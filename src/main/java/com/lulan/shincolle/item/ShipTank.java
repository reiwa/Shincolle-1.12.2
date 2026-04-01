package com.lulan.shincolle.item;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ShipTank
        extends BasicItem {
    private static final String NAME = "ShipTank";

    public ShipTank() {
        this.setUnlocalizedName(NAME);
        this.setRegistryName(NAME);
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
    }

    @Override
    @SideOnly(value= Side.CLIENT)
    public void initModel() {
        ModelResourceLocation[] models = new ModelResourceLocation[this.getTypes()];
        for (int i = 0; i < this.getTypes(); ++i) {
            models[i] = new ModelResourceLocation(this.getRegistryName() + String.valueOf(i), "inventory");
        }
        ModelBakery.registerItemVariants(this, models);
        for(int i = 0; i < this.getTypes(); ++i) {
            ModelLoader.setCustomModelResourceLocation(this, i, models[i]);
        }
    }

    @Override
    public int getTypes() {
        return 4;
    }

    public static int getCapacity(int meta) {
        switch (meta) {
            case 1: {
                return 128000;
            }
            case 2: {
                return 512000;
            }
            case 3: {
                return 2048000;
            }
            default:
        }
        return 32000;
    }

    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (player == null) {
            return new ActionResult<>(EnumActionResult.PASS, stack);
        }
        RayTraceResult raytraceresult = this.rayTrace(world, player, true);
        IFluidHandler fh = FluidUtil.getFluidHandler(stack);
        if (world.isRemote) {
            return new ActionResult<>(EnumActionResult.PASS, stack);
        }
        if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK) {
            BlockPos pos = raytraceresult.getBlockPos();
            if (!world.isBlockModifiable(player, pos) || !player.canPlayerEdit(pos.offset(raytraceresult.sideHit), raytraceresult.sideHit, stack)) {
                return new ActionResult<>(EnumActionResult.FAIL, stack);
            }
            IBlockState state = world.getBlockState(pos);
            TileEntity tile = world.getTileEntity(pos);
            FluidStack fs = null;
            if (state.getBlock() instanceof BlockLiquid) {
                if (state.getMaterial() == Material.WATER && state.getValue(BlockLiquid.LEVEL) == 0) {
                    fs = new FluidStack(FluidRegistry.WATER, 1000);
                    if (fh.fill(fs, false) > 0) {
                        world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
                        player.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0f, 1.0f);
                        fh.fill(fs, true);
                    }
                } else if (state.getMaterial() == Material.LAVA && state.getValue(BlockLiquid.LEVEL) == 0
                        && fh.fill(fs = new FluidStack(FluidRegistry.LAVA, 1000), false) > 0) {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
                    player.playSound(SoundEvents.ITEM_BUCKET_FILL_LAVA, 1.0f, 1.0f);
                    fh.fill(fs, true);
                }
            } else if (state.getBlock() instanceof IFluidBlock) {
                IFluidBlock fb = (IFluidBlock) state.getBlock();
                if (fb.canDrain(world, pos) && (fs = fb.drain(world, pos, false)) != null && fh.fill(fs, false) > 0) {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
                    player.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0f, 1.0f);
                    fh.fill(fs, true);
                    return new ActionResult<>(EnumActionResult.SUCCESS, stack);
                }
            } else if (tile != null && tile.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, raytraceresult.sideHit)) {
                IFluidHandler tilefh = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, EnumFacing.UP);
                if (tilefh != null && (player.isSneaking()
                        ? FluidUtil.tryFluidTransfer(fh, tilefh, 1000, true) != null
                        : FluidUtil.tryFluidTransfer(tilefh, fh, 1000, true) != null)) {
                    return new ActionResult<>(EnumActionResult.SUCCESS, stack);
                }
            } else {
                BlockPos pos2;
                boolean flag1 = world.getBlockState(pos).getBlock().isReplaceable(world, pos);
                pos2 = (flag1 && raytraceresult.sideHit == EnumFacing.UP) ? pos : pos.offset(raytraceresult.sideHit);
                if (!player.canPlayerEdit(pos2, raytraceresult.sideHit, stack)) {
                    return new ActionResult<>(EnumActionResult.FAIL, stack);
                }
                if (ShipTank.tryPlaceContainedLiquid(player, world, pos2, fh)) {
                    return new ActionResult<>(EnumActionResult.SUCCESS, stack);
                }
                return new ActionResult<>(EnumActionResult.FAIL, stack);
            }
        }
        return new ActionResult<>(EnumActionResult.PASS, stack);
    }

    public static boolean tryPlaceContainedLiquid(@Nullable EntityPlayer player, World world, BlockPos pos, IFluidHandler fh) {
        if (fh == null) {
            return false;
        }
        FluidStack fs = fh.drain(1000, false);
        if (fs == null || fs.amount < 1000 || fs.getFluid().getBlock() == null) {
            return false;
        }
        IBlockState state = world.getBlockState(pos);
        Material material = state.getMaterial();
        boolean flag = !material.isSolid();
        boolean flag1 = state.getBlock().isReplaceable(world, pos);
        if (!(world.isAirBlock(pos) || flag || flag1)) {
            return false;
        }
        if (world.provider.doesWaterVaporize() && fs.getFluid() == FluidRegistry.WATER) {
            world.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
            for (int k = 0; k < 8; ++k) {
                world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, pos.getX() + Math.random(), pos.getY() + Math.random(), pos.getZ() + Math.random(), 0.0, 0.0, 0.0);
            }
        } else {
            if (!world.isRemote && (flag || flag1) && !material.isLiquid()) {
                world.destroyBlock(pos, true);
            }
            world.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.setBlockState(pos, fs.getFluid().getBlock().getDefaultState(), 11);
        }
        fh.drain(1000, true);
        world.notifyNeighborsOfStateChange(pos, world.getBlockState(pos).getBlock(), true);
        return true;
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        int capacity = ShipTank.getCapacity(stack.getMetadata());
        IFluidHandlerItem handler = new FluidHandlerItemStack(stack, capacity);
        return new ICapabilityProvider() {
            @Override
            public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
                return capability == CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY;
            }

            @Override
            public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
                if (capability == CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY) {
                    return CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY.cast(handler);
                }
                return null;
            }
        };
    }

    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.GRAY + I18n.format("gui.shincolle:shiptank"));
        if (!stack.isEmpty()) {
            FluidStack fs = FluidUtil.getFluidContained(stack);
            String name = "";
            int amount = 0;
            int max = ShipTank.getCapacity(stack.getItemDamage());
            if (fs != null) {
                name = fs.getLocalizedName();
                amount = fs.amount;
            }
            tooltip.add(TextFormatting.AQUA + name + TextFormatting.WHITE + " " + amount + " / " + max + " mB");
        }
    }
}
