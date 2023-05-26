package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientStrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* loaded from: classes.dex */
public class GradientStroke implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f9337a;

    /* renamed from: b  reason: collision with root package name */
    private final GradientType f9338b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableGradientColorValue f9339c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableIntegerValue f9340d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatablePointValue f9341e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatablePointValue f9342f;

    /* renamed from: g  reason: collision with root package name */
    private final AnimatableFloatValue f9343g;

    /* renamed from: h  reason: collision with root package name */
    private final ShapeStroke.LineCapType f9344h;

    /* renamed from: i  reason: collision with root package name */
    private final ShapeStroke.LineJoinType f9345i;

    /* renamed from: j  reason: collision with root package name */
    private final float f9346j;

    /* renamed from: k  reason: collision with root package name */
    private final List<AnimatableFloatValue> f9347k;

    /* renamed from: l  reason: collision with root package name */
    private final AnimatableFloatValue f9348l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f9349m;

    public GradientStroke(String str, GradientType gradientType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f8, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2, boolean z7) {
        this.f9337a = str;
        this.f9338b = gradientType;
        this.f9339c = animatableGradientColorValue;
        this.f9340d = animatableIntegerValue;
        this.f9341e = animatablePointValue;
        this.f9342f = animatablePointValue2;
        this.f9343g = animatableFloatValue;
        this.f9344h = lineCapType;
        this.f9345i = lineJoinType;
        this.f9346j = f8;
        this.f9347k = list;
        this.f9348l = animatableFloatValue2;
        this.f9349m = z7;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new GradientStrokeContent(lottieDrawable, baseLayer, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.f9344h;
    }

    public AnimatableFloatValue c() {
        return this.f9348l;
    }

    public AnimatablePointValue d() {
        return this.f9342f;
    }

    public AnimatableGradientColorValue e() {
        return this.f9339c;
    }

    public GradientType f() {
        return this.f9338b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.f9345i;
    }

    public List<AnimatableFloatValue> h() {
        return this.f9347k;
    }

    public float i() {
        return this.f9346j;
    }

    public String j() {
        return this.f9337a;
    }

    public AnimatableIntegerValue k() {
        return this.f9340d;
    }

    public AnimatablePointValue l() {
        return this.f9341e;
    }

    public AnimatableFloatValue m() {
        return this.f9343g;
    }

    public boolean n() {
        return this.f9349m;
    }
}
