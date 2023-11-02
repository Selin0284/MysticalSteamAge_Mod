package net.arjuna.mysticalSteamAge.blocks.custom.machines;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.carpenterWorkbench.CarpenterWorkbenchRecipe;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace.DoubleFurnaceRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MysticalSteamAgeMachineRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MysticalSteamAge.MOD_ID);

    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);
    }

    public static final RegistryObject<RecipeSerializer<DoubleFurnaceRecipe>> double_furnace_serializer =
            RECIPE_SERIALIZER.register("double_furnace", () -> DoubleFurnaceRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<CarpenterWorkbenchRecipe>> carpenter_workbench_serializer =
            RECIPE_SERIALIZER.register("carpenter_workbench", () -> CarpenterWorkbenchRecipe.Serializer.INSTANCE);

}
