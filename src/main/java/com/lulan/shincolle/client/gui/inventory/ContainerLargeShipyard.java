package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.tileentity.TileMultiGrudgeHeavy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerLargeShipyard
extends Container {
    private final TileMultiGrudgeHeavy tile;
    private int guiConsumedPower;
    private int guiRemainedPower;
    private int guiGoalPower;
    private int guiBuildType;
    private int guiSelectMat;
    private int guiInvMode = 0;
    private final int[] guiMatBuild = new int[]{0, 0, 0, 0};
    private final int[] guiMatStock = new int[]{0, 0, 0, 0};

    public ContainerLargeShipyard(IInventory player, TileMultiGrudgeHeavy tile) {
        int i;
        this.tile = tile;
        this.addSlotToContainer(new SlotLargeShipyard(tile, 0, 168, 51));
        for (i = 1; i < 10; ++i) {
            this.addSlotToContainer(new SlotLargeShipyard(tile, i, 7 + i * 18, 116));
        }
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 25 + j * 18, 141 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(player, i, 25 + i * 18, 199));
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
            boolean success;

            if (slotid == 0) {
                success = this.mergeItemStack(orgStack, 1, 46, true);
            } else if (slotid >= 37) {
                success = this.mergeItemStack(orgStack, 1, 37, false);
            } else if (slotid >= 10 && slotid < 37) {
                success = this.mergeItemStack(orgStack, 1, 10, true);
            } else {
                success = this.mergeItemStack(orgStack, 10, 46, false);
            }
            if (!success) {
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

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (IContainerListener listener : this.listeners) {
            if (this.guiBuildType != this.tile.getBuildType()) {
                listener.sendWindowProperty(this, 0, this.tile.getBuildType());
            }
            if (this.guiSelectMat != this.tile.getSelectMat()) {
                listener.sendWindowProperty(this, 1, this.tile.getSelectMat());
            }
            if (this.guiInvMode != this.tile.getInvMode()) {
                listener.sendWindowProperty(this, 2, this.tile.getInvMode());
            }
            for (int i = 0; i < this.guiMatBuild.length; i++) {
                if (this.guiMatBuild[i] != this.tile.getMatBuild(i)) {
                    listener.sendWindowProperty(this, 3 + i, this.tile.getMatBuild(i));
                }
            }
            boolean needsSync = this.guiConsumedPower != this.tile.getPowerConsumed() ||
                    this.guiRemainedPower != this.tile.getPowerRemained() ||
                    this.guiGoalPower != this.tile.getPowerGoal();
            for (int i = 0; i < this.guiMatStock.length; i++) {
                if (this.guiMatStock[i] != this.tile.getMatStock(i)) {
                    needsSync = true;
                    break;
                }
            }
            if (needsSync) {
                this.tile.sendSyncPacket();
            }
        }
        this.guiConsumedPower = this.tile.getPowerConsumed();
        this.guiRemainedPower = this.tile.getPowerRemained();
        this.guiGoalPower = this.tile.getPowerGoal();
        this.guiBuildType = this.tile.getBuildType();
        this.guiSelectMat = this.tile.getSelectMat();
        this.guiInvMode = this.tile.getInvMode();
        for (int i = 0; i < this.guiMatStock.length; i++) {
            this.guiMatStock[i] = this.tile.getMatStock(i);
        }
        for (int i = 0; i < this.guiMatBuild.length; i++) {
            this.guiMatBuild[i] = this.tile.getMatBuild(i);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void updateProgressBar(int valueType, int updatedValue) {
        switch (valueType) {
            case 0: {
                this.tile.setBuildType(updatedValue);
                break;
            }
            case 1: {
                this.tile.setSelectMat(updatedValue);
                break;
            }
            case 2: {
                this.tile.setInvMode(updatedValue);
                break;
            }
            case 3: {
                this.tile.setMatBuild(0, updatedValue);
                break;
            }
            case 4: {
                this.tile.setMatBuild(1, updatedValue);
                break;
            }
            case 5: {
                this.tile.setMatBuild(2, updatedValue);
                break;
            }
            case 6: {
                this.tile.setMatBuild(3, updatedValue);
                break;
            }
            default:
        }
    }
}
