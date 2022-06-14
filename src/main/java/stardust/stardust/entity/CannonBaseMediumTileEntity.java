package stardust.stardust.entity;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import stardust.stardust.registry.TileEntityTypeRegistry;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.print.DocFlavor;
import java.util.Objects;

public class CannonBaseMediumTileEntity extends TileEntity {
    public CannonBaseMediumTileEntity() {
        super(TileEntityTypeRegistry.CANNON_BASE_MEDIUM_TILE_ENTITY.get());
    }

    @ParametersAreNonnullByDefault
    @Override
    public void read(BlockState blockState, CompoundNBT compound) {
        super.read(blockState, compound);
    }

    @Override
    public @ParametersAreNonnullByDefault CompoundNBT write(CompoundNBT compound) {
        return super.write(compound);
    }
//
//    public BlockPos getCenterPos() {
//        return this.getPos().add(-this.offsetX, 0, -this.offsetZ);
//    }
//
//    public BlockState getCenterBlockState() {
//        World world = this.getWorld();
//        assert world != null;
//        return world.getBlockState(getCenterPos());
//    }
//
//    public TileEntity getCenterTileEntity() {
//        World world = this.getWorld();
//        assert world != null;
//        return world.getTileEntity(getCenterPos());
//    }
//
//    public int getOffsetX() {
//        return offsetX;
//    }
//
//    public int getOffsetZ() {
//        return offsetZ;
//    }

}
