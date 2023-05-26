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
public final class FixedPollingService_Factory implements Factory<FixedPollingService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerManager> f25542a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PollingRetryStrategy> f25543b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverStatusSender> f25544c;

    public FixedPollingService_Factory(Provider<PollerManager> provider, Provider<PollingRetryStrategy> provider2, Provider<DriverStatusSender> provider3) {
        this.f25542a = provider;
        this.f25543b = provider2;
        this.f25544c = provider3;
    }

    public static FixedPollingService_Factory a(Provider<PollerManager> provider, Provider<PollingRetryStrategy> provider2, Provider<DriverStatusSender> provider3) {
        return new FixedPollingService_Factory(provider, provider2, provider3);
    }

    public static FixedPollingService c(PollerManager pollerManager, PollingRetryStrategy pollingRetryStrategy, DriverStatusSender driverStatusSender) {
        return new FixedPollingService(pollerManager, pollingRetryStrategy, driverStatusSender);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FixedPollingService get() {
        return c(this.f25542a.get(), this.f25543b.get(), this.f25544c.get());
    }
}
