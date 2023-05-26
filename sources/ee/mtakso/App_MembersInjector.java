package ee.mtakso;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.identity.verification.IdentityVerificationCoordinator;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.integration.clevertap.CleverTapCoordinator;
import ee.mtakso.driver.ui.screens.home.v3.DeeplinkHomeContainerCoordinator;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.DeeplinkCoordinator;
import ee.mtakso.driver.ui.screens.login.v2.RouterFragmentCoordinator;
import ee.mtakso.driver.utils.ActivityLifecycleLoggingManager;
import ee.mtakso.driver.utils.customtabs.CustomTabsUrlLauncher;
import ee.mtakso.driver.utils.urlcomand.DriverPortalUrlCoordinator;
import ee.mtakso.driver.utils.urlcomand.UrlCoordinator;
import eu.bolt.driver.chat.ui.ChatForegroundTracker;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.coordinator.ActivitiesStackClassCoordinator;
import eu.bolt.driver.core.ui.routing.coordinator.ActivityClassCoordinator;
import eu.bolt.driver.core.ui.routing.coordinator.ActivityIntentCoordinator;
import eu.bolt.driver.core.ui.routing.coordinator.DialogFragmentCoordinator;
import eu.bolt.driver.core.ui.routing.state.StateTracker;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class App_MembersInjector implements MembersInjector<App> {
    @InjectedFieldSignature("ee.mtakso.App.activitiesStackClassCoordinator")
    public static void a(App app, ActivitiesStackClassCoordinator activitiesStackClassCoordinator) {
        app.f19811l = activitiesStackClassCoordinator;
    }

    @InjectedFieldSignature("ee.mtakso.App.activityClassCoordinator")
    public static void b(App app, ActivityClassCoordinator activityClassCoordinator) {
        app.f19810k = activityClassCoordinator;
    }

    @InjectedFieldSignature("ee.mtakso.App.activityIntentCoordinator")
    public static void c(App app, ActivityIntentCoordinator activityIntentCoordinator) {
        app.f19812m = activityIntentCoordinator;
    }

    @InjectedFieldSignature("ee.mtakso.App.activityLifecycleLoggingManager")
    public static void d(App app, ActivityLifecycleLoggingManager activityLifecycleLoggingManager) {
        app.f19805f = activityLifecycleLoggingManager;
    }

    @InjectedFieldSignature("ee.mtakso.App.chatForegroundTracker")
    public static void e(App app, ChatForegroundTracker chatForegroundTracker) {
        app.f19806g = chatForegroundTracker;
    }

    @InjectedFieldSignature("ee.mtakso.App.cleverTapCoordinator")
    public static void f(App app, CleverTapCoordinator cleverTapCoordinator) {
        app.f19816q = cleverTapCoordinator;
    }

    @InjectedFieldSignature("ee.mtakso.App.customTabsUrlLauncher")
    public static void g(App app, CustomTabsUrlLauncher customTabsUrlLauncher) {
        app.f19822w = customTabsUrlLauncher;
    }

    @InjectedFieldSignature("ee.mtakso.App.deeplinkCoordinator")
    public static void h(App app, DeeplinkCoordinator deeplinkCoordinator) {
        app.f19815p = deeplinkCoordinator;
    }

    @InjectedFieldSignature("ee.mtakso.App.deeplinkHomeContainerIntentCoordinator")
    public static void i(App app, DeeplinkHomeContainerCoordinator deeplinkHomeContainerCoordinator) {
        app.f19814o = deeplinkHomeContainerCoordinator;
    }

    @InjectedFieldSignature("ee.mtakso.App.dialogFragmentCoordinator")
    public static void j(App app, DialogFragmentCoordinator dialogFragmentCoordinator) {
        app.f19820u = dialogFragmentCoordinator;
    }

    @InjectedFieldSignature("ee.mtakso.App.driverPortalUrlCoordinator")
    public static void k(App app, DriverPortalUrlCoordinator driverPortalUrlCoordinator) {
        app.f19818s = driverPortalUrlCoordinator;
    }

    @InjectedFieldSignature("ee.mtakso.App.driverProvider")
    public static void l(App app, DriverProvider driverProvider) {
        app.f19807h = driverProvider;
    }

    @InjectedFieldSignature("ee.mtakso.App.identityVerificationCoordinator")
    public static void m(App app, IdentityVerificationCoordinator identityVerificationCoordinator) {
        app.f19819t = identityVerificationCoordinator;
    }

    @InjectedFieldSignature("ee.mtakso.App.permissionManager")
    public static void n(App app, PermissionManager permissionManager) {
        app.f19821v = permissionManager;
    }

    @InjectedFieldSignature("ee.mtakso.App.routerCoordinator")
    public static void o(App app, RouterFragmentCoordinator routerFragmentCoordinator) {
        app.f19813n = routerFragmentCoordinator;
    }

    @InjectedFieldSignature("ee.mtakso.App.routingManager")
    public static void p(App app, RoutingManager routingManager) {
        app.f19809j = routingManager;
    }

    @InjectedFieldSignature("ee.mtakso.App.stateTracker")
    public static void q(App app, StateTracker stateTracker) {
        app.f19808i = stateTracker;
    }

    @InjectedFieldSignature("ee.mtakso.App.urlCoordinator")
    public static void r(App app, UrlCoordinator urlCoordinator) {
        app.f19817r = urlCoordinator;
    }
}
