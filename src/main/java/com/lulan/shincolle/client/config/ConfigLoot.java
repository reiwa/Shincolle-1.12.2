package com.lulan.shincolle.config;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigLoot extends BasicShipConfig {
    public static final Map<Integer, List<ItemEntry>> LOOTMAP;

    static {
        LOOTMAP = new HashMap<>();
        for (int i = 0; i < 10; ++i) {
            LOOTMAP.put(i, new ArrayList<>());
        }
    }

    public ConfigLoot(File file) {
        super(file);
    }

    @Override
    protected void parse(ArrayList<String> lines) {
        if (lines != null && !lines.isEmpty()) {
            for (String str : lines) {
                if (BasicShipConfig.isCommentString(str)) continue;
                String cleanedStr = str.replaceAll("\\s", "");
                String[] strs = cleanedStr.split(",");
                if (strs.length != 7 || strs[1].isEmpty()) continue;
                try {
                    int id = Integer.parseInt(strs[0]);
                    int meta = Integer.parseInt(strs[2]);
                    int weight = Integer.parseInt(strs[3]);
                    int chance = Integer.parseInt(strs[4]);
                    int min = Integer.parseInt(strs[5]);
                    int max = Integer.parseInt(strs[6]);
                    List<ItemEntry> list = LOOTMAP.get(id);
                    if (list == null) continue;
                    list.add(new ItemEntry(strs[1], meta, weight, chance, min, max));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected ArrayList<String> getDefaultContent() {
        ArrayList<String> strs = new ArrayList<>();
        strs.add("# Custom Loot Table" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# format: chest_ID, item_name, item_meta, weight, chance%, min stack size, max stack size" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# chest_ID: 0:Spawn Bonus Chest, 1:Igloo, 2:Dungeon, 3:Village Blacksmith, 4:Mineshaft," + NEW_LINE);
        strs.add("#           5:Pyramid, 6:Jungle Temple, 7:Nether Bridge, 8:Stronghold, 9:End City" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# item_meta: -1:random meta, only for shincolle item, 0~N:specific meta" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# chance%: 0~100" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# 'rolls' will be random from 1 ~ N/2+1, N = #entries per chestID" + NEW_LINE);
        strs.add("# 'bonus_rolls' is fixed at 1" + NEW_LINE);
        strs.add(NEW_LINE);
        strs.add("0,shincolle:Grudge,0,1,100,10,15" + NEW_LINE);
        strs.add("0,shincolle:ShipSpawnEgg,2,2,100,1,1" + NEW_LINE);
        strs.add("0,shincolle:Ammo,0,1,100,5,8" + NEW_LINE);
        strs.add("1,shincolle:Grudge,0,1,100,5,8" + NEW_LINE);
        strs.add("1,shincolle:ShipSpawnEgg,0,1,100,1,1" + NEW_LINE);
        strs.add("1,shincolle:Ammo,0,1,100,2,3" + NEW_LINE);
        strs.add("1,shincolle:InstantConMat,0,1,100,3,5" + NEW_LINE);
        strs.add("2,shincolle:MarriageRing,0,4,70,1,1" + NEW_LINE);
        strs.add("2,shincolle:TrainingBook,0,4,80,1,3" + NEW_LINE);
        strs.add("2,shincolle:ShipSpawnEgg,0,3,100,1,1" + NEW_LINE);
        strs.add("2,shincolle:ShipSpawnEgg,1,3,100,1,1" + NEW_LINE);
        strs.add("2,shincolle:ShipSpawnEgg,17,1,80,1,1" + NEW_LINE);
        strs.add("2,shincolle:ShipSpawnEgg,48,1,80,1,1" + NEW_LINE);
        strs.add("3,shincolle:InstantConMat,0,20,100,10,20" + NEW_LINE);
        strs.add("3,shincolle:BlockAbyssium,0,10,100,5,10" + NEW_LINE);
        strs.add("3,shincolle:BlockPolymetal,0,10,100,5,10" + NEW_LINE);
        strs.add("3,shincolle:ShipSpawnEgg,0,5,100,1,1" + NEW_LINE);
        strs.add("4,shincolle:TrainingBook,0,6,80,1,3" + NEW_LINE);
        strs.add("4,shincolle:MarriageRing,0,6,70,1,1" + NEW_LINE);
        strs.add("4,shincolle:ShipSpawnEgg,0,3,100,1,1" + NEW_LINE);
        strs.add("4,shincolle:ShipSpawnEgg,1,3,100,1,1" + NEW_LINE);
        strs.add("4,shincolle:EquipCannon,-1,8,100,1,1" + NEW_LINE);
        strs.add("4,shincolle:EquipAirplane,-1,8,100,1,1" + NEW_LINE);
        strs.add("4,shincolle:Torpedo,-1,8,100,1,1" + NEW_LINE);
        strs.add("5,shincolle:TrainingBook,0,6,80,1,3" + NEW_LINE);
        strs.add("5,shincolle:MarriageRing,0,6,70,1,1" + NEW_LINE);
        strs.add("5,shincolle:ShipSpawnEgg,0,3,100,1,1" + NEW_LINE);
        strs.add("5,shincolle:ShipSpawnEgg,1,3,100,1,1" + NEW_LINE);
        strs.add("5,shincolle:EquipCannon,-1,8,100,1,1" + NEW_LINE);
        strs.add("5,shincolle:EquipAirplane,-1,8,100,1,1" + NEW_LINE);
        strs.add("5,shincolle:Torpedo,-1,8,100,1,1" + NEW_LINE);
        strs.add("6,shincolle:MarriageRing,0,4,70,1,1" + NEW_LINE);
        strs.add("6,shincolle:ShipSpawnEgg,1,2,100,1,1" + NEW_LINE);
        strs.add("6,shincolle:ShipSpawnEgg,17,1,80,1,1" + NEW_LINE);
        strs.add("6,shincolle:ShipSpawnEgg,48,1,80,1,1" + NEW_LINE);
        strs.add("7,shincolle:TrainingBook,0,4,80,1,3" + NEW_LINE);
        strs.add("7,shincolle:InstantConMat,0,4,100,10,12" + NEW_LINE);
        strs.add("7,shincolle:MarriageRing,0,4,70,1,1" + NEW_LINE);
        strs.add("7,shincolle:BlockAbyssium,0,4,100,5,15" + NEW_LINE);
        strs.add("7,shincolle:BlockPolymetal,0,4,100,5,15" + NEW_LINE);
        strs.add("8,shincolle:TrainingBook,0,6,80,1,3" + NEW_LINE);
        strs.add("8,shincolle:MarriageRing,0,6,70,1,1" + NEW_LINE);
        strs.add("8,shincolle:ShipSpawnEgg,0,3,100,1,1" + NEW_LINE);
        strs.add("8,shincolle:ShipSpawnEgg,1,3,100,1,1" + NEW_LINE);
        strs.add("8,shincolle:EquipCannon,-1,8,100,1,1" + NEW_LINE);
        strs.add("8,shincolle:EquipAirplane,-1,8,100,1,1" + NEW_LINE);
        strs.add("8,shincolle:Torpedo,-1,8,100,1,1" + NEW_LINE);
        strs.add("9,shincolle:TrainingBook,0,6,80,1,3" + NEW_LINE);
        strs.add("9,shincolle:MarriageRing,0,6,70,1,1" + NEW_LINE);
        strs.add("9,shincolle:ShipSpawnEgg,0,3,100,1,1" + NEW_LINE);
        strs.add("9,shincolle:ShipSpawnEgg,1,3,100,1,1" + NEW_LINE);
        strs.add("9,shincolle:EquipCannon,-1,8,100,1,1" + NEW_LINE);
        strs.add("9,shincolle:EquipAirplane,-1,8,100,1,1" + NEW_LINE);
        strs.add("9,shincolle:Torpedo,-1,8,100,1,1" + NEW_LINE);
        return strs;
    }

    public class ItemEntry {
        public int itemMeta;
        public int weight;
        public int min;
        public int max;
        public float chance;
        public String itemName;

        public ItemEntry(String itemName, int itemMeta, int weight, int chance, int min, int max) {
            this.itemName = itemName;
            this.itemMeta = itemMeta;
            this.weight = weight;
            this.chance = chance * 0.01f;
            this.min = min;
            this.max = max;
        }
    }
}
