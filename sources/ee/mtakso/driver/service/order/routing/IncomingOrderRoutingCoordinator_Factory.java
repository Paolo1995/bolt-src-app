package ee.mtakso.driver.service.order.routing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class IncomingOrderRoutingCoordinator_Factory implements Factory<IncomingOrderRoutingCoordinator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UiNotificationManager> f25496a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderTracker> f25497b;

    public IncomingOrderRoutingCoordinator_Factory(Provider<UiNotificationManager> provider, Provider<OrderTracker> provider2) {
        this.f25496a = provider;
        this.f25497b = provider2;
    }

    public static IncomingOrderRoutingCoordinator_Factory a(Provider<UiNotificationManager> provider, Provider<OrderTracker> provider2) {
        return new IncomingOrderRoutingCoordinator_Factory(provider, provider2);
    }

    public static IncomingOrderRoutingCoordinator c(UiNotificationManager uiNotificationManager, OrderTracker orderTracker) {
        return new IncomingOrderRoutingCoordinator(uiNotificationManager, orderTracker);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IncomingOrderRoutingCoordinator get() {
        return c(this.f25496a.get(), this.f25497b.get());
    }
}
