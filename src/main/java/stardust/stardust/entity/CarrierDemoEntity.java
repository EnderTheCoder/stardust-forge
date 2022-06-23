package stardust.stardust.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import stardust.stardust.registry.EntityTypeRegistry;

public class CarrierDemoEntity extends DamagingProjectileEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);
    public CarrierDemoEntity(EntityType<? extends DamagingProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public CarrierDemoEntity(World world, double x0, double y0, double z0, double x1, double y1, double z1) {
        super(EntityTypeRegistry.CARRIER_DEMO_ENTITY.get(), x0, y0, z0, x1, y1, z1, world);
    }

    @Override
    public void registerControllers(AnimationData data) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote()) this.remove();
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
