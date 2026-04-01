package com.lulan.shincolle.item;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipMorph;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.TeamHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class KaitaiHammer
        extends BasicItem {
    private static final String NAME = "KaitaiHammer";

    public KaitaiHammer() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setMaxStackSize(1);
        this.setMaxDamage(20);
        this.setFull3D();
        this.setNoRepair();
        this.setHasSubtypes(false);
    }

    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    public ItemStack getContainerItem(ItemStack stack) {
        int meta = stack.getItemDamage() + 1;
        stack.setCount(0);
        if (meta >= this.getMaxDamage(stack)) {
            return ItemStack.EMPTY;
        }
        return new ItemStack(ModItems.KaitaiHammer, 1, meta);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return String.format("item.%s", "shincolle:KaitaiHammer");
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (entity instanceof IShipMorph && ((IShipMorph)entity).isMorph()) {
            entity.setDead();
            return true;
        }
        if (!player.world.isRemote && entity instanceof BasicEntityShip) {
            if (TeamHelper.checkSameOwner(player, entity) || EntityHelper.checkOP(player)) {
                entity.attackEntityFrom(DamageSource.causePlayerDamage(player), ((BasicEntityShip)entity).getMaxHealth() * 1.1f);
                int meta = stack.getItemDamage();
                if (!player.capabilities.isCreativeMode) {
                    ++meta;
                }
                if (meta >= stack.getMaxDamage()) {
                    if (player.inventory.getCurrentItem() != ItemStack.EMPTY && player.inventory.getCurrentItem().getItem() == ModItems.KaitaiHammer) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                    }
                } else {
                    stack.setItemDamage(meta);
                }
            }
            return true;
        }
        return false;
    }
}
