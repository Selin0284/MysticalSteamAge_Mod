package net.arjuna.mysticalSteamAge.plugin.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeBlocksRegister;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.carpenterWorkbench.CarpenterWorkbenchRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CarpenterWorkbenchRecipeCategory implements IRecipeCategory<CarpenterWorkbenchRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(MysticalSteamAge.MOD_ID + "carpenter_workbench");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(MysticalSteamAge.MOD_ID, "textures/gui/gui_vanilla.png");

    public static final RecipeType<CarpenterWorkbenchRecipe> CARPENTER_WORKBENCH_RECIPE_TYPE =
            new RecipeType<>(UID, CarpenterWorkbenchRecipe.class);

    public static final int width = 82;
    public static final int height = 34;

    private final IDrawable background;
    private final IDrawable icon;
    private final Component localizedName;

    public CarpenterWorkbenchRecipeCategory(IGuiHelper guiHelper) {
        background = guiHelper.createDrawable(TEXTURE, 0, 220, width, height);
        icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(MysticalSteamAgeBlocksRegister.carpenter_workbench.get()));
        localizedName = Component.translatable("container.carpenter_workbench");
    }

    @Override
    public @NotNull RecipeType<CarpenterWorkbenchRecipe> getRecipeType() {
        return CARPENTER_WORKBENCH_RECIPE_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return this.localizedName;
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CarpenterWorkbenchRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 9)
                .addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 61,  9)
                .addItemStack(recipe.getResultItem(null));
    }

    @Override
    public boolean isHandled(CarpenterWorkbenchRecipe recipe) {
        return !recipe.isSpecial();
    }
}
