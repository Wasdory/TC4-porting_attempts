package net.wasdory.tutorialmod.Item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties ZOMBIE_BRAIN = new FoodProperties.Builder().nutrition(4).saturationModifier(0.2f)
            .effect(new MobEffectInstance(MobEffects.HUNGER, 600), 0.8f).build();


}
