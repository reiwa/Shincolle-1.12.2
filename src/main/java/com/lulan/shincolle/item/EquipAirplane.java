package com.lulan.shincolle.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EquipAirplane
        extends BasicEquip {
    private static final String NAME = "EquipAirplane";

    public EquipAirplane() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setHasSubtypes(true);
    }

    @Override
    @SideOnly(value= Side.CLIENT)
    public void initModel() {
        ResourceLocation base = this.getRegistryName();
        int iconTypes = getIconTypes();
        ModelResourceLocation[] models = new ModelResourceLocation[iconTypes];

        for (int i = 0; i < iconTypes; i++) {
            ResourceLocation variant = new ResourceLocation(base.getResourceDomain(), base.getResourcePath() + i);
            models[i] = new ModelResourceLocation(variant, "inventory");
        }

        int types = getTypes();
        for (int meta = 0; meta < types; meta++) {
            int texIndex = getIconFromDamage(meta);
            ModelLoader.setCustomModelResourceLocation(this, meta, models[texIndex]);
        }
    }

    @Override
    public int getTypes() {
        return 22;
    }

    @Override
    public int getIconTypes() {
        return 4;
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        switch (meta) {
            case 0:
            case 1:
            case 2: {
                return 6;
            }
            case 3:
            case 15: {
                return 7;
            }
            case 4:
            case 5:
            case 6: {
                return 8;
            }
            case 7:
            case 8:
            case 16:
            case 18:
            case 21: {
                return 9;
            }
            case 9:
            case 10: {
                return 10;
            }
            case 11:
            case 12:
            case 17:
            case 19:
            case 20: {
                return 11;
            }
            case 13: {
                return 12;
            }
            case 14: {
                return 13;
            }
            default:
        }
        return 0;
    }

    public int getIconFromDamage(int meta) {
        switch (this.getEquipTypeIDFromMeta(meta)) {
            case 6:
            case 7: {
                return 0;
            }
            case 8:
            case 9: {
                return 1;
            }
            case 10:
            case 11: {
                return 2;
            }
            case 12:
            case 13: {
                return 3;
            }
            default:
        }
        return 0;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        switch (this.getEquipTypeIDFromMeta(stack.getMetadata())) {
            case 6:
            case 8:
            case 10:
            case 12: {
                return 18;
            }
            case 7:
            case 9:
            case 11:
            case 13: {
                return 25;
            }
            default:
        }
        return 9;
    }

    @Override
    public int[] getResourceValue(int meta) {
        switch (this.getEquipTypeIDFromMeta(meta)) {
            case 6:
            case 8:
            case 10: {
                return new int[]{itemRand.nextInt(20) + 80, itemRand.nextInt(30) + 100, itemRand.nextInt(40) + 120, itemRand.nextInt(50) + 150};
            }
            case 7:
            case 9:
            case 11: {
                return new int[]{itemRand.nextInt(50) + 130, itemRand.nextInt(60) + 170, itemRand.nextInt(70) + 210, itemRand.nextInt(75) + 230};
            }
            case 12: {
                return new int[]{itemRand.nextInt(12) + 3, itemRand.nextInt(14) + 5, itemRand.nextInt(14) + 5, itemRand.nextInt(16) + 11};
            }
            case 13: {
                return new int[]{itemRand.nextInt(10) + 40, itemRand.nextInt(15) + 50, itemRand.nextInt(20) + 60, itemRand.nextInt(25) + 80};
            }
            default:
        }
        return new int[]{0, 0, 0, 0};
    }
}
