package com.lulan.shincolle.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ParticleLaser
extends Particle {
    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle:textures/particles/ParticleLaser.png");
    private final double tarX;
    private final double tarY;
    private final double tarZ;

    public ParticleLaser(World world, double posX, double posY, double posZ, double tarX, double tarY, double tarZ, float scale, int type) {
        super(world, posX, posY, posZ);
        this.setSize(0.0f, 0.0f);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleScale = scale;
        this.tarX = tarX;
        this.tarY = tarY;
        this.tarZ = tarZ;
        this.canCollide = false;
        switch (type) {
            case 0: {
                this.particleMaxAge = 11;
                this.particleRed = 1.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.particleAlpha = 1.0f;
                break;
            }
            case 1: {
                this.particleMaxAge = 11;
                this.particleAge = 4;
                this.particleRed = 1.0f;
                this.particleGreen = 0.0f;
                this.particleBlue = 0.0f;
                this.particleAlpha = 1.0f;
                break;
            }
            default:
        }
    }

    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float cosYaw, float cosPitch, float sinYaw, float sinYawsinPitch, float cosYawsinPitch) {
        double f11 = this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX;
        double f12 = this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY;
        double f13 = this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ;
        double f21 = this.tarX - interpPosX;
        double f22 = this.tarY - interpPosY;
        double f23 = this.tarZ - interpPosZ;
        float minU = 0.0f;
        float maxU = (float)this.rand.nextInt(32) + 32;
        float minV = (this.particleAge % 12) / 12.0f;
        float maxV = minV + 0.08333333f;
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableLighting();
        render.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        render.pos(f21, f22, f23).tex(maxU, maxV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f21, f22 + this.particleScale * 0.3, f23).tex(maxU, minV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12 + this.particleScale * 0.3, f13).tex(minU, minV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12, f13).tex(minU, maxV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12, f13).tex(minU, maxV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12 + this.particleScale * 0.3, f13).tex(minU, minV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f21, f22 + this.particleScale * 0.3, f23).tex(maxU, minV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f21, f22, f23).tex(maxU, maxV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(false);
        GlStateManager.popMatrix();
    }

    public int getFXLayer() {
        return 3;
    }

    public void onUpdate() {
        if (this.particleAge++ > this.particleMaxAge) {
            this.setExpired();
        }
    }
}
