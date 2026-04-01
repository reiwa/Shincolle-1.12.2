package com.lulan.shincolle.network;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.proxy.ServerProxy;
import com.lulan.shincolle.team.TeamData;
import com.lulan.shincolle.tileentity.*;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.PacketHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.*;

public class S2CGUIPackets
implements IMessage {
    private TileEntity tile;
    private BasicEntityShip ship;
    private CapaTeitoku capa;
    private List dataList;
    private Map dataMap;
    private byte packetType;
    private int valueInt;
    private boolean valueBoolean;
    private int[] valueInt1;
    private byte[] valueByte1;
    private boolean[] valueBoolean1;
    private float[] valueFloat1;
    private int[][] valueInt2;
    private int[][] valueInt2a;
    private boolean[][] valueBoolean2;
    private List<String> valueStrs;

    public S2CGUIPackets() {
    }

    public S2CGUIPackets(TileEntity tile, byte type) {
        this.tile = tile;
        this.packetType = type;
    }

    public S2CGUIPackets(CapaTeitoku capa, byte type) {
        if (capa != null) {
            this.packetType = type;
            this.capa = capa;
            if(type == 41){
                this.dataList = PacketHelper.getStringListFromStringMap(ServerProxy.getPlayerTargetClass(this.capa.getPlayerUID()));
            } else if(type == 43){
                this.valueInt1 = this.capa.getFormatID();
            }
        }
    }

    public S2CGUIPackets(CapaTeitoku capa, byte type, int ... parms) {
        if (capa != null) {
            this.packetType = type;
            this.capa = capa;
            if (parms != null && parms.length > 0) {
                this.valueInt1 = parms;
            }
        }
    }

    public S2CGUIPackets(BasicEntityShip ship) {
        this.packetType = (byte)100;
        this.ship = ship;
    }

    public S2CGUIPackets(byte type, int value, boolean flag) {
        this.packetType = type;
        this.valueInt = value;
        this.valueBoolean = flag;
    }

    public S2CGUIPackets(byte type, List list) {
        this.packetType = type;
        this.dataList = list;
    }

    public S2CGUIPackets(byte type, float[] data) {
        this.packetType = type;
        this.valueFloat1 = data;
    }

    public S2CGUIPackets(byte type, int ... parms) {
        this.packetType = type;
        if (parms != null && parms.length > 0) {
            this.valueInt1 = parms;
        }
    }

    public void fromBytes(ByteBuf buf) {
        this.packetType = buf.readByte();
        switch (this.packetType) {
            case 0: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 7);
                break;
            }
            case 1: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 15);
                break;
            }
            case 2: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 7);
                break;
            }
            case 3: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 6);
                break;
            }
            case 4: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 14);
                break;
            }
            case 5: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 16);
                this.valueByte1 = PacketHelper.readByteArray(buf, 4);
                break;
            }
            case 100: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 6);
                break;
            }
            case 40: {
                this.valueInt1 = new int[27];
                this.valueBoolean1 = new boolean[6];
                this.valueInt1[0] = buf.readByte();
                this.valueInt1[1] = buf.readByte();
                this.valueInt1[2] = buf.readByte();
                this.valueInt1[3] = buf.readInt();
                this.valueInt1[4] = buf.readInt();
                this.valueInt1[5] = buf.readInt();
                for (int i = 0; i < 9; ++i) {
                    this.valueInt1[i + 6] = buf.readByte();
                }
                for (int j = 0; j < 6; ++j) {
                    this.valueInt1[j * 2 + 15] = buf.readInt();
                    this.valueInt1[j * 2 + 16] = buf.readInt();
                    this.valueBoolean1[j] = buf.readBoolean();
                }
                break;
            }
            case 48: {
                this.valueInt1 = new int[6];
                this.valueInt1[0] = buf.readByte();
                this.valueInt1[1] = buf.readByte();
                this.valueInt1[2] = buf.readByte();
                this.valueInt1[3] = buf.readInt();
                this.valueInt1[4] = buf.readInt();
                this.valueInt1[5] = buf.readInt();
                break;
            }
            case 49: {
                this.valueStrs = PacketHelper.readListString(buf);
                break;
            }
            case 80: 
            case 81: {
                this.valueBoolean = buf.readBoolean();
                break;
            }
            case 46: 
            case 47: 
            case 101: {
                this.valueInt = buf.readInt();
                this.dataList = new ArrayList();
                if (this.valueInt <= 0) break;
                for (int i = 0; i < this.valueInt; ++i) {
                    this.dataList.add(buf.readInt());
                }
                break;
            }
            case 41: {
                this.valueInt = buf.readInt();
                this.dataMap = new HashMap<>();
                if (this.valueInt <= 0) break;
                for (int i = 0; i < this.valueInt; ++i) {
                    String str = ByteBufUtils.readUTF8String(buf);
                    this.dataMap.put(str.hashCode(), str);
                }
                break;
            }
            case 42: {
                this.valueInt = buf.readInt();
                this.dataMap = new HashMap<>();
                for (int i = 0; i < this.valueInt; ++i) {
                    TeamData tdata = new TeamData();
                    tdata.setTeamID(buf.readInt());
                    List<Integer> list = PacketHelper.readListInt(buf);
                    tdata.setTeamBannedList(list);
                    list = PacketHelper.readListInt(buf);
                    tdata.setTeamAllyList(list);
                    String name = PacketHelper.readString(buf);
                    tdata.setTeamName(name);
                    name = PacketHelper.readString(buf);
                    tdata.setTeamLeaderName(name);
                    this.dataMap.put(tdata.getTeamID(), tdata);
                }
                break;
            }
            case 43: {
                this.valueByte1 = PacketHelper.readByteArray(buf, 9);
                break;
            }
            case 44: {
                this.valueInt1 = new int[11];
                this.valueInt1[0] = buf.readInt();
                for (int i = 0; i < 9; ++i) {
                    this.valueInt1[i + 1] = buf.readByte();
                }
                this.valueInt1[10] = buf.readByte();
                if (this.valueInt1[10] <= 0) break;
                this.valueInt2 = new int[9][6];
                this.valueInt2a = new int[9][6];
                this.valueBoolean2 = new boolean[9][6];
                for (int k = 0; k < 9; ++k) {
                    for (int i = 0; i < 6; ++i) {
                        this.valueInt2[k][i] = buf.readInt();
                        this.valueInt2a[k][i] = buf.readInt();
                        this.valueBoolean2[k][i] = buf.readBoolean();
                    }
                }
                break;
            }
            case 45: {
                this.valueInt1 = new int[15];
                this.valueBoolean1 = new boolean[6];
                this.valueInt1[0] = buf.readInt();
                this.valueInt1[1] = buf.readByte();
                this.valueInt1[2] = buf.readByte();
                if (this.valueInt1[2] <= 0) break;
                for (int i = 0; i < 6; ++i) {
                    this.valueInt1[i * 2 + 3] = buf.readInt();
                    this.valueInt1[i * 2 + 4] = buf.readInt();
                    this.valueBoolean1[i] = buf.readBoolean();
                }
                break;
            }
            case 50: {
                this.valueInt1 = new int[1];
                this.valueInt1[0] = buf.readInt();
                break;
            }
            case 102: {
                this.valueFloat1 = PacketHelper.readFloatArray(buf);
                break;
            }
            default:
        }
    }

    public void toBytes(ByteBuf buf) {
        buf.writeByte(this.packetType);
        switch (this.packetType) {
            case 0: {
                TileEntitySmallShipyard tile2 = (TileEntitySmallShipyard)this.tile;
                buf.writeInt(tile2.getPos().getX());
                buf.writeInt(tile2.getPos().getY());
                buf.writeInt(tile2.getPos().getZ());
                buf.writeInt(tile2.getPowerConsumed());
                buf.writeInt(tile2.getPowerRemained());
                buf.writeInt(tile2.getPowerGoal());
                buf.writeInt(tile2.getPlayerUID());
                break;
            }
            case 1: {
                TileMultiGrudgeHeavy tile2 = (TileMultiGrudgeHeavy)this.tile;
                buf.writeInt(tile2.getPos().getX());
                buf.writeInt(tile2.getPos().getY());
                buf.writeInt(tile2.getPos().getZ());
                buf.writeInt(tile2.getPowerConsumed());
                buf.writeInt(tile2.getPowerRemained());
                buf.writeInt(tile2.getPowerGoal());
                buf.writeInt(tile2.getMatStock(0));
                buf.writeInt(tile2.getMatStock(1));
                buf.writeInt(tile2.getMatStock(2));
                buf.writeInt(tile2.getMatStock(3));
                buf.writeInt(tile2.getMatBuild(0));
                buf.writeInt(tile2.getMatBuild(1));
                buf.writeInt(tile2.getMatBuild(2));
                buf.writeInt(tile2.getMatBuild(3));
                buf.writeInt(tile2.getPlayerUID());
                break;
            }
            case 2: {
                TileEntityDesk tile2 = (TileEntityDesk)this.tile;
                buf.writeInt(tile2.getPos().getX());
                buf.writeInt(tile2.getPos().getY());
                buf.writeInt(tile2.getPos().getZ());
                buf.writeInt(tile2.getField(0));
                buf.writeInt(tile2.getField(1));
                buf.writeInt(tile2.getField(2));
                buf.writeInt(tile2.getField(3));
                break;
            }
            case 3: {
                TileEntityVolCore tile2 = (TileEntityVolCore)this.tile;
                buf.writeInt(tile2.getPos().getX());
                buf.writeInt(tile2.getPos().getY());
                buf.writeInt(tile2.getPos().getZ());
                buf.writeInt(tile2.getPowerRemained());
                buf.writeInt(tile2.getField(0));
                buf.writeInt(tile2.getPlayerUID());
                break;
            }
            case 5: {
                TileEntityCrane tile2 = (TileEntityCrane)this.tile;
                buf.writeInt(tile2.getPos().getX());
                buf.writeInt(tile2.getPos().getY());
                buf.writeInt(tile2.getPos().getZ());
                buf.writeInt(tile2.getLastWaypoint().getX());
                buf.writeInt(tile2.getLastWaypoint().getY());
                buf.writeInt(tile2.getLastWaypoint().getZ());
                buf.writeInt(tile2.getNextWaypoint().getX());
                buf.writeInt(tile2.getNextWaypoint().getY());
                buf.writeInt(tile2.getNextWaypoint().getZ());
                buf.writeInt(tile2.getPairedChest().getX());
                buf.writeInt(tile2.getPairedChest().getY());
                buf.writeInt(tile2.getPairedChest().getZ());
                if (tile2.getShip() != null) {
                    buf.writeInt(tile2.getShip().getEntityId());
                } else {
                    buf.writeInt(-1);
                }
                buf.writeInt(tile2.getField(5));
                buf.writeInt(tile2.getPlayerUID());
                if (tile2.owner != null) {
                    buf.writeInt(tile2.owner.getEntityId());
                } else {
                    buf.writeInt(0);
                }
                buf.writeByte(tile2.getField(2));
                buf.writeByte(tile2.getField(3));
                buf.writeByte(tile2.getField(4));
                buf.writeByte(tile2.getField(8));
                break;
            }
            case 4: {
                TileEntityWaypoint tile2 = (TileEntityWaypoint)this.tile;
                buf.writeInt(tile2.getPos().getX());
                buf.writeInt(tile2.getPos().getY());
                buf.writeInt(tile2.getPos().getZ());
                buf.writeInt(tile2.getLastWaypoint().getX());
                buf.writeInt(tile2.getLastWaypoint().getY());
                buf.writeInt(tile2.getLastWaypoint().getZ());
                buf.writeInt(tile2.getNextWaypoint().getX());
                buf.writeInt(tile2.getNextWaypoint().getY());
                buf.writeInt(tile2.getNextWaypoint().getZ());
                buf.writeInt(tile2.getPairedChest().getX());
                buf.writeInt(tile2.getPairedChest().getY());
                buf.writeInt(tile2.getPairedChest().getZ());
                buf.writeInt(tile2.getPlayerUID());
                if (tile2.owner != null) {
                    buf.writeInt(tile2.owner.getEntityId());
                    break;
                }
                buf.writeInt(0);
                break;
            }
            case 40: {
                buf.writeByte(this.capa.isRingActive() ? 1 : 0);
                buf.writeByte(this.capa.hasTeam() ? 1 : 0);
                buf.writeByte(this.capa.getCurrentTeamID());
                buf.writeInt(this.capa.getMarriageNum());
                buf.writeInt(this.capa.getPlayerUID());
                buf.writeInt(this.capa.getPlayerTeamCooldown());
                int[] fid = this.capa.getFormatID();
                for (int j = 0; j < 9; ++j) {
                    buf.writeByte((byte)fid[j]);
                }
                for (int i = 0; i < 6; ++i) {
                    if (this.capa.getShipEntityCurrentTeam(i) != null) {
                        buf.writeInt(this.capa.getShipEntityCurrentTeam(i).getEntityId());
                    } else {
                        buf.writeInt(-1);
                    }
                    buf.writeInt(this.capa.getSIDCurrentTeam(i));
                    buf.writeBoolean(this.capa.getSelectStateCurrentTeam(i));
                }
                break;
            }
            case 48: {
                buf.writeByte(this.capa.isRingActive() ? 1 : 0);
                buf.writeByte(this.capa.hasTeam() ? 1 : 0);
                buf.writeByte(this.capa.getCurrentTeamID());
                buf.writeInt(this.capa.getMarriageNum());
                buf.writeInt(this.capa.getPlayerUID());
                buf.writeInt(this.capa.getPlayerTeamCooldown());
                break;
            }
            case 49: {
                ArrayList<String> strlist = new ArrayList<>();
                String[] strarr = this.capa.getUnitName();
                for (int i = 0; i < 9; ++i) {
                    if (strarr[i] == null || strarr[i].isEmpty()) {
                        strlist.add(" ");
                        continue;
                    }
                    strlist.add(strarr[i]);
                }
                PacketHelper.sendListString(buf, strlist);
                break;
            }
            case 100: {
                if (this.ship.isMorph()) {
                    EntityPlayer playerentity = this.ship.getMorphHost();
                    if (playerentity != null) {
                        buf.writeInt(playerentity.getEntityId());
                    } else {
                        buf.writeInt(-1);
                    }
                } else {
                    buf.writeInt(this.ship.getEntityId());
                }
                buf.writeInt(this.ship.getStateMinor(1));
                buf.writeInt(this.ship.getStateMinor(6));
                buf.writeInt(this.ship.getStateMinor(4));
                buf.writeInt(this.ship.getStateMinor(5));
                buf.writeInt(this.ship.getCapaShipInventory().getInventoryPage());
                break;
            }
            case 80: 
            case 81: {
                buf.writeBoolean(this.valueBoolean);
                break;
            }
            case 41: 
            case 46: 
            case 47: 
            case 101: {
                if (this.dataList != null) {
                    buf.writeInt(this.dataList.size());
                    Iterator iter = this.dataList.iterator();
                    switch (this.packetType) {
                        case 46: 
                        case 47: 
                        case 101: {
                            while (iter.hasNext()) {
                                buf.writeInt(((Integer)iter.next()).intValue());
                            }
                            break;
                        }
                        case 41: {
                            while (iter.hasNext()) {
                                ByteBufUtils.writeUTF8String(buf, (String)iter.next());
                            }
                            break;
                        }
                        default:
                    }
                    break;
                }
                buf.writeInt(-1);
                break;
            }
            case 42: {
                this.dataMap = ServerProxy.getAllTeamWorldData();
                if (this.dataMap != null) {
                    buf.writeInt(this.dataMap.size());
                    this.dataMap.forEach((k, v) -> {
                        int tid = (Integer)k;
                        TeamData tdata = (TeamData)v;
                        buf.writeInt(tid);
                        PacketHelper.sendListInt(buf, tdata.getTeamBannedList());
                        PacketHelper.sendListInt(buf, tdata.getTeamAllyList());
                        PacketHelper.sendString(buf, tdata.getTeamName());
                        PacketHelper.sendString(buf, tdata.getTeamLeaderName());
                    });
                    break;
                }
                buf.writeInt(-1);
                break;
            }
            case 43: {
                for (int i : this.valueInt1) {
                    buf.writeByte((byte)i);
                }
                break;
            }
            case 44: {
                buf.writeInt(this.capa.getCurrentTeamID());
                int[] fid = this.capa.getFormatID();
                for (int j = 0; j < 9; ++j) {
                    buf.writeByte((byte)fid[j]);
                }
                BasicEntityShip[][] ships = this.capa.getShipEntityAllTeams();
                int[][] sids = this.capa.getSID();
                boolean[][] sels = this.capa.getSelectStateAllTeams();
                if (ships != null && sids != null && sels != null) {
                    buf.writeByte(1);
                    for (int k2 = 0; k2 < 9; ++k2) {
                        for (int i = 0; i < 6; ++i) {
                            if (ships[k2][i] != null) {
                                buf.writeInt(ships[k2][i].getEntityId());
                            } else {
                                buf.writeInt(-1);
                            }
                            buf.writeInt(sids[k2][i]);
                            buf.writeBoolean(sels[k2][i]);
                        }
                    }
                    break;
                }
                buf.writeByte(-1);
                break;
            }
            case 45: {
                buf.writeInt(this.valueInt1[0]);
                buf.writeByte(this.capa.getFormatID(this.valueInt1[0]));
                BasicEntityShip[] ships = this.capa.getShipEntityAll(this.valueInt1[0]);
                int[] sids = this.capa.getSID(this.valueInt1[0]);
                boolean[] sels = this.capa.getSelectState(this.valueInt1[0]);
                if (ships != null && sids != null && sels != null) {
                    buf.writeByte(1);
                    for (int i = 0; i < 6; ++i) {
                        if (ships[i] != null) {
                            buf.writeInt(ships[i].getEntityId());
                        } else {
                            buf.writeInt(-1);
                        }
                        buf.writeInt(sids[i]);
                        buf.writeBoolean(sels[i]);
                    }
                    break;
                }
                buf.writeByte(-1);
                break;
            }
            case 50: {
                if (this.valueInt1 != null && this.valueInt1.length > 0) {
                    buf.writeInt(this.valueInt1[0]);
                } else {
                    buf.writeInt(-1);
                }
                break;
            }
            case 102: {
                if (this.valueFloat1 != null) {
                    PacketHelper.sendArrayFloat(buf, this.valueFloat1);
                    break;
                }
                buf.writeInt(0);
                break;
            }
            default:
        }
    }

    private static void handle(S2CGUIPackets msg) {
        World world = ClientProxy.getClientWorld();
        switch (msg.packetType) {
            case 0: {
                TileEntity tile = world.getTileEntity(new BlockPos(msg.valueInt1[0], msg.valueInt1[1], msg.valueInt1[2]));
                if (!(tile instanceof TileEntitySmallShipyard)) break;
                TileEntitySmallShipyard tile2 = (TileEntitySmallShipyard)tile;
                tile2.setPowerConsumed(msg.valueInt1[3]);
                tile2.setPowerRemained(msg.valueInt1[4]);
                tile2.setPowerGoal(msg.valueInt1[5]);
                tile2.setPlayerUID(msg.valueInt1[6]);
                break;
            }
            case 1: {
                TileEntity tile = world.getTileEntity(new BlockPos(msg.valueInt1[0], msg.valueInt1[1], msg.valueInt1[2]));
                if (!(tile instanceof TileMultiGrudgeHeavy)) break;
                TileMultiGrudgeHeavy tile2 = (TileMultiGrudgeHeavy)tile;
                tile2.setPowerConsumed(msg.valueInt1[3]);
                tile2.setPowerRemained(msg.valueInt1[4]);
                tile2.setPowerGoal(msg.valueInt1[5]);
                tile2.setMatStock(0, msg.valueInt1[6]);
                tile2.setMatStock(1, msg.valueInt1[7]);
                tile2.setMatStock(2, msg.valueInt1[8]);
                tile2.setMatStock(3, msg.valueInt1[9]);
                tile2.setMatBuild(0, msg.valueInt1[10]);
                tile2.setMatBuild(1, msg.valueInt1[11]);
                tile2.setMatBuild(2, msg.valueInt1[12]);
                tile2.setMatBuild(3, msg.valueInt1[13]);
                tile2.setPlayerUID(msg.valueInt1[14]);
                break;
            }
            case 2: {
                TileEntity tile = world.getTileEntity(new BlockPos(msg.valueInt1[0], msg.valueInt1[1], msg.valueInt1[2]));
                if (!(tile instanceof TileEntityDesk)) break;
                TileEntityDesk tile2 = (TileEntityDesk)tile;
                tile2.setField(0, msg.valueInt1[3]);
                tile2.setField(1, msg.valueInt1[4]);
                tile2.setField(2, msg.valueInt1[5]);
                tile2.setField(3, msg.valueInt1[6]);
                break;
            }
            case 3: {
                TileEntity tile = world.getTileEntity(new BlockPos(msg.valueInt1[0], msg.valueInt1[1], msg.valueInt1[2]));
                if (!(tile instanceof TileEntityVolCore)) break;
                TileEntityVolCore tile2 = (TileEntityVolCore)tile;
                tile2.setPowerRemained(msg.valueInt1[3]);
                tile2.setField(0, msg.valueInt1[4]);
                tile2.setPlayerUID(msg.valueInt1[5]);
                break;
            }
            case 4: {
                TileEntity tile = world.getTileEntity(new BlockPos(msg.valueInt1[0], msg.valueInt1[1], msg.valueInt1[2]));
                if (!(tile instanceof TileEntityWaypoint)) break;
                TileEntityWaypoint tile2 = (TileEntityWaypoint)tile;
                tile2.setLastWaypoint(new BlockPos(msg.valueInt1[3], msg.valueInt1[4], msg.valueInt1[5]));
                tile2.setNextWaypoint(new BlockPos(msg.valueInt1[6], msg.valueInt1[7], msg.valueInt1[8]));
                tile2.setPairedChest(new BlockPos(msg.valueInt1[9], msg.valueInt1[10], msg.valueInt1[11]));
                tile2.setPlayerUID(msg.valueInt1[12]);
                tile2.owner = EntityHelper.getEntityPlayerByID(msg.valueInt1[13], 0, true);
                break;
            }
            case 5: {
                TileEntity tile = world.getTileEntity(new BlockPos(msg.valueInt1[0], msg.valueInt1[1], msg.valueInt1[2]));
                Entity entity = EntityHelper.getEntityByID(msg.valueInt1[12], 0, true);
                if (!(tile instanceof TileEntityCrane)) break;
                TileEntityCrane tile2 = (TileEntityCrane)tile;
                tile2.setLastWaypoint(new BlockPos(msg.valueInt1[3], msg.valueInt1[4], msg.valueInt1[5]));
                tile2.setNextWaypoint(new BlockPos(msg.valueInt1[6], msg.valueInt1[7], msg.valueInt1[8]));
                tile2.setPairedChest(new BlockPos(msg.valueInt1[9], msg.valueInt1[10], msg.valueInt1[11]));
                tile2.setField(2, msg.valueByte1[0]);
                tile2.setField(3, msg.valueByte1[1]);
                tile2.setField(4, msg.valueByte1[2]);
                tile2.setField(8, msg.valueByte1[3]);
                tile2.setField(5, msg.valueInt1[13]);
                tile2.setField(11, msg.valueInt1[14]);
                tile2.owner = EntityHelper.getEntityPlayerByID(msg.valueInt1[15], 0, true);
                if (entity instanceof BasicEntityShip) {
                    tile2.setShip((BasicEntityShip)entity);
                    break;
                }
                tile2.setShip(null);
                break;
            }
            case 40: {
                int[] misc = new int[6];
                System.arraycopy(msg.valueInt1, 0, misc, 0, 6);
                int[] formatID = new int[9];
                System.arraycopy(msg.valueInt1, 6, formatID, 0, 9);
                int[] shipList = new int[12];
                for (int i = 0; i < 6; ++i) {
                    shipList[i * 2] = msg.valueInt1[i * 2 + 15];
                    shipList[i * 2 + 1] = msg.valueInt1[i * 2 + 16];
                }
                CapaTeitoku.setCapaDataMisc(misc);
                CapaTeitoku.setCapaDataTeamList(msg.valueInt1[2], formatID, shipList, msg.valueBoolean1);
                break;
            }
            case 48: {
                CapaTeitoku.setCapaDataMisc(msg.valueInt1);
                break;
            }
            case 49: {
                String[] strarr = new String[9];
                for (int i = 0; i < 9; ++i) {
                    strarr[i] = msg.valueStrs.get(i);
                }
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
                if (capa == null) break;
                capa.setUnitName(strarr);
                break;
            }
            case 100: {
                Entity entity = EntityHelper.getEntityByID(msg.valueInt1[0], 0, true);
                BasicEntityShip ship = null;
                if (entity instanceof EntityPlayer) {
                    CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
                    if (capa != null && capa.getMorphEntity() instanceof BasicEntityShip) {
                        ship = (BasicEntityShip)capa.getMorphEntity();
                    }
                } else {
                    ship = (BasicEntityShip)entity;
                }
                if (ship == null) break;
                ship.setStateMinor(1, msg.valueInt1[1]);
                ship.setStateMinor(6, msg.valueInt1[2]);
                ship.setStateMinor(4, msg.valueInt1[3]);
                ship.setStateMinor(5, msg.valueInt1[4]);
                ship.getCapaShipInventory().setInventoryPage(msg.valueInt1[5]);
                break;
            }
            case 80: {
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
                if (capa == null) break;
                capa.setInitSID(msg.valueBoolean);
                break;
            }
            case 81: {
                ClientProxy.showMorphSkills = !ClientProxy.showMorphSkills;
                break;
            }
            case 46: 
            case 47: 
            case 101: {
                if (msg.valueInt <= 0) break;
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
                if (capa != null) {
                    switch (msg.packetType) {
                        case 101: {
                            capa.setShipEIDList(msg.dataList);
                            break;
                        }
                        case 46: {
                            capa.setColleShipList(msg.dataList);
                            break;
                        }
                        case 47: {
                            capa.setColleEquipList(msg.dataList);
                            break;
                        }
                        default:
                    }
                }
                break;
            }
            case 41: {
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
                if (msg.valueInt > 0) {
                    if (capa == null) break;
                    capa.setTargetClass(msg.dataMap);
                    break;
                }
                if (capa == null) break;
                capa.clearAllTargetClass();
                LogHelper.debug("DEBUG: S2C gui sync: clear target class list ");
                break;
            }
            case 42: {
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
                if (capa == null) break;
                capa.setPlayerTeamDataMap(msg.dataMap);
                break;
            }
            case 43: {
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
                if (capa == null) break;
                int[] formatID = new int[9];
                for (int i = 0; i < 9; ++i) {
                    formatID[i] = msg.valueByte1[i];
                }
                capa.setFormatID(formatID);
                break;
            }
            case 44: {
                if (msg.valueInt1[10] <= 0) break;
                int[] formatID = new int[9];
                System.arraycopy(msg.valueInt1, 1, formatID, 0, 9);
                BasicEntityShip[][] ships = new BasicEntityShip[9][6];
                for (int j = 0; j < 9; ++j) {
                    for (int k = 0; k < 6; ++k) {
                        Entity ent;
                        if (msg.valueInt2[j][k] <= 0 || !((ent = EntityHelper.getEntityByID(msg.valueInt2[j][k], 0, true)) instanceof BasicEntityShip)) continue;
                        ships[j][k] = (BasicEntityShip)ent;
                    }
                }
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
                if (capa == null) break;
                capa.setPointerTeamID(msg.valueInt1[0]);
                capa.setFormatID(formatID);
                capa.setTeamList(ships);
                capa.setSelectState(msg.valueBoolean2);
                capa.setSIDList(msg.valueInt2a);
                break;
            }
            case 45: {
                if (msg.valueInt1[2] <= 0) break;
                BasicEntityShip[] ships = new BasicEntityShip[6];
                int[] uids = new int[6];
                for (int i = 0; i < 6; ++i) {
                    Entity ent = EntityHelper.getEntityByID(msg.valueInt1[i * 2 + 3], 0, true);
                    if (ent instanceof BasicEntityShip) {
                        ships[i] = (BasicEntityShip)ent;
                    }
                    uids[i] = msg.valueInt1[i * 2 + 4];
                }
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
                if (capa == null) break;
                capa.setFormatID(msg.valueInt1[0], msg.valueInt1[1]);
                capa.setTeamList(msg.valueInt1[0], ships);
                capa.setSelectState(msg.valueInt1[0], msg.valueBoolean1);
                capa.setSIDList(msg.valueInt1[0], uids);
                break;
            }
            case 50: {
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapabilityClientOnly();
                if (capa != null && msg.valueInt1 != null && msg.valueInt1.length > 0) {
                    capa.setAppearance(msg.valueInt1[0]);
                }
                break;
            }
            case 102: {
                CommonProxy.entityItemList = msg.valueFloat1 != null && msg.valueFloat1.length > 1 ? msg.valueFloat1.clone() : new float[0];
                break;
            }
            default:
        }
    }

    public static class Handler
    implements IMessageHandler<S2CGUIPackets, IMessage> {
        public IMessage onMessage(S2CGUIPackets message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> S2CGUIPackets.handle(message));
            return null;
        }
    }
}
