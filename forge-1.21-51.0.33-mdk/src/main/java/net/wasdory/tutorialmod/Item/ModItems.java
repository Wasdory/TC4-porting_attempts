package net.wasdory.tutorialmod.Item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wasdory.tutorialmod.Item.custom.ChiselItem;
import net.wasdory.tutorialmod.Item.custom.FuelItem;
import net.wasdory.tutorialmod.TutorialMod;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> THAUMIUM = ITEMS.register("thaumium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VOID_METAL = ITEMS.register("void_metal",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.void_metal"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });
    public static final RegistryObject<Item> AMBER = ITEMS.register("amber",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final RegistryObject<Item> ZOMBIE_BRAIN = ITEMS.register("zombie_brain",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ZOMBIE_BRAIN)));
    public static final RegistryObject<Item> ALUMENTUM = ITEMS.register( "alumentum",
            () -> new FuelItem(new Item.Properties(), 6400));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
