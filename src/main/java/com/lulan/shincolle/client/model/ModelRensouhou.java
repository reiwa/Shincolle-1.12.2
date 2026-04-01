package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelRensouhou
extends ModelBase
implements IModelEmotion {
    private final ModelRenderer BodyMain;
    private final ModelRenderer SwimRing;
    private final ModelRenderer Head;
    private final ModelRenderer ArmLeft;
    private final ModelRenderer ArmRight;
    private final ModelRenderer LegLeft;
    private final ModelRenderer LegRight;
    private final ModelRenderer Propeller;
    private final ModelRenderer EarL;
    private final ModelRenderer EarR;
    private final ModelRenderer HeadBack;
    private final ModelRenderer Radar;
    private final ModelRenderer CannonL01;
    private final ModelRenderer CannonR01;
    private final ModelRenderer Face0;
    private final ModelRenderer Face1;
    private final ModelRenderer Face2;
    private final ModelRenderer CannonL02;
    private final ModelRenderer CannonR02;

    public ModelRensouhou() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.CannonL02 = new ModelRenderer(this, 0, 1);
        this.CannonL02.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.CannonL02.addBox(-1.5f, -1.5f, -26.0f, 3, 3, 20, 0.0f);
        this.Propeller = new ModelRenderer(this, 0, 24);
        this.Propeller.setRotationPoint(0.0f, 4.0f, 9.0f);
        this.Propeller.addBox(-2.5f, -2.5f, 0.0f, 5, 5, 2, 0.0f);
        this.LegRight = new ModelRenderer(this, 0, 0);
        this.LegRight.setRotationPoint(-4.0f, 6.0f, 0.0f);
        this.LegRight.addBox(-2.5f, 0.0f, -7.0f, 5, 2, 7, 0.0f);
        this.setRotateAngle(this.LegRight, 0.5235988f, 0.34906584f, 0.0f);
        this.Face2 = new ModelRenderer(this, 88, 0);
        this.Face2.setRotationPoint(0.0f, -8.0f, -9.1f);
        this.Face2.addBox(-8.5f, 0.0f, 0.0f, 17, 9, 0, 0.0f);
        this.BodyMain = new ModelRenderer(this, 0, 0);
        this.BodyMain.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.BodyMain.addBox(-5.0f, -6.0f, -5.0f, 10, 11, 10, 0.0f);
        this.ArmLeft = new ModelRenderer(this, 0, 0);
        this.ArmLeft.setRotationPoint(5.0f, -4.0f, -4.0f);
        this.ArmLeft.addBox(-2.5f, 0.0f, -8.0f, 5, 2, 8, 0.0f);
        this.setRotateAngle(this.ArmLeft, 1.0471976f, -0.5235988f, 0.0f);
        this.EarL = new ModelRenderer(this, 55, 20);
        this.EarL.setRotationPoint(7.0f, -11.0f, -9.0f);
        this.EarL.addBox(-2.0f, 0.0f, 0.0f, 4, 3, 7, 0.0f);
        this.CannonR02 = new ModelRenderer(this, 0, 1);
        this.CannonR02.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.CannonR02.addBox(-1.5f, -1.5f, -26.0f, 3, 3, 20, 0.0f);
        this.LegLeft = new ModelRenderer(this, 0, 0);
        this.LegLeft.setRotationPoint(4.0f, 6.0f, 0.0f);
        this.LegLeft.addBox(-2.5f, 0.0f, -7.0f, 5, 2, 7, 0.0f);
        this.setRotateAngle(this.LegLeft, 0.5235988f, -0.34906584f, 0.0f);
        this.CannonR01 = new ModelRenderer(this, 54, 36);
        this.CannonR01.setRotationPoint(-2.5f, -9.0f, -2.0f);
        this.CannonR01.addBox(-2.0f, -2.0f, -6.0f, 4, 4, 6, 0.0f);
        this.setRotateAngle(this.CannonR01, -0.5235988f, (float)Math.PI / 90, 0.0f);
        this.Face1 = new ModelRenderer(this, 54, 9);
        this.Face1.setRotationPoint(0.0f, -8.0f, -9.1f);
        this.Face1.addBox(-8.5f, 0.0f, 0.0f, 17, 9, 0, 0.0f);
        this.ArmRight = new ModelRenderer(this, 0, 0);
        this.ArmRight.setRotationPoint(-5.0f, -4.0f, -4.0f);
        this.ArmRight.addBox(-2.5f, 0.0f, -8.0f, 5, 2, 8, 0.0f);
        this.setRotateAngle(this.ArmRight, 1.0471976f, 0.5235988f, 0.0f);
        this.Radar = new ModelRenderer(this, 0, 37);
        this.Radar.setRotationPoint(5.0f, -15.0f, -5.0f);
        this.Radar.addBox(0.0f, 0.0f, 0.0f, 4, 4, 5, 0.0f);
        this.CannonL01 = new ModelRenderer(this, 54, 36);
        this.CannonL01.setRotationPoint(2.5f, -9.0f, -2.0f);
        this.CannonL01.addBox(-2.0f, -2.0f, -6.0f, 4, 4, 6, 0.0f);
        this.setRotateAngle(this.CannonL01, -0.5235988f, (float)(-Math.PI) / 90, 0.0f);
        this.HeadBack = new ModelRenderer(this, 70, 22);
        this.HeadBack.setRotationPoint(0.0f, -12.0f, -2.0f);
        this.HeadBack.addBox(-9.0f, 0.0f, 0.0f, 18, 4, 11, 0.0f);
        this.Face0 = new ModelRenderer(this, 54, 0);
        this.Face0.setRotationPoint(0.0f, -8.0f, -9.1f);
        this.Face0.addBox(-8.5f, 0.0f, 0.0f, 17, 9, 0, 0.0f);
        this.SwimRing = new ModelRenderer(this, 0, 29);
        this.SwimRing.setRotationPoint(0.0f, 5.0f, 0.0f);
        this.SwimRing.addBox(-9.0f, 0.0f, -9.0f, 18, 7, 18, 0.0f);
        this.EarR = new ModelRenderer(this, 55, 20);
        this.EarR.mirror = true;
        this.EarR.setRotationPoint(-7.0f, -11.0f, -9.0f);
        this.EarR.addBox(-2.0f, 0.0f, 0.0f, 4, 3, 7, 0.0f);
        this.Head = new ModelRenderer(this, 56, 37);
        this.Head.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.Head.addBox(-9.0f, -8.0f, -9.0f, 18, 9, 18, 0.0f);
        this.CannonL01.addChild(this.CannonL02);
        this.SwimRing.addChild(this.Propeller);
        this.SwimRing.addChild(this.LegRight);
        this.Head.addChild(this.Face2);
        this.BodyMain.addChild(this.ArmLeft);
        this.Head.addChild(this.EarL);
        this.CannonR01.addChild(this.CannonR02);
        this.SwimRing.addChild(this.LegLeft);
        this.Head.addChild(this.CannonR01);
        this.Head.addChild(this.Face1);
        this.BodyMain.addChild(this.ArmRight);
        this.Head.addChild(this.Radar);
        this.Head.addChild(this.CannonL01);
        this.Head.addChild(this.HeadBack);
        this.Head.addChild(this.Face0);
        this.BodyMain.addChild(this.SwimRing);
        this.Head.addChild(this.EarR);
        this.BodyMain.addChild(this.Head);
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
        float scale;
        float offsetY;
        switch (((IShipEmotion)entity).getScaleLevel()) {
            case 3: {
                scale = 1.08f;
                offsetY = -0.09f;
                break;
            }
            case 2: {
                scale = 0.81f;
                offsetY = 0.4f;
                break;
            }
            case 1: {
                scale = 0.54f;
                offsetY = 1.32f;
                break;
            }
            default: {
                scale = 0.27f;
                offsetY = 4.09f;
            }
        }
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.scale(scale, scale, scale);
        GlStateManager.translate(0.0f, offsetY, 0.0f);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.BodyMain.render(f5);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        IShipEmotion ent = (IShipEmotion)entity;
        EmotionHelper.rollEmotion(this, ent);
        this.motionHumanPos(f, f1, f2, f3, ent);
    }

    private void motionHumanPos(float f, float f1, float f2, float f3, IShipEmotion ent) {
        float angleX = MathHelper.cos(f2 * 0.08f);
        float angleRun = MathHelper.cos(f) * f1;
        float addk1;
        float addk2;
        addk1 = MathHelper.cos(f * 0.7f) * f1 + 0.7f;
        addk2 = MathHelper.cos(f * 0.7f + (float)Math.PI) * f1 + 0.7f;
        this.Head.rotateAngleY = f3 / 57.0f;
        this.BodyMain.rotateAngleX = 0.0f;
        this.ArmLeft.rotateAngleX = angleX * 0.3f + 0.9f;
        this.ArmRight.rotateAngleX = angleX * 0.3f + 0.9f;
        this.CannonL01.rotateAngleX = angleX * 0.05f - 0.5f;
        this.CannonR01.rotateAngleX = -angleX * 0.05f - 0.5f;
        this.Propeller.rotateAngleZ = f2 / 4.0f % 360.0f;
        if (f1 > 0.9f) {
            this.setFace(2);
            this.BodyMain.rotateAngleX = 0.2618f;
            this.ArmLeft.rotateAngleX = angleRun * 0.3f + 0.9f;
            this.ArmRight.rotateAngleX = angleRun * 0.3f + 0.9f;
            this.CannonL01.rotateAngleX = angleRun * 0.05f - 0.5f;
            this.CannonR01.rotateAngleX = -angleRun * 0.05f - 0.5f;
            this.Propeller.rotateAngleZ = f / 2.0f % 360.0f;
        }
        if (ent.getAttackTick() > 0) {
            this.setFace(2);
        }
        this.LegLeft.rotateAngleX = addk1;
        this.LegRight.rotateAngleX = addk2;
    }

    @Override
    public void setFace(int emo) {
        switch (emo) {
            case 0: {
                this.Face0.isHidden = false;
                this.Face1.isHidden = true;
                this.Face2.isHidden = true;
                break;
            }
            case 1: 
            case 4: {
                this.Face0.isHidden = true;
                this.Face1.isHidden = false;
                this.Face2.isHidden = true;
                break;
            }
            case 2: 
            case 3: {
                this.Face0.isHidden = true;
                this.Face1.isHidden = true;
                this.Face2.isHidden = false;
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
