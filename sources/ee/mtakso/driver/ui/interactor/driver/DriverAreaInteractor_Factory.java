package ee.mtakso.driver.ui.interactor.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.WorkDistanceDelegate;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverAreaInteractor_Factory implements Factory<DriverAreaInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f26458a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f26459b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<WorkDistanceDelegate> f26460c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<FifoQueueManager> f26461d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<GeoLocationManager> f26462e;

    public DriverAreaInteractor_Factory(Provider<DriverProvider> provider, Provider<DriverDestinationsManager> provider2, Provider<WorkDistanceDelegate> provider3, Provider<FifoQueueManager> provider4, Provider<GeoLocationManager> provider5) {
        this.f26458a = provider;
        this.f26459b = provider2;
        this.f26460c = provider3;
        this.f26461d = provider4;
        this.f26462e = provider5;
    }

    public static DriverAreaInteractor_Factory a(Provider<DriverProvider> provider, Provider<DriverDestinationsManager> provider2, Provider<WorkDistanceDelegate> provider3, Provider<FifoQueueManager> provider4, Provider<GeoLocationManager> provider5) {
        return new DriverAreaInteractor_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DriverAreaInteractor c(DriverProvider driverProvider, DriverDestinationsManager driverDestinationsManager, WorkDistanceDelegate workDistanceDelegate, FifoQueueManager fifoQueueManager, GeoLocationManager geoLocationManager) {
        return new DriverAreaInteractor(driverProvider, driverDestinationsManager, workDistanceDelegate, fifoQueueManager, geoLocationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverAreaInteractor get() {
        return c(this.f26458a.get(), this.f26459b.get(), this.f26460c.get(), this.f26461d.get(), this.f26462e.get());
    }
}
