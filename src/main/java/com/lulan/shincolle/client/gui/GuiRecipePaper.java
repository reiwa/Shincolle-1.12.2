package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.client.gui.inventory.ContainerRecipePaper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiRecipePaper
extends GuiContainer {
    private static final ResourceLocation guiTexture = new ResourceLocation("shincolle:textures/gui/GuiRecipePaper.png");

    public GuiRecipePaper(EntityPlayer player, ItemStack stack) {
        super(new ContainerRecipePaper(player.world, player.inventory, stack));
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float f) {
        super.drawScreen(mouseX, mouseY, f);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    protected void drawGuiContainerForegroundLayer(int i, int j) {
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableBlend();
        Minecraft.getMinecraft().getTextureManager().bindTexture(guiTexture);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        GlStateManager.disableBlend();
    }
}
