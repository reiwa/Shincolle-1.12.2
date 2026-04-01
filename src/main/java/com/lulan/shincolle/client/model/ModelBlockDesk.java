package com.lulan.shincolle.client.model;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;

public class ModelBlockDesk extends ModelBase {
	private final ModelRenderer bone;

	public ModelBlockDesk() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(8.0F, 24.0F, -8.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 30, -16.0F, -16.0F, 0.0F, 16, 1, 16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 1, 0, -16.0F, -15.0F, 0.0F, 1, 15, 15, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 1, 0, -1.0F, -15.0F, 0.0F, 1, 15, 15, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -16.0F, -15.0F, 15.0F, 16, 15, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 34, 0, -15.0F, -15.0F, 0.0F, 14, 6, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 15, -15.0F, -10.0F, 1.0F, 14, 1, 14, 0.0F, false));
	}

	public void render(float f) {
		bone.render(f);
	}
}