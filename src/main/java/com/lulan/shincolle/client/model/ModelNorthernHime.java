package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.entity.other.EntitySeat;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelNorthernHime
extends ShipModelBaseAdv {
    private final ModelRenderer BodyMain;
    private final ModelRenderer ArmLeft01;
    private final ModelRenderer ArmRight01;
    private final ModelRenderer Butt;
    private final ModelRenderer EquipBase;
    private final ModelRenderer Cloth01;
    private final ModelRenderer Neck;
    private final ModelRenderer ArmLeft02;
    private final ModelRenderer ArmLeft03;
    private final ModelRenderer ArmLeft04;
    private final ModelRenderer ArmLeft05;
    private final ModelRenderer ArmLeft06;
    private final ModelRenderer EquipUmbre01a;
    private final ModelRenderer EquipUmbre01b;
    private final ModelRenderer EquipUmbre02;
    private final ModelRenderer EquipUmbre01c;
    private final ModelRenderer EquipUmbre02a;
    private final ModelRenderer EquipUmbre03a;
    private final ModelRenderer EquipUmbre02b;
    private final ModelRenderer EquipUmbre03b;
    private final ModelRenderer ArmRight02;
    private final ModelRenderer ArmRight03;
    private final ModelRenderer ArmRight04;
    private final ModelRenderer ArmRight05;
    private final ModelRenderer ArmRight06;
    private final ModelRenderer LegRight01;
    private final ModelRenderer ArmRightItem;
    private final ModelRenderer LegLeft01;
    private final ModelRenderer LegRight02;
    private final ModelRenderer ShoesR;
    private final ModelRenderer LegLeft02;
    private final ModelRenderer ShoesL2;
    private final ModelRenderer ShoesL;
    private final ModelRenderer EquipRT01;
    private final ModelRenderer EquipLT01;
    private final ModelRenderer EquipRT02;
    private final ModelRenderer HeadBase;
    private final ModelRenderer TailJaw1;
    private final ModelRenderer TailHead1;
    private final ModelRenderer TailHeadCL1;
    private final ModelRenderer TailHeadCR1;
    private final ModelRenderer EquipRoad01;
    private final ModelRenderer TailJawT01;
    private final ModelRenderer TailHead2;
    private final ModelRenderer TailHeadT01;
    private final ModelRenderer TailHeadC2;
    private final ModelRenderer TailHeadC3;
    private final ModelRenderer EquipRoad02;
    private final ModelRenderer EquipRoad03;
    private final ModelRenderer EquipLT02;
    private final ModelRenderer EquipLT03;
    private final ModelRenderer EquipLT04;
    private final ModelRenderer EquipLT05;
    private final ModelRenderer EquipLT06;
    private final ModelRenderer EquipLHead;
    private final ModelRenderer EquipLHead01;
    private final ModelRenderer EquipLHead02;
    private final ModelRenderer EquipLHead03;
    private final ModelRenderer Cloth02;
    private final ModelRenderer Cloth03;
    private final ModelRenderer SantaCloth01;
    private final ModelRenderer Head;
    private final ModelRenderer Hair;
    private final ModelRenderer HairMain;
    private final ModelRenderer HeadHL;
    private final ModelRenderer HeadHR;
    private final ModelRenderer SantaHat01;
    private final ModelRenderer Ahoke;
    private final ModelRenderer HairL01;
    private final ModelRenderer HairR01;
    private final ModelRenderer HairL02;
    private final ModelRenderer HairR02;
    private final ModelRenderer Hair01;
    private final ModelRenderer Hair02;
    private final ModelRenderer HeadHL2;
    private final ModelRenderer HeadHL3;
    private final ModelRenderer HeadHR2;
    private final ModelRenderer HeadHR3;
    private final ModelRenderer SantaHat02;
    private final ModelRenderer SantaHat03;
    private final ModelRenderer SantaHat04;
    private final ModelRenderer SantaHat05;
    private final ModelRenderer HairS01a;
    private final ModelRenderer HairS01b;
    private final ModelRenderer HairS02a;
    private final ModelRenderer HairS02b;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowNeck;
    private final ModelRenderer GlowHead;
    private final ModelRenderer GlowEquipBase;
    private final ModelRenderer GlowEquipRT01;
    private final ModelRenderer GlowEquipRT02;
    private final ModelRenderer GlowHeadBase;
    private final ModelRenderer GlowTailHead1;
    private final ModelRenderer GlowTailJaw1;
    private final ModelRenderer GlowTailHead2;
    private final ModelRenderer GlowEquipLT01;
    private final ModelRenderer GlowEquipLT02;
    private final ModelRenderer GlowEquipLT03;
    private final ModelRenderer GlowEquipLT04;
    private final ModelRenderer GlowEquipLT05;
    private final ModelRenderer GlowEquipLT06;
    protected float[] offsetItem2 = new float[]{0.05f, 1.0f, -0.14f};
    protected float[] offsetBlock2 = new float[]{0.1f, 1.13f, 0.1f};
    protected float[] rotateItem2 = new float[]{-30.0f, 30.0f, -60.0f};

    public ModelNorthernHime() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.scale = 0.34f;
        this.offsetY = 3.08f;
        this.offsetItem = new float[]{0.07f, 1.02f, -0.05f};
        this.offsetBlock = new float[]{0.1f, 1.03f, 0.0f};
        this.setDefaultFaceModel();
        this.Cloth01 = new ModelRenderer(this, 128, 75);
        this.Cloth01.setRotationPoint(0.0f, -5.0f, -4.4f);
        this.Cloth01.addBox(-7.0f, 0.0f, 0.0f, 14, 4, 8, 0.0f);
        this.EquipUmbre03b = new ModelRenderer(this, 54, 0);
        this.EquipUmbre03b.setRotationPoint(1.5f, 2.0f, 2.9f);
        this.EquipUmbre03b.addBox(-2.0f, -6.0f, 0.0f, 5, 12, 11, 0.0f);
        this.setRotateAngle(this.EquipUmbre03b, -0.091106184f, 0.68294734f, 0.13665928f);
        this.ShoesR = new ModelRenderer(this, 80, 45);
        this.ShoesR.setRotationPoint(0.0f, 4.0f, 2.5f);
        this.ShoesR.addBox(-3.0f, 0.0f, -3.0f, 6, 2, 6, 0.0f);
        this.EquipLT06 = new ModelRenderer(this, 0, 45);
        this.EquipLT06.setRotationPoint(6.0f, 0.0f, 0.0f);
        this.EquipLT06.addBox(0.0f, -2.5f, -2.5f, 6, 5, 5, 0.0f);
        this.setRotateAngle(this.EquipLT06, 0.0f, 0.34906584f, -0.2617994f);
        this.HairMain = new ModelRenderer(this, 48, 55);
        this.HairMain.setRotationPoint(0.0f, -15.0f, -3.0f);
        this.HairMain.addBox(-7.5f, 0.0f, 0.0f, 15, 12, 10, 0.0f);
        this.ShoesL = new ModelRenderer(this, 80, 45);
        this.ShoesL.mirror = true;
        this.ShoesL.setRotationPoint(0.0f, 4.0f, 2.5f);
        this.ShoesL.addBox(-3.0f, 0.0f, -3.0f, 6, 2, 6, 0.0f);
        this.EquipLT02 = new ModelRenderer(this, 0, 45);
        this.EquipLT02.setRotationPoint(6.0f, 0.0f, 0.0f);
        this.EquipLT02.addBox(0.0f, -2.5f, -2.5f, 6, 5, 5, 0.0f);
        this.setRotateAngle(this.EquipLT02, 0.0f, 0.34906584f, -0.2617994f);
        this.TailJawT01 = new ModelRenderer(this, 0, 56);
        this.TailJawT01.setRotationPoint(0.0f, -3.0f, 4.0f);
        this.TailJawT01.addBox(-5.5f, 0.0f, 0.0f, 11, 5, 9, 0.0f);
        this.setRotateAngle(this.TailJawT01, 0.17453292f, 0.0f, 0.0f);
        this.LegLeft02 = new ModelRenderer(this, 0, 99);
        this.LegLeft02.mirror = true;
        this.LegLeft02.setRotationPoint(0.0f, 8.0f, -2.5f);
        this.LegLeft02.addBox(-2.5f, 0.0f, 0.0f, 5, 9, 5, 0.0f);
        this.EquipLT05 = new ModelRenderer(this, 0, 45);
        this.EquipLT05.setRotationPoint(6.0f, 0.0f, 0.0f);
        this.EquipLT05.addBox(0.0f, -2.5f, -2.5f, 6, 5, 5, 0.0f);
        this.setRotateAngle(this.EquipLT05, 0.0f, 0.34906584f, -0.2617994f);
        this.SantaCloth01 = new ModelRenderer(this, 128, 114);
        this.SantaCloth01.setRotationPoint(0.0f, 3.0f, -0.3f);
        this.SantaCloth01.addBox(-8.5f, 0.0f, 0.0f, 17, 2, 11, 0.0f);
        this.ArmLeft05 = new ModelRenderer(this, 20, 100);
        this.ArmLeft05.setRotationPoint(0.0f, 2.0f, 0.0f);
        this.ArmLeft05.addBox(-3.0f, 0.0f, -3.5f, 6, 7, 7, 0.0f);
        this.ArmRight06 = new ModelRenderer(this, 20, 100);
        this.ArmRight06.setRotationPoint(2.0f, 1.0f, -1.5f);
        this.ArmRight06.addBox(-1.5f, 0.0f, -3.0f, 3, 4, 3, 0.0f);
        this.setRotateAngle(this.ArmRight06, -0.08726646f, -0.08726646f, -0.17453292f);
        this.EquipLT01 = new ModelRenderer(this, 0, 45);
        this.EquipLT01.setRotationPoint(2.0f, 4.0f, 2.5f);
        this.EquipLT01.addBox(0.0f, -2.5f, -2.5f, 6, 5, 5, 0.0f);
        this.setRotateAngle(this.EquipLT01, 0.0f, -1.0471976f, -0.2617994f);
        this.Hair01 = new ModelRenderer(this, 1, 70);
        this.Hair01.setRotationPoint(0.0f, 9.0f, 2.0f);
        this.Hair01.addBox(-7.5f, 0.0f, 0.0f, 15, 12, 8, 0.0f);
        this.setRotateAngle(this.Hair01, 0.34906584f, 0.0f, 0.0f);
        this.HairS01a = new ModelRenderer(this, 38, 19);
        this.HairS01a.setRotationPoint(7.5f, -1.0f, 3.5f);
        this.HairS01a.addBox(0.0f, 0.0f, -2.0f, 0, 7, 4, 0.0f);
        this.setRotateAngle(this.HairS01a, 0.087f, 0.0f, -0.2618f);
        this.HairS01b = new ModelRenderer(this, 46, 26);
        this.HairS01b.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.HairS01b.addBox(0.0f, 0.0f, -2.0f, 0, 7, 4, 0.0f);
        this.setRotateAngle(this.HairS01b, 0.0f, 0.0f, -0.2618f);
        this.HairS02a = new ModelRenderer(this, 38, 19);
        this.HairS02a.setRotationPoint(-7.5f, 3.0f, 2.5f);
        this.HairS02a.addBox(0.0f, 0.0f, -2.0f, 0, 7, 4, 0.0f);
        this.setRotateAngle(this.HairS02a, 0.087f, 0.0f, 0.35f);
        this.HairS02b = new ModelRenderer(this, 38, 25);
        this.HairS02b.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.HairS02b.addBox(0.0f, 0.0f, -2.0f, 0, 7, 4, 0.0f);
        this.setRotateAngle(this.HairS02b, 0.0f, 0.0f, 0.35f);
        this.EquipUmbre03a = new ModelRenderer(this, 0, 0);
        this.EquipUmbre03a.setRotationPoint(0.0f, 0.0f, -14.4f);
        this.EquipUmbre03a.addBox(0.0f, -7.0f, 0.0f, 13, 17, 3, 0.0f);
        this.setRotateAngle(this.EquipUmbre03a, 0.0f, -0.2617994f, 0.3642502f);
        this.EquipRoad03 = new ModelRenderer(this, 46, 41);
        this.EquipRoad03.setRotationPoint(0.0f, 0.0f, 12.0f);
        this.EquipRoad03.addBox(0.0f, 0.0f, 0.0f, 7, 2, 12, 0.0f);
        this.ArmLeft04 = new ModelRenderer(this, 72, 43);
        this.ArmLeft04.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.ArmLeft04.addBox(-4.0f, 0.0f, -4.0f, 8, 2, 8, 0.0f);
        this.EquipLHead03 = new ModelRenderer(this, 24, 48);
        this.EquipLHead03.setRotationPoint(-11.5f, 0.0f, 0.0f);
        this.EquipLHead03.addBox(-5.0f, -1.5f, -1.0f, 6, 3, 2, 0.0f);
        this.setRotateAngle(this.EquipLHead03, 0.0f, 0.31869712f, 0.0f);
        this.SantaHat02 = new ModelRenderer(this, 58, 24);
        this.SantaHat02.setRotationPoint(0.0f, 3.0f, -0.5f);
        this.SantaHat02.addBox(-4.5f, -8.0f, -4.5f, 9, 7, 8, 0.0f);
        this.setRotateAngle(this.SantaHat02, -0.5235988f, 0.17453292f, 0.0f);
        this.Neck = new ModelRenderer(this, 129, 58);
        this.Neck.setRotationPoint(0.0f, -11.3f, -0.5f);
        this.Neck.addBox(-7.0f, -2.0f, -6.0f, 14, 3, 12, 0.0f);
        this.setRotateAngle(this.Neck, 0.05235988f, 0.0f, 0.0f);
        this.ArmLeft02 = new ModelRenderer(this, 2, 100);
        this.ArmLeft02.mirror = true;
        this.ArmLeft02.setRotationPoint(1.0f, 4.0f, 2.0f);
        this.ArmLeft02.addBox(-2.0f, 0.0f, -4.0f, 4, 4, 4, 0.0f);
        this.EquipLT03 = new ModelRenderer(this, 0, 45);
        this.EquipLT03.setRotationPoint(6.0f, 0.0f, 0.0f);
        this.EquipLT03.addBox(0.0f, -2.5f, -2.5f, 6, 5, 5, 0.0f);
        this.setRotateAngle(this.EquipLT03, 0.0f, 0.34906584f, -0.2617994f);
        this.HeadHL3 = new ModelRenderer(this, 30, 90);
        this.HeadHL3.setRotationPoint(1.0f, 0.0f, 0.0f);
        this.HeadHL3.addBox(0.0f, -1.5f, -1.5f, 1, 3, 3, 0.0f);
        this.HairR02 = new ModelRenderer(this, 86, 102);
        this.HairR02.mirror = true;
        this.HairR02.setRotationPoint(0.2f, 7.5f, 0.0f);
        this.HairR02.addBox(-1.0f, 0.0f, 0.0f, 2, 8, 4, 0.0f);
        this.setRotateAngle(this.HairR02, 0.2617994f, 0.0f, -0.05235988f);
        this.SantaHat04 = new ModelRenderer(this, 67, 28);
        this.SantaHat04.setRotationPoint(0.5f, -4.5f, 0.0f);
        this.SantaHat04.addBox(-2.0f, -6.0f, -2.0f, 4, 6, 4, 0.0f);
        this.setRotateAngle(this.SantaHat04, -1.1383038f, -0.27314404f, 0.0f);
        this.EquipUmbre01b = new ModelRenderer(this, 0, 0);
        this.EquipUmbre01b.setRotationPoint(0.0f, 0.0f, -6.0f);
        this.EquipUmbre01b.addBox(-1.0f, -1.0f, -12.0f, 2, 2, 12, 0.0f);
        this.SantaHat03 = new ModelRenderer(this, 65, 27);
        this.SantaHat03.setRotationPoint(0.0f, -5.0f, -1.0f);
        this.SantaHat03.addBox(-2.5f, -6.0f, -2.5f, 6, 6, 6, 0.0f);
        this.setRotateAngle(this.SantaHat03, -0.27314404f, 0.0f, -0.5009095f);
        this.EquipUmbre01c = new ModelRenderer(this, 0, 0);
        this.EquipUmbre01c.setRotationPoint(0.0f, 0.0f, -12.0f);
        this.EquipUmbre01c.addBox(-1.0f, -1.0f, -12.0f, 2, 2, 12, 0.0f);
        this.EquipUmbre02a = new ModelRenderer(this, 0, 0);
        this.EquipUmbre02a.setRotationPoint(-3.0f, 0.0f, -12.0f);
        this.EquipUmbre02a.addBox(-16.0f, -9.0f, -2.0f, 20, 18, 3, 0.0f);
        this.setRotateAngle(this.EquipUmbre02a, 0.0f, 0.17453292f, 0.5235988f);
        this.TailHead1 = new ModelRenderer(this, 0, 0);
        this.TailHead1.setRotationPoint(0.0f, -9.5f, 4.0f);
        this.TailHead1.addBox(-7.0f, -0.2f, -5.6f, 14, 8, 10, 0.0f);
        this.setRotateAngle(this.TailHead1, 0.17453292f, 0.0f, 0.0f);
        this.HeadHR = new ModelRenderer(this, 30, 90);
        this.HeadHR.mirror = true;
        this.HeadHR.setRotationPoint(-5.9f, -10.8f, 1.0f);
        this.HeadHR.addBox(-3.0f, -2.5f, -2.5f, 3, 5, 5, 0.0f);
        this.setRotateAngle(this.HeadHR, -0.7853982f, 0.17453292f, 0.31415927f);
        this.TailHeadC2 = new ModelRenderer(this, 0, 13);
        this.TailHeadC2.setRotationPoint(3.2f, 3.2f, 10.5f);
        this.TailHeadC2.addBox(-1.5f, -1.5f, 0.0f, 3, 3, 10, 0.0f);
        this.setRotateAngle(this.TailHeadC2, 0.08726646f, 0.08726646f, 0.017627826f);
        this.HeadHL = new ModelRenderer(this, 30, 90);
        this.HeadHL.mirror = true;
        this.HeadHL.setRotationPoint(5.9f, -10.9f, 1.0f);
        this.HeadHL.addBox(0.0f, -2.5f, -2.5f, 3, 5, 5, 0.0f);
        this.setRotateAngle(this.HeadHL, -0.7853982f, -0.17453292f, -0.31415927f);
        this.ArmLeft06 = new ModelRenderer(this, 20, 100);
        this.ArmLeft06.setRotationPoint(-2.0f, 1.0f, -1.5f);
        this.ArmLeft06.addBox(-1.5f, 0.0f, -3.0f, 3, 4, 3, 0.0f);
        this.setRotateAngle(this.ArmLeft06, -0.08726646f, 0.08726646f, 0.17453292f);
        this.LegRight01 = new ModelRenderer(this, 0, 99);
        this.LegRight01.setRotationPoint(-3.2f, 5.5f, 2.4f);
        this.LegRight01.addBox(-2.5f, 0.0f, -2.5f, 5, 8, 5, 0.0f);
        this.setRotateAngle(this.LegRight01, -0.17453292f, 0.0f, 0.05235988f);
        this.HeadBase = new ModelRenderer(this, 0, 0);
        this.HeadBase.setRotationPoint(-14.0f, -3.0f, 0.0f);
        this.HeadBase.addBox(-6.0f, -8.0f, 2.0f, 12, 15, 8, 0.0f);
        this.setRotateAngle(this.HeadBase, -0.43633232f, -2.7925267f, -0.13962634f);
        this.Hair02 = new ModelRenderer(this, 0, 70);
        this.Hair02.setRotationPoint(0.0f, 9.5f, 7.5f);
        this.Hair02.addBox(-8.0f, 0.0f, -8.0f, 16, 12, 8, 0.0f);
        this.setRotateAngle(this.Hair02, 0.13665928f, 0.0f, 0.0f);
        this.Butt = new ModelRenderer(this, 92, 28);
        this.Butt.setRotationPoint(0.0f, -2.0f, -4.0f);
        this.Butt.addBox(-5.5f, 0.0f, 0.0f, 11, 6, 7, 0.0f);
        this.setRotateAngle(this.Butt, 0.2617994f, 0.0f, 0.0f);
        this.TailHeadCR1 = new ModelRenderer(this, 0, 0);
        this.TailHeadCR1.mirror = true;
        this.TailHeadCR1.setRotationPoint(-6.0f, -5.0f, 12.0f);
        this.TailHeadCR1.addBox(-1.0f, 0.0f, -3.0f, 2, 11, 6, 0.0f);
        this.setRotateAngle(this.TailHeadCR1, 0.0f, -0.05235988f, 0.0f);
        this.EquipBase = new ModelRenderer(this, 0, 0);
        this.EquipBase.setRotationPoint(0.0f, -5.0f, 0.0f);
        this.EquipBase.addBox(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.Cloth02 = new ModelRenderer(this, 128, 87);
        this.Cloth02.setRotationPoint(0.0f, 3.0f, -0.3f);
        this.Cloth02.addBox(-7.5f, 0.0f, 0.0f, 15, 4, 9, 0.0f);
        this.setRotateAngle(this.Cloth02, 0.13962634f, 0.0f, 0.0f);
        this.EquipRoad01 = new ModelRenderer(this, 46, 41);
        this.EquipRoad01.setRotationPoint(6.0f, -11.5f, -3.0f);
        this.EquipRoad01.addBox(0.0f, 0.0f, 0.0f, 7, 2, 12, 0.0f);
        this.setRotateAngle(this.EquipRoad01, -0.20943952f, 0.08726646f, 0.0f);
        this.TailHeadC3 = new ModelRenderer(this, 0, 13);
        this.TailHeadC3.setRotationPoint(-3.2f, 3.2f, 10.5f);
        this.TailHeadC3.addBox(-1.5f, -1.5f, 0.0f, 3, 3, 10, 0.0f);
        this.setRotateAngle(this.TailHeadC3, 0.08726646f, -0.08726646f, 0.0f);
        this.Head = new ModelRenderer(this, 44, 101);
        this.Head.setRotationPoint(0.0f, -1.5f, 0.0f);
        this.Head.addBox(-7.0f, -14.5f, -6.5f, 14, 14, 13, 0.0f);
        this.HairR01 = new ModelRenderer(this, 86, 102);
        this.HairR01.mirror = true;
        this.HairR01.setRotationPoint(-6.5f, 3.0f, -4.5f);
        this.HairR01.addBox(-1.0f, 0.0f, 0.0f, 2, 8, 4, 0.0f);
        this.setRotateAngle(this.HairR01, -0.2617994f, 0.17453292f, 0.13962634f);
        this.EquipUmbre02b = new ModelRenderer(this, 54, 0);
        this.EquipUmbre02b.setRotationPoint(1.0f, 0.0f, 0.0f);
        this.EquipUmbre02b.addBox(-11.0f, -8.0f, 0.0f, 13, 16, 5, 0.0f);
        this.setRotateAngle(this.EquipUmbre02b, -0.05235988f, -0.08726646f, 0.0f);
        this.TailHead2 = new ModelRenderer(this, 0, 0);
        this.TailHead2.setRotationPoint(0.0f, -1.0f, 4.5f);
        this.TailHead2.addBox(-7.0f, 0.0f, 0.0f, 14, 8, 11, 0.0f);
        this.Hair = new ModelRenderer(this, 50, 77);
        this.Hair.setRotationPoint(0.0f, -7.5f, 0.0f);
        this.Hair.addBox(-8.0f, -8.0f, -7.2f, 16, 16, 8, 0.0f);
        this.TailJaw1 = new ModelRenderer(this, 0, 0);
        this.TailJaw1.setRotationPoint(0.0f, 3.0f, 5.0f);
        this.TailJaw1.addBox(-6.5f, 0.0f, 0.0f, 13, 5, 14, 0.0f);
        this.setRotateAngle(this.TailJaw1, -0.27314404f, 0.0f, 0.0f);
        this.TailHeadT01 = new ModelRenderer(this, 0, 55);
        this.TailHeadT01.setRotationPoint(0.0f, 4.5f, 4.5f);
        this.TailHeadT01.addBox(-6.0f, 0.0f, 0.0f, 12, 5, 10, 0.0f);
        this.setRotateAngle(this.TailHeadT01, -0.17453292f, 0.0f, 0.0f);
        this.TailHeadCL1 = new ModelRenderer(this, 0, 0);
        this.TailHeadCL1.setRotationPoint(6.0f, -5.0f, 12.0f);
        this.TailHeadCL1.addBox(-1.0f, 0.0f, -3.0f, 2, 11, 6, 0.0f);
        this.setRotateAngle(this.TailHeadCL1, 0.0f, 0.05235988f, 0.0f);
        this.ShoesL2 = new ModelRenderer(this, 80, 45);
        this.ShoesL2.setRotationPoint(0.0f, 4.0f, 0.0f);
        this.ShoesL2.addBox(-3.0f, 0.0f, -3.0f, 6, 2, 6, 0.0f);
        this.ArmRight04 = new ModelRenderer(this, 72, 43);
        this.ArmRight04.setRotationPoint(0.0f, 3.0f, 0.0f);
        this.ArmRight04.addBox(-4.0f, 0.0f, -4.0f, 8, 2, 8, 0.0f);
        this.SantaHat05 = new ModelRenderer(this, 0, 0);
        this.SantaHat05.setRotationPoint(2.0f, -5.8f, 2.0f);
        this.SantaHat05.addBox(-3.0f, -6.0f, -3.0f, 6, 6, 6, 0.0f);
        this.setRotateAngle(this.SantaHat05, 0.61086524f, 0.6981317f, -0.5235988f);
        this.EquipRT01 = new ModelRenderer(this, 0, 0);
        this.EquipRT01.setRotationPoint(0.0f, 4.0f, 4.0f);
        this.EquipRT01.addBox(-16.0f, -2.0f, -2.0f, 16, 4, 4, 0.0f);
        this.setRotateAngle(this.EquipRT01, 0.0f, 0.7853982f, 0.34906584f);
        this.EquipLHead = new ModelRenderer(this, 0, 29);
        this.EquipLHead.setRotationPoint(5.0f, 0.0f, -1.0f);
        this.EquipLHead.addBox(0.0f, -3.5f, -5.0f, 10, 7, 9, 0.0f);
        this.setRotateAngle(this.EquipLHead, 0.0f, -0.6981317f, -0.17453292f);
        this.EquipLHead02 = new ModelRenderer(this, 0, 0);
        this.EquipLHead02.setRotationPoint(-11.5f, 0.0f, 0.0f);
        this.EquipLHead02.addBox(-12.0f, -1.0f, 0.0f, 12, 2, 0, 0.0f);
        this.setRotateAngle(this.EquipLHead02, 0.0f, 0.5235988f, -0.2617994f);
        this.EquipUmbre02 = new ModelRenderer(this, 38, 57);
        this.EquipUmbre02.setRotationPoint(0.0f, 0.0f, 6.0f);
        this.EquipUmbre02.addBox(-2.5f, -1.0f, 0.0f, 5, 2, 5, 0.0f);
        this.Cloth03 = new ModelRenderer(this, 128, 100);
        this.Cloth03.setRotationPoint(0.0f, 3.0f, -0.2f);
        this.Cloth03.addBox(-8.0f, 0.0f, 0.0f, 16, 4, 10, 0.0f);
        this.setRotateAngle(this.Cloth03, 0.13962634f, 0.0f, 0.0f);
        this.BodyMain = new ModelRenderer(this, 0, 114);
        this.BodyMain.setRotationPoint(0.0f, 2.0f, 0.0f);
        this.BodyMain.addBox(-6.5f, -11.0f, -4.0f, 13, 7, 7, 0.0f);
        this.setRotateAngle(this.BodyMain, -0.08726646f, 0.0f, 0.0f);
        this.Ahoke = new ModelRenderer(this, 104, 29);
        this.Ahoke.setRotationPoint(0.0f, -5.0f, -5.0f);
        this.Ahoke.addBox(0.0f, -12.0f, -6.0f, 0, 12, 12, 0.0f);
        this.setRotateAngle(this.Ahoke, 0.35f, 2.1f, 0.0f);
        this.HeadHR2 = new ModelRenderer(this, 30, 90);
        this.HeadHR2.setRotationPoint(-3.0f, 0.0f, 0.0f);
        this.HeadHR2.addBox(-1.0f, -2.0f, -2.0f, 1, 4, 4, 0.0f);
        this.ArmRight05 = new ModelRenderer(this, 20, 100);
        this.ArmRight05.setRotationPoint(0.0f, 2.0f, 0.0f);
        this.ArmRight05.addBox(-3.0f, 0.0f, -3.5f, 6, 7, 7, 0.0f);
        this.EquipLT04 = new ModelRenderer(this, 0, 45);
        this.EquipLT04.setRotationPoint(6.0f, 0.0f, 0.0f);
        this.EquipLT04.addBox(0.0f, -2.5f, -2.5f, 6, 5, 5, 0.0f);
        this.setRotateAngle(this.EquipLT04, 0.0f, 0.34906584f, -0.2617994f);
        this.ArmRight02 = new ModelRenderer(this, 2, 100);
        this.ArmRight02.setRotationPoint(-1.0f, 4.0f, 2.0f);
        this.ArmRight02.addBox(-2.0f, 0.0f, -4.0f, 4, 4, 4, 0.0f);
        this.EquipUmbre01a = new ModelRenderer(this, 0, 0);
        this.EquipUmbre01a.setRotationPoint(-1.0f, 4.0f, -1.0f);
        this.EquipUmbre01a.addBox(-1.0f, -1.0f, -6.0f, 2, 2, 12, 0.0f);
        this.HairL02 = new ModelRenderer(this, 86, 102);
        this.HairL02.setRotationPoint(-0.2f, 7.5f, 0.0f);
        this.HairL02.addBox(-1.0f, 0.0f, 0.0f, 2, 8, 4, 0.0f);
        this.setRotateAngle(this.HairL02, 0.2617994f, 0.0f, 0.08726646f);
        this.HairL01 = new ModelRenderer(this, 86, 102);
        this.HairL01.setRotationPoint(6.5f, 3.0f, -4.5f);
        this.HairL01.addBox(-1.0f, 0.0f, 0.0f, 2, 8, 4, 0.0f);
        this.setRotateAngle(this.HairL01, -0.2617994f, -0.17453292f, -0.13962634f);
        this.EquipLHead01 = new ModelRenderer(this, 0, 0);
        this.EquipLHead01.setRotationPoint(4.0f, 0.0f, -4.0f);
        this.EquipLHead01.addBox(-12.0f, -1.0f, 0.0f, 12, 2, 0, 0.0f);
        this.setRotateAngle(this.EquipLHead01, 0.0f, -0.5235988f, -0.34906584f);
        this.LegLeft01 = new ModelRenderer(this, 0, 99);
        this.LegLeft01.mirror = true;
        this.LegLeft01.setRotationPoint(3.2f, 5.5f, 2.4f);
        this.LegLeft01.addBox(-2.5f, 0.0f, -2.5f, 5, 8, 5, 0.0f);
        this.setRotateAngle(this.LegLeft01, -0.17453292f, 0.0f, -0.05235988f);
        this.HeadHR3 = new ModelRenderer(this, 30, 90);
        this.HeadHR3.setRotationPoint(-1.0f, 0.0f, 0.0f);
        this.HeadHR3.addBox(-1.0f, -1.5f, -1.5f, 1, 3, 3, 0.0f);
        this.EquipRoad02 = new ModelRenderer(this, 46, 41);
        this.EquipRoad02.setRotationPoint(0.0f, 0.0f, 12.0f);
        this.EquipRoad02.addBox(0.0f, 0.0f, 0.0f, 7, 2, 12, 0.0f);
        this.HeadHL2 = new ModelRenderer(this, 30, 90);
        this.HeadHL2.setRotationPoint(3.0f, 0.0f, 0.0f);
        this.HeadHL2.addBox(0.0f, -2.0f, -2.0f, 1, 4, 4, 0.0f);
        this.EquipRT02 = new ModelRenderer(this, 0, 0);
        this.EquipRT02.setRotationPoint(-16.0f, 0.0f, 2.0f);
        this.EquipRT02.addBox(-16.0f, -2.0f, -4.0f, 16, 4, 4, 0.0f);
        this.setRotateAngle(this.EquipRT02, 0.0f, -1.0471976f, 0.0f);
        this.LegRight02 = new ModelRenderer(this, 0, 99);
        this.LegRight02.setRotationPoint(0.0f, 8.0f, -2.5f);
        this.LegRight02.addBox(-2.5f, 0.0f, 0.0f, 5, 9, 5, 0.0f);
        this.SantaHat01 = new ModelRenderer(this, 0, 0);
        this.SantaHat01.setRotationPoint(4.0f, -16.5f, 3.0f);
        this.SantaHat01.addBox(-6.5f, 0.0f, -6.5f, 13, 3, 13, 0.0f);
        this.setRotateAngle(this.SantaHat01, -0.43633232f, 0.87266463f, -0.13962634f);
        this.ArmRight01 = new ModelRenderer(this, 2, 100);
        this.ArmRight01.setRotationPoint(-6.0f, -9.8f, -0.7f);
        this.ArmRight01.addBox(-3.0f, -1.0f, -2.0f, 4, 5, 4, 0.0f);
        this.setRotateAngle(this.ArmRight01, 0.2617994f, 0.0f, 0.5235988f);
        this.ArmLeft03 = new ModelRenderer(this, 0, 90);
        this.ArmLeft03.setRotationPoint(0.0f, 1.0f, -2.0f);
        this.ArmLeft03.addBox(-3.0f, 0.0f, -3.0f, 6, 3, 6, 0.0f);
        this.ArmLeft01 = new ModelRenderer(this, 2, 100);
        this.ArmLeft01.mirror = true;
        this.ArmLeft01.setRotationPoint(6.0f, -9.8f, -0.7f);
        this.ArmLeft01.addBox(-1.0f, -1.0f, -2.0f, 4, 5, 4, 0.0f);
        this.setRotateAngle(this.ArmLeft01, -0.27314404f, 0.0f, -0.5235988f);
        this.ArmRight03 = new ModelRenderer(this, 0, 90);
        this.ArmRight03.setRotationPoint(0.0f, 1.0f, -2.0f);
        this.ArmRight03.addBox(-3.0f, 0.0f, -3.0f, 6, 3, 6, 0.0f);
        this.ArmRightItem = new ModelRenderer(this, 0, 0);
        this.ArmRightItem.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.BodyMain.addChild(this.Cloth01);
        this.ArmRight05.addChild(this.ArmRightItem);
        this.EquipUmbre03a.addChild(this.EquipUmbre03b);
        this.LegRight02.addChild(this.ShoesR);
        this.EquipLT05.addChild(this.EquipLT06);
        this.Head.addChild(this.HairMain);
        this.LegLeft02.addChild(this.ShoesL);
        this.EquipLT01.addChild(this.EquipLT02);
        this.LegLeft01.addChild(this.LegLeft02);
        this.EquipLT04.addChild(this.EquipLT05);
        this.Cloth03.addChild(this.SantaCloth01);
        this.ArmLeft04.addChild(this.ArmLeft05);
        this.ArmRight05.addChild(this.ArmRight06);
        this.EquipBase.addChild(this.EquipLT01);
        this.HairMain.addChild(this.Hair01);
        this.EquipUmbre01c.addChild(this.EquipUmbre03a);
        this.ArmLeft03.addChild(this.ArmLeft04);
        this.EquipLHead02.addChild(this.EquipLHead03);
        this.SantaHat01.addChild(this.SantaHat02);
        this.BodyMain.addChild(this.Neck);
        this.ArmLeft01.addChild(this.ArmLeft02);
        this.EquipLT02.addChild(this.EquipLT03);
        this.HeadHL2.addChild(this.HeadHL3);
        this.HairR01.addChild(this.HairR02);
        this.SantaHat03.addChild(this.SantaHat04);
        this.EquipUmbre01a.addChild(this.EquipUmbre01b);
        this.SantaHat02.addChild(this.SantaHat03);
        this.EquipUmbre01b.addChild(this.EquipUmbre01c);
        this.EquipUmbre01c.addChild(this.EquipUmbre02a);
        this.HeadBase.addChild(this.TailHead1);
        this.ArmLeft05.addChild(this.ArmLeft06);
        this.Butt.addChild(this.LegRight01);
        this.EquipRT02.addChild(this.HeadBase);
        this.Hair01.addChild(this.Hair02);
        this.Hair01.addChild(this.HairS01a);
        this.Hair01.addChild(this.HairS02a);
        this.HairS01a.addChild(this.HairS01b);
        this.HairS02a.addChild(this.HairS02b);
        this.BodyMain.addChild(this.Butt);
        this.HeadBase.addChild(this.TailHeadCR1);
        this.BodyMain.addChild(this.EquipBase);
        this.Cloth01.addChild(this.Cloth02);
        this.Neck.addChild(this.Head);
        this.Hair.addChild(this.HairR01);
        this.EquipUmbre02a.addChild(this.EquipUmbre02b);
        this.TailHead1.addChild(this.TailHead2);
        this.Head.addChild(this.Hair);
        this.HeadBase.addChild(this.TailJaw1);
        this.HeadBase.addChild(this.TailHeadCL1);
        this.LegLeft01.addChild(this.ShoesL2);
        this.ArmRight03.addChild(this.ArmRight04);
        this.SantaHat04.addChild(this.SantaHat05);
        this.EquipBase.addChild(this.EquipRT01);
        this.EquipLHead01.addChild(this.EquipLHead02);
        this.EquipUmbre01a.addChild(this.EquipUmbre02);
        this.Cloth02.addChild(this.Cloth03);
        this.Hair.addChild(this.Ahoke);
        this.HeadHR.addChild(this.HeadHR2);
        this.ArmRight04.addChild(this.ArmRight05);
        this.EquipLT03.addChild(this.EquipLT04);
        this.ArmRight01.addChild(this.ArmRight02);
        this.ArmLeft05.addChild(this.EquipUmbre01a);
        this.HairL01.addChild(this.HairL02);
        this.Hair.addChild(this.HairL01);
        this.EquipLHead.addChild(this.EquipLHead01);
        this.Butt.addChild(this.LegLeft01);
        this.HeadHR2.addChild(this.HeadHR3);
        this.HeadHL.addChild(this.HeadHL2);
        this.EquipRT01.addChild(this.EquipRT02);
        this.LegRight01.addChild(this.LegRight02);
        this.Head.addChild(this.SantaHat01);
        this.BodyMain.addChild(this.ArmRight01);
        this.ArmLeft02.addChild(this.ArmLeft03);
        this.BodyMain.addChild(this.ArmLeft01);
        this.ArmRight02.addChild(this.ArmRight03);
        this.GlowBodyMain = new ModelRenderer(this, 0, 114);
        this.GlowBodyMain.setRotationPoint(0.0f, 2.0f, 0.0f);
        this.setRotateAngle(this.GlowBodyMain, -0.08726646f, 0.0f, 0.0f);
        this.GlowNeck = new ModelRenderer(this, 129, 58);
        this.GlowNeck.setRotationPoint(0.0f, -11.3f, -0.5f);
        this.setRotateAngle(this.GlowNeck, 0.05235988f, 0.0f, 0.0f);
        this.GlowHead = new ModelRenderer(this, 44, 101);
        this.GlowHead.setRotationPoint(0.0f, -1.5f, 0.0f);
        this.GlowEquipBase = new ModelRenderer(this, 0, 0);
        this.GlowEquipBase.setRotationPoint(0.0f, -5.0f, 0.0f);
        this.GlowEquipRT01 = new ModelRenderer(this, 0, 0);
        this.GlowEquipRT01.setRotationPoint(0.0f, 4.0f, 4.0f);
        this.setRotateAngle(this.GlowEquipRT01, 0.0f, 0.7853982f, 0.34906584f);
        this.GlowEquipRT02 = new ModelRenderer(this, 0, 0);
        this.GlowEquipRT02.setRotationPoint(-16.0f, 0.0f, 2.0f);
        this.setRotateAngle(this.GlowEquipRT02, 0.0f, -1.0471976f, 0.0f);
        this.GlowHeadBase = new ModelRenderer(this, 0, 0);
        this.GlowHeadBase.setRotationPoint(-14.0f, -3.0f, 0.0f);
        this.setRotateAngle(this.GlowHeadBase, -0.43633232f, -2.7925267f, -0.13962634f);
        this.GlowTailHead1 = new ModelRenderer(this, 0, 0);
        this.GlowTailHead1.setRotationPoint(0.0f, -9.5f, 4.0f);
        this.setRotateAngle(this.GlowTailHead1, 0.17453292f, 0.0f, 0.0f);
        this.GlowTailJaw1 = new ModelRenderer(this, 0, 0);
        this.GlowTailJaw1.setRotationPoint(0.0f, 3.0f, 5.0f);
        this.setRotateAngle(this.GlowTailJaw1, -0.27314404f, 0.0f, 0.0f);
        this.GlowTailHead2 = new ModelRenderer(this, 0, 0);
        this.GlowTailHead2.setRotationPoint(0.0f, -1.0f, 4.5f);
        this.GlowEquipLT01 = new ModelRenderer(this, 0, 45);
        this.GlowEquipLT01.setRotationPoint(2.0f, 4.0f, 2.5f);
        this.setRotateAngle(this.GlowEquipLT01, 0.0f, -1.0471976f, -0.2617994f);
        this.GlowEquipLT02 = new ModelRenderer(this, 0, 45);
        this.GlowEquipLT02.setRotationPoint(6.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.GlowEquipLT02, 0.0f, 0.34906584f, -0.2617994f);
        this.GlowEquipLT03 = new ModelRenderer(this, 0, 45);
        this.GlowEquipLT03.setRotationPoint(6.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.GlowEquipLT03, 0.0f, 0.34906584f, -0.2617994f);
        this.GlowEquipLT04 = new ModelRenderer(this, 0, 45);
        this.GlowEquipLT04.setRotationPoint(6.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.GlowEquipLT04, 0.0f, 0.34906584f, -0.2617994f);
        this.GlowEquipLT05 = new ModelRenderer(this, 0, 45);
        this.GlowEquipLT05.setRotationPoint(6.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.GlowEquipLT05, 0.0f, 0.34906584f, -0.2617994f);
        this.GlowEquipLT06 = new ModelRenderer(this, 0, 45);
        this.GlowEquipLT06.setRotationPoint(6.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.GlowEquipLT06, 0.0f, 0.34906584f, -0.2617994f);
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
        this.GlowHead.addChild(this.HeadHR);
        this.GlowHead.addChild(this.HeadHL);
        this.GlowBodyMain.addChild(this.GlowEquipBase);
        this.GlowEquipBase.addChild(this.GlowEquipRT01);
        this.GlowEquipRT01.addChild(this.GlowEquipRT02);
        this.GlowEquipRT02.addChild(this.GlowHeadBase);
        this.GlowHeadBase.addChild(this.GlowTailHead1);
        this.GlowTailHead1.addChild(this.TailHeadT01);
        this.GlowHeadBase.addChild(this.GlowTailJaw1);
        this.GlowTailJaw1.addChild(this.TailJawT01);
        this.GlowHeadBase.addChild(this.EquipRoad01);
        this.EquipRoad01.addChild(this.EquipRoad02);
        this.EquipRoad02.addChild(this.EquipRoad03);
        this.GlowTailHead1.addChild(this.GlowTailHead2);
        this.GlowTailHead2.addChild(this.TailHeadC2);
        this.GlowTailHead2.addChild(this.TailHeadC3);
        this.GlowEquipBase.addChild(this.GlowEquipLT01);
        this.GlowEquipLT01.addChild(this.GlowEquipLT02);
        this.GlowEquipLT02.addChild(this.GlowEquipLT03);
        this.GlowEquipLT03.addChild(this.GlowEquipLT04);
        this.GlowEquipLT04.addChild(this.GlowEquipLT05);
        this.GlowEquipLT05.addChild(this.GlowEquipLT06);
        this.GlowEquipLT06.addChild(this.EquipLHead);
        this.armMain = new ModelRenderer[]{this.BodyMain, this.ArmRight01, this.ArmRight02, this.ArmRight03, this.ArmRight04, this.ArmRight05};
        this.armOff = new ModelRenderer[]{this.BodyMain, this.ArmLeft01, this.ArmLeft02, this.ArmLeft03, this.ArmLeft04, this.ArmLeft05};
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
        GlStateManager.scale(0.36f, 0.34f, 0.36f);
        GlStateManager.translate(0.0f, 3.08f, 0.0f);
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
        this.GlowEquipBase.isHidden = flag = !EmotionHelper.checkModelState(0, state);
        this.EquipBase.isHidden = flag;
        this.SantaCloth01.isHidden = flag = !EmotionHelper.checkModelState(1, state);
        this.SantaHat01.isHidden = flag;
        this.EquipUmbre01a.isHidden = !EmotionHelper.checkModelState(2, state);
        this.ShoesL.isHidden = flag = !EmotionHelper.checkModelState(3, state);
        this.ShoesL2.isHidden = flag;
        this.ShoesR.isHidden = flag;
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
        this.GlowEquipBase.rotateAngleX = this.EquipBase.rotateAngleX;
        this.GlowTailJaw1.rotateAngleX = this.TailJaw1.rotateAngleX;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        GlStateManager.translate(0.0f, 0.24f, 0.0f);
        this.setFaceHungry(ent);
        this.Head.rotateAngleX = 0.5f;
        this.Head.rotateAngleY = 0.0f;
        this.BodyMain.rotateAngleX = -0.087f;
        this.Hair01.rotateAngleX = 0.2f;
        this.Hair02.rotateAngleX = -0.3f;
        this.HairL01.rotateAngleX = -0.26f;
        this.HairL02.rotateAngleX = 0.26f;
        this.HairR01.rotateAngleX = -0.26f;
        this.HairR02.rotateAngleX = 0.26f;
        this.ArmLeft01.rotateAngleX = 0.2618f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = -0.57f;
        this.ArmLeft02.rotateAngleX = 0.0f;
        this.ArmLeft02.offsetY = 0.0f;
        this.ArmLeft02.offsetZ = 0.0f;
        this.ArmLeft04.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleX = 0.2618f;
        this.ArmRight01.rotateAngleZ = 0.57f;
        this.ArmRight02.rotateAngleX = 0.0f;
        this.LegLeft01.rotateAngleX = -1.66f;
        this.LegLeft01.rotateAngleY = -0.2618f;
        this.LegLeft01.rotateAngleZ = -0.05f;
        this.LegLeft02.rotateAngleX = 0.0f;
        this.LegRight01.rotateAngleX = -1.66f;
        this.LegRight01.rotateAngleY = 0.2618f;
        this.LegRight01.rotateAngleZ = 0.05f;
        this.LegRight02.rotateAngleX = 0.0f;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float angleX = MathHelper.cos(f2 * 0.08f);
        float angleAdd1 = MathHelper.cos(f * 0.7f) * f1;
        float angleAdd2 = MathHelper.cos(f * 0.7f + (float)Math.PI) * f1;
        float addk1;
        float addk2;
        float headX;
        float headZ;
        int state = ent.getStateEmotion(0);
        boolean showCannon = EmotionHelper.checkModelState(0, state);
        boolean showUmbrella = EmotionHelper.checkModelState(2, state);
        if (ent.getShipDepth(0) > 0.0 || ent.getShipDepth(1) > 0.0) {
            GlStateManager.translate(0.0f, angleX * 0.05f + 0.025f, 0.0f);
        }
        addk1 = angleAdd1 - 0.1745f;
        addk2 = angleAdd2 - 0.1745f;
        this.Head.rotateAngleX = f4 * 0.014f;
        this.Head.rotateAngleY = f3 * 0.01f;
        headX = this.Head.rotateAngleX * -0.5f;
        this.Ahoke.rotateAngleX = angleX * 0.25f + 0.35f;
        this.BodyMain.rotateAngleX = -0.087f;
        this.Hair01.rotateAngleX = angleX * 0.02f + 0.35f + headX;
        this.Hair02.rotateAngleX = angleX * 0.04f + 0.14f + headX;
        this.HairL01.rotateAngleX = angleX * 0.02f + headX - 0.26f;
        this.HairL02.rotateAngleX = angleX * 0.02f + headX + 0.26f;
        this.HairR01.rotateAngleX = angleX * 0.02f + headX - 0.26f;
        this.HairR02.rotateAngleX = angleX * 0.02f + headX + 0.26f;
        this.ArmLeft01.rotateAngleX = angleAdd2 + 0.2618f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = -angleX * 0.1f - 0.5235f;
        this.ArmLeft02.rotateAngleX = 0.0f;
        this.ArmLeft02.offsetY = 0.0f;
        this.ArmLeft02.offsetZ = 0.0f;
        this.ArmLeft04.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleX = angleAdd1 + 0.2618f;
        this.ArmRight01.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleZ = angleX * 0.1f + 0.5235f;
        this.ArmRight02.rotateAngleX = 0.0f;
        this.ArmRight04.rotateAngleY = 0.0f;
        this.LegLeft01.rotateAngleY = 0.0f;
        this.LegLeft01.rotateAngleZ = -0.05f;
        this.LegLeft02.rotateAngleX = 0.0f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleZ = 0.05f;
        this.LegRight02.rotateAngleX = 0.0f;
        if (showCannon) {
            this.EquipBase.rotateAngleX = 0.0f;
            this.TailJaw1.rotateAngleX = angleX * 0.08f - 0.15f;
            this.TailHeadC2.rotateAngleX = angleX * 0.12f;
            this.TailHeadC3.rotateAngleX = -angleX * 0.08f + 0.1f;
            this.EquipLHead01.rotateAngleY = angleX * 0.1f - 0.5f;
            this.EquipLHead01.rotateAngleZ = -angleX * 0.1f - 0.1f;
            this.EquipLHead02.rotateAngleY = angleX * 0.3f + 0.1f;
            this.EquipLHead02.rotateAngleZ = -angleX * 0.3f;
        }
        if (showUmbrella) {
            this.ArmLeft01.rotateAngleX = 0.0f;
            this.ArmLeft01.rotateAngleY = -0.26f;
            this.ArmLeft01.rotateAngleZ = -0.52f;
            this.ArmLeft02.offsetY = 0.25f;
            this.ArmLeft02.rotateAngleX = -1.57f;
            this.ArmLeft04.rotateAngleY = -0.52f;
            this.EquipUmbre03b.rotateAngleY = angleX * 0.3f + 0.7f;
        }
        if (ent.getIsSprinting() || f1 > 0.9f) {
            this.setFace(3);
            this.ArmLeft01.rotateAngleZ = -1.0f;
            this.ArmRight01.rotateAngleX = -2.9f;
            this.ArmRight01.rotateAngleZ = -0.7f;
            if (showUmbrella) {
                this.ArmLeft04.rotateAngleY = -1.0f;
            }
        }
        this.Head.rotateAngleZ = EmotionHelper.getHeadTiltAngle(ent, f2);
        this.Hair01.rotateAngleZ = headZ = this.Head.rotateAngleZ * -0.5f;
        this.Hair02.rotateAngleZ = headZ;
        this.HairL01.rotateAngleZ = headZ - 0.14f;
        this.HairL02.rotateAngleZ = headZ + 0.087f;
        this.HairR01.rotateAngleZ = headZ + 0.14f;
        this.HairR02.rotateAngleZ = headZ - 0.052f;
        if (ent.getIsSneaking()) {
            GlStateManager.translate(0.0f, 0.02f, 0.0f);
            this.Head.rotateAngleX -= 0.8727f;
            this.BodyMain.rotateAngleX = 1.0472f;
            this.Hair01.rotateAngleX += 0.2236f;
            addk1 -= 1.2f;
            addk2 -= 1.2f;
            this.EquipBase.rotateAngleX -= 0.8727f;
            if (showUmbrella) {
                this.ArmLeft01.rotateAngleY = -1.05f;
                this.ArmLeft02.rotateAngleX = -2.01f;
                this.ArmLeft04.rotateAngleY = -1.05f;
            }
        }
        if ((ent.getIsSitting() && !ent.getIsRiding()) || (ent.getIsRiding() && ent.getRidingEntity() instanceof EntitySeat)) {
            GlStateManager.translate(0.0f, 0.24f, 0.0f);
            this.Head.rotateAngleY *= 0.25f;
            if (ent.getStateEmotion(1) == 4) {
                this.Head.rotateAngleX -= 0.15f;
                this.BodyMain.rotateAngleX = -0.3142f;
                this.ArmLeft01.rotateAngleX = -2.0f;
                this.ArmLeft01.rotateAngleY = -0.35f;
                this.ArmLeft01.rotateAngleZ = 0.35f;
                this.ArmRight01.rotateAngleX = -2.9f;
                this.ArmRight01.rotateAngleY = 0.35f;
                this.ArmRight01.rotateAngleZ = -0.35f;
                addk1 = -1.4f;
                addk2 = -1.4f;
                this.LegLeft01.rotateAngleY = -0.2618f;
                this.LegRight01.rotateAngleY = 0.2618f;
                this.ArmLeft02.offsetY = 0.0f;
                this.ArmLeft02.rotateAngleX = 0.0f;
                this.ArmLeft04.rotateAngleY = 0.0f;
            } else {
                this.ArmLeft01.rotateAngleZ -= 0.05f;
                this.ArmRight01.rotateAngleZ += 0.05f;
                addk1 = -1.66f;
                addk2 = -1.66f;
                this.LegLeft01.rotateAngleY = -0.2618f;
                this.LegRight01.rotateAngleY = 0.2618f;
                this.ArmLeft02.offsetY = 0.0f;
            }
        }
        if (ent.getIsRiding() && !(ent.getRidingEntity() instanceof EntitySeat)) {
            GlStateManager.translate(0.0f, 0.24f, 0.27f);
            if (ent.getIsSitting()) {
                this.ArmLeft01.rotateAngleX = -0.8f;
                this.ArmLeft01.rotateAngleZ = -0.35f;
                this.ArmRight01.rotateAngleX = -0.8f;
                this.ArmRight01.rotateAngleZ = 0.35f;
                addk1 = -1.66f;
                addk2 = -1.66f;
                this.LegLeft01.rotateAngleY = -0.5f;
                this.LegRight01.rotateAngleY = 0.5f;
                if (showUmbrella) {
                    this.ArmLeft02.offsetY = 0.0f;
                    this.ArmLeft02.rotateAngleX = -0.8f;
                    this.ArmLeft04.rotateAngleY = -0.4f;
                }
            } else {
                this.setFace(3);
                this.Head.rotateAngleX -= 0.25f;
                this.ArmLeft01.rotateAngleX = -1.2f;
                this.ArmLeft01.rotateAngleY = -0.2f;
                this.ArmLeft01.rotateAngleZ = -0.2f;
                this.ArmRight01.rotateAngleX = -2.53f;
                this.ArmRight01.rotateAngleZ = -0.7f;
                addk1 = -1.66f;
                addk2 = -1.66f;
                this.LegLeft01.rotateAngleY = -0.5f;
                this.LegRight01.rotateAngleY = 0.5f;
                if (showUmbrella) {
                    this.ArmLeft02.offsetY = 0.0f;
                    this.ArmLeft02.rotateAngleX = -0.2f;
                    this.ArmLeft04.rotateAngleY = -0.4f;
                }
            }
        }
        if (ent.getAttackTick() > 49) {
            this.ArmRight01.rotateAngleX = -3.5f;
            this.ArmRight01.rotateAngleY = 0.0f;
            this.ArmRight01.rotateAngleZ = -0.35f;
            this.ArmRight04.rotateAngleY = -1.57f;
        } else if (ent.getAttackTick() > 46) {
            this.ArmRight01.rotateAngleX = (46.0f - ent.getAttackTick() + (f2 - (int)f2)) * 0.75f - 0.5f;
            this.ArmRight01.rotateAngleY = 0.0f;
            this.ArmRight01.rotateAngleZ = -0.35f;
            this.ArmRight04.rotateAngleY = -1.57f;
        } else if (ent.getAttackTick() > 35) {
            this.ArmRight01.rotateAngleX = -0.5f;
            this.ArmRight01.rotateAngleY = 0.0f;
            this.ArmRight01.rotateAngleZ = 0.5f;
            this.ArmRight04.rotateAngleY = -1.57f;
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
                this.setMouth(5);
            }
        } else {
            this.setFace(7);
            this.setMouth(5);
        }
    }

    @Override
    public void setFaceAttack(IShipEmotion ent) {
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0x1FF;
        if (t < 160) {
            this.setFace(0);
            if (t < 80) {
                this.setMouth(4);
            } else {
                this.setMouth(3);
            }
        } else if (t < 320) {
            this.setFace(2);
            if (t < 220) {
                this.setMouth(0);
            } else {
                this.setMouth(3);
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
                this.setMouth(3);
            } else {
                this.setMouth(4);
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
                this.setMouth(3);
            } else {
                this.setMouth(5);
            }
        } else {
            this.setFace(9);
            if (t < 450) {
                this.setMouth(2);
            } else {
                this.setMouth(3);
            }
        }
    }

    @Override
    public void setFaceScorn(IShipEmotion ent) {
        this.setFace(2);
        this.setMouth(3);
    }

    @Override
    public void setFaceHungry(IShipEmotion ent) {
        this.setFace(4);
        this.setMouth(3);
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
                this.setMouth(0);
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
            this.setFace(5);
            if (t < 250) {
                this.setMouth(4);
            } else {
                this.setMouth(3);
            }
        } else {
            this.setFace(0);
            if (t < 420) {
                this.setMouth(4);
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
                this.setMouth(4);
            } else {
                this.setMouth(3);
            }
        } else {
            this.setFace(8);
            this.setMouth(3);
        }
    }

    @Override
    public float[] getHeldItemOffset(IShipEmotion ent, EnumHandSide side, int type) {
        if (side == EnumHandSide.RIGHT && (ent.getIsSprinting() || ent.getIsRiding())) {
            if (ent.getIsSprinting()) {
                this.offsetItem2[1] = 0.9f;
                this.offsetItem2[2] = -0.3f;
            } else if (ent.getIsRiding()) {
                this.offsetItem2[1] = 1.1f;
                this.offsetItem2[2] = -0.2f;
            }
            return type == 0 ? this.offsetItem2 : this.offsetBlock2;
        }
        return type == 0 ? this.offsetItem : this.offsetBlock;
    }

    @Override
    public float[] getHeldItemRotate(IShipEmotion ent, EnumHandSide side, int type) {
        if (side == EnumHandSide.RIGHT && (ent.getIsSprinting() || ent.getIsRiding())) {
            return type == 0 ? this.rotateItem2 : this.rotateBlock;
        }
        return type == 0 ? this.rotateItem : this.rotateBlock;
    }
}
