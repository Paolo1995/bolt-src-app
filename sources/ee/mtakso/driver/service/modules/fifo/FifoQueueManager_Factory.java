package ee.mtakso.driver.service.modules.fifo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.param.DriverFeatures;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FifoQueueManager_Factory implements Factory<FifoQueueManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverFeatures> f24744a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderClient> f24745b;

    public FifoQueueManager_Factory(Provider<DriverFeatures> provider, Provider<OrderClient> provider2) {
        this.f24744a = provider;
        this.f24745b = provider2;
    }

    public static FifoQueueManager_Factory a(Provider<DriverFeatures> provider, Provider<OrderClient> provider2) {
        return new FifoQueueManager_Factory(provider, provider2);
    }

    public static FifoQueueManager c(DriverFeatures driverFeatures, OrderClient orderClient) {
        return new FifoQueueManager(driverFeatures, orderClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FifoQueueManager get() {
        return c(this.f24744a.get(), this.f24745b.get());
    }
}
