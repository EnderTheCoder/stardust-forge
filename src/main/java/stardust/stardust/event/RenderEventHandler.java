package stardust.stardust.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import stardust.stardust.Stardust;
import stardust.stardust.client.render.gecko.renderer.KineticCannon1MediumRenderer;
import stardust.stardust.registry.TileEntityTypeRegistry;

public class RenderEventHandler {


    @SubscribeEvent
    public void registerRenderers(final FMLClientSetupEvent event)
    {
        Stardust.LOGGER.info("model event triggered");
        ClientRegistry.bindTileEntityRenderer(TileEntityTypeRegistry.KINETIC_CANNON_1_MEDIUM_TILE_ENTITY.get(), KineticCannon1MediumRenderer::new);
    }
}
