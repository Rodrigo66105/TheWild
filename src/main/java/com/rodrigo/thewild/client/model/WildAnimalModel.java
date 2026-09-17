package com.rodrigo.thewild.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.rodrigo.thewild.TheWild;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

/**
 * Minecraft-adapted realistic quadruped model used by the first TheWild animals.
 * Geometry is deliberately more anatomical than vanilla mobs while keeping
 * Minecraft's low-poly silhouette and animation-friendly part hierarchy.
 */
public class WildAnimalModel<T extends Entity> extends EntityModel<T> {
    public enum Type { DEER, FOX, WOLF, BOAR }

    public static final ModelLayerLocation DEER_LAYER = layer("red_deer");
    public static final ModelLayerLocation FOX_LAYER = layer("red_fox");
    public static final ModelLayerLocation WOLF_LAYER = layer("gray_wolf");
    public static final ModelLayerLocation BOAR_LAYER = layer("wild_boar");

    private static ModelLayerLocation layer(String name) {
        return new ModelLayerLocation(new ResourceLocation(TheWild.MOD_ID, name), "main");
    }

    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leftFrontLeg, rightFrontLeg, leftBackLeg, rightBackLeg;
    private final ModelPart tail;
    private final ModelPart leftAntler, rightAntler, leftTusk, rightTusk;

    public WildAnimalModel(ModelPart root) {
        this.root = root;
        body = root.getChild("body");
        head = root.getChild("head");
        leftFrontLeg = root.getChild("left_front_leg");
        rightFrontLeg = root.getChild("right_front_leg");
        leftBackLeg = root.getChild("left_back_leg");
        rightBackLeg = root.getChild("right_back_leg");
        tail = root.getChild("tail");
        leftAntler = root.getChild("left_antler");
        rightAntler = root.getChild("right_antler");
        leftTusk = root.getChild("left_tusk");
        rightTusk = root.getChild("right_tusk");
    }

