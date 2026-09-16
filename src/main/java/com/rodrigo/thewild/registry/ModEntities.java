package com.rodrigo.thewild.registry;

import com.rodrigo.thewild.TheWild;
import com.rodrigo.thewild.entity.GrayWolfEntity;
import com.rodrigo.thewild.entity.RedDeerEntity;
import com.rodrigo.thewild.entity.RedFoxEntity;
import com.rodrigo.thewild.entity.WildBoarEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheWild.MOD_ID);

    public static final RegistryObject<EntityType<RedDeerEntity>> RED_DEER = ENTITIES.register("red_deer",
            () -> EntityType.Builder.of(RedDeerEntity::new, MobCategory.CREATURE)
                    .sized(1.0F, 1.65F).clientTrackingRange(10).build("red_deer"));

    public static final RegistryObject<EntityType<WildBoarEntity>> WILD_BOAR = ENTITIES.register("wild_boar",
            () -> EntityType.Builder.of(WildBoarEntity::new, MobCategory.CREATURE)
                    .sized(1.0F, 1.0F).clientTrackingRange(10).build("wild_boar"));

    public static final RegistryObject<EntityType<RedFoxEntity>> RED_FOX = ENTITIES.register("red_fox",
            () -> EntityType.Builder.of(RedFoxEntity::new, MobCategory.CREATURE)
                    .sized(0.9F, 0.9F).clientTrackingRange(10).build("red_fox"));

    public static final RegistryObject<EntityType<GrayWolfEntity>> GRAY_WOLF = ENTITIES.register("gray_wolf",
            () -> EntityType.Builder.of(GrayWolfEntity::new, MobCategory.CREATURE)
                    .sized(0.85F, 1.0F).clientTrackingRange(10).build("gray_wolf"));

    private ModEntities() {}
}
