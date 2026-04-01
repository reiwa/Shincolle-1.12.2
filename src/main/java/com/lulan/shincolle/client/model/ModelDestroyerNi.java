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

public class ModelDestroyerNi
extends ModelBase
implements IModelEmotion {
    private final ModelRenderer Back;
    private final ModelRenderer NeckBack;
    private final ModelRenderer Body;
    private final ModelRenderer TailBack;
    private final ModelRenderer Head;
    private final ModelRenderer NeckBody;
    private final ModelRenderer EquipBase;
    private final ModelRenderer ArmLeft;
    private final ModelRenderer ArmRight;
    private final ModelRenderer k00;
    private final ModelRenderer ToothU;
    private final ModelRenderer Face00;
    private final ModelRenderer Face01;
    private final ModelRenderer Face02;
    private final ModelRenderer k01;
    private final ModelRenderer k02;
    private final ModelRenderer k03;
    private final ModelRenderer Equip01;
    private final ModelRenderer Equip02;
    private final ModelRenderer Equip03;
    private final ModelRenderer ArmLeft01;
    private final ModelRenderer ArmRight01;
    private final ModelRenderer TailEnd1;
    private final ModelRenderer GlowBack;
    private final ModelRenderer GlowNeckBack;
    private final ModelRenderer GlowHead;

    public ModelDestroyerNi() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Back = new ModelRenderer(this, 14, 76);
        this.Back.setRotationPoint(0.0f, -40.0f, 0.0f);
        this.Back.addBox(-12.0f, -12.0f, -14.0f, 24, 21, 26, 0.0f);
        this.setRotateAngle(this.Back, 0.7853982f, 0.0f, 0.0f);
        this.Body = new ModelRenderer(this, 0, 33);
        this.Body.setRotationPoint(0.0f, 11.0f, -14.0f);
        this.Body.addBox(-10.0f, 0.0f, 0.0f, 20, 12, 24, 0.0f);
        this.setRotateAngle(this.Body, 0.3642502f, 0.0f, 0.0f);
        this.Face02 = new ModelRenderer(this, 68, 0);
        this.Face02.setRotationPoint(0.0f, -14.1f, -27.0f);
        this.Face02.addBox(-10.0f, 0.0f, 0.0f, 20, 0, 20, 0.0f);
        this.Face00 = new ModelRenderer(this, 68, 40);
        this.Face00.setRotationPoint(0.0f, -14.3f, -27.0f);
        this.Face00.addBox(-10.0f, 0.0f, 0.0f, 20, 0, 20, 0.0f);
        this.k01 = new ModelRenderer(this, 106, 76);
        this.k01.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.k01.addBox(1.0f, -18.5f, 1.0f, 3, 18, 8, 0.0f);
        this.setRotateAngle(this.k01, -0.5235988f, 0.0f, 0.0f);
        this.NeckBack = new ModelRenderer(this, 10, 76);
        this.NeckBack.setRotationPoint(0.0f, -2.5f, -14.0f);
        this.NeckBack.addBox(-14.0f, -10.0f, -20.0f, 28, 25, 26, 0.0f);
        this.setRotateAngle(this.NeckBack, 0.08726646f, 0.0f, 0.0f);
        this.Equip02 = new ModelRenderer(this, 54, 64);
        this.Equip02.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.Equip02.addBox(0.0f, 0.0f, 0.0f, 0, 28, 5, 0.0f);
        this.setRotateAngle(this.Equip02, 0.0f, 0.0f, 1.3089969f);
        this.k02 = new ModelRenderer(this, 106, 76);
        this.k02.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.k02.addBox(0.8f, -25.0f, -0.7f, 3, 18, 8, 0.0f);
        this.setRotateAngle(this.k02, -1.3962634f, 0.0f, 0.0f);
        this.TailEnd1 = new ModelRenderer(this, 28, 82);
        this.TailEnd1.setRotationPoint(0.0f, 0.0f, 19.0f);
        this.TailEnd1.addBox(-8.0f, -3.0f, 0.0f, 16, 13, 20, 0.0f);
        this.setRotateAngle(this.TailEnd1, -0.17453292f, 0.0f, 0.0f);
        this.ToothU = new ModelRenderer(this, 0, 0);
        this.ToothU.setRotationPoint(0.0f, 7.0f, -29.0f);
        this.ToothU.addBox(-11.0f, 0.0f, 0.0f, 22, 9, 22, 0.0f);
        this.setRotateAngle(this.ToothU, 0.13962634f, 0.0f, 0.0f);
        this.ArmLeft01 = new ModelRenderer(this, 2, 32);
        this.ArmLeft01.setRotationPoint(0.0f, 28.0f, 0.0f);
        this.ArmLeft01.addBox(-3.5f, 0.0f, -3.5f, 7, 30, 7, 0.0f);
        this.setRotateAngle(this.ArmLeft01, 0.0f, 0.0f, 1.3962634f);
        this.TailBack = new ModelRenderer(this, 22, 80);
        this.TailBack.setRotationPoint(0.0f, -7.0f, 9.0f);
        this.TailBack.addBox(-10.0f, -4.0f, 0.0f, 20, 17, 22, 0.0f);
        this.setRotateAngle(this.TailBack, -0.17453292f, 0.0f, 0.0f);
        this.ArmRight01 = new ModelRenderer(this, 2, 32);
        this.ArmRight01.setRotationPoint(0.0f, 28.0f, 0.0f);
        this.ArmRight01.addBox(-3.5f, 0.0f, -3.5f, 7, 30, 7, 0.0f);
        this.setRotateAngle(this.ArmRight01, 0.0f, 0.0f, -1.3962634f);
        this.NeckBody = new ModelRenderer(this, 1, 36);
        this.NeckBody.setRotationPoint(0.0f, 13.0f, -4.0f);
        this.NeckBody.addBox(-11.0f, 0.0f, -9.0f, 22, 10, 21, 0.0f);
        this.setRotateAngle(this.NeckBody, -0.31869712f, 0.0f, 0.0f);
        this.k03 = new ModelRenderer(this, 106, 76);
        this.k03.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.k03.addBox(0.6f, -24.5f, -2.5f, 3, 18, 8, 0.0f);
        this.setRotateAngle(this.k03, -2.0943952f, 0.0f, 0.0f);
        this.Equip03 = new ModelRenderer(this, 54, 64);
        this.Equip03.setRotationPoint(0.0f, 28.0f, 0.0f);
        this.Equip03.addBox(0.0f, 0.0f, 0.0f, 0, 32, 5, 0.0f);
        this.setRotateAngle(this.Equip03, 0.0f, 0.0f, -1.0471976f);
        this.ArmRight = new ModelRenderer(this, 0, 31);
        this.ArmRight.setRotationPoint(-13.0f, 15.0f, -9.0f);
        this.ArmRight.addBox(-4.0f, 0.0f, -4.0f, 8, 30, 8, 0.0f);
        this.setRotateAngle(this.ArmRight, -0.5235988f, 0.6981317f, 1.0471976f);
        this.Equip01 = new ModelRenderer(this, 54, 64);
        this.Equip01.setRotationPoint(18.0f, 13.0f, 9.0f);
        this.Equip01.addBox(0.0f, 0.0f, 0.0f, 0, 24, 5, 0.0f);
        this.setRotateAngle(this.Equip01, 1.0471976f, 0.7853982f, 0.0f);
        this.EquipBase = new ModelRenderer(this, 11, 89);
        this.EquipBase.setRotationPoint(0.0f, 11.0f, -26.0f);
        this.EquipBase.addBox(-20.0f, 0.0f, 0.0f, 40, 13, 13, 0.0f);
        this.k00 = new ModelRenderer(this, 100, 60);
        this.k00.setRotationPoint(14.0f, -12.0f, 0.0f);
        this.k00.addBox(0.0f, 0.0f, 0.0f, 5, 8, 8, 0.0f);
        this.setRotateAngle(this.k00, -0.34906584f, 0.2617994f, 0.0f);
        this.Head = new ModelRenderer(this, 0, 70);
        this.Head.setRotationPoint(0.0f, 3.0f, -19.0f);
        this.Head.addBox(-16.0f, -14.0f, -28.0f, 32, 22, 32, 0.0f);
        this.setRotateAngle(this.Head, 0.08726646f, 0.0f, 0.0f);
        this.ArmLeft = new ModelRenderer(this, 0, 31);
        this.ArmLeft.setRotationPoint(13.0f, 15.0f, -9.0f);
        this.ArmLeft.addBox(-4.0f, 0.0f, -4.0f, 8, 30, 8, 0.0f);
        this.setRotateAngle(this.ArmLeft, -0.5235988f, -0.6981317f, -1.0471976f);
        this.Face01 = new ModelRenderer(this, 68, 20);
        this.Face01.setRotationPoint(0.0f, -14.2f, -27.0f);
        this.Face01.addBox(-10.0f, 0.0f, 0.0f, 20, 0, 20, 0.0f);
        this.Back.addChild(this.Body);
        this.Back.addChild(this.NeckBack);
        this.Equip01.addChild(this.Equip02);
        this.TailBack.addChild(this.TailEnd1);
        this.Head.addChild(this.ToothU);
        this.ArmLeft.addChild(this.ArmLeft01);
        this.Back.addChild(this.TailBack);
        this.ArmRight.addChild(this.ArmRight01);
        this.NeckBack.addChild(this.NeckBody);
        this.Equip02.addChild(this.Equip03);
        this.NeckBack.addChild(this.ArmRight);
        this.EquipBase.addChild(this.Equip01);
        this.NeckBack.addChild(this.EquipBase);
        this.NeckBack.addChild(this.Head);
        this.NeckBack.addChild(this.ArmLeft);
        this.GlowBack = new ModelRenderer(this, 0, 0);
        this.GlowBack.setRotationPoint(0.0f, -40.0f, 0.0f);
        this.setRotateAngle(this.GlowBack, 0.7853982f, 0.0f, 0.0f);
        this.GlowNeckBack = new ModelRenderer(this, 0, 0);
        this.GlowNeckBack.setRotationPoint(0.0f, -2.5f, -14.0f);
        this.setRotateAngle(this.GlowNeckBack, 0.08726646f, 0.0f, 0.0f);
        this.GlowHead = new ModelRenderer(this, 0, 0);
        this.GlowHead.setRotationPoint(0.0f, 3.0f, -19.0f);
        this.setRotateAngle(this.GlowHead, 0.08726646f, 0.0f, 0.0f);
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
        GlStateManager.translate(0.0f, 1.1f, 0.0f);
        GlStateManager.scale(0.35f, 0.35f, 0.35f);
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
            this.Back.rotateAngleX = 0.7854f;
            this.ArmLeft.rotateAngleX = -0.5f;
            this.ArmLeft.rotateAngleY = -0.7f;
            this.ArmLeft.rotateAngleZ = -1.2217f;
            this.ArmRight.rotateAngleX = -0.5f;
            this.ArmRight.rotateAngleY = 0.7f;
            this.ArmRight.rotateAngleZ = 1.2217f;
            this.ArmLeft01.rotateAngleX = 0.0f;
            this.ArmLeft01.rotateAngleZ = 1.4f;
            this.ArmRight01.rotateAngleX = 0.0f;
            this.ArmRight01.rotateAngleZ = -1.4f;
            this.Equip01.rotateAngleX = 1.0f;
            this.isKisaragi(ent);
            this.rollEmotion(ent);
            this.motionWatch(f3, f4);
            this.motionTail(angleX);
            if (ent.isSitting()) {
                this.motionSit(ent, angleX);
            } else {
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
        GlStateManager.translate(0.0f, 0.75f, 0.0f);
        this.setFace(2);
        this.isKisaragi(ent);
        this.NeckBack.rotateAngleX = 0.3f;
        this.NeckBack.rotateAngleY = 0.0f;
        this.Head.rotateAngleX = 0.3f;
        this.Head.rotateAngleY = 0.0f;
        this.Equip01.rotateAngleY = 0.5f;
        this.Equip02.rotateAngleZ = 1.0f;
        this.Equip03.rotateAngleZ = -0.8f;
        this.Back.rotateAngleX = -0.3236f;
        this.ArmLeft.rotateAngleX = -1.4f;
        this.ArmLeft.rotateAngleY = -0.7f;
        this.ArmLeft.rotateAngleZ = -0.2618f;
        this.ArmRight.rotateAngleX = -1.4f;
        this.ArmRight.rotateAngleY = 0.9f;
        this.ArmRight.rotateAngleZ = 0.2618f;
        this.ArmLeft01.rotateAngleX = 0.0f;
        this.ArmLeft01.rotateAngleZ = 1.2f;
        this.ArmRight01.rotateAngleX = 0.0f;
        this.ArmRight01.rotateAngleZ = -0.8f;
        this.TailBack.rotateAngleX = -0.1f;
        this.TailEnd1.rotateAngleX = 0.05f;
        this.Equip01.rotateAngleX = 2.0f;
    }

    private void motionLeg(float f, float f1) {
        float angle1 = MathHelper.cos(f * 0.6662f) * 1.1f * f1;
        this.ArmLeft.rotateAngleX = angle1 - 0.5f;
        this.ArmRight.rotateAngleX = -angle1 - 0.5f;
    }

    private void motionSit(BasicEntityShip ent, float angleX) {
        if (ent.getStateEmotion(1) == 4) {
            GlStateManager.translate(0.0f, angleX * 0.2f - 0.05f, angleX * 0.2f);
            this.ArmLeft.rotateAngleZ = -angleX * 0.6f - 1.0472f;
            this.ArmLeft01.rotateAngleZ = angleX * 0.5f + 1.2f;
            this.ArmRight.rotateAngleZ = angleX * 0.6f + 1.0472f;
            this.ArmRight01.rotateAngleZ = -angleX * 0.5f - 1.2f;
            this.TailBack.rotateAngleX = angleX * 0.1f + 0.2f;
            this.TailEnd1.rotateAngleX = angleX * 0.1f + 0.2f;
        } else {
            GlStateManager.translate(0.0f, 0.75f, 0.0f);
            this.Back.rotateAngleX = -0.5236f;
            this.ArmLeft.rotateAngleX = -0.6981f;
            this.ArmLeft.rotateAngleY = -0.2618f;
            this.ArmLeft.rotateAngleZ = -0.2618f;
            this.ArmRight.rotateAngleX = -0.6981f;
            this.ArmRight.rotateAngleY = 0.2618f;
            this.ArmRight.rotateAngleZ = 0.2618f;
            this.ArmLeft01.rotateAngleX = -1.9199f;
            this.ArmLeft01.rotateAngleZ = -0.6981f;
            this.ArmRight01.rotateAngleX = -1.9199f;
            this.ArmRight01.rotateAngleZ = 0.6981f;
            this.TailBack.rotateAngleX = angleX * 0.1f + 0.2f;
            this.TailEnd1.rotateAngleX = angleX * 0.1f + 0.2f;
            this.Equip01.rotateAngleX = 2.0f;
        }
    }

    private void motionTail(float angleX) {
        this.TailBack.rotateAngleX = angleX * 0.2f;
        this.TailEnd1.rotateAngleX = angleX * 0.2f;
        this.Equip01.rotateAngleY = angleX * 0.2f + 0.5f;
        this.Equip02.rotateAngleZ = angleX * 0.3f + 1.0f;
        this.Equip03.rotateAngleZ = angleX * 0.4f - 0.8f;
    }

    private void motionWatch(float f3, float f4) {
        if (f4 != 0.0f) {
            this.NeckBack.rotateAngleX = f4 * 0.005f;
            this.NeckBack.rotateAngleY = f3 * 0.005f;
            this.Head.rotateAngleX = f4 * 0.005f;
            this.Head.rotateAngleY = f3 * 0.005f;
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
