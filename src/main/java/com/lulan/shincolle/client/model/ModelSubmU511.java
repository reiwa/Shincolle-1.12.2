package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelSubmU511
extends ShipModelBaseAdv {
    private final ModelRenderer BodyMain;
    private final ModelRenderer Neck;
    private final ModelRenderer ArmLeft01;
    private final ModelRenderer ArmRight01;
    private final ModelRenderer Butt;
    private final ModelRenderer Cloth01;
    private final ModelRenderer EquipBase;
    private final ModelRenderer Head;
    private final ModelRenderer Pipe;
    private final ModelRenderer Hair;
    private final ModelRenderer HairMain;
    private final ModelRenderer Hat01;
    private final ModelRenderer Ahoke;
    private final ModelRenderer HairL01;
    private final ModelRenderer HairR01;
    private final ModelRenderer HairL02;
    private final ModelRenderer HairR02;
    private final ModelRenderer Hair01;
    private final ModelRenderer Hat02;
    private final ModelRenderer Ear1;
    private final ModelRenderer Ear2;
    private final ModelRenderer ArmLeft02;
    private final ModelRenderer ArmLeft03;
    private final ModelRenderer ArmRight02;
    private final ModelRenderer ArmRight03;
    private final ModelRenderer LegRight01;
    private final ModelRenderer LegLeft01;
    private final ModelRenderer Skirt;
    private final ModelRenderer LegRight02;
    private final ModelRenderer LegLeft02;
    private final ModelRenderer EquipMid;
    private final ModelRenderer EquipL;
    private final ModelRenderer EquipR;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowNeck;
    private final ModelRenderer GlowHead;

    public ModelSubmU511() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.offsetItem = new float[]{0.0f, 1.1f, -0.05f};
        this.offsetBlock = new float[]{0.0f, 1.1f, -0.05f};
        this.setDefaultFaceModel();
        this.Cloth01 = new ModelRenderer(this, 84, 0);
        this.Cloth01.setRotationPoint(0.0f, -11.5f, 0.0f);
        this.Cloth01.addBox(-7.0f, 0.0f, -4.5f, 14, 11, 8, 0.0f);
        this.HairL02 = new ModelRenderer(this, 88, 100);
        this.HairL02.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.HairL02.addBox(-1.0f, 0.0f, 0.0f, 2, 8, 3, 0.0f);
        this.setRotateAngle(this.HairL02, -0.17453292f, 0.0f, 0.08726646f);
        this.Hat01 = new ModelRenderer(this, 30, 24);
        this.Hat01.setRotationPoint(0.0f, -15.0f, -6.0f);
        this.Hat01.addBox(-3.0f, -6.0f, 0.5f, 6, 6, 13, 0.0f);
        this.setRotateAngle(this.Hat01, -0.13962634f, 0.0f, 0.0f);
        this.EquipL = new ModelRenderer(this, 0, 23);
        this.EquipL.mirror = true;
        this.EquipL.setRotationPoint(11.5f, 0.0f, 4.0f);
        this.EquipL.addBox(0.0f, 0.0f, -20.0f, 5, 13, 20, 0.0f);
        this.setRotateAngle(this.EquipL, -0.31415927f, -0.17453292f, 0.0f);
        this.HairL01 = new ModelRenderer(this, 88, 100);
        this.HairL01.mirror = true;
        this.HairL01.setRotationPoint(6.5f, 0.0f, -4.0f);
        this.HairL01.addBox(-1.0f, 0.0f, 0.0f, 2, 8, 3, 0.0f);
        this.setRotateAngle(this.HairL01, -0.17453292f, -0.17453292f, -0.13962634f);
        this.Neck = new ModelRenderer(this, 0, 0);
        this.Neck.setRotationPoint(0.0f, -10.5f, 0.0f);
        this.Neck.addBox(-4.5f, -2.0f, -6.0f, 9, 4, 10, 0.0f);
        this.setRotateAngle(this.Neck, 0.05235988f, 0.0f, 0.0f);
        this.ArmRight03 = new ModelRenderer(this, 28, 78);
        this.ArmRight03.setRotationPoint(0.0f, 3.0f, 1.0f);
        this.ArmRight03.addBox(-2.5f, 0.0f, -4.0f, 5, 11, 5, 0.0f);
        this.BodyMain = new ModelRenderer(this, 0, 104);
        this.BodyMain.setRotationPoint(0.0f, -13.0f, 0.0f);
        this.BodyMain.addBox(-6.5f, -11.0f, -4.0f, 13, 21, 7, 0.0f);
        this.HairR02 = new ModelRenderer(this, 88, 100);
        this.HairR02.mirror = true;
        this.HairR02.setRotationPoint(0.2f, 6.0f, 0.0f);
        this.HairR02.addBox(-1.0f, 0.0f, 0.0f, 2, 8, 3, 0.0f);
        this.setRotateAngle(this.HairR02, -0.17453292f, 0.0f, -0.05235988f);
        this.Butt = new ModelRenderer(this, 80, 19);
        this.Butt.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Butt.addBox(-8.0f, 5.0f, -5.0f, 16, 9, 8, 0.0f);
        this.setRotateAngle(this.Butt, 0.2617994f, 0.0f, 0.0f);
        this.ArmRight02 = new ModelRenderer(this, 24, 95);
        this.ArmRight02.setRotationPoint(-0.8f, 7.0f, 0.5f);
        this.ArmRight02.addBox(-2.5f, 0.0f, -3.0f, 5, 3, 5, 0.0f);
        this.ArmRight01 = new ModelRenderer(this, 24, 67);
        this.ArmRight01.setRotationPoint(-7.2f, -9.0f, -0.7f);
        this.ArmRight01.addBox(-4.5f, -1.0f, -3.5f, 7, 8, 7, 0.0f);
        this.setRotateAngle(this.ArmRight01, 0.0f, 0.0f, 0.10471976f);
        this.ArmLeft01 = new ModelRenderer(this, 24, 67);
        this.ArmLeft01.mirror = true;
        this.ArmLeft01.setRotationPoint(7.2f, -9.0f, -0.7f);
        this.ArmLeft01.addBox(-2.5f, -1.0f, -3.5f, 7, 8, 7, 0.0f);
        this.setRotateAngle(this.ArmLeft01, 0.0f, 0.0f, -0.10471976f);
        this.HairR01 = new ModelRenderer(this, 88, 100);
        this.HairR01.setRotationPoint(-6.5f, 0.0f, -4.0f);
        this.HairR01.addBox(-1.0f, 0.0f, 0.0f, 2, 8, 3, 0.0f);
        this.setRotateAngle(this.HairR01, -0.17453292f, 0.17453292f, 0.13962634f);
        this.Skirt = new ModelRenderer(this, 80, 19);
        this.Skirt.setRotationPoint(0.0f, 5.0f, -2.0f);
        this.Skirt.addBox(-8.0f, 0.0f, -4.5f, 16, 9, 8, 0.0f);
        this.setRotateAngle(this.Skirt, 0.34906584f, (float)(-Math.PI), 0.0f);
        this.EquipR = new ModelRenderer(this, 0, 23);
        this.EquipR.setRotationPoint(-11.5f, 0.0f, 4.0f);
        this.EquipR.addBox(-5.0f, 0.0f, -20.0f, 5, 13, 20, 0.0f);
        this.setRotateAngle(this.EquipR, -0.31415927f, 0.17453292f, 0.0f);
        this.ArmLeft03 = new ModelRenderer(this, 28, 78);
        this.ArmLeft03.mirror = true;
        this.ArmLeft03.setRotationPoint(0.0f, 3.0f, 1.0f);
        this.ArmLeft03.addBox(-2.5f, 0.0f, -4.0f, 5, 11, 5, 0.0f);
        this.EquipMid = new ModelRenderer(this, 0, 0);
        this.EquipMid.setRotationPoint(0.0f, -5.0f, 2.0f);
        this.EquipMid.addBox(-13.0f, 0.0f, 0.0f, 26, 12, 5, 0.0f);
        this.setRotateAngle(this.EquipMid, 0.13962634f, 0.0f, 0.0f);
        this.Ear2 = new ModelRenderer(this, 4, 18);
        this.Ear2.setRotationPoint(-8.0f, -1.0f, 0.0f);
        this.Ear2.addBox(0.0f, 0.0f, -4.0f, 0, 8, 5, 0.0f);
        this.setRotateAngle(this.Ear2, 0.0f, 0.0f, 0.2617994f);
        this.Hair = new ModelRenderer(this, 50, 75);
        this.Hair.setRotationPoint(0.0f, -7.5f, -0.5f);
        this.Hair.addBox(-8.0f, -8.0f, -6.8f, 16, 17, 8, 0.0f);
        this.Hair01 = new ModelRenderer(this, 49, 47);
        this.Hair01.setRotationPoint(0.0f, 9.0f, 1.1f);
        this.Hair01.addBox(-7.5f, 0.0f, 0.0f, 15, 18, 9, 0.0f);
        this.setRotateAngle(this.Hair01, 0.2617994f, 0.0f, 0.0f);
        this.HairMain = new ModelRenderer(this, 48, 47);
        this.HairMain.setRotationPoint(0.0f, -15.0f, -3.0f);
        this.HairMain.addBox(-7.5f, 0.0f, 0.0f, 15, 9, 10, 0.0f);
        this.LegRight02 = new ModelRenderer(this, 0, 67);
        this.LegRight02.setRotationPoint(0.0f, 13.0f, -3.0f);
        this.LegRight02.addBox(-3.0f, 0.0f, 0.0f, 6, 14, 6, 0.0f);
        this.Hat02 = new ModelRenderer(this, 4, 17);
        this.Hat02.setRotationPoint(0.0f, 0.5f, 8.4f);
        this.Hat02.addBox(-8.0f, 0.0f, 0.5f, 16, 1, 5, 0.0f);
        this.setRotateAngle(this.Hat02, 0.31415927f, 0.0f, 0.0f);
        this.Ahoke = new ModelRenderer(this, 104, 29);
        this.Ahoke.setRotationPoint(0.0f, -8.0f, -5.0f);
        this.Ahoke.addBox(0.0f, -4.0f, -11.0f, 0, 12, 12, 0.0f);
        this.setRotateAngle(this.Ahoke, 0.0f, 0.5235988f, 0.0f);
        this.Head = new ModelRenderer(this, 44, 101);
        this.Head.setRotationPoint(0.0f, -1.5f, 0.0f);
        this.Head.addBox(-7.0f, -14.5f, -6.5f, 14, 14, 13, 0.0f);
        this.LegLeft02 = new ModelRenderer(this, 0, 67);
        this.LegLeft02.setRotationPoint(0.0f, 13.0f, -3.0f);
        this.LegLeft02.addBox(-3.0f, 0.0f, 0.0f, 6, 14, 6, 0.0f);
        this.Pipe = new ModelRenderer(this, 0, 17);
        this.Pipe.setRotationPoint(7.0f, -1.0f, -3.5f);
        this.Pipe.addBox(0.0f, -26.0f, 0.0f, 1, 25, 1, 0.0f);
        this.setRotateAngle(this.Pipe, -0.08726646f, 0.0f, 0.08726646f);
        this.Ear1 = new ModelRenderer(this, 4, 18);
        this.Ear1.mirror = true;
        this.Ear1.setRotationPoint(8.0f, -1.0f, 0.0f);
        this.Ear1.addBox(0.0f, 0.0f, -4.0f, 0, 8, 5, 0.0f);
        this.setRotateAngle(this.Ear1, 0.0f, 0.0f, -0.2617994f);
        this.LegRight01 = new ModelRenderer(this, 0, 85);
        this.LegRight01.setRotationPoint(-3.8f, 9.5f, -2.7f);
        this.LegRight01.addBox(-3.0f, 0.0f, -3.0f, 6, 13, 6, 0.0f);
        this.setRotateAngle(this.LegRight01, -0.2618f, 0.0f, (float)(-Math.PI) / 90);
        this.LegLeft01 = new ModelRenderer(this, 0, 85);
        this.LegLeft01.setRotationPoint(3.8f, 9.5f, -2.7f);
        this.LegLeft01.addBox(-3.0f, 0.0f, -3.0f, 6, 13, 6, 0.0f);
        this.setRotateAngle(this.LegLeft01, -0.2618f, 0.0f, (float)Math.PI / 90);
        this.EquipBase = new ModelRenderer(this, 60, 0);
        this.EquipBase.setRotationPoint(0.0f, 8.0f, 3.0f);
        this.EquipBase.addBox(-3.0f, 0.0f, 1.0f, 6, 16, 6, 0.0f);
        this.setRotateAngle(this.EquipBase, 0.43633232f, 0.0f, 0.0f);
        this.ArmLeft02 = new ModelRenderer(this, 24, 95);
        this.ArmLeft02.mirror = true;
        this.ArmLeft02.setRotationPoint(0.8f, 7.0f, 0.5f);
        this.ArmLeft02.addBox(-2.5f, 0.0f, -3.0f, 5, 3, 5, 0.0f);
        this.BodyMain.addChild(this.Cloth01);
        this.HairL01.addChild(this.HairL02);
        this.Head.addChild(this.Hat01);
        this.EquipMid.addChild(this.EquipL);
        this.Hair.addChild(this.HairL01);
        this.BodyMain.addChild(this.Neck);
        this.ArmRight02.addChild(this.ArmRight03);
        this.HairR01.addChild(this.HairR02);
        this.BodyMain.addChild(this.Butt);
        this.ArmRight01.addChild(this.ArmRight02);
        this.BodyMain.addChild(this.ArmRight01);
        this.BodyMain.addChild(this.ArmLeft01);
        this.Hair.addChild(this.HairR01);
        this.Butt.addChild(this.Skirt);
        this.EquipMid.addChild(this.EquipR);
        this.ArmLeft02.addChild(this.ArmLeft03);
        this.EquipBase.addChild(this.EquipMid);
        this.Hat02.addChild(this.Ear2);
        this.Head.addChild(this.Hair);
        this.HairMain.addChild(this.Hair01);
        this.Head.addChild(this.HairMain);
        this.LegRight01.addChild(this.LegRight02);
        this.Hat01.addChild(this.Hat02);
        this.Hair.addChild(this.Ahoke);
        this.Neck.addChild(this.Head);
        this.LegLeft01.addChild(this.LegLeft02);
        this.Neck.addChild(this.Pipe);
        this.Hat02.addChild(this.Ear1);
        this.Butt.addChild(this.LegRight01);
        this.Butt.addChild(this.LegLeft01);
        this.BodyMain.addChild(this.EquipBase);
        this.ArmLeft01.addChild(this.ArmLeft02);
        this.GlowBodyMain = new ModelRenderer(this, 0, 0);
        this.GlowBodyMain.setRotationPoint(0.0f, -13.0f, 0.0f);
        this.GlowNeck = new ModelRenderer(this, 0, 0);
        this.GlowNeck.setRotationPoint(0.0f, -10.5f, 0.0f);
        this.setRotateAngle(this.GlowNeck, 0.05235988f, 0.0f, 0.0f);
        this.GlowHead = new ModelRenderer(this, 0, 0);
        this.GlowHead.setRotationPoint(0.0f, -1.5f, 0.0f);
        this.GlowBodyMain.addChild(this.GlowNeck);
        this.GlowNeck.addChild(this.GlowHead);
        this.GlowHead.addChild(this.Face0);
        this.GlowHead.addChild(this.Face1);
        this.GlowHead.addChild(this.Face2);
        this.GlowHead.addChild(this.Face3);
        this.GlowHead.addChild(this.Face4);
        this.GlowHead.addChild(this.Mouth0);
        this.GlowHead.addChild(this.Mouth1);
        this.GlowHead.addChild(this.Mouth2);
        this.GlowHead.addChild(this.Flush0);
        this.GlowHead.addChild(this.Flush1);
        this.armMain = new ModelRenderer[]{this.BodyMain, this.ArmRight01, this.ArmRight02, this.ArmRight03};
        this.armOff = new ModelRenderer[]{this.BodyMain, this.ArmLeft01, this.ArmLeft02, this.ArmLeft03};
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        if (f3 <= -180.0f) {
            f3 += 360.0f;
        } else if (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        switch (((IShipEmotion)entity).getScaleLevel()) {
            case 3: {
                this.scale = 1.44f;
                this.offsetY = -0.45f;
                break;
            }
            case 2: {
                this.scale = 1.08f;
                this.offsetY = -0.06f;
                break;
            }
            case 1: {
                this.scale = 0.72f;
                this.offsetY = 0.66f;
                break;
            }
            default: {
                this.scale = 0.36f;
                this.offsetY = 2.86f;
            }
        }
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.scale(this.scale, this.scale * 0.95f, this.scale);
        GlStateManager.translate(0.0f, this.offsetY, 0.0f);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.BodyMain.render(f5);
        GlStateManager.disableLighting();
        GlStateManager.enableCull();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        this.GlowBodyMain.render(f5);
        GlStateManager.disableCull();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Override
    public void showEquip(IShipEmotion ent) {
        int state = ent.getStateEmotion(0);
        this.EquipBase.isHidden = !EmotionHelper.checkModelState(0, state);
        this.Hat01.isHidden = !EmotionHelper.checkModelState(1, state);
        this.Pipe.isHidden = !EmotionHelper.checkModelState(2, state);
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.rotateAngleX = this.BodyMain.rotateAngleX;
        this.GlowBodyMain.rotateAngleY = this.BodyMain.rotateAngleY;
        this.GlowBodyMain.rotateAngleZ = this.BodyMain.rotateAngleZ;
        this.GlowNeck.rotateAngleX = this.Neck.rotateAngleX;
        this.GlowNeck.rotateAngleY = this.Neck.rotateAngleY;
        this.GlowNeck.rotateAngleZ = this.Neck.rotateAngleZ;
        this.GlowHead.rotateAngleX = this.Head.rotateAngleX;
        this.GlowHead.rotateAngleY = this.Head.rotateAngleY;
        this.GlowHead.rotateAngleZ = this.Head.rotateAngleZ;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        GlStateManager.translate(0.0f, 0.41f + 0.19f * ent.getScaleLevel(), 0.0f);
        this.setFaceHungry(ent);
        this.LegLeft01.rotateAngleY = 0.0f;
        this.LegLeft01.rotateAngleZ = 0.035f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleZ = -0.035f;
        this.LegLeft01.rotateAngleX = -2.8f;
        this.LegLeft02.rotateAngleX = 1.4f;
        this.LegRight01.rotateAngleX = -2.8f;
        this.LegRight02.rotateAngleX = 1.4f;
        this.Pipe.rotateAngleX = -0.0873f;
        this.Ahoke.rotateAngleY = 0.5236f;
        this.Head.rotateAngleX = 0.2618f;
        this.Head.rotateAngleY = 0.0f;
        this.BodyMain.rotateAngleX = 0.35f;
        this.ArmLeft01.rotateAngleX = -0.7f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = -0.12f;
        this.ArmRight01.rotateAngleX = -0.96f;
        this.ArmRight01.rotateAngleY = -0.35f;
        this.ArmRight01.rotateAngleZ = 0.12f;
        this.ArmRight03.rotateAngleZ = -1.57f;
        this.ArmRight03.offsetX = -0.153f;
        this.ArmRight03.offsetY = 0.1f;
        this.Hair01.rotateAngleX = 0.05f;
        this.Ear1.rotateAngleZ = -0.2618f;
        this.Ear2.rotateAngleZ = 0.2618f;
        this.Skirt.rotateAngleX = 2.618f;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float f6;
        float angleX = MathHelper.cos(f2 * 0.08f);
        float angleAdd1 = MathHelper.cos(f * 0.7f) * f1 * 0.5f;
        float angleAdd2 = MathHelper.cos(f * 0.7f + (float)Math.PI) * f1 * 0.5f;
        float addk1;
        float addk2;
        if (ent.getShipDepth(0) > 0.0) {
            GlStateManager.translate(0.0f, angleX * 0.05f + 0.025f, 0.0f);
        }
        addk1 = angleAdd1 - 0.2118f;
        addk2 = angleAdd2 - 0.1118f;
        this.Head.rotateAngleX = f4 * 0.014f + 0.1f;
        this.Head.rotateAngleY = f3 * 0.01f;
        this.Ahoke.rotateAngleY = angleX * 0.25f + 0.5236f;
        this.BodyMain.rotateAngleX = -0.1f;
        this.Hair01.rotateAngleX = angleX * 0.06f + 0.3f;
        this.Hair01.rotateAngleZ = 0.0f;
        this.HairL01.rotateAngleX = -0.17f;
        this.HairL02.rotateAngleX = 0.17f;
        this.HairR01.rotateAngleX = -0.17f;
        this.HairR02.rotateAngleX = 0.17f;
        this.HairL01.rotateAngleZ = -0.14f;
        this.HairL02.rotateAngleZ = 0.08f;
        this.HairR01.rotateAngleZ = 0.14f;
        this.HairR02.rotateAngleZ = -0.05f;
        this.Ear1.rotateAngleZ = angleX * 0.1f - 0.2618f;
        this.Ear2.rotateAngleZ = angleX * 0.1f + 0.2618f;
        this.ArmLeft01.rotateAngleX = angleAdd2 * 0.5f + 0.15f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = -angleX * 0.06f - 0.16f;
        this.ArmRight01.rotateAngleX = angleAdd1 * 0.5f;
        this.ArmRight01.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleZ = angleX * 0.06f + 0.16f;
        this.ArmRight03.rotateAngleZ = 0.0f;
        this.ArmRight03.offsetX = 0.0f;
        this.ArmRight03.offsetY = 0.0f;
        this.LegLeft01.rotateAngleY = 0.0f;
        this.LegLeft01.rotateAngleZ = 0.035f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleZ = -0.035f;
        this.LegLeft02.rotateAngleX = 0.0f;
        this.LegRight02.rotateAngleX = 0.0f;
        this.Pipe.rotateAngleX = -0.0873f;
        this.Skirt.rotateAngleX = 0.35f;
        if (ent.getIsSprinting() || f1 > 0.9f) {
            // empty if block
        }
        this.Head.rotateAngleZ = EmotionHelper.getHeadTiltAngle(ent, f2);
        if (ent.getIsSneaking()) {
            GlStateManager.translate(0.0f, 0.1f, 0.0f);
            this.Head.rotateAngleX -= 0.8727f;
            this.BodyMain.rotateAngleX = 1.0472f;
            this.Hair01.rotateAngleX += 0.2236f;
            addk1 -= 1.2f;
            addk2 -= 1.2f;
            this.Pipe.rotateAngleX = -0.7854f;
            this.Skirt.rotateAngleX = 0.8727f;
        }
        if (ent.getIsSitting() || ent.getIsRiding()) {
            if (ent.getStateEmotion(1) == 4) {
                GlStateManager.translate(0.0f, 0.41f, 0.0f);
                this.Head.rotateAngleX += 0.2618f;
                this.BodyMain.rotateAngleX = 0.35f;
                this.HairL01.rotateAngleX -= 0.2f;
                this.HairR01.rotateAngleX -= 0.2f;
                this.HairL02.rotateAngleX -= 0.2f;
                this.HairR02.rotateAngleX -= 0.2f;
                this.ArmLeft01.rotateAngleX = -angleX * 0.2f - 0.7f;
                this.ArmRight01.rotateAngleX = -0.96f;
                this.ArmRight01.rotateAngleY = -0.35f;
                this.ArmRight03.rotateAngleZ = -1.57f;
                this.ArmRight03.offsetX = -0.153f;
                this.ArmRight03.offsetY = 0.1f;
                this.Hair01.rotateAngleX -= 0.25f;
                addk1 = -2.8f;
                addk2 = -2.8f;
                this.LegLeft02.rotateAngleX = 1.4f;
                this.LegRight02.rotateAngleX = 1.4f;
                this.Skirt.rotateAngleX = 2.618f;
            } else {
                GlStateManager.translate(0.0f, 0.4f, 0.0f);
                this.Head.rotateAngleX -= 0.7f;
                this.BodyMain.rotateAngleX = 0.5236f;
                this.HairL01.rotateAngleX -= 0.3f;
                this.HairR01.rotateAngleX -= 0.3f;
                this.HairL02.rotateAngleX -= 0.3f;
                this.HairR02.rotateAngleX -= 0.3f;
                this.ArmLeft01.rotateAngleX = -0.5236f;
                this.ArmLeft01.rotateAngleZ = 0.3146f;
                this.ArmRight01.rotateAngleX = -0.5236f;
                this.ArmRight01.rotateAngleZ = -0.3146f;
                addk1 = -2.2689f;
                addk2 = -2.2689f;
                this.LegLeft01.rotateAngleY = -0.3491f;
                this.LegRight01.rotateAngleY = 0.3491f;
                this.Pipe.rotateAngleX = -0.7854f;
                this.Skirt.rotateAngleX = 0.8727f;
            }
        }
        if (ent.getAttackTick() > 43) {
            float ft = (50 - ent.getAttackTick()) + (f2 - (int)f2);
            float fa = MathHelper.cos((ft *= 0.08f) * ft * (float)Math.PI);
            float fb = MathHelper.cos(MathHelper.sqrt(ft) * (float)Math.PI);
            this.ArmLeft01.rotateAngleX += -fb * 80.0f * ((float)Math.PI / 180) - 0.9f;
            this.ArmLeft01.rotateAngleY += fa * 20.0f * ((float)Math.PI / 180) - 0.3f;
            this.ArmLeft01.rotateAngleZ += fb * 10.0f * ((float)Math.PI / 180);
        }
        if ((f6 = ent.getSwingTime(f2 - (int)f2)) != 0.0f) {
            float f7 = MathHelper.sin(f6 * f6 * (float)Math.PI);
            float f8 = MathHelper.sin(MathHelper.sqrt(f6) * (float)Math.PI);
            this.ArmRight01.rotateAngleX = -0.4f;
            this.ArmRight01.rotateAngleY = 0.0f;
            this.ArmRight01.rotateAngleZ = -0.2f;
            this.ArmRight01.rotateAngleX += -f8 * 80.0f * ((float)Math.PI / 180);
            this.ArmRight01.rotateAngleY += -f7 * 20.0f * ((float)Math.PI / 180) + 0.2f;
            this.ArmRight01.rotateAngleZ += -f8 * 20.0f * ((float)Math.PI / 180);
        }
        float headX = this.Head.rotateAngleX * -0.5f;
        float headZ = this.Head.rotateAngleZ * -0.5f;
        this.Hair01.rotateAngleX += headX;
        this.Hair01.rotateAngleZ += headZ;
        this.HairL01.rotateAngleZ += headZ;
        this.HairL02.rotateAngleZ += headZ;
        this.HairR01.rotateAngleZ += headZ;
        this.HairR02.rotateAngleZ += headZ;
        this.HairL01.rotateAngleX += headX;
        this.HairL02.rotateAngleX += headX;
        this.HairR01.rotateAngleX += headX;
        this.HairR02.rotateAngleX += headX;
        this.LegLeft01.rotateAngleX = addk1;
        this.LegRight01.rotateAngleX = addk2;
    }

    @Override
    public void setFaceNormal(IShipEmotion ent) {
        this.setFace(0);
        if (ent.getStateEmotion(7) == 4 && (ent.getTickExisted() & 0xFF) > 200) {
            this.setMouth(0);
        } else {
            this.setMouth(3);
        }
    }

    @Override
    public void setFaceBlink0(IShipEmotion ent) {
        this.setFace(0);
    }

    @Override
    public void setFaceBlink1(IShipEmotion ent) {
        this.setFace(1);
    }

    @Override
    public void setFaceCry(IShipEmotion ent) {
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0xFF;
        if (t < 128) {
            this.setFace(6);
            if (t < 64) {
                this.setMouth(2);
            } else {
                this.setMouth(1);
            }
        } else {
            this.setFace(7);
            this.setMouth(2);
        }
    }

    @Override
    public void setFaceAttack(IShipEmotion ent) {
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0x1FF;
        if (t < 160) {
            this.setFace(0);
            if (t < 80) {
                this.setMouth(0);
            } else {
                this.setMouth(1);
            }
        } else if (t < 320) {
            this.setFace(2);
            if (t < 220) {
                this.setMouth(0);
            } else {
                this.setMouth(1);
            }
        } else if (t < 410) {
            this.setFace(3);
            if (t < 360) {
                this.setMouth(0);
            } else {
                this.setMouth(4);
            }
        } else {
            this.setFace(8);
            if (t < 470) {
                this.setMouth(0);
            } else {
                this.setMouth(1);
            }
        }
    }

    @Override
    public void setFaceDamaged(IShipEmotion ent) {
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0x1FF;
        if (t < 200) {
            this.setFace(6);
            if (t < 60) {
                this.setMouth(2);
            } else {
                this.setMouth(1);
            }
        } else if (t < 400) {
            this.setFace(3);
            if (t < 250) {
                this.setMouth(0);
            } else {
                this.setMouth(3);
            }
        } else {
            this.setFace(9);
            if (t < 450) {
                this.setMouth(0);
            } else {
                this.setMouth(1);
            }
        }
    }

    @Override
    public void setFaceScorn(IShipEmotion ent) {
        this.setFace(2);
        this.setMouth(1);
    }

    @Override
    public void setFaceHungry(IShipEmotion ent) {
        this.setFace(4);
        this.setMouth(2);
    }

    @Override
    public void setFaceAngry(IShipEmotion ent) {
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0xFF;
        if (t < 128) {
            this.setFace(1);
            if (t < 64) {
                this.setMouth(3);
            } else {
                this.setMouth(1);
            }
        } else {
            this.setFace(2);
            if (t < 170) {
                this.setMouth(1);
            } else {
                this.setMouth(3);
            }
        }
    }

    @Override
    public void setFaceBored(IShipEmotion ent) {
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0x1FF;
        if (t < 170) {
            this.setFace(1);
            if (t < 80) {
                this.setMouth(0);
            } else {
                this.setMouth(3);
            }
        } else if (t < 340) {
            this.setFace(8);
            if (t < 250) {
                this.setMouth(0);
            } else {
                this.setMouth(3);
            }
        } else {
            this.setFace(0);
            if (t < 420) {
                this.setMouth(0);
            } else {
                this.setMouth(3);
            }
        }
    }

    @Override
    public void setFaceShy(IShipEmotion ent) {
        this.setFlush(true);
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0xFF;
        this.setFace(0);
        if (t < 150) {
            this.setMouth(3);
        } else {
            this.setMouth(2);
        }
    }

    @Override
    public void setFaceHappy(IShipEmotion ent) {
        this.setFlush(true);
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0xFF;
        if (t < 140) {
            this.setFace(3);
            if (t < 80) {
                this.setMouth(3);
            } else {
                this.setMouth(4);
            }
        } else {
            this.setFace(8);
            this.setMouth(0);
        }
    }
}
