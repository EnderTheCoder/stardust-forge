package stardust.stardust.entity;

import io.netty.util.collection.CharObjectMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;

import java.util.UUID;

public abstract class AbstractStardustProjectileEntity extends Entity implements IAnimatable {

    enum ProjectileType {
        ENERGY_LASER, ENERGY_PLASMA, ENERGY_SUBSTANCE_DECOMPOSER, KINETIC_ARMOR_PIERCING, KINETIC_HIGHLY_EXPLOSIVE, KINETIC_BULLET
    }

    private float accelerationX = 0.0f;
    private float accelerationY = 0.0f;
    private float accelerationZ = 0.0f;

    private BlockPos shooterPos;
    private World shooterWorld;

    private long shieldDamage;
    private float armorPiercing;
    private float damage;
    private ProjectileType projectileType;


    public AbstractStardustProjectileEntity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    public AbstractStardustProjectileEntity(EntityType<?> entityTypeIn, World worldIn, ProjectileType projectileType, TileEntity shootTile, float accelerationX, float accelerationY, float accelerationZ) {
        this(entityTypeIn, worldIn);
        this.projectileType = projectileType;
        this.addVelocity(accelerationX, accelerationY, accelerationZ);
    }


    private void onImpact(RayTraceResult result) {
        switch (projectileType) {
            case ENERGY_LASER -> {
            }
            case ENERGY_PLASMA -> {
            }
            case ENERGY_SUBSTANCE_DECOMPOSER -> {
            }
            case KINETIC_ARMOR_PIERCING -> {
            }
            case KINETIC_BULLET -> {
            }
            case KINETIC_HIGHLY_EXPLOSIVE -> {
            }
        }
        if (result.getType() == RayTraceResult.Type.ENTITY) onEntityHit(result.getHitVec());
        if (result.getType() == RayTraceResult.Type.BLOCK) onBlockHit(result.getHitVec());
    }

    private void onEntityHit(Vector3d vec3) {

    }

    private void onBlockHit(Vector3d vec3) {

    }

    public TileEntity getShooter() {
        return this.shooterWorld.getTileEntity(shooterPos);
    }

    @Override
    public void tick() {
//        RayTraceResult raytraceresult = this.world.rayTraceBlocks(new RayTraceContext(vector3d2, vector3d3, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, this));
        super.tick();
    }

    @Override
    protected void registerData() {

    }

    @Override
    protected void readAdditional(CompoundNBT compound) {
        this.accelerationX = compound.getFloat("accelerationX");
        this.accelerationY = compound.getFloat("accelerationY");
        this.accelerationZ = compound.getFloat("accelerationZ");
        this.shieldDamage = compound.getLong("shieldDamage");
        this.armorPiercing = compound.getFloat("armorPiercing");
        this.shooterPos = new BlockPos(compound.getInt("shootPosX"), compound.getInt("shootPosY"), compound.getInt("shootPosZ"));
//        this.shooterWorld = new World();
        this.damage = compound.getFloat("damage");
    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {
        compound.putFloat("accelerationX", this.accelerationX);
        compound.putFloat("accelerationY", this.accelerationY);
        compound.putFloat("accelerationZ", this.accelerationZ);
        compound.putLong("shieldDamage", this.shieldDamage);
        compound.putFloat("armorPiercing", this.armorPiercing);
        compound.putInt("shooterPosX", this.shooterPos.getX());
        compound.putInt("shooterPosY", this.shooterPos.getY());
        compound.putInt("shooterPosZ", this.shooterPos.getZ());
//        compound.putString("shooterWorld", this.shooterWorld.getDimensionKey());
        compound.putFloat("damage", this.damage);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
