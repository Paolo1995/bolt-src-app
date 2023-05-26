package ee.mtakso.driver.service.modules.incident;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.incident.IncidentReportingClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class IncidentReportingService_Factory implements Factory<IncidentReportingService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderProvider> f24794a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<IncidentReportingClient> f24795b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<TrueTimeProvider> f24796c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverProvider> f24797d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<GeoLocationManager> f24798e;

    public IncidentReportingService_Factory(Provider<OrderProvider> provider, Provider<IncidentReportingClient> provider2, Provider<TrueTimeProvider> provider3, Provider<DriverProvider> provider4, Provider<GeoLocationManager> provider5) {
        this.f24794a = provider;
        this.f24795b = provider2;
        this.f24796c = provider3;
        this.f24797d = provider4;
        this.f24798e = provider5;
    }

    public static IncidentReportingService_Factory a(Provider<OrderProvider> provider, Provider<IncidentReportingClient> provider2, Provider<TrueTimeProvider> provider3, Provider<DriverProvider> provider4, Provider<GeoLocationManager> provider5) {
        return new IncidentReportingService_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static IncidentReportingService c(OrderProvider orderProvider, IncidentReportingClient incidentReportingClient, TrueTimeProvider trueTimeProvider, DriverProvider driverProvider, GeoLocationManager geoLocationManager) {
        return new IncidentReportingService(orderProvider, incidentReportingClient, trueTimeProvider, driverProvider, geoLocationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public IncidentReportingService get() {
        return c(this.f24794a.get(), this.f24795b.get(), this.f24796c.get(), this.f24797d.get(), this.f24798e.get());
    }
}
