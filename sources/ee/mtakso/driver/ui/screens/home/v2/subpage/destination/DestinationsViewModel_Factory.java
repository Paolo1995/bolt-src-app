package ee.mtakso.driver.ui.screens.home.v2.subpage.destination;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.ui.interactor.destination.ActiveDestinationInteractor;
import ee.mtakso.driver.ui.interactor.destination.DeactivateDestinationInteractor;
import ee.mtakso.driver.ui.interactor.destination.DeleteDestinationInteractor;
import ee.mtakso.driver.ui.interactor.destination.DestinationLimitInteractor;
import ee.mtakso.driver.ui.interactor.destination.SavedDestinationsInteractor;
import ee.mtakso.driver.ui.interactor.destination.SelectDestinationInteractor;
import ee.mtakso.driver.ui.screens.destination.DestinationMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DestinationsViewModel_Factory implements Factory<DestinationsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DestinationLimitInteractor> f29730a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SavedDestinationsInteractor> f29731b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ActiveDestinationInteractor> f29732c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SelectDestinationInteractor> f29733d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DeactivateDestinationInteractor> f29734e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<DeleteDestinationInteractor> f29735f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<GeoLocationManager> f29736g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DestinationMapper> f29737h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<DriverProvider> f29738i;

    public DestinationsViewModel_Factory(Provider<DestinationLimitInteractor> provider, Provider<SavedDestinationsInteractor> provider2, Provider<ActiveDestinationInteractor> provider3, Provider<SelectDestinationInteractor> provider4, Provider<DeactivateDestinationInteractor> provider5, Provider<DeleteDestinationInteractor> provider6, Provider<GeoLocationManager> provider7, Provider<DestinationMapper> provider8, Provider<DriverProvider> provider9) {
        this.f29730a = provider;
        this.f29731b = provider2;
        this.f29732c = provider3;
        this.f29733d = provider4;
        this.f29734e = provider5;
        this.f29735f = provider6;
        this.f29736g = provider7;
        this.f29737h = provider8;
        this.f29738i = provider9;
    }

    public static DestinationsViewModel_Factory a(Provider<DestinationLimitInteractor> provider, Provider<SavedDestinationsInteractor> provider2, Provider<ActiveDestinationInteractor> provider3, Provider<SelectDestinationInteractor> provider4, Provider<DeactivateDestinationInteractor> provider5, Provider<DeleteDestinationInteractor> provider6, Provider<GeoLocationManager> provider7, Provider<DestinationMapper> provider8, Provider<DriverProvider> provider9) {
        return new DestinationsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static DestinationsViewModel c(DestinationLimitInteractor destinationLimitInteractor, SavedDestinationsInteractor savedDestinationsInteractor, ActiveDestinationInteractor activeDestinationInteractor, SelectDestinationInteractor selectDestinationInteractor, DeactivateDestinationInteractor deactivateDestinationInteractor, DeleteDestinationInteractor deleteDestinationInteractor, GeoLocationManager geoLocationManager, DestinationMapper destinationMapper, DriverProvider driverProvider) {
        return new DestinationsViewModel(destinationLimitInteractor, savedDestinationsInteractor, activeDestinationInteractor, selectDestinationInteractor, deactivateDestinationInteractor, deleteDestinationInteractor, geoLocationManager, destinationMapper, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DestinationsViewModel get() {
        return c(this.f29730a.get(), this.f29731b.get(), this.f29732c.get(), this.f29733d.get(), this.f29734e.get(), this.f29735f.get(), this.f29736g.get(), this.f29737h.get(), this.f29738i.get());
    }
}
