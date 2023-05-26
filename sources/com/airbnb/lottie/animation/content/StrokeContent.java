package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes.dex */
public class StrokeContent extends BaseStrokeContent {

    /* renamed from: r  reason: collision with root package name */
    private final BaseLayer f9155r;

    /* renamed from: s  reason: collision with root package name */
    private final String f9156s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f9157t;

    /* renamed from: u  reason: collision with root package name */
    private final BaseKeyframeAnimation<Integer, Integer> f9158u;

    /* renamed from: v  reason: collision with root package name */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f9159v;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.b().a(), shapeStroke.e().a(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.f9155r = baseLayer;
        this.f9156s = shapeStroke.h();
        this.f9157t = shapeStroke.k();
        BaseKeyframeAnimation<Integer, Integer> a8 = shapeStroke.c().a();
        this.f9158u = a8;
        a8.a(this);
        baseLayer.i(a8);
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        super.d(t7, lottieValueCallback);
        if (t7 == LottieProperty.f8933b) {
            this.f9158u.n(lottieValueCallback);
        } else if (t7 == LottieProperty.K) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f9159v;
            if (baseKeyframeAnimation != null) {
                this.f9155r.G(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f9159v = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f9159v = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f9155r.i(this.f9158u);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f9156s;
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void h(Canvas canvas, Matrix matrix, int i8) {
        if (this.f9157t) {
            return;
        }
        this.f9026i.setColor(((ColorKeyframeAnimation) this.f9158u).p());
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f9159v;
        if (baseKeyframeAnimation != null) {
            this.f9026i.setColorFilter(baseKeyframeAnimation.h());
        }
        super.h(canvas, matrix, i8);
    }
}
