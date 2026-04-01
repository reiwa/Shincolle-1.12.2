package com.lulan.shincolle.client.render;

import com.lulan.shincolle.client.model.ShipModelBaseAdv;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.handler.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;

public class LayerShipHeldItem
implements LayerRenderer<EntityLivingBase> {
    protected final RenderLivingBase<?> render;
    protected ShipModelBaseAdv mainModel;
    protected ModelRenderer[] hand;
    protected float[] itemOffset;
    protected float[] itemRotate;
    protected float modelScale;

    public LayerShipHeldItem(RenderLivingBase<?> render) {
        this.render = render;
    }

    public void doRenderLayer(EntityLivingBase entity, float swingTick, float swingAmount, float partialTicks, float tick, float yaw, float pitch, float scale) {
        if (entity instanceof BasicEntityShip && !((BasicEntityShip)entity).canShowHeldItem()) {
            return;
        }
        ItemStack stackMain = entity.getHeldItemMainhand();
        ItemStack stackOff = entity.getHeldItemOffhand();
        if (stackMain != null) {
            this.renderHeldItem(entity, stackMain, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
        }
        if (stackOff != null) {
            this.renderHeldItem(entity, stackOff, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
        }
    }

    private void renderHeldItem(EntityLivingBase entity, ItemStack stack, ItemCameraTransforms.TransformType type, EnumHandSide handSide) {
        GlStateManager.pushMatrix();
        if (entity.isSneaking()) {
            GlStateManager.translate(0.0f, 0.2f, 0.0f);
        }
        if (this.render.getMainModel() instanceof ShipModelBaseAdv) {
            boolean isBlock = stack.getItem() instanceof ItemBlock;
            this.mainModel = (ShipModelBaseAdv)this.render.getMainModel();
            this.hand = this.mainModel.getArmForSide(handSide);
            this.itemOffset = this.mainModel.getHeldItemOffset((IShipEmotion)entity, handSide, isBlock ? 1 : 0);
            this.itemRotate = this.mainModel.getHeldItemRotate((IShipEmotion)entity, handSide, isBlock ? 1 : 0);
            this.modelScale = this.mainModel.getScale();
            if (this.hand != null) {
                boolean flag = handSide == EnumHandSide.LEFT;
                GlStateManager.translate((this.itemOffset[0] + ConfigHandler.scaleHeldItem[1]) * (flag ? -1.0f : 1.0f), this.itemOffset[1] + ConfigHandler.scaleHeldItem[2], this.itemOffset[2] + ConfigHandler.scaleHeldItem[3]);
                for (int i = 0; i < this.hand.length; ++i) {
                    this.hand[i].postRender(0.0625f * this.modelScale);
                }
                GlStateManager.scale(this.modelScale, this.modelScale, this.modelScale);
                GlStateManager.rotate(-90.0f + this.itemRotate[0], 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(180.0f + this.itemRotate[1], 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(this.itemRotate[2], 0.0f, 0.0f, 1.0f);
                GlStateManager.translate((flag ? -1 : 1) / 16.0f, 0.125f, -0.625f);
                if (stack.getItem().isFull3D()) {
                    GlStateManager.scale(ConfigHandler.scaleHeldItem[0] * 0.5, ConfigHandler.scaleHeldItem[0], ConfigHandler.scaleHeldItem[0]);
                } else if (isBlock) {
                    GlStateManager.scale(ConfigHandler.scaleHeldItem[0] * 0.75, ConfigHandler.scaleHeldItem[0] * 0.75, ConfigHandler.scaleHeldItem[0] * 0.75);
                } else {
                    GlStateManager.scale(ConfigHandler.scaleHeldItem[0], ConfigHandler.scaleHeldItem[0], ConfigHandler.scaleHeldItem[0]);
                }
                GlStateManager.disableLighting();
                Minecraft.getMinecraft().getItemRenderer().renderItemSide(entity, stack, type, flag);
                GlStateManager.enableLighting();
            }
        }
        GlStateManager.popMatrix();
    }

    public boolean shouldCombineTextures() {
        return false;
    }
}
