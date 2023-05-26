package ee.mtakso.driver.di.anonymous;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.log.LogWorker;
import ee.mtakso.driver.log.applog.AppLogWatcher;
import ee.mtakso.driver.log.bigquery.BigQueryLogWatcher;
import ee.mtakso.driver.log.storage.DatabaseManager;
import ee.mtakso.driver.log.strategy.memory.OrderStateStrategy;
import ee.mtakso.driver.log.strategy.memory.WebViewStrategy;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.network.client.ShardApiProvider;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthApi;
import ee.mtakso.driver.network.client.auth.anonymous.DriverAuthAnonymousApi;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthApi;
import ee.mtakso.driver.network.client.device.DeviceInfoApi;
import ee.mtakso.driver.network.client.driver.DriverConfigurationApi;
import ee.mtakso.driver.network.client.partner.PartnerClient;
import ee.mtakso.driver.network.client.registration.DriverRegistrationApi;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.platform.ads.AdvertiserIdProvider;
import ee.mtakso.driver.platform.check.PlatformAvailabilityManager;
import ee.mtakso.driver.platform.installation.InstallationIdProvider;
import ee.mtakso.driver.service.analytics.controller.MixpanelController;
import ee.mtakso.driver.service.analytics.event.AnalyticsManager;
import ee.mtakso.driver.service.analytics.event.facade.AppVerificationAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DriverAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SignUpAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.service.auth.TempDriverConfigHolder;
import ee.mtakso.driver.service.chat.ChatService;
import ee.mtakso.driver.service.deviceinfo.DeviceInfoSender;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.integration.appsflyer.AppsflyerManager;
import ee.mtakso.driver.service.modules.polling.Poller;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.restriction.DriverTrainingRestrictionManager;
import ee.mtakso.driver.service.restriction.EnvironmentDataProvider;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.service.session.SessionProvider;
import ee.mtakso.driver.service.token.PartnerTokenManager;
import ee.mtakso.driver.service.token.TokenManager;
import ee.mtakso.driver.ui.screens.home.v3.DeeplinkHomeContainerCoordinator;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.translation.TranslationManager;
import eu.bolt.driver.verification.identity.VerificationAnalytics;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: AnonymousComponent.kt */
/* loaded from: classes3.dex */
public interface AnonymousModuleDeps {
    Context A0();

    OrderProvider B0();

    DeviceInfoApi C();

    DeeplinkHomeContainerCoordinator C1();

    DatabaseManager D0();

    PackageManager E1();

    DriverTrainingRestrictionManager F();

    OrderStateStrategy F0();

    ChatService F1();

    InstallationIdProvider G0();

    EnvironmentDataProvider I1();

    DeviceInfoSender J0();

    ScreenAnalytics J1();

    DeviceSettings M();

    MixpanelController O0();

    CoroutineDispatcher O1();

    DriverAuthAnonymousApi P();

    VerificationAnalytics P1();

    DriverManager Q0();

    ResponseErrorProcessor Q1();

    AppLogWatcher R();

    ShardApiProvider T0();

    TokenManager T1();

    TempDriverConfigHolder U();

    TranslationManager X0();

    DeepLinkManager Z();

    DriverRegistrationApi Z0();

    SignUpAnalytics a0();

    AuthenticatedAuthApi b0();

    DriverAnalytics d1();

    PartnerTokenManager e1();

    WebViewStrategy f0();

    AppRoutingManager g0();

    SessionProvider h1();

    LoginAnalytics i();

    PermissionManager i0();

    AppVerificationAnalytics k0();

    DeviceInfo l();

    DriverConfigurationApi l1();

    StartUpTracing m();

    NotificationManager m0();

    LogWorker m1();

    AnonymousAuthApi o();

    AdvertiserIdProvider p();

    BigQueryLogWatcher r();

    PartnerClient r0();

    WebViewAnalytics s1();

    Poller u0();

    AnalyticsManager x0();

    AppsflyerManager x1();

    Features z();

    DriverStatusProvider z0();

    PlatformAvailabilityManager z1();
}
