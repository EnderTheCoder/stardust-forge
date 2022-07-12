package stardust.stardust.registry;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import stardust.stardust.item.CannonBaseMedium;
import stardust.stardust.item.group.ModGroup;

import static stardust.stardust.Stardust.MODID;

public class ItemRegistry {
    //BlockItems
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> CANNON_BASE_MEDIUM = ITEMS.register("cannon_base_medium", CannonBaseMedium::new);
    public static final RegistryObject<Item> RAIL_GUN_4_MEDIUM = ITEMS.register("rail_gun_4_medium", () -> new BlockItem(BlockRegistry.RAIL_GUN_4_MEDIUM.get(), new Item.Properties().group(ModGroup.WEAPON_GROUP)));


    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
