package net.arjuna.mysticalSteamAge.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BasePressurePlateBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StuddedPressurePlateBlock extends BasePressurePlateBlock {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    private final Sensitivity sensitivity;

    public StuddedPressurePlateBlock(Sensitivity p_55253_, Properties p_55254_, BlockSetType pType) {
        super(p_55254_, pType);
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, Boolean.FALSE));
        this.sensitivity = p_55253_;
    }

    protected int getSignalForState(BlockState p_55270_) {
        return p_55270_.getValue(POWERED) ? 15 : 0;
    }

    protected @NotNull BlockState setSignalForState(BlockState p_55259_, int p_55260_) {
        return p_55259_.setValue(POWERED, p_55260_ > 0);
    }

    protected void playOnSound(@NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos) {
        if (this.defaultMapColor() != MapColor.WOOD) {
            levelAccessor.playSound(null, blockPos, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundSource.BLOCKS, 0.3F, 0.6F);
        } else {
            levelAccessor.playSound(null, blockPos, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundSource.BLOCKS, 0.3F, 0.8F);
        }

    }

    protected void playOffSound(@NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos) {
        if (this.defaultMapColor() != MapColor.WOOD) {
            levelAccessor.playSound(null, blockPos, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundSource.BLOCKS, 0.3F, 0.5F);
        } else {
            levelAccessor.playSound(null, blockPos, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundSource.BLOCKS, 0.3F, 0.7F);
        }

    }

    protected int getSignalStrength(@NotNull Level level, @NotNull BlockPos blockPos) {
        AABB aabb = TOUCH_AABB.move(blockPos);
        List<? extends Entity> list;
        switch(this.sensitivity) {
            case EVERYTHING:
                list = level.getEntities(null, aabb);
                break;
            case PLAYER:
                list = level.getEntitiesOfClass(Player.class, aabb);
                break;
            case MOBS:
                list = level.getEntitiesOfClass(LivingEntity.class, aabb);
                break;
            default:
                return 0;
        }

        if (!list.isEmpty()) {
            for(Entity entity : list) {
                if (!entity.isIgnoringBlockTriggers()) {
                    return 15;
                }
            }
        }

        return 0;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55262_) {
        p_55262_.add(POWERED);
    }

    public enum Sensitivity {
        EVERYTHING,
        PLAYER,
        MOBS
    }
}
