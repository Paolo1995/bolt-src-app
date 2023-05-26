package ee.mtakso.driver.ui.screens.order.v2;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.common.push.PushDialogDelegate;
import ee.mtakso.driver.ui.helper.ErrorHandler;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.DialerLauncher;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ActiveRideActivity_MembersInjector implements MembersInjector<ActiveRideActivity> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity.appThemeManager")
    public static void a(ActiveRideActivity activeRideActivity, AppThemeManager appThemeManager) {
        activeRideActivity.f31866w = appThemeManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity.dialerLauncher")
    public static void b(ActiveRideActivity activeRideActivity, DialerLauncher dialerLauncher) {
        activeRideActivity.f31858o = dialerLauncher;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity.driverConfig")
    public static void c(ActiveRideActivity activeRideActivity, DriverConfig driverConfig) {
        activeRideActivity.f31860q = driverConfig;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity.driverProvider")
    public static void d(ActiveRideActivity activeRideActivity, DriverProvider driverProvider) {
        activeRideActivity.f31859p = driverProvider;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity.errorHandler")
    public static void e(ActiveRideActivity activeRideActivity, ErrorHandler errorHandler) {
        activeRideActivity.f31862s = errorHandler;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity.htmlEngine")
    public static void f(ActiveRideActivity activeRideActivity, HtmlEngine htmlEngine) {
        activeRideActivity.f31868y = htmlEngine;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity.languageManager")
    public static void g(ActiveRideActivity activeRideActivity, LanguageManager languageManager) {
        activeRideActivity.f31865v = languageManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity.pushDialogDelegate")
    public static void h(ActiveRideActivity activeRideActivity, PushDialogDelegate pushDialogDelegate) {
        activeRideActivity.f31863t = pushDialogDelegate;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity.routingManager")
    public static void i(ActiveRideActivity activeRideActivity, RoutingManager routingManager) {
        activeRideActivity.f31867x = routingManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity.uiNotificationManager")
    public static void j(ActiveRideActivity activeRideActivity, UiNotificationManager uiNotificationManager) {
        activeRideActivity.f31861r = uiNotificationManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity.urlLauncher")
    public static void k(ActiveRideActivity activeRideActivity, CompositeUrlLauncher compositeUrlLauncher) {
        activeRideActivity.f31864u = compositeUrlLauncher;
    }
}
