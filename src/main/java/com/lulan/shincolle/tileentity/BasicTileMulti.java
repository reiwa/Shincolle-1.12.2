package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.block.BasicBlockMulti;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BasicTileMulti
extends BasicTileInventory {
    protected BasicTileMulti masterTile = null;
    protected boolean hasMaster;
    protected boolean isMaster;
    protected int structType;
    private BlockPos masterPos = BlockPos.ORIGIN;

    @Override
    public byte getGuiIntID() {
        BasicTileMulti tile = this.getMaster();
        if (tile instanceof TileMultiGrudgeHeavy) {
            return tile.getGuiIntID();
        }
        return -1;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setInteger("masterX", this.masterPos.getX());
        data.setInteger("masterY", this.masterPos.getY());
        data.setInteger("masterZ", this.masterPos.getZ());
        data.setInteger("structType", this.structType);
        data.setBoolean("hasMaster", this.hasMaster);
        data.setBoolean("isMaster", this.isMaster);
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.masterPos = new BlockPos(data.getInteger("masterX"), data.getInteger("masterY"), data.getInteger("masterZ"));
        this.structType = data.getInteger("structType");
        this.hasMaster = data.getBoolean("hasMaster");
        this.isMaster = data.getBoolean("isMaster");
    }

    public int getStructType() {
        return this.structType;
    }

    public BasicTileMulti getMaster() {
        TileEntity tile;
        if (this.masterTile != null) {
            return this.masterTile;
        }
        if (this.hasMaster && (tile = this.world.getTileEntity(this.masterPos)) instanceof BasicTileMulti) {
            this.setMaster((BasicTileMulti)tile);
            return this.masterTile;
        }
        return null;
    }

    public boolean hasMaster() {
        return this.hasMaster;
    }

    public BlockPos getMasterPos() {
        return this.masterPos;
    }

    public void setStructType(int type, World world) {
        this.structType = type;
        if (type == 0) {
            BasicBlockMulti.updateBlockState(0, world, this.getPos());
        } else {
            BasicBlockMulti.updateBlockState(1, world, this.getPos());
        }
    }

    public void setMaster(BasicTileMulti master) {
        if (master != null && !master.isInvalid()) {
            this.masterTile = master;
            this.setMasterCoords(master.getPos());
        } else {
            this.masterTile = null;
        }
    }

    public void setHasMaster(boolean par1) {
        this.hasMaster = par1;
    }

    public void setIsMaster(boolean par1) {
        this.isMaster = par1;
    }

    public void setMasterCoords(BlockPos pos) {
        this.masterPos = pos;
    }
}
