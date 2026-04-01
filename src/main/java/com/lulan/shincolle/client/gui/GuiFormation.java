package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.client.gui.inventory.ContainerFormation;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.network.C2SGUIPackets;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.reference.Enums;
import com.lulan.shincolle.reference.unitclass.Attrs;
import com.lulan.shincolle.reference.unitclass.AttrsAdv;
import com.lulan.shincolle.utility.*;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

import java.io.IOException;
import java.util.*;

public class GuiFormation extends GuiContainer {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("shincolle:textures/gui/GuiFormation.png");
    private static final ResourceLocation GUI_NAME_ICON_TEXTURE = new ResourceLocation("shincolle:textures/gui/GuiNameIcon0.png");
    private static final int BAR_LENGTH = 20;
    private static final int[] BAR_ROWS = new int[]{54, 69, 84, 99, 114, 129};
    private static final int[] BAR_COLS = new int[]{9, 52, 95};
    private static final String ATTR_ATKL = TextFormatting.RED + I18n.format("gui.shincolle:firepower1");
    private static final String ATTR_ATKH = TextFormatting.GREEN + I18n.format("gui.shincolle:torpedo");
    private static final String ATTR_AIRL = TextFormatting.RED + I18n.format("gui.shincolle:airfirepower");
    private static final String ATTR_AIRH = TextFormatting.GREEN + I18n.format("gui.shincolle:airtorpedo");
    private static final String ATTR_DEF = TextFormatting.WHITE + I18n.format("gui.shincolle:armor");
    private static final String ATTR_SPD = TextFormatting.WHITE + I18n.format("gui.shincolle:attackspeed");
    private static final String ATTR_MOV = TextFormatting.GRAY + I18n.format("gui.shincolle:movespeed");
    private static final String ATTR_HIT = TextFormatting.LIGHT_PURPLE + I18n.format("gui.shincolle:range");
    private static final String ATTR_MISS = TextFormatting.RED + I18n.format("gui.shincolle:missreduce");
    private static final String ATTR_DODGE = TextFormatting.GOLD + I18n.format("gui.shincolle:dodge");
    private static final String ATTR_CRI = TextFormatting.AQUA + I18n.format("gui.shincolle:critical");
    private static final String ATTR_DHIT = TextFormatting.YELLOW + I18n.format("gui.shincolle:doublehit");
    private static final String ATTR_THIT = TextFormatting.GOLD + I18n.format("gui.shincolle:triplehit");
    private static final String ATTR_AA = TextFormatting.YELLOW + I18n.format("gui.shincolle:antiair");
    private static final String ATTR_ASM = TextFormatting.AQUA + I18n.format("gui.shincolle:antiss");
    private static final String ATTR_GRUDGE = TextFormatting.DARK_PURPLE + I18n.format("gui.shincolle:equip.grudge");
    private static final String ATTR_HPRES = TextFormatting.DARK_GREEN + I18n.format("gui.shincolle:equip.hpres");
    private static final String ATTR_KB = TextFormatting.YELLOW + I18n.format("gui.shincolle:equip.kb");
    private static final String ATTR_TOTAL_FP = TextFormatting.LIGHT_PURPLE + I18n.format("gui.shincolle:formation.totalfirepower");
    private static final String STR_POS = I18n.format("gui.shincolle:formation.position");
    private static final String STR_RADAR = I18n.format("gui.shincolle:radar.tname");
    private static final String STR_NO_SIGNAL = TextFormatting.DARK_RED + "" + TextFormatting.OBFUSCATED + I18n.format("gui.shincolle:formation.nosignal");
    private static final Map<Integer, int[][]> FORMATION_POSITIONS = new HashMap<>();
    private int xMouse;
    private int yMouse;
    private int tickGUI;
    private int tickWaitSync;
    private int listClicked;
    private int teamClicked;
    private int formatClicked;
    private int maxAttrStrLen;
    private int unitNameState;
    private String totalFPL;
    private String totalFPH;
    private String totalFPAL;
    private String totalFPAH;
    private String totalFPAA;
    private String totalFPASM;
    private String unitName;
    private final List<String> mouseoverList;
    private GuiTextField textField;
    private AttrsAdv attrs;
    private float[] unbuffedAttrs;
    private final EntityPlayer player;
    private final CapaTeitoku capa;
    private final int[][] spotPos;
    private final int[][] spotPosFinal;
    private final float[] buffBar;
    private final float[] buffBarFinal;
    private final BasicEntityShip[] shipList;
    private final String[] shipName;

