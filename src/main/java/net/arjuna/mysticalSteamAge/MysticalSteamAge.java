package net.arjuna.mysticalSteamAge;

import com.mojang.logging.LogUtils;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeBlocksRegister;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeMachinesRegister;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.MysticalSteamAgeMachineRecipes;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.MysticalSteamAgeMenuTypes;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.carpenterWorkbench.CarpenterWorkbenchScreen;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace.DoubleFurnaceScreen;
import net.arjuna.mysticalSteamAge.event.loot.MysticalSteamAgeLootModifiers;
import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.arjuna.mysticalSteamAge.items.custom.Potions;
import net.arjuna.mysticalSteamAge.items.custom.armor.EntityAINearestAttackableTarget;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MysticalSteamAge.MOD_ID)
public class MysticalSteamAge {

    public static final String MOD_ID = "mysticalsteamage";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MysticalSteamAge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MysticalSteamAgeItemsRegister.register(eventBus);
        MysticalSteamAgeBlocksRegister.register(eventBus);

        MysticalSteamAgeCreativeTabs.register(eventBus);
        MysticalSteamAgeLootModifiers.register(eventBus);

        MysticalSteamAgeMachinesRegister.register(eventBus);
        MysticalSteamAgeMachineRecipes.register(eventBus);
        MysticalSteamAgeMenuTypes.register(eventBus);

        eventBus.addListener(this::commonSetup);

