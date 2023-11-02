package net.arjuna.mysticalSteamAge.blocks;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.carpenterWorkbench.CarpenterWorkbenchMenu;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace.DoubleFurnaceBE;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace.DoubleFurnaceMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = MysticalSteamAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MysticalSteamAgeMachinesRegister {

    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MysticalSteamAge.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

    // Machines
    public static final RegistryObject<BlockEntityType<DoubleFurnaceBE>> double_furnace_be = BLOCK_ENTITIES.register("double_furnace", () ->
            BlockEntityType.Builder.of(DoubleFurnaceBE::new, MysticalSteamAgeBlocksRegister.double_furnace.get()).build(null));

}
