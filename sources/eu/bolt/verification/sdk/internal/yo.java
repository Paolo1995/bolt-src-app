package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.VerificationSDKConfiguration;
import eu.bolt.verification.sdk.analytics.VerificationAnalyticsManager;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.sdk.di.VerificationSDKScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class yo implements Factory<VerificationAnalyticsManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VerificationSDKConfiguration> f45773a;

    public yo(Provider<VerificationSDKConfiguration> provider) {
        this.f45773a = provider;
    }

    public static VerificationAnalyticsManager b(VerificationSDKConfiguration verificationSDKConfiguration) {
        return (VerificationAnalyticsManager) Preconditions.checkNotNullFromProvides(xo.a(verificationSDKConfiguration));
    }

    public static yo c(Provider<VerificationSDKConfiguration> provider) {
        return new yo(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public VerificationAnalyticsManager get() {
        return b(this.f45773a.get());
    }
}
