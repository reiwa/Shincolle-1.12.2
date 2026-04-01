package com.lulan.shincolle.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

public class ModelLargeShipyard
extends ModelBase {
    private final ModelRenderer BodyMain;
    private final ModelRenderer Body01;
    private final ModelRenderer Body02;
    private final ModelRenderer Body03;
    private final ModelRenderer Body04;
    private final ModelRenderer Body05;
    private final ModelRenderer Body06;
    private final ModelRenderer Body07;
    private final ModelRenderer Body08;
    private final ModelRenderer Base00;
    private final ModelRenderer Base01;
    private final ModelRenderer Base02;
    private final ModelRenderer Base03;
    private final ModelRenderer Base04;
    private final ModelRenderer Base05;
    private final ModelRenderer Base06;
    private final ModelRenderer Base07;
    private final ModelRenderer Base08;
    private final ModelRenderer Pillar01a;
    private final ModelRenderer Pillar01b;
    private final ModelRenderer Pillar02a;
    private final ModelRenderer Pillar02b;
    private final ModelRenderer Pillar03a;
    private final ModelRenderer Pillar03b;
    private final ModelRenderer Pillar01a_1;
    private final ModelRenderer Pillar01b_1;

    public ModelLargeShipyard() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Body06 = new ModelRenderer(this, 0, 0);
        this.Body06.setRotationPoint(-10.0f, -6.0f, -23.0f);
        this.Body06.addBox(0.0f, 0.0f, 0.0f, 20, 6, 10, 0.0f);
        this.Body07 = new ModelRenderer(this, 0, 0);
        this.Body07.setRotationPoint(10.0f, -7.0f, -20.0f);
        this.Body07.addBox(0.0f, 0.0f, 0.0f, 12, 7, 14, 0.0f);
        this.Base06 = new ModelRenderer(this, 0, 0);
        this.Base06.setRotationPoint(-24.0f, -1.0f, 8.0f);
        this.Base06.addBox(0.0f, 0.0f, 0.0f, 16, 7, 16, 0.0f);
        this.Body03 = new ModelRenderer(this, 0, 0);
        this.Body03.setRotationPoint(-20.6f, -7.0f, 8.0f);
        this.Body03.addBox(0.0f, 0.0f, 0.0f, 15, 7, 13, 0.0f);
        this.Body08 = new ModelRenderer(this, 0, 0);
        this.Body08.setRotationPoint(15.0f, -5.0f, -10.0f);
        this.Body08.addBox(0.0f, 0.0f, 0.0f, 8, 5, 18, 0.0f);
        this.Pillar01b_1 = new ModelRenderer(this, 0, 0);
        this.Pillar01b_1.setRotationPoint(0.0f, -9.0f, 0.5f);
        this.Pillar01b_1.addBox(-3.0f, -8.0f, -3.0f, 6, 8, 6, 0.0f);
        this.setRotateAngle(this.Pillar01b_1, -0.17453292f, 0.0f, -0.17453292f);
        this.Pillar03b = new ModelRenderer(this, 0, 0);
        this.Pillar03b.setRotationPoint(0.0f, -8.5f, 0.0f);
        this.Pillar03b.addBox(-3.0f, -6.0f, -3.0f, 6, 8, 6, 0.0f);
        this.setRotateAngle(this.Pillar03b, -0.17453292f, 0.0f, 0.17453292f);
        this.Body02 = new ModelRenderer(this, 0, 0);
        this.Body02.setRotationPoint(-7.0f, -1.5f, 11.0f);
        this.Body02.addBox(0.0f, -3.4f, 0.0f, 18, 5, 11, 0.0f);
        this.Pillar02a = new ModelRenderer(this, 0, 0);
        this.Pillar02a.setRotationPoint(8.0f, 2.0f, 6.0f);
        this.Pillar02a.addBox(-5.5f, -10.0f, -4.5f, 11, 10, 9, 0.0f);
        this.setRotateAngle(this.Pillar02a, 0.17453292f, 0.0f, 0.17453292f);
        this.Base02 = new ModelRenderer(this, 0, 0);
        this.Base02.setRotationPoint(8.0f, -1.0f, -24.0f);
        this.Base02.addBox(0.0f, 0.0f, 0.0f, 16, 7, 16, 0.0f);
        this.Base01 = new ModelRenderer(this, 0, 0);
        this.Base01.setRotationPoint(-8.0f, -2.0f, -24.0f);
        this.Base01.addBox(0.0f, 0.0f, 0.0f, 16, 8, 16, 0.0f);
        this.Base05 = new ModelRenderer(this, 0, 0);
        this.Base05.setRotationPoint(-8.0f, -2.0f, 8.0f);
        this.Base05.addBox(0.0f, 0.0f, 0.0f, 16, 8, 16, 0.0f);
        this.Body05 = new ModelRenderer(this, 0, 0);
        this.Body05.setRotationPoint(-20.0f, -5.0f, -22.0f);
        this.Body05.addBox(0.0f, 0.0f, 0.0f, 12, 5, 15, 0.0f);
        this.Pillar01a_1 = new ModelRenderer(this, 0, 0);
        this.Pillar01a_1.setRotationPoint(5.0f, 2.0f, 6.0f);
        this.Pillar01a_1.addBox(-4.0f, -10.0f, -4.0f, 9, 10, 9, 0.0f);
        this.setRotateAngle(this.Pillar01a_1, -0.17453292f, 0.0f, -0.17453292f);
        this.Pillar02b = new ModelRenderer(this, 0, 0);
        this.Pillar02b.setRotationPoint(2.0f, -10.6f, 0.5f);
        this.Pillar02b.addBox(-5.5f, -6.0f, -4.0f, 8, 8, 7, 0.0f);
        this.setRotateAngle(this.Pillar02b, 0.17453292f, 0.0f, 0.17453292f);
        this.Pillar01a = new ModelRenderer(this, 0, 0);
        this.Pillar01a.setRotationPoint(7.0f, 2.0f, 7.0f);
        this.Pillar01a.addBox(-5.0f, -10.0f, -5.0f, 10, 10, 10, 0.0f);
        this.setRotateAngle(this.Pillar01a, 0.17453292f, 0.0f, -0.17453292f);
        this.Base03 = new ModelRenderer(this, 0, 0);
        this.Base03.setRotationPoint(8.0f, 0.0f, -8.0f);
        this.Base03.addBox(0.0f, 0.0f, 0.0f, 16, 6, 16, 0.0f);
        this.Base04 = new ModelRenderer(this, 0, 0);
        this.Base04.setRotationPoint(8.0f, -3.0f, 8.0f);
        this.Base04.addBox(0.0f, 0.0f, 0.0f, 16, 9, 16, 0.0f);
        this.Body04 = new ModelRenderer(this, 0, 0);
        this.Body04.setRotationPoint(-22.0f, -4.0f, -10.0f);
        this.Body04.addBox(0.0f, 0.0f, 0.0f, 12, 4, 20, 0.0f);
        this.Pillar01b = new ModelRenderer(this, 0, 0);
        this.Pillar01b.setRotationPoint(0.0f, -3.0f, 0.0f);
        this.Pillar01b.addBox(-3.0f, -13.3f, -3.0f, 7, 8, 7, 0.0f);
        this.setRotateAngle(this.Pillar01b, 0.17453292f, 0.0f, -0.17453292f);
        this.Body01 = new ModelRenderer(this, 0, 0);
        this.Body01.setRotationPoint(7.0f, -6.0f, 6.0f);
        this.Body01.addBox(0.0f, 0.0f, 0.0f, 14, 6, 14, 0.0f);
        this.Base07 = new ModelRenderer(this, 0, 0);
        this.Base07.setRotationPoint(-24.0f, -2.0f, -8.0f);
        this.Base07.addBox(0.0f, 0.0f, 0.0f, 16, 8, 16, 0.0f);
        this.BodyMain = new ModelRenderer(this, 0, 0);
        this.BodyMain.setRotationPoint(0.0f, 18.0f, 0.0f);
        this.BodyMain.addBox(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.Base00 = new ModelRenderer(this, 0, 0);
        this.Base00.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Base00.addBox(-24.0f, 0.0f, -24.0f, 16, 6, 16, 0.0f);
        this.Base08 = new ModelRenderer(this, 0, 0);
        this.Base08.setRotationPoint(-8.0f, 1.0f, -8.0f);
        this.Base08.addBox(0.0f, 0.0f, 0.0f, 16, 5, 16, 0.0f);
        this.Pillar03a = new ModelRenderer(this, 0, 0);
        this.Pillar03a.setRotationPoint(6.0f, 1.0f, 7.0f);
        this.Pillar03a.addBox(-4.5f, -8.0f, -5.0f, 9, 9, 10, 0.0f);
        this.setRotateAngle(this.Pillar03a, -0.17453292f, 0.0f, 0.17453292f);
        this.BodyMain.addChild(this.Base00);
        this.BodyMain.addChild(this.Body06);
        this.BodyMain.addChild(this.Body07);
        this.BodyMain.addChild(this.Base06);
        this.BodyMain.addChild(this.Body03);
        this.BodyMain.addChild(this.Body08);
        this.Pillar01a_1.addChild(this.Pillar01b_1);
        this.Pillar03a.addChild(this.Pillar03b);
        this.BodyMain.addChild(this.Body02);
        this.Body03.addChild(this.Pillar02a);
        this.BodyMain.addChild(this.Base02);
        this.BodyMain.addChild(this.Base01);
        this.BodyMain.addChild(this.Base05);
        this.BodyMain.addChild(this.Body05);
        this.Body07.addChild(this.Pillar01a_1);
        this.Pillar02a.addChild(this.Pillar02b);
        this.Body01.addChild(this.Pillar01a);
        this.BodyMain.addChild(this.Base03);
        this.BodyMain.addChild(this.Base04);
        this.BodyMain.addChild(this.Body04);
        this.Pillar01a.addChild(this.Pillar01b);
        this.BodyMain.addChild(this.Body01);
        this.BodyMain.addChild(this.Base07);
        this.BodyMain.addChild(this.Base08);
        this.Body05.addChild(this.Pillar03a);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushAttrib();
        GlStateManager.pushMatrix();
        GlStateManager.disableLighting();
        GlStateManager.enableCull();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        this.BodyMain.render(f5);
        GlStateManager.disableCull();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }

    public void render(float f5) {
        this.render(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
