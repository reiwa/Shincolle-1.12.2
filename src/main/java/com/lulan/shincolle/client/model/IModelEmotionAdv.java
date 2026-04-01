package com.lulan.shincolle.client.model;

import com.lulan.shincolle.entity.IShipEmotion;

public interface IModelEmotionAdv
extends IModelEmotion {
    void setMouth(int var1);

    void setFlush(boolean var1);

    void setFaceNormal(IShipEmotion var1);

    void setFaceBlink0(IShipEmotion var1);

    void setFaceBlink1(IShipEmotion var1);

    void setFaceCry(IShipEmotion var1);

    void setFaceAttack(IShipEmotion var1);

    void setFaceDamaged(IShipEmotion var1);

    void setFaceHungry(IShipEmotion var1);

    void setFaceAngry(IShipEmotion var1);

    void setFaceScorn(IShipEmotion var1);

    void setFaceBored(IShipEmotion var1);

    void setFaceShy(IShipEmotion var1);

    void setFaceHappy(IShipEmotion var1);
}
