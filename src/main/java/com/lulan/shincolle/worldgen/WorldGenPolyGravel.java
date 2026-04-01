package com.lulan.shincolle.worldgen;

import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenPolyGravel extends WorldGenerator {
    private final IBlockState genBlock = ModBlocks.BlockPolymetalGravel.getDefaultState();
    private final int numberOfBlocks;

    public WorldGenPolyGravel(int num) {
        this.numberOfBlocks = num;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        boolean isFrozen = world.getBlockState(pos.down()).getMaterial() == Material.ICE && world.getBlockState(pos.down(2)).getMaterial() == Material.WATER;
        if (isFrozen) {
            for (int newY = y - 3; newY > 3; --newY) {
                if (world.getBlockState(new BlockPos(x, newY, z)).getMaterial() != Material.WATER) {
                    y = newY;
                    break;
                }
            }
        }
        BlockPos checkPos = new BlockPos(x, y, z);
        if (world.getBlockState(checkPos).getMaterial() != Material.WATER || y > 55) {
            return false;
        }
        int radius = rand.nextInt(this.numberOfBlocks - 1) + 1;
        if (!world.isAreaLoaded(pos, radius, false)) {
            return false;
        }
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        for (int i1 = x - radius; i1 <= x + radius; ++i1) {
            for (int j1 = z - radius; j1 <= z + radius; ++j1) {
                int k1 = i1 - x;
                int l1 = j1 - z;
                if (k1 * k1 + l1 * l1 > radius * radius) {
                    continue;
                }
                for (int i2 = y - 1; i2 <= y + 1; ++i2) {
                    mutablePos.setPos(i1, i2, j1);
                    if (canReplace(world.getBlockState(mutablePos).getBlock())) {
                        world.setBlockState(mutablePos, this.genBlock, 2);
                    }
                }
            }
        }
        return true;
    }

    private boolean canReplace(Block block) {
        return (ConfigHandler.polyGravelBaseBlock[0] && block == Blocks.STONE) ||
                (ConfigHandler.polyGravelBaseBlock[1] && block == Blocks.GRAVEL) ||
                (ConfigHandler.polyGravelBaseBlock[2] && block == Blocks.SAND) ||
                (ConfigHandler.polyGravelBaseBlock[3] && block == Blocks.DIRT);
    }
}