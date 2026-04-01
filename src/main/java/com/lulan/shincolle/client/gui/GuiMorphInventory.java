package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.client.gui.inventory.ContainerMorphInventory;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipCV;
import com.lulan.shincolle.entity.IShipInvisible;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.network.C2SGUIPackets;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.reference.Enums;
import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.reference.unitclass.AttrsAdv;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.CombatHelper;
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

public class GuiMorphInventory extends GuiContainer {

    private static final ResourceLocation TEXTURE_BG = new ResourceLocation("shincolle:textures/gui/GuiShipMorph.png");
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
    private static final String STR_ATTR_DODGE = I18n.format("gui.shincolle:dodge");
    private static final String STR_ATTR_FORMAT = I18n.format("gui.shincolle:formation.formation");
    private static final String STR_ATTR_WEDDING = I18n.format("gui.shincolle:marriage");
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
    private static final String AURA_EFFECT = I18n.format("gui.shincolle:auraeffect");
    private static final String STR_SHOW_HELD = I18n.format("gui.shincolle:showhelditem");
    private static final String STR_APPEAR = I18n.format("gui.shincolle:appearance");
    private static final String STR_NOFUEL = I18n.format("gui.shincolle:morph.nofuel");
    private static final String STR_SIT = I18n.format("gui.shincolle:morph.sit");
    private static final String STR_EMO_FLAG1 = I18n.format("gui.shincolle:morph.emo1");
    private static final String STR_EMO_FLAG2 = I18n.format("gui.shincolle:morph.emo2");
    private static final String STR_ATTR_WED_TRUE = I18n.format("gui.shincolle:married");
    private static final String STR_ATTR_WED_FALSE = I18n.format("gui.shincolle:unmarried");
    private static final int[] BT_COLS = {189, 205, 222};

    public BasicEntityShip entity;
    public CapaTeitoku capa;
    public InventoryPlayer invPlayer;
    private final BasicEntityShip[] shipRiding = new BasicEntityShip[3];
    private final AttrsAdv attrs;
    private int widthHoveringText1;
    private final List<String> mouseoverList;
    private String strATK;
    private String strAATK;
    private int showPage;
    private int showPageAI;
    private int showAttack;
    private final int maxBtn;
    private float xMouse;
    private float yMouse;
    private final boolean[] switchPage1a;
    private final boolean[] switchPage6;
    private final int[][] iconXY;

    public GuiMorphInventory(CapaTeitoku capa, InventoryPlayer invPlayer, BasicEntityShip entity) {
        super(new ContainerMorphInventory(capa, invPlayer, entity));
        this.capa = capa;
        this.entity = entity;
        this.invPlayer = invPlayer;
        this.xSize = 256;
        this.ySize = 214;
        this.mouseoverList = new ArrayList<>();
        this.showPage = 1;
        this.showPageAI = 1;
        this.showAttack = 1;
        this.switchPage1a = new boolean[6];
        this.switchPage6 = new boolean[17];
        this.attrs = (AttrsAdv) this.entity.getAttrs();
        this.shipRiding[0] = this.entity;
        this.maxBtn = this.entity.getStateMinor(13);
        this.iconXY = new int[2][3];
        this.iconXY[0] = Values.ShipTypeIconMap.get(this.entity.getShipType());
        this.iconXY[1] = Values.ShipNameIconMap.get((int)this.entity.getShipClass());
    }

    @Override
    public void initGui() {
        super.initGui();
        this.widthHoveringText1 = Stream.of(STR_ATTR_ATK, STR_ATTR_AIR, STR_ATTR_CRI, STR_ATTR_DHIT, STR_ATTR_THIT, STR_ATTR_AA, STR_ATTR_ASM, STR_ATTR_MODERN, STR_ATTR_XP, STR_ATTR_GRUDGE, STR_ATTR_AMMO, STR_ATTR_HPRES, STR_ATTR_MISS, STR_ATTR_DODGE, STR_ATTR_KB, STR_ATTR_HP)
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
        this.drawPageIndicator();
        this.drawPageAIBackground();
        this.drawShipIcons();
        drawEntityModel(this.guiLeft + 218, this.guiTop + 100, this.entity.getModelPos(), (this.guiLeft + 215) - this.xMouse, (this.guiTop + 60) - this.yMouse, this.shipRiding);
        GlStateManager.disableBlend();
    }

