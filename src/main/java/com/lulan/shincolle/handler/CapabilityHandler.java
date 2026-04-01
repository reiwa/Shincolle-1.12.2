package com.lulan.shincolle.handler;

import com.lulan.shincolle.capability.CapaTeitokuProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
    public static final ResourceLocation CAPA_TEITOKU_NAME = new ResourceLocation("shincolle", "TeitokuExtProps");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer && !(event.getObject() instanceof FakePlayer)) {
            event.addCapability(CAPA_TEITOKU_NAME, new CapaTeitokuProvider());
        }
    }
}
