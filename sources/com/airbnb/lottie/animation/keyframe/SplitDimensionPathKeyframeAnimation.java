package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

/* loaded from: classes.dex */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f9205i;

    /* renamed from: j  reason: collision with root package name */
    private final PointF f9206j;

    /* renamed from: k  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f9207k;

    /* renamed from: l  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f9208l;

    /* renamed from: m  reason: collision with root package name */
    protected LottieValueCallback<Float> f9209m;

    /* renamed from: n  reason: collision with root package name */
    protected LottieValueCallback<Float> f9210n;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.f9205i = new PointF();
        this.f9206j = new PointF();
        this.f9207k = baseKeyframeAnimation;
        this.f9208l = baseKeyframeAnimation2;
        m(f());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void m(float f8) {
        this.f9207k.m(f8);
        this.f9208l.m(f8);
        this.f9205i.set(this.f9207k.h().floatValue(), this.f9208l.h().floatValue());
        for (int i8 = 0; i8 < this.f9167a.size(); i8++) {
            this.f9167a.get(i8).a();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: p */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: q */
    public PointF i(Keyframe<PointF> keyframe, float f8) {
        Float f9;
        Keyframe<Float> b8;
        float floatValue;
        Keyframe<Float> b9;
        float floatValue2;
        Float f10 = null;
        if (this.f9209m != null && (b9 = this.f9207k.b()) != null) {
            float d8 = this.f9207k.d();
            Float f11 = b9.f9667h;
            LottieValueCallback<Float> lottieValueCallback = this.f9209m;
            float f12 = b9.f9666g;
            if (f11 == null) {
                floatValue2 = f12;
            } else {
                floatValue2 = f11.floatValue();
            }
            f9 = lottieValueCallback.b(f12, floatValue2, b9.f9661b, b9.f9662c, f8, f8, d8);
        } else {
            f9 = null;
        }
        if (this.f9210n != null && (b8 = this.f9208l.b()) != null) {
            float d9 = this.f9208l.d();
            Float f13 = b8.f9667h;
            LottieValueCallback<Float> lottieValueCallback2 = this.f9210n;
            float f14 = b8.f9666g;
            if (f13 == null) {
                floatValue = f14;
            } else {
                floatValue = f13.floatValue();
            }
            f10 = lottieValueCallback2.b(f14, floatValue, b8.f9661b, b8.f9662c, f8, f8, d9);
        }
        if (f9 == null) {
            this.f9206j.set(this.f9205i.x, 0.0f);
        } else {
            this.f9206j.set(f9.floatValue(), 0.0f);
        }
        if (f10 == null) {
            PointF pointF = this.f9206j;
            pointF.set(pointF.x, this.f9205i.y);
        } else {
            PointF pointF2 = this.f9206j;
            pointF2.set(pointF2.x, f10.floatValue());
        }
        return this.f9206j;
    }

    public void r(LottieValueCallback<Float> lottieValueCallback) {
        LottieValueCallback<Float> lottieValueCallback2 = this.f9209m;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.c(null);
        }
        this.f9209m = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.c(this);
        }
    }

    public void s(LottieValueCallback<Float> lottieValueCallback) {
        LottieValueCallback<Float> lottieValueCallback2 = this.f9210n;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.c(null);
        }
        this.f9210n = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.c(this);
        }
    }
}
