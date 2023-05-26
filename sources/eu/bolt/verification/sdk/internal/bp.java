package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.analytics.VerificationAnalyticsManager;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.sdk.di.VerificationSDKScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class bp implements Factory<s> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VerificationAnalyticsManager> f42404a;

    public bp(Provider<VerificationAnalyticsManager> provider) {
        this.f42404a = provider;
    }

    public static bp a(Provider<VerificationAnalyticsManager> provider) {
        return new bp(provider);
    }

    public static s c(VerificationAnalyticsManager verificationAnalyticsManager) {
        return (s) Preconditions.checkNotNullFromProvides(xo.e(verificationAnalyticsManager));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public s get() {
        return c(this.f42404a.get());
    }
}
