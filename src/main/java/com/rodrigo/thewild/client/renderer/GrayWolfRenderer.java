package com.rodrigo.thewild.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rodrigo.thewild.client.model.WildAnimalModel;
import com.rodrigo.thewild.entity.GrayWolfEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GrayWolfRenderer extends MobRenderer<GrayWolfEntity, WildAnimalModel<GrayWolfEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/entity/wolf/wolf.png");

    public GrayWolfRenderer(EntityRendererProvider.Context context) {
        super(context, createModel(context), 0.45F);
    }

    private static WildAnimalModel<GrayWolfEntity> createModel(EntityRendererProvider.Context context) {
        WildAnimalModel<GrayWolfEntity> model = new WildAnimalModel<>(context.bakeLayer(WildAnimalModel.WOLF_LAYER));
        model.setType(WildAnimalModel.Type.WOLF);
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(GrayWolfEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(GrayWolfEntity entity, PoseStack poseStack, float partialTick) {
        float scale = entity.getBodyScale() * 0.85F;
        poseStack.scale(scale, scale, scale);
    }
}
