package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ShapeGroup implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f9407a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ContentModel> f9408b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9409c;

    public ShapeGroup(String str, List<ContentModel> list, boolean z7) {
        this.f9407a = str;
        this.f9408b = list;
        this.f9409c = z7;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ContentGroup(lottieDrawable, baseLayer, this);
    }

    public List<ContentModel> b() {
        return this.f9408b;
    }

    public String c() {
        return this.f9407a;
    }

    public boolean d() {
        return this.f9409c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f9407a + "' Shapes: " + Arrays.toString(this.f9408b.toArray()) + '}';
    }
}
