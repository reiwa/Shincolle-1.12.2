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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ParticleLine
extends Particle {
    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle:textures/particles/ParticleGradientLine.png");
    private final int particleType;
    private final float[] parms;

    public ParticleLine(World world, int type, float[] parms) {
        super(world, 0.0, 0.0, 0.0);
        this.setSize(0.0f, 0.0f);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.parms = parms;
        this.particleType = type;
        this.canCollide = false;
        if(type == 0){
            this.particleMaxAge = 50;
            this.particleRed = parms[3];
            this.particleGreen = parms[4];
            this.particleBlue = parms[5];
            this.particleAlpha = parms[6];
            this.posX = parms[7];
            this.posY = parms[8];
            this.posZ = parms[9];
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
    }

    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float cosYaw, float cosPitch, float sinYaw, float sinYawsinPitch, float cosYawsinPitch) {
        double px = this.posX - interpPosX;
        double py = this.posY - interpPosY;
        double pz = this.posZ - interpPosZ;
        double[] xyzh = new double[]{this.parms[0] * this.parms[10], this.parms[0] * this.parms[11], this.parms[0] * this.parms[12]};
        double[] xyzf = new double[]{this.parms[1] * this.parms[10], this.parms[1] * this.parms[11], this.parms[1] * this.parms[12]};
        double[] xyzb = new double[]{-this.parms[2] * this.parms[10], -this.parms[2] * this.parms[11], -this.parms[2] * this.parms[12]};
        Vec3d[] plane1 = new Vec3d[]{new Vec3d(xyzf[0], xyzf[1] - xyzh[2], xyzf[2] + xyzh[1]), new Vec3d(xyzf[0], xyzf[1] + xyzh[2], xyzf[2] - xyzh[1]), new Vec3d(xyzb[0], xyzb[1] + xyzh[2], xyzb[2] - xyzh[1]), new Vec3d(xyzb[0], xyzb[1] - xyzh[2], xyzb[2] + xyzh[1])};
        Vec3d[] plane2 = new Vec3d[]{new Vec3d(xyzf[0] - xyzh[2], xyzf[1], xyzf[2] + xyzh[0]), new Vec3d(xyzf[0] + xyzh[2], xyzf[1], xyzf[2] - xyzh[0]), new Vec3d(xyzb[0] - xyzh[2], xyzb[1], xyzb[2] + xyzh[0]), new Vec3d(xyzb[0] + xyzh[2], xyzb[1], xyzb[2] - xyzh[0])};
        Vec3d[] plane3 = new Vec3d[]{new Vec3d(xyzf[0] - xyzh[1], xyzf[1] + xyzh[0], xyzf[2]), new Vec3d(xyzf[0] + xyzh[1], xyzf[1] - xyzh[0], xyzf[2]), new Vec3d(xyzb[0] - xyzh[1], xyzb[1] + xyzh[0], xyzb[2]), new Vec3d(xyzb[0] + xyzh[1], xyzb[1] - xyzh[0], xyzb[2])};
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.depthMask(false);
        GlStateManager.disableLighting();
        render.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        render.pos(px + plane1[0].x, py + plane1[0].y, pz + plane1[0].z).tex(1.0, 1.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane1[1].x, py + plane1[1].y, pz + plane1[1].z).tex(1.0, 0.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane1[2].x, py + plane1[2].y, pz + plane1[2].z).tex(0.0, 0.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane1[3].x, py + plane1[3].y, pz + plane1[3].z).tex(0.0, 1.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane1[3].x, py + plane1[3].y, pz + plane1[3].z).tex(0.0, 1.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane1[2].x, py + plane1[2].y, pz + plane1[2].z).tex(0.0, 0.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane1[1].x, py + plane1[1].y, pz + plane1[1].z).tex(1.0, 0.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane1[0].x, py + plane1[0].y, pz + plane1[0].z).tex(1.0, 1.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane2[0].x, py + plane2[0].y, pz + plane2[0].z).tex(1.0, 1.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane2[1].x, py + plane2[1].y, pz + plane2[1].z).tex(1.0, 0.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane2[2].x, py + plane2[2].y, pz + plane2[2].z).tex(0.0, 0.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane2[3].x, py + plane2[3].y, pz + plane2[3].z).tex(0.0, 1.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane2[3].x, py + plane2[3].y, pz + plane2[3].z).tex(0.0, 1.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane2[2].x, py + plane2[2].y, pz + plane2[2].z).tex(0.0, 0.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane2[1].x, py + plane2[1].y, pz + plane2[1].z).tex(1.0, 0.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane2[0].x, py + plane2[0].y, pz + plane2[0].z).tex(1.0, 1.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane3[0].x, py + plane3[0].y, pz + plane3[0].z).tex(1.0, 1.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane3[1].x, py + plane3[1].y, pz + plane3[1].z).tex(1.0, 0.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane3[2].x, py + plane3[2].y, pz + plane3[2].z).tex(0.0, 0.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane3[3].x, py + plane3[3].y, pz + plane3[3].z).tex(0.0, 1.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane3[3].x, py + plane3[3].y, pz + plane3[3].z).tex(0.0, 1.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane3[2].x, py + plane3[2].y, pz + plane3[2].z).tex(0.0, 0.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane3[1].x, py + plane3[1].y, pz + plane3[1].z).tex(1.0, 0.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(px + plane3[0].x, py + plane3[0].y, pz + plane3[0].z).tex(1.0, 1.0).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.enableLighting();
        GlStateManager.depthMask(false);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public int getFXLayer() {
        return 3;
    }

    public void onUpdate() {
        if (this.particleAge++ > this.particleMaxAge) {
            this.setExpired();
        }
        if(this.particleType == 0){
            this.parms[0] = this.parms[0] * 0.88f;
            this.parms[2] = this.parms[2] * 0.85f;
            this.particleAlpha *= 0.9f;
        }
    }
}
