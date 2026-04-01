package com.lulan.shincolle.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EquipCannon
        extends BasicEquip {
    private static final String NAME = "EquipCannon";

    public EquipCannon() {
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
        return 16;
    }

    @Override
    public int getIconTypes() {
        return 3;
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        switch (meta) {
            case 0:
            case 1:
            case 12: {
                return 0;
            }
            case 2:
            case 3:
            case 4:
            case 5:
            case 13: {
                return 1;
            }
            case 6:
            case 7:
            case 8: {
                return 2;
            }
            case 9:
            case 10:
            case 11:
            case 14:
            case 15: {
                return 3;
            }
            default:
        }
        return 0;
    }

    public int getIconFromDamage(int meta) {
        switch (this.getEquipTypeIDFromMeta(meta)) {
            case 0: {
                return 0;
            }
            case 1:
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            default:
        }
        return 3;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        switch (this.getEquipTypeIDFromMeta(stack.getMetadata())) {
            case 1: {
                return 12;
            }
            case 2: {
                return 18;
            }
            case 3: {
                return 25;
            }
            default:
        }
        return 9;
    }

    @Override
    public int[] getResourceValue(int meta) {
        switch (this.getEquipTypeIDFromMeta(meta)) {
            case 0: {
                return new int[]{itemRand.nextInt(4) + 5, itemRand.nextInt(4) + 5, itemRand.nextInt(5) + 11, itemRand.nextInt(3) + 3};
            }
            case 1: {
                return new int[]{itemRand.nextInt(7) + 10, itemRand.nextInt(7) + 10, itemRand.nextInt(8) + 16, itemRand.nextInt(6) + 6};
            }
            case 2: {
                return new int[]{itemRand.nextInt(10) + 50, itemRand.nextInt(15) + 70, itemRand.nextInt(35) + 90, itemRand.nextInt(20) + 80};
            }
            case 3: {
                return new int[]{itemRand.nextInt(60) + 170, itemRand.nextInt(70) + 210, itemRand.nextInt(80) + 250, itemRand.nextInt(50) + 130};
            }
            default:
        }
        return new int[]{0, 0, 0, 0};
    }
}
