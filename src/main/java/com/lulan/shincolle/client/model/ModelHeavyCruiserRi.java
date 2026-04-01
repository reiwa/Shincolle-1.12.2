package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelHeavyCruiserRi
extends ShipModelBaseAdv {
    private final ModelRenderer BodyMain;
    private final ModelRenderer Butt;
    private final ModelRenderer ArmLeft;
    private final ModelRenderer ArmRight;
    private final ModelRenderer Neck;
    private final ModelRenderer EquipBase;
    private final ModelRenderer LegRight;
    private final ModelRenderer LegLeft;
    private final ModelRenderer BoobR;
    private final ModelRenderer BoobL;
    private final ModelRenderer EquipLeftBase;
    private final ModelRenderer EquipLeftTube1;
    private final ModelRenderer EquipLeftBase2;
    private final ModelRenderer EquipLeftBase3;
    private final ModelRenderer EquipLeftBase4;
    private final ModelRenderer EquipLeftTube2;
    private final ModelRenderer EquipLeftTube3;
    private final ModelRenderer EquipLeftTooth;
    private final ModelRenderer EquipRightBase;
    private final ModelRenderer EquipRightTube1;
    private final ModelRenderer EquipRightBase1;
    private final ModelRenderer EquipRightBase2;
    private final ModelRenderer EquipRightBase3;
    private final ModelRenderer EquipRightBase4;
    private final ModelRenderer EquipRightTube2;
    private final ModelRenderer EquipRightTube3;
    private final ModelRenderer EquipRightTooth1;
    private final ModelRenderer EquipRightTooth2;
    private final ModelRenderer Head;
    private final ModelRenderer Cloak;
    private final ModelRenderer Hair;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowNeck;
    private final ModelRenderer GlowHead;
    private final ModelRenderer GlowArmLeft;
    private final ModelRenderer GlowEquipLeftBase;
    private final ModelRenderer GlowEquipLeftBase3;
    private final ModelRenderer GlowArmRight;
    private final ModelRenderer GlowEquipRightBase;
    private final ModelRenderer GlowEquipRightBase2;
    private final ModelRenderer GlowEquipRightBase3;
    private final ModelRenderer ShoesRight;
    private final ModelRenderer ShoesLeft;
    private final ModelRenderer HeadTail0;
    private final ModelRenderer HeadTail1;
    private final ModelRenderer HeadTail2;

    public ModelHeavyCruiserRi() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.scale = 0.41f;
        this.offsetY = 2.15f;
        this.offsetItem = new float[]{-0.14f, 1.29f, 0.0f};
        this.offsetBlock = new float[]{-0.14f, 1.29f, 0.0f};
        this.setDefaultFaceModel();
        this.EquipRightTube2 = new ModelRenderer(this, 82, 56);
        this.EquipRightTube2.setRotationPoint(0.0f, -15.0f, 0.0f);
        this.EquipRightTube2.addBox(-1.5f, -13.0f, -1.5f, 3, 14, 3, 0.0f);
        this.setRotateAngle(this.EquipRightTube2, 0.7853982f, -0.17453292f, 0.0f);
        this.EquipRightTooth2 = new ModelRenderer(this, 59, 24);
        this.EquipRightTooth2.setRotationPoint(-1.6f, 2.3f, 0.0f);
        this.EquipRightTooth2.addBox(0.0f, 0.0f, -2.5f, 2, 5, 5, 0.0f);
        this.LegRight = new ModelRenderer(this, 1, 85);
        this.LegRight.setRotationPoint(-4.7f, 7.5f, -1.0f);
        this.LegRight.addBox(-3.0f, 0.0f, -3.0f, 6, 17, 6, 0.0f);
        this.setRotateAngle(this.LegRight, -0.2f, 0.0f, -0.087f);
        this.EquipRightTooth1 = new ModelRenderer(this, 44, 13);
        this.EquipRightTooth1.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.EquipRightTooth1.addBox(0.0f, 0.0f, -4.0f, 2, 5, 8, 0.0f);
        this.BoobL = new ModelRenderer(this, 1, 26);
        this.BoobL.mirror = true;
        this.BoobL.setRotationPoint(3.3f, -8.5f, -2.5f);
        this.BoobL.addBox(-3.5f, 0.0f, -1.0f, 7, 5, 5, 0.0f);
        this.setRotateAngle(this.BoobL, -0.7853982f, 0.087f, 0.087f);
        this.BoobR = new ModelRenderer(this, 1, 26);
        this.BoobR.setRotationPoint(-3.3f, -8.5f, -2.5f);
        this.BoobR.addBox(-3.5f, 0.0f, -1.0f, 7, 5, 5, 0.0f);
        this.setRotateAngle(this.BoobR, -0.7853982f, -0.087f, -0.087f);
        this.EquipLeftBase2 = new ModelRenderer(this, 82, 5);
        this.EquipLeftBase2.setRotationPoint(-2.0f, 0.0f, 0.0f);
        this.EquipLeftBase2.addBox(-3.0f, -7.0f, -5.0f, 8, 7, 10, 0.0f);
        this.setRotateAngle(this.EquipLeftBase2, 0.0f, 0.0f, 0.025481807f);
        this.EquipRightBase1 = new ModelRenderer(this, 85, 4);
        this.EquipRightBase1.setRotationPoint(-5.0f, 0.0f, -5.5f);
        this.EquipRightBase1.addBox(0.0f, -20.0f, 0.0f, 4, 21, 11, 0.0f);
        this.setRotateAngle(this.EquipRightBase1, 0.0f, 0.0f, -0.08726646f);
        this.EquipRightTube3 = new ModelRenderer(this, 82, 56);
        this.EquipRightTube3.setRotationPoint(2.0f, -12.0f, 0.0f);
        this.EquipRightTube3.addBox(-3.5f, -23.5f, -1.4f, 3, 25, 3, 0.0f);
        this.setRotateAngle(this.EquipRightTube3, 1.3962634f, -0.34906584f, 0.0f);
        this.Hair = new ModelRenderer(this, 34, 68);
        this.Hair.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.Hair.addBox(-8.0f, -8.0f, -7.2f, 16, 16, 16, 0.0f);
        this.EquipLeftTube2 = new ModelRenderer(this, 82, 56);
        this.EquipLeftTube2.setRotationPoint(0.0f, -15.0f, 0.0f);
        this.EquipLeftTube2.addBox(-1.5f, -12.0f, -1.5f, 3, 12, 3, 0.0f);
        this.setRotateAngle(this.EquipLeftTube2, 0.87266463f, 0.0f, 0.0f);
        this.EquipLeftBase4 = new ModelRenderer(this, 83, 9);
        this.EquipLeftBase4.setRotationPoint(0.0f, 6.5f, 2.5f);
        this.EquipLeftBase4.addBox(-6.5f, 0.0f, 0.0f, 11, 16, 6, 0.0f);
        this.setRotateAngle(this.EquipLeftBase4, 0.08726646f, 0.0f, 0.0f);
        this.Head = new ModelRenderer(this, 43, 101);
        this.Head.setRotationPoint(0.0f, 0.5f, 0.0f);
        this.Head.addBox(-7.0f, -14.5f, -6.5f, 14, 14, 13, 0.0f);
        this.LegLeft = new ModelRenderer(this, 1, 85);
        this.LegLeft.setRotationPoint(4.7f, 7.5f, -1.0f);
        this.LegLeft.addBox(-3.0f, 0.0f, -3.0f, 6, 17, 6, 0.0f);
        this.setRotateAngle(this.LegLeft, -0.087f, 0.0f, 0.087f);
        this.EquipLeftBase3 = new ModelRenderer(this, 77, 5);
        this.EquipLeftBase3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.EquipLeftBase3.addBox(-7.5f, 5.0f, -10.0f, 13, 19, 10, 0.0f);
        this.setRotateAngle(this.EquipLeftBase3, -0.08726646f, 0.0f, 0.0f);
        this.EquipRightBase4 = new ModelRenderer(this, 81, 0);
        this.EquipRightBase4.setRotationPoint(-5.0f, 0.0f, -7.5f);
        this.EquipRightBase4.addBox(0.0f, 0.0f, 0.0f, 4, 25, 15, 0.0f);
        this.setRotateAngle(this.EquipRightBase4, 0.0f, 0.0f, -0.08726646f);
        this.ArmRight = new ModelRenderer(this, 0, 53);
        this.ArmRight.setRotationPoint(-6.0f, -9.5f, 0.0f);
        this.ArmRight.addBox(-5.0f, 0.0f, -2.5f, 5, 25, 5, 0.0f);
        this.setRotateAngle(this.ArmRight, 0.2f, 0.0f, 0.2617994f);
        this.ArmLeft = new ModelRenderer(this, 0, 53);
        this.ArmLeft.mirror = true;
        this.ArmLeft.setRotationPoint(6.0f, -9.5f, 0.0f);
        this.ArmLeft.addBox(0.0f, 0.0f, -2.5f, 5, 25, 5, 0.0f);
        this.setRotateAngle(this.ArmLeft, -0.087f, 0.0f, -0.2617994f);
        this.Neck = new ModelRenderer(this, 78, 5);
        this.Neck.setRotationPoint(0.0f, -13.0f, 1.0f);
        this.Neck.addBox(-5.5f, 0.0f, -5.6f, 11, 3, 10, 0.0f);
        this.setRotateAngle(this.Neck, 0.1f, 0.0f, 0.0f);
        this.ShoesRight = new ModelRenderer(this, 52, 52);
        this.ShoesRight.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.ShoesRight.addBox(-3.5f, 17.0f, -3.5f, 7, 9, 7, 0.0f);
        this.ShoesLeft = new ModelRenderer(this, 52, 52);
        this.ShoesLeft.mirror = true;
        this.ShoesLeft.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.ShoesLeft.addBox(-3.5f, 17.0f, -3.5f, 7, 9, 7, 0.0f);
        this.EquipRightBase3 = new ModelRenderer(this, 90, 8);
        this.EquipRightBase3.setRotationPoint(1.0f, 14.0f, 0.0f);
        this.EquipRightBase3.addBox(0.0f, 0.0f, -3.5f, 3, 8, 7, 0.0f);
        this.setRotateAngle(this.EquipRightBase3, 0.0f, 0.0f, -0.2617994f);
        this.Butt = new ModelRenderer(this, 0, 36);
        this.Butt.setRotationPoint(0.0f, 5.0f, 0.0f);
        this.Butt.addBox(-8.0f, 0.0f, -4.1f, 16, 8, 9, 0.0f);
        this.setRotateAngle(this.Butt, 0.2617994f, 0.0f, 0.0f);
        this.EquipBase = new ModelRenderer(this, 82, 12);
        this.EquipBase.setRotationPoint(0.0f, -11.0f, 4.0f);
        this.EquipBase.addBox(-5.0f, 0.0f, 0.0f, 10, 7, 4, 0.0f);
        this.EquipLeftTube1 = new ModelRenderer(this, 82, 56);
        this.EquipLeftTube1.setRotationPoint(-2.0f, 8.0f, 3.0f);
        this.EquipLeftTube1.addBox(-1.5f, -16.0f, -1.5f, 3, 16, 3, 0.0f);
        this.setRotateAngle(this.EquipLeftTube1, -0.6981317f, 0.5235988f, 0.0f);
        this.EquipLeftTooth = new ModelRenderer(this, 44, 0);
        this.EquipLeftTooth.setRotationPoint(0.0f, 14.0f, -1.2f);
        this.EquipLeftTooth.addBox(-5.5f, 0.0f, 0.0f, 9, 7, 6, 0.0f);
        this.setRotateAngle(this.EquipLeftTooth, 0.08726646f, 0.0f, 0.0f);
        this.BodyMain = new ModelRenderer(this, 0, 0);
        this.BodyMain.setRotationPoint(0.0f, -14.0f, 0.0f);
        this.BodyMain.addBox(-6.5f, -10.0f, -4.0f, 13, 16, 8, 0.0f);
        this.EquipLeftBase = new ModelRenderer(this, 76, 1);
        this.EquipLeftBase.setRotationPoint(7.0f, 16.0f, 0.0f);
        this.EquipLeftBase.addBox(-6.0f, 0.0f, -7.0f, 10, 14, 14, 0.0f);
        this.setRotateAngle(this.EquipLeftBase, 0.0f, 0.0f, 0.08726646f);
        this.EquipRightBase = new ModelRenderer(this, 78, 6);
        this.EquipRightBase.setRotationPoint(-6.0f, 16.0f, 0.0f);
        this.EquipRightBase.addBox(-7.5f, 0.0f, -4.5f, 13, 14, 9, 0.0f);
        this.setRotateAngle(this.EquipRightBase, 0.0f, 0.0f, -0.08726646f);
        this.EquipRightBase2 = new ModelRenderer(this, 85, 5);
        this.EquipRightBase2.setRotationPoint(-4.2f, 13.0f, 0.0f);
        this.EquipRightBase2.addBox(-5.0f, 0.0f, -5.0f, 5, 10, 10, 0.0f);
        this.setRotateAngle(this.EquipRightBase2, 0.0f, 0.0f, 0.08726646f);
        this.EquipRightTube1 = new ModelRenderer(this, 82, 56);
        this.EquipRightTube1.setRotationPoint(1.0f, 8.0f, 3.0f);
        this.EquipRightTube1.addBox(-1.5f, -16.0f, -1.5f, 3, 16, 3, 0.0f);
        this.setRotateAngle(this.EquipRightTube1, -1.0471976f, 0.0f, 0.0f);
        this.Cloak = new ModelRenderer(this, 0, 112);
        this.Cloak.setRotationPoint(0.0f, 1.0f, 4.0f);
        this.Cloak.addBox(-8.0f, 0.0f, 0.0f, 16, 16, 0, 0.0f);
        this.setRotateAngle(this.Cloak, 1.3089969f, 0.0f, 0.0f);
        this.EquipLeftTube3 = new ModelRenderer(this, 82, 56);
        this.EquipLeftTube3.setRotationPoint(0.0f, -11.0f, 0.0f);
        this.EquipLeftTube3.addBox(-1.5f, -20.0f, -1.5f, 3, 20, 3, 0.0f);
        this.setRotateAngle(this.EquipLeftTube3, 1.4486233f, 0.7853982f, 0.2617994f);
        this.HeadTail0 = new ModelRenderer(this, 20, 54);
        this.HeadTail0.setRotationPoint(0.0f, -15.0f, 8.0f);
        this.HeadTail0.addBox(-4.5f, 0.0f, -3.0f, 9, 14, 6, 0.0f);
        this.setRotateAngle(this.HeadTail0, 0.2617994f, 0.0f, 0.0f);
        this.HeadTail1 = new ModelRenderer(this, 24, 54);
        this.HeadTail1.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.HeadTail1.addBox(-3.5f, 0.0f, -3.0f, 7, 16, 6, 0.0f);
        this.setRotateAngle(this.HeadTail1, 0.09f, 0.0f, 0.0f);
        this.HeadTail2 = new ModelRenderer(this, 21, 55);
        this.HeadTail2.setRotationPoint(0.0f, 14.0f, 0.0f);
        this.HeadTail2.addBox(-4.0f, 0.0f, -2.5f, 8, 18, 5, 0.0f);
        this.setRotateAngle(this.HeadTail2, -0.1745f, 0.0f, 0.0f);
        this.EquipRightTube1.addChild(this.EquipRightTube2);
        this.Butt.addChild(this.LegRight);
        this.BodyMain.addChild(this.BoobL);
        this.EquipLeftBase.addChild(this.EquipLeftBase2);
        this.EquipRightBase.addChild(this.EquipRightBase1);
        this.EquipRightTube2.addChild(this.EquipRightTube3);
        this.Head.addChild(this.Hair);
        this.EquipLeftTube1.addChild(this.EquipLeftTube2);
        this.EquipLeftBase.addChild(this.EquipLeftBase4);
        this.Neck.addChild(this.Head);
        this.Butt.addChild(this.LegLeft);
        this.EquipLeftBase.addChild(this.EquipLeftBase3);
        this.EquipRightBase.addChild(this.EquipRightBase4);
        this.LegLeft.addChild(this.ShoesLeft);
        this.BodyMain.addChild(this.ArmRight);
        this.BodyMain.addChild(this.Neck);
        this.LegRight.addChild(this.ShoesRight);
        this.EquipRightBase.addChild(this.EquipRightBase3);
        this.BodyMain.addChild(this.Butt);
        this.BodyMain.addChild(this.EquipBase);
        this.EquipLeftBase.addChild(this.EquipLeftTube1);
        this.BodyMain.addChild(this.BoobR);
        this.ArmLeft.addChild(this.EquipLeftBase);
        this.ArmRight.addChild(this.EquipRightBase);
        this.EquipRightBase.addChild(this.EquipRightBase2);
        this.EquipRightBase.addChild(this.EquipRightTube1);
        this.Neck.addChild(this.Cloak);
        this.BodyMain.addChild(this.ArmLeft);
        this.EquipLeftTube2.addChild(this.EquipLeftTube3);
        this.Head.addChild(this.HeadTail0);
        this.HeadTail0.addChild(this.HeadTail1);
        this.HeadTail1.addChild(this.HeadTail2);
        this.GlowBodyMain = new ModelRenderer(this, 0, 0);
        this.GlowBodyMain.setRotationPoint(0.0f, -14.0f, 0.0f);
        this.GlowNeck = new ModelRenderer(this, 0, 0);
        this.GlowNeck.setRotationPoint(0.0f, -13.0f, 1.0f);
        this.GlowHead = new ModelRenderer(this, 0, 0);
        this.GlowHead.setRotationPoint(0.0f, 0.5f, 0.0f);
        this.GlowArmLeft = new ModelRenderer(this, 0, 0);
        this.GlowArmLeft.setRotationPoint(7.0f, -10.0f, 0.0f);
        this.setRotateAngle(this.GlowArmLeft, 0.0f, 0.0f, -0.2617994f);
        this.GlowEquipLeftBase = new ModelRenderer(this, 0, 0);
        this.GlowEquipLeftBase.setRotationPoint(7.0f, 16.0f, 0.0f);
        this.setRotateAngle(this.GlowEquipLeftBase, 0.0f, 0.0f, 0.08726646f);
        this.GlowEquipLeftBase3 = new ModelRenderer(this, 0, 0);
        this.GlowEquipLeftBase3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.GlowEquipLeftBase3, -0.08726646f, 0.0f, 0.0f);
        this.GlowArmRight = new ModelRenderer(this, 0, 53);
        this.GlowArmRight.setRotationPoint(-7.0f, -10.0f, 0.0f);
        this.setRotateAngle(this.GlowArmRight, 0.0f, 0.0f, 0.2617994f);
        this.GlowEquipRightBase = new ModelRenderer(this, 0, 0);
        this.GlowEquipRightBase.setRotationPoint(-6.0f, 16.0f, 0.0f);
        this.setRotateAngle(this.GlowEquipRightBase, 0.0f, 0.0f, -0.08726646f);
        this.GlowEquipRightBase2 = new ModelRenderer(this, 0, 0);
        this.GlowEquipRightBase2.setRotationPoint(-4.2f, 13.0f, 0.0f);
        this.setRotateAngle(this.GlowEquipRightBase2, 0.0f, 0.0f, 0.08726646f);
        this.GlowEquipRightBase3 = new ModelRenderer(this, 0, 0);
        this.GlowEquipRightBase3.setRotationPoint(1.0f, 14.0f, 0.0f);
        this.setRotateAngle(this.GlowEquipRightBase3, 0.0f, 0.0f, -0.2617994f);
        this.GlowBodyMain.addChild(this.GlowNeck);
        this.GlowBodyMain.addChild(this.GlowArmLeft);
        this.GlowBodyMain.addChild(this.GlowArmRight);
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
        this.GlowArmLeft.addChild(this.GlowEquipLeftBase);
        this.GlowEquipLeftBase.addChild(this.GlowEquipLeftBase3);
        this.GlowEquipLeftBase3.addChild(this.EquipLeftTooth);
        this.GlowArmRight.addChild(this.GlowEquipRightBase);
        this.GlowEquipRightBase.addChild(this.GlowEquipRightBase2);
        this.GlowEquipRightBase.addChild(this.GlowEquipRightBase3);
        this.GlowEquipRightBase2.addChild(this.EquipRightTooth1);
        this.GlowEquipRightBase3.addChild(this.EquipRightTooth2);
        this.armMain = new ModelRenderer[]{this.BodyMain, this.ArmRight};
        this.armOff = new ModelRenderer[]{this.BodyMain, this.ArmLeft};
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
        boolean fc1 = EmotionHelper.checkModelState(0, state);
        boolean fc2 = EmotionHelper.checkModelState(1, state);
        if (fc1) {
            this.EquipBase.isHidden = false;
            this.EquipLeftBase.isHidden = false;
            this.GlowEquipLeftBase.isHidden = false;
        }
        if (fc2) {
            this.EquipBase.isHidden = false;
            this.EquipRightBase.isHidden = false;
            this.GlowEquipRightBase.isHidden = false;
        }
        if (!fc1 && !fc2) {
            this.EquipBase.isHidden = true;
            this.EquipLeftBase.isHidden = true;
            this.EquipRightBase.isHidden = true;
            this.GlowEquipLeftBase.isHidden = true;
            this.GlowEquipRightBase.isHidden = true;
        }
        this.Cloak.isHidden = !EmotionHelper.checkModelState(2, state);
        this.HeadTail0.isHidden = !EmotionHelper.checkModelState(3, state);
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowArmLeft.rotateAngleX = this.ArmLeft.rotateAngleX;
        this.GlowArmLeft.rotateAngleY = this.ArmLeft.rotateAngleY;
        this.GlowArmLeft.rotateAngleZ = this.ArmLeft.rotateAngleZ;
        this.GlowArmRight.rotateAngleX = this.ArmRight.rotateAngleX;
        this.GlowArmRight.rotateAngleY = this.ArmRight.rotateAngleY;
        this.GlowArmRight.rotateAngleZ = this.ArmRight.rotateAngleZ;
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
        GlStateManager.translate(0.0f, 0.46f, 0.0f);
        this.setFaceHungry(ent);
        this.Head.rotateAngleX = 0.2f;
        this.Head.rotateAngleY = 0.0f;
        this.Head.rotateAngleZ = 0.0f;
        this.Cloak.rotateAngleX = -0.2f;
        this.BoobL.rotateAngleX = -0.73f;
        this.BoobR.rotateAngleX = -0.73f;
        this.BodyMain.rotateAngleX = 0.3f;
        this.HeadTail0.rotateAngleX = -0.05f;
        this.HeadTail1.rotateAngleX = -0.05f;
        this.ArmLeft.rotateAngleX = -0.6f;
        this.ArmRight.rotateAngleX = -0.6f;
        this.ArmLeft.rotateAngleZ = 0.5f;
        this.ArmRight.rotateAngleZ = -0.5f;
        this.LegLeft.rotateAngleX = -2.0f;
        this.LegLeft.rotateAngleY = 0.15f;
        this.LegLeft.rotateAngleZ = 1.2f;
        this.LegRight.rotateAngleX = -2.0f;
        this.LegRight.rotateAngleY = -0.15f;
        this.LegRight.rotateAngleZ = -1.2f;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float f6;
        float angleZ = MathHelper.cos(f2 * 0.08f);
        float addk1;
        float addk2;
        if (ent.getShipDepth(0) > 0.0) {
            GlStateManager.translate(0.0f, angleZ * 0.05f + 0.025f, 0.0f);
        }
        addk1 = MathHelper.cos(f * 0.6662f) * 1.4f * f1 - 0.087f;
        addk2 = MathHelper.cos(f * 0.6662f + (float)Math.PI) * 1.4f * f1 - 0.2f;
        this.Head.rotateAngleY = f3 * 0.01f;
        this.Head.rotateAngleX = f4 * 0.008f;
        this.Cloak.rotateAngleX = angleZ * 0.2f + 1.0f;
        this.BoobL.rotateAngleX = -angleZ * 0.06f - 0.73f;
        this.BoobR.rotateAngleX = -angleZ * 0.06f - 0.73f;
        this.BodyMain.rotateAngleX = -0.15f;
        this.ArmLeft.rotateAngleZ = angleZ * -0.06f - 0.25f;
        this.ArmLeft.rotateAngleX = 0.2f;
        this.ArmRight.rotateAngleX = 0.2f;
        this.ArmRight.rotateAngleY = 0.0f;
        this.ArmRight.rotateAngleZ = angleZ * 0.06f + 0.25f;
        this.LegLeft.rotateAngleZ = 0.087f;
        this.LegRight.rotateAngleZ = -0.087f;
        this.LegLeft.rotateAngleY = 0.0f;
        this.LegRight.rotateAngleY = 0.0f;
        this.HeadTail0.rotateAngleX = angleZ * 0.05f + 0.26f;
        this.HeadTail1.rotateAngleX = angleZ * 0.1f + 0.09f;
        if (ent.getIsSprinting() || f1 > 0.9f) {
            this.ArmLeft.rotateAngleX = 1.0f;
            this.ArmRight.rotateAngleX = 1.0f;
            this.BodyMain.rotateAngleX = 0.5f;
            this.HeadTail0.rotateAngleX = angleZ * 0.05f + 0.8f;
            addk1 -= 0.4f;
            addk2 -= 0.4f;
        }
        this.Head.rotateAngleZ = EmotionHelper.getHeadTiltAngle(ent, f2);
        if (ent.getIsSneaking()) {
            GlStateManager.translate(0.0f, 0.05f, 0.0f);
            this.ArmLeft.rotateAngleX = 0.7f;
            this.ArmRight.rotateAngleX = 0.7f;
            this.BodyMain.rotateAngleX = 0.5f;
            addk1 -= 0.6f;
            addk2 -= 0.6f;
        }
        if (ent.getIsSitting() || ent.getIsRiding()) {
            if (ent.getStateEmotion(1) == 4) {
                GlStateManager.translate(0.0f, 0.44f, 0.0f);
                this.ArmLeft.rotateAngleX = 0.6f;
                this.ArmRight.rotateAngleX = 0.6f;
                this.ArmLeft.rotateAngleZ = -0.6f;
                this.ArmRight.rotateAngleZ = 0.6f;
                this.BodyMain.rotateAngleX = -0.6f;
                this.Head.rotateAngleX -= 0.2f;
                addk1 = -1.58f;
                addk2 = -1.58f;
                this.LegLeft.rotateAngleZ = 1.2f;
                this.LegRight.rotateAngleZ = -1.2f;
                this.LegLeft.rotateAngleY = -0.75f;
                this.LegRight.rotateAngleY = 0.75f;
                this.HeadTail0.rotateAngleX += 0.7f;
            } else {
                GlStateManager.translate(0.0f, 0.45f, 0.0f);
                this.ArmLeft.rotateAngleX = -0.6f;
                this.ArmLeft.rotateAngleZ = 0.3f;
                this.ArmRight.rotateAngleX = -0.6f;
                this.ArmRight.rotateAngleZ = -0.3f;
                this.BodyMain.rotateAngleX = 0.3f;
                this.Head.rotateAngleX -= 0.35f;
                addk1 = -2.0f;
                addk2 = -2.0f;
                this.LegLeft.rotateAngleY = 0.15f;
                this.LegRight.rotateAngleY = -0.15f;
                this.LegLeft.rotateAngleZ = 1.2f;
                this.LegRight.rotateAngleZ = -1.2f;
            }
        }
        this.LegLeft.rotateAngleX = addk1;
        this.LegRight.rotateAngleX = addk2;
        if (ent.getAttackTick() > 15) {
            this.ArmLeft.rotateAngleX = f4 / 57.29578f - 1.5f;
            this.ArmRight.rotateAngleZ = 0.7f;
            this.ArmRight.rotateAngleX = 0.4f;
        }
        if ((f6 = ent.getSwingTime(f2 - (int)f2)) != 0.0f) {
            float f7 = MathHelper.sin(f6 * f6 * (float)Math.PI);
            float f8 = MathHelper.sin(MathHelper.sqrt(f6) * (float)Math.PI);
            this.ArmRight.rotateAngleX = -0.5f;
            this.ArmRight.rotateAngleY = 0.0f;
            this.ArmRight.rotateAngleZ = 0.2f;
            this.ArmRight.rotateAngleX += -f8 * 80.0f * ((float)Math.PI / 180);
            this.ArmRight.rotateAngleY += -f7 * 20.0f * ((float)Math.PI / 180) + 0.2f;
            this.ArmRight.rotateAngleZ += -f8 * 20.0f * ((float)Math.PI / 180);
        }
    }
}
