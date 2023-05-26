package ee.mtakso.driver.ui.interactor.settings;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GetLanguageSettingsInteractor_Factory implements Factory<GetLanguageSettingsInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<LanguageManager> f26906a;

    public GetLanguageSettingsInteractor_Factory(Provider<LanguageManager> provider) {
        this.f26906a = provider;
    }

    public static GetLanguageSettingsInteractor_Factory a(Provider<LanguageManager> provider) {
        return new GetLanguageSettingsInteractor_Factory(provider);
    }

    public static GetLanguageSettingsInteractor c(LanguageManager languageManager) {
        return new GetLanguageSettingsInteractor(languageManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GetLanguageSettingsInteractor get() {
        return c(this.f26906a.get());
    }
}
