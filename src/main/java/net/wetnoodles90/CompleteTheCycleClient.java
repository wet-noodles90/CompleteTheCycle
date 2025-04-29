package net.wetnoodles90;

import net.fabricmc.api.ClientModInitializer;

public class CompleteTheCycleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CompleteTheCycle.LOGGER.info("Running Complete The Cycle Client");
    }
}
