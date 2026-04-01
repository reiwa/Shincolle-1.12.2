package com.lulan.shincolle.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockAbyssium extends BasicBlock {
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockAbyssium";
    public static final BlockAbyssium INSTANCE = new BlockAbyssium();

    public BlockAbyssium() {
        super(Material.IRON);
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setHarvestLevel("pickaxe", 0);
        setHardness(3.0f);
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return true;
    }
}
