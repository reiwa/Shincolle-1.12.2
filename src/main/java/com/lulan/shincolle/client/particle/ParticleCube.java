package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.utility.CalcHelper;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ParticleCube
extends Particle {
    private final int particleType;
    private float shotYaw;
    private float shotPitch;
    private float scaleOut;
    private float scaleIn;
    private float alphaOut;
    private float alphaIn;
    private final double par1;
    private final double par2;
    private final double par3;
    private final double[][] vt;
    private final double[][] vt2;
    private final EntityLivingBase host;

    public ParticleCube(World world, EntityLivingBase host, double par1, double par2, double par3, float scale, int type) {
        super(world, host.posX, host.posY, host.posZ);
        this.setSize(0.0f, 0.0f);
        this.host = host;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleScale = scale;
        this.particleType = type;
        this.par1 = par1;
        this.par2 = par2;
        this.par3 = par3;
        this.vt = new double[8][3];
        this.vt2 = new double[8][3];
        this.canCollide = false;
        if(type == 1){
            this.particleMaxAge = 30;
            this.particleRed = 1.0f;
            this.particleGreen = 0.8f;
            this.particleBlue = 0.9f;
        } else {
            this.particleScale = (float)par1;
            this.particleMaxAge = 40;
            this.particleRed = 1.0f;
            this.particleGreen = 0.8f;
            this.particleBlue = 0.9f;
        }
    }

    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float cosYaw, float cosPitch, float sinYaw, float sinYawsinPitch, float cosYawsinPitch) {
        if (this.particleAge <= 1) {
            return;
        }
        GlStateManager.pushMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableLighting();
        GlStateManager.disableTexture2D();
        float[] v1 = CalcHelper.rotateXYZByYawPitch(-1.0f, -1.0f, -1.0f, this.shotYaw, this.shotPitch, this.scaleOut);
        float[] v2 = CalcHelper.rotateXYZByYawPitch(-1.0f, 1.0f, -1.0f, this.shotYaw, this.shotPitch, this.scaleOut);
        float[] v3 = CalcHelper.rotateXYZByYawPitch(1.0f, 1.0f, -1.0f, this.shotYaw, this.shotPitch, this.scaleOut);
        float[] v4 = CalcHelper.rotateXYZByYawPitch(1.0f, -1.0f, -1.0f, this.shotYaw, this.shotPitch, this.scaleOut);
        float[] v5 = CalcHelper.rotateXYZByYawPitch(-1.0f, -1.0f, 1.0f, this.shotYaw, this.shotPitch, this.scaleOut);
        float[] v6 = CalcHelper.rotateXYZByYawPitch(-1.0f, 1.0f, 1.0f, this.shotYaw, this.shotPitch, this.scaleOut);
        float[] v7 = CalcHelper.rotateXYZByYawPitch(1.0f, 1.0f, 1.0f, this.shotYaw, this.shotPitch, this.scaleOut);
        float[] v8 = CalcHelper.rotateXYZByYawPitch(1.0f, -1.0f, 1.0f, this.shotYaw, this.shotPitch, this.scaleOut);
        float[] t1 = CalcHelper.rotateXYZByYawPitch(-1.0f, -1.0f, -1.0f, this.shotYaw, this.shotPitch, this.scaleIn);
        float[] t2 = CalcHelper.rotateXYZByYawPitch(-1.0f, 1.0f, -1.0f, this.shotYaw, this.shotPitch, this.scaleIn);
        float[] t3 = CalcHelper.rotateXYZByYawPitch(1.0f, 1.0f, -1.0f, this.shotYaw, this.shotPitch, this.scaleIn);
        float[] t4 = CalcHelper.rotateXYZByYawPitch(1.0f, -1.0f, -1.0f, this.shotYaw, this.shotPitch, this.scaleIn);
        float[] t5 = CalcHelper.rotateXYZByYawPitch(-1.0f, -1.0f, 1.0f, this.shotYaw, this.shotPitch, this.scaleIn);
        float[] t6 = CalcHelper.rotateXYZByYawPitch(-1.0f, 1.0f, 1.0f, this.shotYaw, this.shotPitch, this.scaleIn);
        float[] t7 = CalcHelper.rotateXYZByYawPitch(1.0f, 1.0f, 1.0f, this.shotYaw, this.shotPitch, this.scaleIn);
        float[] t8 = CalcHelper.rotateXYZByYawPitch(1.0f, -1.0f, 1.0f, this.shotYaw, this.shotPitch, this.scaleIn);
        double hx = this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX;
        double hy = this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY;
        double hz = this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ;
        this.vt[0][0] = hx + v1[0];
        this.vt[0][1] = hy + v1[1];
        this.vt[0][2] = hz + v1[2];
        this.vt[1][0] = hx + v2[0];
        this.vt[1][1] = hy + v2[1];
        this.vt[1][2] = hz + v2[2];
        this.vt[2][0] = hx + v3[0];
        this.vt[2][1] = hy + v3[1];
        this.vt[2][2] = hz + v3[2];
        this.vt[3][0] = hx + v4[0];
        this.vt[3][1] = hy + v4[1];
        this.vt[3][2] = hz + v4[2];
        this.vt[4][0] = hx + v5[0];
        this.vt[4][1] = hy + v5[1];
        this.vt[4][2] = hz + v5[2];
        this.vt[5][0] = hx + v6[0];
        this.vt[5][1] = hy + v6[1];
        this.vt[5][2] = hz + v6[2];
        this.vt[6][0] = hx + v7[0];
        this.vt[6][1] = hy + v7[1];
        this.vt[6][2] = hz + v7[2];
        this.vt[7][0] = hx + v8[0];
        this.vt[7][1] = hy + v8[1];
        this.vt[7][2] = hz + v8[2];
        this.vt2[0][0] = hx + t1[0];
        this.vt2[0][1] = hy + t1[1];
        this.vt2[0][2] = hz + t1[2];
        this.vt2[1][0] = hx + t2[0];
        this.vt2[1][1] = hy + t2[1];
        this.vt2[1][2] = hz + t2[2];
        this.vt2[2][0] = hx + t3[0];
        this.vt2[2][1] = hy + t3[1];
        this.vt2[2][2] = hz + t3[2];
        this.vt2[3][0] = hx + t4[0];
        this.vt2[3][1] = hy + t4[1];
        this.vt2[3][2] = hz + t4[2];
        this.vt2[4][0] = hx + t5[0];
        this.vt2[4][1] = hy + t5[1];
        this.vt2[4][2] = hz + t5[2];
        this.vt2[5][0] = hx + t6[0];
        this.vt2[5][1] = hy + t6[1];
        this.vt2[5][2] = hz + t6[2];
        this.vt2[6][0] = hx + t7[0];
        this.vt2[6][1] = hy + t7[1];
        this.vt2[6][2] = hz + t7[2];
        this.vt2[7][0] = hx + t8[0];
        this.vt2[7][1] = hy + t8[1];
        this.vt2[7][2] = hz + t8[2];
        render.begin(7, DefaultVertexFormats.POSITION_COLOR);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        render.pos(this.vt2[7][0], this.vt2[7][1], this.vt2[7][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[6][0], this.vt2[6][1], this.vt2[6][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[5][0], this.vt2[5][1], this.vt2[5][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[4][0], this.vt2[4][1], this.vt2[4][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[3][0], this.vt2[3][1], this.vt2[3][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[2][0], this.vt2[2][1], this.vt2[2][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[6][0], this.vt2[6][1], this.vt2[6][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[7][0], this.vt2[7][1], this.vt2[7][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[0][0], this.vt2[0][1], this.vt2[0][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[1][0], this.vt2[1][1], this.vt2[1][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[2][0], this.vt2[2][1], this.vt2[2][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[3][0], this.vt2[3][1], this.vt2[3][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[4][0], this.vt2[4][1], this.vt2[4][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[5][0], this.vt2[5][1], this.vt2[5][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[1][0], this.vt2[1][1], this.vt2[1][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[0][0], this.vt2[0][1], this.vt2[0][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[2][0], this.vt2[2][1], this.vt2[2][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[1][0], this.vt2[1][1], this.vt2[1][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[5][0], this.vt2[5][1], this.vt2[5][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[6][0], this.vt2[6][1], this.vt2[6][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[3][0], this.vt2[3][1], this.vt2[3][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[7][0], this.vt2[7][1], this.vt2[7][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[4][0], this.vt2[4][1], this.vt2[4][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[0][0], this.vt2[0][1], this.vt2[0][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt[7][0], this.vt[7][1], this.vt[7][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[6][0], this.vt[6][1], this.vt[6][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[5][0], this.vt[5][1], this.vt[5][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[4][0], this.vt[4][1], this.vt[4][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[3][0], this.vt[3][1], this.vt[3][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[2][0], this.vt[2][1], this.vt[2][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[6][0], this.vt[6][1], this.vt[6][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[7][0], this.vt[7][1], this.vt[7][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[0][0], this.vt[0][1], this.vt[0][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[1][0], this.vt[1][1], this.vt[1][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[2][0], this.vt[2][1], this.vt[2][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[3][0], this.vt[3][1], this.vt[3][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[4][0], this.vt[4][1], this.vt[4][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[5][0], this.vt[5][1], this.vt[5][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[1][0], this.vt[1][1], this.vt[1][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[0][0], this.vt[0][1], this.vt[0][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[2][0], this.vt[2][1], this.vt[2][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[1][0], this.vt[1][1], this.vt[1][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[5][0], this.vt[5][1], this.vt[5][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[6][0], this.vt[6][1], this.vt[6][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[3][0], this.vt[3][1], this.vt[3][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[7][0], this.vt[7][1], this.vt[7][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[4][0], this.vt[4][1], this.vt[4][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[0][0], this.vt[0][1], this.vt[0][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(false);
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

    public int getFXLayer() {
        return 3;
    }

    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.host == null) {
            this.setExpired();
        } else {
            if(this.particleType == 1){
                float[] lookDeg = CalcHelper.getLookDegree(this.par1, this.par2, this.par3, false);
                float[] posOffset = CalcHelper.rotateXYZByYawPitch(0.0f, 0.0f, this.host.width * 2.0f, lookDeg[0], lookDeg[1], 1.0f);
                this.posX = this.host.posX + posOffset[0];
                this.posY = this.host.posY + this.host.height * 0.6;
                this.posZ = this.host.posZ + posOffset[2];
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.alphaIn = this.particleAge > 20 ? 1.0f + (20 - this.particleAge) * 0.1f : (this.particleAge < 4 ? 0.2f + this.particleAge * 0.2f : 0.95f);
                this.alphaOut = 0.0f;
                if (this.particleAge > 20) {
                    this.scaleOut = this.particleScale * (1.0f + (this.particleAge - 20));
                    this.scaleIn = this.particleScale * 0.4f * (1.0f - (this.particleAge - 20) * 0.1f);
                } else if (this.particleAge < 8) {
                    this.scaleOut = this.particleScale * 0.3f * (this.particleAge * 0.3f);
                    this.scaleIn = this.particleScale * 0.4f * (this.particleAge * 0.125f);
                } else {
                    this.scaleOut = this.particleScale;
                    this.scaleIn = this.particleScale * 0.4f;
                }
                this.scaleOut += this.rand.nextFloat() * 0.04f - 0.01f;
                this.scaleIn += this.rand.nextFloat() * 0.04f - 0.005f;
            } else {
                float[] posOffset = CalcHelper.rotateXZByAxis(this.host.width * 2.0f, 0.0f, this.host.renderYawOffset % 360.0f * ((float)Math.PI / 180), 1.0f);
                this.posX = this.host.posX + posOffset[1];
                this.posY = this.host.posY + this.host.height * 0.6;
                this.posZ = this.host.posZ + posOffset[0];
                this.shotYaw = this.host.renderYawOffset % 360.0f * ((float)Math.PI / 180);
                this.shotPitch = this.host.rotationPitch % 360.0f * ((float)Math.PI / 180);
                this.alphaIn = this.particleAge < 32 ? this.rand.nextFloat() * 0.5f + 0.75f : (this.particleMaxAge - this.particleAge) * 0.1f + 0.2f;
                this.alphaOut = this.alphaIn * 0.25f;
                this.scaleOut = this.particleScale * this.particleAge * ((MathHelper.cos(this.particleAge) + 1.0f) * 0.005f + 0.015f);
                this.scaleIn = this.scaleOut * 0.75f;
                this.scaleOut += this.rand.nextFloat() * 0.04f - 0.01f;
                this.scaleIn += this.rand.nextFloat() * 0.04f - 0.005f;
            }
        }
        if (this.particleAge++ > this.particleMaxAge) {
            this.setExpired();
        }
    }
}
