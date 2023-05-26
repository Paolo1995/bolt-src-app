package ee.mtakso.driver.service.quickaccess;

import android.view.WindowManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.navigation.NavigationManager;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics;
import ee.mtakso.driver.service.chat.ChatActiveOrderSource;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.screens.order.v2.order.NavigationTargetInteractor;
import ee.mtakso.driver.ui.views.quickaccess.QuickAccessPrefsManager;
import ee.mtakso.driver.utils.BackgroundManager;
import eu.bolt.driver.chat.service.ChatManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class QuickAccessService_MembersInjector implements MembersInjector<QuickAccessService> {
    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.backgroundManager")
    public static void a(QuickAccessService quickAccessService, BackgroundManager backgroundManager) {
        quickAccessService.f25739i = backgroundManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.chatManager")
    public static void b(QuickAccessService quickAccessService, ChatManager chatManager) {
        quickAccessService.f25749s = chatManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.chatOrderProvider")
    public static void c(QuickAccessService quickAccessService, ChatActiveOrderSource chatActiveOrderSource) {
        quickAccessService.f25750t = chatActiveOrderSource;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.driverProvider")
    public static void d(QuickAccessService quickAccessService, DriverProvider driverProvider) {
        quickAccessService.f25737g = driverProvider;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.features")
    public static void e(QuickAccessService quickAccessService, Features features) {
        quickAccessService.f25745o = features;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.locationManager")
    public static void f(QuickAccessService quickAccessService, GeoLocationManager geoLocationManager) {
        quickAccessService.f25748r = geoLocationManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.navigationManager")
    public static void g(QuickAccessService quickAccessService, NavigationManager navigationManager) {
        quickAccessService.f25744n = navigationManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.navigationTargetInteractor")
    public static void h(QuickAccessService quickAccessService, NavigationTargetInteractor navigationTargetInteractor) {
        quickAccessService.f25743m = navigationTargetInteractor;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.orderFlowAnalytics")
    public static void i(QuickAccessService quickAccessService, OrderFlowAnalytics orderFlowAnalytics) {
        quickAccessService.f25746p = orderFlowAnalytics;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.orderProvider")
    public static void j(QuickAccessService quickAccessService, OrderProvider orderProvider) {
        quickAccessService.f25736f = orderProvider;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.orderStateManager")
    public static void k(QuickAccessService quickAccessService, OrderStateManager orderStateManager) {
        quickAccessService.f25742l = orderStateManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.quickAccessOrderPrefsMapper")
    public static void l(QuickAccessService quickAccessService, QuickAccessPrefsManager quickAccessPrefsManager) {
        quickAccessService.f25747q = quickAccessPrefsManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.statusSender")
    public static void m(QuickAccessService quickAccessService, DriverStatusSender driverStatusSender) {
        quickAccessService.f25738h = driverStatusSender;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.surgeManager")
    public static void n(QuickAccessService quickAccessService, SurgeManager surgeManager) {
        quickAccessService.f25741k = surgeManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.service.quickaccess.QuickAccessService.windowManager")
    public static void o(QuickAccessService quickAccessService, WindowManager windowManager) {
        quickAccessService.f25740j = windowManager;
    }
}
