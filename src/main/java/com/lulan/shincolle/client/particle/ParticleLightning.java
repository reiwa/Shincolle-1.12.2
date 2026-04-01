package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.entity.IShipFloating;
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
public class ParticleLightning
extends Particle {
    private final int particleType;
    private final Entity host;
    private final int numStem;
    private final double[][] prevShape;
    private final float scaleXZ;
    private final float scaleY;

    public ParticleLightning(World world, Entity entity, float scale, int type) {
        super(world, 0.0, 0.0, 0.0);
        this.setSize(0.0f, 0.0f);
        this.host = entity;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleScale = scale;
        this.particleType = type;
        this.canCollide = false;
        this.particleRed = 1.0f;
        this.particleGreen = 0.4f + this.rand.nextFloat() * 0.3f;
        this.particleBlue = 0.4f + this.rand.nextFloat() * 0.3f;
        this.particleAlpha = 1.0f;
        this.particleMaxAge = 20;
        this.numStem = 4;
        this.scaleXZ = 0.01f;
        this.scaleY = 0.12f;
        this.posY = this.host.posY + 1.5;
        float randx = this.rand.nextFloat() + 0.1f;
        float[] newPos = CalcHelper.rotateXZByAxis(0.8f + this.rand.nextFloat() * 0.2f, randx, ((EntityLivingBase)this.host).renderYawOffset * -0.01745f, 1.0f);
        this.posX = this.host.posX + newPos[0];
        this.posY = this.host.posY + 1.53 + randx * 0.25;
        this.posZ = this.host.posZ + newPos[1];
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
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
        for (i = 0; i < this.numStem; ++i) {
            offx = (this.rand.nextFloat() - 0.5f) * 0.1f * (i + 1);
            offz = (this.rand.nextFloat() - 0.5f) * 0.1f * (i + 1);
            if (i == 0) {
                this.prevShape[i][1] = py + cosPitch * this.scaleY;
                this.prevShape[i][4] = this.prevShape[i][1];
            } else {
                this.prevShape[i][1] = py + cosPitch * this.scaleY - i * this.scaleY;
                this.prevShape[i][4] = this.prevShape[i][1];
            }
            this.prevShape[i][0] = px + offx + cosYaw * this.scaleXZ;
            this.prevShape[i][2] = pz + offz + sinYaw * this.scaleXZ;
            this.prevShape[i][3] = px + offx - cosYaw * this.scaleXZ;
            this.prevShape[i][5] = pz + offz - sinYaw * this.scaleXZ;
        }
        render.begin(8, DefaultVertexFormats.POSITION_COLOR);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        for (i = this.numStem - 1; i >= 0; --i) {
            render.pos(this.prevShape[i][0], this.prevShape[i][1], this.prevShape[i][2]).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos(this.prevShape[i][3], this.prevShape[i][4], this.prevShape[i][5]).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
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
        if (this.particleAge++ > this.particleMaxAge) {
            this.setExpired();
        }
        if (this.particleType == 0 && this.host != null) {
            float randx = this.rand.nextFloat() + 0.1f;
            float[] newPos = CalcHelper.rotateXZByAxis(0.8f + this.rand.nextFloat() * 0.2f, randx, ((EntityLivingBase)this.host).renderYawOffset * -0.01745f, 1.0f);
            this.posX = this.host.posX + newPos[0];
            this.posY = this.host.posY + 1.76 + randx * 0.25;
            this.posZ = this.host.posZ + newPos[1];
            if (((IShipFloating)this.host).getShipDepth() > 0.0) {
                this.posY -= 0.08;
            }
            if (((IShipEmotion)this.host).getIsSitting()) {
                this.posY -= 0.23;
            }
        }
    }
}
