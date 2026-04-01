package com.lulan.shincolle.item;

import net.minecraft.item.ItemStack;

public class EquipMachinegun
        extends BasicEquip {
    private static final String NAME = "EquipMachinegun";

    public EquipMachinegun() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setHasSubtypes(true);
    }

    @Override
    public int getTypes() {
        return 7;
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        switch (meta) {
            case 0:
            case 1:
            case 2:
            case 3: {
                return 20;
            }
            case 4:
            case 5:
            case 6: {
                return 21;
            }
            default:
        }
        return 0;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        switch (this.getEquipTypeIDFromMeta(stack.getMetadata())) {
            case 20: {
                return 12;
            }
            case 21: {
                return 15;
            }
            default:
        }
        return 9;
    }

    @Override
    public int[] getResourceValue(int meta) {
        switch (this.getEquipTypeIDFromMeta(meta)) {
            case 20: {
                return new int[]{itemRand.nextInt(3) + 4, itemRand.nextInt(4) + 7, itemRand.nextInt(5) + 8, itemRand.nextInt(2) + 4};
            }
            case 21: {
                return new int[]{itemRand.nextInt(20) + 30, itemRand.nextInt(25) + 40, itemRand.nextInt(30) + 50, itemRand.nextInt(15) + 20};
            }
            default:
        }
        return new int[]{0, 0, 0, 0};
    }
}
