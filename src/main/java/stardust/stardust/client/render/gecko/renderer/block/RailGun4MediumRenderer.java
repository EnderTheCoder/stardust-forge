package stardust.stardust.client.render.gecko.renderer.block;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import stardust.stardust.client.render.gecko.model.block.RailGun4MediumModel;
import stardust.stardust.entity.AbstractCannonMediumTileEntity;

public class RailGun4MediumRenderer extends GeoBlockRenderer<AbstractCannonMediumTileEntity> {


    public RailGun4MediumRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn, new RailGun4MediumModel());

    }

    @Override
    public void render(AbstractCannonMediumTileEntity tile, float partialTicks, MatrixStack stack, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(tile, partialTicks, stack, bufferIn, packedLightIn);
    }


}
