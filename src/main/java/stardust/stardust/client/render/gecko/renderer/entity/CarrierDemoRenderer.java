package stardust.stardust.client.render.gecko.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;
import stardust.stardust.client.render.gecko.model.entity.CarrierDemoModel;
import stardust.stardust.entity.CarrierDemoEntity;

public class CarrierDemoRenderer extends GeoProjectilesRenderer<CarrierDemoEntity> {
    public CarrierDemoRenderer(EntityRendererManager renderManager) {
        super(renderManager, new CarrierDemoModel());
    }
}
