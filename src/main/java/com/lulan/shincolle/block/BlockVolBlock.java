package com.lulan.shincolle.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockVolBlock extends BasicBlock {
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockVolBlock";
    public static final BlockVolBlock INSTANCE = new BlockVolBlock();

    public BlockVolBlock() {
        super(Material.SAND);
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setHarvestLevel("pickaxe", 0);
        this.setHardness(3.0f);
        this.setLightLevel(1.0f);
        this.setResistance(200.0f);
    }

    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return true;
    }
}
