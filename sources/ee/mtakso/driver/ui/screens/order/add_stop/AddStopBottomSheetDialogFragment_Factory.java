package ee.mtakso.driver.ui.screens.order.add_stop;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class AddStopBottomSheetDialogFragment_Factory implements Factory<AddStopBottomSheetDialogFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f30980a;

    public AddStopBottomSheetDialogFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f30980a = provider;
    }

    public static AddStopBottomSheetDialogFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new AddStopBottomSheetDialogFragment_Factory(provider);
    }

    public static AddStopBottomSheetDialogFragment c(BaseUiDependencies baseUiDependencies) {
        return new AddStopBottomSheetDialogFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AddStopBottomSheetDialogFragment get() {
        return c(this.f30980a.get());
    }
}
