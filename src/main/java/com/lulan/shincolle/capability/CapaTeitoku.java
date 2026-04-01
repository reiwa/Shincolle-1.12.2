package com.lulan.shincolle.capability;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.network.S2CGUIPackets;
import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.proxy.ServerProxy;
import com.lulan.shincolle.team.TeamData;
import com.lulan.shincolle.utility.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.items.ItemStackHandler;

import java.util.*;

public class CapaTeitoku implements ICapaTeitoku, IInventory {
    public static final String CAPA_KEY = "TeitokuExtProps";
    public static final String INV_KEY = "CpInv";
    private static final String KEY_PLAYER_UID = "PlayerUID";
    private static final String KEY_UNIT_NAME_PREFIX = "uname";

    private EntityPlayer player;
    private String playerName = "";
    private boolean needInit = true;
    private boolean initSID = false;
    private boolean isGuiOpening = false;
    private boolean hasRing = false;
    private boolean hasTeam = false;
    private boolean isRingActive = false;
    private boolean isRingFlying = false;
    private int marriageNum = 0;
    private int bossCooldown = ConfigHandler.bossCooldown;
    private int teamCooldown = 20;
    private final BasicEntityShip[][] teamList = new BasicEntityShip[9][6];
    private boolean[][] selectState;
    private int[][] sidList;
    private int[] formatID;
    private int saveId = 0;
    private int teamId = 0;
    private List<Integer> listShipEID;
    private List<Integer> listColleShip;
    private List<Integer> listColleEquip;
    private String[] unitNames = new String[9];
    private int playerUID = -1;
    private Map<Integer, TeamData> mapTeamData;
    private List<TeamData> listTeamData;
    private Map<Integer, String> targetClassMap;
    private ItemStackHandler itemHandler;
    private int appearance = -1;
    private EntityLivingBase morphEntity = null;
    private int[] shipMinor;

    public CapaTeitoku() {
        this.selectState = new boolean[9][6];
        this.sidList = new int[9][6];
        this.formatID = new int[9];
        this.listShipEID = new ArrayList<>();
        this.listColleShip = new ArrayList<>();
        this.listColleEquip = new ArrayList<>();
        this.mapTeamData = new HashMap<>();
        this.listTeamData = new ArrayList<>();
        this.targetClassMap = new HashMap<>();
        this.itemHandler = new ItemStackHandler(this.getSizeInventory());
        this.shipMinor = new int[3];
    }

    public void init(EntityPlayer player) {
        LogHelper.debugHighLevel("DEBUG: init player capability data.");
        this.player = player;
        this.playerName = player.getName();
        this.needInit = false;
    }

