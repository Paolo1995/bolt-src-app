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
public final class AccountSettingsFragment_Factory implements Factory<AccountSettingsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f32987a;

    public AccountSettingsFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f32987a = provider;
    }

    public static AccountSettingsFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new AccountSettingsFragment_Factory(provider);
    }

    public static AccountSettingsFragment c(BaseUiDependencies baseUiDependencies) {
        return new AccountSettingsFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AccountSettingsFragment get() {
        return c(this.f32987a.get());
    }
}
