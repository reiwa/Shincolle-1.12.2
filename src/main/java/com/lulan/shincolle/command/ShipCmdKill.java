package com.lulan.shincolle.command;

import com.lulan.shincolle.crafting.ShipCalc;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.utility.EntityHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ShipCmdKill extends CommandBase {

    private static final ArrayList<String> Aliases = new ArrayList<>();
    static {
        Aliases.add("shipkill");
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
        return "/shipkill <class id> [range]";
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return sender instanceof EntityPlayer;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = sender.getEntityWorld();
        if (world.isRemote) {
            return;
        }
        if (!(sender instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer player = (EntityPlayer) sender;
        if (!EntityHelper.checkOP(player)) {
            return;
        }
        short id = -1;
        int range = 64;
        if (args.length == 1) {
            id = (short) parseInt(args[0]);
        } else if (args.length >= 2) {
            id = (short) parseInt(args[0]);
            range = parseInt(args[1]);
        }
        if (range <= 0) {
            sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.wrongrange").appendText(" ( > 0 )"));
            return;
        }
        if (id < 2) {
            sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.wrongcid").appendText(" " + id));
            return;
        }
        sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.command").appendSibling(new TextComponentString(" shipkill: CID: " + id + " " + ShipCalc.getEntityToSpawnName(id - 2))));
        AxisAlignedBB aabb = new AxisAlignedBB(player.posX - range, -256.0, player.posZ - range, player.posX + range, 512.0, player.posZ + range);
        int classId = id - 2;
        if (classId < 2000) {
            killFriendlyShipsInRange(player.world, aabb, classId, sender);
        } else {
            int hostileClassId = classId - 2000;
            killHostileShipsInRange(player.world, aabb, hostileClassId, sender);
        }
    }

    private void killFriendlyShipsInRange(World world, AxisAlignedBB aabb, int classId, ICommandSender sender) {
        List<BasicEntityShip> shipsToKill = world.getEntitiesWithinAABB(BasicEntityShip.class, aabb);
        for (BasicEntityShip ship : shipsToKill) {
            if (ship.getShipClass() == classId) {
                ship.setDead();
                sender.sendMessage(new TextComponentString("remove " + ship));
            }
        }
    }

    private void killHostileShipsInRange(World world, AxisAlignedBB aabb, int classId, ICommandSender sender) {
        List<BasicEntityShipHostile> shipsToKill = world.getEntitiesWithinAABB(BasicEntityShipHostile.class, aabb);
        for (BasicEntityShipHostile ship : shipsToKill) {
            if (ship.getShipClass() == classId) {
                ship.setDead();
                sender.sendMessage(new TextComponentString("remove " + ship));
            }
        }
    }
}