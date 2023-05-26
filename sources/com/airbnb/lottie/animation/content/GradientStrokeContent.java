package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes.dex */
public class GradientStrokeContent extends BaseStrokeContent {
    private final BaseKeyframeAnimation<PointF, PointF> A;
    private ValueCallbackKeyframeAnimation B;

    /* renamed from: r  reason: collision with root package name */
    private final String f9091r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f9092s;

    /* renamed from: t  reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f9093t;

    /* renamed from: u  reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f9094u;

    /* renamed from: v  reason: collision with root package name */
    private final RectF f9095v;

    /* renamed from: w  reason: collision with root package name */
    private final GradientType f9096w;

    /* renamed from: x  reason: collision with root package name */
    private final int f9097x;

    /* renamed from: y  reason: collision with root package name */
    private final BaseKeyframeAnimation<GradientColor, GradientColor> f9098y;

    /* renamed from: z  reason: collision with root package name */
    private final BaseKeyframeAnimation<PointF, PointF> f9099z;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.b().a(), gradientStroke.g().a(), gradientStroke.i(), gradientStroke.k(), gradientStroke.m(), gradientStroke.h(), gradientStroke.c());
        this.f9093t = new LongSparseArray<>();
        this.f9094u = new LongSparseArray<>();
        this.f9095v = new RectF();
        this.f9091r = gradientStroke.j();
        this.f9096w = gradientStroke.f();
        this.f9092s = gradientStroke.n();
        this.f9097x = (int) (lottieDrawable.G().d() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> a8 = gradientStroke.e().a();
        this.f9098y = a8;
        a8.a(this);
        baseLayer.i(a8);
        BaseKeyframeAnimation<PointF, PointF> a9 = gradientStroke.l().a();
        this.f9099z = a9;
        a9.a(this);
        baseLayer.i(a9);
        BaseKeyframeAnimation<PointF, PointF> a10 = gradientStroke.d().a();
        this.A = a10;
        a10.a(this);
        baseLayer.i(a10);
    }

    private int[] j(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.B;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.h();
            int i8 = 0;
            if (iArr.length == numArr.length) {
                while (i8 < iArr.length) {
                    iArr[i8] = numArr[i8].intValue();
                    i8++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i8 < numArr.length) {
                    iArr[i8] = numArr[i8].intValue();
                    i8++;
                }
            }
        }
        return iArr;
    }

    private int k() {
        int i8;
        int round = Math.round(this.f9099z.f() * this.f9097x);
        int round2 = Math.round(this.A.f() * this.f9097x);
        int round3 = Math.round(this.f9098y.f() * this.f9097x);
        if (round != 0) {
            i8 = 527 * round;
        } else {
            i8 = 17;
        }
        if (round2 != 0) {
            i8 = i8 * 31 * round2;
        }
        if (round3 != 0) {
            return i8 * 31 * round3;
        }
        return i8;
    }

    private LinearGradient l() {
        long k8 = k();
        LinearGradient f8 = this.f9093t.f(k8);
        if (f8 != null) {
            return f8;
        }
        PointF h8 = this.f9099z.h();
        PointF h9 = this.A.h();
        GradientColor h10 = this.f9098y.h();
        LinearGradient linearGradient = new LinearGradient(h8.x, h8.y, h9.x, h9.y, j(h10.a()), h10.b(), Shader.TileMode.CLAMP);
        this.f9093t.l(k8, linearGradient);
        return linearGradient;
    }

    private RadialGradient m() {
        float f8;
        float f9;
        long k8 = k();
        RadialGradient f10 = this.f9094u.f(k8);
        if (f10 != null) {
            return f10;
        }
        PointF h8 = this.f9099z.h();
        PointF h9 = this.A.h();
        GradientColor h10 = this.f9098y.h();
        int[] j8 = j(h10.a());
        float[] b8 = h10.b();
        RadialGradient radialGradient = new RadialGradient(h8.x, h8.y, (float) Math.hypot(h9.x - f8, h9.y - f9), j8, b8, Shader.TileMode.CLAMP);
        this.f9094u.l(k8, radialGradient);
        return radialGradient;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        super.d(t7, lottieValueCallback);
        if (t7 == LottieProperty.L) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.B;
            if (valueCallbackKeyframeAnimation != null) {
                this.f9023f.G(valueCallbackKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.B = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.B = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            this.f9023f.i(this.B);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f9091r;
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void h(Canvas canvas, Matrix matrix, int i8) {
        Shader m8;
        if (this.f9092s) {
            return;
        }
        f(this.f9095v, matrix, false);
        if (this.f9096w == GradientType.LINEAR) {
            m8 = l();
        } else {
            m8 = m();
        }
        m8.setLocalMatrix(matrix);
        this.f9026i.setShader(m8);
        super.h(canvas, matrix, i8);
    }
}
