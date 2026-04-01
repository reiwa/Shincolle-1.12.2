package com.lulan.shincolle.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class RepairGoddess
        extends BasicItem {
    private static final String NAME = "RepairGoddess";

    public RepairGoddess() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setMaxStackSize(16);
    }

    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.RED + I18n.format("gui.shincolle:repairgoddess"));
    }

    @SideOnly(value=Side.CLIENT)
    public boolean hasEffect(ItemStack item) {
        return true;
    }
}
