package com.lulan.shincolle.reference.unitclass;

import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.reference.Values;

import java.util.Arrays;
import java.util.Random;

public class Attrs {
    protected byte[] AttrsBonus;
    protected float[] AttrsType;
    protected float[] AttrsRaw;
    protected float[] AttrsBuffed;
    protected float[] AttrsEquip;
    protected float[] AttrsPotion;

    public Attrs() {
        this.initValue();
        this.initAttrsType(0);
    }

    public Attrs(int shipClass) {
        this.initValue();
        this.initAttrsType(shipClass);
    }

    public void initValue() {
        this.AttrsBonus = new byte[6];
        this.AttrsType = new float[6];
        this.resetAttrsRaw();
        this.resetAttrsEquip();
        this.resetAttrsPotion();
        this.resetAttrsBuffed();
    }

    public void initAttrsType(int shipClass) {
        if (!Values.ShipAttrMap.containsKey(shipClass)) {
            shipClass = 0;
        }
        float[] getStat = Arrays.copyOf(Values.ShipAttrMap.get(shipClass), 21);
        this.AttrsType[0] = getStat[6];
        this.AttrsType[1] = getStat[7];
        this.AttrsType[2] = getStat[8];
        this.AttrsType[3] = getStat[9];
        this.AttrsType[4] = getStat[10];
        this.AttrsType[5] = getStat[11];
    }

    public void checkAttrsLimit() {
        Attrs.checkAttrsLimit(this.AttrsBuffed);
    }

    public static void checkAttrsLimit(float[] data) {
        int i;
        for (i = 0; i < 21; ++i) {
            if (ConfigHandler.limitShipAttrs[i] < 0.0 || data[i] <= ConfigHandler.limitShipAttrs[i]) continue;
            data[i] = (float)ConfigHandler.limitShipAttrs[i];
        }
        for (i = 0; i < data.length; ++i) {
            if (data[i] >= 0.0f) continue;
            data[i] = 0.0f;
        }
        if (data[0] < 1.0f) {
            data[0] = 1.0f;
        }
        if (data[1] < 1.0f) {
            data[1] = 1.0f;
        }
        if (data[2] < 1.0f) {
            data[2] = 1.0f;
        }
        if (data[3] < 1.0f) {
            data[3] = 1.0f;
        }
        if (data[4] < 1.0f) {
            data[4] = 1.0f;
        }
        if (data[8] < 1.0f) {
            data[8] = 1.0f;
        }
        if (data[6] < 0.2f) {
            data[6] = 0.2f;
        }
    }

    public void copyRaw2Buffed() {
        System.arraycopy(this.AttrsRaw, 0, this.AttrsBuffed, 0, 21);
    }

