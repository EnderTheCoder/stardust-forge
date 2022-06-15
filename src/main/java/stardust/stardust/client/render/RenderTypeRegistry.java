package stardust.stardust.client.render;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import stardust.stardust.registry.BlockRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderTypeRegistry {
//    @SubscribeEvent
//    public static void onRenderTypeSetup(FMLClientSetupEvent event) {
//
//        event.enqueueWork(() -> {
//            RenderTypeLookup.setRenderLayer(BlockRegistry.CANNON_BASE_MEDIUM.get(), RenderType.getTranslucent());
//        });
//    }
}
