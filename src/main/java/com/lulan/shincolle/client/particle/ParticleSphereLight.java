package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.utility.CalcHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ParticleSphereLight extends Particle {
    private static final ResourceLocation TEXTURE1 = new ResourceLocation("shincolle:textures/particles/ParticleGradientLine.png");
    private final int particleType;
    private int beamCurrent;
    private final Entity host;
    private float[][] beamPos;
    private float beamRad;
    private float beamSpd;
    private float beamThick;
    private float beamHeight;
    private final RenderManager rm;

    public ParticleSphereLight(Entity entity, int type, float... parms) {
        super(entity.world, 0.0, 0.0, 0.0);
        this.setSize(0.0f, 0.0f);
        this.host = entity;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleType = type;
        this.canCollide = false;
        this.beamCurrent = 0;
        this.rm = ClientProxy.getMineraft().getRenderManager();
        int numBeam = (3 - ClientProxy.getMineraft().gameSettings.particleSetting) * 25;
        switch (type) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                initializeDefaultType(parms, numBeam);
                break;
            case 5:
                initializeType5(parms, entity.height, numBeam);
                break;
            default:
        }
        this.setPosition(entity.posX, entity.posY + this.beamHeight, entity.posZ);
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
    }

    private void initializeDefaultType(float[] parms, int numBeam) {
        this.particleScale = parms[0];
        this.beamRad = parms[1];
        this.beamSpd = parms[2];
        this.beamThick = parms[3];
        this.particleRed = parms[4];
        this.particleGreen = parms[5];
        this.particleBlue = parms[6];
        this.particleAlpha = parms[7];
        this.beamHeight = parms[8];
        this.particleMaxAge = 40;
        this.beamPos = new float[numBeam][6];
    }

    private void initializeType5(float[] parms, float entityHeight, int numBeam) {
        this.particleMaxAge = (int) parms[0];
        this.particleScale = parms[1];
        this.beamRad = 0.5f;
        this.beamSpd = 0.8f;
        this.beamThick = 2.0f;
        this.particleRed = 0.0f;
        this.particleGreen = 0.0f;
        this.particleBlue = 0.0f;
        this.particleAlpha = 0.8f;
        this.beamHeight = entityHeight * 0.5f;
        this.beamPos = new float[numBeam][6];
    }

    @Override
    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float cosYaw, float cosPitch, float sinYaw, float sinYawsinPitch, float cosYawsinPitch) {
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE1);
        float x = (float) (this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX);
        float y = (float) (this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY);
        float z = (float) (this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ);
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.rotate(-this.rm.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(this.rm.playerViewX, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(-0.25f, -0.25f, 0.25f);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(true);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        render.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        for (float[] beam : this.beamPos) {
            renderBeam(render, beam);
        }
        Tessellator.getInstance().draw();
        GlStateManager.depthMask(false);
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.popMatrix();
    }

    private void renderBeam(BufferBuilder render, float[] beam) {
        if (beam[0] == 0.0f && beam[1] == 0.0f) return;
        float depth = this.rand.nextFloat() * 0.1f;
        float x0 = beam[0];
        float y0 = beam[1];
        float r = beam[2];
        float g = beam[3];
        float b = beam[4];
        float a = beam[5];
        float scaledX = this.particleScale * x0;
        float scaledY = this.particleScale * y0;
        float thickOffsetX = y0 * this.beamThick;
        float thickOffsetY = x0 * this.beamThick;
        render.pos(scaledX - thickOffsetX, scaledY + thickOffsetY, depth).tex(1.0, 1.0).color(r, g, b, a).endVertex();
        render.pos(scaledX, scaledY, depth).tex(1.0, 0.0).color(r, g, b, a).endVertex();
        render.pos(x0, y0, depth).tex(0.0, 0.0).color(r, g, b, a).endVertex();
        render.pos(x0 - thickOffsetX, y0 + thickOffsetY, depth).tex(0.0, 1.0).color(r, g, b, a).endVertex();
    }

    @Override
    public int getFXLayer() {
        return 3;
    }

    @Override
    public void onUpdate() {
        if (this.particleAge++ > this.particleMaxAge) {
            this.setExpired();
            return;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.host != null) {
            this.setPosition(this.host.posX, this.host.posY + this.beamHeight, this.host.posZ);
        }
        switch (this.particleType) {
            case 0:
                updateType0();
                break;
            case 1:
                updateType1();
                break;
            case 2:
            case 3:
                break;
            case 5:
                updateType5();
                break;
            default:
        }
    }

    private void updateType0() {
        if (this.particleAge <= 30) {
            int particlesToSpawn = (3 - ClientProxy.getMineraft().gameSettings.particleSetting) * 3;
            for (int i = 0; i < particlesToSpawn; ++i) {
                spawnBeam(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha, 360.0f);
            }
        }
        updateBeamPositionsCommon();
    }

    private void updateType1() {
        if (this.particleAge <= 40) {
            for (int i = 0; i < 2; ++i) {
                spawnBeam(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha, 540.0f);
            }
        }
        updateBeamPositionsType1();
    }

    private void updateType5() {
        if (this.particleAge <= this.particleMaxAge * 0.95f) {
            if (this.particleAge > this.particleMaxAge * 0.5f) {
                this.particleAlpha *= 0.8f;
            }
            int particlesToSpawn = (3 - ClientProxy.getMineraft().gameSettings.particleSetting) * 3;
            for (int i = 0; i < particlesToSpawn; ++i) {
                float r = this.particleRed + this.rand.nextFloat() * 0.1f;
                float b = this.particleBlue + this.rand.nextFloat() * 0.2f;
                spawnBeam(r, this.particleGreen, b, this.particleAlpha, 360.0f);
            }
        }
        updateBeamPositionsCommon();
    }

    private void spawnBeam(float r, float g, float b, float a, float angleRange) {
        float[] newpos = CalcHelper.rotateXZByAxis(this.beamRad * (this.rand.nextFloat() + 1.0f), this.beamRad * (this.rand.nextFloat() + 1.0f), this.rand.nextFloat() * angleRange * ((float) Math.PI / 180), 1.0f);
        this.beamPos[this.beamCurrent] = new float[]{newpos[0], newpos[1], r, g, b, a};
        this.beamCurrent = (this.beamCurrent + 1) % this.beamPos.length;
    }

    private void updateBeamPositionsCommon() {
        for (float[] beam : this.beamPos) {
            beam[0] *= this.beamSpd;
            beam[1] *= this.beamSpd;
            beam[0] = clampToMinimumMagnitude(beam[0], 0.001f);
            beam[1] = clampToMinimumMagnitude(beam[1], 0.001f);
        }
    }

    private void updateBeamPositionsType1() {
        float multiplier = 1.0f + this.beamSpd;
        for (float[] beam : this.beamPos) {
            beam[0] *= multiplier;
            beam[1] *= multiplier;
            if (this.particleAge > 30) {
                beam[5] *= 0.8f;
            }
        }
    }

    private float clampToMinimumMagnitude(float value, float minMagnitude) {
        if (value > 0.0f && value < minMagnitude) {
            return minMagnitude;
        }
        if (value < 0.0f && value > -minMagnitude) {
            return -minMagnitude;
        }
        return value;
    }
}