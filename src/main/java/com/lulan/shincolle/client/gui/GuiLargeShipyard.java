package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.client.gui.inventory.ContainerLargeShipyard;
import com.lulan.shincolle.network.C2SGUIPackets;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.reference.Enums;
import com.lulan.shincolle.tileentity.TileMultiGrudgeHeavy;
import com.lulan.shincolle.utility.GuiHelper;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiLargeShipyard extends GuiContainer {
    private static final ResourceLocation TEXTURE_BG = new ResourceLocation("shincolle:textures/gui/GuiLargeShipyard.png");
    private final TileMultiGrudgeHeavy tile;
    private int xMouse;
    private int yMouse;
    private float tickGUI;
    private static final String ERROR_MSG_NO_MATERIAL = I18n.format("gui.shincolle:nomaterial");
    private static final String ERROR_MSG_NO_FUEL = I18n.format("gui.shincolle:nofuel");
    private static final int POWER_BAR_U = 208;
    private static final int POWER_BAR_WIDTH = 12;
    private static final int POWER_BAR_HEIGHT = 64;
    private static final int ICON_U = 208;
    private static final int ICON_V_BASE = 64;
    private static final int ICON_SIZE = 18;
    private static final int[] ANIM_ICON_V_OFFSETS = {103, 121, 139, 157, 175, 193};

    public GuiLargeShipyard(InventoryPlayer par1, TileMultiGrudgeHeavy par2) {
        super(new ContainerLargeShipyard(par1, par2));
        this.tile = par2;
        this.xSize = 208;
        this.ySize = 223;
        this.tickGUI = 0.0f;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float f) {
        super.drawScreen(mouseX, mouseY, f);
        this.xMouse = mouseX;
        this.yMouse = mouseY;
        this.tickGUI += 0.125f;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j) {
        drawBuildInfoText();
        drawStatusMessages();
        drawMaterialText();
        handleHoveringText();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(TEXTURE_BG);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        drawPowerBar();
        drawBuildIcons();
        drawSelectionHighlights();
    }

    @Override
    protected void mouseClicked(int posX, int posY, int mouseKey) throws IOException {
        super.mouseClicked(posX, posY, mouseKey);
        int xClick = posX - this.guiLeft;
        int yClick = posY - this.guiTop;
        int mainButtonClicked = GuiHelper.getButton(2, 0, xClick, yClick);
        if (mainButtonClicked != -1) {
            handleMainButtonClick(mainButtonClicked);
            return;
        }
        int amountButtonClicked = GuiHelper.getButton(2, this.tile.getSelectMat() + 1, xClick, yClick);
        if (amountButtonClicked != -1) {
            handleAmountButtonClick(amountButtonClicked);
        }
    }

    private void drawBuildInfoText() {
        String time = this.tile.getBuildTimeString();
        this.fontRenderer.drawString(time, 176 - this.fontRenderer.getStringWidth(time) / 2, 77, Enums.EnumColors.GRAY_MIDDLE.getValue());
    }

    private void drawStatusMessages() {
        String msg = null;
        if (this.tile.getPowerGoal() <= 0 && this.tile.getBuildType() != 0) {
            msg = ERROR_MSG_NO_MATERIAL;
        } else if (!this.tile.hasPowerRemained()) {
            msg = ERROR_MSG_NO_FUEL;
        }
        if (msg != null) {
            this.fontRenderer.drawString(msg, 105 - this.fontRenderer.getStringWidth(msg) / 2, 99, Enums.EnumColors.RED_LIGHT.getValue());
        }
    }

    private int getMaterialColor(int amount) {
        if (amount < 100) return Enums.EnumColors.RED_LIGHT.getValue();
        if (amount == 1000) return Enums.EnumColors.YELLOW.getValue();
        return Enums.EnumColors.WHITE.getValue();
    }

    private void drawMaterialText() {
        for (int i = 0; i < 4; i++) {
            String matBuild = String.valueOf(this.tile.getMatBuild(i));
            String matStock = String.valueOf(this.tile.getMatStock(i));
            int yPos = 20 + i * 19;
            int color = getMaterialColor(this.tile.getMatBuild(i));
            this.fontRenderer.drawString(matBuild, 73 - this.fontRenderer.getStringWidth(matBuild) / 2, yPos, color);
            this.fontRenderer.drawString(matStock, 125 - this.fontRenderer.getStringWidth(matStock) / 2, yPos, Enums.EnumColors.YELLOW.getValue());
        }
    }

    private void drawPowerBar() {
        if (this.tile.hasPowerRemained()) {
            int scaleBar = this.tile.getPowerRemainingScaled(POWER_BAR_HEIGHT);
            this.drawTexturedModalRect(this.guiLeft + 9, this.guiTop + 83 - scaleBar, POWER_BAR_U, POWER_BAR_HEIGHT - scaleBar, POWER_BAR_WIDTH, scaleBar);
        }
    }

    private void drawBuildIcons() {
        int buildType = this.tile.getBuildType();
        if (buildType == 0) return;
        boolean isEquip = buildType == 2 || buildType == 4;
        boolean isBuilding = buildType == 3 || buildType == 4;
        int x = this.guiLeft + (isEquip ? 177 : 157);
        int y = this.guiTop + 24;
        int v = isBuilding ? ANIM_ICON_V_OFFSETS[(int)this.tickGUI % 6] : ICON_V_BASE;
        this.drawTexturedModalRect(x, y, ICON_U, v, ICON_SIZE, ICON_SIZE);
    }

    private void drawSelectionHighlights() {
        int selectMat = this.tile.getSelectMat();
        this.drawTexturedModalRect(this.guiLeft + 50, this.guiTop + 8 + selectMat * 19, 0, 223, 48, 30);
        this.drawTexturedModalRect(this.guiLeft + 27, this.guiTop + 14 + selectMat * 19, ICON_U, ICON_V_BASE, ICON_SIZE, ICON_SIZE);
        if (this.tile.getInvMode() == 1) {
            this.drawTexturedModalRect(this.guiLeft + 23, this.guiTop + 92, 208, 82, 25, 20);
        }
    }

    private void handleHoveringText() {
        int mx = this.xMouse - this.guiLeft;
        int my = this.yMouse - this.guiTop;
        if (mx > 8 && mx < 22 && my > 19 && my < 84) {
            List<String> list = new ArrayList<>();
            String strFuel = String.valueOf(this.tile.getPowerRemained());
            list.add(strFuel);
            this.drawHoveringText(list, 3 - this.fontRenderer.getStringWidth(strFuel) / 2, 58, this.fontRenderer);
        }
    }

    private void handleMainButtonClick(int button) {
        switch (button) {
            case 0:
                handleBuildTypeChange(false);
                break;
            case 1:
                handleBuildTypeChange(true);
                break;
            case 2:
                int newInvMode = this.tile.getInvMode() == 0 ? 1 : 0;
                sendGUIPacket(1, newInvMode, 0);
                break;
            case 3: case 4: case 5: case 6:
                sendGUIPacket(2, button - 3, 0);
                break;
            case 7: case 8: case 9: case 10:
                sendGUIPacket(2, button - 7, 0);
                break;
            default:
                break;
        }
    }

    private void handleBuildTypeChange(boolean isEquip) {
        int currentType = this.tile.getBuildType();
        int newType;
        if (!isEquip) {
            newType = (currentType == 1) ? 3 : (currentType == 3 ? 0 : 1);
        } else {
            newType = (currentType == 2) ? 4 : (currentType == 4 ? 0 : 2);
        }
        sendGUIPacket(0, newType, 0);
    }

    private void handleAmountButtonClick(int button) {
        if (button >= 0 && button <= 7) {
            sendGUIPacket(3, this.tile.getSelectMat(), button);
        }
    }

    private void sendGUIPacket(int type, int value1, int value2) {
        LogHelper.debug("DEBUG: GUI click: Large Shipyard: type=" + type + " val1=" + value1 + " val2=" + value2);
        CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.tile, (byte)1, type, value1, value2));
    }
}