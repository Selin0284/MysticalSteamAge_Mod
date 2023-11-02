package net.arjuna.mysticalSteamAge.plugin.jei;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeBlocksRegister;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace.DoubleFurnaceRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static mezz.jei.api.recipe.RecipeIngredientRole.INPUT;
import static mezz.jei.api.recipe.RecipeIngredientRole.OUTPUT;

public class DoubleFurnaceRecipeCategory implements IRecipeCategory<DoubleFurnaceRecipe> {

    public final static ResourceLocation UID = new ResourceLocation(MysticalSteamAge.MOD_ID, "double_furnace");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(MysticalSteamAge.MOD_ID, "textures/gui/double_furnace.png");

    public static final RecipeType<DoubleFurnaceRecipe> DOUBLE_FURNACE_RECIPE_TYPE =
            new RecipeType<>(UID, DoubleFurnaceRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private final int regularCookTime;
    private final Component localizedName;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;
    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;

    public DoubleFurnaceRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 36, 16, 104, 57);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(MysticalSteamAgeBlocksRegister.double_furnace.get()));
        this.regularCookTime = 200;
        this.localizedName = Component.translatable("container.double_furnace");
        this.staticFlame = helper.createDrawable(TEXTURE, 176, 0, 14, 14);
        this.animatedFlame = helper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
        this.cachedArrows = CacheBuilder.newBuilder()
                .maximumSize(25)
                .build(new CacheLoader<>() {
                    @Override
                    public @NotNull IDrawableAnimated load(@NotNull Integer cookTime) {
                        return helper.drawableBuilder(TEXTURE, 177, 15, 24, 17)
                                .buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
                    }
                });
    }

    protected IDrawableAnimated getArrow(DoubleFurnaceRecipe recipe) {
        int cookTime = recipe.getCookingTime();
        if (cookTime <= 0) {
            cookTime = regularCookTime;
        }
        return this.cachedArrows.getUnchecked(cookTime);
    }

    @Override
    public @NotNull RecipeType<DoubleFurnaceRecipe> getRecipeType() {
        return DOUBLE_FURNACE_RECIPE_TYPE;
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

    protected void drawExperience(DoubleFurnaceRecipe recipe, GuiGraphics guiGraphics, int y) {
        float experience = recipe.getExperience();
        if (experience > 0) {
            Component experienceString = Component.translatable("gui.jei.category.smelting.experience", experience);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(experienceString);
            guiGraphics.drawString(fontRenderer, experienceString, getWidth() - stringWidth, y, 0xFF808080, false);
        }
    }

    protected void drawCookTime(DoubleFurnaceRecipe recipe, GuiGraphics guiGraphics, int y) {
        int cookTime = recipe.getCookingTime();
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            Component timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(timeString);
            guiGraphics.drawString(fontRenderer, timeString, getWidth() - stringWidth, y, 0xFF808080, false);
        }
    }

    @Override
    public void draw(@NotNull DoubleFurnaceRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphics stack, double mouseX, double mouseY) {
        this.animatedFlame.draw(stack, 10, 21);

        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(stack, 44, 19);

        drawExperience(recipe, stack, 0);
        drawCookTime(recipe, stack, 45);
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, DoubleFurnaceRecipe recipe, @NotNull IFocusGroup focuses) {

        List<ItemStack> ingredient1 = new ArrayList<>();
        List<ItemStack> ingredient2 = new ArrayList<>();

        for (ItemStack itemStack : recipe.getIngredient1().getItems()) {
            ingredient1.add(new ItemStack(itemStack.getItem(), recipe.getIngredient1Count()));
        }
        for (ItemStack itemStack : recipe.getIngredient2().getItems()) {
            ingredient2.add(new ItemStack(itemStack.getItem(), recipe.getIngredient2Count()));
        }

        builder.addSlot(INPUT, 1, 1).addItemStacks(Objects.requireNonNull(ingredient1));
        builder.addSlot(INPUT, 20, 1).addItemStacks(Objects.requireNonNull(ingredient2));

        builder.addSlot(OUTPUT, 80, 19).addItemStack(recipe.getResultItem(null));
    }
}
