package ee.mtakso.driver.ui.screens.work;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.campaign.ActiveAndFutureCampaigns;
import ee.mtakso.driver.network.client.campaign.CampaignClient;
import ee.mtakso.driver.network.client.campaign.CircleKClient;
import ee.mtakso.driver.network.client.campaign.CircleKLoyaltySignUpMagicLink;
import ee.mtakso.driver.network.client.dashboard.DriverHomeScreenResponse;
import ee.mtakso.driver.network.client.driver.Car;
import ee.mtakso.driver.network.client.driver.Cars;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.network.client.driver.PricingData;
import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import ee.mtakso.driver.network.client.order.DriverStatisticsSummary;
import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.network.client.settings.DriverPricing;
import ee.mtakso.driver.network.client.work_time.WorkingTimeInfo;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.service.WorkDistanceDelegate;
import ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DestinationAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.HeatmapAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PermissionAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.service.analytics.event.wrapper.AttributedAnalyticsDelegate;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.service.campaign.CampaignManager;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.state.GeoLocationIssue;
import ee.mtakso.driver.service.geo.storage.LocationStorageCleaner;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.fifo.FifoQueueDetails;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import ee.mtakso.driver.service.modules.status.GoOnlineIssue;
import ee.mtakso.driver.service.settings.CategorySelectionAutoAcceptanceState;
import ee.mtakso.driver.service.settings.CategorySelectionSignal;
import ee.mtakso.driver.service.settings.CategorySelectionState;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.service.workingtime.WorkingTimeManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.LiveDataNotification;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.interactor.dashboard.GetDashboardInteractor;
import ee.mtakso.driver.ui.interactor.driver.WorkRadius;
import ee.mtakso.driver.ui.interactor.driver.WorkRadiusInteractor;
import ee.mtakso.driver.ui.interactor.map.GetHeatmapStatusInteractor;
import ee.mtakso.driver.ui.interactor.map.HeatmapStatus;
import ee.mtakso.driver.ui.interactor.modaldialog.BackendModalDialogActionReporterInteractor;
import ee.mtakso.driver.ui.interactor.modaldialog.FifoModal;
import ee.mtakso.driver.ui.interactor.modaldialog.FifoModalInteractor;
import ee.mtakso.driver.ui.interactor.modaldialog.PromoDialogEvent;
import ee.mtakso.driver.ui.interactor.modaldialog.SingleModalDialogInteractor;
import ee.mtakso.driver.ui.interactor.promodialog.PromoDialog;
import ee.mtakso.driver.ui.interactor.score.DriverScoreItem;
import ee.mtakso.driver.ui.interactor.score.DriverScoreManager;
import ee.mtakso.driver.ui.screens.dialogs.DynamicModalDialog;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.modal.ModalAction;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpType;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyTooltipState;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyFABButtonType;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyUIUtils;
import ee.mtakso.driver.ui.screens.work.dashboard.DashboardState;
import ee.mtakso.driver.ui.screens.work.fifo.FifoQueueStateMapper;
import ee.mtakso.driver.utils.CompletableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.android.audio_recording_engine.engine.RecorderState;
import eu.bolt.driver.earnings.network.DriverButtonAction;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: WorkViewModel.kt */
/* loaded from: classes5.dex */
public final class WorkViewModel extends BaseViewModel {
    private final DriverStatusProvider A;
    private final LocationStorageCleaner B;
    private final OptInCampaignAnalytics C;
    private final HeatmapAnalytics D;
    private final DispatchSettingsManager E;
    private final DriverDestinationsManager F;
    private final ReferralCampaignsAnalytics G;
    private final SafetyToolkitAnalytics H;
    private final SingleModalDialogInteractor I;
    private final FifoModalInteractor J;
    private final AttributedAnalyticsDelegate K;
    private final BackendModalDialogActionReporterInteractor L;
    private final FifoQueueManager M;
    private final FifoQueueStateMapper N;
    private final DeeplinkDelegate O;
    private final DestinationAnalytics P;
    private final DidYouGetHelpInteractor Q;
    private final EmergencyAssistInteractor R;
    private final WorkRadiusInteractor S;
    private final AudioRecordingManager T;
    private final GetHeatmapStatusInteractor U;
    private final PermissionAnalytics V;
    private final MutableLiveData<DashboardState> W;
    private final LiveEvent<LiveDataNotification<String>> X;
    private final LiveEvent<PromoDialog> Y;
    private final LiveEvent<Unit> Z;

    /* renamed from: a0  reason: collision with root package name */
    private final LiveEvent<Unit> f33802a0;

    /* renamed from: b0  reason: collision with root package name */
    private final LiveEvent<SafetyTooltipState> f33803b0;

    /* renamed from: c0  reason: collision with root package name */
    private final LiveEvent<Boolean> f33804c0;

    /* renamed from: d0  reason: collision with root package name */
    private final LiveEvent<GoOnlineIssue> f33805d0;

    /* renamed from: e0  reason: collision with root package name */
    private final LiveEvent<GeoLocationIssue> f33806e0;

    /* renamed from: f  reason: collision with root package name */
    private final DriverClient f33807f;

    /* renamed from: f0  reason: collision with root package name */
    private final ObservableLiveData<Optional<DriverDestination>> f33808f0;

    /* renamed from: g  reason: collision with root package name */
    private final OrderTracker f33809g;

    /* renamed from: g0  reason: collision with root package name */
    private final ObservableLiveData<Optional<DriverPricing>> f33810g0;

    /* renamed from: h  reason: collision with root package name */
    private final CircleKClient f33811h;

    /* renamed from: h0  reason: collision with root package name */
    private final LiveEvent<String> f33812h0;

    /* renamed from: i  reason: collision with root package name */
    private final DriverManager f33813i;

    /* renamed from: i0  reason: collision with root package name */
    private final MutableLiveData<DriverStatus> f33814i0;

