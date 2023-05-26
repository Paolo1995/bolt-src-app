package ee.mtakso.driver.ui.screens.permission_onboarding;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import eu.bolt.driver.core.theme.AppThemeManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PermissionOnboardingActivity_MembersInjector implements MembersInjector<PermissionOnboardingActivity> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingActivity.appThemeManager")
    public static void a(PermissionOnboardingActivity permissionOnboardingActivity, AppThemeManager appThemeManager) {
        permissionOnboardingActivity.f32480n = appThemeManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingActivity.driverProvider")
    public static void b(PermissionOnboardingActivity permissionOnboardingActivity, DriverProvider driverProvider) {
        permissionOnboardingActivity.f32477k = driverProvider;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingActivity.loginAnalytics")
    public static void c(PermissionOnboardingActivity permissionOnboardingActivity, LoginAnalytics loginAnalytics) {
        permissionOnboardingActivity.f32479m = loginAnalytics;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingActivity.onBoardingManager")
    public static void d(PermissionOnboardingActivity permissionOnboardingActivity, OnBoardingManager onBoardingManager) {
        permissionOnboardingActivity.f32478l = onBoardingManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingActivity.routingManager")
    public static void e(PermissionOnboardingActivity permissionOnboardingActivity, AppRoutingManager appRoutingManager) {
        permissionOnboardingActivity.f32476j = appRoutingManager;
    }
}
