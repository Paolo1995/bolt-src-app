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
public final class zo implements Factory<y> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VerificationSDKConfiguration> f45876a;

    public zo(Provider<VerificationSDKConfiguration> provider) {
        this.f45876a = provider;
    }

    public static y b(VerificationSDKConfiguration verificationSDKConfiguration) {
        return (y) Preconditions.checkNotNullFromProvides(xo.h(verificationSDKConfiguration));
    }

    public static zo c(Provider<VerificationSDKConfiguration> provider) {
        return new zo(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public y get() {
        return b(this.f45876a.get());
    }
}
