package com.lulan.shincolle.init;

import com.lulan.shincolle.handler.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

public class ModOres {
    private ModOres() {}

    public static void oreDictRegister() {
    }

    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> e){
        ItemStack ingotAbyssium = new ItemStack(ModItems.AbyssMetal, 1, 0);
        ItemStack ingotPolymetal = new ItemStack(ModItems.AbyssMetal, 1, 1);
        ItemStack nuggetAbyssium = new ItemStack(ModItems.AbyssNugget, 1, 0);
        ItemStack nuggetPolymetal = new ItemStack(ModItems.AbyssNugget, 1, 1);
        OreDictionary.registerOre("ingotAbyssium", ingotAbyssium);
        OreDictionary.registerOre("nuggetAbyssium", nuggetAbyssium);
        OreDictionary.registerOre("blockAbyssium", new ItemStack(ModBlocks.BlockAbyssium, 1, 0));
        if (ConfigHandler.polyAsMn) {
            OreDictionary.registerOre("dustManganese", ingotPolymetal);
            OreDictionary.registerOre("oreManganese", ModBlocks.BlockPolymetalOre);
            OreDictionary.registerOre("nuggetManganese", nuggetPolymetal);
            OreDictionary.registerOre("blockManganese", ModBlocks.BlockAbyssium);
            OreDictionary.registerOre("oreManganese", new ItemStack(ModBlocks.BlockPolymetalOre));
        } else {
            OreDictionary.registerOre("ingotPolymetal", ingotPolymetal);
            OreDictionary.registerOre("nuggetPolymetal", nuggetPolymetal);
            OreDictionary.registerOre("blockPolymetal", ModBlocks.BlockPolymetal);
            OreDictionary.registerOre("orePolymetal", new ItemStack(ModBlocks.BlockPolymetalOre));
        }
        OreDictionary.registerOre("blockGrudge", new ItemStack(ModBlocks.BlockGrudge));
        OreDictionary.registerOre("blockHeavyGrudge", new ItemStack(ModBlocks.BlockGrudgeHeavy));
        OreDictionary.registerOre("grudge", ModItems.Grudge);
        OreDictionary.registerOre("foodCombatRation", ModItems.CombatRation);
    }
}
