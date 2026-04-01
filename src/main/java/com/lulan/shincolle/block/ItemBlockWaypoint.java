package com.lulan.shincolle.block;

import com.lulan.shincolle.utility.EntityHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemBlockWaypoint
extends BasicItemBlock {
    public ItemBlockWaypoint(Block block) {
        super(block);
    }

    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        RayTraceResult hitobj;
        if (!world.isRemote && (hitobj = EntityHelper.getMouseoverTarget(world, player, 6.0, true, false, false)) != null) {
            if (hitobj.typeOfHit == RayTraceResult.Type.BLOCK) {
                BlockPos pos = hitobj.getBlockPos();
                if (!player.canPlayerEdit(pos, hitobj.sideHit, stack)) {
                    return new ActionResult<>(EnumActionResult.PASS, stack);
                }
                if (!this.block.isReplaceable(world, pos)) {
                    pos = pos.offset(hitobj.sideHit);
                }
                if (stack.getCount() != 0) {
                    int i = this.getMetadata(stack.getMetadata());
                    IBlockState state = this.block.getStateForPlacement(world, pos, hitobj.sideHit, 0.0f, 0.0f, 0.0f, i, player, hand);
                    if (this.placeBlockAt(stack, player, world, pos, hitobj.sideHit, 0.0f, 0.0f, 0.0f, state)) {
                        SoundType soundtype = world.getBlockState(pos).getBlock().getSoundType(world.getBlockState(pos), world, pos, player);
                        world.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0f) / 2.0f, soundtype.getPitch() * 0.8f);
                        if (!player.capabilities.isCreativeMode) {
                            stack.shrink(1);
                        }
                    }
                    return new ActionResult<>(EnumActionResult.SUCCESS, stack);
                }
            } else if (hitobj.typeOfHit == RayTraceResult.Type.ENTITY) {
                return new ActionResult<>(EnumActionResult.FAIL, stack);
            }
        }
        return super.onItemRightClick(world, player, hand);
    }
}
