package com.lulan.shincolle.proxy;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.capability.CapaTeitokuStorage;
import com.lulan.shincolle.capability.ICapaTeitoku;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.network.*;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public abstract class CommonProxy
implements IProxy {
    public static final String chNameEnt = "scEnt";
    public static final String chNameGui = "scGui";
    public static final String chNamePar = "scPar";
    public static final String chNameIn = "scIn";
    public static SimpleNetworkWrapper channelE;
    public static SimpleNetworkWrapper channelG;
    public static SimpleNetworkWrapper channelP;
    public static SimpleNetworkWrapper channelI;
    public static boolean isMultiplayer;
    public static boolean activeBaubles;
    public static boolean activeIC2;
    public static boolean activeMetamorph;
    public static float[] entityItemList;

    @Override
    public void registerChannel() {
        channelE = NetworkRegistry.INSTANCE.newSimpleChannel(chNameEnt);
        channelG = NetworkRegistry.INSTANCE.newSimpleChannel(chNameGui);
        channelP = NetworkRegistry.INSTANCE.newSimpleChannel(chNamePar);
        channelI = NetworkRegistry.INSTANCE.newSimpleChannel(chNameIn);
        channelE.registerMessage(S2CEntitySync.Handler.class, S2CEntitySync.class, 1, Side.CLIENT);
        channelP.registerMessage(S2CSpawnParticle.Handler.class, S2CSpawnParticle.class, 2, Side.CLIENT);
        channelG.registerMessage(S2CGUIPackets.Handler.class, S2CGUIPackets.class, 4, Side.CLIENT);
        channelG.registerMessage(C2SGUIPackets.Handler.class, C2SGUIPackets.class, 3, Side.SERVER);
        channelI.registerMessage(S2CReactPackets.Handler.class, S2CReactPackets.class, 7, Side.CLIENT);
        channelI.registerMessage(C2SInputPackets.Handler.class, C2SInputPackets.class, 6, Side.SERVER);
    }

    @Override
    public void registerCapability() {
        CapabilityManager.INSTANCE.register(ICapaTeitoku.class, new CapaTeitokuStorage(), CapaTeitoku.class);
    }

    public static void checkModLoaded() {
        if (Loader.isModLoaded("Baubles")) {
            LogHelper.info("INFO : Enabled mod support: Baubles");
            activeBaubles = true;
        }
        if (Loader.isModLoaded("IC2") && ConfigHandler.enableIC2) {
            LogHelper.info("INFO : Enabled mod support: IC2");
            activeIC2 = true;
        }
        if (Loader.isModLoaded("metamorph")) {
            LogHelper.info("INFO : Enabled mod support: metamorph");
            activeMetamorph = true;
        }
    }

    static {
        isMultiplayer = false;
        activeBaubles = false;
        activeIC2 = false;
        activeMetamorph = false;
        entityItemList = null;
    }
}
