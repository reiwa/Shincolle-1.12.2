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
public class Particle91Type
extends Particle {
    private static final ResourceLocation TEXTURE1 = new ResourceLocation("shincolle:textures/particles/Particle91Type.png");
    private final int fadeTime = 16;
    private final int middTime = 60;
    private final int totalTime = 2 * this.fadeTime + this.middTime;

    private float alpha;
    private final float fadeCoef = 1.0f / this.fadeTime;

    public Particle91Type(World world, double posX, double posY, double posZ, float scale) {
        super(world, 0.0, 0.0, 0.0);
        this.setSize(0.0f, 0.0f);
        this.setPosition(posX, posY + this.rand.nextDouble() * 4.0, posZ);
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleScale = scale;
        this.particleMaxAge = 136;
        this.canCollide = false;
    }

    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float cosYaw, float cosPitch, float sinYaw, float sinYawsinPitch, float cosYawsinPitch) {
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE1);
        GlStateManager.pushMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableLighting();
        render.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        int partAge;
        for (int i = 0; i < 6; ++i) {
            partAge = this.particleAge - i * 8;
            if (partAge <= -1 || partAge >= this.totalTime) continue;
            float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX);
            float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY);
            float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ);
            float minu = 0.16666667f * i;
            float maxu = 0.16666667f * (i + 1);
            float scale;
            float x = f11 - (i - 2.5f) * this.particleScale * 2.0f * cosYaw;
            float y = f12;
            float z = f13 - (i - 2.5f) * this.particleScale * 2.0f * sinYaw;
            if (partAge < this.fadeTime) {
                scale = this.particleScale * (3.0f - 2.0f * this.fadeCoef * partAge);
                this.alpha = this.fadeCoef * partAge;
            } else if (partAge >= this.fadeTime + this.middTime) {
                partAge -= this.fadeTime + this.middTime;
                scale = this.particleScale * (1.0f + 2.0f * this.fadeCoef * partAge);
                this.alpha = 1.0f - this.fadeCoef * partAge;
            } else {
                scale = this.particleScale;
                this.alpha = 1.0f;
            }
            this.addQuad(render, scale, x, y, z, cosYaw, cosPitch, sinYaw, minu, maxu, 0.0f, 1.0f);
        }
        Tessellator.getInstance().draw();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(false);
        GlStateManager.popMatrix();
    }

    private void addQuad(BufferBuilder render, float scale, float x, float y, float z, float offx, float offy, float offz, float minu, float maxu, float minv, float maxv) {
        float offsetX = offx * scale;
        float offsetY = offy * scale;
        float offsetZ = offz * scale;
        render.pos(x - offsetX, y - offsetY, z - offsetZ).tex(maxu, maxv).color(1.0f, 1.0f, 1.0f, this.alpha).endVertex();
        render.pos(x - offsetX, y + offsetY, z - offsetZ).tex(maxu, minv).color(1.0f, 1.0f, 1.0f, this.alpha).endVertex();
        render.pos(x + offsetX, y + offsetY, z + offsetZ).tex(minu, minv).color(1.0f, 1.0f, 1.0f, this.alpha).endVertex();
        render.pos(x + offsetX, y - offsetY, z + offsetZ).tex(minu, maxv).color(1.0f, 1.0f, 1.0f, this.alpha).endVertex();
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
