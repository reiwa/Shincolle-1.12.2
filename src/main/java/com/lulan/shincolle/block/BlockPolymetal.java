package com.lulan.shincolle.block;

import com.lulan.shincolle.tileentity.TileMultiPolymetal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPolymetal extends BasicBlockMulti {
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockPolymetal";
    public static final BlockPolymetal INSTANCE = new BlockPolymetal();

    public BlockPolymetal() {
        super(Material.IRON);
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setHarvestLevel("pickaxe", 0);
        setHardness(3.0f);
    }

    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileMultiPolymetal();
    }

    @Override
    public boolean canDropInventory() {
        return true;
    }

    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        IBlockState sideState = world.getBlockState(pos.offset(face));
        if (sideState != null && sideState.getMaterial() != null && sideState.getMaterial().isLiquid()) {
            return true;
        }
        return state.isOpaqueCube();
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos,
                                 IBlockState state, EntityPlayer player) {
        super.onBlockHarvested(worldIn, pos, state, player);
        if (worldIn.isRemote) {
            worldIn.removeTileEntity(pos);
            worldIn.notifyBlockUpdate(pos, state, Blocks.AIR.getDefaultState(), 3);
            worldIn.markBlockRangeForRenderUpdate(pos, pos);
        }
    }
}
