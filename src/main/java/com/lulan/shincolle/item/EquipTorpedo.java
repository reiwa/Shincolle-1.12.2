package com.lulan.shincolle.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class EquipTorpedo
        extends BasicEquip
        implements IShipEffectItem {
    private static final String NAME = "EquipTorpedo";

    public EquipTorpedo() {
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
            case 2: {
                return 4;
            }
            case 3:
            case 4:
            case 5:
            case 6: {
                return 5;
            }
            default:
        }
        return 0;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        switch (this.getEquipTypeIDFromMeta(stack.getMetadata())) {
            case 4: {
                return 16;
            }
            case 5: {
                return 22;
            }
            default:
        }
        return 9;
    }

    @Override
    public int[] getResourceValue(int meta) {
        switch (this.getEquipTypeIDFromMeta(meta)) {
            case 4: {
                return new int[]{itemRand.nextInt(4) + 8, itemRand.nextInt(5) + 8, itemRand.nextInt(6) + 12, itemRand.nextInt(4) + 5};
            }
            case 5: {
                return new int[]{itemRand.nextInt(20) + 60, itemRand.nextInt(25) + 70, itemRand.nextInt(30) + 80, itemRand.nextInt(15) + 45};
            }
            default:
        }
        return new int[]{0, 0, 0, 0};
    }

    @Override
    public Map<Integer, int[]> getEffectOnAttack(int meta) {
        return Collections.emptyMap();
    }

    @Override
    public int getMissileType(int meta) {
        return -1;
    }

    @Override
    public int getMissileMoveType(int meta) {
        return -1;
    }

    @Override
    public int getMissileSpeedLevel(int meta) {
        switch (meta) {
            case 3:
            case 4: {
                return 1;
            }
            case 5: {
                return 2;
            }
            case 6: {
                return 3;
            }
            default:
        }
        return 0;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        int level = this.getMissileSpeedLevel(stack.getMetadata());
        if (level != 0) {
            tooltip.add(TextFormatting.YELLOW + I18n.format("gui.shincolle:equip.torpedospeed", level));
        }
    }
}
