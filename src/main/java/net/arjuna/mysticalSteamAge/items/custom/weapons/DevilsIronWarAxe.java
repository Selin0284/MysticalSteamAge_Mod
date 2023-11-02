package net.arjuna.mysticalSteamAge.items.custom.weapons;

import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DevilsIronWarAxe extends WarAxe {
    public static final Component REPAIR = Component.translatable("enchantment.self_repair").withStyle(ChatFormatting.GREEN);

    public DevilsIronWarAxe(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties, int defense) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties, defense);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        super.appendHoverText(stack, pLevel, pTooltipComponents, pIsAdvanced);
        if(stack.getItem() == MysticalSteamAgeItemsRegister.devil_iron_war_axe.get()) {
            pTooltipComponents.add(REPAIR);
        }
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        if(stack.getItem() == MysticalSteamAgeItemsRegister.devil_iron_war_axe.get()) {
            if(pAttacker instanceof Player player) {
                if(player.experienceLevel > 0) {
                    if(stack.getDamageValue() >= 400) {
                        stack.setDamageValue(stack.getDamageValue() - 400);
                        player.giveExperienceLevels(-1);
                    }
                }
            }
        }
        return super.hurtEnemy(stack, pTarget, pAttacker);
    }

    @Override
    public boolean mineBlock(ItemStack stack, @NotNull Level pLevel, @NotNull BlockState pState, @NotNull BlockPos pPos, @NotNull LivingEntity pEntityLiving) {
        if(stack.getItem() == MysticalSteamAgeItemsRegister.devil_iron_war_axe.get()) {
            if(pEntityLiving instanceof Player player) {
                if(player.experienceLevel > 0) {
                    if(stack.getDamageValue() >= 400) {
                        stack.setDamageValue(stack.getDamageValue() - 400);
                        player.giveExperienceLevels(-1);
                    }
                }
            }
        }
        return super.mineBlock(stack, pLevel, pState, pPos, pEntityLiving);
    }

}
