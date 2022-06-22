package stardust.stardust.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import stardust.stardust.damage.SubstanceDecomposing;
import stardust.stardust.registry.EntityTypeRegistry;

public class RailGunProjectileEntity extends DamagingProjectileEntity implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);

    public RailGunProjectileEntity(EntityType<? extends RailGunProjectileEntity> p_i50147_1_, World p_i50147_2_) {
        super(p_i50147_1_, p_i50147_2_);
        this.ignoreFrustumCheck = true;
    }

    public RailGunProjectileEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(EntityTypeRegistry.RAIL_GUN_PROJECTILE_ENTITY.get(), shooter, accelX, accelY, accelZ, worldIn);
    }

    public RailGunProjectileEntity(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(EntityTypeRegistry.RAIL_GUN_PROJECTILE_ENTITY.get(), x, y, z, accelX, accelY, accelZ, worldIn);
    }

    @Override
    public boolean isBurning() {
        return false;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            Explosion.Mode explosion$mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.getShooter()) ? Explosion.Mode.DESTROY : Explosion.Mode.NONE;
            this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 10.0F, true, explosion$mode);
            this.remove();
        }
    }

    @Override
    protected void func_230299_a_(BlockRayTraceResult result) {
        super.func_230299_a_(result);
        if (!this.world.isRemote) {
            LOGGER.warn("HIT BLOCK");
            this.remove();
        }

    }

    @Override
    protected void onEntityHit(EntityRayTraceResult result) {
        super.onEntityHit(result);
        if (!this.world.isRemote) {
            LOGGER.warn("HIT ENTITY");
            this.remove();
        }

    }

    @Override
    public void registerControllers(AnimationData data) {
//        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

//    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
//        event.getController().setAnimation(new AnimationBuilder().addAnimation("", true));
//        return PlayState.CONTINUE;
//    }

}
