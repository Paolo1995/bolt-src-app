package ee.mtakso.driver.ui.interactor.order;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class IncomingOrderInteractor_Factory implements Factory<IncomingOrderInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderProvider> f26706a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f26707b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<GeoLocationManager> f26708c;

    public IncomingOrderInteractor_Factory(Provider<OrderProvider> provider, Provider<DriverDestinationsManager> provider2, Provider<GeoLocationManager> provider3) {
        this.f26706a = provider;
        this.f26707b = provider2;
        this.f26708c = provider3;
    }

    public static IncomingOrderInteractor_Factory a(Provider<OrderProvider> provider, Provider<DriverDestinationsManager> provider2, Provider<GeoLocationManager> provider3) {
        return new IncomingOrderInteractor_Factory(provider, provider2, provider3);
    }

    public static IncomingOrderInteractor c(OrderProvider orderProvider, DriverDestinationsManager driverDestinationsManager, GeoLocationManager geoLocationManager) {
        return new IncomingOrderInteractor(orderProvider, driverDestinationsManager, geoLocationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IncomingOrderInteractor get() {
        return c(this.f26706a.get(), this.f26707b.get(), this.f26708c.get());
    }
}
