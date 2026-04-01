package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelMountSuH
extends ModelBase
implements IModelEmotion {
    private final ModelRenderer BodyMain;
    private final ModelRenderer Neck;
    private final ModelRenderer Head01;
    private final ModelRenderer Jaw;
    private final ModelRenderer NeckFront;
    private final ModelRenderer Body01;
    private final ModelRenderer Head02;
    private final ModelRenderer Head03;
    private final ModelRenderer Head04;
    private final ModelRenderer Head05;
    private final ModelRenderer Head06;
    private final ModelRenderer Head07a;
    private final ModelRenderer HeadTooth;
    private final ModelRenderer Eye01a;
    private final ModelRenderer Eye01b;
    private final ModelRenderer Eye02a;
    private final ModelRenderer Eye02b;
    private final ModelRenderer Eye03a;
    private final ModelRenderer Eye03b;
    private final ModelRenderer JawTooth;
    private final ModelRenderer Jaw02;
    private final ModelRenderer Body02;
    private final ModelRenderer Body01a;
    private final ModelRenderer Body02a;
    private final ModelRenderer Body02b;
    private final ModelRenderer Body03;
    private final ModelRenderer Body03a;
    private final ModelRenderer Body03b;
    private final ModelRenderer Body04;
    private final ModelRenderer Body04a;
    private final ModelRenderer Body04b;
    private final ModelRenderer Bridge02;
    private final ModelRenderer Bridge01;
    private final ModelRenderer Head07b;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowNeck;
    private final ModelRenderer GlowJaw;
    private final ModelRenderer GlowHead01;

    public ModelMountSuH() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Eye03a = new ModelRenderer(this, 77, 16);
        this.Eye03a.setRotationPoint(9.6f, -9.0f, -15.0f);
        this.Eye03a.addBox(0.0f, 0.0f, 0.0f, 0, 8, 8, 0.0f);
        this.Body04a = new ModelRenderer(this, 0, 0);
        this.Body04a.setRotationPoint(0.0f, -1.0f, 9.5f);
        this.Body04a.addBox(-2.5f, -6.0f, 0.0f, 5, 6, 5, 0.0f);
        this.Head07b = new ModelRenderer(this, 0, 4);
        this.Head07b.setRotationPoint(-0.7f, 5.5f, 0.7f);
        this.Head07b.addBox(-5.0f, 0.0f, -5.0f, 10, 12, 10, 0.0f);
        this.Body01a = new ModelRenderer(this, 0, 0);
        this.Body01a.setRotationPoint(0.0f, -20.7f, 0.0f);
        this.Body01a.addBox(-7.0f, 0.0f, 0.0f, 14, 9, 11, 0.0f);
        this.Head04 = new ModelRenderer(this, 0, 3);
        this.Head04.setRotationPoint(0.0f, -23.9f, -29.9f);
        this.Head04.addBox(-9.5f, 0.0f, 0.0f, 19, 8, 12, 0.0f);
        this.Head06 = new ModelRenderer(this, 0, 3);
        this.Head06.setRotationPoint(0.0f, -12.1f, -40.8f);
        this.Head06.addBox(-7.5f, 0.0f, 0.0f, 15, 6, 11, 0.0f);
        this.JawTooth = new ModelRenderer(this, 57, 46);
        this.JawTooth.mirror = true;
        this.JawTooth.setRotationPoint(0.0f, -1.7f, -2.0f);
        this.JawTooth.addBox(-6.5f, 0.0f, -14.0f, 13, 3, 14, 0.0f);
        this.setRotateAngle(this.JawTooth, -0.08726646f, -0.022340214f, 0.0f);
        this.Bridge02 = new ModelRenderer(this, 0, 0);
        this.Bridge02.setRotationPoint(0.0f, 0.1f, 0.0f);
        this.Bridge02.addBox(-3.0f, 0.0f, 0.0f, 6, 10, 7, 0.0f);
        this.setRotateAngle(this.Bridge02, 1.5707964f, 0.0f, 0.0f);
        this.HeadTooth = new ModelRenderer(this, 56, 45);
        this.HeadTooth.setRotationPoint(0.0f, 2.5f, -15.0f);
        this.HeadTooth.addBox(-6.5f, 0.0f, -6.5f, 13, 4, 15, 0.0f);
        this.setRotateAngle(this.HeadTooth, 0.05235988f, 0.0f, 0.0f);
        this.Body03 = new ModelRenderer(this, 0, 0);
        this.Body03.setRotationPoint(0.0f, -3.0f, 8.0f);
        this.Body03.addBox(-8.0f, -10.0f, 0.0f, 16, 10, 12, 0.0f);
        this.setRotateAngle(this.Body03, -0.17453292f, 0.0f, 0.0f);
        this.Eye03b = new ModelRenderer(this, 77, 16);
        this.Eye03b.setRotationPoint(-9.6f, -9.0f, -15.0f);
        this.Eye03b.addBox(0.0f, 0.0f, 0.0f, 0, 8, 8, 0.0f);
        this.Body03b = new ModelRenderer(this, 0, 0);
        this.Body03b.setRotationPoint(0.0f, -19.9f, -2.0f);
        this.Body03b.addBox(-5.5f, 0.0f, 0.0f, 11, 10, 12, 0.0f);
        this.Bridge01 = new ModelRenderer(this, 0, 44);
        this.Bridge01.setRotationPoint(0.0f, 0.1f, 0.0f);
        this.Bridge01.addBox(-3.5f, 0.0f, 0.0f, 7, 12, 8, 0.0f);
        this.setRotateAngle(this.Bridge01, 1.5707964f, 0.0f, 0.0f);
        this.Body03a = new ModelRenderer(this, 0, 0);
        this.Body03a.setRotationPoint(0.0f, 4.0f, 4.5f);
        this.Body03a.addBox(-6.0f, -6.0f, 0.0f, 12, 6, 11, 0.0f);
        this.setRotateAngle(this.Body03a, 0.43633232f, 0.0f, 0.0f);
        this.Body04b = new ModelRenderer(this, 0, 0);
        this.Body04b.setRotationPoint(0.0f, -15.6f, 6.0f);
        this.Body04b.addBox(-3.5f, 0.0f, 0.0f, 7, 9, 12, 0.0f);
        this.setRotateAngle(this.Body04b, -0.43633232f, 0.0f, 0.0f);
        this.NeckFront = new ModelRenderer(this, 30, 48);
        this.NeckFront.setRotationPoint(0.0f, -8.5f, -15.0f);
        this.NeckFront.addBox(-5.5f, 0.0f, 0.0f, 11, 14, 2, 0.0f);
        this.Head02 = new ModelRenderer(this, 0, 3);
        this.Head02.setRotationPoint(0.0f, -16.0f, -29.9f);
        this.Head02.addBox(-9.5f, 0.0f, 0.0f, 19, 10, 12, 0.0f);
        this.Head07a = new ModelRenderer(this, 0, 4);
        this.Head07a.setRotationPoint(0.0f, -23.8f, -41.7f);
        this.Head07a.addBox(-6.0f, 0.0f, -6.0f, 12, 12, 12, 0.0f);
        this.setRotateAngle(this.Head07a, 0.0f, 0.7853982f, 0.0f);
        this.Eye02b = new ModelRenderer(this, 77, 8);
        this.Eye02b.setRotationPoint(-9.6f, -9.0f, -15.0f);
        this.Eye02b.addBox(0.0f, 0.0f, 0.0f, 0, 8, 8, 0.0f);
        this.Head03 = new ModelRenderer(this, 0, 3);
        this.Head03.setRotationPoint(0.0f, -23.9f, -18.0f);
        this.Head03.addBox(-9.5f, 0.0f, 0.0f, 19, 8, 12, 0.0f);
        this.Eye02a = new ModelRenderer(this, 77, 8);
        this.Eye02a.setRotationPoint(9.6f, -9.0f, -15.0f);
        this.Eye02a.addBox(0.0f, 0.0f, 0.1f, 0, 8, 8, 0.0f);
        this.Head05 = new ModelRenderer(this, 0, 3);
        this.Head05.setRotationPoint(0.0f, -24.0f, -41.8f);
        this.Head05.addBox(-8.5f, 0.0f, 0.0f, 17, 12, 12, 0.0f);
        this.Body04 = new ModelRenderer(this, 0, 0);
        this.Body04.setRotationPoint(0.0f, -1.0f, 11.0f);
        this.Body04.addBox(-4.5f, -8.0f, 0.0f, 9, 8, 10, 0.0f);
        this.setRotateAngle(this.Body04, 0.43633232f, 0.0f, 0.0f);
        this.Jaw02 = new ModelRenderer(this, 0, 0);
        this.Jaw02.setRotationPoint(0.0f, 0.8f, -14.8f);
        this.Jaw02.addBox(-5.5f, 0.0f, -5.5f, 11, 5, 11, 0.0f);
        this.setRotateAngle(this.Jaw02, -0.33161256f, 0.7853982f, -0.24085544f);
        this.Jaw = new ModelRenderer(this, 0, 0);
        this.Jaw.setRotationPoint(0.0f, 2.0f, -11.6f);
        this.Jaw.addBox(-7.5f, 0.0f, -16.0f, 15, 7, 16, 0.0f);
        this.setRotateAngle(this.Jaw, 0.2617994f, 0.0f, 0.0f);
        this.Eye01b = new ModelRenderer(this, 77, 0);
        this.Eye01b.setRotationPoint(-9.6f, -9.0f, -15.0f);
        this.Eye01b.addBox(0.0f, 0.0f, 0.0f, 0, 8, 8, 0.0f);
        this.Body01 = new ModelRenderer(this, 0, 0);
        this.Body01.setRotationPoint(0.0f, -3.0f, -8.3f);
        this.Body01.addBox(-8.5f, -12.0f, 0.0f, 17, 12, 12, 0.0f);
        this.Body02b = new ModelRenderer(this, 0, 3);
        this.Body02b.setRotationPoint(0.0f, -21.8f, -2.0f);
        this.Body02b.addBox(-4.5f, 0.0f, 0.0f, 9, 7, 12, 0.0f);
        this.Body02 = new ModelRenderer(this, 0, 3);
        this.Body02.setRotationPoint(0.0f, 5.0f, 6.0f);
        this.Body02.addBox(-7.0f, -15.0f, 0.0f, 14, 15, 12, 0.0f);
        this.setRotateAngle(this.Body02, -0.2617994f, 0.0f, 0.0f);
        this.Body02a = new ModelRenderer(this, 0, 0);
        this.Body02a.setRotationPoint(0.0f, -2.1f, 0.0f);
        this.Body02a.addBox(-6.5f, 0.0f, 0.0f, 13, 7, 12, 0.0f);
        this.setRotateAngle(this.Body02a, 0.2617994f, 0.0f, 0.0f);
        this.BodyMain = new ModelRenderer(this, 0, 0);
        this.BodyMain.setRotationPoint(0.0f, 10.0f, 8.0f);
        this.BodyMain.addBox(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.Eye01a = new ModelRenderer(this, 77, 0);
        this.Eye01a.setRotationPoint(9.6f, -9.0f, -15.0f);
        this.Eye01a.addBox(0.0f, 0.0f, 0.0f, 0, 8, 8, 0.0f);
        this.Head01 = new ModelRenderer(this, 0, 3);
        this.Head01.setRotationPoint(0.0f, -9.0f, -7.0f);
        this.Head01.addBox(-9.5f, -7.0f, -11.0f, 19, 10, 12, 0.0f);
        this.Neck = new ModelRenderer(this, 0, 0);
        this.Neck.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Neck.addBox(-7.0f, -7.5f, -14.0f, 14, 15, 14, 0.0f);
        this.Body04.addChild(this.Body04a);
        this.Head07a.addChild(this.Head07b);
        this.Body01.addChild(this.Body01a);
        this.Neck.addChild(this.Head04);
        this.Neck.addChild(this.Head06);
        this.Body01a.addChild(this.Bridge02);
        this.Body02.addChild(this.Body03);
        this.Body03.addChild(this.Body03b);
        this.Head03.addChild(this.Bridge01);
        this.Body03.addChild(this.Body03a);
        this.Body04.addChild(this.Body04b);
        this.Neck.addChild(this.Head02);
        this.Neck.addChild(this.Head07a);
        this.Neck.addChild(this.Head03);
        this.Neck.addChild(this.Head05);
        this.Body03.addChild(this.Body04);
        this.Jaw.addChild(this.Jaw02);
        this.Neck.addChild(this.Jaw);
        this.Neck.addChild(this.Body01);
        this.Body02.addChild(this.Body02b);
        this.Body01.addChild(this.Body02);
        this.Body02.addChild(this.Body02a);
        this.Neck.addChild(this.Head01);
        this.BodyMain.addChild(this.Neck);
        this.GlowBodyMain = new ModelRenderer(this, 0, 0);
        this.GlowBodyMain.setRotationPoint(0.0f, 10.0f, 8.0f);
        this.GlowNeck = new ModelRenderer(this, 0, 0);
        this.GlowNeck.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.GlowJaw = new ModelRenderer(this, 0, 0);
        this.GlowJaw.setRotationPoint(0.0f, 2.0f, -11.6f);
        this.setRotateAngle(this.GlowJaw, 0.2617994f, 0.0f, 0.0f);
        this.GlowHead01 = new ModelRenderer(this, 0, 3);
        this.GlowHead01.setRotationPoint(0.0f, -9.0f, -7.0f);
        this.GlowBodyMain.addChild(this.GlowNeck);
        this.GlowNeck.addChild(this.GlowJaw);
        this.GlowJaw.addChild(this.JawTooth);
        this.GlowNeck.addChild(this.GlowHead01);
        this.GlowHead01.addChild(this.HeadTooth);
        this.GlowNeck.addChild(this.NeckFront);
        this.GlowHead01.addChild(this.Eye01a);
        this.GlowHead01.addChild(this.Eye01b);
        this.GlowHead01.addChild(this.Eye02a);
        this.GlowHead01.addChild(this.Eye02b);
        this.GlowHead01.addChild(this.Eye03a);
        this.GlowHead01.addChild(this.Eye03b);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        if (f3 <= -180.0f) {
            f3 += 360.0f;
        } else if (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.scale(0.6f, 0.6f, 0.6f);
        GlStateManager.translate(0.0f, 1.0f, 0.0f);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.BodyMain.render(f5);
        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        this.GlowBodyMain.render(f5);
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        IShipEmotion ent = (IShipEmotion)entity;
        EmotionHelper.rollEmotion(this, ent);
        this.motionHumanPos(f, f1, f2, ent);
        this.syncRotationGlowPart();
    }

    private void motionHumanPos(float f, float f1, float f2, IShipEmotion ent) {
        float angleX = MathHelper.cos(f2 * 0.08f);
        float angleX2 = MathHelper.cos(-f * 0.8f + 0.7f);
        if (ent.getShipDepth(0) > 0.0) {
            GlStateManager.translate(0.0f, angleX * 0.025f + 0.025f, 0.0f);
        }
        this.Jaw.rotateAngleX = angleX * 0.075f + 0.26f;
        this.Body04.rotateAngleY = angleX * 0.15f;
        if (ent.getIsSprinting() || f1 > 0.9f) {
            this.Body03.rotateAngleY = angleX2 * 0.075f;
            this.Body04.rotateAngleY = angleX2 * 0.15f;
        }
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowJaw.rotateAngleX = this.Jaw.rotateAngleX;
    }

    @Override
    public void setFace(int emo) {
        switch (emo) {
            case 0: {
                this.Eye01a.isHidden = true;
                this.Eye01b.isHidden = true;
                this.Eye02a.isHidden = false;
                this.Eye02b.isHidden = false;
                this.Eye03a.isHidden = true;
                this.Eye03b.isHidden = true;
                break;
            }
            case 1: {
                this.Eye01a.isHidden = true;
                this.Eye01b.isHidden = true;
                this.Eye02a.isHidden = true;
                this.Eye02b.isHidden = true;
                this.Eye03a.isHidden = false;
                this.Eye03b.isHidden = false;
                break;
            }
            default: {
                this.Eye01a.isHidden = false;
                this.Eye01b.isHidden = false;
                this.Eye02a.isHidden = true;
                this.Eye02b.isHidden = true;
                this.Eye03a.isHidden = true;
                this.Eye03b.isHidden = true;
            }
        }
    }

    @Override
    public void showEquip(IShipEmotion ent) {
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void setField(int id, float value) {
    }

    @Override
    public float getField(int id) {
        return 0.0f;
    }
}
