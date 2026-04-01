package com.lulan.shincolle.crafting;

import com.lulan.shincolle.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.List;

public class RecipeEnchantShell extends IForgeRegistryEntry.Impl<IRecipe>implements IRecipe {

    public boolean matches(InventoryCrafting inv, World worldIn) {
        if (inv.getWidth() == 3 && inv.getHeight() == 3) {
            ItemStack stack0 = inv.getStackInRowAndColumn(0, 0);
            if (stack0.getItem() != Items.POTIONITEM) {
                return false;
            }
            for (int i = 0; i < inv.getWidth(); ++i) {
                for (int j = 0; j < inv.getHeight(); ++j) {
                    if (i == 0 && j == 0) continue;
                    ItemStack stackX = inv.getStackInRowAndColumn(i, j);
                    Item item = stackX.getItem();
                    if (i == 1 && j == 1) {
                        if (item != ModItems.EquipAmmo) {
                            return false;
                        }
                        if (stackX.getMetadata() == 7) continue;
                        return false;
                    }
                    if (item == Items.POTIONITEM) {
                        if (ItemStack.areItemStackTagsEqual(stack0, stackX)) continue;
                        return false;
                    }
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Nullable
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack ammo = inv.getStackInRowAndColumn(1, 1);
        ItemStack potion = inv.getStackInRowAndColumn(0, 0);
        if (ammo.getItem() == ModItems.EquipAmmo && potion.getItem() == Items.POTIONITEM) {
            ItemStack ammoNew = ammo.copy();
            List<PotionEffect> elist = PotionUtils.getEffectsFromStack(potion);
            if (!elist.isEmpty()) {
                NBTTagCompound nbt0;
                PotionEffect effect = elist.get(0);
                int pid = Potion.getIdFromPotion(effect.getPotion());
                if (pid < 1) {
                    return ammoNew;
                }
                int plv = effect.getAmplifier();
                int ptime = 100;
                int pchance = 20;
                NBTTagCompound nbtOld = ammo.getTagCompound();
                if (nbtOld != null) {
                    nbt0 = nbtOld.getTagList("PList", 10).getCompoundTagAt(0);
                    int pidOld = nbt0.getInteger("PID");
                    int plvOld = nbt0.getInteger("PLV");
                    int ptimeOld = nbt0.getInteger("PTick");
                    int pchanceOld = nbt0.getInteger("PChance");
                    if (pid == pidOld && plv == plvOld) {
                        ptime = ptimeOld + 20;
                        pchance = pchanceOld + 10;
                        if (pchance > 100) {
                            pchance = 100;
                        }
                    }
                }
                NBTTagCompound nbtNew = new NBTTagCompound();
                NBTTagList listNew = new NBTTagList();
                NBTTagCompound nbt02 = new NBTTagCompound();
                nbt02.setInteger("PID", pid);
                nbt02.setInteger("PLV", plv);
                nbt02.setInteger("PTick", ptime);
                nbt02.setInteger("PChance", pchance);
                listNew.appendTag(nbt02);
                nbtNew.setTag("PList", listNew);
                ammoNew.setTagCompound(nbtNew);
            }
            return ammoNew;
        }
        return ItemStack.EMPTY;
    }

    @Nullable
    public ItemStack getRecipeOutput() {
        return ItemStack.EMPTY;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
        return NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }
}
