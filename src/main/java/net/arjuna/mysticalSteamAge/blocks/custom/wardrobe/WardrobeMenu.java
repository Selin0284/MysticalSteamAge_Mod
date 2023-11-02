package net.arjuna.mysticalSteamAge.blocks.custom.wardrobe;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;

public class WardrobeMenu extends ChestMenu {

    public WardrobeMenu(MenuType<?> menuType, int pId, Inventory inventory, Container container, int rows) {
        super(menuType, pId, inventory, container, rows);
    }

    public static WardrobeMenu oneRow(int pId, Inventory pPlayer, Container pBlockEntity) {
        return new WardrobeMenu(MenuType.GENERIC_9x1, pId, pPlayer, pBlockEntity, 1);
    }

    public static WardrobeMenu twoRows(int pId, Inventory pPlayer, Container pBlockEntity) {
        return new WardrobeMenu(MenuType.GENERIC_9x2, pId, pPlayer, pBlockEntity,2);
    }

    public static WardrobeMenu threeRows(int pId, Inventory pPlayer, Container pBlockEntity) {
        return new WardrobeMenu(MenuType.GENERIC_9x3, pId, pPlayer, pBlockEntity, 3);
    }

    public static WardrobeMenu fourRows(int pId, Inventory pPlayer, Container pBlockEntity) {
        return new WardrobeMenu(MenuType.GENERIC_9x4, pId, pPlayer, pBlockEntity, 4);
    }

    public static WardrobeMenu fiveRows(int pId, Inventory pPlayer, Container pBlockEntity) {
        return new WardrobeMenu(MenuType.GENERIC_9x5, pId, pPlayer, pBlockEntity, 5);
    }

    public static WardrobeMenu sixRows(int pId, Inventory pPlayer,  Container pBlockEntity) {
        return new WardrobeMenu(MenuType.GENERIC_9x6, pId, pPlayer, pBlockEntity, 6);
    }
}
