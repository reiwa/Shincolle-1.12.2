package com.lulan.shincolle.proxy;

import com.lulan.shincolle.client.render.*;
import com.lulan.shincolle.client.render.item.RenderBasicEntityItem;
import com.lulan.shincolle.client.render.item.RenderTileEntityItem;
import com.lulan.shincolle.entity.battleship.*;
import com.lulan.shincolle.entity.carrier.*;
import com.lulan.shincolle.entity.cruiser.*;
import com.lulan.shincolle.entity.destroyer.*;
import com.lulan.shincolle.entity.hime.*;
import com.lulan.shincolle.entity.mounts.*;
import com.lulan.shincolle.entity.other.*;
import com.lulan.shincolle.entity.submarine.*;
import com.lulan.shincolle.entity.transport.EntityTransportWa;
import com.lulan.shincolle.item.BasicEntityItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.util.Map;

public class ClientProxy
extends CommonProxy {
    public static final ResourceLocation TextureGuiHUD = new ResourceLocation("shincolle:textures/gui/GuiHUD.png");
    public static boolean showMorphSkills = false;
    public static int rideKeys = 0;
    public static int keyMountActionCD = 0;
    public static int keyPlayerSkillCD = 0;
    public static boolean isViewChanged = false;
    public static boolean isViewPlayer = false;
    public static int debugCooldown = 0;
    public static float field1 = 0.0f;
    public static float field2 = 0.0f;
    public static float field3 = 0.0f;
    public static float field4 = 0.0f;
    public static float field5 = 0.0f;
    public static float field6 = 0.0f;

    public static World getClientWorld() {
        return Minecraft.getMinecraft().world;
    }

    public static EntityPlayer getClientPlayer() {
        return Minecraft.getMinecraft().player;
    }

    public static GameSettings getGameSetting() {
        return Minecraft.getMinecraft().gameSettings;
    }

    public static Minecraft getMineraft() {
        return Minecraft.getMinecraft();
    }

    @Override
    public void registerRender() {
        TileEntityItemStackRenderer.instance = new RenderTileEntityItem();
        RenderingRegistry.registerEntityRenderingHandler(BasicEntityItem.class, RenderBasicEntityItem.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityAirfieldHime.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBattleshipHime.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBBKongou.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBBKongouMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBBHiei.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBBHieiMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBBHaruna.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBBHarunaMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBBKirishima.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBBKirishimaMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBattleshipNGT.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBattleshipNGTMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBattleshipYMT.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBattleshipYMTMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBattleshipRu.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBattleshipTa.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityBattleshipRe.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCAHime.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCarrierAkagi.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCarrierAkagiMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCarrierKaga.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCarrierKagaMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCarrierHime.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCarrierWD.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCarrierWo.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCAAtago.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCAAtagoMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCATakao.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCATakaoMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCLTenryuu.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCLTenryuuMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCLTatsuta.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCLTatsutaMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerI.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerRo.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerHa.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerNi.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerHime.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerAkatsuki.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerAkatsukiMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerHibiki.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerHibikiMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerIkazuchi.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerIkazuchiMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerInazuma.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerInazumaMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerShimakaze.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityDestroyerShimakazeMob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityHarbourHime.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityIsolatedHime.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityMidwayHime.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCARi.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityCANe.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityNorthernHime.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityRensouhou.class, RenderSummonEntity.FACTORY_SUMMON);
        RenderingRegistry.registerEntityRenderingHandler(EntityRensouhouMob.class, RenderSummonEntity.FACTORY_SUMMON);
        RenderingRegistry.registerEntityRenderingHandler(EntityRensouhouS.class, RenderSummonEntity.FACTORY_SUMMON);
        RenderingRegistry.registerEntityRenderingHandler(EntitySubmHime.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntitySSNH.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntitySubmKa.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntitySubmYo.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntitySubmSo.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntitySubmRo500.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntitySubmRo500Mob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntitySubmU511.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntitySubmU511Mob.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityTransportWa.class, RenderShipEntity.FACTORY_SHIP);
        RenderingRegistry.registerEntityRenderingHandler(EntityMountAfH.class, RenderMountsEntity.FACTORY_MOUNT);
        RenderingRegistry.registerEntityRenderingHandler(EntityMountBaH.class, RenderMountsEntity.FACTORY_MOUNT);
        RenderingRegistry.registerEntityRenderingHandler(EntityMountCaWD.class, RenderMountsEntity.FACTORY_MOUNT);
        RenderingRegistry.registerEntityRenderingHandler(EntityMountHbH.class, RenderMountsEntity.FACTORY_MOUNT);
        RenderingRegistry.registerEntityRenderingHandler(EntityMountCaH.class, RenderMountsEntity.FACTORY_MOUNT);
        RenderingRegistry.registerEntityRenderingHandler(EntityMountIsH.class, RenderMountsEntity.FACTORY_MOUNT);
        RenderingRegistry.registerEntityRenderingHandler(EntityMountMiH.class, RenderMountsEntity.FACTORY_MOUNT);
        RenderingRegistry.registerEntityRenderingHandler(EntityMountSuH.class, RenderMountsEntity.FACTORY_MOUNT);
        RenderingRegistry.registerEntityRenderingHandler(EntityAbyssMissile.class, RenderMiscEntity.FACTORY_MISC);
        RenderingRegistry.registerEntityRenderingHandler(EntityProjectileBeam.class, RenderMiscEntity.FACTORY_MISC);
        RenderingRegistry.registerEntityRenderingHandler(EntityProjectileStatic.class, RenderMiscEntity.FACTORY_MISC);
        RenderingRegistry.registerEntityRenderingHandler(EntityShipFishingHook.class, RenderShipFishing.FACTORY_FISHINGHOOK);
        RenderingRegistry.registerEntityRenderingHandler(EntityAirplane.class, RenderSummonEntity.FACTORY_SUMMON);
        RenderingRegistry.registerEntityRenderingHandler(EntityAirplaneTakoyaki.class, RenderSummonEntity.FACTORY_SUMMON);
        RenderingRegistry.registerEntityRenderingHandler(EntityAirplaneT.class, RenderSummonEntity.FACTORY_SUMMON);
        RenderingRegistry.registerEntityRenderingHandler(EntityAirplaneZero.class, RenderSummonEntity.FACTORY_SUMMON);
        RenderingRegistry.registerEntityRenderingHandler(EntityAirplaneTMob.class, RenderSummonEntity.FACTORY_SUMMON);
        RenderingRegistry.registerEntityRenderingHandler(EntityAirplaneZeroMob.class, RenderSummonEntity.FACTORY_SUMMON);
        RenderingRegistry.registerEntityRenderingHandler(EntityFloatingFort.class, RenderSummonEntity.FACTORY_SUMMON);
        RenderingRegistry.registerEntityRenderingHandler(EntityFleetController.class, new RenderFleetControllerFactory());
    }

    public static class RenderFleetControllerFactory implements IRenderFactory<EntityFleetController> {
        @Override
        public Render<? super EntityFleetController> createRenderFor(RenderManager manager) {
            return new RenderFleetController(manager);
        }
    }
}
