package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

/* loaded from: classes.dex */
public class TransformKeyframeAnimation {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f9215a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f9216b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f9217c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f9218d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f9219e;

    /* renamed from: f  reason: collision with root package name */
    private BaseKeyframeAnimation<PointF, PointF> f9220f;

    /* renamed from: g  reason: collision with root package name */
    private BaseKeyframeAnimation<?, PointF> f9221g;

    /* renamed from: h  reason: collision with root package name */
    private BaseKeyframeAnimation<ScaleXY, ScaleXY> f9222h;

    /* renamed from: i  reason: collision with root package name */
    private BaseKeyframeAnimation<Float, Float> f9223i;

    /* renamed from: j  reason: collision with root package name */
    private BaseKeyframeAnimation<Integer, Integer> f9224j;

    /* renamed from: k  reason: collision with root package name */
    private FloatKeyframeAnimation f9225k;

    /* renamed from: l  reason: collision with root package name */
    private FloatKeyframeAnimation f9226l;

    /* renamed from: m  reason: collision with root package name */
    private BaseKeyframeAnimation<?, Float> f9227m;

    /* renamed from: n  reason: collision with root package name */
    private BaseKeyframeAnimation<?, Float> f9228n;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        BaseKeyframeAnimation<PointF, PointF> a8;
        BaseKeyframeAnimation<PointF, PointF> a9;
        BaseKeyframeAnimation<ScaleXY, ScaleXY> a10;
        BaseKeyframeAnimation<Float, Float> a11;
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        if (animatableTransform.c() == null) {
            a8 = null;
        } else {
            a8 = animatableTransform.c().a();
        }
        this.f9220f = a8;
        if (animatableTransform.f() == null) {
            a9 = null;
        } else {
            a9 = animatableTransform.f().a();
        }
        this.f9221g = a9;
        if (animatableTransform.h() == null) {
            a10 = null;
        } else {
            a10 = animatableTransform.h().a();
        }
        this.f9222h = a10;
        if (animatableTransform.g() == null) {
            a11 = null;
        } else {
            a11 = animatableTransform.g().a();
        }
        this.f9223i = a11;
        if (animatableTransform.i() == null) {
            floatKeyframeAnimation = null;
        } else {
            floatKeyframeAnimation = (FloatKeyframeAnimation) animatableTransform.i().a();
        }
        this.f9225k = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.f9216b = new Matrix();
            this.f9217c = new Matrix();
            this.f9218d = new Matrix();
            this.f9219e = new float[9];
        } else {
            this.f9216b = null;
            this.f9217c = null;
            this.f9218d = null;
            this.f9219e = null;
        }
        if (animatableTransform.j() == null) {
            floatKeyframeAnimation2 = null;
        } else {
            floatKeyframeAnimation2 = (FloatKeyframeAnimation) animatableTransform.j().a();
        }
        this.f9226l = floatKeyframeAnimation2;
        if (animatableTransform.e() != null) {
            this.f9224j = animatableTransform.e().a();
        }
        if (animatableTransform.k() != null) {
            this.f9227m = animatableTransform.k().a();
        } else {
            this.f9227m = null;
        }
        if (animatableTransform.d() != null) {
            this.f9228n = animatableTransform.d().a();
        } else {
            this.f9228n = null;
        }
    }

    private void d() {
        for (int i8 = 0; i8 < 9; i8++) {
            this.f9219e[i8] = 0.0f;
        }
    }

    public void a(BaseLayer baseLayer) {
        baseLayer.i(this.f9224j);
        baseLayer.i(this.f9227m);
        baseLayer.i(this.f9228n);
        baseLayer.i(this.f9220f);
        baseLayer.i(this.f9221g);
        baseLayer.i(this.f9222h);
        baseLayer.i(this.f9223i);
        baseLayer.i(this.f9225k);
        baseLayer.i(this.f9226l);
    }

    public void b(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f9224j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.a(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f9227m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f9228n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.a(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f9220f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.a(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f9221g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.a(animationListener);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.f9222h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.a(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f9223i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.a(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f9225k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.a(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f9226l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.a(animationListener);
        }
    }

    public <T> boolean c(T t7, LottieValueCallback<T> lottieValueCallback) {
        if (t7 == LottieProperty.f8937f) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation = this.f9220f;
            if (baseKeyframeAnimation == null) {
                this.f9220f = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation.n(lottieValueCallback);
            return true;
        } else if (t7 == LottieProperty.f8938g) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.f9221g;
            if (baseKeyframeAnimation2 == null) {
                this.f9221g = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation2.n(lottieValueCallback);
            return true;
        } else {
            if (t7 == LottieProperty.f8939h) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation3 = this.f9221g;
                if (baseKeyframeAnimation3 instanceof SplitDimensionPathKeyframeAnimation) {
                    ((SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation3).r(lottieValueCallback);
                    return true;
                }
            }
            if (t7 == LottieProperty.f8940i) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.f9221g;
                if (baseKeyframeAnimation4 instanceof SplitDimensionPathKeyframeAnimation) {
                    ((SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation4).s(lottieValueCallback);
                    return true;
                }
            }
            if (t7 == LottieProperty.f8946o) {
                BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation5 = this.f9222h;
                if (baseKeyframeAnimation5 == null) {
                    this.f9222h = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                    return true;
                }
                baseKeyframeAnimation5.n(lottieValueCallback);
                return true;
            } else if (t7 == LottieProperty.f8947p) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.f9223i;
                if (baseKeyframeAnimation6 == null) {
                    this.f9223i = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(0.0f));
                    return true;
                }
                baseKeyframeAnimation6.n(lottieValueCallback);
                return true;
            } else if (t7 == LottieProperty.f8934c) {
                BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.f9224j;
                if (baseKeyframeAnimation7 == null) {
                    this.f9224j = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                    return true;
                }
                baseKeyframeAnimation7.n(lottieValueCallback);
                return true;
            } else if (t7 == LottieProperty.C) {
                BaseKeyframeAnimation<?, Float> baseKeyframeAnimation8 = this.f9227m;
                if (baseKeyframeAnimation8 == null) {
                    this.f9227m = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(100.0f));
                    return true;
                }
                baseKeyframeAnimation8.n(lottieValueCallback);
                return true;
            } else if (t7 == LottieProperty.D) {
                BaseKeyframeAnimation<?, Float> baseKeyframeAnimation9 = this.f9228n;
                if (baseKeyframeAnimation9 == null) {
                    this.f9228n = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(100.0f));
                    return true;
                }
                baseKeyframeAnimation9.n(lottieValueCallback);
                return true;
            } else if (t7 == LottieProperty.f8948q) {
                if (this.f9225k == null) {
                    this.f9225k = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                }
                this.f9225k.n(lottieValueCallback);
                return true;
            } else if (t7 == LottieProperty.f8949r) {
                if (this.f9226l == null) {
                    this.f9226l = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                }
                this.f9226l.n(lottieValueCallback);
                return true;
            } else {
                return false;
            }
        }
    }

    public BaseKeyframeAnimation<?, Float> e() {
        return this.f9228n;
    }

    public Matrix f() {
        float cos;
        float sin;
        float p8;
        PointF h8;
        this.f9215a.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f9221g;
        if (baseKeyframeAnimation != null && (h8 = baseKeyframeAnimation.h()) != null) {
            float f8 = h8.x;
            if (f8 != 0.0f || h8.y != 0.0f) {
                this.f9215a.preTranslate(f8, h8.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f9223i;
        if (baseKeyframeAnimation2 != null) {
            if (baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation) {
                p8 = baseKeyframeAnimation2.h().floatValue();
            } else {
                p8 = ((FloatKeyframeAnimation) baseKeyframeAnimation2).p();
            }
            if (p8 != 0.0f) {
                this.f9215a.preRotate(p8);
            }
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f9225k;
        if (floatKeyframeAnimation != null) {
            FloatKeyframeAnimation floatKeyframeAnimation2 = this.f9226l;
            if (floatKeyframeAnimation2 == null) {
                cos = 0.0f;
            } else {
                cos = (float) Math.cos(Math.toRadians((-floatKeyframeAnimation2.p()) + 90.0f));
            }
            FloatKeyframeAnimation floatKeyframeAnimation3 = this.f9226l;
            if (floatKeyframeAnimation3 == null) {
                sin = 1.0f;
            } else {
                sin = (float) Math.sin(Math.toRadians((-floatKeyframeAnimation3.p()) + 90.0f));
            }
            float tan = (float) Math.tan(Math.toRadians(floatKeyframeAnimation.p()));
            d();
            float[] fArr = this.f9219e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f9 = -sin;
            fArr[3] = f9;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f9216b.setValues(fArr);
            d();
            float[] fArr2 = this.f9219e;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f9217c.setValues(fArr2);
            d();
            float[] fArr3 = this.f9219e;
            fArr3[0] = cos;
            fArr3[1] = f9;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f9218d.setValues(fArr3);
            this.f9217c.preConcat(this.f9216b);
            this.f9218d.preConcat(this.f9217c);
            this.f9215a.preConcat(this.f9218d);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3 = this.f9222h;
        if (baseKeyframeAnimation3 != null) {
            ScaleXY h9 = baseKeyframeAnimation3.h();
            if (h9.b() != 1.0f || h9.c() != 1.0f) {
                this.f9215a.preScale(h9.b(), h9.c());
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f9220f;
        if (baseKeyframeAnimation4 != null) {
            PointF h10 = baseKeyframeAnimation4.h();
            float f10 = h10.x;
            if (f10 != 0.0f || h10.y != 0.0f) {
                this.f9215a.preTranslate(-f10, -h10.y);
            }
        }
        return this.f9215a;
    }

    public Matrix g(float f8) {
        PointF h8;
        ScaleXY h9;
        float f9;
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f9221g;
        PointF pointF = null;
        if (baseKeyframeAnimation == null) {
            h8 = null;
        } else {
            h8 = baseKeyframeAnimation.h();
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.f9222h;
        if (baseKeyframeAnimation2 == null) {
            h9 = null;
        } else {
            h9 = baseKeyframeAnimation2.h();
        }
        this.f9215a.reset();
        if (h8 != null) {
            this.f9215a.preTranslate(h8.x * f8, h8.y * f8);
        }
        if (h9 != null) {
            double d8 = f8;
            this.f9215a.preScale((float) Math.pow(h9.b(), d8), (float) Math.pow(h9.c(), d8));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.f9223i;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.h().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f9220f;
            if (baseKeyframeAnimation4 != null) {
                pointF = baseKeyframeAnimation4.h();
            }
            Matrix matrix = this.f9215a;
            float f10 = floatValue * f8;
            float f11 = 0.0f;
            if (pointF == null) {
                f9 = 0.0f;
            } else {
                f9 = pointF.x;
            }
            if (pointF != null) {
                f11 = pointF.y;
            }
            matrix.preRotate(f10, f9, f11);
        }
        return this.f9215a;
    }

    public BaseKeyframeAnimation<?, Integer> h() {
        return this.f9224j;
    }

    public BaseKeyframeAnimation<?, Float> i() {
        return this.f9227m;
    }

    public void j(float f8) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f9224j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.m(f8);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f9227m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.m(f8);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f9228n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.m(f8);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.f9220f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.m(f8);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f9221g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.m(f8);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.f9222h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.m(f8);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f9223i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.m(f8);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f9225k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.m(f8);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f9226l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.m(f8);
        }
    }
}
