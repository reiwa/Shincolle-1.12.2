package com.lulan.shincolle.command;

import com.lulan.shincolle.item.BasicEntityItem;
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

public class ShipCmdShipClearDrop
extends CommandBase {
    private static final ArrayList<String> Aliases = new ArrayList<>();
    static {
        Aliases.add("shipcleardrop");
    }

    public String getName() {
        return Aliases.get(0);
    }

    public List<String> getAliases() {
        return Aliases;
    }

    public String getUsage(ICommandSender sender) {
        return "/shipcleardrop [range]";
    }

    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return sender instanceof EntityPlayer;
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = sender.getEntityWorld();
        EntityPlayer op;
        if (!world.isRemote && sender instanceof EntityPlayer && EntityHelper.checkOP(op = (EntityPlayer)sender)) {
            int range = 128;
            if (args.length > 0 && (range = ShipCmdShipClearDrop.parseInt(args[0])) == 0) {
                range = 128;
            }
            AxisAlignedBB aabb = new AxisAlignedBB(op.posX - range, 0.0, op.posZ - range, op.posX + range, 256.0, op.posZ + range);
            List<BasicEntityItem> hitent = op.world.getEntitiesWithinAABB(BasicEntityItem.class, aabb);
            sender.sendMessage(new TextComponentTranslation("chat.shincolle:command.command").appendSibling(new TextComponentString(" shipcleardrop: remove " + hitent.size() + " item entities.")));
            for (BasicEntityItem i : hitent) {
                i.setDead();
            }
        }
    }
}
