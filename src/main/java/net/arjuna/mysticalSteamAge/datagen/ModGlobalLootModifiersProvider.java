package net.arjuna.mysticalSteamAge.datagen;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.event.loot.AddItemModifier;
import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, MysticalSteamAge.MOD_ID);
    }

    @Override
    protected void start() {
        add("feather_herb_from_villager_chests", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_shepherd")).build() }, MysticalSteamAgeItemsRegister.feather_herb_seed.get()));
    }
}