package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelCAHime
extends ShipModelBaseAdv {
    private final ModelRenderer BodyMain;
    private final ModelRenderer ArmLeft01;
    private final ModelRenderer ArmRight01;
    private final ModelRenderer LegLeft01;
    private final ModelRenderer LegRight01;
    private final ModelRenderer Neck;
    private final ModelRenderer Head;
    private final ModelRenderer TailBase;
    private final ModelRenderer Band01;
    private final ModelRenderer Band02;
    private final ModelRenderer ArmLeft02;
    private final ModelRenderer ArmRight02;
    private final ModelRenderer LegLeft02;
    private final ModelRenderer LegRight02;
    private final ModelRenderer Hair;
    private final ModelRenderer HairMain;
    private final ModelRenderer Ear01;
    private final ModelRenderer Ear02;
    private final ModelRenderer Horn01;
    private final ModelRenderer Horn02;
    private final ModelRenderer HatBase;
    private final ModelRenderer Ahoke;
    private final ModelRenderer Hair01;
    private final ModelRenderer Hair02a;
    private final ModelRenderer Hair02b;
    private final ModelRenderer Hair03a;
    private final ModelRenderer Hair03b;
    private final ModelRenderer Horn03;
    private final ModelRenderer HatL;
    private final ModelRenderer HatR;
    private final ModelRenderer HatEyeL;
    private final ModelRenderer HatEyeR;
    private final ModelRenderer Tail01;
    private final ModelRenderer Tail01_1;
    private final ModelRenderer Tail02;
    private final ModelRenderer Tail03;
    private final ModelRenderer Tail04;
    private final ModelRenderer Tail05;
    private final ModelRenderer Tail06;
    private final ModelRenderer Tail07;
    private final ModelRenderer Tail08;
    private final ModelRenderer Tail09;
    private final ModelRenderer TailHead01;
    private final ModelRenderer TailJaw01;
    private final ModelRenderer TailC01;
    private final ModelRenderer TailC02;
    private final ModelRenderer Tail02_1;
    private final ModelRenderer Tail03_1;
    private final ModelRenderer Tail04_1;
    private final ModelRenderer Tail05_1;
    private final ModelRenderer Tail06_1;
    private final ModelRenderer Tail07_1;
    private final ModelRenderer Tail08_1;
    private final ModelRenderer Tail09_1;
    private final ModelRenderer TailHead01_1;
    private final ModelRenderer TailJaw01_1;
    private final ModelRenderer TailC01_1;
    private final ModelRenderer TailC02_1;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowHead;

    public ModelCAHime() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.scale = 0.45f;
        this.offsetY = 2.22f;
        this.offsetItem = new float[]{0.07f, 0.99f, -0.09f};
        this.offsetBlock = new float[]{0.07f, 0.99f, -0.09f};
        this.Hair01 = new ModelRenderer(this, 0, 40);
        this.Hair01.setRotationPoint(0.0f, 9.0f, 1.6f);
        this.Hair01.addBox(-7.5f, 0.0f, 0.0f, 15, 7, 9, 0.0f);
        this.setRotateAngle(this.Hair01, 0.34906584f, 0.0f, 0.0f);
        this.Hair03a = new ModelRenderer(this, 90, 32);
        this.Hair03a.setRotationPoint(6.4f, 9.8f, 5.5f);
        this.Hair03a.addBox(-1.5f, 0.0f, -3.0f, 3, 12, 4, 0.0f);
        this.setRotateAngle(this.Hair03a, -0.20943952f, -0.13962634f, 0.06981317f);
        this.LegLeft02 = new ModelRenderer(this, 46, 105);
        this.LegLeft02.setRotationPoint(0.0f, 8.0f, -2.5f);
        this.LegLeft02.addBox(-2.5f, 0.0f, 0.0f, 5, 7, 5, 0.0f);
        this.Neck = new ModelRenderer(this, 0, 78);
        this.Neck.setRotationPoint(0.0f, -2.0f, -9.4f);
        this.Neck.addBox(-5.0f, -4.0f, -4.5f, 10, 5, 9, 0.0f);
        this.setRotateAngle(this.Neck, 0.41887903f, 0.0f, 0.0f);
        this.Horn03 = new ModelRenderer(this, 40, 39);
        this.Horn03.setRotationPoint(1.5f, 1.5f, -6.0f);
        this.Horn03.addBox(-3.0f, -3.0f, -6.0f, 3, 3, 6, 0.0f);
        this.setRotateAngle(this.Horn03, -0.6981317f, 0.0f, 0.0f);
        this.HatEyeR = new ModelRenderer(this, 22, 28);
        this.HatEyeR.mirror = true;
        this.HatEyeR.setRotationPoint(-9.6f, -6.0f, 5.3f);
        this.HatEyeR.addBox(-1.0f, -3.0f, -3.0f, 1, 6, 6, 0.0f);
        this.setRotateAngle(this.HatEyeR, 0.08726646f, 0.05235988f, 0.05235988f);
        this.TailHead01_1 = new ModelRenderer(this, 40, 0);
        this.TailHead01_1.setRotationPoint(0.0f, -1.8f, 3.5f);
        this.TailHead01_1.addBox(-4.5f, 0.0f, 0.0f, 9, 6, 10, 0.0f);
        this.setRotateAngle(this.TailHead01_1, -0.17453292f, 0.0f, 0.0f);
        this.Tail03 = new ModelRenderer(this, 54, 16);
        this.Tail03.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail03.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail03, 0.61086524f, -0.08726646f, 0.0f);
        this.HatL = new ModelRenderer(this, 0, 0);
        this.HatL.setRotationPoint(-1.3f, 2.1f, -2.9f);
        this.HatL.addBox(0.0f, -14.0f, -1.0f, 10, 16, 10, 0.0f);
        this.setRotateAngle(this.HatL, 0.5235988f, 0.08726646f, 0.06981317f);
        this.Tail05_1 = new ModelRenderer(this, 58, 19);
        this.Tail05_1.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail05_1.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail05_1, 0.5235988f, 0.34906584f, 0.0f);
        this.Tail06 = new ModelRenderer(this, 83, 0);
        this.Tail06.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail06.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail06, 0.34906584f, 0.0f, 0.0f);
        this.Tail09_1 = new ModelRenderer(this, 96, 0);
        this.Tail09_1.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail09_1.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail09_1, -0.08726646f, 0.43633232f, 0.0f);
        this.Tail08_1 = new ModelRenderer(this, 83, 0);
        this.Tail08_1.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail08_1.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail08_1, -0.5235988f, 0.34906584f, 0.0f);
        this.LegRight01 = new ModelRenderer(this, 66, 92);
        this.LegRight01.mirror = true;
        this.LegRight01.setRotationPoint(-4.0f, 3.0f, 8.3f);
        this.LegRight01.addBox(-2.5f, 0.0f, -2.5f, 5, 8, 5, 0.0f);
        this.setRotateAngle(this.LegRight01, -0.13962634f, 0.0f, -0.17453292f);
        this.Tail02_1 = new ModelRenderer(this, 56, 17);
        this.Tail02_1.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail02_1.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail02_1, 0.34906584f, 0.2617994f, 0.0f);
        this.Hair02b = new ModelRenderer(this, 81, 116);
        this.Hair02b.setRotationPoint(-6.9f, 4.7f, 0.0f);
        this.Hair02b.addBox(-1.5f, 0.0f, -3.3f, 3, 7, 5, 0.0f);
        this.setRotateAngle(this.Hair02b, 0.0f, 0.0f, 0.08726646f);
        this.LegLeft01 = new ModelRenderer(this, 46, 92);
        this.LegLeft01.setRotationPoint(4.0f, 3.0f, 8.3f);
        this.LegLeft01.addBox(-2.5f, 0.0f, -2.5f, 5, 8, 5, 0.0f);
        this.setRotateAngle(this.LegLeft01, 0.13962634f, 0.0f, 0.17453292f);
        this.Band02 = new ModelRenderer(this, 40, 39);
        this.Band02.setRotationPoint(-4.5f, 1.7f, -12.0f);
        this.Band02.addBox(-0.5f, 0.0f, 0.0f, 1, 6, 0, 0.0f);
        this.setRotateAngle(this.Band02, -0.08726646f, 0.0f, 0.0f);
        this.Hair02a = new ModelRenderer(this, 81, 116);
        this.Hair02a.setRotationPoint(6.9f, 4.7f, 0.0f);
        this.Hair02a.addBox(-1.5f, 0.0f, -3.3f, 3, 7, 5, 0.0f);
        this.setRotateAngle(this.Hair02a, 0.0f, 0.0f, -0.08726646f);
        this.HairMain = new ModelRenderer(this, 0, 56);
        this.HairMain.setRotationPoint(0.0f, -11.5f, -3.0f);
        this.HairMain.addBox(-7.5f, 0.0f, 0.0f, 15, 12, 10, 0.0f);
        this.HatEyeL = new ModelRenderer(this, 22, 28);
        this.HatEyeL.setRotationPoint(9.6f, -6.0f, 5.3f);
        this.HatEyeL.addBox(0.0f, -3.0f, -3.0f, 1, 6, 6, 0.0f);
        this.setRotateAngle(this.HatEyeL, 0.08726646f, -0.05235988f, -0.05235988f);
        this.Ahoke = new ModelRenderer(this, 104, 29);
        this.Ahoke.setRotationPoint(2.0f, -4.0f, -7.6f);
        this.Ahoke.addBox(0.0f, 0.0f, -12.0f, 0, 12, 12, 0.0f);
        this.setRotateAngle(this.Ahoke, -0.2617994f, 1.4835298f, -0.2617994f);
        this.Tail02 = new ModelRenderer(this, 58, 17);
        this.Tail02.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail02.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail02, 0.61086524f, -0.08726646f, 0.0f);
        this.Tail05 = new ModelRenderer(this, 53, 16);
        this.Tail05.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail05.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail05, 0.5235988f, 0.0f, 0.0f);
        this.ArmRight01 = new ModelRenderer(this, 0, 92);
        this.ArmRight01.mirror = true;
        this.ArmRight01.setRotationPoint(-4.0f, 3.0f, -6.0f);
        this.ArmRight01.addBox(-2.5f, 0.0f, -2.5f, 5, 8, 5, 0.0f);
        this.setRotateAngle(this.ArmRight01, 0.13962634f, 0.0f, -0.20943952f);
        this.TailBase = new ModelRenderer(this, 57, 21);
        this.TailBase.setRotationPoint(0.0f, 7.0f, -2.0f);
        this.TailBase.addBox(-4.0f, -2.0f, 0.0f, 8, 5, 7, 0.0f);
        this.Tail07 = new ModelRenderer(this, 86, 0);
        this.Tail07.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail07.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail07, 0.17453292f, 0.08726646f, 0.0f);
        this.TailHead01 = new ModelRenderer(this, 40, 0);
        this.TailHead01.setRotationPoint(0.0f, -1.8f, 3.5f);
        this.TailHead01.addBox(-4.5f, 0.0f, 0.0f, 9, 6, 10, 0.0f);
        this.setRotateAngle(this.TailHead01, -0.17453292f, 0.0f, 0.0f);
        this.Ear01 = new ModelRenderer(this, 0, 26);
        this.Ear01.setRotationPoint(4.2f, -11.0f, 6.8f);
        this.Ear01.addBox(-2.0f, 0.0f, -7.0f, 4, 7, 7, 0.0f);
        this.setRotateAngle(this.Ear01, -0.83775806f, -0.12217305f, 0.17453292f);
        this.Tail06_1 = new ModelRenderer(this, 85, 2);
        this.Tail06_1.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail06_1.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail06_1, 0.08726646f, 0.2617994f, 0.0f);
        this.TailJaw01 = new ModelRenderer(this, 90, 18);
        this.TailJaw01.setRotationPoint(0.0f, -0.7f, 3.3f);
        this.TailJaw01.addBox(-4.5f, -4.0f, 0.0f, 9, 4, 10, 0.0f);
        this.setRotateAngle(this.TailJaw01, 0.2617994f, 0.0f, 0.0f);
        this.Hair03b = new ModelRenderer(this, 90, 32);
        this.Hair03b.setRotationPoint(-6.4f, 9.8f, 5.5f);
        this.Hair03b.addBox(-1.5f, 0.0f, -3.0f, 3, 12, 4, 0.0f);
        this.setRotateAngle(this.Hair03b, -0.20943952f, 0.13962634f, -0.06981317f);
        this.Tail08 = new ModelRenderer(this, 83, 0);
        this.Tail08.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail08.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail08, 0.08726646f, 0.2617994f, 0.0f);
        this.Tail07_1 = new ModelRenderer(this, 86, 0);
        this.Tail07_1.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail07_1.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail07_1, -0.34906584f, 0.34906584f, 0.0f);
        this.Horn02 = new ModelRenderer(this, 40, 39);
        this.Horn02.setRotationPoint(3.3f, -7.5f, -6.0f);
        this.Horn02.addBox(-1.5f, -1.5f, -6.0f, 3, 3, 6, 0.0f);
        this.setRotateAngle(this.Horn02, -0.87266463f, -0.43633232f, 0.2617994f);
        this.BodyMain = new ModelRenderer(this, 0, 93);
        this.BodyMain.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.BodyMain.addBox(-5.5f, -4.5f, -12.0f, 11, 10, 24, 0.0f);
        this.LegRight02 = new ModelRenderer(this, 66, 105);
        this.LegRight02.mirror = true;
        this.LegRight02.setRotationPoint(0.0f, 8.0f, -2.5f);
        this.LegRight02.addBox(-2.5f, 0.0f, 0.0f, 5, 7, 5, 0.0f);
        this.Tail09 = new ModelRenderer(this, 96, 0);
        this.Tail09.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail09.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail09, -0.08726646f, 0.43633232f, 0.0f);
        this.Hair = new ModelRenderer(this, 50, 40);
        this.Hair.setRotationPoint(0.0f, -4.0f, 0.0f);
        this.Hair.addBox(-8.0f, -8.0f, -7.2f, 16, 17, 8, 0.0f);
        this.TailC02_1 = new ModelRenderer(this, 100, 8);
        this.TailC02_1.setRotationPoint(-2.0f, 4.5f, 9.5f);
        this.TailC02_1.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 8, 0.0f);
        this.setRotateAngle(this.TailC02_1, -0.13962634f, (float)(-Math.PI) / 90, 0.0f);
        this.Head = new ModelRenderer(this, 44, 65);
        this.Head.setRotationPoint(0.0f, -6.0f, -13.0f);
        this.Head.addBox(-7.0f, -11.0f, -6.5f, 14, 14, 13, 0.0f);
        this.ArmLeft01 = new ModelRenderer(this, 0, 92);
        this.ArmLeft01.setRotationPoint(4.0f, 3.0f, -6.0f);
        this.ArmLeft01.addBox(-2.5f, 0.0f, -2.5f, 5, 8, 5, 0.0f);
        this.setRotateAngle(this.ArmLeft01, -0.13962634f, 0.0f, 0.20943952f);
        this.Band01 = new ModelRenderer(this, 40, 39);
        this.Band01.setRotationPoint(4.5f, 1.7f, -12.0f);
        this.Band01.addBox(-0.5f, 0.0f, 0.0f, 1, 6, 0, 0.0f);
        this.setRotateAngle(this.Band01, -0.17453292f, 0.0f, 0.0f);
        this.TailJaw01_1 = new ModelRenderer(this, 90, 18);
        this.TailJaw01_1.setRotationPoint(0.0f, -0.7f, 2.7f);
        this.TailJaw01_1.addBox(-4.5f, -4.0f, 0.0f, 9, 4, 10, 0.0f);
        this.setRotateAngle(this.TailJaw01_1, 0.17453292f, 0.0f, 0.0f);
        this.HatBase = new ModelRenderer(this, 0, 0);
        this.HatBase.setRotationPoint(0.0f, -3.1f, 5.8f);
        this.HatBase.addBox(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.Tail01 = new ModelRenderer(this, 58, 16);
        this.Tail01.setRotationPoint(1.5f, 0.0f, 3.0f);
        this.Tail01.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail01, 0.2617994f, 1.5707964f, 0.0f);
        this.TailC01 = new ModelRenderer(this, 100, 8);
        this.TailC01.setRotationPoint(2.0f, 4.5f, 9.5f);
        this.TailC01.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 8, 0.0f);
        this.setRotateAngle(this.TailC01, -0.13962634f, (float)Math.PI / 90, 0.0f);
        this.Tail04 = new ModelRenderer(this, 54, 19);
        this.Tail04.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail04.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail04, 0.5235988f, 0.0f, 0.0f);
        this.Tail04_1 = new ModelRenderer(this, 53, 18);
        this.Tail04_1.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail04_1.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail04_1, 0.34906584f, 0.43633232f, 0.0f);
        this.Tail01_1 = new ModelRenderer(this, 54, 16);
        this.Tail01_1.setRotationPoint(-1.5f, 0.0f, 3.0f);
        this.Tail01_1.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail01_1, 0.6981317f, -1.5707964f, 0.0f);
        this.ArmLeft02 = new ModelRenderer(this, 0, 105);
        this.ArmLeft02.setRotationPoint(2.5f, 8.0f, 2.5f);
        this.ArmLeft02.addBox(-5.0f, 0.0f, -5.0f, 5, 7, 5, 0.0f);
        this.HatR = new ModelRenderer(this, 0, 0);
        this.HatR.mirror = true;
        this.HatR.setRotationPoint(1.3f, 2.1f, -2.9f);
        this.HatR.addBox(-10.0f, -14.0f, -1.0f, 10, 16, 10, 0.0f);
        this.setRotateAngle(this.HatR, 0.5235988f, -0.08726646f, -0.06981317f);
        this.Tail03_1 = new ModelRenderer(this, 58, 16);
        this.Tail03_1.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.Tail03_1.addBox(-4.0f, -3.5f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.Tail03_1, 0.43633232f, 0.34906584f, 0.0f);
        this.ArmRight02 = new ModelRenderer(this, 0, 105);
        this.ArmRight02.mirror = true;
        this.ArmRight02.setRotationPoint(-2.5f, 8.0f, 2.5f);
        this.ArmRight02.addBox(0.0f, 0.0f, -5.0f, 5, 7, 5, 0.0f);
        this.Ear02 = new ModelRenderer(this, 0, 26);
        this.Ear02.mirror = true;
        this.Ear02.setRotationPoint(-4.2f, -11.0f, 6.8f);
        this.Ear02.addBox(-2.0f, 0.0f, -7.0f, 4, 7, 7, 0.0f);
        this.setRotateAngle(this.Ear02, -0.83775806f, 0.12217305f, -0.17453292f);
        this.TailC01_1 = new ModelRenderer(this, 100, 8);
        this.TailC01_1.setRotationPoint(2.0f, 4.5f, 9.5f);
        this.TailC01_1.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 8, 0.0f);
        this.setRotateAngle(this.TailC01_1, -0.13962634f, (float)Math.PI / 90, 0.0f);
        this.TailC02 = new ModelRenderer(this, 100, 8);
        this.TailC02.setRotationPoint(-2.0f, 4.5f, 9.5f);
        this.TailC02.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 8, 0.0f);
        this.setRotateAngle(this.TailC02, -0.13962634f, (float)(-Math.PI) / 90, 0.0f);
        this.Horn01 = new ModelRenderer(this, 40, 39);
        this.Horn01.setRotationPoint(-3.0f, -7.5f, -6.0f);
        this.Horn01.addBox(-1.5f, -1.5f, -6.0f, 3, 3, 6, 0.0f);
        this.setRotateAngle(this.Horn01, -0.87266463f, 0.43633232f, -0.5235988f);
        this.HairMain.addChild(this.Hair01);
        this.HairMain.addChild(this.Hair03a);
        this.LegLeft01.addChild(this.LegLeft02);
        this.BodyMain.addChild(this.Neck);
        this.Horn02.addChild(this.Horn03);
        this.HatR.addChild(this.HatEyeR);
        this.Tail09_1.addChild(this.TailHead01_1);
        this.Tail02.addChild(this.Tail03);
        this.HatBase.addChild(this.HatL);
        this.Tail04_1.addChild(this.Tail05_1);
        this.Tail05.addChild(this.Tail06);
        this.Tail08_1.addChild(this.Tail09_1);
        this.Tail07_1.addChild(this.Tail08_1);
        this.BodyMain.addChild(this.LegRight01);
        this.Tail01_1.addChild(this.Tail02_1);
        this.HairMain.addChild(this.Hair02b);
        this.BodyMain.addChild(this.LegLeft01);
        this.BodyMain.addChild(this.Band02);
        this.HairMain.addChild(this.Hair02a);
        this.Head.addChild(this.HairMain);
        this.HatL.addChild(this.HatEyeL);
        this.Hair.addChild(this.Ahoke);
        this.Tail01.addChild(this.Tail02);
        this.Tail04.addChild(this.Tail05);
        this.BodyMain.addChild(this.ArmRight01);
        this.BodyMain.addChild(this.TailBase);
        this.Tail06.addChild(this.Tail07);
        this.Tail09.addChild(this.TailHead01);
        this.Head.addChild(this.Ear01);
        this.Tail05_1.addChild(this.Tail06_1);
        this.Tail09.addChild(this.TailJaw01);
        this.HairMain.addChild(this.Hair03b);
        this.Tail07.addChild(this.Tail08);
        this.Tail06_1.addChild(this.Tail07_1);
        this.Head.addChild(this.Horn02);
        this.LegRight01.addChild(this.LegRight02);
        this.Tail08.addChild(this.Tail09);
        this.Head.addChild(this.Hair);
        this.TailHead01_1.addChild(this.TailC02_1);
        this.BodyMain.addChild(this.Head);
        this.BodyMain.addChild(this.ArmLeft01);
        this.BodyMain.addChild(this.Band01);
        this.Tail09_1.addChild(this.TailJaw01_1);
        this.Head.addChild(this.HatBase);
        this.TailBase.addChild(this.Tail01);
        this.TailHead01.addChild(this.TailC01);
        this.Tail03.addChild(this.Tail04);
        this.Tail03_1.addChild(this.Tail04_1);
        this.TailBase.addChild(this.Tail01_1);
        this.ArmLeft01.addChild(this.ArmLeft02);
        this.HatBase.addChild(this.HatR);
        this.Tail02_1.addChild(this.Tail03_1);
        this.ArmRight01.addChild(this.ArmRight02);
        this.Head.addChild(this.Ear02);
        this.TailHead01_1.addChild(this.TailC01_1);
        this.TailHead01.addChild(this.TailC02);
        this.Head.addChild(this.Horn01);
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
        int state = ent.getStateEmotion(0);
        boolean ft1 = EmotionHelper.checkModelState(0, state);
        boolean ft2 = EmotionHelper.checkModelState(1, state);
        this.TailBase.isHidden = !ft1 && !ft2;
        boolean fh1 = EmotionHelper.checkModelState(2, state);
        boolean fh2 = EmotionHelper.checkModelState(3, state);
        boolean fh3 = EmotionHelper.checkModelState(4, state);
        if (fh2 || fh3) {
            this.HatBase.isHidden = false;
            this.Hair01.isHidden = true;
            this.Horn01.isHidden = false;
            this.Horn02.isHidden = false;
            this.Ear01.isHidden = false;
            this.Ear02.isHidden = false;
        } else if (fh1) {
            this.HatBase.isHidden = false;
            this.Hair01.isHidden = true;
            this.Horn01.isHidden = true;
            this.Horn02.isHidden = true;
            this.Ear01.isHidden = true;
            this.Ear02.isHidden = true;
        } else {
            this.HatBase.isHidden = true;
            this.Hair01.isHidden = false;
            this.Horn01.isHidden = false;
            this.Horn02.isHidden = false;
            this.Ear01.isHidden = false;
            this.Ear02.isHidden = false;
        }
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
        this.Ahoke.rotateAngleX = -0.2618f;
        this.BodyMain.rotateAngleX = 0.0f;
        this.BodyMain.rotateAngleY = 0.0f;
        this.BodyMain.rotateAngleZ = -1.4835f;
        this.Head.offsetY = 0.0f;
        this.GlowHead.offsetY = 0.0f;
        this.ArmLeft01.rotateAngleX = -0.4f;
        this.ArmLeft01.rotateAngleZ = 0.4537f;
        this.ArmLeft01.offsetZ = 0.0f;
        this.ArmLeft02.rotateAngleZ = 0.0f;
        this.ArmRight01.rotateAngleX = -0.8f;
        this.ArmRight01.rotateAngleZ = -0.05f;
        this.ArmRight01.offsetZ = 0.0f;
        this.ArmRight02.rotateAngleZ = 0.0f;
        this.LegLeft01.rotateAngleX = 0.5f;
        this.LegLeft01.rotateAngleY = 0.0f;
        this.LegLeft01.rotateAngleZ = 0.4537f;
        this.LegLeft02.rotateAngleX = 0.0f;
        this.LegLeft02.rotateAngleZ = 0.0f;
        this.LegRight01.rotateAngleX = 0.8f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleZ = -0.05f;
        this.LegRight02.rotateAngleX = 0.0f;
        this.LegRight02.rotateAngleZ = 0.0f;
        int state = ent.getStateEmotion(0);
        boolean fh1 = EmotionHelper.checkModelState(2, state);
        boolean fh2 = EmotionHelper.checkModelState(3, state);
        boolean fh3 = EmotionHelper.checkModelState(4, state);
        boolean fh4 = fh1 && fh2;
        if (fh4) {
            this.HatBase.rotateAngleX = -1.8f;
            this.HatBase.offsetY = 0.6f;
            this.HatBase.offsetZ = 0.07f;
        } else if (fh1) {
            this.HatBase.rotateAngleX = 1.37f;
            this.HatBase.offsetY = -0.45f;
            this.HatBase.offsetZ = -0.2f;
        } else if (fh3) {
            this.HatBase.rotateAngleX = -0.85f;
            this.HatBase.offsetY = 0.33f;
            this.HatBase.offsetZ = 0.07f;
        } else {
            this.HatBase.rotateAngleX = 0.0f;
            this.HatBase.offsetY = 0.0f;
            this.HatBase.offsetZ = 0.0f;
        }
        this.TailHead01.rotateAngleX = -0.17f;
        this.TailJaw01.rotateAngleX = 0.26f;
        this.TailHead01_1.rotateAngleX = 0.0f;
        this.TailJaw01_1.rotateAngleX = 0.2f;
        this.TailBase.isHidden = false;
        this.Tail01.rotateAngleX = -1.4f;
        this.Tail01.rotateAngleY = 1.57f;
        this.Tail02.rotateAngleX = -0.3f;
        this.Tail02.rotateAngleY = 0.2f;
        this.Tail03.rotateAngleX = -0.3f;
        this.Tail03.rotateAngleY = 0.3f;
        this.Tail04.rotateAngleX = 0.2f;
        this.Tail04.rotateAngleY = 0.4f;
        this.Tail05.rotateAngleX = 0.1f;
        this.Tail05.rotateAngleY = 0.5f;
        this.Tail06.rotateAngleX = -0.1f;
        this.Tail06.rotateAngleY = 0.4f;
        this.Tail07.rotateAngleX = -0.1f;
        this.Tail07.rotateAngleY = 0.3f;
        this.Tail08.rotateAngleX = 0.1f;
        this.Tail08.rotateAngleY = 0.2f;
        this.Tail09.rotateAngleX = 0.0f;
        this.Tail09.rotateAngleY = 0.1f;
        this.Tail01_1.rotateAngleX = -1.4f;
        this.Tail01_1.rotateAngleY = -1.7f;
        this.Tail02_1.rotateAngleX = -0.2f;
        this.Tail02_1.rotateAngleY = 0.2f;
        this.Tail03_1.rotateAngleX = -0.1f;
        this.Tail03_1.rotateAngleY = 0.3f;
        this.Tail04_1.rotateAngleX = 0.0f;
        this.Tail04_1.rotateAngleY = 0.4f;
        this.Tail05_1.rotateAngleX = 0.0f;
        this.Tail05_1.rotateAngleY = 0.5f;
        this.Tail06_1.rotateAngleX = -0.1f;
        this.Tail06_1.rotateAngleY = 0.4f;
        this.Tail07_1.rotateAngleX = -0.1f;
        this.Tail07_1.rotateAngleY = 0.3f;
        this.Tail08_1.rotateAngleX = 0.2f;
        this.Tail08_1.rotateAngleY = 0.2f;
        this.Tail09_1.rotateAngleX = -0.2f;
        this.Tail09_1.rotateAngleY = 0.3f;
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
        int state = ent.getStateEmotion(0);
        boolean ft1 = EmotionHelper.checkModelState(0, state);
        boolean ft2 = EmotionHelper.checkModelState(1, state);
        boolean ft3 = ft1 && ft2;
        boolean fh1 = EmotionHelper.checkModelState(2, state);
        boolean fh2 = EmotionHelper.checkModelState(3, state);
        boolean fh3 = EmotionHelper.checkModelState(4, state);
        boolean fh4 = fh1 && fh2;
        if (ent.getShipDepth(0) > 0.0) {
            GlStateManager.translate(0.0f, angleX * 0.05f + 0.025f, 0.0f);
        }
        addk1 = angleAdd1 * 0.35f - 0.14f;
        addk2 = angleAdd2 * 0.35f + 0.14f;
        this.ArmRight01.rotateAngleX = addk1;
        this.ArmLeft01.rotateAngleX = addk2;
        this.Head.rotateAngleX = f4 * 0.014f;
        this.Head.rotateAngleY = f3 * 0.01f;
        this.Ahoke.rotateAngleX = angleX * 0.05f - 0.2618f;
        this.BodyMain.rotateAngleX = 0.0f;
        this.BodyMain.rotateAngleY = 0.0f;
        this.BodyMain.rotateAngleZ = 0.0f;
        this.Head.offsetY = 0.0f;
        this.GlowHead.offsetY = 0.0f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = 0.21f;
        this.ArmLeft01.offsetZ = 0.0f;
        this.ArmLeft02.rotateAngleZ = 0.0f;
        this.ArmRight01.rotateAngleY = 0.0f;
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
        if (fh4) {
            this.HatBase.rotateAngleX = -1.8f;
            this.HatBase.offsetY = 0.4f;
            this.HatBase.offsetZ = 0.07f;
        } else if (fh1) {
            this.HatBase.rotateAngleX = 1.37f;
            this.HatBase.offsetY = -0.45f;
            this.HatBase.offsetZ = -0.2f;
        } else if (fh3) {
            this.HatBase.rotateAngleX = -0.85f;
            this.HatBase.offsetY = 0.33f;
            this.HatBase.offsetZ = 0.07f;
        } else {
            this.HatBase.rotateAngleX = 0.0f;
            this.HatBase.offsetY = 0.0f;
            this.HatBase.offsetZ = 0.0f;
        }
        float[] cosf2 = new float[9];
        for (int i = 0; i < 9; ++i) {
            cosf2[i] = MathHelper.cos(f2 * 0.1f + f * 0.25f + 0.8f * i);
        }
        this.TailHead01.rotateAngleX = -angleX * 0.075f - 0.1f;
        this.TailJaw01.rotateAngleX = angleX * 0.1f + 0.18f;
        this.TailHead01_1.rotateAngleX = -angleX2 * 0.12f - 0.1f;
        this.TailJaw01_1.rotateAngleX = angleX2 * 0.15f + 0.26f;
        this.TailC01.rotateAngleX = angleX1 * 0.3f - 0.2f;
        this.TailC02.rotateAngleX = angleX2 * 0.3f - 0.2f;
        this.TailC01_1.rotateAngleX = angleX1 * 0.3f - 0.2f;
        this.TailC02_1.rotateAngleX = angleX2 * 0.3f - 0.2f;
        if (ft3) {
            this.TailBase.offsetY = -0.15f;
            this.TailBase.offsetZ = 0.0f;
            this.Tail01.rotateAngleX = 0.26f;
            this.Tail01.rotateAngleY = 1.7f + cosf2[0] * 0.015f;
            this.Tail02.rotateAngleX = 0.61f;
            this.Tail02.rotateAngleY = -0.09f + cosf2[1] * 0.02f;
            this.Tail03.rotateAngleX = 0.61f;
            this.Tail03.rotateAngleY = -0.09f + cosf2[2] * 0.025f;
            this.Tail04.rotateAngleX = 0.52f;
            this.Tail04.rotateAngleY = 0.0f + cosf2[3] * 0.03f;
            this.Tail05.rotateAngleX = 0.52f;
            this.Tail05.rotateAngleY = 0.0f + cosf2[4] * 0.04f;
            this.Tail06.rotateAngleX = 0.35f;
            this.Tail06.rotateAngleY = 0.0f + cosf2[5] * 0.05f;
            this.Tail07.rotateAngleX = 0.17f;
            this.Tail07.rotateAngleY = 0.1f + cosf2[6] * 0.06f;
            this.Tail08.rotateAngleX = 0.09f;
            this.Tail08.rotateAngleY = 0.1f + cosf2[7] * 0.08f;
            this.Tail09.rotateAngleX = -0.09f;
            this.Tail09.rotateAngleY = 0.5f + cosf2[8] * 0.15f;
            this.Tail01_1.rotateAngleX = 0.7f;
            this.Tail01_1.rotateAngleY = -1.57f + cosf2[0] * 0.02f;
            this.Tail02_1.rotateAngleX = 0.35f;
            this.Tail02_1.rotateAngleY = 0.26f + cosf2[1] * 0.03f;
            this.Tail03_1.rotateAngleX = 0.44f;
            this.Tail03_1.rotateAngleY = 0.35f + cosf2[2] * 0.04f;
            this.Tail04_1.rotateAngleX = 0.35f;
            this.Tail04_1.rotateAngleY = 0.44f + cosf2[3] * 0.05f;
            this.Tail05_1.rotateAngleX = 0.52f;
            this.Tail05_1.rotateAngleY = 0.35f + cosf2[4] * 0.06f;
            this.Tail06_1.rotateAngleX = 0.09f;
            this.Tail06_1.rotateAngleY = 0.26f + cosf2[5] * 0.07f;
            this.Tail07_1.rotateAngleX = -0.35f;
            this.Tail07_1.rotateAngleY = 0.35f + cosf2[6] * 0.08f;
            this.Tail08_1.rotateAngleX = -0.52f;
            this.Tail08_1.rotateAngleY = 0.35f + cosf2[7] * 0.09f;
            this.Tail09_1.rotateAngleX = -0.09f;
            this.Tail09_1.rotateAngleY = 0.44f + cosf2[8] * 0.12f;
        } else if (ft1) {
            this.TailBase.offsetY = -0.15f;
            this.TailBase.offsetZ = 0.0f;
            this.Tail01.rotateAngleX = -0.17f + cosf2[0] * 0.03f;
            this.Tail01.rotateAngleY = 1.3f + cosf2[0] * 0.03f;
            this.Tail02.rotateAngleX = 0.26f + cosf2[1] * 0.03f;
            this.Tail02.rotateAngleY = -0.52f + cosf2[1] * 0.03f;
            this.Tail03.rotateAngleX = 0.35f + cosf2[2] * 0.03f;
            this.Tail03.rotateAngleY = -0.52f + cosf2[2] * 0.03f;
            this.Tail04.rotateAngleX = 0.52f + cosf2[3] * 0.03f;
            this.Tail04.rotateAngleY = -0.44f + cosf2[3] * 0.03f;
            this.Tail05.rotateAngleX = 0.52f + cosf2[4] * 0.04f;
            this.Tail05.rotateAngleY = -0.17f + cosf2[4] * 0.04f;
            this.Tail06.rotateAngleX = 0.35f + cosf2[5] * 0.05f;
            this.Tail06.rotateAngleY = 0.35f + cosf2[5] * 0.05f;
            this.Tail07.rotateAngleX = 0.44f + cosf2[6] * 0.06f;
            this.Tail07.rotateAngleY = 0.17f + cosf2[6] * 0.06f;
            this.Tail08.rotateAngleX = 0.52f + cosf2[7] * 0.08f;
            this.Tail08.rotateAngleY = 0.17f + cosf2[7] * 0.08f;
            this.Tail09.rotateAngleX = 0.52f + cosf2[8] * 0.15f;
            this.Tail09.rotateAngleY = 0.17f + cosf2[8] * 0.15f;
            this.Tail01_1.rotateAngleX = -0.17f + cosf2[0] * 0.03f;
            this.Tail01_1.rotateAngleY = -1.3f + cosf2[0] * 0.03f;
            this.Tail02_1.rotateAngleX = 0.26f + cosf2[1] * 0.03f;
            this.Tail02_1.rotateAngleY = 0.52f + cosf2[1] * 0.03f;
            this.Tail03_1.rotateAngleX = 0.35f + cosf2[2] * 0.03f;
            this.Tail03_1.rotateAngleY = 0.52f + cosf2[2] * 0.03f;
            this.Tail04_1.rotateAngleX = 0.52f + cosf2[3] * 0.03f;
            this.Tail04_1.rotateAngleY = 0.44f + cosf2[3] * 0.03f;
            this.Tail05_1.rotateAngleX = 0.52f + cosf2[4] * 0.04f;
            this.Tail05_1.rotateAngleY = 0.17f + cosf2[4] * 0.04f;
            this.Tail06_1.rotateAngleX = 0.35f + cosf2[5] * 0.05f;
            this.Tail06_1.rotateAngleY = -0.35f + cosf2[5] * 0.05f;
            this.Tail07_1.rotateAngleX = 0.44f + cosf2[6] * 0.06f;
            this.Tail07_1.rotateAngleY = -0.17f + cosf2[6] * 0.06f;
            this.Tail08_1.rotateAngleX = 0.52f + cosf2[7] * 0.08f;
            this.Tail08_1.rotateAngleY = -0.17f + cosf2[7] * 0.08f;
            this.Tail09_1.rotateAngleX = 0.52f + cosf2[8] * 0.15f;
            this.Tail09_1.rotateAngleY = -0.17f + cosf2[8] * 0.15f;
        } else if (ft2) {
            this.TailBase.offsetY = -0.54f;
            this.TailBase.offsetZ = 0.86f;
            this.Tail01.rotateAngleX = -0.17f + cosf2[0] * 0.03f;
            this.Tail01.rotateAngleY = 1.3f + cosf2[0] * 0.03f;
            this.Tail02.rotateAngleX = 0.26f + cosf2[1] * 0.03f;
            this.Tail02.rotateAngleY = -0.52f + cosf2[1] * 0.03f;
            this.Tail03.rotateAngleX = 0.35f + cosf2[2] * 0.03f;
            this.Tail03.rotateAngleY = -0.52f + cosf2[2] * 0.03f;
            this.Tail04.rotateAngleX = 0.52f + cosf2[3] * 0.03f;
            this.Tail04.rotateAngleY = -0.44f + cosf2[3] * 0.03f;
            this.Tail05.rotateAngleX = 0.52f + cosf2[4] * 0.04f;
            this.Tail05.rotateAngleY = -0.17f + cosf2[4] * 0.04f;
            this.Tail06.rotateAngleX = 0.35f + cosf2[5] * 0.05f;
            this.Tail06.rotateAngleY = 0.35f + cosf2[5] * 0.05f;
            this.Tail07.rotateAngleX = 0.44f + cosf2[6] * 0.06f;
            this.Tail07.rotateAngleY = 0.17f + cosf2[6] * 0.06f;
            this.Tail08.rotateAngleX = 0.52f + cosf2[7] * 0.08f;
            this.Tail08.rotateAngleY = 0.17f + cosf2[7] * 0.08f;
            this.Tail09.rotateAngleX = 0.52f + cosf2[8] * 0.15f;
            this.Tail09.rotateAngleY = 0.17f + cosf2[8] * 0.15f;
            this.Tail01_1.rotateAngleX = -0.17f + cosf2[0] * 0.03f;
            this.Tail01_1.rotateAngleY = -1.3f + cosf2[0] * 0.03f;
            this.Tail02_1.rotateAngleX = 0.26f + cosf2[1] * 0.03f;
            this.Tail02_1.rotateAngleY = 0.52f + cosf2[1] * 0.03f;
            this.Tail03_1.rotateAngleX = 0.35f + cosf2[2] * 0.03f;
            this.Tail03_1.rotateAngleY = 0.52f + cosf2[2] * 0.03f;
            this.Tail04_1.rotateAngleX = 0.52f + cosf2[3] * 0.03f;
            this.Tail04_1.rotateAngleY = 0.44f + cosf2[3] * 0.03f;
            this.Tail05_1.rotateAngleX = 0.52f + cosf2[4] * 0.04f;
            this.Tail05_1.rotateAngleY = 0.17f + cosf2[4] * 0.04f;
            this.Tail06_1.rotateAngleX = 0.35f + cosf2[5] * 0.05f;
            this.Tail06_1.rotateAngleY = -0.35f + cosf2[5] * 0.05f;
            this.Tail07_1.rotateAngleX = 0.44f + cosf2[6] * 0.06f;
            this.Tail07_1.rotateAngleY = -0.17f + cosf2[6] * 0.06f;
            this.Tail08_1.rotateAngleX = 0.52f + cosf2[7] * 0.08f;
            this.Tail08_1.rotateAngleY = -0.17f + cosf2[7] * 0.08f;
            this.Tail09_1.rotateAngleX = 0.52f + cosf2[8] * 0.15f;
            this.Tail09_1.rotateAngleY = -0.17f + cosf2[8] * 0.15f;
        }
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
                if (fh4) {
                    this.HatBase.rotateAngleX = -1.8f;
                    this.HatBase.offsetY = 0.3f;
                    this.HatBase.offsetZ = 0.07f;
                } else if (fh1) {
                    this.HatBase.rotateAngleX = 1.37f;
                    this.HatBase.offsetY = -0.45f;
                    this.HatBase.offsetZ = -0.2f;
                } else if (fh3) {
                    this.HatBase.rotateAngleX = -0.85f;
                    this.HatBase.offsetY = 0.1f;
                    this.HatBase.offsetZ = 0.07f;
                } else {
                    this.HatBase.rotateAngleX = 0.0f;
                    this.HatBase.offsetY = 0.0f;
                    this.HatBase.offsetZ = 0.0f;
                }
                GlStateManager.translate(0.0f, 0.21f, 0.0f);
                this.Head.rotateAngleX -= 0.2f;
                this.Head.rotateAngleZ -= 0.09f;
                this.BodyMain.rotateAngleZ = 0.09f;
                this.ArmLeft01.rotateAngleX = -1.31f;
                this.ArmLeft01.rotateAngleY = 0.17f;
                this.ArmLeft01.rotateAngleZ = 0.0f;
                this.ArmLeft01.offsetZ = 0.0f;
                this.ArmLeft02.rotateAngleZ = 0.0f;
                this.ArmRight01.rotateAngleX = -1.22f;
                this.ArmRight01.rotateAngleY = 1.05f;
                this.ArmRight01.rotateAngleZ = 0.0f;
                this.ArmRight01.offsetZ = 0.0f;
                this.ArmRight02.rotateAngleZ = 0.0f;
                addk1 = 1.31f;
                addk2 = 1.22f;
                this.LegLeft01.rotateAngleY = -0.7f;
                this.LegLeft01.rotateAngleZ = 0.0f;
                this.LegRight01.rotateAngleY = -0.87f;
                this.LegRight01.rotateAngleZ = 0.0f;
            } else if (ent.getStateEmotion(7) == 4) {
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
                if (fh4) {
                    this.HatBase.rotateAngleX = -1.8f;
                    this.HatBase.offsetY = 0.6f;
                    this.HatBase.offsetZ = -0.3f;
                } else if (fh1) {
                    this.HatBase.rotateAngleX = 1.37f;
                    this.HatBase.offsetY = -0.45f;
                    this.HatBase.offsetZ = -0.2f;
                } else if (fh3) {
                    this.HatBase.rotateAngleX = -0.85f;
                    this.HatBase.offsetY = 0.6f;
                    this.HatBase.offsetZ = 0.07f;
                } else {
                    this.HatBase.rotateAngleX = 0.0f;
                    this.HatBase.offsetY = 0.0f;
                    this.HatBase.offsetZ = 0.0f;
                }
            } else {
                if (fh4) {
                    this.HatBase.rotateAngleX = -1.8f;
                    this.HatBase.offsetY = 0.2f;
                    this.HatBase.offsetZ = 0.07f;
                } else if (fh1) {
                    this.HatBase.rotateAngleX = 1.37f;
                    this.HatBase.offsetY = -0.45f;
                    this.HatBase.offsetZ = -0.2f;
                } else if (fh3) {
                    this.HatBase.rotateAngleX = -0.85f;
                    this.HatBase.offsetY = 0.0f;
                    this.HatBase.offsetZ = 0.07f;
                } else {
                    this.HatBase.rotateAngleX = 0.0f;
                    this.HatBase.offsetY = 0.0f;
                    this.HatBase.offsetZ = 0.0f;
                }
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
        if (ent.getAttackTick() > 30) {
            this.TailHead01.rotateAngleX = -0.6f;
            this.TailJaw01.rotateAngleX = 0.5f;
            this.TailHead01_1.rotateAngleX = -0.6f;
            this.TailJaw01_1.rotateAngleX = 0.5f;
            this.TailC01.rotateAngleX = -0.1f;
            this.TailC02.rotateAngleX = -0.1f;
            this.TailC01_1.rotateAngleX = -0.1f;
            this.TailC02_1.rotateAngleX = -0.1f;
            this.Tail01.rotateAngleX = 0.2f;
            this.Tail01.rotateAngleY = 1.2f;
            this.Tail02.rotateAngleX = 0.4f;
            this.Tail02.rotateAngleY = -0.5f;
            this.Tail03.rotateAngleX = 0.4f;
            this.Tail03.rotateAngleY = -0.32f;
            this.Tail04.rotateAngleX = 0.4f;
            this.Tail04.rotateAngleY = 0.4f;
            this.Tail05.rotateAngleX = 0.2f;
            this.Tail05.rotateAngleY = 0.4f;
            this.Tail06.rotateAngleX = 0.3f;
            this.Tail06.rotateAngleY = 0.4f;
            this.Tail07.rotateAngleX = 0.2f;
            this.Tail07.rotateAngleY = 0.4f;
            this.Tail08.rotateAngleX = 0.1f;
            this.Tail08.rotateAngleY = 0.3f;
            this.Tail09.rotateAngleX = 0.1f;
            this.Tail09.rotateAngleY = 0.3f;
            this.Tail01_1.rotateAngleX = -0.17f;
            this.Tail01_1.rotateAngleY = -1.5f;
            this.Tail02_1.rotateAngleX = 0.26f;
            this.Tail02_1.rotateAngleY = 0.52f;
            this.Tail03_1.rotateAngleX = 0.35f;
            this.Tail03_1.rotateAngleY = 0.52f;
            this.Tail04_1.rotateAngleX = 0.52f;
            this.Tail04_1.rotateAngleY = 0.3f;
            this.Tail05_1.rotateAngleX = 0.52f;
            this.Tail05_1.rotateAngleY = 0.17f;
            this.Tail06_1.rotateAngleX = 0.35f;
            this.Tail06_1.rotateAngleY = -0.35f;
            this.Tail07_1.rotateAngleX = 0.2f;
            this.Tail07_1.rotateAngleY = -0.17f;
            this.Tail08_1.rotateAngleX = 0.3f;
            this.Tail08_1.rotateAngleY = -0.17f;
            this.Tail09_1.rotateAngleX = 0.5f;
            this.Tail09_1.rotateAngleY = -0.17f;
            float ptick = ent.getAttackTick() + (1.0f - f2 + (int)f2);
            if (ent.getAttackTick() > 47) {
                this.TailHead01.rotateAngleX = (ptick - 50.0f) * 0.3f - 0.1f;
                this.TailJaw01.rotateAngleX = (50.0f - ptick) * 0.3f + 0.1f;
            } else if (ent.getAttackTick() > 39) {
                this.TailHead01.rotateAngleX = -0.7f + (47.0f - ptick) * 0.06f;
                this.TailJaw01.rotateAngleX = 0.7f - (47.0f - ptick) * 0.06f;
            } else {
                this.TailHead01.rotateAngleX = -0.25f;
                this.TailJaw01.rotateAngleX = 0.25f;
            }
            this.TailHead01_1.rotateAngleX = this.TailHead01.rotateAngleX;
            this.TailJaw01_1.rotateAngleX = this.TailJaw01.rotateAngleX;
        }
        if ((f6 = ent.getSwingTime(f2 - (int)f2)) != 0.0f) {
            float f7 = MathHelper.sin(f6 * f6 * (float)Math.PI);
            float f8 = MathHelper.sin(MathHelper.sqrt(f6) * (float)Math.PI);
            this.ArmRight01.rotateAngleX = -0.6f - f8 * 80.0f * ((float)Math.PI / 180);
            this.ArmRight01.rotateAngleY = 0.0f - f7 * 20.0f * ((float)Math.PI / 180) + 0.2f;
            this.ArmRight01.rotateAngleZ = 0.2f - -f8 * 20.0f * ((float)Math.PI / 180);
        }
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
