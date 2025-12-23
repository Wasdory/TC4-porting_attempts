package net.wasdory.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.wasdory.tutorialmod.Item.ModItems;
import net.wasdory.tutorialmod.TutorialMod;
import net.wasdory.tutorialmod.block.ModBlocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> AMBER_SMELTABLES = List.of(ModBlocks.AMBER_ORE.get(), ModBlocks.DEEPSLATE_AMBER_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.THAUMIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.THAUMIUM.get())
                .unlockedBy(getHasName(ModItems.THAUMIUM.get()), has(ModItems.THAUMIUM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VOID_METAL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.VOID_METAL.get())
                .unlockedBy(getHasName(ModItems.VOID_METAL.get()), has(ModItems.VOID_METAL.get())).save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.VOID_METAL.get(), 9)
                .requires(ModBlocks.VOID_METAL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.VOID_METAL_BLOCK.get()), has(ModBlocks.VOID_METAL_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THAUMIUM.get(), 9)
                .requires(ModBlocks.THAUMIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.THAUMIUM_BLOCK.get()), has(ModBlocks.THAUMIUM_BLOCK.get())).save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THAUMIUM.get(), 64)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.THAUMIUM_BLOCK.get()), has(ModBlocks.THAUMIUM_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":thaumium_from_magic_block");


        oreSmelting(pRecipeOutput, AMBER_SMELTABLES, RecipeCategory.MISC, ModItems.AMBER.get(), 0.25f, 200, "amber");
        oreBlasting(pRecipeOutput, AMBER_SMELTABLES, RecipeCategory.MISC, ModItems.AMBER.get(), 0.25f, 100, "amber");

    }
        protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
        float pExperience, int pCookingTIme, String pGroup) {
            oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                    pExperience, pCookingTIme, pGroup, "_from_smelting");
        }

        protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
        float pExperience, int pCookingTime, String pGroup) {
            oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                    pExperience, pCookingTime, pGroup, "_from_blasting");
        }

        protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                           List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
            for(ItemLike itemlike : pIngredients) {
                SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                        .save(recipeOutput, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
            }
        }
    }