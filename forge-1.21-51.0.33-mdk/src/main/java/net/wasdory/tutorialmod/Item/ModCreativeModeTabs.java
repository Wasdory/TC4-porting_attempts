package net.wasdory.tutorialmod.Item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.wasdory.tutorialmod.TutorialMod;
import net.wasdory.tutorialmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> THAUMCRAFT_ITEMS_TAB = CREATIVE_MODE_TABS.register("thaumcraft_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.THAUMIUM.get()))
                    .title(Component.translatable("creativetab.tutorialmod.thaumcraft_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.AMBER.get());
                        output.accept(ModItems.THAUMIUM.get());
                        output.accept(ModItems.VOID_METAL.get());

                        output.accept(ModItems.ZOMBIE_BRAIN.get());
                        output.accept(ModItems.ALUMENTUM.get());

                        output.accept(ModItems.CHISEL.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> THAUMCRAFT_BLOCKS_TAB = CREATIVE_MODE_TABS.register("thaumcraft_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.THAUMIUM_BLOCK.get()))
                    .withTabsBefore(THAUMCRAFT_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.tutorialmod.thaumcraft_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.THAUMIUM_BLOCK.get());
                        output.accept(ModBlocks.VOID_METAL_BLOCK.get());
                        output.accept(ModBlocks.MAGIC_STONE.get());

                        output.accept(ModBlocks.AMBER_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_AMBER_ORE.get());

                        output.accept(ModBlocks.ARCANE_BLOCK.get());


                        output.accept(ModBlocks.MAGIC_STONE_STAIRS.get());
                        output.accept(ModBlocks.MAGIC_STONE_SLAB.get());

                        output.accept(ModBlocks.MAGIC_STONE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.MAGIC_STONE_BUTTON.get());

                        output.accept(ModBlocks.MAGIC_STONE_FENCE.get());
                        output.accept(ModBlocks.MAGIC_STONE_FENCE_GATE.get());
                        output.accept(ModBlocks.MAGIC_STONE_WALL.get());

                        output.accept(ModBlocks.MAGIC_STONE_DOOR.get());
                        output.accept(ModBlocks.MAGIC_STONE_TRAPDOOR.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
