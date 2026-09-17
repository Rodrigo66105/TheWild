package com.rodrigo.thewild.client;

import com.rodrigo.thewild.TheWild;
import com.rodrigo.thewild.client.model.WildAnimalModel;
import com.rodrigo.thewild.client.renderer.GrayWolfRenderer;
import com.rodrigo.thewild.client.renderer.RedDeerRenderer;
import com.rodrigo.thewild.client.renderer.RedFoxRenderer;
import com.rodrigo.thewild.client.renderer.WildBoarRenderer;
import com.rodrigo.thewild.registry.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheWild.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ModClientEvents {
    private ModClientEvents() {}

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WildAnimalModel.DEER_LAYER,
                () -> WildAnimalModel.createBodyLayer(WildAnimalModel.Type.DEER));
        event.registerLayerDefinition(WildAnimalModel.FOX_LAYER,
                () -> WildAnimalModel.createBodyLayer(WildAnimalModel.Type.FOX));
        event.registerLayerDefinition(WildAnimalModel.WOLF_LAYER,
                () -> WildAnimalModel.createBodyLayer(WildAnimalModel.Type.WOLF));
        event.registerLayerDefinition(WildAnimalModel.BOAR_LAYER,
                () -> WildAnimalModel.createBodyLayer(WildAnimalModel.Type.BOAR));
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.RED_DEER.get(), RedDeerRenderer::new);
        event.registerEntityRenderer(ModEntities.WILD_BOAR.get(), WildBoarRenderer::new);
        event.registerEntityRenderer(ModEntities.RED_FOX.get(), RedFoxRenderer::new);
        event.registerEntityRenderer(ModEntities.GRAY_WOLF.get(), GrayWolfRenderer::new);
    }
}
