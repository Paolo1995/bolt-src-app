package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes.dex */
public class CircleShape implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f9320a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f9321b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatablePointValue f9322c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f9323d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f9324e;

    public CircleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, boolean z7, boolean z8) {
        this.f9320a = str;
        this.f9321b = animatableValue;
        this.f9322c = animatablePointValue;
        this.f9323d = z7;
        this.f9324e = z8;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new EllipseContent(lottieDrawable, baseLayer, this);
    }

    public String b() {
        return this.f9320a;
    }

    public AnimatableValue<PointF, PointF> c() {
        return this.f9321b;
    }

    public AnimatablePointValue d() {
        return this.f9322c;
    }

    public boolean e() {
        return this.f9324e;
    }

    public boolean f() {
        return this.f9323d;
    }
}
