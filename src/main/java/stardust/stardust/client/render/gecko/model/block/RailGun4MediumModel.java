package stardust.stardust.client.render.gecko.model.block;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import stardust.stardust.entity.AbstractTurretMediumTileEntity;

import static stardust.stardust.Stardust.MODID;

public class RailGun4MediumModel extends AnimatedGeoModel<AbstractTurretMediumTileEntity> {

    @Override
    public ResourceLocation getModelLocation(AbstractTurretMediumTileEntity object) {

        return new ResourceLocation(MODID, "geo/rail_gun_4_medium.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractTurretMediumTileEntity object) {
        return new ResourceLocation(MODID, "textures/block/rail_gun_4_medium.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AbstractTurretMediumTileEntity object) {
        return new ResourceLocation(MODID, "animations/rail_gun_4_medium_shooting.json");
    }

    @Override
    public void setLivingAnimations(AbstractTurretMediumTileEntity entity, Integer uniqueID) {
        super.setLivingAnimations(entity, uniqueID);
//        this.getAnimationProcessor().getBone("barrel_moving_up_down").setRotationZ((float) Math.toRadians(entity.nowRotationX));
        this.getAnimationProcessor().getBone("turret").setRotationY((float) entity.getActualRotationY());
        this.getAnimationProcessor().getBone("barrel_moving_up_down").setRotationX((float) entity.getActualRotationX());
    }
}
