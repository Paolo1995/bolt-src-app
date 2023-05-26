package ee.mtakso.driver.service.pollerv2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.polling.PollingRetryStrategy;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DynamicPollingService_Factory implements Factory<DynamicPollingService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerManager> f25526a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PollingRetryStrategy> f25527b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverStatusSender> f25528c;

    public DynamicPollingService_Factory(Provider<PollerManager> provider, Provider<PollingRetryStrategy> provider2, Provider<DriverStatusSender> provider3) {
        this.f25526a = provider;
        this.f25527b = provider2;
        this.f25528c = provider3;
    }

    public static DynamicPollingService_Factory a(Provider<PollerManager> provider, Provider<PollingRetryStrategy> provider2, Provider<DriverStatusSender> provider3) {
        return new DynamicPollingService_Factory(provider, provider2, provider3);
    }

    public static DynamicPollingService c(PollerManager pollerManager, PollingRetryStrategy pollingRetryStrategy, DriverStatusSender driverStatusSender) {
        return new DynamicPollingService(pollerManager, pollingRetryStrategy, driverStatusSender);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DynamicPollingService get() {
        return c(this.f25526a.get(), this.f25527b.get(), this.f25528c.get());
    }
}
