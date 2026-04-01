package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.block.BlockGrudgeHeavy;
import com.lulan.shincolle.capability.CapaInventory;
import com.lulan.shincolle.crafting.LargeRecipes;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModBlocks;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.item.BasicEquip;
import com.lulan.shincolle.utility.BlockHelper;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.TileEntityHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class TileMultiGrudgeHeavy
extends BasicTileMulti
implements ITileLiquidFurnace,
ITickable {
    private int powerConsumed = 0;
    private int powerRemained = 0;
    private int powerGoal = 0;
    private int buildType = 0;
    private int invMode = 0;
    private int selectMat = 0;
    private boolean isActive;
    private int[] matsBuild;
    private int[] matsStock;
    public static final int POWERINST;
    public static final int BUILDSPEED;
    public static final int POWERMAX;
    public static final float FUELMAGN;
    public static final int SLOTS_NUM = 10;
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

    public TileMultiGrudgeHeavy() {
        this.itemHandler = new CapaInventory<TileMultiGrudgeHeavy>(10, this);
        this.isActive = false;
        this.syncTime = 0;
        this.tank = new FluidTank(FluidRegistry.LAVA, 0, 2000);
        this.tank.setCanDrain(false);
        this.tank.setTileEntity(this);
        this.matsBuild = new int[4];
        this.matsStock = new int[4];
    }

    @Override
    public int getRenderMetadata() {
        if (this.world == null || this.pos == BlockPos.ORIGIN) {
            return -1;
        }
        return this.getBlockMetadata();
    }

    @Override
    public String getRegName() {
        return "tilemultilargeshipyard";
    }

    @Override
    public byte getGuiIntID() {
        return 2;
    }

    @Override
    public byte getPacketID(int type) {
        if(type == 0){
            return 1;
        }
        return -1;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        if (this.structType == 1) {
            return ALLSLOTS;
        }
        return new int[0];
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.tank.readFromNBT(nbt);
        this.powerConsumed = nbt.getInteger("powerConsumed");
        this.powerRemained = nbt.getInteger("powerRemained");
        this.powerGoal = nbt.getInteger("powerGoal");
        this.buildType = nbt.getInteger("buildType");
        this.invMode = nbt.getInteger("invMode");
        this.selectMat = nbt.getInteger("selectMat");
        this.setMatBuild(nbt.getIntArray("matsBuild"));
        this.setMatStock(nbt.getIntArray("matsStock"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        this.tank.writeToNBT(nbt);
        nbt.setInteger("powerConsumed", this.powerConsumed);
        nbt.setInteger("powerRemained", this.powerRemained);
        nbt.setInteger("powerGoal", this.powerGoal);
        nbt.setInteger("buildType", this.buildType);
        nbt.setInteger("invMode", this.invMode);
        nbt.setInteger("selectMat", this.selectMat);
        nbt.setIntArray("matsBuild", this.getMatBuild());
        nbt.setIntArray("matsStock", this.getMatStock());
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
        if (slot == 0) return false;
        if (stack.isEmpty()) return true;
        IFluidHandlerItem handler = stack.getCapability(
                CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY,
                EnumFacing.UP
        );
        if (handler != null) {
            handler.drain(1000, false);
            return true;
        }
        ItemStack current = this.itemHandler.getStackInSlot(slot);
        return current.isEmpty();
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, EnumFacing face) {
        if (slot == 0 || this.invMode == 1) return true;
        IFluidHandlerItem handler = stack.getCapability(
                CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY,
                face
        );
        if (handler != null) {
            FluidStack f = handler.drain(BlockHelper.SampleFluidLava, false);
            return f == null;
        }
        if (stack.getItem() == ModItems.InstantConMat
                || stack.getItem() == ModItems.ShipSpawnEgg
                || stack.getItem() instanceof BasicEquip
                || TileEntityHelper.getItemFuelValue(stack) > 0) {
            return false;
        }
        FluidStack fluid = FluidUtil.getFluidContained(stack);
        return fluid == null || fluid.amount < 1000;
    }

    public void buildComplete() {
        switch (this.buildType) {
            case 2: 
            case 4: {
                this.itemHandler.setStackInSlot(0, LargeRecipes.getBuildResultEquip(this.getMatBuild()));
                break;
            }
            default: {
                this.itemHandler.setStackInSlot(0, LargeRecipes.getBuildResultShip(this.getMatBuild()));
                break;
            }
        }
    }

    public boolean isBuilding() {
        return this.hasPowerRemained() && this.canBuild();
    }

    public boolean hasPowerRemained() {
        return this.powerRemained > this.getActualFuelConsumption();
    }

    public boolean canBuild() {
        return this.powerGoal > 0 && this.itemHandler.getStackInSlot(0) == ItemStack.EMPTY;
    }

    private int getActualFuelConsumption() {
        int difficulty = ConfigHandler.consumptionLevel;
        int consumption = BUILDSPEED;
        if (difficulty == 0) {
            consumption /= 5;
        } else if (difficulty == 1) {
            consumption /= 2;
        }
        return Math.max(1, consumption);
    }

    @Override
    public void update() {
        if (this.getStructType() <= 0) return;

        if (!this.world.isRemote) {
            this.runServerTick();
        } else if (this.world.getBlockState(this.pos).getBlock() != ModBlocks.BlockGrudgeHeavy) {
            this.invalidate();
        }
    }

    private void runServerTick() {
        boolean needsSync = false;
        this.powerGoal = this.buildType != 0 ? LargeRecipes.calcGoalPower(this.getMatBuild()) : 0;

        if (TileEntityHelper.decrItemFuel(this)) needsSync = true;
        TileEntityHelper.decrLiquidFuel(this);

        if (this.handleMaterials()) needsSync = true;

        if (this.isBuilding()) {
            if (this.processBuilding()) needsSync = true;
        } else {
            this.powerConsumed = 0;
        }

        if (this.updateActiveState()) needsSync = true;

        if (needsSync) {
            this.syncTime = 0;
            BlockGrudgeHeavy.updateBlockState(this.isBuilding() ? 2 : 1, this.world, this.pos);
            this.markDirty();
        }
    }

    private boolean handleMaterials() {
        if (this.invMode == 0) {
            for (int i = 1; i < SLOTS_NUM; ++i) {
                ItemStack item = this.itemHandler.getStackInSlot(i);
                if (!item.isEmpty() && LargeRecipes.addMaterialStock(this, item)) {
                    item.shrink(1);
                    return true;
                }
            }
        } else {
            int difficulty = ConfigHandler.consumptionLevel;
            int compressNum = (difficulty == 0) ? 90 : ((difficulty == 1) ? 18 : 9);
            int normalNum = (difficulty == 0) ? 10 : ((difficulty == 1) ? 2 : 1);
            if (this.getMatStock(this.selectMat) >= compressNum) {
                if (LargeRecipes.outputMaterialToSlot(this, this.selectMat, true)) {
                    this.addMatStock(this.selectMat, -compressNum);
                    return true;
                }
            } else if (this.getMatStock(this.selectMat) >= normalNum && LargeRecipes.outputMaterialToSlot(this, this.selectMat, false)) {
                this.addMatStock(this.selectMat, -normalNum);
                return true;
            }
        }
        return false;
    }

    private boolean processBuilding() {
        this.powerRemained -= this.getActualFuelConsumption();
        this.powerConsumed += BUILDSPEED;

        for (int i = 1; i < SLOTS_NUM; ++i) {
            ItemStack item = this.itemHandler.getStackInSlot(i);
            if (!item.isEmpty() && item.getItem() == ModItems.InstantConMat && this.powerConsumed < this.powerGoal) {
                item.shrink(1);
                this.powerConsumed += POWERINST;
                return true;
            }
        }

        if (this.powerConsumed >= this.powerGoal) {
            this.buildComplete();
            this.powerConsumed = 0;
            this.powerGoal = 0;
            if (this.buildType == 3 || this.buildType == 4) {
                this.setupRepeatBuild();
            } else {
                this.buildType = 0;
                this.matsBuild = new int[4];
            }
            return true;
        }
        return false;
    }

    private boolean updateActiveState() {
        boolean nowActive = this.isBuilding();
        if (this.isActive != nowActive) {
            this.isActive = nowActive;
            return true;
        }
        return false;
    }

    public void setupRepeatBuild() {
        boolean canRepeat = true;
        for (int i = 0; i < 4; i++) {
            if (this.getMatStock(i) < this.getMatBuild(i)) {
                canRepeat = false;
                break;
            }
        }
        if (canRepeat) {
            for (int i = 0; i < 4; i++) {
                this.addMatStock(i, -this.getMatBuild(i));
            }
        } else {
            this.buildType = 0;
            this.matsBuild = new int[4];
        }
    }

    public int getPowerRemainingScaled(int i) {
        return this.powerRemained * i / POWERMAX;
    }

    public String getBuildTimeString() {
        int timeSec = (int)(((double)(this.powerGoal - this.powerConsumed) / BUILDSPEED) * 0.05f);
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

    @Override
    public int getPowerMax() {
        return POWERMAX;
    }

    public int getBuildType() {
        return this.buildType;
    }

    public int getInvMode() {
        return this.invMode;
    }

    public int getSelectMat() {
        return this.selectMat;
    }

    public int[] getMatBuild() {
        return this.matsBuild;
    }

    public int[] getMatStock() {
        return this.matsStock;
    }

    public int getMatBuild(int id) {
        return this.matsBuild[id];
    }

    public int getMatStock(int id) {
        return this.matsStock[id];
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

    public void setInvMode(int par1) {
        this.invMode = par1;
    }

    public void setSelectMat(int par1) {
        this.selectMat = par1;
    }

    public void setMatBuild(int[] par1) {
        this.matsBuild = par1 == null || par1.length < 4 ? new int[]{0, 0, 0, 0} : par1;
    }

    public void setMatStock(int[] par1) {
        this.matsStock = par1 == null || par1.length < 4 ? new int[]{0, 0, 0, 0} : par1;
    }

    public void setMatBuild(int id, int par1) {
        if (this.matsBuild == null || this.matsBuild.length < 4) {
            this.matsBuild = new int[]{0, 0, 0, 0};
        }
        this.matsBuild[id] = par1;
    }

    public void setMatStock(int id, int par1) {
        if (this.matsStock == null || this.matsStock.length < 4) {
            this.matsStock = new int[]{0, 0, 0, 0};
        }
        this.matsStock[id] = par1;
    }

    public void addMatBuild(int id, int par1) {
        if (this.matsBuild == null || this.matsBuild.length < 4) {
            this.matsBuild = new int[]{0, 0, 0, 0};
        }
        this.matsBuild[id] = this.matsBuild[id] + par1;
    }

    public void addMatStock(int id, int par1) {
        if (this.matsStock == null || this.matsStock.length < 4) {
            this.matsStock = new int[]{0, 0, 0, 0};
        }
        this.matsStock[id] = this.matsStock[id] + par1;
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

    @SideOnly(value=Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        BlockPos pos = this.getPos();
        return new AxisAlignedBB(pos.add(-2, -3, -2), pos.add(2, 2, 2));
    }

    static {
        POWERMAX = (int)ConfigHandler.tileShipyardLarge[0];
        BUILDSPEED = (int)ConfigHandler.tileShipyardLarge[1];
        FUELMAGN = (float)ConfigHandler.tileShipyardLarge[2];
        POWERINST = BUILDSPEED * 1200;
        ALLSLOTS = new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9};
    }
}
