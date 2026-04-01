package com.lulan.shincolle.worldgen;

import com.lulan.shincolle.config.ConfigLoot;
import com.lulan.shincolle.handler.ConfigHandler;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;

import java.util.ArrayList;
import java.util.List;

public class ChestLootTable {
    private ChestLootTable() {}

    private static int LootCount = 0;

    public static void editLoot(LootTableLoadEvent event) {
        ResourceLocation host = event.getName();
        LootTable table = event.getTable();
        if (host.equals(LootTableList.CHESTS_SPAWN_BONUS_CHEST)) {
            ChestLootTable.addNewPoolToTable(table, 0);
        } else if (host.equals(LootTableList.CHESTS_IGLOO_CHEST)) {
            ChestLootTable.addNewPoolToTable(table, 1);
        } else if (host.equals(LootTableList.CHESTS_SIMPLE_DUNGEON)) {
            ChestLootTable.addNewPoolToTable(table, 2);
        } else if (host.equals(LootTableList.CHESTS_VILLAGE_BLACKSMITH)) {
            ChestLootTable.addNewPoolToTable(table, 3);
        } else if (host.equals(LootTableList.CHESTS_ABANDONED_MINESHAFT)) {
            ChestLootTable.addNewPoolToTable(table, 4);
        } else if (host.equals(LootTableList.CHESTS_DESERT_PYRAMID)) {
            ChestLootTable.addNewPoolToTable(table, 5);
        } else if (host.equals(LootTableList.CHESTS_JUNGLE_TEMPLE)) {
            ChestLootTable.addNewPoolToTable(table, 6);
        } else if (host.equals(LootTableList.CHESTS_NETHER_BRIDGE)) {
            ChestLootTable.addNewPoolToTable(table, 7);
        } else if (host.equals(LootTableList.CHESTS_STRONGHOLD_LIBRARY) || host.equals(LootTableList.CHESTS_STRONGHOLD_CROSSING) || host.equals(LootTableList.CHESTS_STRONGHOLD_CORRIDOR)) {
            ChestLootTable.addNewPoolToTable(table, 8);
        } else if (host.equals(LootTableList.CHESTS_END_CITY_TREASURE)) {
            ChestLootTable.addNewPoolToTable(table, 9);
        }
    }

    private static LootEntryItem convItemEntryToLootEntry(ConfigLoot.ItemEntry ent) {
        if (ent != null) {
            Item item = Item.getByNameOrId(ent.itemName);
            int level = ConfigHandler.consumptionLevel;
            float rate = 1.0f;
            if (level == 1) {
                rate = 0.5f;
            } else if (level == 2) {
                rate = 0.1f;
            }
            float adjustedChance = ent.chance * rate;
            ArrayList<Object> funcList = new ArrayList<>();
            LootCondition[] condList = new LootCondition[]{ new RandomChance(adjustedChance) };
            String entryName = "shincolle:lootentry" + LootCount++;
            if (item != null) {
                return new LootEntryItem(
                        item,
                        ent.weight,
                        0,
                        funcList.toArray(new LootFunction[funcList.size()]),
                        condList,
                        entryName
                );
            }
        }
        return null;
    }
    private static void addNewPoolToTable(LootTable table, int chestID) {
        ArrayList<LootEntryItem> lootList = new ArrayList<>();
        List<ConfigLoot.ItemEntry> lootlist2 = ConfigLoot.LOOTMAP.get(chestID);
        String poolName = "shincollePool";
        for (ConfigLoot.ItemEntry ent : lootlist2) {
            LootEntryItem ent2 = ChestLootTable.convItemEntryToLootEntry(ent);
            if (ent2 == null) continue;
            lootList.add(ent2);
        }
        if (!lootList.isEmpty()) {
            table.addPool(new LootPool(lootList.toArray(new LootEntry[lootList.size()]), new LootCondition[0], new RandomValueRange(1.0f, (lootList.size() / 2 + 1)), new RandomValueRange(1.0f), poolName));
        }
    }
}
