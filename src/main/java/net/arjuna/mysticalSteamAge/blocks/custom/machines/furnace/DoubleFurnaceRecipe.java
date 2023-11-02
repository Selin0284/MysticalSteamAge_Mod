package net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace;

import com.google.gson.JsonObject;
import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DoubleFurnaceRecipe implements Recipe<Container> {
    private final ResourceLocation recipeId;
    private final Ingredient  ingredient1;
    private final int         count1;
    private final Ingredient  ingredient2;
    private final int         count2;
    private final Ingredient  result;
    private final int         resultCount;
    private final float       experience;
    private final int         cookingTime;
    private final String      group;

    public DoubleFurnaceRecipe(ResourceLocation pID, String grp, Ingredient in1, int c1, Ingredient in2, int c2, Ingredient res, int rc, float exp, int time) {
        recipeId = pID;
        group = grp;
        ingredient1 = in1;
        count1 = c1;
        ingredient2 = in2;
        count2 = c2;
        result = res;
        resultCount = rc;
        experience = exp;
        cookingTime = time;
    }

    @Override
    public boolean matches(@NotNull Container pContainer, @NotNull Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }
        ItemStack in1 = pContainer.getItem(0);
        ItemStack in2 = pContainer.getItem(1);
        return ingredient1.test(in1) && in1.getCount() >= count1 && ingredient2.test(in2) && in2.getCount() >= count2;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull Container pContainer, RegistryAccess pRegistryAccess) {
        ItemStack resultItem = null;
        for (ItemStack itemStack : this.result.getItems()) {
            resultItem = new ItemStack(itemStack.getItem(), this.resultCount);
        }
        assert resultItem != null;
        return resultItem;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return (pWidth == 2 && pHeight == 1);
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.ingredient1);
        nonnulllist.add(this.ingredient2);
        return nonnulllist;
    }

    public int getIngredient1Count() { return count1; }

    public int getIngredient2Count() { return count2; }

    public int getResultCount() {
        return resultCount;
    }

    public Ingredient getIngredient1() { return ingredient1; }

    public Ingredient getIngredient2() { return ingredient2; }

    public float getExperience() {
        return this.experience;
    }

    public int getCookingTime() {
        return this.cookingTime;
    }

    /**
     * Recipes with equal group are combined into one button in the recipe book
     */
    @Override
    public @NotNull String getGroup() {
        return this.group;
    }

    @Override
    public @NotNull ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        ItemStack resultItem = null;
        System.out.println(this.resultCount);
        System.out.println(this.getResultCount());
        for (ItemStack itemStack : this.result.getItems()) {
            resultItem = new ItemStack(itemStack.getItem(), this.getResultCount());
        }
        assert resultItem != null;
        return resultItem;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return recipeId;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<DoubleFurnaceRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "double_furnace";
    }

    public static class Serializer implements RecipeSerializer<DoubleFurnaceRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(MysticalSteamAge.MOD_ID, "double_furnace");

        @Override
        public @NotNull DoubleFurnaceRecipe fromJson(@NotNull ResourceLocation pRecipeId, @NotNull JsonObject pSerializedRecipe) {
            String grp = GsonHelper.getAsString(pSerializedRecipe, "group", "");

            JsonObject jIn1 = GsonHelper.getAsJsonObject(pSerializedRecipe, "ingredient1");
            Ingredient ingredient1 = Ingredient.fromJson(jIn1);
            int c1 = GsonHelper.getAsInt(jIn1, "count", 1);

            JsonObject jIn2 = GsonHelper.getAsJsonObject(pSerializedRecipe, "ingredient2");
            Ingredient ingredient2 = Ingredient.fromJson(jIn2);
            int c2 = GsonHelper.getAsInt(jIn2, "count", 1);

            JsonObject jR = GsonHelper.getAsJsonObject(pSerializedRecipe, "result");
            Ingredient result = Ingredient.fromJson(jR);
            int rc = GsonHelper.getAsInt(jR, "count", 1);

            float f = GsonHelper.getAsFloat(pSerializedRecipe, "experience", 0.0F);
            int i = GsonHelper.getAsInt(pSerializedRecipe, "cookingtime", 200);

            return new DoubleFurnaceRecipe(pRecipeId, grp, ingredient1, c1, ingredient2, c2, result, rc, f, i);
        }

        @Nullable
        @Override
        public DoubleFurnaceRecipe fromNetwork(@NotNull ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String grp              = pBuffer.readUtf();
            Ingredient ingredient1  = Ingredient.fromNetwork(pBuffer);
            int c1                  = pBuffer.readByte();
            Ingredient ingredient2  = Ingredient.fromNetwork(pBuffer);
            int c2                  = pBuffer.readByte();
            Ingredient result       = Ingredient.fromNetwork(pBuffer);
            int rc                  = pBuffer.readByte();
            float exp               = pBuffer.readFloat();
            int time                = pBuffer.readInt();

            return new DoubleFurnaceRecipe(pRecipeId, grp, ingredient1, c1, ingredient2, c2, result, rc, exp, time);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, DoubleFurnaceRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.group);
            pRecipe.ingredient1.toNetwork(pBuffer);
            pBuffer.writeByte(pRecipe.count1);
            pRecipe.ingredient2.toNetwork(pBuffer);
            pBuffer.writeByte(pRecipe.count2);
            pRecipe.result.toNetwork(pBuffer);
            pBuffer.writeByte(pRecipe.resultCount);
            pBuffer.writeFloat(pRecipe.experience);
            pBuffer.writeInt(pRecipe.cookingTime);
        }
    }

}

