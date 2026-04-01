package com.lulan.shincolle.reference;

public class Enums {

    public enum EnumEquipEffectSP {
        NONE,
        DRUM,
        DRUM_LIQUID,
        DRUM_EU,
        COMPASS,
        FLARE,
        SEARCHLIGHT
    }

    public enum EnumPathType {
        BLOCKED,
        OPEN,
        FLUID,
        OPENABLE,
        FENCE,
        LADDER
    }

    public enum EnumColors {
        WHITE(0xFFFFFF),
        YELLOW(0xFFFF00),
        ORANGE(16753920),
        RED_LIGHT(0xFF3333),
        GRAY_DARK(0x303030),
        BLACK(0),
        RED_DARK(0xAA0000),
        GRAY_LIGHT(0xAAAAAA),
        PINK(15515845),
        CYAN(65535),
        PURPLE_LIGHT(16581630),
        PURPLE(0x8000FF),
        GRAY_MIDDLE(0x404040),
        GRAY_DARK_HP(0xF5F5F5),
        YELLOW_DARK_HP(0xCCCC00),
        ORANGE_DARK_HP(16747520),
        RED_DARK_HP(0xC80000),
        GREEN(65344),
        GREEN_DARK(36352),
        BLUE(255),
        BLUE_LIGHT(0x7777FF),
        BLUE_LIGHT2(40703),
        BLUE_DARK(128);

        private final int colorValue;

        EnumColors(int value) {
            this.colorValue = value;
        }

        public int getValue() {
            return this.colorValue;
        }
    }

    public enum BodySide {
        LEFT,
        FRONT,
        RIGHT,
        BACK
    }

    public enum BodyHeight {
        TOP,
        HEAD,
        NECK,
        CHEST,
        BELLY,
        UBELLY,
        LEG
    }
}
