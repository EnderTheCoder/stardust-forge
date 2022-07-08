package stardust.stardust.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KeyBinding {
    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(TurretCamera.RELEASE_KEY);
    }
}
