package ee.mtakso.driver.ui.screens.settings.language;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.interactor.settings.GetLanguageSettingsInteractor;
import ee.mtakso.driver.ui.interactor.settings.SetLanguageInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class LanguageSettingsViewModel_Factory implements Factory<LanguageSettingsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<GetLanguageSettingsInteractor> f33205a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SetLanguageInteractor> f33206b;

    public LanguageSettingsViewModel_Factory(Provider<GetLanguageSettingsInteractor> provider, Provider<SetLanguageInteractor> provider2) {
        this.f33205a = provider;
        this.f33206b = provider2;
    }

    public static LanguageSettingsViewModel_Factory a(Provider<GetLanguageSettingsInteractor> provider, Provider<SetLanguageInteractor> provider2) {
        return new LanguageSettingsViewModel_Factory(provider, provider2);
    }

    public static LanguageSettingsViewModel c(GetLanguageSettingsInteractor getLanguageSettingsInteractor, SetLanguageInteractor setLanguageInteractor) {
        return new LanguageSettingsViewModel(getLanguageSettingsInteractor, setLanguageInteractor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LanguageSettingsViewModel get() {
        return c(this.f33205a.get(), this.f33206b.get());
    }
}
