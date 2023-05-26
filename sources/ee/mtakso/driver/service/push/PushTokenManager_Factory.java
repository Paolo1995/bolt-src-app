package ee.mtakso.driver.service.push;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.partner.PartnerClient;
import ee.mtakso.driver.service.analytics.event.facade.PushTokenAnalytics;
import ee.mtakso.driver.service.auth.AuthManager;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PushTokenManager_Factory implements Factory<PushTokenManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverClient> f25642a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PartnerClient> f25643b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AuthManager> f25644c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PushTokenAnalytics> f25645d;

    public PushTokenManager_Factory(Provider<DriverClient> provider, Provider<PartnerClient> provider2, Provider<AuthManager> provider3, Provider<PushTokenAnalytics> provider4) {
        this.f25642a = provider;
        this.f25643b = provider2;
        this.f25644c = provider3;
        this.f25645d = provider4;
    }

    public static PushTokenManager_Factory a(Provider<DriverClient> provider, Provider<PartnerClient> provider2, Provider<AuthManager> provider3, Provider<PushTokenAnalytics> provider4) {
        return new PushTokenManager_Factory(provider, provider2, provider3, provider4);
    }

    public static PushTokenManager c(DriverClient driverClient, PartnerClient partnerClient, AuthManager authManager, PushTokenAnalytics pushTokenAnalytics) {
        return new PushTokenManager(driverClient, partnerClient, authManager, pushTokenAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PushTokenManager get() {
        return c(this.f25642a.get(), this.f25643b.get(), this.f25644c.get(), this.f25645d.get());
    }
}
