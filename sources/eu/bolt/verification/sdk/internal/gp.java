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
public final class gp implements Factory<jr> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VerificationSDKConfiguration> f43176a;

    public gp(Provider<VerificationSDKConfiguration> provider) {
        this.f43176a = provider;
    }

    public static gp a(Provider<VerificationSDKConfiguration> provider) {
        return new gp(provider);
    }

    public static jr c(VerificationSDKConfiguration verificationSDKConfiguration) {
        return (jr) Preconditions.checkNotNullFromProvides(xo.j(verificationSDKConfiguration));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public jr get() {
        return c(this.f43176a.get());
    }
}
