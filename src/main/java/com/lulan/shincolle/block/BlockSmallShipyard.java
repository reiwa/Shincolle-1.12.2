package com.lulan.shincolle.block;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.client.render.block.RenderSmallShipyard;
import com.lulan.shincolle.entity.IShipOwner;
import com.lulan.shincolle.tileentity.TileEntitySmallShipyard;
import com.lulan.shincolle.utility.BlockHelper;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.PacketHelper;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockSmallShipyard extends BasicBlockContainer {
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockSmallShipyard";
    public static final PropertyBool ACTIVE = PropertyBool.create("active");
    private static final double[] smoke1 = new double[]{0.72, 1.1, 0.55};
    private static final double[] smoke2 = new double[]{0.22, 0.8, 0.7};
    private static final double[] smoke3 = new double[]{0.47, 0.6, 0.25};

    public BlockSmallShipyard() {
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setHarvestLevel("pickaxe", 3);
        setHardness(10.0f);
        this.setLightLevel(4.0f);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntitySmallShipyard();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void initModel() {
        super.initModel();
        ModelLoader.setCustomStateMapper(this, new StateMap.Builder().ignore(BlockHorizontal.FACING, ACTIVE).build());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmallShipyard.class, new RenderSmallShipyard());
    }

    @Deprecated
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, BlockHorizontal.FACING, ACTIVE);
    }

    @Deprecated
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState()
                .withProperty(BlockHorizontal.FACING, EnumFacing.HORIZONTALS[meta & 3])
                .withProperty(ACTIVE, (meta & 8) > 0);

    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int meta = state.getValue(BlockHorizontal.FACING).getHorizontalIndex();
        if (state.getValue(ACTIVE)) meta |= 8;
        return meta;
    }

    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        Material mat = world.getBlockState(pos.offset(face)).getMaterial();
        return mat != null && mat.isLiquid();
    }

    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
        return false;
    }

    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
        double[] smokeR1;
        double[] smokeR2;
        double[] smokeR3;
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        smokeR1 = CalcHelper.rotateParticleByFace(smoke1[0], smoke1[1], smoke1[2], ((EnumFacing)state.getValue((IProperty)BlockHorizontal.FACING)).getIndex(), 1);
        smokeR2 = CalcHelper.rotateParticleByFace(smoke2[0], smoke2[1], smoke2[2], ((EnumFacing)state.getValue((IProperty)BlockHorizontal.FACING)).getIndex(), 1);
        smokeR3 = CalcHelper.rotateParticleByFace(smoke3[0], smoke3[1], smoke3[2], ((EnumFacing)state.getValue((IProperty)BlockHorizontal.FACING)).getIndex(), 1);
        if (((Boolean)state.getValue((IProperty)ACTIVE)).booleanValue()) {
            switch (rand.nextInt(3)) {
                case 0: {
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR1[0], y + smokeR1[1], z + smokeR1[2], 0.0, 0.0, 0.0);
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR1[0], y + smokeR1[1] + 0.1, z + smokeR1[2], 0.0, 0.005, 0.0);
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR1[0], y + smokeR1[1] + 0.2, z + smokeR1[2], 0.0, 0.01, 0.0);
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR3[0], y + smokeR3[1], z + smokeR3[2], 0.0, 0.0, 0.0);
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR3[0], y + smokeR3[1] + 0.1, z + smokeR3[2], 0.0, 0.01, 0.0);
                    break;
                }
                case 1: {
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR1[0], y + smokeR1[1], z + smokeR1[2], 0.0, 0.0, 0.0);
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR1[0], y + smokeR1[1] + 0.1, z + smokeR1[2], 0.0, 0.005, 0.0);
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR1[0], y + smokeR1[1] + 0.2, z + smokeR1[2], 0.0, 0.01, 0.0);
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR2[0], y + smokeR2[1], z + smokeR2[2], 0.0, 0.0, 0.0);
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR2[0], y + smokeR2[1] + 0.1, z + smokeR2[2], 0.0, 0.01, 0.0);
                    break;
                }
                case 2: {
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR2[0], y + smokeR2[1], z + smokeR2[2], 0.0, 0.0, 0.0);
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR2[0], y + smokeR2[1] + 0.1, z + smokeR2[2], 0.0, 0.01, 0.0);
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR3[0], y + smokeR3[1], z + smokeR3[2], 0.0, 0.0, 0.0);
                    world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + smokeR3[0], y + smokeR3[1] + 0.1, z + smokeR3[2], 0.0, 0.01, 0.0);
                    break;
                }
                default:
            }
        }
    }

    public static void updateBlockState(boolean isBuilding, World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state != null && state.getBlock() instanceof BlockSmallShipyard) {
            world.setBlockState(pos, world.getBlockState(pos).withProperty(ACTIVE, Boolean.valueOf(isBuilding)), 2);
        }
    }

    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
        if (EntityHelper.checkOP(player) || BlockHelper.checkTileOwner(player, world.getTileEntity(pos))) {
            return super.removedByPlayer(state, world, pos, player, willHarvest);
        }
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        CapaTeitoku capa;
        super.onBlockPlacedBy(world, pos, state, placer, stack);
        TileEntity tile = world.getTileEntity(pos);
        if (!world.isRemote && tile instanceof IShipOwner && placer instanceof EntityPlayer && (capa = CapaTeitoku.getTeitokuCapability((EntityPlayer)placer)) != null) {
            ((IShipOwner)tile).setPlayerUID(capa.getPlayerUID());
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntity tile = world.getTileEntity(pos);
        if (!world.isRemote && tile instanceof IShipOwner) {
            PacketHelper.sendS2CEntitySync(0, tile, tile.getWorld(), tile.getPos(), null);
        }
        return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
    }
}
