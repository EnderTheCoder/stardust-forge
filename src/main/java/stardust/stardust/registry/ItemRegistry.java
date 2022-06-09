package stardust.stardust.registry;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import stardust.stardust.item.group.ModGroup;

import static stardust.stardust.Stardust.MODID;

public class ItemRegistry {
    //BlockItems
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> kineticCannon1Large = ITEMS.register("kinetic_cannon_1_large", () -> new BlockItem(BlockRegistry.kineticCannon1Large.get(), new Item.Properties().group(ModGroup.itemGroup)));

    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
