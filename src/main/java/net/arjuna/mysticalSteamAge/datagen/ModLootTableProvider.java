package net.arjuna.mysticalSteamAge.datagen;

import net.arjuna.mysticalSteamAge.datagen.Loot.MysticalSteamAgeBlockLootTables;
import net.arjuna.mysticalSteamAge.datagen.Loot.MysticalSteamAgeEntityLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(MysticalSteamAgeBlockLootTables::new, LootContextParamSets.BLOCK)
                //new LootTableProvider.SubProviderEntry(MysticalSteamAgeEntityLootTables::new, LootContextParamSets.ENTITY)
        ));
    }
}
