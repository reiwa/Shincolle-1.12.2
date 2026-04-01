package com.lulan.shincolle.client.render;

import com.lulan.shincolle.client.model.ModelAbyssMissile;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;

public class RenderMiscEntity
extends Render<Entity> {
    public static final ResourceLocation TEX_AM = new ResourceLocation("shincolle:textures/entity/EntityAbyssMissile.png");
    public static final ModelBase MD_AM = new ModelAbyssMissile();
    public static final FactoryDefault FACTORY_MISC = new FactoryDefault();
    protected int mobID = 0;
    protected boolean initModel = true;
    protected ModelBase mainModel;

    public RenderMiscEntity(RenderManager rm) {
        super(rm);
    }

    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull Entity entity) {
        return TEX_AM;
    }

    protected void setModel() {
        switch (this.mobID) {
            case -1: {
                this.mainModel = null;
                break;
            }
            case 0: {
                this.mainModel = MD_AM;
                break;
            }
            default: {
                this.mainModel = MD_AM;
            }
        }
    }

    protected void setShadowSize() {
        this.shadowSize = 0.0f;
    }

    public void doRender(Entity entity, double x, double y, double z, float yaw, float parTick) {
        if (this.initModel) {
            this.mobID = ((IShipCustomTexture)entity).getTextureID();
            this.initModel = false;
            this.setModel();
        }
        if (this.mainModel == null) {
            return;
        }
        this.setShadowSize();
        this.bindEntityTexture(entity);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y + 0.3f, (float)z);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }
        GlStateManager.enableRescaleNormal();
        this.mainModel.render(entity, parTick, 0.0f, 0.0f, entity.rotationYaw, entity.rotationPitch, 0.0625f);
        GlStateManager.disableRescaleNormal();
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, yaw, parTick);
    }

    public static class FactoryDefault
    implements IRenderFactory<Entity> {
        public Render<? super Entity> createRenderFor(RenderManager rm) {
            return new RenderMiscEntity(rm);
        }
    }
}
