package com.lulan.shincolle.item;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.intermod.MetamorphHelper;
import com.lulan.shincolle.network.C2SInputPackets;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.tileentity.ITileWaypoint;
import com.lulan.shincolle.tileentity.TileEntityCrane;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;
public class TargetWrench
        extends BasicItem {
    private static final String NAME = "TargetWrench";
    private BlockPos[] tilePoint;
    private int pointID;

    public TargetWrench() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setMaxStackSize(1);
        this.setFull3D();
        this.tilePoint = new BlockPos[]{BlockPos.ORIGIN, BlockPos.ORIGIN};
        this.pointID = 0;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote && player.isSneaking()) {
            TileEntity tile = worldIn.getTileEntity(pos);
            if (tile instanceof TileEntityCrane || tile instanceof IInventory || tile instanceof ITileWaypoint) {
                this.tilePoint[this.pointID] = pos;
                this.switchPoint();
                this.setPair(player);
                return EnumActionResult.SUCCESS;
            }
            player.sendMessage(new TextComponentTranslation("chat.shincolle:wrench.wrongtile"));
            this.resetPos();
            return EnumActionResult.FAIL;
        }
        return EnumActionResult.PASS;
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (CommonProxy.activeMetamorph) {
            MetamorphHelper.acquireShipMorph(player, entity);
            return true;
        }
        return false;
    }

    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.YELLOW + I18n.format("gui.shincolle:wrench3"));
    }

    private void switchPoint() {
        this.pointID = this.pointID == 0 ? 1 : 0;
    }

    private void resetPos() {
        this.tilePoint = new BlockPos[]{BlockPos.ORIGIN, BlockPos.ORIGIN};
        this.pointID = 0;
    }

    private boolean setPair(EntityPlayer player) {
        if (this.tilePoint[0].getY() <= 0 || this.tilePoint[1].getY() <= 0) {
            return false;
        }
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        int uid = 0;
        if (capa != null) {
            uid = capa.getPlayerUID();
        }
        if (uid <= 0) {
            return false;
        }
        TileEntity[] tiles = new TileEntity[]{player.world.getTileEntity(this.tilePoint[0]), player.world.getTileEntity(this.tilePoint[1])};
        int dx = this.tilePoint[0].getX() - this.tilePoint[1].getX();
        int dy = this.tilePoint[0].getY() - this.tilePoint[1].getY();
        int dz = this.tilePoint[0].getZ() - this.tilePoint[1].getZ();
        if (dx == 0 && dy == 0 && dz == 0) {
            player.sendMessage(new TextComponentTranslation("chat.shincolle:wrench.samepoint"));
            this.resetPos();
            return false;
        }
        if (tiles[0] instanceof IInventory && !(tiles[0] instanceof ITileWaypoint) && tiles[1] instanceof ITileWaypoint || tiles[1] instanceof IInventory && !(tiles[1] instanceof ITileWaypoint) && tiles[0] instanceof ITileWaypoint) {
            BlockPos wpPos;
            BlockPos chestPos;
            if (tiles[0] instanceof ITileWaypoint) {
                wpPos = this.tilePoint[0];
                chestPos = this.tilePoint[1];
            } else {
                wpPos = this.tilePoint[1];
                chestPos = this.tilePoint[0];
            }
            CommonProxy.channelI.sendToServer(new C2SInputPackets((byte)9, uid, wpPos.getX(), wpPos.getY(), wpPos.getZ(), chestPos.getX(), chestPos.getY(), chestPos.getZ()));
            this.resetPos();
            return true;
        }
        if (tiles[0] instanceof ITileWaypoint && tiles[1] instanceof ITileWaypoint) {
            BlockPos posF = this.tilePoint[this.pointID];
            this.switchPoint();
            BlockPos posT = this.tilePoint[this.pointID];
            CommonProxy.channelI.sendToServer(new C2SInputPackets((byte)6, uid, posF.getX(), posF.getY(), posF.getZ(), posT.getX(), posT.getY(), posT.getZ()));
            this.resetPos();
            return true;
        }
        TextComponentTranslation str = new TextComponentTranslation("chat.shincolle:wrench.wrongtile");
        str.getStyle().setColor(TextFormatting.YELLOW);
        player.sendMessage(str);
        this.resetPos();
        return false;
    }
}
