package com.lulan.shincolle.item;

import com.lulan.shincolle.crafting.EquipCalc;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.reference.Enums;
import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.utility.EnchantHelper;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

public abstract class BasicEquip
extends BasicItem
implements IShipResourceItem {
    protected BasicEquip() {
        this.setMaxStackSize(1);
    }

    public abstract int getEquipTypeIDFromMeta(int var1);

    public int getEquipID(int meta) {
        return this.getEquipTypeIDFromMeta(meta) + meta * 100;
    }

    public int getIconTypes() {
        return 1;
    }

    public int getIconFromDamage() {
        return 0;
    }

    public Enums.EnumEquipEffectSP getSpecialEffect() {
        return Enums.EnumEquipEffectSP.NONE;
    }

    public Enums.EnumEquipEffectSP getSpecialEffect(ItemStack stack) {
        return this.getSpecialEffect();
    }

    public int getItemEnchantability(ItemStack stack) {
        return 9;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void initModel() {
        if (this.getHasSubtypes()) {
            int i;
            ModelResourceLocation[] models = new ModelResourceLocation[this.getIconTypes()];
            for (i = 0; i < this.getIconTypes(); ++i) {
                models[i] = new ModelResourceLocation(this.getRegistryName() + String.valueOf(i), "inventory");
            }
            ModelBakery.registerItemVariants(this, models);
            for (i = 0; i < this.getTypes(); ++i) {
                ModelLoader.setCustomModelResourceLocation(this, i, models[this.getIconFromDamage()]);
            }
        } else {
            ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
        }
    }

    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (!stack.isEmpty()) {
            stack.getItem();
            if (stack.hasTagCompound()) {
                NBTTagCompound nbt = stack.getTagCompound();
                assert nbt != null;
                if (!nbt.hasKey("HideFlags", 99)) {
                    nbt.setInteger("HideFlags", 1);
                }
                int flag;
                flag = Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) ? 0 : 1;
                nbt.setInteger("HideFlags", flag);
            }
            float[] main = Values.EquipAttrsMain.get(((BasicEquip) stack.getItem()).getEquipID(stack.getItemDamage()));
            int[] misc = Values.EquipAttrsMisc.get(((BasicEquip) stack.getItem()).getEquipID(stack.getItemDamage()));
            if (main != null && misc != null) {
                if ((main = EquipCalc.calcEquipStatWithEnchant(misc[0], main, EnchantHelper.calcEnchantEffect(stack)))[0] != 0.0f) {
                    tooltip.add(TextFormatting.RED + String.format("%.1f", Float.valueOf(main[0] * (float) ConfigHandler.scaleShip[0])) + " " + I18n.format("gui.shincolle:hp"));
                }
                if (main[1] != 0.0f) {
                    tooltip.add(TextFormatting.RED + String.format("%.1f", Float.valueOf(main[1] * (float) ConfigHandler.scaleShip[1])) + " " + I18n.format("gui.shincolle:firepower1"));
                }
                if (main[2] != 0.0f) {
                    tooltip.add(TextFormatting.GREEN + String.format("%.1f", Float.valueOf(main[2] * (float) ConfigHandler.scaleShip[1])) + " " + I18n.format("gui.shincolle:torpedo"));
                }
                if (main[3] != 0.0f) {
                    tooltip.add(TextFormatting.RED + String.format("%.1f", Float.valueOf(main[3] * (float) ConfigHandler.scaleShip[1])) + " " + I18n.format("gui.shincolle:airfirepower"));
                }
                if (main[4] != 0.0f) {
                    tooltip.add(TextFormatting.GREEN + String.format("%.1f", Float.valueOf(main[4] * (float) ConfigHandler.scaleShip[1])) + " " + I18n.format("gui.shincolle:airtorpedo"));
                }
                if (main[5] != 0.0f) {
                    tooltip.add(TextFormatting.WHITE + String.format("%.1f", Float.valueOf(main[5] * 100.0f * (float) ConfigHandler.scaleShip[2])) + "% " + I18n.format("gui.shincolle:armor"));
                }
                if (main[6] != 0.0f) {
                    tooltip.add(TextFormatting.WHITE + String.format("%.2f", Float.valueOf(main[6] * (float) ConfigHandler.scaleShip[3])) + " " + I18n.format("gui.shincolle:attackspeed"));
                }
                if (main[7] != 0.0f) {
                    tooltip.add(TextFormatting.GRAY + String.format("%.2f", Float.valueOf(main[7] * (float) ConfigHandler.scaleShip[4])) + " " + I18n.format("gui.shincolle:movespeed"));
                }
                if (main[8] != 0.0f) {
                    tooltip.add(TextFormatting.LIGHT_PURPLE + String.format("%.1f", Float.valueOf(main[8] * (float) ConfigHandler.scaleShip[5])) + " " + I18n.format("gui.shincolle:range"));
                }
                if (main[9] != 0.0f) {
                    tooltip.add(TextFormatting.AQUA + String.format("%.0f", Float.valueOf(main[9] * 100.0f)) + "% " + I18n.format("gui.shincolle:critical"));
                }
                if (main[10] != 0.0f) {
                    tooltip.add(TextFormatting.YELLOW + String.format("%.0f", Float.valueOf(main[10] * 100.0f)) + "% " + I18n.format("gui.shincolle:doublehit"));
                }
                if (main[11] != 0.0f) {
                    tooltip.add(TextFormatting.GOLD + String.format("%.0f", Float.valueOf(main[11] * 100.0f)) + "% " + I18n.format("gui.shincolle:triplehit"));
                }
                if (main[12] != 0.0f) {
                    tooltip.add(TextFormatting.RED + String.format("%.0f", Float.valueOf(main[12] * 100.0f)) + "% " + I18n.format("gui.shincolle:missreduce"));
                }
                if (main[15] != 0.0f) {
                    tooltip.add(TextFormatting.GOLD + String.format("%.0f", Float.valueOf(main[15] * 100.0f)) + "% " + I18n.format("gui.shincolle:dodge"));
                }
                if (main[13] != 0.0f) {
                    tooltip.add(TextFormatting.YELLOW + String.format("%.1f", Float.valueOf(main[13])) + " " + I18n.format("gui.shincolle:antiair"));
                }
                if (main[14] != 0.0f) {
                    tooltip.add(TextFormatting.AQUA + String.format("%.1f", Float.valueOf(main[14])) + " " + I18n.format("gui.shincolle:antiss"));
                }
                if (main[16] != 0.0f) {
                    tooltip.add(TextFormatting.GREEN + I18n.format("gui.shincolle:equip.xp") + " " + String.format("%.0f", Float.valueOf(main[16] * 100.0f)) + "%");
                }
                if (main[17] != 0.0f) {
                    tooltip.add(TextFormatting.DARK_PURPLE + I18n.format("gui.shincolle:equip.grudge") + " " + String.format("%.0f", Float.valueOf(main[17] * 100.0f)) + "%");
                }
                if (main[18] != 0.0f) {
                    tooltip.add(TextFormatting.DARK_AQUA + I18n.format("gui.shincolle:equip.ammo") + " " + String.format("%.0f", Float.valueOf(main[18] * 100.0f)) + "%");
                }
                if (main[19] != 0.0f) {
                    tooltip.add(TextFormatting.DARK_GREEN + I18n.format("gui.shincolle:equip.hpres") + " " + String.format("%.0f", Float.valueOf(main[19] * 100.0f)) + "%");
                }
                if (main[20] != 0.0f) {
                    tooltip.add(TextFormatting.DARK_RED + I18n.format("gui.shincolle:equip.kb") + " " + String.format("%.0f", Float.valueOf(main[20] * 100.0f)) + "%");
                }
                String drawstr = I18n.format("gui.shincolle:equip.enchtype") + " ";
                drawstr = drawstr + (misc[5] == 1.0f ? TextFormatting.RED + I18n.format("gui.shincolle:equip.enchtype1") : (misc[5] == 2.0f ? TextFormatting.AQUA + I18n.format("gui.shincolle:equip.enchtype0") : (misc[5] == 3.0f ? TextFormatting.GRAY + I18n.format("gui.shincolle:equip.enchtype2") : "")));
                drawstr = drawstr + (misc[0] == 1.0f ? "  " + TextFormatting.DARK_RED + I18n.format("gui.shincolle:notforcarrier") : (misc[0] == 3.0f ? "  " + TextFormatting.DARK_AQUA + I18n.format("gui.shincolle:carrieronly") : ""));
                tooltip.add(drawstr);
                if (misc[3] > 400) {
                    tooltip.add(TextFormatting.DARK_RED + I18n.format("tile.shincolle:BlockLargeShipyard.name"));
                } else {
                    tooltip.add(TextFormatting.DARK_RED + I18n.format("tile.shincolle:BlockSmallShipyard.name"));
                }
                String matname;
                switch (misc[4]) {
                    case 1: {
                        matname = I18n.format("item.shincolle:AbyssMetal.name");
                        break;
                    }
                    case 2: {
                        matname = I18n.format("item.shincolle:Ammo.name");
                        break;
                    }
                    case 3: {
                        matname = I18n.format("item.shincolle:AbyssMetal1.name");
                        break;
                    }
                    default: {
                        matname = I18n.format("item.shincolle:Grudge.name");
                    }
                }
                drawstr = TextFormatting.DARK_PURPLE + I18n.format("gui.shincolle:equip.matstype") + TextFormatting.GRAY + " (" + matname + ") " + String.format("%.0f", Float.valueOf(misc[3])) + "  " + TextFormatting.DARK_PURPLE + I18n.format("gui.shincolle:equip.matsrarelevel") + TextFormatting.GRAY + " " + String.format("%.0f", Float.valueOf(misc[2]));
                tooltip.add(drawstr);
            }
        }
    }
}
