package com.lulan.shincolle.item;

import java.util.Map;

public interface IShipEffectItem {
    Map<Integer, int[]> getEffectOnAttack(int var1);

    int getMissileType(int var1);

    int getMissileMoveType(int var1);

    int getMissileSpeedLevel(int var1);
}
