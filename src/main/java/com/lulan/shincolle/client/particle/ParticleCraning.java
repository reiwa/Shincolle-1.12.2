package com.lulan.shincolle.client.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ParticleCraning
extends Particle {
    private final float lenMax;
    private float len;
    private final double[][] vt1;
    private final double[][] vt2;

    public ParticleCraning(World world, double x, double y, double z, double lengthMax, double scale) {
        super(world, x, y, z);
        this.setSize(0.0f, 0.0f);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.lenMax = (float)lengthMax;
        this.particleScale = (float)scale;
        this.vt1 = new double[8][3];
        this.vt2 = new double[8][3];
        this.canCollide = false;
        this.particleMaxAge = 127;
        this.particleRed = 0.6f;
        this.particleGreen = 0.0f;
        this.particleBlue = 0.0f;
        this.len = 0.0f;
    }

    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float cosYaw, float cosPitch, float sinYaw, float sinYawsinPitch, float cosYawsinPitch) {
        GlStateManager.pushMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableLighting();
        GlStateManager.disableTexture2D();
        float sizeHead = this.particleScale;
        float sizeChain = this.particleScale * 0.25f;
        float[] v1 = new float[]{sizeHead * 0.75f, -sizeHead, -sizeHead};
        float[] v2 = new float[]{sizeHead * 0.75f, sizeHead, -sizeHead};
        float[] v3 = new float[]{-sizeHead * 0.75f, sizeHead, -sizeHead};
        float[] v4 = new float[]{-sizeHead * 0.75f, -sizeHead, -sizeHead};
        float[] v5 = new float[]{sizeChain, -sizeChain * 1.5f, -sizeChain};
        float[] v6 = new float[]{sizeChain, sizeChain * 1.5f, -sizeChain};
        float[] v7 = new float[]{-sizeChain, sizeChain * 1.5f, -sizeChain};
        float[] v8 = new float[]{-sizeChain, -sizeChain * 1.5f, -sizeChain};
        double hx = this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX;
        double hy = this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY - this.len + this.particleScale * 5.0;
        double hz = this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ + this.particleScale * 0.5;
        double z1 = this.particleScale * 0.8;
        double z2 = this.particleScale * 0.25;
        double y1 =  this.particleScale;
        this.vt1[0][0] = hx + v1[0];
        this.vt1[0][1] = hy + v1[1];
        this.vt1[0][2] = hz + v1[2];
        this.vt1[1][0] = hx + v2[0];
        this.vt1[1][1] = hy + v2[1];
        this.vt1[1][2] = hz + v2[2];
        this.vt1[2][0] = hx + v3[0];
        this.vt1[2][1] = hy + v3[1];
        this.vt1[2][2] = hz + v3[2];
        this.vt1[3][0] = hx + v4[0];
        this.vt1[3][1] = hy + v4[1];
        this.vt1[3][2] = hz + v4[2];
        this.vt1[4][0] = hx + v1[0];
        this.vt1[4][1] = hy + v1[1];
        this.vt1[4][2] = hz + v1[2] + z1;
        this.vt1[5][0] = hx + v2[0];
        this.vt1[5][1] = hy + v2[1];
        this.vt1[5][2] = hz + v2[2] + z1;
        this.vt1[6][0] = hx + v3[0];
        this.vt1[6][1] = hy + v3[1];
        this.vt1[6][2] = hz + v3[2] + z1;
        this.vt1[7][0] = hx + v4[0];
        this.vt1[7][1] = hy + v4[1];
        this.vt1[7][2] = hz + v4[2] + z1;
        this.vt2[0][0] = hx + v5[0];
        this.vt2[0][1] = hy + v5[1] + y1;
        this.vt2[0][2] = (hz -= this.particleScale * 0.47) + v5[2];
        this.vt2[1][0] = hx + v6[0];
        this.vt2[1][1] = hy + v6[1] + y1;
        this.vt2[1][2] = hz + v6[2];
        this.vt2[2][0] = hx + v7[0];
        this.vt2[2][1] = hy + v7[1] + y1;
        this.vt2[2][2] = hz + v7[2];
        this.vt2[3][0] = hx + v8[0];
        this.vt2[3][1] = hy + v8[1] + y1;
        this.vt2[3][2] = hz + v8[2];
        this.vt2[4][0] = hx + v5[0];
        this.vt2[4][1] = hy + v5[1] + y1;
        this.vt2[4][2] = hz + v5[2] + z2;
        this.vt2[5][0] = hx + v6[0];
        this.vt2[5][1] = hy + v6[1] + y1;
        this.vt2[5][2] = hz + v6[2] + z2;
        this.vt2[6][0] = hx + v7[0];
        this.vt2[6][1] = hy + v7[1] + y1;
        this.vt2[6][2] = hz + v7[2] + z2;
        this.vt2[7][0] = hx + v8[0];
        this.vt2[7][1] = hy + v8[1] + y1;
        this.vt2[7][2] = hz + v8[2] + z2;
        render.begin(7, DefaultVertexFormats.POSITION_COLOR);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 30.0f, 30.0f);
        float clen = 0.0f;
        while (clen < this.len) {
            float ny = (float)hy + clen;
            this.vt2[0][0] = hx + v5[0];
            this.vt2[0][1] = (ny + v5[1]) + y1;
            this.vt2[0][2] = hz + v5[2];
            this.vt2[1][0] = hx + v6[0];
            this.vt2[1][1] = (ny + v6[1]) + y1;
            this.vt2[1][2] = hz + v6[2];
            this.vt2[2][0] = hx + v7[0];
            this.vt2[2][1] = (ny + v7[1]) + y1;
            this.vt2[2][2] = hz + v7[2];
            this.vt2[3][0] = hx + v8[0];
            this.vt2[3][1] = (ny + v8[1]) + y1;
            this.vt2[3][2] = hz + v8[2];
            this.vt2[4][0] = hx + v5[0];
            this.vt2[4][1] = (ny + v5[1]) + y1;
            this.vt2[4][2] = hz + v5[2] + z2;
            this.vt2[5][0] = hx + v6[0];
            this.vt2[5][1] = (ny + v6[1]) + y1;
            this.vt2[5][2] = hz + v6[2] + z2;
            this.vt2[6][0] = hx + v7[0];
            this.vt2[6][1] = (ny + v7[1]) + y1;
            this.vt2[6][2] = hz + v7[2] + z2;
            this.vt2[7][0] = hx + v8[0];
            this.vt2[7][1] = (ny + v8[1]) + y1;
            this.vt2[7][2] = hz + v8[2] + z2;
            render.pos(this.vt2[3][0], this.vt2[3][1], this.vt2[3][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[2][0], this.vt2[2][1], this.vt2[2][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[1][0], this.vt2[1][1], this.vt2[1][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[0][0], this.vt2[0][1], this.vt2[0][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[0][0], this.vt2[0][1], this.vt2[0][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[1][0], this.vt2[1][1], this.vt2[1][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[5][0], this.vt2[5][1], this.vt2[5][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[4][0], this.vt2[4][1], this.vt2[4][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[4][0], this.vt2[4][1], this.vt2[4][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[5][0], this.vt2[5][1], this.vt2[5][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[6][0], this.vt2[6][1], this.vt2[6][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[7][0], this.vt2[7][1], this.vt2[7][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[7][0], this.vt2[7][1], this.vt2[7][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[6][0], this.vt2[6][1], this.vt2[6][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[2][0], this.vt2[2][1], this.vt2[2][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[3][0], this.vt2[3][1], this.vt2[3][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[1][0], this.vt2[1][1], this.vt2[1][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[2][0], this.vt2[2][1], this.vt2[2][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[6][0], this.vt2[6][1], this.vt2[6][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[5][0], this.vt2[5][1], this.vt2[5][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[3][0], this.vt2[3][1], this.vt2[3][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[0][0], this.vt2[0][1], this.vt2[0][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[4][0], this.vt2[4][1], this.vt2[4][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            render.pos(this.vt2[7][0], this.vt2[7][1], this.vt2[7][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
            clen = (float)((double)clen + (double) this.particleScale);
        }
        render.pos(this.vt1[3][0], this.vt1[3][1], this.vt1[3][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[2][0], this.vt1[2][1], this.vt1[2][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[1][0], this.vt1[1][1], this.vt1[1][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[0][0], this.vt1[0][1], this.vt1[0][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[0][0], this.vt1[0][1], this.vt1[0][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[1][0], this.vt1[1][1], this.vt1[1][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[5][0], this.vt1[5][1], this.vt1[5][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[4][0], this.vt1[4][1], this.vt1[4][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[4][0], this.vt1[4][1], this.vt1[4][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[5][0], this.vt1[5][1], this.vt1[5][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[6][0], this.vt1[6][1], this.vt1[6][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[7][0], this.vt1[7][1], this.vt1[7][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[7][0], this.vt1[7][1], this.vt1[7][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[6][0], this.vt1[6][1], this.vt1[6][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[2][0], this.vt1[2][1], this.vt1[2][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[3][0], this.vt1[3][1], this.vt1[3][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[1][0], this.vt1[1][1], this.vt1[1][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[2][0], this.vt1[2][1], this.vt1[2][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[6][0], this.vt1[6][1], this.vt1[6][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[5][0], this.vt1[5][1], this.vt1[5][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[3][0], this.vt1[3][1], this.vt1[3][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[0][0], this.vt1[0][1], this.vt1[0][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[4][0], this.vt1[4][1], this.vt1[4][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
        render.pos(this.vt1[7][0], this.vt1[7][1], this.vt1[7][2]).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).endVertex();
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
        float half = this.particleMaxAge * 0.45f;
        float half2 = this.particleMaxAge - half;
        if (this.particleAge <= half) {
            this.len = this.particleAge / half * this.lenMax;
        } else if (this.particleAge <= half2) {
            this.len = this.lenMax;
        } else {
            this.len = (this.particleMaxAge - this.particleAge) / half * this.lenMax;
        }
        if (this.particleAge++ > this.particleMaxAge) {
            this.setExpired();
        }
    }
}
