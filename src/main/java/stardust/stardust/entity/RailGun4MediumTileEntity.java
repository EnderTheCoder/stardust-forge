package stardust.stardust.entity;

import net.minecraft.block.DispenserBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import stardust.stardust.registry.TileEntityTypeRegistry;

public class RailGun4MediumTileEntity extends TileEntity implements IAnimatable {
    public static final Logger LOGGER = LogManager.getLogger();
    private final AnimationFactory factory = new AnimationFactory(this);

    private int shootCount = 0;

    public RailGun4MediumTileEntity()
    {
        super(TileEntityTypeRegistry.RAIL_GUN_4_MEDIUM_TILE_ENTITY.get());
    }

    @Override
    public void registerControllers(AnimationData data) {

    }

    public void shoot() {
        if (!this.world.isRemote()) {

            World world = this.getWorld();
            assert world != null;
            Direction direction = this.getBlockState().get(DispenserBlock.FACING);

//        LOGGER.info(String.format("current pos is (%s, %s, %s)", this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()));
//        LOGGER.info(String.format("current offset is (%s, %s, %s)", direction.getXOffset(), direction.getYOffset(), direction.getZOffset()));
            LOGGER.info(String.format("the %s times of shooting", ++shootCount));
            double dx = this.getPos().getX() + (double) ((float) direction.getXOffset() * 0.3F);
            double dy = this.getPos().getY() + (double) ((float) direction.getYOffset() * 0.3F);
            double dz = this.getPos().getZ() + (double) ((float) direction.getZOffset() * 0.3F);

            RailGunProjectileEntity projectile = new RailGunProjectileEntity(this.world, dx, dy, dz, 0, 0, 1);

            projectile.setRawPosition(dx, dy, dz);
            world.addEntity(projectile);
        }
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
