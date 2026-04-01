package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelHeavyCruiserNe
extends ShipModelBaseAdv {
    private final ModelRenderer BodyMain;
    private final ModelRenderer ArmLeft01;
    private final ModelRenderer ArmRight01;
    private final ModelRenderer LegLeft01;
    private final ModelRenderer LegRight01;
    private final ModelRenderer Neck;
    private final ModelRenderer Head;
    private final ModelRenderer Cloth01;
    private final ModelRenderer TailBase;
    private final ModelRenderer ArmLeft02;
    private final ModelRenderer ArmRight02;
    private final ModelRenderer LegLeft02;
    private final ModelRenderer LegRight02;
    private final ModelRenderer Hair;
    private final ModelRenderer HairMain;
    private final ModelRenderer Ear01;
    private final ModelRenderer Ear02;
    private final ModelRenderer Ahoke;
    private final ModelRenderer Hair01;
    private final ModelRenderer Hair02;
    private final ModelRenderer Hair03;
    private final ModelRenderer TailL01;
    private final ModelRenderer TailR01;
    private final ModelRenderer TailL02;
    private final ModelRenderer TailL03;
    private final ModelRenderer TailL04;
    private final ModelRenderer TailL05;
    private final ModelRenderer TailL06;
    private final ModelRenderer TailLHead01;
    private final ModelRenderer TailLHead02;
    private final ModelRenderer TailLC01;
    private final ModelRenderer TailLC02;
    private final ModelRenderer TailLC03;
    private final ModelRenderer TailR02;
    private final ModelRenderer TailR03;
    private final ModelRenderer TailR04;
    private final ModelRenderer TailR05;
    private final ModelRenderer TailR06;
    private final ModelRenderer TailRHead01;
    private final ModelRenderer TailRHead02;
    private final ModelRenderer TailRC01;
    private final ModelRenderer TailRC02;
    private final ModelRenderer TailRC03;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowHead;

    public ModelHeavyCruiserNe() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.scale = 0.4f;
        this.offsetY = 2.63f;
        this.offsetItem = new float[]{0.07f, 0.99f, -0.09f};
        this.offsetBlock = new float[]{0.07f, 0.99f, -0.09f};
        this.TailRC02 = new ModelRenderer(this, 0, 0);
        this.TailRC02.setRotationPoint(-3.0f, 2.0f, 13.5f);
        this.TailRC02.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 11, 0.0f);
        this.setRotateAngle(this.TailRC02, -0.091106184f, -0.08726646f, 0.0f);
        this.Hair = new ModelRenderer(this, 50, 40);
        this.Hair.setRotationPoint(0.0f, -4.0f, 0.0f);
        this.Hair.addBox(-8.0f, -8.0f, -7.2f, 16, 17, 8, 0.0f);
        this.TailLC01 = new ModelRenderer(this, 0, 0);
        this.TailLC01.setRotationPoint(0.0f, 2.2f, 13.5f);
        this.TailLC01.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 11, 0.0f);
        this.setRotateAngle(this.TailLC01, -0.18203785f, 0.0f, 0.0f);
        this.Hair02 = new ModelRenderer(this, 78, 92);
        this.Hair02.setRotationPoint(-6.3f, 4.7f, 2.0f);
        this.Hair02.addBox(-2.0f, 0.0f, -3.5f, 3, 10, 7, 0.0f);
        this.setRotateAngle(this.Hair02, 0.20943952f, 0.0f, 0.17453292f);
        this.TailRC01 = new ModelRenderer(this, 0, 0);
        this.TailRC01.setRotationPoint(0.0f, 2.2f, 13.5f);
        this.TailRC01.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 11, 0.0f);
        this.setRotateAngle(this.TailRC01, -0.18203785f, 0.0f, 0.0f);
        this.LegLeft01 = new ModelRenderer(this, 48, 92);
        this.LegLeft01.setRotationPoint(4.0f, 3.0f, 8.3f);
        this.LegLeft01.addBox(-2.5f, 0.0f, -2.5f, 5, 8, 5, 0.0f);
        this.setRotateAngle(this.LegLeft01, 0.13962634f, 0.0f, 0.17453292f);
        this.LegLeft02 = new ModelRenderer(this, 48, 105);
        this.LegLeft02.setRotationPoint(0.0f, 8.0f, -2.5f);
        this.LegLeft02.addBox(-2.5f, 0.0f, 0.0f, 5, 7, 5, 0.0f);
        this.Ahoke = new ModelRenderer(this, 104, 29);
        this.Ahoke.setRotationPoint(0.0f, -8.5f, -5.0f);
        this.Ahoke.addBox(0.0f, -4.0f, -11.5f, 0, 12, 12, 0.0f);
        this.setRotateAngle(this.Ahoke, 0.0f, 0.5235988f, 0.0f);
        this.BodyMain = new ModelRenderer(this, 0, 93);
        this.BodyMain.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.BodyMain.addBox(-5.5f, -4.5f, -12.0f, 11, 10, 24, 0.0f);
        this.Neck = new ModelRenderer(this, 0, 78);
        this.Neck.setRotationPoint(0.0f, -4.0f, -9.4f);
        this.Neck.addBox(-5.0f, -2.0f, -4.5f, 10, 5, 9, 0.0f);
        this.setRotateAngle(this.Neck, 0.41887903f, 0.0f, 0.0f);
        this.ArmLeft01 = new ModelRenderer(this, 0, 92);
        this.ArmLeft01.setRotationPoint(4.0f, 3.0f, -6.0f);
        this.ArmLeft01.addBox(-2.5f, 0.0f, -2.5f, 5, 8, 5, 0.0f);
        this.setRotateAngle(this.ArmLeft01, -0.13962634f, 0.0f, 0.20943952f);
        this.TailBase = new ModelRenderer(this, 98, 0);
        this.TailBase.setRotationPoint(0.0f, -0.5f, 9.0f);
        this.TailBase.addBox(-4.0f, -4.0f, 0.0f, 8, 8, 7, 0.0f);
        this.setRotateAngle(this.TailBase, 0.7853982f, 0.0f, 0.0f);
        this.ArmRight02 = new ModelRenderer(this, 0, 105);
        this.ArmRight02.mirror = true;
        this.ArmRight02.setRotationPoint(-2.5f, 8.0f, 2.5f);
        this.ArmRight02.addBox(0.0f, 0.0f, -5.0f, 5, 7, 5, 0.0f);
        this.Ear02 = new ModelRenderer(this, 0, 26);
        this.Ear02.mirror = true;
        this.Ear02.setRotationPoint(-4.2f, -11.0f, 6.8f);
        this.Ear02.addBox(-2.0f, 0.0f, -7.0f, 4, 7, 7, 0.0f);
        this.setRotateAngle(this.Ear02, -0.8378f, 0.1222f, -0.1745f);
        this.TailRC03 = new ModelRenderer(this, 0, 0);
        this.TailRC03.setRotationPoint(3.0f, 2.0f, 13.5f);
        this.TailRC03.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 11, 0.0f);
        this.setRotateAngle(this.TailRC03, -0.13665928f, 0.08726646f, 0.0f);
        this.Hair03 = new ModelRenderer(this, 80, 109);
        this.Hair03.setRotationPoint(0.2f, 7.5f, -0.3f);
        this.Hair03.addBox(-2.0f, 0.0f, -3.0f, 3, 12, 6, 0.0f);
        this.setRotateAngle(this.Hair03, -0.2617994f, 0.0f, -0.2617994f);
        this.LegRight01 = new ModelRenderer(this, 48, 92);
        this.LegRight01.mirror = true;
        this.LegRight01.setRotationPoint(-4.0f, 3.0f, 8.3f);
        this.LegRight01.addBox(-2.5f, 0.0f, -2.5f, 5, 8, 5, 0.0f);
        this.setRotateAngle(this.LegRight01, -0.13962634f, 0.0f, -0.17453292f);
        this.Ear01 = new ModelRenderer(this, 0, 26);
        this.Ear01.setRotationPoint(4.2f, -11.0f, 6.8f);
        this.Ear01.addBox(-2.0f, 0.0f, -7.0f, 4, 7, 7, 0.0f);
        this.setRotateAngle(this.Ear01, -0.8378f, -0.1222f, 0.1745f);
        this.ArmLeft02 = new ModelRenderer(this, 0, 105);
        this.ArmLeft02.setRotationPoint(2.5f, 8.0f, 2.5f);
        this.ArmLeft02.addBox(-5.0f, 0.0f, -5.0f, 5, 7, 5, 0.0f);
        this.TailL04 = new ModelRenderer(this, 97, 3);
        this.TailL04.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.TailL04.addBox(-3.5f, -3.5f, 0.0f, 7, 7, 7, 0.0f);
        this.setRotateAngle(this.TailL04, 0.2617994f, 0.20943952f, 0.0f);
        this.ArmRight01 = new ModelRenderer(this, 0, 92);
        this.ArmRight01.mirror = true;
        this.ArmRight01.setRotationPoint(-4.0f, 3.0f, -6.0f);
        this.ArmRight01.addBox(-2.5f, 0.0f, -2.5f, 5, 8, 5, 0.0f);
        this.setRotateAngle(this.ArmRight01, 0.13962634f, 0.0f, -0.20943952f);
        this.TailRHead01 = new ModelRenderer(this, 76, 18);
        this.TailRHead01.mirror = true;
        this.TailRHead01.setRotationPoint(0.0f, 0.0f, -2.5f);
        this.TailRHead01.addBox(-5.5f, -2.0f, 0.0f, 11, 6, 15, 0.0f);
        this.setRotateAngle(this.TailRHead01, -0.12217305f, 0.0f, 0.0f);
        this.TailL05 = new ModelRenderer(this, 95, 2);
        this.TailL05.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.TailL05.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 7, 0.0f);
        this.setRotateAngle(this.TailL05, 0.2617994f, 0.13962634f, 0.0f);
        this.TailL06 = new ModelRenderer(this, 89, 0);
        this.TailL06.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.TailL06.addBox(-4.5f, -3.5f, 0.0f, 9, 7, 10, 0.0f);
        this.setRotateAngle(this.TailL06, 0.2617994f, 0.06981317f, 0.0f);
        this.TailL03 = new ModelRenderer(this, 95, 1);
        this.TailL03.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.TailL03.addBox(-3.5f, -3.5f, 0.0f, 7, 7, 7, 0.0f);
        this.setRotateAngle(this.TailL03, 0.2617994f, 0.2443461f, 0.0f);
        this.TailLC02 = new ModelRenderer(this, 0, 0);
        this.TailLC02.setRotationPoint(-3.0f, 2.0f, 13.5f);
        this.TailLC02.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 11, 0.0f);
        this.setRotateAngle(this.TailLC02, -0.091106184f, -0.08726646f, 0.0f);
        this.TailR04 = new ModelRenderer(this, 100, 2);
        this.TailR04.mirror = true;
        this.TailR04.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.TailR04.addBox(-3.5f, -3.5f, 0.0f, 7, 7, 7, 0.0f);
        this.setRotateAngle(this.TailR04, 0.41887903f, 0.13962634f, 0.0f);
        this.LegRight02 = new ModelRenderer(this, 48, 105);
        this.LegRight02.mirror = true;
        this.LegRight02.setRotationPoint(0.0f, 8.0f, -2.5f);
        this.LegRight02.addBox(-2.5f, 0.0f, 0.0f, 5, 7, 5, 0.0f);
        this.Hair01 = new ModelRenderer(this, 0, 40);
        this.Hair01.setRotationPoint(0.0f, 9.0f, 1.6f);
        this.Hair01.addBox(-7.5f, 0.0f, 0.0f, 15, 7, 9, 0.0f);
        this.setRotateAngle(this.Hair01, 0.34906584f, 0.0f, 0.0f);
        this.TailLHead01 = new ModelRenderer(this, 76, 18);
        this.TailLHead01.setRotationPoint(0.0f, 0.0f, -2.5f);
        this.TailLHead01.addBox(-5.5f, -2.0f, 0.0f, 11, 6, 15, 0.0f);
        this.setRotateAngle(this.TailLHead01, -0.12217305f, 0.0f, 0.0f);
        this.TailR06 = new ModelRenderer(this, 89, 1);
        this.TailR06.mirror = true;
        this.TailR06.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.TailR06.addBox(-4.5f, -3.5f, 0.0f, 9, 7, 10, 0.0f);
        this.setRotateAngle(this.TailR06, 0.2617994f, 0.13962634f, 0.0f);
        this.TailL01 = new ModelRenderer(this, 98, 0);
        this.TailL01.setRotationPoint(1.5f, 0.0f, 6.0f);
        this.TailL01.addBox(-3.0f, -3.0f, 0.0f, 6, 6, 7, 0.0f);
        this.setRotateAngle(this.TailL01, 0.2617994f, 0.41887903f, 0.0f);
        this.TailLHead02 = new ModelRenderer(this, 22, 27);
        this.TailLHead02.setRotationPoint(0.0f, 0.0f, 1.5f);
        this.TailLHead02.addBox(-5.0f, -4.0f, 0.0f, 10, 3, 9, 0.0f);
        this.setRotateAngle(this.TailLHead02, 0.08726646f, 0.0f, 0.0f);
        this.TailR03 = new ModelRenderer(this, 97, 2);
        this.TailR03.mirror = true;
        this.TailR03.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.TailR03.addBox(-3.5f, -3.5f, 0.0f, 7, 7, 7, 0.0f);
        this.setRotateAngle(this.TailR03, 0.31415927f, 0.06981317f, 0.0f);
        this.Head = new ModelRenderer(this, 44, 65);
        this.Head.setRotationPoint(0.0f, -6.0f, -13.0f);
        this.Head.addBox(-7.0f, -11.0f, -6.5f, 14, 14, 13, 0.0f);
        this.TailRHead02 = new ModelRenderer(this, 22, 27);
        this.TailRHead02.mirror = true;
        this.TailRHead02.setRotationPoint(0.0f, 0.0f, 1.5f);
        this.TailRHead02.addBox(-5.0f, -4.0f, 0.0f, 10, 3, 9, 0.0f);
        this.setRotateAngle(this.TailRHead02, 0.08726646f, 0.0f, 0.0f);
        this.Cloth01 = new ModelRenderer(this, 42, 39);
        this.Cloth01.setRotationPoint(0.0f, -1.0f, -13.0f);
        this.Cloth01.addBox(-4.0f, 0.0f, 0.0f, 8, 9, 0, 0.0f);
        this.setRotateAngle(this.Cloth01, -0.08726646f, 0.0f, 0.0f);
        this.HairMain = new ModelRenderer(this, 0, 56);
        this.HairMain.setRotationPoint(0.0f, -11.5f, -3.0f);
        this.HairMain.addBox(-7.5f, 0.0f, 0.0f, 15, 12, 10, 0.0f);
        this.TailR01 = new ModelRenderer(this, 101, 0);
        this.TailR01.mirror = true;
        this.TailR01.setRotationPoint(-1.5f, 0.0f, 6.0f);
        this.TailR01.addBox(-3.0f, -3.0f, 0.0f, 6, 6, 7, 0.0f);
        this.setRotateAngle(this.TailR01, 0.2617994f, -0.06981317f, 0.0f);
        this.TailR02 = new ModelRenderer(this, 102, 3);
        this.TailR02.mirror = true;
        this.TailR02.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.TailR02.addBox(-3.0f, -3.0f, 0.0f, 6, 6, 7, 0.0f);
        this.setRotateAngle(this.TailR02, 0.2617994f, 0.0f, 0.0f);
        this.TailL02 = new ModelRenderer(this, 95, 3);
        this.TailL02.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.TailL02.addBox(-3.0f, -3.0f, 0.0f, 6, 6, 7, 0.0f);
        this.setRotateAngle(this.TailL02, 0.2617994f, 0.31415927f, 0.0f);
        this.TailLC03 = new ModelRenderer(this, 0, 0);
        this.TailLC03.setRotationPoint(3.0f, 2.0f, 13.5f);
        this.TailLC03.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 11, 0.0f);
        this.setRotateAngle(this.TailLC03, -0.13665928f, 0.08726646f, 0.0f);
        this.TailR05 = new ModelRenderer(this, 97, 0);
        this.TailR05.mirror = true;
        this.TailR05.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.TailR05.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 7, 0.0f);
        this.setRotateAngle(this.TailR05, 0.5235988f, 0.13962634f, 0.0f);
        this.TailRHead01.addChild(this.TailRC02);
        this.Head.addChild(this.Hair);
        this.TailLHead01.addChild(this.TailLC01);
        this.HairMain.addChild(this.Hair02);
        this.TailRHead01.addChild(this.TailRC01);
        this.BodyMain.addChild(this.LegLeft01);
        this.LegLeft01.addChild(this.LegLeft02);
        this.Hair.addChild(this.Ahoke);
        this.BodyMain.addChild(this.Neck);
        this.BodyMain.addChild(this.ArmLeft01);
        this.BodyMain.addChild(this.TailBase);
        this.ArmRight01.addChild(this.ArmRight02);
        this.Head.addChild(this.Ear02);
        this.TailRHead01.addChild(this.TailRC03);
        this.Hair02.addChild(this.Hair03);
        this.BodyMain.addChild(this.LegRight01);
        this.Head.addChild(this.Ear01);
        this.ArmLeft01.addChild(this.ArmLeft02);
        this.TailL03.addChild(this.TailL04);
        this.BodyMain.addChild(this.ArmRight01);
        this.TailR06.addChild(this.TailRHead01);
        this.TailL04.addChild(this.TailL05);
        this.TailL05.addChild(this.TailL06);
        this.TailL02.addChild(this.TailL03);
        this.TailLHead01.addChild(this.TailLC02);
        this.TailR03.addChild(this.TailR04);
        this.LegRight01.addChild(this.LegRight02);
        this.HairMain.addChild(this.Hair01);
        this.TailL06.addChild(this.TailLHead01);
        this.TailR05.addChild(this.TailR06);
        this.TailBase.addChild(this.TailL01);
        this.TailL06.addChild(this.TailLHead02);
        this.TailR02.addChild(this.TailR03);
        this.BodyMain.addChild(this.Head);
        this.TailR06.addChild(this.TailRHead02);
        this.BodyMain.addChild(this.Cloth01);
        this.Head.addChild(this.HairMain);
        this.TailBase.addChild(this.TailR01);
        this.TailR01.addChild(this.TailR02);
        this.TailL01.addChild(this.TailL02);
        this.TailLHead01.addChild(this.TailLC03);
        this.TailR04.addChild(this.TailR05);
        this.GlowBodyMain = new ModelRenderer(this, 0, 0);
        this.GlowBodyMain.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.GlowHead = new ModelRenderer(this, 0, 0);
        this.GlowHead.setRotationPoint(0.0f, -6.0f, -13.0f);
        this.Face0 = new ModelRenderer(this, 98, 63);
        this.Face0.setRotationPoint(0.0f, -8.5f, -6.1f);
        this.Face0.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Face1 = new ModelRenderer(this, 98, 76);
        this.Face1.setRotationPoint(0.0f, -8.5f, -6.1f);
        this.Face1.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Face2 = new ModelRenderer(this, 98, 89);
        this.Face2.setRotationPoint(0.0f, -8.5f, -6.1f);
        this.Face2.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Face3 = new ModelRenderer(this, 98, 102);
        this.Face3.setRotationPoint(0.0f, -8.5f, -6.1f);
        this.Face3.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Face4 = new ModelRenderer(this, 98, 115);
        this.Face4.setRotationPoint(0.0f, -8.5f, -6.1f);
        this.Face4.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Mouth0 = new ModelRenderer(this, 100, 53);
        this.Mouth0.setRotationPoint(0.0f, -0.7f, -6.2f);
        this.Mouth0.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.Mouth1 = new ModelRenderer(this, 100, 58);
        this.Mouth1.setRotationPoint(0.0f, -0.7f, -6.2f);
        this.Mouth1.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.Mouth2 = new ModelRenderer(this, 114, 53);
        this.Mouth2.setRotationPoint(0.0f, -0.7f, -6.2f);
        this.Mouth2.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.Flush0 = new ModelRenderer(this, 114, 58);
        this.Flush0.setRotationPoint(-6.0f, 0.7f, -6.8f);
        this.Flush0.addBox(-1.0f, 0.0f, -0.5f, 2, 1, 0, 0.0f);
        this.Flush1 = new ModelRenderer(this, 114, 58);
        this.Flush1.setRotationPoint(6.0f, 0.7f, -6.8f);
        this.Flush1.addBox(-1.0f, 0.0f, -0.5f, 2, 1, 0, 0.0f);
        this.GlowBodyMain.addChild(this.GlowHead);
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
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.rotateAngleX = this.BodyMain.rotateAngleX;
        this.GlowBodyMain.rotateAngleY = this.BodyMain.rotateAngleY;
        this.GlowBodyMain.rotateAngleZ = this.BodyMain.rotateAngleZ;
        this.GlowHead.rotateAngleX = this.Head.rotateAngleX;
        this.GlowHead.rotateAngleY = this.Head.rotateAngleY;
        this.GlowHead.rotateAngleZ = this.Head.rotateAngleZ;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        GlStateManager.translate(0.0f, 0.2f, 0.0f);
        this.setFaceHungry(ent);
        this.Head.rotateAngleX = 0.7853f;
        this.Head.rotateAngleY = 0.0f;
        this.Ahoke.rotateAngleY = 0.45f;
        this.BodyMain.rotateAngleX = 0.0f;
        this.BodyMain.rotateAngleY = 0.0f;
        this.BodyMain.rotateAngleZ = -1.4835f;
        this.Head.offsetY = 0.0f;
        this.GlowHead.offsetY = 0.0f;
        this.Hair02.rotateAngleX = 0.21f;
        this.Hair02.rotateAngleZ = 0.0f;
        this.Hair03.rotateAngleX = -0.2618f;
        this.Hair03.rotateAngleZ = 0.0f;
        this.ArmLeft01.rotateAngleX = 0.1745f;
        this.ArmLeft01.rotateAngleZ = 0.4537f;
        this.ArmLeft01.offsetZ = 0.0f;
        this.ArmLeft02.rotateAngleZ = 0.0f;
        this.ArmRight01.rotateAngleX = -0.1745f;
        this.ArmRight01.rotateAngleZ = -0.05f;
        this.ArmRight01.offsetZ = 0.0f;
        this.ArmRight02.rotateAngleZ = 0.0f;
        this.LegLeft01.rotateAngleX = -0.1745f;
        this.LegLeft01.rotateAngleY = 0.0f;
        this.LegLeft01.rotateAngleZ = 0.4537f;
        this.LegLeft02.rotateAngleX = 0.0f;
        this.LegLeft02.rotateAngleZ = 0.0f;
        this.LegRight01.rotateAngleX = 0.1745f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleZ = -0.05f;
        this.LegRight02.rotateAngleX = 0.0f;
        this.LegRight02.rotateAngleZ = 0.0f;
        this.TailBase.rotateAngleX = 0.8f;
        this.TailL01.rotateAngleX = 0.2618f;
        this.TailL01.rotateAngleY = -0.2f;
        this.TailL01.rotateAngleZ = this.TailL01.rotateAngleY * 0.25f;
        this.TailL02.rotateAngleX = 0.2618f;
        this.TailL02.rotateAngleY = -0.3f;
        this.TailL02.rotateAngleZ = this.TailL02.rotateAngleY * 0.25f;
        this.TailL03.rotateAngleX = 0.2618f;
        this.TailL03.rotateAngleY = -0.2f;
        this.TailL03.rotateAngleZ = this.TailL03.rotateAngleY * 0.25f;
        this.TailL04.rotateAngleX = 0.35f;
        this.TailL04.rotateAngleY = 0.2f;
        this.TailL04.rotateAngleZ = this.TailL04.rotateAngleY * 0.25f;
        this.TailL05.rotateAngleX = 0.4f;
        this.TailL05.rotateAngleY = 0.2f;
        this.TailL05.rotateAngleZ = this.TailL05.rotateAngleY * 0.25f;
        this.TailL06.rotateAngleX = 0.45f;
        this.TailL06.rotateAngleY = 0.1f;
        this.TailL06.rotateAngleZ = this.TailL06.rotateAngleY * 0.25f;
        this.TailR01.rotateAngleX = 0.6f;
        this.TailR01.rotateAngleY = 0.2617f;
        this.TailR01.rotateAngleZ = this.TailR01.rotateAngleY * 0.25f;
        this.TailR02.rotateAngleX = 0.6f;
        this.TailR02.rotateAngleY = -0.2f;
        this.TailR02.rotateAngleZ = this.TailR02.rotateAngleY * 0.25f;
        this.TailR03.rotateAngleX = 0.5f;
        this.TailR03.rotateAngleY = -0.1f;
        this.TailR03.rotateAngleZ = this.TailR03.rotateAngleY * 0.25f;
        this.TailR04.rotateAngleX = 0.3f;
        this.TailR04.rotateAngleY = -0.1f;
        this.TailR04.rotateAngleZ = this.TailR04.rotateAngleY * 0.25f;
        this.TailR05.rotateAngleX = 0.1f;
        this.TailR05.rotateAngleY = 0.1f;
        this.TailR05.rotateAngleZ = this.TailR05.rotateAngleY * 0.25f;
        this.TailR06.rotateAngleX = -0.1f;
        this.TailR06.rotateAngleY = 0.1f;
        this.TailR06.rotateAngleZ = this.TailR06.rotateAngleY * 0.25f;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float f6;
        float angleX = MathHelper.cos(f2 * 0.08f + f * 0.25f);
        float angleX1 = MathHelper.cos(f2 * 0.08f + 0.3f + f * 0.5f);
        float angleX2 = MathHelper.cos(f2 * 0.08f + 0.6f + f * 0.5f);
        float angleAdd1 = MathHelper.cos(f * 0.7f) * f1;
        float angleAdd2 = MathHelper.cos(f * 0.7f + (float)Math.PI) * f1;
        float addk1;
        float addk2;
        if (ent.getShipDepth(0) > 0.0) {
            GlStateManager.translate(0.0f, angleX * 0.05f + 0.025f, 0.0f);
        }
        addk1 = angleAdd1 * 0.5f - 0.14f;
        addk2 = angleAdd2 * 0.5f + 0.14f;
        this.ArmRight01.rotateAngleX = addk1;
        this.ArmLeft01.rotateAngleX = addk2;
        this.Head.rotateAngleX = f4 * 0.014f;
        this.Head.rotateAngleY = f3 * 0.01f;
        this.Ahoke.rotateAngleY = angleX * 0.25f + 0.45f;
        this.BodyMain.rotateAngleX = 0.0f;
        this.BodyMain.rotateAngleY = 0.0f;
        this.BodyMain.rotateAngleZ = 0.0f;
        this.Head.offsetY = 0.0f;
        this.GlowHead.offsetY = 0.0f;
        this.Hair02.rotateAngleX = angleX1 * 0.04f + 0.21f;
        this.Hair02.rotateAngleZ = 0.0f;
        this.Hair03.rotateAngleX = angleX2 * 0.07f - 0.2618f;
        this.Hair03.rotateAngleZ = 0.0f;
        this.ArmLeft01.rotateAngleZ = 0.21f;
        this.ArmLeft01.offsetZ = 0.0f;
        this.ArmLeft02.rotateAngleZ = 0.0f;
        this.ArmRight01.rotateAngleZ = -0.21f;
        this.ArmRight01.offsetZ = 0.0f;
        this.ArmRight02.rotateAngleZ = 0.0f;
        this.LegLeft01.rotateAngleY = 0.0f;
        this.LegLeft01.rotateAngleZ = 0.1745f;
        this.LegLeft02.rotateAngleX = 0.0f;
        this.LegLeft02.rotateAngleZ = 0.0f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleZ = -0.1745f;
        this.LegRight02.rotateAngleX = 0.0f;
        this.LegRight02.rotateAngleZ = 0.0f;
        this.TailBase.rotateAngleX = 0.8f;
        this.TailL01.rotateAngleX = 0.2618f;
        this.TailL01.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 0.7f) * 0.2f + 0.5f;
        this.TailL01.rotateAngleZ = this.TailL01.rotateAngleY * 0.25f;
        this.TailL02.rotateAngleX = 0.2618f;
        this.TailL02.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 1.4f) * 0.25f;
        this.TailL02.rotateAngleZ = this.TailL02.rotateAngleY * 0.25f;
        this.TailL03.rotateAngleX = 0.2618f;
        this.TailL03.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 2.1f) * 0.3f;
        this.TailL03.rotateAngleZ = this.TailL03.rotateAngleY * 0.25f;
        this.TailL04.rotateAngleX = 0.35f;
        this.TailL04.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 2.8f) * 0.35f;
        this.TailL04.rotateAngleZ = this.TailL04.rotateAngleY * 0.25f;
        this.TailL05.rotateAngleX = 0.4f;
        this.TailL05.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 3.5f) * 0.4f;
        this.TailL05.rotateAngleZ = this.TailL05.rotateAngleY * 0.25f;
        this.TailL06.rotateAngleX = 0.45f;
        this.TailL06.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 4.2f) * 0.35f;
        this.TailL06.rotateAngleZ = this.TailL06.rotateAngleY * 0.25f;
        this.TailR01.rotateAngleX = 0.2618f;
        this.TailR01.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 0.7f) * 0.2f - 0.5f;
        this.TailR01.rotateAngleZ = this.TailR01.rotateAngleY * 0.25f;
        this.TailR02.rotateAngleX = 0.2618f;
        this.TailR02.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 1.4f) * 0.25f;
        this.TailR02.rotateAngleZ = this.TailR02.rotateAngleY * 0.25f;
        this.TailR03.rotateAngleX = 0.2618f;
        this.TailR03.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 2.1f) * 0.3f;
        this.TailR03.rotateAngleZ = this.TailR03.rotateAngleY * 0.25f;
        this.TailR04.rotateAngleX = 0.35f;
        this.TailR04.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 2.8f) * 0.35f;
        this.TailR04.rotateAngleZ = this.TailR04.rotateAngleY * 0.25f;
        this.TailR05.rotateAngleX = 0.4f;
        this.TailR05.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 3.5f) * 0.4f;
        this.TailR05.rotateAngleZ = this.TailR05.rotateAngleY * 0.25f;
        this.TailR06.rotateAngleX = 0.45f;
        this.TailR06.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 4.2f) * 0.45f;
        this.TailR06.rotateAngleZ = this.TailR06.rotateAngleY * 0.25f;
        float modf2 = f2 % 128.0f;
        if (modf2 < 6.0f) {
            if (modf2 >= 3.0f) {
                modf2 -= 3.0f;
            }
            float anglef2 = MathHelper.sin(modf2 * 1.0472f) * 0.25f;
            this.Ear01.rotateAngleZ = anglef2 + 0.1745f;
            this.Ear02.rotateAngleZ = -anglef2 - 0.1745f;
        } else {
            this.Ear01.rotateAngleZ = 0.1745f;
            this.Ear02.rotateAngleZ = -0.1745f;
        }
        if (ent.getIsSprinting() || f1 > 0.8f) {
            this.ArmRight01.rotateAngleX = addk1 *= 2.0f;
            this.ArmLeft01.rotateAngleX = addk2 *= 2.0f;
        }
        this.Head.rotateAngleZ = EmotionHelper.getHeadTiltAngle(ent, f2);
        if (ent.getIsSneaking()) {
            this.Head.offsetY = 0.2f;
            this.GlowHead.offsetY = 0.2f;
        }
        if (ent.getIsSitting() || ent.getIsRiding()) {
            if (ent.getStateEmotion(1) == 4) {
                GlStateManager.translate(0.0f, 0.22f, 0.0f);
                this.Head.rotateAngleX = 1.5359f;
                this.Head.offsetY = 0.25f;
                this.GlowHead.rotateAngleX = 1.5359f;
                this.GlowHead.offsetY = 0.25f;
                addk1 = 1.5359f;
                addk2 = 1.5359f;
                this.ArmLeft01.rotateAngleX = -1.5359f;
                this.ArmLeft01.rotateAngleZ = 0.0f;
                this.ArmLeft01.offsetZ = -0.18f;
                this.ArmRight01.rotateAngleX = -1.5359f;
                this.ArmRight01.rotateAngleZ = 0.0f;
                this.ArmRight01.offsetZ = -0.18f;
                this.TailBase.rotateAngleX = 0.0873f;
                this.TailL01.rotateAngleX = 0.02618f;
                this.TailL01.rotateAngleY *= 0.5f;
                this.TailL02.rotateAngleX = -0.02618f;
                this.TailL02.rotateAngleY *= 0.5f;
                this.TailL03.rotateAngleX = -0.02618f;
                this.TailL03.rotateAngleY *= 0.5f;
                this.TailL04.rotateAngleX = -0.035f;
                this.TailL04.rotateAngleY *= 0.5f;
                this.TailL05.rotateAngleX = -0.04f;
                this.TailL05.rotateAngleY *= 0.5f;
                this.TailL06.rotateAngleX = -0.045f;
                this.TailL06.rotateAngleY *= 0.5f;
                this.TailR01.rotateAngleX = -0.02618f;
                this.TailR01.rotateAngleY *= 0.5f;
                this.TailR02.rotateAngleX = -0.02618f;
                this.TailR02.rotateAngleY *= 0.5f;
                this.TailR03.rotateAngleX = -0.02618f;
                this.TailR03.rotateAngleY *= 0.5f;
                this.TailR04.rotateAngleX = -0.035f;
                this.TailR04.rotateAngleY *= 0.5f;
                this.TailR05.rotateAngleX = -0.04f;
                this.TailR05.rotateAngleY *= 0.5f;
                this.TailR06.rotateAngleX = -0.045f;
                this.TailR06.rotateAngleY *= 0.5f;
            } else {
                GlStateManager.translate(0.0f, 0.22f, 0.0f);
                this.Head.rotateAngleX -= 0.5f;
                this.GlowHead.rotateAngleX -= 0.5f;
                this.Head.offsetY = 0.25f;
                this.GlowHead.offsetY = 0.25f;
                addk1 = 1.5359f;
                addk2 = 1.5359f;
                this.ArmLeft01.rotateAngleX = -1.5359f;
                this.ArmLeft01.rotateAngleZ = 0.0f;
                this.ArmLeft01.offsetZ = -0.18f;
                this.ArmLeft02.rotateAngleZ = 1.1868f;
                this.ArmRight01.rotateAngleX = -1.5359f;
                this.ArmRight01.rotateAngleZ = 0.0f;
                this.ArmRight01.offsetZ = -0.18f;
                this.ArmRight02.rotateAngleZ = -1.1868f;
            }
        }
        if (ent.getAttackTick() > 20) {
            this.TailL01.rotateAngleX = 0.2618f;
            this.TailL01.rotateAngleY = 0.2618f;
            this.TailL01.rotateAngleZ = 0.0f;
            this.TailL02.rotateAngleX = 0.35f;
            this.TailL02.rotateAngleY = 0.1748f;
            this.TailL02.rotateAngleZ = 0.0f;
            this.TailL03.rotateAngleX = 0.4363f;
            this.TailL03.rotateAngleY = 0.14f;
            this.TailL03.rotateAngleZ = 0.0f;
            this.TailL04.rotateAngleX = 0.5236f;
            this.TailL04.rotateAngleY = 0.14f;
            this.TailL04.rotateAngleZ = 0.0f;
            this.TailL05.rotateAngleX = 0.6109f;
            this.TailL05.rotateAngleY = 0.1745f;
            this.TailL05.rotateAngleZ = 0.0f;
            this.TailL06.rotateAngleX = 0.35f;
            this.TailL06.rotateAngleY = 0.0f;
            this.TailL06.rotateAngleZ = 0.0f;
            this.TailR01.rotateAngleX = 0.2618f;
            this.TailR01.rotateAngleY = -0.2618f;
            this.TailR01.rotateAngleZ = 0.0f;
            this.TailR02.rotateAngleX = 0.35f;
            this.TailR02.rotateAngleY = -0.1748f;
            this.TailR02.rotateAngleZ = 0.0f;
            this.TailR03.rotateAngleX = 0.35f;
            this.TailR03.rotateAngleY = -0.14f;
            this.TailR03.rotateAngleZ = 0.0f;
            this.TailR04.rotateAngleX = 0.4363f;
            this.TailR04.rotateAngleY = -0.14f;
            this.TailR04.rotateAngleZ = 0.0f;
            this.TailR05.rotateAngleX = 0.4363f;
            this.TailR05.rotateAngleY = -0.14f;
            this.TailR05.rotateAngleZ = 0.0f;
            this.TailR06.rotateAngleX = 0.35f;
            this.TailR06.rotateAngleY = 0.0f;
            this.TailR06.rotateAngleZ = 0.0f;
        }
        if ((f6 = ent.getSwingTime(f2 - (int)f2)) != 0.0f) {
            float f7 = MathHelper.sin(f6 * f6 * (float)Math.PI);
            float f8 = MathHelper.sin(MathHelper.sqrt(f6) * (float)Math.PI);
            this.ArmRight01.rotateAngleX = -0.6f - f8 * 80.0f * ((float)Math.PI / 180);
            this.ArmRight01.rotateAngleY = 0.0f - f7 * 20.0f * ((float)Math.PI / 180) + 0.2f;
            this.ArmRight01.rotateAngleZ = 0.2f - -f8 * 20.0f * ((float)Math.PI / 180);
        }
        float headZ = this.Head.rotateAngleZ * -0.5f;
        float headX = this.Head.rotateAngleX * -0.5f - 0.05f;
        this.Hair02.rotateAngleX += headX * 0.5f;
        this.Hair03.rotateAngleX += headX * 0.2f;
        this.Hair02.rotateAngleZ += headZ * 0.8f;
        this.Hair03.rotateAngleZ += headZ * 0.4f;
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
