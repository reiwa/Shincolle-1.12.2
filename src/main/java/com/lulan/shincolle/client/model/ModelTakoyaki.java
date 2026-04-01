package com.lulan.shincolle.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelTakoyaki
extends ModelBase {
    private final ModelRenderer BodyMain;
    private final ModelRenderer JawMain;
    private final ModelRenderer EyeL;
    private final ModelRenderer Body1;
    private final ModelRenderer Body2;
    private final ModelRenderer Body3;
    private final ModelRenderer EarL;
    private final ModelRenderer EarR;
    private final ModelRenderer Jaw1;
    private final ModelRenderer Jaw2;
    private final ModelRenderer Jaw3;
    private final ModelRenderer Tongue;
    private final ModelRenderer GlowBodyMain;

    public ModelTakoyaki() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.JawMain = new ModelRenderer(this, 0, 38);
        this.JawMain.setRotationPoint(0.0f, 3.5f, 3.0f);
        this.JawMain.addBox(-6.5f, -1.1f, -8.0f, 13, 6, 13, 0.0f);
        this.setRotateAngle(this.JawMain, 1.3f, 0.0f, 0.0f);
        this.Jaw1 = new ModelRenderer(this, 0, 17);
        this.Jaw1.setRotationPoint(0.0f, -1.2f, -9.5f);
        this.Jaw1.addBox(-5.0f, 0.0f, 0.0f, 10, 5, 16, 0.0f);
        this.EyeL = new ModelRenderer(this, 65, 50);
        this.EyeL.setRotationPoint(8.1f, -3.3f, 0.5f);
        this.EyeL.addBox(0.0f, -3.0f, -3.0f, 0, 5, 5, 0.0f);
        this.setRotateAngle(this.EyeL, -0.17453292f, 0.0f, 0.0f);
        this.Body1 = new ModelRenderer(this, 76, 19);
        this.Body1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Body1.addBox(-5.0f, -4.3f, -8.0f, 10, 7, 16, 0.0f);
        this.Body3 = new ModelRenderer(this, 76, 1);
        this.Body3.setRotationPoint(0.0f, -0.5f, 0.0f);
        this.Body3.addBox(-8.0f, -5.0f, -5.0f, 16, 8, 10, 0.0f);
        this.Jaw2 = new ModelRenderer(this, 0, 2);
        this.Jaw2.setRotationPoint(0.0f, -1.0f, -6.5f);
        this.Jaw2.addBox(-8.0f, 0.0f, 0.0f, 16, 5, 10, 0.0f);
        this.Jaw3 = new ModelRenderer(this, 42, 0);
        this.Jaw3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Jaw3.addBox(-5.0f, 5.0f, -5.5f, 10, 2, 9, 0.0f);
        this.BodyMain = new ModelRenderer(this, 76, 42);
        this.BodyMain.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.BodyMain.addBox(-6.5f, -6.4f, -6.5f, 13, 9, 13, 0.0f);
        this.setRotateAngle(this.BodyMain, -0.34906584f, 0.0f, 0.0f);
        this.Body2 = new ModelRenderer(this, 54, 19);
        this.Body2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Body2.addBox(-5.0f, -8.5f, -4.5f, 10, 2, 9, 0.0f);
        this.setRotateAngle(this.Body2, 0.0f, 0.0f, -0.013613569f);
        this.EarL = new ModelRenderer(this, 114, 20);
        this.EarL.mirror = true;
        this.EarL.setRotationPoint(5.5f, -4.5f, 3.0f);
        this.EarL.addBox(-2.0f, -8.0f, -1.5f, 4, 8, 3, 0.0f);
        this.setRotateAngle(this.EarL, -0.5235988f, -0.5235988f, 0.7853982f);
        this.Tongue = new ModelRenderer(this, 50, 39);
        this.Tongue.setRotationPoint(0.0f, -2.0f, 0.5f);
        this.Tongue.addBox(-4.5f, 0.0f, -7.0f, 9, 3, 7, 0.0f);
        this.setRotateAngle(this.Tongue, -0.08726646f, 0.0f, 0.0f);
        this.EarR = new ModelRenderer(this, 114, 20);
        this.EarR.setRotationPoint(-5.5f, -4.5f, 3.0f);
        this.EarR.addBox(-2.0f, -8.0f, -1.5f, 4, 8, 3, 0.0f);
        this.setRotateAngle(this.EarR, -0.5235988f, 0.5235988f, -0.7853982f);
        this.GlowBodyMain = new ModelRenderer(this, 0, 0);
        this.GlowBodyMain.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.JawMain.addChild(this.Jaw1);
        this.BodyMain.addChild(this.Body1);
        this.BodyMain.addChild(this.JawMain);
        this.BodyMain.addChild(this.Body3);
        this.JawMain.addChild(this.Jaw2);
        this.JawMain.addChild(this.Jaw3);
        this.BodyMain.addChild(this.Body2);
        this.BodyMain.addChild(this.EarL);
        this.JawMain.addChild(this.Tongue);
        this.BodyMain.addChild(this.EarR);
        this.GlowBodyMain.addChild(this.EyeL);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.scale(0.45f, 0.45f, 0.45f);
        GlStateManager.translate(0.0f, 2.7f, 0.0f);
        this.BodyMain.render(f5);
        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        this.GlowBodyMain.render(f5);
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.BodyMain.rotateAngleY = f3 / 57.0f;
        this.BodyMain.rotateAngleX = f4 / 57.0f;
        this.GlowBodyMain.rotateAngleY = f3 / 57.0f;
        this.GlowBodyMain.rotateAngleX = f4 / 57.0f;
        this.JawMain.rotateAngleZ = 0.0f;
        this.JawMain.rotateAngleX = MathHelper.cos(entity.ticksExisted * 0.125f) * 0.2f + 1.1f;
    }
}
