package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.utility.EmotionHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHandSide;

public abstract class ShipModelBaseAdv
extends ModelBase
implements IModelEmotionAdv {
    protected float scale = 1.0f;
    protected float offsetY = 0.0f;
    public ModelRenderer Face0;
    public ModelRenderer Face1;
    public ModelRenderer Face2;
    public ModelRenderer Face3;
    public ModelRenderer Face4;
    public ModelRenderer Mouth0;
    public ModelRenderer Mouth1;
    public ModelRenderer Mouth2;
    public ModelRenderer Flush0;
    public ModelRenderer Flush1;
    protected float[] offsetItem = new float[]{0.0f, 0.0f, 0.0f};
    protected float[] rotateItem = new float[]{0.0f, 0.0f, 0.0f};
    protected float[] offsetBlock = new float[]{0.0f, 0.0f, 0.0f};
    protected float[] rotateBlock = new float[]{0.0f, 0.0f, 0.0f};
    protected ModelRenderer[] armMain;
    protected ModelRenderer[] armOff;

    protected void setDefaultFaceModel() {
        this.Face0 = new ModelRenderer(this, 98, 63);
        this.Face0.setRotationPoint(0.0f, -12.2f, -6.1f);
        this.Face0.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Face1 = new ModelRenderer(this, 98, 76);
        this.Face1.setRotationPoint(0.0f, -12.2f, -6.1f);
        this.Face1.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Face2 = new ModelRenderer(this, 98, 89);
        this.Face2.setRotationPoint(0.0f, -12.2f, -6.1f);
        this.Face2.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Face3 = new ModelRenderer(this, 98, 102);
        this.Face3.setRotationPoint(0.0f, -12.2f, -6.1f);
        this.Face3.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Face4 = new ModelRenderer(this, 98, 115);
        this.Face4.setRotationPoint(0.0f, -12.2f, -6.1f);
        this.Face4.addBox(-7.0f, 0.0f, -0.5f, 14, 12, 1, 0.0f);
        this.Mouth0 = new ModelRenderer(this, 100, 53);
        this.Mouth0.setRotationPoint(0.0f, -4.2f, -6.2f);
        this.Mouth0.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.Mouth1 = new ModelRenderer(this, 100, 58);
        this.Mouth1.setRotationPoint(0.0f, -4.2f, -6.2f);
        this.Mouth1.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.Mouth2 = new ModelRenderer(this, 114, 53);
        this.Mouth2.setRotationPoint(0.0f, -4.2f, -6.2f);
        this.Mouth2.addBox(-3.0f, 0.0f, -0.5f, 6, 4, 1, 0.0f);
        this.Flush0 = new ModelRenderer(this, 114, 58);
        this.Flush0.setRotationPoint(-6.0f, -3.0f, -6.9f);
        this.Flush0.addBox(-1.0f, 0.0f, -0.5f, 2, 1, 0, 0.0f);
        this.Flush1 = new ModelRenderer(this, 114, 58);
        this.Flush1.setRotationPoint(6.0f, -3.0f, -6.9f);
        this.Flush1.addBox(-1.0f, 0.0f, -0.5f, 2, 1, 0, 0.0f);
    }

    public ModelRenderer[] getArmForSide(EnumHandSide side) {
        return side == EnumHandSide.RIGHT ? this.armMain : this.armOff;
    }

    public float[] getHeldItemOffset(IShipEmotion ent, EnumHandSide side, int type) {
        return type == 0 ? this.offsetItem : this.offsetBlock;
    }

    public float[] getHeldItemRotate(IShipEmotion ent, EnumHandSide side, int type) {
        return type == 0 ? this.rotateItem : this.rotateBlock;
    }

    public float getOffsetY() {
        return this.offsetY;
    }

    public float getScale() {
        return this.scale;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float swingTick, float swingAmount, float tick, float yaw, float pitch, float scale, Entity entity) {
        super.setRotationAngles(swingTick, swingAmount, tick, yaw, pitch, scale, entity);
        IShipEmotion ent = (IShipEmotion)entity;
        this.showEquip(ent);
        this.setFlush(ent.getStateMinor(30) > 3900);
        EmotionHelper.rollEmotionAdv(this, ent);
        if (ent.getStateFlag(2)) {
            this.applyDeadPose(swingTick, swingAmount, tick, yaw, pitch, ent);
        } else {
            this.applyNormalPose(swingTick, swingAmount, tick, yaw, pitch, ent);
        }
        this.syncRotationGlowPart();
    }

    @Override
    public void setFace(int emo) {
        switch (emo) {
            case 0: {
                this.Face0.isHidden = false;
                this.Face0.rotateAngleY = 0.0f;
                this.Face1.isHidden = true;
                this.Face2.isHidden = true;
                this.Face3.isHidden = true;
                this.Face4.isHidden = true;
                break;
            }
            case 1: {
                this.Face0.isHidden = true;
                this.Face1.isHidden = false;
                this.Face1.rotateAngleY = 0.0f;
                this.Face2.isHidden = true;
                this.Face3.isHidden = true;
                this.Face4.isHidden = true;
                break;
            }
            case 2: {
                this.Face0.isHidden = true;
                this.Face1.isHidden = true;
                this.Face2.isHidden = false;
                this.Face2.rotateAngleY = 0.0f;
                this.Face3.isHidden = true;
                this.Face4.isHidden = true;
                break;
            }
            case 3: {
                this.Face0.isHidden = true;
                this.Face1.isHidden = true;
                this.Face2.isHidden = true;
                this.Face3.isHidden = false;
                this.Face3.rotateAngleY = 0.0f;
                this.Face4.isHidden = true;
                break;
            }
            case 4: {
                this.Face0.isHidden = true;
                this.Face1.isHidden = true;
                this.Face2.isHidden = true;
                this.Face3.isHidden = true;
                this.Face4.isHidden = false;
                this.Face4.rotateAngleY = 0.0f;
                break;
            }
            case 5: {
                this.Face0.isHidden = false;
                this.Face0.rotateAngleY = 3.14159f;
                this.Face1.isHidden = true;
                this.Face2.isHidden = true;
                this.Face3.isHidden = true;
                this.Face4.isHidden = true;
                break;
            }
            case 6: {
                this.Face0.isHidden = true;
                this.Face1.isHidden = false;
                this.Face1.rotateAngleY = 3.14159f;
                this.Face2.isHidden = true;
                this.Face3.isHidden = true;
                this.Face4.isHidden = true;
                break;
            }
            case 7: {
                this.Face0.isHidden = true;
                this.Face1.isHidden = true;
                this.Face2.isHidden = false;
                this.Face2.rotateAngleY = 3.14159f;
                this.Face3.isHidden = true;
                this.Face4.isHidden = true;
                break;
            }
            case 8: {
                this.Face0.isHidden = true;
                this.Face1.isHidden = true;
                this.Face2.isHidden = true;
                this.Face3.isHidden = false;
                this.Face3.rotateAngleY = 3.14159f;
                this.Face4.isHidden = true;
                break;
            }
            case 9: {
                this.Face0.isHidden = true;
                this.Face1.isHidden = true;
                this.Face2.isHidden = true;
                this.Face3.isHidden = true;
                this.Face4.isHidden = false;
                this.Face4.rotateAngleY = 3.14159f;
                break;
            }
            default:
        }
    }

    @Override
    public void setMouth(int emo) {
        switch (emo) {
            case 0: {
                this.Mouth0.isHidden = false;
                this.Mouth0.rotateAngleY = 0.0f;
                this.Mouth1.isHidden = true;
                this.Mouth2.isHidden = true;
                break;
            }
            case 1: {
                this.Mouth0.isHidden = true;
                this.Mouth1.isHidden = false;
                this.Mouth1.rotateAngleY = 0.0f;
                this.Mouth2.isHidden = true;
                break;
            }
            case 2: {
                this.Mouth0.isHidden = true;
                this.Mouth1.isHidden = true;
                this.Mouth2.isHidden = false;
                this.Mouth2.rotateAngleY = 0.0f;
                break;
            }
            case 3: {
                this.Mouth0.isHidden = false;
                this.Mouth0.rotateAngleY = 3.14159f;
                this.Mouth1.isHidden = true;
                this.Mouth2.isHidden = true;
                break;
            }
            case 4: {
                this.Mouth0.isHidden = true;
                this.Mouth1.isHidden = false;
                this.Mouth1.rotateAngleY = 3.14159f;
                this.Mouth2.isHidden = true;
                break;
            }
            case 5: {
                this.Mouth0.isHidden = true;
                this.Mouth1.isHidden = true;
                this.Mouth2.isHidden = false;
                this.Mouth2.rotateAngleY = 3.14159f;
                break;
            }
            default:
        }
    }

    @Override
    public void setFlush(boolean show) {
        if (show) {
            this.Flush0.isHidden = false;
            this.Flush1.isHidden = false;
        } else {
            this.Flush0.isHidden = true;
            this.Flush1.isHidden = true;
        }
    }

    @Override
    public void setFaceNormal(IShipEmotion ent) {
        this.setFace(0);
        if (ent.getStateEmotion(7) == 4 && (ent.getTickExisted() & 0xFF) > 160) {
            this.setMouth(3);
        } else {
            this.setMouth(0);
        }
    }

    @Override
    public void setFaceBlink0(IShipEmotion ent) {
        this.setFace(0);
    }

    @Override
    public void setFaceBlink1(IShipEmotion ent) {
        this.setFace(1);
    }

    @Override
    public void setFaceCry(IShipEmotion ent) {
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0xFF;
        if (t < 128) {
            this.setFace(6);
            if (t < 64) {
                this.setMouth(5);
            } else {
                this.setMouth(2);
            }
        } else {
            this.setFace(7);
            this.setMouth(2);
        }
    }

    @Override
    public void setFaceAttack(IShipEmotion ent) {
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0x1FF;
        if (t < 128) {
            this.setFace(1);
            if (t < 64) {
                this.setMouth(0);
            } else {
                this.setMouth(2);
            }
        } else if (t < 256) {
            this.setFace(2);
            if (t < 180) {
                this.setMouth(0);
            } else {
                this.setMouth(1);
            }
        } else if (t < 384) {
            this.setFace(3);
            if (t < 320) {
                this.setMouth(0);
            } else {
                this.setMouth(4);
            }
        } else {
            this.setFace(8);
            if (t < 450) {
                this.setMouth(0);
            } else {
                this.setMouth(1);
            }
        }
    }

    @Override
    public void setFaceDamaged(IShipEmotion ent) {
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0x1FF;
        if (t < 200) {
            this.setFace(6);
            if (t < 60) {
                this.setMouth(5);
            } else {
                this.setMouth(2);
            }
        } else if (t < 400) {
            this.setFace(3);
            if (t < 250) {
                this.setMouth(0);
            } else {
                this.setMouth(4);
            }
        } else {
            this.setFace(9);
            if (t < 450) {
                this.setMouth(0);
            } else {
                this.setMouth(1);
            }
        }
    }

    @Override
    public void setFaceScorn(IShipEmotion ent) {
        this.setFace(2);
        this.setMouth(1);
    }

    @Override
    public void setFaceHungry(IShipEmotion ent) {
        this.setFace(4);
        this.setMouth(2);
    }

    @Override
    public void setFaceAngry(IShipEmotion ent) {
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0xFF;
        if (t < 128) {
            this.setFace(1);
            if (t < 64) {
                this.setMouth(0);
            } else {
                this.setMouth(1);
            }
        } else {
            this.setFace(2);
            if (t < 170) {
                this.setMouth(1);
            } else {
                this.setMouth(2);
            }
        }
    }

    @Override
    public void setFaceBored(IShipEmotion ent) {
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0x1FF;
        if (t < 170) {
            this.setFace(5);
            if (t < 80) {
                this.setMouth(0);
            } else {
                this.setMouth(4);
            }
        } else if (t < 340) {
            this.setFace(8);
            this.setMouth(0);
        } else {
            this.setFace(0);
            this.setMouth(0);
        }
    }

    @Override
    public void setFaceShy(IShipEmotion ent) {
        this.setFlush(true);
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0xFF;
        if (t < 140) {
            this.setFace(0);
            if (t < 80) {
                this.setMouth(3);
            } else {
                this.setMouth(2);
            }
        } else {
            this.setFace(8);
            this.setMouth(0);
        }
    }

    @Override
    public void setFaceHappy(IShipEmotion ent) {
        this.setFlush(true);
        int t = ent.getTickExisted() + (ent.getStateMinor(22) << 7) & 0xFF;
        if (t < 140) {
            this.setFace(3);
            if (t < 80) {
                this.setMouth(0);
            } else {
                this.setMouth(4);
            }
        } else {
            this.setFace(8);
            this.setMouth(4);
        }
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void setField(int id, float value) {
    }

    @Override
    public float getField(int id) {
        return 0.0f;
    }

    public boolean shouldRenderMiscModel(int miscID) {
        return false;
    }
}
