package com.lulan.shincolle.client.gui.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerRecipePaper
extends Container {
    private final InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    private final IInventory craftResult = new InventoryCraftResult();
    private final World world;
    private final ItemStack hostStack;

    public ContainerRecipePaper(World world, IInventory invPlayer, ItemStack hostStack) {
        this.world = world;
        this.hostStack = hostStack;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }
        this.addSlotToContainer(new SlotRecipePaper(this.craftResult, 0, 124, 35));
        for (int k = 0; k < 3; ++k) {
            for (int i1 = 0; i1 < 9; ++i1) {
                this.addSlotToContainer(new Slot(invPlayer, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }
        for (int l = 0; l < 9; ++l) {
            this.addSlotToContainer(new Slot(invPlayer, l, 8 + l * 18, 142));
        }
        if (hostStack.hasTagCompound()) {
            NBTTagCompound nbt = hostStack.getTagCompound();
            NBTTagList tagList = nbt.getTagList("Recipe", 10);
            for (int i = 0; i < 9; ++i) {
                NBTTagCompound itemTags = tagList.getCompoundTagAt(i);
                int slot = itemTags.getInteger("Slot");
                if (slot < 0 || slot >= 9) continue;
                this.craftMatrix.setInventorySlotContents(slot, new ItemStack(itemTags));
            }
        }
        this.onCraftMatrixChanged(null);
    }

    public void onCraftMatrixChanged(IInventory inventoryIn) {
        IRecipe recipe = CraftingManager.findMatchingRecipe(this.craftMatrix, this.world);
        ItemStack result = recipe == null ? ItemStack.EMPTY : recipe.getRecipeOutput();
        this.craftResult.setInventorySlotContents(0, result);
    }

    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        if (!this.world.isRemote) {
            ItemStack stack;
            NBTTagCompound nbt;
            NBTTagList nbtlist = new NBTTagList();
            nbt = this.hostStack.hasTagCompound() ? this.hostStack.getTagCompound() : new NBTTagCompound();
            for (int i = 0; i < 9; ++i) {
                stack = this.craftMatrix.getStackInSlot(i);
                if (stack.isEmpty()) continue;
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setInteger("Slot", i);
                stack.writeToNBT(itemTag);
                nbtlist.appendTag(itemTag);
            }
            stack = this.craftResult.getStackInSlot(0);
            if (!stack.isEmpty()) {
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setInteger("Slot", 9);
                stack.writeToNBT(itemTag);
                nbtlist.appendTag(itemTag);
            }
            nbt.setTag("Recipe", nbtlist);
            this.hostStack.setTagCompound(nbt);
        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotid) {
        return ItemStack.EMPTY;
    }

    @SideOnly(value=Side.CLIENT)
    public void updateProgressBar(int id, int value) {
    }

    public ItemStack slotClick(int id, int key, ClickType type, EntityPlayer player) {
        ItemStack itemstack = player.inventory.getItemStack();
        if (id >= 0 && id < 9) {
            Slot slot = this.inventorySlots.get(id);
            if (!itemstack.isEmpty()) {
                if (key == 1) {
                    slot.putStack(ItemStack.EMPTY);
                } else {
                    ItemStack itemstack2 = itemstack.copy();
                    itemstack2.setCount(1);
                    slot.putStack(itemstack2);
                }
            } else {
                slot.putStack(ItemStack.EMPTY);
            }
            this.detectAndSendChanges();
            return ItemStack.EMPTY;
        }
        if (id == 9) {
            return ItemStack.EMPTY;
        }
        return super.slotClick(id, key, type, player);
    }
}
