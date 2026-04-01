package com.lulan.shincolle.client.gui.inventory;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.tileentity.TileEntityDesk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerDesk
extends Container {
    private TileEntityDesk tile;
    private final CapaTeitoku capa;
    private int lenTemp;
    private final int type;
    private int allyCD;
    private int[] valueTemp;

    public ContainerDesk(EntityPlayer player, TileEntityDesk te, int type) {
        this.capa = CapaTeitoku.getTeitokuCapability(player);
        this.type = type;
        if (type == 0) {
            this.tile = te;
            this.lenTemp = this.tile.getFieldCount();
            this.valueTemp = new int[this.lenTemp];
        }
        if (this.capa != null) {
            this.capa.setGuiOpening(true);
        }
    }

    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    public void onContainerClosed(EntityPlayer player) {
        if (this.capa != null) {
            this.capa.setGuiOpening(false);
        }
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotid) {
        return ItemStack.EMPTY;
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        if (this.type == 0) {
            for (int i = 0; i < this.listeners.size(); ++i) {
                IContainerListener listener = this.listeners.get(i);
                int temp = 0;
                if (this.allyCD != this.capa.getPlayerTeamCooldownInSec()) {
                    listener.sendWindowProperty(this, 0, this.capa.getPlayerTeamCooldownInSec());
                }
                for (int j = 0; j < this.lenTemp; ++j) {
                    temp = this.tile.getField(j);
                    if (this.valueTemp[j] == temp) continue;
                    listener.sendWindowProperty(this, j + 1, temp);
                }
            }
            this.allyCD = this.capa.getPlayerTeamCooldownInSec();
            for (int k = 0; k < this.lenTemp; ++k) {
                this.valueTemp[k] = this.tile.getField(k);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void updateProgressBar(int id, int value) {
        if(id == 0){
            this.capa.setPlayerTeamCooldown(value * 20);
        } else {
            this.tile.setField(id - 1, value);
        }
    }
}
