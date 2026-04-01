package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.entity.IShipRiderType;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelDestroyerHibiki
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
    private final ModelRenderer HatBase;
    private final ModelRenderer Hair02f1;
    private final ModelRenderer Hair02a1;
    private final ModelRenderer Hair02b1;
    private final ModelRenderer Hair02c1;
    private final ModelRenderer Hair02d1;
    private final ModelRenderer Hair02e1;
    private final ModelRenderer Hair02a2;
    private final ModelRenderer Hair02b2;
    private final ModelRenderer Hair02c2;
    private final ModelRenderer Hair02d2;
    private final ModelRenderer Hair02e2;
    private final ModelRenderer Hat01a;
    private final ModelRenderer Hat01b;
    private final ModelRenderer Hat01c;
    private final ModelRenderer Hat01d;
    private final ModelRenderer Hat02a;
    private final ModelRenderer Hat03a;
    private final ModelRenderer Hat03b;
    private final ModelRenderer Hat03c;
    private final ModelRenderer Hat03d;
    private final ModelRenderer Hat02b;
    private final ModelRenderer HatBase2;
    private final ModelRenderer Hat201_01;
    private final ModelRenderer Hat201_02;
    private final ModelRenderer Hat201_03;
    private final ModelRenderer Hat201_04;
    private final ModelRenderer Hat201_05;
    private final ModelRenderer Hat201_06;
    private final ModelRenderer Hat201_07;
    private final ModelRenderer Hat201_08;
    private final ModelRenderer Hat201_09;
    private final ModelRenderer Hat201_10;
    private final ModelRenderer Hat201_11;
    private final ModelRenderer Hat201_12;
    private final ModelRenderer Hat202a;
    private final ModelRenderer Hat202b;
    private final ModelRenderer Hair02f2;
    private final ModelRenderer ArmLeft02;
    private final ModelRenderer ArmLeft03;
    private final ModelRenderer EquipTL03;
    private final ModelRenderer ArmRight02;
    private final ModelRenderer ArmRight03;
    private final ModelRenderer Cloth02;
    private final ModelRenderer EquipMain01;
    private final ModelRenderer EquipC01;
    private final ModelRenderer EquipMain02;
    private final ModelRenderer EquipMain03;
    private final ModelRenderer EquipMain04;
    private final ModelRenderer EquipTL02;
    private final ModelRenderer EquipTR02;
    private final ModelRenderer EquipHead01;
    private final ModelRenderer EquipHead02;
    private final ModelRenderer EquipHead03;
    private final ModelRenderer EquipHead04;
    private final ModelRenderer EquipHead05;
    private final ModelRenderer EquipTL02a;
    private final ModelRenderer EquipTL02b;
    private final ModelRenderer EquipTL02c;
    private final ModelRenderer EquipTL02d;
    private final ModelRenderer EquipTL02e;
    private final ModelRenderer EquipTL02f;
    private final ModelRenderer EquipTR02a;
    private final ModelRenderer EquipTR02b;
    private final ModelRenderer EquipTR02c;
    private final ModelRenderer EquipTR02d;
    private final ModelRenderer EquipTR02e;
    private final ModelRenderer EquipTR02f;
    private final ModelRenderer EquipC02;
    private final ModelRenderer EquipC03;
    private final ModelRenderer EquipC04a;
    private final ModelRenderer EquipC05a;
    private final ModelRenderer EquipC04b;
    private final ModelRenderer EquipC05b;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowHead;

    public ModelDestroyerHibiki() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.offsetItem = new float[]{0.06f, 1.04f, -0.08f};
        this.offsetBlock = new float[]{0.06f, 1.04f, -0.08f};
        this.EquipTR02f = new ModelRenderer(this, 0, 0);
        this.EquipTR02f.setRotationPoint(-1.3f, 2.3f, 2.5f);
        this.EquipTR02f.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2, 0.0f);
        this.LegLeft01 = new ModelRenderer(this, 0, 59);
        this.LegLeft01.mirror = true;
        this.LegLeft01.setRotationPoint(4.4f, 5.5f, 3.2f);
        this.LegLeft01.addBox(-3.0f, 0.0f, -3.0f, 6, 12, 6, 0.0f);
        this.setRotateAngle(this.LegLeft01, -0.13962634f, 0.0f, 0.10471976f);
        this.Cloth01 = new ModelRenderer(this, 84, 31);
        this.Cloth01.setRotationPoint(0.0f, -11.6f, 0.0f);
        this.Cloth01.addBox(-7.0f, 0.0f, -4.4f, 14, 7, 8, 0.0f);
        this.EquipTR02a = new ModelRenderer(this, 0, 0);
        this.EquipTR02a.setRotationPoint(-1.3f, 0.0f, -19.8f);
        this.EquipTR02a.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 11, 0.0f);
        this.EquipMain04 = new ModelRenderer(this, 0, 26);
        this.EquipMain04.setRotationPoint(0.0f, -16.5f, 9.0f);
        this.EquipMain04.addBox(-3.0f, 0.0f, -3.0f, 6, 16, 6, 0.0f);
        this.setRotateAngle(this.EquipMain04, -0.08726646f, 0.0f, 0.0f);
        this.Cloth02 = new ModelRenderer(this, 24, 73);
        this.Cloth02.setRotationPoint(0.0f, 4.8f, -4.3f);
        this.Cloth02.addBox(-3.0f, 0.0f, 0.0f, 6, 10, 0, 0.0f);
        this.ArmLeft02 = new ModelRenderer(this, 24, 88);
        this.ArmLeft02.mirror = true;
        this.ArmLeft02.setRotationPoint(3.5f, 10.0f, 3.0f);
        this.ArmLeft02.addBox(-6.0f, 0.0f, -6.0f, 6, 8, 6, 0.0f);
        this.EquipTL02d = new ModelRenderer(this, 0, 0);
        this.EquipTL02d.setRotationPoint(1.3f, -2.3f, 3.0f);
        this.EquipTL02d.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2, 0.0f);
        this.Hair02b1 = new ModelRenderer(this, 24, 26);
        this.Hair02b1.setRotationPoint(-4.0f, 7.0f, -2.4f);
        this.Hair02b1.addBox(-2.0f, 0.0f, 0.0f, 4, 7, 0, 0.0f);
        this.setRotateAngle(this.Hair02b1, 0.2617994f, -0.17453292f, 0.2617994f);
        this.Hat03c = new ModelRenderer(this, 23, 43);
        this.Hat03c.setRotationPoint(-0.5f, 2.0f, 0.0f);
        this.Hat03c.addBox(0.0f, -4.0f, 0.0f, 5, 3, 5, 0.0f);
        this.setRotateAngle(this.Hat03c, (float)(-Math.PI) / 90, 0.0f, 0.0f);
        this.EquipHead04 = new ModelRenderer(this, 0, 0);
        this.EquipHead04.setRotationPoint(0.0f, -4.8f, 2.5f);
        this.EquipHead04.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 6, 0.0f);
        this.setRotateAngle(this.EquipHead04, 0.2617994f, 0.0f, 0.0f);
        this.EquipMain01 = new ModelRenderer(this, 0, 0);
        this.EquipMain01.setRotationPoint(0.0f, -4.0f, 5.0f);
        this.EquipMain01.addBox(-5.5f, -1.0f, 0.0f, 11, 9, 12, 0.0f);
        this.EquipTR02e = new ModelRenderer(this, 0, 0);
        this.EquipTR02e.setRotationPoint(-1.3f, 0.0f, 2.2f);
        this.EquipTR02e.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2, 0.0f);
        this.EquipHead01 = new ModelRenderer(this, 0, 0);
        this.EquipHead01.setRotationPoint(0.0f, 6.5f, -0.5f);
        this.EquipHead01.addBox(0.0f, -1.5f, -12.0f, 2, 3, 18, 0.0f);
        this.setRotateAngle(this.EquipHead01, (float)Math.PI, -1.8325957f, -1.5707964f);
        this.EquipTL02b = new ModelRenderer(this, 0, 0);
        this.EquipTL02b.setRotationPoint(1.3f, -2.3f, -18.8f);
        this.EquipTL02b.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 10, 0.0f);
        this.HairU01 = new ModelRenderer(this, 52, 45);
        this.HairU01.setRotationPoint(0.0f, -6.2f, -7.1f);
        this.HairU01.addBox(-8.5f, 0.0f, 0.0f, 17, 15, 6, 0.0f);
        this.Hat01a = new ModelRenderer(this, 46, 0);
        this.Hat01a.setRotationPoint(-0.7f, 0.0f, 0.0f);
        this.Hat01a.addBox(0.0f, 0.0f, -6.0f, 6, 2, 6, 0.0f);
        this.Hair02a1 = new ModelRenderer(this, 24, 26);
        this.Hair02a1.setRotationPoint(0.0f, 10.0f, -2.2f);
        this.Hair02a1.addBox(-2.0f, 0.0f, 0.0f, 4, 7, 0, 0.0f);
        this.setRotateAngle(this.Hair02a1, 0.2617994f, 0.0f, 0.0f);
        this.EquipHead05 = new ModelRenderer(this, 0, 0);
        this.EquipHead05.setRotationPoint(0.0f, 0.0f, -2.0f);
        this.EquipHead05.addBox(-1.0f, -5.0f, 0.0f, 2, 10, 2, 0.0f);
        this.EquipMain03 = new ModelRenderer(this, 63, 13);
        this.EquipMain03.setRotationPoint(0.0f, 9.5f, 9.0f);
        this.EquipMain03.addBox(-1.0f, 0.0f, -1.5f, 2, 6, 3, 0.0f);
        this.setRotateAngle(this.EquipMain03, 0.5009095f, 0.0f, 0.0f);
        this.Skirt02 = new ModelRenderer(this, 76, 0);
        this.Skirt02.setRotationPoint(0.0f, 3.5f, -0.4f);
        this.Skirt02.addBox(-8.0f, 0.0f, 0.0f, 16, 6, 10, 0.0f);
        this.setRotateAngle(this.Skirt02, -0.05235988f, 0.0f, 0.0f);
        this.EquipTR02d = new ModelRenderer(this, 0, 0);
        this.EquipTR02d.setRotationPoint(-1.3f, -2.3f, 3.0f);
        this.EquipTR02d.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2, 0.0f);
        this.Hat01b = new ModelRenderer(this, 46, 0);
        this.Hat01b.setRotationPoint(-0.7f, 0.0f, 0.0f);
        this.Hat01b.addBox(0.0f, 0.0f, 0.0f, 6, 2, 6, 0.0f);
        this.LegRight02 = new ModelRenderer(this, 0, 72);
        this.LegRight02.setRotationPoint(3.0f, 12.0f, -3.0f);
        this.LegRight02.addBox(-6.0f, 0.0f, 0.0f, 6, 10, 6, 0.0f);
        this.EquipC03 = new ModelRenderer(this, 0, 0);
        this.EquipC03.setRotationPoint(0.0f, -5.0f, -2.0f);
        this.EquipC03.addBox(-3.0f, 0.0f, 0.0f, 6, 2, 5, 0.0f);
        this.Hat01c = new ModelRenderer(this, 46, 0);
        this.Hat01c.setRotationPoint(0.7f, 0.0f, 0.0f);
        this.Hat01c.addBox(-6.0f, 0.0f, 0.0f, 6, 2, 6, 0.0f);
        this.ArmRight02 = new ModelRenderer(this, 24, 88);
        this.ArmRight02.setRotationPoint(-3.5f, 10.0f, 3.0f);
        this.ArmRight02.addBox(0.0f, 0.0f, -6.0f, 6, 8, 6, 0.0f);
        this.EquipC05a = new ModelRenderer(this, 0, 0);
        this.EquipC05a.setRotationPoint(1.5f, -3.0f, 0.0f);
        this.EquipC05a.addBox(-1.0f, -1.0f, -6.0f, 2, 2, 6, 0.0f);
        this.EquipHead03 = new ModelRenderer(this, 0, 0);
        this.EquipHead03.setRotationPoint(0.0f, 4.8f, 2.5f);
        this.EquipHead03.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 6, 0.0f);
        this.setRotateAngle(this.EquipHead03, -0.2617994f, 0.0f, 0.0f);
        this.Hair02f2 = new ModelRenderer(this, 26, 68);
        this.Hair02f2.mirror = true;
        this.Hair02f2.setRotationPoint(0.0f, 5.0f, 0.0f);
        this.Hair02f2.addBox(-1.5f, 0.0f, 0.0f, 3, 4, 0, 0.0f);
        this.setRotateAngle(this.Hair02f2, 0.62831855f, 0.0f, 0.0f);
        this.ArmLeft03 = new ModelRenderer(this, 36, 102);
        this.ArmLeft03.mirror = true;
        this.ArmLeft03.setRotationPoint(-3.0f, 6.0f, -3.0f);
        this.ArmLeft03.addBox(-2.5f, 0.0f, -2.5f, 5, 5, 5, 0.0f);
        this.LegLeft02 = new ModelRenderer(this, 0, 72);
        this.LegLeft02.mirror = true;
        this.LegLeft02.setRotationPoint(-3.0f, 12.0f, -3.0f);
        this.LegLeft02.addBox(0.0f, 0.0f, 0.0f, 6, 10, 6, 0.0f);
        this.Butt = new ModelRenderer(this, 54, 66);
        this.Butt.setRotationPoint(0.0f, 3.0f, -4.0f);
        this.Butt.addBox(-7.0f, 0.0f, 0.0f, 14, 7, 8, 0.0f);
        this.setRotateAngle(this.Butt, 0.20943952f, 0.0f, 0.0f);
        this.EquipTL02e = new ModelRenderer(this, 0, 0);
        this.EquipTL02e.setRotationPoint(1.3f, 0.0f, 2.2f);
        this.EquipTL02e.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2, 0.0f);
        this.ArmLeft01 = new ModelRenderer(this, 0, 88);
        this.ArmLeft01.mirror = true;
        this.ArmLeft01.setRotationPoint(7.3f, -9.4f, -0.7f);
        this.ArmLeft01.addBox(-2.5f, -1.0f, -3.0f, 6, 11, 6, 0.0f);
        this.setRotateAngle(this.ArmLeft01, 0.17453292f, 0.0f, -0.31415927f);
        this.Hair02b2 = new ModelRenderer(this, 24, 66);
        this.Hair02b2.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.Hair02b2.addBox(-2.0f, 0.0f, 0.0f, 4, 7, 0, 0.0f);
        this.setRotateAngle(this.Hair02b2, -0.43633232f, 0.0f, 0.0f);
        this.Hair02e1 = new ModelRenderer(this, 24, 22);
        this.Hair02e1.setRotationPoint(7.4f, -4.0f, -5.5f);
        this.Hair02e1.addBox(0.0f, 0.0f, -2.0f, 0, 7, 4, 0.0f);
        this.setRotateAngle(this.Hair02e1, 0.05235988f, 0.0f, -0.61086524f);
        this.BodyMain = new ModelRenderer(this, 0, 105);
        this.BodyMain.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.BodyMain.addBox(-6.5f, -11.0f, -4.0f, 13, 14, 7, 0.0f);
        this.setRotateAngle(this.BodyMain, -0.10471976f, 0.0f, 0.0f);
        this.EquipC04a = new ModelRenderer(this, 0, 0);
        this.EquipC04a.setRotationPoint(-1.5f, -3.0f, 0.0f);
        this.EquipC04a.addBox(-1.0f, -1.0f, -6.0f, 2, 2, 6, 0.0f);
        this.Skirt01 = new ModelRenderer(this, 80, 16);
        this.Skirt01.setRotationPoint(0.0f, 1.7f, -0.4f);
        this.Skirt01.addBox(-7.5f, 0.0f, 0.0f, 15, 6, 9, 0.0f);
        this.setRotateAngle(this.Skirt01, -0.05235988f, 0.0f, 0.0f);
        this.Hat03d = new ModelRenderer(this, 23, 43);
        this.Hat03d.setRotationPoint(0.5f, 2.0f, 0.0f);
        this.Hat03d.addBox(-5.0f, -4.0f, 0.0f, 5, 3, 5, 0.0f);
        this.setRotateAngle(this.Hat03d, (float)(-Math.PI) / 90, 0.0f, 0.0f);
        this.HairR01 = new ModelRenderer(this, 89, 102);
        this.HairR01.setRotationPoint(-8.0f, 2.6f, -4.7f);
        this.HairR01.addBox(-0.5f, 0.0f, 0.0f, 1, 9, 3, 0.0f);
        this.setRotateAngle(this.HairR01, -0.2617994f, 0.08726646f, -0.08726646f);
        this.EquipTL02a = new ModelRenderer(this, 0, 0);
        this.EquipTL02a.setRotationPoint(1.3f, 0.0f, -19.8f);
        this.EquipTL02a.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 11, 0.0f);
        this.Hat02b = new ModelRenderer(this, 0, 24);
        this.Hat02b.setRotationPoint(4.8f, -1.7f, -2.0f);
        this.Hat02b.addBox(0.0f, 0.0f, 0.0f, 0, 2, 2, 0.0f);
        this.setRotateAngle(this.Hat02b, -0.13962634f, 0.0f, 0.0f);
        this.EquipTR02 = new ModelRenderer(this, 0, 0);
        this.EquipTR02.setRotationPoint(-5.5f, 6.0f, 4.5f);
        this.EquipTR02.addBox(-3.0f, -4.0f, -9.0f, 3, 9, 12, 0.0f);
        this.setRotateAngle(this.EquipTR02, 0.13962634f, 0.06981317f, 0.0f);
        this.Ahoke = new ModelRenderer(this, 0, 37);
        this.Ahoke.setRotationPoint(-4.5f, -7.4f, -7.0f);
        this.Ahoke.addBox(0.0f, 0.0f, -11.0f, 0, 11, 11, 0.0f);
        this.setRotateAngle(this.Ahoke, -0.5235988f, 1.2217305f, 0.0f);
        this.EquipTL03 = new ModelRenderer(this, 36, 45);
        this.EquipTL03.setRotationPoint(0.5f, 4.0f, -3.0f);
        this.EquipTL03.addBox(0.0f, -12.0f, -3.5f, 1, 24, 7, 0.0f);
        this.setRotateAngle(this.EquipTL03, -0.13962634f, -0.10471976f, -0.05235988f);
        this.LegLeft03 = new ModelRenderer(this, 30, 76);
        this.LegLeft03.setRotationPoint(3.0f, 8.0f, 2.9f);
        this.LegLeft03.addBox(-3.5f, 0.0f, -3.5f, 7, 5, 7, 0.0f);
        this.Hair02d2 = new ModelRenderer(this, 28, 62);
        this.Hair02d2.mirror = true;
        this.Hair02d2.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.Hair02d2.addBox(0.0f, 0.0f, -2.0f, 0, 7, 4, 0.0f);
        this.setRotateAngle(this.Hair02d2, 0.0f, 0.0f, -0.5235988f);
        this.EquipMain02 = new ModelRenderer(this, 52, 8);
        this.EquipMain02.setRotationPoint(0.0f, 6.9f, 1.2f);
        this.EquipMain02.addBox(-4.0f, 0.0f, 0.0f, 8, 7, 8, 0.0f);
        this.setRotateAngle(this.EquipMain02, 0.62831855f, 0.0f, 0.0f);
        this.HatBase = new ModelRenderer(this, 0, 0);
        this.HatBase.setRotationPoint(-1.0f, -2.4f, 1.5f);
        this.HatBase.addBox(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.HatBase, -0.10471976f, 0.7853982f, 0.0f);
        this.Hat01d = new ModelRenderer(this, 46, 0);
        this.Hat01d.setRotationPoint(0.7f, 0.0f, 0.0f);
        this.Hat01d.addBox(-6.0f, 0.0f, -6.0f, 6, 2, 6, 0.0f);
        this.EquipC02 = new ModelRenderer(this, 0, 0);
        this.EquipC02.setRotationPoint(-2.0f, 0.5f, 0.0f);
        this.EquipC02.addBox(-3.5f, -3.0f, -3.5f, 7, 3, 7, 0.0f);
        this.setRotateAngle(this.EquipC02, -0.17453292f, 0.62831855f, 0.0f);
        this.Hair02d1 = new ModelRenderer(this, 28, 22);
        this.Hair02d1.setRotationPoint(-7.4f, 0.0f, -5.5f);
        this.Hair02d1.addBox(0.0f, 0.0f, -2.0f, 0, 7, 4, 0.0f);
        this.setRotateAngle(this.Hair02d1, 0.2617994f, 0.0f, 0.34906584f);
        this.EquipTL02 = new ModelRenderer(this, 0, 0);
        this.EquipTL02.setRotationPoint(5.5f, 6.0f, 4.5f);
        this.EquipTL02.addBox(0.0f, -4.0f, -9.0f, 3, 9, 12, 0.0f);
        this.setRotateAngle(this.EquipTL02, 0.13962634f, -0.06981317f, 0.0f);
        this.Hair01 = new ModelRenderer(this, 38, 23);
        this.Hair01.setRotationPoint(0.0f, 9.0f, 12.0f);
        this.Hair01.addBox(-7.5f, 0.0f, -10.0f, 15, 12, 8, 0.0f);
        this.setRotateAngle(this.Hair01, 0.2617994f, 0.0f, 0.0f);
        this.Hair02e2 = new ModelRenderer(this, 24, 62);
        this.Hair02e2.mirror = true;
        this.Hair02e2.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.Hair02e2.addBox(0.0f, 0.0f, -2.0f, 0, 7, 4, 0.0f);
        this.setRotateAngle(this.Hair02e2, 0.0f, 0.0f, 0.87266463f);
        this.Hat03a = new ModelRenderer(this, 23, 43);
        this.Hat03a.mirror = true;
        this.Hat03a.setRotationPoint(-0.3f, 2.0f, 0.0f);
        this.Hat03a.addBox(0.0f, -4.0f, -5.0f, 5, 3, 5, 0.0f);
        this.setRotateAngle(this.Hat03a, -0.13962634f, 0.0f, 0.0f);
        this.EquipC01 = new ModelRenderer(this, 0, 0);
        this.EquipC01.setRotationPoint(-7.0f, -11.0f, 9.0f);
        this.EquipC01.addBox(-2.0f, 0.0f, -2.0f, 4, 8, 4, 0.0f);
        this.EquipTR02b = new ModelRenderer(this, 0, 0);
        this.EquipTR02b.setRotationPoint(-1.3f, -2.3f, -18.8f);
        this.EquipTR02b.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 10, 0.0f);
        this.Hair02c1 = new ModelRenderer(this, 24, 26);
        this.Hair02c1.setRotationPoint(4.2f, 6.0f, -2.4f);
        this.Hair02c1.addBox(-2.0f, 0.0f, 0.0f, 4, 7, 0, 0.0f);
        this.setRotateAngle(this.Hair02c1, 0.17453292f, 0.17453292f, -0.40142572f);
        this.Hair02c2 = new ModelRenderer(this, 24, 66);
        this.Hair02c2.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.Hair02c2.addBox(-2.0f, 0.0f, 0.0f, 4, 7, 0, 0.0f);
        this.setRotateAngle(this.Hair02c2, -0.34906584f, 0.0f, 0.0f);
        this.Hat03b = new ModelRenderer(this, 23, 43);
        this.Hat03b.setRotationPoint(0.3f, 2.0f, 0.0f);
        this.Hat03b.addBox(-5.0f, -4.0f, -5.0f, 5, 3, 5, 0.0f);
        this.setRotateAngle(this.Hat03b, -0.13962634f, 0.0f, 0.0f);
        this.EquipTL02c = new ModelRenderer(this, 0, 0);
        this.EquipTL02c.setRotationPoint(1.3f, 2.3f, -19.5f);
        this.EquipTL02c.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 11, 0.0f);
        this.Hair02f1 = new ModelRenderer(this, 25, 26);
        this.Hair02f1.setRotationPoint(5.0f, 1.0f, 9.5f);
        this.Hair02f1.addBox(-1.5f, 0.0f, 0.0f, 3, 5, 0, 0.0f);
        this.setRotateAngle(this.Hair02f1, 0.7853982f, 0.34906584f, -0.13962634f);
        this.HairL01 = new ModelRenderer(this, 89, 102);
        this.HairL01.setRotationPoint(8.0f, 2.5f, -4.4f);
        this.HairL01.addBox(-0.5f, 0.0f, 0.0f, 1, 9, 3, 0.0f);
        this.setRotateAngle(this.HairL01, -0.2617994f, -0.08726646f, 0.08726646f);
        this.HairMain = new ModelRenderer(this, 46, 104);
        this.HairMain.setRotationPoint(0.0f, -14.8f, -2.8f);
        this.HairMain.addBox(-7.5f, 0.0f, 0.0f, 15, 11, 10, 0.0f);
        this.EquipBase = new ModelRenderer(this, 0, 0);
        this.EquipBase.setRotationPoint(0.0f, -1.0f, 0.0f);
        this.EquipBase.addBox(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.Hair02a2 = new ModelRenderer(this, 24, 32);
        this.Hair02a2.setRotationPoint(0.0f, 7.0f, 0.0f);
        this.Hair02a2.addBox(-2.0f, 0.0f, 0.0f, 4, 7, 0, 0.0f);
        this.setRotateAngle(this.Hair02a2, -0.2617994f, 0.0f, 0.0f);
        this.EquipTL02f = new ModelRenderer(this, 0, 0);
        this.EquipTL02f.setRotationPoint(1.3f, 2.3f, 2.5f);
        this.EquipTL02f.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 2, 0.0f);
        this.HairR02 = new ModelRenderer(this, 88, 104);
        this.HairR02.setRotationPoint(0.1f, 8.5f, 0.0f);
        this.HairR02.addBox(-0.5f, 0.0f, 0.0f, 1, 7, 3, 0.0f);
        this.setRotateAngle(this.HairR02, 0.20943952f, 0.0f, -0.08726646f);
        this.LegRight03 = new ModelRenderer(this, 30, 76);
        this.LegRight03.mirror = true;
        this.LegRight03.setRotationPoint(-3.0f, 8.0f, 2.9f);
        this.LegRight03.addBox(-3.5f, 0.0f, -3.5f, 7, 5, 7, 0.0f);
        this.EquipHead02 = new ModelRenderer(this, 0, 0);
        this.EquipHead02.setRotationPoint(1.0f, 0.0f, -15.0f);
        this.EquipHead02.addBox(-1.5f, -7.0f, 0.0f, 3, 14, 3, 0.0f);
        this.Hair = new ModelRenderer(this, 50, 81);
        this.Hair.setRotationPoint(0.0f, -7.5f, 0.3f);
        this.Hair.addBox(-8.0f, -8.0f, -7.4f, 16, 12, 8, 0.0f);
        this.Head = new ModelRenderer(this, 44, 101);
        this.Head.setRotationPoint(0.0f, -11.8f, -1.0f);
        this.Head.addBox(-7.0f, -14.5f, -6.5f, 14, 14, 13, 0.0f);
        this.setRotateAngle(this.Head, 0.10471976f, 0.0f, 0.0f);
        this.Hat02a = new ModelRenderer(this, 55, 0);
        this.Hat02a.setRotationPoint(0.0f, 2.0f, -6.0f);
        this.Hat02a.addBox(-4.5f, 0.0f, -6.0f, 9, 0, 6, 0.0f);
        this.setRotateAngle(this.Hat02a, 0.17453292f, 0.0f, 0.0f);
        this.LegRight01 = new ModelRenderer(this, 0, 59);
        this.LegRight01.setRotationPoint(-4.4f, 5.5f, 3.2f);
        this.LegRight01.addBox(-3.0f, 0.0f, -3.0f, 6, 12, 6, 0.0f);
        this.setRotateAngle(this.LegRight01, -0.05235988f, 0.0f, -0.10471976f);
        this.EquipTR02c = new ModelRenderer(this, 0, 0);
        this.EquipTR02c.setRotationPoint(-1.3f, 2.3f, -19.5f);
        this.EquipTR02c.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 11, 0.0f);
        this.HairL02 = new ModelRenderer(this, 88, 104);
        this.HairL02.setRotationPoint(-0.1f, 8.5f, 0.0f);
        this.HairL02.addBox(-0.5f, 0.0f, 0.0f, 1, 7, 3, 0.0f);
        this.setRotateAngle(this.HairL02, 0.31415927f, 0.0f, 0.08726646f);
        this.ArmRight01 = new ModelRenderer(this, 0, 88);
        this.ArmRight01.setRotationPoint(-7.3f, -9.4f, -0.7f);
        this.ArmRight01.addBox(-3.5f, -1.0f, -3.0f, 6, 11, 6, 0.0f);
        this.setRotateAngle(this.ArmRight01, 0.17453292f, 0.0f, 0.31415927f);
        this.EquipC04b = new ModelRenderer(this, 0, 0);
        this.EquipC04b.setRotationPoint(0.0f, 0.0f, -6.0f);
        this.EquipC04b.addBox(-0.5f, -0.5f, -10.0f, 1, 1, 10, 0.0f);
        this.EquipC05b = new ModelRenderer(this, 0, 0);
        this.EquipC05b.setRotationPoint(0.0f, 0.0f, -6.0f);
        this.EquipC05b.addBox(-0.5f, -0.5f, -10.0f, 1, 1, 10, 0.0f);
        this.ArmRight03 = new ModelRenderer(this, 36, 102);
        this.ArmRight03.setRotationPoint(3.0f, 6.0f, -3.0f);
        this.ArmRight03.addBox(-2.5f, 0.0f, -2.5f, 5, 5, 5, 0.0f);
        this.HatBase2 = new ModelRenderer(this, 0, 0);
        this.HatBase2.setRotationPoint(0.0f, -8.0f, 0.0f);
        this.HatBase2.addBox(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.HatBase2, -0.2618f, 0.0f, 0.0f);
        this.Hat201_01 = new ModelRenderer(this, 98, 46);
        this.Hat201_01.mirror = true;
        this.Hat201_01.setRotationPoint(0.0f, 0.0f, -9.0f);
        this.Hat201_01.addBox(0.0f, -9.0f, 0.0f, 9, 9, 1, 0.0f);
        this.Hat201_02 = new ModelRenderer(this, 98, 46);
        this.Hat201_02.setRotationPoint(0.0f, 0.0f, -9.0f);
        this.Hat201_02.addBox(-9.0f, -9.0f, 0.0f, 9, 9, 1, 0.0f);
        this.Hat201_03 = new ModelRenderer(this, 98, 46);
        this.Hat201_03.mirror = true;
        this.Hat201_03.setRotationPoint(0.0f, 0.0f, 8.0f);
        this.Hat201_03.addBox(0.0f, -9.0f, 0.0f, 9, 9, 1, 0.0f);
        this.Hat201_04 = new ModelRenderer(this, 98, 46);
        this.Hat201_04.setRotationPoint(0.0f, 0.0f, 8.0f);
        this.Hat201_04.addBox(-9.0f, -9.0f, 0.0f, 9, 9, 1, 0.0f);
        this.Hat201_05 = new ModelRenderer(this, 98, 46);
        this.Hat201_05.mirror = true;
        this.Hat201_05.setRotationPoint(8.0f, 0.0f, 0.0f);
        this.Hat201_05.addBox(0.0f, -9.0f, 0.0f, 9, 9, 1, 0.0f);
        this.setRotateAngle(this.Hat201_05, 0.0f, 1.5707964f, 0.0f);
        this.Hat201_06 = new ModelRenderer(this, 98, 46);
        this.Hat201_06.setRotationPoint(8.0f, 0.0f, 9.0f);
        this.Hat201_06.addBox(0.0f, -9.0f, 0.0f, 9, 9, 1, 0.0f);
        this.setRotateAngle(this.Hat201_06, 0.0f, 1.5707964f, 0.0f);
        this.Hat201_07 = new ModelRenderer(this, 98, 46);
        this.Hat201_07.mirror = true;
        this.Hat201_07.setRotationPoint(-9.0f, 0.0f, 0.0f);
        this.Hat201_07.addBox(0.0f, -9.0f, 0.0f, 9, 9, 1, 0.0f);
        this.setRotateAngle(this.Hat201_07, 0.0f, 1.5707964f, 0.0f);
        this.Hat201_08 = new ModelRenderer(this, 98, 46);
        this.Hat201_08.setRotationPoint(-9.0f, 0.0f, 9.0f);
        this.Hat201_08.addBox(0.0f, -9.0f, 0.0f, 9, 9, 1, 0.0f);
        this.setRotateAngle(this.Hat201_08, 0.0f, 1.5707964f, 0.0f);
        this.Hat201_09 = new ModelRenderer(this, 98, 46);
        this.Hat201_09.mirror = true;
        this.Hat201_09.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.Hat201_09.addBox(0.0f, 0.0f, 0.0f, 9, 9, 1, 0.0f);
        this.setRotateAngle(this.Hat201_09, -1.5707964f, 0.0f, 0.0f);
        this.Hat201_10 = new ModelRenderer(this, 98, 46);
        this.Hat201_10.setRotationPoint(-9.0f, -9.0f, 0.0f);
        this.Hat201_10.addBox(0.0f, 0.0f, 0.0f, 9, 9, 1, 0.0f);
        this.setRotateAngle(this.Hat201_10, -1.5707964f, 0.0f, 0.0f);
        this.Hat201_11 = new ModelRenderer(this, 98, 46);
        this.Hat201_11.mirror = true;
        this.Hat201_11.setRotationPoint(0.0f, -9.0f, 9.0f);
        this.Hat201_11.addBox(0.0f, 0.0f, 0.0f, 9, 9, 1, 0.0f);
        this.setRotateAngle(this.Hat201_11, -1.5707964f, 0.0f, 0.0f);
        this.Hat201_12 = new ModelRenderer(this, 98, 46);
        this.Hat201_12.setRotationPoint(-9.0f, -9.0f, 9.0f);
        this.Hat201_12.addBox(0.0f, 0.0f, 0.0f, 9, 9, 1, 0.0f);
        this.setRotateAngle(this.Hat201_12, -1.5707964f, 0.0f, 0.0f);
        this.Hat202a = new ModelRenderer(this, 46, 8);
        this.Hat202a.setRotationPoint(9.5f, -2.5f, 0.0f);
        this.Hat202a.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.setRotateAngle(this.Hat202a, 0.0f, 1.57f, -0.08726646f);
        this.Hat202b = new ModelRenderer(this, 46, 8);
        this.Hat202b.setRotationPoint(-9.5f, -2.5f, 0.0f);
        this.Hat202b.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.setRotateAngle(this.Hat202b, 0.0f, 1.57f, 0.08726646f);
        this.EquipTR02.addChild(this.EquipTR02f);
        this.Butt.addChild(this.LegLeft01);
        this.BodyMain.addChild(this.Cloth01);
        this.EquipTR02.addChild(this.EquipTR02a);
        this.EquipMain01.addChild(this.EquipMain04);
        this.Cloth01.addChild(this.Cloth02);
        this.ArmLeft01.addChild(this.ArmLeft02);
        this.EquipTL02.addChild(this.EquipTL02d);
        this.Hair01.addChild(this.Hair02b1);
        this.HatBase.addChild(this.Hat03c);
        this.EquipHead02.addChild(this.EquipHead04);
        this.EquipBase.addChild(this.EquipMain01);
        this.EquipTR02.addChild(this.EquipTR02e);
        this.EquipMain03.addChild(this.EquipHead01);
        this.EquipTL02.addChild(this.EquipTL02b);
        this.Hair.addChild(this.HairU01);
        this.HatBase.addChild(this.Hat01a);
        this.Hair01.addChild(this.Hair02a1);
        this.EquipHead02.addChild(this.EquipHead05);
        this.EquipMain01.addChild(this.EquipMain03);
        this.Skirt01.addChild(this.Skirt02);
        this.EquipTR02.addChild(this.EquipTR02d);
        this.HatBase.addChild(this.Hat01b);
        this.LegRight01.addChild(this.LegRight02);
        this.EquipC02.addChild(this.EquipC03);
        this.HatBase.addChild(this.Hat01c);
        this.ArmRight01.addChild(this.ArmRight02);
        this.EquipC02.addChild(this.EquipC05a);
        this.EquipHead02.addChild(this.EquipHead03);
        this.Hair02f1.addChild(this.Hair02f2);
        this.ArmLeft02.addChild(this.ArmLeft03);
        this.LegLeft01.addChild(this.LegLeft02);
        this.BodyMain.addChild(this.Butt);
        this.EquipTL02.addChild(this.EquipTL02e);
        this.BodyMain.addChild(this.ArmLeft01);
        this.Hair02b1.addChild(this.Hair02b2);
        this.Hair01.addChild(this.Hair02e1);
        this.EquipC02.addChild(this.EquipC04a);
        this.Butt.addChild(this.Skirt01);
        this.HatBase.addChild(this.Hat03d);
        this.Hair.addChild(this.HairR01);
        this.EquipTL02.addChild(this.EquipTL02a);
        this.HatBase.addChild(this.Hat02b);
        this.EquipMain01.addChild(this.EquipTR02);
        this.Hair.addChild(this.Ahoke);
        this.ArmLeft02.addChild(this.EquipTL03);
        this.LegLeft02.addChild(this.LegLeft03);
        this.Hair02d1.addChild(this.Hair02d2);
        this.EquipMain01.addChild(this.EquipMain02);
        this.HairMain.addChild(this.HatBase);
        this.HatBase.addChild(this.Hat01d);
        this.EquipC01.addChild(this.EquipC02);
        this.Hair01.addChild(this.Hair02d1);
        this.EquipMain01.addChild(this.EquipTL02);
        this.HairMain.addChild(this.Hair01);
        this.Hair02e1.addChild(this.Hair02e2);
        this.HatBase.addChild(this.Hat03a);
        this.EquipBase.addChild(this.EquipC01);
        this.EquipTR02.addChild(this.EquipTR02b);
        this.Hair01.addChild(this.Hair02c1);
        this.Hair02c1.addChild(this.Hair02c2);
        this.HatBase.addChild(this.Hat03b);
        this.EquipTL02.addChild(this.EquipTL02c);
        this.HairMain.addChild(this.Hair02f1);
        this.Hair.addChild(this.HairL01);
        this.Head.addChild(this.HairMain);
        this.BodyMain.addChild(this.EquipBase);
        this.Hair02a1.addChild(this.Hair02a2);
        this.EquipTL02.addChild(this.EquipTL02f);
        this.HairR01.addChild(this.HairR02);
        this.LegRight02.addChild(this.LegRight03);
        this.EquipHead01.addChild(this.EquipHead02);
        this.Head.addChild(this.Hair);
        this.BodyMain.addChild(this.Head);
        this.HatBase.addChild(this.Hat02a);
        this.Butt.addChild(this.LegRight01);
        this.EquipTR02.addChild(this.EquipTR02c);
        this.HairL01.addChild(this.HairL02);
        this.BodyMain.addChild(this.ArmRight01);
        this.EquipC04a.addChild(this.EquipC04b);
        this.EquipC05a.addChild(this.EquipC05b);
        this.ArmRight02.addChild(this.ArmRight03);
        this.GlowBodyMain = new ModelRenderer(this, 0, 0);
        this.GlowBodyMain.setRotationPoint(0.0f, -9.0f, 0.0f);
        this.GlowHead = new ModelRenderer(this, 0, 0);
        this.GlowHead.setRotationPoint(0.0f, -11.8f, -1.0f);
        this.Face0 = new ModelRenderer(this, 98, 63);
        this.Face0.setRotationPoint(0.0f, -12.2f, -6.1f);
        this.Face0.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Face1 = new ModelRenderer(this, 98, 76);
        this.Face1.setRotationPoint(0.0f, -12.2f, -6.1f);
        this.Face1.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Face2 = new ModelRenderer(this, 98, 89);
        this.Face2.setRotationPoint(0.0f, -12.2f, -6.1f);
        this.Face2.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Face3 = new ModelRenderer(this, 98, 102);
        this.Face3.setRotationPoint(0.0f, -12.2f, -6.1f);
        this.Face3.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Face4 = new ModelRenderer(this, 98, 115);
        this.Face4.setRotationPoint(0.0f, -12.2f, -6.1f);
        this.Face4.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Mouth0 = new ModelRenderer(this, 22, 52);
        this.Mouth0.setRotationPoint(0.0f, -4.2f, -6.2f);
        this.Mouth0.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.Mouth1 = new ModelRenderer(this, 100, 58);
        this.Mouth1.setRotationPoint(0.0f, -4.2f, -6.2f);
        this.Mouth1.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.Mouth2 = new ModelRenderer(this, 114, 56);
        this.Mouth2.setRotationPoint(0.0f, -4.2f, -6.2f);
        this.Mouth2.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.Flush0 = new ModelRenderer(this, 114, 61);
        this.Flush0.setRotationPoint(-6.0f, -3.0f, -6.8f);
        this.Flush0.addBox(-1.0f, 0.0f, -0.5f, 2, 1, 0, 0.0f);
        this.Flush1 = new ModelRenderer(this, 114, 61);
        this.Flush1.setRotationPoint(6.0f, -3.0f, -6.8f);
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
        this.GlowHead.addChild(this.HatBase2);
        this.HatBase2.addChild(this.Hat201_01);
        this.HatBase2.addChild(this.Hat201_02);
        this.HatBase2.addChild(this.Hat201_03);
        this.HatBase2.addChild(this.Hat201_04);
        this.HatBase2.addChild(this.Hat201_05);
        this.HatBase2.addChild(this.Hat201_06);
        this.HatBase2.addChild(this.Hat201_07);
        this.HatBase2.addChild(this.Hat201_08);
        this.HatBase2.addChild(this.Hat201_09);
        this.HatBase2.addChild(this.Hat201_10);
        this.HatBase2.addChild(this.Hat201_11);
        this.HatBase2.addChild(this.Hat201_12);
        this.HatBase2.addChild(this.Hat202a);
        this.HatBase2.addChild(this.Hat202b);
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
        this.EquipTL03.isHidden = !EmotionHelper.checkModelState(1, state);
        boolean fh1 = EmotionHelper.checkModelState(2, state);
        boolean fh2 = EmotionHelper.checkModelState(3, state);
        boolean fh3 = EmotionHelper.checkModelState(4, state);
        if (fh1) {
            this.HatBase.isHidden = false;
            this.Hair02f1.isHidden = false;
            this.Hair01.isHidden = false;
            this.HatBase2.isHidden = true;
        } else if (fh2 && fh3) {
            this.HatBase.isHidden = true;
            this.Hair01.isHidden = true;
            this.Hair02f1.isHidden = true;
            this.HatBase2.isHidden = false;
            this.HatBase2.rotateAngleX = -1.35f;
            this.HatBase2.offsetY = 0.0f;
            this.HatBase2.offsetZ = 0.1f;
        } else if (fh2) {
            this.HatBase.isHidden = true;
            this.Hair02f1.isHidden = true;
            this.Hair01.isHidden = false;
            this.HatBase2.isHidden = false;
            this.HatBase2.rotateAngleX = -0.2618f;
            this.HatBase2.offsetY = 0.0f;
            this.HatBase2.offsetZ = 0.0f;
        } else if (fh3) {
            this.HatBase.isHidden = true;
            this.Hair02f1.isHidden = true;
            this.Hair01.isHidden = false;
            this.HatBase2.isHidden = false;
            this.HatBase2.rotateAngleX = -0.7f;
            this.HatBase2.offsetY = -0.06f;
            this.HatBase2.offsetZ = 0.06f;
        } else {
            this.HatBase.isHidden = true;
            this.Hair02f1.isHidden = false;
            this.Hair01.isHidden = false;
            this.HatBase2.isHidden = true;
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
        GlStateManager.translate(0.0f, 0.51f + 0.25f * ent.getScaleLevel(), 0.0f);
        this.setFaceHungry(ent);
        this.Head.rotateAngleX = 0.0f;
        this.Head.rotateAngleY = 0.0f;
        this.Head.rotateAngleZ = 0.0f;
        this.Ahoke.rotateAngleY = 0.5236f;
        this.BodyMain.rotateAngleX = 1.4f;
        this.Butt.rotateAngleX = 0.21f;
        this.Butt.offsetY = 0.0f;
        this.Skirt01.rotateAngleX = -0.052f;
        this.Skirt01.offsetY = 0.0f;
        this.Skirt02.rotateAngleX = -0.052f;
        this.Skirt02.offsetY = 0.0f;
        this.Hair01.rotateAngleX = -0.07f;
        this.Hair01.offsetY = -0.2f;
        this.ArmLeft01.rotateAngleX = -2.8f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = 0.7f;
        this.ArmRight01.rotateAngleX = -2.8f;
        this.ArmRight01.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleZ = -0.7f;
        this.ArmLeft02.rotateAngleZ = 1.0f;
        this.ArmLeft02.offsetX = 0.0f;
        this.ArmRight02.rotateAngleZ = -1.0f;
        this.ArmRight02.offsetX = 0.0f;
        this.LegLeft01.rotateAngleX = 0.1f;
        this.LegLeft01.rotateAngleY = 3.1415f;
        this.LegLeft01.rotateAngleZ = -0.1f;
        this.LegRight01.rotateAngleX = 0.1f;
        this.LegRight01.rotateAngleY = 3.1415f;
        this.LegRight01.rotateAngleZ = 0.1f;
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
        float headX;
        float headZ;
        if (ent.getShipDepth(0) > 0.0 || ent.getShipDepth(1) > 0.0) {
            GlStateManager.translate(0.0f, angleX * 0.05f + 0.025f, 0.0f);
        }
        addk1 = angleAdd1 * 0.5f - 0.14f;
        addk2 = angleAdd2 * 0.5f - 0.0523f;
        this.Head.rotateAngleX = f4 * 0.014f + 0.11f;
        this.Head.rotateAngleY = f3 * 0.01f;
        this.Ahoke.rotateAngleY = angleX * 0.2f + 1.2f;
        this.BodyMain.rotateAngleX = -0.1047f;
        this.BodyMain.rotateAngleY = 0.0f;
        this.BodyMain.rotateAngleZ = 0.0f;
        this.Butt.rotateAngleX = 0.21f;
        this.Butt.offsetY = 0.0f;
        this.Skirt01.rotateAngleX = -0.052f;
        this.Skirt01.offsetY = 0.0f;
        this.Skirt02.rotateAngleX = -0.052f;
        this.Skirt02.offsetY = 0.0f;
        this.Hair01.rotateAngleX = angleX * 0.04f + 0.26f;
        this.Hair01.rotateAngleZ = 0.0f;
        this.Hair01.offsetY = 0.0f;
        this.Hair02a1.rotateAngleX = -angleX1 * 0.1f + 0.26f;
        this.Hair02a1.rotateAngleZ = 0.0f;
        this.Hair02b1.rotateAngleX = -angleX1 * 0.1f + 0.26f;
        this.Hair02b1.rotateAngleZ = 0.26f;
        this.Hair02c1.rotateAngleX = -angleX1 * 0.1f + 0.17f;
        this.Hair02c1.rotateAngleZ = -0.4f;
        this.Hair02d1.rotateAngleX = 0.2618f;
        this.Hair02d1.rotateAngleZ = -angleX1 * 0.05f + 0.35f;
        this.Hair02e1.rotateAngleX = 0.05f;
        this.Hair02e1.rotateAngleZ = angleX1 * 0.05f - 0.6f;
        this.Hair02a2.rotateAngleX = -angleX2 * 0.13f - 0.26f;
        this.Hair02b2.rotateAngleX = -angleX2 * 0.13f - 0.44f;
        this.Hair02c2.rotateAngleX = -angleX2 * 0.13f - 0.35f;
        this.Hair02d2.rotateAngleZ = -angleX2 * 0.07f - 0.52f;
        this.Hair02e2.rotateAngleZ = angleX2 * 0.07f + 0.87f;
        this.HairL01.rotateAngleX = angleX * 0.04f + -0.2618f;
        this.HairL01.rotateAngleZ = 0.087f;
        this.HairL02.rotateAngleX = -angleX1 * 0.1f + 0.3142f;
        this.HairL02.rotateAngleZ = 0.0873f;
        this.HairR01.rotateAngleX = angleX * 0.04f + -0.2618f;
        this.HairR01.rotateAngleZ = -0.0873f;
        this.HairR02.rotateAngleX = -angleX1 * 0.1f + 0.21f;
        this.HairR02.rotateAngleZ = -0.0873f;
        this.ArmLeft01.rotateAngleX = angleAdd2 * 0.25f + 0.1745f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = angleX * 0.03f - 0.3f;
        this.ArmLeft02.rotateAngleX = 0.0f;
        this.ArmLeft02.rotateAngleZ = 0.0f;
        this.ArmLeft02.offsetX = 0.0f;
        this.ArmRight01.rotateAngleX = angleAdd1 * 0.25f - 0.0523f;
        this.ArmRight01.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleZ = -angleX * 0.03f + 0.3f;
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
        this.EquipHead01.rotateAngleZ = angleX * 0.2f - 1.5708f;
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
        if (ent.getIsSprinting() || f1 > 0.95f) {
            this.Head.rotateAngleX -= 0.25f;
            this.BodyMain.rotateAngleX = 0.1f;
            this.Skirt01.rotateAngleX = -0.1f;
            this.Skirt02.rotateAngleX = -0.1885f;
            this.ArmLeft01.rotateAngleX = 0.35f;
            this.ArmLeft01.rotateAngleZ = -0.5f;
            this.ArmRight01.rotateAngleX = 0.35f;
            this.ArmRight01.rotateAngleZ = 0.5f;
            addk1 -= 0.2f;
            addk2 -= 0.2f;
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
        if (((IShipRiderType) ent).getRiderType() > 0) {
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
            this.ArmRight01.rotateAngleX = -0.3f;
            this.ArmRight01.rotateAngleY = 0.2f;
            this.ArmRight01.rotateAngleZ = 0.0f;
            this.ArmRight02.rotateAngleX = -1.2f;
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
            if (ent.getIsSitting()) {
                GL11.glTranslatef(0.0f, 0.21f, 0.0f);
                this.ArmLeft01.rotateAngleX = -0.6f;
                this.ArmLeft01.rotateAngleY = 0.0f;
                this.ArmLeft01.rotateAngleZ = 0.2f;
                this.ArmLeft02.rotateAngleX = 0.0f;
                this.ArmRight01.rotateAngleX = -0.6f;
                this.ArmRight01.rotateAngleY = 0.0f;
                this.ArmRight01.rotateAngleZ = -0.2f;
                this.ArmRight02.rotateAngleX = 0.0f;
            }
            if (((IShipRiderType) ent).getRiderType() > 1) {
                this.Head.rotateAngleY *= 0.5f;
                this.Head.rotateAngleZ = 0.0f;
                this.ArmLeft01.rotateAngleX = -0.8f;
                this.ArmLeft01.rotateAngleY = -1.5f;
                this.ArmLeft01.rotateAngleZ = 0.0f;
                this.ArmLeft02.rotateAngleX = 0.0f;
                this.ArmLeft02.rotateAngleZ = 1.45f;
                this.ArmRight01.rotateAngleX = -0.8f;
                this.ArmRight01.rotateAngleY = 1.5f;
                this.ArmRight01.rotateAngleZ = 0.0f;
                this.ArmRight02.rotateAngleX = 0.0f;
                this.ArmRight02.rotateAngleZ = -1.45f;
                this.EquipBase.isHidden = true;
                if (ent.getIsSitting()) {
                    this.Head.rotateAngleX -= 0.1f;
                    this.BodyMain.rotateAngleX = 0.0f;
                    this.Butt.rotateAngleX = -0.2f;
                    this.Butt.offsetY = -0.1f;
                    this.Skirt01.rotateAngleX = -0.07f;
                    this.Skirt01.offsetY = -0.05f;
                    this.Skirt02.rotateAngleX = -0.16f;
                    this.Skirt02.offsetY = -0.08f;
                    addk1 = -0.65f;
                    addk2 = -0.65f;
                    this.LegLeft01.rotateAngleY = 0.2f;
                    this.LegLeft01.rotateAngleZ = 0.0f;
                    this.LegLeft02.offsetZ = 0.375f;
                    this.LegLeft02.rotateAngleX = 2.45f;
                    this.LegLeft02.rotateAngleZ = 0.0175f;
                    this.LegRight01.rotateAngleY = -0.2f;
                    this.LegRight01.rotateAngleZ = 0.0f;
                    this.LegRight02.offsetZ = 0.375f;
                    this.LegRight02.rotateAngleX = 2.45f;
                    this.LegRight02.rotateAngleZ = -0.0175f;
                }
            }
        } else if (ent.getIsSitting() || ent.getIsRiding()) {
            if (ent.getStateEmotion(1) == 4) {
                GlStateManager.translate(0.0f, 0.52f, 0.0f);
                this.setFaceBlink1(ent);
                this.Head.rotateAngleX = -0.9f;
                this.Head.rotateAngleY = -1.1f;
                this.Head.rotateAngleZ = 0.0f;
                this.BodyMain.rotateAngleX = 1.4f;
                this.Hair01.rotateAngleX -= 0.1f;
                this.Hair01.offsetY = -0.2f;
                addk1 = -0.1f;
                addk2 = 0.0f;
                this.LegLeft01.rotateAngleY = 0.0f;
                this.LegLeft01.rotateAngleZ = 0.2f;
                this.LegRight01.rotateAngleY = 0.0f;
                this.LegRight01.rotateAngleZ = -0.2f;
                this.LegRight02.rotateAngleX = 0.3f;
                this.ArmLeft01.rotateAngleX = -2.8f;
                this.ArmLeft01.rotateAngleY = 0.0f;
                this.ArmLeft01.rotateAngleZ = -0.2f;
                this.ArmRight01.rotateAngleX = -2.8f;
                this.ArmRight01.rotateAngleY = 0.0f;
                this.ArmRight01.rotateAngleZ = -0.7f;
                this.ArmLeft02.rotateAngleZ = 0.5f;
                this.ArmLeft02.offsetX = 0.0f;
                this.ArmRight02.rotateAngleZ = -1.0f;
                this.ArmRight02.offsetX = 0.0f;
            } else {
                GlStateManager.translate(0.0f, 0.3f, 0.0f);
                this.Head.rotateAngleX -= 0.1f;
                this.BodyMain.rotateAngleX = 0.0f;
                this.Butt.rotateAngleX = -0.2f;
                this.Butt.offsetY = -0.1f;
                this.Skirt01.rotateAngleX = -0.07f;
                this.Skirt01.offsetY = -0.05f;
                this.Skirt02.rotateAngleX = -0.16f;
                this.Skirt02.offsetY = -0.08f;
                this.ArmLeft01.rotateAngleX = -0.4f;
                this.ArmLeft01.rotateAngleZ = 0.15f;
                this.ArmRight01.rotateAngleX = -0.4f;
                this.ArmRight01.rotateAngleZ = -0.15f;
                addk1 = -0.65f;
                addk2 = -0.65f;
                this.LegLeft01.rotateAngleY = 0.2f;
                this.LegLeft01.rotateAngleZ = 0.0f;
                this.LegLeft02.offsetZ = 0.375f;
                this.LegLeft02.rotateAngleX = 2.45f;
                this.LegLeft02.rotateAngleZ = 0.0175f;
                this.LegRight01.rotateAngleY = -0.2f;
                this.LegRight01.rotateAngleZ = 0.0f;
                this.LegRight02.offsetZ = 0.375f;
                this.LegRight02.rotateAngleX = 2.45f;
                this.LegRight02.rotateAngleZ = -0.0175f;
            }
        }
        if (ent.getAttackTick() > 30) {
            this.setFaceAttack(ent);
            this.ArmLeft01.rotateAngleX = -1.55f;
            this.ArmLeft01.rotateAngleY = 0.3f;
            this.ArmLeft01.rotateAngleZ = 0.0f;
            this.ArmLeft02.rotateAngleX = 0.0f;
            this.ArmLeft02.rotateAngleZ = 0.7f;
            this.ArmRight01.rotateAngleX = -1.7f;
            this.ArmRight01.rotateAngleY = -0.1f;
            this.ArmRight01.rotateAngleZ = 1.5f;
            this.ArmRight02.rotateAngleX = 0.0f;
            this.ArmRight02.rotateAngleZ = 0.0f;
        }
        if ((f6 = ent.getSwingTime(f2 - (int)f2)) != 0.0f) {
            float f7 = MathHelper.sin(f6 * f6 * (float)Math.PI);
            float f8 = MathHelper.sin(MathHelper.sqrt(f6) * (float)Math.PI);
            this.ArmRight01.rotateAngleX += -f8 * 80.0f * ((float)Math.PI / 180);
            this.ArmRight01.rotateAngleY += -f7 * 20.0f * ((float)Math.PI / 180) + 0.2f;
            this.ArmRight01.rotateAngleZ += -f8 * 20.0f * ((float)Math.PI / 180);
        }
        if (ent.getStateEmotion(6) == 1) {
            this.setFaceShy(ent);
            this.Head.rotateAngleX += 0.6f;
            this.ArmLeft01.rotateAngleX = -0.44f;
            this.ArmLeft01.rotateAngleY = 0.0f;
            this.ArmLeft01.rotateAngleZ = 0.4f;
            this.ArmLeft02.rotateAngleZ = 0.0f;
            this.ArmLeft02.offsetX = 0.0f;
            this.ArmRight01.rotateAngleX = -0.4f;
            this.ArmRight01.rotateAngleY = 0.0f;
            this.ArmRight01.rotateAngleZ = -0.4f;
            this.ArmRight02.rotateAngleZ = 0.0f;
            this.ArmRight02.offsetX = 0.0f;
        }
        headX = this.Head.rotateAngleX * -0.5f;
        headZ = this.Head.rotateAngleZ * -0.5f;
        this.Hair01.rotateAngleX += headX;
        this.Hair01.rotateAngleZ += headZ;
        this.Hair02a1.rotateAngleX += headX;
        this.Hair02a1.rotateAngleZ += headZ;
        this.Hair02b1.rotateAngleX += headX;
        this.Hair02b1.rotateAngleZ += headZ;
        this.Hair02c1.rotateAngleX += headX;
        this.Hair02c1.rotateAngleZ += headZ;
        this.Hair02d1.rotateAngleX += headX;
        this.Hair02d1.rotateAngleZ += headZ;
        this.Hair02e1.rotateAngleX += headX;
        this.Hair02e1.rotateAngleZ += headZ;
        this.HairL01.rotateAngleZ += headZ;
        this.HairL02.rotateAngleZ += headZ;
        this.HairR01.rotateAngleZ += headZ;
        this.HairR02.rotateAngleZ += headZ * 2.0f;
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
