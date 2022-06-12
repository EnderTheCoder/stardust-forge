package stardust.stardust.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CannonBaseMedium extends Block {
    public CannonBaseMedium() {
        super(Properties.create(Material.IRON).hardnessAndResistance(10));
    }
}
