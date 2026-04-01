package com.lulan.shincolle.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelFloatingFort
extends ModelBase {
    private final ModelRenderer BodyMain;
    private final ModelRenderer Body1;
    private final ModelRenderer Body2;
    private final ModelRenderer Body3;
    private final ModelRenderer EarL;
    private final ModelRenderer EarR;
    private final ModelRenderer JawMain;
    private final ModelRenderer Jaw1;
    private final ModelRenderer Jaw2;
    private final ModelRenderer Jaw3;

    public ModelFloatingFort() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Jaw2 = new ModelRenderer(this, 1, 3);
        this.Jaw2.setRotationPoint(0.0f, -1.0f, -10.0f);
        this.Jaw2.addBox(-7.5f, 0.0f, 0.0f, 15, 4, 9, 0.0f);
        this.BodyMain = new ModelRenderer(this, 76, 43);
        this.BodyMain.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.BodyMain.addBox(-6.5f, -6.4f, -6.5f, 13, 8, 13, 0.0f);
        this.setRotateAngle(this.BodyMain, 0.22759093f, 0.0f, 0.0f);
        this.Body1 = new ModelRenderer(this, 76, 20);
        this.Body1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Body1.addBox(-5.0f, -4.3f, -8.0f, 10, 6, 16, 0.0f);
        this.Jaw3 = new ModelRenderer(this, 42, 0);
        this.Jaw3.setRotationPoint(0.0f, -0.1f, -9.5f);
        this.Jaw3.addBox(-5.0f, 4.0f, 0.0f, 10, 1, 9, 0.0f);
        this.Body3 = new ModelRenderer(this, 76, 2);
        this.Body3.setRotationPoint(0.0f, -0.5f, 0.0f);
        this.Body3.addBox(-8.0f, -5.0f, -5.0f, 16, 7, 10, 0.0f);
        this.JawMain = new ModelRenderer(this, 1, 39);
        this.JawMain.setRotationPoint(0.0f, 2.8f, 6.0f);
        this.JawMain.addBox(-6.0f, -1.1f, -11.5f, 12, 5, 12, 0.0f);
        this.setRotateAngle(this.JawMain, 0.5235988f, 0.0f, 0.0f);
        this.Body2 = new ModelRenderer(this, 54, 19);
        this.Body2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Body2.addBox(-5.0f, -8.5f, -4.5f, 10, 2, 9, 0.0f);
        this.setRotateAngle(this.Body2, 0.0f, 0.0f, -0.013613569f);
        this.EarR = new ModelRenderer(this, 114, 20);
        this.EarR.setRotationPoint(-5.0f, -5.5f, 0.7f);
        this.EarR.addBox(-2.0f, -6.0f, -2.0f, 4, 6, 4, 0.0f);
        this.setRotateAngle(this.EarR, -0.17453292f, -0.7853982f, -0.08726646f);
        this.Jaw1 = new ModelRenderer(this, 1, 18);
        this.Jaw1.setRotationPoint(0.0f, -1.2f, -13.0f);
        this.Jaw1.addBox(-4.5f, 0.0f, 0.0f, 9, 4, 15, 0.0f);
        this.EarL = new ModelRenderer(this, 114, 20);
        this.EarL.mirror = true;
        this.EarL.setRotationPoint(5.0f, -5.5f, 0.7f);
        this.EarL.addBox(-2.0f, -6.0f, -2.0f, 4, 6, 4, 0.0f);
        this.setRotateAngle(this.EarL, -0.17453292f, 0.7853982f, 0.08726646f);
        this.JawMain.addChild(this.Jaw2);
        this.BodyMain.addChild(this.Body1);
        this.JawMain.addChild(this.Jaw3);
        this.BodyMain.addChild(this.Body3);
        this.BodyMain.addChild(this.JawMain);
        this.BodyMain.addChild(this.Body2);
        this.BodyMain.addChild(this.EarR);
        this.JawMain.addChild(this.Jaw1);
        this.BodyMain.addChild(this.EarL);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.scale(0.3f, 0.3f, 0.3f);
        GlStateManager.translate(0.0f, 4.2f, 0.0f);
        this.BodyMain.render(f5);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.BodyMain.rotateAngleY = f3 * 0.0174533f;
        this.BodyMain.rotateAngleX = f4 * 0.0174533f;
        this.JawMain.rotateAngleZ = 0.0f;
        this.JawMain.rotateAngleX = MathHelper.cos(f2) * 0.25f + 0.375f;
    }
}
