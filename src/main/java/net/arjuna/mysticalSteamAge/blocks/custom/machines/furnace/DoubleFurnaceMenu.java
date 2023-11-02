package net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace;

import net.arjuna.mysticalSteamAge.blocks.MysticalSteamAgeMachinesRegister;
import net.arjuna.mysticalSteamAge.blocks.custom.machines.MysticalSteamAgeMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class DoubleFurnaceMenu extends AbstractContainerMenu {

    public static final int INGREDIENT_SLOT_1 = 0;
    public static final int INGREDIENT_SLOT_2 = 1;
    public static final int FUEL_SLOT = 2;
    public static final int RESULT_SLOT = 3;

    private static final int INV_SLOT_START = 4;
    private static final int INV_SLOT_END = 31;
    private static final int USE_ROW_SLOT_START = 31;
    private static final int USE_ROW_SLOT_END = 40;

    private final Container container;
    private final ContainerData data;
    protected final Level level;

    public DoubleFurnaceMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, (DoubleFurnaceBE) inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public DoubleFurnaceMenu(int pId, Inventory inv, DoubleFurnaceBE be) {
        this(pId, inv, be, be.dataAccess);
    }

    static class SlotContainerValid extends Slot {
        public SlotContainerValid(Container pContainer, int pIndex, int pX, int pY) {
            super(pContainer, pIndex, pX, pY);
        }

        public boolean mayPlace(@NotNull ItemStack pStack) {
            return this.container.canPlaceItem(this.index, pStack);
        }
    }

    public static class FurnaceResultSlot extends Slot {
        private final Player player;
        private int removeCount;

        public FurnaceResultSlot(Player p_39542_, Container p_39543_, int p_39544_, int p_39545_, int p_39546_) {
            super(p_39543_, p_39544_, p_39545_, p_39546_);
            this.player = p_39542_;
        }

        /**
         * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
         */
        public boolean mayPlace(@NotNull ItemStack pStack) {
            return false;
        }

        /**
         * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new stack.
         */
        public @NotNull ItemStack remove(int pAmount) {
            if (this.hasItem()) {
                this.removeCount += Math.min(pAmount, this.getItem().getCount());
            }

            return super.remove(pAmount);
        }

        public void onTake(@NotNull Player pPlayer, @NotNull ItemStack pStack) {
            this.checkTakeAchievements(pStack);
            super.onTake(pPlayer, pStack);
        }

        /**
         * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
         * internal count then calls onCrafting(item).
         */
        protected void onQuickCraft(@NotNull ItemStack pStack, int pAmount) {
            this.removeCount += pAmount;
            this.checkTakeAchievements(pStack);
        }

        /**
         * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
         */
        protected void checkTakeAchievements(ItemStack pStack) {
            pStack.onCraftedBy(this.player.level(), this.player, this.removeCount);
            if (this.player instanceof ServerPlayer && this.container instanceof DoubleFurnaceBE) {
                ((DoubleFurnaceBE)this.container).awardUsedRecipesAndPopExperience((ServerPlayer)this.player);
            }

            this.removeCount = 0;
            net.minecraftforge.event.ForgeEventFactory.firePlayerSmeltedEvent(this.player, pStack);
        }
    }

    protected DoubleFurnaceMenu(int pId, Inventory inv, Container cont, ContainerData contData) {
        super(MysticalSteamAgeMenuTypes.double_furnace_menu.get(), pId);

        checkContainerSize(cont, 3);
        checkContainerDataCount(contData, 4);

        this.container = cont;
        this.data = contData;
        this.level = inv.player.level();

        this.addSlot(new SlotContainerValid(cont, INGREDIENT_SLOT_1, 37, 17));
        this.addSlot(new SlotContainerValid(cont, INGREDIENT_SLOT_2, 56, 17));
        this.addSlot(new SlotContainerValid(cont, FUEL_SLOT, 46, 53));
        this.addSlot(new FurnaceResultSlot(inv.player, cont, RESULT_SLOT, 116, 35));

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inv, k, 8 + k * 18, 142));
        }

        this.addDataSlots(contData);
    }


    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();


            if (index == RESULT_SLOT) {
                if (!this.moveItemStackTo(itemstack1, INV_SLOT_START, USE_ROW_SLOT_END, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);//wrong
            } else if (index == INGREDIENT_SLOT_2 || index == INGREDIENT_SLOT_1 || index == FUEL_SLOT) {
                if (!this.moveItemStackTo(itemstack1, INV_SLOT_START, USE_ROW_SLOT_END, false)) {
                    return ItemStack.EMPTY;
                }
            }
            else
            {
                if(container.canPlaceItem(INGREDIENT_SLOT_1, itemstack1)){
                    if (!this.moveItemStackTo(itemstack1, INGREDIENT_SLOT_1, INGREDIENT_SLOT_1 + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else if(container.canPlaceItem(INGREDIENT_SLOT_2, itemstack1)){
                    if (!this.moveItemStackTo(itemstack1, INGREDIENT_SLOT_2, INGREDIENT_SLOT_2 + 2, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else if(container.canPlaceItem(FUEL_SLOT, itemstack1)){
                    if (!this.moveItemStackTo(itemstack1, FUEL_SLOT, FUEL_SLOT + 2, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= INV_SLOT_START && index < INV_SLOT_END) {
                    if (!this.moveItemStackTo(itemstack1, USE_ROW_SLOT_START, USE_ROW_SLOT_END, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= USE_ROW_SLOT_START && index < USE_ROW_SLOT_END && !this.moveItemStackTo(itemstack1, INV_SLOT_START, INV_SLOT_END, false)) {
                    return ItemStack.EMPTY;
                }

            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return this.container.stillValid(pPlayer);
    }

    public int getBurnProgress() {
        int i = this.data.get(2);
        int j = this.data.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    public int getLitProgress() {
        int i = this.data.get(1);
        if (i == 0) {
            i = 200;
        }

        return this.data.get(0) * 13 / i;
    }

    public boolean isLit() {
        return this.data.get(0) > 0;
    }
}
