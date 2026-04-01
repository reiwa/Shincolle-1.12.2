package com.lulan.shincolle.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

public class ModelVortex
extends ModelBase {
    private final ModelRenderer Vortex;

    public ModelVortex() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.Vortex = new ModelRenderer(this, 0, 0);
        this.Vortex.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Vortex.addBox(-64.0f, -64.0f, 0.0f, 128, 128, 0, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushAttrib();
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableLighting();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        this.Vortex.render(f5);
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public void render(float f5) {
        this.render(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
