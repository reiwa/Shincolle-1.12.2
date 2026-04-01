package com.lulan.shincolle.block;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.IShipOwner;
import com.lulan.shincolle.tileentity.TileEntityCrane;
import com.lulan.shincolle.utility.BlockHelper;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.PacketHelper;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCrane extends BasicBlockContainer {
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockCrane";
    public static final BlockCrane INSTANCE = new BlockCrane();

    public BlockCrane() {
        super(Material.IRON);
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setResistance(10.0f);
        setHarvestLevel("pickaxe", 0);
        setHardness(1.0f);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityCrane();
    }

    @Override
    public boolean canDropInventory() {
        return false;
    }

    @Override
    public boolean canAlertBlockChange() {
        return true;
    }

    @Deprecated
    @Override
    public boolean isNormalCube(IBlockState state) {
        return false;
    }

    @Deprecated
    @Override
    public boolean canProvidePower(IBlockState state) {
        return true;
    }

    @Deprecated
    @Override
    public int getStrongPower(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return getWeakPower(state, world, pos, side);
    }

    @Deprecated
    @Override
    public int getWeakPower(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof TileEntityCrane) {
            TileEntityCrane crane = (TileEntityCrane) tile;
            if (crane.getRedMode() > 0 && crane.getRedTick() > 0) {
                return 15;
            }
        }
        return 0;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(world, pos, state, placer, stack);
        if (!world.isRemote && placer instanceof EntityPlayer) {
            CapaTeitoku capa = CapaTeitoku.getTeitokuCapability((EntityPlayer) placer);
            TileEntity tile = world.getTileEntity(pos);
            if (capa != null && tile instanceof IShipOwner) {
                ((IShipOwner) tile).setPlayerUID(capa.getPlayerUID());
            }
        }
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
        if (EntityHelper.checkOP(player) || BlockHelper.checkTileOwner(player, world.getTileEntity(pos))) {
            return super.removedByPlayer(state, world, pos, player, willHarvest);
        }
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntity tile;
        if (!world.isRemote && (tile = world.getTileEntity(pos)) instanceof IShipOwner) {
            PacketHelper.sendS2CEntitySync(0, tile, tile.getWorld(), tile.getPos(), null);
        }
        return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
    }
}
