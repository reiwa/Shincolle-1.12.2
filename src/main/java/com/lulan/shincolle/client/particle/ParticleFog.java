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
import org.lwjgl.opengl.GL11;

import static java.lang.Math.max;

public class ParticleFog extends Particle {
    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle:textures/particles/ParticleBlockFog.png");
    private final float initAlpha;

    public ParticleFog(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
        double radius = 0.02D;
        double theta = rand.nextDouble() * Math.PI * 2;
        double phi   = Math.acos(2 * rand.nextDouble() - 1);
        this.motionX = xSpeedIn + Math.sin(phi) * Math.cos(theta) * radius;
        this.motionY = max(0, ySpeedIn + Math.cos(phi) * radius);
        this.motionZ = zSpeedIn + Math.sin(phi) * Math.sin(theta) * radius;
        this.particleScale *= 1.0F;
        this.particleMaxAge = 60;
        this.canCollide = false;
        this.particleAlpha = 1.0F;
        this.initAlpha = this.particleAlpha;
    }

    @Override
    public void renderParticle(BufferBuilder buf, Entity entity, float pt, float rotX, float rotZ, float rotYZ, float rotXY, float rotXZ) {
        float x = (float)(prevPosX + (posX - prevPosX) * pt - interpPosX);
        float y = (float)(prevPosY + (posY - prevPosY) * pt - interpPosY);
        float z = (float)(prevPosZ + (posZ - prevPosZ) * pt - interpPosZ);
        Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.depthMask(false);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240F, 240F);
        Tessellator tess = Tessellator.getInstance();
        BufferBuilder buffer = tess.getBuffer();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
        float s = 0.2F * particleScale;
        float u0 = 0;
        float u1 = 1;
        float v0 = 0;
        float v1 = 1;
        int light = getBrightnessForRender(pt);
        int lmX = light >> 16 & 0xFFFF;
        int lmY = light & 0xFFFF;
        buffer.pos(x - rotX * s - rotXY * s,    y - rotZ * s,     z - rotYZ * s - rotXZ * s)
                .tex(u1, v1).color(particleRed, particleGreen, particleBlue, particleAlpha).lightmap(lmX, lmY).endVertex();
        buffer.pos(x - rotX * s + rotXY * s,    y + rotZ * s,     z - rotYZ * s + rotXZ * s)
                .tex(u1, v0).color(particleRed, particleGreen, particleBlue, particleAlpha).lightmap(lmX, lmY).endVertex();
        buffer.pos(x + rotX * s + rotXY * s,    y + rotZ * s,     z + rotYZ * s + rotXZ * s)
                .tex(u0, v0).color(particleRed, particleGreen, particleBlue, particleAlpha).lightmap(lmX, lmY).endVertex();
        buffer.pos(x + rotX * s - rotXY * s,    y - rotZ * s,     z + rotYZ * s - rotXZ * s)
                .tex(u0, v1).color(particleRed, particleGreen, particleBlue, particleAlpha).lightmap(lmX, lmY).endVertex();
        tess.draw();
        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
    }

    @Override
    public int getFXLayer() {
        return 3;
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.move(this.motionX, this.motionY, this.motionZ);
        float lifeFrac = (float)this.particleAge / this.particleMaxAge;
        this.particleAlpha = initAlpha * (1.0F - lifeFrac);
        this.motionX *= 0.9D;
        this.motionY *= 0.9D;
        this.motionZ *= 0.9D;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
    }
}
