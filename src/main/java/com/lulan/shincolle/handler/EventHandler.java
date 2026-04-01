package com.lulan.shincolle.handler;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.client.gui.GuiAppearance;
import com.lulan.shincolle.entity.*;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.intermod.MetamorphHelper;
import com.lulan.shincolle.item.BasicEquip;
import com.lulan.shincolle.network.S2CEntitySync;
import com.lulan.shincolle.network.S2CGUIPackets;
import com.lulan.shincolle.playerskill.ShipSkillHandler;
import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.proxy.ServerProxy;
import com.lulan.shincolle.utility.*;
import com.lulan.shincolle.worldgen.ChestLootTable;
import mchorse.metamorph.api.events.MorphActionEvent;
import mchorse.metamorph.api.events.MorphEvent;
import mchorse.metamorph.api.events.SpawnGhostEvent;
import mchorse.metamorph.api.morphs.EntityMorph;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.*;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.Map;

public class EventHandler {
    private final GuiAppearance guiAppearance = new GuiAppearance();

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onDrop(LivingDropsEvent event) {
        Entity host = event.getEntity();
        if (!(host instanceof IMob || host instanceof EntitySlime || host instanceof EntityGolem) || !host.world.getGameRules().getBoolean("doMobLoot")) {
            return;
        }
        float dropRate = ConfigHandler.dropGrudge;
        int fixedDrop = (int) dropRate;
        if (fixedDrop > 0) {
            event.getDrops().add(new EntityItem(host.world, host.posX, host.posY, host.posZ, new ItemStack(ModItems.Grudge, fixedDrop)));
        }
        if (host.world.rand.nextFloat() < dropRate - fixedDrop) {
            event.getDrops().add(new EntityItem(host.world, host.posX, host.posY, host.posZ, new ItemStack(ModItems.Grudge, 1)));
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onGetBreakSpeed(PlayerEvent.BreakSpeed event) {
        if (ConfigHandler.ringAbility[2] <= 0) return;
        EntityPlayer player = event.getEntityPlayer();
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa != null && capa.hasRing() && capa.isRingActive() && EntityHelper.checkEntityIsInLiquid(player)) {
            int marriageNum = Math.min(capa.getMarriageNum(), ConfigHandler.ringAbility[2]);
            float digBoost = 1.0f + marriageNum * 0.2f;
            event.setNewSpeed(event.getOriginalSpeed() * 5.0f * digBoost);
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onSetLiquidFog(EntityViewRenderEvent.FogDensity event) {
        if (ConfigHandler.ringAbility[3] < 0 || !EntityHelper.checkEntityIsInLiquid(event.getEntity())) return;
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
        if (capa != null && capa.hasRing() && capa.isRingActive()) {
            float density = event.getDensity();
            if (density < 1.0E-4f) return;
            if (ConfigHandler.ringAbility[3] == 0) {
                density = 1.0E-4f;
            } else {
                density *= (float) (ConfigHandler.ringAbility[3] - capa.getMarriageNum()) / (float) ConfigHandler.ringAbility[3];
                if (density < 1.0E-4f) density = 1.0E-4f;
            }
            event.setDensity(density);
            GlStateManager.setFog(GlStateManager.FogMode.EXP);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEntityDeath(LivingDeathEvent event) {
        Entity deadEntity = event.getEntity();
        if (deadEntity == null || deadEntity.world.isRemote) return;
        if (deadEntity instanceof BasicEntityShip) {
            ((BasicEntityShip) deadEntity).updateShipCacheDataWithoutNewID();
            ((BasicEntityShip) deadEntity).applyParticleEmotion(8);
            EntityHelper.applyShipEmotesAOE(deadEntity.world, deadEntity.posX, deadEntity.posY, deadEntity.posZ, 16.0, 6);
        } else if (deadEntity instanceof BasicEntityShipHostile) {
            ((BasicEntityShipHostile) deadEntity).applyParticleEmotion(8);
            EntityHelper.applyShipEmotesAOEHostile(deadEntity.world, deadEntity.posX, deadEntity.posY, deadEntity.posZ, 48.0, 6);
        }
        Entity killer = event.getSource().getTrueSource();
        if (killer instanceof BasicEntityShip) {
            BasicEntityShip ship = (BasicEntityShip) killer;
            ship.addKills();
            ship.addMorale(2);
        } else if (killer instanceof IShipAttackBase) {
            Entity host = ((IShipAttackBase) killer).getHostEntity();
            if (host instanceof BasicEntityShip) {
                ((BasicEntityShip) host).addKills();
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onPlayerClone(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) return;
        CapaTeitoku originalCapa = CapaTeitoku.getTeitokuCapability(event.getOriginal());
        CapaTeitoku newCapa = CapaTeitoku.getTeitokuCapability(event.getEntityPlayer());
        if (originalCapa != null && newCapa != null) {
            newCapa.init(event.getEntityPlayer());
            newCapa.loadNBTData(originalCapa.saveNBTData(new NBTTagCompound()));
            newCapa.sendSyncPacket(0);
            ServerProxy.updatePlayerID(event.getEntityPlayer());
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onWorldLoad(WorldEvent.Load event) {
        if (ServerProxy.initServerFile && event.getWorld() != null && !event.getWorld().isRemote) {
            ServerProxy.initServerProxy(event.getWorld());
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onWorldUnload(WorldEvent.Unload event) {
        if (ServerProxy.saveServerFile && event.getWorld() != null && !event.getWorld().isRemote) {
            ServerProxy.saveServerProxy();
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEntityDamaged(LivingHurtEvent event) {
        if (CommonProxy.activeMetamorph) {
            MetamorphHelper.onMorphDamagedHelper(event);
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEntityAttack(LivingAttackEvent event) {
        Entity target = event.getEntity();
        if (target == null || target.world.isRemote) return;
        if (target instanceof EntityPlayer) {
            if (target.getRidingEntity() instanceof BasicEntityMount && (event.getSource() == DamageSource.FALL || event.getSource() == DamageSource.IN_WALL)) {
                event.setCanceled(true);
                return;
            }
            CapaTeitoku capa = CapaTeitoku.getTeitokuCapability((EntityPlayer) target);
            if (capa != null && capa.hasRing() && capa.isRingActive() && ConfigHandler.ringAbility[4] >= 0 && capa.getMarriageNum() >= ConfigHandler.ringAbility[4] && event.getSource().isFireDamage()) {
                if (target.isBurning()) target.extinguish();
                event.setCanceled(true);
                return;
            }
        }
        Entity attackerSource = event.getSource().getTrueSource();
        if (attackerSource != null) {
            if (attackerSource instanceof EntityPlayer) {
                TargetHelper.setRevengeTargetAroundPlayer((EntityPlayer) attackerSource, 32.0, target);
            }
            if (target instanceof EntityPlayer) {
                Entity attacker = event.getSource().getImmediateSource();
                Entity revengeTarget = target.getDistanceSq(attackerSource) < 1024.0 ? attackerSource : attacker;
                TargetHelper.setRevengeTargetAroundPlayer((EntityPlayer) target, 32.0, revengeTarget);
            } else if (target instanceof BasicEntityShipHostile && !(attackerSource instanceof BasicEntityShipHostile)) {
                Entity attacker = event.getSource().getImmediateSource();
                Entity revengeTarget = target.getDistanceSq(attackerSource) < 1024.0 ? attackerSource : attacker;
                TargetHelper.setRevengeTargetAroundHostileShip((BasicEntityShipHostile) target, 64.0, revengeTarget);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEnteringChunk(EntityEvent.EnteringChunk event) {
        if (event.getEntity() instanceof BasicEntityShip) {
            BasicEntityShip ship = (BasicEntityShip) event.getEntity();
            ship.updateChunkLoader();
            if (MathHelper.floor(ship.posX / 16.0) != event.getNewChunkX() || MathHelper.floor(ship.posZ / 16.0) != event.getNewChunkZ()) {
                ship.isDead = false;
                ship.dismountRidingEntity();
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onChestSpawn(LootTableLoadEvent event) {
        if (event.getName() != null) {
            ChestLootTable.editLoot(event);
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START) return;
        EntityPlayer player = event.player;
        if (player.world.isRemote) {
            handleClientPlayerTick();
        } else {
            handleServerPlayerTick(player);
        }
        if ((player.ticksExisted & 0xF) == 0) {
            updatePlayerRingStatus(player);
        }
        if (CommonProxy.activeMetamorph) {
            MetamorphHelper.onPlayerTickHelper(player);
        }
    }

    private void handleServerPlayerTick(EntityPlayer player) {
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa == null) return;
        if (capa.needInit()) capa.init(player);
        boolean syncTeamList = false;
        if (player.ticksExisted > 0 && (player.ticksExisted & 0x1F) == 0) {
            if (capa.getPlayerUID() < 100) {
                ServerProxy.updatePlayerID(player);
                if (capa.getPlayerUID() < 100) return;
                capa.sendSyncPacket(0);
            }
            if (player.ticksExisted == 64) {
                TeamHelper.updateTeamList(player, capa);
                syncTeamList = true;
            }
            if ((player.ticksExisted & 0x7F) == 0) {
                EntityHelper.spawnMobShip(player, capa);
                capa.sendSyncPacket(8);
                if ((player.ticksExisted & 0xFF) == 0) {
                    TeamHelper.updateTeamList(player, capa);
                    syncTeamList = true;
                }
            }
        }
        EntityHelper.spawnBossShip(player, capa);
        capa.setPlayerTeamCooldown(Math.max(0, capa.getPlayerTeamCooldown() - 1));
        if (!capa.isInitSID() && (player.ticksExisted & 0xF) == 0) {
            capa.updateShipEntityBySID();
            CommonProxy.channelG.sendTo(new S2CGUIPackets((byte) 80, 0, true), (EntityPlayerMP) player);
            syncTeamList = true;
        }
        if (syncTeamList) {
            capa.sendSyncPacket(0);
        }
    }

    @SideOnly(Side.CLIENT)
    private void handleClientPlayerTick() {
        if (ClientProxy.keyMountActionCD > 0) --ClientProxy.keyMountActionCD;
        if (ClientProxy.keyPlayerSkillCD > 0) --ClientProxy.keyPlayerSkillCD;
        if (ClientProxy.debugCooldown > 0) --ClientProxy.debugCooldown;

        EntityPlayer player = ClientProxy.getClientPlayer();
        if (player != null) {
            ShipSkillHandler.handleShipSkillKeys(ShipSkillHandler.getShipSkillHostType(player));
        }
    }

    private void updatePlayerRingStatus(EntityPlayer player) {
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa == null) return;
        ItemStack ringStack = null;
        for (ItemStack itemStack : player.inventory.mainInventory) {
            if (!itemStack.isEmpty() && itemStack.getItem() == ModItems.MarriageRing) {
                ringStack = itemStack;
                break;
            }
        }
        boolean hasRing = ringStack != null;
        if (!hasRing && Loader.isModLoaded("Baubles")) {
            hasRing = InventoryHelper.checkRingInBaubles(player);
        }
        if (capa.hasRing() && !hasRing) {
            player.capabilities.isFlying = false;
        }
        capa.setHasRing(hasRing);
        if (ringStack != null && ringStack.hasTagCompound()) {
            capa.setRingActive(ringStack.getTagCompound().getBoolean("isActive"));
        } else {
            capa.setRingActive(false);
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        EntityPlayer player = ClientProxy.getClientPlayer();
        if (player == null) return;
        TargetHelper.handleOPToolKeyInput();
        EntityHelper.handlePointerKeyInput();
        if (ConfigHandler.debugMode) {
            handleDebugKeys(player);
        }
    }

    @SideOnly(Side.CLIENT)
    private void handleDebugKeys(EntityPlayer player) {
        if (ClientProxy.debugCooldown > 0) return;
        float amount = Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL) ? 0.1f : 0.01f;
        boolean isAlt = Keyboard.isKeyDown(Keyboard.KEY_LMENU) || Keyboard.isKeyDown(Keyboard.KEY_RMENU);
        if (Keyboard.isKeyDown(Keyboard.KEY_K)) updateDebugValue(player, isAlt ? 4 : 1, amount);
        else if (Keyboard.isKeyDown(Keyboard.KEY_O)) updateDebugValue(player, isAlt ? 4 : 1, -amount);
        else if (Keyboard.isKeyDown(Keyboard.KEY_L)) updateDebugValue(player, isAlt ? 5 : 2, amount);
        else if (Keyboard.isKeyDown(Keyboard.KEY_P)) updateDebugValue(player, isAlt ? 5 : 2, -amount);
        else if (Keyboard.isKeyDown(Keyboard.KEY_M)) updateDebugValue(player, isAlt ? 6 : 3, amount);
        else if (Keyboard.isKeyDown(Keyboard.KEY_I)) updateDebugValue(player, isAlt ? 6 : 3, -amount);
    }

    @SideOnly(Side.CLIENT)
    private void updateDebugValue(EntityPlayer player, int field, float amount) {
        ClientProxy.debugCooldown = 2;
        float newValue;
        String fieldName;
        switch (field) {
            case 1: newValue = ClientProxy.field1 += amount; fieldName = "f1"; break;
            case 2: newValue = ClientProxy.field2 += amount; fieldName = "f2"; break;
            case 3: newValue = ClientProxy.field3 += amount; fieldName = "f3"; break;
            case 4: newValue = ClientProxy.field4 += amount; fieldName = "f4"; break;
            case 5: newValue = ClientProxy.field5 += amount; fieldName = "f5"; break;
            case 6: newValue = ClientProxy.field6 += amount; fieldName = "f6"; break;
            default: return;
        }
        player.sendMessage(new TextComponentString(String.format("%s %.2f", fieldName, newValue)));
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onPlayerSave(PlayerEvent.SaveToFile event) {
        if (event.getEntityPlayer() != null && CommonProxy.activeMetamorph && ConfigHandler.enableMetamorphSkill) {
            MetamorphHelper.writeToNBT(event.getEntityPlayer());
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onPlayerLoggedOut(PlayerLoggedOutEvent event) {
        if (event.player != null && CommonProxy.activeMetamorph && ConfigHandler.enableMetamorphSkill) {
            MetamorphHelper.writeToNBT(event.player);
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
        if (event.player instanceof EntityPlayerMP) {
            CommonProxy.channelE.sendTo(new S2CEntitySync(null, (byte) 81), (EntityPlayerMP) event.player);
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onPlayerChangeDim(PlayerChangedDimensionEvent event) {
        if (event.player != null && !event.player.world.isRemote) {
            ServerProxy.updatePlayerID(event.player);
            CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(event.player);
            if(capa != null) capa.sendSyncPacket(0);
            if (CommonProxy.activeMetamorph) {
                MetamorphHelper.onPlayerChangeDimHelper(event.player);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onRenderHand(RenderSpecificHandEvent event) {
        if (event.getHand() == EnumHand.MAIN_HAND && event.getItemStack().getItem() == ModItems.PointerItem && event.getItemStack().getMetadata() > 2) {
            event.setCanceled(true);
            RenderHelper.renderItemInFirstPerson((AbstractClientPlayer) ClientProxy.getClientPlayer(), event.getPartialTicks(), event.getItemStack());
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onRenderTick(TickEvent.RenderTickEvent event) {
        EntityPlayer player = ClientProxy.getClientPlayer();
        if (player == null) return;
        if (event.phase == TickEvent.Phase.START) {
            if (player.getRidingEntity() instanceof BasicEntityMount) {
                BasicEntityMount mount = (BasicEntityMount) player.getRidingEntity();
                if (mount.host != null && !ClientProxy.isViewChanged && !ClientProxy.isViewPlayer) {
                    ClientProxy.getMineraft().setRenderViewEntity(mount.host);
                    ClientProxy.isViewChanged = true;
                }
                Entity camera = ClientProxy.getMineraft().getRenderViewEntity();
                if (ClientProxy.isViewChanged && camera instanceof EntityLivingBase) {
                    camera.rotationPitch = player.rotationPitch;
                    camera.rotationYaw = player.rotationYaw;
                    camera.prevRotationPitch = player.prevRotationPitch;
                    camera.prevRotationYaw = player.prevRotationYaw;
                    ((EntityLivingBase) camera).renderYawOffset = player.renderYawOffset;
                    ((EntityLivingBase) camera).rotationYawHead = player.rotationYawHead;
                    ((EntityLivingBase) camera).prevCameraPitch = player.prevCameraPitch;
                    ((EntityLivingBase) camera).prevRenderYawOffset = player.prevRenderYawOffset;
                    ((EntityLivingBase) camera).prevRotationYawHead = player.prevRotationYawHead;
                }
            }
        } else if (event.phase == TickEvent.Phase.END && ClientProxy.isViewChanged) {
            ClientProxy.getMineraft().setRenderViewEntity(player);
            ClientProxy.isViewChanged = false;
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            ServerProxy.updateServerTick();
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack equip = event.getLeft();
        ItemStack book = event.getRight();
        if (equip.isEmpty() || !(equip.getItem() instanceof BasicEquip) || book.isEmpty() || book.getItem() != Items.ENCHANTED_BOOK) {
            return;
        }
        ItemStack newEquip = equip.copy();
        Map<Enchantment, Integer> equipEnchants = EnchantmentHelper.getEnchantments(newEquip);
        Map<Enchantment, Integer> bookEnchants = EnchantmentHelper.getEnchantments(book);
        bookEnchants.forEach((ench, bookLevel) -> {
            if (ench != null) {
                int currentLevel = equipEnchants.getOrDefault(ench, 0);
                int newLevel = (currentLevel == bookLevel) ? currentLevel + 1 : Math.max(currentLevel, bookLevel);
                newLevel = Math.min(newLevel, ench.getMaxLevel());
                equipEnchants.put(ench, newLevel);
            }
        });
        EnchantmentHelper.setEnchantments(equipEnchants, newEquip);
        event.setOutput(newEquip);
        event.setCost(30);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onRenderGameOverlay(RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            RenderHelper.drawPlayerSkillIcon();
        }
    }

    @Optional.Method(modid = "metamorph")
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onMorphPre(MorphEvent.Pre event) {
        if (event.player == null) return;
        BasicEntityShip ship = MetamorphHelper.getShipMorphEntity(event.player);
        if (ship != null) {
            CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(event.player);
            if (capa != null) capa.setMorphEntity(null);
            MetamorphHelper.writeToNBT(event.player);
            event.player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
        }
        if (event.morph instanceof EntityMorph) {
            EntityMorph em = (EntityMorph) event.morph;
            EntityLivingBase target = em.getEntity(event.player.world);
            if (target instanceof IShipMorph) {
                NBTTagCompound nbtAll = em.getEntityData();
                if (nbtAll == null) {
                    nbtAll = target.serializeNBT();
                    em.setEntityData(nbtAll);
                }
                NBTTagCompound shipExtProps = nbtAll.getCompoundTag("ShipExtProps");
                NBTTagCompound shipFlags = shipExtProps.getCompoundTag("ShipFlags");
                shipFlags.setBoolean("IsMorph", true);
                shipExtProps.setTag("ShipFlags", shipFlags);
                nbtAll.setTag("ShipExtProps", shipExtProps);
            }
        }
    }

    @Optional.Method(modid = "metamorph")
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onMorphPost(MorphEvent.Post event) {
        if (event.player == null) return;
        if (event.isDemorphing()) {
            event.player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
            return;
        }
        if (event.morph instanceof EntityMorph) {
            EntityLivingBase target = ((EntityMorph) event.morph).getEntity(event.player.world);
            if (target instanceof BasicEntityShip) {
                BasicEntityShip ship = (BasicEntityShip) target;
                ship.setIsMorph(true);
                ship.setMorphHost(event.player);
                ship.setStateFlag(2, false);
                ship.setStateFlag(11, true);
                ship.setStateFlag(10, false);
            } else if (target instanceof BasicEntityShipHostile) {
                BasicEntityShipHostile ship = (BasicEntityShipHostile) target;
                ship.setIsMorph(true);
                ship.setMorphHost(event.player);
                ship.canDrop = false;
            }
        }
    }

    @Optional.Method(modid = "metamorph")
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onSpawnMorphPre(SpawnGhostEvent.Pre event) {
        if (event.player == null || !(event.morph instanceof EntityMorph)) return;
        EntityMorph em = (EntityMorph) event.morph;
        EntityLivingBase target = em.getEntity(event.player.world);
        if (target instanceof BasicEntityShip) {
            event.morph = null;
            return;
        }
        if (target instanceof IShipAttackBase) {
            NBTTagCompound nbtAll = em.getEntityData();
            if (nbtAll == null) return;
            nbtAll.removeTag("CpInv");
            NBTTagList tagList = nbtAll.getTagList("Attributes", 10);
            for (int i = 0; i < tagList.tagCount(); ++i) {
                NBTTagCompound tags = tagList.getCompoundTagAt(i);
                if ("generic.maxHealth".equals(tags.getString("Name"))) {
                    tags.setDouble("Base", 20.0);
                    break;
                }
            }
        }
    }

    @Optional.Method(modid = "metamorph")
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onMorphAction(MorphActionEvent event) {
        if (event.player != null && event.morph instanceof EntityMorph) {
            EntityLivingBase target = ((EntityMorph) event.morph).getEntity(event.player.world);
            if (target instanceof IShipMorph) {
                MetamorphHelper.onMorphActionHelper(event);
            }
        }
    }

    @SubscribeEvent
    public void onGuiDraw(GuiScreenEvent.DrawScreenEvent.Post event) {
        if (!(event.getGui() instanceof GuiInventory)) {
            return;
        }
        GuiInventory gui = (GuiInventory) event.getGui();
        EntityPlayer player = Minecraft.getMinecraft().player;
        if (player == null) return;
        this.guiAppearance.draw(gui, player);
    }

    @SubscribeEvent
    public void onGuiMouseClicked(GuiScreenEvent.MouseInputEvent.Post event) {
        if (!(event.getGui() instanceof GuiInventory)) {
            return;
        }
        GuiInventory gui = (GuiInventory) event.getGui();
        EntityPlayer player = Minecraft.getMinecraft().player;
        if (player == null) return;
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution sr = new ScaledResolution(mc);
        int mouseX = Mouse.getEventX() * sr.getScaledWidth()  / mc.displayWidth;
        int mouseY = sr.getScaledHeight() - Mouse.getEventY() * sr.getScaledHeight() / mc.displayHeight - 1;
        this.guiAppearance.mouseClicked(gui, mouseX, mouseY, Mouse.getEventButton(), player);
    }
}