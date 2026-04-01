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

public class ParticleGradient
extends Particle {
    private static final ResourceLocation TEXTURE1 = new ResourceLocation("shincolle:textures/particles/ParticleGradient.png");
    private final int particleType;
    private int gradCurrent;
    private int gradSpace;
    private final Entity host;
    private float[][] gradPos;
    private float gradSpd;
    private float gradFad;
    private float gradHFad;
    private float gradSlope;

    public ParticleGradient(Entity entity, int type, float ... parms) {
        super(entity.world, 0.0, 0.0, 0.0);
        this.setSize(0.0f, 0.0f);
        this.host = entity;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleType = type;
        this.canCollide = false;
        this.gradCurrent = 0;
        switch (type) {
            case 0: 
            case 1: {
                this.particleScale = parms[0];
                this.gradFad = parms[1];
                this.gradSpd = parms[2];
                this.gradHFad = 20.0f;
                this.gradSlope = 1.5f;
                this.gradSpace = (int)parms[3];
                if (this.gradSpace <= 1) {
                    this.gradSpace = 1;
                }
                this.particleRed = parms[4];
                this.particleGreen = parms[5];
                this.particleBlue = parms[6];
                this.particleAlpha = parms[7];
                this.particleMaxAge = 80;
                this.gradPos = new float[20][7];
                this.setPosition(entity.posX, entity.posY, entity.posZ);
                break;
            }
            case 2: {
                this.particleScale = parms[0];
                this.gradFad = parms[1];
                this.gradSpd = parms[2];
                this.gradSpace = (int)parms[3];
                if (this.gradSpace <= 1) {
                    this.gradSpace = 1;
                }
                this.particleRed = parms[4];
                this.particleGreen = parms[5];
                this.particleBlue = parms[6];
                this.particleAlpha = parms[7];
                this.gradHFad = parms[8];
                this.gradSlope = parms[9];
                this.particleMaxAge = 80;
                this.gradPos = new float[20][7];
                this.setPosition(entity.posX, entity.posY, entity.posZ);
                break;
            }
            default:
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
    }

    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float cosYaw, float cosPitch, float sinYaw, float sinYawsinPitch, float cosYawsinPitch) {
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE1);
        float x = (float)(this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX);
        float y = (float)(this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY);
        float z = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ);
        GlStateManager.pushMatrix();
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableLighting();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        for (float[] grad : this.gradPos) {
            if (grad[0] > 6.0f && grad[0] <= 0.0f || grad[5] < 0.05f) continue;
            float rad = grad[1] + (grad[0] - grad[1]) * ptick;
            float h = (this.gradHFad - grad[6]) / this.gradHFad;
            if (h < 0.1f) {
                h = 0.1f;
            }
            render.begin(8, DefaultVertexFormats.POSITION_TEX_COLOR);
            render.pos(x + rad, y, z + rad).tex(0.0, 1.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x + rad * this.gradSlope, y + this.particleScale * h, z + rad * this.gradSlope).tex(0.0, 0.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x - rad, y, z + rad).tex(1.0, 1.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x - rad * this.gradSlope, y + this.particleScale * h, z + rad * this.gradSlope).tex(1.0, 0.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x - rad, y, z - rad).tex(0.0, 1.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x - rad * this.gradSlope, y + this.particleScale * h, z - rad * this.gradSlope).tex(0.0, 0.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x + rad, y, z - rad).tex(1.0, 1.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x + rad * this.gradSlope, y + this.particleScale * h, z - rad * this.gradSlope).tex(1.0, 0.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x + rad, y, z + rad).tex(0.0, 1.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x + rad * this.gradSlope, y + this.particleScale * h, z + rad * this.gradSlope).tex(0.0, 0.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x + rad, y, z + rad).tex(0.0, 1.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x + rad * this.gradSlope, y + this.particleScale * h, z + rad * this.gradSlope).tex(0.0, 0.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x + rad, y, z - rad).tex(1.0, 1.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x + rad * this.gradSlope, y + this.particleScale * h, z - rad * this.gradSlope).tex(1.0, 0.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x - rad, y, z - rad).tex(0.0, 1.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x - rad * this.gradSlope, y + this.particleScale * h, z - rad * this.gradSlope).tex(0.0, 0.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x - rad, y, z + rad).tex(1.0, 1.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x - rad * this.gradSlope, y + this.particleScale * h, z + rad * this.gradSlope).tex(1.0, 0.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x + rad, y, z + rad).tex(0.0, 1.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            render.pos(x + rad * this.gradSlope, y + this.particleScale * h, z + rad * this.gradSlope).tex(0.0, 0.0).color(grad[2], grad[3], grad[4], grad[5]).endVertex();
            Tessellator.getInstance().draw();
        }
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.popMatrix();
    }

    public int getFXLayer() {
        return 3;
    }

    public void onUpdate() {
        if (this.particleAge++ > this.particleMaxAge) {
            this.setExpired();
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        switch (this.particleType) {
            case 0: {
                break;
            }
            case 1: {
                if (this.host != null) {
                    this.setPosition(this.host.posX, this.host.posY, this.host.posZ);
                }
                if (this.particleAge <= 40 && this.particleAge % this.gradSpace == 0) {
                    this.gradPos[this.gradCurrent] = new float[]{0.0f, 0.0f, this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha, 0.0f};
                    ++this.gradCurrent;
                    if (this.gradCurrent >= this.gradPos.length) {
                        this.gradCurrent = 0;
                    }
                }
                for (int i = 0; i < this.gradPos.length; ++i) {
                    this.gradPos[i][1] = this.gradPos[i][0];
                    float[] fArray = this.gradPos[i];
                    fArray[0] = fArray[0] + this.gradSpd;
                    float[] fArray2 = this.gradPos[i];
                    fArray2[6] = fArray2[6] + 1.0f;
                    if (this.particleAge % 2 != 0) continue;
                    float[] fArray3 = this.gradPos[i];
                    fArray3[5] = fArray3[5] * this.gradFad;
                }
                break;
            }
            case 2: {
                if (this.particleAge == 1) {
                    this.gradPos[0] = new float[]{0.0f, 0.0f, this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha, 0.0f};
                }
                this.gradPos[0][1] = this.gradPos[0][0];
                float[] fArray = this.gradPos[0];
                fArray[0] = fArray[0] + this.gradSpd;
                float[] fArray4 = this.gradPos[0];
                fArray4[6] = fArray4[6] + 1.0f;
                if ((this.particleAge & 1) != 0) break;
                float[] fArray5 = this.gradPos[0];
                fArray5[5] = fArray5[5] * this.gradFad;
                break;
            }
            default:
        }
    }
}