    public GuiFormation(EntityPlayer par1) {
        super(new ContainerFormation());
        this.player = par1;
        this.xSize = 256;
        this.ySize = 192;
        this.tickGUI = 0;
        this.tickWaitSync = 0;
        this.capa = CapaTeitoku.getTeitokuCapability(this.player);
        this.spotPos = new int[2][6];
        this.spotPosFinal = new int[2][6];
        this.buffBar = new float[21];
        this.buffBarFinal = new float[21];
        this.shipName = new String[6];
        this.shipList = new BasicEntityShip[6];
        this.attrs = null;
        this.unbuffedAttrs = Attrs.getResetZeroValue();
        for (int i=0; i<6; ++i) {
            this.spotPos[0][i] = 25;
            this.spotPos[1][i] = 25;
            this.spotPosFinal[0][i] = 25;
            this.spotPosFinal[1][i] = 25;
        }
        Arrays.fill(this.buffBar, 0.0f);
        Arrays.fill(this.buffBarFinal, 0.0f);
        this.listClicked = 0;
        if (this.capa != null) {
            this.teamClicked = this.capa.getCurrentTeamID();
            this.formatClicked = this.capa.getFormatIDCurrentTeam();
            this.setShipList(this.teamClicked);
            this.setFormationSpotPos(this.formatClicked);
            this.setFormationBuffBar(this.formatClicked, this.listClicked);
            this.setShipName();
        }
        this.mouseoverList = new ArrayList<>();
        this.updateStrings();
    }
    static {
        FORMATION_POSITIONS.put(0, new int[][]{{25, 25, 25, 25, 25, 25}, {25, 25, 25, 25, 25, 25}});
        FORMATION_POSITIONS.put(1, new int[][]{{25, 25, 25, 25, 25, 25}, {9, 15, 21, 27, 33, 39}});
        FORMATION_POSITIONS.put(2, new int[][]{{21, 29, 21, 29, 21, 29}, {25, 25, 16, 16, 34, 34}});
        FORMATION_POSITIONS.put(3, new int[][]{{25, 25, 15, 35, 25, 25}, {29, 15, 26, 26, 36, 23}});
        FORMATION_POSITIONS.put(4, new int[][]{{40, 34, 28, 22, 16, 10}, {9, 15, 21, 27, 33, 39}});
        FORMATION_POSITIONS.put(5, new int[][]{{40, 34, 28, 22, 16, 10}, {25, 25, 25, 25, 25, 25}});
    }

    @Override
    public void initGui() {
        super.initGui();
        this.textField = new GuiTextField(1, this.fontRenderer, this.guiLeft + 100, this.guiTop + 180, 150, 12);
        this.textField.setTextColor(Enums.EnumColors.YELLOW.getValue());
        this.textField.setDisabledTextColour(-1);
        this.textField.setEnableBackgroundDrawing(true);
        this.textField.setMaxStringLength(250);
        this.textField.setEnabled(false);
        this.textField.setFocused(false);
        this.unitNameState = -1;
        this.maxAttrStrLen = Arrays.stream(new String[]{ATTR_TOTAL_FP, ATTR_ATKL, ATTR_ATKH, ATTR_AIRL, ATTR_AIRH, ATTR_AA, ATTR_ASM})
                .mapToInt(this.fontRenderer::getStringWidth).max().orElse(0);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float parTick) {
        super.drawScreen(mouseX, mouseY, parTick);
        this.xMouse = mouseX;
        this.yMouse = mouseY;
        ++this.tickGUI;
        if (this.tickWaitSync > 0 && --this.tickWaitSync == 1) {
            this.setShipList(this.teamClicked);
            this.setShipName();
        }
        if (this.unitNameState >= 0) {
            GlStateManager.pushMatrix();
            GlStateManager.disableLighting();
            GlStateManager.disableBlend();
            this.textField.setEnabled(true);
            this.textField.drawTextBox();
            GlStateManager.popMatrix();
        } else {
            this.textField.setEnabled(false);
        }
        if (this.tickGUI % 32 == 0) {
            this.updateStrings();
        }
    }

