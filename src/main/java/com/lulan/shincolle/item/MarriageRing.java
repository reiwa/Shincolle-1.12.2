package com.lulan.shincolle.item;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.TeamHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

@Optional.Interface(iface = "baubles.api.IBauble", modid = "Baubles")
public class MarriageRing extends BasicItem implements IBauble {

    private static final String NAME = "MarriageRing";

    public MarriageRing() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (world.isRemote) {
            return new ActionResult<>(EnumActionResult.PASS, stack);
        }
        NBTTagCompound tag = stack.getTagCompound();
        if (tag == null) {
            tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }
        boolean newActiveState = !tag.getBoolean("isActive");
        tag.setBoolean("isActive", newActiveState);
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa != null) {
            capa.setRingActive(newActiveState);
            if (!newActiveState && !player.capabilities.isCreativeMode && capa.isRingFlying()) {
                player.capabilities.isFlying = false;
                capa.setRingFlying(false);
            }
            capa.sendSyncPacket(0);
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return stack.hasTagCompound() && stack.getTagCompound().getBoolean("isActive");
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (!(entity instanceof EntityPlayer)) return;
        EntityPlayer player = (EntityPlayer) entity;
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa == null) return;
        this.updatePlayerAbilities(player, capa);
        if (!world.isRemote && isSelected && (player.ticksExisted & 0x3F) == 0) {
            this.applyAuraToNearbyShips(player, world);
        }
    }

    private void updatePlayerAbilities(EntityPlayer player, CapaTeitoku capa) {
        if (ConfigHandler.ringAbility[0] >= 0 && capa.getMarriageNum() >= ConfigHandler.ringAbility[0] && (player.ticksExisted & 0x7F) == 0 && player.getAir() < 300) {
            player.setAir(300);
        }
        if (ConfigHandler.ringAbility[1] >= 0 && capa.getMarriageNum() >= ConfigHandler.ringAbility[1]) {
            if (EntityHelper.checkEntityIsInLiquid(player)) {
                if (!player.capabilities.isFlying && capa.hasRing() && capa.isRingActive()) {
                    player.capabilities.isFlying = true;
                    capa.setRingFlying(true);
                }
            } else {
                if (capa.isRingFlying() && !player.capabilities.isCreativeMode && player.capabilities.isFlying) {
                    player.capabilities.isFlying = false;
                    capa.setRingFlying(false);
                }
            }
        }
    }

    private void applyAuraToNearbyShips(EntityPlayer player, World world) {
        List<BasicEntityShip> nearbyShips = world.getEntitiesWithinAABB(BasicEntityShip.class, player.getEntityBoundingBox().expand(6.0, 5.0, 6.0));
        for (BasicEntityShip ship : nearbyShips) {
            if (ship == null || !ship.isEntityAlive() || ship.getStateFlag(2) || !TeamHelper.checkSameOwner(player, ship)) {
                continue;
            }
            ship.setStateEmotion(1, 7, true);
            if (ship.getRand().nextInt(5) != 0) {
                continue;
            }
            switch (ship.getRand().nextInt(3)) {
                case 1:
                    ship.applyParticleEmotion(1);
                    break;
                case 2:
                    ship.applyParticleEmotion(31);
                    break;
                default:
                    ship.applyParticleEmotion(15);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
        if (capa != null) {
            tooltip.add(TextFormatting.AQUA + I18n.format("gui.shincolle:ringText") + " " + capa.getMarriageNum());
        }
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public void onWornTick(ItemStack stack, EntityLivingBase player) {
        this.onUpdate(stack, player.world, player, 0, true);
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {}

    @Override
    @Optional.Method(modid = "Baubles")
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {}

    @Override
    @Optional.Method(modid = "Baubles")
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    @Optional.Method(modid = "Baubles")
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }
}