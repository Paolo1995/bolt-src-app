package ee.mtakso.driver.di.authorised;

import com.google.gson.Gson;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.log.LogManager;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.navigation.NavigationManager;
import ee.mtakso.driver.network.ApiExceptionProvider;
import ee.mtakso.driver.network.client.audio_recording.upload.AudioRecordingUploadAPI;
import ee.mtakso.driver.network.client.contact.ContactApi;
import ee.mtakso.driver.network.client.support.SupportApi;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.push.TokenProvider;
import ee.mtakso.driver.service.analytics.event.facade.AppPerformanceAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.HistoryAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.NewsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PermissionAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.service.analytics.timed.TimedAnalyticsManager;
import ee.mtakso.driver.service.analytics.timed.facade.OrderTracing;
import ee.mtakso.driver.service.connectivity.NetworkService;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.storage.LocationStorageCleaner;
import ee.mtakso.driver.service.geo.transmitter.LocationTransmitter;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.incident.IncidentReportingService;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.modules.reporters.NotRespondReporter;
import ee.mtakso.driver.service.modules.reporters.WrongStateReporter;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.service.push.PushManagerImpl;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.service.voip.VoipService;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipActiveWindowTracker;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipRxLifecycleTransfromer;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerCallCache;
import ee.mtakso.driver.service.workingtime.WorkingTimeManager;
import ee.mtakso.driver.ui.helper.ErrorHandler;
import ee.mtakso.driver.ui.screens.home.v3.map.vector.VectorTileBitmapPool;
import ee.mtakso.driver.utils.BackgroundManager;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.interactor.ReadMessageInteractor;
import eu.bolt.chat.chatcore.interactor.RequestReplySuggestionsInteractor;
import eu.bolt.chat.chatcore.interactor.SendChatMessageInteractor;
import eu.bolt.chat.chatcore.push.ChatPushHandler;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.driver.chat.helper.SoundEffectsPool;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.translation.RawTranslationProvider;
import eu.bolt.driver.core.util.DateTimeFormatter;
import eu.bolt.driver.earnings.network.EarningsApi;
import eu.bolt.driver.earnings.network.EarningsBalanceApi;
import eu.bolt.driver.earnings.network.EarningsGoalApi;
import eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer;
import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/* compiled from: MainAuthorisedComponent.kt */
/* loaded from: classes3.dex */
public interface AuthorisedModuleDeps {
    RoutingManager A();

    OptInCampaignAnalytics A1();

    DateTimeConverter C0();

    IncidentReportingService D();

    PlatformManager D1();

    WrongStateReporter E0();

    TrueTimeProvider G();

    DispatchSettingsManager H1();

    GsonConverterFactory I();

    EarningsApi J();

    SafetyToolkitAnalytics K();

    PermissionAnalytics K1();

    AudioRecordingUploadAPI L0();

    VoipNotificationDrawer L1();

    SettingsAnalytics M1();

    OrderTracing N();

    LocationTransmitter N0();

    ChatConnectionProvider N1();

    NavigationManager O();

    NewsAnalytics P0();

    OrderStateManager Q();

    PayoutAnalytics R0();

    BackgroundManager R1();

    ReferralCampaignsAnalytics S();

    ApiExceptionProvider S0();

    PartnerOffersAnalytics S1();

    VoipActiveWindowTracker T();

    TimedAnalyticsManager U1();

    NetworkService V();

    DriverStatusSender V0();

    NoAnswerCallCache W();

    AudioRecordingAnalytics W0();

    ContactApi X();

    RawTranslationProvider a1();

    ReadMessageInteractor b();

    Gson b1();

    SendChatMessageInteractor c();

    SupportApi c0();

    ChatPushHandler d();

    ErrorHandler d0();

    RequestReplySuggestionsInteractor e();

    LocationStorageCleaner e0();

    OrdersCache f();

    VoipService f1();

    ChatRepo g();

    TokenProvider h0();

    OnBoardingManager i1();

    HtmlEngine j0();

    DriverDestinationsManager j1();

    SurgeManager k1();

    EarningsGoalApi l0();

    ChatAnalytics n0();

    OkHttpClient o0();

    GeoLocationManager o1();

    VectorTileBitmapPool p0();

    CampaignAnalytics p1();

    WorkingTimeManager q();

    VoipRxLifecycleTransfromer q0();

    LogManager r1();

    EarningsBalanceApi s();

    SoundEffectsPool s0();

    PushNotificationManager t0();

    NotRespondReporter t1();

    HistoryAnalytics u();

    OrderFlowAnalytics u1();

    PushManagerImpl v();

    DateTimeFormatter v1();

    MapProvider w();

    QuickAccessStateAnalytics w1();

    NavigationAppTypeFactory y();

    SimpleXmlConverterFactory y0();

    AppPerformanceAnalytics y1();
}
