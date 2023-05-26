package ee.mtakso.driver.ui.screens.car_chooser;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.utils.UrlFactory;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CarChooserViewModel_Factory implements Factory<CarChooserViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f27709a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverClient> f27710b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UrlFactory> f27711c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<GetDriverCarsInteractor> f27712d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<GetDriverPortalTokenInteractor> f27713e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<DriverManager> f27714f;

    public CarChooserViewModel_Factory(Provider<DriverProvider> provider, Provider<DriverClient> provider2, Provider<UrlFactory> provider3, Provider<GetDriverCarsInteractor> provider4, Provider<GetDriverPortalTokenInteractor> provider5, Provider<DriverManager> provider6) {
        this.f27709a = provider;
        this.f27710b = provider2;
        this.f27711c = provider3;
        this.f27712d = provider4;
        this.f27713e = provider5;
        this.f27714f = provider6;
    }

    public static CarChooserViewModel_Factory a(Provider<DriverProvider> provider, Provider<DriverClient> provider2, Provider<UrlFactory> provider3, Provider<GetDriverCarsInteractor> provider4, Provider<GetDriverPortalTokenInteractor> provider5, Provider<DriverManager> provider6) {
        return new CarChooserViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CarChooserViewModel c(DriverProvider driverProvider, DriverClient driverClient, UrlFactory urlFactory, GetDriverCarsInteractor getDriverCarsInteractor, GetDriverPortalTokenInteractor getDriverPortalTokenInteractor, DriverManager driverManager) {
        return new CarChooserViewModel(driverProvider, driverClient, urlFactory, getDriverCarsInteractor, getDriverPortalTokenInteractor, driverManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CarChooserViewModel get() {
        return c(this.f27709a.get(), this.f27710b.get(), this.f27711c.get(), this.f27712d.get(), this.f27713e.get(), this.f27714f.get());
    }
}
