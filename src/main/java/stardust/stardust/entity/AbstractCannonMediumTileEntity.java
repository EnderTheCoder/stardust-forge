package stardust.stardust.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import stardust.stardust.Stardust;
import stardust.stardust.entity.projectile.AbstractStardustProjectileEntity;
import stardust.stardust.entity.projectile.HEProjectileEntity;
import stardust.stardust.entity.projectile.RailGunProjectileEntity;
import stardust.stardust.registry.TileEntityTypeRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;

public class AbstractCannonMediumTileEntity extends TileEntity implements IAnimatable, ITickableTileEntity {
    public static final Logger LOGGER = LogManager.getLogger();
    private final AnimationFactory factory = new AnimationFactory(this);
    private final AnimationController<AbstractCannonMediumTileEntity> controller = new AnimationController<>(this, "controller", 0, this::predicate);

    public enum RotationState {
        ROTATING, READY, FREE, RESETTING
    }

    private RotationState rotationState = RotationState.FREE;
    public double initialRotationYPrefix = Math.PI;
    public double initialRotationXPrefix = 0;
    private int cd = 5;
    private long lastShootTick = 0;
    //    private int shootCount = 0;
    private double rotationSpeed = Math.PI / (3 * 20);
    public double nowRotationX = 0;
    public double nowRotationY = 0;
    //    public Vector3d targetPos;
    public double goalRotationX = 0;
    public double goalRotationY = 0;
    private Vector3d barrelRootOffset = new Vector3d(0.0d, 0.2d, 4.0d);
    public PlayerEntity playerHooked;
    public static HashMap<PlayerEntity, AbstractCannonMediumTileEntity> TURRETS_ON_PLAYER_CONTROLLED = new HashMap<>();

    public AbstractCannonMediumTileEntity() {
        super(TileEntityTypeRegistry.RAIL_GUN_4_MEDIUM_TILE_ENTITY.get());
    }

    public void rotate(MatrixStack stack) {
//        stack.rotate(Vector3f.XP.rotationDegrees((float) nowRotationX));
//        stack.rotate(Vector3f.YP.rotationDegrees((float) nowRotationY));
//        stack.rotate(Vector3f.XP.rotationDegrees(45));
//        stack.rotate(Vector3f.YP.rotationDegrees(180));
    }

    public void setRotationY(double rotationY) {
        this.nowRotationY = rotationY;
    }

    public double getActualRotationY() {
        return playerHooked == null ? nowRotationY + initialRotationYPrefix : nowRotationY;
    }

    public double getActualRotationX() {
        return playerHooked == null ? nowRotationX + initialRotationXPrefix : nowRotationX;
    }


    public Vector3d getBarrelEndPos() {
        return getBlockCenter().add(this.barrelRootOffset.rotateYaw((float) this.getActualRotationY()));
    }

    public Vector3d getBarrelDirection() {
        return new Vector3d(0, 0, 1.0d).rotateYaw((float) getActualRotationY());
    }

    public void setRotationGoal(Vector3d targetPos) {
        Vector3d turretCenter = getBlockCenter();

        double a = turretCenter.getX();
        double b = turretCenter.getY();
        double c = turretCenter.getZ();

        double d = targetPos.getX();
        double e = targetPos.getY();
        double f = targetPos.getZ();
        this.rotationState = RotationState.ROTATING;
        this.goalRotationY = getAngularDifferenceY(getBarrelInitialTowardTo(), new Vector3d(d - a, 0, f - c));
    }

    public void setRotationGoal(double yaw) {
        this.goalRotationY = yaw;
        this.rotationState = RotationState.ROTATING;
    }

    public void setDirectRotation(Vector3d targetPos) {
        Vector3d turretCenter = getBlockCenter();

        double a = turretCenter.getX();
        double b = turretCenter.getY();
        double c = turretCenter.getZ();

        double d = targetPos.getX();
        double e = targetPos.getY();
        double f = targetPos.getZ();
        this.rotationState = RotationState.ROTATING;
        this.nowRotationY = getAngularDifferenceY(getBarrelInitialTowardTo(), new Vector3d(d - a, 0, f - c));
    }

    public Vector3d getBarrelInitialTowardTo() {
        return new Vector3d(0, 0, 1.0d).rotateYaw((float) initialRotationYPrefix);
    }

