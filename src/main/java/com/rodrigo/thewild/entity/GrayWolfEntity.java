package com.rodrigo.thewild.entity;

import com.rodrigo.thewild.registry.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public class GrayWolfEntity extends WildAnimalEntity {
    public GrayWolfEntity(EntityType<? extends Animal> type, Level level) {
        super(type, level, 25.0F, 60.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return createBaseAttributes()
                .add(Attributes.MAX_HEALTH, 26.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.30D)
                .add(Attributes.FOLLOW_RANGE, 36.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return ModEntities.GRAY_WOLF.get().create(level);
    }
}
