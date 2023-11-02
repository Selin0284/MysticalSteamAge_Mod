package net.arjuna.mysticalSteamAge.event;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MysticalSteamAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MysticalSteamAgeEventBusEvents {

    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
       /* event.put(MysticalSteamAgeEntitiesRegister.FLOWER_HORSE.get(), FlowerHorseEntity.createBaseHorseAttributes().build());
        event.put(MysticalSteamAgeEntitiesRegister.ROADIE.get(), RoadieEntity.createBaseRoadieAttributes().build());*/
    }

}
