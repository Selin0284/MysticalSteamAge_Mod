package net.arjuna.mysticalSteamAge.datagen;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = MysticalSteamAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        generator.addProvider(event.includeServer(), new Recipes(packOutput));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));
        MysticalSteamAgeBlockTags blockTags = generator.addProvider(event.includeServer(),
                new MysticalSteamAgeBlockTags(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new MysticalSteamAgeItemTags(packOutput,
                lookupProvider, blockTags.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModGlobalLootModifiersProvider(packOutput));

        generator.addProvider(event.includeClient(), new BlockStates(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ItemModels(packOutput, existingFileHelper));
    }
}
