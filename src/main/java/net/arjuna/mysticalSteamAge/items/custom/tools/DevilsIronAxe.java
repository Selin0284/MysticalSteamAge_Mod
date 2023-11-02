package net.arjuna.mysticalSteamAge.items.custom.tools;

import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DevilsIronAxe extends AxeItem {
    public static final Component REPAIR_SHIFT = Component.translatable("tooltip.self_repair.tooltip.shift").withStyle(ChatFormatting.GREEN);
    public static final Component REPAIR = Component.translatable("tooltip.self_repair.tooltip").withStyle(ChatFormatting.GREEN);

    public DevilsIronAxe(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        super.appendHoverText(stack, pLevel, pTooltipComponents, pIsAdvanced);
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(REPAIR_SHIFT);
        } else {
            pTooltipComponents.add(REPAIR);
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        if(stack.getItem() == MysticalSteamAgeItemsRegister.devil_iron_axe.get()) {
            if(pAttacker instanceof Player player) {
                if(player.totalExperience > 10) {
                    if(stack.getDamageValue() >= 50) {
                        stack.setDamageValue(stack.getDamageValue() - 50);
                        player.giveExperiencePoints(-10);
                    }
                }
            }
        }
        return super.hurtEnemy(stack, pTarget, pAttacker);
    }

    @Override
    public boolean mineBlock(ItemStack stack, @NotNull Level pLevel, @NotNull BlockState pState, @NotNull BlockPos pPos, @NotNull LivingEntity pEntityLiving) {
        if(stack.getItem() == MysticalSteamAgeItemsRegister.devil_iron_axe.get()) {
            if(pEntityLiving instanceof Player player) {
                if(player.totalExperience > 10) {
                    if(stack.getDamageValue() >= 50) {
                        stack.setDamageValue(stack.getDamageValue() - 50);
                        player.giveExperiencePoints(-10);
                    }
                }
            }
        }
        return super.mineBlock(stack, pLevel, pState, pPos, pEntityLiving);
    }

}
