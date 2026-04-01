package com.lulan.shincolle.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelAbyssMissile
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer Head;
    private final ModelRenderer Tail;
    private final ModelRenderer Tail1;
    private final ModelRenderer Tail2;

    public ModelAbyssMissile() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0f, 14.0f, -1.5f);
        this.Body.addBox(-2.0f, -2.0f, -5.5f, 4, 4, 11, 0.0f);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(-1.5f, -1.5f, -6.5f);
        this.Head.addBox(0.0f, 0.0f, 0.0f, 3, 3, 1, 0.0f);
        this.Tail = new ModelRenderer(this, 0, 4);
        this.Tail.setRotationPoint(-1.0f, -1.0f, 5.5f);
        this.Tail.addBox(0.0f, 0.0f, 0.0f, 2, 2, 3, 0.0f);
        this.Tail1 = new ModelRenderer(this, 0, 20);
        this.Tail1.setRotationPoint(-0.5f, -2.5f, 5.5f);
        this.Tail1.addBox(0.0f, 0.0f, 0.0f, 1, 5, 4, 0.0f);
        this.Tail2 = new ModelRenderer(this, 0, 15);
        this.Tail2.setRotationPoint(-2.5f, -0.5f, 5.5f);
        this.Tail2.addBox(0.0f, 0.0f, 0.0f, 5, 1, 4, 0.0f);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.Tail1);
        this.Body.addChild(this.Tail2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        if (entity.ticksExisted < 2) {
            return;
        }
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        GlStateManager.translate(0.0f, -0.65f, 0.1f);
        this.Body.rotateAngleY = f3;
        this.Body.rotateAngleX = f4;
    }
}
