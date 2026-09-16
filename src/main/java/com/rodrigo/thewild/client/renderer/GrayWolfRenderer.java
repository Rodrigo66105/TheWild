package com.rodrigo.thewild.client.renderer;

import com.rodrigo.thewild.entity.GrayWolfEntity;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GrayWolfRenderer extends MobRenderer<GrayWolfEntity, CowModel<GrayWolfEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/entity/wolf/wolf.png");

    public GrayWolfRenderer(EntityRendererProvider.Context context) {
        super(context, new CowModel<>(context.bakeLayer(ModelLayers.COW)), 0.45F);
    }

    @Override
    public ResourceLocation getTextureLocation(GrayWolfEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(GrayWolfEntity entity, com.mojang.blaze3d.vertex.PoseStack poseStack, float partialTick) {
        float scale = entity.getBodyScale() * 0.85F;
        poseStack.scale(scale, scale, scale);
    }
}
