package ee.mtakso.driver.di.anonymous;

import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnonymousStaffModule.kt */
@Module
/* loaded from: classes3.dex */
public final class AnonymousStaffModule {
    @Provides
    public final BaseUiDependencies a(ScreenAnalytics screenAnalytics, ViewModelFactory viewModelFactory, PermissionManager permissionManager, AppThemeManager appThemeManager) {
        Intrinsics.f(screenAnalytics, "screenAnalytics");
        Intrinsics.f(viewModelFactory, "viewModelFactory");
        Intrinsics.f(permissionManager, "permissionManager");
        Intrinsics.f(appThemeManager, "appThemeManager");
        return new BaseUiDependencies(screenAnalytics, viewModelFactory, permissionManager, appThemeManager);
    }
}
