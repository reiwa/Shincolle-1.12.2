package com.lulan.shincolle.init;

import com.lulan.shincolle.block.ICustomModels;
import com.lulan.shincolle.item.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = ModItems.MODID)
public class ModItems {

    public static final String MODID = "shincolle";

    private static final List<Item> ITEMS_TO_REGISTER = new ArrayList<>();

    public static final BasicItem ShipSpawnEgg = register(new ShipSpawnEgg());
    public static final BasicItem AbyssMetal = register(new AbyssMetal());
    public static final BasicItem AbyssNugget = register(new AbyssNugget());
    public static final BasicItem Ammo = register(new Ammo());
    public static final BasicItem Grudge = register(new Grudge());
    public static final BasicItem EquipAirplane = register(new EquipAirplane());
    public static final BasicItem EquipAmmo = register(new EquipAmmo());
    public static final BasicItem EquipArmor = register(new EquipArmor());
    public static final BasicItem EquipCannon = register(new EquipCannon());
    public static final BasicItem EquipCatapult = register(new EquipCatapult());
    public static final BasicItem EquipCompass = register(new EquipCompass());
    public static final BasicItem EquipDrum = register(new EquipDrum());
    public static final BasicItem EquipFlare = register(new EquipFlare());
    public static final BasicItem EquipMachinegun = register(new EquipMachinegun());
    public static final BasicItem EquipRadar = register(new EquipRadar());
    public static final BasicItem EquipSearchlight = register(new EquipSearchlight());
    public static final BasicItem EquipTorpedo = register(new EquipTorpedo());
    public static final BasicItem EquipTurbine = register(new EquipTurbine());
    public static final BasicItem BucketRepair = register(new BucketRepair());
    public static final BasicItem CombatRation = register(new CombatRation());
    public static final BasicItem DeskItemBook = register(new DeskItemBook());
    public static final BasicItem DeskItemRadar = register(new DeskItemRadar());
    public static final BasicItem InstantConMat = register(new InstantConMat());
    public static final BasicItem KaitaiHammer = register(new KaitaiHammer());
    public static final BasicItem MarriageRing = register(new MarriageRing());
    public static final BasicItem ModernKit = register(new ModernKit());
    public static final BasicItem OwnerPaper = register(new OwnerPaper());
    public static final BasicItem OPTool = register(new OPTool());
    public static final BasicItem PointerItem = register(new PointerItem());
    public static final BasicItem RecipePaper = register(new RecipePaper());
    public static final BasicItem RepairGoddess = register(new RepairGoddess());
    public static final BasicItem ShipTank = register(new ShipTank());
    public static final BasicItem TargetWrench = register(new TargetWrench());
    public static final BasicItem TrainingBook = register(new TrainingBook());
    public static final BasicItem ToyAirplane = register(new ToyAirplane());

    private ModItems() {}

    private static <T extends Item> T register(T item) {
        ITEMS_TO_REGISTER.add(item);
        return item;
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ITEMS_TO_REGISTER.toArray(new Item[0]));
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event) {
        for (Item item : ITEMS_TO_REGISTER) {
            if (item instanceof ICustomModels) {
                ((ICustomModels) item).initModel();
            } else {
                ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
            }
        }
    }
}