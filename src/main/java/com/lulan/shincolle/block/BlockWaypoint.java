package com.lulan.shincolle.block;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.IShipOwner;
import com.lulan.shincolle.item.TargetWrench;
import com.lulan.shincolle.tileentity.TileEntityWaypoint;
import com.lulan.shincolle.utility.BlockHelper;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.PacketHelper;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockWaypoint extends BasicBlockContainer {
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockWaypoint";
    public static final BlockWaypoint INSTANCE = new BlockWaypoint();

    public BlockWaypoint() {
        super(Material.GLASS);
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setHarvestLevel("null", -1);
        this.setResistance(0.0f);
        this.setHardness(0.0f);
        this.setLightOpacity(0);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityWaypoint();
    }

    @Override
    public boolean canDropInventory() {
        return false;
    }

    @Deprecated
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Deprecated
    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    @Deprecated
    public boolean isSideSolid(IBlockState basestate, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
        return true;
    }

    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        return false;
    }

    @Deprecated
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid) {
        return true;
    }

    @Deprecated
    public boolean isCollidable() {
        return true;
    }

    public boolean canBeReplacedByLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    public int getLightOpacity(IBlockState state, IBlockAccess world, BlockPos pos) {
        return 0;
    }

    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        Material mat = world.getBlockState(pos.offset(face)).getMaterial();
        return mat.isLiquid();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state,
                                    EntityPlayer player, EnumHand hand, EnumFacing side,
                                    float hitX, float hitY, float hitZ) {
        TileEntity tile = worldIn.getTileEntity(pos);
        if (!worldIn.isRemote && tile instanceof IShipOwner) {
            PacketHelper.sendS2CEntitySync(0, tile, tile.getWorld(), tile.getPos(), null);
        }
        if (!worldIn.isRemote && !player.isSneaking()) {
            ItemStack held = player.getHeldItem(hand);
            if (held != ItemStack.EMPTY && held.getItem() instanceof TargetWrench) {
                tile = worldIn.getTileEntity(pos);
                if (tile instanceof TileEntityWaypoint
                        && BlockHelper.checkTileOwner(player, tile)) {
                    TileEntityWaypoint wp = (TileEntityWaypoint) tile;
                    wp.nextWpStayTime();
                    player.sendMessage(new TextComponentString(
                            "Change waypoint stay time to: " +
                                    CalcHelper.tick2SecOrMin(wp.getWpStayTime())
                    ));
                    return true;
                }
                TileEntityWaypoint wpTile = (TileEntityWaypoint) tile;
                player.sendMessage(
                        new TextComponentTranslation("chat.shincolle:wrongowner")
                                .appendText(" " + wpTile.getPlayerUID())
                );
                return true;
            }
        }
        return false;
    }

    public int quantityDropped(Random random) {
        return 0;
    }

    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, @Nullable ItemStack stack) {
    }

    public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
        if (world != null && entity instanceof EntityPlayer) {
            if (EntityHelper.checkOP((EntityPlayer)entity)) {
                return true;
            }
            return BlockHelper.checkTileOwner(entity, world.getTileEntity(pos));
        }
        return false;
    }

    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
        if (EntityHelper.checkOP(player) || BlockHelper.checkTileOwner(player, world.getTileEntity(pos))) {
            ItemStack stack = new ItemStack(Item.getItemFromBlock(this));
            if (!world.isRemote && !player.inventory.addItemStackToInventory(stack)) {
                EntityItem entityitem = new EntityItem(world, player.posX, player.posY + 0.5, player.posZ, stack);
                world.spawnEntity(entityitem);
            }
            return world.setBlockState(pos, Blocks.AIR.getDefaultState(), world.isRemote ? 11 : 3);
        }
        return false;
    }

    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        CapaTeitoku capa;
        super.onBlockPlacedBy(world, pos, state, placer, stack);
        TileEntity tile = world.getTileEntity(pos);
        if (!world.isRemote && tile instanceof IShipOwner && placer instanceof EntityPlayer && (capa = CapaTeitoku.getTeitokuCapability((EntityPlayer)placer)) != null) {
            ((IShipOwner)tile).setPlayerUID(capa.getPlayerUID());
        }
    }

    public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
    }
}
