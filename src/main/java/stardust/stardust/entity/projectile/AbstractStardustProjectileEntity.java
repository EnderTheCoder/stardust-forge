/**
 * @Author: EnderTheCoder
 *
 * */

package stardust.stardust.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import stardust.stardust.damage.SubstanceDecomposing;

import javax.annotation.Nonnull;

public abstract class AbstractStardustProjectileEntity extends DamagingProjectileEntity {

    enum ProjectileType {
        ENERGY_LASER, ENERGY_PLASMA, ENERGY_SUBSTANCE_DECOMPOSER, KINETIC_ARMOR_PIERCING, KINETIC_HIGHLY_EXPLOSIVE, KINETIC_BULLET
    }

    private double accelerationX = 0.0d;
    private double accelerationY = 0.0d;
    private double accelerationZ = 0.0d;

    private BlockPos shooterPos;

    private long shieldDamage;
    private long energy;
    private float attribute;
    public ProjectileType projectileType;


    public AbstractStardustProjectileEntity(EntityType<? extends AbstractStardustProjectileEntity> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    public AbstractStardustProjectileEntity(EntityType<? extends AbstractStardustProjectileEntity> entityTypeIn, World worldIn, ProjectileType projectileType, long energy, float attribute, TileEntity shootTile, double startX, double startY, double startZ, double accelerationX, double accelerationY, double accelerationZ) {
        super(entityTypeIn, startX, startY, startZ, accelerationX, accelerationY, accelerationZ, worldIn);
        this.projectileType = projectileType;
        this.shooterPos = shootTile.getPos();
        this.addVelocity(accelerationX, accelerationY, accelerationZ);
        this.energy = energy;
        this.attribute = attribute;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        RayTraceResult.Type type = result.getType();
        if (type == RayTraceResult.Type.ENTITY) {
            if (((EntityRayTraceResult) result).getEntity().equals(this)) return;
            this.onEntityHit((EntityRayTraceResult) result);
        } else if (type == RayTraceResult.Type.BLOCK) {
            this.func_230299_a_((BlockRayTraceResult) result);
        }

        if (!world.isRemote()) {
            if (projectileType == ProjectileType.KINETIC_HIGHLY_EXPLOSIVE) {
                Explosion.Mode explosion$mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.getShooter()) ? Explosion.Mode.DESTROY : Explosion.Mode.NONE;
                this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), attribute, false, explosion$mode);
            }

            if (projectileType != ProjectileType.KINETIC_ARMOR_PIERCING && projectileType != ProjectileType.ENERGY_SUBSTANCE_DECOMPOSER) {
                this.remove();
            }
        }

    }

    @Override
    protected void onEntityHit(@Nonnull EntityRayTraceResult result) {
        super.onEntityHit(result);
        if (!this.world.isRemote()) {
            if (this.projectileType == ProjectileType.KINETIC_HIGHLY_EXPLOSIVE) this.remove();
        }
    }

    /**
     * OnBlockHit()
     */
    @Override
    protected void func_230299_a_(@Nonnull BlockRayTraceResult result) {
        super.func_230299_a_(result);
        if (!this.world.isRemote) {
            if (this.projectileType == ProjectileType.ENERGY_SUBSTANCE_DECOMPOSER) {
                new SubstanceDecomposing(this.world, result.getPos(), (long) this.attribute);
            }
        }
    }

    public TileEntity getShooterTile() {
        return this.world.getTileEntity(shooterPos);
    }

    @Override
    public boolean isBurning() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected void registerData() {
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        this.accelerationX = compound.getDouble("accelerationX");
        this.accelerationY = compound.getDouble("accelerationY");
        this.accelerationZ = compound.getDouble("accelerationZ");
        this.shieldDamage = compound.getLong("shieldDamage");
        this.energy = compound.getLong("energy");
        this.shooterPos = new BlockPos(compound.getInt("shootPosX"), compound.getInt("shootPosY"), compound.getInt("shootPosZ"));
        this.attribute = compound.getFloat("attribute");
//        this.projectileType = ProjectileType.valueOf(compound.getString("projectileType"));
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        compound.putDouble("accelerationX", this.accelerationX);
        compound.putDouble("accelerationY", this.accelerationY);
        compound.putDouble("accelerationZ", this.accelerationZ);
        compound.putLong("shieldDamage", this.shieldDamage);
        compound.putFloat("energy", this.energy);
        compound.putInt("shooterPosX", this.shooterPos.getX());
        compound.putInt("shooterPosY", this.shooterPos.getY());
        compound.putInt("shooterPosZ", this.shooterPos.getZ());
        compound.putFloat("attribute", this.attribute);
//        compound.putString("projectileType", String.valueOf(this.projectileType));
    }


    @Override
    public @Nonnull IPacket<?> createSpawnPacket() {
         return NetworkHooks.getEntitySpawningPacket(this);
    }
}
