package stardust.stardust.client.render.gecko.model.block;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import stardust.stardust.entity.RailGun4MediumTileEntity;

import static stardust.stardust.Stardust.MODID;

public class RailGun4MediumModel extends AnimatedGeoModel<RailGun4MediumTileEntity> {

    @Override
    public ResourceLocation getModelLocation(RailGun4MediumTileEntity object)
    {

        return new ResourceLocation(MODID, "geo/rail_gun_4_medium.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(RailGun4MediumTileEntity object)
    {
        return new ResourceLocation(MODID, "textures/block/rail_gun_4_medium.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(RailGun4MediumTileEntity object)
    {
        return new ResourceLocation(MODID, "animations/rail_gun_4_medium_shooting.json");
    }

    @Override
    public void setLivingAnimations(RailGun4MediumTileEntity entity, Integer uniqueID) {
        super.setLivingAnimations(entity, uniqueID);
//        this.getAnimationProcessor().getBone("barrel_moving_up_down").setRotationZ((float) Math.toRadians(entity.nowRotationX));
//        this.getAnimationProcessor().getBone("turret").setRotationY((float) Math.toRadians(entity.nowRotationY));
    }
}
