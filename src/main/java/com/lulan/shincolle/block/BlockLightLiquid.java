package com.lulan.shincolle.block;

import com.lulan.shincolle.tileentity.TileEntityLightBlock;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockLightLiquid extends BasicBlock {
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockLightLiquid";
    public static final BlockLightLiquid INSTANCE = new BlockLightLiquid();

    public BlockLightLiquid() {
        super(Material.PLANTS);
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        this.setLightOpacity(3);
        this.disableStats();
        this.setHardness(100.0f);
        this.setTickRandomly(false);
        this.setLightLevel(1.0f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
        ModelLoader.setCustomStateMapper(this, new StateMap.Builder().ignore(BlockLiquid.LEVEL).build());
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    public String getUnlocalizedName() {
        return String.format("tile.%s%s", "shincolle:", this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityLightBlock();
    }

    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        return false;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
    }

    @Deprecated
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Deprecated
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Deprecated
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
        return true;
    }

    @Deprecated
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState state = worldIn.getBlockState(pos);
        return state.getBlock().isReplaceable(worldIn, pos) && (state.getMaterial() == Material.WATER || state.getMaterial() == Material.AIR);
    }
}
