package com.lulan.shincolle.crafting;

import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.TileEntityHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Random;

public class SmallRecipes {
    private static final Random rand = new Random();

    private SmallRecipes() {}

    public static boolean canRecipeBuild(int[] matAmount) {
        return matAmount[0] >= 16 && matAmount[1] >= 16 && matAmount[2] >= 16 && matAmount[3] >= 16;
    }

    public static int calcGoalPower(int[] matAmount) {
        if (SmallRecipes.canRecipeBuild(matAmount)) {
            int extraAmount = matAmount[0] + matAmount[1] + matAmount[2] + matAmount[3] - 64;
            return 57600 + 2100 * extraAmount;
        }
        return 0;
    }

    public static int getMaterialType(ItemStack itemstack) {
        Item item = itemstack.getItem();
        int meta = itemstack.getItemDamage();
        int itemID = -1;
        if (item == ModItems.Grudge) {
            itemID = 0;
        } else if (item == ModItems.AbyssMetal && meta == 0) {
            itemID = 1;
        } else if (item == ModItems.Ammo && meta == 0) {
            itemID = 2;
        } else if (item == ModItems.AbyssMetal && meta == 1) {
            itemID = 3;
        } else if (TileEntityHelper.getItemFuelValue(itemstack) > 0) {
            itemID = 4;
        } else if (item == ModItems.InstantConMat) {
            itemID = 4;
        }
        return itemID;
    }

    public static int[] getMaterialAmount(ItemStack[] item) {
        int[] itemAmount = new int[4];
        for (int i = 0; i < 4; ++i) {
            itemAmount[i] = item[i] != null ? item[i].getCount() : 0;
        }
        return itemAmount;
    }

    public static ItemStack getBuildResultShip(int[] matAmount) {
        ItemStack buildResult = new ItemStack(ModItems.ShipSpawnEgg);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setByte("Grudge", (byte)matAmount[0]);
        tag.setByte("Abyssium", (byte)matAmount[1]);
        tag.setByte("Ammo", (byte)matAmount[2]);
        tag.setByte("Polymetal", (byte)matAmount[3]);
        buildResult.setItemDamage(0);
        buildResult.setTagCompound(tag);
        return buildResult;
    }

    public static ItemStack getBuildResultEquip(int[] matAmount) {
        ItemStack buildResult = null;
        int totalMats = matAmount[0] + matAmount[1] + matAmount[2] + matAmount[3];
        int[] matsInt = new int[]{0, 0, 0, 0};
        int rollType;
        float equipRate = totalMats / 128.0f;
        float randRate = rand.nextFloat();
        if (equipRate > 1.0f) {
            equipRate = 1.0f;
        }
        LogHelper.debug("DEBUG : equip build roll: rate / random " + String.format("%.2f", Float.valueOf(equipRate)) + " " + String.format("%.2f", Float.valueOf(randRate)));
        if (randRate < equipRate) {
            matsInt[0] = matAmount[0];
            matsInt[1] = matAmount[1];
            matsInt[2] = matAmount[2];
            matsInt[3] = matAmount[3];
            rollType = EquipCalc.rollEquipType(0, matsInt);
            return EquipCalc.rollEquipsOfTheType(rollType, totalMats, 0);
        }
        buildResult = rand.nextInt(2) == 0 ? new ItemStack(ModItems.Ammo, 11 + rand.nextInt(11), 1) : new ItemStack(ModItems.Ammo, 2 + rand.nextInt(2), 3);
        return buildResult;
    }
}
