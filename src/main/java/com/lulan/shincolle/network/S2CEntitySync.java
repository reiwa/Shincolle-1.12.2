package com.lulan.shincolle.network;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.client.render.ClientAccessoryData;
import com.lulan.shincolle.entity.*;
import com.lulan.shincolle.entity.other.EntityShipFishingHook;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.reference.unitclass.AttrsAdv;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.PacketHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.*;

public class S2CEntitySync
implements IMessage {
    private Object host;
    private Entity entity;
    private byte packetType;
    private int entityID;
    private int valueInt;
    private int[] valueInt1;
    private float[] valueFloat1;
    private float[] valueFloat2;
    private float[] valueFloat3;
    private float[] valueFloat4;
    private float[] valueFloat5;
    private float[] valueFloat6;
    private double[] valueDouble1;
    private byte[] valueByte1;
    private boolean[] valueBoolean1;
    private List<String> valueString1;
    private Map<Integer, Integer> valueMap1;
    private ItemStack[] stacks;

    public S2CEntitySync() {
    }

    public S2CEntitySync(Entity entity, byte type) {
        this.entity = entity;
        this.packetType = type;
    }

    public S2CEntitySync(Entity entity, int value, byte type) {
        this.entity = entity;
        this.packetType = type;
        this.valueInt = value;
    }

    public S2CEntitySync(Entity entity, byte type, float[] data) {
        this.entity = entity;
        this.packetType = type;
        this.valueFloat1 = data;
    }

    public S2CEntitySync(Object host, byte type) {
        this.host = null;
        this.entity = null;
        this.packetType = type;
        if (host instanceof IShipOwner) {
            this.host = host;
        }
    }

    public void fromBytes(ByteBuf buf) {
        this.packetType = buf.readByte();
        this.entityID = buf.readInt();
        switch (this.packetType) {
            case 0: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 39);
                this.valueBoolean1 = PacketHelper.readBooleanArray(buf, 18);
                this.stacks = new ItemStack[2];
                this.stacks[0] = PacketHelper.readItemStack(buf);
                this.stacks[1] = PacketHelper.readItemStack(buf);
                break;
            }
            case 12: {
                int i;
                float[] data;
                boolean bonus = buf.readBoolean();
                boolean raw = buf.readBoolean();
                boolean equip = buf.readBoolean();
                boolean morale = buf.readBoolean();
                boolean potion = buf.readBoolean();
                boolean formation = buf.readBoolean();
                boolean buffed = buf.readBoolean();
                this.valueByte1 = bonus ? PacketHelper.readByteArray(buf) : null;
                this.valueFloat1 = raw ? PacketHelper.readFloatArray(buf) : null;
                this.valueFloat2 = equip ? PacketHelper.readFloatArray(buf) : null;
                this.valueFloat3 = morale ? PacketHelper.readFloatArray(buf) : null;
                this.valueFloat4 = potion ? PacketHelper.readFloatArray(buf) : null;
                if (formation) {
                    data = PacketHelper.readFloatArray(buf);
                    this.valueFloat5 = new float[22];
                    for (i = 0; i < 21; ++i) {
                        this.valueFloat5[i] = data[i];
                    }
                    this.valueFloat5[21] = buf.readFloat();
                } else {
                    this.valueFloat5 = null;
                }
                if (buffed) {
                    data = PacketHelper.readFloatArray(buf);
                    this.valueFloat6 = new float[22];
                    for (i = 0; i < 21; ++i) {
                        this.valueFloat6[i] = data[i];
                    }
                    this.valueFloat6[21] = buf.readFloat();
                    break;
                }
                this.valueFloat6 = null;
                break;
            }
            case 1: 
            case 50: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 6);
                this.valueBoolean1 = PacketHelper.readBooleanArray(buf, 2);
                break;
            }
            case 2: {
                this.valueBoolean1 = PacketHelper.readBooleanArray(buf, 18);
                break;
            }
            case 6: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 7);
                this.valueFloat1 = PacketHelper.readFloatArray(buf, 1);
                break;
            }
            case 3: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 30);
                break;
            }
            case 9: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 6);
                break;
            }
            case 10: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 3);
                break;
            }
            case 5:
            case 80:
            case 8:
            case 55:
            case 90: {
                this.valueInt = buf.readInt();
                break;
            }
            case 13:
            case 51: {
                this.valueInt1 = PacketHelper.readIntArray(buf, 4);
                break;
            }
            case 4: {
                this.valueInt = buf.readInt();
                if (this.valueInt > 0) {
                    this.valueInt1 = PacketHelper.readIntArray(buf, this.valueInt + 2);
                    break;
                }
                this.valueInt1 = PacketHelper.readIntArray(buf, 2);
                break;
            }
            case 52: {
                this.valueDouble1 = PacketHelper.readDoubleArray(buf, 3);
                this.valueFloat1 = PacketHelper.readFloatArray(buf, 4);
                break;
            }
            case 53:
            case 54: {
                this.valueFloat1 = PacketHelper.readFloatArray(buf, 3);
                break;
            }
            case 56: {
                this.valueFloat1 = PacketHelper.readFloatArray(buf);
                break;
            }
            case 81: {
                this.valueInt1 = PacketHelper.readIntArray(buf);
                break;
            }
            case 11: {
                this.valueString1 = PacketHelper.readListString(buf);
                break;
            }
            case 7: {
                this.valueMap1 = PacketHelper.readMapInt(buf);
                break;
            }
            default:
        }
    }

    public void toBytes(ByteBuf buf) {
        buf.writeByte(this.packetType);
        if (this.entity == null) {
            buf.writeInt(-1);
        } else if (this.entity instanceof IShipMorph && ((IShipMorph)this.entity).isMorph() && ((IShipMorph)this.entity).getMorphHost() != null) {
            buf.writeInt(((IShipMorph)this.entity).getMorphHost().getEntityId());
        } else {
            buf.writeInt(this.entity.getEntityId());
        }
        switch (this.packetType) {
            case 0: {
                BasicEntityShip shipentity = (BasicEntityShip)this.entity;
                if(shipentity == null) return;
                buf.writeInt(shipentity.getStateMinor(0));
                buf.writeInt(shipentity.getStateMinor(1));
                buf.writeInt(shipentity.getStateMinor(2));
                buf.writeInt(shipentity.getStateMinor(4));
                buf.writeInt(shipentity.getStateMinor(5));
                buf.writeInt(shipentity.getStateMinor(6));
                buf.writeInt(shipentity.getStateMinor(7));
                buf.writeInt(shipentity.getStateMinor(8));
                buf.writeInt(shipentity.getStateMinor(10));
                buf.writeInt(shipentity.getStateMinor(11));
                buf.writeInt(shipentity.getStateMinor(12));
                buf.writeInt(shipentity.getStateMinor(14));
                buf.writeInt(shipentity.getStateMinor(15));
                buf.writeInt(shipentity.getStateMinor(16));
                buf.writeInt(shipentity.getStateMinor(17));
                buf.writeInt(shipentity.getStateMinor(18));
                buf.writeInt(shipentity.getStateMinor(24));
                buf.writeInt(shipentity.getStateMinor(21));
                buf.writeInt(shipentity.getStateMinor(22));
                buf.writeInt(shipentity.getStateMinor(23));
                buf.writeInt(shipentity.getStateMinor(26));
                buf.writeInt(shipentity.getStateMinor(27));
                buf.writeInt(shipentity.getStateMinor(30));
                buf.writeInt(shipentity.getStateMinor(36));
                buf.writeInt(shipentity.getStateMinor(37));
                buf.writeInt(shipentity.getStateMinor(38));
                buf.writeInt(shipentity.getStateMinor(39));
                buf.writeInt(shipentity.getStateMinor(44));
                buf.writeInt(shipentity.getStateMinor(9));
                buf.writeInt(shipentity.getStateTimer(1));
                buf.writeInt(shipentity.getStateMinor(35));
                buf.writeInt(shipentity.getStateMinor(13));
                buf.writeInt(shipentity.getStateMinor(40));
                buf.writeInt(shipentity.getStateMinor(41));
                buf.writeInt(shipentity.getStateEmotion(0));
                buf.writeInt(shipentity.getStateEmotion(3));
                buf.writeInt(shipentity.getStateEmotion(1));
                buf.writeInt(shipentity.getStateEmotion(7));
                buf.writeInt(shipentity.getStateEmotion(5));
                buf.writeBoolean(shipentity.getStateFlag(0));
                buf.writeBoolean(shipentity.getStateFlag(1));
                buf.writeBoolean(shipentity.getStateFlag(2));
                buf.writeBoolean(shipentity.getStateFlag(3));
                buf.writeBoolean(shipentity.getStateFlag(4));
                buf.writeBoolean(shipentity.getStateFlag(5));
                buf.writeBoolean(shipentity.getStateFlag(6));
                buf.writeBoolean(shipentity.getStateFlag(7));
                buf.writeBoolean(shipentity.getStateFlag(9));
                buf.writeBoolean(shipentity.getStateFlag(12));
                buf.writeBoolean(shipentity.getStateFlag(18));
                buf.writeBoolean(shipentity.getStateFlag(19));
                buf.writeBoolean(shipentity.getStateFlag(20));
                buf.writeBoolean(shipentity.getStateFlag(21));
                buf.writeBoolean(shipentity.getStateFlag(22));
                buf.writeBoolean(shipentity.getStateFlag(23));
                buf.writeBoolean(shipentity.getStateFlag(24));
                buf.writeBoolean(shipentity.getStateFlag(25));
                PacketHelper.sendItemStack(buf, shipentity.getHeldItemMainhand());
                PacketHelper.sendItemStack(buf, shipentity.getHeldItemOffhand());
                break;
            }
            case 12: {
                float[] data2;
                BasicEntityShip shipentity = (BasicEntityShip)this.entity;
                if(shipentity == null) return;
                AttrsAdv attrs = (AttrsAdv)shipentity.getAttrs();
                buf.writeBoolean(shipentity.getUpdateFlag(2));
                buf.writeBoolean(shipentity.getUpdateFlag(7));
                buf.writeBoolean(shipentity.getUpdateFlag(3));
                buf.writeBoolean(shipentity.getUpdateFlag(4));
                buf.writeBoolean(shipentity.getUpdateFlag(5));
                buf.writeBoolean(shipentity.getUpdateFlag(6));
                buf.writeBoolean(shipentity.getUpdateFlag(1));
                if (shipentity.getUpdateFlag(2)) {
                    byte[] data1 = attrs.getAttrsBonus();
                    PacketHelper.sendArrayByte(buf, data1);
                }
                if (shipentity.getUpdateFlag(7)) {
                    data2 = attrs.getAttrsRaw();
                    PacketHelper.sendArrayFloat(buf, data2);
                }
                if (shipentity.getUpdateFlag(3)) {
                    data2 = attrs.getAttrsEquip();
                    PacketHelper.sendArrayFloat(buf, data2);
                }
                if (shipentity.getUpdateFlag(4)) {
                    data2 = attrs.getAttrsMorale();
                    PacketHelper.sendArrayFloat(buf, data2);
                }
                if (shipentity.getUpdateFlag(5)) {
                    data2 = attrs.getAttrsPotion();
                    PacketHelper.sendArrayFloat(buf, data2);
                }
                if (shipentity.getUpdateFlag(6)) {
                    data2 = attrs.getAttrsFormation();
                    PacketHelper.sendArrayFloat(buf, data2);
                    buf.writeFloat(attrs.getMinMOV());
                }
                if (shipentity.getUpdateFlag(1)) {
                    data2 = attrs.getAttrsBuffed();
                    PacketHelper.sendArrayFloat(buf, data2);
                    buf.writeFloat(attrs.getMinMOV());
                }
                shipentity.setUpdateFlag(1, false);
                shipentity.setUpdateFlag(2, false);
                shipentity.setUpdateFlag(3, false);
                shipentity.setUpdateFlag(4, false);
                shipentity.setUpdateFlag(5, false);
                shipentity.setUpdateFlag(6, false);
                shipentity.setUpdateFlag(7, false);
                break;
            }
            case 1: 
            case 50: {
                IShipEmotion shipentity = (IShipEmotion)this.entity;
                if(shipentity == null) return;
                buf.writeInt(shipentity.getStateEmotion(0));
                buf.writeInt(shipentity.getStateEmotion(3));
                buf.writeInt(shipentity.getStateEmotion(1));
                buf.writeInt(shipentity.getStateEmotion(7));
                buf.writeInt(shipentity.getStateEmotion(5));
                if (this.entity instanceof IShipMorph) {
                    if (((IShipMorph) entity).getMorphHost() != null) {
                        buf.writeInt(((IShipMorph) entity).getMorphHost().getEntityId());
                    } else {
                        buf.writeInt(-1);
                    }
                } else {
                    buf.writeInt(-1);
                }
                buf.writeBoolean(shipentity.getStateFlag(2));
                buf.writeBoolean(shipentity.getIsSitting());
                break;
            }
            case 2: {
                BasicEntityShip shipentity = (BasicEntityShip)this.entity;
                if(shipentity == null) return;
                buf.writeBoolean(shipentity.getStateFlag(0));
                buf.writeBoolean(shipentity.getStateFlag(1));
                buf.writeBoolean(shipentity.getStateFlag(2));
                buf.writeBoolean(shipentity.getStateFlag(3));
                buf.writeBoolean(shipentity.getStateFlag(4));
                buf.writeBoolean(shipentity.getStateFlag(5));
                buf.writeBoolean(shipentity.getStateFlag(6));
                buf.writeBoolean(shipentity.getStateFlag(7));
                buf.writeBoolean(shipentity.getStateFlag(9));
                buf.writeBoolean(shipentity.getStateFlag(12));
                buf.writeBoolean(shipentity.getStateFlag(18));
                buf.writeBoolean(shipentity.getStateFlag(19));
                buf.writeBoolean(shipentity.getStateFlag(20));
                buf.writeBoolean(shipentity.getStateFlag(21));
                buf.writeBoolean(shipentity.getStateFlag(22));
                buf.writeBoolean(shipentity.getStateFlag(23));
                buf.writeBoolean(shipentity.getStateFlag(24));
                buf.writeBoolean(shipentity.getStateFlag(25));
                break;
            }
            case 3: {
                BasicEntityShip shipentity = (BasicEntityShip)this.entity;
                if(shipentity == null) return;
                buf.writeInt(shipentity.getStateMinor(0));
                buf.writeInt(shipentity.getStateMinor(1));
                buf.writeInt(shipentity.getStateMinor(2));
                buf.writeInt(shipentity.getStateMinor(4));
                buf.writeInt(shipentity.getStateMinor(5));
                buf.writeInt(shipentity.getStateMinor(6));
                buf.writeInt(shipentity.getStateMinor(7));
                buf.writeInt(shipentity.getStateMinor(8));
                buf.writeInt(shipentity.getStateMinor(10));
                buf.writeInt(shipentity.getStateMinor(11));
                buf.writeInt(shipentity.getStateMinor(12));
                buf.writeInt(shipentity.getStateMinor(14));
                buf.writeInt(shipentity.getStateMinor(15));
                buf.writeInt(shipentity.getStateMinor(16));
                buf.writeInt(shipentity.getStateMinor(17));
                buf.writeInt(shipentity.getStateMinor(18));
                buf.writeInt(shipentity.getStateMinor(24));
                buf.writeInt(shipentity.getStateMinor(21));
                buf.writeInt(shipentity.getStateMinor(22));
                buf.writeInt(shipentity.getStateMinor(23));
                buf.writeInt(shipentity.getStateMinor(26));
                buf.writeInt(shipentity.getStateMinor(27));
                buf.writeInt(shipentity.getStateMinor(30));
                buf.writeInt(shipentity.getStateMinor(36));
                buf.writeInt(shipentity.getStateMinor(37));
                buf.writeInt(shipentity.getStateMinor(38));
                buf.writeInt(shipentity.getStateMinor(39));
                buf.writeInt(shipentity.getStateMinor(44));
                buf.writeInt(shipentity.getStateMinor(9));
                buf.writeInt(shipentity.getStateMinor(35));
                break;
            }
            case 9: {
                BasicEntityShip shipentity = (BasicEntityShip)this.entity;
                if(shipentity == null) return;
                buf.writeInt(shipentity.getStateMinor(14));
                buf.writeInt(shipentity.getStateMinor(15));
                buf.writeInt(shipentity.getStateMinor(16));
                buf.writeInt(shipentity.getStateMinor(17));
                buf.writeInt(shipentity.getStateMinor(18));
                buf.writeInt(shipentity.getStateMinor(24));
                break;
            }
            case 10: {
                BasicEntityShip shipentity = (BasicEntityShip)this.entity;
                if(shipentity == null) return;
                buf.writeInt(shipentity.getStateMinor(21));
                buf.writeInt(shipentity.getStateMinor(22));
                buf.writeInt(shipentity.getStateMinor(23));
                break;
            }
            case 5: {
                buf.writeInt(((IShipEmotion)this.entity).getScaleLevel());
                break;
            }
            case 8: {
                BasicEntityShip shipentity = (BasicEntityShip)this.entity;
                if(shipentity == null) return;
                buf.writeInt(shipentity.getStateTimer(1));
                break;
            }
            case 13: {
                BasicEntityShip shipentity = (BasicEntityShip)this.entity;
                if(shipentity == null) return;
                buf.writeInt(shipentity.getStateTimer(16));
                buf.writeInt(shipentity.getStateTimer(17));
                buf.writeInt(shipentity.getStateTimer(18));
                buf.writeInt(shipentity.getStateTimer(19));
                break;
            }
            case 4: {
                if(this.entity == null) return;
                List<Entity> list = this.entity.getPassengers();
                int length = list.size();
                buf.writeInt(length);
                if (length > 0) {
                    for (Entity ent : list) {
                        buf.writeInt(ent.getEntityId());
                    }
                }
                if (this.entity instanceof BasicEntityMount) {
                    buf.writeInt(((BasicEntityMount)this.entity).getHostEntity().getEntityId());
                } else {
                    buf.writeInt(0);
                }
                if (this.entity.getRidingEntity() != null) {
                    buf.writeInt(this.entity.getRidingEntity().getEntityId());
                    break;
                }
                buf.writeInt(0);
                break;
            }
            case 80:
            case 90: {
                buf.writeInt(this.valueInt);
                break;
            }
            case 52: {
                if (this.entity instanceof EntityLivingBase) {
                    buf.writeDouble(this.entity.posX);
                    buf.writeDouble(this.entity.posY);
                    buf.writeDouble(this.entity.posZ);
                    buf.writeFloat(this.entity.rotationYaw);
                    buf.writeFloat(this.entity.rotationPitch);
                    buf.writeFloat(((EntityLivingBase)this.entity).renderYawOffset);
                    buf.writeFloat(((EntityLivingBase)this.entity).rotationYawHead);
                    break;
                }
                buf.writeDouble(this.entity.posX);
                buf.writeDouble(this.entity.posY);
                buf.writeDouble(this.entity.posZ);
                buf.writeFloat(this.entity.rotationYaw);
                buf.writeFloat(this.entity.rotationPitch);
                buf.writeFloat(0.0f);
                buf.writeFloat(0.0f);
                break;
            }
            case 53: {
                if (this.entity instanceof EntityLivingBase) {
                    buf.writeFloat(((EntityLivingBase)this.entity).rotationYawHead);
                    buf.writeFloat(this.entity.rotationYaw);
                    buf.writeFloat(this.entity.rotationPitch);
                    break;
                }
                buf.writeFloat(this.entity.rotationYaw);
                buf.writeFloat(this.entity.rotationYaw);
                buf.writeFloat(this.entity.rotationPitch);
                break;
            }
            case 6: {
                BasicEntityShip shipentity = (BasicEntityShip)this.entity;
                if(shipentity == null) return;
                buf.writeInt(shipentity.getStateMinor(14));
                buf.writeInt(shipentity.getStateMinor(15));
                buf.writeInt(shipentity.getStateMinor(16));
                buf.writeInt(shipentity.getStateMinor(17));
                buf.writeInt(shipentity.getStateMinor(24));
                buf.writeInt(shipentity.getStateMinor(26));
                buf.writeInt(shipentity.getStateMinor(27));
                buf.writeFloat(((AttrsAdv)shipentity.getAttrs()).getMinMOV());
                break;
            }
            case 54: {
                buf.writeFloat((float)this.entity.motionX);
                buf.writeFloat((float)this.entity.motionY);
                buf.writeFloat((float)this.entity.motionZ);
                break;
            }
            case 56: {
                PacketHelper.sendArrayFloat(buf, this.valueFloat1);
                break;
            }
            case 51: {
                boolean sendFail = true;
                if (this.host instanceof IShipOwner) {
                    if (this.host instanceof TileEntity) {
                        sendFail = false;
                        buf.writeInt(((TileEntity)this.host).getPos().getX());
                        buf.writeInt(((TileEntity)this.host).getPos().getY());
                        buf.writeInt(((TileEntity)this.host).getPos().getZ());
                        buf.writeInt(((IShipOwner)this.host).getPlayerUID());
                    } else if (this.host instanceof Entity) {
                        sendFail = false;
                        buf.writeInt(((Entity)this.host).getEntityId());
                        buf.writeInt(-1);
                        buf.writeInt(-1);
                        buf.writeInt(((IShipOwner)this.host).getPlayerUID());
                    }
                }
                if (!sendFail) break;
                buf.writeInt(0);
                buf.writeInt(0);
                buf.writeInt(0);
                buf.writeInt(0);
                break;
            }
            case 81: {
                PacketHelper.sendArrayInt(buf, ConfigHandler.ringAbility);
                break;
            }
            case 11: {
                BasicEntityShip ship = (BasicEntityShip)this.entity;
                if (ship == null || ship.unitNames == null) break;
                PacketHelper.sendListString(buf, ship.unitNames);
                break;
            }
            case 7: {
                BasicEntityShip ship = (BasicEntityShip)this.entity;
                if (ship.getBuffMap() == null) break;
                PacketHelper.sendMapInt(buf, ship.getBuffMap());
                break;
            }
            case 55: {
                if (!(this.entity instanceof EntityShipFishingHook)) break;
                if (((EntityShipFishingHook)this.entity).host != null) {
                    buf.writeInt(((EntityShipFishingHook)this.entity).host.getEntityId());
                    break;
                }
                buf.writeInt(-1);
                break;
            }
            default:
        }
    }

    private static void handle(S2CEntitySync msg) {
        boolean getTarget = false;
        Entity entity = null;
        BasicEntityShip ship;
        CapaTeitoku capa;
        if (msg.entityID > 0) {
            entity = EntityHelper.getEntityByID(msg.entityID, 0, true);
        }
        switch (msg.packetType) {
            case 0: 
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: {
                if (!(entity instanceof BasicEntityShip) && !(entity instanceof IShipEmotion) && !(entity instanceof EntityLivingBase)) break;
                getTarget = true;
                break;
            }
            case 1: 
            case 50: {
                if (entity instanceof BasicEntityShip || entity instanceof IShipEmotion || entity instanceof EntityLivingBase) {
                    getTarget = true;
                    break;
                }
                entity = EntityHelper.getEntityPlayerByID(msg.valueInt1[5], 0, true);
                if (entity == null) break;
                getTarget = true;
                break;
            }
            case 4: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 80: {
                if (entity == null) break;
                getTarget = true;
                break;
            }
            case 51: 
            case 81: {
                getTarget = true;
                break;
            }
            case 90: {
                if (entity instanceof EntityPlayer) {
                    getTarget = true;
                }
                break;
            }
            default:
        }
        if (getTarget) {
            switch (msg.packetType) {
                case 0: {
                    ship = S2CEntitySync.getShipByEntity(entity);
                    if (ship == null) {
                        return;
                    }
                    ship.setStateMinor(0, msg.valueInt1[0]);
                    ship.setStateMinor(1, msg.valueInt1[1]);
                    ship.setStateMinor(2, msg.valueInt1[2]);
                    ship.setStateMinor(4, msg.valueInt1[3]);
                    ship.setStateMinor(5, msg.valueInt1[4]);
                    ship.setStateMinor(6, msg.valueInt1[5]);
                    ship.setStateMinor(7, msg.valueInt1[6]);
                    ship.setStateMinor(8, msg.valueInt1[7]);
                    ship.setStateMinor(10, msg.valueInt1[8]);
                    ship.setStateMinor(11, msg.valueInt1[9]);
                    ship.setStateMinor(12, msg.valueInt1[10]);
                    ship.setStateMinor(14, msg.valueInt1[11]);
                    ship.setStateMinor(15, msg.valueInt1[12]);
                    ship.setStateMinor(16, msg.valueInt1[13]);
                    ship.setStateMinor(17, msg.valueInt1[14]);
                    ship.setStateMinor(18, msg.valueInt1[15]);
                    ship.setStateMinor(24, msg.valueInt1[16]);
                    ship.setStateMinor(21, msg.valueInt1[17]);
                    ship.setStateMinor(22, msg.valueInt1[18]);
                    ship.setStateMinor(23, msg.valueInt1[19]);
                    ship.setStateMinor(26, msg.valueInt1[20]);
                    ship.setStateMinor(27, msg.valueInt1[21]);
                    ship.setStateMinor(30, msg.valueInt1[22]);
                    ship.setStateMinor(36, msg.valueInt1[23]);
                    ship.setStateMinor(37, msg.valueInt1[24]);
                    ship.setStateMinor(38, msg.valueInt1[25]);
                    ship.setStateMinor(39, msg.valueInt1[26]);
                    ship.setStateMinor(44, msg.valueInt1[27]);
                    ship.setStateMinor(9, msg.valueInt1[28]);
                    ship.setStateTimer(1, msg.valueInt1[29]);
                    ship.setStateMinor(35, msg.valueInt1[30]);
                    ship.setStateMinor(13, msg.valueInt1[31]);
                    ship.setStateMinor(40, msg.valueInt1[32]);
                    ship.setStateMinor(41, msg.valueInt1[33]);
                    ship.setStateEmotion(0, msg.valueInt1[34], false);
                    ship.setStateEmotion(3, msg.valueInt1[35], false);
                    ship.setStateEmotion(1, msg.valueInt1[36], false);
                    ship.setStateEmotion(7, msg.valueInt1[37], false);
                    ship.setStateEmotion(5, msg.valueInt1[38], false);
                    ship.setStateFlag(0, msg.valueBoolean1[0]);
                    ship.setStateFlag(1, msg.valueBoolean1[1]);
                    ship.setStateFlag(2, msg.valueBoolean1[2]);
                    ship.setStateFlag(3, msg.valueBoolean1[3]);
                    ship.setStateFlag(4, msg.valueBoolean1[4]);
                    ship.setStateFlag(5, msg.valueBoolean1[5]);
                    ship.setStateFlag(6, msg.valueBoolean1[6]);
                    ship.setStateFlag(7, msg.valueBoolean1[7]);
                    ship.setStateFlag(9, msg.valueBoolean1[8]);
                    ship.setStateFlag(12, msg.valueBoolean1[9]);
                    ship.setStateFlag(18, msg.valueBoolean1[10]);
                    ship.setStateFlag(19, msg.valueBoolean1[11]);
                    ship.setStateFlag(20, msg.valueBoolean1[12]);
                    ship.setStateFlag(21, msg.valueBoolean1[13]);
                    ship.setStateFlag(22, msg.valueBoolean1[14]);
                    ship.setStateFlag(23, msg.valueBoolean1[15]);
                    ship.setStateFlag(24, msg.valueBoolean1[16]);
                    ship.setStateFlag(25, msg.valueBoolean1[17]);
                    ship.getCapaShipInventory().setStackInSlot(22, msg.stacks[0]);
                    ship.getCapaShipInventory().setStackInSlot(23, msg.stacks[1]);
                    return;
                }
                case 12: {
                    ship = S2CEntitySync.getShipByEntity(entity);
                    if (ship == null) {
                        return;
                    }
                    AttrsAdv attrs = (AttrsAdv)ship.getAttrs();
                    if (msg.valueByte1 != null) {
                        attrs.setAttrsBonus(Arrays.copyOf(msg.valueByte1, msg.valueByte1.length));
                    }
                    if (msg.valueFloat1 != null) {
                        attrs.setAttrsRaw(Arrays.copyOf(msg.valueFloat1, msg.valueFloat1.length));
                    }
                    if (msg.valueFloat2 != null) {
                        attrs.setAttrsEquip(Arrays.copyOf(msg.valueFloat2, msg.valueFloat2.length));
                    }
                    if (msg.valueFloat3 != null) {
                        attrs.setAttrsMorale(Arrays.copyOf(msg.valueFloat3, msg.valueFloat3.length));
                    }
                    if (msg.valueFloat4 != null) {
                        attrs.setAttrsPotion(Arrays.copyOf(msg.valueFloat4, msg.valueFloat4.length));
                    }
                    if (msg.valueFloat5 != null) {
                        attrs.setAttrsFormation(Arrays.copyOf(msg.valueFloat5, 21));
                        attrs.setMinMOV(msg.valueFloat5[21]);
                    }
                    if (msg.valueFloat6 == null) return;
                    attrs.setAttrsBuffed(Arrays.copyOf(msg.valueFloat6, 21));
                    attrs.setMinMOV(msg.valueFloat6[21]);
                    return;
                }
                case 1: 
                case 50: {
                    IShipEmotion entity2 = null;
                    if (entity instanceof IShipEmotion) {
                        entity2 = (IShipEmotion)entity;
                    } else if (entity instanceof EntityPlayer && (capa = CapaTeitoku.getTeitokuCapability((EntityPlayer)entity)) != null && capa.getMorphEntity() instanceof IShipEmotion) {
                        entity2 = (IShipEmotion)capa.getMorphEntity();
                    }
                    if (entity2 == null) return;
                    entity2.setStateEmotion(0, msg.valueInt1[0], false);
                    entity2.setStateEmotion(3, msg.valueInt1[1], false);
                    entity2.setStateEmotion(1, msg.valueInt1[2], false);
                    entity2.setStateEmotion(7, msg.valueInt1[3], false);
                    entity2.setStateEmotion(5, msg.valueInt1[4], false);
                    entity2.setStateFlag(2, msg.valueBoolean1[0]);
                    entity2.setEntitySit(msg.valueBoolean1[1]);
                    return;
                }
                case 2: {
                    ship = S2CEntitySync.getShipByEntity(entity);
                    if (ship == null) {
                        return;
                    }
                    ship.setStateFlag(0, msg.valueBoolean1[0]);
                    ship.setStateFlag(1, msg.valueBoolean1[1]);
                    ship.setStateFlag(2, msg.valueBoolean1[2]);
                    ship.setStateFlag(3, msg.valueBoolean1[3]);
                    ship.setStateFlag(4, msg.valueBoolean1[4]);
                    ship.setStateFlag(5, msg.valueBoolean1[5]);
                    ship.setStateFlag(6, msg.valueBoolean1[6]);
                    ship.setStateFlag(7, msg.valueBoolean1[7]);
                    ship.setStateFlag(9, msg.valueBoolean1[8]);
                    ship.setStateFlag(12, msg.valueBoolean1[9]);
                    ship.setStateFlag(18, msg.valueBoolean1[10]);
                    ship.setStateFlag(19, msg.valueBoolean1[11]);
                    ship.setStateFlag(20, msg.valueBoolean1[12]);
                    ship.setStateFlag(21, msg.valueBoolean1[13]);
                    ship.setStateFlag(22, msg.valueBoolean1[14]);
                    ship.setStateFlag(23, msg.valueBoolean1[15]);
                    ship.setStateFlag(24, msg.valueBoolean1[16]);
                    ship.setStateFlag(25, msg.valueBoolean1[17]);
                    return;
                }
                case 6: {
                    ship = S2CEntitySync.getShipByEntity(entity);
                    if (ship == null) {
                        return;
                    }
                    ship.setStateMinor(14, msg.valueInt1[0]);
                    ship.setStateMinor(15, msg.valueInt1[1]);
                    ship.setStateMinor(16, msg.valueInt1[2]);
                    ship.setStateMinor(17, msg.valueInt1[3]);
                    ship.setStateMinor(24, msg.valueInt1[4]);
                    ship.setStateMinor(26, msg.valueInt1[5]);
                    ship.setStateMinor(27, msg.valueInt1[6]);
                    ((AttrsAdv)ship.getAttrs()).setMinMOV(msg.valueFloat1[0]);
                    return;
                }
                case 3: {
                    ship = S2CEntitySync.getShipByEntity(entity);
                    if (ship == null) {
                        return;
                    }
                    ship.setStateMinor(0, msg.valueInt1[0]);
                    ship.setStateMinor(1, msg.valueInt1[1]);
                    ship.setStateMinor(2, msg.valueInt1[2]);
                    ship.setStateMinor(4, msg.valueInt1[3]);
                    ship.setStateMinor(5, msg.valueInt1[4]);
                    ship.setStateMinor(6, msg.valueInt1[5]);
                    ship.setStateMinor(7, msg.valueInt1[6]);
                    ship.setStateMinor(8, msg.valueInt1[7]);
                    ship.setStateMinor(10, msg.valueInt1[8]);
                    ship.setStateMinor(11, msg.valueInt1[9]);
                    ship.setStateMinor(12, msg.valueInt1[10]);
                    ship.setStateMinor(14, msg.valueInt1[11]);
                    ship.setStateMinor(15, msg.valueInt1[12]);
                    ship.setStateMinor(16, msg.valueInt1[13]);
                    ship.setStateMinor(17, msg.valueInt1[14]);
                    ship.setStateMinor(18, msg.valueInt1[15]);
                    ship.setStateMinor(24, msg.valueInt1[16]);
                    ship.setStateMinor(21, msg.valueInt1[17]);
                    ship.setStateMinor(22, msg.valueInt1[18]);
                    ship.setStateMinor(23, msg.valueInt1[19]);
                    ship.setStateMinor(26, msg.valueInt1[20]);
                    ship.setStateMinor(27, msg.valueInt1[21]);
                    ship.setStateMinor(30, msg.valueInt1[22]);
                    ship.setStateMinor(36, msg.valueInt1[23]);
                    ship.setStateMinor(37, msg.valueInt1[24]);
                    ship.setStateMinor(38, msg.valueInt1[25]);
                    ship.setStateMinor(39, msg.valueInt1[26]);
                    ship.setStateMinor(44, msg.valueInt1[27]);
                    ship.setStateMinor(9, msg.valueInt1[28]);
                    ship.setStateMinor(35, msg.valueInt1[29]);
                    return;
                }
                case 9: {
                    ship = S2CEntitySync.getShipByEntity(entity);
                    if (ship == null) {
                        return;
                    }
                    ship.setStateMinor(14, msg.valueInt1[0]);
                    ship.setStateMinor(15, msg.valueInt1[1]);
                    ship.setStateMinor(16, msg.valueInt1[2]);
                    ship.setStateMinor(17, msg.valueInt1[3]);
                    ship.setStateMinor(18, msg.valueInt1[4]);
                    ship.setStateMinor(24, msg.valueInt1[5]);
                    return;
                }
                case 10: {
                    ship = S2CEntitySync.getShipByEntity(entity);
                    if (ship == null) {
                        return;
                    }
                    ship.setStateMinor(21, msg.valueInt1[0]);
                    ship.setStateMinor(22, msg.valueInt1[1]);
                    ship.setStateMinor(23, msg.valueInt1[2]);
                    return;
                }
                case 8: {
                    ship = S2CEntitySync.getShipByEntity(entity);
                    if (ship == null) {
                        return;
                    }
                    ship.setStateTimer(1, msg.valueInt);
                    return;
                }
                case 13: {
                    ship = S2CEntitySync.getShipByEntity(entity);
                    if (ship == null) {
                        return;
                    }
                    ship.setStateTimer(16, msg.valueInt1[0]);
                    ship.setStateTimer(17, msg.valueInt1[1]);
                    ship.setStateTimer(18, msg.valueInt1[2]);
                    ship.setStateTimer(19, msg.valueInt1[3]);
                    return;
                }
                case 5: {
                    if (!(entity instanceof IShipEmotion)) return;
                    ((IShipEmotion)entity).setScaleLevel(msg.valueInt);
                    return;
                }
                case 4: {
                    if (msg.valueInt > 0) {
                        for (int i = 0; i < msg.valueInt; ++i) {
                            Entity ent = EntityHelper.getEntityByID(msg.valueInt1[i], 0, true);
                            if (ent == null) continue;
                            ent.startRiding(entity, true);
                        }
                        if (entity instanceof BasicEntityMount) {
                            Entity ent;
                            if (msg.valueInt1[msg.valueInt] > 0 && (ent = EntityHelper.getEntityByID(msg.valueInt1[msg.valueInt], 0, true)) instanceof BasicEntityShip) {
                                ((BasicEntityMount)entity).host = (BasicEntityShip)ent;
                            }
                            if (msg.valueInt > 1) {
                                ((BasicEntityMount)entity).setStateEmotion(1, 1, false);
                            }
                        }
                    }
                    if (msg.valueInt1[msg.valueInt + 1] > 0) {
                        Entity ent = EntityHelper.getEntityByID(msg.valueInt1[msg.valueInt + 1], 0, true);
                        if (ent == null) return;
                        entity.startRiding(ent, true);
                        return;
                    }
                    entity.dismountRidingEntity();
                    return;
                }
                case 80: {
                    if (!(entity instanceof IShipProjectile)) return;
                    ((IShipProjectile)entity).setProjectileType(msg.valueInt);
                    return;
                }
                case 52: {
                    if (entity instanceof EntityLivingBase) {
                        entity.setPositionAndRotation(msg.valueDouble1[0], msg.valueDouble1[1], msg.valueDouble1[2], msg.valueFloat1[0], msg.valueFloat1[1]);
                        ((EntityLivingBase)entity).renderYawOffset = msg.valueFloat1[2];
                        ((EntityLivingBase)entity).rotationYawHead = msg.valueFloat1[3];
                        return;
                    }
                    entity.setPositionAndRotation(msg.valueDouble1[0], msg.valueDouble1[1], msg.valueDouble1[2], msg.valueFloat1[0], msg.valueFloat1[1]);
                    return;
                }
                case 53: {
                    if (entity instanceof EntityLivingBase) {
                        ((EntityLivingBase)entity).rotationYawHead = msg.valueFloat1[0];
                        entity.rotationYaw = msg.valueFloat1[1];
                        entity.rotationPitch = msg.valueFloat1[2];
                    } else {
                        entity.rotationYaw = msg.valueFloat1[0];
                        entity.rotationPitch = msg.valueFloat1[2];
                    }
                    if (entity.getRidingEntity() instanceof BasicEntityMount) {
                        ((BasicEntityMount)entity.getRidingEntity()).rotationYawHead = msg.valueFloat1[0];
                        entity.getRidingEntity().rotationYaw = msg.valueFloat1[1];
                        entity.getRidingEntity().rotationPitch = msg.valueFloat1[2];
                    }
                    if (entity.getPassengers().isEmpty()) return;
                    for (Entity rider : entity.getPassengers()) {
                        rider.rotationYaw = msg.valueFloat1[0];
                        rider.rotationPitch = msg.valueFloat1[2];
                        if (!(rider instanceof EntityLivingBase)) continue;
                        ((EntityLivingBase)rider).rotationYawHead = msg.valueFloat1[0];
                    }
                    return;
                }
                case 54: {
                    entity.setVelocity(msg.valueFloat1[0], msg.valueFloat1[1], msg.valueFloat1[2]);
                    return;
                }
                case 56: {
                    PacketHelper.setEntityByCustomData(entity, msg.valueFloat1);
                    return;
                }
                case 51: {
                    if (msg.valueInt1[2] == -1) {
                        entity = EntityHelper.getEntityByID(msg.valueInt1[0], 0, true);
                        if (!(entity instanceof IShipOwner)) return;
                        ((IShipOwner)entity).setPlayerUID(msg.valueInt1[3]);
                        return;
                    }
                    TileEntity tile = ClientProxy.getClientWorld().getTileEntity(new BlockPos(msg.valueInt1[0], msg.valueInt1[1], msg.valueInt1[2]));
                    if (!(tile instanceof IShipOwner)) return;
                    ((IShipOwner)tile).setPlayerUID(msg.valueInt1[3]);
                    return;
                }
                case 81: {
                    if (ConfigHandler.ringAbility != null && msg.valueInt1 != null) {
                        if (ConfigHandler.ringAbility.length != msg.valueInt1.length) {
                            ConfigHandler.ringAbility = new int[msg.valueInt1.length];
                        }
                    } else {
                        ConfigHandler.ringAbility = new int[msg.valueInt1.length];
                    }
                    System.arraycopy(msg.valueInt1, 0, ConfigHandler.ringAbility, 0, msg.valueInt1.length);
                    return;
                }
                case 11: {
                    ship = S2CEntitySync.getShipByEntity(entity);
                    if (ship == null) {
                        return;
                    }
                    ship.unitNames = msg.valueString1;
                    return;
                }
                case 7: {
                    ship = S2CEntitySync.getShipByEntity(entity);
                    if (ship == null) {
                        return;
                    }
                    ship.setBuffMap((HashMap)msg.valueMap1);
                    return;
                }
                case 55: {
                    Entity ent = EntityHelper.getEntityByID(msg.valueInt, 0, true);
                    if (ent == null || !(entity instanceof EntityShipFishingHook) || !(ent instanceof EntityLivingBase)) return;
                    ((EntityShipFishingHook)entity).host = (EntityLivingBase)ent;
                    break;
                }
                case 90: {
                    boolean show = msg.valueInt == 1;
                    capa = CapaTeitoku.getTeitokuCapability((EntityPlayer) entity);
                    ClientAccessoryData.setShow(capa.getPlayerUID(), show);
                    return;
                }
                default:
            }
            return;
        }
        LogHelper.debug("DEBUG: packet handler: S2CEntitySync: entity is null, type: " + msg.packetType + " eid: " + msg.entityID);
    }

    public static BasicEntityShip getShipByEntity(Entity target) {
        if (target instanceof EntityPlayer) {
            CapaTeitoku capa = CapaTeitoku.getTeitokuCapability((EntityPlayer)target);
            if (capa != null && capa.getMorphEntity() instanceof BasicEntityShip) {
                return (BasicEntityShip)capa.getMorphEntity();
            }
            return null;
        }
        return (BasicEntityShip)target;
    }

    public static class Handler
    implements IMessageHandler<S2CEntitySync, IMessage> {
        public IMessage onMessage(S2CEntitySync message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> S2CEntitySync.handle(message));
            return null;
        }
    }

    public static final class PID {
        public static final byte SyncShip_Riders = 4;
        public static final byte SyncEntity_Emo = 50;
        
        private PID() {}
    }
}
