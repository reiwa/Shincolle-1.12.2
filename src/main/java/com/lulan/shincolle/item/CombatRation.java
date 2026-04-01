package com.lulan.shincolle.item;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.InteractHelper;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class CombatRation
        extends BasicItem
        implements IShipCombatRation {
    private static final String NAME = "CombatRation";

    public CombatRation() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setMaxStackSize(16);
        this.setHasSubtypes(true);
    }

    @Override
    @SideOnly(value= Side.CLIENT)
    public void initModel() {
        ModelResourceLocation[] models = new ModelResourceLocation[this.getTypes()];
        for (int i = 0; i < this.getTypes(); ++i) {
            models[i] = new ModelResourceLocation(this.getRegistryName() + String.valueOf(i), "inventory");
        }
        ModelBakery.registerItemVariants(this, models);
        for(int i = 0; i < this.getTypes(); ++i) {
            ModelLoader.setCustomModelResourceLocation(this, i, models[i]);
        }
    }

    @Override
    public int getTypes() {
        return 6;
    }

    @Override
    public float getFoodValue(int meta) {
        switch (meta) {
            case 1: {
                return 3600.0f;
            }
            case 2: {
                return 1200.0f;
            }
            case 3: {
                return 3900.0f;
            }
            case 4: {
                return 100.0f;
            }
            case 5: {
                return 900.0f;
            }
            default:
        }
        return 900.0f;
    }

    @Override
    public int getSpecialEffect(int meta) {
        return 6;
    }

    @Override
    public int getMoraleValue(int meta) {
        switch (meta) {
            case 1: {
                return 1800;
            }
            case 2: {
                return 1600;
            }
            case 3: {
                return 2000;
            }
            case 4: {
                return 3000;
            }
            case 5: {
                return 4000;
            }
            default:
        }
        return 1400;
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
            return 60;
        }
        return 0;
    }

    @Nullable
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase host) {
        CapaTeitoku capa;
        if (host instanceof EntityPlayer && world != null && !world.isRemote && CommonProxy.activeMetamorph && ConfigHandler.enableMetamorphSkill && (capa = CapaTeitoku.getTeitokuCapability((EntityPlayer)host)) != null && capa.getMorphEntity() instanceof BasicEntityShip) {
            InteractHelper.interactFeed((BasicEntityShip)capa.getMorphEntity(), (EntityPlayer)host, stack);
        }
        return stack;
    }

    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean inUse) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)entity;
            if (!world.isRemote && inUse && (player.ticksExisted & 0xF) == 0) {
                List<BasicEntityShip> slist = world.getEntitiesWithinAABB(BasicEntityShip.class, player.getEntityBoundingBox().expand(8.0, 6.0, 8.0));
                for (BasicEntityShip s : slist) {
                    if (s == null || !s.isEntityAlive() || s.getStateFlag(2) || s.isSitting() || s.isRiding()) continue;
                    if (player.getDistanceSq(s) > 4.0) {
                        s.setStateEmotion(1, 8, true);
                        s.getShipNavigate().tryMoveToEntityLiving(player, 0.75);
                        if (player.getRNG().nextInt(5) == 0) {
                            switch (player.getRNG().nextInt(3)) {
                                case 1: {
                                    s.applyParticleEmotion(9);
                                    break;
                                }
                                case 2: {
                                    s.applyParticleEmotion(30);
                                    break;
                                }
                                default: {
                                    s.applyParticleEmotion(1);
                                }
                            }
                        }
                    }
                    s.getLookHelper().setLookPosition(player.posX, player.posY + 2.0, player.posZ, 50.0f, 50.0f);
                }
            }
        }
    }

    public void addInformation(ItemStack itemstack, List<String> list) {
        if (!itemstack.isEmpty()) {
            int meta = itemstack.getItemDamage();
            String str = I18n.format("gui.shincolle:combatration" + meta);
            Collections.addAll(list, CalcHelper.stringConvNewlineToArray(str));
            list.add(TextFormatting.LIGHT_PURPLE + "+" + this.getMoraleValue(meta) + " " + I18n.format("gui.shincolle:combatration"));
            list.add(TextFormatting.RED + "+" + (int)this.getFoodValue(meta) + "~" + (int)this.getFoodValue(meta) * 2 + " " + I18n.format("item.shincolle:Grudge.name"));
        }
    }
}
