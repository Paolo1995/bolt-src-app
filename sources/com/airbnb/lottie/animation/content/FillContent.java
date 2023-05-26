package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: a  reason: collision with root package name */
    private final Path f9057a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f9058b;

    /* renamed from: c  reason: collision with root package name */
    private final BaseLayer f9059c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9060d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f9061e;

    /* renamed from: f  reason: collision with root package name */
    private final List<PathContent> f9062f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<Integer, Integer> f9063g;

    /* renamed from: h  reason: collision with root package name */
    private final BaseKeyframeAnimation<Integer, Integer> f9064h;

    /* renamed from: i  reason: collision with root package name */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f9065i;

    /* renamed from: j  reason: collision with root package name */
    private final LottieDrawable f9066j;

    /* renamed from: k  reason: collision with root package name */
    private BaseKeyframeAnimation<Float, Float> f9067k;

    /* renamed from: l  reason: collision with root package name */
    float f9068l;

    /* renamed from: m  reason: collision with root package name */
    private DropShadowKeyframeAnimation f9069m;

    public FillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeFill shapeFill) {
        Path path = new Path();
        this.f9057a = path;
        this.f9058b = new LPaint(1);
        this.f9062f = new ArrayList();
        this.f9059c = baseLayer;
        this.f9060d = shapeFill.d();
        this.f9061e = shapeFill.f();
        this.f9066j = lottieDrawable;
        if (baseLayer.v() != null) {
            BaseKeyframeAnimation<Float, Float> a8 = baseLayer.v().a().a();
            this.f9067k = a8;
            a8.a(this);
            baseLayer.i(this.f9067k);
        }
        if (baseLayer.x() != null) {
            this.f9069m = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.x());
        }
        if (shapeFill.b() != null && shapeFill.e() != null) {
            path.setFillType(shapeFill.c());
            BaseKeyframeAnimation<Integer, Integer> a9 = shapeFill.b().a();
            this.f9063g = a9;
            a9.a(this);
            baseLayer.i(a9);
            BaseKeyframeAnimation<Integer, Integer> a10 = shapeFill.e().a();
            this.f9064h = a10;
            a10.a(this);
            baseLayer.i(a10);
            return;
        }
        this.f9063g = null;
        this.f9064h = null;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f9066j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List<Content> list, List<Content> list2) {
        for (int i8 = 0; i8 < list2.size(); i8++) {
            Content content = list2.get(i8);
            if (content instanceof PathContent) {
                this.f9062f.add((PathContent) content);
            }
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation2;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation3;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation4;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation5;
        if (t7 == LottieProperty.f8932a) {
            this.f9063g.n(lottieValueCallback);
        } else if (t7 == LottieProperty.f8935d) {
            this.f9064h.n(lottieValueCallback);
        } else if (t7 == LottieProperty.K) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f9065i;
            if (baseKeyframeAnimation != null) {
                this.f9059c.G(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f9065i = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f9065i = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f9059c.i(this.f9065i);
        } else if (t7 == LottieProperty.f8941j) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f9067k;
            if (baseKeyframeAnimation2 != null) {
                baseKeyframeAnimation2.n(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f9067k = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            this.f9059c.i(this.f9067k);
        } else if (t7 == LottieProperty.f8936e && (dropShadowKeyframeAnimation5 = this.f9069m) != null) {
            dropShadowKeyframeAnimation5.c(lottieValueCallback);
        } else if (t7 == LottieProperty.G && (dropShadowKeyframeAnimation4 = this.f9069m) != null) {
            dropShadowKeyframeAnimation4.f(lottieValueCallback);
        } else if (t7 == LottieProperty.H && (dropShadowKeyframeAnimation3 = this.f9069m) != null) {
            dropShadowKeyframeAnimation3.d(lottieValueCallback);
        } else if (t7 == LottieProperty.I && (dropShadowKeyframeAnimation2 = this.f9069m) != null) {
            dropShadowKeyframeAnimation2.e(lottieValueCallback);
        } else if (t7 == LottieProperty.J && (dropShadowKeyframeAnimation = this.f9069m) != null) {
            dropShadowKeyframeAnimation.g(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.k(keyPath, i8, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z7) {
        this.f9057a.reset();
        for (int i8 = 0; i8 < this.f9062f.size(); i8++) {
            this.f9057a.addPath(this.f9062f.get(i8).getPath(), matrix);
        }
        this.f9057a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f9060d;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void h(Canvas canvas, Matrix matrix, int i8) {
        if (this.f9061e) {
            return;
        }
        L.a("FillContent#draw");
        this.f9058b.setColor((MiscUtils.c((int) ((((i8 / 255.0f) * this.f9064h.h().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((ColorKeyframeAnimation) this.f9063g).p() & 16777215));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f9065i;
        if (baseKeyframeAnimation != null) {
            this.f9058b.setColorFilter(baseKeyframeAnimation.h());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f9067k;
        if (baseKeyframeAnimation2 != null) {
            float floatValue = baseKeyframeAnimation2.h().floatValue();
            if (floatValue == 0.0f) {
                this.f9058b.setMaskFilter(null);
            } else if (floatValue != this.f9068l) {
                this.f9058b.setMaskFilter(this.f9059c.w(floatValue));
            }
            this.f9068l = floatValue;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.f9069m;
        if (dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.b(this.f9058b);
        }
        this.f9057a.reset();
        for (int i9 = 0; i9 < this.f9062f.size(); i9++) {
            this.f9057a.addPath(this.f9062f.get(i9).getPath(), matrix);
        }
        canvas.drawPath(this.f9057a, this.f9058b);
        L.b("FillContent#draw");
    }
}