    public double getAngularDifferenceY(Vector3d vec1, Vector3d vec2) {
        double cos = (vec1.x * vec2.x + vec1.z * vec2.z) / (Math.sqrt(vec1.x * vec1.x + vec1.z * vec1.z) * Math.sqrt(vec2.x * vec2.x + vec2.z * vec2.z));
        double difference = Math.acos(cos);
        return vec1.x * vec2.z - vec1.z * vec2.x > 0 ? -difference : difference;
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("railgun4_shooting", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(controller);
    }

    public boolean isInCD() {
        World world = this.getWorld();
        assert world != null;
        return this.lastShootTick + this.cd > world.getGameTime();
    }

    public void resetCD() {
        assert this.world != null;
        this.lastShootTick = this.world.getGameTime();
    }

    public void shoot() {
        World world = this.getWorld();
        assert world != null;
        if (this.isInCD()) return;
        resetCD();
        if (!world.isRemote()) {
            Vector3d barrelRootPos = getBarrelEndPos();
            double x0 = barrelRootPos.getX();
            double y0 = barrelRootPos.getY();
            double z0 = barrelRootPos.getZ();

            Vector3d barrelDirection = this.getBarrelDirection();

            double x1 = barrelDirection.getX();
            double y1 = barrelDirection.getY();
            double z1 = barrelDirection.getZ();

//            RailGunProjectileEntity projectile = new HEProjectileEntity(this.world, 1000, 10.0f, this, x0, y0, z0, x1, y1, z1);
            RailGunProjectileEntity projectile = new HEProjectileEntity(, this.world);
            projectile.setRawPosition(x0, y0, z0);
            world.addEntity(projectile);
        }
    }

    public void resetRotation() {
        if (this.goalRotationY == 0 && this.goalRotationX == 0) return;
        this.goalRotationY = 0;
        this.goalRotationX = 0;
        this.rotationState = RotationState.ROTATING;
    }

    public Vector3d getBlockCenter() {
        return new Vector3d(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5);
    }


    public void hookPlayer(PlayerEntity player) {
        this.playerHooked = player;
        TURRETS_ON_PLAYER_CONTROLLED.put(player, this);
        player.setRotationYawHead((float) this.getActualRotationY());
    }

    public PlayerEntity getPlayerHooked() {
        return this.playerHooked;
    }

    public void releasePlayer() {
        TURRETS_ON_PLAYER_CONTROLLED.put(this.playerHooked, null);
        this.playerHooked = null;
        Stardust.LOGGER.info("release");
    }

    private void rotateTick() {
        if (this.goalRotationY > this.nowRotationY) {
            if (Math.abs(this.goalRotationY - this.nowRotationY) < this.rotationSpeed)
                this.nowRotationY = this.goalRotationY;
            else this.nowRotationY += this.rotationSpeed;
        } else if (this.goalRotationY < this.nowRotationY) {
            if (Math.abs(this.goalRotationY - this.nowRotationY) < this.rotationSpeed)
                this.nowRotationY = this.goalRotationY;
            else this.nowRotationY -= this.rotationSpeed;
        } else if (this.goalRotationY == this.nowRotationY) {
            this.rotationState = RotationState.FREE;
        }
//        this.nowRotationY = this.targetRotationY;
//        this.rotationState = RotationState.COMPLETED;
    }


    /**
     * Packet sending for Server -> Client
     */
    @Nullable
    public SUpdateTileEntityPacket getUpdatePacket() {
        return null;
    }

    /**
     * Packet receiver for Client.
     */
    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        handleUpdateTag(pkt.getNbtCompound());
    }

    /**
     * Write data into NBT object.
     */
    @Override
    public @Nonnull CompoundNBT getUpdateTag() {
        CompoundNBT compoundNBT = super.getUpdateTag();
        compoundNBT.putString("rotationState", this.rotationState.toString());
        compoundNBT.putDouble("initialRotationXPrefix", this.initialRotationXPrefix);
        compoundNBT.putDouble("initialRotationYPrefix", this.initialRotationYPrefix);
        compoundNBT.putInt("cd", this.cd);
        compoundNBT.putLong("lastShootTick", this.lastShootTick);
        compoundNBT.putDouble("rotationSpeed", this.rotationSpeed);
        compoundNBT.putDouble("nowRotationX", this.nowRotationX);
        compoundNBT.putDouble("nowRotationY", this.nowRotationY);
        compoundNBT.putDouble("goalRotationX", this.goalRotationX);
        compoundNBT.putDouble("goalRotationY", this.goalRotationY);
        compoundNBT.putDouble("barrelRootOffsetX", this.barrelRootOffset.x);
        compoundNBT.putDouble("barrelRootOffsetY", this.barrelRootOffset.y);
        compoundNBT.putDouble("barrelRootOffsetZ", this.barrelRootOffset.z);
        if (this.playerHooked != null)
            compoundNBT.putUniqueId("playerHooked", this.playerHooked.getUniqueID());
        return compoundNBT;
    }

    /**
     * Read data from NBT object.
     */
    public void handleUpdateTag(CompoundNBT compoundNBT) {
        this.rotationState = RotationState.valueOf(compoundNBT.getString("rotationState"));
        this.initialRotationXPrefix = compoundNBT.getDouble("initialRotationXPrefix");
        this.initialRotationYPrefix = compoundNBT.getDouble("initialRotationYPrefix");
        this.cd = compoundNBT.getInt("cd");
        this.lastShootTick = compoundNBT.getLong("lastShootTick");
        this.rotationSpeed = compoundNBT.getDouble("rotationSpeed");
        this.nowRotationX = compoundNBT.getDouble("nowRotationX");
        this.nowRotationY = compoundNBT.getDouble("nowRotationY");
        this.goalRotationX = compoundNBT.getDouble("goalRotationX");
        this.nowRotationY = compoundNBT.getDouble("goalRotationY");
        this.barrelRootOffset = new Vector3d(compoundNBT.getDouble("barrelRootOffsetX"), compoundNBT.getDouble("barrelRootOffsetY"), compoundNBT.getDouble("barrelRootOffsetZ"));
        this.playerHooked = this.world.getPlayerByUuid(compoundNBT.getUniqueId("playerHooked"));
    }


    @Override
    public void tick() {
        if (this.playerHooked != null) {
            setRotationGoal(-Math.toRadians(this.playerHooked.getRotationYawHead()));
        }
//        goalRotationY = Math.PI;

        if (this.rotationState == RotationState.FREE) {
//            resetRotation();
        } else if (this.rotationState == RotationState.READY) {
            shoot();
        } else if (this.rotationState == RotationState.ROTATING) {
            rotateTick();
        }

        if (!this.world.isRemote) {
            world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
        }

    }


    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
