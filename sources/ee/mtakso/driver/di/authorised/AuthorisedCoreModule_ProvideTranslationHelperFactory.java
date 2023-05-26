package ee.mtakso.driver.di.authorised;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.ui.translation.v2.TranslationHelper;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthorisedCoreModule_ProvideTranslationHelperFactory implements Factory<TranslationHelper> {
    public static TranslationHelper a(AuthorisedCoreModule authorisedCoreModule) {
        return (TranslationHelper) Preconditions.checkNotNullFromProvides(authorisedCoreModule.f());
    }
}
