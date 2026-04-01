package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.item.BasicEquip;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMorphInventory
extends Slot {

    public SlotMorphInventory(CapaTeitoku capa, int slotIndex, int x, int y) {
        super(capa, slotIndex, x, y);
    }

    public boolean isItemValid(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem() instanceof BasicEquip;
    }
}