    private String formatAttribute(String format, float... values) {
        Object[] args = new Object[values.length];
        for(int i = 0; i < values.length; i++) args[i] = values[i];
        return String.format(format, args);
    }
    private String getAttributeDisplayString(byte attrid) {
        if (this.attrs == null) return "";
        float formationValue = this.attrs.getAttrsFormation(attrid);
        float unbuffedValue = this.unbuffedAttrs[attrid];
        float buffedValue = this.attrs.getAttrsBuffed(attrid);
        String prefix = (formationValue > (attrid == 8 || attrid == 7 ? 0.0f : 1.0f) && attrid < 15) || (formationValue > 0f && attrid >=15) ? "+" : "";
        String formationStr = "";
        String orgStr = "";
        String buffedStr = "";
        switch (attrid) {
            case 1: case 2: case 3: case 4: case 6: case 13: case 14:
                formationStr = formatAttribute("%.0f%%", (formationValue - 1.0f) * 100.0f);
                orgStr = formatAttribute("%.1f", unbuffedValue);
                buffedStr = formatAttribute("%.1f", buffedValue);
                break;
            case 5: case 9: case 10: case 11: case 12:
                formationStr = formatAttribute("%.0f%%", (formationValue - 1.0f) * 100.0f);
                orgStr = formatAttribute("%.1f%%", unbuffedValue * 100.0f);
                buffedStr = formatAttribute("%.1f%%", buffedValue * 100.0f);
                break;
            case 8:
                formationStr = formatAttribute("%.2f", formationValue);
                orgStr = formatAttribute("%.2f", unbuffedValue);
                buffedStr = formatAttribute("%.2f", buffedValue);
                break;
            case 7:
                float mov = Math.max(0.0f, Math.min(this.attrs.getMinMOV() + formationValue * (float) ConfigHandler.scaleShip[4], (float) ConfigHandler.limitShipAttrs[7]));
                formationStr = formatAttribute("%.2f", formationValue);
                orgStr = formatAttribute("%.2f", unbuffedValue);
                buffedStr = formatAttribute("%.2f", mov);
                break;
            case 15:
                formationStr = formatAttribute("%.0f%%", formationValue * 100.0f);
                orgStr = formatAttribute("%.1f%%", unbuffedValue * 100.0f);
                buffedStr = formatAttribute("%.1f%%", buffedValue * 100.0f);
                break;
            case 17: case 19:
                formationStr = formatAttribute("%.0f%%", formationValue * 100.0f);
                orgStr = formatAttribute("%.0f%%", (unbuffedValue - 1.0f) * 100.0f);
                buffedStr = formatAttribute("%.0f%%", (buffedValue - 1.0f) * 100.0f);
                break;
            default:
                formationStr = formatAttribute("%.0f%%", formationValue * 100.0f);
                orgStr = formatAttribute("%.0f%%", unbuffedValue * 100.0f);
                buffedStr = formatAttribute("%.0f%%", buffedValue * 100.0f);
                break;
        }
        return prefix + formationStr + " : " + TextFormatting.GRAY + orgStr + TextFormatting.WHITE + " -> " + TextFormatting.YELLOW + buffedStr;
    }

