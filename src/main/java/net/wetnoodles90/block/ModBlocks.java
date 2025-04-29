package net.wetnoodles90.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.wetnoodles90.CompleteTheCycle;

public class ModBlocks {

    public static final Block DIORITE_BRICKS = registerBlock("diorite_bricks", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CompleteTheCycle.MOD_ID, "diorite_bricks")))));



    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CompleteTheCycle.MOD_ID, name)), new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CompleteTheCycle.MOD_ID, name)))));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CompleteTheCycle.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        CompleteTheCycle.LOGGER.info("Registering Blocks for " + CompleteTheCycle.MOD_ID);
    }
}
