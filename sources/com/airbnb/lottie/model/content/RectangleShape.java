package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes.dex */
public class RectangleShape implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f9386a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f9387b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f9388c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableFloatValue f9389d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f9390e;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatableValue<PointF, PointF> animatableValue2, AnimatableFloatValue animatableFloatValue, boolean z7) {
        this.f9386a = str;
        this.f9387b = animatableValue;
        this.f9388c = animatableValue2;
        this.f9389d = animatableFloatValue;
        this.f9390e = z7;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RectangleContent(lottieDrawable, baseLayer, this);
    }

    public AnimatableFloatValue b() {
        return this.f9389d;
    }

    public String c() {
        return this.f9386a;
    }

    public AnimatableValue<PointF, PointF> d() {
        return this.f9387b;
    }

    public AnimatableValue<PointF, PointF> e() {
        return this.f9388c;
    }

    public boolean f() {
        return this.f9390e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f9387b + ", size=" + this.f9388c + '}';
    }
}
