package com.lulan.shincolle.item;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.network.C2SGUIPackets;
import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.tileentity.ITileGuardPoint;
import com.lulan.shincolle.utility.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class PointerItem extends BasicItem {
    private static final String NAME = "PointerItem";
    private boolean formatFlag = false;
    private int formatAddID = 0;
    private int formatCD = 0;
    private int coolDown = -1;

    public PointerItem() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
        this.setFull3D();
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return String.format("item.%s", this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelResourceLocation[] models = new ModelResourceLocation[4];
        for (int i = 0; i < models.length; ++i) {
            models[i] = new ModelResourceLocation(this.getRegistryName() + String.valueOf(i), "inventory");
        }
        ModelBakery.registerItemVariants(this, models);
        for (int i = 0; i < 4; ++i) {
            ModelLoader.setCustomModelResourceLocation(this, i, models[i]);
        }
        ModelLoader.setCustomModelResourceLocation(this, 4, models[3]);
        ModelLoader.setCustomModelResourceLocation(this, 5, models[3]);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack item) {
        return true;
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entity, ItemStack stack) {
        if (!(entity instanceof EntityPlayer) || !entity.world.isRemote) {
            return true;
        }
        EntityPlayer player = (EntityPlayer) entity;
        ArrayList<Entity> excludeList = new ArrayList<>();
        excludeList.add(player);
        if (player.isRiding()) {
            excludeList.add(player.getRidingEntity());
            if (player.getRidingEntity() instanceof BasicEntityMount) {
                excludeList.add(((BasicEntityMount) player.getRidingEntity()).getHostEntity());
            }
        }
        RayTraceResult hitResult = EntityHelper.getPlayerMouseOverEntity(64.0, 1.0f, excludeList, true, false);
        if (hitResult != null && hitResult.entityHit != null) {
            return handleSwingOnEntity(player, stack, hitResult.entityHit);
        }
        return handleSwingOnMiss(player, stack);
    }

    private boolean handleSwingOnEntity(EntityPlayer player, ItemStack stack, Entity hitEntity) {
        BasicEntityShip ship = EntityHelper.getShipFromHost(hitEntity);
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (ship != null && capa != null && TeamHelper.checkSameOwner(player, ship)) {
            int teamIndex = capa.checkIsInCurrentTeam(ship.getShipUID());
            if (ClientProxy.getGameSetting().keyBindSneak.isKeyDown()) {
                if (teamIndex >= 0) {
                    if (stack.getMetadata() == 0) {
                        for (int i = 0; i < 6; ++i) {
                            BasicEntityShip teamShip = capa.getShipEntityCurrentTeam(i);
                            if (i != teamIndex && teamShip != null) {
                                CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 29, stack.getMetadata(), teamShip.getShipUID()));
                                break;
                            }
                        }
                    }
                    CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 20, ship.getEntityId()));
                }
            } else {
                if (teamIndex >= 0) {
                    CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 29, stack.getMetadata(), ship.getShipUID()));
                } else {
                    CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 20, ship.getEntityId()));
                    if (stack.getMetadata() == 0) {
                        CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 29, stack.getMetadata(), ship.getShipUID()));
                    }
                }
            }
        } else {
            String targetName = hitEntity.getClass().getSimpleName();
            player.sendMessage(new TextComponentTranslation("chat.shincolle:pointer.settargetclass", "  " + targetName));
            CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 30, targetName));
        }
        if((EntityHelper.getPointerInUse(player) != null && stack.getMetadata() < 3) || ConfigHandler.alwaysShowTeamParticle) {
            coolDown = 2;
        }
        return true;
    }

    private boolean handleSwingOnMiss(EntityPlayer player, ItemStack stack) {
        GameSettings keySet = ClientProxy.getGameSetting();
        boolean isSneaking = keySet.keyBindSneak.isKeyDown();
        boolean isSprinting = keySet.keyBindSprint.isKeyDown();
        int meta = stack.getMetadata();

        if (isSneaking && isSprinting) {
            CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 26, 0));
        } else if (isSneaking) {
            int newMeta;
            switch (meta) {
                case 1: case 4: newMeta = 2; break;
                case 2: case 5: newMeta = 0; break;
                default: newMeta = 1;
            }
            stack.setItemDamage(newMeta);
            CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 24, newMeta));
        } else if (isSprinting && meta == 2) {
            this.formatFlag = true;
            this.formatAddID++;
            this.formatCD = 20;
            return false;
        }
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (stack.getMetadata() > 2 || !world.isRemote) {
            return new ActionResult<>(EnumActionResult.PASS, stack);
        }
        List<Entity> excludeList = new ArrayList<>();
        excludeList.add(player);
        if (player.isRiding()) {
            excludeList.add(player.getRidingEntity());
            if (player.getRidingEntity() instanceof BasicEntityMount) {
                excludeList.add(((BasicEntityMount) player.getRidingEntity()).getHostEntity());
            }
        }
        RayTraceResult hitResult = EntityHelper.getPlayerMouseOverEntity(64.0, 1.0f, excludeList, true, false);
        if (hitResult != null && hitResult.typeOfHit == RayTraceResult.Type.ENTITY) {
            handleRightClickOnEntity(player, stack, hitResult.entityHit);
        } else {
            RayTraceResult blockHitResult = BlockHelper.getPlayerMouseOverBlockOnWater(64.0, 1.0f);
            if (blockHitResult != null && blockHitResult.typeOfHit == RayTraceResult.Type.BLOCK) {
                handleRightClickOnBlock(player, stack, world, blockHitResult);
            } else if (ClientProxy.getGameSetting().keyBindSneak.isKeyDown()) {
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 32, 0));
                return new ActionResult<>(EnumActionResult.SUCCESS, stack);
            }
        }
        return new ActionResult<>(EnumActionResult.PASS, stack);
    }

    private void handleRightClickOnEntity(EntityPlayer player, ItemStack stack, Entity target) {
        int meta = stack.getMetadata();
        if (ClientProxy.getGameSetting().keyBindSprint.isKeyDown()) {
            CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 25, meta, 0, target.getEntityId()));
            return;
        }
        BasicEntityShip ship = EntityHelper.getShipFromHost(target);
        if (ship != null) {
            if (TeamHelper.checkSameOwner(player, ship)) {
                if (player.isSneaking()) {
                    CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 22, ship.getEntityId()));
                } else if (!(target instanceof BasicEntityMount && player.getDistanceSq(target) <= 16.0)) {
                    CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 23, meta, ship.getShipUID()));
                }
            } else {
                sendAttackCommand(player, stack, target);
            }
        } else if (target instanceof EntityPlayer || !target.isInvisible()) {
            sendAttackCommand(player, stack, target);
        }
    }

    private void sendAttackCommand(EntityPlayer player, ItemStack stack, Entity target) {
        int meta = stack.getMetadata();
        if (ConfigHandler.friendlyFire && !(target instanceof EntityPlayer) && !target.isInvisible()) {
            CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 21, meta, target.getEntityId()));
            ParticleHelper.spawnAttackParticleAtEntity(target, 0.3, 5.0, 0.0, (byte) 2);
        } else {
            BlockPos pos = target.getPosition();
            CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 28, meta, 1, pos.getX(), pos.getY(), pos.getZ()));
            ParticleHelper.spawnAttackParticleAtEntity(target, 0.3, 4.0, 0.0, (byte) 2);
        }
    }

    private void handleRightClickOnBlock(EntityPlayer player, ItemStack stack, World world, RayTraceResult hitResult) {
        BlockPos pos = hitResult.getBlockPos();
        IBlockState state = world.getBlockState(pos);
        TileEntity tile = world.getTileEntity(pos);
        int guardType = 1;
        if (state.getMaterial().isLiquid()) {
            guardType = 2;
        } else if (!(tile instanceof ITileGuardPoint)) {
            pos = pos.offset(hitResult.sideHit);
        }
        CommonProxy.channelG.sendToServer(new C2SGUIPackets(player, (byte) 28, stack.getMetadata(), guardType, pos.getX(), pos.getY(), pos.getZ()));
        if (guardType == 2) {
            ParticleHelper.spawnAttackParticleAt(pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, 0.3, 4.0, 0.0, (byte) 25);
        } else {
            ParticleHelper.spawnAttackParticleAt(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.3, 4.0, 0.0, (byte) 25);
        }
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        return true;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean inUse) {
        if (!world.isRemote) return;
        handleClientUpdate(stack, entity, inUse);
        if ((entity instanceof EntityPlayer && EntityHelper.getPointerInUse((EntityPlayer) entity) != null && stack.getMetadata() < 3) || ConfigHandler.alwaysShowTeamParticle) {
            if(coolDown > 0){
                coolDown --;
            }
            if (entity.ticksExisted % 32 == 0 || coolDown == 0) {
                if (!(entity instanceof EntityPlayer)) return;
                showTeamParticle((EntityPlayer) entity, stack);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    private void handleClientUpdate(ItemStack stack, Entity entity, boolean inUse) {
        if (inUse && ConfigHandler.debugMode && stack.getItemDamage() > 2 && (entity.ticksExisted & 1) == 0) {
            showDebugParticle();
        }
        if (this.formatFlag) {
            this.formatCD--;
            if (this.formatCD <= 0 && entity instanceof EntityPlayer) {
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability((EntityPlayer) entity);
                if (capa != null) {
                    int fid = (capa.getFormatID()[capa.getCurrentTeamID()] + this.formatAddID) % 6;
                    entity.sendMessage(new TextComponentString(I18n.format("chat.shincolle:pointer.changeformation") + " " + I18n.format("gui.shincolle:formation.format" + fid)));
                    CommonProxy.channelG.sendToServer(new C2SGUIPackets(entity, (byte) 31, fid));
                    this.formatFlag = false;
                    this.formatAddID = 0;
                    this.formatCD = 0;
                }
            }
        }
        if (inUse && ClientProxy.getGameSetting().keyBindSprint.isKeyDown() && (entity.ticksExisted & 7) == 0) {
            CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
            if (capa != null) {
                for (BasicEntityShip ship : capa.getShipEntityAll(capa.getCurrentTeamID())) {
                    ParticleHelper.spawnAttackParticleAtEntity(entity, ship, 0.0, 0.0, 0.0, (byte) 5, false);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    private void showDebugParticle() {
        RayTraceResult hitResult = EntityHelper.getPlayerMouseOverEntity(6.0, 1.0f);
        if (hitResult == null || hitResult.typeOfHit != RayTraceResult.Type.ENTITY) return;
        Entity hitEntity = hitResult.entityHit;
        int hitHeight = CalcHelper.getEntityHitHeightByClientPlayer(hitEntity);
        ParticleHelper.spawnAttackParticleAtEntity(hitEntity, hitHeight * 0.01f * hitEntity.height, 0.0, 0.0, (byte) 18);
        if (hitEntity instanceof BasicEntityShip) {
            BasicEntityShip ship = (BasicEntityShip) hitEntity;
            int hitBodyID = EntityHelper.getBodyArrayIDFromHeight(hitHeight, ship);
            int[] cubeRange = EntityHelper.getBodyRangeFromHeight(hitHeight, ship);
            byte particleType = 19;
            int hitSide = CalcHelper.getEntityHitSideByClientPlayer(hitEntity);
            if (EntityHelper.getHitBodyID(EntityHelper.getBodyIDFromHeight(hitHeight, ship), EntityHelper.getHitAngleID(hitSide)) == ship.getSensitiveBody()) {
                particleType = 20;
            }
            ParticleHelper.spawnAttackParticleAtEntity(hitEntity, cubeRange[0] * 0.01f * hitEntity.height, cubeRange[1] * 0.01f * hitEntity.height, hitBodyID, particleType);
        }
    }

    @SideOnly(Side.CLIENT)
    private void showTeamParticle(EntityPlayer player, ItemStack stack) {
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa == null) return;
        int meta = stack.getMetadata();
        for (int i = 0; i < 6; i++) {
            BasicEntityShip teamShip = capa.getShipEntityCurrentTeam(i);
            if (teamShip == null) continue;
            boolean isSelected = capa.getSelectStateCurrentTeam(i);
            int particleType = 0;
            if (isSelected) {
                switch (meta) {
                    case 1: case 4: particleType = 2; break;
                    case 2: case 5: particleType = 3; break;
                    default: particleType = 1;
                }
            } else {
                if (meta == 2 || meta == 5) {
                    particleType = 3;
                }
            }
            ParticleHelper.spawnAttackParticleAtEntity(teamShip, 0.3, particleType, 0.0, (byte) 2);
        }
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
        if (capa == null || capa.needInit()) return;
        addModeInfo(stack, tooltip, capa);
        addTeamInfo(tooltip, capa);
    }

    private void addModeInfo(ItemStack stack, List<String> tooltip, CapaTeitoku capa) {
        int fid = capa.getFormatID()[capa.getCurrentTeamID()];
        String formation = (fid >= 0) ? TextFormatting.GOLD + I18n.format("gui.shincolle:formation.format" + fid) : "";
        String mode, help;
        switch (stack.getItemDamage()) {
            case 1:
                mode = TextFormatting.RED + I18n.format("gui.shincolle:pointer1");
                break;
            case 2:
                mode = TextFormatting.GOLD + I18n.format("gui.shincolle:pointer2");
                break;
            default:
                mode = TextFormatting.AQUA + I18n.format("gui.shincolle:pointer0");
        }
        help = TextFormatting.GRAY + I18n.format("gui.shincolle:pointer3");
        tooltip.add(mode + " : " + formation);
        tooltip.add(help);
    }

    private void addTeamInfo(List<String> tooltip, CapaTeitoku capa) {
        tooltip.add(TextFormatting.YELLOW + "" + TextFormatting.UNDERLINE + String.format("%s %d", I18n.format("gui.shincolle:pointer4"), capa.getCurrentTeamID() + 1));
        int displayedCount = 1;
        for (int i = 0; i < 6; i++) {
            BasicEntityShip ship = capa.getShipEntityCurrentTeam(i);
            if (ship != null) {
                String name = ship.getCustomNameTag().isEmpty() ? ship.getName() : ship.getCustomNameTag();
                TextFormatting color = capa.getSelectStateCurrentTeam(i) ? TextFormatting.WHITE : TextFormatting.GRAY;
                tooltip.add(color + String.format("%d: %s - Lv %d", displayedCount, name, ship.getStateMinor(0)));
                displayedCount++;
            } else if (capa.getSIDCurrentTeam(i) > 0) {
                tooltip.add(TextFormatting.DARK_RED + "" + TextFormatting.OBFUSCATED + I18n.format("gui.shincolle:formation.nosignal"));
                displayedCount++;
            }
        }
    }
}