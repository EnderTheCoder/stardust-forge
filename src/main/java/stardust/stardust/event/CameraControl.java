package stardust.stardust.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;
import stardust.stardust.Stardust;
import stardust.stardust.entity.AbstractTurretMediumTileEntity;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class CameraControl {

    public static final KeyBinding MESSAGE_KEY = new KeyBinding("key.release",
            KeyConflictContext.IN_GAME,
            KeyModifier.CONTROL,
            InputMappings.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT_SHIFT,
            "key.category.stardust");

    @SubscribeEvent
    public static void onPlayerShoot(InputEvent.ClickInputEvent event) {
        Stardust.LOGGER.info(event.getHand());
        AbstractTurretMediumTileEntity turret = AbstractTurretMediumTileEntity.TURRETS_ON_PLAYER_CONTROLLED.get(Minecraft.getInstance().player);
        if (turret == null)
            return;

        event.setCanceled(true);
        Stardust.LOGGER.info(event.getHand());
        if (event.getHand() == Hand.MAIN_HAND) turret.shoot();
    }

    @SubscribeEvent
    public static void onPlayerUnhook(InputEvent.KeyInputEvent event) {
        if (MESSAGE_KEY.isPressed()) {
            PlayerEntity player = Minecraft.getInstance().player;
            assert player != null;
            player.sendMessage(new StringTextComponent("Shoot"), player.getUniqueID());
            AbstractTurretMediumTileEntity turret = AbstractTurretMediumTileEntity.TURRETS_ON_PLAYER_CONTROLLED.get(Minecraft.getInstance().player);
            turret.unhookPlayer();
        }
    }
}
