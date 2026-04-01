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

public class ModelDestroyerI
extends ModelBase
implements IModelEmotion {
    private final ModelRenderer PBack;
    private final ModelRenderer PNeck;
    private final ModelRenderer PHead;
    private final ModelRenderer[] PEyeLightL = new ModelRenderer[3];
    private final ModelRenderer[] PEyeLightR = new ModelRenderer[3];
    private final ModelRenderer PJawBottom;
    private final ModelRenderer PBody;
    private final ModelRenderer PLegLeft;
    private final ModelRenderer PLegLeftEnd;
    private final ModelRenderer PLegRight;
    private final ModelRenderer PLegRightEnd;
    private final ModelRenderer PTail;
    private final ModelRenderer PTailLeft;
    private final ModelRenderer PTailLeftEnd;
    private final ModelRenderer PTailRight;
    private final ModelRenderer PTailRightEnd;
    private final ModelRenderer PTailEnd;
    private final ModelRenderer PKisaragi00;
    private final ModelRenderer PKisaragi01;
    private final ModelRenderer PKisaragi02;
    private final ModelRenderer PKisaragi03;
    private final ModelRenderer GlowPBack;
    private final ModelRenderer GlowPNeck;
    private final ModelRenderer GlowPHead;

    public ModelDestroyerI() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.setTextureOffset("PBack.Back", 128, 8);
        this.setTextureOffset("PNeck.NeckBack", 128, 0);
        this.setTextureOffset("PNeck.NeckNeck", 128, 28);
        this.setTextureOffset("PNeck.NeckBody", 0, 70);
        this.setTextureOffset("PHead.Head", 0, 0);
        this.setTextureOffset("PHead.ToothTopMid", 96, 0);
        this.setTextureOffset("PHead.ToothTopRight", 128, 54);
        this.setTextureOffset("PHead.ToothTopLeft", 128, 54);
        this.setTextureOffset("PHead.JawTop", 0, 102);
        this.setTextureOffset("PJawBottom.JawBottom", 92, 64);
        this.setTextureOffset("PJawBottom.ToothBottomLeft", 96, 19);
        this.setTextureOffset("PJawBottom.ToothBottomRight", 96, 19);
        this.setTextureOffset("PJawBottom.ToothBottomMid", 0, 0);
        this.setTextureOffset("PBody.Body", 0, 64);
        this.setTextureOffset("PLegLeft.LegLeftFront", 0, 80);
        this.setTextureOffset("PLegLeftEnd.LegLeftEnd", 0, 90);
        this.setTextureOffset("PLegRight.LegRightFront", 0, 80);
        this.setTextureOffset("PLegRightEnd.LegRightEnd", 0, 90);
        this.setTextureOffset("PTail.TailBack", 128, 16);
        this.setTextureOffset("PTail.TailBody", 0, 68);
        this.setTextureOffset("PTailLeft.TailLeftFront", 128, 28);
        this.setTextureOffset("PTailLeftEnd.TailLeftEnd", 128, 36);
        this.setTextureOffset("PTailRight.TailRightFront", 128, 28);
        this.setTextureOffset("PTailRightEnd.TailRightEnd", 128, 36);
        this.setTextureOffset("PTailEnd.TailEnd", 128, 26);
        this.setTextureOffset("Eye01L", 138, 64);
        this.setTextureOffset("Eye02L", 138, 85);
        this.setTextureOffset("Eye03L", 138, 106);
        this.setTextureOffset("Eye01R", 138, 64);
        this.setTextureOffset("Eye02R", 138, 85);
        this.setTextureOffset("Eye03R", 138, 106);
        this.setTextureOffset("PKisaragi00.k00", 66, 102);
        this.setTextureOffset("PKisaragi01.k01", 114, 102);
        this.setTextureOffset("PKisaragi02.k02", 92, 102);
        this.setTextureOffset("PKisaragi03.k03", 92, 102);
        this.PBack = new ModelRenderer(this, "PBack");
        this.PBack.setRotationPoint(-8.0f, -16.0f, 0.0f);
        this.setRotation(this.PBack, 0.0f, 0.0f, -0.31f);
        this.PBack.addBox("Back", -12.0f, -10.0f, -12.0f, 28, 20, 24);
        this.PNeck = new ModelRenderer(this, "PNeck");
        this.PNeck.setRotationPoint(15.0f, 0.0f, 0.0f);
        this.setRotation(this.PNeck, 0.0f, 0.0f, 0.2f);
        this.PNeck.addBox("NeckBack", -3.0f, -11.0f, -13.0f, 30, 26, 26);
        this.PNeck.addBox("NeckNeck", 6.0f, 15.0f, -10.0f, 21, 4, 20);
        this.PNeck.addBox("NeckBody", -8.0f, 7.0f, -9.0f, 18, 14, 18);
        this.PHead = new ModelRenderer(this, "PHead");
        this.PHead.setRotationPoint(26.0f, 0.0f, 0.0f);
        this.setRotation(this.PHead, 0.0f, 0.0f, 0.3f);
        this.PHead.addBox("Head", -3.0f, -12.0f, -16.0f, 32, 32, 32);
        this.PHead.addBox("ToothTopMid", 14.5f, 20.0f, -6.0f, 4, 6, 12);
        this.PHead.addBox("ToothTopRight", 0.0f, 20.0f, -10.0f, 18, 6, 4);
        this.PHead.addBox("ToothTopLeft", 0.0f, 20.0f, 6.0f, 18, 6, 4);
        this.PHead.addBox("JawTop", -3.0f, 20.0f, -11.0f, 22, 2, 22);
        this.PEyeLightL[0] = new ModelRenderer(this, 138, 64);
        this.PEyeLightL[0].mirror = true;
        this.PEyeLightL[0].addBox(-3.0f, 0.0f, 15.1f, 24, 20, 1);
        this.PEyeLightR[0] = new ModelRenderer(this, 138, 64);
        this.PEyeLightR[0].addBox(-3.0f, 0.0f, -16.1f, 24, 20, 1);
        this.PEyeLightL[1] = new ModelRenderer(this, 138, 85);
        this.PEyeLightL[1].mirror = true;
        this.PEyeLightL[1].addBox(-3.0f, 0.0f, 15.1f, 24, 20, 1).isHidden = true;
        this.PEyeLightR[1] = new ModelRenderer(this, 138, 85);
        this.PEyeLightR[1].addBox(-3.0f, 0.0f, -16.1f, 24, 20, 1).isHidden = true;
        this.PEyeLightL[2] = new ModelRenderer(this, 138, 106);
        this.PEyeLightL[2].mirror = true;
        this.PEyeLightL[2].addBox(-3.0f, 0.0f, 15.1f, 24, 20, 1).isHidden = true;
        this.PEyeLightR[2] = new ModelRenderer(this, 138, 106);
        this.PEyeLightR[2].addBox(-3.0f, 0.0f, -16.1f, 24, 20, 1).isHidden = true;
        this.PKisaragi00 = new ModelRenderer(this, "PKisaragi00");
        this.PKisaragi01 = new ModelRenderer(this, "PKisaragi01");
        this.PKisaragi02 = new ModelRenderer(this, "PKisaragi02");
        this.PKisaragi03 = new ModelRenderer(this, "PKisaragi03");
        this.PKisaragi00.setRotationPoint(-7.0f, -9.0f, 14.0f);
        this.PKisaragi01.setRotationPoint(-7.0f, -9.0f, 14.0f);
        this.PKisaragi02.setRotationPoint(-7.0f, -9.0f, 14.0f);
        this.PKisaragi03.setRotationPoint(-7.0f, -9.0f, 14.0f);
        this.PKisaragi00.addBox("k00", 0.0f, 0.0f, 0.0f, 8, 8, 5);
        this.PKisaragi01.addBox("k01", -2.0f, -16.0f, 1.0f, 8, 20, 3);
        this.PKisaragi02.addBox("k02", -7.0f, -17.0f, 0.8f, 8, 18, 3);
        this.PKisaragi03.addBox("k03", -9.0f, -18.0f, 0.6f, 8, 18, 3);
        this.setRotation(this.PKisaragi01, 0.0f, 0.0f, -0.524f);
        this.setRotation(this.PKisaragi02, 0.0f, 0.0f, -1.396f);
        this.setRotation(this.PKisaragi03, 0.0f, 0.0f, -2.094f);
        this.PJawBottom = new ModelRenderer(this, "PJawBottom");
        this.PJawBottom.setRotationPoint(-6.0f, 18.0f, 0.0f);
        this.setRotation(this.PJawBottom, 0.0f, 0.0f, -0.2f);
        this.PJawBottom.addBox("JawBottom", -3.0f, 0.0f, -10.0f, 3, 18, 20);
        this.PJawBottom.addBox("ToothBottomLeft", -1.0f, 7.5f, 6.0f, 4, 10, 3);
        this.PJawBottom.addBox("ToothBottomRight", -1.0f, 7.5f, -9.0f, 4, 10, 3);
        this.PJawBottom.addBox("ToothBottomMid", -1.0f, 14.5f, -6.0f, 4, 3, 12);
        this.PHead.addChild(this.PJawBottom);
        this.PNeck.addChild(this.PHead);
        this.PBack.addChild(this.PNeck);
        this.PBody = new ModelRenderer(this, "PBody");
        this.PBody.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.PBody.addBox("Body", -10.0f, 10.0f, -11.0f, 24, 16, 22);
        this.PLegLeft = new ModelRenderer(this, "PLegLeft");
        this.PLegLeft.setRotationPoint(-3.0f, 24.0f, 6.0f);
        this.PLegLeft.addBox("LegLeftFront", -3.0f, -4.0f, -1.0f, 8, 14, 8);
        this.PLegLeftEnd = new ModelRenderer(this, "PLegLeftEnd");
        this.PLegLeftEnd.setRotationPoint(1.0f, 8.0f, 4.0f);
        this.PLegLeftEnd.addBox("LegLeftEnd", -12.0f, -3.0f, -4.0f, 12, 6, 6);
        this.PLegLeft.addChild(this.PLegLeftEnd);
        this.PBody.addChild(this.PLegLeft);
        this.PLegRight = new ModelRenderer(this, "PLegRight");
        this.PLegRight.setRotationPoint(-3.0f, 24.0f, -8.0f);
        this.PLegRight.addBox("LegRightFront", -3.0f, -4.0f, -5.0f, 8, 14, 8);
        this.PLegRightEnd = new ModelRenderer(this, "PLegRightEnd");
        this.PLegRightEnd.setRotationPoint(1.0f, 8.0f, -1.0f);
        this.PLegRightEnd.addBox("LegRightEnd", -12.0f, -3.0f, -3.0f, 12, 6, 6);
        this.PLegRight.addChild(this.PLegRightEnd);
        this.PBody.addChild(this.PLegRight);
        this.PBack.addChild(this.PBody);
        this.PTail = new ModelRenderer(this, "PTail");
        this.PTail.setRotationPoint(-12.0f, -2.0f, 0.0f);
        this.setRotation(this.PTail, 0.0f, 0.0f, 0.25f);
        this.PTail.addBox("TailBack", -22.0f, -6.0f, -10.0f, 26, 16, 20);
        this.PTail.addBox("TailBody", -8.0f, 2.0f, -8.0f, 18, 18, 14);
        this.PTailLeft = new ModelRenderer(this, "PTailLeft");
        this.PTailLeft.setRotationPoint(-12.0f, 4.0f, 8.0f);
        this.setRotation(this.PTailLeft, 0.5f, 0.0f, 0.25f);
        this.PTailLeft.addBox("TailLeftFront", -8.0f, -4.0f, 0.0f, 12, 18, 6);
        this.PTailLeftEnd = new ModelRenderer(this, "PTailLeftEnd");
        this.PTailLeftEnd.setRotationPoint(0.0f, 9.0f, 5.0f);
        this.setRotation(this.PTailLeftEnd, 0.0f, 0.0f, -0.4f);
        this.PTailLeftEnd.addBox("TailLeftEnd", -24.0f, -4.0f, -2.0f, 24, 12, 4);
        this.PTailLeft.addChild(this.PTailLeftEnd);
        this.PTail.addChild(this.PTailLeft);
        this.PTailRight = new ModelRenderer(this, "PTailRight");
        this.PTailRight.setRotationPoint(-12.0f, 4.0f, -8.0f);
        this.setRotation(this.PTailRight, -0.5f, 0.0f, 0.25f);
        this.PTailRight.addBox("TailRightFront", -8.0f, -4.0f, -6.0f, 12, 18, 6);
        this.PTailRightEnd = new ModelRenderer(this, "PTailRightEnd");
        this.PTailRightEnd.setRotationPoint(0.0f, 9.0f, -5.0f);
        this.setRotation(this.PTailRightEnd, 0.0f, 0.0f, -0.4f);
        this.PTailRightEnd.addBox("TailRightEnd", -24.0f, -4.0f, -2.0f, 24, 12, 4);
        this.PTailRight.addChild(this.PTailRightEnd);
        this.PTail.addChild(this.PTailRight);
        this.PTailEnd = new ModelRenderer(this, "PTailEnd");
        this.PTailEnd.setRotationPoint(-22.0f, 2.0f, 0.0f);
        this.setRotation(this.PTailEnd, 0.0f, 0.0f, 0.3f);
        this.PTailEnd.addBox("TailEnd", -20.0f, -6.0f, -8.0f, 24, 10, 16);
        this.PTail.addChild(this.PTailEnd);
        this.PBack.addChild(this.PTail);
        this.GlowPBack = new ModelRenderer(this, "GlowPBack");
        this.GlowPBack.setRotationPoint(-8.0f, -16.0f, 0.0f);
        this.setRotation(this.GlowPBack, 0.0f, 0.0f, -0.31f);
        this.GlowPNeck = new ModelRenderer(this, "GlowPNeck");
        this.GlowPNeck.setRotationPoint(15.0f, 0.0f, 0.0f);
        this.setRotation(this.GlowPNeck, 0.0f, 0.0f, 0.2f);
        this.GlowPHead = new ModelRenderer(this, "GlowPHead");
        this.GlowPHead.setRotationPoint(26.0f, 0.0f, 0.0f);
        this.setRotation(this.GlowPHead, 0.0f, 0.0f, 0.3f);
        this.GlowPHead.addChild(this.PEyeLightL[0]);
        this.GlowPHead.addChild(this.PEyeLightR[0]);
        this.GlowPHead.addChild(this.PEyeLightL[1]);
        this.GlowPHead.addChild(this.PEyeLightR[1]);
        this.GlowPHead.addChild(this.PEyeLightL[2]);
        this.GlowPHead.addChild(this.PEyeLightR[2]);
        this.GlowPHead.addChild(this.PKisaragi00);
        this.GlowPHead.addChild(this.PKisaragi01);
        this.GlowPHead.addChild(this.PKisaragi02);
        this.GlowPHead.addChild(this.PKisaragi03);
        this.GlowPNeck.addChild(this.GlowPHead);
        this.GlowPBack.addChild(this.GlowPNeck);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        if (f3 <= -180.0f) {
            f3 += 360.0f;
        } else if (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.45f, 0.4f, 0.4f);
        GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        this.PBack.render(f5);
        GlStateManager.disableLighting();
        GlStateManager.enableCull();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        this.GlowPBack.render(f5);
        GlStateManager.disableCull();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float angleZ = MathHelper.cos(f2 * 0.125f);
        BasicEntityShip ent = (BasicEntityShip)entity;
        if (ent.getShipDepth(0) > 0.0) {
            GlStateManager.translate(0.0f, angleZ * 0.05f + 0.025f, 0.0f);
        }
        if (ent.getStateFlag(2)) {
            this.motionStopPos(ent);
        } else {
            this.PBack.rotateAngleX = 0.0f;
            this.PLegLeft.rotateAngleX = 0.0f;
            this.PLegLeft.rotateAngleZ = 0.0f;
            this.PLegRight.rotateAngleX = 0.0f;
            this.PLegRight.rotateAngleZ = 0.0f;
            this.isKisaragi(ent);
            this.rollEmotion(ent);
            this.motionWatch(f3, f4, angleZ);
            if (ent.isSitting()) {
                this.motionSit(ent, angleZ);
            } else {
                this.motionLeg(f, f1);
                this.motionTail(angleZ);
                this.PBack.rotateAngleZ = -0.31f;
                GlStateManager.translate(0.0f, 0.42f, 0.0f);
            }
        }
        this.setGlowRotation();
    }

    private void setGlowRotation() {
        this.GlowPBack.rotateAngleX = this.PBack.rotateAngleX;
        this.GlowPBack.rotateAngleY = this.PBack.rotateAngleY;
        this.GlowPBack.rotateAngleZ = this.PBack.rotateAngleZ;
        this.GlowPHead.rotateAngleX = this.PHead.rotateAngleX;
        this.GlowPHead.rotateAngleY = this.PHead.rotateAngleY;
        this.GlowPHead.rotateAngleZ = this.PHead.rotateAngleZ;
        this.GlowPNeck.rotateAngleX = this.PNeck.rotateAngleX;
        this.GlowPNeck.rotateAngleY = this.PNeck.rotateAngleY;
        this.GlowPNeck.rotateAngleZ = this.PNeck.rotateAngleZ;
    }

    private void motionStopPos(BasicEntityShip ent) {
        GlStateManager.translate(0.0f, 0.75f, 0.0f);
        this.isKisaragi(ent);
        this.setFace(2);
        this.PBack.rotateAngleX = 1.4835f;
        this.PBack.rotateAngleZ = 0.0f;
        this.PNeck.rotateAngleY = 0.0f;
        this.PNeck.rotateAngleZ = 0.2f;
        this.PHead.rotateAngleY = 0.0f;
        this.PHead.rotateAngleZ = 0.2f;
        this.PTail.rotateAngleY = 0.0f;
        this.PLegLeft.rotateAngleX = -1.0472f;
        this.PLegLeft.rotateAngleZ = 0.0f;
        this.PLegLeftEnd.rotateAngleZ = -1.4f;
        this.PLegRight.rotateAngleX = 0.087f;
        this.PLegRight.rotateAngleZ = -0.7854f;
        this.PLegRightEnd.rotateAngleZ = -1.4f;
        this.PTail.rotateAngleZ = 0.2f;
        this.PTailEnd.rotateAngleZ = 0.3f;
        this.PJawBottom.rotateAngleZ = -0.3f;
    }

    private void isKisaragi(BasicEntityShip ent) {
        boolean flag;
        this.PKisaragi00.isHidden = flag = !EmotionHelper.checkModelState(0, ent.getStateEmotion(0));
        this.PKisaragi01.isHidden = flag;
        this.PKisaragi02.isHidden = flag;
        this.PKisaragi03.isHidden = flag;
    }

    private void motionSit(BasicEntityShip ent, float angleZ) {
        if (ent.getStateEmotion(1) == 4) {
            GlStateManager.translate(0.0f, 0.5f, 0.0f);
            this.PBack.rotateAngleZ = 0.6f;
            this.PNeck.rotateAngleZ = -0.25f;
            this.PHead.rotateAngleZ = -0.3f;
            this.PLegRight.rotateAngleZ = -1.0f;
            this.PLegLeft.rotateAngleZ = -1.0f;
            this.PLegRightEnd.rotateAngleZ = -1.1f;
            this.PLegLeftEnd.rotateAngleZ = -1.1f;
            this.PTail.rotateAngleZ = -0.6f;
            this.PTailEnd.rotateAngleZ = -0.6f;
            this.PJawBottom.rotateAngleZ = -0.7f;
        } else {
            GlStateManager.translate(0.0f, 0.68f, 0.0f);
            this.PBack.rotateAngleZ = -0.8f;
            this.PNeck.rotateAngleZ = -0.3f;
            this.PLegRight.rotateAngleZ = -0.8f;
            this.PLegLeft.rotateAngleZ = -0.8f;
            this.PLegRightEnd.rotateAngleZ = -1.4f;
            this.PLegLeftEnd.rotateAngleZ = -1.4f;
            this.PTail.rotateAngleZ = 0.4f;
            this.PTailEnd.rotateAngleZ = angleZ * 0.2f + 0.4f;
            this.PJawBottom.rotateAngleZ = angleZ * 0.05f - 0.3f;
            this.PHead.rotateAngleZ = angleZ * 0.02f + 0.4f;
        }
    }

    private void motionTail(float angleZ) {
        this.PTail.rotateAngleZ = angleZ * 0.2f;
        this.PTailEnd.rotateAngleZ = angleZ * 0.3f;
        this.PJawBottom.rotateAngleZ = angleZ * 0.2f - 0.3f;
    }

    private void motionLeg(float f, float f1) {
        this.PLegRight.rotateAngleZ = MathHelper.cos(f * 0.6662f) * 1.4f * f1 - 0.6f;
        this.PLegLeft.rotateAngleZ = MathHelper.cos(f * 0.6662f + (float)Math.PI) * 1.4f * f1 - 0.6f;
        this.PLegRightEnd.rotateAngleZ = MathHelper.sin(f * 0.6662f) * f1 - 0.4f;
        this.PLegLeftEnd.rotateAngleZ = MathHelper.sin(f * 0.6662f + (float)Math.PI) * f1 - 0.4f;
    }

    private void motionWatch(float f3, float f4, float angleZ) {
        if (f4 != 0.0f) {
            this.PNeck.rotateAngleY = f3 * 0.006f;
            this.PNeck.rotateAngleZ = f4 * 0.006f;
            this.PHead.rotateAngleY = f3 * 0.006f;
            this.PHead.rotateAngleZ = f4 * 0.006f;
            this.PTail.rotateAngleY = f3 * -0.006f;
        } else {
            this.PNeck.rotateAngleY = 0.0f;
            this.PNeck.rotateAngleZ = 0.2f;
            this.PHead.rotateAngleY = 0.0f;
            this.PHead.rotateAngleZ = angleZ * 0.15f + 0.2f;
            this.PTail.rotateAngleY = 0.0f;
        }
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
                this.PEyeLightL[0].isHidden = false;
                this.PEyeLightR[0].isHidden = false;
                this.PEyeLightL[1].isHidden = true;
                this.PEyeLightR[1].isHidden = true;
                this.PEyeLightL[2].isHidden = true;
                this.PEyeLightR[2].isHidden = true;
                break;
            }
            case 1: {
                this.PEyeLightL[0].isHidden = true;
                this.PEyeLightR[0].isHidden = true;
                this.PEyeLightL[1].isHidden = false;
                this.PEyeLightR[1].isHidden = false;
                this.PEyeLightL[2].isHidden = true;
                this.PEyeLightR[2].isHidden = true;
                break;
            }
            case 2: {
                this.PEyeLightL[0].isHidden = true;
                this.PEyeLightR[0].isHidden = true;
                this.PEyeLightL[1].isHidden = true;
                this.PEyeLightR[1].isHidden = true;
                this.PEyeLightL[2].isHidden = false;
                this.PEyeLightR[2].isHidden = false;
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
