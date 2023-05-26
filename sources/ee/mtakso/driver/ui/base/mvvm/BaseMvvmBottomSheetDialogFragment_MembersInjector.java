package ee.mtakso.driver.ui.base.mvvm;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import eu.bolt.driver.core.permission.PermissionManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class BaseMvvmBottomSheetDialogFragment_MembersInjector<T extends BaseViewModel> implements MembersInjector<BaseMvvmBottomSheetDialogFragment<T>> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment.permissionManager")
    public static <T extends BaseViewModel> void a(BaseMvvmBottomSheetDialogFragment<T> baseMvvmBottomSheetDialogFragment, PermissionManager permissionManager) {
        baseMvvmBottomSheetDialogFragment.f26244m = permissionManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment.screenAnalytics")
    public static <T extends BaseViewModel> void b(BaseMvvmBottomSheetDialogFragment<T> baseMvvmBottomSheetDialogFragment, ScreenAnalytics screenAnalytics) {
        baseMvvmBottomSheetDialogFragment.f26242k = screenAnalytics;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment.viewModelFactory")
    public static <T extends BaseViewModel> void c(BaseMvvmBottomSheetDialogFragment<T> baseMvvmBottomSheetDialogFragment, ViewModelFactory viewModelFactory) {
        baseMvvmBottomSheetDialogFragment.f26243l = viewModelFactory;
    }
}
