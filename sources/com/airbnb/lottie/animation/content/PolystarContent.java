package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: b  reason: collision with root package name */
    private final String f9108b;

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f9109c;

    /* renamed from: d  reason: collision with root package name */
    private final PolystarShape.Type f9110d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f9111e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f9112f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f9113g;

    /* renamed from: h  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f9114h;

    /* renamed from: i  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f9115i;

    /* renamed from: j  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f9116j;

    /* renamed from: k  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f9117k;

    /* renamed from: l  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f9118l;

    /* renamed from: m  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f9119m;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9121o;

    /* renamed from: a  reason: collision with root package name */
    private final Path f9107a = new Path();

    /* renamed from: n  reason: collision with root package name */
    private final CompoundTrimPathContent f9120n = new CompoundTrimPathContent();

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9122a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f9122a = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9122a[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.f9109c = lottieDrawable;
        this.f9108b = polystarShape.d();
        PolystarShape.Type j8 = polystarShape.j();
        this.f9110d = j8;
        this.f9111e = polystarShape.k();
        this.f9112f = polystarShape.l();
        BaseKeyframeAnimation<Float, Float> a8 = polystarShape.g().a();
        this.f9113g = a8;
        BaseKeyframeAnimation<PointF, PointF> a9 = polystarShape.h().a();
        this.f9114h = a9;
        BaseKeyframeAnimation<Float, Float> a10 = polystarShape.i().a();
        this.f9115i = a10;
        BaseKeyframeAnimation<Float, Float> a11 = polystarShape.e().a();
        this.f9117k = a11;
        BaseKeyframeAnimation<Float, Float> a12 = polystarShape.f().a();
        this.f9119m = a12;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (j8 == type) {
            this.f9116j = polystarShape.b().a();
            this.f9118l = polystarShape.c().a();
        } else {
            this.f9116j = null;
            this.f9118l = null;
        }
        baseLayer.i(a8);
        baseLayer.i(a9);
        baseLayer.i(a10);
        baseLayer.i(a11);
        baseLayer.i(a12);
        if (j8 == type) {
            baseLayer.i(this.f9116j);
            baseLayer.i(this.f9118l);
        }
        a8.a(this);
        a9.a(this);
        a10.a(this);
        a11.a(this);
        a12.a(this);
        if (j8 == type) {
            this.f9116j.a(this);
            this.f9118l.a(this);
        }
    }

    private void g() {
        double floatValue;
        double d8;
        double d9;
        double d10;
        int i8;
        int floor = (int) Math.floor(this.f9113g.h().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f9115i;
        if (baseKeyframeAnimation == null) {
            floatValue = 0.0d;
        } else {
            floatValue = baseKeyframeAnimation.h().floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d11 = floor;
        float floatValue2 = this.f9119m.h().floatValue() / 100.0f;
        float floatValue3 = this.f9117k.h().floatValue();
        double d12 = floatValue3;
        float cos = (float) (Math.cos(radians) * d12);
        float sin = (float) (Math.sin(radians) * d12);
        this.f9107a.moveTo(cos, sin);
        double d13 = (float) (6.283185307179586d / d11);
        double d14 = radians + d13;
        double ceil = Math.ceil(d11);
        int i9 = 0;
        while (i9 < ceil) {
            float cos2 = (float) (Math.cos(d14) * d12);
            double d15 = ceil;
            float sin2 = (float) (d12 * Math.sin(d14));
            if (floatValue2 != 0.0f) {
                d9 = d12;
                i8 = i9;
                d8 = d14;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                d10 = d13;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f8 = floatValue3 * floatValue2 * 0.25f;
                this.f9107a.cubicTo(cos - (cos3 * f8), sin - (((float) Math.sin(atan2)) * f8), cos2 + (((float) Math.cos(atan22)) * f8), sin2 + (f8 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d8 = d14;
                d9 = d12;
                d10 = d13;
                i8 = i9;
                this.f9107a.lineTo(cos2, sin2);
            }
            d14 = d8 + d10;
            i9 = i8 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d15;
            d12 = d9;
            d13 = d10;
        }
        PointF h8 = this.f9114h.h();
        this.f9107a.offset(h8.x, h8.y);
        this.f9107a.close();
    }

    private void i() {
        double floatValue;
        float f8;
        float f9;
        double d8;
        int i8;
        double d9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        double d10;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23;
        float floatValue2 = this.f9113g.h().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f9115i;
        if (baseKeyframeAnimation == null) {
            floatValue = 0.0d;
        } else {
            floatValue = baseKeyframeAnimation.h().floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d11 = floatValue2;
        float f24 = (float) (6.283185307179586d / d11);
        if (this.f9112f) {
            f24 *= -1.0f;
        }
        float f25 = f24 / 2.0f;
        float f26 = floatValue2 - ((int) floatValue2);
        int i9 = (f26 > 0.0f ? 1 : (f26 == 0.0f ? 0 : -1));
        if (i9 != 0) {
            radians += (1.0f - f26) * f25;
        }
        float floatValue3 = this.f9117k.h().floatValue();
        float floatValue4 = this.f9116j.h().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f9118l;
        if (baseKeyframeAnimation2 != null) {
            f8 = baseKeyframeAnimation2.h().floatValue() / 100.0f;
        } else {
            f8 = 0.0f;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f9119m;
        if (baseKeyframeAnimation3 != null) {
            f9 = baseKeyframeAnimation3.h().floatValue() / 100.0f;
        } else {
            f9 = 0.0f;
        }
        if (i9 != 0) {
            f12 = ((floatValue3 - floatValue4) * f26) + floatValue4;
            i8 = i9;
            double d12 = f12;
            d8 = d11;
            f10 = (float) (d12 * Math.cos(radians));
            f11 = (float) (d12 * Math.sin(radians));
            this.f9107a.moveTo(f10, f11);
            d9 = radians + ((f24 * f26) / 2.0f);
        } else {
            d8 = d11;
            i8 = i9;
            double d13 = floatValue3;
            float cos = (float) (Math.cos(radians) * d13);
            float sin = (float) (d13 * Math.sin(radians));
            this.f9107a.moveTo(cos, sin);
            d9 = radians + f25;
            f10 = cos;
            f11 = sin;
            f12 = 0.0f;
        }
        double ceil = Math.ceil(d8) * 2.0d;
        int i10 = 0;
        boolean z7 = false;
        while (true) {
            double d14 = i10;
            if (d14 < ceil) {
                if (z7) {
                    f13 = floatValue3;
                } else {
                    f13 = floatValue4;
                }
                int i11 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
                if (i11 != 0 && d14 == ceil - 2.0d) {
                    f14 = f24;
                    f15 = (f24 * f26) / 2.0f;
                } else {
                    f14 = f24;
                    f15 = f25;
                }
                if (i11 != 0 && d14 == ceil - 1.0d) {
                    f16 = f25;
                    d10 = d14;
                    f17 = f12;
                } else {
                    f16 = f25;
                    d10 = d14;
                    f17 = f13;
                }
                double d15 = f17;
                double d16 = ceil;
                float cos2 = (float) (d15 * Math.cos(d9));
                float sin2 = (float) (d15 * Math.sin(d9));
                if (f8 == 0.0f && f9 == 0.0f) {
                    this.f9107a.lineTo(cos2, sin2);
                    f18 = f8;
                    f19 = f12;
                } else {
                    f18 = f8;
                    f19 = f12;
                    double atan2 = (float) (Math.atan2(f11, f10) - 1.5707963267948966d);
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    if (z7) {
                        f20 = f18;
                    } else {
                        f20 = f9;
                    }
                    if (z7) {
                        f21 = f9;
                    } else {
                        f21 = f18;
                    }
                    if (z7) {
                        f22 = floatValue4;
                    } else {
                        f22 = floatValue3;
                    }
                    if (z7) {
                        f23 = floatValue3;
                    } else {
                        f23 = floatValue4;
                    }
                    float f27 = f22 * f20 * 0.47829f;
                    float f28 = cos3 * f27;
                    float f29 = f27 * sin3;
                    float f30 = f23 * f21 * 0.47829f;
                    float f31 = cos4 * f30;
                    float f32 = f30 * sin4;
                    if (i8 != 0) {
                        if (i10 == 0) {
                            f28 *= f26;
                            f29 *= f26;
                        } else if (d10 == d16 - 1.0d) {
                            f31 *= f26;
                            f32 *= f26;
                        }
                    }
                    this.f9107a.cubicTo(f10 - f28, f11 - f29, cos2 + f31, sin2 + f32, cos2, sin2);
                }
                d9 += f15;
                z7 = !z7;
                i10++;
                f10 = cos2;
                f11 = sin2;
                f8 = f18;
                f12 = f19;
                f25 = f16;
                f24 = f14;
                ceil = d16;
            } else {
                PointF h8 = this.f9114h.h();
                this.f9107a.offset(h8.x, h8.y);
                this.f9107a.close();
                return;
            }
        }
    }

    private void j() {
        this.f9121o = false;
        this.f9109c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        j();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List<Content> list, List<Content> list2) {
        for (int i8 = 0; i8 < list.size(); i8++) {
            Content content = list.get(i8);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f9120n.a(trimPathContent);
                    trimPathContent.d(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t7 == LottieProperty.f8954w) {
            this.f9113g.n(lottieValueCallback);
        } else if (t7 == LottieProperty.f8955x) {
            this.f9115i.n(lottieValueCallback);
        } else if (t7 == LottieProperty.f8945n) {
            this.f9114h.n(lottieValueCallback);
        } else if (t7 == LottieProperty.f8956y && (baseKeyframeAnimation2 = this.f9116j) != null) {
            baseKeyframeAnimation2.n(lottieValueCallback);
        } else if (t7 == LottieProperty.f8957z) {
            this.f9117k.n(lottieValueCallback);
        } else if (t7 == LottieProperty.A && (baseKeyframeAnimation = this.f9118l) != null) {
            baseKeyframeAnimation.n(lottieValueCallback);
        } else if (t7 == LottieProperty.B) {
            this.f9119m.n(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.k(keyPath, i8, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f9108b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.f9121o) {
            return this.f9107a;
        }
        this.f9107a.reset();
        if (this.f9111e) {
            this.f9121o = true;
            return this.f9107a;
        }
        int i8 = AnonymousClass1.f9122a[this.f9110d.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                g();
            }
        } else {
            i();
        }
        this.f9107a.close();
        this.f9120n.b(this.f9107a);
        this.f9121o = true;
        return this.f9107a;
    }
}
