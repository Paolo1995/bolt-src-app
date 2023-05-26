package ee.mtakso.driver.di.authorised;

import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.voip.service.order.CurrentOrderInfoProvider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorisedStaffModule.kt */
@Module
/* loaded from: classes3.dex */
public final class AuthorisedStaffModule {
    @Provides
    public final CurrentOrderInfoProvider a(VoipOrderInformationDelegate impl) {
        Intrinsics.f(impl, "impl");
        return impl;
    }

    @Provides
    public final BaseUiDependencies b(ScreenAnalytics screenAnalytics, ViewModelFactory viewModelFactory, PermissionManager permissionManager, AppThemeManager appThemeManager) {
        Intrinsics.f(screenAnalytics, "screenAnalytics");
        Intrinsics.f(viewModelFactory, "viewModelFactory");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(appThemeManager, "appThemeManager");
        return new BaseUiDependencies(screenAnalytics, viewModelFactory, permissionManager, appThemeManager);
    }
}
