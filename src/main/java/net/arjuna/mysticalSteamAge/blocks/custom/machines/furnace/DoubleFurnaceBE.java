package net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeMachinesRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.List;
import java.util.Objects;

import static net.minecraft.world.level.block.entity.BaseContainerBlockEntity.canUnlock;

public class DoubleFurnaceBE extends BlockEntity implements Container, MenuProvider, Nameable, RecipeHolder {

    public static final int INGREDIENT_SLOT_1 = 0;
    public static final int INGREDIENT_SLOT_2 = 1;
    public static final int FUEL_SLOT = 2;
    public static final int RESULT_SLOT = 3;

    int litTime;
    int litDuration;
    int cookingProgress;
    int cookingTotalTime;

    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();

    /*TILE*/
    public DoubleFurnaceBE(BlockPos pWorldPosition, BlockState pBlockState) {
        super(MysticalSteamAgeMachinesRegister.double_furnace_be.get(), pWorldPosition, pBlockState);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        handler.invalidate();
    }

    @Override
    public void load(@NotNull CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("Items"));
        this.litTime = pTag.getInt("BurnTime");
        this.litDuration = pTag.getInt("BurnTimeTotal");
        this.cookingProgress = pTag.getInt("CookTime");
        this.cookingTotalTime = pTag.getInt("CookTimeTotal");
        CompoundTag compoundtag = pTag.getCompound("RecipesUsed");

