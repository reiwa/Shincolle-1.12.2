package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.network.S2CEntitySync;
import com.lulan.shincolle.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiAppearance {
    private static final ResourceLocation APPEARANCE_TEXTURE = new ResourceLocation("shincolle", "textures/gui/GuiAppearance.png");

    public void draw(GuiInventory gui, EntityPlayer player) {
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa == null) return;
        int appearance = capa.getAppearance();
        if (appearance < 0 || appearance > 2) {
            return;
        }
        Minecraft mc = Minecraft.getMinecraft();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(APPEARANCE_TEXTURE);
        int posX = gui.getGuiLeft() - 18;
        int posY = gui.getGuiTop();
        //gui.drawTexturedModalRect(posX, posY, 0, 0, 22, 166);
        for (int i = 0; i < 2; i++) {
            gui.drawTexturedModalRect(posX + 5, posY + 16 + i * 13, (i == appearance) ? 0 : 11, 167, 11, 11);
        }
        //mc.fontRenderer.drawString("Looks", posX + 4, posY + 5, 0x323232);
    }

    public void mouseClicked(GuiInventory gui, int mouseX, int mouseY, int mouseButton, EntityPlayer player) {
        if (mouseButton == 0) {
            int xClick = mouseX - (gui.getGuiLeft() - 18);
            int yClick = mouseY - gui.getGuiTop();
            if (xClick >= 5 && xClick <= 16) {
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                if (yClick >= 16 && yClick <= 27) {
                    capa.setAppearance(0);
                    CommonProxy.channelE.sendToAll(new S2CEntitySync(player, 0, (byte)90));
                }
                else if (yClick >= 29 && yClick <= 40) {
                    capa.setAppearance(1);
                    CommonProxy.channelE.sendToAll(new S2CEntitySync(player, 1, (byte)90));
                }
            }
        }
    }
}