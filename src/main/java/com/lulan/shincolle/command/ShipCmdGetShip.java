package com.lulan.shincolle.command;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.network.S2CReactPackets;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.proxy.ServerProxy;
import com.lulan.shincolle.server.CacheDataShip;
import com.lulan.shincolle.utility.EntityHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;
import java.util.List;

public class ShipCmdGetShip extends CommandBase {

    private static final ArrayList<String> Aliases = new ArrayList<>();
    private static final String MSG_COMMAND_PREFIX = "chat.shincolle:command.command";

    static {
        Aliases.add("ship");
    }

    protected static final String[] StrArg1 = new String[]{"list", "get", "del"};

    @Override
    public String getName() {
        return Aliases.get(0);
    }

    @Override
    public List<String> getAliases() {
        return Aliases;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/ship <list|get|del> <page number|ship UID>";
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length > 0 && sender instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) sender;
            int cmdType = -1;
            for (int i = 0; i < StrArg1.length; ++i) {
                if (args[0].equals(StrArg1[i])) {
                    cmdType = i;
                    break;
                }
            }
            switch (cmdType) {
                case 0: {
                    int showPage = 0;
                    if (args.length > 1) {
                        showPage = CommandBase.parseInt(args[1]);
                    }
                    CommonProxy.channelI.sendTo(new S2CReactPackets((byte) 3, 0, showPage), (EntityPlayerMP) sender);
                    break;
                }
                case 1: {
                    if (!EntityHelper.checkOP(player)) {
                        sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.notop"));
                        return;
                    }
                    if (args.length < 2) {
                        sender.sendMessage(new TextComponentString(getUsage(sender)));
                        return;
                    }
                    int uid = CommandBase.parseInt(args[1]);
                    if (uid <= 0) return;
                    CacheDataShip data = ServerProxy.getShipWorldData(uid);
                    if (data != null) {
                        if (data.worldID != sender.getEntityWorld().provider.getDimension()) {
                            sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.worldnull"));
                            return;
                        }
                        Vec3d pos1 = sender.getPositionVector();
                        float dx = (float) pos1.x - data.posX;
                        float dy = (float) pos1.y - data.posY;
                        float dz = (float) pos1.z - data.posZ;
                        float dist = dx * dx + dy * dy + dz * dz;
                        if (dist < 4096.0f) {
                            Entity ent = EntityHelper.getEntityByID(data.entityID, data.worldID, false);
                            if (ent instanceof BasicEntityShip && !ent.isDead) {
                                BasicEntityShip ship = (BasicEntityShip) ent;
                                if (ship.getShipUID() == uid) {
                                    ship.dismountRidingEntity();
                                    ship.setAttackTarget(null);
                                    ship.setEntityTarget(null);
                                    ship.motionX = 0.0;
                                    ship.motionY = 0.0;
                                    ship.motionZ = 0.0;
                                    ship.setPosition(pos1.x, pos1.y + 0.5, pos1.z);
                                    ship.setSitting(false);
                                    ship.setGuardedEntity(null);
                                    ship.setGuardedPos((int) pos1.x, (int) (pos1.y + 0.5), (int) pos1.z, ship.world.provider.getDimension(), 1);
                                    ship.setStateFlag(11, false);
                                    ship.updateShipCacheDataWithoutNewID();
                                    ship.sendSyncPacketAll();
                                    sender.sendMessage(new TextComponentTranslation(MSG_COMMAND_PREFIX).appendSibling(new TextComponentString(" ship: " + TextFormatting.YELLOW + "get: " + uid)));
                                    return;
                                }
                            }
                            Entity newEnt = EntityHelper.createShipEntity(player.world, data.classID, data.entityNBT, pos1.x, pos1.y + 0.5, pos1.z, true);
                            if (newEnt instanceof BasicEntityShip) {
                                sender.sendMessage(new TextComponentTranslation(MSG_COMMAND_PREFIX).appendSibling(new TextComponentString(" ship: " + TextFormatting.GREEN + "spawn: " + uid)));
                            } else {
                                if (newEnt != null) newEnt.setDead();
                                sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.shipnull").appendText(" " + uid));
                            }
                        } else {
                            sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.shiptoofar"));
                        }
                    } else {
                        sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.shipnull").appendText(" " + uid));
                    }
                    break;
                }
                case 2: {
                    if (!EntityHelper.checkOP(player)) {
                        sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.notop"));
                        return;
                    }
                    if (args.length < 2) {
                        sender.sendMessage(new TextComponentString(getUsage(sender)));
                        return;
                    }
                    int uid = CommandBase.parseInt(args[1]);
                    if (uid <= 0) return;
                    CacheDataShip data = ServerProxy.getShipWorldData(uid);
                    if (data != null) {
                        ServerProxy.getAllShipWorldData().remove(uid);
                        sender.sendMessage(new TextComponentTranslation(MSG_COMMAND_PREFIX).appendSibling(new TextComponentString(" ship: " + TextFormatting.RED + "delete: " + uid)));
                    } else {
                        sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.shipnull").appendText(" " + uid));
                    }
                    break;
                }
                default:
            }
        } else {
            sender.sendMessage(new TextComponentString(getUsage(sender)));
        }
    }
}