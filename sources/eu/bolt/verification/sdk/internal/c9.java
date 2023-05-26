package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class c9 implements Factory<z8> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<rc> f42474a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<d2> f42475b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<x8> f42476c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<sk> f42477d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<wk> f42478e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<uk> f42479f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<bh> f42480g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<xn> f42481h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<x1> f42482i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<v8> f42483j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<mn> f42484k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<tl> f42485l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<s> f42486m;

    /* renamed from: n  reason: collision with root package name */
    private final Provider<j9> f42487n;

    public c9(Provider<rc> provider, Provider<d2> provider2, Provider<x8> provider3, Provider<sk> provider4, Provider<wk> provider5, Provider<uk> provider6, Provider<bh> provider7, Provider<xn> provider8, Provider<x1> provider9, Provider<v8> provider10, Provider<mn> provider11, Provider<tl> provider12, Provider<s> provider13, Provider<j9> provider14) {
        this.f42474a = provider;
        this.f42475b = provider2;
        this.f42476c = provider3;
        this.f42477d = provider4;
        this.f42478e = provider5;
        this.f42479f = provider6;
        this.f42480g = provider7;
        this.f42481h = provider8;
        this.f42482i = provider9;
        this.f42483j = provider10;
        this.f42484k = provider11;
        this.f42485l = provider12;
        this.f42486m = provider13;
        this.f42487n = provider14;
    }

    public static c9 a(Provider<rc> provider, Provider<d2> provider2, Provider<x8> provider3, Provider<sk> provider4, Provider<wk> provider5, Provider<uk> provider6, Provider<bh> provider7, Provider<xn> provider8, Provider<x1> provider9, Provider<v8> provider10, Provider<mn> provider11, Provider<tl> provider12, Provider<s> provider13, Provider<j9> provider14) {
        return new c9(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    public static z8 c(rc rcVar, d2 d2Var, x8 x8Var, sk skVar, wk wkVar, uk ukVar, bh bhVar, xn xnVar, x1 x1Var, v8 v8Var, mn mnVar, tl tlVar, s sVar, j9 j9Var) {
        return new z8(rcVar, d2Var, x8Var, skVar, wkVar, ukVar, bhVar, xnVar, x1Var, v8Var, mnVar, tlVar, sVar, j9Var);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public z8 get() {
        return c(this.f42474a.get(), this.f42475b.get(), this.f42476c.get(), this.f42477d.get(), this.f42478e.get(), this.f42479f.get(), this.f42480g.get(), this.f42481h.get(), this.f42482i.get(), this.f42483j.get(), this.f42484k.get(), this.f42485l.get(), this.f42486m.get(), this.f42487n.get());
    }
}
