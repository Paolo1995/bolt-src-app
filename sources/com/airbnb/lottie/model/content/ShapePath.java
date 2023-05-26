package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes.dex */
public class ShapePath implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f9410a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9411b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableShapeValue f9412c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f9413d;

    public ShapePath(String str, int i8, AnimatableShapeValue animatableShapeValue, boolean z7) {
        this.f9410a = str;
        this.f9411b = i8;
        this.f9412c = animatableShapeValue;
        this.f9413d = z7;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ShapeContent(lottieDrawable, baseLayer, this);
    }

    public String b() {
        return this.f9410a;
    }

    public AnimatableShapeValue c() {
        return this.f9412c;
    }

    public boolean d() {
        return this.f9413d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f9410a + ", index=" + this.f9411b + '}';
    }
}
