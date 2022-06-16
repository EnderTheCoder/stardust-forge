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
import stardust.stardust.registry.EntityTypeRegistry;

public class RailGunProjectileEntity extends DamagingProjectileEntity {
    public RailGunProjectileEntity(EntityType<? extends RailGunProjectileEntity> p_i50147_1_, World p_i50147_2_) {
        super(p_i50147_1_, p_i50147_2_);
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
    }

    @Override
    protected void func_230299_a_(BlockRayTraceResult result) {
        super.func_230299_a_(result);
        if (!this.world.isRemote) {
            Explosion.Mode explosion$mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.getShooter()) ? Explosion.Mode.DESTROY : Explosion.Mode.NONE;
            this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 10.0F, true, explosion$mode);
            this.remove();
        }

    }

    @Override
    protected void onEntityHit(EntityRayTraceResult result) {
        super.onEntityHit(result);
        boolean flag = result.getEntity().attackEntityFrom(DamageSource.causeBedExplosionDamage(), 5.0F);
    }

}
