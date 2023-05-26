package ee.mtakso.driver.ui.screens.settings.theme;

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
public final class ThemeSettingsFragment_Factory implements Factory<ThemeSettingsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33303a;

    public ThemeSettingsFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f33303a = provider;
    }

    public static ThemeSettingsFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new ThemeSettingsFragment_Factory(provider);
    }

    public static ThemeSettingsFragment c(BaseUiDependencies baseUiDependencies) {
        return new ThemeSettingsFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ThemeSettingsFragment get() {
        return c(this.f33303a.get());
    }
}