    @Override
    public NBTTagCompound saveNBTData(NBTTagCompound nbt) {
        NBTTagCompound nbtExt = new NBTTagCompound();
        nbtExt.setBoolean("hasRing", this.hasRing);
        nbtExt.setBoolean("RingOn", this.isRingActive);
        nbtExt.setBoolean("RingFly", this.isRingFlying);
        nbtExt.setIntArray("FormatID", this.formatID);
        nbtExt.setInteger("MarriageNum", this.marriageNum);
        nbtExt.setInteger("BossCD", this.bossCooldown);
        nbtExt.setInteger(KEY_PLAYER_UID, this.playerUID);
        nbtExt.setInteger("TeamCD", this.teamCooldown);
        nbtExt.setInteger("Appearance", this.appearance);
        try {
            nbtExt.setString("PlayerName", this.playerName);
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: player name is empty string.");
            e.printStackTrace();
        }

        if (this.initSID) {
            LogHelper.debug("DEBUG: save player ExtNBT: update ship UID from teamList");
            this.updateSID();
        }

        for (int i = 0; i < 9; ++i) {
            nbtExt.setIntArray("TeamList" + i, this.getSID(i));
            nbtExt.setByteArray("SelectState" + i, this.getSelectStateByte(i));
        }

        int[] arrtemp = CalcHelper.intListToArray(this.listColleShip);
        nbtExt.setIntArray("ColleShip", arrtemp);
        arrtemp = CalcHelper.intListToArray(this.listColleEquip);
        nbtExt.setIntArray("ColleEquip", arrtemp);

        if (this.targetClassMap != null) {
            NBTTagList list = new NBTTagList();
            this.targetClassMap.forEach((k, v) -> {
                NBTTagString str = new NBTTagString(v);
                list.appendTag(str);
            });
            nbtExt.setTag("CustomTargetClass", list);
        }

        for (int i = 0; i < 9; ++i) {
            if (this.unitNames[i] != null && this.unitNames[i].length() > 1) {
                nbtExt.setString(KEY_UNIT_NAME_PREFIX + i, this.unitNames[i]);
            } else {
                nbtExt.setString(KEY_UNIT_NAME_PREFIX + i, " ");
            }
        }

        if (this.itemHandler == null) {
            this.itemHandler = new ItemStackHandler(this.getSizeInventory());
        }
        nbtExt.setTag(INV_KEY, this.itemHandler.serializeNBT());

        if (this.shipMinor != null) {
            nbtExt.setInteger("NumGrudge", this.shipMinor[0]);
            nbtExt.setInteger("NumAmmoL", this.shipMinor[1]);
            nbtExt.setInteger("NumAmmoH", this.shipMinor[2]);
        }

        nbt.setTag(CAPA_KEY, nbtExt);
        LogHelper.debug("DEBUG : save player ExtNBT data on: " + this.player);
        return nbt;
    }

    @Override
    public void loadNBTData(NBTTagCompound nbt) {
        NBTTagCompound nbtExt = (NBTTagCompound) nbt.getTag(CAPA_KEY);
        LogHelper.debug("DEBUG: player loadNBTData: get data " + nbtExt);
        try {
            this.hasRing = nbtExt.getBoolean("hasRing");
            this.isRingActive = nbtExt.getBoolean("RingOn");
            this.isRingFlying = nbtExt.getBoolean("RingFly");
            this.formatID = nbtExt.getIntArray("FormatID");
            this.marriageNum = nbtExt.getInteger("MarriageNum");
            this.bossCooldown = nbtExt.getInteger("BossCD");
            this.playerUID = nbtExt.getInteger(KEY_PLAYER_UID);
            this.teamCooldown = nbtExt.getInteger("TeamCD");
            this.appearance = nbtExt.getInteger("Appearance");
            this.listColleShip = CalcHelper.intArrayToList(nbtExt.getIntArray("ColleShip"));
            this.listColleEquip = CalcHelper.intArrayToList(nbtExt.getIntArray("ColleEquip"));

            for (int i = 0; i < 9; ++i) {
                byte[] byteSelect = nbtExt.getByteArray("SelectState" + i);
                int[] sid = nbtExt.getIntArray("TeamList" + i);
                if (sid.length > 5) {
                    for (int j = 0; j < 6; ++j) {
                        this.selectState[i][j] = byteSelect[j] == 1;
                        this.sidList[i][j] = sid[j];
                    }
                }
            }

            if (this.unitNames == null) {
                this.unitNames = new String[9];
            }
            for (int i = 0; i < 9; ++i) {
                this.unitNames[i] = nbtExt.getString(KEY_UNIT_NAME_PREFIX + i);
            }

            if (nbtExt.hasKey(INV_KEY)) {
                if (this.itemHandler == null) {
                    this.itemHandler = new ItemStackHandler(this.getSizeInventory());
                }
                this.itemHandler.deserializeNBT((NBTTagCompound) nbtExt.getTag(INV_KEY));
            }

            if (this.shipMinor == null) {
                this.shipMinor = new int[3];
            }
            this.shipMinor[0] = nbtExt.getInteger("NumGrudge");
            this.shipMinor[1] = nbtExt.getInteger("NumAmmoL");
            this.shipMinor[2] = nbtExt.getInteger("NumAmmoH");
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: player loadNBTData: load fail: " + e);
            e.printStackTrace();
        }
        LogHelper.debug("DEBUG: load player ExtNBT data on: " + this.player);
    }
    
