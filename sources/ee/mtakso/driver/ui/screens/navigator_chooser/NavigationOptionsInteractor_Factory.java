package ee.mtakso.driver.ui.screens.navigator_chooser;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.navigation.DynamicNavigationMapper;
import ee.mtakso.driver.network.client.driver.navigation.DriverNavigationConfigurationClient;
import ee.mtakso.driver.utils.AppResolver;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NavigationOptionsInteractor_Factory implements Factory<NavigationOptionsInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverNavigationConfigurationClient> f30899a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AppResolver> f30900b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DynamicNavigationMapper> f30901c;

    public NavigationOptionsInteractor_Factory(Provider<DriverNavigationConfigurationClient> provider, Provider<AppResolver> provider2, Provider<DynamicNavigationMapper> provider3) {
        this.f30899a = provider;
        this.f30900b = provider2;
        this.f30901c = provider3;
    }

    public static NavigationOptionsInteractor_Factory a(Provider<DriverNavigationConfigurationClient> provider, Provider<AppResolver> provider2, Provider<DynamicNavigationMapper> provider3) {
        return new NavigationOptionsInteractor_Factory(provider, provider2, provider3);
    }

    public static NavigationOptionsInteractor c(DriverNavigationConfigurationClient driverNavigationConfigurationClient, AppResolver appResolver, DynamicNavigationMapper dynamicNavigationMapper) {
        return new NavigationOptionsInteractor(driverNavigationConfigurationClient, appResolver, dynamicNavigationMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NavigationOptionsInteractor get() {
        return c(this.f30899a.get(), this.f30900b.get(), this.f30901c.get());
    }
}
