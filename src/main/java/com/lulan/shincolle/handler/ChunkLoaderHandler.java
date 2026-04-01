package com.lulan.shincolle.handler;

import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;

import java.util.List;

public class ChunkLoaderHandler
implements ForgeChunkManager.LoadingCallback {
    public void ticketsLoaded(List<ForgeChunkManager.Ticket> tickets, World world) {
        LogHelper.debug("DEBUG : release all saved chunk loader tickets");
        if (tickets != null) {
            for (ForgeChunkManager.Ticket t : tickets) {
                ForgeChunkManager.releaseTicket(t);
            }
        }
    }
}
