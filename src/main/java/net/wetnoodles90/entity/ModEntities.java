package net.wetnoodles90.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.wetnoodles90.CompleteTheCycle;
import net.wetnoodles90.entity.custom.MoobloomEntity;

public class ModEntities {

    private static RegistryKey<EntityType<?>> ofKey(String name) {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE, CompleteTheCycle.ofCTC(name));
    }

    public static final EntityType<MoobloomEntity> MOOBLOOM = Registry.register(Registries.ENTITY_TYPE, CompleteTheCycle.ofCTC("moobloom"), EntityType.Builder.create(MoobloomEntity::new, SpawnGroup.CREATURE).dimensions(1f, 2.5f).build(ofKey("moobloom")));

    public static void registerModEntities() {
        CompleteTheCycle.LOGGER.info("Registering Mod Entities for " + CompleteTheCycle.MOD_ID);
    }
}
