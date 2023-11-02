package net.arjuna.mysticalSteamAge.items.custom;

import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class FeatherHerbSeed extends BlockItem {
    public FeatherHerbSeed(Block block, Properties props) {
        super(block, props);
    }

    @Override
    public @NotNull String getDescriptionId() {
        return Util.makeDescriptionId("item", BuiltInRegistries.ITEM.getKey(this));
    }
}
