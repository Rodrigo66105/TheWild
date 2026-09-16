package com.rodrigo.thewild.registry;

import com.rodrigo.thewild.TheWild;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheWild.MOD_ID);

    public static final RegistryObject<Item> RED_DEER_SPAWN_EGG = ITEMS.register("red_deer_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RED_DEER, 0x8A5A3C, 0xE6D2B5, new Item.Properties()));

    public static final RegistryObject<Item> WILD_BOAR_SPAWN_EGG = ITEMS.register("wild_boar_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WILD_BOAR, 0x5A4034, 0xC29A72, new Item.Properties()));

    public static final RegistryObject<Item> RED_FOX_SPAWN_EGG = ITEMS.register("red_fox_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RED_FOX, 0xB54A2A, 0xF0E0C0, new Item.Properties()));

    public static final RegistryObject<Item> GRAY_WOLF_SPAWN_EGG = ITEMS.register("gray_wolf_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GRAY_WOLF, 0x6A6A6A, 0xD8D8D8, new Item.Properties()));

    private ModItems() {}
}
