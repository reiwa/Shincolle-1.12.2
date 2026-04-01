package com.lulan.shincolle.command;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.proxy.ServerProxy;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.ArrayList;
import java.util.List;

public class ShipCmdUpdateOwnerUID
extends CommandBase {
    private static final ArrayList<String> Aliases = new ArrayList<>();
    static {
        Aliases.add("shipupdateowneruid");
    }

    public String getName() {
        return Aliases.get(0);
    }

    public List<String> getAliases() {
        return Aliases;
    }

    public String getUsage(ICommandSender sender) {
        return "/shipupdateowneruid [player name (OP only)]";
    }

    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return sender instanceof EntityPlayer;
    }

    public boolean isUsernameIndex(String[] cmd, int index) {
        return cmd.length > 0 && index == 0;
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = sender.getEntityWorld();
        EntityPlayer player;
        boolean isOP;
        if (!world.isRemote && sender instanceof EntityPlayer) {
            player = (EntityPlayer)sender;
            isOP = EntityHelper.checkOP(player);
            if (args.length == 0) {
                sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.command").appendSibling(new TextComponentString(" shipupdateowneruid: get player: " + TextFormatting.AQUA + player)));
                this.updateShipOwner(player);
            } else if (isOP) {
                player = EntityHelper.getEntityPlayerByName(args[0]);
                if (player != null) {
                    sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.command").appendSibling(new TextComponentString(" shipupdateiwneruid: get player " + TextFormatting.AQUA + player)));
                    this.updateShipOwner(player);
                }
            } else {
                sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.notop"));
            }
        }
    }

    private void updateShipOwner(EntityPlayer player) {
        String uuid = player.getUniqueID().toString();
        String name = player.getName();
        int pid = EntityHelper.getPlayerUID(player);
        player.sendMessage(new TextComponentTranslation("chat.shincolle:command.command").appendSibling(new TextComponentString(" shipupdateowneruid: owner: " + TextFormatting.AQUA + pid + " " + TextFormatting.LIGHT_PURPLE + uuid)));
        if (uuid != null && uuid.length() > 3) {
            WorldServer[] worlds = ServerProxy.getServerWorld();
            try {
                for (WorldServer w : worlds) {
                    for (Entity ent : w.loadedEntityList) {
                        BasicEntityShip ship;
                        if (!(ent instanceof BasicEntityShip) || !EntityHelper.getPetPlayerUUID(ship = (BasicEntityShip)ent).equals(uuid)) continue;
                        EntityHelper.setPetPlayerUID(pid, ship);
                        ship.ownerName = name;
                        player.sendMessage(new TextComponentString("get ship: " + TextFormatting.GOLD + ship));
                        ship.sendSyncPacketAll();
                    }
                }
            }
            catch (Exception e) {
                LogHelper.info("EXCEPTION: Command: ShipUpdateOwnerUID: change ship's owner fail: " + e);
                e.printStackTrace();
            }
        }
    }
}
