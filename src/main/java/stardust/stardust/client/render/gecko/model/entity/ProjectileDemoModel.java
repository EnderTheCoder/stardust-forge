package stardust.stardust.client.render.gecko.model.entity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import stardust.stardust.entity.ProjectileDemoEntity;
import stardust.stardust.entity.RailGunProjectileEntity;

import static stardust.stardust.Stardust.MODID;

public class ProjectileDemoModel extends AnimatedGeoModel {

//    @Override
//    public void setLivingAnimations(Object entity, Integer uniqueID, AnimationEvent customPredicate) {
//
//    }

    @Override
    public ResourceLocation getModelLocation(Object object) {
        return new ResourceLocation(MODID, "geo/ammo.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Object object) {
        return new ResourceLocation(MODID, "textures/entity/ammo.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Object animatable) {
        return null;
    }
}
