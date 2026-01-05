package net.wasdory.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wasdory.tutorialmod.TutorialMod;
import net.wasdory.tutorialmod.block.ModBlocks;
import net.wasdory.tutorialmod.block.custom.ThaumiumLambBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.THAUMIUM_BLOCK);
        blockWithItem(ModBlocks.VOID_METAL_BLOCK);
        blockWithItem(ModBlocks.MAGIC_STONE);

        blockWithItem(ModBlocks.AMBER_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_AMBER_ORE);

        blockWithItem(ModBlocks.ARCANE_BLOCK);

        stairsBlock(ModBlocks.MAGIC_STONE_STAIRS.get(), blockTexture(ModBlocks.MAGIC_STONE.get()));
        slabBlock(ModBlocks.MAGIC_STONE_SLAB.get(), blockTexture(ModBlocks.MAGIC_STONE.get()), blockTexture(ModBlocks.MAGIC_STONE.get()));

        buttonBlock(ModBlocks.MAGIC_STONE_BUTTON.get(), blockTexture(ModBlocks.MAGIC_STONE.get()));
        pressurePlateBlock(ModBlocks.MAGIC_STONE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MAGIC_STONE.get()));

        fenceBlock(ModBlocks.MAGIC_STONE_FENCE.get(), blockTexture(ModBlocks.MAGIC_STONE.get()));
        fenceGateBlock(ModBlocks.MAGIC_STONE_FENCE_GATE.get(), blockTexture(ModBlocks.MAGIC_STONE.get()));
        wallBlock(ModBlocks.MAGIC_STONE_WALL.get(), blockTexture(ModBlocks.MAGIC_STONE.get()));

        doorBlockWithRenderType(ModBlocks.MAGIC_STONE_DOOR.get(), modLoc("block/magic_stone_door_bottom"), modLoc("block/magic_stone_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.MAGIC_STONE_TRAPDOOR.get(), modLoc("block/magic_stone_trapdoor_bottom"), true, "cutout");

        blockItem(ModBlocks.MAGIC_STONE_STAIRS);
        blockItem(ModBlocks.MAGIC_STONE_SLAB);
        blockItem(ModBlocks.MAGIC_STONE_PRESSURE_PLATE);
        blockItem(ModBlocks.MAGIC_STONE_FENCE_GATE);
        blockItem(ModBlocks.MAGIC_STONE_TRAPDOOR, "_bottom");

        customLampBlock();
    }



    private void customLampBlock() {
    getVariantBuilder(ModBlocks.THAUMIUM_LAMP_BLOCK.get()).forAllStates(state -> {
        if(state.getValue(ThaumiumLambBlock.CLICKED)) {
            return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("thaumium_lamp_block_on",
                    ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "thaumium_lamp_block_on")))};
        } else {
            return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("thaumium_lamp_block_off",
                    ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,  "block/" + "thaumium_lamp_block_off")))};
        }
    });
    simpleBlockItem(ModBlocks.THAUMIUM_LAMP_BLOCK.get(), models().cubeAll("thaumium_lamp_block_on",
            ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "thaumium_lamp_block_on")));
}


private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
