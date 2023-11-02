package net.arjuna.mysticalSteamAge.datagen;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeBlocksRegister;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.carpenterWorkbench.CarpenterWorkbenchRecipeBuilder;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace.DoubleFurnaceRecipeBuilder;
import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class Recipes extends RecipeProvider implements IConditionBuilder {

    public Recipes(PackOutput pOutput) {
        super(pOutput);
    }

     @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        // Ingots & Blocks
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, MysticalSteamAgeItemsRegister.brass_ingot.get(), RecipeCategory.MISC, MysticalSteamAgeBlocksRegister.brass_block.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, MysticalSteamAgeItemsRegister.bronze_ingot.get(), RecipeCategory.MISC, MysticalSteamAgeBlocksRegister.bronze_block.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, MysticalSteamAgeItemsRegister.tin_ingot.get(), RecipeCategory.MISC, MysticalSteamAgeBlocksRegister.tin_block.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, MysticalSteamAgeItemsRegister.zinc_ingot.get(), RecipeCategory.MISC, MysticalSteamAgeBlocksRegister.zinc_block.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, MysticalSteamAgeItemsRegister.devil_iron_ingot.get(), RecipeCategory.MISC, MysticalSteamAgeBlocksRegister.devil_iron_block.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, MysticalSteamAgeItemsRegister.steel_ingot.get(), RecipeCategory.MISC, MysticalSteamAgeBlocksRegister.steel_block.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, MysticalSteamAgeItemsRegister.raw_salt.get(), RecipeCategory.MISC, MysticalSteamAgeBlocksRegister.salt_block.get());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MysticalSteamAgeBlocksRegister.tin_ore_item_tag), RecipeCategory.MISC,
                        MysticalSteamAgeItemsRegister.tin_ingot.get(), 0.7f, 200)
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.tin_ore.get()), has(MysticalSteamAgeBlocksRegister.tin_ore.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "tin_ingot_1"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MysticalSteamAgeItemsRegister.raw_tin_tag), RecipeCategory.MISC,
                        MysticalSteamAgeItemsRegister.tin_ingot.get(), 0.7f, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_tin.get()), has(MysticalSteamAgeItemsRegister.raw_tin.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"tin_ingot_2"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MysticalSteamAgeBlocksRegister.zinc_ore_item_tag), RecipeCategory.MISC,
                        MysticalSteamAgeItemsRegister.zinc_ingot.get(), 0.7f, 200)
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.zinc_ore.get()), has(MysticalSteamAgeBlocksRegister.zinc_ore.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"zinc_ingot_1"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MysticalSteamAgeItemsRegister.raw_zinc_tag), RecipeCategory.MISC,
                        MysticalSteamAgeItemsRegister.zinc_ingot.get(), 0.7f, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_zinc.get()), has(MysticalSteamAgeItemsRegister.raw_zinc.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"zinc_ingot_2"));

        // Decoration & more
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, MysticalSteamAgeItemsRegister.feather_herb_leaf.get(), RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.feather_herb_block.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, Items.STICK, RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.stick_bundle_block.get(), "mystical_stick",
                null, "stick_bundle_block", null);

        ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, MysticalSteamAgeItemsRegister.big_glass_bottle.get(), 3).define('#', Blocks.GLASS)
                .pattern(" # ").pattern("# #").pattern("###").unlockedBy(getHasName(Blocks.GLASS), has(Blocks.GLASS)).save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID, "big_glass_bottle"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, MysticalSteamAgeItemsRegister.empty_beer_glass.get(), 4).define('#', Blocks.GLASS)
                .pattern("# #").pattern("# #").pattern("###").unlockedBy(getHasName(Blocks.GLASS), has(Blocks.GLASS)).save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID, "empty_beer_glass"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeItemsRegister.sand_mold.get(), 2).define('#', Ingredient.of(ItemTags.SAND)).define('X', Items.STICK)
                .pattern(" X ").pattern("X#X").pattern(" X ").unlockedBy(getHasName(Blocks.SAND), has(Blocks.SAND)).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "sand_mold"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.ROTTEN_FLESH), RecipeCategory.MISC, Items.LEATHER, 0.35f, 200)
                .unlockedBy(getHasName(Items.ROTTEN_FLESH), has(Items.ROTTEN_FLESH)).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"leather_from_rotten_flesh"));
        // Leather
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysticalSteamAgeItemsRegister.blue_hardened_leather.get(), 2).define('#',
                        MysticalSteamAgeItemsRegister.blumento_leather.get())
                .define('X', MysticalSteamAgeItemsRegister.iron_nail.get()).define('O', Items.BLUE_DYE)
                .pattern("XOX").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.blumento_leather.get()),
                        has(MysticalSteamAgeItemsRegister.blumento_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"blue_hardened_leather"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysticalSteamAgeItemsRegister.black_hardened_leather.get(), 2).define('#',
                        MysticalSteamAgeItemsRegister.blumento_leather.get())
                .define('X', MysticalSteamAgeItemsRegister.gold_nail.get()).define('O', Items.BLACK_DYE)
                .pattern("XOX").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.blumento_leather.get()),
                        has(MysticalSteamAgeItemsRegister.blumento_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"black_hardened_leather"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysticalSteamAgeItemsRegister.brown_hardened_leather.get(), 2).define('#',
                        MysticalSteamAgeItemsRegister.blumento_leather.get())
                .define('X', MysticalSteamAgeItemsRegister.iron_nail.get())
                .pattern("X X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.blumento_leather.get()),
                        has(MysticalSteamAgeItemsRegister.blumento_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"brown_hardened_leather"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysticalSteamAgeItemsRegister.green_hardened_leather.get(), 2).define('#',
                        MysticalSteamAgeItemsRegister.blumento_leather.get())
                .define('X', MysticalSteamAgeItemsRegister.iron_nail.get()).define('O', Items.GREEN_DYE)
                .pattern("XOX").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.blumento_leather.get()),
                        has(MysticalSteamAgeItemsRegister.blumento_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"green_hardened_leather"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysticalSteamAgeItemsRegister.light_green_hardened_leather.get(), 2).define('#',
                        MysticalSteamAgeItemsRegister.blumento_leather.get())
                .define('X', MysticalSteamAgeItemsRegister.iron_nail.get()).define('O', Items.LIME_DYE)
                .pattern("XOX").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.blumento_leather.get()),
                        has(MysticalSteamAgeItemsRegister.blumento_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"light_green_hardened_leather"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysticalSteamAgeItemsRegister.purple_hardened_leather.get(), 2).define('#',
                        MysticalSteamAgeItemsRegister.blumento_leather.get())
                .define('X', MysticalSteamAgeItemsRegister.gold_nail.get()).define('O', Items.PURPLE_DYE)
                .pattern("XOX").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.blumento_leather.get()),
                        has(MysticalSteamAgeItemsRegister.blumento_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"purple_hardened_leather"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysticalSteamAgeItemsRegister.red_hardened_leather.get(), 2).define('#',
                        MysticalSteamAgeItemsRegister.blumento_leather.get())
                .define('X', MysticalSteamAgeItemsRegister.gold_nail.get()).define('O', Items.RED_DYE)
                .pattern("XOX").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.blumento_leather.get()),
                        has(MysticalSteamAgeItemsRegister.blumento_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"red_hardened_leather"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MysticalSteamAgeItemsRegister.white_hardened_leather.get(), 2).define('#',
                        MysticalSteamAgeItemsRegister.blumento_leather.get())
                .define('X', MysticalSteamAgeItemsRegister.gold_nail.get()).define('O', Items.WHITE_DYE)
                .pattern("XOX").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.blumento_leather.get()),
                        has(MysticalSteamAgeItemsRegister.blumento_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"white_hardened_leather"));

        // Leather Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.block_black_hardened_leather.get(), 4)
                .define('#', MysticalSteamAgeItemsRegister.black_hardened_leather.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.black_hardened_leather.get()), has(MysticalSteamAgeItemsRegister.black_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"block_black_hardened_leather"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.block_blue_hardened_leather.get(), 4)
                .define('#', MysticalSteamAgeItemsRegister.blue_hardened_leather.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.blue_hardened_leather.get()), has(MysticalSteamAgeItemsRegister.blue_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"block_blue_hardened_leather"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.block_brown_hardened_leather.get(), 4)
                .define('#', MysticalSteamAgeItemsRegister.brown_hardened_leather.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.brown_hardened_leather.get()), has(MysticalSteamAgeItemsRegister.brown_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"block_brown_hardened_leather"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.block_green_hardened_leather.get(), 4)
                .define('#', MysticalSteamAgeItemsRegister.green_hardened_leather.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.green_hardened_leather.get()), has(MysticalSteamAgeItemsRegister.green_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"block_green_hardened_leather"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.block_light_green_hardened_leather.get(), 4)
                .define('#', MysticalSteamAgeItemsRegister.light_green_hardened_leather.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.light_green_hardened_leather.get()), has(MysticalSteamAgeItemsRegister.light_green_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"block_light_green_hardened_leather"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.block_purple_hardened_leather.get(), 4)
                .define('#', MysticalSteamAgeItemsRegister.purple_hardened_leather.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.purple_hardened_leather.get()), has(MysticalSteamAgeItemsRegister.purple_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"block_purple_hardened_leather"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.block_red_hardened_leather.get(), 4)
                .define('#', MysticalSteamAgeItemsRegister.red_hardened_leather.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.red_hardened_leather.get()), has(MysticalSteamAgeItemsRegister.red_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"block_red_hardened_leather"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.block_white_hardened_leather.get(), 4)
                .define('#', MysticalSteamAgeItemsRegister.white_hardened_leather.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.white_hardened_leather.get()), has(MysticalSteamAgeItemsRegister.white_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"block_white_hardened_leather"));


        // Leather Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.black_hardened_leather_boots.get()).define('X', MysticalSteamAgeItemsRegister.black_hardened_leather.get())
                .pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.black_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.black_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"black_hardened_leather_boots"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.black_hardened_leather_chestplate.get()).define('X', MysticalSteamAgeItemsRegister.black_hardened_leather.get())
                .pattern("X X").pattern("XXX").pattern("XXX").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.black_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.black_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"black_hardened_leather_chestplate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.black_hardened_leather_helmet.get()).define('X', MysticalSteamAgeItemsRegister.black_hardened_leather.get())
                .pattern("XXX").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.black_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.black_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"black_hardened_leather_helmet"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.black_hardened_leather_leggings.get()).define('X', MysticalSteamAgeItemsRegister.black_hardened_leather.get())
                .pattern("XXX").pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.black_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.black_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"black_hardened_leather_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.blue_hardened_leather_boots.get()).define('X', MysticalSteamAgeItemsRegister.blue_hardened_leather.get())
                .pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.blue_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.blue_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"blue_hardened_leather_boots"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.blue_hardened_leather_chestplate.get()).define('X', MysticalSteamAgeItemsRegister.blue_hardened_leather.get())
                .pattern("X X").pattern("XXX").pattern("XXX").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.blue_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.blue_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"blue_hardened_leather_chestplate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.blue_hardened_leather_helmet.get()).define('X', MysticalSteamAgeItemsRegister.blue_hardened_leather.get())
                .pattern("XXX").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.blue_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.blue_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"blue_hardened_leather_helmet"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.blue_hardened_leather_leggings.get()).define('X', MysticalSteamAgeItemsRegister.blue_hardened_leather.get())
                .pattern("XXX").pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.blue_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.blue_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"blue_hardened_leather_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.brown_hardened_leather_boots.get()).define('X', MysticalSteamAgeItemsRegister.brown_hardened_leather.get())
                .pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.brown_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.brown_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"brown_hardened_leather_boots"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.brown_hardened_leather_chestplate.get()).define('X', MysticalSteamAgeItemsRegister.brown_hardened_leather.get())
                .pattern("X X").pattern("XXX").pattern("XXX").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.brown_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.brown_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"brown_hardened_leather_chestplate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.brown_hardened_leather_helmet.get()).define('X', MysticalSteamAgeItemsRegister.brown_hardened_leather.get())
                .pattern("XXX").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.brown_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.brown_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"brown_hardened_leather_helmet"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.brown_hardened_leather_leggings.get()).define('X', MysticalSteamAgeItemsRegister.brown_hardened_leather.get())
                .pattern("XXX").pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.brown_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.brown_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"brown_hardened_leather_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.green_hardened_leather_boots.get()).define('X', MysticalSteamAgeItemsRegister.green_hardened_leather.get())
                .pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.green_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.green_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"green_hardened_leather_boots"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.green_hardened_leather_chestplate.get()).define('X', MysticalSteamAgeItemsRegister.green_hardened_leather.get())
                .pattern("X X").pattern("XXX").pattern("XXX").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.green_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.green_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"green_hardened_leather_chestplate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.green_hardened_leather_helmet.get()).define('X', MysticalSteamAgeItemsRegister.green_hardened_leather.get())
                .pattern("XXX").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.green_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.green_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"green_hardened_leather_helmet"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.green_hardened_leather_leggings.get()).define('X', MysticalSteamAgeItemsRegister.green_hardened_leather.get())
                .pattern("XXX").pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.green_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.green_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"green_hardened_leather_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.light_green_hardened_leather_boots.get()).define('X', MysticalSteamAgeItemsRegister.light_green_hardened_leather.get())
                .pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.light_green_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.light_green_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"light_green_hardened_leather_boots"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.light_green_hardened_leather_chestplate.get()).define('X', MysticalSteamAgeItemsRegister.light_green_hardened_leather.get())
                .pattern("X X").pattern("XXX").pattern("XXX").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.light_green_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.light_green_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"light_green_hardened_leather_chestplate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.light_green_hardened_leather_helmet.get()).define('X', MysticalSteamAgeItemsRegister.light_green_hardened_leather.get())
                .pattern("XXX").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.light_green_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.light_green_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"light_green_hardened_leather_helmet"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.light_green_hardened_leather_leggings.get()).define('X', MysticalSteamAgeItemsRegister.light_green_hardened_leather.get())
                .pattern("XXX").pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.light_green_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.light_green_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"light_green_hardened_leather_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.purple_hardened_leather_boots.get()).define('X', MysticalSteamAgeItemsRegister.purple_hardened_leather.get())
                .pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.purple_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.purple_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"purple_hardened_leather_boots"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.purple_hardened_leather_chestplate.get()).define('X', MysticalSteamAgeItemsRegister.purple_hardened_leather.get())
                .pattern("X X").pattern("XXX").pattern("XXX").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.purple_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.purple_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"purple_hardened_leather_chestplate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.purple_hardened_leather_helmet.get()).define('X', MysticalSteamAgeItemsRegister.purple_hardened_leather.get())
                .pattern("XXX").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.purple_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.purple_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"purple_hardened_leather_helmet"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.purple_hardened_leather_leggings.get()).define('X', MysticalSteamAgeItemsRegister.purple_hardened_leather.get())
                .pattern("XXX").pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.purple_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.purple_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"purple_hardened_leather_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.red_hardened_leather_boots.get()).define('X', MysticalSteamAgeItemsRegister.red_hardened_leather.get())
                .pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.red_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.red_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"red_hardened_leather_boots"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.red_hardened_leather_chestplate.get()).define('X', MysticalSteamAgeItemsRegister.red_hardened_leather.get())
                .pattern("X X").pattern("XXX").pattern("XXX").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.red_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.red_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"red_hardened_leather_chestplate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.red_hardened_leather_helmet.get()).define('X', MysticalSteamAgeItemsRegister.red_hardened_leather.get())
                .pattern("XXX").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.red_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.red_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"red_hardened_leather_helmet"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.red_hardened_leather_leggings.get()).define('X', MysticalSteamAgeItemsRegister.red_hardened_leather.get())
                .pattern("XXX").pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.red_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.red_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"red_hardened_leather_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.white_hardened_leather_boots.get()).define('X', MysticalSteamAgeItemsRegister.white_hardened_leather.get())
                .pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.white_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.white_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"white_hardened_leather_boots"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.white_hardened_leather_chestplate.get()).define('X', MysticalSteamAgeItemsRegister.white_hardened_leather.get())
                .pattern("X X").pattern("XXX").pattern("XXX").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.white_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.white_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"white_hardened_leather_chestplate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.white_hardened_leather_helmet.get()).define('X', MysticalSteamAgeItemsRegister.white_hardened_leather.get())
                .pattern("XXX").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.white_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.white_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"white_hardened_leather_helmet"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.white_hardened_leather_leggings.get()).define('X', MysticalSteamAgeItemsRegister.white_hardened_leather.get())
                .pattern("XXX").pattern("X X").pattern("X X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.white_hardened_leather.get()),
                        has(MysticalSteamAgeItemsRegister.white_hardened_leather.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"white_hardened_leather_leggings"));

        devilIronSmithing(consumer, Items.IRON_BOOTS, RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.devil_iron_boots.get());
        devilIronSmithing(consumer, Items.IRON_CHESTPLATE, RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.devil_iron_chestplate.get());
        devilIronSmithing(consumer, Items.IRON_HELMET, RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.devil_iron_helmet.get());
        devilIronSmithing(consumer, Items.IRON_LEGGINGS, RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.devil_iron_leggings.get());

        // Lamps
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.acacia_lamp.get(), 4).define('#', Items.TORCH).define('X', Items.ACACIA_PLANKS)
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"acacia_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.andesite_lamp.get(), 4).define('#', Items.TORCH).define('X', Items.ANDESITE)
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.ANDESITE), has(Items.ANDESITE))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"andesite_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.birch_lamp.get(), 4).define('#', Items.TORCH).define('X', Items.BIRCH_PLANKS)
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"birch_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.cobblestone_lamp.get(), 4).define('#', Items.TORCH).define('X', Items.COBBLESTONE)
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"cobblestone_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.dark_oak_lamp.get(), 4).define('#', Items.TORCH).define('X', Items.DARK_OAK_PLANKS)
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"dark_oak_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.deepslate_lamp.get(), 4).define('#', Items.TORCH).define('X', Items.COBBLED_DEEPSLATE)
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.COBBLED_DEEPSLATE), has(Items.COBBLED_DEEPSLATE))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"deepslate_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.diorite_lamp.get(), 4).define('#', Items.TORCH).define('X', Items.DIORITE)
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.DIORITE), has(Items.DIORITE))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"diorite_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.granite_lamp.get(), 4).define('#', Items.TORCH).define('X', Items.GRANITE)
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.GRANITE), has(Items.GRANITE))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"granite_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.iron_lamp.get(), 4).define('#', Items.TORCH).define('X', Items.IRON_INGOT)
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"iron_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.jungle_lamp.get(), 4).define('#', Items.TORCH).define('X', Items.JUNGLE_PLANKS)
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"jungle_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.marble_black_lamp.get(), 4).define('#', Items.TORCH).define('X',
                        MysticalSteamAgeBlocksRegister.marble.get()).define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX")
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black.get()), has(MysticalSteamAgeBlocksRegister.marble_black.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"marble_black_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.marble_lamp.get(), 4).define('#', Items.TORCH).define('X',
                        MysticalSteamAgeBlocksRegister.marble.get()).define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX")
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble.get()), has(MysticalSteamAgeBlocksRegister.marble.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"marble_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.oak_lamp.get(), 4).define('#', Items.TORCH).define('X', Items.OAK_PLANKS)
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.OAK_PLANKS))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"oak_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.sand_stone_lamp.get(), 4).define('#', Items.TORCH).define('X', Items.SANDSTONE)
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.SANDSTONE), has(Items.SANDSTONE))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"sand_stone_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.spruce_lamp.get(), 4).define('#', Items.TORCH).define('X', Items.SPRUCE_PLANKS)
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"spruce_lamp"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.baobab_lamp.get(), 4).define('#', Items.TORCH)
                .define('X', MysticalSteamAgeBlocksRegister.baobab_planks_item.get())
                .define('O', Items.STICK).pattern("XXX").pattern("O#O").pattern("XXX")
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()), has(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"baobab_lamp"));


        // Food
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.beer.get(), 1).requires(MysticalSteamAgeItemsRegister.empty_beer_glass.get())
                .requires(Items.WATER_BUCKET).requires(Items.WHEAT).unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,"beer"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MysticalSteamAgeItemsRegister.raw_roadie_leg.get()), RecipeCategory.FOOD,
                        MysticalSteamAgeItemsRegister.cooked_roadie_leg.get(), 0.35F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_roadie_leg.get()), has(MysticalSteamAgeItemsRegister.raw_roadie_leg.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "smelting_roadie_leg"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MysticalSteamAgeItemsRegister.raw_roadie_meat.get()), RecipeCategory.FOOD,
                        MysticalSteamAgeItemsRegister.cooked_roadie_meat.get(), 0.35F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_roadie_meat.get()), has(MysticalSteamAgeItemsRegister.raw_roadie_meat.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "smelting_roadie_meat"));

         SimpleCookingRecipeBuilder.smoking(Ingredient.of(MysticalSteamAgeItemsRegister.raw_roadie_leg.get()), RecipeCategory.FOOD,
                         MysticalSteamAgeItemsRegister.cooked_roadie_leg.get(), 0.35F, 200)
                 .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_roadie_leg.get()), has(MysticalSteamAgeItemsRegister.raw_roadie_leg.get()))
                 .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "smoking_roadie_leg"));
         SimpleCookingRecipeBuilder.smoking(Ingredient.of(MysticalSteamAgeItemsRegister.raw_roadie_meat.get()), RecipeCategory.FOOD,
                         MysticalSteamAgeItemsRegister.cooked_roadie_meat.get(), 0.35F, 200)
                 .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_roadie_meat.get()), has(MysticalSteamAgeItemsRegister.raw_roadie_meat.get()))
                 .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "smoking_roadie_meat"));

         SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(MysticalSteamAgeItemsRegister.raw_roadie_leg.get()), RecipeCategory.FOOD,
                         MysticalSteamAgeItemsRegister.cooked_roadie_leg.get(), 0.35F, 200)
                 .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_roadie_leg.get()), has(MysticalSteamAgeItemsRegister.raw_roadie_leg.get()))
                 .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "campfire_roadie_leg"));
         SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(MysticalSteamAgeItemsRegister.raw_roadie_meat.get()), RecipeCategory.FOOD,
                         MysticalSteamAgeItemsRegister.cooked_roadie_meat.get(), 0.35F, 200)
                 .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_roadie_meat.get()), has(MysticalSteamAgeItemsRegister.raw_roadie_meat.get()))
                 .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "campfire_roadie_meat"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.cheese.get(), 1).requires(MysticalSteamAgeItemsRegister.salt_dust.get())
                .requires(MysticalSteamAgeItemsRegister.bottle_milk.get()).unlockedBy(getHasName(MysticalSteamAgeItemsRegister.salt_dust.get()), has(MysticalSteamAgeItemsRegister.salt_dust.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "cheese"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.cheese_bread.get(), 1).requires(MysticalSteamAgeItemsRegister.cheese.get())
                .requires(Items.BREAD).unlockedBy(getHasName(MysticalSteamAgeItemsRegister.cheese.get()), has(MysticalSteamAgeItemsRegister.cheese.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "cheese_bread"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.ham_bread.get(), 1).requires(MysticalSteamAgeItemsRegister.ham.get())
                .requires(Items.BREAD).unlockedBy(getHasName(MysticalSteamAgeItemsRegister.ham.get()), has(MysticalSteamAgeItemsRegister.ham.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "ham_bread"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.dough_bowl_bread.get(), 3).requires(MysticalSteamAgeItemsRegister.meal.get())
                .requires(Items.EGG).requires(Items.WATER_BUCKET).requires(Items.BOWL).unlockedBy(getHasName(MysticalSteamAgeItemsRegister.meal.get()),
                        has(MysticalSteamAgeItemsRegister.meal.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "dough_bowl_bread"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.dough_bowl_potato_bread.get(), 3).requires(MysticalSteamAgeItemsRegister.meal.get())
                .requires(Items.EGG).requires(Items.WATER_BUCKET).requires(Items.BOWL).requires(Items.POTATO).unlockedBy(getHasName(MysticalSteamAgeItemsRegister.meal.get()),
                        has(MysticalSteamAgeItemsRegister.meal.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "dough_bowl_potato_bread"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.dough_bowl_feather_herb_bread.get(), 3).requires(MysticalSteamAgeItemsRegister.meal.get())
                .requires(Items.EGG).requires(Items.WATER_BUCKET).requires(Items.BOWL).requires(MysticalSteamAgeItemsRegister.feather_herb_leaf.get())
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.meal.get()), has(MysticalSteamAgeItemsRegister.meal.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "dough_bowl_feather_herb_bread"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.dough_bowl_pancake.get(), 3).requires(MysticalSteamAgeItemsRegister.meal.get())
                .requires(Items.EGG).requires(Items.EGG).requires(Items.BOWL).requires(Items.HONEY_BOTTLE).requires(MysticalSteamAgeItemsRegister.bottle_milk.get())
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.meal.get()), has(MysticalSteamAgeItemsRegister.meal.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "dough_bowl_pancake"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.dough_bowl_waffle.get(), 3).requires(MysticalSteamAgeItemsRegister.meal.get())
                .requires(Items.EGG).requires(Items.EGG).requires(Items.BOWL).requires(Items.SUGAR).requires(MysticalSteamAgeItemsRegister.bottle_milk.get())
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.meal.get()), has(MysticalSteamAgeItemsRegister.meal.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "dough_bowl_waffle"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.EGG), RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.mirror_egg.get(), 0.35F, 200)
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "mirror_egg"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MysticalSteamAgeItemsRegister.dough_bowl_bread.get()), RecipeCategory.FOOD, Items.BREAD, 0.35F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.dough_bowl_bread.get()), has(MysticalSteamAgeItemsRegister.dough_bowl_bread.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "bread_from_meal"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MysticalSteamAgeItemsRegister.dough_bowl_potato_bread.get()), RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.potato_bread.get(),
                        0.35F, 200).unlockedBy(getHasName(MysticalSteamAgeItemsRegister.dough_bowl_potato_bread.get()),
                        has(MysticalSteamAgeItemsRegister.dough_bowl_potato_bread.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "potato_bread"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MysticalSteamAgeItemsRegister.dough_bowl_pancake.get()), RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.pancake.get(),
                0.35F, 200).unlockedBy(getHasName(MysticalSteamAgeItemsRegister.dough_bowl_pancake.get()),
                has(MysticalSteamAgeItemsRegister.dough_bowl_pancake.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "pancake"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MysticalSteamAgeItemsRegister.dough_bowl_waffle.get()), RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.waffle.get(),
                0.35F, 200).unlockedBy(getHasName(MysticalSteamAgeItemsRegister.dough_bowl_waffle.get()),
                has(MysticalSteamAgeItemsRegister.dough_bowl_waffle.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "waffle"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MysticalSteamAgeItemsRegister.dough_bowl_feather_herb_bread.get()), RecipeCategory.FOOD,
                MysticalSteamAgeItemsRegister.feather_herb_bread.get(), 0.35F, 200).unlockedBy(
                        getHasName(MysticalSteamAgeItemsRegister.dough_bowl_feather_herb_bread.get()), has(MysticalSteamAgeItemsRegister.dough_bowl_feather_herb_bread.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "feather_herb_bread"));

        // TODO currently dummy recipes, must be changed when the mill is implemented
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.meal.get(), 1).requires(Items.WHEAT_SEEDS)
                .unlockedBy(getHasName(Items.WHEAT_SEEDS), has(Items.WHEAT_SEEDS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "meal"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, MysticalSteamAgeItemsRegister.salt_dust.get(), 1).requires(MysticalSteamAgeItemsRegister.raw_salt.get())
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_salt.get()), has(MysticalSteamAgeItemsRegister.raw_salt.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "salt_dust"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MysticalSteamAgeItemsRegister.sulphur_dust.get(), 1).requires(MysticalSteamAgeItemsRegister.raw_sulphur.get())
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_sulphur.get()), has(MysticalSteamAgeItemsRegister.raw_sulphur.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "sulphur_dust"));

        // Marple & Black Marple
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_slab.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.marble.get(), MysticalSteamAgeBlocksRegister.marble_pillar.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble.get()), has(MysticalSteamAgeBlocksRegister.marble.get())).unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_pillar.get()),
                        has(MysticalSteamAgeBlocksRegister.marble_pillar.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_slab"));
        stairBuilder(MysticalSteamAgeBlocksRegister.marble_stairs.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.marble.get(), MysticalSteamAgeBlocksRegister.marble_pillar.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble.get()), has(MysticalSteamAgeBlocksRegister.marble.get())).unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_pillar.get()),
                        has(MysticalSteamAgeBlocksRegister.marble_pillar.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_stairs"));
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_wall.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.marble.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble.get()),
                        has(MysticalSteamAgeBlocksRegister.marble.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_wall"));
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble_slab.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.polished_marble.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.polished_marble.get()),
                        has(MysticalSteamAgeBlocksRegister.polished_marble.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "polished_marble_slab"));
        stairBuilder(MysticalSteamAgeBlocksRegister.polished_marble_stairs.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.polished_marble.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.polished_marble.get()),
                        has(MysticalSteamAgeBlocksRegister.polished_marble.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "polished_marble_stairs"));
        polishedBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.marble.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble.get()),
                        has(MysticalSteamAgeBlocksRegister.marble.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "polished_marble"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_pillar.get(), 2).define('#', MysticalSteamAgeBlocksRegister.marble.get()).pattern("#").pattern("#")
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble.get()), has(MysticalSteamAgeBlocksRegister.marble.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_pillar"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_brick.get(), 4).define('#', MysticalSteamAgeBlocksRegister.polished_marble.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.polished_marble.get()), has(MysticalSteamAgeBlocksRegister.polished_marble.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_brick"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MysticalSteamAgeBlocksRegister.marble_brick.get()), RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_bricks_slab.get(), 2)
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_brick.get()), has(MysticalSteamAgeBlocksRegister.marble_brick.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(MysticalSteamAgeBlocksRegister.marble_bricks_slab.get(),
                                MysticalSteamAgeBlocksRegister.marble_brick.get()) + "_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MysticalSteamAgeBlocksRegister.marble_brick.get()), RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_bricks_stairs.get())
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_brick.get()), has(MysticalSteamAgeBlocksRegister.marble_brick.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(MysticalSteamAgeBlocksRegister.marble_bricks_stairs.get(),
                        MysticalSteamAgeBlocksRegister.marble_brick.get()) + "_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MysticalSteamAgeBlocksRegister.marble_brick.get()), RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_bricks_wall.get())
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_brick.get()), has(MysticalSteamAgeBlocksRegister.marble_brick.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(MysticalSteamAgeBlocksRegister.marble_bricks_wall.get(),
                        MysticalSteamAgeBlocksRegister.marble_brick.get()) + "_stonecutting"));
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_bricks_slab.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.marble_brick.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_brick.get()),
                has(MysticalSteamAgeBlocksRegister.marble_brick.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_bricks_slab"));
        stairBuilder(MysticalSteamAgeBlocksRegister.marble_bricks_stairs.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.marble_brick.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_brick.get()),
                has(MysticalSteamAgeBlocksRegister.marble_brick.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_bricks_stairs"));
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_bricks_wall.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.marble.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble.get()),
                has(MysticalSteamAgeBlocksRegister.marble.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_bricks_wall"));
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_pillar.get(),  MysticalSteamAgeBlocksRegister.marble.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_slab.get(),  MysticalSteamAgeBlocksRegister.marble.get(),2);
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_stairs.get(),  MysticalSteamAgeBlocksRegister.marble.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_wall.get(),  MysticalSteamAgeBlocksRegister.marble.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble.get(),  MysticalSteamAgeBlocksRegister.marble.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble_slab.get(),  MysticalSteamAgeBlocksRegister.marble.get(), 2);
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble_stairs.get(),  MysticalSteamAgeBlocksRegister.marble.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_brick.get(), MysticalSteamAgeBlocksRegister.marble.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_bricks_slab.get(), MysticalSteamAgeBlocksRegister.marble.get(), 2);
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_bricks_stairs.get(), MysticalSteamAgeBlocksRegister.marble.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_bricks_wall.get(), MysticalSteamAgeBlocksRegister.marble.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble_slab.get(),  MysticalSteamAgeBlocksRegister.polished_marble.get(), 2);
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble_stairs.get(),  MysticalSteamAgeBlocksRegister.polished_marble.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_brick.get(), MysticalSteamAgeBlocksRegister.polished_marble.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_bricks_slab.get(), MysticalSteamAgeBlocksRegister.polished_marble.get(), 2);
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_bricks_stairs.get(), MysticalSteamAgeBlocksRegister.polished_marble.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_bricks_wall.get(), MysticalSteamAgeBlocksRegister.polished_marble.get());
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_slab.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.marble_black.get(),
                MysticalSteamAgeBlocksRegister.marble_black_pillar.get())).unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black.get()),
                has(MysticalSteamAgeBlocksRegister.marble_black.get())).unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black_pillar.get()),
                has(MysticalSteamAgeBlocksRegister.marble_black_pillar.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_black_slab"));
        stairBuilder(MysticalSteamAgeBlocksRegister.marble_black_stairs.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.marble_black.get(),
                MysticalSteamAgeBlocksRegister.marble_black_pillar.get())).unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black.get()),
                has(MysticalSteamAgeBlocksRegister.marble_black.get())).unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black_pillar.get()),
                has(MysticalSteamAgeBlocksRegister.marble_black_pillar.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_black_stairs"));
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_wall.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.marble_black.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black.get()),
                        has(MysticalSteamAgeBlocksRegister.marble_black.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_black_wall"));
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble_black_slab.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.polished_marble_black.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.polished_marble_black.get()), has(MysticalSteamAgeBlocksRegister.polished_marble_black.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "polished_marble_black_slab"));
        stairBuilder(MysticalSteamAgeBlocksRegister.polished_marble_black_stairs.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.polished_marble_black.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.polished_marble_black.get()), has(MysticalSteamAgeBlocksRegister.polished_marble_black.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "polished_marble_black_stairs"));
        polishedBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble_black.get(),Ingredient.of(MysticalSteamAgeBlocksRegister.marble_black.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black.get()),
                        has(MysticalSteamAgeBlocksRegister.marble_black.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "polished_marble_black"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_pillar.get(), 2).define('#', MysticalSteamAgeBlocksRegister.marble_black.get()).pattern("#").pattern("#")
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black.get()), has(MysticalSteamAgeBlocksRegister.marble_black.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_black_pillar"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_brick.get(), 4).define('#', MysticalSteamAgeBlocksRegister.polished_marble_black.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.polished_marble_black.get()), has(MysticalSteamAgeBlocksRegister.polished_marble_black.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_black_brick"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MysticalSteamAgeBlocksRegister.marble_black_brick.get()), RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_bricks_slab.get(), 2)
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black_brick.get()), has(MysticalSteamAgeBlocksRegister.marble_black_brick.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(MysticalSteamAgeBlocksRegister.marble_black_bricks_slab.get(),
                        MysticalSteamAgeBlocksRegister.marble_black_brick.get()) + "_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MysticalSteamAgeBlocksRegister.marble_black_brick.get()), RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_bricks_stairs.get())
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black_brick.get()), has(MysticalSteamAgeBlocksRegister.marble_black_brick.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(MysticalSteamAgeBlocksRegister.marble_black_bricks_stairs.get(),
                        MysticalSteamAgeBlocksRegister.marble_black_brick.get()) + "_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MysticalSteamAgeBlocksRegister.marble_black_brick.get()), RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_bricks_wall.get())
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black_brick.get()), has(MysticalSteamAgeBlocksRegister.marble_black_brick.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(MysticalSteamAgeBlocksRegister.marble_black_bricks_wall.get(),
                        MysticalSteamAgeBlocksRegister.marble_black_brick.get()) + "_stonecutting"));
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_bricks_slab.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.marble_black_brick.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black_brick.get()),  has(MysticalSteamAgeBlocksRegister.marble_black_brick.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_black_bricks_slab"));
        stairBuilder(MysticalSteamAgeBlocksRegister.marble_black_bricks_stairs.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.marble_black_brick.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black_brick.get()),  has(MysticalSteamAgeBlocksRegister.marble_black_brick.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_black_bricks_stairs"));
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_bricks_wall.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.marble_black.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.marble_black.get()),
                        has(MysticalSteamAgeBlocksRegister.marble_black.get())).save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "marble_black_bricks_wall"));
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_pillar.get(),  MysticalSteamAgeBlocksRegister.marble_black.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_slab.get(),  MysticalSteamAgeBlocksRegister.marble_black.get(),2);
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_stairs.get(),  MysticalSteamAgeBlocksRegister.marble_black.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_wall.get(),  MysticalSteamAgeBlocksRegister.marble_black.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble_black.get(),  MysticalSteamAgeBlocksRegister.marble_black.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble_black_slab.get(),  MysticalSteamAgeBlocksRegister.marble_black.get(), 2);
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble_black_stairs.get(),  MysticalSteamAgeBlocksRegister.marble_black.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_brick.get(), MysticalSteamAgeBlocksRegister.marble_black.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_bricks_slab.get(), MysticalSteamAgeBlocksRegister.marble_black.get(), 2);
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_bricks_stairs.get(), MysticalSteamAgeBlocksRegister.marble_black.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_bricks_wall.get(), MysticalSteamAgeBlocksRegister.marble_black.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble_black_slab.get(),  MysticalSteamAgeBlocksRegister.polished_marble_black.get(), 2);
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.polished_marble_black_stairs.get(),  MysticalSteamAgeBlocksRegister.polished_marble_black.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_brick.get(), MysticalSteamAgeBlocksRegister.polished_marble_black.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_bricks_slab.get(), MysticalSteamAgeBlocksRegister.polished_marble_black.get(), 2);
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_bricks_stairs.get(), MysticalSteamAgeBlocksRegister.polished_marble_black.get());
        stoneCutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.marble_black_bricks_wall.get(), MysticalSteamAgeBlocksRegister.polished_marble_black.get());

        // Carpenter Workbench
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.carpenter_workbench.get()).define('#', Ingredient.of(ItemTags.PLANKS))
                .define('X', Ingredient.of(MysticalSteamAgeBlocksRegister.wardrobe_item_tag)).define('I', Items.IRON_INGOT)
                .pattern("  I").pattern("#X#").pattern("# #").unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "carpenter_workbench"));

        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.OAK_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.OAK_SLAB, 2)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.OAK_SLAB, Items.OAK_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.ACACIA_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_SLAB, 2)
                .unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.ACACIA_SLAB, Items.ACACIA_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.BIRCH_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_SLAB, 2)
                .unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.BIRCH_SLAB, Items.BIRCH_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.DARK_OAK_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_SLAB, 2)
                .unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.DARK_OAK_SLAB, Items.DARK_OAK_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.JUNGLE_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_SLAB, 2)
                .unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.JUNGLE_SLAB, Items.JUNGLE_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.SPRUCE_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_SLAB, 2)
                .unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.SPRUCE_SLAB, Items.SPRUCE_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.CRIMSON_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_SLAB, 2)
                .unlockedBy(getHasName(Items.CRIMSON_PLANKS), has(Items.CRIMSON_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.CRIMSON_SLAB, Items.CRIMSON_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.WARPED_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.WARPED_SLAB, 2)
                .unlockedBy(getHasName(Items.WARPED_PLANKS), has(Items.WARPED_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.WARPED_SLAB, Items.WARPED_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()), RecipeCategory.BUILDING_BLOCKS,
                        MysticalSteamAgeBlocksRegister.baobab_slab_item.get(), 2)
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()), has(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(MysticalSteamAgeBlocksRegister.baobab_slab_item.get(),
                        MysticalSteamAgeBlocksRegister.baobab_planks_item.get()) + "_carpenter_workbench"));

        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.OAK_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.OAK_STAIRS)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.OAK_STAIRS, Items.OAK_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.ACACIA_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_STAIRS)
                .unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.ACACIA_STAIRS, Items.ACACIA_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.BIRCH_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_STAIRS)
                .unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.BIRCH_STAIRS, Items.BIRCH_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.DARK_OAK_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_STAIRS)
                .unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.DARK_OAK_STAIRS, Items.DARK_OAK_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.JUNGLE_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_STAIRS)
                .unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.JUNGLE_STAIRS, Items.JUNGLE_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.SPRUCE_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_STAIRS)
                .unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.SPRUCE_STAIRS, Items.SPRUCE_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.CRIMSON_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_STAIRS)
                .unlockedBy(getHasName(Items.CRIMSON_PLANKS), has(Items.CRIMSON_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.CRIMSON_STAIRS, Items.CRIMSON_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.WARPED_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.WARPED_STAIRS)
                .unlockedBy(getHasName(Items.WARPED_PLANKS), has(Items.WARPED_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.WARPED_STAIRS, Items.WARPED_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()), RecipeCategory.BUILDING_BLOCKS,
                        MysticalSteamAgeBlocksRegister.baobab_stairs_item.get())
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()), has(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(MysticalSteamAgeBlocksRegister.baobab_stairs_item.get(),
                        MysticalSteamAgeBlocksRegister.baobab_planks_item.get()) + "_carpenter_workbench"));


        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.OAK_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.OAK_FENCE)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.OAK_FENCE, Items.OAK_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.ACACIA_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_FENCE)
                .unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.ACACIA_FENCE, Items.ACACIA_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.BIRCH_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_FENCE)
                .unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.BIRCH_FENCE, Items.BIRCH_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.DARK_OAK_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_FENCE)
                .unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.DARK_OAK_FENCE, Items.DARK_OAK_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.JUNGLE_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_FENCE)
                .unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.JUNGLE_FENCE, Items.JUNGLE_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.SPRUCE_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_FENCE)
                .unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.SPRUCE_FENCE, Items.SPRUCE_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.CRIMSON_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_FENCE)
                .unlockedBy(getHasName(Items.CRIMSON_PLANKS), has(Items.CRIMSON_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.CRIMSON_FENCE, Items.CRIMSON_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.WARPED_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.WARPED_FENCE)
                .unlockedBy(getHasName(Items.WARPED_PLANKS), has(Items.WARPED_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.WARPED_FENCE, Items.WARPED_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()), RecipeCategory.BUILDING_BLOCKS,
                        MysticalSteamAgeBlocksRegister.baobab_fence_item.get())
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()), has(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(MysticalSteamAgeBlocksRegister.baobab_fence_item.get(),
                        MysticalSteamAgeBlocksRegister.baobab_planks_item.get()) + "_carpenter_workbench"));

        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.OAK_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.OAK_FENCE_GATE)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.OAK_FENCE_GATE, Items.OAK_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.ACACIA_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_FENCE_GATE)
                .unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.ACACIA_FENCE_GATE, Items.ACACIA_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.BIRCH_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_FENCE_GATE)
                .unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.BIRCH_FENCE_GATE, Items.BIRCH_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.DARK_OAK_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_FENCE_GATE)
                .unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.DARK_OAK_FENCE_GATE, Items.DARK_OAK_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.JUNGLE_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_FENCE_GATE)
                .unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.JUNGLE_FENCE_GATE, Items.JUNGLE_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.SPRUCE_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_FENCE_GATE)
                .unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.SPRUCE_FENCE_GATE, Items.SPRUCE_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.CRIMSON_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_FENCE_GATE)
                .unlockedBy(getHasName(Items.CRIMSON_PLANKS), has(Items.CRIMSON_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.CRIMSON_FENCE_GATE, Items.CRIMSON_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.WARPED_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.WARPED_FENCE_GATE)
                .unlockedBy(getHasName(Items.WARPED_PLANKS), has(Items.WARPED_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.WARPED_FENCE_GATE, Items.WARPED_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()), RecipeCategory.BUILDING_BLOCKS,
                        MysticalSteamAgeBlocksRegister.baobab_fence_gate_item.get())
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()), has(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(MysticalSteamAgeBlocksRegister.baobab_fence_gate_item.get(),
                        MysticalSteamAgeBlocksRegister.baobab_planks_item.get()) + "_carpenter_workbench"));

        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.OAK_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.OAK_BUTTON)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.OAK_BUTTON, Items.OAK_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.ACACIA_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_BUTTON)
                .unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.ACACIA_BUTTON, Items.ACACIA_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.BIRCH_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_BUTTON)
                .unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.BIRCH_BUTTON, Items.BIRCH_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.DARK_OAK_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_BUTTON)
                .unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.DARK_OAK_BUTTON, Items.DARK_OAK_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.JUNGLE_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_BUTTON)
                .unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.JUNGLE_BUTTON, Items.JUNGLE_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.SPRUCE_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_BUTTON)
                .unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.SPRUCE_BUTTON, Items.SPRUCE_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.CRIMSON_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_BUTTON)
                .unlockedBy(getHasName(Items.CRIMSON_PLANKS), has(Items.CRIMSON_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.CRIMSON_BUTTON, Items.CRIMSON_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.WARPED_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.WARPED_BUTTON)
                .unlockedBy(getHasName(Items.WARPED_PLANKS), has(Items.WARPED_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.WARPED_BUTTON, Items.WARPED_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks.get()), RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_button.get())
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks.get()), has(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(MysticalSteamAgeBlocksRegister.baobab_button.get(),
                        MysticalSteamAgeBlocksRegister.baobab_planks.get()) + "_carpenter_workbench"));

        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.OAK_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.OAK_DOOR)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.OAK_DOOR, Items.OAK_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.ACACIA_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.ACACIA_DOOR)
                .unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.ACACIA_DOOR, Items.ACACIA_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.BIRCH_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.BIRCH_DOOR)
                .unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.BIRCH_DOOR, Items.BIRCH_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.DARK_OAK_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.DARK_OAK_DOOR)
                .unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.DARK_OAK_DOOR, Items.DARK_OAK_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.JUNGLE_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.JUNGLE_DOOR)
                .unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.JUNGLE_DOOR, Items.JUNGLE_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.SPRUCE_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.SPRUCE_DOOR)
                .unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.SPRUCE_DOOR, Items.SPRUCE_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.CRIMSON_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.CRIMSON_DOOR)
                .unlockedBy(getHasName(Items.CRIMSON_PLANKS), has(Items.CRIMSON_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.CRIMSON_DOOR, Items.CRIMSON_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(Items.WARPED_PLANKS), RecipeCategory.BUILDING_BLOCKS, Items.WARPED_DOOR)
                .unlockedBy(getHasName(Items.WARPED_PLANKS), has(Items.WARPED_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(Items.WARPED_DOOR, Items.WARPED_PLANKS) + "_carpenter_workbench"));
        CarpenterWorkbenchRecipeBuilder.woodCutting(Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks.get()), RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_door_item.get())
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks.get()), has(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getConversionRecipeName(MysticalSteamAgeBlocksRegister.baobab_door_item.get(),
                        MysticalSteamAgeBlocksRegister.baobab_planks.get()) + "_carpenter_workbench"));
        // Baobab Stuff
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_planks.get(), 4).requires(MysticalSteamAgeBlocksRegister.baobab_log.get())
                .group("planks").unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_log.get()), has(MysticalSteamAgeBlocksRegister.baobab_log.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_planks"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_wood.get(), 3).define('#', MysticalSteamAgeBlocksRegister.baobab_log.get())
                .pattern("##").pattern("##").group("bark").unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_log.get()), has(MysticalSteamAgeBlocksRegister.baobab_log.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_wood"));
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_slab.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks.get()),  has(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_slab"));
        stairBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_stairs.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks.get()),  has(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_stairs"));
        buttonBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_button.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks.get()),  has(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_button"));
        doorBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_door.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks.get()),  has(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_door"));
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_pressure_plate.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks.get()),  has(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_pressure_plate"));
        trapdoorBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_trapdoor.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks.get()),  has(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_trapdoor"));
        fenceBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_fence.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks.get()),  has(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_fence"));
        fenceGateBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_fence_gate.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks.get()),  has(MysticalSteamAgeBlocksRegister.baobab_planks.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_fence_gate"));

        // Studded Wood Doors
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.studded_wooden_door_1.get(), 3)
                .define('#', Ingredient.of(MysticalSteamAgeBlocksRegister.iron_studded_wood_item_tag)).define('X', Items.GLASS)
                .pattern("XX").pattern("##").pattern("##").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.iron_nail.get()),
                        has(MysticalSteamAgeItemsRegister.iron_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "studded_wooden_door_1"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.studded_wooden_door_2.get(), 3)
                .define('#', Ingredient.of(MysticalSteamAgeBlocksRegister.iron_studded_wood_item_tag))
                .pattern("##").pattern("##").pattern("##").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.iron_nail.get()),
                        has(MysticalSteamAgeItemsRegister.iron_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "studded_wooden_door_2"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.studded_wooden_door_3.get(), 3)
                .define('#', Ingredient.of(MysticalSteamAgeBlocksRegister.iron_studded_wood_item_tag)).define('X', Items.IRON_BARS)
                .pattern("XX").pattern("##").pattern("##").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.iron_nail.get()),
                        has(MysticalSteamAgeItemsRegister.iron_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "studded_wooden_door_3"));

        // Studded Wood
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.acacia_iron_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.iron_nail.get())
                .define('X', Items.ACACIA_PLANKS)
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.iron_nail.get()),
                        has(MysticalSteamAgeItemsRegister.iron_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "acacia_iron_studded_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.birch_iron_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.iron_nail.get())
                .define('X', Items.BIRCH_PLANKS)
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.iron_nail.get()),
                        has(MysticalSteamAgeItemsRegister.iron_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "birch_iron_studded_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.dark_oak_iron_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.iron_nail.get())
                .define('X', Items.DARK_OAK_PLANKS)
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.iron_nail.get()),
                        has(MysticalSteamAgeItemsRegister.iron_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "dark_oak_iron_studded_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.jungle_iron_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.iron_nail.get())
                .define('X', Items.JUNGLE_PLANKS)
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.iron_nail.get()),
                        has(MysticalSteamAgeItemsRegister.iron_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "jungle_iron_studded_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.oak_iron_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.iron_nail.get())
                .define('X', Items.OAK_PLANKS)
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.iron_nail.get()),
                        has(MysticalSteamAgeItemsRegister.iron_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "oak_iron_studded_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.spruce_iron_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.iron_nail.get())
                .define('X', Items.SPRUCE_PLANKS)
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.iron_nail.get()),
                        has(MysticalSteamAgeItemsRegister.iron_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "spruce_iron_studded_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_iron_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.iron_nail.get())
                .define('X', MysticalSteamAgeBlocksRegister.baobab_planks_item.get())
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.iron_nail.get()),
                        has(MysticalSteamAgeItemsRegister.iron_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_iron_studded_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.acacia_gold_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.gold_nail.get())
                .define('X', Items.ACACIA_PLANKS)
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.gold_nail.get()),
                        has(MysticalSteamAgeItemsRegister.gold_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "acacia_gold_studded_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.birch_gold_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.gold_nail.get())
                .define('X', Items.BIRCH_PLANKS)
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.gold_nail.get()),
                        has(MysticalSteamAgeItemsRegister.gold_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "birch_gold_studded_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.dark_oak_gold_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.gold_nail.get())
                .define('X', Items.DARK_OAK_PLANKS)
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.gold_nail.get()),
                        has(MysticalSteamAgeItemsRegister.gold_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "dark_oak_gold_studded_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.jungle_gold_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.gold_nail.get())
                .define('X', Items.JUNGLE_PLANKS)
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.gold_nail.get()),
                        has(MysticalSteamAgeItemsRegister.gold_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "jungle_gold_studded_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.oak_gold_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.gold_nail.get())
                .define('X', Items.OAK_PLANKS)
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.gold_nail.get()),
                        has(MysticalSteamAgeItemsRegister.gold_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "oak_gold_studded_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.spruce_gold_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.gold_nail.get())
                .define('X', Items.SPRUCE_PLANKS)
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.gold_nail.get()),
                        has(MysticalSteamAgeItemsRegister.gold_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "spruce_gold_studded_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_gold_studded_block.get(), 6)
                .define('#', MysticalSteamAgeItemsRegister.gold_nail.get())
                .define('X', MysticalSteamAgeBlocksRegister.baobab_planks_item.get())
                .pattern("X#X").pattern("X#X").pattern("X#X").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.gold_nail.get()),
                        has(MysticalSteamAgeItemsRegister.gold_nail.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_gold_studded_block"));

        // Studded Wood Pressure Plates
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.acacia_studded_pressure_plate.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.acacia_iron_studded_block.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.acacia_iron_studded_block.get()),  has(MysticalSteamAgeBlocksRegister.acacia_iron_studded_block.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "acacia_studded_pressure_plate"));
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.baobab_studded_pressure_plate.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.baobab_iron_studded_block.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_iron_studded_block.get()),  has(MysticalSteamAgeBlocksRegister.baobab_iron_studded_block.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_studded_pressure_plate"));
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.birch_studded_pressure_plate.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.birch_iron_studded_block.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.birch_iron_studded_block.get()),  has(MysticalSteamAgeBlocksRegister.birch_iron_studded_block.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "birch_studded_pressure_plate"));
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.dark_oak_studded_pressure_plate.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.dark_oak_iron_studded_block.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.dark_oak_iron_studded_block.get()),  has(MysticalSteamAgeBlocksRegister.dark_oak_iron_studded_block.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "dark_oak_studded_pressure_plate"));
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.jungle_studded_pressure_plate.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.jungle_iron_studded_block.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.jungle_iron_studded_block.get()),  has(MysticalSteamAgeBlocksRegister.jungle_iron_studded_block.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "jungle_studded_pressure_plate"));
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.oak_studded_pressure_plate.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.oak_iron_studded_block.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.oak_iron_studded_block.get()),  has(MysticalSteamAgeBlocksRegister.oak_iron_studded_block.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "oak_studded_pressure_plate"));
        pressurePlateBuilder(RecipeCategory.BUILDING_BLOCKS, MysticalSteamAgeBlocksRegister.spruce_studded_pressure_plate.get(), Ingredient.of(MysticalSteamAgeBlocksRegister.spruce_iron_studded_block.get()))
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.spruce_iron_studded_block.get()),  has(MysticalSteamAgeBlocksRegister.spruce_iron_studded_block.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "spruce_studded_pressure_plate"));

        // Flowers
        oneToOneConversionRecipe(consumer, RecipeCategory.MISC, Items.ORANGE_DYE, MysticalSteamAgeBlocksRegister.fire_flower.get(), "orange_dye");
        oneToOneConversionRecipe(consumer, RecipeCategory.MISC, Items.ORANGE_DYE, MysticalSteamAgeBlocksRegister.fire_bush.get(), "orange_dye", 2);
        oneToOneConversionRecipe(consumer, RecipeCategory.MISC, Items.CYAN_DYE, MysticalSteamAgeBlocksRegister.irrlicht.get(), "cyan_dye");
        oneToOneConversionRecipe(consumer, RecipeCategory.MISC, Items.LIGHT_BLUE_DYE, MysticalSteamAgeBlocksRegister.cloud_bush.get(), "light_blue_dye", 2);
        oneToOneConversionRecipe(consumer, RecipeCategory.MISC, Items.LIGHT_BLUE_DYE, MysticalSteamAgeBlocksRegister.ice_flower.get(), "light_blue_dye");
        oneToOneConversionRecipe(consumer, RecipeCategory.MISC, Items.MAGENTA_DYE, MysticalSteamAgeBlocksRegister.dust_flower.get(), "magenta_dye");
        oneToOneConversionRecipe(consumer, RecipeCategory.MISC, Items.PURPLE_DYE, MysticalSteamAgeBlocksRegister.pink_fern.get(), "purple_dye");
        oneToOneConversionRecipe(consumer, RecipeCategory.MISC, Items.PINK_DYE, MysticalSteamAgeBlocksRegister.white_rose.get(), "pink_dye");
        oneToOneConversionRecipe(consumer, RecipeCategory.MISC, Items.PURPLE_DYE, MysticalSteamAgeBlocksRegister.purple_rose.get(), "purple_dye");
        oneToOneConversionRecipe(consumer, RecipeCategory.MISC, Items.BLACK_DYE, MysticalSteamAgeBlocksRegister.shadow_fern.get(), "black_dye", 2);
        oneToOneConversionRecipe(consumer, RecipeCategory.MISC, Items.LIGHT_BLUE_DYE, MysticalSteamAgeBlocksRegister.silver_umbrella.get(), "light_blue_dye", 2);
        oneToOneConversionRecipe(consumer, RecipeCategory.MISC, Items.GLOWSTONE_DUST, MysticalSteamAgeBlocksRegister.star_flower.get(), "glowstone_dust");

        // Wardrobe
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.oak_wardrobe.get(), 2).define('#', Items.STICK)
                .define('X', Items.OAK_PLANKS).define('O', Items.OAK_TRAPDOOR)
                .pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "oak_wardrobe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.spruce_wardrobe.get(), 2).define('#', Items.STICK)
                .define('X', Items.SPRUCE_PLANKS).define('O', Items.SPRUCE_TRAPDOOR)
                .pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.SPRUCE_PLANKS), has(Items.SPRUCE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "spruce_wardrobe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.birch_wardrobe.get(), 2).define('#', Items.STICK)
                .define('X', Items.BIRCH_PLANKS).define('O', Items.BIRCH_TRAPDOOR)
                .pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.BIRCH_PLANKS), has(Items.BIRCH_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "birch_wardrobe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.jungle_wardrobe.get(), 2).define('#', Items.STICK)
                .define('X', Items.JUNGLE_PLANKS).define('O', Items.JUNGLE_TRAPDOOR)
                .pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.JUNGLE_PLANKS), has(Items.JUNGLE_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "jungle_wardrobe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.acacia_wardrobe.get(), 2).define('#', Items.STICK)
                .define('X', Items.ACACIA_PLANKS).define('O', Items.ACACIA_TRAPDOOR)
                .pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.ACACIA_PLANKS), has(Items.ACACIA_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "acacia_wardrobe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.dark_oak_wardrobe.get(), 2).define('#', Items.STICK)
                .define('X', Items.DARK_OAK_PLANKS).define('O', Items.DARK_OAK_TRAPDOOR)
                .pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(Items.DARK_OAK_PLANKS), has(Items.DARK_OAK_PLANKS))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "dark_oak_wardrobe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.baobab_wardrobe.get(), 2).define('#', Items.STICK)
                .define('X', MysticalSteamAgeBlocksRegister.baobab_planks_item.get()).define('O', MysticalSteamAgeBlocksRegister.baobab_trapdoor_item.get())
                .pattern("XXX").pattern("O#O").pattern("XXX").unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()),
                        has(MysticalSteamAgeBlocksRegister.baobab_planks_item.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "baobab_wardrobe"));

        // Axes
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.copper_axe.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_COPPER)
                .pattern("XX").pattern("X#").pattern(" #").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "copper_axe"));
        devilIronSmithing(consumer, Items.IRON_AXE, RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.devil_iron_axe.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.flint_axe.get()).define('#', Items.STICK).define('X', Items.FLINT)
                .pattern("XX").pattern("X#").pattern(" #").unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "flint_axe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.netherrack_axe.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_NETHER_BRICK)
                .pattern("XX").pattern("X#").pattern(" #").unlockedBy(getHasName(Items.NETHER_BRICK), has(Items.NETHER_BRICK))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "netherrack_axe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.steel_axe.get()).define('#', Items.STICK).define('X',
                        MysticalSteamAgeItemsRegister.steel_ingot_tag).pattern("XX").pattern("X#").pattern(" #")
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.steel_ingot.get()), has(MysticalSteamAgeItemsRegister.steel_ingot.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "steel_axe"));

        // Hoes
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.copper_hoe.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_COPPER)
                .pattern("XX").pattern(" #").pattern(" #").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "copper_hoe"));
        devilIronSmithing(consumer, Items.IRON_HOE, RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.devil_iron_hoe.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.flint_hoe.get()).define('#', Items.STICK).define('X', Items.FLINT)
                .pattern("XX").pattern(" #").pattern(" #").unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "flint_hoe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.netherrack_hoe.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_NETHER_BRICK)
                .pattern("XX").pattern(" #").pattern(" #").unlockedBy(getHasName(Items.NETHER_BRICK), has(Items.NETHER_BRICK))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "netherrack_hoe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.steel_hoe.get()).define('#', Items.STICK).define('X',
                        MysticalSteamAgeItemsRegister.steel_ingot_tag).pattern("XX").pattern(" #").pattern(" #")
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.steel_ingot.get()), has(MysticalSteamAgeItemsRegister.steel_ingot.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "steel_hoe"));

        // Pickaxes
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.copper_pickaxe.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_COPPER)
                .pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "copper_pickaxe"));
        devilIronSmithing(consumer, Items.IRON_PICKAXE, RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.devil_iron_pickaxe.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.flint_pickaxe.get()).define('#', Items.STICK).define('X', Items.FLINT)
                .pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "flint_pickaxe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.netherrack_pickaxe.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_NETHER_BRICK)
                .pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy(getHasName(Items.NETHER_BRICK), has(Items.NETHER_BRICK))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "netherrack_pickaxe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.steel_pickaxe.get()).define('#', Items.STICK).define('X',
                        MysticalSteamAgeItemsRegister.steel_ingot_tag).pattern("XXX").pattern(" # ").pattern(" # ")
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.steel_ingot.get()), has(MysticalSteamAgeItemsRegister.steel_ingot.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "steel_pickaxe"));

        // Shovels
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.copper_shovel.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_COPPER)
                .pattern("X").pattern("#").pattern("#").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "copper_shovel"));
        devilIronSmithing(consumer, Items.IRON_SHOVEL, RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.devil_iron_shovel.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.flint_shovel.get()).define('#', Items.STICK).define('X', Items.FLINT)
                .pattern("X").pattern("#").pattern("#").unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "flint_shovel"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.netherrack_shovel.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_NETHER_BRICK)
                .pattern("X").pattern("#").pattern("#").unlockedBy(getHasName(Items.NETHER_BRICK), has(Items.NETHER_BRICK))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "netherrack_shovel"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MysticalSteamAgeItemsRegister.steel_shovel.get()).define('#', Items.STICK).define('X',
                        MysticalSteamAgeItemsRegister.steel_ingot_tag).pattern("X").pattern("#").pattern("#")
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.steel_ingot.get()), has(MysticalSteamAgeItemsRegister.steel_ingot.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "steel_shovel"));

        // Swords
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.copper_sword.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_COPPER)
                .pattern("X").pattern("X").pattern("#").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "copper_sword"));
        devilIronSmithing(consumer, Items.IRON_SWORD, RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.devil_iron_sword.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.netherrack_sword.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_NETHER_BRICK)
                .pattern("X").pattern("X").pattern("#").unlockedBy(getHasName(Items.NETHER_BRICK), has(Items.NETHER_BRICK))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "netherrack_sword"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.steel_sword.get()).define('#', Items.STICK).define('X',
                        MysticalSteamAgeItemsRegister.steel_ingot_tag).pattern("X").pattern("X").pattern("#")
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.steel_ingot.get()), has(MysticalSteamAgeItemsRegister.steel_ingot.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "steel_sword"));

        // War Axes
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.copper_war_axe.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_COPPER)
                .pattern("XXX").pattern("X#X").pattern(" # ").unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "copper_war_axe"));
        devilIronSmithing(consumer, MysticalSteamAgeItemsRegister.iron_war_axe.get(), RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.devil_iron_war_axe.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.diamond_war_axe.get()).define('#', Items.STICK).define('X', Tags.Items.GEMS_DIAMOND)
                .pattern("XXX").pattern("X#X").pattern(" # ").unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "diamond_war_axe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.gold_war_axe.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_GOLD)
                .pattern("XXX").pattern("X#X").pattern(" # ").unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "gold_war_axe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.iron_war_axe.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_IRON)
                .pattern("XXX").pattern("X#X").pattern(" # ").unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "iron_war_axe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.netherrack_war_axe.get()).define('#', Items.STICK).define('X', Tags.Items.INGOTS_NETHER_BRICK)
                .pattern("XXX").pattern("X#X").pattern(" # ").unlockedBy(getHasName(Items.NETHER_BRICK), has(Items.NETHER_BRICK))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "netherrack_war_axe"));
        netheriteSmithing(consumer, MysticalSteamAgeItemsRegister.diamond_war_axe.get(), RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.netherite_war_axe.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.steel_war_axe.get()).define('#', Items.STICK).define('X', MysticalSteamAgeItemsRegister.steel_ingot_tag)
                .pattern("XXX").pattern("X#X").pattern(" # ").unlockedBy(getHasName(MysticalSteamAgeItemsRegister.steel_ingot.get()), has(MysticalSteamAgeItemsRegister.steel_ingot.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "steel_war_axe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.stone_war_axe.get()).define('#', Items.STICK).define('X', Items.STONE)
                .pattern("XXX").pattern("X#X").pattern(" # ").unlockedBy(getHasName(Items.STONE), has(Items.STONE))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "stone_war_axe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.wood_war_axe.get()).define('#', Items.STICK).define('X', ItemTags.PLANKS)
                .pattern("XXX").pattern("X#X").pattern(" # ").unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "wood_war_axe"));

        // Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.roadie_leather_armor.get()).define('#', Tags.Items.LEATHER)
                .pattern("  #").pattern("###").pattern(" # ").unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "roadie_leather_armor"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.roadie_gold_armor.get()).define('#', Tags.Items.INGOTS_GOLD)
                .pattern("  #").pattern("###").pattern(" # ").unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "roadie_gold_armor"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.roadie_iron_armor.get()).define('#', Tags.Items.INGOTS_IRON)
                .pattern("  #").pattern("###").pattern(" # ").unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "roadie_iron_armor"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MysticalSteamAgeItemsRegister.roadie_diamond_armor.get()).define('#', Tags.Items.GEMS_DIAMOND)
                .pattern("  #").pattern("###").pattern(" # ").unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "roadie_diamond_armor"));

        // Double Furnace
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MysticalSteamAgeBlocksRegister.double_furnace.get()).define('#', Blocks.SMOOTH_STONE).define('X', Blocks.FURNACE)
                .define('I', Items.IRON_INGOT).pattern("IXI").pattern("IXI").pattern("###").unlockedBy(getHasName(Blocks.SMOOTH_STONE), has(Blocks.SMOOTH_STONE))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "double_furnace"));

        // bronze_ingot with INGOTS_COPPER
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"bronze_ingot", Tags.Items.INGOTS_COPPER, 3, MysticalSteamAgeItemsRegister.tin_ingot_tag, 1,
                        MysticalSteamAgeItemsRegister.bronze_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.tin_ingot.get()), has(MysticalSteamAgeItemsRegister.tin_ingot.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_bronze_ingot_1"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"bronze_ingot", Tags.Items.INGOTS_COPPER, 3, MysticalSteamAgeBlocksRegister.tin_ore_item_tag, 1,
                        MysticalSteamAgeItemsRegister.bronze_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.tin_ore_item.get()), has(MysticalSteamAgeBlocksRegister.tin_ore_item.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_bronze_ingot_2"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"bronze_ingot", Tags.Items.INGOTS_COPPER, 3, MysticalSteamAgeItemsRegister.tin_dust_tag, 1,
                        MysticalSteamAgeItemsRegister.bronze_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.tin_dust.get()), has(MysticalSteamAgeItemsRegister.tin_dust.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_bronze_ingot_3"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"bronze_ingot", Tags.Items.INGOTS_COPPER, 3, MysticalSteamAgeItemsRegister.raw_tin_tag, 1,
                        MysticalSteamAgeItemsRegister.bronze_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_tin.get()), has(MysticalSteamAgeItemsRegister.raw_tin.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_bronze_ingot_4"));

        // brass_ingot with INGOTS_COPPER
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"brass_ingot", Tags.Items.INGOTS_COPPER, 3, MysticalSteamAgeItemsRegister.zinc_ingot_tag, 1,
                        MysticalSteamAgeItemsRegister.brass_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.zinc_ingot.get()), has(MysticalSteamAgeItemsRegister.zinc_ingot.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_brass_ingot_1"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"brass_ingot", Tags.Items.INGOTS_COPPER, 3, MysticalSteamAgeBlocksRegister.zinc_ore_item_tag, 1,
                        MysticalSteamAgeItemsRegister.brass_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.zinc_ore_item.get()), has(MysticalSteamAgeBlocksRegister.zinc_ore_item.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_brass_ingot_2"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"brass_ingot", Tags.Items.INGOTS_COPPER, 3, MysticalSteamAgeItemsRegister.zinc_dust_tag, 1,
                        MysticalSteamAgeItemsRegister.brass_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.zinc_dust.get()), has(MysticalSteamAgeItemsRegister.zinc_dust.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_brass_ingot_3"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"brass_ingot", Tags.Items.INGOTS_COPPER, 3, MysticalSteamAgeItemsRegister.raw_zinc_tag, 1,
                        MysticalSteamAgeItemsRegister.brass_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_zinc.get()), has(MysticalSteamAgeItemsRegister.raw_zinc.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_brass_ingot_4"));

        // bronze_ingot with ORES_COPPER
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"bronze_ingot", Tags.Items.ORES_COPPER, 3, MysticalSteamAgeItemsRegister.tin_ingot_tag, 1,
                        MysticalSteamAgeItemsRegister.bronze_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.tin_ingot.get()), has(MysticalSteamAgeItemsRegister.tin_ingot.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_bronze_ingot_5"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"bronze_ingot", Tags.Items.ORES_COPPER, 3, MysticalSteamAgeBlocksRegister.tin_ore_item_tag, 1,
                        MysticalSteamAgeItemsRegister.bronze_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.tin_ore_item.get()), has(MysticalSteamAgeBlocksRegister.tin_ore_item.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_bronze_ingot_6"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"bronze_ingot", Tags.Items.ORES_COPPER, 3, MysticalSteamAgeItemsRegister.tin_dust_tag, 1,
                        MysticalSteamAgeItemsRegister.bronze_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.tin_dust.get()), has(MysticalSteamAgeItemsRegister.tin_dust.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_bronze_ingot_7"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"bronze_ingot", Tags.Items.ORES_COPPER, 3, MysticalSteamAgeItemsRegister.raw_tin_tag, 1,
                        MysticalSteamAgeItemsRegister.bronze_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_tin.get()), has(MysticalSteamAgeItemsRegister.raw_tin.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_bronze_ingot_8"));

        // brass_ingot with ORES_COPPER
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"brass_ingot", Tags.Items.ORES_COPPER, 3, MysticalSteamAgeItemsRegister.zinc_ingot_tag, 1,
                        MysticalSteamAgeItemsRegister.brass_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.zinc_ingot.get()), has(MysticalSteamAgeItemsRegister.zinc_ingot.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_brass_ingot_5"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"brass_ingot", Tags.Items.ORES_COPPER, 3, MysticalSteamAgeBlocksRegister.zinc_ore_item_tag, 1,
                        MysticalSteamAgeItemsRegister.brass_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.zinc_ore_item.get()), has(MysticalSteamAgeBlocksRegister.zinc_ore_item.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_brass_ingot_6"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"brass_ingot", Tags.Items.ORES_COPPER, 3, MysticalSteamAgeItemsRegister.zinc_dust_tag, 1,
                        MysticalSteamAgeItemsRegister.brass_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.zinc_dust.get()), has(MysticalSteamAgeItemsRegister.zinc_dust.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "double_furnace_brass_ingot_7"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"brass_ingot", Tags.Items.ORES_COPPER, 3, MysticalSteamAgeItemsRegister.raw_zinc_tag, 1,
                        MysticalSteamAgeItemsRegister.brass_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_zinc.get()), has(MysticalSteamAgeItemsRegister.raw_zinc.get()))
                .save(consumer, new ResourceLocation(MysticalSteamAge.MOD_ID, "double_furnace_brass_ingot_8"));

        // bronze_ingot with copper_dust_tag
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"bronze_ingot", MysticalSteamAgeItemsRegister.copper_dust_tag, 3, MysticalSteamAgeItemsRegister.tin_ingot_tag, 1,
                        MysticalSteamAgeItemsRegister.bronze_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.tin_ingot.get()), has(MysticalSteamAgeItemsRegister.tin_ingot.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_bronze_ingot_9"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"bronze_ingot", MysticalSteamAgeItemsRegister.copper_dust_tag, 3, MysticalSteamAgeBlocksRegister.tin_ore_item_tag, 1,
                        MysticalSteamAgeItemsRegister.bronze_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.tin_ore_item.get()), has(MysticalSteamAgeBlocksRegister.tin_ore_item.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_bronze_ingot_10"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"bronze_ingot", MysticalSteamAgeItemsRegister.copper_dust_tag, 3, MysticalSteamAgeItemsRegister.tin_dust_tag, 1,
                        MysticalSteamAgeItemsRegister.bronze_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.tin_dust.get()), has(MysticalSteamAgeItemsRegister.tin_dust.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_bronze_ingot_11"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"bronze_ingot", MysticalSteamAgeItemsRegister.copper_dust_tag, 3, MysticalSteamAgeItemsRegister.raw_tin_tag, 1,
                        MysticalSteamAgeItemsRegister.bronze_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_tin.get()), has(MysticalSteamAgeItemsRegister.raw_tin.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_bronze_ingot_12"));

        // brass_ingot with copper_dust_tag
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"brass_ingot", MysticalSteamAgeItemsRegister.copper_dust_tag, 3, MysticalSteamAgeItemsRegister.zinc_ingot_tag, 1,
                        MysticalSteamAgeItemsRegister.brass_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.zinc_ingot.get()), has(MysticalSteamAgeItemsRegister.zinc_ingot.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_brass_ingot_9"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"brass_ingot", MysticalSteamAgeItemsRegister.copper_dust_tag, 3, MysticalSteamAgeBlocksRegister.zinc_ore_item_tag, 1,
                        MysticalSteamAgeItemsRegister.brass_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.zinc_ore_item.get()), has(MysticalSteamAgeBlocksRegister.zinc_ore_item.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_brass_ingot_10"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"brass_ingot", MysticalSteamAgeItemsRegister.copper_dust_tag, 3, MysticalSteamAgeItemsRegister.zinc_dust_tag, 1,
                        MysticalSteamAgeItemsRegister.brass_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.zinc_dust.get()), has(MysticalSteamAgeItemsRegister.zinc_dust.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_brass_ingot_11"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"brass_ingot", MysticalSteamAgeItemsRegister.copper_dust_tag, 3, MysticalSteamAgeItemsRegister.raw_zinc_tag, 1,
                        MysticalSteamAgeItemsRegister.brass_ingot.get(), 4, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_zinc.get()), has(MysticalSteamAgeItemsRegister.raw_zinc.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_brass_ingot_12"));

        // steel_ingot
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"steel_ingot", Tags.Items.INGOTS_IRON, 1, MysticalSteamAgeItemsRegister.coal_tag, 2,
                        MysticalSteamAgeItemsRegister.steel_ingot.get(), 1, 0.75F, 200)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_steel_ingot_1"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"steel_ingot", Tags.Items.INGOTS_IRON, 1, MysticalSteamAgeItemsRegister.char_coal_tag, 4,
                        MysticalSteamAgeItemsRegister.steel_ingot.get(), 1, 0.75F, 200)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_steel_ingot_2"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"steel_ingot", MysticalSteamAgeItemsRegister.iron_dust_tag, 1, MysticalSteamAgeItemsRegister.coal_tag, 2,
                        MysticalSteamAgeItemsRegister.steel_ingot.get(), 1, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.iron_dust.get()), has(MysticalSteamAgeItemsRegister.iron_dust.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_steel_ingot_3"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"steel_ingot", MysticalSteamAgeItemsRegister.iron_dust_tag, 1, MysticalSteamAgeItemsRegister.char_coal_tag, 4,
                        MysticalSteamAgeItemsRegister.steel_ingot.get(), 1, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.iron_dust.get()), has(MysticalSteamAgeItemsRegister.iron_dust.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_steel_ingot_4"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"steel_ingot", Tags.Items.INGOTS_IRON, 1, MysticalSteamAgeItemsRegister.sulphur_dust_tag, 1,
                        MysticalSteamAgeItemsRegister.steel_ingot.get(), 1, 0.75F, 200)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_steel_ingot_5"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"steel_ingot", MysticalSteamAgeItemsRegister.iron_dust_tag, 1, MysticalSteamAgeItemsRegister.sulphur_dust_tag, 1,
                        MysticalSteamAgeItemsRegister.steel_ingot.get(), 1, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.iron_dust.get()), has(MysticalSteamAgeItemsRegister.iron_dust.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_steel_ingot_6"));

        // devil_iron_ingot
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"devil_iron_ingot", MysticalSteamAgeBlocksRegister.nether_devil_iron_ore_item_tag, 1, MysticalSteamAgeItemsRegister.sulphur_dust_tag, 1,
                        MysticalSteamAgeItemsRegister.devil_iron_ingot.get(), 1, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeBlocksRegister.nether_devil_iron_ore.get()), has(MysticalSteamAgeBlocksRegister.nether_devil_iron_ore.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_devil_iron_ingot_1"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"devil_iron_ingot", MysticalSteamAgeItemsRegister.raw_devil_iron_tag, 1, MysticalSteamAgeItemsRegister.sulphur_dust_tag, 1,
                        MysticalSteamAgeItemsRegister.devil_iron_ingot.get(), 1, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.raw_devil_iron.get()), has(MysticalSteamAgeItemsRegister.raw_devil_iron.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_devil_iron_ingot_2"));
        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"devil_iron_ingot", MysticalSteamAgeItemsRegister.devil_iron_dust_tag, 1, MysticalSteamAgeItemsRegister.sulphur_dust_tag, 1,
                        MysticalSteamAgeItemsRegister.devil_iron_ingot.get(), 1, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.devil_iron_dust.get()), has(MysticalSteamAgeItemsRegister.devil_iron_dust.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_devil_iron_ingot_3"));

        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"ham", MysticalSteamAgeItemsRegister.ham_tag , 1, MysticalSteamAgeItemsRegister.salt_dust_tag, 1,
                        MysticalSteamAgeItemsRegister.ham.get(), 1, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.salt_dust.get()), has(MysticalSteamAgeItemsRegister.salt_dust.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_ham"));

        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"nail", Tags.Items.INGOTS_GOLD , 1, MysticalSteamAgeItemsRegister.sand_mold_tag, 1,
                        MysticalSteamAgeItemsRegister.gold_nail.get(), 16, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.sand_mold.get()), has(MysticalSteamAgeItemsRegister.sand_mold.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_gold_nail"));

        DoubleFurnaceRecipeBuilder.smelting(RecipeCategory.MISC,"nail", Tags.Items.INGOTS_IRON , 1, MysticalSteamAgeItemsRegister.sand_mold_tag, 1,
                        MysticalSteamAgeItemsRegister.iron_nail.get(), 16, 0.75F, 200)
                .unlockedBy(getHasName(MysticalSteamAgeItemsRegister.sand_mold.get()), has(MysticalSteamAgeItemsRegister.sand_mold.get()))
                .save(consumer,  new ResourceLocation(MysticalSteamAge.MOD_ID,"double_furnace_iron_nail"));
    }

    protected static void netheriteSmithing(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, @NotNull Item pIngredientItem, @NotNull RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(pIngredientItem),
                Ingredient.of(Items.NETHERITE_INGOT), pCategory, pResultItem).unlocks(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
                .save(pFinishedRecipeConsumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getItemName(pResultItem) + "_smithing"));
    }

    private static void devilIronSmithing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),Ingredient.of(pIngredientItem), Ingredient.of(MysticalSteamAgeItemsRegister.devil_iron_ingot.get()), pCategory,  pResultItem)
                .unlocks(getHasName(MysticalSteamAgeItemsRegister.devil_iron_ingot.get()), has(MysticalSteamAgeItemsRegister.devil_iron_ingot.get()))
                .save(pFinishedRecipeConsumer, new ResourceLocation(MysticalSteamAge.MOD_ID,getItemName(pResultItem) + "_smithing"));
    }

    protected static void nineBlockStorageRecipes(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, @NotNull RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked) {
        nineBlockStorageRecipes(pFinishedRecipeConsumer, pUnpackedCategory, pUnpacked, pPackedCategory, pPacked, getSimpleRecipeName(pPacked), (String)null, getSimpleRecipeName(pUnpacked), (String)null);
    }

    protected static void nineBlockStorageRecipes(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer, @NotNull RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked, String pPackedName, @Nullable String pPackedGroup, String pUnpackedName, @Nullable String pUnpackedGroup) {
        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9).requires(pPacked).group(pUnpackedGroup).unlockedBy(getHasName(pPacked), has(pPacked)).save(pFinishedRecipeConsumer, new ResourceLocation(MysticalSteamAge.MOD_ID, pUnpackedName));
        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked).define('#', pUnpacked).pattern("###").pattern("###").pattern("###").group(pPackedGroup).unlockedBy(getHasName(pUnpacked), has(pUnpacked)).save(pFinishedRecipeConsumer, new ResourceLocation(MysticalSteamAge.MOD_ID, pPackedName));
    }

    protected static void stoneCutterResultFromBase(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial) {
        stonecutterResultFromBase(pFinishedRecipeConsumer, pCategory, pResult, pMaterial, 1);
    }

    protected static void stoneCutterResultFromBase(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial, int pResultCount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(pMaterial), pCategory, pResult, pResultCount).unlockedBy(getHasName(pMaterial),
                has(pMaterial)).save(pFinishedRecipeConsumer, new ResourceLocation(MysticalSteamAge.MOD_ID, getConversionRecipeName(pResult, pMaterial) + "_stonecutting"));
    }

    protected static void oneToOneConversionRecipe(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pResult, ItemLike pIngredient, @Nullable String pGroup) {
        oneToOneConversionRecipe(pFinishedRecipeConsumer, pCategory, pResult, pIngredient, pGroup, 1);
    }

    protected static void oneToOneConversionRecipe(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike pResult, ItemLike pIngredient, @Nullable String pGroup, int pResultCount) {
        ShapelessRecipeBuilder.shapeless(pCategory, pResult, pResultCount).requires(pIngredient).group(pGroup)
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pFinishedRecipeConsumer, new ResourceLocation(MysticalSteamAge.MOD_ID, getConversionRecipeName(pResult, pIngredient)));
    }

    protected static @NotNull RecipeBuilder slabBuilder(RecipeCategory pCategory, ItemLike pSlab, @NotNull Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(pCategory, pSlab, 6).define('#', pMaterial).pattern("###");
    }

    private static RecipeBuilder stairBuilder(RecipeCategory pCategory, ItemLike pStairs, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(pCategory, pStairs, 4).define('#', pMaterial).pattern("#  ").pattern("## ").pattern("###");
    }

    public static @NotNull RecipeBuilder wallBuilder(RecipeCategory pCategory, ItemLike pWall, @NotNull Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(pCategory, pWall, 6).define('#', pMaterial).pattern("###").pattern("###");
    }

    public static @NotNull RecipeBuilder polishedBuilder(RecipeCategory pCategory, ItemLike pResult, @NotNull Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(pCategory, pResult, 4).define('S', pMaterial).pattern("SS").pattern("SS");
    }

    private static RecipeBuilder buttonBuilder(RecipeCategory pCategory, ItemLike p_176659_, Ingredient p_176660_) {
        return ShapelessRecipeBuilder.shapeless(pCategory, p_176659_).requires(p_176660_);
    }

    private static RecipeBuilder doorBuilder(RecipeCategory pCategory, ItemLike p_176671_, Ingredient p_176672_) {
        return ShapedRecipeBuilder.shaped(pCategory, p_176671_, 3).define('#', p_176672_).pattern("##").pattern("##").pattern("##");
    }

    private static RecipeBuilder fenceBuilder(RecipeCategory pCategory, ItemLike p_176679_, Ingredient p_176680_) {
        int i = p_176679_ == Blocks.NETHER_BRICK_FENCE ? 6 : 3;
        Item item = p_176679_ == Blocks.NETHER_BRICK_FENCE ? Items.NETHER_BRICK : Items.STICK;
        return ShapedRecipeBuilder.shaped(pCategory, p_176679_, i).define('W', p_176680_).define('#', item).pattern("W#W").pattern("W#W");
    }

    private static RecipeBuilder fenceGateBuilder(RecipeCategory pCategory, ItemLike p_176685_, Ingredient p_176686_) {
        return ShapedRecipeBuilder.shaped(pCategory, p_176685_).define('#', Items.STICK).define('W', p_176686_).pattern("#W#").pattern("#W#");
    }

    protected static @NotNull RecipeBuilder pressurePlateBuilder(RecipeCategory pCategory, ItemLike p_176695_, @NotNull Ingredient ingredient) {
        return ShapedRecipeBuilder.shaped(pCategory, p_176695_).define('#', ingredient).pattern("##");
    }

    private static RecipeBuilder trapdoorBuilder(RecipeCategory pCategory, ItemLike p_176721_, Ingredient p_176722_) {
        return ShapedRecipeBuilder.shaped(pCategory, p_176721_, 2).define('#', p_176722_).pattern("###").pattern("###");
    }

    protected static String getHasName(ItemLike pItemLike) {
        return "has_" + getItemName(pItemLike);
    }

    protected static @NotNull String getItemName(ItemLike pItemLike) {
        return BuiltInRegistries.ITEM.getKey(pItemLike.asItem()).getPath();
    }

    protected static @NotNull String getSimpleRecipeName(ItemLike pItemLike) {
        return getItemName(pItemLike);
    }

    protected static String getConversionRecipeName(ItemLike pResult, ItemLike pIngredient) {
        return getItemName(pResult) + "_from_" + getItemName(pIngredient);
    }
}