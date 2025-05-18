package net.wetnoodles90;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.wetnoodles90.block.ModBlocks;
import net.wetnoodles90.block.ModFluids;
import net.wetnoodles90.enchantment.ModEnchantmentEffects;
import net.wetnoodles90.entity.ModEntities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompleteTheCycle implements ModInitializer {
	public static final String MOD_ID = "complete-the-cycle";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier ofCTC(String id) {
		return Identifier.of(MOD_ID, id);
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Running Complete The Cycle. . .");
		ModFluids.registerModFluids();
		ModBlocks.registerModBlocks();
		ModEnchantmentEffects.registerModEnchantmentEffects();

		ModEntities.registerModEntities();
	}
}