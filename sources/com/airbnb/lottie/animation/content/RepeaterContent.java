package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class RepeaterContent implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f9134a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f9135b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f9136c;

    /* renamed from: d  reason: collision with root package name */
    private final BaseLayer f9137d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9138e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f9139f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f9140g;

    /* renamed from: h  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f9141h;

    /* renamed from: i  reason: collision with root package name */
    private final TransformKeyframeAnimation f9142i;

    /* renamed from: j  reason: collision with root package name */
    private ContentGroup f9143j;

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Repeater repeater) {
        this.f9136c = lottieDrawable;
        this.f9137d = baseLayer;
        this.f9138e = repeater.c();
        this.f9139f = repeater.f();
        BaseKeyframeAnimation<Float, Float> a8 = repeater.b().a();
        this.f9140g = a8;
        baseLayer.i(a8);
        a8.a(this);
        BaseKeyframeAnimation<Float, Float> a9 = repeater.d().a();
        this.f9141h = a9;
        baseLayer.i(a9);
        a9.a(this);
        TransformKeyframeAnimation b8 = repeater.e().b();
        this.f9142i = b8;
        b8.a(baseLayer);
        b8.b(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f9136c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List<Content> list, List<Content> list2) {
        this.f9143j.b(list, list2);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        if (this.f9142i.c(t7, lottieValueCallback)) {
            return;
        }
        if (t7 == LottieProperty.f8952u) {
            this.f9140g.n(lottieValueCallback);
        } else if (t7 == LottieProperty.f8953v) {
            this.f9141h.n(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.k(keyPath, i8, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z7) {
        this.f9143j.f(rectF, matrix, z7);
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void g(ListIterator<Content> listIterator) {
        if (this.f9143j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f9143j = new ContentGroup(this.f9136c, this.f9137d, "Repeater", this.f9139f, arrayList, null);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f9138e;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        Path path = this.f9143j.getPath();
        this.f9135b.reset();
        float floatValue = this.f9140g.h().floatValue();
        float floatValue2 = this.f9141h.h().floatValue();
        for (int i8 = ((int) floatValue) - 1; i8 >= 0; i8--) {
            this.f9134a.set(this.f9142i.g(i8 + floatValue2));
            this.f9135b.addPath(path, this.f9134a);
        }
        return this.f9135b;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void h(Canvas canvas, Matrix matrix, int i8) {
        float floatValue = this.f9140g.h().floatValue();
        float floatValue2 = this.f9141h.h().floatValue();
        float floatValue3 = this.f9142i.i().h().floatValue() / 100.0f;
        float floatValue4 = this.f9142i.e().h().floatValue() / 100.0f;
        for (int i9 = ((int) floatValue) - 1; i9 >= 0; i9--) {
            this.f9134a.set(matrix);
            float f8 = i9;
            this.f9134a.preConcat(this.f9142i.g(f8 + floatValue2));
            this.f9143j.h(canvas, this.f9134a, (int) (i8 * MiscUtils.i(floatValue3, floatValue4, f8 / floatValue)));
        }
    }
}
