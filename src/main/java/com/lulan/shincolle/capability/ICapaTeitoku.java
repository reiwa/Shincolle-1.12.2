package com.lulan.shincolle.capability;

import net.minecraft.nbt.NBTTagCompound;

public interface ICapaTeitoku {
    NBTTagCompound saveNBTData(NBTTagCompound var1);

    void loadNBTData(NBTTagCompound var1);
}
