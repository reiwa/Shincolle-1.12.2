package com.lulan.shincolle.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelBasicEntityItem
extends ModelBase {
    private final ModelRenderer shape1;

    public ModelBasicEntityItem() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0f, 10.1f, 0.0f);
        this.shape1.addBox(-8.0f, -8.0f, -8.0f, 16, 16, 16, 0.0f);
        this.setRotateAngle(this.shape1, 1.275f, 0.592f, 0.774f);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushAttrib();
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableLighting();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        float f6 = MathHelper.cos(f * 0.12f) * 0.5f;
        float f7 = f6 < 0.0f ? 0.9f + f6 : 0.9f - f6;
        float f8 = f6 < 0.0f ? 0.25f - f6 * 0.5f : 0.25f + f6 * 1.25f;
        GlStateManager.scale(f8, f8, f8);
        GlStateManager.color(1.0f, 1.0f, 1.0f, f7);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.shape1.render(f5);
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.popAttrib();
        GlStateManager.popMatrix();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.shape1.rotateAngleX = f % 360.0f * 0.1f;
        this.shape1.rotateAngleY = f % 360.0f * 0.1f;
    }
}