    public static float[] getResetRawValue() {
        return new float[]{4.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    }

    public static float[] getResetZeroValue() {
        return new float[21];
    }

    public void resetAttrsRaw() {
        this.AttrsRaw = Attrs.getResetRawValue();
    }

    public void resetAttrsBuffed() {
        this.AttrsBuffed = Attrs.getResetRawValue();
    }

    public void resetAttrsEquip() {
        this.AttrsEquip = new float[21];
    }

    public void resetAttrsPotion() {
        this.AttrsPotion = new float[21];
    }

    public float[] getAttrsRaw() {
        return this.AttrsRaw;
    }

    public float getAttrsRaw(int id) {
        return this.AttrsRaw[id];
    }

    public float[] getAttrsBuffed() {
        return this.AttrsBuffed;
    }

    public float getAttrsBuffed(int id) {
        return this.AttrsBuffed[id];
    }

    public byte[] getAttrsBonus() {
        return this.AttrsBonus;
    }

    public byte getAttrsBonus(int id) {
        return this.AttrsBonus[id];
    }

    public float[] getAttrsType() {
        return this.AttrsType;
    }

    public float[] getAttrsEquip() {
        return this.AttrsEquip;
    }

    public float[] getAttrsPotion() {
        return this.AttrsPotion;
    }

    public float getAttackDamage() {
        return this.AttrsBuffed[1];
    }

    public float getAttackDamageHeavy() {
        return this.AttrsBuffed[2];
    }

    public float getAttackDamageAir() {
        return this.AttrsBuffed[3];
    }

    public float getAttackDamageAirHeavy() {
        return this.AttrsBuffed[4];
    }

    public float getDefense() {
        return this.AttrsBuffed[5];
    }

    public float getAttackRange() {
        return this.AttrsBuffed[8];
    }

    public float getAttackSpeed() {
        if (this.AttrsBuffed[6] < 0.001f) {
            return 0.001f;
        }
        return this.AttrsBuffed[6];
    }

    public float getMoveSpeed() {
        return this.AttrsBuffed[7];
    }

    public float getAttackDamage(boolean getRaw) {
        if (getRaw) {
            return this.AttrsRaw[1];
        }
        return this.AttrsBuffed[1];
    }

    public float getAttackDamageHeavy(boolean getRaw) {
        if (getRaw) {
            return this.AttrsRaw[2];
        }
        return this.AttrsBuffed[2];
    }

    public float getAttackDamageAir(boolean getRaw) {
        if (getRaw) {
            return this.AttrsRaw[3];
        }
        return this.AttrsBuffed[3];
    }

    public float getAttackDamageAirHeavy(boolean getRaw) {
        if (getRaw) {
            return this.AttrsRaw[4];
        }
        return this.AttrsBuffed[4];
    }

    public float getAttackRange(boolean getRaw) {
        if (getRaw) {
            return this.AttrsRaw[8];
        }
        return this.AttrsBuffed[8];
    }

    public float getAttackSpeed(boolean getRaw) {
        if (getRaw) {
            return this.AttrsRaw[6];
        }
        return this.AttrsBuffed[6];
    }

    public float getMoveSpeed(boolean getRaw) {
        if (getRaw) {
            return this.AttrsRaw[7];
        }
        return this.AttrsBuffed[7];
    }

    public void setAttrsRaw(float[] data) {
        this.AttrsRaw = data;
    }

    public void setAttrsRaw(int id, float data) {
        this.AttrsRaw[id] = data;
    }

    public void setAttrsBuffed(float[] data) {
        this.AttrsBuffed = data;
    }

    public void setAttrsBuffed(int id, float data) {
        this.AttrsBuffed[id] = data;
    }

    public void setAttrsBonus(byte[] data) {
        this.AttrsBonus = data;
    }

    public void setAttrsBonus(int id, int data) {
        this.AttrsBonus[id] = (byte)data;
    }

    public void setAttrsType(float[] data) {
        this.AttrsType = data;
    }

    public void setAttrsEquip(float[] data) {
        this.AttrsEquip = data;
    }

    public void setAttrsPotion(float[] data) {
        this.AttrsPotion = data;
    }

    public boolean addAttrsBonusRandom(Random rand) {
        int bonusChoose = rand.nextInt(6);
        if (this.AttrsBonus[bonusChoose] < ConfigHandler.modernLimit) {
            int n = bonusChoose;
            this.AttrsBonus[n] = (byte)(this.AttrsBonus[n] + 1);
            return true;
        }
        for (int i = 0; i < 6; ++i) {
            if (this.AttrsBonus[i] >= ConfigHandler.modernLimit) continue;
            int n = i;
            this.AttrsBonus[n] = (byte)(this.AttrsBonus[n] + 1);
            return true;
        }
        return false;
    }

    public static Attrs copyAttrs(Attrs attrs) {
        Attrs newattrs = new Attrs();
        newattrs.setAttrsBonus(Arrays.copyOf(attrs.getAttrsBonus(), attrs.getAttrsBonus().length));
        newattrs.setAttrsType(Arrays.copyOf(attrs.getAttrsType(), attrs.getAttrsType().length));
        newattrs.setAttrsRaw(Arrays.copyOf(attrs.getAttrsRaw(), attrs.getAttrsRaw().length));
        newattrs.setAttrsEquip(Arrays.copyOf(attrs.getAttrsEquip(), attrs.getAttrsEquip().length));
        newattrs.setAttrsPotion(Arrays.copyOf(attrs.getAttrsPotion(), attrs.getAttrsPotion().length));
        newattrs.setAttrsBuffed(Arrays.copyOf(attrs.getAttrsBuffed(), attrs.getAttrsBuffed().length));
        return newattrs;
    }
}
