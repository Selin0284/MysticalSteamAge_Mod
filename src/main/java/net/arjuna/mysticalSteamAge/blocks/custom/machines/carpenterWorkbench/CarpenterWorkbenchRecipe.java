package net.arjuna.mysticalSteamAge.blocks.custom.machines.carpenterWorkbench;

import com.google.gson.JsonObject;
import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
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

public class CarpenterWorkbenchRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    private final String group;
    private final Ingredient ingredient;
    private final ItemStack result;

    public CarpenterWorkbenchRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result) {
        this.id = id;
        this.group = group;
        this.ingredient = ingredient;
        this.result = result;
    }

    @Override
    public boolean matches(@NotNull Container pContainer, @NotNull Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }
        return this.ingredient.test(pContainer.getItem(0));
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull Container pContainer, RegistryAccess pRegistryAccess) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return this.result;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return this.id;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public @NotNull NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNullList = NonNullList.create();
        nonNullList.add(this.ingredient);
        return nonNullList;
    }

    public static class Type implements RecipeType<CarpenterWorkbenchRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "carpenter_workbench";
    }

    public static class Serializer implements RecipeSerializer<CarpenterWorkbenchRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(MysticalSteamAge.MOD_ID, "carpenter_workbench");

        @Override
        public @NotNull CarpenterWorkbenchRecipe fromJson(@NotNull ResourceLocation pRecipeId, @NotNull JsonObject pSerializedRecipe) {
            String s = GsonHelper.getAsString(pSerializedRecipe, "group", "");
            Ingredient ingredient;
            if (GsonHelper.isArrayNode(pSerializedRecipe, "ingredient")) {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredient"));
            } else {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "ingredient"));
            }

            String s1 = GsonHelper.getAsString(pSerializedRecipe, "result");
            int i = GsonHelper.getAsInt(pSerializedRecipe, "count");
            ItemStack itemstack = new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(s1)), i);
            return new CarpenterWorkbenchRecipe(pRecipeId, s, ingredient, itemstack);
        }

        @Nullable
        @Override
        public CarpenterWorkbenchRecipe fromNetwork(@NotNull ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String s = pBuffer.readUtf();
            Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
            ItemStack itemstack = pBuffer.readItem();
            return new CarpenterWorkbenchRecipe(pRecipeId, s, ingredient, itemstack);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, CarpenterWorkbenchRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.group);
            pRecipe.ingredient.toNetwork(pBuffer);
            pBuffer.writeItem(pRecipe.result);
        }

    }

}