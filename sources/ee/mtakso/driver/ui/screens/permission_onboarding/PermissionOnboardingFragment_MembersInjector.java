package ee.mtakso.driver.ui.screens.permission_onboarding;

import android.os.PowerManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.AnalyticsManager;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PermissionOnboardingFragment_MembersInjector implements MembersInjector<PermissionOnboardingFragment> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment.analyticsManager")
    public static void a(PermissionOnboardingFragment permissionOnboardingFragment, AnalyticsManager analyticsManager) {
        permissionOnboardingFragment.f32487f = analyticsManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment.driverProvider")
    public static void b(PermissionOnboardingFragment permissionOnboardingFragment, DriverProvider driverProvider) {
        permissionOnboardingFragment.f32489h = driverProvider;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment.loginAnalytics")
    public static void c(PermissionOnboardingFragment permissionOnboardingFragment, LoginAnalytics loginAnalytics) {
        permissionOnboardingFragment.f32491j = loginAnalytics;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment.onBoardingManager")
    public static void d(PermissionOnboardingFragment permissionOnboardingFragment, OnBoardingManager onBoardingManager) {
        permissionOnboardingFragment.f32488g = onBoardingManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment.powerManager")
    public static void e(PermissionOnboardingFragment permissionOnboardingFragment, PowerManager powerManager) {
        permissionOnboardingFragment.f32490i = powerManager;
    }
}
