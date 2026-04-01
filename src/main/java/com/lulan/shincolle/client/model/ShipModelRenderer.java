package com.lulan.shincolle.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ShipModelRenderer
extends ModelRenderer {
    public boolean tweakModel = false;
    public float scale2x = 0.0f;
    public float scale2y = 0.0f;
    public float scale2z = 0.0f;
    public float trans2x = 0.0f;
    public float trans2y = 0.0f;
    public float trans2z = 0.0f;
    public float rotat2x = 0.0f;
    public float rotat2y = 0.0f;
    public float rotat2z = 0.0f;

    public ShipModelRenderer(ModelBase model, int textureOffX, int textureOffY) {
        super(model, textureOffX, textureOffY);
    }

    @SideOnly(value=Side.CLIENT)
    public void render(float scale) {
        if (this.tweakModel) {
            GlStateManager.pushMatrix();
            GlStateManager.scale(this.scale2x, this.scale2y, this.scale2z);
            GlStateManager.rotate(this.rotat2x, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(this.rotat2y, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(this.rotat2z, 0.0f, 0.0f, 1.0f);
            GlStateManager.translate(this.trans2x, this.trans2y, this.trans2z);
            super.render(scale);
            GlStateManager.popMatrix();
        } else {
            super.render(scale);
        }
    }
}
