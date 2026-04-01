package com.lulan.shincolle.creativetab;

import com.lulan.shincolle.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabSC {
    private CreativeTabSC() {}

    public static final CreativeTabs SC_TAB = new CreativeTabs("shincolle"){

        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.Grudge);
        }
    };
}
