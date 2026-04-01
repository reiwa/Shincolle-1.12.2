package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.tileentity.TileMultiGrudgeHeavy;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotLargeShipyard
extends Slot {
    private final int slotIndex;
    private final TileMultiGrudgeHeavy tile;

    public SlotLargeShipyard(IInventory entity, int slotIndex, int x, int y) {
        super(entity, slotIndex, x, y);
        this.slotIndex = slotIndex;
        this.tile = (TileMultiGrudgeHeavy)entity;
    }

    public boolean isItemValid(ItemStack itemstack) {
        return this.tile.isItemValidForSlot(this.slotIndex, itemstack);
    }
}
