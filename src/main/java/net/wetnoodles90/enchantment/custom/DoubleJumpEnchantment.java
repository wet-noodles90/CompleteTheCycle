package net.wetnoodles90.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.wetnoodles90.CompleteTheCycleClient;

public record DoubleJumpEnchantment() implements EnchantmentEntityEffect {
    public static final MapCodec<DoubleJumpEnchantment> CODEC = MapCodec.unit(DoubleJumpEnchantment::new);
    private static int jumpCount = 0;

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (CompleteTheCycleClient.client.player == null || CompleteTheCycleClient.client.options.jumpKey == null) return;

        // Reset when on ground
        if (CompleteTheCycleClient.client.player.isOnGround()) {
            jumpCount = 0;
        }

        // On jump key press
        if (CompleteTheCycleClient.client.options.jumpKey.wasPressed()) {
            if (!CompleteTheCycleClient.client.player.isOnGround()) {
                if (level > 0) {
                    int used = jumpCount;
                    if (used < level) {
                        // consume one
                        jumpCount = used + 1;
                        // give a little boost
                        CompleteTheCycleClient.client.player.addVelocity(0, 0.6, 0);
                    }
                }
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
