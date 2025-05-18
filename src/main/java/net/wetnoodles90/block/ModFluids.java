package net.wetnoodles90.block;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.wetnoodles90.CompleteTheCycle;
import net.wetnoodles90.block.custom.MilkFluid;

public class ModFluids {

    public static final FlowableFluid FLOWING_MILK = (FlowableFluid) register("flowing_milk", new MilkFluid.Flowing());
    public static final FlowableFluid MILK = (FlowableFluid) register("milk", new MilkFluid.Still());

    private static <T extends Fluid> T register(String id, T value) {
        return Registry.register(Registries.FLUID, id, value);
    }

    static {
        for (Fluid fluid : Registries.FLUID) {
            for (FluidState fluidState : fluid.getStateManager().getStates()) {
                Fluid.STATE_IDS.add(fluidState);
            }
        }
    }

    public static void registerModFluids() {
        CompleteTheCycle.LOGGER.info("Registering Fluids for. . . " + CompleteTheCycle.MOD_ID);
    }
}
