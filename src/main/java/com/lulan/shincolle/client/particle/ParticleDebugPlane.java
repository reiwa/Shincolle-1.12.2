package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.entity.BasicEntityShip;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;

public class ParticleDebugPlane
extends Particle {
    private final int particleType;
    private final Entity host;
    private final float[] parms;
    private float hostWidth;
    private float yTop;
    private float yBottom;
    private float red2;
    private float green2;
    private float blue2;
    private float alpha2;

    public ParticleDebugPlane(Entity entity, int type, float ... parms) {
        super(entity.world, 0.0, 0.0, 0.0);
        this.setSize(0.0f, 0.0f);
        this.host = entity;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleType = type;
        this.parms = parms;
        this.canCollide = false;
        switch (type) {
            case 0: {
                this.hostWidth = this.host.width * 0.5f;
                this.particleMaxAge = 2;
                this.red2 = 0.0f;
                this.green2 = 1.0f;
                this.blue2 = 0.0f;
                this.alpha2 = 0.6f;
                this.yTop = this.parms[0];
                this.yBottom = this.parms[0];
                this.setPosition(entity.posX, entity.posY, entity.posZ);
                break;
            }
            case 1: 
            case 2: {
                this.hostWidth = this.host.width * 0.5f;
                if (this.host instanceof BasicEntityShip) {
                    if (this.particleType == 2) {
                        this.red2 = 1.0f;
                        this.green2 = 0.6f;
                        this.blue2 = 1.0f;
                        this.alpha2 = 0.6f;
                    } else {
                        this.red2 = 1.0f;
                        this.green2 = 1.0f;
                        this.blue2 = 1.0f;
                        this.alpha2 = 0.15f;
                    }
                    switch ((int)this.parms[2]) {
                        case 0: {
                            this.particleRed = 1.0f;
                            this.particleGreen = 1.0f;
                            this.particleBlue = 0.0f;
                            this.particleAlpha = 0.15f;
                            break;
                        }
                        case 1: {
                            this.particleRed = 0.0f;
                            this.particleGreen = 1.0f;
                            this.particleBlue = 0.0f;
                            this.particleAlpha = 0.15f;
                            break;
                        }
                        case 2: {
                            this.particleRed = 1.0f;
                            this.particleGreen = 0.0f;
                            this.particleBlue = 1.0f;
                            this.particleAlpha = 0.15f;
                            break;
                        }
                        case 3: {
                            this.particleRed = 1.0f;
                            this.particleGreen = 1.0f;
                            this.particleBlue = 1.0f;
                            this.particleAlpha = 0.15f;
                            break;
                        }
                        case 4: {
                            this.particleRed = 0.0f;
                            this.particleGreen = 1.0f;
                            this.particleBlue = 1.0f;
                            this.particleAlpha = 0.15f;
                            break;
                        }
                        case 5: {
                            this.particleRed = 1.0f;
                            this.particleGreen = 0.0f;
                            this.particleBlue = 0.0f;
                            this.particleAlpha = 0.15f;
                            break;
                        }
                        default: {
                            this.particleRed = 0.0f;
                            this.particleGreen = 0.0f;
                            this.particleBlue = 1.0f;
                            this.particleAlpha = 0.15f;
                        }
                    }
                }
                this.particleMaxAge = 2;
                this.yTop = this.parms[0];
                this.yBottom = this.parms[1];
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
        if (this.particleAge <= 1) {
            return;
        }
        float x = (float)(this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX);
        float y = (float)(this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY);
        float z = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ);
        GlStateManager.pushMatrix();
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableLighting();
        GlStateManager.disableTexture2D();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        render.begin(7, DefaultVertexFormats.POSITION_COLOR);
        render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yTop, (double)z - (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yTop, (double)z + (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yTop, (double)z + (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yTop, (double)z - (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yTop, (double)z - (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yTop, (double)z + (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yTop, (double)z + (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yTop, (double)z - (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
        if (this.yTop != this.yBottom) {
            render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z - (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z + (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z + (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z - (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z - (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z + (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z + (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z - (double)this.hostWidth).color(this.red2, this.green2, this.blue2, this.alpha2).endVertex();
            render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z - (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yTop, (double)z - (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yTop, (double)z + (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z + (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z - (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yTop, (double)z - (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yTop, (double)z - (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z - (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z + (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yTop, (double)z + (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yTop, (double)z - (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z - (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z + (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x + (double)this.hostWidth, (double)y + (double)this.yTop, (double)z + (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yTop, (double)z + (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
            render.pos((double)x - (double)this.hostWidth, (double)y + (double)this.yBottom, (double)z + (double)this.hostWidth).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        }
        Tessellator.getInstance().draw();
        GlStateManager.enableTexture2D();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.popMatrix();
    }

    public int getFXLayer() {
        return 3;
    }

    public void onUpdate() {
        if (this.particleAge++ > this.particleMaxAge || this.host == null) {
            this.setExpired();
            return;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if(this.particleType == 0){
            this.setPosition(this.host.posX, this.host.posY, this.host.posZ);
        }
    }
}
