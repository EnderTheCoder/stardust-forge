package stardust.stardust.client.render.gecko.renderer.block;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import stardust.stardust.client.render.gecko.model.block.RailGun4MediumModel;
import stardust.stardust.entity.RailGun4MediumTileEntity;

public class RailGun4MediumRenderer extends GeoBlockRenderer<RailGun4MediumTileEntity>
{
    public RailGun4MediumRenderer(TileEntityRendererDispatcher rendererDispatcherIn)
    {
        super(rendererDispatcherIn, new RailGun4MediumModel());
    }
}
