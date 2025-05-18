package net.wetnoodles90.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.wetnoodles90.CompleteTheCycle;
import net.wetnoodles90.block.custom.AntiCraftingTableBlock;
import net.wetnoodles90.block.custom.PlacerBlockEntity;

import java.util.function.Function;

import static net.wetnoodles90.CompleteTheCycle.ofCTC;

public class ModBlocks {

    public static final Block DIORITE_BRICKS = registerBlock("diorite_bricks", AbstractBlock.Settings.create().requiresTool().strength(1.5f, 6.0f));
    public static final Item DIORITE_BRICKS_ITEM = registerBlockItem("diorite_bricks", DIORITE_BRICKS);

    public static final Block CHISELED_DIORITE = registerBlock("chiseled_diorite", AbstractBlock.Settings.create());
    public static final Item CHISELED_DIORITE_ITEM = registerBlockItem("chiseled_diorite", CHISELED_DIORITE);

    public static final Block DIORITE_BRICK_SLAB = registerBlock("diorite_brick_slab", SlabBlock::new, AbstractBlock.Settings.create().requiresTool().strength(1.5f, 6.0f));
    public static final Item DIORITE_BRICK_SLAB_ITEM = registerBlockItem("diorite_brick_slab", DIORITE_BRICK_SLAB);

    public static final Block DIORITE_PILLAR = registerBlock("diorite_pillar", PillarBlock::new, AbstractBlock.Settings.create().requiresTool().strength(1.5f, 6.0f));
    public static final Item DIORITE_PILLAR_ITEM = registerBlockItem("diorite_pillar", DIORITE_PILLAR);

    public static final Block GRANITE_BRICKS = registerBlock("granite_bricks", AbstractBlock.Settings.create().requiresTool().strength(1.5f, 6.0f));
    public static final Item GRANITE_BRICKS_ITEM = registerBlockItem("granite_bricks", GRANITE_BRICKS);

    public static final Block GRANITE_BRICK_SLAB = registerBlock("granite_brick_slab", SlabBlock::new, AbstractBlock.Settings.create().requiresTool().strength(1.5f, 6.0f));
    public static final Item GRANITE_BRICK_SLAB_ITEM = registerBlockItem("granite_brick_slab", GRANITE_BRICK_SLAB);

    public static final Block CHISELED_GRANITE = registerBlock("chiseled_granite", AbstractBlock.Settings.create().requiresTool().strength(1.5f, 6.0f));
    public static final Item CHISELED_GRANITE_ITEM = registerBlockItem("chiseled_granite", CHISELED_GRANITE);

    public static final Block GRANITE_PILLAR = registerBlock("granite_pillar", PillarBlock::new, AbstractBlock.Settings.create().requiresTool().strength(1.5f, 6.0f));
    public static final Item GRANITE_PILLAR_ITEM = registerBlockItem("granite_pillar", GRANITE_PILLAR);

    public static final Block STONE_PILLAR = registerBlock("stone_pillar", PillarBlock::new, AbstractBlock.Settings.create().requiresTool().strength(1.5f, 6.0f));
    public static final Item STONE_PILLAR_ITEM = registerBlockItem("stone_pillar", STONE_PILLAR);

    public static final Block DIORITE_BRICK_STAIRS = registerStairsBlock("diorite_brick_stairs", DIORITE_BRICKS);
    public static final Item DIORITE_BRICK_STAIRS_ITEM = registerBlockItem("diorite_brick_stairs", DIORITE_BRICK_STAIRS);

    public static final Block GRANITE_BRICK_STAIRS = registerStairsBlock("granite_brick_stairs", GRANITE_BRICKS);
    public static final Item GRANITE_BRICK_STAIRS_ITEM = registerBlockItem("granite_brick_stairs", GRANITE_BRICK_STAIRS);

    public static final Block ANDESITE_BRICKS = registerBlock("andesite_bricks", AbstractBlock.Settings.create().requiresTool().strength(1.5f, 6.0f));
    public static final Item ANDESITE_BRICKS_ITEM = registerBlockItem("andesite_bricks", ANDESITE_BRICKS);

    public static final Block ANDESITE_BRICK_SLAB = registerBlock("andesite_brick_slab", SlabBlock::new, AbstractBlock.Settings.create().requiresTool().strength(1.5f, 6.0f));
    public static final Item ANDESITE_BRICK_SLAB_ITEM = registerBlockItem("andesite_brick_slab", ANDESITE_BRICK_SLAB);

    public static final Block ANDESITE_BRICK_STAIRS = registerStairsBlock("andesite_brick_stairs", ANDESITE_BRICKS);
    public static final Item ANDESITE_BRICK_STAIRS_ITEM = registerBlockItem("andesite_brick_stairs", ANDESITE_BRICK_STAIRS);

