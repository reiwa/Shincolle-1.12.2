package com.lulan.shincolle.item;

import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.reference.Enums;
import com.lulan.shincolle.utility.EnchantHelper;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class EquipDrum
        extends BasicEquip {
    private static final String NAME = "EquipDrum";

    public EquipDrum() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setHasSubtypes(true);
    }

    @Override
    @SideOnly(value= Side.CLIENT)
    public void initModel() {
        ModelResourceLocation[] models = new ModelResourceLocation[this.getIconTypes()];
        for (int i = 0; i < this.getIconTypes(); ++i) {
            models[i] = new ModelResourceLocation(this.getRegistryName() + String.valueOf(i), "inventory");
        }
        ModelBakery.registerItemVariants(this, models);
        for (int i = 0; i < this.getIconTypes(); ++i) {
            ModelLoader.setCustomModelResourceLocation(this, i, models[this.getIconFromDamage(i)]);
        }
    }

    @Override
    public int getTypes() {
        return 3;
    }

    @Override
    public int getIconTypes() {
        return 3;
    }

    public Enums.EnumEquipEffectSP getSpecialEffect(ItemStack stack) {
        int meta = stack.getItemDamage();
        switch (meta) {
            case 1: {
                return Enums.EnumEquipEffectSP.DRUM_LIQUID;
            }
            case 2: {
                return Enums.EnumEquipEffectSP.DRUM_EU;
            }
            default:
        }
        return Enums.EnumEquipEffectSP.DRUM;
    }

    public int getIconFromDamage(int meta) {
        switch (meta) {
            case 0:
            case 1:
            case 2: {
                return meta;
            }
            default:
        }
        return 0;
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        switch (meta) {
            case 0:
            case 1:
            case 2: {
                return 24;
            }
            default:
        }
        return 0;
    }

    @Override
    public int[] getResourceValue(int meta) {
        if(this.getEquipTypeIDFromMeta(meta) == 24){
            return new int[]{itemRand.nextInt(4) + 5, itemRand.nextInt(5) + 9, itemRand.nextInt(4) + 4, itemRand.nextInt(3) + 3};
        }
        return new int[]{0, 0, 0, 0};
    }

    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        switch (stack.getItemDamage()) {
            case 1: {
                tooltip.add(TextFormatting.GRAY + I18n.format("gui.shincolle:drum1"));
                int num = EnchantHelper.calcEnchantNumber(stack) * ConfigHandler.drumLiquid[1] + ConfigHandler.drumLiquid[0];
                if (num <= 0) break;
                tooltip.add(TextFormatting.AQUA + I18n.format("gui.shincolle:equip.rateliq") + " " + num + " mB/t");
                break;
            }
            case 2: {
                if (CommonProxy.activeIC2) {
                    tooltip.add(TextFormatting.GRAY + I18n.format("gui.shincolle:drum2a"));
                } else {
                    tooltip.add(TextFormatting.GRAY + I18n.format("gui.shincolle:drum2b"));
                }
                int num = EnchantHelper.calcEnchantNumber(stack) * ConfigHandler.drumEU[1] + ConfigHandler.drumEU[0];
                if (num <= 0) break;
                tooltip.add(TextFormatting.YELLOW + I18n.format("gui.shincolle:equip.rateeu") + " " + num + " EU/t (NYI)");
                break;
            }
            default: {
                tooltip.add(TextFormatting.GRAY + I18n.format("gui.shincolle:drum"));
            }
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
