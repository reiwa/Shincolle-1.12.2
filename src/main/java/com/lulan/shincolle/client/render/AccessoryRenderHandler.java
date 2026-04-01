package com.lulan.shincolle.client.render;

import com.lulan.shincolle.client.model.ModelPlayerAccessory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class AccessoryRenderHandler {
    private static final ModelPlayerAccessory model = new ModelPlayerAccessory();
    private static final ResourceLocation tex = new ResourceLocation(
            "shincolle", "textures/entity/ModelPlayerAccessory.png"
    );

    @SubscribeEvent
    public static void onRenderWorldLast(RenderWorldLastEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        TextureManager texMgr = mc.getTextureManager();
        RenderManager rm = mc.getRenderManager();
        float partial = event.getPartialTicks();
        for (EntityPlayer ep : mc.world.playerEntities) {
            if (!(ep instanceof AbstractClientPlayer)) continue;
            AbstractClientPlayer player = (AbstractClientPlayer) ep;
            if (!ClientAccessoryData.shouldShow(player)) continue;
            double px = player.lastTickPosX + (player.posX - player.lastTickPosX) * partial;
            double py = player.lastTickPosY + (player.posY - player.lastTickPosY) * partial;
            double pz = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * partial;
            GlStateManager.pushMatrix();
            GlStateManager.translate(
                    px - rm.viewerPosX,
                    py - rm.viewerPosY + (player.isSneaking() ? -0.2F : 0F),
                    pz - rm.viewerPosZ
            );
            float yaw = player.prevRenderYawOffset
                    + (player.renderYawOffset - player.prevRenderYawOffset) * partial;
            GlStateManager.rotate(-yaw, 0F, 1F, 0F);
            texMgr.bindTexture(tex);
            model.render(player, 0, 0, 0, 0, 0, 0.0625F);
            GlStateManager.popMatrix();
        }
    }
}
