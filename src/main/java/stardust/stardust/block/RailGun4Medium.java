package stardust.stardust.block;

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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stardust.stardust.entity.AbstractTurretMediumTileEntity;

import javax.annotation.Nullable;

public class RailGun4Medium extends AbstractCannonMedium {

    public static final Logger LOGGER = LogManager.getLogger();

    public RailGun4Medium() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(100.0F, 2000.0F));
    }


    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new AbstractTurretMediumTileEntity();
    }


    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        AbstractTurretMediumTileEntity tileEntity = (AbstractTurretMediumTileEntity) worldIn.getTileEntity(pos);
        assert tileEntity != null;

        AbstractTurretMediumTileEntity.TURRETS_ON_PLAYER_CONTROLLED.put(player, tileEntity);
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

}
