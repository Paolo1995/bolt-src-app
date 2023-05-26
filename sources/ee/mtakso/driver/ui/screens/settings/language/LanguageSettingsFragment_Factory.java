package ee.mtakso.driver.ui.screens.settings.language;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes5.dex */
public final class LanguageSettingsFragment_Factory implements Factory<LanguageSettingsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33198a;

    public LanguageSettingsFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f33198a = provider;
    }

    public static LanguageSettingsFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new LanguageSettingsFragment_Factory(provider);
    }

    public static LanguageSettingsFragment c(BaseUiDependencies baseUiDependencies) {
        return new LanguageSettingsFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public LanguageSettingsFragment get() {
        return c(this.f33198a.get());
    }
}
