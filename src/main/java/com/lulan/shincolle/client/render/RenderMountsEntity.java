package com.lulan.shincolle.client.render;

import com.lulan.shincolle.client.model.*;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;

public class RenderMountsEntity
extends RenderShipEntity {
    public static final ResourceLocation TEX_AirfieldMount = new ResourceLocation("shincolle:textures/entity/EntityMountAfH.png");
    public static final ModelBase MD_AirfieldMount = new ModelMountAfH();
    public static final ResourceLocation TEX_BattleshipMount = new ResourceLocation("shincolle:textures/entity/EntityMountBaH.png");
    public static final ModelBase MD_BattleshipMount = new ModelMountBaH();
    public static final ResourceLocation TEX_CarrierMount = new ResourceLocation("shincolle:textures/entity/EntityMountCaH.png");
    public static final ModelBase MD_CarrierMount = new ModelMountCaH();
    public static final ResourceLocation TEX_CarrierWDMount = new ResourceLocation("shincolle:textures/entity/EntityMountCaWD.png");
    public static final ModelBase MD_CarrierWDMount = new ModelMountCaWD();
    public static final ResourceLocation TEX_HarbourMount = new ResourceLocation("shincolle:textures/entity/EntityMountHbH.png");
    public static final ModelBase MD_HarbourMount = new ModelMountHbH();
    public static final ResourceLocation TEX_IsloatedMount = new ResourceLocation("shincolle:textures/entity/EntityMountIsH.png");
    public static final ModelBase MD_IsloatedMount = new ModelMountIsH();
    public static final ResourceLocation TEX_MidwayMount = new ResourceLocation("shincolle:textures/entity/EntityMountMiH.png");
    public static final ModelBase MD_MidwayMount = new ModelMountMiH();
    public static final ResourceLocation TEX_SubmMount = new ResourceLocation("shincolle:textures/entity/EntityMountSuH.png");
    public static final ModelBase MD_SubmMount = new ModelMountSuH();
    public static final FactoryDefault FACTORY_MOUNT = new FactoryDefault();

    public RenderMountsEntity(RenderManager rm) {
        super(rm);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityLiving entity) {
        switch (this.shipClass) {
            case 8: {
                return TEX_AirfieldMount;
            }
            case 9: {
                return TEX_BattleshipMount;
            }
            case 12: {
                return TEX_CarrierMount;
            }
            case 10: {
                return TEX_CarrierWDMount;
            }
            case 11: {
                return TEX_HarbourMount;
            }
            case 13: {
                return TEX_IsloatedMount;
            }
            case 14: {
                return TEX_MidwayMount;
            }
            case 15: {
                return TEX_SubmMount;
            }
            default:
        }
        return TEX_AirfieldMount;
    }

    @Override
    protected void setModel() {
        switch (this.shipClass) {
            case 8: {
                this.mainModel = MD_AirfieldMount;
                break;
            }
            case 9: {
                this.mainModel = MD_BattleshipMount;
                break;
            }
            case 12: {
                this.mainModel = MD_CarrierMount;
                break;
            }
            case 10: {
                this.mainModel = MD_CarrierWDMount;
                break;
            }
            case 11: {
                this.mainModel = MD_HarbourMount;
                break;
            }
            case 13: {
                this.mainModel = MD_IsloatedMount;
                break;
            }
            case 14: {
                this.mainModel = MD_MidwayMount;
                break;
            }
            case 15: {
                this.mainModel = MD_SubmMount;
                break;
            }
            default: {
                this.mainModel = MD_AirfieldMount;
            }
        }
    }

    @Override
    protected void setShadowSize() {
        this.shadowSize = 1.5f;
    }

    @Override
    protected float[] getLeashHeight() {
        switch (this.shipClass) {
            case 8: {
                return new float[]{0.37f, 0.5f, 0.5f, 0.5f, 0.5f};
            }
            case 9: {
                return new float[]{0.4f, 0.5f, 0.5f, 0.5f, 0.5f};
            }
            case 12: {
                return new float[]{0.45f, 1.05f, 1.05f, 1.05f, 1.05f};
            }
            case 10: {
                return new float[]{0.45f, 1.05f, 1.05f, 1.05f, 1.05f};
            }
            case 11: {
                return new float[]{0.0f, 0.5f, 0.5f, 0.5f, 0.6f};
            }
            case 13: {
                return new float[]{0.45f, 1.05f, 1.05f, 1.05f, 1.05f};
            }
            case 14: {
                return new float[]{0.45f, 1.05f, 1.05f, 1.05f, 1.05f};
            }
            case 15: {
                return new float[]{0.45f, 1.05f, 1.05f, 1.05f, 1.05f};
            }
            default:
        }
        return new float[]{0.8f, 0.8f, 0.8f, 0.8f, 0.8f};
    }

    public static class FactoryDefault
    implements IRenderFactory<EntityLiving> {
        public Render<? super EntityLiving> createRenderFor(RenderManager rm) {
            return new RenderMountsEntity(rm);
        }
    }
}
