package stardust.stardust.event;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import stardust.stardust.client.render.gecko.renderer.block.RailGun4MediumRenderer;
import stardust.stardust.registry.TileEntityTypeRegistry;

public class RenderEventHandler {
    @SubscribeEvent
    public void registerRenderers(final FMLClientSetupEvent event)
    {
        ClientRegistry.bindTileEntityRenderer(TileEntityTypeRegistry.RAIL_GUN_4_MEDIUM_TILE_ENTITY.get(), RailGun4MediumRenderer::new);
    }
}
