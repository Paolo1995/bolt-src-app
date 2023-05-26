package ee.mtakso.driver.identity.verification;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class IdentityVerificationManager_Factory implements Factory<IdentityVerificationManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PartnerIdentityVerificationInitializer> f20983a;

    public IdentityVerificationManager_Factory(Provider<PartnerIdentityVerificationInitializer> provider) {
        this.f20983a = provider;
    }

    public static IdentityVerificationManager_Factory a(Provider<PartnerIdentityVerificationInitializer> provider) {
        return new IdentityVerificationManager_Factory(provider);
    }

    public static IdentityVerificationManager c(PartnerIdentityVerificationInitializer partnerIdentityVerificationInitializer) {
        return new IdentityVerificationManager(partnerIdentityVerificationInitializer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IdentityVerificationManager get() {
        return c(this.f20983a.get());
    }
}
