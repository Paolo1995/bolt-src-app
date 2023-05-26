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
public final class ph implements Factory<oh> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<tc> f44546a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<yl> f44547b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<xg> f44548c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<bd> f44549d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<q8> f44550e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<xn> f44551f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<x1> f44552g;

    public ph(Provider<tc> provider, Provider<yl> provider2, Provider<xg> provider3, Provider<bd> provider4, Provider<q8> provider5, Provider<xn> provider6, Provider<x1> provider7) {
        this.f44546a = provider;
        this.f44547b = provider2;
        this.f44548c = provider3;
        this.f44549d = provider4;
        this.f44550e = provider5;
        this.f44551f = provider6;
        this.f44552g = provider7;
    }

    public static oh b(tc tcVar, yl ylVar, xg xgVar, bd bdVar, q8 q8Var, xn xnVar, x1 x1Var) {
        return new oh(tcVar, ylVar, xgVar, bdVar, q8Var, xnVar, x1Var);
    }

    public static ph c(Provider<tc> provider, Provider<yl> provider2, Provider<xg> provider3, Provider<bd> provider4, Provider<q8> provider5, Provider<xn> provider6, Provider<x1> provider7) {
        return new ph(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public oh get() {
        return b(this.f44546a.get(), this.f44547b.get(), this.f44548c.get(), this.f44549d.get(), this.f44550e.get(), this.f44551f.get(), this.f44552g.get());
    }
}