    /* renamed from: j  reason: collision with root package name */
    private final DriverProvider f33815j;

    /* renamed from: j0  reason: collision with root package name */
    private final LiveEvent<Unit> f33816j0;

    /* renamed from: k  reason: collision with root package name */
    private final DriverSettings f33817k;

    /* renamed from: k0  reason: collision with root package name */
    private final LiveEvent<Unit> f33818k0;

    /* renamed from: l  reason: collision with root package name */
    private final CampaignClient f33819l;

    /* renamed from: l0  reason: collision with root package name */
    private final MutableLiveData<CategorySelectionAutoAcceptanceState> f33820l0;

    /* renamed from: m  reason: collision with root package name */
    private final LoginAnalytics f33821m;

    /* renamed from: m0  reason: collision with root package name */
    private final MutableLiveData<Optional<WorkingTimeInfo>> f33822m0;

    /* renamed from: n  reason: collision with root package name */
    private final StartUpTracing f33823n;

    /* renamed from: n0  reason: collision with root package name */
    private final MutableLiveData<DidYouGetHelpType> f33824n0;

    /* renamed from: o  reason: collision with root package name */
    private final CampaignManager f33825o;

    /* renamed from: o0  reason: collision with root package name */
    private final MutableLiveData<SafetyFABButtonType> f33826o0;

    /* renamed from: p  reason: collision with root package name */
    private final GetDashboardInteractor f33827p;

    /* renamed from: p0  reason: collision with root package name */
    private final ObservableLiveData<WorkRadius> f33828p0;

    /* renamed from: q  reason: collision with root package name */
    private final DashboardMapper f33829q;

    /* renamed from: q0  reason: collision with root package name */
    private final MutableLiveData<FifoModal> f33830q0;

    /* renamed from: r  reason: collision with root package name */
    private final CampaignAnalytics f33831r;

    /* renamed from: r0  reason: collision with root package name */
    private final ObservableLiveData<HeatmapStatus> f33832r0;

    /* renamed from: s  reason: collision with root package name */
    private final SettingsAnalytics f33833s;

    /* renamed from: t  reason: collision with root package name */
    private final DriverScoreManager f33834t;

    /* renamed from: u  reason: collision with root package name */
    private final DriverStatusSender f33835u;

    /* renamed from: v  reason: collision with root package name */
    private final GeoLocationManager f33836v;

    /* renamed from: w  reason: collision with root package name */
    private final RateMePrefsManager f33837w;

    /* renamed from: x  reason: collision with root package name */
    private final WorkingTimeManager f33838x;

    /* renamed from: y  reason: collision with root package name */
    private final WorkDistanceDelegate f33839y;

    /* renamed from: z  reason: collision with root package name */
    private final DriverScoreAnalytics f33840z;

