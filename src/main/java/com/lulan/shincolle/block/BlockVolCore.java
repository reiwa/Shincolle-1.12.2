package com.lulan.shincolle.block;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.IShipOwner;
import com.lulan.shincolle.tileentity.TileEntityVolCore;
import com.lulan.shincolle.utility.BlockHelper;
import com.lulan.shincolle.utility.EntityHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockVolCore extends BasicBlockContainer {
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockVolCore";
    public static final BlockVolCore INSTANCE = new BlockVolCore();

    public BlockVolCore() {
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setHarvestLevel("pickaxe", 0);
        this.setHardness(6.0f);
        this.setResistance(600.0f);
        this.setLightLevel(1.0f);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityVolCore();
    }

    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
        if (EntityHelper.checkOP(player) || BlockHelper.checkTileOwner(player, world.getTileEntity(pos))) {
            return super.removedByPlayer(state, world, pos, player, willHarvest);
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
}
