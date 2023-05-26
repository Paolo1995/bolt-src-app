package ee.mtakso.driver.di.modules;

import dagger.Binds;
import dagger.Module;
import ee.mtakso.driver.service.language.LanguageListProviderImpl;
import ee.mtakso.driver.service.language.LanguageSettingsStorageImpl;
import eu.bolt.driver.core.ui.translation.language.LanguageListProvider;
import eu.bolt.driver.core.ui.translation.language.LanguageSettingsStorage;

/* compiled from: LanguageBindings.kt */
@Module
/* loaded from: classes3.dex */
public interface LanguageBindings {
    @Binds
    LanguageSettingsStorage a(LanguageSettingsStorageImpl languageSettingsStorageImpl);

    @Binds
    LanguageListProvider b(LanguageListProviderImpl languageListProviderImpl);
}
