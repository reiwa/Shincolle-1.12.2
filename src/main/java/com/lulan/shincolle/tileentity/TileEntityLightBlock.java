package com.lulan.shincolle.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;

public class TileEntityLightBlock
extends BasicTileEntity
implements ITickable {
    public int type = 0;
    public int life = 120;
    public int tick = 0;

    @Override
    public String getRegName() {
        return "TileEntityLightBlock";
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.type = nbt.getInteger("type");
        this.life = nbt.getInteger("life");
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("type", this.type);
        nbt.setInteger("life", this.life);
        return nbt;
    }

    public void update() {
        ++this.tick;
        if (this.tick > this.life) {
            switch (this.type) {
                case 1: {
                    this.world.setBlockState(this.pos, Blocks.WATER.getDefaultState(), 1);
                    break;
                }
                case 2: {
                    this.world.setBlockState(this.pos, Blocks.FLOWING_WATER.getDefaultState(), 1);
                    break;
                }
                default: {
                    this.world.setBlockState(this.pos, Blocks.AIR.getDefaultState(), 1);
                }
            }
            this.invalidate();
        }
    }
}
