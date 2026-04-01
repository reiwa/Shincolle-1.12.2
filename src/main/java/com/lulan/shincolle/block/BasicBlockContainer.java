package com.lulan.shincolle.block;

import com.lulan.shincolle.ShinColle;
import com.lulan.shincolle.tileentity.BasicTileEntity;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BasicBlockContainer extends BasicBlock implements ITileEntityProvider {

    protected BasicBlockContainer() {
        this(Material.ROCK);
    }

    protected BasicBlockContainer(Material material) {
        this(material, material.getMaterialMapColor());
    }

    protected BasicBlockContainer(Material material, MapColor color) {
        super(material, color);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World worldIn, IBlockState state) {
        int meta = state.getBlock().getMetaFromState(state);
        return createNewTileEntity(worldIn, meta);
    }

    public boolean canDropInventory() {
        return true;
    }

    public boolean canAlertBlockChange() {
        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity tile = worldIn.getTileEntity(pos);
        if (this.canDropInventory() && tile instanceof IInventory) {
            InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) tile);
        }
        if (this.canAlertBlockChange()) {
            worldIn.updateComparatorOutputLevel(pos, this);
        }
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state,
                                    EntityPlayer player, EnumHand hand, EnumFacing facing,
                                    float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {
            return true;
        }
        TileEntity tile = worldIn.getTileEntity(pos);
        if (!player.isSneaking() && tile instanceof BasicTileEntity) {
            int guiId = ((BasicTileEntity) tile).getGuiIntID();
            if (guiId >= 0) {
                player.openGui(ShinColle.instance, guiId, worldIn,
                        pos.getX(), pos.getY(), pos.getZ());
                return true;
            }
        }
        return false;
    }
}
