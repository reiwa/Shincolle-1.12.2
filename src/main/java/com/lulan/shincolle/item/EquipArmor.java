package com.lulan.shincolle.item;

import net.minecraft.item.ItemStack;

public class EquipArmor
        extends BasicEquip {
    private static final String NAME = "EquipArmor";

    public EquipArmor() {
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
            case 2:
            case 3:
            case 5: {
                return 18;
            }
            case 1:
            case 4:
            case 6: {
                return 19;
            }
            default:
        }
        return 0;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        switch (this.getEquipTypeIDFromMeta(stack.getMetadata())) {
            case 18: {
                return 9;
            }
            case 19: {
                return 20;
            }
            default:
        }
        return 9;
    }

    @Override
    public int[] getResourceValue(int meta) {
        switch (this.getEquipTypeIDFromMeta(meta)) {
            case 18: {
                return new int[]{itemRand.nextInt(3) + 3, itemRand.nextInt(4) + 4, itemRand.nextInt(2) + 2, itemRand.nextInt(2) + 2};
            }
            case 19: {
                return new int[]{itemRand.nextInt(15) + 35, itemRand.nextInt(20) + 45, itemRand.nextInt(10) + 25, itemRand.nextInt(5) + 15};
            }
            default:
        }
        return new int[]{0, 0, 0, 0};
    }
}