    private void drawPageIndicator() {
        int indicatorY;
        switch (this.showPage) {
            case 1: indicatorY = 18; break;
            case 2: indicatorY = 54; break;
            case 3: indicatorY = 90; break;
            default: return;
        }
        this.drawTexturedModalRect(this.guiLeft + 135, this.guiTop + indicatorY, 74, 214, 6, 34);
    }

    private void drawPageAIBackground() {
        int indicatorX;
        int indicatorY;
        switch (this.showPageAI) {
            case 1: indicatorX = 239; indicatorY = 131; drawPageAI1Background(); break;
            case 2: indicatorX = 239; indicatorY = 144; break;
            case 3: indicatorX = 239; indicatorY = 157; break;
            case 4: indicatorX = 239; indicatorY = 170; break;
            case 5: indicatorX = 239; indicatorY = 183; break;
            case 6: indicatorX = 239; indicatorY = 196; drawPageAI6Background(); break;
            case 7: indicatorX = 246; indicatorY = 131; break;
            case 8: indicatorX = 246; indicatorY = 144; drawPageAI8Background(); break;
            case 9: indicatorX = 246; indicatorY = 157; break;
            case 10: indicatorX = 246; indicatorY = 170; break;
            case 11: indicatorX = 246; indicatorY = 183; break;
            case 12: indicatorX = 246; indicatorY = 196; break;
            default: return;
        }
        this.drawTexturedModalRect(this.guiLeft + indicatorX, this.guiTop + indicatorY, 74, 214, 6, 11);
    }

    private void drawOnOffButton(int x, int y, boolean state) {
        int u = state ? 0 : 11;
        this.drawTexturedModalRect(this.guiLeft + x, this.guiTop + y, u, 214, 11, 11);
    }

    private void drawPageAI1Background() {
        this.switchPage1a[0] = this.entity.getStateFlag(2);
        this.switchPage1a[1] = this.entity.isSitting();
        this.switchPage1a[2] = this.entity.getStateEmotion(1) > 0;
        this.switchPage1a[3] = this.entity.getStateEmotion(7) > 0;
        this.switchPage1a[5] = this.entity.getStateFlag(9);
        int iconY = 131;
        for (int i = 0; i < 6; ++i) {
            if (i != 4) {
                drawOnOffButton(174, iconY, this.switchPage1a[i]);
            }
            iconY += 13;
        }
    }

    private void drawPageAI6Background() {
        this.switchPage6[0] = this.entity.getStateFlag(25);
        int modelstate = this.entity.getStateEmotion(0);
        for (int i = 0; i < this.maxBtn; ++i) {
            this.switchPage6[i + 1] = (modelstate & Values.N.Pow2[i]) == Values.N.Pow2[i];
        }
        drawOnOffButton(174, 131, this.switchPage6[0]);
        int numbtn = 0;
        for (int i = 0; i < 4 && numbtn <= this.maxBtn; ++i) {
            for (int j = 0; j < 4 && ++numbtn <= this.maxBtn; ++j) {
                drawOnOffButton(176 + j * 16, 157 + i * 13, this.switchPage6[i * 4 + j + 1]);
            }
        }
    }

    private void drawPageAI8Background() {
        int tside = this.entity.getStateMinor(41);
        this.drawTexturedModalRect(this.guiLeft + 173, this.guiTop + 144, 151, 214, 66, 11);
        this.drawTexturedModalRect(this.guiLeft + 173, this.guiTop + 170, 151, 214, 66, 11);
        this.drawTexturedModalRect(this.guiLeft + 173, this.guiTop + 196, 151, 214, 66, 11);
        for (int i = 0; i < 18; ++i) {
            if ((tside & Values.N.Pow2[i]) == Values.N.Pow2[i]) {
                int dx = i % 6 * 11;
                int dy = i / 6 * 26;
                this.drawTexturedModalRect(this.guiLeft + 173 + dx, this.guiTop + 144 + dy, 151 + dx, 225, 11, 11);
            }
        }
    }

