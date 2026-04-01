package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.capability.CapaShipInventory;
import com.lulan.shincolle.item.BasicEquip;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class SlotShipInventory
extends Slot {
    private final int slotIndex;
    private final CapaShipInventory capa;

    public SlotShipInventory(CapaShipInventory capa, int slotIndex, int x, int y) {
        super(capa, slotIndex, x, y);
        this.capa = capa;
        this.slotIndex = slotIndex;
    }

    public boolean isItemValid(ItemStack stack) {
        if (!stack.isEmpty()) {
            Item item = stack.getItem();
            if (this.slotIndex < 6) {
                return item instanceof BasicEquip;
            } else {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public ItemStack getStack() {
        if (this.slotIndex < 6) {
            return this.inventory.getStackInSlot(this.slotIndex);
        }
        return this.inventory.getStackInSlot(this.slotIndex + this.capa.getInventoryPage() * 18);
    }

    public void putStack(@Nullable ItemStack stack) {
        if (this.slotIndex < 6) {
            this.inventory.setInventorySlotContents(this.slotIndex, stack);
        } else {
            this.inventory.setInventorySlotContents(this.slotIndex + this.capa.getInventoryPage() * 18, stack);
        }
        this.onSlotChanged();
    }

    public ItemStack decrStackSize(int amount) {
        if (this.slotIndex < 6) {
            return this.inventory.decrStackSize(this.slotIndex, amount);
        }
        return this.inventory.decrStackSize(this.slotIndex + this.capa.getInventoryPage() * 18, amount);
    }
}
