package com.lulan.shincolle.init;

import com.lulan.shincolle.ShinColle;
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
import com.lulan.shincolle.tileentity.*;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModEntity {
    private static int modEntityID = 1;
    public static final String MODID = "shincolle";
    
    private ModEntity() {}

    public static void init() {
        ModEntity.createEntity(EntityAirfieldHime.class, "EntityAirfieldHime", modEntityID++);
        ModEntity.createEntity(EntityBattleshipHime.class, "EntityBattleshipHime", modEntityID++);
        ModEntity.createEntity(EntityBBKongou.class, "EntityBattleshipKongou", modEntityID++);
        ModEntity.createEntity(EntityBBKongouMob.class, "EntityBattleshipKongouMob", modEntityID++);
        ModEntity.createEntity(EntityBBHiei.class, "EntityBattleshipHiei", modEntityID++);
        ModEntity.createEntity(EntityBBHieiMob.class, "EntityBattleshipHieiMob", modEntityID++);
        ModEntity.createEntity(EntityBBHaruna.class, "EntityBattleshipHaruna", modEntityID++);
        ModEntity.createEntity(EntityBBHarunaMob.class, "EntityBattleshipHarunaMob", modEntityID++);
        ModEntity.createEntity(EntityBBKirishima.class, "EntityBattleshipKirishima", modEntityID++);
        ModEntity.createEntity(EntityBBKirishimaMob.class, "EntityBattleshipKirishimaMob", modEntityID++);
        ModEntity.createEntity(EntityBattleshipNGT.class, "EntityBattleshipNGT", modEntityID++);
        ModEntity.createEntity(EntityBattleshipNGTMob.class, "EntityBattleshipNGTMob", modEntityID++);
        ModEntity.createEntity(EntityBattleshipYMT.class, "EntityBattleshipYMT", modEntityID++);
        ModEntity.createEntity(EntityBattleshipYMTMob.class, "EntityBattleshipYMTMob", modEntityID++);
        ModEntity.createEntity(EntityBattleshipRe.class, "EntityBattleshipRe", modEntityID++);
        ModEntity.createEntity(EntityBattleshipRu.class, "EntityBattleshipRu", modEntityID++);
        ModEntity.createEntity(EntityBattleshipTa.class, "EntityBattleshipTa", modEntityID++);
        ModEntity.createEntity(EntityCAHime.class, "EntityCAHime", modEntityID++);
        ModEntity.createEntity(EntityCarrierAkagi.class, "EntityCarrierAkagi", modEntityID++);
        ModEntity.createEntity(EntityCarrierAkagiMob.class, "EntityCarrierAkagiMob", modEntityID++);
        ModEntity.createEntity(EntityCarrierKaga.class, "EntityCarrierKaga", modEntityID++);
        ModEntity.createEntity(EntityCarrierKagaMob.class, "EntityCarrierKagaMob", modEntityID++);
        ModEntity.createEntity(EntityCarrierHime.class, "EntityCarrierHime", modEntityID++);
        ModEntity.createEntity(EntityCarrierWD.class, "EntityCarrierWD", modEntityID++);
        ModEntity.createEntity(EntityCarrierWo.class, "EntityCarrierWo", modEntityID++);
        ModEntity.createEntity(EntityCAAtago.class, "EntityCruiserAtago", modEntityID++);
        ModEntity.createEntity(EntityCAAtagoMob.class, "EntityCruiserAtagoMob", modEntityID++);
        ModEntity.createEntity(EntityCATakao.class, "EntityCruiserTakao", modEntityID++);
        ModEntity.createEntity(EntityCATakaoMob.class, "EntityCruiserTakaoMob", modEntityID++);
        ModEntity.createEntity(EntityCLTenryuu.class, "EntityCruiserTenryuu", modEntityID++);
        ModEntity.createEntity(EntityCLTenryuuMob.class, "EntityCruiserTenryuuMob", modEntityID++);
        ModEntity.createEntity(EntityCLTatsuta.class, "EntityCruiserTatsuta", modEntityID++);
        ModEntity.createEntity(EntityCLTatsutaMob.class, "EntityCruiserTatsutaMob", modEntityID++);
        ModEntity.createEntity(EntityDestroyerI.class, "EntityDestroyerI", modEntityID++);
        ModEntity.createEntity(EntityDestroyerRo.class, "EntityDestroyerRo", modEntityID++);
        ModEntity.createEntity(EntityDestroyerHa.class, "EntityDestroyerHa", modEntityID++);
        ModEntity.createEntity(EntityDestroyerNi.class, "EntityDestroyerNi", modEntityID++);
        ModEntity.createEntity(EntityDestroyerHime.class, "EntityDestroyerHime", modEntityID++);
        ModEntity.createEntity(EntityDestroyerAkatsuki.class, "EntityDestroyerAkatsuki", modEntityID++);
        ModEntity.createEntity(EntityDestroyerAkatsukiMob.class, "EntityDestroyerAkatsukiMob", modEntityID++);
        ModEntity.createEntity(EntityDestroyerHibiki.class, "EntityDestroyerHibiki", modEntityID++);
        ModEntity.createEntity(EntityDestroyerHibikiMob.class, "EntityDestroyerHibikiMob", modEntityID++);
        ModEntity.createEntity(EntityDestroyerIkazuchi.class, "EntityDestroyerIkazuchi", modEntityID++);
        ModEntity.createEntity(EntityDestroyerIkazuchiMob.class, "EntityDestroyerIkazuchiMob", modEntityID++);
        ModEntity.createEntity(EntityDestroyerInazuma.class, "EntityDestroyerInazuma", modEntityID++);
        ModEntity.createEntity(EntityDestroyerInazumaMob.class, "EntityDestroyerInazumaMob", modEntityID++);
        ModEntity.createEntity(EntityDestroyerShimakaze.class, "EntityDestroyerShimakaze", modEntityID++);
        ModEntity.createEntity(EntityDestroyerShimakazeMob.class, "EntityDestroyerShimakazeMob", modEntityID++);
        ModEntity.createEntity(EntityHarbourHime.class, "EntityHarbourHime", modEntityID++);
        ModEntity.createEntity(EntityIsolatedHime.class, "EntityIsolatedHime", modEntityID++);
        ModEntity.createEntity(EntityMidwayHime.class, "EntityMidwayHime", modEntityID++);
        ModEntity.createEntity(EntityCARi.class, "EntityHeavyCruiserRi", modEntityID++);
        ModEntity.createEntity(EntityCANe.class, "EntityHeavyCruiserNe", modEntityID++);
        ModEntity.createEntity(EntityNorthernHime.class, "EntityNorthernHime", modEntityID++);
        ModEntity.createEntity(EntityRensouhou.class, "EntityRensouhou", modEntityID++);
        ModEntity.createEntity(EntityRensouhouMob.class, "EntityRensouhouMob", modEntityID++);
        ModEntity.createEntity(EntityRensouhouS.class, "EntityRensouhouS", modEntityID++);
        ModEntity.createEntity(EntitySubmHime.class, "EntitySubmHime", modEntityID++);
        ModEntity.createEntity(EntitySSNH.class, "EntitySubmNewHime", modEntityID++);
        ModEntity.createEntity(EntitySubmKa.class, "EntitySubmKa", modEntityID++);
        ModEntity.createEntity(EntitySubmYo.class, "EntitySubmYo", modEntityID++);
        ModEntity.createEntity(EntitySubmSo.class, "EntitySubmSo", modEntityID++);
        ModEntity.createEntity(EntitySubmRo500.class, "EntitySubmRo500", modEntityID++);
        ModEntity.createEntity(EntitySubmRo500Mob.class, "EntitySubmRo500Mob", modEntityID++);
        ModEntity.createEntity(EntitySubmU511.class, "EntitySubmU511", modEntityID++);
        ModEntity.createEntity(EntitySubmU511Mob.class, "EntitySubmU511Mob", modEntityID++);
        ModEntity.createEntity(EntityTransportWa.class, "EntityTransportWa", modEntityID++);
        ModEntity.createEntity(EntityMountAfH.class, "EntityMountAfH", modEntityID++);
        ModEntity.createEntity(EntityMountBaH.class, "EntityMountBaH", modEntityID++);
        ModEntity.createEntity(EntityMountCaH.class, "EntityMountCaH", modEntityID++);
        ModEntity.createEntity(EntityMountCaWD.class, "EntityMountCaWD", modEntityID++);
        ModEntity.createEntity(EntityMountHbH.class, "EntityMountHbH", modEntityID++);
        ModEntity.createEntity(EntityMountIsH.class, "EntityMountIsH", modEntityID++);
        ModEntity.createEntity(EntityMountMiH.class, "EntityMountMiH", modEntityID++);
        ModEntity.createEntity(EntityMountSuH.class, "EntityMountSuH", modEntityID++);
        ModEntity.createProjectileEntity(EntityAbyssMissile.class, "EntityAbyssMissile", modEntityID++);
        ModEntity.createProjectileEntity(EntityProjectileBeam.class, "EntityProjectileBeam", modEntityID++);
        ModEntity.createProjectileEntity(EntityProjectileStatic.class, "EntityProjectileStatic", modEntityID++);
        ModEntity.createProjectileEntity(EntityShipFishingHook.class, "EntityShipFishingHook", modEntityID++);
        ModEntity.createProjectileEntity(EntityAirplane.class, "EntityAirplane", modEntityID++);
        ModEntity.createProjectileEntity(EntityAirplaneTakoyaki.class, "EntityAirplaneTakoyaki", modEntityID++);
        ModEntity.createProjectileEntity(EntityAirplaneT.class, "EntityAirplaneT", modEntityID++);
        ModEntity.createProjectileEntity(EntityAirplaneZero.class, "EntityAirplaneZero", modEntityID++);
        ModEntity.createProjectileEntity(EntityAirplaneTMob.class, "EntityAirplaneTMob", modEntityID++);
        ModEntity.createProjectileEntity(EntityAirplaneZeroMob.class, "EntityAirplaneZeroMob", modEntityID++);
        ModEntity.createProjectileEntity(EntityFloatingFort.class, "EntityFloatingFort", modEntityID++);
        ModEntity.createItemEntity(BasicEntityItem.class, "BasicEntityItem", modEntityID++);
        ModEntity.createEntity(EntitySeat.class, "EntitySeat", modEntityID++);
        ModEntity.createEntity(EntityFleetController.class, "EntityFleetController", modEntityID++);

        GameRegistry.registerTileEntity(TileEntityWaypoint.class, new ResourceLocation(MODID, "TileEntityWaypoint"));
        GameRegistry.registerTileEntity(TileEntityVolCore.class, new ResourceLocation(MODID, "TileEntityVolCore"));
        GameRegistry.registerTileEntity(TileEntitySmallShipyard.class, new ResourceLocation(MODID, "TileEntitySmallShipyard"));
        GameRegistry.registerTileEntity(TileMultiPolymetal.class, new ResourceLocation(MODID, "TileMultiPolymetal"));
        GameRegistry.registerTileEntity(TileEntityLightBlock.class, new ResourceLocation(MODID, "TileEntityLightBlock"));
        GameRegistry.registerTileEntity(TileEntityCrane.class, new ResourceLocation(MODID, "TileEntityCrane"));
        GameRegistry.registerTileEntity(TileEntityChair.class, new ResourceLocation(MODID, "TileEntityChair"));
        GameRegistry.registerTileEntity(TileEntityDesk.class, new ResourceLocation(MODID, "TileEntityDesk"));
        GameRegistry.registerTileEntity(TileMultiGrudgeHeavy.class, new ResourceLocation(MODID, "TileMultiLargeShipyard"));
    }

    public static void createEntity(Class entityClass, String entityName, int entityId) {
        LogHelper.debug("DEBUG: register entity: " + entityId + " " + entityClass + " " + entityName);
        EntityRegistry.registerModEntity(new ResourceLocation(MODID, entityName), entityClass, entityName, entityId, ShinColle.instance, 64, 1, true);
    }

    public static void createProjectileEntity(Class entityClass, String entityName, int entityId) {
        EntityRegistry.registerModEntity(new ResourceLocation(MODID, entityName), entityClass, entityName, entityId, ShinColle.instance, 64, 1, true);
    }

    public static void createItemEntity(Class entityClass, String entityName, int entityId) {
        EntityRegistry.registerModEntity(new ResourceLocation(MODID, entityName), entityClass, entityName, entityId, ShinColle.instance, 64, 4, false);
    }
}
