package com.lulan.shincolle.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;

import static net.minecraft.client.renderer.GlStateManager.pushMatrix;

public class ModelPlayerAccessory extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;

	public ModelPlayerAccessory() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone, 0.0F, 0.0F, -3.1416F);
		bone.cubeList.add(new ModelBox(bone, 23, 39, 14.5F, -6.0F, 0.2F, 4, 6, 5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 23, 31, 14.5F, -9.0F, 0.2F, 4, 3, 5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 56, 33, 16.7F, -7.0F, 0.5F, 2, 2, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -4.5F, -11.0F, -16.6F, 9, 8, 9, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 32, 4, 7.5F, -15.0F, -13.7F, 1, 2, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 29, 4, 3.5F, -15.0F, -13.7F, 4, 7, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 37, 0, 5.5F, -36.0F, -12.7F, 1, 21, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 64, 24, 4.5F, -26.0F, -13.7F, 3, 2, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 64, 24, 4.5F, -34.0F, -13.7F, 3, 1, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 47, 42, 4.5F, -39.0F, -13.7F, 3, 3, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 40, 13, 4.5F, -45.0F, -12.7F, 1, 12, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 26, 13, -1.5F, -32.0F, -12.7F, 15, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 32, 13, 0.5F, -42.0F, -12.7F, 9, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 23, 39, -18.5F, -6.0F, 0.2F, 4, 6, 5, 0.0F, true));
		bone.cubeList.add(new ModelBox(bone, 56, 33, -18.7F, -7.0F, 0.5F, 2, 2, 4, 0.0F, true));
		bone.cubeList.add(new ModelBox(bone, 23, 31, -18.5F, -9.0F, 0.2F, 4, 3, 5, 0.0F, true));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-6.0F, -28.0F, -8.0F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.7854F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 24, 0, -0.1F, 21.0F, -3.7F, 3, 3, 9, 0.0F, true));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-9.0F, -28.0F, -4.0F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.2182F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 26, 0, -0.7F, 21.0F, -0.5F, 2, 3, 8, 0.0F, true));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-19.0F, -33.0F, 2.0F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.0175F, 0.2618F, 0.0F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 7, 9, -0.1F, 21.2F, 6.4F, 4, 3, 1, 0.0F, true));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-19.0F, -35.0F, 2.0F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.1745F, 0.1745F, 0.0F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 47, 34, 1.0F, 23.5F, 0.0F, 1, 1, 6, 0.0F, true));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 47, 34, 3.0F, 23.5F, 0.0F, 1, 1, 6, 0.0F, true));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-18.0F, -38.0F, 2.0F);
		bone.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.0175F, 0.1745F, 0.0F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 48, 30, 2.2F, 23.7F, 1.5F, 1, 1, 1, 0.0F, true));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 48, 30, -0.2F, 23.7F, 1.5F, 1, 1, 1, 0.0F, true));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-16.0F, -33.0F, -4.0F);
		bone.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -0.6109F, 0.0F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 4, -0.9F, 20.5F, -6.0F, 4, 4, 6, 0.0F, true));
		cube_r6.cubeList.add(new ModelBox(cube_r6, 4, 5, -1.5F, 20.5F, -5.5F, 1, 4, 5, 0.0F, true));

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-20.0F, -35.0F, -6.0F);
		bone.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, -0.2618F, 0.0436F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 56, 30, -0.5F, 23.5F, -3.0F, 5, 1, 1, 0.0F, true));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-19.0F, -35.0F, 2.0F);
		bone.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.0175F, 0.1745F, 0.0F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, -2, 2, -0.5F, 21.6F, -3.0F, 6, 3, 8, 0.0F, true));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-19.0F, -33.0F, 2.0F);
		bone.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.1745F, 0.0F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 0, 0, -1.0F, 22.5F, -1.8F, 7, 2, 7, 0.0F, true));

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-17.5F, -30.0F, 6.0F);
		bone.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.3491F, 0.0F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 25, 31, -0.7F, 21.0F, -1.1F, 4, 3, 5, 0.0F, true));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 25, 39, -0.7F, 24.0F, -1.1F, 4, 6, 5, 0.0F, true));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-16.0F, -30.0F, -6.0F);
		bone.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, -0.3491F, 0.0F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 18, 31, -0.2F, 21.0F, 1.7F, 4, 3, 5, 0.0F, true));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 16, 39, -0.2F, 24.0F, 1.7F, 4, 6, 5, 0.0F, true));

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-21.0F, -31.0F, 4.0F);
		bone.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.3927F, 0.0F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 46, 30, -1.0F, 24.5F, -1.0F, 4, 1, 1, 0.0F, true));

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-16.0F, -30.0F, -6.0F);
		bone.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, -0.6109F, 0.0F);
		cube_r13.cubeList.add(new ModelBox(cube_r13, 12, 31, 0.3F, 21.0F, -3.3F, 4, 3, 5, 0.0F, true));
		cube_r13.cubeList.add(new ModelBox(cube_r13, 10, 39, 0.3F, 24.0F, -3.3F, 4, 6, 5, 0.0F, true));

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-20.0F, -31.0F, -8.0F);
		bone.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, -1.0472F, 0.0F);
		cube_r14.cubeList.add(new ModelBox(cube_r14, 46, 30, -0.8F, 24.5F, -5.5F, 4, 1, 1, 0.0F, true));

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-17.0F, -31.0F, -5.0F);
		bone.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, -0.6545F, 0.0F);
		cube_r15.cubeList.add(new ModelBox(cube_r15, 56, 33, 0.2F, 24.0F, -6.2F, 2, 2, 4, 0.0F, true));

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-16.0F, -30.0F, -6.0F);
		bone.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, -0.7854F, 0.0F);
		cube_r16.cubeList.add(new ModelBox(cube_r16, 10, 31, -0.3F, 21.0F, -8.3F, 4, 3, 5, 0.0F, true));
		cube_r16.cubeList.add(new ModelBox(cube_r16, 10, 39, -0.3F, 24.0F, -8.3F, 4, 6, 5, 0.0F, true));

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(9.0F, -28.0F, -4.0F);
		bone.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, -0.2182F, 0.0F);
		cube_r17.cubeList.add(new ModelBox(cube_r17, 26, 0, -1.3F, 21.0F, -0.5F, 2, 3, 8, 0.0F, false));

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(6.0F, -28.0F, -8.0F);
		bone.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.7854F, 0.0F);
		cube_r18.cubeList.add(new ModelBox(cube_r18, 24, 0, -2.9F, 21.0F, -3.7F, 3, 3, 9, 0.0F, false));

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(7.0F, -28.0F, -15.0F);
		bone.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 1.0297F, 0.0F);
		cube_r19.cubeList.add(new ModelBox(cube_r19, 27, 0, -4.9F, 19.1F, -2.5F, 4, 5, 7, 0.0F, false));

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(0.0F, -34.0F, -12.0F);
		bone.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.1309F, 0.0F, 0.0F);
		cube_r20.cubeList.add(new ModelBox(cube_r20, 21, 53, -4.0F, 4.0F, -4.1F, 8, 4, 8, 0.0F, false));
		cube_r20.cubeList.add(new ModelBox(cube_r20, 4, 3, -3.5F, 8.0F, -3.6F, 7, 16, 7, 0.0F, false));

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(16.0F, -33.0F, -4.0F);
		bone.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.6109F, 0.0F);
		cube_r21.cubeList.add(new ModelBox(cube_r21, 4, 5, 0.5F, 20.5F, -5.5F, 1, 4, 5, 0.0F, false));
		cube_r21.cubeList.add(new ModelBox(cube_r21, 0, 4, -3.1F, 20.5F, -6.0F, 4, 4, 6, 0.0F, false));

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(19.0F, -35.0F, 2.0F);
		bone.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.1745F, -0.1745F, 0.0F);
		cube_r22.cubeList.add(new ModelBox(cube_r22, 47, 34, -4.0F, 23.5F, 0.0F, 1, 1, 6, 0.0F, false));
		cube_r22.cubeList.add(new ModelBox(cube_r22, 47, 34, -2.0F, 23.5F, 0.0F, 1, 1, 6, 0.0F, false));

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(18.0F, -38.0F, 2.0F);
		bone.addChild(cube_r23);
		setRotationAngle(cube_r23, -0.0175F, -0.1745F, 0.0F);
		cube_r23.cubeList.add(new ModelBox(cube_r23, 48, 30, -0.8F, 23.7F, 1.5F, 1, 1, 1, 0.0F, false));
		cube_r23.cubeList.add(new ModelBox(cube_r23, 48, 30, -3.2F, 23.7F, 1.5F, 1, 1, 1, 0.0F, false));

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(19.0F, -33.0F, 2.0F);
		bone.addChild(cube_r24);
		setRotationAngle(cube_r24, -0.0175F, -0.2618F, 0.0F);
		cube_r24.cubeList.add(new ModelBox(cube_r24, 7, 9, -3.9F, 21.2F, 6.4F, 4, 3, 1, 0.0F, false));

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(19.0F, -35.0F, 2.0F);
		bone.addChild(cube_r25);
		setRotationAngle(cube_r25, -0.0175F, -0.1745F, 0.0F);
		cube_r25.cubeList.add(new ModelBox(cube_r25, -2, 2, -5.5F, 21.6F, -3.0F, 6, 3, 8, 0.0F, false));

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(19.0F, -33.0F, 2.0F);
		bone.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, -0.1745F, 0.0F);
		cube_r26.cubeList.add(new ModelBox(cube_r26, 0, 0, -6.0F, 22.5F, -1.8F, 7, 2, 7, 0.0F, false));

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(20.0F, -35.0F, -6.0F);
		bone.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 0.2618F, -0.0436F);
		cube_r27.cubeList.add(new ModelBox(cube_r27, 56, 30, -4.5F, 23.5F, -3.0F, 5, 1, 1, 0.0F, false));

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(20.0F, -31.0F, -8.0F);
		bone.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 1.0472F, 0.0F);
		cube_r28.cubeList.add(new ModelBox(cube_r28, 46, 30, -3.2F, 24.5F, -5.5F, 4, 1, 1, 0.0F, false));

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(21.0F, -31.0F, 4.0F);
		bone.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, -0.3927F, 0.0F);
		cube_r29.cubeList.add(new ModelBox(cube_r29, 46, 30, -3.0F, 24.5F, -1.0F, 4, 1, 1, 0.0F, false));

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(17.0F, -31.0F, -5.0F);
		bone.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.6545F, 0.0F);
		cube_r30.cubeList.add(new ModelBox(cube_r30, 56, 33, -2.2F, 24.0F, -6.2F, 2, 2, 4, 0.0F, false));

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(16.0F, -30.0F, -6.0F);
		bone.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 0.6109F, 0.0F);
		cube_r31.cubeList.add(new ModelBox(cube_r31, 12, 31, -4.3F, 21.0F, -3.3F, 4, 3, 5, 0.0F, false));
		cube_r31.cubeList.add(new ModelBox(cube_r31, 10, 39, -4.3F, 24.0F, -3.3F, 4, 6, 5, 0.0F, false));

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(16.0F, -30.0F, -6.0F);
		bone.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, 0.3491F, 0.0F);
		cube_r32.cubeList.add(new ModelBox(cube_r32, 18, 31, -3.8F, 21.0F, 1.7F, 4, 3, 5, 0.0F, false));
		cube_r32.cubeList.add(new ModelBox(cube_r32, 16, 39, -3.8F, 24.0F, 1.7F, 4, 6, 5, 0.0F, false));

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(17.5F, -30.0F, 6.0F);
		bone.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, -0.3491F, 0.0F);
		cube_r33.cubeList.add(new ModelBox(cube_r33, 25, 31, -3.3F, 21.0F, -1.1F, 4, 3, 5, 0.0F, false));
		cube_r33.cubeList.add(new ModelBox(cube_r33, 25, 39, -3.3F, 24.0F, -1.1F, 4, 6, 5, 0.0F, false));

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(16.0F, -30.0F, -6.0F);
		bone.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.7854F, 0.0F);
		cube_r34.cubeList.add(new ModelBox(cube_r34, 10, 31, -3.7F, 21.0F, -8.3F, 4, 3, 5, 0.0F, false));
		cube_r34.cubeList.add(new ModelBox(cube_r34, 10, 39, -3.7F, 24.0F, -8.3F, 4, 6, 5, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		pushMatrix();
		GlStateManager.enableRescaleNormal();
		RenderHelper.enableStandardItemLighting();
		GlStateManager.scale(0.5, 0.5, 0.5);
		bone.render(f5);
		GlStateManager.disableRescaleNormal();
		GlStateManager.disableLighting();
		GlStateManager.popMatrix();
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}