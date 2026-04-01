package com.lulan.shincolle.handler;

import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class NameTagRenderHandler {
    @SubscribeEvent
    public void onRenderNameTag(RenderLivingEvent.Specials.Pre event) {
        event.setCanceled(true);
    }
}