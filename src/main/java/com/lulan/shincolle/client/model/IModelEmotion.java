package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;

public interface IModelEmotion {
    void setFace(int var1);

    void showEquip(IShipEmotion var1);

    void syncRotationGlowPart();

    void applyDeadPose(float var1, float var2, float var3, float var4, float var5, IShipEmotion var6);

    void applyNormalPose(float var1, float var2, float var3, float var4, float var5, IShipEmotion var6);

    int getFieldCount();

    void setField(int var1, float var2);

    float getField(int var1);
}
