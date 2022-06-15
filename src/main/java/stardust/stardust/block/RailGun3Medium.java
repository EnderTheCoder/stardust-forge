package stardust.stardust.block;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;

public class RailGun3Medium extends AbstractCannonMedium{

    public RailGun3Medium() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5));
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }
}