    public EntityPlayer getPlayer() { return player; }

    public boolean needInit() { return needInit; }
    public boolean isInitSID() { return initSID; }
    public void setInitSID(boolean initSID) { this.initSID = initSID; }
    public EntityLivingBase getMorphEntity() { return morphEntity; }
    public void setMorphEntity(EntityLivingBase morphEntity) { this.morphEntity = morphEntity; }
    public boolean isRingActive() { return this.isRingActive; }
    public boolean isRingFlying() { return this.isRingFlying; }
    public boolean hasRing() { return this.hasRing; }

    public boolean hasTeam() {
        if (this.player != null && !this.player.world.isRemote && ServerProxy.getTeamData(this.playerUID) != null) {
            return true;
        }
        return this.hasTeam;
    }

    public int getMarriageNum() { return this.marriageNum; }
    public int getBossCooldown() { return this.bossCooldown; }

    public BasicEntityShip getShipEntityCurrentTeam(int id) {
        return this.getShipEntity(this.teamId, id);
    }

    public BasicEntityShip getShipEntity(int tid, int id) {
        try {
            return this.teamList[tid][id];
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: get ship entity from extProps fail: " + e);
            e.printStackTrace();
            return null;
        }
    }

    public BasicEntityShip[] getShipEntityAll(int tid) {
        try {
            return this.teamList[tid];
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: get all ship entity from extProps fail: " + e);
            e.printStackTrace();
            return new BasicEntityShip[0];
        }
    }

    public List<BasicEntityShip> getShipEntityAllList(int tid) {
        List<BasicEntityShip> list = new ArrayList<>();
        if (this.teamList[tid] != null) {
            Collections.addAll(list, this.teamList[tid]);
        }
        return list;
    }

    public BasicEntityShip[][] getShipEntityAllTeams() {
        try {
            return this.teamList;
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: get all ship entity from extProps fail: " + e);
            e.printStackTrace();
            return new BasicEntityShip[0][0];
        }
    }

