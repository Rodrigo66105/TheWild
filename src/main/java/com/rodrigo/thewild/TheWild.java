package com.rodrigo.thewild;

import com.rodrigo.thewild.registry.ModCreativeTabs;
import com.rodrigo.thewild.registry.ModEntities;
import com.rodrigo.thewild.registry.ModItems;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(TheWild.MOD_ID)
public class TheWild {
    public static final String MOD_ID = "thewild";

    public TheWild() {
        var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntities.ENTITIES.register(modBus);
        ModItems.ITEMS.register(modBus);
        ModCreativeTabs.TABS.register(modBus);
        modBus.addListener(this::commonSetup);
        modBus.addListener(this::createAttributes);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntities.RED_DEER.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ModEntities.WILD_BOAR.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ModEntities.RED_FOX.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ModEntities.GRAY_WOLF.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        });
    }

    private void createAttributes(final EntityAttributeCreationEvent event) {
        event.put(ModEntities.RED_DEER.get(), com.rodrigo.thewild.entity.RedDeerEntity.createAttributes().build());
        event.put(ModEntities.WILD_BOAR.get(), com.rodrigo.thewild.entity.WildBoarEntity.createAttributes().build());
        event.put(ModEntities.RED_FOX.get(), com.rodrigo.thewild.entity.RedFoxEntity.createAttributes().build());
        event.put(ModEntities.GRAY_WOLF.get(), com.rodrigo.thewild.entity.GrayWolfEntity.createAttributes().build());
    }
}