        IEventBus bus = MinecraftForge.EVENT_BUS;
        //bus.addListener(Ores::onBiomeLoadingEvent);
        //bus.addListener(Trees::onBiomeLoadingEvent);
        //bus.addListener(Flowers::onBiomeLoadingEvent);
        //bus.addListener(MysticalSteamAgeEntities::addBiomeSpawn);
        bus.addListener(this::furnaceFuelBurnTimeEvent);
        bus.addListener(this::onPlayerInteract);
        bus.addListener(this::onAttackEntity);
        bus.addListener(this::entityJoinWorld);
        bus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.feather_herb.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.dust_flower.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.fire_flower.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.ice_flower.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.irrlicht.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.purple_rose.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.pink_fern.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.star_flower.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.white_rose.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.camas.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.cloud_bush.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.fire_bush.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.shadow_fern.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.silver_umbrella.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.potted_dust_flower.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.potted_fire_flower.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.potted_ice_flower.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.potted_irrlicht.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.potted_purple_rose.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.potted_pink_fern.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.potted_star_flower.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.potted_white_rose.get(), RenderType.cutout());
       /* ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.baobab_sapling.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.potted_baobab_sapling.get(), RenderType.cutout());*/
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.baobab_leaves.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.baobab_door.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.baobab_trapdoor.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.studded_wooden_door_1.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.studded_wooden_door_2.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MysticalSteamAgeBlocksRegister.studded_wooden_door_3.get(), RenderType.translucent());

            MenuScreens.register(MysticalSteamAgeMenuTypes.double_furnace_menu.get(), DoubleFurnaceScreen::new);
            MenuScreens.register(MysticalSteamAgeMenuTypes.carpenter_workbench_menu.get(), CarpenterWorkbenchScreen::new);


        }

        @SubscribeEvent
        public static void registerColors(RegisterColorHandlersEvent.Item event) {
            Potions.POTIONS_LIST.forEach(potions ->
                    event.getItemColors().register((stack, layer) -> potions.getColor(layer), potions)
            );
            event.getItemColors().register((p_92708_, p_92709_) -> p_92709_ > 0 ? -1 : (
                    (DyeableLeatherItem) p_92708_.getItem()).getColor(p_92708_), MysticalSteamAgeItemsRegister.roadie_leather_armor.get()
            );
        }
    }

    public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
        if (event.getItemStack().getItem() == MysticalSteamAgeBlocksRegister.stick_bundle_block.get().asItem()) {
            event.setBurnTime(1000);
        }
    }

    public void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        ItemStack stack = player.getItemInHand(event.getHand());
        InteractionHand hand = event.getHand();
        if (event.getEntity().getMainHandItem().getItem() == Items.GLASS_BOTTLE) {
            if (event.getTarget() instanceof Cow) {
                player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
                ItemStack itemstack1 = ItemUtils.createFilledResult(stack, player, MysticalSteamAgeItemsRegister.bottle_milk.get().getDefaultInstance());
                player.setItemInHand(hand, itemstack1);
            }
        }
    }

    private boolean isRedArmor(ItemStack stack) {
        return stack.getItem() == MysticalSteamAgeItemsRegister.red_hardened_leather_helmet.get() ||
                stack.getItem() == MysticalSteamAgeItemsRegister.red_hardened_leather_chestplate.get() ||
                stack.getItem() == MysticalSteamAgeItemsRegister.red_hardened_leather_leggings.get() ||
                stack.getItem() == MysticalSteamAgeItemsRegister.red_hardened_leather_boots.get();
    }

    private boolean isBrownArmor(ItemStack stack) {
        return stack.getItem() == MysticalSteamAgeItemsRegister.brown_hardened_leather_helmet.get() ||
                stack.getItem() == MysticalSteamAgeItemsRegister.brown_hardened_leather_chestplate.get() ||
                stack.getItem() == MysticalSteamAgeItemsRegister.brown_hardened_leather_leggings.get() ||
                stack.getItem() == MysticalSteamAgeItemsRegister.brown_hardened_leather_boots.get();
    }

    private boolean isLightGreenArmor(ItemStack stack) {
        return stack.getItem() == MysticalSteamAgeItemsRegister.light_green_hardened_leather_helmet.get() ||
                stack.getItem() == MysticalSteamAgeItemsRegister.light_green_hardened_leather_chestplate.get() ||
                stack.getItem() == MysticalSteamAgeItemsRegister.light_green_hardened_leather_leggings.get() ||
                stack.getItem() == MysticalSteamAgeItemsRegister.light_green_hardened_leather_boots.get();
    }

    private boolean isWhiteArmor(ItemStack stack) {
        return stack.getItem() == MysticalSteamAgeItemsRegister.white_hardened_leather_helmet.get() ||
                stack.getItem() == MysticalSteamAgeItemsRegister.white_hardened_leather_chestplate.get() ||
                stack.getItem() == MysticalSteamAgeItemsRegister.white_hardened_leather_leggings.get() ||
                stack.getItem() == MysticalSteamAgeItemsRegister.white_hardened_leather_boots.get();
    }


    public void onAttackEntity(LivingAttackEvent event) {
        if(event.getSource().is(DamageTypes.ON_FIRE)) {
            if(event.getEntity() instanceof Player player) {

                ItemStack boots = player.getInventory().getArmor(0);
                ItemStack leggings = player.getInventory().getArmor(1);
                ItemStack breastplate = player.getInventory().getArmor(2);
                ItemStack helmet = player.getInventory().getArmor(3);

                if(this.isRedArmor(helmet) && this.isRedArmor(breastplate) && this.isRedArmor(leggings) && this.isRedArmor(boots)) {
                    event.setCanceled(true);
                    player.clearFire();
                }
            }
        } else if(event.getSource().is(DamageTypes.FALL)) {
            if(event.getEntity() instanceof Player player) {

                ItemStack boots = player.getInventory().getArmor(0);
                ItemStack leggings = player.getInventory().getArmor(1);
                ItemStack breastplate = player.getInventory().getArmor(2);
                ItemStack helmet = player.getInventory().getArmor(3);

                if(this.isBrownArmor(helmet) && this.isBrownArmor(breastplate) && this.isBrownArmor(leggings) && this.isBrownArmor(boots)) {
                    event.setCanceled(true);
                }
                if(this.isLightGreenArmor(helmet) && this.isLightGreenArmor(breastplate) && this.isLightGreenArmor(leggings) && this.isLightGreenArmor(boots)) {
                    event.setCanceled(true);
                }
                if(this.isWhiteArmor(helmet) && this.isWhiteArmor(breastplate) && this.isWhiteArmor(leggings) && this.isWhiteArmor(boots)) {
                    event.setCanceled(true);
                }
            }
        }
    }

    public void entityJoinWorld(EntityJoinLevelEvent event) {
        if(event.getEntity() instanceof Creeper creeper) {
            creeper.targetSelector.removeAllGoals((p_262562_) -> {
                return p_262562_ instanceof NearestAttackableTargetGoal;
            });
            creeper.targetSelector.addGoal(1, new EntityAINearestAttackableTarget<>(creeper, Player.class, true));
        }
    }
}
