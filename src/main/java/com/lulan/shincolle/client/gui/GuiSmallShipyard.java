package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.client.gui.inventory.ContainerSmallShipyard;
import com.lulan.shincolle.network.C2SGUIPackets;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.tileentity.TileEntitySmallShipyard;
import com.lulan.shincolle.utility.GuiHelper;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.util.Collections;

public class GuiSmallShipyard extends GuiContainer {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("shincolle:textures/gui/GuiSmallShipyard.png");
    private final TileEntitySmallShipyard tile;
    private int mouseX;
    private int mouseY;
    private float guiTicks;

    private final String containerName;
    private final String errorMsgNoMaterial;
    private final String errorMsgNoFuel;

    public GuiSmallShipyard(InventoryPlayer playerInv, TileEntitySmallShipyard tileEntity) {
        super(new ContainerSmallShipyard(playerInv, tileEntity));
        this.tile = tileEntity;
        this.xSize = 176;
        this.ySize = 164;
        this.guiTicks = 0.0F;
        this.containerName = I18n.format("tile.shincolle:BlockSmallShipyard.name");
        this.errorMsgNoMaterial = I18n.format("gui.shincolle:nomaterial");
        this.errorMsgNoFuel = I18n.format("gui.shincolle:nofuel");
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.guiTicks += 0.125F;
        this.handleFuelTooltip();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRenderer.drawString(this.containerName, this.xSize / 2 - this.fontRenderer.getStringWidth(this.containerName) / 2, 6, 0x404040);
        String time = this.tile.getBuildTimeString();
        this.fontRenderer.drawString(time, 71 - this.fontRenderer.getStringWidth(time) / 2, 51, 0x404040);
        if (this.tile.getPowerGoal() <= 0) {
            this.fontRenderer.drawString(this.errorMsgNoMaterial, 80 - this.fontRenderer.getStringWidth(this.errorMsgNoMaterial) / 2, 67, 0xFF3333);
        } else if (!this.tile.hasRemainedPower()) {
            this.fontRenderer.drawString(this.errorMsgNoFuel, 80 - this.fontRenderer.getStringWidth(this.errorMsgNoFuel) / 2, 67, 0xFF3333);
        }
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(GUI_TEXTURE);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        if (this.tile.getPowerRemained() > 0) {
            int scaleBar = this.tile.getPowerRemainingScaled(31);
            this.drawTexturedModalRect(this.guiLeft + 10, this.guiTop + 48 - scaleBar, 176, 47 - scaleBar, 12, scaleBar);
        }
        drawBuildTypeIndicator();
    }

    private void drawBuildTypeIndicator() {
        int buildType = this.tile.getBuildType();
        if (buildType == 0) return;
        int u = 176;
        int v;
        int xOffset;
        boolean isAnimating = buildType == 3 || buildType == 4;
        if (buildType == 1 || buildType == 3) {
            xOffset = 123;
        } else {
            xOffset = 143;
        }
        if (isAnimating) {
            int frame = (int) this.guiTicks % 6;
            v = 65 + frame * 18;
        } else {
            v = 47;
        }
        this.drawTexturedModalRect(this.guiLeft + xOffset, this.guiTop + 17, u, v, 18, 18);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        int xClick = mouseX - this.guiLeft;
        int yClick = mouseY - this.guiTop;
        int clickedButton = GuiHelper.getButton(1, 0, xClick, yClick);
        if (clickedButton == -1) {
            return;
        }
        int currentBuildType = this.tile.getBuildType();
        int nextBuildType;
        switch (clickedButton) {
            case 0:
                if (currentBuildType == 1) {
                    nextBuildType = 3;
                } else if (currentBuildType == 3) {
                    nextBuildType = 0;
                } else {
                    nextBuildType = 1;
                }
                LogHelper.debug("GUI click: Set build type to SHIP: " + nextBuildType);
                break;
            case 1:
                if (currentBuildType == 2) {
                    nextBuildType = 4;
                } else if (currentBuildType == 4) {
                    nextBuildType = 0;
                } else {
                    nextBuildType = 2;
                }
                LogHelper.debug("GUI click: Set build type to EQUIP: " + nextBuildType);
                break;
            default:
                return;
        }
        CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.tile, (byte) 1, 0, nextBuildType, 0));
    }

    private void handleFuelTooltip() {
        boolean isHovering = this.mouseX >= this.guiLeft + 9 && this.mouseX < this.guiLeft + 23 &&
                this.mouseY >= this.guiTop + 17 && this.mouseY < this.guiTop + 49;
        if (isHovering) {
            String fuelText = String.valueOf(this.tile.getPowerRemained());
            this.drawHoveringText(Collections.singletonList(fuelText), this.mouseX - this.guiLeft, this.mouseY - this.guiTop);
        }
    }
}
