package stardust.stardust.client.render;

import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import stardust.stardust.Stardust;
import stardust.stardust.entity.RailGun4MediumTileEntity;

@Mod.EventBusSubscriber()
public class TurretCamera {
    @SubscribeEvent
    public static void onCameraSetup(EntityViewRenderEvent event) {
//        if (event.getInfo().getRenderViewEntity().getClass() == ClientPlayerEntity.class) {
        PlayerEntity player = (PlayerEntity) event.getInfo().getRenderViewEntity();
        RailGun4MediumTileEntity turret = RailGun4MediumTileEntity.TURRETS_ON_PLAYER_CONTROLLED.get(player);
        if (turret != null) {
            event.getInfo().setPosition(turret.getBlockCenter().add(0,1.0, 0));
            Stardust.LOGGER.info(event.getInfo().getYaw());
            RailGun4MediumTileEntity.TURRETS_ON_PLAYER_CONTROLLED.get(player).setRotationY(event.getInfo().getYaw()%Math.PI);
        }
//        }

    }
}
