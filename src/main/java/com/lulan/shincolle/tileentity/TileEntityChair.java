package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.entity.other.EntitySeat;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldServer;

import java.util.UUID;

public class TileEntityChair
extends BasicTileEntity {
    private EntitySeat seatEntity;
    private UUID seatEntityUUID;

    @Override
    public String getRegName() {
        return "TileEntityChair";
    }

    public boolean isOccupied() {
        if (this.seatEntity != null) {
            return !this.seatEntity.getPassengers().isEmpty();
        }
        return false;
    }

    public void sit(Entity entity) {
        if (this.world.isRemote) {
            return;
        }
        if (this.isOccupied()) {
            return;
        }
        if (this.seatEntity == null || this.seatEntity.isDead) {
            this.seatEntity = new EntitySeat(this.world);
            this.seatEntity.setPosition(this.pos.getX() + 0.5D, this.pos.getY() + 0.25D, this.pos.getZ() + 0.5D);
            this.world.spawnEntity(this.seatEntity);
            this.seatEntityUUID = this.seatEntity.getUniqueID();
        }
        entity.startRiding(this.seatEntity, true);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasUniqueId("SeatUUID")) {
            this.seatEntityUUID = compound.getUniqueId("SeatUUID");
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        if (this.seatEntityUUID != null) {
            compound.setUniqueId("SeatUUID", this.seatEntityUUID);
        }
        return compound;
    }

    public void update() {
        if (!world.isRemote && this.seatEntity == null && this.seatEntityUUID != null) {
            Entity e = ((WorldServer) this.world).getEntityFromUuid(this.seatEntityUUID);
            if (e instanceof EntitySeat) {
                this.seatEntity = (EntitySeat) e;
            } else {
                this.seatEntityUUID = null;
            }
        }
        if (this.seatEntity != null && !this.world.isRemote && this.seatEntity.ticksExisted > 20) {
            if (this.seatEntity.getPassengers().isEmpty()) {
                this.seatEntity.setDead();
                this.seatEntity = null;
                this.seatEntityUUID = null;
            }
        }
    }
}