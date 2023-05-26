package ee.mtakso.driver.ui.screens.home.v3;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.deeplink.DeepLinkParser;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import ee.mtakso.driver.network.client.settings.SettingsResponse;
import ee.mtakso.driver.network.client.training.Training;
import ee.mtakso.driver.network.client.training.TrainingClient;
import ee.mtakso.driver.network.client.training.TrainingModal;
import ee.mtakso.driver.network.exception.ApiException;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.RateMeModel;
import ee.mtakso.driver.service.analytics.event.facade.DestinationAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.service.dashboard.DashboardService;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.push.PushMessage;
import ee.mtakso.driver.service.rating.app.AppRatingManager;
import ee.mtakso.driver.service.restriction.DriverTrainingRestrictionManager;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.common.push.PushDataService;
import ee.mtakso.driver.ui.interactor.driver.DistinctDriverStateInteractor;
import ee.mtakso.driver.ui.interactor.driver.DriverStateChangeFailInteractor;
import ee.mtakso.driver.ui.interactor.driver.MakeDriverInactiveInteractor;
import ee.mtakso.driver.ui.interactor.driver.MakeDriverInactiveStatus;
import ee.mtakso.driver.ui.interactor.driver.OnlineCheckInteractor;
import ee.mtakso.driver.ui.interactor.modaldialog.BackendModalDialogActionReporterInteractor;
import ee.mtakso.driver.ui.interactor.modaldialog.PromoDialogEvent;
import ee.mtakso.driver.ui.interactor.network_usage.NetworkUsageUploadInteractor;
import ee.mtakso.driver.ui.interactor.promodialog.HomePromoDialogInteractor;
import ee.mtakso.driver.ui.interactor.promodialog.PromoDialog;
import ee.mtakso.driver.ui.interactor.warnings.AuthorizedWarningInteractor;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.screens.dialogs.DynamicModalDialog;
import ee.mtakso.driver.ui.screens.home.v3.delegate.TrainingEvent;
import ee.mtakso.driver.ui.screens.home.v3.delegate.TrainingRetryAction;
import ee.mtakso.driver.utils.CompletableExtKt;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: HomeViewModel.kt */
/* loaded from: classes3.dex */
public final class HomeViewModel extends BaseViewModel {
    private final DispatchSettingsManager A;
    private final MutableLiveData<DriverStatus> B;
    private Disposable C;
    private final MutableLiveData<Unit> D;
    private Disposable E;
    private final MutableLiveData<RateMeModel> F;
    private Disposable G;
    private final LiveEvent<CarUnavailableDialog> H;
    private Disposable I;
    private final LiveEvent<PromoDialog> J;
    private Disposable K;
    private final LiveEvent<TrainingEvent> L;
    private Disposable M;
    private final LiveEvent<OrderDetails> N;
    private Disposable O;
    private Disposable P;
    private final ObservableLiveData<WarningMessage> Q;
    private final LiveEvent<MakeDriverInactiveStatus> R;
    private Disposable S;
    private final LiveEvent<String> T;
    private Disposable U;

    /* renamed from: f  reason: collision with root package name */
    private final DistinctDriverStateInteractor f29791f;

    /* renamed from: g  reason: collision with root package name */
    private final OnlineCheckInteractor f29792g;

    /* renamed from: h  reason: collision with root package name */
    private final MakeDriverInactiveInteractor f29793h;

    /* renamed from: i  reason: collision with root package name */
    private final PushDataService f29794i;

    /* renamed from: j  reason: collision with root package name */
    private final AppRatingManager f29795j;

    /* renamed from: k  reason: collision with root package name */
    private final OrderProvider f29796k;

    /* renamed from: l  reason: collision with root package name */
    private final OrderStateManager f29797l;

    /* renamed from: m  reason: collision with root package name */
    private final DriverManager f29798m;

    /* renamed from: n  reason: collision with root package name */
    private final DriverProvider f29799n;

    /* renamed from: o  reason: collision with root package name */
    private final CompositeUrlLauncher f29800o;

    /* renamed from: p  reason: collision with root package name */
    private final DeepLinkParser f29801p;

    /* renamed from: q  reason: collision with root package name */
    private final HomePromoDialogInteractor f29802q;

    /* renamed from: r  reason: collision with root package name */
    private final AuthorizedWarningInteractor f29803r;

    /* renamed from: s  reason: collision with root package name */
    private final DashboardService f29804s;

    /* renamed from: t  reason: collision with root package name */
    private final BackendModalDialogActionReporterInteractor f29805t;

