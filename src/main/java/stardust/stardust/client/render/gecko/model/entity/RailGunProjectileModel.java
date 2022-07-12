package stardust.stardust.client.render.gecko.model.entity;// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import stardust.stardust.entity.projectile.RailGunProjectileEntity;

import static stardust.stardust.Stardust.MODID;

public class RailGunProjectileModel extends AnimatedGeoModel<RailGunProjectileEntity> {
    @Override
    public ResourceLocation getModelLocation(RailGunProjectileEntity object) {
        return new ResourceLocation(MODID, "geo/rail_gun_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(RailGunProjectileEntity object) {
        return new ResourceLocation(MODID, "textures/entity/rail_gun_projectile.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(RailGunProjectileEntity object) {
        return null;
    }
}