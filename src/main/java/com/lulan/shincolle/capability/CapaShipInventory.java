package com.lulan.shincolle.capability;

import com.lulan.shincolle.entity.BasicEntityShip;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

public class CapaShipInventory extends CapaInventory<BasicEntityShip> implements IInventory {
    public static final int SLOT_PAGES = 3;
    private static final int BASE_SIZE = 24;
    private static final int PER_LEVEL_SIZE = 18;
    private static final int ATTRIBUTE_CALC_THRESHOLD = 6;

    private int inventoryPage;

    public CapaShipInventory(int size, BasicEntityShip host) {
        super(size, host);
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < getSizeInventory(); i++) {
            if (!getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public int getInventoryPage() {
        return inventoryPage;
    }

    public void setInventoryPage(int page) {
        if (page < 0 || page >= SLOT_PAGES) {
            inventoryPage = 0;
        } else {
            inventoryPage = page;
        }
        host.sendSyncPacketGUI();
    }

    @Override
    public String getName() {
        return "ship_inventory";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return null;
    }

    @Override
    public int getSizeInventory() {
        return BASE_SIZE;
    }

    public int getSizeInventoryPaged() {
        if (host != null) {
            int level = host.getStateMinor(36);
            return BASE_SIZE + level * PER_LEVEL_SIZE;
        }
        return BASE_SIZE;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        validateSlotIndex(index);
        return stacks.get(index);
    }

    public ItemStack getStackInSlotWithPageCheck(int index) {
        int pagedSize = getSizeInventoryPaged();
        if (index < 0 || index >= pagedSize || index >= stacks.size()) {
            throw new IllegalArgumentException(
                    String.format("Slot %d not in valid range [0, %d)", index, stacks.size())
            );
        }
        return stacks.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        if (index < 0 || index >= getSlots() || count <= 0) {
            return ItemStack.EMPTY;
        }
        ItemStack original = getStackInSlot(index);
        ItemStack result = original.splitStack(count);
        if (original.isEmpty()) {
            setStackInSlot(index, ItemStack.EMPTY);
        }
        return result;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        setStackInSlot(index, stack);
        enforceStackLimit(stack);
        recalcAttributesIfNeeded(index);
    }

    public void setInventorySlotWithPageCheck(int index, ItemStack stack) {
        int pagedSize = getSizeInventoryPaged();
        if (index < 0 || index >= pagedSize || index >= stacks.size()) {
            throw new IllegalArgumentException(
                    String.format("Slot %d not in valid range [0, %d)", index, stacks.size())
            );
        }
        ItemStack current = stacks.get(index);
        if (!ItemStack.areItemStacksEqual(current, stack)) {
            stacks.set(index, stack);
            onContentsChanged(index);
            recalcAttributesIfNeeded(index);
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void markDirty() {
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public void clear() {
        stacks.clear();
    }

    public boolean isSlotAvailable(int slotId) {
        int pages = host.getInventoryPageSize();
        if (pages < 2) {
            if (slotId >= 42) {
                return false;
            }
            return pages >= 1 || slotId < BASE_SIZE;
        }
        return true;
    }

    public int findFirstSlotForNewItem() {
        for (int i = ATTRIBUTE_CALC_THRESHOLD; i < getSlots(); i++) {
            if (isSlotAvailable(i)) {
                return i;
            }
        }
        return -1;
    }

    private int findFirstStackableSlot(ItemStack stack) {
        for (int i = ATTRIBUTE_CALC_THRESHOLD; i < getSlots(); i++) {
            if (!isSlotAvailable(i)) {
                return -1;
            }
            ItemStack slotStack = getStackInSlot(i);
            if (slotStack.getItem() == stack.getItem()
                    && slotStack.isStackable()
                    && slotStack.getCount() < Math.min(slotStack.getMaxStackSize(), getInventoryStackLimit())
                    && (!slotStack.getHasSubtypes() || slotStack.getItemDamage() == stack.getItemDamage())
                    && ItemStack.areItemStackTagsEqual(slotStack, stack)) {
                return i;
            }
        }
        return -1;
    }

    private int storePartialItemStack(ItemStack stack) {
        int remaining = stack.getCount();
        if (stack.getMaxStackSize() == 1) {
            int slot = findFirstSlotForNewItem();
            if (slot < 0) {
                return remaining;
            }
            setStackInSlot(slot, stack.copy());
            return 0;
        }
        int slot = findFirstStackableSlot(stack);
        if (slot < 0) {
            slot = findFirstSlotForNewItem();
        }
        if (slot < 0) {
            return remaining;
        }
        ItemStack slotStack = getStackInSlot(slot);
        ItemStack copyItem = new ItemStack(stack.getItem(), 0, stack.getItemDamage());
        if (stack.hasTagCompound()) {
            copyItem.setTagCompound(stack.getTagCompound().copy());
        }
        setStackInSlot(slot, copyItem);
        int toTransfer = Math.min(remaining,
                Math.min(copyItem.getMaxStackSize() - slotStack.getCount(),
                        getInventoryStackLimit() - slotStack.getCount()));
        if (toTransfer <= 0) {
            return remaining;
        }
        slotStack.setCount(slotStack.getCount() + toTransfer);
        return remaining - toTransfer;
    }

    public boolean addItemStackToInventory(ItemStack stack) {
        if (stack.isEmpty() || stack.getCount() == 0) {
            return false;
        }
        if (stack.isItemDamaged()) {
            int slot = findFirstSlotForNewItem();
            if (slot < 0) {
                return false;
            }
            setStackInSlot(slot, stack.copy());
            stack.setCount(0);
            return true;
        }
        int initialCount = stack.getCount();
        int newCount;
        do {
            newCount = storePartialItemStack(stack);
            stack.setCount(newCount);
        } while (stack.getCount() > 0 && stack.getCount() < initialCount);
        return stack.getCount() < initialCount;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    private void enforceStackLimit(ItemStack stack) {
        if (stack.getCount() > getInventoryStackLimit()) {
            stack.setCount(getInventoryStackLimit());
        }
    }

    private void recalcAttributesIfNeeded(int index) {
        if (!host.world.isRemote && index < ATTRIBUTE_CALC_THRESHOLD) {
            host.calcShipAttributes(2, true);
        }
    }
}
