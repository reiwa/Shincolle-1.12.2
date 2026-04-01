package com.lulan.shincolle.client.render.block;

import com.lulan.shincolle.client.model.ModelBlockChair;
import com.lulan.shincolle.tileentity.BasicTileEntity;
import com.lulan.shincolle.tileentity.TileEntityChair;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderChair extends TileEntitySpecialRenderer<BasicTileEntity> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("shincolle:textures/blocks/blockchair.png");

    private final ModelBlockChair modelSingle = new ModelBlockChair();
    private final ModelBlockChair modelDouble = new ModelBlockChair();

    @Override
    public void render(BasicTileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        World world = te.getWorld();
        if (world == null) {
            float angle = 90.0f;
            this.bindTexture(TEXTURE);
            GlStateManager.pushMatrix();
            try {
                GlStateManager.translate((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
                GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(angle, 0.0f, 1.0f, 0.0f);
                this.modelSingle.render(0.0625f);
            } finally {
                GlStateManager.popMatrix();
            }
            return;
        }
        BlockPos pos = te.getPos();
        Block blockType = te.getBlockType();
        int meta = te.getRenderMetadata();
        EnumFacing facing = EnumFacing.NORTH;
        float angle;
        switch (meta) {
            case 0: facing = EnumFacing.SOUTH; angle = 180.0f; break;
            case 1: facing = EnumFacing.WEST;  angle = -90.0f; break;
            case 3: facing = EnumFacing.EAST;  angle = 90.0f;  break;
            default: angle = 0.0f; break;
        }
        BlockPos rightPos = pos.offset(facing.rotateY());
        boolean isRightAlreadyChained = this.canConnectTo(world, rightPos, facing.rotateY(), blockType, meta);
        boolean connectToRight = this.canConnectTo(world, pos, facing.rotateY(), blockType, meta) && !isRightAlreadyChained;
        boolean connectToLeft = this.canConnectTo(world, pos, facing.rotateYCCW(), blockType, meta);
        if (connectToRight) {
            return;
        }
        boolean isDouble = connectToLeft && !isRightAlreadyChained;
        this.bindTexture(TEXTURE);
        GlStateManager.pushMatrix();
        try {
            GlStateManager.translate((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
            GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
            GlStateManager.rotate(angle, 0.0f, 1.0f, 0.0f);
            if (isDouble) {
                this.modelDouble.render(0.0625f);
            } else {
                this.modelSingle.render(0.0625f);
            }
        } finally {
            GlStateManager.popMatrix();
        }
    }

    private boolean canConnectTo(World world, BlockPos pos, EnumFacing direction, Block requiredBlock, int requiredMeta) {
        BlockPos neighborPos = pos.offset(direction);
        IBlockState neighborState = world.getBlockState(neighborPos);
        if (neighborState.getBlock() == requiredBlock) {
            TileEntity neighborTe = world.getTileEntity(neighborPos);
            if (neighborTe instanceof TileEntityChair) {
                return ((BasicTileEntity) neighborTe).getRenderMetadata() == requiredMeta;
            }
        }
        return false;
    }
}