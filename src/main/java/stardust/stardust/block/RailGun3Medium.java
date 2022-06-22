package stardust.stardust.block;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import stardust.stardust.entity.RailGun4MediumTileEntity;

import javax.annotation.Nullable;

public class RailGun3Medium extends AbstractCannonMedium{

    public RailGun3Medium() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5));
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new RailGun4MediumTileEntity();
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }


    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        RailGun4MediumTileEntity tile =  (RailGun4MediumTileEntity) worldIn.getTileEntity(pos);
        if (tile != null) tile.shoot();
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
