package stardust.stardust.client.render.model;// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import stardust.stardust.entity.RailGunProjectileEntity;

public class RailGunProjectileModel extends EntityModel<RailGunProjectileEntity> {
	private final ModelRenderer body;

	public RailGunProjectileModel() {
		textureWidth = 32;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(8.0F, 24.0F, -6.0F);
		body.setTextureOffset(0, 12).addBox(-9.0F, -4.0F, 4.0F, 2.0F, 4.0F, 10.0F, 0.0F, false);
		body.setTextureOffset(0, 3).addBox(-9.0F, -4.0F, 2.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-10.0F, -3.0F, 2.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(14, 12).addBox(-9.0F, -3.0F, -1.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		body.setTextureOffset(4, 8).addBox(-8.5F, -2.5F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-10.0F, -3.0F, 4.0F, 4.0F, 2.0F, 10.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(RailGunProjectileEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}