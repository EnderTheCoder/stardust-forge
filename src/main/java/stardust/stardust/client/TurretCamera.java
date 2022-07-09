package stardust.stardust.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
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

    public static final KeyBinding RELEASE_KEY = new KeyBinding("key.stardust",
            KeyConflictContext.IN_GAME,
            KeyModifier.NONE,
            InputMappings.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT_SHIFT,
            "key.stardust.release");


    /**
     * Change the player's camera position to the turret's position
     * */
    @SubscribeEvent
    public static void onCameraSetup(EntityViewRenderEvent event) {
        PlayerEntity player = (PlayerEntity) event.getInfo().getRenderViewEntity();
        AbstractTurretMediumTileEntity turret = AbstractTurretMediumTileEntity.TURRETS_ON_PLAYER_CONTROLLED.get(player);
        if (turret != null) {
//            event.getInfo().setPosition(turret.getBarrelEndPos());
            event.getInfo().setPosition(turret.getBlockCenter().add(0, 1.5, 0));
        }
    }

    /**
    * Listen to player's left click to shoot. Meanwhile, cancel this event in case of player destroy things around his real position.
    * */
    @SubscribeEvent
    public static void onPlayerShoot(InputEvent.ClickInputEvent event) {
        AbstractTurretMediumTileEntity turret = AbstractTurretMediumTileEntity.TURRETS_ON_PLAYER_CONTROLLED.get(Minecraft.getInstance().player);
        if (turret == null)
            return;
        if (event.getKeyBinding().getKey().getKeyCode() == GLFW.GLFW_MOUSE_BUTTON_LEFT) {
            event.setCanceled(true);
            turret.shoot();
        }
    }

    @SubscribeEvent
    public static void onPlayerRelease(InputEvent.KeyInputEvent event) {
        if (RELEASE_KEY.isPressed()) {
            PlayerEntity player = Minecraft.getInstance().player;
            assert player != null;
            AbstractTurretMediumTileEntity turret = AbstractTurretMediumTileEntity.TURRETS_ON_PLAYER_CONTROLLED.get(Minecraft.getInstance().player);
            if (turret == null) return;
            player.sendStatusMessage(new TranslationTextComponent("message.stardust.release"), true);
            turret.releasePlayer();
        }
    }
}
