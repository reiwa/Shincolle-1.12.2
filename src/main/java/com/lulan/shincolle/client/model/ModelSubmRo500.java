package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.entity.IShipFloating;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelSubmRo500
extends ShipModelBaseAdv {
    private final ModelRenderer BodyMain;
    private final ModelRenderer Neck;
    private final ModelRenderer ArmLeft01;
    private final ModelRenderer ArmRight01;
    private final ModelRenderer Butt;
    private final ModelRenderer Cloth01;
    private final ModelRenderer EquipBase1;
    private final ModelRenderer EquipBase2;
    private final ModelRenderer Head;
    private final ModelRenderer Hair;
    private final ModelRenderer HairMain;
    private final ModelRenderer FlowerBase;
    private final ModelRenderer Ahoke;
    private final ModelRenderer HairL01;
    private final ModelRenderer HairR01;
    private final ModelRenderer HairL02;
    private final ModelRenderer HairR02;
    private final ModelRenderer Hair01;
    private final ModelRenderer Flower1;
    private final ModelRenderer Flower2;
    private final ModelRenderer Flower3;
    private final ModelRenderer Flower4;
    private final ModelRenderer ArmLeft02;
    private final ModelRenderer ArmRight02;
    private final ModelRenderer LegRight01;
    private final ModelRenderer LegLeft01;
    private final ModelRenderer LegRight02;
    private final ModelRenderer LegLeft02;
    private final ModelRenderer Equip101;
    private final ModelRenderer Equip102;
    private final ModelRenderer Equip103;
    private final ModelRenderer Equip104;
    private final ModelRenderer Equip201;
    private final ModelRenderer Equip202;
    private final ModelRenderer Equip203;
    private final ModelRenderer Equip204;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowNeck;
    private final ModelRenderer GlowHead;
    protected float[] offsetItem2 = new float[]{-0.03f, 0.93f, 0.1f};

    public ModelSubmRo500() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.offsetItem = new float[]{-0.01f, 1.1f, -0.05f};
        this.offsetBlock = new float[]{-0.01f, 1.1f, -0.05f};
        this.setDefaultFaceModel();
        this.ArmRight02 = new ModelRenderer(this, 24, 86);
        this.ArmRight02.setRotationPoint(-2.0f, 10.5f, 2.5f);
        this.ArmRight02.addBox(-2.5f, 0.0f, -5.0f, 5, 11, 5, 0.0f);
        this.LegLeft02 = new ModelRenderer(this, 0, 65);
        this.LegLeft02.mirror = true;
        this.LegLeft02.setRotationPoint(0.0f, 13.0f, -3.0f);
        this.LegLeft02.addBox(-3.0f, 0.0f, 0.0f, 6, 14, 6, 0.0f);
        this.Hair = new ModelRenderer(this, 50, 75);
        this.Hair.setRotationPoint(0.0f, -7.5f, -0.5f);
        this.Hair.addBox(-8.0f, -8.0f, -6.8f, 16, 17, 8, 0.0f);
        this.EquipBase1 = new ModelRenderer(this, 0, 0);
        this.EquipBase1.setRotationPoint(0.0f, 7.0f, 18.0f);
        this.EquipBase1.addBox(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.Butt = new ModelRenderer(this, 82, 18);
        this.Butt.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Butt.addBox(-7.5f, 4.8f, -5.6f, 15, 7, 8, 0.0f);
        this.setRotateAngle(this.Butt, 0.2617994f, 0.0f, 0.0f);
        this.LegLeft01 = new ModelRenderer(this, 0, 85);
        this.LegLeft01.setRotationPoint(4.2f, 11.0f, -2.2f);
        this.LegLeft01.addBox(-3.0f, 0.0f, -3.0f, 6, 13, 6, 0.0f);
        this.setRotateAngle(this.LegLeft01, -0.12217305f, 0.0f, (float)(-Math.PI) / 90);
        this.Equip103 = new ModelRenderer(this, 24, 73);
        this.Equip103.setRotationPoint(-22.0f, 0.0f, 0.0f);
        this.Equip103.addBox(0.0f, -1.0f, -3.0f, 7, 2, 6, 0.0f);
        this.setRotateAngle(this.Equip103, 0.7853982f, 0.0f, 0.0f);
        this.Equip204 = new ModelRenderer(this, 0, 10);
        this.Equip204.setRotationPoint(-9.0f, 0.0f, -14.0f);
        this.Equip204.addBox(0.0f, 0.0f, 0.0f, 24, 6, 6, 0.0f);
        this.EquipBase2 = new ModelRenderer(this, 0, 0);
        this.EquipBase2.setRotationPoint(0.0f, 8.0f, -2.0f);
        this.EquipBase2.addBox(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.EquipBase2, 0.31415927f, 0.0f, 0.0f);
        this.Equip203 = new ModelRenderer(this, 46, 10);
        this.Equip203.setRotationPoint(9.0f, 6.0f, 16.0f);
        this.Equip203.addBox(0.0f, 0.0f, 0.0f, 6, 6, 24, 0.0f);
        this.setRotateAngle(this.Equip203, (float)(-Math.PI), 0.0f, 0.0f);
        this.LegRight02 = new ModelRenderer(this, 0, 65);
        this.LegRight02.setRotationPoint(0.0f, 13.0f, -3.0f);
        this.LegRight02.addBox(-3.0f, 0.0f, 0.0f, 6, 14, 6, 0.0f);
        this.Hair01 = new ModelRenderer(this, 49, 47);
        this.Hair01.setRotationPoint(0.0f, 9.0f, 1.1f);
        this.Hair01.addBox(-7.5f, 0.0f, 0.0f, 15, 18, 9, 0.0f);
        this.setRotateAngle(this.Hair01, 0.34906584f, 0.0f, 0.0f);
        this.BodyMain = new ModelRenderer(this, 0, 104);
        this.BodyMain.setRotationPoint(0.0f, -13.5f, 0.0f);
        this.BodyMain.addBox(-6.5f, -11.0f, -4.0f, 13, 17, 7, 0.0f);
        this.setRotateAngle(this.BodyMain, -0.10471976f, 0.0f, 0.0f);
        this.Equip202 = new ModelRenderer(this, 0, 10);
        this.Equip202.mirror = true;
        this.Equip202.setRotationPoint(-15.0f, 0.0f, 10.0f);
        this.Equip202.addBox(0.0f, 0.0f, 0.0f, 24, 6, 6, 0.0f);
        this.Neck = new ModelRenderer(this, 0, 22);
        this.Neck.setRotationPoint(0.0f, -10.5f, 0.0f);
        this.Neck.addBox(-3.0f, -2.0f, -3.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.Neck, 0.05235988f, 0.0f, 0.0f);
        this.Equip101 = new ModelRenderer(this, 0, 0);
        this.Equip101.setRotationPoint(0.0f, -6.0f, -9.5f);
        this.Equip101.addBox(-15.0f, -2.5f, -2.5f, 36, 5, 5, 0.0f);
        this.setRotateAngle(this.Equip101, 0.5235988f, 0.05235988f, 0.13962634f);
        this.Equip104 = new ModelRenderer(this, 54, 10);
        this.Equip104.setRotationPoint(21.0f, 0.0f, 0.0f);
        this.Equip104.addBox(0.0f, -1.5f, -1.5f, 2, 3, 3, 0.0f);
        this.Head = new ModelRenderer(this, 44, 101);
        this.Head.setRotationPoint(0.0f, -1.5f, 0.0f);
        this.Head.addBox(-7.0f, -14.5f, -6.5f, 14, 14, 13, 0.0f);
        this.HairR01 = new ModelRenderer(this, 88, 100);
        this.HairR01.setRotationPoint(-6.5f, 0.0f, -4.0f);
        this.HairR01.addBox(-1.0f, 0.0f, 0.0f, 2, 8, 3, 0.0f);
        this.setRotateAngle(this.HairR01, -0.17453292f, 0.17453292f, 0.13962634f);
        this.ArmRight01 = new ModelRenderer(this, 24, 81);
        this.ArmRight01.setRotationPoint(-6.0f, -9.0f, -0.5f);
        this.ArmRight01.addBox(-4.5f, -0.5f, -2.5f, 5, 11, 5, 0.0f);
        this.setRotateAngle(this.ArmRight01, 0.15707964f, 0.0f, 0.38397244f);
        this.HairL01 = new ModelRenderer(this, 88, 100);
        this.HairL01.mirror = true;
        this.HairL01.setRotationPoint(6.5f, 0.0f, -4.0f);
        this.HairL01.addBox(-1.0f, 0.0f, 0.0f, 2, 8, 3, 0.0f);
        this.setRotateAngle(this.HairL01, -0.17453292f, -0.17453292f, -0.13962634f);
        this.Flower1 = new ModelRenderer(this, 0, 7);
        this.Flower1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Flower1.addBox(0.0f, 0.0f, -1.5f, 0, 4, 3, 0.0f);
        this.setRotateAngle(this.Flower1, 1.3089969f, -0.08726646f, 0.0f);
        this.ArmLeft02 = new ModelRenderer(this, 24, 56);
        this.ArmLeft02.mirror = true;
        this.ArmLeft02.setRotationPoint(2.0f, 10.5f, 2.5f);
        this.ArmLeft02.addBox(-2.5f, 0.0f, -5.0f, 5, 11, 5, 0.0f);
        this.HairMain = new ModelRenderer(this, 48, 47);
        this.HairMain.setRotationPoint(0.0f, -15.0f, -3.0f);
        this.HairMain.addBox(-7.5f, 0.0f, 0.0f, 15, 9, 10, 0.0f);
        this.Flower2 = new ModelRenderer(this, 0, 7);
        this.Flower2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Flower2.addBox(0.0f, 0.0f, -1.5f, 0, 4, 3, 0.0f);
        this.setRotateAngle(this.Flower2, 2.5307274f, 0.0f, -0.08726646f);
        this.Flower3 = new ModelRenderer(this, 0, 7);
        this.Flower3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Flower3.addBox(0.0f, 0.0f, -1.5f, 0, 4, 3, 0.0f);
        this.setRotateAngle(this.Flower3, -2.6179938f, 0.0f, -0.08726646f);
        this.Cloth01 = new ModelRenderer(this, 84, 0);
        this.Cloth01.setRotationPoint(0.0f, -11.3f, 0.0f);
        this.Cloth01.addBox(-7.0f, 0.0f, -4.5f, 14, 10, 8, 0.0f);
        this.LegRight01 = new ModelRenderer(this, 0, 85);
        this.LegRight01.setRotationPoint(-4.2f, 11.0f, -2.2f);
        this.LegRight01.addBox(-3.0f, 0.0f, -3.0f, 6, 13, 6, 0.0f);
        this.setRotateAngle(this.LegRight01, -0.12217305f, 0.0f, (float)Math.PI / 90);
        this.Equip201 = new ModelRenderer(this, 46, 10);
        this.Equip201.setRotationPoint(-15.0f, 0.0f, -14.0f);
        this.Equip201.addBox(0.0f, 0.0f, 0.0f, 6, 6, 24, 0.0f);
        this.FlowerBase = new ModelRenderer(this, 0, 7);
        this.FlowerBase.setRotationPoint(8.8f, -12.0f, -4.0f);
        this.FlowerBase.addBox(0.0f, 0.0f, -1.5f, 0, 4, 3, 0.0f);
        this.setRotateAngle(this.FlowerBase, -0.6981317f, 0.08726646f, -0.08726646f);
        this.HairL02 = new ModelRenderer(this, 88, 100);
        this.HairL02.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.HairL02.addBox(-1.0f, 0.0f, 0.0f, 2, 8, 3, 0.0f);
        this.setRotateAngle(this.HairL02, -0.17453292f, 0.0f, 0.08726646f);
        this.ArmLeft01 = new ModelRenderer(this, 24, 81);
        this.ArmLeft01.mirror = true;
        this.ArmLeft01.setRotationPoint(6.0f, -9.0f, -0.5f);
        this.ArmLeft01.addBox(-0.5f, -0.5f, -2.5f, 5, 11, 5, 0.0f);
        this.setRotateAngle(this.ArmLeft01, 0.15707964f, 0.0f, -0.38397244f);
        this.Ahoke = new ModelRenderer(this, 104, 29);
        this.Ahoke.setRotationPoint(0.0f, -8.5f, -5.0f);
        this.Ahoke.addBox(0.0f, -5.0f, -12.0f, 0, 12, 12, 0.0f);
        this.setRotateAngle(this.Ahoke, 0.0f, 0.5235988f, 0.0f);
        this.HairR02 = new ModelRenderer(this, 88, 100);
        this.HairR02.mirror = true;
        this.HairR02.setRotationPoint(0.2f, 6.0f, 0.0f);
        this.HairR02.addBox(-1.0f, 0.0f, 0.0f, 2, 8, 3, 0.0f);
        this.setRotateAngle(this.HairR02, -0.17453292f, 0.0f, -0.05235988f);
        this.Flower4 = new ModelRenderer(this, 0, 7);
        this.Flower4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Flower4.addBox(0.0f, 0.0f, -1.5f, 0, 4, 3, 0.0f);
        this.setRotateAngle(this.Flower4, -1.2217305f, 0.0f, 0.0f);
        this.Equip102 = new ModelRenderer(this, 28, 73);
        this.Equip102.setRotationPoint(-22.0f, 0.0f, 0.0f);
        this.Equip102.addBox(0.0f, -3.0f, -1.0f, 7, 6, 2, 0.0f);
        this.setRotateAngle(this.Equip102, 0.7853982f, 0.0f, 0.0f);
        this.ArmRight01.addChild(this.ArmRight02);
        this.LegLeft01.addChild(this.LegLeft02);
        this.Head.addChild(this.Hair);
        this.BodyMain.addChild(this.EquipBase1);
        this.BodyMain.addChild(this.Butt);
        this.Butt.addChild(this.LegLeft01);
        this.Equip101.addChild(this.Equip103);
        this.EquipBase2.addChild(this.Equip204);
        this.BodyMain.addChild(this.EquipBase2);
        this.EquipBase2.addChild(this.Equip203);
        this.LegRight01.addChild(this.LegRight02);
        this.HairMain.addChild(this.Hair01);
        this.EquipBase2.addChild(this.Equip202);
        this.BodyMain.addChild(this.Neck);
        this.EquipBase1.addChild(this.Equip101);
        this.Equip101.addChild(this.Equip104);
        this.Neck.addChild(this.Head);
        this.Hair.addChild(this.HairR01);
        this.BodyMain.addChild(this.ArmRight01);
        this.Hair.addChild(this.HairL01);
        this.ArmLeft01.addChild(this.ArmLeft02);
        this.Head.addChild(this.HairMain);
        this.BodyMain.addChild(this.Cloth01);
        this.Butt.addChild(this.LegRight01);
        this.EquipBase2.addChild(this.Equip201);
        this.HairL01.addChild(this.HairL02);
        this.BodyMain.addChild(this.ArmLeft01);
        this.Hair.addChild(this.Ahoke);
        this.HairR01.addChild(this.HairR02);
        this.Equip101.addChild(this.Equip102);
        this.GlowBodyMain = new ModelRenderer(this, 0, 0);
        this.GlowBodyMain.setRotationPoint(0.0f, -13.5f, 0.0f);
        this.setRotateAngle(this.GlowBodyMain, -0.10471976f, 0.0f, 0.0f);
        this.GlowNeck = new ModelRenderer(this, 0, 0);
        this.GlowNeck.setRotationPoint(0.0f, -10.5f, 0.0f);
        this.setRotateAngle(this.GlowNeck, 0.05235988f, 0.0f, 0.0f);
        this.GlowHead = new ModelRenderer(this, 0, 0);
        this.GlowHead.setRotationPoint(0.0f, -1.5f, 0.0f);
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
        this.GlowHead.addChild(this.FlowerBase);
        this.FlowerBase.addChild(this.Flower1);
        this.FlowerBase.addChild(this.Flower2);
        this.FlowerBase.addChild(this.Flower3);
        this.FlowerBase.addChild(this.Flower4);
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
                this.scale = 1.44f;
                this.offsetY = -0.45f;
                break;
            }
            case 2: {
                this.scale = 1.08f;
                this.offsetY = -0.06f;
                break;
            }
            case 1: {
                this.scale = 0.72f;
                this.offsetY = 0.66f;
                break;
            }
            default: {
                this.scale = 0.36f;
                this.offsetY = 2.86f;
            }
        }
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.scale(this.scale, this.scale * 0.95f, this.scale);
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
        this.EquipBase1.isHidden = !EmotionHelper.checkModelState(0, state);
        this.EquipBase2.isHidden = !EmotionHelper.checkModelState(1, state);
        this.FlowerBase.isHidden = !EmotionHelper.checkModelState(2, state);
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
        GlStateManager.translate(0.0f, 0.55f + 0.29f * ent.getScaleLevel(), 0.0f);
        this.setFaceHungry(ent);
        this.Head.rotateAngleX = -0.35f;
        this.Head.rotateAngleY = 0.0f;
        this.Ahoke.rotateAngleY = 0.5236f;
        this.BodyMain.rotateAngleX = -1.6f;
        this.Hair01.rotateAngleX = 0.3f;
        this.ArmLeft01.rotateAngleX = 3.1f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = 0.7f;
        this.ArmRight01.rotateAngleX = 3.1f;
        this.ArmRight01.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleZ = -0.7f;
        this.ArmLeft02.rotateAngleX = 0.0f;
        this.ArmRight02.rotateAngleX = 0.0f;
        this.LegLeft01.rotateAngleX = -0.2f;
        this.LegLeft01.rotateAngleY = 0.0f;
        this.LegLeft01.rotateAngleZ = -0.1f;
        this.LegRight01.rotateAngleX = -0.2f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleZ = 0.1f;
        this.LegLeft02.rotateAngleX = 0.0f;
        this.LegRight02.rotateAngleX = 0.0f;
        this.EquipBase1.offsetZ = 0.0f;
        this.EquipBase2.offsetY = 0.0f;
        this.EquipBase2.rotateAngleX = 0.3142f;
    }

    @Override
    public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent) {
        float f6;
        float angleX = MathHelper.cos(f2 * 0.08f);
        float angleX2 = MathHelper.cos(f2 * 0.25f);
        float angleAdd1 = MathHelper.cos(f * 0.7f) * f1;
        float angleAdd2 = MathHelper.cos(f * 0.7f + (float)Math.PI) * f1;
        float addk1;
        float addk2;
        if (ent.getShipDepth(0) > 0.0) {
            GlStateManager.translate(0.0f, angleX * 0.05f + 0.025f, 0.0f);
        }
        addk1 = angleAdd1 - 0.122f;
        addk2 = angleAdd2 - 0.122f;
        this.Head.rotateAngleX = f4 * 0.014f;
        this.Head.rotateAngleY = f3 * 0.01f;
        this.Ahoke.rotateAngleY = angleX * 0.25f + 0.5236f;
        this.BodyMain.rotateAngleX = -0.1f;
        this.Hair01.rotateAngleX = angleX * 0.06f + 0.3f;
        this.Hair01.rotateAngleZ = 0.0f;
        this.HairL01.rotateAngleX = -0.17f;
        this.HairL02.rotateAngleX = 0.17f;
        this.HairR01.rotateAngleX = -0.17f;
        this.HairR02.rotateAngleX = 0.17f;
        this.HairL01.rotateAngleZ = -0.14f;
        this.HairL02.rotateAngleZ = 0.08f;
        this.HairR01.rotateAngleZ = 0.14f;
        this.HairR02.rotateAngleZ = -0.05f;
        boolean flag = !EmotionHelper.checkModelState(1, ent.getStateEmotion(0));
        this.ArmLeft01.rotateAngleX = 0.157f;
        this.ArmLeft01.rotateAngleY = 0.0f;
        this.ArmLeft01.rotateAngleZ = -0.384f;
        if (flag) {
            this.ArmLeft01.rotateAngleZ += -angleX * 0.06f;
        }
        this.ArmRight01.rotateAngleX = 0.157f;
        this.ArmRight01.rotateAngleY = 0.0f;
        this.ArmRight01.rotateAngleZ = 0.384f;
        if (flag) {
            this.ArmRight01.rotateAngleZ += angleX * 0.06f;
        }
        this.ArmLeft02.rotateAngleX = 0.0f;
        this.ArmRight02.rotateAngleX = 0.0f;
        this.LegLeft01.rotateAngleY = 0.0f;
        this.LegLeft01.rotateAngleZ = -0.035f;
        this.LegRight01.rotateAngleY = 0.0f;
        this.LegRight01.rotateAngleZ = 0.035f;
        this.LegLeft02.rotateAngleX = 0.0f;
        this.LegRight02.rotateAngleX = 0.0f;
        this.EquipBase1.offsetZ = 0.0f;
        this.EquipBase2.offsetY = 0.0f;
        this.EquipBase2.rotateAngleX = 0.3142f;
        if (ent.getIsSprinting() || f1 > 0.9f) {
            this.setFace(3);
            this.BodyMain.rotateAngleX = 0.1745f;
            this.Head.rotateAngleX -= 0.35f;
            addk1 -= 0.25f;
            addk2 -= 0.25f;
            if (ent.getTickExisted() % 256 > 128) {
                this.ArmLeft01.rotateAngleX = 2.6f;
                this.ArmLeft01.rotateAngleZ = 0.7f;
                this.ArmRight01.rotateAngleX = 2.6f;
                this.ArmRight01.rotateAngleZ = -0.7f;
            } else {
                this.ArmRight01.rotateAngleX = -2.8f;
                this.ArmRight01.rotateAngleZ = -0.7f;
            }
        }
        this.Head.rotateAngleZ = EmotionHelper.getHeadTiltAngle(ent, f2);
        if (ent.getIsSneaking()) {
            GlStateManager.translate(0.0f, 0.1f, 0.0f);
            this.Head.rotateAngleX -= 0.8727f;
            this.BodyMain.rotateAngleX = 1.0472f;
            this.Hair01.rotateAngleX += 0.2236f;
            addk1 -= 1.2f;
            addk2 -= 1.2f;
        }
        if (ent.getIsSitting() || ent.getIsRiding()) {
            if (ent.getStateEmotion(1) == 4) {
                if (((IShipFloating) ent).getShipDepth() > 0.0) {
                    GlStateManager.translate(0.0f, -0.21f, 0.0f);
                } else {
                    GlStateManager.translate(0.0f, 0.43f, 0.0f);
                }
                this.Head.rotateAngleX += 0.35f;
                this.BodyMain.rotateAngleX = -0.7f;
                this.ArmLeft01.rotateAngleX = 0.5236f;
                this.ArmLeft01.rotateAngleZ = -0.5236f;
                this.ArmLeft02.rotateAngleX = -1.0472f;
                this.ArmRight01.rotateAngleX = 0.7f;
                this.ArmRight01.rotateAngleZ = 0.5236f;
                this.ArmRight02.rotateAngleX = -1.0472f;
                addk1 = -1.9f;
                addk2 = -1.9f;
                this.LegLeft02.rotateAngleX = angleX2 * 0.4f + 0.8f;
                this.LegRight02.rotateAngleX = -angleX2 * 0.4f + 0.8f;
                this.EquipBase1.offsetZ = -0.9f;
                this.EquipBase2.isHidden = false;
                this.EquipBase2.rotateAngleX = 0.7f;
            } else {
                if (((IShipFloating) ent).getShipDepth() > 0.0) {
                    GlStateManager.translate(0.0f, -0.22f, 0.0f);
                } else {
                    GlStateManager.translate(0.0f, 0.41f, 0.0f);
                }
                this.Head.rotateAngleX += 0.2f;
                this.BodyMain.rotateAngleX = -0.7f;
                this.ArmLeft01.rotateAngleX = 0.95f;
                this.ArmLeft01.rotateAngleZ = -0.3146f;
                this.ArmRight01.rotateAngleX = 0.95f;
                this.ArmRight01.rotateAngleZ = 0.3146f;
                addk1 = -1.1f;
                addk2 = -1.1f;
                this.LegLeft01.rotateAngleY = -0.3491f;
                this.LegRight01.rotateAngleY = 0.3491f;
                this.EquipBase1.offsetZ = -0.15f;
                this.EquipBase2.offsetY = -0.15f;
            }
        }
        if (ent.getAttackTick() > 41) {
            this.setFace(3);
            float ft = (50 - ent.getAttackTick()) + (f2 - (int)f2);
            float fa = MathHelper.sin((ft *= 0.125f) * ft * (float)Math.PI);
            float fb = MathHelper.sin(MathHelper.sqrt(ft) * (float)Math.PI);
            this.ArmLeft01.rotateAngleX += -fb * 180.0f * ((float)Math.PI / 180) + 0.1f;
            this.ArmLeft01.rotateAngleY += fa * 20.0f * ((float)Math.PI / 180) - 0.6f;
            this.ArmLeft01.rotateAngleZ += fb * 20.0f * ((float)Math.PI / 180);
            this.ArmRight01.rotateAngleX += -fb * 180.0f * ((float)Math.PI / 180) + 0.1f;
            this.ArmRight01.rotateAngleY += -fa * 20.0f * ((float)Math.PI / 180) + 0.6f;
            this.ArmRight01.rotateAngleZ += -fb * 20.0f * ((float)Math.PI / 180);
        }
        if ((f6 = ent.getSwingTime(f2 - (int)f2)) != 0.0f) {
            float f7 = MathHelper.sin(f6 * f6 * (float)Math.PI);
            float f8 = MathHelper.sin(MathHelper.sqrt(f6) * (float)Math.PI);
            this.ArmRight01.rotateAngleX = -0.4f;
            this.ArmRight01.rotateAngleY = 0.0f;
            this.ArmRight01.rotateAngleZ = -0.2f;
            this.ArmRight01.rotateAngleX += -f8 * 80.0f * ((float)Math.PI / 180);
            this.ArmRight01.rotateAngleY += -f7 * 20.0f * ((float)Math.PI / 180) + 0.2f;
            this.ArmRight01.rotateAngleZ += -f8 * 20.0f * ((float)Math.PI / 180);
        }
        this.LegLeft01.rotateAngleX = addk1;
        this.LegRight01.rotateAngleX = addk2;
    }

    @Override
    public float[] getHeldItemOffset(IShipEmotion ent, EnumHandSide side, int type) {
        if (ent.getIsSprinting()) {
            return this.offsetItem2;
        }
        return this.offsetItem;
    }
}
