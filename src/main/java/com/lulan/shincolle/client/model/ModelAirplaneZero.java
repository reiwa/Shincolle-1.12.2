package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

public class ModelAirplaneZero
extends ModelBase {
    private final ModelRenderer BodyMain;
    private final ModelRenderer Tail01;
    private final ModelRenderer Wing01;
    private final ModelRenderer Wing02;
    private final ModelRenderer BodyU;
    private final ModelRenderer Propeller;
    private final ModelRenderer Prop02;
    private final ModelRenderer Tank;
    private final ModelRenderer Tail02;
    private final ModelRenderer Tail03;
    private final ModelRenderer Tail04;
    private final ModelRenderer GlowBodyMain;

    public ModelAirplaneZero() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.BodyMain = new ModelRenderer(this, 0, 17);
        this.BodyMain.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.BodyMain.addBox(-2.0f, -3.0f, -6.0f, 4, 4, 11, 0.0f);
        this.Tail03 = new ModelRenderer(this, 0, 17);
        this.Tail03.setRotationPoint(0.0f, -2.2f, 4.5f);
        this.Tail03.addBox(-0.5f, 0.0f, 0.0f, 1, 4, 3, 0.0f);
        this.setRotateAngle(this.Tail03, -1.0471976f, 0.0f, 0.0f);
        this.Propeller = new ModelRenderer(this, 0, 6);
        this.Propeller.setRotationPoint(0.0f, -1.0f, -6.5f);
        this.Propeller.addBox(-3.0f, -3.0f, 0.0f, 6, 6, 0, 0.0f);
        this.Wing02 = new ModelRenderer(this, 0, 0);
        this.Wing02.setRotationPoint(-2.0f, -0.4f, -3.2f);
        this.Wing02.addBox(-13.0f, 0.0f, 0.0f, 13, 1, 5, 0.0f);
        this.setRotateAngle(this.Wing02, 0.0f, 0.0f, 0.06981317f);
        this.Prop02 = new ModelRenderer(this, 0, 24);
        this.Prop02.setRotationPoint(0.0f, -1.0f, -7.5f);
        this.Prop02.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2, 0.0f);
        this.Tail04 = new ModelRenderer(this, 0, 13);
        this.Tail04.setRotationPoint(0.0f, 0.2f, 2.0f);
        this.Tail04.addBox(-6.5f, 0.0f, 0.0f, 13, 1, 3, 0.0f);
        this.Tail01 = new ModelRenderer(this, 30, 25);
        this.Tail01.setRotationPoint(0.0f, -2.8f, 5.0f);
        this.Tail01.addBox(-2.0f, 0.0f, 0.0f, 4, 3, 4, 0.0f);
        this.Wing01 = new ModelRenderer(this, 0, 0);
        this.Wing01.mirror = true;
        this.Wing01.setRotationPoint(2.0f, -0.4f, -3.2f);
        this.Wing01.addBox(0.0f, 0.0f, 0.0f, 13, 1, 5, 0.0f);
        this.setRotateAngle(this.Wing01, 0.0f, 0.0f, -0.06981317f);
        this.Tail02 = new ModelRenderer(this, 46, 24);
        this.Tail02.setRotationPoint(0.0f, 0.1f, 4.0f);
        this.Tail02.addBox(-1.5f, 0.0f, 0.0f, 3, 2, 6, 0.0f);
        this.BodyU = new ModelRenderer(this, 19, 17);
        this.BodyU.setRotationPoint(0.0f, -4.9f, -1.8f);
        this.BodyU.addBox(-1.5f, 0.0f, 0.0f, 3, 2, 6, 0.0f);
        this.setRotateAngle(this.BodyU, -0.31415927f, 0.0f, 0.0f);
        this.Tank = new ModelRenderer(this, 14, 7);
        this.Tank.setRotationPoint(0.0f, 0.5f, -3.0f);
        this.Tank.addBox(-1.0f, 0.0f, 0.0f, 2, 2, 4, 0.0f);
        this.Tail02.addChild(this.Tail03);
        this.BodyMain.addChild(this.Propeller);
        this.BodyMain.addChild(this.Wing02);
        this.BodyMain.addChild(this.Prop02);
        this.Tail02.addChild(this.Tail04);
        this.BodyMain.addChild(this.Tail01);
        this.BodyMain.addChild(this.Wing01);
        this.Tail01.addChild(this.Tail02);
        this.BodyMain.addChild(this.BodyU);
        this.BodyMain.addChild(this.Tank);
        this.GlowBodyMain = new ModelRenderer(this, 0, 17);
        this.GlowBodyMain.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.GlowBodyMain.addChild(this.BodyU);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        if (f3 <= -180.0f) {
            f3 += 360.0f;
        } else if (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        float scale;
        float offsetY;
        switch (((IShipEmotion)entity).getScaleLevel()) {
            case 3: {
                scale = 1.6f;
                offsetY = 0.37f;
                break;
            }
            case 2: {
                scale = 1.2f;
                offsetY = 0.68f;
                break;
            }
            case 1: {
                scale = 0.8f;
                offsetY = 1.32f;
                break;
            }
            default: {
                scale = 0.4f;
                offsetY = 3.22f;
            }
        }
        if (entity.ticksExisted > 6) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            GlStateManager.scale(scale, scale, scale);
            GlStateManager.translate(0.0f, offsetY, 0.0f);
            this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.BodyMain.rotateAngleY = f3 / 57.0f;
        this.BodyMain.rotateAngleX = f4 / 57.0f;
        this.GlowBodyMain.rotateAngleY = this.BodyMain.rotateAngleY;
        this.GlowBodyMain.rotateAngleX = this.BodyMain.rotateAngleX;
    }
}
