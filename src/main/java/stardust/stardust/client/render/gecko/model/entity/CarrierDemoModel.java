package stardust.stardust.client.render.gecko.model.entity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import stardust.stardust.entity.CarrierDemoEntity;

import static stardust.stardust.Stardust.MODID;

public class CarrierDemoModel extends AnimatedGeoModel<CarrierDemoEntity> {

    @Override
    public ResourceLocation getModelLocation(CarrierDemoEntity object) {
        return new ResourceLocation(MODID, "geo/carrier.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CarrierDemoEntity object) {
        return new ResourceLocation(MODID, "textures/entity/carrier.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CarrierDemoEntity animatable) {
        return null;
    }

}
