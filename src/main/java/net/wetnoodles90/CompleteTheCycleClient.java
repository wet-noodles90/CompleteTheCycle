package net.wetnoodles90;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import net.wetnoodles90.block.ModFluids;

public class CompleteTheCycleClient implements ClientModInitializer {

    public static MinecraftClient client = MinecraftClient.getInstance();
    public static final boolean[] currentWgenValue = {true};
    @Override
    public void onInitializeClient() {
        CompleteTheCycle.LOGGER.info("Running Complete The Cycle Client");

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.MILK, ModFluids.FLOWING_MILK, new SimpleFluidRenderHandler(
                Identifier.ofVanilla("block/water_still"),
                Identifier.ofVanilla("block/water_flow"),
                0xFFFFFFFF
        ));
    }
}
