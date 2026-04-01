package com.lulan.shincolle.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes {
    public static final String MODID = "shincolle";

    private ModRecipes() {}

    public static void init() {
        ItemStack abyssiumBlock = new ItemStack(ModBlocks.BlockAbyssium);
        ItemStack abyssiumNugget = new ItemStack(ModItems.AbyssNugget, 1, 0);
        ItemStack abyssiumNugget4 = new ItemStack(ModItems.AbyssNugget, 4, 0);
        ItemStack abyssiumStack = new ItemStack(ModItems.AbyssMetal, 1, 0);
        ItemStack abyssiumStack9 = new ItemStack(ModItems.AbyssMetal, 9, 0);
        ItemStack ammo1 = new ItemStack(ModItems.Ammo, 1, 0);
        ItemStack ammo8 = new ItemStack(ModItems.Ammo, 8, 0);
        ItemStack ammo9 = new ItemStack(ModItems.Ammo, 9, 0);
        ItemStack ammo16 = new ItemStack(ModItems.Ammo, 16, 0);
        ItemStack ammo32 = new ItemStack(ModItems.Ammo, 32, 0);
        ItemStack ammo64 = new ItemStack(ModItems.Ammo, 64, 0);
        ItemStack ammoContainer = new ItemStack(ModItems.Ammo, 1, 1);
        ItemStack ammoHeavy1 = new ItemStack(ModItems.Ammo, 1, 2);
        ItemStack ammoHeavy2 = new ItemStack(ModItems.Ammo, 2, 2);
        ItemStack ammoHeavy4 = new ItemStack(ModItems.Ammo, 4, 2);
        ItemStack ammoHeavy8 = new ItemStack(ModItems.Ammo, 8, 2);
        ItemStack ammoHeavy9 = new ItemStack(ModItems.Ammo, 9, 2);
        ItemStack ammoHeavyContainer = new ItemStack(ModItems.Ammo, 1, 3);
        ItemStack blazepowderStack = new ItemStack(Items.BLAZE_POWDER);
        ItemStack bucketRepairStack = new ItemStack(ModItems.BucketRepair);
        ItemStack chair = new ItemStack(ModBlocks.BlockChair);
        ItemStack desk = new ItemStack(ModBlocks.BlockDesk);
        ItemStack deskBook = new ItemStack(ModItems.DeskItemBook);
        ItemStack deskRadar = new ItemStack(ModItems.DeskItemRadar);
        ItemStack grudeStack = new ItemStack(ModItems.Grudge);
        ItemStack grudeStack9 = new ItemStack(ModItems.Grudge, 9, 0);
        ItemStack grudeBlock = new ItemStack(ModBlocks.BlockGrudge);
        ItemStack grudeBlock2 = new ItemStack(ModBlocks.BlockGrudge, 2, 0);
        ItemStack grudeBlock9 = new ItemStack(ModBlocks.BlockGrudge, 9, 0);
        ItemStack grudeXPStack = new ItemStack(ModItems.Grudge, 1, 1);
        ItemStack grudeXPBlock = new ItemStack(ModBlocks.BlockGrudgeXP);
        ItemStack grudeHeavyBlock = new ItemStack(ModBlocks.BlockGrudgeHeavy);
        ItemStack grudeHeavyBlockDeco = new ItemStack(ModBlocks.BlockGrudgeHeavyDeco);
        ItemStack gunpowderStack = new ItemStack(Items.GUNPOWDER);
        ItemStack instantMat8 = new ItemStack(ModItems.InstantConMat, 8);
        ItemStack instantMat32 = new ItemStack(ModItems.InstantConMat, 64);
        ItemStack ironBlock = new ItemStack(Blocks.IRON_BLOCK);
        ItemStack kaitaiHammerNew = new ItemStack(ModItems.KaitaiHammer);
        ItemStack kaitaiHammerAll = new ItemStack(ModItems.KaitaiHammer, 1, Short.MAX_VALUE);
        ItemStack modernKit = new ItemStack(ModItems.ModernKit);
        ItemStack magma = new ItemStack(Blocks.MAGMA);
        ItemStack ownerPaper = new ItemStack(ModItems.OwnerPaper);
        ItemStack pointer = new ItemStack(ModItems.PointerItem);
        ItemStack polymetalNugget = new ItemStack(ModItems.AbyssNugget, 1, 1);
        ItemStack polymetalNugget9 = new ItemStack(ModItems.AbyssNugget, 9, 1);
        ItemStack polymetalStack = new ItemStack(ModItems.AbyssMetal, 1, 1);
        ItemStack polymetalStack4 = new ItemStack(ModItems.AbyssMetal, 4, 1);
        ItemStack polymetalStack5 = new ItemStack(ModItems.AbyssMetal, 5, 1);
        ItemStack polymetalStack9 = new ItemStack(ModItems.AbyssMetal, 9, 1);
        ItemStack polymetalBlock = new ItemStack(ModBlocks.BlockPolymetal);
        ItemStack polymetalGravel = new ItemStack(ModBlocks.BlockPolymetalGravel);
        ItemStack ring = new ItemStack(ModItems.MarriageRing);
        ItemStack repairGoddess = new ItemStack(ModItems.RepairGoddess, 1, 0);
        ItemStack shipEggS = new ItemStack(ModItems.ShipSpawnEgg, 1, 0);
        ItemStack shipEggL = new ItemStack(ModItems.ShipSpawnEgg, 1, 1);
        ItemStack smallshipyardStack = new ItemStack(ModBlocks.BlockSmallShipyard);
        ItemStack toyplane = new ItemStack(ModItems.ToyAirplane);
        ItemStack trainbook = new ItemStack(ModItems.TrainingBook);
        ItemStack wrench = new ItemStack(ModItems.TargetWrench);
        ItemStack volblock = new ItemStack(ModBlocks.BlockVolBlock);
        ItemStack volcore = new ItemStack(ModBlocks.BlockVolCore);
        ItemStack frame16 = new ItemStack(ModBlocks.BlockFrame, 16);
        ItemStack crane = new ItemStack(ModBlocks.BlockCrane);
        ItemStack waypoint = new ItemStack(ModBlocks.BlockWaypoint, 16);
        ItemStack ration0 = new ItemStack(ModItems.CombatRation, 1, 0);
        ItemStack ration1 = new ItemStack(ModItems.CombatRation, 1, 1);
        ItemStack ration2 = new ItemStack(ModItems.CombatRation, 1, 2);
        ItemStack ration3 = new ItemStack(ModItems.CombatRation, 1, 3);
        ItemStack ration4 = new ItemStack(ModItems.CombatRation, 1, 4);
        ItemStack ration5 = new ItemStack(ModItems.CombatRation, 1, 5);
        ItemStack shiptank0 = new ItemStack(ModItems.ShipTank, 1, 0);
        ItemStack shiptank1 = new ItemStack(ModItems.ShipTank, 1, 1);
        ItemStack shiptank2 = new ItemStack(ModItems.ShipTank, 1, 2);
        ItemStack shiptank3 = new ItemStack(ModItems.ShipTank, 1, 3);
        ItemStack recipepaper = new ItemStack(ModItems.RecipePaper);

        ShapelessOreRecipe recipeAbyssiumStack = new ShapelessOreRecipe(null, abyssiumStack, "ingotIron", grudeStack);
        recipeAbyssiumStack.setRegistryName(new ResourceLocation(MODID, "abyssium_stack"));
        ForgeRegistries.RECIPES.register(recipeAbyssiumStack);

        ShapelessOreRecipe recipeBucketRepair = new ShapelessOreRecipe(null, bucketRepairStack, new ItemStack(Items.LAVA_BUCKET), grudeStack);
        recipeBucketRepair.setRegistryName(new ResourceLocation(MODID, "bucket_repair"));
        ForgeRegistries.RECIPES.register(recipeBucketRepair);

        ShapelessOreRecipe recipeAmmo9 = new ShapelessOreRecipe(null, ammo9, ammoContainer);
        recipeAmmo9.setRegistryName(new ResourceLocation(MODID, "ammo9"));
        ForgeRegistries.RECIPES.register(recipeAmmo9);

        ShapelessOreRecipe recipeAmmoHeavy9 = new ShapelessOreRecipe(null, ammoHeavy9, ammoHeavyContainer);
        recipeAmmoHeavy9.setRegistryName(new ResourceLocation(MODID, "ammo_heavy9"));
        ForgeRegistries.RECIPES.register(recipeAmmoHeavy9);

        ShapelessOreRecipe recipeAbyssiumStack2 = new ShapelessOreRecipe(null, abyssiumStack, abyssiumNugget, abyssiumNugget, abyssiumNugget, abyssiumNugget);
        recipeAbyssiumStack2.setRegistryName(new ResourceLocation(MODID, "abyssium_stack2"));
        ForgeRegistries.RECIPES.register(recipeAbyssiumStack2);

        ShapelessOreRecipe recipeAbyssiumNugget4 = new ShapelessOreRecipe(null, abyssiumNugget4, abyssiumStack);
        recipeAbyssiumNugget4.setRegistryName(new ResourceLocation(MODID, "abyssium_nugget4"));
        ForgeRegistries.RECIPES.register(recipeAbyssiumNugget4);

        ShapelessOreRecipe recipeAbyssiumStack9 = new ShapelessOreRecipe(null, abyssiumStack9, abyssiumBlock);
        recipeAbyssiumStack9.setRegistryName(new ResourceLocation(MODID, "abyssium_stack9"));
        ForgeRegistries.RECIPES.register(recipeAbyssiumStack9);

        ShapelessOreRecipe recipeAbyssiumBlock = new ShapelessOreRecipe(null, abyssiumBlock, ironBlock, grudeBlock);
        recipeAbyssiumBlock.setRegistryName(new ResourceLocation(MODID, "abyssium_block_shapeless"));
        ForgeRegistries.RECIPES.register(recipeAbyssiumBlock);

        ShapelessOreRecipe recipeGrudeStack9 = new ShapelessOreRecipe(null, grudeStack9, grudeBlock);
        recipeGrudeStack9.setRegistryName(new ResourceLocation(MODID, "grude_stack9"));
        ForgeRegistries.RECIPES.register(recipeGrudeStack9);

        ShapelessOreRecipe recipeGrudeBlock2 = new ShapelessOreRecipe(null, grudeBlock2, grudeHeavyBlockDeco);
        recipeGrudeBlock2.setRegistryName(new ResourceLocation(MODID, "grude_block2"));
        ForgeRegistries.RECIPES.register(recipeGrudeBlock2);

        ShapelessOreRecipe recipeGrudeBlock9 = new ShapelessOreRecipe(null, grudeBlock9, grudeHeavyBlock);
        recipeGrudeBlock9.setRegistryName(new ResourceLocation(MODID, "grude_block9"));
        ForgeRegistries.RECIPES.register(recipeGrudeBlock9);

        ShapelessOreRecipe recipeGrudeHeavyBlockDeco = new ShapelessOreRecipe(null, grudeHeavyBlockDeco, grudeBlock, grudeBlock);
        recipeGrudeHeavyBlockDeco.setRegistryName(new ResourceLocation(MODID, "grude_heavy_block_deco"));
        ForgeRegistries.RECIPES.register(recipeGrudeHeavyBlockDeco);

        ShapelessOreRecipe recipePolymetalStack4 = new ShapelessOreRecipe(null, polymetalStack4, polymetalGravel);
        recipePolymetalStack4.setRegistryName(new ResourceLocation(MODID, "polymetal_stack4"));
        ForgeRegistries.RECIPES.register(recipePolymetalStack4);

        ShapelessOreRecipe recipePolymetalStack9 = new ShapelessOreRecipe(null, polymetalStack9, polymetalBlock);
        recipePolymetalStack9.setRegistryName(new ResourceLocation(MODID, "polymetal_stack9"));
        ForgeRegistries.RECIPES.register(recipePolymetalStack9);

        ShapelessOreRecipe recipePolymetalGravel = new ShapelessOreRecipe(null, polymetalGravel, polymetalStack, polymetalStack, polymetalStack, polymetalStack);
        recipePolymetalGravel.setRegistryName(new ResourceLocation(MODID, "polymetal_gravel"));
        ForgeRegistries.RECIPES.register(recipePolymetalGravel);

        ShapelessOreRecipe recipePolymetalStack5 = new ShapelessOreRecipe(null, polymetalStack5, toyplane);
        recipePolymetalStack5.setRegistryName(new ResourceLocation(MODID, "polymetal_stack5"));
        ForgeRegistries.RECIPES.register(recipePolymetalStack5);

        ShapelessOreRecipe recipePolymetalNugget9 = new ShapelessOreRecipe(null, polymetalNugget9, polymetalStack);
        recipePolymetalNugget9.setRegistryName(new ResourceLocation(MODID, "polymetal_nugget9"));
        ForgeRegistries.RECIPES.register(recipePolymetalNugget9);

        ShapelessOreRecipe recipeInstantMat8 = new ShapelessOreRecipe(null, instantMat8, kaitaiHammerAll, shipEggS);
        recipeInstantMat8.setRegistryName(new ResourceLocation(MODID, "instant_mat8"));
        ForgeRegistries.RECIPES.register(recipeInstantMat8);

        ShapelessOreRecipe recipeInstantMat32 = new ShapelessOreRecipe(null, instantMat32, kaitaiHammerAll, shipEggL);
        recipeInstantMat32.setRegistryName(new ResourceLocation(MODID, "instant_mat32"));
        ForgeRegistries.RECIPES.register(recipeInstantMat32);

        ShapelessOreRecipe recipeOwnerPaper = new ShapelessOreRecipe(null, ownerPaper, grudeStack, Items.PAPER);
        recipeOwnerPaper.setRegistryName(new ResourceLocation(MODID, "owner_paper"));
        ForgeRegistries.RECIPES.register(recipeOwnerPaper);

        ShapelessOreRecipe recipeWaypoint = new ShapelessOreRecipe(null, waypoint, grudeStack, Items.STICK);
        recipeWaypoint.setRegistryName(new ResourceLocation(MODID, "waypoint_shapeless"));
        ForgeRegistries.RECIPES.register(recipeWaypoint);

        ShapelessOreRecipe recipeRecipePaper = new ShapelessOreRecipe(null, recipepaper, grudeStack, Items.PAPER, "gemLapis");
        recipeRecipePaper.setRegistryName(new ResourceLocation(MODID, "recipe_paper"));
        ForgeRegistries.RECIPES.register(recipeRecipePaper);

        ShapelessOreRecipe recipeRation0 = new ShapelessOreRecipe(null, ration0, Items.BREAD, Items.GOLDEN_CARROT, grudeStack, "cookedRice");
        recipeRation0.setRegistryName(new ResourceLocation(MODID, "ration0_shapeless"));
        ForgeRegistries.RECIPES.register(recipeRation0);

        ShapelessOreRecipe recipeRation1 = new ShapelessOreRecipe(null, ration1, ration0, ModBlocks.BlockGrudge, ModBlocks.BlockPolymetalGravel);
        recipeRation1.setRegistryName(new ResourceLocation(MODID, "ration1"));
        ForgeRegistries.RECIPES.register(recipeRation1);

        ShapelessOreRecipe recipeRation2Beef = new ShapelessOreRecipe(null, ration2, Items.COOKED_BEEF, Items.GOLDEN_CARROT, grudeStack, "cookedRice");
        recipeRation2Beef.setRegistryName(new ResourceLocation(MODID, "ration2_beef_shapeless"));
        ForgeRegistries.RECIPES.register(recipeRation2Beef);

        ShapelessOreRecipe recipeRation2Chicken = new ShapelessOreRecipe(null, ration2, Items.COOKED_CHICKEN, Items.GOLDEN_CARROT, grudeStack, "cookedRice");
        recipeRation2Chicken.setRegistryName(new ResourceLocation(MODID, "ration2_chicken_shapeless"));
        ForgeRegistries.RECIPES.register(recipeRation2Chicken);

        ShapelessOreRecipe recipeRation2Fish = new ShapelessOreRecipe(null, ration2, Items.COOKED_FISH, Items.GOLDEN_CARROT, grudeStack, "cookedRice");
        recipeRation2Fish.setRegistryName(new ResourceLocation(MODID, "ration2_fish_shapeless"));
        ForgeRegistries.RECIPES.register(recipeRation2Fish);

        ShapelessOreRecipe recipeRation2Mutton = new ShapelessOreRecipe(null, ration2, Items.COOKED_MUTTON, Items.GOLDEN_CARROT, grudeStack, "cookedRice");
        recipeRation2Mutton.setRegistryName(new ResourceLocation(MODID, "ration2_mutton_shapeless"));
        ForgeRegistries.RECIPES.register(recipeRation2Mutton);

        ShapelessOreRecipe recipeRation2Pork = new ShapelessOreRecipe(null, ration2, Items.COOKED_PORKCHOP, Items.GOLDEN_CARROT, grudeStack, "cookedRice");
        recipeRation2Pork.setRegistryName(new ResourceLocation(MODID, "ration2_pork_shapeless"));
        ForgeRegistries.RECIPES.register(recipeRation2Pork);

        ShapelessOreRecipe recipeRation2Rabbit = new ShapelessOreRecipe(null, ration2, Items.COOKED_RABBIT, Items.GOLDEN_CARROT, grudeStack, "cookedRice");
        recipeRation2Rabbit.setRegistryName(new ResourceLocation(MODID, "ration2_rabbit_shapeless"));
        ForgeRegistries.RECIPES.register(recipeRation2Rabbit);

        ShapelessOreRecipe recipeRation3 = new ShapelessOreRecipe(null, ration3, ration2, ModBlocks.BlockGrudge, ModBlocks.BlockPolymetalGravel);
        recipeRation3.setRegistryName(new ResourceLocation(MODID, "ration3"));
        ForgeRegistries.RECIPES.register(recipeRation3);

        ShapelessOreRecipe recipeRation4 = new ShapelessOreRecipe(null, ration4, Items.SNOWBALL, Items.SNOWBALL, Items.SNOWBALL, Items.SNOWBALL, Items.MILK_BUCKET, ModItems.Grudge);
        recipeRation4.setRegistryName(new ResourceLocation(MODID, "ration4"));
        ForgeRegistries.RECIPES.register(recipeRation4);

        ShapelessOreRecipe recipeRation5 = new ShapelessOreRecipe(null, ration5, ration4, ModBlocks.BlockGrudge);
        recipeRation5.setRegistryName(new ResourceLocation(MODID, "ration5"));
        ForgeRegistries.RECIPES.register(recipeRation5);

        ShapelessOreRecipe recipeModernKit = new ShapelessOreRecipe(null, modernKit, kaitaiHammerAll, wrench, grudeXPBlock, grudeXPBlock, grudeXPBlock, grudeXPBlock);
        recipeModernKit.setRegistryName(new ResourceLocation(MODID, "modern_kit"));
        ForgeRegistries.RECIPES.register(recipeModernKit);

        ShapelessOreRecipe recipeTrainBook = new ShapelessOreRecipe(null, trainbook, kaitaiHammerAll, modernKit, Items.WRITABLE_BOOK, grudeXPBlock, grudeXPBlock, grudeXPBlock, grudeXPBlock);
        recipeTrainBook.setRegistryName(new ResourceLocation(MODID, "train_book"));
        ForgeRegistries.RECIPES.register(recipeTrainBook);

        ShapedOreRecipe recipeAmmo8Copper = new ShapedOreRecipe(null, ammo8, "iii", "igi", "ipi", 'i', "ingotCopper", 'g', grudeStack, 'p', gunpowderStack);
        recipeAmmo8Copper.setRegistryName(new ResourceLocation(MODID, "ammo8_copper"));
        ForgeRegistries.RECIPES.register(recipeAmmo8Copper);

        ShapedOreRecipe recipeAmmo8Tin = new ShapedOreRecipe(null, ammo8, "iii", "igi", "ipi", 'i', "ingotTin", 'g', grudeStack, 'p', gunpowderStack);
        recipeAmmo8Tin.setRegistryName(new ResourceLocation(MODID, "ammo8_tin"));
        ForgeRegistries.RECIPES.register(recipeAmmo8Tin);

        ShapedOreRecipe recipeAmmo16Iron = new ShapedOreRecipe(null, ammo16, "iii", "igi", "ipi", 'i', "ingotIron", 'g', grudeStack, 'p', gunpowderStack);
        recipeAmmo16Iron.setRegistryName(new ResourceLocation(MODID, "ammo16_iron"));
        ForgeRegistries.RECIPES.register(recipeAmmo16Iron);

        ShapedOreRecipe recipeAmmo16Lead = new ShapedOreRecipe(null, ammo16, "iii", "igi", "ipi", 'i', "ingotLead", 'g', grudeStack, 'p', gunpowderStack);
        recipeAmmo16Lead.setRegistryName(new ResourceLocation(MODID, "ammo16_lead"));
        ForgeRegistries.RECIPES.register(recipeAmmo16Lead);

        ShapedOreRecipe recipeAmmo8Bronze = new ShapedOreRecipe(null, ammo8, "iii", "igi", "ipi", 'i', "ingotBronze", 'g', grudeStack, 'p', gunpowderStack);
        recipeAmmo8Bronze.setRegistryName(new ResourceLocation(MODID, "ammo8_bronze"));
        ForgeRegistries.RECIPES.register(recipeAmmo8Bronze);

        ShapedOreRecipe recipeAmmo32Abyssium = new ShapedOreRecipe(null, ammo32, "iii", "igi", "ipi", 'i', abyssiumStack, 'g', grudeStack, 'p', gunpowderStack);
        recipeAmmo32Abyssium.setRegistryName(new ResourceLocation(MODID, "ammo32_abyssium"));
        ForgeRegistries.RECIPES.register(recipeAmmo32Abyssium);

        ShapedOreRecipe recipeAmmo32Gold = new ShapedOreRecipe(null, ammo32, "iii", "igi", "ipi", 'i', "ingotGold", 'g', grudeStack, 'p', gunpowderStack);
        recipeAmmo32Gold.setRegistryName(new ResourceLocation(MODID, "ammo32_gold"));
        ForgeRegistries.RECIPES.register(recipeAmmo32Gold);

        ShapedOreRecipe recipeAmmo32Steel = new ShapedOreRecipe(null, ammo32, "iii", "igi", "ipi", 'i', "ingotSteel", 'g', grudeStack, 'p', gunpowderStack);
        recipeAmmo32Steel.setRegistryName(new ResourceLocation(MODID, "ammo32_steel"));
        ForgeRegistries.RECIPES.register(recipeAmmo32Steel);

        ShapedOreRecipe recipeAmmo32Silver = new ShapedOreRecipe(null, ammo32, "iii", "igi", "ipi", 'i', "ingotSilver", 'g', grudeStack, 'p', gunpowderStack);
        recipeAmmo32Silver.setRegistryName(new ResourceLocation(MODID, "ammo32_silver"));
        ForgeRegistries.RECIPES.register(recipeAmmo32Silver);

        ShapedOreRecipe recipeAmmo64Diamond = new ShapedOreRecipe(null, ammo64, "iii", "igi", "ipi", 'i', "gemDiamond", 'g', grudeStack, 'p', gunpowderStack);
        recipeAmmo64Diamond.setRegistryName(new ResourceLocation(MODID, "ammo64_diamond"));
        ForgeRegistries.RECIPES.register(recipeAmmo64Diamond);

        ShapedOreRecipe recipeAmmo64Uranium = new ShapedOreRecipe(null, ammo64, "iii", "igi", "ipi", 'i', "ingotUranium", 'g', grudeStack, 'p', gunpowderStack);
        recipeAmmo64Uranium.setRegistryName(new ResourceLocation(MODID, "ammo64_uranium"));
        ForgeRegistries.RECIPES.register(recipeAmmo64Uranium);

        ShapedOreRecipe recipeAmmoHeavy1Copper = new ShapedOreRecipe(null, ammoHeavy1, "iii", "igi", "ipi", 'i', "ingotCopper", 'g', grudeStack, 'p', blazepowderStack);
        recipeAmmoHeavy1Copper.setRegistryName(new ResourceLocation(MODID, "ammo_heavy1_copper"));
        ForgeRegistries.RECIPES.register(recipeAmmoHeavy1Copper);

        ShapedOreRecipe recipeAmmoHeavy1Tin = new ShapedOreRecipe(null, ammoHeavy1, "iii", "igi", "ipi", 'i', "ingotTin", 'g', grudeStack, 'p', blazepowderStack);
        recipeAmmoHeavy1Tin.setRegistryName(new ResourceLocation(MODID, "ammo_heavy1_tin"));
        ForgeRegistries.RECIPES.register(recipeAmmoHeavy1Tin);

        ShapedOreRecipe recipeAmmoHeavy2Iron = new ShapedOreRecipe(null, ammoHeavy2, "iii", "igi", "ipi", 'i', "ingotIron", 'g', grudeStack, 'p', blazepowderStack);
        recipeAmmoHeavy2Iron.setRegistryName(new ResourceLocation(MODID, "ammo_heavy2_iron"));
        ForgeRegistries.RECIPES.register(recipeAmmoHeavy2Iron);

        ShapedOreRecipe recipeAmmoHeavy2Lead = new ShapedOreRecipe(null, ammoHeavy2, "iii", "igi", "ipi", 'i', "ingotLead", 'g', grudeStack, 'p', blazepowderStack);
        recipeAmmoHeavy2Lead.setRegistryName(new ResourceLocation(MODID, "ammo_heavy2_lead"));
        ForgeRegistries.RECIPES.register(recipeAmmoHeavy2Lead);

        ShapedOreRecipe recipeAmmoHeavy1Bronze = new ShapedOreRecipe(null, ammoHeavy1, "iii", "igi", "ipi", 'i', "ingotBronze", 'g', grudeStack, 'p', blazepowderStack);
        recipeAmmoHeavy1Bronze.setRegistryName(new ResourceLocation(MODID, "ammo_heavy1_bronze"));
        ForgeRegistries.RECIPES.register(recipeAmmoHeavy1Bronze);

        ShapedOreRecipe recipeAmmoHeavy4Abyssium = new ShapedOreRecipe(null, ammoHeavy4, "iii", "igi", "ipi", 'i', abyssiumStack, 'g', grudeStack, 'p', blazepowderStack);
        recipeAmmoHeavy4Abyssium.setRegistryName(new ResourceLocation(MODID, "ammo_heavy4_abyssium"));
        ForgeRegistries.RECIPES.register(recipeAmmoHeavy4Abyssium);

        ShapedOreRecipe recipeAmmoHeavy4Gold = new ShapedOreRecipe(null, ammoHeavy4, "iii", "igi", "ipi", 'i', "ingotGold", 'g', grudeStack, 'p', blazepowderStack);
        recipeAmmoHeavy4Gold.setRegistryName(new ResourceLocation(MODID, "ammo_heavy4_gold"));
        ForgeRegistries.RECIPES.register(recipeAmmoHeavy4Gold);

        ShapedOreRecipe recipeAmmoHeavy4Steel = new ShapedOreRecipe(null, ammoHeavy4, "iii", "igi", "ipi", 'i', "ingotSteel", 'g', grudeStack, 'p', blazepowderStack);
        recipeAmmoHeavy4Steel.setRegistryName(new ResourceLocation(MODID, "ammo_heavy4_steel"));
        ForgeRegistries.RECIPES.register(recipeAmmoHeavy4Steel);

        ShapedOreRecipe recipeAmmoHeavy4Silver = new ShapedOreRecipe(null, ammoHeavy4, "iii", "igi", "ipi", 'i', "ingotSilver", 'g', grudeStack, 'p', blazepowderStack);
        recipeAmmoHeavy4Silver.setRegistryName(new ResourceLocation(MODID, "ammo_heavy4_silver"));
        ForgeRegistries.RECIPES.register(recipeAmmoHeavy4Silver);

        ShapedOreRecipe recipeAmmoHeavy8Diamond = new ShapedOreRecipe(null, ammoHeavy8, "iii", "igi", "ipi", 'i', "gemDiamond", 'g', grudeStack, 'p', blazepowderStack);
        recipeAmmoHeavy8Diamond.setRegistryName(new ResourceLocation(MODID, "ammo_heavy8_diamond"));
        ForgeRegistries.RECIPES.register(recipeAmmoHeavy8Diamond);

        ShapedOreRecipe recipeAmmoHeavy8Uranium = new ShapedOreRecipe(null, ammoHeavy8, "iii", "igi", "ipi", 'i', "ingotUranium", 'g', grudeStack, 'p', blazepowderStack);
        recipeAmmoHeavy8Uranium.setRegistryName(new ResourceLocation(MODID, "ammo_heavy8_uranium"));
        ForgeRegistries.RECIPES.register(recipeAmmoHeavy8Uranium);

        ShapedOreRecipe recipeAmmoContainer = new ShapedOreRecipe(null, ammoContainer, "aaa", "aaa", "aaa", 'a', ammo1);
        recipeAmmoContainer.setRegistryName(new ResourceLocation(MODID, "ammo_container"));
        ForgeRegistries.RECIPES.register(recipeAmmoContainer);

        ShapedOreRecipe recipeAmmoHeavyContainer = new ShapedOreRecipe(null, ammoHeavyContainer, "aaa", "aaa", "aaa", 'a', ammoHeavy1);
        recipeAmmoHeavyContainer.setRegistryName(new ResourceLocation(MODID, "ammo_heavy_container"));
        ForgeRegistries.RECIPES.register(recipeAmmoHeavyContainer);

        ShapedOreRecipe recipeAbyssiumBlockShaped = new ShapedOreRecipe(null, abyssiumBlock, "aaa", "aaa", "aaa", 'a', abyssiumStack);
        recipeAbyssiumBlockShaped.setRegistryName(new ResourceLocation(MODID, "abyssium_block_shaped"));
        ForgeRegistries.RECIPES.register(recipeAbyssiumBlockShaped);

        ShapedOreRecipe recipeGrudeBlockShaped = new ShapedOreRecipe(null, grudeBlock, "aaa", "aaa", "aaa", 'a', grudeStack);
        recipeGrudeBlockShaped.setRegistryName(new ResourceLocation(MODID, "grude_block_shaped"));
        ForgeRegistries.RECIPES.register(recipeGrudeBlockShaped);

        ShapedOreRecipe recipeGrudeHeavyBlockShaped = new ShapedOreRecipe(null, grudeHeavyBlock, "aaa", "aaa", "aaa", 'a', grudeBlock);
        recipeGrudeHeavyBlockShaped.setRegistryName(new ResourceLocation(MODID, "grude_heavy_block_shaped"));
        ForgeRegistries.RECIPES.register(recipeGrudeHeavyBlockShaped);

        ShapedOreRecipe recipePolymetalBlockShaped = new ShapedOreRecipe(null, polymetalBlock, "aaa", "aaa", "aaa", 'a', polymetalStack);
        recipePolymetalBlockShaped.setRegistryName(new ResourceLocation(MODID, "polymetal_block_shaped"));
        ForgeRegistries.RECIPES.register(recipePolymetalBlockShaped);

        ShapedOreRecipe recipePolymetalStackShaped = new ShapedOreRecipe(null, polymetalStack, "aaa", "aaa", "aaa", 'a', polymetalNugget);
        recipePolymetalStackShaped.setRegistryName(new ResourceLocation(MODID, "polymetal_stack_shaped"));
        ForgeRegistries.RECIPES.register(recipePolymetalStackShaped);

        ShapedOreRecipe recipeChair = new ShapedOreRecipe(null, chair, "ggp", "ppp", "plp", 'g', grudeStack, 'l', Items.LEATHER, 'p', "plankWood");
        recipeChair.setRegistryName(new ResourceLocation(MODID, "chair"));
        ForgeRegistries.RECIPES.register(recipeChair);

        ShapedOreRecipe recipeDesk = new ShapedOreRecipe(null, desk, "abc", "ooo", "o o", 'a', deskRadar, 'b', deskBook, 'c', Blocks.WOOL, 'o', Blocks.OBSIDIAN);
        recipeDesk.setRegistryName(new ResourceLocation(MODID, "desk"));
        ForgeRegistries.RECIPES.register(recipeDesk);

        ShapedOreRecipe recipeDeskBook = new ShapedOreRecipe(null, deskBook, "ggg", "gbg", "ggg", 'g', grudeStack, 'b', Items.WRITABLE_BOOK);
        recipeDeskBook.setRegistryName(new ResourceLocation(MODID, "desk_book"));
        ForgeRegistries.RECIPES.register(recipeDeskBook);

        ShapedOreRecipe recipeDeskRadar = new ShapedOreRecipe(null, deskRadar, "ggg", "gbg", "ggg", 'g', grudeStack, 'b', Items.COMPASS);
        recipeDeskRadar.setRegistryName(new ResourceLocation(MODID, "desk_radar"));
        ForgeRegistries.RECIPES.register(recipeDeskRadar);

        ShapedOreRecipe recipeSmallShipyard = new ShapedOreRecipe(null, smallshipyardStack, "glg", "lol", "ooo", 'g', grudeStack, 'l', new ItemStack(Items.LAVA_BUCKET), 'o', Blocks.OBSIDIAN);
        recipeSmallShipyard.setRegistryName(new ResourceLocation(MODID, "small_shipyard"));
        ForgeRegistries.RECIPES.register(recipeSmallShipyard);

        ShapedOreRecipe recipeRing = new ShapedOreRecipe(null, ring, " s ", "a a", " a ", 's', Items.NETHER_STAR, 'a', abyssiumStack);
        recipeRing.setRegistryName(new ResourceLocation(MODID, "ring"));
        ForgeRegistries.RECIPES.register(recipeRing);

        ShapedOreRecipe recipeKaitaiHammer = new ShapedOreRecipe(null, kaitaiHammerNew, "aaa", "aaa", " s ", 's', Items.STICK, 'a', abyssiumStack);
        recipeKaitaiHammer.setRegistryName(new ResourceLocation(MODID, "kaitai_hammer"));
        ForgeRegistries.RECIPES.register(recipeKaitaiHammer);

        ShapedOreRecipe recipePointer = new ShapedOreRecipe(null, pointer, "  g", " p ", "p  ", 'g', grudeBlock, 'p', polymetalStack);
        recipePointer.setRegistryName(new ResourceLocation(MODID, "pointer"));
        ForgeRegistries.RECIPES.register(recipePointer);

        ShapedOreRecipe recipeToyPlane = new ShapedOreRecipe(null, toyplane, " a ", "aaa", " a ", 'a', polymetalStack);
        recipeToyPlane.setRegistryName(new ResourceLocation(MODID, "toy_plane"));
        ForgeRegistries.RECIPES.register(recipeToyPlane);

        ShapedOreRecipe recipeRepairGoddess1 = new ShapedOreRecipe(null, repairGoddess, "hgh", "gdg", "hgh", 'd', Blocks.DIAMOND_BLOCK, 'g', grudeBlock, 'h', grudeHeavyBlock);
        recipeRepairGoddess1.setRegistryName(new ResourceLocation(MODID, "repair_goddess_1"));
        ForgeRegistries.RECIPES.register(recipeRepairGoddess1);

        ShapedOreRecipe recipeRepairGoddess2 = new ShapedOreRecipe(null, repairGoddess, "ghg", "hdh", "ghg", 'd', Blocks.DIAMOND_BLOCK, 'g', grudeBlock, 'h', grudeHeavyBlock);
        recipeRepairGoddess2.setRegistryName(new ResourceLocation(MODID, "repair_goddess_2"));
        ForgeRegistries.RECIPES.register(recipeRepairGoddess2);

        ShapedOreRecipe recipeWrench = new ShapedOreRecipe(null, wrench, "a a", "aaa", " a ", 'a', abyssiumStack);
        recipeWrench.setRegistryName(new ResourceLocation(MODID, "wrench"));
        ForgeRegistries.RECIPES.register(recipeWrench);

        ShapedOreRecipe recipeVolBlock1 = new ShapedOreRecipe(null, volblock, "gog", "olo", "gog", 'g', magma, 'l', grudeBlock, 'o', Blocks.OBSIDIAN);
        recipeVolBlock1.setRegistryName(new ResourceLocation(MODID, "vol_block_1"));
        ForgeRegistries.RECIPES.register(recipeVolBlock1);

        ShapedOreRecipe recipeVolBlock2 = new ShapedOreRecipe(null, volblock, "gog", "olo", "gog", 'g', Blocks.OBSIDIAN, 'l', grudeBlock, 'o', magma);
        recipeVolBlock2.setRegistryName(new ResourceLocation(MODID, "vol_block_2"));
        ForgeRegistries.RECIPES.register(recipeVolBlock2);

        ShapedOreRecipe recipeVolCore1 = new ShapedOreRecipe(null, volcore, "gog", "olo", "gog", 'g', volblock, 'l', grudeHeavyBlock, 'o', Blocks.OBSIDIAN);
        recipeVolCore1.setRegistryName(new ResourceLocation(MODID, "vol_core_1"));
        ForgeRegistries.RECIPES.register(recipeVolCore1);

        ShapedOreRecipe recipeVolCore2 = new ShapedOreRecipe(null, volcore, "gog", "olo", "gog", 'g', Blocks.OBSIDIAN, 'l', grudeHeavyBlock, 'o', volblock);
        recipeVolCore2.setRegistryName(new ResourceLocation(MODID, "vol_core_2"));
        ForgeRegistries.RECIPES.register(recipeVolCore2);

        ShapedOreRecipe recipeFrame16 = new ShapedOreRecipe(null, frame16, "a a", " o ", "a a", 'o', Blocks.OBSIDIAN, 'a', abyssiumStack);
        recipeFrame16.setRegistryName(new ResourceLocation(MODID, "frame16"));
        ForgeRegistries.RECIPES.register(recipeFrame16);

        ShapedOreRecipe recipeCrane = new ShapedOreRecipe(null, crane, "aaa", "aga", "apa", 'a', abyssiumStack, 'p', Blocks.PISTON, 'g', grudeBlock);
        recipeCrane.setRegistryName(new ResourceLocation(MODID, "crane"));
        ForgeRegistries.RECIPES.register(recipeCrane);

        ShapedOreRecipe recipeRation0Wheat = new ShapedOreRecipe(null, ration0, "www", "bgc", "www", 'b', Items.BREAD, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', Items.WHEAT);
        recipeRation0Wheat.setRegistryName(new ResourceLocation(MODID, "ration0_wheat"));
        ForgeRegistries.RECIPES.register(recipeRation0Wheat);

        ShapedOreRecipe recipeRation2BeefWheat = new ShapedOreRecipe(null, ration2, "www", "bgc", "www", 'b', Items.COOKED_BEEF, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', Items.WHEAT);
        recipeRation2BeefWheat.setRegistryName(new ResourceLocation(MODID, "ration2_beef_wheat"));
        ForgeRegistries.RECIPES.register(recipeRation2BeefWheat);

        ShapedOreRecipe recipeRation2ChickenWheat = new ShapedOreRecipe(null, ration2, "www", "bgc", "www", 'b', Items.COOKED_CHICKEN, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', Items.WHEAT);
        recipeRation2ChickenWheat.setRegistryName(new ResourceLocation(MODID, "ration2_chicken_wheat"));
        ForgeRegistries.RECIPES.register(recipeRation2ChickenWheat);

        ShapedOreRecipe recipeRation2FishWheat = new ShapedOreRecipe(null, ration2, "www", "bgc", "www", 'b', Items.COOKED_FISH, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', Items.WHEAT);
        recipeRation2FishWheat.setRegistryName(new ResourceLocation(MODID, "ration2_fish_wheat"));
        ForgeRegistries.RECIPES.register(recipeRation2FishWheat);

        ShapedOreRecipe recipeRation2MuttonWheat = new ShapedOreRecipe(null, ration2, "www", "bgc", "www", 'b', Items.COOKED_MUTTON, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', Items.WHEAT);
        recipeRation2MuttonWheat.setRegistryName(new ResourceLocation(MODID, "ration2_mutton_wheat"));
        ForgeRegistries.RECIPES.register(recipeRation2MuttonWheat);

        ShapedOreRecipe recipeRation2PorkWheat = new ShapedOreRecipe(null, ration2, "www", "bgc", "www", 'b', Items.COOKED_PORKCHOP, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', Items.WHEAT);
        recipeRation2PorkWheat.setRegistryName(new ResourceLocation(MODID, "ration2_pork_wheat"));
        ForgeRegistries.RECIPES.register(recipeRation2PorkWheat);

        ShapedOreRecipe recipeRation2RabbitWheat = new ShapedOreRecipe(null, ration2, "www", "bgc", "www", 'b', Items.COOKED_RABBIT, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', Items.WHEAT);
        recipeRation2RabbitWheat.setRegistryName(new ResourceLocation(MODID, "ration2_rabbit_wheat"));
        ForgeRegistries.RECIPES.register(recipeRation2RabbitWheat);

        ShapedOreRecipe recipeRation0Flour = new ShapedOreRecipe(null, ration0, "www", "bgc", "www", 'b', Items.BREAD, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', "foodFlour");
        recipeRation0Flour.setRegistryName(new ResourceLocation(MODID, "ration0_flour"));
        ForgeRegistries.RECIPES.register(recipeRation0Flour);

        ShapedOreRecipe recipeRation2BeefFlour = new ShapedOreRecipe(null, ration2, "www", "bgc", "www", 'b', Items.COOKED_BEEF, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', "foodFlour");
        recipeRation2BeefFlour.setRegistryName(new ResourceLocation(MODID, "ration2_beef_flour"));
        ForgeRegistries.RECIPES.register(recipeRation2BeefFlour);

        ShapedOreRecipe recipeRation2ChickenFlour = new ShapedOreRecipe(null, ration2, "www", "bgc", "www", 'b', Items.COOKED_CHICKEN, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', "foodFlour");
        recipeRation2ChickenFlour.setRegistryName(new ResourceLocation(MODID, "ration2_chicken_flour"));
        ForgeRegistries.RECIPES.register(recipeRation2ChickenFlour);

        ShapedOreRecipe recipeRation2FishFlour = new ShapedOreRecipe(null, ration2, "www", "bgc", "www", 'b', Items.COOKED_FISH, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', "foodFlour");
        recipeRation2FishFlour.setRegistryName(new ResourceLocation(MODID, "ration2_fish_flour"));
        ForgeRegistries.RECIPES.register(recipeRation2FishFlour);

        ShapedOreRecipe recipeRation2MuttonFlour = new ShapedOreRecipe(null, ration2, "www", "bgc", "www", 'b', Items.COOKED_MUTTON, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', "foodFlour");
        recipeRation2MuttonFlour.setRegistryName(new ResourceLocation(MODID, "ration2_mutton_flour"));
        ForgeRegistries.RECIPES.register(recipeRation2MuttonFlour);

        ShapedOreRecipe recipeRation2PorkFlour = new ShapedOreRecipe(null, ration2, "www", "bgc", "www", 'b', Items.COOKED_PORKCHOP, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', "foodFlour");
        recipeRation2PorkFlour.setRegistryName(new ResourceLocation(MODID, "ration2_pork_flour"));
        ForgeRegistries.RECIPES.register(recipeRation2PorkFlour);

        ShapedOreRecipe recipeRation2RabbitFlour = new ShapedOreRecipe(null, ration2, "www", "bgc", "www", 'b', Items.COOKED_RABBIT, 'c', Items.GOLDEN_CARROT, 'g', grudeStack, 'w', "foodFlour");
        recipeRation2RabbitFlour.setRegistryName(new ResourceLocation(MODID, "ration2_rabbit_flour"));
        ForgeRegistries.RECIPES.register(recipeRation2RabbitFlour);

        ShapedOreRecipe recipeShipTank0 = new ShapedOreRecipe(null, shiptank0, "mtm", "mtm", "mtm", 'm', polymetalStack, 't', Items.CAULDRON);
        recipeShipTank0.setRegistryName(new ResourceLocation(MODID, "ship_tank0"));
        ForgeRegistries.RECIPES.register(recipeShipTank0);

        ShapedOreRecipe recipeShipTank1 = new ShapedOreRecipe(null, shiptank1, "mtm", "mtm", "mtm", 'm', Blocks.OBSIDIAN, 't', shiptank0);
        recipeShipTank1.setRegistryName(new ResourceLocation(MODID, "ship_tank1"));
        ForgeRegistries.RECIPES.register(recipeShipTank1);

        ShapedOreRecipe recipeShipTank2 = new ShapedOreRecipe(null, shiptank2, "mtm", "mtm", "mtm", 'm', abyssiumBlock, 't', shiptank1);
        recipeShipTank2.setRegistryName(new ResourceLocation(MODID, "ship_tank2"));
        ForgeRegistries.RECIPES.register(recipeShipTank2);

        ShapedOreRecipe recipeShipTank3 = new ShapedOreRecipe(null, shiptank3, "mtm", "mtm", "mtm", 'm', grudeHeavyBlock, 't', shiptank2);
        recipeShipTank3.setRegistryName(new ResourceLocation(MODID, "ship_tank3"));
        ForgeRegistries.RECIPES.register(recipeShipTank3);

        ShapedOreRecipe recipeGrudeXPStack = new ShapedOreRecipe(null, grudeXPStack, "xxx", "xgx", "xxx", 'g', grudeStack, 'x', Items.EXPERIENCE_BOTTLE);
        recipeGrudeXPStack.setRegistryName(new ResourceLocation(MODID, "grude_xp_stack"));
        ForgeRegistries.RECIPES.register(recipeGrudeXPStack);

        ShapedOreRecipe recipeGrudeXPBlock = new ShapedOreRecipe(null, grudeXPBlock, "xxx", "xxx", "xxx", 'x', grudeXPStack);
        recipeGrudeXPBlock.setRegistryName(new ResourceLocation(MODID, "grude_xp_block"));
        ForgeRegistries.RECIPES.register(recipeGrudeXPBlock);
    }
}

