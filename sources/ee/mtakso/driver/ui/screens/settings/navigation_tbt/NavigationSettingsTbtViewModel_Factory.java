package ee.mtakso.driver.ui.screens.settings.navigation_tbt;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.core.PlatformManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class NavigationSettingsTbtViewModel_Factory implements Factory<NavigationSettingsTbtViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f33223a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PlatformManager> f33224b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<NavigationAppTypeFactory> f33225c;

    public NavigationSettingsTbtViewModel_Factory(Provider<DriverProvider> provider, Provider<PlatformManager> provider2, Provider<NavigationAppTypeFactory> provider3) {
        this.f33223a = provider;
        this.f33224b = provider2;
        this.f33225c = provider3;
    }

    public static NavigationSettingsTbtViewModel_Factory a(Provider<DriverProvider> provider, Provider<PlatformManager> provider2, Provider<NavigationAppTypeFactory> provider3) {
        return new NavigationSettingsTbtViewModel_Factory(provider, provider2, provider3);
    }

    public static NavigationSettingsTbtViewModel c(DriverProvider driverProvider, PlatformManager platformManager, NavigationAppTypeFactory navigationAppTypeFactory) {
        return new NavigationSettingsTbtViewModel(driverProvider, platformManager, navigationAppTypeFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NavigationSettingsTbtViewModel get() {
        return c(this.f33223a.get(), this.f33224b.get(), this.f33225c.get());
    }
}
