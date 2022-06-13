package stardust.stardust.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import stardust.stardust.entity.CannonBaseMediumTileEntity;

public class CannonBaseMedium extends Block {

//    public static final DirectionProperty FACING = DirectionProperty.

    public CannonBaseMedium() {
        super(Properties.create(Material.IRON).hardnessAndResistance(100.0F, 2000.0F));
    }

    //右击创建GUI
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        TranslationTextComponent translationTextComponent = new TranslationTextComponent("message.stardust.counter", ((CannonBaseMediumTileEntity) worldIn.getTileEntity(pos)).getOffsetX());
        player.sendStatusMessage(translationTextComponent, false);

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
