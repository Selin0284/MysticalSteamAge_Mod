package net.arjuna.mysticalSteamAge.items.custom;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum CustomArmorMaterials implements ArmorMaterial {
    BLUE_HARDENED_LEATHER("blue_cloth", 15, new int[]{1, 4, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
        Ingredient.of(MysticalSteamAgeItemsRegister.blue_hardened_leather.get())
    ),
    BROWN_HARDENED_LEATHER("brown_cloth", 15, new int[]{1, 4, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
            Ingredient.of(MysticalSteamAgeItemsRegister.brown_hardened_leather.get())
    ),
    BLACK_HARDENED_LEATHER("black_cloth", 15, new int[]{1, 4, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
            Ingredient.of(MysticalSteamAgeItemsRegister.black_hardened_leather.get())
    ),
    GREEN_HARDENED_LEATHER("green_cloth", 15, new int[]{1, 4, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
            Ingredient.of(MysticalSteamAgeItemsRegister.green_hardened_leather.get())
    ),
    LIGHT_GREEN_HARDENED_LEATHER("light_green_cloth", 15, new int[]{1, 4, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
            Ingredient.of(MysticalSteamAgeItemsRegister.light_green_hardened_leather.get())
    ),
    PURPLE_HARDENED_LEATHER("purple_cloth", 15, new int[]{1, 4, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
            Ingredient.of(MysticalSteamAgeItemsRegister.purple_hardened_leather.get())
    ),
    RED_HARDENED_LEATHER("red_cloth", 15, new int[]{1, 4, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
            Ingredient.of(MysticalSteamAgeItemsRegister.red_hardened_leather.get())
    ),
    WHITE_HARDENED_LEATHER("white_cloth", 15, new int[]{1, 4, 5, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () ->
            Ingredient.of(MysticalSteamAgeItemsRegister.white_hardened_leather.get())
    ),
    DEVIL_IRON("devil_iron", 20, new int[]{2, 5, 6, 2}, 20, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () ->
            Ingredient.of(MysticalSteamAgeItemsRegister.devil_iron_ingot.get())
    );

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    CustomArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness,
                         float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    public int getDurabilityForType(ArmorItem.Type pType) {
        return HEALTH_PER_SLOT[pType.getSlot().getIndex()] * this.durabilityMultiplier;
    }


    public int getDefenseForType(ArmorItem.Type pType) {
        return this.slotProtections[pType.getSlot().getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public @NotNull SoundEvent getEquipSound() {
        return this.sound;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public @NotNull String getName() {
        return MysticalSteamAge.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}