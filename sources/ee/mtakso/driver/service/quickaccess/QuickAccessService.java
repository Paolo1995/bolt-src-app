package ee.mtakso.driver.service.quickaccess;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.view.ContextThemeWrapper;
import android.view.WindowManager;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.navigation.NavigationManager;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.order.Order;
import ee.mtakso.driver.network.client.order.OrderKt;
import ee.mtakso.driver.network.client.order.UpcomingStop;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.param.field.BooleanSettingsField;
import ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics;
import ee.mtakso.driver.service.chat.ChatActiveOrderSource;
import ee.mtakso.driver.service.geo.GeoCoordinate;
import ee.mtakso.driver.service.geo.GeoLocation;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.quickaccess.QuickAccessService;
import ee.mtakso.driver.ui.screens.order.v2.order.NavigationTarget;
import ee.mtakso.driver.ui.screens.order.v2.order.NavigationTargetInteractor;
import ee.mtakso.driver.ui.views.quickaccess.OnChangeStateButtonClickListener;
import ee.mtakso.driver.ui.views.quickaccess.OnChatButtonClickListener;
import ee.mtakso.driver.ui.views.quickaccess.QuickAccessController;
import ee.mtakso.driver.ui.views.quickaccess.QuickAccessMode;
import ee.mtakso.driver.ui.views.quickaccess.QuickAccessOrderMapper;
import ee.mtakso.driver.ui.views.quickaccess.QuickAccessPrefsManager;
import ee.mtakso.driver.utils.AppForegroundState;
import ee.mtakso.driver.utils.BackgroundManager;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.android.maps.core.GeoUtils;
import eu.bolt.driver.chat.service.ChatManager;
import eu.bolt.driver.chat.service.ConversationPreviewData;
import eu.bolt.driver.core.R$style;
import eu.bolt.driver.core.util.ObservableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickAccessService.kt */
/* loaded from: classes3.dex */
public final class QuickAccessService extends Service {
    public static final Companion D = new Companion(null);
    private QuickAccessController A;
    private QuickAccessMode B;
    private Observable<Optional<ActiveOrderDetails>> C;
    @Inject

    /* renamed from: f  reason: collision with root package name */
    public OrderProvider f25736f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    public DriverProvider f25737g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    public DriverStatusSender f25738h;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public BackgroundManager f25739i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public WindowManager f25740j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public SurgeManager f25741k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public OrderStateManager f25742l;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public NavigationTargetInteractor f25743m;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public NavigationManager f25744n;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public Features f25745o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public OrderFlowAnalytics f25746p;
    @Inject

    /* renamed from: q  reason: collision with root package name */
    public QuickAccessPrefsManager f25747q;
    @Inject

    /* renamed from: r  reason: collision with root package name */
    public GeoLocationManager f25748r;
    @Inject

    /* renamed from: s  reason: collision with root package name */
    public ChatManager f25749s;
    @Inject

    /* renamed from: t  reason: collision with root package name */
    public ChatActiveOrderSource f25750t;

    /* renamed from: u  reason: collision with root package name */
    private final Lazy f25751u;

    /* renamed from: v  reason: collision with root package name */
    private Disposable f25752v;

    /* renamed from: w  reason: collision with root package name */
    private Disposable f25753w;

    /* renamed from: x  reason: collision with root package name */
    private Disposable f25754x;

    /* renamed from: y  reason: collision with root package name */
    private Disposable f25755y;

    /* renamed from: z  reason: collision with root package name */
    private Disposable f25756z;

    /* compiled from: QuickAccessService.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            Intrinsics.f(context, "context");
            return new Intent(context, QuickAccessService.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QuickAccessService.kt */
    /* loaded from: classes3.dex */
    public static final class OrderStateWithDistance {

        /* renamed from: a  reason: collision with root package name */
        private final OrderState f25757a;

        /* renamed from: b  reason: collision with root package name */
        private final double f25758b;

        public OrderStateWithDistance(OrderState orderState, double d8) {
            Intrinsics.f(orderState, "orderState");
            this.f25757a = orderState;
            this.f25758b = d8;
        }

        public final double a() {
            return this.f25758b;
        }

