package ee.mtakso.driver.di;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import com.google.gson.Gson;
import ee.mtakso.App;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.di.anonymous.AnonymousComponent;
import ee.mtakso.driver.di.anonymous.DaggerAnonymousComponent;
import ee.mtakso.driver.di.authorised.AuthorisedComponent;
import ee.mtakso.driver.di.authorised.DaggerAuthorisedComponent;
import ee.mtakso.driver.di.modules.ApplicationComponent;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.identity.verification.IdentityVerificationManager;
import ee.mtakso.driver.log.LogManager;
import ee.mtakso.driver.log.LogWorker;
import ee.mtakso.driver.log.applog.AppLogWatcher;
import ee.mtakso.driver.log.bigquery.BigQueryLogWatcher;
import ee.mtakso.driver.log.report.ReportManager;
import ee.mtakso.driver.log.storage.DatabaseManager;
import ee.mtakso.driver.log.strategy.memory.OrderStateStrategy;
import ee.mtakso.driver.log.strategy.memory.WebViewStrategy;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.navigation.NavigationManager;
import ee.mtakso.driver.network.ApiExceptionProvider;
import ee.mtakso.driver.network.client.ShardApiProvider;
import ee.mtakso.driver.network.client.audio_recording.upload.AudioRecordingUploadAPI;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthApi;
import ee.mtakso.driver.network.client.auth.anonymous.DriverAuthAnonymousApi;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthApi;
import ee.mtakso.driver.network.client.contact.ContactApi;
import ee.mtakso.driver.network.client.device.DeviceInfoApi;
import ee.mtakso.driver.network.client.driver.DriverConfigurationApi;
import ee.mtakso.driver.network.client.partner.PartnerClient;
import ee.mtakso.driver.network.client.registration.DriverRegistrationApi;
import ee.mtakso.driver.network.client.support.SupportApi;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.platform.Platform;
import ee.mtakso.driver.platform.ads.AdvertiserIdProvider;
import ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever;
import ee.mtakso.driver.platform.check.PlatformAvailabilityManager;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.installation.InstallationIdProvider;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultToRequestMapper;
import ee.mtakso.driver.platform.push.PushManager;
import ee.mtakso.driver.platform.push.TokenProvider;
import ee.mtakso.driver.platform.security.SecurityManager;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityCheck;
import ee.mtakso.driver.service.AwakeService;
import ee.mtakso.driver.service.analytics.controller.MixpanelController;
import ee.mtakso.driver.service.analytics.event.AnalyticsManager;
import ee.mtakso.driver.service.analytics.event.facade.AppPerformanceAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.AppVerificationAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DriverAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.HistoryAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.NewsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PermissionAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SignUpAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics;
import ee.mtakso.driver.service.analytics.timed.TimedAnalyticsManager;
import ee.mtakso.driver.service.analytics.timed.facade.OrderTracing;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.TempDriverConfigHolder;
import ee.mtakso.driver.service.chat.ChatService;
import ee.mtakso.driver.service.connectivity.NetworkService;
import ee.mtakso.driver.service.deviceinfo.DeviceInfoSender;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.storage.LocationStorageCleaner;
import ee.mtakso.driver.service.geo.transmitter.LocationTransmitter;
import ee.mtakso.driver.service.integration.appsflyer.AppsflyerManager;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.incident.IncidentReportingService;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.modules.polling.Poller;
import ee.mtakso.driver.service.modules.reporters.NotRespondReporter;
import ee.mtakso.driver.service.modules.reporters.WrongStateReporter;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.service.push.PushManagerImpl;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.service.quickaccess.QuickAccessService;
import ee.mtakso.driver.service.restriction.DriverTrainingRestrictionManager;
import ee.mtakso.driver.service.restriction.EnvironmentDataProvider;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.service.session.SessionProvider;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.service.token.PartnerTokenManager;
import ee.mtakso.driver.service.token.TokenManager;
import ee.mtakso.driver.service.voip.VoipService;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipActiveWindowTracker;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipRxLifecycleTransfromer;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerCallCache;
import ee.mtakso.driver.service.workingtime.WorkingTimeManager;
import ee.mtakso.driver.startup.AnalyticsInitializer;
import ee.mtakso.driver.startup.LogManagerInitializer;
import ee.mtakso.driver.startup.WorkManagerInitializer;
import ee.mtakso.driver.ui.helper.ErrorHandler;
import ee.mtakso.driver.ui.screens.contact_methods.voip.service.VoipIntentService;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.cancels.CancelsFragment;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.hours.HoursFragment;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.rides.RidesFragment;
import ee.mtakso.driver.ui.screens.home.v3.DeeplinkHomeContainerCoordinator;
import ee.mtakso.driver.ui.screens.home.v3.map.vector.VectorTileBitmapPool;
import ee.mtakso.driver.ui.screens.launch.LauncherActivity;
import ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment;
import ee.mtakso.driver.utils.BackgroundManager;
import eu.bolt.android.chat.DaggerChatComponent;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.chat.chatcore.ChatKit;
import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.interactor.ReadMessageInteractor;
import eu.bolt.chat.chatcore.interactor.RequestReplySuggestionsInteractor;
import eu.bolt.chat.chatcore.interactor.SendChatMessageInteractor;
import eu.bolt.chat.chatcore.push.ChatPushHandler;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.driver.chat.DriverChatSdk;
import eu.bolt.driver.chat.helper.SoundEffectsPool;
import eu.bolt.driver.chat.service.ChatManager;
import eu.bolt.driver.chat.ui.notification.ChatNotificationManager;
import eu.bolt.driver.core.DriverCore;
import eu.bolt.driver.core.di.scope.authorized.AuthorizedCoreComponent;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.time.AnchoredTimeSource;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.translation.RawTranslationProvider;
import eu.bolt.driver.core.ui.translation.TranslationManager;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import eu.bolt.driver.core.util.DateTimeFormatter;
import eu.bolt.driver.earnings.network.EarningsApi;
import eu.bolt.driver.earnings.network.EarningsBalanceApi;
import eu.bolt.driver.earnings.network.EarningsGoalApi;
import eu.bolt.driver.verification.identity.VerificationAnalytics;
import eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer;
import eu.bolt.kalev.Kalev;
import javax.inject.Provider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/* compiled from: Injector.kt */
/* loaded from: classes3.dex */
public final class Injector implements ApplicationComponent {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f20166d = new Companion(null);

