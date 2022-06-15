package stardust.stardust.registry;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import stardust.stardust.entity.CannonBaseMediumTileEntity;
import stardust.stardust.entity.RailGunWarheadEntity;

import static stardust.stardust.Stardust.MODID;

public class EntityTypeRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);

    public static RegistryObject<EntityType<RailGunWarheadEntity>> RAIL_GUN_WARHEAD_ENTITY = ENTITY_TYPE_DEFERRED_REGISTER.register(
            "rail_gun_warhead_entity",
            () -> EntityType.Builder.create(
                    (EntityType<RailGunWarheadEntity> entityType, World world) -> new RailGunWarheadEntity(entityType, world),
                    EntityClassification.MISC
            ).build("rail_gun_warhead_entity")
    );

    public static void registry() {
        ENTITY_TYPE_DEFERRED_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
