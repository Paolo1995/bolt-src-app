package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes.dex */
public class ShapeTrimPath implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f9434a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f9435b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableFloatValue f9436c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableFloatValue f9437d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableFloatValue f9438e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f9439f;

    /* loaded from: classes.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type a(int i8) {
            if (i8 != 1) {
                if (i8 == 2) {
                    return INDIVIDUALLY;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i8);
            }
            return SIMULTANEOUSLY;
        }
    }

    public ShapeTrimPath(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean z7) {
        this.f9434a = str;
        this.f9435b = type;
        this.f9436c = animatableFloatValue;
        this.f9437d = animatableFloatValue2;
        this.f9438e = animatableFloatValue3;
        this.f9439f = z7;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new TrimPathContent(baseLayer, this);
    }

    public AnimatableFloatValue b() {
        return this.f9437d;
    }

    public String c() {
        return this.f9434a;
    }

    public AnimatableFloatValue d() {
        return this.f9438e;
    }

    public AnimatableFloatValue e() {
        return this.f9436c;
    }

    public Type f() {
        return this.f9435b;
    }

    public boolean g() {
        return this.f9439f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f9436c + ", end: " + this.f9437d + ", offset: " + this.f9438e + "}";
    }
}
