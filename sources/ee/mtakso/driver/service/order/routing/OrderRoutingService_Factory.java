package ee.mtakso.driver.service.order.routing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderRoutingService_Factory implements Factory<OrderRoutingService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerSource> f25508a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RoutingManager> f25509b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<IntentProvider> f25510c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<IncomingOrderRoutingCoordinator> f25511d;

    public OrderRoutingService_Factory(Provider<PollerSource> provider, Provider<RoutingManager> provider2, Provider<IntentProvider> provider3, Provider<IncomingOrderRoutingCoordinator> provider4) {
        this.f25508a = provider;
        this.f25509b = provider2;
        this.f25510c = provider3;
        this.f25511d = provider4;
    }

    public static OrderRoutingService_Factory a(Provider<PollerSource> provider, Provider<RoutingManager> provider2, Provider<IntentProvider> provider3, Provider<IncomingOrderRoutingCoordinator> provider4) {
        return new OrderRoutingService_Factory(provider, provider2, provider3, provider4);
    }

    public static OrderRoutingService c(PollerSource pollerSource, RoutingManager routingManager, IntentProvider intentProvider, IncomingOrderRoutingCoordinator incomingOrderRoutingCoordinator) {
        return new OrderRoutingService(pollerSource, routingManager, intentProvider, incomingOrderRoutingCoordinator);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderRoutingService get() {
        return c(this.f25508a.get(), this.f25509b.get(), this.f25510c.get(), this.f25511d.get());
    }
}
