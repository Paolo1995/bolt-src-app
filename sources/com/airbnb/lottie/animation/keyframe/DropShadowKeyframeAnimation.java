package com.airbnb.lottie.animation.keyframe;

import android.graphics.Color;
import android.graphics.Paint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes.dex */
public class DropShadowKeyframeAnimation implements BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private final BaseKeyframeAnimation.AnimationListener f9181a;

    /* renamed from: b  reason: collision with root package name */
    private final BaseKeyframeAnimation<Integer, Integer> f9182b;

    /* renamed from: c  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f9183c;

    /* renamed from: d  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f9184d;

    /* renamed from: e  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f9185e;

    /* renamed from: f  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f9186f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9187g = true;

    public DropShadowKeyframeAnimation(BaseKeyframeAnimation.AnimationListener animationListener, BaseLayer baseLayer, DropShadowEffect dropShadowEffect) {
        this.f9181a = animationListener;
        BaseKeyframeAnimation<Integer, Integer> a8 = dropShadowEffect.a().a();
        this.f9182b = a8;
        a8.a(this);
        baseLayer.i(a8);
        BaseKeyframeAnimation<Float, Float> a9 = dropShadowEffect.d().a();
        this.f9183c = a9;
        a9.a(this);
        baseLayer.i(a9);
        BaseKeyframeAnimation<Float, Float> a10 = dropShadowEffect.b().a();
        this.f9184d = a10;
        a10.a(this);
        baseLayer.i(a10);
        BaseKeyframeAnimation<Float, Float> a11 = dropShadowEffect.c().a();
        this.f9185e = a11;
        a11.a(this);
        baseLayer.i(a11);
        BaseKeyframeAnimation<Float, Float> a12 = dropShadowEffect.e().a();
        this.f9186f = a12;
        a12.a(this);
        baseLayer.i(a12);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f9187g = true;
        this.f9181a.a();
    }

    public void b(Paint paint) {
        if (!this.f9187g) {
            return;
        }
        this.f9187g = false;
        double floatValue = this.f9184d.h().floatValue() * 0.017453292519943295d;
        float floatValue2 = this.f9185e.h().floatValue();
        float sin = ((float) Math.sin(floatValue)) * floatValue2;
        float cos = ((float) Math.cos(floatValue + 3.141592653589793d)) * floatValue2;
        int intValue = this.f9182b.h().intValue();
        paint.setShadowLayer(this.f9186f.h().floatValue(), sin, cos, Color.argb(Math.round(this.f9183c.h().floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
    }

    public void c(LottieValueCallback<Integer> lottieValueCallback) {
        this.f9182b.n(lottieValueCallback);
    }

    public void d(LottieValueCallback<Float> lottieValueCallback) {
        this.f9184d.n(lottieValueCallback);
    }

    public void e(LottieValueCallback<Float> lottieValueCallback) {
        this.f9185e.n(lottieValueCallback);
    }

    public void f(final LottieValueCallback<Float> lottieValueCallback) {
        if (lottieValueCallback == null) {
            this.f9183c.n(null);
        } else {
            this.f9183c.n(new LottieValueCallback<Float>() { // from class: com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation.1
                @Override // com.airbnb.lottie.value.LottieValueCallback
                /* renamed from: d */
                public Float a(LottieFrameInfo<Float> lottieFrameInfo) {
                    Float f8 = (Float) lottieValueCallback.a(lottieFrameInfo);
                    if (f8 == null) {
                        return null;
                    }
                    return Float.valueOf(f8.floatValue() * 2.55f);
                }
            });
        }
    }

    public void g(LottieValueCallback<Float> lottieValueCallback) {
        this.f9186f.n(lottieValueCallback);
    }
}
