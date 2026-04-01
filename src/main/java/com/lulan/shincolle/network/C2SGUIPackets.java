package com.lulan.shincolle.network;

import com.lulan.shincolle.ShinColle;
import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.intermod.MetamorphHelper;
import com.lulan.shincolle.proxy.ServerProxy;
import com.lulan.shincolle.tileentity.TileEntityDesk;
import com.lulan.shincolle.utility.*;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.HashMap;
import java.util.List;

public class C2SGUIPackets
implements IMessage {
    private Entity entity;
    private TileEntity tile;
    private byte packetType;
    private int[] valueInt;
    private byte[] valueByte;
    private String valueStr;

    public C2SGUIPackets() {}

    public C2SGUIPackets(Entity entity, byte type, int ... parms) {
        this.packetType = type;
        this.valueInt = parms;
        this.entity = entity;
    }

    public C2SGUIPackets(TileEntity tile, byte type, int ... parms) {
        this.packetType = type;
        this.valueInt = parms;
        this.tile = tile;
    }

    public C2SGUIPackets(EntityPlayer player, byte type, String str) {
        this.packetType = type;
        this.valueStr = str;
        this.entity = player;
    }

    public void fromBytes(ByteBuf buf) {
        this.packetType = buf.readByte();
        switch (this.packetType) {
            case 0: 
            case 2: 
            case 3: {
                this.valueInt = PacketHelper.readIntArray(buf, 4);
                break;
            }
            case 1: {
                this.valueInt = PacketHelper.readIntArray(buf, 4);
                this.valueByte = PacketHelper.readByteArray(buf, 3);
                break;
            }
            case 77: {
                this.valueInt = PacketHelper.readIntArray(buf, 5);
                this.valueByte = PacketHelper.readByteArray(buf, this.valueInt[4]);
                break;
            }
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 31: 
            case 32: 
            case 33:
            case 35: 
            case 51: 
            case 72: 
            case 73: 
            case 74: 
            case 75: 
            case 76: {
                int length = buf.readInt();
                this.valueInt = PacketHelper.readIntArray(buf, length);
                break;
            }
            case 34:
                int size = buf.readInt();
                if (size < 0) {
                    this.valueInt = null;
                } else {
                    this.valueInt = new int[size];
                    for (int i = 0; i < size; i++) {
                        this.valueInt[i] = buf.readInt();
                    }
                }
                break;
            case 30: 
            case 36: 
            case 50: 
            case 70: 
            case 71: {
                this.valueInt = PacketHelper.readIntArray(buf, 2);
                this.valueStr = PacketHelper.readString(buf);
                break;
            }
            default:
        }
    }

    public void toBytes(ByteBuf buf) {
        buf.writeByte(this.packetType);
        switch (this.packetType) {
            case 0: 
            case 2: 
            case 3: {
                buf.writeInt(this.entity.getEntityId());
                buf.writeInt(this.entity.world.provider.getDimension());
                buf.writeInt(this.valueInt[0]);
                buf.writeInt(this.valueInt[1]);
                break;
            }
            case 1: {
                buf.writeInt(this.tile.getWorld().provider.getDimension());
                buf.writeInt(this.tile.getPos().getX());
                buf.writeInt(this.tile.getPos().getY());
                buf.writeInt(this.tile.getPos().getZ());
                buf.writeByte(this.valueInt[0]);
                buf.writeByte(this.valueInt[1]);
                buf.writeByte(this.valueInt[2]);
                break;
            }
            case 77: {
                buf.writeInt(this.tile.getWorld().provider.getDimension());
                buf.writeInt(this.tile.getPos().getX());
                buf.writeInt(this.tile.getPos().getY());
                buf.writeInt(this.tile.getPos().getZ());
                buf.writeInt(this.valueInt.length);
                for (int val : this.valueInt) {
                    buf.writeByte(val);
                }
                break;
            }
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 31: 
            case 32: 
            case 33:
            case 35: 
            case 51: 
            case 72: 
            case 73: 
            case 74: 
            case 75: 
            case 76: {
                int length = 2;
                if (this.valueInt != null) {
                    length += this.valueInt.length;
                }
                buf.writeInt(length);
                buf.writeInt(this.entity.getEntityId());
                buf.writeInt(this.entity.world.provider.getDimension());
                if (this.valueInt == null) break;
                for (int val : this.valueInt) {
                    buf.writeInt(val);
                }
                break;
            }
            case 34:
                if (this.valueInt == null) {
                    buf.writeInt(-1);
                } else {
                    buf.writeInt(this.valueInt.length);
                    for (int i : this.valueInt) {
                        buf.writeInt(i);
                    }
                }
                break;
            case 30: 
            case 36: 
            case 50: 
            case 70: 
            case 71: {
                buf.writeInt(this.entity.getEntityId());
                buf.writeInt(this.entity.world.provider.getDimension());
                PacketHelper.sendString(buf, this.valueStr);
                break;
            }
            default:
        }
    }

    private static void handle(C2SGUIPackets msg, MessageContext ctx) {
        block0 : switch (msg.packetType) {
            case 0: {
                Entity entity = EntityHelper.getEntityByID(msg.valueInt[0], msg.valueInt[1], false);
                if (!(entity instanceof BasicEntityShip)) break;
                PacketHelper.setEntityByGUI((BasicEntityShip)entity, msg.valueInt[2], msg.valueInt[3]);
                break;
            }
            case 2: {
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(msg.valueInt[0], msg.valueInt[1], false);
                if (capa == null || !(capa.getMorphEntity() instanceof BasicEntityShip)) break;
                PacketHelper.setEntityByGUI((BasicEntityShip)capa.getMorphEntity(), msg.valueInt[2], msg.valueInt[3]);
                break;
            }
            case 3: {
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(msg.valueInt[0], msg.valueInt[1], false);
                if (capa == null) break;
                MetamorphHelper.handleGUIPacketInput(capa, msg.valueInt[2]);
                break;
            }
            case 1: {
                WorldServer world = ServerProxy.getServerWorld(msg.valueInt[0]);
                if (world == null) break;
                PacketHelper.setTileEntityByGUI(world.getTileEntity(new BlockPos(msg.valueInt[1], msg.valueInt[2], msg.valueInt[3])), msg.valueByte[0], msg.valueByte[1], msg.valueByte[2]);
                break;
            }
            case 77: {
                TileEntity tile;
                WorldServer world = ServerProxy.getServerWorld(msg.valueInt[0]);
                if (world == null || !((tile = world.getTileEntity(new BlockPos(msg.valueInt[1], msg.valueInt[2], msg.valueInt[3]))) instanceof TileEntityDesk)) break;
                TileEntityDesk tile2 = (TileEntityDesk)tile;
                tile2.setField(0, msg.valueByte[0]);
                tile2.setField(1, msg.valueByte[1]);
                tile2.setField(2, msg.valueByte[2]);
                tile2.setField(3, msg.valueByte[3]);
                break;
            }
            case 20: {
                EntityPlayer player = EntityHelper.getEntityPlayerByID(msg.valueInt[0], msg.valueInt[1], false);
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                if (capa == null) break;
                Entity entity = EntityHelper.getEntityByID(msg.valueInt[2], msg.valueInt[1], false);
                if (entity instanceof BasicEntityShip) {
                    capa.addShipEntity(0, (BasicEntityShip)entity, false);
                    capa.setFormatIDCurrentTeam(0);
                    EntityHelper.updateNameTag((BasicEntityShip)entity);
                    ((BasicEntityShip)entity).sendSyncPacketUnitName();
                } else {
                    capa.addShipEntity(0, null, false);
                    capa.setFormatIDCurrentTeam(0);
                }
                capa.sendSyncPacket(0);
                break;
            }
            case 21: {
                EntityPlayer player = EntityHelper.getEntityPlayerByID(msg.valueInt[0], msg.valueInt[1], false);
                Entity entity = EntityHelper.getEntityByID(msg.valueInt[3], msg.valueInt[1], false);
                if (entity == null || player == null || TargetHelper.isEntityInvulnerable(entity) || TeamHelper.checkSameOwner(player, entity) || TeamHelper.checkIsAlly(player, entity)) break;
                FormationHelper.applyTeamAttack(player, msg.valueInt[2], entity);
                break;
            }
            case 28: {
                FormationHelper.applyTeamMove(msg.valueInt);
                break;
            }
            case 34: {
                EntityPlayerMP player = ctx.getServerHandler().player;
                FormationHelper.applySummonShipsToDesk(player, msg.valueInt);
                break;
            }
            case 29: {
                FormationHelper.applyTeamSelect(msg.valueInt);
                break;
            }
            case 23: {
                FormationHelper.applyTeamSit(msg.valueInt);
                break;
            }
            case 25: {
                FormationHelper.applyTeamGuard(msg.valueInt);
                break;
            }
            case 22: {
                EntityPlayer player = EntityHelper.getEntityPlayerByID(msg.valueInt[0], msg.valueInt[1], false);
                Entity entity = EntityHelper.getEntityByID(msg.valueInt[2], msg.valueInt[1], false);
                if (player == null || !(entity instanceof BasicEntityShip)) break;
                FMLNetworkHandler.openGui(player, ShinColle.instance, 0, player.world, msg.valueInt[2], 0, 0);
                break;
            }
            case 24: {
                CapaTeitoku capa;
                ItemStack pointer;
                EntityPlayer player = EntityHelper.getEntityPlayerByID(msg.valueInt[0], msg.valueInt[1], false);
                if (player == null || (pointer = EntityHelper.getPointerInUse(player)) == null) break;
                int oldmeta = pointer.getItemDamage();
                pointer.setItemDamage(msg.valueInt[2]);
                if (MathHelper.abs(msg.valueInt[2] - oldmeta) % 3 == 0 || (capa = CapaTeitoku.getTeitokuCapability(player)) == null || msg.valueInt[2] != 0) break;
                capa.clearSelectStateCurrentTeam();
                for (int j = 0; j < 6; ++j) {
                    if (capa.getShipEntityCurrentTeam(j) == null) continue;
                    capa.setSelectStateCurrentTeam(j, true);
                    capa.sendSyncPacket(0);
                    break block0;
                }
                break;
            }
            case 26: {
                EntityPlayer player = EntityHelper.getEntityPlayerByID(msg.valueInt[0], msg.valueInt[1], false);
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                if (capa == null) break;
                capa.setFormatIDCurrentTeam(0);
                capa.removeShipCurrentTeam();
                capa.sendSyncPacket(0);
                break;
            }
            case 27: {
                EntityPlayer player = EntityHelper.getEntityPlayerByID(msg.valueInt[0], msg.valueInt[1], false);
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                if (capa == null) break;
                if (msg.valueInt[3] >= 0) {
                    player.inventory.currentItem = msg.valueInt[3];
                }
                capa.setPointerTeamID(msg.valueInt[2]);
                capa.sendSyncPacket(0);
                break;
            }
            case 30: {
                int uid;
                EntityPlayer player = EntityHelper.getEntityPlayerByID(msg.valueInt[0], msg.valueInt[1], false);
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                if (capa == null || (uid = capa.getPlayerUID()) <= 0) break;
                if (ServerProxy.setPlayerTargetClass(uid, msg.valueStr)) {
                    player.sendMessage(new TextComponentString(TextFormatting.AQUA + "ADD: " + TextFormatting.YELLOW + msg.valueStr));
                } else {
                    player.sendMessage(new TextComponentString(TextFormatting.RED + "REMOVE: " + TextFormatting.YELLOW + msg.valueStr));
                }
                capa.sendSyncPacket(2);
                break;
            }
            case 70: 
            case 71: {
                int uid;
                EntityPlayer player = EntityHelper.getEntityPlayerByID(msg.valueInt[0], msg.valueInt[1], false);
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                if (capa == null || (uid = capa.getPlayerUID()) <= 0) break;
                switch (msg.packetType) {
                    case 70: {
                        ServerProxy.teamCreate(player, msg.valueStr);
                        break;
                    }
                    case 71: {
                        ServerProxy.teamRename(uid, msg.valueStr);
                        break;
                    }
                    default:
                }
                capa.sendSyncPacket(7);
                capa.sendSyncPacket(3);
                break;
            }
            case 72: 
            case 73: 
            case 74: 
            case 75: 
            case 76: {
                int uid;
                EntityPlayer player = EntityHelper.getEntityPlayerByID(msg.valueInt[0], msg.valueInt[1], false);
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                if (capa == null || (uid = capa.getPlayerUID()) <= 0) break;
                switch (msg.packetType) {
                    case 76: {
                        ServerProxy.teamDisband(player);
                        break;
                    }
                    case 72: {
                        ServerProxy.teamAddAlly(uid, msg.valueInt[2]);
                        break;
                    }
                    case 73: {
                        ServerProxy.teamRemoveAlly(uid, msg.valueInt[2]);
                        break;
                    }
                    case 74: {
                        ServerProxy.teamAddBan(uid, msg.valueInt[2]);
                        break;
                    }
                    case 75: {
                        ServerProxy.teamRemoveBan(uid, msg.valueInt[2]);
                        break;
                    }
                    default:
                }
                List<EntityPlayer> plist = EntityHelper.getEntityPlayerUsingGUI();
                for (EntityPlayer p : plist) {
                    capa = CapaTeitoku.getTeitokuCapability(p);
                    if (capa == null) continue;
                    capa.sendSyncPacket(7);
                    capa.sendSyncPacket(3);
                }
                break;
            }
            case 31: {
                FormationHelper.setFormationID(msg.valueInt);
                break;
            }
            case 32: {
                EntityPlayer player = EntityHelper.getEntityPlayerByID(msg.valueInt[0], msg.valueInt[1], false);
                if (player == null) break;
                if(msg.valueInt[2] == 0){
                    FMLNetworkHandler.openGui(player, ShinColle.instance, 5, player.world, 0, 0, 0);
                }
                break;
            }
            case 33: {
                EntityPlayer player = EntityHelper.getEntityPlayerByID(msg.valueInt[0], msg.valueInt[1], false);
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                if (capa == null) break;
                capa.swapShip(msg.valueInt[2], msg.valueInt[3], msg.valueInt[4]);
                capa.syncShips(msg.valueInt[2]);
                break;
            }
            case 50: {
                EntityPlayer player = EntityHelper.getEntityPlayerByID(msg.valueInt[0], msg.valueInt[1], false);
                if (!EntityHelper.checkOP(player)) break;
                if (ServerProxy.addUnattackableTargetClass(msg.valueStr)) {
                    player.sendMessage(new TextComponentTranslation("chat.shincolle:optool.add").appendText(" " + msg.valueStr));
                    break;
                }
                player.sendMessage(new TextComponentTranslation("chat.shincolle:optool.remove").appendText(" " + msg.valueStr));
                break;
            }
            case 35: {
                Entity entity = EntityHelper.getEntityByID(msg.valueInt[2], msg.valueInt[1], false);
                if (!(entity instanceof BasicEntityShip)) break;
                ((BasicEntityShip)entity).setHitHeight(msg.valueInt[3]);
                ((BasicEntityShip)entity).setHitAngle(msg.valueInt[4]);
                break;
            }
            case 51: {
                EntityPlayer player = EntityHelper.getEntityPlayerByID(msg.valueInt[0], msg.valueInt[1], false);
                if (player == null) break;
                HashMap<Integer, String> tarlist = ServerProxy.getUnattackableTargetClass();
                TextComponentTranslation text = new TextComponentTranslation("chat.shincolle:optool.show");
                text.getStyle().setColor(TextFormatting.GOLD);
                player.sendMessage(text);
                tarlist.forEach((k, v) -> player.sendMessage(new TextComponentString(TextFormatting.AQUA + v)));
                break;
            }
            case 36: {
                EntityPlayerMP player = ctx.getServerHandler().player;
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                if (capa == null) break;
                capa.setUnitName(capa.getCurrentTeamID(), msg.valueStr);
                capa.sendSyncPacket(8);
                for (BasicEntityShip s : capa.getShipEntityAll(capa.getCurrentTeamID())) {
                    if (s == null) continue;
                    EntityHelper.updateNameTag(s);
                    s.sendSyncRequest(1);
                }
                break;
            }
            default:
        }
    }

    public static class Handler
    implements IMessageHandler<C2SGUIPackets, IMessage> {
        public IMessage onMessage(C2SGUIPackets message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> C2SGUIPackets.handle(message, ctx));
            return null;
        }
    }
}
