package net.arjuna.mysticalSteamAge.event;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MysticalSteamAge.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MysticalSteamAgeEventBusClientEvents {

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        /*event.registerLayerDefinition(MysticalSteamAgeModelLayer.FLOWER_HORSE_LAYER, FlowerHorseModel::createBodyLayer);
        event.registerLayerDefinition(MysticalSteamAgeModelLayer.ROADIE_LAYER, RoadieModel::createBodyLayer);*/
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        /*EntityRenderers.register(MysticalSteamAgeEntitiesRegister.ROADIE.get(), RoadieRenderer::new);*/
    }

}
