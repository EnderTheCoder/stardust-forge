package stardust.stardust.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import stardust.stardust.item.group.ModGroup;
import stardust.stardust.registry.BlockRegistry;

import javax.annotation.Nullable;

public class CannonBaseMedium extends BlockItem {

    public CannonBaseMedium() {
        super(BlockRegistry.CANNON_BASE_MEDIUM.get(), new Item.Properties().group(ModGroup.WEAPON_GROUP));
    }


    @Override
    public ActionResultType tryPlace(BlockItemUseContext context) {
        World world = context.getWorld();

        BlockState blockState1 = world.getBlockState(context.getPos().offset(Direction.EAST));
        if (!blockState1.getMaterial().isReplaceable()) return ActionResultType.FAIL;

        BlockState blockState2 = world.getBlockState(context.getPos().offset(Direction.WEST));
        if (!blockState2.getMaterial().isReplaceable()) return ActionResultType.FAIL;

        BlockState blockState3 = world.getBlockState(context.getPos().offset(Direction.SOUTH));
        if (!blockState3.getMaterial().isReplaceable()) return ActionResultType.FAIL;

        BlockState blockState4 = world.getBlockState(context.getPos().offset(Direction.NORTH));
        if (!blockState4.getMaterial().isReplaceable()) return ActionResultType.FAIL;

        BlockState blockState5 = world.getBlockState(context.getPos().offset(Direction.NORTH).offset(Direction.WEST));
        if (!blockState5.getMaterial().isReplaceable()) return ActionResultType.FAIL;

        BlockState blockState6 = world.getBlockState(context.getPos().offset(Direction.NORTH).offset(Direction.EAST));
        if (!blockState6.getMaterial().isReplaceable()) return ActionResultType.FAIL;

        BlockState blockState7 = world.getBlockState(context.getPos().offset(Direction.SOUTH).offset(Direction.WEST));
        if (!blockState7.getMaterial().isReplaceable()) return ActionResultType.FAIL;

        BlockState blockState8 = world.getBlockState(context.getPos().offset(Direction.SOUTH).offset(Direction.EAST));
        if (!blockState8.getMaterial().isReplaceable()) return ActionResultType.FAIL;
        return super.tryPlace(context);
    }


    @Override
    protected boolean placeBlock(BlockItemUseContext context, BlockState state) {
        context.getWorld().setBlockState(context.getPos().add(1, 0, 0), this.getBlock().getDefaultState().with(stardust.stardust.block.CannonBaseMedium.OFFSET_X, 0), 11);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(-1, 0, 0), this.getBlock().getDefaultState().with(stardust.stardust.block.CannonBaseMedium.OFFSET_X, 2), 11);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(0, 0, 1), this.getBlock().getDefaultState().with(stardust.stardust.block.CannonBaseMedium.OFFSET_Z, 0), 11);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(0, 0, -1), this.getBlock().getDefaultState().with(stardust.stardust.block.CannonBaseMedium.OFFSET_Z, 2), 11);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(1, 0, 1), this.getBlock().getDefaultState().with(stardust.stardust.block.CannonBaseMedium.OFFSET_X, 0).with(stardust.stardust.block.CannonBaseMedium.OFFSET_Z, 0), 11);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(1, 0, -1), this.getBlock().getDefaultState().with(stardust.stardust.block.CannonBaseMedium.OFFSET_X, 0).with(stardust.stardust.block.CannonBaseMedium.OFFSET_Z, 2), 11);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(-1, 0, 1), this.getBlock().getDefaultState().with(stardust.stardust.block.CannonBaseMedium.OFFSET_X, 2).with(stardust.stardust.block.CannonBaseMedium.OFFSET_Z, 0), 11);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(-1, 0, -1), this.getBlock().getDefaultState().with(stardust.stardust.block.CannonBaseMedium.OFFSET_X, 2).with(stardust.stardust.block.CannonBaseMedium.OFFSET_Z, 2), 11);
        super.placeBlock(context, state);
        return super.placeBlock(context, state);
    }

}
