package stardust.stardust.client.render.gecko.model.entity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static stardust.stardust.Stardust.MODID;

public class CarrierDemoModel extends AnimatedGeoModel {

    @Override
    public ResourceLocation getModelLocation(Object object) {
        return new ResourceLocation(MODID, "geo/carrier.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Object object) {
        return new ResourceLocation(MODID, "textures/entity/carrier.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Object animatable) {
        return null;
    }

}
