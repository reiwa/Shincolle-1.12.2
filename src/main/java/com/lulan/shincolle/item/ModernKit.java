package com.lulan.shincolle.item;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.utility.InteractHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ModernKit
        extends BasicItem {
    private static final String NAME = "ModernKit";

    public ModernKit() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
    }

    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.GOLD + I18n.format("gui.shincolle:modernkit"));
    }

    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, EntityPlayer player, EnumHand hand) {
        if (CommonProxy.activeMetamorph && ConfigHandler.enableMetamorphSkill && hand == EnumHand.MAIN_HAND) {
            player.setActiveHand(hand);
            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        }
        return new ActionResult<>(EnumActionResult.FAIL, stack);
    }

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.EAT;
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        if (CommonProxy.activeMetamorph && ConfigHandler.enableMetamorphSkill) {
            return 80;
        }
        return 0;
    }

    @Nullable
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase host) {
        CapaTeitoku capa;
        if (host instanceof EntityPlayer && world != null && !world.isRemote && CommonProxy.activeMetamorph && ConfigHandler.enableMetamorphSkill && (capa = CapaTeitoku.getTeitokuCapability((EntityPlayer)host)) != null && capa.getMorphEntity() instanceof BasicEntityShip) {
            InteractHelper.interactModernKit((BasicEntityShip)capa.getMorphEntity(), (EntityPlayer)host, stack);
        }
        return stack;
    }
}
