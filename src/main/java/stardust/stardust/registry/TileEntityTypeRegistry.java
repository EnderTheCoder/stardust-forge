package stardust.stardust.registry;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import stardust.stardust.entity.KineticCannon1MediumTileEntity;

import static stardust.stardust.Stardust.MODID;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);

    public static RegistryObject<TileEntityType<KineticCannon1MediumTileEntity>> KINETIC_CANNON_1_MEDIUM_TILE_ENTITY = TILE_ENTITY_TYPE_DEFERRED_REGISTER.register(
            "kinetic_cannon_1_medium_tile_entity",
            () -> TileEntityType.Builder.create(KineticCannon1MediumTileEntity::new,
                    BlockRegistry.KINETIC_CANNON_1_MEDIUM.get()).build(null)
    );


    public static void registry() {
        TILE_ENTITY_TYPE_DEFERRED_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
