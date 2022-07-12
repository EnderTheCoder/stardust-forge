package stardust.stardust.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class HEProjectileEntity extends AbstractStardustProjectileEntity implements IAnimatable {

    public ProjectileType projectileType = ProjectileType.KINETIC_HIGHLY_EXPLOSIVE;

    public HEProjectileEntity(EntityType<? extends AbstractStardustProjectileEntity> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    @Override
    public void registerControllers(AnimationData data) {

    }

    @Override
    public AnimationFactory getFactory() {
        return null;
    }
}
