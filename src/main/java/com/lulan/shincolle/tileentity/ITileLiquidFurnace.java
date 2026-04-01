package com.lulan.shincolle.tileentity;

public interface ITileLiquidFurnace
extends ITileFurnace {
    int getFluidFuelAmount();

    int consumeFluidFuel(int var1);
}
