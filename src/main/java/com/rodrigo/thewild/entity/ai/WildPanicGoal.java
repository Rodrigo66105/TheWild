package com.rodrigo.thewild.entity.ai;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.PanicGoal;

/** Panic behavior tuned for TheWild animals. */
public class WildPanicGoal extends PanicGoal {
    private final Mob mob;
    private int recoveryCooldown;

    public WildPanicGoal(Mob mob, double speedModifier) {
        super(mob, speedModifier);
        this.mob = mob;
    }

    @Override
    public void start() {
        recoveryCooldown = 0;
        super.start();
    }

    @Override
    public void tick() {
        super.tick();

        if (recoveryCooldown > 0) {
            recoveryCooldown--;
        }

        if (recoveryCooldown == 0 && mob.onGround()
                && (mob.horizontalCollision || mob.getNavigation().isStuck())) {
            mob.getJumpControl().jump();
            mob.getNavigation().recomputePath();
            recoveryCooldown = 8;
        }
    }
}
