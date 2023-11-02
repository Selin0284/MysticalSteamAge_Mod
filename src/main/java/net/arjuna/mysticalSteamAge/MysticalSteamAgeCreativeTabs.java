package net.arjuna.mysticalSteamAge;

import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeBlocksRegister;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeMachinesRegister;
import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MysticalSteamAgeCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MysticalSteamAge.MOD_ID);

    public static final RegistryObject<CreativeModeTab> items = CREATIVE_MODE_TABS.register("mystical_steam_age_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(MysticalSteamAgeItemsRegister.roadie_leather_armor.get()))
                    .title(Component.translatable("creative_tab.mystical_steam_age_items_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Dust
                        pOutput.accept(MysticalSteamAgeItemsRegister.brass_dust.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.bronze_dust.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.devil_iron_dust.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.salt_dust.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.tin_dust.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.zinc_dust.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.sulphur_dust.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.copper_dust.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.iron_dust.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.gold_dust.get());
                        // Ingot
                        pOutput.accept(MysticalSteamAgeItemsRegister.brass_ingot.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.bronze_ingot.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.devil_iron_ingot.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.steel_ingot.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.tin_ingot.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.zinc_ingot.get());
                        // Raw Ore
                        pOutput.accept(MysticalSteamAgeItemsRegister.raw_devil_iron.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.raw_salt.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.raw_sulphur.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.raw_tin.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.raw_zinc.get());
                        // Others
                        pOutput.accept(MysticalSteamAgeItemsRegister.feather_herb_leaf.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.feather_herb_seed.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.feather_herb_potion.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.camas.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.big_glass_bottle.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.big_water_potion.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.blumento_love.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.roadie_love.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.empty_beer_glass.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.beer.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.bottle_milk.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.camas_paste.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.gold_nail.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.iron_nail.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.sand_mold.get());
                        // Food
                        pOutput.accept(MysticalSteamAgeItemsRegister.cheese.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.cheese_bread.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.raw_roadie_leg.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.raw_roadie_meat.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.cooked_roadie_leg.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.cooked_roadie_meat.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.meal.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.dough_bowl_bread.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.dough_bowl_potato_bread.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.dough_bowl_feather_herb_bread.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.dough_bowl_pancake.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.dough_bowl_waffle.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.potato_bread.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.feather_herb_bread.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.pancake.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.waffle.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.mirror_egg.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.ham.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.ham_bread.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.bao_bapfel.get());
                        // Armor
                        pOutput.accept(MysticalSteamAgeItemsRegister.roadie_iron_armor.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.roadie_gold_armor.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.roadie_diamond_armor.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.roadie_leather_armor.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.blue_hardened_leather_helmet.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.blue_hardened_leather_chestplate.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.blue_hardened_leather_leggings.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.blue_hardened_leather_boots.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.black_hardened_leather_helmet.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.black_hardened_leather_chestplate.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.black_hardened_leather_leggings.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.black_hardened_leather_boots.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.brown_hardened_leather_helmet.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.brown_hardened_leather_chestplate.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.brown_hardened_leather_leggings.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.brown_hardened_leather_boots.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.green_hardened_leather_helmet.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.green_hardened_leather_chestplate.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.green_hardened_leather_leggings.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.green_hardened_leather_boots.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.light_green_hardened_leather_helmet.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.light_green_hardened_leather_chestplate.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.light_green_hardened_leather_leggings.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.light_green_hardened_leather_boots.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.purple_hardened_leather_helmet.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.purple_hardened_leather_chestplate.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.purple_hardened_leather_leggings.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.purple_hardened_leather_boots.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.red_hardened_leather_helmet.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.red_hardened_leather_chestplate.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.red_hardened_leather_leggings.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.red_hardened_leather_boots.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.white_hardened_leather_helmet.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.white_hardened_leather_chestplate.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.white_hardened_leather_leggings.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.white_hardened_leather_boots.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.devil_iron_helmet.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.devil_iron_chestplate.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.devil_iron_leggings.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.devil_iron_boots.get());
                        // Weapon & Tools
                        pOutput.accept(MysticalSteamAgeItemsRegister.copper_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.copper_hoe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.copper_pickaxe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.copper_shovel.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.copper_sword.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.devil_iron_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.devil_iron_hoe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.devil_iron_pickaxe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.devil_iron_shovel.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.devil_iron_sword.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.flint_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.flint_hoe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.flint_pickaxe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.flint_shovel.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.netherrack_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.netherrack_hoe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.netherrack_pickaxe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.netherrack_shovel.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.netherrack_sword.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.steel_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.steel_hoe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.steel_pickaxe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.steel_shovel.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.steel_sword.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.copper_war_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.devil_iron_war_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.diamond_war_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.gold_war_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.iron_war_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.netherite_war_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.netherrack_war_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.steel_war_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.stone_war_axe.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.wood_war_axe.get());
                        // Leather
                        pOutput.accept(MysticalSteamAgeItemsRegister.blumento_leather.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.blue_hardened_leather.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.brown_hardened_leather.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.green_hardened_leather.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.light_green_hardened_leather.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.purple_hardened_leather.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.red_hardened_leather.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.black_hardened_leather.get());
                        pOutput.accept(MysticalSteamAgeItemsRegister.white_hardened_leather.get());
                        // SpawnEgg
                        /*pOutput.accept(MysticalSteamAgeSpawnEggItems.roadie_egg.get());
                        pOutput.accept(MysticalSteamAgeSpawnEggItems.flower_horse_egg.get());*/
                    })
                    .build());


    public static final RegistryObject<CreativeModeTab> decoration = CREATIVE_MODE_TABS.register("mystical_steam_age_decoration_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(MysticalSteamAgeBlocksRegister.dust_flower_item.get()))
                    .title(Component.translatable("creative_tab.mystical_steam_age_decoration_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(MysticalSteamAgeBlocksRegister.oak_wardrobe_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.spruce_wardrobe_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.birch_wardrobe_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.jungle_wardrobe_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.acacia_wardrobe_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.dark_oak_wardrobe_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_wardrobe_item.get());
                        // BlockDeco Plants & Wood
                        //pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_sapling_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_door_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_pressure_plate_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_trapdoor_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_button_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_fence_gate_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_fence_item.get());
                        // BlockDeco Lamps
                        pOutput.accept(MysticalSteamAgeBlocksRegister.acacia_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.birch_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.dark_oak_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.jungle_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.oak_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.spruce_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.andesite_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.cobblestone_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.deepslate_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.diorite_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.granite_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_black_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.sand_stone_lamp_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.iron_lamp_item.get());
                        // BlockDeco Studded Wood Doors
                        pOutput.accept(MysticalSteamAgeBlocksRegister.studded_wooden_door_1_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.studded_wooden_door_2_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.studded_wooden_door_3_item.get());
                        // BlockDeco Studded Wood
                        pOutput.accept(MysticalSteamAgeBlocksRegister.acacia_gold_studded_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.birch_gold_studded_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.dark_oak_gold_studded_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.jungle_gold_studded_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.oak_gold_studded_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.spruce_gold_studded_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_gold_studded_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.acacia_iron_studded_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.birch_iron_studded_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.dark_oak_iron_studded_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.jungle_iron_studded_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.oak_iron_studded_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.spruce_iron_studded_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_iron_studded_block_item.get());
                        // Studded Pressure Plate
                        pOutput.accept(MysticalSteamAgeBlocksRegister.acacia_studded_pressure_plate_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_studded_pressure_plate_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.birch_studded_pressure_plate_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.dark_oak_studded_pressure_plate_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.jungle_studded_pressure_plate_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.oak_studded_pressure_plate_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.spruce_studded_pressure_plate_item.get());
                        // BlockDeco Leather Blocks
                        pOutput.accept(MysticalSteamAgeBlocksRegister.block_blue_hardened_leather_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.block_brown_hardened_leather_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.block_green_hardened_leather_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.block_light_green_hardened_leather_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.block_purple_hardened_leather_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.block_red_hardened_leather_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.block_black_hardened_leather_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.block_white_hardened_leather_item.get());
                        // Small Flowers
                        pOutput.accept(MysticalSteamAgeBlocksRegister.dust_flower_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.fire_flower_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.ice_flower_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.irrlicht_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.purple_rose_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.pink_fern_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.star_flower_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.white_rose_item.get());
                        // Tall Flowers
                        pOutput.accept(MysticalSteamAgeBlocksRegister.cloud_bush_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.fire_bush_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.shadow_fern_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.silver_umbrella_item.get());
                    })
                    .build());


    public static final RegistryObject<CreativeModeTab> machines = CREATIVE_MODE_TABS.register("mystical_steam_age_machines_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(MysticalSteamAgeBlocksRegister.carpenter_workbench_item.get()))
                    .title(Component.translatable("creative_tab.mystical_steam_age_machines_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(MysticalSteamAgeBlocksRegister.double_furnace_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.carpenter_workbench_item.get());
                    })
                    .build());


    public static final RegistryObject<CreativeModeTab> blocks = CREATIVE_MODE_TABS.register("mystical_steam_age_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(MysticalSteamAgeBlocksRegister.marble_item.get()))
                    .title(Component.translatable("creative_tab.mystical_steam_age_blocks_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Blocks
                        pOutput.accept(MysticalSteamAgeBlocksRegister.brass_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.bronze_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.tin_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.zinc_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.devil_iron_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.steel_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.salt_block_item.get());
                        // Ores
                        pOutput.accept(MysticalSteamAgeBlocksRegister.deepslate_sulphur_ore_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.deepslate_tin_ore_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.deepslate_zinc_ore_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.nether_coal_ore_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.nether_devil_iron_ore_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.nether_sulphur_ore_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.tin_ore_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.zinc_ore_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.salt_ore_item.get());
                        // BlockDeco Marble
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_stairs_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_slab_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_wall_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_pillar_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.polished_marble_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.polished_marble_slab_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.polished_marble_stairs_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_bricks_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_bricks_stairs_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_bricks_slab_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_bricks_wall_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_black_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_black_stairs_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_black_slab_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_black_wall_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_black_pillar_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.polished_marble_black_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.polished_marble_black_slab_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.polished_marble_black_stairs_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_black_bricks_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_black_bricks_stairs_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_black_bricks_slab_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.marble_black_bricks_wall_item.get());
                        // BlockDeco Plants & Wood
                        pOutput.accept(MysticalSteamAgeBlocksRegister.feather_herb_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.stick_bundle_block_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_log_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_wood_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_planks_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_leaves_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_stairs_item.get());
                        pOutput.accept(MysticalSteamAgeBlocksRegister.baobab_slab_item.get());

                    })
                    .build());


    public static void register (IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
