package ee.mtakso.driver.ui.screens.settings;

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
public final class NavigationSettingsFragment_Factory implements Factory<NavigationSettingsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33019a;

    public NavigationSettingsFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f33019a = provider;
    }

    public static NavigationSettingsFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new NavigationSettingsFragment_Factory(provider);
    }

    public static NavigationSettingsFragment c(BaseUiDependencies baseUiDependencies) {
        return new NavigationSettingsFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NavigationSettingsFragment get() {
        return c(this.f33019a.get());
    }
}
