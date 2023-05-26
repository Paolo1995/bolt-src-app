package ee.mtakso.driver.service.order;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.service.driver.DriverManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ScheduledOrderManager_Factory implements Factory<ScheduledOrderManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderClient> f25386a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScheduledOrderProvider> f25387b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverManager> f25388c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<RoutingManager> f25389d;

    public ScheduledOrderManager_Factory(Provider<OrderClient> provider, Provider<ScheduledOrderProvider> provider2, Provider<DriverManager> provider3, Provider<RoutingManager> provider4) {
        this.f25386a = provider;
        this.f25387b = provider2;
        this.f25388c = provider3;
        this.f25389d = provider4;
    }

    public static ScheduledOrderManager_Factory a(Provider<OrderClient> provider, Provider<ScheduledOrderProvider> provider2, Provider<DriverManager> provider3, Provider<RoutingManager> provider4) {
        return new ScheduledOrderManager_Factory(provider, provider2, provider3, provider4);
    }

    public static ScheduledOrderManager c(OrderClient orderClient, ScheduledOrderProvider scheduledOrderProvider, DriverManager driverManager, RoutingManager routingManager) {
        return new ScheduledOrderManager(orderClient, scheduledOrderProvider, driverManager, routingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrderManager get() {
        return c(this.f25386a.get(), this.f25387b.get(), this.f25388c.get(), this.f25389d.get());
    }
}
