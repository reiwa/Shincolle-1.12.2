package com.lulan.shincolle.client.particle;

import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.utility.CalcHelper;
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
public class ParticleEmotion
extends Particle {
    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle:textures/particles/ParticleEmotion.png");
    private final Entity host;
    private final int particleType;
    private int playTimes;
    private int fadeTick;
    private int fadeState;
    private int stayTick;
    private int stayTickCount;
    private int frameSize;
    private float playSpeed;
    private float playSpeedCount;
    private final float particleIconX;
    private final float particleIconY;
    private final float addHeight;
    private final float entType;
    private double px;
    private double py;
    private double pz;
    private double addx;
    private double addy;
    private double addz;

    public ParticleEmotion(World world, Entity host, double posX, double posY, double posZ, float height, int entType, int type) {
        super(world, posX, posY, posZ);
        this.host = host;
        this.setSize(0.0f, 0.0f);
        this.setPosition(posX, posY, posZ);
        this.prevPosX = posX;
        this.prevPosY = posY;
        this.prevPosZ = posZ;
        this.motionX = 0.0;
        this.motionZ = 0.0;

        this.particleType = type;
        this.particleScale = this.rand.nextFloat() * 0.05f + 0.275f;
        this.particleAlpha = 0.0f;
        this.playSpeed = 1.0f;
        this.playSpeedCount = 0.0f;
        this.stayTick = 10;
        this.stayTickCount = 0;
        this.fadeTick = 0;
        this.fadeState = 0;
        this.frameSize = 1;
        this.addHeight = height;
        this.entType = entType;
        this.particleAge = -1;
        this.canCollide = false;
        switch (this.particleType) {
            case 1: {
                this.particleIconX = 0.0625f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 7;
                this.playTimes = 4;
                this.stayTick = 0;
                break;
            }
            case 2: {
                this.particleIconX = 0.0625f;
                this.particleIconY = 0.5f;
                this.particleMaxAge = 7;
                this.playTimes = 3;
                this.particleAlpha = 1.0f;
                this.fadeState = 1;
                this.fadeTick = 5;
                this.stayTick = 0;
                break;
            }
            case 3: {
                this.particleIconX = 0.125f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 7;
                this.playTimes = 1;
                this.fadeTick = 3;
                break;
            }
            case 4: {
                this.particleIconX = 0.125f;
                this.particleIconY = 0.5f;
                this.particleMaxAge = 7;
                this.playTimes = 1;
                this.fadeTick = 3;
                this.stayTick = 20;
                break;
            }
            case 5: {
                this.particleIconX = 0.1875f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 7;
                this.playTimes = 1;
                this.stayTick = 20;
                this.playSpeed = 0.5f;
                break;
            }
            case 6: {
                this.particleIconX = 0.1875f;
                this.particleIconY = 0.5f;
                this.particleMaxAge = 7;
                this.playTimes = 1;
                this.fadeTick = 3;
                break;
            }
            case 7: {
                this.particleIconX = 0.25f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 15;
                this.playTimes = 1;
                this.particleAlpha = 1.0f;
                this.fadeState = 1;
                this.fadeTick = 3;
                this.stayTick = 3;
                this.playSpeed = 0.7f;
                break;
            }
            case 8: {
                this.particleIconX = 0.3125f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 7;
                this.playTimes = 3;
                this.fadeTick = 3;
                this.stayTick = 0;
                this.playSpeed = 0.5f;
                break;
            }
            case 9: {
                this.particleIconX = 0.3125f;
                this.particleIconY = 0.5f;
                this.particleMaxAge = 7;
                this.playTimes = 2;
                this.fadeTick = 3;
                this.stayTick = 1;
                this.playSpeed = 0.5f;
                break;
            }
            case 10: {
                this.particleIconX = 0.375f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 7;
                this.playTimes = 4;
                this.particleAlpha = 1.0f;
                this.fadeState = 1;
                this.fadeTick = 3;
                this.stayTick = 1;
                break;
            }
            case 11: {
                this.particleIconX = 0.375f;
                this.particleIconY = 0.5f;
                this.particleMaxAge = 7;
                this.playTimes = 2;
                this.particleAlpha = 1.0f;
                this.fadeState = 1;
                this.fadeTick = 3;
                this.stayTick = 0;
                this.playSpeed = 0.75f;
                break;
            }
            case 12: {
                this.particleIconX = 0.4375f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 14;
                this.playTimes = 1;
                this.particleAlpha = 1.0f;
                this.fadeState = 1;
                this.fadeTick = 3;
                this.stayTick = 20;
                this.playSpeed = 0.75f;
                this.frameSize = 2;
                break;
            }
            case 13: {
                this.particleIconX = 0.5f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 7;
                this.playTimes = 2;
                this.particleAlpha = 1.0f;
                this.fadeState = 1;
                this.fadeTick = 3;
                this.stayTick = 0;
                this.playSpeed = 0.75f;
                break;
            }
            case 14: {
                this.particleIconX = 0.5f;
                this.particleIconY = 0.5f;
                this.particleMaxAge = 7;
                this.playTimes = 2;
                this.fadeTick = 3;
                this.stayTick = 0;
                break;
            }
            case 15: {
                this.particleIconX = 0.5625f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 7;
                this.playTimes = 1;
                this.fadeTick = 3;
                this.stayTick = 15;
                this.playSpeed = 0.7f;
                break;
            }
            case 16: {
                this.particleIconX = 0.5625f;
                this.particleIconY = 0.5f;
                this.particleMaxAge = 7;
                this.playTimes = 3;
                this.particleAlpha = 1.0f;
                this.fadeState = 1;
                this.fadeTick = 3;
                this.stayTick = 0;
                break;
            }
            case 17: {
                this.particleIconX = 0.625f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 15;
                this.playTimes = 1;
                this.fadeTick = 3;
                this.playSpeed = 0.5f;
                break;
            }
            case 18: {
                this.particleIconX = 0.6875f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 7;
                this.playTimes = 1;
                this.stayTick = 0;
                this.playSpeed = 0.4f;
                break;
            }
            case 19: {
                this.particleIconX = 0.6875f;
                this.particleIconY = 0.5f;
                this.particleMaxAge = 7;
                this.playTimes = 3;
                this.particleAlpha = 1.0f;
                this.fadeState = 1;
                this.fadeTick = 3;
                this.stayTick = 0;
                this.playSpeed = 0.75f;
                break;
            }
            case 20: {
                this.particleIconX = 0.75f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 7;
                this.playTimes = 1;
                this.fadeTick = 3;
                this.stayTick = 20;
                this.playSpeed = 0.5f;
                break;
            }
            case 21: {
                this.particleIconX = 0.75f;
                this.particleIconY = 0.5f;
                this.particleMaxAge = 0;
                this.playTimes = 1;
                this.stayTick = 40;
                break;
            }
            case 22: {
                this.particleIconX = 0.75f;
                this.particleIconY = 0.5625f;
                this.particleMaxAge = 0;
                this.playTimes = 1;
                this.stayTick = 40;
                break;
            }
            case 23: {
                this.particleIconX = 0.75f;
                this.particleIconY = 0.625f;
                this.particleMaxAge = 0;
                this.playTimes = 1;
                this.stayTick = 40;
                break;
            }
            case 24: {
                this.particleIconX = 0.75f;
                this.particleIconY = 0.6875f;
                this.particleMaxAge = 0;
                this.playTimes = 1;
                this.stayTick = 40;
                break;
            }
            case 25: {
                this.particleIconX = 0.75f;
                this.particleIconY = 0.75f;
                this.particleMaxAge = 0;
                this.playTimes = 1;
                this.stayTick = 40;
                break;
            }
            case 26: {
                this.particleIconX = 0.75f;
                this.particleIconY = 0.8125f;
                this.particleMaxAge = 0;
                this.playTimes = 1;
                this.stayTick = 40;
                break;
            }
            case 27: {
                this.particleIconX = 0.75f;
                this.particleIconY = 0.875f;
                this.particleMaxAge = 0;
                this.playTimes = 1;
                this.stayTick = 40;
                break;
            }
            case 28: {
                this.particleIconX = 0.75f;
                this.particleIconY = 0.9375f;
                this.particleMaxAge = 0;
                this.playTimes = 1;
                this.stayTick = 40;
                break;
            }
            case 29: {
                this.particleIconX = 0.8125f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 7;
                this.playTimes = 1;
                this.fadeTick = 3;
                this.playSpeed = 0.35f;
                this.stayTick = 20;
                break;
            }
            case 30: {
                this.particleIconX = 0.8125f;
                this.particleIconY = 0.5f;
                this.particleMaxAge = 7;
                this.playTimes = 1;
                this.fadeTick = 3;
                this.playSpeed = 0.75f;
                this.stayTick = 3;
                break;
            }
            case 31: {
                this.particleIconX = 0.875f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 3;
                this.particleScale += 0.2f;
                this.playTimes = 1;
                this.fadeTick = 3;
                this.playSpeed = 0.75f;
                this.stayTick = 30;
                break;
            }
            case 32: {
                this.particleIconX = 0.875f;
                this.particleIconY = 0.25f;
                this.particleMaxAge = 5;
                this.playTimes = 4;
                this.playSpeed = 0.75f;
                this.stayTick = 0;
                break;
            }
            case 33: {
                this.particleIconX = 0.875f;
                this.particleIconY = 0.625f;
                this.particleMaxAge = 4;
                this.playTimes = 1;
                this.playSpeed = 0.25f;
                this.stayTick = 30;
                break;
            }
            case 34: {
                this.particleIconX = 0.875f;
                this.particleIconY = 0.9375f;
                this.particleMaxAge = 0;
                this.particleScale += 0.3f;
                this.playTimes = 1;
                this.stayTick = 50;
                break;
            }
            default: {
                this.particleIconX = 0.0f;
                this.particleIconY = 0.0f;
                this.particleMaxAge = 15;
                this.playTimes = 1;
            }
        }
        this.px = posX;
        this.py = posY;
        this.pz = posZ;
        this.addx = 0.0;
        this.addy = 0.0;
        this.addz = 0.0;
        this.calcParticlePosition();
    }

    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float rotX, float rotZ, float rotYZ, float rotXY, float rotXZ) {
        if (this.particleAge < 0) {
            return;
        }
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
        GlStateManager.pushMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableLighting();
        int age = Math.min(this.particleAge, this.particleMaxAge);
        float f6 = this.particleIconX;
        float f7 = f6 + 0.0625f;
        float f8 = this.particleIconY + age * 0.0625f;
        float f9 = f8 + 0.0625f * this.frameSize;
        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * ptick - interpPosX);
        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * ptick - interpPosY);
        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * ptick - interpPosZ);
        render.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        render.pos(f11 - rotX * this.particleScale - rotXY * this.particleScale, f12 - rotZ * this.particleScale * this.frameSize, f13 - rotYZ * this.particleScale - rotXZ * this.particleScale).tex(f7, f9).color(1.0f, 1.0f, 1.0f, this.particleAlpha).endVertex();
        render.pos(f11 - rotX * this.particleScale + rotXY * this.particleScale, f12 + rotZ * this.particleScale * this.frameSize, f13 - rotYZ * this.particleScale + rotXZ * this.particleScale).tex(f7, f8).color(1.0f, 1.0f, 1.0f, this.particleAlpha).endVertex();
        render.pos(f11 + rotX * this.particleScale + rotXY * this.particleScale, f12 + rotZ * this.particleScale * this.frameSize, f13 + rotYZ * this.particleScale + rotXZ * this.particleScale).tex(f6, f8).color(1.0f, 1.0f, 1.0f, this.particleAlpha).endVertex();
        render.pos(f11 + rotX * this.particleScale - rotXY * this.particleScale, f12 - rotZ * this.particleScale * this.frameSize, f13 + rotYZ * this.particleScale - rotXZ * this.particleScale).tex(f6, f9).color(1.0f, 1.0f, 1.0f, this.particleAlpha).endVertex();
        render.pos(f11 + rotX * this.particleScale - rotXY * this.particleScale, f12 - rotZ * this.particleScale * this.frameSize, f13 + rotYZ * this.particleScale - rotXZ * this.particleScale).tex(f6, f9).color(1.0f, 1.0f, 1.0f, this.particleAlpha).endVertex();
        render.pos(f11 + rotX * this.particleScale + rotXY * this.particleScale, f12 + rotZ * this.particleScale * this.frameSize, f13 + rotYZ * this.particleScale + rotXZ * this.particleScale).tex(f6, f8).color(1.0f, 1.0f, 1.0f, this.particleAlpha).endVertex();
        render.pos(f11 - rotX * this.particleScale + rotXY * this.particleScale, f12 + rotZ * this.particleScale * this.frameSize, f13 - rotYZ * this.particleScale + rotXZ * this.particleScale).tex(f7, f8).color(1.0f, 1.0f, 1.0f, this.particleAlpha).endVertex();
        render.pos(f11 - rotX * this.particleScale - rotXY * this.particleScale, f12 - rotZ * this.particleScale * this.frameSize, f13 - rotYZ * this.particleScale - rotXZ * this.particleScale).tex(f7, f9).color(1.0f, 1.0f, 1.0f, this.particleAlpha).endVertex();
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
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.host != null) {
            this.updateHostPosition();
        }
        switch (this.fadeState) {
            case 0: {
                ++this.fadeTick;
                this.particleAlpha = this.fadeTick * 0.2f;
                if (this.fadeTick <= 5) break;
                this.fadeState = 1;
                break;
            }
            case 1: {
                this.playSpeedCount += this.playSpeed;
                this.particleAge = this.frameSize * (int)this.playSpeedCount;
                this.particleAlpha = 1.0f;
                break;
            }
            case 2: {
                --this.fadeTick;
                this.particleAlpha = this.fadeTick * 0.2f;
                if (this.fadeTick >= 1) break;
                this.setExpired();
                return;
            }
            default: {
                this.setExpired();
                return;
            }
        }
        if (this.particleAge >= this.particleMaxAge) {
            this.particleAge = this.particleMaxAge;
            if (this.stayTickCount > this.stayTick) {
                this.particleAge = this.particleMaxAge + 1;
                this.stayTickCount = 0;
            } else {
                ++this.stayTickCount;
            }
        }
        if (this.particleAge > this.particleMaxAge) {
            if (--this.playTimes <= 0) {
                this.fadeState = 2;
            } else {
                this.particleAge = 0;
                this.playSpeedCount = 0.0f;
            }
        }
    }

    private void updateHostPosition() {
        if (this.host != null) {
            this.posX = this.host.posX + this.addx;
            this.posY = this.host.posY + this.addy;
            this.posZ = this.host.posZ + this.addz;
        }
    }

    private void calcParticlePosition() {
        float[] newPos;
        if (this.host != null) {
            this.px = this.host.posX;
            this.py = this.host.posY;
            this.pz = this.host.posZ;
        }
        float angle = ClientProxy.getClientPlayer().renderYawOffset % 360.0f * ((float)Math.PI / 180);
        if (this.entType == 1.0f) {
            float frontDist = 0.7f;
            float leftDist = -0.2f;
            switch (this.particleType) {
                case 12: {
                    leftDist = 0.0f;
                    this.addy += 0.6;
                    break;
                }
                case 15: {
                    frontDist = 1.5f;
                    leftDist = -0.7f;
                    break;
                }
                case 19: {
                    frontDist = 1.4f;
                    leftDist = -1.1f;
                    break;
                }
                case 34: {
                    frontDist = -0.2f;
                    leftDist = 0.0f;
                    this.addy -= 0.2;
                    break;
                }
                default:
            }
            newPos = CalcHelper.rotateXZByAxis(frontDist, leftDist, angle, 1.0f);
            this.addx += newPos[1];
            this.addy -= 0.2;
            this.addz += newPos[0];
        } else {
            newPos = CalcHelper.rotateXZByAxis(0.0f, -0.2f, angle, 1.0f);
            this.addx += newPos[1];
            this.addy += 0.5;
            this.addz += newPos[0];
        }
        float addx2 = 0.0f;
        float addy2 = 0.0f;
        float addz2 = 0.0f;
        if (this.addHeight > 2.0f) {
            this.particleScale += 1.0f;
            addx2 = 1.2f;
            addy2 = 1.5f;
            addz2 = 0.5f;
        }
        switch (this.particleType) {
            case 2: {
                newPos = CalcHelper.rotateXZByAxis(-0.2f - addz2, this.rand.nextFloat() * 0.3f - 1.0f - addx2, angle, 1.0f);
                this.addx += newPos[1];
                this.addy = this.addy + this.rand.nextDouble() * this.addHeight * 0.2 + this.addHeight * 1.8 + addy2;
                this.addz += newPos[0];
                break;
            }
            case 15: {
                newPos = CalcHelper.rotateXZByAxis(this.rand.nextFloat() * 0.1f - 0.7f - addx2, this.rand.nextFloat() * 0.1f + 0.2f + addz2, angle, 1.0f);
                this.addx += newPos[1];
                this.addy = this.addy + this.rand.nextDouble() * this.addHeight * 0.2 + this.addHeight * 1.6 + addy2;
                this.addz += newPos[0];
                break;
            }
            case 34: {
                newPos = CalcHelper.rotateXZByAxis(0.15f, 0.0f, angle, 1.0f);
                this.addx += newPos[1];
                this.addy = this.addy + this.rand.nextDouble() * this.addHeight * 0.15 + this.addHeight * 1.9 + addy2;
                this.addz += newPos[0];
                break;
            }
            default: {
                newPos = CalcHelper.rotateXZByAxis(-0.4f - addz2, this.rand.nextFloat() * 0.3f + 0.7f + addx2, angle, 1.0f);
                this.addx += newPos[1];
                this.addy = this.addy + this.rand.nextDouble() * this.addHeight * 0.5 + this.addHeight * 1.5 + addy2;
                this.addz += newPos[0];
            }
        }
        this.setPosition(this.px + this.addx, this.py + this.addy, this.pz + this.addz);
    }
}
