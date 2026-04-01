package com.lulan.shincolle.config;

import com.lulan.shincolle.handler.ConfigHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

public class ConfigGui
extends GuiConfig {
    public ConfigGui(GuiScreen parent) {
        this(parent, ConfigGui.getAllCategoryList(), "shincolle", false, false, "NOW EDITING: shincolle.cfg");
    }

    public ConfigGui(GuiScreen parent, List<IConfigElement> configs, String modid, boolean worldRestart, boolean mcRestart, String title) {
        super(parent, configs, modid, worldRestart, mcRestart, title, "All changes are CLIENT side only, it DO NOT affect SERVER side config file!!");
    }

    public static List<IConfigElement> getAllCategoryList() {
        ArrayList<IConfigElement> cfgs = new ArrayList<>();
        cfgs.add(new ConfigElement(ConfigHandler.config.getCategory("general")));
        cfgs.add(new ConfigElement(ConfigHandler.config.getCategory("ship setting")));
        cfgs.add(new ConfigElement(ConfigHandler.config.getCategory("world gen")));
        cfgs.add(new ConfigElement(ConfigHandler.config.getCategory("inter-mod")));
        return cfgs;
    }
}
