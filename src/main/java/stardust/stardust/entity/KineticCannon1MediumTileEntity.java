package stardust.stardust.entity;

import net.minecraft.tileentity.TileEntity;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import stardust.stardust.registry.TileEntityTypeRegistry;

public class KineticCannon1MediumTileEntity extends TileEntity implements IAnimatable {
    private int counter = 0;
    private final AnimationFactory factory = new AnimationFactory(this);
    public KineticCannon1MediumTileEntity() {
        super(TileEntityTypeRegistry.KINETIC_CANNON_1_MEDIUM_TILE_ENTITY.get());
    }

    public int increase() {
        counter++;
        return counter;
    }

    @Override
    public void registerControllers(AnimationData data) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
