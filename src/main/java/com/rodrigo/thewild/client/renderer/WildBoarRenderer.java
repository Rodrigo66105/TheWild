package com.rodrigo.thewild.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rodrigo.thewild.client.model.WildAnimalModel;
import com.rodrigo.thewild.entity.WildBoarEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WildBoarRenderer extends MobRenderer<WildBoarEntity, WildAnimalModel<WildBoarEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/entity/pig/pig.png");

    public WildBoarRenderer(EntityRendererProvider.Context context) {
        super(context, createModel(context), 0.45F);
    }

    private static WildAnimalModel<WildBoarEntity> createModel(EntityRendererProvider.Context context) {
        WildAnimalModel<WildBoarEntity> model = new WildAnimalModel<>(context.bakeLayer(WildAnimalModel.BOAR_LAYER));
        model.setType(WildAnimalModel.Type.BOAR);
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(WildBoarEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(WildBoarEntity entity, PoseStack poseStack, float partialTick) {
        float scale = entity.getBodyScale();
        poseStack.scale(scale, scale, scale);
    }
}
