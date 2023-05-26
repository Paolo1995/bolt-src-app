package ee.mtakso.driver.ui.screens.order.v2.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverInteractor_Factory implements Factory<DriverInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f32079a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<NavigationAppTypeFactory> f32080b;

    public DriverInteractor_Factory(Provider<DriverProvider> provider, Provider<NavigationAppTypeFactory> provider2) {
        this.f32079a = provider;
        this.f32080b = provider2;
    }

    public static DriverInteractor_Factory a(Provider<DriverProvider> provider, Provider<NavigationAppTypeFactory> provider2) {
        return new DriverInteractor_Factory(provider, provider2);
    }

    public static DriverInteractor c(DriverProvider driverProvider, NavigationAppTypeFactory navigationAppTypeFactory) {
        return new DriverInteractor(driverProvider, navigationAppTypeFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverInteractor get() {
        return c(this.f32079a.get(), this.f32080b.get());
    }
}
