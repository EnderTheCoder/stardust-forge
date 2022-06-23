package stardust.stardust.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.DispenserBlock;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import stardust.stardust.registry.TileEntityTypeRegistry;

import java.net.PortUnreachableException;
import java.util.zip.DeflaterOutputStream;

public class RailGun4MediumTileEntity extends TileEntity implements IAnimatable, ITickableTileEntity {
    public static final Logger LOGGER = LogManager.getLogger();
    private final AnimationFactory factory = new AnimationFactory(this);

    private int shootCount = 0;
    private final int rotationSpeed = 6;
    private double nowRotationX = 0;
    private double nowRotationY = 0;
    private final double heightOffset = 1.0d;

    public RailGun4MediumTileEntity() {
        super(TileEntityTypeRegistry.RAIL_GUN_4_MEDIUM_TILE_ENTITY.get());
    }

    public void rotate(MatrixStack stack) {
//        stack.rotate(Vector3f.XP.rotationDegrees((float) nowRotationX));
//        stack.rotate(Vector3f.YP.rotationDegrees((float) nowRotationY));
        stack.rotate(Vector3f.XP.rotationDegrees(45));
        stack.rotate(Vector3f.YP.rotationDegrees(180));

    }

    public void rotateTo(Vector3d targetPos, Vector3d initialDirection) {
        Vector3d turretCenter = getBlockCenter(this.getPos());

        double a = turretCenter.getX();//a
        double b = turretCenter.getY();//b
        double c = turretCenter.getZ();//c

        double d = targetPos.getX();
        double e = targetPos.getY();
        double f = targetPos.getZ();

        double i = initialDirection.getX();
        double j = initialDirection.getY();
        double k = initialDirection.getZ();
        //need to be changed with facing someday

        //WDday's algorithm
        //x:arctan[(d-a)/(f-c)]-arctan(i/k)
        //y:arctan[(d-a)/(e-b)]-arctan(i/j)

        double atanResult1 = Math.toDegrees(Math.atan((d - a) / (f - c)));
        if (k != 0) this.nowRotationX = atanResult1 - Math.toDegrees(Math.atan(i / k));
        else this.nowRotationX = atanResult1 - 0;

        double atanResult2 = Math.toDegrees(Math.atan((d - a) / (e - b)));
        if (j != 0) this.nowRotationY = atanResult2 - Math.toDegrees(Math.atan(i / j));
        else this.nowRotationY = atanResult2 - 0;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("railgun4_shooting", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }


    public void shoot(Vector3d targetPos) {
        World world = this.getWorld();
        assert world != null;

        rotateTo(targetPos, new Vector3d(0,0,1));

        if (!world.isRemote()) {


            Direction direction = this.getBlockState().get(DispenserBlock.FACING);
            LOGGER.info(String.format("the %s times of shooting", ++shootCount));

            Vector3d blockCenter = this.getBlockCenter(this.getPos());

            double x0 = blockCenter.getX();
            double y0 = blockCenter.getY();
            double z0 = blockCenter.getZ();

            y0 += heightOffset;

            double x1 = targetPos.getX() - x0;
            double y1 = targetPos.getY() - y0;
            double z1 = targetPos.getZ() - z0;

            RailGunProjectileEntity projectile = new RailGunProjectileEntity(this.world, AbstractStardustProjectileEntity.ProjectileType.KINETIC_HIGHLY_EXPLOSIVE, 1000, 10.0f, this, x0, y0, z0, x1, y1, z1);
            projectile.setRawPosition(x0, y0, z0);
            world.addEntity(projectile);
        }
    }

    private Vector3d getBlockCenter(BlockPos pos) {
        return new Vector3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
    }

    @Override
    public void tick() {
        World world = this.world;
        assert world != null;
        if (world.getGameTime() % 20 == 0) shoot(new Vector3d(0, 0, 0));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
