package net.arjuna.mysticalSteamAge.blocks.custom;

/*public class OresConfig {

    public static final int VEIN_SIZE = 7;
    public static final int VEIN_SIZE_SMALL = 3;
    public static final int RARE_VEIN_SIZE = 9;
    public static final int RARE_VEIN_SIZE_SMALL = 4;
    public static final int AMOUNT = 16;
    public static final int RARE_AMOUNT = 8;

    public static final List<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), MysticalSteamAgeBlocksRegister.tin_ore.get().defaultBlockState()),
            OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), MysticalSteamAgeBlocksRegister.deepslate_tin_ore.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_ZINC_TARGET_LIST = List.of(OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), MysticalSteamAgeBlocksRegister.zinc_ore.get().defaultBlockState()),
            OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), MysticalSteamAgeBlocksRegister.deepslate_zinc_ore.get().defaultBlockState()));

    // Over World and Deepslate
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> TIN_OREGEN_NORMAL = FeatureUtils.register("tin_ore_normal",
            Feature.ORE, new OreConfiguration(ORE_TIN_TARGET_LIST, VEIN_SIZE));
    public static final Holder<PlacedFeature> TIN_OREGEN_NORMAL_PLACED = PlacementUtils.register("tin_ore_normal_placed",
            TIN_OREGEN_NORMAL, commonOrePlacement(AMOUNT,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> TIN_OREGEN_SMALL = FeatureUtils.register("tin_ore_small",
            Feature.ORE, new OreConfiguration(ORE_TIN_TARGET_LIST, VEIN_SIZE_SMALL));
    public static final Holder<PlacedFeature> TIN_OREGEN_SMALL_PLACED = PlacementUtils.register("tin_ore_small_placed",
            TIN_OREGEN_SMALL, commonOrePlacement(AMOUNT,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ZINC_OREGEN_NORMAL = FeatureUtils.register("zinc_ore_normal",
            Feature.ORE, new OreConfiguration(ORE_ZINC_TARGET_LIST, VEIN_SIZE));
    public static final Holder<PlacedFeature> ZINC_OREGEN_NORMAL_PLACED = PlacementUtils.register("zinc_ore_normal_placed",
            ZINC_OREGEN_NORMAL, commonOrePlacement(AMOUNT,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ZINC_OREGEN_SMALL = FeatureUtils.register("zinc_ore_small",
            Feature.ORE, new OreConfiguration(ORE_ZINC_TARGET_LIST, VEIN_SIZE_SMALL));
    public static final Holder<PlacedFeature> ZINC_OREGEN_SMALL_PLACED = PlacementUtils.register("zinc_ore_small_placed",
            ZINC_OREGEN_SMALL, commonOrePlacement(AMOUNT,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));



    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SALT_OREGEN_NORMAL = FeatureUtils.register("salt_ore_normal",
            Feature.ORE, new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES,
                    MysticalSteamAgeBlocksRegister.salt_ore.get().defaultBlockState(), RARE_VEIN_SIZE));
    public static final Holder<PlacedFeature> SALT_OREGEN_NORMAL_PLACED = PlacementUtils.register("salt_ore_normal_placed",
            SALT_OREGEN_NORMAL, commonOrePlacement(32,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(64), VerticalAnchor.absolute(384))));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SALT_OREGEN_SMALL = FeatureUtils.register("salt_ore_small",
            Feature.ORE, new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES,
                    MysticalSteamAgeBlocksRegister.salt_ore.get().defaultBlockState(), RARE_VEIN_SIZE_SMALL));
    public static final Holder<PlacedFeature> SALT_OREGEN_SMALL_PLACED = PlacementUtils.register("salt_ore_small_placed",
            SALT_OREGEN_SMALL, commonOrePlacement(32,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(64), VerticalAnchor.absolute(384))));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MARBLE_OREGEN_NORMAL = FeatureUtils.register("marble_normal",
            Feature.ORE, new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES,
                    MysticalSteamAgeBlocksRegister.marble.get().defaultBlockState(), 32));
    public static final Holder<PlacedFeature> MARBLE_OREGEN_NORMAL_PLACED = PlacementUtils.register("marble_normal_placed",
            MARBLE_OREGEN_NORMAL, commonOrePlacement(6,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MARBLE_OREGEN_SMALL = FeatureUtils.register("marble_small",
            Feature.ORE, new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES,
                    MysticalSteamAgeBlocksRegister.marble.get().defaultBlockState(), 16));
    public static final Holder<PlacedFeature> MARBLE_OREGEN_SMALL_PLACED = PlacementUtils.register("marble_small_placed",
            MARBLE_OREGEN_SMALL, commonOrePlacement(6,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> DEEPSLATE_MARBLE_BLACK_OREGEN_NORMAL = FeatureUtils.register("deepslate_marble_black_normal",
            Feature.ORE, new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    MysticalSteamAgeBlocksRegister.marble_black.get().defaultBlockState(), 32));
    public static final Holder<PlacedFeature> DEEPSLATE_MARBLE_BLACK_OREGEN_NORMAL_PLACED = PlacementUtils.register("deepslate_marble_black_normal_placed",
            DEEPSLATE_MARBLE_BLACK_OREGEN_NORMAL, commonOrePlacement(6,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> DEEPSLATE_MARBLE_BLACK_OREGEN_SMALL = FeatureUtils.register("deepslate_marble_black_small",
            Feature.ORE, new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    MysticalSteamAgeBlocksRegister.marble_black.get().defaultBlockState(), 16));
    public static final Holder<PlacedFeature> DEEPSLATE_MARBLE_BLACK_OREGEN_SMALL_PLACED = PlacementUtils.register("deepslate_marble_black_small_placed",
            DEEPSLATE_MARBLE_BLACK_OREGEN_SMALL, commonOrePlacement(6,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> DEEPSLATE_SULPHUR_OREGEN_NORMAL = FeatureUtils.register("deepslate_sulphur_ore_normal",
            Feature.ORE, new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    MysticalSteamAgeBlocksRegister.deepslate_sulphur_ore.get().defaultBlockState(), 5));
    public static final Holder<PlacedFeature> DEEPSLATE_SULPHUR_OREGEN_NORMAL_PLACED = PlacementUtils.register("deepslate_sulphur_ore_normal_placed",
            DEEPSLATE_SULPHUR_OREGEN_NORMAL, commonOrePlacement(6,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> DEEPSLATE_SULPHUR_OREGEN_SMALL = FeatureUtils.register("deepslate_sulphur_ore_small",
            Feature.ORE, new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    MysticalSteamAgeBlocksRegister.deepslate_sulphur_ore.get().defaultBlockState(), 2));
    public static final Holder<PlacedFeature> DEEPSLATE_SULPHUR_OREGEN_SMALL_PLACED = PlacementUtils.register("deepslate_sulphur_ore_small_placed",
            DEEPSLATE_SULPHUR_OREGEN_SMALL, commonOrePlacement(6,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));


    // Nether World
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_COAL_OREGEN_NORMAL = FeatureUtils.register("nether_coal_ore_normal",
            Feature.ORE, new OreConfiguration(OreFeatures.NETHERRACK,
                    MysticalSteamAgeBlocksRegister.nether_coal_ore.get().defaultBlockState(), 17));
    public static final Holder<PlacedFeature> NETHER_COAL_OREGEN_NORMAL_PLACED = PlacementUtils.register("nether_coal_ore_normal_placed",
            NETHER_COAL_OREGEN_NORMAL, commonOrePlacement(30,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(30), VerticalAnchor.absolute(90))));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_COAL_OREGEN_SMALL = FeatureUtils.register("nether_coal_ore_small",
            Feature.ORE, new OreConfiguration(OreFeatures.NETHERRACK,
                    MysticalSteamAgeBlocksRegister.nether_coal_ore.get().defaultBlockState(), 7));
    public static final Holder<PlacedFeature> NETHER_COAL_OREGEN_SMALL_PLACED = PlacementUtils.register("nether_coal_ore_small_placed",
            NETHER_COAL_OREGEN_SMALL, commonOrePlacement(30,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(30), VerticalAnchor.absolute(90))));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_DEVIL_IRON_OREGEN_NORMAL = FeatureUtils.register("nether_devil_iron_ore_normal",
            Feature.ORE, new OreConfiguration(OreFeatures.NETHERRACK,
                    MysticalSteamAgeBlocksRegister.nether_devil_iron_ore.get().defaultBlockState(), RARE_VEIN_SIZE));
    public static final Holder<PlacedFeature> NETHER_DEVIL_IRON_OREGEN_NORMAL_PLACED = PlacementUtils.register("nether_devil_iron_ore_normal_placed",
            NETHER_DEVIL_IRON_OREGEN_NORMAL, commonOrePlacement(RARE_AMOUNT,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(90))));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_DEVIL_IRON_OREGEN_SMALL = FeatureUtils.register("nether_devil_iron_ore_small",
            Feature.ORE, new OreConfiguration(OreFeatures.NETHERRACK,
                    MysticalSteamAgeBlocksRegister.nether_devil_iron_ore.get().defaultBlockState(), RARE_VEIN_SIZE_SMALL));
    public static final Holder<PlacedFeature> NETHER_DEVIL_IRON_OREGEN_SMALL_PLACED = PlacementUtils.register("nether_devil_iron_ore_small_placed",
            NETHER_DEVIL_IRON_OREGEN_SMALL, commonOrePlacement(RARE_AMOUNT,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(90))));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_SULPHUR_OREGEN_NORMAL = FeatureUtils.register("nether_sulphur_ore_normal",
            Feature.ORE, new OreConfiguration(OreFeatures.NETHERRACK,
                    MysticalSteamAgeBlocksRegister.nether_sulphur_ore.get().defaultBlockState(), RARE_VEIN_SIZE));
    public static final Holder<PlacedFeature> NETHER_SULPHUR_OREGEN_NORMAL_PLACED = PlacementUtils.register("nether_sulphur_ore_normal_placed",
            NETHER_SULPHUR_OREGEN_NORMAL, commonOrePlacement(RARE_AMOUNT,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(90))));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_SULPHUR_OREGEN_SMALL = FeatureUtils.register("nether_sulphur_ore_small",
            Feature.ORE, new OreConfiguration(OreFeatures.NETHERRACK,
                    MysticalSteamAgeBlocksRegister.nether_sulphur_ore.get().defaultBlockState(), RARE_VEIN_SIZE_SMALL));
    public static final Holder<PlacedFeature> NETHER_SULPHUR_OREGEN_SMALL_PLACED = PlacementUtils.register("nether_sulphur_ore_small_placed",
            NETHER_SULPHUR_OREGEN_SMALL, commonOrePlacement(RARE_AMOUNT,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(90))));


    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}*/
