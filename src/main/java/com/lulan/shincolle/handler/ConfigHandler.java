package com.lulan.shincolle.handler;

import com.lulan.shincolle.config.ConfigLoot;
import com.lulan.shincolle.config.ConfigMining;
import com.lulan.shincolle.config.ConfigSound;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigHandler {
    public static final String CATE_GENERAL = "general";
    public static final String CATE_SHIP = "ship setting";
    public static final String CATE_WORLD = "world gen";
    public static final String CATE_INTERMOD = "inter-mod";
    public static final String CATE_BUFF = "buff";
    public static Configuration config;
    public static ConfigSound configSound;
    public static ConfigLoot configLoot;
    public static ConfigMining configMining;
    private static Property propShip;
    private static Property propLimitShipAttrs;
    private static Property propMobSpawn;
    private static Property propBossSmall;
    private static Property propBossLarge;
    private static Property propMobSmall;
    private static Property propMobLarge;
    private static Property propGrudgeShip;
    private static Property propGrudgeAction;
    private static Property propAmmoShip;
    private static Property propAtkSpd;
    private static Property propAtkDly;
    private static Property propExp;
    private static Property propExpTask;
    private static Property propShipyardSmall;
    private static Property propShipyardLarge;
    private static Property propVolCore;
    private static Property propRingAbility;
    private static Property propPolyGravel;
    private static Property propHeldItem;
    private static Property propDrumLiquid;
    private static Property propDrumEU;
    private static Property propCrane;
    private static Property propInfLiquid;
    private static Property propShipTeleport;
    private static Property propFishing;
    private static Property propMining;
    private static Property propTask;
    private static Property propGrudgeTask;
    private static Property propPosHUD;
    public static boolean debugMode;
    public static boolean showTag;
    public static boolean friendlyFire;
    public static boolean alwaysShowTeamParticle;
    public static boolean polyAsMn;
    public static boolean vortexDepth;
    public static boolean mobAttackPlayer;
    public static float dropGrudge;
    public static int closeGUIDist;
    public static int bossCooldown;
    public static int teamCooldown;
    public static int despawnBoss;
    public static int despawnMinion;
    public static int despawnEgg;
    public static int kaitaiAmountSmall;
    public static int kaitaiAmountLarge;
    public static int baseCaressMorale;
    public static int nameTagDist;
    public static int spawnBossNum;
    public static int spawnMobNum;
    public static int shipNumPerPage;
    public static int chunkloaderMode;
    public static int deathMaxTick;
    public static int radarUpdate;
    public static int shipAttackPlayer;
    public static int pairDistChest;
    public static int pairDistWp;
    public static double[] tileShipyardSmall;
    public static double[] tileShipyardLarge;
    public static double[] tileVolCore;
    public static int[] tileCrane;
    public static boolean enableIC2;
    public static boolean enableMetamorphSkill;
    public static double expGainPlayerSkill;
    public static double morphHPRatio;
    public static double morphDmgTakenRatio;
    public static int buffSaturation;
    public static double[] limitShipAttrs;
    public static double[] scaleShip;
    public static double[] scaleBossSmall;
    public static double[] scaleBossLarge;
    public static double[] scaleMobSmall;
    public static double[] scaleMobLarge;
    public static double[] scaleHeldItem;
    public static int[] consumeAmmoShip;
    public static int[] consumeGrudgeShip;
    public static int[] consumeGrudgeAction;
    public static int[] consumeGrudgeTask;
    public static int[] baseAttackSpeed;
    public static int[] fixedAttackDelay;
    public static int[] expGain;
    public static int[] expGainTask;
    public static int[] tickFishing;
    public static int[] tickMining;
    public static int[] mobSpawn;
    public static int[] ringAbility;
    public static int[] drumLiquid;
    public static int[] drumEU;
    public static int[] infLiquid;
    public static int[] shipTeleport;
    public static boolean[] enableTask;
    public static double[] posHUD;
    public static int dmgSvS;
    public static int expMod;
    public static int modernLimit;
    public static int searchlightCD;
    public static int maxLevel;
    public static int airplaneDelay;
    public static boolean timeKeeping;
    public static boolean canFlare;
    public static boolean canSearchlight;
    public static boolean checkRing;
    public static boolean canTeleport;
    public static float volumeTimekeep;
    public static float volumeShip;
    public static float volumeFire;
    public static int polyOreBaseRate;
    public static int polyGravelBaseRate;
    public static boolean[] polyGravelBaseBlock;
    public static final String[] consumptionMode = {"Low", "Middle", "High"};
    public static String consumption;
    public static int consumptionLevel;

    private static void loadConfiguration() {
        config.addCustomCategoryComment(CATE_GENERAL, "general setting");
        config.addCustomCategoryComment(CATE_SHIP, CATE_SHIP);
        config.addCustomCategoryComment(CATE_WORLD, "world generate setting");
        config.addCustomCategoryComment(CATE_INTERMOD, "mod interaction setting");
        config.addCustomCategoryComment(CATE_BUFF, "potion buff and debuff setting");
        Property prop = config.get(CATE_GENERAL, "Consumption_Mode", "Middle", "Sets consumption level.  Low : ++Treasure chest loot ++Resource input to a shipyard  Middle : +Resource input to a shipyard  High : --Treasure chest loot", consumptionMode);
        consumption = prop.getString();
        consumptionLevel = getconsumptionLevel(consumption);
        alwaysShowTeamParticle = config.getBoolean("AlwaysShow_TeamCircle", CATE_GENERAL, false, "Always show team circle indicator particle");
        bossCooldown = config.getInt("Cooldown_Boss", CATE_GENERAL, 4800, 20, 1728000, "Boss spawn cooldown");
        closeGUIDist = config.getInt("Close_GUI_Distance", CATE_GENERAL, 64, 2, 64, "Close inventory GUI if ship away from player X blocks");
        chunkloaderMode = config.getInt("Mode_ChunkLoader", CATE_GENERAL, 2, 0, 2, "Chunk loader mode: 0: disable, 1: only 1 chunk each ship, 2: 3x3 chunks each ship");
        deathMaxTick = config.getInt("Death_Time", CATE_GENERAL, 400, 0, 3600, "Ship death animation time");
        debugMode = config.getBoolean("Mode_Debug", CATE_GENERAL, false, "Enable debug message (SPAM WARNING)");
        despawnBoss = config.getInt("Despawn_Boss", CATE_GENERAL, 12000, -1, 1728000, "Despawn time of boss ship , -1 = do NOT despawn");
        despawnMinion = config.getInt("Despawn_Minion", CATE_GENERAL, 600, -1, 1728000, "Despawn time of nonboss ship, -1 = do NOT despawn");
        despawnEgg = config.getInt("Despawn_Egg", CATE_GENERAL, 12000, -1, 1728000, "Despawn time of spawn egg of ship mob, -1 = do NOT despawn");
        dropGrudge = config.getFloat("DropRate_Grudge", CATE_GENERAL, 1.0f, 0.0f, 64.0f, "Grudge drop rate (ex: 0.5 = 50% drop 1 grudge, 5.5 = drop 5 grudge + 50% drop 1 grudge)");
        friendlyFire = config.getBoolean("Friendly_Fire", CATE_GENERAL, true, "false: disable damage done by player (except owner)");
        kaitaiAmountSmall = config.getInt("Recycle_Small", CATE_GENERAL, 20, 0, 1000, "Recycle amount by Dismantle Hammer for copmmon ship, ex: Ro500.");
        kaitaiAmountLarge = config.getInt("Recycle_Large", CATE_GENERAL, 20, 0, 1000, "Recycle amount by Dismantle Hammer for rare ship, ex: Yamato.");
        mobAttackPlayer = config.getBoolean("Attack_Player_ShipMob", CATE_GENERAL, true, "for mob ship, true: attack player automatically");
        shipAttackPlayer = config.getInt("Attack_Player_Ship", CATE_GENERAL, 0, 0, 3, "for pet ship, 0: ship don't attack player automatically, 1: attack hostile player, 2: attack hostile and neutral player, 3: attack all player even if the player isn't in a team");
        polyAsMn = config.getBoolean("Polymetal_as_Mn", CATE_GENERAL, false, "true: Polymetallic Nodules = Manganese Dust, Polymetallic Ore = Manganese Ore");
        radarUpdate = config.getInt("Radar_Update", CATE_GENERAL, 64, 20, 6000, "Radar update interval (ticks) in Admiral's Desk GUI");
        showTag = config.getBoolean("NameTag_AlwaysShow", CATE_GENERAL, true, "Always show custom name tag");
        nameTagDist = config.getInt("NameTag_Distance", CATE_GENERAL, 16, 1, 64, "Show name tag if player get close to ship X blocks");
        shipNumPerPage = config.getInt("Command_ShipNum", CATE_GENERAL, 5, 1, 5000, "#Ship per page for command: /ship list");
        teamCooldown = config.getInt("Cooldown_Team", CATE_GENERAL, 6000, 20, 1728000, "Create/Disband Team Cooldown");
        vortexDepth = config.getBoolean("Depth_HadalVortex", CATE_GENERAL, false, "Enable depth while rendering Hadal Vortex block.");
        spawnBossNum = config.getInt("Spawn_Boss_Number", CATE_GENERAL, 2, 1, 10, "large hostile ship (boss) number per spawn");
        spawnMobNum = config.getInt("Spawn_Mob_Number", CATE_GENERAL, 4, 1, 10, "small hostile ship number per spawn");
        pairDistChest = config.getInt("PairingDist_Chest", CATE_GENERAL, 16, 0, 64, "Max pairing distance between waypoint and chest");
        pairDistWp = config.getInt("PairingDist_Waypoint", CATE_GENERAL, 48, 0, 64, "Max pairing distance between waypoints");
        enableIC2 = config.getBoolean("Mod_IC2", CATE_INTERMOD, true, "Enable IC2 module if mod existed: add EU related function.");
        propDrumEU = config.get(CATE_INTERMOD, "Drum_EU", drumEU, "EU transport rate: base transfer rate (EU/t), additional rate per enchantment (EU/t). Total Rate = (ShipLV * 0.1 + 1) * (BaseRate * #TotalTransformers + EnchantRate * #TotalEnchantments)");
        enableMetamorphSkill = config.getBoolean("Mod_MetamorphSkill", CATE_INTERMOD, true, "Enable Metamorph module, if true: 1. player can use ship skill in morphing, 2. if no grudge, player will be demorphed.");
        expGainPlayerSkill = config.getFloat("Metamorph_ExpGain", CATE_INTERMOD, 6.0f, 0.0f, 1000.0f, "Exp modify for casting ship attack skill by player in morph, final exp = raw exp * Metamorph_ExpGain, req: Metamorph mod.");
        morphHPRatio = config.getFloat("Metamorph_HPRatio", CATE_INTERMOD, 0.1f, 0.0f, 10.0f, "HP modify of player in morph, final HP = 20 + shipHP * Metamorph_HPRatio, req: Metamorph mod.");
        morphDmgTakenRatio = config.getFloat("Metamorph_DmgTakenRatio", CATE_INTERMOD, 0.2f, 0.0f, 1.0f, "Damage by ship attack modify of player in morph, final DamageTaken = raw damage * Metamorph_DmgTakenRatio, req: Metamorph mod.");
        canFlare = config.getBoolean("Can_Flare", CATE_SHIP, true, "Can ship spawn Flare lighting effect, CLIENT SIDE only");
        canSearchlight = config.getBoolean("Can_Searchlight", CATE_SHIP, true, "Can ship spawn Searchlight lighting effect, CLIENT SIDE only");
        canTeleport = config.getBoolean("Can_Teleport", CATE_SHIP, true, "Can ship teleport to owner/guarding position if too far away. NOTE: set false if ship usually disappear/despawn after teleport!");
        checkRing = config.getBoolean("Check_Ring", CATE_SHIP, true, "Should check wedding ring when spawning NON-BOSS ship mob");
        timeKeeping = config.getBoolean("Can_Timekeeping", CATE_SHIP, true, "Play timekeeping sound every 1000 ticks (1 minecraft hour)");
        volumeTimekeep = config.getFloat("Volume_Timekeeping", CATE_SHIP, 1.0f, 0.0f, 10.0f, "Timekeeping sound volume");
        volumeShip = config.getFloat("Volume_Ship", CATE_SHIP, 1.0f, 0.0f, 10.0f, "Other sound volume");
        volumeFire = config.getFloat("Volume_Attack", CATE_SHIP, 0.7f, 0.0f, 10.0f, "Attack sound volume");
        baseCaressMorale = config.getInt("Caress_BaseMorale", CATE_SHIP, 20, 1, 5000, "base morale value per CaressTick (4 ticks)");
        modernLimit = config.getInt("Attrs_Limit_Modernization", CATE_SHIP, 3, 3, 100, "Max upgrade level by Modernization Toolkit");
        searchlightCD = config.getInt("CD_SearchLight", CATE_SHIP, 4, 1, 256, "Cooldown for placing light block of searchlight");
        airplaneDelay = config.getInt("CD_AirplaneRecovery", CATE_SHIP, 3600, 1, 30000, "Base cooldown for airplane recovery, actual recovery time = CD_AirplaneRecovery / attack speed + 20");
        propShip = config.get(CATE_SHIP, "Attrs_Scale", scaleShip, "Ship attributes SCALE: HP, firepower, armor, attack speed, move speed, range");
        propLimitShipAttrs = config.get(CATE_SHIP, "Attrs_Limit", limitShipAttrs, "Ship attributes max limit (-1 = no limit): HP, damage(light), damage(heavy), damage(air_light), damage(air_heavy), armor%, attack speed, move speed, range(blocks), critical, double hit, triple hit, miss reduction, anti-air, anti-ss, dodge, xp gain, grudge gain, ammo gain, hp regen, knockback resist");
        propBossSmall = config.get(CATE_SHIP, "Attrs_Hostile_SmallBoss", scaleBossSmall, "Small boss base attribute values: HP, firepower, armor, attack speed, move speed, range");
        propBossLarge = config.get(CATE_SHIP, "Attrs_Hostile_LargeBoss", scaleBossLarge, "Large boss base attribute values: HP, firepower, armor, attack speed, move speed, range");
        propMobSmall = config.get(CATE_SHIP, "Attrs_Hostile_SmallMob", scaleMobSmall, "Small mob ship like DD and SS base attribute values: HP, firepower, armor, attack speed, move speed, range");
        propMobLarge = config.get(CATE_SHIP, "Attrs_Hostile_LargeMob", scaleMobLarge, "Large mob ship like CL and CA base attribute values: HP, firepower, armor, attack speed, move speed, range");
        propAmmoShip = config.get(CATE_SHIP, "Consume_Ammo", consumeAmmoShip, "Ammo consumption for ship type: DD CL CA CAV CLT CVL CV BB BBV SS AP (MAX = 45)");
        propGrudgeShip = config.get(CATE_SHIP, "Consume_Grudge_Idle", consumeGrudgeShip, "Grudge consumption for ship type: DD CL CA CAV CLT CVL CV BB BBV SS AP (MAX = 120)");
        propGrudgeAction = config.get(CATE_SHIP, "Consume_Grudge_Action", consumeGrudgeAction, "Grudge consumption for ship action: Light attack, Heavy attack, Light aircraft, Heavy aircraft, Moving per block");
        propGrudgeTask = config.get(CATE_SHIP, "Consume_Grudge_Task", consumeGrudgeTask, "Grudge consumption for task: cooking, fishing, mining, crafting");
        propAtkSpd = config.get(CATE_SHIP, "Attack_Base_Speed", baseAttackSpeed, "Base attack speed for: Melee, Light attack, Heavy attack, Carrier attack, Airplane attack, ex: base speed 160, fixed delay 30 means (160 / ship attack speed +30) ticks per attack");
        propAtkDly = config.get(CATE_SHIP, "Attack_Fixed_Delay", fixedAttackDelay, "Fixed attack delay for: Melee, Light attack, Heavy attack, Carrier attack, Airplane attack, ex: base speed 160, fixed delay 30 means (160 / ship attack speed +30) ticks per attack");
        propExp = config.get(CATE_SHIP, "Exp_Gain", expGain, "Exp gain for: Melee, Light Attack, Heavy Attack, Light Aircraft, Heavy Aircraft, Move per Block(AP only), Other Action(AP only)");
        propExpTask = config.get(CATE_SHIP, "Exp_Gain_Task", expGainTask, "Exp gain for task: Cooking, Fishing, Mining, Crafting");
        propMobSpawn = config.get(CATE_SHIP, "Limit_MobSpawnNumber", mobSpawn, "Mob ship spawn MAX number in the world, Spawn prob (roll once per player every 128 ticks), #groups each spawn, #min each group, #max each group");
        propHeldItem = config.get(CATE_SHIP, "Held_Item", scaleHeldItem, "Ship held item scaling: scale, offset X, offset Y, offset Z");
        propDrumLiquid = config.get(CATE_SHIP, "Drum_Liquid", drumLiquid, "liquid transport rate: base transfer rate (mB/t), additional rate per enchantment (mB/t). Total Rate = (ShipLV * 0.1 + 1) * (BaseRate * #TotalPumps + EnchantRate * #TotalEnchantments)");
        propShipTeleport = config.get(CATE_SHIP, "ship_teleport", shipTeleport, "Ship teleport when following and guarding: cooldown (ticks), distance (blocks^2)");
        propFishing = config.get(CATE_SHIP, "Tick_Fishing", tickFishing, "Fishing time setting: base, random (ticks)");
        propMining = config.get(CATE_SHIP, "Tick_Mining", tickMining, "Mining time setting: base, random (ticks)");
        propTask = config.get(CATE_SHIP, "Task_Enable", enableTask, "set true to enable the task: cooking, fishing, mining, crafting");
        propShipyardSmall = config.get(CATE_GENERAL, "Tile_SmallShipyard", tileShipyardSmall, "Small shipyard: max fuel storage, build speed, fuel magnification");
        propShipyardLarge = config.get(CATE_GENERAL, "Tile_LargeShipyard", tileShipyardLarge, "Large shipyard: max fuel storage, build speed, fuel magnification");
        propVolCore = config.get(CATE_GENERAL, "Tile_VolCore", tileVolCore, "Volcano Core: max fuel storage, fuel consume speed, fuel value per grudge item");
        propCrane = config.get(CATE_GENERAL, "Tile_Crane", tileCrane, "Crane: internal fluid tank capacity (mB), internal energy capacity (EU)");
        propRingAbility = config.get(CATE_GENERAL, "Ring_Ability", ringAbility, "Ring ability related married number, -1 = disable, 0~N = active or max limit number: water breath (active number), fly in water (active number), dig speed boost (max limit number), fog in liquid (max limit number), immune to fire (active number)");
        propInfLiquid = config.get(CATE_GENERAL, "Infinite_Pump", infLiquid, "Can ship pump infinite water or lava without destroying block: min water depth, min lava depth");
        propPosHUD = config.get(CATE_GENERAL, "Position_HUD", posHUD, "HUD position of mounts skills: x, y (0.5D = middle of window)");
        dmgSvS = config.getInt("DmgTaken_SvS", CATE_SHIP, 100, 0, 10000, "Ship vs Ship damage modifier, 20 = damage * 20% ");
        expMod = config.getInt("EXP_Modifier", CATE_SHIP, 20, 1, 10000, "ship experience modifier, 20 = level 150: 150*20+20 = 3020");
        polyOreBaseRate = config.getInt("Polymetal_Ore", CATE_WORLD, 7, 0, 100, "Polymetallic Ore clusters in one chunk");
        polyGravelBaseRate = config.getInt("Polymetal_Gravel", CATE_WORLD, 4, 0, 100, "Polymetallic Gravel clusters in one chunk");
        propPolyGravel = config.get(CATE_WORLD, "Polymetal_Gravel_Replace", polyGravelBaseBlock, "PolyGravel replaced block: stone, gravel, sand, dirt", true, 4);
        limitShipAttrs = ConfigHandler.getDoubleArrayFromConfig(limitShipAttrs, propLimitShipAttrs);
        scaleShip = ConfigHandler.getDoubleArrayFromConfig(scaleShip, propShip);
        scaleBossSmall = ConfigHandler.getDoubleArrayFromConfig(scaleBossSmall, propBossSmall);
        scaleBossLarge = ConfigHandler.getDoubleArrayFromConfig(scaleBossLarge, propBossLarge);
        scaleMobSmall = ConfigHandler.getDoubleArrayFromConfig(scaleMobSmall, propMobSmall);
        scaleMobLarge = ConfigHandler.getDoubleArrayFromConfig(scaleMobLarge, propMobLarge);
        polyGravelBaseBlock = ConfigHandler.getBooleanArrayFromConfig(polyGravelBaseBlock, propPolyGravel);
        consumeAmmoShip = ConfigHandler.getIntArrayFromConfig(consumeAmmoShip, propAmmoShip);
        consumeGrudgeShip = ConfigHandler.getIntArrayFromConfig(consumeGrudgeShip, propGrudgeShip);
        consumeGrudgeAction = ConfigHandler.getIntArrayFromConfig(consumeGrudgeAction, propGrudgeAction);
        consumeGrudgeTask = ConfigHandler.getIntArrayFromConfig(consumeGrudgeTask, propGrudgeTask);
        baseAttackSpeed = ConfigHandler.getIntArrayFromConfig(baseAttackSpeed, propAtkSpd);
        fixedAttackDelay = ConfigHandler.getIntArrayFromConfig(fixedAttackDelay, propAtkDly);
        expGain = ConfigHandler.getIntArrayFromConfig(expGain, propExp);
        expGainTask = ConfigHandler.getIntArrayFromConfig(expGainTask, propExpTask);
        mobSpawn = ConfigHandler.getIntArrayFromConfig(mobSpawn, propMobSpawn);
        tileShipyardSmall = ConfigHandler.getDoubleArrayFromConfig(tileShipyardSmall, propShipyardSmall);
        tileShipyardLarge = ConfigHandler.getDoubleArrayFromConfig(tileShipyardLarge, propShipyardLarge);
        tileVolCore = ConfigHandler.getDoubleArrayFromConfig(tileVolCore, propVolCore);
        tileCrane = ConfigHandler.getIntArrayFromConfig(tileCrane, propCrane);
        ringAbility = ConfigHandler.getIntArrayFromConfig(ringAbility, propRingAbility);
        scaleHeldItem = ConfigHandler.getDoubleArrayFromConfig(scaleHeldItem, propHeldItem);
        drumLiquid = ConfigHandler.getIntArrayFromConfig(drumLiquid, propDrumLiquid);
        drumEU = ConfigHandler.getIntArrayFromConfig(drumEU, propDrumEU);
        shipTeleport = ConfigHandler.getIntArrayFromConfig(shipTeleport, propShipTeleport);
        tickFishing = ConfigHandler.getIntArrayFromConfig(tickFishing, propFishing);
        tickMining = ConfigHandler.getIntArrayFromConfig(tickMining, propMining);
        enableTask = ConfigHandler.getBooleanArrayFromConfig(enableTask, propTask);
        posHUD = ConfigHandler.getDoubleArrayFromConfig(posHUD, propPosHUD);
        ConfigHandler.checkChange(config);
    }

    public static void init(FMLPreInitializationEvent event) throws Exception {
        if (config == null) {
            String configRootLoc = event.getModConfigurationDirectory() + "/" + "shincolle" + "/";
            File fileMainConfig = new File(configRootLoc + "shincolle" + ".cfg");
            File fileSounds = new File(configRootLoc + "sounds.cfg");
            File fileLootTable = new File(configRootLoc + "loottable.cfg");
            File fileMining = new File(configRootLoc + "mining.cfg");
            config = new Configuration(fileMainConfig);
            configSound = new ConfigSound(fileSounds);
            configLoot = new ConfigLoot(fileLootTable);
            configMining = new ConfigMining(fileMining);
            ConfigHandler.loadConfiguration();
            configSound.runConfig();
            configLoot.runConfig();
            configMining.runConfig();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equalsIgnoreCase("shincolle")) {
            ConfigHandler.loadConfiguration();
        }
    }

    public static void checkChange(Configuration cfg) {
        if (cfg != null && cfg.hasChanged()) {
            cfg.save();
        }
    }

    public static int[] getIntArrayFromConfig(int[] defaultValue, Property target) {
        int size = defaultValue.length;
        int[] geti = target.getIntList();
        if (geti != null && geti.length == size) {
            return geti;
        }
        target.set(defaultValue);
        return defaultValue;
    }

    public static double[] getDoubleArrayFromConfig(double[] defaultValue, Property target) {
        int size = defaultValue.length;
        double[] getd = target.getDoubleList();
        if (getd != null && getd.length == size) {
            return getd;
        }
        target.set(defaultValue);
        return defaultValue;
    }

    public static boolean[] getBooleanArrayFromConfig(boolean[] defaultValue, Property target) {
        int size = defaultValue.length;
        boolean[] getd = target.getBooleanList();
        if (getd != null && getd.length == size) {
            return getd;
        }
        target.set(defaultValue);
        return defaultValue;
    }

    private static int getconsumptionLevel(String val) {
        for (int i = 0; i < consumptionMode.length; i++) {
            if (consumptionMode[i].equalsIgnoreCase(val)) {
                return i;
            }
        }
        return 1;
    }

    static {
        debugMode = false;
        showTag = true;
        friendlyFire = true;
        alwaysShowTeamParticle = false;
        polyAsMn = false;
        vortexDepth = false;
        mobAttackPlayer = true;
        dropGrudge = 1.0f;
        closeGUIDist = 64;
        bossCooldown = 4800;
        teamCooldown = 6000;
        despawnBoss = 12000;
        despawnMinion = 600;
        despawnEgg = 12000;
        kaitaiAmountSmall = 20;
        kaitaiAmountLarge = 20;
        baseCaressMorale = 20;
        nameTagDist = 16;
        spawnBossNum = 2;
        spawnMobNum = 4;
        shipNumPerPage = 5;
        chunkloaderMode = 2;
        deathMaxTick = 400;
        radarUpdate = 64;
        shipAttackPlayer = 0;
        pairDistChest = 16;
        pairDistWp = 48;
        tileShipyardSmall = new double[]{460800.0, 48.0, 1.0};
        tileShipyardLarge = new double[]{1382400.0, 48.0, 1.0};
        tileVolCore = new double[]{9600.0, 16.0, 240.0};
        tileCrane = new int[]{2048000, 160000000};
        enableIC2 = true;
        enableMetamorphSkill = true;
        expGainPlayerSkill = 6.0;
        morphHPRatio = 0.1;
        morphDmgTakenRatio = 0.2;
        buffSaturation = 100;
        limitShipAttrs = new double[]{-1.0, -1.0, -1.0, -1.0, -1.0, 0.8, 4.0, 0.6, 64.0, 0.9, 0.9, 0.9, 0.9, -1.0, -1.0, 0.75, -1.0, -1.0, -1.0, -1.0, 1.0};
        scaleShip = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        scaleBossSmall = new double[]{1600.0, 120.0, 0.5, 1.6, 0.38, 18.0};
        scaleBossLarge = new double[]{3200.0, 240.0, 0.75, 2.0, 0.35, 22.0};
        scaleMobSmall = new double[]{250.0, 25.0, 0.15, 0.7, 0.45, 12.0};
        scaleMobLarge = new double[]{500.0, 50.0, 0.3, 0.9, 0.4, 15.0};
        scaleHeldItem = new double[]{2.5, 0.0, 0.0, 0.0};
        consumeAmmoShip = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 1, 1};
        consumeGrudgeShip = new int[]{5, 7, 8, 9, 8, 11, 12, 15, 14, 4, 3};
        consumeGrudgeAction = new int[]{4, 8, 6, 12, 3};
        consumeGrudgeTask = new int[]{3, 30, 300, 2};
        baseAttackSpeed = new int[]{40, 80, 120, 100, 100};
        fixedAttackDelay = new int[]{0, 20, 50, 35, 35};
        expGain = new int[]{4, 8, 24, 16, 48, 2, 4};
        expGainTask = new int[]{4, 40, 20, 2};
        tickFishing = new int[]{400, 600};
        tickMining = new int[]{100, 200};
        mobSpawn = new int[]{50, 10, 1, 1, 1};
        ringAbility = new int[]{0, 6, 30, 20, 12};
        drumLiquid = new int[]{40, 5};
        drumEU = new int[]{400, 100};
        infLiquid = new int[]{12, 8};
        shipTeleport = new int[]{200, 256};
        enableTask = new boolean[]{true, true, true, true};
        posHUD = new double[]{0.5, 0.6};
        dmgSvS = 100;
        expMod = 20;
        modernLimit = 3;
        searchlightCD = 4;
        maxLevel = 150;
        airplaneDelay = 2400;
        timeKeeping = true;
        canFlare = true;
        canSearchlight = true;
        checkRing = true;
        canTeleport = true;
        volumeTimekeep = 1.0f;
        volumeShip = 1.0f;
        volumeFire = 0.7f;
        polyOreBaseRate = 7;
        polyGravelBaseRate = 4;
        polyGravelBaseBlock = new boolean[]{true, true, false, false};
    }
}
