package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.proxy.ClientProxy;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ParticleTextsCustom
extends Particle {
    private final int particleType;
    private int textWidth;
    private int textHeight;
    private double[] parms;
    private final RenderManager rm;
    private final FontRenderer fr;
    private String text;
    private final Entity host;

    public ParticleTextsCustom(Entity host, World world, double posX, double posY, double posZ, float scale, int type, String text, int ... parms) {
        super(world, 0.0, 0.0, 0.0);
        this.setSize(0.0f, 0.0f);
        this.prevPosX = posX;
        this.prevPosY = posY;
        this.prevPosZ = posZ;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleScale = scale;
        this.particleType = type;
        this.canCollide = false;
        this.host = host;
        this.rm = ClientProxy.getMineraft().getRenderManager();
        this.fr = this.rm.getFontRenderer();
        switch (type) {
            case 0: {
                this.particleMaxAge = 30;
                this.textHeight = parms[0] - 1;
                this.textWidth = parms[1] / 2;
                this.text = text;
                this.setPosition(posX, posY, posZ);
                break;
            }
            case 1: {
                this.particleMaxAge = 30;
                this.textHeight = parms[0] - 1;
                this.textWidth = parms[1] / 2;
                this.text = text;
                this.parms = new double[]{posX, posY, posZ};
                this.setPosition(this.host.posX + this.parms[0], this.host.posY + this.parms[1], this.host.posZ + this.parms[2]);
                break;
            }
            default:
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
    }

    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float cosYaw, float cosPitch, float sinYaw, float sinYawsinPitch, float cosYawsinPitch) {
        float x = (float)(this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX);
        float y = (float)(this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY);
        float z = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ);
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        GlStateManager.glNormal3f(0.0f, 1.0f, 0.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.rotate(-this.rm.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(this.rm.playerViewX, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(-0.025f, -0.025f, 0.025f);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.disableTexture2D();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        render.begin(7, DefaultVertexFormats.POSITION_COLOR);
        render.pos(-this.textWidth - (double)1, -1.0 - this.textHeight * 9.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        render.pos(-this.textWidth - (double)1, 8.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        render.pos(this.textWidth + (double)1, 8.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        render.pos(this.textWidth + (double)1, -1.0 - this.textHeight * 9.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.enableTexture2D();
        GlStateManager.depthMask(true);
        this.fr.drawSplitString(this.text, -this.textWidth, -this.textHeight * 9, this.textWidth * 2, -1);
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
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
            return;
        }
        if(this.particleType == 1){
            if (this.host == null) {
                this.setExpired();
                return;
            }
            this.setPosition(this.host.posX + this.parms[0], this.host.posY + this.parms[1], this.host.posZ + this.parms[2]);   
        }
    }
}
