package net.arjuna.mysticalSteamAge.items;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeBlocksRegister;
import net.arjuna.mysticalSteamAge.items.custom.*;
import net.arjuna.mysticalSteamAge.items.custom.armor.*;
import net.arjuna.mysticalSteamAge.items.custom.tools.DevilsIronAxe;
import net.arjuna.mysticalSteamAge.items.custom.tools.DevilsIronHoe;
import net.arjuna.mysticalSteamAge.items.custom.tools.DevilsIronPickaxe;
import net.arjuna.mysticalSteamAge.items.custom.tools.DevilsIronShovel;
import net.arjuna.mysticalSteamAge.items.custom.weapons.DevilsIronSword;
import net.arjuna.mysticalSteamAge.items.custom.weapons.DevilsIronWarAxe;
import net.arjuna.mysticalSteamAge.items.custom.weapons.WarAxe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Items.GLASS_BOTTLE;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class MysticalSteamAgeItemsRegister {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MysticalSteamAge.MOD_ID);
    public static final Item.Properties default_props = new Item.Properties();
    public static final Item.Properties food_props = new Item.Properties();

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    // Dust
    public static final RegistryObject<Item> brass_dust = ITEMS.register("brass_dust", () -> new Item(default_props));
    public static final RegistryObject<Item> bronze_dust = ITEMS.register("bronze_dust", () -> new Item(default_props));
    public static final RegistryObject<Item> devil_iron_dust = ITEMS.register("devil_iron_dust", () -> new Item(default_props));
    public static final RegistryObject<Item> salt_dust = ITEMS.register("salt_dust", () -> new Item(default_props));
    public static final RegistryObject<Item> tin_dust = ITEMS.register("tin_dust", () -> new Item(default_props));
    public static final RegistryObject<Item> zinc_dust = ITEMS.register("zinc_dust", () -> new Item(default_props));
    public static final RegistryObject<Item> sulphur_dust = ITEMS.register("sulphur_dust", () -> new Item(default_props));
    public static final RegistryObject<Item> copper_dust = ITEMS.register("copper_dust", () -> new Item(default_props));
    public static final RegistryObject<Item> iron_dust = ITEMS.register("iron_dust", () -> new Item(default_props));
    public static final RegistryObject<Item> gold_dust = ITEMS.register("gold_dust", () -> new Item(default_props));

    // Ingot
    public static final RegistryObject<Item> brass_ingot = ITEMS.register("brass_ingot", () -> new Item(default_props));
    public static final RegistryObject<Item> bronze_ingot = ITEMS.register("bronze_ingot", () -> new Item(default_props));
    public static final RegistryObject<Item> devil_iron_ingot = ITEMS.register("devil_iron_ingot", () -> new Item(default_props));
    public static final RegistryObject<Item> steel_ingot = ITEMS.register("steel_ingot", () -> new Item(default_props));
    public static final RegistryObject<Item> tin_ingot = ITEMS.register("tin_ingot", () -> new Item(default_props));
    public static final RegistryObject<Item> zinc_ingot = ITEMS.register("zinc_ingot", () -> new Item(default_props));

    // Raw Ore
    public static final RegistryObject<Item> raw_devil_iron = ITEMS.register("raw_devil_iron", () -> new Item(default_props));
    public static final RegistryObject<Item> raw_salt = ITEMS.register("raw_salt", () -> new Item(default_props));
    public static final RegistryObject<Item> raw_sulphur = ITEMS.register("raw_sulphur", () -> new Item(default_props));
    public static final RegistryObject<Item> raw_tin = ITEMS.register("raw_tin", () -> new Item(default_props));
    public static final RegistryObject<Item> raw_zinc = ITEMS.register("raw_zinc", () -> new Item(default_props));

    // Others
    public static final RegistryObject<Item> feather_herb_leaf = ITEMS.register("feather_herb_leaf", () -> new Item(default_props));
    public static final RegistryObject<Item> feather_herb_seed = ITEMS.register("feather_herb_seed", () -> new FeatherHerbSeed(MysticalSteamAgeBlocksRegister.feather_herb.get(), default_props));
    public static final RegistryObject<Item> feather_herb_potion = ITEMS.register("feather_herb_potion", () -> new Potions(0xffff00, default_props));

    public static final RegistryObject<Item> camas = ITEMS.register("camas", () -> new Camas(MysticalSteamAgeBlocksRegister.camas.get(), default_props));

    public static final RegistryObject<Item> big_glass_bottle = ITEMS.register("big_glass_bottle", () -> new EmptyPotion(default_props));
    public static final RegistryObject<Item> big_water_potion = ITEMS.register("big_water_potion", () -> new Potions(0x253B82, default_props));

    public static final RegistryObject<Item> blumento_love = ITEMS.register("blumento_love", () -> new Potions(0x8B4513, default_props));
    public static final RegistryObject<Item> roadie_love = ITEMS.register("roadie_love", () -> new Potions(0xff0000, default_props));

    public static final RegistryObject<Item> empty_beer_glass = ITEMS.register("empty_beer_glass", () -> new Item(default_props));
    public static final RegistryObject<Item> beer = ITEMS.register("beer", () -> new BeerItem(new Item.Properties()
            .craftRemainder(GLASS_BOTTLE).stacksTo(16).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3F)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 300, 0), 1.0F).build())));
    public static final RegistryObject<Item> bottle_milk = ITEMS.register("bottle_milk", () -> new MilkBottleItem(new Item.Properties()
            .craftRemainder(GLASS_BOTTLE).stacksTo(16)));
    public static final RegistryObject<Item> camas_paste = ITEMS.register("camas_paste", () -> new Item(default_props));
    public static final RegistryObject<Item> gold_nail = ITEMS.register("gold_nail", () -> new Item(default_props));
    public static final RegistryObject<Item> iron_nail = ITEMS.register("iron_nail", () -> new Item(default_props));
    public static final RegistryObject<Item> sand_mold = ITEMS.register("sand_mold", () -> new Item(default_props));

    // Food
    public static final RegistryObject<Item> cheese = ITEMS.register("cheese", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> cheese_bread = ITEMS.register("cheese_bread", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(10)
            .saturationMod(0.8F).build())));
    public static final RegistryObject<Item> raw_roadie_leg = ITEMS.register("raw_roadie_leg", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.3F).build())));
    public static final RegistryObject<Item> raw_roadie_meat = ITEMS.register("raw_roadie_meat", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(5)
            .saturationMod(0.3F).build())));
    public static final RegistryObject<Item> cooked_roadie_leg = ITEMS.register("cooked_roadie_leg", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(7)
            .saturationMod(0.8F).build())));
    public static final RegistryObject<Item> cooked_roadie_meat = ITEMS.register("cooked_roadie_meat", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(9)
            .saturationMod(0.8F).build())));
    public static final RegistryObject<Item> meal = ITEMS.register("meal", () -> new Item(default_props));
    public static final RegistryObject<Item> dough_bowl_bread = ITEMS.register("dough_bowl_bread", () -> new Item(default_props));
    public static final RegistryObject<Item> dough_bowl_potato_bread = ITEMS.register("dough_bowl_potato_bread", () -> new Item(default_props));
    public static final RegistryObject<Item> dough_bowl_feather_herb_bread = ITEMS.register("dough_bowl_feather_herb_bread", () -> new Item(default_props));
    public static final RegistryObject<Item> dough_bowl_pancake = ITEMS.register("dough_bowl_pancake", () -> new Item(default_props));
    public static final RegistryObject<Item> dough_bowl_waffle = ITEMS.register("dough_bowl_waffle", () -> new Item(default_props));
    public static final RegistryObject<Item> potato_bread = ITEMS.register("potato_bread", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(9)
            .saturationMod(0.8F).build())));
    public static final RegistryObject<Item> feather_herb_bread = ITEMS.register("feather_herb_bread", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(9)
            .saturationMod(0.8F).build())));
    public static final RegistryObject<Item> pancake = ITEMS.register("pancake", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).build())));
    public static final RegistryObject<Item> waffle = ITEMS.register("waffle", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(7).saturationMod(0.8F).build())));
    public static final RegistryObject<Item> mirror_egg = ITEMS.register("mirror_egg", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(3).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> ham = ITEMS.register("ham", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> ham_bread = ITEMS.register("ham_bread", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(10).saturationMod(0.8F).build())));
    public static final RegistryObject<Item> bao_bapfel = ITEMS.register("bao_bapfel", () -> new Item(food_props.food(new FoodProperties.Builder().nutrition(4).saturationMod(0.5F).build())));

    // Armor
    public static final RegistryObject<Item> roadie_iron_armor = ITEMS.register("roadie_iron_armor", () -> new RoadieArmorItem(5, "iron",
            new Item.Properties()));
    public static final RegistryObject<Item> roadie_gold_armor = ITEMS.register("roadie_gold_armor", () -> new RoadieArmorItem(7, "gold",
            new Item.Properties()));
    public static final RegistryObject<Item> roadie_diamond_armor = ITEMS.register("roadie_diamond_armor", () -> new RoadieArmorItem(11, "diamond",
            new Item.Properties()));
    public static final RegistryObject<Item> roadie_leather_armor = ITEMS.register("roadie_leather_armor", () -> new DyeableRoadieArmorItem(3, "leather",
            new Item.Properties()));

    public static final RegistryObject<Item> blue_hardened_leather_helmet = ITEMS.register("blue_hardened_leather_helmet", () ->
            new BlueHardenedLeatherArmor(CustomArmorMaterials.BLUE_HARDENED_LEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> blue_hardened_leather_chestplate = ITEMS.register("blue_hardened_leather_chestplate", () ->
            new BlueHardenedLeatherArmor(CustomArmorMaterials.BLUE_HARDENED_LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> blue_hardened_leather_leggings = ITEMS.register("blue_hardened_leather_leggings", () ->
            new BlueHardenedLeatherArmor(CustomArmorMaterials.BLUE_HARDENED_LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> blue_hardened_leather_boots = ITEMS.register("blue_hardened_leather_boots", () ->
            new BlueHardenedLeatherArmor(CustomArmorMaterials.BLUE_HARDENED_LEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> black_hardened_leather_helmet = ITEMS.register("black_hardened_leather_helmet", () ->
            new BlackHardenedLeatherArmor(CustomArmorMaterials.BLACK_HARDENED_LEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> black_hardened_leather_chestplate = ITEMS.register("black_hardened_leather_chestplate", () ->
            new BlackHardenedLeatherArmor(CustomArmorMaterials.BLACK_HARDENED_LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> black_hardened_leather_leggings = ITEMS.register("black_hardened_leather_leggings", () ->
            new BlackHardenedLeatherArmor(CustomArmorMaterials.BLACK_HARDENED_LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> black_hardened_leather_boots = ITEMS.register("black_hardened_leather_boots", () ->
            new BlackHardenedLeatherArmor(CustomArmorMaterials.BLACK_HARDENED_LEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> brown_hardened_leather_helmet = ITEMS.register("brown_hardened_leather_helmet", () ->
            new BrownHardenedLeatherArmor(CustomArmorMaterials.BROWN_HARDENED_LEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> brown_hardened_leather_chestplate = ITEMS.register("brown_hardened_leather_chestplate", () ->
            new BrownHardenedLeatherArmor(CustomArmorMaterials.BROWN_HARDENED_LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> brown_hardened_leather_leggings = ITEMS.register("brown_hardened_leather_leggings", () ->
            new BrownHardenedLeatherArmor(CustomArmorMaterials.BROWN_HARDENED_LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> brown_hardened_leather_boots = ITEMS.register("brown_hardened_leather_boots", () ->
            new BrownHardenedLeatherArmor(CustomArmorMaterials.BROWN_HARDENED_LEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> green_hardened_leather_helmet = ITEMS.register("green_hardened_leather_helmet", () ->
            new GreenHardenedLeatherArmor(CustomArmorMaterials.GREEN_HARDENED_LEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> green_hardened_leather_chestplate = ITEMS.register("green_hardened_leather_chestplate", () ->
            new GreenHardenedLeatherArmor(CustomArmorMaterials.GREEN_HARDENED_LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> green_hardened_leather_leggings = ITEMS.register("green_hardened_leather_leggings", () ->
            new GreenHardenedLeatherArmor(CustomArmorMaterials.GREEN_HARDENED_LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> green_hardened_leather_boots = ITEMS.register("green_hardened_leather_boots", () ->
            new GreenHardenedLeatherArmor(CustomArmorMaterials.GREEN_HARDENED_LEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> light_green_hardened_leather_helmet = ITEMS.register("light_green_hardened_leather_helmet", () ->
            new LightGreenHardenedLeatherArmor(CustomArmorMaterials.LIGHT_GREEN_HARDENED_LEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> light_green_hardened_leather_chestplate = ITEMS.register("light_green_hardened_leather_chestplate", () ->
            new LightGreenHardenedLeatherArmor(CustomArmorMaterials.LIGHT_GREEN_HARDENED_LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> light_green_hardened_leather_leggings = ITEMS.register("light_green_hardened_leather_leggings", () ->
            new LightGreenHardenedLeatherArmor(CustomArmorMaterials.LIGHT_GREEN_HARDENED_LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> light_green_hardened_leather_boots = ITEMS.register("light_green_hardened_leather_boots", () ->
            new LightGreenHardenedLeatherArmor(CustomArmorMaterials.LIGHT_GREEN_HARDENED_LEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> purple_hardened_leather_helmet = ITEMS.register("purple_hardened_leather_helmet", () ->
            new PurpleHardenedLeatherArmor(CustomArmorMaterials.PURPLE_HARDENED_LEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> purple_hardened_leather_chestplate = ITEMS.register("purple_hardened_leather_chestplate", () ->
            new PurpleHardenedLeatherArmor(CustomArmorMaterials.PURPLE_HARDENED_LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> purple_hardened_leather_leggings = ITEMS.register("purple_hardened_leather_leggings", () ->
            new PurpleHardenedLeatherArmor(CustomArmorMaterials.PURPLE_HARDENED_LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> purple_hardened_leather_boots = ITEMS.register("purple_hardened_leather_boots", () ->
            new PurpleHardenedLeatherArmor(CustomArmorMaterials.PURPLE_HARDENED_LEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> red_hardened_leather_helmet = ITEMS.register("red_hardened_leather_helmet", () ->
            new RedHardenedLeatherArmor(CustomArmorMaterials.RED_HARDENED_LEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> red_hardened_leather_chestplate = ITEMS.register("red_hardened_leather_chestplate", () ->
            new RedHardenedLeatherArmor(CustomArmorMaterials.RED_HARDENED_LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> red_hardened_leather_leggings = ITEMS.register("red_hardened_leather_leggings", () ->
            new RedHardenedLeatherArmor(CustomArmorMaterials.RED_HARDENED_LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> red_hardened_leather_boots = ITEMS.register("red_hardened_leather_boots", () ->
            new RedHardenedLeatherArmor(CustomArmorMaterials.RED_HARDENED_LEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> white_hardened_leather_helmet = ITEMS.register("white_hardened_leather_helmet", () ->
            new WhiteHardenedLeatherArmor(CustomArmorMaterials.WHITE_HARDENED_LEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> white_hardened_leather_chestplate = ITEMS.register("white_hardened_leather_chestplate", () ->
            new WhiteHardenedLeatherArmor(CustomArmorMaterials.WHITE_HARDENED_LEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> white_hardened_leather_leggings = ITEMS.register("white_hardened_leather_leggings", () ->
            new WhiteHardenedLeatherArmor(CustomArmorMaterials.WHITE_HARDENED_LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> white_hardened_leather_boots = ITEMS.register("white_hardened_leather_boots", () ->
            new WhiteHardenedLeatherArmor(CustomArmorMaterials.WHITE_HARDENED_LEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> devil_iron_helmet = ITEMS.register("devil_iron_helmet", () ->
            new DevilIronArmor(CustomArmorMaterials.DEVIL_IRON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> devil_iron_chestplate = ITEMS.register("devil_iron_chestplate", () ->
            new DevilIronArmor(CustomArmorMaterials.DEVIL_IRON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> devil_iron_leggings = ITEMS.register("devil_iron_leggings", () ->
            new DevilIronArmor(CustomArmorMaterials.DEVIL_IRON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> devil_iron_boots = ITEMS.register("devil_iron_boots", () ->
            new DevilIronArmor(CustomArmorMaterials.DEVIL_IRON, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Weapon & Tools
    public static final RegistryObject<Item> copper_axe = ITEMS.register("copper_axe", () -> new AxeItem(CustomTiers.COPPER, 6.0F, -3.1F,
            new Item.Properties()));
    public static final RegistryObject<Item> copper_hoe = ITEMS.register("copper_hoe", () -> new HoeItem(CustomTiers.COPPER, -2, -1.0F,
            new Item.Properties()));
    public static final RegistryObject<Item> copper_pickaxe = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(CustomTiers.COPPER, 1, -2.8F,
            new Item.Properties()));
    public static final RegistryObject<Item> copper_shovel = ITEMS.register("copper_shovel", () -> new ShovelItem(CustomTiers.COPPER, 1.5F, -3.0F,
            new Item.Properties()));
    public static final RegistryObject<Item> copper_sword = ITEMS.register("copper_sword", () -> new SwordItem(CustomTiers.COPPER, 3, -2.4F,
            new Item.Properties()));

    public static final RegistryObject<Item> devil_iron_axe = ITEMS.register("devil_iron_axe", () -> new DevilsIronAxe(CustomTiers.DEVIL_IRON, 6.0F, -3.1F,
            new Item.Properties()));
    public static final RegistryObject<Item> devil_iron_hoe = ITEMS.register("devil_iron_hoe", () -> new DevilsIronHoe(CustomTiers.DEVIL_IRON, -2, -1.0F,
            new Item.Properties()));
    public static final RegistryObject<Item> devil_iron_pickaxe = ITEMS.register("devil_iron_pickaxe", () -> new DevilsIronPickaxe(CustomTiers.DEVIL_IRON, 1,
            -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> devil_iron_shovel = ITEMS.register("devil_iron_shovel", () -> new DevilsIronShovel(CustomTiers.DEVIL_IRON, 1.5F,
            -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> devil_iron_sword = ITEMS.register("devil_iron_sword", () -> new DevilsIronSword(CustomTiers.DEVIL_IRON, 3, -2.4F,
            new Item.Properties()));

    public static final RegistryObject<Item> flint_axe = ITEMS.register("flint_axe", () -> new AxeItem(CustomTiers.FLINT, 7.0F, -3.2F,
            new Item.Properties()));
    public static final RegistryObject<Item> flint_hoe = ITEMS.register("flint_hoe", () -> new HoeItem(CustomTiers.FLINT, -2, -1.0F,
            new Item.Properties()));
    public static final RegistryObject<Item> flint_pickaxe = ITEMS.register("flint_pickaxe", () -> new PickaxeItem(CustomTiers.FLINT, 1, -2.8F,
            new Item.Properties()));
    public static final RegistryObject<Item> flint_shovel = ITEMS.register("flint_shovel", () -> new ShovelItem(CustomTiers.FLINT, 1.5F, -3.0F,
            new Item.Properties()));

    public static final RegistryObject<Item> netherrack_axe = ITEMS.register("netherrack_axe", () -> new AxeItem(CustomTiers.NETHERRACK, 7.0F, -3.2F,
            new Item.Properties()));
    public static final RegistryObject<Item> netherrack_hoe = ITEMS.register("netherrack_hoe", () -> new HoeItem(CustomTiers.NETHERRACK, -2, -1.0F,
            new Item.Properties()));
    public static final RegistryObject<Item> netherrack_pickaxe = ITEMS.register("netherrack_pickaxe", () -> new PickaxeItem(CustomTiers.NETHERRACK, 1, -2.8F,
            new Item.Properties()));
    public static final RegistryObject<Item> netherrack_shovel = ITEMS.register("netherrack_shovel", () -> new ShovelItem(CustomTiers.NETHERRACK, 1.5F, -3.0F,
            new Item.Properties()));
    public static final RegistryObject<Item> netherrack_sword = ITEMS.register("netherrack_sword", () -> new SwordItem(CustomTiers.NETHERRACK, 3, -2.4F,
            new Item.Properties()));

    public static final RegistryObject<Item> steel_axe = ITEMS.register("steel_axe", () -> new AxeItem(CustomTiers.STEEL, 5.0F, -3.0F,
            new Item.Properties()));
    public static final RegistryObject<Item> steel_hoe = ITEMS.register("steel_hoe", () -> new HoeItem(CustomTiers.STEEL, -3, 0.0F,
            new Item.Properties()));
    public static final RegistryObject<Item> steel_pickaxe = ITEMS.register("steel_pickaxe", () -> new PickaxeItem(CustomTiers.STEEL, 1, -2.8F,
            new Item.Properties()));
    public static final RegistryObject<Item> steel_shovel = ITEMS.register("steel_shovel", () -> new ShovelItem(CustomTiers.STEEL, 1.5F, -3.0F,
            new Item.Properties()));
    public static final RegistryObject<Item> steel_sword = ITEMS.register("steel_sword", () -> new SwordItem(CustomTiers.STEEL, 3, -2.4F,
            new Item.Properties()));

    public static final RegistryObject<Item> copper_war_axe = ITEMS.register("copper_war_axe", () -> new WarAxe(CustomTiers.COPPER, 7.0F, -2.1F,
            new Item.Properties(), 3));
    public static final RegistryObject<Item> devil_iron_war_axe = ITEMS.register("devil_iron_war_axe", () -> new DevilsIronWarAxe(CustomTiers.DEVIL_IRON, 7.0F,
            -2.1F, new Item.Properties(), 3));
    public static final RegistryObject<Item> diamond_war_axe = ITEMS.register("diamond_war_axe", () -> new WarAxe(Tiers.DIAMOND, 6.0F, -2.0F,
            new Item.Properties(), 4));
    public static final RegistryObject<Item> gold_war_axe = ITEMS.register("gold_war_axe", () -> new WarAxe(Tiers.GOLD, 7.0F, -2.0F,
            new Item.Properties(), 2));
    public static final RegistryObject<Item> iron_war_axe = ITEMS.register("iron_war_axe", () -> new WarAxe(Tiers.IRON, 7.0F, -2.1F,
            new Item.Properties(), 3));
    public static final RegistryObject<Item> netherite_war_axe = ITEMS.register("netherite_war_axe", () -> new WarAxe(Tiers.NETHERITE, 6.0F, -2.0F,
            new Item.Properties(), 5));
    public static final RegistryObject<Item> netherrack_war_axe = ITEMS.register("netherrack_war_axe", () -> new WarAxe(CustomTiers.NETHERRACK, 8.0F, -2.0F,
            new Item.Properties(), 2));
    public static final RegistryObject<Item> steel_war_axe = ITEMS.register("steel_war_axe", () -> new WarAxe(CustomTiers.STEEL, 6.0F, -2.0F,
            new Item.Properties(), 4));
    public static final RegistryObject<Item> stone_war_axe = ITEMS.register("stone_war_axe", () -> new WarAxe(Tiers.STONE, 8.0F, -2.2F,
            new Item.Properties(), 2));
    public static final RegistryObject<Item> wood_war_axe = ITEMS.register("wood_war_axe", () -> new WarAxe(Tiers.WOOD, 7.0F, -2.2F,
            new Item.Properties(), 1));

    // Leather
    public static final RegistryObject<Item> blumento_leather = ITEMS.register("blumento_leather", () -> new Item(default_props));

    public static final RegistryObject<Item> blue_hardened_leather = ITEMS.register("blue_hardened_leather", () -> new Item(default_props));
    public static final RegistryObject<Item> brown_hardened_leather = ITEMS.register("brown_hardened_leather", () -> new Item(default_props));
    public static final RegistryObject<Item> green_hardened_leather = ITEMS.register("green_hardened_leather", () -> new Item(default_props));
    public static final RegistryObject<Item> light_green_hardened_leather = ITEMS.register("light_green_hardened_leather", () -> new Item(default_props));
    public static final RegistryObject<Item> purple_hardened_leather = ITEMS.register("purple_hardened_leather", () -> new Item(default_props));
    public static final RegistryObject<Item> red_hardened_leather = ITEMS.register("red_hardened_leather", () -> new Item(default_props));
    public static final RegistryObject<Item> black_hardened_leather = ITEMS.register("black_hardened_leather", () -> new Item(default_props));
    public static final RegistryObject<Item> white_hardened_leather = ITEMS.register("white_hardened_leather", () -> new Item(default_props));

    // ItemTags
    public static final TagKey<Item> raw_devil_iron_tag = ItemTags.create(new ResourceLocation("forge","raw_materials/devil_iron"));
    public static final TagKey<Item> raw_salt_tag = ItemTags.create(new ResourceLocation("forge","raw_materials/salt"));
    public static final TagKey<Item> raw_sulphur_tag = ItemTags.create(new ResourceLocation("forge","raw_materials/sulphur"));
    public static final TagKey<Item> raw_tin_tag = ItemTags.create(new ResourceLocation("forge","raw_materials/tin"));
    public static final TagKey<Item> raw_zinc_tag = ItemTags.create(new ResourceLocation("forge","raw_materials/zinc"));
    public static final TagKey<Item> coal_tag = ItemTags.create(new ResourceLocation("forge","raw_materials/coal"));
    public static final TagKey<Item> char_coal_tag = ItemTags.create(new ResourceLocation("forge","raw_materials/coal_coal"));
    public static final TagKey<Item> brass_ingot_tag = ItemTags.create(new ResourceLocation("forge","ingots/brass"));
    public static final TagKey<Item> bronze_ingot_tag = ItemTags.create(new ResourceLocation("forge","ingots/bronze"));
    public static final TagKey<Item> devil_iron_ingot_tag = ItemTags.create(new ResourceLocation("forge","ingots/devil_iron"));
    public static final TagKey<Item> steel_ingot_tag = ItemTags.create(new ResourceLocation("forge","ingots/steel"));
    public static final TagKey<Item> tin_ingot_tag = ItemTags.create(new ResourceLocation("forge","ingots/tin"));
    public static final TagKey<Item> zinc_ingot_tag = ItemTags.create(new ResourceLocation("forge","ingots/zinc"));
    public static final TagKey<Item> brass_dust_tag = ItemTags.create(new ResourceLocation("forge","dusts/brass"));
    public static final TagKey<Item> bronze_dust_tag = ItemTags.create(new ResourceLocation("forge","dusts/bronze"));
    public static final TagKey<Item> devil_iron_dust_tag = ItemTags.create(new ResourceLocation("forge","dusts/devil_iron"));
    public static final TagKey<Item> salt_dust_tag = ItemTags.create(new ResourceLocation("forge","dusts/salt"));
    public static final TagKey<Item> tin_dust_tag = ItemTags.create(new ResourceLocation("forge","dusts/tin"));
    public static final TagKey<Item> zinc_dust_tag = ItemTags.create(new ResourceLocation("forge","dusts/zinc"));
    public static final TagKey<Item> sulphur_dust_tag = ItemTags.create(new ResourceLocation("forge","dusts/sulphur"));
    public static final TagKey<Item> copper_dust_tag = ItemTags.create(new ResourceLocation("forge","dusts/copper"));
    public static final TagKey<Item> iron_dust_tag = ItemTags.create(new ResourceLocation("forge","dusts/iron"));
    public static final TagKey<Item> gold_dust_tag = ItemTags.create(new ResourceLocation("forge","dusts/gold"));

    public static final TagKey<Item> baobab_planks_tag = ItemTags.create(new ResourceLocation("forge","planks/wooden"));

    public static final TagKey<Item> big_glass_bottle_tag = ItemTags.create(new ResourceLocation("forge","empty_bottles"));

    public static final TagKey<Item> ham_tag = ItemTags.create(new ResourceLocation(MysticalSteamAge.MOD_ID,"ham_meat"));
    public static final TagKey<Item> sand_mold_tag = ItemTags.create(new ResourceLocation(MysticalSteamAge.MOD_ID,"sand_mold"));
    public static final TagKey<Item> baobab_log_tag = ItemTags.create(new ResourceLocation(MysticalSteamAge.MOD_ID,"baobab_log"));
    public static final TagKey<Item> baobab_wood_tag = ItemTags.create(new ResourceLocation(MysticalSteamAge.MOD_ID,"baobab_wood"));


}
