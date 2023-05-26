package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RepeaterContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes.dex */
public class Repeater implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f9391a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableFloatValue f9392b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableFloatValue f9393c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableTransform f9394d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f9395e;

    public Repeater(String str, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableTransform animatableTransform, boolean z7) {
        this.f9391a = str;
        this.f9392b = animatableFloatValue;
        this.f9393c = animatableFloatValue2;
        this.f9394d = animatableTransform;
        this.f9395e = z7;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RepeaterContent(lottieDrawable, baseLayer, this);
    }

    public AnimatableFloatValue b() {
        return this.f9392b;
    }

    public String c() {
        return this.f9391a;
    }

    public AnimatableFloatValue d() {
        return this.f9393c;
    }

    public AnimatableTransform e() {
        return this.f9394d;
    }

    public boolean f() {
        return this.f9395e;
    }
}
