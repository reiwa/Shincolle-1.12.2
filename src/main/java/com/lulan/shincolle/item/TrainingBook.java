package com.lulan.shincolle.item;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModSounds;
import com.lulan.shincolle.proxy.CommonProxy;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class TrainingBook
        extends BasicItem {
    private static final String NAME = "TrainingBook";

    public TrainingBook() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
    }

    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.GOLD + I18n.format("gui.shincolle:trainingbook"));
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
        BasicEntityShip ship;
        EntityPlayer player;
        CapaTeitoku capa;
        if (host instanceof EntityPlayer && world != null && !world.isRemote && CommonProxy.activeMetamorph && ConfigHandler.enableMetamorphSkill && (capa = CapaTeitoku.getTeitokuCapability(player = (EntityPlayer)host)) != null && capa.getMorphEntity() instanceof BasicEntityShip && (ship = (BasicEntityShip)capa.getMorphEntity()).getLevel() < 150) {
            int lv = ship.getLevel() + 5 + ship.getRNG().nextInt(6);
            if (lv > 150) {
                lv = 150;
            }
            ship.setShipLevel(lv, true);
            ship.playSound(ModSounds.SHIP_LEVEL, 0.75f, 1.0f);
            ship.world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_LEVELUP, ship.getSoundCategory(), 0.75f, 1.0f);
            if (!player.capabilities.isCreativeMode) {
                stack.shrink(1);
            }
        }
        return stack;
    }
}
