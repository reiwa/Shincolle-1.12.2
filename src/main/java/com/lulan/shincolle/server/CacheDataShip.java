package com.lulan.shincolle.server;

import net.minecraft.nbt.NBTTagCompound;

public class CacheDataShip {
    public int entityID;
    public int worldID;
    public int classID;
    public boolean isDead;
    public int posX;
    public int posY;
    public int posZ;
    public NBTTagCompound entityNBT;

    public CacheDataShip(int eid, int wid, int cid, boolean isDead, double posX, double posY, double posZ, NBTTagCompound nbt) {
        this.entityID = eid;
        this.worldID = wid;
        this.classID = cid;
        this.isDead = isDead;
        this.posX = (int)posX;
        this.posY = (int)posY;
        this.posZ = (int)posZ;
        this.entityNBT = nbt;
    }
}
