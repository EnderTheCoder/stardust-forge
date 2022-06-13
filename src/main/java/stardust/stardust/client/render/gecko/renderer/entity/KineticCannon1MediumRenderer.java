package stardust.stardust.client.render.gecko.renderer.entity;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import stardust.stardust.client.render.gecko.model.entity.KineticCannon1MediumModel;
import stardust.stardust.entity.KineticCannon1MediumTileEntity;

public class KineticCannon1MediumRenderer extends GeoBlockRenderer<KineticCannon1MediumTileEntity> {
    public KineticCannon1MediumRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn, new KineticCannon1MediumModel());
//        this.shadowRadius = 0.5F;
    }

}