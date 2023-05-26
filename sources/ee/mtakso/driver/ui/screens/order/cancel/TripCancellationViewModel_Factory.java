package ee.mtakso.driver.ui.screens.order.cancel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.order.ScheduledOrderManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import eu.bolt.android.engine.html.HtmlEngine;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class TripCancellationViewModel_Factory implements Factory<TripCancellationViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderStateManager> f31269a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderProvider> f31270b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderFlowAnalytics> f31271c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ScheduledOrderManager> f31272d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<HtmlEngine> f31273e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<RateMePrefsManager> f31274f;

    public TripCancellationViewModel_Factory(Provider<OrderStateManager> provider, Provider<OrderProvider> provider2, Provider<OrderFlowAnalytics> provider3, Provider<ScheduledOrderManager> provider4, Provider<HtmlEngine> provider5, Provider<RateMePrefsManager> provider6) {
        this.f31269a = provider;
        this.f31270b = provider2;
        this.f31271c = provider3;
        this.f31272d = provider4;
        this.f31273e = provider5;
        this.f31274f = provider6;
    }

    public static TripCancellationViewModel_Factory a(Provider<OrderStateManager> provider, Provider<OrderProvider> provider2, Provider<OrderFlowAnalytics> provider3, Provider<ScheduledOrderManager> provider4, Provider<HtmlEngine> provider5, Provider<RateMePrefsManager> provider6) {
        return new TripCancellationViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static TripCancellationViewModel c(OrderStateManager orderStateManager, OrderProvider orderProvider, OrderFlowAnalytics orderFlowAnalytics, ScheduledOrderManager scheduledOrderManager, HtmlEngine htmlEngine, RateMePrefsManager rateMePrefsManager) {
        return new TripCancellationViewModel(orderStateManager, orderProvider, orderFlowAnalytics, scheduledOrderManager, htmlEngine, rateMePrefsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public TripCancellationViewModel get() {
        return c(this.f31269a.get(), this.f31270b.get(), this.f31271c.get(), this.f31272d.get(), this.f31273e.get(), this.f31274f.get());
    }
}
