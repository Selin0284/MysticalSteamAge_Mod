package net.arjuna.mysticalSteamAge.blocks.custom;

import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class CamasBlock extends CropBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;
    private static final VoxelShape[] SHAPES = new VoxelShape[] {
      Block.box(5, 0, 5, 11, 6,11),
      Block.box(4, 0, 4, 12, 12,12),
      Block.box(3, 0, 3, 13, 13,13),
      Block.box(3, 0, 3, 13, 15,13),
      Block.box(2, 0, 2, 14, 15,14),
      Block.box(2, 0, 2, 14, 15,14)
    };

    public CamasBlock(Properties p_52247_) {
        super(p_52247_);
    }

    @Override
    public int getMaxAge() {
        return 5;
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return MysticalSteamAgeItemsRegister.camas.get();
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return pState.is(Blocks.SAND) || pState.is(Blocks.FARMLAND);
    }

    @Override
    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(AGE);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext col) {

        return SHAPES[state.getValue(this.getAgeProperty())];
    }
}
