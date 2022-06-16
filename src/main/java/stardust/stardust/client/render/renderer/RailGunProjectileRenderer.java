package stardust.stardust.client.render.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import stardust.stardust.client.render.model.RailGunProjectileModel;
import stardust.stardust.entity.RailGunProjectileEntity;

import static stardust.stardust.Stardust.MODID;

public class RailGunProjectileRenderer extends EntityRenderer<RailGunProjectileEntity> {
    private final EntityModel<RailGunProjectileEntity> railGunProjectileModel;

    public RailGunProjectileRenderer(EntityRendererManager renderManager) {
        super(renderManager);
        railGunProjectileModel = new RailGunProjectileModel();
    }

    @Override
    public ResourceLocation getEntityTexture(RailGunProjectileEntity entity) {
        return new ResourceLocation(MODID, "textures/entity/rail_gun_projectile.png");
    }

    @Override
    public void render(RailGunProjectileEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();
        matrixStackIn.rotate(Vector3f.YN.rotationDegrees(45));
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.railGunProjectileModel.getRenderType(this.getEntityTexture(entityIn)));
        this.railGunProjectileModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
    }

}
