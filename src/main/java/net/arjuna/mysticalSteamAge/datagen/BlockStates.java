package net.arjuna.mysticalSteamAge.datagen;

import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeBlocksRegister;
import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeMachinesRegister;
import net.arjuna.mysticalSteamAge.blocks.custom.StuddedPressurePlateBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockStates  extends BlockStateProvider {

    public BlockStates(PackOutput output, ExistingFileHelper helper) {
        super(output, MysticalSteamAge.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Blocks
        blockWithItem(MysticalSteamAgeBlocksRegister.brass_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.bronze_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.tin_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.zinc_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.devil_iron_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.steel_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.salt_block);
        // Ores
        blockWithItem(MysticalSteamAgeBlocksRegister.deepslate_sulphur_ore);
        blockWithItem(MysticalSteamAgeBlocksRegister.deepslate_tin_ore);
        blockWithItem(MysticalSteamAgeBlocksRegister.deepslate_zinc_ore);
        blockWithItem(MysticalSteamAgeBlocksRegister.nether_coal_ore);
        blockWithItem(MysticalSteamAgeBlocksRegister.nether_devil_iron_ore);
        blockWithItem(MysticalSteamAgeBlocksRegister.nether_sulphur_ore);
        blockWithItem(MysticalSteamAgeBlocksRegister.tin_ore);
        blockWithItem(MysticalSteamAgeBlocksRegister.zinc_ore);
        blockWithItem(MysticalSteamAgeBlocksRegister.salt_ore);
        blockWithItem(MysticalSteamAgeBlocksRegister.marble);
        blockWithItem(MysticalSteamAgeBlocksRegister.marble_black);
        // Decoration
        stairsBlock(((StairBlock) MysticalSteamAgeBlocksRegister.marble_stairs.get()), blockTexture(MysticalSteamAgeBlocksRegister.marble.get()));
        slabBlock(((SlabBlock) MysticalSteamAgeBlocksRegister.marble_slab.get()), blockTexture(MysticalSteamAgeBlocksRegister.marble.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.marble.get()));
        wallBlock(((WallBlock) MysticalSteamAgeBlocksRegister.marble_wall.get()), blockTexture(MysticalSteamAgeBlocksRegister.marble.get()));
        stairsBlock(((StairBlock) MysticalSteamAgeBlocksRegister.marble_black_stairs.get()), blockTexture(MysticalSteamAgeBlocksRegister.marble_black.get()));
        slabBlock(((SlabBlock) MysticalSteamAgeBlocksRegister.marble_black_slab.get()), blockTexture(MysticalSteamAgeBlocksRegister.marble_black.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.marble_black.get()));
        wallBlock(((WallBlock) MysticalSteamAgeBlocksRegister.marble_black_wall.get()), blockTexture(MysticalSteamAgeBlocksRegister.marble_black.get()));
        blockWithItem(MysticalSteamAgeBlocksRegister.marble_brick);
        stairsBlock(((StairBlock) MysticalSteamAgeBlocksRegister.marble_bricks_stairs.get()), blockTexture(MysticalSteamAgeBlocksRegister.marble_brick.get()));
        slabBlock(((SlabBlock) MysticalSteamAgeBlocksRegister.marble_bricks_slab.get()), blockTexture(MysticalSteamAgeBlocksRegister.marble_brick.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.marble_brick.get()));
        wallBlock(((WallBlock) MysticalSteamAgeBlocksRegister.marble_bricks_wall.get()), blockTexture(MysticalSteamAgeBlocksRegister.marble_brick.get()));
        blockWithItem(MysticalSteamAgeBlocksRegister.marble_black_brick);
        stairsBlock(((StairBlock) MysticalSteamAgeBlocksRegister.marble_black_bricks_stairs.get()), blockTexture(MysticalSteamAgeBlocksRegister.marble_black_brick.get()));
        slabBlock(((SlabBlock) MysticalSteamAgeBlocksRegister.marble_black_bricks_slab.get()), blockTexture(MysticalSteamAgeBlocksRegister.marble_black_brick.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.marble_black_brick.get()));
        wallBlock(((WallBlock) MysticalSteamAgeBlocksRegister.marble_black_bricks_wall.get()), blockTexture(MysticalSteamAgeBlocksRegister.marble_black_brick.get()));
        blockWithItem(MysticalSteamAgeBlocksRegister.polished_marble);
        stairsBlock(((StairBlock) MysticalSteamAgeBlocksRegister.polished_marble_stairs.get()), blockTexture(MysticalSteamAgeBlocksRegister.polished_marble.get()));
        slabBlock(((SlabBlock) MysticalSteamAgeBlocksRegister.polished_marble_slab.get()), blockTexture(MysticalSteamAgeBlocksRegister.polished_marble.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.polished_marble.get()));
        blockWithItem(MysticalSteamAgeBlocksRegister.polished_marble_black);
        stairsBlock(((StairBlock) MysticalSteamAgeBlocksRegister.polished_marble_black_stairs.get()), blockTexture(MysticalSteamAgeBlocksRegister.polished_marble_black.get()));
        slabBlock(((SlabBlock) MysticalSteamAgeBlocksRegister.polished_marble_black_slab.get()), blockTexture(MysticalSteamAgeBlocksRegister.polished_marble_black.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.polished_marble_black.get()));
        // Leather
        blockWithItem(MysticalSteamAgeBlocksRegister.block_black_hardened_leather);
        blockWithItem(MysticalSteamAgeBlocksRegister.block_blue_hardened_leather);
        blockWithItem(MysticalSteamAgeBlocksRegister.block_brown_hardened_leather);
        blockWithItem(MysticalSteamAgeBlocksRegister.block_green_hardened_leather);
        blockWithItem(MysticalSteamAgeBlocksRegister.block_light_green_hardened_leather);
        blockWithItem(MysticalSteamAgeBlocksRegister.block_purple_hardened_leather);
        blockWithItem(MysticalSteamAgeBlocksRegister.block_red_hardened_leather);
        blockWithItem(MysticalSteamAgeBlocksRegister.block_white_hardened_leather);
        // Boabab Wood
        logBlock(((RotatedPillarBlock) MysticalSteamAgeBlocksRegister.baobab_log.get()));
        axisBlock(((RotatedPillarBlock) MysticalSteamAgeBlocksRegister.baobab_wood.get()),
                blockTexture(MysticalSteamAgeBlocksRegister.baobab_log.get()), blockTexture(MysticalSteamAgeBlocksRegister.baobab_log.get()));
        blockItem(MysticalSteamAgeBlocksRegister.baobab_log);
        blockItem(MysticalSteamAgeBlocksRegister.baobab_wood);
        blockWithItem(MysticalSteamAgeBlocksRegister.baobab_planks);
        leavesBlock(MysticalSteamAgeBlocksRegister.baobab_leaves);
        stairsBlock(((StairBlock) MysticalSteamAgeBlocksRegister.baobab_stairs.get()), blockTexture(MysticalSteamAgeBlocksRegister.baobab_planks.get()));
        slabBlock(((SlabBlock) MysticalSteamAgeBlocksRegister.baobab_slab.get()), blockTexture(MysticalSteamAgeBlocksRegister.baobab_planks.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.baobab_planks.get()));
        fenceBlock(((FenceBlock) MysticalSteamAgeBlocksRegister.baobab_fence.get()), blockTexture(MysticalSteamAgeBlocksRegister.baobab_planks.get()));
        fenceGateBlock(((FenceGateBlock) MysticalSteamAgeBlocksRegister.baobab_fence_gate.get()), blockTexture(MysticalSteamAgeBlocksRegister.baobab_planks.get()));
        doorBlockWithRenderType(((DoorBlock) MysticalSteamAgeBlocksRegister.baobab_door.get()), modLoc("block/baobab_door_bottom")
                , modLoc("block/baobab_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) MysticalSteamAgeBlocksRegister.baobab_trapdoor.get()), modLoc("block/baobab_trapdoor")
                , true, "cutout");
        pressurePlateBlock(((PressurePlateBlock) MysticalSteamAgeBlocksRegister.baobab_pressure_plate.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.baobab_planks.get()));
        buttonBlock(((ButtonBlock) MysticalSteamAgeBlocksRegister.baobab_button.get()), blockTexture(MysticalSteamAgeBlocksRegister.baobab_planks.get()));
        // Studded Items
        doorBlockWithRenderType(((DoorBlock) MysticalSteamAgeBlocksRegister.studded_wooden_door_1.get()), modLoc("block/studded_wooden_door_1_bottom")
                , modLoc("block/studded_wooden_door_1_top"), "cutout");
        doorBlockWithRenderType(((DoorBlock) MysticalSteamAgeBlocksRegister.studded_wooden_door_2.get()), modLoc("block/studded_wooden_door_2_bottom")
                , modLoc("block/studded_wooden_door_2_top"), "cutout");
        doorBlockWithRenderType(((DoorBlock) MysticalSteamAgeBlocksRegister.studded_wooden_door_3.get()), modLoc("block/studded_wooden_door_3_bottom")
                , modLoc("block/studded_wooden_door_3_top"), "cutout");
        blockWithItem(MysticalSteamAgeBlocksRegister.acacia_iron_studded_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.acacia_gold_studded_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.baobab_iron_studded_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.baobab_gold_studded_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.birch_iron_studded_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.birch_gold_studded_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.dark_oak_iron_studded_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.dark_oak_gold_studded_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.jungle_iron_studded_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.jungle_gold_studded_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.oak_iron_studded_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.oak_gold_studded_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.spruce_iron_studded_block);
        blockWithItem(MysticalSteamAgeBlocksRegister.spruce_gold_studded_block);
        pressurePlateBlock(((StuddedPressurePlateBlock) MysticalSteamAgeBlocksRegister.acacia_studded_pressure_plate.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.acacia_iron_studded_block.get()));
        pressurePlateBlock(((StuddedPressurePlateBlock) MysticalSteamAgeBlocksRegister.baobab_studded_pressure_plate.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.baobab_iron_studded_block.get()));
        pressurePlateBlock(((StuddedPressurePlateBlock) MysticalSteamAgeBlocksRegister.birch_studded_pressure_plate.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.birch_iron_studded_block.get()));
        pressurePlateBlock(((StuddedPressurePlateBlock) MysticalSteamAgeBlocksRegister.dark_oak_studded_pressure_plate.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.dark_oak_iron_studded_block.get()));
        pressurePlateBlock(((StuddedPressurePlateBlock) MysticalSteamAgeBlocksRegister.jungle_studded_pressure_plate.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.jungle_iron_studded_block.get()));
        pressurePlateBlock(((StuddedPressurePlateBlock) MysticalSteamAgeBlocksRegister.oak_studded_pressure_plate.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.oak_iron_studded_block.get()));
        pressurePlateBlock(((StuddedPressurePlateBlock) MysticalSteamAgeBlocksRegister.spruce_studded_pressure_plate.get())
                , blockTexture(MysticalSteamAgeBlocksRegister.spruce_iron_studded_block.get()));


    }


    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void pressurePlateBlock(StuddedPressurePlateBlock block, ResourceLocation texture) {
        ModelFile pressurePlate = models().pressurePlate(name(block), texture);
        ModelFile pressurePlateDown = models().pressurePlateDown(name(block) + "_down", texture);
        pressurePlateBlock(block, pressurePlate, pressurePlateDown);
    }

    public void pressurePlateBlock(StuddedPressurePlateBlock block, ModelFile pressurePlate, ModelFile pressurePlateDown) {
        getVariantBuilder(block)
                .partialState().with(StuddedPressurePlateBlock.POWERED, true).addModels(new ConfiguredModel(pressurePlateDown))
                .partialState().with(StuddedPressurePlateBlock.POWERED, false).addModels(new ConfiguredModel(pressurePlate));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(MysticalSteamAge.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
}
