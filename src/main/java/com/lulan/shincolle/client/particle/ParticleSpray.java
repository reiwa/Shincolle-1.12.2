package com.lulan.shincolle.client.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

@SideOnly(value=Side.CLIENT)
public class ParticleSpray
extends Particle {
    private final int ptype;
    private float pScale;
    private double speedLimit;

    public ParticleSpray(World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, int type) {
        super(world, posX, posY, posZ);
        this.ptype = type;
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;
        switch (this.ptype) {
            case 1: {
                this.speedLimit = 0.25;
                this.particleRed = 1.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.particleAlpha = 1.0f;
                this.particleScale *= 1.5f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 40;
                break;
            }
            case 2: {
                this.speedLimit = 0.3;
                this.particleRed = 0.5f;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.particleAlpha = 1.0f;
                this.particleScale *= 1.5f;
                this.pScale = (float)(this.particleScale * motionZ);
                this.particleMaxAge = 40;
                this.motionX = 0.0;
                this.motionZ = 0.0;
                break;
            }
            case 3: {
                this.speedLimit = 0.3;
                this.particleRed = 0.2f;
                this.particleGreen = 1.0f;
                this.particleBlue = 0.6f;
                this.particleAlpha = 0.7f;
                this.particleScale *= 1.5f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 10;
                break;
            }
            case 4: {
                this.speedLimit = 0.3;
                this.particleRed = 1.0f;
                this.particleGreen = 0.0f;
                this.particleBlue = 0.0f;
                this.particleAlpha = 0.8f;
                this.particleScale *= 1.5f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 40;
                break;
            }
            case 5: {
                this.speedLimit = 0.3;
                this.particleRed = 1.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.particleAlpha = 0.5f;
                this.particleScale *= 1.5f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 40;
                break;
            }
            case 6: {
                this.speedLimit = 0.3;
                this.particleRed = 1.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.particleAlpha = 0.5f;
                this.particleScale *= 1.5f;
                this.pScale = 15.0f;
                this.particleMaxAge = 50;
                this.motionY = 0.0;
                break;
            }
            case 7: {
                this.speedLimit = 0.3;
                this.particleRed = 0.7f;
                this.particleGreen = 0.94f;
                this.particleBlue = 1.0f;
                this.particleAlpha = 1.0f;
                this.particleScale *= 1.5f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 40;
                break;
            }
            case 8: {
                this.speedLimit = 0.3;
                this.particleRed = 1.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 0.6f;
                this.particleAlpha = 1.0f;
                this.particleScale *= 3.0f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 20;
                break;
            }
            case 9: {
                this.speedLimit = 0.3;
                this.particleRed = 1.0f;
                this.particleGreen = 0.35f;
                this.particleBlue = 0.0f;
                this.particleAlpha = 0.8f;
                this.particleScale *= 1.5f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 40;
                break;
            }
            case 10: {
                this.speedLimit = 0.3;
                this.particleRed = 0.5f;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.particleAlpha = 0.2f;
                this.particleScale *= 1.5f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 40;
                break;
            }
            case 11: {
                this.speedLimit = 0.3;
                this.particleRed = 1.0f;
                this.particleGreen = 0.0f;
                this.particleBlue = 0.0f;
                this.particleAlpha = 0.2f;
                this.particleScale *= 1.5f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 40;
                break;
            }
            case 12: {
                this.speedLimit = 0.3;
                this.particleRed = 1.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.particleAlpha = 0.5f;
                this.particleScale *= 0.75f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 50;
                break;
            }
            case 13: {
                this.speedLimit = 2.0;
                this.particleRed = 1.0f;
                this.particleGreen = 0.0f;
                this.particleBlue = 0.0f;
                this.particleAlpha = 0.5f;
                this.particleScale *= 3.0f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 100;
                this.setSize(0.0f, 0.0f);
                break;
            }
            case 14: {
                this.speedLimit = 2.0;
                this.particleRed = 0.5f;
                this.particleGreen = 0.0f;
                this.particleBlue = 0.5f;
                this.particleAlpha = 0.5f;
                this.particleScale *= 3.0f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 100;
                this.setSize(0.0f, 0.0f);
                break;
            }
            case 15: {
                this.speedLimit = 0.3;
                this.particleRed = 0.7f;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.particleAlpha = 0.75f;
                this.particleScale *= 1.5f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 40;
                break;
            }
            case 16: {
                this.motionY = 0.0;
                this.speedLimit = 0.25;
                this.particleRed = 1.0f;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.particleAlpha = 1.0f;
                this.pScale = this.particleScale = (float)motionY * 3.0f;
                this.particleMaxAge = 40;
                this.posX += (this.rand.nextDouble() - 0.5) * motionY;
                this.posY += (this.rand.nextDouble() - 0.5) * motionY * 0.15;
                this.posZ += (this.rand.nextDouble() - 0.5) * motionY;
                this.motionX *= 1.5;
                this.motionZ *= 1.5;
                break;
            }
            default: {
                this.speedLimit = 0.3;
                this.particleRed = 1.0f;
                this.particleGreen = 0.0f;
                this.particleBlue = 0.0f;
                this.particleAlpha = 0.7f;
                this.particleScale *= 1.5f;
                this.pScale = 15.0f;
                this.particleMaxAge = 40;
                this.motionY = 0.0;
            }
        }
        double motsq = this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ;
        if (motsq > this.speedLimit * this.speedLimit) {
            motsq = MathHelper.sqrt(motsq);
            this.motionX = this.speedLimit * this.motionX / motsq;
            this.motionY = this.speedLimit * this.motionY / motsq;
            this.motionZ = this.speedLimit * this.motionZ / motsq;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    public ParticleSpray(Entity host, int type, double[] data) {
        super(host.world, host.posX, host.posY, host.posZ);
        this.ptype = type;
        switch (this.ptype) {
            case 1: {
                this.posX = host.posX + host.motionX * 2.0 - host.motionX * 1.5 * data[1];
                this.posY = host.posY + host.motionY * 2.0 - host.motionY * 1.5 * data[1] + 0.5;
                this.posZ = host.posZ + host.motionZ * 2.0 - host.motionZ * 1.5 * data[1];
                this.motionX = -host.motionX * 0.1;
                this.motionY = -host.motionY * 0.1;
                this.motionZ = -host.motionZ * 0.1;
                this.speedLimit = 2.0;
                float velred = 1.4f - (float)data[0];
                if (velred > 1.0f) {
                    velred = 1.0f;
                } else if (velred < 0.0f) {
                    velred = 0.0f;
                }
                this.particleRed = velred;
                this.particleGreen = 1.0f;
                this.particleBlue = 1.0f;
                this.particleAlpha = 0.75f;
                this.particleScale *= 1.5f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 40;
                break;
            }
            case 2: {
                this.posX = host.posX + host.motionX * 2.0 - host.motionX * 1.5 * data[1];
                this.posY = host.posY + host.motionY * 2.0 - host.motionY * 1.5 * data[1] + 0.5;
                this.posZ = host.posZ + host.motionZ * 2.0 - host.motionZ * 1.5 * data[1];
                this.motionX = -host.motionX * 0.1;
                this.motionY = -host.motionY * 0.1;
                this.motionZ = -host.motionZ * 0.1;
                this.speedLimit = 2.0;
                float velgb = ((float)data[0] - 0.2f) * 3.333f;
                if (velgb > 1.0f) {
                    velgb = 1.0f;
                } else if (velgb < 0.0f) {
                    velgb = 0.0f;
                }
                this.particleRed = 1.0f;
                this.particleGreen = velgb;
                this.particleBlue = velgb;
                this.particleAlpha = 0.75f;
                this.particleScale *= 1.5f;
                this.pScale = this.particleScale;
                this.particleMaxAge = 40;
                break;
            }
            default:
        }
        double motsq = this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ;
        if (motsq > this.speedLimit * this.speedLimit) {
            motsq = MathHelper.sqrt(motsq);
            this.motionX = this.speedLimit * this.motionX / motsq;
            this.motionY = this.speedLimit * this.motionY / motsq;
            this.motionZ = this.speedLimit * this.motionZ / motsq;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    @SideOnly(value=Side.CLIENT)
    public int getBrightnessForRender(float ptick) {
        return 240;
    }

    public void renderParticle(BufferBuilder render, Entity entity, float ptick, float rotX, float rotZ, float rotYZ, float rotXY, float rotXZ) {
        if (this.particleAge == 1) {
            return;
        }
        float f6 = (this.particleAge + ptick) / this.particleMaxAge * 32.0f;
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        this.particleScale = this.pScale * f6;
        GlStateManager.pushMatrix();
        GlStateManager.depthMask(false);
        super.renderParticle(render, entity, ptick, rotX, rotZ, rotYZ, rotXY, rotXZ);
        GlStateManager.depthMask(true);
        GlStateManager.popMatrix();
    }

    public AxisAlignedBB checkBoundingBox() {
        double size = 0.1;
        return new AxisAlignedBB(this.posX - size, this.posY - size, this.posZ - size,
                this.posX + size, this.posY + size, this.posZ + size);
    }

    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.setPosition(this.posX, this.posY, this.posZ);
        if (this.particleAge++ > this.particleMaxAge) {
            this.setExpired();
            return;
        }
        switch (this.ptype) {
            case 13: 
            case 14: {
                this.setParticleTextureIndex(7 - this.particleAge * 4 / this.particleMaxAge);
                this.posX += this.motionX;
                this.posY += this.motionY;
                this.posZ += this.motionZ;
                break;
            }
            default: {
                this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
                this.motionX *= 0.96;
                this.motionY *= 0.96;
                this.motionZ *= 0.96;
                List<AxisAlignedBB> collisionBoxes = this.world.getCollisionBoxes(null, this.checkBoundingBox().offset(this.motionX, this.motionY, this.motionZ));
                if (!collisionBoxes.isEmpty()) {
                    this.motionX *= 0.7;
                    this.motionZ *= 0.7;
                }
                this.move(this.motionX, this.motionY, this.motionZ);
            }
        }
    }
}
