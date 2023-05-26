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
public final class ad implements Factory<zc> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<rc> f42067a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ld> f42068b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<nd> f42069c;

    public ad(Provider<rc> provider, Provider<ld> provider2, Provider<nd> provider3) {
        this.f42067a = provider;
        this.f42068b = provider2;
        this.f42069c = provider3;
    }

    public static ad a(Provider<rc> provider, Provider<ld> provider2, Provider<nd> provider3) {
        return new ad(provider, provider2, provider3);
    }

    public static zc c(rc rcVar, ld ldVar, nd ndVar) {
        return new zc(rcVar, ldVar, ndVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public zc get() {
        return c(this.f42067a.get(), this.f42068b.get(), this.f42069c.get());
    }
}
