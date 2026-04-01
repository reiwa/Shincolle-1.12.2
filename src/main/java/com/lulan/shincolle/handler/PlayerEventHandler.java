package com.lulan.shincolle.handler;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.network.S2CEntitySync;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.proxy.ServerProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.network.play.server.SPacketEntityEquipment;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Mod.EventBusSubscriber
public class PlayerEventHandler {
    private PlayerEventHandler() {}

    private static final Set<UUID> pendingPlayers = ConcurrentHashMap.newKeySet();

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        if (player != null && !player.world.isRemote) {
            ServerProxy.updatePlayerID(player);
            pendingPlayers.add(event.player.getUniqueID());
        }
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (pendingPlayers.isEmpty()) {
                return;
            }
            MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
            if (server == null) return;
            pendingPlayers.removeIf(uuid -> {
                EntityPlayerMP player = server.getPlayerList().getPlayerByUUID(uuid);
                executeDelayedLoginTasks(player);
                return true;
            });
        }
    }

    private static void executeDelayedLoginTasks(EntityPlayer player) {
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if(capa.getAppearance() != -1) {
            capa.setAppearance(0);
            CommonProxy.channelE.sendToAll(new S2CEntitySync(player, 0, (byte) 90));
        }
    }

    @SubscribeEvent
    public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        EntityPlayer player = event.player;

        if (player != null && !player.world.isRemote) {
            ServerProxy.updatePlayerID(player);
        }
    }

    @SubscribeEvent
    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        EntityPlayer player = event.player;
        if (player != null && !player.world.isRemote) {
            CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
            if (capa != null) {
                int pid = capa.getPlayerUID();
                if (pid > 0) {
                    ServerProxy.removePlayerWorldData(pid);
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (event.getItemStack().getItem() != Items.NAME_TAG && event.getItemStack().getItem() != Items.LEAD && getPointedEntity(event.getEntityPlayer().world, event.getEntityPlayer(), 5.0D) instanceof BasicEntityShip) {
            event.setResult(Event.Result.DENY);
            event.setCanceled(true);
            syncPlayerHand(event.getEntityPlayer(), event.getHand());
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getItemStack().getItem() != Items.NAME_TAG && event.getItemStack().getItem() != Items.LEAD && getPointedEntity(event.getEntityPlayer().world, event.getEntityPlayer(), 5.0D) instanceof BasicEntityShip) {
            event.setUseBlock(Event.Result.DENY);
            event.setUseItem(Event.Result.DENY);
            event.setCanceled(true);
            syncPlayerHand(event.getEntityPlayer(), event.getHand());
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            if (event.getItem().getItem() != Items.NAME_TAG && event.getItem().getItem() != Items.LEAD && getPointedEntity(player.world, player, 5.0D) instanceof BasicEntityShip) {
                event.setDuration(0);
                event.setCanceled(true);
                syncPlayerHand(player, player.getActiveHand());
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onFillBucket(FillBucketEvent event) {
        if (getPointedEntity(event.getEntityPlayer().world, event.getEntityPlayer(), 5.0D) instanceof BasicEntityShip) {
            event.setCanceled(true);
            syncPlayerHand(event.getEntityPlayer(), EnumHand.MAIN_HAND);
            syncPlayerHand(event.getEntityPlayer(), EnumHand.OFF_HAND);
        }
    }

    private static void syncPlayerHand(EntityPlayer player, EnumHand hand) {
        if (player instanceof EntityPlayerMP) {
            EntityPlayerMP playerMP = (EntityPlayerMP) player;
            EntityEquipmentSlot slot = (hand == EnumHand.MAIN_HAND)? EntityEquipmentSlot.MAINHAND : EntityEquipmentSlot.OFFHAND;
            playerMP.connection.sendPacket(new SPacketEntityEquipment(player.getEntityId(), slot, player.getHeldItem(hand)));
        }
    }

    @Nullable
    private static Entity getPointedEntity(World world, EntityPlayer player, double range) {
        Entity pointedEntity = null;
        Vec3d eyePosition = player.getPositionEyes(1.0F);
        Vec3d lookVector = player.getLook(1.0F);
        Vec3d reachVector = eyePosition.add(lookVector.scale(range));
        List<Entity> candidates = world.getEntitiesInAABBexcluding(
                player,
                player.getEntityBoundingBox().expand(lookVector.x * range, lookVector.y * range, lookVector.z * range).grow(1.0D),
                entity -> entity!= null && entity.canBeCollidedWith()
        );
        double closestDistanceSq = -1.0D;
        for (Entity entity : candidates) {
            AxisAlignedBB entityBB = entity.getEntityBoundingBox().grow(entity.getCollisionBorderSize());
            RayTraceResult intercept = entityBB.calculateIntercept(eyePosition, reachVector);
            if (intercept!= null) {
                double distSq = eyePosition.squareDistanceTo(intercept.hitVec);
                if (closestDistanceSq == -1.0D || distSq < closestDistanceSq) {
                    closestDistanceSq = distSq;
                    pointedEntity = entity;
                }
            }
        }
        return pointedEntity;
    }
}
