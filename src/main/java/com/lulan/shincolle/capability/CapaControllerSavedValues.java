package com.lulan.shincolle.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class CapaControllerSavedValues extends WorldSavedData {

    private static final String DATA_NAME = "shincolle_ControllerValues";

    private final Map<String, Integer> controllerUIDs = new HashMap<>();

    public CapaControllerSavedValues(String name) {
        super(name);
    }

    public static CapaControllerSavedValues get(World world) {
        MapStorage storage = world.getPerWorldStorage();
        CapaControllerSavedValues instance = (CapaControllerSavedValues) storage.getOrLoadData(CapaControllerSavedValues.class, DATA_NAME);
        if (instance == null) {
            instance = new CapaControllerSavedValues(DATA_NAME);
            storage.setData(DATA_NAME, instance);
        }
        return instance;
    }

    @Override
    public void readFromNBT(@Nonnull NBTTagCompound nbt) {
        this.controllerUIDs.clear();
        NBTTagCompound controllersTag = nbt.getCompoundTag("FleetControllers");
        for (String key : controllersTag.getKeySet()) {
            this.controllerUIDs.put(key, controllersTag.getInteger(key));
        }
    }

    @Override
    @Nonnull
    public NBTTagCompound writeToNBT(@Nonnull NBTTagCompound compound) {
        NBTTagCompound controllersTag = new NBTTagCompound();
        this.controllerUIDs.forEach(controllersTag::setInteger);
        compound.setTag("FleetControllers", controllersTag);
        return compound;
    }

    public void addController(String key, int controllerUID) {
        this.controllerUIDs.put(key, controllerUID);
        this.markDirty();
    }

    public Integer getControllerUID(String key) {
        return this.controllerUIDs.get(key);
    }

    public void removeController(String key) {
        if (this.controllerUIDs.remove(key) != null) {
            this.markDirty();
        }
    }
}