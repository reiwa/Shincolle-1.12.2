package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelDestroyerRo
extends ModelBase
implements IModelEmotion {
    private final ModelRenderer Back;
    private final ModelRenderer NeckBack;
    private final ModelRenderer Body;
    private final ModelRenderer TailBack;
    private final ModelRenderer LegLeftFront;
    private final ModelRenderer LegRightFront;
    private final ModelRenderer BodyTurbine;
    private final ModelRenderer Head;
    private final ModelRenderer NeckBody;
    private final ModelRenderer HeadD03;
    private final ModelRenderer HeadU01;
    private final ModelRenderer HeadD01;
    private final ModelRenderer FaceL00;
    private final ModelRenderer FaceL01;
    private final ModelRenderer FaceL02;
    private final ModelRenderer FaceR00;
    private final ModelRenderer FaceR01;
    private final ModelRenderer FaceR02;
    private final ModelRenderer k00;
    private final ModelRenderer HeadD04;
    private final ModelRenderer UpperTooth;
    private final ModelRenderer HeadU02;
    private final ModelRenderer LowerTooth;
    private final ModelRenderer k01;
    private final ModelRenderer k02;
    private final ModelRenderer k03;
    private final ModelRenderer tube01;
    private final ModelRenderer tube02;
    private final ModelRenderer tube03;
    private final ModelRenderer TailEnd;
    private final ModelRenderer TailBack01;
    private final ModelRenderer TailBack02;
    private final ModelRenderer LegLeftEnd;
    private final ModelRenderer LegRightEnd;
    private final ModelRenderer GlowBack;
    private final ModelRenderer GlowNeckBack;
    private final ModelRenderer GlowHead;

    public ModelDestroyerRo() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.LowerTooth = new ModelRenderer(this, 0, 0);
        this.LowerTooth.setRotationPoint(0.0f, 9.5f, -5.5f);
        this.LowerTooth.addBox(-12.0f, 0.0f, 0.0f, 24, 10, 20, 0.0f);
        this.LowerTooth.mirror = true;
        this.setRotateAngle(this.LowerTooth, -3.4906585f, 0.0f, 0.0f);
        this.k02 = new ModelRenderer(this, 72, 102);
        this.k02.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.k02.addBox(0.8f, -25.0f, -0.7f, 3, 18, 8, 0.0f);
        this.setRotateAngle(this.k02, -1.3962634f, 0.0f, 0.0f);
        this.TailBack = new ModelRenderer(this, 12, 38);
        this.TailBack.setRotationPoint(0.0f, -2.0f, 11.0f);
        this.TailBack.addBox(-10.0f, -8.0f, 0.0f, 20, 14, 22, 0.0f);
        this.setRotateAngle(this.TailBack, -0.08726646f, 0.0f, 0.0f);
        this.LegRightEnd = new ModelRenderer(this, 24, 106);
        this.LegRightEnd.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.LegRightEnd.addBox(-3.0f, -3.0f, -3.0f, 6, 14, 6, 0.0f);
        this.setRotateAngle(this.LegRightEnd, 0.5235988f, 0.0f, 0.0f);
        this.TailBack02 = new ModelRenderer(this, 30, 40);
        this.TailBack02.setRotationPoint(-8.0f, 0.0f, 15.0f);
        this.TailBack02.addBox(-2.0f, 0.0f, 0.0f, 4, 10, 20, 0.0f);
        this.setRotateAngle(this.TailBack02, -1.0471976f, 0.0f, -0.40142572f);
        this.LegRightFront = new ModelRenderer(this, 20, 104);
        this.LegRightFront.setRotationPoint(-7.8f, 12.0f, -3.0f);
        this.LegRightFront.addBox(-4.0f, -4.0f, -4.0f, 8, 16, 8, 0.0f);
        this.setRotateAngle(this.LegRightFront, 0.7853982f, 0.0f, 0.0f);
        this.TailBack01 = new ModelRenderer(this, 30, 40);
        this.TailBack01.setRotationPoint(8.0f, 0.0f, 15.0f);
        this.TailBack01.addBox(-2.0f, 0.0f, 0.0f, 4, 10, 20, 0.0f);
        this.setRotateAngle(this.TailBack01, -1.0471976f, 0.0f, 0.40142572f);
        this.k03 = new ModelRenderer(this, 72, 102);
        this.k03.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.k03.addBox(0.6f, -24.5f, -2.5f, 3, 18, 8, 0.0f);
        this.setRotateAngle(this.k03, -2.0943952f, 0.0f, 0.0f);
        this.Head = new ModelRenderer(this, 6, 42);
        this.Head.setRotationPoint(0.0f, 0.0f, -17.5f);
        this.Head.addBox(-15.0f, -12.0f, -16.0f, 30, 27, 18, 0.0f);
        this.setRotateAngle(this.Head, 0.2617994f, 0.0f, 0.0f);
        this.HeadD03 = new ModelRenderer(this, 2, 94);
        this.HeadD03.setRotationPoint(0.0f, 10.3f, -23.0f);
        this.HeadD03.addBox(-8.5f, 0.0f, 0.0f, 17, 12, 11, 0.0f);
        this.setRotateAngle(this.HeadD03, -0.05235988f, 0.0f, 0.0f);
        this.tube03 = new ModelRenderer(this, 24, 32);
        this.tube03.setRotationPoint(-1.0f, 1.5f, 18.0f);
        this.tube03.addBox(-1.0f, 0.0f, 0.0f, 2, 2, 28, 0.0f);
        this.setRotateAngle(this.tube03, 1.0471976f, -0.13962634f, 0.0f);
        this.k00 = new ModelRenderer(this, 54, 94);
        this.k00.setRotationPoint(12.0f, -10.0f, 0.0f);
        this.k00.addBox(0.0f, 0.0f, 0.0f, 5, 8, 8, 0.0f);
        this.setRotateAngle(this.k00, 0.0f, 0.17453292f, 0.0f);
        this.HeadD04 = new ModelRenderer(this, 2, 94);
        this.HeadD04.setRotationPoint(0.0f, 7.0f, -15.0f);
        this.HeadD04.addBox(-8.0f, 0.0f, 0.0f, 16, 12, 18, 0.0f);
        this.setRotateAngle(this.HeadD04, -0.2617994f, 0.0f, 0.0f);
        this.HeadU02 = new ModelRenderer(this, 6, 40);
        this.HeadU02.setRotationPoint(0.0f, -20.0f, -23.0f);
        this.HeadU02.addBox(-14.0f, 0.0f, 0.0f, 28, 15, 20, 0.0f);
        this.setRotateAngle(this.HeadU02, 0.08726646f, 0.0f, 0.0f);
        this.LegLeftEnd = new ModelRenderer(this, 24, 106);
        this.LegLeftEnd.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.LegLeftEnd.addBox(-3.0f, -3.0f, -3.0f, 6, 14, 6, 0.0f);
        this.setRotateAngle(this.LegLeftEnd, 0.5235988f, 0.0f, 0.0f);
        this.NeckBody = new ModelRenderer(this, 0, 94);
        this.NeckBody.setRotationPoint(0.0f, 7.0f, -9.0f);
        this.NeckBody.addBox(-9.0f, 0.0f, -9.0f, 18, 14, 18, 0.0f);
        this.setRotateAngle(this.NeckBody, 0.34906584f, 0.0f, 0.0f);
        this.tube01 = new ModelRenderer(this, 31, 40);
        this.tube01.setRotationPoint(0.0f, 12.0f, 3.0f);
        this.tube01.addBox(-1.5f, 0.0f, 0.0f, 3, 3, 20, 0.0f);
        this.setRotateAngle(this.tube01, -0.87266463f, 0.0f, 0.0f);
        this.Back = new ModelRenderer(this, 2, 32);
        this.Back.setRotationPoint(0.0f, -16.0f, 0.0f);
        this.Back.addBox(-12.0f, -12.0f, -14.0f, 24, 22, 28, 0.0f);
        this.setRotateAngle(this.Back, -0.2617994f, 0.0f, 0.0f);
        this.HeadU01 = new ModelRenderer(this, 6, 40);
        this.HeadU01.setRotationPoint(0.0f, 7.0f, -19.0f);
        this.HeadU01.addBox(-14.0f, -21.0f, -9.0f, 28, 16, 20, 0.0f);
        this.setRotateAngle(this.HeadU01, -0.08726646f, 0.0f, 0.0f);
        this.TailEnd = new ModelRenderer(this, 14, 36);
        this.TailEnd.setRotationPoint(0.0f, 0.0f, 19.0f);
        this.TailEnd.addBox(-8.0f, -6.5f, 0.0f, 16, 10, 24, 0.0f);
        this.setRotateAngle(this.TailEnd, -0.08726646f, 0.0f, 0.0f);
        this.Body = new ModelRenderer(this, 4, 96);
        this.Body.setRotationPoint(0.0f, 8.0f, -10.0f);
        this.Body.addBox(-8.0f, 0.0f, 0.0f, 16, 7, 16, 0.0f);
        this.setRotateAngle(this.Body, 0.5235988f, 0.0f, 0.0f);
        this.LegLeftFront = new ModelRenderer(this, 20, 104);
        this.LegLeftFront.setRotationPoint(7.8f, 12.0f, -3.0f);
        this.LegLeftFront.addBox(-4.0f, -4.0f, -4.0f, 8, 16, 8, 0.0f);
        this.setRotateAngle(this.LegLeftFront, 0.7853982f, 0.0f, 0.0f);
        this.HeadD01 = new ModelRenderer(this, 0, 34);
        this.HeadD01.setRotationPoint(0.0f, 1.0f, -10.3f);
        this.HeadD01.addBox(-13.0f, 1.5f, -25.0f, 26, 10, 28, 0.0f);
        this.setRotateAngle(this.HeadD01, 0.6981317f, 0.0f, 0.0f);
        this.NeckBack = new ModelRenderer(this, 8, 40);
        this.NeckBack.setRotationPoint(0.0f, -3.0f, -12.0f);
        this.NeckBack.addBox(-13.0f, -11.0f, -20.0f, 26, 26, 22, 0.0f);
        this.setRotateAngle(this.NeckBack, 0.08726646f, 0.0f, 0.0f);
        this.k01 = new ModelRenderer(this, 72, 102);
        this.k01.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.k01.addBox(1.0f, -18.5f, 1.0f, 3, 18, 8, 0.0f);
        this.setRotateAngle(this.k01, -0.5235988f, 0.0f, 0.0f);
        this.tube02 = new ModelRenderer(this, 24, 32);
        this.tube02.setRotationPoint(1.0f, 1.5f, 18.0f);
        this.tube02.addBox(-1.0f, 0.0f, 0.0f, 2, 2, 28, 0.0f);
        this.setRotateAngle(this.tube02, 1.0471976f, 0.13962634f, 0.0f);
        this.BodyTurbine = new ModelRenderer(this, 86, 89);
        this.BodyTurbine.setRotationPoint(0.0f, 7.0f, -2.0f);
        this.BodyTurbine.addBox(-4.5f, 0.0f, 0.0f, 9, 9, 12, 0.0f);
        this.setRotateAngle(this.BodyTurbine, -0.5235988f, 0.0f, 0.0f);
        this.UpperTooth = new ModelRenderer(this, 0, 0);
        this.UpperTooth.setRotationPoint(0.0f, -6.0f, -15.0f);
        this.UpperTooth.addBox(-12.0f, 0.0f, 0.0f, 24, 10, 20, 0.0f);
        this.setRotateAngle(this.UpperTooth, 0.34906584f, 0.0f, 0.0f);
        this.FaceL00 = new ModelRenderer(this, 96, 96);
        this.FaceL00.setRotationPoint(15.1f, -8.0f, -16.0f);
        this.FaceL00.addBox(0.0f, 0.0f, 0.0f, 0, 16, 16, 0.0f);
        this.FaceL01 = new ModelRenderer(this, 96, 0);
        this.FaceL01.setRotationPoint(15.1f, -8.0f, -16.0f);
        this.FaceL01.addBox(0.0f, 0.0f, 0.0f, 0, 16, 16, 0.0f);
        this.FaceL02 = new ModelRenderer(this, 96, 16);
        this.FaceL02.setRotationPoint(15.1f, -8.0f, -16.0f);
        this.FaceL02.addBox(0.0f, 0.0f, 0.0f, 0, 16, 16, 0.0f);
        this.FaceR00 = new ModelRenderer(this, 96, 96);
        this.FaceR00.setRotationPoint(-15.1f, -8.0f, -16.0f);
        this.FaceR00.addBox(0.0f, 0.0f, 0.0f, 0, 16, 16, 0.0f);
        this.FaceR01 = new ModelRenderer(this, 96, 0);
        this.FaceR01.setRotationPoint(-15.1f, -8.0f, -16.0f);
        this.FaceR01.addBox(0.0f, 0.0f, 0.0f, 0, 16, 16, 0.0f);
        this.FaceR02 = new ModelRenderer(this, 96, 16);
        this.FaceR02.setRotationPoint(-15.1f, -8.0f, -16.0f);
        this.FaceR02.addBox(0.0f, 0.0f, 0.0f, 0, 16, 16, 0.0f);
        this.HeadD01.addChild(this.LowerTooth);
        this.Back.addChild(this.TailBack);
        this.LegRightFront.addChild(this.LegRightEnd);
        this.TailBack.addChild(this.TailBack02);
        this.Back.addChild(this.LegRightFront);
        this.TailBack.addChild(this.TailBack01);
        this.NeckBack.addChild(this.Head);
        this.NeckBack.addChild(this.HeadD03);
        this.tube01.addChild(this.tube03);
        this.Head.addChild(this.HeadD04);
        this.HeadU01.addChild(this.HeadU02);
        this.LegLeftFront.addChild(this.LegLeftEnd);
        this.NeckBack.addChild(this.NeckBody);
        this.NeckBody.addChild(this.tube01);
        this.Head.addChild(this.HeadU01);
        this.TailBack.addChild(this.TailEnd);
        this.Back.addChild(this.Body);
        this.Back.addChild(this.LegLeftFront);
        this.Head.addChild(this.HeadD01);
        this.Back.addChild(this.NeckBack);
        this.tube01.addChild(this.tube02);
        this.Back.addChild(this.BodyTurbine);
        this.HeadU01.addChild(this.UpperTooth);
        this.GlowBack = new ModelRenderer(this, 0, 0);
        this.GlowBack.setRotationPoint(0.0f, -16.0f, 0.0f);
        this.setRotateAngle(this.GlowBack, -0.2618f, 0.0f, 0.0f);
        this.GlowNeckBack = new ModelRenderer(this, 0, 0);
        this.GlowNeckBack.setRotationPoint(0.0f, -3.0f, -12.0f);
        this.setRotateAngle(this.GlowNeckBack, 0.0873f, 0.0f, 0.0f);
        this.GlowHead = new ModelRenderer(this, 0, 0);
        this.GlowHead.setRotationPoint(0.0f, 0.0f, -17.5f);
        this.setRotateAngle(this.GlowHead, 0.2618f, 0.0f, 0.0f);
        this.GlowBack.addChild(this.GlowNeckBack);
        this.GlowNeckBack.addChild(this.GlowHead);
        this.GlowHead.addChild(this.FaceL00);
        this.GlowHead.addChild(this.FaceL01);
        this.GlowHead.addChild(this.FaceL02);
        this.GlowHead.addChild(this.FaceR00);
        this.GlowHead.addChild(this.FaceR01);
        this.GlowHead.addChild(this.FaceR02);
        this.GlowHead.addChild(this.k00);
        this.k00.addChild(this.k01);
        this.k00.addChild(this.k02);
        this.k00.addChild(this.k03);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.45f, 0.45f, 0.45f);
        GlStateManager.translate(0.0f, 2.1f, 0.0f);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Back.render(f5);
        GlStateManager.disableLighting();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        this.GlowBack.render(f5);
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        if (f3 <= -180.0f) {
            f3 += 360.0f;
        } else if (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float angleX = MathHelper.cos(f2 * 0.125f);
        BasicEntityShip ent = (BasicEntityShip)entity;
        if (ent.getShipDepth(0) > 0.0) {
            GlStateManager.translate(0.0f, angleX * 0.05f + 0.025f, 0.0f);
        }
        if (ent.getStateFlag(2)) {
            this.motionStopPos(ent);
        } else {
            this.Back.rotateAngleX = -0.2618f;
            this.Back.rotateAngleY = 0.0f;
            this.Back.rotateAngleZ = 0.0f;
            this.NeckBack.rotateAngleX = 0.0873f;
            this.Head.rotateAngleX = 0.3f;
            this.LegRightFront.rotateAngleY = 0.0f;
            this.LegLeftFront.rotateAngleY = 0.0f;
            this.isKisaragi(ent);
            this.rollEmotion(ent);
            this.motionWatch(f3, f4, angleX);
            if (ent.isSitting()) {
                this.motionSit(ent, angleX);
            } else {
                this.motionLeg(ent, f, f1, angleX);
                this.motionTail(angleX);
            }
        }
        this.setGlowRotation();
    }

    private void setGlowRotation() {
        this.GlowBack.rotateAngleX = this.Back.rotateAngleX;
        this.GlowBack.rotateAngleY = this.Back.rotateAngleY;
        this.GlowBack.rotateAngleZ = this.Back.rotateAngleZ;
        this.GlowNeckBack.rotateAngleX = this.NeckBack.rotateAngleX;
        this.GlowNeckBack.rotateAngleY = this.NeckBack.rotateAngleY;
        this.GlowNeckBack.rotateAngleZ = this.NeckBack.rotateAngleZ;
        this.GlowHead.rotateAngleX = this.Head.rotateAngleX;
        this.GlowHead.rotateAngleY = this.Head.rotateAngleY;
        this.GlowHead.rotateAngleZ = this.Head.rotateAngleZ;
    }

    private void motionStopPos(BasicEntityShip ent) {
        GlStateManager.translate(0.0f, 0.45f, 0.0f);
        this.isKisaragi(ent);
        this.setFace(1);
        this.HeadD01.rotateAngleX = 0.7f;
        this.NeckBack.rotateAngleX = 0.0f;
        this.NeckBack.rotateAngleY = 0.1f;
        this.Head.rotateAngleX = 0.1f;
        this.Head.rotateAngleY = 0.1f;
        this.Back.rotateAngleX = 0.0f;
        this.Back.rotateAngleY = 3.1415f;
        this.Back.rotateAngleZ = 3.1415f;
        this.LegRightFront.rotateAngleX = 1.57f;
        this.LegRightFront.rotateAngleY = -0.52f;
        this.LegLeftFront.rotateAngleX = 1.57f;
        this.LegLeftFront.rotateAngleY = 0.52f;
        this.LegRightEnd.rotateAngleX = 1.0f;
        this.LegLeftEnd.rotateAngleX = 1.0f;
        this.TailBack.rotateAngleX = 0.1f;
        this.TailBack.rotateAngleY = -0.15f;
        this.TailEnd.rotateAngleX = 0.1f;
        this.TailEnd.rotateAngleY = -0.15f;
        this.tube01.rotateAngleX = -0.8f;
        this.tube01.rotateAngleY = -0.12f;
    }

    private void motionSit(BasicEntityShip ent, float angleX) {
        GlStateManager.translate(0.0f, 0.45f, 0.0f);
        if (ent.getStateEmotion(1) == 4) {
            this.setFace(2);
            this.Back.rotateAngleX = 0.0f;
            this.Back.rotateAngleY = 3.1415f;
            this.Back.rotateAngleZ = 3.1415f;
            this.Head.rotateAngleX = angleX * 0.08f + 0.35f;
            this.LegRightFront.rotateAngleX = angleX * 0.3f + 0.5f;
            this.LegLeftFront.rotateAngleX = -angleX * 0.3f + 0.5f;
            this.LegRightEnd.rotateAngleX = angleX * 0.3f + 0.5f;
            this.LegLeftEnd.rotateAngleX = -angleX * 0.3f + 0.5f;
            this.TailBack.rotateAngleX = -0.3f;
            this.TailBack.rotateAngleY = angleX * 0.3f;
            this.TailEnd.rotateAngleX = -0.3f;
            this.TailEnd.rotateAngleY = angleX * 0.5f;
            this.tube01.rotateAngleX = -0.8f;
        } else {
            this.Back.rotateAngleX = -0.7f;
            this.Head.rotateAngleX = angleX * 0.08f + 0.35f;
            this.LegRightFront.rotateAngleX = -0.6981f;
            this.LegLeftFront.rotateAngleX = -0.6981f;
            this.LegRightEnd.rotateAngleX = 0.1745f;
            this.LegLeftEnd.rotateAngleX = 0.1745f;
            this.TailBack.rotateAngleX = 0.5f;
            this.TailBack.rotateAngleY = angleX * 0.3f;
            this.TailEnd.rotateAngleX = 0.6f;
            this.TailEnd.rotateAngleY = angleX * 0.5f;
            this.tube01.rotateAngleX = -0.6f;
        }
    }

    private void motionTail(float angleX) {
        this.TailBack.rotateAngleX = angleX * 0.1f - 0.1f;
        this.TailEnd.rotateAngleX = angleX * 0.25f - 0.1f;
    }

    private void motionLeg(BasicEntityShip ent, float f, float f1, float angleX) {
        if (ent.isSprinting() || f1 > 0.9f) {
            this.LegRightFront.rotateAngleX = MathHelper.cos(f * 0.6662f) * 0.4f * f1 + 1.0f;
            this.LegLeftFront.rotateAngleX = MathHelper.cos(f * 0.6662f + (float)Math.PI) * 0.4f * f1 + 1.0f;
            this.LegRightEnd.rotateAngleX = MathHelper.sin(f * 0.6662f) * f1 + 0.5f;
            this.LegLeftEnd.rotateAngleX = MathHelper.sin(f * 0.6662f + (float)Math.PI) * f1 + 0.5f;
        } else {
            this.LegRightFront.rotateAngleX = angleX * 0.3f + 0.8f;
            this.LegLeftFront.rotateAngleX = -angleX * 0.3f + 0.8f;
            this.LegRightEnd.rotateAngleX = angleX * 0.3f + 0.5f;
            this.LegLeftEnd.rotateAngleX = -angleX * 0.3f + 0.5f;
        }
    }

    private void motionWatch(float f3, float f4, float angleX) {
        if (f4 != 0.0f) {
            this.NeckBack.rotateAngleX = f4 * 0.005f;
            this.NeckBack.rotateAngleY = f3 * 0.005f;
            this.Head.rotateAngleX = f4 * 0.005f;
            this.Head.rotateAngleY = f3 * 0.005f;
            this.TailBack.rotateAngleX = 0.1f;
            this.TailBack.rotateAngleY = f3 * -0.005f;
            this.TailEnd.rotateAngleX = 0.1f;
            this.TailEnd.rotateAngleY = f3 * -0.005f;
            this.tube01.rotateAngleX = f4 * -0.005f - 0.8727f;
            this.tube01.rotateAngleY = f3 * -0.005f;
        } else {
            this.Head.rotateAngleX = angleX * 0.08f + 0.3f;
            this.HeadD01.rotateAngleX = angleX * 0.05f + 0.7f;
            this.NeckBack.rotateAngleX = 0.0873f;
            this.NeckBack.rotateAngleY = 0.0f;
            this.Head.rotateAngleY = 0.0f;
            this.TailBack.rotateAngleY = 0.0f;
            this.TailEnd.rotateAngleY = 0.0f;
            this.tube01.rotateAngleX = -0.8727f;
            this.tube01.rotateAngleY = 0.0f;
        }
    }

    private void isKisaragi(BasicEntityShip ent) {
        this.k00.isHidden = !EmotionHelper.checkModelState(0, ent.getStateEmotion(0));
    }

    private void rollEmotion(BasicEntityShip ent) {
        switch (ent.getStateEmotion(1)) {
            case 1: {
                EmotionHelper.applyEmotionBlink(this, ent);
                break;
            }
            case 2: 
            case 3: 
            case 5: {
                if (ent.getFaceTick() > 0) break;
                this.setFace(2);
                break;
            }
            case 4: {
                if (ent.getFaceTick() > 0) break;
                this.setFace(1);
                break;
            }
            default: {
                if (ent.getFaceTick() <= 0) {
                    this.setFace(0);
                } else {
                    EmotionHelper.applyEmotionBlink(this, ent);
                }
                if (ent.ticksExisted % 120 != 0 || ent.getRNG().nextInt(10) <= 7) break;
                EmotionHelper.applyEmotionBlink(this, ent);
            }
        }
    }

    @Override
    public void setFace(int emo) {
        switch (emo) {
            case 0: {
                this.FaceL00.isHidden = false;
                this.FaceR00.isHidden = false;
                this.FaceL01.isHidden = true;
                this.FaceR01.isHidden = true;
                this.FaceL02.isHidden = true;
                this.FaceR02.isHidden = true;
                break;
            }
            case 1: {
                this.FaceL00.isHidden = true;
                this.FaceR00.isHidden = true;
                this.FaceL01.isHidden = false;
                this.FaceR01.isHidden = false;
                this.FaceL02.isHidden = true;
                this.FaceR02.isHidden = true;
                break;
            }
            case 2: {
                this.FaceL00.isHidden = true;
                this.FaceR00.isHidden = true;
                this.FaceL01.isHidden = true;
                this.FaceR01.isHidden = true;
                this.FaceL02.isHidden = false;
                this.FaceR02.isHidden = false;
                break;
            }
            default:
        }
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

    @Override
    public void showEquip(IShipEmotion ent) {
    }

    @Override
    public void syncRotationGlowPart() {
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
    }
}
