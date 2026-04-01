package com.lulan.shincolle.item;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipCV;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.network.S2CSpawnParticle;
import com.lulan.shincolle.proxy.CommonProxy;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import javax.annotation.Nullable;
import java.util.Random;

public class BucketRepair
        extends BasicItem {
    private static final String NAME = "BucketRepair";
    private static final String NBT_KEY = "particle_timer";

    public BucketRepair() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setMaxStackSize(16);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        int useTime = capa.getMorphEntity() instanceof BasicEntityShip ? 24 : 40;
        NBTTagCompound tag = stack.getTagCompound();
        if (tag == null) {
            tag = new NBTTagCompound();
        }
        tag.setInteger("UseDuration", useTime);
        stack.setTagCompound(tag);
        player.setActiveHand(hand);
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        NBTTagCompound tag = stack.getTagCompound();
        if (tag != null && tag.hasKey("UseDuration")) {
            return tag.getInteger("UseDuration");
        }
        return 24;
    }

    @Nullable
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase host) {
        EntityPlayer player;
        CapaTeitoku capa;
        if(host instanceof EntityPlayer && !world.isRemote) {
            player = (EntityPlayer) host;
            if (CommonProxy.activeMetamorph && ConfigHandler.enableMetamorphSkill && (capa = CapaTeitoku.getTeitokuCapability(player)) != null && capa.getMorphEntity() instanceof BasicEntityShip) {
                BasicEntityShip ship = (BasicEntityShip) capa.getMorphEntity();
                if (player.getHealth() < player.getMaxHealth()) {
                    if (!player.capabilities.isCreativeMode) {
                        stack.shrink(1);
                    }
                    player.heal(player.getMaxHealth() * 0.1f + 2.0f);
                    if (ship instanceof BasicEntityShipCV) {
                        BasicEntityShipCV ship2 = (BasicEntityShipCV) ship;
                        ship2.setNumAircraftLight(ship2.getNumAircraftLight() + 1);
                        ship2.setNumAircraftHeavy(ship2.getNumAircraftHeavy() + 1);
                    }
                }
            } else {
                setParticleTimer(player, 220);
                player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 220, 0));
                player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 220, 0));
            }
        }
        return stack;
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && !event.player.world.isRemote) {
            EntityPlayer player = event.player;
            int timer = getParticleTimer(player);
            if (timer > 0) {
                spawnParticlesAroundPlayer(player);
                setParticleTimer(player, timer - 1);
            }
        }
    }

    private void spawnParticlesAroundPlayer(EntityPlayer player) {
        if (player.world instanceof WorldServer) {
            Random rand = player.world.rand;
            for (int i = 0; i < 3; i++) {
                double x = player.posX + (rand.nextDouble() - 0.5D) * 1.5D;
                double y = player.posY + rand.nextDouble() * 2.0D;
                double z = player.posZ + (rand.nextDouble() - 0.5D) * 1.5D;
                CommonProxy.channelP.sendToAllAround(new S2CSpawnParticle(51, x, y, z, 0.0, 0.0, 0.0), new NetworkRegistry.TargetPoint(player.world.provider.getDimension(), x, y, z, 64.0D));
            }
        }
    }

    public static void setParticleTimer(EntityPlayer player, int ticks) {
        NBTTagCompound nbt = player.getEntityData();
        nbt.setInteger(NBT_KEY, ticks);
    }

    public static int getParticleTimer(EntityPlayer player) {
        NBTTagCompound nbt = player.getEntityData();
        return nbt.getInteger(NBT_KEY);
    }
}
