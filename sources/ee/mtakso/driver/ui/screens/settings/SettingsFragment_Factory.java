package ee.mtakso.driver.ui.screens.settings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes5.dex */
public final class SettingsFragment_Factory implements Factory<SettingsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33052a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TweaksMenu> f33053b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f33054c;

    public SettingsFragment_Factory(Provider<BaseUiDependencies> provider, Provider<TweaksMenu> provider2, Provider<DriverProvider> provider3) {
        this.f33052a = provider;
        this.f33053b = provider2;
        this.f33054c = provider3;
    }

    public static SettingsFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<TweaksMenu> provider2, Provider<DriverProvider> provider3) {
        return new SettingsFragment_Factory(provider, provider2, provider3);
    }

    public static SettingsFragment c(BaseUiDependencies baseUiDependencies, TweaksMenu tweaksMenu, DriverProvider driverProvider) {
        return new SettingsFragment(baseUiDependencies, tweaksMenu, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SettingsFragment get() {
        return c(this.f33052a.get(), this.f33053b.get(), this.f33054c.get());
    }
}
