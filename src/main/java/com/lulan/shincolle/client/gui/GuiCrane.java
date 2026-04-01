package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.client.gui.inventory.ContainerCrane;
import com.lulan.shincolle.network.C2SGUIPackets;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.reference.Enums;
import com.lulan.shincolle.tileentity.TileEntityCrane;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.GuiHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.util.ArrayList;

public class GuiCrane
extends GuiContainer {
    private static final ResourceLocation guiTexture = new ResourceLocation("shincolle:textures/gui/GuiCrane.png");
    private final TileEntityCrane tile;
    private int xMouse;
    private int yMouse;
    private int btnMode;
    private int btnRedMode;
    private int btnLiquidMode;
    private int btnEnergyMode;
    private boolean btnPower;
    private boolean btnMeta;
    private boolean btnDict;
    private boolean btnNbt;
    private boolean btnLoad;
    private boolean btnUnload;
    private static final String strLoad = I18n.format("gui.shincolle:crane.toship");
    private static final String strUnload = I18n.format("gui.shincolle:crane.tochest");
    private static final String strMeta = I18n.format("gui.shincolle:crane.usemeta");
    private static final String strDict = I18n.format("gui.shincolle:crane.useoredict");
    private static final String strNbt = I18n.format("gui.shincolle:crane.usenbt");
    private static final String strNowait = I18n.format("gui.shincolle:crane.nowait");
    private static final String strNowait1 = I18n.format("gui.shincolle:crane.nowait1");
    private static final String strFull = I18n.format("gui.shincolle:crane.untilfull");
    private static final String strFull1 = I18n.format("gui.shincolle:crane.untilfull1");
    private static final String strFull2 = I18n.format("gui.shincolle:crane.untilfull2");
    private static final String strEmpty = I18n.format("gui.shincolle:crane.untilempty");
    private static final String strEmpty1 = I18n.format("gui.shincolle:crane.untilempty1");
    private static final String strEmpty2 = I18n.format("gui.shincolle:crane.untilempty2");
    private static final String strExcess = I18n.format("gui.shincolle:crane.excess");
    private static final String strExcess1 = I18n.format("gui.shincolle:crane.excess1");
    private static final String strExcess2 = I18n.format("gui.shincolle:crane.excess2");
    private static final String strRemain = I18n.format("gui.shincolle:crane.remain");
    private static final String strRemain1 = I18n.format("gui.shincolle:crane.remain1");
    private static final String strRemain2 = I18n.format("gui.shincolle:crane.remain2");
    private static final String strRed0 = I18n.format("gui.shincolle:crane.red0");
    private static final String strRed1 = I18n.format("gui.shincolle:crane.red1");
    private static final String strRed2 = I18n.format("gui.shincolle:crane.red2");
    private static final String strLiq0 = I18n.format("gui.shincolle:crane.liquid0");
    private static final String strLiq1 = I18n.format("gui.shincolle:crane.liquid1");
    private static final String strLiq2 = I18n.format("gui.shincolle:crane.liquid2");

    public GuiCrane(InventoryPlayer par1, TileEntityCrane par2) {
        super(new ContainerCrane(par1, par2));
        this.tile = par2;
        this.xSize = 176;
        this.ySize = 201;
        this.updateButton();
    }

    public void drawScreen(int mouseX, int mouseY, float f) {
        super.drawScreen(mouseX, mouseY, f);
        this.xMouse = mouseX;
        this.yMouse = mouseY;
    }

    private void handleHoveringText() {
        int mx = this.xMouse - this.guiLeft;
        int my = this.yMouse - this.guiTop;
        ArrayList<String> list = new ArrayList<>();
        if (my > 21 && my < 34) {
            if (mx > 22 && mx < 35) {
                list.add(strMeta);
            } else if (mx > 36 && mx < 49) {
                list.add(strDict);
            } else if (mx > 50 && mx < 63) {
                list.add(strNbt);
            } else if (mx > 64 && mx < 77) {
                switch (this.btnRedMode) {
                    case 1: {
                        list.add(strRed1);
                        break;
                    }
                    case 2: {
                        list.add(strRed2);
                        break;
                    }
                    default: {
                        list.add(strRed0);
                    }
                }
            }
            this.drawHoveringText(list, mx, my + 10, this.fontRenderer);
        } else if (my > 35 && my < 50) {
            if (mx > 22 && mx < 37) {
                switch (this.btnLiquidMode) {
                    case 1: {
                        list.add(strLiq1);
                        break;
                    }
                    case 2: {
                        list.add(strLiq2);
                        break;
                    }
                    default: {
                        list.add(strLiq0);
                    }
                }
            }
            this.drawHoveringText(list, mx, my + 10, this.fontRenderer);
        }
        if (mx > 22 && mx < 91 && my > 5 && my < 20) {
            list.clear();
            switch (this.btnMode) {
                case 0: {
                    list.add(strNowait1);
                    break;
                }
                case 1: {
                    list.add(strFull1);
                    list.add(strFull2);
                    break;
                }
                case 2: {
                    list.add(strEmpty1);
                    list.add(strEmpty2);
                    break;
                }
                case 3: {
                    list.add(strExcess1);
                    list.add(strExcess2);
                    break;
                }
                case 4: {
                    list.add(strRemain1);
                    list.add(strRemain2);
                    break;
                }
                default:
            }
            this.drawHoveringText(list, -50, 37, this.fontRenderer);
        }
    }

    protected void drawGuiContainerForegroundLayer(int i, int j) {
        String str = null;
        String strnum = null;
        int len = 0;
        switch (this.btnMode) {
            case 0: {
                str = strNowait;
                break;
            }
            case 1: {
                str = strFull;
                break;
            }
            case 2: {
                str = strEmpty;
                break;
            }
            case 3: {
                str = strExcess;
                break;
            }
            case 4: {
                str = strRemain;
                break;
            }
            default: {
                if (this.btnMode < 10) {
                    Object[] objectArray = new Object[1];
                    objectArray[0] = Float.valueOf(TileEntityCrane.getWaitTime(this.btnMode) * 0.05f);
                    strnum = String.format("%.1f", objectArray);
                    str = I18n.format("gui.shincolle:crane.waitsec", strnum);
                    break;
                }
                if (this.btnMode < 15) {
                    strnum = String.valueOf((int)(TileEntityCrane.getWaitTime(this.btnMode) * 0.05f));
                    str = I18n.format("gui.shincolle:crane.waitsec", strnum);
                    break;
                }
                strnum = String.valueOf(TileEntityCrane.getWaitTime(this.btnMode) / 1200);
                str = I18n.format("gui.shincolle:crane.waitmin", strnum);
            }
        }
        len = (int)(this.fontRenderer.getStringWidth(str) * 0.5f);
        this.fontRenderer.drawStringWithShadow(str, (57 - len), 9.0f, Enums.EnumColors.YELLOW.getValue());
        this.fontRenderer.drawString(strLoad, 21, 54, Enums.EnumColors.RED_LIGHT.getValue());
        this.fontRenderer.drawString(strUnload, 21, 85, Enums.EnumColors.BLACK.getValue());
        if (this.tile.getShip() != null) {
            str = CalcHelper.getTimeFormated((int) ( this.tile.getShip().getStateTimer(1) * 0.05f));
            len = (int)(this.fontRenderer.getStringWidth(str) * 0.5f);
            this.fontRenderer.drawString(str, 133 - len, 10, Enums.EnumColors.GRAY_DARK.getValue());
            str = this.tile.getShip().getCustomNameTag() != null && !this.tile.getShip().getCustomNameTag().isEmpty() ? this.tile.getShip().getCustomNameTag() : I18n.format("entity.shincolle." + this.tile.getShip().getClass().getSimpleName() + ".name");
            this.fontRenderer.drawStringWithShadow(str, 80.0f, 24.0f, Enums.EnumColors.WHITE.getValue());
        }
        this.handleHoveringText();
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableBlend();
        Minecraft.getMinecraft().getTextureManager().bindTexture(guiTexture);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        this.updateButton();
        if (this.btnPower) {
            this.drawTexturedModalRect(this.guiLeft + 7, this.guiTop + 6, 176, 0, 13, 13);
        }
        if (this.btnMeta) {
            this.drawTexturedModalRect(this.guiLeft + 23, this.guiTop + 22, 176, 13, 11, 11);
        }
        if (this.btnDict) {
            this.drawTexturedModalRect(this.guiLeft + 37, this.guiTop + 22, 176, 24, 11, 11);
        }
        if (this.btnNbt) {
            this.drawTexturedModalRect(this.guiLeft + 51, this.guiTop + 22, 176, 46, 11, 11);
        }
        if (!this.btnLoad) {
            this.drawTexturedModalRect(this.guiLeft + 7, this.guiTop + 52, 176, 35, 11, 11);
            this.drawTexturedModalRect(this.guiLeft + 8, this.guiTop + 65, 0, 201, 160, 16);
        }
        if (!this.btnUnload) {
            this.drawTexturedModalRect(this.guiLeft + 7, this.guiTop + 83, 176, 35, 11, 11);
            this.drawTexturedModalRect(this.guiLeft + 8, this.guiTop + 96, 0, 201, 160, 16);
        }
        switch (this.btnRedMode) {
            case 1: {
                this.drawTexturedModalRect(this.guiLeft + 65, this.guiTop + 22, 176, 57, 11, 11);
                break;
            }
            case 2: {
                this.drawTexturedModalRect(this.guiLeft + 65, this.guiTop + 22, 176, 68, 11, 11);
                break;
            }
            default:
        }
        switch (this.btnLiquidMode) {
            case 0: {
                this.drawTexturedModalRect(this.guiLeft + 23, this.guiTop + 36, 202, 101, 13, 13);
                break;
            }
            case 1: {
                this.drawTexturedModalRect(this.guiLeft + 23, this.guiTop + 36, 176, 101, 13, 13);
                break;
            }
            case 2: {
                this.drawTexturedModalRect(this.guiLeft + 23, this.guiTop + 36, 189, 101, 13, 13);
                break;
            }
            default:
        }
        for (int i = 0; i < 18; ++i) {
            boolean slotMode = this.tile.getItemMode(i);
            ItemStack item = this.inventorySlots.getSlot(i).getStack();
            if (item.isEmpty()) continue;
            if (i >= 9) {
                if(slotMode) {
                    this.drawTexturedModalRect(this.guiLeft + 7 + (i - 9) * 18, this.guiTop + 95, 0, 217, 18, 18);
                } else {
                    this.drawTexturedModalRect(this.guiLeft + 7 + (i - 9) * 18, this.guiTop + 95, 19, 217, 18, 18);
                }
                continue;
            }
            if(slotMode) {
                this.drawTexturedModalRect(this.guiLeft + 7 + i * 18, this.guiTop + 64, 0, 217, 18, 18);
            } else {
                this.drawTexturedModalRect(this.guiLeft + 7 + i * 18, this.guiTop + 64, 19, 217, 18, 18);
            }
        }
        GlStateManager.disableBlend();
    }

    protected void mouseClicked(int posX, int posY, int key) throws IOException {
        super.mouseClicked(posX, posY, key);
        int xClick = posX - this.guiLeft;
        int yClick = posY - this.guiTop;
        this.updateButton();
        switch (GuiHelper.getButton(5, 0, xClick, yClick)) {
            case 0: {
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.tile, (byte)1, 0, this.btnPower ? 0 : 1, 0));
                break;
            }
            case 1: {
                if (key == 0) {
                    ++this.btnMode;
                    if (this.btnMode > 24) {
                        this.btnMode = 24;
                    }
                } else {
                    --this.btnMode;
                    if (this.btnMode < 0) {
                        this.btnMode = 0;
                    }
                }
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.tile, (byte)1, 1, this.btnMode, 0));
                break;
            }
            case 2: {
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.tile, (byte)1, 2, this.btnMeta ? 0 : 1, 0));
                break;
            }
            case 3: {
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.tile, (byte)1, 3, this.btnDict ? 0 : 1, 0));
                break;
            }
            case 4: {
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.tile, (byte)1, 4, this.btnLoad ? 0 : 1, 0));
                break;
            }
            case 5: {
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.tile, (byte)1, 5, this.btnUnload ? 0 : 1, 0));
                break;
            }
            case 6: {
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.tile, (byte)1, 6, this.btnNbt ? 0 : 1, 0));
                break;
            }
            case 7: {
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.tile, (byte)1, 7, this.btnRedMode + 1, 0));
                break;
            }
            case 8: {
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.tile, (byte)1, 8, this.btnLiquidMode + 1, 0));
                break;
            }
            case 9: {
                CommonProxy.channelG.sendToServer(new C2SGUIPackets(this.tile, (byte)1, 9, this.btnEnergyMode + 1, 0));
                break;
            }
            default:
        }
    }

    private void updateButton() {
        this.btnPower = this.tile.getField(2) > 0;
        this.btnMeta = this.tile.getField(3) > 0;
        this.btnDict = this.tile.getField(4) > 0;
        this.btnMode = this.tile.getField(5);
        this.btnLoad = this.tile.getField(6) > 0;
        this.btnUnload = this.tile.getField(7) > 0;
        this.btnNbt = this.tile.getField(8) > 0;
        this.btnRedMode = this.tile.getField(10);
        this.btnLiquidMode = this.tile.getField(12);
        this.btnEnergyMode = this.tile.getField(13);
    }
}
