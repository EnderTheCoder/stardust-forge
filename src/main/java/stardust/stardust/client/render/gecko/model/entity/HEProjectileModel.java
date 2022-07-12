package stardust.stardust.client.render.gecko.model.entity;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import stardust.stardust.entity.projectile.HEProjectileEntity;
import stardust.stardust.entity.projectile.RailGunProjectileEntity;

import static stardust.stardust.Stardust.MODID;

public class HEProjectileModel extends AnimatedGeoModel<HEProjectileEntity> {
    @Override
    public ResourceLocation getModelLocation(HEProjectileEntity object) {
        return new ResourceLocation(MODID, "geo/he_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(HEProjectileEntity object) {
        return new ResourceLocation(MODID, "textures/entity/he_projectile.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(HEProjectileEntity animatable) {
        return null;
    }
}