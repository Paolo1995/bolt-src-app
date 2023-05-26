package ee.mtakso.driver.ui.screens.countypicker;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CountryPickerViewModel_Factory implements Factory<CountryPickerViewModel> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final CountryPickerViewModel_Factory f28127a = new CountryPickerViewModel_Factory();

        private InstanceHolder() {
        }
    }

    public static CountryPickerViewModel_Factory a() {
        return InstanceHolder.f28127a;
    }

    public static CountryPickerViewModel c() {
        return new CountryPickerViewModel();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CountryPickerViewModel get() {
        return c();
    }
}
