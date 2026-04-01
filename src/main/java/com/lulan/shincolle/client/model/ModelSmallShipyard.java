package com.lulan.shincolle.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSmallShipyard
extends ModelBase {
    private final ModelRenderer Shape1;
    private final ModelRenderer Shape2;
    private final ModelRenderer Shape3;
    private final ModelRenderer Shape4;
    private final ModelRenderer Shape5;
    private final ModelRenderer Shape6;
    private final ModelRenderer Shape7;
    private final ModelRenderer Shape8;
    private final ModelRenderer Shape9;
    private final ModelRenderer Shape10;
    private final ModelRenderer Shape11;

    public ModelSmallShipyard() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Shape1 = new ModelRenderer(this, 0, 0);
        this.Shape1.addBox(0.0f, 0.0f, 0.0f, 16, 1, 16);
        this.Shape1.setRotationPoint(-8.0f, 23.0f, -8.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        this.Shape2 = new ModelRenderer(this, 0, 19);
        this.Shape2.addBox(0.0f, 0.0f, 0.0f, 14, 3, 10);
        this.Shape2.setRotationPoint(-7.0f, 20.0f, -3.0f);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        this.Shape3 = new ModelRenderer(this, 0, 0);
        this.Shape3.addBox(-5.0f, 0.0f, 0.0f, 6, 4, 6);
        this.Shape3.setRotationPoint(-1.0f, 17.0f, -1.5f);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        this.Shape4 = new ModelRenderer(this, 0, 0);
        this.Shape4.addBox(0.0f, 0.0f, 0.0f, 4, 6, 4);
        this.Shape4.setRotationPoint(-5.0f, 11.0f, -1.0f);
        this.Shape4.setTextureSize(64, 32);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.0f, 0.0f, 0.0f);
        this.Shape5 = new ModelRenderer(this, 48, 6);
        this.Shape5.addBox(0.0f, 0.0f, 0.0f, 3, 3, 3);
        this.Shape5.setRotationPoint(-4.5f, 8.0f, -0.5f);
        this.Shape5.setTextureSize(64, 32);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        this.Shape6 = new ModelRenderer(this, 32, 20);
        this.Shape6.addBox(0.0f, 0.0f, 0.0f, 10, 3, 6);
        this.Shape6.setRotationPoint(-3.5f, 18.0f, 0.0f);
        this.Shape6.setTextureSize(64, 32);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        this.Shape7 = new ModelRenderer(this, 0, 10);
        this.Shape7.addBox(0.0f, 0.0f, 0.0f, 4, 3, 4);
        this.Shape7.setRotationPoint(2.0f, 15.0f, 1.5f);
        this.Shape7.setTextureSize(64, 32);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, 0.0f, 0.0f, 0.0f);
        this.Shape8 = new ModelRenderer(this, 48, 12);
        this.Shape8.addBox(0.0f, 0.0f, 0.0f, 3, 3, 3);
        this.Shape8.setRotationPoint(2.5f, 12.5f, 2.0f);
        this.Shape8.setTextureSize(64, 32);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, 0.0f, 0.0f, 0.0f);
        this.Shape9 = new ModelRenderer(this, 0, 17);
        this.Shape9.addBox(0.0f, 1.0f, 0.0f, 11, 2, 4);
        this.Shape9.setRotationPoint(-5.0f, 20.0f, -7.0f);
        this.Shape9.setTextureSize(64, 32);
        this.Shape9.mirror = true;
        this.setRotation(this.Shape9, 0.0f, 0.0f, 0.0f);
        this.Shape10 = new ModelRenderer(this, 0, 10);
        this.Shape10.addBox(-2.0f, 0.0f, 0.0f, 4, 2, 4);
        this.Shape10.setRotationPoint(1.0f, 19.0f, -6.5f);
        this.Shape10.setTextureSize(64, 32);
        this.Shape10.mirror = true;
        this.setRotation(this.Shape10, 0.0f, 0.0f, 0.0f);
        this.Shape11 = new ModelRenderer(this, 48, 0);
        this.Shape11.addBox(0.0f, 0.0f, 0.0f, 3, 3, 3);
        this.Shape11.setRotationPoint(-0.5f, 16.01333f, -6.0f);
        this.Shape11.setTextureSize(64, 32);
        this.Shape11.mirror = true;
        this.setRotation(this.Shape11, 0.0f, 0.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
        this.Shape5.render(f5);
        this.Shape6.render(f5);
        this.Shape7.render(f5);
        this.Shape8.render(f5);
        this.Shape9.render(f5);
        this.Shape10.render(f5);
        this.Shape11.render(f5);
    }

    public void renderModel(float f5) {
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
        this.Shape5.render(f5);
        this.Shape6.render(f5);
        this.Shape7.render(f5);
        this.Shape8.render(f5);
        this.Shape9.render(f5);
        this.Shape10.render(f5);
        this.Shape11.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
