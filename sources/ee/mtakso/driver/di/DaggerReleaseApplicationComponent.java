package ee.mtakso.driver.di;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.PowerManager;
import android.view.WindowManager;
import androidx.lifecycle.ViewModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapBuilder;
import dagger.internal.MapFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import ee.mtakso.App;
import ee.mtakso.App_MembersInjector;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.deeplink.DeepLinkParser;
import ee.mtakso.driver.di.ReleaseApplicationComponent;
import ee.mtakso.driver.di.application.CoroutinesDispatcherModule;
import ee.mtakso.driver.di.application.CoroutinesDispatcherModule_ProvideIoDispatcherFactory;
import ee.mtakso.driver.di.application.DriverChatApplicationModule;
import ee.mtakso.driver.di.application.DriverChatApplicationModule_ProvideChatKitDependenciesFactory;
import ee.mtakso.driver.di.application.DriverChatApplicationModule_ProvideChatManagerFactory;
import ee.mtakso.driver.di.module.ReleaseGeoModule;
import ee.mtakso.driver.di.module.ReleaseGeoModule_ProvideGeoLocationManagerFactory;
import ee.mtakso.driver.di.modules.AnalyticsModule_ProvideFirebaseAnalyticsFactory;
import ee.mtakso.driver.di.modules.AnalyticsModule_ProvideLoggingConsumerFactory;
import ee.mtakso.driver.di.modules.AnalyticsModule_ProvideLoggingTimedConsumerFactory;
import ee.mtakso.driver.di.modules.AndroidModule_ProvideNotificationManagerFactory;
import ee.mtakso.driver.di.modules.AndroidModule_ProvidePackageInfoFactory;
import ee.mtakso.driver.di.modules.AndroidModule_ProvideWindowManagerFactory;
import ee.mtakso.driver.di.modules.AndroidModule_ProvidesConnectivityManagerFactory;
import ee.mtakso.driver.di.modules.AndroidModule_ProvidesPackageManagerFactory;
import ee.mtakso.driver.di.modules.AndroidModule_ProvidesPowerManagerFactory;
import ee.mtakso.driver.di.modules.GeoModule_ProvideLocationDaoFactory;
import ee.mtakso.driver.di.modules.GeoModule_ProvideLocationDatabaseFactory;
import ee.mtakso.driver.di.modules.HtmlEngineModule;
import ee.mtakso.driver.di.modules.HtmlEngineModule_ProvidesHtmlEngineFactory;
import ee.mtakso.driver.di.modules.HtmlEngineModule_ProvidesHtmlEngineLoggerFactory;
import ee.mtakso.driver.di.modules.HtmlEngineModule_ProvidesHtmlFontMapperFactory;
import ee.mtakso.driver.di.modules.LogsModule;
import ee.mtakso.driver.di.modules.LogsModule_ProvideApplogUploaderFactory;
import ee.mtakso.driver.di.modules.MapModule;
import ee.mtakso.driver.di.modules.MapModule_ProvideMapV2Factory;
import ee.mtakso.driver.di.modules.NetworkModule;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideAnonymousOkHttpFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideApplogOkHttpFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideAuthorizedOkHttpFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideContactApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideDriverAppLogAnonymousApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideDriverAuthAnonymousApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideDriverConfigurationApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideDriverWorkTimeApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideEarningsBalanceApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideEarningsGoalApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideGsonFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideJaxbConverterFactoryFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideNewEarningsApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidePartnerAuthorisedOkHttpFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidePartnerBoltDriverVerificationRetrofitBuilderFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideSerializerFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideSimpleOkHttpFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideTranslationUpaterFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvideUploadAudioOkHttpFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidesApiPartnerAuthenticationFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidesApiWithoutAuthenticationFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidesAuthApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidesChatApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidesDeviceInfoApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidesDriverRegistrationApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidesEventApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidesFindSolutionApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidesGsonConverterFactoryFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidesIncidentReportingApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidesLeadEventApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidesTranslationApiFactory;
import ee.mtakso.driver.di.modules.NetworkModule_ProvidesUploadAudioApiFactory;
import ee.mtakso.driver.di.modules.ReleaseDeviceInfoModule;
import ee.mtakso.driver.di.modules.ReleaseDeviceInfoModule_ProvidesDeviceInfoFactory;
import ee.mtakso.driver.di.modules.ReleaseNetworkModule;
import ee.mtakso.driver.di.modules.ReleaseNetworkModule_ProvideReleaseBaseNetworkClientFactory;
import ee.mtakso.driver.di.modules.ServiceModule_BindsDeepLinkManagerFactory;
import ee.mtakso.driver.di.modules.ServiceModule_BindsDeepLinkParserFactory;
import ee.mtakso.driver.di.modules.ServiceModule_ProvidesAnchoredTrueTimeProviderFactory;
import ee.mtakso.driver.di.modules.TimingHooks;
import ee.mtakso.driver.di.modules.TimingHooks_Factory;
import ee.mtakso.driver.di.modules.UtilsModule;
import ee.mtakso.driver.di.modules.UtilsModule_ProvideDefaultFragmentFactoryFactory;
import ee.mtakso.driver.di.modules.UtilsModule_ProvidePermissionInitiatorTrackerFactory;
import ee.mtakso.driver.di.modules.UtilsModule_ProvidesAutoStartPermissionHelperFactory;
import ee.mtakso.driver.di.modules.UtilsModule_ProvidesCustomNotificationManagerHelperFactory;
import ee.mtakso.driver.di.modules.UtilsModule_ProvidesOtherPermissionHelperFactory;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.features.Features_Factory;
import ee.mtakso.driver.helper.AutoStartPermissionHelper;
import ee.mtakso.driver.helper.CustomNotificationManagerHelper;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.helper.DateTimeConverter_Factory;
import ee.mtakso.driver.helper.NotificationSoundPermissionHelper;
import ee.mtakso.driver.helper.OtherPermissionHelper;
import ee.mtakso.driver.identity.verification.IdentityVerificationCoordinator;
import ee.mtakso.driver.identity.verification.IdentityVerificationManager;
import ee.mtakso.driver.identity.verification.IdentityVerificationManager_Factory;
import ee.mtakso.driver.identity.verification.PartnerIdentityVerificationInitializer;
import ee.mtakso.driver.identity.verification.PartnerIdentityVerificationInitializer_Factory;
import ee.mtakso.driver.log.CrashlyticsConsumer;
import ee.mtakso.driver.log.CrashlyticsConsumer_Factory;
import ee.mtakso.driver.log.InternalLog;
import ee.mtakso.driver.log.InternalLog_Factory;
import ee.mtakso.driver.log.LogManager;
import ee.mtakso.driver.log.LogManager_Factory;
import ee.mtakso.driver.log.LogWorker;
import ee.mtakso.driver.log.LogWorker_Factory;
import ee.mtakso.driver.log.applog.AppLogWatcher;
import ee.mtakso.driver.log.applog.AppLogWatcher_Factory;
import ee.mtakso.driver.log.applog.ApplogFactory_Factory;
import ee.mtakso.driver.log.applog.ApplogUploader;
import ee.mtakso.driver.log.bigquery.BigQueryLogWatcher;
import ee.mtakso.driver.log.bigquery.BigQueryLogWatcher_Factory;
import ee.mtakso.driver.log.bigquery.BigQueryUploader;
import ee.mtakso.driver.log.bigquery.BigQueryUploader_Factory;
import ee.mtakso.driver.log.report.FirebaseReportManager;
import ee.mtakso.driver.log.report.FirebaseReportManager_Factory;
import ee.mtakso.driver.log.report.ReportManager;
import ee.mtakso.driver.log.storage.DatabaseManager;
import ee.mtakso.driver.log.storage.DatabaseManager_Factory;
import ee.mtakso.driver.log.strategy.memory.OrderStateStrategy;
import ee.mtakso.driver.log.strategy.memory.OrderStateStrategy_Factory;
import ee.mtakso.driver.log.strategy.memory.WebViewStrategy;
import ee.mtakso.driver.log.strategy.memory.WebViewStrategy_Factory;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.navigation.DynamicNavigationProvider;
import ee.mtakso.driver.navigation.DynamicNavigationProvider_Factory;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory_Factory;
import ee.mtakso.driver.navigation.NavigationManager;
import ee.mtakso.driver.navigation.NavigationManager_Factory;
import ee.mtakso.driver.navigation.navigators.CityGuideNavigator;
import ee.mtakso.driver.navigation.navigators.CityGuideNavigator_Factory;
import ee.mtakso.driver.navigation.navigators.GoogleMapsNavigator;
import ee.mtakso.driver.navigation.navigators.GoogleMapsNavigator_Factory;
import ee.mtakso.driver.navigation.navigators.MapsMeNavigator;
import ee.mtakso.driver.navigation.navigators.MapsMeNavigator_Factory;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.navigation.navigators.NoDefaultNavigator;
import ee.mtakso.driver.navigation.navigators.NoDefaultNavigator_Factory;
import ee.mtakso.driver.navigation.navigators.TaxifyNavigator;
import ee.mtakso.driver.navigation.navigators.TaxifyNavigator_Factory;
import ee.mtakso.driver.navigation.navigators.TwoGisNavigator;
import ee.mtakso.driver.navigation.navigators.TwoGisNavigator_Factory;
import ee.mtakso.driver.navigation.navigators.WazeNavigator;
import ee.mtakso.driver.navigation.navigators.WazeNavigator_Factory;
import ee.mtakso.driver.navigation.navigators.YandexMapsNavigator;
import ee.mtakso.driver.navigation.navigators.YandexMapsNavigator_Factory;
import ee.mtakso.driver.navigation.navigators.YandexNavigationNavigator;
import ee.mtakso.driver.navigation.navigators.YandexNavigationNavigator_Factory;
import ee.mtakso.driver.network.ApiExceptionProvider;
import ee.mtakso.driver.network.ClientFactory;
import ee.mtakso.driver.network.ClientFactory_Factory;
import ee.mtakso.driver.network.cache.CacheProvider;
import ee.mtakso.driver.network.cache.CacheProvider_Factory;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.ApiFactory_Factory;
import ee.mtakso.driver.network.client.ShardApiProvider;
import ee.mtakso.driver.network.client.ShardApiProvider_Factory;
import ee.mtakso.driver.network.client.analytics.AnalyticsApi;
import ee.mtakso.driver.network.client.analytics.AnalyticsClient;
import ee.mtakso.driver.network.client.analytics.AnalyticsClient_Factory;
import ee.mtakso.driver.network.client.analytics.LeadAnalyticsApi;
import ee.mtakso.driver.network.client.applog.AppLogClient;
import ee.mtakso.driver.network.client.applog.AppLogClient_Factory;
import ee.mtakso.driver.network.client.applog.ApplogParamsInterceptor;
import ee.mtakso.driver.network.client.applog.ApplogParamsInterceptor_Factory;
import ee.mtakso.driver.network.client.applog.DriverAppLogAnonymousApi;
import ee.mtakso.driver.network.client.audio_recording.upload.AudioRecordingUploadAPI;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthApi;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient_Factory;
import ee.mtakso.driver.network.client.auth.anonymous.DriverAuthAnonymousApi;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthApi;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient_Factory;
import ee.mtakso.driver.network.client.contact.ContactApi;
import ee.mtakso.driver.network.client.device.DeviceInfoApi;
import ee.mtakso.driver.network.client.device.DeviceInfoClient;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.DriverClient_Factory;
import ee.mtakso.driver.network.client.driver.DriverConfigurationApi;
import ee.mtakso.driver.network.client.driver.DriverConfigurationClient;
import ee.mtakso.driver.network.client.driver.DriverConfigurationClient_Factory;
import ee.mtakso.driver.network.client.fleet.FleetClient;
import ee.mtakso.driver.network.client.fleet.FleetClient_Factory;
import ee.mtakso.driver.network.client.incident.IncidentReportingApi;
import ee.mtakso.driver.network.client.incident.IncidentReportingClient;
import ee.mtakso.driver.network.client.incident.IncidentReportingClient_Factory;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.network.client.order.OrderClient_Factory;
import ee.mtakso.driver.network.client.partner.PartnerApi;
import ee.mtakso.driver.network.client.partner.PartnerClient;
import ee.mtakso.driver.network.client.partner.PartnerClient_Factory;
import ee.mtakso.driver.network.client.registration.DriverRegistrationApi;
import ee.mtakso.driver.network.client.registration.DriverRegistrationClient;
import ee.mtakso.driver.network.client.registration.DriverRegistrationClient_Factory;
import ee.mtakso.driver.network.client.settings.SettingsClient;
import ee.mtakso.driver.network.client.settings.SettingsClient_Factory;
import ee.mtakso.driver.network.client.support.SupportApi;
import ee.mtakso.driver.network.client.translations.TranslationApi;
import ee.mtakso.driver.network.client.translations.TranslationsClient;
import ee.mtakso.driver.network.client.translations.TranslationsClient_Factory;
import ee.mtakso.driver.network.client.work_time.DriverWorkTimeApi;
import ee.mtakso.driver.network.exception.ApiExceptionFactory_Factory;
import ee.mtakso.driver.network.interceptor.AccessTokenInterceptor;
import ee.mtakso.driver.network.interceptor.AccessTokenInterceptor_Factory;
import ee.mtakso.driver.network.interceptor.HttpErrorInterceptor;
import ee.mtakso.driver.network.interceptor.HttpErrorInterceptor_Factory;
import ee.mtakso.driver.network.interceptor.LocationInterceptor;
import ee.mtakso.driver.network.interceptor.LocationInterceptor_Factory;
import ee.mtakso.driver.network.interceptor.LoggingInterceptor;
import ee.mtakso.driver.network.interceptor.LoggingInterceptor_Factory;
import ee.mtakso.driver.network.interceptor.PartnerAccessTokenInterceptor;
import ee.mtakso.driver.network.interceptor.PartnerAccessTokenInterceptor_Factory;
import ee.mtakso.driver.network.interceptor.StandardParamsInterceptors;
import ee.mtakso.driver.network.interceptor.StandardParamsInterceptors_Factory;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.network.response.CompositeResponseTransformer_Factory;
import ee.mtakso.driver.network.response.ExposeResponseTransformer;
import ee.mtakso.driver.network.response.ExposeResponseTransformer_Factory;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.network.response.ResponseErrorProcessor_Factory;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import ee.mtakso.driver.onboarding.steps.AutoStartPermissionStep;
import ee.mtakso.driver.onboarding.steps.BatteryExclusionPermissionStep;
import ee.mtakso.driver.onboarding.steps.NotificationPermissionStep;
import ee.mtakso.driver.onboarding.steps.NotificationSoundStep;
import ee.mtakso.driver.onboarding.steps.OnBoardingStep;
import ee.mtakso.driver.onboarding.steps.OtherPermissionsStep;
import ee.mtakso.driver.onboarding.steps.OverlayPermissionStep;
import ee.mtakso.driver.onboarding.steps.RecordAudioPermissionStep;
import ee.mtakso.driver.param.ChatSettingsManager;
import ee.mtakso.driver.param.ChatSettingsManager_Factory;
import ee.mtakso.driver.param.DeviceFeatures;
import ee.mtakso.driver.param.DeviceFeatures_Factory;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.param.DeviceSettings_Factory;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverProvider_Factory;
import ee.mtakso.driver.param.DriverReferralCampaignManager;
import ee.mtakso.driver.param.TargetingUpdateManager;
import ee.mtakso.driver.param.TargetingUpdateManager_Factory;
import ee.mtakso.driver.param.storage.BoltPrefsStorageMigration;
import ee.mtakso.driver.param.storage.BoltPrefsStorageMigration_Factory;
import ee.mtakso.driver.platform.ads.AdvertiserIdProvider;
import ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever;
import ee.mtakso.driver.platform.check.PlatformAvailabilityManager;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.google.ads.GmsAdvertiserIdProvider;
import ee.mtakso.driver.platform.google.autofill.GmsSmsRetriever;
import ee.mtakso.driver.platform.google.autofill.GmsSmsRetriever_Factory;
import ee.mtakso.driver.platform.google.check.GmsAvailabilityManager;
import ee.mtakso.driver.platform.google.check.GmsAvailabilityManager_Factory;
import ee.mtakso.driver.platform.google.core.GmsPlatformManager;
import ee.mtakso.driver.platform.google.core.GmsPlatformManager_Factory;
import ee.mtakso.driver.platform.google.geo.GmsLocationSource;
import ee.mtakso.driver.platform.google.geo.GmsLocationSource_Factory;
import ee.mtakso.driver.platform.google.installation.FirebaseInstallationIdProvider;
import ee.mtakso.driver.platform.google.network.store_integrity.PlayStoreVerificationResultToRequestMapper;
import ee.mtakso.driver.platform.google.network.store_integrity.PlayStoreVerificationResultToRequestMapper_Factory;
import ee.mtakso.driver.platform.google.push.FirebasePushTokenManager;
import ee.mtakso.driver.platform.google.push.FirebasePushTokenManager_Factory;
import ee.mtakso.driver.platform.google.security.GmsSecurityManager;
import ee.mtakso.driver.platform.google.store_integrity.GoogleIntegrityCheck;
import ee.mtakso.driver.platform.google.store_integrity.GoogleIntegrityCheck_Factory;
import ee.mtakso.driver.platform.installation.InstallationIdProvider;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultToRequestMapper;
import ee.mtakso.driver.platform.push.PushManager;
import ee.mtakso.driver.platform.push.TokenProvider;
import ee.mtakso.driver.platform.security.SecurityManager;
import ee.mtakso.driver.platform.store_integrity.StoreIntegrityCheck;
import ee.mtakso.driver.service.AwakeService;
import ee.mtakso.driver.service.AwakeService_MembersInjector;
import ee.mtakso.driver.service.analytics.controller.MixpanelController;
import ee.mtakso.driver.service.analytics.controller.MixpanelController_Factory;
import ee.mtakso.driver.service.analytics.event.AnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.AnalyticsImpl;
import ee.mtakso.driver.service.analytics.event.AnalyticsImpl_Factory;
import ee.mtakso.driver.service.analytics.event.AnalyticsManager;
import ee.mtakso.driver.service.analytics.event.AnalyticsManager_Factory;
import ee.mtakso.driver.service.analytics.event.consumer.CrashlyticsAnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.consumer.CrashlyticsAnalyticsConsumer_Factory;
import ee.mtakso.driver.service.analytics.event.consumer.FirebaseAnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.consumer.FirebaseAnalyticsConsumer_Factory;
import ee.mtakso.driver.service.analytics.event.consumer.InternalAnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.consumer.InternalAnalyticsConsumer_Factory;
import ee.mtakso.driver.service.analytics.event.consumer.LeadInternalAnalyticsConsumer;
import ee.mtakso.driver.service.analytics.event.consumer.LeadInternalAnalyticsConsumer_Factory;
import ee.mtakso.driver.service.analytics.event.consumer.LoggingAnalyticsConsumer_Factory;
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
import ee.mtakso.driver.service.analytics.timed.TimedAnalyticsImpl;
import ee.mtakso.driver.service.analytics.timed.TimedAnalyticsImpl_Factory;
import ee.mtakso.driver.service.analytics.timed.TimedAnalyticsManager;
import ee.mtakso.driver.service.analytics.timed.TimedAnalyticsManager_Factory;
import ee.mtakso.driver.service.analytics.timed.TimedConsumer;
import ee.mtakso.driver.service.analytics.timed.consumer.firebase.FirebaseTimedConsumer;
import ee.mtakso.driver.service.analytics.timed.consumer.firebase.FirebaseTimedConsumer_Factory;
import ee.mtakso.driver.service.analytics.timed.consumer.log.LoggingTimedConsumer_Factory;
import ee.mtakso.driver.service.analytics.timed.facade.OrderTracing;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.service.auth.AuthConfigurationBackoffStrategy;
import ee.mtakso.driver.service.auth.AuthConfigurationBackoffStrategy_Factory;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthManager_Factory;
import ee.mtakso.driver.service.auth.AuthStepFactory;
import ee.mtakso.driver.service.auth.AuthStepFactory_Factory;
import ee.mtakso.driver.service.auth.FullAuthFlow;
import ee.mtakso.driver.service.auth.FullAuthFlow_Factory;
import ee.mtakso.driver.service.auth.LightAuthFlow;
import ee.mtakso.driver.service.auth.StoreVerificationBackoffStrategy;
import ee.mtakso.driver.service.auth.StoreVerificationBackoffStrategy_Factory;
import ee.mtakso.driver.service.auth.TempDriverConfigHolder;
import ee.mtakso.driver.service.auth.TempDriverConfigHolder_Factory;
import ee.mtakso.driver.service.chat.ChatActiveOrderSource;
import ee.mtakso.driver.service.chat.ChatConfigManager;
import ee.mtakso.driver.service.chat.ChatConfigManager_Factory;
import ee.mtakso.driver.service.chat.ChatNetworkInfoProvider;
import ee.mtakso.driver.service.chat.ChatService;
import ee.mtakso.driver.service.chat.ChatService_Factory;
import ee.mtakso.driver.service.chat.ChatTerminationMessageProvider;
import ee.mtakso.driver.service.chat.ChatTerminationMessageProvider_Factory;
import ee.mtakso.driver.service.chat.DriverChatUserInfoProvider;
import ee.mtakso.driver.service.chat.DriverChatUserInfoProvider_Factory;
import ee.mtakso.driver.service.connectivity.ConnectionMessageManager;
import ee.mtakso.driver.service.connectivity.ConnectionMessageManager_Factory;
import ee.mtakso.driver.service.connectivity.NetworkService;
import ee.mtakso.driver.service.connectivity.NetworkService_Factory;
import ee.mtakso.driver.service.deviceinfo.DeviceInfoSender;
import ee.mtakso.driver.service.deviceinfo.DriverDeviceInfoSender;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.driver.DriverManager_Factory;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.mock.ReleaseMockChecker;
import ee.mtakso.driver.service.geo.mock.ReleaseMockChecker_Factory;
import ee.mtakso.driver.service.geo.storage.LocationStorageCleaner;
import ee.mtakso.driver.service.geo.storage.db.LocationDao;
import ee.mtakso.driver.service.geo.storage.db.LocationDatabase;
import ee.mtakso.driver.service.geo.storage.db.LocationStorageDatabase;
import ee.mtakso.driver.service.geo.storage.db.LocationStorageDatabase_Factory;
import ee.mtakso.driver.service.geo.storage.memory.LocationStorageInMemory_Factory;
import ee.mtakso.driver.service.geo.storage.wrapper.LocationStorageWrapper;
import ee.mtakso.driver.service.geo.storage.wrapper.LocationStorageWrapper_Factory;
import ee.mtakso.driver.service.geo.transmitter.LocationTransmitter;
import ee.mtakso.driver.service.geo.transmitter.LocationTransmitter_Factory;
import ee.mtakso.driver.service.integration.appsflyer.AppsflyerManager;
import ee.mtakso.driver.service.integration.appsflyer.AppsflyerManager_Factory;
import ee.mtakso.driver.service.integration.clevertap.CleverTapCoordinator;
import ee.mtakso.driver.service.integration.clevertap.CleverTapCoordinator_Factory;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager_Factory;
import ee.mtakso.driver.service.language.LanguageListProviderImpl_Factory;
import ee.mtakso.driver.service.language.LanguageSettingsStorageImpl;
import ee.mtakso.driver.service.language.LanguageSettingsStorageImpl_Factory;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager_Factory;
import ee.mtakso.driver.service.modules.incident.IncidentReportingService;
import ee.mtakso.driver.service.modules.incident.IncidentReportingService_Factory;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager_Factory;
import ee.mtakso.driver.service.modules.polling.ActivePollingErrorHandler;
import ee.mtakso.driver.service.modules.polling.ActivePollingErrorHandler_Factory;
import ee.mtakso.driver.service.modules.polling.InactivePollingErrorHandler;
import ee.mtakso.driver.service.modules.polling.InactivePollingErrorHandler_Factory;
import ee.mtakso.driver.service.modules.polling.Poller;
import ee.mtakso.driver.service.modules.polling.PollerFactory;
import ee.mtakso.driver.service.modules.polling.PollerFactory_Factory;
import ee.mtakso.driver.service.modules.polling.PollerImpl;
import ee.mtakso.driver.service.modules.polling.PollerImpl_Factory;
import ee.mtakso.driver.service.modules.polling.PollingRetryStrategy_Factory;
import ee.mtakso.driver.service.modules.reporters.AppReporter;
import ee.mtakso.driver.service.modules.reporters.AppReporter_Factory;
import ee.mtakso.driver.service.modules.reporters.NotRespondReporter;
import ee.mtakso.driver.service.modules.reporters.WrongStateReporter;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import ee.mtakso.driver.service.modules.status.DriverStatusSenderImpl;
import ee.mtakso.driver.service.modules.status.DriverStatusSenderImpl_Factory;
import ee.mtakso.driver.service.modules.status.GoOnlineFlow;
import ee.mtakso.driver.service.modules.status.GoOnlineFlow_Factory;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import ee.mtakso.driver.service.modules.surge.SurgeManager_Factory;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.service.order.details.OrdersCache_Factory;
import ee.mtakso.driver.service.order.routing.IntentProvider;
import ee.mtakso.driver.service.order.routing.IntentProvider_Factory;
import ee.mtakso.driver.service.push.PushHandler;
import ee.mtakso.driver.service.push.PushManagerImpl;
import ee.mtakso.driver.service.push.PushManagerImpl_Factory;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.service.push.PushNotificationManager_Factory;
import ee.mtakso.driver.service.push.PushTokenManager;
import ee.mtakso.driver.service.push.PushTokenManager_Factory;
import ee.mtakso.driver.service.push.handler.CleverTapPushHandler;
import ee.mtakso.driver.service.push.handler.CleverTapPushHandler_Factory;
import ee.mtakso.driver.service.push.handler.DefaultPushHandler;
import ee.mtakso.driver.service.push.handler.DefaultPushHandler_Factory;
import ee.mtakso.driver.service.push.handler.SupportPushHandler;
import ee.mtakso.driver.service.push.handler.SupportPushHandler_Factory;
import ee.mtakso.driver.service.quickaccess.QuickAccessService;
import ee.mtakso.driver.service.quickaccess.QuickAccessService_MembersInjector;
import ee.mtakso.driver.service.restriction.DriverTrainingRestrictionManager;
import ee.mtakso.driver.service.restriction.DriverTrainingRestrictionManager_Factory;
import ee.mtakso.driver.service.restriction.EnvironmentDataProvider;
import ee.mtakso.driver.service.restriction.MockEnvironmentDataProvider;
import ee.mtakso.driver.service.restriction.MockEnvironmentDataProvider_Factory;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.service.routing.AppRoutingManager_Factory;
import ee.mtakso.driver.service.session.SessionProvider;
import ee.mtakso.driver.service.session.SessionProvider_Factory;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.service.settings.DispatchSettingsManager_Factory;
import ee.mtakso.driver.service.time.AnchoredTrueTimeProvider;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.service.token.PartnerTokenManager;
import ee.mtakso.driver.service.token.PartnerTokenManager_Factory;
import ee.mtakso.driver.service.token.TokenManager;
import ee.mtakso.driver.service.token.TokenManager_Factory;
import ee.mtakso.driver.service.voip.VoipService;
import ee.mtakso.driver.service.voip.VoipService_Factory;
import ee.mtakso.driver.service.voip.effects.VoipEffectsFactory;
import ee.mtakso.driver.service.voip.effects.VoipEffectsFactory_Factory;
import ee.mtakso.driver.service.voip.extractor.VoipInfoExtractorFactoryImpl_Factory;
import ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObservableImpl;
import ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObservableImpl_Factory;
import ee.mtakso.driver.service.voip.lifecycle.VoipLifecycleObserver;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipActiveWindowTracker;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipActiveWindowTracker_Factory;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipProximityManager;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipProximityManager_Factory;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipRxLifecycleTransfromer;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipRxLifecycleTransfromer_Factory;
import ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager.IncomingWindowManager;
import ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager.IncomingWindowManager_Factory;
import ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager.OutgoingWindowManager;
import ee.mtakso.driver.service.voip.lifecycle.observers.windowmanager.OutgoingWindowManager_Factory;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerCallCache;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerCallCache_Factory;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerCallManager;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerCallManager_Factory;
import ee.mtakso.driver.service.workingtime.WorkingTimeManager;
import ee.mtakso.driver.service.workingtime.WorkingTimeManager_Factory;
import ee.mtakso.driver.startup.AnalyticsInitializer;
import ee.mtakso.driver.startup.AnalyticsInitializer_MembersInjector;
import ee.mtakso.driver.startup.LogManagerInitializer;
import ee.mtakso.driver.startup.LogManagerInitializer_MembersInjector;
import ee.mtakso.driver.startup.WorkManagerInitializer;
import ee.mtakso.driver.startup.WorkManagerInitializer_MembersInjector;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity_MembersInjector;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import ee.mtakso.driver.ui.common.internet.InternetDataDelegate;
import ee.mtakso.driver.ui.common.internet.InternetDataDelegate_Factory;
import ee.mtakso.driver.ui.common.map.MapManager;
import ee.mtakso.driver.ui.helper.ErrorHandler;
import ee.mtakso.driver.ui.interactor.warnings.UnauthorizedWarningInteractor;
import ee.mtakso.driver.ui.interactor.warnings.UnauthorizedWarningInteractor_Factory;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.ui.notification.UiNotificationManager_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.service.VoipIntentService;
import ee.mtakso.driver.ui.screens.contact_methods.voip.service.VoipIntentService_MembersInjector;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.cancels.CancelsFragment;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.hours.HoursFragment;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.rides.RidesFragment;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.legacy.rides.RidesFragment_MembersInjector;
import ee.mtakso.driver.ui.screens.home.v3.DeeplinkHomeContainerCoordinator;
import ee.mtakso.driver.ui.screens.home.v3.DeeplinkHomeContainerCoordinator_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.DeeplinkActivityMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.DeeplinkCoordinator;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.DeeplinkHomeRouter;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.DeeplinkHomeRouter_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.BalanceDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.CampaignDetailsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.CampaignListDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.CampaignOptInDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.CampaignRefferralsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.ChatDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.CircleKDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityCancelsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityCancelsDeeplinkMapper_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityDeeplinkMapper_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityHoursDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityHoursDeeplinkMapper_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityTripsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityTripsDeeplinkMapper_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverPortalDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverPortalRootDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverPortalWithHashDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverScoreDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.EarningsBreakdownDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.EarningsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.EarningsGoalDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.FallbackWebPageDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.HomeMapSettingsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.IdentityVerificationDetailsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.LoyaltyOfferDetailsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.LoyaltyOfferDetailsDeeplinkMapper_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.LoyaltyOffersListDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.LoyaltyOffersListDeeplinkMapper_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.NewsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.NewsDeeplinkMapper_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.NewsInboxDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PayoutConfirmationDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PayoutRequirementsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PayoutsDetailsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PayoutsHistoryDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PricingDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PriorityDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PriorityDeeplinkMapper_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.RejectRideDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.RequestWebUrlDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.RideDetailsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.SettingsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.SettingsDeeplinkMapper_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.StoryDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.StoryDeeplinkMapper_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.SupportDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.SupportDeeplinkMapper_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.SupportTicketDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.SupportTicketDeeplinkMapper_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.UpcommingRideDetialsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.UpcommingRidesDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.map.vector.VectorTileBitmapPool;
import ee.mtakso.driver.ui.screens.home.v3.map.vector.VectorTileBitmapPool_Factory;
import ee.mtakso.driver.ui.screens.launch.LauncherActivity;
import ee.mtakso.driver.ui.screens.launch.LauncherActivity_MembersInjector;
import ee.mtakso.driver.ui.screens.launch.LauncherViewModel;
import ee.mtakso.driver.ui.screens.launch.LauncherViewModel_Factory;
import ee.mtakso.driver.ui.screens.login.v2.RouterFragmentCoordinator;
import ee.mtakso.driver.ui.screens.login.v2.RouterFragmentCoordinator_Factory;
import ee.mtakso.driver.ui.screens.order.v2.order.NavigationTargetInteractor;
import ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment;
import ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingFragment_MembersInjector;
import ee.mtakso.driver.ui.screens.settings.MagicLinkInteractor;
import ee.mtakso.driver.ui.screens.settings.MagicLinkInteractor_Factory;
import ee.mtakso.driver.ui.views.quickaccess.QuickAccessPrefsManager;
import ee.mtakso.driver.utils.ActivityLifecycleLoggingManager;
import ee.mtakso.driver.utils.ActivityLifecycleLoggingManager_Factory;
import ee.mtakso.driver.utils.AppResolver;
import ee.mtakso.driver.utils.AppResolver_Factory;
import ee.mtakso.driver.utils.BackgroundManager;
import ee.mtakso.driver.utils.BackgroundManager_Factory;
import ee.mtakso.driver.utils.ChromeCustomTabsUrlLauncher;
import ee.mtakso.driver.utils.ChromeCustomTabsUrlLauncher_Factory;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.CompositeUrlLauncher_Factory;
import ee.mtakso.driver.utils.DeviceUuidManager;
import ee.mtakso.driver.utils.DeviceUuidManager_Factory;
import ee.mtakso.driver.utils.SystemUrlLauncher;
import ee.mtakso.driver.utils.SystemUrlLauncher_Factory;
import ee.mtakso.driver.utils.UrlFactory;
import ee.mtakso.driver.utils.UrlFactory_Factory;
import ee.mtakso.driver.utils.coroutines.DispatcherProvider_Factory;
import ee.mtakso.driver.utils.customtabs.CustomTabsUrlLauncher;
import ee.mtakso.driver.utils.customtabs.CustomTabsUrlLauncher_Factory;
import ee.mtakso.driver.utils.logs.LogsUploaderImpl;
import ee.mtakso.driver.utils.logs.LogsUploaderImpl_Factory;
import ee.mtakso.driver.utils.logs.PersistPoeg_Factory;
import ee.mtakso.driver.utils.power.WakeLockManager;
import ee.mtakso.driver.utils.power.WakeLockManager_Factory;
import ee.mtakso.driver.utils.retry.StandardExponentialBackoffStrategy;
import ee.mtakso.driver.utils.retry.StandardExponentialBackoffStrategy_Factory;
import ee.mtakso.driver.utils.urlcomand.DriverPortalUrlCoordinator;
import ee.mtakso.driver.utils.urlcomand.DriverPortalUrlCoordinator_Factory;
import ee.mtakso.driver.utils.urlcomand.UrlCoordinator;
import ee.mtakso.driver.utils.urlcomand.UrlCoordinator_Factory;
import ee.mtakso.driver.work.WorkerFactorImpl;
import eu.bolt.android.chat.ChatDependencyProvider;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.engine.html.font.HtmlFontMapper;
import eu.bolt.android.engine.html.logger.Logger;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.chat.chatcore.ChatKit;
import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.interactor.CreateChatInteractor;
import eu.bolt.chat.chatcore.interactor.ReadMessageInteractor;
import eu.bolt.chat.chatcore.interactor.RequestReplySuggestionsInteractor;
import eu.bolt.chat.chatcore.interactor.SendChatMessageInteractor;
import eu.bolt.chat.chatcore.push.ChatPushHandler;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.driver.chat.helper.SoundEffectsPool;
import eu.bolt.driver.chat.helper.SoundEffectsPool_Factory;
import eu.bolt.driver.chat.network.ChatApi;
import eu.bolt.driver.chat.network.ChatClient;
import eu.bolt.driver.chat.service.ChatManager;
import eu.bolt.driver.chat.service.foreground.ChatForegroundProvider;
import eu.bolt.driver.chat.service.foreground.ChatForegroundProvider_Factory;
import eu.bolt.driver.chat.service.id.ChatIdGenerator;
import eu.bolt.driver.chat.service.repo.ActiveChatsMapper;
import eu.bolt.driver.chat.service.repo.MessageTranslationRatingMapper;
import eu.bolt.driver.chat.service.rx.ChatRxSchedulers;
import eu.bolt.driver.chat.ui.ChatForegroundTracker;
import eu.bolt.driver.chat.ui.ChatForegroundTracker_Factory;
import eu.bolt.driver.chat.ui.notification.ChatNotificationManager;
import eu.bolt.driver.chat.ui.notification.ChatNotificationManager_Factory;
import eu.bolt.driver.core.permission.PermissionInitiatorTracker;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.permission.PermissionManager_Factory;
import eu.bolt.driver.core.storage.StorageFactory;
import eu.bolt.driver.core.storage.StorageFactory_Factory;
import eu.bolt.driver.core.time.SystemUptimeSource;
import eu.bolt.driver.core.time.SystemUptimeSource_Factory;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.RoutingManager_Factory;
import eu.bolt.driver.core.ui.routing.coordinator.ActivitiesStackClassCoordinator;
import eu.bolt.driver.core.ui.routing.coordinator.ActivityClassCoordinator;
import eu.bolt.driver.core.ui.routing.coordinator.ActivityIntentCoordinator;
import eu.bolt.driver.core.ui.routing.coordinator.DialogFragmentCoordinator;
import eu.bolt.driver.core.ui.routing.state.StateTracker;
import eu.bolt.driver.core.ui.translation.RawTranslationProvider;
import eu.bolt.driver.core.ui.translation.RawTranslationProvider_Factory;
import eu.bolt.driver.core.ui.translation.TranslationManager;
import eu.bolt.driver.core.ui.translation.TranslationManager_Factory;
import eu.bolt.driver.core.ui.translation.TranslationUpdateProvider;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import eu.bolt.driver.core.ui.translation.language.LanguageManager_Factory;
import eu.bolt.driver.core.util.DateTimeFormatter;
import eu.bolt.driver.core.util.DateTimeFormatter_Factory;
import eu.bolt.driver.earnings.network.EarningsApi;
import eu.bolt.driver.earnings.network.EarningsBalanceApi;
import eu.bolt.driver.earnings.network.EarningsGoalApi;
import eu.bolt.driver.stories.StoryManager_Factory;
import eu.bolt.driver.verification.identity.VerificationAnalytics;
import eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.OkHttpClient;
import org.simpleframework.xml.Serializer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@DaggerGenerated
/* loaded from: classes3.dex */
public final class DaggerReleaseApplicationComponent {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Builder implements ReleaseApplicationComponent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private App f20031a;

