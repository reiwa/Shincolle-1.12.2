package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.network.S2CGUIPackets;
import com.lulan.shincolle.proxy.CommonProxy;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BasicTileEntity
extends TileEntity {

    public int getRenderMetadata() {
        if (this.world == null || this.pos == BlockPos.ORIGIN) {
            return -1;
        }
        return this.getBlockMetadata();
    }

    public void sendSyncPacket() {
        if (!this.world.isRemote && this.getPacketID(0) >= 0) {
            NetworkRegistry.TargetPoint point = new NetworkRegistry.TargetPoint(this.world.provider.getDimension(), this.pos.getX(), this.pos.getY(), this.pos.getZ(), 64.0);
            CommonProxy.channelG.sendToAllAround(new S2CGUIPackets(this, this.getPacketID(0)), point);
        }
    }

    public void sendSyncPacketC2S() {}

    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
        return false;
    }

    public byte getGuiIntID() {
        return -1;
    }

    public byte getPacketID(int type) {
        return -1;
    }

    public abstract String getRegName();

    public ITextComponent getDisplayName() {
        return new TextComponentString("tile.shincolle:" + this.getRegName());
    }

    public void setField(int id, int value) {}

    public int getFieldCount() {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        return new AxisAlignedBB(getPos().add(-1, -1, -1), getPos().add(2, 2, 2));
    }
}
