package stardust.stardust.client.render.gecko.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;
import stardust.stardust.client.render.gecko.model.entity.HEProjectileModel;
import stardust.stardust.entity.projectile.HEProjectileEntity;
import stardust.stardust.entity.projectile.RailGunProjectileEntity;

public class HEProjectileRenderer extends GeoProjectilesRenderer<HEProjectileEntity> {
    public HEProjectileRenderer(EntityRendererManager renderManager, AnimatedGeoModel<RailGunProjectileEntity> modelProvider) {
        super(renderManager, new HEProjectileModel());
    }

}