    public List<BasicEntityShip> getShipEntityByMode(int mode) {
        List<BasicEntityShip> ships = new ArrayList<>();
        switch (mode) {
            case 1:
                for (int i = 0; i < 6; ++i) {
                    if (this.getSelectStateCurrentTeam(i) && this.teamList[this.teamId][i] != null) {
                        ships.add(this.teamList[this.teamId][i]);
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 6; ++i) {
                    if (this.teamList[this.teamId][i] != null) {
                        ships.add(this.teamList[this.teamId][i]);
                    }
                }
                break;
            default:
                for (int i = 0; i < 6; ++i) {
                    if (this.getSelectStateCurrentTeam(i) && this.teamList[this.teamId][i] != null) {
                        ships.add(this.teamList[this.teamId][i]);
                        return ships;
                    }
                }
        }
        return ships;
    }

    public byte[] getSelectStateByte(int tid) {
        byte[] byteState = new byte[6];
        if (tid > 5) tid = 0;

        if (this.selectState[tid] != null) {
            for (int i = 0; i < 6; ++i) {
                byteState[i] = this.selectState[tid][i] ? (byte) 1 : 0;
            }
        }
        return byteState;
    }

    public boolean[][] getSelectStateAllTeams() { return this.selectState; }

    public boolean[] getSelectState(int tid) {
        try {
            return this.selectState[tid];
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: get ship select state fail: " + e);
            e.printStackTrace();
            return new boolean[6];
        }
    }

    public boolean getSelectStateCurrentTeam(int id) {
        if (id > 5) id = 0;
        return this.selectState[this.teamId][id];
    }

    public int getSID(int tid, int pos) {
        try {
            return this.sidList[tid][pos];
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: get ship ID fail: " + e);
            e.printStackTrace();
            return -1;
        }
    }

    public int[] getSID(int tid) {
        if (this.sidList != null && this.sidList[tid] != null) {
            return this.sidList[tid];
        }
        return new int[0];
    }

    public int[][] getSID() { return this.sidList; }

    public int getSIDCurrentTeam(int id) {
        if (id > 5) id = 0;
        return this.sidList[this.teamId][id];
    }

    public int getCurrentTeamID() { return this.teamId; }
    public int getPlayerUID() { return this.playerUID; }

    public List<Integer> getPlayerTeamBannedList() {
        if (this.playerUID > 0) {
            TeamData tdata = this.mapTeamData.get(this.playerUID);
            if (tdata != null) {
                return tdata.getTeamBannedList();
            }
        }
        return Collections.emptyList();
    }

    public List<Integer> getPlayerTeamAllyList() {
        if (this.playerUID > 0) {
            TeamData tdata = this.mapTeamData.get(this.playerUID);
            if (tdata != null) {
                return tdata.getTeamAllyList();
            }
        }
        return Collections.emptyList();
    }

    public Map<Integer, TeamData> getPlayerTeamDataMap() { return this.mapTeamData; }
    public List<TeamData> getPlayerTeamDataList() { return this.listTeamData; }
    public TeamData getPlayerTeamData(int par1) { return this.mapTeamData.get(par1); }
    public int getPlayerTeamCooldown() { return this.teamCooldown; }
    public int getPlayerTeamCooldownInSec() { return (int) (this.teamCooldown * 0.05f); }
    public List<Integer> getShipEIDList() { return this.listShipEID; }
    public List<Integer> getColleShipList() { return this.listColleShip; }
    public List<Integer> getColleEquipList() { return this.listColleEquip; }
    public Map<Integer, String> getTargetClassMap() { return this.targetClassMap; }
    public int getAppearance() {return this.appearance;}

    public void setAppearance(int value) {
        if (value < 0 || value > 2) {
            return;
        }
        this.appearance = value;
        if (this.player != null && !this.player.world.isRemote && this.player instanceof EntityPlayerMP) {
            CommonProxy.channelG.sendTo(new S2CGUIPackets((byte) 50, this.appearance), (EntityPlayerMP) this.player);
        }
    }

    public boolean isGuiOpening() { return this.isGuiOpening; }

    public int[] getFormatID() {
        if (this.formatID == null || this.formatID.length != 9) {
            this.formatID = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        }
        return this.formatID;
    }

    public int getFormatID(int teamID) {
        try {
            return this.formatID[teamID];
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: get formation id fail: " + e);
            e.printStackTrace();
            return 0;
        }
    }

    public int getFormatIDCurrentTeam() { return this.getFormatID(this.teamId); }

    public int getNumberOfShip(int teamID) {
        int num = 0;
        for (int i = 0; i < 6; ++i) {
            if (this.teamList[teamID][i] != null && this.teamList[teamID][i].isEntityAlive()) {
                ++num;
            }
        }
        return num;
    }

    public int getFormationPos(int teamID, int sid) {
        int pos = 0;
        for (int i = 0; i < 6; ++i) {
            if (this.teamList[teamID][i] != null) {
                if (this.sidList[teamID][i] == sid) {
                    return pos;
                }
                ++pos;
            }
        }
        return -1;
    }

    public float getMinMOVInTeam(int teamID) {
        float mov = 10.0f;
        boolean getnoship = true;
        try {
            for (BasicEntityShip ship : this.teamList[teamID]) {
                if (ship != null) {
                    getnoship = false;
                    float temp = ship.getAttrs().getMoveSpeed();
                    if (temp < mov) {
                        mov = temp;
                    }
                }
            }
            if (getnoship) {
                LogHelper.debug("DEBUG: get min move speed: no ship in team");
                return 0.0f;
            }
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: get entity MOV from extProps fail: " + e);
            e.printStackTrace();
            return 0.0f;
        }
        return mov;
    }

    public String[] getUnitName() {
        return this.unitNames != null ? this.unitNames : new String[9];
    }

    public String getUnitName(int tid) {
        if (this.unitNames != null && tid >= 0 && tid < this.unitNames.length) {
            return this.unitNames[tid];
        }
        return "";
    }

    public void setRingActive(boolean par1) { this.isRingActive = par1; }
    public void setRingFlying(boolean par1) { this.isRingFlying = par1; }
    public void setHasRing(boolean par1) { this.hasRing = par1; }
    public void setMarriageNum(int par1) { this.marriageNum = par1; }
    public void setBossCooldown(int par1) { this.bossCooldown = par1; }

    public void setSIDCurrentTeam(int pos, int sid) {
        try {
            this.sidList[this.teamId][pos] = sid;
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: set current team ship ID fail: " + e);
            e.printStackTrace();
        }
    }

    public void setSelectStateCurrentTeam(int id, boolean par1) {
        try {
            this.selectState[this.teamId][id] = par1;
        } catch (Exception e) {
            LogHelper.info("EXCEPTION : set current team select state fail.");
            e.printStackTrace();
        }
    }

    public void setPointerTeamID(int par1) {
        this.teamId = (par1 > 9) ? 0 : par1;
    }

    public void setPlayerUID(int par1) { this.playerUID = par1; }

    public void setPlayerTeamDataMap(Map<Integer, TeamData> par1) {
        if (par1 != null) {
            this.mapTeamData = par1;
            this.listTeamData = new ArrayList<>(this.mapTeamData.values());
        } else {
            this.mapTeamData = new HashMap<>();
            this.listTeamData = new ArrayList<>();
        }
    }

    public void setPlayerTeamCooldown(int par1) { this.teamCooldown = par1; }
    public void setShipEIDList(List<Integer> list) { this.listShipEID = list; }
    public void setColleShipList(List<Integer> list) { this.listColleShip = list; }
    public void setColleEquipList(List<Integer> list) { this.listColleEquip = list; }

    public void setColleShip(int shipID) {
        if (!this.listColleShip.contains(shipID)) {
            this.listColleShip.add(shipID);
        }
    }

    public void setColleEquip(int equipID) {
        if (!this.listColleEquip.contains(equipID)) {
            this.listColleEquip.add(equipID);
        }
    }

    public void setTargetClass(Map<Integer, String> map) {
        if (map != null) {
            this.targetClassMap = map;
        }
    }

    public void setGuiOpening(boolean par1) { this.isGuiOpening = par1; }
    public void setFormatID(int[] par1) { this.formatID = par1; }

    public void setFormatID(int tid, int fid) {
        try {
            this.formatID[tid] = fid;
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: set ship team formation id fail: " + e);
            e.printStackTrace();
        }
    }

    public void setFormatIDCurrentTeam(int fid) {
        try {
            this.formatID[this.teamId] = fid;
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: set current team formation id fail: " + e);
            e.printStackTrace();
        }
    }

    public void setTeamList(BasicEntityShip[][] par1) { System.arraycopy(par1, 0, this.teamList, 0, par1.length); }
    public void setSelectState(boolean[][] par1) { this.selectState = par1; }
    public void setSIDList(int[][] par1) { this.sidList = par1; }

    public void setTeamList(int tid, BasicEntityShip[] par1) {
        try {
            this.teamList[tid] = par1;
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: set ship team entity fail: " + e);
            e.printStackTrace();
        }
    }

    public void setSelectState(int tid, boolean[] par1) {
        try {
            this.selectState[tid] = par1;
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: set ship team select state fail: " + e);
            e.printStackTrace();
        }
    }

    public void setSIDList(int tid, int[] par1) {
        try {
            this.sidList[tid] = par1;
        } catch (Exception e) {
            LogHelper.info("EXCEPTION : set ship team SID list fail: " + e);
        }
    }

    public void setHasTeam(boolean par1) { this.hasTeam = par1; }
    public void setUnitName(String[] str) { this.unitNames = str; }
    public void setUnitName(int tid, String str) { this.unitNames[tid] = (str == null) ? "" : str; }

    public void addShipEntityToCurrentTeam(int slot, BasicEntityShip entity) {
        if (slot > 5) return;
        if (entity == null) {
            this.teamList[this.teamId][slot] = null;
            this.sidList[this.teamId][slot] = -1;
            this.selectState[this.teamId][slot] = false;
        } else {
            this.teamList[this.teamId][slot] = entity;
            this.sidList[this.teamId][slot] = entity.getShipUID();
        }
    }

    public void addShipEntity(int slot, BasicEntityShip entity, boolean forceAdd) {
        if (forceAdd) {
            if (slot > 5) slot = 0;
            addShipEntityToCurrentTeam(slot, entity);
            return;
        }
        if (entity != null) {
            if (this.player != null && !TeamHelper.checkSameOwner(this.player, entity)) return;
            int inTeam = this.checkIsInCurrentTeam(entity.getShipUID());
            if (inTeam >= 0) {
                this.addShipEntityToCurrentTeam(inTeam, null);
                this.saveId = inTeam;
                this.setSelectStateCurrentTeam(inTeam, false);
                return;
            }
            for (int i = 0; i < 6; ++i) {
                if (this.teamList[this.teamId][i] == null) {
                    this.setSelectStateCurrentTeam(i, false);
                    this.addShipEntityToCurrentTeam(i, entity);
                    this.saveId = (i + 1 > 5) ? 0 : i + 1;
                    return;
                }
            }
            this.setSelectStateCurrentTeam(this.saveId, false);
            this.addShipEntityToCurrentTeam(this.saveId, entity);
            this.saveId = (this.saveId + 1 > 5) ? 0 : this.saveId + 1;
        } else {
            if (slot > 5) slot = 0;
            this.setSelectStateCurrentTeam(slot, false);
            this.addShipEntityToCurrentTeam(slot, null);
        }
    }

    public int[] checkIsInFormation(int shipID) {
        int[] val = new int[]{-1, -1};
        if (shipID > 0) {
            for (int i = 0; i < 9; ++i) {
                if (this.getFormatID(i) > 0) {
                    val = this.checkIsInTeam(shipID, i);
                    if(val[0] > 4 && val[1] >= 0) {
                        val[0] = i;
                        break;
                    }
                }
            }
        }
        if (val[1] < 0) val[0] = -1;
        return val;
    }

    public int checkIsInCurrentTeam(int shipID) {
        return this.checkIsInTeam(shipID, this.teamId)[1];
    }

    public int[] checkIsInTeam(int shipID, int teamID) {
        int[] val = new int[]{0, -1};
        try {
            for (int i = 0; i < 6; ++i) {
                if (this.teamList[teamID][i] != null && this.teamList[teamID][i].isEntityAlive()) {
                    val[0]++;
                    if (this.teamList[teamID][i].getShipUID() == shipID) {
                        val[1] = i;
                    }
                } else {
                    this.teamList[teamID][i] = null;
                }
            }
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: check ship in team fail: " + e);
            e.printStackTrace();
        }
        return val;
    }

    public void clearSelectStateCurrentTeam() {
        Arrays.fill(this.selectState[this.teamId], false);
    }

    public void removeShipCurrentTeam() {
        for (int i = 0; i < 6; ++i) {
            this.teamList[this.teamId][i] = null;
            this.sidList[this.teamId][i] = -1;
            this.selectState[this.teamId][i] = false;
        }
    }

    public void clearAllTargetClass() { this.targetClassMap.clear(); }

    public void updateSID() {
        if (this.sidList != null) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 6; ++j) {
                    if (this.teamList[i][j] != null) {
                        this.sidList[i][j] = this.teamList[i][j].getShipUID();
                    }
                }
            }
        }
    }

    public void updateShipEntityBySID() {
        if (this.sidList != null) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 6; ++j) {
                    this.teamList[i][j] = this.sidList[i][j] > 0 ? EntityHelper.getShipByUID(this.sidList[i][j]) : null;
                }
            }
            this.initSID = true;
        }
    }

    public boolean isTeamAlly(int par1) {
        if (par1 == 0) return true;
        List<Integer> allyList = this.getPlayerTeamAllyList();
        return this.player.world.isRemote && allyList != null && allyList.contains(par1);
    }

    public boolean isTeamBanned(int par1) {
        if (par1 == 0) return false;
        List<Integer> bannedList = this.getPlayerTeamBannedList();
        return this.player.world.isRemote && bannedList != null && bannedList.contains(par1);
    }

    public void sendSyncPacket(int type) {
        if (this.player.world != null && !this.player.world.isRemote) {
            EntityPlayerMP playerMP = (EntityPlayerMP) this.player;
            switch (type) {
                case 0:
                    this.updateShipEntityBySID();
                    CommonProxy.channelG.sendTo(new S2CGUIPackets(this, (byte) 40), playerMP);
                    break;
                case 1:
                    CommonProxy.channelG.sendTo(new S2CGUIPackets(this, (byte) 43), playerMP);
                    break;
                case 2:
                    CommonProxy.channelG.sendTo(new S2CGUIPackets(this, (byte) 41), playerMP);
                    break;
                case 3:
                    CommonProxy.channelG.sendTo(new S2CGUIPackets(this, (byte) 42), playerMP);
                    break;
                case 4:
                    CommonProxy.channelG.sendTo(new S2CGUIPackets(this, (byte) 44), playerMP);
                    break;
                case 5:
                    CommonProxy.channelG.sendTo(new S2CGUIPackets((byte) 46, this.getColleShipList()), playerMP);
                    break;
                case 6:
                    CommonProxy.channelG.sendTo(new S2CGUIPackets((byte) 47, this.getColleEquipList()), playerMP);
                    break;
                case 7:
                    CommonProxy.channelG.sendTo(new S2CGUIPackets(this, (byte) 48), playerMP);
                    break;
                case 8:
                    CommonProxy.channelG.sendTo(new S2CGUIPackets(this, (byte) 49), playerMP);
                    break;
                default:
                    break;
            }
        }
    }

    public void syncShips(int teamID) {
        if (this.player.world != null && !this.player.world.isRemote) {
            CommonProxy.channelG.sendTo(new S2CGUIPackets(this, (byte) 45, teamID), (EntityPlayerMP) this.player);
        }
    }

    public void swapShip(int tid, int posA, int posB) {
        if (tid < 0 || tid > 8 || posA < 0 || posA > 5 || posB < 0 || posB > 5) return;
        BasicEntityShip shipA = this.teamList[tid][posA];
        int sidA = this.sidList[tid][posA];
        boolean selA = this.selectState[tid][posA];
        this.teamList[tid][posA] = this.teamList[tid][posB];
        this.sidList[tid][posA] = this.sidList[tid][posB];
        this.selectState[tid][posA] = this.selectState[tid][posB];
        this.teamList[tid][posB] = shipA;
        this.sidList[tid][posB] = sidA;
        this.selectState[tid][posB] = selA;
        if (this.teamList[tid][posA] != null) this.teamList[tid][posA].setUpdateFlag(0, true);
        if (this.teamList[tid][posB] != null) this.teamList[tid][posB].setUpdateFlag(0, true);
        List<BasicEntityShip> ships = new ArrayList<>();
        for (BasicEntityShip ship : this.teamList[tid]) {
            if (ship != null) ships.add(ship);
        }
        if (ships.size() > 4) {
            FormationHelper.applyFormationMoving(ships, this.getFormatID(tid), (int) ships.get(0).posX, (int) ships.get(0).posY, (int) ships.get(0).posZ, false);
        }
    }

    public static CapaTeitoku getTeitokuCapability(int entityID, int worldID, boolean isClient) {
        EntityPlayer player = EntityHelper.getEntityPlayerByID(entityID, worldID, isClient);
        return CapaTeitoku.getTeitokuCapability(player);
    }

    public static CapaTeitoku getTeitokuCapability(int pid) {
        EntityPlayer player = EntityHelper.getEntityPlayerByUID(pid);
        return CapaTeitoku.getTeitokuCapability(player);
    }

    public static CapaTeitoku getTeitokuCapabilityClientOnly() {
        return CapaTeitoku.getTeitokuCapability(ClientProxy.getClientPlayer());
    }

    public static CapaTeitoku getTeitokuCapability(EntityPlayer player) {
        if (player == null) return null;
        return (CapaTeitoku) player.getCapability(CapaTeitokuProvider.TeitokuCapability, null);
    }

    public static void setCapaDataMisc(int[] value) {
        EntityPlayer player = ClientProxy.getClientPlayer();
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa != null) {
            if (capa.needInit()) capa.init(player);
            capa.setRingActive(value[0] > 0);
            capa.setHasTeam(value[1] > 0);
            capa.setPointerTeamID(value[2]);
            capa.setMarriageNum(value[3]);
            capa.setPlayerUID(value[4]);
            capa.setPlayerTeamCooldown(value[5]);
            if (!capa.isRingActive() && !player.capabilities.isCreativeMode && capa.isRingFlying()) {
                LogHelper.debug("DEBUG: cancel fly by right click");
                player.capabilities.isFlying = false;
                capa.setRingFlying(false);
            }
        }
    }

    public static void setCapaDataTeamList(int teamid, int[] formatID, int[] teamlist, boolean[] selstate) {
        EntityPlayer player = ClientProxy.getClientPlayer();
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa != null) {
            capa.setPointerTeamID(teamid);
            capa.setFormatID(formatID);
            for (int i = 0; i < 6; ++i) {
                capa.setSelectStateCurrentTeam(i, selstate[i]);
                if (teamlist[i * 2] <= 0) {
                    capa.addShipEntity(i, null, true);
                } else {
                    Entity getEnt = EntityHelper.getEntityByID(teamlist[i * 2], 0, true);
                    if (getEnt instanceof BasicEntityShip) {
                        capa.addShipEntity(i, (BasicEntityShip) getEnt, true);
                    } else {
                        capa.addShipEntity(i, null, true);
                    }
                }
                capa.setSIDCurrentTeam(i, teamlist[i * 2 + 1]);
            }
        }
    }

    public List<Integer> getShipTeamIDArray(int shipUID) {
        List<Integer> tid = new ArrayList<>();
        if (this.sidList != null) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 6; ++j) {
                    if (this.sidList[i][j] == shipUID) {
                        tid.add(i);
                    }
                }
            }
        }
        return tid;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            if (!this.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override public String getName() { return "CapaTeitokuInventory"; }
    @Override public boolean hasCustomName() { return false; }
    @Override public ITextComponent getDisplayName() { return null; }
    @Override public int getSizeInventory() { return 6; }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.itemHandler.getStackInSlot(index);
    }

    @Override
    public ItemStack decrStackSize(int id, int count) {
        try {
            if (id >= 0 && id < this.itemHandler.getSlots() && count > 0) {
                return this.itemHandler.extractItem(id, count, false);
            }
            return ItemStack.EMPTY;
        } catch (Exception e) {
            e.printStackTrace();
            return ItemStack.EMPTY;
        }
    }

    @Override public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = this.getStackInSlot(index);
        this.setInventorySlotContents(index, ItemStack.EMPTY);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int id, ItemStack stack) {
        if (this.itemHandler != null && this.itemHandler.getSlots() > id) {
            this.itemHandler.setStackInSlot(id, stack);
            if (stack.getCount() > this.getInventoryStackLimit()) {
                stack.setCount(this.getInventoryStackLimit());
            }
            if (this.player != null && this.player.world != null && !this.player.world.isRemote && id < 6 && this.morphEntity instanceof BasicEntityShip) {
                ((BasicEntityShip) this.morphEntity).calcShipAttributes(2, true);
            }
        }
    }

    @Override public int getInventoryStackLimit() { return 1; }
    @Override public void markDirty() {}
    @Override public boolean isUsableByPlayer(EntityPlayer player) { return true; }
    @Override public void openInventory(EntityPlayer player) {}
    @Override public void closeInventory(EntityPlayer player) {}
    @Override public boolean isItemValidForSlot(int index, ItemStack stack) { return true; }
    @Override public int getField(int id) { return 0; }
    @Override public void setField(int id, int value) {}
    @Override public int getFieldCount() { return 0; }
    @Override public void clear() { this.itemHandler = new ItemStackHandler(this.getSizeInventory()); }
}