    /* renamed from: u  reason: collision with root package name */
    private final DestinationAnalytics f29806u;

    /* renamed from: v  reason: collision with root package name */
    private final DriverStateChangeFailInteractor f29807v;

    /* renamed from: w  reason: collision with root package name */
    private final TrainingClient f29808w;

    /* renamed from: x  reason: collision with root package name */
    private final DriverTrainingRestrictionManager f29809x;

    /* renamed from: y  reason: collision with root package name */
    private final SettingsAnalytics f29810y;

    /* renamed from: z  reason: collision with root package name */
    private final NetworkUsageUploadInteractor f29811z;

    /* compiled from: HomeViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class CarUnavailableDialog {

        /* renamed from: a  reason: collision with root package name */
        private final String f29812a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f29813b;

        public CarUnavailableDialog(String carName, boolean z7) {
            Intrinsics.f(carName, "carName");
            this.f29812a = carName;
            this.f29813b = z7;
        }

        public final String a() {
            return this.f29812a;
        }

        public final boolean b() {
            return this.f29813b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CarUnavailableDialog) {
                CarUnavailableDialog carUnavailableDialog = (CarUnavailableDialog) obj;
                return Intrinsics.a(this.f29812a, carUnavailableDialog.f29812a) && this.f29813b == carUnavailableDialog.f29813b;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f29812a.hashCode() * 31;
            boolean z7 = this.f29813b;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode + i8;
        }

