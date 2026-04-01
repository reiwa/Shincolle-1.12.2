package com.lulan.shincolle.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquipAmmo
        extends BasicEquip
        implements IShipEffectItem {
    private static final String NAME = "EquipAmmo";
    public static final String PID = "PID";
    public static final String PLEVEL = "PLV";
    public static final String PTIME = "PTick";
    public static final String PCHANCE = "PChance";
    public static final String PLIST = "PList";

    public EquipAmmo() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setHasSubtypes(true);
    }

    @Override
    public int getTypes() {
        return 9;
    }

    @Override
    public int getEquipTypeIDFromMeta(int meta) {
        switch (meta) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8: {
                return 29;
            }
            default:
        }
        return 28;
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        switch (this.getEquipTypeIDFromMeta(stack.getMetadata())) {
            case 28: {
                return 12;
            }
            case 29: {
                return 25;
            }
            default:
        }
        return 12;
    }

    @Override
    public int[] getResourceValue(int meta) {
        switch (this.getEquipTypeIDFromMeta(meta)) {
            case 28: {
                return new int[]{itemRand.nextInt(3) + 4, itemRand.nextInt(4) + 7, itemRand.nextInt(5) + 9, itemRand.nextInt(2) + 4};
            }
            case 29: {
                return new int[]{itemRand.nextInt(25) + 35, itemRand.nextInt(30) + 45, itemRand.nextInt(40) + 70, itemRand.nextInt(20) + 40};
            }
            default:
        }
        return new int[]{0, 0, 0, 0};
    }

    @Override
    public Map<Integer, int[]> getEffectOnAttack(int meta) {
        HashMap<Integer, int[]> emap = new HashMap<>();
        switch (meta) {
            case 0: {
                emap.put(19, new int[]{0, 120, 50});
                break;
            }
            case 1: {
                emap.put(19, new int[]{1, 120, 70});
                break;
            }
            case 3: {
                emap.put(9, new int[]{0, 120, 50});
                break;
            }
            case 4: {
                emap.put(20, new int[]{0, 100, 25});
                break;
            }
            case 6: {
                emap.put(25, new int[]{0, 100, 50});
                break;
            }
            default:
        }
        return emap;
    }

    @Override
    public int getMissileType(int meta) {
        switch (meta) {
            case 5: {
                return 5;
            }
            case 8: {
                return 3;
            }
            default:
        }
        return 0;
    }

    @Override
    public int getMissileMoveType(int meta) {
        if(meta == 8){
            return 1;
        }
        return -1;
    }

    @Override
    public int getMissileSpeedLevel(int meta) {
        return 0;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        switch (stack.getMetadata()) {
            case 5: {
                tooltip.add(TextFormatting.YELLOW + I18n.format("gui.shincolle:equip.gravity"));
                break;
            }
            case 7: {
                if (!stack.hasTagCompound()) break;
                NBTTagCompound nbt = stack.getTagCompound();
                NBTTagList nbtlist = nbt.getTagList(PLIST, 10);
                int pid2;
                int plv;
                int ptime;
                int pchance;
                NBTTagCompound nbtX;
                for (int i = 0; i < nbtlist.tagCount(); ++i) {
                    nbtX = nbtlist.getCompoundTagAt(i);
                    pid2 = nbtX.getInteger(PID);
                    Potion pt = Potion.getPotionById(pid2);
                    if (pt == null) continue;
                    String s1 = I18n.format(pt.getName()).trim();
                    plv = nbtX.getInteger(PLEVEL) + 1;
                    ptime = nbtX.getInteger(PTIME) / 20;
                    pchance = nbtX.getInteger(PCHANCE);
                    tooltip.add(I18n.format("gui.shincolle:equip.enchantshell", pchance, s1, plv, ptime));
                }
                break;
            }
            case 8: {
                tooltip.add(TextFormatting.YELLOW + I18n.format("gui.shincolle:equip.cluster"));
                break;
            }
            default:
        }
        Map<Integer, int[]> emap = this.getEffectOnAttack(stack.getMetadata());
        if (emap != null && emap.size() > 0) {
            emap.forEach((pid, pdata) -> {
                Potion pt = Potion.getPotionById(pid);
                if (pt != null) {
                    String s1 = I18n.format(pt.getName()).trim();
                    tooltip.add(I18n.format("gui.shincolle:equip.enchantshell", pdata[2], s1, pdata[0] + 1, pdata[1] / 20));
                }
            });
        }
    }
}
