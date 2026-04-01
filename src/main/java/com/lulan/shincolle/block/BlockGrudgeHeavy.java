package com.lulan.shincolle.block;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.client.render.block.RenderLargeShipyard;
import com.lulan.shincolle.init.ModBlocks;
import com.lulan.shincolle.item.BasicEntityItem;
import com.lulan.shincolle.tileentity.TileMultiGrudgeHeavy;
import com.lulan.shincolle.utility.BlockHelper;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.MulitBlockHelper;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockGrudgeHeavy extends BasicBlockMulti {
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockGrudgeHeavy";
    public static final PropertyBool ACTIVE = PropertyBool.create("active");
    public BlockGrudgeHeavy() {
        super(Material.ROCK);
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setHarvestLevel("shovel", 0);
        setHardness(3.0f);
        setLightLevel(1.0f);
        setResistance(600.0f);
        setSoundType(SoundType.SAND);
        this.setDefaultState(this.blockState.getBaseState().withProperty(MBS, 0).withProperty(ACTIVE, false).withProperty(BlockHorizontal.FACING, EnumFacing.NORTH));
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return state.getValue(MBS) > 0;
    }

    @Deprecated
    @Override
    public IBlockState getStateFromMeta(int meta) {
        int mbs = meta > 2 ? 0 : meta;
        return this.getDefaultState().withProperty(MBS, mbs);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int mbs = state.getValue(MBS);
        return mbs > 2 ? 0 : mbs;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void initModel() {
        super.initModel();
        ModelLoader.setCustomStateMapper(this, new StateMap.Builder().ignore(BlockLiquid.LEVEL).build());
        ClientRegistry.bindTileEntitySpecialRenderer(TileMultiGrudgeHeavy.class, new RenderLargeShipyard());
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, MBS, ACTIVE, BlockHorizontal.FACING);
    }

    public static void updateBlockState(int state, World worldIn, BlockPos pos) {
        IBlockState oldState = worldIn.getBlockState(pos);
        TileEntity te = worldIn.getTileEntity(pos);
        boolean isActive = (state == 2);
        IBlockState newState = ModBlocks.BlockGrudgeHeavy
                .getDefaultState()
                .withProperty(MBS, state)
                .withProperty(ACTIVE, isActive)
                .withProperty(BlockHorizontal.FACING, oldState.getValue(BlockHorizontal.FACING));
        worldIn.setBlockState(pos, newState, 3);
        if (te != null) {
            te.validate();
            worldIn.setTileEntity(pos, te);
        }
    }

    @Deprecated
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        if ((Integer)state.getValue((IProperty)MBS) > 0) {
            return EnumBlockRenderType.INVISIBLE;
        }
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileMultiGrudgeHeavy();
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return true;
    }

    @Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        return false;
    }

    @Override
    public boolean canBeReplacedByLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
        return false;
    }

    @Deprecated
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        return new ArrayList<>();
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(world, pos, state, placer, stack);
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TileMultiGrudgeHeavy) {
            CapaTeitoku capa;
            TileMultiGrudgeHeavy tile2 = (TileMultiGrudgeHeavy) tile;
            if (placer instanceof EntityPlayer && (capa = CapaTeitoku.getTeitokuCapability((EntityPlayer) placer)) != null) {
                tile2.setPlayerUID(capa.getPlayerUID());
            }
            if (stack.hasTagCompound()) {
                NBTTagCompound nbt = stack.getTagCompound();
                int[] mats = nbt.getIntArray("mats");
                int fuel = nbt.getInteger("fuel");
                tile2.setMatStock(0, mats[0]);
                tile2.setMatStock(1, mats[1]);
                tile2.setMatStock(2, mats[2]);
                tile2.setMatStock(3, mats[3]);
                tile2.setPowerRemained(fuel);
            }
        }
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntity getTile = world.getTileEntity(pos);
        if (getTile instanceof TileMultiGrudgeHeavy) {
            TileMultiGrudgeHeavy tile = (TileMultiGrudgeHeavy) getTile;
            float ranf1 = world.rand.nextFloat() * 0.5f + 0.2f;
            float ranf2 = world.rand.nextFloat() * 0.5f + 0.2f;
            float ranf3 = world.rand.nextFloat() * 0.5f + 0.2f;
            BasicEntityItem item = new BasicEntityItem(world,
                    pos.getX() + ranf1, pos.getY() + ranf2, pos.getZ() + ranf3,
                    new ItemStack(ModBlocks.BlockGrudgeHeavy, 1, 0));
            NBTTagCompound nbt = new NBTTagCompound();
            int[] mats = new int[]{
                    tile.getMatBuild(0) + tile.getMatStock(0),
                    tile.getMatBuild(1) + tile.getMatStock(1),
                    tile.getMatBuild(2) + tile.getMatStock(2),
                    tile.getMatBuild(3) + tile.getMatStock(3)
            };
            nbt.setIntArray("mats", mats);
            nbt.setInteger("fuel", tile.getPowerRemained());
            item.getEntityItem().setTagCompound(nbt);
            world.spawnEntity(item);
        }
        IBlockState resetState = this.getDefaultState().withProperty(MBS, 0);
        super.breakBlock(world, pos, resetState);
    }
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
        if (rand.nextInt(50) == 0) {
            world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5f, rand.nextFloat() * 0.4f + 0.8f, false);
        }
    }

    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        IBlockState sideState = world.getBlockState(pos.offset(face));
        sideState.getMaterial();
        if (sideState.getMaterial().isLiquid()) {
            return true;
        }
        return state.isOpaqueCube();
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
        if (EntityHelper.checkOP(player) || BlockHelper.checkTileOwner(player, world.getTileEntity(pos))) {
            return super.removedByPlayer(state, world, pos, player, willHarvest);
        }
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
                                    EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        if (player.isSneaking()) {
            return false;
        }
        if (!state.getValue(MBS).equals(0)) {
            return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
        } else {
            int type = MulitBlockHelper.checkMultiBlockForm(world, pos.getX(), pos.getY(), pos.getZ());
            if (type > 0) {
                world.setBlockState(pos, state.withProperty(MBS, 1), 3);
                MulitBlockHelper.setupStructure(world, pos.getX(), pos.getY(), pos.getZ(), type);
                return true;
            }
            return false;
        }
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

