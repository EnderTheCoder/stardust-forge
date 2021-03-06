package stardust.stardust.registry;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import stardust.stardust.block.*;
import stardust.stardust.block.cannon.medium.CannonBaseMedium;
import stardust.stardust.block.cannon.medium.RailGun4Medium;

import static stardust.stardust.Stardust.MODID;

public class BlockRegistry {
    //Blocks
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final RegistryObject<Block> CANNON_BASE_MEDIUM = BLOCKS.register("cannon_base_medium", CannonBaseMedium::new);
    public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", SteelBlock::new);
    public static final RegistryObject<Block> RAIL_GUN_4_MEDIUM = BLOCKS.register("rail_gun_4_medium", RailGun4Medium::new);

    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
