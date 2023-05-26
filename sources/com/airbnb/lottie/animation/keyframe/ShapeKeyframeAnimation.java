package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.animation.content.ShapeModifierContent;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes.dex */
public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {

    /* renamed from: i  reason: collision with root package name */
    private final ShapeData f9202i;

    /* renamed from: j  reason: collision with root package name */
    private final Path f9203j;

    /* renamed from: k  reason: collision with root package name */
    private List<ShapeModifierContent> f9204k;

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
        this.f9202i = new ShapeData();
        this.f9203j = new Path();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public Path i(Keyframe<ShapeData> keyframe, float f8) {
        this.f9202i.c(keyframe.f9661b, keyframe.f9662c, f8);
        ShapeData shapeData = this.f9202i;
        List<ShapeModifierContent> list = this.f9204k;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                shapeData = this.f9204k.get(size).c(shapeData);
            }
        }
        MiscUtils.h(shapeData, this.f9203j);
        return this.f9203j;
    }

    public void q(List<ShapeModifierContent> list) {
        this.f9204k = list;
    }
}
