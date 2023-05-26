package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.FillContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes.dex */
public class ShapeFill implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f9401a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f9402b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9403c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableColorValue f9404d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableIntegerValue f9405e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f9406f;

    public ShapeFill(String str, boolean z7, Path.FillType fillType, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, boolean z8) {
        this.f9403c = str;
        this.f9401a = z7;
        this.f9402b = fillType;
        this.f9404d = animatableColorValue;
        this.f9405e = animatableIntegerValue;
        this.f9406f = z8;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new FillContent(lottieDrawable, baseLayer, this);
    }

    public AnimatableColorValue b() {
        return this.f9404d;
    }

    public Path.FillType c() {
        return this.f9402b;
    }

    public String d() {
        return this.f9403c;
    }

    public AnimatableIntegerValue e() {
        return this.f9405e;
    }

    public boolean f() {
        return this.f9406f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f9401a + '}';
    }
}
