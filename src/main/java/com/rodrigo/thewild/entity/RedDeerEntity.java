package com.rodrigo.thewild.entity;

import com.rodrigo.thewild.registry.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public class RedDeerEntity extends WildAnimalEntity {
    public RedDeerEntity(EntityType<? extends Animal> type, Level level) {
        super(type, level, 70.0F, 240.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return createBaseAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.30D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return ModEntities.RED_DEER.get().create(level);
    }
}
