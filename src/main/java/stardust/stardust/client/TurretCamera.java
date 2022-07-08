package stardust.stardust.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;
import stardust.stardust.Stardust;
import stardust.stardust.entity.AbstractTurretMediumTileEntity;

@Mod.EventBusSubscriber()
public class TurretCamera {

    public static final KeyBinding RELEASE_KEY = new KeyBinding("key.release",
            KeyConflictContext.IN_GAME,
            KeyModifier.CONTROL,
            InputMappings.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT_SHIFT,
            "key.category.stardust");


    @SubscribeEvent
    public static void onCameraSetup(EntityViewRenderEvent event) {
        PlayerEntity player = (PlayerEntity) event.getInfo().getRenderViewEntity();
        AbstractTurretMediumTileEntity turret = AbstractTurretMediumTileEntity.TURRETS_ON_PLAYER_CONTROLLED.get(player);
        if (turret != null) {
//            event.getInfo().setPosition(turret.getBarrelEndPos());
            event.getInfo().setPosition(turret.getBlockCenter().add(0, 1.5, 0));
        }
    }

    @SubscribeEvent
    public static void onPlayerShoot(InputEvent.ClickInputEvent event) {
        AbstractTurretMediumTileEntity turret = AbstractTurretMediumTileEntity.TURRETS_ON_PLAYER_CONTROLLED.get(Minecraft.getInstance().player);
        if (turret == null)
            return;

        event.setCanceled(true);
        Stardust.LOGGER.info(event.getHand());
        if (event.getHand() == Hand.MAIN_HAND) turret.shoot();
    }

    @SubscribeEvent
    public static void onPlayerRelease(InputEvent.KeyInputEvent event) {
        Stardust.LOGGER.info("key pressed");
        if (RELEASE_KEY.isPressed()) {
            Stardust.LOGGER.info("key shift");

            PlayerEntity player = Minecraft.getInstance().player;
            assert player != null;
            player.sendStatusMessage(new StringTextComponent("release"), true);
            AbstractTurretMediumTileEntity turret = AbstractTurretMediumTileEntity.TURRETS_ON_PLAYER_CONTROLLED.get(Minecraft.getInstance().player);
            turret.releasePlayer();
        }
    }
}
