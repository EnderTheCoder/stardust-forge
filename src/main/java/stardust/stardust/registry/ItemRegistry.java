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

    public static final RegistryObject<Item> CANNON_BASE_MEDIUM = ITEMS.register("cannon_base_medium", () -> new BlockItem(BlockRegistry.CANNON_BASE_MEDIUM.get(), new Item.Properties().group(ModGroup.itemGroup)));
    public static final RegistryObject<Item> KINETIC_CANNON_1_MEDIUM = ITEMS.register("kinetic_cannon_1_medium", () -> new BlockItem(BlockRegistry.KINETIC_CANNON_1_MEDIUM.get(), new Item.Properties().group(ModGroup.itemGroup)));
    public static final RegistryObject<Item> KINETIC_CANNON_2_MEDIUM = ITEMS.register("kinetic_cannon_2_medium", () -> new BlockItem(BlockRegistry.KINETIC_CANNON_2_MEDIUM.get(), new Item.Properties().group(ModGroup.itemGroup)));
    public static final RegistryObject<Item> MISSILE_LAUNCHER_1 = ITEMS.register("missile_launcher_1", () -> new BlockItem(BlockRegistry.MISSILE_LAUNCHER_1.get(), new Item.Properties().group(ModGroup.itemGroup)));

    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
