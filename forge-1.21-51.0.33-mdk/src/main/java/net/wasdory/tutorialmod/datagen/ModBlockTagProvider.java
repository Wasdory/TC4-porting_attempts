package net.wasdory.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.wasdory.tutorialmod.TutorialMod;
import net.wasdory.tutorialmod.block.ModBlocks;
import net.wasdory.tutorialmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.THAUMIUM_BLOCK.get())
                .add(ModBlocks.VOID_METAL_BLOCK.get())
                .add(ModBlocks.AMBER_ORE.get())
                .add(ModBlocks.DEEPSLATE_AMBER_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.AMBER_ORE.get())
                .add(ModBlocks.DEEPSLATE_AMBER_ORE.get())
                .add(ModBlocks.THAUMIUM_BLOCK.get())
                .add(ModBlocks.VOID_METAL_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.get());

    }
}
