package com.lulan.shincolle.item;

public class AbyssNugget
        extends BasicItem{
    public static final String MODID = "shincolle";
    private static final String NAME = "AbyssNugget";

    public AbyssNugget() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setHasSubtypes(true);
    }

    @Override
    public int getTypes() {
        return 2;
    }
}
