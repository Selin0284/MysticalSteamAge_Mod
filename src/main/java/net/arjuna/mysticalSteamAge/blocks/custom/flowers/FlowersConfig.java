package net.arjuna.mysticalSteamAge.blocks.custom.flowers;

/*public class FlowersConfig {

    // Small Flowers
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DUST_FLOWER =
            FeatureUtils.register("dust_flower", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(MysticalSteamAgeBlocksRegister.dust_flower.get())))));

    public static final Holder<PlacedFeature> DUST_FLOWER_PLACED = PlacementUtils.register("dust_flower_placed",
            DUST_FLOWER, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FIRE_FLOWER =
            FeatureUtils.register("fire_flower", Feature.FLOWER,
                    new RandomPatchConfiguration(64, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(MysticalSteamAgeBlocksRegister.fire_flower.get())))));

    public static final Holder<PlacedFeature> FIRE_FLOWER_PLACED = PlacementUtils.register("fire_flower_placed",
            FIRE_FLOWER, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ICE_FLOWER =
            FeatureUtils.register("ice_flower", Feature.FLOWER,
                    new RandomPatchConfiguration(64, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(MysticalSteamAgeBlocksRegister.ice_flower.get())))));

    public static final Holder<PlacedFeature> ICE_FLOWER_PLACED = PlacementUtils.register("ice_flower_placed",
            ICE_FLOWER, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> IRRLICHT =
            FeatureUtils.register("irrlicht", Feature.FLOWER,
                    new RandomPatchConfiguration(64, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(MysticalSteamAgeBlocksRegister.irrlicht.get())))));

    public static final Holder<PlacedFeature> IRRLICHT_PLACED = PlacementUtils.register("irrlicht_placed",
            IRRLICHT, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PURPLE_ROSE =
            FeatureUtils.register("purple_rose", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(MysticalSteamAgeBlocksRegister.purple_rose.get())))));

    public static final Holder<PlacedFeature> PURPLE_ROSE_PLACED = PlacementUtils.register("purple_rose_placed",
            PURPLE_ROSE, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WHITE_ROSE =
            FeatureUtils.register("white_rose", Feature.FLOWER,
                    new RandomPatchConfiguration(32, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(MysticalSteamAgeBlocksRegister.white_rose.get())))));

    public static final Holder<PlacedFeature> WHITE_ROSE_PLACED = PlacementUtils.register("white_rose_placed",
            WHITE_ROSE, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PINK_FERN =
            FeatureUtils.register("pink_fern", Feature.FLOWER,
                    new RandomPatchConfiguration(64, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(MysticalSteamAgeBlocksRegister.pink_fern.get())))));

    public static final Holder<PlacedFeature> PINK_FERN_PLACED = PlacementUtils.register("pink_fern_placed",
            PINK_FERN, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> STAR_FLOWER =
            FeatureUtils.register("star_flower", Feature.FLOWER,
                    new RandomPatchConfiguration(64, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(MysticalSteamAgeBlocksRegister.star_flower.get())))));

    public static final Holder<PlacedFeature> STAR_FLOWER_PLACED = PlacementUtils.register("star_flower_placed",
            STAR_FLOWER, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    // Tall Flowers
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CLOUD_BUSH =
            FeatureUtils.register("cloud_bush", Feature.FLOWER,
                    new RandomPatchConfiguration(64, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(MysticalSteamAgeBlocksRegister.cloud_bush.get())))));

    public static final Holder<PlacedFeature> CLOUD_BUSH_PLACED = PlacementUtils.register("cloud_bush_placed",
            CLOUD_BUSH, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FIRE_BUSH =
            FeatureUtils.register("fire_bush", Feature.FLOWER,
                    new RandomPatchConfiguration(64, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(MysticalSteamAgeBlocksRegister.fire_bush.get())))));

    public static final Holder<PlacedFeature> FIRE_BUSH_PLACED = PlacementUtils.register("fire_bush_placed",
            FIRE_BUSH, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SHADOW_FERN =
            FeatureUtils.register("shadow_fern", Feature.FLOWER,
                    new RandomPatchConfiguration(64, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(MysticalSteamAgeBlocksRegister.shadow_fern.get())))));

    public static final Holder<PlacedFeature> SHADOW_FERN_PLACED = PlacementUtils.register("shadow_fern_placed",
            SHADOW_FERN, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SILVER_UMBRELLA =
            FeatureUtils.register("silver_umbrella", Feature.FLOWER,
                    new RandomPatchConfiguration(64, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(MysticalSteamAgeBlocksRegister.silver_umbrella.get())))));

    public static final Holder<PlacedFeature> SILVER_UMBRELLA_PLACED = PlacementUtils.register("silver_umbrella_placed",
            SILVER_UMBRELLA, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    // Other Plants
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CAMAS =
            FeatureUtils.register("camas", Feature.FLOWER,
                    new RandomPatchConfiguration(64, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(MysticalSteamAgeBlocksRegister.camas.get())))));

    public static final Holder<PlacedFeature> CAMAS_PLACED = PlacementUtils.register("camas_placed",
            CAMAS, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
}*/
