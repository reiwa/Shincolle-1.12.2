package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.capability.CapaInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class TileMultiPolymetal
extends BasicTileMulti {

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            if (!this.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public TileMultiPolymetal() {
        this.itemHandler = new CapaInventory<TileMultiPolymetal>(0, this);
    }

    @Override
    public String getRegName() {
        return "tilemultipolymetal";
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        BasicTileMulti tile = this.getMaster();
        if (tile instanceof TileMultiGrudgeHeavy) {
            return tile.getSlotsForFace(side);
        }
        return new int[0];
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        BasicTileMulti tile = this.getMaster();
        if (tile instanceof TileMultiGrudgeHeavy) {
            return tile.isItemValidForSlot(slot, itemstack);
        }
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack item, EnumFacing face) {
        BasicTileMulti tile = this.getMaster();
        if (tile instanceof TileMultiGrudgeHeavy) {
            return tile.canExtractItem(slot, item, face);
        }
        return false;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        BasicTileMulti master = this.getMaster();
        if (master != null) {
            return master.hasCapability(capability, facing);
        }
        return false;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        BasicTileMulti master = this.getMaster();
        if (master != null) {
            return master.getCapability(capability, facing);
        }
        return null;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        BasicTileMulti tile = this.getMaster();
        if (tile instanceof TileMultiGrudgeHeavy) {
            return tile.isUsableByPlayer(player);
        }
        return false;
    }

    @Override
    public int getSizeInventory() {
        BasicTileMulti tile = this.getMaster();
        if (tile instanceof TileMultiGrudgeHeavy) {
            return tile.getSizeInventory();
        }
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        BasicTileMulti tile = this.getMaster();
        if (tile instanceof TileMultiGrudgeHeavy) {
            return tile.getStackInSlot(i);
        }
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack decrStackSize(int id, int count) {
        BasicTileMulti tile = this.getMaster();
        if (tile instanceof TileMultiGrudgeHeavy) {
            return tile.decrStackSize(id, count);
        }
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeStackFromSlot(int id) {
        BasicTileMulti tile = this.getMaster();
        if (tile instanceof TileMultiGrudgeHeavy) {
            return tile.removeStackFromSlot(id);
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        BasicTileMulti tile = this.getMaster();
        if (tile instanceof TileMultiGrudgeHeavy) {
            tile.setInventorySlotContents(i, itemstack);
        }
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack item, EnumFacing face) {
        BasicTileMulti tile = this.getMaster();
        if (tile instanceof TileMultiGrudgeHeavy) {
            return tile.canInsertItem(slot, item, face);
        }
        return false;
    }
}
