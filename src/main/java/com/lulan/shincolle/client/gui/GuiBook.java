package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.reference.Enums;
import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.utility.CalcHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

import java.util.Arrays;
import java.util.List;

public class GuiBook {
    private static final String BOOK_CHAP_KEY = "gui.shincolle:book.chap";
    private static final ResourceLocation guiBookPic01 = new ResourceLocation("shincolle:textures/gui/book/BookPic01.png");
    private static final TextureManager tm = ClientProxy.getMineraft().getTextureManager();
    private static GuiDesk gui;
    private static FontRenderer font;
    private static RenderItem itemRender;
    private static int numChap;
    private static int numPage;
    public static int PageLeftCurrent;
    public static int PageRightCurrent;
    public static final int PageWidth;
    public static int Page0LX;
    public static int Page0RX;
    public static int Page0Y;
    public static final int PageTLX;
    public static final int PageTRX;
    public static final int PageTY;
    protected static final int[] PageLimit;

    private GuiBook() {
    }

    public static void drawBookContent(GuiDesk par1, FontRenderer par2, int chap, int page) {
        itemRender = Minecraft.getMinecraft().getRenderItem();
        int index = GuiBook.getIndexID(chap, page);
        List<int[]> cont = Values.BookList.get(index);
        gui = par1;
        font = par2;
        numChap = chap;
        numPage = page;
        if (cont == null) {
            cont = Arrays.asList(new int[] {0, 0, 0, 0}, new int[] {0, 1, 0, 0});
        }
        GuiBook.drawBookContent(cont);
    }

    private static void drawBookContent(List<int[]> cont) {
        if (cont != null) {
            int leftRand = 0;
            int rightRand = 1;
            if ((GuiBook.gui.tickGUI & 0x7F) == 0) {
                PageLeftCurrent += 2;
                PageRightCurrent += 2;
            }
            for (int[] getc : cont) {
                if (getc == null) continue;
                switch (getc[0]) {
                    case 0: {
                        GuiBook.drawBookText(getc[1], getc[2], getc[3]);
                        break;
                    }
                    case 1: {
                        if (PageLeftCurrent > leftRand) {
                            PageLeftCurrent = 0;
                        }
                        if (PageRightCurrent > rightRand) {
                            PageRightCurrent = 1;
                        }
                        if (getc[1] != PageLeftCurrent && getc[1] != PageRightCurrent) break;
                        GuiBook.drawBookPic(getc);
                        break;
                    }
                    case 2: {
                        if (PageLeftCurrent > leftRand) {
                            PageLeftCurrent = 0;
                        }
                        if (PageRightCurrent > rightRand) {
                            PageRightCurrent = 1;
                        }
                        if (getc[1] != PageLeftCurrent && getc[1] != PageRightCurrent) break;
                        GuiBook.drawBookIcon(getc[1], getc[2], getc[3], getc[4]);
                        break;
                    }
                    case 3: {
                        leftRand = getc[1];
                        rightRand = getc[2];
                        break;
                    }
                    default:
                }
            }
        }
    }

    private static void drawBookText(int pageSide, int offX, int offY) {
        GuiBook.drawTitleText();
        GuiBook.drawPageText(pageSide, offX, offY);
    }

    private static void drawTitleText() {
        String str;
        if(numChap == 0){
            str = I18n.format(BOOK_CHAP_KEY + numChap + ".title");
        } else {
            str = I18n.format(BOOK_CHAP_KEY + numChap + ".title" + numPage);
        }
        int strlen = (int)(font.getStringWidth(str) * 0.5f);
        str = TextFormatting.UNDERLINE + str;
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.8f, 0.8f, 0.8f);
        font.drawString(str, 82 - strlen, 40, Enums.EnumColors.RED_DARK.getValue());
        GlStateManager.popMatrix();
    }

    private static void drawPageText(int pageSide, int offX, int offY) {
        int picY = PageTY + offY - 4;
        int picX = PageTLX;
        if (pageSide > 0) {
            picX = PageTRX;
        }
        String str = I18n.format(BOOK_CHAP_KEY + numChap + ".text" + numPage + "d" + pageSide);
        GuiBook.drawStringWithSpecialSymbol(str, picX + offX, picY);
    }

    private static void drawStringWithSpecialSymbol(String str, int x, int y) {
        String[] strArray = CalcHelper.stringConvNewlineToArray(str);

        GlStateManager.pushMatrix();
        float scale = 0.75f;
        GlStateManager.scale(scale, scale, scale);
        int scaledX = (int) (x / scale);
        int currentScaledY = (int) (y / scale);
        int scaledPageWidth = (int) (PageWidth / scale);

        for (String singleLineOrParagraph : strArray) {
            if (singleLineOrParagraph.isEmpty()) {
                currentScaledY += font.FONT_HEIGHT;
            } else {
                List<String> wrappedLines = font.listFormattedStringToWidth(singleLineOrParagraph, scaledPageWidth);
                font.drawSplitString(singleLineOrParagraph, scaledX, currentScaledY, scaledPageWidth, 0);
                int linesCount = wrappedLines.size();
                if (linesCount == 0 && !singleLineOrParagraph.isEmpty()) {
                    linesCount = 1;
                }
                currentScaledY += linesCount * font.FONT_HEIGHT;
            }
        }
        GlStateManager.popMatrix();
    }

    private static void drawBookPic(int[] parms) {
        if (parms == null || parms.length != 9) {
            return;
        }
        int pageSide = parms[1];
        int posX = parms[2];
        int posY = parms[3];
        int picID = parms[4];
        int picU = parms[5];
        int picV = parms[6];
        int sizeX = parms[7];
        int sizeY = parms[8];
        int picY = Page0Y + posY;
        int picX = Page0LX;
        if ((pageSide & 1) == 1) {
            picX = Page0RX;
        }
        picX += posX;
        if(picID == 0){
            tm.bindTexture(guiBookPic01);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        gui.drawTexturedModalRect(picX, picY, picU, picV, sizeX, sizeY);
        GlStateManager.disableBlend();
    }

    private static void drawBookIcon(int pageSide, int offX, int offY, int iconID) {
        int picY = Page0Y + offY;
        int picX = Page0LX;
        if ((pageSide & 1) == 1) {
            picX = Page0RX;
        }
        GuiBook.drawItemIcon(GuiBook.getItemStackForIcon(iconID), picX + offX, picY);
    }

    private static void drawItemIcon(ItemStack item, int x, int y) {
        if (item != null) {
            RenderHelper.enableGUIStandardItemLighting();
            itemRender.renderItemIntoGUI(item, x, y);
            RenderHelper.disableStandardItemLighting();
        }
    }

    public static int getMaxPageNumber(int chap) {
        if (chap < PageLimit.length) {
            return PageLimit[chap];
        }
        return 0;
    }

    public static int getIndexID(int ch, int pg) {
        return ch * 1000 + pg;
    }

    public static ItemStack getItemStackForIcon(int itemID) {
        return Values.ItemIconMap.get((short)itemID);
    }

    static {
        PageLeftCurrent = 0;
        PageRightCurrent = 0;
        PageWidth = 105;
        Page0LX = 13;
        Page0RX = 133;
        Page0Y = 48;
        PageTLX = 13;
        PageTRX = 132;
        PageTY = 48;
        PageLimit = new int[]{2, 29, 6, 20, 26, 19, 4};
    }
}
