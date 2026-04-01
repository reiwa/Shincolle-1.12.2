package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.capability.CapaShipInventory;
import com.lulan.shincolle.client.gui.inventory.ContainerShipInventory;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipCV;
import com.lulan.shincolle.entity.IShipInvisible;
import com.lulan.shincolle.entity.destroyer.EntityDestroyerIkazuchi;
import com.lulan.shincolle.entity.destroyer.EntityDestroyerInazuma;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.network.C2SGUIPackets;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.reference.Enums;
import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.reference.unitclass.AttrsAdv;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.CombatHelper;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.GuiHelper;
import com.lulan.shincolle.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GuiShipInventory extends GuiContainer {
    private static final ResourceLocation TEXTURE_BG = new ResourceLocation("shincolle:textures/gui/GuiShipInventory.png");
    private static final ResourceLocation TEXTURE_ICON0 = new ResourceLocation("shincolle:textures/gui/GuiNameIcon0.png");
    private static final ResourceLocation TEXTURE_ICON1 = new ResourceLocation("shincolle:textures/gui/GuiNameIcon1.png");
    private static final ResourceLocation TEXTURE_ICON2 = new ResourceLocation("shincolle:textures/gui/GuiNameIcon2.png");
    private static final String LV_MARK = I18n.format("gui.shincolle:level");
    private static final String HP_MARK = I18n.format("gui.shincolle:hp");
    private static final String STR_ATTR_HP = I18n.format("gui.shincolle:hp");
    private static final String STR_ATTR_ATK = I18n.format("gui.shincolle:firepower1");
    private static final String STR_ATTR_AIR = I18n.format("gui.shincolle:firepower2");
    private static final String STR_ATTR_DEF = I18n.format("gui.shincolle:armor");
    private static final String STR_ATTR_SPD = I18n.format("gui.shincolle:attackspeed");
    private static final String STR_ATTR_MOV = I18n.format("gui.shincolle:movespeed");
    private static final String STR_ATTR_HIT = I18n.format("gui.shincolle:range");
    private static final String STR_ATTR_CRI = I18n.format("gui.shincolle:critical");
    private static final String STR_ATTR_DHIT = I18n.format("gui.shincolle:doublehit");
    private static final String STR_ATTR_THIT = I18n.format("gui.shincolle:triplehit");
    private static final String STR_ATTR_AA = I18n.format("gui.shincolle:antiair");
    private static final String STR_ATTR_ASM = I18n.format("gui.shincolle:antiss");
    private static final String STR_ATTR_MISS = I18n.format("gui.shincolle:missrate");
    private static final String STR_ATTR_MISSR = I18n.format("gui.shincolle:missreduce");
    private static final String STR_ATTR_DODGE = I18n.format("gui.shincolle:dodge");
    private static final String STR_ATTR_FPOS = I18n.format("gui.shincolle:formation.position");
    private static final String STR_ATTR_FORMAT = I18n.format("gui.shincolle:formation.formation");
    private static final String STR_ATTR_WEDDING = I18n.format("gui.shincolle:marriage");
    private static final String STR_ATTR_WED_TRUE = I18n.format("gui.shincolle:married");
    private static final String STR_ATTR_WED_FALSE = I18n.format("gui.shincolle:unmarried");
    private static final String STR_ATTR_MODERN = I18n.format("gui.shincolle:modernlevel");
    private static final String STR_ATTR_XP = I18n.format("gui.shincolle:equip.xp");
    private static final String STR_ATTR_GRUDGE = I18n.format("gui.shincolle:equip.grudge");
    private static final String STR_ATTR_AMMO = I18n.format("gui.shincolle:equip.ammo");
    private static final String STR_ATTR_HPRES = I18n.format("gui.shincolle:equip.hpres");
    private static final String STR_ATTR_KB = I18n.format("gui.shincolle:equip.kb");
    private static final String STR_MI_KILLS = I18n.format("gui.shincolle:kills");
    private static final String STR_MI_EXP = I18n.format("gui.shincolle:exp");
    private static final String STR_MI_AMMOL = I18n.format("gui.shincolle:ammolight");
    private static final String STR_MI_AMMOH = I18n.format("gui.shincolle:ammoheavy");
    private static final String STR_MI_GRUDGE = I18n.format("gui.shincolle:grudge");
    private static final String STR_MI_AIRL = I18n.format("gui.shincolle:airplanelight");
    private static final String STR_MI_AIRH = I18n.format("gui.shincolle:airplaneheavy");
    private static final String CAN_MELEE = I18n.format("gui.shincolle:canmelee");
    private static final String CAN_LATK = I18n.format("gui.shincolle:canlightattack");
    private static final String CAN_HATK = I18n.format("gui.shincolle:canheavyattack");
    private static final String CAN_ALATK = I18n.format("gui.shincolle:canairlightattack");
    private static final String CAN_AHATK = I18n.format("gui.shincolle:canairheavyattack");
    private static final String AURA_EFFECT = I18n.format("gui.shincolle:auraeffect");
    private static final String FOLLOW_MIN = I18n.format("gui.shincolle:followmin");
    private static final String FOLLOW_MAX = I18n.format("gui.shincolle:followmax");
    private static final String FLEE_HP = I18n.format("gui.shincolle:fleehp");
    private static final String TAR_AI = I18n.format("gui.shincolle:targetAI");
    private static final String STR_ONSIGHT = I18n.format("gui.shincolle:onsightAI");
    private static final String STR_PVP = I18n.format("gui.shincolle:ai.pvp");
    private static final String STR_AA = I18n.format("gui.shincolle:ai.aa");
    private static final String STR_ASM = I18n.format("gui.shincolle:ai.asm");
    private static final String STR_TIMEKEEP = I18n.format("gui.shincolle:ai.timekeeper");
    private static final String STR_PICK = I18n.format("gui.shincolle:ai.pickitem");
    private static final String STR_WPSTAY = I18n.format("gui.shincolle:ai.wpstay");
    private static final String STR_SHOW_HELD = I18n.format("gui.shincolle:showhelditem");
    private static final String STR_AUTOCR = I18n.format("gui.shincolle:autocombatration");
    private static final String STR_AUTOPUMP = I18n.format("gui.shincolle:autopump");
    private static final String STR_APPEAR = I18n.format("gui.shincolle:appearance");
    private static final String STR_META = I18n.format("gui.shincolle:crane.usemeta");
    private static final String STR_DICT = I18n.format("gui.shincolle:crane.useoredict");
    private static final String STR_NBT = I18n.format("gui.shincolle:crane.usenbt");
    private static final String STR_INPUT = I18n.format("gui.shincolle:ai.inputside");
    private static final String STR_OUTPUT = I18n.format("gui.shincolle:ai.outputside");
    private static final String STR_FUEL = I18n.format("gui.shincolle:ai.fuelside");
    private static final String STR_COOK = I18n.format("gui.shincolle:ai.cooking");
    private static final String STR_FISH = I18n.format("gui.shincolle:ai.fishing");
    private static final String STR_MINE = I18n.format("gui.shincolle:ai.mining");
    private static final String STR_CRAFT = I18n.format("gui.shincolle:ai.crafting");
    private static final String[] STR_MORALE = {
            I18n.format("gui.shincolle:morale0"), I18n.format("gui.shincolle:morale1"),
            I18n.format("gui.shincolle:morale2"), I18n.format("gui.shincolle:morale3"),
            I18n.format("gui.shincolle:morale4")
    };
    private static final int[] BT_COLS = {189, 205, 222};

    public BasicEntityShip entity;
    public InventoryPlayer player;
    private final BasicEntityShip[] shipRiding = new BasicEntityShip[3];
    private final AttrsAdv attrs;
    private int widthHoveringText1;
    private int widthHoveringText3;
    private final List<String> mouseoverList;
    private String strATK;
    private String strAATK;
    private int showPage;
    private int showPageAI;
    private int showAttack;
    private int barPos;
    private int mousePressBar;
    private final int maxBtn;
    private float xMouse;
    private float yMouse;
    private final int[][] iconXY;

    public GuiShipInventory(InventoryPlayer invPlayer, BasicEntityShip entity) {
        super(new ContainerShipInventory(invPlayer, entity));
        this.entity = entity;
        this.player = invPlayer;
        this.xSize = 256;
        this.ySize = 214;
        this.mouseoverList = new ArrayList<>();
        this.showPage = 1;
        this.showPageAI = 1;
        this.showAttack = 1;
        this.mousePressBar = -1;
        this.attrs = (AttrsAdv) this.entity.getAttrs();
        this.shipRiding[0] = this.entity;
        this.maxBtn = this.entity.getStateMinor(13);
        this.iconXY = new int[2][3];
        this.initRidingShip();
    }

    private void initRidingShip() {
        int shipType = this.entity.getShipType();
        int shipClass = this.entity.getShipClass();
        if ((this.entity instanceof EntityDestroyerInazuma || this.entity instanceof EntityDestroyerIkazuchi) && this.entity.getRidingState() > 1) {
            shipType = 2;
            shipClass = 55;
            if (this.entity.getRidingEntity() instanceof EntityDestroyerInazuma) {
                this.shipRiding[2] = (BasicEntityShip) this.entity.getRidingEntity();
            } else if (!this.entity.getPassengers().isEmpty() && this.entity.getPassengers().get(0) instanceof EntityDestroyerIkazuchi) {
                this.shipRiding[1] = (BasicEntityShip) this.entity.getPassengers().get(0);
            }
        }
        this.iconXY[0] = Values.ShipTypeIconMap.get((byte) shipType);
        this.iconXY[1] = Values.ShipNameIconMap.get(shipClass);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.widthHoveringText1 = Stream.of(STR_ATTR_ATK, STR_ATTR_AIR, STR_ATTR_CRI, STR_ATTR_DHIT, STR_ATTR_THIT, STR_ATTR_AA, STR_ATTR_ASM, STR_ATTR_MODERN, STR_ATTR_XP, STR_ATTR_GRUDGE, STR_ATTR_AMMO, STR_ATTR_HPRES, STR_ATTR_MISS, STR_ATTR_DODGE, STR_ATTR_KB, STR_ATTR_HP)
                .mapToInt(this.fontRenderer::getStringWidth)
                .max()
                .orElse(0);
        this.widthHoveringText3 = Stream.of(STR_ATTR_FPOS, STR_ATTR_ATK, STR_ATTR_AIR, STR_ATTR_DEF, STR_ATTR_DODGE, STR_ATTR_MISSR, STR_ATTR_CRI, STR_ATTR_DHIT, STR_ATTR_THIT, STR_ATTR_AA, STR_ATTR_ASM, STR_ATTR_MOV)
                .mapToInt(this.fontRenderer::getStringWidth)
                .max()
                .orElse(0);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j) {
        this.fontRenderer.drawString(this.entity.getCustomNameTag(), 8, 6, 0);
        this.drawAttributes();
        this.handleHoveringText();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableBlend();
        this.mc.getTextureManager().bindTexture(TEXTURE_BG);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        drawInventoryPageIndicators();
        drawMainPageIndicator();
        drawAIPage();
        drawShipAndMoraleIcons();
        drawEntityModel(this.guiLeft + 218, this.guiTop + 100, this.entity.getModelPos(), (this.guiLeft + 215) - this.xMouse, (this.guiTop + 60) - this.yMouse, this.shipRiding);
        GlStateManager.disableBlend();
    }

    private void drawOnOffButton(int x, int y, boolean state) {
        this.drawTexturedModalRect(this.guiLeft + x, this.guiTop + y, state ? 0 : 11, 214, 11, 11);
    }

    private void drawSlider(int x, int y, int pos) {
        this.drawTexturedModalRect(this.guiLeft + x, this.guiTop + y, 31, 214, 43, 3);
        this.drawTexturedModalRect(this.guiLeft + x - 4 + pos, this.guiTop + y - 3, 22, 214, 9, 9);
    }

    private void drawInventoryPageIndicators() {
        switch (this.entity.getInventoryPageSize()) {
            case 1: this.drawTexturedModalRect(this.guiLeft + 62, this.guiTop + 90, 80, 214, 6, 34); break;
            case 2: break;
            default:
                this.drawTexturedModalRect(this.guiLeft + 62, this.guiTop + 54, 80, 214, 6, 34);
                this.drawTexturedModalRect(this.guiLeft + 62, this.guiTop + 90, 80, 214, 6, 34);
                break;
        }
        int pageIndicatorY;
        switch (this.entity.getCapaShipInventory().getInventoryPage()) {
            case 1: pageIndicatorY = 54; break;
            case 2: pageIndicatorY = 90; break;
            default: pageIndicatorY = 18; break;
        }
        this.drawTexturedModalRect(this.guiLeft + 62, this.guiTop + pageIndicatorY, 74, 214, 6, 34);
    }

    private void drawMainPageIndicator() {
        int pageIndicatorY;
        switch (this.showPage) {
            case 1: pageIndicatorY = 18; break;
            case 2: pageIndicatorY = 54; break;
            case 3: pageIndicatorY = 90; break;
            default: return;
        }
        this.drawTexturedModalRect(this.guiLeft + 135, this.guiTop + pageIndicatorY, 74, 214, 6, 34);
    }

    private void drawAIPage() {
        int[] indicatorPos;
        switch (this.showPageAI) {
            case 1: indicatorPos = new int[]{239, 131}; drawAIPage1Background(); break;
            case 2: indicatorPos = new int[]{239, 144}; drawAIPage2Background(); break;
            case 3: indicatorPos = new int[]{239, 157}; drawAIPage3Background(); break;
            case 4: indicatorPos = new int[]{239, 170}; drawAIPage4Background(); break;
            case 5: indicatorPos = new int[]{239, 183}; drawAIPage5Background(); break;
            case 6: indicatorPos = new int[]{239, 196}; drawAIPage6Background(); break;
            case 7: indicatorPos = new int[]{246, 131}; drawAIPage7Background(); break;
            case 8: indicatorPos = new int[]{246, 144}; drawAIPage8Background(); break;
            case 9: indicatorPos = new int[]{246, 157}; break;
            case 10: indicatorPos = new int[]{246, 170}; break;
            case 11: indicatorPos = new int[]{246, 183}; break;
            case 12: indicatorPos = new int[]{246, 196}; break;
            default: return;
        }
        if (indicatorPos[0] != -1) {
            this.drawTexturedModalRect(this.guiLeft + indicatorPos[0], this.guiTop + indicatorPos[1], 74, 214, 6, 11);
        }
    }

    private void drawAIPage1Background() {
        boolean[] flags = {
                this.entity.getStateFlag(3), this.entity.getStateFlag(4), this.entity.getStateFlag(5),
                this.entity.getStateFlag(6), this.entity.getStateFlag(7), this.entity.getStateFlag(9)
        };
        boolean[] attackTypes = {
                true, this.entity.getStateFlag(13), this.entity.getStateFlag(14),
                this.entity.getStateFlag(15), this.entity.getStateFlag(16), this.entity.getStateFlag(17)
        };
        for (int i = 0; i < 6; ++i) {
            if (attackTypes[i]) {
                drawOnOffButton(174, 131 + i * 13, flags[i]);
            }
        }
    }

    private void drawAIPage2Background() {
        int fMinPos = (int) ((this.entity.getStateMinor(10) - 1) / 30.0f * 42.0f);
        int fMaxPos = (int) ((this.entity.getStateMinor(11) - 2) / 30.0f * 42.0f);
        int fleeHPPos = (int) (this.entity.getStateMinor(12) / 100.0f * 42.0f);
        if (this.mousePressBar == 0) drawSlider(191, 148, this.barPos); else drawSlider(191, 148, fMinPos);
        if (this.mousePressBar == 1) drawSlider(191, 172, this.barPos); else drawSlider(191, 172, fMaxPos);
        if (this.mousePressBar == 2) drawSlider(191, 196, this.barPos); else drawSlider(191, 196, fleeHPPos);
    }

    private void drawAIPage3Background() {
        boolean[] flags = {
                this.entity.getStateFlag(21), this.entity.getStateFlag(12), this.entity.getStateFlag(18),
                this.entity.getStateFlag(19), this.entity.getStateFlag(20), this.entity.getStateFlag(22)
        };
        for (int i = 0; i < flags.length; ++i) {
            drawOnOffButton(174, 131 + i * 13, flags[i]);
        }
    }

    private void drawAIPage4Background() {
        if (this.entity.getStateFlag(24)) {
            drawOnOffButton(174, 131, this.entity.getStateFlag(23));
        }
        drawOnOffButton(174, 144, this.entity.getStateFlag(26));
    }

    private void drawAIPage5Background() {
        int wpStayPos = (int) (this.entity.getStateMinor(44) * 0.0625f * 42.0f);
        int autoCRPos = (int) ((this.entity.getStateMinor(9) - 1) * 14.0f);
        if (this.mousePressBar == 3) drawSlider(191, 148, this.barPos); else drawSlider(191, 148, wpStayPos);
        if (this.mousePressBar == 4) drawSlider(191, 172, this.barPos); else drawSlider(191, 172, autoCRPos);
    }

    private void drawAIPage6Background() {
        drawOnOffButton(174, 131, this.entity.getStateFlag(25));
        int modelstate = this.entity.getStateEmotion(0);
        int numbtn = 0;
        for (int i = 0; i < 4 && numbtn <= this.maxBtn; ++i) {
            for (int j = 0; j < 4 && ++numbtn <= this.maxBtn; ++j) {
                boolean state = (modelstate & Values.N.Pow2[numbtn - 1]) != 0;
                drawOnOffButton(176 + j * 16, 157 + i * 13, state);
            }
        }
    }

    private void drawAIPage7Background() {
        int tside = this.entity.getStateMinor(41);
        this.drawTexturedModalRect(this.guiLeft + 174, this.guiTop + 136, 87, 214, 64, 16);
        this.drawTexturedModalRect(this.guiLeft + 174, this.guiTop + 138, 151, 237, 64, 16);
        int taskType = this.entity.getStateMinor(40);
        if(taskType >= 1 && taskType <= 4) {
            this.drawTexturedModalRect(this.guiLeft + 174 + (taskType - 1) * 16, this.guiTop + 136, 87 + (taskType - 1) * 16, 230, 16, 16);
        }
        this.drawTexturedModalRect(this.guiLeft + 177, this.guiTop + 157, 0, (tside & Values.N.Pow2[18]) != 0 ? 236 : 225, 11, 11);
        this.drawTexturedModalRect(this.guiLeft + 177, this.guiTop + 170, 11, (tside & Values.N.Pow2[19]) != 0 ? 236 : 225, 11, 11);
        this.drawTexturedModalRect(this.guiLeft + 177, this.guiTop + 183, 22, (tside & Values.N.Pow2[20]) != 0 ? 236 : 225, 11, 11);
    }

    private void drawAIPage8Background() {
        int tside = this.entity.getStateMinor(41);
        int[] yCoords = {144, 170, 196};
        for (int y : yCoords) {
            this.drawTexturedModalRect(this.guiLeft + 173, this.guiTop + y, 151, 214, 66, 11);
        }
        for (int i = 0; i < 18; ++i) {
            if ((tside & Values.N.Pow2[i]) != 0) {
                int dx = i % 6 * 11;
                int dy = i / 6 * 26;
                this.drawTexturedModalRect(this.guiLeft + 173 + dx, this.guiTop + 144 + dy, 151 + dx, 225, 11, 11);
            }
        }
    }

    private void drawShipAndMoraleIcons() {
        if (this.entity.getCapaShipInventory().getInventoryPage() == 0) {
            drawTaskIcons();
        }
        try {
            this.mc.getTextureManager().bindTexture(TEXTURE_ICON0);
            int u = 0;
            int v = this.entity.getStateMinor(0) > 99 ? 0 : 43;
            int w = this.entity.getStateMinor(0) > 99 ? 40 : 30;
            int h = this.entity.getStateMinor(0) > 99 ? 42 : 30;
            this.drawTexturedModalRect(this.guiLeft + 165, this.guiTop + 18, u, v, w, h);
            this.drawTexturedModalRect(this.guiLeft + 167, this.guiTop + 22, this.iconXY[0][0], this.iconXY[0][1], 28, 28);
            this.drawTexturedModalRect(this.guiLeft + 239, this.guiTop + 18, EntityHelper.getMoraleLevel(this.entity.getMorale()) * 11, 240, 11, 11);
            int offy = 0;
            if (this.iconXY[1][0] < 100) {
                this.mc.getTextureManager().bindTexture(TEXTURE_ICON1);
                if (this.iconXY[1][0] == 4) offy = -10;
            } else {
                this.mc.getTextureManager().bindTexture(TEXTURE_ICON2);
                offy = this.iconXY[1][0] == 6 ? -10 : 10;
            }
            this.drawTexturedModalRect(this.guiLeft + 176, this.guiTop + 63 + offy, this.iconXY[1][1], this.iconXY[1][2], 11, 59);
        } catch (Exception e) {
            LogHelper.info("Exception: ship GUI: get name icon fail " + e);
        }
    }

    private void drawTaskIcons() {
        int u;
        int v;
        switch (this.entity.getStateMinor(40)) {
            case 1: u = 151; v = 236; break;
            case 2: u = 167; v = 236; break;
            case 3: u = 183; v = 236; break;
            case 4: u = 199; v = 236; drawCraftingSlots(); break;
            default: return;
        }
        this.drawTexturedModalRect(this.guiLeft + 25, this.guiTop + 107, 33, 225, 18, 18);
        this.drawTexturedModalRect(this.guiLeft + 26, this.guiTop + 109, u, v, 18, 18);
    }

    private void drawCraftingSlots() {
        CapaShipInventory inv = this.entity.getCapaShipInventory();
        for (int i = 0; i < 9; ++i) {
            int u = inv.getStackInSlot(i + 12).isEmpty() ? 33 : 51;
            this.drawTexturedModalRect(this.guiLeft + 7 + i % 3 * 18, this.guiTop + 53 + i / 3 * 18, u, 225, 18, 18);
        }
    }

    private void handleHoveringText() {
        this.mouseoverList.clear();
        if (isHovering(238, 17, 13, 13)) {
            addMoraleHoveringText();
        } else if (isHovering(145, 4, 57, 11)) {
            addModernizationHoveringText();
        } else if (isHovering(73, 18, 61, 108)) {
            addMainPageHoveringText();
        } else if (this.showPageAI == 7 && isHovering(173, 131, 66, 76)) {
            addAIPage7HoveringText();
        }
    }

    private boolean isHovering(int x, int y, int width, int height) {
        return this.xMouse >= (x + this.guiLeft) && this.xMouse < (x + width + this.guiLeft) &&
                this.yMouse >= (y + this.guiTop) && this.yMouse < (y + height + this.guiTop);
    }

    private void addModernizationHoveringText() {
        this.mouseoverList.add(STR_ATTR_MODERN + " " + this.attrs.getAttrsBonus(0));
        this.drawHoveringText(this.mouseoverList, 145, 32, this.fontRenderer);
    }

    private void addMoraleHoveringText() {
        this.mouseoverList.add(STR_MORALE[EntityHelper.getMoraleLevel(this.entity.getMorale())]);
        this.drawHoveringText(this.mouseoverList, 120, 30, this.fontRenderer);
        List<String> labels = new ArrayList<>();
        List<String> values = new ArrayList<>();
        addStatInfo(labels, values, TextFormatting.RED, STR_ATTR_ATK, "x %.0f %% / %.0f %%", attrs.getAttrsMorale(1) * 100.0f, attrs.getAttrsMorale(2) * 100.0f);
        addStatInfo(labels, values, TextFormatting.RED, STR_ATTR_AIR, "x %.0f %% / %.0f %%", attrs.getAttrsMorale(3) * 100.0f, attrs.getAttrsMorale(4) * 100.0f);
        addStatInfo(labels, values, TextFormatting.WHITE, STR_ATTR_SPD, "x %.0f %%", attrs.getAttrsMorale(6) * 100.0f);
        addStatInfo(labels, values, TextFormatting.LIGHT_PURPLE, STR_ATTR_HIT, "+ %.1f", attrs.getAttrsMorale(8));
        addStatInfo(labels, values, TextFormatting.AQUA, STR_ATTR_CRI, "x %.0f %%", attrs.getAttrsMorale(9) * 100.0f);
        addStatInfo(labels, values, TextFormatting.YELLOW, STR_ATTR_DHIT, "x %.0f %%", attrs.getAttrsMorale(10) * 100.0f);
        addStatInfo(labels, values, TextFormatting.GOLD, STR_ATTR_THIT, "x %.0f %%", attrs.getAttrsMorale(11) * 100.0f);
        addStatInfo(labels, values, TextFormatting.RED, STR_ATTR_MISSR, "x %.0f %%", attrs.getAttrsMorale(12) * 100.0f);
        addStatInfo(labels, values, TextFormatting.YELLOW, STR_ATTR_AA, "x %.0f %%", attrs.getAttrsMorale(13) * 100.0f);
        addStatInfo(labels, values, TextFormatting.AQUA, STR_ATTR_ASM, "x %.0f %%", attrs.getAttrsMorale(14) * 100.0f);
        addStatInfo(labels, values, TextFormatting.WHITE, STR_ATTR_DEF, "+ %.0f %%", attrs.getAttrsMorale(5) * 100.0f);
        addStatInfo(labels, values, TextFormatting.GOLD, STR_ATTR_DODGE, "+ %.0f %%", attrs.getAttrsMorale(15) * 100.0f);
        addStatInfo(labels, values, TextFormatting.GREEN, STR_ATTR_XP, "+ %.0f %%", attrs.getAttrsMorale(16) * 100.0f);
        addStatInfo(labels, values, TextFormatting.DARK_PURPLE, STR_ATTR_GRUDGE, "+ %.0f %%", attrs.getAttrsMorale(17) * 100.0f);
        addStatInfo(labels, values, TextFormatting.DARK_AQUA, STR_ATTR_AMMO, "+ %.0f %%", attrs.getAttrsMorale(18) * 100.0f);
        addStatInfo(labels, values, TextFormatting.DARK_GREEN, STR_ATTR_HPRES, "+ %.0f %%", attrs.getAttrsMorale(19) * 100.0f);
        addStatInfo(labels, values, TextFormatting.DARK_RED, STR_ATTR_KB, "+ %.0f %%", attrs.getAttrsMorale(20) * 100.0f);
        addStatInfo(labels, values, TextFormatting.GRAY, STR_ATTR_MOV, "+ %.2f", attrs.getAttrsMorale(7));
        this.drawHoveringText(labels, 120, 46, this.fontRenderer);
        this.drawHoveringText(values, 126 + this.widthHoveringText3, 46, this.fontRenderer);
    }

    private void addStatInfo(List<String> labels, List<String> values, TextFormatting color, String label, String format, Object... args) {
        labels.add(color + label);
        values.add(String.format(format, args));
    }

    private void addMainPageHoveringText() {
        switch (this.showPage) {
            case 2: addPage2HoveringText(); break;
            case 3: addPage3HoveringText(); break;
            default:
        }
    }

    private void addPage2HoveringText() {
        int y = (int) (this.yMouse - this.guiTop);
        if (y < 41) addPage2HoveringTextTop();
        else if (y < 62) addModernBonusHoveringText(2, 78);
        else if (y < 83) addModernBonusHoveringText(3, 99);
        else if (y < 104) addModernBonusHoveringText(4, 120);
        else if (y < 126) addModernBonusHoveringText(5, 142);
    }

    private void addModernBonusHoveringText(int bonusType, int yPos) {
        this.mouseoverList.add(STR_ATTR_MODERN + " " + this.attrs.getAttrsBonus(bonusType));
        this.drawHoveringText(this.mouseoverList, 55, yPos, this.fontRenderer);
    }

    private void addPage2HoveringTextTop() {
        List<String> labels = new ArrayList<>();
        List<String> values = new ArrayList<>();
        labels.add(STR_ATTR_MODERN); values.add(String.valueOf(this.attrs.getAttrsBonus(1)));
        labels.add(TextFormatting.RED + STR_ATTR_ATK); values.add(this.strATK);
        labels.add(TextFormatting.RED + STR_ATTR_AIR); values.add(this.strAATK);
        labels.add(TextFormatting.AQUA + STR_ATTR_CRI); values.add((int) (this.attrs.getAttrsBuffed(9) * 100.0f) + " %");
        labels.add(TextFormatting.YELLOW + STR_ATTR_DHIT); values.add((int) (this.attrs.getAttrsBuffed(10) * 100.0f) + " %");
        labels.add(TextFormatting.GOLD + STR_ATTR_THIT); values.add((int) (this.attrs.getAttrsBuffed(11) * 100.0f) + " %");
        labels.add(TextFormatting.YELLOW + STR_ATTR_AA); values.add(String.valueOf((int)this.attrs.getAttrsBuffed(13)));
        labels.add(TextFormatting.AQUA + STR_ATTR_ASM); values.add(String.valueOf((int)this.attrs.getAttrsBuffed(14)));
        int missNear = (int)(CombatHelper.calcMissRate(this.entity, 0.0f) * 100.0f);
        int missFar = (int)(CombatHelper.calcMissRate(this.entity, this.attrs.getAttackRange()) * 100.0f);
        labels.add(TextFormatting.RED + STR_ATTR_MISS); values.add(missNear + " ~ " + missFar + " %");
        float dodgeValue = Math.min(this.attrs.getAttrsBuffed(15) + (this.entity instanceof IShipInvisible ? ((IShipInvisible) this.entity).getInvisibleLevel() : 0), (float)ConfigHandler.limitShipAttrs[15]);
        labels.add(TextFormatting.GOLD + STR_ATTR_DODGE); values.add(String.format("%.0f", dodgeValue * 100.0f) + " %");
        labels.add(TextFormatting.GREEN + STR_ATTR_XP); values.add((int) ((this.attrs.getAttrsBuffed(16) - 1.0f) * 100.0f) + " %");
        labels.add(TextFormatting.DARK_PURPLE + STR_ATTR_GRUDGE); values.add((int) ((this.attrs.getAttrsBuffed(17) - 1.0f) * 100.0f) + " %");
        labels.add(TextFormatting.DARK_AQUA + STR_ATTR_AMMO); values.add((int) ((this.attrs.getAttrsBuffed(18) - 1.0f) * 100.0f) + " %");
        labels.add(TextFormatting.DARK_GREEN + STR_ATTR_HPRES); values.add((int) ((this.attrs.getAttrsBuffed(19) - 1.0f) * 100.0f) + " %");
        labels.add(TextFormatting.DARK_RED + STR_ATTR_KB); values.add((int) (this.attrs.getAttrsBuffed(20) * 100.0f) + " %");
        this.drawHoveringText(labels, 55, 57, this.fontRenderer);
        this.drawHoveringText(values, 61 + widthHoveringText1, 57, this.fontRenderer);
    }

    private void addPage3HoveringText() {
        if (this.yMouse >= (40 + this.guiTop) && this.yMouse < (62 + this.guiTop) && this.entity.getStateMinor(26) >= 1) {
            List<String> labels = new ArrayList<>();
            List<String> values = new ArrayList<>();
            addStatInfo(labels, values, TextFormatting.LIGHT_PURPLE, STR_ATTR_FPOS, String.valueOf(this.entity.getStateMinor(27) + 1));
            addStatInfo(labels, values, TextFormatting.RED, STR_ATTR_ATK, "x %.0f %% / %.0f %%", attrs.getAttrsFormation(1) * 100.0f, attrs.getAttrsFormation(2) * 100.0f);
            addStatInfo(labels, values, TextFormatting.RED, STR_ATTR_AIR, "x %.0f %% / %.0f %%", attrs.getAttrsFormation(3) * 100.0f, attrs.getAttrsFormation(4) * 100.0f);
            addStatInfo(labels, values, TextFormatting.WHITE, STR_ATTR_SPD, "x %.0f %%", attrs.getAttrsFormation(6) * 100.0f);
            addStatInfo(labels, values, TextFormatting.LIGHT_PURPLE, STR_ATTR_HIT, "+ %.1f", attrs.getAttrsFormation(8));
            addStatInfo(labels, values, TextFormatting.AQUA, STR_ATTR_CRI, "x %.0f %%", attrs.getAttrsFormation(9) * 100.0f);
            addStatInfo(labels, values, TextFormatting.YELLOW, STR_ATTR_DHIT, "x %.0f %%", attrs.getAttrsFormation(10) * 100.0f);
            addStatInfo(labels, values, TextFormatting.GOLD, STR_ATTR_THIT, "x %.0f %%", attrs.getAttrsFormation(11) * 100.0f);
            addStatInfo(labels, values, TextFormatting.RED, STR_ATTR_MISSR, "x %.0f %%", attrs.getAttrsFormation(12) * 100.0f);
            addStatInfo(labels, values, TextFormatting.YELLOW, STR_ATTR_AA, "x %.0f %%", attrs.getAttrsFormation(13) * 100.0f);
            addStatInfo(labels, values, TextFormatting.AQUA, STR_ATTR_ASM, "x %.0f %%", attrs.getAttrsFormation(14) * 100.0f);
            addStatInfo(labels, values, TextFormatting.WHITE, STR_ATTR_DEF, "x %.0f %%", attrs.getAttrsFormation(5) * 100.0f);
            addStatInfo(labels, values, TextFormatting.GOLD, STR_ATTR_DODGE, "+ %.0f %%", attrs.getAttrsFormation(15) * 100.0f);
            addStatInfo(labels, values, TextFormatting.DARK_PURPLE, STR_ATTR_GRUDGE, "+ %.0f %%", attrs.getAttrsFormation(17) * 100.0f);
            addStatInfo(labels, values, TextFormatting.DARK_GREEN, STR_ATTR_HPRES, "+ %.0f %%", attrs.getAttrsFormation(19) * 100.0f);
            addStatInfo(labels, values, TextFormatting.DARK_RED, STR_ATTR_KB, "+ %.0f %%", attrs.getAttrsFormation(20) * 100.0f);
            addStatInfo(labels, values, TextFormatting.GRAY, STR_ATTR_MOV, "+ %.2f", attrs.getAttrsFormation(7));
            this.drawHoveringText(labels, 128, 35, this.fontRenderer);
            this.drawHoveringText(values, 134 + widthHoveringText3, 35, this.fontRenderer);
        }
    }

    private void addAIPage7HoveringText() {
        int y = (int)(this.yMouse - this.guiTop);
        int x = (int)(this.xMouse - this.guiLeft);
        if (y <= 157) {
            if (x <= 189) this.mouseoverList.add(STR_COOK);
            else if (x <= 205) this.mouseoverList.add(STR_FISH);
            else if (x <= 221) this.mouseoverList.add(STR_MINE);
            else this.mouseoverList.add(STR_CRAFT);
            this.drawHoveringText(this.mouseoverList, 167, 170, this.fontRenderer);
        } else if (y <= 170) {
            this.mouseoverList.add(STR_META);
            this.drawHoveringText(this.mouseoverList, 145, 185, this.fontRenderer);
        } else if (y <= 183) {
            this.mouseoverList.add(STR_DICT);
            this.drawHoveringText(this.mouseoverList, 145, 198, this.fontRenderer);
        } else if (y <= 196) {
            this.mouseoverList.add(STR_NBT);
            this.drawHoveringText(this.mouseoverList, 145, 211, this.fontRenderer);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float f) {
        super.drawScreen(mouseX, mouseY, f);
        this.xMouse = mouseX;
        this.yMouse = mouseY;
    }

    public static void drawEntityModel(int x, int y, float[] modelPos, float yaw, float pitch, BasicEntityShip[] entity) {
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate(x + modelPos[0], y + modelPos[1], 50.0f + modelPos[2]);
        GlStateManager.scale(-modelPos[3], modelPos[3], modelPos[3]);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-((float)Math.atan(pitch / 40.0f)) * 20.0f, 1.0f, 0.0f, 0.0f);
        entity[0].renderYawOffset = (float)Math.atan(yaw / 40.0f) * 20.0f;
        entity[0].rotationYaw = (float)Math.atan(yaw / 40.0f) * 40.0f;
        entity[0].rotationPitch = -((float)Math.atan(pitch / 40.0f)) * 20.0f;
        entity[0].rotationYawHead = entity[0].rotationYaw;
        entity[0].prevRotationYawHead = entity[0].rotationYaw;
        if (entity[2] != null) setEntityRotation(entity[2], entity[0]);
        else if (entity[1] != null) setEntityRotation(entity[1], entity[0]);
        GlStateManager.translate(0.0, entity[0].getYOffset(), 0.0);
        rendermanager.setPlayerViewY(180.0f);
        rendermanager.setRenderShadow(false);
        if (entity[1] != null) drawRidingEntityModel(rendermanager, entity[1], entity[0]);
        else if (entity[2] != null) drawRidingEntityModel(rendermanager, entity[0], entity[2]);
        else rendermanager.renderEntity(entity[0], 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        rendermanager.setRenderShadow(true);
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    private static void setEntityRotation(BasicEntityShip target, BasicEntityShip source) {
        target.renderYawOffset = source.renderYawOffset;
        target.rotationYaw = source.rotationYaw;
        target.rotationPitch = source.rotationPitch;
        target.rotationYawHead = source.rotationYawHead;
        target.prevRotationYawHead = source.prevRotationYawHead;
    }

    private static void drawRidingEntityModel(RenderManager rendermanager, BasicEntityShip rider, BasicEntityShip riding) {
        float specialOffset = 0.0f;
        if (rider.getShipClass() == 53 || rider.getShipClass() == 54) {
            boolean isSitting = riding.isSitting();
            if (riding.getStateEmotion(1) == 4) specialOffset = isSitting ? -0.34f : -0.57f;
            else specialOffset = isSitting ? -0.55f : -0.45f;
        }
        float[] partPos = CalcHelper.rotateXZByAxis(-0.2f, 0.0f, riding.renderYawOffset % 360.0f / 57.2957f, 1.0f);
        GlStateManager.translate(partPos[1], (float)riding.getMountedYOffset() + specialOffset, partPos[0]);
        rendermanager.renderEntity(rider, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        GlStateManager.translate(-partPos[1], -((float)riding.getMountedYOffset() + specialOffset), -partPos[0]);
        rendermanager.renderEntity(riding, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
    }

    private void drawAttributes() {
        drawCommonAttributes();
        drawPageSpecificAttributes();
        drawAIPageSpecificAttributes();
    }

    private void drawCommonAttributes() {
        int hpCurrent = MathHelper.ceil(this.entity.getHealth());
        int hpMax = MathHelper.ceil(this.entity.getMaxHealth());
        this.fontRenderer.drawStringWithShadow(LV_MARK, (231 - this.fontRenderer.getStringWidth(LV_MARK)), 6.0f, 65535);
        this.fontRenderer.drawStringWithShadow(HP_MARK, (145 - this.fontRenderer.getStringWidth(HP_MARK)), 6.0f, 65535);
        this.fontRenderer.drawStringWithShadow(String.valueOf(this.entity.getLevel()), (this.xSize - 6 - this.fontRenderer.getStringWidth(String.valueOf(this.entity.getLevel()))), 6.0f, this.entity.getLevel() < 150 ? 0xFFFFFF : 16766720);
        this.fontRenderer.drawStringWithShadow(String.valueOf(hpCurrent), 147.0f, 6.0f, hpCurrent < hpMax ? GuiHelper.getDarkerColor(GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(0)), 0.8f) : GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(0)));
        this.fontRenderer.drawStringWithShadow("/" + hpMax, (148 + this.fontRenderer.getStringWidth(String.valueOf(hpCurrent))), 6.0f, GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(0)));
    }

    private void drawAttributeLine(String label, String value, int x, int y, int yValOffset, int color) {
        this.fontRenderer.drawString(label, x, y, 0);
        this.fontRenderer.drawStringWithShadow(value, (133 - this.fontRenderer.getStringWidth(value)), (float)y + yValOffset, color);
    }

    private void drawPageSpecificAttributes() {
        switch (this.showPage) {
            case 1: drawPage1Attributes(); break;
            case 2: drawPage2Attributes(); break;
            case 3: drawPage3Attributes(); break;
            default:
        }
    }

    private void drawPage1Attributes() {
        this.entity.setExpNext();
        drawAttributeLine(STR_MI_KILLS, String.valueOf(this.entity.getStateMinor(1)), 75, 20, 10, Enums.EnumColors.WHITE.getValue());
        drawAttributeLine(STR_MI_EXP, this.entity.getStateMinor(2) + "/" + this.entity.getStateMinor(3), 75, 41, 10, Enums.EnumColors.WHITE.getValue());
        drawAttributeLine(STR_MI_AMMOL, String.valueOf(this.entity.getStateMinor(4)), 75, 62, 10, Enums.EnumColors.WHITE.getValue());
        drawAttributeLine(STR_MI_AMMOH, String.valueOf(this.entity.getStateMinor(5)), 75, 83, 10, Enums.EnumColors.WHITE.getValue());
        drawAttributeLine(STR_MI_GRUDGE, String.valueOf(this.entity.getStateMinor(6)), 75, 104, 10, Enums.EnumColors.WHITE.getValue());
    }

    private void drawPage2Attributes() {
        this.strATK = String.format("%.1f", this.attrs.getAttrsBuffed(1)) + " / " + String.format("%.1f", this.attrs.getAttrsBuffed(2));
        this.strAATK = String.format("%.1f", this.attrs.getAttrsBuffed(3)) + " / " + String.format("%.1f", this.attrs.getAttrsBuffed(4));
        String atkLabel = this.showAttack == 1 ? STR_ATTR_ATK : STR_ATTR_AIR;
        String atkValue = this.showAttack == 1 ? this.strATK : this.strAATK;
        drawAttributeLine(atkLabel, atkValue, 75, 20, 10, GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(1)));
        drawAttributeLine(STR_ATTR_DEF, String.format("%.1f", this.attrs.getAttrsBuffed(5) * 100.0f) + "%", 75, 41, 10, GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(2)));
        drawAttributeLine(STR_ATTR_SPD, String.format("%.2f", this.attrs.getAttrsBuffed(6)), 75, 62, 10, GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(3)));
        drawAttributeLine(STR_ATTR_MOV, String.format("%.2f", this.attrs.getAttrsBuffed(7)), 75, 83, 10, GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(4)));
        drawAttributeLine(STR_ATTR_HIT, String.format("%.1f", this.attrs.getAttrsBuffed(8)), 75, 104, 10, GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(5)));
    }

    private void drawPage3Attributes() {
        String marriage = this.entity.getStateFlag(1) ? STR_ATTR_WED_TRUE : STR_ATTR_WED_FALSE;
        String formation = I18n.format("gui.shincolle:formation.format" + this.entity.getStateMinor(26));
        drawAttributeLine(STR_ATTR_WEDDING, marriage, 75, 20, 10, Enums.EnumColors.YELLOW.getValue());
        drawAttributeLine(STR_ATTR_FORMAT, formation, 75, 41, 10, Enums.EnumColors.WHITE.getValue());
        if (this.entity instanceof BasicEntityShipCV) {
            drawAttributeLine(STR_MI_AIRL, String.valueOf(((BasicEntityShipCV)this.entity).getNumAircraftLight()), 75, 83, 10, Enums.EnumColors.YELLOW.getValue());
            drawAttributeLine(STR_MI_AIRH, String.valueOf(((BasicEntityShipCV)this.entity).getNumAircraftHeavy()), 75, 104, 10, Enums.EnumColors.YELLOW.getValue());
        }
    }

    private void drawAIPageSpecificAttributes() {
        switch (this.showPageAI) {
            case 1: drawAIPage1Labels(); break;
            case 2: drawAIPage2Labels(); break;
            case 3: drawAIPage3Labels(); break;
            case 4: drawAIPage4Labels(); break;
            case 5: drawAIPage5Labels(); break;
            case 6: drawAIPage6Labels(); break;
            case 7: drawAIPage7Labels(); break;
            case 8: drawAIPage8Labels(); break;
            default:
        }
    }

    private void drawAIPage1Labels() {
        this.fontRenderer.drawString(CAN_MELEE, 187, 133, 0);
        if (this.entity.getAttackType(13)) this.fontRenderer.drawString(CAN_LATK, 187, 146, 0);
        if (this.entity.getAttackType(14)) this.fontRenderer.drawString(CAN_HATK, 187, 159, 0);
        if (this.entity.getAttackType(15)) this.fontRenderer.drawString(CAN_ALATK, 187, 172, 0);
        if (this.entity.getAttackType(16)) this.fontRenderer.drawString(CAN_AHATK, 187, 185, 0);
        if (this.entity.getAttackType(17)) this.fontRenderer.drawString(AURA_EFFECT, 187, 198, 0);
    }

    private void drawAIPage2Labels() {
        this.fontRenderer.drawString(FOLLOW_MIN, 174, 134, 0);
        this.fontRenderer.drawString(FOLLOW_MAX, 174, 158, 0);
        this.fontRenderer.drawString(FLEE_HP, 174, 182, 0);
        String fMin = this.mousePressBar == 0 ? String.valueOf((int)(this.barPos / 42.0f * 30.0f + 1.0f)) : String.valueOf(this.entity.getStateMinor(10));
        String fMax = this.mousePressBar == 1 ? String.valueOf((int)(this.barPos / 42.0f * 30.0f + 2.0f)) : String.valueOf(this.entity.getStateMinor(11));
        String flee = this.mousePressBar == 2 ? String.valueOf((int)(this.barPos / 42.0f * 100.0f)) : String.valueOf(this.entity.getStateMinor(12));
        this.fontRenderer.drawStringWithShadow(fMin, 174.0f, 145.0f, this.mousePressBar == 0 ? Enums.EnumColors.RED_DARK.getValue() : Enums.EnumColors.YELLOW.getValue());
        this.fontRenderer.drawStringWithShadow(fMax, 174.0f, 169.0f, this.mousePressBar == 1 ? Enums.EnumColors.RED_LIGHT.getValue() : Enums.EnumColors.YELLOW.getValue());
        this.fontRenderer.drawStringWithShadow(flee, 174.0f, 193.0f, this.mousePressBar == 2 ? Enums.EnumColors.RED_LIGHT.getValue() : Enums.EnumColors.YELLOW.getValue());
    }

    private void drawAIPage3Labels() {
        this.fontRenderer.drawString(TAR_AI, 187, 133, 0);
        this.fontRenderer.drawString(STR_ONSIGHT, 187, 146, 0);
        this.fontRenderer.drawString(STR_PVP, 187, 159, 0);
        this.fontRenderer.drawString(STR_AA, 187, 172, 0);
        this.fontRenderer.drawString(STR_ASM, 187, 185, 0);
        this.fontRenderer.drawString(STR_TIMEKEEP, 187, 198, 0);
    }

    private void drawAIPage4Labels() {
        if (this.entity.getStateFlag(24)) this.fontRenderer.drawString(STR_PICK, 187, 134, 0);
        this.fontRenderer.drawString(STR_AUTOPUMP, 187, 146, 0);
    }

    private void drawAIPage5Labels() {
        this.fontRenderer.drawString(STR_WPSTAY, 174, 134, 0);
        this.fontRenderer.drawString(STR_AUTOCR, 174, 158, 0);
        String wpStay = this.mousePressBar == 3 ? CalcHelper.tick2SecOrMin(BasicEntityShip.wpStayTime2Ticks((int)(this.barPos / 2.625f))) : CalcHelper.tick2SecOrMin(BasicEntityShip.wpStayTime2Ticks(this.entity.getStateMinor(44)));
        int moraleIdx = this.mousePressBar == 4 ? (int)(this.barPos / 10.75f) : this.entity.getStateMinor(9) -1;
        String morale = (moraleIdx >= 0 && moraleIdx < STR_MORALE.length-1) ? STR_MORALE[moraleIdx + 1] : STR_MORALE[this.entity.getStateMinor(9)];
        this.fontRenderer.drawStringWithShadow(wpStay, 174.0f, 145.0f, this.mousePressBar == 3 ? Enums.EnumColors.RED_LIGHT.getValue() : Enums.EnumColors.YELLOW.getValue());
        this.fontRenderer.drawStringWithShadow(morale, 174.0f, 169.0f, this.mousePressBar == 4 ? Enums.EnumColors.RED_LIGHT.getValue() : Enums.EnumColors.YELLOW.getValue());
    }

    private void drawAIPage6Labels() {
        this.fontRenderer.drawString(STR_SHOW_HELD, 187, 133, 0);
        this.fontRenderer.drawString(STR_APPEAR, 177, 146, 0);
    }

    private void drawAIPage7Labels() {
        this.fontRenderer.drawString(" Metadata", 187, 159, 0);
        this.fontRenderer.drawString(" Ore Dict", 187, 172, 0);
        this.fontRenderer.drawString(" NBT Tag", 187, 185, 0);
    }

    private void drawAIPage8Labels() {
        this.fontRenderer.drawString(STR_INPUT, 177, 133, 0);
        this.fontRenderer.drawString(STR_OUTPUT, 177, 159, 0);
        this.fontRenderer.drawString(STR_FUEL, 177, 185, 0);
    }

    @Override
    protected void mouseClickMove(int posX, int posY, int mouseKey, long pressTime) {
        super.mouseClickMove(posX, posY, mouseKey, pressTime);
        if (this.mousePressBar != -1) {
            this.barPos = MathHelper.clamp(posX - this.guiLeft - 191, 0, 42);
        }
    }

    @Override
    protected void mouseReleased(int posX, int posY, int state) {
        super.mouseReleased(posX, posY, state);
        if (this.mousePressBar != -1) {
            int barvalue;
            switch (this.mousePressBar) {
                case 0: barvalue = (int) (this.barPos / 42.0f * 30.0f + 1.0f); sendCommand(5, barvalue); break;
                case 1: barvalue = (int) (this.barPos / 42.0f * 30.0f + 2.0f); sendCommand(6, barvalue); break;
                case 2: barvalue = (int) (this.barPos / 42.0f * 100.0f); sendCommand(7, barvalue); break;
                case 3: barvalue = (int) (this.barPos / 2.625f); sendCommand(17, barvalue); break;
                case 4: barvalue = (int) (this.barPos / 10.75f) + 1; sendCommand(19, barvalue); break;
                default:
            }
            this.mousePressBar = -1;
        }
    }

    @Override
    protected void mouseClicked(int posX, int posY, int mouseKey) throws IOException {
        super.mouseClicked(posX, posY, mouseKey);
        int xClick = posX - this.guiLeft;
        int yClick = posY - this.guiTop;
        handleSliderPress(xClick, yClick);
        if (this.mousePressBar != -1) return;
        int buttonID = GuiHelper.getButton(0, 0, xClick, yClick);
        if (buttonID != -1) {
            handleButtonClicks(buttonID, xClick);
        }
        if (this.showPage == 2 && GuiHelper.getButton(0, 1, xClick, yClick) == 0) {
            this.showAttack = (this.showAttack == 1) ? 2 : 1;
        }
    }

    private void handleSliderPress(int x, int y) {
        if (this.showPageAI == 2) this.mousePressBar = GuiHelper.getButton(0, 2, x, y);
        else if (this.showPageAI == 5) {
            int sliderId = GuiHelper.getButton(0, 2, x, y);
            this.mousePressBar = (sliderId != -1) ? sliderId + 3 : -1;
        } else {
            this.mousePressBar = -1;
        }
    }

    private void handleButtonClicks(int buttonID, int xClick) {
        if (buttonID >= 0 && buttonID <= 2) this.showPage = buttonID + 1;
        else if (buttonID >= 9 && buttonID <= 14) this.showPageAI = buttonID - 8;
        else if (buttonID >= 18 && buttonID <= 23) this.showPageAI = buttonID - 11;
        else if (buttonID >= 15 && buttonID <= 17 && this.entity.getInventoryPageSize() >= buttonID - 15) {
            sendCommand(15, buttonID - 15);
        } else {
            handleAIPageActions(buttonID, xClick);
        }
    }

    private void handleAIPageActions(int buttonID, int xClick) {
        switch (this.showPageAI) {
            case 1: handleAIPage1Actions(buttonID); break;
            case 3: handleAIPage3Actions(buttonID); break;
            case 4: handleAIPage4Actions(buttonID); break;
            case 6: handleAIPage6Actions(buttonID, xClick); break;
            case 7: handleAIPage7Actions(buttonID, xClick); break;
            case 8: handleAIPage8Actions(buttonID, xClick); break;
            default:
        }
    }

    private void handleAIPage1Actions(int buttonID) {
        int[] types = {0, 1, 2, 3, 4, 9};
        boolean[] flags = {
                entity.getStateFlag(3), entity.getStateFlag(4), entity.getStateFlag(5),
                entity.getStateFlag(6), entity.getStateFlag(7), entity.getStateFlag(9)
        };
        if (buttonID >= 3 && buttonID <= 8) {
            sendCommand(types[buttonID - 3], flags[buttonID - 3] ? 0 : 1);
        }
    }

    private void handleAIPage3Actions(int buttonID) {
        int[] types = {8, 10, 11, 12, 13, 14};
        boolean[] flags = {
                entity.getStateFlag(21), entity.getStateFlag(12), entity.getStateFlag(18),
                entity.getStateFlag(19), entity.getStateFlag(20), entity.getStateFlag(22)
        };
        if (buttonID >= 3 && buttonID <= 8) {
            sendCommand(types[buttonID - 3], flags[buttonID - 3] ? 0 : 1);
        }
    }

    private void handleAIPage4Actions(int buttonID) {
        if (buttonID == 3) sendCommand(16, entity.getStateFlag(23) ? 0 : 1);
        else if (buttonID == 4) sendCommand(20, entity.getStateFlag(26) ? 0 : 1);
    }

    private void handleAIPage6Actions(int buttonID, int xClick) {
        if (buttonID == 3) {
            sendAppearanceCommand(18, this.entity.getStateFlag(25));
        } else if (buttonID >= 5 && buttonID <= 8) {
            handleAppearanceSubAction(xClick, buttonID);
        }
    }

    private void handleAppearanceSubAction(int xClick, int buttonID) {
        int baseType = 21 + (buttonID - 5) * 4;
        int baseSwitchIndex = 1 + (buttonID - 5) * 4;
        int indexOffset = (xClick < BT_COLS[0]) ? 0 : (xClick < BT_COLS[1]) ? 1 : (xClick < BT_COLS[2]) ? 2 : 3;
        if (baseSwitchIndex + indexOffset <= this.maxBtn) {
            int modelstate = this.entity.getStateEmotion(0);
            boolean flag = (modelstate & Values.N.Pow2[baseSwitchIndex + indexOffset -1]) != 0;
            sendAppearanceCommand(baseType + indexOffset, flag);
        }
    }

    private void handleAIPage7Actions(int buttonID, int xClick) {
        if (buttonID == 3 || buttonID == 4) {
            int curTask = this.entity.getStateMinor(40);
            int newTask = (xClick < 191) ? 1 : (xClick < 207) ? 2 : (xClick < 223) ? 3 : 4;
            sendCommand(37, (curTask != newTask) ? newTask : 0);
        } else if (buttonID >= 5 && buttonID <= 7) {
            sendCommand(38, this.entity.getStateMinor(41) ^ Values.N.Pow2[18 + (buttonID - 5)]);
        }
    }

    private void handleAIPage8Actions(int buttonID, int xClick) {
        int baseId = -1;
        if (buttonID == 4) baseId = 0;
        else if (buttonID == 6) baseId = 6;
        else if (buttonID == 8) baseId = 12;

        if (baseId != -1) {
            int offset = (xClick - 174) / 11;
            if(offset >= 0 && offset < 6){
                sendCommand(38, this.entity.getStateMinor(41) ^ Values.N.Pow2[baseId + offset]);
            }
        }
    }

    private void sendCommand(int type, int value) {
        CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.entity, (byte)0, type, value));
    }

    private void sendAppearanceCommand(int type, boolean flag) {
        sendCommand(type, flag ? 0 : 1);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (this.entity == null || !this.entity.isEntityAlive() || this.entity.getDistance(this.mc.player) > ConfigHandler.closeGUIDist) {
            this.mc.player.closeScreen();
        }
    }
}