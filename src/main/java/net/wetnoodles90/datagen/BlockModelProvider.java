package net.wetnoodles90.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.PillarBlock;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.wetnoodles90.block.ModBlocks;
import net.wetnoodles90.block.custom.PlacerBlock;

public class BlockModelProvider extends FabricModelProvider {
    public BlockModelProvider(FabricDataOutput output) {
        super(output);
    }

    public static final TexturedModel.Factory ORIENTABLE_VERTICAL = TexturedModel.makeFactory(TextureMap::sideFrontTop, Models.ORIENTABLE_VERTICAL);

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        createPillarModel(ModBlocks.GRANITE_PILLAR, blockStateModelGenerator);
        createPillarModel(ModBlocks.STONE_PILLAR, blockStateModelGenerator);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DIORITE_BRICKS)
                .stairs(ModBlocks.DIORITE_BRICK_STAIRS);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRANITE_BRICKS)
                .stairs(ModBlocks.GRANITE_BRICK_STAIRS);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ANDESITE_BRICKS)
                .slab(ModBlocks.ANDESITE_BRICK_SLAB)
                .stairs(ModBlocks.ANDESITE_BRICK_STAIRS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_ANDESITE);

        createPillarModel(ModBlocks.ANDESITE_PILLAR, blockStateModelGenerator);
        createPillarModel(ModBlocks.TUFF_PILLAR, blockStateModelGenerator);
        createPillarModel(ModBlocks.DEEPSLATE_PILLAR, blockStateModelGenerator);

        blockStateModelGenerator.registerSingleton(ModBlocks.ANTI_CRAFTING_TABLE, TexturedModel.CUBE_BOTTOM_TOP);

        createOrientableModel(ModBlocks.PLACER, blockStateModelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }

    private static void createPillarModel(Block block, BlockStateModelGenerator blockStateModelGenerator) {
        final Identifier pillar = TexturedModel.CUBE_COLUMN.upload(block, blockStateModelGenerator.modelCollector);
        final Identifier pillarHorizontal = TexturedModel.CUBE_COLUMN_HORIZONTAL.upload(block, blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockModelDefinitionCreator.of(block)
                        .with(BlockStateVariantMap.models(PillarBlock.AXIS)
                                .register(Direction.Axis.X, BlockStateModelGenerator.createWeightedVariant(pillarHorizontal).apply(BlockStateModelGenerator.ROTATE_X_90.then(BlockStateModelGenerator.ROTATE_Y_90)))
                                .register(Direction.Axis.Y, BlockStateModelGenerator.createWeightedVariant(pillar))
                                .register(Direction.Axis.Z, BlockStateModelGenerator.createWeightedVariant(pillarHorizontal).apply(BlockStateModelGenerator.ROTATE_X_90))));

        blockStateModelGenerator.registerParentedItemModel(block, pillar);
    }

    private static void createOrientableModel(Block block, BlockStateModelGenerator blockStateModelGenerator) {
        final Identifier orientable = TexturedModel.ORIENTABLE.upload(block, blockStateModelGenerator.modelCollector);
        final Identifier orientableVertical = ORIENTABLE_VERTICAL.upload(block, blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockModelDefinitionCreator.of(block)
                        .with(BlockStateVariantMap.models(PlacerBlock.FACING)
                                .register(Direction.UP, BlockStateModelGenerator.createWeightedVariant(orientableVertical))
                                .register(Direction.DOWN, BlockStateModelGenerator.createWeightedVariant(orientableVertical).apply(BlockStateModelGenerator.ROTATE_X_180))
                                .register(Direction.NORTH, BlockStateModelGenerator.createWeightedVariant(orientable))
                                .register(Direction.EAST, BlockStateModelGenerator.createWeightedVariant(orientable).apply(BlockStateModelGenerator.ROTATE_X_90))
                                .register(Direction.WEST, BlockStateModelGenerator.createWeightedVariant(orientable).apply(BlockStateModelGenerator.ROTATE_X_270))
                                .register(Direction.SOUTH, BlockStateModelGenerator.createWeightedVariant(orientable).apply(BlockStateModelGenerator.ROTATE_X_180))
        ));

        blockStateModelGenerator.registerParentedItemModel(block, orientable);
    }

}