    /* renamed from: e  reason: collision with root package name */
    private static volatile Injector f20167e;

    /* renamed from: a  reason: collision with root package name */
    private final ApplicationComponent f20168a;

    /* renamed from: b  reason: collision with root package name */
    private AnonymousComponent f20169b;

    /* renamed from: c  reason: collision with root package name */
    private AuthorisedComponent f20170c;

    /* compiled from: Injector.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ApplicationComponent a(App application, Provider<ApplicationComponent.Builder> builderProvider) {
            ApplicationComponent applicationComponent;
            Intrinsics.f(application, "application");
            Intrinsics.f(builderProvider, "builderProvider");
            ApplicationComponent appComponent = builderProvider.get().a(application).b(DaggerChatComponent.a().context(application).build()).build();
            Intrinsics.e(appComponent, "appComponent");
            Injector.f20167e = new Injector(appComponent);
            Platform platform = Platform.f23272a;
            Injector injector = Injector.f20167e;
            if (injector != null) {
                applicationComponent = injector.e2();
            } else {
                applicationComponent = null;
            }
            platform.b(applicationComponent);
            return appComponent;
        }

        public final Injector b() {
            Injector injector = Injector.f20167e;
            if (injector != null) {
                return injector;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    public Injector(ApplicationComponent appComponent) {
        Intrinsics.f(appComponent, "appComponent");
        this.f20168a = appComponent;
    }

    public static final Injector f2() {
        return f20166d.b();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public RoutingManager A() {
        return this.f20168a.A();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public Context A0() {
        return this.f20168a.A0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public OptInCampaignAnalytics A1() {
        return this.f20168a.A1();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public void B(WorkManagerInitializer workManagerInitializer) {
        this.f20168a.B(workManagerInitializer);
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public OrderProvider B0() {
        return this.f20168a.B0();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public SecurityManager B1() {
        return this.f20168a.B1();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DeviceInfoApi C() {
        return this.f20168a.C();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public DateTimeConverter C0() {
        return this.f20168a.C0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DeeplinkHomeContainerCoordinator C1() {
        return this.f20168a.C1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public IncidentReportingService D() {
        return this.f20168a.D();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DatabaseManager D0() {
        return this.f20168a.D0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public PlatformManager D1() {
        return this.f20168a.D1();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public void E(AwakeService awakeService) {
        this.f20168a.E(awakeService);
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public WrongStateReporter E0() {
        return this.f20168a.E0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public PackageManager E1() {
        return this.f20168a.E1();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DriverTrainingRestrictionManager F() {
        return this.f20168a.F();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public OrderStateStrategy F0() {
        return this.f20168a.F0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public ChatService F1() {
        return this.f20168a.F1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public TrueTimeProvider G() {
        return this.f20168a.G();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public InstallationIdProvider G0() {
        return this.f20168a.G0();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public CleverTapManager G1() {
        return this.f20168a.G1();
    }

    @Override // ee.mtakso.driver.platform.di.PlatformDependencies
    public StoreIntegrityVerificationResultToRequestMapper H() {
        return this.f20168a.H();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public void H0(HoursFragment hoursFragment) {
        this.f20168a.H0(hoursFragment);
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public DispatchSettingsManager H1() {
        return this.f20168a.H1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public GsonConverterFactory I() {
        return this.f20168a.I();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public IdentityVerificationManager I0() {
        return this.f20168a.I0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public EnvironmentDataProvider I1() {
        return this.f20168a.I1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public EarningsApi J() {
        return this.f20168a.J();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DeviceInfoSender J0() {
        return this.f20168a.J0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public ScreenAnalytics J1() {
        return this.f20168a.J1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public SafetyToolkitAnalytics K() {
        return this.f20168a.K();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public void K0(CancelsFragment cancelsFragment) {
        this.f20168a.K0(cancelsFragment);
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public PermissionAnalytics K1() {
        return this.f20168a.K1();
    }

    @Override // eu.bolt.driver.chat.di.DriverChatApplicationComponent
    public ChatManager L() {
        return this.f20168a.L();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public AudioRecordingUploadAPI L0() {
        return this.f20168a.L0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public VoipNotificationDrawer L1() {
        return this.f20168a.L1();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DeviceSettings M() {
        return this.f20168a.M();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public void M0(LogManagerInitializer logManagerInitializer) {
        this.f20168a.M0(logManagerInitializer);
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public SettingsAnalytics M1() {
        return this.f20168a.M1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public OrderTracing N() {
        return this.f20168a.N();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public LocationTransmitter N0() {
        return this.f20168a.N0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public ChatConnectionProvider N1() {
        return this.f20168a.N1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public NavigationManager O() {
        return this.f20168a.O();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public MixpanelController O0() {
        return this.f20168a.O0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public CoroutineDispatcher O1() {
        return this.f20168a.O1();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DriverAuthAnonymousApi P() {
        return this.f20168a.P();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public NewsAnalytics P0() {
        return this.f20168a.P0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public VerificationAnalytics P1() {
        return this.f20168a.P1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public OrderStateManager Q() {
        return this.f20168a.Q();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DriverManager Q0() {
        return this.f20168a.Q0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public ResponseErrorProcessor Q1() {
        return this.f20168a.Q1();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public AppLogWatcher R() {
        return this.f20168a.R();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public PayoutAnalytics R0() {
        return this.f20168a.R0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public BackgroundManager R1() {
        return this.f20168a.R1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public ReferralCampaignsAnalytics S() {
        return this.f20168a.S();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public ApiExceptionProvider S0() {
        return this.f20168a.S0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public PartnerOffersAnalytics S1() {
        return this.f20168a.S1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public VoipActiveWindowTracker T() {
        return this.f20168a.T();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public ShardApiProvider T0() {
        return this.f20168a.T0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public TokenManager T1() {
        return this.f20168a.T1();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public TempDriverConfigHolder U() {
        return this.f20168a.U();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public void U0(LauncherActivity launcherActivity) {
        this.f20168a.U0(launcherActivity);
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public TimedAnalyticsManager U1() {
        return this.f20168a.U1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public NetworkService V() {
        return this.f20168a.V();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public DriverStatusSender V0() {
        return this.f20168a.V0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public NoAnswerCallCache W() {
        return this.f20168a.W();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public AudioRecordingAnalytics W0() {
        return this.f20168a.W0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public ContactApi X() {
        return this.f20168a.X();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public TranslationManager X0() {
        return this.f20168a.X0();
    }

    public final AnonymousComponent X1() {
        if (this.f20169b == null) {
            Kalev.e(new IllegalStateException("Emergency dagger restoration - anon"), "Fixed dagger graph on process start");
            a2();
        }
        AnonymousComponent anonymousComponent = this.f20169b;
        if (anonymousComponent != null) {
            return anonymousComponent;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // ee.mtakso.driver.platform.di.PlatformDependencies
    public ConfirmationCodeRetriever Y() {
        return this.f20168a.Y();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public void Y0(PermissionOnboardingFragment permissionOnboardingFragment) {
        this.f20168a.Y0(permissionOnboardingFragment);
    }

    public final AuthorisedComponent Y1() {
        if (this.f20170c == null) {
            Kalev.e(new IllegalStateException("Emergency dagger restoration - auth"), "Fixed dagger graph on process start");
            DriverProvider t7 = this.f20168a.t();
            b2(t7.o(), t7.w(), t7.r(), new AnchoredTimeSource(System.currentTimeMillis()));
        }
        AuthorisedComponent authorisedComponent = this.f20170c;
        if (authorisedComponent != null) {
            return authorisedComponent;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DeepLinkManager Z() {
        return this.f20168a.Z();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DriverRegistrationApi Z0() {
        return this.f20168a.Z0();
    }

    public final AuthorisedComponent Z1() {
        return this.f20170c;
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public LanguageManager a() {
        return this.f20168a.a();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public SignUpAnalytics a0() {
        return this.f20168a.a0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public RawTranslationProvider a1() {
        return this.f20168a.a1();
    }

    public final void a2() {
        if (this.f20169b != null) {
            return;
        }
        this.f20169b = DaggerAnonymousComponent.a().a(this.f20168a).b();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public ReadMessageInteractor b() {
        return this.f20168a.b();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public AuthenticatedAuthApi b0() {
        return this.f20168a.b0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public Gson b1() {
        return this.f20168a.b1();
    }

    public final void b2(DriverConfig driver, DriverSettings settings, DriverFeatures features, AnchoredTimeSource timeSource) {
        Intrinsics.f(driver, "driver");
        Intrinsics.f(settings, "settings");
        Intrinsics.f(features, "features");
        Intrinsics.f(timeSource, "timeSource");
        if (this.f20170c != null) {
            return;
        }
        AuthorisedComponent build = DaggerAuthorisedComponent.a().d(driver).b(settings).a(features).c(timeSource).e(this.f20168a).build();
        this.f20170c = build;
        DriverCore.f40758a.c(new Function0<AuthorizedCoreComponent>() { // from class: ee.mtakso.driver.di.Injector$buildAuthorisedComponent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final AuthorizedCoreComponent invoke() {
                return Injector.this.Y1();
            }
        });
        DriverChatSdk.f40388a.f(build);
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public SendChatMessageInteractor c() {
        return this.f20168a.c();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public SupportApi c0() {
        return this.f20168a.c0();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public void c1(RidesFragment ridesFragment) {
        this.f20168a.c1(ridesFragment);
    }

    public final void c2() {
        this.f20169b = null;
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public ChatPushHandler d() {
        return this.f20168a.d();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public ErrorHandler d0() {
        return this.f20168a.d0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DriverAnalytics d1() {
        return this.f20168a.d1();
    }

    public final void d2() {
        DriverChatSdk.f40388a.g();
        this.f20170c = null;
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public RequestReplySuggestionsInteractor e() {
        return this.f20168a.e();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public LocationStorageCleaner e0() {
        return this.f20168a.e0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public PartnerTokenManager e1() {
        return this.f20168a.e1();
    }

    public final ApplicationComponent e2() {
        return this.f20168a;
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public OrdersCache f() {
        return this.f20168a.f();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public WebViewStrategy f0() {
        return this.f20168a.f0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public VoipService f1() {
        return this.f20168a.f1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public ChatRepo g() {
        return this.f20168a.g();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public AppRoutingManager g0() {
        return this.f20168a.g0();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public ReportManager g1() {
        return this.f20168a.g1();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public void h(VoipIntentService voipIntentService) {
        this.f20168a.h(voipIntentService);
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public TokenProvider h0() {
        return this.f20168a.h0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public SessionProvider h1() {
        return this.f20168a.h1();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public LoginAnalytics i() {
        return this.f20168a.i();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public PermissionManager i0() {
        return this.f20168a.i0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public OnBoardingManager i1() {
        return this.f20168a.i1();
    }

    @Override // ee.mtakso.driver.platform.di.PlatformDependencies
    public PushManager j() {
        return this.f20168a.j();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public HtmlEngine j0() {
        return this.f20168a.j0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public DriverDestinationsManager j1() {
        return this.f20168a.j1();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public void k(App app) {
        this.f20168a.k(app);
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public AppVerificationAnalytics k0() {
        return this.f20168a.k0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public SurgeManager k1() {
        return this.f20168a.k1();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DeviceInfo l() {
        return this.f20168a.l();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public EarningsGoalApi l0() {
        return this.f20168a.l0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DriverConfigurationApi l1() {
        return this.f20168a.l1();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public StartUpTracing m() {
        return this.f20168a.m();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public NotificationManager m0() {
        return this.f20168a.m0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public LogWorker m1() {
        return this.f20168a.m1();
    }

    @Override // eu.bolt.driver.chat.di.DriverChatApplicationComponent
    public ChatKit.Dependencies n() {
        return this.f20168a.n();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public ChatAnalytics n0() {
        return this.f20168a.n0();
    }

    @Override // eu.bolt.driver.chat.di.DriverChatApplicationComponent
    public ChatNotificationManager n1() {
        return this.f20168a.n1();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public AnonymousAuthApi o() {
        return this.f20168a.o();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public OkHttpClient o0() {
        return this.f20168a.o0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public GeoLocationManager o1() {
        return this.f20168a.o1();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public AdvertiserIdProvider p() {
        return this.f20168a.p();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public VectorTileBitmapPool p0() {
        return this.f20168a.p0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public CampaignAnalytics p1() {
        return this.f20168a.p1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public WorkingTimeManager q() {
        return this.f20168a.q();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public VoipRxLifecycleTransfromer q0() {
        return this.f20168a.q0();
    }

    @Override // ee.mtakso.driver.platform.di.PlatformDependencies
    public StoreIntegrityCheck q1() {
        return this.f20168a.q1();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public BigQueryLogWatcher r() {
        return this.f20168a.r();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public PartnerClient r0() {
        return this.f20168a.r0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public LogManager r1() {
        return this.f20168a.r1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public EarningsBalanceApi s() {
        return this.f20168a.s();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public SoundEffectsPool s0() {
        return this.f20168a.s0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public WebViewAnalytics s1() {
        return this.f20168a.s1();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public DriverProvider t() {
        return this.f20168a.t();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public PushNotificationManager t0() {
        return this.f20168a.t0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public NotRespondReporter t1() {
        return this.f20168a.t1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public HistoryAnalytics u() {
        return this.f20168a.u();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public Poller u0() {
        return this.f20168a.u0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public OrderFlowAnalytics u1() {
        return this.f20168a.u1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public PushManagerImpl v() {
        return this.f20168a.v();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public void v0(AnalyticsInitializer analyticsInitializer) {
        this.f20168a.v0(analyticsInitializer);
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public DateTimeFormatter v1() {
        return this.f20168a.v1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public MapProvider w() {
        return this.f20168a.w();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public AuthManager w0() {
        return this.f20168a.w0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public QuickAccessStateAnalytics w1() {
        return this.f20168a.w1();
    }

    @Override // ee.mtakso.driver.di.modules.ApplicationComponent
    public void x(QuickAccessService quickAccessService) {
        this.f20168a.x(quickAccessService);
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public AnalyticsManager x0() {
        return this.f20168a.x0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public AppsflyerManager x1() {
        return this.f20168a.x1();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public NavigationAppTypeFactory y() {
        return this.f20168a.y();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public SimpleXmlConverterFactory y0() {
        return this.f20168a.y0();
    }

    @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
    public AppPerformanceAnalytics y1() {
        return this.f20168a.y1();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public Features z() {
        return this.f20168a.z();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public DriverStatusProvider z0() {
        return this.f20168a.z0();
    }

    @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
    public PlatformAvailabilityManager z1() {
        return this.f20168a.z1();
    }
}
