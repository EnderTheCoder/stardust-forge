package stardust.stardust.client.render.gecko.renderer.block;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import stardust.stardust.Stardust;
import stardust.stardust.client.render.gecko.model.block.RailGun4MediumModel;
import stardust.stardust.entity.RailGun4MediumTileEntity;

import java.util.List;

public class RailGun4MediumRenderer extends GeoBlockRenderer<RailGun4MediumTileEntity> {


    public RailGun4MediumRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn, new RailGun4MediumModel());

    }

    @Override
    public void render(RailGun4MediumTileEntity tile, float partialTicks, MatrixStack stack, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(tile, partialTicks, stack, bufferIn, packedLightIn);
    }


}
