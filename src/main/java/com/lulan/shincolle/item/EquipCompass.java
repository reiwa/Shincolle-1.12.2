package com.lulan.shincolle.item;

import com.lulan.shincolle.reference.Enums;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class EquipCompass
        extends BasicEquip {
    private static final String NAME = "EquipCompass";

    public EquipCompass() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
    }

    public Enums.EnumEquipEffectSP getSpecialEffect() {
        return Enums.EnumEquipEffectSP.COMPASS;
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        if(meta == 0){
            return 25;
        }
        return 0;
    }

    @Override
    public int[] getResourceValue(int meta) {
        if(this.getEquipTypeIDFromMeta(meta) == 25){
            return new int[]{itemRand.nextInt(5) + 5, itemRand.nextInt(3) + 4, itemRand.nextInt(2) + 2, itemRand.nextInt(2) + 2};
        }
        return new int[]{0, 0, 0, 0};
    }

    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.GRAY + I18n.format("gui.shincolle:compass"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
