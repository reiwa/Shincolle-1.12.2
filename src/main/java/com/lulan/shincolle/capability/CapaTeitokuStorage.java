package com.lulan.shincolle.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class CapaTeitokuStorage
implements Capability.IStorage<ICapaTeitoku> {
    public NBTBase writeNBT(Capability<ICapaTeitoku> capability, ICapaTeitoku instance, EnumFacing side) {
        return instance.saveNBTData(new NBTTagCompound());
    }

    public void readNBT(Capability<ICapaTeitoku> capability, ICapaTeitoku instance, EnumFacing side, NBTBase nbt) {
        instance.loadNBTData((NBTTagCompound)nbt);
    }
}