    private void updateStrings() {
        if (this.shipList[this.listClicked] != null) {
            this.attrs = (AttrsAdv) this.shipList[this.listClicked].getAttrs();
            this.unbuffedAttrs = BuffHelper.calcAttrsWithoutBuff(this.attrs, 4);
        } else {
            this.attrs = null;
            this.unbuffedAttrs = Attrs.getResetZeroValue();
        }
        float[] totalFP = new float[6];
        for (BasicEntityShip ship : this.shipList) {
            if (ship == null) continue;
            totalFP[0] += ship.getAttrs().getAttrsBuffed(1);
            totalFP[1] += ship.getAttrs().getAttrsBuffed(2);
            totalFP[2] += ship.getAttrs().getAttrsBuffed(3);
            totalFP[3] += ship.getAttrs().getAttrsBuffed(4);
            totalFP[4] += ship.getAttrs().getAttrsBuffed(13);
            totalFP[5] += ship.getAttrs().getAttrsBuffed(14);
        }
        this.totalFPL = TextFormatting.RED + String.format("%.1f", totalFP[0]);
        this.totalFPH = TextFormatting.GREEN + String.format("%.1f", totalFP[1]);
        this.totalFPAL = TextFormatting.RED + String.format("%.1f", totalFP[2]);
        this.totalFPAH = TextFormatting.GREEN + String.format("%.1f", totalFP[3]);
        this.totalFPAA = TextFormatting.YELLOW + String.format("%.1f", totalFP[4]);
        this.totalFPASM = TextFormatting.AQUA + String.format("%.1f", totalFP[5]);
        this.unitName = "\"" + this.capa.getUnitName(this.teamClicked) + "\"";
    }

