package com.lulan.shincolle.tileentity;

import com.lulan.shincolle.block.BlockWaypoint;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.init.ModBlocks;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.item.PointerItem;
import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.PacketHelper;
import com.lulan.shincolle.utility.ParticleHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;

public class TileEntityWaypoint
extends BasicTileEntity
implements ITileWaypoint,
ITickable {
    private int tick = 0;
    private int wpstay = 0;
    private int playerUID = 0;
    private BlockPos lastPos = BlockPos.ORIGIN;
    private BlockPos nextPos = BlockPos.ORIGIN;
    private BlockPos chestPos = BlockPos.ORIGIN;
    public EntityPlayer owner;

    @Override
    public String getRegName() {
        return "TileEntityWaypoint";
    }

    public byte getPacketID(int type) {
        if(type == 0){
            return 4;
        }
        return -1;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.wpstay = nbt.getInteger("wpstay");
        this.playerUID = nbt.getInteger("pid");
        int[] pos = nbt.getIntArray("lastPos");
        this.lastPos = pos.length == 3 ? new BlockPos(pos[0], pos[1], pos[2]) : BlockPos.ORIGIN;
        pos = nbt.getIntArray("nextPos");
        this.nextPos = pos.length == 3 ? new BlockPos(pos[0], pos[1], pos[2]) : BlockPos.ORIGIN;
        pos = nbt.getIntArray("chestPos");
        this.chestPos = pos.length == 3 ? new BlockPos(pos[0], pos[1], pos[2]) : BlockPos.ORIGIN;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("wpstay", this.wpstay);
        nbt.setInteger("pid", this.playerUID);
        nbt.setIntArray("lastPos", new int[]{this.lastPos.getX(), this.lastPos.getY(), this.lastPos.getZ()});
        nbt.setIntArray("nextPos", new int[]{this.nextPos.getX(), this.nextPos.getY(), this.nextPos.getZ()});
        nbt.setIntArray("chestPos", new int[]{this.chestPos.getX(), this.chestPos.getY(), this.chestPos.getZ()});
        return nbt;
    }

    public void update() {
        ++this.tick;
        if (this.world.isRemote) {
            if (this.world.getBlockState(this.pos).getBlock() != ModBlocks.BlockWaypoint) {
                this.invalidate();
                return;
            }
            EntityPlayer player = ClientProxy.getClientPlayer();
            ItemStack item = player.getHeldItem(EnumHand.MAIN_HAND);
            if (((item.getItem() instanceof ItemBlock && (BlockWaypoint.INSTANCE.getRegistryName().toString()).equals(((ItemBlock) item.getItem()).getBlock().getRegistryName().toString())) || item.getItem() == ModItems.TargetWrench || item.getItem() instanceof PointerItem && item.getItemDamage() < 3) && (this.tick & 7) == 0) {
                ParticleHelper.spawnAttackParticleAt(this.pos.getX() + 0.5, this.pos.getY() - 0.25, this.pos.getZ() + 0.5, 0.2, 9.0, 0.0, (byte)25);
                if ((this.tick & 0xF) == 0) {
                    if (this.nextPos.getY() > 0) {
                        double dx = (this.nextPos.getX() - this.pos.getX()) * 0.01;
                        double dy = (this.nextPos.getY() - this.pos.getY()) * 0.01;
                        double dz = (this.nextPos.getZ() - this.pos.getZ()) * 0.01;
                        ParticleHelper.spawnAttackParticleAt(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5, dx, dy, dz, (byte)38);
                    }
                    if (this.chestPos.getY() > 0) {
                        double dx = (this.chestPos.getX() - this.pos.getX()) * 0.01;
                        double dy = (this.chestPos.getY() - this.pos.getY()) * 0.01;
                        double dz = (this.chestPos.getZ() - this.pos.getZ()) * 0.01;
                        ParticleHelper.spawnAttackParticleAt(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5, dx, dy, dz, (byte)39);
                    }
                    if ((this.tick & 0x1F) == 0) {
                        if (this.lastPos.getY() > 0 || this.nextPos.getY() > 0 || this.chestPos.getY() > 0) {
                            net.minecraft.client.gui.FontRenderer fontRenderer = ClientProxy.getMineraft().getRenderManager().getFontRenderer();
                            int maxWidth = 0;
                            StringBuilder text = new StringBuilder();
                            if (this.owner != null) {
                                String name = TextFormatting.GREEN + this.owner.getName();
                                maxWidth = fontRenderer.getStringWidth(name);
                                text.append(name).append("\n");
                            }
                            String postext1 = "F: " + TextFormatting.LIGHT_PURPLE + this.lastPos.getX() + ", " + this.lastPos.getY() + ", " + this.lastPos.getZ();
                            String postext2 = "T: " + TextFormatting.AQUA + this.nextPos.getX() + ", " + this.nextPos.getY() + ", " + this.nextPos.getZ();
                            String postext3 = "C: " + TextFormatting.YELLOW + this.chestPos.getX() + ", " + this.chestPos.getY() + ", " + this.chestPos.getZ();
                            maxWidth = Math.max(maxWidth, fontRenderer.getStringWidth(postext1));
                            maxWidth = Math.max(maxWidth, fontRenderer.getStringWidth(postext2));
                            maxWidth = Math.max(maxWidth, fontRenderer.getStringWidth(postext3));
                            text.append(TextFormatting.WHITE).append(postext1).append("\n").append(TextFormatting.WHITE).append(postext2).append("\n").append(TextFormatting.WHITE).append(postext3);
                            ParticleHelper.spawnAttackParticleAt(text.toString(), this.pos.getX() + 0.5, this.pos.getY() + 1.9, this.pos.getZ() + 0.5, (byte)0, 4, maxWidth + 1);
                        }
                        ParticleHelper.spawnAttackParticleAt(this.pos.getX() + 0.5, this.pos.getY() - 0.25, this.pos.getZ() + 0.5, 0.2, 8.0, 0.0, (byte)25);
                    }
                }
            }
        } else {
            if ((this.tick & 0xF) == 0 && this.owner == null && this.playerUID > 0) {
                this.owner = EntityHelper.getEntityPlayerByUID(this.playerUID);
            }
            if ((this.playerUID > 0 || this.lastPos.getY() > 0 || this.nextPos.getY() > 0 || this.chestPos.getY() > 0) && this.tick > 128) {
                this.tick = 0;
                this.sendSyncPacket();
            }
        }
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
    public int getWpStayTime() {
        return BasicEntityShip.wpStayTime2Ticks(this.wpstay);
    }

    public void nextWpStayTime() {
        ++this.wpstay;
        if (this.wpstay > 16) {
            this.wpstay = 0;
        }
    }

    @Override
    public void setPlayerUID(int uid) {
        this.playerUID = uid;
        if (!this.world.isRemote) {
            PacketHelper.sendS2CEntitySync(0, this, this.world, this.pos, null);
        }
    }

    @Override
    public int getPlayerUID() {
        return this.playerUID;
    }

    @Override
    public Entity getHostEntity() {
        return null;
    }

    @Override
    public void setPairedChest(BlockPos pos) {
        if (pos != null) {
            TileEntity tile = this.world.getTileEntity(pos);
            if (tile instanceof IInventory) {
                this.chestPos = pos;
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
