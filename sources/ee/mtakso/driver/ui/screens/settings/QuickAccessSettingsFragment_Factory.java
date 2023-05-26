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
public final class QuickAccessSettingsFragment_Factory implements Factory<QuickAccessSettingsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33024a;

    public QuickAccessSettingsFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f33024a = provider;
    }

    public static QuickAccessSettingsFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new QuickAccessSettingsFragment_Factory(provider);
    }

    public static QuickAccessSettingsFragment c(BaseUiDependencies baseUiDependencies) {
        return new QuickAccessSettingsFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public QuickAccessSettingsFragment get() {
        return c(this.f33024a.get());
    }
}
