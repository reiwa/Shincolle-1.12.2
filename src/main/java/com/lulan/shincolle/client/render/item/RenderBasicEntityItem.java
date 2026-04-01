package com.lulan.shincolle.client.render.item;

import com.lulan.shincolle.client.model.ModelBasicEntityItem;
import com.lulan.shincolle.item.BasicEntityItem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderBasicEntityItem
extends Render {
    public static final Factory FACTORY = new Factory();
    private static final ResourceLocation entityTexture = new ResourceLocation("shincolle:textures/entity/modelbasicentityitem.png");
    private final ModelBasicEntityItem model = new ModelBasicEntityItem();

    public RenderBasicEntityItem(RenderManager render) {
        super(render);
        this.shadowSize = 0.0f;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return entityTexture;
    }

    public void doRender(BasicEntityItem entity, double x, double y, double z, float ptick) {
        this.bindEntityTexture(entity);
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y + 0.1f, z);
        this.model.render(entity, entity.ticksExisted + ptick, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.popMatrix();
    }

    public void doRender(Entity entity, double x, double y, double z, float yaw, float ptick) {
        this.doRender((BasicEntityItem)entity, x, y, z, ptick);
    }

    public static class Factory
    implements IRenderFactory<BasicEntityItem> {
        public Render<? super BasicEntityItem> createRenderFor(RenderManager manager) {
            return new RenderBasicEntityItem(manager);
        }
    }
}
