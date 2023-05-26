package ee.mtakso.driver.service.modules.order.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.order.RideHistoryClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderHistoryManager_Factory implements Factory<OrderHistoryManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RideHistoryClient> f24911a;

    public OrderHistoryManager_Factory(Provider<RideHistoryClient> provider) {
        this.f24911a = provider;
    }

    public static OrderHistoryManager_Factory a(Provider<RideHistoryClient> provider) {
        return new OrderHistoryManager_Factory(provider);
    }

    public static OrderHistoryManager c(RideHistoryClient rideHistoryClient) {
        return new OrderHistoryManager(rideHistoryClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderHistoryManager get() {
        return c(this.f24911a.get());
    }
}
