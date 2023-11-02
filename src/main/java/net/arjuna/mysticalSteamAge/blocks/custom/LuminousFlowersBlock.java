package net.arjuna.mysticalSteamAge.blocks.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class LuminousFlowersBlock extends FlowerBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public LuminousFlowersBlock(MobEffect pSuspiciousStewEffect, int pEffectDuration, Properties pProperties) {
        super(pSuspiciousStewEffect, pEffectDuration, pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.TRUE));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT);
    }

}
