package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

/* loaded from: classes.dex */
public class Mask {

    /* renamed from: a  reason: collision with root package name */
    private final MaskMode f9353a;

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableShapeValue f9354b;

    /* renamed from: c  reason: collision with root package name */
    private final AnimatableIntegerValue f9355c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f9356d;

    /* loaded from: classes.dex */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, AnimatableShapeValue animatableShapeValue, AnimatableIntegerValue animatableIntegerValue, boolean z7) {
        this.f9353a = maskMode;
        this.f9354b = animatableShapeValue;
        this.f9355c = animatableIntegerValue;
        this.f9356d = z7;
    }

    public MaskMode a() {
        return this.f9353a;
    }

    public AnimatableShapeValue b() {
        return this.f9354b;
    }

    public AnimatableIntegerValue c() {
        return this.f9355c;
    }

    public boolean d() {
        return this.f9356d;
    }
}
