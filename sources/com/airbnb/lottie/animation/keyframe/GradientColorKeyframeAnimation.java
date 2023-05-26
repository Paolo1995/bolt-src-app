package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {

    /* renamed from: i  reason: collision with root package name */
    private final GradientColor f9190i;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        GradientColor gradientColor = list.get(0).f9661b;
        int c8 = gradientColor != null ? gradientColor.c() : 0;
        this.f9190i = new GradientColor(new float[c8], new int[c8]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public GradientColor i(Keyframe<GradientColor> keyframe, float f8) {
        this.f9190i.d(keyframe.f9661b, keyframe.f9662c, f8);
        return this.f9190i;
    }
}
