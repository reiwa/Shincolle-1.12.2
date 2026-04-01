package com.lulan.shincolle.reference.unitclass;

import com.lulan.shincolle.utility.FormationHelper;

import java.util.Arrays;

public class AttrsAdv
extends Attrs {
    protected float[] AttrsFormation;
    protected float[] AttrsMorale;
    protected float MinMOV;

    public AttrsAdv() {
    }

    public AttrsAdv(int shipClass) {
        super(shipClass);
    }

    @Override
    public void initValue() {
        super.initValue();
        this.resetAttrsMorale();
        this.resetAttrsFormation();
    }

    public static float[] getResetFormationValue() {
        return new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public static float[] getResetMoraleValue() {
        return new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public void resetAttrsFormation() {
        this.AttrsFormation = AttrsAdv.getResetFormationValue();
        this.MinMOV = 0.0f;
    }

    public void resetAttrsMorale() {
        this.AttrsMorale = AttrsAdv.getResetMoraleValue();
    }

    public float[] getAttrsFormation() {
        return this.AttrsFormation;
    }

    public float getAttrsFormation(int id) {
        return this.AttrsFormation[id];
    }

    public float getMinMOV() {
        return this.MinMOV;
    }

    public float[] getAttrsMorale() {
        return this.AttrsMorale;
    }

    public float getAttrsMorale(int id) {
        return this.AttrsMorale[id];
    }

    public void setAttrsFormation(float[] data) {
        this.AttrsFormation = data;
    }

    public void setMinMOV(float data) {
        this.MinMOV = data;
    }

    public void setAttrsFormation(int formatID, int formatSlot) {
        this.AttrsFormation = FormationHelper.getFormationBuffValue(formatID, formatSlot);
    }

    public void setAttrsMorale(float[] data) {
        this.AttrsMorale = data;
    }

    public static AttrsAdv copyAttrsAdv(AttrsAdv attrs) {
        AttrsAdv newattrs = new AttrsAdv();
        newattrs.setAttrsBonus(Arrays.copyOf(attrs.getAttrsBonus(), attrs.getAttrsBonus().length));
        newattrs.setAttrsType(Arrays.copyOf(attrs.getAttrsType(), attrs.getAttrsType().length));
        newattrs.setAttrsRaw(Arrays.copyOf(attrs.getAttrsRaw(), attrs.getAttrsRaw().length));
        newattrs.setAttrsEquip(Arrays.copyOf(attrs.getAttrsEquip(), attrs.getAttrsEquip().length));
        newattrs.setAttrsPotion(Arrays.copyOf(attrs.getAttrsPotion(), attrs.getAttrsPotion().length));
        newattrs.setAttrsBuffed(Arrays.copyOf(attrs.getAttrsBuffed(), attrs.getAttrsBuffed().length));
        newattrs.setAttrsMorale(Arrays.copyOf(attrs.getAttrsMorale(), attrs.getAttrsMorale().length));
        newattrs.setAttrsFormation(Arrays.copyOf(attrs.getAttrsFormation(), attrs.getAttrsFormation().length));
        newattrs.setMinMOV(attrs.getMinMOV());
        return newattrs;
    }
}
