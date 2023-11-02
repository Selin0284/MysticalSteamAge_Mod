package net.arjuna.mysticalSteamAge.items.custom;

import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class CustomTiers {

    public static final ForgeTier COPPER = new ForgeTier(2, 200, 8f,
            1f, 16, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(Items.COPPER_INGOT));

    public static final ForgeTier DEVIL_IRON = new ForgeTier(2, 1400, 10f,
            2f, 20, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(MysticalSteamAgeItemsRegister.devil_iron_ingot.get()));

    public static final ForgeTier FLINT = new ForgeTier(1, 100, 3f,
            3f, 12, BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(Items.FLINT));

    public static final ForgeTier NETHERRACK = new ForgeTier(1, 150, 3f,
            0f, 5, BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(Items.NETHER_BRICK));

    public static final ForgeTier STEEL = new ForgeTier(3, 500, 5f,
            4f, 14, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(MysticalSteamAgeItemsRegister.steel_ingot.get()));
}
