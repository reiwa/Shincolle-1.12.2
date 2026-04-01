package com.lulan.shincolle.intermod;

import com.lulan.shincolle.ShinColle;
import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.*;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModBlocks;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.network.S2CGUIPackets;
import com.lulan.shincolle.network.S2CSpawnParticle;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.utility.*;
import mchorse.metamorph.api.EntityUtils;
import mchorse.metamorph.api.MorphAPI;
import mchorse.metamorph.api.MorphManager;
import mchorse.metamorph.api.events.MorphActionEvent;
import mchorse.metamorph.api.morphs.AbstractMorph;
import mchorse.metamorph.api.morphs.EntityMorph;
import mchorse.metamorph.capabilities.morphing.IMorphing;
import mchorse.metamorph.capabilities.morphing.Morphing;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class MetamorphHelper {
    private MetamorphHelper() {}

    public static BasicEntityShip getShipMorphEntity(EntityPlayer player) {
        EntityMorph em;
        if (player == null) {
            return null;
        }
        IMorphing im = Morphing.get(player);
        if (im != null && im.getCurrentMorph() instanceof EntityMorph && (em = (EntityMorph)im.getCurrentMorph()) != null && em.getEntity() instanceof BasicEntityShip) {
            return (BasicEntityShip)em.getEntity();
        }
        return null;
    }

    public static Entity getMorphEntityByPlayerEID(int entityID, int worldID, boolean isClient) {
        BasicEntityShip morph;
        Entity ent = EntityHelper.getEntityByID(entityID, worldID, isClient);
        if (CommonProxy.activeMetamorph && ent instanceof EntityPlayer && (morph = MetamorphHelper.getShipMorphEntity((EntityPlayer)ent)) != null) {
            return morph;
        }
        return ent;
    }

    public static void demorphPlayer(EntityPlayer player) {
        if (player == null) {
            return;
        }
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa == null) {
            return;
        }
        capa.setMorphEntity(null);
        MetamorphHelper.writeToNBT(player);
        player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
        MorphAPI.demorph(player);
    }

    public static void onPlayerChangeDimHelper(EntityPlayer player) {
        IMorphing im = Morphing.get(player);
        if (im != null && im.isMorphed()) {
            MetamorphHelper.demorphPlayer(player);
        }
    }

    public static void onPlayerTickHelper(EntityPlayer player) {
        if (player == null || (player.ticksExisted & 0x1F) != 0) {
            return;
        }
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa == null) {
            return;
        }
        IMorphing im = Morphing.get(player);
        if (im != null && im.getCurrentMorph() instanceof EntityMorph) {
            EntityMorph em = (EntityMorph)im.getCurrentMorph();
            if (em != null && em.getEntity() instanceof IShipMorph) {
                AbstractMorph morph = Morphing.get(player).getCurrentMorph();
                EntityLivingBase target = ((EntityMorph) morph).getEntity(player.world);
                if(target instanceof BasicEntityShip){
                    morph.settings.health = (int)(20.0 + ((BasicEntityShip) target).getAttrs().getAttrsBuffed(0) * ConfigHandler.morphHPRatio);
                } else if(target instanceof BasicEntityShipHostile) {
                    morph.settings.health = 20;
                }
                if (!player.world.isRemote && player.ticksExisted == 32) {
                    MetamorphHelper.demorphPlayer(player);
                    return;
                }
                if (capa.getMorphEntity() != null && !capa.getMorphEntity().equals(em.getEntity())) {
                    capa.getMorphEntity().setDead();
                    capa.setMorphEntity(em.getEntity());
                    IShipMorph ism = (IShipMorph)em.getEntity();
                    ism.setIsMorph(true);
                    ism.setMorphHost(player);
                } else if (capa.getMorphEntity() == null) {
                    capa.setMorphEntity(em.getEntity());
                    IShipMorph ism = (IShipMorph)em.getEntity();
                    ism.setIsMorph(true);
                    ism.setMorphHost(player);
                }
            }
        } else {
            capa.setMorphEntity(null);
        }
    }

    public static void onMorphDamagedHelper(LivingHurtEvent event) {
        if (!(event.getEntityLiving() instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer player = (EntityPlayer)event.getEntityLiving();
        if (player.world == null || player.world.isRemote) {
            return;
        }
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa == null || !(capa.getMorphEntity() instanceof BasicEntityShip)) {
            return;
        }
        BasicEntityShip ship = (BasicEntityShip)capa.getMorphEntity();
        float atk = event.getAmount();
        if (event.getSource() == DamageSource.IN_WALL || event.getSource() == DamageSource.CACTUS || event.getSource() == DamageSource.FALL) {
            event.setAmount(0.0f);
            return;
        }
        if (event.getSource() == DamageSource.MAGIC || event.getSource() == DamageSource.DRAGON_BREATH || event.getSource() == DamageSource.OUT_OF_WORLD) {
            ship.setStateEmotion(1, 3, true);
            return;
        }
        float patk = BuffHelper.getPotionDamage(ship, event.getSource(), atk);
        if (patk > 0.0f) {
            ship.setStateEmotion(1, 3, true);
            event.setAmount((float)(patk * ConfigHandler.morphHPRatio));
            return;
        }
        if (event.getSource().getTrueSource() != null) {
            Entity attacker = event.getSource().getTrueSource();
            if (attacker.equals(player)) {
                event.setAmount(0.0f);
                return;
            }
            if (attacker instanceof EntityPlayer && !ConfigHandler.friendlyFire) {
                event.setAmount(0.0f);
                return;
            }
            float dist = (float)player.getDistanceSq(attacker);
            if (CombatHelper.canDodge(ship, dist)) {
                event.setCanceled(true);
                return;
            }
            float reducedAtk = atk;
            reducedAtk = CombatHelper.applyDamageReduceByDEF(ship.getAttrs(), reducedAtk);
            if (attacker instanceof IShipAttackBase) {
                reducedAtk = (float)(reducedAtk * ConfigHandler.morphDmgTakenRatio);
            }
            reducedAtk = BuffHelper.applyBuffOnDamageByResist(ship, event.getSource(), reducedAtk);
            reducedAtk = BuffHelper.applyBuffOnDamageByLight(ship, event.getSource(), reducedAtk);
            if (reducedAtk < 1.0f && reducedAtk > 0.0f) {
                reducedAtk = 1.0f;
            } else if (reducedAtk <= 0.0f) {
                reducedAtk = 0.0f;
            }
            if (reducedAtk >= player.getHealth() - 1.0f && MetamorphHelper.decrSupplies(player.inventory, 8)) {
                player.setHealth(player.getMaxHealth());
                player.hurtResistantTime = 120;
                ship.setStateTimer(2, 120);
                NetworkRegistry.TargetPoint point = new NetworkRegistry.TargetPoint(player.dimension, player.posX, player.posY, player.posZ, 64.0);
                CommonProxy.channelP.sendToAllAround(new S2CSpawnParticle(player, 13, 0.0, 0.03, 0.0), point);
                event.setAmount(0.0f);
                return;
            }
            ship.setStateEmotion(1, 3, true);
            event.setAmount(reducedAtk);
        }
    }

    public static void onMorphActionHelper(MorphActionEvent event) {
        if (!event.player.world.isRemote) {
            CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(event.player);
            if (ConfigHandler.enableMetamorphSkill) {
                if (event.player.isSneaking()) {
                    CommonProxy.channelG.sendTo(new S2CGUIPackets((byte)81, 0, true), (EntityPlayerMP)event.player);
                    return;
                }
                MetamorphHelper.openMorphGui(capa);
                return;
            }
            MetamorphHelper.openMorphGui(capa);
        }
    }

    public static void openMorphGui(CapaTeitoku capa) {
        if (capa != null && capa.getPlayer() != null && !capa.getPlayer().world.isRemote && capa.getMorphEntity() instanceof BasicEntityShip) {
            FMLNetworkHandler.openGui(capa.getPlayer(), ShinColle.instance, 9, capa.getPlayer().world, 0, 0, 0);
        }
    }

    public static void acquireShipMorph(EntityPlayer player, Entity target) {
        if (player == null) {
            return;
        }
        if (!player.world.isRemote && target instanceof BasicEntityShip) {
            NBTTagCompound shipMinor;
            BasicEntityShip ship = (BasicEntityShip)target;
            if (!TeamHelper.checkSameOwner(player, ship)) {
                return;
            }
            String name = MorphManager.INSTANCE.morphNameFromEntity(target);
            if (!MorphManager.INSTANCE.hasMorph(name)) {
                return;
            }
            NBTTagCompound tag = new NBTTagCompound();
            NBTTagCompound tagData = EntityUtils.stripEntityNBT(target.serializeNBT());
            if (tagData == null) {
                return;
            }
            NBTTagList tagList = tagData.getTagList("Attributes", 10);
            if (tagList == null) {
                return;
            }
            for (int i = 0; i < tagList.tagCount(); ++i) {
                NBTTagCompound tags = tagList.getCompoundTagAt(i);
                String attrs = tags.getString("Name");
                if (!"generic.maxHealth".equals(attrs)) continue;
                tags.setDouble("Base", 20.0);
            }
            tagData.removeTag("CpInv");
            NBTTagCompound shipData = (NBTTagCompound)tagData.getTag("ShipExtProps");
            if (shipData == null) {
                shipData = new NBTTagCompound();
                tagData.setTag("ShipExtProps", shipData);
            }
            if ((shipMinor = (NBTTagCompound)shipData.getTag("Minor")) == null) {
                shipMinor = new NBTTagCompound();
                shipData.setTag("Minor", shipMinor);
            }
            shipMinor.setInteger("PlayerUID", EntityHelper.getPlayerUID(player));
            int sid = shipMinor.getInteger("ShipUID");
            shipMinor.setInteger("ShipUID", sid + EntityHelper.getPlayerUID(player) * 1000);
            shipMinor.setInteger("Level", 1);
            shipMinor.setInteger("Exp", 0);
            shipMinor.setInteger("Crane", 0);
            shipMinor.setInteger("Task", 0);
            shipMinor.setInteger("Kills", 0);
            shipMinor.setInteger("NumAmmoL", 0);
            shipMinor.setInteger("NumAmmoH", 0);
            shipMinor.setInteger("NumGrudge", 0);
            NBTTagCompound shipFlag = (NBTTagCompound)shipData.getTag("ShipFlags");
            if (shipFlag == null) {
                shipFlag = new NBTTagCompound();
                shipData.setTag("ShipFlags", shipFlag);
            }
            shipFlag.setBoolean("IsMorph", true);
            shipFlag.setBoolean("NoFuel", false);
            shipFlag.setBoolean("CanDrop", false);
            shipFlag.setBoolean("CanFollow", true);
            shipFlag.setBoolean("IsMarried", true);
            shipFlag.setBoolean("OnSight", true);
            shipFlag.setBoolean("TimeKeeper", false);
            shipFlag.setBoolean("AutoPump", false);
            shipFlag.setBoolean("PVPFirst", true);
            shipFlag.setBoolean("AA", true);
            shipFlag.setBoolean("ASM", true);
            shipFlag.setBoolean("PassiveAI", false);
            NBTTagCompound shipPoint = (NBTTagCompound)shipData.getTag("Point");
            if (shipPoint == null) {
                shipPoint = new NBTTagCompound();
                shipData.setTag("Point", shipPoint);
            }
            shipPoint.setByte("HP", (byte)0);
            shipPoint.setByte("ATK", (byte)0);
            shipPoint.setByte("DEF", (byte)0);
            shipPoint.setByte("SPD", (byte)0);
            shipPoint.setByte("MOV", (byte)0);
            shipPoint.setByte("HIT", (byte)0);
            tag.setString("Name", name);
            tag.setTag("EntityData", tagData);
            AbstractMorph morph = MorphManager.INSTANCE.morphFromNBT(tag);
            MorphAPI.acquire(player, morph);
        }
    }

    public static void handlePlayerSkillOfMorph(EntityPlayer player, int[] data) {
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa == null || !(capa.getMorphEntity() instanceof BasicEntityShip)) {
            return;
        }
        BasicEntityShip ship = (BasicEntityShip)capa.getMorphEntity();
        int skill;
        switch (data[0]) {
            case 0: {
                if (!ship.getStateFlag(13)) {
                    return;
                }
                skill = 16;
                break;
            }
            case 1: {
                if (!ship.getStateFlag(14)) {
                    return;
                }
                skill = 17;
                break;
            }
            case 2: {
                if (!ship.getStateFlag(15)) {
                    return;
                }
                skill = 18;
                break;
            }
            case 3: {
                if (!ship.getStateFlag(16)) {
                    return;
                }
                skill = 19;
                break;
            }
            case 4: {
                skill = 20;
                break;
            }
            default: {
                return;
            }
        }
        if (ship.getStateTimer(skill) > 0) {
            return;
        }
        Entity target = null;
        BlockPos targetPos = null;
        float rangeSq = ship.getAttrs().getAttackRange() * ship.getAttrs().getAttackRange();
        if (data[2] < 0) {
            target = EntityHelper.getEntityByID(data[1], player.world.provider.getDimension(), false);
            if (target != null) {
                if (data[0] == 4) {
                    if (ship.getDistanceSq(target) > 6.0) {
                        target = null;
                    }
                } else if (ship.getDistanceSq(target) > rangeSq) {
                    target = null;
                }
            }
        } else {
            targetPos = new BlockPos(data[1], data[2], data[3]);
            if (ship.getDistanceSqToCenter(targetPos) > rangeSq) {
                targetPos = null;
            }
        }
        if (target == null && targetPos == null) {
            return;
        }
        if (target != null && TeamHelper.checkSameOwner(ship, target)) {
            return;
        }
        switch (data[0]) {
            case 0: {
                if (target == null) break;
                ship.attackEntityWithAmmo(target);
                ship.setStateTimer(16, CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 1));
                ship.sendSyncPacketTimer(1);
                break;
            }
            case 1: {
                if (target != null) {
                    ship.attackEntityWithHeavyAmmo(target);
                } else {
                    ship.attackEntityWithHeavyAmmo(targetPos);
                }
                ship.setStateTimer(17, CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 2));
                ship.sendSyncPacketTimer(1);
                break;
            }
            case 2: {
                if (!(ship instanceof BasicEntityShipCV) || target == null) break;
                ((BasicEntityShipCV)ship).attackEntityWithAircraft(target);
                ship.setStateTimer(18, CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 3));
                ship.setStateTimer(19, CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 3));
                ship.sendSyncPacketTimer(1);
                break;
            }
            case 3: {
                if (!(ship instanceof BasicEntityShipCV) || target == null) break;
                ((BasicEntityShipCV)ship).attackEntityWithHeavyAircraft(target);
                ship.setStateTimer(18, CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 4));
                ship.setStateTimer(19, CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 4));
                ship.sendSyncPacketTimer(1);
                break;
            }
            case 4: {
                if (target == null) break;
                ship.attackEntityAsMob(target);
                ship.setStateTimer(20, CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 0));
                ship.sendSyncPacketTimer(1);
                break;
            }
            default:
        }
    }

    public static boolean decrAmmoNum(BasicEntityShip morph, int type, int amount) {
        int ammoType = type == 1 ? 5 : 4;
        int remain = morph.getStateMinor(ammoType) - amount;
        if (remain < 0) {
            return false;
        }
        morph.setStateMinor(ammoType, remain);
        return true;
    }

    public static void decrGrudgeNum(BasicEntityShip morph, int value) {
        float modGrudge = morph.getAttrs().getAttrsBuffed(17);
        if (value > 0) {
            int level = BuffHelper.getPotionLevel(morph, 17);
            value *= 1 + level;
        } else if (value < 0) {
            value = (int)(value * modGrudge);
        }
        morph.addGrudge(-value);
    }

    public static void handleGUIPacketInput(CapaTeitoku capa, int button) {
        if (capa == null || capa.getMorphEntity() == null || capa.getPlayer() == null) {
            return;
        }
        BasicEntityShip ship = null;
        if (capa.getMorphEntity() instanceof BasicEntityShip) {
            ship = (BasicEntityShip)capa.getMorphEntity();
        }
        switch (button) {
            case 0: {
                if (ship == null || ship.getStateMinor(4) >= 30000) break;
                MetamorphHelper.consumeSupplyItems(capa.getPlayer().inventory, ship, 1);
                break;
            }
            case 1: {
                if (ship == null || ship.getStateMinor(5) >= 30000) break;
                MetamorphHelper.consumeSupplyItems(capa.getPlayer().inventory, ship, 2);
                break;
            }
            case 2: {
                if (ship == null || ship.getStateMinor(6) >= 30000) break;
                MetamorphHelper.consumeSupplyItems(capa.getPlayer().inventory, ship, 0);
                break;
            }
            default:
        }
    }

    private static void consumeSupplyItems(IInventory inv, BasicEntityShip ship, int type) {
        int itemType = -1;
        float addValue = 0.0f;
        switch (type) {
            case 0: {
                if (MetamorphHelper.decrSupplies(inv, 4)) {
                    itemType = 0;
                    addValue = 300.0f;
                    break;
                }
                if (!MetamorphHelper.decrSupplies(inv, 5)) break;
                itemType = 0;
                addValue = 2700.0f;
                break;
            }
            case 1: {
                if (MetamorphHelper.decrSupplies(inv, 0)) {
                    itemType = 1;
                    addValue = 30.0f;
                    break;
                }
                if (!MetamorphHelper.decrSupplies(inv, 2)) break;
                itemType = 1;
                addValue = 270.0f;
                break;
            }
            case 2: {
                if (MetamorphHelper.decrSupplies(inv, 1)) {
                    itemType = 2;
                    addValue = 15.0f;
                    break;
                }
                if (!MetamorphHelper.decrSupplies(inv, 3)) break;
                itemType = 2;
                addValue = 135.0f;
                break;
            }
            default:
        }
        if (ConfigHandler.consumptionLevel == 0) {
            addValue *= 10.0f;
        }
        switch (itemType) {
            case 0: {
                ship.addGrudge((int)(addValue * ship.getAttrs().getAttrsBuffed(17)));
                break;
            }
            case 1: {
                ship.addAmmoLight((int)(addValue * ship.getAttrs().getAttrsBuffed(18)));
                break;
            }
            case 2: {
                ship.addAmmoHeavy((int)(addValue * ship.getAttrs().getAttrsBuffed(18)));
                break;
            }
            default:
        }
    }

    private static boolean decrSupplies(IInventory inv, int type) {
        ItemStack itemType = ItemStack.EMPTY;
        switch (type) {
            case 0: {
                itemType = new ItemStack(ModItems.Ammo, 1, 0);
                break;
            }
            case 1: {
                itemType = new ItemStack(ModItems.Ammo, 1, 2);
                break;
            }
            case 2: {
                itemType = new ItemStack(ModItems.Ammo, 1, 1);
                break;
            }
            case 3: {
                itemType = new ItemStack(ModItems.Ammo, 1, 3);
                break;
            }
            case 4: {
                itemType = new ItemStack(ModItems.Grudge, 1);
                break;
            }
            case 5: {
                itemType = new ItemStack(ModBlocks.BlockGrudge, 1);
                break;
            }
            case 6: {
                itemType = new ItemStack(ModBlocks.BlockGrudgeHeavy, 1);
                break;
            }
            case 7: {
                itemType = new ItemStack(ModItems.BucketRepair, 1);
                break;
            }
            case 8: {
                itemType = new ItemStack(ModItems.RepairGoddess, 1);
                break;
            }
            default:
        }
        ItemStack itemGet = InventoryHelper.getAndRemoveItem(inv, itemType, 1, true, false, false, null);
        return !itemGet.isEmpty();
    }

    public static void writeToNBT(EntityPlayer player) {
        if (player == null) {
            return;
        }
        IMorphing im = Morphing.get(player);
        if (im != null) {
            AbstractMorph am = im.getCurrentMorph();
            BasicEntityShip morph = null;
            if (am instanceof EntityMorph && ((EntityMorph)am).getEntity() instanceof BasicEntityShip) {
                LogHelper.info("INFO: save morph ship data from current morph.");
                morph = (BasicEntityShip)((EntityMorph)am).getEntity();
            }
            if (morph != null) {
                NBTTagCompound shipMinor;
                NBTTagCompound shipData;
                NBTTagCompound tagData = ((EntityMorph)am).getEntityData();
                if (tagData == null) {
                    tagData = morph.serializeNBT();
                    ((EntityMorph)am).setEntityData(tagData);
                }
                if ((shipData = (NBTTagCompound)tagData.getTag("ShipExtProps")) == null) {
                    shipData = new NBTTagCompound();
                    tagData.setTag("ShipExtProps", shipData);
                }
                if ((shipMinor = (NBTTagCompound)shipData.getTag("Minor")) == null) {
                    shipMinor = new NBTTagCompound();
                    shipData.setTag("Minor", shipMinor);
                }
                LogHelper.info("INFO: save morph ship data: LV " + morph.getLevel() + " EXP " + morph.getStateMinor(2));
                shipMinor.setInteger("Level", morph.getLevel());
                shipMinor.setInteger("Exp", morph.getStateMinor(2));
                shipMinor.setInteger("Kills", morph.getStateMinor(1));
                shipMinor.setInteger("NumAmmoL", morph.getStateMinor(4));
                shipMinor.setInteger("NumAmmoH", morph.getStateMinor(5));
                shipMinor.setInteger("NumGrudge", morph.getStateMinor(6));
                NBTTagCompound shipPoint = (NBTTagCompound)shipData.getTag("Point");
                if (shipPoint == null) {
                    shipPoint = new NBTTagCompound();
                    shipData.setTag("Point", shipPoint);
                }
                shipPoint.setByte("HP", morph.getAttrs().getAttrsBonus(0));
                shipPoint.setByte("ATK", morph.getAttrs().getAttrsBonus(1));
                shipPoint.setByte("DEF", morph.getAttrs().getAttrsBonus(2));
                shipPoint.setByte("SPD", morph.getAttrs().getAttrsBonus(3));
                shipPoint.setByte("MOV", morph.getAttrs().getAttrsBonus(4));
                shipPoint.setByte("HIT", morph.getAttrs().getAttrsBonus(5));
                NBTTagCompound shipFlag = (NBTTagCompound)shipData.getTag("ShipFlags");
                if (shipFlag == null) {
                    shipFlag = new NBTTagCompound();
                    shipData.setTag("ShipFlags", shipFlag);
                }
                shipFlag.setBoolean("NoFuel", morph.getStateFlag(2));
                shipFlag.setBoolean("WedEffect", morph.getStateFlag(9));
            }
        }
    }
}
