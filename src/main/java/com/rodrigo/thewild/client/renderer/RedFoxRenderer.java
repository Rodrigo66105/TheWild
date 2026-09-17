package com.rodrigo.thewild.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rodrigo.thewild.client.model.WildAnimalModel;
import com.rodrigo.thewild.entity.RedFoxEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RedFoxRenderer extends MobRenderer<RedFoxEntity, WildAnimalModel<RedFoxEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/entity/fox/fox.png");

    public RedFoxRenderer(EntityRendererProvider.Context context) {
        super(context, createModel(context), 0.4F);
    }

    private static WildAnimalModel<RedFoxEntity> createModel(EntityRendererProvider.Context context) {
        WildAnimalModel<RedFoxEntity> model = new WildAnimalModel<>(context.bakeLayer(WildAnimalModel.FOX_LAYER));
        model.setType(WildAnimalModel.Type.FOX);
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(RedFoxEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(RedFoxEntity entity, PoseStack poseStack, float partialTick) {
        float scale = entity.getBodyScale() * 0.75F;
        poseStack.scale(scale, scale, scale);
    }
}
