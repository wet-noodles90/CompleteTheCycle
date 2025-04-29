package net.wetnoodles90;

import net.fabricmc.api.ModInitializer;

import net.wetnoodles90.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompleteTheCycle implements ModInitializer {
	public static final String MOD_ID = "complete-the-cycle";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Running Complete The Cycle. . .");
		ModBlocks.registerModBlocks();
	}
}