package ee.mtakso.driver.ui.base.mvvm;

import androidx.fragment.app.FragmentFactory;
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
public final class BaseMvvmActivity_MembersInjector<T extends BaseViewModel> implements MembersInjector<BaseMvvmActivity<T>> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity.fragmentFactory")
    public static <T extends BaseViewModel> void a(BaseMvvmActivity<T> baseMvvmActivity, FragmentFactory fragmentFactory) {
        baseMvvmActivity.f26239i = fragmentFactory;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity.permissionsManager")
    public static <T extends BaseViewModel> void b(BaseMvvmActivity<T> baseMvvmActivity, PermissionManager permissionManager) {
        baseMvvmActivity.f26238h = permissionManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity.screenAnalytics")
    public static <T extends BaseViewModel> void c(BaseMvvmActivity<T> baseMvvmActivity, ScreenAnalytics screenAnalytics) {
        baseMvvmActivity.f26236f = screenAnalytics;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity.viewModelFactory")
    public static <T extends BaseViewModel> void d(BaseMvvmActivity<T> baseMvvmActivity, ViewModelFactory viewModelFactory) {
        baseMvvmActivity.f26237g = viewModelFactory;
    }
}
