package net.wasdory.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.wasdory.tutorialmod.Item.ModItems;
import net.wasdory.tutorialmod.TutorialMod;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.AMBER.get());
        basicItem(ModItems.VOID_METAL.get());
        basicItem(ModItems.THAUMIUM.get());

        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.ZOMBIE_BRAIN.get());
        basicItem(ModItems.ALUMENTUM.get());

    }
}