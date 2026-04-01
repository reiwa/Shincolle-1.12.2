package com.lulan.shincolle.block;

import com.lulan.shincolle.creativetab.CreativeTabSC;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BasicBlock
extends Block
implements ICustomModels {
    protected BasicBlock() {
        this(Material.ROCK);
    }

    protected BasicBlock(Material material) {
        super(material);
        this.setCreativeTab(CreativeTabSC.SC_TAB);
    }

    protected BasicBlock(Material material, MapColor color) {
        super(material, color);
        this.setCreativeTab(CreativeTabSC.SC_TAB);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", "shincolle:", this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
}