    private void handleHoveringText() {
        int mx = this.xMouse - this.guiLeft;
        int my = this.yMouse - this.guiTop;
        this.mouseoverList.clear();
        if (isMouseOverAttributeBars(mx, my)) {
            byte attrId = getHoveredAttributeId(mx, my);
            if (attrId != -1) {
                this.mouseoverList.add(getAttributeDisplayString(attrId));
                this.drawHoveringText(this.mouseoverList, mx, my + 10, this.fontRenderer);
            }
        } else if (isMouseOverTotalFP(mx, my)) {
            this.mouseoverList.addAll(Arrays.asList(ATTR_TOTAL_FP, ATTR_ATKL, ATTR_ATKH, ATTR_AIRL, ATTR_AIRH, ATTR_AA, ATTR_ASM));
            this.drawHoveringText(this.mouseoverList, mx, my + 10, this.fontRenderer);
            this.mouseoverList.clear();
            this.mouseoverList.addAll(Arrays.asList("", this.totalFPL, this.totalFPH, this.totalFPAL, this.totalFPAH, this.totalFPAA, this.totalFPASM));
            this.drawHoveringText(this.mouseoverList, mx + this.maxAttrStrLen + 6, my + 10, this.fontRenderer);
        }
    }
    private boolean isMouseOverAttributeBars(int mx, int my) {
        return this.shipList[this.listClicked] != null && this.shipList[this.listClicked].getStateMinor(26) > 0 &&
                mx > 3 && mx < 138 && my > 43 && my < 145;
    }
    private boolean isMouseOverTotalFP(int mx, int my) {
        return mx > 45 && mx < 138 && my > 3 && my < 43;
    }
    private byte getHoveredAttributeId(int mx, int my) {
        int range = 5;
        for (int row = 0; row < BAR_ROWS.length; row++) {
            if (my < BAR_ROWS[row] + range) {
                if (mx < 51) return new byte[]{1, 2, 3, 4, 6, 8}[row];
                if (mx < 94) return new byte[]{9, 10, 11, 12, 13, 14}[row];
                return new byte[]{5, 15, 17, 19, 20, 7}[row];
            }
        }
        return -1;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j) {
        if (this.tickWaitSync > 0) {
            String str = String.format("%.1f", this.tickWaitSync * 0.05f);
            this.fontRenderer.drawString(str, 190, 171, Enums.EnumColors.YELLOW.getValue());
        }
        if (this.unitName != null) {
            this.fontRenderer.drawStringWithShadow(this.unitName, 100.0f, 182.0f, Enums.EnumColors.YELLOW.getValue());
        }
        this.drawFormationText();
        this.handleHoveringText();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GUI_TEXTURE);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        drawSelectionHighlight();
        drawTeamAndFormatIcons();
        drawFormationPosSpots();
        drawFormationBuffBars();
        drawMoraleIcons();
    }
    private void drawSelectionHighlight() {
        if (this.listClicked >= 0 && this.listClicked < 6) {
            this.drawTexturedModalRect(this.guiLeft + 142, this.guiTop + 5 + this.listClicked * 27, 3, 192, 108, 27);
        }
    }
    private void drawTeamAndFormatIcons() {
        this.drawTexturedModalRect(this.guiLeft + 18 + this.teamClicked * 12, this.guiTop + 167, 111 + this.teamClicked * 9, 207, 9, 11);
        this.drawTexturedModalRect(this.guiLeft + 18 + this.formatClicked * 18, this.guiTop + 149, 111 + this.formatClicked * 15, 192, 15, 15);
    }

    private void drawMoraleIcons() {
        this.mc.getTextureManager().bindTexture(GUI_NAME_ICON_TEXTURE);
        if (this.shipList == null) return;
        for (int i = 0; i < 6; ++i) {
            if (this.shipList[i] != null) {
                int ix = EntityHelper.getMoraleLevel(this.shipList[i].getMorale()) * 11;
                this.drawTexturedModalRect(this.guiLeft + 145, this.guiTop + 9 + i * 27 - 1, ix, 240, 11, 11);
            }
        }
    }

    @Override
    protected void mouseClicked(int posX, int posY, int mouseKey) throws IOException {
        super.mouseClicked(posX, posY, mouseKey);
        this.textField.mouseClicked(posX, posY, mouseKey);
        int xClick = posX - this.guiLeft;
        int yClick = posY - this.guiTop;
        int btn = GuiHelper.getButton(4, 0, xClick, yClick);
        if (btn >= 0) {
            handleButtonClick(btn);
            this.setFormationBuffBar(this.formatClicked, this.listClicked);
            this.updateStrings();
        }
    }
    private void handleButtonClick(int btn) {
        if (btn <= 5) {
            handleFormatButtonClick(btn);
        } else if (btn <= 14) {
            handleTeamButtonClick(btn - 6);
        } else if (btn <= 20) {
            handleShipListClick(btn - 15);
        } else if (btn == 21 || btn == 22) {
            handleChangePosClick(btn == 22);
        } else if (btn == 23) {
            handleRenameClick();
        }
    }
    private void handleFormatButtonClick(int formatId) {
        this.formatClicked = formatId;
        this.setFormationSpotPos(this.formatClicked);
        CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.player, (byte) 31, this.formatClicked));
    }
    private void handleTeamButtonClick(int teamId) {
        if (this.unitNameState >= 0) return;
        this.teamClicked = teamId;
        CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.player, (byte) 27, this.teamClicked, -1));
        this.setShipList(this.teamClicked);
        this.formatClicked = this.capa.getFormatID(this.teamClicked);
        this.setFormationSpotPos(this.formatClicked);
        this.setShipName();
        this.tickWaitSync = 60;
    }
    private void handleShipListClick(int shipIndex) {
        if (this.listClicked == shipIndex) {
            openShipGUI();
        }
        this.listClicked = shipIndex;
    }
    private void handleChangePosClick(boolean isUp) {
        if (this.tickWaitSync > 0) return;
        if (this.capa != null && this.shipList != null) {
            int target = isUp ? (this.listClicked + 5) % 6 : (this.listClicked + 1) % 6;
            CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.player, (byte) 33, this.teamClicked, this.listClicked, target));
            this.listClicked = target;
            this.tickWaitSync = 40;
        }
    }
    private void handleRenameClick() {
        if (this.unitNameState < 0) {
            this.unitNameState = this.teamClicked;
        } else {
            String str = this.textField.getText();
            CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.player, (byte) 36, str));
            this.unitNameState = -1;
        }
    }

    private void openShipGUI() {
        if (this.shipList != null && this.shipList[this.listClicked] != null) {
            this.mc.player.closeScreen();
            CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.player, (byte) 22, this.shipList[this.listClicked].getEntityId()));
        }
    }

    private void drawFormationPosSpots() {
        for (int j = 0; j < 6; ++j) {
            if (this.spotPos[0][j] != this.spotPosFinal[0][j]) this.spotPos[0][j] += (int) Math.signum(this.spotPosFinal[0][j] - (float)this.spotPos[0][j]);
            if (this.spotPos[1][j] != this.spotPosFinal[1][j]) this.spotPos[1][j] += (int) Math.signum(this.spotPosFinal[1][j] - (float)this.spotPos[1][j]);
        }
        for (int i = 0; i < 6; ++i) {
            this.drawTexturedModalRect(this.guiLeft + this.spotPos[0][i], this.guiTop + this.spotPos[1][i], 0, i == this.listClicked ? 195 : 192, 3, 3);
        }
    }

    private void drawFormationBuffBars() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 6; ++j) {
                this.drawTexturedModalRect(this.guiLeft + BAR_COLS[i], this.guiTop + BAR_ROWS[j], 0, 220, BAR_LENGTH, 4);
            }
        }
        byte[] attrIds = {1, 2, 3, 4, 6, 8, 9, 10, 11, 12, 13, 14, 5, 15, 17, 19, 20, 7};
        int[] colMap = {0,0,0,0,0,0, 1,1,1,1,1,1, 2,2,2,2,2,2};
        int[] rowMap = {0,1,2,3,4,5, 0,1,2,3,4,5, 0,1,2,3,4,5};
        for(int i = 0; i < attrIds.length; i++){
            int attrId = attrIds[i];
            if (Math.abs(this.buffBar[attrId] - this.buffBarFinal[attrId]) > 0.1f) {
                this.buffBar[attrId] += (this.buffBarFinal[attrId] - this.buffBar[attrId]) * 0.1f;
            } else {
                this.buffBar[attrId] = this.buffBarFinal[attrId];
            }
            int len = (int) Math.abs(this.buffBar[attrId]);
            if (len > 0) {
                int x = this.guiLeft + BAR_COLS[colMap[i]] + (this.buffBar[attrId] > 0 ? BAR_LENGTH : -len + BAR_LENGTH);
                int y = this.guiTop + BAR_ROWS[rowMap[i]];
                int u = 0;
                int v = this.buffBar[attrId] > 0 ? 230 : 225;
                this.drawTexturedModalRect(x, y, u, v, len, 4);
            }
        }
    }

    private void drawFormationText() {
        int centerX = 70;
        int centerY = 182;
        this.fontRenderer.drawStringWithShadow(STR_RADAR, centerX - (float)this.fontRenderer.getStringWidth(STR_RADAR) / 2, centerY, Enums.EnumColors.YELLOW.getValue());
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.75f, 0.75f, 0.75f);
        drawShipListText();
        drawFormationInfoText();
        drawAttributeLabels();
        GlStateManager.popMatrix();
    }
    private void drawShipListText() {
        if (this.shipList == null) return;
        for (int i = 0; i < 6; ++i) {
            int texty = 14 + i * 36;
            if (this.shipList[i] != null) {
                this.fontRenderer.drawString(this.shipName[i], 210, texty, Enums.EnumColors.WHITE.getValue());
                String str = TextFormatting.AQUA + "LV " + TextFormatting.YELLOW + this.shipList[i].getLevel() + "   " + TextFormatting.GOLD + (int) this.shipList[i].getHealth() + " / " + TextFormatting.RED + (int) this.shipList[i].getMaxHealth();
                this.fontRenderer.drawString(str, 195, texty + 14, 0);
            } else {
                String str = STR_NO_SIGNAL + TextFormatting.GRAY + " UID: " + this.capa.getSID(this.capa.getCurrentTeamID(), i);
                this.fontRenderer.drawString(str, 195, texty, 0);
            }
        }
    }
    private void drawFormationInfoText() {
        String str = TextFormatting.YELLOW + I18n.format("gui.shincolle:formation.format" + this.formatClicked);
        this.fontRenderer.drawString(str, 115 - this.fontRenderer.getStringWidth(str) / 2, 18, Enums.EnumColors.WHITE.getValue());
        str = TextFormatting.LIGHT_PURPLE + STR_POS + " " + TextFormatting.WHITE + (this.listClicked + 1);
        this.fontRenderer.drawString(str, 115 - this.fontRenderer.getStringWidth(str) / 2, 30, Enums.EnumColors.WHITE.getValue());
    }
    private void drawAttributeLabels() {
        String[] labels = {ATTR_ATKL, ATTR_ATKH, ATTR_AIRL, ATTR_AIRH, ATTR_SPD, ATTR_HIT, ATTR_CRI, ATTR_DHIT, ATTR_THIT, ATTR_MISS, ATTR_AA, ATTR_ASM, ATTR_DEF, ATTR_DODGE, ATTR_GRUDGE, ATTR_HPRES, ATTR_KB, ATTR_MOV};
        float[] xPos = {12, 12, 12, 12, 12, 12, 69, 69, 69, 69, 69, 69, 126, 126, 126, 126, 126, 126};
        float[] yPos = {60, 80, 100, 120, 140, 160, 60, 80, 100, 120, 140, 160, 60, 80, 100, 120, 140, 160};
        for (int i = 0; i < labels.length; i++) {
            this.fontRenderer.drawStringWithShadow(labels[i], xPos[i], yPos[i], Enums.EnumColors.WHITE.getValue());
        }
    }

    private void setFormationSpotPos(int fid) {
        int[][] positions = FORMATION_POSITIONS.getOrDefault(fid, FORMATION_POSITIONS.get(0));
        System.arraycopy(positions[0], 0, this.spotPosFinal[0], 0, 6);
        System.arraycopy(positions[1], 0, this.spotPosFinal[1], 0, 6);
    }

    private void setFormationBuffBar(int fid, int pos) {
        float[] value = FormationHelper.getFormationBuffValue(fid, pos);
        float lenModify = 20.0f;
        for(int i = 1; i < value.length; i++){
            float multiplier = lenModify;
            float base = 1.0f;
            if(i == 7) { multiplier /= 0.5f; base = 0f; }
            else if(i == 8) { multiplier /= 10.0f; base = 0f; }
            else if(i >= 15 && i <= 20) { base = 0f; }
            this.buffBarFinal[i] = (value[i] - base) * multiplier;
        }
    }

    private void setShipList(int tid) {
        Arrays.fill(this.shipList, null);
        try {
            BasicEntityShip[] shipsInTeam = this.capa.getShipEntityAll(tid);
            if (shipsInTeam == null) return;
            if (this.capa.getFormatID(tid) > 0) {
                for (BasicEntityShip s : shipsInTeam) {
                    if (s != null) {
                        int formationPos = s.getStateMinor(27);
                        if(formationPos >= 0 && formationPos < 6) this.shipList[formationPos] = s;
                    }
                }
            } else {
                System.arraycopy(shipsInTeam, 0, this.shipList, 0, Math.min(shipsInTeam.length, 6));
            }
        } catch (Exception e) {
            LogHelper.info("EXCEPTION: formation GUI get ship fail: " + e.getMessage());
        }
    }

    private void setShipName() {
        if (this.shipList == null) return;
        for (int i = 0; i < 6; ++i) {
            if (this.shipList[i] != null) {
                this.shipName[i] = this.shipList[i].hasCustomName() ? this.shipList[i].getCustomNameTag() : this.shipList[i].getName();
            } else {
                this.shipName[i] = null;
            }
        }
    }

    @Override
    protected void keyTyped(char input, int keyID) throws IOException {
        if (this.textField.isFocused()) {
            if (keyID == 28 || keyID == 156) {
                handleRenameClick();
            } else if (keyID == 1) {
                this.unitNameState = -1;
            }
        }
        if (!this.textField.textboxKeyTyped(input, keyID)) {
            super.keyTyped(input, keyID);
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        this.textField.updateCursorCounter();
    }
}
