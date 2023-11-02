package net.arjuna.mysticalSteamAge.blocks.custom.machines;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.carpenterWorkbench.CarpenterWorkbenchMenu;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace.DoubleFurnaceBE;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace.DoubleFurnaceMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MysticalSteamAgeMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, MysticalSteamAge.MOD_ID);

    public static final RegistryObject<MenuType<DoubleFurnaceMenu>> double_furnace_menu =
            registerMenuType("double_furnace_menu", DoubleFurnaceMenu::new);

    public static final RegistryObject<MenuType<CarpenterWorkbenchMenu>> carpenter_workbench_menu =
            registerMenuType("carpenter_workbench_menu", CarpenterWorkbenchMenu::new);


    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
