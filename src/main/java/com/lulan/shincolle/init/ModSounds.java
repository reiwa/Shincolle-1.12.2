package com.lulan.shincolle.init;

import com.lulan.shincolle.config.ConfigSound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;

@Mod.EventBusSubscriber(modid = "shincolle")
public class ModSounds {
    public static HashMap<Integer, SoundEvent> CUSTOM_SOUND;
    public static SoundEvent SHIP_IDLE;
    public static SoundEvent SHIP_HURT;
    public static SoundEvent SHIP_DEATH;
    public static SoundEvent SHIP_FIRELIGHT;
    public static SoundEvent SHIP_EXPLODE;
    public static SoundEvent SHIP_FIREHEAVY;
    public static SoundEvent SHIP_HIT;
    public static SoundEvent SHIP_AIRCRAFT;
    public static SoundEvent SHIP_MACHINEGUN;
    public static SoundEvent SHIP_LASER;
    public static SoundEvent SHIP_MARRY;
    public static SoundEvent SHIP_TIME0;
    public static SoundEvent SHIP_TIME1;
    public static SoundEvent SHIP_TIME2;
    public static SoundEvent SHIP_TIME3;
    public static SoundEvent SHIP_TIME4;
    public static SoundEvent SHIP_TIME5;
    public static SoundEvent SHIP_TIME6;
    public static SoundEvent SHIP_TIME7;
    public static SoundEvent SHIP_TIME8;
    public static SoundEvent SHIP_TIME9;
    public static SoundEvent SHIP_TIME10;
    public static SoundEvent SHIP_TIME11;
    public static SoundEvent SHIP_TIME12;
    public static SoundEvent SHIP_TIME13;
    public static SoundEvent SHIP_TIME14;
    public static SoundEvent SHIP_TIME15;
    public static SoundEvent SHIP_TIME16;
    public static SoundEvent SHIP_TIME17;
    public static SoundEvent SHIP_TIME18;
    public static SoundEvent SHIP_TIME19;
    public static SoundEvent SHIP_TIME20;
    public static SoundEvent SHIP_TIME21;
    public static SoundEvent SHIP_TIME22;
    public static SoundEvent SHIP_TIME23;
    public static SoundEvent SHIP_AP_P1;
    public static SoundEvent SHIP_AP_P2;
    public static SoundEvent SHIP_AP_ATTACK;
    public static SoundEvent SHIP_GARURU;
    public static SoundEvent SHIP_YAMATO_READY;
    public static SoundEvent SHIP_YAMATO_SHOT;
    public static SoundEvent SHIP_KNOCKBACK;
    public static SoundEvent SHIP_ITEM;
    public static SoundEvent SHIP_LEVEL;
    public static SoundEvent SHIP_FEED;
    public static SoundEvent SHIP_BELL;
    public static SoundEvent SHIP_JET;
    public static SoundEvent SHIP_HITMETAL;

    private ModSounds() {}

