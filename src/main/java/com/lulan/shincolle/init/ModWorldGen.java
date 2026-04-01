package com.lulan.shincolle.init;

import com.lulan.shincolle.worldgen.ShinColleWorldGen;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModWorldGen {
    private ModWorldGen() {}

    public static final ShinColleWorldGen scWorldGen = new ShinColleWorldGen();

    public static void init() {
        GameRegistry.registerWorldGenerator(scWorldGen, 0);
    }
}
