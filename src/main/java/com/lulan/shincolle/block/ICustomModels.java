package com.lulan.shincolle.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface ICustomModels {
    @SideOnly(value=Side.CLIENT)
    void initModel();
}
