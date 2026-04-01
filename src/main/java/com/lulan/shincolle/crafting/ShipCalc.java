package com.lulan.shincolle.crafting;

import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModBlocks;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

import java.util.*;

public class ShipCalc {
    private static final Random rand = new Random();
    private static final List<int[]> EquipSmall = new ArrayList<>();
    private static final List<int[]> EquipLarge = new ArrayList<>();

    private ShipCalc() {}

    public static int rollShipType(ItemStack item) {
        int[] material = new int[4];
        int totalMats = 0;
        if (item.getItemDamage() > 1) {
            return item.getItemDamage() - 2;
        }
        if (item.hasTagCompound()) {
            material[0] = item.getTagCompound().getInteger("Grudge");
            material[1] = item.getTagCompound().getInteger("Abyssium");
            material[2] = item.getTagCompound().getInteger("Ammo");
            material[3] = item.getTagCompound().getInteger("Polymetal");
            totalMats = material[0] + material[1] + material[2] + material[3];
        }
        List<int[]> shiplistOrg;
        float te = 4000.0f;
        if (item.getItemDamage() == 0) {
            shiplistOrg = EquipSmall;
            te = 256.0f;
        } else {
            shiplistOrg = EquipLarge;
        }
        HashMap<Integer, Float> probList = new HashMap<>();
        int meanNew;
        int meanDist;
        float prob;
        for (int[] i : shiplistOrg) {
            meanNew = i[2] >= 0 && i[2] <= 3 ? i[1] - material[i[2]] : i[1];
            meanDist = MathHelper.abs(totalMats - meanNew);
            if (item.getItemDamage() == 0) {
                meanDist = (int)(meanDist * 15.625f);
            }
            prob = CalcHelper.getNormDist(meanDist);
            probList.put(i[0], Float.valueOf(prob));
            LogHelper.debug("DEBUG: roll ship type: prob list: ID " + i[0] + " MEAN(ORG) " + i[1] + " MEAN(NEW) " + meanNew + " MEAN(P) " + meanNew / te + " MD " + meanDist + " PR " + prob);
        }
        float random = rand.nextFloat();
        float totalProb = 0.0f;
        float sumProb = 0.0125f;
        int rollresult = -1;
        for (Map.Entry<Integer, Float> entry : probList.entrySet()) {
            totalProb += (entry.getValue()).floatValue();
        }
        random *= totalProb;
        for (Map.Entry<Integer, Float> entry : probList.entrySet()) {
            LogHelper.debug("DEBUG: roll ship type: random: " + random + " sum.pr " + (sumProb += (entry.getValue()).floatValue()) + " total.pr " + totalProb);
            if (sumProb <= random) continue;
            rollresult = entry.getKey();
            LogHelper.debug("DEBUG: roll ship type: get ship:" + rollresult);
            break;
        }
        return rollresult;
    }

