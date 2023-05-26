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
public final class ej implements Factory<dj> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<vj> f42799a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<si> f42800b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ek> f42801c;

    public ej(Provider<vj> provider, Provider<si> provider2, Provider<ek> provider3) {
        this.f42799a = provider;
        this.f42800b = provider2;
        this.f42801c = provider3;
    }

    public static dj b(vj vjVar, si siVar, ek ekVar) {
        return new dj(vjVar, siVar, ekVar);
    }

    public static ej c(Provider<vj> provider, Provider<si> provider2, Provider<ek> provider3) {
        return new ej(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public dj get() {
        return b(this.f42799a.get(), this.f42800b.get(), this.f42801c.get());
    }
}