    @Inject
    public WorkViewModel(DriverClient driverClient, OrderTracker orderTracker, CircleKClient circleKClient, DriverManager driverManager, DriverProvider driverProvider, DriverSettings driverSettings, CampaignClient campaignClient, LoginAnalytics loginAnalytics, StartUpTracing startUpTracing, CampaignManager campaignManager, GetDashboardInteractor getDashboardInteractor, DashboardMapper dashboardMapper, CampaignAnalytics campaignAnalytics, SettingsAnalytics settingsAnalytics, DriverScoreManager driverScoreManager, DriverStatusSender driverStatusSender, GeoLocationManager geoLocationManager, RateMePrefsManager rateMePrefsManager, WorkingTimeManager workingTimeManager, WorkDistanceDelegate workDistanceDelegate, DriverScoreAnalytics driverScoreAnalytics, DriverStatusProvider driverStatusProvider, LocationStorageCleaner locationStorageCleaner, OptInCampaignAnalytics optInCampaignAnalytics, HeatmapAnalytics heatmapAnalytics, DispatchSettingsManager dispatchSettingsManager, DriverDestinationsManager driverDestinationsManager, ReferralCampaignsAnalytics referralCampaignsAnalytics, SafetyToolkitAnalytics safetyToolkitAnalytics, SingleModalDialogInteractor singleModalDialogInteractor, FifoModalInteractor fifoModalInteractor, AttributedAnalyticsDelegate attributedAnalyticsDelegate, BackendModalDialogActionReporterInteractor backendModalDialogActionReporterInteractor, FifoQueueManager fifoQueueManager, FifoQueueStateMapper fifoMapper, DeeplinkDelegate deeplinkDelegate, DestinationAnalytics destinationAnalytics, DidYouGetHelpInteractor didYouGetHelpInteractor, EmergencyAssistInteractor emergencyAssistInteractor, WorkRadiusInteractor workRadiusInteractor, AudioRecordingManager audioRecordingManager, GetHeatmapStatusInteractor getHeatmapStatusInteractor, PermissionAnalytics permissionAnalytics) {
        Intrinsics.f(driverClient, "driverClient");
        Intrinsics.f(orderTracker, "orderTracker");
        Intrinsics.f(circleKClient, "circleKClient");
        Intrinsics.f(driverManager, "driverManager");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(driverSettings, "driverSettings");
        Intrinsics.f(campaignClient, "campaignClient");
        Intrinsics.f(loginAnalytics, "loginAnalytics");
        Intrinsics.f(startUpTracing, "startUpTracing");
        Intrinsics.f(campaignManager, "campaignManager");
        Intrinsics.f(getDashboardInteractor, "getDashboardInteractor");
        Intrinsics.f(dashboardMapper, "dashboardMapper");
        Intrinsics.f(campaignAnalytics, "campaignAnalytics");
        Intrinsics.f(settingsAnalytics, "settingsAnalytics");
        Intrinsics.f(driverScoreManager, "driverScoreManager");
        Intrinsics.f(driverStatusSender, "driverStatusSender");
        Intrinsics.f(geoLocationManager, "geoLocationManager");
        Intrinsics.f(rateMePrefsManager, "rateMePrefsManager");
        Intrinsics.f(workingTimeManager, "workingTimeManager");
        Intrinsics.f(workDistanceDelegate, "workDistanceDelegate");
        Intrinsics.f(driverScoreAnalytics, "driverScoreAnalytics");
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        Intrinsics.f(locationStorageCleaner, "locationStorageCleaner");
        Intrinsics.f(optInCampaignAnalytics, "optInCampaignAnalytics");
        Intrinsics.f(heatmapAnalytics, "heatmapAnalytics");
        Intrinsics.f(dispatchSettingsManager, "dispatchSettingsManager");
        Intrinsics.f(driverDestinationsManager, "driverDestinationsManager");
        Intrinsics.f(referralCampaignsAnalytics, "referralCampaignsAnalytics");
        Intrinsics.f(safetyToolkitAnalytics, "safetyToolkitAnalytics");
        Intrinsics.f(singleModalDialogInteractor, "singleModalDialogInteractor");
        Intrinsics.f(fifoModalInteractor, "fifoModalInteractor");
        Intrinsics.f(attributedAnalyticsDelegate, "attributedAnalyticsDelegate");
        Intrinsics.f(backendModalDialogActionReporterInteractor, "backendModalDialogActionReporterInteractor");
        Intrinsics.f(fifoQueueManager, "fifoQueueManager");
        Intrinsics.f(fifoMapper, "fifoMapper");
        Intrinsics.f(deeplinkDelegate, "deeplinkDelegate");
        Intrinsics.f(destinationAnalytics, "destinationAnalytics");
        Intrinsics.f(didYouGetHelpInteractor, "didYouGetHelpInteractor");
        Intrinsics.f(emergencyAssistInteractor, "emergencyAssistInteractor");
        Intrinsics.f(workRadiusInteractor, "workRadiusInteractor");
        Intrinsics.f(audioRecordingManager, "audioRecordingManager");
        Intrinsics.f(getHeatmapStatusInteractor, "getHeatmapStatusInteractor");
        Intrinsics.f(permissionAnalytics, "permissionAnalytics");
        this.f33807f = driverClient;
        this.f33809g = orderTracker;
        this.f33811h = circleKClient;
        this.f33813i = driverManager;
        this.f33815j = driverProvider;
        this.f33817k = driverSettings;
        this.f33819l = campaignClient;
        this.f33821m = loginAnalytics;
        this.f33823n = startUpTracing;
        this.f33825o = campaignManager;
        this.f33827p = getDashboardInteractor;
        this.f33829q = dashboardMapper;
        this.f33831r = campaignAnalytics;
        this.f33833s = settingsAnalytics;
        this.f33834t = driverScoreManager;
        this.f33835u = driverStatusSender;
        this.f33836v = geoLocationManager;
        this.f33837w = rateMePrefsManager;
        this.f33838x = workingTimeManager;
        this.f33839y = workDistanceDelegate;
        this.f33840z = driverScoreAnalytics;
        this.A = driverStatusProvider;
        this.B = locationStorageCleaner;
        this.C = optInCampaignAnalytics;
        this.D = heatmapAnalytics;
        this.E = dispatchSettingsManager;
        this.F = driverDestinationsManager;
        this.G = referralCampaignsAnalytics;
        this.H = safetyToolkitAnalytics;
        this.I = singleModalDialogInteractor;
        this.J = fifoModalInteractor;
        this.K = attributedAnalyticsDelegate;
        this.L = backendModalDialogActionReporterInteractor;
        this.M = fifoQueueManager;
        this.N = fifoMapper;
        this.O = deeplinkDelegate;
        this.P = destinationAnalytics;
        this.Q = didYouGetHelpInteractor;
        this.R = emergencyAssistInteractor;
        this.S = workRadiusInteractor;
        this.T = audioRecordingManager;
        this.U = getHeatmapStatusInteractor;
        this.V = permissionAnalytics;
        this.W = new MutableLiveData<>(DashboardState.Loading.f33943a);
        this.X = new LiveEvent<>();
        this.Y = new LiveEvent<>();
        this.Z = new LiveEvent<>();
        this.f33802a0 = new LiveEvent<>();
        this.f33803b0 = new LiveEvent<>();
        this.f33804c0 = new LiveEvent<>();
        this.f33805d0 = new LiveEvent<>();
        this.f33806e0 = new LiveEvent<>();
        this.f33808f0 = new ObservableLiveData<>();
        this.f33810g0 = new ObservableLiveData<>();
        this.f33812h0 = new LiveEvent<>();
        this.f33814i0 = new MutableLiveData<>(DriverStatus.UNDEFINED);
        this.f33816j0 = new LiveEvent<>();
        this.f33818k0 = new LiveEvent<>();
        this.f33820l0 = new MutableLiveData<>();
        this.f33822m0 = new MutableLiveData<>();
        this.f33824n0 = new MutableLiveData<>();
        this.f33826o0 = new MutableLiveData<>();
        this.f33828p0 = new ObservableLiveData<>();
        this.f33830q0 = new MutableLiveData<>();
        this.f33832r0 = new ObservableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource A1(WorkViewModel this$0) {
        Intrinsics.f(this$0, "this$0");
        if (this$0.s1()) {
            return this$0.G1();
        }
        return this$0.E1();
    }

    private final void A2() {
        Observable<Optional<WorkingTimeInfo>> g8 = this.f33838x.g();
        final Function1<Optional<WorkingTimeInfo>, Unit> function1 = new Function1<Optional<WorkingTimeInfo>, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observerWorkTime$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<WorkingTimeInfo> optional) {
                MutableLiveData mutableLiveData;
                mutableLiveData = WorkViewModel.this.f33822m0;
                mutableLiveData.o(optional);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<WorkingTimeInfo> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer<? super Optional<WorkingTimeInfo>> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.d2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.B2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observerWorkTime$2
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
                MutableLiveData mutableLiveData;
                mutableLiveData = WorkViewModel.this.f33822m0;
                mutableLiveData.o(Optional.a());
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = g8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.e2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.C2(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observerWork…     .autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DashboardState B1(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DashboardState) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Observable<DashboardState.Static> E1() {
        Single<DriverStatisticsSummary> q8 = this.f33819l.q();
        Single<ActiveAndFutureCampaigns> t7 = this.f33825o.t();
        Single<Optional<DriverScoreItem>> j8 = this.f33834t.j(true);
        final Function3<DriverStatisticsSummary, ActiveAndFutureCampaigns, Optional<DriverScoreItem>, DashboardState.Static> function3 = new Function3<DriverStatisticsSummary, ActiveAndFutureCampaigns, Optional<DriverScoreItem>, DashboardState.Static>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$loadDashboardV1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            /* renamed from: b */
            public final DashboardState.Static l(DriverStatisticsSummary stats, ActiveAndFutureCampaigns campaigns, Optional<DriverScoreItem> optionalScore) {
                DriverProvider driverProvider;
                Intrinsics.f(stats, "stats");
                Intrinsics.f(campaigns, "campaigns");
                Intrinsics.f(optionalScore, "optionalScore");
                driverProvider = WorkViewModel.this.f33815j;
                return new DashboardState.Static(campaigns, driverProvider.n().f(), stats, WorkViewModel.this.u1(), optionalScore.c());
            }
        };
        Single U = Single.U(q8, t7, j8, new io.reactivex.functions.Function3() { // from class: ee.mtakso.driver.ui.screens.work.m2
            @Override // io.reactivex.functions.Function3
            public final Object a(Object obj, Object obj2, Object obj3) {
                DashboardState.Static F1;
                F1 = WorkViewModel.F1(Function3.this, obj, obj2, obj3);
                return F1;
            }
        });
        Intrinsics.e(U, "private fun loadDashboar…    .toObservable()\n    }");
        Observable<DashboardState.Static> R = SingleExtKt.d(U).R();
        Intrinsics.e(R, "private fun loadDashboar…    .toObservable()\n    }");
        return R;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DashboardState.Static F1(Function3 tmp0, Object obj, Object obj2, Object obj3) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DashboardState.Static) tmp0.l(obj, obj2, obj3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Observable<DashboardState.Dynamic> G1() {
        Observable<DriverHomeScreenResponse> d8 = this.f33827p.d();
        final Function1<DriverHomeScreenResponse, DashboardState.Dynamic> function1 = new Function1<DriverHomeScreenResponse, DashboardState.Dynamic>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$loadDashboardV2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DashboardState.Dynamic invoke(DriverHomeScreenResponse it) {
                DashboardMapper dashboardMapper;
                Intrinsics.f(it, "it");
                dashboardMapper = WorkViewModel.this.f33829q;
                return dashboardMapper.d(it);
            }
        };
        Observable map = d8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.work.l2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DashboardState.Dynamic H1;
                H1 = WorkViewModel.H1(Function1.this, obj);
                return H1;
            }
        });
        Intrinsics.e(map, "private fun loadDashboar….mapDashboard(it) }\n    }");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DashboardState.Dynamic H1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DashboardState.Dynamic) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N2() {
        Kalev.b("modal action reported");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void P1() {
        Observable<CategorySelectionAutoAcceptanceState> observeOn = this.E.v().observeOn(AndroidSchedulers.a());
        final Function1<CategorySelectionAutoAcceptanceState, Unit> function1 = new Function1<CategorySelectionAutoAcceptanceState, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeCategorySelectionAvailability$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(CategorySelectionAutoAcceptanceState categorySelectionAutoAcceptanceState) {
                MutableLiveData mutableLiveData;
                DispatchSettingsManager dispatchSettingsManager;
                if (categorySelectionAutoAcceptanceState.b() == CategorySelectionState.PROMOTED) {
                    dispatchSettingsManager = WorkViewModel.this.E;
                    dispatchSettingsManager.A();
                }
                mutableLiveData = WorkViewModel.this.f33820l0;
                mutableLiveData.o(categorySelectionAutoAcceptanceState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CategorySelectionAutoAcceptanceState categorySelectionAutoAcceptanceState) {
                b(categorySelectionAutoAcceptanceState);
                return Unit.f50853a;
            }
        };
        Consumer<? super CategorySelectionAutoAcceptanceState> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.s2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.Q1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeCategorySelectionAvailability$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.d3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.R1(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeCateg…     .autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void S1() {
        Observable<String> w7 = this.E.w();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeCategorySelectionMessage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                MutableLiveData mutableLiveData;
                LiveEvent liveEvent;
                mutableLiveData = WorkViewModel.this.f33814i0;
                Object b8 = LiveDataExtKt.b(mutableLiveData);
                Intrinsics.e(b8, "driverState.requireValue()");
                if (DriverStatusKt.b((DriverStatus) b8)) {
                    liveEvent = WorkViewModel.this.f33812h0;
                    liveEvent.o(str);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer<? super String> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.b2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.T1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeCategorySelectionMessage$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = w7.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.c2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.U1(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeCateg…     .autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void T2(String str, String str2) {
        Completable a8 = CompletableExtKt.a(this.L.a(str, str2));
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.work.n2
            @Override // io.reactivex.functions.Action
            public final void run() {
                WorkViewModel.U2();
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$reportModalAction$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable G = a8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.o2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.V2(Function1.this, obj);
            }
        });
        Intrinsics.e(G, "private fun reportModalA…     .autoDispose()\n    }");
        v(G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2() {
        Kalev.b("modal action reported");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void W1() {
        ObservableLiveData.t(this.f33808f0, this.F.F(), null, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeCurrentDriverDestination$1
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
                BaseViewModel.A(WorkViewModel.this, it, null, 2, null);
            }
        }, 2, null);
        v(this.f33808f0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W2(long j8) {
        Single d8 = SingleExtKt.d(this.f33807f.u(j8));
        final Function1<EmptyServerResponse, Unit> function1 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$selectCarAndGoOnline$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                WorkViewModel.this.p1();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.f3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.X2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$selectCarAndGoOnline$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable I = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.g3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.Y2(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "private fun selectCarAnd…     .autoDispose()\n    }");
        v(I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Y1() {
        PublishSubject<DidYouGetHelpType> a8 = this.Q.a();
        final Function1<DidYouGetHelpType, Unit> function1 = new Function1<DidYouGetHelpType, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeDidYouGetHelpSignal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DidYouGetHelpType didYouGetHelpType) {
                MutableLiveData mutableLiveData;
                mutableLiveData = WorkViewModel.this.f33824n0;
                mutableLiveData.o(didYouGetHelpType);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DidYouGetHelpType didYouGetHelpType) {
                b(didYouGetHelpType);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = a8.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.k2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.Z1(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeDidYo…    }.autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y2(Function1 tmp0, Object obj) {
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

    private final void Z2() {
        this.f33803b0.m(new SafetyTooltipState(this.f33817k.H().a(), this.f33817k.O().a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1() {
        if (this.f33815j.n().k() > 0) {
            p1();
            return;
        }
        Single d8 = SingleExtKt.d(this.f33807f.i());
        final Function1<Cars, Unit> function1 = new Function1<Cars, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$checkCars$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Cars cars) {
                LiveEvent liveEvent;
                Object W;
                LiveEvent liveEvent2;
                int size = cars.a().size();
                if (size == 0) {
                    liveEvent = WorkViewModel.this.Z;
                    liveEvent.o(Unit.f50853a);
                } else if (size != 1) {
                    liveEvent2 = WorkViewModel.this.f33802a0;
                    liveEvent2.o(Unit.f50853a);
                } else {
                    WorkViewModel workViewModel = WorkViewModel.this;
                    W = CollectionsKt___CollectionsKt.W(cars.a());
                    workViewModel.W2(((Car) W).a());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Cars cars) {
                b(cars);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.a3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.b1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$checkCars$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable I = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.b3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.c1(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "private fun checkCars() …Dispose()\n        }\n    }");
        v(I);
    }

    private final void a3() {
        this.f33804c0.m(Boolean.valueOf(this.f33817k.N().a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void b2() {
        Observable<DriverStatus> observeOn = this.A.g().observeOn(AndroidSchedulers.a());
        final Function1<DriverStatus, Unit> function1 = new Function1<DriverStatus, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeDriverState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverStatus driverState) {
                MutableLiveData y7;
                boolean z7;
                MutableLiveData mutableLiveData;
                WorkingTimeManager workingTimeManager;
                y7 = WorkViewModel.this.y();
                if (driverState == DriverStatus.PENDING) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                y7.o(Boolean.valueOf(z7));
                Intrinsics.e(driverState, "driverState");
                if (DriverStatusKt.a(driverState)) {
                    mutableLiveData = WorkViewModel.this.f33822m0;
                    workingTimeManager = WorkViewModel.this.f33838x;
                    mutableLiveData.o(workingTimeManager.e());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverStatus driverStatus) {
                b(driverStatus);
                return Unit.f50853a;
            }
        };
        Consumer<? super DriverStatus> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.x1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.c2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeDriverState$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.y1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.d2(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeDrive…     .autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void d1() {
        Single d8 = SingleExtKt.d(this.I.a(PromoDialogEvent.GO_ONLINE.c()));
        final Function1<Optional<ModalDialogResponse>, Unit> function1 = new Function1<Optional<ModalDialogResponse>, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$checkModals$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<ModalDialogResponse> optional) {
                PromoDialog banner;
                LiveEvent liveEvent;
                if (optional.d()) {
                    WorkViewModel.this.a1();
                    return;
                }
                ModalDialogResponse b8 = optional.b();
                Intrinsics.e(b8, "it.value");
                ModalDialogResponse modalDialogResponse = b8;
                if (modalDialogResponse instanceof ModalDialogResponse.Dialog) {
                    banner = new PromoDialog.Dynamic((ModalDialogResponse.Dialog) modalDialogResponse);
                } else if (modalDialogResponse instanceof ModalDialogResponse.Story) {
                    banner = new PromoDialog.Story((ModalDialogResponse.Story) modalDialogResponse);
                } else if (modalDialogResponse instanceof ModalDialogResponse.Banner) {
                    banner = new PromoDialog.Banner((ModalDialogResponse.Banner) modalDialogResponse);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                liveEvent = WorkViewModel.this.Y;
                liveEvent.o(banner);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<ModalDialogResponse> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.p2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.e1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$checkModals$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable I = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.q2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.f1(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "private fun checkModals(…     .autoDispose()\n    }");
        v(I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void e2() {
        Observable g8 = ObservableExtKt.g(this.J.f());
        final Function1<FifoModal, Unit> function1 = new Function1<FifoModal, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeFifoModal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(FifoModal fifoModal) {
                MutableLiveData mutableLiveData;
                mutableLiveData = WorkViewModel.this.f33830q0;
                mutableLiveData.o(fifoModal);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FifoModal fifoModal) {
                b(fifoModal);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.k3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.f2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeFifoModal$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = g8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.l3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.g2(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeFifoM…     .autoDispose()\n    }");
        v(subscribe);
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
    public static final void h1() {
        Kalev.b("pricing data sent");
    }

    private final void h2() {
        ObservableLiveData.t(this.f33832r0, this.U.f(), null, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeMapSettings$1
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
                BaseViewModel.A(WorkViewModel.this, it, null, 2, null);
            }
        }, 2, null);
        v(this.f33832r0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void i2() {
        Observable<CategorySelectionSignal> y7 = this.E.y();
        final Function1<CategorySelectionSignal, Unit> function1 = new Function1<CategorySelectionSignal, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeNoCategorySelectedSignal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(CategorySelectionSignal categorySelectionSignal) {
                MutableLiveData mutableLiveData;
                LiveEvent liveEvent;
                mutableLiveData = WorkViewModel.this.f33814i0;
                Object b8 = LiveDataExtKt.b(mutableLiveData);
                Intrinsics.e(b8, "driverState.requireValue()");
                if (DriverStatusKt.b((DriverStatus) b8)) {
                    categorySelectionSignal.c(true);
                    liveEvent = WorkViewModel.this.f33818k0;
                    liveEvent.o(Unit.f50853a);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CategorySelectionSignal categorySelectionSignal) {
                b(categorySelectionSignal);
                return Unit.f50853a;
            }
        };
        Consumer<? super CategorySelectionSignal> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.i3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.j2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeNoCategorySelectedSignal$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = y7.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.j3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.k2(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeNoCat…     .autoDispose()\n    }");
        v(subscribe);
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

    private final void l2() {
        ObservableLiveData.t(this.f33810g0, this.E.x(), null, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observePricingData$1
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
                BaseViewModel.A(WorkViewModel.this, it, null, 2, null);
            }
        }, 2, null);
        v(this.f33810g0);
    }

    private final void m2() {
        Observable<Boolean> t7 = this.E.t();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observePricingUnavailableSignal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean pricingUnavailable) {
                LiveEvent liveEvent;
                Intrinsics.e(pricingUnavailable, "pricingUnavailable");
                if (pricingUnavailable.booleanValue()) {
                    liveEvent = WorkViewModel.this.f33816j0;
                    liveEvent.o(Unit.f50853a);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        Consumer<? super Boolean> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.w1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.n2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observePricingUnavailableSignal$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = t7.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.h2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.o2(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observePrici…     .autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p1() {
        DriverManager.o(this.f33813i, null, 1, null);
        this.f33837w.e();
        Completable.u(new Action() { // from class: ee.mtakso.driver.ui.screens.work.h3
            @Override // io.reactivex.functions.Action
            public final void run() {
                WorkViewModel.q1(WorkViewModel.this);
            }
        }).I(Schedulers.a()).E();
        this.K.h();
        this.f33822m0.o(Optional.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(WorkViewModel this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.B.a();
    }

    private final void r2() {
        BehaviorSubject<Boolean> a8 = this.R.a();
        Observable<RecorderState> f8 = this.T.f();
        final WorkViewModel$observeSafetyFABState$1 workViewModel$observeSafetyFABState$1 = new Function2<Boolean, RecorderState, SafetyFABButtonType>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeSafetyFABState$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final SafetyFABButtonType s(Boolean hasActiveIncident, RecorderState recorderState) {
                Intrinsics.f(hasActiveIncident, "hasActiveIncident");
                Intrinsics.f(recorderState, "recorderState");
                return SafetyUIUtils.f32878a.a(hasActiveIncident.booleanValue(), recorderState);
            }
        };
        Observable combineLatest = Observable.combineLatest(a8, f8, new BiFunction() { // from class: ee.mtakso.driver.ui.screens.work.m3
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                SafetyFABButtonType s22;
                s22 = WorkViewModel.s2(Function2.this, obj, obj2);
                return s22;
            }
        });
        Intrinsics.e(combineLatest, "combineLatest(\n         … recorderState)\n        }");
        Observable g8 = ObservableExtKt.g(combineLatest);
        final Function1<SafetyFABButtonType, Unit> function1 = new Function1<SafetyFABButtonType, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeSafetyFABState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(SafetyFABButtonType safetyFABButtonType) {
                MutableLiveData mutableLiveData;
                mutableLiveData = WorkViewModel.this.f33826o0;
                mutableLiveData.o(safetyFABButtonType);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SafetyFABButtonType safetyFABButtonType) {
                b(safetyFABButtonType);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = g8.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.n3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.t2(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observeSafet…    }.autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SafetyFABButtonType s2(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SafetyFABButtonType) tmp0.s(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void w2() {
        ObservableLiveData.t(this.f33828p0, this.S.c(), null, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observeWorkRadius$1
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
                BaseViewModel.A(WorkViewModel.this, it, null, 2, null);
            }
        }, 2, null);
        v(this.f33828p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void x2() {
        Observable<GoOnlineIssue> observeOn = this.A.k().observeOn(AndroidSchedulers.a());
        final Function1<GoOnlineIssue, Unit> function1 = new Function1<GoOnlineIssue, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observerGoOnlineIssues$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GoOnlineIssue goOnlineIssue) {
                DriverStatusSender driverStatusSender;
                LiveEvent liveEvent;
                driverStatusSender = WorkViewModel.this.f33835u;
                driverStatusSender.l();
                liveEvent = WorkViewModel.this.f33805d0;
                liveEvent.o(goOnlineIssue);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GoOnlineIssue goOnlineIssue) {
                b(goOnlineIssue);
                return Unit.f50853a;
            }
        };
        Consumer<? super GoOnlineIssue> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.z1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.y2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$observerGoOnlineIssues$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.a2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.z2(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun observerGoOn…     .autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void z1() {
        Observable<FifoQueueDetails> p8 = this.M.p();
        Observable defer = Observable.defer(new Callable() { // from class: ee.mtakso.driver.ui.screens.work.f2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource A1;
                A1 = WorkViewModel.A1(WorkViewModel.this);
                return A1;
            }
        });
        final Function2<FifoQueueDetails, DashboardState, DashboardState> function2 = new Function2<FifoQueueDetails, DashboardState, DashboardState>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$loadDashboard$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final DashboardState s(FifoQueueDetails fifoState, DashboardState dashboardState) {
                FifoQueueStateMapper fifoQueueStateMapper;
                Intrinsics.f(fifoState, "fifoState");
                Intrinsics.f(dashboardState, "dashboardState");
                if (!(fifoState instanceof FifoQueueDetails.None)) {
                    fifoQueueStateMapper = WorkViewModel.this.N;
                    return fifoQueueStateMapper.b(fifoState);
                }
                return dashboardState;
            }
        };
        Observable combineLatest = Observable.combineLatest(p8, defer, new BiFunction() { // from class: ee.mtakso.driver.ui.screens.work.g2
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                DashboardState B1;
                B1 = WorkViewModel.B1(Function2.this, obj, obj2);
                return B1;
            }
        });
        Intrinsics.e(combineLatest, "private fun loadDashboar…     .autoDispose()\n    }");
        Observable g8 = ObservableExtKt.g(combineLatest);
        final Function1<DashboardState, Unit> function1 = new Function1<DashboardState, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$loadDashboard$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DashboardState dashboardState) {
                MutableLiveData mutableLiveData;
                DriverScoreAnalytics driverScoreAnalytics;
                if (dashboardState instanceof DashboardState.Static) {
                    driverScoreAnalytics = WorkViewModel.this.f33840z;
                    driverScoreAnalytics.N0(((DashboardState.Static) dashboardState).e().b());
                }
                mutableLiveData = WorkViewModel.this.W;
                mutableLiveData.o(dashboardState);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DashboardState dashboardState) {
                b(dashboardState);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.i2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.C1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$loadDashboard$4
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable subscribe = g8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.j2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.D1(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "private fun loadDashboar…     .autoDispose()\n    }");
        v(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z2(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        z1();
        x2();
        W1();
        l2();
        m2();
        S1();
        P1();
        i2();
        b2();
        A2();
        Z2();
        a3();
        Y1();
        r2();
        w2();
        e2();
        h2();
        this.f33821m.Q3();
        this.f33823n.p();
        this.f33809g.w();
    }

    public final void D2() {
        Single d8 = SingleExtKt.d(this.f33836v.z());
        final Function1<Optional<GeoLocationIssue>, Unit> function1 = new Function1<Optional<GeoLocationIssue>, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$obtainLocationIssue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<GeoLocationIssue> optional) {
                LiveEvent liveEvent;
                liveEvent = WorkViewModel.this.f33806e0;
                liveEvent.o(optional.c());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<GeoLocationIssue> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.u2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.E2(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$obtainLocationIssue$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable I = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.v2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.F2(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "fun obtainLocationIssue(…     .autoDispose()\n    }");
        v(I);
    }

    public final void G2() {
        this.f33839y.z(false);
    }

    public final void H2(ModalAction payload) {
        Intrinsics.f(payload, "payload");
        T2(payload.c(), payload.a());
    }

    public final LiveData<GeoLocationIssue> I1() {
        return this.f33806e0;
    }

    public final void I2(DriverButtonAction action) {
        Intrinsics.f(action, "action");
        if (action instanceof DriverButtonAction.Close) {
            this.M.m();
        } else if (action instanceof DriverButtonAction.DeepLink) {
            DeeplinkDelegate.f(this.O, ((DriverButtonAction.DeepLink) action).a(), null, 2, null);
        } else {
            String str = "Unsupported action: " + action;
            Kalev.e(new IllegalArgumentException(str), str);
        }
    }

    public final void J1() {
        d1();
    }

    public final void J2() {
        this.M.m();
    }

    public final LiveData<HeatmapStatus> K1() {
        return this.f33832r0;
    }

    public final void K2() {
        this.M.o();
    }

    public final void L1() {
        this.f33815j.w().b0(true);
    }

    public final void L2() {
        this.f33839y.z(true);
    }

    public final LiveData<Unit> M1() {
        return this.Z;
    }

    public final void M2(DynamicModalDialog.ActionModel actionModel) {
        String str;
        a1();
        if (actionModel != null) {
            BackendModalDialogActionReporterInteractor backendModalDialogActionReporterInteractor = this.L;
            DynamicModalDialog.ModalInfo c8 = actionModel.c();
            if (c8 != null) {
                str = c8.c();
            } else {
                str = null;
            }
            Completable a8 = backendModalDialogActionReporterInteractor.a(str, actionModel.a());
            Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.work.w2
                @Override // io.reactivex.functions.Action
                public final void run() {
                    WorkViewModel.N2();
                }
            };
            final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$onModalAction$1$2
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
                    WorkViewModel workViewModel = WorkViewModel.this;
                    Intrinsics.e(it, "it");
                    BaseViewModel.A(workViewModel, it, null, 2, null);
                }
            };
            Disposable G = a8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.x2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WorkViewModel.O2(Function1.this, obj);
                }
            });
            Intrinsics.e(G, "fun onModalAction(action…Dispose()\n        }\n    }");
            v(G);
        }
    }

    public final LiveData<Unit> N1() {
        return this.f33802a0;
    }

    public final LiveData<Unit> O1() {
        return this.f33818k0;
    }

    public final OptInCampaignAnalytics P2() {
        return this.C;
    }

    public final LiveData<Unit> Q2() {
        return this.f33816j0;
    }

    public final LiveData<PromoDialog> R2() {
        return this.Y;
    }

    public final ReferralCampaignsAnalytics S2() {
        return this.G;
    }

    public final LiveData<LiveDataNotification<String>> V1() {
        return this.X;
    }

    public final CampaignAnalytics W0() {
        return this.f33831r;
    }

    public final void X0() {
        Single l8 = l(this.F.y());
        final WorkViewModel$cancelActiveDestination$1 workViewModel$cancelActiveDestination$1 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$cancelActiveDestination$1
            public final void b(EmptyServerResponse emptyServerResponse) {
                Kalev.b("destination deactivated");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.r2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.Y0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$cancelActiveDestination$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable I = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.t2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.Z0(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "fun cancelActiveDestinat…     .autoDispose()\n    }");
        v(I);
    }

    public final LiveData<DashboardState> X1() {
        return this.W;
    }

    public final LiveData<DidYouGetHelpType> a2() {
        MutableLiveData<DidYouGetHelpType> mutableLiveData = this.f33824n0;
        Intrinsics.d(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpType>");
        return mutableLiveData;
    }

    public final LiveData<String> b3() {
        return this.f33812h0;
    }

    public final void c3() {
        Double a8;
        DashboardState f8 = this.W.f();
        long j8 = 0;
        if ((f8 instanceof DashboardState.Static) && (a8 = ((DashboardState.Static) f8).e().a()) != null) {
            j8 = MathKt__MathJVMKt.c(a8.doubleValue());
        }
        this.f33840z.A1(j8);
    }

    public final void d3() {
        this.f33833s.Q1();
    }

    public final void e3() {
        this.P.m3();
    }

    public final void f3() {
        this.P.a4();
    }

    public final void g1(PricingData pricingData) {
        Intrinsics.f(pricingData, "pricingData");
        Completable j8 = j(this.E.J(pricingData.b(), pricingData.a()));
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.work.y2
            @Override // io.reactivex.functions.Action
            public final void run() {
                WorkViewModel.h1();
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$confirmPricing$2
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
                WorkViewModel workViewModel = WorkViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(workViewModel, it, null, 2, null);
            }
        };
        Disposable G = j8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.z2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.i1(Function1.this, obj);
            }
        });
        Intrinsics.e(G, "fun confirmPricing(prici…     .autoDispose()\n    }");
        v(G);
    }

    public final void g3() {
        DriverScoreItem c8;
        DashboardState f8 = this.W.f();
        long j8 = 0;
        if ((f8 instanceof DashboardState.Static) && (c8 = ((DashboardState.Static) f8).c()) != null) {
            j8 = MathKt__MathJVMKt.c(c8.d());
        }
        this.f33840z.l(j8);
    }

    public final void h3() {
        HeatmapStatus.Available available;
        HeatmapStatus f8 = this.f33832r0.f();
        if (f8 instanceof HeatmapStatus.Available) {
            available = (HeatmapStatus.Available) f8;
        } else {
            available = null;
        }
        if (available == null) {
            return;
        }
        this.D.r1(available.c(), available.a(), available.b());
    }

    public final void i3() {
        this.V.H0();
    }

    public final LiveData<Optional<DriverDestination>> j1() {
        return this.f33808f0;
    }

    public final void j3() {
        this.V.X();
    }

    public final LiveData<CategorySelectionAutoAcceptanceState> k1() {
        return this.f33820l0;
    }

    public final void k3() {
        this.H.M0();
    }

    public final LiveData<Optional<DriverPricing>> l1() {
        return this.f33810g0;
    }

    public final void l3(SafetyTooltipState newTooltipState) {
        Intrinsics.f(newTooltipState, "newTooltipState");
        SafetyTooltipState safetyTooltipState = (SafetyTooltipState) LiveDataExtKt.b(this.f33803b0);
        if (!safetyTooltipState.b()) {
            this.f33817k.H().b(newTooltipState.b());
        } else if (!safetyTooltipState.c()) {
            this.f33817k.O().b(newTooltipState.c());
        }
    }

    public final LiveData<DriverStatus> m1() {
        return this.f33814i0;
    }

    public final void m3() {
        this.f33804c0.m(Boolean.TRUE);
        this.f33817k.N().b(true);
    }

    public final LiveData<FifoModal> n1() {
        return this.f33830q0;
    }

    public final LiveData<Optional<WorkingTimeInfo>> n3() {
        return this.f33822m0;
    }

    public final DriverDestination o1() {
        Optional<DriverDestination> f8 = this.f33808f0.f();
        if (f8 != null) {
            return f8.c();
        }
        return null;
    }

    public final LiveData<WorkRadius> p2() {
        return this.f33828p0;
    }

    public final LiveData<SafetyFABButtonType> q2() {
        MutableLiveData<SafetyFABButtonType> mutableLiveData = this.f33826o0;
        Intrinsics.d(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyFABButtonType>");
        return mutableLiveData;
    }

    public final LiveData<GoOnlineIssue> r1() {
        return this.f33805d0;
    }

    public final boolean s1() {
        return this.f33815j.q().E();
    }

    public final boolean t1() {
        return this.f33813i.r();
    }

    public final boolean u1() {
        if (this.f33815j.q().k() && this.f33815j.n().e()) {
            return true;
        }
        return false;
    }

    public final LiveData<SafetyTooltipState> u2() {
        return this.f33803b0;
    }

    public final boolean v1() {
        return this.f33815j.n().r();
    }

    public final LiveData<Boolean> v2() {
        return this.f33804c0;
    }

    public final void w1() {
        this.X.o(LiveDataNotification.f26294d.b());
        Single d8 = SingleExtKt.d(this.f33811h.d());
        final Function1<CircleKLoyaltySignUpMagicLink, Unit> function1 = new Function1<CircleKLoyaltySignUpMagicLink, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$loadCircleKCampaignUrl$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(CircleKLoyaltySignUpMagicLink circleKLoyaltySignUpMagicLink) {
                LiveEvent liveEvent;
                liveEvent = WorkViewModel.this.X;
                liveEvent.o(LiveDataNotification.f26294d.c(circleKLoyaltySignUpMagicLink.a()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CircleKLoyaltySignUpMagicLink circleKLoyaltySignUpMagicLink) {
                b(circleKLoyaltySignUpMagicLink);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.c3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.x1(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkViewModel$loadCircleKCampaignUrl$2
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
                LiveEvent liveEvent;
                liveEvent = WorkViewModel.this.X;
                LiveDataNotification.Companion companion = LiveDataNotification.f26294d;
                Intrinsics.e(it, "it");
                liveEvent.o(companion.a(it));
            }
        };
        Disposable I = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.e3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                WorkViewModel.y1(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "fun loadCircleKCampaignU…     .autoDispose()\n    }");
        v(I);
    }
}
