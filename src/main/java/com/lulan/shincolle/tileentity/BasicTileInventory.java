package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.capability.CapaInventory;
import com.lulan.shincolle.entity.IShipOwner;
import com.lulan.shincolle.utility.PacketHelper;
import com.lulan.shincolle.utility.TeamHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;

public abstract class BasicTileInventory
extends BasicTileEntity
implements ISidedInventory,
IShipOwner {
    protected CapaInventory itemHandler;
    protected int syncTime = 0;
    protected int playerUID = 0;

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.playerUID = nbt.getInteger("pid");
        if (nbt.hasKey("CpInv")) {
            this.itemHandler.deserializeNBT((NBTTagCompound)nbt.getTag("CpInv"));
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("pid", this.playerUID);
        nbt.setTag("CpInv", this.itemHandler.serializeNBT());
        return nbt;
    }

    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return (T) this.itemHandler;
        }
        return super.getCapability(capability, facing);
    }

    public boolean isUsableByPlayer(EntityPlayer player) {
        return TeamHelper.isUsableByPlayer(this, player);
    }

    public int getSizeInventory() {
        if (this.itemHandler != null) {
            return this.itemHandler.getSlots();
        }
        return 0;
    }

    public ItemStack getStackInSlot(int i) {
        try {
            return this.itemHandler.getStackInSlot(i);
        }
        catch (Exception e) {
            e.printStackTrace();
            return ItemStack.EMPTY;
        }
    }

    public ItemStack decrStackSize(int id, int count) {
        try {
            if (id >= 0 && id < this.itemHandler.getSlots() && !this.itemHandler.getStackInSlot(id).isEmpty() && count > 0) {
                ItemStack itemstack = this.itemHandler.getStackInSlot(id).splitStack(count);
                if (this.itemHandler.getStackInSlot(id).getCount() == 0) {
                    this.itemHandler.setStackInSlot(id, ItemStack.EMPTY);
                }
                return itemstack;
            }
            return ItemStack.EMPTY;
        }
        catch (Exception e) {
            e.printStackTrace();
            return ItemStack.EMPTY;
        }
    }

    public ItemStack removeStackFromSlot(int id) {
        return ItemStack.EMPTY;
    }

    public void setInventorySlotContents(int id, ItemStack stack) {
        if (this.itemHandler != null && this.itemHandler.getSlots() > id) {
            this.itemHandler.setStackInSlot(id, stack);
            if (!stack.isEmpty() && stack.getCount() > this.getInventoryStackLimit()) {
                stack.setCount(this.getInventoryStackLimit());
            }
        }
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean canInsertItem(int slot, ItemStack item, EnumFacing face) {
        return this.isItemValidForSlot(slot, item);
    }

    public boolean canExtractItem(int slot, ItemStack item, EnumFacing face) {
        return false;
    }

    public int[] getSlotsForFace(EnumFacing face) {
        return new int[0];
    }

    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        return false;
    }

    public void openInventory(EntityPlayer player) {
    }

    public void closeInventory(EntityPlayer player) {
    }

    public String getName() {
        return "tile.shincolle:" + this.getRegName();
    }

    public boolean hasCustomName() {
        return false;
    }

    public int getField(int id) {
        return 0;
    }

    public void setField(int id, int value) {
    }

    public int getFieldCount() {
        return 0;
    }

    public void clear() {
    }

    @Override
    public int getPlayerUID() {
        return this.playerUID;
    }

    @Override
    public void setPlayerUID(int uid) {
        this.playerUID = uid;
        if (!this.world.isRemote) {
            PacketHelper.sendS2CEntitySync(0, this, this.world, this.pos, null);
        }
    }

    @Override
    public Entity getHostEntity() {
        return null;
    }
}
