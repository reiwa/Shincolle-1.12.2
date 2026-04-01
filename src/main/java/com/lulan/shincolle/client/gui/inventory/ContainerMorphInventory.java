package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.item.BasicEquip;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerMorphInventory
extends Container {
    private final BasicEntityShip entity;
    private final int lenTemp;
    private final int[] valueTemp;

    public ContainerMorphInventory(CapaTeitoku capa, IInventory invPlayer, BasicEntityShip entity) {
        int i;
        this.entity = entity;
        this.lenTemp = entity.getFieldCount();
        this.valueTemp = new int[this.lenTemp];
        for (i = 0; i < 6; ++i) {
            this.addSlotToContainer(new SlotMorphInventory(capa, i, 144, 18 + i * 18));
        }
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 132 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 190));
        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotid) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(slotid);
        boolean isEquip = false;
        int slotsEnd = 42;
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (itemstack1.getItem() instanceof BasicEquip) {
                isEquip = true;
            }
            if (slotid < 6) {
                if (!this.mergeItemStack(itemstack1, 6, slotsEnd, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if (isEquip) {
                if (!this.mergeItemStack(itemstack1, 0, 6, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                return ItemStack.EMPTY;
            }
            if (itemstack1.getCount() <= 0) {
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
        int i;
        int pageTemp = this.entity.getField(27);
        for (i = 0; i < this.inventorySlots.size(); ++i) {
            ItemStack itemNew = this.inventorySlots.get(i).getStack();
            ItemStack itemBackup = this.inventoryItemStacks.get(i);
            if (ItemStack.areItemStacksEqual(itemBackup, itemNew) && pageTemp == this.valueTemp[27]) continue;
            itemBackup = itemNew.copy();
            this.inventoryItemStacks.set(i, itemBackup);
            for (int j = 0; j < this.listeners.size(); ++j) {
                this.listeners.get(j).sendSlotContents(this, i, itemBackup);
            }
        }
        for (IContainerListener listener : this.listeners) {
            boolean needsGuiSync = false;
            for (int j = 0; j < this.lenTemp; ++j) {
                int temp = this.entity.getField(j);
                if (this.valueTemp[j] == temp) {
                    continue;
                }
                switch (j) {
                    case 1:
                    case 2:
                    case 25:
                    case 26:
                    case 27:
                        needsGuiSync = true;
                        break;
                    default:
                        listener.sendWindowProperty(this, j, temp);
                        break;
                }
            }
            if (needsGuiSync) {
                this.entity.sendSyncPacketGUI();
            }
        }
        for (int k = 0; k < this.lenTemp; ++k) {
            this.valueTemp[k] = this.entity.getField(k);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        this.entity.setField(id, value);
    }
}
