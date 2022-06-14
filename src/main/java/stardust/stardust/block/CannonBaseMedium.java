package stardust.stardust.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import stardust.stardust.entity.CannonBaseMediumTileEntity;

import javax.annotation.Nullable;

public class CannonBaseMedium extends Block {

    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    public static final IntegerProperty OFFSET_X = IntegerProperty.create("offset_x", 0, 2);
    public static final IntegerProperty OFFSET_Z = IntegerProperty.create("offset_z", 0, 2);

    public CannonBaseMedium() {
        super(Properties.create(Material.IRON).hardnessAndResistance(100.0F, 2000.0F));
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.UP).with(OFFSET_X, 1).with(OFFSET_Z, 1));
    }


    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(OFFSET_X);
        builder.add(OFFSET_Z);
        super.fillStateContainer(builder);
    }

    //右击创建GUI
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CannonBaseMediumTileEntity();
    }
}
