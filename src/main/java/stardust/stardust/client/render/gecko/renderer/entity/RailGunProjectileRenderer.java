package stardust.stardust.client.render.gecko.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;
import stardust.stardust.client.render.gecko.model.entity.RailGunProjectileModel;
import stardust.stardust.entity.RailGunProjectileEntity;

public class RailGunProjectileRenderer extends GeoProjectilesRenderer<RailGunProjectileEntity> {

    public RailGunProjectileRenderer (EntityRendererManager renderManager) {
        super(renderManager, new RailGunProjectileModel());
    }
}
