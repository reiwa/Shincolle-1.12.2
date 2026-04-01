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

public class ModelDestroyerHa
extends ModelBase
implements IModelEmotion {
    private final ModelRenderer Back;
    private final ModelRenderer NeckBack;
    private final ModelRenderer Body;
    private final ModelRenderer TailBack;
    private final ModelRenderer Head;
    private final ModelRenderer NeckBody;
    private final ModelRenderer HeadD01;
    private final ModelRenderer k00;
    private final ModelRenderer ToothU;
    private final ModelRenderer Face00;
    private final ModelRenderer Face01;
    private final ModelRenderer Face02;
    private final ModelRenderer HeadD02;
    private final ModelRenderer ToothL;
    private final ModelRenderer HeadD03;
    private final ModelRenderer k01;
    private final ModelRenderer k02;
    private final ModelRenderer k03;
    private final ModelRenderer LegLeftFront;
    private final ModelRenderer LegRightFront;
    private final ModelRenderer LegLeftEnd;
    private final ModelRenderer LegRightEnd;
    private final ModelRenderer TailEnd1;
    private final ModelRenderer TailEnd2;
    private final ModelRenderer GlowBack;
    private final ModelRenderer GlowNeckBack;
    private final ModelRenderer GlowHead;

    public ModelDestroyerHa() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.TailBack = new ModelRenderer(this, 30, 79);
        this.TailBack.setRotationPoint(0.0f, -7.0f, 9.0f);
        this.TailBack.addBox(-10.0f, -4.0f, 0.0f, 20, 17, 22, 0.0f);
        this.setRotateAngle(this.TailBack, 0.08726646f, 0.0f, 0.0f);
        this.ToothL = new ModelRenderer(this, 0, 0);
        this.ToothL.setRotationPoint(0.0f, 1.0f, 0.5f);
        this.ToothL.addBox(-11.0f, 0.0f, -22.0f, 22, 7, 22, 0.0f);
        this.ToothL.mirror = true;
        this.setRotateAngle(this.ToothL, -3.0892327f, (float)(-Math.PI), 0.0f);
        this.k01 = new ModelRenderer(this, 90, 0);
        this.k01.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.k01.addBox(1.0f, -18.5f, 1.0f, 3, 18, 8, 0.0f);
        this.setRotateAngle(this.k01, -0.5235988f, 0.0f, 0.0f);
        this.LegRightFront = new ModelRenderer(this, 66, 46);
        this.LegRightFront.setRotationPoint(-12.0f, 7.0f, 14.0f);
        this.LegRightFront.addBox(-5.0f, -4.0f, -5.0f, 10, 16, 10, 0.0f);
        this.setRotateAngle(this.LegRightFront, -0.5235988f, 0.0f, 0.0f);
        this.k02 = new ModelRenderer(this, 90, 0);
        this.k02.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.k02.addBox(0.8f, -25.0f, -0.7f, 3, 18, 8, 0.0f);
        this.setRotateAngle(this.k02, -1.3962634f, 0.0f, 0.0f);
        this.NeckBack = new ModelRenderer(this, 24, 79);
        this.NeckBack.setRotationPoint(0.0f, -2.5f, -11.0f);
        this.NeckBack.addBox(-13.0f, -10.0f, -20.0f, 26, 26, 22, 0.0f);
        this.setRotateAngle(this.NeckBack, -0.0873f, 0.0f, 0.0f);
        this.LegLeftFront = new ModelRenderer(this, 66, 46);
        this.LegLeftFront.setRotationPoint(12.0f, 7.0f, 14.0f);
        this.LegLeftFront.addBox(-5.0f, -4.0f, -5.0f, 10, 16, 10, 0.0f);
        this.setRotateAngle(this.LegLeftFront, -0.5235988f, 0.0f, 0.0f);
        this.LegLeftEnd = new ModelRenderer(this, 70, 48);
        this.LegLeftEnd.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.LegLeftEnd.addBox(-4.0f, -3.0f, -4.0f, 8, 16, 8, 0.0f);
        this.setRotateAngle(this.LegLeftEnd, 0.6981317f, 0.0f, 0.0f);
        this.Back = new ModelRenderer(this, 20, 73);
        this.Back.setRotationPoint(0.0f, -22.0f, 0.0f);
        this.Back.addBox(-12.0f, -12.0f, -14.0f, 24, 22, 28, 0.0f);
        this.k03 = new ModelRenderer(this, 90, 0);
        this.k03.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.k03.addBox(0.6f, -24.5f, -2.5f, 3, 18, 8, 0.0f);
        this.setRotateAngle(this.k03, -2.0943952f, 0.0f, 0.0f);
        this.Head = new ModelRenderer(this, 16, 75);
        this.Head.setRotationPoint(0.0f, 3.0f, -13.0f);
        this.Head.addBox(-13.5f, -14.0f, -28.0f, 27, 27, 26, 0.0f);
        this.setRotateAngle(this.Head, -0.17453292f, 0.0f, 0.0f);
        this.ToothU = new ModelRenderer(this, 0, 0);
        this.ToothU.setRotationPoint(0.0f, 12.5f, -28.5f);
        this.ToothU.addBox(-11.0f, 0.0f, 0.0f, 22, 7, 22, 0.0f);
        this.setRotateAngle(this.ToothU, 0.05235988f, 0.0f, 0.0f);
        this.Body = new ModelRenderer(this, 44, 32);
        this.Body.setRotationPoint(0.0f, 11.0f, -18.0f);
        this.Body.addBox(-9.0f, 0.0f, 0.0f, 18, 14, 24, 0.0f);
        this.setRotateAngle(this.Body, 0.17453292f, 0.0f, 0.0f);
        this.TailEnd1 = new ModelRenderer(this, 36, 81);
        this.TailEnd1.setRotationPoint(0.0f, 0.0f, 19.0f);
        this.TailEnd1.addBox(-8.0f, -3.0f, 0.0f, 16, 12, 20, 0.0f);
        this.setRotateAngle(this.TailEnd1, 0.17453292f, 0.0f, 0.0f);
        this.HeadD01 = new ModelRenderer(this, 45, 94);
        this.HeadD01.setRotationPoint(0.0f, 12.0f, -3.0f);
        this.HeadD01.addBox(-12.0f, 0.0f, -3.0f, 24, 16, 7, 0.0f);
        this.setRotateAngle(this.HeadD01, -0.13962634f, 0.0f, 0.0f);
        this.k00 = new ModelRenderer(this, 102, 84);
        this.k00.setRotationPoint(13.0f, -8.0f, -10.0f);
        this.k00.addBox(0.0f, 0.0f, 0.0f, 5, 8, 8, 0.0f);
        this.setRotateAngle(this.k00, 0.0f, 0.17453292f, 0.0f);
        this.NeckBody = new ModelRenderer(this, 46, 34);
        this.NeckBody.setRotationPoint(0.0f, 15.0f, -8.0f);
        this.NeckBody.addBox(-9.0f, 0.0f, -9.0f, 18, 11, 22, 0.0f);
        this.HeadD02 = new ModelRenderer(this, 27, 77);
        this.HeadD02.setRotationPoint(0.0f, 9.5f, -1.5f);
        this.HeadD02.addBox(-10.5f, 0.0f, -21.0f, 21, 8, 24, 0.0f);
        this.setRotateAngle(this.HeadD02, 0.34906584f, 0.0f, 0.0f);
        this.HeadD03 = new ModelRenderer(this, 44, 83);
        this.HeadD03.setRotationPoint(0.0f, 5.0f, -28.0f);
        this.HeadD03.addBox(-5.0f, 0.0f, 0.0f, 10, 10, 18, 0.0f);
        this.setRotateAngle(this.HeadD03, 0.34906584f, 0.0f, 0.0f);
        this.LegRightEnd = new ModelRenderer(this, 70, 48);
        this.LegRightEnd.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.LegRightEnd.addBox(-4.0f, -3.0f, -4.0f, 8, 16, 8, 0.0f);
        this.setRotateAngle(this.LegRightEnd, 0.6981317f, 0.0f, 0.0f);
        this.TailEnd2 = new ModelRenderer(this, 42, 85);
        this.TailEnd2.setRotationPoint(0.0f, 8.0f, 20.0f);
        this.TailEnd2.addBox(-7.0f, -5.0f, 0.0f, 14, 10, 16, 0.0f);
        this.setRotateAngle(this.TailEnd2, -0.5235988f, 0.0f, 0.0f);
        this.Face00 = new ModelRenderer(this, 0, 81);
        this.Face00.setRotationPoint(0.0f, -12.0f, -28.1f);
        this.Face00.addBox(-10.0f, 0.0f, 0.0f, 20, 20, 0, 0.0f);
        this.Face01 = new ModelRenderer(this, 0, 61);
        this.Face01.setRotationPoint(0.0f, -12.0f, -28.2f);
        this.Face01.addBox(-10.0f, 0.0f, 0.0f, 20, 20, 0, 0.0f);
        this.Face02 = new ModelRenderer(this, 0, 41);
        this.Face02.setRotationPoint(0.0f, -12.0f, -28.3f);
        this.Face02.addBox(-10.0f, 0.0f, 0.0f, 20, 20, 0, 0.0f);
        this.Back.addChild(this.TailBack);
        this.HeadD02.addChild(this.ToothL);
        this.Body.addChild(this.LegRightFront);
        this.Back.addChild(this.NeckBack);
        this.Body.addChild(this.LegLeftFront);
        this.LegLeftFront.addChild(this.LegLeftEnd);
        this.NeckBack.addChild(this.Head);
        this.Head.addChild(this.ToothU);
        this.Back.addChild(this.Body);
        this.TailBack.addChild(this.TailEnd1);
        this.Head.addChild(this.HeadD01);
        this.NeckBack.addChild(this.NeckBody);
        this.HeadD01.addChild(this.HeadD02);
        this.HeadD02.addChild(this.HeadD03);
        this.LegRightFront.addChild(this.LegRightEnd);
        this.TailBack.addChild(this.TailEnd2);
        this.GlowBack = new ModelRenderer(this, 0, 0);
        this.GlowBack.setRotationPoint(0.0f, -22.0f, 0.0f);
        this.GlowNeckBack = new ModelRenderer(this, 0, 0);
        this.GlowNeckBack.setRotationPoint(0.0f, -2.5f, -11.0f);
        this.setRotateAngle(this.GlowNeckBack, -0.0873f, 0.0f, 0.0f);
        this.GlowHead = new ModelRenderer(this, 0, 0);
        this.GlowHead.setRotationPoint(0.0f, 3.0f, -13.0f);
        this.setRotateAngle(this.GlowHead, -0.17453292f, 0.0f, 0.0f);
        this.GlowBack.addChild(this.GlowNeckBack);
        this.GlowNeckBack.addChild(this.GlowHead);
        this.GlowHead.addChild(this.Face00);
        this.GlowHead.addChild(this.Face01);
        this.GlowHead.addChild(this.Face02);
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
        GlStateManager.translate(0.0f, 1.0f, 0.0f);
        GlStateManager.scale(0.45f, 0.45f, 0.45f);
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
        if (ent.getShipDepth() > 0.0) {
            GlStateManager.translate(0.0f, angleX * 0.05f + 0.025f, 0.0f);
        }
        if (ent.getStateFlag(2)) {
            this.motionStopPos(ent);
        } else {
            this.Back.rotateAngleX = -0.1f;
            this.Back.rotateAngleZ = 0.0f;
            this.NeckBack.rotateAngleX = -0.15f;
            this.NeckBack.rotateAngleY = 0.0f;
            this.Head.rotateAngleX = -0.2f;
            this.Head.rotateAngleY = 0.0f;
            this.LegLeftFront.rotateAngleZ = 0.0f;
            this.LegLeftEnd.rotateAngleZ = 0.0f;
            this.LegRightFront.rotateAngleZ = 0.0f;
            this.isKisaragi(ent);
            this.rollEmotion(ent);
            this.motionWatch(f3, f4, angleX);
            if (ent.isSitting()) {
                this.motionSit(ent, f2);
            } else {
                this.motionTail(angleX);
                this.motionLeg(f, f1);
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
        GlStateManager.translate(0.0f, 0.5f, 0.0f);
        this.isKisaragi(ent);
        this.setFace(2);
        this.Back.rotateAngleX = 0.0f;
        this.Back.rotateAngleZ = -1.66f;
        this.NeckBack.rotateAngleX = 0.1745f;
        this.NeckBack.rotateAngleY = 0.0f;
        this.Head.rotateAngleX = 0.1745f;
        this.Head.rotateAngleY = 0.0f;
        this.HeadD01.rotateAngleX = 0.1745f;
        this.TailBack.rotateAngleX = 0.4f;
        this.TailBack.rotateAngleY = 0.0f;
        this.TailEnd1.rotateAngleX = 0.4f;
        this.TailEnd1.rotateAngleY = 0.0f;
        this.LegLeftFront.rotateAngleX = 0.35f;
        this.LegLeftFront.rotateAngleZ = 0.52f;
        this.LegLeftEnd.rotateAngleX = 0.0f;
        this.LegLeftEnd.rotateAngleZ = 0.52f;
        this.LegRightFront.rotateAngleX = -0.2f;
        this.LegRightFront.rotateAngleZ = 0.087f;
        this.LegRightEnd.rotateAngleX = 0.52f;
    }

    private void motionSit(BasicEntityShip ent, float f2) {
        float angle1 = MathHelper.cos(f2);
        if (ent.getStateEmotion(1) == 4) {
            this.setFace(1);
            GlStateManager.translate(0.0f, 0.4f, 0.0f);
            this.Back.rotateAngleX = -0.8f;
            this.NeckBack.rotateAngleX = -0.2618f;
            this.Head.rotateAngleX = -0.2618f;
            this.HeadD01.rotateAngleX = -angle1 * 0.05f + 0.2618f;
            this.LegRightFront.rotateAngleX = -0.7f;
            this.LegLeftFront.rotateAngleX = angle1 * 0.5f - 2.5f;
            this.LegRightEnd.rotateAngleX = 0.35f;
            this.LegLeftEnd.rotateAngleX = angle1 * 0.3f + 0.7f;
            this.TailBack.rotateAngleX = 0.35f;
            this.TailEnd1.rotateAngleX = 0.35f;
        } else {
            GlStateManager.translate(0.0f, 0.5f, 0.0f);
            this.Back.rotateAngleX = 0.0f;
            this.Back.rotateAngleZ = -1.5708f;
            this.NeckBack.rotateAngleX = 0.1745f;
            this.Head.rotateAngleX = 0.1745f;
            this.HeadD01.rotateAngleX = 0.1745f;
            this.LegRightFront.rotateAngleX = 0.0f;
            this.LegLeftFront.rotateAngleX = 0.5f;
            this.LegRightEnd.rotateAngleX = 1.7f;
            this.LegLeftEnd.rotateAngleX = 1.5f;
            this.TailBack.rotateAngleX = -0.7f;
            this.TailEnd1.rotateAngleX = -0.5f;
        }
    }

    private void motionTail(float angleX) {
        this.TailBack.rotateAngleX = angleX * 0.05f + 0.1745f;
        this.TailEnd1.rotateAngleX = angleX * 0.1f + 0.2618f;
    }

    private void motionLeg(float f, float f1) {
        float angle1 = MathHelper.cos(f * 0.6662f) * 0.5f * f1;
        float angle2 = MathHelper.sin(f * 0.6662f) * 0.5f * f1;
        this.LegRightFront.rotateAngleX = angle1 - 0.5f;
        this.LegLeftFront.rotateAngleX = -angle1 - 0.5f;
        this.LegRightEnd.rotateAngleX = angle2 + 1.0f;
        this.LegLeftEnd.rotateAngleX = -angle2 + 1.0f;
    }

    private void motionWatch(float f3, float f4, float angleX) {
        if (f4 != 0.0f) {
            this.NeckBack.rotateAngleX = f4 * 0.005f;
            this.NeckBack.rotateAngleY = f3 * 0.005f;
            this.Head.rotateAngleX = f4 * 0.005f;
            this.Head.rotateAngleY = f3 * 0.005f;
            this.HeadD01.rotateAngleX = angleX * 0.05f - 0.05f;
            this.TailBack.rotateAngleX = 0.15f;
            this.TailBack.rotateAngleY = f3 * -0.005f;
            this.TailEnd1.rotateAngleX = 0.2f;
            this.TailEnd1.rotateAngleY = f3 * -0.005f;
        } else {
            this.HeadD01.rotateAngleX = angleX * 0.05f - 0.05f;
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
                this.Face00.isHidden = false;
                this.Face01.isHidden = true;
                this.Face02.isHidden = true;
                break;
            }
            case 1: {
                this.Face00.isHidden = true;
                this.Face01.isHidden = false;
                this.Face02.isHidden = true;
                break;
            }
            case 2: {
                this.Face00.isHidden = true;
                this.Face01.isHidden = true;
                this.Face02.isHidden = false;
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
