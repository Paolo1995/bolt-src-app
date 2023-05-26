package ee.mtakso.driver.service.b2b;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.order.DriverOrderClient;
import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class B2bManager_Factory implements Factory<B2bManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverClient> f23937a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderAnalytics> f23938b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f23939c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverOrderClient> f23940d;

    public B2bManager_Factory(Provider<DriverClient> provider, Provider<OrderAnalytics> provider2, Provider<TrueTimeProvider> provider3, Provider<DriverOrderClient> provider4) {
        this.f23937a = provider;
        this.f23938b = provider2;
        this.f23939c = provider3;
        this.f23940d = provider4;
    }

    public static B2bManager_Factory a(Provider<DriverClient> provider, Provider<OrderAnalytics> provider2, Provider<TrueTimeProvider> provider3, Provider<DriverOrderClient> provider4) {
        return new B2bManager_Factory(provider, provider2, provider3, provider4);
    }

    public static B2bManager c(DriverClient driverClient, OrderAnalytics orderAnalytics, TrueTimeProvider trueTimeProvider, DriverOrderClient driverOrderClient) {
        return new B2bManager(driverClient, orderAnalytics, trueTimeProvider, driverOrderClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public B2bManager get() {
        return c(this.f23937a.get(), this.f23938b.get(), this.f23939c.get(), this.f23940d.get());
    }
}
