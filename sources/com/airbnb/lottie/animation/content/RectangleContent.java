package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {

    /* renamed from: c  reason: collision with root package name */
    private final String f9125c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f9126d;

    /* renamed from: e  reason: collision with root package name */
    private final LottieDrawable f9127e;

    /* renamed from: f  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f9128f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f9129g;

    /* renamed from: h  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f9130h;

    /* renamed from: k  reason: collision with root package name */
    private boolean f9133k;

    /* renamed from: a  reason: collision with root package name */
    private final Path f9123a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f9124b = new RectF();

    /* renamed from: i  reason: collision with root package name */
    private final CompoundTrimPathContent f9131i = new CompoundTrimPathContent();

    /* renamed from: j  reason: collision with root package name */
    private BaseKeyframeAnimation<Float, Float> f9132j = null;

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.f9125c = rectangleShape.c();
        this.f9126d = rectangleShape.f();
        this.f9127e = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> a8 = rectangleShape.d().a();
        this.f9128f = a8;
        BaseKeyframeAnimation<PointF, PointF> a9 = rectangleShape.e().a();
        this.f9129g = a9;
        BaseKeyframeAnimation<Float, Float> a10 = rectangleShape.b().a();
        this.f9130h = a10;
        baseLayer.i(a8);
        baseLayer.i(a9);
        baseLayer.i(a10);
        a8.a(this);
        a9.a(this);
        a10.a(this);
    }

    private void g() {
        this.f9133k = false;
        this.f9127e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        g();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List<Content> list, List<Content> list2) {
        for (int i8 = 0; i8 < list.size(); i8++) {
            Content content = list.get(i8);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f9131i.a(trimPathContent);
                    trimPathContent.d(this);
                }
            }
            if (content instanceof RoundedCornersContent) {
                this.f9132j = ((RoundedCornersContent) content).g();
            }
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        if (t7 == LottieProperty.f8943l) {
            this.f9129g.n(lottieValueCallback);
        } else if (t7 == LottieProperty.f8945n) {
            this.f9128f.n(lottieValueCallback);
        } else if (t7 == LottieProperty.f8944m) {
            this.f9130h.n(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.k(keyPath, i8, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f9125c;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        float p8;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        if (this.f9133k) {
            return this.f9123a;
        }
        this.f9123a.reset();
        if (this.f9126d) {
            this.f9133k = true;
            return this.f9123a;
        }
        PointF h8 = this.f9129g.h();
        float f8 = h8.x / 2.0f;
        float f9 = h8.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f9130h;
        if (baseKeyframeAnimation2 == null) {
            p8 = 0.0f;
        } else {
            p8 = ((FloatKeyframeAnimation) baseKeyframeAnimation2).p();
        }
        if (p8 == 0.0f && (baseKeyframeAnimation = this.f9132j) != null) {
            p8 = Math.min(baseKeyframeAnimation.h().floatValue(), Math.min(f8, f9));
        }
        float min = Math.min(f8, f9);
        if (p8 > min) {
            p8 = min;
        }
        PointF h9 = this.f9128f.h();
        this.f9123a.moveTo(h9.x + f8, (h9.y - f9) + p8);
        this.f9123a.lineTo(h9.x + f8, (h9.y + f9) - p8);
        int i8 = (p8 > 0.0f ? 1 : (p8 == 0.0f ? 0 : -1));
        if (i8 > 0) {
            RectF rectF = this.f9124b;
            float f10 = h9.x;
            float f11 = p8 * 2.0f;
            float f12 = h9.y;
            rectF.set((f10 + f8) - f11, (f12 + f9) - f11, f10 + f8, f12 + f9);
            this.f9123a.arcTo(this.f9124b, 0.0f, 90.0f, false);
        }
        this.f9123a.lineTo((h9.x - f8) + p8, h9.y + f9);
        if (i8 > 0) {
            RectF rectF2 = this.f9124b;
            float f13 = h9.x;
            float f14 = h9.y;
            float f15 = p8 * 2.0f;
            rectF2.set(f13 - f8, (f14 + f9) - f15, (f13 - f8) + f15, f14 + f9);
            this.f9123a.arcTo(this.f9124b, 90.0f, 90.0f, false);
        }
        this.f9123a.lineTo(h9.x - f8, (h9.y - f9) + p8);
        if (i8 > 0) {
            RectF rectF3 = this.f9124b;
            float f16 = h9.x;
            float f17 = h9.y;
            float f18 = p8 * 2.0f;
            rectF3.set(f16 - f8, f17 - f9, (f16 - f8) + f18, (f17 - f9) + f18);
            this.f9123a.arcTo(this.f9124b, 180.0f, 90.0f, false);
        }
        this.f9123a.lineTo((h9.x + f8) - p8, h9.y - f9);
        if (i8 > 0) {
            RectF rectF4 = this.f9124b;
            float f19 = h9.x;
            float f20 = p8 * 2.0f;
            float f21 = h9.y;
            rectF4.set((f19 + f8) - f20, f21 - f9, f19 + f8, (f21 - f9) + f20);
            this.f9123a.arcTo(this.f9124b, 270.0f, 90.0f, false);
        }
        this.f9123a.close();
        this.f9131i.b(this.f9123a);
        this.f9133k = true;
        return this.f9123a;
    }
}
