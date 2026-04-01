package com.lulan.shincolle.proxy;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.network.S2CGUIPackets;
import com.lulan.shincolle.server.CacheDataPlayer;
import com.lulan.shincolle.server.CacheDataShip;
import com.lulan.shincolle.server.ShinWorldData;
import com.lulan.shincolle.team.TeamData;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.MapStorage;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ServerProxy
        extends CommonProxy {
    private static HashMap<Integer, HashMap<Integer, String>> customTargetClass = null;
    private static HashMap<Integer, String> unattackableTargetClass = null;
    private static HashMap<Integer, TeamData> mapTeamID = null;
    private static HashMap<Integer, CacheDataPlayer> mapPlayerID = null;
    private static HashMap<Integer, CacheDataShip> mapShipID = null;
    private static int nextPlayerID = -1;
    private static int nextShipID = -1;
    public static World world0;
    public static MapStorage serverFile;
    public static ShinWorldData serverData;
    public static boolean initServerFile;
    public static boolean saveServerFile;
    public static final String CUSTOM_TARGET_CLASS = "CustomTargetClass";
    public static final String UNATK_TARGET_CLASS = "UnatkTargetClass";
    public static int serverTicks;
    public static int updateRadarTicks;

    public static void initServerProxy(World world) {
        LogHelper.info("INFO: init server proxy data");
        ServerProxy.customTargetClass        = new HashMap<>();
        ServerProxy.unattackableTargetClass  = new HashMap<>();
        ServerProxy.mapPlayerID              = new HashMap<>();
        ServerProxy.mapShipID                = new HashMap<>();
        ServerProxy.mapTeamID                = new HashMap<>();
        ServerProxy.nextPlayerID             = -1;
        ServerProxy.nextShipID               = -1;
        ServerProxy.world0                   = world;
        ServerProxy.serverFile               = world.getMapStorage();
        ServerProxy.serverData               = (ShinWorldData) ServerProxy.serverFile.getOrLoadData(ShinWorldData.class, "shincolle");
        if (ServerProxy.serverData == null) {
            LogHelper.warn("WARN: getOrLoadData returned null for 'shincolle'. Attempting to create and register a new instance.");
            ServerProxy.serverData = new ShinWorldData("shincolle");
            ServerProxy.serverFile.setData("shincolle", ServerProxy.serverData);
            LogHelper.info("INFO: Successfully created and registered new ShinWorldData 'shincolle'.");
        }

        if (ShinWorldData.nbtData != null) {
            NBTTagList unatktag = ShinWorldData.nbtData.getTagList(UNATK_TARGET_CLASS, 8);
            LogHelper.info("INFO: init server proxy: get unattackable target list: count: " + unatktag.tagCount());
            HashMap<Integer, String> unatklist = new HashMap<>();
            for (int j = 0; j < unatktag.tagCount(); j++) {
                String str = unatktag.getStringTagAt(j);
                if (str == null || str.length() <= 1) continue;
                unatklist.put(str.hashCode(), str);
            }
            ServerProxy.unattackableTargetClass = unatklist;

            NBTTagList list = ShinWorldData.nbtData.getTagList("playerData", 10);
            LogHelper.info("INFO: init server proxy: get player data count: " + list.tagCount());
            for (int i = 0; i < list.tagCount(); i++) {
                NBTTagCompound getlist = list.getCompoundTagAt(i);
                int uid = getlist.getInteger("pUID");
                NBTTagList strListTag = getlist.getTagList(CUSTOM_TARGET_CLASS, 8);
                HashMap<Integer, String> strList = new HashMap<>();
                for (int j = 0; j < strListTag.tagCount(); j++) {
                    String str = strListTag.getStringTagAt(j);
                    if (str == null || str.length() <= 1) continue;
                    strList.put(str.hashCode(), str);
                }
                LogHelper.debug("DEBUG: init server proxy: get player data: UID " + uid + " target list size: " + strList.size());
                ServerProxy.customTargetClass.put(uid, strList);
            }

            NBTTagList list2 = ShinWorldData.nbtData.getTagList("teamData", 10);
            LogHelper.info("INFO: init server proxy: get team data count: " + list2.tagCount());
            for (int i = 0; i < list2.tagCount(); i++) {
                NBTTagCompound getlist = list2.getCompoundTagAt(i);
                int tUID    = getlist.getInteger("tUID");
                String tName = getlist.getString("tName");
                String tLName = getlist.getString("tLName");
                int[] tBan   = getlist.getIntArray("tBan");
                List<Integer> tList1 = CalcHelper.intArrayToList(tBan);
                int[] tAlly  = getlist.getIntArray("tAlly");
                List<Integer> tList2 = CalcHelper.intArrayToList(tAlly);

                TeamData tData = new TeamData();
                tData.setTeamID(tUID);
                tData.setTeamName(tName);
                tData.setTeamLeaderName(tLName);
                tData.setTeamBannedList(tList1);
                tData.setTeamAllyList(tList2);
                LogHelper.debug("DEBUG: init server proxy: get team data: UID " + tUID + " NAME " + tName);
                ServerProxy.mapTeamID.put(tUID, tData);
            }

            NBTTagList list3 = ShinWorldData.nbtData.getTagList("shipData", 10);
            LogHelper.info("INFO: init server proxy: get ship data count: " + list3.tagCount());
            for (int i = 0; i < list3.tagCount(); i++) {
                NBTTagCompound getlist = list3.getCompoundTagAt(i);
                int uid      = getlist.getInteger("sUID");
                int eid      = getlist.getInteger("sEID");
                int wid      = getlist.getInteger("sWID");
                int cid      = getlist.getInteger("sCID");
                boolean isDead = getlist.getBoolean("sDead");
                int[] pos    = getlist.getIntArray("sPOS");
                NBTTagCompound sTag = getlist.getCompoundTag("sNBT");

                CacheDataShip sData = new CacheDataShip(eid, wid, cid, isDead, pos[0], pos[1], pos[2], sTag);
                LogHelper.debug("DEBUG: init server proxy: get ship data: UID " + uid);
                ServerProxy.mapShipID.put(uid, sData);
            }

            ServerProxy.initServerFile = false;
        } else {
            LogHelper.info("INFO: init server proxy: create .dat file");
            ServerProxy.serverData = new ShinWorldData();
            ServerProxy.serverFile.setData("shincolle", ServerProxy.serverData);
            ServerProxy.initServerFile = false;
        }
    }

    public static void saveServerProxy() {
        LogHelper.debug("DEBUG: save server proxy: save .dat file");
        if (serverData != null) {
            serverData.markDirty();
        }
        if (serverFile != null) {
            serverFile.saveAllData();
        }
        saveServerFile = false;
    }

    public static MinecraftServer getServer() {
        return FMLCommonHandler.instance().getMinecraftServerInstance();
    }

    public static WorldServer[] getServerWorld() {
        return ServerProxy.getServer().worlds;
    }

    public static WorldServer getServerWorld(int worldID) {
        for (WorldServer getw : ServerProxy.getServerWorld()) {
            if (getw.provider.getDimension() != worldID) continue;
            return getw;
        }
        return null;
    }

    @Override
    public void registerRender() {
    }

    public static boolean setPlayerTargetClass(int pid, String str) {
        if (str != null && str.length() > 1 && pid > 0) {
            HashMap<Integer, String> tarList = ServerProxy.getPlayerTargetClass(pid);
            if (tarList != null) {
                String s = tarList.get(str.hashCode());
                if (s != null) {
                    tarList.remove(str.hashCode());
                    return false;
                }
                tarList.put(str.hashCode(), str);
            } else {
                tarList = new HashMap();
                tarList.put(str.hashCode(), str);
                customTargetClass.put(pid, tarList);
                serverData.markDirty();
            }
        }
        return true;
    }

    public static boolean addUnattackableTargetClass(String target) {
        boolean result = false;
        if (target != null) {
            int key = target.hashCode();
            if (unattackableTargetClass.containsKey(key)) {
                unattackableTargetClass.remove(key);
            } else {
                unattackableTargetClass.put(key, target);
                result = true;
            }
            serverData.markDirty();
        }
        return result;
    }

    public static HashMap<Integer, String> getUnattackableTargetClass() {
        return unattackableTargetClass;
    }

    public static HashMap<Integer, String> getPlayerTargetClass(int pid) {
        if (pid > 0) {
            return customTargetClass.get(pid);
        }
        return new HashMap<>();
    }

    public static CacheDataPlayer getPlayerWorldData(int par1) {
        if (par1 != -1) {
            return mapPlayerID.get(par1);
        }
        return null;
    }

    public static void setPlayerWorldData(int pid, CacheDataPlayer pdata) {
        if (pid > 0 && pdata != null) {
            mapPlayerID.put(pid, pdata);
        }
    }

    public static CacheDataShip getShipWorldData(int par1) {
        if (par1 != -1) {
            return mapShipID.get(par1);
        }
        return null;
    }

    public static void setShipWorldData(int pid, CacheDataShip pdata) {
        if (pid > 0 && pdata != null) {
            mapShipID.put(pid, pdata);
            serverData.markDirty();
        }
    }

    public static TeamData getTeamData(int tid) {
        if (tid > 0) {
            return mapTeamID.get(tid);
        }
        return null;
    }

    public static void setTeamData(TeamData data) {
        if (data != null && data.getTeamID() > 0) {
            mapTeamID.put(data.getTeamID(), data);
            serverData.markDirty();
        }
    }

    public static void removeTeamData(int tid) {
        if (tid > 0 && mapTeamID.containsKey(tid)) {
            mapTeamID.remove(tid);
            serverData.markDirty();
        }
    }

    private static void cleanTeamData(TeamData tdata) {
        if (tdata != null) {
            try {
                String owner1 = tdata.getTeamLeaderName();
                String owner2 = null;
                for (Map.Entry<Integer, TeamData> entry : mapTeamID.entrySet()) {
                    int pid = entry.getKey();
                    TeamData getdata = entry.getValue();
                    owner2 = getdata.getTeamLeaderName();
                    if (!owner1.equals(owner2)) continue;
                    ServerProxy.removeTeamData(pid);
                }
            }
            catch (Exception e) {
                LogHelper.info("EXCEPTION: clean team data fail: " + e);
                e.printStackTrace();
            }
        }
    }

    public static int getNextPlayerID() {
        return nextPlayerID;
    }

    public static void setNextPlayerID(int par1) {
        if (serverData != null) {
            LogHelper.debug("DEBUG: server proxy: set next player id " + par1);
            nextPlayerID = par1;
            serverData.markDirty();
        }
    }

    public static int getNextShipID() {
        return nextShipID;
    }

    public static void setNextShipID(int par1) {
        if (serverData != null) {
            LogHelper.debug("DEBUG: server proxy: set next ship id " + par1);
            nextShipID = par1;
            serverData.markDirty();
        }
    }

    public static HashMap<Integer, HashMap<Integer, String>> getAllPlayerTargetClassList() {
        return customTargetClass;
    }

    public static HashMap<Integer, CacheDataShip> getAllShipWorldData() {
        return mapShipID;
    }

    public static HashMap<Integer, TeamData> getAllTeamWorldData() {
        return mapTeamID;
    }

    public static void updatePlayerID(EntityPlayer player) {
        LogHelper.debug("DEBUG: update player: " + player.getDisplayNameString() + " " + player.getUniqueID() + " " + player.getEntityId());
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa != null) {
            int pid = capa.getPlayerUID();
            if (pid > 0) {
                LogHelper.info("INFO: update player: update player uid: " + pid);
                ServerProxy.setPlayerWorldData(pid, new CacheDataPlayer(player.getEntityId(), player.dimension, capa.hasTeam(), player.posX, player.posY, player.posZ, capa.saveNBTData(new NBTTagCompound())));
                if (ServerProxy.getNextPlayerID() <= 0 || ServerProxy.getNextPlayerID() <= pid) {
                    LogHelper.info("INFO: update player: find next player UID fail, shift id 100000");
                    int newNextID = pid + 100000;
                    ServerProxy.setNextPlayerID(newNextID);
                }
            } else {
                pid = ServerProxy.getNextPlayerID();
                if (pid <= 0) {
                    pid = 100;
                }
                LogHelper.info("INFO: update player: create player uid: " + pid);
                capa.setPlayerUID(pid);
                ServerProxy.setPlayerWorldData(pid, new CacheDataPlayer(player.getEntityId(), player.dimension, capa.hasTeam(), player.posX, player.posY, player.posZ, capa.saveNBTData(new NBTTagCompound())));
                ServerProxy.setNextPlayerID(++pid);
            }
        } else {
            LogHelper.info("INFO: update player: fail: player extProps = null");
        }
    }

    public static BasicEntityShip checkShipIsDupe(BasicEntityShip ship, int uid) {
        if (!ship.isMorph() && mapShipID.containsKey(uid)) {
            CacheDataShip olddata = mapShipID.get(uid);
            Entity ent = EntityHelper.getEntityByID(olddata.entityID, olddata.worldID, false);
            if (ent instanceof BasicEntityShip && ent.getEntityId() != ship.getEntityId() && ((BasicEntityShip)ent).getShipUID() == uid) {
                LogHelper.info("INFO: ServerProxy: ships with same uid found: uid: " + uid);
                LogHelper.info("      ent1: eid: " + ent.getEntityId() + " ticks: " + ent.ticksExisted + " " + ent);
                LogHelper.info("      ent2: eid: " + ship.getEntityId() + " ticks: " + ship.ticksExisted + " " + ship);
                if (ent.ticksExisted > 200 && ship.ticksExisted > 200 && ent.isEntityAlive() && ship.isEntityAlive()) {
                    if (ent.ticksExisted > ship.ticksExisted) {
                        LogHelper.info("      older entity: " + ent.getEntityId() + " is deleted.");
                        ent.setDead();
                    } else {
                        LogHelper.info("      older entity: " + ship.getEntityId() + " is deleted.");
                        ship.setDead();
                        ship = (BasicEntityShip)ent;
                    }
                }
            }
        }
        return ship;
    }

    public static void updateShipID(BasicEntityShip ship) {
        LogHelper.debug("DEBUG: update ship: " + ship);
        int uid = ship.getShipUID();
        if (uid > 0) {
            LogHelper.debug("DEBUG: update ship: update ship id " + uid + " eid: " + ship.getEntityId() + " world: " + ship.world.provider.getDimension());
            ship = ServerProxy.checkShipIsDupe(ship, uid);
            NBTTagCompound nbt = new NBTTagCompound();
            ship.writeEntityToNBT(nbt);
            CacheDataShip sdata = new CacheDataShip(ship.getEntityId(), ship.world.provider.getDimension(), ship.getShipClass(), ship.isDead, ship.posX, ship.posY, ship.posZ, nbt);
            ServerProxy.setShipWorldData(uid, sdata);
            if (ServerProxy.getNextShipID() <= 0 || ServerProxy.getNextShipID() <= uid) {
                LogHelper.debug("DEBUG: update ship: find next ship id error");
                int newNextID = uid + 100000;
                ServerProxy.setNextShipID(newNextID);
            }
        } else {
            uid = ServerProxy.getNextShipID();
            if (uid <= 0) {
                uid = 100;
            }
            LogHelper.debug("DEBUG: update ship: create sid: " + uid + " eid: " + ship.getEntityId() + " world: " + ship.world.provider.getDimension());
            ship.setShipUID(uid);
            NBTTagCompound nbt = new NBTTagCompound();
            ship.writeEntityToNBT(nbt);
            CacheDataShip sdata = new CacheDataShip(ship.getEntityId(), ship.world.provider.getDimension(), ship.getShipClass(), ship.isDead, ship.posX, ship.posY, ship.posZ, nbt);
            ServerProxy.setShipWorldData(uid, sdata);
            ServerProxy.setNextShipID(++uid);
        }
    }

    public static void updateShipOwnerID(BasicEntityShip ship) {
        EntityLivingBase owner = ship.getOwner();
        if (owner instanceof EntityPlayer) {
            CapaTeitoku capa = CapaTeitoku.getTeitokuCapability((EntityPlayer)owner);
            if (capa != null) {
                int pid = capa.getPlayerUID();
                LogHelper.debug("DEBUG: update ship: set owner id: " + pid + " on " + ship);
                ship.setPlayerUID(pid);
                ship.ownerName = owner.getName();
            }
        } else {
            LogHelper.debug("DEBUG: update ship: get owner id: fail, owner offline or no owner data: " + ship);
        }
    }

    public static void updateServerTick() {
        if (++serverTicks > 23999) {
            serverTicks = 0;
        }
        if (serverTicks > 100 && serverTicks % updateRadarTicks == 0) {
            boolean needUpdate = false;
            for (WorldServer getw : ServerProxy.getServerWorld()) {
                if (getw.playerEntities.isEmpty()) continue;
                needUpdate = true;
                break;
            }
            if (needUpdate) {
                HashMap<Integer, List> shipListByPlayer = new HashMap<>();
                HashMap playerByPUID = new HashMap();
                mapPlayerID.forEach((pid, pdata) -> {
                    ArrayList newlist = new ArrayList();
                    EntityPlayer pe = EntityHelper.getEntityPlayerByUID(pid);
                    shipListByPlayer.put(pid, newlist);
                    if (pe != null) {
                        playerByPUID.put(pid, pe);
                    }
                });
                mapShipID.forEach((sid, sdata) -> {
                    List shipList;
                    BasicEntityShip ship;
                    int pid;
                    EntityPlayer player;
                    Entity ent = EntityHelper.getEntityByID(sdata.entityID, sdata.worldID, false);
                    if (ent instanceof BasicEntityShip && (player = (EntityPlayer)playerByPUID.get(pid = (ship = (BasicEntityShip)ent).getPlayerUID())) != null && player.world.provider.getDimension() == ship.world.provider.getDimension() && (shipList = shipListByPlayer.get(pid)) != null) {
                        shipList.add(sdata.entityID);
                    }
                });
                shipListByPlayer.forEach((pid, value) -> {
                    EntityPlayerMP player = (EntityPlayerMP)playerByPUID.get(pid);
                    if (player != null) {
                        CommonProxy.channelG.sendTo(new S2CGUIPackets((byte)101, value), player);
                    }
                });
            }
        }
    }

    public static void teamRename(int tid, String tname) {
        if (tid > 0 && tname != null && tname.length() > 1 && ServerProxy.getAllTeamWorldData().containsKey(tid)) {
            TeamData tdata = ServerProxy.getTeamData(tid);
            tdata.setTeamName(tname);
        }
    }

    public static void teamCreate(EntityPlayer player, String tname) {
        int pUID;
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa != null && (pUID = capa.getPlayerUID()) > 0 && tname != null && tname.length() > 1 && ServerProxy.getAllTeamWorldData() != null) {
            TeamData tdata = new TeamData();
            tdata.setTeamID(pUID);
            tdata.setTeamName(tname);
            tdata.setTeamLeaderName(player.getDisplayNameString());
            LogHelper.debug("DEBUG: server proxy: create team: " + pUID + " " + tname);
            ServerProxy.cleanTeamData(tdata);
            ServerProxy.setTeamData(tdata);
            capa.setPlayerTeamCooldown(ConfigHandler.teamCooldown);
            ServerProxy.updatePlayerID(player);
        }
    }

    public static void teamDisband(EntityPlayer player) {
        CapaTeitoku capa;
        if (player != null && (capa = CapaTeitoku.getTeitokuCapability(player)) != null) {
            int pUID = capa.getPlayerUID();
            if (ServerProxy.getAllTeamWorldData() != null && ServerProxy.getAllTeamWorldData().containsKey(pUID)) {
                LogHelper.debug("DEBUG: server proxy: remove team: " + pUID);
                ServerProxy.removeTeamData(pUID);
                capa.setPlayerTeamCooldown(ConfigHandler.teamCooldown);
                ServerProxy.updatePlayerID(player);
            }
        }
    }

    public static void teamAddAlly(int tid1, int tid2) {
        if (tid1 > 0 && tid2 > 0 && tid1 != tid2 && ServerProxy.getAllTeamWorldData().containsKey(tid1) && ServerProxy.getAllTeamWorldData().containsKey(tid2)) {
            LogHelper.debug("DEBUG: server proxy: add ally: " + tid1 + " add " + tid2);
            TeamData tdata = ServerProxy.getTeamData(tid1);
            tdata.addTeamAlly(tid2);
        }
    }

    public static void teamRemoveAlly(int tid1, int tid2) {
        if (tid1 > 0 && tid2 > 0 && ServerProxy.getAllTeamWorldData().containsKey(tid1) && ServerProxy.getAllTeamWorldData().containsKey(tid2)) {
            LogHelper.debug("DEBUG: server proxy: remove ally: " + tid1 + " and " + tid2);
            TeamData tdata1 = ServerProxy.getTeamData(tid1);
            tdata1.removeTeamAlly(tid2);
            TeamData tdata2 = ServerProxy.getTeamData(tid2);
            tdata2.removeTeamAlly(tid1);
        }
    }

    public static void teamAddBan(int tid1, int tid2) {
        if (tid1 > 0 && tid2 > 0 && tid1 != tid2 && ServerProxy.getAllTeamWorldData().containsKey(tid1) && ServerProxy.getAllTeamWorldData().containsKey(tid2)) {
            LogHelper.debug("DEBUG: server proxy: ban team: " + tid1 + " ban " + tid2);
            TeamData tdata1 = ServerProxy.getTeamData(tid1);
            tdata1.addTeamBanned(tid2);
            TeamData tdata2 = ServerProxy.getTeamData(tid2);
            tdata2.addTeamBanned(tid1);
        }
    }

    public static void teamRemoveBan(int tid1, int tid2) {
        if (tid1 > 0 && tid2 > 0 && ServerProxy.getAllTeamWorldData().containsKey(tid1) && ServerProxy.getAllTeamWorldData().containsKey(tid2)) {
            LogHelper.debug("DEBUG: server proxy: unban team: " + tid1 + " unban " + tid2);
            TeamData tdata1 = ServerProxy.getTeamData(tid1);
            tdata1.removeTeamBanned(tid2);
        }
    }

    public static void removePlayerWorldData(int pid) {
        if (pid > 0) {
            mapPlayerID.remove(pid);
        }
    }

    static {
        serverFile = null;
        serverData = null;
        initServerFile = true;
        saveServerFile = false;
        serverTicks = 0;
        updateRadarTicks = ConfigHandler.radarUpdate;
    }
}
