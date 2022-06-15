package stardust.stardust.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import stardust.stardust.registry.EntityTypeRegistry;

public class RailGunWarheadEntity extends DamagingProjectileEntity {
    public RailGunWarheadEntity(EntityType<? extends RailGunWarheadEntity> p_i50147_1_, World p_i50147_2_) {
        super(p_i50147_1_, p_i50147_2_);
    }

    public RailGunWarheadEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(EntityTypeRegistry.RAIL_GUN_WARHEAD_ENTITY.get(), shooter, accelX, accelY, accelZ, worldIn);
    }

    public RailGunWarheadEntity(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(EntityTypeRegistry.RAIL_GUN_WARHEAD_ENTITY.get(), x, y, z, accelX, accelY, accelZ, worldIn);
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
}
