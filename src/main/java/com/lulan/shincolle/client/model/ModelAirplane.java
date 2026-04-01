package com.lulan.shincolle.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

public class ModelAirplane
extends ModelBase {
    private final ModelRenderer BodyMain;
    private final ModelRenderer EyeL;
    private final ModelRenderer EyeR;
    private final ModelRenderer AirfoilL;
    private final ModelRenderer AirfoilR;
    private final ModelRenderer Head;
    private final ModelRenderer BodyFront;
    private final ModelRenderer Tail;
    private final ModelRenderer Tongue;
    private final ModelRenderer BombL;
    private final ModelRenderer BombR;
    private final ModelRenderer GunBase;
    private final ModelRenderer Gun;
    private final ModelRenderer GlowBodyMain;

    public ModelAirplane() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Head = new ModelRenderer(this, 8, 24);
        this.Head.setRotationPoint(0.0f, 0.0f, -6.2f);
        this.Head.addBox(-2.0f, -2.0f, -2.0f, 4, 4, 4, 0.0f);
        this.setRotateAngle(this.Head, 0.0f, 0.7853982f, 0.0f);
        this.BodyMain = new ModelRenderer(this, 3, 18);
        this.BodyMain.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.BodyMain.addBox(-3.0f, -3.0f, -1.0f, 6, 7, 7, 0.0f);
        this.BombR = new ModelRenderer(this, 0, 0);
        this.BombR.setRotationPoint(-6.0f, 2.3f, -1.0f);
        this.BombR.addBox(0.0f, 0.0f, 0.0f, 2, 2, 6, 0.0f);
        this.setRotateAngle(this.BombR, 0.0f, 0.0f, 0.7853982f);
        this.AirfoilL = new ModelRenderer(this, 0, 17);
        this.AirfoilL.setRotationPoint(3.5f, 0.0f, 0.0f);
        this.AirfoilL.addBox(-2.5f, -2.0f, -6.0f, 5, 4, 11, 0.0f);
        this.setRotateAngle(this.AirfoilL, 0.0f, 0.5235988f, 0.12217305f);
        this.AirfoilR = new ModelRenderer(this, 0, 17);
        this.AirfoilR.setRotationPoint(-3.5f, 0.0f, 0.0f);
        this.AirfoilR.addBox(-2.5f, -2.0f, -6.0f, 5, 4, 11, 0.0f);
        this.setRotateAngle(this.AirfoilR, 0.0f, -0.5235988f, -0.12217305f);
        this.BombL = new ModelRenderer(this, 0, 0);
        this.BombL.setRotationPoint(6.0f, 2.3f, -1.0f);
        this.BombL.addBox(0.0f, 0.0f, 0.0f, 2, 2, 6, 0.0f);
        this.setRotateAngle(this.BombL, 0.0f, 0.0f, 0.7853982f);
        this.EyeL = new ModelRenderer(this, 16, 0);
        this.EyeL.setRotationPoint(3.7f, -3.2f, 2.0f);
        this.EyeL.addBox(-2.0f, 0.0f, -2.0f, 4, 2, 4, 0.0f);
        this.setRotateAngle(this.EyeL, 0.0f, 0.7853982f, 0.17453292f);
        this.EyeR = new ModelRenderer(this, 16, 0);
        this.EyeR.setRotationPoint(-3.7f, -3.2f, 2.0f);
        this.EyeR.addBox(-2.0f, 0.0f, -2.0f, 4, 2, 4, 0.0f);
        this.setRotateAngle(this.EyeR, 0.0f, -2.3561945f, -0.17453292f);
        this.GunBase = new ModelRenderer(this, 10, 24);
        this.GunBase.setRotationPoint(0.0f, 4.0f, 2.5f);
        this.GunBase.addBox(-1.5f, 0.0f, 0.0f, 3, 4, 3, 0.0f);
        this.Tail = new ModelRenderer(this, 0, 19);
        this.Tail.setRotationPoint(0.0f, 0.0f, 4.3f);
        this.Tail.addBox(-4.0f, -2.5f, -4.0f, 8, 5, 8, 0.0f);
        this.setRotateAngle(this.Tail, 0.0f, 0.7853982f, 0.0f);
        this.BodyFront = new ModelRenderer(this, 12, 6);
        this.BodyFront.setRotationPoint(0.0f, 0.0f, -3.2f);
        this.BodyFront.addBox(-2.5f, -2.6f, -2.5f, 5, 6, 5, 0.0f);
        this.setRotateAngle(this.BodyFront, 0.08726646f, 0.0f, 0.0f);
        this.Tongue = new ModelRenderer(this, 0, 13);
        this.Tongue.setRotationPoint(0.0f, 2.3f, -3.5f);
        this.Tongue.addBox(-1.5f, 0.0f, -3.0f, 3, 1, 3, 0.0f);
        this.setRotateAngle(this.Tongue, 1.6580628f, 0.0f, 0.0f);
        this.Gun = new ModelRenderer(this, 0, 0);
        this.Gun.setRotationPoint(0.0f, 2.5f, 0.0f);
        this.Gun.addBox(-0.5f, 0.0f, -8.0f, 1, 1, 8, 0.0f);
        this.setRotateAngle(this.Gun, 0.05235988f, 0.0f, 0.0f);
        this.GlowBodyMain = new ModelRenderer(this, 0, 0);
        this.GlowBodyMain.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.BodyMain.addChild(this.Head);
        this.BodyMain.addChild(this.BombR);
        this.BodyMain.addChild(this.AirfoilL);
        this.BodyMain.addChild(this.AirfoilR);
        this.BodyMain.addChild(this.BombL);
        this.BodyMain.addChild(this.GunBase);
        this.BodyMain.addChild(this.Tail);
        this.BodyMain.addChild(this.BodyFront);
        this.BodyMain.addChild(this.Tongue);
        this.GunBase.addChild(this.Gun);
        this.GlowBodyMain.addChild(this.EyeL);
        this.GlowBodyMain.addChild(this.EyeR);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.scale(0.5f, 0.5f, 0.5f);
        GlStateManager.translate(0.0f, 2.5f, 0.0f);
        this.BodyMain.render(f5);
        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        GlStateManager.enableCull();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        this.GlowBodyMain.render(f5);
        GlStateManager.disableCull();
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
    }
}
