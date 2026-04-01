package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.block.BlockWaypoint;
import com.lulan.shincolle.capability.CapaInventory;
import com.lulan.shincolle.capability.CapaShipInventory;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModBlocks;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.init.ModSounds;
import com.lulan.shincolle.item.PointerItem;
import com.lulan.shincolle.network.S2CSpawnParticle;
import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.utility.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class TileEntityCrane
        extends BasicTileInventory
        implements ITileWaypoint,
        ITickable {
    private int tick;
    private int partDelay;
    private int modeItem;
    private int modeRedstone;
    private int tickRedstone;
    private int modeLiquid;
    private int modeEnergy;
    private int rateLiquid;
    private int rateEU;
    private boolean isActive;
    private boolean isPaired;
    private boolean checkMetadata;
    private boolean checkOredict;
    private boolean checkNbt;
    private boolean enabLoad;
    private boolean enabUnload;
    private BlockPos lastPos;
    private BlockPos nextPos;
    private BlockPos chestPos;
    private int craneMode;
    public static final int[] NOSLOT = new int[0];
    public EntityPlayer owner;
    private BasicEntityShip ship;
    private IInventory chest;
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

    public TileEntityCrane() {
        this.itemHandler = new CapaInventory<>(18, this);
        this.ship = null;
        this.chest = null;
        this.isActive = false;
        this.isPaired = false;
        this.enabLoad = true;
        this.enabUnload = true;
        this.checkMetadata = false;
        this.checkOredict = false;
        this.checkNbt = false;
        this.craneMode = 0;
        this.tick = 0;
        this.partDelay = 0;
        this.modeItem = 0;
        this.modeRedstone = 0;
        this.modeLiquid = 0;
        this.modeEnergy = 0;
        this.rateLiquid = 0;
        this.rateEU = 0;
        this.tickRedstone = 0;
        this.lastPos = BlockPos.ORIGIN;
        this.nextPos = BlockPos.ORIGIN;
        this.chestPos = BlockPos.ORIGIN;
        this.tank = new FluidTank(ConfigHandler.tileCrane[0]);
        this.tank.setTileEntity(this);
    }

    @Override
    public String getRegName() {
        return "TileEntityCrane";
    }

    @Override
    public byte getGuiIntID() {
        return 6;
    }

    public byte getPacketID(int type) {
        if(type == 0){
            return 5;
        }
        return -1;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return NOSLOT;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.isActive = nbt.getBoolean("active");
        this.isPaired = nbt.getBoolean("paired");
        this.enabLoad = nbt.getBoolean("load");
        this.enabUnload = nbt.getBoolean("unload");
        this.checkMetadata = nbt.getBoolean("meta");
        this.checkOredict = nbt.getBoolean("dict");
        this.checkNbt = nbt.getBoolean("nbt");
        this.craneMode = nbt.getInteger("mode");
        this.modeItem = nbt.getInteger("imode");
        this.modeRedstone = nbt.getInteger("rmode");
        this.modeLiquid = nbt.getInteger("lmode");
        this.modeEnergy = nbt.getInteger("emode");
        this.tank.readFromNBT(nbt);
        int[] pos = nbt.getIntArray("chestPos");
        this.chestPos = pos.length != 3 ? BlockPos.ORIGIN : new BlockPos(pos[0], pos[1], pos[2]);
        pos = nbt.getIntArray("lastPos");
        this.lastPos = pos.length != 3 ? BlockPos.ORIGIN : new BlockPos(pos[0], pos[1], pos[2]);
        pos = nbt.getIntArray("nextPos");
        this.nextPos = pos.length != 3 ? BlockPos.ORIGIN : new BlockPos(pos[0], pos[1], pos[2]);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setBoolean("active", this.isActive);
        nbt.setBoolean("paired", this.isPaired);
        nbt.setBoolean("load", this.enabLoad);
        nbt.setBoolean("unload", this.enabUnload);
        nbt.setBoolean("meta", this.checkMetadata);
        nbt.setBoolean("dict", this.checkOredict);
        nbt.setBoolean("nbt", this.checkNbt);
        nbt.setInteger("mode", this.craneMode);
        nbt.setInteger("imode", this.modeItem);
        nbt.setInteger("rmode", this.modeRedstone);
        nbt.setInteger("lmode", this.modeLiquid);
        nbt.setInteger("emode", this.modeEnergy);
        this.tank.writeToNBT(nbt);
        if (this.lastPos != null) {
            nbt.setIntArray("lastPos", new int[]{this.lastPos.getX(), this.lastPos.getY(), this.lastPos.getZ()});
        } else {
            nbt.setIntArray("lastPos", new int[]{0, 0, 0});
        }
        if (this.nextPos != null) {
            nbt.setIntArray("nextPos", new int[]{this.nextPos.getX(), this.nextPos.getY(), this.nextPos.getZ()});
        } else {
            nbt.setIntArray("nextPos", new int[]{0, 0, 0});
        }
        if (this.chestPos != null) {
            nbt.setIntArray("chestPos", new int[]{this.chestPos.getX(), this.chestPos.getY(), this.chestPos.getZ()});
        } else {
            nbt.setIntArray("chestPos", new int[]{0, 0, 0});
        }
        return nbt;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return false;
        }
        return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return null;
        }
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && facing != EnumFacing.DOWN) {
            return (T)this.tank;
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
        return true;
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack item, EnumFacing face) {
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack item, EnumFacing face) {
        return false;
    }

    public void checkPairedChest() {
        if (this.isPaired) {
            TileEntity tile;
            if (this.chest == null && (tile = this.world.getTileEntity(this.chestPos)) instanceof IInventory) {
                this.chest = (IInventory)tile;
            }
            if (this.chest != null && !((TileEntity)this.chest).isInvalid()) {
                return;
            }
            this.clearPairedChest();
            this.sendSyncPacket();
        }
    }

    public void clearPairedChest() {
        this.chest = null;
        this.isPaired = false;
        this.chestPos = BlockPos.ORIGIN;
    }

    @Override
    public void setNextWaypoint(BlockPos pos) {
        if (pos != null) {
            this.nextPos = pos;
            if (!this.world.isRemote) {
                this.sendSyncPacket();
            }
        }
    }

    @Override
    public BlockPos getNextWaypoint() {
        return this.nextPos;
    }

    @Override
    public void setLastWaypoint(BlockPos pos) {
        if (pos != null) {
            this.lastPos = pos;
            if (!this.world.isRemote) {
                this.sendSyncPacket();
            }
        }
    }

    @Override
    public BlockPos getLastWaypoint() {
        return this.lastPos;
    }

    @Override
    public void update() {
        if (!this.world.isRemote) {
            boolean update = false;
            ++this.tick;
            if (this.tickRedstone > 0) {
                --this.tickRedstone;
                if (this.tickRedstone <= 0) {
                    this.world.notifyNeighborsOfStateChange(this.pos, ModBlocks.BlockCrane, true);
                }
            }
            if ((this.tick & 0xF) == 0 && this.owner == null && this.playerUID > 0) {
                this.owner = EntityHelper.getEntityPlayerByUID(this.playerUID);
            }
            if (this.isActive && this.isPaired && this.tick > 64 && (this.tick & 0xF) == 0) {
                this.checkPairedChest();
                this.checkCraningShip();
                if (this.modeRedstone == 1 && this.ship != null) {
                    this.tickRedstone = 18;
                    this.world.notifyNeighborsOfStateChange(this.pos, ModBlocks.BlockCrane, true);
                }
                if (this.chest != null) {
                    this.applyPreLiquidTransfer(this.modeLiquid);
                }
                if (this.chest != null && this.ship != null && this.ship.getStateMinor(43) == 2) {
                    boolean[] workList = new boolean[4];
                    try {
                        if (this.enabLoad) {
                            workList[0] = this.applyItemTransfer(true);
                        }
                        if (this.enabUnload) {
                            workList[1] = this.applyItemTransfer(false);
                        }
                        this.applyLiquidTransfer(this.modeLiquid);
                        workList[2] = (this.modeLiquid != 0 && this.rateLiquid > 0) && this.applyLiquidTransfer(this.modeLiquid);
                        workList[3] = (CommonProxy.activeIC2 && this.modeEnergy != 0 && this.rateEU > 0) && this.applyEnergyTransfer();
                        if (this.ship != null && this.ship.getShipType() == 7) {
                            for (boolean ignored : workList) {
                                this.ship.addShipExp(ConfigHandler.expGain[6]);
                            }
                        }
                        NetworkRegistry.TargetPoint tp = new NetworkRegistry.TargetPoint(this.ship.dimension, this.ship.posX, this.ship.posY, this.ship.posZ, 48.0);
                        CommonProxy.channelP.sendToAllAround(new S2CSpawnParticle(this.ship, 22, 0.0, 0.1, 0.0), tp);
                        if (this.checkCraneEnding(workList)) {
                            if (this.modeRedstone == 2) {
                                this.tickRedstone = 2;
                                this.world.notifyNeighborsOfStateChange(this.pos, ModBlocks.BlockCrane, true);
                            }
                            this.ship.setStateMinor(43, 0);
                            this.ship.setStateTimer(1, 0);
                            if (EntityHelper.applyNextWaypoint(this, this.ship, false, 0)) {
                                this.ship.setStateMinor(10, 2);
                            }
                            this.ship.playSound(ModSounds.SHIP_BELL, ConfigHandler.volumeShip * 1.5f, this.ship.getRNG().nextFloat() * 0.3f + 1.0f);
                            this.ship = null;
                        }
                    }
                    catch (Exception e) {
                        LogHelper.info("EXCEPTION: ship loading/unloading fail: " + e);
                        e.printStackTrace();
                        return;
                    }
                }
            }
            if ((this.tick & 0x7F) == 0 && (this.chestPos.getY() > 0 || this.lastPos.getY() > 0 || this.nextPos.getY() > 0)) {
                update = true;
            }
            if (update) {
                this.sendSyncPacket();
            }
        } else {
            if (this.world.getBlockState(this.pos).getBlock() != ModBlocks.BlockCrane) {
                this.invalidate();
                return;
            }
            ++this.tick;
            if (this.partDelay > 0) {
                --this.partDelay;
            }
            if (this.isActive && this.ship != null && this.partDelay <= 0) {
                this.partDelay = 128;
                double len = this.pos.getY() - this.ship.posY - 1.0;
                if (len < 1.0) {
                    len = 1.0;
                }
                ParticleHelper.spawnAttackParticleAt(this.pos.getX() + 0.5, this.pos.getY() - 1.0, this.pos.getZ() + 0.5, len, 0.0, 0.25, (byte)40);
            }
            if ((this.tick & 0xF) == 0) {
                EntityPlayer player = ClientProxy.getClientPlayer();
                ItemStack item = player.getHeldItem(EnumHand.MAIN_HAND);
                if (item != ItemStack.EMPTY && ((item.getItem() instanceof ItemBlock && (BlockWaypoint.INSTANCE.getRegistryName().toString()).equals(((ItemBlock) item.getItem()).getBlock().getRegistryName().toString())) || item.getItem() == ModItems.TargetWrench || item.getItem() instanceof PointerItem && item.getItemDamage() < 3)) {
                    double dz;
                    double dy;
                    double dx;
                    if (this.nextPos.getY() > 0) {
                        dx = (double)this.nextPos.getX() - this.pos.getX();
                        dy = (double)this.nextPos.getY() - this.pos.getY();
                        dz = (double)this.nextPos.getZ() - this.pos.getZ();
                        ParticleHelper.spawnAttackParticleAt(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5, dx * 0.01, dy * 0.01, dz * 0.01, (byte)38);
                    }
                    if (this.chestPos.getY() > 0) {
                        dx = (double)this.chestPos.getX() - this.pos.getX();
                        dy = (double)this.chestPos.getY() - this.pos.getY();
                        dz = (double)this.chestPos.getZ() - this.pos.getZ();
                        ParticleHelper.spawnAttackParticleAt(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5, dx * 0.01, dy * 0.01, dz * 0.01, (byte)39);
                    }
                    if ((this.tick & 0x1F) == 0 && (this.lastPos.getY() > 0 || this.nextPos.getY() > 0 || this.chestPos.getY() > 0)) {
                        String name = "";
                        String postext1;
                        String postext2;
                        String postext3;
                        int len0 = 0;
                        int len1;
                        int len2;
                        int len3;
                        if (this.owner != null) {
                            name = TextFormatting.GREEN + this.owner.getName();
                            len0 = ClientProxy.getMineraft().getRenderManager().getFontRenderer().getStringWidth(name);
                        }
                        postext1 = "F: " + TextFormatting.LIGHT_PURPLE + this.lastPos.getX() + ", " + this.lastPos.getY() + ", " + this.lastPos.getZ();
                        len1 = ClientProxy.getMineraft().getRenderManager().getFontRenderer().getStringWidth(postext1);
                        len1 = Math.max(len1, len0);
                        postext2 = "T: " + TextFormatting.AQUA + this.nextPos.getX() + ", " + this.nextPos.getY() + ", " + this.nextPos.getZ();
                        len2 = ClientProxy.getMineraft().getRenderManager().getFontRenderer().getStringWidth(postext2);
                        if (len1 < len2) {
                            len1 = len2;
                        }
                        postext3 = "C: " + TextFormatting.YELLOW + this.chestPos.getX() + ", " + this.chestPos.getY() + ", " + this.chestPos.getZ();
                        len3 = ClientProxy.getMineraft().getRenderManager().getFontRenderer().getStringWidth(postext3);
                        if (len1 < len3) {
                            len1 = len3;
                        }
                        postext1 = name + "\n" + TextFormatting.WHITE + postext1 + "\n" + TextFormatting.WHITE + postext2 + "\n" + TextFormatting.WHITE + postext3;
                        ParticleHelper.spawnAttackParticleAt(postext1, this.pos.getX() + 0.5, this.pos.getY() + 1.9, this.pos.getZ() + 0.5, (byte)0, 4, len1 + 1);
                    }
                }
            }
        }
    }

    private boolean checkCraneEnding(boolean[] workList) {
        switch (this.craneMode) {
            case 0: {
                for (boolean b : workList) {
                    if (!b) continue;
                    return false;
                }
                return true;
            }
            case 1: {
                return this.isInventoryFull();
            }
            case 2: {
                return this.isInventoryEmpty();
            }
            case 3: {
                return !workList[2] && !workList[3] && this.isInventoryExcess();
            }
            case 4: {
                return !workList[2] && !workList[3] && this.isInventoryRemain();
            }
            default:
        }
        return this.ship.getStateTimer(1) >= TileEntityCrane.getWaitTime(this.craneMode);
    }

    private boolean isInventoryFull() {
        FluidStack fs;
        boolean[] fullList = new boolean[6];
        fullList[0] = !this.enabLoad || this.ship == null || InventoryHelper.checkInventoryFull(this.ship.getCapaShipInventory());
        fullList[1] = !this.enabUnload || this.chest == null || InventoryHelper.checkInventoryFull(this.chest);
        if (this.modeLiquid == 1 && this.tank != null) {
            fs = this.tank.getFluid() == null ? null : this.tank.getFluid().copy();
            fullList[2] = this.ship == null || InventoryHelper.checkFluidContainer(this.ship.getCapaShipInventory(), fs, true);
        } else {
            fullList[2] = true;
        }
        if (this.modeLiquid == 2 && this.tank != null) {
            fs = this.tank.getFluid() == null ? null : this.tank.getFluid().copy();
            fullList[3] = this.chest == null || InventoryHelper.checkFluidContainer(this.chest, fs, true);
        } else {
            fullList[3] = true;
        }
        fullList[4] = true;
        fullList[5] = true;
        for (boolean isFull : fullList) {
            if (isFull) continue;
            return false;
        }
        return true;
    }

    private boolean isInventoryEmpty() {
        FluidStack fs;
        boolean[] emptyList = new boolean[6];
        emptyList[0] = !this.enabLoad || this.chest == null || InventoryHelper.checkInventoryEmpty(this.chest, this.getItemstackTemp(true), this.getItemMode(true), this.checkMetadata, this.checkNbt, this.checkOredict);
        emptyList[1] = !this.enabUnload || this.ship == null || InventoryHelper.checkInventoryEmpty(this.ship.getCapaShipInventory(), this.getItemstackTemp(false), this.getItemMode(false), this.checkMetadata, this.checkNbt, this.checkOredict);
        if (this.modeLiquid == 1 && this.tank != null) {
            fs = this.tank.getFluid() == null ? null : this.tank.getFluid().copy();
            emptyList[2] = this.chest == null || InventoryHelper.checkFluidContainer(this.chest, fs, false);
        } else {
            emptyList[2] = true;
        }
        if (this.modeLiquid == 2 && this.tank != null) {
            fs = this.tank.getFluid() == null ? null : this.tank.getFluid().copy();
            emptyList[3] = this.ship == null || InventoryHelper.checkFluidContainer(this.ship.getCapaShipInventory(), fs, false);
        } else {
            emptyList[3] = true;
        }
        emptyList[4] = true;
        emptyList[5] = true;
        for (boolean isEmpty : emptyList) {
            if (isEmpty) continue;
            return false;
        }
        return true;
    }

    private boolean isInventoryExcess() {
        boolean[] excessList = new boolean[]{!this.enabLoad || this.ship == null || InventoryHelper.checkInventoryAmount(this.ship.getCapaShipInventory(), this.getItemstackTemp(true), this.getItemMode(true), this.checkMetadata, this.checkNbt, this.checkOredict, true), !this.enabUnload || this.chest == null || InventoryHelper.checkInventoryAmount(this.chest, this.getItemstackTemp(false), this.getItemMode(false), this.checkMetadata, this.checkNbt, this.checkOredict, true)};
        for (boolean isExcess : excessList) {
            if (isExcess) continue;
            return false;
        }
        return true;
    }

    private boolean isInventoryRemain() {
        boolean[] remainList = new boolean[]{!this.enabLoad || this.chest == null || InventoryHelper.checkInventoryAmount(this.chest, this.getItemstackTemp(true), this.getItemMode(true), this.checkMetadata, this.checkNbt, this.checkOredict, false), !this.enabUnload || this.ship == null || InventoryHelper.checkInventoryAmount(this.ship.getCapaShipInventory(), this.getItemstackTemp(false), this.getItemMode(false), this.checkMetadata, this.checkNbt, this.checkOredict, false)};
        for (boolean isRemain : remainList) {
            if (isRemain) continue;
            return false;
        }
        return true;
    }

    private void applyPreLiquidTransfer(int mode) {
        if (this.chest == null) {
            return;
        }
        if (mode == 1) {
            for (int i = 0; i < this.chest.getSizeInventory(); ++i) {
                ItemStack sourceStack = this.chest.getStackInSlot(i);
                if (sourceStack.isEmpty()) continue;
                ItemStack singleItem = sourceStack.copy();
                singleItem.setCount(1);
                IFluidHandlerItem handler = FluidUtil.getFluidHandler(singleItem);
                if (handler != null) {
                    FluidStack drainedSim = handler.drain(Integer.MAX_VALUE, false);
                    if (drainedSim != null && drainedSim.amount > 0 && this.tank.fill(drainedSim, false) > 0) {
                        FluidStack drained = handler.drain(drainedSim.amount, true);
                        if (drained == null || drained.amount <= 0) continue;
                        this.tank.fill(drained, true);
                        ItemStack container = handler.getContainer();
                        sourceStack.shrink(1);
                        this.chest.setInventorySlotContents(i, sourceStack);
                        boolean merged = InventoryHelper.mergeItemStack(this.chest, container, null);
                        if (!merged || !container.isEmpty()) {
                            sourceStack.grow(1);
                            this.chest.setInventorySlotContents(i, sourceStack);
                            this.tank.drain(drained.amount, true);
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        else if (mode == 2 && this.tank.getFluid() != null && this.tank.getFluidAmount() > 0) {
            for (int i = 0; i < this.chest.getSizeInventory(); ++i) {
                ItemStack sourceStack = this.chest.getStackInSlot(i);
                if (sourceStack.isEmpty()) continue;
                ItemStack singleItem = sourceStack.copy();
                singleItem.setCount(1);
                IFluidHandlerItem handler = FluidUtil.getFluidHandler(singleItem);
                if (handler != null) {
                    FluidStack fluidToFill = this.tank.getFluid().copy();
                    int filledSim = handler.fill(fluidToFill, false);
                    if (filledSim > 0) {
                        FluidStack drained = this.tank.drain(filledSim, true);
                        if(drained != null && drained.amount > 0) {
                            handler.fill(drained, true);
                            ItemStack container = handler.getContainer();
                            sourceStack.shrink(1);
                            this.chest.setInventorySlotContents(i, sourceStack);
                            boolean merged = InventoryHelper.mergeItemStack(this.chest, container, null);
                            if (!merged || !container.isEmpty()) {
                                sourceStack.grow(1);
                                this.chest.setInventorySlotContents(i, sourceStack);
                                this.tank.fill(drained, true);
                                continue;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    private boolean applyLiquidTransfer(int mode) {
        if (this.ship == null) return false;
        boolean moved = false;
        if (mode == 1) {
            FluidStack fluidInTank = this.tank.getFluid();
            if (fluidInTank == null || fluidInTank.amount <= 0) {
                return false;
            }
            FluidStack fluidToTransfer = fluidInTank.copy();
            int amountBefore = fluidToTransfer.amount;
            if (InventoryHelper.tryFillContainer(this.ship.getCapaShipInventory(), fluidToTransfer)) {
                int transferredAmount = amountBefore - fluidToTransfer.amount;
                if (transferredAmount > 0) {
                    this.tank.drain(transferredAmount, true);
                    moved = true;
                }
            }
        }
        else if (mode == 2) {
            int maxFill = this.tank.getCapacity() - this.tank.getFluidAmount();
            int maxDrain = Math.min(1000, maxFill);
            if (maxDrain <= 0) {
                return false;
            }
            FluidStack drained = InventoryHelper.tryDrainContainer(this.ship.getCapaShipInventory(), this.tank.getFluid(), maxDrain);
            if (drained != null && drained.amount > 0) {
                this.tank.fill(drained, true);
                moved = true;
            }
        }
        return moved;
    }

    private boolean applyEnergyTransfer() {
        return false;
    }

    private boolean applyItemTransfer(boolean isLoading) {
        IInventory invFrom;
        IInventory invTo;
        ItemStack tempitem;
        ItemStack moveitem;
        boolean allNull = true;
        boolean moved = false;
        int slotid;
        for (int i = 0; i < 9; ++i) {
            TileEntityChest chest2;
            if (isLoading) {
                invFrom = this.chest;
                invTo = this.ship.getCapaShipInventory();
            } else {
                invTo = this.chest;
                invFrom = this.ship.getCapaShipInventory();
            }
            tempitem = this.getItemstackTemp(i, isLoading);
            if (tempitem != null && !tempitem.isEmpty()) {
                TileEntityChest chest22;
                allNull = false;
                slotid = this.matchTempItem(invFrom, tempitem);
                if (slotid < 0 && invFrom instanceof TileEntityChest && (chest22 = TileEntityHelper.getAdjChest((TileEntityChest)invFrom)) != null) {
                    invFrom = chest22;
                    slotid = this.matchTempItem(invFrom, tempitem);
                }
                boolean canMove = true;
                int targetStacks;
                if (this.craneMode == 3) {
                    if (isLoading) {
                        targetStacks = InventoryHelper.calcItemStackAmount(this.ship.getCapaShipInventory(), tempitem, this.checkMetadata, this.checkNbt, this.checkOredict);
                        if (targetStacks >= tempitem.getCount()) {
                            canMove = false;
                        }
                    } else {
                        targetStacks = InventoryHelper.calcItemStackAmount(this.chest, tempitem, this.checkMetadata, this.checkNbt, this.checkOredict);
                        if (targetStacks >= tempitem.getCount()) {
                            canMove = false;
                        }
                    }
                } else if (this.craneMode == 4) {
                    if (isLoading) {
                        targetStacks = InventoryHelper.calcItemStackAmount(this.chest, tempitem, this.checkMetadata, this.checkNbt, this.checkOredict);
                        if (targetStacks <= tempitem.getCount()) {
                            canMove = false;
                        }
                    } else {
                        targetStacks = InventoryHelper.calcItemStackAmount(this.ship.getCapaShipInventory(), tempitem, this.checkMetadata, this.checkNbt, this.checkOredict);
                        if (targetStacks <= tempitem.getCount()) {
                            canMove = false;
                        }
                    }
                }
                if (!canMove || slotid < 0) continue;
                moveitem = invFrom instanceof CapaShipInventory ? ((CapaShipInventory)invFrom).getStackInSlotWithPageCheck(slotid) : invFrom.getStackInSlot(slotid);
                moved = InventoryHelper.moveItemstackToInv(invTo, moveitem, null);
                if (moved && moveitem.getCount() <= 0) {
                    if (invFrom instanceof CapaShipInventory) {
                        ((CapaShipInventory)invFrom).setInventorySlotWithPageCheck(slotid, ItemStack.EMPTY);
                    } else {
                        invFrom.setInventorySlotContents(slotid, ItemStack.EMPTY);
                    }
                }
                if (moved) break;
            }
            if (i != 8 || !allNull) continue;
            slotid = this.matchAnyItemExceptNotModeItem(invFrom, isLoading);
            if (slotid < 0 && invFrom instanceof TileEntityChest && (chest2 = TileEntityHelper.getAdjChest((TileEntityChest)invFrom)) != null) {
                invFrom = chest2;
                slotid = this.matchAnyItemExceptNotModeItem(invFrom, isLoading);
            }
            if (slotid >= 0) {
                moveitem = invFrom instanceof CapaShipInventory ? ((CapaShipInventory)invFrom).getStackInSlotWithPageCheck(slotid) : invFrom.getStackInSlot(slotid);
                if (InventoryHelper.moveItemstackToInv(invTo, moveitem, null)) {
                    moved = true;
                    if (moveitem.getCount() <= 0) {
                        if (invFrom instanceof CapaShipInventory) {
                            ((CapaShipInventory)invFrom).setInventorySlotWithPageCheck(slotid, ItemStack.EMPTY);
                        } else {
                            invFrom.setInventorySlotContents(slotid, ItemStack.EMPTY);
                        }
                    }
                }
            }
        }
        return moved;
    }

    private ItemStack[] getItemstackTemp(boolean isLoadingTemp) {
        ItemStack[] temp = new ItemStack[9];
        int start = isLoadingTemp ? 0 : 9;
        for (int i = 0; i < 9; ++i) {
            temp[i] = this.itemHandler.getStackInSlot(i + start);
        }
        return temp;
    }

    private ItemStack getItemstackTemp(int i, boolean isLoadingTemp) {
        if (this.getItemMode(isLoadingTemp ? i : i + 9)) {
            return ItemStack.EMPTY;
        }
        if (isLoadingTemp) {
            return this.itemHandler.getStackInSlot(i);
        }
        return this.itemHandler.getStackInSlot(i + 9);
    }

    private int matchTempItem(IInventory inv, ItemStack target) {
        int startId = 0;
        int endId = inv.getSizeInventory();
        boolean isCapa = inv instanceof CapaShipInventory;
        if (isCapa) {
            startId = 6;
            endId = ((CapaShipInventory)inv).getSizeInventoryPaged();
        }
        if (target == null || target.isEmpty()) {
            for (int i = startId; i < endId; ++i) {
                ItemStack stack = isCapa ? ((CapaShipInventory)inv).getStackInSlotWithPageCheck(i) : inv.getStackInSlot(i);
                if (!stack.isEmpty()) return i;
            }
            return -1;
        }
        for (int i = startId; i < endId; ++i) {
            ItemStack itemInSlot = isCapa ? ((CapaShipInventory)inv).getStackInSlotWithPageCheck(i) : inv.getStackInSlot(i);
            if (itemInSlot == null || itemInSlot.isEmpty()) continue;
            if (itemInSlot.getItem() == target.getItem()) {
                boolean metaOK = !this.checkMetadata || itemInSlot.getItemDamage() == target.getItemDamage();
                boolean nbtOK = !this.checkNbt || ItemStack.areItemStackTagsEqual(itemInSlot, target);
                if (metaOK && nbtOK) return i;
            }
            if (this.checkOredict) {
                int[] targetOres = OreDictionary.getOreIDs(target);
                if (targetOres.length > 0) {
                    int[] slotOres = OreDictionary.getOreIDs(itemInSlot);
                    if (slotOres.length > 0 && targetOres[0] == slotOres[0]) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private int matchAnyItemExceptNotModeItem(IInventory inv, boolean isLoading) {
        ItemStack getitem;
        int slotid;
        int startid = 0;
        int maxSize = inv.getSizeInventory();
        if (inv instanceof CapaShipInventory) {
            startid = 6;
            maxSize = ((CapaShipInventory)inv).getSizeInventoryPaged();
        }
        for (slotid = startid; slotid < maxSize; ++slotid) {
            getitem = inv instanceof CapaShipInventory ? ((CapaShipInventory)inv).getStackInSlotWithPageCheck(slotid) : inv.getStackInSlot(slotid);
            if (getitem == null || getitem.isEmpty() || this.checkNotModeItem(slotid, getitem, isLoading) < 0) continue;
            return slotid;
        }
        return -1;
    }

    private int checkNotModeItem(int slotid, ItemStack item, boolean isLoading) {
        ItemStack temp;
        int slotStart = isLoading ? 0 : 9;
        int slotEnd = isLoading ? 9 : 18;
        for (int i = slotStart; i < slotEnd; ++i) {
            if (!this.getItemMode(i)) continue;
            temp = this.itemHandler.getStackInSlot(i);
            if (item.getItem() == temp.getItem()) {
                boolean metaOK = !this.checkMetadata || item.getItemDamage() == temp.getItemDamage();
                boolean nbtOK = !this.checkNbt || ItemStack.areItemStackTagsEqual(item, temp);
                if (this.checkNbt && this.checkMetadata) {
                    if (nbtOK && metaOK) return -1;
                } else if(this.checkNbt) {
                    if(nbtOK) return -1;
                } else if (this.checkMetadata) {
                    if(metaOK) return -1;
                } else {
                    return -1;
                }
            }
            if (!this.checkOredict) continue;
            int[] a = OreDictionary.getOreIDs(item);
            int[] b = OreDictionary.getOreIDs(temp);
            if (a.length > 0 && b.length > 0 && a[0] == b[0]) return -1;
        }
        return slotid;
    }

    private void checkCraningShip() {
        AxisAlignedBB box = new AxisAlignedBB(this.pos.getX() - 7.0, this.pos.getY() - 8.0, this.pos.getZ() - 7.0, this.pos.getX() + 7.0, this.pos.getY(), this.pos.getZ() + 7.0);
        List<BasicEntityShip> slist = this.world.getEntitiesWithinAABB(BasicEntityShip.class, box);
        if (!slist.isEmpty()) {
            for (BasicEntityShip s : slist) {
                if (s.getStateMinor(43) != 2 || s.getGuardedPos(0) != this.pos.getX() || s.getGuardedPos(1) != this.pos.getY() || s.getGuardedPos(2) != this.pos.getZ()) continue;
                this.setShipData(s);
                return;
            }
            for (BasicEntityShip s : slist) {
                if (s.getStateMinor(43) != 1 || s.getGuardedPos(0) != this.pos.getX() || s.getGuardedPos(1) != this.pos.getY() || s.getGuardedPos(2) != this.pos.getZ()) continue;
                this.setShipData(s);
                return;
            }
        }
        boolean needSync = this.ship != null;
        this.ship = null;
        if (needSync) {
            this.sendSyncPacket();
        }
    }

    protected void setShipData(BasicEntityShip ship) {
        this.ship = ship;
        this.ship.setStateMinor(43, 2);
        this.ship.getShipNavigate().tryMoveToXYZ(this.pos.getX() + 0.5, this.pos.getY() - 2.0, this.pos.getZ() + 0.5, 0.5);
        int[] drumNum = this.calcDrumLevel(ship, 0);
        this.rateLiquid = drumNum[1] * ConfigHandler.drumLiquid[1] + drumNum[0] * ConfigHandler.drumLiquid[0];
        this.rateLiquid = this.rateLiquid * 16 * ((int)(ship.getLevel() * 0.1f) + 1);
        if (CommonProxy.activeIC2) {
            drumNum = this.calcDrumLevel(ship, 1);
            this.rateEU = drumNum[1] * ConfigHandler.drumEU[1] + drumNum[0] * ConfigHandler.drumEU[0];
            this.rateEU = this.rateEU * 16 * ((int)(ship.getLevel() * 0.1f) + 1);
        }
        this.sendSyncPacket();
    }

    protected int[] calcDrumLevel(BasicEntityShip ship, int type) {
        int[] num = new int[]{0, 0};
        CapaShipInventory inv = ship.getCapaShipInventory();
        if (ship.getShipType() == 7 && ship.getStateFlag(1)) {
            num[0] = 1;
        }
        for (int i = 0; i < 6; ++i) {
            ItemStack stack = inv.getStackInSlotWithPageCheck(i);
            if (stack == null || stack.getItem() != ModItems.EquipDrum || (type != 0 || stack.getItemDamage() != 1) && (type != 1 || stack.getItemDamage() != 2)) continue;
            num[0] = num[0] + 1;
            num[1] = num[1] + EnchantHelper.calcEnchantNumber(stack);
        }
        return num;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.itemHandler.getStackInSlot(i);
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack stack) {
        this.itemHandler.setStackInSlot(i, stack);
    }

    @Override
    public int getInventoryStackLimit() {
        return 0;
    }

    public static int getWaitTime(int mode) {
        switch (mode) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9: {
                return (mode - 4) * 16;
            }
            case 10:
            case 11:
            case 12:
            case 13:
            case 14: {
                return (mode - 9) * 100;
            }
            case 15:
            case 16:
            case 17:
            case 18:
            case 19: {
                return (mode - 14) * 1200;
            }
            case 20:
            case 21:
            case 22:
            case 23:
            case 24: {
                return (mode - 19) * 12000;
            }
            default:
        }
        return 0;
    }

    @Override
    public int getWpStayTime() {
        return 0;
    }

    public void setItemMode(int slotID, boolean notMode) {
        this.modeItem = InventoryHelper.setItemMode(slotID, this.modeItem, notMode);
    }

    public boolean[] getItemMode(boolean isLoadingTemp) {
        int start = isLoadingTemp ? 0 : 9;
        boolean[] temp = new boolean[9];
        for (int i = 0; i < 9; ++i) {
            temp[i] = (this.modeItem >> i + start & 1) == 1;
        }
        return temp;
    }

    public boolean getItemMode(int slotID) {
        return InventoryHelper.getItemMode(slotID, this.modeItem);
    }

    public int getRedMode() {
        return this.modeRedstone;
    }

    public int getRedTick() {
        return this.tickRedstone;
    }

    public void setShip(BasicEntityShip ship) {
        this.ship = ship;
    }

    public BasicEntityShip getShip() {
        return this.ship;
    }

    @Override
    public int getField(int id) {
        switch (id) {
            case 0: {
                return this.ship == null ? 0 : this.ship.getEntityId();
            }
            case 1: {
                return this.ship == null ? 0 : this.ship.getStateTimer(1);
            }
            case 2: {
                return this.isActive ? 1 : 0;
            }
            case 3: {
                return this.checkMetadata ? 1 : 0;
            }
            case 4: {
                return this.checkOredict ? 1 : 0;
            }
            case 5: {
                return this.craneMode;
            }
            case 6: {
                return this.enabLoad ? 1 : 0;
            }
            case 7: {
                return this.enabUnload ? 1 : 0;
            }
            case 8: {
                return this.checkNbt ? 1 : 0;
            }
            case 9: {
                return this.modeItem;
            }
            case 10: {
                return this.modeRedstone;
            }
            case 11: {
                return this.playerUID;
            }
            case 12: {
                return this.modeLiquid;
            }
            case 13: {
                return this.modeEnergy;
            }
            default:
        }
        return 0;
    }

    @Override
    public void setField(int id, int value) {
        switch (id) {
            case 0:
            case 1: {
                break;
            }
            case 2: {
                this.isActive = value != 0;
                break;
            }
            case 3: {
                this.checkMetadata = value != 0;
                break;
            }
            case 4: {
                this.checkOredict = value != 0;
                break;
            }
            case 5: {
                this.craneMode = value;
                break;
            }
            case 6: {
                this.enabLoad = value != 0;
                break;
            }
            case 7: {
                this.enabUnload = value != 0;
                break;
            }
            case 8: {
                this.checkNbt = value != 0;
                break;
            }
            case 9: {
                this.modeItem = value;
                break;
            }
            case 10: {
                this.modeRedstone = value;
                break;
            }
            case 11: {
                this.playerUID = value;
                break;
            }
            case 12: {
                this.modeLiquid = value;
                break;
            }
            case 13: {
                this.modeEnergy = value;
                break;
            }
            default:
        }
    }

    @Override
    public int getFieldCount() {
        return 14;
    }

    @Override
    public void setPairedChest(BlockPos pos) {
        if (pos != null) {
            TileEntity tile = this.world.getTileEntity(pos);
            if (tile instanceof IInventory) {
                this.chestPos = pos;
                this.isPaired = true;
                this.chest = (IInventory)tile;
            }
            if (!this.world.isRemote) {
                this.sendSyncPacket();
            }
        }
    }

    @Override
    public BlockPos getPairedChest() {
        return this.chestPos;
    }
}