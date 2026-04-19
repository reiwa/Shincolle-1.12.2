package com.lulan.shincolle.crafting;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.item.BasicEquip;
import com.lulan.shincolle.item.IShipEffectItem;
import com.lulan.shincolle.reference.Enums;
import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.reference.unitclass.Attrs;
import com.lulan.shincolle.utility.BuffHelper;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.EnchantHelper;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

import java.util.*;
import com.lulan.shincolle.capability.CapaShipInventory;
import java.util.function.Function;
import java.util.stream.IntStream;

public class EquipCalc {
    private static final Random rand = new Random();
    private static final List<int[]> EquipSmall = new ArrayList<>();
    private static final List<int[]> EquipLarge = new ArrayList<>();
    private static final Map<Integer, EquipCreationData> EQUIP_MAP = new HashMap<>();

    private EquipCalc() {}

    private static class EquipCreationData {
        final Item item;
        final int enchType;
        EquipCreationData(Item item, int enchType) {
            this.item = item;
            this.enchType = enchType;
        }
    }

    public static void updateAttrsEquip(BasicEntityShip ship) {
        updateAttrsEquipCore(ship, i -> ship.getCapaShipInventory().getStackInSlot(i));
    }

    public static void updateAttrsEquipOfMorph(BasicEntityShip ship) {
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(ship.getMorphHost());
        updateAttrsEquipCore(ship, capa != null ? capa::getStackInSlot : null);
    }

    private static void updateAttrsEquipCore(BasicEntityShip ship, Function<Integer, ItemStack> stackGetter) {
        Attrs attrs = ship.getAttrs();
        attrs.resetAttrsEquip();
        ship.resetMissileData();
        ship.calcShipAttributesAddEffect();
        for (int i = 36; i <= 39; ++i) ship.setStateMinor(i, 0);
        if (stackGetter != null) {
            for (int i = 0; i < 6; ++i) {
                EquipCalc.calcEquipAttrs(ship, stackGetter.apply(i));
            }
        }
        int maxPages = CapaShipInventory.SLOT_PAGES - 1;
        if (ship.getStateMinor(36) > maxPages) {
            ship.setStateMinor(36, maxPages);
        }
        float[] equip = attrs.getAttrsEquip();
        equip[0] *= ConfigHandler.scaleShip[0];
        equip[1] *= ConfigHandler.scaleShip[1];
        equip[2] *= ConfigHandler.scaleShip[1];
        equip[3] *= ConfigHandler.scaleShip[1];
        equip[4] *= ConfigHandler.scaleShip[1];
        equip[5] *= ConfigHandler.scaleShip[2];
        equip[6] *= ConfigHandler.scaleShip[3];
        equip[7] *= ConfigHandler.scaleShip[4];
        equip[8] *= ConfigHandler.scaleShip[5];
    }

    public static void calcEquipAttrs(BasicEntityShip ship, ItemStack equip) {
        Attrs attrs = ship.getAttrs();
        float[] attrsEquip = attrs.getAttrsEquip();
        float[] getEquip = EquipCalc.getEquipAttrsMain(ship, equip);
        int[] getMisc = EquipCalc.getEquipAttrsMisc(equip);
        for (int i = 0; i < 21; ++i) {
            attrsEquip[i] += getEquip[i];
        }
        if (getMisc.length > 0) {
            ship.setStateMinor(36, ship.getStateMinor(36) + getMisc[0]);
            ship.setStateMinor(37, ship.getStateMinor(37) + getMisc[1]);
            ship.setStateMinor(38, ship.getStateMinor(38) + getMisc[2]);
            ship.setStateMinor(39, ship.getStateMinor(39) + getMisc[3]);
        }
        if (equip != null && equip.getItem() instanceof IShipEffectItem) {
            int meta = equip.getMetadata();
            IShipEffectItem eitem = (IShipEffectItem) equip.getItem();
            if (meta == 7 && eitem == ModItems.EquipAmmo) {
                BuffHelper.addEffectToAttackEffectMapFromStack(ship, equip);
            }
            Map<Integer, int[]> emap = eitem.getEffectOnAttack(meta);
            if (emap != null && !emap.isEmpty()) {
                BuffHelper.addEffectToAttackEffectMap(ship, emap);
            }
            int type;
            if ((type = eitem.getMissileType(meta)) > 0) {
                for (int i = 0; i < 5; i++) ship.getMissileData(i).type = type;
            }
            if ((type = eitem.getMissileMoveType(meta)) >= 0) {
                for (int i = 0; i < 5; i++) ship.getMissileData(i).movetype = type;
            }
            if ((type = eitem.getMissileSpeedLevel(meta)) != 0) {
                float addSpeed = type * 0.025f;
                float addAccel = type * 0.004f;
                for (int i = 0; i < 5; i++) {
                    ship.getMissileData(i).vel0 += addSpeed;
                    ship.getMissileData(i).accY1 += addAccel;
                    ship.getMissileData(i).accY2 = ship.getMissileData(i).accY1;
                }
            }
        }
    }

