package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;

/* loaded from: classes.dex */
public class Keyframe<T> {

    /* renamed from: a  reason: collision with root package name */
    private final LottieComposition f9660a;

    /* renamed from: b  reason: collision with root package name */
    public final T f9661b;

    /* renamed from: c  reason: collision with root package name */
    public T f9662c;

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f9663d;

    /* renamed from: e  reason: collision with root package name */
    public final Interpolator f9664e;

    /* renamed from: f  reason: collision with root package name */
    public final Interpolator f9665f;

    /* renamed from: g  reason: collision with root package name */
    public final float f9666g;

    /* renamed from: h  reason: collision with root package name */
    public Float f9667h;

    /* renamed from: i  reason: collision with root package name */
    private float f9668i;

    /* renamed from: j  reason: collision with root package name */
    private float f9669j;

    /* renamed from: k  reason: collision with root package name */
    private int f9670k;

    /* renamed from: l  reason: collision with root package name */
    private int f9671l;

    /* renamed from: m  reason: collision with root package name */
    private float f9672m;

    /* renamed from: n  reason: collision with root package name */
    private float f9673n;

    /* renamed from: o  reason: collision with root package name */
    public PointF f9674o;

    /* renamed from: p  reason: collision with root package name */
    public PointF f9675p;

    public Keyframe(LottieComposition lottieComposition, T t7, T t8, Interpolator interpolator, float f8, Float f9) {
        this.f9668i = -3987645.8f;
        this.f9669j = -3987645.8f;
        this.f9670k = 784923401;
        this.f9671l = 784923401;
        this.f9672m = Float.MIN_VALUE;
        this.f9673n = Float.MIN_VALUE;
        this.f9674o = null;
        this.f9675p = null;
        this.f9660a = lottieComposition;
        this.f9661b = t7;
        this.f9662c = t8;
        this.f9663d = interpolator;
        this.f9664e = null;
        this.f9665f = null;
        this.f9666g = f8;
        this.f9667h = f9;
    }

    public boolean a(float f8) {
        if (f8 >= e() && f8 < b()) {
            return true;
        }
        return false;
    }

    public float b() {
        if (this.f9660a == null) {
            return 1.0f;
        }
        if (this.f9673n == Float.MIN_VALUE) {
            if (this.f9667h == null) {
                this.f9673n = 1.0f;
            } else {
                this.f9673n = e() + ((this.f9667h.floatValue() - this.f9666g) / this.f9660a.e());
            }
        }
        return this.f9673n;
    }

    public float c() {
        if (this.f9669j == -3987645.8f) {
            this.f9669j = ((Float) this.f9662c).floatValue();
        }
        return this.f9669j;
    }

    public int d() {
        if (this.f9671l == 784923401) {
            this.f9671l = ((Integer) this.f9662c).intValue();
        }
        return this.f9671l;
    }

    public float e() {
        LottieComposition lottieComposition = this.f9660a;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.f9672m == Float.MIN_VALUE) {
            this.f9672m = (this.f9666g - lottieComposition.p()) / this.f9660a.e();
        }
        return this.f9672m;
    }

    public float f() {
        if (this.f9668i == -3987645.8f) {
            this.f9668i = ((Float) this.f9661b).floatValue();
        }
        return this.f9668i;
    }

    public int g() {
        if (this.f9670k == 784923401) {
            this.f9670k = ((Integer) this.f9661b).intValue();
        }
        return this.f9670k;
    }

    public boolean h() {
        if (this.f9663d == null && this.f9664e == null && this.f9665f == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f9661b + ", endValue=" + this.f9662c + ", startFrame=" + this.f9666g + ", endFrame=" + this.f9667h + ", interpolator=" + this.f9663d + '}';
    }

    public Keyframe(LottieComposition lottieComposition, T t7, T t8, Interpolator interpolator, Interpolator interpolator2, float f8, Float f9) {
        this.f9668i = -3987645.8f;
        this.f9669j = -3987645.8f;
        this.f9670k = 784923401;
        this.f9671l = 784923401;
        this.f9672m = Float.MIN_VALUE;
        this.f9673n = Float.MIN_VALUE;
        this.f9674o = null;
        this.f9675p = null;
        this.f9660a = lottieComposition;
        this.f9661b = t7;
        this.f9662c = t8;
        this.f9663d = null;
        this.f9664e = interpolator;
        this.f9665f = interpolator2;
        this.f9666g = f8;
        this.f9667h = f9;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Keyframe(LottieComposition lottieComposition, T t7, T t8, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f8, Float f9) {
        this.f9668i = -3987645.8f;
        this.f9669j = -3987645.8f;
        this.f9670k = 784923401;
        this.f9671l = 784923401;
        this.f9672m = Float.MIN_VALUE;
        this.f9673n = Float.MIN_VALUE;
        this.f9674o = null;
        this.f9675p = null;
        this.f9660a = lottieComposition;
        this.f9661b = t7;
        this.f9662c = t8;
        this.f9663d = interpolator;
        this.f9664e = interpolator2;
        this.f9665f = interpolator3;
        this.f9666g = f8;
        this.f9667h = f9;
    }

    public Keyframe(T t7) {
        this.f9668i = -3987645.8f;
        this.f9669j = -3987645.8f;
        this.f9670k = 784923401;
        this.f9671l = 784923401;
        this.f9672m = Float.MIN_VALUE;
        this.f9673n = Float.MIN_VALUE;
        this.f9674o = null;
        this.f9675p = null;
        this.f9660a = null;
        this.f9661b = t7;
        this.f9662c = t7;
        this.f9663d = null;
        this.f9664e = null;
        this.f9665f = null;
        this.f9666g = Float.MIN_VALUE;
        this.f9667h = Float.valueOf(Float.MAX_VALUE);
    }
}
