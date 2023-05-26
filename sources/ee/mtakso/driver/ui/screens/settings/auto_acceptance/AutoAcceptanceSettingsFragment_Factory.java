package ee.mtakso.driver.ui.screens.settings.auto_acceptance;

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
public final class AutoAcceptanceSettingsFragment_Factory implements Factory<AutoAcceptanceSettingsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33159a;

    public AutoAcceptanceSettingsFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f33159a = provider;
    }

    public static AutoAcceptanceSettingsFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new AutoAcceptanceSettingsFragment_Factory(provider);
    }

    public static AutoAcceptanceSettingsFragment c(BaseUiDependencies baseUiDependencies) {
        return new AutoAcceptanceSettingsFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AutoAcceptanceSettingsFragment get() {
        return c(this.f33159a.get());
    }
}
