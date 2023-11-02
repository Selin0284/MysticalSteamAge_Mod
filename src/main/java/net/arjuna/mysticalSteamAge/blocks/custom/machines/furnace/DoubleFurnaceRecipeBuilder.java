package net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace;

import com.google.gson.JsonObject;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeMachinesRegister;
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
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class DoubleFurnaceRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final CookingBookCategory bookCategory;
    private final TagKey<Item> ingredient1;
    private final int count1;
    private final TagKey<Item> ingredient2;
    private final int count2;
    private final Item result;
    private final int resultCount;
    private final float experience;
    private final int cookingTime;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;
    private final RecipeSerializer<?> serializer;

    public DoubleFurnaceRecipeBuilder(RecipeCategory category, CookingBookCategory bookCategory, @Nullable String group, TagKey<Item> ingredient1, int count1, TagKey<Item> ingredient2, int count2, ItemLike result, int resultCount,
                                      float experience, int cookingTime, RecipeSerializer<?> serializer) {
        this.category = category;
        this.bookCategory = bookCategory;
        this.group = group;
        this.ingredient1 = ingredient1;
        this.count1 = count1;
        this.ingredient2 = ingredient2;
        this.count2 = count2;
        this.result = result.asItem();
        this.resultCount = resultCount;
        this.experience = experience;
        this.cookingTime = cookingTime;
        this.serializer = serializer;
    }

    public static DoubleFurnaceRecipeBuilder smelting(RecipeCategory category, String group, TagKey<Item> ingredient1, int count1, TagKey<Item> ingredient2, int count2, ItemLike pResult,
                                                      int resultCount, float pExperience, int pCookingTime) {

        return new DoubleFurnaceRecipeBuilder(category, CookingBookCategory.MISC, group, ingredient1, count1, ingredient2, count2, pResult, resultCount, pExperience, pCookingTime,
                MysticalSteamAgeMachineRecipes.double_furnace_serializer.get());

    }
    public @NotNull DoubleFurnaceRecipeBuilder unlockedBy(@NotNull String pCriterionName, @NotNull CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    public @NotNull DoubleFurnaceRecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    public @NotNull Item getResult() {
        return this.result;
    }

    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, @NotNull ResourceLocation pRecipeId) {
        this.ensureValid(pRecipeId);
        this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe",
                RecipeUnlockedTrigger.unlocked(pRecipeId)).rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);
        pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.group == null ? "" : this.group, this.bookCategory, this.ingredient1,
                this.count1, this.ingredient2, this.count2, this.result, this.resultCount, this.experience, this.cookingTime, this.advancement,
                pRecipeId.withPrefix("recipes/" + this.category.getFolderName() + "/"), this.serializer));
    }

    /**
     * Makes sure that this obtainable.
     */
    private void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }

    public static class Result implements FinishedRecipe {
        private final CookingBookCategory category;
        private final ResourceLocation id;
        private final String group;
        private final TagKey<Item> ingredient1;
        private final int count1;
        private final TagKey<Item>  ingredient2;
        private final int count2;
        private final Item result;
        private final int resultCount;
        private final float experience;
        private final int cookingTime;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<?> serializer;

        public Result(ResourceLocation id, String group, CookingBookCategory category, TagKey<Item> ingredient1, int count1, TagKey<Item> ingredient2, int count2, Item result, int resultCount,
                      float experience, int cookingTime, Advancement.Builder advancement, ResourceLocation advancementId, RecipeSerializer<?> serializer) {
            this.id = id;
            this.group = group;
            this.category = category;
            this.ingredient1 = ingredient1;
            this.count1 = count1;
            this.ingredient2 = ingredient2;
            this.count2 = count2;
            this.result = result;
            this.resultCount = resultCount;
            this.experience = experience;
            this.cookingTime = cookingTime;
            this.advancement = advancement;
            this.advancementId = advancementId;
            this.serializer = serializer;
        }

        public void serializeRecipeData(@NotNull JsonObject pJson) {
            if (!this.group.isEmpty()) {
                pJson.addProperty("group", this.group);
            }
            pJson.addProperty("category", this.category.getSerializedName());
            JsonObject jsonobject1 = new JsonObject();
            jsonobject1.addProperty("tag", this.ingredient1.location().toString());
            if (this.count1 > 1) {
                jsonobject1.addProperty("count", this.count1);
            }
            pJson.add("ingredient1", jsonobject1);
            JsonObject jsonobject2 = new JsonObject();
            jsonobject2.addProperty("tag", this.ingredient2.location().toString());
            if (this.count2 > 1) {
                jsonobject2.addProperty("count", this.count2);
            }
            pJson.add("ingredient2", jsonobject2);
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", BuiltInRegistries.ITEM.getKey(this.result).toString());
            if (this.resultCount > 1) {
                jsonobject.addProperty("count", this.resultCount);
            }

            pJson.add("result", jsonobject);
            pJson.addProperty("experience", this.experience);
            pJson.addProperty("cookingtime", this.cookingTime);
        }

        public @NotNull RecipeSerializer<?> getType() {
            return this.serializer;
        }

        public @NotNull ResourceLocation getId() {
            return this.id;
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