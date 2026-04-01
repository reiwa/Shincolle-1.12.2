package com.lulan.shincolle.client.render;

import com.lulan.shincolle.client.model.*;
import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.entity.other.EntityAirplaneTakoyaki;
import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.reference.Values;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class RenderShipEntity
extends RenderBasic {
    public static final ResourceLocation TEX_AP_Wa = new ResourceLocation("shincolle:textures/entity/entitytransportwa.png");
    public static final ModelBase MD_AP_Wa = new ModelTransportWa();
    public static final ResourceLocation TEX_BB_Re = new ResourceLocation("shincolle:textures/entity/entitybattleshipre.png");
    public static final ModelBase MD_BB_Re = new ModelBattleshipRe();
    public static final ResourceLocation TEX_BB_Ru = new ResourceLocation("shincolle:textures/entity/entitybattleshipru.png");
    public static final ModelBase MD_BB_Ru = new ModelBattleshipRu();
    public static final ResourceLocation TEX_BB_Ta = new ResourceLocation("shincolle:textures/entity/entitybattleshipta.png");
    public static final ModelBase MD_BB_Ta = new ModelBattleshipTa();
    public static final ResourceLocation TEX_CA_Ri = new ResourceLocation("shincolle:textures/entity/entityheavycruiserri.png");
    public static final ModelBase MD_CA_Ri = new ModelHeavyCruiserRi();
    public static final ResourceLocation TEX_CA_Ne = new ResourceLocation("shincolle:textures/entity/entityheavycruiserne.png");
    public static final ModelBase MD_CA_Ne = new ModelHeavyCruiserNe();
    public static final ResourceLocation TEX_CV_Wo = new ResourceLocation("shincolle:textures/entity/entitycarrierwo.png");
    public static final ModelBase MD_CV_Wo = new ModelCarrierWo();
    public static final ResourceLocation TEX_DD_I = new ResourceLocation("shincolle:textures/entity/entitydestroyeri.png");
    public static final ModelBase MD_DD_I = new ModelDestroyerI();
    public static final ResourceLocation TEX_DD_Ro = new ResourceLocation("shincolle:textures/entity/entitydestroyerro.png");
    public static final ModelBase MD_DD_Ro = new ModelDestroyerRo();
    public static final ResourceLocation TEX_DD_Ha = new ResourceLocation("shincolle:textures/entity/entitydestroyerha.png");
    public static final ModelBase MD_DD_Ha = new ModelDestroyerHa();
    public static final ResourceLocation TEX_DD_Ni = new ResourceLocation("shincolle:textures/entity/entitydestroyerni.png");
    public static final ModelBase MD_DD_Ni = new ModelDestroyerNi();
    public static final ResourceLocation TEX_Hime_Airfield = new ResourceLocation("shincolle:textures/entity/entityairfieldhime.png");
    public static final ModelBase MD_Hime_Airfield = new ModelAirfieldHime();
    public static final ResourceLocation TEX_Hime_Battleship = new ResourceLocation("shincolle:textures/entity/entitybattleshiphime.png");
    public static final ModelBase MD_Hime_Battleship = new ModelBattleshipHime();
    public static final ResourceLocation TEX_Hime_Destroyer = new ResourceLocation("shincolle:textures/entity/entitydestroyerhime.png");
    public static final ModelBase MD_Hime_Destroyer = new ModelDestroyerHime();
    public static final ResourceLocation TEX_Hime_Carrier = new ResourceLocation("shincolle:textures/entity/entitycarrierhime.png");
    public static final ModelBase MD_Hime_Carrier = new ModelCarrierHime();
    public static final ResourceLocation TEX_Hime_CA = new ResourceLocation("shincolle:textures/entity/entitycahime.png");
    public static final ModelBase MD_Hime_CA = new ModelCAHime();
    public static final ResourceLocation TEX_Hime_Harbour = new ResourceLocation("shincolle:textures/entity/entityharbourhime.png");
    public static final ModelBase MD_Hime_Harbour = new ModelHarbourHime();
    public static final ResourceLocation TEX_Hime_Isolated = new ResourceLocation("shincolle:textures/entity/entityisolatedhime.png");
    public static final ModelBase MD_Hime_Isolated = new ModelIsolatedHime();
    public static final ResourceLocation TEX_Hime_Midway = new ResourceLocation("shincolle:textures/entity/entitymidwayhime.png");
    public static final ModelBase MD_Hime_Midway = new ModelMidwayHime();
    public static final ResourceLocation TEX_Hime_Northern = new ResourceLocation("shincolle:textures/entity/entitynorthernhime.png");
    public static final ModelBase MD_Hime_Northern = new ModelNorthernHime();
    public static final ResourceLocation TEX_Hime_Subm = new ResourceLocation("shincolle:textures/entity/entitysubmhime.png");
    public static final ModelBase MD_Hime_Subm = new ModelSubmHime();
    public static final ResourceLocation TEX_Hime_SubmNew = new ResourceLocation("shincolle:textures/entity/entitysubmhimenew.png");
    public static final ModelBase MD_Hime_SubmNew = new ModelSSNH();
    public static final ResourceLocation TEX_SS_Ka = new ResourceLocation("shincolle:textures/entity/entitysubmka.png");
    public static final ModelBase MD_SS_Ka = new ModelSubmKa();
    public static final ResourceLocation TEX_SS_Yo = new ResourceLocation("shincolle:textures/entity/entitysubmyo.png");
    public static final ModelBase MD_SS_Yo = new ModelSubmYo();
    public static final ResourceLocation TEX_SS_So = new ResourceLocation("shincolle:textures/entity/entitysubmso.png");
    public static final ModelBase MD_SS_So = new ModelSubmSo();
    public static final ResourceLocation TEX_WD_Carrier = new ResourceLocation("shincolle:textures/entity/entitycarrierwdemon.png");
    public static final ModelBase MD_WD_Carrier = new ModelCarrierWDemon();
    public static final ResourceLocation TEX_BB_Nagato = new ResourceLocation("shincolle:textures/entity/entitybattleshipnagato.png");
    public static final ModelBase MD_BB_Nagato = new ModelBattleshipNagato();
    public static final ResourceLocation TEX_BB_Yamato = new ResourceLocation("shincolle:textures/entity/entitybattleshipyamato.png");
    public static final ModelBase MD_BB_Yamato = new ModelBattleshipYamato();
    public static final ResourceLocation TEX_BB_Kongou = new ResourceLocation("shincolle:textures/entity/entitybbkongou.png");
    public static final ModelBase MD_BB_Kongou = new ModelBBKongou();
    public static final ResourceLocation TEX_BB_Hiei = new ResourceLocation("shincolle:textures/entity/entitybbhiei.png");
    public static final ModelBase MD_BB_Hiei = new ModelBBHiei();
    public static final ResourceLocation TEX_BB_Haruna = new ResourceLocation("shincolle:textures/entity/entitybbharuna.png");
    public static final ModelBase MD_BB_Haruna = new ModelBBHaruna();
    public static final ResourceLocation TEX_BB_Kirishima = new ResourceLocation("shincolle:textures/entity/entitybbkirishima.png");
    public static final ModelBase MD_BB_Kirishima = new ModelBBKirishima();
    public static final ResourceLocation TEX_CV_Akagi = new ResourceLocation("shincolle:textures/entity/entitycarrierakagi.png");
    public static final ModelBase MD_CV_Akagi = new ModelCarrierAkagi();
    public static final ResourceLocation TEX_CV_Kaga = new ResourceLocation("shincolle:textures/entity/entitycarrierkaga.png");
    public static final ModelBase MD_CV_Kaga = new ModelCarrierKaga();
    public static final ResourceLocation TEX_CL_Tenryuu = new ResourceLocation("shincolle:textures/entity/entitycruisertenryuu.png");
    public static final ModelBase MD_CL_Tenryuu = new ModelCruiserTenryuu();
    public static final ResourceLocation TEX_CL_Tatsuta = new ResourceLocation("shincolle:textures/entity/entitycruisertatsuta.png");
    public static final ModelBase MD_CL_Tatsuta = new ModelCruiserTatsuta();
    public static final ResourceLocation TEX_CA_Atago = new ResourceLocation("shincolle:textures/entity/entitycruiseratago.png");
    public static final ModelBase MD_CA_Atago = new ModelCruiserAtago();
    public static final ResourceLocation TEX_CA_Takao = new ResourceLocation("shincolle:textures/entity/entitycruisertakao.png");
    public static final ModelBase MD_CA_Takao = new ModelCruiserTakao();
    public static final ResourceLocation TEX_DD_Akatsuki = new ResourceLocation("shincolle:textures/entity/entitydestroyerakatsuki.png");
    public static final ModelBase MD_DD_Akatsuki = new ModelDestroyerAkatsuki();
    public static final ResourceLocation TEX_DD_Hibiki = new ResourceLocation("shincolle:textures/entity/entitydestroyerhibiki.png");
    public static final ModelBase MD_DD_Hibiki = new ModelDestroyerHibiki();
    public static final ResourceLocation TEX_DD_Ikazuchi = new ResourceLocation("shincolle:textures/entity/entitydestroyerikazuchi.png");
    public static final ModelBase MD_DD_Ikazuchi = new ModelDestroyerIkazuchi();
    public static final ResourceLocation TEX_DD_Inazuma = new ResourceLocation("shincolle:textures/entity/entitydestroyerinazuma.png");
    public static final ModelBase MD_DD_Inazuma = new ModelDestroyerInazuma();
    public static final ResourceLocation TEX_DD_Shimakaze = new ResourceLocation("shincolle:textures/entity/entitydestroyershimakaze.png");
    public static final ModelBase MD_DD_Shimakaze = new ModelDestroyerShimakaze();
    public static final ResourceLocation TEX_SS_Ro500 = new ResourceLocation("shincolle:textures/entity/entitysubmro500.png");
    public static final ModelBase MD_SS_Ro500 = new ModelSubmRo500();
    public static final ResourceLocation TEX_SS_U511 = new ResourceLocation("shincolle:textures/entity/entitysubmu511.png");
    public static final ModelBase MD_SS_U511 = new ModelSubmU511();
    public static final FactoryDefault FACTORY_SHIP = new FactoryDefault();

    public RenderShipEntity(RenderManager rm) {
        super(rm);
        this.addLayer(new LayerShipHeldItem(this));
    }

    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityLiving entity) {
        switch (this.shipClass) {
            case 16: {
                return TEX_AP_Wa;
            }
            case 13: {
                return TEX_BB_Ru;
            }
            case 14: {
                return TEX_BB_Ta;
            }
            case 15: {
                return TEX_BB_Re;
            }
            case 9: {
                return TEX_CA_Ri;
            }
            case 10: {
                return TEX_CA_Ne;
            }
            case 12: {
                return TEX_CV_Wo;
            }
            case 0: {
                return TEX_DD_I;
            }
            case 1: {
                return TEX_DD_Ro;
            }
            case 2: {
                return TEX_DD_Ha;
            }
            case 3: {
                return TEX_DD_Ni;
            }
            case 21: {
                return TEX_Hime_Airfield;
            }
            case 26: {
                return TEX_Hime_Battleship;
            }
            case 27: {
                return TEX_Hime_Destroyer;
            }
            case 20: {
                return TEX_Hime_Carrier;
            }
            case 49: {
                return TEX_Hime_CA;
            }
            case 28: {
                return TEX_Hime_Harbour;
            }
            case 29: {
                return TEX_Hime_Isolated;
            }
            case 30: {
                return TEX_Hime_Midway;
            }
            case 31: {
                return TEX_Hime_Northern;
            }
            case 44: {
                return TEX_Hime_Subm;
            }
            case 72: {
                return TEX_Hime_SubmNew;
            }
            case 17: {
                return TEX_SS_Ka;
            }
            case 19: {
                return TEX_SS_So;
            }
            case 18: {
                return TEX_SS_Yo;
            }
            case 33: {
                return TEX_WD_Carrier;
            }
            case 37: {
                return TEX_BB_Nagato;
            }
            case 46: {
                return TEX_BB_Yamato;
            }
            case 60: {
                return TEX_BB_Kongou;
            }
            case 61: {
                return TEX_BB_Hiei;
            }
            case 62: {
                return TEX_BB_Haruna;
            }
            case 63: {
                return TEX_BB_Kirishima;
            }
            case 48: {
                return TEX_CV_Akagi;
            }
            case 47: {
                return TEX_CV_Kaga;
            }
            case 56: {
                return TEX_CL_Tenryuu;
            }
            case 57: {
                return TEX_CL_Tatsuta;
            }
            case 58: {
                return TEX_CA_Atago;
            }
            case 59: {
                return TEX_CA_Takao;
            }
            case 51: {
                return TEX_DD_Akatsuki;
            }
            case 52: {
                return TEX_DD_Hibiki;
            }
            case 53: {
                return TEX_DD_Ikazuchi;
            }
            case 54: {
                return TEX_DD_Inazuma;
            }
            case 36: {
                return TEX_DD_Shimakaze;
            }
            case 39: {
                return TEX_SS_Ro500;
            }
            case 38: {
                return TEX_SS_U511;
            }
            default:
        }
        return TEX_DD_I;
    }

    @Override
    protected void setModel() {
        switch (this.shipClass) {
            case 16: {
                this.mainModel = MD_AP_Wa;
                break;
            }
            case 13: {
                this.mainModel = MD_BB_Ru;
                break;
            }
            case 14: {
                this.mainModel = MD_BB_Ta;
                break;
            }
            case 15: {
                this.mainModel = MD_BB_Re;
                break;
            }
            case 9: {
                this.mainModel = MD_CA_Ri;
                break;
            }
            case 10: {
                this.mainModel = MD_CA_Ne;
                break;
            }
            case 12: {
                this.mainModel = MD_CV_Wo;
                break;
            }
            case 0: {
                this.mainModel = MD_DD_I;
                break;
            }
            case 1: {
                this.mainModel = MD_DD_Ro;
                break;
            }
            case 2: {
                this.mainModel = MD_DD_Ha;
                break;
            }
            case 3: {
                this.mainModel = MD_DD_Ni;
                break;
            }
            case 21: {
                this.mainModel = MD_Hime_Airfield;
                break;
            }
            case 26: {
                this.mainModel = MD_Hime_Battleship;
                break;
            }
            case 27: {
                this.mainModel = MD_Hime_Destroyer;
                break;
            }
            case 20: {
                this.mainModel = MD_Hime_Carrier;
                break;
            }
            case 49: {
                this.mainModel = MD_Hime_CA;
                break;
            }
            case 28: {
                this.mainModel = MD_Hime_Harbour;
                break;
            }
            case 29: {
                this.mainModel = MD_Hime_Isolated;
                break;
            }
            case 30: {
                this.mainModel = MD_Hime_Midway;
                break;
            }
            case 31: {
                this.mainModel = MD_Hime_Northern;
                break;
            }
            case 44: {
                this.mainModel = MD_Hime_Subm;
                break;
            }
            case 72: {
                this.mainModel = MD_Hime_SubmNew;
                break;
            }
            case 17: {
                this.mainModel = MD_SS_Ka;
                break;
            }
            case 19: {
                this.mainModel = MD_SS_So;
                break;
            }
            case 18: {
                this.mainModel = MD_SS_Yo;
                break;
            }
            case 33: {
                this.mainModel = MD_WD_Carrier;
                break;
            }
            case 37: {
                this.mainModel = MD_BB_Nagato;
                break;
            }
            case 46: {
                this.mainModel = MD_BB_Yamato;
                break;
            }
            case 60: {
                this.mainModel = MD_BB_Kongou;
                break;
            }
            case 61: {
                this.mainModel = MD_BB_Hiei;
                break;
            }
            case 62: {
                this.mainModel = MD_BB_Haruna;
                break;
            }
            case 63: {
                this.mainModel = MD_BB_Kirishima;
                break;
            }
            case 48: {
                this.mainModel = MD_CV_Akagi;
                break;
            }
            case 47: {
                this.mainModel = MD_CV_Kaga;
                break;
            }
            case 56: {
                this.mainModel = MD_CL_Tenryuu;
                break;
            }
            case 57: {
                this.mainModel = MD_CL_Tatsuta;
                break;
            }
            case 58: {
                this.mainModel = MD_CA_Atago;
                break;
            }
            case 59: {
                this.mainModel = MD_CA_Takao;
                break;
            }
            case 51: {
                this.mainModel = MD_DD_Akatsuki;
                break;
            }
            case 52: {
                this.mainModel = MD_DD_Hibiki;
                break;
            }
            case 53: {
                this.mainModel = MD_DD_Ikazuchi;
                break;
            }
            case 54: {
                this.mainModel = MD_DD_Inazuma;
                break;
            }
            case 36: {
                this.mainModel = MD_DD_Shimakaze;
                break;
            }
            case 39: {
                this.mainModel = MD_SS_Ro500;
                break;
            }
            case 38: {
                this.mainModel = MD_SS_U511;
                break;
            }
            default: {
                this.mainModel = MD_DD_I;
            }
        }
    }

    @Override
    protected void setMiscModel() {
        if(this.shipClass == 30){
            this.miscModelList = new ArrayList<>();
            EntityAirplaneTakoyaki tako1 = new EntityAirplaneTakoyaki(ClientProxy.getClientWorld());
            tako1.posX = 0.0;
            tako1.posY = 0.0;
            tako1.posZ = 0.0;
            MiscModel m1 = new MiscModel(tako1, RenderSummonEntity.MD_AirplaneTako, RenderSummonEntity.TEX_AirplaneTako);
            this.miscModelList.add(m1);
            ((ModelMidwayHime)RenderShipEntity.MD_Hime_Midway).miscModelList = this.miscModelList;
            m1.scale = new Vec3d(0.65, 0.65, 0.65);
            m1.rotX = -30.0f;
            m1.entity.posX = 0.0;
            m1.entity.posY = 0.34;
            m1.entity.posZ = -0.18;
        }
    }

    @Override
    protected void setShadowSize() {
        switch (this.shipClass) {
            case 17: 
            case 18: 
            case 19: 
            case 31: 
            case 36: 
            case 38: 
            case 39: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 72: {
                this.shadowSize = 0.5f;
                break;
            }
            case 27: 
            case 56: 
            case 57: {
                this.shadowSize = 0.6f;
                break;
            }
            case 28: 
            case 30: {
                this.shadowSize = 0.8f;
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                this.shadowSize = 0.9f;
                break;
            }
            case 12: {
                this.shadowSize = 1.0f;
                break;
            }
            default: {
                this.shadowSize = 0.7f;
            }
        }
    }

    @Override
    protected boolean hasMiscModel() {
        return this.shipClass == 30;
    }

    protected float[] getLeashHeight() {
        float[] f = Values.ShipLeashHeight.get(this.shipClass);
        if (f == null) {
            return new float[]{0.8f, 0.8f, 0.8f, 0.8f, 0.8f};
        }
        return f;
    }

    protected void renderLeash(EntityLiving host, double x, double y, double z, float yaw, float parTick) {
        Entity entity = host.getLeashHolder();
        if(entity == null){
            return;
        }
        float[] leashHeight = this.getLeashHeight();
        IShipEmotion host1 = (IShipEmotion)host;
        y = host1.getIsRiding() ? (host1.getIsSitting() ? (y -= (1.6 - host.height) * 0.5 + leashHeight[2]) : (y -= (1.6 - host.height) * 0.5 + leashHeight[1])) : (host1.getIsSitting() ? (y -= (1.6 - host.height) * 0.5 + leashHeight[3]) : (y -= (1.6 - host.height) * 0.5 + leashHeight[4]));
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder BufferBuilder = tessellator.getBuffer();
        double d3 = this.interp(entity.prevRotationYaw, entity.rotationYaw, parTick * 0.5f) * 0.01745329238474369;
        double d4 = this.interp(entity.prevRotationPitch, entity.rotationPitch, parTick * 0.5f) * 0.01745329238474369;
        double d5 = Math.cos(d3);
        double d6 = Math.sin(d3);
        double d7 = Math.sin(d4);
        if (entity instanceof EntityHanging) {
            d5 = 0.0;
            d6 = 0.0;
            d7 = -1.0;
        }
        double d8 = Math.cos(d4);
        double d9 = this.interp(entity.prevPosX, entity.posX, parTick) - d5 * 0.7 - d6 * 0.5 * d8;
        double d10 = this.interp(entity.prevPosY + entity.getEyeHeight() * 0.7, entity.posY + entity.getEyeHeight() * 0.7, parTick) - d7 * 0.5 - 0.25;
        double d11 = this.interp(entity.prevPosZ, entity.posZ, parTick) - d6 * 0.7 + d5 * 0.5 * d8;
        double d12 = this.interp(host.prevRenderYawOffset, host.renderYawOffset, parTick) * 0.01745329238474369 + 1.5707963267948966;
        d5 = Math.cos(d12) * host.width * leashHeight[0];
        d6 = Math.sin(d12) * host.width * leashHeight[0];
        double d13 = this.interp(host.prevPosX, host.posX, parTick) + d5;
        double d14 = this.interp(host.prevPosY, host.posY, parTick);
        double d15 = this.interp(host.prevPosZ, host.posZ, parTick) + d6;
        x += d5;
        z += d6;
        double d16 = (float)(d9 - d13);
        double d17 = (float)(d10 - d14);
        double d18 = (float)(d11 - d15);
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        BufferBuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);
        for (int j = 0; j <= 24; ++j) {
            float f = 0.5f;
            float f1 = 0.4f;
            float f2 = 0.3f;
            if (j % 2 == 0) {
                f *= 0.7f;
                f1 *= 0.7f;
                f2 *= 0.7f;
            }
            float f3 = j / 24.0f;
            BufferBuilder.pos(x + d16 * f3 + 0.0, y + d17 * (f3 * f3 + f3) * 0.5 + ((24.0f - j) / 18.0f + 0.125f), z + d18 * f3).color(f, f1, f2, 1.0f).endVertex();
            BufferBuilder.pos(x + d16 * f3 + 0.025, y + d17 * (f3 * f3 + f3) * 0.5 + ((24.0f - j) / 18.0f + 0.125f) + 0.025, z + d18 * f3).color(f, f1, f2, 1.0f).endVertex();
        }
        tessellator.draw();
        BufferBuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);
        for (int k = 0; k <= 24; ++k) {
            float f4 = 0.5f;
            float f5 = 0.4f;
            float f6 = 0.3f;
            if (k % 2 == 0) {
                f4 *= 0.7f;
                f5 *= 0.7f;
                f6 *= 0.7f;
            }
            float f7 = k / 24.0f;
            BufferBuilder.pos(x + d16 * f7 + 0.0, y + d17 * (f7 * f7 + f7) * 0.5 + ((24.0f - k) / 18.0f + 0.125f) + 0.025, z + d18 * f7).color(f4, f5, f6, 1.0f).endVertex();
            BufferBuilder.pos(x + d16 * f7 + 0.025, y + d17 * (f7 * f7 + f7) * 0.5 + ((24.0f - k) / 18.0f + 0.125f), z + d18 * f7 + 0.025).color(f4, f5, f6, 1.0f).endVertex();
        }
        tessellator.draw();
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
        GlStateManager.enableCull();
    }

    protected float getDeathMaxRotation(EntityLiving entityLivingBaseIn) {
        return 0.0f;
    }

    public static class FactoryDefault
    implements IRenderFactory<EntityLiving> {
        public Render<? super EntityLiving> createRenderFor(RenderManager rm) {
            return new RenderShipEntity(rm);
        }
    }
}
