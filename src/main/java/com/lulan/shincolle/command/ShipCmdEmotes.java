package com.lulan.shincolle.command;

import com.lulan.shincolle.network.S2CSpawnParticle;
import com.lulan.shincolle.proxy.CommonProxy;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.CommandBlockBaseLogic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipCmdEmotes extends CommandBase {

    private static final List<String> Aliases = Arrays.asList("em", "emo", "emote", "emotes");
    protected static final String[] EmoNameArray = new String[]{"0", "swt", "drop", "1", "lv", "love", "heart", "2", "swt2", "wah", "panic", "3", "?", "4", "!", "5", "...", "6", "an", "anger", "angry", "7", "note", "ho", "8", "sob", "cry", "sad", "9", "spit", "rice", "hungry", "10", "spin", "dizzy", "11", "find", "??", "12", "omg", "shock", "13", "ok", "nod", "14", "fsh", "flash", "+_+", "15", "kiss", "kis", "16", "lol", "ha", "heh", "17", "gg", "giggle", "18", "sigh", "19", "meh", "lick", "20", "orz", "otl", "21", "o", "oh", "yes", "22", "x", "no", "23", "!?", "surprised", "24", "rock", "bawi", "25", "paper", "bo", "26", "scissors", "gawi", "ya", "yeah", "27", "-w-", "28", "-o-", "29", "blink", "wink", "30", "pif", "31", "shy", "shine", "32", "hmm", "33", ":p", "34", "lll"};
    protected static final Map<String, Integer> EmoNameToID = new HashMap<>();

    static {
        EmoNameToID.put("0", 0); EmoNameToID.put("swt", 0); EmoNameToID.put("drop", 0);
        EmoNameToID.put("1", 1); EmoNameToID.put("lv", 1); EmoNameToID.put("love", 1); EmoNameToID.put("heart", 1);
        EmoNameToID.put("2", 2); EmoNameToID.put("swt2", 2); EmoNameToID.put("wah", 2); EmoNameToID.put("panic", 2);
        EmoNameToID.put("3", 3); EmoNameToID.put("?", 3);
        EmoNameToID.put("4", 4); EmoNameToID.put("!", 4);
        EmoNameToID.put("5", 5); EmoNameToID.put("...", 5);
        EmoNameToID.put("6", 6); EmoNameToID.put("an", 6); EmoNameToID.put("anger", 6); EmoNameToID.put("angry", 6);
        EmoNameToID.put("7", 7); EmoNameToID.put("note", 7); EmoNameToID.put("ho", 7);
        EmoNameToID.put("8", 8); EmoNameToID.put("sob", 8); EmoNameToID.put("cry", 8); EmoNameToID.put("sad", 8);
        EmoNameToID.put("9", 9); EmoNameToID.put("spit", 9); EmoNameToID.put("rice", 9); EmoNameToID.put("hungry", 9);
        EmoNameToID.put("10", 10); EmoNameToID.put("spin", 10); EmoNameToID.put("dizzy", 10);
        EmoNameToID.put("11", 11); EmoNameToID.put("find", 11); EmoNameToID.put("??", 11);
        EmoNameToID.put("12", 12); EmoNameToID.put("omg", 12); EmoNameToID.put("shock", 12);
        EmoNameToID.put("13", 13); EmoNameToID.put("ok", 13); EmoNameToID.put("nod", 13);
        EmoNameToID.put("14", 14); EmoNameToID.put("fsh", 14); EmoNameToID.put("flash", 14); EmoNameToID.put("+_+", 14);
        EmoNameToID.put("15", 15); EmoNameToID.put("kiss", 15); EmoNameToID.put("kis", 15);
        EmoNameToID.put("16", 16); EmoNameToID.put("lol", 16); EmoNameToID.put("ha", 16); EmoNameToID.put("heh", 16);
        EmoNameToID.put("17", 17); EmoNameToID.put("gg", 17); EmoNameToID.put("giggle", 17);
        EmoNameToID.put("18", 18); EmoNameToID.put("sigh", 18);
        EmoNameToID.put("19", 19); EmoNameToID.put("meh", 19); EmoNameToID.put("lick", 19);
        EmoNameToID.put("20", 20); EmoNameToID.put("orz", 20); EmoNameToID.put("otl", 20);
        EmoNameToID.put("21", 21); EmoNameToID.put("o", 21); EmoNameToID.put("oh", 21); EmoNameToID.put("yes", 21);
        EmoNameToID.put("22", 22); EmoNameToID.put("x", 22); EmoNameToID.put("no", 22);
        EmoNameToID.put("23", 23); EmoNameToID.put("!?", 23); EmoNameToID.put("surprised", 23);
        EmoNameToID.put("24", 24); EmoNameToID.put("rock", 24); EmoNameToID.put("bawi", 24);
        EmoNameToID.put("25", 25); EmoNameToID.put("paper", 25); EmoNameToID.put("bo", 25);
        EmoNameToID.put("26", 26); EmoNameToID.put("scissors", 26); EmoNameToID.put("gawi", 26); EmoNameToID.put("ya", 26); EmoNameToID.put("yeah", 26);
        EmoNameToID.put("27", 27); EmoNameToID.put("-w-", 27);
        EmoNameToID.put("28", 28); EmoNameToID.put("-o-", 28);
        EmoNameToID.put("29", 29); EmoNameToID.put("blink", 29); EmoNameToID.put("wink", 29);
        EmoNameToID.put("30", 30); EmoNameToID.put("pif", 30);
        EmoNameToID.put("31", 31); EmoNameToID.put("shy", 31); EmoNameToID.put("shine", 31);
        EmoNameToID.put("32", 32); EmoNameToID.put("hmm", 32);
        EmoNameToID.put("33", 33); EmoNameToID.put(":p", 33);
        EmoNameToID.put("34", 34); EmoNameToID.put("lll", 34);
    }

    @Override
    public String getName() {
        return "shipemotes";
    }

    @Override
    public List<String> getAliases() {
        return Aliases;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/shipemotes [" + String.join(", ", EmoNameArray) + "]";
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] cmd) throws CommandException {
        World world = sender.getEntityWorld();
        int emo = cmd.length > 0 ? ShipCmdEmotes.nameToEmoID(cmd[0]) : world.rand.nextInt(30);
        float px;
        float py;
        float pz;
        float height;
        int entityType;
        if (sender instanceof EntityLivingBase) {
            EntityLivingBase host = (EntityLivingBase) sender;
            height = host.height * 0.25f;
            entityType = 1;
            px = (float) host.posX;
            py = (float) host.posY;
            pz = (float) host.posZ;
            if (sender instanceof EntityPlayer) {
                height = host.height * 0.65f;
            }
        } else if (sender instanceof CommandBlockBaseLogic) {
            BlockPos pos = sender.getPosition();
            height = 0.5f;
            entityType = 2;
            px = pos.getX() + 0.5f;
            py = pos.getY();
            pz = pos.getZ() + 0.5f;
        } else {
            BlockPos pos = sender.getPosition();
            height = 0.5f;
            entityType = 0;
            px = pos.getX();
            py = pos.getY();
            pz = pos.getZ();
        }
        NetworkRegistry.TargetPoint point = new NetworkRegistry.TargetPoint(world.provider.getDimension(), px, py, pz, 64.0);
        if (sender instanceof Entity) {
            CommonProxy.channelP.sendToAllAround(new S2CSpawnParticle((Entity) sender, 36, height, entityType, emo), point);
        } else {
            CommonProxy.channelP.sendToAllAround(new S2CSpawnParticle(36, px, py, pz, height, entityType, emo), point);
        }
    }

    public static int nameToEmoID(String str) {
        if (str == null) {
            return 0;
        }
        return EmoNameToID.getOrDefault(str, 0);
    }
}