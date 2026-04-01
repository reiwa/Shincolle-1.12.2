package com.lulan.shincolle.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockGrudgeHeavyDeco extends BasicBlock {
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockGrudgeHeavyDeco";
    public static final BlockGrudgeHeavyDeco INSTANCE = new BlockGrudgeHeavyDeco();

    public BlockGrudgeHeavyDeco() {
        super(Material.SAND);
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setHarvestLevel("shovel", 0);
        setHardness(3.0f);
        this.setLightLevel(1.0f);
        this.setResistance(300.0f);
        this.setSoundType(SoundType.SAND);
    }

    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return true;
    }
}
