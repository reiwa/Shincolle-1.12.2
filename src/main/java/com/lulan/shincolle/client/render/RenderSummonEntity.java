package com.lulan.shincolle.client.render;

import com.lulan.shincolle.client.model.*;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;

public class RenderSummonEntity
extends RenderBasic {
    public static final ResourceLocation TEX_Airplane = new ResourceLocation("shincolle:textures/entity/EntityAircraft.png");
    public static ModelBase MD_Airplane = new ModelAirplane();
    public static final ResourceLocation TEX_AirplaneT = new ResourceLocation("shincolle:textures/entity/EntityAirplaneT.png");
    public static ModelBase MD_AirplaneT = new ModelAirplaneT();
    public static final ResourceLocation TEX_AirplaneTako = new ResourceLocation("shincolle:textures/entity/EntityAircraftTakoyaki.png");
    public static ModelBase MD_AirplaneTako = new ModelTakoyaki();
    public static final ResourceLocation TEX_AirplaneZero = new ResourceLocation("shincolle:textures/entity/EntityAirplaneZero.png");
    public static ModelBase MD_AirplaneZero = new ModelAirplaneZero();
    public static final ResourceLocation TEX_FloatingFort = new ResourceLocation("shincolle:textures/entity/EntityFloatingFort.png");
    public static ModelBase MD_FloatingFort = new ModelFloatingFort();
    public static final ResourceLocation TEX_Rensouhou = new ResourceLocation("shincolle:textures/entity/EntityRensouhou.png");
    public static ModelBase MD_Rensouhou = new ModelRensouhou();
    public static final ResourceLocation TEX_RensouhouS = new ResourceLocation("shincolle:textures/entity/EntityRensouhouS.png");
    public static ModelBase MD_RensouhouS = new ModelRensouhouS();
    public static final FactoryDefault FACTORY_SUMMON = new FactoryDefault();

    public RenderSummonEntity(RenderManager rm) {
        super(rm);
    }

    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityLiving entity) {
        switch (this.shipClass) {
            case 1: {
                return TEX_Airplane;
            }
            case 2: {
                return TEX_AirplaneT;
            }
            case 3: {
                return TEX_AirplaneTako;
            }
            case 4: {
                return TEX_AirplaneZero;
            }
            case 5: {
                return TEX_FloatingFort;
            }
            case 6: {
                return TEX_Rensouhou;
            }
            case 7: {
                return TEX_RensouhouS;
            }
            default:
        }
        return TEX_Rensouhou;
    }

    @Override
    protected void setModel() {
        switch (this.shipClass) {
            case 1: {
                this.mainModel = MD_Airplane;
                break;
            }
            case 2: {
                this.mainModel = MD_AirplaneT;
                break;
            }
            case 3: {
                this.mainModel = MD_AirplaneTako;
                break;
            }
            case 4: {
                this.mainModel = MD_AirplaneZero;
                break;
            }
            case 5: {
                this.mainModel = MD_FloatingFort;
                break;
            }
            case 6: {
                this.mainModel = MD_Rensouhou;
                break;
            }
            case 7: {
                this.mainModel = MD_RensouhouS;
                break;
            }
            default: {
                this.mainModel = MD_Rensouhou;
            }
        }
    }

    @Override
    protected void setMiscModel() {
    }

    @Override
    protected void setShadowSize() {
        switch (this.shipClass) {
            case 1: 
            case 4: 
            case 5: {
                this.shadowSize = 0.5f;
                break;
            }
            case 2: 
            case 3: 
            case 6: 
            case 7: {
                this.shadowSize = 0.7f;
                break;
            }
            default: {
                this.shadowSize = 1.0f;
            }
        }
    }

    public static class FactoryDefault
    implements IRenderFactory<EntityLiving> {
        public Render<? super EntityLiving> createRenderFor(RenderManager rm) {
            return new RenderSummonEntity(rm);
        }
    }
}
