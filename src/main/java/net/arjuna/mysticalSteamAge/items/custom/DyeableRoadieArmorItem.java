package net.arjuna.mysticalSteamAge.items.custom;

import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;

public class DyeableRoadieArmorItem extends RoadieArmorItem implements DyeableLeatherItem {
    /**
     *
     * @param pProtection the given protection level of the {@code ChocoArmorItem}
     * @param pIdentifier the texture path identifier for the {@code DyeableChocoArmorItem}
     * @param pProperties the item properties
     */
    public DyeableRoadieArmorItem(int pProtection, String pIdentifier, Item.Properties pProperties) {
        super(pProtection, pIdentifier, pProperties);
    }
    /**
     *
     * @param pProtection the given protection level of the {@code ChocoArmorItem}
     * @param pIdentifier the texture path identifier for the {@code DyeableChocoArmorItem}
     * @param pProperties the item properties
     */
    public DyeableRoadieArmorItem(int pProtection, net.minecraft.resources.ResourceLocation pIdentifier, Item.Properties pProperties) {
        super(pProtection, pIdentifier, pProperties);
    }
}