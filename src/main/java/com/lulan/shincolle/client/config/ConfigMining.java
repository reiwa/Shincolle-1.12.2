package com.lulan.shincolle.config;

import com.lulan.shincolle.utility.LogHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigMining extends BasicShipConfig {
    public static final Map<Integer, Map<Integer, List<ItemEntry>>> MININGMAP;

    static {
        MININGMAP = new HashMap<>();
    }

    public ConfigMining(File file) {
        super(file);
    }

    @Override
    protected void parse(ArrayList<String> lines) {
        if (lines != null && !lines.isEmpty()) {
            for (String str : lines) {
                if (BasicShipConfig.isCommentString(str)) continue;
                String cleanedStr = str.replaceAll("\\s", "");
                String[] strs = cleanedStr.split(",");
                if (strs.length != 11 || strs[2].isEmpty()) continue;
                try {
                    int worldId = Integer.parseInt(strs[0]);
                    int biomeId = Integer.parseInt(strs[1]);
                    int itemMeta = Integer.parseInt(strs[3]);
                    int weight = Math.max(1, Integer.parseInt(strs[4]));
                    int minStack = Math.max(1, Integer.parseInt(strs[5]));
                    int maxStack = Math.max(1, Integer.parseInt(strs[6]));
                    int shipLv = Integer.parseInt(strs[7]);
                    int yLv = Integer.parseInt(strs[8]);
                    int toolLv = Integer.parseInt(strs[9]);
                    int enchantWeight = Integer.parseInt(strs[10]);

                    Map<Integer, List<ItemEntry>> biomeMap = MININGMAP.computeIfAbsent(worldId, k -> new HashMap<>());
                    List<ItemEntry> list = biomeMap.computeIfAbsent(biomeId, k -> new ArrayList<>());

                    list.add(new ItemEntry(strs[2], itemMeta, weight, minStack, maxStack, shipLv, yLv, toolLv, enchantWeight));
                } catch (NumberFormatException e) {
                    LogHelper.info("EXCEPTION : parse error at ConfigMining.cfg : " + str + " " + e);
                }
            }
        }
    }

    @Override
    protected ArrayList<String> getDefaultContent() {
        ArrayList<String> strs = new ArrayList<>();
        strs.add("# Mining Loot Table" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# format: world id, biome id, item_name, item_meta, weight, min stack size, max stack size, ship level, y level, tool level, enchant weight" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# world id: 999999:all worlds, 0:Overworld, -1:the Nether, 1:the End, N:for specific world" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# biome id: -999999:for all biome, N:for specific biome" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# item_meta: -1:random meta, only for shincolle item, 0~N:specific meta" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# weight: generate rate, actual rate = weight of this item / total weight of all item" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# ship level: ship minimal level for this item" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# y level: highest y level of ship position for this item" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# tool level: minimal tool level of pickaxe, 0:wood/gold, 1:stone, 2:iron, 3:diamond" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# enchant weight: for fortune level on pickaxe, actual stack size = stack size * (1 + (enchant weight / 100) * fortune level)" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("999999,-999999,minecraft:cobblestone,0,100,1,4,1,256,0,0" + NEW_LINE);
        strs.add("0,-999999,minecraft:cobblestone,0,4000,1,4,1,256,0,0" + NEW_LINE);
        strs.add("0,-999999,minecraft:stone,1,500,1,1,1,256,0,0" + NEW_LINE);
        strs.add("0,-999999,minecraft:stone,3,500,1,1,1,256,0,0" + NEW_LINE);
        strs.add("0,-999999,minecraft:stone,5,500,1,1,1,256,0,0" + NEW_LINE);
        strs.add("0,-999999,minecraft:dirt,0,500,1,1,1,256,0,0" + NEW_LINE);
        strs.add("0,-999999,minecraft:sand,0,500,1,1,1,256,0,0" + NEW_LINE);
        strs.add("0,-999999,minecraft:gravel,0,200,1,1,1,256,0,0" + NEW_LINE);
        strs.add("0,-999999,minecraft:obsidian,0,200,1,1,40,24,3,0" + NEW_LINE);
        strs.add("0,-999999,minecraft:flint,0,250,1,1,1,256,0,0" + NEW_LINE);
        strs.add("0,-999999,minecraft:gunpowder,0,400,1,1,40,64,0,0" + NEW_LINE);
        strs.add("0,-999999,minecraft:bone,0,400,1,1,1,64,0,0" + NEW_LINE);
        strs.add("0,-999999,minecraft:coal,0,500,1,3,1,100,1,150" + NEW_LINE);
        strs.add("0,-999999,minecraft:redstone,0,500,1,3,20,15,2,150" + NEW_LINE);
        strs.add("0,-999999,minecraft:iron_ore,0,350,1,2,1,64,2,100" + NEW_LINE);
        strs.add("0,-999999,shincolle:AbyssMetal,1,350,1,3,1,64,2,100" + NEW_LINE);
        strs.add("0,-999999,minecraft:gold_ore,0,100,1,1,30,32,2,100" + NEW_LINE);
        strs.add("0,-999999,minecraft:dye,4,200,1,3,30,30,2,150" + NEW_LINE);
        strs.add("0,-999999,minecraft:diamond,0,50,1,1,60,16,3,100" + NEW_LINE);
        strs.add("0,-999999,minecraft:emerald,0,80,1,1,40,32,3,100" + NEW_LINE);
        strs.add("0,-999999,shincolle:MarriageRing,0,25,1,1,1,16,3,0" + NEW_LINE);
        strs.add("0,0,minecraft:prismarine_shard,0,500,1,4,30,128,0,0" + NEW_LINE);
        strs.add("0,0,minecraft:prismarine_crystals,0,200,1,3,60,128,2,100" + NEW_LINE);
        strs.add("0,0,shincolle:AbyssMetal,1,500,1,3,1,64,2,100" + NEW_LINE);
        strs.add("0,0,minecraft:sponge,0,200,1,1,80,128,0,100" + NEW_LINE);
        strs.add("0,6,minecraft:clay_ball,0,500,1,4,30,128,0,0" + NEW_LINE);
        strs.add("0,6,minecraft:mycelium,0,500,1,1,50,128,0,0" + NEW_LINE);
        strs.add("0,7,minecraft:clay_ball,0,500,1,4,30,128,0,0" + NEW_LINE);
        strs.add("0,7,minecraft:mycelium,0,500,1,1,50,128,0,0" + NEW_LINE);
        strs.add("0,10,minecraft:prismarine_shard,0,500,1,4,30,128,0,0" + NEW_LINE);
        strs.add("0,10,minecraft:prismarine_crystals,0,200,1,3,60,128,2,100" + NEW_LINE);
        strs.add("0,10,shincolle:AbyssMetal,1,500,1,3,1,64,2,100" + NEW_LINE);
        strs.add("0,10,minecraft:sponge,0,200,1,1,80,128,0,100" + NEW_LINE);
        strs.add("0,10,minecraft:packed_ice,0,1000,1,4,1,256,2,0" + NEW_LINE);
        strs.add("0,11,minecraft:clay_ball,0,500,1,4,30,128,0,0" + NEW_LINE);
        strs.add("0,11,minecraft:mycelium,0,500,1,1,50,128,0,0" + NEW_LINE);
        strs.add("0,11,minecraft:packed_ice,0,1000,1,4,1,256,2,0" + NEW_LINE);
        strs.add("0,12,minecraft:packed_ice,0,1000,1,4,1,256,2,0" + NEW_LINE);
        strs.add("0,13,minecraft:packed_ice,0,1000,1,4,1,256,2,0" + NEW_LINE);
        strs.add("0,16,minecraft:clay_ball,0,500,1,4,30,128,0,0" + NEW_LINE);
        strs.add("0,16,minecraft:mycelium,0,500,1,1,50,128,0,0" + NEW_LINE);
        strs.add("0,24,minecraft:prismarine_shard,0,500,1,4,30,128,0,0" + NEW_LINE);
        strs.add("0,24,minecraft:prismarine_crystals,0,200,1,3,60,128,2,100" + NEW_LINE);
        strs.add("0,24,shincolle:AbyssMetal,1,500,1,3,1,64,2,100" + NEW_LINE);
        strs.add("0,24,minecraft:sponge,0,200,1,1,80,128,0,100" + NEW_LINE);
        strs.add("0,25,minecraft:clay_ball,0,500,1,4,30,128,0,0" + NEW_LINE);
        strs.add("0,25,minecraft:mycelium,0,500,1,1,50,128,0,0" + NEW_LINE);
        strs.add("0,26,minecraft:clay_ball,0,500,1,4,30,128,0,0" + NEW_LINE);
        strs.add("0,26,minecraft:mycelium,0,500,1,1,50,128,0,0" + NEW_LINE);
        strs.add("0,26,minecraft:packed_ice,0,1000,1,4,1,256,2,0" + NEW_LINE);
        strs.add("0,30,minecraft:packed_ice,0,1000,1,4,1,256,2,0" + NEW_LINE);
        strs.add("0,31,minecraft:packed_ice,0,1000,1,4,1,256,2,0" + NEW_LINE);
        strs.add("0,134,minecraft:clay_ball,0,500,1,4,30,128,0,0" + NEW_LINE);
        strs.add("0,134,minecraft:mycelium,0,500,1,1,50,128,0,0" + NEW_LINE);
        strs.add("0,140,minecraft:packed_ice,0,1000,1,4,1,256,2,0" + NEW_LINE);
        strs.add("0,158,minecraft:packed_ice,0,1000,1,4,1,256,2,0" + NEW_LINE);
        strs.add("-1,-999999,minecraft:netherrack,0,4500,1,4,1,256,0,0" + NEW_LINE);
        strs.add("-1,-999999,minecraft:nether_brick,0,1000,1,1,1,256,0,0" + NEW_LINE);
        strs.add("-1,-999999,minecraft:soul_sand,0,1000,1,1,1,256,0,0" + NEW_LINE);
        strs.add("-1,-999999,minecraft:gravel,0,1000,1,1,1,256,0,0" + NEW_LINE);
        strs.add("-1,-999999,minecraft:magma,0,500,1,1,40,256,3,0" + NEW_LINE);
        strs.add("-1,-999999,minecraft:flint,0,500,1,1,1,256,0,0" + NEW_LINE);
        strs.add("-1,-999999,shincolle:MarriageRing,0,50,1,1,1,256,3,0" + NEW_LINE);
        strs.add("-1,-999999,minecraft:quartz,0,1000,1,3,1,256,2,150" + NEW_LINE);
        strs.add("-1,-999999,minecraft:glowstone,0,500,1,2,1,256,0,100" + NEW_LINE);
        strs.add("-1,-999999,minecraft:ghast_tear,0,50,1,1,90,256,3,100" + NEW_LINE);
        strs.add("-1,-999999,minecraft:blaze_rod,0,80,1,1,60,256,3,100" + NEW_LINE);
        strs.add("1,-999999,minecraft:end_stone,0,4000,1,4,1,256,0,0" + NEW_LINE);
        strs.add("1,-999999,minecraft:ender_pearl,0,200,1,1,40,256,3,100" + NEW_LINE);
        strs.add("1,-999999,minecraft:chorus_fruit,0,200,1,3,60,256,3,100" + NEW_LINE);
        strs.add("-1,-999999,shincolle:MarriageRing,0,25,1,1,1,256,3,0" + NEW_LINE);
        return strs;
    }

    public class ItemEntry {
        public final int itemMeta;
        public final int weight;
        public final int min;
        public final int max;
        public final int lvShip;
        public final int lvHeight;
        public final int lvTool;
        public final float enchant;
        public final String itemName;

        public ItemEntry(String itemName, int itemMeta, int weight, int min, int max, int lvShip, int lvHeight, int lvTool, int enchant) {
            this.itemName = itemName;
            this.itemMeta = itemMeta;
            this.weight = weight;
            this.min = min;
            this.max = max;
            this.lvShip = lvShip;
            this.lvHeight = lvHeight;
            this.lvTool = lvTool;
            this.enchant = enchant * 0.01f;
        }
    }
}
