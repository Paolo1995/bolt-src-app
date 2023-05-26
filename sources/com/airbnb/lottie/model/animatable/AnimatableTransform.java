package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes.dex */
public class AnimatableTransform implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final AnimatablePathValue f9309a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f9310b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableScaleValue f9311c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableFloatValue f9312d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableIntegerValue f9313e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatableFloatValue f9314f;

    /* renamed from: g  reason: collision with root package name */
    private final AnimatableFloatValue f9315g;

    /* renamed from: h  reason: collision with root package name */
    private final AnimatableFloatValue f9316h;

    /* renamed from: i  reason: collision with root package name */
    private final AnimatableFloatValue f9317i;

    public AnimatableTransform() {
        this(null, null, null, null, null, null, null, null, null);
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return null;
    }

    public TransformKeyframeAnimation b() {
        return new TransformKeyframeAnimation(this);
    }

    public AnimatablePathValue c() {
        return this.f9309a;
    }

    public AnimatableFloatValue d() {
        return this.f9317i;
    }

    public AnimatableIntegerValue e() {
        return this.f9313e;
    }

    public AnimatableValue<PointF, PointF> f() {
        return this.f9310b;
    }

    public AnimatableFloatValue g() {
        return this.f9312d;
    }

    public AnimatableScaleValue h() {
        return this.f9311c;
    }

    public AnimatableFloatValue i() {
        return this.f9314f;
    }

    public AnimatableFloatValue j() {
        return this.f9315g;
    }

    public AnimatableFloatValue k() {
        return this.f9316h;
    }

    public AnimatableTransform(AnimatablePathValue animatablePathValue, AnimatableValue<PointF, PointF> animatableValue, AnimatableScaleValue animatableScaleValue, AnimatableFloatValue animatableFloatValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5) {
        this.f9309a = animatablePathValue;
        this.f9310b = animatableValue;
        this.f9311c = animatableScaleValue;
        this.f9312d = animatableFloatValue;
        this.f9313e = animatableIntegerValue;
        this.f9316h = animatableFloatValue2;
        this.f9317i = animatableFloatValue3;
        this.f9314f = animatableFloatValue4;
        this.f9315g = animatableFloatValue5;
    }
}
