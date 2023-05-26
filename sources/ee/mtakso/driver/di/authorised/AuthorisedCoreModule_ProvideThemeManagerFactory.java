package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import eu.bolt.driver.core.theme.ThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthorisedCoreModule_ProvideThemeManagerFactory implements Factory<ThemeManager> {

    /* renamed from: a  reason: collision with root package name */
    private final AuthorisedCoreModule f20287a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f20288b;

    public AuthorisedCoreModule_ProvideThemeManagerFactory(AuthorisedCoreModule authorisedCoreModule, Provider<DriverProvider> provider) {
        this.f20287a = authorisedCoreModule;
        this.f20288b = provider;
    }

    public static AuthorisedCoreModule_ProvideThemeManagerFactory a(AuthorisedCoreModule authorisedCoreModule, Provider<DriverProvider> provider) {
        return new AuthorisedCoreModule_ProvideThemeManagerFactory(authorisedCoreModule, provider);
    }

    public static ThemeManager c(AuthorisedCoreModule authorisedCoreModule, DriverProvider driverProvider) {
        return (ThemeManager) Preconditions.checkNotNullFromProvides(authorisedCoreModule.d(driverProvider));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ThemeManager get() {
        return c(this.f20287a, this.f20288b.get());
    }
}