    public static LayerDefinition createBodyLayer(Type type) {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition r = mesh.getRoot();

        float bodyW, bodyH, bodyD, headW, headH, headD, legH, legW, legZ, bodyY, headY, headZ, tailD;
        switch (type) {
            case DEER -> {
                bodyW = 10; bodyH = 9; bodyD = 16; headW = 7; headH = 7; headD = 6;
                legH = 11; legW = 2.5F; legZ = 5.5F; bodyY = 10; headY = 1; headZ = -8; tailD = 4;
            }
            case FOX -> {
                bodyW = 8; bodyH = 8; bodyD = 15; headW = 6; headH = 6; headD = 6;
                legH = 10; legW = 2; legZ = 5; bodyY = 10; headY = 4; headZ = -8; tailD = 10;
            }
            case WOLF -> {
                bodyW = 9; bodyH = 9; bodyD = 16; headW = 7; headH = 7; headD = 7;
                legH = 10.5F; legW = 2.2F; legZ = 5.5F; bodyY = 10; headY = 4; headZ = -8; tailD = 10;
            }
            default -> {
                bodyW = 11; bodyH = 10; bodyD = 15; headW = 8; headH = 7; headD = 6;
                legH = 9; legW = 3; legZ = 5; bodyY = 10; headY = 5; headZ = -8; tailD = 5;
            }
        }

        r.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-bodyW / 2F, -bodyH / 2F, -bodyD / 2F, bodyW, bodyH, bodyD),
                PartPose.offset(0, bodyY, 1));

        r.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24)
                .addBox(-headW / 2F, -headH / 2F, -headD / 2F, headW, headH, headD)
                .texOffs(24, 24)
                .addBox(-headW / 3F, -0.5F, -headD / 2F - 3F, headW * 2F / 3F, 3F, 3F),
                PartPose.offset(0, headY, headZ));

        addLeg(r, "left_front_leg", -bodyW * 0.33F, bodyY + 1, -legZ, legW, legH, 40, 0);
        addLeg(r, "right_front_leg", bodyW * 0.33F, bodyY + 1, -legZ, legW, legH, 40, 0);
        addLeg(r, "left_back_leg", -bodyW * 0.33F, bodyY + 1, legZ, legW, legH, 40, 16);
        addLeg(r, "right_back_leg", bodyW * 0.33F, bodyY + 1, legZ, legW, legH, 40, 16);

        r.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 40)
                .addBox(-1.5F, -1.5F, 0, 3, 3, tailD),
                PartPose.offsetAndRotation(0, bodyY - 2, bodyD / 2F, 0.18F, 0, 0));

        PartDefinition leftAntler = r.addOrReplaceChild("left_antler", CubeListBuilder.create().texOffs(16, 40)
                .addBox(-0.7F, -7, -0.7F, 1.4F, 8, 1.4F),
                PartPose.offsetAndRotation(2.2F, headY - 2, headZ, -0.18F, 0, -0.06F));
        leftAntler.addOrReplaceChild("tine1", CubeListBuilder.create().texOffs(22, 40)
                .addBox(-0.5F, -4, -0.5F, 1, 4, 1), PartPose.offsetAndRotation(0, -6, 0, -0.7F, 0, 0));
        leftAntler.addOrReplaceChild("tine2", CubeListBuilder.create().texOffs(26, 40)
                .addBox(-0.5F, -3.5F, -0.5F, 1, 3.5F, 1), PartPose.offsetAndRotation(0, -8, 0, -0.8F, 0, 0));

        PartDefinition rightAntler = r.addOrReplaceChild("right_antler", CubeListBuilder.create().texOffs(16, 40)
                .addBox(-0.7F, -7, -0.7F, 1.4F, 8, 1.4F),
                PartPose.offsetAndRotation(-2.2F, headY - 2, headZ, -0.18F, 0, 0.06F));
        rightAntler.addOrReplaceChild("tine1", CubeListBuilder.create().texOffs(22, 40)
                .addBox(-0.5F, -4, -0.5F, 1, 4, 1), PartPose.offsetAndRotation(0, -6, 0, -0.7F, 0, 0));
        rightAntler.addOrReplaceChild("tine2", CubeListBuilder.create().texOffs(26, 40)
                .addBox(-0.5F, -3.5F, -0.5F, 1, 3.5F, 1), PartPose.offsetAndRotation(0, -8, 0, -0.8F, 0, 0));

        r.addOrReplaceChild("left_tusk", CubeListBuilder.create().texOffs(32, 40)
                .addBox(-0.6F, 0, -2, 1.2F, 3, 1.2F),
                PartPose.offsetAndRotation(2.5F, headY + 2, headZ - 3, -0.45F, 0, -0.12F));
        r.addOrReplaceChild("right_tusk", CubeListBuilder.create().texOffs(32, 40)
                .addBox(-0.6F, 0, -2, 1.2F, 3, 1.2F),
                PartPose.offsetAndRotation(-2.5F, headY + 2, headZ - 3, -0.45F, 0, 0.12F));

        return LayerDefinition.create(mesh, 64, 64);
    }

    private static void addLeg(PartDefinition root, String name, float x, float y, float z,
                               float width, float height, int u, int v) {
        root.addOrReplaceChild(name, CubeListBuilder.create().texOffs(u, v)
                .addBox(-width / 2F, 0, -width / 2F, width, height, width), PartPose.offset(x, y, z));
    }

    public void setType(Type type) {
        boolean deer = type == Type.DEER;
        boolean boar = type == Type.BOAR;
        leftAntler.visible = deer;
        rightAntler.visible = deer;
        leftTusk.visible = boar;
        rightTusk.visible = boar;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        float walk = limbSwing * 0.9F;
        leftFrontLeg.xRot = Mth.cos(walk) * 0.75F * limbSwingAmount;
        rightFrontLeg.xRot = Mth.cos(walk + Mth.PI) * 0.75F * limbSwingAmount;
        leftBackLeg.xRot = Mth.cos(walk + Mth.PI) * 0.65F * limbSwingAmount;
        rightBackLeg.xRot = Mth.cos(walk) * 0.65F * limbSwingAmount;
        head.yRot = netHeadYaw * Mth.DEG_TO_RAD * 0.65F;
        head.xRot = headPitch * Mth.DEG_TO_RAD * 0.55F;
        tail.yRot = Mth.sin(ageInTicks * 0.08F) * 0.2F;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        root.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
