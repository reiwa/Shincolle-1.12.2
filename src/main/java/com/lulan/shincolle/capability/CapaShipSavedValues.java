package com.lulan.shincolle.capability;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.reference.unitclass.Attrs;
import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.NBTHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class CapaShipSavedValues {

    public static final String SHIP_EXTPROP_NAME = "ShipExtProps";
    private static final String KEY_CRANE = "Crane";

    private CapaShipSavedValues() {
    }

    public static NBTTagCompound saveNBTData(NBTTagCompound nbt, BasicEntityShip ship) {
        NBTTagCompound nbtExt = new NBTTagCompound();
        NBTTagCompound nbtExtMinor = new NBTTagCompound();
        NBTTagCompound nbtExtDisplay = new NBTTagCompound();
        NBTTagCompound nbtExtPoint = new NBTTagCompound();
        NBTTagCompound nbtExtShipFlags = new NBTTagCompound();
        NBTTagCompound nbtExtTimer = new NBTTagCompound();

        nbtExt.setTag("Minor", nbtExtMinor);
        nbtExtMinor.setInteger("Level", ship.getStateMinor(0));
        nbtExtMinor.setInteger("Kills", ship.getStateMinor(1));
        nbtExtMinor.setInteger("Exp", ship.getStateMinor(2));
        nbtExtMinor.setInteger("NumAmmoL", ship.getStateMinor(4));
        nbtExtMinor.setInteger("NumAmmoH", ship.getStateMinor(5));
        nbtExtMinor.setInteger("NumGrudge", ship.getStateMinor(6));
        nbtExtMinor.setInteger("NumAirL", ship.getStateMinor(7));
        nbtExtMinor.setInteger("NumAirH", ship.getStateMinor(8));
        nbtExtMinor.setInteger("FMin", ship.getStateMinor(10));
        nbtExtMinor.setInteger("FMax", ship.getStateMinor(11));
        nbtExtMinor.setInteger("FHP", ship.getStateMinor(12));
        nbtExtMinor.setInteger("GuardX", ship.getStateMinor(14));
        nbtExtMinor.setInteger("GuardY", ship.getStateMinor(15));
        nbtExtMinor.setInteger("GuardZ", ship.getStateMinor(16));
        nbtExtMinor.setInteger("GuardDim", ship.getStateMinor(17));
        nbtExtMinor.setInteger("GuardID", ship.getStateMinor(18));
        nbtExtMinor.setInteger("GuardType", ship.getStateMinor(24));
        nbtExtMinor.setInteger("PlayerUID", ship.getStateMinor(21));
        nbtExtMinor.setInteger("ShipUID", ship.getStateMinor(22));
        nbtExtMinor.setInteger("FType", ship.getStateMinor(26));
        nbtExtMinor.setInteger("FPos", ship.getStateMinor(27));
        nbtExtMinor.setInteger("Morale", ship.getStateMinor(30));
        nbtExtMinor.setInteger("Food", ship.getStateMinor(31));
        nbtExtMinor.setInteger(KEY_CRANE, ship.getStateMinor(43));
        nbtExtMinor.setInteger("WpStay", ship.getStateMinor(44));
        nbtExtMinor.setInteger("AutoCR", ship.getStateMinor(9));
        nbtExtMinor.setInteger("Task", ship.getStateMinor(40));
        nbtExtMinor.setInteger("Side", ship.getStateMinor(41));
        nbtExtMinor.setString("tagName", ship.getCustomNameTag());

        nbtExt.setTag("Display", nbtExtDisplay);
        nbtExtDisplay.setInteger("State", ship.getStateEmotion(0));
        nbtExtDisplay.setInteger("Emotion", ship.getStateEmotion(1));
        nbtExtDisplay.setInteger("Emotion2", ship.getStateEmotion(2));
        nbtExtDisplay.setInteger("Phase", ship.getStateEmotion(5));

        nbtExt.setTag("Point", nbtExtPoint);
        nbtExtPoint.setByte("HP", ship.getAttrs().getAttrsBonus(0));
        nbtExtPoint.setByte("ATK", ship.getAttrs().getAttrsBonus(1));
        nbtExtPoint.setByte("DEF", ship.getAttrs().getAttrsBonus(2));
        nbtExtPoint.setByte("SPD", ship.getAttrs().getAttrsBonus(3));
        nbtExtPoint.setByte("MOV", ship.getAttrs().getAttrsBonus(4));
        nbtExtPoint.setByte("HIT", ship.getAttrs().getAttrsBonus(5));

        nbtExt.setTag("ShipFlags", nbtExtShipFlags);
        nbtExtShipFlags.setBoolean("CanFloat", ship.getStateFlag(0));
        nbtExtShipFlags.setBoolean("IsMarried", ship.getStateFlag(1));
        nbtExtShipFlags.setBoolean("NoFuel", ship.getStateFlag(2));
        nbtExtShipFlags.setBoolean("Melee", ship.getStateFlag(3));
        nbtExtShipFlags.setBoolean("AmmoL", ship.getStateFlag(4));
        nbtExtShipFlags.setBoolean("AmmoH", ship.getStateFlag(5));
        nbtExtShipFlags.setBoolean("AirL", ship.getStateFlag(6));
        nbtExtShipFlags.setBoolean("AirH", ship.getStateFlag(7));
        nbtExtShipFlags.setBoolean("WedEffect", ship.getStateFlag(9));
        nbtExtShipFlags.setBoolean("CanDrop", ship.getStateFlag(10));
        nbtExtShipFlags.setBoolean("CanFollow", ship.getStateFlag(11));
        nbtExtShipFlags.setBoolean("OnSight", ship.getStateFlag(12));
        nbtExtShipFlags.setBoolean("PVPFirst", ship.getStateFlag(18));
        nbtExtShipFlags.setBoolean("AA", ship.getStateFlag(19));
        nbtExtShipFlags.setBoolean("ASM", ship.getStateFlag(20));
        nbtExtShipFlags.setBoolean("PassiveAI", ship.getStateFlag(21));
        nbtExtShipFlags.setBoolean("TimeKeeper", ship.getStateFlag(22));
        nbtExtShipFlags.setBoolean("PickItem", ship.getStateFlag(23));
        nbtExtShipFlags.setBoolean("HeldItem", ship.getStateFlag(25));
        nbtExtShipFlags.setBoolean("AutoPump", ship.getStateFlag(26));
        nbtExtShipFlags.setBoolean("FleetMode", ship.getStateFlag(27));
        nbtExtShipFlags.setBoolean("IsMorph", ship.isMorph());

        nbtExt.setTag("Timer", nbtExtTimer);
        nbtExtTimer.setInteger(KEY_CRANE, ship.getStateTimer(1));

        if (ship.ownerName != null && !ship.ownerName.isEmpty()) {
            nbtExt.setString("Owner", ship.ownerName);
        }
        nbtExt = NBTHelper.saveStringTagArrayList(nbtExt, "uname", ship.unitNames);
        nbt.setTag(SHIP_EXTPROP_NAME, nbtExt);
        LogHelper.debug("DEBUG: save entity ExtNBT data on id: " + ship.getEntityId());
        return nbt;
    }

    public static void loadNBTData(NBTTagCompound nbt, BasicEntityShip ship) {
        NBTTagCompound nbtTag = (NBTTagCompound) nbt.getTag(SHIP_EXTPROP_NAME);

        NBTTagCompound nbtMinor = nbtTag.getCompoundTag("Minor");
        ship.setStateMinor(0, nbtMinor.getInteger("Level"));
        ship.setStateMinor(1, nbtMinor.getInteger("Kills"));
        ship.setStateMinor(2, nbtMinor.getInteger("Exp"));
        ship.setStateMinor(4, nbtMinor.getInteger("NumAmmoL"));
        ship.setStateMinor(5, nbtMinor.getInteger("NumAmmoH"));
        ship.setStateMinor(6, nbtMinor.getInteger("NumGrudge"));
        ship.setStateMinor(7, nbtMinor.getInteger("NumAirL"));
        ship.setStateMinor(8, nbtMinor.getInteger("NumAirH"));
        ship.setStateMinor(10, nbtMinor.getInteger("FMin"));
        ship.setStateMinor(11, nbtMinor.getInteger("FMax"));
        ship.setStateMinor(12, nbtMinor.getInteger("FHP"));
        ship.setStateMinor(14, nbtMinor.getInteger("GuardX"));
        ship.setStateMinor(15, nbtMinor.getInteger("GuardY"));
        ship.setStateMinor(16, nbtMinor.getInteger("GuardZ"));
        ship.setStateMinor(17, nbtMinor.getInteger("GuardDim"));
        ship.setStateMinor(18, nbtMinor.getInteger("GuardID"));
        ship.setStateMinor(24, nbtMinor.getInteger("GuardType"));
        ship.setStateMinor(21, nbtMinor.getInteger("PlayerUID"));
        ship.setStateMinor(22, nbtMinor.getInteger("ShipUID"));
        ship.setStateMinor(26, nbtMinor.getInteger("FType"));
        ship.setStateMinor(27, nbtMinor.getInteger("FPos"));
        ship.setStateMinor(30, nbtMinor.getInteger("Morale"));
        ship.setStateMinor(31, nbtMinor.getInteger("Food"));
        ship.setStateMinor(43, nbtMinor.getInteger(KEY_CRANE));
        ship.setStateMinor(44, nbtMinor.getInteger("WpStay"));
        ship.setStateMinor(9, nbtMinor.getInteger("AutoCR"));
        ship.setStateMinor(40, nbtMinor.getInteger("Task"));
        ship.setStateMinor(41, nbtMinor.getInteger("Side"));

        NBTTagCompound nbtDisplay = nbtTag.getCompoundTag("Display");
        ship.setStateEmotion(0, nbtDisplay.getInteger("State"), false);
        ship.setStateEmotion(1, nbtDisplay.getInteger("Emotion"), false);
        ship.setStateEmotion(2, nbtDisplay.getInteger("Emotion2"), false);
        ship.setStateEmotion(5, nbtDisplay.getInteger("Phase"), false);

        NBTTagCompound nbtPoint = nbtTag.getCompoundTag("Point");
        Attrs attrs = ship.getAttrs();
        attrs.setAttrsBonus(0, nbtPoint.getByte("HP"));
        attrs.setAttrsBonus(1, nbtPoint.getByte("ATK"));
        attrs.setAttrsBonus(2, nbtPoint.getByte("DEF"));
        attrs.setAttrsBonus(3, nbtPoint.getByte("SPD"));
        attrs.setAttrsBonus(4, nbtPoint.getByte("MOV"));
        attrs.setAttrsBonus(5, nbtPoint.getByte("HIT"));

        NBTTagCompound nbtShipFlags = nbtTag.getCompoundTag("ShipFlags");
        ship.setStateFlag(0, nbtShipFlags.getBoolean("CanFloat"));
        ship.setStateFlag(1, nbtShipFlags.getBoolean("IsMarried"));
        ship.setStateFlag(2, nbtShipFlags.getBoolean("NoFuel"));
        ship.setStateFlag(3, nbtShipFlags.getBoolean("Melee"));
        ship.setStateFlag(4, nbtShipFlags.getBoolean("AmmoL"));
        ship.setStateFlag(5, nbtShipFlags.getBoolean("AmmoH"));
        ship.setStateFlag(6, nbtShipFlags.getBoolean("AirL"));
        ship.setStateFlag(7, nbtShipFlags.getBoolean("AirH"));
        ship.setStateFlag(9, nbtShipFlags.getBoolean("WedEffect"));
        ship.setStateFlag(10, nbtShipFlags.getBoolean("CanDrop"));
        ship.setStateFlag(11, nbtShipFlags.getBoolean("CanFollow"));
        ship.setStateFlag(12, nbtShipFlags.getBoolean("OnSight"));
        ship.setStateFlag(18, nbtShipFlags.getBoolean("PVPFirst"));
        ship.setStateFlag(19, nbtShipFlags.getBoolean("AA"));
        ship.setStateFlag(20, nbtShipFlags.getBoolean("ASM"));
        ship.setStateFlag(21, nbtShipFlags.getBoolean("PassiveAI"));
        ship.setStateFlag(22, nbtShipFlags.getBoolean("TimeKeeper"));
        ship.setStateFlag(23, nbtShipFlags.getBoolean("PickItem"));
        ship.setStateFlag(25, nbtShipFlags.getBoolean("HeldItem"));
        ship.setStateFlag(26, nbtShipFlags.getBoolean("AutoPump"));
        ship.setStateFlag(27, nbtShipFlags.getBoolean("FleetMode"));
        ship.setIsMorph(nbtShipFlags.getBoolean("IsMorph"));

        NBTTagCompound nbtTimer = nbtTag.getCompoundTag("Timer");
        ship.setStateTimer(1, nbtTimer.getInteger(KEY_CRANE));

        String name = nbtTag.getString("Owner");
        if (!name.isEmpty()) {
            ship.ownerName = name;
        } else {
            Entity owner = ship.getHostEntity();
            if (owner instanceof EntityPlayer) {
                ship.ownerName = owner.getName();
            }
        }
        ship.unitNames = NBTHelper.loadStringTagArrayList(nbtTag, "uname");
        ship.setExpNext();
        ship.calcShipAttributes(31, true);
        LogHelper.debug("DEBUG : load entity ExtNBT data on id: " + ship.getEntityId());
    }
}