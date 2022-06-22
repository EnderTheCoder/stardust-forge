package stardust.stardust.client.render;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import stardust.stardust.registry.EntityTypeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderTypeRegistry {
    @SubscribeEvent
    public static void onRenderTypeSetup(final FMLClientSetupEvent event) {
//        event.enqueueWork(() -> {
//            RenderTypeLookup.setRenderLayer(BlockRegistry.CANNON_BASE_MEDIUM.get(), RenderType.getWaterMask());
//        });
    }
}
