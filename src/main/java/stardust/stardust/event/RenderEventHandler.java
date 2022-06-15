package stardust.stardust.event;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class RenderEventHandler {
    @SubscribeEvent
    public void registerRenderers(final FMLClientSetupEvent event)
    {
//        ClientRegistry.bindTileEntityRenderer(TileEntityTypeRegistry.KINETIC_CANNON_1_MEDIUM_TILE_ENTITY.get(), KineticCannon1MediumRenderer::new);
    }
}
