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
public final class jp implements Factory<ip> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<kn> f43768a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<f0> f43769b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<vn> f43770c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<oq> f43771d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<on> f43772e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<xg> f43773f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<fe> f43774g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<dl> f43775h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<fo> f43776i;

    public jp(Provider<kn> provider, Provider<f0> provider2, Provider<vn> provider3, Provider<oq> provider4, Provider<on> provider5, Provider<xg> provider6, Provider<fe> provider7, Provider<dl> provider8, Provider<fo> provider9) {
        this.f43768a = provider;
        this.f43769b = provider2;
        this.f43770c = provider3;
        this.f43771d = provider4;
        this.f43772e = provider5;
        this.f43773f = provider6;
        this.f43774g = provider7;
        this.f43775h = provider8;
        this.f43776i = provider9;
    }

    public static ip b(kn knVar, f0 f0Var, vn vnVar, oq oqVar, on onVar, xg xgVar, fe feVar, dl dlVar, fo foVar) {
        return new ip(knVar, f0Var, vnVar, oqVar, onVar, xgVar, feVar, dlVar, foVar);
    }

    public static jp c(Provider<kn> provider, Provider<f0> provider2, Provider<vn> provider3, Provider<oq> provider4, Provider<on> provider5, Provider<xg> provider6, Provider<fe> provider7, Provider<dl> provider8, Provider<fo> provider9) {
        return new jp(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ip get() {
        return b(this.f43768a.get(), this.f43769b.get(), this.f43770c.get(), this.f43771d.get(), this.f43772e.get(), this.f43773f.get(), this.f43774g.get(), this.f43775h.get(), this.f43776i.get());
    }
}
