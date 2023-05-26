package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.PolystarContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes.dex */
public class PolystarShape implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f9371a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f9372b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableFloatValue f9373c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableValue<PointF, PointF> f9374d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableFloatValue f9375e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatableFloatValue f9376f;

    /* renamed from: g  reason: collision with root package name */
    private final AnimatableFloatValue f9377g;

    /* renamed from: h  reason: collision with root package name */
    private final AnimatableFloatValue f9378h;

    /* renamed from: i  reason: collision with root package name */
    private final AnimatableFloatValue f9379i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f9380j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f9381k;

    /* loaded from: classes.dex */
    public enum Type {
        STAR(1),
        POLYGON(2);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f9385f;

        Type(int i8) {
            this.f9385f = i8;
        }

        public static Type a(int i8) {
            Type[] values;
            for (Type type : values()) {
                if (type.f9385f == i8) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableValue<PointF, PointF> animatableValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5, AnimatableFloatValue animatableFloatValue6, boolean z7, boolean z8) {
        this.f9371a = str;
        this.f9372b = type;
        this.f9373c = animatableFloatValue;
        this.f9374d = animatableValue;
        this.f9375e = animatableFloatValue2;
        this.f9376f = animatableFloatValue3;
        this.f9377g = animatableFloatValue4;
        this.f9378h = animatableFloatValue5;
        this.f9379i = animatableFloatValue6;
        this.f9380j = z7;
        this.f9381k = z8;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new PolystarContent(lottieDrawable, baseLayer, this);
    }

    public AnimatableFloatValue b() {
        return this.f9376f;
    }

    public AnimatableFloatValue c() {
        return this.f9378h;
    }

    public String d() {
        return this.f9371a;
    }

    public AnimatableFloatValue e() {
        return this.f9377g;
    }

    public AnimatableFloatValue f() {
        return this.f9379i;
    }

    public AnimatableFloatValue g() {
        return this.f9373c;
    }

    public AnimatableValue<PointF, PointF> h() {
        return this.f9374d;
    }

    public AnimatableFloatValue i() {
        return this.f9375e;
    }

    public Type j() {
        return this.f9372b;
    }

    public boolean k() {
        return this.f9380j;
    }

    public boolean l() {
        return this.f9381k;
    }
}