    public static float[] getEquipAttrsMain(BasicEntityShip entity, ItemStack stack) {
        if (entity != null && !stack.isEmpty() && stack.getItem() instanceof BasicEquip) {
            int equipId = ((BasicEquip) stack.getItem()).getEquipID(stack.getItemDamage());
            float[] itemRaw = Values.EquipAttrsMain.get(equipId);
            int[] itemMisc = Values.EquipAttrsMisc.get(equipId);
            if (itemRaw != null && itemMisc != null) {
                if (entity.getEquipType() != 2 && itemMisc[0] != 2 && entity.getEquipType() != itemMisc[0]) {
                    return Attrs.getResetZeroValue();
                }
                float[] itemEnch = EnchantHelper.calcEnchantEffect(stack);
                return EquipCalc.calcEquipStatWithEnchant(itemMisc[0], itemRaw, itemEnch);
            }
        }
        return Attrs.getResetZeroValue();
    }

    public static int[] getEquipAttrsMisc(ItemStack stack) {
        if (!stack.isEmpty() && stack.getItem() instanceof BasicEquip) {
            int[] itemStat = new int[]{0, 0, 0, 0};
            Enums.EnumEquipEffectSP effect = ((BasicEquip) stack.getItem()).getSpecialEffect(stack);
            switch (effect) {
                case DRUM:
                case DRUM_LIQUID:
                case DRUM_EU:
                    itemStat[0] = 1;
                    break;
                case COMPASS:
                    itemStat[1] = 1;
                    break;
                case FLARE:
                    itemStat[2] = 1;
                    break;
                case SEARCHLIGHT:
                    itemStat[3] = 1;
                    break;
                default:
                    break;
            }
            return itemStat;
        }
        return new int[0];
    }

    public static float[] calcEquipStatWithEnchant(int equipType, float[] raw, float[] enchant) {
        float[] newstat = new float[21];
        float modTemp;
        newstat[0] = raw[0] * (1.0f + enchant[0]);
        modTemp = equipType == 1 ? 1.0f + enchant[1] : 1.0f;
        newstat[1] = raw[1] * modTemp;
        newstat[2] = raw[2] * modTemp;
        newstat[3] = raw[3] * modTemp;
        newstat[4] = raw[4] * modTemp;
        modTemp = equipType == 2 ? 1.0f + enchant[5] : 1.0f;
        newstat[5] = raw[5] * modTemp;
        newstat[6] = raw[6] * (1.0f + enchant[6]);
        modTemp = raw[7] < 0.0f ? Math.max(0.0f, 1.0f - enchant[7]) : 1.0f + enchant[7];
        newstat[7] = raw[7] * modTemp;
        for (int i = 8; i <= 14; ++i) {
            newstat[i] = raw[i] * (1.0f + enchant[i]);
        }
        modTemp = raw[15] < 0.0f ? Math.max(0.0f, 1.0f - enchant[15]) : 1.0f + enchant[15];
        newstat[15] = raw[15] * modTemp;
        newstat[16] = raw[16] + (equipType == 1 ? enchant[16] : 0.0f);
        newstat[17] = raw[17] + (equipType != 1 ? enchant[17] : 0.0f);
        newstat[18] = raw[18] + (equipType == 1 ? enchant[18] : 0.0f);
        newstat[19] = raw[19] + (equipType != 1 ? enchant[19] : 0.0f);
        newstat[20] = raw[20] + (equipType != 1 ? enchant[20] : 0.0f);
        return newstat;
    }

