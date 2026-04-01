package com.lulan.shincolle.capability;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.tileentity.BasicTileInventory;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.ItemStackHandler;

public class CapaInventory<T>
        extends ItemStackHandler {
    protected int hostType = -1;
    protected T host;
    protected ISidedInventory hostInv;

    public CapaInventory(int size, T host) {
        super(size);
        this.host = host;
        if (host instanceof ISidedInventory) {
            this.hostInv = (ISidedInventory)host;
        }

        if (this.host instanceof BasicEntityShip) {
            this.hostType = 0;
        } else if (this.host instanceof BasicTileInventory) {
            this.hostType = 1;
        } else if (this.host instanceof Entity) {
            this.hostType = 2;
        } else if (this.host instanceof ItemStack) {
            this.hostType = 3;
        } else {
            this.hostType = 4;
        }
    }

    public T getHost() {
        return this.host;
    }

    public ItemStack[] getStacksInSlots(int slotStart, int length) {
        this.validateSlotIndex(slotStart);
        if (slotStart + length > this.getSlots() || length < 0) {
            throw new RuntimeException("Slot length not in valid range - [0, " + this.stacks.size() + ")");
        }
        ItemStack[] items = new ItemStack[length];
        int slotEnd = slotStart + length;
        for (int i = slotStart; i < slotEnd; ++i) {
            items[i] = this.stacks.get(i);
        }
        return items;
    }

    protected void onContentsChanged(int slot) {
        switch (this.hostType) {
            case 0: {
                break;
            }
            case 1: {
                ((TileEntity)this.host).markDirty();
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            default:
                break;
        }
    }

    protected void onLoad() {
    }

    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        if (this.hostInv != null) {
            if (this.hostInv.canInsertItem(slot, stack, EnumFacing.UP)) {
                return super.insertItem(slot, stack, simulate);
            }
            return stack;
        }
        return super.insertItem(slot, stack, simulate);
    }

    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (this.hostInv != null) {
            if (this.hostInv.canExtractItem(slot, this.getStackInSlot(slot), EnumFacing.UP)) {
                return super.extractItem(slot, amount, simulate);
            }
            return ItemStack.EMPTY;
        }
        return super.extractItem(slot, amount, simulate);
    }
}