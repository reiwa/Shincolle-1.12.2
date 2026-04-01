package com.lulan.shincolle.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;

public class ModelBlockChair extends ModelBase {
	private final ModelRenderer bone;

	public ModelBlockChair() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(7.0F, 16.0F, 5.0F);
		setRotationAngle(bone, 0.0F, -1.5708F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 29, 25, -10.0F, -2.0F, 13.0F, 11, 2, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 56, 6, -12.0F, -5.0F, 13.0F, 2, 13, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 56, 25, 1.0F, -21.0F, -1.0F, 2, 29, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 56, 25, 1.0F, -21.0F, 13.0F, 2, 29, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 56, 6, -12.0F, -5.0F, -1.0F, 2, 13, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 33, -12.0F, -2.0F, 1.0F, 13, 2, 12, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 36, 10, 1.0F, -2.0F, 1.0F, 2, 2, 12, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 1.0F, -22.0F, 1.0F, 2, 20, 12, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 32, 0, -12.0F, -7.0F, -1.0F, 13, 2, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 32, 0, -12.0F, -7.0F, 12.0F, 13, 2, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 29, 25, -10.0F, -2.0F, -1.0F, 11, 2, 2, 0.0F, false));
	}

	public void render(float f) {
		bone.render(f);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}