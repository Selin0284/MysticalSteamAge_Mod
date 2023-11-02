package net.arjuna.mysticalSteamAge.items.custom;

import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Potions extends Item {
    public static final List<Potions> POTIONS_LIST = new ArrayList<>();
    private final int backgroundColor;

    public Potions(int pBackgroundColor, Properties pProperties) {
        super(pProperties);
        this.backgroundColor = pBackgroundColor;
        POTIONS_LIST.add(this);
    }

    public int getColor(int pTintIndex) {
        return pTintIndex == 0 ? -1 : this.backgroundColor;
    }

}
