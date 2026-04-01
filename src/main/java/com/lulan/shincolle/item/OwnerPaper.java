package com.lulan.shincolle.item;

import com.lulan.shincolle.capability.CapaTeitoku;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class OwnerPaper
        extends BasicItem {
    private static final String NAME = "OwnerPaper";
    public static final String SignNameA = "SignNameA";
    public static final String SignNameB = "SignNameB";
    public static final String SignIDA = "SignIDA";
    public static final String SignIDB = "SignIDB";

    public OwnerPaper() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setMaxStackSize(1);
    }

    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        CapaTeitoku capa;
        if (!world.isRemote && !player.isSneaking() && (capa = CapaTeitoku.getTeitokuCapability(player)) != null) {
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setString(SignNameA, player.getName());
                stack.getTagCompound().setString(SignNameB, "");
                stack.getTagCompound().setInteger(SignIDA, capa.getPlayerUID());
                stack.getTagCompound().setInteger(SignIDB, -1);
                stack.getTagCompound().setBoolean("signPos", false);
            } else if (stack.getTagCompound().getBoolean("signPos")) {
                stack.getTagCompound().setString(SignNameA, player.getName());
                stack.getTagCompound().setInteger(SignIDA, capa.getPlayerUID());
                stack.getTagCompound().setBoolean("signPos", false);
            } else {
                stack.getTagCompound().setString(SignNameB, player.getName());
                stack.getTagCompound().setInteger(SignIDB, capa.getPlayerUID());
                stack.getTagCompound().setBoolean("signPos", true);
            }
        }
        return new ActionResult<>(EnumActionResult.PASS, stack);
    }

    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (stack.hasTagCompound()) {
            tooltip.add(TextFormatting.RED + String.valueOf(stack.getTagCompound().getInteger(SignIDA)) + " " + TextFormatting.AQUA + stack.getTagCompound().getString(SignNameA));
            tooltip.add(TextFormatting.RED + String.valueOf(stack.getTagCompound().getInteger(SignIDB)) + " " + TextFormatting.AQUA + stack.getTagCompound().getString(SignNameB));
        }
    }
}
