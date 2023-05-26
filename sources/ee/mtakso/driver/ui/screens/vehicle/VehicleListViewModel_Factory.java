package ee.mtakso.driver.ui.screens.vehicle;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.vehicle.CarApplicationClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.ui.interactor.portal.DriverPortalTokenInteractor;
import ee.mtakso.driver.utils.UrlFactory;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class VehicleListViewModel_Factory implements Factory<VehicleListViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverPortalTokenInteractor> f33542a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UrlFactory> f33543b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverManager> f33544c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverProvider> f33545d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverClient> f33546e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<CarApplicationClient> f33547f;

    public VehicleListViewModel_Factory(Provider<DriverPortalTokenInteractor> provider, Provider<UrlFactory> provider2, Provider<DriverManager> provider3, Provider<DriverProvider> provider4, Provider<DriverClient> provider5, Provider<CarApplicationClient> provider6) {
        this.f33542a = provider;
        this.f33543b = provider2;
        this.f33544c = provider3;
        this.f33545d = provider4;
        this.f33546e = provider5;
        this.f33547f = provider6;
    }

    public static VehicleListViewModel_Factory a(Provider<DriverPortalTokenInteractor> provider, Provider<UrlFactory> provider2, Provider<DriverManager> provider3, Provider<DriverProvider> provider4, Provider<DriverClient> provider5, Provider<CarApplicationClient> provider6) {
        return new VehicleListViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static VehicleListViewModel c(DriverPortalTokenInteractor driverPortalTokenInteractor, UrlFactory urlFactory, DriverManager driverManager, DriverProvider driverProvider, DriverClient driverClient, CarApplicationClient carApplicationClient) {
        return new VehicleListViewModel(driverPortalTokenInteractor, urlFactory, driverManager, driverProvider, driverClient, carApplicationClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public VehicleListViewModel get() {
        return c(this.f33542a.get(), this.f33543b.get(), this.f33544c.get(), this.f33545d.get(), this.f33546e.get(), this.f33547f.get());
    }
}
