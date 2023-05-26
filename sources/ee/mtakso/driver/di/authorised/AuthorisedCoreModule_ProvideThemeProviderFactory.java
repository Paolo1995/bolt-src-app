package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.ui.theme.DriverThemeProvider;
import eu.bolt.driver.core.ui.theme.ThemeProvider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthorisedCoreModule_ProvideThemeProviderFactory implements Factory<ThemeProvider> {
    public static ThemeProvider a(AuthorisedCoreModule authorisedCoreModule, DriverThemeProvider driverThemeProvider) {
        return (ThemeProvider) Preconditions.checkNotNullFromProvides(authorisedCoreModule.e(driverThemeProvider));
    }
}
