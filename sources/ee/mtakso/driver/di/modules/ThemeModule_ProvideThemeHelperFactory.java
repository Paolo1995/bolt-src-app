package ee.mtakso.driver.di.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import eu.bolt.driver.core.theme.ThemeHelper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ThemeModule_ProvideThemeHelperFactory implements Factory<ThemeHelper> {

    /* renamed from: a  reason: collision with root package name */
    private final ThemeModule f20874a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f20875b;

    public ThemeModule_ProvideThemeHelperFactory(ThemeModule themeModule, Provider<DriverProvider> provider) {
        this.f20874a = themeModule;
        this.f20875b = provider;
    }

    public static ThemeModule_ProvideThemeHelperFactory a(ThemeModule themeModule, Provider<DriverProvider> provider) {
        return new ThemeModule_ProvideThemeHelperFactory(themeModule, provider);
    }

    public static ThemeHelper c(ThemeModule themeModule, DriverProvider driverProvider) {
        return (ThemeHelper) Preconditions.checkNotNullFromProvides(themeModule.a(driverProvider));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ThemeHelper get() {
        return c(this.f20874a, this.f20875b.get());
    }
}
