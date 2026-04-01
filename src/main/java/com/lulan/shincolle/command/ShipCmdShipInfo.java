package com.lulan.shincolle.command;

import com.lulan.shincolle.network.S2CReactPackets;
import com.lulan.shincolle.proxy.CommonProxy;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ShipCmdShipInfo
extends CommandBase {
    private static final ArrayList<String> Aliases = new ArrayList<>();
    static {
        Aliases.add("shipinfo");
    }

    public String getName() {
        return Aliases.get(0);
    }

    public List<String> getAliases() {
        return Aliases;
    }

    public String getUsage(ICommandSender sender) {
        return "/shipinfo";
    }

    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return sender instanceof EntityPlayer;
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = sender.getEntityWorld();
        if (!world.isRemote && sender instanceof EntityPlayer) {
            CommonProxy.channelI.sendTo(new S2CReactPackets((byte)1, ((EntityPlayer)sender).getEntityId()), (EntityPlayerMP)sender);
        }
    }
}
