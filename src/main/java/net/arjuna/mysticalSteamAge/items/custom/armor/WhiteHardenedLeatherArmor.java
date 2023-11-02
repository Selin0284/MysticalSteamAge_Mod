package net.arjuna.mysticalSteamAge.items.custom.armor;

import com.google.common.collect.ImmutableMap;
import net.arjuna.mysticalSteamAge.items.custom.CustomArmorMaterials;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class WhiteHardenedLeatherArmor extends ArmorItem {

    protected final Type slot;
    public static final Component EFFECT = Component.translatable("tooltip.has_white_effect.tooltip").withStyle(ChatFormatting.GREEN);
    public static final Component NO_EFFECT = Component.translatable("tooltip.has_white_effect.tooltip").withStyle(ChatFormatting.GRAY);
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(CustomArmorMaterials.WHITE_HARDENED_LEATHER,
                            new MobEffectInstance(MobEffects.JUMP, 200, 1)).build();

    public WhiteHardenedLeatherArmor(ArmorMaterial material, Type slot, Properties settings) {
        super(material, slot, settings);
        this.slot = slot;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        super.appendHoverText(stack, pLevel, pTooltipComponents, pIsAdvanced);
        Player player;
        boolean isEquip = false;

        player = Minecraft.getInstance().player;
        if (player != null) {
            if (slot.equals(Type.HELMET)) {
                if (stack == player.getInventory().getArmor(3)) {
                    isEquip = true;
                }
            } else if (slot.equals(Type.CHESTPLATE)) {
                if (stack == player.getInventory().getArmor(2)) {
                    isEquip = true;
                }
            } else if (slot.equals(Type.LEGGINGS)) {
                if (stack == player.getInventory().getArmor(1)) {
                    isEquip = true;
                }
            } else if (slot.equals(Type.BOOTS)) {
                if (stack == player.getInventory().getArmor(0)) {
                    isEquip = true;
                }
            }

            if (isEquip) {
                if (hasFullSuitOfArmorOn(player)) {
                    if (hasCorrectArmorOn(CustomArmorMaterials.PURPLE_HARDENED_LEATHER, player)) {
                        pTooltipComponents.add(EFFECT);
                        return;
                    }
                }
            }
        }
        pTooltipComponents.add(NO_EFFECT);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            if(hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial, MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect.getEffect(),
                    mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier(), false, false));

            //if(new Random().nextFloat() > 0.6f) { // 40% of damaging the armor! Possibly!
            //    player.getInventory().hurtArmor(DamageSource.MAGIC, 1f, new int[]{0, 1, 2, 3});
            //}
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
