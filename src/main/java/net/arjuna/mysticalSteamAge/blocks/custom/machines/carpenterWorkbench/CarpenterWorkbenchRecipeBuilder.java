package net.arjuna.mysticalSteamAge.blocks.custom.machines.carpenterWorkbench;

import com.google.gson.JsonObject;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.MysticalSteamAgeMachineRecipes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class CarpenterWorkbenchRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final Item result;
    private final Ingredient ingredient;
    private final int count;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;
    private final RecipeSerializer<?> type;

    public CarpenterWorkbenchRecipeBuilder(RecipeCategory pCategory, RecipeSerializer<?> pType, Ingredient pIngredient, ItemLike pResult, int pCount) {
        this.category = pCategory;
        this.type = pType;
        this.result = pResult.asItem();
        this.ingredient = pIngredient;
        this.count = pCount;
    }

    public static CarpenterWorkbenchRecipeBuilder woodCutting(Ingredient pIngredient, RecipeCategory pCategory, ItemLike pResult) {
        return new CarpenterWorkbenchRecipeBuilder(pCategory, MysticalSteamAgeMachineRecipes.carpenter_workbench_serializer.get(), pIngredient, pResult, 1);
    }

    public static CarpenterWorkbenchRecipeBuilder woodCutting(Ingredient pIngredient, RecipeCategory pCategory, ItemLike pResult, int pCount) {
        return new CarpenterWorkbenchRecipeBuilder(pCategory, MysticalSteamAgeMachineRecipes.carpenter_workbench_serializer.get(), pIngredient, pResult, pCount);
    }

    public @NotNull CarpenterWorkbenchRecipeBuilder unlockedBy(@NotNull String pCriterionName, @NotNull CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    public @NotNull CarpenterWorkbenchRecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    public @NotNull Item getResult() {
        return this.result;
    }

    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, @NotNull ResourceLocation pRecipeId) {
        this.ensureValid(pRecipeId);
        this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe",
                RecipeUnlockedTrigger.unlocked(pRecipeId)).rewards(AdvancementRewards.Builder.recipe(pRecipeId))
                .requirements(RequirementsStrategy.OR);
        pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.type, this.group == null ? "" : this.group,
                this.ingredient, this.result, this.count, this.advancement, pRecipeId.withPrefix("recipes/" + this.category.getFolderName() + "/" + pRecipeId.getPath())));
    }

    private void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final Ingredient ingredient;
        private final Item result;
        private final int count;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<?> type;

        public Result(ResourceLocation pId, RecipeSerializer<?> pType, String pGroup, Ingredient pIngredient, Item pResult, int pCount, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId) {
            this.id = pId;
            this.type = pType;
            this.group = pGroup;
            this.ingredient = pIngredient;
            this.result = pResult;
            this.count = pCount;
            this.advancement = pAdvancement;
            this.advancementId = pAdvancementId;
        }

        public void serializeRecipeData(@NotNull JsonObject pJson) {
            if (!this.group.isEmpty()) {
                pJson.addProperty("group", this.group);
            }

            pJson.add("ingredient", this.ingredient.toJson());
            pJson.addProperty("result", BuiltInRegistries.ITEM.getKey(this.result).toString());
            pJson.addProperty("count", this.count);
        }

        public @NotNull ResourceLocation getId() {
            return this.id;
        }

        public @NotNull RecipeSerializer<?> getType() {
            return this.type;
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}