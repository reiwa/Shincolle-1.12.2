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
public class ParticleStickyLightning
extends Particle {
    private final int particleType;
    private final Entity host;
    private final int numStem;
    private final double[][] prevShape;
    private final float scaleX;
    private final float scaleZ;
    private final float scaleY;
    private final float stemWidth;

    public ParticleStickyLightning(World world, Entity entity, float scale, int life, int type) {
        super(world, entity.posX, entity.posY, entity.posZ);
        this.setSize(0.0f, 0.0f);
        this.host = entity;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleScale = scale;
        this.particleType = type;
        this.canCollide = false;
        switch (type) {
            case 1: {
                this.particleRed = 1.0f;
                this.particleGreen = 0.5f;
                this.particleBlue = 0.7f;
                this.particleAlpha = 1.0f;
                this.particleMaxAge = life;
                this.numStem = 4;
                this.scaleX = 0.5f + this.host.width * 0.5f;
                this.scaleY = 0.5f + this.host.width * 0.5f;
                this.scaleZ = 0.5f + this.host.width * 0.5f;
                this.stemWidth = 0.01f * this.host.width;
                this.posX = this.host.posX + (this.rand.nextFloat() * this.particleScale * 2.0f) - this.particleScale;
                this.posY = this.host.posY + this.host.height * 0.6;
                this.posZ = this.host.posZ + (this.rand.nextFloat() * this.particleScale * 2.0f) - this.particleScale;
                break;
            }
            case 2: {
                this.particleRed = 1.0f;
                this.particleGreen = 0.5f;
                this.particleBlue = 0.7f;
                this.particleAlpha = 1.0f;
                this.particleMaxAge = life;
                this.numStem = 12;
                this.scaleX = 0.25f;
                this.scaleY = 0.25f;
                this.scaleZ = 0.25f;
                this.stemWidth = 0.005f;
                float[] partPos = CalcHelper.rotateXZByAxis(1.0f, 0.0f, ((EntityLivingBase)this.host).renderYawOffset % 360.0f * ((float)Math.PI / 180), 1.0f);
                this.posX = this.host.posX + partPos[1];
                this.posY = this.host.posY + this.host.height * 0.8;
                this.posZ = this.host.posZ + partPos[0];
                break;
            }
            case 3: {
                this.particleRed = 1.0f;
                this.particleGreen = 0.5f;
                this.particleBlue = 0.7f;
                this.particleAlpha = 1.0f;
                this.particleMaxAge = life;
                this.numStem = 4;
                this.scaleX = 1.0f;
                this.scaleY = 1.0f;
                this.scaleZ = 1.0f;
                this.stemWidth = 0.025f;
                break;
            }
            case 4: {
                this.particleRed = 0.0f;
                this.particleGreen = 0.7f;
                this.particleBlue = 1.0f;
                this.particleAlpha = 1.0f;
                this.particleMaxAge = life;
                this.numStem = 12;
                this.scaleX = 0.75f;
                this.scaleY = 0.75f;
                this.scaleZ = 0.75f;
                this.stemWidth = 0.008f;
                this.posX = this.host.posX + (this.rand.nextFloat() * 0.25f) - 0.125;
                this.posY = this.host.posY + this.host.height * 0.5 + (this.rand.nextFloat() * 0.25f) - 0.125;
                this.posZ = this.host.posZ + (this.rand.nextFloat() * 0.25f) - 0.125;
                break;
            }
            case 5: {
                this.particleRed = 0.0f;
                this.particleGreen = 0.0f;
                this.particleBlue = 0.0f;
                this.particleAlpha = 0.0f;
                this.particleMaxAge = life;
                this.numStem = 4;
                this.scaleX = this.particleScale;
                this.scaleY = this.particleScale;
                this.scaleZ = this.particleScale;
                this.stemWidth = 0.1f;
                this.posX = this.host.posX + (this.rand.nextFloat() * 0.25f) - 0.125;
                this.posY = this.host.posY + this.host.height * 0.5 + (this.rand.nextFloat() * 0.25f) - 0.125;
                this.posZ = this.host.posZ + (this.rand.nextFloat() * 0.25f) - 0.125;
                break;
            }
            default: {
                this.particleRed = 1.0f;
                this.particleGreen = 0.5f;
                this.particleBlue = 0.7f;
                this.particleAlpha = 1.0f;
                this.particleMaxAge = life;
                this.numStem = 8;
                this.scaleX = 1.75f;
                this.scaleY = 1.75f;
                this.scaleZ = 1.75f;
                this.stemWidth = 0.006f;
                this.posX = this.host.posX + (this.rand.nextFloat() * 2.0f) - 1.0;
                this.posY = this.host.posY + this.host.height * 0.5 + (this.rand.nextFloat() * 2.0f) - 1.0;
                this.posZ = this.host.posZ + (this.rand.nextFloat() * 2.0f) - 1.0;
            }
        }
        this.prevShape = new double[this.numStem][6];
    }

    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float cosYaw, float cosPitch, float sinYaw, float sinYawsinPitch, float cosYawsinPitch) {
        int i;
        GlStateManager.pushMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableLighting();
        GlStateManager.disableTexture2D();
        float px = (float)(this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX);
        float py = (float)(this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY);
        float pz = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ);
        float offx;
        float offz;
        float offy;
        if (this.particleAge % 2 == 0) {
            for (i = 0; i < this.numStem; ++i) {
                offx = (this.rand.nextFloat() - 0.5f) * this.scaleX;
                offz = (this.rand.nextFloat() - 0.5f) * this.scaleZ;
                offy = (this.rand.nextFloat() - 0.5f) * this.scaleY;
                if (i == 0) {
                    this.prevShape[i][0] = px + offx;
                    this.prevShape[i][1] = py + offy;
                    this.prevShape[i][2] = pz + offz;
                    this.prevShape[i][3] = this.prevShape[i][0];
                    this.prevShape[i][4] = this.prevShape[i][1];
                    this.prevShape[i][5] = this.prevShape[i][2];
                    continue;
                }
                if (i == this.numStem - 1) {
                    this.prevShape[i][0] = this.prevShape[i - 1][0] + offx;
                    this.prevShape[i][1] = this.prevShape[i - 1][1] + offy;
                    this.prevShape[i][2] = this.prevShape[i - 1][2] + offz;
                    this.prevShape[i][3] = this.prevShape[i][0];
                    this.prevShape[i][4] = this.prevShape[i][1];
                    this.prevShape[i][5] = this.prevShape[i][2];
                    continue;
                }
                this.prevShape[i][0] = this.prevShape[i - 1][0] + offx;
                this.prevShape[i][1] = this.prevShape[i - 1][1] + offy;
                this.prevShape[i][2] = this.prevShape[i - 1][2] + offz;
                this.prevShape[i][3] = this.prevShape[i - 1][3] + offx + this.stemWidth;
                this.prevShape[i][4] = this.prevShape[i - 1][4] + offy + this.stemWidth;
                this.prevShape[i][5] = this.prevShape[i - 1][5] + offz + this.stemWidth;
            }
        }
        render.begin(8, DefaultVertexFormats.POSITION_COLOR);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        for (i = this.numStem - 1; i >= 0; --i) {
            render.pos(this.prevShape[i][0], this.prevShape[i][1], this.prevShape[i][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos(this.prevShape[i][3], this.prevShape[i][4], this.prevShape[i][5]).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        }
        Tessellator.getInstance().draw();
        render.begin(8, DefaultVertexFormats.POSITION_COLOR);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        for (i = this.numStem - 1; i >= 0; --i) {
            render.pos(this.prevShape[i][3], this.prevShape[i][4], this.prevShape[i][5]).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos(this.prevShape[i][0], this.prevShape[i][1], this.prevShape[i][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        }
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
        this.setPosition(this.posX, this.posY, this.posZ);
        if (this.particleAge++ > this.particleMaxAge) {
            this.setExpired();
        }
        if(this.particleType == 3){
            float[] partPos2 = CalcHelper.rotateXZByAxis(this.host.width * 2.0f, 0.0f, ((EntityLivingBase)this.host).renderYawOffset % 360.0f * ((float)Math.PI / 180), 1.0f);
            this.posX = this.host.posX + partPos2[1];
            this.posY = this.host.posY + this.host.height * 0.6;
            this.posZ = this.host.posZ + partPos2[0];
        }
        switch (this.particleType) {
            case 4: {
                if (this.particleMaxAge - this.particleAge < 6) {
                    this.particleAlpha = (this.particleMaxAge - this.particleAge) * 0.15f + 0.2f;
                }
                this.particleGreen = 0.6f + this.rand.nextFloat() * 0.6f;
                this.particleRed = this.particleGreen - 0.3f;
                break;
            }
            case 5: {
                this.particleAlpha = this.particleMaxAge - this.particleAge < 10 ? (this.particleMaxAge - this.particleAge) * 0.015f + 0.018f : 0.35f;
                this.particleGreen = 0.0f + this.rand.nextFloat() * 0.1f;
                this.particleRed = this.particleGreen + this.rand.nextFloat() * 0.15f;
                this.particleBlue = this.particleRed + this.rand.nextFloat() * 0.15f;
                break;
            }
            default: {
                if (this.particleMaxAge - this.particleAge < 6) {
                    this.particleAlpha = (this.particleMaxAge - this.particleAge) * 0.15f + 0.2f;
                }
                this.particleGreen = 0.4f + this.rand.nextFloat() * 0.75f;
                this.particleBlue = 0.1f + this.particleGreen;
            }
        }
    }
}
