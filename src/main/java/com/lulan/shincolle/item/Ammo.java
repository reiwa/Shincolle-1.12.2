package com.lulan.shincolle.item;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Ammo
        extends BasicItem
        implements IShipResourceItem,
        IShipFoodItem {
    private static final String NAME = "Ammo";

    public Ammo() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setHasSubtypes(true);
    }

    @Override
    @SideOnly(value= Side.CLIENT)
    public void initModel() {
        ModelResourceLocation[] models = new ModelResourceLocation[this.getTypes()];
        for (int i = 0; i < this.getTypes(); ++i) {
            models[i] = new ModelResourceLocation(this.getRegistryName() + String.valueOf(i), "inventory");
        }
        ModelBakery.registerItemVariants(this, models);
        for(int i = 0; i < this.getTypes(); ++i) {
            ModelLoader.setCustomModelResourceLocation(this, i, models[i]);
        }
    }

    @Override
    public int getTypes() {
        return 4;
    }

    @Override
    public int[] getResourceValue(int meta) {
        switch (meta) {
            case 0: {
                return new int[]{0, 0, 1, 0};
            }
            case 1: {
                return new int[]{0, 0, 9, 0};
            }
            case 2: {
                return new int[]{0, 0, 4, 0};
            }
            case 3: {
                return new int[]{0, 0, 36, 0};
            }
            default:
        }
        return new int[]{0, 0, 0, 0};
    }

    @Override
    public float getFoodValue(int meta) {
        return 5.0f;
    }

    @Override
    public int getSpecialEffect(int meta) {
        return 3;
    }
}
