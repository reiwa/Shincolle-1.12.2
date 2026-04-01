package com.lulan.shincolle.network;

import com.lulan.shincolle.entity.IShipMorph;
import com.lulan.shincolle.intermod.MetamorphHelper;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.PacketHelper;
import com.lulan.shincolle.utility.ParticleHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class S2CSpawnParticle
implements IMessage {
    private Entity entity;
    private int entityID;
    private int entityID2;
    private byte packetType;
    private byte particleType;
    private boolean setAtkTime;
    private int[] valueInt1;
    private float[] valueFloat1;

    public S2CSpawnParticle() {
    }

    public S2CSpawnParticle(Entity entity, int type, boolean setAtkTime) {
        this.entity = entity;
        this.packetType = 0;
        this.setAtkTime = setAtkTime;
        this.particleType = (byte)type;
        if (entity instanceof IShipMorph && ((IShipMorph)entity).getMorphHost() != null) {
            this.entity = ((IShipMorph)entity).getMorphHost();
        }
    }

    public S2CSpawnParticle(Entity entity, int type, double posX, double posY, double posZ, double lookX, double lookY, double lookZ, boolean setAtkTime) {
        this.entity = entity;
        this.packetType = 1;
        this.setAtkTime = setAtkTime;
        this.particleType = (byte)type;
        this.valueFloat1 = new float[6];
        this.valueFloat1[0] = (float)posX;
        this.valueFloat1[1] = (float)posY;
        this.valueFloat1[2] = (float)posZ;
        this.valueFloat1[3] = (float)lookX;
        this.valueFloat1[4] = (float)lookY;
        this.valueFloat1[5] = (float)lookZ;
        if (entity instanceof IShipMorph && ((IShipMorph)entity).getMorphHost() != null) {
            this.entity = ((IShipMorph)entity).getMorphHost();
        }
    }

    public S2CSpawnParticle(int type, double posX, double posY, double posZ, double lookX, double lookY, double lookZ) {
        this.packetType = (byte)2;
        this.particleType = (byte)type;
        this.valueFloat1 = new float[6];
        this.valueFloat1[0] = (float)posX;
        this.valueFloat1[1] = (float)posY;
        this.valueFloat1[2] = (float)posZ;
        this.valueFloat1[3] = (float)lookX;
        this.valueFloat1[4] = (float)lookY;
        this.valueFloat1[5] = (float)lookZ;
    }

    public S2CSpawnParticle(Entity entity, Entity target, double par1, double par2, double par3, int type, boolean setAtkTime) {
        this.packetType = (byte)3;
        this.setAtkTime = setAtkTime;
        this.particleType = (byte)type;
        this.entityID = entity.getEntityId();
        this.entityID2 = target.getEntityId();
        this.valueFloat1 = new float[3];
        this.valueFloat1[0] = (float)par1;
        this.valueFloat1[1] = (float)par2;
        this.valueFloat1[2] = (float)par3;
        if (entity instanceof IShipMorph && ((IShipMorph)entity).getMorphHost() != null) {
            this.entityID = ((IShipMorph)entity).getMorphHost().getEntityId();
        }
    }

    public S2CSpawnParticle(Entity entity, int type, double par1, double par2, double par3) {
        this.entity = entity;
        this.packetType = (byte)4;
        this.particleType = (byte)type;
        this.valueFloat1 = new float[3];
        this.valueFloat1[0] = (float)par1;
        this.valueFloat1[1] = (float)par2;
        this.valueFloat1[2] = (float)par3;
        if (entity instanceof IShipMorph && ((IShipMorph)entity).getMorphHost() != null) {
            this.entity = ((IShipMorph)entity).getMorphHost();
        }
    }

    public S2CSpawnParticle(int type, int[] data) {
        this.packetType = (byte)5;
        this.particleType = (byte)type;
        this.valueInt1 = data;
    }

    public void fromBytes(ByteBuf buf) {
        this.packetType = buf.readByte();
        switch (this.packetType) {
            case 0: {
                this.entityID = buf.readInt();
                this.particleType = buf.readByte();
                this.setAtkTime = buf.readBoolean();
                break;
            }
            case 1: {
                this.entityID = buf.readInt();
                this.particleType = buf.readByte();
                this.setAtkTime = buf.readBoolean();
                this.valueFloat1 = PacketHelper.readFloatArray(buf, 6);
                break;
            }
            case 2: {
                this.particleType = buf.readByte();
                this.valueFloat1 = PacketHelper.readFloatArray(buf, 6);
                break;
            }
            case 3: {
                this.particleType = buf.readByte();
                this.setAtkTime = buf.readBoolean();
                this.entityID = buf.readInt();
                this.entityID2 = buf.readInt();
                this.valueFloat1 = PacketHelper.readFloatArray(buf, 3);
                break;
            }
            case 4: {
                this.entityID = buf.readInt();
                this.particleType = buf.readByte();
                this.valueFloat1 = PacketHelper.readFloatArray(buf, 3);
                break;
            }
            case 5: {
                this.particleType = buf.readByte();
                int len = buf.readInt();
                this.valueInt1 = PacketHelper.readIntArray(buf, len);
                break;
            }
            default:
        }
    }

    public void toBytes(ByteBuf buf) {
        switch (this.packetType) {
            case 0: {
                if (this.entity == null) {
                    return;
                }
                buf.writeByte(0);
                buf.writeInt(this.entity.getEntityId());
                buf.writeByte(this.particleType);
                buf.writeBoolean(this.setAtkTime);
                break;
            }
            case 1: {
                if (this.entity == null) {
                    return;
                }
                buf.writeByte(1);
                buf.writeInt(this.entity.getEntityId());
                buf.writeByte(this.particleType);
                buf.writeBoolean(this.setAtkTime);
                buf.writeFloat(this.valueFloat1[0]);
                buf.writeFloat(this.valueFloat1[1]);
                buf.writeFloat(this.valueFloat1[2]);
                buf.writeFloat(this.valueFloat1[3]);
                buf.writeFloat(this.valueFloat1[4]);
                buf.writeFloat(this.valueFloat1[5]);
                break;
            }
            case 2: {
                buf.writeByte(2);
                buf.writeByte(this.particleType);
                buf.writeFloat(this.valueFloat1[0]);
                buf.writeFloat(this.valueFloat1[1]);
                buf.writeFloat(this.valueFloat1[2]);
                buf.writeFloat(this.valueFloat1[3]);
                buf.writeFloat(this.valueFloat1[4]);
                buf.writeFloat(this.valueFloat1[5]);
                break;
            }
            case 3: {
                buf.writeByte(3);
                buf.writeByte(this.particleType);
                buf.writeBoolean(this.setAtkTime);
                buf.writeInt(this.entityID);
                buf.writeInt(this.entityID2);
                buf.writeFloat(this.valueFloat1[0]);
                buf.writeFloat(this.valueFloat1[1]);
                buf.writeFloat(this.valueFloat1[2]);
                break;
            }
            case 4: {
                if (this.entity == null) {
                    return;
                }
                buf.writeByte(4);
                buf.writeInt(this.entity.getEntityId());
                buf.writeByte(this.particleType);
                buf.writeFloat(this.valueFloat1[0]);
                buf.writeFloat(this.valueFloat1[1]);
                buf.writeFloat(this.valueFloat1[2]);
                break;
            }
            case 5: {
                if (this.valueInt1 == null || this.valueInt1.length <= 0) {
                    return;
                }
                buf.writeByte(5);
                buf.writeByte(this.particleType);
                int len = this.valueInt1.length;
                buf.writeInt(len);
                for (int i = 0; i < len; ++i) {
                    buf.writeInt(this.valueInt1[i]);
                }
                break;
            }
            default:
        }
    }

    private static void handle(S2CSpawnParticle msg) {
        Entity ent;
        switch (msg.packetType) {
            case 0: {
                ent = MetamorphHelper.getMorphEntityByPlayerEID(msg.entityID, 0, true);
                ParticleHelper.spawnAttackParticle(ent, msg.particleType, msg.setAtkTime);
                break;
            }
            case 1: {
                ent = MetamorphHelper.getMorphEntityByPlayerEID(msg.entityID, 0, true);
                ParticleHelper.spawnAttackParticleCustomVector(ent, msg.valueFloat1[0], msg.valueFloat1[1], msg.valueFloat1[2], msg.valueFloat1[3], msg.valueFloat1[4], msg.valueFloat1[5], msg.particleType, msg.setAtkTime);
                break;
            }
            case 2: {
                ParticleHelper.spawnAttackParticleAt(msg.valueFloat1[0], msg.valueFloat1[1], msg.valueFloat1[2], msg.valueFloat1[3], msg.valueFloat1[4], msg.valueFloat1[5], msg.particleType);
                break;
            }
            case 3: {
                ent = MetamorphHelper.getMorphEntityByPlayerEID(msg.entityID, 0, true);
                ParticleHelper.spawnAttackParticleAtEntity(ent, EntityHelper.getEntityByID(msg.entityID2, 0, true), msg.valueFloat1[0], msg.valueFloat1[1], msg.valueFloat1[2], msg.particleType, msg.setAtkTime);
                break;
            }
            case 4: {
                ent = MetamorphHelper.getMorphEntityByPlayerEID(msg.entityID, 0, true);
                ParticleHelper.spawnAttackParticleAtEntity(ent, msg.valueFloat1[0], msg.valueFloat1[1], msg.valueFloat1[2], msg.particleType);
                break;
            }
            case 5: {
                if (msg.particleType == 0) {
                    int len = (msg.valueInt1.length - 1) / 3;
                    int cid = msg.valueInt1[0];
                    for (int i = 0; i < len; ++i) {
                        byte parType = i == cid ? (byte)32 : 33;
                        ParticleHelper.spawnAttackParticleAt(msg.valueInt1[i * 3 + 1] + 0.5, msg.valueInt1[i * 3 + 2] + 0.5, msg.valueInt1[i * 3 + 3] + 0.5, 0.0, 0.0, 0.0, parType);
                    }
                } else {
                    int len = (msg.valueInt1.length - 1) / 3;
                    int cid = msg.valueInt1[0];
                    for (int i = 0; i < len; ++i) {
                        byte parType = i == cid ? (byte)16 : 29;
                        ParticleHelper.spawnAttackParticleAt(msg.valueInt1[i * 3 + 1] + 0.5, msg.valueInt1[i * 3 + 2] + 0.5, msg.valueInt1[i * 3 + 3] + 0.5, 0.0, 0.0, 0.0, parType);
                    }
                }
                break;
            }
            default:
        }
    }

    public static class Handler
    implements IMessageHandler<S2CSpawnParticle, IMessage> {
        public IMessage onMessage(S2CSpawnParticle message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> S2CSpawnParticle.handle(message));
            return null;
        }
    }
}
