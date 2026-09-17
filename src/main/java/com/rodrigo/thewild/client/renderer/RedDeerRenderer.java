package com.rodrigo.thewild.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rodrigo.thewild.client.model.WildAnimalModel;
import com.rodrigo.thewild.entity.RedDeerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RedDeerRenderer extends MobRenderer<RedDeerEntity, WildAnimalModel<RedDeerEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/entity/horse/horse_brown.png");

    public RedDeerRenderer(EntityRendererProvider.Context context) {
        super(context, createModel(context), 0.55F);
    }

    private static WildAnimalModel<RedDeerEntity> createModel(EntityRendererProvider.Context context) {
        WildAnimalModel<RedDeerEntity> model = new WildAnimalModel<>(context.bakeLayer(WildAnimalModel.DEER_LAYER));
        model.setType(WildAnimalModel.Type.DEER);
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(RedDeerEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(RedDeerEntity entity, PoseStack poseStack, float partialTick) {
        float scale = entity.getBodyScale();
        poseStack.scale(scale, scale, scale);
    }
}
