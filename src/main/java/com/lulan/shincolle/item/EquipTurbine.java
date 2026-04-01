package com.lulan.shincolle.item;

import net.minecraft.item.ItemStack;

public class EquipTurbine
        extends BasicEquip {
    private static final String NAME = "EquipTurbine";

    public EquipTurbine() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setHasSubtypes(true);
    }

    @Override
    public int getTypes() {
        return 5;
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        switch (meta) {
            case 0:
            case 1: {
                return 16;
            }
            case 2:
            case 3:
            case 4: {
                return 17;
            }
            default:
        }
        return 0;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        switch (this.getEquipTypeIDFromMeta(stack.getMetadata())) {
            case 16: {
                return 18;
            }
            case 17: {
                return 25;
            }
            default:
        }
        return 9;
    }

    @Override
    public int[] getResourceValue(int meta) {
        switch (this.getEquipTypeIDFromMeta(meta)) {
            case 16: {
                return new int[]{itemRand.nextInt(35) + 90, itemRand.nextInt(25) + 80, itemRand.nextInt(15) + 45, itemRand.nextInt(20) + 60};
            }
            case 17: {
                return new int[]{itemRand.nextInt(70) + 200, itemRand.nextInt(55) + 170, itemRand.nextInt(25) + 90, itemRand.nextInt(40) + 130};
            }
            default:
        }
        return new int[]{0, 0, 0, 0};
    }
}
