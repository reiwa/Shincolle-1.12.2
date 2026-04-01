package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.client.gui.inventory.ContainerDesk;
import com.lulan.shincolle.crafting.ShipCalc;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.network.C2SGUIPackets;
import com.lulan.shincolle.network.C2SInputPackets;
import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.reference.Enums;
import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.team.TeamData;
import com.lulan.shincolle.tileentity.TileEntityDesk;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.GuiHelper;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.io.IOException;
import java.util.*;

public class GuiDesk extends GuiContainer {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("shincolle:textures/gui/guidesk.png");
    private static final ResourceLocation GUI_RADAR = new ResourceLocation("shincolle:textures/gui/guideskradar.png");
    private static final ResourceLocation GUI_BOOK = new ResourceLocation("shincolle:textures/gui/guideskbook.png");
    private static final ResourceLocation GUI_BOOK2 = new ResourceLocation("shincolle:textures/gui/guideskbook2.png");
    private static final ResourceLocation GUI_TEAM = new ResourceLocation("shincolle:textures/gui/guideskteam.png");
    private static final ResourceLocation GUI_TARGET = new ResourceLocation("shincolle:textures/gui/guidesktarget.png");
    private static final ResourceLocation GUI_NAME_ICON0 = new ResourceLocation("shincolle:textures/gui/guinameicon0.png");
    private static final ResourceLocation GUI_NAME_ICON1 = new ResourceLocation("shincolle:textures/gui/guinameicon1.png");
    private static final ResourceLocation GUI_NAME_ICON2 = new ResourceLocation("shincolle:textures/gui/guinameicon2.png");
    private static final String STR_POS = I18n.format("gui.shincolle:radar.position");
    private static final String STR_HEIGHT = I18n.format("gui.shincolle:radar.height");
    private static final String STR_TEAM_ID = I18n.format("gui.shincolle:team.teamid");
    private static final String STR_BREAK = I18n.format("gui.shincolle:team.break");
    private static final String STR_ALLY = I18n.format("gui.shincolle:team.ally");
    private static final String STR_OK = I18n.format("gui.shincolle:general.ok");
    private static final String STR_UNBAN = I18n.format("gui.shincolle:team.unban");
    private static final String STR_BAN = I18n.format("gui.shincolle:team.ban");
    private static final String STR_CANCEL = I18n.format("gui.shincolle:general.cancel");
    private static final String STR_ALLY_LIST = I18n.format("gui.shincolle:team.allylist");
    private static final String STR_BAN_LIST = I18n.format("gui.shincolle:team.banlist");
    private static final String STR_RENAME = I18n.format("gui.shincolle:team.rename");
    private static final String STR_DISBAND = I18n.format("gui.shincolle:team.disband");
    private static final String STR_CREATE = I18n.format("gui.shincolle:team.create");
    private static final String STR_NEUTRAL = I18n.format("gui.shincolle:team.neutral");
    private static final String STR_BELONG = I18n.format("gui.shincolle:team.belong");
    private static final String STR_ALLIED = I18n.format("gui.shincolle:team.allied");
    private static final String STR_HOSTILE = I18n.format("gui.shincolle:team.hostile");
    private static final String STR_REMOVE = I18n.format("gui.shincolle:target.remove");
    private final TileEntityDesk tile;
    public int tickGUI;
    private int xMouse;
    private int yMouse;
    private int tempCD;
    private int lastXMouse;
    private int lastYMouse;
    private int guiFunc;
    private final int type;
    private final float guiScale;
    private final float guiScaleInv;
    private final int[] listNum;
    private final int[] listClicked;
    private final EntityPlayer player;
    private final CapaTeitoku capa;
    private int radar_zoomLv;
    private final List<RadarEntity> shipList;
    private final List<RadarEntity> itemList;
    private int book_chapNum;
    private int book_pageNum;
    private int teamState;
    private int listFocus;
    private GuiTextField textField;
    private Entity targetEntity;
    private final ArrayList<String> tarList;
    private float targetScale;
    private float targetRotateX;
    private float targetRotateY;
    private float currentScale;
    private float currentRotateX;
    private float currentRotateY;
    private float prevScale;
    private float prevRotateX;
    private float prevRotateY;
    private BasicEntityShip shipModel;
    private BasicEntityMount shipMount;
    private int shipStats;
    private int shipMaxStats;
    private int[][] iconXY;
    private final ArrayList<Integer> selectedShips = new ArrayList<>();

    public GuiDesk(EntityPlayer player, TileEntityDesk tile, int type) {
        super(new ContainerDesk(player, tile, type));
        this.type = type;
        this.tile = tile;
        this.player = player;
        this.guiScale = 1.25f;
        this.guiScaleInv = 1.0f / this.guiScale;
        this.xSize = (int)(256.0f * this.guiScale);
        this.ySize = (int)(192.0f * this.guiScale);
        this.lastXMouse = 0;
        this.lastYMouse = 0;
        this.tickGUI = 0;
        this.tempCD = 60;
        if (type == 0) {
            this.updateDeskValue();
        } else {
            this.guiFunc = this.type;
            this.book_chapNum = 0;
            this.book_pageNum = 0;
            this.radar_zoomLv = 0;
        }
        this.capa = CapaTeitoku.getTeitokuCapability(ClientProxy.getClientPlayer());
        this.listNum = new int[]{0, 0, 0, 0, 0};
        this.listClicked = new int[]{-1, -1, -1, -1, -1};
        this.shipList = new ArrayList<>();
        this.itemList = new ArrayList<>();
        this.teamState = 0;
        this.listFocus = 1;
        this.tarList = new ArrayList<>();
        this.updateTargetClassList();
        this.targetScale = 30.0f;
        this.currentScale = 30.0f;
        this.prevScale = 30.0f;
        this.targetRotateX = 0.0f;
        this.currentRotateX = 0.0f;
        this.prevRotateX = 0.0f;
        this.targetRotateY = -30.0f;
        this.currentRotateY = -30.0f;
        this.prevRotateY = -30.0f;
        this.setShipModel(this.book_chapNum, this.book_pageNum);
        Keyboard.enableRepeatEvents(true);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.textField = new GuiTextField(1, this.fontRenderer, (int)((this.guiLeft + 10) * this.guiScale), (int)((this.guiTop + 24) * this.guiScale), 153, 12);
        this.textField.setTextColor(-1);
        this.textField.setDisabledTextColour(-1);
        this.textField.setEnableBackgroundDrawing(true);
        this.textField.setMaxStringLength(64);
        this.textField.setEnabled(false);
        this.textField.setFocused(false);
    }

