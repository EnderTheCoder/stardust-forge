package stardust.stardust.client.render.gecko.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;
import stardust.stardust.client.render.gecko.model.entity.RailGunProjectileModel;
import stardust.stardust.entity.projectile.RailGunProjectileEntity;

public class RailGunProjectileRenderer extends GeoProjectilesRenderer<RailGunProjectileEntity> {

    public RailGunProjectileRenderer (EntityRendererManager renderManager) {
        super(renderManager, new RailGunProjectileModel());
    }
}
