package ee.mtakso.driver.di.authorised;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.language.LanguageListProviderImpl;
import eu.bolt.driver.core.language.LanguageManager;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthorisedCoreModule_ProvideLanguageManagerFactory implements Factory<LanguageManager> {
    public static LanguageManager a(AuthorisedCoreModule authorisedCoreModule, DriverProvider driverProvider, Context context, LanguageListProviderImpl languageListProviderImpl) {
        return (LanguageManager) Preconditions.checkNotNullFromProvides(authorisedCoreModule.c(driverProvider, context, languageListProviderImpl));
    }
}
