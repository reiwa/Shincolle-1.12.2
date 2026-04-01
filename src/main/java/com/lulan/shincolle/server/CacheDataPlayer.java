package com.lulan.shincolle.server;

import net.minecraft.nbt.NBTTagCompound;

public class CacheDataPlayer {
    public int entityID;
    public int worldID;
    public boolean hasTeam;
    public int posX;
    public int posY;
    public int posZ;
    public NBTTagCompound capaNBT;

    public CacheDataPlayer(int eid, int wid, boolean hasTeam, double posX, double posY, double posZ, NBTTagCompound nbt) {
        this.entityID = eid;
        this.worldID = wid;
        this.hasTeam = hasTeam;
        this.posX = (int)posX;
        this.posY = (int)posY;
        this.posZ = (int)posZ;
        this.capaNBT = nbt;
    }
}
