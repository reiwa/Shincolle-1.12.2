package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelBattleshipRe
extends ShipModelBaseAdv {
    private final ModelRenderer BodyMain;
    private final ModelRenderer Cloth;
    private final ModelRenderer Neck;
    private final ModelRenderer BoobR;
    private final ModelRenderer BoobL;
    private final ModelRenderer ArmLeft01;
    private final ModelRenderer ArmRight01;
    private final ModelRenderer ArmLeft02;
    private final ModelRenderer ArmRight02;
    private final ModelRenderer BagMain;
    private final ModelRenderer TailBase;
    private final ModelRenderer Butt;
    private final ModelRenderer Cloth2;
    private final ModelRenderer Head;
    private final ModelRenderer Ear01;
    private final ModelRenderer Ear02;
    private final ModelRenderer Hair;
    private final ModelRenderer Hair01;
    private final ModelRenderer HairU01;
    private final ModelRenderer Cap;
    private final ModelRenderer Cap2;
    private final ModelRenderer Ahoke;
    private final ModelRenderer BoobM;
    private final ModelRenderer PalmLeft;
    private final ModelRenderer PalmRight;
    private final ModelRenderer BagMain2;
    private final ModelRenderer BagStrap1;
    private final ModelRenderer BagStrap2;
    private final ModelRenderer Tail1;
    private final ModelRenderer TailBack0;
    private final ModelRenderer Tail2;
    private final ModelRenderer TailBack1;
    private final ModelRenderer Tail3;
    private final ModelRenderer TailBack2;
    private final ModelRenderer Tail4;
    private final ModelRenderer TailBack3;
    private final ModelRenderer Tail5;
    private final ModelRenderer TailBack4;
    private final ModelRenderer Tail6;
    private final ModelRenderer TailBack5;
    private final ModelRenderer TailHeadBase;
    private final ModelRenderer TailBack6;
    private final ModelRenderer TailJaw1;
    private final ModelRenderer TailHead1;
    private final ModelRenderer TailHeadCL1;
    private final ModelRenderer TailHeadCR1;
    private final ModelRenderer TailJawT01;
    private final ModelRenderer TailJaw2;
    private final ModelRenderer TailJaw3;
    private final ModelRenderer TailHead2;
    private final ModelRenderer TailHeadT01;
    private final ModelRenderer TailHeadC1;
    private final ModelRenderer TailHead3;
    private final ModelRenderer TailHeadC2;
    private final ModelRenderer TailHeadC3;
    private final ModelRenderer TailHeadC4;
    private final ModelRenderer TailHeadCL2;
    private final ModelRenderer TailHeadCL3;
    private final ModelRenderer TailHeadCR2;
    private final ModelRenderer TailHeadCR3;
    private final ModelRenderer LegRight;
    private final ModelRenderer LegLeft;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowNeck;
    private final ModelRenderer GlowHead;
    private final ModelRenderer GlowTailBase;
    private final ModelRenderer GlowTail1;
    private final ModelRenderer GlowTail2;
    private final ModelRenderer GlowTail3;
    private final ModelRenderer GlowTail4;
    private final ModelRenderer GlowTail5;
    private final ModelRenderer GlowTail6;
    private final ModelRenderer GlowTailHeadBase;
    private final ModelRenderer GlowTailHead1;
    private final ModelRenderer GlowTailJaw1;

    public ModelBattleshipRe() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.scale = 0.4f;
        this.offsetY = 0.0f;
        this.offsetItem = new float[]{0.04f, 0.42f, -0.04f};
        this.offsetBlock = new float[]{0.04f, 0.42f, -0.04f};
        this.setDefaultFaceModel();
        this.ArmLeft01 = new ModelRenderer(this, 0, 57);
        this.ArmLeft01.mirror = true;
        this.ArmLeft01.setRotationPoint(4.5f, -8.5f, -0.5f);
        this.ArmLeft01.addBox(0.0f, 0.0f, -3.0f, 6, 10, 6, 0.0f);
        this.setRotateAngle(this.ArmLeft01, 0.2617994f, 0.0f, -0.43633232f);
        this.ArmLeft02 = new ModelRenderer(this, 0, 57);
        this.ArmLeft02.mirror = true;
        this.ArmLeft02.setRotationPoint(6.0f, 10.0f, 3.0f);
        this.ArmLeft02.addBox(-6.0f, 0.0f, -6.0f, 6, 7, 6, 0.0f);
        this.TailHeadC1 = new ModelRenderer(this, 201, 78);
        this.TailHeadC1.setRotationPoint(0.0f, -3.5f, 0.0f);
        this.TailHeadC1.addBox(-4.5f, 0.0f, 0.0f, 9, 5, 9, 0.0f);
        this.setRotateAngle(this.TailHeadC1, 0.34906584f, 0.0f, 0.0f);
        this.Cloth2 = new ModelRenderer(this, 50, 0);
        this.Cloth2.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.Cloth2.addBox(-8.5f, 0.0f, -5.0f, 17, 12, 10, 0.0f);
        this.setRotateAngle(this.Cloth2, -0.05235988f, 0.0f, 0.0f);
        this.TailHead1 = new ModelRenderer(this, 191, 70);
        this.TailHead1.setRotationPoint(0.0f, -8.5f, 4.0f);
        this.TailHead1.addBox(-5.5f, 0.0f, -0.5f, 11, 8, 17, 0.0f);
        this.setRotateAngle(this.TailHead1, 0.13962634f, 0.0f, 0.0f);
        this.Tail5 = new ModelRenderer(this, 208, 103);
        this.Tail5.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.Tail5.addBox(-6.0f, -6.0f, 0.0f, 12, 12, 12, 0.0f);
        this.setRotateAngle(this.Tail5, -0.5235988f, 0.0f, 0.0f);
        this.BoobL = new ModelRenderer(this, 0, 80);
        this.BoobL.mirror = true;
        this.BoobL.setRotationPoint(3.5f, -9.5f, -3.0f);
        this.BoobL.addBox(-3.5f, 0.0f, 0.0f, 7, 5, 4, 0.0f);
        this.setRotateAngle(this.BoobL, -0.7853982f, -0.12217305f, -0.08726646f);
        this.PalmLeft = new ModelRenderer(this, 0, 89);
        this.PalmLeft.mirror = true;
        this.PalmLeft.setRotationPoint(-3.0f, 7.0f, -3.0f);
        this.PalmLeft.addBox(-2.5f, 0.0f, -2.5f, 5, 4, 5, 0.0f);
        this.TailHeadCR2 = new ModelRenderer(this, 207, 77);
        this.TailHeadCR2.setRotationPoint(-2.0f, 0.5f, 7.0f);
        this.TailHeadCR2.addBox(-2.0f, 0.0f, 0.0f, 2, 2, 10, 0.0f);
        this.setRotateAngle(this.TailHeadCR2, 0.08726646f, -0.17453292f, 0.0f);
        this.TailHeadC2 = new ModelRenderer(this, 207, 77);
        this.TailHeadC2.setRotationPoint(0.0f, 1.0f, 8.5f);
        this.TailHeadC2.addBox(-1.0f, 0.0f, 0.0f, 2, 2, 10, 0.0f);
        this.setRotateAngle(this.TailHeadC2, 0.13962634f, 0.0f, 0.0f);
        this.TailHeadCR3 = new ModelRenderer(this, 207, 77);
        this.TailHeadCR3.setRotationPoint(-2.0f, 3.5f, 7.0f);
        this.TailHeadCR3.addBox(-2.0f, 0.0f, 0.0f, 2, 2, 10, 0.0f);
        this.setRotateAngle(this.TailHeadCR3, -0.05235988f, -0.17453292f, 0.0f);
        this.Tail6 = new ModelRenderer(this, 208, 103);
        this.Tail6.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.Tail6.addBox(-5.5f, -6.5f, 0.0f, 11, 13, 12, 0.0f);
        this.setRotateAngle(this.Tail6, -0.5235988f, 0.0f, 0.0f);
        this.TailHeadCL1 = new ModelRenderer(this, 207, 80);
        this.TailHeadCL1.setRotationPoint(6.0f, -6.0f, 5.0f);
        this.TailHeadCL1.addBox(0.0f, 0.0f, 0.0f, 5, 6, 7, 0.0f);
        this.setRotateAngle(this.TailHeadCL1, 0.08726646f, 0.17453292f, 0.0f);
        this.BagMain = new ModelRenderer(this, 37, 23);
        this.BagMain.setRotationPoint(3.0f, -13.0f, 6.5f);
        this.BagMain.addBox(-8.0f, 0.0f, 0.0f, 14, 12, 7, 0.0f);
        this.setRotateAngle(this.BagMain, -0.2617994f, 0.0f, 0.08726646f);
        this.BagStrap1 = new ModelRenderer(this, 103, 16);
        this.BagStrap1.setRotationPoint(3.5f, 1.0f, 0.5f);
        this.BagStrap1.addBox(0.0f, 0.0f, -11.0f, 3, 10, 11, 0.0f);
        this.setRotateAngle(this.BagStrap1, 0.2617994f, -0.13962634f, -0.17453292f);
        this.BagStrap2 = new ModelRenderer(this, 82, 24);
        this.BagStrap2.setRotationPoint(-5.0f, 1.0f, 2.0f);
        this.BagStrap2.addBox(-3.0f, 0.0f, -15.0f, 3, 10, 15, 0.0f);
        this.setRotateAngle(this.BagStrap2, 0.34906584f, 0.34906584f, 0.13962634f);
        this.Ahoke = new ModelRenderer(this, 28, 90);
        this.Ahoke.setRotationPoint(0.0f, -7.0f, -4.0f);
        this.Ahoke.addBox(0.0f, -6.0f, -11.0f, 0, 11, 11, 0.0f);
        this.setRotateAngle(this.Ahoke, -0.1742f, 0.5235988f, 0.0f);
        this.Cap = new ModelRenderer(this, 204, 40);
        this.Cap.setRotationPoint(0.0f, 0.6f, 2.0f);
        this.Cap.addBox(-8.0f, -17.0f, -2.0f, 16, 17, 10, 0.0f);
        this.setRotateAngle(this.Cap, 0.2f, 0.0f, 0.0f);
        this.Cap2 = new ModelRenderer(this, 206, 42);
        this.Cap2.setRotationPoint(0.0f, -2.0f, -3.0f);
        this.Cap2.addBox(-8.0f, -15.0f, 0.0f, 16, 15, 8, 0.0f);
        this.setRotateAngle(this.Cap2, -1.4f, 0.0f, 0.0f);
        this.TailHead3 = new ModelRenderer(this, 200, 80);
        this.TailHead3.setRotationPoint(0.0f, 4.0f, 14.5f);
        this.TailHead3.addBox(-6.0f, 0.0f, 0.0f, 12, 4, 7, 0.0f);
        this.setRotateAngle(this.TailHead3, 0.5235988f, 0.0f, 0.0f);
        this.TailHead2 = new ModelRenderer(this, 182, 68);
        this.TailHead2.setRotationPoint(0.0f, -1.5f, 4.5f);
        this.TailHead2.addBox(-9.0f, 0.0f, 0.0f, 18, 8, 19, 0.0f);
        this.setRotateAngle(this.TailHead2, 0.13962634f, 0.0f, 0.0f);
        this.TailHeadCL2 = new ModelRenderer(this, 207, 77);
        this.TailHeadCL2.setRotationPoint(2.0f, 0.5f, 7.0f);
        this.TailHeadCL2.addBox(0.0f, 0.0f, 0.0f, 2, 2, 10, 0.0f);
        this.setRotateAngle(this.TailHeadCL2, 0.08726646f, 0.17453292f, 0.0f);
        this.ArmRight01 = new ModelRenderer(this, 0, 57);
        this.ArmRight01.setRotationPoint(-4.5f, -8.5f, -0.5f);
        this.ArmRight01.addBox(-6.0f, 0.0f, -3.0f, 6, 10, 6, 0.0f);
        this.setRotateAngle(this.ArmRight01, 0.2617994f, 0.0f, 0.43633232f);
        this.ArmRight02 = new ModelRenderer(this, 0, 57);
        this.ArmRight02.setRotationPoint(-6.0f, 10.0f, 3.0f);
        this.ArmRight02.addBox(0.0f, 0.0f, -6.0f, 6, 7, 6, 0.0f);
        this.TailBack4 = new ModelRenderer(this, 163, 70);
        this.TailBack4.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.TailBack4.addBox(-3.5f, 0.0f, 0.0f, 7, 2, 12, 0.0f);
        this.setRotateAngle(this.TailBack4, 0.17453292f, 0.0f, 0.0f);
        this.TailJaw2 = new ModelRenderer(this, 197, 77);
        this.TailJaw2.setRotationPoint(0.0f, 2.0f, 8.0f);
        this.TailJaw2.addBox(-5.0f, 0.0f, 0.0f, 10, 5, 10, 0.0f);
        this.setRotateAngle(this.TailJaw2, -0.17453292f, 0.0f, 0.0f);
        this.BoobR = new ModelRenderer(this, 0, 80);
        this.BoobR.setRotationPoint(-3.5f, -9.5f, -3.0f);
        this.BoobR.addBox(-3.5f, 0.0f, 0.0f, 7, 5, 4, 0.0f);
        this.setRotateAngle(this.BoobR, -0.7853982f, 0.12217305f, 0.08726646f);
        this.TailHeadT01 = new ModelRenderer(this, 141, 29);
        this.TailHeadT01.setRotationPoint(0.0f, 4.5f, 4.5f);
        this.TailHeadT01.addBox(-6.0f, 0.0f, 0.0f, 12, 5, 12, 0.0f);
        this.setRotateAngle(this.TailHeadT01, -0.17453292f, 0.0f, 0.0f);
        this.Tail3 = new ModelRenderer(this, 208, 103);
        this.Tail3.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.Tail3.addBox(-6.0f, -6.0f, 0.0f, 12, 12, 12, 0.0f);
        this.setRotateAngle(this.Tail3, 0.5235988f, 0.0f, 0.0f);
        this.Neck = new ModelRenderer(this, 21, 85);
        this.Neck.setRotationPoint(0.0f, -11.5f, 0.5f);
        this.Neck.addBox(-7.5f, -1.5f, -7.0f, 15, 5, 11, 0.0f);
        this.setRotateAngle(this.Neck, 0.2617994f, 0.0f, 0.0f);
        this.TailBack2 = new ModelRenderer(this, 163, 70);
        this.TailBack2.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.TailBack2.addBox(-3.5f, 0.0f, 0.0f, 7, 2, 12, 0.0f);
        this.setRotateAngle(this.TailBack2, 0.17453292f, 0.0f, 0.0f);
        this.LegLeft = new ModelRenderer(this, 0, 98);
        this.LegLeft.mirror = true;
        this.LegLeft.setRotationPoint(4.5f, 11.0f, -2.0f);
        this.LegLeft.addBox(-3.5f, 0.0f, -3.5f, 7, 22, 7, 0.0f);
        this.setRotateAngle(this.LegLeft, -0.2268928f, 0.0f, 0.05235988f);
        this.BodyMain = new ModelRenderer(this, 0, 34);
        this.BodyMain.setRotationPoint(0.0f, -8.0f, 0.0f);
        this.BodyMain.addBox(-7.0f, -9.0f, -4.0f, 14, 15, 8, 0.0f);
        this.setRotateAngle(this.BodyMain, 0.05235988f, 0.0f, 0.0f);
        this.TailJaw3 = new ModelRenderer(this, 207, 80);
        this.TailJaw3.setRotationPoint(0.0f, 4.0f, 15.5f);
        this.TailJaw3.addBox(-2.5f, -2.5f, 0.0f, 5, 5, 7, 0.0f);
        this.setRotateAngle(this.TailJaw3, -0.10035643f, 0.0f, 0.0f);
        this.TailBase = new ModelRenderer(this, 208, 103);
        this.TailBase.setRotationPoint(0.0f, 7.5f, 0.0f);
        this.TailBase.addBox(-6.0f, -6.0f, 0.0f, 12, 12, 12, 0.0f);
        this.setRotateAngle(this.TailBase, -0.2617994f, 0.0f, 0.0f);
        this.Butt = new ModelRenderer(this, 106, 0);
        this.Butt.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Butt.addBox(-8.0f, 4.0f, -5.0f, 16, 8, 8, 0.0f);
        this.setRotateAngle(this.Butt, 0.17453292f, 0.0f, 0.0f);
        this.TailBack5 = new ModelRenderer(this, 163, 70);
        this.TailBack5.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.TailBack5.addBox(-3.5f, 0.0f, 0.0f, 7, 2, 12, 0.0f);
        this.setRotateAngle(this.TailBack5, 0.17453292f, 0.0f, 0.0f);
        this.LegRight = new ModelRenderer(this, 0, 98);
        this.LegRight.setRotationPoint(-4.5f, 11.0f, -2.0f);
        this.LegRight.addBox(-3.5f, 0.0f, -3.5f, 7, 22, 7, 0.0f);
        this.setRotateAngle(this.LegRight, -0.2268928f, 0.0f, -0.05235988f);
        this.TailBack0 = new ModelRenderer(this, 163, 70);
        this.TailBack0.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.TailBack0.addBox(-3.5f, 0.0f, 0.0f, 7, 2, 12, 0.0f);
        this.setRotateAngle(this.TailBack0, 0.17453292f, 0.0f, 0.0f);
        this.Cloth = new ModelRenderer(this, 0, 0);
        this.Cloth.setRotationPoint(0.0f, -8.5f, 0.0f);
        this.Cloth.addBox(-8.0f, 0.0f, -4.5f, 16, 14, 9, 0.0f);
        this.TailHeadC3 = new ModelRenderer(this, 207, 77);
        this.TailHeadC3.setRotationPoint(-2.8f, 1.0f, 8.5f);
        this.TailHeadC3.addBox(-1.0f, 0.0f, 0.0f, 2, 2, 10, 0.0f);
        this.setRotateAngle(this.TailHeadC3, 0.13962634f, -0.05235988f, 0.0f);
        this.Tail1 = new ModelRenderer(this, 208, 103);
        this.Tail1.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.Tail1.addBox(-6.0f, -6.0f, 0.0f, 12, 12, 12, 0.0f);
        this.setRotateAngle(this.Tail1, 0.2617994f, 0.0f, 0.0f);
        this.TailHeadBase = new ModelRenderer(this, 157, 96);
        this.TailHeadBase.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.Hair = new ModelRenderer(this, 24, 61);
        this.Hair.setRotationPoint(0.0f, -7.3f, 0.0f);
        this.Hair.addBox(-7.5f, -8.0f, -8.0f, 15, 16, 8, 0.0f);
        this.Hair01 = new ModelRenderer(this, 186, 0);
        this.Hair01.setRotationPoint(0.0f, -9.5f, 9.5f);
        this.Hair01.addBox(-7.0f, 0.0f, -12.0f, 14, 9, 9, 0.0f);
        this.setRotateAngle(this.Hair01, 0.1257f, 0.0f, 0.0f);
        this.HairU01 = new ModelRenderer(this, 189, 19);
        this.HairU01.setRotationPoint(0.0f, -0.2f, -7.2f);
        this.HairU01.addBox(-8.0f, -14.7f, 0.0f, 16, 15, 6, 0.0f);
        this.TailJaw1 = new ModelRenderer(this, 194, 106);
        this.TailJaw1.setRotationPoint(0.0f, 3.0f, 5.0f);
        this.TailJaw1.addBox(-6.5f, 0.0f, 0.0f, 13, 5, 16, 0.0f);
        this.setRotateAngle(this.TailJaw1, -0.17453292f, 0.0f, 0.0f);
        this.Head = new ModelRenderer(this, 39, 101);
        this.Head.setRotationPoint(0.0f, -0.5f, 0.0f);
        this.Head.addBox(-7.0f, -14.5f, -6.5f, 14, 14, 13, 0.0f);
        this.setRotateAngle(this.Head, -0.17453292f, 0.0f, 0.0f);
        this.TailHeadCR1 = new ModelRenderer(this, 207, 80);
        this.TailHeadCR1.setRotationPoint(-6.0f, -6.0f, 5.0f);
        this.TailHeadCR1.addBox(-5.0f, 0.0f, 0.0f, 5, 6, 7, 0.0f);
        this.setRotateAngle(this.TailHeadCR1, 0.08726646f, -0.17453292f, 0.0f);
        this.TailBack1 = new ModelRenderer(this, 163, 70);
        this.TailBack1.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.TailBack1.addBox(-3.5f, 0.0f, 0.0f, 7, 2, 12, 0.0f);
        this.setRotateAngle(this.TailBack1, 0.17453292f, 0.0f, 0.0f);
        this.TailHeadC4 = new ModelRenderer(this, 207, 77);
        this.TailHeadC4.setRotationPoint(2.8f, 1.0f, 8.5f);
        this.TailHeadC4.addBox(-1.0f, 0.0f, 0.0f, 2, 2, 10, 0.0f);
        this.setRotateAngle(this.TailHeadC4, 0.13962634f, 0.05235988f, 0.0f);
        this.PalmRight = new ModelRenderer(this, 0, 89);
        this.PalmRight.setRotationPoint(3.0f, 7.0f, -3.0f);
        this.PalmRight.addBox(-2.5f, 0.0f, -2.5f, 5, 4, 5, 0.0f);
        this.setRotateAngle(this.PalmRight, 0.0f, 0.025307273f, 0.0f);
        this.Tail2 = new ModelRenderer(this, 208, 103);
        this.Tail2.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.Tail2.addBox(-6.0f, -6.0f, 0.0f, 12, 12, 12, 0.0f);
        this.setRotateAngle(this.Tail2, 0.5235988f, 0.0f, 0.0f);
        this.TailJawT01 = new ModelRenderer(this, 143, 46);
        this.TailJawT01.setRotationPoint(0.0f, -3.0f, 4.0f);
        this.TailJawT01.addBox(-5.5f, 0.0f, 0.0f, 11, 5, 11, 0.0f);
        this.setRotateAngle(this.TailJawT01, 0.17453292f, 0.0f, 0.0f);
        this.Tail4 = new ModelRenderer(this, 208, 103);
        this.Tail4.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.Tail4.addBox(-6.0f, -6.0f, 0.0f, 12, 12, 12, 0.0f);
        this.setRotateAngle(this.Tail4, 0.2617994f, 0.0f, 0.0f);
        this.TailHeadCL3 = new ModelRenderer(this, 207, 77);
        this.TailHeadCL3.setRotationPoint(2.0f, 3.5f, 7.0f);
        this.TailHeadCL3.addBox(0.0f, 0.0f, 0.0f, 2, 2, 10, 0.0f);
        this.setRotateAngle(this.TailHeadCL3, -0.05235988f, 0.17453292f, 0.0f);
        this.BoobM = new ModelRenderer(this, 0, 0);
        this.BoobM.setRotationPoint(4.2f, 4.5f, 0.3f);
        this.BoobM.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 0, 0.0f);
        this.setRotateAngle(this.BoobM, 0.7853982f, 0.0f, -0.08726646f);
        this.TailBack6 = new ModelRenderer(this, 163, 70);
        this.TailBack6.setRotationPoint(0.0f, -7.5f, 0.0f);
        this.TailBack6.addBox(-3.5f, 0.0f, 0.0f, 7, 2, 12, 0.0f);
        this.setRotateAngle(this.TailBack6, 0.17453292f, 0.0f, 0.0f);
        this.TailBack3 = new ModelRenderer(this, 163, 70);
        this.TailBack3.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.TailBack3.addBox(-3.5f, 0.0f, 0.0f, 7, 2, 12, 0.0f);
        this.setRotateAngle(this.TailBack3, 0.17453292f, 0.0f, 0.0f);
        this.BagMain2 = new ModelRenderer(this, 36, 23);
        this.BagMain2.setRotationPoint(-0.5f, 11.0f, -0.5f);
        this.BagMain2.addBox(-7.5f, 0.0f, 0.0f, 15, 9, 8, 0.0f);
        this.setRotateAngle(this.BagMain2, 0.6981317f, 0.0f, -0.2617994f);
        this.Ear01 = new ModelRenderer(this, 136, 17);
        this.Ear01.mirror = true;
        this.Ear01.setRotationPoint(-3.5f, -14.5f, 5.7f);
        this.Ear01.addBox(-1.5f, 0.0f, -6.0f, 3, 6, 6, 0.0f);
        this.setRotateAngle(this.Ear01, -0.6981f, 0.2618f, -0.1396f);
        this.Ear02 = new ModelRenderer(this, 136, 17);
        this.Ear02.setRotationPoint(3.5f, -14.5f, 5.7f);
        this.Ear02.addBox(-1.5f, 0.0f, -6.0f, 3, 6, 6, 0.0f);
        this.setRotateAngle(this.Ear02, -0.6981f, -0.2618f, 0.1396f);
        this.BodyMain.addChild(this.ArmLeft01);
        this.ArmLeft01.addChild(this.ArmLeft02);
        this.TailHead1.addChild(this.TailHeadC1);
        this.Cloth.addChild(this.Cloth2);
        this.BodyMain.addChild(this.BoobL);
        this.ArmLeft02.addChild(this.PalmLeft);
        this.TailHeadCR1.addChild(this.TailHeadCR2);
        this.TailHeadC1.addChild(this.TailHeadC2);
        this.TailHeadCR1.addChild(this.TailHeadCR3);
        this.TailHeadBase.addChild(this.TailHeadCL1);
        this.BodyMain.addChild(this.BagMain);
        this.BagMain.addChild(this.BagStrap2);
        this.Hair.addChild(this.Ahoke);
        this.Head.addChild(this.Cap);
        this.Head.addChild(this.Ear01);
        this.Head.addChild(this.Ear02);
        this.TailHead1.addChild(this.TailHead3);
        this.TailHead1.addChild(this.TailHead2);
        this.TailHeadCL1.addChild(this.TailHeadCL2);
        this.BodyMain.addChild(this.ArmRight01);
        this.ArmRight01.addChild(this.ArmRight02);
        this.TailJaw1.addChild(this.TailJaw2);
        this.BodyMain.addChild(this.BoobR);
        this.Butt.addChild(this.LegLeft);
        this.TailJaw1.addChild(this.TailJaw3);
        this.BodyMain.addChild(this.Butt);
        this.Butt.addChild(this.LegRight);
        this.BodyMain.addChild(this.Cloth);
        this.TailHeadC1.addChild(this.TailHeadC3);
        this.BagMain.addChild(this.BagStrap1);
        this.Head.addChild(this.Hair);
        this.Head.addChild(this.Hair01);
        this.Head.addChild(this.HairU01);
        this.TailHeadBase.addChild(this.TailHeadCR1);
        this.TailHeadC1.addChild(this.TailHeadC4);
        this.ArmRight02.addChild(this.PalmRight);
        this.TailHeadCL1.addChild(this.TailHeadCL3);
        this.BoobR.addChild(this.BoobM);
        this.BagMain.addChild(this.BagMain2);
        this.BodyMain.addChild(this.Neck);
        this.Neck.addChild(this.Head);
        this.Neck.addChild(this.Cap2);
        this.BodyMain.addChild(this.TailBase);
        this.TailBase.addChild(this.Tail1);
        this.Tail1.addChild(this.Tail2);
        this.Tail2.addChild(this.Tail3);
        this.Tail3.addChild(this.Tail4);
        this.Tail4.addChild(this.Tail5);
        this.Tail5.addChild(this.Tail6);
        this.Tail6.addChild(this.TailHeadBase);
        this.TailHeadBase.addChild(this.TailHead1);
        this.TailHeadBase.addChild(this.TailJaw1);
        this.GlowBodyMain = new ModelRenderer(this, 0, 0);
        this.GlowBodyMain.setRotationPoint(0.0f, -8.0f, 0.0f);
        this.GlowNeck = new ModelRenderer(this, 0, 0);
        this.GlowNeck.setRotationPoint(0.0f, -11.5f, 0.5f);
        this.GlowHead = new ModelRenderer(this, 0, 0);
        this.GlowHead.setRotationPoint(0.0f, -0.5f, 0.0f);
        this.GlowTailBase = new ModelRenderer(this, 0, 0);
        this.GlowTailBase.setRotationPoint(0.0f, 7.5f, 0.0f);
        this.GlowTail1 = new ModelRenderer(this, 0, 0);
        this.GlowTail1.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.GlowTail2 = new ModelRenderer(this, 0, 0);
        this.GlowTail2.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.GlowTail3 = new ModelRenderer(this, 0, 0);
        this.GlowTail3.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.GlowTail4 = new ModelRenderer(this, 0, 0);
        this.GlowTail4.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.GlowTail5 = new ModelRenderer(this, 0, 0);
        this.GlowTail5.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.GlowTail6 = new ModelRenderer(this, 0, 0);
        this.GlowTail6.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.GlowTailHeadBase = new ModelRenderer(this, 157, 96);
        this.GlowTailHeadBase.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.GlowTailHeadBase.addBox(-5.0f, -7.0f, 0.0f, 10, 14, 12, 0.0f);
        this.GlowTailHead1 = new ModelRenderer(this, 0, 0);
        this.GlowTailHead1.setRotationPoint(0.0f, -8.5f, 4.0f);
        this.GlowTailJaw1 = new ModelRenderer(this, 0, 0);
        this.GlowTailJaw1.setRotationPoint(0.0f, 3.0f, 5.0f);
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
        this.GlowBodyMain.addChild(this.GlowTailBase);
        this.GlowTailBase.addChild(this.GlowTail1);
        this.GlowTail1.addChild(this.GlowTail2);
        this.GlowTail2.addChild(this.GlowTail3);
        this.GlowTail3.addChild(this.GlowTail4);
        this.GlowTail4.addChild(this.GlowTail5);
        this.GlowTail5.addChild(this.GlowTail6);
        this.GlowTailBase.addChild(this.TailBack0);
        this.GlowTail1.addChild(this.TailBack1);
        this.GlowTail2.addChild(this.TailBack2);
        this.GlowTail3.addChild(this.TailBack3);
        this.GlowTail4.addChild(this.TailBack4);
        this.GlowTail5.addChild(this.TailBack5);
        this.GlowTail6.addChild(this.TailBack6);
        this.GlowTail6.addChild(this.GlowTailHeadBase);
        this.GlowTailHeadBase.addChild(this.GlowTailHead1);
        this.GlowTailHead1.addChild(this.TailHeadT01);
        this.GlowTailHeadBase.addChild(this.GlowTailJaw1);
        this.GlowTailJaw1.addChild(this.TailJawT01);
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
        this.Hair01.isHidden = flag = !EmotionHelper.checkModelState(0, state);
        this.HairU01.isHidden = flag;
        this.Ear01.isHidden = flag;
        this.Ear02.isHidden = flag;
        this.Cap.isHidden = !flag;
        this.Cap2.isHidden = flag;
        this.BagMain.isHidden = !EmotionHelper.checkModelState(1, state);
        this.Ear01.isHidden = flag = !EmotionHelper.checkModelState(2, state);
        this.Ear02.isHidden = flag;
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
        this.GlowTailBase.rotateAngleX = this.TailBase.rotateAngleX;
        this.GlowTailBase.rotateAngleY = this.TailBase.rotateAngleY;
        this.GlowTailBase.rotateAngleZ = this.TailBase.rotateAngleZ;
        this.GlowTail1.rotateAngleX = this.Tail1.rotateAngleX;
        this.GlowTail1.rotateAngleY = this.Tail1.rotateAngleY;
        this.GlowTail1.rotateAngleZ = this.Tail1.rotateAngleZ;
        this.GlowTail2.rotateAngleX = this.Tail2.rotateAngleX;
        this.GlowTail2.rotateAngleY = this.Tail2.rotateAngleY;
        this.GlowTail2.rotateAngleZ = this.Tail2.rotateAngleZ;
        this.GlowTail3.rotateAngleX = this.Tail3.rotateAngleX;
        this.GlowTail3.rotateAngleY = this.Tail3.rotateAngleY;
        this.GlowTail3.rotateAngleZ = this.Tail3.rotateAngleZ;
        this.GlowTail4.rotateAngleX = this.Tail4.rotateAngleX;
        this.GlowTail4.rotateAngleY = this.Tail4.rotateAngleY;
        this.GlowTail4.rotateAngleZ = this.Tail4.rotateAngleZ;
        this.GlowTail5.rotateAngleX = this.Tail5.rotateAngleX;
        this.GlowTail5.rotateAngleY = this.Tail5.rotateAngleY;
        this.GlowTail5.rotateAngleZ = this.Tail5.rotateAngleZ;
        this.GlowTail6.rotateAngleX = this.Tail6.rotateAngleX;
        this.GlowTail6.rotateAngleY = this.Tail6.rotateAngleY;
        this.GlowTail6.rotateAngleZ = this.Tail6.rotateAngleZ;
        this.GlowTailHeadBase.rotateAngleX = this.TailHeadBase.rotateAngleX;
        this.GlowTailHeadBase.rotateAngleY = this.TailHeadBase.rotateAngleY;
        this.GlowTailHeadBase.rotateAngleZ = this.TailHeadBase.rotateAngleZ;
        this.GlowTailHead1.rotateAngleX = this.TailHead1.rotateAngleX;
        this.GlowTailHead1.rotateAngleY = this.TailHead1.rotateAngleY;
        this.GlowTailHead1.rotateAngleZ = this.TailHead1.rotateAngleZ;
        this.GlowTailJaw1.rotateAngleX = this.TailJaw1.rotateAngleX;
        this.GlowTailJaw1.rotateAngleY = this.TailJaw1.rotateAngleY;
        this.GlowTailJaw1.rotateAngleZ = this.TailJaw1.rotateAngleZ;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        GlStateManager.translate(0.0f, 1.13f, 0.0f);
        this.setFaceHungry(ent);
        this.Head.rotateAngleX = 0.0f;
        this.Head.rotateAngleY = 0.0f;
        this.BoobL.rotateAngleX = -0.73f;
        this.BoobR.rotateAngleX = -0.73f;
        this.Ahoke.rotateAngleY = 0.5236f;
        this.Head.rotateAngleX -= 0.5236f;
        this.BodyMain.rotateAngleY = 0.0f;
        this.BodyMain.rotateAngleX = 1.5708f;
        this.Cloth2.rotateAngleX = -0.0524f;
        this.ArmLeft01.rotateAngleX = -2.9671f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = 0.0349f;
        this.ArmLeft02.rotateAngleZ = 0.0f;
        this.ArmRight01.rotateAngleX = -2.9671f;
        this.ArmRight01.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleZ = -0.0349f;
        this.ArmRight02.rotateAngleZ = 0.0f;
        this.BagStrap1.rotateAngleX = 0.2618f;
        this.BagStrap1.rotateAngleY = -0.1396f;
        this.BagStrap1.rotateAngleZ = -0.1745f;
        this.BagStrap2.rotateAngleX = 0.3491f;
        this.BagStrap2.rotateAngleY = 0.3491f;
        this.LegLeft.rotateAngleX = -0.3491f;
        this.LegRight.rotateAngleX = -0.3491f;
        this.LegLeft.rotateAngleY = 0.0f;
        this.LegRight.rotateAngleY = 0.0f;
        this.TailBase.rotateAngleX = -0.4f;
        this.TailBase.rotateAngleY = -0.8f;
        this.TailBase.rotateAngleZ = 0.0f;
        this.Tail1.rotateAngleX = -0.3f;
        this.Tail1.rotateAngleY = -0.35f;
        this.Tail1.rotateAngleZ = 0.0f;
        this.Tail2.rotateAngleX = -0.35f;
        this.Tail2.rotateAngleY = -0.3f;
        this.Tail2.rotateAngleZ = 0.0f;
        this.Tail3.rotateAngleX = -0.4f;
        this.Tail3.rotateAngleY = -0.2f;
        this.Tail3.rotateAngleZ = 0.0f;
        this.Tail4.rotateAngleX = -0.25f;
        this.Tail4.rotateAngleY = 0.2f;
        this.Tail4.rotateAngleZ = 0.0f;
        this.Tail5.rotateAngleX = 0.25f;
        this.Tail5.rotateAngleY = 0.2f;
        this.Tail5.rotateAngleZ = 0.0f;
        this.Tail6.rotateAngleX = 0.35f;
        this.Tail6.rotateAngleY = 0.2f;
        this.Tail6.rotateAngleZ = 0.0f;
        this.TailHeadBase.rotateAngleX = 0.4f;
        this.TailHeadBase.rotateAngleY = 0.0f;
        this.TailHeadBase.rotateAngleZ = 0.0f;
        this.TailHead1.rotateAngleX = 0.2618f;
        this.TailJaw1.rotateAngleX = -0.7f;
        this.Hair01.isHidden = true;
        this.Ear01.isHidden = true;
        this.Ear02.isHidden = true;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float f6;
        float angleX = MathHelper.cos(f2 * 0.08f);
        float addk1;
        float addk2;
        GlStateManager.translate(0.0f, 0.63f, 0.0f);
        if (ent.getShipDepth(0) > 0.0) {
            GlStateManager.translate(0.0f, angleX * 0.05f + 0.025f, 0.0f);
        }
        addk1 = MathHelper.cos(f * 0.7f) * f1;
        addk2 = MathHelper.cos(f * 0.7f + (float)Math.PI) * f1;
        this.Head.rotateAngleX = f4 * 0.014f;
        this.Head.rotateAngleY = f3 * 0.01f;
        this.BoobL.rotateAngleX = -angleX * 0.06f - 0.73f;
        this.BoobR.rotateAngleX = -angleX * 0.06f - 0.73f;
        this.Ahoke.rotateAngleY = angleX * 0.25f + 0.5236f;
        this.Head.rotateAngleX -= 0.5236f;
        this.Cap2.rotateAngleX = -1.4f;
        this.BodyMain.rotateAngleX = 0.0873f;
        this.BodyMain.rotateAngleY = 0.0f;
        this.Cloth2.rotateAngleX = -0.0524f;
        this.ArmLeft01.rotateAngleX = 0.2618f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = angleX * 0.1f - 0.5236f;
        this.ArmLeft02.rotateAngleZ = 0.0f;
        this.ArmRight01.rotateAngleX = 0.2618f;
        this.ArmRight01.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleZ = -angleX * 0.1f + 0.5236f;
        this.ArmRight02.rotateAngleZ = 0.0f;
        this.BagStrap1.rotateAngleX = 0.2618f;
        this.BagStrap1.rotateAngleY = -0.1396f;
        this.BagStrap1.rotateAngleZ = -0.1745f;
        this.BagStrap2.rotateAngleX = 0.3491f;
        this.BagStrap2.rotateAngleY = 0.3491f;
        addk1 -= 0.2618f;
        addk2 -= 0.2618f;
        this.LegLeft.rotateAngleY = 0.0f;
        this.LegRight.rotateAngleY = 0.0f;
        this.TailBase.rotateAngleX = -0.5236f;
        this.TailBase.rotateAngleY = MathHelper.cos(-f2 * 0.1f) * 0.1f;
        this.TailBase.rotateAngleZ = 0.0f;
        this.Tail1.rotateAngleX = 0.5236f;
        this.Tail1.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 0.7f) * 0.1f;
        this.Tail1.rotateAngleZ = 0.0f;
        this.Tail2.rotateAngleX = 0.5236f;
        this.Tail2.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 1.4f) * 0.15f;
        this.Tail2.rotateAngleZ = 0.0f;
        this.Tail3.rotateAngleX = 0.5236f;
        this.Tail3.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 2.1f) * 0.2f;
        this.Tail3.rotateAngleZ = 0.0f;
        this.Tail4.rotateAngleX = 0.5236f;
        this.Tail4.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 2.8f) * 0.25f;
        this.Tail4.rotateAngleZ = 0.0f;
        this.Tail5.rotateAngleX = -0.5236f;
        this.Tail5.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 3.5f) * 0.3f;
        this.Tail5.rotateAngleZ = 0.0f;
        this.Tail6.rotateAngleX = -0.5236f;
        this.Tail6.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 4.2f) * 0.35f;
        this.Tail6.rotateAngleZ = 0.0f;
        this.TailHeadBase.rotateAngleX = -0.5236f;
        this.TailHeadBase.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 4.9f) * 0.4f;
        this.TailHeadBase.rotateAngleZ = 0.0f;
        this.TailHead1.rotateAngleX = 0.1745f;
        this.TailJaw1.rotateAngleX = angleX * 0.1f - 0.15f;
        float modf2 = f2 % 128.0f;
        if (modf2 < 6.0f) {
            if (modf2 >= 3.0f) {
                modf2 -= 3.0f;
            }
            float anglef2 = MathHelper.sin(modf2 * 1.0472f) * 0.25f;
            this.Ear01.rotateAngleZ = -anglef2 - 0.14f;
            this.Ear02.rotateAngleZ = anglef2 + 0.14f;
        } else {
            this.Ear01.rotateAngleZ = -0.14f;
            this.Ear02.rotateAngleZ = 0.14f;
        }
        if (ent.getIsSprinting() || f1 > 0.9f) {
            this.setFaceHappy(ent);
            float t2 = ent.getTickExisted() & 0x3FF;
            if (t2 > 700.0f) {
                GlStateManager.translate(0.0f, 0.05f, 0.0f);
                this.ArmLeft01.rotateAngleX = MathHelper.cos(f * 0.8f) * 0.1f - 2.0944f;
                this.ArmLeft01.rotateAngleY = -0.5236f;
                this.ArmLeft01.rotateAngleZ = 0.0f;
                this.ArmRight01.rotateAngleX = -MathHelper.cos(f * 0.8f) * 0.1f - 2.0944f;
                this.ArmRight01.rotateAngleY = 0.5236f;
                this.ArmRight01.rotateAngleZ = 0.0f;
                this.Head.rotateAngleX *= 0.75f;
                this.Head.rotateAngleX -= 0.5236f;
                this.Cap2.rotateAngleX = -1.74f;
                this.BodyMain.rotateAngleX = 0.5236f;
                this.BodyMain.rotateAngleY = 3.1416f;
                this.Cloth2.rotateAngleX = -0.7854f;
                addk1 = addk1 * 0.1f - 1.2708f;
                addk2 = addk2 * 0.1f - 1.2708f;
                this.LegLeft.rotateAngleY = -0.2618f;
                this.LegRight.rotateAngleY = 0.2618f;
                this.BagStrap1.rotateAngleX = 0.0872f;
                this.BagStrap1.rotateAngleY = 0.0f;
                this.BagStrap1.rotateAngleZ = -0.1745f;
                this.BagStrap2.rotateAngleX = 0.0872f;
                this.BagStrap2.rotateAngleY = 0.3491f;
                this.TailBase.rotateAngleX = -1.3f;
                this.TailBase.rotateAngleY = -MathHelper.cos(f * 0.25f - 5.0f) * 0.2f * f1;
                this.TailBase.rotateAngleZ = MathHelper.cos(f * 0.25f - 5.0f) * 0.4f * f1;
                this.Tail1.rotateAngleX = 0.2618f;
                this.Tail1.rotateAngleY = -MathHelper.cos(f * 0.25f - 4.2f) * 0.3f * f1;
                this.Tail1.rotateAngleZ = -MathHelper.cos(f * 0.25f - 4.2f) * 0.1f * f1;
                this.Tail2.rotateAngleX = 0.2618f;
                this.Tail2.rotateAngleY = -MathHelper.cos(f * 0.25f - 3.5f) * 0.4f * f1;
                this.Tail2.rotateAngleZ = -MathHelper.cos(f * 0.25f - 3.5f) * 0.1f * f1;
                this.Tail3.rotateAngleX = 0.1745f;
                this.Tail3.rotateAngleY = -MathHelper.cos(f * 0.25f - 2.8f) * 0.5f * f1;
                this.Tail3.rotateAngleZ = 0.0f;
                this.Tail4.rotateAngleX = 0.1745f;
                this.Tail4.rotateAngleY = -MathHelper.cos(f * 0.25f - 2.1f) * 0.5f * f1;
                this.Tail4.rotateAngleZ = 0.0f;
                this.Tail5.rotateAngleX = 0.0873f;
                this.Tail5.rotateAngleY = -MathHelper.cos(f * 0.25f - 1.4f) * 0.4f * f1;
                this.Tail5.rotateAngleZ = 0.0f;
                this.Tail6.rotateAngleX = 0.0873f;
                this.Tail6.rotateAngleY = -MathHelper.cos(f * 0.25f - 0.7f) * 0.3f * f1;
                this.Tail6.rotateAngleZ = 0.0f;
                this.TailHeadBase.rotateAngleX = -0.0873f;
                this.TailHeadBase.rotateAngleY = -MathHelper.cos(f * 0.25f) * 0.2f * f1;
                this.TailHeadBase.rotateAngleZ = 0.0f;
                this.TailHead1.rotateAngleX = 0.3f;
                this.TailJaw1.rotateAngleX = angleX * 0.2f - 0.3f;
            } else if (t2 > 400.0f) {
                GlStateManager.translate(0.0f, 0.05f, 0.0f);
                this.ArmLeft01.rotateAngleX = -1.0472f;
                this.ArmLeft01.rotateAngleY = 0.2618f;
                this.ArmLeft01.rotateAngleZ = 0.0f;
                this.ArmRight01.rotateAngleX = -2.7925f;
                this.ArmRight01.rotateAngleY = 0.0f;
                this.ArmRight01.rotateAngleZ = f3 / -57.0f;
                this.Head.rotateAngleX *= 0.75f;
                this.Head.rotateAngleX -= 1.2217f;
                this.Cap2.rotateAngleX = -1.74f;
                this.BodyMain.rotateAngleX = 1.2217f;
                this.Cloth2.rotateAngleX = -0.3491f;
                addk1 = -1.0472f;
                addk2 = -1.0472f;
                this.LegLeft.rotateAngleY = -0.3491f;
                this.LegRight.rotateAngleY = 0.3491f;
                this.BagStrap1.rotateAngleX = 0.2618f;
                this.BagStrap1.rotateAngleY = 0.0f;
                this.BagStrap1.rotateAngleZ = 0.0f;
                this.BagStrap2.rotateAngleX = 0.3491f;
                this.BagStrap2.rotateAngleY = 0.3491f;
                this.TailBase.rotateAngleX = 1.0472f;
                this.TailBase.rotateAngleY = 0.0f;
                this.TailBase.rotateAngleZ = 3.1415f;
                this.Tail1.rotateAngleX = 0.7854f;
                this.Tail1.rotateAngleY = 0.0f;
                this.Tail1.rotateAngleZ = 0.0f;
                this.Tail2.rotateAngleX = 0.7854f;
                this.Tail2.rotateAngleY = 0.0f;
                this.Tail2.rotateAngleZ = 0.0f;
                this.Tail3.rotateAngleX = 0.7854f;
                this.Tail3.rotateAngleY = 0.0f;
                this.Tail3.rotateAngleZ = 0.0f;
                this.Tail4.rotateAngleX = 0.7854f;
                this.Tail4.rotateAngleY = 0.0f;
                this.Tail4.rotateAngleZ = 0.0f;
                this.Tail5.rotateAngleX = 0.5236f;
                this.Tail5.rotateAngleY = 0.0f;
                this.Tail5.rotateAngleZ = 0.0f;
                this.Tail6.rotateAngleX = -0.2618f;
                this.Tail6.rotateAngleY = 0.0f;
                this.Tail6.rotateAngleZ = 0.0f;
                this.TailHeadBase.rotateAngleX = 0.0f;
                this.TailHeadBase.rotateAngleY = 0.0f;
                this.TailHeadBase.rotateAngleZ = 0.0f;
                this.TailHead1.rotateAngleX = 0.1745f;
                this.TailJaw1.rotateAngleX = angleX * 0.15f - 0.3f;
            } else {
                GlStateManager.translate(0.0f, 0.1f, 0.0f);
                this.ArmLeft01.rotateAngleX = MathHelper.cos(f * 0.8f) * 0.1f + 0.6981f;
                this.ArmLeft01.rotateAngleY = 0.0f;
                this.ArmLeft01.rotateAngleZ = -0.6981f;
                this.ArmRight01.rotateAngleX = MathHelper.cos(f * 0.8f) * 0.1f + 0.6981f;
                this.ArmRight01.rotateAngleY = 0.0f;
                this.ArmRight01.rotateAngleZ = 0.6981f;
                this.Head.rotateAngleX *= 0.75f;
                this.Head.rotateAngleX -= 1.0472f;
                this.Cap2.rotateAngleX = -1.74f;
                this.BodyMain.rotateAngleX = 0.8727f;
                this.Cloth2.rotateAngleX = -0.5236f;
                addk1 -= 0.5f;
                addk2 -= 0.5f;
                this.LegLeft.rotateAngleY = 0.0f;
                this.LegRight.rotateAngleY = 0.0f;
                this.BagStrap1.rotateAngleX = 0.15f;
                this.BagStrap1.rotateAngleY = -1.0472f;
                this.BagStrap1.rotateAngleZ = 0.0f;
                this.BagStrap2.rotateAngleX = 0.3491f;
                this.BagStrap2.rotateAngleY = 1.0472f;
                this.TailBase.rotateAngleX = -0.7f;
                this.TailBase.rotateAngleY = -MathHelper.cos(-f * 0.3f) * 0.2f * f1;
                this.TailBase.rotateAngleZ = MathHelper.cos(-f * 0.3f) * 0.3f * f1;
                this.Tail1.rotateAngleX = 0.2618f;
                this.Tail1.rotateAngleY = -MathHelper.cos(-f * 0.3f + 0.7f) * 0.2f * f1;
                this.Tail1.rotateAngleZ = -MathHelper.cos(-f * 0.3f + 0.7f) * 0.1f * f1;
                this.Tail2.rotateAngleX = 0.2618f;
                this.Tail2.rotateAngleY = -MathHelper.cos(-f * 0.3f + 1.4f) * 0.3f * f1;
                this.Tail2.rotateAngleZ = -MathHelper.cos(-f * 0.3f + 1.4f) * 0.1f * f1;
                this.Tail3.rotateAngleX = -0.2618f;
                this.Tail3.rotateAngleY = -MathHelper.cos(-f * 0.3f + 2.2f) * 0.3f * f1;
                this.Tail3.rotateAngleZ = MathHelper.cos(-f * 0.3f + 2.2f) * 0.1f * f1;
                this.Tail4.rotateAngleX = -0.2618f;
                this.Tail4.rotateAngleY = -MathHelper.cos(-f * 0.3f + 2.8f) * 0.4f * f1;
                this.Tail4.rotateAngleZ = MathHelper.cos(-f * 0.3f + 2.8f) * 0.1f * f1;
                this.Tail5.rotateAngleX = -0.2618f;
                this.Tail5.rotateAngleY = -MathHelper.cos(-f * 0.3f + 3.5f) * 0.4f * f1;
                this.Tail5.rotateAngleZ = MathHelper.cos(-f * 0.3f + 3.5f) * 0.1f * f1;
                this.Tail6.rotateAngleX = -0.2618f;
                this.Tail6.rotateAngleY = -MathHelper.cos(-f * 0.3f + 4.2f) * 0.5f * f1;
                this.Tail6.rotateAngleZ = MathHelper.cos(-f * 0.3f + 4.2f) * 0.1f * f1;
                this.TailHeadBase.rotateAngleX = 0.2618f;
                this.TailHeadBase.rotateAngleY = -MathHelper.cos(-f * 0.3f + 4.9f) * 0.6f * f1;
                this.TailHeadBase.rotateAngleZ = -MathHelper.cos(-f * 0.3f + 4.9f) * 0.1f * f1;
                this.TailHead1.rotateAngleX = 0.1745f;
                this.TailJaw1.rotateAngleX = angleX * 0.15f - 0.3f;
            }
        }
        this.Head.rotateAngleZ = EmotionHelper.getHeadTiltAngle(ent, f2);
        if (ent.getIsSneaking()) {
            GlStateManager.translate(0.0f, 0.1f, 0.0f);
            this.ArmLeft01.rotateAngleX = 0.5236f;
            this.ArmLeft01.rotateAngleY = 0.0f;
            this.ArmLeft01.rotateAngleZ = -0.5236f;
            this.ArmRight01.rotateAngleX = 0.5236f;
            this.ArmRight01.rotateAngleY = 0.0f;
            this.ArmRight01.rotateAngleZ = 0.5236f;
            this.Head.rotateAngleX = -1.2217f;
            this.BodyMain.rotateAngleX = 1.0472f;
            this.Cloth2.rotateAngleX = -0.5236f;
            addk1 -= 0.95f;
            addk2 -= 0.95f;
            this.LegLeft.rotateAngleY = 0.0f;
            this.LegRight.rotateAngleY = 0.0f;
            this.BagStrap1.rotateAngleX = 0.15f;
            this.BagStrap1.rotateAngleY = -1.0472f;
            this.BagStrap1.rotateAngleZ = 0.0f;
            this.BagStrap2.rotateAngleX = 0.3491f;
            this.BagStrap2.rotateAngleY = 1.0472f;
            this.TailBase.rotateAngleX = 0.7f;
            this.TailBase.rotateAngleY = 0.0f;
            this.TailBase.rotateAngleZ = 3.1416f;
            this.Tail1.rotateAngleX = -0.2618f;
            this.Tail1.rotateAngleY = 0.0f;
            this.Tail1.rotateAngleZ = 0.0f;
            this.Tail2.rotateAngleX = -0.5236f;
            this.Tail2.rotateAngleY = 0.0f;
            this.Tail2.rotateAngleZ = 0.0f;
            this.Tail3.rotateAngleX = -0.2618f;
            this.Tail3.rotateAngleY = 0.0f;
            this.Tail3.rotateAngleZ = 0.0f;
            this.Tail4.rotateAngleX = -0.2618f;
            this.Tail4.rotateAngleY = 0.0f;
            this.Tail4.rotateAngleZ = 0.0f;
            this.Tail5.rotateAngleX = -0.5236f;
            this.Tail5.rotateAngleY = 0.0f;
            this.Tail5.rotateAngleZ = 0.0f;
            this.Tail6.rotateAngleX = -0.5236f;
            this.Tail6.rotateAngleY = 0.0f;
            this.Tail6.rotateAngleZ = 0.0f;
            this.TailHeadBase.rotateAngleX = -0.2618f;
            this.TailHeadBase.rotateAngleY = 0.0f;
            this.TailHeadBase.rotateAngleZ = 0.0f;
            this.TailHead1.rotateAngleX = 0.1745f;
            this.TailJaw1.rotateAngleX = -0.2f;
        }
        if (ent.getIsSitting() || ent.getIsRiding()) {
            this.Cap2.isHidden = true;
            if ((ent.getTickExisted() & 0x3FF) > 512) {
                if (ent.getStateEmotion(1) == 4) {
                    float az1;
                    float az;
                    GlStateManager.translate(0.0f, 0.13f, 0.0f);
                    this.Head.rotateAngleX += 0.3f;
                    this.BodyMain.rotateAngleX = -0.3f;
                    this.Cloth2.rotateAngleX = -0.3f;
                    this.ArmLeft01.rotateAngleX = 2.3f;
                    this.ArmLeft01.rotateAngleY = 0.0f;
                    this.ArmLeft01.rotateAngleZ = 0.2f;
                    this.ArmLeft02.rotateAngleZ = 1.0f;
                    this.ArmRight01.rotateAngleX = 2.3f;
                    this.ArmRight01.rotateAngleY = 0.0f;
                    this.ArmRight01.rotateAngleZ = -0.2f;
                    this.ArmRight02.rotateAngleZ = -1.0f;
                    float parTick = f2 - (int)f2 + (ent.getTickExisted() & 0xFF);
                    if (parTick < 30.0f) {
                        az = MathHelper.sin(parTick * 0.033f * 1.5708f) * 1.6f;
                        az1 = az * 1.6f;
                        this.setFaceHappy(ent);
                        this.ArmLeft01.rotateAngleZ = 0.2f + az;
                        this.ArmLeft02.rotateAngleZ = 1.0f - az1;
                        if (this.ArmLeft02.rotateAngleZ < 0.0f) {
                            this.ArmLeft02.rotateAngleZ = 0.0f;
                        }
                        this.ArmRight01.rotateAngleZ = -0.2f - az;
                        this.ArmRight02.rotateAngleZ = -1.0f + az1;
                        if (this.ArmRight02.rotateAngleZ > 0.0f) {
                            this.ArmRight02.rotateAngleZ = 0.0f;
                        }
                    } else if (parTick < 45.0f) {
                        this.setFaceHappy(ent);
                        this.ArmLeft01.rotateAngleZ = 1.8f;
                        this.ArmLeft02.rotateAngleZ = 0.0f;
                        this.ArmRight01.rotateAngleZ = -1.8f;
                        this.ArmRight02.rotateAngleZ = 0.0f;
                    } else if (parTick < 53.0f) {
                        az = MathHelper.cos((parTick - 45.0f) * 0.125f * 1.5708f);
                        az1 = az * 1.6f;
                        this.ArmLeft01.rotateAngleZ = 0.2f + az1;
                        this.ArmLeft02.rotateAngleZ = 1.0f - az;
                        this.ArmRight01.rotateAngleZ = -0.2f - az1;
                        this.ArmRight02.rotateAngleZ = -1.0f + az;
                    }
                    this.BagStrap1.rotateAngleX = 0.6f;
                    this.BagStrap1.rotateAngleY = 0.0f;
                    this.BagStrap1.rotateAngleZ = 0.0f;
                    this.BagStrap2.rotateAngleX = 1.0472f;
                    this.BagStrap2.rotateAngleY = 1.3963f;
                    addk1 = angleX * 0.1f - 0.9f;
                    addk2 = -angleX * 0.1f - 0.9f;
                    this.LegLeft.rotateAngleY = -0.2f;
                    this.LegRight.rotateAngleY = 0.2f;
                    this.TailBase.rotateAngleX = -1.0f;
                    this.TailBase.rotateAngleY = 0.2618f;
                    this.TailBase.rotateAngleZ = 0.0f;
                    this.Tail1.rotateAngleX = 0.6981f;
                    this.Tail1.rotateAngleY = 0.0872f;
                    this.Tail1.rotateAngleZ = 0.0f;
                    this.Tail2.rotateAngleX = 0.5236f;
                    this.Tail2.rotateAngleY = 0.0872f;
                    this.Tail2.rotateAngleZ = 0.1745f;
                    this.Tail3.rotateAngleX = 0.0f;
                    this.Tail3.rotateAngleY = 0.6981f;
                    this.Tail3.rotateAngleZ = 0.0f;
                    this.Tail4.rotateAngleX = 0.0f;
                    this.Tail4.rotateAngleY = 0.6981f;
                    this.Tail4.rotateAngleZ = 0.0f;
                    this.Tail5.rotateAngleX = 0.0f;
                    this.Tail5.rotateAngleY = 0.5236f;
                    this.Tail5.rotateAngleZ = 0.0f;
                    this.Tail6.rotateAngleX = 0.0f;
                    this.Tail6.rotateAngleY = 0.5236f;
                    this.Tail6.rotateAngleZ = 0.0f;
                    this.TailHeadBase.rotateAngleX = 0.2618f;
                    this.TailHeadBase.rotateAngleY = 0.5236f;
                    this.TailHeadBase.rotateAngleZ = 0.0f;
                    this.TailHead1.rotateAngleX = 0.2618f;
                    this.TailJaw1.rotateAngleX = angleX * 0.1f - 0.2618f;
                } else {
                    GlStateManager.translate(0.0f, 0.51f, 0.0f);
                    this.Head.rotateAngleX *= 0.8f;
                    this.Head.rotateAngleX -= 1.8f;
                    this.Head.rotateAngleY *= 0.5f;
                    this.BodyMain.rotateAngleX = 1.5708f;
                    this.Cloth2.rotateAngleX = -0.0524f;
                    this.ArmLeft01.rotateAngleX = -2.9671f;
                    this.ArmLeft01.rotateAngleY = 0.0f;
                    this.ArmLeft01.rotateAngleZ = 0.0349f;
                    this.ArmLeft02.rotateAngleZ = 1.3962f;
                    this.ArmRight01.rotateAngleX = -2.9671f;
                    this.ArmRight01.rotateAngleY = 0.0f;
                    this.ArmRight01.rotateAngleZ = -0.0349f;
                    this.ArmRight02.rotateAngleZ = -1.3962f;
                    this.BagStrap1.rotateAngleX = 0.2618f;
                    this.BagStrap1.rotateAngleY = -0.1396f;
                    this.BagStrap1.rotateAngleZ = -0.1745f;
                    this.BagStrap2.rotateAngleX = 0.3491f;
                    this.BagStrap2.rotateAngleY = 0.3491f;
                    addk1 = -0.3491f;
                    addk2 = -0.3491f;
                    this.LegLeft.rotateAngleY = 0.0f;
                    this.LegRight.rotateAngleY = 0.0f;
                    this.TailBase.rotateAngleX = -0.7f;
                    this.TailBase.rotateAngleY = MathHelper.cos(-f2 * 0.1f) * 0.1f;
                    this.TailBase.rotateAngleZ = MathHelper.cos(-f2 * 0.1f) * 0.05f;
                    this.Tail1.rotateAngleX = 0.35f;
                    this.Tail1.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 0.7f) * 0.2f;
                    this.Tail1.rotateAngleZ = -MathHelper.cos(-f2 * 0.1f + 0.7f) * 0.05f;
                    this.Tail2.rotateAngleX = 0.35f;
                    this.Tail2.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 1.4f) * 0.3f;
                    this.Tail2.rotateAngleZ = -MathHelper.cos(-f2 * 0.1f + 1.4f) * 0.05f;
                    this.Tail3.rotateAngleX = 0.35f;
                    this.Tail3.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 2.1f) * 0.4f;
                    this.Tail3.rotateAngleZ = -MathHelper.cos(-f2 * 0.1f + 2.1f) * 0.05f;
                    this.Tail4.rotateAngleX = -0.2618f;
                    this.Tail4.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 2.8f) * 0.5f;
                    this.Tail4.rotateAngleZ = MathHelper.cos(-f2 * 0.1f + 2.8f) * 0.025f;
                    this.Tail5.rotateAngleX = -0.35f;
                    this.Tail5.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 3.5f) * 0.55f;
                    this.Tail5.rotateAngleZ = MathHelper.cos(-f2 * 0.1f + 3.5f) * 0.05f;
                    this.Tail6.rotateAngleX = -0.35f;
                    this.Tail6.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 4.2f) * 0.6f;
                    this.Tail6.rotateAngleZ = MathHelper.cos(-f2 * 0.1f + 4.2f) * 0.05f;
                    this.TailHeadBase.rotateAngleX = -0.15f;
                    this.TailHeadBase.rotateAngleY = MathHelper.cos(-f2 * 0.1f + 4.9f) * 0.65f;
                    this.TailHeadBase.rotateAngleZ = MathHelper.cos(-f2 * 0.1f + 4.9f) * 0.025f;
                    this.TailHead1.rotateAngleX = 0.2618f;
                    this.TailJaw1.rotateAngleX = angleX * 0.1f - 0.15f;
                }
            } else {
                this.setFace(1);
                GlStateManager.translate(0.0f, 0.17f, 0.0f);
                this.ArmLeft01.rotateAngleX = -1.7f;
                this.ArmLeft01.rotateAngleY = -0.1f;
                this.ArmLeft01.rotateAngleZ = 0.0f;
                this.ArmRight01.rotateAngleX = -1.8f;
                this.ArmRight01.rotateAngleY = 0.1f;
                this.ArmRight01.rotateAngleZ = 0.0f;
                this.Head.rotateAngleX = -1.5f;
                this.Head.rotateAngleY = 0.0f;
                this.Head.rotateAngleZ = 0.7f;
                this.Cap2.rotateAngleX = -1.74f;
                this.BodyMain.rotateAngleX = 1.8f;
                this.Cloth2.rotateAngleX = -0.3491f;
                addk1 = -1.8f;
                addk2 = -1.8f;
                this.LegLeft.rotateAngleY = -0.23f;
                this.LegRight.rotateAngleY = 0.23f;
                this.BagStrap1.rotateAngleX = 0.2618f;
                this.BagStrap1.rotateAngleY = 0.0f;
                this.BagStrap1.rotateAngleZ = 0.0f;
                this.BagStrap2.rotateAngleX = 0.3491f;
                this.BagStrap2.rotateAngleY = 0.3491f;
                this.TailBase.rotateAngleX = 1.6f;
                this.TailBase.rotateAngleY = 0.0f;
                this.TailBase.rotateAngleZ = 3.1415f;
                this.Tail1.rotateAngleX = 0.8f;
                this.Tail1.rotateAngleY = 0.0f;
                this.Tail1.rotateAngleZ = 0.0f;
                this.Tail2.rotateAngleX = 0.8f;
                this.Tail2.rotateAngleY = 0.0f;
                this.Tail2.rotateAngleZ = 0.0f;
                this.Tail3.rotateAngleX = 0.9f;
                this.Tail3.rotateAngleY = 0.0f;
                this.Tail3.rotateAngleZ = 0.0f;
                this.Tail4.rotateAngleX = 0.9f;
                this.Tail4.rotateAngleY = 0.0f;
                this.Tail4.rotateAngleZ = 0.0f;
                this.Tail5.rotateAngleX = 0.4f;
                this.Tail5.rotateAngleY = 0.0f;
                this.Tail5.rotateAngleZ = 0.0f;
                this.Tail6.rotateAngleX = -0.4f;
                this.Tail6.rotateAngleY = 0.0f;
                this.Tail6.rotateAngleZ = 0.0f;
                this.TailHeadBase.rotateAngleX = -0.3f;
                this.TailHeadBase.rotateAngleY = 0.0f;
                this.TailHeadBase.rotateAngleZ = 0.8f;
                this.TailHead1.rotateAngleX = 0.1745f;
                this.TailJaw1.rotateAngleX = -0.5f;
            }
        }
        if (ent.getAttackTick() > 0) {
            GlStateManager.translate(0.0f, 0.13f, 0.0f);
            this.ArmLeft01.rotateAngleX = 0.5236f;
            this.ArmLeft01.rotateAngleY = 0.0f;
            this.ArmLeft01.rotateAngleZ = -0.5236f;
            this.ArmRight01.rotateAngleX = -2.7925f;
            this.ArmRight01.rotateAngleY = 0.0f;
            this.ArmRight01.rotateAngleZ = -0.2618f;
            this.Head.rotateAngleX = -1.2217f;
            this.Head.rotateAngleY = 0.0f;
            this.BodyMain.rotateAngleX = 1.0472f;
            this.Cloth2.rotateAngleX = -0.5236f;
            addk1 -= 1.48f;
            addk2 -= 0.26f;
            this.LegLeft.rotateAngleY = 0.0f;
            this.LegRight.rotateAngleY = 0.0f;
            this.BagStrap1.rotateAngleX = 0.15f;
            this.BagStrap1.rotateAngleY = -1.0472f;
            this.BagStrap1.rotateAngleZ = 0.0f;
            this.BagStrap2.rotateAngleX = 0.3491f;
            this.BagStrap2.rotateAngleY = 0.3491f;
            this.TailBase.rotateAngleX = 0.6f;
            this.TailBase.rotateAngleY = 0.0f;
            this.TailBase.rotateAngleZ = 3.1416f;
            this.Tail1.rotateAngleX = -0.2618f;
            this.Tail1.rotateAngleY = 0.0f;
            this.Tail1.rotateAngleZ = 0.0f;
            this.Tail2.rotateAngleX = -0.5236f;
            this.Tail2.rotateAngleY = 0.0f;
            this.Tail2.rotateAngleZ = 0.0f;
            this.Tail3.rotateAngleX = -0.2618f;
            this.Tail3.rotateAngleY = 0.0f;
            this.Tail3.rotateAngleZ = 0.0f;
            this.Tail4.rotateAngleX = -0.2618f;
            this.Tail4.rotateAngleY = 0.0f;
            this.Tail4.rotateAngleZ = 0.0f;
            this.Tail5.rotateAngleX = -0.5236f;
            this.Tail5.rotateAngleY = 0.0f;
            this.Tail5.rotateAngleZ = 0.0f;
            this.Tail6.rotateAngleX = -0.5236f;
            this.Tail6.rotateAngleY = 0.0f;
            this.Tail6.rotateAngleZ = 0.0f;
            this.TailHeadBase.rotateAngleX = -0.2618f;
            this.TailHeadBase.rotateAngleY = 0.0f;
            this.TailHeadBase.rotateAngleZ = 0.0f;
            if (ent.getAttackTick() > 47) {
                this.TailHead1.rotateAngleX = (50 - ent.getAttackTick()) * 0.15f + 0.4f;
                this.TailJaw1.rotateAngleX = (ent.getAttackTick() - 50) * 0.15f - 0.4f;
            } else if (ent.getAttackTick() > 39) {
                this.TailHead1.rotateAngleX = 0.76f - (46 - ent.getAttackTick()) * 0.06f;
                this.TailJaw1.rotateAngleX = -0.76f + (46 - ent.getAttackTick()) * 0.06f;
            } else {
                this.TailHead1.rotateAngleX = 0.4f;
                this.TailJaw1.rotateAngleX = -0.4f;
            }
        }
        if ((f6 = ent.getSwingTime(f2 - ((int)f2))) != 0.0f) {
            float f7 = MathHelper.sin(f6 * f6 * (float)Math.PI);
            float f8 = MathHelper.sin(MathHelper.sqrt(f6) * (float)Math.PI);
            this.ArmRight01.rotateAngleX = -0.6f;
            this.ArmRight01.rotateAngleY = 0.0f;
            this.ArmRight01.rotateAngleZ = 0.2f;
            this.ArmRight01.rotateAngleX += -f8 * 80.0f * ((float)Math.PI / 180);
            this.ArmRight01.rotateAngleY += -f7 * 20.0f * ((float)Math.PI / 180) + 0.2f;
            this.ArmRight01.rotateAngleZ += -f8 * 20.0f * ((float)Math.PI / 180);
        }
        this.LegLeft.rotateAngleX = addk1;
        this.LegRight.rotateAngleX = addk2;
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
                this.setMouth(5);
            }
        } else {
            this.setFace(7);
            if (t < 190) {
                this.setMouth(2);
            } else {
                this.setMouth(5);
            }
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
                this.setMouth(4);
            }
        } else if (t < 320) {
            this.setFace(2);
            if (t < 220) {
                this.setMouth(3);
            } else {
                this.setMouth(1);
            }
        } else if (t < 410) {
            this.setFace(3);
            if (t < 360) {
                this.setMouth(5);
            } else {
                this.setMouth(4);
            }
        } else {
            this.setFace(5);
            if (t < 470) {
                this.setMouth(4);
            } else {
                this.setMouth(5);
            }
        }
    }

    @Override
    public void setFaceDamaged(IShipEmotion ent) {
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0x1FF;
        if (t < 200) {
            this.setFace(6);
            if (t < 60) {
                this.setMouth(4);
            } else {
                this.setMouth(5);
            }
        } else if (t < 400) {
            this.setFace(3);
            if (t < 250) {
                this.setMouth(4);
            } else {
                this.setMouth(5);
            }
        } else {
            this.setFace(9);
            if (t < 450) {
                this.setMouth(4);
            } else {
                this.setMouth(5);
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
        this.setMouth(5);
    }

    @Override
    public void setFaceAngry(IShipEmotion ent) {
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0xFF;
        if (t < 128) {
            this.setFace(1);
            if (t < 64) {
                this.setMouth(3);
            } else {
                this.setMouth(4);
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
                this.setMouth(4);
            }
        } else if (t < 340) {
            this.setFace(8);
            if (t < 250) {
                this.setMouth(0);
            } else {
                this.setMouth(4);
            }
        } else {
            this.setFace(0);
            if (t < 420) {
                this.setMouth(3);
            } else {
                this.setMouth(4);
            }
        }
    }

    @Override
    public void setFaceShy(IShipEmotion ent) {
        this.setFlush(true);
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0xFF;
        this.setFace(0);
        if (t < 150) {
            this.setMouth(2);
        } else {
            this.setMouth(4);
        }
    }

    @Override
    public void setFaceHappy(IShipEmotion ent) {
        this.setFlush(true);
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0xFF;
        if (t < 140) {
            this.setFace(3);
            if (t < 80) {
                this.setMouth(4);
            } else {
                this.setMouth(5);
            }
        } else {
            this.setFace(8);
            this.setMouth(4);
        }
    }
}
