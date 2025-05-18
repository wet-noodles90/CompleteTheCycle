package net.wetnoodles90.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wetnoodles90.CompleteTheCycle;
import net.wetnoodles90.enchantment.custom.DoubleJumpEnchantment;

public class ModEnchantmentEffects {

    public static final MapCodec<? extends EnchantmentEntityEffect> DOUBLE_JUMP = registerEntityEffect("doublejump", DoubleJumpEnchantment.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name, MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(CompleteTheCycle.MOD_ID, name), codec);
    }

    public static void registerModEnchantmentEffects() {
        CompleteTheCycle.LOGGER.info("Registering Enchantment Effects. . . ");
    }
}
