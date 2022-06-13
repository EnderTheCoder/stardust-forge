package stardust.stardust.client.render.gecko.model.entity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import stardust.stardust.entity.KineticCannon1MediumTileEntity;

import static stardust.stardust.Stardust.MODID;

public class KineticCannon1MediumModel extends AnimatedGeoModel<KineticCannon1MediumTileEntity> {

    @Override
    public ResourceLocation getModelLocation(KineticCannon1MediumTileEntity object)
    {

        return new ResourceLocation(MODID, "geo/kinetic_cannon_1_medium.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(KineticCannon1MediumTileEntity object)
    {
        return new ResourceLocation(MODID, "textures/block/kinetic_cannon_1_medium.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(KineticCannon1MediumTileEntity object)
    {
        return new ResourceLocation(MODID, "animations/shoot_test.animation.json");
    }

}
