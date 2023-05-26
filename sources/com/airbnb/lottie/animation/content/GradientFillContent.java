package com.airbnb.lottie.animation.content;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GradientFillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f9070a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9071b;

    /* renamed from: c  reason: collision with root package name */
    private final BaseLayer f9072c;

    /* renamed from: d  reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f9073d = new LongSparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f9074e = new LongSparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private final Path f9075f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f9076g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f9077h;

    /* renamed from: i  reason: collision with root package name */
    private final List<PathContent> f9078i;

    /* renamed from: j  reason: collision with root package name */
    private final GradientType f9079j;

    /* renamed from: k  reason: collision with root package name */
    private final BaseKeyframeAnimation<GradientColor, GradientColor> f9080k;

    /* renamed from: l  reason: collision with root package name */
    private final BaseKeyframeAnimation<Integer, Integer> f9081l;

    /* renamed from: m  reason: collision with root package name */
    private final BaseKeyframeAnimation<PointF, PointF> f9082m;

    /* renamed from: n  reason: collision with root package name */
    private final BaseKeyframeAnimation<PointF, PointF> f9083n;

    /* renamed from: o  reason: collision with root package name */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f9084o;

    /* renamed from: p  reason: collision with root package name */
    private ValueCallbackKeyframeAnimation f9085p;

    /* renamed from: q  reason: collision with root package name */
    private final LottieDrawable f9086q;

    /* renamed from: r  reason: collision with root package name */
    private final int f9087r;

    /* renamed from: s  reason: collision with root package name */
    private BaseKeyframeAnimation<Float, Float> f9088s;

    /* renamed from: t  reason: collision with root package name */
    float f9089t;

    /* renamed from: u  reason: collision with root package name */
    private DropShadowKeyframeAnimation f9090u;

    public GradientFillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientFill gradientFill) {
        Path path = new Path();
        this.f9075f = path;
        this.f9076g = new LPaint(1);
        this.f9077h = new RectF();
        this.f9078i = new ArrayList();
        this.f9089t = 0.0f;
        this.f9072c = baseLayer;
        this.f9070a = gradientFill.f();
        this.f9071b = gradientFill.i();
        this.f9086q = lottieDrawable;
        this.f9079j = gradientFill.e();
        path.setFillType(gradientFill.c());
        this.f9087r = (int) (lottieDrawable.G().d() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> a8 = gradientFill.d().a();
        this.f9080k = a8;
        a8.a(this);
        baseLayer.i(a8);
        BaseKeyframeAnimation<Integer, Integer> a9 = gradientFill.g().a();
        this.f9081l = a9;
        a9.a(this);
        baseLayer.i(a9);
        BaseKeyframeAnimation<PointF, PointF> a10 = gradientFill.h().a();
        this.f9082m = a10;
        a10.a(this);
        baseLayer.i(a10);
        BaseKeyframeAnimation<PointF, PointF> a11 = gradientFill.b().a();
        this.f9083n = a11;
        a11.a(this);
        baseLayer.i(a11);
        if (baseLayer.v() != null) {
            BaseKeyframeAnimation<Float, Float> a12 = baseLayer.v().a().a();
            this.f9088s = a12;
            a12.a(this);
            baseLayer.i(this.f9088s);
        }
        if (baseLayer.x() != null) {
            this.f9090u = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.x());
        }
    }

    private int[] g(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f9085p;
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

    private int i() {
        int i8;
        int round = Math.round(this.f9082m.f() * this.f9087r);
        int round2 = Math.round(this.f9083n.f() * this.f9087r);
        int round3 = Math.round(this.f9080k.f() * this.f9087r);
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

    private LinearGradient j() {
        long i8 = i();
        LinearGradient f8 = this.f9073d.f(i8);
        if (f8 != null) {
            return f8;
        }
        PointF h8 = this.f9082m.h();
        PointF h9 = this.f9083n.h();
        GradientColor h10 = this.f9080k.h();
        LinearGradient linearGradient = new LinearGradient(h8.x, h8.y, h9.x, h9.y, g(h10.a()), h10.b(), Shader.TileMode.CLAMP);
        this.f9073d.l(i8, linearGradient);
        return linearGradient;
    }

    private RadialGradient k() {
        float f8;
        long i8 = i();
        RadialGradient f9 = this.f9074e.f(i8);
        if (f9 != null) {
            return f9;
        }
        PointF h8 = this.f9082m.h();
        PointF h9 = this.f9083n.h();
        GradientColor h10 = this.f9080k.h();
        int[] g8 = g(h10.a());
        float[] b8 = h10.b();
        float f10 = h8.x;
        float f11 = h8.y;
        float hypot = (float) Math.hypot(h9.x - f10, h9.y - f11);
        if (hypot <= 0.0f) {
            f8 = 0.001f;
        } else {
            f8 = hypot;
        }
        RadialGradient radialGradient = new RadialGradient(f10, f11, f8, g8, b8, Shader.TileMode.CLAMP);
        this.f9074e.l(i8, radialGradient);
        return radialGradient;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f9086q.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List<Content> list, List<Content> list2) {
        for (int i8 = 0; i8 < list2.size(); i8++) {
            Content content = list2.get(i8);
            if (content instanceof PathContent) {
                this.f9078i.add((PathContent) content);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation2;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation3;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation4;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation5;
        if (t7 == LottieProperty.f8935d) {
            this.f9081l.n(lottieValueCallback);
        } else if (t7 == LottieProperty.K) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f9084o;
            if (baseKeyframeAnimation != null) {
                this.f9072c.G(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f9084o = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f9084o = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f9072c.i(this.f9084o);
        } else if (t7 == LottieProperty.L) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.f9085p;
            if (valueCallbackKeyframeAnimation2 != null) {
                this.f9072c.G(valueCallbackKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.f9085p = null;
                return;
            }
            this.f9073d.b();
            this.f9074e.b();
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f9085p = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.a(this);
            this.f9072c.i(this.f9085p);
        } else if (t7 == LottieProperty.f8941j) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f9088s;
            if (baseKeyframeAnimation2 != null) {
                baseKeyframeAnimation2.n(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f9088s = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.a(this);
            this.f9072c.i(this.f9088s);
        } else if (t7 == LottieProperty.f8936e && (dropShadowKeyframeAnimation5 = this.f9090u) != null) {
            dropShadowKeyframeAnimation5.c(lottieValueCallback);
        } else if (t7 == LottieProperty.G && (dropShadowKeyframeAnimation4 = this.f9090u) != null) {
            dropShadowKeyframeAnimation4.f(lottieValueCallback);
        } else if (t7 == LottieProperty.H && (dropShadowKeyframeAnimation3 = this.f9090u) != null) {
            dropShadowKeyframeAnimation3.d(lottieValueCallback);
        } else if (t7 == LottieProperty.I && (dropShadowKeyframeAnimation2 = this.f9090u) != null) {
            dropShadowKeyframeAnimation2.e(lottieValueCallback);
        } else if (t7 == LottieProperty.J && (dropShadowKeyframeAnimation = this.f9090u) != null) {
            dropShadowKeyframeAnimation.g(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.k(keyPath, i8, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z7) {
        this.f9075f.reset();
        for (int i8 = 0; i8 < this.f9078i.size(); i8++) {
            this.f9075f.addPath(this.f9078i.get(i8).getPath(), matrix);
        }
        this.f9075f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f9070a;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void h(Canvas canvas, Matrix matrix, int i8) {
        Shader k8;
        if (this.f9071b) {
            return;
        }
        L.a("GradientFillContent#draw");
        this.f9075f.reset();
        for (int i9 = 0; i9 < this.f9078i.size(); i9++) {
            this.f9075f.addPath(this.f9078i.get(i9).getPath(), matrix);
        }
        this.f9075f.computeBounds(this.f9077h, false);
        if (this.f9079j == GradientType.LINEAR) {
            k8 = j();
        } else {
            k8 = k();
        }
        k8.setLocalMatrix(matrix);
        this.f9076g.setShader(k8);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f9084o;
        if (baseKeyframeAnimation != null) {
            this.f9076g.setColorFilter(baseKeyframeAnimation.h());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f9088s;
        if (baseKeyframeAnimation2 != null) {
            float floatValue = baseKeyframeAnimation2.h().floatValue();
            if (floatValue == 0.0f) {
                this.f9076g.setMaskFilter(null);
            } else if (floatValue != this.f9089t) {
                this.f9076g.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f9089t = floatValue;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.f9090u;
        if (dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.b(this.f9076g);
        }
        this.f9076g.setAlpha(MiscUtils.c((int) ((((i8 / 255.0f) * this.f9081l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f9075f, this.f9076g);
        L.b("GradientFillContent#draw");
    }
}
