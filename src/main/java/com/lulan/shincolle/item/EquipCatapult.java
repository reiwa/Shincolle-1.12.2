package com.lulan.shincolle.item;

import net.minecraft.item.ItemStack;

public class EquipCatapult
        extends BasicEquip {
    private static final String NAME = "EquipCatapult";

    public EquipCatapult() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setHasSubtypes(true);
    }

    @Override
    public int getTypes() {
        return 4;
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        switch (meta) {
            case 0:
            case 1: {
                return 22;
            }
            case 2:
            case 3: {
                return 23;
            }
            default:
        }
        return 0;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        switch (this.getEquipTypeIDFromMeta(stack.getMetadata())) {
            case 22: {
                return 18;
            }
            case 23: {
                return 25;
            }
            default:
        }
        return 9;
    }

    @Override
    public int[] getResourceValue(int meta) {
        switch (this.getEquipTypeIDFromMeta(meta)) {
            case 22: {
                return new int[]{itemRand.nextInt(40) + 120, itemRand.nextInt(50) + 150, itemRand.nextInt(30) + 80, itemRand.nextInt(60) + 180};
            }
            case 23: {
                return new int[]{itemRand.nextInt(70) + 190, itemRand.nextInt(85) + 230, itemRand.nextInt(55) + 150, itemRand.nextInt(90) + 250};
            }
            default:
        }
        return new int[]{0, 0, 0, 0};
    }
}
