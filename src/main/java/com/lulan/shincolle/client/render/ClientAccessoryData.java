package com.lulan.shincolle.client.render;

import com.lulan.shincolle.capability.CapaTeitoku;
import net.minecraft.entity.player.EntityPlayer;

import java.util.HashMap;
import java.util.Map;

public class ClientAccessoryData {
    private static final Map<Integer, Boolean> SHOW_MAP = new HashMap<>();

    public static void setShow(int entityId, boolean show) {
        if (show) {
            SHOW_MAP.put(entityId, true);
        } else {
            SHOW_MAP.remove(entityId);
        }
    }

    public static boolean shouldShow(EntityPlayer player) {
        CapaTeitoku capa = CapaTeitoku.getTeitokuCapability(player);
        return SHOW_MAP.containsKey(capa.getPlayerUID());
    }
}