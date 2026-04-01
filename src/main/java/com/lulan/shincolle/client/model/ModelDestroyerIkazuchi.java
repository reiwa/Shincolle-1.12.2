package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.entity.destroyer.EntityDestroyerAkatsuki;
import com.lulan.shincolle.entity.destroyer.EntityDestroyerInazuma;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelDestroyerIkazuchi
extends ShipModelBaseAdv {
    private final ModelRenderer BodyMain;
    private final ModelRenderer Butt;
    private final ModelRenderer Head;
    private final ModelRenderer ArmLeft01;
    private final ModelRenderer ArmRight01;
    private final ModelRenderer Cloth01;
    private final ModelRenderer EquipBase;
    private final ModelRenderer LegRight01;
    private final ModelRenderer LegLeft01;
    private final ModelRenderer Skirt01;
    private final ModelRenderer LegRight02;
    private final ModelRenderer LegRight03;
    private final ModelRenderer LegLeft02;
    private final ModelRenderer LegLeft03;
    private final ModelRenderer Skirt02;
    private final ModelRenderer Hair;
    private final ModelRenderer HairMain;
    private final ModelRenderer Ahoke;
    private final ModelRenderer HairU01;
    private final ModelRenderer HairL01;
    private final ModelRenderer HairR01;
    private final ModelRenderer HairL02;
    private final ModelRenderer HairR02;
    private final ModelRenderer Hair01;
    private final ModelRenderer ArmLeft02;
    private final ModelRenderer ArmLeft03;
    private final ModelRenderer ArmRight02;
    private final ModelRenderer ArmRight03;
    private final ModelRenderer EquipHead01;
    private final ModelRenderer EquipHead02;
    private final ModelRenderer EquipHead03;
    private final ModelRenderer EquipHead04;
    private final ModelRenderer EquipHead05;
    private final ModelRenderer Cloth02;
    private final ModelRenderer EquipMain01;
    private final ModelRenderer EquipC01;
    private final ModelRenderer EquipMain02;
    private final ModelRenderer EquipMain03;
    private final ModelRenderer EquipMain04;
    private final ModelRenderer EquipTL02;
    private final ModelRenderer EquipTL02_1;
    private final ModelRenderer EquipTL02a;
    private final ModelRenderer EquipTL02b;
    private final ModelRenderer EquipTL02c;
    private final ModelRenderer EquipTL03;
    private final ModelRenderer EquipTL02d;
    private final ModelRenderer EquipTL02e;
    private final ModelRenderer EquipTL02f;
    private final ModelRenderer EquipTL02a_1;
    private final ModelRenderer EquipTL02b_1;
    private final ModelRenderer EquipTL02c_1;
    private final ModelRenderer EquipTL03_1;
    private final ModelRenderer EquipTL02d_1;
    private final ModelRenderer EquipTL02e_1;
    private final ModelRenderer EquipTL02f_1;
    private final ModelRenderer EquipC02;
    private final ModelRenderer EquipC03;
    private final ModelRenderer EquipC04a;
    private final ModelRenderer EquipC05a;
    private final ModelRenderer EquipC04b;
    private final ModelRenderer EquipC05b;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowHead;
    protected float[] offsetItem2 = new float[]{0.06f, 0.81f, -0.1f};

    public ModelDestroyerIkazuchi() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.offsetItem = new float[]{0.06f, 1.04f, -0.08f};
        this.offsetBlock = new float[]{0.06f, 1.04f, -0.08f};
        this.setDefaultFaceModel();
        this.ArmRight01 = new ModelRenderer(this, 0, 88);
        this.ArmRight01.setRotationPoint(-7.3f, -9.4f, -0.7f);
        this.ArmRight01.addBox(-3.5f, -1.0f, -3.0f, 6, 11, 6, 0.0f);
        this.setRotateAngle(this.ArmRight01, -0.06981317f, 0.0f, 0.34906584f);
        this.LegRight03 = new ModelRenderer(this, 30, 76);
        this.LegRight03.mirror = true;
        this.LegRight03.setRotationPoint(-3.0f, 8.0f, 2.9f);
        this.LegRight03.addBox(-3.5f, 0.0f, -3.5f, 7, 5, 7, 0.0f);
        this.EquipHead05 = new ModelRenderer(this, 0, 0);
        this.EquipHead05.setRotationPoint(0.0f, 0.0f, -2.0f);
        this.EquipHead05.addBox(-1.0f, -5.0f, 0.0f, 2, 10, 2, 0.0f);
        this.EquipC01 = new ModelRenderer(this, 0, 0);
        this.EquipC01.setRotationPoint(-7.0f, -11.0f, 9.0f);
        this.EquipC01.addBox(-2.0f, 0.0f, -2.0f, 4, 8, 4, 0.0f);
        this.BodyMain = new ModelRenderer(this, 0, 105);
        this.BodyMain.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.BodyMain.addBox(-6.5f, -11.0f, -4.0f, 13, 14, 7, 0.0f);
        this.setRotateAngle(this.BodyMain, -0.10471976f, 0.0f, 0.0f);
        this.EquipTL02_1 = new ModelRenderer(this, 0, 0);
        this.EquipTL02_1.setRotationPoint(-5.5f, 6.0f, 4.5f);
        this.EquipTL02_1.addBox(-3.0f, -4.0f, -9.0f, 3, 8, 12, 0.0f);
        this.setRotateAngle(this.EquipTL02_1, 0.13962634f, 0.06981317f, 0.0f);
        this.EquipTL02c_1 = new ModelRenderer(this, 0, 0);
        this.EquipTL02c_1.setRotationPoint(-1.3f, 2.3f, -18.8f);
        this.EquipTL02c_1.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 10, 0.0f);
        this.EquipC05a = new ModelRenderer(this, 0, 0);
        this.EquipC05a.setRotationPoint(1.5f, -3.0f, 0.0f);
        this.EquipC05a.addBox(-1.0f, -1.0f, -6.0f, 2, 2, 6, 0.0f);
        this.Hair = new ModelRenderer(this, 50, 81);
        this.Hair.setRotationPoint(0.0f, -7.5f, 0.3f);
        this.Hair.addBox(-8.0f, -8.0f, -7.4f, 16, 12, 8, 0.0f);
        this.ArmRight03 = new ModelRenderer(this, 36, 102);
        this.ArmRight03.setRotationPoint(3.0f, 6.0f, -3.0f);
        this.ArmRight03.addBox(-2.5f, 0.0f, -2.5f, 5, 5, 5, 0.0f);
        this.EquipTL02a_1 = new ModelRenderer(this, 0, 0);
        this.EquipTL02a_1.setRotationPoint(-1.3f, 0.0f, -19.8f);
        this.EquipTL02a_1.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 11, 0.0f);
        this.LegLeft03 = new ModelRenderer(this, 30, 76);
        this.LegLeft03.setRotationPoint(3.0f, 8.0f, 2.9f);
        this.LegLeft03.addBox(-3.5f, 0.0f, -3.5f, 7, 5, 7, 0.0f);
        this.LegRight02 = new ModelRenderer(this, 0, 72);
        this.LegRight02.setRotationPoint(3.0f, 12.0f, -3.0f);
        this.LegRight02.addBox(-6.0f, 0.0f, 0.0f, 6, 10, 6, 0.0f);
        this.EquipTL02c = new ModelRenderer(this, 0, 0);
        this.EquipTL02c.setRotationPoint(1.3f, 2.3f, -18.8f);
        this.EquipTL02c.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 10, 0.0f);
        this.EquipTL02b = new ModelRenderer(this, 0, 0);
        this.EquipTL02b.setRotationPoint(1.3f, -2.3f, -18.8f);
        this.EquipTL02b.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 10, 0.0f);
        this.EquipTL03 = new ModelRenderer(this, 36, 45);
        this.EquipTL03.setRotationPoint(3.0f, -12.0f, 3.0f);
        this.EquipTL03.addBox(0.0f, 0.0f, -8.0f, 1, 24, 7, 0.0f);
        this.setRotateAngle(this.EquipTL03, 0.0f, -0.34906584f, -0.08726646f);
        this.HairMain = new ModelRenderer(this, 46, 104);
        this.HairMain.setRotationPoint(0.0f, -14.8f, -3.0f);
        this.HairMain.addBox(-7.5f, 0.0f, 0.0f, 15, 11, 10, 0.0f);
        this.EquipTL02e = new ModelRenderer(this, 0, 0);
        this.EquipTL02e.setRotationPoint(1.3f, 0.0f, 2.5f);
        this.EquipTL02e.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2, 0.0f);
        this.EquipMain02 = new ModelRenderer(this, 46, 9);
        this.EquipMain02.setRotationPoint(0.0f, 7.7f, 0.6f);
        this.EquipMain02.addBox(-4.5f, 0.0f, 0.0f, 9, 7, 9, 0.0f);
        this.setRotateAngle(this.EquipMain02, 0.62831855f, 0.0f, 0.0f);
        this.EquipBase = new ModelRenderer(this, 0, 0);
        this.EquipBase.setRotationPoint(0.0f, -1.0f, 0.0f);
        this.EquipBase.addBox(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.Cloth01 = new ModelRenderer(this, 84, 31);
        this.Cloth01.setRotationPoint(0.0f, -11.6f, 0.0f);
        this.Cloth01.addBox(-7.0f, 0.0f, -4.4f, 14, 7, 8, 0.0f);
        this.EquipTL02d_1 = new ModelRenderer(this, 0, 0);
        this.EquipTL02d_1.setRotationPoint(-1.3f, -2.3f, 3.0f);
        this.EquipTL02d_1.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2, 0.0f);
        this.EquipHead01 = new ModelRenderer(this, 0, 0);
        this.EquipHead01.setRotationPoint(-0.5f, 3.0f, 0.0f);
        this.EquipHead01.addBox(0.0f, 0.0f, -12.0f, 2, 3, 18, 0.0f);
        this.setRotateAngle(this.EquipHead01, 0.3142f, 0.0f, 0.0f);
        this.EquipTL02f = new ModelRenderer(this, 0, 0);
        this.EquipTL02f.setRotationPoint(1.3f, 2.3f, 3.0f);
        this.EquipTL02f.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2, 0.0f);
        this.HairU01 = new ModelRenderer(this, 52, 45);
        this.HairU01.setRotationPoint(0.0f, -6.0f, -7.0f);
        this.HairU01.addBox(-8.5f, 0.0f, 0.0f, 17, 15, 6, 0.0f);
        this.EquipMain03 = new ModelRenderer(this, 59, 15);
        this.EquipMain03.setRotationPoint(0.0f, 9.5f, 9.0f);
        this.EquipMain03.addBox(-1.0f, 0.0f, -1.5f, 2, 6, 3, 0.0f);
        this.setRotateAngle(this.EquipMain03, 0.5009095f, 0.0f, 0.0f);
        this.LegRight01 = new ModelRenderer(this, 0, 59);
        this.LegRight01.setRotationPoint(-4.4f, 5.5f, 3.2f);
        this.LegRight01.addBox(-3.0f, 0.0f, -3.0f, 6, 12, 6, 0.0f);
        this.setRotateAngle(this.LegRight01, (float)(-Math.PI) / 90, 0.0f, -0.10471976f);
        this.EquipC02 = new ModelRenderer(this, 0, 0);
        this.EquipC02.setRotationPoint(-2.0f, 0.5f, 0.0f);
        this.EquipC02.addBox(-3.5f, -3.0f, -3.5f, 7, 3, 7, 0.0f);
        this.setRotateAngle(this.EquipC02, -0.17453292f, 0.62831855f, 0.0f);
        this.ArmLeft03 = new ModelRenderer(this, 36, 102);
        this.ArmLeft03.mirror = true;
        this.ArmLeft03.setRotationPoint(-3.0f, 6.0f, -3.0f);
        this.ArmLeft03.addBox(-2.5f, 0.0f, -2.5f, 5, 5, 5, 0.0f);
        this.EquipC04a = new ModelRenderer(this, 0, 0);
        this.EquipC04a.setRotationPoint(-1.5f, -3.0f, 0.0f);
        this.EquipC04a.addBox(-1.0f, -1.0f, -6.0f, 2, 2, 6, 0.0f);
        this.EquipTL02d = new ModelRenderer(this, 0, 0);
        this.EquipTL02d.setRotationPoint(1.3f, -2.3f, 3.0f);
        this.EquipTL02d.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2, 0.0f);
        this.HairR02 = new ModelRenderer(this, 88, 103);
        this.HairR02.setRotationPoint(-1.0f, 9.0f, 0.0f);
        this.HairR02.addBox(0.0f, 0.0f, 0.0f, 1, 7, 4, 0.0f);
        this.setRotateAngle(this.HairR02, 0.0f, 0.0f, -1.0471976f);
        this.EquipMain01 = new ModelRenderer(this, 0, 0);
        this.EquipMain01.setRotationPoint(0.0f, -4.0f, 5.0f);
        this.EquipMain01.addBox(-5.5f, -1.0f, 0.0f, 11, 9, 12, 0.0f);
        this.EquipTL02a = new ModelRenderer(this, 0, 0);
        this.EquipTL02a.setRotationPoint(1.3f, 0.0f, -19.8f);
        this.EquipTL02a.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 11, 0.0f);
        this.EquipTL02b_1 = new ModelRenderer(this, 0, 0);
        this.EquipTL02b_1.setRotationPoint(-1.3f, -2.3f, -18.8f);
        this.EquipTL02b_1.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 10, 0.0f);
        this.HairL02 = new ModelRenderer(this, 88, 103);
        this.HairL02.setRotationPoint(1.0f, 9.0f, 0.0f);
        this.HairL02.addBox(-1.0f, 0.0f, 0.0f, 1, 7, 4, 0.0f);
        this.setRotateAngle(this.HairL02, 0.0f, 0.0f, 1.0471976f);
        this.EquipHead02 = new ModelRenderer(this, 0, 0);
        this.EquipHead02.setRotationPoint(1.0f, 1.5f, -15.0f);
        this.EquipHead02.addBox(-1.5f, -7.0f, 0.0f, 3, 14, 3, 0.0f);
        this.Skirt01 = new ModelRenderer(this, 80, 16);
        this.Skirt01.setRotationPoint(0.0f, 1.7f, -0.4f);
        this.Skirt01.addBox(-7.5f, 0.0f, 0.0f, 15, 6, 9, 0.0f);
        this.setRotateAngle(this.Skirt01, -0.05235988f, 0.0f, 0.0f);
        this.HairL01 = new ModelRenderer(this, 88, 101);
        this.HairL01.setRotationPoint(7.0f, -1.0f, -4.7f);
        this.HairL01.addBox(0.0f, 0.0f, 0.0f, 1, 9, 4, 0.0f);
        this.setRotateAngle(this.HairL01, 0.57595867f, 0.2617994f, -0.2617994f);
        this.EquipC05b = new ModelRenderer(this, 0, 0);
        this.EquipC05b.setRotationPoint(0.0f, 0.0f, -6.0f);
        this.EquipC05b.addBox(-0.5f, -0.5f, -10.0f, 1, 1, 10, 0.0f);
        this.EquipC04b = new ModelRenderer(this, 0, 0);
        this.EquipC04b.setRotationPoint(0.0f, 0.0f, -6.0f);
        this.EquipC04b.addBox(-0.5f, -0.5f, -10.0f, 1, 1, 10, 0.0f);
        this.Skirt02 = new ModelRenderer(this, 76, 0);
        this.Skirt02.setRotationPoint(0.0f, 3.5f, -0.4f);
        this.Skirt02.addBox(-8.0f, 0.0f, 0.0f, 16, 6, 10, 0.0f);
        this.setRotateAngle(this.Skirt02, -0.05235988f, 0.0f, 0.0f);
        this.ArmLeft02 = new ModelRenderer(this, 24, 88);
        this.ArmLeft02.mirror = true;
        this.ArmLeft02.setRotationPoint(3.5f, 10.0f, 3.0f);
        this.ArmLeft02.addBox(-6.0f, 0.0f, -6.0f, 6, 8, 6, 0.0f);
        this.EquipTL02f_1 = new ModelRenderer(this, 0, 0);
        this.EquipTL02f_1.setRotationPoint(-1.3f, 2.3f, 3.0f);
        this.EquipTL02f_1.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2, 0.0f);
        this.EquipMain04 = new ModelRenderer(this, 0, 26);
        this.EquipMain04.setRotationPoint(0.0f, -16.5f, 9.0f);
        this.EquipMain04.addBox(-3.0f, 0.0f, -3.0f, 6, 16, 6, 0.0f);
        this.setRotateAngle(this.EquipMain04, -0.08726646f, 0.0f, 0.0f);
        this.Cloth02 = new ModelRenderer(this, 22, 48);
        this.Cloth02.setRotationPoint(0.0f, 4.8f, -4.3f);
        this.Cloth02.addBox(-3.0f, 0.0f, 0.0f, 6, 10, 0, 0.0f);
        this.ArmLeft01 = new ModelRenderer(this, 0, 88);
        this.ArmLeft01.mirror = true;
        this.ArmLeft01.setRotationPoint(7.3f, -9.4f, -0.7f);
        this.ArmLeft01.addBox(-2.5f, -1.0f, -3.0f, 6, 11, 6, 0.0f);
        this.setRotateAngle(this.ArmLeft01, 0.20943952f, 0.0f, -0.34906584f);
        this.EquipTL02 = new ModelRenderer(this, 0, 0);
        this.EquipTL02.setRotationPoint(5.5f, 6.0f, 4.5f);
        this.EquipTL02.addBox(0.0f, -4.0f, -9.0f, 3, 8, 12, 0.0f);
        this.setRotateAngle(this.EquipTL02, 0.13962634f, -0.06981317f, 0.0f);
        this.Hair01 = new ModelRenderer(this, 36, 26);
        this.Hair01.setRotationPoint(0.0f, 6.8f, 1.1f);
        this.Hair01.addBox(-7.5f, 0.0f, 0.0f, 15, 10, 9, 0.0f);
        this.setRotateAngle(this.Hair01, 0.20943952f, 0.0f, 0.0f);
        this.LegLeft01 = new ModelRenderer(this, 0, 59);
        this.LegLeft01.mirror = true;
        this.LegLeft01.setRotationPoint(4.4f, 5.5f, 3.2f);
        this.LegLeft01.addBox(-3.0f, 0.0f, -3.0f, 6, 12, 6, 0.0f);
        this.setRotateAngle(this.LegLeft01, -0.13962634f, 0.0f, 0.10471976f);
        this.EquipTL03_1 = new ModelRenderer(this, 36, 45);
        this.EquipTL03_1.setRotationPoint(-3.0f, -12.0f, 3.0f);
        this.EquipTL03_1.addBox(-1.0f, 0.0f, -8.0f, 1, 24, 7, 0.0f);
        this.setRotateAngle(this.EquipTL03_1, 0.0f, 0.34906584f, 0.08726646f);
        this.Butt = new ModelRenderer(this, 54, 66);
        this.Butt.setRotationPoint(0.0f, 3.0f, -4.0f);
        this.Butt.addBox(-7.0f, 0.0f, 0.0f, 14, 7, 8, 0.0f);
        this.setRotateAngle(this.Butt, 0.20943952f, 0.0f, 0.0f);
        this.LegLeft02 = new ModelRenderer(this, 0, 72);
        this.LegLeft02.mirror = true;
        this.LegLeft02.setRotationPoint(-3.0f, 12.0f, -3.0f);
        this.LegLeft02.addBox(0.0f, 0.0f, 0.0f, 6, 10, 6, 0.0f);
        this.Head = new ModelRenderer(this, 44, 101);
        this.Head.setRotationPoint(0.0f, -11.8f, -1.0f);
        this.Head.addBox(-7.0f, -14.5f, -6.5f, 14, 14, 13, 0.0f);
        this.setRotateAngle(this.Head, 0.10471976f, 0.0f, 0.0f);
        this.Ahoke = new ModelRenderer(this, 0, 37);
        this.Ahoke.setRotationPoint(-1.0f, -6.0f, -6.0f);
        this.Ahoke.addBox(0.0f, -11.0f, -7.0f, 0, 11, 11, 0.0f);
        this.setRotateAngle(this.Ahoke, 1.0471976f, 1.0471976f, 0.0f);
        this.EquipTL02e_1 = new ModelRenderer(this, 0, 0);
        this.EquipTL02e_1.setRotationPoint(-1.3f, 0.0f, 2.5f);
        this.EquipTL02e_1.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2, 0.0f);
        this.EquipC03 = new ModelRenderer(this, 0, 0);
        this.EquipC03.setRotationPoint(0.0f, -5.0f, -2.0f);
        this.EquipC03.addBox(-3.0f, 0.0f, 0.0f, 6, 2, 5, 0.0f);
        this.HairR01 = new ModelRenderer(this, 88, 101);
        this.HairR01.setRotationPoint(-7.0f, -1.0f, -4.7f);
        this.HairR01.addBox(-1.0f, 0.0f, 0.0f, 1, 9, 4, 0.0f);
        this.setRotateAngle(this.HairR01, 0.57595867f, -0.2617994f, 0.2617994f);
        this.ArmRight02 = new ModelRenderer(this, 24, 88);
        this.ArmRight02.setRotationPoint(-3.5f, 10.0f, 3.0f);
        this.ArmRight02.addBox(0.0f, 0.0f, -6.0f, 6, 8, 6, 0.0f);
        this.EquipHead03 = new ModelRenderer(this, 0, 0);
        this.EquipHead03.setRotationPoint(0.0f, 4.8f, 2.5f);
        this.EquipHead03.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 6, 0.0f);
        this.setRotateAngle(this.EquipHead03, -0.2617994f, 0.0f, 0.0f);
        this.EquipHead04 = new ModelRenderer(this, 0, 0);
        this.EquipHead04.setRotationPoint(0.0f, -4.8f, 2.5f);
        this.EquipHead04.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 6, 0.0f);
        this.setRotateAngle(this.EquipHead04, 0.2617994f, 0.0f, 0.0f);
        this.BodyMain.addChild(this.ArmRight01);
        this.LegRight02.addChild(this.LegRight03);
        this.EquipHead02.addChild(this.EquipHead05);
        this.EquipBase.addChild(this.EquipC01);
        this.EquipMain01.addChild(this.EquipTL02_1);
        this.EquipTL02_1.addChild(this.EquipTL02c_1);
        this.EquipC02.addChild(this.EquipC05a);
        this.Head.addChild(this.Hair);
        this.ArmRight02.addChild(this.ArmRight03);
        this.EquipTL02_1.addChild(this.EquipTL02a_1);
        this.LegLeft02.addChild(this.LegLeft03);
        this.LegRight01.addChild(this.LegRight02);
        this.EquipTL02.addChild(this.EquipTL02c);
        this.EquipTL02.addChild(this.EquipTL02b);
        this.EquipTL02.addChild(this.EquipTL03);
        this.Head.addChild(this.HairMain);
        this.EquipTL02.addChild(this.EquipTL02e);
        this.EquipMain01.addChild(this.EquipMain02);
        this.BodyMain.addChild(this.EquipBase);
        this.BodyMain.addChild(this.Cloth01);
        this.EquipTL02_1.addChild(this.EquipTL02d_1);
        this.ArmRight03.addChild(this.EquipHead01);
        this.EquipTL02.addChild(this.EquipTL02f);
        this.Hair.addChild(this.HairU01);
        this.EquipMain01.addChild(this.EquipMain03);
        this.Butt.addChild(this.LegRight01);
        this.EquipC01.addChild(this.EquipC02);
        this.ArmLeft02.addChild(this.ArmLeft03);
        this.EquipC02.addChild(this.EquipC04a);
        this.EquipTL02.addChild(this.EquipTL02d);
        this.HairR01.addChild(this.HairR02);
        this.EquipBase.addChild(this.EquipMain01);
        this.EquipTL02.addChild(this.EquipTL02a);
        this.EquipTL02_1.addChild(this.EquipTL02b_1);
        this.HairL01.addChild(this.HairL02);
        this.EquipHead01.addChild(this.EquipHead02);
        this.Butt.addChild(this.Skirt01);
        this.Hair.addChild(this.HairL01);
        this.EquipC05a.addChild(this.EquipC05b);
        this.EquipC04a.addChild(this.EquipC04b);
        this.Skirt01.addChild(this.Skirt02);
        this.ArmLeft01.addChild(this.ArmLeft02);
        this.EquipTL02_1.addChild(this.EquipTL02f_1);
        this.EquipMain01.addChild(this.EquipMain04);
        this.Cloth01.addChild(this.Cloth02);
        this.BodyMain.addChild(this.ArmLeft01);
        this.EquipMain01.addChild(this.EquipTL02);
        this.HairMain.addChild(this.Hair01);
        this.Butt.addChild(this.LegLeft01);
        this.EquipTL02_1.addChild(this.EquipTL03_1);
        this.BodyMain.addChild(this.Butt);
        this.LegLeft01.addChild(this.LegLeft02);
        this.BodyMain.addChild(this.Head);
        this.Hair.addChild(this.Ahoke);
        this.EquipTL02_1.addChild(this.EquipTL02e_1);
        this.EquipC02.addChild(this.EquipC03);
        this.Hair.addChild(this.HairR01);
        this.ArmRight01.addChild(this.ArmRight02);
        this.EquipHead02.addChild(this.EquipHead03);
        this.EquipHead02.addChild(this.EquipHead04);
        this.GlowBodyMain = new ModelRenderer(this, 0, 0);
        this.GlowBodyMain.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.GlowHead = new ModelRenderer(this, 0, 0);
        this.GlowHead.setRotationPoint(0.0f, -11.8f, -1.0f);
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
        switch (((IShipEmotion)entity).getScaleLevel()) {
            case 3: {
                this.scale = 1.6f;
                this.offsetY = -0.53f;
                break;
            }
            case 2: {
                this.scale = 1.2f;
                this.offsetY = -0.23f;
                break;
            }
            case 1: {
                this.scale = 0.8f;
                this.offsetY = 0.41f;
                break;
            }
            default: {
                this.scale = 0.4f;
                this.offsetY = 2.28f;
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
        this.EquipBase.isHidden = !EmotionHelper.checkModelState(0, state);
        this.EquipHead01.isHidden = !EmotionHelper.checkModelState(1, state);
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
        GlStateManager.translate(0.0f, 0.51f + 0.24f * ent.getScaleLevel(), 0.0f);
        this.setFaceHungry(ent);
        this.Head.rotateAngleX = 0.0f;
        this.Head.rotateAngleY = 0.0f;
        this.Head.rotateAngleZ = 0.0f;
        this.Ahoke.rotateAngleY = 0.5236f;
        this.BodyMain.rotateAngleX = 1.55f;
        this.Butt.rotateAngleX = 0.21f;
        this.Butt.offsetY = 0.0f;
        this.Skirt01.rotateAngleX = -0.052f;
        this.Skirt01.offsetY = 0.0f;
        this.Skirt02.rotateAngleX = -0.052f;
        this.Skirt02.offsetY = 0.0f;
        this.ArmLeft01.rotateAngleX = -3.0f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = 0.3f;
        this.ArmRight01.rotateAngleX = -3.0f;
        this.ArmRight01.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleZ = -0.3f;
        this.ArmLeft02.rotateAngleX = 0.0f;
        this.ArmLeft02.rotateAngleZ = 0.0f;
        this.ArmLeft02.offsetX = 0.0f;
        this.ArmRight02.rotateAngleX = 0.0f;
        this.ArmRight02.rotateAngleZ = 0.0f;
        this.ArmRight02.offsetX = 0.0f;
        this.LegLeft01.rotateAngleX = -0.2618f;
        this.LegLeft01.rotateAngleY = 0.0f;
        this.LegLeft01.rotateAngleZ = 0.03f;
        this.LegRight01.rotateAngleX = -0.2618f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleZ = -0.03f;
        this.LegLeft02.rotateAngleX = 0.0f;
        this.LegLeft02.rotateAngleY = 0.0f;
        this.LegLeft02.rotateAngleZ = 0.0f;
        this.LegLeft02.offsetX = 0.0f;
        this.LegLeft02.offsetY = 0.0f;
        this.LegLeft02.offsetZ = 0.0f;
        this.LegRight02.rotateAngleX = 0.0f;
        this.LegRight02.rotateAngleY = 0.0f;
        this.LegRight02.rotateAngleZ = 0.0f;
        this.LegRight02.offsetX = 0.0f;
        this.LegRight02.offsetY = 0.0f;
        this.LegRight02.offsetZ = 0.0f;
        this.EquipHead01.rotateAngleY = -1.4f;
        this.EquipHead01.rotateAngleZ = 1.4f;
        this.EquipC02.rotateAngleY = 0.6f;
        this.EquipC04a.rotateAngleX = 0.0f;
        this.EquipC05a.rotateAngleX = -0.2f;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float f6;
        float angleX = MathHelper.cos(f2 * 0.08f + f * 0.25f);
        float angleAdd1 = MathHelper.cos(f * 0.7f) * f1;
        float angleAdd2 = MathHelper.cos(f * 0.7f + (float)Math.PI) * f1;
        float addk1;
        float addk2;
        if (ent.getShipDepth(0) > 0.0 || ent.getShipDepth(1) > 0.0) {
            GlStateManager.translate(0.0f, angleX * 0.05f + 0.025f, 0.0f);
        }
        addk1 = angleAdd1 * 0.5f - 0.14f;
        addk2 = angleAdd2 * 0.5f - 0.03f;
        this.Head.rotateAngleX = f4 * 0.014f + 0.1047f;
        this.Head.rotateAngleY = f3 * 0.01f;
        this.Ahoke.rotateAngleY = angleX * 0.2f + 0.5f;
        this.BodyMain.rotateAngleX = -0.1047f;
        this.BodyMain.rotateAngleY = 0.0f;
        this.BodyMain.rotateAngleZ = 0.0f;
        this.Butt.rotateAngleX = 0.21f;
        this.Butt.offsetY = 0.0f;
        this.Skirt01.rotateAngleX = -0.052f;
        this.Skirt01.offsetY = 0.0f;
        this.Skirt02.rotateAngleX = -0.052f;
        this.Skirt02.offsetY = 0.0f;
        this.ArmLeft01.rotateAngleX = angleAdd2 * 0.25f + 0.21f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = angleX * 0.03f - 0.35f;
        this.ArmLeft02.rotateAngleX = 0.0f;
        this.ArmLeft02.rotateAngleZ = 0.0f;
        this.ArmLeft02.offsetX = 0.0f;
        this.ArmRight01.rotateAngleX = angleAdd1 * 0.25f - 0.07f;
        this.ArmRight01.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleZ = -angleX * 0.03f + 0.35f;
        this.ArmRight02.rotateAngleX = 0.0f;
        this.ArmRight02.rotateAngleZ = 0.0f;
        this.ArmRight02.offsetX = 0.0f;
        this.LegLeft01.rotateAngleY = 0.0f;
        this.LegLeft01.rotateAngleZ = 0.1047f;
        this.LegLeft02.rotateAngleX = 0.0f;
        this.LegLeft02.rotateAngleY = 0.0f;
        this.LegLeft02.rotateAngleZ = 0.0f;
        this.LegLeft02.offsetX = 0.0f;
        this.LegLeft02.offsetY = 0.0f;
        this.LegLeft02.offsetZ = 0.0f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleZ = -0.1047f;
        this.LegRight02.rotateAngleX = 0.0f;
        this.LegRight02.rotateAngleY = 0.0f;
        this.LegRight02.rotateAngleZ = 0.0f;
        this.LegRight02.offsetX = 0.0f;
        this.LegRight02.offsetY = 0.0f;
        this.LegRight02.offsetZ = 0.0f;
        this.EquipHead01.rotateAngleY = 0.0f;
        this.EquipHead01.rotateAngleZ = 0.0f;
        this.EquipC02.rotateAngleY = 0.5f + this.Head.rotateAngleY * 0.5f;
        this.EquipC04a.rotateAngleX = -0.2f + this.Head.rotateAngleX;
        if (this.EquipC04a.rotateAngleX > 0.0f) {
            this.EquipC04a.rotateAngleX = 0.0f;
        }
        this.EquipC05a.rotateAngleX = this.EquipC04a.rotateAngleX;
        if (!EmotionHelper.checkModelState(0, ent.getStateEmotion(0))) {
            this.ArmLeft01.rotateAngleZ += 0.1f;
            this.ArmRight01.rotateAngleZ -= 0.1f;
        }
        if (ent.getIsSprinting() || f1 > 0.9f) {
            this.setFace(3);
            this.Head.rotateAngleX -= 0.25f;
            this.BodyMain.rotateAngleX = 0.1f;
            this.Skirt01.rotateAngleX = -0.1f;
            this.Skirt02.rotateAngleX = -0.1885f;
            this.ArmLeft01.rotateAngleX += 0.1f;
            this.ArmLeft01.rotateAngleZ -= 0.3f;
            this.ArmRight01.rotateAngleX = -2.2f + angleAdd1 * 0.2f;
            this.ArmRight01.rotateAngleZ = -0.4712f;
            addk1 -= 0.2f;
            addk2 -= 0.2f;
            this.EquipHead01.rotateAngleY = -0.3142f;
        }
        this.Head.rotateAngleZ = EmotionHelper.getHeadTiltAngle(ent, f2);
        if (ent.getIsSneaking()) {
            GlStateManager.translate(0.0f, 0.05f, 0.0f);
            this.Head.rotateAngleX -= 1.0472f;
            this.BodyMain.rotateAngleX = 1.0472f;
            this.Butt.rotateAngleX = -0.4f;
            this.Butt.offsetY = -0.19f;
            this.Skirt01.rotateAngleX = -0.12f;
            this.Skirt02.rotateAngleX = -0.4f;
            this.Skirt02.offsetY = -0.1f;
            this.ArmLeft01.rotateAngleX = -0.6f;
            this.ArmLeft01.rotateAngleZ = 0.2618f;
            this.ArmRight01.rotateAngleX = -0.6f;
            this.ArmRight01.rotateAngleZ = -0.2618f;
            addk1 -= 0.55f;
            addk2 -= 0.55f;
        }
        if (ent.getIsSitting() || ent.getIsRiding()) {
            Entity mount = ((Entity)ent).getRidingEntity();
            if (mount instanceof EntityDestroyerInazuma || mount instanceof EntityDestroyerAkatsuki) {
                if (((IShipEmotion)mount).getStateEmotion(1) == 4) {
                    this.BodyMain.rotateAngleX = -0.1f;
                    this.Butt.rotateAngleX = -0.2f;
                    this.Butt.offsetY = -0.1f;
                    this.Skirt01.rotateAngleX = -0.07f;
                    this.Skirt01.offsetY = -0.05f;
                    this.Skirt02.rotateAngleX = -0.16f;
                    this.Skirt02.offsetY = -0.08f;
                    this.ArmLeft01.rotateAngleX = -0.5f;
                    this.ArmLeft01.rotateAngleY = -0.2f;
                    this.ArmLeft01.rotateAngleZ = 0.0f;
                    this.ArmLeft02.rotateAngleX = -1.45f;
                    this.ArmRight01.rotateAngleX = -0.5f;
                    this.ArmRight01.rotateAngleY = 0.2f;
                    this.ArmRight01.rotateAngleZ = 0.0f;
                    this.ArmRight02.rotateAngleX = -1.45f;
                    addk1 = -0.65f;
                    addk2 = -0.65f;
                    this.LegLeft01.rotateAngleY = 0.0f;
                    this.LegLeft01.rotateAngleZ = -0.25f;
                    this.LegLeft02.offsetZ = 0.0f;
                    this.LegLeft02.rotateAngleX = 0.8f;
                    this.LegLeft02.rotateAngleZ = 0.0175f;
                    this.LegRight01.rotateAngleY = -0.0f;
                    this.LegRight01.rotateAngleZ = 0.25f;
                    this.LegRight02.offsetZ = 0.0f;
                    this.LegRight02.rotateAngleX = 0.8f;
                    this.LegRight02.rotateAngleZ = -0.0175f;
                    this.EquipHead01.isHidden = true;
                } else {
                    this.Butt.rotateAngleX = -0.2f;
                    this.Butt.offsetY = -0.1f;
                    this.Skirt01.rotateAngleX = -0.07f;
                    this.Skirt01.offsetY = -0.1f;
                    this.Skirt02.rotateAngleX = -0.16f;
                    this.Skirt02.offsetY = -0.15f;
                    this.ArmLeft01.rotateAngleX = -0.3f;
                    this.ArmLeft01.rotateAngleY = -0.2f;
                    this.ArmLeft01.rotateAngleZ = 0.0f;
                    this.ArmLeft02.rotateAngleX = -1.2f;
                    this.ArmRight01.rotateAngleX = -1.8f;
                    this.ArmRight01.rotateAngleY = 0.2f;
                    this.ArmRight01.rotateAngleZ = 0.0f;
                    addk1 = -0.95f;
                    addk2 = -0.95f;
                    this.LegLeft01.rotateAngleY = -0.5f;
                    this.LegLeft01.rotateAngleZ = -0.1f;
                    this.LegLeft02.offsetZ = 0.0f;
                    this.LegLeft02.rotateAngleX = 0.8f;
                    this.LegLeft02.rotateAngleZ = 0.0175f;
                    this.LegRight01.rotateAngleY = 0.5f;
                    this.LegRight01.rotateAngleZ = 0.1f;
                    this.LegRight02.offsetZ = 0.0f;
                    this.LegRight02.rotateAngleX = 0.8f;
                    this.LegRight02.rotateAngleZ = -0.0175f;
                }
            } else if (ent.getStateEmotion(1) == 4) {
                float az;
                GlStateManager.translate(0.0f, 0.375f, 0.0f);
                this.Head.rotateAngleX -= 0.1f;
                this.BodyMain.rotateAngleX = -0.25f;
                this.Butt.rotateAngleX = -0.2f;
                this.Butt.offsetY = -0.1f;
                this.Skirt01.rotateAngleX = -0.07f;
                this.Skirt01.offsetY = -0.1f;
                this.Skirt02.rotateAngleX = -0.16f;
                this.Skirt02.offsetY = -0.15f;
                this.ArmLeft01.rotateAngleX = 2.5f;
                this.ArmLeft01.rotateAngleZ = 0.1f;
                this.ArmLeft02.rotateAngleZ = 1.0f;
                this.ArmRight01.rotateAngleX = 2.5f;
                this.ArmRight01.rotateAngleZ = -0.1f;
                this.ArmRight02.rotateAngleZ = -1.0f;
                addk1 = -0.9f;
                addk2 = -0.9f;
                this.LegLeft01.rotateAngleZ = -0.14f;
                this.LegLeft02.rotateAngleX = 1.2217f;
                this.LegLeft02.rotateAngleY = 1.2217f;
                this.LegLeft02.rotateAngleZ = -1.0472f;
                this.LegLeft02.offsetX = 0.32f;
                this.LegLeft02.offsetY = 0.05f;
                this.LegLeft02.offsetZ = 0.35f;
                this.LegRight01.rotateAngleZ = 0.14f;
                this.LegRight02.rotateAngleX = 1.2217f;
                this.LegRight02.rotateAngleY = -1.2217f;
                this.LegRight02.rotateAngleZ = 1.0472f;
                this.LegRight02.offsetX = -0.32f;
                this.LegRight02.offsetY = 0.05f;
                this.LegRight02.offsetZ = 0.35f;
                this.EquipHead01.isHidden = true;
                float parTick = f2 - (int)f2 + (ent.getTickExisted() % 256);
                if (parTick < 30.0f) {
                    az = MathHelper.sin(parTick * 0.033f * 1.5708f) * 1.8f;
                    float az1 = az * 1.6f;
                    this.setFace(3);
                    this.ArmLeft01.rotateAngleZ = 0.1f + az;
                    this.ArmLeft02.rotateAngleZ = 1.0f - az1;
                    if (this.ArmLeft02.rotateAngleZ < 0.0f) {
                        this.ArmLeft02.rotateAngleZ = 0.0f;
                    }
                    this.ArmRight01.rotateAngleZ = -0.1f - az;
                    this.ArmRight02.rotateAngleZ = -1.0f + az1;
                    if (this.ArmRight02.rotateAngleZ > 0.0f) {
                        this.ArmRight02.rotateAngleZ = 0.0f;
                    }
                } else if (parTick < 45.0f) {
                    this.setFace(3);
                    this.ArmLeft01.rotateAngleZ = 1.9f;
                    this.ArmLeft02.rotateAngleZ = 0.0f;
                    this.ArmRight01.rotateAngleZ = -1.9f;
                    this.ArmRight02.rotateAngleZ = 0.0f;
                } else if (parTick < 53.0f) {
                    az = MathHelper.cos((parTick - 45.0f) * 0.125f * 1.5708f);
                    float az1 = az * 1.8f;
                    this.ArmLeft01.rotateAngleZ = 0.1f + az1;
                    this.ArmLeft02.rotateAngleZ = 1.0f - az;
                    this.ArmRight01.rotateAngleZ = -0.1f - az1;
                    this.ArmRight02.rotateAngleZ = -1.0f + az;
                }
            } else {
                GlStateManager.translate(0.0f, 0.375f, 0.0f);
                this.Head.rotateAngleX -= 0.1f;
                this.BodyMain.rotateAngleX = -0.25f;
                this.Butt.rotateAngleX = -0.2f;
                this.Butt.offsetY = -0.1f;
                this.Skirt01.rotateAngleX = -0.07f;
                this.Skirt01.offsetY = -0.1f;
                this.Skirt02.rotateAngleX = -0.16f;
                this.Skirt02.offsetY = -0.15f;
                this.ArmLeft01.rotateAngleX = 0.3f;
                this.ArmLeft01.rotateAngleZ = -0.2618f;
                this.ArmRight01.rotateAngleX = 0.3f;
                this.ArmRight01.rotateAngleZ = 0.2618f;
                addk1 = -0.9f;
                addk2 = -0.9f;
                this.LegLeft01.rotateAngleZ = -0.14f;
                this.LegLeft02.rotateAngleX = 1.2217f;
                this.LegLeft02.rotateAngleY = 1.2217f;
                this.LegLeft02.rotateAngleZ = -1.0472f;
                this.LegLeft02.offsetX = 0.32f;
                this.LegLeft02.offsetY = 0.05f;
                this.LegLeft02.offsetZ = 0.35f;
                this.LegRight01.rotateAngleZ = 0.14f;
                this.LegRight02.rotateAngleX = 1.2217f;
                this.LegRight02.rotateAngleY = -1.2217f;
                this.LegRight02.rotateAngleZ = 1.0472f;
                this.LegRight02.offsetX = -0.32f;
                this.LegRight02.offsetY = 0.05f;
                this.LegRight02.offsetZ = 0.35f;
                this.EquipHead01.rotateAngleZ = 1.2f;
            }
        }
        if (ent.getAttackTick() > 20 && !ent.getIsRiding()) {
            this.setFace(3);
            this.Head.rotateAngleX -= 0.1f;
            this.EquipHead01.rotateAngleY = -0.3142f;
            if (ent.getTickExisted() % 128 < 64) {
                this.ArmLeft01.rotateAngleX = 0.2356f;
                this.ArmLeft01.rotateAngleZ = -0.7854f;
                this.ArmLeft02.rotateAngleZ = 1.5708f;
                this.ArmLeft02.offsetX = -0.15f;
                this.ArmRight01.rotateAngleX = -1.6f + angleAdd1 * 0.2f;
                this.ArmRight01.rotateAngleZ = -0.4f;
            } else {
                this.ArmLeft01.rotateAngleX = 0.2356f;
                this.ArmLeft01.rotateAngleZ = -0.7854f;
                this.ArmLeft02.rotateAngleZ = 1.5708f;
                this.ArmLeft02.offsetX = -0.15f;
                this.ArmRight01.rotateAngleX = 0.2356f;
                this.ArmRight01.rotateAngleZ = 0.7854f;
                this.ArmRight02.rotateAngleZ = -1.5708f;
                this.ArmRight02.offsetX = 0.15f;
                this.EquipHead01.isHidden = true;
            }
        }
        if ((f6 = ent.getSwingTime(f2 - (int)f2)) != 0.0f) {
            float f7 = MathHelper.sin(f6 * f6 * (float)Math.PI);
            float f8 = MathHelper.sin(MathHelper.sqrt(f6) * (float)Math.PI);
            this.ArmRight01.rotateAngleX += -f8 * 80.0f * ((float)Math.PI / 180);
            this.ArmRight01.rotateAngleY += -f7 * 20.0f * ((float)Math.PI / 180) + 0.2f;
            this.ArmRight01.rotateAngleZ += -f8 * 20.0f * ((float)Math.PI / 180);
        }
        this.LegLeft01.rotateAngleX = addk1;
        this.LegRight01.rotateAngleX = addk2;
    }

    @Override
    public void setFaceNormal(IShipEmotion ent) {
        this.setFace(0);
        if (ent.getStateEmotion(7) == 4 && (ent.getTickExisted() & 0xFF) > 160) {
            this.setMouth(4);
        } else {
            this.setMouth(0);
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
                this.setMouth(4);
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
                this.setMouth(0);
            } else {
                this.setMouth(4);
            }
        } else {
            this.setFace(2);
            if (t < 170) {
                this.setMouth(1);
            } else {
                this.setMouth(4);
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
                this.setMouth(5);
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

    @Override
    public float[] getHeldItemOffset(IShipEmotion ent, EnumHandSide side, int type) {
        if (ent.getIsRiding()) {
            return this.offsetItem2;
        }
        return this.offsetItem;
    }
}
