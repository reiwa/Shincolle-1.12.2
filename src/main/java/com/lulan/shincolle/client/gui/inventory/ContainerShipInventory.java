package com.lulan.shincolle.client.gui.inventory;

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

public class ContainerShipInventory extends Container {
    private final BasicEntityShip entity;
    private final int fieldCount;
    private final int[] cachedFields;
    private static final int EQUIP_SLOTS = 6;
    private static final int SHIP_INV_SLOTS = 18;
    private static final int PLAYER_INV_SLOTS = 27;
    private static final int PLAYER_HOTBAR_SLOTS = 9;
    private static final int EQUIP_SLOTS_END = EQUIP_SLOTS;
    private static final int SHIP_INV_END = EQUIP_SLOTS_END + SHIP_INV_SLOTS;
    private static final int PLAYER_INV_END = SHIP_INV_END + PLAYER_INV_SLOTS;
    private static final int TOTAL_SLOTS = PLAYER_INV_END + PLAYER_HOTBAR_SLOTS;

    public ContainerShipInventory(IInventory playerInventory, BasicEntityShip entity) {
        this.entity = entity;
        this.fieldCount = entity.getFieldCount();
        this.cachedFields = new int[this.fieldCount];
        for (int i = 0; i < EQUIP_SLOTS; ++i) {
            this.addSlotToContainer(new SlotShipInventory(entity.getCapaShipInventory(), i, 144, 18 + i * 18));
        }
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.addSlotToContainer(new SlotShipInventory(entity.getCapaShipInventory(), j + i * 3 + EQUIP_SLOTS, 8 + j * 18, 18 + i * 18));
            }
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + PLAYER_HOTBAR_SLOTS, 8 + j * 18, 132 + i * 18));
            }
        }
        for (int i = 0; i < PLAYER_HOTBAR_SLOTS; ++i) {
            this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 190));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack resultStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot == null || !slot.getHasStack()) {
            return resultStack;
        }
        ItemStack sourceStack = slot.getStack();
        resultStack = sourceStack.copy();
        boolean isEquip = sourceStack.getItem() instanceof BasicEquip;
        boolean mergeFailed;
        if (index < EQUIP_SLOTS_END) {
            mergeFailed = !this.mergeItemStack(sourceStack, EQUIP_SLOTS_END, TOTAL_SLOTS, true);
        } else if (index < SHIP_INV_END) {
            if (isEquip) {
                mergeFailed = !this.mergeItemStack(sourceStack, 0, EQUIP_SLOTS_END, false) &&
                        !this.mergeItemStack(sourceStack, SHIP_INV_END, TOTAL_SLOTS, true);
            } else {
                mergeFailed = !this.mergeItemStack(sourceStack, SHIP_INV_END, TOTAL_SLOTS, true);
            }
        } else {
            if (isEquip) {
                mergeFailed = !this.mergeItemStack(sourceStack, 0, EQUIP_SLOTS_END, false) &&
                        !this.mergeItemStack(sourceStack, EQUIP_SLOTS_END, SHIP_INV_END, true);
            } else {
                mergeFailed = !this.mergeItemStack(sourceStack, EQUIP_SLOTS_END, SHIP_INV_END, false);
            }
        }
        if (mergeFailed) {
            return ItemStack.EMPTY;
        }
        if (index < EQUIP_SLOTS_END) {
            slot.onSlotChange(sourceStack, resultStack);
        }
        if (sourceStack.isEmpty()) {
            slot.putStack(ItemStack.EMPTY);
        } else {
            slot.onSlotChanged();
        }
        if (sourceStack.getCount() == resultStack.getCount()) {
            return ItemStack.EMPTY;
        }
        slot.onTake(playerIn, sourceStack);
        return resultStack;
    }

    @Override
    public void detectAndSendChanges() {
        int currentPage = this.entity.getField(27);
        for (int i = 0; i < this.inventorySlots.size(); ++i) {
            ItemStack newStack = this.inventorySlots.get(i).getStack();
            ItemStack cachedStack = this.inventoryItemStacks.get(i);
            if (ItemStack.areItemStacksEqual(cachedStack, newStack) && currentPage == this.cachedFields[27]) {
                continue;
            }
            ItemStack stackToCache = newStack.isEmpty() ? ItemStack.EMPTY : newStack.copy();
            this.inventoryItemStacks.set(i, stackToCache);
            for (IContainerListener listener : this.listeners) {
                listener.sendSlotContents(this, i, stackToCache);
            }
        }
        for (IContainerListener listener : this.listeners) {
            boolean needsFullSync = false;
            for (int j = 0; j < this.fieldCount; ++j) {
                int currentValue = this.entity.getField(j);
                if (this.cachedFields[j] == currentValue) continue;
                switch (j) {
                    case 1:
                    case 2:
                    case 25:
                    case 26:
                    case 27:
                        needsFullSync = true;
                        continue;
                    default:
                        listener.sendWindowProperty(this, j, currentValue);
                }
            }
            if (needsFullSync) {
                this.entity.sendSyncPacketGUI();
            }
        }
        for (int i = 0; i < this.fieldCount; ++i) {
            this.cachedFields[i] = this.entity.getField(i);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int data) {
        this.entity.setField(id, data);
    }
}