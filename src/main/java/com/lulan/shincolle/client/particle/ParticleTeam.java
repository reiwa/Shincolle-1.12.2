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
public class ParticleTeam
extends Particle {
    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle:textures/particles/ParticleTeam.png");
    private final int particleType;
    private final double particleHeight;
    private float particleAlphaA;
    private float particleAlphaC;
    private Entity host;

    public ParticleTeam(World world, Entity host, float scale, int type) {
        super(world, 0.0, 0.0, 0.0);
        this.setSize(0.0f, 0.0f);
        this.prevPosX = host.posX;
        this.prevPosY = host.posY;
        this.prevPosZ = host.posZ;
        this.setPosition(host.posX, host.posY, host.posZ);
        this.host = host;
        this.particleHeight = host.height;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleScale = scale;
        this.particleAlphaA = 1.0f;
        this.particleAlphaC = 0.8f;
        this.particleType = type;
        this.canCollide = false;
        switch (type) {
            case 1: {
                this.particleRed = 0.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.particleMaxAge = 30;
                break;
            }
            case 2: {
                this.particleRed = 1.0f;
                this.particleGreen = 0.0f;
                this.particleBlue = 1.0f;
                this.particleMaxAge = 30;
                break;
            }
            case 3: {
                this.particleRed = 1.0f;
                this.particleGreen = 0.9f;
                this.particleBlue = 0.0f;
                this.particleMaxAge = 30;
                break;
            }
            case 5: {
                this.particleRed = 1.0f;
                this.particleGreen = 0.0f;
                this.particleBlue = 0.0f;
                this.particleMaxAge = 30;
                break;
            }
            case 6: {
                this.particleRed = 1.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.particleMaxAge = 30;
                break;
            }
            case 7: {
                this.particleRed = 0.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 0.0f;
                this.particleMaxAge = 30;
                this.particleAlphaA = 0.0f;
                this.particleAlphaC = 0.35f;
                this.prevPosX = host.posX;
                this.prevPosY = host.posY - 0.04;
                this.prevPosZ = host.posZ;
                this.setPosition(host.posX, host.posY - 0.04, host.posZ);
                break;
            }
            default: {
                this.particleRed = 0.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 0.0f;
                this.particleMaxAge = 30;
                break;
            }
        }
    }

    public ParticleTeam(World world, float scale, int type, double x, double y, double z) {
        super(world, 0.0, 0.0, 0.0);
        this.setSize(0.0f, 0.0f);
        this.setPosition(x, y, z);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleHeight = 1.5;
        this.particleScale = scale;
        this.particleAlphaA = 1.0f;
        this.particleAlphaC = 0.5f;
        this.particleType = type;
        this.canCollide = false;
        switch (type) {
            case 5: {
                this.particleRed = 1.0f;
                this.particleGreen = 0.0f;
                this.particleBlue = 0.0f;
                this.particleMaxAge = 30;
                break;
            }
            case 6: {
                this.particleRed = 1.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.particleMaxAge = 30;
                break;
            }
            case 8: {
                this.particleRed = 1.0f;
                this.particleGreen = 0.0f;
                this.particleBlue = 0.0f;
                this.particleMaxAge = 31;
                this.particleAlphaA = 0.8f;
                this.particleAlphaC = 0.9f;
                break;
            }
            case 9: {
                this.particleRed = 1.0f;
                this.particleGreen = 0.0f;
                this.particleBlue = 0.0f;
                this.particleMaxAge = 31;
                this.particleAlphaA = 0.0f;
                this.particleAlphaC = 0.9f;
                break;
            }
            default: {
                this.particleRed = 0.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 0.0f;
                this.particleMaxAge = 30;
                break;
            }
        }
    }

    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float cosYaw, float cosPitch, float sinYaw, float sinYawsinPitch, float cosYawsinPitch) {
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
        GlStateManager.pushMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableLighting();
        float xmin = 0.0f;
        float xmax = 1.0f;
        float y1min = 0.0f;
        float y1max = 0.5f;
        float y2min = 0.5f;
        float y2max = 1.0f;
        float halfScale;
        double f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX);
        double f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY + this.particleHeight + 1.3);
        double f12b = (float)(this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY + 0.3);
        double f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ);
        render.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        render.pos(f11 - (cosYaw * this.particleScale), f12 - (cosPitch * this.particleScale * 2.0f), f13 - (sinYaw * this.particleScale)).tex(xmax, y1max).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlphaA).endVertex();
        render.pos(f11 - (cosYaw * this.particleScale), f12 + (cosPitch * this.particleScale * 2.0f), f13 - (sinYaw * this.particleScale)).tex(xmax, y1min).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlphaA).endVertex();
        render.pos(f11 + (cosYaw * this.particleScale), f12 + (cosPitch * this.particleScale * 2.0f), f13 + (sinYaw * this.particleScale)).tex(xmin, y1min).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlphaA).endVertex();
        render.pos(f11 + (cosYaw * this.particleScale), f12 - (cosPitch * this.particleScale * 2.0f), f13 + (sinYaw * this.particleScale)).tex(xmin, y1max).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlphaA).endVertex();
        halfScale = this.particleScale * 3.0f;
        render.pos(f11 + halfScale, f12b, f13 + halfScale).tex(xmax, y2max).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlphaC).endVertex();
        render.pos(f11 + halfScale, f12b, f13 - halfScale).tex(xmax, y2min).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlphaC).endVertex();
        render.pos(f11 - halfScale, f12b, f13 - halfScale).tex(xmin, y2min).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlphaC).endVertex();
        render.pos(f11 - halfScale, f12b, f13 + halfScale).tex(xmin, y2max).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlphaC).endVertex();
        render.pos(f11 + halfScale, f12b, f13 - halfScale).tex(xmax, y2max).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlphaC).endVertex();
        render.pos(f11 + halfScale, f12b, f13 + halfScale).tex(xmax, y2min).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlphaC).endVertex();
        render.pos(f11 - halfScale, f12b, f13 + halfScale).tex(xmin, y2min).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlphaC).endVertex();
        render.pos(f11 - halfScale, f12b, f13 - halfScale).tex(xmin, y2max).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlphaC).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(false);
        GlStateManager.popMatrix();
    }

    public int getFXLayer() {
        return 3;
    }

    public void onUpdate() {
        if (this.host != null) {
            if(this.particleType == 7){
                this.prevPosX = this.posX;
                this.prevPosY = this.posY;
                this.prevPosZ = this.posZ;
                this.setPosition(this.host.posX, this.host.posY - 0.04, this.host.posZ);
            } else {
                this.prevPosX = this.posX;
                this.prevPosY = this.posY;
                this.prevPosZ = this.posZ;
                this.setPosition(this.host.posX, this.host.posY, this.host.posZ);   
            }
        } else if (this.particleType < 4) {
            this.setExpired();
        }
        switch (this.particleType) {
            case 4: 
            case 5: 
            case 6: {
                if (this.particleAge <= 10) break;
                this.particleAlphaA = 1.0f - (this.particleAge - 10.0f) / 20.0f;
                this.particleAlphaC = this.particleAlphaA * 0.5f;
                break;
            }
            case 9: {
                this.prevPosX = this.posX;
                this.prevPosY = this.posY;
                this.prevPosZ = this.posZ;
                this.setPosition(this.posX, this.posY + this.particleAge * 0.002, this.posZ);
                this.particleAlphaC = 0.9f - this.particleAge * 0.027f;
                break;
            }
            default:
        }
        if (this.particleAge++ > this.particleMaxAge) {
            this.setExpired();
        }
    }
}
