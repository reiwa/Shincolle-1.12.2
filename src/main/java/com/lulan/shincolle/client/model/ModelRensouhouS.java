package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelRensouhouS
extends ModelBase {
    private final ModelRenderer BodyMain;
    private final ModelRenderer HeadBase;
    private final ModelRenderer TailJaw1;
    private final ModelRenderer Head;
    private final ModelRenderer TailHeadCL1;
    private final ModelRenderer TailHeadCR1;
    private final ModelRenderer Tooth02;
    private final ModelRenderer Tube01;
    private final ModelRenderer Tube02;
    private final ModelRenderer Tube03;
    private final ModelRenderer TailHead2;
    private final ModelRenderer Tooth01;
    private final ModelRenderer HeadCannon1;
    private final ModelRenderer HeadCannon2;
    private final ModelRenderer GlowBodyMain;
    private final ModelRenderer GlowHeadBase;
    private final ModelRenderer GlowHead;
    private final ModelRenderer GlowTailJaw1;
    private final ModelRenderer GlowTailHead2;

    public ModelRensouhouS() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Tube03 = new ModelRenderer(this, 0, 0);
        this.Tube03.setRotationPoint(-5.5f, 4.6f, 22.0f);
        this.Tube03.addBox(0.0f, 0.0f, 0.0f, 11, 1, 1, 0.0f);
        this.HeadBase = new ModelRenderer(this, 0, 0);
        this.HeadBase.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.HeadBase.addBox(-6.0f, -8.0f, 2.0f, 12, 15, 8, 0.0f);
        this.setRotateAngle(this.HeadBase, -0.13962634f, (float)(-Math.PI), 0.0f);
        this.Tube01 = new ModelRenderer(this, 0, 0);
        this.Tube01.setRotationPoint(-4.5f, 3.0f, 13.0f);
        this.Tube01.addBox(-0.5f, 0.0f, 0.0f, 1, 1, 10, 0.0f);
        this.setRotateAngle(this.Tube01, -0.17453292f, -0.05235988f, 0.0f);
        this.HeadCannon1 = new ModelRenderer(this, 26, 6);
        this.HeadCannon1.setRotationPoint(3.2f, 3.5f, 12.0f);
        this.HeadCannon1.addBox(-2.0f, -2.0f, 0.0f, 4, 4, 15, 0.0f);
        this.setRotateAngle(this.HeadCannon1, 0.08726646f, 0.08726646f, 0.017627826f);
        this.BodyMain = new ModelRenderer(this, 0, 0);
        this.BodyMain.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.TailJaw1 = new ModelRenderer(this, 0, 0);
        this.TailJaw1.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.TailJaw1.addBox(-6.5f, 0.0f, 0.0f, 13, 5, 16, 0.0f);
        this.setRotateAngle(this.TailJaw1, -0.3142f, 0.0f, 0.0f);
        this.Tooth02 = new ModelRenderer(this, 2, 42);
        this.Tooth02.setRotationPoint(0.0f, -3.0f, 4.0f);
        this.Tooth02.addBox(-5.5f, 0.0f, 0.0f, 11, 5, 11, 0.0f);
        this.setRotateAngle(this.Tooth02, 0.17453292f, 0.0f, 0.0f);
        this.TailHead2 = new ModelRenderer(this, 0, 0);
        this.TailHead2.setRotationPoint(0.0f, -1.0f, 6.5f);
        this.TailHead2.addBox(-7.0f, 0.0f, 0.0f, 14, 8, 13, 0.0f);
        this.Tooth01 = new ModelRenderer(this, 0, 25);
        this.Tooth01.setRotationPoint(0.0f, 4.5f, 4.5f);
        this.Tooth01.addBox(-6.0f, 0.0f, 0.0f, 12, 5, 12, 0.0f);
        this.setRotateAngle(this.Tooth01, -0.17453292f, 0.0f, 0.0f);
        this.Tube02 = new ModelRenderer(this, 0, 0);
        this.Tube02.setRotationPoint(4.5f, 3.0f, 13.0f);
        this.Tube02.addBox(-0.5f, 0.0f, 0.0f, 1, 1, 10, 0.0f);
        this.setRotateAngle(this.Tube02, -0.17453292f, 0.05235988f, 0.0f);
        this.HeadCannon2 = new ModelRenderer(this, 26, 6);
        this.HeadCannon2.setRotationPoint(-3.2f, 3.5f, 12.0f);
        this.HeadCannon2.addBox(-2.0f, -2.0f, 0.0f, 4, 4, 15, 0.0f);
        this.setRotateAngle(this.HeadCannon2, 0.08726646f, -0.08726646f, 0.0f);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0f, -8.5f, 4.0f);
        this.Head.addBox(-7.0f, -0.2f, -3.6f, 14, 8, 10, 0.0f);
        this.setRotateAngle(this.Head, 0.17453292f, 0.0f, 0.0f);
        this.TailHeadCR1 = new ModelRenderer(this, 36, 25);
        this.TailHeadCR1.mirror = true;
        this.TailHeadCR1.setRotationPoint(-5.5f, 0.0f, 9.0f);
        this.TailHeadCR1.addBox(-3.0f, -3.0f, -3.0f, 3, 6, 6, 0.0f);
        this.setRotateAngle(this.TailHeadCR1, 0.7853982f, -0.13962634f, 0.0f);
        this.TailHeadCL1 = new ModelRenderer(this, 36, 25);
        this.TailHeadCL1.setRotationPoint(5.5f, 0.0f, 9.0f);
        this.TailHeadCL1.addBox(0.0f, -3.0f, -3.0f, 3, 6, 6, 0.0f);
        this.setRotateAngle(this.TailHeadCL1, 0.7853982f, 0.13962634f, 0.0f);
        this.TailJaw1.addChild(this.Tube03);
        this.BodyMain.addChild(this.HeadBase);
        this.TailJaw1.addChild(this.Tube01);
        this.HeadBase.addChild(this.TailJaw1);
        this.Head.addChild(this.TailHead2);
        this.TailJaw1.addChild(this.Tube02);
        this.HeadBase.addChild(this.Head);
        this.HeadBase.addChild(this.TailHeadCR1);
        this.HeadBase.addChild(this.TailHeadCL1);
        this.GlowBodyMain = new ModelRenderer(this, 0, 0);
        this.GlowBodyMain.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.GlowHeadBase = new ModelRenderer(this, 0, 0);
        this.GlowHeadBase.setRotationPoint(0.0f, 0.0f, 9.0f);
        this.setRotateAngle(this.GlowHeadBase, -0.13962634f, (float)(-Math.PI), 0.0f);
        this.GlowHead = new ModelRenderer(this, 0, 0);
        this.GlowHead.setRotationPoint(0.0f, -8.5f, 4.0f);
        this.setRotateAngle(this.GlowHead, 0.17453292f, 0.0f, 0.0f);
        this.GlowTailJaw1 = new ModelRenderer(this, 0, 0);
        this.GlowTailJaw1.setRotationPoint(0.0f, 0.0f, 5.5f);
        this.setRotateAngle(this.GlowTailJaw1, -0.3142f, 0.0f, 0.0f);
        this.GlowTailHead2 = new ModelRenderer(this, 0, 0);
        this.GlowTailHead2.setRotationPoint(0.0f, -1.0f, 6.5f);
        this.GlowBodyMain.addChild(this.GlowHeadBase);
        this.GlowHeadBase.addChild(this.GlowHead);
        this.GlowHeadBase.addChild(this.GlowTailJaw1);
        this.GlowHead.addChild(this.GlowTailHead2);
        this.GlowHead.addChild(this.Tooth01);
        this.GlowTailJaw1.addChild(this.Tooth02);
        this.GlowTailHead2.addChild(this.HeadCannon1);
        this.GlowTailHead2.addChild(this.HeadCannon2);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.scale(0.4f, 0.4f, 0.4f);
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

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        IShipEmotion ent = (IShipEmotion)entity;
        GlStateManager.translate(0.0f, 0.75f, 0.0f);
        float angleX = MathHelper.cos(f2 * 0.1f);
        this.TailJaw1.rotateAngleX = angleX * 0.05f - 0.3142f;
        this.HeadCannon1.rotateAngleX = angleX * 0.1f + 0.15f;
        this.HeadCannon2.rotateAngleX = -angleX * 0.1f + 0.15f;
        if (ent.getAttackTick() > 0) {
            this.TailJaw1.rotateAngleX = angleX * 0.3f - 0.8f;
        }
        this.GlowTailJaw1.rotateAngleX = this.TailJaw1.rotateAngleX;
    }
}