    public static String getEntityToSpawnName(int type) {
        switch (type) {
            case 0: {
                return "shincolle:EntityDestroyerI";
            }
            case 1: {
                return "shincolle:EntityDestroyerRo";
            }
            case 2: {
                return "shincolle:EntityDestroyerHa";
            }
            case 3: {
                return "shincolle:EntityDestroyerNi";
            }
            case 9: {
                return "shincolle:EntityHeavyCruiserRi";
            }
            case 10: {
                return "shincolle:EntityHeavyCruiserNe";
            }
            case 12: {
                return "shincolle:EntityCarrierWo";
            }
            case 13: {
                return "shincolle:EntityBattleshipRu";
            }
            case 14: {
                return "shincolle:EntityBattleshipTa";
            }
            case 15: {
                return "shincolle:EntityBattleshipRe";
            }
            case 16: {
                return "shincolle:EntityTransportWa";
            }
            case 17: {
                return "shincolle:EntitySubmKa";
            }
            case 18: {
                return "shincolle:EntitySubmYo";
            }
            case 19: {
                return "shincolle:EntitySubmSo";
            }
            case 21: {
                return "shincolle:EntityAirfieldHime";
            }
            case 20: {
                return "shincolle:EntityCarrierHime";
            }
            case 26: {
                return "shincolle:EntityBattleshipHime";
            }
            case 27: {
                return "shincolle:EntityDestroyerHime";
            }
            case 28: {
                return "shincolle:EntityHarbourHime";
            }
            case 29: {
                return "shincolle:EntityIsolatedHime";
            }
            case 30: {
                return "shincolle:EntityMidwayHime";
            }
            case 31: {
                return "shincolle:EntityNorthernHime";
            }
            case 44: {
                return "shincolle:EntitySubmHime";
            }
            case 72: {
                return "shincolle:EntitySubmNewHime";
            }
            case 33: {
                return "shincolle:EntityCarrierWD";
            }
            case 36: {
                return "shincolle:EntityDestroyerShimakaze";
            }
            case 2036: {
                return "shincolle:EntityDestroyerShimakazeMob";
            }
            case 60: {
                return "shincolle:EntityBattleshipKongou";
            }
            case 2060: {
                return "shincolle:EntityBattleshipKongouMob";
            }
            case 61: {
                return "shincolle:EntityBattleshipHiei";
            }
            case 2061: {
                return "shincolle:EntityBattleshipHieiMob";
            }
            case 62: {
                return "shincolle:EntityBattleshipHaruna";
            }
            case 2062: {
                return "shincolle:EntityBattleshipHarunaMob";
            }
            case 63: {
                return "shincolle:EntityBattleshipKirishima";
            }
            case 2063: {
                return "shincolle:EntityBattleshipKirishimaMob";
            }
            case 37: {
                return "shincolle:EntityBattleshipNGT";
            }
            case 2037: {
                return "shincolle:EntityBattleshipNGTMob";
            }
            case 46: {
                return "shincolle:EntityBattleshipYMT";
            }
            case 2046: {
                return "shincolle:EntityBattleshipYMTMob";
            }
            case 38: {
                return "shincolle:EntitySubmU511";
            }
            case 2038: {
                return "shincolle:EntitySubmU511Mob";
            }
            case 39: {
                return "shincolle:EntitySubmRo500";
            }
            case 2039: {
                return "shincolle:EntitySubmRo500Mob";
            }
            case 47: {
                return "shincolle:EntityCarrierKaga";
            }
            case 2047: {
                return "shincolle:EntityCarrierKagaMob";
            }
            case 48: {
                return "shincolle:EntityCarrierAkagi";
            }
            case 2048: {
                return "shincolle:EntityCarrierAkagiMob";
            }
            case 51: {
                return "shincolle:EntityDestroyerAkatsuki";
            }
            case 2051: {
                return "shincolle:EntityDestroyerAkatsukiMob";
            }
            case 52: {
                return "shincolle:EntityDestroyerHibiki";
            }
            case 2052: {
                return "shincolle:EntityDestroyerHibikiMob";
            }
            case 53: {
                return "shincolle:EntityDestroyerIkazuchi";
            }
            case 2053: {
                return "shincolle:EntityDestroyerIkazuchiMob";
            }
            case 54: {
                return "shincolle:EntityDestroyerInazuma";
            }
            case 2054: {
                return "shincolle:EntityDestroyerInazumaMob";
            }
            case 56: {
                return "shincolle:EntityCruiserTenryuu";
            }
            case 2056: {
                return "shincolle:EntityCruiserTenryuuMob";
            }
            case 57: {
                return "shincolle:EntityCruiserTatsuta";
            }
            case 2057: {
                return "shincolle:EntityCruiserTatsutaMob";
            }
            case 58: {
                return "shincolle:EntityCruiserAtago";
            }
            case 2058: {
                return "shincolle:EntityCruiserAtagoMob";
            }
            case 59: {
                return "shincolle:EntityCruiserTakao";
            }
            case 2059: {
                return "shincolle:EntityCruiserTakaoMob";
            }
            case 49: {
                return "shincolle:EntityCAHime";
            }
            default:
        }
        return "shincolle:EntityDestroyerI";
    }

