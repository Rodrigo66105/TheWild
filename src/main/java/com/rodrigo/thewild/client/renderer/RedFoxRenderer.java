package com.rodrigo.thewild.client.renderer;

import com.rodrigo.thewild.entity.RedFoxEntity;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RedFoxRenderer extends MobRenderer<RedFoxEntity, CowModel<RedFoxEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/entity/fox/fox.png");

    public RedFoxRenderer(EntityRendererProvider.Context context) {
        super(context, new CowModel<>(context.bakeLayer(ModelLayers.COW)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(RedFoxEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(RedFoxEntity entity, com.mojang.blaze3d.vertex.PoseStack poseStack, float partialTick) {
        float scale = entity.getBodyScale() * 0.75F;
        poseStack.scale(scale, scale, scale);
    }
}
