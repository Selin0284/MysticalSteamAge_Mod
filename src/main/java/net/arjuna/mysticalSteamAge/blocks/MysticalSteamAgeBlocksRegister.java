package net.arjuna.mysticalSteamAge.blocks;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.blocks.custom.*;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.carpenterWorkbench.CarpenterWorkbenchBlock;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace.DoubleFurnaceBlock;
import net.arjuna.mysticalSteamAge.blocks.custom.trees.FlammableRotatedPillarBlock;
import net.arjuna.mysticalSteamAge.blocks.custom.wardrobe.WardrobeBlock;
import net.arjuna.mysticalSteamAge.blocks.custom.wardrobe.WardrobeBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.ToIntFunction;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class MysticalSteamAgeBlocksRegister {

    public static final Item.Properties PROPERTIES = new Item.Properties();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MysticalSteamAge.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MysticalSteamAge.MOD_ID);
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MysticalSteamAge.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ENTITIES.register(eventBus);
        ITEMS.register(eventBus);
    }

    // Machines
    public static final RegistryObject<DoubleFurnaceBlock> double_furnace = BLOCKS.register("double_furnace", () ->
            new DoubleFurnaceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3.5F).lightLevel(litBlockEmission(13))));
    public static final RegistryObject<Item> double_furnace_item = fromBlock(double_furnace, PROPERTIES);
    public static final RegistryObject<CarpenterWorkbenchBlock> carpenter_workbench = BLOCKS.register("carpenter_workbench", () ->
            new CarpenterWorkbenchBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.5F).sound(SoundType.WOOD).noCollission()));
    public static final RegistryObject<Item> carpenter_workbench_item = fromBlock(carpenter_workbench, PROPERTIES);
    // Blocks
    public static final RegistryObject<Block> brass_block = BLOCKS.register("brass_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
    public static final RegistryObject<Item> brass_block_item = fromBlock(brass_block, new Item.Properties());
    public static final RegistryObject<Block> bronze_block = BLOCKS.register("bronze_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
    public static final RegistryObject<Item> bronze_block_item = fromBlock(bronze_block, new Item.Properties());
    public static final RegistryObject<Block> tin_block = BLOCKS.register("tin_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
    public static final RegistryObject<Item> tin_block_item = fromBlock(tin_block, new Item.Properties());
    public static final RegistryObject<Block> zinc_block = BLOCKS.register("zinc_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
    public static final RegistryObject<Item> zinc_block_item = fromBlock(zinc_block, PROPERTIES);
    public static final RegistryObject<Block> devil_iron_block = BLOCKS.register("devil_iron_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> devil_iron_block_item = fromBlock(devil_iron_block, PROPERTIES);
    public static final RegistryObject<Block> steel_block = BLOCKS.register("steel_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.5F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> steel_block_item = fromBlock(steel_block, PROPERTIES);
    public static final RegistryObject<Block> salt_block = BLOCKS.register("salt_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(0.4F).sound(SoundType.SAND)));
    public static final RegistryObject<Item> salt_block_item = fromBlock(salt_block, PROPERTIES);

    // Ores
    public static final RegistryObject<Block> deepslate_sulphur_ore = BLOCKS.register("deepslate_sulphur_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Item> deepslate_sulphur_ore_item = fromBlock(deepslate_sulphur_ore, PROPERTIES);
    public static final RegistryObject<Block> deepslate_tin_ore = BLOCKS.register("deepslate_tin_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Item> deepslate_tin_ore_item = fromBlock(deepslate_tin_ore, PROPERTIES);
    public static final RegistryObject<Block> deepslate_zinc_ore = BLOCKS.register("deepslate_zinc_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Item> deepslate_zinc_ore_item = fromBlock(deepslate_zinc_ore, PROPERTIES);
    public static final RegistryObject<Block> nether_coal_ore = BLOCKS.register("nether_coal_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(0, 2)));
    public static final RegistryObject<Item> nether_coal_ore_item = fromBlock(nether_coal_ore, PROPERTIES);
    public static final RegistryObject<Block> nether_devil_iron_ore = BLOCKS.register("nether_devil_iron_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
    public static final RegistryObject<Item> nether_devil_iron_ore_item = fromBlock(nether_devil_iron_ore, PROPERTIES);
    public static final RegistryObject<Block> nether_sulphur_ore = BLOCKS.register("nether_sulphur_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
    public static final RegistryObject<Item> nether_sulphur_ore_item = fromBlock(nether_sulphur_ore, PROPERTIES);
    public static final RegistryObject<Block> tin_ore = BLOCKS.register("tin_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.5F, 3.0F)));
    public static final RegistryObject<Item> tin_ore_item = fromBlock(tin_ore, PROPERTIES);
    public static final RegistryObject<Block> zinc_ore = BLOCKS.register("zinc_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.5F, 3.0F)));
    public static final RegistryObject<Item> zinc_ore_item = fromBlock(zinc_ore, PROPERTIES);
    public static final RegistryObject<Block> salt_ore = BLOCKS.register("salt_ore", () ->
            new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
    public static final RegistryObject<Item> salt_ore_item = fromBlock(salt_ore, PROPERTIES);

    // BlockDeco Marble
    public static final RegistryObject<Block> marble = BLOCKS.register("marble", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Item> marble_item = fromBlock(marble, PROPERTIES);

    public static final RegistryObject<Block> marble_stairs = BLOCKS.register("marble_stairs", () ->
            new StairBlock(marble.get().defaultBlockState(), BlockBehaviour.Properties.copy(marble.get())));
    public static final RegistryObject<Item> marble_stairs_item = fromBlock(marble_stairs, PROPERTIES);
    public static final RegistryObject<Block> marble_slab = BLOCKS.register("marble_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(marble.get())));
    public static final RegistryObject<Item> marble_slab_item = fromBlock(marble_slab, PROPERTIES);
    public static final RegistryObject<Block> marble_wall = BLOCKS.register("marble_wall", () ->
            new WallBlock(BlockBehaviour.Properties.copy(marble.get())));
    public static final RegistryObject<Item> marble_wall_item = fromBlock(marble_wall, PROPERTIES);
    public static final RegistryObject<Block> marble_pillar = BLOCKS.register("marble_pillar", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.copy(marble.get())));
    public static final RegistryObject<Item> marble_pillar_item = fromBlock(marble_pillar, PROPERTIES);
    public static final RegistryObject<Block> polished_marble = BLOCKS.register("polished_marble", () ->
            new Block(BlockBehaviour.Properties.copy(marble.get())));
    public static final RegistryObject<Item> polished_marble_item = fromBlock(polished_marble, PROPERTIES);
    public static final RegistryObject<Block> polished_marble_slab = BLOCKS.register("polished_marble_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(polished_marble.get())));
    public static final RegistryObject<Item> polished_marble_slab_item = fromBlock(polished_marble_slab, PROPERTIES);
    public static final RegistryObject<Block> polished_marble_stairs = BLOCKS.register("polished_marble_stairs", () ->
            new StairBlock(polished_marble.get().defaultBlockState(), BlockBehaviour.Properties.copy(polished_marble.get())));
    public static final RegistryObject<Item> polished_marble_stairs_item = fromBlock(polished_marble_stairs, PROPERTIES);
    public static final RegistryObject<Block> marble_brick = BLOCKS.register("marble_brick", () ->
            new Block(BlockBehaviour.Properties.copy(marble.get())));
    public static final RegistryObject<Item> marble_bricks_item = fromBlock(marble_brick, PROPERTIES);
    public static final RegistryObject<Block> marble_bricks_stairs = BLOCKS.register("marble_bricks_stairs", () ->
            new StairBlock(marble_brick.get().defaultBlockState(), BlockBehaviour.Properties.copy(marble_brick.get())));
    public static final RegistryObject<Item> marble_bricks_stairs_item = fromBlock(marble_bricks_stairs, PROPERTIES);
    public static final RegistryObject<Block> marble_bricks_slab = BLOCKS.register("marble_bricks_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(marble_brick.get())));
    public static final RegistryObject<Item> marble_bricks_slab_item = fromBlock(marble_bricks_slab, PROPERTIES);
    public static final RegistryObject<Block> marble_bricks_wall = BLOCKS.register("marble_bricks_wall", () ->
            new WallBlock(BlockBehaviour.Properties.copy(marble_brick.get())));
    public static final RegistryObject<Item> marble_bricks_wall_item = fromBlock(marble_bricks_wall, PROPERTIES);

    public static final RegistryObject<Block> marble_black = BLOCKS.register("marble_black", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Item> marble_black_item = fromBlock(marble_black, PROPERTIES);

    public static final RegistryObject<Block> marble_black_stairs = BLOCKS.register("marble_black_stairs", () ->
            new StairBlock(marble_black.get().defaultBlockState(), BlockBehaviour.Properties.copy(marble_black.get())));
    public static final RegistryObject<Item> marble_black_stairs_item = fromBlock(marble_black_stairs, PROPERTIES);
    public static final RegistryObject<Block> marble_black_slab = BLOCKS.register("marble_black_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(marble_black.get())));
    public static final RegistryObject<Item> marble_black_slab_item = fromBlock(marble_black_slab, PROPERTIES);
    public static final RegistryObject<Block> marble_black_wall = BLOCKS.register("marble_black_wall", () ->
            new WallBlock(BlockBehaviour.Properties.copy(marble_black.get())));
    public static final RegistryObject<Item> marble_black_wall_item = fromBlock(marble_black_wall, PROPERTIES);
    public static final RegistryObject<Block> marble_black_pillar = BLOCKS.register("marble_black_pillar", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.copy(marble_black.get())));
    public static final RegistryObject<Item> marble_black_pillar_item = fromBlock(marble_black_pillar, PROPERTIES);
    public static final RegistryObject<Block> polished_marble_black = BLOCKS.register("polished_marble_black", () ->
            new Block(BlockBehaviour.Properties.copy(marble_black.get())));
    public static final RegistryObject<Item> polished_marble_black_item = fromBlock(polished_marble_black, PROPERTIES);
    public static final RegistryObject<Block> polished_marble_black_slab = BLOCKS.register("polished_marble_black_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(polished_marble_black.get())));
    public static final RegistryObject<Item> polished_marble_black_slab_item = fromBlock(polished_marble_black_slab, PROPERTIES);
    public static final RegistryObject<Block> polished_marble_black_stairs = BLOCKS.register("polished_marble_black_stairs", () ->
            new StairBlock(polished_marble_black.get().defaultBlockState(), BlockBehaviour.Properties.copy(polished_marble_black.get())));
    public static final RegistryObject<Item> polished_marble_black_stairs_item = fromBlock(polished_marble_black_stairs, PROPERTIES);
    public static final RegistryObject<Block> marble_black_brick = BLOCKS.register("marble_black_brick", () ->
            new Block(BlockBehaviour.Properties.copy(marble_black.get())));
    public static final RegistryObject<Item> marble_black_bricks_item = fromBlock(marble_black_brick, PROPERTIES);
    public static final RegistryObject<Block> marble_black_bricks_stairs = BLOCKS.register("marble_black_bricks_stairs", () ->
            new StairBlock(marble_black_brick.get().defaultBlockState(), BlockBehaviour.Properties.copy(marble_black_brick.get())));
    public static final RegistryObject<Item> marble_black_bricks_stairs_item = fromBlock(marble_black_bricks_stairs, PROPERTIES);
    public static final RegistryObject<Block> marble_black_bricks_slab = BLOCKS.register("marble_black_bricks_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(marble_black_brick.get())));
    public static final RegistryObject<Item> marble_black_bricks_slab_item = fromBlock(marble_black_bricks_slab, PROPERTIES);
    public static final RegistryObject<Block> marble_black_bricks_wall = BLOCKS.register("marble_black_bricks_wall", () ->
            new WallBlock(BlockBehaviour.Properties.copy(marble_black_brick.get())));
    public static final RegistryObject<Item> marble_black_bricks_wall_item = fromBlock(marble_black_bricks_wall, PROPERTIES);

    public static final RegistryObject<Block> oak_wardrobe = BLOCKS.register("oak_wardrobe", () ->
            new WardrobeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> oak_wardrobe_item = fromBlock(oak_wardrobe, PROPERTIES);
    public static final RegistryObject<Block> spruce_wardrobe = BLOCKS.register("spruce_wardrobe", () ->
            new WardrobeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> spruce_wardrobe_item = fromBlock(spruce_wardrobe, PROPERTIES);
    public static final RegistryObject<Block> birch_wardrobe = BLOCKS.register("birch_wardrobe", () ->
            new WardrobeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> birch_wardrobe_item = fromBlock(birch_wardrobe, PROPERTIES);
    public static final RegistryObject<Block> jungle_wardrobe = BLOCKS.register("jungle_wardrobe", () ->
            new WardrobeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> jungle_wardrobe_item = fromBlock(jungle_wardrobe, PROPERTIES);
    public static final RegistryObject<Block> acacia_wardrobe = BLOCKS.register("acacia_wardrobe", () ->
            new WardrobeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> acacia_wardrobe_item = fromBlock(acacia_wardrobe, PROPERTIES);
    public static final RegistryObject<Block> dark_oak_wardrobe = BLOCKS.register("dark_oak_wardrobe", () ->
            new WardrobeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> dark_oak_wardrobe_item = fromBlock(dark_oak_wardrobe, PROPERTIES);
    public static final RegistryObject<Block> baobab_wardrobe = BLOCKS.register("baobab_wardrobe", () ->
            new WardrobeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> baobab_wardrobe_item = fromBlock(baobab_wardrobe, PROPERTIES);

    public static final RegistryObject<BlockEntityType<WardrobeBlockEntity>> wardrobe_block_be = BLOCK_ENTITIES.register("wardrobe_block", () ->
            BlockEntityType.Builder.of(WardrobeBlockEntity::new, oak_wardrobe.get(), spruce_wardrobe.get(), birch_wardrobe.get(),
                    jungle_wardrobe.get(), acacia_wardrobe.get(), dark_oak_wardrobe.get()).build(null));

    // BlockDeco Plants & Wood
    public static final RegistryObject<Block> feather_herb_block = BLOCKS.register("feather_herb_block", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).strength(0.5F).sound(SoundType.GRASS)));
    public static final RegistryObject<Item> feather_herb_block_item = fromBlock(feather_herb_block, PROPERTIES);
    public static final RegistryObject<Block> feather_herb = BLOCKS.register("feather_herb", () ->
            new FeatherHerbBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> camas = BLOCKS.register("camas", () ->
            new CamasBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> stick_bundle_block = BLOCKS.register("stick_bundle_block", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> stick_bundle_block_item = fromBlock(stick_bundle_block, PROPERTIES);

    public static final RegistryObject<Block> baobab_log = BLOCKS.register("baobab_log", () ->
            new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Item> baobab_log_item = fromBlock(baobab_log, PROPERTIES);
    public static final RegistryObject<Block> baobab_wood = BLOCKS.register("baobab_wood", () ->
            new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Item> baobab_wood_item = fromBlock(baobab_wood, PROPERTIES);
    public static final RegistryObject<Block> baobab_planks = BLOCKS.register("baobab_planks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            });
    public static final RegistryObject<Item> baobab_planks_item = fromBlock(baobab_planks, PROPERTIES);

    public static final RegistryObject<Block> baobab_leaves = BLOCKS.register("baobab_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            });
    public static final RegistryObject<Item> baobab_leaves_item = fromBlock(baobab_leaves, PROPERTIES);
    /*public static final RegistryObject<Block> baobab_sapling = BLOCKS.register("baobab_sapling", () ->
            new SaplingBlock(new BaobabTree(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Item> baobab_sapling_item = fromBlock(baobab_sapling, PROPERTIES);
    public static final RegistryObject<Block> potted_baobab_sapling = BLOCKS.register("potted_baobab_sapling", () ->
            new FlowerPotBlock(baobab_sapling.get(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().noOcclusion()));*/

    public static final RegistryObject<Block> baobab_stairs = BLOCKS.register("baobab_stairs", () ->
            new StairBlock(baobab_planks.get().defaultBlockState(), BlockBehaviour.Properties.copy(baobab_planks.get())){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            });
    public static final RegistryObject<Item> baobab_stairs_item = fromBlock(baobab_stairs, PROPERTIES);
    public static final RegistryObject<Block> baobab_slab = BLOCKS.register("baobab_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.of().mapColor(baobab_planks.get().defaultMapColor()).strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            });
    public static final RegistryObject<Item> baobab_slab_item = fromBlock(baobab_slab, PROPERTIES);
    public static final RegistryObject<Block> baobab_door = BLOCKS.register("baobab_door", () ->
            new DoorBlock(BlockBehaviour.Properties.of().mapColor(baobab_planks.get().defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava()
                    .pushReaction(PushReaction.DESTROY), BlockSetType.OAK));
    public static final RegistryObject<Item> baobab_door_item = fromBlock(baobab_door, PROPERTIES);
    public static final RegistryObject<Block> baobab_pressure_plate = BLOCKS.register("baobab_pressure_plate", () ->
            new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(baobab_planks.get()
                    .defaultMapColor()).noCollission().strength(0.5F).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Item> baobab_pressure_plate_item = fromBlock(baobab_pressure_plate, PROPERTIES);
    public static final RegistryObject<Block> baobab_trapdoor = BLOCKS.register("baobab_trapdoor", () ->
            new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(baobab_planks.get().defaultMapColor())
                    .strength(3.0F).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Item> baobab_trapdoor_item = fromBlock(baobab_trapdoor, PROPERTIES);
    public static final RegistryObject<Block> baobab_button = BLOCKS.register("baobab_button", () ->
            new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.WOOD), BlockSetType.OAK, 30, true));
    public static final RegistryObject<Item> baobab_button_item = fromBlock(baobab_button, PROPERTIES);
    public static final RegistryObject<Block> baobab_fence_gate = BLOCKS.register("baobab_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(baobab_planks.get().defaultMapColor())
                    .strength(2.0F, 3.0F).sound(SoundType.WOOD), WoodType.OAK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            });
    public static final RegistryObject<Item> baobab_fence_gate_item = fromBlock(baobab_fence_gate, PROPERTIES);
    public static final RegistryObject<Block> baobab_fence = BLOCKS.register("baobab_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.of().mapColor(baobab_planks.get().defaultMapColor())
                    .strength(2.0F, 3.0F).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            });
    public static final RegistryObject<Item> baobab_fence_item = fromBlock(baobab_fence, PROPERTIES);

    // BlockDeco Lamps
    public static final RegistryObject<Block> acacia_lamp = BLOCKS.register("acacia_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> acacia_lamp_item = fromBlock(acacia_lamp, PROPERTIES);
    public static final RegistryObject<Block> birch_lamp = BLOCKS.register("birch_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> birch_lamp_item = fromBlock(birch_lamp, PROPERTIES);
    public static final RegistryObject<Block> dark_oak_lamp = BLOCKS.register("dark_oak_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> dark_oak_lamp_item = fromBlock(dark_oak_lamp, PROPERTIES);
    public static final RegistryObject<Block> jungle_lamp = BLOCKS.register("jungle_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> jungle_lamp_item = fromBlock(jungle_lamp, PROPERTIES);
    public static final RegistryObject<Block> oak_lamp = BLOCKS.register("oak_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> oak_lamp_item = fromBlock(oak_lamp, PROPERTIES);
    public static final RegistryObject<Block> spruce_lamp = BLOCKS.register("spruce_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> spruce_lamp_item = fromBlock(spruce_lamp, PROPERTIES);
    public static final RegistryObject<Block> baobab_lamp = BLOCKS.register("baobab_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.WOOD)));
    public static final RegistryObject<Item> baobab_lamp_item = fromBlock(baobab_lamp, PROPERTIES);

    public static final RegistryObject<Block> andesite_lamp = BLOCKS.register("andesite_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.STONE)));
    public static final RegistryObject<Item> andesite_lamp_item = fromBlock(andesite_lamp, PROPERTIES);
    public static final RegistryObject<Block> cobblestone_lamp = BLOCKS.register("cobblestone_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.STONE)));
    public static final RegistryObject<Item> cobblestone_lamp_item = fromBlock(cobblestone_lamp, PROPERTIES);
    public static final RegistryObject<Block> deepslate_lamp = BLOCKS.register("deepslate_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Item> deepslate_lamp_item = fromBlock(deepslate_lamp, PROPERTIES);
    public static final RegistryObject<Block> diorite_lamp = BLOCKS.register("diorite_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.STONE)));
    public static final RegistryObject<Item> diorite_lamp_item = fromBlock(diorite_lamp, PROPERTIES);
    public static final RegistryObject<Block> granite_lamp = BLOCKS.register("granite_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.STONE)));
    public static final RegistryObject<Item> granite_lamp_item = fromBlock(granite_lamp, PROPERTIES);
    public static final RegistryObject<Block> marble_lamp = BLOCKS.register("marble_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.STONE)));
    public static final RegistryObject<Item> marble_lamp_item = fromBlock(marble_lamp, PROPERTIES);
    public static final RegistryObject<Block> marble_black_lamp = BLOCKS.register("marble_black_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.STONE)));
    public static final RegistryObject<Item> marble_black_lamp_item = fromBlock(marble_black_lamp, PROPERTIES);
    public static final RegistryObject<Block> sand_stone_lamp = BLOCKS.register("sand_stone_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.STONE)));
    public static final RegistryObject<Item> sand_stone_lamp_item = fromBlock(sand_stone_lamp, PROPERTIES);
    public static final RegistryObject<Block> iron_lamp = BLOCKS.register("iron_lamp", () ->
            new LampBlock(BlockBehaviour.Properties.of()
                    .lightLevel(litBlockEmission(15)).strength(0.3F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> iron_lamp_item = fromBlock(iron_lamp, PROPERTIES);

    // BlockDeco Studded Wood Doors
    public static final RegistryObject<Block> studded_wooden_door_1 = BLOCKS.register("studded_wooden_door_1", () ->
            new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).requiresCorrectToolForDrops().strength(3.0F, 1200.0F)
                    .instrument(NoteBlockInstrument.BASS).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Item> studded_wooden_door_1_item = fromBlock(studded_wooden_door_1, PROPERTIES);
    public static final RegistryObject<Block> studded_wooden_door_2 = BLOCKS.register("studded_wooden_door_2", () ->
            new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).requiresCorrectToolForDrops().strength(3.0F, 1200.0F)
                    .instrument(NoteBlockInstrument.BASS).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Item> studded_wooden_door_2_item = fromBlock(studded_wooden_door_2, PROPERTIES);
    public static final RegistryObject<Block> studded_wooden_door_3 = BLOCKS.register("studded_wooden_door_3", () ->
            new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).requiresCorrectToolForDrops().strength(3.0F, 1200.0F)
                    .instrument(NoteBlockInstrument.BASS).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Item> studded_wooden_door_3_item = fromBlock(studded_wooden_door_3, PROPERTIES);

    // BlockDeco Studded Wood
    public static final RegistryObject<Block> acacia_gold_studded_block = BLOCKS.register("acacia_gold_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> acacia_gold_studded_block_item = fromBlock(acacia_gold_studded_block, PROPERTIES);
    public static final RegistryObject<Block> birch_gold_studded_block = BLOCKS.register("birch_gold_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> birch_gold_studded_block_item = fromBlock(birch_gold_studded_block, PROPERTIES);
    public static final RegistryObject<Block> dark_oak_gold_studded_block = BLOCKS.register("dark_oak_gold_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> dark_oak_gold_studded_block_item = fromBlock(dark_oak_gold_studded_block, PROPERTIES);
    public static final RegistryObject<Block> jungle_gold_studded_block = BLOCKS.register("jungle_gold_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> jungle_gold_studded_block_item = fromBlock(jungle_gold_studded_block, PROPERTIES);
    public static final RegistryObject<Block> oak_gold_studded_block = BLOCKS.register("oak_gold_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> oak_gold_studded_block_item = fromBlock(oak_gold_studded_block, PROPERTIES);
    public static final RegistryObject<Block> spruce_gold_studded_block = BLOCKS.register("spruce_gold_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> spruce_gold_studded_block_item = fromBlock(spruce_gold_studded_block, PROPERTIES);
    public static final RegistryObject<Block> baobab_gold_studded_block = BLOCKS.register("baobab_gold_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> baobab_gold_studded_block_item = fromBlock(baobab_gold_studded_block, PROPERTIES);

    public static final RegistryObject<Block> acacia_iron_studded_block = BLOCKS.register("acacia_iron_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> acacia_iron_studded_block_item = fromBlock(acacia_iron_studded_block, PROPERTIES);
    public static final RegistryObject<Block> birch_iron_studded_block = BLOCKS.register("birch_iron_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> birch_iron_studded_block_item = fromBlock(birch_iron_studded_block, PROPERTIES);
    public static final RegistryObject<Block> dark_oak_iron_studded_block = BLOCKS.register("dark_oak_iron_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> dark_oak_iron_studded_block_item = fromBlock(dark_oak_iron_studded_block, PROPERTIES);
    public static final RegistryObject<Block> jungle_iron_studded_block = BLOCKS.register("jungle_iron_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> jungle_iron_studded_block_item = fromBlock(jungle_iron_studded_block, PROPERTIES);
    public static final RegistryObject<Block> oak_iron_studded_block = BLOCKS.register("oak_iron_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> oak_iron_studded_block_item = fromBlock(oak_iron_studded_block, PROPERTIES);
    public static final RegistryObject<Block> spruce_iron_studded_block = BLOCKS.register("spruce_iron_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> spruce_iron_studded_block_item = fromBlock(spruce_iron_studded_block, PROPERTIES);
    public static final RegistryObject<Block> baobab_iron_studded_block = BLOCKS.register("baobab_iron_studded_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(2.0F, 1200.0F)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Item> baobab_iron_studded_block_item = fromBlock(baobab_iron_studded_block, PROPERTIES);

    // Studded Pressure Plate
    public static final RegistryObject<Block> acacia_studded_pressure_plate = BLOCKS.register("acacia_studded_pressure_plate", () ->
            new StuddedPressurePlateBlock(StuddedPressurePlateBlock.Sensitivity.PLAYER, BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(0.5F, 1200.0F).sound(SoundType.WOOD), BlockSetType.ACACIA));
    public static final RegistryObject<Item> acacia_studded_pressure_plate_item = fromBlock(acacia_studded_pressure_plate, PROPERTIES);
    public static final RegistryObject<Block> baobab_studded_pressure_plate = BLOCKS.register("baobab_studded_pressure_plate", () ->
            new StuddedPressurePlateBlock(StuddedPressurePlateBlock.Sensitivity.PLAYER, BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(0.5F, 1200.0F).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Item> baobab_studded_pressure_plate_item = fromBlock(baobab_studded_pressure_plate, PROPERTIES);
    public static final RegistryObject<Block> birch_studded_pressure_plate = BLOCKS.register("birch_studded_pressure_plate", () ->
            new StuddedPressurePlateBlock(StuddedPressurePlateBlock.Sensitivity.PLAYER, BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(0.5F, 1200.0F).sound(SoundType.WOOD), BlockSetType.BIRCH));
    public static final RegistryObject<Item> birch_studded_pressure_plate_item = fromBlock(birch_studded_pressure_plate, PROPERTIES);
    public static final RegistryObject<Block> dark_oak_studded_pressure_plate = BLOCKS.register("dark_oak_studded_pressure_plate", () ->
            new StuddedPressurePlateBlock(StuddedPressurePlateBlock.Sensitivity.PLAYER, BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(0.5F, 1200.0F).sound(SoundType.WOOD), BlockSetType.DARK_OAK));
    public static final RegistryObject<Item> dark_oak_studded_pressure_plate_item = fromBlock(dark_oak_studded_pressure_plate, PROPERTIES);
    public static final RegistryObject<Block> jungle_studded_pressure_plate = BLOCKS.register("jungle_studded_pressure_plate", () ->
            new StuddedPressurePlateBlock(StuddedPressurePlateBlock.Sensitivity.PLAYER, BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(0.5F, 1200.0F).sound(SoundType.WOOD), BlockSetType.JUNGLE));
    public static final RegistryObject<Item> jungle_studded_pressure_plate_item = fromBlock(jungle_studded_pressure_plate, PROPERTIES);
    public static final RegistryObject<Block> oak_studded_pressure_plate = BLOCKS.register("oak_studded_pressure_plate", () ->
            new StuddedPressurePlateBlock(StuddedPressurePlateBlock.Sensitivity.PLAYER, BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(0.5F, 1200.0F).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Item> oak_studded_pressure_plate_item = fromBlock(oak_studded_pressure_plate, PROPERTIES);
    public static final RegistryObject<Block> spruce_studded_pressure_plate = BLOCKS.register("spruce_studded_pressure_plate", () ->
            new StuddedPressurePlateBlock(StuddedPressurePlateBlock.Sensitivity.PLAYER, BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(0.5F, 1200.0F).sound(SoundType.WOOD), BlockSetType.SPRUCE));
    public static final RegistryObject<Item> spruce_studded_pressure_plate_item = fromBlock(spruce_studded_pressure_plate, PROPERTIES);

    // BlockDeco Leather Blocks
    public static final RegistryObject<Block> block_blue_hardened_leather = BLOCKS.register("block_blue_hardened_leather", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(0.8F, 1200.0F)
                    .sound(SoundType.WOOL)));
    public static final RegistryObject<Item> block_blue_hardened_leather_item = fromBlock(block_blue_hardened_leather, PROPERTIES);
    public static final RegistryObject<Block> block_brown_hardened_leather = BLOCKS.register("block_brown_hardened_leather", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(0.8F, 1200.0F)
                    .sound(SoundType.WOOL)));
    public static final RegistryObject<Item> block_brown_hardened_leather_item = fromBlock(block_brown_hardened_leather, PROPERTIES);
    public static final RegistryObject<Block> block_green_hardened_leather = BLOCKS.register("block_green_hardened_leather", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(0.8F, 1200.0F)
                    .sound(SoundType.WOOL)));
    public static final RegistryObject<Item> block_green_hardened_leather_item = fromBlock(block_green_hardened_leather, PROPERTIES);
    public static final RegistryObject<Block> block_light_green_hardened_leather = BLOCKS.register("block_light_green_hardened_leather", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(0.8F, 1200.0F)
                    .sound(SoundType.WOOL)));
    public static final RegistryObject<Item> block_light_green_hardened_leather_item = fromBlock(block_light_green_hardened_leather, PROPERTIES);
    public static final RegistryObject<Block> block_purple_hardened_leather = BLOCKS.register("block_purple_hardened_leather", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(0.8F, 1200.0F)
                    .sound(SoundType.WOOL)));
    public static final RegistryObject<Item> block_purple_hardened_leather_item = fromBlock(block_purple_hardened_leather, PROPERTIES);
    public static final RegistryObject<Block> block_red_hardened_leather = BLOCKS.register("block_red_hardened_leather", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(0.8F, 1200.0F)
                    .sound(SoundType.WOOL)));
    public static final RegistryObject<Item> block_red_hardened_leather_item = fromBlock(block_red_hardened_leather, PROPERTIES);
    public static final RegistryObject<Block> block_black_hardened_leather = BLOCKS.register("block_black_hardened_leather", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(0.8F, 1200.0F)
                    .sound(SoundType.WOOL)));
    public static final RegistryObject<Item> block_black_hardened_leather_item = fromBlock(block_black_hardened_leather, PROPERTIES);
    public static final RegistryObject<Block> block_white_hardened_leather = BLOCKS.register("block_white_hardened_leather", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(0.8F, 1200.0F)
                    .sound(SoundType.WOOL)));
    public static final RegistryObject<Item> block_white_hardened_leather_item = fromBlock(block_white_hardened_leather, PROPERTIES);

    // Small Flowers
    public static final RegistryObject<Block> dust_flower = BLOCKS.register("dust_flower", () ->
            new FlowerBlock(() -> MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> dust_flower_item = fromBlock(dust_flower, PROPERTIES);
    public static final RegistryObject<Block> potted_dust_flower = BLOCKS.register("potted_dust_flower", () ->
            new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), dust_flower, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().noOcclusion()));

    public static final RegistryObject<Block> fire_flower = BLOCKS.register("fire_flower", () ->
            new MesaFlowersBlock(MobEffects.FIRE_RESISTANCE, 4, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> fire_flower_item = fromBlock(fire_flower, PROPERTIES);
    public static final RegistryObject<Block> potted_fire_flower = BLOCKS.register("potted_fire_flower", () ->
            new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), fire_flower, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().noOcclusion()));

    public static final RegistryObject<Block> ice_flower = BLOCKS.register("ice_flower", () ->
            new LuminousFlowersBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().lightLevel(litBlockEmission(7)).sound(SoundType.GRASS)));
    public static final RegistryObject<Item> ice_flower_item = fromBlock(ice_flower, PROPERTIES);
    public static final RegistryObject<Block> potted_ice_flower = BLOCKS.register("potted_ice_flower", () ->
            new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ice_flower, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().noOcclusion()));

    public static final RegistryObject<Block> irrlicht = BLOCKS.register("irrlicht", () ->
            new LuminousFlowersBlock(MobEffects.NIGHT_VISION, 5, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().lightLevel(litBlockEmission(7)).sound(SoundType.GRASS)));
    public static final RegistryObject<Item> irrlicht_item = fromBlock(irrlicht, PROPERTIES);
    public static final RegistryObject<Block> potted_irrlicht = BLOCKS.register("potted_irrlicht", () ->
            new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), irrlicht, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().noOcclusion()));

    public static final RegistryObject<Block> purple_rose = BLOCKS.register("purple_rose", () ->
            new FlowerBlock(() -> MobEffects.WEAKNESS, 9, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> purple_rose_item = fromBlock(purple_rose, PROPERTIES);
    public static final RegistryObject<Block> potted_purple_rose = BLOCKS.register("potted_purple_rose", () ->
            new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), purple_rose, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().noOcclusion()));

    public static final RegistryObject<Block> pink_fern = BLOCKS.register("pink_fern", () ->
            new FlowerBlock(() -> MobEffects.SATURATION, 7, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> pink_fern_item = fromBlock(pink_fern, PROPERTIES);
    public static final RegistryObject<Block> potted_pink_fern = BLOCKS.register("potted_pink_fern", () ->
            new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), pink_fern, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().noOcclusion()));

    public static final RegistryObject<Block> star_flower = BLOCKS.register("star_flower", () ->
            new LuminousFlowersBlock(MobEffects.JUMP, 6, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().lightLevel(litBlockEmission(7)).sound(SoundType.GRASS)));
    public static final RegistryObject<Item> star_flower_item = fromBlock(star_flower, PROPERTIES);
    public static final RegistryObject<Block> potted_star_flower = BLOCKS.register("potted_star_flower", () ->
            new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), star_flower, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().noOcclusion()));

    public static final RegistryObject<Block> white_rose = BLOCKS.register("white_rose", () ->
            new FlowerBlock(() -> MobEffects.BLINDNESS, 8, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> white_rose_item = fromBlock(white_rose, PROPERTIES);
    public static final RegistryObject<Block> potted_white_rose = BLOCKS.register("potted_white_rose", () ->
            new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), white_rose, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().noOcclusion()));

    // Tall Flowers
    public static final RegistryObject<Block> cloud_bush = BLOCKS.register("cloud_bush", () ->
            new TallFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> cloud_bush_item = fromBlock(cloud_bush, PROPERTIES);

    public static final RegistryObject<Block> fire_bush = BLOCKS.register("fire_bush", () ->
            new TallFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> fire_bush_item = fromBlock(fire_bush, PROPERTIES);

    public static final RegistryObject<Block> shadow_fern = BLOCKS.register("shadow_fern", () ->
            new TallFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> shadow_fern_item = fromBlock(shadow_fern, PROPERTIES);

    public static final RegistryObject<Block> silver_umbrella = BLOCKS.register("silver_umbrella", () ->
            new TallFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Item> silver_umbrella_item = fromBlock(silver_umbrella, PROPERTIES);

    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, Item.Properties properties) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
    }

    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return (p_50763_) -> p_50763_.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
    }

    // BlockTags
    public static final TagKey<Block> salt_ore_tag = BlockTags.create(new ResourceLocation("forge","ores/salt"));
    public static final TagKey<Block> zinc_ore_tag = BlockTags.create(new ResourceLocation("forge","ores/zinc"));
    public static final TagKey<Block> tin_ore_tag = BlockTags.create(new ResourceLocation("forge","ores/tin"));
    public static final TagKey<Block> nether_devil_iron_ore_tag = BlockTags.create(new ResourceLocation("forge","ores/devil_iron"));
    public static final TagKey<Block> sulphur_ore_tag = BlockTags.create(new ResourceLocation("forge","ores/sulphur"));
    public static final TagKey<Block> brass_block_tag = BlockTags.create(new ResourceLocation("forge","storage_blocks/brass_block"));
    public static final TagKey<Block> bronze_block_tag = BlockTags.create(new ResourceLocation("forge","storage_blocks/bronze_block"));
    public static final TagKey<Block> tin_block_tag = BlockTags.create(new ResourceLocation("forge","storage_blocks/tin_block"));
    public static final TagKey<Block> zinc_block_tag = BlockTags.create(new ResourceLocation("forge","storage_blocks/zinc_block"));
    public static final TagKey<Block> devil_iron_block_tag = BlockTags.create(new ResourceLocation("forge","storage_blocks/devil_iron_block"));
    public static final TagKey<Block> steel_block_tag = BlockTags.create(new ResourceLocation("forge","storage_blocks/steel_block"));
    public static final TagKey<Block> salt_block_tag = BlockTags.create(new ResourceLocation("forge","storage_blocks/salt_block"));
    public static final TagKey<Block> marble_tag = BlockTags.create(new ResourceLocation("forge","stone/marble"));
    public static final TagKey<Block> marble_black_tag = BlockTags.create(new ResourceLocation("forge","stone/black_marble"));
    // ItemTags
    public static final TagKey<Item> salt_ore_item_tag = ItemTags.create(new ResourceLocation("forge","ores/salt"));
    public static final TagKey<Item> zinc_ore_item_tag = ItemTags.create(new ResourceLocation("forge","ores/zinc"));
    public static final TagKey<Item> tin_ore_item_tag = ItemTags.create(new ResourceLocation("forge","ores/tin"));
    public static final TagKey<Item> nether_devil_iron_ore_item_tag = ItemTags.create(new ResourceLocation("forge","ores/devil_iron"));
    public static final TagKey<Item> sulphur_ore_item_tag = ItemTags.create(new ResourceLocation("forge","ores/sulphur"));
    public static final TagKey<Item> marble_item_tag = ItemTags.create(new ResourceLocation("forge","stone/marble"));
    public static final TagKey<Item> marble_black_item_tag = ItemTags.create(new ResourceLocation("forge","stone/black_marble"));
    public static final TagKey<Item> wardrobe_item_tag = ItemTags.create(new ResourceLocation(MysticalSteamAge.MOD_ID,"wardrobe"));
    public static final TagKey<Item> iron_studded_wood_item_tag = ItemTags.create(new ResourceLocation(MysticalSteamAge.MOD_ID,"iron_studded_wood"));
}
