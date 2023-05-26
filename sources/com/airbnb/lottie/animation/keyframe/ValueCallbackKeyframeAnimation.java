package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

/* loaded from: classes.dex */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {

    /* renamed from: i  reason: collision with root package name */
    private final A f9229i;

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback) {
        this(lottieValueCallback, null);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    float c() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public A h() {
        LottieValueCallback<A> lottieValueCallback = this.f9171e;
        A a8 = this.f9229i;
        return lottieValueCallback.b(0.0f, 0.0f, a8, a8, f(), f(), f());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    A i(Keyframe<K> keyframe, float f8) {
        return h();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void k() {
        if (this.f9171e != null) {
            super.k();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void m(float f8) {
        this.f9170d = f8;
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback, A a8) {
        super(Collections.emptyList());
        n(lottieValueCallback);
        this.f9229i = a8;
    }
}