    public static String getRandomMobToSpawnName() {
        int ran1 = rand.nextInt(100);
        if (ran1 > 75) {
            switch (rand.nextInt(3)) {
                case 1: {
                    return ShipCalc.getEntityToSpawnName(2046);
                }
                case 2: {
                    switch (rand.nextInt(4)) {
                        case 1: {
                            return ShipCalc.getEntityToSpawnName(2061);
                        }
                        case 2: {
                            return ShipCalc.getEntityToSpawnName(2062);
                        }
                        case 3: {
                            return ShipCalc.getEntityToSpawnName(2063);
                        }
                        default:
                    }
                    return ShipCalc.getEntityToSpawnName(2060);
                }
                default:
            }
            return ShipCalc.getEntityToSpawnName(2037);
        }
        if (ran1 > 45) {
            switch (rand.nextInt(3)) {
                case 1: 
                case 2: {
                    switch (rand.nextInt(4)) {
                        case 1: {
                            return ShipCalc.getEntityToSpawnName(2056);
                        }
                        case 2: {
                            return ShipCalc.getEntityToSpawnName(2057);
                        }
                        case 3: {
                            return ShipCalc.getEntityToSpawnName(2058);
                        }
                        default:
                    }
                    return ShipCalc.getEntityToSpawnName(2059);
                }
                default:
            }
            if(rand.nextInt(2) == 1){
                return ShipCalc.getEntityToSpawnName(2047);
            }
            return ShipCalc.getEntityToSpawnName(2048);
        }
        switch (rand.nextInt(7)) {
            case 1: {
                return ShipCalc.getEntityToSpawnName(2052);
            }
            case 2: {
                return ShipCalc.getEntityToSpawnName(2053);
            }
            case 3: {
                return ShipCalc.getEntityToSpawnName(2054);
            }
            case 4: {
                return ShipCalc.getEntityToSpawnName(2036);
            }
            case 5: {
                return ShipCalc.getEntityToSpawnName(2038);
            }
            case 6: {
                return ShipCalc.getEntityToSpawnName(2039);
            }
            default:
        }
        return ShipCalc.getEntityToSpawnName(2051);
    }

