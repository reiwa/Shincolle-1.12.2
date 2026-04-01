package com.lulan.shincolle.capability;

import com.lulan.shincolle.item.ShipTank;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.FluidTankProperties;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

import javax.annotation.Nullable;

public class CapaFluidContainer
implements IFluidHandler,
ICapabilityProvider {
    public static final String FLUID_NBT_KEY = "Fluid";
    protected ItemStack stack;
    protected int capacity;
    protected boolean needInit = true;

    protected void initCapacity() {
        if (this.needInit && !this.stack.isEmpty()) {
            if (this.stack.getItem() instanceof ShipTank) {
                this.capacity = ShipTank.getCapacity(this.stack.getItemDamage());
            }
            this.needInit = false;
        }
    }

    @Nullable
    public FluidStack getFluid() {
        NBTTagCompound tagCompound = this.stack.getTagCompound();
        if (tagCompound == null || !tagCompound.hasKey(FLUID_NBT_KEY)) {
            return null;
        }
        return FluidStack.loadFluidStackFromNBT(tagCompound.getCompoundTag(FLUID_NBT_KEY));
    }

    protected void setFluid(FluidStack fluid) {
        if (!this.stack.hasTagCompound()) {
            this.stack.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound fluidTag = new NBTTagCompound();
        fluid.writeToNBT(fluidTag);
        this.stack.getTagCompound().setTag(FLUID_NBT_KEY, fluidTag);
    }

    public IFluidTankProperties[] getTankProperties() {
        return new FluidTankProperties[]{new FluidTankProperties(this.getFluid(), this.capacity)};
    }

    public int fill(FluidStack resource, boolean doFill) {
        this.initCapacity();
        if (this.stack.getCount() != 1 || resource == null || resource.amount <= 0 || !this.canFillFluidType()) {
            return 0;
        }
        FluidStack contained = this.getFluid();
        if (contained == null) {
            int fillAmount = Math.min(this.capacity, resource.amount);
            if (doFill) {
                FluidStack filled = resource.copy();
                filled.amount = fillAmount;
                this.setFluid(filled);
            }
            return fillAmount;
        }
        if (contained.isFluidEqual(resource)) {
            int fillAmount = Math.min(this.capacity - contained.amount, resource.amount);
            if (doFill && fillAmount > 0) {
                contained.amount += fillAmount;
                this.setFluid(contained);
            }
            return fillAmount;
        }
        return 0;
    }

    public FluidStack drain(FluidStack resource, boolean doDrain) {
        this.initCapacity();
        if (this.stack.getCount() != 1 || resource == null || resource.amount <= 0 || !resource.isFluidEqual(this.getFluid())) {
            return null;
        }
        return this.drain(resource.amount, doDrain);
    }

    public FluidStack drain(int maxDrain, boolean doDrain) {
        this.initCapacity();
        if (this.stack.getCount() != 1 || maxDrain <= 0) {
            return null;
        }
        FluidStack contained = this.getFluid();
        if (contained == null || contained.amount <= 0 || !this.canDrainFluidType()) {
            return null;
        }
        int drainAmount = Math.min(contained.amount, maxDrain);
        FluidStack drained = contained.copy();
        drained.amount = drainAmount;
        if (doDrain) {
            contained.amount -= drainAmount;
            if (contained.amount == 0) {
                this.setContainerToEmpty();
            } else {
                this.setFluid(contained);
            }
        }
        return drained;
    }

    public boolean canFillFluidType() {
        return true;
    }

    public boolean canDrainFluidType() {
        return true;
    }

    protected void setContainerToEmpty() {
        this.stack.getTagCompound().removeTag(FLUID_NBT_KEY);
    }

    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY;
    }

    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return (T)(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY ? this : null);
    }
}
