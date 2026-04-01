package com.lulan.shincolle.item;

import com.lulan.shincolle.ShinColle;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

import javax.annotation.Nullable;
import java.util.List;
public class RecipePaper
        extends BasicItem {
    private static final String NAME = "RecipePaper";

    public RecipePaper() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote) {
            FMLNetworkHandler.openGui(playerIn, ShinColle.instance, 8, worldIn, 0, 0, 0);
            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        }
        return new ActionResult<>(EnumActionResult.PASS, stack);
    }

    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        NBTTagList tagList;
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if (stack.hasTagCompound() && (tagList = (stack.getTagCompound()).getTagList("Recipe", 10)) != null && tagList.tagCount() > 0) {
            int i;
            ItemStack[] stacks = new ItemStack[10];
            for (i = 0; i < tagList.tagCount(); ++i) {
                NBTTagCompound itemTags = tagList.getCompoundTagAt(i);
                int slot = itemTags.getInteger("Slot");
                if (slot < 0 || slot >= 10) continue;
                stacks[slot] = new ItemStack(itemTags);
            }
            if (stacks[9].isEmpty()) {
                tooltip.add(TextFormatting.YELLOW + I18n.format("gui.shincolle:recipepaper.result") + " " + TextFormatting.WHITE + stacks[9].getDisplayName());
            }
            tooltip.add(TextFormatting.AQUA + I18n.format("gui.shincolle:recipepaper.material"));
            for (i = 0; i < 9; ++i) {
                if (stacks[i] == null || stacks[i].isEmpty()) continue;
                tooltip.add(TextFormatting.GRAY + "  " + stacks[i].getDisplayName());
            }
        }
    }
}
