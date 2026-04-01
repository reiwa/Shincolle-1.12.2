package com.lulan.shincolle.command;

import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.utility.EntityHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ShipCmdStopAI
extends CommandBase {
    private static final ArrayList<String> Aliases = new ArrayList<>();
    static {
        Aliases.add("shipstopai");
        Aliases.add("shipstop");
    }

    public String getName() {
        return Aliases.get(0);
    }

    public List<String> getAliases() {
        return Aliases;
    }

    public String getUsage(ICommandSender sender) {
        return "/shipstopai";
    }

    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return sender instanceof EntityPlayer;
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        World world = sender.getEntityWorld();
        if (!world.isRemote && sender instanceof EntityPlayer && EntityHelper.checkOP((EntityPlayer)sender)) {
            BasicEntityShip.stopAI = !BasicEntityShip.stopAI;
            BasicEntityShipHostile.stopAI = !BasicEntityShipHostile.stopAI;
            BasicEntityMount.stopAI = !BasicEntityMount.stopAI;
            sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.command").appendSibling(new TextComponentString(" shipstopai: " + BasicEntityShip.stopAI)));
        }
    }
}
