package ee.mtakso.driver.service.order.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.order.DriverOrderClient;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.utils.coroutines.DispatcherProvider;
import ee.mtakso.driver.utils.coroutines.ScopeProvider;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderManager_Factory implements Factory<OrderManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScopeProvider> f25457a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DispatcherProvider> f25458b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderClient> f25459c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverOrderClient> f25460d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<OrdersCache> f25461e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f25462f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<OrderTryAgainManager> f25463g;

    public OrderManager_Factory(Provider<ScopeProvider> provider, Provider<DispatcherProvider> provider2, Provider<OrderClient> provider3, Provider<DriverOrderClient> provider4, Provider<OrdersCache> provider5, Provider<TrueTimeProvider> provider6, Provider<OrderTryAgainManager> provider7) {
        this.f25457a = provider;
        this.f25458b = provider2;
        this.f25459c = provider3;
        this.f25460d = provider4;
        this.f25461e = provider5;
        this.f25462f = provider6;
        this.f25463g = provider7;
    }

    public static OrderManager_Factory a(Provider<ScopeProvider> provider, Provider<DispatcherProvider> provider2, Provider<OrderClient> provider3, Provider<DriverOrderClient> provider4, Provider<OrdersCache> provider5, Provider<TrueTimeProvider> provider6, Provider<OrderTryAgainManager> provider7) {
        return new OrderManager_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static OrderManager c(ScopeProvider scopeProvider, DispatcherProvider dispatcherProvider, OrderClient orderClient, DriverOrderClient driverOrderClient, OrdersCache ordersCache, TrueTimeProvider trueTimeProvider, OrderTryAgainManager orderTryAgainManager) {
        return new OrderManager(scopeProvider, dispatcherProvider, orderClient, driverOrderClient, ordersCache, trueTimeProvider, orderTryAgainManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderManager get() {
        return c(this.f25457a.get(), this.f25458b.get(), this.f25459c.get(), this.f25460d.get(), this.f25461e.get(), this.f25462f.get(), this.f25463g.get());
    }
}
