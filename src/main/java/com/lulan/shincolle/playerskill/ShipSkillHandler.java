package com.lulan.shincolle.playerskill;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipCV;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.intermod.MetamorphHelper;
import com.lulan.shincolle.network.C2SInputPackets;
import com.lulan.shincolle.proxy.ClientProxy;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.utility.*;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;

import java.util.ArrayList;
import java.util.Arrays;

public class ShipSkillHandler {
    private ShipSkillHandler() {}

    public static int getShipSkillHostType(EntityPlayer player) {
        if (player.getRidingEntity() instanceof BasicEntityMount) {
            return 0;
        }
        if (!player.getPassengers().isEmpty() && player.getPassengers().get(0) instanceof BasicEntityShip) {
            return 2;
        }
        if (player.world.isRemote && ConfigHandler.enableMetamorphSkill) {
            return 1;
        }
        return -1;
    }

    public static void handleShipSkillKeys(int type) {
        switch (type) {
            case 0:
                handleSkillKeysMounts();
                break;
            case 1:
                handleSkillKeysMorph();
                break;
            case 2:
                handleSkillKeysRider();
                break;
            default:
        }
    }

    protected static void handleSkillKeysMounts() {
        EntityPlayer player = ClientProxy.getClientPlayer();
        if (!(player.getRidingEntity() instanceof BasicEntityMount)) return;
        BasicEntityMount mount = (BasicEntityMount) player.getRidingEntity();
        GameSettings keySet = ClientProxy.getGameSetting();
        if (ClientProxy.keyMountActionCD <= 0) {
            if (keySet.keyBindInventory.isPressed()) {
                ClientProxy.keyMountActionCD = 8;
                CommonProxy.channelI.sendToServer(new C2SInputPackets((byte) 1));
                return;
            }
            if (keySet.keyBindPickBlock.isPressed()) {
                ClientProxy.keyMountActionCD = 8;
                ClientProxy.isViewPlayer = !ClientProxy.isViewPlayer;
                return;
            }
        }

        int newKeys = getMoveKeys(keySet, mount.onGround || EntityHelper.checkEntityIsInLiquid(mount));

        mount.keyPressed = newKeys;
        if (newKeys > 0) {
            mount.keyTick = 10;
        }

        boolean stateChanged = newKeys != ClientProxy.rideKeys;
        boolean keepAlive = newKeys > 0 && mount.ticksExisted % 8 == 0;

        if (stateChanged || keepAlive) {
            ClientProxy.rideKeys = newKeys;
            CommonProxy.channelI.sendToServer(new C2SInputPackets((byte) 0, newKeys));
        }
        BasicEntityShip ship = (BasicEntityShip) mount.getHostEntity();
        if (ship == null) return;
        ArrayList<Entity> exlist = new ArrayList<>(Arrays.asList(player, mount, ship));
        handleGenericSkillKeys(ship, 4, exlist);
    }

    public static void handleSkillKeysMorph() {
        EntityPlayer player = ClientProxy.getClientPlayer();
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        if (capa == null || !(capa.getMorphEntity() instanceof BasicEntityShip) || !ClientProxy.showMorphSkills) {
            return;
        }
        BasicEntityShip ship = (BasicEntityShip) capa.getMorphEntity();
        ArrayList<Entity> exlist = new ArrayList<>(Arrays.asList(player, ship));
        handleGenericSkillKeys(ship, 5, exlist);
    }

    protected static void handleSkillKeysRider() {
        EntityPlayer player = ClientProxy.getClientPlayer();
        if (player.getPassengers().isEmpty() || !(player.getPassengers().get(0) instanceof BasicEntityShip)) {
            return;
        }
        BasicEntityShip ship = (BasicEntityShip) player.getPassengers().get(0);
        GameSettings keySet = ClientProxy.getGameSetting();
        if (ClientProxy.keyMountActionCD <= 0 && keySet.keyBindInventory.isPressed()) {
            ClientProxy.keyMountActionCD = 8;
            CommonProxy.channelI.sendToServer(new C2SInputPackets((byte) 1));
            return;
        }
        if (ship.getAttrs() == null) return;
        ArrayList<Entity> exlist = new ArrayList<>(Arrays.asList(player, ship, ship.getHostEntity()));
        handleGenericSkillKeys(ship, 4, exlist);
    }

    private static void handleGenericSkillKeys(BasicEntityShip ship, int maxKeys, ArrayList<Entity> excludeList) {
        if (ClientProxy.keyPlayerSkillCD > 0) return;
        GameSettings keySet = ClientProxy.getGameSetting();
        int skillKey = -1;
        for (int i = 0; i < maxKeys; i++) {
            if (keySet.keyBindsHotbar[i].isKeyDown()) {
                skillKey = i;
                break;
            }
        }
        if (skillKey < 0) return;
        float range = Math.max(ship.getAttrs().getAttackRange(), 2.0F);
        ClientProxy.keyPlayerSkillCD = 4;
        RayTraceResult hitObj = EntityHelper.getPlayerMouseOverEntity(range, 1.0F, excludeList);
        Entity target = null;
        BlockPos targetPos = null;
        if (hitObj != null && hitObj.typeOfHit == RayTraceResult.Type.ENTITY) {
            target = hitObj.entityHit;
            ParticleHelper.spawnAttackParticleAtEntity(target, 0.3, 5.0, 0.0, (byte) 2);
        } else {
            RayTraceResult blockHit = ship.getShipDepth() > 2.0 ? BlockHelper.getPlayerMouseOverBlockThroughWater(range, 1.0F) : BlockHelper.getPlayerMouseOverBlockOnWater(range, 1.0F);
            if (blockHit != null && blockHit.typeOfHit == RayTraceResult.Type.BLOCK) {
                targetPos = blockHit.getBlockPos();
                ParticleHelper.spawnAttackParticleAt(targetPos.getX() + 0.5, targetPos.getY(), targetPos.getZ() + 0.5, 0.3, 5.0, 0.0, (byte) 25);
            }
        }
        sendSkillPacket(skillKey, target, targetPos);
    }

