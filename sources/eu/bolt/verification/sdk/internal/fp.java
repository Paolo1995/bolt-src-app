package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.VerificationSDKConfiguration;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.sdk.di.VerificationSDKScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class fp implements Factory<kn> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<v1> f43055a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<VerificationSDKConfiguration> f43056b;

    public fp(Provider<v1> provider, Provider<VerificationSDKConfiguration> provider2) {
        this.f43055a = provider;
        this.f43056b = provider2;
    }

    public static fp a(Provider<v1> provider, Provider<VerificationSDKConfiguration> provider2) {
        return new fp(provider, provider2);
    }

    public static kn c(v1 v1Var, VerificationSDKConfiguration verificationSDKConfiguration) {
        return (kn) Preconditions.checkNotNullFromProvides(xo.d(v1Var, verificationSDKConfiguration));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public kn get() {
        return c(this.f43055a.get(), this.f43056b.get());
    }
}
