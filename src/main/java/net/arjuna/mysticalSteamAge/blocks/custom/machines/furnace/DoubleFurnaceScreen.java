package net.arjuna.mysticalSteamAge.blocks.custom.machines.furnace;

import com.mojang.blaze3d.systems.RenderSystem;
import net.arjuna.mysticalSteamAge.MysticalSteamAge;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class DoubleFurnaceScreen extends AbstractContainerScreen<DoubleFurnaceMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MysticalSteamAge.MOD_ID, "textures/gui/double_furnace.png");
    private boolean widthTooNarrow;

    public DoubleFurnaceScreen(DoubleFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    public void init() {
        super.init();
        this.widthTooNarrow = this.width < 379;
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    public void containerTick() {
        super.containerTick();
    }

    public void render(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pGuiGraphics);
        if (this.widthTooNarrow) {
            this.renderBg(pGuiGraphics, pPartialTick, pMouseX, pMouseY);
        } else {
            super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        }
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    protected void renderBg(@NotNull GuiGraphics pGuiGraphics, float pPartialTick, int pX, int pY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = this.leftPos;
        int j = this.topPos;
        pGuiGraphics.blit(TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);
        if (this.menu.isLit()) {
            int k = this.menu.getLitProgress();
            pGuiGraphics.blit(TEXTURE, i + 47, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.menu.getBurnProgress();
        pGuiGraphics.blit(TEXTURE, i + 79, j + 34, 176, 14, l + 1, 16);
    }
}
