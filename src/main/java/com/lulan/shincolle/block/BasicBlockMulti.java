package com.lulan.shincolle.block;

import com.lulan.shincolle.ShinColle;
import com.lulan.shincolle.tileentity.BasicTileMulti;
import com.lulan.shincolle.tileentity.TileMultiGrudgeHeavy;
import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.MulitBlockHelper;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BasicBlockMulti extends BasicBlockContainer {

    public static final PropertyInteger MBS = PropertyInteger.create("mbs", 0, 2);

    protected BasicBlockMulti(Material material) {
        super(material);
    }

    @Override
    public boolean canDropInventory() {
        return true;
    }

    @Override
    public boolean canAlertBlockChange() {
        return true;
    }

    @Deprecated
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return state.getValue(MBS) > 0 ? EnumBlockRenderType.INVISIBLE : EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        Material mat = world.getBlockState(pos.offset(face)).getMaterial();
        return state.getValue(MBS) > 0 && (mat == Material.WATER || mat == Material.LAVA);
    }

    @Deprecated
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return state.getValue(MBS) <= 0;
    }

    @Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        return false;
    }

    public static void updateBlockState(int mbState, World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof BasicBlockMulti) {
            world.setBlockState(pos, state.withProperty(MBS, mbState), 2);
        }
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.setBlockState(pos, state.withProperty(MBS, 0), 2);
    }

    @Deprecated
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(MBS, meta > 2 ? 0 : meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(MBS);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, MBS);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        if (!world.isRemote) {
            TileEntity tile = world.getTileEntity(pos);
            if (tile instanceof BasicTileMulti) {
                BasicTileMulti multiTile = (BasicTileMulti) tile;
                if (multiTile.hasMaster()) {
                    BlockPos masterPos = multiTile.getMasterPos();
                    MulitBlockHelper.resetStructure(world, masterPos.getX(), masterPos.getY(), masterPos.getZ());
                }
            }
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        if (player.isSneaking()) {
            return false;
        }
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof BasicTileMulti) {
            BasicTileMulti multiTile = (BasicTileMulti) te;
            if (multiTile.hasMaster()) {
                if (multiTile.getGuiIntID() >= 0 && multiTile.getStructType() == 1) {
                    LogHelper.debug("DEBUG : open multi block GUI");
                    BlockPos masterPos = multiTile.getMasterPos();
                    player.openGui(ShinColle.instance, multiTile.getMaster().getGuiIntID(), world, masterPos.getX(), masterPos.getY(), masterPos.getZ());
                    return true;
                }
            } else if (multiTile instanceof TileMultiGrudgeHeavy) {
                int type = MulitBlockHelper.checkMultiBlockForm(world, pos.getX(), pos.getY(), pos.getZ());
                if (type > 0) {
                    MulitBlockHelper.setupStructure(world, pos.getX(), pos.getY(), pos.getZ(), type);
                    LogHelper.debug("DEBUG: check multi block form: type " + type);
                    return true;
                }
            }
        }
        return false;
    }
}