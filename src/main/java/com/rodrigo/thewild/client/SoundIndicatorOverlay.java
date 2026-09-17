package com.rodrigo.thewild.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.rodrigo.thewild.TheWild;

/**
 * Client-only visual representation of the noise the player is making.
 * The value follows vanilla Minecraft movement/sound behaviour: walking,
 * sprinting, jumping/falling and sneaking change the amount of noise.
 * No custom sound files are introduced; Minecraft's own sound system remains
 * responsible for the actual footsteps and movement sounds.
 */
@Mod.EventBusSubscriber(modid = TheWild.MOD_ID, value = Dist.CLIENT)
public final class SoundIndicatorOverlay {
    private static float noise = 0.0F;
    private static float displayedNoise = 0.0F;

    private SoundIndicatorOverlay() {}

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null || mc.isPaused()) {
            noise *= 0.92F;
            displayedNoise += (noise - displayedNoise) * 0.18F;
            return;
        }

        float target = 0.0F;

        if (player.isSprinting() && player.onGround()) {
            target = 1.0F;
        } else if (player.isShiftKeyDown()) {
            target = 0.08F;
        } else if (player.onGround() && player.getDeltaMovement().horizontalDistanceSqr() > 0.0004D) {
            target = 0.42F;
        }

        // Jumping/falling produces a short, loud movement sound in vanilla.
        if (!player.onGround()) {
            target = Math.max(target, 0.72F);
        }

        // Swimming is quieter than sprinting but still audible.
        if (player.isSwimming()) {
            target = Math.max(target, 0.30F);
        }

        noise += (target - noise) * 0.35F;
        noise *= 0.985F;
        displayedNoise += (noise - displayedNoise) * 0.22F;
    }

    @SubscribeEvent
    public static void onRenderOverlay(RenderGuiOverlayEvent.Post event) {
        // Render after the hotbar so the indicator sits cleanly in the lower-right HUD.
        if (event.getOverlay() != net.minecraftforge.client.gui.overlay.VanillaGuiOverlay.HOTBAR.type()) {
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.options.hideGui) {
            return;
        }

        GuiGraphics graphics = event.getGuiGraphics();
        int width = graphics.guiWidth();
        int height = graphics.guiHeight();

        int barWidth = 92;
        int barHeight = 10;
        int right = width - 8;
        int bottom = height - 8;
        int left = right - barWidth;
        int top = bottom - barHeight;

        // Dark, compact background similar to Minecraft's own HUD panels.
        graphics.fill(left, top, right, bottom, 0xAA111111);
        graphics.fill(left + 1, top + 1, right - 1, bottom - 1, 0xFF303030);

        int fillWidth = Math.round((barWidth - 4) * Math.min(1.0F, displayedNoise));
        int fillColor;
        if (displayedNoise < 0.25F) {
            fillColor = 0xFF55AA55;
        } else if (displayedNoise < 0.60F) {
            fillColor = 0xFFE0B84A;
        } else {
            fillColor = 0xFFE05252;
        }

        if (fillWidth > 0) {
            graphics.fill(left + 2, top + 2, left + 2 + fillWidth, bottom - 2, fillColor);
        }

        graphics.drawString(mc.font, "SONIDO", left - 42, top + 1, 0xFFEFEFEF, false);
    }
}
