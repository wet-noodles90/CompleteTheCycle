package net.wetnoodles90.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.wetnoodles90.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICKS_ITEM, 4)
                        .pattern("DD")
                        .pattern("DD")
                        .input('D', Items.POLISHED_DIORITE)
                        .criterion(hasItem(Items.POLISHED_DIORITE), conditionsFromItem(Items.POLISHED_DIORITE))
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICKS_ITEM, Items.POLISHED_DIORITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICKS_ITEM, Items.DIORITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICK_SLAB_ITEM, Items.DIORITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DIORITE_ITEM, Items.DIORITE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICK_SLAB_ITEM, 6)
                        .pattern("BBB")
                        .input('B', ModBlocks.DIORITE_BRICKS_ITEM)
                        .criterion(hasItem(ModBlocks.DIORITE_BRICKS_ITEM), conditionsFromItem(ModBlocks.DIORITE_BRICKS_ITEM))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DIORITE_ITEM, 1)
                        .pattern("S")
                        .pattern("S")
                        .input('S', ModBlocks.DIORITE_BRICK_SLAB_ITEM)
                        .criterion(hasItem(ModBlocks.DIORITE_BRICK_SLAB_ITEM), conditionsFromItem(ModBlocks.DIORITE_BRICK_SLAB_ITEM))
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_PILLAR_ITEM, Items.DIORITE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_PILLAR_ITEM, 2)
                        .pattern("D")
                        .pattern("D")
                        .input('D', Items.DIORITE)
                        .criterion(hasItem(Items.DIORITE), conditionsFromItem(Items.DIORITE))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICKS_ITEM, 4)
                        .pattern("GG")
                        .pattern("GG")
                        .input('G', Items.POLISHED_GRANITE)
                        .criterion(hasItem(Items.POLISHED_GRANITE), conditionsFromItem(Items.POLISHED_GRANITE))
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICKS_ITEM, Items.POLISHED_GRANITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICKS_ITEM, Items.GRANITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICK_SLAB_ITEM, Items.GRANITE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICK_SLAB_ITEM, 6)
                        .pattern("BBB")
                        .input('B', ModBlocks.GRANITE_BRICKS_ITEM)
                        .criterion(hasItem(ModBlocks.GRANITE_BRICKS_ITEM), conditionsFromItem(ModBlocks.DIORITE_BRICKS_ITEM))
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GRANITE_ITEM, Items.GRANITE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GRANITE_ITEM, 1)
                        .pattern("S")
                        .pattern("S")
                        .input('S', ModBlocks.GRANITE_BRICK_SLAB_ITEM)
                        .criterion(hasItem(ModBlocks.GRANITE_BRICK_SLAB_ITEM), conditionsFromItem(ModBlocks.GRANITE_BRICK_SLAB_ITEM))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_PILLAR_ITEM, 2)
                        .pattern("G")
                        .pattern("G")
                        .input('G', Items.GRANITE)
                        .criterion(hasItem(Items.GRANITE), conditionsFromItem(Items.GRANITE))
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_PILLAR_ITEM, Items.GRANITE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_PILLAR_ITEM, 2)
                        .pattern("S")
                        .pattern("S")
                        .input('S', Items.STONE)
                        .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_PILLAR_ITEM, Items.STONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_PILLAR_ITEM, Items.DIORITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICK_STAIRS, Items.DIORITE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICK_STAIRS, 6)
                        .pattern("B  ")
                        .pattern("BB ")
                        .pattern("BBB")
                        .input('B', ModBlocks.DIORITE_BRICKS_ITEM)
                        .criterion(hasItem(ModBlocks.DIORITE_BRICKS_ITEM), conditionsFromItem(ModBlocks.DIORITE_BRICKS_ITEM))
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICK_STAIRS, Items.GRANITE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICK_STAIRS, 6)
                        .pattern("B  ")
                        .pattern("BB ")
                        .pattern("BBB")
                        .input('B', ModBlocks.GRANITE_BRICKS_ITEM)
                        .criterion(hasItem(ModBlocks.GRANITE_BRICKS_ITEM), conditionsFromItem(ModBlocks.GRANITE_BRICKS_ITEM))
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICKS, Items.ANDESITE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICKS, Items.POLISHED_ANDESITE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICKS, 4)
                        .pattern("AA")
                        .pattern("AA")
                        .input('A', Items.POLISHED_ANDESITE)
                        .criterion(hasItem(Items.POLISHED_ANDESITE), conditionsFromItem(Items.POLISHED_ANDESITE))
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICK_SLAB, Items.ANDESITE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICK_SLAB, 6)
                        .pattern("BBB")
                        .input('B', ModBlocks.ANDESITE_BRICKS)
                        .criterion(hasItem(ModBlocks.ANDESITE_BRICKS_ITEM), conditionsFromItem(ModBlocks.ANDESITE_BRICKS_ITEM))
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICK_STAIRS, Items.ANDESITE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICK_STAIRS, 6)
                        .pattern("B  ")
                        .pattern("BB ")
                        .pattern("BBB")
                        .input('B', ModBlocks.ANDESITE_BRICKS)
                        .criterion(hasItem(ModBlocks.ANDESITE_BRICKS_ITEM), conditionsFromItem(ModBlocks.ANDESITE_BRICKS_ITEM))
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ANDESITE, Items.ANDESITE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ANDESITE, 1)
                        .pattern("S")
                        .pattern("S")
                        .input('S', ModBlocks.ANDESITE_BRICK_SLAB)
                        .criterion(hasItem(ModBlocks.ANDESITE_BRICK_SLAB_ITEM), conditionsFromItem(ModBlocks.ANDESITE_BRICK_SLAB_ITEM))
                        .offerTo(recipeExporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TUFF_PILLAR, Items.TUFF);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TUFF_PILLAR, 2)
                        .pattern("T")
                        .pattern("T")
                        .input('T', Items.TUFF)
                        .criterion(hasItem(Items.TUFF), conditionsFromItem(Items.TUFF))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEEPSLATE_PILLAR, 2)
                        .pattern("D")
                        .pattern("D")
                        .input('D', Items.DEEPSLATE)
                        .criterion(hasItem(Items.DEEPSLATE), conditionsFromItem(Items.DEEPSLATE))
                        .offerTo(recipeExporter);
            }
        };
    }

    @Override
    public String getName() {
        return "CompleteTheCycleRecipe";
    }
}
