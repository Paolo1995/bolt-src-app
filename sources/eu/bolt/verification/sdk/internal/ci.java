package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ci implements Factory<bi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<f0> f42517a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<s8> f42518b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<xg> f42519c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<dj> f42520d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<kk> f42521e;

    public ci(Provider<f0> provider, Provider<s8> provider2, Provider<xg> provider3, Provider<dj> provider4, Provider<kk> provider5) {
        this.f42517a = provider;
        this.f42518b = provider2;
        this.f42519c = provider3;
        this.f42520d = provider4;
        this.f42521e = provider5;
    }

    public static bi b(f0 f0Var, s8 s8Var, xg xgVar, dj djVar, kk kkVar) {
        return new bi(f0Var, s8Var, xgVar, djVar, kkVar);
    }

    public static ci c(Provider<f0> provider, Provider<s8> provider2, Provider<xg> provider3, Provider<dj> provider4, Provider<kk> provider5) {
        return new ci(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public bi get() {
        return b(this.f42517a.get(), this.f42518b.get(), this.f42519c.get(), this.f42520d.get(), this.f42521e.get());
    }
}
