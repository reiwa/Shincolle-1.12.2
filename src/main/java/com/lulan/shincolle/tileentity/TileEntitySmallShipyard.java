package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.block.BlockSmallShipyard;
import com.lulan.shincolle.capability.CapaInventory;
import com.lulan.shincolle.crafting.SmallRecipes;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModBlocks;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.TileEntityHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;

public class TileEntitySmallShipyard
extends BasicTileInventory
implements ITileLiquidFurnace,
ITickable {
    private int powerConsumed = 0;
    private int powerRemained = 0;
    private int powerGoal = 0;
    private int buildType = 0;
    private int[] buildRecord;
    private boolean isActive;
    public static final int POWERINST;
    public static final int BUILDSPEED;
    public static final int POWERMAX;
    public static final float FUELMAGN;
    public static final int[] ALLSLOTS;
    protected FluidTank tank;

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            if (!this.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }
    public TileEntitySmallShipyard() {
        this.itemHandler = new CapaInventory<TileEntitySmallShipyard>(6, this);
        this.isActive = false;
        this.syncTime = 0;
        this.tank = new FluidTank(FluidRegistry.LAVA, 0, 2000);
        this.tank.setCanDrain(false);
        this.tank.setTileEntity(this);
    }

    @Override
    public String getRegName() {
        return "tileentitysmallshipyard";
    }

    @Override
    public byte getGuiIntID() {
        return 1;
    }

    @Override
    public byte getPacketID(int type) {
        if(type == 0){
            return 0;
        }
        return -1;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return ALLSLOTS;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, EnumFacing face) {
        if (slot == 5) return true;
        if (slot != 4 || stack.isEmpty()) return false;

        if (stack.getItem() == Items.BUCKET) return true;

        if (stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, EnumFacing.UP)) {
            IFluidHandlerItem fluidHandler = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, EnumFacing.UP);
            if (fluidHandler == null) return false;
            FluidStack drained = fluidHandler.drain(Fluid.BUCKET_VOLUME, false);
            return drained == null || drained.amount <= 0;
        }

        if (TileEntityHelper.getItemFuelValue(stack) > 0 || stack.getItem() == ModItems.InstantConMat) {
            return false;
        }

        FluidStack contained = FluidUtil.getFluidContained(stack);
        return contained == null || contained.amount < Fluid.BUCKET_VOLUME;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.tank.readFromNBT(nbt);
        this.powerConsumed = nbt.getInteger("consumedPower");
        this.powerRemained = nbt.getInteger("remainedPower");
        this.powerGoal = nbt.getInteger("goalPower");
        this.buildType = nbt.getInteger("buildType");
        this.setBuildRecord(nbt.getIntArray("buildRecord"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        this.tank.writeToNBT(nbt);
        nbt.setInteger("consumedPower", this.powerConsumed);
        nbt.setInteger("remainedPower", this.powerRemained);
        nbt.setInteger("goalPower", this.powerGoal);
        nbt.setInteger("buildType", this.buildType);
        nbt.setIntArray("buildRecord", this.getBuildRecord());
        return nbt;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return (T)this.tank;
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        if (stack.isEmpty()) return false;
        Item item = stack.getItem();
        int meta = stack.getItemDamage();
        switch (slot) {
            case 0:
                return item == ModItems.Grudge;
            case 1:
                return item == ModItems.AbyssMetal && meta == 0;
            case 2:
                return item == ModItems.Ammo && meta == 0;
            case 3:
                return item == ModItems.AbyssMetal && meta == 1;
            case 4:
                ItemStack inSlot = this.itemHandler.getStackInSlot(slot);
                if (!inSlot.isEmpty()) {
                    FluidStack existing = FluidUtil.getFluidContained(inSlot);
                    if (existing != null && existing.amount >= Fluid.BUCKET_VOLUME) {
                        return false;
                    }
                }
                FluidStack inputFluid = FluidUtil.getFluidContained(stack);
                boolean isSmallFluid = inputFluid == null || inputFluid.amount < Fluid.BUCKET_VOLUME;
                return isSmallFluid
                        || TileEntityHelper.getItemFuelValue(stack) > 0
                        || item == ModItems.InstantConMat;
            default:
                return false;
        }
    }
    public void buildComplete() {
        if (this.buildType == 4 || this.buildType == 3) {
            for (int i = 0; i < 4; ++i) {
                ItemStack item = this.itemHandler.getStackInSlot(i);
                if (item.isEmpty() || item.getCount() < this.getBuildRecord(i)) {
                    return;
                }
                item.shrink(this.getBuildRecord(i));
                if (item.getCount() > 0) continue;
                this.itemHandler.setStackInSlot(i, ItemStack.EMPTY);
            }
            if(this.buildType == 4){
                this.itemHandler.setStackInSlot(5, SmallRecipes.getBuildResultEquip(this.getBuildRecord()));
            } else {
                this.itemHandler.setStackInSlot(5, SmallRecipes.getBuildResultShip(this.getBuildRecord()));
            }
        } else {
            int[] matAmount;
            matAmount = SmallRecipes.getMaterialAmount(this.itemHandler.getStacksInSlots(0, 4));
            this.itemHandler.setStackInSlot(0, ItemStack.EMPTY);
            this.itemHandler.setStackInSlot(1, ItemStack.EMPTY);
            this.itemHandler.setStackInSlot(2, ItemStack.EMPTY);
            this.itemHandler.setStackInSlot(3, ItemStack.EMPTY);
            switch (this.buildType) {
                case 2: 
                case 4: {
                    this.itemHandler.setStackInSlot(5, SmallRecipes.getBuildResultEquip(matAmount));
                    break;
                }
                default: {
                    this.itemHandler.setStackInSlot(5, SmallRecipes.getBuildResultShip(matAmount));
                    break;
                }
            }
        }
    }

    public boolean isBuilding() {
        return this.hasRemainedPower() && this.canBuild();
    }

    public boolean hasRemainedPower() {
        return this.powerRemained > BUILDSPEED;
    }

    public boolean canBuild() {
        if (this.powerGoal <= 0) {
            return false;
        }
        if (this.buildType == 4 || this.buildType == 3) {
            if (SmallRecipes.canRecipeBuild(this.getBuildRecord())) {
                for (int i = 0; i < 4; ++i) {
                    ItemStack item = this.itemHandler.getStackInSlot(i);
                    if (!item.isEmpty() && item.getCount() >= this.getBuildRecord(i)) continue;
                    return false;
                }
                return this.itemHandler.getStackInSlot(5).isEmpty();
            }
        } else {
            return this.itemHandler.getStackInSlot(5).isEmpty();
        }
        return false;
    }

    @Override
    public void update() {
        if (this.world.isRemote) {
            if (this.world.getBlockState(this.pos).getBlock() != ModBlocks.BlockSmallShipyard) {
                this.invalidate();
            }
            return;
        }

        boolean stateChanged = this.consumeFuel();
        this.updatePowerGoal();

        if (this.isBuilding()) {
            if (this.tryInstantConstruction()) stateChanged = true;

            this.advanceBuildProcess();

            if (this.powerConsumed >= this.powerGoal) {
                this.finishBuild();
                stateChanged = true;
            }
        }

        if (!this.canBuild()) {
            this.powerConsumed = 0;
        }

        if (this.isActive != this.isBuilding()) {
            this.isActive = !this.isActive;
            stateChanged = true;
        }

        if (stateChanged) {
            BlockSmallShipyard.updateBlockState(this.isBuilding(), this.world, this.pos);
            this.markDirty();
        }
    }

    private boolean consumeFuel() {
        boolean consumed = TileEntityHelper.decrItemFuel(this);
        TileEntityHelper.decrLiquidFuel(this);
        return consumed;
    }

    private void updatePowerGoal() {
        if (this.buildType == 0) {
            this.powerGoal = 0;
            return;
        }

        if (this.buildType == 4 || this.buildType == 3) {
            this.powerGoal = SmallRecipes.canRecipeBuild(this.getBuildRecord()) ?
                    SmallRecipes.calcGoalPower(this.getBuildRecord()) : 0;
        } else {
            int[] itemAmount = SmallRecipes.getMaterialAmount(this.itemHandler.getStacksInSlots(0, 4));
            this.powerGoal = SmallRecipes.calcGoalPower(itemAmount);
        }
    }

    private boolean tryInstantConstruction() {
        ItemStack item = this.itemHandler.getStackInSlot(4);
        if (!item.isEmpty() && item.getItem() == ModItems.InstantConMat) {
            item.shrink(1);
            this.powerConsumed += POWERINST;
            return true;
        }
        return false;
    }

    private void advanceBuildProcess() {
        this.powerRemained -= BUILDSPEED;
        this.powerConsumed += BUILDSPEED;
    }

    private void finishBuild() {
        this.buildComplete();
        this.powerConsumed = 0;
        this.powerGoal = 0;
        if (this.buildType < 3) {
            this.buildType = 0;
        }
    }

    public int getPowerRemainingScaled(int i) {
        return this.powerRemained * i / POWERMAX;
    }

    public String getBuildTimeString() {
        int timeSec = (int)((((double)this.powerGoal - this.powerConsumed) / BUILDSPEED) * 0.05f);
        return CalcHelper.getTimeFormated(timeSec);
    }

    @Override
    public int getPowerConsumed() {
        return this.powerConsumed;
    }

    @Override
    public int getPowerRemained() {
        return this.powerRemained;
    }

    @Override
    public int getPowerGoal() {
        return this.powerGoal;
    }

    public int getBuildType() {
        return this.buildType;
    }

    private int[] safeGetBuildRecord() {
        if (this.buildRecord == null || this.buildRecord.length < 4) {
            this.buildRecord = new int[]{0, 0, 0, 0};
        }
        return this.buildRecord;
    }

    public int[] getBuildRecord() {
        return this.safeGetBuildRecord();
    }

    public int getBuildRecord(int id) {
        return this.safeGetBuildRecord()[id];
    }

    public void setBuildRecord(int[] record) {
        if (record == null || record.length < 4) {
            this.buildRecord = new int[]{0, 0, 0, 0};
        } else {
            this.buildRecord = record.clone();
        }
    }

    @Override
    public void setPowerConsumed(int par1) {
        this.powerConsumed = par1;
    }

    @Override
    public void setPowerRemained(int par1) {
        this.powerRemained = par1;
    }

    @Override
    public void setPowerGoal(int par1) {
        this.powerGoal = par1;
    }

    public void setBuildType(int par1) {
        this.buildType = par1;
    }

    @Override
    public int getPowerMax() {
        return POWERMAX;
    }

    @Override
    public int getFluidFuelAmount() {
        return this.tank.getFluidAmount();
    }

    @Override
    public int consumeFluidFuel(int amount) {
        FluidStack fluid;
        if (this.tank != null && (fluid = this.tank.drainInternal(amount, true)) != null) {
            return fluid.amount;
        }
        return 0;
    }

    @Override
    public float getFuelMagni() {
        return FUELMAGN;
    }

    static {
        POWERMAX = (int)ConfigHandler.tileShipyardSmall[0];
        BUILDSPEED = (int)ConfigHandler.tileShipyardSmall[1];
        FUELMAGN = (float)ConfigHandler.tileShipyardSmall[2];
        POWERINST = BUILDSPEED * 2400;
        ALLSLOTS = new int[]{0, 1, 2, 3, 4, 5};
    }
}
