package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.VerificationSDKConfiguration;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class fq implements Factory<eq> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VerificationSDKConfiguration> f43057a;

    public fq(Provider<VerificationSDKConfiguration> provider) {
        this.f43057a = provider;
    }

    public static eq b(VerificationSDKConfiguration verificationSDKConfiguration) {
        return new eq(verificationSDKConfiguration);
    }

    public static fq c(Provider<VerificationSDKConfiguration> provider) {
        return new fq(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public eq get() {
        return b(this.f43057a.get());
    }
}
