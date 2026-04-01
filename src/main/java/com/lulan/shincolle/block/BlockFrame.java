package com.lulan.shincolle.block;

import com.lulan.shincolle.proxy.ClientProxy;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.Random;

public class BlockFrame extends BasicBlock {
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockFrame";
    public static final PropertyDirection FACING = PropertyDirection.create("facing", Arrays.asList(EnumFacing.NORTH, EnumFacing.EAST, EnumFacing.SOUTH, EnumFacing.WEST));

    public BlockFrame() {
        super(Material.GLASS);
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setHarvestLevel("pickaxe", 0);
        setHardness(0.1f);
        this.setResistance(40.0f);
        this.setLightOpacity(0);
        this.setTickRandomly(false);
        this.setSoundType(SoundType.METAL);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Deprecated
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }

    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World w, BlockPos pos, Random rand) {
    }

    public boolean getTickRandomly() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Deprecated
    public boolean isNormalCube(IBlockState state) {
        return false;
    }

    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
        return true;
    }

    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        if (world.isRemote && (entity.equals(ClientProxy.getClientPlayer()) || entity.equals(ClientProxy.getClientPlayer().getRidingEntity()))) {
            GameSettings keySet = ClientProxy.getGameSetting();
            if (keySet.keyBindForward.isKeyDown() || keySet.keyBindBack.isKeyDown() || keySet.keyBindLeft.isKeyDown() || keySet.keyBindRight.isKeyDown()) {
                ClientProxy.getClientPlayer().addVelocity(0.0, 0.4, 0.0);
                if (ClientProxy.getClientPlayer().getRidingEntity() != null) {
                    ClientProxy.getClientPlayer().getRidingEntity().addVelocity(0.0, 0.4, 0.0);
                }
            }
        }
        if (entity.motionY < -0.1) {
            entity.motionY = -0.1;
        } else if (entity.motionY > 0.4) {
            entity.motionY = 0.4;
        }
        if (entity.isSneaking()) {
            entity.motionY = 0.08;
        }
        entity.fallDistance = 0.0f;
    }

    public static EnumFacing getFacingFromEntity(EntityLivingBase entity) {
        return entity.getHorizontalFacing().getOpposite();
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.setBlockState(pos, state.withProperty(BlockHorizontal.FACING, BlockFrame.getFacingFromEntity(placer)), 2);
    }

    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        IBlockState sideState = world.getBlockState(pos.offset(face));
        if (sideState != null && sideState.getMaterial() != null && sideState.getMaterial().isLiquid()) {
            return true;
        }
        return state.isOpaqueCube();
    }
}
