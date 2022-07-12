package stardust.stardust.registry;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import stardust.stardust.entity.AbstractCannonMediumTileEntity;
import stardust.stardust.entity.CannonBaseMediumTileEntity;

import static stardust.stardust.Stardust.MODID;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);

    public static RegistryObject<TileEntityType<CannonBaseMediumTileEntity>> CANNON_BASE_MEDIUM_TILE_ENTITY = TILE_ENTITY_TYPE_DEFERRED_REGISTER.register("cannon_base_medium_tile_entity", () -> TileEntityType.Builder.create(CannonBaseMediumTileEntity::new, BlockRegistry.CANNON_BASE_MEDIUM.get()).build(null));
    public static RegistryObject<TileEntityType<AbstractCannonMediumTileEntity>> RAIL_GUN_4_MEDIUM_TILE_ENTITY = TILE_ENTITY_TYPE_DEFERRED_REGISTER.register("rail_gun_4_medium_tile_entity", () -> TileEntityType.Builder.create(AbstractCannonMediumTileEntity::new, BlockRegistry.RAIL_GUN_4_MEDIUM.get()).build(null));

    public static void registry() {
        TILE_ENTITY_TYPE_DEFERRED_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
