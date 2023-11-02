package net.arjuna.mysticalSteamAge.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class MesaFlowersBlock extends FlowerBlock {


    public MesaFlowersBlock(MobEffect pSuspiciousStewEffect, int pEffectDuration, Properties pProperties) {
        super(pSuspiciousStewEffect, pEffectDuration, pProperties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return pState.is(Blocks.SAND) || pState.is(Blocks.RED_SAND) || pState.is(Blocks.TERRACOTTA) ||
                pState.is(Blocks.WHITE_TERRACOTTA) || pState.is(Blocks.ORANGE_TERRACOTTA) || pState.is(Blocks.MAGENTA_TERRACOTTA) ||
                pState.is(Blocks.LIGHT_BLUE_TERRACOTTA) || pState.is(Blocks.YELLOW_TERRACOTTA) || pState.is(Blocks.LIME_TERRACOTTA) ||
                pState.is(Blocks.PINK_TERRACOTTA) || pState.is(Blocks.GRAY_TERRACOTTA) || pState.is(Blocks.LIGHT_GRAY_TERRACOTTA) ||
                pState.is(Blocks.CYAN_TERRACOTTA) || pState.is(Blocks.PURPLE_TERRACOTTA) || pState.is(Blocks.BLUE_TERRACOTTA) ||
                pState.is(Blocks.BROWN_TERRACOTTA) || pState.is(Blocks.GREEN_TERRACOTTA) || pState.is(Blocks.RED_TERRACOTTA) ||
                pState.is(Blocks.BLACK_TERRACOTTA) || super.mayPlaceOn(pState, pLevel, pPos);
    }
}
