package com.rodrigo.thewild.entity;

import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.concurrent.ThreadLocalRandom;

public abstract class WildAnimalEntity extends Animal {
    private final float minWeight;
    private final float maxWeight;
    private float weightKg;
    private float bodyScale;

    protected WildAnimalEntity(EntityType<? extends Animal> type, Level level, float minWeight, float maxWeight) {
        super(type, level);
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        randomizeIndividual();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.6D));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 12.0F, 1.25D, 1.7D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    protected final void randomizeIndividual() {
        this.weightKg = minWeight + this.random.nextFloat() * (maxWeight - minWeight);
        this.bodyScale = 0.90F + this.random.nextFloat() * 0.20F;
    }

    public float getWeightKg() {
        return weightKg;
    }

    public float getBodyScale() {
        return bodyScale;
    }

    public static AttributeSupplier.Builder createBaseAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 24.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.0D);
    }

    @Override
    public boolean isFood(net.minecraft.world.item.ItemStack stack) {
        return false;
    }

    @Override
    public AgeableMob getBreedOffspring(net.minecraft.server.level.ServerLevel level, AgeableMob otherParent) {
        return null;
    }
}
