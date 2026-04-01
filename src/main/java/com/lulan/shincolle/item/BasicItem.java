package com.lulan.shincolle.item;

import com.lulan.shincolle.block.ICustomModels;
import com.lulan.shincolle.creativetab.CreativeTabSC;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BasicItem
extends Item
implements ICustomModels {
    protected BasicItem() {
        this.setCreativeTab(CreativeTabSC.SC_TAB);
    }

    public int getTypes() {
        return 1;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (tab != this.getCreativeTab()) return;
        if (getTypes() > 1) {
            for (int i = 0; i < getTypes(); i++) {
                items.add(new ItemStack(this, 1, i));
            }
        } else {
            items.add(new ItemStack(this, 1, 0));
        }
    }
    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    public String getUnlocalizedName() {
        return String.format("item.%s%s", "shincolle:", this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    public String getUnlocalizedName(ItemStack itemstack) {
        int meta = itemstack.getItemDamage();
        if (meta > 0) {
            return String.format("item.%s%s", "shincolle:", this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()) + meta);
        }
        return String.format("item.%s%s", "shincolle:", this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void initModel() {
        if (this.getHasSubtypes()) {
            int i;
            ModelResourceLocation[] models = new ModelResourceLocation[this.getTypes()];
            for (i = 0; i < this.getTypes(); ++i) {
                models[i] = new ModelResourceLocation(this.getRegistryName() + String.valueOf(i), "inventory");
            }
            ModelBakery.registerItemVariants(this, models);
            for (i = 0; i < this.getTypes(); ++i) {
                ModelLoader.setCustomModelResourceLocation(this, i, models[i]);
            }
        } else {
            ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
        }
    }
}