    private static void sendSkillPacket(int skill, Entity target, BlockPos pos) {
        if (target != null) {
            if (skill != 1) {
                CommonProxy.channelI.sendToServer(new C2SInputPackets((byte) 12, skill, target.getEntityId(), -1, -1));
            } else {
                CommonProxy.channelI.sendToServer(new C2SInputPackets((byte) 12, 1, target.getEntityId(), -1, -1));
            }
        } else if (pos != null && skill == 1) {
            CommonProxy.channelI.sendToServer(new C2SInputPackets((byte) 12, 1, pos.getX(), pos.getY(), pos.getZ()));
        }
    }

    private static int getMoveKeys(GameSettings keySet, boolean canJump) {
        int keys = 0;
        if (keySet.keyBindForward.isKeyDown()) keys |= 1;
        if (keySet.keyBindBack.isKeyDown()) keys |= 2;
        if (keySet.keyBindLeft.isKeyDown()) keys |= 4;
        if (keySet.keyBindRight.isKeyDown()) keys |= 8;
        if (canJump && keySet.keyBindJump.isKeyDown()) keys |= 16;
        return keys;
    }

    public static void handlePlayerSkill(EntityPlayer player, int[] data) {
        if (player.getRidingEntity() instanceof BasicEntityMount) {
            BasicEntityMount mount = (BasicEntityMount) player.getRidingEntity();
            castPlayerSkill((BasicEntityShip) mount.getHostEntity(), player, data);
        } else if (!player.getPassengers().isEmpty() && player.getPassengers().get(0) instanceof BasicEntityShip) {
            castPlayerSkill((BasicEntityShip) player.getPassengers().get(0), player, data);
        } else if (CommonProxy.activeMetamorph && ConfigHandler.enableMetamorphSkill) {
            MetamorphHelper.handlePlayerSkillOfMorph(player, data);
        }
    }

    public static void castPlayerSkill(BasicEntityShip ship, EntityPlayer player, int[] data) {
        if (ship == null || !TeamHelper.checkSameOwner(player, ship)) return;
        int skillID = data[0];
        int stateTimerIdx;
        int stateFlagIdx;
        switch (skillID) {
            case 0: stateTimerIdx = 16; stateFlagIdx = 13; break;
            case 1: stateTimerIdx = 17; stateFlagIdx = 14; break;
            case 2: stateTimerIdx = 18; stateFlagIdx = 15; break;
            case 3: stateTimerIdx = 19; stateFlagIdx = 16; break;
            default: return;
        }
        if (!ship.getStateFlag(stateFlagIdx) || ship.getStateTimer(stateTimerIdx) > 0) return;
        float rangeSq = ship.getAttrs().getAttackRange() * ship.getAttrs().getAttackRange();
        Entity target = null;
        BlockPos targetPos = null;
        if (data[2] < 0) {
            Entity found = EntityHelper.getEntityByID(data[1], player.world.provider.getDimension(), false);
            if (found != null && ship.getDistanceSq(found) <= rangeSq) target = found;
        } else {
            BlockPos found = new BlockPos(data[1], data[2], data[3]);
            if (ship.getDistanceSqToCenter(found) <= rangeSq) targetPos = found;
        }
        if (target == null && targetPos == null) return;
        if (target != null && TeamHelper.checkSameOwner(ship, target)) return;
        switch (skillID) {
            case 0:
                if (target == null) break;
                ship.attackEntityWithAmmo(target);
                ship.setStateTimer(16, CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 1));
                ship.sendSyncPacketTimer(1);
                break;
            case 1:
                if (target != null) ship.attackEntityWithHeavyAmmo(target);
                else ship.attackEntityWithHeavyAmmo(targetPos);
                ship.setStateTimer(17, CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 2));
                ship.sendSyncPacketTimer(1);
                break;
            case 2:
                if (!(ship instanceof BasicEntityShipCV) || target == null) break;
                ((BasicEntityShipCV) ship).attackEntityWithAircraft(target);
                ship.setStateTimer(18, CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 3));
                ship.setStateTimer(19, CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 3));
                ship.sendSyncPacketTimer(1);
                break;
            case 3:
                if (!(ship instanceof BasicEntityShipCV) || target == null) break;
                ((BasicEntityShipCV) ship).attackEntityWithHeavyAircraft(target);
                ship.setStateTimer(18, CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 4));
                ship.setStateTimer(19, CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 4));
                ship.sendSyncPacketTimer(1);
                break;
            default:
        }
    }
}