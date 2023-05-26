package ee.mtakso.driver.service.order.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderUpdaterService_Factory implements Factory<OrderUpdaterService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PollerSource> f25476a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderManager> f25477b;

    public OrderUpdaterService_Factory(Provider<PollerSource> provider, Provider<OrderManager> provider2) {
        this.f25476a = provider;
        this.f25477b = provider2;
    }

    public static OrderUpdaterService_Factory a(Provider<PollerSource> provider, Provider<OrderManager> provider2) {
        return new OrderUpdaterService_Factory(provider, provider2);
    }

    public static OrderUpdaterService c(PollerSource pollerSource, OrderManager orderManager) {
        return new OrderUpdaterService(pollerSource, orderManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderUpdaterService get() {
        return c(this.f25476a.get(), this.f25477b.get());
    }
}
