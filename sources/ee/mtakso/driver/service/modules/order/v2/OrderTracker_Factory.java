package ee.mtakso.driver.service.modules.order.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.log.strategy.memory.OrderStateStrategy;
import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.OrderTracing;
import ee.mtakso.driver.service.modules.reporters.NotRespondReporter;
import ee.mtakso.driver.service.modules.reporters.WrongStateReporter;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderTracker_Factory implements Factory<OrderTracker> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderTracing> f24996a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderFlowAnalytics> f24997b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderAnalytics> f24998c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<OrderStateStrategy> f24999d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<NotRespondReporter> f25000e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<WrongStateReporter> f25001f;

    public OrderTracker_Factory(Provider<OrderTracing> provider, Provider<OrderFlowAnalytics> provider2, Provider<OrderAnalytics> provider3, Provider<OrderStateStrategy> provider4, Provider<NotRespondReporter> provider5, Provider<WrongStateReporter> provider6) {
        this.f24996a = provider;
        this.f24997b = provider2;
        this.f24998c = provider3;
        this.f24999d = provider4;
        this.f25000e = provider5;
        this.f25001f = provider6;
    }

    public static OrderTracker_Factory a(Provider<OrderTracing> provider, Provider<OrderFlowAnalytics> provider2, Provider<OrderAnalytics> provider3, Provider<OrderStateStrategy> provider4, Provider<NotRespondReporter> provider5, Provider<WrongStateReporter> provider6) {
        return new OrderTracker_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static OrderTracker c(OrderTracing orderTracing, OrderFlowAnalytics orderFlowAnalytics, OrderAnalytics orderAnalytics, OrderStateStrategy orderStateStrategy, NotRespondReporter notRespondReporter, WrongStateReporter wrongStateReporter) {
        return new OrderTracker(orderTracing, orderFlowAnalytics, orderAnalytics, orderStateStrategy, notRespondReporter, wrongStateReporter);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderTracker get() {
        return c(this.f24996a.get(), this.f24997b.get(), this.f24998c.get(), this.f24999d.get(), this.f25000e.get(), this.f25001f.get());
    }
}
