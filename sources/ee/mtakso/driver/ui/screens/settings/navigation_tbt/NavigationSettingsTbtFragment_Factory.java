package ee.mtakso.driver.ui.screens.settings.navigation_tbt;

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
public final class NavigationSettingsTbtFragment_Factory implements Factory<NavigationSettingsTbtFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33214a;

    public NavigationSettingsTbtFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f33214a = provider;
    }

    public static NavigationSettingsTbtFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new NavigationSettingsTbtFragment_Factory(provider);
    }

    public static NavigationSettingsTbtFragment c(BaseUiDependencies baseUiDependencies) {
        return new NavigationSettingsTbtFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NavigationSettingsTbtFragment get() {
        return c(this.f33214a.get());
    }
}
