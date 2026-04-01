package com.lulan.shincolle.item;

import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.utility.EntityHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Objects;
public class BasicEntityItem
extends Entity {
    private static final DataParameter<ItemStack> ITEM = EntityDataManager.createKey(EntityItem.class, DataSerializers.ITEM_STACK);
    private int delayBeforeCanPickup;
    private String owner;

    public BasicEntityItem(World world) {
        super(world);
        this.setSize(0.8f, 0.8f);
    }

    public BasicEntityItem(World world, double x, double y, double z, ItemStack item) {
        this(world);
        this.setPosition(x, y, z);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.isImmuneToFire = true;
        this.onGround = true;
        this.noClip = false;
        this.delayBeforeCanPickup = 10;
        this.setEntityItemStack(item);
        this.firstUpdate = false;
    }

    protected void entityInit() {
        this.getDataManager().register(ITEM, ItemStack.EMPTY);
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    public boolean attackEntityFrom(DamageSource attacker, float dmg) {
        return false;
    }

    public boolean canBeAttackedWithItem() {
        return false;
    }

    public Entity changeDimension(int dimensionIn) {
        return null;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void onUpdate() {
        if (this.world.isRemote) {
            if ((this.ticksExisted & 0x1F) == 0 && this.rand.nextInt(3) == 0) {
                this.world.playSound(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5f, this.rand.nextFloat() * 0.4f + 0.8f, false);
            }
        } else if (this.ticksExisted > ConfigHandler.despawnEgg && !(this.getEntityItem()).hasTagCompound()) {
            this.setDead();
        }
        this.setPosition(this.posX, this.posY, this.posZ);
        if (this.getEntityItem() == null) {
            this.setDead();
        } else {
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
            this.noClip = this.pushOutOfBlocks(this.posX, (this.getEntityBoundingBox().minY + this.getEntityBoundingBox().maxY) / 2.0, this.posZ);
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            ItemStack item = this.getDataManager().get(ITEM);
            if (!item.isEmpty() && item.getCount() <= 0) {
                this.setDead();
            }
        }
        if (this.delayBeforeCanPickup > 0) {
            --this.delayBeforeCanPickup;
        }
    }

    protected void dealFireDamage(int fire) {
    }

    public void setFire(int time) {
    }

    protected void setOnFireFromLava() {
    }

    public boolean handleWaterMovement() {
        return false;
    }

    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
    }

    public void fall(float distance, float damageMultiplier) {
    }

    @SideOnly(value=Side.CLIENT)
    public boolean canRenderOnFire() {
        return false;
    }

    public boolean shouldRenderInPass(int pass) {
        return true;
    }

    public boolean isInvisible() {
        return false;
    }

    public void setInvisible(boolean par1) {
    }

    public ItemStack getEntityItem() {
        ItemStack itemstack = this.getDataManager().get(ITEM);
        if (itemstack.isEmpty()) {
            return new ItemStack(Blocks.STONE);
        }
        return itemstack;
    }

    public void setEntityItemStack(@Nullable ItemStack stack) {
        this.getDataManager().set(ITEM, stack != null ? stack : ItemStack.EMPTY);
        this.getDataManager().setDirty(ITEM);
    }

    public void onCollideWithPlayer(EntityPlayer player) {
        if (!this.world.isRemote && !this.isDead) {
            if (this.delayBeforeCanPickup > 0) {
                return;
            }
            ItemStack itemstack = this.getEntityItem();
            if (this.delayBeforeCanPickup <= 0) {
                if (EntityHelper.checkOP(player)) {
                    player.inventory.addItemStackToInventory(itemstack);
                } else if (itemstack.getItem() == ModItems.ShipSpawnEgg) {
                    NBTTagCompound nbt = itemstack.getTagCompound();
                    if (nbt != null) {
                        String pid1 = nbt.getString("ownername");
                        String pid2 = player.getName();
                        if (pid1.length() <= 1) {
                            String uuid1 = nbt.getString("owner");
                            String uuid2 = player.getUniqueID().toString();
                            if (uuid2.equals(uuid1)) {
                                player.inventory.addItemStackToInventory(itemstack);
                            }
                        } else if (pid1.equals(pid2)) {
                            player.inventory.addItemStackToInventory(itemstack);
                        }
                    } else {
                        player.inventory.addItemStackToInventory(itemstack);
                    }
                } else {
                    player.inventory.addItemStackToInventory(itemstack);
                }
                if (!this.isSilent()) {
                    this.world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.0f) * 2.0f);
                }
            }
            if (itemstack.getCount() <= 0) {
                this.setDead();
            }
        }
    }

    protected void readEntityFromNBT(NBTTagCompound nbt) {
        NBTTagCompound itemtag = nbt.getCompoundTag("Item");
        this.setEntityItemStack(new ItemStack(itemtag));
        ItemStack item = this.getDataManager().get(ITEM);
        if (item.isEmpty() || item.getCount() <= 0) {
            this.setDead();
        }
        if (nbt.hasKey("PickupDelay")) {
            this.delayBeforeCanPickup = nbt.getShort("PickupDelay");
        }
        if (nbt.hasKey("Owner")) {
            this.owner = nbt.getString("Owner");
        }
    }

    protected void writeEntityToNBT(NBTTagCompound nbt) {
        if (this.getEntityItem() != null) {
            nbt.setTag("Item", this.getEntityItem().writeToNBT(new NBTTagCompound()));
        }
        if (this.getOwner() != null) {
            nbt.setString("Owner", this.owner);
        }
        nbt.setShort("PickupDelay", (short)this.delayBeforeCanPickup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicEntityItem)) return false;
        BasicEntityItem that = (BasicEntityItem) o;
        return Objects.equals(this.getUniqueID(), that.getUniqueID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUniqueID());
    }
}
