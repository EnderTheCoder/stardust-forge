package stardust.stardust.registry;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import stardust.stardust.block.*;

import static stardust.stardust.Stardust.MODID;

public class BlockRegistry {
    //Blocks
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final RegistryObject<Block> CANNON_BASE_MEDIUM = BLOCKS.register("cannon_base_medium", CannonBaseMedium::new);
    public static final RegistryObject<Block> KINETIC_CANNON_1_MEDIUM = BLOCKS.register("kinetic_cannon_1_medium", KineticCannon1Medium::new);
    public static final RegistryObject<Block> KINETIC_CANNON_2_MEDIUM = BLOCKS.register("kinetic_cannon_2_medium", KineticCannon2Medium::new);
    public static final RegistryObject<Block> MISSILE_LAUNCHER_1 = BLOCKS.register("missile_launcher_1", MissileLauncher1::new);
    public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", SteelBlock::new);

    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
