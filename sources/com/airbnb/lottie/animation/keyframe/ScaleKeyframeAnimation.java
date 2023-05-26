package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

/* loaded from: classes.dex */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {

    /* renamed from: i  reason: collision with root package name */
    private final ScaleXY f9201i;

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
        this.f9201i = new ScaleXY();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public ScaleXY i(Keyframe<ScaleXY> keyframe, float f8) {
        ScaleXY scaleXY;
        ScaleXY scaleXY2;
        ScaleXY scaleXY3 = keyframe.f9661b;
        if (scaleXY3 != null && (scaleXY = keyframe.f9662c) != null) {
            ScaleXY scaleXY4 = scaleXY3;
            ScaleXY scaleXY5 = scaleXY;
            LottieValueCallback<A> lottieValueCallback = this.f9171e;
            if (lottieValueCallback != 0 && (scaleXY2 = (ScaleXY) lottieValueCallback.b(keyframe.f9666g, keyframe.f9667h.floatValue(), scaleXY4, scaleXY5, f8, e(), f())) != null) {
                return scaleXY2;
            }
            this.f9201i.d(MiscUtils.i(scaleXY4.b(), scaleXY5.b(), f8), MiscUtils.i(scaleXY4.c(), scaleXY5.c(), f8));
            return this.f9201i;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
