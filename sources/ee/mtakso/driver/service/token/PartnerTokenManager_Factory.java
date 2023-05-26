package ee.mtakso.driver.service.token;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.param.DeviceSettings;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PartnerTokenManager_Factory implements Factory<PartnerTokenManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeviceSettings> f26046a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AnonymousAuthClient> f26047b;

    public PartnerTokenManager_Factory(Provider<DeviceSettings> provider, Provider<AnonymousAuthClient> provider2) {
        this.f26046a = provider;
        this.f26047b = provider2;
    }

    public static PartnerTokenManager_Factory a(Provider<DeviceSettings> provider, Provider<AnonymousAuthClient> provider2) {
        return new PartnerTokenManager_Factory(provider, provider2);
    }

    public static PartnerTokenManager c(DeviceSettings deviceSettings, AnonymousAuthClient anonymousAuthClient) {
        return new PartnerTokenManager(deviceSettings, anonymousAuthClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PartnerTokenManager get() {
        return c(this.f26046a.get(), this.f26047b.get());
    }
}
