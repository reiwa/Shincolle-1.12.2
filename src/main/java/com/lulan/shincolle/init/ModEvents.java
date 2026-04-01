package com.lulan.shincolle.init;

import com.lulan.shincolle.handler.CapabilityHandler;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.handler.EventHandler;
import com.lulan.shincolle.item.BucketRepair;
import net.minecraftforge.common.MinecraftForge;

public class ModEvents {
    private ModEvents() {}

    public static void init() {
        MinecraftForge.EVENT_BUS.register(new ConfigHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new BucketRepair());
    }
}
