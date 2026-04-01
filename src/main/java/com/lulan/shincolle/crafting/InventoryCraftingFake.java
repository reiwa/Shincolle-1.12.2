package com.lulan.shincolle.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;

public class InventoryCraftingFake
extends InventoryCrafting {
    protected final ItemStack[] stacks;
    protected final int width;
    protected final int height;

    public InventoryCraftingFake(int width, int height) {
        super(null, width, height);
        int i = width * height;
        this.stacks = new ItemStack[i];
        this.width = width;
        this.height = height;
    }

    public int getSizeInventory() {
        return this.stacks.length;
    }

    @Nullable
    public ItemStack getStackInSlot(int index) {
        return index >= this.getSizeInventory() ? ItemStack.EMPTY : this.stacks[index];
    }

    @Nullable
    public ItemStack getStackInRowAndColumn(int row, int column) {
        return row >= 0 && row < this.width && column >= 0 && column <= this.height ? this.getStackInSlot(row + column * this.width) : ItemStack.EMPTY;
    }

    @Nullable
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(new ArrayList<>(Arrays.asList(this.stacks)), index);
    }

    @Nullable
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(new ArrayList<>(Arrays.asList(this.stacks)), index, count);
    }

    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
        this.stacks[index] = stack;
    }

    public void clear() {
        Arrays.fill(this.stacks, ItemStack.EMPTY);
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
