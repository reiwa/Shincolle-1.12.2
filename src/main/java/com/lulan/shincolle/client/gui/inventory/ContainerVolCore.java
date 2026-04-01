package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.tileentity.TileEntityVolCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerVolCore
extends Container {
    private final TileEntityVolCore tile;
    private int guiRemainedPower;
    private int btnActive;

    public ContainerVolCore(IInventory invPlayer, TileEntityVolCore tile) {
        int i;
        this.tile = tile;
        this.addSlotToContainer(new SlotVolCore(tile, 0, 62, 19));
        this.addSlotToContainer(new SlotVolCore(tile, 1, 80, 19));
        this.addSlotToContainer(new SlotVolCore(tile, 2, 98, 19));
        this.addSlotToContainer(new SlotVolCore(tile, 3, 62, 37));
        this.addSlotToContainer(new SlotVolCore(tile, 4, 80, 37));
        this.addSlotToContainer(new SlotVolCore(tile, 5, 98, 37));
        this.addSlotToContainer(new SlotVolCore(tile, 6, 62, 55));
        this.addSlotToContainer(new SlotVolCore(tile, 7, 80, 55));
        this.addSlotToContainer(new SlotVolCore(tile, 8, 98, 55));
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        return this.tile.isUsableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotid) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(slotid);
        if (slot != null && slot.getHasStack()) {
            ItemStack orgStack = slot.getStack();
            newStack = orgStack.copy();
            if (slotid >= 36 ? !this.mergeItemStack(orgStack, 0, 36, false) : (slotid >= 9 ? !this.mergeItemStack(orgStack, 0, 9, true) : !this.mergeItemStack(orgStack, 9, 45, false))) {
                return ItemStack.EMPTY;
            }
            if (orgStack.getCount() <= 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return newStack;
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.listeners.size(); ++i) {
            int temp;
            IContainerListener listener = this.listeners.get(i);
            if (this.guiRemainedPower != this.tile.getPowerRemained()) {
                this.tile.sendSyncPacket();
            }
            if (this.btnActive == (temp = this.tile.getField(0))) continue;
            listener.sendWindowProperty(this, 0, temp);
        }
        this.guiRemainedPower = this.tile.getPowerRemained();
        this.btnActive = this.tile.getField(0);
    }

    @SideOnly(value=Side.CLIENT)
    public void updateProgressBar(int type, int value) {
        this.tile.setField(type, value);
    }
}
