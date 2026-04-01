package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelAirfieldHime
extends ShipModelBaseAdv {
    private final ModelRenderer BodyMain;
    private final ModelRenderer Neck;
    private final ModelRenderer BoobR;
    private final ModelRenderer BoobL;
    private final ModelRenderer ArmLeft01;
    private final ModelRenderer ArmRight01;
    private final ModelRenderer Butt;
    private final ModelRenderer Head;
    private final ModelRenderer Hair;
    private final ModelRenderer HairMain;
    private final ModelRenderer HeadHL;
    private final ModelRenderer HeadHR;
    private final ModelRenderer Ahoke;
    private final ModelRenderer HairL01;
    private final ModelRenderer HairR01;
    private final ModelRenderer HairL02;
    private final ModelRenderer HairR02;
    private final ModelRenderer Hair01;
    private final ModelRenderer Hair02;
    private final ModelRenderer Hair03;
    private final ModelRenderer HeadHL2;
    private final ModelRenderer HeadHL3;
    private final ModelRenderer HeadHR2;
    private final ModelRenderer HeadHR3;
    private final ModelRenderer ArmLeft02;
    private final ModelRenderer EquipHand01;
    private final ModelRenderer ArmRight02;
    private final ModelRenderer EquipHand02;
    private final ModelRenderer LegRight01;
    private final ModelRenderer LegLeft01;
    private final ModelRenderer LegRight02;
    private final ModelRenderer ShoesR;
    private final ModelRenderer LegLeft02;
    private final ModelRenderer ShoesL;
    private final ModelRenderer EquipRdL01;
    private final ModelRenderer EquipRdR01;
    private final ModelRenderer EquipRdL02;
    private final ModelRenderer EquipRdL03;
    private final ModelRenderer EquipRdL04;
    private final ModelRenderer EquipRdL05;
    private final ModelRenderer EquipRdL06;
    private final ModelRenderer EquipRdR02;
    private final ModelRenderer EquipRdR03;
    private final ModelRenderer EquipRdR04;
    private final ModelRenderer EquipRdR05;
    private final ModelRenderer EquipRdR06;
    private final ModelRenderer GlowEquipBase;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowNeck;
    private final ModelRenderer GlowHead;

    public ModelAirfieldHime() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.scale = 0.47f;
        this.offsetY = 1.75f;
        this.offsetItem = new float[]{0.08f, 1.02f, -0.07f};
        this.offsetBlock = new float[]{0.08f, 1.02f, -0.07f};
        this.setDefaultFaceModel();
        this.HairR02 = new ModelRenderer(this, 25, 18);
        this.HairR02.mirror = true;
        this.HairR02.setRotationPoint(0.2f, 10.0f, 0.0f);
        this.HairR02.addBox(-1.0f, 0.0f, 0.0f, 2, 12, 5, 0.0f);
        this.setRotateAngle(this.HairR02, 0.2617994f, 0.0f, -0.05235988f);
        this.BodyMain = new ModelRenderer(this, 0, 104);
        this.BodyMain.setRotationPoint(0.0f, -15.0f, 0.0f);
        this.BodyMain.addBox(-6.5f, -11.0f, -4.0f, 13, 17, 7, 0.0f);
        this.setRotateAngle(this.BodyMain, -0.17453292f, 0.0f, 0.0f);
        this.Hair02 = new ModelRenderer(this, 0, 59);
        this.Hair02.setRotationPoint(0.0f, 13.5f, 5.5f);
        this.Hair02.addBox(-8.0f, 0.0f, -5.0f, 16, 16, 8, 0.0f);
        this.setRotateAngle(this.Hair02, -0.08726646f, 0.0f, 0.0f);
        this.BoobR = new ModelRenderer(this, 33, 101);
        this.BoobR.setRotationPoint(-3.7f, -8.6f, -3.5f);
        this.BoobR.addBox(-3.5f, 0.0f, 0.0f, 7, 5, 5, 0.0f);
        this.setRotateAngle(this.BoobR, -0.6981317f, -0.13962634f, -0.08726646f);
        this.Ahoke = new ModelRenderer(this, 104, 29);
        this.Ahoke.setRotationPoint(0.0f, -10.5f, -5.0f);
        this.Ahoke.addBox(0.0f, -4.0f, -11.5f, 0, 12, 12, 0.0f);
        this.setRotateAngle(this.Ahoke, 0.0f, 0.5235988f, 0.0f);
        this.LegLeft01 = new ModelRenderer(this, 0, 84);
        this.LegLeft01.mirror = true;
        this.LegLeft01.setRotationPoint(4.7f, 9.5f, -2.6f);
        this.LegLeft01.addBox(-3.0f, 0.0f, -3.0f, 6, 14, 6, 0.0f);
        this.setRotateAngle(this.LegLeft01, 0.0f, 0.0f, 0.14f);
        this.HeadHR3 = new ModelRenderer(this, 43, 30);
        this.HeadHR3.setRotationPoint(-1.0f, 0.0f, 0.0f);
        this.HeadHR3.addBox(-1.0f, -1.5f, -1.5f, 1, 3, 3, 0.0f);
        this.ArmRight02 = new ModelRenderer(this, 24, 83);
        this.ArmRight02.setRotationPoint(-3.0f, 12.0f, 2.5f);
        this.ArmRight02.addBox(0.0f, 0.0f, -5.0f, 5, 13, 5, 0.0f);
        this.HairMain = new ModelRenderer(this, 48, 55);
        this.HairMain.setRotationPoint(0.0f, -15.0f, -3.0f);
        this.HairMain.addBox(-7.5f, 0.0f, 0.0f, 15, 12, 10, 0.0f);
        this.HairR01 = new ModelRenderer(this, 25, 18);
        this.HairR01.mirror = true;
        this.HairR01.setRotationPoint(-6.5f, 3.0f, -3.0f);
        this.HairR01.addBox(-1.0f, 0.0f, 0.0f, 2, 11, 5, 0.0f);
        this.setRotateAngle(this.HairR01, -0.2617994f, 0.17453292f, 0.13962634f);
        this.BoobL = new ModelRenderer(this, 33, 101);
        this.BoobL.mirror = true;
        this.BoobL.setRotationPoint(3.7f, -8.6f, -3.5f);
        this.BoobL.addBox(-3.5f, 0.0f, 0.0f, 7, 5, 5, 0.0f);
        this.setRotateAngle(this.BoobL, -0.6981317f, 0.13962634f, 0.08726646f);
        this.Hair01 = new ModelRenderer(this, 46, 29);
        this.Hair01.setRotationPoint(0.0f, 9.0f, 1.0f);
        this.Hair01.addBox(-7.5f, 0.0f, 0.0f, 15, 17, 9, 0.0f);
        this.setRotateAngle(this.Hair01, 0.2617994f, 0.0f, 0.0f);
        this.EquipHand02 = new ModelRenderer(this, 0, 17);
        this.EquipHand02.setRotationPoint(2.5f, -0.5f, -2.5f);
        this.EquipHand02.addBox(-3.0f, 0.0f, -3.0f, 6, 14, 6, 0.0f);
        this.HairL02 = new ModelRenderer(this, 25, 18);
        this.HairL02.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.HairL02.addBox(-1.0f, 0.0f, 0.0f, 2, 12, 5, 0.0f);
        this.setRotateAngle(this.HairL02, 0.2617994f, 0.0f, 0.08726646f);
        this.HeadHR = new ModelRenderer(this, 39, 28);
        this.HeadHR.mirror = true;
        this.HeadHR.setRotationPoint(-6.4f, -10.6f, 0.8f);
        this.HeadHR.addBox(-3.0f, -2.5f, -2.5f, 3, 5, 5, 0.0f);
        this.setRotateAngle(this.HeadHR, -0.7853982f, 0.17453292f, 0.31415927f);
        this.ShoesR = new ModelRenderer(this, 87, 0);
        this.ShoesR.setRotationPoint(0.0f, 7.0f, 3.0f);
        this.ShoesR.addBox(-3.5f, 0.0f, -3.5f, 7, 8, 7, 0.0f);
        this.Butt = new ModelRenderer(this, 39, 0);
        this.Butt.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Butt.addBox(-7.5f, 4.0f, -5.7f, 15, 8, 8, 0.0f);
        this.setRotateAngle(this.Butt, 0.31415927f, 0.0f, 0.0f);
        this.HeadHL2 = new ModelRenderer(this, 47, 56);
        this.HeadHL2.setRotationPoint(3.0f, 0.0f, 0.0f);
        this.HeadHL2.addBox(0.0f, -2.0f, -2.0f, 1, 4, 4, 0.0f);
        this.HeadHR2 = new ModelRenderer(this, 47, 56);
        this.HeadHR2.setRotationPoint(-3.0f, 0.0f, 0.0f);
        this.HeadHR2.addBox(-1.0f, -2.0f, -2.0f, 1, 4, 4, 0.0f);
        this.LegLeft02 = new ModelRenderer(this, 0, 84);
        this.LegLeft02.mirror = true;
        this.LegLeft02.setRotationPoint(0.0f, 14.0f, -3.0f);
        this.LegLeft02.addBox(-3.0f, 0.0f, 0.0f, 6, 7, 6, 0.0f);
        this.ArmRight01 = new ModelRenderer(this, 2, 85);
        this.ArmRight01.setRotationPoint(-7.8f, -9.3f, -0.7f);
        this.ArmRight01.addBox(-3.0f, -1.0f, -2.5f, 5, 13, 5, 0.0f);
        this.setRotateAngle(this.ArmRight01, 0.20943952f, 0.0f, 0.20943952f);
        this.LegRight01 = new ModelRenderer(this, 0, 84);
        this.LegRight01.setRotationPoint(-4.7f, 9.5f, -2.6f);
        this.LegRight01.addBox(-3.0f, 0.0f, -3.0f, 6, 14, 6, 0.0f);
        this.setRotateAngle(this.LegRight01, -0.10471976f, 0.0f, -0.14f);
        this.LegRight02 = new ModelRenderer(this, 0, 84);
        this.LegRight02.setRotationPoint(0.0f, 14.0f, -3.0f);
        this.LegRight02.addBox(-3.0f, 0.0f, 0.0f, 6, 7, 6, 0.0f);
        this.HeadHL3 = new ModelRenderer(this, 43, 30);
        this.HeadHL3.setRotationPoint(1.0f, 0.0f, 0.0f);
        this.HeadHL3.addBox(0.0f, -1.5f, -1.5f, 1, 3, 3, 0.0f);
        this.ShoesL = new ModelRenderer(this, 87, 0);
        this.ShoesL.mirror = true;
        this.ShoesL.setRotationPoint(0.0f, 7.0f, 3.0f);
        this.ShoesL.addBox(-3.5f, 0.0f, -3.5f, 7, 8, 7, 0.0f);
        this.ArmLeft02 = new ModelRenderer(this, 24, 83);
        this.ArmLeft02.mirror = true;
        this.ArmLeft02.setRotationPoint(3.0f, 12.0f, 2.5f);
        this.ArmLeft02.addBox(-5.0f, 0.0f, -5.0f, 5, 13, 5, 0.0f);
        this.HeadHL = new ModelRenderer(this, 39, 28);
        this.HeadHL.mirror = true;
        this.HeadHL.setRotationPoint(6.4f, -10.6f, 0.8f);
        this.HeadHL.addBox(0.0f, -2.5f, -2.5f, 3, 5, 5, 0.0f);
        this.setRotateAngle(this.HeadHL, -0.7853982f, -0.17453292f, -0.31415927f);
        this.Head = new ModelRenderer(this, 44, 101);
        this.Head.setRotationPoint(0.0f, -1.5f, 0.0f);
        this.Head.addBox(-7.0f, -14.5f, -6.5f, 14, 14, 13, 0.0f);
        this.EquipRdL01 = new ModelRenderer(this, 0, 0);
        this.EquipRdL01.setRotationPoint(5.0f, 0.0f, 6.0f);
        this.EquipRdL01.addBox(-3.5f, 0.0f, -12.0f, 7, 1, 12, 0.0f);
        this.setRotateAngle(this.EquipRdL01, 1.4f, -0.34906584f, -0.34906584f);
        this.EquipRdR01 = new ModelRenderer(this, 0, 0);
        this.EquipRdR01.setRotationPoint(-5.0f, 0.0f, 6.0f);
        this.EquipRdR01.addBox(-3.5f, 0.0f, -12.0f, 7, 1, 12, 0.0f);
        this.setRotateAngle(this.EquipRdR01, 1.4f, 0.34906584f, 0.34906584f);
        this.EquipRdL02 = new ModelRenderer(this, 0, 0);
        this.EquipRdL02.setRotationPoint(0.0f, 0.0f, -11.0f);
        this.EquipRdL02.addBox(-3.5f, 0.0f, -12.0f, 7, 1, 12, 0.0f);
        this.setRotateAngle(this.EquipRdL02, -0.34906584f, 0.0f, 0.0f);
        this.EquipRdR02 = new ModelRenderer(this, 0, 0);
        this.EquipRdR02.setRotationPoint(0.0f, 0.0f, -11.0f);
        this.EquipRdR02.addBox(-3.5f, 0.0f, -12.0f, 7, 1, 12, 0.0f);
        this.setRotateAngle(this.EquipRdR02, -0.34906584f, 0.0f, 0.0f);
        this.EquipRdL03 = new ModelRenderer(this, 0, 0);
        this.EquipRdL03.setRotationPoint(0.0f, 0.0f, -11.0f);
        this.EquipRdL03.addBox(-3.5f, 0.0f, -12.0f, 7, 1, 12, 0.0f);
        this.setRotateAngle(this.EquipRdL03, -0.4363f, 0.0f, 0.0f);
        this.EquipRdR03 = new ModelRenderer(this, 0, 0);
        this.EquipRdR03.setRotationPoint(0.0f, 0.0f, -11.0f);
        this.EquipRdR03.addBox(-3.5f, 0.0f, -12.0f, 7, 1, 12, 0.0f);
        this.setRotateAngle(this.EquipRdR03, -0.4363f, 0.0f, 0.0f);
        this.EquipRdL04 = new ModelRenderer(this, 0, 0);
        this.EquipRdL04.setRotationPoint(0.0f, 0.0f, -11.0f);
        this.EquipRdL04.addBox(-3.5f, 0.0f, -12.0f, 7, 1, 12, 0.0f);
        this.setRotateAngle(this.EquipRdL04, -0.3491f, 0.0f, 0.0f);
        this.EquipRdR04 = new ModelRenderer(this, 0, 0);
        this.EquipRdR04.setRotationPoint(0.0f, 0.0f, -11.0f);
        this.EquipRdR04.addBox(-3.5f, 0.0f, -12.0f, 7, 1, 12, 0.0f);
        this.setRotateAngle(this.EquipRdR04, -0.3491f, 0.0f, 0.0f);
        this.EquipRdL05 = new ModelRenderer(this, 0, 0);
        this.EquipRdL05.setRotationPoint(0.0f, 0.0f, -11.0f);
        this.EquipRdL05.addBox(-3.5f, 0.0f, -12.0f, 7, 1, 12, 0.0f);
        this.setRotateAngle(this.EquipRdL05, -0.2618f, 0.0f, 0.0f);
        this.EquipRdR05 = new ModelRenderer(this, 0, 0);
        this.EquipRdR05.setRotationPoint(0.0f, 0.0f, -11.0f);
        this.EquipRdR05.addBox(-3.5f, 0.0f, -12.0f, 7, 1, 12, 0.0f);
        this.setRotateAngle(this.EquipRdR05, -0.2618f, 0.0f, 0.0f);
        this.EquipRdL06 = new ModelRenderer(this, 0, 0);
        this.EquipRdL06.setRotationPoint(0.0f, 0.0f, -11.0f);
        this.EquipRdL06.addBox(-3.5f, 0.0f, -12.0f, 7, 1, 12, 0.0f);
        this.setRotateAngle(this.EquipRdL06, -0.1745f, 0.0f, 0.0f);
        this.EquipRdR06 = new ModelRenderer(this, 0, 0);
        this.EquipRdR06.setRotationPoint(0.0f, 0.0f, -11.0f);
        this.EquipRdR06.addBox(-3.5f, 0.0f, -12.0f, 7, 1, 12, 0.0f);
        this.setRotateAngle(this.EquipRdR06, -0.1745f, 0.0f, 0.0f);
        this.EquipHand01 = new ModelRenderer(this, 0, 17);
        this.EquipHand01.setRotationPoint(-0.5f, 7.5f, 0.0f);
        this.EquipHand01.addBox(-3.0f, 0.0f, -3.0f, 6, 5, 6, 0.0f);
        this.Neck = new ModelRenderer(this, 88, 26);
        this.Neck.setRotationPoint(0.0f, -10.3f, -0.5f);
        this.Neck.addBox(-5.5f, -2.0f, -5.0f, 11, 3, 9, 0.0f);
        this.setRotateAngle(this.Neck, 0.20943952f, 0.0f, 0.0f);
        this.ArmLeft01 = new ModelRenderer(this, 2, 85);
        this.ArmLeft01.mirror = true;
        this.ArmLeft01.setRotationPoint(7.8f, -9.3f, -0.7f);
        this.ArmLeft01.addBox(-2.0f, -1.0f, -2.5f, 5, 13, 5, 0.0f);
        this.setRotateAngle(this.ArmLeft01, 0.20943952f, 0.0f, -0.20943952f);
        this.Hair03 = new ModelRenderer(this, 0, 37);
        this.Hair03.setRotationPoint(0.0f, 12.5f, -0.1f);
        this.Hair03.addBox(-8.0f, 0.0f, -4.5f, 16, 15, 7, 0.0f);
        this.setRotateAngle(this.Hair03, -0.13962634f, 0.0f, 0.0f);
        this.HairL01 = new ModelRenderer(this, 25, 18);
        this.HairL01.setRotationPoint(6.5f, 3.0f, -3.0f);
        this.HairL01.addBox(-1.0f, 0.0f, 0.0f, 2, 11, 5, 0.0f);
        this.setRotateAngle(this.HairL01, -0.2617994f, -0.17453292f, -0.13962634f);
        this.Hair = new ModelRenderer(this, 45, 77);
        this.Hair.setRotationPoint(0.0f, -7.5f, 0.0f);
        this.Hair.addBox(-8.0f, -8.0f, -7.2f, 16, 16, 8, 0.0f);
        this.HairR01.addChild(this.HairR02);
        this.Hair01.addChild(this.Hair02);
        this.BodyMain.addChild(this.BoobR);
        this.LegRight01.addChild(this.LegRight02);
        this.Hair.addChild(this.Ahoke);
        this.Butt.addChild(this.LegLeft01);
        this.ArmRight01.addChild(this.ArmRight02);
        this.Head.addChild(this.HairMain);
        this.Hair.addChild(this.HairR01);
        this.BodyMain.addChild(this.BoobL);
        this.HairMain.addChild(this.Hair01);
        this.ArmRight02.addChild(this.EquipHand02);
        this.HairL01.addChild(this.HairL02);
        this.LegRight02.addChild(this.ShoesR);
        this.BodyMain.addChild(this.Butt);
        this.LegLeft01.addChild(this.LegLeft02);
        this.BodyMain.addChild(this.ArmRight01);
        this.Butt.addChild(this.LegRight01);
        this.LegLeft02.addChild(this.ShoesL);
        this.ArmLeft01.addChild(this.ArmLeft02);
        this.Neck.addChild(this.Head);
        this.ArmRight01.addChild(this.EquipHand01);
        this.BodyMain.addChild(this.Neck);
        this.BodyMain.addChild(this.ArmLeft01);
        this.Hair02.addChild(this.Hair03);
        this.Hair.addChild(this.HairL01);
        this.Head.addChild(this.Hair);
        this.GlowBodyMain = new ModelRenderer(this, 0, 104);
        this.GlowBodyMain.setRotationPoint(0.0f, -15.0f, 0.0f);
        this.setRotateAngle(this.GlowBodyMain, -0.17453292f, 0.0f, 0.0f);
        this.GlowNeck = new ModelRenderer(this, 88, 26);
        this.GlowNeck.setRotationPoint(0.0f, -10.3f, -0.5f);
        this.setRotateAngle(this.GlowNeck, 0.20943952f, 0.0f, 0.0f);
        this.GlowHead = new ModelRenderer(this, 44, 101);
        this.GlowHead.setRotationPoint(0.0f, -1.5f, 0.0f);
        this.GlowEquipBase = new ModelRenderer(this, 0, 0);
        this.GlowEquipBase.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.GlowBodyMain.addChild(this.GlowNeck);
        this.GlowBodyMain.addChild(this.GlowEquipBase);
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
        this.GlowEquipBase.addChild(this.EquipRdL01);
        this.GlowEquipBase.addChild(this.EquipRdR01);
        this.EquipRdL01.addChild(this.EquipRdL02);
        this.EquipRdL02.addChild(this.EquipRdL03);
        this.EquipRdL03.addChild(this.EquipRdL04);
        this.EquipRdL04.addChild(this.EquipRdL05);
        this.EquipRdL05.addChild(this.EquipRdL06);
        this.EquipRdR01.addChild(this.EquipRdR02);
        this.EquipRdR02.addChild(this.EquipRdR03);
        this.EquipRdR03.addChild(this.EquipRdR04);
        this.EquipRdR04.addChild(this.EquipRdR05);
        this.EquipRdR05.addChild(this.EquipRdR06);
        this.GlowHead.addChild(this.HeadHL);
        this.GlowHead.addChild(this.HeadHR);
        this.HeadHL.addChild(this.HeadHL2);
        this.HeadHR.addChild(this.HeadHR2);
        this.HeadHL2.addChild(this.HeadHL3);
        this.HeadHR2.addChild(this.HeadHR3);
        this.armMain = new ModelRenderer[]{this.BodyMain, this.ArmRight01, this.ArmRight02};
        this.armOff = new ModelRenderer[]{this.BodyMain, this.ArmLeft01, this.ArmLeft02};
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
        boolean flag;
        int state = ent.getStateEmotion(0);
        this.EquipHand01.isHidden = flag = !EmotionHelper.checkModelState(1, state);
        this.EquipHand02.isHidden = flag;
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
        float addk1;
        float addk2;
        float headX;
        float headZ;
        GlStateManager.translate(0.0f, 0.55f, 0.0f);
        this.setFaceHungry(ent);
        this.Head.rotateAngleX = 0.0f;
        this.Head.rotateAngleY = 0.0f;
        this.Head.rotateAngleZ = 0.0f;
        headX = this.Head.rotateAngleX * -0.5f;
        this.BoobL.rotateAngleX = -0.7f;
        this.BoobR.rotateAngleX = -0.7f;
        this.Ahoke.rotateAngleY = 0.5236f;
        this.BodyMain.rotateAngleZ = 0.0f;
        this.Hair01.rotateAngleX = 0.26f + headX;
        this.Hair02.rotateAngleX = -0.08f + headX;
        this.Hair03.rotateAngleX = -0.14f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft02.rotateAngleX = 0.0f;
        this.ArmRight02.rotateAngleX = 0.0f;
        this.LegLeft01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.EquipRdL01.isHidden = true;
        this.EquipRdR01.isHidden = true;
        this.Head.rotateAngleX += 0.14f;
        this.BodyMain.rotateAngleX = 0.4f;
        this.Butt.rotateAngleX = -0.4f;
        this.Butt.offsetZ = 0.19f;
        this.BoobL.rotateAngleX -= 0.2f;
        this.BoobR.rotateAngleX -= 0.2f;
        this.ArmLeft01.rotateAngleX = -1.3f;
        this.ArmLeft01.rotateAngleZ = -0.1f;
        this.ArmLeft02.rotateAngleZ = 1.15f;
        this.ArmRight01.rotateAngleX = -1.3f;
        this.ArmRight01.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleZ = 0.1f;
        this.ArmRight02.rotateAngleZ = -1.4f;
        addk1 = -2.1232f;
        addk2 = -2.0708f;
        this.LegLeft01.rotateAngleZ = -0.2f;
        this.LegLeft02.rotateAngleX = 1.34f;
        this.LegRight01.rotateAngleZ = 0.2f;
        this.LegRight02.rotateAngleX = 1.13f;
        this.Hair01.rotateAngleX -= 0.2f;
        this.Hair02.rotateAngleX -= 0.2f;
        this.Hair03.rotateAngleX -= 0.1f;
        this.Hair01.rotateAngleZ = headZ = this.Head.rotateAngleZ * -0.5f;
        this.Hair02.rotateAngleZ = headZ;
        this.HairL01.rotateAngleZ = headZ - 0.0f;
        this.HairL02.rotateAngleZ = headZ + 0.087f;
        this.HairR01.rotateAngleZ = headZ + 0.0f;
        this.HairR02.rotateAngleZ = headZ - 0.052f;
        headX = this.Head.rotateAngleX * -0.5f;
        this.HairL01.rotateAngleX = headX - 0.5f;
        this.HairL02.rotateAngleX = headX - 0.1f;
        this.HairR01.rotateAngleX = headX - 0.5f;
        this.HairR02.rotateAngleX = headX - 0.1f;
        this.LegLeft01.rotateAngleX = addk1;
        this.LegRight01.rotateAngleX = addk2;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float angleX = MathHelper.cos(f2 * 0.08f);
        float angleX1 = MathHelper.cos(f2 * 0.08f + 0.3f + f * 0.5f);
        float angleX2 = MathHelper.cos(f2 * 0.08f + 0.6f + f * 0.5f);
        float angleAdd1 = MathHelper.cos(f * 0.7f) * f1 * 0.7f;
        float angleAdd2 = MathHelper.cos(f * 0.7f + (float)Math.PI) * f1 * 0.7f;
        float addk1;
        float addk2;
        float headX;
        float headZ;
        if (ent.getShipDepth(0) > 0.0 || ent.getShipDepth(1) > 0.0) {
            GlStateManager.translate(0.0f, angleX * 0.05f + 0.025f, 0.0f);
        }
        addk1 = angleAdd1;
        addk2 = angleAdd2 - 0.2f;
        this.Head.rotateAngleX = f4 * 0.014f;
        this.Head.rotateAngleY = f3 * 0.01f;
        this.Head.rotateAngleZ = 0.0f;
        headX = this.Head.rotateAngleX * -0.5f;
        this.BoobL.rotateAngleX = angleX * 0.06f - 0.7f;
        this.BoobR.rotateAngleX = angleX * 0.06f - 0.7f;
        this.Ahoke.rotateAngleY = angleX * 0.25f + 0.5236f;
        this.BodyMain.rotateAngleX = -0.1745f;
        this.BodyMain.rotateAngleZ = 0.0f;
        this.Butt.rotateAngleX = 0.3142f;
        this.Butt.offsetZ = 0.0f;
        this.Hair01.rotateAngleX = angleX * 0.03f + 0.26f + headX;
        this.Hair01.rotateAngleZ = 0.0f;
        this.Hair02.rotateAngleX = -angleX1 * 0.04f - 0.08f + headX;
        this.Hair02.rotateAngleZ = 0.0f;
        this.Hair03.rotateAngleX = -angleX2 * 0.07f - 0.14f;
        this.Hair03.rotateAngleZ = 0.0f;
        this.ArmLeft01.rotateAngleX = angleAdd2 * 0.8f + 0.2f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = angleX * 0.08f - 0.2f;
        this.ArmLeft02.rotateAngleX = 0.0f;
        this.ArmLeft02.rotateAngleZ = 0.0f;
        this.ArmRight01.rotateAngleX = angleAdd1 * 0.8f + 0.2f;
        this.ArmRight01.rotateAngleZ = -angleX * 0.08f + 0.2f;
        this.ArmRight02.rotateAngleX = 0.0f;
        this.ArmRight02.rotateAngleZ = 0.0f;
        this.LegLeft01.rotateAngleY = 0.0f;
        this.LegLeft01.rotateAngleZ = 0.14f;
        this.LegLeft02.rotateAngleX = 0.0f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleZ = -0.14f;
        this.LegRight02.rotateAngleX = 0.0f;
        this.EquipRdL01.isHidden = true;
        this.EquipRdR01.isHidden = true;
        if (ent.getIsSprinting() || f1 > 0.9f) {
            // empty if block
        }
        this.Head.rotateAngleZ = EmotionHelper.getHeadTiltAngle(ent, f2);
        this.Hair01.rotateAngleZ = headZ = this.Head.rotateAngleZ * -0.5f;
        this.Hair02.rotateAngleZ = headZ;
        this.HairL01.rotateAngleZ = headZ - 0.14f;
        this.HairL02.rotateAngleZ = headZ + 0.087f;
        this.HairR01.rotateAngleZ = headZ + 0.14f;
        this.HairR02.rotateAngleZ = headZ - 0.052f;
        if (ent.getIsSneaking()) {
            GlStateManager.translate(0.0f, 0.07f, 0.0f);
            this.Head.rotateAngleX -= 0.6283f;
            this.BodyMain.rotateAngleX = 0.8727f;
            this.ArmLeft01.rotateAngleX = -0.35f;
            this.ArmLeft01.rotateAngleZ = 0.2618f;
            this.ArmRight01.rotateAngleX = -0.35f;
            this.ArmRight01.rotateAngleZ = -0.2618f;
            addk1 -= 1.1f;
            addk2 -= 1.1f;
            this.Hair01.rotateAngleX += 0.37f;
            this.Hair02.rotateAngleX += 0.23f;
            this.Hair03.rotateAngleX -= 0.1f;
        }
        if (ent.getIsSitting() && !ent.getIsRiding()) {
            if (ent.getStateEmotion(1) == 4) {
                GlStateManager.translate(0.0f, 0.27f, 0.0f);
                this.Head.rotateAngleX += 0.14f;
                this.BodyMain.rotateAngleX = -0.4363f;
                this.BoobL.rotateAngleX -= 0.25f;
                this.BoobR.rotateAngleX -= 0.25f;
                this.ArmLeft01.rotateAngleX = -0.3142f;
                this.ArmLeft01.rotateAngleZ = 0.349f;
                this.ArmLeft02.rotateAngleZ = 1.15f;
                this.ArmRight01.rotateAngleX = -0.4363f;
                this.ArmRight01.rotateAngleZ = -0.2793f;
                this.ArmRight02.rotateAngleZ = -1.4f;
                addk1 = -1.309f;
                addk2 = -1.7f;
                this.LegLeft01.rotateAngleY = 0.3142f;
                this.LegLeft02.rotateAngleX = 1.0472f;
                this.LegRight01.rotateAngleY = -0.35f;
                this.LegRight01.rotateAngleZ = -0.2618f;
                this.LegRight02.rotateAngleX = 0.9f;
                this.Hair01.rotateAngleX += 0.12f;
                this.Hair02.rotateAngleX += 0.15f;
                this.Hair03.rotateAngleX += 0.25f;
            } else {
                GlStateManager.translate(0.0f, 0.37f, 0.0f);
                this.Head.rotateAngleX += 0.14f;
                this.BodyMain.rotateAngleX = -0.5236f;
                this.BoobL.rotateAngleX -= 0.2f;
                this.BoobR.rotateAngleX -= 0.2f;
                this.ArmLeft01.rotateAngleX = -0.4363f;
                this.ArmLeft01.rotateAngleZ = 0.3142f;
                this.ArmRight01.rotateAngleX = -0.4363f;
                this.ArmRight01.rotateAngleZ = -0.3142f;
                addk1 = -1.6232f;
                addk2 = -1.5708f;
                this.LegLeft01.rotateAngleZ = -0.3142f;
                this.LegLeft02.rotateAngleX = 1.34f;
                this.LegRight01.rotateAngleZ = 0.35f;
                this.LegRight02.rotateAngleX = 1.13f;
                this.Hair01.rotateAngleX += 0.09f;
                this.Hair02.rotateAngleX += 0.43f;
                this.Hair03.rotateAngleX += 0.49f;
            }
        }
        if (ent.getIsRiding()) {
            if (((Entity)ent).getRidingEntity() instanceof BasicEntityMount) {
                if (ent.getIsSitting()) {
                    GlStateManager.translate(0.0f, 0.22f, 0.2f);
                    if (ent.getStateEmotion(1) == 4) {
                        this.Head.rotateAngleX -= 0.3f;
                        this.BodyMain.rotateAngleX = -0.4363f;
                        this.BoobL.rotateAngleX -= 0.25f;
                        this.BoobR.rotateAngleX -= 0.25f;
                        this.ArmLeft01.rotateAngleX = -0.3142f;
                        this.ArmLeft01.rotateAngleZ = 0.349f;
                        this.ArmLeft02.rotateAngleZ = 1.15f;
                        this.ArmRight01.rotateAngleX = -0.4363f;
                        this.ArmRight01.rotateAngleZ = -0.2793f;
                        this.ArmRight02.rotateAngleZ = -1.4f;
                        addk1 = -1.309f;
                        addk2 = -1.7f;
                        this.LegLeft01.rotateAngleY = 0.3142f;
                        this.LegLeft02.rotateAngleX = 1.0472f;
                        this.LegRight01.rotateAngleY = -0.35f;
                        this.LegRight01.rotateAngleZ = -0.2618f;
                        this.LegRight02.rotateAngleX = 0.9f;
                        this.Hair01.rotateAngleX += 0.12f;
                        this.Hair02.rotateAngleX += 0.15f;
                        this.Hair03.rotateAngleX += 0.25f;
                    } else {
                        this.BodyMain.rotateAngleX = -0.5236f;
                        this.BoobL.rotateAngleX -= 0.2f;
                        this.BoobR.rotateAngleX -= 0.2f;
                        this.ArmLeft01.rotateAngleX = -0.4363f;
                        this.ArmLeft01.rotateAngleZ = 0.3142f;
                        this.ArmRight01.rotateAngleX = -0.4363f;
                        this.ArmRight01.rotateAngleZ = -0.3142f;
                        addk1 = -1.6232f;
                        addk2 = -1.5708f;
                        this.LegLeft01.rotateAngleZ = -0.3142f;
                        this.LegLeft02.rotateAngleX = 1.34f;
                        this.LegRight01.rotateAngleZ = 0.35f;
                        this.LegRight02.rotateAngleX = 1.13f;
                        this.Hair01.rotateAngleX += 0.09f;
                        this.Hair02.rotateAngleX += 0.43f;
                        this.Hair03.rotateAngleX += 0.49f;
                    }
                } else {
                    this.Head.rotateAngleX -= 0.1f;
                    this.ArmLeft01.rotateAngleX = 0.5f;
                    this.ArmLeft01.rotateAngleZ = -1.2f;
                    this.ArmRight01.rotateAngleX = 0.5f;
                    this.ArmRight01.rotateAngleZ = 1.2f;
                    addk1 = -0.2618f;
                    addk2 = -0.35f;
                    this.LegRight02.rotateAngleX = 0.8727f;
                    this.Hair01.rotateAngleX += 0.45f;
                    this.Hair02.rotateAngleX += 0.43f;
                    this.Hair03.rotateAngleX += 0.49f;
                }
            } else if (ent.getStateEmotion(1) == 4) {
                GlStateManager.translate(0.0f, 0.27f, 0.0f);
                this.Head.rotateAngleX += 0.14f;
                this.BodyMain.rotateAngleX = -0.4363f;
                this.BoobL.rotateAngleX -= 0.25f;
                this.BoobR.rotateAngleX -= 0.25f;
                this.ArmLeft01.rotateAngleX = -0.3142f;
                this.ArmLeft01.rotateAngleZ = 0.349f;
                this.ArmLeft02.rotateAngleZ = 1.15f;
                this.ArmRight01.rotateAngleX = -0.4363f;
                this.ArmRight01.rotateAngleZ = -0.2793f;
                this.ArmRight02.rotateAngleZ = -1.4f;
                addk1 = -1.309f;
                addk2 = -1.7f;
                this.LegLeft01.rotateAngleY = 0.3142f;
                this.LegLeft02.rotateAngleX = 1.0472f;
                this.LegRight01.rotateAngleY = -0.35f;
                this.LegRight01.rotateAngleZ = -0.2618f;
                this.LegRight02.rotateAngleX = 0.9f;
                this.Hair01.rotateAngleX += 0.12f;
                this.Hair02.rotateAngleX += 0.15f;
                this.Hair03.rotateAngleX += 0.25f;
            } else {
                GlStateManager.translate(0.0f, 0.37f, 0.0f);
                this.Head.rotateAngleX += 0.14f;
                this.BodyMain.rotateAngleX = -0.5236f;
                this.BoobL.rotateAngleX -= 0.2f;
                this.BoobR.rotateAngleX -= 0.2f;
                this.ArmLeft01.rotateAngleX = -0.4363f;
                this.ArmLeft01.rotateAngleZ = 0.3142f;
                this.ArmRight01.rotateAngleX = -0.4363f;
                this.ArmRight01.rotateAngleZ = -0.3142f;
                addk1 = -1.6232f;
                addk2 = -1.5708f;
                this.LegLeft01.rotateAngleZ = -0.3142f;
                this.LegLeft02.rotateAngleX = 1.34f;
                this.LegRight01.rotateAngleZ = 0.35f;
                this.LegRight02.rotateAngleX = 1.13f;
                this.Hair01.rotateAngleX += 0.09f;
                this.Hair02.rotateAngleX += 0.43f;
                this.Hair03.rotateAngleX += 0.49f;
            }
        }
        if (ent.getAttackTick() > 0) {
            if (ent.getAttackTick() > 25) {
                if (EmotionHelper.checkModelState(2, ent.getStateEmotion(0))) {
                    GlStateManager.translate(0.0f, 0.15f, 0.0f);
                    this.Head.rotateAngleY *= 0.8f;
                    this.Head.rotateAngleX = 0.4538f;
                    this.BodyMain.rotateAngleX = -1.0472f;
                    this.BodyMain.rotateAngleZ = -0.2094f;
                    this.ArmLeft01.rotateAngleX = -0.35f;
                    this.ArmLeft01.rotateAngleZ = -0.35f;
                    this.ArmLeft02.rotateAngleX = -0.5f;
                    this.ArmRight01.rotateAngleX = 1.2f;
                    this.ArmRight01.rotateAngleZ = 0.5236f;
                    this.ArmRight02.rotateAngleX = -0.35f;
                    addk1 = 0.5236f;
                    addk2 = 0.1745f;
                    this.LegLeft01.rotateAngleZ = 0.2618f;
                    this.LegLeft02.rotateAngleX = 0.5236f;
                    this.LegRight01.rotateAngleZ = 0.1745f;
                    this.LegRight02.rotateAngleX = 0.5236f;
                    this.Hair01.rotateAngleX += 0.09f;
                    this.Hair02.rotateAngleX += 0.43f;
                    this.Hair03.rotateAngleX += 0.49f;
                } else if (EmotionHelper.checkModelState(3, ent.getStateEmotion(0))) {
                    this.Head.rotateAngleY *= 0.8f;
                    this.Head.rotateAngleX = 0.2094f;
                    this.Head.rotateAngleZ = -0.2618f;
                    this.BodyMain.rotateAngleX = -0.35f;
                    this.BodyMain.rotateAngleZ = 0.1745f;
                    this.ArmLeft01.rotateAngleX = -1.2217f;
                    this.ArmLeft01.rotateAngleY = 0.5236f;
                    this.ArmLeft01.rotateAngleZ = -0.35f;
                    this.ArmLeft02.rotateAngleX = -1.3963f;
                    this.ArmRight01.rotateAngleX = 0.7854f;
                    this.ArmRight01.rotateAngleZ = 0.5236f;
                    this.ArmRight02.rotateAngleX = -0.5236f;
                    addk1 = -0.2618f;
                    addk2 = 0.3142f;
                    this.LegLeft01.rotateAngleZ = -0.4363f;
                    this.LegLeft02.rotateAngleX = 0.2618f;
                    this.LegRight01.rotateAngleZ = 0.0873f;
                    this.Hair01.rotateAngleX += 0.09f;
                    this.Hair02.rotateAngleX += 0.43f;
                    this.Hair03.rotateAngleX += 0.49f;
                } else {
                    this.ArmLeft01.rotateAngleX = -1.3f;
                    this.ArmLeft01.rotateAngleY = -0.7f;
                    this.ArmLeft01.rotateAngleZ = 0.0f;
                }
            }
            this.setRoad(ent.getAttackTick());
        }
        headX = this.Head.rotateAngleX * -0.5f;
        this.HairL01.rotateAngleX = angleX * 0.03f + headX - 0.26f;
        this.HairL02.rotateAngleX = -angleX1 * 0.04f + headX + 0.26f;
        this.HairR01.rotateAngleX = angleX * 0.03f + headX - 0.26f;
        this.HairR02.rotateAngleX = -angleX1 * 0.04f + headX + 0.26f;
        float f6 = ent.getSwingTime(f2 % 1.0f);
        if (f6 != 0.0f) {
            float f7 = MathHelper.sin(f6 * f6 * (float)Math.PI);
            float f8 = MathHelper.sin(MathHelper.sqrt(f6) * (float)Math.PI);
            this.ArmRight01.rotateAngleX = -0.3f;
            this.ArmRight01.rotateAngleY = 0.0f;
            this.ArmRight01.rotateAngleZ = -0.1f;
            this.ArmRight01.rotateAngleX += -f8 * 80.0f * ((float)Math.PI / 180);
            this.ArmRight01.rotateAngleY += -f7 * 20.0f * ((float)Math.PI / 180);
            this.ArmRight01.rotateAngleZ += -f8 * 20.0f * ((float)Math.PI / 180);
            this.ArmRight02.rotateAngleX = 0.0f;
            this.ArmRight02.rotateAngleZ = 0.0f;
        }
        this.LegLeft01.rotateAngleX = addk1;
        this.LegRight01.rotateAngleX = addk2;
    }

    private void setRoad(int attackTime) {
        switch (attackTime) {
            case 26: 
            case 50: {
                this.EquipRdL01.isHidden = false;
                this.EquipRdR01.isHidden = false;
                this.EquipRdL02.isHidden = true;
                this.EquipRdR02.isHidden = true;
                break;
            }
            case 27: 
            case 49: {
                this.EquipRdL01.isHidden = false;
                this.EquipRdR01.isHidden = false;
                this.EquipRdL02.isHidden = false;
                this.EquipRdR02.isHidden = false;
                this.EquipRdL03.isHidden = true;
                this.EquipRdR03.isHidden = true;
                break;
            }
            case 28: 
            case 48: {
                this.EquipRdL01.isHidden = false;
                this.EquipRdR01.isHidden = false;
                this.EquipRdL02.isHidden = false;
                this.EquipRdR02.isHidden = false;
                this.EquipRdL03.isHidden = false;
                this.EquipRdR03.isHidden = false;
                this.EquipRdL04.isHidden = true;
                this.EquipRdR04.isHidden = true;
                break;
            }
            case 29: 
            case 47: {
                this.EquipRdL01.isHidden = false;
                this.EquipRdR01.isHidden = false;
                this.EquipRdL02.isHidden = false;
                this.EquipRdR02.isHidden = false;
                this.EquipRdL03.isHidden = false;
                this.EquipRdR03.isHidden = false;
                this.EquipRdL04.isHidden = false;
                this.EquipRdR04.isHidden = false;
                this.EquipRdL05.isHidden = true;
                this.EquipRdR05.isHidden = true;
                break;
            }
            case 30: 
            case 46: {
                this.EquipRdL01.isHidden = false;
                this.EquipRdR01.isHidden = false;
                this.EquipRdL02.isHidden = false;
                this.EquipRdR02.isHidden = false;
                this.EquipRdL03.isHidden = false;
                this.EquipRdR03.isHidden = false;
                this.EquipRdL04.isHidden = false;
                this.EquipRdR04.isHidden = false;
                this.EquipRdL05.isHidden = false;
                this.EquipRdR05.isHidden = false;
                this.EquipRdL06.isHidden = true;
                this.EquipRdR06.isHidden = true;
                break;
            }
            default: {
                if (attackTime >= 46 || attackTime <= 30) break;
                this.EquipRdL01.isHidden = false;
                this.EquipRdR01.isHidden = false;
                this.EquipRdL02.isHidden = false;
                this.EquipRdR02.isHidden = false;
                this.EquipRdL03.isHidden = false;
                this.EquipRdR03.isHidden = false;
                this.EquipRdL04.isHidden = false;
                this.EquipRdR04.isHidden = false;
                this.EquipRdL05.isHidden = false;
                this.EquipRdR05.isHidden = false;
                this.EquipRdL06.isHidden = false;
                this.EquipRdR06.isHidden = false;
            }
        }
    }
}
