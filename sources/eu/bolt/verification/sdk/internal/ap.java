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
public final class ap implements Factory<f0> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VerificationSDKConfiguration> f42221a;

    public ap(Provider<VerificationSDKConfiguration> provider) {
        this.f42221a = provider;
    }

    public static ap a(Provider<VerificationSDKConfiguration> provider) {
        return new ap(provider);
    }

    public static f0 c(VerificationSDKConfiguration verificationSDKConfiguration) {
        return (f0) Preconditions.checkNotNullFromProvides(xo.i(verificationSDKConfiguration));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public f0 get() {
        return c(this.f42221a.get());
    }
}
