package com.rodrigo.thewild.client.renderer;

import com.rodrigo.thewild.entity.WildBoarEntity;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WildBoarRenderer extends MobRenderer<WildBoarEntity, PigModel<WildBoarEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/entity/pig/pig.png");

    public WildBoarRenderer(EntityRendererProvider.Context context) {
        super(context, new PigModel<>(context.bakeLayer(ModelLayers.PIG)), 0.45F);
    }

    @Override
    public ResourceLocation getTextureLocation(WildBoarEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(WildBoarEntity entity, com.mojang.blaze3d.vertex.PoseStack poseStack, float partialTick) {
        float scale = entity.getBodyScale();
        poseStack.scale(scale, scale, scale);
    }
}
