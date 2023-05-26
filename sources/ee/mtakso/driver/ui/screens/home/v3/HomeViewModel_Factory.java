package ee.mtakso.driver.ui.screens.home.v3;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.deeplink.DeepLinkParser;
import ee.mtakso.driver.network.client.training.TrainingClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.DestinationAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.service.dashboard.DashboardService;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.rating.app.AppRatingManager;
import ee.mtakso.driver.service.restriction.DriverTrainingRestrictionManager;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.ui.common.push.PushDataService;
import ee.mtakso.driver.ui.interactor.driver.DistinctDriverStateInteractor;
import ee.mtakso.driver.ui.interactor.driver.DriverStateChangeFailInteractor;
import ee.mtakso.driver.ui.interactor.driver.MakeDriverInactiveInteractor;
import ee.mtakso.driver.ui.interactor.driver.OnlineCheckInteractor;
import ee.mtakso.driver.ui.interactor.modaldialog.BackendModalDialogActionReporterInteractor;
import ee.mtakso.driver.ui.interactor.network_usage.NetworkUsageUploadInteractor;
import ee.mtakso.driver.ui.interactor.promodialog.HomePromoDialogInteractor;
import ee.mtakso.driver.ui.interactor.warnings.AuthorizedWarningInteractor;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DistinctDriverStateInteractor> f29829a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OnlineCheckInteractor> f29830b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MakeDriverInactiveInteractor> f29831c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PushDataService> f29832d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<AppRatingManager> f29833e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<OrderProvider> f29834f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<OrderStateManager> f29835g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DriverManager> f29836h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<DriverProvider> f29837i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<CompositeUrlLauncher> f29838j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<DeepLinkParser> f29839k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<HomePromoDialogInteractor> f29840l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<AuthorizedWarningInteractor> f29841m;

    /* renamed from: n  reason: collision with root package name */
    private final Provider<DashboardService> f29842n;

    /* renamed from: o  reason: collision with root package name */
    private final Provider<BackendModalDialogActionReporterInteractor> f29843o;

    /* renamed from: p  reason: collision with root package name */
    private final Provider<DestinationAnalytics> f29844p;

    /* renamed from: q  reason: collision with root package name */
    private final Provider<DriverStateChangeFailInteractor> f29845q;

    /* renamed from: r  reason: collision with root package name */
    private final Provider<TrainingClient> f29846r;

    /* renamed from: s  reason: collision with root package name */
    private final Provider<DriverTrainingRestrictionManager> f29847s;

    /* renamed from: t  reason: collision with root package name */
    private final Provider<SettingsAnalytics> f29848t;

    /* renamed from: u  reason: collision with root package name */
    private final Provider<NetworkUsageUploadInteractor> f29849u;

    /* renamed from: v  reason: collision with root package name */
    private final Provider<DispatchSettingsManager> f29850v;

    public HomeViewModel_Factory(Provider<DistinctDriverStateInteractor> provider, Provider<OnlineCheckInteractor> provider2, Provider<MakeDriverInactiveInteractor> provider3, Provider<PushDataService> provider4, Provider<AppRatingManager> provider5, Provider<OrderProvider> provider6, Provider<OrderStateManager> provider7, Provider<DriverManager> provider8, Provider<DriverProvider> provider9, Provider<CompositeUrlLauncher> provider10, Provider<DeepLinkParser> provider11, Provider<HomePromoDialogInteractor> provider12, Provider<AuthorizedWarningInteractor> provider13, Provider<DashboardService> provider14, Provider<BackendModalDialogActionReporterInteractor> provider15, Provider<DestinationAnalytics> provider16, Provider<DriverStateChangeFailInteractor> provider17, Provider<TrainingClient> provider18, Provider<DriverTrainingRestrictionManager> provider19, Provider<SettingsAnalytics> provider20, Provider<NetworkUsageUploadInteractor> provider21, Provider<DispatchSettingsManager> provider22) {
        this.f29829a = provider;
        this.f29830b = provider2;
        this.f29831c = provider3;
        this.f29832d = provider4;
        this.f29833e = provider5;
        this.f29834f = provider6;
        this.f29835g = provider7;
        this.f29836h = provider8;
        this.f29837i = provider9;
        this.f29838j = provider10;
        this.f29839k = provider11;
        this.f29840l = provider12;
        this.f29841m = provider13;
        this.f29842n = provider14;
        this.f29843o = provider15;
        this.f29844p = provider16;
        this.f29845q = provider17;
        this.f29846r = provider18;
        this.f29847s = provider19;
        this.f29848t = provider20;
        this.f29849u = provider21;
        this.f29850v = provider22;
    }

    public static HomeViewModel_Factory a(Provider<DistinctDriverStateInteractor> provider, Provider<OnlineCheckInteractor> provider2, Provider<MakeDriverInactiveInteractor> provider3, Provider<PushDataService> provider4, Provider<AppRatingManager> provider5, Provider<OrderProvider> provider6, Provider<OrderStateManager> provider7, Provider<DriverManager> provider8, Provider<DriverProvider> provider9, Provider<CompositeUrlLauncher> provider10, Provider<DeepLinkParser> provider11, Provider<HomePromoDialogInteractor> provider12, Provider<AuthorizedWarningInteractor> provider13, Provider<DashboardService> provider14, Provider<BackendModalDialogActionReporterInteractor> provider15, Provider<DestinationAnalytics> provider16, Provider<DriverStateChangeFailInteractor> provider17, Provider<TrainingClient> provider18, Provider<DriverTrainingRestrictionManager> provider19, Provider<SettingsAnalytics> provider20, Provider<NetworkUsageUploadInteractor> provider21, Provider<DispatchSettingsManager> provider22) {
        return new HomeViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22);
    }

    public static HomeViewModel c(DistinctDriverStateInteractor distinctDriverStateInteractor, OnlineCheckInteractor onlineCheckInteractor, MakeDriverInactiveInteractor makeDriverInactiveInteractor, PushDataService pushDataService, AppRatingManager appRatingManager, OrderProvider orderProvider, OrderStateManager orderStateManager, DriverManager driverManager, DriverProvider driverProvider, CompositeUrlLauncher compositeUrlLauncher, DeepLinkParser deepLinkParser, HomePromoDialogInteractor homePromoDialogInteractor, AuthorizedWarningInteractor authorizedWarningInteractor, DashboardService dashboardService, BackendModalDialogActionReporterInteractor backendModalDialogActionReporterInteractor, DestinationAnalytics destinationAnalytics, DriverStateChangeFailInteractor driverStateChangeFailInteractor, TrainingClient trainingClient, DriverTrainingRestrictionManager driverTrainingRestrictionManager, SettingsAnalytics settingsAnalytics, NetworkUsageUploadInteractor networkUsageUploadInteractor, DispatchSettingsManager dispatchSettingsManager) {
        return new HomeViewModel(distinctDriverStateInteractor, onlineCheckInteractor, makeDriverInactiveInteractor, pushDataService, appRatingManager, orderProvider, orderStateManager, driverManager, driverProvider, compositeUrlLauncher, deepLinkParser, homePromoDialogInteractor, authorizedWarningInteractor, dashboardService, backendModalDialogActionReporterInteractor, destinationAnalytics, driverStateChangeFailInteractor, trainingClient, driverTrainingRestrictionManager, settingsAnalytics, networkUsageUploadInteractor, dispatchSettingsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HomeViewModel get() {
        return c(this.f29829a.get(), this.f29830b.get(), this.f29831c.get(), this.f29832d.get(), this.f29833e.get(), this.f29834f.get(), this.f29835g.get(), this.f29836h.get(), this.f29837i.get(), this.f29838j.get(), this.f29839k.get(), this.f29840l.get(), this.f29841m.get(), this.f29842n.get(), this.f29843o.get(), this.f29844p.get(), this.f29845q.get(), this.f29846r.get(), this.f29847s.get(), this.f29848t.get(), this.f29849u.get(), this.f29850v.get());
    }
}