    private void drawShipIcons() {
        try {
            this.mc.getTextureManager().bindTexture(TEXTURE_ICON0);
            if (this.entity.getStateMinor(0) > 99) {
                this.drawTexturedModalRect(this.guiLeft + 165, this.guiTop + 18, 0, 0, 40, 42);
            } else {
                this.drawTexturedModalRect(this.guiLeft + 165, this.guiTop + 18, 0, 43, 30, 30);
            }
            this.drawTexturedModalRect(this.guiLeft + 167, this.guiTop + 22, this.iconXY[0][0], this.iconXY[0][1], 28, 28);
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

    private void handleHoveringText() {
        this.mouseoverList.clear();
        if (isHovering(145, 4, 57, 11)) {
            this.mouseoverList.add(STR_ATTR_MODERN + " " + this.attrs.getAttrsBonus(0));
            this.drawHoveringText(this.mouseoverList, 145, 32, this.fontRenderer);
        } else if (this.showPage == 2) {
            handlePage2HoveringText();
        }
    }

    private void handlePage2HoveringText() {
        if (isHovering(73, 18, 61, 23)) {
            drawPage2AttributesHoverText();
        } else if (isHovering(73, 41, 61, 21)) {
            drawPage2ModernBonusHoverText(2, 55, 78);
        } else if (isHovering(73, 62, 61, 21)) {
            drawPage2ModernBonusHoverText(3, 55, 99);
        } else if (isHovering(73, 83, 61, 21)) {
            drawPage2ModernBonusHoverText(4, 55, 120);
        } else if (isHovering(73, 104, 61, 22)) {
            drawPage2ModernBonusHoverText(5, 55, 142);
        }
    }

    private void drawPage2AttributesHoverText() {
        this.mouseoverList.add(STR_ATTR_MODERN);
        this.mouseoverList.add(TextFormatting.RED + STR_ATTR_ATK);
        this.mouseoverList.add(TextFormatting.RED + STR_ATTR_AIR);
        this.mouseoverList.add(TextFormatting.AQUA + STR_ATTR_CRI);
        this.mouseoverList.add(TextFormatting.YELLOW + STR_ATTR_DHIT);
        this.mouseoverList.add(TextFormatting.GOLD + STR_ATTR_THIT);
        this.mouseoverList.add(TextFormatting.YELLOW + STR_ATTR_AA);
        this.mouseoverList.add(TextFormatting.AQUA + STR_ATTR_ASM);
        this.mouseoverList.add(TextFormatting.RED + STR_ATTR_MISS);
        this.mouseoverList.add(TextFormatting.GOLD + STR_ATTR_DODGE);
        this.mouseoverList.add(TextFormatting.GREEN + STR_ATTR_XP);
        this.mouseoverList.add(TextFormatting.DARK_PURPLE + STR_ATTR_GRUDGE);
        this.mouseoverList.add(TextFormatting.DARK_AQUA + STR_ATTR_AMMO);
        this.mouseoverList.add(TextFormatting.DARK_GREEN + STR_ATTR_HPRES);
        this.mouseoverList.add(TextFormatting.DARK_RED + STR_ATTR_KB);
        this.drawHoveringText(this.mouseoverList, 55, 57, this.fontRenderer);
        this.mouseoverList.clear();
        this.mouseoverList.add(String.valueOf(this.attrs.getAttrsBonus(1)));
        this.mouseoverList.add(this.strATK);
        this.mouseoverList.add(this.strAATK);
        this.mouseoverList.add((int) (this.attrs.getAttrsBuffed(9) * 100.0f) + " %");
        this.mouseoverList.add((int) (this.attrs.getAttrsBuffed(10) * 100.0f) + " %");
        this.mouseoverList.add((int) (this.attrs.getAttrsBuffed(11) * 100.0f) + " %");
        this.mouseoverList.add(String.valueOf((int)this.attrs.getAttrsBuffed(13)));
        this.mouseoverList.add(String.valueOf((int)this.attrs.getAttrsBuffed(14)));
        int missNear = (int)(CombatHelper.calcMissRate(this.entity, 0.0f) * 100.0f);
        int missFar = (int)(CombatHelper.calcMissRate(this.entity, this.attrs.getAttackRange()) * 100.0f);
        this.mouseoverList.add(missNear + " ~ " + missFar + " %");
        float dodgeValue = this.attrs.getAttrsBuffed(15);
        if (this.entity instanceof IShipInvisible) {
            dodgeValue += ((IShipInvisible) this.entity).getInvisibleLevel();
        }
        dodgeValue = Math.min(dodgeValue, (float)ConfigHandler.limitShipAttrs[15]);
        this.mouseoverList.add(String.format("%.0f", dodgeValue * 100.0f) + " %");
        this.mouseoverList.add((int) ((this.attrs.getAttrsBuffed(16) - 1.0f) * 100.0f) + " %");
        this.mouseoverList.add((int) ((this.attrs.getAttrsBuffed(17) - 1.0f) * 100.0f) + " %");
        this.mouseoverList.add((int) ((this.attrs.getAttrsBuffed(18) - 1.0f) * 100.0f) + " %");
        this.mouseoverList.add((int) ((this.attrs.getAttrsBuffed(19) - 1.0f) * 100.0f) + " %");
        this.mouseoverList.add((int) (this.attrs.getAttrsBuffed(20) * 100.0f) + " %");
        this.drawHoveringText(this.mouseoverList, 61 + this.widthHoveringText1, 57, this.fontRenderer);
    }

    private void drawPage2ModernBonusHoverText(int bonusIndex, int x, int y) {
        this.mouseoverList.add(STR_ATTR_MODERN + " " + this.attrs.getAttrsBonus(bonusIndex));
        this.drawHoveringText(this.mouseoverList, x, y, this.fontRenderer);
    }

    private boolean isHovering(int x, int y, int width, int height) {
        return this.xMouse >= (x + this.guiLeft) && this.xMouse < (x + width + this.guiLeft) &&
                this.yMouse >= (y + this.guiTop) && this.yMouse < (y + height + this.guiTop);
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
        GlStateManager.rotate(135.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-((float)Math.atan(pitch / 40.0f)) * 20.0f, 1.0f, 0.0f, 0.0f);
        entity[0].renderYawOffset = (float)Math.atan(yaw / 40.0f) * 20.0f;
        entity[0].rotationYaw = (float)Math.atan(yaw / 40.0f) * 40.0f;
        entity[0].rotationPitch = -((float)Math.atan(pitch / 40.0f)) * 20.0f;
        entity[0].rotationYawHead = entity[0].rotationYaw;
        entity[0].prevRotationYawHead = entity[0].rotationYaw;
        if (entity[2] != null) {
            setEntityRotation(entity[2], entity[0]);
        } else if (entity[1] != null) {
            setEntityRotation(entity[1], entity[0]);
        }
        GlStateManager.translate(0.0, entity[0].getYOffset(), 0.0);
        rendermanager.setPlayerViewY(180.0f);
        rendermanager.setRenderShadow(false);
        if (entity[1] != null) {
            drawRidingEntityModel(rendermanager, entity[0], entity[1]);
        } else if (entity[2] != null) {
            drawRidingEntityModel(rendermanager, entity[2], entity[0]);
        } else {
            rendermanager.renderEntity(entity[0], 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        }
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
            if (riding.getStateEmotion(1) == 4) {
                specialOffset = isSitting ? -0.34f : -0.57f;
            } else {
                specialOffset = isSitting ? -0.55f : -0.45f;
            }
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
        drawPageAISpecificAttributes();
    }

    private void drawCommonAttributes() {
        String shiplevel = String.valueOf(this.entity.getStateMinor(0));
        int hpCurrent = 0;
        int hpMax = 0;
        if (this.capa.getPlayer() != null) {
            hpCurrent = MathHelper.ceil(this.capa.getPlayer().getHealth());
            hpMax = MathHelper.ceil(this.capa.getPlayer().getMaxHealth());
        }
        this.fontRenderer.drawStringWithShadow(LV_MARK, (231 - this.fontRenderer.getStringWidth(LV_MARK)), 6.0f, 65535);
        this.fontRenderer.drawStringWithShadow(HP_MARK, (145 - this.fontRenderer.getStringWidth(HP_MARK)), 6.0f, 65535);
        int color = this.entity.getStateMinor(0) < 150 ? 0xFFFFFF : 16766720;
        this.fontRenderer.drawStringWithShadow(shiplevel, (this.xSize - 6 - this.fontRenderer.getStringWidth(shiplevel)), 6.0f, color);
        color = GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(0));
        this.fontRenderer.drawStringWithShadow("/" + hpMax, (148 + this.fontRenderer.getStringWidth(String.valueOf(hpCurrent))), 6.0f, color);
        if (hpCurrent < hpMax) {
            color = GuiHelper.getDarkerColor(color, 0.8f);
        }
        this.fontRenderer.drawStringWithShadow(String.valueOf(hpCurrent), 147.0f, 6.0f, color);
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
        this.fontRenderer.drawString(STR_MI_KILLS, 75, 20, 0);
        this.fontRenderer.drawString(STR_MI_EXP, 75, 41, 0);
        this.fontRenderer.drawString(STR_MI_AMMOL, 75, 62, 0);
        this.fontRenderer.drawString(STR_MI_AMMOH, 75, 83, 0);
        this.fontRenderer.drawString(STR_MI_GRUDGE, 75, 104, 0);
        this.entity.setExpNext();
        String exp = this.entity.getStateMinor(2) + "/" + this.entity.getStateMinor(3);
        String kills = String.valueOf(this.entity.getStateMinor(1));
        String ammoLight = String.valueOf(this.entity.getStateMinor(4));
        String ammoHeavy = String.valueOf(this.entity.getStateMinor(5));
        String grudge = String.valueOf(this.entity.getStateMinor(6));
        this.fontRenderer.drawStringWithShadow(kills, (133 - this.fontRenderer.getStringWidth(kills)), 30.0f, Enums.EnumColors.WHITE.getValue());
        this.fontRenderer.drawStringWithShadow(exp, (133 - this.fontRenderer.getStringWidth(exp)), 51.0f, Enums.EnumColors.WHITE.getValue());
        this.fontRenderer.drawStringWithShadow(ammoLight, (133 - this.fontRenderer.getStringWidth(ammoLight)), 72.0f, Enums.EnumColors.WHITE.getValue());
        this.fontRenderer.drawStringWithShadow(ammoHeavy, (133 - this.fontRenderer.getStringWidth(ammoHeavy)), 93.0f, Enums.EnumColors.WHITE.getValue());
        this.fontRenderer.drawStringWithShadow(grudge, (133 - this.fontRenderer.getStringWidth(grudge)), 114.0f, Enums.EnumColors.WHITE.getValue());
    }

    private void drawPage2Attributes() {
        this.strATK = String.format("%.1f", this.attrs.getAttrsBuffed(1)) + " / " + String.format("%.1f", this.attrs.getAttrsBuffed(2));
        this.strAATK = String.format("%.1f", this.attrs.getAttrsBuffed(3)) + " / " + String.format("%.1f", this.attrs.getAttrsBuffed(4));
        String strDEF = String.format("%.1f", this.attrs.getAttrsBuffed(5) * 100.0f) + "%";
        String strSPD = String.format("%.2f", this.attrs.getAttrsBuffed(6));
        String strMOV = String.format("%.2f", this.attrs.getAttrsBuffed(7));
        String strHIT = String.format("%.1f", this.attrs.getAttrsBuffed(8));
        String atkLabel = this.showAttack == 1 ? STR_ATTR_ATK : STR_ATTR_AIR;
        String atkValue = this.showAttack == 1 ? this.strATK : this.strAATK;
        this.fontRenderer.drawString(atkLabel, 75, 20, 0);
        this.fontRenderer.drawStringWithShadow(atkValue, (133 - this.fontRenderer.getStringWidth(atkValue)), 30.0f, GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(1)));
        this.fontRenderer.drawString(STR_ATTR_DEF, 75, 41, 0);
        this.fontRenderer.drawString(STR_ATTR_SPD, 75, 62, 0);
        this.fontRenderer.drawString(STR_ATTR_MOV, 75, 83, 0);
        this.fontRenderer.drawString(STR_ATTR_HIT, 75, 104, 0);
        this.fontRenderer.drawStringWithShadow(strDEF, (133 - this.fontRenderer.getStringWidth(strDEF)), 51.0f, GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(2)));
        this.fontRenderer.drawStringWithShadow(strSPD, (133 - this.fontRenderer.getStringWidth(strSPD)), 72.0f, GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(3)));
        this.fontRenderer.drawStringWithShadow(strMOV, (133 - this.fontRenderer.getStringWidth(strMOV)), 93.0f, GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(4)));
        this.fontRenderer.drawStringWithShadow(strHIT, (133 - this.fontRenderer.getStringWidth(strHIT)), 114.0f, GuiHelper.getBonusPointColor(this.attrs.getAttrsBonus(5)));
    }

    private void drawPage3Attributes() {
        this.fontRenderer.drawString(STR_ATTR_WEDDING, 75, 20, 0);
        this.fontRenderer.drawString(STR_ATTR_FORMAT, 75, 41, 0);
        String marriage;
        if (this.entity.getStateFlag(1)) {
            marriage = STR_ATTR_WED_TRUE;
        } else {
            marriage = STR_ATTR_WED_FALSE;
        }
        int ftype = this.entity.getStateMinor(26);
        String formation = I18n.format("gui.shincolle:formation.format" + ftype);
        this.fontRenderer.drawStringWithShadow(formation, (133 - this.fontRenderer.getStringWidth(formation)), 51.0f, Enums.EnumColors.WHITE.getValue());
        if (this.entity instanceof BasicEntityShipCV) {
            this.fontRenderer.drawString(STR_MI_AIRL, 75, 83, 0);
            this.fontRenderer.drawString(STR_MI_AIRH, 75, 104, 0);
            String airLight = String.valueOf(((BasicEntityShipCV) this.entity).getNumAircraftLight());
            String airHeavy = String.valueOf(((BasicEntityShipCV) this.entity).getNumAircraftHeavy());
            this.fontRenderer.drawStringWithShadow(airLight, (133 - this.fontRenderer.getStringWidth(airLight)), 93.0f, Enums.EnumColors.YELLOW.getValue());
            this.fontRenderer.drawStringWithShadow(airHeavy, (133 - this.fontRenderer.getStringWidth(airHeavy)), 114.0f, Enums.EnumColors.YELLOW.getValue());
        }
        this.fontRenderer.drawStringWithShadow(marriage, (133 - this.fontRenderer.getStringWidth(marriage)), 30.0f, Enums.EnumColors.YELLOW.getValue());
    }

    private void drawPageAISpecificAttributes() {
        switch (this.showPageAI) {
            case 1:
                this.fontRenderer.drawString(STR_NOFUEL, 187, 133, 0);
                this.fontRenderer.drawString(STR_SIT, 187, 146, 0);
                this.fontRenderer.drawString(STR_EMO_FLAG1, 187, 159, 0);
                this.fontRenderer.drawString(STR_EMO_FLAG2, 187, 172, 0);
                this.fontRenderer.drawString(AURA_EFFECT, 187, 198, 0);
                break;
            case 6:
                this.fontRenderer.drawString(STR_SHOW_HELD, 187, 133, 0);
                this.fontRenderer.drawString(STR_APPEAR, 177, 146, 0);
                break;
            default:
        }
    }

    @Override
    protected void mouseClicked(int posX, int posY, int mouseKey) throws IOException {
        super.mouseClicked(posX, posY, mouseKey);
        int xClick = posX - this.guiLeft;
        int yClick = posY - this.guiTop;
        int button = GuiHelper.getButton(0, 0, xClick, yClick);
        handlePageSwitchClick(button);
        handlePageAISwitchClick(button);
        handleActionButtonClick(button, xClick);
        handleMiscClicks(xClick, yClick);
    }

    private void handlePageSwitchClick(int button) {
        if (button >= 0 && button <= 2) {
            this.showPage = button + 1;
        }
    }

    private void handlePageAISwitchClick(int button) {
        switch (button) {
            case 9: this.showPageAI = 1; break;
            case 10: this.showPageAI = 2; break;
            case 11: this.showPageAI = 3; break;
            case 12: this.showPageAI = 4; break;
            case 13: this.showPageAI = 5; break;
            case 14: this.showPageAI = 6; break;
            case 18: this.showPageAI = 7; break;
            case 19: this.showPageAI = 8; break;
            case 20: this.showPageAI = 9; break;
            case 21: this.showPageAI = 10; break;
            case 22: this.showPageAI = 11; break;
            case 23: this.showPageAI = 12; break;
            default:
        }
    }

    private void handleActionButtonClick(int button, int xClick) {
        switch (button) {
            case 3: handleActionForPageAI(39, 18); break;
            case 4: if (this.showPageAI == 1) sendCommand(40, 0); break;
            case 5: handleActionForPageAI_5_6(xClick); break;
            case 6: handleActionForPageAI_5_6(xClick); break;
            case 7: if (this.showPageAI == 6) handleSubActionForPageAI6(xClick, 29, 9); break;
            case 8: handleActionForPageAI_8(xClick); break;
            default:
        }
    }

    private void handleActionForPageAI(int typeAI1, int typeAI6) {
        if (this.showPageAI == 1) {
            this.switchPage1a[0] = this.entity.getStateFlag(2);
            sendCommand(typeAI1, getInverseInt(this.switchPage1a[0]));
        } else if (this.showPageAI == 6) {
            this.switchPage6[0] = this.entity.getStateFlag(25);
            sendCommand(typeAI6, getInverseInt(this.switchPage6[0]));
        }
    }

    private void handleActionForPageAI_5_6(int xClick) {
        if (this.showPageAI == 1) {
            if (xClick > 173 && xClick < 185) {
                sendCommand(41, this.entity.getRNG().nextInt(9));
            } else {
                sendCommand(42, this.entity.getStateEmotion(7) > 0 ? 0 : 4);
            }
        } else if (this.showPageAI == 6) {
            if (isHovering(176, 157, 64, 13)) {
                handleSubActionForPageAI6(xClick, 21, 1);
            } else {
                handleSubActionForPageAI6(xClick, 25, 5);
            }
        }
    }

    private void handleActionForPageAI_8(int xClick) {
        if (this.showPageAI == 1) {
            this.switchPage1a[5] = this.entity.getStateFlag(9);
            sendCommand(9, getInverseInt(this.switchPage1a[5]));
        } else if (this.showPageAI == 6) {
            handleSubActionForPageAI6(xClick, 33, 13);
        }
    }

    private void handleSubActionForPageAI6(int xClick, int baseType, int baseSwitchIndex) {
        int indexOffset;
        if (xClick < BT_COLS[0]) indexOffset = 0;
        else if (xClick < BT_COLS[1]) indexOffset = 1;
        else if (xClick < BT_COLS[2]) indexOffset = 2;
        else indexOffset = 3;

        if (baseSwitchIndex + indexOffset <= this.maxBtn) {
            sendCommand(baseType + indexOffset, getInverseInt(this.switchPage6[baseSwitchIndex + indexOffset]));
        }
    }

    private void handleMiscClicks(int xClick, int yClick) {
        if (this.showPage == 2 && GuiHelper.getButton(0, 1, xClick, yClick) == 0) {
            if (this.showAttack == 1) {
                this.showAttack = 2;
            } else {
                this.showAttack = 1;
            }
        }
        int formationButton = GuiHelper.getButton(7, 0, xClick, yClick);
        if (formationButton != -1) {
            sendFormationCommand(formationButton);
        }
    }

    private void sendCommand(int type, int value) {
        CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.invPlayer.player, (byte) 2, type, value));
    }

    private void sendFormationCommand(int type) {
        CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.invPlayer.player, (byte) 3, type, 0));
    }

    private int getInverseInt(boolean par1) {
        if (par1) {
            return 0;
        }
        return 1;
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        if (this.entity == null || !this.invPlayer.player.isEntityAlive()) {
            this.mc.player.closeScreen();
        }
    }
}
