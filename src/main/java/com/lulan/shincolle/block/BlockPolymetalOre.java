package com.lulan.shincolle.block;

import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.utility.ParticleHelper;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockPolymetalOre extends BasicBlock {
    public static final String MODID = "shincolle";
    public static final String NAME = "BlockPolymetalOre";
    public static final BlockPolymetalOre INSTANCE = new BlockPolymetalOre();
    private static final Random rand = new Random();

    public BlockPolymetalOre() {
        super(Material.IRON);
        setUnlocalizedName(NAME);
        setRegistryName(new ResourceLocation(MODID, NAME));
        setHarvestLevel("pickaxe", 1);
        setHardness(3.0f);
    }

    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            return (rand.nextInt(4) + 1) * (fortune + 1);
        }
        return 0;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.AbyssMetal;
    }

    public int damageDropped(IBlockState state) {
        return 1;
    }

    public int quantityDroppedWithBonus(int fortune, Random rand) {
        if (fortune > 0) {
            return 2 + rand.nextInt(fortune + 1);
        }
        return 1 + rand.nextInt(2);
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        return 10;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(3) == 0) return;
        List<EnumFacing> openSides = new ArrayList<>();
        for (EnumFacing side : EnumFacing.values()) {
            if (!worldIn.getBlockState(pos.offset(side)).isOpaqueCube()) {
                openSides.add(side);
            }
        }
        if (!openSides.isEmpty()) {
            EnumFacing chosenSide = openSides.get(rand.nextInt(openSides.size()));
            double x = pos.getX();
            double y = pos.getY();
            double z = pos.getZ();
            double randomX = rand.nextDouble();
            double randomY = rand.nextDouble();
            double randomZ = rand.nextDouble();
            double particleX = x + 0.5D;
            double particleY = y + 0.5D;
            double particleZ = z + 0.5D;
            switch (chosenSide) {
                case DOWN:
                    particleY = y;
                    particleX = x + randomX;
                    particleZ = z + randomZ;
                    break;
                case UP:
                    particleY = y + 1.0D;
                    particleX = x + randomX;
                    particleZ = z + randomZ;
                    break;
                case NORTH:
                    particleZ = z;
                    particleX = x + randomX;
                    particleY = y + randomY;
                    break;
                case SOUTH:
                    particleZ = z + 1.0D;
                    particleX = x + randomX;
                    particleY = y + randomY;
                    break;
                case WEST:
                    particleX = x;
                    particleY = y + randomY;
                    particleZ = z + randomZ;
                    break;
                case EAST:
                    particleX = x + 1.0D;
                    particleY = y + randomY;
                    particleZ = z + randomZ;
                    break;
            }
            ParticleHelper.spawnAttackParticleAt(particleX, particleY, particleZ, 0.0D, 0.0D, 0.0D, (byte)50);
        }
    }
}
