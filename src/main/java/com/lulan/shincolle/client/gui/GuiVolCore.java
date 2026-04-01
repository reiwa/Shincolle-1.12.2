package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.client.gui.inventory.ContainerVolCore;
import com.lulan.shincolle.network.C2SGUIPackets;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.tileentity.TileEntityVolCore;
import com.lulan.shincolle.utility.GuiHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.util.ArrayList;

public class GuiVolCore
extends GuiContainer {
    private static final ResourceLocation guiTexture = new ResourceLocation("shincolle:textures/gui/GuiVolCore.png");
    private final TileEntityVolCore tile;
    private int xMouse;
    private int yMouse;
    private boolean btnPower;
    private static final String conName = I18n.format("tile.shincolle:BlockVolCore.name");

    public GuiVolCore(InventoryPlayer par1, TileEntityVolCore par2) {
        super(new ContainerVolCore(par1, par2));
        this.tile = par2;
        this.xSize = 176;
        this.ySize = 166;
        this.updateButton();
    }

    public void drawScreen(int mouseX, int mouseY, float f) {
        super.drawScreen(mouseX, mouseY, f);
        this.xMouse = mouseX;
        this.yMouse = mouseY;
    }

    private void handleHoveringText() {
        if (this.xMouse > 36 + this.guiLeft && this.xMouse < 52 + this.guiLeft && this.yMouse > 27 + this.guiTop && this.yMouse < 61 + this.guiTop) {
            ArrayList<String> list = new ArrayList<>();
            String strFuel = String.valueOf(this.tile.getPowerRemained());
            int strLen = this.fontRenderer.getStringWidth(strFuel) / 2;
            list.add(strFuel);
            this.drawHoveringText(list, 10 - strLen, 52, this.fontRenderer);
        }
    }

    protected void drawGuiContainerForegroundLayer(int i, int j) {
        this.fontRenderer.drawString(conName, this.xSize / 2 - this.fontRenderer.getStringWidth(conName) / 2, 6, 0x404040);
        this.handleHoveringText();
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(guiTexture);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        this.updateButton();
        if (this.btnPower) {
            this.drawTexturedModalRect(this.guiLeft + 7, this.guiTop + 6, 12, 166, 13, 13);
        }
        if (this.tile.getPowerRemained() > 0) {
            int scaleBar = this.tile.getPowerRemainingScaled(31);
            this.drawTexturedModalRect(this.guiLeft + 38, this.guiTop + 59 - scaleBar, 0, 197 - scaleBar, 12, scaleBar);
        }
    }

    protected void mouseClicked(int posX, int posY, int key) throws IOException {
        super.mouseClicked(posX, posY, key);
        int xClick = posX - this.guiLeft;
        int yClick = posY - this.guiTop;
        this.updateButton();
        if(GuiHelper.getButton(6, 0, xClick, yClick) == 0){
            CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.tile, (byte)1, 0, this.btnPower ? 0 : 1, 0));
        }
    }

    private void updateButton() {
        this.btnPower = this.tile.getField(0) > 0;
    }
}
