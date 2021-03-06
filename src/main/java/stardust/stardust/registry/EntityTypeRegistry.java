package stardust.stardust.registry;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import stardust.stardust.entity.CarrierDemoEntity;
import stardust.stardust.entity.projectile.HEProjectileEntity;
import stardust.stardust.entity.projectile.RailGunProjectileEntity;

import static stardust.stardust.Stardust.MODID;

public class EntityTypeRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);

    public static RegistryObject<EntityType<RailGunProjectileEntity>> RAIL_GUN_PROJECTILE_ENTITY = ENTITY_TYPE_DEFERRED_REGISTER.register(
            "rail_gun_projectile_entity",
            () -> EntityType.Builder.create(
                    (EntityType<RailGunProjectileEntity> entityType, World world) -> new RailGunProjectileEntity(entityType, world),
                    EntityClassification.MISC
            ).build("rail_gun_projectile_entity")
    );

    public static RegistryObject<EntityType<CarrierDemoEntity>> CARRIER_DEMO_ENTITY = ENTITY_TYPE_DEFERRED_REGISTER.register(
            "carrier_demo_entity",
            () -> EntityType.Builder.create(
                    (EntityType<CarrierDemoEntity> entityType, World world) -> new CarrierDemoEntity(entityType, world),
                    EntityClassification.MISC
            ).build("carrier_demo_entity")
    );

    public static RegistryObject<EntityType<HEProjectileEntity>> HE_PROJECTILE_ENTITY = ENTITY_TYPE_DEFERRED_REGISTER.register(
            "he_projectile_entity",
            () -> EntityType.Builder.create(
                    HEProjectileEntity::new,
                    EntityClassification.MISC
            ).build("he_projectile_entity")
    );

    public static void registry() {
        ENTITY_TYPE_DEFERRED_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
