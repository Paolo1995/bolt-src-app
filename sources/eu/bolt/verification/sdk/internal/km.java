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
public final class km implements Factory<jm> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VerificationSDKConfiguration> f43895a;

    public km(Provider<VerificationSDKConfiguration> provider) {
        this.f43895a = provider;
    }

    public static jm b(VerificationSDKConfiguration verificationSDKConfiguration) {
        return new jm(verificationSDKConfiguration);
    }

    public static km c(Provider<VerificationSDKConfiguration> provider) {
        return new km(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public jm get() {
        return b(this.f43895a.get());
    }
}
