package com.lulan.shincolle.network;

import com.lulan.shincolle.ShinColle;
import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.*;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.init.ModItems;
import com.lulan.shincolle.item.ShipTank;
import com.lulan.shincolle.playerskill.ShipSkillHandler;
import com.lulan.shincolle.reference.unitclass.Attrs;
import com.lulan.shincolle.utility.*;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class C2SInputPackets
implements IMessage {
    private byte packetID;
    private int[] value3;

    public C2SInputPackets() {
    }

    public C2SInputPackets(byte id, int ... parms) {
        this.packetID = id;
        this.value3 = parms;
    }

    public void fromBytes(ByteBuf buf) {
        this.packetID = buf.readByte();
        switch (this.packetID) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                int value;
                try {
                    value = buf.readInt();
                    if (value <= 0) break;
                    this.value3 = PacketHelper.readIntArray(buf, value);
                    break;
                }
                catch (Exception e) {
                    LogHelper.info("EXCEPTION: C2S input packet: ");
                    e.printStackTrace();
                }
                break;
            }
            default:
        }
    }

    public void toBytes(ByteBuf buf) {
        buf.writeByte(this.packetID);
        switch (this.packetID) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                if (this.value3 != null) {
                    buf.writeInt(this.value3.length);
                    for (int geti : this.value3) {
                        buf.writeInt(geti);
                    }
                    break;
                }
                buf.writeInt(0);
                break;
            }
            default:
        }
    }

    private static void handle(C2SInputPackets msg, MessageContext ctx) {
        EntityPlayerMP player = ctx.getServerHandler().player;
        try {
            switch (msg.packetID) {
                case 0: {
                    if (!player.isRiding() || !(player.getRidingEntity() instanceof BasicEntityMount)) break;
                    BasicEntityMount mount = (BasicEntityMount)player.getRidingEntity();
                    BasicEntityShip ship = (BasicEntityShip)mount.getHostEntity();
                    if (ship != null && TeamHelper.checkSameOwner(player, ship)) {
                        mount.keyPressed = msg.value3[0];
                        mount.keyTick = 10;

                        if (msg.value3[0] > 0) {
                            ship.setGuardedPos(-1, -1, -1, 0, 0);
                            ship.setGuardedEntity(null);
                        }
                    }
                    break;
                }
                case 1: {
                    if (player.isRiding() && player.getRidingEntity() instanceof BasicEntityMount) {
                        BasicEntityMount mount = (BasicEntityMount)player.getRidingEntity();
                        BasicEntityShip ship = (BasicEntityShip)mount.getHostEntity();
                        if (ship != null && TeamHelper.checkSameOwner(player, ship)) {
                            FMLNetworkHandler.openGui(player, ShinColle.instance, 0, player.world, mount.getHostEntity().getEntityId(), 0, 0);
                        }
                    } else {
                        if (player.getPassengers().isEmpty() || !(player.getPassengers().get(0) instanceof BasicEntityShip)) break;
                        BasicEntityShip ship = (BasicEntityShip)player.getPassengers().get(0);
                        if (TeamHelper.checkSameOwner(player, ship)) {
                            FMLNetworkHandler.openGui(player, ShinColle.instance, 0, player.world, ship.getEntityId(), 0, 0);
                        }
                    }
                    break;
                }
                case 13: {
                    CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
                    if (capa != null && capa.getMorphEntity() instanceof BasicEntityShip) {
                        FMLNetworkHandler.openGui(player, ShinColle.instance, 9, player.world, 0, 0, 0);
                    }
                    break;
                }
                case 12: {
                    ShipSkillHandler.handlePlayerSkill(player, msg.value3);
                    break;
                }
                case 2: {
                    player.inventory.currentItem = msg.value3[0];
                    break;
                }
                case 3: {
                    player = (EntityPlayerMP)EntityHelper.getEntityPlayerByID(msg.value3[0], msg.value3[2], false);
                    Entity entity = EntityHelper.getEntityByID(msg.value3[1], msg.value3[2], false);
                    if (player == null || !(entity instanceof BasicEntityShip)) break;
                    EntityHelper.setPetPlayerUUID(player.getUniqueID(), (EntityTameable)entity);
                    EntityHelper.setPetPlayerUID(player, (IShipOwner)entity);
                    ((BasicEntityShip)entity).ownerName = player.getName();
                    LogHelper.debug("DEBUG : C2S input packet: command: change owner " + player + " " + entity);
                    ((BasicEntityShip)entity).sendSyncPacketAll();
                    break;
                }
                case 4: {
                    Entity entity = EntityHelper.getEntityByID(msg.value3[0], msg.value3[1], false);
                    if (!(entity instanceof BasicEntityShip)) break;
                    BasicEntityShip ship = (BasicEntityShip)entity;
                    if (msg.value3.length == 9) {
                        Attrs shipattrs = ship.getAttrs();
                        shipattrs.setAttrsBonus(0, msg.value3[3]);
                        shipattrs.setAttrsBonus(1, msg.value3[4]);
                        shipattrs.setAttrsBonus(2, msg.value3[5]);
                        shipattrs.setAttrsBonus(3, msg.value3[6]);
                        shipattrs.setAttrsBonus(4, msg.value3[7]);
                        shipattrs.setAttrsBonus(5, msg.value3[8]);
                        ship.setShipLevel(msg.value3[2], true);
                        break;
                    }
                    if (msg.value3.length == 3) {
                        ship.setShipLevel(msg.value3[2], true);
                    }
                    break;
                }
                case 5: {
                    Entity entity = EntityHelper.getEntityByID(msg.value3[0], msg.value3[1], false);
                    if (entity instanceof BasicEntityShip) {
                        ((BasicEntityShip)entity).sendSyncPacketEmotion();
                        break;
                    }
                    if (entity instanceof BasicEntityShipHostile) {
                        ((BasicEntityShipHostile)entity).sendSyncPacket(0);
                        break;
                    }
                    if (entity instanceof BasicEntitySummon) {
                        ((BasicEntitySummon)entity).sendSyncPacket(0);
                        break;
                    }
                    if (!(entity instanceof EntityPlayer)) break;
                    CapaTeitoku capa = CapaTeitoku.getTeitokuCapability((EntityPlayer)entity);
                    if (capa != null && capa.getMorphEntity() instanceof BasicEntityShip) {
                        ((BasicEntityShip)capa.getMorphEntity()).sendSyncPacketEmotion();
                    }
                    break;
                }
                case 7: {
                    Entity entity = EntityHelper.getEntityByID(msg.value3[0], msg.value3[1], false);
                    if (!(entity instanceof BasicEntityShip)) break;
                    BasicEntityShip ship = (BasicEntityShip)entity;
                    if (TeamHelper.checkSameOwner(player, ship)) {
                        ship.setEntitySit(false);
                        ship.startRiding(player, true);
                        ship.getShipNavigate().clearPathEntity();
                        ship.sendSyncPacketRiders();
                    }
                    break;
                }
                case 6: {
                    EntityPlayerMP p = ctx.getServerHandler().player;
                    World w = null;
                    if (p != null) {
                        w = p.world;
                    }
                    if (w != null) {
                        float dx = (float)msg.value3[1] - msg.value3[4];
                        float dy = (float)msg.value3[2] - msg.value3[5];
                        float dz = (float)msg.value3[3] - msg.value3[6];
                        float dist = (float)Math.sqrt(dx * dx + dy * dy + dz * dz);
                        if (dist <= ConfigHandler.pairDistWp) {
                            TileEntityHelper.pairingWaypoints(p, msg.value3[0], w, new BlockPos(msg.value3[1], msg.value3[2], msg.value3[3]), new BlockPos(msg.value3[4], msg.value3[5], msg.value3[6]));
                            break;
                        }
                        TextComponentTranslation str = new TextComponentTranslation("chat.shincolle:wrench.wptoofar");
                        str.getStyle().setColor(TextFormatting.YELLOW);
                        player.sendMessage(str);
                    }
                    break;
                }
                case 9: {
                    EntityPlayerMP p = ctx.getServerHandler().player;
                    World w = null;
                    if (p != null) {
                        w = p.world;
                    }
                    if (w != null) {
                        float dx = (float)msg.value3[1] - msg.value3[4];
                        float dy = (float)msg.value3[2] - msg.value3[5];
                        float dz = (float)msg.value3[3] - msg.value3[6];
                        float dist = (float)Math.sqrt(dx * dx + dy * dy + dz * dz);
                        if (dist <= ConfigHandler.pairDistChest) {
                            TileEntityHelper.pairingWaypointAndChest(p, msg.value3[0], w, new BlockPos(msg.value3[1], msg.value3[2], msg.value3[3]), new BlockPos(msg.value3[4], msg.value3[5], msg.value3[6]));
                            break;
                        }
                        TextComponentTranslation str = new TextComponentTranslation("chat.shincolle:wrench.toofar");
                        str.getStyle().setColor(TextFormatting.YELLOW);
                        player.sendMessage(str);
                    }
                    break;
                }
                case 8: {
                    BlockPos pos;
                    IFluidHandler fh;
                    if (player == null) break;
                    ItemStack stack = player.inventory.getCurrentItem();
                    if (!stack.isEmpty() && stack.getItem() == ModItems.ShipTank && (fh = FluidUtil.getFluidHandler(stack)) != null && player.world.isBlockModifiable(player, pos = new BlockPos(msg.value3[0], msg.value3[1], msg.value3[2]))) {
                        ShipTank.tryPlaceContainedLiquid(player, player.world, pos, fh);
                    }
                    break;
                }
                case 10: {
                    Entity entity = EntityHelper.getEntityByID(msg.value3[0], msg.value3[1], false);
                    if (!(entity instanceof BasicEntityShip)) break;
                    ((BasicEntityShip)entity).sendSyncPacketUnitName();
                    break;
                }
                case 11: {
                    Entity entity = EntityHelper.getEntityByID(msg.value3[0], msg.value3[1], false);
                    if (!(entity instanceof BasicEntityShip)) break;
                    BasicEntityShip ship = (BasicEntityShip)entity;
                    if (!ship.isMorph()) {
                        ship.sendSyncPacketBuffMap();
                    }
                    break;
                }
                case 14: {
                    if (player == null) break;
                    PacketHelper.syncEntityItemListToClient(player);
                    break;
                }
                default:
            }
        }
        catch (Exception e) {
            LogHelper.debug("EXCEPTION : C2S input packet: handler: " + e);
        }
    }

    public static class Handler
    implements IMessageHandler<C2SInputPackets, IMessage> {
        public IMessage onMessage(C2SInputPackets message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> C2SInputPackets.handle(message, ctx));
            return null;
        }
    }
}
