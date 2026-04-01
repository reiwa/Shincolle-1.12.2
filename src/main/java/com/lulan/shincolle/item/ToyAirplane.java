package com.lulan.shincolle.item;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.network.S2CEntitySync;
import com.lulan.shincolle.proxy.CommonProxy;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ToyAirplane
        extends BasicItem
        implements IShipFoodItem {
    private static final String NAME = "ToyAirplane";

    public ToyAirplane() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
    }

    @Override
    public float getFoodValue(int meta) {
        return 150.0f;
    }

    @Override
    public int getSpecialEffect(int meta) {
        return 5;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.EAT;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if (playerIn.canEat(false)) {
            playerIn.setActiveHand(handIn);
            return new ActionResult<>(EnumActionResult.SUCCESS, stack);
        } else {
            return new ActionResult<>(EnumActionResult.FAIL, stack);
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityLiving;
            player.getFoodStats().addStats(1, 0.5F);
            player.attackEntityFrom(DamageSource.GENERIC, 1.0F);
            worldIn.playSound(null, player.posX, player.posY, player.posZ,
                    SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.PLAYERS, 1.0F, 1.0F);
            if (!player.capabilities.isCreativeMode) {
                stack.shrink(1);
            }
            if(BucketRepair.getParticleTimer(player) != 0){
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                capa.setAppearance(1);
                CommonProxy.channelE.sendToAll(new S2CEntitySync(player, 1, (byte)90));
                BucketRepair.setParticleTimer(player, 0);
            }
        }
        return stack;
    }
}
