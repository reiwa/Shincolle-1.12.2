package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.utility.CalcHelper;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.Vec3d;

public class ParticleSparkle extends Particle {
    private final int particleType;
    private int beamCurrent;
    private final Entity host;
    private float[][] beamPos;
    private float beamFad;
    private float beamSpd;
    private float beamHeight;

    public ParticleSparkle(Entity entity, int type, float... parms) {
        super(entity.world, 0.0, 0.0, 0.0);
        this.setSize(0.0f, 0.0f);
        this.host = entity;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleType = type;
        this.canCollide = false;
        this.beamCurrent = 0;
        switch (type) {
            case 1:
                initializeType1(parms);
                break;
            case 8:
                initializeDefaultType(parms, 120, 30);
                break;
            default:
                initializeDefaultType(parms, 20, 15);
                break;
        }
        this.setPosition(entity.posX, entity.posY + this.beamHeight, entity.posZ);
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
    }

    private void initializeDefaultType(float[] parms, int maxAge, int numBeamMultiplier) {
        this.particleScale = parms[0];
        this.beamFad = parms[1];
        this.beamSpd = parms[2];
        this.particleRed = parms[4];
        this.particleGreen = parms[5];
        this.particleBlue = parms[6];
        this.particleAlpha = parms[7];
        this.beamHeight = parms[8];
        this.particleMaxAge = maxAge;
        int numBeam = (3 - ClientProxy.getMineraft().gameSettings.particleSetting) * numBeamMultiplier;
        this.beamPos = new float[numBeam][8];
    }

    private void initializeType1(float[] parms) {
        this.particleScale = 0.018f;
        this.beamHeight = parms[0];
        this.beamFad = parms[1];
        this.beamSpd = parms[2];
        this.particleRed = parms[3];
        this.particleGreen = parms[4];
        this.particleBlue = parms[5];
        this.particleAlpha = parms[6];
        this.particleMaxAge = 50;
        int numBeam = (3 - ClientProxy.getMineraft().gameSettings.particleSetting) * 15;
        this.beamPos = new float[numBeam][11];
    }

