package stardust.stardust.item.group;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import stardust.stardust.registry.ItemRegistry;

import javax.annotation.Nonnull;

public class WeaponGroup extends ItemGroup {
    public static ItemGroup itemGroup;

    public WeaponGroup() {
        super("weapon_group");
    }

    @Nonnull
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.KINETIC_CANNON_1_MEDIUM.get());
    }

}
