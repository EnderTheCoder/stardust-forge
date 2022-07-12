package stardust.stardust.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class ProjectileDemoEntity extends AbstractStardustProjectileEntity implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);

    public ProjectileDemoEntity(EntityType<? extends AbstractStardustProjectileEntity> type, World worldIn) {
        super(type, worldIn);
        this.ignoreFrustumCheck = true;
    }

//    public ProjectileDemoEntity() {
//        super(EntityTypeRegistry.PROJECTILE_DEMO_ENTITY.get(), null);
//    }

//    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
//
//    }


    @Override
    public void registerControllers(AnimationData data) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    public Entity getEntity() {
        return super.getEntity();
    }
}