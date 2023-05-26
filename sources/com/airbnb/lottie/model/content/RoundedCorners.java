package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RoundedCornersContent;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes.dex */
public class RoundedCorners implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f9396a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableValue<Float, Float> f9397b;

    public RoundedCorners(String str, AnimatableValue<Float, Float> animatableValue) {
        this.f9396a = str;
        this.f9397b = animatableValue;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RoundedCornersContent(lottieDrawable, baseLayer, this);
    }

    public AnimatableValue<Float, Float> b() {
        return this.f9397b;
    }

    public String c() {
        return this.f9396a;
    }
}
