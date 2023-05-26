package ee.mtakso.driver.ui.screens.order.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.navigation.NavigationManager;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.b2b.B2bManager;
import ee.mtakso.driver.service.chat.ChatActiveOrderSource;
import ee.mtakso.driver.service.deviceinfo.DeviceInfoSender;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.service.modules.reminder.AutoReminder;
import ee.mtakso.driver.service.order.details.OrderManager;
import ee.mtakso.driver.service.order.details.OrderTryAgainManager;
import ee.mtakso.driver.ui.common.internet.InternetDataDelegate;
import ee.mtakso.driver.ui.common.push.PushDataService;
import ee.mtakso.driver.ui.interactor.call.NoAnswerIncomingCallInteractor;
import ee.mtakso.driver.ui.interactor.order.active.map.MapDataInteractor;
import ee.mtakso.driver.ui.interactor.warnings.AuthorizedWarningInteractor;
import ee.mtakso.driver.ui.screens.order.v2.driver.DriverInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.AutoAcceptedOrderInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.BottomSheetStateInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderDistanceInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderStateDataInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.PaidStopsStateInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.PriceInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.RouteSharingInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistInteractor;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.chat.service.ChatManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderViewModel_Factory implements Factory<OrderViewModel> {
    private final Provider<DidYouGetHelpInteractor> A;
    private final Provider<EmergencyAssistInteractor> B;
    private final Provider<GeoLocationManager> C;
    private final Provider<HtmlEngine> D;
    private final Provider<ChatManager> E;
    private final Provider<ChatActiveOrderSource> F;
    private final Provider<OrderTryAgainManager> G;
    private final Provider<OrderManager> H;
    private final Provider<DeviceInfoSender> I;
    private final Provider<AudioRecordingManager> J;

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrderDistanceInteractor> f32031a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AutoReminder> f32032b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<BottomSheetStateInteractor> f32033c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<MapDataInteractor> f32034d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverInteractor> f32035e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<OrderStateDataInteractor> f32036f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<NavigationManager> f32037g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<OrderStateManager> f32038h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<B2bManager> f32039i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<PriceInteractor> f32040j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<ChatAnalytics> f32041k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<SafetyToolkitAnalytics> f32042l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<InternetDataDelegate> f32043m;

    /* renamed from: n  reason: collision with root package name */
    private final Provider<NavigationAppTypeFactory> f32044n;

    /* renamed from: o  reason: collision with root package name */
    private final Provider<PushDataService> f32045o;

    /* renamed from: p  reason: collision with root package name */
    private final Provider<DriverProvider> f32046p;

    /* renamed from: q  reason: collision with root package name */
    private final Provider<DriverSettings> f32047q;

    /* renamed from: r  reason: collision with root package name */
    private final Provider<PaidStopsStateInteractor> f32048r;

    /* renamed from: s  reason: collision with root package name */
    private final Provider<ActiveRideDeeplinkInteractor> f32049s;

    /* renamed from: t  reason: collision with root package name */
    private final Provider<AutoAcceptedOrderInteractor> f32050t;

    /* renamed from: u  reason: collision with root package name */
    private final Provider<NoAnswerIncomingCallInteractor> f32051u;

    /* renamed from: v  reason: collision with root package name */
    private final Provider<AuthorizedWarningInteractor> f32052v;

    /* renamed from: w  reason: collision with root package name */
    private final Provider<OrderTracker> f32053w;

    /* renamed from: x  reason: collision with root package name */
    private final Provider<RateMePrefsManager> f32054x;

    /* renamed from: y  reason: collision with root package name */
    private final Provider<AppThemeManager> f32055y;

    /* renamed from: z  reason: collision with root package name */
    private final Provider<RouteSharingInteractor> f32056z;

    public OrderViewModel_Factory(Provider<OrderDistanceInteractor> provider, Provider<AutoReminder> provider2, Provider<BottomSheetStateInteractor> provider3, Provider<MapDataInteractor> provider4, Provider<DriverInteractor> provider5, Provider<OrderStateDataInteractor> provider6, Provider<NavigationManager> provider7, Provider<OrderStateManager> provider8, Provider<B2bManager> provider9, Provider<PriceInteractor> provider10, Provider<ChatAnalytics> provider11, Provider<SafetyToolkitAnalytics> provider12, Provider<InternetDataDelegate> provider13, Provider<NavigationAppTypeFactory> provider14, Provider<PushDataService> provider15, Provider<DriverProvider> provider16, Provider<DriverSettings> provider17, Provider<PaidStopsStateInteractor> provider18, Provider<ActiveRideDeeplinkInteractor> provider19, Provider<AutoAcceptedOrderInteractor> provider20, Provider<NoAnswerIncomingCallInteractor> provider21, Provider<AuthorizedWarningInteractor> provider22, Provider<OrderTracker> provider23, Provider<RateMePrefsManager> provider24, Provider<AppThemeManager> provider25, Provider<RouteSharingInteractor> provider26, Provider<DidYouGetHelpInteractor> provider27, Provider<EmergencyAssistInteractor> provider28, Provider<GeoLocationManager> provider29, Provider<HtmlEngine> provider30, Provider<ChatManager> provider31, Provider<ChatActiveOrderSource> provider32, Provider<OrderTryAgainManager> provider33, Provider<OrderManager> provider34, Provider<DeviceInfoSender> provider35, Provider<AudioRecordingManager> provider36) {
        this.f32031a = provider;
        this.f32032b = provider2;
        this.f32033c = provider3;
        this.f32034d = provider4;
        this.f32035e = provider5;
        this.f32036f = provider6;
        this.f32037g = provider7;
        this.f32038h = provider8;
        this.f32039i = provider9;
        this.f32040j = provider10;
        this.f32041k = provider11;
        this.f32042l = provider12;
        this.f32043m = provider13;
        this.f32044n = provider14;
        this.f32045o = provider15;
        this.f32046p = provider16;
        this.f32047q = provider17;
        this.f32048r = provider18;
        this.f32049s = provider19;
        this.f32050t = provider20;
        this.f32051u = provider21;
        this.f32052v = provider22;
        this.f32053w = provider23;
        this.f32054x = provider24;
        this.f32055y = provider25;
        this.f32056z = provider26;
        this.A = provider27;
        this.B = provider28;
        this.C = provider29;
        this.D = provider30;
        this.E = provider31;
        this.F = provider32;
        this.G = provider33;
        this.H = provider34;
        this.I = provider35;
        this.J = provider36;
    }

    public static OrderViewModel_Factory a(Provider<OrderDistanceInteractor> provider, Provider<AutoReminder> provider2, Provider<BottomSheetStateInteractor> provider3, Provider<MapDataInteractor> provider4, Provider<DriverInteractor> provider5, Provider<OrderStateDataInteractor> provider6, Provider<NavigationManager> provider7, Provider<OrderStateManager> provider8, Provider<B2bManager> provider9, Provider<PriceInteractor> provider10, Provider<ChatAnalytics> provider11, Provider<SafetyToolkitAnalytics> provider12, Provider<InternetDataDelegate> provider13, Provider<NavigationAppTypeFactory> provider14, Provider<PushDataService> provider15, Provider<DriverProvider> provider16, Provider<DriverSettings> provider17, Provider<PaidStopsStateInteractor> provider18, Provider<ActiveRideDeeplinkInteractor> provider19, Provider<AutoAcceptedOrderInteractor> provider20, Provider<NoAnswerIncomingCallInteractor> provider21, Provider<AuthorizedWarningInteractor> provider22, Provider<OrderTracker> provider23, Provider<RateMePrefsManager> provider24, Provider<AppThemeManager> provider25, Provider<RouteSharingInteractor> provider26, Provider<DidYouGetHelpInteractor> provider27, Provider<EmergencyAssistInteractor> provider28, Provider<GeoLocationManager> provider29, Provider<HtmlEngine> provider30, Provider<ChatManager> provider31, Provider<ChatActiveOrderSource> provider32, Provider<OrderTryAgainManager> provider33, Provider<OrderManager> provider34, Provider<DeviceInfoSender> provider35, Provider<AudioRecordingManager> provider36) {
        return new OrderViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34, provider35, provider36);
    }

    public static OrderViewModel c(OrderDistanceInteractor orderDistanceInteractor, AutoReminder autoReminder, BottomSheetStateInteractor bottomSheetStateInteractor, MapDataInteractor mapDataInteractor, DriverInteractor driverInteractor, OrderStateDataInteractor orderStateDataInteractor, NavigationManager navigationManager, OrderStateManager orderStateManager, B2bManager b2bManager, PriceInteractor priceInteractor, ChatAnalytics chatAnalytics, SafetyToolkitAnalytics safetyToolkitAnalytics, InternetDataDelegate internetDataDelegate, NavigationAppTypeFactory navigationAppTypeFactory, PushDataService pushDataService, DriverProvider driverProvider, DriverSettings driverSettings, PaidStopsStateInteractor paidStopsStateInteractor, ActiveRideDeeplinkInteractor activeRideDeeplinkInteractor, AutoAcceptedOrderInteractor autoAcceptedOrderInteractor, NoAnswerIncomingCallInteractor noAnswerIncomingCallInteractor, AuthorizedWarningInteractor authorizedWarningInteractor, OrderTracker orderTracker, RateMePrefsManager rateMePrefsManager, AppThemeManager appThemeManager, RouteSharingInteractor routeSharingInteractor, DidYouGetHelpInteractor didYouGetHelpInteractor, EmergencyAssistInteractor emergencyAssistInteractor, GeoLocationManager geoLocationManager, HtmlEngine htmlEngine, ChatManager chatManager, ChatActiveOrderSource chatActiveOrderSource, OrderTryAgainManager orderTryAgainManager, OrderManager orderManager, DeviceInfoSender deviceInfoSender, AudioRecordingManager audioRecordingManager) {
        return new OrderViewModel(orderDistanceInteractor, autoReminder, bottomSheetStateInteractor, mapDataInteractor, driverInteractor, orderStateDataInteractor, navigationManager, orderStateManager, b2bManager, priceInteractor, chatAnalytics, safetyToolkitAnalytics, internetDataDelegate, navigationAppTypeFactory, pushDataService, driverProvider, driverSettings, paidStopsStateInteractor, activeRideDeeplinkInteractor, autoAcceptedOrderInteractor, noAnswerIncomingCallInteractor, authorizedWarningInteractor, orderTracker, rateMePrefsManager, appThemeManager, routeSharingInteractor, didYouGetHelpInteractor, emergencyAssistInteractor, geoLocationManager, htmlEngine, chatManager, chatActiveOrderSource, orderTryAgainManager, orderManager, deviceInfoSender, audioRecordingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderViewModel get() {
        return c(this.f32031a.get(), this.f32032b.get(), this.f32033c.get(), this.f32034d.get(), this.f32035e.get(), this.f32036f.get(), this.f32037g.get(), this.f32038h.get(), this.f32039i.get(), this.f32040j.get(), this.f32041k.get(), this.f32042l.get(), this.f32043m.get(), this.f32044n.get(), this.f32045o.get(), this.f32046p.get(), this.f32047q.get(), this.f32048r.get(), this.f32049s.get(), this.f32050t.get(), this.f32051u.get(), this.f32052v.get(), this.f32053w.get(), this.f32054x.get(), this.f32055y.get(), this.f32056z.get(), this.A.get(), this.B.get(), this.C.get(), this.D.get(), this.E.get(), this.F.get(), this.G.get(), this.H.get(), this.I.get(), this.J.get());
    }
}
