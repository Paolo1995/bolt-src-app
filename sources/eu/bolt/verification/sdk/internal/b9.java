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
public final class b9 implements Factory<a9> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<rc> f42295a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<d2> f42296b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<x8> f42297c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<sk> f42298d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<wk> f42299e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<uk> f42300f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<bh> f42301g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<xn> f42302h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<x1> f42303i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<v8> f42304j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<mn> f42305k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<tl> f42306l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<s> f42307m;

    /* renamed from: n  reason: collision with root package name */
    private final Provider<j9> f42308n;

    public b9(Provider<rc> provider, Provider<d2> provider2, Provider<x8> provider3, Provider<sk> provider4, Provider<wk> provider5, Provider<uk> provider6, Provider<bh> provider7, Provider<xn> provider8, Provider<x1> provider9, Provider<v8> provider10, Provider<mn> provider11, Provider<tl> provider12, Provider<s> provider13, Provider<j9> provider14) {
        this.f42295a = provider;
        this.f42296b = provider2;
        this.f42297c = provider3;
        this.f42298d = provider4;
        this.f42299e = provider5;
        this.f42300f = provider6;
        this.f42301g = provider7;
        this.f42302h = provider8;
        this.f42303i = provider9;
        this.f42304j = provider10;
        this.f42305k = provider11;
        this.f42306l = provider12;
        this.f42307m = provider13;
        this.f42308n = provider14;
    }

    public static a9 b(rc rcVar, d2 d2Var, x8 x8Var, sk skVar, wk wkVar, uk ukVar, bh bhVar, xn xnVar, x1 x1Var, v8 v8Var, mn mnVar, tl tlVar, s sVar, j9 j9Var) {
        return new a9(rcVar, d2Var, x8Var, skVar, wkVar, ukVar, bhVar, xnVar, x1Var, v8Var, mnVar, tlVar, sVar, j9Var);
    }

    public static b9 c(Provider<rc> provider, Provider<d2> provider2, Provider<x8> provider3, Provider<sk> provider4, Provider<wk> provider5, Provider<uk> provider6, Provider<bh> provider7, Provider<xn> provider8, Provider<x1> provider9, Provider<v8> provider10, Provider<mn> provider11, Provider<tl> provider12, Provider<s> provider13, Provider<j9> provider14) {
        return new b9(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public a9 get() {
        return b(this.f42295a.get(), this.f42296b.get(), this.f42297c.get(), this.f42298d.get(), this.f42299e.get(), this.f42300f.get(), this.f42301g.get(), this.f42302h.get(), this.f42303i.get(), this.f42304j.get(), this.f42305k.get(), this.f42306l.get(), this.f42307m.get(), this.f42308n.get());
    }
}
