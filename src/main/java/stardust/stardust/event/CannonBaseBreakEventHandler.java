package stardust.stardust.event;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import stardust.stardust.block.cannon.medium.CannonBaseMedium;

import java.util.List;

public class CannonBaseBreakEventHandler {

    @SubscribeEvent
    public void breakMedium(BlockEvent.BreakEvent event) {
        if (event.getState().getBlock().getClass().equals(CannonBaseMedium.class)) {

            List<BlockPos> allPos = CannonBaseMedium.getAllBlockPos(event.getState(), event.getPos());
            for (BlockPos pos : allPos) {
                event.getWorld().setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
            }
        }
    }
}
