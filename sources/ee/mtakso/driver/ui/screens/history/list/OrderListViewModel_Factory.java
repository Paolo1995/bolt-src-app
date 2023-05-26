package ee.mtakso.driver.ui.screens.history.list;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.service.analytics.event.facade.HistoryAnalytics;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.modules.order.v2.OrderHistoryManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderListViewModel_Factory implements Factory<OrderListViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderHistoryManager> f29604a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RateMePrefsManager> f29605b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<HistoryAnalytics> f29606c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverManager> f29607d;

    public OrderListViewModel_Factory(Provider<OrderHistoryManager> provider, Provider<RateMePrefsManager> provider2, Provider<HistoryAnalytics> provider3, Provider<DriverManager> provider4) {
        this.f29604a = provider;
        this.f29605b = provider2;
        this.f29606c = provider3;
        this.f29607d = provider4;
    }

    public static OrderListViewModel_Factory a(Provider<OrderHistoryManager> provider, Provider<RateMePrefsManager> provider2, Provider<HistoryAnalytics> provider3, Provider<DriverManager> provider4) {
        return new OrderListViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static OrderListViewModel c(OrderHistoryManager orderHistoryManager, RateMePrefsManager rateMePrefsManager, HistoryAnalytics historyAnalytics, DriverManager driverManager) {
        return new OrderListViewModel(orderHistoryManager, rateMePrefsManager, historyAnalytics, driverManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderListViewModel get() {
        return c(this.f29604a.get(), this.f29605b.get(), this.f29606c.get(), this.f29607d.get());
    }
}