        /* renamed from: b  reason: collision with root package name */
        private ChatDependencyProvider f20032b;

        private Builder() {
        }

        @Override // ee.mtakso.driver.di.ReleaseApplicationComponent.Builder, ee.mtakso.driver.di.modules.ApplicationComponent.Builder
        /* renamed from: c */
        public Builder a(App app) {
            this.f20031a = (App) Preconditions.checkNotNull(app);
            return this;
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent.Builder
        /* renamed from: d */
        public Builder b(ChatDependencyProvider chatDependencyProvider) {
            this.f20032b = (ChatDependencyProvider) Preconditions.checkNotNull(chatDependencyProvider);
            return this;
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent.Builder
        /* renamed from: e */
        public ReleaseApplicationComponent build() {
            Preconditions.checkBuilderRequirement(this.f20031a, App.class);
            Preconditions.checkBuilderRequirement(this.f20032b, ChatDependencyProvider.class);
            return new ReleaseApplicationComponentImpl(new CoroutinesDispatcherModule(), new DriverChatApplicationModule(), new LogsModule(), new MapModule(), new PlatformModule(), new ReleaseDeviceInfoModule(), new ReleaseGeoModule(), new ReleaseNetworkModule(), new NetworkModule(), new UtilsModule(), new HtmlEngineModule(), this.f20032b, this.f20031a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ReleaseApplicationComponentImpl implements ReleaseApplicationComponent {
        private Provider<GmsPlatformManager> A;
        private Provider<PartnerClient> A0;
        private Provider<BackgroundManager> A1;
        private Provider<NavigationManager> A2;
        private Provider<CompositeUrlLauncher> A3;
        private Provider<AnalyticsImpl> B;
        private Provider<PushTokenManager> B0;
        private Provider<PollerFactory> B1;
        private Provider<VoipRxLifecycleTransfromer> B2;
        private Provider<MagicLinkInteractor> B3;
        private Provider<SessionProvider> C;
        private Provider<DriverTrainingRestrictionManager> C0;
        private Provider<ActivePollingErrorHandler> C1;
        private Provider<IncidentReportingApi> C2;
        private Provider<DriverPortalUrlCoordinator> C3;
        private Provider<LanguageSettingsStorageImpl> D;
        private Provider<DeepLinkParser> D0;
        private Provider<RoutingManager> D1;
        private Provider<IncidentReportingClient> D2;
        private Provider<DriverRegistrationClient> D3;
        private Provider<LanguageManager> E;
        private Provider<DeepLinkManager> E0;
        private Provider<InactivePollingErrorHandler> E1;
        private Provider<IncidentReportingService> E2;
        private Provider<GmsAvailabilityManager> E3;
        private Provider<StandardParamsInterceptors> F;
        private Provider<SettingsDeeplinkMapper> F0;
        private Provider<PollerImpl> F1;
        private Provider<SoundEffectsPool> F2;
        private Provider<GoogleIntegrityCheck> F3;
        private Provider<ApplogParamsInterceptor> G;
        private Provider<NewsDeeplinkMapper> G0;
        private Provider<DriverRegistrationApi> G1;
        private Provider<ContactApi> G2;
        private Provider<AuthConfigurationBackoffStrategy> G3;
        private Provider<LoggingInterceptor> H;
        private Provider<DeeplinkHomeRouter> H0;
        private Provider<DeviceInfoApi> H1;
        private Provider<CrashlyticsConsumer> H2;
        private Provider<AuthStepFactory> H3;
        private Provider<CacheProvider> I;
        private Provider<DeeplinkHomeContainerCoordinator> I0;
        private Provider<CleverTapManager> I1;
        private Provider<LogManager> I2;
        private Provider<FullAuthFlow> I3;
        private Provider<ResponseErrorProcessor> J;
        private Provider<OkHttpClient> J0;
        private Provider<CleverTapPushHandler> J1;
        private Provider<NoAnswerCallCache> J2;
        private Provider<InternetDataDelegate> J3;
        private Provider<HttpErrorInterceptor> K;
        private Provider<TranslationApi> K0;
        private Provider<IntentProvider> K1;
        private Provider<NoAnswerCallManager> K2;
        private Provider<ConnectionMessageManager> K3;
        private Provider<ClientFactory> L;
        private Provider<TranslationsClient> L0;
        private Provider<NotificationManager> L1;
        private Provider<IncomingWindowManager> L2;
        private Provider<UnauthorizedWarningInteractor> L3;
        private Provider<OkHttpClient> M;
        private Provider<TranslationUpdateProvider> M0;
        private Provider<UiNotificationManager> M1;
        private Provider<PowerManager> M2;
        private Provider<TimedAnalyticsImpl> M3;
        private Provider<GmsLocationSource> N;
        private Provider<TranslationManager> N0;
        private Provider<PushNotificationManager> N1;
        private Provider<WakeLockManager> N2;
        private Provider<LauncherViewModel> N3;
        private Provider<ReleaseMockChecker> O;
        private Provider<Set<TimedConsumer>> O0;
        private Provider<DefaultPushHandler> O1;
        private Provider<VoipProximityManager> O2;
        private Provider<LogsUploaderImpl> O3;
        private Provider<PermissionInitiatorTracker> P;
        private Provider<FirebaseTimedConsumer> P0;
        private Provider<SupportPushHandler> P1;
        private Provider<Set<VoipLifecycleObserver>> P2;
        private Provider<PermissionManager> Q;
        private Provider<Set<TimedConsumer>> Q0;
        private Provider<Set<PushHandler>> Q1;
        private Provider<OutgoingWindowManager> Q2;
        private Provider<GeoLocationManager> R;
        private Provider<TimedAnalyticsManager> R0;
        private Provider<PushManagerImpl> R1;
        private Provider<Set<VoipLifecycleObserver>> R2;
        private Provider<LocationInterceptor> S;
        private Provider<MixpanelController> S0;
        private Provider<TempDriverConfigHolder> S1;
        private Provider<VoipLifecycleObservableImpl> S2;
        private Provider<Gson> T;
        private Provider<AppsflyerManager> T0;
        private Provider<ConnectivityManager> T1;
        private Provider<VoipService> T2;
        private Provider<GsonConverterFactory> U;
        private Provider<AppRoutingManager> U0;
        private Provider<NetworkService> U1;
        private Provider<SupportApi> U2;
        private Provider<Serializer> V;
        private Provider<DriverChatUserInfoProvider> V0;
        private Provider<DateTimeFormatter> V1;
        private Provider<EarningsApi> V2;
        private Provider<SimpleXmlConverterFactory> W;
        private Provider<ChatRepo> W0;
        private Provider<DateTimeConverter> W1;
        private Provider<EarningsGoalApi> W2;
        private Provider<ApiFactory> X;
        private Provider<OrdersCache> X0;
        private Provider<FleetClient> X1;
        private Provider<EarningsBalanceApi> X2;
        private Provider<OkHttpClient> Y;
        private Provider<ChatSettingsManager> Y0;
        private Provider<SettingsClient> Y1;
        private Provider<VectorTileBitmapPool> Y2;
        private Provider<AnonymousAuthApi> Z;
        private Provider<ChatConfigManager> Z0;
        private Provider<DriverDestinationsManager> Z1;
        private Provider<HtmlFontMapper> Z2;

        /* renamed from: a  reason: collision with root package name */
        private final App f20033a;

        /* renamed from: a0  reason: collision with root package name */
        private Provider<CompositeResponseTransformer> f20034a0;

        /* renamed from: a1  reason: collision with root package name */
        private Provider<ChatForegroundProvider> f20035a1;

        /* renamed from: a2  reason: collision with root package name */
        private Provider<VoipActiveWindowTracker> f20036a2;

        /* renamed from: a3  reason: collision with root package name */
        private Provider<Logger> f20037a3;

        /* renamed from: b  reason: collision with root package name */
        private final ReleaseDeviceInfoModule f20038b;

        /* renamed from: b0  reason: collision with root package name */
        private Provider<DriverAuthAnonymousApi> f20039b0;

        /* renamed from: b1  reason: collision with root package name */
        private Provider<ChatConnectionProvider> f20040b1;

        /* renamed from: b2  reason: collision with root package name */
        private Provider<SurgeManager> f20041b2;

        /* renamed from: b3  reason: collision with root package name */
        private Provider<HtmlEngine> f20042b3;

        /* renamed from: c  reason: collision with root package name */
        private final UtilsModule f20043c;

        /* renamed from: c0  reason: collision with root package name */
        private Provider<AnonymousAuthClient> f20044c0;

        /* renamed from: c1  reason: collision with root package name */
        private Provider<CreateChatInteractor> f20045c1;

        /* renamed from: c2  reason: collision with root package name */
        private Provider<DriverWorkTimeApi> f20046c2;

        /* renamed from: c3  reason: collision with root package name */
        private Provider<RawTranslationProvider> f20047c3;

        /* renamed from: d  reason: collision with root package name */
        private final NetworkModule f20048d;

        /* renamed from: d0  reason: collision with root package name */
        private Provider<OkHttpClient> f20049d0;

        /* renamed from: d1  reason: collision with root package name */
        private Provider<ChatManager> f20050d1;

        /* renamed from: d2  reason: collision with root package name */
        private Provider<WorkingTimeManager> f20051d2;

        /* renamed from: d3  reason: collision with root package name */
        private Provider<OkHttpClient> f20052d3;

        /* renamed from: e  reason: collision with root package name */
        private final ChatDependencyProvider f20053e;

        /* renamed from: e0  reason: collision with root package name */
        private Provider<ShardApiProvider> f20054e0;

        /* renamed from: e1  reason: collision with root package name */
        private Provider<ChatService> f20055e1;

        /* renamed from: e2  reason: collision with root package name */
        private Provider<OrderClient> f20056e2;

        /* renamed from: e3  reason: collision with root package name */
        private Provider<AudioRecordingUploadAPI> f20057e3;

        /* renamed from: f  reason: collision with root package name */
        private final PlatformModule f20058f;

        /* renamed from: f0  reason: collision with root package name */
        private Provider<DriverClient> f20059f0;

        /* renamed from: f1  reason: collision with root package name */
        private Provider<AppReporter> f20060f1;

        /* renamed from: f2  reason: collision with root package name */
        private Provider<LocationDatabase> f20061f2;

        /* renamed from: f3  reason: collision with root package name */
        private Provider<GmsSmsRetriever> f20062f3;

        /* renamed from: g  reason: collision with root package name */
        private final MapModule f20063g;

        /* renamed from: g0  reason: collision with root package name */
        private Provider<UrlFactory> f20064g0;

        /* renamed from: g1  reason: collision with root package name */
        private Provider<GoOnlineFlow> f20065g1;

        /* renamed from: g2  reason: collision with root package name */
        private Provider<LocationDao> f20066g2;

        /* renamed from: g3  reason: collision with root package name */
        private Provider<ChatNotificationManager> f20067g3;

        /* renamed from: h  reason: collision with root package name */
        private final DriverChatApplicationModule f20068h;

        /* renamed from: h0  reason: collision with root package name */
        private Provider<PartnerTokenManager> f20069h0;

        /* renamed from: h1  reason: collision with root package name */
        private Provider<DriverStatusSenderImpl> f20070h1;

        /* renamed from: h2  reason: collision with root package name */
        private Provider<LocationStorageDatabase> f20071h2;

        /* renamed from: h3  reason: collision with root package name */
        private Provider<ChatTerminationMessageProvider> f20072h3;

        /* renamed from: i  reason: collision with root package name */
        private final ReleaseApplicationComponentImpl f20073i;

        /* renamed from: i0  reason: collision with root package name */
        private Provider<PartnerAccessTokenInterceptor> f20074i0;

        /* renamed from: i1  reason: collision with root package name */
        private Provider<DriverConfigurationApi> f20075i1;

        /* renamed from: i2  reason: collision with root package name */
        private Provider<LocationStorageWrapper> f20076i2;

        /* renamed from: i3  reason: collision with root package name */
        private Provider<ChatApi> f20077i3;

        /* renamed from: j  reason: collision with root package name */
        private Provider<App> f20078j;

        /* renamed from: j0  reason: collision with root package name */
        private Provider<OkHttpClient> f20079j0;

        /* renamed from: j1  reason: collision with root package name */
        private Provider<DriverConfigurationClient> f20080j1;

        /* renamed from: j2  reason: collision with root package name */
        private Provider<LocationTransmitter> f20081j2;

        /* renamed from: j3  reason: collision with root package name */
        private Provider<ActivityLifecycleLoggingManager> f20082j3;

        /* renamed from: k  reason: collision with root package name */
        private Provider<BoltPrefsStorageMigration> f20083k;

        /* renamed from: k0  reason: collision with root package name */
        private Provider<Retrofit.Builder> f20084k0;

        /* renamed from: k1  reason: collision with root package name */
        private Provider<TargetingUpdateManager> f20085k1;

        /* renamed from: k2  reason: collision with root package name */
        private Provider<OrderStateManager> f20086k2;

        /* renamed from: k3  reason: collision with root package name */
        private Provider<ChatForegroundTracker> f20087k3;

        /* renamed from: l  reason: collision with root package name */
        private Provider<StorageFactory> f20088l;

        /* renamed from: l0  reason: collision with root package name */
        private Provider<PartnerIdentityVerificationInitializer> f20089l0;

        /* renamed from: l1  reason: collision with root package name */
        private Provider<DriverManager> f20090l1;

        /* renamed from: l2  reason: collision with root package name */
        private Provider<DispatchSettingsManager> f20091l2;

        /* renamed from: l3  reason: collision with root package name */
        private Provider<RouterFragmentCoordinator> f20092l3;

        /* renamed from: m  reason: collision with root package name */
        private Provider<DeviceSettings> f20093m;

        /* renamed from: m0  reason: collision with root package name */
        private Provider<IdentityVerificationManager> f20094m0;

        /* renamed from: m1  reason: collision with root package name */
        private Provider<DatabaseManager> f20095m1;

        /* renamed from: m2  reason: collision with root package name */
        private Provider<NoDefaultNavigator> f20096m2;

        /* renamed from: m3  reason: collision with root package name */
        private Provider<SupportDeeplinkMapper> f20097m3;

        /* renamed from: n  reason: collision with root package name */
        private Provider<CoroutineDispatcher> f20098n;

        /* renamed from: n0  reason: collision with root package name */
        private Provider<AuthenticatedAuthApi> f20099n0;

        /* renamed from: n1  reason: collision with root package name */
        private Provider<InternalLog> f20100n1;

        /* renamed from: n2  reason: collision with root package name */
        private Provider<TaxifyNavigator> f20101n2;

        /* renamed from: n3  reason: collision with root package name */
        private Provider<SupportTicketDeeplinkMapper> f20102n3;

        /* renamed from: o  reason: collision with root package name */
        private Provider<Features> f20103o;

        /* renamed from: o0  reason: collision with root package name */
        private Provider<AuthenticatedAuthClient> f20104o0;

        /* renamed from: o1  reason: collision with root package name */
        private Provider<OkHttpClient> f20105o1;

        /* renamed from: o2  reason: collision with root package name */
        private Provider<AppResolver> f20106o2;

        /* renamed from: o3  reason: collision with root package name */
        private Provider<PriorityDeeplinkMapper> f20107o3;

        /* renamed from: p  reason: collision with root package name */
        private Provider<DriverProvider> f20108p;

        /* renamed from: p0  reason: collision with root package name */
        private Provider<AuthManager> f20109p0;

        /* renamed from: p1  reason: collision with root package name */
        private Provider<DriverAppLogAnonymousApi> f20110p1;

        /* renamed from: p2  reason: collision with root package name */
        private Provider<TwoGisNavigator> f20111p2;

        /* renamed from: p3  reason: collision with root package name */
        private Provider<DriverActivityDeeplinkMapper> f20112p3;

        /* renamed from: q  reason: collision with root package name */
        private Provider<Set<AnalyticsConsumer>> f20113q;

        /* renamed from: q0  reason: collision with root package name */
        private Provider<StandardExponentialBackoffStrategy> f20114q0;

        /* renamed from: q1  reason: collision with root package name */
        private Provider<AppLogClient> f20115q1;

        /* renamed from: q2  reason: collision with root package name */
        private Provider<YandexMapsNavigator> f20116q2;

        /* renamed from: q3  reason: collision with root package name */
        private Provider<DriverActivityHoursDeeplinkMapper> f20117q3;

        /* renamed from: r  reason: collision with root package name */
        private Provider<FirebaseAnalytics> f20118r;

        /* renamed from: r0  reason: collision with root package name */
        private Provider<TokenManager> f20119r0;

        /* renamed from: r1  reason: collision with root package name */
        private Provider<DeviceFeatures> f20120r1;

        /* renamed from: r2  reason: collision with root package name */
        private Provider<ChromeCustomTabsUrlLauncher> f20121r2;

        /* renamed from: r3  reason: collision with root package name */
        private Provider<DriverActivityTripsDeeplinkMapper> f20122r3;

        /* renamed from: s  reason: collision with root package name */
        private Provider<FirebaseAnalyticsConsumer> f20123s;

        /* renamed from: s0  reason: collision with root package name */
        private Provider<AccessTokenInterceptor> f20124s0;

        /* renamed from: s1  reason: collision with root package name */
        private Provider<ApplogUploader> f20125s1;

        /* renamed from: s2  reason: collision with root package name */
        private Provider<YandexNavigationNavigator> f20126s2;

        /* renamed from: s3  reason: collision with root package name */
        private Provider<DriverActivityCancelsDeeplinkMapper> f20127s3;

        /* renamed from: t  reason: collision with root package name */
        private Provider<CrashlyticsAnalyticsConsumer> f20128t;

        /* renamed from: t0  reason: collision with root package name */
        private Provider<AnalyticsApi> f20129t0;

        /* renamed from: t1  reason: collision with root package name */
        private Provider<LogWorker> f20130t1;

        /* renamed from: t2  reason: collision with root package name */
        private Provider<CityGuideNavigator> f20131t2;

        /* renamed from: t3  reason: collision with root package name */
        private Provider<LoyaltyOffersListDeeplinkMapper> f20132t3;

        /* renamed from: u  reason: collision with root package name */
        private Provider<PackageInfo> f20133u;

        /* renamed from: u0  reason: collision with root package name */
        private Provider<LeadAnalyticsApi> f20134u0;

        /* renamed from: u1  reason: collision with root package name */
        private Provider<AppLogWatcher> f20135u1;

        /* renamed from: u2  reason: collision with root package name */
        private Provider<MapsMeNavigator> f20136u2;

        /* renamed from: u3  reason: collision with root package name */
        private Provider<LoyaltyOfferDetailsDeeplinkMapper> f20137u3;

        /* renamed from: v  reason: collision with root package name */
        private Provider<DeviceUuidManager> f20138v;

        /* renamed from: v0  reason: collision with root package name */
        private Provider<AnalyticsClient> f20139v0;

        /* renamed from: v1  reason: collision with root package name */
        private Provider<BigQueryUploader> f20140v1;

        /* renamed from: v2  reason: collision with root package name */
        private Provider<GoogleMapsNavigator> f20141v2;

        /* renamed from: v3  reason: collision with root package name */
        private Provider<StoryDeeplinkMapper> f20142v3;

        /* renamed from: w  reason: collision with root package name */
        private Provider<DeviceInfo> f20143w;

        /* renamed from: w0  reason: collision with root package name */
        private Provider<InternalAnalyticsConsumer> f20144w0;

        /* renamed from: w1  reason: collision with root package name */
        private Provider<BigQueryLogWatcher> f20145w1;

        /* renamed from: w2  reason: collision with root package name */
        private Provider<WazeNavigator> f20146w2;

        /* renamed from: w3  reason: collision with root package name */
        private Provider<CleverTapCoordinator> f20147w3;

        /* renamed from: x  reason: collision with root package name */
        private Provider<AnchoredTrueTimeProvider> f20148x;

        /* renamed from: x0  reason: collision with root package name */
        private Provider<LeadInternalAnalyticsConsumer> f20149x0;

        /* renamed from: x1  reason: collision with root package name */
        private Provider<OrderStateStrategy> f20150x1;

        /* renamed from: x2  reason: collision with root package name */
        private Provider<Map<Navigator.Type, Navigator>> f20151x2;

        /* renamed from: x3  reason: collision with root package name */
        private Provider<CustomTabsUrlLauncher> f20152x3;

        /* renamed from: y  reason: collision with root package name */
        private Provider<AnalyticsManager> f20153y;

        /* renamed from: y0  reason: collision with root package name */
        private Provider<Set<AnalyticsConsumer>> f20154y0;

        /* renamed from: y1  reason: collision with root package name */
        private Provider<WebViewStrategy> f20155y1;

        /* renamed from: y2  reason: collision with root package name */
        private Provider<NavigationAppTypeFactory> f20156y2;

        /* renamed from: y3  reason: collision with root package name */
        private Provider<SystemUrlLauncher> f20157y3;

        /* renamed from: z  reason: collision with root package name */
        private Provider<PackageManager> f20158z;

        /* renamed from: z0  reason: collision with root package name */
        private Provider<PartnerApi> f20159z0;

        /* renamed from: z1  reason: collision with root package name */
        private Provider<TimingHooks> f20160z1;

        /* renamed from: z2  reason: collision with root package name */
        private Provider<DynamicNavigationProvider> f20161z2;

        /* renamed from: z3  reason: collision with root package name */
        private Provider<UrlCoordinator> f20162z3;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ChatConnectionProviderProvider implements Provider<ChatConnectionProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ChatDependencyProvider f20163a;

            ChatConnectionProviderProvider(ChatDependencyProvider chatDependencyProvider) {
                this.f20163a = chatDependencyProvider;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ChatConnectionProvider get() {
                return (ChatConnectionProvider) Preconditions.checkNotNullFromComponent(this.f20163a.a());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ChatRepoProvider implements Provider<ChatRepo> {

            /* renamed from: a  reason: collision with root package name */
            private final ChatDependencyProvider f20164a;

            ChatRepoProvider(ChatDependencyProvider chatDependencyProvider) {
                this.f20164a = chatDependencyProvider;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ChatRepo get() {
                return (ChatRepo) Preconditions.checkNotNullFromComponent(this.f20164a.g());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class CreateChatInteractorProvider implements Provider<CreateChatInteractor> {

            /* renamed from: a  reason: collision with root package name */
            private final ChatDependencyProvider f20165a;

            CreateChatInteractorProvider(ChatDependencyProvider chatDependencyProvider) {
                this.f20165a = chatDependencyProvider;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public CreateChatInteractor get() {
                return (CreateChatInteractor) Preconditions.checkNotNullFromComponent(this.f20165a.f());
            }
        }

        private ReleaseApplicationComponentImpl(CoroutinesDispatcherModule coroutinesDispatcherModule, DriverChatApplicationModule driverChatApplicationModule, LogsModule logsModule, MapModule mapModule, PlatformModule platformModule, ReleaseDeviceInfoModule releaseDeviceInfoModule, ReleaseGeoModule releaseGeoModule, ReleaseNetworkModule releaseNetworkModule, NetworkModule networkModule, UtilsModule utilsModule, HtmlEngineModule htmlEngineModule, ChatDependencyProvider chatDependencyProvider, App app) {
            this.f20073i = this;
            this.f20033a = app;
            this.f20038b = releaseDeviceInfoModule;
            this.f20043c = utilsModule;
            this.f20048d = networkModule;
            this.f20053e = chatDependencyProvider;
            this.f20058f = platformModule;
            this.f20063g = mapModule;
            this.f20068h = driverChatApplicationModule;
            G2(coroutinesDispatcherModule, driverChatApplicationModule, logsModule, mapModule, platformModule, releaseDeviceInfoModule, releaseGeoModule, releaseNetworkModule, networkModule, utilsModule, htmlEngineModule, chatDependencyProvider, app);
            H2(coroutinesDispatcherModule, driverChatApplicationModule, logsModule, mapModule, platformModule, releaseDeviceInfoModule, releaseGeoModule, releaseNetworkModule, networkModule, utilsModule, htmlEngineModule, chatDependencyProvider, app);
            I2(coroutinesDispatcherModule, driverChatApplicationModule, logsModule, mapModule, platformModule, releaseDeviceInfoModule, releaseGeoModule, releaseNetworkModule, networkModule, utilsModule, htmlEngineModule, chatDependencyProvider, app);
        }

        private GmsAdvertiserIdProvider A2() {
            return new GmsAdvertiserIdProvider(this.f20033a);
        }

        private GmsAvailabilityManager B2() {
            return new GmsAvailabilityManager(this.f20033a);
        }

        private GmsPlatformManager C2() {
            return new GmsPlatformManager(this.f20033a);
        }

        private GmsSecurityManager D2() {
            return new GmsSecurityManager(this.f20033a);
        }

        private GoogleIntegrityCheck E2() {
            return new GoogleIntegrityCheck(this.f20033a);
        }

        private IdentityVerificationCoordinator F2() {
            return new IdentityVerificationCoordinator(I0());
        }

        private void G2(CoroutinesDispatcherModule coroutinesDispatcherModule, DriverChatApplicationModule driverChatApplicationModule, LogsModule logsModule, MapModule mapModule, PlatformModule platformModule, ReleaseDeviceInfoModule releaseDeviceInfoModule, ReleaseGeoModule releaseGeoModule, ReleaseNetworkModule releaseNetworkModule, NetworkModule networkModule, UtilsModule utilsModule, HtmlEngineModule htmlEngineModule, ChatDependencyProvider chatDependencyProvider, App app) {
            Factory create = InstanceFactory.create(app);
            this.f20078j = create;
            this.f20083k = BoltPrefsStorageMigration_Factory.a(create);
            StorageFactory_Factory a8 = StorageFactory_Factory.a(this.f20078j);
            this.f20088l = a8;
            this.f20093m = DoubleCheck.provider(DeviceSettings_Factory.a(this.f20078j, this.f20083k, a8));
            this.f20098n = DoubleCheck.provider(CoroutinesDispatcherModule_ProvideIoDispatcherFactory.a(coroutinesDispatcherModule, DispatcherProvider_Factory.a()));
            this.f20103o = DoubleCheck.provider(Features_Factory.a(this.f20078j));
            this.f20108p = DoubleCheck.provider(DriverProvider_Factory.a(this.f20078j, this.f20083k, this.f20093m));
            this.f20113q = AnalyticsModule_ProvideLoggingConsumerFactory.a(LoggingAnalyticsConsumer_Factory.a());
            AnalyticsModule_ProvideFirebaseAnalyticsFactory a9 = AnalyticsModule_ProvideFirebaseAnalyticsFactory.a(this.f20078j);
            this.f20118r = a9;
            this.f20123s = FirebaseAnalyticsConsumer_Factory.a(a9);
            this.f20128t = CrashlyticsAnalyticsConsumer_Factory.a(FirebaseReportManager_Factory.a());
            this.f20133u = AndroidModule_ProvidePackageInfoFactory.a(this.f20078j);
            Provider<DeviceUuidManager> provider = DoubleCheck.provider(DeviceUuidManager_Factory.a(this.f20093m));
            this.f20138v = provider;
            this.f20143w = ReleaseDeviceInfoModule_ProvidesDeviceInfoFactory.a(releaseDeviceInfoModule, this.f20133u, provider);
            this.f20148x = DoubleCheck.provider(ServiceModule_ProvidesAnchoredTrueTimeProviderFactory.a());
            this.f20153y = new DelegateFactory();
            this.f20158z = AndroidModule_ProvidesPackageManagerFactory.a(this.f20078j);
            this.A = GmsPlatformManager_Factory.a(this.f20078j);
            AnalyticsImpl_Factory a10 = AnalyticsImpl_Factory.a(this.f20078j, this.f20103o, this.f20108p, this.f20153y, this.f20158z, FirebaseReportManager_Factory.a(), this.A);
            this.B = a10;
            this.C = DoubleCheck.provider(SessionProvider_Factory.a(this.f20148x, this.f20143w, a10));
            this.D = LanguageSettingsStorageImpl_Factory.a(this.f20108p);
            Provider<LanguageManager> provider2 = DoubleCheck.provider(LanguageManager_Factory.a(LanguageListProviderImpl_Factory.a(), this.D, this.f20078j));
            this.E = provider2;
            this.F = StandardParamsInterceptors_Factory.a(this.f20143w, this.C, this.f20108p, provider2);
            this.G = ApplogParamsInterceptor_Factory.a(this.f20143w, this.f20108p);
            this.H = LoggingInterceptor_Factory.a(SystemUptimeSource_Factory.a());
            this.I = DoubleCheck.provider(CacheProvider_Factory.a(this.f20078j));
            Provider<ResponseErrorProcessor> provider3 = DoubleCheck.provider(ResponseErrorProcessor_Factory.a());
            this.J = provider3;
            HttpErrorInterceptor_Factory a11 = HttpErrorInterceptor_Factory.a(provider3, this.B, ApiExceptionFactory_Factory.a(), FirebaseReportManager_Factory.a(), this.f20108p);
            this.K = a11;
            ClientFactory_Factory a12 = ClientFactory_Factory.a(this.F, this.G, this.H, this.I, a11);
            this.L = a12;
            this.M = DoubleCheck.provider(ReleaseNetworkModule_ProvideReleaseBaseNetworkClientFactory.a(releaseNetworkModule, a12));
            this.N = DoubleCheck.provider(GmsLocationSource_Factory.a(this.f20078j));
            this.O = ReleaseMockChecker_Factory.a(this.f20108p);
            UtilsModule_ProvidePermissionInitiatorTrackerFactory a13 = UtilsModule_ProvidePermissionInitiatorTrackerFactory.a(utilsModule, this.f20093m);
            this.P = a13;
            Provider<PermissionManager> provider4 = DoubleCheck.provider(PermissionManager_Factory.a(a13));
            this.Q = provider4;
            Provider<GeoLocationManager> provider5 = DoubleCheck.provider(ReleaseGeoModule_ProvideGeoLocationManagerFactory.a(releaseGeoModule, this.N, this.f20078j, this.f20148x, this.O, this.f20158z, provider4, MockEnvironmentDataProvider_Factory.a()));
            this.R = provider5;
            this.S = LocationInterceptor_Factory.a(provider5, this.f20108p, this.f20148x);
            Provider<Gson> provider6 = DoubleCheck.provider(NetworkModule_ProvideGsonFactory.a(networkModule));
            this.T = provider6;
            this.U = DoubleCheck.provider(NetworkModule_ProvidesGsonConverterFactoryFactory.a(networkModule, provider6));
            NetworkModule_ProvideSerializerFactory a14 = NetworkModule_ProvideSerializerFactory.a(networkModule);
            this.V = a14;
            NetworkModule_ProvideJaxbConverterFactoryFactory a15 = NetworkModule_ProvideJaxbConverterFactoryFactory.a(networkModule, a14);
            this.W = a15;
            this.X = ApiFactory_Factory.a(this.U, a15);
            Provider<OkHttpClient> provider7 = DoubleCheck.provider(NetworkModule_ProvideAnonymousOkHttpFactory.a(networkModule, this.L, this.M));
            this.Y = provider7;
            this.Z = DoubleCheck.provider(NetworkModule_ProvidesApiWithoutAuthenticationFactory.a(networkModule, this.X, provider7));
            this.f20034a0 = CompositeResponseTransformer_Factory.a(ExposeResponseTransformer_Factory.a());
            this.f20039b0 = DoubleCheck.provider(NetworkModule_ProvideDriverAuthAnonymousApiFactory.a(networkModule, this.X, this.Y));
            this.f20044c0 = AnonymousAuthClient_Factory.a(this.f20143w, this.Z, this.f20034a0, SystemUptimeSource_Factory.a(), this.f20039b0, PlayStoreVerificationResultToRequestMapper_Factory.a());
            DelegateFactory delegateFactory = new DelegateFactory();
            this.f20049d0 = delegateFactory;
            Provider<ShardApiProvider> provider8 = DoubleCheck.provider(ShardApiProvider_Factory.a(this.X, this.f20108p, delegateFactory));
            this.f20054e0 = provider8;
            this.f20059f0 = DriverClient_Factory.a(provider8, this.f20034a0, this.J);
            this.f20064g0 = UrlFactory_Factory.a(this.f20143w, this.E);
            Provider<PartnerTokenManager> provider9 = DoubleCheck.provider(PartnerTokenManager_Factory.a(this.f20093m, this.f20044c0));
            this.f20069h0 = provider9;
            PartnerAccessTokenInterceptor_Factory a16 = PartnerAccessTokenInterceptor_Factory.a(provider9);
            this.f20074i0 = a16;
            Provider<OkHttpClient> provider10 = DoubleCheck.provider(NetworkModule_ProvidePartnerAuthorisedOkHttpFactory.a(networkModule, this.L, this.M, a16));
            this.f20079j0 = provider10;
            Provider<Retrofit.Builder> provider11 = DoubleCheck.provider(NetworkModule_ProvidePartnerBoltDriverVerificationRetrofitBuilderFactory.a(networkModule, provider10, this.X));
            this.f20084k0 = provider11;
            PartnerIdentityVerificationInitializer_Factory a17 = PartnerIdentityVerificationInitializer_Factory.a(this.f20064g0, provider11, this.f20143w, this.E, this.f20069h0, this.B, this.f20108p);
            this.f20089l0 = a17;
            this.f20094m0 = IdentityVerificationManager_Factory.a(a17);
            Provider<AuthenticatedAuthApi> provider12 = DoubleCheck.provider(NetworkModule_ProvidesAuthApiFactory.a(networkModule, this.f20049d0, this.X));
            this.f20099n0 = provider12;
            AuthenticatedAuthClient_Factory a18 = AuthenticatedAuthClient_Factory.a(this.f20143w, this.f20093m, provider12, this.f20034a0, this.J);
            this.f20104o0 = a18;
            this.f20109p0 = DoubleCheck.provider(AuthManager_Factory.a(this.f20078j, this.f20108p, this.f20103o, this.f20093m, this.f20148x, this.f20059f0, this.E, this.f20094m0, a18, this.B));
            StandardExponentialBackoffStrategy_Factory a19 = StandardExponentialBackoffStrategy_Factory.a(this.f20148x);
            this.f20114q0 = a19;
            Provider<TokenManager> provider13 = DoubleCheck.provider(TokenManager_Factory.a(this.f20093m, this.f20044c0, this.f20109p0, a19));
            this.f20119r0 = provider13;
            AccessTokenInterceptor_Factory a20 = AccessTokenInterceptor_Factory.a(provider13);
            this.f20124s0 = a20;
            DelegateFactory.setDelegate(this.f20049d0, DoubleCheck.provider(NetworkModule_ProvideAuthorizedOkHttpFactory.a(networkModule, this.L, this.M, this.S, a20)));
            this.f20129t0 = DoubleCheck.provider(NetworkModule_ProvidesEventApiFactory.a(networkModule, this.f20049d0, this.X));
            Provider<LeadAnalyticsApi> provider14 = DoubleCheck.provider(NetworkModule_ProvidesLeadEventApiFactory.a(networkModule, this.Y, this.X));
            this.f20134u0 = provider14;
            AnalyticsClient_Factory a21 = AnalyticsClient_Factory.a(this.f20129t0, provider14, this.J);
            this.f20139v0 = a21;
            this.f20144w0 = InternalAnalyticsConsumer_Factory.a(a21);
            this.f20149x0 = LeadInternalAnalyticsConsumer_Factory.a(this.f20139v0);
            SetFactory build = SetFactory.builder(4, 1).addCollectionProvider(this.f20113q).addProvider(this.f20123s).addProvider(this.f20128t).addProvider(this.f20144w0).addProvider(this.f20149x0).build();
            this.f20154y0 = build;
            DelegateFactory.setDelegate(this.f20153y, DoubleCheck.provider(AnalyticsManager_Factory.a(build)));
            Provider<PartnerApi> provider15 = DoubleCheck.provider(NetworkModule_ProvidesApiPartnerAuthenticationFactory.a(networkModule, this.X, this.f20079j0));
            this.f20159z0 = provider15;
            PartnerClient_Factory a22 = PartnerClient_Factory.a(provider15);
            this.A0 = a22;
            this.B0 = DoubleCheck.provider(PushTokenManager_Factory.a(this.f20059f0, a22, this.f20109p0, this.B));
            this.C0 = DoubleCheck.provider(DriverTrainingRestrictionManager_Factory.a());
            Provider<DeepLinkParser> provider16 = DoubleCheck.provider(ServiceModule_BindsDeepLinkParserFactory.b());
            this.D0 = provider16;
            this.E0 = DoubleCheck.provider(ServiceModule_BindsDeepLinkManagerFactory.b(provider16));
            this.F0 = DoubleCheck.provider(SettingsDeeplinkMapper_Factory.a());
            Provider<NewsDeeplinkMapper> provider17 = DoubleCheck.provider(NewsDeeplinkMapper_Factory.a());
            this.G0 = provider17;
            Provider<DeeplinkHomeRouter> provider18 = DoubleCheck.provider(DeeplinkHomeRouter_Factory.a(this.F0, provider17));
            this.H0 = provider18;
            this.I0 = DoubleCheck.provider(DeeplinkHomeContainerCoordinator_Factory.a(provider18, this.E0));
            Provider<OkHttpClient> provider19 = DoubleCheck.provider(NetworkModule_ProvideSimpleOkHttpFactory.a(networkModule, this.L, this.M));
            this.J0 = provider19;
            Provider<TranslationApi> provider20 = DoubleCheck.provider(NetworkModule_ProvidesTranslationApiFactory.a(networkModule, provider19, this.X));
            this.K0 = provider20;
            TranslationsClient_Factory a23 = TranslationsClient_Factory.a(provider20);
            this.L0 = a23;
            NetworkModule_ProvideTranslationUpaterFactory a24 = NetworkModule_ProvideTranslationUpaterFactory.a(networkModule, a23);
            this.M0 = a24;
            this.N0 = DoubleCheck.provider(TranslationManager_Factory.a(a24));
            this.O0 = AnalyticsModule_ProvideLoggingTimedConsumerFactory.a(LoggingTimedConsumer_Factory.a());
            this.P0 = DoubleCheck.provider(FirebaseTimedConsumer_Factory.a());
            SetFactory build2 = SetFactory.builder(1, 1).addCollectionProvider(this.O0).addProvider(this.P0).build();
            this.Q0 = build2;
            Provider<TimedAnalyticsManager> provider21 = DoubleCheck.provider(TimedAnalyticsManager_Factory.a(build2));
            this.R0 = provider21;
            this.S0 = DoubleCheck.provider(MixpanelController_Factory.a(this.f20108p, this.f20078j, this.f20153y, provider21, this.E));
            this.T0 = DoubleCheck.provider(AppsflyerManager_Factory.a(this.f20078j));
            this.U0 = DoubleCheck.provider(AppRoutingManager_Factory.a(this.f20078j));
            this.V0 = DriverChatUserInfoProvider_Factory.a(this.f20108p, this.f20119r0, this.C, this.E, this.f20143w);
            this.W0 = new ChatRepoProvider(chatDependencyProvider);
            this.X0 = DoubleCheck.provider(OrdersCache_Factory.a());
            ChatSettingsManager_Factory a25 = ChatSettingsManager_Factory.a(this.f20108p);
            this.Y0 = a25;
            this.Z0 = DoubleCheck.provider(ChatConfigManager_Factory.a(a25));
            this.f20035a1 = DoubleCheck.provider(ChatForegroundProvider_Factory.a());
            this.f20040b1 = new ChatConnectionProviderProvider(chatDependencyProvider);
            this.f20045c1 = new CreateChatInteractorProvider(chatDependencyProvider);
        }

        private void H2(CoroutinesDispatcherModule coroutinesDispatcherModule, DriverChatApplicationModule driverChatApplicationModule, LogsModule logsModule, MapModule mapModule, PlatformModule platformModule, ReleaseDeviceInfoModule releaseDeviceInfoModule, ReleaseGeoModule releaseGeoModule, ReleaseNetworkModule releaseNetworkModule, NetworkModule networkModule, UtilsModule utilsModule, HtmlEngineModule htmlEngineModule, ChatDependencyProvider chatDependencyProvider, App app) {
            DriverChatApplicationModule_ProvideChatManagerFactory a8 = DriverChatApplicationModule_ProvideChatManagerFactory.a(driverChatApplicationModule, this.V0, this.W0, this.f20040b1, this.f20045c1);
            this.f20050d1 = a8;
            this.f20055e1 = DoubleCheck.provider(ChatService_Factory.a(this.V0, this.W0, this.X0, this.Z0, this.f20119r0, this.f20035a1, a8));
            this.f20060f1 = DoubleCheck.provider(AppReporter_Factory.a(this.f20148x, this.B));
            GoOnlineFlow_Factory a9 = GoOnlineFlow_Factory.a(this.R, this.f20059f0, this.f20108p, MockEnvironmentDataProvider_Factory.a());
            this.f20065g1 = a9;
            this.f20070h1 = DoubleCheck.provider(DriverStatusSenderImpl_Factory.a(this.f20059f0, this.B, this.f20060f1, this.f20108p, a9));
            Provider<DriverConfigurationApi> provider = DoubleCheck.provider(NetworkModule_ProvideDriverConfigurationApiFactory.a(networkModule, this.f20049d0, this.X));
            this.f20075i1 = provider;
            DriverConfigurationClient_Factory a10 = DriverConfigurationClient_Factory.a(this.f20098n, provider);
            this.f20080j1 = a10;
            TargetingUpdateManager_Factory a11 = TargetingUpdateManager_Factory.a(a10, this.f20103o, this.f20108p, this.B, this.f20148x);
            this.f20085k1 = a11;
            this.f20090l1 = DoubleCheck.provider(DriverManager_Factory.a(this.f20070h1, this.f20108p, a11, this.f20148x));
            this.f20095m1 = DoubleCheck.provider(DatabaseManager_Factory.a(this.f20078j));
            this.f20100n1 = InternalLog_Factory.a(FirebaseReportManager_Factory.a());
            Provider<OkHttpClient> provider2 = DoubleCheck.provider(NetworkModule_ProvideApplogOkHttpFactory.a(networkModule, this.L, this.M));
            this.f20105o1 = provider2;
            Provider<DriverAppLogAnonymousApi> provider3 = DoubleCheck.provider(NetworkModule_ProvideDriverAppLogAnonymousApiFactory.a(networkModule, provider2, this.X));
            this.f20110p1 = provider3;
            this.f20115q1 = AppLogClient_Factory.a(provider3);
            this.f20120r1 = DeviceFeatures_Factory.a(this.f20078j);
            this.f20125s1 = DoubleCheck.provider(LogsModule_ProvideApplogUploaderFactory.a(logsModule, this.f20115q1, this.f20108p, ApplogFactory_Factory.a(), this.f20100n1, this.f20120r1));
            Provider<LogWorker> provider4 = DoubleCheck.provider(LogWorker_Factory.a());
            this.f20130t1 = provider4;
            this.f20135u1 = DoubleCheck.provider(AppLogWatcher_Factory.a(this.f20095m1, this.f20100n1, this.f20125s1, provider4));
            BigQueryUploader_Factory a12 = BigQueryUploader_Factory.a(this.f20153y, this.f20100n1);
            this.f20140v1 = a12;
            this.f20145w1 = DoubleCheck.provider(BigQueryLogWatcher_Factory.a(this.f20095m1, this.f20100n1, a12, this.f20130t1));
            this.f20150x1 = DoubleCheck.provider(OrderStateStrategy_Factory.a(this.f20125s1, this.f20108p));
            this.f20155y1 = DoubleCheck.provider(WebViewStrategy_Factory.a(this.f20125s1, this.f20120r1));
            this.f20160z1 = DoubleCheck.provider(TimingHooks_Factory.a());
            Provider<BackgroundManager> provider5 = DoubleCheck.provider(BackgroundManager_Factory.a(this.f20060f1));
            this.A1 = provider5;
            this.B1 = PollerFactory_Factory.a(this.f20160z1, this.f20059f0, this.X0, provider5, this.f20108p, PollingRetryStrategy_Factory.a(), this.R);
            this.C1 = ActivePollingErrorHandler_Factory.a(this.f20109p0);
            Provider<RoutingManager> provider6 = DoubleCheck.provider(RoutingManager_Factory.a());
            this.D1 = provider6;
            InactivePollingErrorHandler_Factory a13 = InactivePollingErrorHandler_Factory.a(this.f20109p0, provider6);
            this.E1 = a13;
            this.F1 = DoubleCheck.provider(PollerImpl_Factory.a(this.B1, this.C1, a13, this.f20070h1));
            this.G1 = DoubleCheck.provider(NetworkModule_ProvidesDriverRegistrationApiFactory.a(networkModule, this.Y, this.X));
            this.H1 = DoubleCheck.provider(NetworkModule_ProvidesDeviceInfoApiFactory.a(networkModule, this.f20049d0, this.X));
            Provider<CleverTapManager> provider7 = DoubleCheck.provider(CleverTapManager_Factory.a());
            this.I1 = provider7;
            this.J1 = CleverTapPushHandler_Factory.a(this.f20078j, provider7);
            this.K1 = IntentProvider_Factory.a(this.f20078j);
            AndroidModule_ProvideNotificationManagerFactory a14 = AndroidModule_ProvideNotificationManagerFactory.a(this.f20078j);
            this.L1 = a14;
            UiNotificationManager_Factory a15 = UiNotificationManager_Factory.a(this.f20078j, this.K1, a14, VoipEffectsFactory_Factory.a());
            this.M1 = a15;
            Provider<PushNotificationManager> provider8 = DoubleCheck.provider(PushNotificationManager_Factory.a(this.f20078j, this.A1, a15));
            this.N1 = provider8;
            this.O1 = DefaultPushHandler_Factory.a(provider8);
            this.P1 = SupportPushHandler_Factory.a(this.N1, this.f20078j);
            SetFactory build = SetFactory.builder(3, 0).addProvider(this.J1).addProvider(this.O1).addProvider(this.P1).build();
            this.Q1 = build;
            this.R1 = DoubleCheck.provider(PushManagerImpl_Factory.a(build, this.B0, this.f20078j, FirebasePushTokenManager_Factory.a(), this.f20109p0, this.M1, this.B));
            this.S1 = DoubleCheck.provider(TempDriverConfigHolder_Factory.a());
            AndroidModule_ProvidesConnectivityManagerFactory a16 = AndroidModule_ProvidesConnectivityManagerFactory.a(this.f20078j);
            this.T1 = a16;
            this.U1 = DoubleCheck.provider(NetworkService_Factory.a(this.f20078j, a16));
            Provider<DateTimeFormatter> provider9 = DoubleCheck.provider(DateTimeFormatter_Factory.a());
            this.V1 = provider9;
            this.W1 = DoubleCheck.provider(DateTimeConverter_Factory.a(provider9));
            this.X1 = FleetClient_Factory.a(this.f20054e0, this.J);
            SettingsClient_Factory a17 = SettingsClient_Factory.a(this.f20054e0, this.J, this.f20034a0);
            this.Y1 = a17;
            Provider<FleetClient> provider10 = this.X1;
            Provider<DriverProvider> provider11 = this.f20108p;
            Provider<DriverStatusSenderImpl> provider12 = this.f20070h1;
            this.Z1 = DoubleCheck.provider(DriverDestinationsManager_Factory.a(provider10, a17, provider11, provider12, provider12));
            this.f20036a2 = DoubleCheck.provider(VoipActiveWindowTracker_Factory.a(this.f20078j, this.D1));
            this.f20041b2 = DoubleCheck.provider(SurgeManager_Factory.a(this.f20108p));
            Provider<DriverWorkTimeApi> provider13 = DoubleCheck.provider(NetworkModule_ProvideDriverWorkTimeApiFactory.a(networkModule, this.f20049d0, this.X));
            this.f20046c2 = provider13;
            this.f20051d2 = DoubleCheck.provider(WorkingTimeManager_Factory.a(this.f20108p, provider13));
            this.f20056e2 = OrderClient_Factory.a(this.f20054e0, this.f20034a0, this.J);
            Provider<LocationDatabase> provider14 = DoubleCheck.provider(GeoModule_ProvideLocationDatabaseFactory.a(this.f20078j));
            this.f20061f2 = provider14;
            GeoModule_ProvideLocationDaoFactory a18 = GeoModule_ProvideLocationDaoFactory.a(provider14);
            this.f20066g2 = a18;
            this.f20071h2 = LocationStorageDatabase_Factory.a(a18);
            Provider<LocationStorageWrapper> provider15 = DoubleCheck.provider(LocationStorageWrapper_Factory.a(LocationStorageInMemory_Factory.a(), this.f20071h2, this.f20103o));
            this.f20076i2 = provider15;
            Provider<LocationTransmitter> provider16 = DoubleCheck.provider(LocationTransmitter_Factory.a(provider15, this.f20103o, this.f20059f0));
            this.f20081j2 = provider16;
            Provider<OrdersCache> provider17 = this.X0;
            this.f20086k2 = DoubleCheck.provider(OrderStateManager_Factory.a(provider17, provider17, this.f20056e2, provider16, this.Z1));
            this.f20091l2 = DoubleCheck.provider(DispatchSettingsManager_Factory.a(this.Y1, this.f20108p, this.B));
            this.f20096m2 = DoubleCheck.provider(NoDefaultNavigator_Factory.a());
            this.f20101n2 = DoubleCheck.provider(TaxifyNavigator_Factory.a());
            AppResolver_Factory a19 = AppResolver_Factory.a(this.f20078j, this.A);
            this.f20106o2 = a19;
            this.f20111p2 = DoubleCheck.provider(TwoGisNavigator_Factory.a(this.f20108p, a19));
            this.f20116q2 = DoubleCheck.provider(YandexMapsNavigator_Factory.a(this.f20106o2));
            ChromeCustomTabsUrlLauncher_Factory a20 = ChromeCustomTabsUrlLauncher_Factory.a(this.f20078j);
            this.f20121r2 = a20;
            this.f20126s2 = DoubleCheck.provider(YandexNavigationNavigator_Factory.a(this.f20078j, a20, this.f20106o2, this.f20103o));
            this.f20131t2 = DoubleCheck.provider(CityGuideNavigator_Factory.a(this.f20106o2));
            this.f20136u2 = DoubleCheck.provider(MapsMeNavigator_Factory.a(this.f20106o2, this.f20103o));
            this.f20141v2 = DoubleCheck.provider(GoogleMapsNavigator_Factory.a(this.f20106o2));
            this.f20146w2 = DoubleCheck.provider(WazeNavigator_Factory.a(this.A, this.f20106o2));
            MapFactory build2 = MapFactory.builder(9).put((MapFactory.Builder) Navigator.Type.NO_NAVIGATION_SELECTED, (Provider) this.f20096m2).put((MapFactory.Builder) Navigator.Type.TAXIFY_NAVIGATION, (Provider) this.f20101n2).put((MapFactory.Builder) Navigator.Type.TWO_GIS_NAVIGATION, (Provider) this.f20111p2).put((MapFactory.Builder) Navigator.Type.YANDEX_MAPS, (Provider) this.f20116q2).put((MapFactory.Builder) Navigator.Type.YANDEX_NAVIGATION, (Provider) this.f20126s2).put((MapFactory.Builder) Navigator.Type.CITY_GUIDE_NAVIGATION, (Provider) this.f20131t2).put((MapFactory.Builder) Navigator.Type.MAPS_ME, (Provider) this.f20136u2).put((MapFactory.Builder) Navigator.Type.GOOGLE_MAPS, (Provider) this.f20141v2).put((MapFactory.Builder) Navigator.Type.WAZE, (Provider) this.f20146w2).build();
            this.f20151x2 = build2;
            this.f20156y2 = NavigationAppTypeFactory_Factory.a(build2);
            DynamicNavigationProvider_Factory a21 = DynamicNavigationProvider_Factory.a(this.f20078j, this.f20121r2);
            this.f20161z2 = a21;
            this.A2 = DoubleCheck.provider(NavigationManager_Factory.a(this.f20078j, this.f20108p, this.f20156y2, this.R, this.f20106o2, a21));
            this.B2 = DoubleCheck.provider(VoipRxLifecycleTransfromer_Factory.a());
            Provider<IncidentReportingApi> provider18 = DoubleCheck.provider(NetworkModule_ProvidesIncidentReportingApiFactory.a(networkModule, this.f20049d0, this.X));
            this.C2 = provider18;
            IncidentReportingClient_Factory a22 = IncidentReportingClient_Factory.a(provider18, this.f20034a0, this.J);
            this.D2 = a22;
            this.E2 = DoubleCheck.provider(IncidentReportingService_Factory.a(this.X0, a22, this.f20148x, this.f20108p, this.R));
            this.F2 = DoubleCheck.provider(SoundEffectsPool_Factory.a(this.f20078j));
            this.G2 = DoubleCheck.provider(NetworkModule_ProvideContactApiFactory.a(networkModule, this.f20049d0, this.X));
            CrashlyticsConsumer_Factory a23 = CrashlyticsConsumer_Factory.a(FirebaseReportManager_Factory.a());
            this.H2 = a23;
            this.I2 = DoubleCheck.provider(LogManager_Factory.a(this.f20095m1, this.f20130t1, this.f20060f1, a23, this.f20155y1, PersistPoeg_Factory.a()));
            Provider<NoAnswerCallCache> provider19 = DoubleCheck.provider(NoAnswerCallCache_Factory.a());
            this.J2 = provider19;
            NoAnswerCallManager_Factory a24 = NoAnswerCallManager_Factory.a(this.X0, this.A1, provider19, this.M1);
            this.K2 = a24;
            this.L2 = DoubleCheck.provider(IncomingWindowManager_Factory.a(this.f20078j, a24, this.M1));
            AndroidModule_ProvidesPowerManagerFactory a25 = AndroidModule_ProvidesPowerManagerFactory.a(this.f20078j);
            this.M2 = a25;
            WakeLockManager_Factory a26 = WakeLockManager_Factory.a(a25);
            this.N2 = a26;
            this.O2 = DoubleCheck.provider(VoipProximityManager_Factory.a(a26));
            this.P2 = SetFactory.builder(4, 0).addProvider(this.L2).addProvider(this.B2).addProvider(this.O2).addProvider(this.f20036a2).build();
            this.Q2 = DoubleCheck.provider(OutgoingWindowManager_Factory.a(this.f20078j));
            SetFactory build3 = SetFactory.builder(4, 0).addProvider(this.Q2).addProvider(this.B2).addProvider(this.O2).addProvider(this.f20036a2).build();
            this.R2 = build3;
            this.S2 = DoubleCheck.provider(VoipLifecycleObservableImpl_Factory.a(this.P2, build3));
            this.T2 = DoubleCheck.provider(VoipService_Factory.a(VoipInfoExtractorFactoryImpl_Factory.a(), this.f20078j, this.S2, this.Q));
            this.U2 = DoubleCheck.provider(NetworkModule_ProvidesFindSolutionApiFactory.a(networkModule, this.f20049d0, this.X));
            this.V2 = DoubleCheck.provider(NetworkModule_ProvideNewEarningsApiFactory.a(networkModule, this.f20049d0, this.X));
            this.W2 = DoubleCheck.provider(NetworkModule_ProvideEarningsGoalApiFactory.a(networkModule, this.f20049d0, this.X));
            this.X2 = DoubleCheck.provider(NetworkModule_ProvideEarningsBalanceApiFactory.a(networkModule, this.f20049d0, this.X));
            this.Y2 = DoubleCheck.provider(VectorTileBitmapPool_Factory.a(this.f20108p));
        }

        private void I2(CoroutinesDispatcherModule coroutinesDispatcherModule, DriverChatApplicationModule driverChatApplicationModule, LogsModule logsModule, MapModule mapModule, PlatformModule platformModule, ReleaseDeviceInfoModule releaseDeviceInfoModule, ReleaseGeoModule releaseGeoModule, ReleaseNetworkModule releaseNetworkModule, NetworkModule networkModule, UtilsModule utilsModule, HtmlEngineModule htmlEngineModule, ChatDependencyProvider chatDependencyProvider, App app) {
            this.Z2 = DoubleCheck.provider(HtmlEngineModule_ProvidesHtmlFontMapperFactory.a(htmlEngineModule, this.f20078j));
            Provider<Logger> provider = DoubleCheck.provider(HtmlEngineModule_ProvidesHtmlEngineLoggerFactory.a(htmlEngineModule));
            this.f20037a3 = provider;
            this.f20042b3 = DoubleCheck.provider(HtmlEngineModule_ProvidesHtmlEngineFactory.a(htmlEngineModule, this.f20078j, this.Z2, provider));
            this.f20047c3 = DoubleCheck.provider(RawTranslationProvider_Factory.a());
            Provider<OkHttpClient> provider2 = DoubleCheck.provider(NetworkModule_ProvideUploadAudioOkHttpFactory.a(networkModule, this.L));
            this.f20052d3 = provider2;
            this.f20057e3 = DoubleCheck.provider(NetworkModule_ProvidesUploadAudioApiFactory.a(networkModule, provider2, this.X));
            this.f20062f3 = DoubleCheck.provider(GmsSmsRetriever_Factory.a(this.f20078j));
            this.f20067g3 = DoubleCheck.provider(ChatNotificationManager_Factory.a(this.B, this.M1, this.Q));
            this.f20072h3 = DoubleCheck.provider(ChatTerminationMessageProvider_Factory.a(this.f20078j));
            this.f20077i3 = DoubleCheck.provider(NetworkModule_ProvidesChatApiFactory.a(networkModule, this.f20049d0, this.X));
            this.f20082j3 = DoubleCheck.provider(ActivityLifecycleLoggingManager_Factory.a());
            this.f20087k3 = DoubleCheck.provider(ChatForegroundTracker_Factory.a(this.f20035a1));
            this.f20092l3 = DoubleCheck.provider(RouterFragmentCoordinator_Factory.a());
            this.f20097m3 = DoubleCheck.provider(SupportDeeplinkMapper_Factory.a());
            this.f20102n3 = DoubleCheck.provider(SupportTicketDeeplinkMapper_Factory.a());
            this.f20107o3 = DoubleCheck.provider(PriorityDeeplinkMapper_Factory.a());
            this.f20112p3 = DoubleCheck.provider(DriverActivityDeeplinkMapper_Factory.a());
            this.f20117q3 = DoubleCheck.provider(DriverActivityHoursDeeplinkMapper_Factory.a());
            this.f20122r3 = DoubleCheck.provider(DriverActivityTripsDeeplinkMapper_Factory.a());
            this.f20127s3 = DoubleCheck.provider(DriverActivityCancelsDeeplinkMapper_Factory.a());
            this.f20132t3 = DoubleCheck.provider(LoyaltyOffersListDeeplinkMapper_Factory.a(this.B));
            this.f20137u3 = DoubleCheck.provider(LoyaltyOfferDetailsDeeplinkMapper_Factory.a(this.B));
            this.f20142v3 = DoubleCheck.provider(StoryDeeplinkMapper_Factory.a(StoryManager_Factory.a()));
            this.f20147w3 = DoubleCheck.provider(CleverTapCoordinator_Factory.a(this.I1));
            this.f20152x3 = DoubleCheck.provider(CustomTabsUrlLauncher_Factory.a());
            SystemUrlLauncher_Factory a8 = SystemUrlLauncher_Factory.a(this.f20078j);
            this.f20157y3 = a8;
            this.f20162z3 = DoubleCheck.provider(UrlCoordinator_Factory.a(this.f20152x3, a8));
            this.A3 = CompositeUrlLauncher_Factory.a(this.f20121r2, this.f20157y3);
            MagicLinkInteractor_Factory a9 = MagicLinkInteractor_Factory.a(this.f20064g0, this.f20104o0);
            this.B3 = a9;
            this.C3 = DoubleCheck.provider(DriverPortalUrlCoordinator_Factory.a(this.A3, a9));
            this.D3 = DriverRegistrationClient_Factory.a(this.G1, this.f20034a0);
            this.E3 = GmsAvailabilityManager_Factory.a(this.f20078j);
            this.F3 = GoogleIntegrityCheck_Factory.a(this.f20078j);
            this.G3 = AuthConfigurationBackoffStrategy_Factory.a(this.f20148x);
            AuthStepFactory_Factory a10 = AuthStepFactory_Factory.a(this.f20078j, this.E0, this.f20044c0, this.A0, this.f20104o0, this.D3, this.N0, this.f20109p0, this.R1, this.f20108p, this.f20093m, this.E, this.E3, this.f20120r1, this.R, this.f20080j1, this.S1, this.F3, StoreVerificationBackoffStrategy_Factory.a(), this.G3, this.A);
            this.H3 = a10;
            this.I3 = FullAuthFlow_Factory.a(this.E0, a10, this.f20109p0, this.E3, this.R);
            this.J3 = InternetDataDelegate_Factory.a(this.U1);
            ConnectionMessageManager_Factory a11 = ConnectionMessageManager_Factory.a(this.U1);
            this.K3 = a11;
            this.L3 = UnauthorizedWarningInteractor_Factory.a(a11, this.f20109p0, this.R);
            TimedAnalyticsImpl_Factory a12 = TimedAnalyticsImpl_Factory.a(this.R0);
            this.M3 = a12;
            Provider<FullAuthFlow> provider3 = this.I3;
            Provider<InternetDataDelegate> provider4 = this.J3;
            Provider<UnauthorizedWarningInteractor> provider5 = this.L3;
            Provider<RoutingManager> provider6 = this.D1;
            Provider<AnalyticsImpl> provider7 = this.B;
            this.N3 = LauncherViewModel_Factory.a(provider3, provider4, provider5, a12, provider6, provider7, provider7, provider7);
            this.O3 = DoubleCheck.provider(LogsUploaderImpl_Factory.a());
        }

        private AnalyticsInitializer J2(AnalyticsInitializer analyticsInitializer) {
            AnalyticsInitializer_MembersInjector.b(analyticsInitializer, this.S0.get());
            AnalyticsInitializer_MembersInjector.a(analyticsInitializer, this.T0.get());
            return analyticsInitializer;
        }

        private App K2(App app) {
            App_MembersInjector.d(app, this.f20082j3.get());
            App_MembersInjector.e(app, this.f20087k3.get());
            App_MembersInjector.l(app, this.f20108p.get());
            App_MembersInjector.q(app, n3());
            App_MembersInjector.p(app, this.D1.get());
            App_MembersInjector.b(app, new ActivityClassCoordinator());
            App_MembersInjector.a(app, new ActivitiesStackClassCoordinator());
            App_MembersInjector.c(app, new ActivityIntentCoordinator());
            App_MembersInjector.o(app, this.f20092l3.get());
            App_MembersInjector.i(app, this.I0.get());
            App_MembersInjector.h(app, m2());
            App_MembersInjector.f(app, this.f20147w3.get());
            App_MembersInjector.r(app, this.f20162z3.get());
            App_MembersInjector.k(app, this.C3.get());
            App_MembersInjector.m(app, F2());
            App_MembersInjector.j(app, new DialogFragmentCoordinator());
            App_MembersInjector.n(app, this.Q.get());
            App_MembersInjector.g(app, this.f20152x3.get());
            return app;
        }

        private AwakeService L2(AwakeService awakeService) {
            AwakeService_MembersInjector.a(awakeService, U2());
            AwakeService_MembersInjector.f(awakeService, this.f20148x.get());
            AwakeService_MembersInjector.d(awakeService, this.f20070h1.get());
            AwakeService_MembersInjector.g(awakeService, p3());
            AwakeService_MembersInjector.b(awakeService, this.A1.get());
            AwakeService_MembersInjector.c(awakeService, this.f20108p.get());
            AwakeService_MembersInjector.h(awakeService, s3());
            AwakeService_MembersInjector.e(awakeService, C2());
            return awakeService;
        }

        private LauncherActivity M2(LauncherActivity launcherActivity) {
            BaseMvvmActivity_MembersInjector.c(launcherActivity, V1());
            BaseMvvmActivity_MembersInjector.d(launcherActivity, r3());
            BaseMvvmActivity_MembersInjector.b(launcherActivity, this.Q.get());
            BaseMvvmActivity_MembersInjector.a(launcherActivity, UtilsModule_ProvideDefaultFragmentFactoryFactory.a(this.f20043c));
            LauncherActivity_MembersInjector.c(launcherActivity, d0());
            LauncherActivity_MembersInjector.a(launcherActivity, X1());
            LauncherActivity_MembersInjector.d(launcherActivity, B2());
            LauncherActivity_MembersInjector.b(launcherActivity, n2());
            LauncherActivity_MembersInjector.e(launcherActivity, this.D1.get());
            return launcherActivity;
        }

        private LogManagerInitializer N2(LogManagerInitializer logManagerInitializer) {
            LogManagerInitializer_MembersInjector.a(logManagerInitializer, this.I2.get());
            return logManagerInitializer;
        }

        private PermissionOnboardingFragment O2(PermissionOnboardingFragment permissionOnboardingFragment) {
            PermissionOnboardingFragment_MembersInjector.a(permissionOnboardingFragment, this.f20153y.get());
            PermissionOnboardingFragment_MembersInjector.d(permissionOnboardingFragment, i1());
            PermissionOnboardingFragment_MembersInjector.b(permissionOnboardingFragment, this.f20108p.get());
            PermissionOnboardingFragment_MembersInjector.e(permissionOnboardingFragment, j3());
            PermissionOnboardingFragment_MembersInjector.c(permissionOnboardingFragment, V1());
            return permissionOnboardingFragment;
        }

        private QuickAccessService P2(QuickAccessService quickAccessService) {
            QuickAccessService_MembersInjector.j(quickAccessService, this.X0.get());
            QuickAccessService_MembersInjector.d(quickAccessService, this.f20108p.get());
            QuickAccessService_MembersInjector.m(quickAccessService, this.f20070h1.get());
            QuickAccessService_MembersInjector.a(quickAccessService, this.A1.get());
            QuickAccessService_MembersInjector.o(quickAccessService, t3());
            QuickAccessService_MembersInjector.n(quickAccessService, this.f20041b2.get());
            QuickAccessService_MembersInjector.k(quickAccessService, this.f20086k2.get());
            QuickAccessService_MembersInjector.h(quickAccessService, a3());
            QuickAccessService_MembersInjector.g(quickAccessService, this.A2.get());
            QuickAccessService_MembersInjector.e(quickAccessService, this.f20103o.get());
            QuickAccessService_MembersInjector.i(quickAccessService, V1());
            QuickAccessService_MembersInjector.l(quickAccessService, l3());
            QuickAccessService_MembersInjector.f(quickAccessService, this.R.get());
            QuickAccessService_MembersInjector.b(quickAccessService, L());
            QuickAccessService_MembersInjector.c(quickAccessService, g2());
            return quickAccessService;
        }

        private RidesFragment Q2(RidesFragment ridesFragment) {
            RidesFragment_MembersInjector.a(ridesFragment, r3());
            return ridesFragment;
        }

        private VoipIntentService R2(VoipIntentService voipIntentService) {
            VoipIntentService_MembersInjector.a(voipIntentService, this.T2.get());
            return voipIntentService;
        }

        private WorkManagerInitializer S2(WorkManagerInitializer workManagerInitializer) {
            WorkManagerInitializer_MembersInjector.a(workManagerInitializer, u3());
            return workManagerInitializer;
        }

        private IntentProvider T2() {
            return new IntentProvider(this.f20033a);
        }

        private AnalyticsImpl V1() {
            return new AnalyticsImpl(this.f20033a, this.f20103o.get(), this.f20108p.get(), this.f20153y.get(), E1(), new FirebaseReportManager(), C2());
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> V2() {
            return Collections.singletonMap(LauncherViewModel.class, this.N3);
        }

        private AnonymousAuthClient W1() {
            return new AnonymousAuthClient(l(), DoubleCheck.lazy(this.Z), j2(), new SystemUptimeSource(), this.f20039b0.get(), new PlayStoreVerificationResultToRequestMapper());
        }

        private Map<String, MapProvider> W2() {
            return Collections.singletonMap("googleV2", k3());
        }

        private AppResolver X1() {
            return new AppResolver(this.f20033a, C2());
        }

        private Map<Navigator.Type, Navigator> X2() {
            return MapBuilder.newMapBuilder(9).put(Navigator.Type.NO_NAVIGATION_SELECTED, this.f20096m2.get()).put(Navigator.Type.TAXIFY_NAVIGATION, this.f20101n2.get()).put(Navigator.Type.TWO_GIS_NAVIGATION, this.f20111p2.get()).put(Navigator.Type.YANDEX_MAPS, this.f20116q2.get()).put(Navigator.Type.YANDEX_NAVIGATION, this.f20126s2.get()).put(Navigator.Type.CITY_GUIDE_NAVIGATION, this.f20131t2.get()).put(Navigator.Type.MAPS_ME, this.f20136u2.get()).put(Navigator.Type.GOOGLE_MAPS, this.f20141v2.get()).put(Navigator.Type.WAZE, this.f20146w2.get()).build();
        }

        private AuthConfigurationBackoffStrategy Y1() {
            return new AuthConfigurationBackoffStrategy(this.f20148x.get());
        }

        private Map<OnBoardingStep.Type, OnBoardingStep> Y2() {
            return MapBuilder.newMapBuilder(7).put(OnBoardingStep.Type.PERMISSION_OVERLAY, g3()).put(OnBoardingStep.Type.PERMISSION_RECORD_AUDIO, m3()).put(OnBoardingStep.Type.PERMISSION_OTHER, f3()).put(OnBoardingStep.Type.PERMISSION_NOTIFICATION, b3()).put(OnBoardingStep.Type.PERMISSION_BATTERY_EXCLUSION, e2()).put(OnBoardingStep.Type.PERMISSION_AUTO_START, c2()).put(OnBoardingStep.Type.PERMISSION_NOTIFICATION_SOUND, d3()).build();
        }

        private AuthStepFactory Z1() {
            return new AuthStepFactory(this.f20033a, this.E0.get(), W1(), r0(), a2(), w2(), this.N0.get(), this.f20109p0.get(), this.R1.get(), this.f20108p.get(), this.f20093m.get(), this.E.get(), B2(), n2(), this.R.get(), q2(), this.S1.get(), E2(), new StoreVerificationBackoffStrategy(), Y1(), C2());
        }

        private AuthenticatedAuthClient a2() {
            return new AuthenticatedAuthClient(l(), this.f20093m.get(), DoubleCheck.lazy(this.f20099n0), j2(), this.J.get());
        }

        private NavigationTargetInteractor a3() {
            return new NavigationTargetInteractor(this.X0.get());
        }

        private AutoStartPermissionHelper b2() {
            return UtilsModule_ProvidesAutoStartPermissionHelperFactory.a(this.f20043c, X1());
        }

        private NotificationPermissionStep b3() {
            return new NotificationPermissionStep(this.f20033a, X1(), k2());
        }

        private AutoStartPermissionStep c2() {
            return new AutoStartPermissionStep(X1(), b2());
        }

        private NotificationSoundPermissionHelper c3() {
            return new NotificationSoundPermissionHelper(X1(), this.f20033a);
        }

        private BalanceDeeplinkMapper d2() {
            return new BalanceDeeplinkMapper(this.f20108p.get());
        }

        private NotificationSoundStep d3() {
            return new NotificationSoundStep(c3());
        }

        private BatteryExclusionPermissionStep e2() {
            return new BatteryExclusionPermissionStep(this.f20033a, j3());
        }

        private OtherPermissionHelper e3() {
            return UtilsModule_ProvidesOtherPermissionHelperFactory.a(this.f20043c, X1(), this.f20033a);
        }

        private CampaignRefferralsDeeplinkMapper f2() {
            return new CampaignRefferralsDeeplinkMapper(this.f20108p.get(), v2());
        }

        private OtherPermissionsStep f3() {
            return new OtherPermissionsStep(this.f20033a, X1(), e3());
        }

        private ChatActiveOrderSource g2() {
            return new ChatActiveOrderSource(this.X0.get());
        }

        private OverlayPermissionStep g3() {
            return new OverlayPermissionStep(this.f20033a);
        }

        private ChatClient h2() {
            return new ChatClient(this.f20077i3.get());
        }

        private ChatNetworkInfoProvider i2() {
            return new ChatNetworkInfoProvider(this.U1.get());
        }

        private PartnerIdentityVerificationInitializer i3() {
            return new PartnerIdentityVerificationInitializer(q3(), this.f20084k0.get(), l(), this.E.get(), this.f20069h0.get(), V1(), this.f20108p.get());
        }

        private CompositeResponseTransformer j2() {
            return new CompositeResponseTransformer(new ExposeResponseTransformer());
        }

        private PowerManager j3() {
            return AndroidModule_ProvidesPowerManagerFactory.c(this.f20033a);
        }

        private CustomNotificationManagerHelper k2() {
            return UtilsModule_ProvidesCustomNotificationManagerHelperFactory.a(this.f20043c, X1(), this.f20033a);
        }

        private MapProvider k3() {
            return PlatformModule_ProvideGoogleMapsV2ProviderFactory.a(this.f20058f, this.f20033a);
        }

        private DeeplinkActivityMapper l2() {
            return new DeeplinkActivityMapper(this.f20097m3.get(), this.f20102n3.get(), this.F0.get(), this.f20107o3.get(), d2(), new RideDetailsDeeplinkMapper(), new RejectRideDeeplinkMapper(), new IdentityVerificationDetailsDeeplinkMapper(), new UpcommingRideDetialsDeeplinkMapper(), new UpcommingRidesDeeplinkMapper(), new ChatDeeplinkMapper(), x2(), new PricingDeeplinkMapper(), new CircleKDeeplinkMapper(), this.f20112p3.get(), this.f20117q3.get(), this.f20122r3.get(), this.f20127s3.get(), z2(), y2(), new EarningsGoalDeeplinkMapper(), new CampaignListDeeplinkMapper(), new CampaignDetailsDeeplinkMapper(), new CampaignOptInDeeplinkMapper(), f2(), new PayoutsDetailsDeeplinkMapper(), new PayoutsHistoryDeeplinkMapper(), new PayoutRequirementsDeeplinkMapper(), new PayoutConfirmationDeeplinkMapper(), new NewsInboxDeeplinkMapper(), this.G0.get(), s2(), u2(), t2(), this.f20132t3.get(), this.f20137u3.get(), new FallbackWebPageDeeplinkMapper(), new RequestWebUrlDeeplinkMapper(), new HomeMapSettingsDeeplinkMapper(), this.f20142v3.get());
        }

        private QuickAccessPrefsManager l3() {
            return new QuickAccessPrefsManager(this.f20108p.get());
        }

        private DeeplinkCoordinator m2() {
            return new DeeplinkCoordinator(l2(), this.E0.get(), this.D1.get());
        }

        private RecordAudioPermissionStep m3() {
            return new RecordAudioPermissionStep(this.f20033a, this.f20103o.get(), this.Q.get());
        }

        private DeviceFeatures n2() {
            return new DeviceFeatures(this.f20033a);
        }

        private StateTracker n3() {
            return new StateTracker(this.D1.get());
        }

        private DeviceInfoClient o2() {
            return new DeviceInfoClient(DoubleCheck.lazy(this.H1), this.J.get());
        }

        private TimedAnalyticsImpl o3() {
            return new TimedAnalyticsImpl(this.R0.get());
        }

        private DriverChatUserInfoProvider p2() {
            return new DriverChatUserInfoProvider(this.f20108p.get(), this.f20119r0.get(), this.C.get(), this.E.get(), l());
        }

        private UiNotificationManager p3() {
            return new UiNotificationManager(this.f20033a, T2(), m0(), new VoipEffectsFactory());
        }

        private DriverConfigurationClient q2() {
            return new DriverConfigurationClient(this.f20098n.get(), this.f20075i1.get());
        }

        private UrlFactory q3() {
            return new UrlFactory(l(), this.E.get());
        }

        private DriverDeviceInfoSender r2() {
            return new DriverDeviceInfoSender(o2());
        }

        private ViewModelFactory r3() {
            return new ViewModelFactory(V2());
        }

        private DriverPortalDeeplinkMapper s2() {
            return new DriverPortalDeeplinkMapper(q3());
        }

        private WakeLockManager s3() {
            return new WakeLockManager(j3());
        }

        private DriverPortalRootDeeplinkMapper t2() {
            return new DriverPortalRootDeeplinkMapper(q3());
        }

        private WindowManager t3() {
            return AndroidModule_ProvideWindowManagerFactory.a(this.f20033a);
        }

        private DriverPortalWithHashDeeplinkMapper u2() {
            return new DriverPortalWithHashDeeplinkMapper(q3());
        }

        private WorkerFactorImpl u3() {
            return new WorkerFactorImpl(Collections.emptyMap());
        }

        private DriverReferralCampaignManager v2() {
            return new DriverReferralCampaignManager(this.f20108p.get());
        }

        private DriverRegistrationClient w2() {
            return new DriverRegistrationClient(DoubleCheck.lazy(this.G1), j2());
        }

        private DriverScoreDeeplinkMapper x2() {
            return new DriverScoreDeeplinkMapper(this.f20108p.get());
        }

        private EarningsBreakdownDeeplinkMapper y2() {
            return new EarningsBreakdownDeeplinkMapper(this.f20108p.get());
        }

        private EarningsDeeplinkMapper z2() {
            return new EarningsDeeplinkMapper(this.f20108p.get());
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public RoutingManager A() {
            return this.D1.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public Context A0() {
            return this.f20033a;
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public OptInCampaignAnalytics A1() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public void B(WorkManagerInitializer workManagerInitializer) {
            S2(workManagerInitializer);
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public OrderProvider B0() {
            return this.X0.get();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public SecurityManager B1() {
            return D2();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DeviceInfoApi C() {
            return this.H1.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public DateTimeConverter C0() {
            return this.W1.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DeeplinkHomeContainerCoordinator C1() {
            return this.I0.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public IncidentReportingService D() {
            return this.E2.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DatabaseManager D0() {
            return this.f20095m1.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public PlatformManager D1() {
            return C2();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public void E(AwakeService awakeService) {
            L2(awakeService);
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public WrongStateReporter E0() {
            return this.f20060f1.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public PackageManager E1() {
            return AndroidModule_ProvidesPackageManagerFactory.c(this.f20033a);
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DriverTrainingRestrictionManager F() {
            return this.C0.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public OrderStateStrategy F0() {
            return this.f20150x1.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public ChatService F1() {
            return this.f20055e1.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public TrueTimeProvider G() {
            return this.f20148x.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public InstallationIdProvider G0() {
            return new FirebaseInstallationIdProvider();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public CleverTapManager G1() {
            return this.I1.get();
        }

        @Override // ee.mtakso.driver.platform.di.PlatformDependencies
        public StoreIntegrityVerificationResultToRequestMapper H() {
            return new PlayStoreVerificationResultToRequestMapper();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public void H0(HoursFragment hoursFragment) {
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public DispatchSettingsManager H1() {
            return this.f20091l2.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public GsonConverterFactory I() {
            return this.U.get();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public IdentityVerificationManager I0() {
            return new IdentityVerificationManager(i3());
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public EnvironmentDataProvider I1() {
            return new MockEnvironmentDataProvider();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public EarningsApi J() {
            return this.V2.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DeviceInfoSender J0() {
            return r2();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public ScreenAnalytics J1() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public SafetyToolkitAnalytics K() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public void K0(CancelsFragment cancelsFragment) {
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public PermissionAnalytics K1() {
            return V1();
        }

        @Override // eu.bolt.driver.chat.di.DriverChatApplicationComponent
        public ChatManager L() {
            return DriverChatApplicationModule_ProvideChatManagerFactory.c(this.f20068h, p2(), (ChatRepo) Preconditions.checkNotNullFromComponent(this.f20053e.g()), (ChatConnectionProvider) Preconditions.checkNotNullFromComponent(this.f20053e.a()), (CreateChatInteractor) Preconditions.checkNotNullFromComponent(this.f20053e.f()));
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public AudioRecordingUploadAPI L0() {
            return this.f20057e3.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public VoipNotificationDrawer L1() {
            return p3();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DeviceSettings M() {
            return this.f20093m.get();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public void M0(LogManagerInitializer logManagerInitializer) {
            N2(logManagerInitializer);
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public SettingsAnalytics M1() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public OrderTracing N() {
            return o3();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public LocationTransmitter N0() {
            return this.f20081j2.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public ChatConnectionProvider N1() {
            return (ChatConnectionProvider) Preconditions.checkNotNullFromComponent(this.f20053e.a());
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public NavigationManager O() {
            return this.A2.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public MixpanelController O0() {
            return this.S0.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public CoroutineDispatcher O1() {
            return this.f20098n.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DriverAuthAnonymousApi P() {
            return this.f20039b0.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public NewsAnalytics P0() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public VerificationAnalytics P1() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public OrderStateManager Q() {
            return this.f20086k2.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DriverManager Q0() {
            return this.f20090l1.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public ResponseErrorProcessor Q1() {
            return this.J.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public AppLogWatcher R() {
            return this.f20135u1.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public PayoutAnalytics R0() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public BackgroundManager R1() {
            return this.A1.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public ReferralCampaignsAnalytics S() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public ApiExceptionProvider S0() {
            return this.J.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public PartnerOffersAnalytics S1() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public VoipActiveWindowTracker T() {
            return this.f20036a2.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public ShardApiProvider T0() {
            return this.f20054e0.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public TokenManager T1() {
            return this.f20119r0.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public TempDriverConfigHolder U() {
            return this.S1.get();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public void U0(LauncherActivity launcherActivity) {
            M2(launcherActivity);
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public TimedAnalyticsManager U1() {
            return this.R0.get();
        }

        public LightAuthFlow U2() {
            return new LightAuthFlow(Z1(), this.f20109p0.get());
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public NetworkService V() {
            return this.U1.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public DriverStatusSender V0() {
            return this.f20070h1.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public NoAnswerCallCache W() {
            return this.J2.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public AudioRecordingAnalytics W0() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public ContactApi X() {
            return this.G2.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public TranslationManager X0() {
            return this.N0.get();
        }

        @Override // ee.mtakso.driver.platform.di.PlatformDependencies
        public ConfirmationCodeRetriever Y() {
            return this.f20062f3.get();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public void Y0(PermissionOnboardingFragment permissionOnboardingFragment) {
            O2(permissionOnboardingFragment);
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DeepLinkManager Z() {
            return this.E0.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DriverRegistrationApi Z0() {
            return this.G1.get();
        }

        public MapManager Z2() {
            return new MapManager(W2());
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public LanguageManager a() {
            return this.E.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public SignUpAnalytics a0() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public RawTranslationProvider a1() {
            return this.f20047c3.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public ReadMessageInteractor b() {
            return (ReadMessageInteractor) Preconditions.checkNotNullFromComponent(this.f20053e.b());
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public AuthenticatedAuthApi b0() {
            return this.f20099n0.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public Gson b1() {
            return this.T.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public SendChatMessageInteractor c() {
            return (SendChatMessageInteractor) Preconditions.checkNotNullFromComponent(this.f20053e.c());
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public SupportApi c0() {
            return this.U2.get();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public void c1(RidesFragment ridesFragment) {
            Q2(ridesFragment);
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public ChatPushHandler d() {
            return (ChatPushHandler) Preconditions.checkNotNullFromComponent(this.f20053e.d());
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public ErrorHandler d0() {
            return new ErrorHandler(this.f20033a);
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DriverAnalytics d1() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public RequestReplySuggestionsInteractor e() {
            return (RequestReplySuggestionsInteractor) Preconditions.checkNotNullFromComponent(this.f20053e.e());
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public LocationStorageCleaner e0() {
            return this.f20076i2.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public PartnerTokenManager e1() {
            return this.f20069h0.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public OrdersCache f() {
            return this.X0.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public WebViewStrategy f0() {
            return this.f20155y1.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public VoipService f1() {
            return this.T2.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public ChatRepo g() {
            return (ChatRepo) Preconditions.checkNotNullFromComponent(this.f20053e.g());
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public AppRoutingManager g0() {
            return this.U0.get();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public ReportManager g1() {
            return new FirebaseReportManager();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public void h(VoipIntentService voipIntentService) {
            R2(voipIntentService);
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public TokenProvider h0() {
            return new FirebasePushTokenManager();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public SessionProvider h1() {
            return this.C.get();
        }

        public PackageInfo h3() {
            return AndroidModule_ProvidePackageInfoFactory.c(this.f20033a);
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public LoginAnalytics i() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public PermissionManager i0() {
            return this.Q.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public OnBoardingManager i1() {
            return new OnBoardingManager(this.f20108p.get(), Y2());
        }

        @Override // ee.mtakso.driver.platform.di.PlatformDependencies
        public PushManager j() {
            return this.R1.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public HtmlEngine j0() {
            return this.f20042b3.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public DriverDestinationsManager j1() {
            return this.Z1.get();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public void k(App app) {
            K2(app);
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public AppVerificationAnalytics k0() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public SurgeManager k1() {
            return this.f20041b2.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DeviceInfo l() {
            return ReleaseDeviceInfoModule_ProvidesDeviceInfoFactory.c(this.f20038b, h3(), this.f20138v.get());
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public EarningsGoalApi l0() {
            return this.W2.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DriverConfigurationApi l1() {
            return this.f20075i1.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public StartUpTracing m() {
            return o3();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public NotificationManager m0() {
            return AndroidModule_ProvideNotificationManagerFactory.c(this.f20033a);
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public LogWorker m1() {
            return this.f20130t1.get();
        }

        @Override // eu.bolt.driver.chat.di.DriverChatApplicationComponent
        public ChatKit.Dependencies n() {
            return DriverChatApplicationModule_ProvideChatKitDependenciesFactory.a(this.f20068h, i2(), p2(), DoubleCheck.lazy(this.f20067g3), this.f20035a1.get(), this.f20072h3.get(), h2(), new ActiveChatsMapper(), new MessageTranslationRatingMapper(), new ChatIdGenerator(), new ChatRxSchedulers());
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public ChatAnalytics n0() {
            return V1();
        }

        @Override // eu.bolt.driver.chat.di.DriverChatApplicationComponent
        public ChatNotificationManager n1() {
            return this.f20067g3.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public AnonymousAuthApi o() {
            return this.Z.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public OkHttpClient o0() {
            return this.f20049d0.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public GeoLocationManager o1() {
            return this.R.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public AdvertiserIdProvider p() {
            return A2();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public VectorTileBitmapPool p0() {
            return this.Y2.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public CampaignAnalytics p1() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public WorkingTimeManager q() {
            return this.f20051d2.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public VoipRxLifecycleTransfromer q0() {
            return this.B2.get();
        }

        @Override // ee.mtakso.driver.platform.di.PlatformDependencies
        public StoreIntegrityCheck q1() {
            return E2();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public BigQueryLogWatcher r() {
            return this.f20145w1.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public PartnerClient r0() {
            return new PartnerClient(this.f20159z0.get());
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public LogManager r1() {
            return this.I2.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public EarningsBalanceApi s() {
            return this.X2.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public SoundEffectsPool s0() {
            return this.F2.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public WebViewAnalytics s1() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public DriverProvider t() {
            return this.f20108p.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public PushNotificationManager t0() {
            return this.N1.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public NotRespondReporter t1() {
            return this.f20060f1.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public HistoryAnalytics u() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public Poller u0() {
            return this.F1.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public OrderFlowAnalytics u1() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public PushManagerImpl v() {
            return this.R1.get();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public void v0(AnalyticsInitializer analyticsInitializer) {
            J2(analyticsInitializer);
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public DateTimeFormatter v1() {
            return this.V1.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public MapProvider w() {
            return MapModule_ProvideMapV2Factory.a(this.f20063g, Z2());
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public AuthManager w0() {
            return this.f20109p0.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public QuickAccessStateAnalytics w1() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.modules.ApplicationComponent
        public void x(QuickAccessService quickAccessService) {
            P2(quickAccessService);
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public AnalyticsManager x0() {
            return this.f20153y.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public AppsflyerManager x1() {
            return this.T0.get();
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public NavigationAppTypeFactory y() {
            return new NavigationAppTypeFactory(X2());
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public SimpleXmlConverterFactory y0() {
            NetworkModule networkModule = this.f20048d;
            return NetworkModule_ProvideJaxbConverterFactoryFactory.c(networkModule, NetworkModule_ProvideSerializerFactory.c(networkModule));
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedModuleDeps
        public AppPerformanceAnalytics y1() {
            return V1();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public Features z() {
            return this.f20103o.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public DriverStatusProvider z0() {
            return this.f20070h1.get();
        }

        @Override // ee.mtakso.driver.di.anonymous.AnonymousModuleDeps
        public PlatformAvailabilityManager z1() {
            return B2();
        }
    }

    private DaggerReleaseApplicationComponent() {
    }

    public static ReleaseApplicationComponent.Builder a() {
        return new Builder();
    }
}