    public static ItemStack[] getKaitaiItems(int shipID) {
        ItemStack[] amount = new ItemStack[4];
        switch (shipID) {
            case -2: {
                amount[0] = new ItemStack(ModItems.Grudge, 10 + rand.nextInt(8));
                amount[1] = new ItemStack(ModItems.AbyssMetal, 10 + rand.nextInt(8), 0);
                amount[2] = new ItemStack(ModItems.Ammo, 10 + rand.nextInt(8), 0);
                amount[3] = new ItemStack(ModItems.AbyssMetal, 10 + rand.nextInt(8), 1);
                break;
            }
            case -1: {
                amount[0] = new ItemStack(ModItems.Grudge, 90 + rand.nextInt(8));
                amount[1] = new ItemStack(ModItems.AbyssMetal, 90 + rand.nextInt(8), 0);
                amount[2] = new ItemStack(ModItems.Ammo, 90 + rand.nextInt(8), 0);
                amount[3] = new ItemStack(ModItems.AbyssMetal, 90 + rand.nextInt(8), 1);
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 16: 
            case 17: 
            case 18: 
            case 19: {
                amount[0] = new ItemStack(ModItems.Grudge, 12 + rand.nextInt(8));
                amount[1] = new ItemStack(ModItems.AbyssMetal, 12 + rand.nextInt(8), 0);
                amount[2] = new ItemStack(ModItems.Ammo, 12 + rand.nextInt(8), 0);
                amount[3] = new ItemStack(ModItems.AbyssMetal, 12 + rand.nextInt(8), 1);
                break;
            }
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 40: 
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: 
            case 49: 
            case 50: 
            case 72: {
                if (ConfigHandler.consumptionLevel == 0) {
                    amount[0] = new ItemStack(ModBlocks.BlockGrudge, 1);
                    amount[1] = new ItemStack(ModBlocks.BlockAbyssium, 1);
                    amount[2] = new ItemStack(ModItems.Ammo, 1, 1);
                    amount[3] = new ItemStack(ModBlocks.BlockPolymetal, 1);
                    break;
                }
                amount[0] = new ItemStack(ModBlocks.BlockGrudge, 10 + rand.nextInt(3));
                amount[1] = new ItemStack(ModBlocks.BlockAbyssium, 10 + rand.nextInt(3));
                amount[2] = new ItemStack(ModItems.Ammo, 10 + rand.nextInt(3), 1);
                amount[3] = new ItemStack(ModBlocks.BlockPolymetal, 10 + rand.nextInt(3));
                break;
            }
            case 36: 
            case 38: 
            case 39: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: {
                amount[0] = new ItemStack(ModItems.Grudge, ConfigHandler.kaitaiAmountSmall + rand.nextInt((int)(ConfigHandler.kaitaiAmountSmall * 0.25f) + 1));
                amount[1] = new ItemStack(ModItems.AbyssMetal, ConfigHandler.kaitaiAmountSmall + rand.nextInt((int)(ConfigHandler.kaitaiAmountSmall * 0.25f) + 1), 0);
                amount[2] = new ItemStack(ModItems.Ammo, ConfigHandler.kaitaiAmountSmall + rand.nextInt((int)(ConfigHandler.kaitaiAmountSmall * 0.25f) + 1), 0);
                amount[3] = new ItemStack(ModItems.AbyssMetal, ConfigHandler.kaitaiAmountSmall + rand.nextInt((int)(ConfigHandler.kaitaiAmountSmall * 0.25f) + 1), 1);
                break;
            }
            case 56: 
            case 57: 
            case 58: 
            case 59: {
                amount[0] = new ItemStack(ModBlocks.BlockGrudge, ConfigHandler.kaitaiAmountLarge + rand.nextInt((int)(ConfigHandler.kaitaiAmountLarge * 0.25f) + 1));
                amount[1] = new ItemStack(ModBlocks.BlockAbyssium, ConfigHandler.kaitaiAmountLarge + rand.nextInt((int)(ConfigHandler.kaitaiAmountLarge * 0.25f) + 1));
                amount[2] = new ItemStack(ModItems.Ammo, ConfigHandler.kaitaiAmountLarge + rand.nextInt((int)(ConfigHandler.kaitaiAmountLarge * 0.25f) + 1), 1);
                amount[3] = new ItemStack(ModBlocks.BlockPolymetal, ConfigHandler.kaitaiAmountLarge + rand.nextInt((int)(ConfigHandler.kaitaiAmountLarge * 0.25f) + 1));
                break;
            }
            case 37: 
            case 46: 
            case 47: 
            case 48: 
            case 60: 
            case 61: 
            case 62: 
            case 63: {
                amount[0] = new ItemStack(ModBlocks.BlockGrudge, ConfigHandler.kaitaiAmountLarge + rand.nextInt(ConfigHandler.kaitaiAmountLarge + 1));
                amount[1] = new ItemStack(ModBlocks.BlockAbyssium, ConfigHandler.kaitaiAmountLarge + rand.nextInt(ConfigHandler.kaitaiAmountLarge + 1));
                amount[2] = new ItemStack(ModItems.Ammo, ConfigHandler.kaitaiAmountLarge + rand.nextInt(ConfigHandler.kaitaiAmountLarge + 1), 1);
                amount[3] = new ItemStack(ModBlocks.BlockPolymetal, ConfigHandler.kaitaiAmountLarge + rand.nextInt(ConfigHandler.kaitaiAmountLarge + 1));
                break;
            }
            default:
        }
        return amount;
    }

    static {
        EquipSmall.add(new int[]{0, 80, 0});
        EquipSmall.add(new int[]{1, 90, 0});
        EquipSmall.add(new int[]{2, 100, 0});
        EquipSmall.add(new int[]{3, 110, 0});
        EquipSmall.add(new int[]{16, 120, 1});
        EquipSmall.add(new int[]{17, 140, 2});
        EquipSmall.add(new int[]{18, 160, 2});
        EquipSmall.add(new int[]{19, 180, 2});
        EquipSmall.add(new int[]{9, 200, 2});
        EquipSmall.add(new int[]{10, 256, 2});
        EquipLarge.add(new int[]{27, 500, 0});
        EquipLarge.add(new int[]{12, 650, 3});
        EquipLarge.add(new int[]{14, 800, 2});
        EquipLarge.add(new int[]{13, 800, 2});
        EquipLarge.add(new int[]{49, 2000, 2});
        EquipLarge.add(new int[]{31, 2600, 1});
        EquipLarge.add(new int[]{72, 2600, 2});
        EquipLarge.add(new int[]{29, 2700, 1});
        EquipLarge.add(new int[]{28, 2800, 1});
        EquipLarge.add(new int[]{21, 3000, 1});
        EquipLarge.add(new int[]{20, 3000, 3});
        EquipLarge.add(new int[]{44, 3500, 2});
        EquipLarge.add(new int[]{15, 3800, 2});
        EquipLarge.add(new int[]{26, 4600, 2});
        EquipLarge.add(new int[]{30, 4800, 1});
        EquipLarge.add(new int[]{33, 5000, 3});
    }
}
