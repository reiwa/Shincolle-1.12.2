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
public class ParticleTexts
extends Particle {
    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle:textures/particles/ParticleTexts.png");
    private final int particleType;

    public ParticleTexts(World world, double posX, double posY, double posZ, float scale, int type) {
        super(world, posX, posY, posZ);
        this.setSize(0.0f, 0.0f);
        this.motionX = 0.0;
        this.motionZ = 0.0;
        this.motionY = 0.1;
        this.particleScale = scale;
        this.particleMaxAge = 25;
        this.particleType = type;
        this.canCollide = false;
    }

    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float cosYaw, float cosPitch, float sinYaw, float sinYawsinPitch, float cosYawsinPitch) {
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
        GlStateManager.pushMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.disableLighting();
        float f6 = 0.0f;
        float f7 = 1.0f;
        float f8 = this.particleType / 5.0f;
        float f9 = (this.particleType + 1.0f) / 5.0f;
        float f10 = 0.8f;
        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX);
        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY);
        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ);
        render.begin(7, DefaultVertexFormats.POSITION_TEX);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        render.pos(f11 - cosYaw * f10, f12 - cosPitch * 0.2f, f13 - sinYaw * f10).tex(f7, f9).endVertex();
        render.pos(f11 - cosYaw * f10, f12 + cosPitch * 0.2f, f13 - sinYaw * f10).tex(f7, f8).endVertex();
        render.pos(f11 + cosYaw * f10, f12 + cosPitch * 0.2f, f13 + sinYaw * f10).tex(f6, f8).endVertex();
        render.pos(f11 + cosYaw * f10, f12 - cosPitch * 0.2f, f13 + sinYaw * f10).tex(f6, f9).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.enableLighting();
        GlStateManager.depthMask(false);
        GlStateManager.popMatrix();
    }

    public int getFXLayer() {
        return 3;
    }

    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ > this.particleMaxAge) {
            this.setExpired();
        }
        this.move(this.motionX, this.motionY, this.motionZ);
        this.motionY *= 0.9;
    }
}
