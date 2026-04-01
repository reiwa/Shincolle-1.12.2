package com.lulan.shincolle.crafting;

import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModBlocks;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.item.IShipResourceItem;
import com.lulan.shincolle.item.ShipSpawnEgg;
import com.lulan.shincolle.tileentity.TileMultiGrudgeHeavy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class LargeRecipes {
    private static final int MAX_STOCK = 1000000;
    private static final int BASE_POWER = 460800;
    private static final int POWER_PER_MAT = 256;

    private LargeRecipes() {}

    private static class MaterialOutput {
        final Item item;
        final int meta;
        MaterialOutput(Item item, int meta) {
            this.item = item;
            this.meta = meta;
        }
    }

    public static boolean canRecipeBuild(int[] matAmount) {
        return matAmount[0] >= 100 && matAmount[1] >= 100 && matAmount[2] >= 100 && matAmount[3] >= 100;
    }

    public static int calcGoalPower(int[] matAmount) {
        if (LargeRecipes.canRecipeBuild(matAmount)) {
            int extraAmount = matAmount[0] + matAmount[1] + matAmount[2] + matAmount[3] - 400;
            return BASE_POWER + POWER_PER_MAT * extraAmount;
        }
        return 0;
    }

    private static void addSlotContents(TileMultiGrudgeHeavy tile, Item item, int meta, int slot) {
        ItemStack stack = tile.getStackInSlot(slot);
        if (stack == null || stack.isEmpty()) {
            tile.setInventorySlotContents(slot, new ItemStack(item, 1, meta));
        } else {
            ItemStack copy = stack.copy();
            copy.grow(1);
            tile.setInventorySlotContents(slot, copy);
        }
    }

    private static int getFitSlot(TileMultiGrudgeHeavy tile, Item item, int meta) {
        for (int i = 1; i < 10; ++i) {
            ItemStack stack = tile.getStackInSlot(i);
            if (stack == null || stack.isEmpty()) {
                return i;
            }
            if (stack.getItem() == item && stack.getMetadata() == meta && stack.getCount() < stack.getMaxStackSize()) {
                return i;
            }
        }
        return -1;
    }

    private static MaterialOutput getOutputItem(int selectMat, boolean compress) {
        if (compress) {
            switch (selectMat) {
                case 0: return new MaterialOutput(Item.getItemFromBlock(ModBlocks.BlockGrudge), 0);
                case 1: return new MaterialOutput(Item.getItemFromBlock(ModBlocks.BlockAbyssium), 0);
                case 2: return new MaterialOutput(ModItems.Ammo, 1);
                case 3: return new MaterialOutput(Item.getItemFromBlock(ModBlocks.BlockPolymetal), 0);
                default:
            }
        } else {
            switch (selectMat) {
                case 0: return new MaterialOutput(ModItems.Grudge, 0);
                case 1: return new MaterialOutput(ModItems.AbyssMetal, 0);
                case 2: return new MaterialOutput(ModItems.Ammo, 0);
                case 3: return new MaterialOutput(ModItems.AbyssMetal, 1);
                default:
            }
        }
        return null;
    }

    public static boolean outputMaterialToSlot(TileMultiGrudgeHeavy tile, int selectMat, boolean compress) {
        MaterialOutput output = getOutputItem(selectMat, compress);
        if (output != null) {
            int slot = getFitSlot(tile, output.item, output.meta);
            if (slot > -1) {
                addSlotContents(tile, output.item, output.meta, slot);
                return true;
            }
        }
        return false;
    }

    private static void addMaterialsToTile(TileMultiGrudgeHeavy tile, int[] amounts, int multiplier) {
        for (int i = 0; i < 4; ++i) {
            if (amounts.length > i) {
                tile.addMatStock(i, amounts[i] * multiplier);
            }
        }
    }

    public static boolean addMaterialStock(TileMultiGrudgeHeavy tile, ItemStack stack) {
        if (stack == null || stack.isEmpty()) return false;
        try {
            for (int j = 0; j < 4; ++j) {
                if (tile.getMatStock(j) > MAX_STOCK) {
                    return false;
                }
            }
            int level = ConfigHandler.consumptionLevel;
            int multiplier = level == 0 ? 10 : (level == 1 ? 2 : 1);
            Item item = stack.getItem();
            Block block = Block.getBlockFromItem(item);
            if (item instanceof IShipResourceItem) {
                addMaterialsToTile(tile, ((IShipResourceItem) item).getResourceValue(stack.getItemDamage()), multiplier);
                return true;
            }
            if (item instanceof ShipSpawnEgg) {
                for (ItemStack eggMat : ShipCalc.getKaitaiItems(stack.getItemDamage() - 2)) {
                    if (eggMat == null) return false;
                    addMaterialsToTile(tile, ((IShipResourceItem) eggMat.getItem()).getResourceValue(eggMat.getItemDamage()), eggMat.getCount() * multiplier);
                }
                return true;
            }
            if (block == ModBlocks.BlockGrudgeHeavy) {
                int[] addMats = {81, 0, 0, 0};
                if (stack.hasTagCompound()) {
                    int[] nbtMats = stack.getTagCompound().getIntArray("mats");
                    for (int i = 0; i < nbtMats.length && i < 4; ++i) addMats[i] += nbtMats[i];
                }
                addMaterialsToTile(tile, addMats, multiplier);
                return true;
            }
            if (block == ModBlocks.BlockGrudge) {
                tile.addMatStock(0, 9 * multiplier);
                return true;
            }
            if (block == ModBlocks.BlockAbyssium) {
                tile.addMatStock(1, 9 * multiplier);
                return true;
            }
            if (block == ModBlocks.BlockPolymetal) {
                tile.addMatStock(3, 9 * multiplier);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static ItemStack getBuildResultShip(int[] matAmount) {
        ItemStack buildResult = new ItemStack(ModItems.ShipSpawnEgg, 1, 1);
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("Grudge", matAmount[0]);
        nbt.setInteger("Abyssium", matAmount[1]);
        nbt.setInteger("Ammo", matAmount[2]);
        nbt.setInteger("Polymetal", matAmount[3]);
        buildResult.setTagCompound(nbt);
        return buildResult;
    }

    public static ItemStack getBuildResultEquip(int[] matAmount) {
        int totalMats = matAmount[0] + matAmount[1] + matAmount[2] + matAmount[3];
        int rollType = EquipCalc.rollEquipType(1, matAmount);
        return EquipCalc.rollEquipsOfTheType(rollType, totalMats, 1);
    }
}