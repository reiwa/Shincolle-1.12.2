package com.lulan.shincolle.block;

import com.lulan.shincolle.client.render.block.RenderChair;
import com.lulan.shincolle.tileentity.TileEntityChair;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class BlockChair extends BasicBlockContainer {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockChair";
    public static final BlockChair INSTANCE = new BlockChair();

    public BlockChair() {
        super(Material.WOOD);
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setResistance(60.0f);
        setHardness(1.0f);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityChair();
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
    @SideOnly(value= Side.CLIENT)
    public void initModel() {
        super.initModel();
        ModelLoader.setCustomStateMapper(this, new StateMap.Builder().ignore(BlockHorizontal.FACING).build());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChair.class, new RenderChair());
    }

    @Deprecated
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Deprecated
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Deprecated
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        EnumFacing playerFacing = placer.getHorizontalFacing().getOpposite();
        worldIn.setBlockState(pos, state.withProperty(FACING, playerFacing), 2);
    }

    @Override
    public boolean onBlockActivated(
        World world, BlockPos pos, IBlockState state,
        EntityPlayer player, EnumHand hand,
        EnumFacing side, float hitX, float hitY, float hitZ
    ) {
        if (!world.isRemote) {
            TileEntity te = world.getTileEntity(pos);
            if (te instanceof TileEntityChair) {
                ((TileEntityChair) te).sit(player);
            }
        }
        return true;
    }

    @Deprecated
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.8D, 1.0D);
    }

    @Deprecated
    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D).offset(pos);
    }

    @Deprecated
    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos,
                                      AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
        AxisAlignedBB box = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
        if (entityBox.intersects(box.offset(pos))) {
            collidingBoxes.add(box.offset(pos));
        }
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