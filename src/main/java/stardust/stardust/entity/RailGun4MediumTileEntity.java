package stardust.stardust.entity;

import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import stardust.stardust.registry.EntityTypeRegistry;
import stardust.stardust.registry.TileEntityTypeRegistry;

public class RailGun4MediumTileEntity extends TileEntity implements IAnimatable {
    public static final Logger LOGGER = LogManager.getLogger();
    private final AnimationFactory factory = new AnimationFactory(this);

    public RailGun4MediumTileEntity() {
        super(TileEntityTypeRegistry.RAIL_GUN_4_MEDIUM_TILE_ENTITY.get());
    }

    @Override
    public void registerControllers(AnimationData data) {

    }

    public boolean shoot() {
        World world = this.getWorld();
        assert world != null;
        Direction direction = this.getBlockState().get(DispenserBlock.FACING);

        LOGGER.info(String.format("current pos is (%s, %s, %s)", this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()));
        LOGGER.info(String.format("current offset is (%s, %s, %s)", direction.getXOffset(), direction.getYOffset(), direction.getZOffset()));

        double dx = this.getPos().getX() + (double)((float)direction.getXOffset() * 0.3F);
        double dy = this.getPos().getY() + (double)((float)direction.getYOffset() * 0.3F);
        double dz = this.getPos().getZ() + (double)((float)direction.getZOffset() * 0.3F);

//        world.addEntity(new RailGunWarheadEntity(world, dx, dy, dz - 10.0F, 0, 0, -1));
//        world.addEntity(new SmallFireballEntity(world, dx, dy, dz, 0, 0, 1));

        RailGunWarheadEntity warhead = new RailGunWarheadEntity(this.world, dx, dy, dz, 0, 0, 1);

        warhead.setRawPosition(dx, dy, dz);
        world.addEntity(warhead);
        return true;
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
