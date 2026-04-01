package com.lulan.shincolle.client.gui.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCrane
extends Slot {

    public SlotCrane(IInventory tile, int slotIndex, int x, int y) {
        super(tile, slotIndex, x, y);
    }

    public boolean isItemValid(ItemStack itemstack) {
        return false;
    }

    public boolean canTakeStack(EntityPlayer player) {
        return false;
    }
}
