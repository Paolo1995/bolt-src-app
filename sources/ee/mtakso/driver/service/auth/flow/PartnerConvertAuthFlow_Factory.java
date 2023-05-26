package ee.mtakso.driver.service.auth.flow;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.auth.AuthStepFactory;
import ee.mtakso.driver.service.token.PartnerTokenManager;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.anonymous.AnonymousScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PartnerConvertAuthFlow_Factory implements Factory<PartnerConvertAuthFlow> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AuthStepFactory> f23781a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeviceSettings> f23782b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PartnerTokenManager> f23783c;

    public PartnerConvertAuthFlow_Factory(Provider<AuthStepFactory> provider, Provider<DeviceSettings> provider2, Provider<PartnerTokenManager> provider3) {
        this.f23781a = provider;
        this.f23782b = provider2;
        this.f23783c = provider3;
    }

    public static PartnerConvertAuthFlow_Factory a(Provider<AuthStepFactory> provider, Provider<DeviceSettings> provider2, Provider<PartnerTokenManager> provider3) {
        return new PartnerConvertAuthFlow_Factory(provider, provider2, provider3);
    }

    public static PartnerConvertAuthFlow c(AuthStepFactory authStepFactory, DeviceSettings deviceSettings, PartnerTokenManager partnerTokenManager) {
        return new PartnerConvertAuthFlow(authStepFactory, deviceSettings, partnerTokenManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PartnerConvertAuthFlow get() {
        return c(this.f23781a.get(), this.f23782b.get(), this.f23783c.get());
    }
}
