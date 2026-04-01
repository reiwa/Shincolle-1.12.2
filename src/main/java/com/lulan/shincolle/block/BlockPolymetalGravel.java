package com.lulan.shincolle.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockPolymetalGravel extends BasicBlock {
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockPolymetalGravel";
    public static final BlockPolymetalGravel INSTANCE = new BlockPolymetalGravel();

    public BlockPolymetalGravel() {
        super(Material.SAND);
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setHarvestLevel("shovel", 0);
        setHardness(0.8f);
        this.setSoundType(SoundType.SAND);
    }
}