    public static int rollEquipType(int type, int[] matAmount) {
        List<int[]> eqlistOrg = (type == 0) ? EquipSmall : EquipLarge;
        float te = (type == 0) ? 256.0f : 4000.0f;
        int totalMats = matAmount[0] + matAmount[1] + matAmount[2] + matAmount[3];
        Map<Integer, Float> probList = new HashMap<>();
        for (int[] i : eqlistOrg) {
            int meanNew = (i[2] >= 0 && i[2] <= 3) ? i[1] - matAmount[i[2]] : i[1];
            int meanDist = MathHelper.abs(totalMats - meanNew);
            if (type == 0) {
                meanDist = (int) (meanDist * 15.625f);
            }
            float prob = CalcHelper.getNormDist(meanDist);
            probList.put(i[0], prob);
            LogHelper.debug("DEBUG: roll equip type: prob list: ID " + i[0] + " MEAN(ORG) " + i[1] + " MEAN(NEW) " + meanNew + " MEAN(P) " + meanNew / te + " MD " + meanDist + " PR " + prob);
        }
        float totalProb = 0.0f;
        for (float f : probList.values()) {
            totalProb += f;
        }
        float random = rand.nextFloat() * totalProb;
        float sumProb = 0.0125f;
        for (Map.Entry<Integer, Float> entry : probList.entrySet()) {
            LogHelper.debug("DEBUG: roll equip type: random: " + random + " sum.pr " + (sumProb + entry.getValue()) + " total.pr " + totalProb);
            sumProb += entry.getValue();
            if (sumProb > random) {
                int rollresult = entry.getKey();
                LogHelper.debug("DEBUG: roll item: get type:" + rollresult);
                return rollresult;
            }
        }
        return -1;
    }

    public static ItemStack rollEquipsOfTheType(int type, int totalMats, int buildType) {
        if (type == -1) return ItemStack.EMPTY;
        Map<Integer, Float> equipList = new HashMap<>();
        for (Map.Entry<Integer, int[]> entry : Values.EquipAttrsMisc.entrySet()) {
            int eid = entry.getKey();
            int[] val = entry.getValue();
            if (val[1] == type) {
                int n = (buildType == 0) ? (int) (totalMats * 15.625f) : totalMats;
                int meanDist = MathHelper.abs(n - val[2]);
                equipList.put(eid, CalcHelper.getNormDist(meanDist));
            }
        }
        float totalProb = 0.0f;
        for (Float prob : equipList.values()) totalProb += prob;
        float random = rand.nextFloat() * totalProb;
        float sumProb = 0.0f;
        int rollResult = -1;
        for (Map.Entry<Integer, Float> entry : equipList.entrySet()) {
            sumProb += entry.getValue();
            if (sumProb > random) {
                rollResult = entry.getKey();
                break;
            }
        }
        int enhanceLevel = 0;
        if (buildType == 0) {
            if (totalMats > 220) enhanceLevel = 3;
            else if (totalMats > 200) enhanceLevel = 2;
            else if (totalMats > 180) enhanceLevel = 1;
        } else {
            if (totalMats > 3500) enhanceLevel = 3;
            else if (totalMats > 3000) enhanceLevel = 2;
            else if (totalMats > 2000) enhanceLevel = 1;
        }
        return EquipCalc.getItemStackFromId(rollResult, enhanceLevel);
    }

