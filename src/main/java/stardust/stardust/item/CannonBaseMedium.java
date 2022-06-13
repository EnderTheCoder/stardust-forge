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

        context.getWorld().setBlockState(context.getPos().add(1,0,0), Blocks.AIR.getDefaultState(), 27);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(-1,0,0), Blocks.AIR.getDefaultState(), 27);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(0,0,1), Blocks.AIR.getDefaultState(), 27);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(0,0,-1), Blocks.AIR.getDefaultState(), 27);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(1,0,1), Blocks.AIR.getDefaultState(), 27);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(1,0,-1), Blocks.AIR.getDefaultState(), 27);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(-1,0,1), Blocks.AIR.getDefaultState(), 27);
        super.placeBlock(context, state);
        context.getWorld().setBlockState(context.getPos().add(-1,0,-1), Blocks.AIR.getDefaultState(), 27);
        super.placeBlock(context, state);
        return super.placeBlock(context, state);
    }

    @Override
    protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity player, ItemStack stack, BlockState state) {
        return setTileEntityNBT(worldIn, player, pos, stack, 0, 0);
    }

    public static boolean setTileEntityNBT(World worldIn, @Nullable PlayerEntity player, BlockPos pos, ItemStack stackIn, int offsetX, int offsetZ) {
        MinecraftServer minecraftserver = worldIn.getServer();
        if (minecraftserver == null) {
            return false;
        } else {
            CompoundNBT compoundnbt = stackIn.getChildTag("BlockEntityTag");
            if (compoundnbt != null) {
                TileEntity tileentity = worldIn.getTileEntity(pos);
                if (tileentity != null) {
                    if (!worldIn.isRemote && tileentity.onlyOpsCanSetNbt() && (player == null || !player.canUseCommandBlock())) {
                        return false;
                    }

                    CompoundNBT compoundnbt1 = tileentity.write(new CompoundNBT());
                    CompoundNBT compoundnbt2 = compoundnbt1.copy();
                    compoundnbt1.merge(compoundnbt);


                    compoundnbt1.putInt("x", pos.getX());
                    compoundnbt1.putInt("y", pos.getY());
                    compoundnbt1.putInt("z", pos.getZ());

                    compoundnbt1.putInt("offsetX", offsetX);
                    compoundnbt1.putInt("offsetZ", offsetZ);

                    if (!compoundnbt1.equals(compoundnbt2)) {
                        tileentity.read(worldIn.getBlockState(pos), compoundnbt1);
                        tileentity.markDirty();
                        return true;
                    }
                }
            }

            return false;
        }
    }

}
