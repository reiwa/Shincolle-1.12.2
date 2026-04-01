package com.lulan.shincolle.block;

import com.lulan.shincolle.client.render.block.RenderDesk;
import com.lulan.shincolle.tileentity.TileEntityDesk;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDesk extends BasicBlockContainer {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockDesk";
    public static final BlockDesk INSTANCE = new BlockDesk();

    public BlockDesk() {
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setResistance(60.0f);
        setHarvestLevel("pickaxe", 0);
        setHardness(1.0f);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityDesk();
    }

    @Override
    public boolean canDropInventory() {
        return false;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Deprecated
    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing = EnumFacing.getHorizontal(meta);
        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void initModel() {
        super.initModel();
        ModelLoader.setCustomStateMapper(this, new StateMap.Builder().ignore(BlockHorizontal.FACING).build());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDesk.class, new RenderDesk());
    }

    @Deprecated
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        EnumFacing playerFacing = placer.getHorizontalFacing().getOpposite();
        worldIn.setBlockState(pos, state.withProperty(FACING, playerFacing), 2);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        super.onBlockHarvested(worldIn, pos, state, player);
        if (worldIn.isRemote) {
            worldIn.removeTileEntity(pos);
            worldIn.notifyBlockUpdate(pos, state, Blocks.AIR.getDefaultState(), 3);
            worldIn.markBlockRangeForRenderUpdate(pos, pos);
        }
    }
}