        for(String s : compoundtag.getAllKeys()) {
            this.recipesUsed.put(new ResourceLocation(s), compoundtag.getInt(s));
        }
        this.lockKey = LockCode.fromTag(pTag);
        if (pTag.contains("CustomName", 8)) {
            this.name = Component.Serializer.fromJson(pTag.getString("CustomName"));
        }
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putInt("BurnTime", this.litTime);
        pTag.putInt("BurnTimeTotal", this.litDuration);
        pTag.putInt("CookTime", this.cookingProgress);
        pTag.putInt("CookTimeTotal", this.cookingTotalTime);
        pTag.put("Items", itemHandler.serializeNBT());
        CompoundTag compoundtag = new CompoundTag();
        this.recipesUsed.forEach((p_187449_, p_187450_) -> {
            compoundtag.putInt(p_187449_.toString(), p_187450_);
        });
        pTag.put("RecipesUsed", compoundtag);
        this.lockKey.addToTag(pTag);
        if (this.name != null) {
            pTag.putString("CustomName", Component.Serializer.toJson(this.name));
        }
    }

    /*TICK*/
    DoubleFurnaceRecipe recipeDouble;

    public boolean validateRecipe() {
        if (recipeDouble != null) {
            if (recipeDouble.matches(this, Objects.requireNonNull(level)))
                return true;

            recipeDouble = null;
        }

        if (!itemHandler.getStackInSlot(INGREDIENT_SLOT_1).isEmpty() && !itemHandler.getStackInSlot(INGREDIENT_SLOT_2).isEmpty()) {
            recipeDouble = Objects.requireNonNull(level).getRecipeManager().getRecipeFor(DoubleFurnaceRecipe.Type.INSTANCE, this, level).orElse(null);
        }

        return recipeDouble != null;
    }

    private boolean isLit() {
        return this.litTime > 0;
    }

    private boolean validateLit() {
        if (litTime > 0) {
            return true;
        }

        if (itemHandler.getStackInSlot(FUEL_SLOT).isEmpty()) {
            return false;
        }

        litDuration = net.minecraftforge.common.ForgeHooks.getBurnTime(itemHandler.getStackInSlot(FUEL_SLOT), RecipeType.BLASTING);
        if (litDuration > 0) {
            itemHandler.getStackInSlot(FUEL_SLOT).shrink(1);
            litTime = litDuration;
        }

        return litTime > 0;
    }

    private boolean isNBTEqual(ItemStack a, ItemStack b) {
        if (a.getTag() == null && b.getTag() == null) {
            return true;
        }

        if (a.getTag() != null && b.getTag() != null) {
            return a.getTag().equals(b.getTag());
        }

        return false;
    }

    private boolean mergeOutput(boolean simulate) {
        ItemStack slot = itemHandler.getStackInSlot(RESULT_SLOT);
        ItemStack out = recipeDouble.getResultItem(null);

        if (slot.isEmpty()) {
            if (!simulate) {
                itemHandler.setStackInSlot(RESULT_SLOT, out);
            }
            return true;
        }


        if (slot.is(out.getItem()) && slot.getCount() + out.getCount() <= slot.getMaxStackSize() && slot.getDamageValue() == out.getDamageValue() && isNBTEqual(slot, out)) {
            if (!simulate) {
                slot.setCount(slot.getCount() + out.getCount());
            }
            return true;
        }

        return false;
    }

    private void consumeItems() {
        itemHandler.getStackInSlot(INGREDIENT_SLOT_1).setCount(itemHandler.getStackInSlot(INGREDIENT_SLOT_1).getCount() - recipeDouble.getIngredient1Count());
        itemHandler.getStackInSlot(INGREDIENT_SLOT_2).setCount(itemHandler.getStackInSlot(INGREDIENT_SLOT_2).getCount() - recipeDouble.getIngredient2Count());
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, DoubleFurnaceBE pBlockEntity) {
        int oldLit = pBlockEntity.litTime;
        boolean dirty = false;

        if (pBlockEntity.isLit()) {
            --pBlockEntity.litTime;
        }

        if (pBlockEntity.validateRecipe()) {
            pBlockEntity.cookingTotalTime = pBlockEntity.recipeDouble.getCookingTime();

            if (pBlockEntity.mergeOutput(true)) {

                if (pBlockEntity.validateLit()) {
                    pBlockEntity.cookingProgress++;

                    if (pBlockEntity.cookingProgress >= pBlockEntity.cookingTotalTime) {
                        Recipe<?> recipe = pLevel.getRecipeManager().getRecipeFor(DoubleFurnaceRecipe.Type.INSTANCE, pBlockEntity, pLevel).orElse(null);

                        pBlockEntity.consumeItems();
                        pBlockEntity.mergeOutput(false);
                        pBlockEntity.cookingProgress = 0;
                        pBlockEntity.setRecipeUsed(recipe);
                        dirty = true;
                    }
                } else {
                    pBlockEntity.cookingProgress = Math.max(pBlockEntity.cookingProgress - 2, 0);
                }
            } else {
                pBlockEntity.cookingProgress = Math.max(pBlockEntity.cookingProgress - 2, 0);
            }
        } else {
            pBlockEntity.cookingTotalTime = 0;
            pBlockEntity.cookingProgress = 0;
        }

        if ((oldLit == 0) != (pBlockEntity.litTime == 0)) {
            pState = pState.setValue(DoubleFurnaceBlock.LIT, pBlockEntity.isLit());
            pLevel.setBlock(pPos, pState, 3);
        }

        if (oldLit < pBlockEntity.litTime || (oldLit == 0) != (pBlockEntity.litTime == 0) || dirty) {
            setChanged(pLevel, pPos, pState);
        }
    }

    public void setRecipeUsed(@Nullable Recipe<?> pRecipe) {
        if (pRecipe != null) {
            ResourceLocation resourcelocation = pRecipe.getId();
            this.recipesUsed.addTo(resourcelocation, 1);
        }

    }

    @Nullable
    public Recipe<?> getRecipeUsed() {
        return null;
    }

    public void awardUsedRecipesAndPopExperience(ServerPlayer pPlayer) {
        List<Recipe<?>> list = this.getRecipesToAwardAndPopExperience(pPlayer.serverLevel(), pPlayer.position());
        pPlayer.awardRecipes(list);
        this.recipesUsed.clear();
    }

    public List<Recipe<?>> getRecipesToAwardAndPopExperience(ServerLevel p_154996_, Vec3 p_154997_) {
        List<Recipe<?>> list = Lists.newArrayList();

        for (Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
            p_154996_.getRecipeManager().byKey(entry.getKey()).ifPresent((p_155023_) -> {
                list.add(p_155023_);
                createExperience(p_154996_, p_154997_, entry.getIntValue(), ((DoubleFurnaceRecipe) p_155023_).getExperience());
            });
        }

        return list;
    }

    private static void createExperience(ServerLevel p_154999_, Vec3 p_155000_, int p_155001_, float p_155002_) {
        int i = Mth.floor((float) p_155001_ * p_155002_);
        float f = Mth.frac((float) p_155001_ * p_155002_);
        if (f != 0.0F && Math.random() < (double) f) {
            ++i;
        }

        ExperienceOrb.award(p_154999_, p_155000_, i);
    }


    /*ITEM Storage*/

    @Override
    public int getContainerSize() {
        return itemHandler.getSlots();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            if (!itemHandler.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public @NotNull ItemStack getItem(int pIndex) {
        return itemHandler.getStackInSlot(pIndex);
    }

    @Override
    public @NotNull ItemStack removeItem(int pIndex, int pCount) {
        return pIndex >= 0 && pIndex < itemHandler.getSlots() && !itemHandler.getStackInSlot(pIndex).isEmpty() && pCount > 0 ? itemHandler.getStackInSlot(pIndex).split(pCount) : ItemStack.EMPTY;
    }

    @Override
    public @NotNull ItemStack removeItemNoUpdate(int pIndex) {
        if (pIndex >= 0 && pIndex < itemHandler.getSlots()) {
            ItemStack old = itemHandler.getStackInSlot(pIndex);
            itemHandler.setStackInSlot(pIndex, ItemStack.EMPTY);
            return old;
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void setItem(int pIndex, @NotNull ItemStack pStack) {

        itemHandler.setStackInSlot(pIndex, pStack);
        if (pStack.getCount() > this.getMaxStackSize()) {
            pStack.setCount(this.getMaxStackSize());
        }
    }

    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        if (Objects.requireNonNull(this.level).getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return pPlayer.distanceToSqr((double) this.worldPosition.getX() + 0.5D, (double) this.worldPosition.getY() + 0.5D, (double) this.worldPosition.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Override
    public void clearContent() {
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            itemHandler.setStackInSlot(i, ItemStack.EMPTY);
        }
    }

    public boolean canPlaceItem(int pIndex, @NotNull ItemStack pStack) {
        return itemHandler.isItemValid(pIndex, pStack);
    }

    /*DATA*/

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {

        @Override
        protected void onContentsChanged(int slot) {

            // To make sure the TE persists when the chunk is saved later we need to
            // mark it dirty every time the item handler changes
            setChanged();
        }

        @Override
        public boolean isItemValid(int pIndex, @Nonnull ItemStack pStack) {
            if (pIndex == RESULT_SLOT) {
                return false;
            }

            if (pIndex == FUEL_SLOT) {
                return net.minecraftforge.common.ForgeHooks.getBurnTime(pStack, RecipeType.BLASTING) > 0;
            }

            if (pIndex == INGREDIENT_SLOT_1) {
                List<DoubleFurnaceRecipe> list = Objects.requireNonNull(level).getRecipeManager().getAllRecipesFor(DoubleFurnaceRecipe.Type.INSTANCE);

                for (DoubleFurnaceRecipe r : list) {
                    if (r.getIngredient1().test(pStack)) {
                        if (itemHandler.getStackInSlot(INGREDIENT_SLOT_2).isEmpty() || r.getIngredient2().test(itemHandler.getStackInSlot(INGREDIENT_SLOT_2))) {
                            return true;
                        }
                    }
                }
            }

            if (pIndex == INGREDIENT_SLOT_2) {
                List<DoubleFurnaceRecipe> list = Objects.requireNonNull(level).getRecipeManager().getAllRecipesFor(DoubleFurnaceRecipe.Type.INSTANCE);

                for (DoubleFurnaceRecipe r : list) {
                    if (r.getIngredient2().test(pStack)) {
                        if (itemHandler.getStackInSlot(INGREDIENT_SLOT_1).isEmpty() || r.getIngredient1().test(itemHandler.getStackInSlot(INGREDIENT_SLOT_1))) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        @Override
        @Nonnull
        public ItemStack extractItem(int slot, int amount, boolean simulate) {
            if (slot == RESULT_SLOT) {
                return super.extractItem(slot, amount, simulate);
            } else {
                return ItemStack.EMPTY;
            }
        }
    };

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        handler.invalidate();
    }

    /*Minecraft Chedt/Furnace Stuff*/
    private LockCode lockKey = LockCode.NO_LOCK;
    private Component name;

    public void setCustomName(Component pName) {
        this.name = pName;
    }

    @Override
    public @NotNull Component getName() {
        return this.name != null ? this.name : this.getDefaultName();
    }

    @Override
    public @NotNull Component getDisplayName() {
        return this.getName();
    }

    @Override
    @Nullable
    public Component getCustomName() {
        return this.name;
    }

    protected Component getDefaultName() {
        return Component.translatable("container.double_furnace");
    }

    public boolean canOpen(Player pPlayer) {
        return canUnlock(pPlayer, this.lockKey, this.getDisplayName());
    }


    /*GUI*/
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pInventory, @NotNull Player pPlayer) {
        return new DoubleFurnaceMenu(pContainerId, pInventory, this, this.dataAccess);
    }


    /*Data Provider*/
    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int p_58431_) {
            return switch (p_58431_) {
                case 0 -> DoubleFurnaceBE.this.litTime;
                case 1 -> DoubleFurnaceBE.this.litDuration;
                case 2 -> DoubleFurnaceBE.this.cookingProgress;
                case 3 -> DoubleFurnaceBE.this.cookingTotalTime;
                default -> 0;
            };
        }

        public void set(int p_58433_, int p_58434_) {
            switch (p_58433_) {
                case 0 -> DoubleFurnaceBE.this.litTime = p_58434_;
                case 1 -> DoubleFurnaceBE.this.litDuration = p_58434_;
                case 2 -> DoubleFurnaceBE.this.cookingProgress = p_58434_;
                case 3 -> DoubleFurnaceBE.this.cookingTotalTime = p_58434_;
            }

        }

        public int getCount() {
            return 4;
        }
    };
}

