package net.arjuna.mysticalSteamAge.datagen.Loot;

import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class MysticalSteamAgeEntityLootTables extends EntityLootSubProvider {

    public MysticalSteamAgeEntityLootTables() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        /*this.add(MysticalSteamAgeEntitiesRegister.ROADIE.get(), createRoadieDropTable());
        this.add(MysticalSteamAgeEntitiesRegister.FLOWER_HORSE.get(), createBlumentoDropTable());*/
    }

    protected LootTable.Builder createRoadieDropTable() {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(
                        LootItem.lootTableItem(MysticalSteamAgeItemsRegister.raw_roadie_leg.get()).apply(
                                SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(
                                LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(
                        MysticalSteamAgeItemsRegister.raw_roadie_meat.get()).apply(
                        SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(
                        SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))).apply(
                        LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F)))));
    }

    protected LootTable.Builder createBlumentoDropTable() {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(
                LootItem.lootTableItem(MysticalSteamAgeItemsRegister.blumento_leather.get()).apply(
                        SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(
                        LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(1.0F, 2.0F)))));
    }
}
