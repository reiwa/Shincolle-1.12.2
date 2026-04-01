package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.crafting.SmallRecipes;
import com.lulan.shincolle.tileentity.TileEntitySmallShipyard;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerSmallShipyard
extends Container {
    private final TileEntitySmallShipyard tile;
    private int guiBuildType;
    private int guiConsumedPower;
    private int guiRemainedPower;
    private int guiGoalPower;

    public ContainerSmallShipyard(IInventory player, TileEntitySmallShipyard tile) {
        int i;
        this.tile = tile;
        this.addSlotToContainer(new SlotSmallShipyard(tile, 0, 33, 29));
        this.addSlotToContainer(new SlotSmallShipyard(tile, 1, 53, 29));
        this.addSlotToContainer(new SlotSmallShipyard(tile, 2, 73, 29));
        this.addSlotToContainer(new SlotSmallShipyard(tile, 3, 93, 29));
        this.addSlotToContainer(new SlotSmallShipyard(tile, 4, 8, 53));
        this.addSlotToContainer(new SlotSmallShipyard(tile, 5, 134, 44));
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 87 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 145));
        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        return this.tile.isUsableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotid) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(slotid);
        int itemID;
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            itemID = SmallRecipes.getMaterialType(itemstack1);
            if (slotid == 5) {
                if (!this.mergeItemStack(itemstack1, 6, 42, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if (slotid > 5 ? (itemID >= 0 ? !this.mergeItemStack(itemstack1, itemID, itemID + 1, false) : (slotid > 5 && slotid < 33 ? !this.mergeItemStack(itemstack1, 33, 42, false) : slotid > 32 && !this.mergeItemStack(itemstack1, 6, 33, false))) : !this.mergeItemStack(itemstack1, 6, 42, true)) {
                return ItemStack.EMPTY;
            }
            if (itemstack1.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, itemstack1);
        }
        return itemstack;
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.listeners.size(); ++i) {
            IContainerListener tileListener = this.listeners.get(i);
            if (this.guiBuildType != this.tile.getBuildType()) {
                tileListener.sendWindowProperty(this, 0, this.tile.getBuildType());
            }
            if (this.guiConsumedPower == this.tile.getPowerConsumed() && this.guiRemainedPower == this.tile.getPowerRemained() && this.guiGoalPower == this.tile.getPowerGoal()) continue;
            this.tile.sendSyncPacket();
        }
        this.guiBuildType = this.tile.getBuildType();
        this.guiConsumedPower = this.tile.getPowerConsumed();
        this.guiRemainedPower = this.tile.getPowerRemained();
        this.guiGoalPower = this.tile.getPowerGoal();
    }

    @SideOnly(value=Side.CLIENT)
    public void updateProgressBar(int valueType, int updatedValue) {
        if (this.tile == null) {
            return;
        }
        if(valueType == 0){
            this.tile.setBuildType(updatedValue);
        }
    }
}
