package ee.mtakso.driver.service.modules.fifo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FifoQueueService_Factory implements Factory<FifoQueueService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerSource> f24754a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f24755b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<FifoQueueManager> f24756c;

    public FifoQueueService_Factory(Provider<PollerSource> provider, Provider<DriverStatusProvider> provider2, Provider<FifoQueueManager> provider3) {
        this.f24754a = provider;
        this.f24755b = provider2;
        this.f24756c = provider3;
    }

    public static FifoQueueService_Factory a(Provider<PollerSource> provider, Provider<DriverStatusProvider> provider2, Provider<FifoQueueManager> provider3) {
        return new FifoQueueService_Factory(provider, provider2, provider3);
    }

    public static FifoQueueService c(PollerSource pollerSource, DriverStatusProvider driverStatusProvider, FifoQueueManager fifoQueueManager) {
        return new FifoQueueService(pollerSource, driverStatusProvider, fifoQueueManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FifoQueueService get() {
        return c(this.f24754a.get(), this.f24755b.get(), this.f24756c.get());
    }
}
