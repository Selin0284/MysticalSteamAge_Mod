package net.arjuna.mysticalSteamAge.items.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class RoadieArmorItem extends Item {
    private final int protection;
    private final ResourceLocation texture;

    /**
     *
     * @param pProtection the given protection level of the {@code ChocoArmorItem}
     * @param pIdentifier the texture path identifier for the {@code DyeableChocoArmorItem}
     * @param pProperties the item properties
     */
    public RoadieArmorItem(int pProtection, String pIdentifier, Properties pProperties) {
        this(pProtection, new ResourceLocation("textures/entity/armor/birdy_" + pIdentifier + "_armor.png"), pProperties);
    }

    /**
     *
     * @param pProtection the given protection level of the {@code HorseArmorItem}
     * @param pIdentifier the texture path identifier for the {@code DyeableChocoArmorItem}
     * @param pProperties the item properties
     */
    public RoadieArmorItem(int pProtection, ResourceLocation pIdentifier, Properties pProperties) {
        super(pProperties);
        this.protection = pProtection;
        this.texture = pIdentifier;
    }

    public @NotNull ResourceLocation getTexture() {
        return texture;
    }

    public int getProtection() {
        return this.protection;
    }
}
