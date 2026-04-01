package com.lulan.shincolle.handler;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.client.gui.*;
import com.lulan.shincolle.client.gui.inventory.*;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.tileentity.*;
import com.lulan.shincolle.utility.EntityHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler
implements IGuiHandler {
    public Object getServerGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile;
        Entity entity;
        switch (guiId) {
            case 1: {
                tile = world.getTileEntity(new BlockPos(x, y, z));
                if (tile instanceof TileEntitySmallShipyard) {
                    ((TileEntitySmallShipyard)tile).sendSyncPacket();
                    return new ContainerSmallShipyard(player.inventory, (TileEntitySmallShipyard)tile);
                }
                return null;
            }
            case 0: {
                entity = world.getEntityByID(x);
                if (entity instanceof BasicEntityShip) {
                    short cid = ((BasicEntityShip)entity).getShipClass();
                    EntityHelper.addPlayerColledShip(cid, player);
                    ((BasicEntityShip)entity).sendSyncPacketAll();
                    return new ContainerShipInventory(player.inventory, (BasicEntityShip)entity);
                }
                return null;
            }
            case 2: {
                tile = world.getTileEntity(new BlockPos(x, y, z));
                if (tile instanceof TileMultiGrudgeHeavy) {
                    ((TileMultiGrudgeHeavy)tile).sendSyncPacket();
                    return new ContainerLargeShipyard(player.inventory, (TileMultiGrudgeHeavy)tile);
                }
                return null;
            }
            case 3: {
                tile = world.getTileEntity(new BlockPos(x, y, z));
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                if (capa != null) {
                    capa.sendSyncPacket(7);
                    capa.sendSyncPacket(2);
                    capa.sendSyncPacket(3);
                    capa.sendSyncPacket(5);
                    capa.sendSyncPacket(6);
                    capa.sendSyncPacket(8);
                }
                if (tile instanceof TileEntityDesk) {
                    ((TileEntityDesk)tile).sendSyncPacket();
                    return new ContainerDesk(player, (TileEntityDesk)tile, 0);
                }
                return new ContainerDesk(player, null, x);
            }
            case 5: {
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                capa.sendSyncPacket(4);
                return new ContainerFormation();
            }
            case 7: {
                tile = world.getTileEntity(new BlockPos(x, y, z));
                if (tile instanceof TileEntityVolCore) {
                    ((TileEntityVolCore)tile).sendSyncPacket();
                    return new ContainerVolCore(player.inventory, (TileEntityVolCore)tile);
                }
                return null;
            }
            case 6: {
                tile = world.getTileEntity(new BlockPos(x, y, z));
                if (tile instanceof TileEntityCrane) {
                    ((TileEntityCrane)tile).sendSyncPacket();
                    return new ContainerCrane(player.inventory, (TileEntityCrane)tile);
                }
                return null;
            }
            case 8: {
                ItemStack stack = player.inventory.getCurrentItem();
                if (!stack.isEmpty() && stack.getItem() == ModItems.RecipePaper) {
                    return new ContainerRecipePaper(world, player.inventory, stack);
                }
                return null;
            }
            case 9: {
                CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                if (capa != null && capa.getMorphEntity() instanceof BasicEntityShip) {
                    return new ContainerMorphInventory(capa, player.inventory, (BasicEntityShip)capa.getMorphEntity());
                }
                return null;
            }
            default:
        }
        return null;
    }

    public Object getClientGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile;
        Entity entity;
        CapaTeitoku capa;
        switch (guiId) {
            case 1: {
                tile = world.getTileEntity(new BlockPos(x, y, z));
                if (tile instanceof TileEntitySmallShipyard) {
                    return new GuiSmallShipyard(player.inventory, (TileEntitySmallShipyard)tile);
                }
                return null;
            }
            case 0: {
                entity = world.getEntityByID(x);
                if (entity instanceof BasicEntityShip) {
                    return new GuiShipInventory(player.inventory, (BasicEntityShip)entity);
                }
                return null;
            }
            case 2: {
                tile = world.getTileEntity(new BlockPos(x, y, z));
                if (tile instanceof TileMultiGrudgeHeavy) {
                    return new GuiLargeShipyard(player.inventory, (TileMultiGrudgeHeavy)tile);
                }
                return null;
            }
            case 3: {
                tile = world.getTileEntity(new BlockPos(x, y, z));
                if (tile instanceof TileEntityDesk) {
                    return new GuiDesk(player, (TileEntityDesk)tile, 0);
                }
                return new GuiDesk(player, null, x);
            }
            case 5: {
                return new GuiFormation(player);
            }
            case 7: {
                tile = world.getTileEntity(new BlockPos(x, y, z));
                if (tile instanceof TileEntityVolCore) {
                    return new GuiVolCore(player.inventory, (TileEntityVolCore)tile);
                }
                return null;
            }
            case 6: {
                tile = world.getTileEntity(new BlockPos(x, y, z));
                if (tile instanceof TileEntityCrane) {
                    return new GuiCrane(player.inventory, (TileEntityCrane)tile);
                }
                return null;
            }
            case 8: {
                ItemStack stack = player.inventory.getCurrentItem();
                if (!stack.isEmpty() && stack.getItem() == ModItems.RecipePaper) {
                    return new GuiRecipePaper(player, stack);
                }
                return null;
            }
            case 9: {
                capa = CapaTeitoku.getTeitokuCapability(player);
                if (capa != null && capa.getMorphEntity() instanceof BasicEntityShip) {
                    return new GuiMorphInventory(capa, player.inventory, (BasicEntityShip)capa.getMorphEntity());
                }
                return null;
            }
            default:
        }
        return null;
    }
}
