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
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ParticleLaserNoTexture
extends Particle {
    private final int particleType;
    private float shotYaw;
    private float shotPitch;
    private float scaleOut;
    private float scaleIn;
    private float alphaOut;
    private float alphaIn;
    private double tarX;
    private double tarY;
    private double tarZ;
    private final double par1;
    private final double par2;
    private final double par3;
    private final double[][] vt;
    private final double[][] vt2;
    private final EntityLivingBase host;
    private final Entity target;

    public ParticleLaserNoTexture(World world, EntityLivingBase host, Entity target, double par1, double par2, double par3, float scale, int type) {
        super(world, host.posX, host.posY, host.posZ);
        this.setSize(0.0f, 0.0f);
        this.host = host;
        this.target = target;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleScale = scale;
        this.particleType = type;
        this.tarX = target.posX;
        this.tarY = target.posY + target.height * 0.75;
        this.tarZ = target.posZ;
        this.par1 = par1;
        this.par2 = par2;
        this.par3 = par3;
        this.vt = new double[8][3];
        this.vt2 = new double[8][3];
        this.canCollide = false;
        switch (type) {
            case 1: {
                this.particleMaxAge = 30;
                this.particleRed = 1.0f;
                this.particleGreen = 0.8f;
                this.particleBlue = 0.9f;
                break;
            }
            case 2: {
                float[] lookDeg = CalcHelper.getLookDegree(this.tarX - this.posX, this.tarY - this.posY, this.tarZ - this.posZ, false);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.particleMaxAge = 8;
                this.particleRed = 1.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.scaleOut = this.particleScale * 0.5f;
                this.scaleIn = this.particleScale * 0.125f;
                this.alphaOut = 0.1f;
                this.alphaIn = 0.2f;
                break;
            }
            case 4: {
                float[] lookDeg = CalcHelper.getLookDegree(this.tarX - this.posX, this.tarY - this.posY, this.tarZ - this.posZ, false);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.tarX = target.posX;
                this.tarY = target.posY + target.height * 0.5;
                this.tarZ = target.posZ;
                this.particleMaxAge = 12;
                this.particleRed = 1.0f;
                this.particleGreen = 0.75f;
                this.particleBlue = 1.0f;
                this.scaleOut = this.particleScale * 0.5f;
                this.scaleIn = this.particleScale * 0.125f;
                this.alphaOut = 0.1f;
                this.alphaIn = 0.2f;
                break;
            }
            case 5: {
                float[] lookDeg = CalcHelper.getLookDegree(this.tarX - this.posX, this.tarY - this.posY, this.tarZ - this.posZ, false);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.tarX = target.posX;
                this.tarY = target.posY + 0.2;
                this.tarZ = target.posZ;
                this.particleMaxAge = 64;
                this.particleRed = 1.0f;
                this.particleGreen = 0.6f;
                this.particleBlue = 1.0f;
                this.scaleOut = this.particleScale * 0.5f;
                this.scaleIn = this.particleScale * 0.125f;
                this.alphaOut = 0.6f;
                this.alphaIn = 0.8f;
                break;
            }
            case 6: {
                float[] lookDeg = CalcHelper.getLookDegree(this.tarX - this.posX, this.tarY + target.height * 0.5 - (this.posY + this.par1), this.tarZ - this.posZ, false);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.tarX = target.posX;
                this.tarY = target.posY + target.height * 0.5;
                this.tarZ = target.posZ;
                this.particleMaxAge = 16;
                this.particleRed = 0.5f;
                this.particleGreen = 0.0f;
                this.particleBlue = 1.0f;
                this.scaleOut = (float)this.par2;
                this.scaleIn = (float)this.par3;
                break;
            }
            default: {
                float[] lookDeg = CalcHelper.getLookDegree(this.tarX - this.posX, this.tarY - this.posY, this.tarZ - this.posZ, false);
                float[] posOffset = CalcHelper.rotateXYZByYawPitch((float)par1, 0.0f, 0.78f, lookDeg[0], lookDeg[1], 1.0f);
                this.shotYaw = lookDeg[0];
                this.shotPitch = lookDeg[1];
                this.posX += posOffset[0];
                this.posY += par2 + posOffset[1];
                this.posZ += posOffset[2];
                this.particleMaxAge = 8;
                this.particleRed = 1.0f;
                this.particleGreen = 0.0f;
                this.particleBlue = 0.0f;
                this.scaleOut = this.particleScale * 0.5f;
                this.scaleIn = this.particleScale * 0.125f;
                this.alphaOut = 0.1f;
                this.alphaIn = 0.2f;
            }
        }
    }

    public ParticleLaserNoTexture(World world, EntityLivingBase host, double tarX, double tarY, double tarZ, float scale, int type) {
        super(world, host.posX, host.posY, host.posZ);
        this.setSize(0.0f, 0.0f);
        this.host = host;
        this.target = host;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleScale = scale;
        this.particleType = type;
        this.tarX = tarX;
        this.tarY = tarY;
        this.tarZ = tarZ;
        this.par1 = 0.0;
        this.par2 = 0.0;
        this.par3 = 0.0;
        this.vt = new double[8][3];
        this.vt2 = new double[8][3];
        this.canCollide = false;
        if(type == 3){
            float[] lookDeg = CalcHelper.getLookDegree(tarX - this.posX, tarY - this.posY, tarZ - this.posZ, false);
            this.shotYaw = lookDeg[0];
            this.shotPitch = lookDeg[1];
            this.particleMaxAge = 8;
            this.particleRed = 1.0f;
            this.particleGreen = 1.0f;
            this.particleBlue = 1.0f;
            this.scaleOut = this.particleScale * 0.5f;
            this.scaleIn = this.particleScale * 0.125f;
            this.alphaOut = 0.1f;
            this.alphaIn = 0.2f;
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
        float[] v1 = CalcHelper.rotateXYZByYawPitch(1.0f, -1.0f, -1.0f, this.shotYaw, this.shotPitch, this.scaleOut);
        float[] v2 = CalcHelper.rotateXYZByYawPitch(1.0f, 1.0f, -1.0f, this.shotYaw, this.shotPitch, this.scaleOut);
        float[] v3 = CalcHelper.rotateXYZByYawPitch(-1.0f, 1.0f, -1.0f, this.shotYaw, this.shotPitch, this.scaleOut);
        float[] v4 = CalcHelper.rotateXYZByYawPitch(-1.0f, -1.0f, -1.0f, this.shotYaw, this.shotPitch, this.scaleOut);
        float[] v5 = CalcHelper.rotateXYZByYawPitch(1.0f, -1.0f, 0.0f, this.shotYaw, this.shotPitch, this.scaleIn);
        float[] v6 = CalcHelper.rotateXYZByYawPitch(1.0f, 1.0f, 0.0f, this.shotYaw, this.shotPitch, this.scaleIn);
        float[] v7 = CalcHelper.rotateXYZByYawPitch(-1.0f, 1.0f, 0.0f, this.shotYaw, this.shotPitch, this.scaleIn);
        float[] v8 = CalcHelper.rotateXYZByYawPitch(-1.0f, -1.0f, 0.0f, this.shotYaw, this.shotPitch, this.scaleIn);
        double hx = this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX;
        double hy = this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY;
        double hz = this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ;
        double tx = this.tarX - interpPosX;
        double ty = this.tarY - interpPosY;
        double tz = this.tarZ - interpPosZ;
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
        this.vt[4][0] = tx + v1[0];
        this.vt[4][1] = ty + v1[1];
        this.vt[4][2] = tz + v1[2];
        this.vt[5][0] = tx + v2[0];
        this.vt[5][1] = ty + v2[1];
        this.vt[5][2] = tz + v2[2];
        this.vt[6][0] = tx + v3[0];
        this.vt[6][1] = ty + v3[1];
        this.vt[6][2] = tz + v3[2];
        this.vt[7][0] = tx + v4[0];
        this.vt[7][1] = ty + v4[1];
        this.vt[7][2] = tz + v4[2];
        this.vt2[0][0] = hx + v5[0];
        this.vt2[0][1] = hy + v5[1];
        this.vt2[0][2] = hz + v5[2];
        this.vt2[1][0] = hx + v6[0];
        this.vt2[1][1] = hy + v6[1];
        this.vt2[1][2] = hz + v6[2];
        this.vt2[2][0] = hx + v7[0];
        this.vt2[2][1] = hy + v7[1];
        this.vt2[2][2] = hz + v7[2];
        this.vt2[3][0] = hx + v8[0];
        this.vt2[3][1] = hy + v8[1];
        this.vt2[3][2] = hz + v8[2];
        this.vt2[4][0] = tx + v5[0];
        this.vt2[4][1] = ty + v5[1];
        this.vt2[4][2] = tz + v5[2];
        this.vt2[5][0] = tx + v6[0];
        this.vt2[5][1] = ty + v6[1];
        this.vt2[5][2] = tz + v6[2];
        this.vt2[6][0] = tx + v7[0];
        this.vt2[6][1] = ty + v7[1];
        this.vt2[6][2] = tz + v7[2];
        this.vt2[7][0] = tx + v8[0];
        this.vt2[7][1] = ty + v8[1];
        this.vt2[7][2] = tz + v8[2];
        render.begin(7, DefaultVertexFormats.POSITION_COLOR);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        render.pos(this.vt2[3][0], this.vt2[3][1], this.vt2[3][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[2][0], this.vt2[2][1], this.vt2[2][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[1][0], this.vt2[1][1], this.vt2[1][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[0][0], this.vt2[0][1], this.vt2[0][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[0][0], this.vt2[0][1], this.vt2[0][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[1][0], this.vt2[1][1], this.vt2[1][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[5][0], this.vt2[5][1], this.vt2[5][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[4][0], this.vt2[4][1], this.vt2[4][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[4][0], this.vt2[4][1], this.vt2[4][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[5][0], this.vt2[5][1], this.vt2[5][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[6][0], this.vt2[6][1], this.vt2[6][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[7][0], this.vt2[7][1], this.vt2[7][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[7][0], this.vt2[7][1], this.vt2[7][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[6][0], this.vt2[6][1], this.vt2[6][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[2][0], this.vt2[2][1], this.vt2[2][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[3][0], this.vt2[3][1], this.vt2[3][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[1][0], this.vt2[1][1], this.vt2[1][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[2][0], this.vt2[2][1], this.vt2[2][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[6][0], this.vt2[6][1], this.vt2[6][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[5][0], this.vt2[5][1], this.vt2[5][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[3][0], this.vt2[3][1], this.vt2[3][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[0][0], this.vt2[0][1], this.vt2[0][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[4][0], this.vt2[4][1], this.vt2[4][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt2[7][0], this.vt2[7][1], this.vt2[7][2]).color(1.0f, 1.0f, 1.0f, this.alphaIn).endVertex();
        render.pos(this.vt[3][0], this.vt[3][1], this.vt[3][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[2][0], this.vt[2][1], this.vt[2][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[1][0], this.vt[1][1], this.vt[1][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[0][0], this.vt[0][1], this.vt[0][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[0][0], this.vt[0][1], this.vt[0][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[1][0], this.vt[1][1], this.vt[1][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[5][0], this.vt[5][1], this.vt[5][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[4][0], this.vt[4][1], this.vt[4][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[4][0], this.vt[4][1], this.vt[4][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[5][0], this.vt[5][1], this.vt[5][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[6][0], this.vt[6][1], this.vt[6][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[7][0], this.vt[7][1], this.vt[7][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[7][0], this.vt[7][1], this.vt[7][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[6][0], this.vt[6][1], this.vt[6][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[2][0], this.vt[2][1], this.vt[2][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[3][0], this.vt[3][1], this.vt[3][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[1][0], this.vt[1][1], this.vt[1][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[2][0], this.vt[2][1], this.vt[2][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[6][0], this.vt[6][1], this.vt[6][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[5][0], this.vt[5][1], this.vt[5][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[3][0], this.vt[3][1], this.vt[3][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[0][0], this.vt[0][1], this.vt[0][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[4][0], this.vt[4][1], this.vt[4][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
        render.pos(this.vt[7][0], this.vt[7][1], this.vt[7][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.alphaOut).endVertex();
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
        if (this.host == null || this.target == null) {
            this.setExpired();
        } else {
            switch (this.particleType) {
                case 1: {
                    float[] lookDeg = CalcHelper.getLookDegree(this.par1, this.par2, this.par3, false);
                    float[] posOffset = CalcHelper.rotateXYZByYawPitch(0.0f, 0.0f, this.host.width * 2.0f, lookDeg[0], lookDeg[1], 1.0f);
                    this.posX = this.host.posX + posOffset[0];
                    this.posY = this.host.posY + this.host.height * 0.6;
                    this.posZ = this.host.posZ + posOffset[2];
                    this.shotYaw = lookDeg[0];
                    this.shotPitch = lookDeg[1];
                    this.tarX = this.target.posX;
                    this.tarY = this.target.posY + (this.target.height * 0.5f);
                    this.tarZ = this.target.posZ;
                    if (this.particleAge > 20) {
                        this.alphaIn = 1.0f + (20 - this.particleAge) * 0.1f;
                        this.alphaOut = this.alphaIn * 0.25f;
                    } else if (this.particleAge < 4) {
                        this.alphaIn = 0.2f + this.particleAge * 0.2f;
                        this.alphaOut = this.alphaIn * 0.25f;
                    } else {
                        this.alphaIn = 1.0f;
                        this.alphaOut = 0.1f + this.rand.nextFloat() * 0.25f;
                    }
                    if (this.particleAge > 20) {
                        this.scaleOut = this.particleScale * (1.0f + (this.particleAge - 20));
                        this.scaleIn = this.particleScale * 0.35f * (1.0f - (this.particleAge - 20) * 0.1f);
                    } else if (this.particleAge < 8) {
                        this.scaleOut = this.particleScale * 0.3f * (this.particleAge * 0.3f);
                        this.scaleIn = this.particleScale * 0.35f * (this.particleAge * 0.125f);
                    } else {
                        this.scaleOut = this.particleScale;
                        this.scaleIn = this.particleScale * 0.35f;
                    }
                    this.scaleOut += this.rand.nextFloat() * 0.2f - 0.05f;
                    this.scaleIn += this.rand.nextFloat() * 0.08f - 0.04f;
                    break;
                }
                case 2: {
                    this.tarX = this.target.posX;
                    this.tarY = this.target.posY;
                    this.tarZ = this.target.posZ;
                }
                case 3: {
                    this.posX = this.host.posX;
                    this.posY = this.host.posY;
                    this.posZ = this.host.posZ;
                    float[] lookDeg = CalcHelper.getLookDegree(this.tarX - this.posX, this.tarY - this.posY, this.tarZ - this.posZ, false);
                    this.shotYaw = lookDeg[0];
                    this.shotPitch = lookDeg[1];
                    if (this.particleAge > 4) {
                        this.alphaIn = 1.0f + (4 - this.particleAge) * 0.2f;
                        this.alphaOut = this.alphaIn * 0.5f;
                        break;
                    }
                    this.alphaIn = 0.2f + this.particleAge * 0.2f;
                    this.alphaOut = this.alphaIn * 0.5f;
                    break;
                }
                case 4: {
                    this.tarX = this.target.posX;
                    this.tarY = this.target.posY + this.target.height * 0.5;
                    this.tarZ = this.target.posZ;
                    this.posX = this.host.posX;
                    this.posY = this.host.posY;
                    this.posZ = this.host.posZ;
                    float[] lookDeg = CalcHelper.getLookDegree(this.tarX - this.posX, this.tarY - this.posY, this.tarZ - this.posZ, false);
                    this.shotYaw = lookDeg[0];
                    this.shotPitch = lookDeg[1];
                    if (this.particleAge > 4) {
                        this.alphaIn = 1.0f + (4 - this.particleAge) * 0.2f;
                        this.alphaOut = this.alphaIn * 0.5f;
                        break;
                    }
                    this.alphaIn = 0.2f + this.particleAge * 0.2f;
                    this.alphaOut = this.alphaIn * 0.5f;
                    break;
                }
                case 5: {
                    this.tarX = this.target.posX;
                    this.tarY = this.target.posY + 0.2;
                    this.tarZ = this.target.posZ;
                    this.posX = this.host.posX;
                    this.posY = this.host.posY + 0.65;
                    this.posZ = this.host.posZ;
                    float[] lookDeg = CalcHelper.getLookDegree(this.tarX - this.posX, this.tarY - this.posY, this.tarZ - this.posZ, false);
                    this.shotYaw = lookDeg[0];
                    this.shotPitch = lookDeg[1];
                    if (this.particleAge <= 56) break;
                    this.alphaIn *= 0.6f;
                    this.alphaOut = this.alphaIn * 0.5f;
                    break;
                }
                case 6: {
                    float[] lookDeg = CalcHelper.getLookDegree(this.tarX - this.posX, this.tarY + this.target.height * 0.5 - (this.posY + this.par1), this.tarZ - this.posZ, false);
                    this.shotYaw = lookDeg[0];
                    this.shotPitch = lookDeg[1];
                    this.posX = this.host.posX;
                    this.posY = this.host.posY + this.par1;
                    this.posZ = this.host.posZ;
                    this.tarX = this.target.posX;
                    this.tarY = this.target.posY + this.target.height * 0.5;
                    this.tarZ = this.target.posZ;
                    if (this.particleAge < 8) {
                        this.scaleIn = (float)this.par3 * (1.0f + 0.6f * this.particleAge);
                        this.alphaIn = 0.2f + this.particleAge * 0.1f;
                        this.alphaOut = this.alphaIn * 0.25f;
                        break;
                    }
                    if (this.particleAge > 10) {
                        this.scaleIn *= 0.75f;
                        this.alphaIn = 1.0f + (10 - this.particleAge) * 0.15f;
                        this.alphaOut = this.alphaIn * 0.25f;
                        break;
                    }
                    this.alphaIn = 1.0f;
                    this.alphaOut = 0.25f;
                    break;
                }
                default: {
                    this.host.renderYawOffset = this.shotYaw * 57.29578f;
                    float[] lookDeg = CalcHelper.getLookDegree(this.tarX - this.posX, this.tarY - this.posY, this.tarZ - this.posZ, false);
                    float[] posOffset = CalcHelper.rotateXYZByYawPitch((float)this.par1, 0.0f, 0.78f, lookDeg[0], lookDeg[1], 1.0f);
                    this.shotYaw = lookDeg[0];
                    this.shotPitch = lookDeg[1];
                    this.posX = this.host.posX + posOffset[0];
                    this.posY = this.host.posY + this.par2 + posOffset[1];
                    this.posZ = this.host.posZ + posOffset[2];
                    this.tarX = this.target.posX;
                    this.tarY = this.target.posY + this.target.height * 0.75;
                    this.tarZ = this.target.posZ;
                    if (this.particleAge > 4) {
                        this.alphaIn = 1.0f + (4 - this.particleAge) * 0.2f;
                        this.alphaOut = this.alphaIn * 0.5f;
                        break;
                    }
                    this.alphaIn = 0.2f + this.particleAge * 0.2f;
                    this.alphaOut = this.alphaIn * 0.5f;
                }
            }
        }
        if (this.particleAge++ > this.particleMaxAge) {
            this.setExpired();
        }
    }
}
