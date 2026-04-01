package com.lulan.shincolle.init;

import com.lulan.shincolle.block.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = ModBlocks.MODID)
public class ModBlocks {

    public static final String MODID = "shincolle";

    private static final List<Block> BLOCKS_TO_REGISTER = new ArrayList<>();
    private static final List<Item> ITEMS_TO_REGISTER = new ArrayList<>();

    public static final Block BlockAbyssium = register(new BlockAbyssium());
    public static final Block BlockCrane = register(new BlockCrane());
    public static final Block BlockChair = register(new BlockChair());
    public static final Block BlockDesk = register(new BlockDesk());
    public static final Block BlockFrame = register(new BlockFrame());
    public static final Block BlockGrudge = register(new BlockGrudge());
    public static final Block BlockGrudgeXP = register(new BlockGrudgeXP());
    public static final Block BlockGrudgeHeavy = register(new BlockGrudgeHeavy());
    public static final Block BlockGrudgeHeavyDeco = register(new BlockGrudgeHeavyDeco());
    public static final Block BlockLightAir = registerBlockOnly(new BlockLightAir());
    public static final Block BlockLightLiquid = registerBlockOnly(new BlockLightLiquid());
    public static final Block BlockNetherAbyss = register(new BlockNetherAbyss());
    public static final Block BlockPolymetal = register(new BlockPolymetal());
    public static final Block BlockPolymetalGravel = register(new BlockPolymetalGravel());
    public static final Block BlockPolymetalOre = register(new BlockPolymetalOre());
    public static final Block BlockSmallShipyard = register(new BlockSmallShipyard());
    public static final Block BlockVolBlock = register(new BlockVolBlock());
    public static final Block BlockVolCore = register(new BlockVolCore());
    public static final Block BlockWaypoint = register(new BlockWaypoint());

    private ModBlocks() {}

    private static <T extends Block> T register(T block) {
        BLOCKS_TO_REGISTER.add(block);
        ITEMS_TO_REGISTER.add(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        return block;
    }

    private static <T extends Block> T registerBlockOnly(T block) {
        BLOCKS_TO_REGISTER.add(block);
        return block;
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BLOCKS_TO_REGISTER.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ITEMS_TO_REGISTER.toArray(new Item[0]));
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event) {
        for (Item item : ITEMS_TO_REGISTER) {
            if (item instanceof ItemBlock && ((ItemBlock) item).getBlock() instanceof ICustomModels) {
                ((ICustomModels) ((ItemBlock) item).getBlock()).initModel();
            } else {
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
            }
        }
    }
}