    private void updateDeskValue() {
        this.guiFunc = this.tile.getField(0);
        this.book_chapNum = this.tile.getField(1);
        this.book_pageNum = this.tile.getField(2);
        this.radar_zoomLv = this.tile.getField(3);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float f) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(this.guiScale, this.guiScale, 1.0f);
        super.drawScreen(mouseX, mouseY, f);
        GlStateManager.popMatrix();
        this.xMouse = mouseX;
        this.yMouse = mouseY;
        ++this.tickGUI;
        if (this.tempCD > 0) {
            --this.tempCD;
        }
        GlStateManager.pushMatrix();
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
        if (this.teamState == 1 || this.teamState == 3) {
            this.textField.setEnabled(true);
            this.textField.drawTextBox();
        } else {
            this.textField.setEnabled(false);
        }
        GlStateManager.popMatrix();
    }

    private void handleHoveringText() {
        int x2 = (int)(this.xMouse * this.guiScaleInv);
        int y2 = (int)(this.yMouse * this.guiScaleInv);
        int mx = x2 - this.guiLeft;
        int my = y2 - this.guiTop;
        switch (this.guiFunc) {
            case 1:
                drawRadarHoverText(x2, y2, mx, my);
                break;
            case 2:
                drawBookHoverText(mx, my);
                break;
            default:
        }
    }

    private void drawRadarHoverText(int x2, int y2, int mx, int my) {
        ArrayList<String> list = new ArrayList<>();
        for (RadarEntity obj : this.shipList) {
            if (obj != null && obj.ship != null && x2 < obj.pixelx + 4.0 && x2 > obj.pixelx - 2.0 && y2 < obj.pixelz + 4.0 && y2 > obj.pixelz - 2.0) {
                list.add(obj.name);
            }
        }
        for (RadarEntity obj : this.itemList) {
            if (obj != null && x2 < obj.pixelx + 4.0 && x2 > obj.pixelx - 2.0 && y2 < obj.pixelz + 4.0 && y2 > obj.pixelz - 2.0) {
                list.add(obj.posX + ", " + obj.posY + ", " + obj.posZ);
            }
        }
        this.drawHoveringText(list, mx, my, this.fontRenderer);
    }

    private void drawBookHoverText(int mx, int my) {
        int getbtn = GuiHelper.getButton(3, 2, mx, my);
        if (getbtn > 1 && getbtn < 9) {
            String strChap = I18n.format("gui.shincolle:book.chap" + (getbtn - 2) + ".title");
            List<String> list = CalcHelper.stringConvNewlineToList(strChap);
            this.drawHoveringText(list, mx - this.fontRenderer.getStringWidth(strChap) - 20, my, this.fontRenderer);
            return;
        }
        int id = GuiBook.getIndexID(this.book_chapNum, this.book_pageNum);
        List<int[]> cont = Values.BookList.get(id);
        if (cont == null) return;
        for (int[] getc : cont) {
            if (getc == null || getc.length != 5 || getc[0] != 2 || (getc[1] != GuiBook.PageLeftCurrent && getc[1] != GuiBook.PageRightCurrent)) continue;
            int xa = ((getc[1] & 1) == 1) ? (getc[2] + GuiBook.Page0RX - 1) : (getc[2] + GuiBook.Page0LX - 1);
            int ya = getc[3] + GuiBook.Page0Y;
            if (mx > xa - 1 && mx < xa + 17 && my > ya - 1 && my < ya + 17) {
                this.renderToolTip(GuiBook.getItemStackForIcon(getc[4]), mx, my);
                break;
            }
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j) {
        switch (this.guiFunc) {
            case 1:
                this.drawRadarText();
                break;
            case 2:
                if (this.book_pageNum > 0 && (this.book_chapNum == 4 || this.book_chapNum == 5) && this.shipModel != null) {
                    String str = "No. " + this.book_pageNum;
                    this.fontRenderer.drawStringWithShadow(str, 55.0f, 32.0f, this.book_chapNum == 4 ? Enums.EnumColors.RED_DARK.getValue() : Enums.EnumColors.CYAN.getValue());
                }
                GuiBook.drawBookContent(this, this.fontRenderer, this.book_chapNum, this.book_pageNum);
                break;
            case 3:
                this.drawTeamText();
                break;
            case 4:
                this.drawTargetText();
                break;
            default:
        }
        this.handleHoveringText();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(GUI_TEXTURE);
        if (this.type == 0) {
            drawBaseBackground();
        }
        switch (this.guiFunc) {
            case 1: drawRadarBackground(); break;
            case 2: drawBookBackground(partialTicks); break;
            case 3: drawTeamBackground(); break;
            case 4: drawTargetBackground(partialTicks); break;
            default:
        }
    }

    private void drawBaseBackground() {
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, 256, 192);
        this.updateDeskValue();
        int u = (this.guiFunc - 1) * 16;
        int xOffset;
        switch(this.guiFunc) {
            case 1: xOffset = 3; break;
            case 2: xOffset = 22; break;
            case 3: xOffset = 41; break;
            case 4: xOffset = 60; break;
            default: return;
        }
        if (u >= 0) {
            this.drawTexturedModalRect(this.guiLeft + xOffset, this.guiTop + 2, u, 192, 16, 16);
        }
    }

    private void drawRadarBackground() {
        this.mc.getTextureManager().bindTexture(GUI_RADAR);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, 256, 192);
        int texty = 192 + (this.radar_zoomLv * 8);
        this.drawTexturedModalRect(this.guiLeft + 9, this.guiTop + 160, 24, texty, 44, 8);
        for (int i = 0; i < 5; ++i) {
            int actualShipIndex = this.listNum[0] + i;
            if (actualShipIndex < this.shipList.size() && this.selectedShips.contains(actualShipIndex)) {
                this.drawTexturedModalRect(this.guiLeft + 142, this.guiTop + 25 + i * 32, 68, 192, 108, 31);
            }
        }
        if (!this.selectedShips.isEmpty()) {
            this.drawTexturedModalRect(this.guiLeft + 88, this.guiTop + 159, 24, 216, 44, 10);
        }
        this.drawRadarIcon();
        this.drawMoraleIcon();
    }

    private void drawBookBackground(float partialTicks) {
        this.mc.getTextureManager().bindTexture(GUI_BOOK);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, 256, 192);
        if (this.xMouse < this.guiLeft + 137.0f * this.guiScale) {
            this.drawTexturedModalRect(this.guiLeft + 53, this.guiTop + 182, 0, 192, 18, 10);
        } else {
            this.drawTexturedModalRect(this.guiLeft + 175, this.guiTop + 182, 0, 202, 18, 10);
        }
        if (this.book_pageNum > 0 && (this.book_chapNum == 4 || this.book_chapNum == 5)) {
            this.drawShipModel(partialTicks);
        }
    }

    private void drawTeamBackground() {
        this.mc.getTextureManager().bindTexture(GUI_TEAM);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, 256, 192);
        this.drawTeamPic();
    }

    private void drawTargetBackground(float partialTicks) {
        this.mc.getTextureManager().bindTexture(GUI_TARGET);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, 256, 192);
        if (this.listClicked[2] > -1 && this.listClicked[2] < 13) {
            int cirY = 25 + this.listClicked[2] * 12;
            this.drawTexturedModalRect(this.guiLeft + 142, this.guiTop + cirY, 68, 192, 108, 31);
        }
        this.drawTargetModel(partialTicks);
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int wheel = Mouse.getEventDWheel();
        if (wheel != 0) {
            this.handleWheelMove(wheel > 0);
        }
    }

    private void handleWheelMove(boolean isWheelUp) {
        int listID = -1;
        switch (this.guiFunc) {
            case 1: listID = 0; break;
            case 3:
                if (this.xMouse - this.guiLeft > 138) {
                    listID = 1;
                } else if (this.teamState == 2) {
                    listID = 3;
                } else if (this.teamState == 4) {
                    listID = 4;
                }
                break;
            case 2:
            case 4:
                handleModelZoom(isWheelUp);
                return;
            default:
        }
        if (listID != -1) {
            scrollList(listID, isWheelUp);
        }
    }

    private void handleModelZoom(boolean isUp) {
        float change = isUp ? 4.0f : -4.0f;
        if (this.guiFunc == 2) change /= 1.7f;
        this.targetScale = MathHelper.clamp(this.targetScale + change, 5.0f, 200.0f);
    }

    private void scrollList(int listID, boolean isUp) {
        int listSize = getListSize(listID);
        if (listSize <= 0) return;

        if (isUp) {
            if (this.listNum[listID] > 0) {
                this.listNum[listID]--;
                this.listClicked[listID]++;
            }
        } else {
            if (this.listNum[listID] < listSize - 1) {
                this.listNum[listID]++;
                this.listClicked[listID]--;
            }
        }
        this.listNum[listID] = Math.max(0, this.listNum[listID]);
    }

    private int getListSize(int listID) {
        if (this.capa == null) return 0;
        switch (listID) {
            case 0: return this.shipList.size();
            case 1: return this.capa.getPlayerTeamDataMap() != null ? this.capa.getPlayerTeamDataMap().size() : 0;
            case 3: return this.capa.getPlayerTeamAllyList() != null ? this.capa.getPlayerTeamAllyList().size() : 0;
            case 4: return this.capa.getPlayerTeamBannedList() != null ? this.capa.getPlayerTeamBannedList().size() : 0;
            default: return 0;
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        this.textField.mouseClicked(mouseX, mouseY, mouseButton);
        int xClick = (int)(mouseX * this.guiScaleInv) - this.guiLeft;
        int yClick = (int)(mouseY * this.guiScaleInv) - this.guiTop;
        this.lastXMouse = mouseX;
        this.lastYMouse = mouseY;
        if (this.type == 0) {
            int getFunc = GuiHelper.getButton(3, 0, xClick, yClick);
            setDeskFunction(getFunc);
        }
        switch (this.guiFunc) {
            case 1: handleRadarClick(xClick, yClick); break;
            case 2: handleBookClick(xClick, yClick, mouseButton); break;
            case 3: handleTeamClick(xClick, yClick); break;
            case 4: handleTargetClick(xClick, yClick); break;
            default:
        }
        this.syncTileEntityC2S();
    }

    private void handleRadarClick(int xClick, int yClick) {
        int clickedButton = GuiHelper.getButton(3, 1, xClick, yClick);
        switch (clickedButton) {
            case 0: this.radar_zoomLv = (this.radar_zoomLv + 1) % 3; break;
            case 1:
                if (!this.selectedShips.isEmpty() && this.type == 0) {
                    sendWaypointPacket();
                }
                break;
            case 2: case 3: case 4: case 5: case 6:
                handleShipSelection(clickedButton - 2);
                break;
            default:
                if (!isShiftKeyDown()) {
                    this.selectedShips.clear();
                }
                break;
        }
    }

    private void sendWaypointPacket() {
        int[] shipIds = this.selectedShips.stream()
                .mapToInt(index -> {
                    if(index < this.shipList.size()){
                        RadarEntity re = this.shipList.get(index);
                        if(re != null && re.ship != null) return re.ship.getEntityId();
                    }
                    return -1;
                })
                .filter(id -> id != -1)
                .toArray();
        if(shipIds.length > 0) {
            int[] payload = new int[3 + shipIds.length];
            payload[0] = this.tile.getPos().getX();
            payload[1] = this.tile.getPos().getY();
            payload[2] = this.tile.getPos().getZ();
            System.arraycopy(shipIds, 0, payload, 3, shipIds.length);
            CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.player, (byte) 34, payload));
            this.mc.player.closeScreen();
        }
    }

    private void handleShipSelection(int clickedIndexInList) {
        int actualShipIndex = this.listNum[0] + clickedIndexInList;
        if (actualShipIndex >= this.shipList.size()) return;

        if (isShiftKeyDown()) {
            if (this.selectedShips.contains(actualShipIndex)) {
                this.selectedShips.remove(Integer.valueOf(actualShipIndex));
            } else {
                this.selectedShips.add(actualShipIndex);
            }
        } else {
            if (this.selectedShips.size() == 1 && this.selectedShips.get(0) == actualShipIndex) {
                openShipGUIbyIndex(actualShipIndex);
            } else {
                this.selectedShips.clear();
                this.selectedShips.add(actualShipIndex);
            }
        }
    }

    private void handleBookClick(int xClick, int yClick, int mouseKey) {
        int getbtn2 = GuiHelper.getButton(3, 5, xClick, yClick);
        if ((this.book_chapNum == 4 || this.book_chapNum == 5) && this.shipModel != null && getbtn2 < 0 && xClick > 15 && xClick < 115 && yClick > 150 && yClick < 170) {
            getbtn2 = 0;
        }
        if (getbtn2 >= 0) {
            handleBookModelControls(getbtn2);
        } else {
            int getbtn = GuiHelper.getButton(3, 2, xClick, yClick);
            handleBookNavigation(getbtn, mouseKey);
        }
    }

    private void handleBookModelControls(int btn) {
        if (this.shipModel == null) return;
        switch(btn) {
            case 0: break;
            case 1:
                this.shipModel.setSitting(!this.shipModel.isSitting());
                this.shipModel.setStateEmotion(1, this.shipModel.getRNG().nextInt(2) == 0 ? 4 : 0, false);
                this.shipModel.setStateEmotion(7, this.shipModel.getRNG().nextInt(2) == 0 ? 4 : 0, false);
                break;
            case 2:
                this.shipModel.setSprinting(!this.shipModel.isSprinting());
                if (this.shipMount != null) this.shipMount.setSprinting(this.shipModel.isSprinting());
                break;
            case 3:
                this.shipModel.setAttackTick(50);
                this.shipModel.setStateEmotion(5, this.shipModel.getRNG().nextInt(4), false);
                if (this.shipMount != null) this.shipMount.setAttackTick(50);
                break;
            case 4:
                this.shipModel.setStateEmotion(7, this.shipModel.getRNG().nextInt(2) == 0 ? 4 : 0, false);
                this.shipModel.setSneaking(this.shipModel.getRNG().nextInt(5) == 0);
                this.shipModel.setStateFlag(2, this.shipModel.getRNG().nextInt(8) == 0);
                this.shipModel.setStateEmotion(1, this.shipModel.getRNG().nextInt(10), false);
                if (this.shipMount != null) this.shipMount.setStateEmotion(1, this.shipMount.getRNG().nextInt(10), false);
                break;
            default:
                if(btn >= 5 && btn <= 20) {
                    this.shipModel.setStateEmotion(0, this.shipModel.getStateEmotion(0) ^ Values.N.Pow2[btn - 5], false);
                    if (this.shipModel.hasShipMounts()) this.setShipMount();
                }
                break;
        }
    }

    private void handleBookNavigation(int btn, int mouseKey) {
        switch(btn) {
            case 0:
                this.book_pageNum -= (mouseKey == 0 ? 1 : 10);
                if (this.book_pageNum < 0) this.book_pageNum = 0;
                this.setShipModel(this.book_chapNum, this.book_pageNum);
                break;
            case 1:
                this.book_pageNum += (mouseKey == 0 ? 1 : 10);
                int maxPage = GuiBook.getMaxPageNumber(this.book_chapNum);
                if (this.book_pageNum > maxPage) this.book_pageNum = maxPage;
                this.setShipModel(this.book_chapNum, this.book_pageNum);
                break;
            default:
                if(btn >= 2 && btn <= 8) {
                    this.book_chapNum = btn - 2;
                    this.book_pageNum = 0;
                }
                break;
        }
    }

    private void handleTeamClick(int xClick, int yClick) {
        int teamBtn = GuiHelper.getButton(3, 3, xClick, yClick);
        switch (teamBtn) {
            case 0: case 6: case 7: case 8:
                handleClickTeamState(teamBtn);
                break;
            case 1: case 2: case 3: case 4: case 5:
                this.listFocus = 1;
                this.listClicked[1] = teamBtn - 1;
                break;
            case 9: case 10: case 11:
                if (this.teamState == 2) {
                    this.listFocus = 3;
                    this.listClicked[3] = teamBtn - 9;
                } else if (this.teamState == 4) {
                    this.listFocus = 4;
                    this.listClicked[4] = teamBtn - 9;
                }
                break;
            default:
        }
    }

    private void handleClickTeamState(int btn) {
        switch (this.teamState) {
            case 0: handleClickTeamMain(btn); break;
            case 1: handleClickTeamCreate(btn); break;
            case 2: handleClickTeamAlly(btn); break;
            case 3: handleClickTeamRename(btn); break;
            case 4: handleClickTeamBan(btn); break;
            default:
        }
    }

    private void handleTargetClick(int xClick, int yClick) {
        this.updateTargetClassList();
        int targetBtn = GuiHelper.getButton(3, 4, xClick, yClick);
        if (targetBtn == 0) {
            int clicked = this.listNum[2] + this.listClicked[2];
            if (clicked >= 0 && clicked < this.tarList.size()) {
                String tarstr = this.tarList.get(clicked);
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.player, (byte)30, tarstr));
            }
        } else if (targetBtn >= 1 && targetBtn <= 13) {
            this.listClicked[2] = targetBtn - 1;
            this.getEntityByClick();
        }
    }

    @Override
    protected void mouseClickMove(int mx, int my, int button, long time) {
        super.mouseClickMove(mx, my, button, time);
        int dx = mx - this.lastXMouse;
        int dy = my - this.lastYMouse;
        this.lastXMouse = mx;
        this.lastYMouse = my;
        if (Math.abs(dx) > 20 || Math.abs(dy) > 20) return;
        int gx = (int)(mx * this.guiScaleInv - this.guiLeft);
        int gy = (int)(my * this.guiScaleInv - this.guiTop);
        if ((this.guiFunc == 4 || this.guiFunc == 2) && gx > 8 && gx < 117 && gy > 47 && gy < 154) {
            if (dx != 0) this.targetRotateY += dx * 3.0f;
            if (dy != 0) this.targetRotateX = MathHelper.clamp(this.targetRotateX + dy * 2.0f, -90.0f, 90.0f);
        }
    }

    private void setDeskFunction(int button) {
        if (button >= 0) {
            this.guiFunc = (this.guiFunc != button + 1) ? button + 1 : 0;
            this.syncTileEntityC2S();
        }
    }

    private void syncTileEntityC2S() {
        if (this.type == 0 && this.tile != null) {
            this.tile.setField(0, this.guiFunc);
            this.tile.setField(1, this.book_chapNum);
            this.tile.setField(2, this.book_pageNum);
            this.tile.setField(3, this.radar_zoomLv);
            this.tile.sendSyncPacketC2S();
        }
    }

    private int getRadarIconU(double px, double pz) {
        int absPx = MathHelper.abs((int)px);
        int absPz = MathHelper.abs((int)pz);
        float timeFactor = this.tickGUI * 0.125f;
        if (absPx > 48 || absPz > 48) return (int)(timeFactor + 6.0f) % 8 * 3;
        if (absPx > 32 || absPz > 32) return (int)(timeFactor + 4.0f) % 8 * 3;
        if (absPx > 16 || absPz > 16) return (int)(timeFactor + 2.0f) % 8 * 3;
        return (int)timeFactor % 8 * 3;
    }

    private void drawRadarIcon() {
        if (this.capa == null) return;
        List<Integer> ships = this.capa.getShipEIDList();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        double ox = (this.type == 0) ? this.tile.getPos().getX() : this.player.posX;
        double oy = (this.type == 0) ? this.tile.getPos().getY() : this.player.posY;
        double oz = (this.type == 0) ? this.tile.getPos().getZ() : this.player.posZ;
        float radarScale = (float) Math.pow(2.0, this.radar_zoomLv);
        this.shipList.clear();
        this.itemList.clear();
        int id = 0;
        for (Integer eid : ships) {
            if (eid == null || eid <= 0) continue;
            Entity ship = EntityHelper.getEntityByID(eid, 0, true);
            if (ship != null && ship.posY > 0.0) {
                double px = (ship.posX - ox) * radarScale;
                double py = ship.posY - oy;
                double pz = (ship.posZ - oz) * radarScale;
                px = MathHelper.clamp(px, -64.0, 64.0);
                pz = MathHelper.clamp(pz, -64.0, 64.0);
                RadarEntity getent = new RadarEntity(ship);
                getent.pixelx = (this.guiLeft + 69) + px;
                getent.pixely = py;
                getent.pixelz = (this.guiTop + 88) + pz;
                this.shipList.add(getent);
                int sIconU = getRadarIconU(px, pz);
                if (this.selectedShips.contains(id)) {
                    GlStateManager.color(1.0f, 0.0f, 0.0f, 1.0f);
                } else {
                    GlStateManager.color(1.0f, 0.684f, 0.788f, 1.0f);
                }
                this.drawTexturedModalRect(this.guiLeft + 69 + (int)px, this.guiTop + 88 + (int)pz, sIconU, 192, 3, 3);
            }
            id++;
        }
        if (CommonProxy.entityItemList != null && CommonProxy.entityItemList.length > 1) {
            for (int i = 0; i < CommonProxy.entityItemList.length / 3; ++i) {
                double itemX = CommonProxy.entityItemList[i * 3];
                double itemY = CommonProxy.entityItemList[i * 3 + 1];
                double itemZ = CommonProxy.entityItemList[i * 3 + 2];
                double px = MathHelper.clamp((itemX - ox) * radarScale, -64.0, 64.0);
                double pz = MathHelper.clamp((itemZ - oz) * radarScale, -64.0, 64.0);
                this.itemList.add(new RadarEntity((this.guiLeft + 69) + px, itemY - oy, (this.guiTop + 88) + pz, (int)itemX, (int)itemY, (int)itemZ));
                int sIconU = getRadarIconU(px, pz);
                GlStateManager.color(0.0f, 1.0f, 1.0f, 1.0f);
                this.drawTexturedModalRect(this.guiLeft + 69 + (int)px, this.guiTop + 88 + (int)pz, sIconU, 192, 3, 3);
            }
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableBlend();
    }

    private void drawMoraleIcon() {
        this.mc.getTextureManager().bindTexture(GUI_NAME_ICON0);
        if (this.shipList == null) return;
        int texty = 37;
        for (int i = 0; i < 5; i++) {
            int index = this.listNum[0] + i;
            if(index >= this.shipList.size()) break;

            RadarEntity s = this.shipList.get(index);
            if (s != null && s.ship instanceof BasicEntityShip) {
                BasicEntityShip s2 = (BasicEntityShip)s.ship;
                int ix = EntityHelper.getMoraleLevel(s2.getMorale()) * 11;
                this.drawTexturedModalRect(this.guiLeft + 237, this.guiTop + texty - 1, ix, 240, 11, 11);
            }
            texty += 32;
        }
    }

    private void drawRadarText() {
        int texty = 27;
        for (int i = 0; i < 5; i++) {
            int index = this.listNum[0] + i;
            if(index >= this.shipList.size()) break;

            RadarEntity s = this.shipList.get(index);
            if (s == null || !(s.ship instanceof BasicEntityShip)) continue;

            BasicEntityShip s2 = (BasicEntityShip) s.ship;
            this.fontRenderer.drawString(s.name, 147, texty, Enums.EnumColors.WHITE.getValue());

            String str = "LV " + TextFormatting.YELLOW + s2.getLevel() + "   " + TextFormatting.GOLD + (int)s2.getHealth() + TextFormatting.RED + " / " + (int)s2.getMaxHealth();
            String str2 = STR_POS + " " + TextFormatting.YELLOW + MathHelper.ceil(s.ship.posX) + ", " + MathHelper.ceil(s.ship.posZ) + "  " + TextFormatting.LIGHT_PURPLE + STR_HEIGHT + " " + TextFormatting.YELLOW + (int)s.ship.posY;

            GlStateManager.pushMatrix();
            GlStateManager.scale(0.8f, 0.8f, 1.0f);
            this.fontRenderer.drawString(str, 184, (int)((texty + 12) * 1.25f), Enums.EnumColors.CYAN.getValue());
            this.fontRenderer.drawString(str2, 184, (int)((texty + 21) * 1.25f), Enums.EnumColors.PURPLE_LIGHT.getValue());
            GlStateManager.popMatrix();

            texty += 32;
        }
    }

    private void drawTeamPic() {
        int cirY;
        if (this.listFocus == 1 && this.listClicked[1] > -1 && this.listClicked[1] < 5) {
            cirY = 25 + this.listClicked[1] * 32;
            this.drawTexturedModalRect(this.guiLeft + 142, this.guiTop + cirY, 0, 192, 108, 31);
        } else if (this.listFocus == 3 && this.listClicked[3] > -1 && this.listClicked[3] < 3) {
            cirY = 61 + this.listClicked[3] * 31;
            this.drawTexturedModalRect(this.guiLeft + 6, this.guiTop + cirY, 109, 192, 129, 31);
        } else if (this.listFocus == 4 && this.listClicked[4] > -1 && this.listClicked[4] < 3) {
            cirY = 61 + this.listClicked[4] * 31;
            this.drawTexturedModalRect(this.guiLeft + 6, this.guiTop + cirY, 109, 192, 129, 31);
        }
    }

    private void drawTeamText() {
        if (this.capa == null) return;
        drawTeamInfoBar();
        drawTeamActionButtons();
        drawTeamList();
        drawAllyOrBanList();
    }

    private void drawTeamInfoBar() {
        if (this.capa.hasTeam()) {
            TeamData tdata = this.capa.getPlayerTeamData(this.capa.getPlayerUID());
            if (tdata != null) {
                GlStateManager.pushMatrix();
                GlStateManager.scale(0.8f, 0.8f, 0.8f);
                String str = TextFormatting.GRAY + STR_TEAM_ID + ":  " + TextFormatting.YELLOW + this.capa.getPlayerUID() + " : " + TextFormatting.LIGHT_PURPLE + tdata.getTeamLeaderName();
                this.fontRenderer.drawString(str, 11, 34, 0);
                this.fontRenderer.drawSplitString(TextFormatting.WHITE + tdata.getTeamName(), 11, 44, 160, 0);
                GlStateManager.popMatrix();
            }
        }
    }

    private void drawTeamActionButtons() {
        String strLT = null;
        String strLB = null;
        String strRT = null;
        String strRB = null;
        int colorLT = Enums.EnumColors.WHITE.getValue();
        int colorLB = colorLT;
        int colorRT = colorLT;
        int colorRB = colorLT;
        switch (this.teamState) {
            case 0:
                if(this.capa.hasTeam()){
                    strLT = STR_ALLY_LIST; colorLT = Enums.EnumColors.CYAN.getValue();
                    strLB = STR_BAN_LIST; colorLB = Enums.EnumColors.YELLOW.getValue();
                    if(this.tempCD > 0) { strRT = String.valueOf(this.tempCD / 20); colorRT = Enums.EnumColors.GRAY_LIGHT.getValue(); }
                    else { strRT = STR_RENAME; }
                    if(this.capa.getPlayerTeamCooldown() > 0) { strRB = String.valueOf(this.capa.getPlayerTeamCooldownInSec()); colorRB = Enums.EnumColors.GRAY_LIGHT.getValue(); }
                    else { strRB = STR_DISBAND; colorRB = Enums.EnumColors.GRAY_DARK.getValue(); }
                } else {
                    if(this.capa.getPlayerTeamCooldown() > 0) { strRB = String.valueOf(this.capa.getPlayerTeamCooldownInSec()); colorRB = Enums.EnumColors.GRAY_LIGHT.getValue(); }
                    else { strRB = STR_CREATE; colorRB = Enums.EnumColors.CYAN.getValue(); }
                }
                break;
            case 1: case 3:
                strLT = STR_CANCEL; colorLT = Enums.EnumColors.GRAY_LIGHT.getValue();
                strLB = STR_OK;
                if (this.teamState == 1) this.fontRenderer.drawString(TextFormatting.WHITE + STR_TEAM_ID + "  " + TextFormatting.YELLOW + this.capa.getPlayerUID(), 10, 43, 0);
                break;
            case 2: case 4:
                strLB = STR_OK;
                if (this.tempCD > 0) { strLT = String.valueOf(this.tempCD / 20); colorLT = Enums.EnumColors.GRAY_LIGHT.getValue(); }
                else {
                    ButtonInfo info = getTeamActionButtonInfo();
                    strLT = info.text;
                    colorLT = info.color;
                }
                break;
            default:
        }
        drawCenteredString(strLT, 31, 160, colorLT);
        drawCenteredString(strLB, 31, 174, colorLB);
        drawCenteredString(strRT, 110, 160, colorRT);
        drawCenteredString(strRB, 110, 174, colorRB);
    }

    private void drawCenteredString(String text, int x, int y, int color) {
        if(text != null) {
            this.fontRenderer.drawString(text, x - this.fontRenderer.getStringWidth(text) / 2, y, color);
        }
    }

    private ButtonInfo getTeamActionButtonInfo() {
        int clicki;
        List<TeamData> tlist = this.capa.getPlayerTeamDataList();
        if (this.listFocus == 1 && tlist != null && (clicki = this.listClicked[1] + this.listNum[1]) >= 0 && clicki < tlist.size()) {
            TeamData getd = tlist.get(clicki);
            if (getd != null && this.capa.getPlayerUID() != getd.getTeamID()) {
                if(this.teamState == 2) return this.capa.isTeamAlly(getd.getTeamID()) ? new ButtonInfo(STR_BREAK, Enums.EnumColors.YELLOW.getValue()) : new ButtonInfo(STR_ALLY, Enums.EnumColors.CYAN.getValue());
                if(this.teamState == 4) return this.capa.isTeamBanned(getd.getTeamID()) ? new ButtonInfo(STR_UNBAN, Enums.EnumColors.CYAN.getValue()) : new ButtonInfo(STR_BAN, Enums.EnumColors.YELLOW.getValue());
            }
        } else if (this.listFocus == 3 && this.teamState == 2) {
            return new ButtonInfo(STR_BREAK, Enums.EnumColors.YELLOW.getValue());
        } else if (this.listFocus == 4 && this.teamState == 4) {
            return new ButtonInfo(STR_UNBAN, Enums.EnumColors.CYAN.getValue());
        }
        return new ButtonInfo(null, 0);
    }

    private void drawTeamList() {
        List<TeamData> tlist = this.capa.getPlayerTeamDataList();
        if (tlist == null) return;
        int texty = 33;
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
        for (int i = 0; i < 5; ++i) {
            int index = this.listNum[1] + i;
            if (index >= tlist.size()) break;
            TeamData tdata2 = tlist.get(index);
            if (tdata2 != null) {
                String allyInfo = TextFormatting.WHITE + "(" + STR_NEUTRAL + ")";
                if (this.capa.getPlayerUID() == tdata2.getTeamID()) allyInfo = TextFormatting.GOLD + "(" + STR_BELONG + ")";
                else if (this.capa.isTeamAlly(tdata2.getTeamID())) allyInfo = TextFormatting.AQUA + "(" + STR_ALLIED + ")";
                else if (this.capa.isTeamBanned(tdata2.getTeamID())) allyInfo = TextFormatting.RED + "(" + STR_HOSTILE + ")";

                String str = TextFormatting.YELLOW + "" + tdata2.getTeamID() + " : " + TextFormatting.LIGHT_PURPLE + tdata2.getTeamLeaderName() + "  " + allyInfo;
                this.fontRenderer.drawString(str, 181, texty, Enums.EnumColors.WHITE.getValue());
                this.fontRenderer.drawSplitString(tdata2.getTeamName(), 181, texty + 9, 132, Enums.EnumColors.WHITE.getValue());
            }
            texty += 40;
        }
        GlStateManager.popMatrix();
    }

    private void drawAllyOrBanList() {
        TeamData tdata = this.capa.getPlayerTeamData(this.capa.getPlayerUID());
        if (tdata == null || (this.teamState != 2 && this.teamState != 4)) return;

        List<Integer> tlist3 = (this.teamState == 2) ? tdata.getTeamAllyList() : tdata.getTeamBannedList();
        int listID = (this.teamState == 2) ? 3 : 4;
        if(tlist3 == null) return;

        int texty = 79;
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
        for (int i = 0; i < 3; ++i) {
            int index = this.listNum[listID] + i;
            if(index >= tlist3.size()) break;

            TeamData tdata3 = this.capa.getPlayerTeamData(tlist3.get(index));
            if (tdata3 != null) {
                String allyInfo = this.capa.isTeamAlly(tdata3.getTeamID()) ? TextFormatting.AQUA + "(" + STR_ALLIED + ")" : TextFormatting.RED + "(" + STR_HOSTILE + ")";
                String str = TextFormatting.GRAY + STR_TEAM_ID + ":  " + TextFormatting.YELLOW + tdata3.getTeamID() + " : " + TextFormatting.LIGHT_PURPLE + tdata3.getTeamLeaderName() + "  " + allyInfo;
                this.fontRenderer.drawString(str, 11, texty, 0);
                this.fontRenderer.drawSplitString(tdata3.getTeamName(), 11, texty + 9, 170, Enums.EnumColors.WHITE.getValue());
            }
            texty += 39;
        }
        GlStateManager.popMatrix();
    }

    private void getEntityByClick() {
        int clicked = this.listClicked[2] + this.listNum[2];
        if (clicked < 0 || clicked >= this.tarList.size()) return;
        String tarStr = this.tarList.get(clicked);
        if (tarStr == null) return;
        Class<? extends Entity> clazz = EntityList.getClassFromName(tarStr);
        if (clazz != null) {
            this.targetEntity = EntityList.newEntity(clazz, this.player.world);
        }
    }

    private void renderEntityModel(Entity entity, float x, float y, float partialTick) {
        if(entity == null) return;
        RenderManager rm = this.mc.getRenderManager();
        float renderScale = this.prevScale + (this.currentScale - this.prevScale) * partialTick;
        float renderRotateX = this.prevRotateX + (this.currentRotateX - this.prevRotateX) * partialTick;
        float renderRotateY = this.prevRotateY + (this.currentRotateY - this.prevRotateY) * partialTick;
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, 50.0f);
        GlStateManager.scale(-renderScale, renderScale, renderScale);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(135.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(renderRotateY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(renderRotateX, 1.0f, 0.0f, 0.0f);
        GlStateManager.translate(0.0, entity.getYOffset(), 0.0);
        rm.setPlayerViewY(180.0f);
        rm.setRenderShadow(false);
        rm.renderEntity(entity, 0.0, 0.0, 0.0, 0.0f, partialTick, false);
        rm.setRenderShadow(true);
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    private void drawTargetModel(float partialTick) {
        renderEntityModel(this.targetEntity, (float)this.guiLeft + 72, (float)this.guiTop + 136, partialTick);
    }

    private void drawTargetText() {
        drawCenteredString(STR_REMOVE, 31, 160, Enums.EnumColors.WHITE.getValue());
        int texty = 28;
        for (int i = 0; i < 13; i++) {
            int index = this.listNum[2] + i;
            if(index >= this.tarList.size()) break;
            String str = this.tarList.get(index);
            if (str != null) {
                this.fontRenderer.drawString(str, 146, texty, Enums.EnumColors.WHITE.getValue());
            }
            texty += 12;
        }
    }

    private void openShipGUIbyIndex(int index) {
        if (index >= 0 && index < this.shipList.size()) {
            RadarEntity re = this.shipList.get(index);
            if (re != null && re.ship instanceof BasicEntityShip) {
                this.mc.player.closeScreen();
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.player, (byte)22, re.ship.getEntityId()));
            }
        }
    }

    @Override
    protected void keyTyped(char input, int keyID) throws IOException {
        if (!this.textField.textboxKeyTyped(input, keyID)) {
            super.keyTyped(input, keyID);
        }
    }

    private void handleClickTeamMain(int btn) {
        switch (btn) {
            case 0: if (this.capa.hasTeam()) this.teamState = 2; break;
            case 6: if (this.capa.hasTeam()) this.teamState = 4; break;
            case 7: if (this.tempCD <= 0 && this.capa.hasTeam()) this.teamState = 3; break;
            case 8:
                if (this.capa.getPlayerTeamCooldown() <= 0) {
                    if (this.capa.hasTeam()) {
                        CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.player, (byte)76, 0));
                        this.teamState = 0;
                        this.tempCD = 60;
                    } else {
                        this.teamState = 1;
                    }
                }
                break;
            default:
        }
    }

    private void handleClickTeamAlly(int btn) {
        if (btn == 6) { this.teamState = 0; return; }
        if (btn == 0 && this.tempCD <= 0) {
            int getTeamID = getSelectedTeamID();
            if (getTeamID > 0) {
                byte packetID = this.capa.isTeamAlly(getTeamID) ? (byte)73 : (byte)72;
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.player, packetID, getTeamID));
                this.tempCD = 60;
            }
        }
    }

    private int getSelectedTeamID() {
        int clicki;
        if(this.listFocus == 1) {
            List<TeamData> tlist = this.capa.getPlayerTeamDataList();
            clicki = this.listClicked[1] + this.listNum[1];
            if (tlist != null && clicki >= 0 && clicki < tlist.size()) {
                TeamData getd = tlist.get(clicki);
                if(getd != null) return getd.getTeamID();
            }
        } else if (this.listFocus == 3) {
            List<Integer> list = this.capa.getPlayerTeamAllyList();
            clicki = this.listClicked[3] + this.listNum[3];
            if(list != null && clicki >= 0 && clicki < list.size()) return list.get(clicki);
        } else if (this.listFocus == 4) {
            List<Integer> list = this.capa.getPlayerTeamBannedList();
            clicki = this.listClicked[4] + this.listNum[4];
            if(list != null && clicki >= 0 && clicki < list.size()) return list.get(clicki);
        }
        return 0;
    }

    private void handleClickTeamCreate(int btn) {
        if (btn == 0) { this.teamState = 0; return; }
        if (btn == 6) {
            String str = this.textField.getText();
            if (!this.capa.hasTeam() && str != null && str.length() > 1) {
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.player, (byte)70, str));
                this.teamState = 0;
                this.tempCD = 60;
            }
        }
    }

    private void handleClickTeamRename(int btn) {
        if (btn == 0) { this.teamState = 0; return; }
        if (btn == 6) {
            String str = this.textField.getText();
            if (this.capa.hasTeam() && str != null && str.length() > 1) {
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.player, (byte)71, str));
                this.teamState = 0;
                this.tempCD = 60;
            }
        }
    }

    private void handleClickTeamBan(int btn) {
        if (btn == 6) { this.teamState = 0; return; }
        if (btn == 0 && this.tempCD <= 0) {
            int getTeamID = getSelectedTeamID();
            if (getTeamID > 0) {
                byte packetID = this.capa.isTeamBanned(getTeamID) ? (byte)75 : (byte)74;
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.player, packetID, getTeamID));
                this.tempCD = 60;
            }
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this.textField.updateCursorCounter();
        if (this.type == 0 && (this.tile == null || this.tile.isInvalid())) {
            this.mc.player.closeScreen();
            return;
        }
        if ((this.tickGUI & 0x3F) == 0 && this.player != null) {
            CommonProxy.channelI.sendToServer(new C2SInputPackets((byte)14, 0));
        }
        if (this.guiFunc == 2 && this.shipModel != null) {
            updateShipModelAnimation();
        }
    }

    private void updateModelTransforms() {
        this.prevRotateX = this.currentRotateX;
        this.prevRotateY = this.currentRotateY;
        this.prevScale = this.currentScale;
        float smoothingFactor = 0.7F;
        this.currentRotateX += (this.targetRotateX - this.currentRotateX) * smoothingFactor;
        this.currentRotateY += (this.targetRotateY - this.currentRotateY) * smoothingFactor;
        this.currentScale += (this.targetScale - this.currentScale) * smoothingFactor;
    }

    private void updateShipModelAnimation() {
        ++this.shipModel.ticksExisted;
        if (this.shipModel.getAttackTick() > 0) {
            this.shipModel.setAttackTick(this.shipModel.getAttackTick() - 1);
        }
        if (this.shipModel.isSprinting()) {
            this.shipModel.travel(1.0f, 0.0f, 0.0f);
        } else {
            this.shipModel.prevSwingProgress = 0.0f;
            this.shipModel.swingProgress = 0.0f;
            this.shipModel.prevLimbSwingAmount = 0.0f;
            this.shipModel.limbSwingAmount = 0.0f;
        }
        if (this.shipMount != null) {
            ++this.shipMount.ticksExisted;
            if (this.shipMount.getAttackTick() > 0) {
                this.shipMount.setAttackTick(this.shipMount.getAttackTick() - 1);
            }
            if (this.shipMount.isSprinting()) {
                this.shipMount.travel(1.0f, 0.0f, 0.0f);
            } else {
                this.shipMount.prevSwingProgress = 0.0f;
                this.shipMount.swingProgress = 0.0f;
                this.shipMount.prevLimbSwingAmount = 0.0f;
                this.shipMount.limbSwingAmount = 0.0f;
            }
        }
    }

    private void setShipModel(int chap, int page) {
        if (this.shipModel != null) {
            this.shipModel.dismountRidingEntity();
            this.shipMount = null;
        }
        int classID = -1;
        try {
            if (page > 0) {
                if (chap == 4 && page - 1 < Values.ShipBookList.size()) classID = Values.ShipBookList.get(page - 1);
                else if (chap == 5 && page - 1 < Values.EnemyBookList.size()) classID = Values.EnemyBookList.get(page - 1);
            }
        } catch (Exception e) { classID = -1; }

        if (classID < 0 || !EntityHelper.checkShipColled(classID, this.capa)) {
            this.shipModel = null;
            return;
        }

        String shipName = ShipCalc.getEntityToSpawnName(classID);
        Entity raw = EntityList.createEntityByIDFromName(new ResourceLocation(shipName), this.player.world);
        if (raw instanceof BasicEntityShip) {
            this.shipModel = (BasicEntityShip) raw;
            this.shipModel.setStateFlag(2, false);
            this.shipMaxStats= this.shipModel.getStateMinor(13);
            this.iconXY = new int[2][];
            this.iconXY[0] = Values.ShipTypeIconMap.get(this.shipModel.getShipType());
            this.iconXY[1] = Values.ShipNameIconMap.get((int)this.shipModel.getShipClass());
        } else {
            this.shipModel = null;
            this.shipMaxStats = 0;
            this.shipStats = 0;
        }
    }

    private void setShipMount() {
        if (this.shipModel != null && this.shipModel.hasShipMounts()) {
            if (this.shipModel.canSummonMounts()) {
                if (!this.shipModel.isRiding()) {
                    this.shipMount = this.shipModel.summonMountEntity();
                    if(this.shipMount != null) {
                        this.shipMount.initAttrs(this.shipModel);
                        this.shipModel.startRiding(this.shipMount, true);
                    }
                }
            } else {
                this.shipModel.dismountRidingEntity();
                this.shipMount = null;
            }
        }
    }

    private void drawShipModel(float partialTick) {
        if (this.shipModel == null) {
            this.mc.getTextureManager().bindTexture(GUI_BOOK2);
            this.drawTexturedModalRect(this.guiLeft + 20, this.guiTop + 48, 0, 148, 87, 108);
            return;
        }
        drawShipModelBackground();
        drawShipModelStats();
        drawShipNameIcons();
        updateModelTransforms();
        renderShipEntity(partialTick);
    }

    private void drawShipModelBackground() {
        this.mc.getTextureManager().bindTexture(GUI_BOOK2);
        int u = (this.book_chapNum == 4) ? 0 : 105;
        this.drawTexturedModalRect(this.guiLeft + 20, this.guiTop + 48, u, 0, 87, 130);
    }

    private void drawShipModelStats() {
        this.shipStats = this.shipModel.getStateEmotion(0);
        for (int i = 0; i < 16; ++i) {
            if (i >= this.shipMaxStats) break;
            int u = 115;
            int v = ((this.shipStats >> i) & 1) == 1 ? 156 : 147;
            this.drawTexturedModalRect(this.guiLeft + 45 + (i%8) * 9, this.guiTop + 158 + (i/8) * 9, u, v, 7, 9);
        }
    }

    private void drawShipNameIcons() {
        try {
            if (this.iconXY == null || this.iconXY[0] == null || this.iconXY[1] == null) return;
            this.mc.getTextureManager().bindTexture(GUI_NAME_ICON0);
            this.drawTexturedModalRect(this.guiLeft + 23, this.guiTop + 53, this.iconXY[0][0], this.iconXY[0][1], 28, 28);

            int offx = 0;
            int offy = 0;
            ResourceLocation iconTexture = GUI_NAME_ICON1;
            if (this.iconXY[1][0] >= 100) iconTexture = GUI_NAME_ICON2;
            if (this.iconXY[1][0] == 4) offy = -10;
            else if (this.iconXY[1][0] == 6) offy = -10;
            else if (this.iconXY[1][0] >= 100) offy = 10;

            this.mc.getTextureManager().bindTexture(iconTexture);
            this.drawTexturedModalRect(this.guiLeft + 30 + offx, this.guiTop + 94 + offy, this.iconXY[1][1], this.iconXY[1][2], 11, 59);
        } catch (Exception e) {
            LogHelper.info("Exception in drawShipNameIcons: " + e.getMessage());
        }
    }

    private void renderShipEntity(float partialTick) {
        RenderManager rm = this.mc.getRenderManager();
        float renderScale = this.prevScale + (this.currentScale - this.prevScale) * partialTick;
        float renderRotateX = this.prevRotateX + (this.currentRotateX - this.prevRotateX) * partialTick;
        float renderRotateY = this.prevRotateY + (this.currentRotateY - this.prevRotateY) * partialTick;
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)this.guiLeft + 72, this.guiTop + 110 + renderScale * 1.1f, 50.0f);
        GlStateManager.scale(-renderScale, renderScale, renderScale);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(135.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(0.0f, 0.7f, 0.0f);
        GlStateManager.rotate(renderRotateY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(renderRotateX, 1.0f, 0.0f, 0.0f);
        GlStateManager.translate(0.0, this.shipModel.getYOffset() - 0.7f, 0.0);
        this.shipModel.rotationYawHead = 0.0f;
        rm.setPlayerViewY(180.0f);
        rm.setRenderShadow(false);
        if (this.shipMount != null) {
            float[] seatPos = this.shipMount.getSeatPos();
            GlStateManager.translate(seatPos[2], seatPos[1] + this.shipModel.getYOffset(), seatPos[0]);
            rm.renderEntity(this.shipModel, 0.0, 0.0, 0.0, 0.0f, partialTick, false);
            GlStateManager.translate(-seatPos[2], -seatPos[1] - this.shipModel.getYOffset(), -seatPos[0]);
            rm.renderEntity(this.shipMount, 0.0, 0.0, 0.0, 0.0f, partialTick, false);
        } else {
            rm.renderEntity(this.shipModel, 0.0, 0.0, 0.0, 0.0f, partialTick, false);
        }
        rm.setRenderShadow(true);
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    private void updateTargetClassList() {
        this.tarList.clear();
        if (this.capa != null) {
            Map<Integer, String> m = this.capa.getTargetClassMap();
            if (m != null) {
                this.tarList.addAll(m.values());
            }
        }
    }

    private class RadarEntity {
        public Entity ship;
        public String name;
        public double pixelx;
        public double pixely;
        public double pixelz;
        public int posX;
        public int posY;
        public int posZ;
        public RadarEntity(Entity ship) {
            this.ship = ship;
            this.name = ship.hasCustomName() ? ship.getCustomNameTag() : ship.getName();
        }
        public RadarEntity(double pixelx, double pixely, double pixelz, int posX, int posY, int posZ) {
            this.pixelx = pixelx;
            this.pixely = pixely;
            this.pixelz = pixelz;
            this.posX = posX;
            this.posY = posY;
            this.posZ = posZ;
        }
    }

    private static class ButtonInfo {
        final String text;
        final int color;
        ButtonInfo(String text, int color) {
            this.text = text;
            this.color = color;
        }
    }
}
