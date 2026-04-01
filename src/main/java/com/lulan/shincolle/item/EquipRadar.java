package com.lulan.shincolle.item;

import net.minecraft.item.ItemStack;

public class EquipRadar
        extends BasicEquip {
    private static final String NAME = "EquipRadar";

    public EquipRadar() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setHasSubtypes(true);
    }

    @Override
    public int getTypes() {
        return 9;
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        switch (meta) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4: {
                return 14;
            }
            case 5:
            case 6:
            case 7:
            case 8: {
                return 15;
            }
            default:
        }
        return 0;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        switch (this.getEquipTypeIDFromMeta(stack.getMetadata())) {
            case 14: {
                return 12;
            }
            case 15: {
                return 15;
            }
            default:
        }
        return 9;
    }

    @Override
    public int[] getResourceValue(int meta) {
        switch (this.getEquipTypeIDFromMeta(meta)) {
            case 14: {
                return new int[]{itemRand.nextInt(7) + 12, itemRand.nextInt(6) + 10, itemRand.nextInt(5) + 9, itemRand.nextInt(4) + 7};
            }
            case 15: {
                return new int[]{itemRand.nextInt(40) + 110, itemRand.nextInt(35) + 90, itemRand.nextInt(30) + 70, itemRand.nextInt(25) + 50};
            }
            default:
        }
        return new int[]{0, 0, 0, 0};
    }
}
