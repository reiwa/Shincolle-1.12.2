package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.entity.IShipOwner;
import net.minecraft.util.math.BlockPos;

public interface ITileWaypoint
extends IShipOwner,
ITileGuardPoint {
    void setLastWaypoint(BlockPos var1);

    BlockPos getLastWaypoint();

    void setNextWaypoint(BlockPos var1);

    BlockPos getNextWaypoint();

    int getWpStayTime();

    void setPairedChest(BlockPos var1);

    BlockPos getPairedChest();
}
