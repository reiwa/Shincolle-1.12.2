package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.utility.CalcHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class ParticleSweep
extends Particle {
    private static final ResourceLocation TEXTURE1 = new ResourceLocation("textures/entity/sweep.png");
    private final int particleType;
    private final Entity host;
    private float swpScale1;
    private float swpScale2;
    private float swpScale3;
    private float swpAngle;

    public ParticleSweep(Entity entity, int type, float ... parms) {
        super(entity.world, 0.0, 0.0, 0.0);
        this.setSize(0.0f, 0.0f);
        this.host = entity;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleType = type;
        this.canCollide = false;
        if(type == 0){
            this.swpScale1 = parms[0];
            this.swpScale2 = parms[1];
            this.swpScale3 = parms[2];
            this.particleMaxAge = (int)parms[4];
            this.particleRed = parms[5];
            this.particleGreen = parms[6];
            this.particleBlue = parms[7];
            this.particleAlpha = parms[8];
            this.setPosition(entity.posX, entity.posY + (entity.height * 0.6f), entity.posZ);
            this.swpAngle = this.host instanceof EntityLivingBase ? ((EntityLivingBase)this.host).renderYawOffset : this.host.rotationYaw;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
    }

    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float cosYaw, float cosPitch, float sinYaw, float sinYawsinPitch, float cosYawsinPitch) {
        int i = (int)((this.particleAge + ptick) / this.particleMaxAge * 8.0f);
        if (i >= 8) {
            return;
        }
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE1);
        float x = (float)(this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX);
        float y = (float)(this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY);
        float z = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ);
        float minU = (i % 4) * 0.25f;
        float maxU = minU + 0.24975f;
        float minV = ((float)i / 4) * 0.5f;
        float maxV = minV + 0.4995f;
        float[] pos1 = CalcHelper.rotateXZByAxis(entity.width * 0.35f, 0.0f, this.swpAngle * ((float)Math.PI / 180), 1.0f);
        GlStateManager.pushMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        render.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        render.pos(x + pos1[1] - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5f, z + pos1[0] + this.swpScale3 * pos1[1]).tex(maxU, maxV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] * this.swpScale2 - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5f, z + pos1[0] * this.swpScale2 + this.swpScale3 * pos1[1]).tex(maxU, minV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] * this.swpScale2 * 1.25f + this.swpScale3 * pos1[0], y + this.swpScale1 * 0.8f, z + pos1[0] * this.swpScale2 * 1.25f - this.swpScale3 * pos1[1]).tex(minU, minV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] + this.swpScale3 * pos1[0], y + this.swpScale1 * 0.8f, z + pos1[0] - this.swpScale3 * pos1[1]).tex(minU, maxV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] + this.swpScale3 * pos1[0], y + this.swpScale1 * 0.8f, z + pos1[0] - this.swpScale3 * pos1[1]).tex(minU, maxV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] * this.swpScale2 * 1.25f + this.swpScale3 * pos1[0], y + this.swpScale1 * 0.8f, z + pos1[0] * this.swpScale2 * 1.25f - this.swpScale3 * pos1[1]).tex(minU, minV).color(this.particleRed, this.particleGreen, this.particleBlue * 0.5f, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] * this.swpScale2 - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5f, z + pos1[0] * this.swpScale2 + this.swpScale3 * pos1[1]).tex(maxU, minV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5f, z + pos1[0] + this.swpScale3 * pos1[1]).tex(maxU, maxV).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        pos1 = CalcHelper.rotateXZByAxis(entity.width * 0.3f, 0.0f, this.swpAngle * ((float)Math.PI / 180) - 0.001f, 1.0f);
        render.pos(x + pos1[1] - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5f, z + pos1[0] + this.swpScale3 * pos1[1]).tex(maxU, maxV).color(this.particleRed * 0.5f, this.particleGreen * 0.5f, this.particleBlue * 0.5f, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] * this.swpScale2 - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5f, z + pos1[0] * this.swpScale2 + this.swpScale3 * pos1[1]).tex(maxU, minV).color(this.particleRed * 0.5f, this.particleGreen * 0.5f, this.particleBlue * 0.5f, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] * this.swpScale2 * 1.25f + this.swpScale3 * 1.25f * pos1[0], y + this.swpScale1 * 0.8f, z + pos1[0] * this.swpScale2 * 1.25f - this.swpScale3 * 1.25f * pos1[1]).tex(minU, minV).color(this.particleRed * 0.5f, this.particleGreen * 0.5f, this.particleBlue * 0.5f, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] + this.swpScale3 * 1.25f * pos1[0], y + this.swpScale1 * 0.8f, z + pos1[0] - this.swpScale3 * 1.25f * pos1[1]).tex(minU, maxV).color(this.particleRed * 0.5f, this.particleGreen * 0.5f, this.particleBlue * 0.5f, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] + this.swpScale3 * 1.25f * pos1[0], y + this.swpScale1 * 0.8f, z + pos1[0] - this.swpScale3 * 1.25f * pos1[1]).tex(minU, maxV).color(this.particleRed * 0.5f, this.particleGreen * 0.5f, this.particleBlue * 0.5f, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] * this.swpScale2 * 1.25f + this.swpScale3 * 1.25f * pos1[0], y + this.swpScale1 * 0.8f, z + pos1[0] * this.swpScale2 * 1.25f - this.swpScale3 * 1.25f * pos1[1]).tex(minU, minV).color(this.particleRed, this.particleGreen * 0.5f, this.particleBlue * 0.5f, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] * this.swpScale2 - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5f, z + pos1[0] * this.swpScale2 + this.swpScale3 * pos1[1]).tex(maxU, minV).color(this.particleRed * 0.5f, this.particleGreen * 0.5f, this.particleBlue * 0.5f, this.particleAlpha).endVertex();
        render.pos(x + pos1[1] - this.swpScale3 * pos1[0], y - this.swpScale1 * 0.5f, z + pos1[0] + this.swpScale3 * pos1[1]).tex(maxU, maxV).color(this.particleRed * 0.5f, this.particleGreen * 0.5f, this.particleBlue * 0.5f, this.particleAlpha).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
    }

    public int getBrightnessForRender(float p_189214_1_) {
        return 61680;
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
        this.setPosition(this.host.posX, this.host.posY + (this.host.height * 0.6f), this.host.posZ);
        if(this.particleType == 0){
            this.swpAngle = this.host instanceof EntityLivingBase ? ((EntityLivingBase)this.host).renderYawOffset : this.host.rotationYaw;
            this.particleAlpha *= 0.6f;
        }
    }
}
