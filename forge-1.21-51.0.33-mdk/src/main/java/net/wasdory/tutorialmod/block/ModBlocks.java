package net.wasdory.tutorialmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wasdory.tutorialmod.Item.ModItems;
import net.wasdory.tutorialmod.TutorialMod;
import net.wasdory.tutorialmod.block.custom.ArcaneBlock;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> THAUMIUM_BLOCK = registryBlock("thaumium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength( 4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> VOID_METAL_BLOCK = registryBlock("void_metal_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength( 4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));


    public static final RegistryObject<Block> AMBER_ORE = registryBlock("amber_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength( 4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> DEEPSLATE_AMBER_ORE = registryBlock("deepslate_amber_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of()
                    .strength( 5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> ARCANE_BLOCK = registryBlock("arcane_block",
            () -> new ArcaneBlock(BlockBehaviour.Properties.of()
                    .strength( 2f).noLootTable().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> MAGIC_STONE = registryBlock("magic_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength( 3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<StairBlock> MAGIC_STONE_STAIRS = registryBlock("magic_stone_stairs",
            () -> new StairBlock(ModBlocks.MAGIC_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> MAGIC_STONE_SLAB = registryBlock("magic_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<PressurePlateBlock> MAGIC_STONE_PRESSURE_PLATE = registryBlock("magic_stone_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> MAGIC_STONE_BUTTON = registryBlock("magic_stone_button",
            () -> new ButtonBlock(BlockSetType.IRON, 5, BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<FenceBlock> MAGIC_STONE_FENCE = registryBlock("magic_stone_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> MAGIC_STONE_FENCE_GATE = registryBlock("magic_stone_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> MAGIC_STONE_WALL = registryBlock("magic_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> MAGIC_STONE_DOOR = registryBlock("magic_stone_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> MAGIC_STONE_TRAPDOOR = registryBlock("magic_stone_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));



    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}