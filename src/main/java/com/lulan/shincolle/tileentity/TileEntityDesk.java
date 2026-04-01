package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.network.C2SGUIPackets;
import com.lulan.shincolle.proxy.CommonProxy;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityDesk
extends BasicTileEntity {
    private int guiFunc = 0;
    private int radar_zoomLv = 0;
    private int book_chap = 0;
    private int book_page = 0;

    @Override
    public String getRegName() {
        return "TileEntityDesk";
    }

    @Override
    public byte getGuiIntID() {
        return 3;
    }

    public byte getPacketID(int type) {
        if(type == 0){
            return 2;
        }
        return -1;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.guiFunc = nbt.getInteger("guiFunc");
        this.radar_zoomLv = nbt.getInteger("radarZoom");
        this.book_chap = nbt.getInteger("bookChap");
        this.book_page = nbt.getInteger("bookPage");
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("guiFunc", this.guiFunc);
        nbt.setInteger("radarZoom", this.radar_zoomLv);
        nbt.setInteger("bookChap", this.book_chap);
        nbt.setInteger("bookPage", this.book_page);
        return nbt;
    }

    @Override
    public void sendSyncPacketC2S() {
        if (this.world.isRemote) {
            int[] data = new int[]{this.guiFunc, this.book_chap, this.book_page, this.radar_zoomLv};
            CommonProxy.channelG.sendToServer(new C2SGUIPackets(this, (byte)77, data));
        }
    }

    public int getField(int id) {
        switch (id) {
            case 0: {
                return this.guiFunc;
            }
            case 1: {
                return this.book_chap;
            }
            case 2: {
                return this.book_page;
            }
            case 3: {
                return this.radar_zoomLv;
            }
            default:
        }
        return 0;
    }

    @Override
    public void setField(int id, int value) {
        switch (id) {
            case 0: {
                this.guiFunc = value;
                break;
            }
            case 1: {
                this.book_chap = value;
                break;
            }
            case 2: {
                this.book_page = value;
                break;
            }
            case 3: {
                this.radar_zoomLv = value;
                break;
            }
            default:
        }
    }

    @Override
    public int getFieldCount() {
        return 4;
    }
}
