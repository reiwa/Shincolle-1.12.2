package com.lulan.shincolle.command;

import com.lulan.shincolle.network.S2CReactPackets;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.utility.EntityHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ShipCmdChangeShipOwner extends CommandBase {

    private static final ArrayList<String> Aliases = new ArrayList<>();

    static {
        Aliases.add("shipchangeowner");
        Aliases.add("shipch");
    }

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
        return "/shipchangeowner <player name>";
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return sender instanceof EntityPlayer;
    }

    @Override
    public boolean isUsernameIndex(String[] cmd, int index) {
        return index == 0;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = sender.getEntityWorld();
        if (!world.isRemote && sender instanceof EntityPlayer) {
            EntityPlayer op = (EntityPlayer) sender;
            int senderEID = op.getEntityId();
            boolean isOP = EntityHelper.checkOP(op);
            if (args.length < 1) {
                sender.sendMessage(new TextComponentString(this.getUsage(sender)));
                sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.playernull"));
                return;
            }
            if (isOP) {
                EntityPlayer owner = EntityHelper.getEntityPlayerByName(args[0]);
                if (owner != null) {
                    int ownerEID = owner.getEntityId();
                    int pid = EntityHelper.getPlayerUID(owner);
                    if (pid > 0) {
                        sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.command").appendSibling(new TextComponentString(" shipchangeowner: owner: " + TextFormatting.AQUA + owner.getName() + " " + TextFormatting.LIGHT_PURPLE + owner.getUniqueID())));
                        CommonProxy.channelI.sendTo(new S2CReactPackets((byte) 0, senderEID, ownerEID), (EntityPlayerMP) op);
                    } else {
                        sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.playernull").appendSibling(new TextComponentString(" UID: " + TextFormatting.AQUA + pid)));
                    }
                } else {
                    sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.playernull").appendSibling(new TextComponentString(" UID: " + TextFormatting.AQUA + args[0])));
                }
            } else {
                sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.notop"));
            }
        }
    }
}