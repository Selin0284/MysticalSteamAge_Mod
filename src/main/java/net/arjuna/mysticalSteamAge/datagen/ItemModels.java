package net.arjuna.mysticalSteamAge.datagen;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeBlocksRegister;
import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;
import java.util.Objects;

public class ItemModels extends ItemModelProvider {

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MysticalSteamAge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Baobab
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.baobab_stairs);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.baobab_slab);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.baobab_pressure_plate);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.baobab_fence_gate);
        fenceItem(MysticalSteamAgeBlocksRegister.baobab_fence, MysticalSteamAgeBlocksRegister.baobab_planks);
        buttonItem(MysticalSteamAgeBlocksRegister.baobab_button, MysticalSteamAgeBlocksRegister.baobab_planks);
        simpleBlockItem(MysticalSteamAgeBlocksRegister.baobab_door);
        trapdoorItem(MysticalSteamAgeBlocksRegister.baobab_trapdoor);

        // Marble
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.marble_stairs);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.marble_slab);
        wallItem(MysticalSteamAgeBlocksRegister.marble_wall, MysticalSteamAgeBlocksRegister.marble);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.marble_black_stairs);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.marble_black_slab);
        wallItem(MysticalSteamAgeBlocksRegister.marble_black_wall, MysticalSteamAgeBlocksRegister.marble_black);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.marble_bricks_stairs);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.marble_bricks_slab);
        wallItem(MysticalSteamAgeBlocksRegister.marble_bricks_wall, MysticalSteamAgeBlocksRegister.marble_brick);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.marble_black_bricks_stairs);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.marble_black_bricks_slab);
        wallItem(MysticalSteamAgeBlocksRegister.marble_black_bricks_wall, MysticalSteamAgeBlocksRegister.marble_black_brick);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.polished_marble_stairs);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.polished_marble_slab);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.polished_marble_black_stairs);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.polished_marble_black_slab);
        // Lamps
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.acacia_lamp_item.getId()).getPath(), modLoc("block/acacia_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.andesite_lamp_item.getId()).getPath(), modLoc("block/andesite_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.birch_lamp_item.getId()).getPath(), modLoc("block/birch_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.cobblestone_lamp_item.getId()).getPath(), modLoc("block/cobblestone_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.dark_oak_lamp_item.getId()).getPath(), modLoc("block/dark_oak_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.deepslate_lamp_item.getId()).getPath(), modLoc("block/deepslate_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.diorite_lamp_item.getId()).getPath(), modLoc("block/diorite_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.granite_lamp_item.getId()).getPath(), modLoc("block/granite_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.jungle_lamp_item.getId()).getPath(), modLoc("block/jungle_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.marble_black_lamp_item.getId()).getPath(), modLoc("block/marble_black_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.marble_lamp_item.getId()).getPath(), modLoc("block/marble_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.oak_lamp_item.getId()).getPath(), modLoc("block/oak_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.sand_stone_lamp_item.getId()).getPath(), modLoc("block/sand_stone_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.spruce_lamp_item.getId()).getPath(), modLoc("block/spruce_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.baobab_lamp_item.getId()).getPath(), modLoc("block/baobab_lamp"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.iron_lamp_item.getId()).getPath(), modLoc("block/iron_lamp"));
        // Wardrobe
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.acacia_wardrobe_item.getId()).getPath(), modLoc("block/acacia_wardrobe"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.birch_wardrobe_item.getId()).getPath(), modLoc("block/birch_wardrobe"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.dark_oak_wardrobe_item.getId()).getPath(), modLoc("block/dark_oak_wardrobe"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.jungle_wardrobe_item.getId()).getPath(), modLoc("block/jungle_wardrobe"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.oak_wardrobe_item.getId()).getPath(), modLoc("block/oak_wardrobe"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.spruce_wardrobe_item.getId()).getPath(), modLoc("block/spruce_wardrobe"));
        withExistingParent(Objects.requireNonNull(MysticalSteamAgeBlocksRegister.baobab_wardrobe_item.getId()).getPath(), modLoc("block/baobab_wardrobe"));
        // Studded Item
        simpleBlockItem(MysticalSteamAgeBlocksRegister.studded_wooden_door_1);
        simpleBlockItem(MysticalSteamAgeBlocksRegister.studded_wooden_door_2);
        simpleBlockItem(MysticalSteamAgeBlocksRegister.studded_wooden_door_3);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.acacia_studded_pressure_plate);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.baobab_studded_pressure_plate);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.birch_studded_pressure_plate);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.dark_oak_studded_pressure_plate);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.jungle_studded_pressure_plate);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.oak_studded_pressure_plate);
        evenSimplerBlockItem(MysticalSteamAgeBlocksRegister.spruce_studded_pressure_plate);
        // Food
        simpleItem(MysticalSteamAgeItemsRegister.beer);
        simpleItem(MysticalSteamAgeItemsRegister.bottle_milk);
        simpleItem(MysticalSteamAgeItemsRegister.camas);
        simpleItem(MysticalSteamAgeItemsRegister.camas_paste);
        simpleItem(MysticalSteamAgeItemsRegister.cheese);
        simpleItem(MysticalSteamAgeItemsRegister.cheese_bread);
        simpleItem(MysticalSteamAgeItemsRegister.cooked_roadie_leg);
        simpleItem(MysticalSteamAgeItemsRegister.cooked_roadie_meat);
        simpleItem(MysticalSteamAgeItemsRegister.ham);
        simpleItem(MysticalSteamAgeItemsRegister.ham_bread);
        simpleItem(MysticalSteamAgeItemsRegister.meal);
        simpleItem(MysticalSteamAgeItemsRegister.mirror_egg);
        simpleItem(MysticalSteamAgeItemsRegister.pancake);
        simpleItem(MysticalSteamAgeItemsRegister.waffle);
        simpleItem(MysticalSteamAgeItemsRegister.potato_bread);
        simpleItem(MysticalSteamAgeItemsRegister.bao_bapfel);

        simpleItem(MysticalSteamAgeItemsRegister.big_glass_bottle);
        simpleItem(MysticalSteamAgeItemsRegister.empty_beer_glass);

        // Normal Items
        simpleItem(MysticalSteamAgeItemsRegister.brass_dust);
        simpleItem(MysticalSteamAgeItemsRegister.bronze_dust);
        simpleItem(MysticalSteamAgeItemsRegister.devil_iron_dust);
        simpleItem(MysticalSteamAgeItemsRegister.salt_dust);
        simpleItem(MysticalSteamAgeItemsRegister.tin_dust);
        simpleItem(MysticalSteamAgeItemsRegister.zinc_dust);
        simpleItem(MysticalSteamAgeItemsRegister.sulphur_dust);
        simpleItem(MysticalSteamAgeItemsRegister.copper_dust);
        simpleItem(MysticalSteamAgeItemsRegister.iron_dust);
        simpleItem(MysticalSteamAgeItemsRegister.gold_dust);

        simpleItem(MysticalSteamAgeItemsRegister.brass_ingot);
        simpleItem(MysticalSteamAgeItemsRegister.bronze_ingot);
        simpleItem(MysticalSteamAgeItemsRegister.devil_iron_ingot);
        simpleItem(MysticalSteamAgeItemsRegister.steel_ingot);
        simpleItem(MysticalSteamAgeItemsRegister.tin_ingot);
        simpleItem(MysticalSteamAgeItemsRegister.zinc_ingot);

        simpleItem(MysticalSteamAgeItemsRegister.raw_devil_iron);
        simpleItem(MysticalSteamAgeItemsRegister.raw_salt);
        simpleItem(MysticalSteamAgeItemsRegister.raw_sulphur);
        simpleItem(MysticalSteamAgeItemsRegister.raw_tin);
        simpleItem(MysticalSteamAgeItemsRegister.raw_zinc);

        simpleItem(MysticalSteamAgeItemsRegister.gold_nail);
        simpleItem(MysticalSteamAgeItemsRegister.iron_nail);
        simpleItem(MysticalSteamAgeItemsRegister.sand_mold);

        simpleItem(MysticalSteamAgeItemsRegister.raw_roadie_leg);
        simpleItem(MysticalSteamAgeItemsRegister.raw_roadie_meat);

        // Roadie Armor
        simpleItem(MysticalSteamAgeItemsRegister.roadie_leather_armor);
        simpleItem(MysticalSteamAgeItemsRegister.roadie_iron_armor);
        simpleItem(MysticalSteamAgeItemsRegister.roadie_gold_armor);
        simpleItem(MysticalSteamAgeItemsRegister.roadie_diamond_armor);

        // Leather
        simpleItem(MysticalSteamAgeItemsRegister.blumento_leather);
        simpleItem(MysticalSteamAgeItemsRegister.black_hardened_leather);
        simpleItem(MysticalSteamAgeItemsRegister.blue_hardened_leather);
        simpleItem(MysticalSteamAgeItemsRegister.brown_hardened_leather);
        simpleItem(MysticalSteamAgeItemsRegister.green_hardened_leather);
        simpleItem(MysticalSteamAgeItemsRegister.light_green_hardened_leather);
        simpleItem(MysticalSteamAgeItemsRegister.purple_hardened_leather);
        simpleItem(MysticalSteamAgeItemsRegister.red_hardened_leather);
        simpleItem(MysticalSteamAgeItemsRegister.white_hardened_leather);

        // Leather Armor
        trimmedArmorItem(MysticalSteamAgeItemsRegister.black_hardened_leather_helmet);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.black_hardened_leather_chestplate);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.black_hardened_leather_leggings);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.black_hardened_leather_boots);

        trimmedArmorItem(MysticalSteamAgeItemsRegister.blue_hardened_leather_helmet);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.blue_hardened_leather_chestplate);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.blue_hardened_leather_leggings);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.blue_hardened_leather_boots);

        trimmedArmorItem(MysticalSteamAgeItemsRegister.brown_hardened_leather_helmet);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.brown_hardened_leather_chestplate);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.brown_hardened_leather_leggings);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.brown_hardened_leather_boots);

        trimmedArmorItem(MysticalSteamAgeItemsRegister.green_hardened_leather_helmet);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.green_hardened_leather_chestplate);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.green_hardened_leather_leggings);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.green_hardened_leather_boots);

        trimmedArmorItem(MysticalSteamAgeItemsRegister.light_green_hardened_leather_helmet);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.light_green_hardened_leather_chestplate);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.light_green_hardened_leather_leggings);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.light_green_hardened_leather_boots);

        trimmedArmorItem(MysticalSteamAgeItemsRegister.purple_hardened_leather_helmet);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.purple_hardened_leather_chestplate);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.purple_hardened_leather_leggings);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.purple_hardened_leather_boots);

        trimmedArmorItem(MysticalSteamAgeItemsRegister.red_hardened_leather_helmet);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.red_hardened_leather_chestplate);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.red_hardened_leather_leggings);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.red_hardened_leather_boots);

        trimmedArmorItem(MysticalSteamAgeItemsRegister.white_hardened_leather_helmet);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.white_hardened_leather_chestplate);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.white_hardened_leather_leggings);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.white_hardened_leather_boots);

        // Devil Iron Armor
        trimmedArmorItem(MysticalSteamAgeItemsRegister.devil_iron_helmet);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.devil_iron_chestplate);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.devil_iron_leggings);
        trimmedArmorItem(MysticalSteamAgeItemsRegister.devil_iron_boots);

        // Weapons & Tools
        handheldItem(MysticalSteamAgeItemsRegister.copper_axe);
        handheldItem(MysticalSteamAgeItemsRegister.copper_hoe);
        handheldItem(MysticalSteamAgeItemsRegister.copper_sword);
        handheldItem(MysticalSteamAgeItemsRegister.copper_shovel);
        handheldItem(MysticalSteamAgeItemsRegister.copper_pickaxe);
        handheldItem(MysticalSteamAgeItemsRegister.copper_war_axe);

        handheldItem(MysticalSteamAgeItemsRegister.devil_iron_axe);
        handheldItem(MysticalSteamAgeItemsRegister.devil_iron_hoe);
        handheldItem(MysticalSteamAgeItemsRegister.devil_iron_sword);
        handheldItem(MysticalSteamAgeItemsRegister.devil_iron_shovel);
        handheldItem(MysticalSteamAgeItemsRegister.devil_iron_pickaxe);
        handheldItem(MysticalSteamAgeItemsRegister.devil_iron_war_axe);

        handheldItem(MysticalSteamAgeItemsRegister.flint_axe);
        handheldItem(MysticalSteamAgeItemsRegister.flint_hoe);
        handheldItem(MysticalSteamAgeItemsRegister.flint_shovel);
        handheldItem(MysticalSteamAgeItemsRegister.flint_pickaxe);

        handheldItem(MysticalSteamAgeItemsRegister.netherrack_axe);
        handheldItem(MysticalSteamAgeItemsRegister.netherrack_hoe);
        handheldItem(MysticalSteamAgeItemsRegister.netherrack_sword);
        handheldItem(MysticalSteamAgeItemsRegister.netherrack_shovel);
        handheldItem(MysticalSteamAgeItemsRegister.netherrack_pickaxe);
        handheldItem(MysticalSteamAgeItemsRegister.netherrack_war_axe);

        handheldItem(MysticalSteamAgeItemsRegister.steel_axe);
        handheldItem(MysticalSteamAgeItemsRegister.steel_hoe);
        handheldItem(MysticalSteamAgeItemsRegister.steel_sword);
        handheldItem(MysticalSteamAgeItemsRegister.steel_shovel);
        handheldItem(MysticalSteamAgeItemsRegister.steel_pickaxe);
        handheldItem(MysticalSteamAgeItemsRegister.steel_war_axe);

        handheldItem(MysticalSteamAgeItemsRegister.diamond_war_axe);
        handheldItem(MysticalSteamAgeItemsRegister.gold_war_axe);
        handheldItem(MysticalSteamAgeItemsRegister.iron_war_axe);
        handheldItem(MysticalSteamAgeItemsRegister.netherite_war_axe);
        handheldItem(MysticalSteamAgeItemsRegister.stone_war_axe);
        handheldItem(MysticalSteamAgeItemsRegister.wood_war_axe);

        // Spawn Egg
        /*withExistingParent(MysticalSteamAgeSpawnEggItems.roadie_egg.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(MysticalSteamAgeSpawnEggItems.flower_horse_egg.getId().getPath(), mcLoc("item/template_spawn_egg"));*/

    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = MysticalSteamAge.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MysticalSteamAge.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(MysticalSteamAge.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(MysticalSteamAge.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(MysticalSteamAge.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(MysticalSteamAge.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(MysticalSteamAge.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MysticalSteamAge.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MysticalSteamAge.MOD_ID,"block/" + item.getId().getPath()));
    }
}