package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientFillContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes.dex */
public class GradientFill implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final GradientType f9327a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f9328b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableGradientColorValue f9329c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableIntegerValue f9330d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatablePointValue f9331e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatablePointValue f9332f;

    /* renamed from: g  reason: collision with root package name */
    private final String f9333g;

    /* renamed from: h  reason: collision with root package name */
    private final AnimatableFloatValue f9334h;

    /* renamed from: i  reason: collision with root package name */
    private final AnimatableFloatValue f9335i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f9336j;

    public GradientFill(String str, GradientType gradientType, Path.FillType fillType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, boolean z7) {
        this.f9327a = gradientType;
        this.f9328b = fillType;
        this.f9329c = animatableGradientColorValue;
        this.f9330d = animatableIntegerValue;
        this.f9331e = animatablePointValue;
        this.f9332f = animatablePointValue2;
        this.f9333g = str;
        this.f9334h = animatableFloatValue;
        this.f9335i = animatableFloatValue2;
        this.f9336j = z7;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new GradientFillContent(lottieDrawable, baseLayer, this);
    }

    public AnimatablePointValue b() {
        return this.f9332f;
    }

    public Path.FillType c() {
        return this.f9328b;
    }

    public AnimatableGradientColorValue d() {
        return this.f9329c;
    }

    public GradientType e() {
        return this.f9327a;
    }

    public String f() {
        return this.f9333g;
    }

    public AnimatableIntegerValue g() {
        return this.f9330d;
    }

    public AnimatablePointValue h() {
        return this.f9331e;
    }

    public boolean i() {
        return this.f9336j;
    }
}
