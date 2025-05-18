package net.wetnoodles90.enchantment;

import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.wetnoodles90.CompleteTheCycle;
import net.wetnoodles90.enchantment.custom.DoubleJumpEnchantment;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> DOUBLE_JUMP = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(CompleteTheCycle.MOD_ID, "double_jump"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, DOUBLE_JUMP, Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
                items.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
                5,
                5,
                Enchantment.leveledCost(5, 7),
                Enchantment.leveledCost(25, 9),
                2,
                AttributeModifierSlot.FEET))
                .addEffect(EnchantmentEffectComponentTypes.LOCATION_CHANGED, new DoubleJumpEnchantment()));
    }



    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}
