package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class EllipseContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: b  reason: collision with root package name */
    private final String f9050b;

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f9051c;

    /* renamed from: d  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f9052d;

    /* renamed from: e  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f9053e;

    /* renamed from: f  reason: collision with root package name */
    private final CircleShape f9054f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9056h;

    /* renamed from: a  reason: collision with root package name */
    private final Path f9049a = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final CompoundTrimPathContent f9055g = new CompoundTrimPathContent();

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, CircleShape circleShape) {
        this.f9050b = circleShape.b();
        this.f9051c = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> a8 = circleShape.d().a();
        this.f9052d = a8;
        BaseKeyframeAnimation<PointF, PointF> a9 = circleShape.c().a();
        this.f9053e = a9;
        this.f9054f = circleShape;
        baseLayer.i(a8);
        baseLayer.i(a9);
        a8.a(this);
        a9.a(this);
    }

    private void g() {
        this.f9056h = false;
        this.f9051c.invalidateSelf();
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
                    this.f9055g.a(trimPathContent);
                    trimPathContent.d(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        if (t7 == LottieProperty.f8942k) {
            this.f9052d.n(lottieValueCallback);
        } else if (t7 == LottieProperty.f8945n) {
            this.f9053e.n(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.k(keyPath, i8, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f9050b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.f9056h) {
            return this.f9049a;
        }
        this.f9049a.reset();
        if (this.f9054f.e()) {
            this.f9056h = true;
            return this.f9049a;
        }
        PointF h8 = this.f9052d.h();
        float f8 = h8.x / 2.0f;
        float f9 = h8.y / 2.0f;
        float f10 = f8 * 0.55228f;
        float f11 = 0.55228f * f9;
        this.f9049a.reset();
        if (this.f9054f.f()) {
            float f12 = -f9;
            this.f9049a.moveTo(0.0f, f12);
            float f13 = 0.0f - f10;
            float f14 = -f8;
            float f15 = 0.0f - f11;
            this.f9049a.cubicTo(f13, f12, f14, f15, f14, 0.0f);
            float f16 = f11 + 0.0f;
            this.f9049a.cubicTo(f14, f16, f13, f9, 0.0f, f9);
            float f17 = f10 + 0.0f;
            this.f9049a.cubicTo(f17, f9, f8, f16, f8, 0.0f);
            this.f9049a.cubicTo(f8, f15, f17, f12, 0.0f, f12);
        } else {
            float f18 = -f9;
            this.f9049a.moveTo(0.0f, f18);
            float f19 = f10 + 0.0f;
            float f20 = 0.0f - f11;
            this.f9049a.cubicTo(f19, f18, f8, f20, f8, 0.0f);
            float f21 = f11 + 0.0f;
            this.f9049a.cubicTo(f8, f21, f19, f9, 0.0f, f9);
            float f22 = 0.0f - f10;
            float f23 = -f8;
            this.f9049a.cubicTo(f22, f9, f23, f21, f23, 0.0f);
            this.f9049a.cubicTo(f23, f20, f22, f18, 0.0f, f18);
        }
        PointF h9 = this.f9053e.h();
        this.f9049a.offset(h9.x, h9.y);
        this.f9049a.close();
        this.f9055g.b(this.f9049a);
        this.f9056h = true;
        return this.f9049a;
    }
}