    @Override
    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float cosYaw, float cosPitch, float sinYaw, float sinYawsinPitch, float cosYawsinPitch) {
        float x = (float)(this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX);
        float y = (float)(this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY);
        float z = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ);
        Vec3d[] avec3d = new Vec3d[]{new Vec3d(-cosYaw * this.particleScale - sinYawsinPitch * this.particleScale, -cosPitch * this.particleScale, -sinYaw * this.particleScale - cosYawsinPitch * this.particleScale), new Vec3d(-cosYaw * this.particleScale + sinYawsinPitch * this.particleScale, cosPitch * this.particleScale, -sinYaw * this.particleScale + cosYawsinPitch * this.particleScale), new Vec3d(cosYaw * this.particleScale + sinYawsinPitch * this.particleScale, cosPitch * this.particleScale, sinYaw * this.particleScale + cosYawsinPitch * this.particleScale), new Vec3d(cosYaw * this.particleScale - sinYawsinPitch * this.particleScale, -cosPitch * this.particleScale, sinYaw * this.particleScale - cosYawsinPitch * this.particleScale)};
        GlStateManager.pushMatrix();
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableLighting();
        GlStateManager.disableTexture2D();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        render.begin(7, DefaultVertexFormats.POSITION_COLOR);
        for (float[] beam : this.beamPos) {
            renderBeam(render, x, y, z, beam, avec3d);
        }
        Tessellator.getInstance().draw();
        GlStateManager.enableTexture2D();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.popMatrix();
    }

    private void renderBeam(BufferBuilder render, float x, float y, float z, float[] beam, Vec3d[] vertices) {
        if (beam[3] == 0.0f || beam[4] == 0.0f || beam[5] == 0.0f || beam[6] == 0.0f) return;
        float size = (20.0f - beam[7]) * 0.05f;
        double beamX = x + beam[0];
        double beamY = y + beam[1];
        double beamZ = z + beam[2];
        render.pos(beamX + vertices[0].x * size, beamY + vertices[0].y * size, beamZ + vertices[0].z * size).color(beam[3], beam[4], beam[5], beam[6]).endVertex();
        render.pos(beamX + vertices[1].x * size, beamY + vertices[1].y * size, beamZ + vertices[1].z * size).color(beam[3], beam[4], beam[5], beam[6]).endVertex();
        render.pos(beamX + vertices[2].x * size, beamY + vertices[2].y * size, beamZ + vertices[2].z * size).color(beam[3], beam[4], beam[5], beam[6]).endVertex();
        render.pos(beamX + vertices[3].x * size, beamY + vertices[3].y * size, beamZ + vertices[3].z * size).color(beam[3], beam[4], beam[5], beam[6]).endVertex();
    }

    @Override
    public int getFXLayer() {
        return 3;
    }

    @Override
    public void onUpdate() {
        if (this.particleAge++ > this.particleMaxAge || this.host == null) {
            this.setExpired();
            return;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if(this.particleType == 1){
            updateType1();
        } else {
            updateDefaultType();
        }
    }

    private void updateDefaultType() {
        int particlesToSpawn = 4 - ClientProxy.getMineraft().gameSettings.particleSetting;
        for (int i = 0; i < particlesToSpawn; ++i) {
            spawnDefaultBeam();
        }
        updateAllBeamsDefault();
    }

    private void spawnDefaultBeam() {
        float[] color = getBeamColor();
        this.beamPos[this.beamCurrent] = new float[]{(float) (this.host.posX - this.posX) + (this.rand.nextFloat() - 0.5f) * this.beamFad, (float) (this.host.posY - this.posY) + this.beamHeight + (this.rand.nextFloat() - 0.5f) * this.beamFad, (float) (this.host.posZ - this.posZ) + (this.rand.nextFloat() - 0.5f) * this.beamFad, color[0], color[1], color[2], this.particleAlpha, 0.0f};
        this.beamCurrent = (this.beamCurrent + 1) % this.beamPos.length;
    }

    private float[] getBeamColor() {
        float red = 1.0f;
        float green = 1.0f;
        float blue = 1.0f;
        float randFactor = this.rand.nextFloat() * 1.2f - 0.5f;
        switch (this.particleType) {
            case 0: red += randFactor; break;
            case 2: green += randFactor; break;
            case 3: blue += randFactor; break;
            case 4: red += randFactor; green += this.rand.nextFloat() * 1.2f - 0.5f; break;
            case 5: red += randFactor; blue += this.rand.nextFloat() * 1.2f - 0.5f; break;
            case 6: green += randFactor; blue += this.rand.nextFloat() * 1.2f - 0.5f; break;
            case 7: red += randFactor; green += this.rand.nextFloat() * 1.2f - 0.5f; blue += this.rand.nextFloat() * 1.2f - 0.5f; break;
            case 8: red += randFactor; green = 0.001f; blue = 0.001f; break;
            case 9: red = 0.001f; green += randFactor; blue = 0.001f; break;
            case 10: red = 0.001f; green = 0.001f; blue += randFactor; break;
            default:
        }
        return new float[]{red, green, blue};
    }

    private void updateAllBeamsDefault() {
        for (float[] beam : this.beamPos) {
            beam[0] += this.particleRed;
            beam[1] += this.particleGreen;
            beam[2] += this.particleBlue;
            beam[7] += 1.0f;
            beam[6] = Math.min(1.0f, this.rand.nextFloat() + 0.1f);
        }
    }

    private void updateType1() {
        this.setPosition(this.host.posX, this.host.posY + this.beamHeight, this.host.posZ);
        int particlesToSpawn = 4 - ClientProxy.getMineraft().gameSettings.particleSetting;
        for (int i = 0; i < particlesToSpawn; ++i) {
            spawnType1Beam();
        }
        updateAllBeamsType1();
    }

    private void spawnType1Beam() {
        boolean isState8 = ((IShipEmotion) this.host).getStateFlag(8);
        float eyex = isState8 ? this.beamFad - 0.05f : this.beamFad;
        float eyeh = isState8 ? 0.02f : 0.0f;
        float yawRad = this.host.getRotationYawHead() * ((float) Math.PI / 180);
        float pitchRad = this.host.rotationPitch * ((float) Math.PI / 180);
        float[] headpos = CalcHelper.rotateXYZByYawPitch(eyex, 0.19f + eyeh, this.beamSpd, yawRad, pitchRad, 1.0f);
        float[] headmov = CalcHelper.rotateXZByAxis(1.0f, 1.0f, ((EntityLivingBase) this.host).rotationYawHead * ((float) Math.PI / 180), 0.025f);
        this.beamPos[this.beamCurrent] = new float[]{headpos[0] + (this.rand.nextFloat() - 0.5f) * 0.1f, headpos[1] + (this.rand.nextFloat() - 0.5f) * 0.1f, headpos[2] + (this.rand.nextFloat() - 0.5f) * 0.1f, this.particleRed + this.rand.nextFloat() + 0.4f, this.particleGreen, this.particleBlue, this.particleAlpha, 0.0f, headmov[1], 0.01f, headmov[0]};
        this.beamCurrent = (this.beamCurrent + 1) % this.beamPos.length;
    }

    private void updateAllBeamsType1() {
        for (float[] beam : this.beamPos) {
            beam[8] *= 0.99f;
            beam[9] *= 1.08f;
            beam[10] *= 0.99f;
            beam[0] += beam[8];
            beam[1] += beam[9];
            beam[2] += beam[10];
            beam[7] += 1.0f;
            beam[6] *= 0.92f;
        }
    }
}