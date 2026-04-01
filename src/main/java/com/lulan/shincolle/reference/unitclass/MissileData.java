package com.lulan.shincolle.reference.unitclass;

public class MissileData {
    public int type;
    public int movetype;
    public float vel0;
    public float accY1;
    public float accY2;

    public MissileData() {
        this.resetData();
    }

    public void resetData() {
        this.type = 0;
        this.movetype = -1;
        this.vel0 = 0.5f;
        this.accY1 = 1.04f;
        this.accY2 = 1.04f;
    }
}
