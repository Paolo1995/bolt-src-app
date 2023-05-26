package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f9160a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9161b;

    /* renamed from: c  reason: collision with root package name */
    private final List<BaseKeyframeAnimation.AnimationListener> f9162c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final ShapeTrimPath.Type f9163d;

    /* renamed from: e  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f9164e;

    /* renamed from: f  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f9165f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f9166g;

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        this.f9160a = shapeTrimPath.c();
        this.f9161b = shapeTrimPath.g();
        this.f9163d = shapeTrimPath.f();
        BaseKeyframeAnimation<Float, Float> a8 = shapeTrimPath.e().a();
        this.f9164e = a8;
        BaseKeyframeAnimation<Float, Float> a9 = shapeTrimPath.b().a();
        this.f9165f = a9;
        BaseKeyframeAnimation<Float, Float> a10 = shapeTrimPath.d().a();
        this.f9166g = a10;
        baseLayer.i(a8);
        baseLayer.i(a9);
        baseLayer.i(a10);
        a8.a(this);
        a9.a(this);
        a10.a(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        for (int i8 = 0; i8 < this.f9162c.size(); i8++) {
            this.f9162c.get(i8).a();
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List<Content> list, List<Content> list2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.f9162c.add(animationListener);
    }

    public BaseKeyframeAnimation<?, Float> e() {
        return this.f9165f;
    }

    public BaseKeyframeAnimation<?, Float> g() {
        return this.f9166g;
    }

    public BaseKeyframeAnimation<?, Float> i() {
        return this.f9164e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type j() {
        return this.f9163d;
    }

    public boolean k() {
        return this.f9161b;
    }
}
