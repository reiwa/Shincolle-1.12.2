package com.lulan.shincolle.client.render;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.other.EntityShipFishingHook;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderShipFishing
extends Render<EntityShipFishingHook> {
    public static final ResourceLocation FISH_PARTICLES = new ResourceLocation("textures/particle/particles.png");
    public static final FactoryDefault FACTORY_FISHINGHOOK = new FactoryDefault();

    public RenderShipFishing(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    public void doRender(EntityShipFishingHook entity, double x, double y, double z, float entityYaw, float partialTicks) {
        float y2 = MathHelper.cos((entity.ticksExisted + partialTicks) * 0.15f) * 0.05f - 0.25f;
        float y3 = (float)y + y2;
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, y3 + 0.25f, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(0.5f, 0.5f, 0.5f);
        this.bindEntityTexture(entity);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder BufferBuilder = tessellator.getBuffer();
        GlStateManager.rotate(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate((this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * -this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }
        BufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        BufferBuilder.pos(-0.5, -0.5, 0.0).tex(0.0625, 0.1875).normal(0.0f, 1.0f, 0.0f).endVertex();
        BufferBuilder.pos(0.5, -0.5, 0.0).tex(0.125, 0.1875).normal(0.0f, 1.0f, 0.0f).endVertex();
        BufferBuilder.pos(0.5, 0.5, 0.0).tex(0.125, 0.125).normal(0.0f, 1.0f, 0.0f).endVertex();
        BufferBuilder.pos(-0.5, 0.5, 0.0).tex(0.0625, 0.125).normal(0.0f, 1.0f, 0.0f).endVertex();
        tessellator.draw();
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        if (entity.host != null && !this.renderOutlines) {
            int k = entity.host.getPrimaryHand() == EnumHandSide.RIGHT ? 1 : -1;
            float f9 = (entity.host.prevRenderYawOffset + (entity.host.renderYawOffset - entity.host.prevRenderYawOffset) * partialTicks) * ((float)Math.PI / 180);
            double d0 = MathHelper.sin(f9);
            double d1 = MathHelper.cos(f9);
            double d2 = k * 0.25;
            double d3 = entity.host.width;
            double d4 = entity.host.prevPosX + (entity.host.posX - entity.host.prevPosX) * partialTicks - d1 * d2 - d0 * d3;
            double d5 = entity.host.prevPosY + entity.host.getEyeHeight() + (entity.host.posY - entity.host.prevPosY) * partialTicks - 0.45;
            double d6 = entity.host.prevPosZ + (entity.host.posZ - entity.host.prevPosZ) * partialTicks - d0 * d2 + d1 * d3;
            double d7 = (entity.host.isSneaking() ? -0.1875 : 0.0) + entity.host.height * 0.2;
            if (entity.host instanceof BasicEntityShip) {
                d7 += ((BasicEntityShip)entity.host).isSitting() ? entity.host.height * -0.3 : 0.0;
            }
            double d13 = entity.prevPosX + (entity.posX - entity.prevPosX) * partialTicks;
            double d8 = entity.prevPosY + (entity.posY - entity.prevPosY) * partialTicks + 0.55 + y2;
            double d9 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * partialTicks;
            double d10 = (float)(d4 - d13);
            double d11 = (float)(d5 - d8) + d7;
            double d12 = (float)(d6 - d9);
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            BufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            for (int i1 = 0; i1 <= 16; ++i1) {
                float f10 = i1 / 16.0f;
                BufferBuilder.pos(x + d10 * f10, y3 + d11 * (f10 * f10 + f10) * 0.5 + 0.25, z + d12 * f10).color(200, 200, 200, 255).endVertex();
            }
            tessellator.draw();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
            super.doRender(entity, x, y, z, entityYaw, partialTicks);
        }
    }

    protected ResourceLocation getEntityTexture(EntityShipFishingHook entity) {
        return FISH_PARTICLES;
    }

    public static class FactoryDefault
    implements IRenderFactory<EntityShipFishingHook> {
        public Render<? super EntityShipFishingHook> createRenderFor(RenderManager rm) {
            return new RenderShipFishing(rm);
        }
    }
}
