package com.airbnb.lottie.value;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

/* loaded from: classes.dex */
public class LottieValueCallback<T> {

    /* renamed from: a  reason: collision with root package name */
    private final LottieFrameInfo<T> f9683a;

    /* renamed from: b  reason: collision with root package name */
    private BaseKeyframeAnimation<?, ?> f9684b;

    /* renamed from: c  reason: collision with root package name */
    protected T f9685c;

    public LottieValueCallback() {
        this.f9683a = new LottieFrameInfo<>();
        this.f9685c = null;
    }

    public T a(LottieFrameInfo<T> lottieFrameInfo) {
        return this.f9685c;
    }

    public final T b(float f8, float f9, T t7, T t8, float f10, float f11, float f12) {
        return a(this.f9683a.h(f8, f9, t7, t8, f10, f11, f12));
    }

    public final void c(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.f9684b = baseKeyframeAnimation;
    }

    public LottieValueCallback(T t7) {
        this.f9683a = new LottieFrameInfo<>();
        this.f9685c = t7;
    }
}
