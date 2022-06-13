package stardust.stardust.event;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import stardust.stardust.Stardust;
import stardust.stardust.client.render.gecko.renderer.entity.KineticCannon1MediumRenderer;
import stardust.stardust.registry.TileEntityTypeRegistry;

public class RenderEventHandler {


    @SubscribeEvent
    public void registerRenderers(final FMLClientSetupEvent event)
    {
        ClientRegistry.bindTileEntityRenderer(TileEntityTypeRegistry.KINETIC_CANNON_1_MEDIUM_TILE_ENTITY.get(), KineticCannon1MediumRenderer::new);
    }
}