    public static final Block CHISELED_ANDESITE = registerBlock("chiseled_andesite", AbstractBlock.Settings.create().requiresTool().strength(1.5f, 6.0f));
    public static final Item CHISELED_ANDESITE_ITEM = registerBlockItem("chiseled_andesite", CHISELED_ANDESITE);

    public static final Block ANDESITE_PILLAR = registerBlock("andesite_pillar", PillarBlock::new, AbstractBlock.Settings.create().requiresTool().strength(1.5f, 6.0f));
    public static final Item ANDESITE_PILLAR_ITEM = registerBlockItem("andesite_pillar", ANDESITE_PILLAR);

    public static final Block TUFF_PILLAR = registerBlock("tuff_pillar", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Item TUFF_PILLAR_ITEM = registerBlockItem("tuff_pillar", TUFF_PILLAR);

    public static final Block DEEPSLATE_PILLAR = registerBlock("deepslate_pillar", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.DEEPSLATE));
    public static final Item DEEPSLATE_PILLAR_ITEM = registerBlockItem("deepslate_pillar", DEEPSLATE_PILLAR);

    public static final Block ANTI_CRAFTING_TABLE = registerBlock("anti_crafting_table", AntiCraftingTableBlock::new, AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE));
    public static final Item ANTI_CRAFTING_TABLE_ITEM = registerBlockItem("anti_crafting_table", ANTI_CRAFTING_TABLE);

    public static final Block MILK = registerFluidBlock("milk", ModFluids.FLOWING_MILK, AbstractBlock.Settings.copy(Blocks.WATER).mapColor(DyeColor.WHITE));

    public static final Block PLACER = registerBlock("placer", PillarBlock::new, AbstractBlock.Settings.copy(Blocks.DISPENSER));
    public static final Item PLACER_ITEM = registerBlockItem("placer", PLACER);
    public static final BlockEntityType<PlacerBlockEntity> PLACER_BLOCK_ENTITY = registerBlockEntity("placer", PlacerBlockEntity::new, PLACER);



    private static RegistryKey<Item> ofKeyItem(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, ofCTC(id));
    }

    private static RegistryKey<Block> ofKey(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, ofCTC(id));
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, ofKeyItem(name), new BlockItem(block, new Item.Settings().registryKey(ofKeyItem(name))));
    }

    private static void addBlocksToBuilding(FabricItemGroupEntries entries) {
        entries.add(DIORITE_BRICKS_ITEM);
        entries.add(DIORITE_BRICK_SLAB_ITEM);
        entries.add(DIORITE_BRICK_STAIRS_ITEM);
        entries.add(CHISELED_DIORITE_ITEM);
        entries.add(DIORITE_PILLAR_ITEM);
        entries.add(GRANITE_BRICKS_ITEM);
        entries.add(GRANITE_BRICK_SLAB_ITEM);
        entries.add(GRANITE_BRICK_STAIRS_ITEM);
        entries.add(CHISELED_GRANITE_ITEM);
        entries.add(GRANITE_PILLAR_ITEM);
        entries.add(ANDESITE_BRICKS_ITEM);
        entries.add(ANDESITE_BRICK_SLAB_ITEM);
        entries.add(ANDESITE_BRICK_STAIRS_ITEM);
        entries.add(CHISELED_ANDESITE_ITEM);
        entries.add(ANDESITE_PILLAR_ITEM);
        entries.add(STONE_PILLAR_ITEM);
        entries.add(TUFF_PILLAR_ITEM);
        entries.add(DEEPSLATE_PILLAR_ITEM);
        entries.add(PLACER_ITEM);
    }

    private static Block registerBlock(String name, AbstractBlock.Settings settings) {
        return registerBlock(name, Block::new, settings);
    }

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = factory.apply(settings.registryKey(ofKey(name)));
        return Registry.register(Registries.BLOCK, ofKey(name), block);
    }

    private static Block registerStairsBlock(String name, Block base) {
        return registerBlock(name, (settings) -> new StairsBlock(base.getDefaultState(), settings), AbstractBlock.Settings.copy(base));
    }

    private static Block registerFluidBlock(String name, FlowableFluid fluid, AbstractBlock.Settings settings) {
        return registerBlock(name, (settings1) -> {
            return new FluidBlock(fluid, settings1);
        }, settings);
    }

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {
        Identifier id = CompleteTheCycle.ofCTC(name);
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    public static void registerModBlocks() {
        CompleteTheCycle.LOGGER.info("Registering Blocks for " + CompleteTheCycle.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addBlocksToBuilding);
    }
}
