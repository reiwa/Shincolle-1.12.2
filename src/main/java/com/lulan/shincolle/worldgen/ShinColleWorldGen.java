package com.lulan.shincolle.worldgen;

import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModBlocks;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ShinColleWorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case -1:
                this.generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 0:
                this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
                this.generateSea(world, random, chunkX * 16, chunkZ * 16);
                break;
            // case 1:
            default:
        }
    }

    private void generateNether(World world, Random rand, int x, int z) {
        WorldGenerator genNetherAbyss = new WorldGenMinable(
                ModBlocks.BlockNetherAbyss.getDefaultState(),
                8,
                BlockMatcher.forBlock(Blocks.NETHERRACK)
        );
        this.oreGenerator(genNetherAbyss, world, rand, x, z, 10, 1, 127);
    }

    private void oreGenerator(WorldGenerator genOres, World world, Random rand, int blockX, int blockZ, int spawnNum, int minY, int maxY) {
        int effectiveSpawnNum = spawnNum;
        BlockPos biomePos = new BlockPos(blockX, 0, blockZ);
        if (!world.isBlockLoaded(biomePos)) return;
        Biome biome = world.getBiome(biomePos);
        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)) {
            effectiveSpawnNum *= 3;
        }
        for (int i = 0; i < effectiveSpawnNum; ++i) {
            int x = blockX + rand.nextInt(16);
            int z = blockZ + rand.nextInt(16);
            int y = minY + rand.nextInt(maxY - minY);
            if (!world.isBlockLoaded(new BlockPos(x,y,z))) continue;
            genOres.generate(world, rand, new BlockPos(x, y, z));
        }
    }

    private void generateSurface(World world, Random rand, int x, int z) {
        WorldGenerator genPolymetal = new WorldGenMinable(ModBlocks.BlockPolymetalOre.getDefaultState(), 4 + rand.nextInt(4));
        this.oreGenerator(genPolymetal, world, rand, x, z, ConfigHandler.polyOreBaseRate, 3, 50);
    }

    private void generateSea(World world, Random rand, int x, int z) {
        if (!world.isBlockLoaded(new BlockPos(x, 0, z))) return;
        Biome biome = world.getBiome(new BlockPos(x, 0, z));
        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)) {
            WorldGenerator genPolyGravel = new WorldGenPolyGravel(2 + rand.nextInt(2));
            for (int i = 0; i < ConfigHandler.polyGravelBaseRate; ++i) {
                BlockPos blockpos = new BlockPos(x + rand.nextInt(16), 1, z + rand.nextInt(16));
                if (!world.isBlockLoaded(blockpos)) continue;
                BlockPos pos = world.getTopSolidOrLiquidBlock(blockpos);
                genPolyGravel.generate(world, rand, pos);
            }
        }
    }
}