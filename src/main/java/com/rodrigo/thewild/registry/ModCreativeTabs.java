package com.rodrigo.thewild.registry;

import com.rodrigo.thewild.TheWild;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheWild.MOD_ID);

    public static final RegistryObject<CreativeModeTab> THEWILD_TAB = TABS.register("thewild",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.thewild"))
                    .icon(() -> new ItemStack(ModItems.RED_DEER_SPAWN_EGG.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.RED_DEER_SPAWN_EGG.get());
                        output.accept(ModItems.WILD_BOAR_SPAWN_EGG.get());
                        output.accept(ModItems.RED_FOX_SPAWN_EGG.get());
                        output.accept(ModItems.GRAY_WOLF_SPAWN_EGG.get());
                    })
                    .build());

    private ModCreativeTabs() {}
}
