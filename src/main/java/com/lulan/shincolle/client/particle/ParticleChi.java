package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.utility.CalcHelper;
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
public class ParticleChi
extends Particle {
    private final Entity host;
    private float radChi;

    public ParticleChi(World world, Entity host, float scale, int type) {
        super(world, host.posX, host.posY + host.height * 0.55, host.posZ);
        this.setSize(0.0f, 0.0f);
        this.host = host;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleScale = scale;
        this.canCollide = false;
        if(type == 1){
            this.particleRed = 1.0f;
            this.particleGreen = 1.0f;
            this.particleBlue = 1.0f;
            this.particleAlpha = 1.0f;
            this.particleMaxAge = 40;
            this.radChi = scale * 12.0f;
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
        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX);
        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY);
        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        render.begin(7, DefaultVertexFormats.POSITION_COLOR);
        render.pos(f11, f12, f13 + this.particleScale).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12 + this.particleScale, f13).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11 + this.particleScale, f12, f13).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12 - this.particleScale, f13).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11 + this.particleScale, f12, f13).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12 + this.particleScale, f13).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12, f13 - this.particleScale).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12 - this.particleScale, f13).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12, f13 - this.particleScale).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12 + this.particleScale, f13).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11 - this.particleScale, f12, f13).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12 - this.particleScale, f13).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11 - this.particleScale, f12, f13).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12 + this.particleScale, f13).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12, f13 + this.particleScale).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        render.pos(f11, f12 - this.particleScale, f13).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).endVertex();
        Tessellator.getInstance().draw();
        float parAlpha2 = this.particleAlpha * 0.5f;
        render.begin(7, DefaultVertexFormats.POSITION_COLOR);
        render.pos(f11, f12, f13 + this.particleScale * 1.3).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11, f12 + this.particleScale * 1.3, f13).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11 + this.particleScale * 1.3, f12, f13).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11, f12 - this.particleScale * 1.3, f13).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11 + this.particleScale * 1.3, f12, f13).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11, f12 + this.particleScale * 1.3, f13).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11, f12, f13 - this.particleScale * 1.3).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11, f12 - this.particleScale * 1.3, f13).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11, f12, f13 - this.particleScale * 1.3).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11, f12 + this.particleScale * 1.3, f13).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11 - this.particleScale * 1.3, f12, f13).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11, f12 - this.particleScale * 1.3, f13).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11 - this.particleScale * 1.3, f12, f13).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11, f12 + this.particleScale * 1.3, f13).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11, f12, f13 + this.particleScale * 1.3).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
        render.pos(f11, f12 - this.particleScale * 1.3, f13).color(this.particleRed, this.particleGreen, this.particleBlue, parAlpha2).endVertex();
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
        float[] newPos = CalcHelper.rotateXZByAxis(this.radChi, 0.0f, 6.283185f / this.particleMaxAge * this.particleAge, 1.0f);
        if (this.host != null) {
            this.posX = this.host.posX + newPos[0];
            this.posZ = this.host.posZ + newPos[1];
        } else {
            return;
        }
        int phase = ((IShipEmotion)this.host).getStateEmotion(5);
        if (this.particleAge++ > this.particleMaxAge || phase == 0 || phase == 2) {
            this.setExpired();
        }
    }
}
