package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelCarrierWo
extends ShipModelBaseAdv {
    private final ModelRenderer BodyMain;
    private final ModelRenderer Butt;
    private final ModelRenderer ArmLeft01;
    private final ModelRenderer ArmRight01;
    private final ModelRenderer ArmLeft02;
    private final ModelRenderer ArmRight02;
    private final ModelRenderer Neck;
    private final ModelRenderer Neck02;
    private final ModelRenderer BoobR;
    private final ModelRenderer BoobL;
    private final ModelRenderer CloakNeck;
    private final ModelRenderer LegRight01;
    private final ModelRenderer LegLeft01;
    private final ModelRenderer LegRight02;
    private final ModelRenderer LegLeft02;
    private final ModelRenderer ShoesRight;
    private final ModelRenderer ShoesLeft;
    private final ModelRenderer Staff;
    private final ModelRenderer StaffHead;
    private final ModelRenderer Head;
    private final ModelRenderer Hair;
    private final ModelRenderer Ahoke;
    private final ModelRenderer HairL01;
    private final ModelRenderer Hair00a;
    private final ModelRenderer Hair00b;
    private final ModelRenderer HairR01;
    private final ModelRenderer HairL02;
    private final ModelRenderer HairR02;
    private final ModelRenderer EquipBase;
    private final ModelRenderer Equip01;
    private final ModelRenderer Equip02;
    private final ModelRenderer Equip03;
    private final ModelRenderer Equip04;
    private final ModelRenderer EquipEye01;
    private final ModelRenderer EquipEye02;
    private final ModelRenderer EquipT01L;
    private final ModelRenderer EquipT01R;
    private final ModelRenderer Equip05;
    private final ModelRenderer Equip06;
    private final ModelRenderer EquipLC01;
    private final ModelRenderer EquipRC01;
    private final ModelRenderer EquipTB01L;
    private final ModelRenderer EquipTB01R;
    private final ModelRenderer EquipTooth01;
    private final ModelRenderer EquipTooth02;
    private final ModelRenderer EquipTooth03;
    private final ModelRenderer EquipT02L;
    private final ModelRenderer EquipT03L;
    private final ModelRenderer EquipT02R;
    private final ModelRenderer EquipT03R;
    private final ModelRenderer EquipLC02;
    private final ModelRenderer EquipLC03;
    private final ModelRenderer EquipRC02;
    private final ModelRenderer EquipRC03;
    private final ModelRenderer EquipTB02L;
    private final ModelRenderer EquipTB03L;
    private final ModelRenderer EquipTB02R;
    private final ModelRenderer EquipTB03R;
    private final ModelRenderer Cloak01;
    private final ModelRenderer Cloak02;
    private final ModelRenderer Cloak03;
    private final ModelRenderer Neck03;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowHead;
    private final ModelRenderer GlowEquipBase;

    public ModelCarrierWo() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.scale = 0.44f;
        this.offsetY = 1.9f;
        this.offsetItem = new float[]{0.11f, 0.92f, -0.09f};
        this.offsetBlock = new float[]{0.11f, 0.92f, -0.09f};
        this.Head = new ModelRenderer(this, 43, 101);
        this.Head.setRotationPoint(0.0f, -13.0f, -0.5f);
        this.Head.addBox(-7.0f, -14.0f, -6.5f, 14, 14, 13, 0.0f);
        this.Neck03 = new ModelRenderer(this, 8, 0);
        this.Neck03.setRotationPoint(0.0f, -11.9f, -0.0f);
        this.Neck03.addBox(-2.5f, -2.0f, -2.5f, 5, 2, 5, 0.0f);
        this.EquipLC02 = new ModelRenderer(this, 128, 0);
        this.EquipLC02.setRotationPoint(-1.0f, -2.0f, -7.0f);
        this.EquipLC02.addBox(-1.5f, -1.5f, -17.0f, 3, 3, 17, 0.0f);
        this.setRotateAngle(this.EquipLC02, -0.10471976f, 0.0f, 0.0f);
        this.EquipTB03R = new ModelRenderer(this, 21, 56);
        this.EquipTB03R.setRotationPoint(0.0f, 13.5f, 0.0f);
        this.EquipTB03R.addBox(-2.0f, -2.0f, -2.0f, 4, 15, 4, 0.0f);
        this.setRotateAngle(this.EquipTB03R, 0.6981317f, 0.0f, -0.7853982f);
        this.EquipLC03 = new ModelRenderer(this, 128, 0);
        this.EquipLC03.setRotationPoint(0.0f, 2.0f, -7.0f);
        this.EquipLC03.addBox(-1.5f, -1.5f, -16.0f, 3, 3, 16, 0.0f);
        this.setRotateAngle(this.EquipLC03, 0.10471976f, 0.0f, 0.0f);
        this.EquipT02L = new ModelRenderer(this, 21, 56);
        this.EquipT02L.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.EquipT02L.addBox(-3.0f, -2.0f, -3.0f, 6, 22, 6, 0.0f);
        this.setRotateAngle(this.EquipT02L, -0.17453292f, 0.0f, -0.2617994f);
        this.ShoesRight = new ModelRenderer(this, 0, 109);
        this.ShoesRight.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.ShoesRight.addBox(-3.5f, 4.5f, -0.5f, 7, 9, 7, 0.0f);
        this.Equip05 = new ModelRenderer(this, 104, 4);
        this.Equip05.setRotationPoint(0.0f, -5.0f, 2.5f);
        this.Equip05.addBox(-24.0f, -18.0f, -15.0f, 48, 18, 28, 0.0f);
        this.setRotateAngle(this.Equip05, (float)Math.PI / 90, 0.0f, 0.0f);
        this.EquipTB03L = new ModelRenderer(this, 21, 56);
        this.EquipTB03L.setRotationPoint(0.0f, 13.5f, 0.0f);
        this.EquipTB03L.addBox(-2.0f, -2.0f, -2.0f, 4, 15, 4, 0.0f);
        this.setRotateAngle(this.EquipTB03L, 0.6981317f, 0.0f, 0.7853982f);
        this.Equip03 = new ModelRenderer(this, 112, 0);
        this.Equip03.setRotationPoint(0.0f, -5.5f, 4.0f);
        this.Equip03.addBox(-16.0f, -18.0f, -20.0f, 32, 18, 40, 0.0f);
        this.setRotateAngle(this.Equip03, 0.06981317f, 0.0f, 0.0f);
        this.Hair = new ModelRenderer(this, 128, 61);
        this.Hair.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.Hair.addBox(-8.0f, -8.0f, -7.2f, 16, 14, 7, 0.0f);
        this.HairR01 = new ModelRenderer(this, 175, 61);
        this.HairR01.mirror = true;
        this.HairR01.setRotationPoint(-6.0f, 0.0f, -2.0f);
        this.HairR01.addBox(-1.0f, 0.0f, -2.0f, 2, 9, 4, 0.0f);
        this.setRotateAngle(this.HairR01, -0.5235988f, 0.17453292f, 0.31415927f);
        this.HairR02 = new ModelRenderer(this, 176, 74);
        this.HairR02.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.HairR02.addBox(-1.0f, 0.0f, -2.2f, 2, 9, 3, 0.0f);
        this.setRotateAngle(this.HairR02, 0.34906584f, 0.0f, -0.2617994f);
        this.HairL01 = new ModelRenderer(this, 175, 61);
        this.HairL01.setRotationPoint(6.0f, 0.0f, -2.0f);
        this.HairL01.addBox(-1.0f, 0.0f, -2.0f, 2, 9, 4, 0.0f);
        this.setRotateAngle(this.HairL01, -0.5235988f, -0.17453292f, -0.31415927f);
        this.HairL02 = new ModelRenderer(this, 176, 74);
        this.HairL02.mirror = true;
        this.HairL02.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.HairL02.addBox(-1.0f, 0.0f, -2.2f, 2, 9, 3, 0.0f);
        this.setRotateAngle(this.HairL02, 0.34906584f, 0.0f, 0.2617994f);
        this.Hair00a = new ModelRenderer(this, 128, 82);
        this.Hair00a.setRotationPoint(0.0f, 0.0f, -0.5f);
        this.Hair00a.addBox(-7.5f, -7.5f, -1.0f, 15, 8, 9, 0.0f);
        this.Hair00b = new ModelRenderer(this, 43, 21);
        this.Hair00b.setRotationPoint(0.0f, 0.3f, -2.5f);
        this.Hair00b.addBox(-7.5f, 0.0f, 0.0f, 15, 10, 10, 0.0f);
        this.setRotateAngle(this.Hair00b, 0.17453292f, 0.0f, 0.0f);
        this.EquipT03L = new ModelRenderer(this, 21, 56);
        this.EquipT03L.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.EquipT03L.addBox(-2.5f, -2.0f, -2.5f, 5, 20, 5, 0.0f);
        this.setRotateAngle(this.EquipT03L, 1.0471976f, 0.0f, 0.7853982f);
        this.LegLeft01 = new ModelRenderer(this, 0, 88);
        this.LegLeft01.mirror = true;
        this.LegLeft01.setRotationPoint(4.2f, 5.0f, -1.0f);
        this.LegLeft01.addBox(-3.0f, 0.0f, -3.0f, 6, 12, 6, 0.0f);
        this.LegLeft02 = new ModelRenderer(this, 1, 110);
        this.LegLeft02.mirror = true;
        this.LegLeft02.setRotationPoint(0.0f, 12.0f, -3.0f);
        this.LegLeft02.addBox(-3.0f, 0.0f, 0.0f, 6, 7, 6, 0.0f);
        this.EquipTooth03 = new ModelRenderer(this, 128, 99);
        this.EquipTooth03.mirror = true;
        this.EquipTooth03.setRotationPoint(-12.4f, -17.0f, -20.3f);
        this.EquipTooth03.addBox(-14.0f, 0.0f, 0.0f, 14, 8, 4, 0.0f);
        this.setRotateAngle(this.EquipTooth03, 0.06981317f, 0.5235988f, -0.05235988f);
        this.EquipRC02 = new ModelRenderer(this, 128, 0);
        this.EquipRC02.setRotationPoint(1.0f, -2.0f, -7.0f);
        this.EquipRC02.addBox(-1.5f, -1.5f, -17.0f, 3, 3, 17, 0.0f);
        this.setRotateAngle(this.EquipRC02, -0.10471976f, 0.0f, 0.0f);
        this.ShoesLeft = new ModelRenderer(this, 0, 109);
        this.ShoesLeft.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.ShoesLeft.addBox(-3.5f, 4.5f, -0.5f, 7, 9, 7, 0.0f);
        this.EquipBase = new ModelRenderer(this, 0, 0);
        this.EquipBase.setRotationPoint(0.0f, -10.0f, -3.0f);
        this.EquipBase.addBox(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.EquipBase, 0.08726646f, 0.0f, 0.0f);
        this.Equip04 = new ModelRenderer(this, 112, 0);
        this.Equip04.setRotationPoint(0.0f, -7.0f, 5.5f);
        this.Equip04.addBox(-12.0f, -15.0f, -24.0f, 24, 15, 46, 0.0f);
        this.setRotateAngle(this.Equip04, 0.10471976f, 0.0f, 0.0f);
        this.EquipLC01 = new ModelRenderer(this, 128, 0);
        this.EquipLC01.setRotationPoint(30.0f, -7.0f, 4.0f);
        this.EquipLC01.addBox(-3.5f, -5.5f, -7.5f, 7, 11, 15, 0.0f);
        this.setRotateAngle(this.EquipLC01, -0.17453292f, -0.2617994f, 0.17453292f);
        this.EquipTB01L = new ModelRenderer(this, 128, 0);
        this.EquipTB01L.setRotationPoint(15.0f, -6.0f, 10.0f);
        this.EquipTB01L.addBox(-3.0f, -2.0f, -3.0f, 6, 10, 6, 0.0f);
        this.setRotateAngle(this.EquipTB01L, 0.17453292f, 0.0f, -0.34906584f);
        this.EquipEye01 = new ModelRenderer(this, 44, 0);
        this.EquipEye01.setRotationPoint(-14.5f, -21.0f, -8.0f);
        this.EquipEye01.addBox(-7.5f, -6.0f, 0.0f, 15, 6, 14, 0.0f);
        this.setRotateAngle(this.EquipEye01, 0.13962634f, 0.13962634f, -0.2617994f);
        this.EquipEye02 = new ModelRenderer(this, 44, 0);
        this.EquipEye02.setRotationPoint(14.5f, -21.0f, -8.0f);
        this.EquipEye02.addBox(-7.5f, -6.0f, 0.0f, 15, 6, 14, 0.0f);
        this.setRotateAngle(this.EquipEye02, 0.13962634f, -0.13962634f, 0.2617994f);
        this.StaffHead = new ModelRenderer(this, 38, 80);
        this.StaffHead.setRotationPoint(-0.5f, -15.0f, -1.0f);
        this.StaffHead.addBox(0.0f, -13.0f, 0.0f, 4, 13, 8, 0.0f);
        this.Equip06 = new ModelRenderer(this, 96, 0);
        this.Equip06.setRotationPoint(0.0f, -7.0f, 4.5f);
        this.Equip06.addBox(-29.0f, -13.0f, -13.0f, 58, 13, 22, 0.0f);
        this.setRotateAngle(this.Equip06, 0.06981317f, 0.0f, 0.0f);
        this.EquipT02R = new ModelRenderer(this, 21, 56);
        this.EquipT02R.setRotationPoint(0.0f, 8.0f, 0.0f);
        this.EquipT02R.addBox(-3.0f, -2.0f, -3.0f, 6, 22, 6, 0.0f);
        this.setRotateAngle(this.EquipT02R, -0.17453292f, 0.0f, 0.2617994f);
        this.Equip02 = new ModelRenderer(this, 120, 0);
        this.Equip02.setRotationPoint(0.0f, -3.0f, 2.0f);
        this.Equip02.addBox(-18.0f, -22.0f, -15.0f, 36, 22, 32, 0.0f);
        this.setRotateAngle(this.Equip02, (float)Math.PI / 90, 0.0f, 0.0f);
        this.EquipTB02L = new ModelRenderer(this, 21, 56);
        this.EquipTB02L.setRotationPoint(0.0f, 9.0f, 0.0f);
        this.EquipTB02L.addBox(-2.5f, -2.0f, -2.5f, 5, 16, 5, 0.0f);
        this.setRotateAngle(this.EquipTB02L, 0.43633232f, 0.0f, -0.34906584f);
        this.EquipT01R = new ModelRenderer(this, 128, 0);
        this.EquipT01R.setRotationPoint(-17.0f, -7.0f, -8.0f);
        this.EquipT01R.addBox(-4.0f, 0.0f, -4.0f, 8, 10, 8, 0.0f);
        this.setRotateAngle(this.EquipT01R, -0.2617994f, 0.0f, 0.2617994f);
        this.EquipTB01R = new ModelRenderer(this, 128, 0);
        this.EquipTB01R.setRotationPoint(-15.0f, -6.0f, 10.0f);
        this.EquipTB01R.addBox(-3.0f, -2.0f, -3.0f, 6, 10, 6, 0.0f);
        this.setRotateAngle(this.EquipTB01R, 0.17453292f, 0.0f, 0.34906584f);
        this.EquipRC01 = new ModelRenderer(this, 128, 0);
        this.EquipRC01.setRotationPoint(-30.0f, -7.0f, 4.0f);
        this.EquipRC01.addBox(-3.5f, -5.5f, -7.5f, 7, 11, 15, 0.0f);
        this.setRotateAngle(this.EquipRC01, -0.17453292f, 0.2617994f, -0.17453292f);
        this.EquipT03R = new ModelRenderer(this, 21, 56);
        this.EquipT03R.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.EquipT03R.addBox(-2.5f, -2.0f, -2.5f, 5, 20, 5, 0.0f);
        this.setRotateAngle(this.EquipT03R, 1.0471976f, 0.0f, -0.7853982f);
        this.EquipTooth02 = new ModelRenderer(this, 128, 99);
        this.EquipTooth02.setRotationPoint(12.4f, -17.0f, -20.3f);
        this.EquipTooth02.addBox(0.0f, 0.0f, 0.0f, 14, 8, 4, 0.0f);
        this.setRotateAngle(this.EquipTooth02, 0.10471976f, -0.5235988f, 0.05235988f);
        this.EquipTB02R = new ModelRenderer(this, 21, 56);
        this.EquipTB02R.setRotationPoint(0.0f, 9.0f, 0.0f);
        this.EquipTB02R.addBox(-2.5f, -2.0f, -2.5f, 5, 16, 5, 0.0f);
        this.setRotateAngle(this.EquipTB02R, 0.43633232f, 0.0f, 0.34906584f);
        this.Cloak01 = new ModelRenderer(this, 216, 85);
        this.Cloak01.setRotationPoint(0.0f, 6.5f, 6.0f);
        this.Cloak01.addBox(-10.0f, 0.0f, 0.0f, 20, 12, 0, 0.0f);
        this.setRotateAngle(this.Cloak01, 0.5f, 0.0f, 0.0f);
        this.CloakNeck = new ModelRenderer(this, 192, 61);
        this.CloakNeck.setRotationPoint(0.0f, -12.0f, -1.5f);
        this.CloakNeck.addBox(-10.0f, 0.0f, -6.0f, 20, 7, 12, 0.0f);
        this.setRotateAngle(this.CloakNeck, 0.31416f, 0.0f, 0.0f);
        this.ArmRight01 = new ModelRenderer(this, 0, 54);
        this.ArmRight01.setRotationPoint(-4.7f, -9.0f, 0.0f);
        this.ArmRight01.addBox(-5.0f, -1.0f, -2.0f, 5, 12, 5, 0.0f);
        this.ArmRight02 = new ModelRenderer(this, 0, 71);
        this.ArmRight02.setRotationPoint(-5.0f, 11.0f, 2.0f);
        this.ArmRight02.addBox(0.0f, 0.0f, -4.0f, 5, 12, 5, 0.0f);
        this.LegRight01 = new ModelRenderer(this, 0, 88);
        this.LegRight01.setRotationPoint(-4.2f, 5.0f, -1.0f);
        this.LegRight01.addBox(-3.0f, 0.0f, -3.0f, 6, 12, 6, 0.0f);
        this.LegRight02 = new ModelRenderer(this, 1, 110);
        this.LegRight02.setRotationPoint(0.0f, 12.0f, -3.0f);
        this.LegRight02.addBox(-3.0f, 0.0f, 0.0f, 6, 7, 6, 0.0f);
        this.EquipT01L = new ModelRenderer(this, 128, 0);
        this.EquipT01L.setRotationPoint(17.0f, -7.0f, -8.0f);
        this.EquipT01L.addBox(-4.0f, 0.0f, -4.0f, 8, 10, 8, 0.0f);
        this.setRotateAngle(this.EquipT01L, -0.2617994f, 0.0f, -0.2617994f);
        this.BodyMain = new ModelRenderer(this, 0, 0);
        this.BodyMain.setRotationPoint(0.0f, -11.0f, 0.0f);
        this.BodyMain.addBox(-6.5f, -12.0f, -4.0f, 13, 17, 7, 0.0f);
        this.setRotateAngle(this.BodyMain, -0.34906584f, 0.0f, 0.0f);
        this.Neck = new ModelRenderer(this, 46, 41);
        this.Neck.setRotationPoint(0.0f, -13.0f, -2.0f);
        this.Neck.addBox(-7.5f, -1.5f, -7.0f, 15, 4, 13, 0.0f);
        this.setRotateAngle(this.Neck, 0.41888f, 0.0f, 0.0f);
        this.Neck02 = new ModelRenderer(this, 128, 0);
        this.Neck02.setRotationPoint(0.0f, 2.0f, -5.0f);
        this.Neck02.addBox(-1.5f, 0.0f, -1.5f, 3, 5, 3, 0.0f);
        this.setRotateAngle(this.Neck02, -0.52f, 0.0f, 0.0f);
        this.Equip01 = new ModelRenderer(this, 128, 0);
        this.Equip01.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Equip01.addBox(-9.0f, -28.5f, -7.0f, 18, 27, 22, 0.0f);
        this.setRotateAngle(this.Equip01, 0.0873f, 0.0f, 0.0f);
        this.ArmLeft01 = new ModelRenderer(this, 0, 54);
        this.ArmLeft01.mirror = true;
        this.ArmLeft01.setRotationPoint(4.7f, -9.0f, 0.0f);
        this.ArmLeft01.addBox(0.0f, -1.0f, -2.0f, 5, 12, 5, 0.0f);
        this.ArmLeft02 = new ModelRenderer(this, 0, 71);
        this.ArmLeft02.mirror = true;
        this.ArmLeft02.setRotationPoint(5.0f, 11.0f, 3.0f);
        this.ArmLeft02.addBox(-5.0f, 0.0f, -5.0f, 5, 12, 5, 0.0f);
        this.Staff = new ModelRenderer(this, 128, 0);
        this.Staff.setRotationPoint(8.0f, 35.0f, 21.0f);
        this.Staff.addBox(0.0f, -15.0f, 0.0f, 3, 28, 4, 0.0f);
        this.setRotateAngle(this.Staff, 1.1838568f, -0.18203785f, -1.2292354f);
        this.Cloak02 = new ModelRenderer(this, 208, 97);
        this.Cloak02.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.Cloak02.addBox(-12.0f, 0.0f, 0.0f, 24, 16, 0, 0.0f);
        this.setRotateAngle(this.Cloak02, -0.4553564f, 0.0f, 0.0f);
        this.EquipRC03 = new ModelRenderer(this, 128, 0);
        this.EquipRC03.setRotationPoint(0.0f, 2.0f, -7.0f);
        this.EquipRC03.addBox(-1.5f, -1.5f, -16.0f, 3, 3, 16, 0.0f);
        this.setRotateAngle(this.EquipRC03, 0.10471976f, 0.0f, 0.0f);
        this.EquipTooth01 = new ModelRenderer(this, 128, 112);
        this.EquipTooth01.setRotationPoint(0.0f, -19.3f, -20.6f);
        this.EquipTooth01.addBox(-12.0f, 0.0f, 0.0f, 24, 15, 1, 0.0f);
        this.setRotateAngle(this.EquipTooth01, 0.10471976f, 0.0f, 0.0f);
        this.BoobL = new ModelRenderer(this, 3, 27);
        this.BoobL.mirror = true;
        this.BoobL.setRotationPoint(3.5f, -9.0f, -3.2f);
        this.BoobL.addBox(-3.5f, 0.0f, -1.0f, 7, 5, 4, 0.0f);
        this.setRotateAngle(this.BoobL, -0.7853982f, 0.08726646f, 0.14f);
        this.BoobR = new ModelRenderer(this, 3, 27);
        this.BoobR.setRotationPoint(-3.5f, -9.0f, -3.2f);
        this.BoobR.addBox(-3.5f, 0.0f, -1.0f, 7, 5, 4, 0.0f);
        this.setRotateAngle(this.BoobR, -0.7853982f, -0.08726646f, -0.14f);
        this.Butt = new ModelRenderer(this, 0, 38);
        this.Butt.setRotationPoint(0.0f, 4.7f, 0.5f);
        this.Butt.addBox(-7.5f, -2.0f, -4.1f, 15, 8, 8, 0.0f);
        this.setRotateAngle(this.Butt, 0.5235988f, 0.0f, 0.0f);
        this.Cloak03 = new ModelRenderer(this, 196, 113);
        this.Cloak03.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.Cloak03.addBox(-15.0f, 0.0f, 0.0f, 30, 15, 0, 0.0f);
        this.setRotateAngle(this.Cloak03, 0.34906584f, 0.0f, 0.0f);
        this.Ahoke = new ModelRenderer(this, 31, 89);
        this.Ahoke.setRotationPoint(0.0f, 0.0f, -4.5f);
        this.Ahoke.addBox(0.0f, -13.5f, -12.0f, 0, 12, 12, 0.0f);
        this.setRotateAngle(this.Ahoke, 0.0f, 0.7f, 0.0f);
        this.BodyMain.addChild(this.Head);
        this.BodyMain.addChild(this.Neck03);
        this.EquipLC01.addChild(this.EquipLC02);
        this.EquipTB02R.addChild(this.EquipTB03R);
        this.BodyMain.addChild(this.BoobL);
        this.EquipLC01.addChild(this.EquipLC03);
        this.EquipT01L.addChild(this.EquipT02L);
        this.LegRight02.addChild(this.ShoesRight);
        this.EquipBase.addChild(this.Equip05);
        this.EquipTB02L.addChild(this.EquipTB03L);
        this.EquipBase.addChild(this.Equip03);
        this.Head.addChild(this.Hair);
        this.Hair.addChild(this.Ahoke);
        this.Hair.addChild(this.HairR01);
        this.HairR01.addChild(this.HairR02);
        this.Hair.addChild(this.HairL01);
        this.HairL01.addChild(this.HairL02);
        this.Hair.addChild(this.Hair00a);
        this.Hair.addChild(this.Hair00b);
        this.EquipT02L.addChild(this.EquipT03L);
        this.Butt.addChild(this.LegLeft01);
        this.LegLeft01.addChild(this.LegLeft02);
        this.EquipBase.addChild(this.EquipTooth03);
        this.EquipRC01.addChild(this.EquipRC02);
        this.LegLeft02.addChild(this.ShoesLeft);
        this.Head.addChild(this.EquipBase);
        this.EquipBase.addChild(this.Equip04);
        this.EquipBase.addChild(this.EquipLC01);
        this.EquipBase.addChild(this.EquipTB01L);
        this.Staff.addChild(this.StaffHead);
        this.EquipBase.addChild(this.Equip06);
        this.EquipT01R.addChild(this.EquipT02R);
        this.EquipBase.addChild(this.Equip02);
        this.EquipTB01L.addChild(this.EquipTB02L);
        this.EquipBase.addChild(this.EquipT01R);
        this.EquipBase.addChild(this.EquipTB01R);
        this.EquipBase.addChild(this.EquipRC01);
        this.EquipT02R.addChild(this.EquipT03R);
        this.EquipBase.addChild(this.EquipTooth02);
        this.EquipTB01R.addChild(this.EquipTB02R);
        this.CloakNeck.addChild(this.Cloak01);
        this.BodyMain.addChild(this.CloakNeck);
        this.BodyMain.addChild(this.ArmRight01);
        this.ArmRight01.addChild(this.ArmRight02);
        this.Butt.addChild(this.LegRight01);
        this.LegRight01.addChild(this.LegRight02);
        this.EquipBase.addChild(this.EquipT01L);
        this.BodyMain.addChild(this.Neck);
        this.Neck.addChild(this.Neck02);
        this.EquipBase.addChild(this.Equip01);
        this.BodyMain.addChild(this.ArmLeft01);
        this.ArmLeft01.addChild(this.ArmLeft02);
        this.ArmRight02.addChild(this.Staff);
        this.Cloak01.addChild(this.Cloak02);
        this.EquipRC01.addChild(this.EquipRC03);
        this.EquipBase.addChild(this.EquipTooth01);
        this.BodyMain.addChild(this.BoobR);
        this.BodyMain.addChild(this.Butt);
        this.Cloak02.addChild(this.Cloak03);
        this.GlowBodyMain = new ModelRenderer(this, 0, 0);
        this.GlowBodyMain.setRotationPoint(0.0f, -11.0f, 0.0f);
        this.setRotateAngle(this.GlowBodyMain, -0.34906584f, 0.0f, 0.0f);
        this.GlowHead = new ModelRenderer(this, 0, 0);
        this.GlowHead.setRotationPoint(0.0f, -13.0f, -0.5f);
        this.GlowEquipBase = new ModelRenderer(this, 0, 0);
        this.GlowEquipBase.setRotationPoint(0.0f, -10.0f, -3.0f);
        this.setRotateAngle(this.GlowEquipBase, 0.08726646f, 0.0f, 0.0f);
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
        this.Mouth0 = new ModelRenderer(this, 69, 91);
        this.Mouth0.setRotationPoint(0.0f, -4.2f, -6.2f);
        this.Mouth0.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.Mouth1 = new ModelRenderer(this, 69, 96);
        this.Mouth1.setRotationPoint(0.0f, -4.2f, -6.2f);
        this.Mouth1.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.Mouth2 = new ModelRenderer(this, 83, 91);
        this.Mouth2.setRotationPoint(0.0f, -4.2f, -6.2f);
        this.Mouth2.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.Flush0 = new ModelRenderer(this, 83, 96);
        this.Flush0.setRotationPoint(-6.0f, -3.0f, -6.8f);
        this.Flush0.addBox(-1.0f, 0.0f, -0.5f, 2, 1, 0, 0.0f);
        this.Flush1 = new ModelRenderer(this, 83, 96);
        this.Flush1.setRotationPoint(6.0f, -3.0f, -6.8f);
        this.Flush1.addBox(-1.0f, 0.0f, -0.5f, 2, 1, 0, 0.0f);
        this.GlowBodyMain.addChild(this.GlowHead);
        this.GlowHead.addChild(this.GlowEquipBase);
        this.GlowEquipBase.addChild(this.EquipEye01);
        this.GlowEquipBase.addChild(this.EquipEye02);
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
        boolean flag;
        int state = ent.getStateEmotion(0);
        this.EquipBase.isHidden = flag = !EmotionHelper.checkModelState(0, state);
        this.GlowEquipBase.isHidden = flag;
        this.Staff.isHidden = !EmotionHelper.checkModelState(1, state);
        this.Neck.isHidden = !EmotionHelper.checkModelState(2, state);
        this.CloakNeck.isHidden = !EmotionHelper.checkModelState(3, state);
    }

    @Override
    public void syncRotationGlowPart() {
        this.GlowBodyMain.rotateAngleX = this.BodyMain.rotateAngleX;
        this.GlowBodyMain.rotateAngleY = this.BodyMain.rotateAngleY;
        this.GlowBodyMain.rotateAngleZ = this.BodyMain.rotateAngleZ;
        this.GlowEquipBase.rotateAngleX = this.EquipBase.rotateAngleX;
        this.GlowEquipBase.rotateAngleY = this.EquipBase.rotateAngleY;
        this.GlowEquipBase.rotateAngleZ = this.EquipBase.rotateAngleZ;
        this.GlowHead.rotateAngleX = this.Head.rotateAngleX;
        this.GlowHead.rotateAngleY = this.Head.rotateAngleY;
        this.GlowHead.rotateAngleZ = this.Head.rotateAngleZ;
    }

    @Override
    public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        GlStateManager.translate(0.0f, 0.41f, 0.0f);
        this.setFaceHungry(ent);
        this.Head.rotateAngleY = 0.0f;
        this.Head.rotateAngleX = 0.0f;
        this.BoobL.rotateAngleX = -0.63f;
        this.BoobR.rotateAngleX = -0.63f;
        this.Ahoke.rotateAngleY = 0.5236f;
        this.ArmRight02.rotateAngleY = 0.0f;
        this.Butt.offsetY = 0.0f;
        this.BodyMain.rotateAngleX = 0.2094f;
        this.BodyMain.rotateAngleY = 0.0f;
        this.BodyMain.rotateAngleZ = 0.0f;
        this.Butt.rotateAngleX = -0.4189f;
        this.Butt.offsetZ = -0.12f;
        this.ArmLeft01.rotateAngleX = -1.0472f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = 0.4189f;
        this.ArmLeft02.rotateAngleX = -0.1396f;
        this.ArmLeft02.rotateAngleY = 0.0f;
        this.ArmLeft02.rotateAngleZ = 1.2915f;
        this.ArmRight01.rotateAngleX = -0.8727f;
        this.ArmRight01.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleZ = -0.0873f;
        this.ArmRight02.rotateAngleZ = -1.1345f;
        this.LegLeft01.rotateAngleX = -2.2689f;
        this.LegLeft01.rotateAngleY = -0.2094f;
        this.LegLeft01.rotateAngleZ = -0.2094f;
        this.LegLeft02.rotateAngleX = 1.7454f;
        this.LegLeft02.offsetZ = 0.3f;
        this.LegRight01.rotateAngleX = -2.2689f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleZ = 0.0873f;
        this.LegRight02.rotateAngleX = 1.5708f;
        this.LegRight02.offsetZ = 0.3f;
        this.Cloak01.rotateAngleX = 0.2618f;
        this.Cloak02.rotateAngleX = -1.3963f;
        this.Cloak03.rotateAngleX = -0.9425f;
        this.Staff.rotateAngleX = 1.309f;
        this.Staff.rotateAngleY = -0.5934f;
        this.Staff.rotateAngleZ = -0.2094f;
        this.Staff.offsetX = -0.3f;
        this.Staff.offsetY = -1.5f;
        this.Staff.offsetZ = -1.7f;
        if (EmotionHelper.checkModelState(0, ent.getStateEmotion(0))) {
            this.EquipLC01.rotateAngleX = this.Head.rotateAngleX;
            this.EquipRC01.rotateAngleX = this.Head.rotateAngleX;
            this.EquipT01L.rotateAngleX = -0.2618f;
            this.EquipT01L.rotateAngleZ = -0.2618f;
            this.EquipT02L.rotateAngleX = -0.3491f;
            this.EquipT02L.rotateAngleZ = 0.2618f;
            this.EquipT03L.rotateAngleX = 1.0472f;
            this.EquipT03L.rotateAngleZ = 1.0472f;
            this.EquipT01R.rotateAngleX = -0.2618f;
            this.EquipT01R.rotateAngleZ = 0.2618f;
            this.EquipT02R.rotateAngleX = -0.3491f;
            this.EquipT02R.rotateAngleZ = -0.2618f;
            this.EquipT03R.rotateAngleX = 1.0472f;
            this.EquipT03R.rotateAngleZ = -1.0472f;
            this.EquipTB01L.rotateAngleX = 0.1745f;
            this.EquipTB01L.rotateAngleZ = -0.3491f;
            this.EquipTB02L.rotateAngleX = -0.6981f;
            this.EquipTB02L.rotateAngleZ = 0.3491f;
            this.EquipTB03L.rotateAngleX = 0.1745f;
            this.EquipTB03L.rotateAngleZ = 0.2618f;
            this.EquipTB01R.rotateAngleX = 0.1745f;
            this.EquipTB01R.rotateAngleZ = 0.3491f;
            this.EquipTB02R.rotateAngleX = -0.6981f;
            this.EquipTB02R.rotateAngleZ = -0.3491f;
            this.EquipTB03R.rotateAngleX = 0.1745f;
            this.EquipTB03R.rotateAngleZ = -0.2618f;
        }
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
        addk1 = MathHelper.cos(f * 0.4f) * 0.5f * f1;
        addk2 = MathHelper.cos(f * 0.4f + (float)Math.PI) * 0.5f * f1;
        this.Head.rotateAngleX = f4 * 0.012f;
        this.Head.rotateAngleY = f3 * 0.01f;
        this.BoobL.rotateAngleX = -angleZ * 0.06f - 0.63f;
        this.BoobR.rotateAngleX = -angleZ * 0.06f - 0.63f;
        this.Ahoke.rotateAngleY = angleZ * 0.25f + 0.5236f;
        this.ArmLeft01.rotateAngleX = -0.3f;
        this.ArmRight01.rotateAngleX = -0.3f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = 0.24f;
        this.ArmRight01.rotateAngleZ = -0.24f;
        this.ArmLeft02.rotateAngleX = 0.0f;
        this.ArmLeft02.rotateAngleY = 0.0f;
        this.ArmLeft02.rotateAngleZ = 0.0f;
        this.ArmRight02.rotateAngleY = 0.0f;
        this.ArmLeft02.rotateAngleZ = 0.0f;
        this.ArmRight02.rotateAngleZ = 0.0f;
        this.BodyMain.rotateAngleX = -0.1745f;
        this.BodyMain.rotateAngleY = 0.0f;
        this.BodyMain.rotateAngleZ = 0.0f;
        this.Butt.rotateAngleX = 0.5236f;
        this.Butt.offsetY = 0.0f;
        this.Butt.offsetZ = 0.0f;
        this.HairL01.rotateAngleX = -0.3f;
        this.HairL02.rotateAngleX = 0.35f;
        this.HairR01.rotateAngleX = -0.3f;
        this.HairR02.rotateAngleX = 0.35f;
        this.HairL01.rotateAngleZ = -0.314f;
        this.HairL02.rotateAngleZ = 0.2618f;
        this.HairR01.rotateAngleZ = 0.314f;
        this.HairR02.rotateAngleZ = -0.2618f;
        addk1 += -0.349f;
        addk2 += -0.349f;
        this.LegLeft01.rotateAngleY = 0.0f;
        this.LegLeft01.rotateAngleZ = 0.052f;
        this.LegLeft02.rotateAngleX = 0.0f;
        this.LegLeft02.offsetZ = 0.0f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleZ = -0.052f;
        this.LegRight02.rotateAngleX = 0.0f;
        this.LegRight02.offsetZ = 0.0f;
        this.Cloak01.rotateAngleX = angleZ * 0.05f + 0.2618f;
        this.Cloak02.rotateAngleX = angleZ * 0.1f + 0.1745f;
        this.Cloak03.rotateAngleX = angleZ * 0.15f + 0.2618f;
        this.Staff.rotateAngleX = 0.0f;
        this.Staff.rotateAngleY = 0.0f;
        this.Staff.rotateAngleZ = 1.8326f;
        this.Staff.offsetX = -0.7f;
        this.Staff.offsetY = -1.7f;
        this.Staff.offsetZ = -1.4f;
        boolean fhead = EmotionHelper.checkModelState(0, ent.getStateEmotion(0));
        if (fhead) {
            this.EquipLC01.rotateAngleX = this.Head.rotateAngleX;
            this.EquipRC01.rotateAngleX = this.Head.rotateAngleX;
            this.EquipT01L.rotateAngleX = angleZ * 0.05f + -0.2618f;
            this.EquipT01L.rotateAngleZ = angleZ * 0.05f + -0.2618f;
            this.EquipT02L.rotateAngleX = angleZ * 0.1f;
            this.EquipT02L.rotateAngleZ = angleZ * 0.1f;
            this.EquipT03L.rotateAngleX = angleZ * 0.25f;
            this.EquipT03L.rotateAngleZ = angleZ * 0.25f;
            this.EquipT01R.rotateAngleX = angleZ * 0.05f + -0.2618f;
            this.EquipT01R.rotateAngleZ = -angleZ * 0.05f + 0.2618f;
            this.EquipT02R.rotateAngleX = angleZ * 0.1f;
            this.EquipT02R.rotateAngleZ = -angleZ * 0.1f;
            this.EquipT03R.rotateAngleX = angleZ * 0.25f;
            this.EquipT03R.rotateAngleZ = -angleZ * 0.25f;
            this.EquipTB01L.rotateAngleX = -angleZ * 0.05f + 0.2618f;
            this.EquipTB01L.rotateAngleZ = angleZ * 0.05f + -0.2618f;
            this.EquipTB02L.rotateAngleX = -angleZ * 0.1f;
            this.EquipTB02L.rotateAngleZ = angleZ * 0.1f;
            this.EquipTB03L.rotateAngleX = -angleZ * 0.25f;
            this.EquipTB03L.rotateAngleZ = angleZ * 0.25f;
            this.EquipTB01R.rotateAngleX = -angleZ * 0.05f + 0.2618f;
            this.EquipTB01R.rotateAngleZ = -angleZ * 0.05f + 0.2618f;
            this.EquipTB02R.rotateAngleX = -angleZ * 0.1f;
            this.EquipTB02R.rotateAngleZ = -angleZ * 0.1f;
            this.EquipTB03R.rotateAngleX = -angleZ * 0.25f;
            this.EquipTB03R.rotateAngleZ = -angleZ * 0.25f;
        }
        if (ent.getIsSprinting() || f1 > 0.9f) {
            float angleZFast = MathHelper.cos(f2 * 0.3f);
            this.ArmLeft01.rotateAngleX = -0.6981f;
            this.ArmRight01.rotateAngleX = -0.6981f;
            this.ArmLeft01.rotateAngleY = 0.4f;
            this.ArmRight01.rotateAngleY = -0.4f;
            this.ArmLeft01.rotateAngleZ = 0.0f;
            this.ArmRight01.rotateAngleZ = 0.0f;
            this.BodyMain.rotateAngleX = -0.349f;
            addk1 = 0.0f;
            addk2 = 0.0f;
            this.LegLeft01.rotateAngleY = 0.0f;
            this.LegRight01.rotateAngleY = 0.0f;
            this.LegLeft01.rotateAngleZ = 0.05236f;
            this.LegRight01.rotateAngleZ = -0.05236f;
            this.Cloak01.rotateAngleX = angleZFast * 0.1f + 1.2f;
            this.Cloak02.rotateAngleX = angleZFast * 0.25f;
            this.Cloak03.rotateAngleX = angleZFast * 0.15f;
            this.Staff.rotateAngleX = 1.3f;
            this.Staff.rotateAngleY = -0.182f;
            this.Staff.rotateAngleZ = -1.2292f;
            this.Staff.offsetX = 0.2f;
            this.Staff.offsetY = -1.0f;
            this.Staff.offsetZ = -0.1f;
            if (fhead) {
                this.EquipT01L.rotateAngleX = angleZFast * 0.05f + 0.2618f;
                this.EquipT01L.rotateAngleZ = -0.2618f;
                this.EquipT02L.rotateAngleX = angleZFast * 0.15f + 0.2618f;
                this.EquipT02L.rotateAngleZ = -0.2618f;
                this.EquipT03L.rotateAngleX = angleZFast * 0.45f + 0.5236f;
                this.EquipT03L.rotateAngleZ = -0.2618f;
                this.EquipT01R.rotateAngleX = angleZFast * 0.05f + 0.2618f;
                this.EquipT01R.rotateAngleZ = 0.2618f;
                this.EquipT02R.rotateAngleX = angleZFast * 0.15f + 0.2618f;
                this.EquipT02R.rotateAngleZ = 0.2618f;
                this.EquipT03R.rotateAngleX = angleZFast * 0.45f + 0.5236f;
                this.EquipT03R.rotateAngleZ = 0.2618f;
                this.EquipTB01L.rotateAngleX = angleZFast * 0.05f + 0.349f;
                this.EquipTB01L.rotateAngleZ = -0.349f;
                this.EquipTB02L.rotateAngleX = angleZFast * 0.15f + 0.5236f;
                this.EquipTB02L.rotateAngleZ = 0.1745f;
                this.EquipTB03L.rotateAngleX = angleZFast * 0.45f + 0.5236f;
                this.EquipTB03L.rotateAngleZ = 0.1745f;
                this.EquipTB01R.rotateAngleX = angleZFast * 0.05f + 0.349f;
                this.EquipTB01R.rotateAngleZ = 0.349f;
                this.EquipTB02R.rotateAngleX = angleZFast * 0.15f + 0.5236f;
                this.EquipTB02R.rotateAngleZ = -0.1745f;
                this.EquipTB03R.rotateAngleX = angleZFast * 0.45f + 0.5236f;
                this.EquipTB03R.rotateAngleZ = -0.1745f;
            }
        }
        this.Head.rotateAngleZ = EmotionHelper.getHeadTiltAngle(ent, f2);
        if (ent.getIsSneaking()) {
            GlStateManager.translate(0.0f, 0.05f, 0.0f);
            this.ArmLeft01.rotateAngleX = 0.7f;
            this.ArmRight01.rotateAngleX = 0.7f;
            this.BodyMain.rotateAngleX = 0.5f;
            this.Head.rotateAngleX -= 0.5f;
            this.Cloak01.rotateAngleX = angleZ * 0.02f + 0.34f;
            addk1 -= 0.66f;
            addk2 -= 0.66f;
        } else {
            this.Head.rotateAngleX += 0.2f;
        }
        if (ent.getIsSitting() || ent.getIsRiding()) {
            if (ent.getStateEmotion(1) == 4) {
                GlStateManager.translate(0.0f, 0.41f, 0.0f);
                this.BodyMain.rotateAngleX = 0.2094f;
                this.BodyMain.rotateAngleY = 0.0f;
                this.BodyMain.rotateAngleZ = 0.0f;
                this.Butt.rotateAngleX = -0.4189f;
                this.Butt.offsetZ = -0.12f;
                this.Head.rotateAngleY *= 0.5f;
                this.ArmLeft01.rotateAngleX = -1.0472f;
                this.ArmLeft01.rotateAngleY = 0.0f;
                this.ArmLeft01.rotateAngleZ = 0.4189f;
                this.ArmLeft02.rotateAngleX = -0.1396f;
                this.ArmLeft02.rotateAngleY = 0.0f;
                this.ArmLeft02.rotateAngleZ = 1.2915f;
                this.ArmRight01.rotateAngleX = -0.8727f;
                this.ArmRight01.rotateAngleY = 0.0f;
                this.ArmRight01.rotateAngleZ = -0.0873f;
                this.ArmRight02.rotateAngleZ = -1.1345f;
                addk1 = -2.2689f;
                addk2 = -2.2689f;
                this.LegLeft01.rotateAngleY = -0.2094f;
                this.LegLeft01.rotateAngleZ = -0.2094f;
                this.LegLeft02.rotateAngleX = 1.7454f;
                this.LegLeft02.offsetZ = 0.3f;
                this.LegRight01.rotateAngleY = 0.0f;
                this.LegRight01.rotateAngleZ = 0.0873f;
                this.LegRight02.rotateAngleX = 1.5708f;
                this.LegRight02.offsetZ = 0.3f;
                this.Cloak01.rotateAngleX = 0.2618f;
                this.Cloak02.rotateAngleX = -1.3963f;
                this.Cloak03.rotateAngleX = -0.9425f;
                this.Staff.rotateAngleX = 1.309f;
                this.Staff.rotateAngleY = -0.5934f;
                this.Staff.rotateAngleZ = -0.2094f;
                this.Staff.offsetX = -0.3f;
                this.Staff.offsetY = -1.5f;
                this.Staff.offsetZ = -1.7f;
                if (fhead) {
                    this.EquipT01L.rotateAngleX = angleZ * 0.01f - 0.2618f;
                    this.EquipT01L.rotateAngleZ = -0.2618f;
                    this.EquipT02L.rotateAngleX = angleZ * 0.03f - 0.3491f;
                    this.EquipT02L.rotateAngleZ = 0.2618f;
                    this.EquipT03L.rotateAngleX = -angleZ * 0.1f + 1.0472f;
                    this.EquipT03L.rotateAngleZ = 1.0472f;
                    this.EquipT01R.rotateAngleX = -angleZ * 0.01f - 0.2618f;
                    this.EquipT01R.rotateAngleZ = 0.2618f;
                    this.EquipT02R.rotateAngleX = -angleZ * 0.03f - 0.3491f;
                    this.EquipT02R.rotateAngleZ = -0.2618f;
                    this.EquipT03R.rotateAngleX = angleZ * 0.1f + 1.0472f;
                    this.EquipT03R.rotateAngleZ = -1.0472f;
                    this.EquipTB01L.rotateAngleX = angleZ * 0.01f + 0.1745f;
                    this.EquipTB01L.rotateAngleZ = -0.3491f;
                    this.EquipTB02L.rotateAngleX = angleZ * 0.03f - 0.6981f;
                    this.EquipTB02L.rotateAngleZ = 0.3491f;
                    this.EquipTB03L.rotateAngleX = angleZ * 0.05f + 0.1745f;
                    this.EquipTB03L.rotateAngleZ = 0.2618f;
                    this.EquipTB01R.rotateAngleX = -angleZ * 0.01f + 0.1745f;
                    this.EquipTB01R.rotateAngleZ = 0.3491f;
                    this.EquipTB02R.rotateAngleX = -angleZ * 0.03f - 0.6981f;
                    this.EquipTB02R.rotateAngleZ = -0.3491f;
                    this.EquipTB03R.rotateAngleX = -angleZ * 0.05f + 0.1745f;
                    this.EquipTB03R.rotateAngleZ = -0.2618f;
                }
            } else {
                this.ArmLeft01.rotateAngleX = 0.4f;
                this.ArmLeft01.rotateAngleY = 0.0f;
                this.ArmLeft01.rotateAngleZ = -0.32f;
                this.ArmRight01.rotateAngleX = 0.34f;
                this.ArmRight01.rotateAngleY = 0.0f;
                this.ArmRight01.rotateAngleZ = 0.5236f;
                this.BodyMain.rotateAngleX = -0.349f;
                this.BodyMain.rotateAngleY = -1.57f;
                this.BodyMain.rotateAngleZ = -0.0873f;
                this.Head.rotateAngleX += -0.25f;
                this.Head.rotateAngleY += 0.4f;
                this.Head.rotateAngleZ += 0.0f;
                addk1 = angleZ * 0.3f + -1.0472f;
                addk2 = -angleZ * 0.3f + -1.0472f;
                this.LegLeft01.rotateAngleY = 0.0f;
                this.LegRight01.rotateAngleY = 0.0f;
                this.LegLeft01.rotateAngleZ = 0.05236f;
                this.LegRight01.rotateAngleZ = -0.05236f;
                this.Cloak01.rotateAngleX = angleZ * 0.1f + 0.4f;
                this.Cloak02.rotateAngleX = angleZ * 0.15f;
                this.Cloak03.rotateAngleX = angleZ * 0.15f;
                this.Staff.rotateAngleX = 0.2f;
                this.Staff.rotateAngleY = 0.0f;
                this.Staff.rotateAngleZ = -2.0f;
                this.Staff.offsetX = 1.1f;
                this.Staff.offsetY = -1.95f;
                this.Staff.offsetZ = -1.4f;
                if (fhead) {
                    this.EquipT01L.rotateAngleX = -angleZ * 0.05f + 0.2618f;
                    this.EquipT01L.rotateAngleZ = -0.2618f;
                    this.EquipT02L.rotateAngleX = -angleZ * 0.15f + 0.2618f;
                    this.EquipT02L.rotateAngleZ = -0.1618f;
                    this.EquipT03L.rotateAngleX = -angleZ * 0.45f + 0.0f;
                    this.EquipT03L.rotateAngleZ = -0.2618f;
                    this.EquipT01R.rotateAngleX = angleZ * 0.05f + 0.2618f;
                    this.EquipT01R.rotateAngleZ = 0.2618f;
                    this.EquipT02R.rotateAngleX = angleZ * 0.15f + 0.2618f;
                    this.EquipT02R.rotateAngleZ = 0.1618f;
                    this.EquipT03R.rotateAngleX = angleZ * 0.45f + 0.0f;
                    this.EquipT03R.rotateAngleZ = 0.2618f;
                    this.EquipTB01L.rotateAngleX = angleZ * 0.05f + 0.349f;
                    this.EquipTB01L.rotateAngleZ = -0.349f;
                    this.EquipTB02L.rotateAngleX = angleZ * 0.15f + 0.2236f;
                    this.EquipTB02L.rotateAngleZ = 0.1745f;
                    this.EquipTB03L.rotateAngleX = angleZ * 0.45f + 0.1236f;
                    this.EquipTB03L.rotateAngleZ = 0.1745f;
                    this.EquipTB01R.rotateAngleX = -angleZ * 0.05f + 0.349f;
                    this.EquipTB01R.rotateAngleZ = 0.349f;
                    this.EquipTB02R.rotateAngleX = -angleZ * 0.15f + 0.2236f;
                    this.EquipTB02R.rotateAngleZ = -0.1745f;
                    this.EquipTB03R.rotateAngleX = -angleZ * 0.45f + 0.1236f;
                    this.EquipTB03R.rotateAngleZ = -0.1745f;
                }
            }
        }
        float headX = this.Head.rotateAngleX * -0.5f;
        float headZ = this.Head.rotateAngleZ * -0.5f;
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
        if (ent.getAttackTick() > 0) {
            this.ArmLeft01.rotateAngleX = f4 / 57.29578f - 1.5f;
            this.ArmRight01.rotateAngleZ = 0.7f;
            this.ArmRight01.rotateAngleX = 0.4f;
            this.Staff.rotateAngleX = 1.5f;
            this.Staff.rotateAngleY = 0.0f;
            this.Staff.rotateAngleZ = -1.2f;
            this.Staff.offsetX = -0.2f;
            this.Staff.offsetY = -1.2f;
            this.Staff.offsetZ = -1.0f;
        }
        if ((f6 = ent.getSwingTime(f2 - (int)f2)) != 0.0f) {
            float f7 = MathHelper.sin(f6 * f6 * (float)Math.PI);
            float f8 = MathHelper.sin(MathHelper.sqrt(f6) * (float)Math.PI);
            this.ArmRight01.rotateAngleX = -0.2f;
            this.ArmRight01.rotateAngleY = 0.0f;
            this.ArmRight01.rotateAngleZ = -0.1f;
            this.ArmRight01.rotateAngleX += -f8 * 80.0f * ((float)Math.PI / 180);
            this.ArmRight01.rotateAngleY += -f7 * 20.0f * ((float)Math.PI / 180) + 0.2f;
            this.ArmRight01.rotateAngleZ += -f8 * 20.0f * ((float)Math.PI / 180);
            this.ArmRight02.rotateAngleX = 0.0f;
            this.ArmRight02.rotateAngleY = 0.0f;
            this.ArmRight02.rotateAngleZ = 0.0f;
        }
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
