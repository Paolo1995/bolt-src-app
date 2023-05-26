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
public final class PasswordAuthFlow_Factory implements Factory<PasswordAuthFlow> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AuthStepFactory> f23792a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeviceSettings> f23793b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PartnerTokenManager> f23794c;

    public PasswordAuthFlow_Factory(Provider<AuthStepFactory> provider, Provider<DeviceSettings> provider2, Provider<PartnerTokenManager> provider3) {
        this.f23792a = provider;
        this.f23793b = provider2;
        this.f23794c = provider3;
    }

    public static PasswordAuthFlow_Factory a(Provider<AuthStepFactory> provider, Provider<DeviceSettings> provider2, Provider<PartnerTokenManager> provider3) {
        return new PasswordAuthFlow_Factory(provider, provider2, provider3);
    }

    public static PasswordAuthFlow c(AuthStepFactory authStepFactory, DeviceSettings deviceSettings, PartnerTokenManager partnerTokenManager) {
        return new PasswordAuthFlow(authStepFactory, deviceSettings, partnerTokenManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PasswordAuthFlow get() {
        return c(this.f23792a.get(), this.f23793b.get(), this.f23794c.get());
    }
}
