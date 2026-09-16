package com.rodrigo.thewild.client.renderer;

import com.rodrigo.thewild.entity.RedDeerEntity;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RedDeerRenderer extends MobRenderer<RedDeerEntity, CowModel<RedDeerEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/entity/cow/cow.png");

    public RedDeerRenderer(EntityRendererProvider.Context context) {
        super(context, new CowModel<>(context.bakeLayer(ModelLayers.COW)), 0.55F);
    }

    @Override
    public ResourceLocation getTextureLocation(RedDeerEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(RedDeerEntity entity, com.mojang.blaze3d.vertex.PoseStack poseStack, float partialTick) {
        float scale = entity.getBodyScale();
        poseStack.scale(scale, scale, scale);
    }
}
