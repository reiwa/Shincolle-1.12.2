package com.lulan.shincolle.tileentity;

public interface ITileFurnace {
    int getPowerConsumed();

    void setPowerConsumed(int var1);

    int getPowerGoal();

    void setPowerGoal(int var1);

    int getPowerRemained();

    void setPowerRemained(int var1);

    int getPowerMax();

    float getFuelMagni();
}
