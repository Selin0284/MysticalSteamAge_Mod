package net.arjuna.mysticalSteamAge.items.custom.armor;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DevilIronArmor extends ArmorItem {
    protected final Type slot;

    public static final Component REPAIR_SHIFT = Component.translatable("tooltip.self_repair.tooltip.shift").withStyle(ChatFormatting.GREEN);
    public static final Component REPAIR = Component.translatable("tooltip.self_repair.tooltip").withStyle(ChatFormatting.GREEN);

    public DevilIronArmor(ArmorMaterial pMaterial, Type pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
        this.slot = pSlot;
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
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            ItemStack boots = player.getInventory().getArmor(0);
            ItemStack leggings = player.getInventory().getArmor(1);
            ItemStack breastplate = player.getInventory().getArmor(2);
            ItemStack helmet = player.getInventory().getArmor(3);

            if (slot.equals(Type.BOOTS)) {
                if(player.totalExperience > 3) {
                    if(boots.getDamageValue() >= 15) {
                        boots.setDamageValue(boots.getDamageValue() - 15);
                        player.giveExperiencePoints(-3);
                    }
                }
            } else if (slot.equals(Type.LEGGINGS)) {
                if(player.totalExperience > 3) {
                    if(leggings.getDamageValue() >= 15) {
                        leggings.setDamageValue(leggings.getDamageValue() - 15);
                        player.giveExperiencePoints(-3);
                    }
                }
            } else if (slot.equals(Type.CHESTPLATE)) {
                if(player.totalExperience > 3) {
                    if(breastplate.getDamageValue() >= 15) {
                        breastplate.setDamageValue(breastplate.getDamageValue() - 15);
                        player.giveExperiencePoints(-3);
                    }
                }
            } else if (slot.equals(Type.HELMET)) {
                if(player.totalExperience > 3) {
                    if(helmet.getDamageValue() >= 15) {
                        helmet.setDamageValue(helmet.getDamageValue() - 15);
                        player.giveExperiencePoints(-3);
                    }
                }
            }
        }
    }
}
