package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelDestroyerShimakaze
extends ShipModelBaseAdv {
    private final ModelRenderer BodyMain;
    private final ModelRenderer NeckCloth;
    private final ModelRenderer ArmLeft;
    private final ModelRenderer ArmRight;
    private final ModelRenderer Butt;
    private final ModelRenderer EquipBase;
    private final ModelRenderer Head;
    private final ModelRenderer NeckTie;
    private final ModelRenderer Hair;
    private final ModelRenderer HairMain;
    private final ModelRenderer Ahoke;
    private final ModelRenderer HairL01;
    private final ModelRenderer HairR01;
    private final ModelRenderer HairL02;
    private final ModelRenderer HairAnchor;
    private final ModelRenderer HairR02;
    private final ModelRenderer HairMidL01;
    private final ModelRenderer HairMidR01;
    private final ModelRenderer EarBase;
    private final ModelRenderer HairMidL02;
    private final ModelRenderer HairMidR02;
    private final ModelRenderer EarL01;
    private final ModelRenderer EarL02;
    private final ModelRenderer EarR01;
    private final ModelRenderer EarR02;
    private final ModelRenderer LegRight;
    private final ModelRenderer LegLeft;
    private final ModelRenderer Skirt;
    private final ModelRenderer ShoesR;
    private final ModelRenderer ShoesL;
    private final ModelRenderer EquipHead;
    private final ModelRenderer EquipT01;
    private final ModelRenderer EquipT02;
    private final ModelRenderer EquipT03;
    private final ModelRenderer EquipT04;
    private final ModelRenderer EquipT05;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowNeckCloth;
    private final ModelRenderer GlowHead;

    public ModelDestroyerShimakaze() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.offsetItem = new float[]{-0.16f, 1.24f, -0.03f};
        this.offsetBlock = new float[]{-0.16f, 1.24f, -0.03f};
        this.setDefaultFaceModel();
        this.Head = new ModelRenderer(this, 24, 101);
        this.Head.setRotationPoint(0.0f, -1.5f, 0.0f);
        this.Head.addBox(-7.0f, -14.5f, -6.5f, 14, 14, 13, 0.0f);
        this.HairMain = new ModelRenderer(this, 23, 61);
        this.HairMain.setRotationPoint(0.0f, -15.0f, -3.0f);
        this.HairMain.addBox(-7.5f, 0.0f, 0.0f, 15, 9, 10, 0.0f);
        this.Hair = new ModelRenderer(this, 24, 80);
        this.Hair.setRotationPoint(0.0f, -7.5f, 0.0f);
        this.Hair.addBox(-8.0f, -7.5f, -8.0f, 16, 12, 8, 0.0f);
        this.HairMidR01 = new ModelRenderer(this, 42, 40);
        this.HairMidR01.mirror = true;
        this.HairMidR01.setRotationPoint(-2.5f, 9.0f, 2.5f);
        this.HairMidR01.addBox(-4.5f, 0.0f, 0.0f, 9, 13, 8, 0.0f);
        this.setRotateAngle(this.HairMidR01, 0.13962634f, -0.08726646f, 0.2617994f);
        this.HairMidL02 = new ModelRenderer(this, 46, 21);
        this.HairMidL02.setRotationPoint(0.0f, 12.0f, 3.0f);
        this.HairMidL02.addBox(-4.5f, 0.0f, 0.0f, 9, 14, 5, 0.0f);
        this.setRotateAngle(this.HairMidL02, 0.13962634f, 0.0f, -0.13962634f);
        this.HairMidL01 = new ModelRenderer(this, 42, 40);
        this.HairMidL01.setRotationPoint(2.5f, 9.0f, 2.5f);
        this.HairMidL01.addBox(-4.5f, 0.0f, 0.0f, 9, 13, 8, 0.0f);
        this.setRotateAngle(this.HairMidL01, 0.13962634f, 0.08726646f, -0.2617994f);
        this.HairMidR02 = new ModelRenderer(this, 46, 21);
        this.HairMidR02.mirror = true;
        this.HairMidR02.setRotationPoint(0.0f, 12.0f, 3.0f);
        this.HairMidR02.addBox(-4.5f, 0.0f, 0.0f, 9, 14, 5, 0.0f);
        this.setRotateAngle(this.HairMidR02, 0.13962634f, 0.0f, 0.13962634f);
        this.Skirt = new ModelRenderer(this, 50, 0);
        this.Skirt.setRotationPoint(0.0f, 5.5f, 0.0f);
        this.Skirt.addBox(-8.5f, 0.0f, -6.0f, 17, 6, 9, 0.0f);
        this.setRotateAngle(this.Skirt, -0.17453292f, 0.0f, 0.0f);
        this.HairL02 = new ModelRenderer(this, 103, 1);
        this.HairL02.setRotationPoint(-0.2f, 8.5f, 0.5f);
        this.HairL02.addBox(-1.0f, 0.0f, 0.0f, 2, 9, 3, 0.0f);
        this.setRotateAngle(this.HairL02, 0.2617994f, 0.0f, 0.17453292f);
        this.EarBase = new ModelRenderer(this, 80, 113);
        this.EarBase.setRotationPoint(-2.0f, -2.0f, 2.0f);
        this.EarBase.addBox(0.0f, 0.0f, 0.0f, 4, 3, 4, 0.0f);
        this.EquipT05 = new ModelRenderer(this, 85, 65);
        this.EquipT05.setRotationPoint(-8.1f, -8.0f, 1.0f);
        this.EquipT05.addBox(0.0f, 0.0f, 0.0f, 3, 31, 3, 0.0f);
        this.HairR01 = new ModelRenderer(this, 102, 0);
        this.HairR01.setRotationPoint(-5.5f, 0.0f, -3.0f);
        this.HairR01.addBox(-1.0f, 0.0f, 0.0f, 2, 9, 4, 0.0f);
        this.setRotateAngle(this.HairR01, -0.2617994f, 0.17453292f, 0.2617994f);
        this.EquipT01 = new ModelRenderer(this, 85, 65);
        this.EquipT01.setRotationPoint(5.1f, -8.0f, 1.0f);
        this.EquipT01.addBox(0.0f, 0.0f, 0.0f, 3, 31, 3, 0.0f);
        this.EarR01 = new ModelRenderer(this, 83, 113);
        this.EarR01.setRotationPoint(0.0f, 2.5f, 2.0f);
        this.EarR01.addBox(-1.5f, -10.0f, -1.0f, 3, 10, 2, 0.0f);
        this.EarR02 = new ModelRenderer(this, 82, 113);
        this.EarR02.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.EarR02.addBox(-2.0f, -13.0f, -1.0f, 4, 13, 2, 0.0f);
        this.EarL01 = new ModelRenderer(this, 83, 113);
        this.EarL01.setRotationPoint(4.0f, 2.5f, 2.0f);
        this.EarL01.addBox(-1.5f, -10.0f, -1.0f, 3, 10, 2, 0.0f);
        this.EarL02 = new ModelRenderer(this, 82, 113);
        this.EarL02.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.EarL02.addBox(-2.0f, -13.0f, -1.0f, 4, 13, 2, 0.0f);
        this.NeckCloth = new ModelRenderer(this, 0, 0);
        this.NeckCloth.setRotationPoint(0.0f, -10.0f, 0.0f);
        this.NeckCloth.addBox(-7.5f, -1.5f, -4.5f, 15, 12, 8, 0.0f);
        this.Ahoke = new ModelRenderer(this, 65, 88);
        this.Ahoke.setRotationPoint(0.0f, -14.0f, -4.0f);
        this.Ahoke.addBox(0.0f, 0.0f, -12.0f, 0, 13, 12, 0.0f);
        this.setRotateAngle(this.Ahoke, 0.0f, 0.5235988f, 0.0f);
        this.ShoesR = new ModelRenderer(this, 88, 15);
        this.ShoesR.setRotationPoint(0.0f, 19.0f, -0.2f);
        this.ShoesR.addBox(-3.5f, 0.0f, -3.5f, 7, 7, 7, 0.0f);
        this.HairL01 = new ModelRenderer(this, 102, 0);
        this.HairL01.setRotationPoint(5.5f, 0.0f, -3.0f);
        this.HairL01.addBox(-1.0f, 0.0f, 0.0f, 2, 9, 4, 0.0f);
        this.setRotateAngle(this.HairL01, -0.2617994f, -0.17453292f, -0.2617994f);
        this.ShoesL = new ModelRenderer(this, 88, 15);
        this.ShoesL.setRotationPoint(0.0f, 19.0f, -0.2f);
        this.ShoesL.addBox(-3.5f, 0.0f, -3.5f, 7, 7, 7, 0.0f);
        this.EquipT04 = new ModelRenderer(this, 85, 65);
        this.EquipT04.setRotationPoint(-4.8f, -8.0f, 1.0f);
        this.EquipT04.addBox(0.0f, 0.0f, 0.0f, 3, 31, 3, 0.0f);
        this.Butt = new ModelRenderer(this, 0, 22);
        this.Butt.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Butt.addBox(-8.0f, 4.0f, -5.4f, 16, 8, 7, 0.0f);
        this.setRotateAngle(this.Butt, 0.2617994f, 0.0f, 0.0f);
        this.EquipT03 = new ModelRenderer(this, 85, 65);
        this.EquipT03.setRotationPoint(-1.5f, -8.0f, 1.0f);
        this.EquipT03.addBox(0.0f, 0.0f, 0.0f, 3, 31, 3, 0.0f);
        this.EquipBase = new ModelRenderer(this, 76, 33);
        this.EquipBase.setRotationPoint(2.0f, -5.0f, 7.0f);
        this.EquipBase.addBox(-7.0f, 0.0f, -3.7f, 14, 8, 12, 0.0f);
        this.setRotateAngle(this.EquipBase, 0.13962634f, 0.0f, 0.5235988f);
        this.EquipHead = new ModelRenderer(this, 77, 29);
        this.EquipHead.setRotationPoint(0.0f, -3.0f, -0.3f);
        this.EquipHead.addBox(-9.0f, 0.0f, 0.0f, 18, 17, 7, 0.0f);
        this.LegRight = new ModelRenderer(this, 0, 96);
        this.LegRight.setRotationPoint(-4.5f, 9.5f, -3.0f);
        this.LegRight.addBox(-3.0f, 0.0f, -3.0f, 6, 19, 6, 0.0f);
        this.setRotateAngle(this.LegRight, -0.2617994f, 0.0f, -0.05235988f);
        this.HairAnchor = new ModelRenderer(this, 112, 7);
        this.HairAnchor.setRotationPoint(0.2f, 8.0f, -1.0f);
        this.HairAnchor.addBox(-1.5f, 0.0f, 0.0f, 2, 5, 6, 0.0f);
        this.setRotateAngle(this.HairAnchor, 0.08726646f, 0.0f, 0.13665928f);
        this.EquipT02 = new ModelRenderer(this, 85, 65);
        this.EquipT02.setRotationPoint(1.8f, -8.0f, 1.0f);
        this.EquipT02.addBox(0.0f, 0.0f, 0.0f, 3, 31, 3, 0.0f);
        this.LegLeft = new ModelRenderer(this, 0, 96);
        this.LegLeft.mirror = true;
        this.LegLeft.setRotationPoint(4.5f, 9.5f, -3.0f);
        this.LegLeft.addBox(-3.0f, 0.0f, -3.0f, 6, 19, 6, 0.0f);
        this.setRotateAngle(this.LegLeft, -0.2617994f, 0.0f, 0.05235988f);
        this.BodyMain = new ModelRenderer(this, 0, 37);
        this.BodyMain.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.BodyMain.addBox(-7.0f, -11.0f, -4.0f, 14, 17, 7, 0.0f);
        this.NeckTie = new ModelRenderer(this, 39, 0);
        this.NeckTie.setRotationPoint(0.0f, 2.5f, -4.7f);
        this.NeckTie.addBox(-3.5f, 0.0f, 0.0f, 7, 7, 0, 0.0f);
        this.setRotateAngle(this.NeckTie, -0.13962634f, 0.0f, 0.0f);
        this.ArmRight = new ModelRenderer(this, 0, 61);
        this.ArmRight.setRotationPoint(-7.0f, -10.5f, 0.0f);
        this.ArmRight.addBox(-2.5f, 0.0f, -2.5f, 5, 22, 5, 0.0f);
        this.setRotateAngle(this.ArmRight, 0.0f, 0.0f, 0.43633232f);
        this.ArmLeft = new ModelRenderer(this, 0, 61);
        this.ArmLeft.mirror = true;
        this.ArmLeft.setRotationPoint(7.0f, -10.5f, 0.0f);
        this.ArmLeft.addBox(-2.5f, 0.0f, -2.5f, 5, 22, 5, 0.0f);
        this.setRotateAngle(this.ArmLeft, 0.0f, 0.0f, -0.34906584f);
        this.HairR02 = new ModelRenderer(this, 103, 1);
        this.HairR02.setRotationPoint(0.2f, 8.5f, 0.5f);
        this.HairR02.addBox(-1.0f, 0.0f, 0.0f, 2, 9, 3, 0.0f);
        this.setRotateAngle(this.HairR02, 0.17453292f, 0.0f, -0.17453292f);
        this.HairMain.addChild(this.HairMidR01);
        this.HairMain.addChild(this.HairMidL01);
        this.EarL01.addChild(this.EarL02);
        this.EarR01.addChild(this.EarR02);
        this.HairL01.addChild(this.HairL02);
        this.HairMain.addChild(this.EarBase);
        this.EquipBase.addChild(this.EquipT05);
        this.Hair.addChild(this.HairR01);
        this.EquipBase.addChild(this.EquipT01);
        this.BodyMain.addChild(this.NeckCloth);
        this.Hair.addChild(this.Ahoke);
        this.LegRight.addChild(this.ShoesR);
        this.Hair.addChild(this.HairL01);
        this.LegLeft.addChild(this.ShoesL);
        this.EquipBase.addChild(this.EquipT04);
        this.BodyMain.addChild(this.Butt);
        this.EquipBase.addChild(this.EquipT03);
        this.BodyMain.addChild(this.EquipBase);
        this.NeckCloth.addChild(this.Head);
        this.Head.addChild(this.HairMain);
        this.EquipBase.addChild(this.EquipHead);
        this.Butt.addChild(this.LegRight);
        this.HairL02.addChild(this.HairAnchor);
        this.EquipBase.addChild(this.EquipT02);
        this.Butt.addChild(this.LegLeft);
        this.NeckCloth.addChild(this.NeckTie);
        this.EarBase.addChild(this.EarL01);
        this.EarBase.addChild(this.EarR01);
        this.BodyMain.addChild(this.ArmRight);
        this.BodyMain.addChild(this.ArmLeft);
        this.HairR01.addChild(this.HairR02);
        this.Butt.addChild(this.Skirt);
        this.Head.addChild(this.Hair);
        this.HairMidL01.addChild(this.HairMidL02);
        this.HairMidR01.addChild(this.HairMidR02);
        this.GlowBodyMain = new ModelRenderer(this, 0, 0);
        this.GlowBodyMain.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.GlowNeckCloth = new ModelRenderer(this, 0, 0);
        this.GlowNeckCloth.setRotationPoint(0.0f, -10.0f, 0.0f);
        this.GlowHead = new ModelRenderer(this, 0, 0);
        this.GlowHead.setRotationPoint(0.0f, -1.5f, 0.0f);
        this.GlowBodyMain.addChild(this.GlowNeckCloth);
        this.GlowNeckCloth.addChild(this.GlowHead);
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
        this.armMain = new ModelRenderer[]{this.BodyMain, this.ArmRight};
        this.armOff = new ModelRenderer[]{this.BodyMain, this.ArmLeft};
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        if (f3 <= -180.0f) {
            f3 += 360.0f;
        } else if (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        switch (((IShipEmotion)entity).getScaleLevel()) {
            case 3: {
                this.scale = 1.64f;
                this.offsetY = -0.58f;
                break;
            }
            case 2: {
                this.scale = 1.23f;
                this.offsetY = -0.27f;
                break;
            }
            case 1: {
                this.scale = 0.82f;
                this.offsetY = 0.35f;
                break;
            }
            default: {
                this.scale = 0.41f;
                this.offsetY = 2.17f;
            }
        }
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.scale(this.scale, this.scale, this.scale);
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
        this.EquipBase.isHidden = !EmotionHelper.checkModelState(1, state);
        this.HairAnchor.isHidden = !EmotionHelper.checkModelState(2, state);
        boolean fh1 = EmotionHelper.checkModelState(3, state);
        boolean fh2 = EmotionHelper.checkModelState(4, state);
        boolean fh3 = EmotionHelper.checkModelState(5, state);
        this.EarBase.isHidden = !fh1 && !fh2 && !fh3;
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.rotateAngleX = this.BodyMain.rotateAngleX;
        this.GlowBodyMain.rotateAngleY = this.BodyMain.rotateAngleY;
        this.GlowBodyMain.rotateAngleZ = this.BodyMain.rotateAngleZ;
        this.GlowNeckCloth.rotateAngleX = this.NeckCloth.rotateAngleX;
        this.GlowNeckCloth.rotateAngleY = this.NeckCloth.rotateAngleY;
        this.GlowNeckCloth.rotateAngleZ = this.NeckCloth.rotateAngleZ;
        this.GlowHead.rotateAngleX = this.Head.rotateAngleX;
        this.GlowHead.rotateAngleY = this.Head.rotateAngleY;
        this.GlowHead.rotateAngleZ = this.Head.rotateAngleZ;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        GlStateManager.translate(0.0f, 0.55f + 0.26f * ent.getScaleLevel(), 0.0f);
        this.setFaceHungry(ent);
        this.EarL01.rotateAngleX = 1.0f;
        this.EarL01.rotateAngleY = -0.4f;
        this.EarL01.rotateAngleZ = 0.0f;
        this.EarR01.rotateAngleX = 1.0f;
        this.EarR01.rotateAngleY = 1.0472f;
        this.EarR01.rotateAngleZ = 0.0f;
        this.EarL02.rotateAngleX = -0.8f;
        this.EarL02.rotateAngleY = 0.0f;
        this.EarL02.rotateAngleZ = 0.0f;
        this.EarR02.rotateAngleX = -0.2f;
        this.EarR02.rotateAngleY = -0.2f;
        this.EarR02.rotateAngleZ = 0.0f;
        this.EquipBase.rotateAngleZ = 0.52f;
        this.Head.rotateAngleX = 0.0f;
        this.Head.rotateAngleY = 0.0f;
        this.Head.rotateAngleZ = 0.0f;
        this.Ahoke.rotateAngleY = 0.5236f;
        this.BodyMain.rotateAngleY = 0.0f;
        this.BodyMain.rotateAngleX = 1.4835f;
        this.HairMidL01.rotateAngleX = -0.05f;
        this.HairMidR01.rotateAngleX = -0.05f;
        this.HairMidL02.rotateAngleX = -0.1f;
        this.HairMidR02.rotateAngleX = -0.1f;
        this.ArmLeft.rotateAngleX = -0.12f;
        this.ArmLeft.rotateAngleZ = -0.2f;
        this.ArmRight.rotateAngleX = -0.12f;
        this.ArmRight.rotateAngleZ = 0.2f;
        this.LegLeft.rotateAngleX = -0.2618f;
        this.LegRight.rotateAngleX = -0.2618f;
        this.LegLeft.rotateAngleY = 0.0f;
        this.LegRight.rotateAngleY = 0.0f;
        this.LegLeft.rotateAngleZ = 0.03f;
        this.LegRight.rotateAngleZ = -0.03f;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float f6;
        boolean fh7;
        float angleX = MathHelper.cos(f2 * 0.08f);
        float angleX1 = MathHelper.cos(f2 * 0.08f + 0.3f + f * 0.5f);
        float angleRun = MathHelper.cos(f * 1.5f) * f1;
        float addk1;
        float addk2;
        if (ent.getShipDepth(0) > 0.0) {
            GlStateManager.translate(0.0f, angleX * 0.05f + 0.025f, 0.0f);
        }
        addk1 = MathHelper.cos(f * 0.7f) * f1 - 0.21f;
        addk2 = MathHelper.cos(f * 0.7f + (float)Math.PI) * f1 - 0.11f;
        this.Head.rotateAngleX = f4 * 0.014f + 0.1f;
        this.Head.rotateAngleY = f3 * 0.01f;
        int state = ent.getStateEmotion(0);
        boolean fh1 = EmotionHelper.checkModelState(3, state);
        boolean fh2 = EmotionHelper.checkModelState(4, state);
        boolean fh3 = EmotionHelper.checkModelState(5, state);
        boolean fh4 = fh1 && fh2;
        boolean fh5 = fh1 && fh3;
        boolean fh6 = fh2 && fh3;
        fh7 = fh1 && fh2 && fh3;
        if (fh7) {
            this.EarL01.rotateAngleX = angleX * 0.075f + 0.6f;
            this.EarL01.rotateAngleY = -0.5f;
            this.EarL01.rotateAngleZ = 0.0f;
            this.EarR01.rotateAngleX = angleX * 0.075f + 1.1f;
            this.EarR01.rotateAngleY = 0.5f;
            this.EarR01.rotateAngleZ = 0.0f;
            this.EarL02.rotateAngleX = angleX1 * 0.1f + 0.7f;
            this.EarL02.rotateAngleY = 0.1f;
            this.EarL02.rotateAngleZ = 0.0f;
            this.EarR02.rotateAngleX = angleX1 * 0.1f + 1.0f;
            this.EarR02.rotateAngleY = -0.1f;
            this.EarR02.rotateAngleZ = 0.0f;
        } else if (fh6) {
            this.EarL01.rotateAngleX = angleX * 0.075f + 1.1f;
            this.EarL01.rotateAngleY = -0.5f;
            this.EarL01.rotateAngleZ = 0.0f;
            this.EarR01.rotateAngleX = angleX * 0.075f + 1.1f;
            this.EarR01.rotateAngleY = 0.5f;
            this.EarR01.rotateAngleZ = 0.0f;
            this.EarL02.rotateAngleX = angleX1 * 0.1f + 1.0f;
            this.EarL02.rotateAngleY = 0.1f;
            this.EarL02.rotateAngleZ = 0.0f;
            this.EarR02.rotateAngleX = angleX1 * 0.1f + 1.0f;
            this.EarR02.rotateAngleY = -0.1f;
            this.EarR02.rotateAngleZ = 0.0f;
        } else if (fh5) {
            this.EarL01.rotateAngleX = angleX * 0.075f - 1.1f;
            this.EarL01.rotateAngleY = 0.5f;
            this.EarL01.rotateAngleZ = 0.0f;
            this.EarR01.rotateAngleX = angleX1 * 0.075f - 1.1f;
            this.EarR01.rotateAngleY = -0.5f;
            this.EarR01.rotateAngleZ = 0.0f;
            this.EarL02.rotateAngleX = angleX * 0.075f - 0.8f;
            this.EarL02.rotateAngleY = 0.0f;
            this.EarL02.rotateAngleZ = -0.5f;
            this.EarR02.rotateAngleX = angleX1 * 0.075f - 0.8f;
            this.EarR02.rotateAngleY = 0.0f;
            this.EarR02.rotateAngleZ = 0.5f;
        } else if (fh4) {
            this.EarL01.rotateAngleX = angleX * 0.075f + 0.6f;
            this.EarL01.rotateAngleY = -0.5f;
            this.EarL01.rotateAngleZ = 0.0f;
            this.EarR01.rotateAngleX = angleX * 0.075f + 0.6f;
            this.EarR01.rotateAngleY = 0.5f;
            this.EarR01.rotateAngleZ = 0.0f;
            this.EarL02.rotateAngleX = angleX1 * 0.1f + 0.7f;
            this.EarL02.rotateAngleY = 0.1f;
            this.EarL02.rotateAngleZ = 0.0f;
            this.EarR02.rotateAngleX = angleX1 * 0.1f + 0.7f;
            this.EarR02.rotateAngleY = -0.1f;
            this.EarR02.rotateAngleZ = 0.0f;
        } else if (fh3) {
            this.EarL01.rotateAngleX = angleX * 0.075f + 0.3f;
            this.EarL01.rotateAngleY = -0.8f;
            this.EarL01.rotateAngleZ = 0.0f;
            this.EarR01.rotateAngleX = angleX * 0.075f + 0.9f;
            this.EarR01.rotateAngleY = 0.6f;
            this.EarR01.rotateAngleZ = 0.0f;
            this.EarL02.rotateAngleX = angleX1 * 0.1f + 0.6f;
            this.EarL02.rotateAngleY = 0.1f;
            this.EarL02.rotateAngleZ = 0.0f;
            this.EarR02.rotateAngleX = angleX1 * 0.1f + 1.0f;
            this.EarR02.rotateAngleY = -0.1f;
            this.EarR02.rotateAngleZ = 0.0f;
        } else if (fh2) {
            this.EarL01.rotateAngleX = angleX * 0.075f + 0.2f;
            this.EarL01.rotateAngleY = -0.4f;
            this.EarL01.rotateAngleZ = 0.4f;
            this.EarR01.rotateAngleX = angleX * 0.075f + 0.2f;
            this.EarR01.rotateAngleY = 0.4f;
            this.EarR01.rotateAngleZ = -0.4f;
            this.EarL02.rotateAngleX = angleX1 * 0.1f + 0.2f;
            this.EarL02.rotateAngleY = 0.0f;
            this.EarL02.rotateAngleZ = -0.3f;
            this.EarR02.rotateAngleX = angleX1 * 0.1f + 0.2f;
            this.EarR02.rotateAngleY = 0.0f;
            this.EarR02.rotateAngleZ = 0.3f;
        } else if (fh1) {
            this.EarL01.rotateAngleX = angleX * 0.075f + -0.1f;
            this.EarL01.rotateAngleY = 0.2f;
            this.EarL01.rotateAngleZ = 0.4f;
            this.EarR01.rotateAngleX = angleX * 0.075f + 0.0f;
            this.EarR01.rotateAngleY = 0.2f;
            this.EarR01.rotateAngleZ = -0.55f;
            this.EarL02.rotateAngleX = angleX1 * 0.1f + 0.4f;
            this.EarL02.rotateAngleY = 0.0f;
            this.EarL02.rotateAngleZ = -0.1f;
            this.EarR02.rotateAngleX = angleX1 * 0.1f + 0.9f;
            this.EarR02.rotateAngleY = 0.5f;
            this.EarR02.rotateAngleZ = 0.0f;
        }
        this.HairMidL01.rotateAngleX = angleX * 0.07f + 0.14f;
        this.HairMidL02.rotateAngleX = -angleX1 * 0.2f + 0.14f;
        this.HairMidR01.rotateAngleX = this.HairMidL01.rotateAngleX;
        this.HairMidR02.rotateAngleX = this.HairMidL02.rotateAngleX;
        this.HairMidL01.rotateAngleZ = -0.2618f;
        this.HairMidL02.rotateAngleZ = -0.14f;
        this.HairMidR01.rotateAngleZ = 0.2618f;
        this.HairMidR02.rotateAngleZ = 0.14f;
        this.HairL01.rotateAngleX = angleX * 0.06f - 0.2618f;
        this.HairL02.rotateAngleX = -angleX1 * 0.1f + 0.2618f;
        this.HairR01.rotateAngleX = angleX * 0.06f - 0.2618f;
        this.HairR02.rotateAngleX = -angleX1 * 0.1f + 0.2618f;
        this.HairL01.rotateAngleZ = -0.2618f;
        this.HairL02.rotateAngleZ = 0.1745f;
        this.HairR01.rotateAngleZ = 0.2618f;
        this.HairR02.rotateAngleZ = -0.1745f;
        this.Ahoke.rotateAngleY = angleX * 0.25f + 0.5236f;
        this.BodyMain.rotateAngleX = -0.1f;
        this.BodyMain.rotateAngleY = 0.0f;
        this.ArmLeft.rotateAngleX = 0.15f;
        this.ArmLeft.rotateAngleZ = angleX * 0.1f - 0.5236f;
        this.ArmRight.rotateAngleX = 0.0f;
        this.ArmRight.rotateAngleY = 0.0f;
        this.ArmRight.rotateAngleZ = -angleX * 0.1f + 0.5236f;
        this.LegLeft.rotateAngleY = 0.0f;
        this.LegLeft.rotateAngleZ = 0.05f;
        this.LegRight.rotateAngleY = 0.0f;
        this.LegRight.rotateAngleZ = -0.05f;
        this.EquipBase.rotateAngleZ = 0.52f;
        if (ent.getIsSprinting() || f1 > 0.6f) {
            this.setFace(3);
            this.Head.rotateAngleX -= 0.2618f;
            this.BodyMain.rotateAngleX = 0.2618f;
            this.HairMidL01.rotateAngleX += 0.5f;
            this.HairMidR01.rotateAngleX += 0.5f;
            this.HairMidL02.rotateAngleX += 0.5f;
            this.HairMidR02.rotateAngleX += 0.5f;
            this.ArmLeft.rotateAngleX = 0.7f;
            this.ArmLeft.rotateAngleZ = -1.0472f;
            this.ArmRight.rotateAngleX = 0.7f;
            this.ArmRight.rotateAngleZ = 1.0472f;
            addk1 = MathHelper.cos(f * 2.0f) * f1 * 1.5f - 0.5f;
            addk2 = MathHelper.cos(f * 2.0f + (float)Math.PI) * f1 * 1.5f - 0.5f;
            this.LegLeft.rotateAngleY = 0.0f;
            this.LegLeft.rotateAngleZ = 0.05f;
            this.LegRight.rotateAngleY = 0.0f;
            this.LegRight.rotateAngleZ = -0.05f;
            this.EarL01.rotateAngleX = -angleRun * 0.08f - 0.8727f;
            this.EarL01.rotateAngleY = 0.5f;
            this.EarL01.rotateAngleZ = 0.0f;
            this.EarR01.rotateAngleX = angleRun * 0.08f - 0.8727f;
            this.EarR01.rotateAngleY = -0.5f;
            this.EarR01.rotateAngleZ = 0.0f;
            this.EarL02.rotateAngleX = -angleRun * 0.1f - 0.5f;
            this.EarL02.rotateAngleY = 0.0f;
            this.EarL02.rotateAngleZ = -0.5f;
            this.EarR02.rotateAngleX = angleRun * 0.1f - 0.5f;
            this.EarR02.rotateAngleY = 0.0f;
            this.EarR02.rotateAngleZ = 0.5f;
        }
        this.Head.rotateAngleZ = EmotionHelper.getHeadTiltAngle(ent, f2);
        if (ent.getIsSneaking()) {
            this.Head.rotateAngleX -= 0.7854f;
            this.BodyMain.rotateAngleX = 0.7854f;
            this.ArmLeft.rotateAngleZ = -0.5f;
            this.ArmRight.rotateAngleZ = 0.5f;
            addk1 -= 0.8f;
            addk2 -= 0.8f;
        }
        if (ent.getIsSitting() || ent.getIsRiding()) {
            if (ent.getStateEmotion(1) == 4) {
                GlStateManager.translate(0.0f, 0.575f, 0.0f);
                this.Head.rotateAngleX = -1.48f;
                this.Head.rotateAngleY = 0.0f;
                this.Head.rotateAngleZ = 0.0f;
                this.BodyMain.rotateAngleX = 1.4835f;
                this.ArmLeft.rotateAngleX = -3.0543f;
                this.ArmLeft.rotateAngleZ = -0.7f;
                this.ArmRight.rotateAngleX = -2.8f;
                this.ArmRight.rotateAngleZ = 0.35f;
                addk1 = 0.0f;
                addk2 = -0.2618f;
                this.LegLeft.rotateAngleZ = 0.1745f;
                this.LegRight.rotateAngleZ = -0.35f;
            } else {
                GlStateManager.translate(0.0f, 0.45f, 0.0f);
                this.Head.rotateAngleX -= 0.7f;
                this.BodyMain.rotateAngleX = 0.5236f;
                this.HairL01.rotateAngleX -= 0.2f;
                this.HairL02.rotateAngleX -= 0.2f;
                this.HairR01.rotateAngleX -= 0.2f;
                this.HairR02.rotateAngleX -= 0.2f;
                this.ArmLeft.rotateAngleX = -0.5236f;
                this.ArmLeft.rotateAngleZ = 0.3146f;
                this.ArmRight.rotateAngleX = -0.5236f;
                this.ArmRight.rotateAngleZ = -0.3146f;
                addk1 = -2.2689f;
                addk2 = -2.2689f;
                this.LegLeft.rotateAngleY = -0.3491f;
                this.LegRight.rotateAngleY = 0.3491f;
            }
        }
        if (ent.getAttackTick() > 20) {
            GlStateManager.translate(0.0f, 0.14f + ent.getScaleLevel() * 0.07f, 0.0f);
            this.Head.rotateAngleX = -0.8727f;
            this.Head.rotateAngleY = 1.0472f;
            this.Head.rotateAngleZ = -0.7f;
            this.BodyMain.rotateAngleX = 1.3f;
            this.BodyMain.rotateAngleY = -1.57f;
            this.ArmLeft.rotateAngleX = 0.0f;
            this.ArmLeft.rotateAngleZ = -0.5f;
            this.ArmRight.rotateAngleX = 0.0f;
            this.ArmRight.rotateAngleZ = 1.57f;
            addk1 = -1.75f;
            addk2 = -1.92f;
            this.EquipBase.rotateAngleZ = 1.57f;
        }
        if ((f6 = ent.getSwingTime(f2 - (int)f2)) != 0.0f) {
            float f7 = MathHelper.sin(f6 * f6 * (float)Math.PI);
            float f8 = MathHelper.sin(MathHelper.sqrt(f6) * (float)Math.PI);
            this.ArmRight.rotateAngleX = -0.4f;
            this.ArmRight.rotateAngleY = 0.0f;
            this.ArmRight.rotateAngleZ = -0.2f;
            this.ArmRight.rotateAngleX += -f8 * 80.0f * ((float)Math.PI / 180);
            this.ArmRight.rotateAngleY += -f7 * 20.0f * ((float)Math.PI / 180) + 0.2f;
            this.ArmRight.rotateAngleZ += -f8 * 20.0f * ((float)Math.PI / 180);
        }
        float headX = this.Head.rotateAngleX * -0.5f;
        float headZ = this.Head.rotateAngleZ * -0.5f;
        this.HairMidL01.rotateAngleX += headX;
        this.HairMidL01.rotateAngleZ += headZ;
        this.HairMidL02.rotateAngleX += headX * 0.5f;
        this.HairMidL02.rotateAngleZ += headZ * 0.5f;
        this.HairMidR01.rotateAngleX += headX;
        this.HairMidR01.rotateAngleZ += headZ;
        this.HairMidR02.rotateAngleX += headX * 0.5f;
        this.HairMidR02.rotateAngleZ += headZ * 0.5f;
        this.HairL01.rotateAngleZ += headZ;
        this.HairL02.rotateAngleZ += headZ;
        this.HairR01.rotateAngleZ += headZ;
        this.HairR02.rotateAngleZ += headZ;
        this.HairL01.rotateAngleX += headX;
        this.HairL02.rotateAngleX += headX;
        this.HairR01.rotateAngleX += headX;
        this.HairR02.rotateAngleX += headX;
        this.LegLeft.rotateAngleX = addk1;
        this.LegRight.rotateAngleX = addk2;
    }
}
