package net.arnec.huntersdelight.item;

import net.arnec.huntersdelight.HuntersDelightMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HuntersDelightMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> HUNTERSDELIGHT_ITEMS_TAB = CREATIVE_MODE_TAB.register("huntersdelight_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SALT.get()))
                    .title(Component.translatable("creativetab.huntersdelight_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SALT.get());
                        output.accept(ModItems.SALT_ORE.get());
                        output.accept(ModItems.HIDE.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
