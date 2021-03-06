package stardust.stardust.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import stardust.stardust.registry.EntityTypeRegistry;

public class RailGunProjectileEntity extends AbstractStardustProjectileEntity implements IAnimatable, net.minecraftforge.common.extensions.IForgeEntity{

    private final AnimationFactory factory = new AnimationFactory(this);

    public RailGunProjectileEntity(EntityType<? extends RailGunProjectileEntity> p_i50147_1_, World p_i50147_2_) {
        super(p_i50147_1_, p_i50147_2_);
        this.ignoreFrustumCheck = true;
        this.projectileType = ProjectileType.KINETIC_HIGHLY_EXPLOSIVE;
    }

    public RailGunProjectileEntity(World worldIn, ProjectileType projectileType, long energy, float attribute, TileEntity shootTile, double startX, double startY, double startZ, double accelerationX, double accelerationY, double accelerationZ) {
        super(EntityTypeRegistry.RAIL_GUN_PROJECTILE_ENTITY.get(), worldIn, projectileType, energy, attribute, shootTile, startX, startY, startZ, accelerationX, accelerationY, accelerationZ);
    }

    @Override
    public void registerControllers(AnimationData data) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
