package ee.mtakso.driver.service.routing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.order.details.OrderProvider;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AutoNavigationRoutingService_Factory implements Factory<AutoNavigationRoutingService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderProvider> f25889a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AutoNavigationManager> f25890b;

    public AutoNavigationRoutingService_Factory(Provider<OrderProvider> provider, Provider<AutoNavigationManager> provider2) {
        this.f25889a = provider;
        this.f25890b = provider2;
    }

    public static AutoNavigationRoutingService_Factory a(Provider<OrderProvider> provider, Provider<AutoNavigationManager> provider2) {
        return new AutoNavigationRoutingService_Factory(provider, provider2);
    }

    public static AutoNavigationRoutingService c(OrderProvider orderProvider, AutoNavigationManager autoNavigationManager) {
        return new AutoNavigationRoutingService(orderProvider, autoNavigationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AutoNavigationRoutingService get() {
        return c(this.f25889a.get(), this.f25890b.get());
    }
}
