package net.arjuna.mysticalSteamAge.datagen;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeBlocksRegister;
import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MysticalSteamAgeItemTags extends ItemTagsProvider {

    public MysticalSteamAgeItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                    CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, completableFuture, MysticalSteamAge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // forge
        tag(Tags.Items.ORES)
                .add(MysticalSteamAgeBlocksRegister.deepslate_sulphur_ore_item.get())
                .add(MysticalSteamAgeBlocksRegister.deepslate_tin_ore_item.get())
                .add(MysticalSteamAgeBlocksRegister.deepslate_zinc_ore_item.get())
                .add(MysticalSteamAgeBlocksRegister.nether_coal_ore_item.get())
                .add(MysticalSteamAgeBlocksRegister.nether_devil_iron_ore_item.get())
                .add(MysticalSteamAgeBlocksRegister.nether_sulphur_ore_item.get())
                .add(MysticalSteamAgeBlocksRegister.tin_ore_item.get())
                .add(MysticalSteamAgeBlocksRegister.zinc_ore_item.get())
                .add(MysticalSteamAgeBlocksRegister.salt_ore_item.get());
        tag(Tags.Items.DUSTS)
                .add(MysticalSteamAgeItemsRegister.brass_dust.get())
                .add(MysticalSteamAgeItemsRegister.bronze_dust.get())
                .add(MysticalSteamAgeItemsRegister.devil_iron_dust.get())
                .add(MysticalSteamAgeItemsRegister.salt_dust.get())
                .add(MysticalSteamAgeItemsRegister.tin_dust.get())
                .add(MysticalSteamAgeItemsRegister.zinc_dust.get());
        tag(Tags.Items.INGOTS)
                .add(MysticalSteamAgeItemsRegister.brass_ingot.get())
                .add(MysticalSteamAgeItemsRegister.bronze_ingot.get())
                .add(MysticalSteamAgeItemsRegister.devil_iron_ingot.get())
                .add(MysticalSteamAgeItemsRegister.steel_ingot.get())
                .add(MysticalSteamAgeItemsRegister.tin_ingot.get())
                .add(MysticalSteamAgeItemsRegister.zinc_ingot.get());
        tag(Tags.Items.RAW_MATERIALS)
                .add(MysticalSteamAgeItemsRegister.raw_devil_iron.get())
                .add(MysticalSteamAgeItemsRegister.raw_salt.get())
                .add(MysticalSteamAgeItemsRegister.raw_sulphur.get())
                .add(MysticalSteamAgeItemsRegister.raw_tin.get())
                .add(MysticalSteamAgeItemsRegister.raw_zinc.get());
        tag(Tags.Items.SEEDS)
                .add(MysticalSteamAgeItemsRegister.feather_herb_seed.get());
        tag(Tags.Items.CROPS)
                .add(MysticalSteamAgeItemsRegister.camas.get())
                .add(MysticalSteamAgeItemsRegister.feather_herb_leaf.get());
        tag(Tags.Items.ORES_COAL)
                .add(MysticalSteamAgeBlocksRegister.nether_coal_ore_item.get());
        tag(Tags.Items.STONE)
                .add(MysticalSteamAgeBlocksRegister.marble_item.get())
                .add(MysticalSteamAgeBlocksRegister.marble_black_item.get())
                .add(MysticalSteamAgeBlocksRegister.polished_marble_item.get())
                .add(MysticalSteamAgeBlocksRegister.polished_marble_black_item.get());
        tag(Tags.Items.FENCES_WOODEN)
                .add(MysticalSteamAgeBlocksRegister.baobab_fence_item.get());
        tag(Tags.Items.FENCE_GATES_WOODEN)
                .add(MysticalSteamAgeBlocksRegister.baobab_fence_gate_item.get());
        tag(MysticalSteamAgeBlocksRegister.salt_ore_item_tag)
                .add(MysticalSteamAgeBlocksRegister.salt_ore_item.get());
        tag(MysticalSteamAgeBlocksRegister.zinc_ore_item_tag)
                .add(MysticalSteamAgeBlocksRegister.deepslate_zinc_ore_item.get())
                .add(MysticalSteamAgeBlocksRegister.zinc_ore_item.get());
        tag(MysticalSteamAgeBlocksRegister.tin_ore_item_tag)
                .add(MysticalSteamAgeBlocksRegister.deepslate_tin_ore_item.get())
                .add(MysticalSteamAgeBlocksRegister.tin_ore_item.get());
        tag(MysticalSteamAgeBlocksRegister.nether_devil_iron_ore_item_tag)
                .add(MysticalSteamAgeBlocksRegister.nether_devil_iron_ore_item.get());
        tag(MysticalSteamAgeBlocksRegister.sulphur_ore_item_tag)
                .add(MysticalSteamAgeBlocksRegister.deepslate_sulphur_ore_item.get())
                .add(MysticalSteamAgeBlocksRegister.nether_sulphur_ore_item.get());
        tag(MysticalSteamAgeBlocksRegister.marble_item_tag)
                .add(MysticalSteamAgeBlocksRegister.marble_item.get());
        tag(MysticalSteamAgeBlocksRegister.marble_black_item_tag)
                .add(MysticalSteamAgeBlocksRegister.marble_black_item.get());
        tag(MysticalSteamAgeItemsRegister.raw_devil_iron_tag)
                .add(MysticalSteamAgeItemsRegister.raw_devil_iron.get());
        tag(MysticalSteamAgeItemsRegister.raw_salt_tag)
                .add(MysticalSteamAgeItemsRegister.raw_salt.get());
        tag(MysticalSteamAgeItemsRegister.raw_sulphur_tag)
                .add(MysticalSteamAgeItemsRegister.raw_sulphur.get());
        tag(MysticalSteamAgeItemsRegister.raw_tin_tag)
                .add(MysticalSteamAgeItemsRegister.raw_tin.get());
        tag(MysticalSteamAgeItemsRegister.raw_zinc_tag)
                .add(MysticalSteamAgeItemsRegister.raw_zinc.get());
        tag(MysticalSteamAgeItemsRegister.devil_iron_ingot_tag)
                .add(MysticalSteamAgeItemsRegister.devil_iron_ingot.get());
        tag(MysticalSteamAgeItemsRegister.steel_ingot_tag)
                .add(MysticalSteamAgeItemsRegister.steel_ingot.get());
        tag(MysticalSteamAgeItemsRegister.brass_ingot_tag)
                .add(MysticalSteamAgeItemsRegister.brass_ingot.get());
        tag(MysticalSteamAgeItemsRegister.bronze_ingot_tag)
                .add(MysticalSteamAgeItemsRegister.bronze_ingot.get());
        tag(MysticalSteamAgeItemsRegister.tin_ingot_tag)
                .add(MysticalSteamAgeItemsRegister.tin_ingot.get());
        tag(MysticalSteamAgeItemsRegister.zinc_ingot_tag)
                .add(MysticalSteamAgeItemsRegister.zinc_ingot.get());
        tag(MysticalSteamAgeItemsRegister.devil_iron_dust_tag)
                .add(MysticalSteamAgeItemsRegister.devil_iron_dust.get());
        tag(MysticalSteamAgeItemsRegister.salt_dust_tag)
                .add(MysticalSteamAgeItemsRegister.salt_dust.get());
        tag(MysticalSteamAgeItemsRegister.brass_dust_tag)
                .add(MysticalSteamAgeItemsRegister.brass_dust.get());
        tag(MysticalSteamAgeItemsRegister.bronze_dust_tag)
                .add(MysticalSteamAgeItemsRegister.bronze_dust.get());
        tag(MysticalSteamAgeItemsRegister.tin_dust_tag)
                .add(MysticalSteamAgeItemsRegister.tin_dust.get());
        tag(MysticalSteamAgeItemsRegister.zinc_dust_tag)
                .add(MysticalSteamAgeItemsRegister.zinc_dust.get());
        tag(MysticalSteamAgeItemsRegister.sulphur_dust_tag)
                .add(MysticalSteamAgeItemsRegister.sulphur_dust.get());
        tag(MysticalSteamAgeItemsRegister.copper_dust_tag)
                .add(MysticalSteamAgeItemsRegister.copper_dust.get());
        tag(MysticalSteamAgeItemsRegister.iron_dust_tag)
                .add(MysticalSteamAgeItemsRegister.iron_dust.get());
        tag(MysticalSteamAgeItemsRegister.gold_dust_tag)
                .add(MysticalSteamAgeItemsRegister.gold_dust.get());
        tag(MysticalSteamAgeItemsRegister.coal_tag)
                .add(Items.COAL);
        tag(MysticalSteamAgeItemsRegister.char_coal_tag)
                .add(Items.CHARCOAL);
        tag(MysticalSteamAgeItemsRegister.baobab_planks_tag)
                .add(MysticalSteamAgeBlocksRegister.baobab_planks_item.get());
        tag(MysticalSteamAgeItemsRegister.big_glass_bottle_tag)
                .add(MysticalSteamAgeItemsRegister.big_glass_bottle.get());
        // Minecraft
        tag(ItemTags.LOGS)
                .add(MysticalSteamAgeBlocksRegister.baobab_log_item.get())
                .add(MysticalSteamAgeBlocksRegister.baobab_wood_item.get());
        tag(ItemTags.LOGS_THAT_BURN)
                .add(MysticalSteamAgeBlocksRegister.baobab_log_item.get())
                .add(MysticalSteamAgeBlocksRegister.baobab_wood_item.get());
       /* tag(ItemTags.SAPLINGS)
                .add(MysticalSteamAgeBlocksRegister.baobab_sapling_item.get());*/
        tag(ItemTags.LEAVES)
                .add(MysticalSteamAgeBlocksRegister.baobab_leaves_item.get());
        tag(ItemTags.PLANKS)
                .add(MysticalSteamAgeBlocksRegister.baobab_planks_item.get());
        tag(ItemTags.STAIRS)
                .add(MysticalSteamAgeBlocksRegister.marble_stairs_item.get())
                .add(MysticalSteamAgeBlocksRegister.polished_marble_stairs_item.get())
                .add(MysticalSteamAgeBlocksRegister.marble_bricks_stairs_item.get())
                .add(MysticalSteamAgeBlocksRegister.marble_black_stairs_item.get())
                .add(MysticalSteamAgeBlocksRegister.polished_marble_black_stairs_item.get())
                .add(MysticalSteamAgeBlocksRegister.marble_black_bricks_stairs_item.get());
        tag(ItemTags.SLABS)
                .add(MysticalSteamAgeBlocksRegister.marble_slab_item.get())
                .add(MysticalSteamAgeBlocksRegister.polished_marble_slab_item.get())
                .add(MysticalSteamAgeBlocksRegister.marble_bricks_slab_item.get())
                .add(MysticalSteamAgeBlocksRegister.marble_black_slab_item.get())
                .add(MysticalSteamAgeBlocksRegister.polished_marble_black_slab_item.get())
                .add(MysticalSteamAgeBlocksRegister.marble_black_bricks_slab_item.get());
        tag(ItemTags.WOODEN_DOORS)
                .add(MysticalSteamAgeBlocksRegister.baobab_door_item.get())
                .add(MysticalSteamAgeBlocksRegister.studded_wooden_door_1_item.get())
                .add(MysticalSteamAgeBlocksRegister.studded_wooden_door_2_item.get())
                .add(MysticalSteamAgeBlocksRegister.studded_wooden_door_3_item.get());
        tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(MysticalSteamAgeBlocksRegister.baobab_pressure_plate_item.get())
                .add(MysticalSteamAgeBlocksRegister.acacia_studded_pressure_plate_item.get())
                .add(MysticalSteamAgeBlocksRegister.baobab_studded_pressure_plate_item.get())
                .add(MysticalSteamAgeBlocksRegister.birch_studded_pressure_plate_item.get())
                .add(MysticalSteamAgeBlocksRegister.dark_oak_studded_pressure_plate_item.get())
                .add(MysticalSteamAgeBlocksRegister.jungle_studded_pressure_plate_item.get())
                .add(MysticalSteamAgeBlocksRegister.oak_studded_pressure_plate_item.get())
                .add(MysticalSteamAgeBlocksRegister.spruce_studded_pressure_plate_item.get());
        tag(ItemTags.WOODEN_TRAPDOORS)
                .add(MysticalSteamAgeBlocksRegister.baobab_trapdoor_item.get());
        tag(ItemTags.WOODEN_BUTTONS)
                .add(MysticalSteamAgeBlocksRegister.baobab_button_item.get());
        tag(ItemTags.WOODEN_STAIRS)
                .add(MysticalSteamAgeBlocksRegister.baobab_stairs_item.get());
        tag(ItemTags.WOODEN_SLABS)
                .add(MysticalSteamAgeBlocksRegister.baobab_slab_item.get());
        tag(ItemTags.WOODEN_FENCES)
                .add(MysticalSteamAgeBlocksRegister.baobab_fence_item.get());
        tag(ItemTags.WALLS)
                .add(MysticalSteamAgeBlocksRegister.marble_wall_item.get())
                .add(MysticalSteamAgeBlocksRegister.marble_bricks_wall_item.get())
                .add(MysticalSteamAgeBlocksRegister.marble_black_wall_item.get())
                .add(MysticalSteamAgeBlocksRegister.marble_black_bricks_wall_item.get());
        tag(ItemTags.FLOWERS)
                .add(MysticalSteamAgeBlocksRegister.dust_flower_item.get())
                .add(MysticalSteamAgeBlocksRegister.fire_flower_item.get())
                .add(MysticalSteamAgeBlocksRegister.ice_flower_item.get())
                .add(MysticalSteamAgeBlocksRegister.irrlicht_item.get())
                .add(MysticalSteamAgeBlocksRegister.purple_rose_item.get())
                .add(MysticalSteamAgeBlocksRegister.pink_fern_item.get())
                .add(MysticalSteamAgeBlocksRegister.star_flower_item.get())
                .add(MysticalSteamAgeBlocksRegister.white_rose_item.get())
                .add(MysticalSteamAgeBlocksRegister.cloud_bush_item.get())
                .add(MysticalSteamAgeBlocksRegister.fire_bush_item.get())
                .add(MysticalSteamAgeBlocksRegister.shadow_fern_item.get())
                .add(MysticalSteamAgeBlocksRegister.silver_umbrella_item.get());
        tag(ItemTags.SMALL_FLOWERS)
                .add(MysticalSteamAgeBlocksRegister.dust_flower_item.get())
                .add(MysticalSteamAgeBlocksRegister.fire_flower_item.get())
                .add(MysticalSteamAgeBlocksRegister.ice_flower_item.get())
                .add(MysticalSteamAgeBlocksRegister.irrlicht_item.get())
                .add(MysticalSteamAgeBlocksRegister.purple_rose_item.get())
                .add(MysticalSteamAgeBlocksRegister.pink_fern_item.get())
                .add(MysticalSteamAgeBlocksRegister.star_flower_item.get())
                .add(MysticalSteamAgeBlocksRegister.white_rose_item.get());
        tag(ItemTags.TALL_FLOWERS)
                .add(MysticalSteamAgeBlocksRegister.cloud_bush_item.get())
                .add(MysticalSteamAgeBlocksRegister.fire_bush_item.get())
                .add(MysticalSteamAgeBlocksRegister.shadow_fern_item.get())
                .add(MysticalSteamAgeBlocksRegister.silver_umbrella_item.get());
        tag(ItemTags.FREEZE_IMMUNE_WEARABLES)
                .add(MysticalSteamAgeItemsRegister.roadie_leather_armor.get())
                .add(MysticalSteamAgeItemsRegister.black_hardened_leather_boots.get())
                .add(MysticalSteamAgeItemsRegister.black_hardened_leather_chestplate.get())
                .add(MysticalSteamAgeItemsRegister.black_hardened_leather_helmet.get())
                .add(MysticalSteamAgeItemsRegister.black_hardened_leather_leggings.get())
                .add(MysticalSteamAgeItemsRegister.blue_hardened_leather_boots.get())
                .add(MysticalSteamAgeItemsRegister.blue_hardened_leather_chestplate.get())
                .add(MysticalSteamAgeItemsRegister.blue_hardened_leather_helmet.get())
                .add(MysticalSteamAgeItemsRegister.blue_hardened_leather_leggings.get())
                .add(MysticalSteamAgeItemsRegister.brown_hardened_leather_boots.get())
                .add(MysticalSteamAgeItemsRegister.brown_hardened_leather_chestplate.get())
                .add(MysticalSteamAgeItemsRegister.brown_hardened_leather_helmet.get())
                .add(MysticalSteamAgeItemsRegister.brown_hardened_leather_leggings.get())
                .add(MysticalSteamAgeItemsRegister.green_hardened_leather_boots.get())
                .add(MysticalSteamAgeItemsRegister.green_hardened_leather_chestplate.get())
                .add(MysticalSteamAgeItemsRegister.green_hardened_leather_helmet.get())
                .add(MysticalSteamAgeItemsRegister.green_hardened_leather_leggings.get())
                .add(MysticalSteamAgeItemsRegister.light_green_hardened_leather_boots.get())
                .add(MysticalSteamAgeItemsRegister.light_green_hardened_leather_chestplate.get())
                .add(MysticalSteamAgeItemsRegister.light_green_hardened_leather_helmet.get())
                .add(MysticalSteamAgeItemsRegister.light_green_hardened_leather_leggings.get())
                .add(MysticalSteamAgeItemsRegister.purple_hardened_leather_boots.get())
                .add(MysticalSteamAgeItemsRegister.purple_hardened_leather_chestplate.get())
                .add(MysticalSteamAgeItemsRegister.purple_hardened_leather_helmet.get())
                .add(MysticalSteamAgeItemsRegister.purple_hardened_leather_leggings.get())
                .add(MysticalSteamAgeItemsRegister.red_hardened_leather_boots.get())
                .add(MysticalSteamAgeItemsRegister.red_hardened_leather_chestplate.get())
                .add(MysticalSteamAgeItemsRegister.red_hardened_leather_helmet.get())
                .add(MysticalSteamAgeItemsRegister.red_hardened_leather_leggings.get())
                .add(MysticalSteamAgeItemsRegister.white_hardened_leather_boots.get())
                .add(MysticalSteamAgeItemsRegister.white_hardened_leather_chestplate.get())
                .add(MysticalSteamAgeItemsRegister.white_hardened_leather_helmet.get())
                .add(MysticalSteamAgeItemsRegister.white_hardened_leather_leggings.get());
        // MysticalSteamAge
        tag(MysticalSteamAgeBlocksRegister.wardrobe_item_tag)
                .add(MysticalSteamAgeBlocksRegister.acacia_wardrobe_item.get())
                .add(MysticalSteamAgeBlocksRegister.birch_wardrobe_item.get())
                .add(MysticalSteamAgeBlocksRegister.oak_wardrobe_item.get())
                .add(MysticalSteamAgeBlocksRegister.dark_oak_wardrobe_item.get())
                .add(MysticalSteamAgeBlocksRegister.baobab_wardrobe_item.get())
                .add(MysticalSteamAgeBlocksRegister.spruce_wardrobe_item.get())
                .add(MysticalSteamAgeBlocksRegister.jungle_wardrobe_item.get());
        tag(MysticalSteamAgeItemsRegister.ham_tag)
                .add(Items.BEEF)
                .add(Items.MUTTON)
                .add(Items.PORKCHOP);
        tag(MysticalSteamAgeItemsRegister.sand_mold_tag)
                .add(MysticalSteamAgeItemsRegister.sand_mold.get());
        tag(MysticalSteamAgeBlocksRegister.iron_studded_wood_item_tag)
                .add(MysticalSteamAgeBlocksRegister.acacia_iron_studded_block_item.get())
                .add(MysticalSteamAgeBlocksRegister.birch_iron_studded_block_item.get())
                .add(MysticalSteamAgeBlocksRegister.dark_oak_iron_studded_block_item.get())
                .add(MysticalSteamAgeBlocksRegister.jungle_iron_studded_block_item.get())
                .add(MysticalSteamAgeBlocksRegister.oak_iron_studded_block_item.get())
                .add(MysticalSteamAgeBlocksRegister.spruce_iron_studded_block_item.get());
        tag(MysticalSteamAgeItemsRegister.baobab_log_tag)
                .add(MysticalSteamAgeBlocksRegister.baobab_log_item.get());
        tag(MysticalSteamAgeItemsRegister.baobab_wood_tag)
                .add(MysticalSteamAgeBlocksRegister.baobab_wood_item.get());

    }
}