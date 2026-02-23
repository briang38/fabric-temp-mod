package net.brian.tutorialmod.block;

import net.brian.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //This adds the blocks to the game, but they won't show up in the creative inventory until we add them to an item group using the ItemGroupEvents API.
    public static final Block PINK_GARENT_BLOCK = registerBlock("pink_garnet_block", 
            new Block(AbstractBlock.Settings.create().strength(4f)
                .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));


    public static final Block TITANIUM_BLOCK = registerBlock("titanium_block", 
            new Block(AbstractBlock.Settings.create().strength(3f)
                .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block RAW_TITANIUM_BLOCK = registerBlock("raw_titanium_block", 
            new Block(AbstractBlock.Settings.create().strength(3f)
                .requiresTool().sounds(BlockSoundGroup.NETHER_BRICKS)));

    public static final Block TITAINIUM_ORE = registerBlock("titanium_ore", 
            new Block(AbstractBlock.Settings.create().strength(3f)
                .requiresTool().sounds(BlockSoundGroup.STONE)));


    //This method registers the block and also creates a corresponding BlockItem so that the block can be placed in the world.
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
            new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PINK_GARENT_BLOCK);
            entries.add(TITANIUM_BLOCK);
            entries.add(RAW_TITANIUM_BLOCK);
            entries.add(TITAINIUM_ORE);
        });
    }
}
