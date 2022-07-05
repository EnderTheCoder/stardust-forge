package stardust.stardust.client.render;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import stardust.stardust.Stardust;
import stardust.stardust.entity.AbstractTurretMediumTileEntity;

@Mod.EventBusSubscriber()
public class TurretCamera {
    @SubscribeEvent
    public static void onCameraSetup(EntityViewRenderEvent event) {
        PlayerEntity player = (PlayerEntity) event.getInfo().getRenderViewEntity();
        AbstractTurretMediumTileEntity turret = AbstractTurretMediumTileEntity.TURRETS_ON_PLAYER_CONTROLLED.get(player);
        if (turret != null) {
            event.getInfo().setPosition(turret.getBlockCenter().add(0,1.0, 0));
            Stardust.LOGGER.info(event.getInfo().getYaw());
            AbstractTurretMediumTileEntity.TURRETS_ON_PLAYER_CONTROLLED.get(player).setRotationY(event.getInfo().getYaw()%Math.PI);

        }
    }
}
