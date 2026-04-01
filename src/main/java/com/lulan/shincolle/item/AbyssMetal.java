package com.lulan.shincolle.item;

public class AbyssMetal
extends BasicItem
implements IShipResourceItem,
IShipFoodItem {
    public static final String MODID = "shincolle";
    private static final String NAME = "AbyssMetal";

    public AbyssMetal() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setHasSubtypes(true);
    }

    @Override
    public int getTypes() {
        return 2;
    }

    @Override
    public int[] getResourceValue(int meta) {
        if (meta == 0) {
            return new int[]{0, 1, 0, 0};
        }
        return new int[]{0, 0, 0, 1};
    }

    @Override
    public float getFoodValue(int meta) {
        return 30.0f;
    }

    @Override
    public int getSpecialEffect(int meta) {
        if (meta == 0) {
            return 2;
        }
        return 4;
    }
}
