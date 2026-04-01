package com.lulan.shincolle.config;

import com.lulan.shincolle.utility.LogHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConfigSound extends BasicShipConfig {
    public static final Map<Integer, float[]> SOUNDRATE;

    static {
        SOUNDRATE = new HashMap<>();
    }

    public ConfigSound(File file) {
        super(file);
    }

    @Override
    protected void parse(ArrayList<String> lines) {
        if (lines != null && !lines.isEmpty()) {
            for (String str : lines) {
                if (BasicShipConfig.isCommentString(str)) continue;
                String cleanedStr = str.replaceAll("\\s", "");
                String[] strs = cleanedStr.split(",");
                if (strs.length != 10) continue;
                try {
                    int id = Integer.parseInt(strs[0]);
                    float[] rate = new float[9];
                    for (int i = 0; i < 9; ++i) {
                        rate[i] = Integer.parseInt(strs[i + 1]) * 0.01f;
                    }
                    SOUNDRATE.put(id, rate);
                } catch (NumberFormatException e) {
                    LogHelper.info("EXCEPTION : parse error at ConfigSound.cfg : " + cleanedStr + " " + e);
                }
            }
        }
    }

    @Override
    protected ArrayList<String> getDefaultContent() {
        ArrayList<String> strs = new ArrayList<>();
        strs.add("# Custom Sound Rate" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# format: ship_ID, idle, attack, hurt, dead, marry, knockback, item, feed, timekeep" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# for each value: 70 = 70% play custom sound and 30% play general sound" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add("# for any non-zero number, you must add a corresponding entry in sounds.json" + NEW_LINE);
        strs.add("# see CustomSoundReadme.txt in mod jar file" + NEW_LINE);
        strs.add("#" + NEW_LINE);
        strs.add(NEW_LINE);
        strs.add("54,25,0,25,0,50,0,50,0,0" + NEW_LINE);
        strs.add("56,50,50,50,100,0,0,50,0,0" + NEW_LINE);
        strs.add("60,25,50,0,0,0,0,0,0,0" + NEW_LINE);
        strs.add("62,0,35,0,0,0,0,0,0,0" + NEW_LINE);
        return strs;
    }
}
