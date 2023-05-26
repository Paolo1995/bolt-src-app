package ee.mtakso.driver.ui.screens.car_chooser;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.driver.DriverManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GetDriverCarsInteractor_Factory implements Factory<GetDriverCarsInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverClient> f27720a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverManager> f27721b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f27722c;

    public GetDriverCarsInteractor_Factory(Provider<DriverClient> provider, Provider<DriverManager> provider2, Provider<DriverProvider> provider3) {
        this.f27720a = provider;
        this.f27721b = provider2;
        this.f27722c = provider3;
    }

    public static GetDriverCarsInteractor_Factory a(Provider<DriverClient> provider, Provider<DriverManager> provider2, Provider<DriverProvider> provider3) {
        return new GetDriverCarsInteractor_Factory(provider, provider2, provider3);
    }

    public static GetDriverCarsInteractor c(DriverClient driverClient, DriverManager driverManager, DriverProvider driverProvider) {
        return new GetDriverCarsInteractor(driverClient, driverManager, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetDriverCarsInteractor get() {
        return c(this.f27720a.get(), this.f27721b.get(), this.f27722c.get());
    }
}
