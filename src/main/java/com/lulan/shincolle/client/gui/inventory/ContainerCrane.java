package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.tileentity.TileEntityCrane;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerCrane
extends Container {
    private final TileEntityCrane tile;
    private final int lenTemp;
    private final int[] valueTemp;

    public ContainerCrane(IInventory invPlayer, TileEntityCrane tile) {
        int i;
        this.tile = tile;
        this.lenTemp = tile.getFieldCount();
        this.valueTemp = new int[this.lenTemp];
        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new SlotCrane(tile, i, 8 + i * 18, 65));
        }
        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new SlotCrane(tile, i + 9, 8 + i * 18, 96));
        }
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 119 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 177));
        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        return this.tile.isUsableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotid) {
        return ItemStack.EMPTY;
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (IContainerListener listener : this.listeners) {
            for (int j = 0; j < this.lenTemp; ++j) {
                int temp = this.tile.getField(j);
                if (this.valueTemp[j] == temp) {
                    continue;
                }
                switch (j) {
                    case 0:
                        this.tile.sendSyncPacket();
                        break;
                    case 1:
                        if (this.tile.getShip() != null) {
                            this.tile.getShip().sendSyncPacketTimer(0);
                        }
                        break;
                    default:
                        listener.sendWindowProperty(this, j, temp);
                        break;
                }
            }
        }
        for (int k = 0; k < this.lenTemp; ++k) {
            this.valueTemp[k] = this.tile.getField(k);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        this.tile.setField(id, value);
    }

    public ItemStack slotClick(int id, int key, ClickType type, EntityPlayer player) {
        ItemStack itemstack = player.inventory.getItemStack();
        if (id >= 0 && id < 18) {
            Slot slot = this.inventorySlots.get(id);
            if (!itemstack.isEmpty()) {
                if (key == 1) {
                    ItemStack itemstack2 = itemstack.copy();
                    itemstack2.setCount(1);
                    slot.putStack(itemstack2);
                    this.tile.setItemMode(id, true);
                } else {
                    ItemStack oldSlot = slot.getStack();
                    ItemStack itemstack2 = itemstack.copy();
                    int size = itemstack.getCount();
                    if (ItemStack.areItemsEqual(itemstack2, oldSlot)) {
                        size += oldSlot.getCount();
                    }
                    itemstack2.setCount(size);
                    slot.putStack(itemstack2);
                    this.tile.setItemMode(id, false);
                }
            } else {
                slot.putStack(ItemStack.EMPTY);
                this.tile.setItemMode(id, false);
            }
            this.detectAndSendChanges();
            return ItemStack.EMPTY;
        }
        return super.slotClick(id, key, type, player);
    }
}
