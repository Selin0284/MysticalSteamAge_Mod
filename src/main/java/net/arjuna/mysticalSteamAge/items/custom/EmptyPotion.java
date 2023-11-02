package net.arjuna.mysticalSteamAge.items.custom;

import net.arjuna.mysticalSteamAge.items.MysticalSteamAgeItemsRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class EmptyPotion extends Item {

	public EmptyPotion(Properties pProperties) {
		super(pProperties);
	}

	public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pHand) {
		ItemStack itemstack = pPlayer.getItemInHand(pHand);

		BlockHitResult hitResult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.SOURCE_ONLY);
		if (hitResult.getType() == HitResult.Type.MISS) {
			return InteractionResultHolder.pass(itemstack);
		} else {
			if (hitResult.getType() == HitResult.Type.BLOCK) {
				BlockPos blockpos = hitResult.getBlockPos();
				if (!pLevel.mayInteract(pPlayer, blockpos)) {
					return InteractionResultHolder.pass(itemstack);
				}

				if (pLevel.getFluidState(blockpos).is(FluidTags.WATER)) {
					pLevel.playSound(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.BOTTLE_FILL,
							SoundSource.NEUTRAL, 1.0F, 1.0F);
					pLevel.gameEvent(pPlayer, GameEvent.FLUID_PICKUP, blockpos);
					return InteractionResultHolder.sidedSuccess(
							this.turnBottleIntoItem(itemstack, pPlayer, new ItemStack(MysticalSteamAgeItemsRegister.big_water_potion.get())), pLevel.isClientSide());
				}
			}

			return InteractionResultHolder.pass(itemstack);
		}
	}

	protected ItemStack turnBottleIntoItem(ItemStack pBottleStack, Player pPlayer, ItemStack pFilledBottleStack) {
		pPlayer.awardStat(Stats.ITEM_USED.get(this));
		return ItemUtils.createFilledResult(pBottleStack, pPlayer, pFilledBottleStack);
	}

}
