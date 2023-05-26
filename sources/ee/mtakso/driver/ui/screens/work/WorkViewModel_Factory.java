package ee.mtakso.driver.ui.screens.work;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.campaign.CampaignClient;
import ee.mtakso.driver.network.client.campaign.CircleKClient;
import ee.mtakso.driver.network.client.driver.DriverClient;
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
import ee.mtakso.driver.service.geo.storage.LocationStorageCleaner;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.service.workingtime.WorkingTimeManager;
import ee.mtakso.driver.ui.interactor.dashboard.GetDashboardInteractor;
import ee.mtakso.driver.ui.interactor.driver.WorkRadiusInteractor;
import ee.mtakso.driver.ui.interactor.map.GetHeatmapStatusInteractor;
import ee.mtakso.driver.ui.interactor.modaldialog.BackendModalDialogActionReporterInteractor;
import ee.mtakso.driver.ui.interactor.modaldialog.FifoModalInteractor;
import ee.mtakso.driver.ui.interactor.modaldialog.SingleModalDialogInteractor;
import ee.mtakso.driver.ui.interactor.score.DriverScoreManager;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistInteractor;
import ee.mtakso.driver.ui.screens.work.fifo.FifoQueueStateMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class WorkViewModel_Factory implements Factory<WorkViewModel> {
    private final Provider<DriverDestinationsManager> A;
    private final Provider<ReferralCampaignsAnalytics> B;
    private final Provider<SafetyToolkitAnalytics> C;
    private final Provider<SingleModalDialogInteractor> D;
    private final Provider<FifoModalInteractor> E;
    private final Provider<AttributedAnalyticsDelegate> F;
    private final Provider<BackendModalDialogActionReporterInteractor> G;
    private final Provider<FifoQueueManager> H;
    private final Provider<FifoQueueStateMapper> I;
    private final Provider<DeeplinkDelegate> J;
    private final Provider<DestinationAnalytics> K;
    private final Provider<DidYouGetHelpInteractor> L;
    private final Provider<EmergencyAssistInteractor> M;
    private final Provider<WorkRadiusInteractor> N;
    private final Provider<AudioRecordingManager> O;
    private final Provider<GetHeatmapStatusInteractor> P;
    private final Provider<PermissionAnalytics> Q;

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverClient> f33884a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderTracker> f33885b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CircleKClient> f33886c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverManager> f33887d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverProvider> f33888e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<DriverSettings> f33889f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<CampaignClient> f33890g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<LoginAnalytics> f33891h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<StartUpTracing> f33892i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<CampaignManager> f33893j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<GetDashboardInteractor> f33894k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<DashboardMapper> f33895l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<CampaignAnalytics> f33896m;

    /* renamed from: n  reason: collision with root package name */
    private final Provider<SettingsAnalytics> f33897n;

    /* renamed from: o  reason: collision with root package name */
    private final Provider<DriverScoreManager> f33898o;

    /* renamed from: p  reason: collision with root package name */
    private final Provider<DriverStatusSender> f33899p;

    /* renamed from: q  reason: collision with root package name */
    private final Provider<GeoLocationManager> f33900q;

    /* renamed from: r  reason: collision with root package name */
    private final Provider<RateMePrefsManager> f33901r;

    /* renamed from: s  reason: collision with root package name */
    private final Provider<WorkingTimeManager> f33902s;

    /* renamed from: t  reason: collision with root package name */
    private final Provider<WorkDistanceDelegate> f33903t;

    /* renamed from: u  reason: collision with root package name */
    private final Provider<DriverScoreAnalytics> f33904u;

    /* renamed from: v  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f33905v;

    /* renamed from: w  reason: collision with root package name */
    private final Provider<LocationStorageCleaner> f33906w;

    /* renamed from: x  reason: collision with root package name */
    private final Provider<OptInCampaignAnalytics> f33907x;

    /* renamed from: y  reason: collision with root package name */
    private final Provider<HeatmapAnalytics> f33908y;

    /* renamed from: z  reason: collision with root package name */
    private final Provider<DispatchSettingsManager> f33909z;

    public WorkViewModel_Factory(Provider<DriverClient> provider, Provider<OrderTracker> provider2, Provider<CircleKClient> provider3, Provider<DriverManager> provider4, Provider<DriverProvider> provider5, Provider<DriverSettings> provider6, Provider<CampaignClient> provider7, Provider<LoginAnalytics> provider8, Provider<StartUpTracing> provider9, Provider<CampaignManager> provider10, Provider<GetDashboardInteractor> provider11, Provider<DashboardMapper> provider12, Provider<CampaignAnalytics> provider13, Provider<SettingsAnalytics> provider14, Provider<DriverScoreManager> provider15, Provider<DriverStatusSender> provider16, Provider<GeoLocationManager> provider17, Provider<RateMePrefsManager> provider18, Provider<WorkingTimeManager> provider19, Provider<WorkDistanceDelegate> provider20, Provider<DriverScoreAnalytics> provider21, Provider<DriverStatusProvider> provider22, Provider<LocationStorageCleaner> provider23, Provider<OptInCampaignAnalytics> provider24, Provider<HeatmapAnalytics> provider25, Provider<DispatchSettingsManager> provider26, Provider<DriverDestinationsManager> provider27, Provider<ReferralCampaignsAnalytics> provider28, Provider<SafetyToolkitAnalytics> provider29, Provider<SingleModalDialogInteractor> provider30, Provider<FifoModalInteractor> provider31, Provider<AttributedAnalyticsDelegate> provider32, Provider<BackendModalDialogActionReporterInteractor> provider33, Provider<FifoQueueManager> provider34, Provider<FifoQueueStateMapper> provider35, Provider<DeeplinkDelegate> provider36, Provider<DestinationAnalytics> provider37, Provider<DidYouGetHelpInteractor> provider38, Provider<EmergencyAssistInteractor> provider39, Provider<WorkRadiusInteractor> provider40, Provider<AudioRecordingManager> provider41, Provider<GetHeatmapStatusInteractor> provider42, Provider<PermissionAnalytics> provider43) {
        this.f33884a = provider;
        this.f33885b = provider2;
        this.f33886c = provider3;
        this.f33887d = provider4;
        this.f33888e = provider5;
        this.f33889f = provider6;
        this.f33890g = provider7;
        this.f33891h = provider8;
        this.f33892i = provider9;
        this.f33893j = provider10;
        this.f33894k = provider11;
        this.f33895l = provider12;
        this.f33896m = provider13;
        this.f33897n = provider14;
        this.f33898o = provider15;
        this.f33899p = provider16;
        this.f33900q = provider17;
        this.f33901r = provider18;
        this.f33902s = provider19;
        this.f33903t = provider20;
        this.f33904u = provider21;
        this.f33905v = provider22;
        this.f33906w = provider23;
        this.f33907x = provider24;
        this.f33908y = provider25;
        this.f33909z = provider26;
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
        this.K = provider37;
        this.L = provider38;
        this.M = provider39;
        this.N = provider40;
        this.O = provider41;
        this.P = provider42;
        this.Q = provider43;
    }

    public static WorkViewModel_Factory a(Provider<DriverClient> provider, Provider<OrderTracker> provider2, Provider<CircleKClient> provider3, Provider<DriverManager> provider4, Provider<DriverProvider> provider5, Provider<DriverSettings> provider6, Provider<CampaignClient> provider7, Provider<LoginAnalytics> provider8, Provider<StartUpTracing> provider9, Provider<CampaignManager> provider10, Provider<GetDashboardInteractor> provider11, Provider<DashboardMapper> provider12, Provider<CampaignAnalytics> provider13, Provider<SettingsAnalytics> provider14, Provider<DriverScoreManager> provider15, Provider<DriverStatusSender> provider16, Provider<GeoLocationManager> provider17, Provider<RateMePrefsManager> provider18, Provider<WorkingTimeManager> provider19, Provider<WorkDistanceDelegate> provider20, Provider<DriverScoreAnalytics> provider21, Provider<DriverStatusProvider> provider22, Provider<LocationStorageCleaner> provider23, Provider<OptInCampaignAnalytics> provider24, Provider<HeatmapAnalytics> provider25, Provider<DispatchSettingsManager> provider26, Provider<DriverDestinationsManager> provider27, Provider<ReferralCampaignsAnalytics> provider28, Provider<SafetyToolkitAnalytics> provider29, Provider<SingleModalDialogInteractor> provider30, Provider<FifoModalInteractor> provider31, Provider<AttributedAnalyticsDelegate> provider32, Provider<BackendModalDialogActionReporterInteractor> provider33, Provider<FifoQueueManager> provider34, Provider<FifoQueueStateMapper> provider35, Provider<DeeplinkDelegate> provider36, Provider<DestinationAnalytics> provider37, Provider<DidYouGetHelpInteractor> provider38, Provider<EmergencyAssistInteractor> provider39, Provider<WorkRadiusInteractor> provider40, Provider<AudioRecordingManager> provider41, Provider<GetHeatmapStatusInteractor> provider42, Provider<PermissionAnalytics> provider43) {
        return new WorkViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34, provider35, provider36, provider37, provider38, provider39, provider40, provider41, provider42, provider43);
    }

    public static WorkViewModel c(DriverClient driverClient, OrderTracker orderTracker, CircleKClient circleKClient, DriverManager driverManager, DriverProvider driverProvider, DriverSettings driverSettings, CampaignClient campaignClient, LoginAnalytics loginAnalytics, StartUpTracing startUpTracing, CampaignManager campaignManager, GetDashboardInteractor getDashboardInteractor, DashboardMapper dashboardMapper, CampaignAnalytics campaignAnalytics, SettingsAnalytics settingsAnalytics, DriverScoreManager driverScoreManager, DriverStatusSender driverStatusSender, GeoLocationManager geoLocationManager, RateMePrefsManager rateMePrefsManager, WorkingTimeManager workingTimeManager, WorkDistanceDelegate workDistanceDelegate, DriverScoreAnalytics driverScoreAnalytics, DriverStatusProvider driverStatusProvider, LocationStorageCleaner locationStorageCleaner, OptInCampaignAnalytics optInCampaignAnalytics, HeatmapAnalytics heatmapAnalytics, DispatchSettingsManager dispatchSettingsManager, DriverDestinationsManager driverDestinationsManager, ReferralCampaignsAnalytics referralCampaignsAnalytics, SafetyToolkitAnalytics safetyToolkitAnalytics, SingleModalDialogInteractor singleModalDialogInteractor, FifoModalInteractor fifoModalInteractor, AttributedAnalyticsDelegate attributedAnalyticsDelegate, BackendModalDialogActionReporterInteractor backendModalDialogActionReporterInteractor, FifoQueueManager fifoQueueManager, FifoQueueStateMapper fifoQueueStateMapper, DeeplinkDelegate deeplinkDelegate, DestinationAnalytics destinationAnalytics, DidYouGetHelpInteractor didYouGetHelpInteractor, EmergencyAssistInteractor emergencyAssistInteractor, WorkRadiusInteractor workRadiusInteractor, AudioRecordingManager audioRecordingManager, GetHeatmapStatusInteractor getHeatmapStatusInteractor, PermissionAnalytics permissionAnalytics) {
        return new WorkViewModel(driverClient, orderTracker, circleKClient, driverManager, driverProvider, driverSettings, campaignClient, loginAnalytics, startUpTracing, campaignManager, getDashboardInteractor, dashboardMapper, campaignAnalytics, settingsAnalytics, driverScoreManager, driverStatusSender, geoLocationManager, rateMePrefsManager, workingTimeManager, workDistanceDelegate, driverScoreAnalytics, driverStatusProvider, locationStorageCleaner, optInCampaignAnalytics, heatmapAnalytics, dispatchSettingsManager, driverDestinationsManager, referralCampaignsAnalytics, safetyToolkitAnalytics, singleModalDialogInteractor, fifoModalInteractor, attributedAnalyticsDelegate, backendModalDialogActionReporterInteractor, fifoQueueManager, fifoQueueStateMapper, deeplinkDelegate, destinationAnalytics, didYouGetHelpInteractor, emergencyAssistInteractor, workRadiusInteractor, audioRecordingManager, getHeatmapStatusInteractor, permissionAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WorkViewModel get() {
        return c(this.f33884a.get(), this.f33885b.get(), this.f33886c.get(), this.f33887d.get(), this.f33888e.get(), this.f33889f.get(), this.f33890g.get(), this.f33891h.get(), this.f33892i.get(), this.f33893j.get(), this.f33894k.get(), this.f33895l.get(), this.f33896m.get(), this.f33897n.get(), this.f33898o.get(), this.f33899p.get(), this.f33900q.get(), this.f33901r.get(), this.f33902s.get(), this.f33903t.get(), this.f33904u.get(), this.f33905v.get(), this.f33906w.get(), this.f33907x.get(), this.f33908y.get(), this.f33909z.get(), this.A.get(), this.B.get(), this.C.get(), this.D.get(), this.E.get(), this.F.get(), this.G.get(), this.H.get(), this.I.get(), this.J.get(), this.K.get(), this.L.get(), this.M.get(), this.N.get(), this.O.get(), this.P.get(), this.Q.get());
    }
}
