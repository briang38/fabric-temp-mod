package net.brian.tutorialmod.item;

import net.brian.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //This adds the items to the game, but they won't show up in the creative inventory until we add them to an item group using the ItemGroupEvents API.
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot", new Item(new Item.Settings()));
    public static final Item PLASTEEL_INGOT = registerItem("plasteel_ingot", new Item(new Item.Settings()));
    public static final Item RAW_TITANIUM = registerItem("raw_titanium", new Item(new Item.Settings()));
    public static final Item TITANIUM_NUGGET = registerItem("titanium_nugget", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        //ItemGroupEvents is used to add items to the creative inventory. Here we are adding our items to the Ingredients tab.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(TITANIUM_INGOT);
            entries.add(PLASTEEL_INGOT);
            entries.add(RAW_TITANIUM);
            entries.add(TITANIUM_NUGGET);
        });
    }

}
