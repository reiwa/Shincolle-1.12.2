package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.capability.CapaInventory;
import com.lulan.shincolle.entity.BasicEntityAirplane;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModBlocks;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.network.S2CSpawnParticle;
import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.utility.BlockHelper;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.ParticleHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import java.util.List;
import java.util.Random;

public class TileEntityVolCore
extends BasicTileInventory
implements ITickable {
    private final Random rand = new Random();
    private boolean canWork;
    private boolean btnActive;
    private int remainedPower = 0;
    public static int CONSUMEDSPEED = (int)ConfigHandler.tileVolCore[1];
    public static int POWERMAX = (int)ConfigHandler.tileVolCore[0];
    public static int FUELMAGN = (int)ConfigHandler.tileVolCore[2];
    private static final int[] ALLSLOTS;

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            if (!this.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }
    public TileEntityVolCore() {
        this.itemHandler = new CapaInventory<TileEntityVolCore>(9, this);
        this.canWork = false;
        this.btnActive = false;
        this.syncTime = 0;
    }

    @Override
    public String getRegName() {
        return "TileEntityVolCore";
    }

    @Override
    public byte getGuiIntID() {
        return 7;
    }

    public byte getPacketID(int type) {
        if(type == 0){
            return 3;
        }
        return -1;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return ALLSLOTS;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.remainedPower = nbt.getInteger("power");
        this.btnActive = nbt.getBoolean("active");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("power", this.remainedPower);
        nbt.setBoolean("active", this.btnActive);
        return nbt;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        Item item;
        return !stack.isEmpty() && ((item = stack.getItem()) == ModItems.Grudge || item == Item.getItemFromBlock(ModBlocks.BlockGrudge));
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack item, EnumFacing face) {
        return true;
    }

    public boolean decrItemFuel() {
        ItemStack stack;
        Item item;
        boolean sendUpdate = false;
        int fuelx = 0;
        for (int i = 0; i < this.itemHandler.getSlots(); ++i) {
            stack = this.getStackInSlot(i);
            item = stack.getItem();
            if (item == ModItems.Grudge) {
                fuelx = FUELMAGN;
            } else if (item == Item.getItemFromBlock(ModBlocks.BlockGrudge)) {
                fuelx = FUELMAGN * 9;
            }
            if (fuelx <= 0) continue;
            if (fuelx + this.remainedPower >= POWERMAX) continue;
            stack.shrink(1);
            this.remainedPower += fuelx;
            if (stack.getCount() <= 0) {
                stack = stack.getItem().getContainerItem(stack);
            }
            this.setInventorySlotContents(i, stack);
            sendUpdate = true;
            break;
        }
        return sendUpdate;
    }

    private boolean isWorking() {
        return this.canWork && this.btnActive;
    }

    public void update() {
        ++this.syncTime;
        if (!this.world.isRemote) {
            boolean wasWorking = this.isWorking();
            if (this.syncTime % 16 == 0) {
                this.canWork = this.remainedPower >= CONSUMEDSPEED;
                if (this.isWorking()) {
                    this.remainedPower -= CONSUMEDSPEED;
                }
            }
            if (this.syncTime % 32 == 0) {
                this.decrItemFuel();
                if (this.isWorking()) {
                    this.volcoreFunction();
                }
            }
            if (this.syncTime % 256 == 0 && this.isWorking()) {
                double dx = this.pos.getX() + 0.5;
                double dy = this.pos.getY() + 2.5;
                double dz = this.pos.getZ() + 0.5;
                AxisAlignedBB box = new AxisAlignedBB(dx - 6.0, dy - 6.0, dz - 6.0, dx + 6.0, dy + 6.0, dz + 6.0);
                List<BasicEntityShip> slist = this.world.getEntitiesWithinAABB(BasicEntityShip.class, box);
                int emotes;
                switch (this.world.rand.nextInt(5)) {
                    case 0: emotes = 2; break;
                    case 1: emotes = 30; break;
                    case 2: emotes = 10; break;
                    default: emotes = 27;
                }
                EntityHelper.applyEmotesAOE(slist, emotes);
            }
            if (wasWorking != this.isWorking()) {
                this.sendSyncPacket();
            }
        } else {
            if (this.world.getBlockState(this.pos).getBlock() != ModBlocks.BlockVolCore) {
                this.invalidate();
                return;
            }
            if ((this.syncTime & 15) == 0 && this.remainedPower > CONSUMEDSPEED && this.btnActive) {
                int maxpar = (3 - ClientProxy.getMineraft().gameSettings.particleSetting) * 25;
                for (int i = 0; i < maxpar; ++i) {
                    double dx = this.pos.getX() + 0.5 + (this.rand.nextFloat() * 13.0f) - 6.5;
                    double dy = this.pos.getY() + 1.5 + (this.rand.nextFloat() * 13.0f) - 4.5;
                    double dz = this.pos.getZ() + 0.5 + (this.rand.nextFloat() * 13.0f) - 6.5;
                    ParticleHelper.spawnAttackParticleAt(dx, dy, dz, 0.0, 0.05, 0.0, (byte)37);
                }
            }
        }
    }

    private void volcoreFunction() {
        double dx = this.pos.getX() + 0.5;
        double dy = this.pos.getY() + 0.5;
        double dz = this.pos.getZ() + 0.5;
        AxisAlignedBB box = new AxisAlignedBB(dx - 6.0, dy - 6.0, dz - 6.0, dx + 6.0, dy + 6.0, dz + 6.0);
        if (BlockHelper.checkBlockNearbyIsLiquid(this.world, this.pos.getX(), this.pos.getY(), this.pos.getZ(), 1)) {
            List<BasicEntityShip> slist = this.world.getEntitiesWithinAABB(BasicEntityShip.class, box);
            for (BasicEntityShip s : slist) {
                if (EntityHelper.checkShipOutOfCombat(s) && EntityHelper.checkEntityIsInLiquid(s)) {
                    if (s.getHealth() < s.getMaxHealth()) {
                        s.heal(s.getMaxHealth() * 0.01f + 4.0f);
                    }
                    if (s.getMorale() < 9180) {
                        s.addMorale(80);
                    }
                }
            }
        } else {
            List<EntityLivingBase> slist = this.world.getEntitiesWithinAABB(EntityLivingBase.class, box);
            for (EntityLivingBase ent : slist) {
                if (ent instanceof BasicEntityShip || ent instanceof BasicEntityMount || ent instanceof BasicEntityAirplane || ent instanceof BasicEntityShipHostile) {
                    return;
                }
                ent.setFire(2);
                ent.attackEntityFrom(DamageSource.ON_FIRE, 4.0f);
                int emotes;
                switch (this.world.rand.nextInt(5)) {
                    case 0:
                        emotes = 12;
                        break;
                    case 1:
                        emotes = 28;
                        break;
                    case 2:
                        emotes = 0;
                        break;
                    default:
                        emotes = 2;
                }
                NetworkRegistry.TargetPoint point = new NetworkRegistry.TargetPoint(ent.dimension, ent.posX, ent.posY, ent.posZ, 48.0);
                CommonProxy.channelP.sendToAllAround(new S2CSpawnParticle(ent, 36, ent.height * 0.75f, 0.0, emotes), point);
            }
        }
    }

    public int getPowerRemainingScaled(int i) {
        return this.remainedPower * i / POWERMAX;
    }

    public int getPowerRemained() {
        return this.remainedPower;
    }

    public void setPowerRemained(int par1) {
        this.remainedPower = par1;
    }

    @Override
    public int getField(int id) {
        if(id == 0){
            return this.btnActive ? 1 : 0;
        }
        return 0;
    }

    @Override
    public void setField(int id, int value) {
        if(id == 0){
            this.btnActive = value != 0;
        }
    }

    @Override
    public int getFieldCount() {
        return 1;
    }

    static {
        ALLSLOTS = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    }
}
