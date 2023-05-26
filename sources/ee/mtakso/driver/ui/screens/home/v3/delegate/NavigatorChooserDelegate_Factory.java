package ee.mtakso.driver.ui.screens.home.v3.delegate;

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
public final class NavigatorChooserDelegate_Factory implements Factory<NavigatorChooserDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f29879a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<NavigationAppTypeFactory> f29880b;

    public NavigatorChooserDelegate_Factory(Provider<DriverProvider> provider, Provider<NavigationAppTypeFactory> provider2) {
        this.f29879a = provider;
        this.f29880b = provider2;
    }

    public static NavigatorChooserDelegate_Factory a(Provider<DriverProvider> provider, Provider<NavigationAppTypeFactory> provider2) {
        return new NavigatorChooserDelegate_Factory(provider, provider2);
    }

    public static NavigatorChooserDelegate c(DriverProvider driverProvider, NavigationAppTypeFactory navigationAppTypeFactory) {
        return new NavigatorChooserDelegate(driverProvider, navigationAppTypeFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NavigatorChooserDelegate get() {
        return c(this.f29879a.get(), this.f29880b.get());
    }
}