        public final OrderState b() {
            return this.f25757a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OrderStateWithDistance) {
                OrderStateWithDistance orderStateWithDistance = (OrderStateWithDistance) obj;
                return this.f25757a == orderStateWithDistance.f25757a && Double.compare(this.f25758b, orderStateWithDistance.f25758b) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (this.f25757a.hashCode() * 31) + q1.a.a(this.f25758b);
        }

        public String toString() {
            OrderState orderState = this.f25757a;
            double d8 = this.f25758b;
            return "OrderStateWithDistance(orderState=" + orderState + ", distance=" + d8 + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QuickAccessService.kt */
    /* loaded from: classes3.dex */
    public static final class StatusData {

        /* renamed from: a  reason: collision with root package name */
        private final AppForegroundState f25759a;

        /* renamed from: b  reason: collision with root package name */
        private final DriverStatus f25760b;

        public StatusData(AppForegroundState appForegroundState, DriverStatus driverStatus) {
            Intrinsics.f(appForegroundState, "appForegroundState");
            Intrinsics.f(driverStatus, "driverStatus");
            this.f25759a = appForegroundState;
            this.f25760b = driverStatus;
        }

        public final AppForegroundState a() {
            return this.f25759a;
        }

        public final DriverStatus b() {
            return this.f25760b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StatusData) {
                StatusData statusData = (StatusData) obj;
                return this.f25759a == statusData.f25759a && this.f25760b == statusData.f25760b;
            }
            return false;
        }

        public int hashCode() {
            return (this.f25759a.hashCode() * 31) + this.f25760b.hashCode();
        }

        public String toString() {
            AppForegroundState appForegroundState = this.f25759a;
            DriverStatus driverStatus = this.f25760b;
            return "StatusData(appForegroundState=" + appForegroundState + ", driverStatus=" + driverStatus + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QuickAccessService.kt */
    /* loaded from: classes3.dex */
    public static final class StatusOrderData {

        /* renamed from: a  reason: collision with root package name */
        private final StatusData f25761a;

        /* renamed from: b  reason: collision with root package name */
        private final ActiveOrderDetails f25762b;

        public StatusOrderData(StatusData statusData, ActiveOrderDetails activeOrderDetails) {
            Intrinsics.f(statusData, "statusData");
            this.f25761a = statusData;
            this.f25762b = activeOrderDetails;
        }

        public final ActiveOrderDetails a() {
            return this.f25762b;
        }

        public final StatusData b() {
            return this.f25761a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StatusOrderData) {
                StatusOrderData statusOrderData = (StatusOrderData) obj;
                return Intrinsics.a(this.f25761a, statusOrderData.f25761a) && Intrinsics.a(this.f25762b, statusOrderData.f25762b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f25761a.hashCode() * 31;
            ActiveOrderDetails activeOrderDetails = this.f25762b;
            return hashCode + (activeOrderDetails == null ? 0 : activeOrderDetails.hashCode());
        }

        public String toString() {
            StatusData statusData = this.f25761a;
            ActiveOrderDetails activeOrderDetails = this.f25762b;
            return "StatusOrderData(statusData=" + statusData + ", activeOrderDetails=" + activeOrderDetails + ")";
        }
    }

    /* compiled from: QuickAccessService.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25763a;

        static {
            int[] iArr = new int[Navigator.Type.values().length];
            try {
                iArr[Navigator.Type.NO_NAVIGATION_SELECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Navigator.Type.TAXIFY_NAVIGATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f25763a = iArr;
        }
    }

    public QuickAccessService() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<QuickAccessOrderMapper>() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$quickAccessOrderMapper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final QuickAccessOrderMapper invoke() {
                return new QuickAccessOrderMapper(QuickAccessService.this, null, 2, null);
            }
        });
        this.f25751u = b8;
        this.B = QuickAccessMode.COLLAPSED;
    }

    private final QuickAccessOrderMapper L() {
        return (QuickAccessOrderMapper) this.f25751u.getValue();
    }

    private final boolean P(ActiveOrderDetails activeOrderDetails) {
        Integer k8;
        if (activeOrderDetails == null || (k8 = activeOrderDetails.i().k()) == null) {
            return false;
        }
        if (activeOrderDetails.l() <= k8.intValue()) {
            return false;
        }
        return true;
    }

    private final boolean Q() {
        if (Build.VERSION.SDK_INT >= 23 && !x1.b.a(getApplicationContext())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(NavigationTarget navigationTarget) {
        if (D().t().f().a()) {
            if (D().q().r()) {
                l0(navigationTarget);
            } else {
                m0(navigationTarget);
            }
        }
    }

    private final boolean S(DriverStatus driverStatus) {
        if (driverStatus != DriverStatus.ACTIVE_ORDER && driverStatus != DriverStatus.WAITING_ORDER) {
            return false;
        }
        return true;
    }

    private final void T() {
        if (!DisposableExtKt.b(this.f25752v)) {
            return;
        }
        Observable distinctUntilChanged = Observable.combineLatest(F().u(1L), this.C, new BiFunction() { // from class: ee.mtakso.driver.service.quickaccess.c
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                QuickAccessService.OrderStateWithDistance U;
                U = QuickAccessService.U((GeoLocation) obj, (Optional) obj2);
                return U;
            }
        }).distinctUntilChanged();
        Intrinsics.e(distinctUntilChanged, "combineLatest(\n         …  .distinctUntilChanged()");
        Observable a8 = ObservableExtKt.a(distinctUntilChanged);
        final Function1<OrderStateWithDistance, Unit> function1 = new Function1<OrderStateWithDistance, Unit>() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$observeWidgetExpandState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(QuickAccessService.OrderStateWithDistance orderStateWithDistance) {
                QuickAccessMode quickAccessMode;
                if (!QuickAccessService.this.D().t().F().a()) {
                    QuickAccessService.this.k0(QuickAccessMode.COLLAPSED);
                } else if (orderStateWithDistance.b() == OrderState.ORDER_STATE_UNKNOWN || orderStateWithDistance.b() == OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION) {
                    QuickAccessService.this.k0(QuickAccessMode.COLLAPSED);
                } else if (orderStateWithDistance.b() == OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT) {
                    QuickAccessService.this.k0(QuickAccessMode.ACTIONABLE);
                } else {
                    QuickAccessService quickAccessService = QuickAccessService.this;
                    if (orderStateWithDistance.a() < 100.0d) {
                        quickAccessMode = QuickAccessMode.ACTIONABLE;
                    } else if (orderStateWithDistance.a() < 200.0d) {
                        quickAccessMode = QuickAccessMode.INFO;
                    } else {
                        quickAccessMode = QuickAccessMode.COLLAPSED;
                    }
                    quickAccessService.k0(quickAccessMode);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QuickAccessService.OrderStateWithDistance orderStateWithDistance) {
                b(orderStateWithDistance);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.quickaccess.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuickAccessService.V(Function1.this, obj);
            }
        };
        final QuickAccessService$observeWidgetExpandState$3 quickAccessService$observeWidgetExpandState$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$observeWidgetExpandState$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Exception on quick access widget expand detection!");
            }
        };
        this.f25752v = a8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.quickaccess.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuickAccessService.W(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OrderStateWithDistance U(GeoLocation location, Optional orderOptional) {
        Intrinsics.f(location, "location");
        Intrinsics.f(orderOptional, "orderOptional");
        ActiveOrderDetails activeOrderDetails = (ActiveOrderDetails) orderOptional.c();
        double d8 = Double.MAX_VALUE;
        if (activeOrderDetails == null) {
            return new OrderStateWithDistance(OrderState.ORDER_STATE_UNKNOWN, Double.MAX_VALUE);
        }
        GeoCoordinate b8 = OrderKt.b(activeOrderDetails.i());
        if (b8 != null) {
            d8 = GeoUtils.f36938a.f(location.e(), b8);
        }
        return new OrderStateWithDistance(activeOrderDetails.b(), d8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional X(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatusData b0(AppForegroundState appStatus, DriverStatus driver) {
        Intrinsics.f(appStatus, "appStatus");
        Intrinsics.f(driver, "driver");
        return new StatusData(appStatus, driver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StatusOrderData c0(StatusData data, Optional activeOrderDetailsOptional) {
        ActiveOrderDetails activeOrderDetails;
        Intrinsics.f(data, "data");
        Intrinsics.f(activeOrderDetailsOptional, "activeOrderDetailsOptional");
        if (activeOrderDetailsOptional.d()) {
            activeOrderDetails = null;
        } else {
            activeOrderDetails = (ActiveOrderDetails) activeOrderDetailsOptional.b();
        }
        return new StatusOrderData(data, activeOrderDetails);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d0(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.s(obj, obj2)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource e0(Function1 tmp0, Observable p02) {
        Intrinsics.f(tmp0, "$tmp0");
        Intrinsics.f(p02, "p0");
        return (ObservableSource) tmp0.invoke(p02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(List<ConversationPreviewData> list) {
        BooleanSettingsField E;
        DriverSettings y7 = D().y();
        if (y7 != null && (E = y7.E()) != null && E.a()) {
            for (ConversationPreviewData conversationPreviewData : list) {
                QuickAccessController quickAccessController = this.A;
                if (quickAccessController != null) {
                    quickAccessController.z(conversationPreviewData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(StatusOrderData statusOrderData) {
        BooleanSettingsField E;
        DriverSettings y7 = D().y();
        if (y7 != null && (E = y7.E()) != null) {
            if (E.a() && S(statusOrderData.b().b()) && Q()) {
                if (statusOrderData.b().a() == AppForegroundState.FOREGROUND) {
                    QuickAccessController quickAccessController = this.A;
                    if (quickAccessController != null) {
                        quickAccessController.r();
                        return;
                    }
                    return;
                }
                QuickAccessController quickAccessController2 = this.A;
                if (quickAccessController2 == null) {
                    quickAccessController2 = new QuickAccessController(new ContextThemeWrapper(this, (int) R$style.Theme_Dark), O(), E(), L(), M());
                }
                quickAccessController2.D(this.B);
                quickAccessController2.t();
                if (statusOrderData.a() != null) {
                    quickAccessController2.A(statusOrderData.a());
                    quickAccessController2.C(new OnChangeStateButtonClickListener() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$proceedWidgetDrawing$1
                        @Override // ee.mtakso.driver.ui.views.quickaccess.OnChangeStateButtonClickListener
                        public void a() {
                            QuickAccessService.this.K().P();
                        }

                        @Override // ee.mtakso.driver.ui.views.quickaccess.OnChangeStateButtonClickListener
                        public void b() {
                            QuickAccessService.this.w();
                        }
                    });
                    quickAccessController2.B(new OnChatButtonClickListener() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$proceedWidgetDrawing$2
                        @Override // ee.mtakso.driver.ui.views.quickaccess.OnChatButtonClickListener
                        public void a() {
                        }
                    });
                }
                this.A = quickAccessController2;
                return;
            }
            QuickAccessController quickAccessController3 = this.A;
            if (quickAccessController3 != null) {
                quickAccessController3.q();
            }
            this.A = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(QuickAccessMode quickAccessMode) {
        this.B = quickAccessMode;
        QuickAccessController quickAccessController = this.A;
        if (quickAccessController != null) {
            quickAccessController.D(quickAccessMode);
        }
    }

    private final void l0(NavigationTarget navigationTarget) {
        if (D().v().I().a() != null) {
            Kalev.k("Starting auto-navigation from quick access service");
            G().a(navigationTarget.a());
        }
    }

    private final void m0(NavigationTarget navigationTarget) {
        int i8 = WhenMappings.f25763a[D().t().r().a().ordinal()];
        if (i8 != 1 && i8 != 2) {
            Kalev.k("Starting auto-navigation from quick access service");
            G().a(navigationTarget.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        Observable<Optional<ActiveOrderDetails>> observable;
        if (!DisposableExtKt.b(this.f25753w) || (observable = this.C) == null) {
            return;
        }
        Single firstOrError = ee.mtakso.driver.utils.ObservableExtKt.h(observable).firstOrError();
        final Function1<ActiveOrderDetails, Unit> function1 = new Function1<ActiveOrderDetails, Unit>() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$changeOrderState$1

            /* compiled from: QuickAccessService.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f25765a;

                static {
                    int[] iArr = new int[OrderState.values().length];
                    try {
                        iArr[OrderState.ORDER_STATE_DRIVER_ACCEPTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[OrderState.ORDER_STATE_WAITING_ON_STOP.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[OrderState.ORDER_STATE_DRIVING_WITH_CLIENT.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f25765a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ActiveOrderDetails activeOrderDetails) {
                int i8 = WhenMappings.f25765a[activeOrderDetails.i().E().ordinal()];
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            if (i8 == 4) {
                                if (activeOrderDetails.i().H().size() > 1) {
                                    QuickAccessService.this.K().L0();
                                    QuickAccessService.this.I().O(true);
                                    return;
                                }
                                QuickAccessService.this.K().r0();
                                QuickAccessService.this.I().k(true, true);
                                return;
                            }
                            return;
                        }
                        QuickAccessService.this.K().j0();
                        return;
                    }
                    QuickAccessService.this.K().h0();
                    QuickAccessService.this.I().t2(true);
                    return;
                }
                QuickAccessService.this.K().N();
                QuickAccessService.this.I().b0(true);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActiveOrderDetails activeOrderDetails) {
                b(activeOrderDetails);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.quickaccess.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuickAccessService.x(Function1.this, obj);
            }
        };
        final QuickAccessService$changeOrderState$2 quickAccessService$changeOrderState$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$changeOrderState$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Exception on observing order expose optional!");
            }
        };
        this.f25753w = firstOrError.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.quickaccess.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuickAccessService.y(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z(StatusOrderData statusOrderData, StatusOrderData statusOrderData2) {
        OrderState orderState;
        OrderState orderState2;
        List<UpcomingStop> list;
        List<UpcomingStop> list2;
        String str;
        Order i8;
        Order i9;
        ActiveOrderDetails a8 = statusOrderData.a();
        String str2 = null;
        if (a8 != null) {
            orderState = a8.b();
        } else {
            orderState = null;
        }
        ActiveOrderDetails a9 = statusOrderData2.a();
        if (a9 != null) {
            orderState2 = a9.b();
        } else {
            orderState2 = null;
        }
        if (orderState == orderState2 && statusOrderData.b().a() == statusOrderData2.b().a() && statusOrderData.b().b() == statusOrderData2.b().b()) {
            ActiveOrderDetails a10 = statusOrderData.a();
            if (a10 != null && (i9 = a10.i()) != null) {
                list = i9.H();
            } else {
                list = null;
            }
            ActiveOrderDetails a11 = statusOrderData2.a();
            if (a11 != null && (i8 = a11.i()) != null) {
                list2 = i8.H();
            } else {
                list2 = null;
            }
            if (Intrinsics.a(list, list2)) {
                ActiveOrderDetails a12 = statusOrderData.a();
                if (a12 != null) {
                    str = a12.j();
                } else {
                    str = null;
                }
                ActiveOrderDetails a13 = statusOrderData2.a();
                if (a13 != null) {
                    str2 = a13.j();
                }
                if (Intrinsics.a(str, str2) && P(statusOrderData.a()) == P(statusOrderData2.a())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final BackgroundManager A() {
        BackgroundManager backgroundManager = this.f25739i;
        if (backgroundManager != null) {
            return backgroundManager;
        }
        Intrinsics.w("backgroundManager");
        return null;
    }

    public final ChatManager B() {
        ChatManager chatManager = this.f25749s;
        if (chatManager != null) {
            return chatManager;
        }
        Intrinsics.w("chatManager");
        return null;
    }

    public final ChatActiveOrderSource C() {
        ChatActiveOrderSource chatActiveOrderSource = this.f25750t;
        if (chatActiveOrderSource != null) {
            return chatActiveOrderSource;
        }
        Intrinsics.w("chatOrderProvider");
        return null;
    }

    public final DriverProvider D() {
        DriverProvider driverProvider = this.f25737g;
        if (driverProvider != null) {
            return driverProvider;
        }
        Intrinsics.w("driverProvider");
        return null;
    }

    public final Features E() {
        Features features = this.f25745o;
        if (features != null) {
            return features;
        }
        Intrinsics.w("features");
        return null;
    }

    public final GeoLocationManager F() {
        GeoLocationManager geoLocationManager = this.f25748r;
        if (geoLocationManager != null) {
            return geoLocationManager;
        }
        Intrinsics.w("locationManager");
        return null;
    }

    public final NavigationManager G() {
        NavigationManager navigationManager = this.f25744n;
        if (navigationManager != null) {
            return navigationManager;
        }
        Intrinsics.w("navigationManager");
        return null;
    }

    public final NavigationTargetInteractor H() {
        NavigationTargetInteractor navigationTargetInteractor = this.f25743m;
        if (navigationTargetInteractor != null) {
            return navigationTargetInteractor;
        }
        Intrinsics.w("navigationTargetInteractor");
        return null;
    }

    public final OrderFlowAnalytics I() {
        OrderFlowAnalytics orderFlowAnalytics = this.f25746p;
        if (orderFlowAnalytics != null) {
            return orderFlowAnalytics;
        }
        Intrinsics.w("orderFlowAnalytics");
        return null;
    }

    public final OrderProvider J() {
        OrderProvider orderProvider = this.f25736f;
        if (orderProvider != null) {
            return orderProvider;
        }
        Intrinsics.w("orderProvider");
        return null;
    }

    public final OrderStateManager K() {
        OrderStateManager orderStateManager = this.f25742l;
        if (orderStateManager != null) {
            return orderStateManager;
        }
        Intrinsics.w("orderStateManager");
        return null;
    }

    public final QuickAccessPrefsManager M() {
        QuickAccessPrefsManager quickAccessPrefsManager = this.f25747q;
        if (quickAccessPrefsManager != null) {
            return quickAccessPrefsManager;
        }
        Intrinsics.w("quickAccessOrderPrefsMapper");
        return null;
    }

    public final DriverStatusSender N() {
        DriverStatusSender driverStatusSender = this.f25738h;
        if (driverStatusSender != null) {
            return driverStatusSender;
        }
        Intrinsics.w("statusSender");
        return null;
    }

    public final WindowManager O() {
        WindowManager windowManager = this.f25740j;
        if (windowManager != null) {
            return windowManager;
        }
        Intrinsics.w("windowManager");
        return null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        Injector.f20166d.b().x(this);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        QuickAccessController quickAccessController = this.A;
        if (quickAccessController != null) {
            quickAccessController.q();
        }
        Disposable disposable = this.f25754x;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f25753w;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.f25752v;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        this.C = null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i8, int i9) {
        Observable<AppForegroundState> h8 = A().h();
        Observable<DriverStatus> d8 = N().d();
        if (this.C == null) {
            Observable<List<OrderDetails>> a8 = J().a();
            final QuickAccessService$onStartCommand$1 quickAccessService$onStartCommand$1 = new Function1<List<? extends OrderDetails>, Optional<ActiveOrderDetails>>() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$onStartCommand$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Optional<ActiveOrderDetails> invoke(List<? extends OrderDetails> it) {
                    Intrinsics.f(it, "it");
                    ActiveOrderDetails i10 = OrderProviderUtils.i(it);
                    if (i10 != null) {
                        return Optional.f(i10);
                    }
                    return Optional.a();
                }
            };
            this.C = a8.map(new Function() { // from class: ee.mtakso.driver.service.quickaccess.a
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Optional X;
                    X = QuickAccessService.X(Function1.this, obj);
                    return X;
                }
            }).share();
        }
        Observable a9 = ObservableExtKt.a(B().j(C()));
        final Function1<List<? extends ConversationPreviewData>, Unit> function1 = new Function1<List<? extends ConversationPreviewData>, Unit>() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$onStartCommand$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<ConversationPreviewData> it) {
                QuickAccessService quickAccessService = QuickAccessService.this;
                Intrinsics.e(it, "it");
                quickAccessService.i0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ConversationPreviewData> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.quickaccess.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuickAccessService.Y(Function1.this, obj);
            }
        };
        final QuickAccessService$onStartCommand$3 quickAccessService$onStartCommand$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$onStartCommand$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Exception on observing order state in QuickAccessService!");
            }
        };
        this.f25755y = a9.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.quickaccess.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuickAccessService.a0(Function1.this, obj);
            }
        });
        if (DisposableExtKt.b(this.f25754x)) {
            Observable withLatestFrom = Observable.combineLatest(h8, d8, new BiFunction() { // from class: ee.mtakso.driver.service.quickaccess.k
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    QuickAccessService.StatusData b02;
                    b02 = QuickAccessService.b0((AppForegroundState) obj, (DriverStatus) obj2);
                    return b02;
                }
            }).withLatestFrom(this.C, new BiFunction() { // from class: ee.mtakso.driver.service.quickaccess.l
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    QuickAccessService.StatusOrderData c02;
                    c02 = QuickAccessService.c0((QuickAccessService.StatusData) obj, (Optional) obj2);
                    return c02;
                }
            });
            final QuickAccessService$onStartCommand$6 quickAccessService$onStartCommand$6 = new QuickAccessService$onStartCommand$6(this);
            Observable distinctUntilChanged = withLatestFrom.distinctUntilChanged(new BiPredicate() { // from class: ee.mtakso.driver.service.quickaccess.m
                @Override // io.reactivex.functions.BiPredicate
                public final boolean test(Object obj, Object obj2) {
                    boolean d02;
                    d02 = QuickAccessService.d0(Function2.this, obj, obj2);
                    return d02;
                }
            });
            final QuickAccessService$onStartCommand$7 quickAccessService$onStartCommand$7 = QuickAccessService$onStartCommand$7.f25774o;
            Observable compose = distinctUntilChanged.compose(new ObservableTransformer() { // from class: ee.mtakso.driver.service.quickaccess.n
                @Override // io.reactivex.ObservableTransformer
                public final ObservableSource a(Observable observable) {
                    ObservableSource e02;
                    e02 = QuickAccessService.e0(Function1.this, observable);
                    return e02;
                }
            });
            final Function1<StatusOrderData, Unit> function12 = new Function1<StatusOrderData, Unit>() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$onStartCommand$8
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(QuickAccessService.StatusOrderData it) {
                    QuickAccessService quickAccessService = QuickAccessService.this;
                    Intrinsics.e(it, "it");
                    quickAccessService.j0(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QuickAccessService.StatusOrderData statusOrderData) {
                    b(statusOrderData);
                    return Unit.f50853a;
                }
            };
            Consumer consumer2 = new Consumer() { // from class: ee.mtakso.driver.service.quickaccess.o
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    QuickAccessService.f0(Function1.this, obj);
                }
            };
            final QuickAccessService$onStartCommand$9 quickAccessService$onStartCommand$9 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$onStartCommand$9
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.e(it, "it");
                    Kalev.e(it, "Exception on observing order state in QuickAccessService!");
                }
            };
            this.f25754x = compose.subscribe(consumer2, new Consumer() { // from class: ee.mtakso.driver.service.quickaccess.p
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    QuickAccessService.g0(Function1.this, obj);
                }
            });
        }
        if (DisposableExtKt.b(this.f25756z)) {
            Observable<NavigationTarget> g8 = H().g();
            final Function1<NavigationTarget, Unit> function13 = new Function1<NavigationTarget, Unit>() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$onStartCommand$10
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(NavigationTarget it) {
                    QuickAccessService quickAccessService = QuickAccessService.this;
                    Intrinsics.e(it, "it");
                    quickAccessService.R(it);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NavigationTarget navigationTarget) {
                    b(navigationTarget);
                    return Unit.f50853a;
                }
            };
            Consumer<? super NavigationTarget> consumer3 = new Consumer() { // from class: ee.mtakso.driver.service.quickaccess.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    QuickAccessService.h0(Function1.this, obj);
                }
            };
            final QuickAccessService$onStartCommand$11 quickAccessService$onStartCommand$11 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.quickaccess.QuickAccessService$onStartCommand$11
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.e(it, "it");
                    Kalev.e(it, "Failed to start autonav flow");
                }
            };
            this.f25756z = g8.subscribe(consumer3, new Consumer() { // from class: ee.mtakso.driver.service.quickaccess.h
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    QuickAccessService.Z(Function1.this, obj);
                }
            });
        }
        T();
        return 2;
    }
}
