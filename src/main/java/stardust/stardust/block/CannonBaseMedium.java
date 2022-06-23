package stardust.stardust.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import stardust.stardust.entity.CannonBaseMediumTileEntity;

import javax.annotation.Nullable;
import java.util.List;

public class CannonBaseMedium extends Block {

    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    public static final IntegerProperty OFFSET_X = IntegerProperty.create("offset_x", 0, 2);
    public static final IntegerProperty OFFSET_Z = IntegerProperty.create("offset_z", 0, 2);

    public CannonBaseMedium() {
        super(Properties.create(Material.ROCK, MaterialColor.BLACK).setRequiresTool().hardnessAndResistance(100.0F, 2000.0F).noDrops());
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.UP).with(OFFSET_X, 1).with(OFFSET_Z, 1));
    }

    public static int getRealOffsetX(BlockState state) {
        return state.get(CannonBaseMedium.OFFSET_X) - 1;
    }

    public static int getRealOffsetZ(BlockState state) {
        return state.get(CannonBaseMedium.OFFSET_Z) - 1;
    }

    public static BlockPos getCenterBlockPos(BlockState blockState, BlockPos pos) {
        return pos.add(getRealOffsetX(blockState),0,getRealOffsetZ(blockState));
    }


//    public static BlockState getCenterBlockState(BlockState blockState, BlockPos pos) {
//        return blockState.
//    }

    public static List<BlockPos> getAllBlockPos(BlockState blockState, BlockPos pos) {
        List<BlockPos> allPos = new java.util.ArrayList<>(List.of(getCenterBlockPos(blockState, pos)));
        allPos.add(allPos.get(0).add(1,0,0));
        allPos.add(allPos.get(0).add(1,0,1));
        allPos.add(allPos.get(0).add(1,0,-1));
        allPos.add(allPos.get(0).add(-1,0,0));
        allPos.add(allPos.get(0).add(-1,0,1));
        allPos.add(allPos.get(0).add(-1,0,-1));
        allPos.add(allPos.get(0).add(0,0,1));
        allPos.add(allPos.get(0).add(0,0,-1));
        return allPos;
    }

    @Override
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

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

//    @Override
//    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
//        return 15;
//    }



    @Override
    public boolean isTransparent(BlockState state) {
        return (state.get(CannonBaseMedium.OFFSET_X) != 1 || state.getBlockState().get(CannonBaseMedium.OFFSET_Z) != 1);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        if (state.get(CannonBaseMedium.OFFSET_X) != 1 || state.getBlockState().get(CannonBaseMedium.OFFSET_Z) != 1) return 0.0F;
        else return 1.0F;
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return 10;
    }

    //    public static class XProperties extends Properties {
//
//    }
}
