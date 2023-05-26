package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.rn;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.core.rib.VerificationFlowBuilder.VerificationFlowScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class tn implements Factory<zn<Cdo>> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ao> f45224a;

    public tn(Provider<ao> provider) {
        this.f45224a = provider;
    }

    public static tn a(Provider<ao> provider) {
        return new tn(provider);
    }

    public static zn<Cdo> c(ao aoVar) {
        return (zn) Preconditions.checkNotNullFromProvides(rn.c.c(aoVar));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public zn<Cdo> get() {
        return c(this.f45224a.get());
    }
}