    private static ItemStack getItemStackFromId(int itemID, int enchLv) {
        if (itemID < 0) return ItemStack.EMPTY;
        int itemType = itemID % 100;
        int itemSubType = itemID / 100;
        EquipCreationData data = EQUIP_MAP.get(itemType);
        if (data == null) return ItemStack.EMPTY;
        ItemStack item = new ItemStack(data.item, 1, itemSubType);
        if (enchLv > 0) {
            EnchantHelper.applyRandomEnchantToEquip(item, data.enchType, enchLv);
        }
        LogHelper.debug("DEBUG: equip calc: get itemstack: " + itemType + " " + itemSubType + " " + item);
        return item;
    }

    static {
        EquipSmall.add(new int[]{18, 80, 1});
        EquipSmall.add(new int[]{26, 80, 2});
        EquipSmall.add(new int[]{27, 80, 0});
        EquipSmall.add(new int[]{25, 90, 0});
        EquipSmall.add(new int[]{20, 100, 2});
        EquipSmall.add(new int[]{24, 120, 1});
        EquipSmall.add(new int[]{28, 120, 2});
        EquipSmall.add(new int[]{0, 128, 2});
        EquipSmall.add(new int[]{4, 160, 2});
        EquipSmall.add(new int[]{14, 200, 0});
        EquipSmall.add(new int[]{12, 256, 3});
        EquipSmall.add(new int[]{1, 320, 2});
        EquipLarge.add(new int[]{19, 500, 1});
        EquipLarge.add(new int[]{21, 800, 2});
        EquipLarge.add(new int[]{29, 1000, 2});
        EquipLarge.add(new int[]{13, 1000, 3});
        EquipLarge.add(new int[]{5, 1200, 2});
        EquipLarge.add(new int[]{16, 1400, 0});
        EquipLarge.add(new int[]{2, 1600, 2});
        EquipLarge.add(new int[]{15, 2000, 0});
        EquipLarge.add(new int[]{6, 2400, 3});
        EquipLarge.add(new int[]{8, 2400, 3});
        EquipLarge.add(new int[]{10, 2400, 3});
        EquipLarge.add(new int[]{22, 2800, 3});
        EquipLarge.add(new int[]{17, 3200, 0});
        EquipLarge.add(new int[]{7, 3800, 3});
        EquipLarge.add(new int[]{9, 3800, 3});
        EquipLarge.add(new int[]{11, 3800, 3});
        EquipLarge.add(new int[]{3, 4400, 2});
        EquipLarge.add(new int[]{23, 5000, 3});

        IntStream.of(0, 1, 2, 3).forEach(id -> EQUIP_MAP.put(id, new EquipCreationData(ModItems.EquipCannon, 0)));
        IntStream.of(20, 21).forEach(id -> EQUIP_MAP.put(id, new EquipCreationData(ModItems.EquipMachinegun, 0)));
        IntStream.of(4, 5).forEach(id -> EQUIP_MAP.put(id, new EquipCreationData(ModItems.EquipTorpedo, 0)));
        IntStream.rangeClosed(6, 13).forEach(id -> EQUIP_MAP.put(id, new EquipCreationData(ModItems.EquipAirplane, 0)));
        IntStream.of(14, 15).forEach(id -> EQUIP_MAP.put(id, new EquipCreationData(ModItems.EquipRadar, 2)));
        IntStream.of(16, 17).forEach(id -> EQUIP_MAP.put(id, new EquipCreationData(ModItems.EquipTurbine, 2)));
        IntStream.of(18, 19).forEach(id -> EQUIP_MAP.put(id, new EquipCreationData(ModItems.EquipArmor, 1)));
        IntStream.of(22, 23).forEach(id -> EQUIP_MAP.put(id, new EquipCreationData(ModItems.EquipCatapult, 2)));
        EQUIP_MAP.put(24, new EquipCreationData(ModItems.EquipDrum, 2));
        EQUIP_MAP.put(25, new EquipCreationData(ModItems.EquipCompass, 2));
        EQUIP_MAP.put(26, new EquipCreationData(ModItems.EquipFlare, 2));
        EQUIP_MAP.put(27, new EquipCreationData(ModItems.EquipSearchlight, 2));
        IntStream.of(28, 29).forEach(id -> EQUIP_MAP.put(id, new EquipCreationData(ModItems.EquipAmmo, 0)));
    }
}