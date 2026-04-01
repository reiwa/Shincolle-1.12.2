package com.lulan.shincolle.network;

import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.utility.BlockHelper;
import com.lulan.shincolle.utility.CommandHelper;
import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.PacketHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class S2CReactPackets
implements IMessage {
    private byte packetType;
    private int[] valueInt;
    private int[] valueInt2;
    private boolean[] valueBoolean;
    private String[] valueStr;

    public S2CReactPackets() {
    }

    public S2CReactPackets(byte type, int ... parms) {
        this.packetType = type;
        this.valueInt = parms;
    }

    public void fromBytes(ByteBuf buf) {
        this.packetType = buf.readByte();
        switch (this.packetType) {
            case 0: 
            case 1: 
            case 2: 
            case 20: {
                try {
                    int length = buf.readInt();
                    if (length <= 0) break;
                    this.valueInt = PacketHelper.readIntArray(buf, length);
                }
                catch (Exception e) {
                    LogHelper.info("EXCEPTION: S2C input packet: get data fail: " + e);
                    e.printStackTrace();
                }
                break;
            }
            case 3: {
                this.valueInt = PacketHelper.readIntArray(buf, 3);
                if (this.valueInt[2] > 0) {
                    this.valueInt2 = new int[this.valueInt[2] * 8];
                    this.valueBoolean = new boolean[this.valueInt[2] * 2];
                    this.valueStr = new String[this.valueInt[2]];
                    for (int i = 0; i < this.valueInt[2]; ++i) {
                        for (int j = 0; j < 8; ++j) {
                            this.valueInt2[i * 8 + j] = buf.readInt();
                        }
                        for (int k = 0; k < 2; ++k) {
                            this.valueBoolean[i * 2 + k] = buf.readBoolean();
                        }
                        this.valueStr[i] = PacketHelper.readString(buf);
                    }
                    break;
                }
                this.valueInt2 = null;
                this.valueStr = null;
                break;
            }
            default:
        }
    }

    public void toBytes(ByteBuf buf) {
        buf.writeByte(this.packetType);
        switch (this.packetType) {
            case 0: 
            case 1: 
            case 2: 
            case 20: {
                if (this.valueInt != null) {
                    buf.writeInt(this.valueInt.length);
                    for (int i : this.valueInt) {
                        buf.writeInt(i);
                    }
                    break;
                }
                buf.writeInt(0);
                break;
            }
            case 3: {
                if (this.valueInt == null) break;
                if(this.valueInt[0] == 0){
                    CommandHelper.processSendShipList(buf, this.valueInt[1]);
                }
                break;
            }
            default:
        }
    }

    private static void handle(S2CReactPackets msg) {
        switch (msg.packetType) {
            case 0: {
                CommandHelper.processShipChangeOwner(msg.valueInt[0], msg.valueInt[1]);
                break;
            }
            case 1: {
                CommandHelper.processShowShipInfo(msg.valueInt[0]);
                break;
            }
            case 2: {
                CommandHelper.processSetShipAttrs(msg.valueInt);
                break;
            }
            case 3: {
                CommandHelper.processGetShipList(msg.valueInt, msg.valueInt2, msg.valueBoolean, msg.valueStr);
                break;
            }
            case 20: {
                BlockPos pos = new BlockPos(msg.valueInt[0], msg.valueInt[1], msg.valueInt[2]);
                float light = ClientProxy.getClientWorld().getLight(pos, true);
                if (light < 11.0f) {
                    BlockHelper.placeLightBlock(ClientProxy.getClientWorld(), pos);
                    break;
                }
                BlockHelper.updateNearbyLightBlock(ClientProxy.getClientWorld(), pos);
                break;
            }
            default:
        }
    }

    public static class Handler
    implements IMessageHandler<S2CReactPackets, IMessage> {
        public IMessage onMessage(S2CReactPackets message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> S2CReactPackets.handle(message));
            return null;
        }
    }
}