        public String toString() {
            String str = this.f29812a;
            boolean z7 = this.f29813b;
            return "CarUnavailableDialog(carName=" + str + ", hasCars=" + z7 + ")";
        }
    }

    @Inject
    public HomeViewModel(DistinctDriverStateInteractor driverStateInteractor, OnlineCheckInteractor onlineCheckInteractor, MakeDriverInactiveInteractor makeDriverInactiveInteractor, PushDataService pushDataService, AppRatingManager appRatingManager, OrderProvider orderProvider, OrderStateManager orderStateManager, DriverManager driverManager, DriverProvider driverProvider, CompositeUrlLauncher urlLauncher, DeepLinkParser deepLinkParser, HomePromoDialogInteractor homePromoDialogInteractor, AuthorizedWarningInteractor warningInteractor, DashboardService dashboardService, BackendModalDialogActionReporterInteractor backendModalDialogActionReporterInteractor, DestinationAnalytics destinationAnalytics, DriverStateChangeFailInteractor driverStateChangeFailInteractor, TrainingClient trainingClient, DriverTrainingRestrictionManager driverTrainingRestrictionManager, SettingsAnalytics settingsAnalytics, NetworkUsageUploadInteractor networkUsageUploadInteractor, DispatchSettingsManager dispatchSettingsManager) {
        Intrinsics.f(driverStateInteractor, "driverStateInteractor");
        Intrinsics.f(onlineCheckInteractor, "onlineCheckInteractor");
        Intrinsics.f(makeDriverInactiveInteractor, "makeDriverInactiveInteractor");
        Intrinsics.f(pushDataService, "pushDataService");
        Intrinsics.f(appRatingManager, "appRatingManager");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(orderStateManager, "orderStateManager");
        Intrinsics.f(driverManager, "driverManager");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(urlLauncher, "urlLauncher");
        Intrinsics.f(deepLinkParser, "deepLinkParser");
        Intrinsics.f(homePromoDialogInteractor, "homePromoDialogInteractor");
        Intrinsics.f(warningInteractor, "warningInteractor");
        Intrinsics.f(dashboardService, "dashboardService");
        Intrinsics.f(backendModalDialogActionReporterInteractor, "backendModalDialogActionReporterInteractor");
        Intrinsics.f(destinationAnalytics, "destinationAnalytics");
        Intrinsics.f(driverStateChangeFailInteractor, "driverStateChangeFailInteractor");
        Intrinsics.f(trainingClient, "trainingClient");
        Intrinsics.f(driverTrainingRestrictionManager, "driverTrainingRestrictionManager");
        Intrinsics.f(settingsAnalytics, "settingsAnalytics");
        Intrinsics.f(networkUsageUploadInteractor, "networkUsageUploadInteractor");
        Intrinsics.f(dispatchSettingsManager, "dispatchSettingsManager");
        this.f29791f = driverStateInteractor;
        this.f29792g = onlineCheckInteractor;
        this.f29793h = makeDriverInactiveInteractor;
        this.f29794i = pushDataService;
        this.f29795j = appRatingManager;
        this.f29796k = orderProvider;
        this.f29797l = orderStateManager;
        this.f29798m = driverManager;
        this.f29799n = driverProvider;
        this.f29800o = urlLauncher;
        this.f29801p = deepLinkParser;
        this.f29802q = homePromoDialogInteractor;
        this.f29803r = warningInteractor;
        this.f29804s = dashboardService;
        this.f29805t = backendModalDialogActionReporterInteractor;
        this.f29806u = destinationAnalytics;
        this.f29807v = driverStateChangeFailInteractor;
        this.f29808w = trainingClient;
        this.f29809x = driverTrainingRestrictionManager;
        this.f29810y = settingsAnalytics;
        this.f29811z = networkUsageUploadInteractor;
        this.A = dispatchSettingsManager;
        this.B = new MutableLiveData<>();
        this.D = new MutableLiveData<>();
        this.F = new MutableLiveData<>();
        this.H = new LiveEvent<>();
        this.J = new LiveEvent<>();
        this.L = new LiveEvent<>();
        this.N = new LiveEvent<>();
        this.Q = new ObservableLiveData<>();
        this.R = new LiveEvent<>();
        this.T = new LiveEvent<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(HomeViewModel this$0, Object obj) {
        Intrinsics.f(this$0, "this$0");
        this$0.D.o(Unit.f50853a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource X0(HomeViewModel this$0, Object it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        return this$0.f29808w.h().K(Schedulers.c()).A(Single.y());
    }

    private final void Z0() {
        Single d8 = SingleExtKt.d(this.f29808w.f());
        final Function1<Training, Unit> function1 = new Function1<Training, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$onTrainingRequested$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Training it) {
                HomeViewModel homeViewModel = HomeViewModel.this;
                Intrinsics.e(it, "it");
                homeViewModel.x0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Training training) {
                b(training);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.h0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.a1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$onTrainingRequested$2
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
                HomeViewModel homeViewModel = HomeViewModel.this;
                Intrinsics.e(it, "it");
                homeViewModel.w0(it, TrainingRetryAction.RequestStart.f29927a);
            }
        };
        Disposable I = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.i0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.b1(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "private fun onTrainingRe…     .autoDispose()\n    }");
        v(I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1(DriverStateChangeFailInteractor.UpdateCarRequired updateCarRequired) {
        this.H.m(new CarUnavailableDialog(this.f29799n.o().l(), updateCarRequired.a()));
    }

    private final void i1() {
        this.f29799n.g().U(false);
        this.L.o(new TrainingEvent.ShowTrainingConfirmation(null));
        q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1() {
        Disposable disposable = this.U;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single d8 = SingleExtKt.d(this.A.r());
        final HomeViewModel$showOnlineSettings$1 homeViewModel$showOnlineSettings$1 = new Function1<Optional<SettingsResponse>, String>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$showOnlineSettings$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(Optional<SettingsResponse> it) {
                String str;
                Intrinsics.f(it, "it");
                SettingsResponse c8 = it.c();
                if (c8 != null) {
                    str = c8.c();
                } else {
                    str = null;
                }
                if (str == null) {
                    return "";
                }
                return str;
            }
        };
        Single x7 = d8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.home.v3.z
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String k12;
                k12 = HomeViewModel.k1(Function1.this, obj);
                return k12;
            }
        });
        final HomeViewModel$showOnlineSettings$2 homeViewModel$showOnlineSettings$2 = new Function1<String, Boolean>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$showOnlineSettings$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(String it) {
                boolean y7;
                Intrinsics.f(it, "it");
                y7 = StringsKt__StringsJVMKt.y(it);
                return Boolean.valueOf(!y7);
            }
        };
        Maybe q8 = x7.q(new Predicate() { // from class: ee.mtakso.driver.ui.screens.home.v3.a0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean l12;
                l12 = HomeViewModel.l1(Function1.this, obj);
                return l12;
            }
        });
        final HomeViewModel$showOnlineSettings$3 homeViewModel$showOnlineSettings$3 = new HomeViewModel$showOnlineSettings$3(this.T);
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.b0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.m1(Function1.this, obj);
            }
        };
        final HomeViewModel$showOnlineSettings$4 homeViewModel$showOnlineSettings$4 = new HomeViewModel$showOnlineSettings$4(this);
        this.U = q8.g(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.c0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.n1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String k1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void o1(List<String> list) {
        this.L.o(new TrainingEvent.ShowStoriesTraining(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(HomeViewModel this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.c1();
    }

    private final void s0() {
        Single d8 = SingleExtKt.d(this.f29808w.d());
        final Function1<TrainingModal, Unit> function1 = new Function1<TrainingModal, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$completeStoriesTraining$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(TrainingModal trainingModal) {
                DriverProvider driverProvider;
                LiveEvent liveEvent;
                driverProvider = HomeViewModel.this.f29799n;
                driverProvider.g().U(false);
                liveEvent = HomeViewModel.this.L;
                liveEvent.o(new TrainingEvent.ShowTrainingConfirmation(trainingModal.b()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TrainingModal trainingModal) {
                b(trainingModal);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.t0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$completeStoriesTraining$2
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
                HomeViewModel homeViewModel = HomeViewModel.this;
                Intrinsics.e(it, "it");
                homeViewModel.w0(it, TrainingRetryAction.ConfirmFinishStories.f29925a);
            }
        };
        Disposable I = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.w
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.u0(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "private fun completeStor…     .autoDispose()\n    }");
        v(I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(Throwable th, TrainingRetryAction trainingRetryAction) {
        ApiException apiException;
        LiveEvent<TrainingEvent> liveEvent = this.L;
        String str = null;
        if (th instanceof ApiException) {
            apiException = (ApiException) th;
        } else {
            apiException = null;
        }
        if (apiException != null) {
            str = apiException.e();
        }
        liveEvent.o(new TrainingEvent.ShowStoriesError(str, trainingRetryAction));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(Training training) {
        Integer num;
        List<String> a8 = training.a();
        if (a8 != null) {
            num = Integer.valueOf(a8.size());
        } else {
            num = null;
        }
        boolean z7 = true;
        if (num != null && num.intValue() != 0) {
            z7 = false;
        }
        if (z7) {
            i1();
        } else {
            o1(training.a());
        }
    }

    public final LiveData<DriverStatus> A0() {
        return this.B;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f29810y.n4(this.f29799n.t().f().a());
        Observable<DriverStatus> a8 = this.f29791f.a();
        final Function1<DriverStatus, Unit> function1 = new Function1<DriverStatus, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverStatus it) {
                MutableLiveData mutableLiveData;
                AppRatingManager appRatingManager;
                FastLog g8 = Kalev.f41674e.g();
                if (g8 != null) {
                    FastLog.DefaultImpls.a(g8, "New driver state: " + it, null, 2, null);
                }
                Intrinsics.e(it, "it");
                if (DriverStatusKt.a(it) && it != DriverStatus.UNDEFINED) {
                    appRatingManager = HomeViewModel.this.f29795j;
                    appRatingManager.j();
                }
                if (it == DriverStatus.WAITING_ORDER) {
                    HomeViewModel.this.j1();
                }
                mutableLiveData = HomeViewModel.this.B;
                mutableLiveData.o(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverStatus driverStatus) {
                b(driverStatus);
                return Unit.f50853a;
            }
        };
        this.C = a8.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.N0(Function1.this, obj);
            }
        });
        this.E = this.f29792g.b().observeOn(AndroidSchedulers.a()).subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.O0(HomeViewModel.this, obj);
            }
        });
        this.f29794i.e();
        Observable g8 = ObservableExtKt.g(this.f29795j.i());
        final Function1<RateMeModel, Unit> function12 = new Function1<RateMeModel, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$onStart$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(RateMeModel rateMeModel) {
                MutableLiveData mutableLiveData;
                mutableLiveData = HomeViewModel.this.F;
                mutableLiveData.o(rateMeModel);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RateMeModel rateMeModel) {
                b(rateMeModel);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.R0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$onStart$4
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
                HomeViewModel homeViewModel = HomeViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(homeViewModel, it, null, 2, null);
            }
        };
        this.G = g8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.S0(Function1.this, obj);
            }
        });
        Single<OrderDetails> z7 = OrderProviderUtils.z(this.f29796k, OrderState.ORDER_STATE_DRIVER_DID_NOT_RESPOND, OrderState.ORDER_STATE_CLIENT_CANCELLED, OrderState.ORDER_STATE_DRIVER_REJECTED, OrderState.ORDER_STATE_CLIENT_DID_NOT_SHOW, OrderState.ORDER_STATE_PAYMENT_BOOKING_FAILED, OrderState.ORDER_STATE_FINISHED).z(AndroidSchedulers.a());
        final Function1<OrderDetails, Unit> function14 = new Function1<OrderDetails, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$onStart$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OrderDetails orderDetails) {
                LiveEvent liveEvent;
                liveEvent = HomeViewModel.this.N;
                liveEvent.o(orderDetails);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OrderDetails orderDetails) {
                b(orderDetails);
                return Unit.f50853a;
            }
        };
        Consumer<? super OrderDetails> consumer2 = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.T0(Function1.this, obj);
            }
        };
        final HomeViewModel$onStart$6 homeViewModel$onStart$6 = new HomeViewModel$onStart$6(this);
        this.O = z7.I(consumer2, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.t
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.U0(Function1.this, obj);
            }
        });
        Observable<DriverStateChangeFailInteractor.UpdateCarRequired> d8 = this.f29807v.d();
        final HomeViewModel$onStart$7 homeViewModel$onStart$7 = new HomeViewModel$onStart$7(this);
        Consumer<? super DriverStateChangeFailInteractor.UpdateCarRequired> consumer3 = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.u
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.V0(Function1.this, obj);
            }
        };
        final HomeViewModel$onStart$8 homeViewModel$onStart$8 = new HomeViewModel$onStart$8(this);
        this.M = d8.subscribe(consumer3, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.v
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.W0(Function1.this, obj);
            }
        });
        ObservableLiveData.t(this.Q, this.f29803r.e(), null, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$onStart$9
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
                BaseViewModel.A(HomeViewModel.this, it, null, 2, null);
            }
        }, 2, null);
        Observable observeOn = this.f29809x.b().flatMapSingle(new Function() { // from class: ee.mtakso.driver.ui.screens.home.v3.x
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource X0;
                X0 = HomeViewModel.X0(HomeViewModel.this, obj);
                return X0;
            }
        }).observeOn(AndroidSchedulers.a());
        final Function1<TrainingModal, Unit> function15 = new Function1<TrainingModal, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$onStart$11
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(TrainingModal trainingModal) {
                LiveEvent liveEvent;
                ModalDialogResponse.Dialog.DialogPayload a9 = trainingModal.a();
                liveEvent = HomeViewModel.this.J;
                liveEvent.o(new PromoDialog.Training(a9));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TrainingModal trainingModal) {
                b(trainingModal);
                return Unit.f50853a;
            }
        };
        Consumer consumer4 = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.y
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.P0(Function1.this, obj);
            }
        };
        final HomeViewModel$onStart$12 homeViewModel$onStart$12 = new HomeViewModel$onStart$12(this);
        Disposable subscribe = observeOn.subscribe(consumer4, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.Q0(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun onStart() {…DailyNetworkUsage()\n    }");
        v(subscribe);
        this.f29811z.c();
    }

    public final LiveData<MakeDriverInactiveStatus> B0() {
        return this.R;
    }

    public final LiveData<Unit> C0() {
        return this.D;
    }

    public final LiveEvent<PromoDialog> D0() {
        return this.J;
    }

    public final LiveData<PushMessage> E0() {
        return this.f29794i.d();
    }

    public final LiveData<RateMeModel> F0() {
        return this.F;
    }

    public final LiveData<String> G0() {
        return this.T;
    }

    public final LiveData<OrderDetails> H0() {
        return this.N;
    }

    public final LiveEvent<TrainingEvent> I0() {
        return this.L;
    }

    public final LiveData<WarningMessage> J0() {
        return this.Q;
    }

    public final void K0(DynamicModalDialog.ActionModel model) {
        String str;
        Intrinsics.f(model, "model");
        BackendModalDialogActionReporterInteractor backendModalDialogActionReporterInteractor = this.f29805t;
        DynamicModalDialog.ModalInfo c8 = model.c();
        if (c8 != null) {
            str = c8.c();
        } else {
            str = null;
        }
        Completable a8 = CompletableExtKt.a(backendModalDialogActionReporterInteractor.a(str, model.a()));
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.home.v3.d0
            @Override // io.reactivex.functions.Action
            public final void run() {
                HomeViewModel.L0();
            }
        };
        final HomeViewModel$onDynamicDialogAction$2 homeViewModel$onDynamicDialogAction$2 = new HomeViewModel$onDynamicDialogAction$2(this);
        this.P = a8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.e0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.M0(Function1.this, obj);
            }
        });
        String b8 = model.b();
        if (b8 != null) {
            DeepLinkParser deepLinkParser = this.f29801p;
            Uri parse = Uri.parse(b8);
            Intrinsics.e(parse, "parse(it)");
            if (deepLinkParser.b(parse) instanceof DeeplinkCall.TrainingStart) {
                Z0();
            } else {
                this.f29800o.a(b8);
            }
        }
    }

    public final void Y0(TrainingRetryAction action) {
        Intrinsics.f(action, "action");
        if (Intrinsics.a(action, TrainingRetryAction.RequestStart.f29927a)) {
            Z0();
        } else if (Intrinsics.a(action, TrainingRetryAction.ConfirmFinishStories.f29925a)) {
            s0();
        } else if (Intrinsics.a(action, TrainingRetryAction.RefreshDashboard.f29926a)) {
            q1();
        } else if (action instanceof TrainingRetryAction.ShowConfirmFinishStories) {
            this.J.o(new PromoDialog.Training(((TrainingRetryAction.ShowConfirmFinishStories) action).a()));
        }
    }

    public final void c1() {
        this.f29804s.g();
    }

    public final void d1(boolean z7) {
        Disposable disposable = this.S;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single d8 = SingleExtKt.d(this.f29793h.i(z7));
        final Function1<MakeDriverInactiveStatus, Unit> function1 = new Function1<MakeDriverInactiveStatus, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$setDriverInactive$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MakeDriverInactiveStatus makeDriverInactiveStatus) {
                LiveEvent liveEvent;
                liveEvent = HomeViewModel.this.R;
                liveEvent.o(makeDriverInactiveStatus);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MakeDriverInactiveStatus makeDriverInactiveStatus) {
                b(makeDriverInactiveStatus);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.k0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.e1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$setDriverInactive$2
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
                HomeViewModel homeViewModel = HomeViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(homeViewModel, it, null, 2, null);
            }
        };
        this.S = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.f1(Function1.this, obj);
            }
        });
    }

    public final void g1() {
        DriverManager.o(this.f29798m, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.C;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.E;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
        Disposable disposable3 = this.K;
        if (disposable3 != null) {
            DisposableExtKt.a(disposable3);
        }
        Disposable disposable4 = this.G;
        if (disposable4 != null) {
            DisposableExtKt.a(disposable4);
        }
        Disposable disposable5 = this.I;
        if (disposable5 != null) {
            DisposableExtKt.a(disposable5);
        }
        Disposable disposable6 = this.M;
        if (disposable6 != null) {
            DisposableExtKt.a(disposable6);
        }
        Disposable disposable7 = this.O;
        if (disposable7 != null) {
            DisposableExtKt.a(disposable7);
        }
        Disposable disposable8 = this.S;
        if (disposable8 != null) {
            DisposableExtKt.a(disposable8);
        }
        Disposable disposable9 = this.U;
        if (disposable9 != null) {
            DisposableExtKt.a(disposable9);
        }
    }

    public final void p0(PromoDialogEvent event) {
        Intrinsics.f(event, "event");
        if (this.K != null) {
            return;
        }
        Single d8 = SingleExtKt.d(this.f29802q.r(event));
        final Function1<Optional<PromoDialog>, Unit> function1 = new Function1<Optional<PromoDialog>, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeViewModel$checkDialogs$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<PromoDialog> optional) {
                LiveEvent liveEvent;
                Kalev.b("got modal dialog: " + optional);
                PromoDialog c8 = optional.c();
                if (c8 != null) {
                    liveEvent = HomeViewModel.this.J;
                    liveEvent.o(c8);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<PromoDialog> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.f0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.q0(Function1.this, obj);
            }
        };
        final HomeViewModel$checkDialogs$2 homeViewModel$checkDialogs$2 = new HomeViewModel$checkDialogs$2(this);
        this.K = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.home.v3.g0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeViewModel.r0(Function1.this, obj);
            }
        });
    }

    public final void p1() {
        this.f29806u.E1();
    }

    public final void q1() {
        Disposable F = Completable.g().k(3L, TimeUnit.SECONDS).F(new Action() { // from class: ee.mtakso.driver.ui.screens.home.v3.j0
            @Override // io.reactivex.functions.Action
            public final void run() {
                HomeViewModel.r1(HomeViewModel.this);
            }
        });
        Intrinsics.e(F, "complete()\n            .…ardUpdate()\n            }");
        v(F);
    }

    public final void v0() {
        if (!this.f29799n.t().J().a()) {
            return;
        }
        this.f29799n.t().J().b(false);
        this.f29810y.n4(true);
        this.f29799n.t().f().b(true);
    }

    public final void y0(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f29797l.v0(orderHandle);
    }

    public final LiveEvent<CarUnavailableDialog> z0() {
        return this.H;
    }
}
