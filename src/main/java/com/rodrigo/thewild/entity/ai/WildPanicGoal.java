package com.rodrigo.thewild.entity.ai;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.PanicGoal;

/**
 * Panic behaviour tuned for TheWild animals.
 * If vanilla navigation keeps the animal pressed against an obstacle,
 * the animal jumps and forces a fresh path calculation.
 */
public class WildPanicGoal extends PanicGoal {
    private final PathfinderMob mob;
    private int recoveryCooldown;
    private int stuckTicks;
    private double lastX;
    private double lastZ;

    public WildPanicGoal(PathfinderMob mob, double speedModifier) {
        super(mob, speedModifier);
        this.mob = mob;
    }

    @Override
    public void start() {
        recoveryCooldown = 0;
        stuckTicks = 0;
        lastX = mob.getX();
        lastZ = mob.getZ();
        super.start();
    }

    @Override
    public void tick() {
        super.tick();

        if (recoveryCooldown > 0) {
            recoveryCooldown--;
        }

        double movedSqr = mob.distanceToSqr(lastX, mob.getY(), lastZ);
        if (movedSqr < 0.0025D) {
            stuckTicks++;
        } else {
            stuckTicks = 0;
        }

        lastX = mob.getX();
        lastZ = mob.getZ();

        // A horizontal collision is immediate evidence of an obstacle.
        // If movement remains almost zero for several ticks, treat it as
        // a failed route even when the collision flag is not raised.
        if (recoveryCooldown == 0 && mob.onGround()
                && (mob.horizontalCollision || stuckTicks >= 8)) {
            mob.getJumpControl().jump();
            mob.getNavigation().stop();
            mob.getNavigation().recomputePath();
            stuckTicks = 0;
            recoveryCooldown = 10;
        }
    }
}
