package com.lulan.shincolle.client.render;

import com.lulan.shincolle.entity.other.EntityFleetController;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

public class RenderFleetController extends Render<EntityFleetController> {

    public RenderFleetController(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    public void doRender(EntityFleetController entity, double x, double y, double z, float entityYaw, float partialTicks) {
        /*GlStateManager.pushMatrix();
        GlStateManager.depthMask(false);
        GlStateManager.translate(x, y + 0.1, z);
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks + 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        float arrowLength = 6.0F;
        float arrowWidth = 2.0F;
        GlStateManager.color(1.0F, 0.0F, 0.0F, 0.6F);
        bufferbuilder.begin(GL11.GL_TRIANGLES, DefaultVertexFormats.POSITION);
        bufferbuilder.pos(arrowLength, 0, 0).endVertex();
        bufferbuilder.pos(0, 0, -arrowWidth).endVertex();
        bufferbuilder.pos(0, 0, arrowWidth).endVertex();
        tessellator.draw();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.depthMask(true);
        GlStateManager.popMatrix();*/
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFleetController entity) {
        return null;
    }
}