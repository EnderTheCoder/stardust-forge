package stardust.stardust.event;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.example.client.renderer.entity.ExampleGeoRenderer;
import stardust.stardust.client.render.gecko.renderer.block.RailGun4MediumRenderer;
//import stardust.stardust.client.render.gecko.renderer.entity.ProjectileDemoRenderer;
import stardust.stardust.client.render.gecko.renderer.entity.RailGunProjectileRenderer;
import stardust.stardust.entity.ProjectileDemoEntity;
import stardust.stardust.registry.EntityTypeRegistry;
import stardust.stardust.registry.TileEntityTypeRegistry;

public class RenderEventHandler {

    @SubscribeEvent
    public void registerRenderers(final FMLClientSetupEvent event) {
        System.out.println("sussy");

        ClientRegistry.bindTileEntityRenderer(TileEntityTypeRegistry.RAIL_GUN_4_MEDIUM_TILE_ENTITY.get(), RailGun4MediumRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityTypeRegistry.RAIL_GUN_PROJECTILE_ENTITY.get(), RailGunProjectileRenderer::new);


    }

}
