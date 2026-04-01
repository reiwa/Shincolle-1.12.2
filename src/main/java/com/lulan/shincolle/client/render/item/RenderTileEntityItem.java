package com.lulan.shincolle.client.render.item;

import com.lulan.shincolle.init.ModBlocks;
import com.lulan.shincolle.tileentity.TileEntityChair;
import com.lulan.shincolle.tileentity.TileEntityDesk;
import com.lulan.shincolle.tileentity.TileEntitySmallShipyard;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class RenderTileEntityItem
extends TileEntityItemStackRenderer {
    private static final TileEntity SmallShipyard = new TileEntitySmallShipyard();
    private static final TileEntity Chair = new TileEntityChair();
    private static final TileEntity Desk = new TileEntityDesk();

    public void renderByItem(ItemStack itemStack) {
        Block block = Block.getBlockFromItem(itemStack.getItem());
        if (block == ModBlocks.BlockSmallShipyard) {
            TileEntityRendererDispatcher.instance.render(SmallShipyard, 0.0, 0.0, 0.0, 0.0f);
        } else if (block == ModBlocks.BlockChair) {
            TileEntityRendererDispatcher.instance.render(Chair, 0.0, 0.0, 0.0, 0.0f);
        } else if (block == ModBlocks.BlockDesk) {
            TileEntityRendererDispatcher.instance.render(Desk, 0.0, 0.0, 0.0, 0.0f);
        } else {
            super.renderByItem(itemStack);
        }
    }
}
