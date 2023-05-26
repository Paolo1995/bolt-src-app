package ee.mtakso.driver.ui.screens.countypicker;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CountryPickerFragment_Factory implements Factory<CountryPickerFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28123a;

    public CountryPickerFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f28123a = provider;
    }

    public static CountryPickerFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new CountryPickerFragment_Factory(provider);
    }

    public static CountryPickerFragment c(BaseUiDependencies baseUiDependencies) {
        return new CountryPickerFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CountryPickerFragment get() {
        return c(this.f28123a.get());
    }
}
