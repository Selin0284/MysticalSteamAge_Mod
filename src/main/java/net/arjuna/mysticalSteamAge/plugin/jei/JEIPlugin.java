package net.arjuna.mysticalSteamAge.plugin.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.*;
import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.carpenterWorkbench.CarpenterWorkbenchRecipe;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace.DoubleFurnaceRecipe;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace.DoubleFurnaceScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(MysticalSteamAge.MOD_ID, "jei_plugin");
    }


    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new DoubleFurnaceRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CarpenterWorkbenchRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }


    @Override
    public void registerRecipes(IRecipeRegistration registration) {

        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<DoubleFurnaceRecipe> doubleFurnaceRecipes = recipeManager.getAllRecipesFor(DoubleFurnaceRecipe.Type.INSTANCE);
        registration.addRecipes(DoubleFurnaceRecipeCategory.DOUBLE_FURNACE_RECIPE_TYPE, doubleFurnaceRecipes);

        List<CarpenterWorkbenchRecipe> carpenterWorkbenchRecipes = recipeManager.getAllRecipesFor(CarpenterWorkbenchRecipe.Type.INSTANCE);
        registration.addRecipes(CarpenterWorkbenchRecipeCategory.CARPENTER_WORKBENCH_RECIPE_TYPE, carpenterWorkbenchRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration  registration) {
        registration.addRecipeClickArea(DoubleFurnaceScreen.class, 0, 3, 4, 36, DoubleFurnaceRecipeCategory.DOUBLE_FURNACE_RECIPE_TYPE);
    }


}