    public static void init() {
        CUSTOM_SOUND = new HashMap<>();
        SHIP_IDLE = createSoundEvent("ship-idle");
        SHIP_HURT = createSoundEvent("ship-hurt");
        SHIP_DEATH = createSoundEvent("ship-death");
        SHIP_FIRELIGHT = createSoundEvent("ship-firelight");
        SHIP_EXPLODE = createSoundEvent("ship-explode");
        SHIP_FIREHEAVY = createSoundEvent("ship-fireheavy");
        SHIP_HIT = createSoundEvent("ship-hit");
        SHIP_AIRCRAFT = createSoundEvent("ship-aircraft");
        SHIP_MACHINEGUN = createSoundEvent("ship-machinegun");
        SHIP_LASER = createSoundEvent("ship-laser");
        SHIP_MARRY = createSoundEvent("ship-marry");
        SHIP_TIME0 = createSoundEvent("ship-time0");
        SHIP_TIME1 = createSoundEvent("ship-time1");
        SHIP_TIME2 = createSoundEvent("ship-time2");
        SHIP_TIME3 = createSoundEvent("ship-time3");
        SHIP_TIME4 = createSoundEvent("ship-time4");
        SHIP_TIME5 = createSoundEvent("ship-time5");
        SHIP_TIME6 = createSoundEvent("ship-time6");
        SHIP_TIME7 = createSoundEvent("ship-time7");
        SHIP_TIME8 = createSoundEvent("ship-time8");
        SHIP_TIME9 = createSoundEvent("ship-time9");
        SHIP_TIME10 = createSoundEvent("ship-time10");
        SHIP_TIME11 = createSoundEvent("ship-time11");
        SHIP_TIME12 = createSoundEvent("ship-time12");
        SHIP_TIME13 = createSoundEvent("ship-time13");
        SHIP_TIME14 = createSoundEvent("ship-time14");
        SHIP_TIME15 = createSoundEvent("ship-time15");
        SHIP_TIME16 = createSoundEvent("ship-time16");
        SHIP_TIME17 = createSoundEvent("ship-time17");
        SHIP_TIME18 = createSoundEvent("ship-time18");
        SHIP_TIME19 = createSoundEvent("ship-time19");
        SHIP_TIME20 = createSoundEvent("ship-time20");
        SHIP_TIME21 = createSoundEvent("ship-time21");
        SHIP_TIME22 = createSoundEvent("ship-time22");
        SHIP_TIME23 = createSoundEvent("ship-time23");
        SHIP_AP_P1 = createSoundEvent("ship-ap_phase1");
        SHIP_AP_P2 = createSoundEvent("ship-ap_phase2");
        SHIP_AP_ATTACK = createSoundEvent("ship-ap_attack");
        SHIP_GARURU = createSoundEvent("ship-garuru");
        SHIP_YAMATO_READY = createSoundEvent("ship-yamato_ready");
        SHIP_YAMATO_SHOT = createSoundEvent("ship-yamato_shot");
        SHIP_KNOCKBACK = createSoundEvent("ship-knockback");
        SHIP_ITEM = createSoundEvent("ship-item");
        SHIP_LEVEL = createSoundEvent("ship-levelup");
        SHIP_FEED = createSoundEvent("ship-feed");
        SHIP_BELL = createSoundEvent("ship-bell");
        SHIP_JET = createSoundEvent("ship-jet");
        SHIP_HITMETAL = createSoundEvent("ship-hitmetal");

        ConfigSound.SOUNDRATE.forEach((k, v) -> {
            if (k > 1 && v != null && v.length == 9) {
                for (int i = 0; i < 8; ++i) {
                    if (v[i] <= 0.0f) continue;
                    SoundEvent event = createSoundEvent(getCustomSoundString(k, i));
                    CUSTOM_SOUND.put(k * 100 + i, event);
                }
                if (v[8] > 0.0f) {
                    for (int j = 0; j < 24; ++j) {
                        SoundEvent event = createSoundEvent(getCustomSoundStringForTimekeeping(k, j));
                        CUSTOM_SOUND.put(k * 100 + 10 + j, event);
                    }
                }
            }
        });
    }

    private static SoundEvent createSoundEvent(String soundName) {
        ResourceLocation name = new ResourceLocation("shincolle", soundName);
        return new SoundEvent(name).setRegistryName(name);
    }

    private static String getCustomSoundStringForTimekeeping(int shipID, int type) {
        return "ship-time" + type + "-" + shipID;
    }

    private static String getCustomSoundString(int shipID, int type) {
        String str = "ship-";
        switch (type) {
            case 0: str += "idle"; break;
            case 1: str += "hit"; break;
            case 2: str += "hurt"; break;
            case 3: str += "death"; break;
            case 4: str += "marry"; break;
            case 5: str += "knockback"; break;
            case 6: str += "item"; break;
            case 7: str += "feed"; break;
            default:
        }
        str += "-" + shipID;
        return str;
    }

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().registerAll(
                SHIP_IDLE,
                SHIP_HURT,
                SHIP_DEATH,
                SHIP_FIRELIGHT,
                SHIP_EXPLODE,
                SHIP_FIREHEAVY,
                SHIP_HIT,
                SHIP_AIRCRAFT,
                SHIP_MACHINEGUN,
                SHIP_LASER,
                SHIP_MARRY,
                SHIP_TIME0,
                SHIP_TIME1,
                SHIP_TIME2,
                SHIP_TIME3,
                SHIP_TIME4,
                SHIP_TIME5,
                SHIP_TIME6,
                SHIP_TIME7,
                SHIP_TIME8,
                SHIP_TIME9,
                SHIP_TIME10,
                SHIP_TIME11,
                SHIP_TIME12,
                SHIP_TIME13,
                SHIP_TIME14,
                SHIP_TIME15,
                SHIP_TIME16,
                SHIP_TIME17,
                SHIP_TIME18,
                SHIP_TIME19,
                SHIP_TIME20,
                SHIP_TIME21,
                SHIP_TIME22,
                SHIP_TIME23,
                SHIP_AP_P1,
                SHIP_AP_P2,
                SHIP_AP_ATTACK,
                SHIP_GARURU,
                SHIP_YAMATO_READY,
                SHIP_YAMATO_SHOT,
                SHIP_KNOCKBACK,
                SHIP_ITEM,
                SHIP_LEVEL,
                SHIP_FEED,
                SHIP_BELL,
                SHIP_JET,
                SHIP_HITMETAL
        );
        CUSTOM_SOUND.values().forEach(event.getRegistry()::register);
    }
}

