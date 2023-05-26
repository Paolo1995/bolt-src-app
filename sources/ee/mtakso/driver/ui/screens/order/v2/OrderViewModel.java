package ee.mtakso.driver.ui.screens.order.v2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import ee.mtakso.driver.R;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.navigation.NavigationManager;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.device.DriverAppDisabledReason;
import ee.mtakso.driver.network.client.order.ChangeRouteRequest;
import ee.mtakso.driver.network.client.order.Price;
import ee.mtakso.driver.network.client.order.RejectOrderResponse;
import ee.mtakso.driver.network.client.order.RejectReason;
import ee.mtakso.driver.network.client.order.RejectResponseType;
import ee.mtakso.driver.network.client.order.UpcomingStop;
import ee.mtakso.driver.network.client.route_sharing.RouteSharing;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.b2b.B2bManager;
import ee.mtakso.driver.service.chat.ChatActiveOrderSource;
import ee.mtakso.driver.service.connectivity.NetworkConnectionStatus;
import ee.mtakso.driver.service.deviceinfo.DeviceInfoSender;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoLocationManagerState;
import ee.mtakso.driver.service.modules.order.v2.OrderStateChange;
import ee.mtakso.driver.service.modules.order.v2.OrderStateChangeError;
import ee.mtakso.driver.service.modules.order.v2.OrderStateChangeProgress;
import ee.mtakso.driver.service.modules.order.v2.OrderStateChangeSuccess;
import ee.mtakso.driver.service.modules.order.v2.OrderStateChangeSuccessWithData;
import ee.mtakso.driver.service.modules.order.v2.OrderStateChangeType;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.service.modules.reminder.AutoReminder;
import ee.mtakso.driver.service.order.details.OrderManager;
import ee.mtakso.driver.service.order.details.OrderTryAgainManager;
import ee.mtakso.driver.service.push.PushMessage;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerIncomingCall;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.common.internet.InternetDataDelegate;
import ee.mtakso.driver.ui.common.push.PushDataService;
import ee.mtakso.driver.ui.interactor.call.NoAnswerIncomingCallInteractor;
import ee.mtakso.driver.ui.interactor.order.active.map.MapData;
import ee.mtakso.driver.ui.interactor.order.active.map.MapDataInteractor;
import ee.mtakso.driver.ui.interactor.warnings.AuthorizedWarningInteractor;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.screens.contact_methods.chat.ChatFragment$ChatParams;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import ee.mtakso.driver.ui.screens.order.add_stop.AddressChangeType;
import ee.mtakso.driver.ui.screens.order.v2.CancelWarningType;
import ee.mtakso.driver.ui.screens.order.v2.driver.DriverData;
import ee.mtakso.driver.ui.screens.order.v2.driver.DriverInteractor;
import ee.mtakso.driver.ui.screens.order.v2.map.MapState;
import ee.mtakso.driver.ui.screens.order.v2.map.NavigationMode;
import ee.mtakso.driver.ui.screens.order.v2.order.AutoAcceptedOrderInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.BottomBarState;
import ee.mtakso.driver.ui.screens.order.v2.order.BottomSheetStateInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.BottomWidgetStates;
import ee.mtakso.driver.ui.screens.order.v2.order.ChatButtonInfo;
import ee.mtakso.driver.ui.screens.order.v2.order.ExtraInfo;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderCommonData;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderData;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderDistanceInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderMenuData;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderStateDataInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.PaidStopsStateInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.PriceInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.RideStep;
import ee.mtakso.driver.ui.screens.order.v2.order.RouteSharingInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.ScreenState;
import ee.mtakso.driver.ui.screens.order.v2.order.SwipeButtonOverrideState;
import ee.mtakso.driver.ui.screens.order.v2.order.SwipeButtonState;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpType;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyFABButtonType;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyUIUtils;
import ee.mtakso.driver.ui.theme.AppThemeUtils;
import ee.mtakso.driver.ui.utils.AnimationTimer;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.CompletableExtKt;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.android.audio_recording_engine.engine.RecorderState;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.GeoUtils;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import eu.bolt.driver.chat.service.ChatManager;
import eu.bolt.driver.chat.service.ConversationPreviewData;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.util.AssertUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: OrderViewModel.kt */
/* loaded from: classes3.dex */
public final class OrderViewModel extends BaseViewModel {
    private final AuthorizedWarningInteractor A;
    private Disposable A0;
    private final OrderTracker B;
    private final MutableLiveData<Boolean> B0;
    private final RateMePrefsManager C;
    private Disposable C0;
    private final AppThemeManager D;
    private NoAnswerIncomingCall D0;
    private final RouteSharingInteractor E;
    private final MutableLiveData<Optional<NoAnswerIncomingCall>> E0;
    private final DidYouGetHelpInteractor F;
    private Disposable F0;
    private final EmergencyAssistInteractor G;
    private final ObservableLiveData<WarningMessage> G0;
    private final GeoLocationManager H;
    private final HtmlEngine I;
    private final ChatManager J;
    private final ChatActiveOrderSource K;
    private final OrderTryAgainManager L;
    private final OrderManager M;
    private final DeviceInfoSender N;
    private final AudioRecordingManager O;
    private final LiveEvent<ConfirmationSignal> P;
    private final LiveEvent<Unit> Q;
    private final LiveEvent<List<RejectReason>> R;
    private final LiveEvent<CancelWarningType> S;
    private final LiveEvent<Unit> T;
    private final LiveEvent<Unit> U;
    private final LiveEvent<Text> V;
    private final MutableLiveData<DidYouGetHelpType> W;
    private final MutableLiveData<SafetyFABButtonType> X;
    private final LiveEvent<Boolean> Y;
    private final LiveEvent<DriverAppDisabledReason> Z;

    /* renamed from: a0  reason: collision with root package name */
    private Disposable f31934a0;

    /* renamed from: b0  reason: collision with root package name */
    private Disposable f31935b0;

    /* renamed from: c0  reason: collision with root package name */
    private final AnimationTimer f31936c0;

    /* renamed from: d0  reason: collision with root package name */
    private Disposable f31937d0;

    /* renamed from: e0  reason: collision with root package name */
    private final MutableLiveData<Boolean> f31938e0;

    /* renamed from: f  reason: collision with root package name */
    private final OrderDistanceInteractor f31939f;

    /* renamed from: f0  reason: collision with root package name */
    private Disposable f31940f0;

    /* renamed from: g  reason: collision with root package name */
    private final AutoReminder f31941g;

    /* renamed from: g0  reason: collision with root package name */
    private MutableLiveData<ScreenState> f31942g0;

    /* renamed from: h  reason: collision with root package name */
    private final BottomSheetStateInteractor f31943h;

    /* renamed from: h0  reason: collision with root package name */
    private final LiveData<Boolean> f31944h0;

    /* renamed from: i  reason: collision with root package name */
    private final MapDataInteractor f31945i;

    /* renamed from: i0  reason: collision with root package name */
    private final MutableLiveData<MapData> f31946i0;

    /* renamed from: j  reason: collision with root package name */
    private final DriverInteractor f31947j;

    /* renamed from: j0  reason: collision with root package name */
    private Disposable f31948j0;

    /* renamed from: k  reason: collision with root package name */
    private final OrderStateDataInteractor f31949k;

    /* renamed from: k0  reason: collision with root package name */
    private MediatorLiveData<MapState> f31950k0;

    /* renamed from: l  reason: collision with root package name */
    private final NavigationManager f31951l;

    /* renamed from: l0  reason: collision with root package name */
    private final MutableLiveData<OrderData> f31952l0;

    /* renamed from: m  reason: collision with root package name */
    private final OrderStateManager f31953m;

    /* renamed from: m0  reason: collision with root package name */
    private final MutableLiveData<Double> f31954m0;

    /* renamed from: n  reason: collision with root package name */
    private final B2bManager f31955n;

    /* renamed from: n0  reason: collision with root package name */
    private final MutableLiveData<StartPaidWaitingData> f31956n0;

    /* renamed from: o  reason: collision with root package name */
    private final PriceInteractor f31957o;

    /* renamed from: o0  reason: collision with root package name */
    private Disposable f31958o0;

    /* renamed from: p  reason: collision with root package name */
    private final ChatAnalytics f31959p;

    /* renamed from: p0  reason: collision with root package name */
    private Disposable f31960p0;

    /* renamed from: q  reason: collision with root package name */
    private final SafetyToolkitAnalytics f31961q;

    /* renamed from: q0  reason: collision with root package name */
    private Disposable f31962q0;

    /* renamed from: r  reason: collision with root package name */
    private final InternetDataDelegate f31963r;

    /* renamed from: r0  reason: collision with root package name */
    private Disposable f31964r0;

    /* renamed from: s  reason: collision with root package name */
    private final NavigationAppTypeFactory f31965s;

    /* renamed from: s0  reason: collision with root package name */
    private Disposable f31966s0;

    /* renamed from: t  reason: collision with root package name */
    private final PushDataService f31967t;

    /* renamed from: t0  reason: collision with root package name */
    private Disposable f31968t0;

    /* renamed from: u  reason: collision with root package name */
    private final DriverProvider f31969u;

    /* renamed from: u0  reason: collision with root package name */
    private final LiveEvent<ChatFragment$ChatParams> f31970u0;

    /* renamed from: v  reason: collision with root package name */
    private final DriverSettings f31971v;

    /* renamed from: v0  reason: collision with root package name */
    private Disposable f31972v0;

