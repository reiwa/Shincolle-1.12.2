package com.lulan.shincolle.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CapaTeitokuProvider
implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(value=ICapaTeitoku.class)
    public static final Capability<ICapaTeitoku> TeitokuCapability = null;
    private final ICapaTeitoku instance = new CapaTeitoku();

    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == TeitokuCapability;
    }

    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == TeitokuCapability) {
            return TeitokuCapability.cast(instance);
        }
        return null;
    }

    public NBTBase serializeNBT() {
        return TeitokuCapability.getStorage().writeNBT(TeitokuCapability, TeitokuCapability.cast(instance), null);
    }

    public void deserializeNBT(NBTBase nbt) {
        TeitokuCapability.getStorage().readNBT(TeitokuCapability, TeitokuCapability.cast(instance), null, nbt);
    }
}