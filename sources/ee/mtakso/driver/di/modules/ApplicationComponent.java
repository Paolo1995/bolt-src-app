package ee.mtakso.driver.di.modules;

import dagger.BindsInstance;
import ee.mtakso.App;
import ee.mtakso.driver.di.anonymous.AnonymousModuleDeps;
import ee.mtakso.driver.di.authorised.AuthorisedModuleDeps;
import ee.mtakso.driver.identity.verification.IdentityVerificationManager;
import ee.mtakso.driver.log.report.ReportManager;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.di.PlatformDependencies;
import ee.mtakso.driver.platform.security.SecurityManager;
import ee.mtakso.driver.service.AwakeService;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager;
import ee.mtakso.driver.service.quickaccess.QuickAccessService;
import ee.mtakso.driver.startup.AnalyticsInitializer;
import ee.mtakso.driver.startup.LogManagerInitializer;
import ee.mtakso.driver.startup.WorkManagerInitializer;
import ee.mtakso.driver.ui.screens.contact_methods.voip.service.VoipIntentService;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.cancels.CancelsFragment;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.hours.HoursFragment;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.rides.RidesFragment;
import ee.mtakso.driver.ui.screens.launch.LauncherActivity;
import ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment;
import eu.bolt.android.chat.ChatDependencyProvider;
import eu.bolt.driver.chat.di.DriverChatApplicationComponent;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;

/* loaded from: classes3.dex */
public interface ApplicationComponent extends AnonymousModuleDeps, AuthorisedModuleDeps, PlatformDependencies, DriverChatApplicationComponent {

    /* loaded from: classes3.dex */
    public interface Builder {
        @BindsInstance
        Builder a(App app);

        Builder b(ChatDependencyProvider chatDependencyProvider);

        ApplicationComponent build();
    }

    void B(WorkManagerInitializer workManagerInitializer);

    SecurityManager B1();

    void E(AwakeService awakeService);

    CleverTapManager G1();

    void H0(HoursFragment hoursFragment);

    IdentityVerificationManager I0();

    void K0(CancelsFragment cancelsFragment);

    void M0(LogManagerInitializer logManagerInitializer);

    void U0(LauncherActivity launcherActivity);

    void Y0(PermissionOnboardingFragment permissionOnboardingFragment);

    LanguageManager a();

    void c1(RidesFragment ridesFragment);

    ReportManager g1();

    void h(VoipIntentService voipIntentService);

    void k(App app);

    DriverProvider t();

    void v0(AnalyticsInitializer analyticsInitializer);

    AuthManager w0();

    void x(QuickAccessService quickAccessService);
}