    /* renamed from: w  reason: collision with root package name */
    private final PaidStopsStateInteractor f31973w;

    /* renamed from: w0  reason: collision with root package name */
    private Disposable f31974w0;

    /* renamed from: x  reason: collision with root package name */
    private final ActiveRideDeeplinkInteractor f31975x;

    /* renamed from: x0  reason: collision with root package name */
    private Disposable f31976x0;

    /* renamed from: y  reason: collision with root package name */
    private final AutoAcceptedOrderInteractor f31977y;

    /* renamed from: y0  reason: collision with root package name */
    private final LiveEvent<Price> f31978y0;

    /* renamed from: z  reason: collision with root package name */
    private final NoAnswerIncomingCallInteractor f31979z;

    /* renamed from: z0  reason: collision with root package name */
    private final MutableLiveData<BottomWidgetStates> f31980z0;

    /* compiled from: OrderViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31981a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f31982b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f31983c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f31984d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ int[] f31985e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ int[] f31986f;

        static {
            int[] iArr = new int[RejectResponseType.values().length];
            try {
                iArr[RejectResponseType.REASONS_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RejectResponseType.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f31981a = iArr;
            int[] iArr2 = new int[OrderStateChangeType.values().length];
            try {
                iArr2[OrderStateChangeType.CANCEL_CURRENT_ORDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            f31982b = iArr2;
            int[] iArr3 = new int[AddressChangeType.values().length];
            try {
                iArr3[AddressChangeType.ADD_ADDRESS_AT_CURRENT_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            f31983c = iArr3;
            int[] iArr4 = new int[RideStep.values().length];
            try {
                iArr4[RideStep.GOING_TO_INTERMEDIATE_STOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr4[RideStep.GOING_TO_FINAL_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            f31984d = iArr4;
            int[] iArr5 = new int[OrderState.values().length];
            try {
                iArr5[OrderState.ORDER_STATE_DRIVER_ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr5[OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr5[OrderState.ORDER_STATE_DRIVING_WITH_CLIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            f31985e = iArr5;
            int[] iArr6 = new int[SwipeButtonState.values().length];
            try {
                iArr6[SwipeButtonState.DRIVING_TO_WAITING_POINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            f31986f = iArr6;
        }
    }

    @Inject
    public OrderViewModel(OrderDistanceInteractor distanceInteractor, AutoReminder autoReminder, BottomSheetStateInteractor bottomSheetStateInteractor, MapDataInteractor mapInteractor, DriverInteractor driverInteractor, OrderStateDataInteractor orderStateDataInteractor, NavigationManager navigationManager, OrderStateManager orderStateManager, B2bManager b2bManager, PriceInteractor priceInteractor, ChatAnalytics chatAnalytics, SafetyToolkitAnalytics safetyToolkitAnalytics, InternetDataDelegate internetDelegate, NavigationAppTypeFactory navigationAppTypeFactory, PushDataService pushDataService, DriverProvider driverProvider, DriverSettings driverSettings, PaidStopsStateInteractor paidStopsStateInteractor, ActiveRideDeeplinkInteractor activeRideDeeplinkInteractor, AutoAcceptedOrderInteractor autoAcceptedOrderInteractor, NoAnswerIncomingCallInteractor noAnswerIncomingCallInteractor, AuthorizedWarningInteractor warningInteractor, OrderTracker orderTracker, RateMePrefsManager rateMePrefsManager, AppThemeManager appThemeManager, RouteSharingInteractor routeSharingInteractor, DidYouGetHelpInteractor didYouGetHelpInteractor, EmergencyAssistInteractor emergencyAssistInteractor, GeoLocationManager locationManager, HtmlEngine htmlEngine, ChatManager chatManager, ChatActiveOrderSource chatActiveOrderSource, OrderTryAgainManager orderTryAgainManager, OrderManager orderManager, DeviceInfoSender deviceInfoSender, AudioRecordingManager audioRecordingManager) {
        List k8;
        Intrinsics.f(distanceInteractor, "distanceInteractor");
        Intrinsics.f(autoReminder, "autoReminder");
        Intrinsics.f(bottomSheetStateInteractor, "bottomSheetStateInteractor");
        Intrinsics.f(mapInteractor, "mapInteractor");
        Intrinsics.f(driverInteractor, "driverInteractor");
        Intrinsics.f(orderStateDataInteractor, "orderStateDataInteractor");
        Intrinsics.f(navigationManager, "navigationManager");
        Intrinsics.f(orderStateManager, "orderStateManager");
        Intrinsics.f(b2bManager, "b2bManager");
        Intrinsics.f(priceInteractor, "priceInteractor");
        Intrinsics.f(chatAnalytics, "chatAnalytics");
        Intrinsics.f(safetyToolkitAnalytics, "safetyToolkitAnalytics");
        Intrinsics.f(internetDelegate, "internetDelegate");
        Intrinsics.f(navigationAppTypeFactory, "navigationAppTypeFactory");
        Intrinsics.f(pushDataService, "pushDataService");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(driverSettings, "driverSettings");
        Intrinsics.f(paidStopsStateInteractor, "paidStopsStateInteractor");
        Intrinsics.f(activeRideDeeplinkInteractor, "activeRideDeeplinkInteractor");
        Intrinsics.f(autoAcceptedOrderInteractor, "autoAcceptedOrderInteractor");
        Intrinsics.f(noAnswerIncomingCallInteractor, "noAnswerIncomingCallInteractor");
        Intrinsics.f(warningInteractor, "warningInteractor");
        Intrinsics.f(orderTracker, "orderTracker");
        Intrinsics.f(rateMePrefsManager, "rateMePrefsManager");
        Intrinsics.f(appThemeManager, "appThemeManager");
        Intrinsics.f(routeSharingInteractor, "routeSharingInteractor");
        Intrinsics.f(didYouGetHelpInteractor, "didYouGetHelpInteractor");
        Intrinsics.f(emergencyAssistInteractor, "emergencyAssistInteractor");
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(chatManager, "chatManager");
        Intrinsics.f(chatActiveOrderSource, "chatActiveOrderSource");
        Intrinsics.f(orderTryAgainManager, "orderTryAgainManager");
        Intrinsics.f(orderManager, "orderManager");
        Intrinsics.f(deviceInfoSender, "deviceInfoSender");
        Intrinsics.f(audioRecordingManager, "audioRecordingManager");
        this.f31939f = distanceInteractor;
        this.f31941g = autoReminder;
        this.f31943h = bottomSheetStateInteractor;
        this.f31945i = mapInteractor;
        this.f31947j = driverInteractor;
        this.f31949k = orderStateDataInteractor;
        this.f31951l = navigationManager;
        this.f31953m = orderStateManager;
        this.f31955n = b2bManager;
        this.f31957o = priceInteractor;
        this.f31959p = chatAnalytics;
        this.f31961q = safetyToolkitAnalytics;
        this.f31963r = internetDelegate;
        this.f31965s = navigationAppTypeFactory;
        this.f31967t = pushDataService;
        this.f31969u = driverProvider;
        this.f31971v = driverSettings;
        this.f31973w = paidStopsStateInteractor;
        this.f31975x = activeRideDeeplinkInteractor;
        this.f31977y = autoAcceptedOrderInteractor;
        this.f31979z = noAnswerIncomingCallInteractor;
        this.A = warningInteractor;
        this.B = orderTracker;
        this.C = rateMePrefsManager;
        this.D = appThemeManager;
        this.E = routeSharingInteractor;
        this.F = didYouGetHelpInteractor;
        this.G = emergencyAssistInteractor;
        this.H = locationManager;
        this.I = htmlEngine;
        this.J = chatManager;
        this.K = chatActiveOrderSource;
        this.L = orderTryAgainManager;
        this.M = orderManager;
        this.N = deviceInfoSender;
        this.O = audioRecordingManager;
        this.P = new LiveEvent<>();
        this.Q = new LiveEvent<>();
        this.R = new LiveEvent<>();
        this.S = new LiveEvent<>();
        this.T = new LiveEvent<>();
        this.U = new LiveEvent<>();
        this.V = new LiveEvent<>();
        this.W = new MutableLiveData<>();
        this.X = new MutableLiveData<>();
        this.Y = new LiveEvent<>();
        this.Z = new LiveEvent<>();
        this.f31936c0 = new AnimationTimer();
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.f31938e0 = mutableLiveData;
        NavigationMode navigationMode = NavigationMode.OVERALL;
        Navigator c8 = navigationAppTypeFactory.c(Navigator.Type.NO_NAVIGATION_SELECTED);
        k8 = CollectionsKt__CollectionsKt.k();
        this.f31942g0 = new MutableLiveData<>(new ScreenState(navigationMode, c8, null, false, null, k8, false));
        this.f31944h0 = mutableLiveData;
        this.f31946i0 = new MutableLiveData<>();
        this.f31950k0 = new MediatorLiveData<>();
        this.f31952l0 = new MutableLiveData<>();
        this.f31954m0 = new MutableLiveData<>(Double.valueOf(Double.MAX_VALUE));
        this.f31956n0 = new MutableLiveData<>(new StartPaidWaitingData(false, false));
        this.f31970u0 = new LiveEvent<>();
        this.f31978y0 = new LiveEvent<>();
        this.f31980z0 = new MutableLiveData<>(new BottomWidgetStates(false, BottomBarState.COLLAPSED, SwipeButtonState.DRIVING_TO_PICKUP, SwipeButtonOverrideState.CHANGING, null, -1L));
        this.B0 = new MutableLiveData<>(Boolean.FALSE);
        this.E0 = new MutableLiveData<>();
        this.G0 = new ObservableLiveData<>();
    }

    private final void A3(OrderData orderData, OrderData orderData2) {
        int v7;
        int v8;
        if ((orderData instanceof OrderData.DrivingWithClientData) || (orderData2 instanceof OrderData.DrivingWithClientData) || (orderData2 instanceof OrderData.WaitingOnStopData)) {
            List<UpcomingStop> n8 = orderData.b().n();
            v7 = CollectionsKt__IterablesKt.v(n8, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (UpcomingStop upcomingStop : n8) {
                arrayList.add(upcomingStop.a());
            }
            List<UpcomingStop> n9 = orderData2.b().n();
            v8 = CollectionsKt__IterablesKt.v(n9, 10);
            ArrayList arrayList2 = new ArrayList(v8);
            for (UpcomingStop upcomingStop2 : n9) {
                arrayList2.add(upcomingStop2.a());
            }
            Text n32 = n3(arrayList, arrayList2);
            if (n32 != null) {
                this.V.o(n32);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void B1(java.lang.String r4, java.util.List<ee.mtakso.driver.network.client.order.RejectReason> r5) {
        /*
            r3 = this;
            ee.mtakso.driver.param.DriverProvider r0 = r3.f31969u
            ee.mtakso.driver.param.DriverFeatures r0 = r0.q()
            boolean r0 = r0.n()
            ee.mtakso.driver.param.DriverProvider r1 = r3.f31969u
            ee.mtakso.driver.param.DriverFeatures r1 = r1.q()
            boolean r1 = r1.o()
            if (r4 == 0) goto L1f
            boolean r2 = kotlin.text.StringsKt.y(r4)
            if (r2 == 0) goto L1d
            goto L1f
        L1d:
            r2 = 0
            goto L20
        L1f:
            r2 = 1
        L20:
            if (r2 != 0) goto L2e
            ee.mtakso.driver.ui.screens.order.v2.CancelWarningType$Confirmation r0 = new ee.mtakso.driver.ui.screens.order.v2.CancelWarningType$Confirmation
            eu.bolt.android.engine.html.HtmlEngine r1 = r3.I
            java.lang.CharSequence r4 = r1.a(r4)
            r0.<init>(r4, r5)
            goto L4c
        L2e:
            if (r0 == 0) goto L38
            if (r1 == 0) goto L38
            ee.mtakso.driver.ui.screens.order.v2.CancelWarningType$DriverScoreAndCampaignWarning r0 = new ee.mtakso.driver.ui.screens.order.v2.CancelWarningType$DriverScoreAndCampaignWarning
            r0.<init>(r5)
            goto L4c
        L38:
            if (r0 == 0) goto L40
            ee.mtakso.driver.ui.screens.order.v2.CancelWarningType$CampaignWarning r0 = new ee.mtakso.driver.ui.screens.order.v2.CancelWarningType$CampaignWarning
            r0.<init>(r5)
            goto L4c
        L40:
            if (r1 == 0) goto L48
            ee.mtakso.driver.ui.screens.order.v2.CancelWarningType$DriverScoreWarning r0 = new ee.mtakso.driver.ui.screens.order.v2.CancelWarningType$DriverScoreWarning
            r0.<init>(r5)
            goto L4c
        L48:
            r3.z3(r5)
            r0 = 0
        L4c:
            ee.mtakso.driver.ui.base.mvvm.LiveEvent<ee.mtakso.driver.ui.screens.order.v2.CancelWarningType> r4 = r3.S
            r4.m(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel.B1(java.lang.String, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1(OrderStateChangeSuccessWithData orderStateChangeSuccessWithData) {
        RejectOrderResponse rejectOrderResponse;
        if (WhenMappings.f31982b[orderStateChangeSuccessWithData.a().ordinal()] == 1) {
            Object b8 = orderStateChangeSuccessWithData.b();
            if (b8 instanceof RejectOrderResponse) {
                rejectOrderResponse = (RejectOrderResponse) b8;
            } else {
                rejectOrderResponse = null;
            }
            if (rejectOrderResponse == null) {
                return;
            }
            int i8 = WhenMappings.f31981a[rejectOrderResponse.c().ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    this.Q.m(Unit.f50853a);
                    return;
                }
                return;
            }
            String a8 = rejectOrderResponse.a();
            List<RejectReason> b9 = rejectOrderResponse.b();
            if (b9 != null) {
                B1(a8, b9);
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    private final void D1() {
        Disposable disposable = this.C0;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<List<Long>> distinctUntilChanged = this.f31977y.d().observeOn(AndroidSchedulers.a()).distinctUntilChanged();
        final OrderViewModel$initAutoAcceptanceFlow$1 orderViewModel$initAutoAcceptanceFlow$1 = new Function1<List<? extends Long>, Boolean>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initAutoAcceptanceFlow$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(List<Long> it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(!it.isEmpty());
            }
        };
        Observable<R> map = distinctUntilChanged.map(new Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.w1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean E1;
                E1 = OrderViewModel.E1(Function1.this, obj);
                return E1;
            }
        });
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initAutoAcceptanceFlow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean bool) {
                MutableLiveData mutableLiveData;
                mutableLiveData = OrderViewModel.this.B0;
                mutableLiveData.o(bool);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.e0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.F1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initAutoAcceptanceFlow$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                OrderViewModel orderViewModel = OrderViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderViewModel, it, null, 2, null);
            }
        };
        this.C0 = map.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.f0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.G1(Function1.this, obj);
            }
        });
    }

    public static /* synthetic */ void D3(OrderViewModel orderViewModel, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        orderViewModel.C3(z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean E1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean G2(StartPaidWaitingData it) {
        Intrinsics.e(it, "it");
        return Boolean.valueOf(OrderViewModelKt.a(it));
    }

    private final void H1() {
        Observable<BottomWidgetStates> observeOn = this.f31943h.i().observeOn(AndroidSchedulers.a());
        final Function1<BottomWidgetStates, Unit> function1 = new Function1<BottomWidgetStates, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initBottomSheetFlow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(BottomWidgetStates it) {
                OrderViewModel orderViewModel = OrderViewModel.this;
                Intrinsics.e(it, "it");
                orderViewModel.J3(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BottomWidgetStates bottomWidgetStates) {
                b(bottomWidgetStates);
                return Unit.f50853a;
            }
        };
        Observable<BottomWidgetStates> doOnNext = observeOn.doOnNext(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.g1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.I1(Function1.this, obj);
            }
        });
        final Function1<BottomWidgetStates, Unit> function12 = new Function1<BottomWidgetStates, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initBottomSheetFlow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(BottomWidgetStates bottomWidgetStates) {
                MutableLiveData mutableLiveData;
                mutableLiveData = OrderViewModel.this.f31980z0;
                mutableLiveData.o(bottomWidgetStates);
                OrderViewModel.this.R3();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BottomWidgetStates bottomWidgetStates) {
                b(bottomWidgetStates);
                return Unit.f50853a;
            }
        };
        Consumer<? super BottomWidgetStates> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.h1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.J1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initBottomSheetFlow$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                OrderViewModel orderViewModel = OrderViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderViewModel, it, null, 2, null);
            }
        };
        this.A0 = doOnNext.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.i1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.K1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J3(BottomWidgetStates bottomWidgetStates) {
        SwipeButtonState swipeButtonState;
        BottomWidgetStates f8 = this.f31980z0.f();
        if (f8 != null) {
            swipeButtonState = f8.g();
        } else {
            swipeButtonState = null;
        }
        if (swipeButtonState == bottomWidgetStates.g()) {
            return;
        }
        if (WhenMappings.f31986f[bottomWidgetStates.g().ordinal()] == 1) {
            this.B.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void K3(OrderData orderData, OrderData orderData2) {
        OrderState orderState;
        OrderCommonData a8;
        if (orderData != null && (a8 = orderData.a()) != null) {
            orderState = a8.f();
        } else {
            orderState = null;
        }
        if (orderState == orderData2.a().f()) {
            return;
        }
        int i8 = WhenMappings.f31985e[orderData2.a().f().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    this.B.t();
                    return;
                }
                return;
            }
            this.B.g0();
            return;
        }
        this.B.c();
    }

    private final void L1() {
        Observable<List<ConversationPreviewData>> observeOn = this.J.j(this.K).observeOn(AndroidSchedulers.a());
        final Function1<List<? extends ConversationPreviewData>, Unit> function1 = new Function1<List<? extends ConversationPreviewData>, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initChatFlow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<ConversationPreviewData> conversations) {
                MutableLiveData mutableLiveData;
                int v7;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                AssertUtils.f41299a.c("Chat should be updated on main thread");
                mutableLiveData = OrderViewModel.this.f31942g0;
                boolean isEmpty = ((ScreenState) LiveDataExtKt.b(mutableLiveData)).c().isEmpty();
                Intrinsics.e(conversations, "conversations");
                if ((!conversations.isEmpty()) && isEmpty) {
                    OrderViewModel.this.Q3();
                }
                v7 = CollectionsKt__IterablesKt.v(conversations, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (ConversationPreviewData conversationPreviewData : conversations) {
                    arrayList.add(new ChatButtonInfo(conversationPreviewData.f(), conversationPreviewData.d(), conversationPreviewData.c(), conversationPreviewData.e(), conversationPreviewData.b()));
                }
                mutableLiveData2 = OrderViewModel.this.f31942g0;
                mutableLiveData3 = OrderViewModel.this.f31942g0;
                Object b8 = LiveDataExtKt.b(mutableLiveData3);
                Intrinsics.e(b8, "screenState.requireValue()");
                mutableLiveData2.o(ScreenState.b((ScreenState) b8, null, null, null, false, null, arrayList, false, 95, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ConversationPreviewData> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Consumer<? super List<ConversationPreviewData>> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.u1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.M1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initChatFlow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                OrderViewModel orderViewModel = OrderViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.v1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.N1(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun initChatFlow…     .autoDispose()\n    }");
        v(subscribe);
    }

    private final void L2() {
        BehaviorSubject<Boolean> a8 = this.G.a();
        Observable<RecorderState> f8 = this.O.f();
        final OrderViewModel$observeSafetyFABState$1 orderViewModel$observeSafetyFABState$1 = new Function2<Boolean, RecorderState, SafetyFABButtonType>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$observeSafetyFABState$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final SafetyFABButtonType s(Boolean hasActiveIncident, RecorderState recorderState) {
                Intrinsics.f(hasActiveIncident, "hasActiveIncident");
                Intrinsics.f(recorderState, "recorderState");
                return SafetyUIUtils.f32878a.a(hasActiveIncident.booleanValue(), recorderState);
            }
        };
        Observable combineLatest = Observable.combineLatest(a8, f8, new BiFunction() { // from class: ee.mtakso.driver.ui.screens.order.v2.l1
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                SafetyFABButtonType M2;
                M2 = OrderViewModel.M2(Function2.this, obj, obj2);
                return M2;
            }
        });
        Intrinsics.e(combineLatest, "combineLatest(\n         … recorderState)\n        }");
        Observable g8 = ObservableExtKt.g(combineLatest);
        final Function1<SafetyFABButtonType, Unit> function1 = new Function1<SafetyFABButtonType, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$observeSafetyFABState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(SafetyFABButtonType safetyFABButtonType) {
                MutableLiveData mutableLiveData;
                mutableLiveData = OrderViewModel.this.X;
                mutableLiveData.o(safetyFABButtonType);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SafetyFABButtonType safetyFABButtonType) {
                b(safetyFABButtonType);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = g8.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.m1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.N2(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeSafet…    }.autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SafetyFABButtonType M2(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SafetyFABButtonType) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void O1() {
        Observable<DriverData> d8 = this.f31947j.d();
        final Function1<DriverData, Unit> function1 = new Function1<DriverData, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initDriverFlow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverData driverData) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                mutableLiveData = OrderViewModel.this.f31942g0;
                mutableLiveData2 = OrderViewModel.this.f31942g0;
                ScreenState screenState = (ScreenState) LiveDataExtKt.b(mutableLiveData2);
                Navigator b8 = driverData.b();
                boolean d9 = driverData.d();
                boolean c8 = driverData.c();
                NavigationOption a8 = driverData.a();
                Intrinsics.e(screenState, "requireValue()");
                mutableLiveData.o(ScreenState.b(screenState, null, b8, a8, d9, null, null, c8, 49, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverData driverData) {
                b(driverData);
                return Unit.f50853a;
            }
        };
        Consumer<? super DriverData> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.p1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.P1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initDriverFlow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                OrderViewModel orderViewModel = OrderViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderViewModel, it, null, 2, null);
            }
        };
        this.f31972v0 = d8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.q1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.Q1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void R1() {
        if (this.f31969u.q().b()) {
            Observable<GeoLocationManagerState> observeOn = this.H.v().observeOn(AndroidSchedulers.a());
            final Function1<GeoLocationManagerState, Unit> function1 = new Function1<GeoLocationManagerState, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initFakeGpsCheck$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(GeoLocationManagerState geoLocationManagerState) {
                    LiveEvent liveEvent;
                    if (geoLocationManagerState == GeoLocationManagerState.MOCKED_LOCATION_FOUND) {
                        liveEvent = OrderViewModel.this.Z;
                        DriverAppDisabledReason driverAppDisabledReason = DriverAppDisabledReason.MOCK_LOCATION;
                        liveEvent.o(driverAppDisabledReason);
                        OrderViewModel.this.q3(driverAppDisabledReason);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GeoLocationManagerState geoLocationManagerState) {
                    b(geoLocationManagerState);
                    return Unit.f50853a;
                }
            };
            this.f31934a0 = observeOn.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.c1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    OrderViewModel.S1(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R3() {
        boolean z7;
        MutableLiveData<StartPaidWaitingData> mutableLiveData = this.f31956n0;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "startPaidWaitingData.requireValue()");
        StartPaidWaitingData startPaidWaitingData = (StartPaidWaitingData) b8;
        if (((BottomWidgetStates) LiveDataExtKt.b(this.f31980z0)).f() == SwipeButtonOverrideState.CHANGED) {
            z7 = true;
        } else {
            z7 = false;
        }
        mutableLiveData.o(StartPaidWaitingData.b(startPaidWaitingData, false, z7, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void T1() {
        Observable<Unit> b8 = this.f31936c0.b();
        final Function1<Unit, Unit> function1 = new Function1<Unit, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initMapDataFlow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Unit unit) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                ScreenState screenState;
                mutableLiveData = OrderViewModel.this.f31942g0;
                mutableLiveData2 = OrderViewModel.this.f31942g0;
                ScreenState screenState2 = (ScreenState) mutableLiveData2.f();
                if (screenState2 != null) {
                    screenState = ScreenState.b(screenState2, NavigationMode.SEGMENT, null, null, false, null, null, false, 126, null);
                } else {
                    screenState = null;
                }
                mutableLiveData.o(screenState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                b(unit);
                return Unit.f50853a;
            }
        };
        Consumer<? super Unit> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.v0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.U1(Function1.this, obj);
            }
        };
        final OrderViewModel$initMapDataFlow$2 orderViewModel$initMapDataFlow$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initMapDataFlow$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to animate map");
            }
        };
        this.f31937d0 = b8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.w0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.V1(Function1.this, obj);
            }
        });
        Observable f8 = ObservableExtKt.f(this.f31945i.i());
        final Function1<MapData, Unit> function12 = new Function1<MapData, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initMapDataFlow$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MapData mapData) {
                MutableLiveData mutableLiveData;
                mutableLiveData = OrderViewModel.this.f31946i0;
                mutableLiveData.o(mapData);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapData mapData) {
                b(mapData);
                return Unit.f50853a;
            }
        };
        Consumer consumer2 = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.x0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.W1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initMapDataFlow$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                OrderViewModel orderViewModel = OrderViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderViewModel, it, null, 2, null);
            }
        };
        this.f31948j0 = f8.subscribe(consumer2, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.y0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.X1(Function1.this, obj);
            }
        });
        MediatorLiveData<MapState> mediatorLiveData = this.f31950k0;
        MutableLiveData<MapData> mutableLiveData = this.f31946i0;
        final Function1<MapData, Unit> function14 = new Function1<MapData, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initMapDataFlow$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MapData newMapData) {
                MediatorLiveData mediatorLiveData2;
                MediatorLiveData mediatorLiveData3;
                MediatorLiveData mediatorLiveData4;
                AnimationTimer animationTimer;
                mediatorLiveData2 = OrderViewModel.this.f31950k0;
                MapState mapState = (MapState) mediatorLiveData2.f();
                if (mapState == null) {
                    mediatorLiveData4 = OrderViewModel.this.f31950k0;
                    NavigationMode navigationMode = NavigationMode.OVERALL;
                    Intrinsics.e(newMapData, "newMapData");
                    mediatorLiveData4.o(new MapState(navigationMode, newMapData));
                    animationTimer = OrderViewModel.this.f31936c0;
                    AnimationTimer.d(animationTimer, 0L, 1, null);
                } else if (!Intrinsics.a(mapState.c(), newMapData)) {
                    mediatorLiveData3 = OrderViewModel.this.f31950k0;
                    Intrinsics.e(newMapData, "newMapData");
                    mediatorLiveData3.o(MapState.b(mapState, null, newMapData, 1, null));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MapData mapData) {
                b(mapData);
                return Unit.f50853a;
            }
        };
        mediatorLiveData.p(mutableLiveData, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.a1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderViewModel.Y1(Function1.this, obj);
            }
        });
        MediatorLiveData<MapState> mediatorLiveData2 = this.f31950k0;
        MutableLiveData<ScreenState> mutableLiveData2 = this.f31942g0;
        final Function1<ScreenState, Unit> function15 = new Function1<ScreenState, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initMapDataFlow$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ScreenState screenState) {
                MediatorLiveData mediatorLiveData3;
                MediatorLiveData mediatorLiveData4;
                mediatorLiveData3 = OrderViewModel.this.f31950k0;
                MapState mapState = (MapState) mediatorLiveData3.f();
                if (mapState != null && mapState.d() != screenState.d()) {
                    mediatorLiveData4 = OrderViewModel.this.f31950k0;
                    mediatorLiveData4.o(MapState.b(mapState, screenState.d(), null, 2, null));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScreenState screenState) {
                b(screenState);
                return Unit.f50853a;
            }
        };
        mediatorLiveData2.p(mutableLiveData2, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.b1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderViewModel.Z1(Function1.this, obj);
            }
        });
    }

    private final void T3(OrderData.DrivingWithClientData drivingWithClientData, boolean z7) {
        int i8 = WhenMappings.f31984d[drivingWithClientData.g().ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                Object b8 = LiveDataExtKt.b(this.f31954m0);
                Intrinsics.e(b8, "distanceToStop.requireValue()");
                if (((Number) b8).doubleValue() >= 300.0d && !z7) {
                    this.P.o(ConfirmationSignal.ARRIVE_TO_DESTINATION_SWIPE);
                    return;
                } else {
                    t1(this, false, 1, null);
                    return;
                }
            }
            return;
        }
        this.B.F();
        this.f31953m.L0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z2(OrderData orderData) {
        ExtraInfo extraInfo;
        boolean y7;
        K3(this.f31952l0.f(), orderData);
        OrderData f8 = this.f31952l0.f();
        if (f8 != null) {
            A3(f8, orderData);
        }
        if (this.f31952l0.f() == null) {
            O1();
        }
        this.f31952l0.o(orderData);
        String b8 = orderData.a().b();
        boolean z7 = false;
        if (b8 != null) {
            y7 = StringsKt__StringsJVMKt.y(b8);
            if (!y7) {
                z7 = true;
            }
        }
        if (z7) {
            extraInfo = new ExtraInfo(b8, orderData.a().i());
        } else {
            extraInfo = null;
        }
        MutableLiveData<ScreenState> mutableLiveData = this.f31942g0;
        Object b9 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b9, "screenState.requireValue()");
        mutableLiveData.o(ScreenState.b((ScreenState) b9, null, null, null, false, extraInfo, null, false, 111, null));
    }

    private final void a2() {
        Disposable disposable = this.F0;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Observable<NoAnswerIncomingCall> observeOn = this.f31979z.c().observeOn(AndroidSchedulers.a());
        final Function1<NoAnswerIncomingCall, Unit> function1 = new Function1<NoAnswerIncomingCall, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initNoAnswerCallFlow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(NoAnswerIncomingCall noAnswerIncomingCall) {
                MutableLiveData mutableLiveData;
                OrderViewModel.this.D0 = noAnswerIncomingCall;
                mutableLiveData = OrderViewModel.this.E0;
                mutableLiveData.o(Optional.f(noAnswerIncomingCall));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NoAnswerIncomingCall noAnswerIncomingCall) {
                b(noAnswerIncomingCall);
                return Unit.f50853a;
            }
        };
        Consumer<? super NoAnswerIncomingCall> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.e1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.b2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initNoAnswerCallFlow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                OrderViewModel orderViewModel = OrderViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderViewModel, it, null, 2, null);
            }
        };
        this.F0 = observeOn.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.f1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.c2(Function1.this, obj);
            }
        });
    }

    private final void b1(boolean z7) {
        Object b8 = LiveDataExtKt.b(this.f31954m0);
        Intrinsics.e(b8, "distanceToStop.requireValue()");
        if (((Number) b8).doubleValue() >= 300.0d && !z7) {
            this.P.o(ConfirmationSignal.ARRIVE_TO_PICKUP);
            return;
        }
        this.f31953m.N();
        this.B.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void d2() {
        Observable f8 = ObservableExtKt.f(this.f31949k.s());
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initOrderDataFlow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                MutableLiveData mutableLiveData;
                MutableLiveData y7;
                mutableLiveData = OrderViewModel.this.f31952l0;
                if (mutableLiveData.f() == 0) {
                    y7 = OrderViewModel.this.y();
                    y7.m(Boolean.TRUE);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Observable doOnSubscribe = f8.doOnSubscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.g0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.e2(Function1.this, obj);
            }
        });
        final Function1<OrderData, Unit> function12 = new Function1<OrderData, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initOrderDataFlow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OrderData orderData) {
                MutableLiveData mutableLiveData;
                MutableLiveData y7;
                mutableLiveData = OrderViewModel.this.f31952l0;
                if (mutableLiveData.f() == 0) {
                    y7 = OrderViewModel.this.y();
                    y7.m(Boolean.FALSE);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OrderData orderData) {
                b(orderData);
                return Unit.f50853a;
            }
        };
        Observable doOnNext = doOnSubscribe.doOnNext(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.h0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.f2(Function1.this, obj);
            }
        });
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initOrderDataFlow$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableLiveData mutableLiveData;
                MutableLiveData y7;
                mutableLiveData = OrderViewModel.this.f31952l0;
                if (mutableLiveData.f() == 0) {
                    y7 = OrderViewModel.this.y();
                    y7.m(Boolean.FALSE);
                }
            }
        };
        Observable doOnError = doOnNext.doOnError(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.i0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.g2(Function1.this, obj);
            }
        });
        final Function1<OrderData, Unit> function14 = new Function1<OrderData, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initOrderDataFlow$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OrderData it) {
                OrderViewModel orderViewModel = OrderViewModel.this;
                Intrinsics.e(it, "it");
                orderViewModel.Z2(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OrderData orderData) {
                b(orderData);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.j0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.h2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function15 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initOrderDataFlow$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                OrderTracker orderTracker;
                orderTracker = OrderViewModel.this.B;
                Intrinsics.e(it, "it");
                orderTracker.J(it);
                BaseViewModel.A(OrderViewModel.this, it, null, 2, null);
            }
        };
        this.f31958o0 = doOnError.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.k0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.i2(Function1.this, obj);
            }
        });
        Observable<Notification<OrderStateChange>> observeOn = this.f31953m.u0().observeOn(AndroidSchedulers.a());
        final Function1<Notification<OrderStateChange>, Unit> function16 = new Function1<Notification<OrderStateChange>, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initOrderDataFlow$6

            /* compiled from: OrderViewModel.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f32018a;

                static {
                    int[] iArr = new int[OrderStateChangeType.values().length];
                    try {
                        iArr[OrderStateChangeType.SWITCH_STOP.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[OrderStateChangeType.CANCEL_NEXT_ORDER.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[OrderStateChangeType.CHANGE_DESTINATION.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[OrderStateChangeType.CANCEL_CURRENT_ORDER.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f32018a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Notification<OrderStateChange> notification) {
                MutableLiveData y7;
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                LiveEvent liveEvent;
                MutableLiveData y8;
                MutableLiveData mutableLiveData3;
                MutableLiveData mutableLiveData4;
                MutableLiveData mutableLiveData5;
                MutableLiveData y9;
                MutableLiveData mutableLiveData6;
                SwipeButtonState g8;
                MutableLiveData mutableLiveData7;
                MutableLiveData mutableLiveData8;
                MutableLiveData mutableLiveData9;
                MutableLiveData mutableLiveData10;
                MutableLiveData y10;
                MutableLiveData mutableLiveData11;
                MutableLiveData mutableLiveData12;
                OrderStateChange e8 = notification.e();
                if (e8 == null) {
                    return;
                }
                if (e8 instanceof OrderStateChangeProgress) {
                    y10 = OrderViewModel.this.y();
                    y10.o(Boolean.TRUE);
                    mutableLiveData11 = OrderViewModel.this.f31980z0;
                    mutableLiveData12 = OrderViewModel.this.f31980z0;
                    Object b8 = LiveDataExtKt.b(mutableLiveData12);
                    Intrinsics.e(b8, "bottomSheetState.requireValue()");
                    mutableLiveData11.o(BottomWidgetStates.b((BottomWidgetStates) b8, false, null, null, SwipeButtonOverrideState.CHANGING, null, 0L, 55, null));
                } else {
                    SwipeButtonOverrideState swipeButtonOverrideState = null;
                    if (e8 instanceof OrderStateChangeSuccess) {
                        y9 = OrderViewModel.this.y();
                        y9.o(Boolean.FALSE);
                        OrderStateChangeType a8 = e8.a();
                        int[] iArr = WhenMappings.f32018a;
                        if (iArr[a8.ordinal()] == 1) {
                            mutableLiveData10 = OrderViewModel.this.f31952l0;
                            if (((OrderData) LiveDataExtKt.b(mutableLiveData10)).a().f() == OrderState.ORDER_STATE_WAITING_ON_STOP) {
                                g8 = SwipeButtonState.STAYING_AT_WAITING_POINT;
                            } else {
                                g8 = SwipeButtonState.DISCLAIMER;
                            }
                        } else {
                            mutableLiveData6 = OrderViewModel.this.f31980z0;
                            g8 = ((BottomWidgetStates) LiveDataExtKt.b(mutableLiveData6)).g();
                        }
                        SwipeButtonState swipeButtonState = g8;
                        int i8 = iArr[e8.a().ordinal()];
                        if (i8 != 1 && i8 != 2 && i8 != 3) {
                            swipeButtonOverrideState = SwipeButtonOverrideState.CHANGED;
                        }
                        SwipeButtonOverrideState swipeButtonOverrideState2 = swipeButtonOverrideState;
                        mutableLiveData7 = OrderViewModel.this.f31980z0;
                        if (((BottomWidgetStates) LiveDataExtKt.b(mutableLiveData7)).f() == SwipeButtonOverrideState.CHANGING) {
                            mutableLiveData8 = OrderViewModel.this.f31980z0;
                            mutableLiveData9 = OrderViewModel.this.f31980z0;
                            Object b9 = LiveDataExtKt.b(mutableLiveData9);
                            Intrinsics.e(b9, "bottomSheetState.requireValue()");
                            mutableLiveData8.o(BottomWidgetStates.b((BottomWidgetStates) b9, false, null, swipeButtonState, swipeButtonOverrideState2, null, 0L, 51, null));
                        }
                    } else if (e8 instanceof OrderStateChangeSuccessWithData) {
                        OrderViewModel.this.C1((OrderStateChangeSuccessWithData) e8);
                        y8 = OrderViewModel.this.y();
                        y8.o(Boolean.FALSE);
                        if (WhenMappings.f32018a[e8.a().ordinal()] != 4) {
                            swipeButtonOverrideState = SwipeButtonOverrideState.CHANGED;
                        }
                        SwipeButtonOverrideState swipeButtonOverrideState3 = swipeButtonOverrideState;
                        mutableLiveData3 = OrderViewModel.this.f31980z0;
                        if (((BottomWidgetStates) LiveDataExtKt.b(mutableLiveData3)).f() == SwipeButtonOverrideState.CHANGING) {
                            mutableLiveData4 = OrderViewModel.this.f31980z0;
                            mutableLiveData5 = OrderViewModel.this.f31980z0;
                            Object b10 = LiveDataExtKt.b(mutableLiveData5);
                            Intrinsics.e(b10, "bottomSheetState.requireValue()");
                            mutableLiveData4.o(BottomWidgetStates.b((BottomWidgetStates) b10, false, null, null, swipeButtonOverrideState3, null, 0L, 55, null));
                        }
                    } else if (e8 instanceof OrderStateChangeError) {
                        y7 = OrderViewModel.this.y();
                        y7.o(Boolean.FALSE);
                        mutableLiveData = OrderViewModel.this.f31980z0;
                        mutableLiveData2 = OrderViewModel.this.f31980z0;
                        Object b11 = LiveDataExtKt.b(mutableLiveData2);
                        Intrinsics.e(b11, "bottomSheetState.requireValue()");
                        mutableLiveData.o(BottomWidgetStates.b((BottomWidgetStates) b11, false, null, null, null, null, 0L, 55, null));
                        if (e8.a() == OrderStateChangeType.ACCEPT && ApiExceptionUtils.m(((OrderStateChangeError) e8).b(), 415)) {
                            liveEvent = OrderViewModel.this.T;
                            liveEvent.m(Unit.f50853a);
                        } else {
                            BaseViewModel.A(OrderViewModel.this, ((OrderStateChangeError) e8).b(), null, 2, null);
                        }
                    }
                }
                OrderViewModel.this.R3();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notification<OrderStateChange> notification) {
                b(notification);
                return Unit.f50853a;
            }
        };
        Consumer<? super Notification<OrderStateChange>> consumer2 = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.l0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.j2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function17 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initOrderDataFlow$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                OrderViewModel orderViewModel = OrderViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderViewModel, it, null, 2, null);
            }
        };
        this.f31960p0 = observeOn.subscribe(consumer2, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.m0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.k2(Function1.this, obj);
            }
        });
        Observable<Double> observeOn2 = this.f31939f.d().observeOn(AndroidSchedulers.a());
        final Function1<Double, Unit> function18 = new Function1<Double, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initOrderDataFlow$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Double d8) {
                MutableLiveData mutableLiveData;
                mutableLiveData = OrderViewModel.this.f31954m0;
                mutableLiveData.o(d8);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Double d8) {
                b(d8);
                return Unit.f50853a;
            }
        };
        this.f31962q0 = observeOn2.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.n0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.l2(Function1.this, obj);
            }
        });
        Observable<Boolean> observeOn3 = this.f31973w.d().observeOn(AndroidSchedulers.a());
        final Function1<Boolean, Unit> function19 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initOrderDataFlow$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean it) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                mutableLiveData = OrderViewModel.this.f31956n0;
                mutableLiveData2 = OrderViewModel.this.f31956n0;
                Object b8 = LiveDataExtKt.b(mutableLiveData2);
                Intrinsics.e(b8, "startPaidWaitingData.requireValue()");
                Intrinsics.e(it, "it");
                mutableLiveData.o(StartPaidWaitingData.b((StartPaidWaitingData) b8, it.booleanValue(), false, 2, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        this.f31966s0 = observeOn3.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.p0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.m2(Function1.this, obj);
            }
        });
        Observable<Boolean> observeOn4 = this.f31941g.d().observeOn(AndroidSchedulers.a());
        final Function1<Boolean, Unit> function110 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$initOrderDataFlow$10
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean it) {
                LiveEvent liveEvent;
                Intrinsics.e(it, "it");
                if (it.booleanValue()) {
                    liveEvent = OrderViewModel.this.P;
                    liveEvent.o(ConfirmationSignal.AUTO_REMINDER);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        this.f31964r0 = observeOn4.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.q0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.n2(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h3(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void i1() {
        this.B.s();
        this.f31953m.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void l1() {
        this.f31953m.j0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void l3(List<UpcomingStop> list) {
        this.B.p();
        this.f31953m.c0(r2(list));
    }

    private final void m1() {
        MutableLiveData<ScreenState> mutableLiveData = this.f31942g0;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "screenState.requireValue()");
        mutableLiveData.o(ScreenState.b((ScreenState) b8, NavigationMode.SEGMENT, null, null, false, null, null, false, 126, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Text n3(List<String> list, List<String> list2) {
        Object i02;
        Object i03;
        Text.Resource resource;
        if (list.isEmpty() || list2.isEmpty()) {
            return null;
        }
        if (list.size() < list2.size()) {
            resource = new Text.Resource(R.string.active_rider_stop_added_info, null, 2, null);
        } else if (list.size() > list2.size()) {
            resource = new Text.Resource(R.string.route_updated_message, null, 2, null);
        } else {
            i02 = CollectionsKt___CollectionsKt.i0(list);
            i03 = CollectionsKt___CollectionsKt.i0(list2);
            if (!Intrinsics.a(i02, i03)) {
                resource = new Text.Resource(R.string.route_updated_message, null, 2, null);
            } else if (Intrinsics.a(list, list2)) {
                return null;
            } else {
                resource = new Text.Resource(R.string.active_rider_stop_added_info, null, 2, null);
            }
        }
        return resource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1() {
    }

    private final boolean o2(GeoCoordinate geoCoordinate) {
        OrderMenuData b8;
        List<UpcomingStop> n8;
        double d8;
        OrderData f8 = this.f31952l0.f();
        if (f8 == null || (b8 = f8.b()) == null || (n8 = b8.n()) == null) {
            return false;
        }
        int size = n8.size();
        if (size != 0 && size != 1) {
            d8 = 500.0d;
        } else {
            d8 = 200.0d;
        }
        GeoLocation q8 = this.H.q();
        if (q8 == null || GeoUtils.f36938a.f(q8.e(), geoCoordinate) >= d8) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean p2() {
        OrderState orderState;
        OrderCommonData a8;
        OrderData f8 = this.f31952l0.f();
        SwipeButtonState swipeButtonState = null;
        if (f8 != null && (a8 = f8.a()) != null) {
            orderState = a8.f();
        } else {
            orderState = null;
        }
        if (orderState != OrderState.ORDER_STATE_WAITING_ON_STOP) {
            BottomWidgetStates f9 = this.f31980z0.f();
            if (f9 != null) {
                swipeButtonState = f9.g();
            }
            if (swipeButtonState != SwipeButtonState.DRIVING_TO_WAITING_POINT) {
                return false;
            }
        }
        return true;
    }

    private final void q1() {
        MutableLiveData<ScreenState> mutableLiveData = this.f31942g0;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "screenState.requireValue()");
        mutableLiveData.o(ScreenState.b((ScreenState) b8, NavigationMode.FOLLOW, null, null, false, null, null, false, 126, null));
    }

    private final boolean q2() {
        return this.f31952l0.f() instanceof OrderData.WaitingOnStopData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q3(DriverAppDisabledReason driverAppDisabledReason) {
        Long l8;
        OrderCommonData a8;
        OrderHandle e8;
        Disposable disposable = this.f31935b0;
        if (disposable != null) {
            disposable.dispose();
        }
        DeviceInfoSender deviceInfoSender = this.N;
        OrderData f8 = this.f31952l0.f();
        if (f8 != null && (a8 = f8.a()) != null && (e8 = a8.e()) != null) {
            l8 = Long.valueOf(e8.b());
        } else {
            l8 = null;
        }
        Single<Optional<EmptyServerResponse>> a9 = deviceInfoSender.a(driverAppDisabledReason, l8);
        final OrderViewModel$sendDriverAppDisabledEvent$1 orderViewModel$sendDriverAppDisabledEvent$1 = new Function1<Optional<EmptyServerResponse>, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$sendDriverAppDisabledEvent$1
            public final void b(Optional<EmptyServerResponse> optional) {
                Kalev.k("App disabled event sent");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<EmptyServerResponse> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer<? super Optional<EmptyServerResponse>> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.n1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.r3(Function1.this, obj);
            }
        };
        final OrderViewModel$sendDriverAppDisabledEvent$2 orderViewModel$sendDriverAppDisabledEvent$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$sendDriverAppDisabledEvent$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to send app disabled event");
            }
        };
        this.f31935b0 = a9.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.o1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.s3(Function1.this, obj);
            }
        });
    }

    private final List<ChangeRouteRequest.DestinationStop> r2(List<UpcomingStop> list) {
        int v7;
        boolean z7;
        ArrayList<UpcomingStop> arrayList = new ArrayList();
        for (Object obj : list) {
            UpcomingStop upcomingStop = (UpcomingStop) obj;
            if (upcomingStop.d() != null && upcomingStop.c() != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                arrayList.add(obj);
            }
        }
        v7 = CollectionsKt__IterablesKt.v(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        for (UpcomingStop upcomingStop2 : arrayList) {
            String a8 = upcomingStop2.a();
            Double c8 = upcomingStop2.c();
            Intrinsics.c(c8);
            double doubleValue = c8.doubleValue();
            Double d8 = upcomingStop2.d();
            Intrinsics.c(d8);
            arrayList2.add(new ChangeRouteRequest.DestinationStop(a8, doubleValue, d8.doubleValue()));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r3(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s3(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void t1(OrderViewModel orderViewModel, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        orderViewModel.s1(z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1() {
    }

    private final void v2() {
        PublishSubject<DidYouGetHelpType> a8 = this.F.a();
        final Function1<DidYouGetHelpType, Unit> function1 = new Function1<DidYouGetHelpType, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$observeDidYouGetHelpSignal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DidYouGetHelpType didYouGetHelpType) {
                MutableLiveData mutableLiveData;
                mutableLiveData = OrderViewModel.this.W;
                mutableLiveData.o(didYouGetHelpType);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DidYouGetHelpType didYouGetHelpType) {
                b(didYouGetHelpType);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = a8.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.d1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.w2(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeDidYo…    }.autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w3(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final String x1() {
        OrderCommonData a8;
        OrderHandle e8;
        OrderData f8 = this.f31952l0.f();
        if (f8 != null && (a8 = f8.a()) != null && (e8 = a8.e()) != null) {
            return Long.valueOf(e8.b()).toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x3(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void y3() {
        this.Y.m(Boolean.valueOf(this.f31971v.N().a()));
    }

    public final LiveData<Boolean> A1() {
        return this.f31944h0;
    }

    public final LiveData<MapState> A2() {
        return this.f31950k0;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        R1();
        T1();
        d2();
        L1();
        H1();
        D1();
        a2();
        v2();
        L2();
        this.f31967t.e();
        this.f31963r.f();
        ObservableLiveData.t(this.G0, this.A.e(), null, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.f(it, "it");
                BaseViewModel.A(OrderViewModel.this, it, null, 2, null);
            }
        }, 2, null);
        Observable<Boolean> observeOn = this.L.c().observeOn(AndroidSchedulers.a());
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$onStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean bool) {
                MutableLiveData mutableLiveData;
                mutableLiveData = OrderViewModel.this.f31938e0;
                mutableLiveData.o(bool);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        this.f31940f0 = observeOn.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.d0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.h3(Function1.this, obj);
            }
        });
    }

    public final LiveEvent<DriverAppDisabledReason> B2() {
        return this.Z;
    }

    public final void B3() {
        String e8;
        if (this.f31969u.q().r()) {
            NavigationOption a8 = this.f31969u.v().I().a();
            if (a8 != null) {
                e8 = a8.getName();
            } else {
                e8 = null;
            }
        } else {
            e8 = this.f31969u.t().r().a().e();
        }
        this.B.C(((OrderData) LiveDataExtKt.b(this.f31952l0)).a().f(), e8, x1(), this.f31969u.m().C());
        GeoCoordinate c8 = ((OrderData) LiveDataExtKt.b(this.f31952l0)).a().c();
        if (c8 == null) {
            c8 = ((OrderData) LiveDataExtKt.b(this.f31952l0)).a().d();
        }
        if (c8 != null) {
            this.f31951l.a(c8);
        }
    }

    public final LiveData<Optional<NoAnswerIncomingCall>> C2() {
        return this.E0;
    }

    public final void C3(boolean z7) {
        OrderData f8 = this.f31952l0.f();
        if (f8 != null) {
            if (f8 instanceof OrderData.GoingToPickupData) {
                OrderData.GoingToPickupData goingToPickupData = (OrderData.GoingToPickupData) f8;
                b1(z7);
            } else if (f8 instanceof OrderData.WaitingForClientData) {
                OrderData.WaitingForClientData waitingForClientData = (OrderData.WaitingForClientData) f8;
                i1();
            } else if (f8 instanceof OrderData.DrivingWithClientData) {
                T3((OrderData.DrivingWithClientData) f8, z7);
            } else if (f8 instanceof OrderData.WaitingOnStopData) {
                OrderData.WaitingOnStopData waitingOnStopData = (OrderData.WaitingOnStopData) f8;
                l1();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final LiveEvent<ChatFragment$ChatParams> D2() {
        return this.f31970u0;
    }

    public final LiveData<OrderData> E2() {
        return this.f31952l0;
    }

    public final void E3() {
        NavigationMode navigationMode;
        boolean z7;
        ScreenState f8 = this.f31942g0.f();
        if (f8 != null) {
            navigationMode = f8.d();
        } else {
            navigationMode = null;
        }
        if (navigationMode == NavigationMode.FOLLOW) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            m1();
        } else if (this.f31952l0.f() != null) {
            if (!this.f31969u.t().s().a()) {
                this.P.o(ConfirmationSignal.CHOOSE_NAVIGATOR);
                this.f31969u.t().s().b(true);
                MutableLiveData<ScreenState> mutableLiveData = this.f31942g0;
                Object b8 = LiveDataExtKt.b(mutableLiveData);
                Intrinsics.e(b8, "screenState.requireValue()");
                mutableLiveData.o(ScreenState.b((ScreenState) b8, null, this.f31965s.c(Navigator.Type.TAXIFY_NAVIGATION), null, false, null, null, false, 125, null));
                return;
            }
            OrderTracker orderTracker = this.B;
            OrderState f9 = ((OrderData) LiveDataExtKt.b(this.f31952l0)).a().f();
            Navigator.Type type = Navigator.Type.TAXIFY_NAVIGATION;
            orderTracker.C(f9, type.e(), x1(), this.f31969u.m().C());
            this.f31969u.t().g0(type);
            q1();
        }
    }

    public final LiveData<Boolean> F2() {
        LiveData<Boolean> b8 = Transformations.b(this.f31956n0, new androidx.arch.core.util.Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.j1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Boolean G2;
                G2 = OrderViewModel.G2((StartPaidWaitingData) obj);
                return G2;
            }
        });
        Intrinsics.e(b8, "map(startPaidWaitingData…t.calculateVisibility() }");
        return b8;
    }

    public final void F3() {
        this.B.d(q2());
    }

    public final void G3() {
        this.B.e();
    }

    public final LiveData<Price> H2() {
        return this.f31978y0;
    }

    public final void H3() {
        this.B.f(q2());
    }

    public final LiveData<PushMessage> I2() {
        return this.f31967t.d();
    }

    public final void I3() {
        this.B.g();
    }

    public final LiveData<Boolean> J2() {
        LiveData b8 = Transformations.b(this.f31950k0, new androidx.arch.core.util.Function() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$observeRiderLocationEnabledSignal$$inlined$map$1
            @Override // androidx.arch.core.util.Function
            public final Boolean apply(MapState mapState) {
                boolean z7;
                if (mapState.c().c() != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        });
        Intrinsics.e(b8, "crossinline transform: (…p(this) { transform(it) }");
        LiveData<Boolean> a8 = Transformations.a(b8);
        Intrinsics.e(a8, "distinctUntilChanged(this)");
        return a8;
    }

    public final LiveData<SafetyFABButtonType> K2() {
        MutableLiveData<SafetyFABButtonType> mutableLiveData = this.X;
        Intrinsics.d(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyFABButtonType>");
        return mutableLiveData;
    }

    public final void L3() {
        this.f31959p.U2();
    }

    public final void M3(String message, String status) {
        Intrinsics.f(message, "message");
        Intrinsics.f(status, "status");
        this.B.I(message, status);
    }

    public final void N3() {
        this.f31961q.M0();
    }

    public final LiveData<Boolean> O2() {
        return this.Y;
    }

    public final void O3(GeoCoordinate coordinate) {
        Intrinsics.f(coordinate, "coordinate");
        this.B.Z(q2(), o2(coordinate));
    }

    public final LiveData<Unit> P2() {
        return this.T;
    }

    public final void P3() {
        this.B.d0();
    }

    public final LiveData<List<RejectReason>> Q2() {
        return this.R;
    }

    public final void Q3() {
        this.f31959p.k3();
    }

    public final LiveData<Unit> R2() {
        return this.Q;
    }

    public final LiveData<CancelWarningType> S2() {
        return this.S;
    }

    public final void S3() {
        this.Y.m(Boolean.TRUE);
        this.f31971v.N().b(true);
    }

    public final LiveData<WarningMessage> T2() {
        return this.G0;
    }

    public final void U2(boolean z7) {
        if (z7) {
            this.B.Y();
        } else {
            this.B.X();
        }
    }

    public final void V2(CancelWarningType warningType) {
        Intrinsics.f(warningType, "warningType");
        if (warningType instanceof CancelWarningType.CampaignWarning) {
            this.B.k();
        } else if (warningType instanceof CancelWarningType.DriverScoreAndCampaignWarning) {
            this.B.m();
        } else if (warningType instanceof CancelWarningType.DriverScoreWarning) {
            this.B.l();
        }
    }

    public final void W2() {
        this.B.n(((OrderData) LiveDataExtKt.b(this.f31952l0)).a().f());
    }

    public final void X0() {
        Disposable disposable = this.f31974w0;
        if (disposable != null) {
            disposable.dispose();
        }
        Completable a8 = CompletableExtKt.a(this.f31955n.j(true));
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.order.v2.r0
            @Override // io.reactivex.functions.Action
            public final void run() {
                OrderViewModel.Y0();
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$allowNextOrder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                OrderViewModel orderViewModel = OrderViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderViewModel, it, null, 2, null);
            }
        };
        this.f31974w0 = a8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.s0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.Z0(Function1.this, obj);
            }
        });
    }

    public final void X2() {
        this.B.r();
    }

    public final void Y2(boolean z7) {
        this.B.i(z7);
    }

    public final void a1() {
        this.f31953m.P();
    }

    public final void a3() {
        this.B.B(((OrderData) LiveDataExtKt.b(this.f31952l0)).a().f());
    }

    public final void b3() {
        this.B.L();
    }

    public final void c1() {
        this.B0.m(Boolean.FALSE);
    }

    public final void c3() {
        this.B.M();
    }

    public final void d1() {
        if (!DisposableExtKt.b(this.f31976x0)) {
            return;
        }
        this.B.P();
        Single d8 = SingleExtKt.d(this.f31957o.a(((OrderData) LiveDataExtKt.b(this.f31952l0)).a().e()));
        final Function1<Price, Unit> function1 = new Function1<Price, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$calculatePrice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Price price) {
                LiveEvent liveEvent;
                liveEvent = OrderViewModel.this.f31978y0;
                liveEvent.o(price);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Price price) {
                b(price);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.k1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.e1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$calculatePrice$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                OrderViewModel orderViewModel = OrderViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderViewModel, it, null, 2, null);
            }
        };
        this.f31976x0 = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.r1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.f1(Function1.this, obj);
            }
        });
    }

    public final void d3() {
        this.B.K();
    }

    public final void e3() {
        DeeplinkCall.Chat chat;
        DeeplinkCall a8 = this.f31975x.a();
        ChatFragment$ChatParams chatFragment$ChatParams = null;
        if (a8 instanceof DeeplinkCall.Chat) {
            chat = (DeeplinkCall.Chat) a8;
        } else {
            chat = null;
        }
        if (chat != null) {
            chatFragment$ChatParams = chat.b();
        }
        if (chatFragment$ChatParams != null) {
            this.f31970u0.o(chatFragment$ChatParams);
        }
        y3();
    }

    public final void f3() {
        this.B.a0();
    }

    public final void g1() {
        this.f31953m.U();
    }

    public final void g3() {
        this.B.e0();
    }

    public final void h1(List<UpcomingStop> upcomingStops, AddressChangeType addressChangeType) {
        Intrinsics.f(upcomingStops, "upcomingStops");
        Intrinsics.f(addressChangeType, "addressChangeType");
        if (WhenMappings.f31983c[addressChangeType.ordinal()] == 1) {
            if (p2()) {
                this.U.o(Unit.f50853a);
                return;
            } else {
                l3(upcomingStops);
                return;
            }
        }
        l3(upcomingStops);
    }

    public final void i3() {
        this.B.N();
    }

    public final void j1() {
        this.E0.o(Optional.a());
    }

    public final void j3() {
        this.B.O();
    }

    public final void k1(List<RejectReason> list) {
        if (list != null) {
            B1(null, list);
        } else {
            k3();
        }
    }

    public final void k3() {
        OrderStateManager.x0(this.f31953m, null, 1, null);
        this.C.b();
    }

    public final void m3() {
        this.f31938e0.o(Boolean.FALSE);
        this.M.t();
    }

    public final void n1() {
        Unit unit;
        OrderCommonData a8;
        OrderHandle e8;
        OrderData f8 = this.f31952l0.f();
        if (f8 != null && (a8 = f8.a()) != null && (e8 = a8.e()) != null) {
            Completable a9 = CompletableExtKt.a(this.f31955n.e(e8.a()));
            Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.order.v2.s1
                @Override // io.reactivex.functions.Action
                public final void run() {
                    OrderViewModel.o1();
                }
            };
            final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$disableNewOrder$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    OrderViewModel orderViewModel = OrderViewModel.this;
                    Intrinsics.e(it, "it");
                    BaseViewModel.A(orderViewModel, it, null, 2, null);
                }
            };
            Disposable G = a9.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.t1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    OrderViewModel.p1(Function1.this, obj);
                }
            });
            Intrinsics.e(G, "fun disableNewOrder() {\n…ded yet\")\n        }\n    }");
            v(G);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            Kalev.m(new IllegalStateException("Order haven't been loaded yet"), "Order haven't been loaded yet");
        }
    }

    public final LiveData<ScreenState> o3() {
        return this.f31942g0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f31948j0;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f31958o0;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
        Disposable disposable3 = this.f31960p0;
        if (disposable3 != null) {
            DisposableExtKt.a(disposable3);
        }
        Disposable disposable4 = this.f31974w0;
        if (disposable4 != null) {
            DisposableExtKt.a(disposable4);
        }
        Disposable disposable5 = this.A0;
        if (disposable5 != null) {
            DisposableExtKt.a(disposable5);
        }
        Disposable disposable6 = this.C0;
        if (disposable6 != null) {
            DisposableExtKt.a(disposable6);
        }
        Disposable disposable7 = this.f31937d0;
        if (disposable7 != null) {
            DisposableExtKt.a(disposable7);
        }
        this.f31963r.d();
        Disposable disposable8 = this.f31966s0;
        if (disposable8 != null) {
            disposable8.dispose();
        }
        Disposable disposable9 = this.f31964r0;
        if (disposable9 != null) {
            disposable9.dispose();
        }
        Disposable disposable10 = this.F0;
        if (disposable10 != null) {
            DisposableExtKt.a(disposable10);
        }
        Disposable disposable11 = this.f31968t0;
        if (disposable11 != null) {
            DisposableExtKt.a(disposable11);
        }
        Disposable disposable12 = this.f31940f0;
        if (disposable12 != null) {
            DisposableExtKt.a(disposable12);
        }
        Disposable disposable13 = this.f31934a0;
        if (disposable13 != null) {
            DisposableExtKt.a(disposable13);
        }
        Disposable disposable14 = this.f31935b0;
        if (disposable14 != null) {
            DisposableExtKt.a(disposable14);
        }
    }

    public final void p3(long j8) {
        this.B.f0();
        this.f31953m.C0(j8);
    }

    public final void r1() {
        this.f31953m.t0(((OrderData) LiveDataExtKt.b(this.f31952l0)).a().e());
    }

    public final void s1(boolean z7) {
        if (z7) {
            this.B.v();
        } else {
            this.B.u();
        }
        this.f31953m.r0();
    }

    public final MutableLiveData<Boolean> s2() {
        return this.B0;
    }

    public final LiveData<BottomWidgetStates> t2() {
        return this.f31980z0;
    }

    public final void t3(BottomBarState state) {
        Intrinsics.f(state, "state");
        MutableLiveData<BottomWidgetStates> mutableLiveData = this.f31980z0;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "bottomSheetState.requireValue()");
        mutableLiveData.o(BottomWidgetStates.b((BottomWidgetStates) b8, false, state, null, null, null, 0L, 61, null));
        R3();
    }

    public final void u1() {
        Disposable disposable = this.f31974w0;
        if (disposable != null) {
            disposable.dispose();
        }
        Completable a8 = CompletableExtKt.a(this.f31955n.j(false));
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.order.v2.t0
            @Override // io.reactivex.functions.Action
            public final void run() {
                OrderViewModel.v1();
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$forbidNextOrder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                OrderViewModel orderViewModel = OrderViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderViewModel, it, null, 2, null);
            }
        };
        this.f31974w0 = a8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.u0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.w1(Function1.this, obj);
            }
        });
    }

    public final LiveData<ConfirmationSignal> u2() {
        return this.P;
    }

    public final void u3(String addressText, GeoCoordinate point) {
        Intrinsics.f(addressText, "addressText");
        Intrinsics.f(point, "point");
        this.B.p();
        this.f31953m.G0(addressText, point);
    }

    public final void v3() {
        OrderHandle e8 = ((OrderData) LiveDataExtKt.b(this.f31952l0)).a().e();
        Single l8 = l(SingleExtKt.d(this.E.a(e8.a(), e8.b())));
        final Function1<RouteSharing, Unit> function1 = new Function1<RouteSharing, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$shareTrip$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(RouteSharing routeSharing) {
                RouteSharingInteractor routeSharingInteractor;
                routeSharingInteractor = OrderViewModel.this.E;
                routeSharingInteractor.b(routeSharing.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RouteSharing routeSharing) {
                b(routeSharing);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.o0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.w3(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.OrderViewModel$shareTrip$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                OrderViewModel orderViewModel = OrderViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderViewModel, it, null, 2, null);
            }
        };
        this.f31968t0 = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.z0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderViewModel.x3(Function1.this, obj);
            }
        });
    }

    public final LiveData<DidYouGetHelpType> x2() {
        MutableLiveData<DidYouGetHelpType> mutableLiveData = this.W;
        Intrinsics.d(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpType>");
        return mutableLiveData;
    }

    public LiveData<NetworkConnectionStatus> y1() {
        return this.f31963r.e();
    }

    public final LiveData<Unit> y2() {
        return this.U;
    }

    public final MapStyle z1() {
        return AppThemeUtils.f34255a.c(this.D.d());
    }

    public final LiveData<Text> z2() {
        return this.V;
    }

    public final void z3(List<RejectReason> list) {
        this.R.m(list);
    }
}
