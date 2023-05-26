package ee.mtakso.driver.ui.screens.navigator_chooser;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.utils.AppResolver;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NavigatorChooserViewModel_Factory implements Factory<NavigatorChooserViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<NavigationAppTypeFactory> f30941a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PlatformManager> f30942b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f30943c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverFeatures> f30944d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<NavigationOptionsInteractor> f30945e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<AppResolver> f30946f;

    public NavigatorChooserViewModel_Factory(Provider<NavigationAppTypeFactory> provider, Provider<PlatformManager> provider2, Provider<DriverProvider> provider3, Provider<DriverFeatures> provider4, Provider<NavigationOptionsInteractor> provider5, Provider<AppResolver> provider6) {
        this.f30941a = provider;
        this.f30942b = provider2;
        this.f30943c = provider3;
        this.f30944d = provider4;
        this.f30945e = provider5;
        this.f30946f = provider6;
    }

    public static NavigatorChooserViewModel_Factory a(Provider<NavigationAppTypeFactory> provider, Provider<PlatformManager> provider2, Provider<DriverProvider> provider3, Provider<DriverFeatures> provider4, Provider<NavigationOptionsInteractor> provider5, Provider<AppResolver> provider6) {
        return new NavigatorChooserViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static NavigatorChooserViewModel c(NavigationAppTypeFactory navigationAppTypeFactory, PlatformManager platformManager, DriverProvider driverProvider, DriverFeatures driverFeatures, NavigationOptionsInteractor navigationOptionsInteractor, AppResolver appResolver) {
        return new NavigatorChooserViewModel(navigationAppTypeFactory, platformManager, driverProvider, driverFeatures, navigationOptionsInteractor, appResolver);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NavigatorChooserViewModel get() {
        return c(this.f30941a.get(), this.f30942b.get(), this.f30943c.get(), this.f30944d.get(), this.f30945e.get(), this.f30946f.get());
    }
}
