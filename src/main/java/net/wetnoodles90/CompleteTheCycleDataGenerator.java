package net.wetnoodles90;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.enchantment.effect.EnchantmentLocationBasedEffect;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.wetnoodles90.datagen.BlockModelProvider;
import net.wetnoodles90.datagen.ModDataRegistryProvider;
import net.wetnoodles90.datagen.RecipeProvider;
import net.wetnoodles90.enchantment.ModEnchantments;
import net.wetnoodles90.enchantment.custom.DoubleJumpEnchantment;

public class CompleteTheCycleDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(RecipeProvider::new);
		pack.addProvider(BlockModelProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
	}
}
