package com.lulan.shincolle.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class OPTool
        extends BasicItem {
    private static final String NAME = "OPTool";

    public OPTool() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setMaxStackSize(1);
        this.setFull3D();
    }

    @SideOnly(value=Side.CLIENT)
    public boolean hasEffect(ItemStack item) {
        return true;
    }

    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.RED + I18n.format("gui.shincolle:optool1"));
        tooltip.add(TextFormatting.AQUA + I18n.format("gui.shincolle:optool2"));
    }
}
