package net.arjuna.mysticalSteamAge.datagen.Loot;

import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeBlocksRegister;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeMachinesRegister;
import net.arjuna.mysticalSteamAge.blocks.custom.CamasBlock;
import net.arjuna.mysticalSteamAge.blocks.custom.FeatherHerbBlock;
import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class MysticalSteamAgeBlockLootTables extends BlockLootSubProvider {

    protected static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    protected static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    protected static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    public MysticalSteamAgeBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // Blocks
        this.dropSelf(MysticalSteamAgeBlocksRegister.brass_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.bronze_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.tin_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.zinc_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.devil_iron_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.steel_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.salt_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_brick.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_bricks_stairs.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_bricks_slab.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_bricks_wall.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_stairs.get());
        this.add(MysticalSteamAgeBlocksRegister.marble_slab.get(),
                block -> createSlabItemTable(MysticalSteamAgeBlocksRegister.marble_slab.get()));
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_wall.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_pillar.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.polished_marble.get());
        this.add(MysticalSteamAgeBlocksRegister.polished_marble_slab.get(),
                block -> createSlabItemTable(MysticalSteamAgeBlocksRegister.polished_marble_slab.get()));
        this.dropSelf(MysticalSteamAgeBlocksRegister.polished_marble_stairs.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_black.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_black_brick.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_black_bricks_stairs.get());
        this.add(MysticalSteamAgeBlocksRegister.marble_black_bricks_slab.get(),
                block -> createSlabItemTable(MysticalSteamAgeBlocksRegister.marble_black_bricks_slab.get()));
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_black_bricks_wall.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_black_stairs.get());
        this.add(MysticalSteamAgeBlocksRegister.marble_black_slab.get(),
                block -> createSlabItemTable(MysticalSteamAgeBlocksRegister.marble_black_slab.get()));
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_black_wall.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_black_pillar.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.polished_marble_black.get());
        this.add(MysticalSteamAgeBlocksRegister.polished_marble_black_slab.get(),
                block -> createSlabItemTable(MysticalSteamAgeBlocksRegister.polished_marble_black_slab.get()));
        this.dropSelf(MysticalSteamAgeBlocksRegister.polished_marble_black_stairs.get());

        // Ores
        this.add(MysticalSteamAgeBlocksRegister.deepslate_sulphur_ore.get(), createSilkTouchTable("deepslate_sulphur_ore", MysticalSteamAgeBlocksRegister.deepslate_sulphur_ore.get(), MysticalSteamAgeItemsRegister.raw_sulphur.get(), 3, 6));
        this.add(MysticalSteamAgeBlocksRegister.deepslate_tin_ore.get(), createSilkTouchTable("deepslate_tin_ore", MysticalSteamAgeBlocksRegister.deepslate_tin_ore.get(), MysticalSteamAgeItemsRegister.raw_tin.get(), 1, 3));
        this.add(MysticalSteamAgeBlocksRegister.deepslate_zinc_ore.get(), createSilkTouchTable("deepslate_zinc_ore", MysticalSteamAgeBlocksRegister.deepslate_zinc_ore.get(), MysticalSteamAgeItemsRegister.raw_zinc.get(), 1, 3));
        this.add(MysticalSteamAgeBlocksRegister.nether_coal_ore.get(), createSilkTouchTable("nether_coal_ore", MysticalSteamAgeBlocksRegister.nether_coal_ore.get(), Items.COAL, 1, 3));
        this.add(MysticalSteamAgeBlocksRegister.nether_devil_iron_ore.get(), createSilkTouchTable("nether_devil_iron_ore", MysticalSteamAgeBlocksRegister.nether_devil_iron_ore.get(), MysticalSteamAgeItemsRegister.raw_devil_iron.get(), 1, 3));
        this.add(MysticalSteamAgeBlocksRegister.nether_sulphur_ore.get(), createSilkTouchTable("nether_sulphur_ore", MysticalSteamAgeBlocksRegister.nether_sulphur_ore.get(), MysticalSteamAgeItemsRegister.raw_sulphur.get(), 3, 6));
        this.add(MysticalSteamAgeBlocksRegister.tin_ore.get(), createSilkTouchTable("tin_ore", MysticalSteamAgeBlocksRegister.tin_ore.get(), MysticalSteamAgeItemsRegister.raw_tin.get(), 1, 3));
        this.add(MysticalSteamAgeBlocksRegister.zinc_ore.get(), createSilkTouchTable("zinc_ore", MysticalSteamAgeBlocksRegister.zinc_ore.get(), MysticalSteamAgeItemsRegister.raw_zinc.get(), 1, 3));
        this.add(MysticalSteamAgeBlocksRegister.salt_ore.get(), createSilkTouchTable("salt_ore", MysticalSteamAgeBlocksRegister.salt_ore.get(), MysticalSteamAgeItemsRegister.raw_salt.get(), 3, 6));

        // Flowers
        this.dropSelf(MysticalSteamAgeBlocksRegister.dust_flower.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.fire_flower.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.ice_flower.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.irrlicht.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.purple_rose.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.pink_fern.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.star_flower.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.white_rose.get());
        this.add(MysticalSteamAgeBlocksRegister.cloud_bush.get(), createSinglePropConditionTable(MysticalSteamAgeBlocksRegister.cloud_bush.get(), DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        this.add(MysticalSteamAgeBlocksRegister.fire_bush.get(), createSinglePropConditionTable(MysticalSteamAgeBlocksRegister.fire_bush.get(), DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        this.add(MysticalSteamAgeBlocksRegister.shadow_fern.get(), createSinglePropConditionTable(MysticalSteamAgeBlocksRegister.shadow_fern.get(), DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        this.add(MysticalSteamAgeBlocksRegister.silver_umbrella.get(), createSinglePropConditionTable(MysticalSteamAgeBlocksRegister.silver_umbrella.get(), DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));

        // Flower Pots
        this.add(MysticalSteamAgeBlocksRegister.potted_dust_flower.get(), createPotFlowerItemTable(MysticalSteamAgeBlocksRegister.dust_flower_item.get()));
        this.add(MysticalSteamAgeBlocksRegister.potted_fire_flower.get(), createPotFlowerItemTable(MysticalSteamAgeBlocksRegister.fire_flower_item.get()));
        this.add(MysticalSteamAgeBlocksRegister.potted_ice_flower.get(), createPotFlowerItemTable(MysticalSteamAgeBlocksRegister.ice_flower_item.get()));
        this.add(MysticalSteamAgeBlocksRegister.potted_irrlicht.get(), createPotFlowerItemTable(MysticalSteamAgeBlocksRegister.irrlicht_item.get()));
        this.add(MysticalSteamAgeBlocksRegister.potted_purple_rose.get(), createPotFlowerItemTable(MysticalSteamAgeBlocksRegister.purple_rose_item.get()));
        this.add(MysticalSteamAgeBlocksRegister.potted_pink_fern.get(), createPotFlowerItemTable(MysticalSteamAgeBlocksRegister.pink_fern_item.get()));
        this.add(MysticalSteamAgeBlocksRegister.potted_star_flower.get(), createPotFlowerItemTable(MysticalSteamAgeBlocksRegister.star_flower_item.get()));
        this.add(MysticalSteamAgeBlocksRegister.potted_white_rose.get(), createPotFlowerItemTable(MysticalSteamAgeBlocksRegister.white_rose_item.get()));

        // Decorations
        this.dropSelf(MysticalSteamAgeBlocksRegister.oak_wardrobe.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.spruce_wardrobe.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.dark_oak_wardrobe.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.jungle_wardrobe.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.birch_wardrobe.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.acacia_wardrobe.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_wardrobe.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.feather_herb_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.stick_bundle_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.acacia_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.andesite_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.birch_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.cobblestone_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.dark_oak_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.deepslate_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.diorite_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.granite_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.iron_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.jungle_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_black_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.marble_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.oak_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.sand_stone_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.spruce_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_lamp.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.block_black_hardened_leather.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.block_blue_hardened_leather.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.block_brown_hardened_leather.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.block_green_hardened_leather.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.block_light_green_hardened_leather.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.block_purple_hardened_leather.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.block_red_hardened_leather.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.block_white_hardened_leather.get());
        this.add(MysticalSteamAgeBlocksRegister.studded_wooden_door_1.get(), createDoorTable(MysticalSteamAgeBlocksRegister.studded_wooden_door_1.get()));
        this.add(MysticalSteamAgeBlocksRegister.studded_wooden_door_2.get(), createDoorTable(MysticalSteamAgeBlocksRegister.studded_wooden_door_2.get()));
        this.add(MysticalSteamAgeBlocksRegister.studded_wooden_door_3.get(), createDoorTable(MysticalSteamAgeBlocksRegister.studded_wooden_door_3.get()));

        this.dropSelf(MysticalSteamAgeBlocksRegister.acacia_iron_studded_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.birch_iron_studded_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.dark_oak_iron_studded_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.jungle_iron_studded_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.oak_iron_studded_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.spruce_iron_studded_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_iron_studded_block.get());

        this.dropSelf(MysticalSteamAgeBlocksRegister.acacia_gold_studded_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.birch_gold_studded_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.dark_oak_gold_studded_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.jungle_gold_studded_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.oak_gold_studded_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.spruce_gold_studded_block.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_gold_studded_block.get());

        this.dropSelf(MysticalSteamAgeBlocksRegister.acacia_studded_pressure_plate.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_studded_pressure_plate.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.birch_studded_pressure_plate.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.dark_oak_studded_pressure_plate.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.jungle_studded_pressure_plate.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.oak_studded_pressure_plate.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.spruce_studded_pressure_plate.get());

        // Wood
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_log.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_wood.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_planks.get());
        this.add(MysticalSteamAgeBlocksRegister.baobab_leaves.get(), createBaobabLeavesDrops(MysticalSteamAgeBlocksRegister.baobab_leaves.get(),
                MysticalSteamAgeBlocksRegister.baobab_log.get())); // TODO: Change to Sapling!
        /*this.add(MysticalSteamAgeBlocksRegister.potted_baobab_sapling.get(), createPotFlowerItemTable(MysticalSteamAgeBlocksRegister.baobab_sapling_item.get()));
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_sapling.get());*/
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_stairs.get());
        this.add(MysticalSteamAgeBlocksRegister.baobab_slab.get(), createSlabItemTable(MysticalSteamAgeBlocksRegister.baobab_slab.get()));
        this.add(MysticalSteamAgeBlocksRegister.baobab_door.get(), createDoorTable(MysticalSteamAgeBlocksRegister.baobab_door.get()));
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_pressure_plate.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_trapdoor.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_button.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_fence_gate.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.baobab_fence.get());

        // Machines
        this.dropSelf(MysticalSteamAgeBlocksRegister.double_furnace.get());
        this.dropSelf(MysticalSteamAgeBlocksRegister.carpenter_workbench.get());

        // Crops
        LootItemCondition.Builder camasBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(MysticalSteamAgeBlocksRegister.camas.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CamasBlock.AGE, 5));
        this.add(MysticalSteamAgeBlocksRegister.camas.get(), this.createCropDrops(MysticalSteamAgeBlocksRegister.camas.get(),
                MysticalSteamAgeItemsRegister.camas.get(), MysticalSteamAgeItemsRegister.camas.get(), camasBuilder));

        LootItemCondition.Builder featherHerbBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(MysticalSteamAgeBlocksRegister.feather_herb.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FeatherHerbBlock.AGE, 5));
        this.add(MysticalSteamAgeBlocksRegister.feather_herb.get(), this.createCropDrops(MysticalSteamAgeBlocksRegister.feather_herb.get(),
                MysticalSteamAgeItemsRegister.feather_herb_leaf.get(), MysticalSteamAgeItemsRegister.feather_herb_leaf.get(), featherHerbBuilder));
    }

    protected LootTable.Builder createSilkTouchTable(String name, Block block, Item lootItem, float min, float max) {
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .setRolls(ConstantValue.exactly(1))
                .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(block)
                                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))),
                                LootItem.lootTableItem(lootItem)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
                                        .apply(ApplyExplosionDecay.explosionDecay())
                        )
                );
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createBaobabLeavesDrops(Block leavesBlock, Block saplingBlock) {
        return createLeavesDrops(leavesBlock, saplingBlock, NORMAL_LEAVES_SAPLING_CHANCES).withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                .add(this.applyExplosionCondition(leavesBlock, LootItem.lootTableItem(MysticalSteamAgeItemsRegister.bao_bapfel.get()))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))));
    }

    protected LootTable.Builder createCropDrops(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem, LootItemCondition.Builder pDropGrownCropCondition) {
        return this.applyExplosionDecay(pCropBlock, LootTable.lootTable().withPool(LootPool.lootPool()
                .add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition).otherwise(LootItem.lootTableItem(pSeedsItem))))
                .withPool(LootPool.lootPool().when(pDropGrownCropCondition).add(LootItem.lootTableItem(pSeedsItem)
                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return MysticalSteamAgeBlocksRegister.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}