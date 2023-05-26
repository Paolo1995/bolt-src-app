package ee.mtakso.driver.di.authorised;

import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MapBuilder;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.deeplink.DeepLinkParser_Factory;
import ee.mtakso.driver.di.authorised.AuthorisedComponent;
import ee.mtakso.driver.di.modules.ApplicationComponent;
import ee.mtakso.driver.di.modules.PollerModule;
import ee.mtakso.driver.di.modules.PollerModule_ProvidePollerDataSourceFactory;
import ee.mtakso.driver.di.modules.PollerModule_ProvidePollerServiceFactory;
import ee.mtakso.driver.di.modules.ThemeModule;
import ee.mtakso.driver.di.modules.ThemeModule_ProvideThemeHelperFactory;
import ee.mtakso.driver.di.modules.TripAudioRecordingModule;
import ee.mtakso.driver.di.modules.TripAudioRecordingModule_ProvideAudioRecordingAPIFactory;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.identity.verification.IdentityVerificationInitializer;
import ee.mtakso.driver.identity.verification.IdentityVerificationManager;
import ee.mtakso.driver.log.InternalLog;
import ee.mtakso.driver.log.InternalLog_Factory;
import ee.mtakso.driver.log.LogFilter_Factory;
import ee.mtakso.driver.log.LogManager;
import ee.mtakso.driver.log.LogService;
import ee.mtakso.driver.log.LogService_Factory;
import ee.mtakso.driver.log.LogWorker;
import ee.mtakso.driver.log.StorageConsumer;
import ee.mtakso.driver.log.StorageConsumer_Factory;
import ee.mtakso.driver.log.applog.AppLogWatcher;
import ee.mtakso.driver.log.bigquery.BigQueryLogWatcher;
import ee.mtakso.driver.log.report.ReportManager;
import ee.mtakso.driver.log.storage.DatabaseManager;
import ee.mtakso.driver.log.storage.LogSaver;
import ee.mtakso.driver.log.storage.LogSaver_Factory;
import ee.mtakso.driver.log.storage.LogStorage;
import ee.mtakso.driver.log.storage.LogStorage_Factory;
import ee.mtakso.driver.log.strategy.ActivityLifecycleStrategy;
import ee.mtakso.driver.log.strategy.ActivityLifecycleStrategy_Factory;
import ee.mtakso.driver.log.strategy.CompositeWatcher;
import ee.mtakso.driver.log.strategy.CompositeWatcher_Factory;
import ee.mtakso.driver.log.strategy.DidNotRespondStrategy;
import ee.mtakso.driver.log.strategy.DidNotRespondStrategy_Factory;
import ee.mtakso.driver.log.strategy.DriverOfflineDetectionStrategy;
import ee.mtakso.driver.log.strategy.DriverOfflineDetectionStrategy_Factory;
import ee.mtakso.driver.log.strategy.DriverWrongStateStrategy;
import ee.mtakso.driver.log.strategy.DriverWrongStateStrategy_Factory;
import ee.mtakso.driver.log.strategy.LocationStrategy;
import ee.mtakso.driver.log.strategy.LocationStrategy_Factory;
import ee.mtakso.driver.log.strategy.OrderStateStrategy;
import ee.mtakso.driver.log.strategy.OrderStateStrategy_Factory;
import ee.mtakso.driver.log.strategy.OrderWrongStateStrategy;
import ee.mtakso.driver.log.strategy.OrderWrongStateStrategy_Factory;
import ee.mtakso.driver.log.strategy.WebViewStrategy_Factory;
import ee.mtakso.driver.log.strategy.memory.WebViewStrategy;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.navigation.DynamicNavigationMapper_Factory;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.navigation.NavigationManager;
import ee.mtakso.driver.network.ApiExceptionProvider;
import ee.mtakso.driver.network.client.ApiFactory;
import ee.mtakso.driver.network.client.ApiFactory_Factory;
import ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient;
import ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient_Factory;
import ee.mtakso.driver.network.client.audio_recording.AudioRecordingNetworkAPI;
import ee.mtakso.driver.network.client.audio_recording.support.TripAudioSupportClient;
import ee.mtakso.driver.network.client.audio_recording.support.TripAudioSupportClient_Factory;
import ee.mtakso.driver.network.client.audio_recording.upload.AudioRecordingUploadAPI;
import ee.mtakso.driver.network.client.audio_recording.upload.AudioRecordingUploadClient;
import ee.mtakso.driver.network.client.audio_recording.upload.AudioRecordingUploadClient_Factory;
import ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager;
import ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager_Factory;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthApi;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient;
import ee.mtakso.driver.network.client.auth.authenticated.AuthenticatedAuthClient_Factory;
import ee.mtakso.driver.network.client.boltclub.BoltClubApi;
import ee.mtakso.driver.network.client.campaign.CampaignApi;
import ee.mtakso.driver.network.client.campaign.CampaignClient;
import ee.mtakso.driver.network.client.campaign.CampaignClient_Factory;
import ee.mtakso.driver.network.client.campaign.CircleKApi;
import ee.mtakso.driver.network.client.campaign.CircleKClient;
import ee.mtakso.driver.network.client.campaign.CircleKClient_Factory;
import ee.mtakso.driver.network.client.contact.ContactApi;
import ee.mtakso.driver.network.client.contact.ContactClient;
import ee.mtakso.driver.network.client.contact.ContactClient_Factory;
import ee.mtakso.driver.network.client.dashboard.DashboardClient;
import ee.mtakso.driver.network.client.dashboard.DashboardClient_Factory;
import ee.mtakso.driver.network.client.device.DeviceInfoApi;
import ee.mtakso.driver.network.client.device.DeviceInfoClient;
import ee.mtakso.driver.network.client.device.DeviceInfoClient_Factory;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.DriverClient_Factory;
import ee.mtakso.driver.network.client.driver.DriverPricingConfigurationApi;
import ee.mtakso.driver.network.client.driver.DriverPricingConfigurationClient;
import ee.mtakso.driver.network.client.driver.DriverPricingConfigurationClient_Factory;
import ee.mtakso.driver.network.client.driver.WaybillApi;
import ee.mtakso.driver.network.client.driver.WaybillClient;
import ee.mtakso.driver.network.client.driver.WaybillClient_Factory;
import ee.mtakso.driver.network.client.driver.navigation.DriverNavigationConfigurationApi;
import ee.mtakso.driver.network.client.driver.navigation.DriverNavigationConfigurationClient;
import ee.mtakso.driver.network.client.driver.navigation.DriverNavigationConfigurationClient_Factory;
import ee.mtakso.driver.network.client.earnings.EarningsApi;
import ee.mtakso.driver.network.client.earnings.EarningsClient;
import ee.mtakso.driver.network.client.earnings.EarningsClient_Factory;
import ee.mtakso.driver.network.client.earnings.PayoutApi;
import ee.mtakso.driver.network.client.earnings.PayoutClient;
import ee.mtakso.driver.network.client.earnings.PayoutClient_Factory;
import ee.mtakso.driver.network.client.emergencyassist.EmergencyAssistApi;
import ee.mtakso.driver.network.client.emergencyassist.EmergencyAssistClient;
import ee.mtakso.driver.network.client.emergencyassist.EmergencyAssistClient_Factory;
import ee.mtakso.driver.network.client.geo.GeoApi;
import ee.mtakso.driver.network.client.geo.GeoClient;
import ee.mtakso.driver.network.client.geo.GeoClient_Factory;
import ee.mtakso.driver.network.client.modal.ModalApi;
import ee.mtakso.driver.network.client.modal.ModalClient;
import ee.mtakso.driver.network.client.modal.ModalClient_Factory;
import ee.mtakso.driver.network.client.order.DriverOrderApi;
import ee.mtakso.driver.network.client.order.DriverOrderClient;
import ee.mtakso.driver.network.client.order.DriverOrderClient_Factory;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.network.client.order.OrderClient_Factory;
import ee.mtakso.driver.network.client.order.RideHistoryApi;
import ee.mtakso.driver.network.client.order.RideHistoryClient;
import ee.mtakso.driver.network.client.order.RideHistoryClient_Factory;
import ee.mtakso.driver.network.client.payments.EarningsPaymentApi;
import ee.mtakso.driver.network.client.payments.EarningsPaymentClient;
import ee.mtakso.driver.network.client.payments.EarningsPaymentClient_Factory;
import ee.mtakso.driver.network.client.price.PriceReviewApi;
import ee.mtakso.driver.network.client.price.PriceReviewClient;
import ee.mtakso.driver.network.client.price.PriceReviewClient_Factory;
import ee.mtakso.driver.network.client.priority.DriverPriorityClient;
import ee.mtakso.driver.network.client.priority.DriverPriorityClient_Factory;
import ee.mtakso.driver.network.client.route_sharing.RouteSharingApi;
import ee.mtakso.driver.network.client.route_sharing.RouteSharingClient;
import ee.mtakso.driver.network.client.route_sharing.RouteSharingClient_Factory;
import ee.mtakso.driver.network.client.score.DriverScoreApi;
import ee.mtakso.driver.network.client.score.DriverScoreClient;
import ee.mtakso.driver.network.client.score.DriverScoreClient_Factory;
import ee.mtakso.driver.network.client.search.SearchApi;
import ee.mtakso.driver.network.client.search.SearchClient;
import ee.mtakso.driver.network.client.search.SearchClient_Factory;
import ee.mtakso.driver.network.client.support.SupportApi;
import ee.mtakso.driver.network.client.support.SupportClient;
import ee.mtakso.driver.network.client.support.SupportClient_Factory;
import ee.mtakso.driver.network.client.tile.TileClient;
import ee.mtakso.driver.network.client.tile.TileClient_Factory;
import ee.mtakso.driver.network.client.training.TrainingApi;
import ee.mtakso.driver.network.client.training.TrainingClient;
import ee.mtakso.driver.network.client.training.TrainingClient_Factory;
import ee.mtakso.driver.network.client.vehicle.CarApplicationApi;
import ee.mtakso.driver.network.client.vehicle.CarApplicationClient;
import ee.mtakso.driver.network.client.vehicle.CarApplicationClient_Factory;
import ee.mtakso.driver.network.client.voip.VoipApi;
import ee.mtakso.driver.network.client.voip.VoipClient;
import ee.mtakso.driver.network.client.voip.VoipClient_Factory;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.network.response.CompositeResponseTransformer_Factory;
import ee.mtakso.driver.network.response.ExposeResponseTransformer_Factory;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.network.usage.NetworkUsageManager;
import ee.mtakso.driver.network.usage.NetworkUsageManager_Factory;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverReferralCampaignManager;
import ee.mtakso.driver.param.DriverReferralCampaignManager_Factory;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.param.DriverSettingsInMemory;
import ee.mtakso.driver.param.DriverSettingsInMemory_Factory;
import ee.mtakso.driver.param.RateMePrefsManager;
import ee.mtakso.driver.param.RateMePrefsManager_Factory;
import ee.mtakso.driver.param.VoipPrefsManager;
import ee.mtakso.driver.platform.ads.AdvertiserIdProvider;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.installation.InstallationIdProvider;
import ee.mtakso.driver.platform.push.TokenProvider;
import ee.mtakso.driver.service.AwakeServiceLauncher;
import ee.mtakso.driver.service.AwakeServiceLauncher_Factory;
import ee.mtakso.driver.service.BaseService;
import ee.mtakso.driver.service.WorkDistanceDelegate;
import ee.mtakso.driver.service.WorkDistanceDelegate_Factory;
import ee.mtakso.driver.service.analytics.controller.MixpanelController;
import ee.mtakso.driver.service.analytics.event.AnalyticsImpl;
import ee.mtakso.driver.service.analytics.event.AnalyticsImpl_Factory;
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
import ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics;
import ee.mtakso.driver.service.analytics.event.wrapper.AttributedAnalyticsDelegate;
import ee.mtakso.driver.service.analytics.event.wrapper.AttributedAnalyticsDelegate_Factory;
import ee.mtakso.driver.service.analytics.timed.TimedAnalyticsImpl;
import ee.mtakso.driver.service.analytics.timed.TimedAnalyticsImpl_Factory;
import ee.mtakso.driver.service.analytics.timed.TimedAnalyticsManager;
import ee.mtakso.driver.service.analytics.timed.facade.OrderTracing;
import ee.mtakso.driver.service.analytics.timed.facade.StartUpTracing;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthService;
import ee.mtakso.driver.service.auth.AuthService_Factory;
import ee.mtakso.driver.service.auth.AuthorisedServicesRunner;
import ee.mtakso.driver.service.auth.AuthorisedServicesRunner_Factory;
import ee.mtakso.driver.service.auth.audiorecording.AudioRecordingService;
import ee.mtakso.driver.service.auth.audiorecording.AudioRecordingService_Factory;
import ee.mtakso.driver.service.b2b.B2bManager;
import ee.mtakso.driver.service.b2b.B2bManager_Factory;
import ee.mtakso.driver.service.b2b.B2bService;
import ee.mtakso.driver.service.b2b.B2bService_Factory;
import ee.mtakso.driver.service.campaign.ActiveCampaignInfoRefreshService;
import ee.mtakso.driver.service.campaign.ActiveCampaignInfoRefreshService_Factory;
import ee.mtakso.driver.service.campaign.CampaignManager;
import ee.mtakso.driver.service.campaign.CampaignManager_Factory;
import ee.mtakso.driver.service.chat.ChatActiveOrderSource;
import ee.mtakso.driver.service.chat.ChatActiveOrderSource_Factory;
import ee.mtakso.driver.service.chat.ChatMessageMapper_Factory;
import ee.mtakso.driver.service.chat.ChatService;
import ee.mtakso.driver.service.connectivity.ConnectionMessageManager;
import ee.mtakso.driver.service.connectivity.ConnectionMessageManager_Factory;
import ee.mtakso.driver.service.connectivity.NetworkService;
import ee.mtakso.driver.service.contact.ContactOptionsService;
import ee.mtakso.driver.service.contact.ContactOptionsService_Factory;
import ee.mtakso.driver.service.dashboard.DashboardService;
import ee.mtakso.driver.service.dashboard.DashboardService_Factory;
import ee.mtakso.driver.service.deeplinks.ExecutableDeeplinkManager;
import ee.mtakso.driver.service.deeplinks.ExecutableDeeplinkManager_Factory;
import ee.mtakso.driver.service.device.fingerprint.DeviceFingerprintCollector;
import ee.mtakso.driver.service.device.fingerprint.DeviceFingerprintCollector_Factory;
import ee.mtakso.driver.service.device.fingerprint.DeviceFingerprintManager;
import ee.mtakso.driver.service.device.fingerprint.DeviceFingerprintManager_Factory;
import ee.mtakso.driver.service.device.fingerprint.DeviceFingerprintService;
import ee.mtakso.driver.service.device.fingerprint.DeviceFingerprintService_Factory;
import ee.mtakso.driver.service.deviceinfo.DeviceInfoSender;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.driver.DriverStateService;
import ee.mtakso.driver.service.driver.DriverStateService_Factory;
import ee.mtakso.driver.service.driver.other.OtherDriversManager;
import ee.mtakso.driver.service.driver.other.OtherDriversManager_Factory;
import ee.mtakso.driver.service.driver.other.UpdateOtherDriversService;
import ee.mtakso.driver.service.driver.other.UpdateOtherDriversService_Factory;
import ee.mtakso.driver.service.earnings.EarningsManager;
import ee.mtakso.driver.service.earnings.EarningsManager_Factory;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.GeoService;
import ee.mtakso.driver.service.geo.GeoService_Factory;
import ee.mtakso.driver.service.geo.route.RouteManager;
import ee.mtakso.driver.service.geo.route.RouteManager_Factory;
import ee.mtakso.driver.service.geo.storage.LocationStorageCleaner;
import ee.mtakso.driver.service.geo.transmitter.LocationTransmitter;
import ee.mtakso.driver.service.geo.transmitter.TransmissionService;
import ee.mtakso.driver.service.geo.transmitter.TransmissionService_Factory;
import ee.mtakso.driver.service.google.FirebaseRemoteConfigManager_Factory;
import ee.mtakso.driver.service.integration.appsflyer.AppsflyerManager;
import ee.mtakso.driver.service.integration.clevertap.CleverTapManager;
import ee.mtakso.driver.service.integration.clevertap.CleverTapService;
import ee.mtakso.driver.service.integration.clevertap.CleverTapService_Factory;
import ee.mtakso.driver.service.integration.clevertap.FcmCleverTapPushTokenHandler;
import ee.mtakso.driver.service.integration.clevertap.FcmCleverTapPushTokenHandler_Factory;
import ee.mtakso.driver.service.integration.mixpanel.MixpanelService;
import ee.mtakso.driver.service.integration.mixpanel.MixpanelService_Factory;
import ee.mtakso.driver.service.language.LanguageListProviderImpl;
import ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService;
import ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService_Factory;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsService;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsService_Factory;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistHelpProviderService;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistHelpProviderService_Factory;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager_Factory;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager_Factory;
import ee.mtakso.driver.service.modules.fifo.FifoQueueService;
import ee.mtakso.driver.service.modules.fifo.FifoQueueService_Factory;
import ee.mtakso.driver.service.modules.incident.IncidentReportingService;
import ee.mtakso.driver.service.modules.map.HeatmapConfigProvider;
import ee.mtakso.driver.service.modules.map.HeatmapConfigProvider_Factory;
import ee.mtakso.driver.service.modules.map.HeatmapOptionProvider;
import ee.mtakso.driver.service.modules.map.HeatmapOptionProvider_Factory;
import ee.mtakso.driver.service.modules.map.HeatmapSettingManager;
import ee.mtakso.driver.service.modules.map.HeatmapSettingManager_Factory;
import ee.mtakso.driver.service.modules.map.HeatmapSettingService;
import ee.mtakso.driver.service.modules.map.HeatmapSettingService_Factory;
import ee.mtakso.driver.service.modules.map.MapsConfigsService;
import ee.mtakso.driver.service.modules.map.MapsConfigsService_Factory;
import ee.mtakso.driver.service.modules.map.TileRequestMerger;
import ee.mtakso.driver.service.modules.map.TileRequestMerger_Factory;
import ee.mtakso.driver.service.modules.order.v2.DynamicStopDetailsService;
import ee.mtakso.driver.service.modules.order.v2.DynamicStopDetailsService_Factory;
import ee.mtakso.driver.service.modules.order.v2.OrderHistoryManager;
import ee.mtakso.driver.service.modules.order.v2.OrderHistoryManager_Factory;
import ee.mtakso.driver.service.modules.order.v2.OrderStateManager;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker_Factory;
import ee.mtakso.driver.service.modules.order.v2.PollingAnalyticsService;
import ee.mtakso.driver.service.modules.order.v2.PollingAnalyticsService_Factory;
import ee.mtakso.driver.service.modules.order.v2.RideStopPollerLaunchService;
import ee.mtakso.driver.service.modules.order.v2.RideStopPollerLaunchService_Factory;
import ee.mtakso.driver.service.modules.order.v2.StaticStopDetailsService;
import ee.mtakso.driver.service.modules.order.v2.StaticStopDetailsService_Factory;
import ee.mtakso.driver.service.modules.order.v2.StopDetailsService;
import ee.mtakso.driver.service.modules.polling.Poller;
import ee.mtakso.driver.service.modules.polling.PollingLoggerService;
import ee.mtakso.driver.service.modules.polling.PollingLoggerService_Factory;
import ee.mtakso.driver.service.modules.polling.PollingRetryStrategy_Factory;
import ee.mtakso.driver.service.modules.reminder.AutoReminderImpl;
import ee.mtakso.driver.service.modules.reminder.AutoReminderImpl_Factory;
import ee.mtakso.driver.service.modules.reporters.NotRespondReporter;
import ee.mtakso.driver.service.modules.reporters.WrongStateReporter;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import ee.mtakso.driver.service.modules.status.DriverStatusService;
import ee.mtakso.driver.service.modules.status.DriverStatusService_Factory;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import ee.mtakso.driver.service.modules.surge.SurgeService;
import ee.mtakso.driver.service.modules.surge.SurgeService_Factory;
import ee.mtakso.driver.service.modules.tile.FeaturePropertiesFactory;
import ee.mtakso.driver.service.modules.tile.FeaturePropertiesFactory_Factory;
import ee.mtakso.driver.service.modules.tile.VectorPropertiesFactory;
import ee.mtakso.driver.service.modules.tile.VectorPropertiesFactory_Factory;
import ee.mtakso.driver.service.order.ScheduledOrderManager;
import ee.mtakso.driver.service.order.ScheduledOrderManager_Factory;
import ee.mtakso.driver.service.order.ScheduledOrderProvider;
import ee.mtakso.driver.service.order.ScheduledOrderProvider_Factory;
import ee.mtakso.driver.service.order.details.CacheCleanupService;
import ee.mtakso.driver.service.order.details.CacheCleanupService_Factory;
import ee.mtakso.driver.service.order.details.OrderManager;
import ee.mtakso.driver.service.order.details.OrderManager_Factory;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.order.details.OrderTimerService;
import ee.mtakso.driver.service.order.details.OrderTimerService_Factory;
import ee.mtakso.driver.service.order.details.OrderTryAgainManager;
import ee.mtakso.driver.service.order.details.OrderTryAgainManager_Factory;
import ee.mtakso.driver.service.order.details.OrderUpdaterService;
import ee.mtakso.driver.service.order.details.OrderUpdaterService_Factory;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.service.order.routing.IncomingOrderRoutingCoordinator;
import ee.mtakso.driver.service.order.routing.IncomingOrderRoutingCoordinator_Factory;
import ee.mtakso.driver.service.order.routing.IntentProvider;
import ee.mtakso.driver.service.order.routing.IntentProvider_Factory;
import ee.mtakso.driver.service.order.routing.OrderRoutingService;
import ee.mtakso.driver.service.order.routing.OrderRoutingService_Factory;
import ee.mtakso.driver.service.pollerv2.DynamicPollingService;
import ee.mtakso.driver.service.pollerv2.DynamicPollingService_Factory;
import ee.mtakso.driver.service.pollerv2.FixedPollingService;
import ee.mtakso.driver.service.pollerv2.FixedPollingService_Factory;
import ee.mtakso.driver.service.pollerv2.PollerManager;
import ee.mtakso.driver.service.pollerv2.PollerManager_Factory;
import ee.mtakso.driver.service.pollerv2.PollerService;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import ee.mtakso.driver.service.polling.message.PollMessageCache;
import ee.mtakso.driver.service.polling.message.PollMessageCache_Factory;
import ee.mtakso.driver.service.polling.message.PollMessageManager;
import ee.mtakso.driver.service.polling.message.PollMessageManager_Factory;
import ee.mtakso.driver.service.polling.message.PollMessageService;
import ee.mtakso.driver.service.polling.message.PollMessageService_Factory;
import ee.mtakso.driver.service.push.AuthPushService;
import ee.mtakso.driver.service.push.AuthPushService_Factory;
import ee.mtakso.driver.service.push.PushHandler;
import ee.mtakso.driver.service.push.PushManagerImpl;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.service.push.PushTokenHandler;
import ee.mtakso.driver.service.push.handler.ChatPushHandlerWrapper;
import ee.mtakso.driver.service.push.handler.ChatPushHandlerWrapper_Factory;
import ee.mtakso.driver.service.push.handler.InternalTokenHandler_Factory;
import ee.mtakso.driver.service.push.handler.NewOrderPushHandler;
import ee.mtakso.driver.service.push.handler.NewOrderPushHandler_Factory;
import ee.mtakso.driver.service.push.handler.OrderTerminatedPushHandler;
import ee.mtakso.driver.service.push.handler.OrderTerminatedPushHandler_Factory;
import ee.mtakso.driver.service.push.handler.RateAppPushHandler;
import ee.mtakso.driver.service.push.handler.RateAppPushHandler_Factory;
import ee.mtakso.driver.service.push.handler.RouteUpdatePushHandler;
import ee.mtakso.driver.service.push.handler.RouteUpdatePushHandler_Factory;
import ee.mtakso.driver.service.push.handler.ScheduledOrderPushHandler;
import ee.mtakso.driver.service.push.handler.ScheduledOrderPushHandler_Factory;
import ee.mtakso.driver.service.push.handler.TipsPushHandler;
import ee.mtakso.driver.service.push.handler.TipsPushHandler_Factory;
import ee.mtakso.driver.service.push.handler.VoipPushHandler;
import ee.mtakso.driver.service.push.handler.VoipPushHandler_Factory;
import ee.mtakso.driver.service.rating.app.AppRatingManager;
import ee.mtakso.driver.service.rating.app.AppRatingManager_Factory;
import ee.mtakso.driver.service.restriction.DriverBlockService;
import ee.mtakso.driver.service.restriction.DriverBlockService_Factory;
import ee.mtakso.driver.service.restriction.DriverRestrictionManager;
import ee.mtakso.driver.service.restriction.DriverRestrictionManager_Factory;
import ee.mtakso.driver.service.restriction.DriverTrainingRestrictionManager;
import ee.mtakso.driver.service.restriction.LocationStateService;
import ee.mtakso.driver.service.restriction.LocationStateService_Factory;
import ee.mtakso.driver.service.restriction.MockLocationService;
import ee.mtakso.driver.service.restriction.MockLocationService_Factory;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.service.routing.AutoNavigationManager;
import ee.mtakso.driver.service.routing.AutoNavigationManager_Factory;
import ee.mtakso.driver.service.routing.AutoNavigationRoutingService;
import ee.mtakso.driver.service.routing.AutoNavigationRoutingService_Factory;
import ee.mtakso.driver.service.routing.OrderAppRoutingService;
import ee.mtakso.driver.service.routing.OrderAppRoutingService_Factory;
import ee.mtakso.driver.service.session.SessionProvider;
import ee.mtakso.driver.service.session.SessionService;
import ee.mtakso.driver.service.session.SessionService_Factory;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.service.settings.DispatchSettingsService;
import ee.mtakso.driver.service.settings.DispatchSettingsService_Factory;
import ee.mtakso.driver.service.thirdparty_incident.ThirdPartyIncidentService;
import ee.mtakso.driver.service.thirdparty_incident.ThirdPartyIncidentService_Factory;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.service.token.InvalidateTokenService;
import ee.mtakso.driver.service.token.InvalidateTokenService_Factory;
import ee.mtakso.driver.service.token.TokenManager;
import ee.mtakso.driver.service.voip.VoipCache;
import ee.mtakso.driver.service.voip.VoipCache_Factory;
import ee.mtakso.driver.service.voip.VoipService;
import ee.mtakso.driver.service.voip.effects.VoipEffectsFactory;
import ee.mtakso.driver.service.voip.effects.VoipEffectsFactory_Factory;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipActiveWindowTracker;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipRxLifecycleTransfromer;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerCallCache;
import ee.mtakso.driver.service.workingtime.WorkingTimeManager;
import ee.mtakso.driver.service.workingtime.WorkingTimeUpdateService;
import ee.mtakso.driver.service.workingtime.WorkingTimeUpdateService_Factory;
import ee.mtakso.driver.ui.DebugTweaksMenu_Factory;
import ee.mtakso.driver.ui.base.BaseActivity_MembersInjector;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity_MembersInjector;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment_MembersInjector;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.common.internet.InternetDataDelegate;
import ee.mtakso.driver.ui.common.internet.InternetDataDelegate_Factory;
import ee.mtakso.driver.ui.common.map.MapPaddingViewModel;
import ee.mtakso.driver.ui.common.map.MapPaddingViewModel_Factory;
import ee.mtakso.driver.ui.common.mapping.FlatGenericSectionsMapper_Factory;
import ee.mtakso.driver.ui.common.mapping.InformationMessageMapper_Factory;
import ee.mtakso.driver.ui.common.mapping.SimpleTextMapper_Factory;
import ee.mtakso.driver.ui.common.push.PushDataService;
import ee.mtakso.driver.ui.common.push.PushDataService_Factory;
import ee.mtakso.driver.ui.common.push.PushDialogDelegate;
import ee.mtakso.driver.ui.common.push.PushDialogDelegate_Factory;
import ee.mtakso.driver.ui.helper.ErrorHandler;
import ee.mtakso.driver.ui.interactor.WorkTimeInteractor;
import ee.mtakso.driver.ui.interactor.WorkTimeInteractor_Factory;
import ee.mtakso.driver.ui.interactor.activity.DriverActivityInteractor;
import ee.mtakso.driver.ui.interactor.activity.DriverActivityInteractor_Factory;
import ee.mtakso.driver.ui.interactor.call.NoAnswerIncomingCallInteractor;
import ee.mtakso.driver.ui.interactor.call.NoAnswerIncomingCallInteractor_Factory;
import ee.mtakso.driver.ui.interactor.dashboard.GetDashboardInteractor;
import ee.mtakso.driver.ui.interactor.dashboard.GetDashboardInteractor_Factory;
import ee.mtakso.driver.ui.interactor.destination.ActiveDestinationInteractor;
import ee.mtakso.driver.ui.interactor.destination.ActiveDestinationInteractor_Factory;
import ee.mtakso.driver.ui.interactor.destination.DeactivateDestinationInteractor;
import ee.mtakso.driver.ui.interactor.destination.DeactivateDestinationInteractor_Factory;
import ee.mtakso.driver.ui.interactor.destination.DeleteDestinationInteractor;
import ee.mtakso.driver.ui.interactor.destination.DeleteDestinationInteractor_Factory;
import ee.mtakso.driver.ui.interactor.destination.DestinationLimitInteractor;
import ee.mtakso.driver.ui.interactor.destination.DestinationLimitInteractor_Factory;
import ee.mtakso.driver.ui.interactor.destination.SavedDestinationsInteractor;
import ee.mtakso.driver.ui.interactor.destination.SavedDestinationsInteractor_Factory;
import ee.mtakso.driver.ui.interactor.destination.SelectDestinationInteractor;
import ee.mtakso.driver.ui.interactor.destination.SelectDestinationInteractor_Factory;
import ee.mtakso.driver.ui.interactor.destination.UpdateDriverDestinationInteractor;
import ee.mtakso.driver.ui.interactor.destination.UpdateDriverDestinationInteractor_Factory;
import ee.mtakso.driver.ui.interactor.driver.DistinctDriverStateInteractor;
import ee.mtakso.driver.ui.interactor.driver.DistinctDriverStateInteractor_Factory;
import ee.mtakso.driver.ui.interactor.driver.DriverAreaInteractor;
import ee.mtakso.driver.ui.interactor.driver.DriverAreaInteractor_Factory;
import ee.mtakso.driver.ui.interactor.driver.DriverStateChangeFailInteractor;
import ee.mtakso.driver.ui.interactor.driver.DriverStateChangeFailInteractor_Factory;
import ee.mtakso.driver.ui.interactor.driver.DriverStateInteractor;
import ee.mtakso.driver.ui.interactor.driver.DriverStateInteractor_Factory;
import ee.mtakso.driver.ui.interactor.driver.FifoQueueMapInteractor;
import ee.mtakso.driver.ui.interactor.driver.FifoQueueMapInteractor_Factory;
import ee.mtakso.driver.ui.interactor.driver.MakeDriverInactiveInteractor;
import ee.mtakso.driver.ui.interactor.driver.MakeDriverInactiveInteractor_Factory;
import ee.mtakso.driver.ui.interactor.driver.NearbyDriversInteractor;
import ee.mtakso.driver.ui.interactor.driver.NearbyDriversInteractor_Factory;
import ee.mtakso.driver.ui.interactor.driver.OnlineCheckInteractor;
import ee.mtakso.driver.ui.interactor.driver.OnlineCheckInteractor_Factory;
import ee.mtakso.driver.ui.interactor.driver.WorkRadiusInteractor;
import ee.mtakso.driver.ui.interactor.driver.WorkRadiusInteractor_Factory;
import ee.mtakso.driver.ui.interactor.driver.surge.SurgeInteractor;
import ee.mtakso.driver.ui.interactor.driver.surge.SurgeInteractor_Factory;
import ee.mtakso.driver.ui.interactor.inbox.InboxItemsInteractor;
import ee.mtakso.driver.ui.interactor.inbox.InboxItemsInteractor_Factory;
import ee.mtakso.driver.ui.interactor.income.report.ChartMapper_Factory;
import ee.mtakso.driver.ui.interactor.income.report.ReportItemsMapper_Factory;
import ee.mtakso.driver.ui.interactor.income.report.ReportPageInteractor;
import ee.mtakso.driver.ui.interactor.income.report.ReportPageInteractor_Factory;
import ee.mtakso.driver.ui.interactor.map.GetHeatmapInteractor;
import ee.mtakso.driver.ui.interactor.map.GetHeatmapInteractor_Factory;
import ee.mtakso.driver.ui.interactor.map.GetHeatmapStatusInteractor;
import ee.mtakso.driver.ui.interactor.map.GetHeatmapStatusInteractor_Factory;
import ee.mtakso.driver.ui.interactor.map.GetMapExplanationInteractor;
import ee.mtakso.driver.ui.interactor.map.GetMapExplanationInteractor_Factory;
import ee.mtakso.driver.ui.interactor.map.GetMapSettingsInteractor;
import ee.mtakso.driver.ui.interactor.map.GetMapSettingsInteractor_Factory;
import ee.mtakso.driver.ui.interactor.map.SetMapSettingsCategoryInteractor;
import ee.mtakso.driver.ui.interactor.map.SetMapSettingsCategoryInteractor_Factory;
import ee.mtakso.driver.ui.interactor.map.SetMapSettingsHeatmapInteractor;
import ee.mtakso.driver.ui.interactor.map.SetMapSettingsHeatmapInteractor_Factory;
import ee.mtakso.driver.ui.interactor.modaldialog.BackendModalDialogActionReporterInteractor;
import ee.mtakso.driver.ui.interactor.modaldialog.BackendModalDialogActionReporterInteractor_Factory;
import ee.mtakso.driver.ui.interactor.modaldialog.FifoModalInteractor;
import ee.mtakso.driver.ui.interactor.modaldialog.FifoModalInteractor_Factory;
import ee.mtakso.driver.ui.interactor.modaldialog.SingleModalDialogInteractor;
import ee.mtakso.driver.ui.interactor.modaldialog.SingleModalDialogInteractor_Factory;
import ee.mtakso.driver.ui.interactor.network_usage.NetworkUsageUploadInteractor;
import ee.mtakso.driver.ui.interactor.network_usage.NetworkUsageUploadInteractor_Factory;
import ee.mtakso.driver.ui.interactor.order.IncomingOrderInteractor;
import ee.mtakso.driver.ui.interactor.order.IncomingOrderInteractor_Factory;
import ee.mtakso.driver.ui.interactor.order.active.map.MapDataInteractor;
import ee.mtakso.driver.ui.interactor.order.active.map.MapDataInteractor_Factory;
import ee.mtakso.driver.ui.interactor.order.incoming.IncomingOrderRouteInteractor;
import ee.mtakso.driver.ui.interactor.order.incoming.IncomingOrderRouteInteractor_Factory;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetAcceptedOrdersInteractor;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetAcceptedOrdersInteractor_Factory;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetScheduledOrdersInteractor;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetScheduledOrdersInteractor_Factory;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetUpcomingOrderDetailsInteractor;
import ee.mtakso.driver.ui.interactor.order.scheduled.GetUpcomingOrderDetailsInteractor_Factory;
import ee.mtakso.driver.ui.interactor.payouts.ConfirmPayoutInteractor;
import ee.mtakso.driver.ui.interactor.payouts.ConfirmPayoutInteractor_Factory;
import ee.mtakso.driver.ui.interactor.payouts.PayToBoltLinkInteractor;
import ee.mtakso.driver.ui.interactor.payouts.PayToBoltLinkInteractor_Factory;
import ee.mtakso.driver.ui.interactor.payouts.PayoutDetailsInteractor;
import ee.mtakso.driver.ui.interactor.payouts.PayoutDetailsInteractor_Factory;
import ee.mtakso.driver.ui.interactor.payouts.PayoutHistoryInteractor;
import ee.mtakso.driver.ui.interactor.payouts.PayoutHistoryInteractor_Factory;
import ee.mtakso.driver.ui.interactor.payouts.PayoutInfoInteractor;
import ee.mtakso.driver.ui.interactor.payouts.PayoutInfoInteractor_Factory;
import ee.mtakso.driver.ui.interactor.payouts.PayoutPayToBoltInfoInteractor;
import ee.mtakso.driver.ui.interactor.payouts.PayoutPayToBoltInfoInteractor_Factory;
import ee.mtakso.driver.ui.interactor.portal.DriverPortalTokenInteractor;
import ee.mtakso.driver.ui.interactor.portal.DriverPortalTokenInteractor_Factory;
import ee.mtakso.driver.ui.interactor.promodialog.HomePromoDialogInteractor;
import ee.mtakso.driver.ui.interactor.promodialog.HomePromoDialogInteractor_Factory;
import ee.mtakso.driver.ui.interactor.rateme.RateMeFetchCategoriesInteractor_Factory;
import ee.mtakso.driver.ui.interactor.score.DriverScoreManager;
import ee.mtakso.driver.ui.interactor.score.DriverScoreManager_Factory;
import ee.mtakso.driver.ui.interactor.search.GetExternalSourceAddressDetailInteractor;
import ee.mtakso.driver.ui.interactor.search.GetExternalSourceAddressDetailInteractor_Factory;
import ee.mtakso.driver.ui.interactor.search.GetExternalSourceAddressInteractor;
import ee.mtakso.driver.ui.interactor.search.GetExternalSourceAddressInteractor_Factory;
import ee.mtakso.driver.ui.interactor.search.GetOrderDestinationSearchSuggestionInteractor;
import ee.mtakso.driver.ui.interactor.search.GetOrderDestinationSearchSuggestionInteractor_Factory;
import ee.mtakso.driver.ui.interactor.search.GetSuggestionsInteractor;
import ee.mtakso.driver.ui.interactor.search.GetSuggestionsInteractor_Factory;
import ee.mtakso.driver.ui.interactor.settings.GetLanguageSettingsInteractor;
import ee.mtakso.driver.ui.interactor.settings.GetLanguageSettingsInteractor_Factory;
import ee.mtakso.driver.ui.interactor.settings.SetLanguageInteractor;
import ee.mtakso.driver.ui.interactor.settings.SetLanguageInteractor_Factory;
import ee.mtakso.driver.ui.interactor.warnings.AuthorizedWarningInteractor;
import ee.mtakso.driver.ui.interactor.warnings.AuthorizedWarningInteractor_Factory;
import ee.mtakso.driver.ui.notification.NotificationCleanerService;
import ee.mtakso.driver.ui.notification.NotificationCleanerService_Factory;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.ui.notification.UiNotificationManager_Factory;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.SimpleActivity_MembersInjector;
import ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledFragment;
import ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledFragment_Factory;
import ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledViewModel;
import ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledViewModel_Factory;
import ee.mtakso.driver.ui.screens.blocking.DriverBlockedFragment;
import ee.mtakso.driver.ui.screens.blocking.DriverBlockedFragment_Factory;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubClient;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubClient_Factory;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubDataMapper;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubDataMapper_Factory;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubListingFragment;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubListingFragment_Factory;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsFragment;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsFragment_Factory;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsViewModel;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsViewModel_Factory;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubViewModel;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubViewModel_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsFragment_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsViewModel_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignFactory;
import ee.mtakso.driver.ui.screens.campaigns.v2.CampaignFactory_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.FutureCampaignFactory;
import ee.mtakso.driver.ui.screens.campaigns.v2.FutureCampaignFactory_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.PastCampaignsFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.PastCampaignsFragment_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.PastCampaignsViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.PastCampaignsViewModel_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyViewModel_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter.CircleKLoyaltyStarterFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter.CircleKLoyaltyStarterFragment_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter.CircleKLoyaltyStarterViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.starter.CircleKLoyaltyStarterViewModel_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignBonusMapper;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignBonusMapper_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsFragment_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsViewModel_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDynamicItemsMapper;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDynamicItemsMapper_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignImageMapper_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignInfoBlockMapper;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignInfoBlockMapper_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.OptInChoiceFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.OptInChoiceFragment_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.OptInChoiceViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.OptInChoiceViewModel_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsFragment_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsViewModel_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignInvitationFactory;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignInvitationFactory_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignMapper;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignMapper_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignFragment_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignViewModel_Factory;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInChoiceActivationInfoFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInChoiceActivationInfoFragment_Factory;
import ee.mtakso.driver.ui.screens.car_chooser.CarChooserActivity;
import ee.mtakso.driver.ui.screens.car_chooser.CarChooserActivity_MembersInjector;
import ee.mtakso.driver.ui.screens.car_chooser.CarChooserViewModel;
import ee.mtakso.driver.ui.screens.car_chooser.CarChooserViewModel_Factory;
import ee.mtakso.driver.ui.screens.car_chooser.GetDriverCarsInteractor;
import ee.mtakso.driver.ui.screens.car_chooser.GetDriverCarsInteractor_Factory;
import ee.mtakso.driver.ui.screens.car_chooser.GetDriverPortalTokenInteractor;
import ee.mtakso.driver.ui.screens.car_chooser.GetDriverPortalTokenInteractor_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseActivity;
import ee.mtakso.driver.ui.screens.contact_methods.ContactMethodsBaseActivity_MembersInjector;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.CallToRiderInteractor;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.CallToRiderInteractor_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsFragment_MembersInjector;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsInteractor;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsInteractor_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsViewModel_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.VoipFloatingActivity;
import ee.mtakso.driver.ui.screens.contact_methods.voip.VoipFloatingActivity_MembersInjector;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackFragment_MembersInjector;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackViewModel_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorDelegate_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorInteractor;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorInteractor_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorViewModel_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ChatDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ChatDelegate_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipCallDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipCallDelegate_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallFragment_MembersInjector;
import ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallViewModel_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallInteractor;
import ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallInteractor_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.inprogress.InprogressCallViewModel_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.NoAnswerFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.NoAnswerInteractor;
import ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.NoAnswerInteractor_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.NoAnswerViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.noanswer.NoAnswerViewModel_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.permission.VoipPermissionDialogFactory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallFragment;
import ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallInteractor;
import ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallInteractor_Factory;
import ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.rate.RateCallViewModel_Factory;
import ee.mtakso.driver.ui.screens.destination.DestinationFragment;
import ee.mtakso.driver.ui.screens.destination.DestinationFragment_Factory;
import ee.mtakso.driver.ui.screens.destination.DestinationMapper_Factory;
import ee.mtakso.driver.ui.screens.destination.active.state.DriverDestinationActiveStateFragment;
import ee.mtakso.driver.ui.screens.destination.active.state.DriverDestinationActiveStateFragment_Factory;
import ee.mtakso.driver.ui.screens.destination.active.state.DriverDestinationActiveStateViewModel;
import ee.mtakso.driver.ui.screens.destination.active.state.DriverDestinationActiveStateViewModel_Factory;
import ee.mtakso.driver.ui.screens.destination.edit.DestinationEditBottomDialogFragment;
import ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchFragment;
import ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchFragment_Factory;
import ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchViewModel;
import ee.mtakso.driver.ui.screens.destination.search.DriverDestinationSearchViewModel_Factory;
import ee.mtakso.driver.ui.screens.destination.search.SearchSuggestionMapper_Factory;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoriesFragment;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoriesFragment_Factory;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoryViewModel;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeCategoryViewModel_Factory;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialogDelegate;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialogDelegate_Factory;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialog_MembersInjector;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeReasonsFragment;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeReasonsFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity_MembersInjector;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsInteractor;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsInteractor_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.balance.BalanceFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.balance.BalanceFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.balance.ReportPageMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.mode.ModeChooserBottomDialog;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltViewModel_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsActivity;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsInfoPageFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsInfoPageFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsProgressPageFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsProgressPageFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsViewModel_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.history.PayoutHistoryFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.history.PayoutHistoryFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.history.PayoutHistoryViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.history.PayoutHistoryViewModel_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.howto.HowToRequestPayoutFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.howto.HowToRequestPayoutFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.howto.HowToRequestPayoutViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.howto.HowToRequestPayoutViewModel_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestFragment;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestViewModel;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestViewModel_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceHeaderMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceHeaderMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceHistoryItemMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceHistoryItemMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceHistoryMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceHistoryMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceViewModel_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownStubFactory_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownViewModel_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsItemMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsItemMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsNestedItemMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsNestedItemMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyValueFormat_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverBannerMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverBannerMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverButtonAppearanceMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverButtonMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverButtonMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverButtonSizeMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverChipMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverChipMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverColorMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverContentTypeMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverImageMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverInfoBlockMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverInfoBlockMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverLinkAppearanceMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverLottieMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverNormalImageMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverTintableImageMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.common.EarningsBalanceStateTypeMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.explanation.EarningsPayoutExplanationViewModel_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesViewModel_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalViewModel_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingMapper_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.landing.EarningsLandingViewModel_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.payout.RequestWebUrlFragment;
import ee.mtakso.driver.ui.screens.earnings.v3.payout.RequestWebUrlFragment_Factory;
import ee.mtakso.driver.ui.screens.earnings.v3.payout.RequestWebUrlViewModel;
import ee.mtakso.driver.ui.screens.earnings.v3.payout.RequestWebUrlViewModel_Factory;
import ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment;
import ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsFragment_Factory;
import ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel;
import ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel_Factory;
import ee.mtakso.driver.ui.screens.history.details.file_upload.FileUploadConfirmationDialog;
import ee.mtakso.driver.ui.screens.history.details.file_upload.FileUploadConfirmationDialog_Factory;
import ee.mtakso.driver.ui.screens.history.details.file_upload.RetryFileUploadFragment;
import ee.mtakso.driver.ui.screens.history.details.file_upload.RetryFileUploadFragment_Factory;
import ee.mtakso.driver.ui.screens.history.list.OrderListFragment;
import ee.mtakso.driver.ui.screens.history.list.OrderListFragment_Factory;
import ee.mtakso.driver.ui.screens.history.list.OrderListViewModel;
import ee.mtakso.driver.ui.screens.history.list.OrderListViewModel_Factory;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityFragment;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityFragment_Factory;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityViewModel;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityViewModel_Factory;
import ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel;
import ee.mtakso.driver.ui.screens.home.v2.subpage.destination.DestinationsViewModel_Factory;
import ee.mtakso.driver.ui.screens.home.v2.subpage.destination.about.AboutDriverDestinationsFragment;
import ee.mtakso.driver.ui.screens.home.v2.subpage.destination.about.AboutDriverDestinationsFragment_Factory;
import ee.mtakso.driver.ui.screens.home.v3.DeeplinkHomeContainerCoordinator;
import ee.mtakso.driver.ui.screens.home.v3.HomeFragment;
import ee.mtakso.driver.ui.screens.home.v3.HomeFragment_Factory;
import ee.mtakso.driver.ui.screens.home.v3.HomeViewModel;
import ee.mtakso.driver.ui.screens.home.v3.HomeViewModel_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.CarUnavailableDialogDelegate_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.NavigatorChooserDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.NavigatorChooserDelegate_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.OnBoardingDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.OnBoardingDelegate_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate_Factory;
import ee.mtakso.driver.ui.screens.home.v3.delegate.TrainingDelegate_Factory;
import ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment;
import ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment_Factory;
import ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel;
import ee.mtakso.driver.ui.screens.home.v3.map.WorkMapViewModel_Factory;
import ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileSource;
import ee.mtakso.driver.ui.screens.home.v3.map.fifo.FifoQueueTileSource_Factory;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.HeatmapTileSourceFactory;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.HeatmapTileSourceFactory_Factory;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.MarkerCache_Factory;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarkerProvider;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarkerProvider_Factory;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarkerRenderer;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeMarkerRenderer_Factory;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeTileSourceFactory;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeTileSourceFactory_Factory;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeTranslationProvider;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeTranslationProvider_Factory;
import ee.mtakso.driver.ui.screens.home.v3.map.surge.MvtRenderer_Factory;
import ee.mtakso.driver.ui.screens.home.v3.map.surge.MvtToRasterConverter;
import ee.mtakso.driver.ui.screens.home.v3.map.surge.MvtToRasterConverter_Factory;
import ee.mtakso.driver.ui.screens.home.v3.map.vector.VectorTileBitmapPool;
import ee.mtakso.driver.ui.screens.inbox.InboxFragment;
import ee.mtakso.driver.ui.screens.inbox.InboxFragment_Factory;
import ee.mtakso.driver.ui.screens.inbox.InboxViewModel;
import ee.mtakso.driver.ui.screens.inbox.InboxViewModel_Factory;
import ee.mtakso.driver.ui.screens.infoweb.InfoWebFragment;
import ee.mtakso.driver.ui.screens.infoweb.InfoWebFragment_Factory;
import ee.mtakso.driver.ui.screens.infoweb.InfoWebViewModel;
import ee.mtakso.driver.ui.screens.infoweb.InfoWebViewModel_Factory;
import ee.mtakso.driver.ui.screens.modal.ModalDelegate;
import ee.mtakso.driver.ui.screens.modal.ModalDelegate_Factory;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOptionsInteractor;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOptionsInteractor_Factory;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserFragment;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserFragment_Factory;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserViewModel;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserViewModel_Factory;
import ee.mtakso.driver.ui.screens.operation_result.OperationResultFragment;
import ee.mtakso.driver.ui.screens.operation_result.OperationResultFragment_Factory;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory;
import ee.mtakso.driver.ui.screens.order.MarkerParamsFactory_Factory;
import ee.mtakso.driver.ui.screens.order.add_stop.AddStopBottomSheetDialogFragment;
import ee.mtakso.driver.ui.screens.order.add_stop.AddStopBottomSheetDialogFragment_Factory;
import ee.mtakso.driver.ui.screens.order.arrived.DrivePriceInteractor;
import ee.mtakso.driver.ui.screens.order.arrived.DrivePriceInteractor_Factory;
import ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel;
import ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel_Factory;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewDialog;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewDialog_Factory;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewViewModel;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewViewModel_Factory;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderDialogFragment;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderDialogFragment_Factory;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderDisclaimerFragment;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderDisclaimerFragment_Factory;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderFragment_Factory;
import ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment;
import ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment_Factory;
import ee.mtakso.driver.ui.screens.order.cancel.TripCancellationViewModel;
import ee.mtakso.driver.ui.screens.order.cancel.TripCancellationViewModel_Factory;
import ee.mtakso.driver.ui.screens.order.finish.CustomPriceFragment;
import ee.mtakso.driver.ui.screens.order.finish.CustomPriceFragment_Factory;
import ee.mtakso.driver.ui.screens.order.finish.PricePreviewFragment;
import ee.mtakso.driver.ui.screens.order.finish.PricePreviewFragment_Factory;
import ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity;
import ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity_MembersInjector;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderActivity;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderActivity_MembersInjector;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment_Factory;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderSoundController;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderSoundController_Factory;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderViewModel_Factory;
import ee.mtakso.driver.ui.screens.order.incoming.v2.map.IncomingOrderMapFragment;
import ee.mtakso.driver.ui.screens.order.incoming.v2.map.IncomingOrderMapFragment_Factory;
import ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationFragment;
import ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationFragment_Factory;
import ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationViewModel;
import ee.mtakso.driver.ui.screens.order.lookup.orderdestination.OrderDestinationViewModel_Factory;
import ee.mtakso.driver.ui.screens.order.modal.OrderModalFragment;
import ee.mtakso.driver.ui.screens.order.modal.OrderModalFragment_Factory;
import ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogFragment;
import ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogFragment_Factory;
import ee.mtakso.driver.ui.screens.order.ordermenudialog.OrderMenuDialogMapper_Factory;
import ee.mtakso.driver.ui.screens.order.scheduled.OrderMapPointsFactory_Factory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderButtonAppearanceMapper_Factory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsComponentFactory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsComponentFactory_Factory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsFragment;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsFragment_Factory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsStateFactory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsStateFactory_Factory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsViewModel;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsViewModel_Factory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderInfoBlockMapper;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderInfoBlockMapper_Factory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderListModelFactory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderListModelFactory_Factory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersFragment;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersFragment_Factory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersGroupFragment;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersGroupFragment_Factory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersGroupViewModel;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersGroupViewModel_Factory;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersViewModel;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersViewModel_Factory;
import ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity;
import ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity_MembersInjector;
import ee.mtakso.driver.ui.screens.order.v2.ActiveRideDeeplinkInteractor;
import ee.mtakso.driver.ui.screens.order.v2.ActiveRideDeeplinkInteractor_Factory;
import ee.mtakso.driver.ui.screens.order.v2.OrderViewModel;
import ee.mtakso.driver.ui.screens.order.v2.OrderViewModel_Factory;
import ee.mtakso.driver.ui.screens.order.v2.driver.DriverInteractor;
import ee.mtakso.driver.ui.screens.order.v2.driver.DriverInteractor_Factory;
import ee.mtakso.driver.ui.screens.order.v2.map.OrderMapFragment;
import ee.mtakso.driver.ui.screens.order.v2.map.OrderMapFragment_Factory;
import ee.mtakso.driver.ui.screens.order.v2.map.RouteProvider;
import ee.mtakso.driver.ui.screens.order.v2.map.RouteProvider_Factory;
import ee.mtakso.driver.ui.screens.order.v2.order.AutoAcceptedOrderInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.AutoAcceptedOrderInteractor_Factory;
import ee.mtakso.driver.ui.screens.order.v2.order.BottomSheetStateInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.BottomSheetStateInteractor_Factory;
import ee.mtakso.driver.ui.screens.order.v2.order.DriverAppStickyBannerMapper;
import ee.mtakso.driver.ui.screens.order.v2.order.DriverAppStickyBannerMapper_Factory;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderDistanceInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderDistanceInteractor_Factory;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderStateDataInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderStateDataInteractor_Factory;
import ee.mtakso.driver.ui.screens.order.v2.order.PaidStopsStateInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.PaidStopsStateInteractor_Factory;
import ee.mtakso.driver.ui.screens.order.v2.order.PriceInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.PriceInteractor_Factory;
import ee.mtakso.driver.ui.screens.order.v2.order.RouteSharingInteractor;
import ee.mtakso.driver.ui.screens.order.v2.order.RouteSharingInteractor_Factory;
import ee.mtakso.driver.ui.screens.order.v2.order.ui.OrderPanelFragment;
import ee.mtakso.driver.ui.screens.order.v2.order.ui.OrderPanelFragment_Factory;
import ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingActivity;
import ee.mtakso.driver.ui.screens.permission_onboarding.PermissionOnboardingActivity_MembersInjector;
import ee.mtakso.driver.ui.screens.priority.DriverPriorityFragment;
import ee.mtakso.driver.ui.screens.priority.DriverPriorityFragment_Factory;
import ee.mtakso.driver.ui.screens.priority.DriverPriorityMapper;
import ee.mtakso.driver.ui.screens.priority.DriverPriorityMapper_Factory;
import ee.mtakso.driver.ui.screens.priority.DriverPriorityViewModel;
import ee.mtakso.driver.ui.screens.priority.DriverPriorityViewModel_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingBottomSheetFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingBottomSheetFragment_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingViewModel;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.AudioRecordingViewModel_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.AudioRecordingMapper_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.LowStorageDialogDelegate;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.LowStorageDialogDelegate_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor.StartRecordingInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor.StartRecordingInteractor_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.permission.MicrophonePermissionDialogProvider;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.permission.MicrophonePermissionDialogProvider_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpFragment_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpInteractor_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpViewModel;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpViewModel_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.ActiveIncidentDialogFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.ActiveIncidentDialogFragment_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistDataMapper;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistDataMapper_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpBottomSheetFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpBottomSheetFragment_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpViewModel;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistHelpViewModel_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistInteractor_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitInteractor;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitInteractor_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitMapper;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitMapper_Factory;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitViewModel;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitViewModel_Factory;
import ee.mtakso.driver.ui.screens.score.DriverScoreExplanationFragment;
import ee.mtakso.driver.ui.screens.score.DriverScoreExplanationFragment_Factory;
import ee.mtakso.driver.ui.screens.score.DriverScoreExplanationViewModel;
import ee.mtakso.driver.ui.screens.score.DriverScoreExplanationViewModel_Factory;
import ee.mtakso.driver.ui.screens.score.DriverScoreFragment;
import ee.mtakso.driver.ui.screens.score.DriverScoreFragment_Factory;
import ee.mtakso.driver.ui.screens.score.DriverScoreMapper;
import ee.mtakso.driver.ui.screens.score.DriverScoreMapper_Factory;
import ee.mtakso.driver.ui.screens.score.DriverScoreTooltipFactory;
import ee.mtakso.driver.ui.screens.score.DriverScoreTooltipFactory_Factory;
import ee.mtakso.driver.ui.screens.score.DriverScoreViewModel;
import ee.mtakso.driver.ui.screens.score.DriverScoreViewModel_Factory;
import ee.mtakso.driver.ui.screens.settings.AccountSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.AccountSettingsFragment_Factory;
import ee.mtakso.driver.ui.screens.settings.AppSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.AppSettingsFragment_Factory;
import ee.mtakso.driver.ui.screens.settings.MagicLinkInteractor;
import ee.mtakso.driver.ui.screens.settings.MagicLinkInteractor_Factory;
import ee.mtakso.driver.ui.screens.settings.NavigationSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.NavigationSettingsFragment_Factory;
import ee.mtakso.driver.ui.screens.settings.QuickAccessSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.QuickAccessSettingsFragment_Factory;
import ee.mtakso.driver.ui.screens.settings.QuickAccessSettingsViewModel;
import ee.mtakso.driver.ui.screens.settings.QuickAccessSettingsViewModel_Factory;
import ee.mtakso.driver.ui.screens.settings.SettingsFragment;
import ee.mtakso.driver.ui.screens.settings.SettingsFragment_Factory;
import ee.mtakso.driver.ui.screens.settings.SettingsInteractor;
import ee.mtakso.driver.ui.screens.settings.SettingsInteractor_Factory;
import ee.mtakso.driver.ui.screens.settings.SettingsViewModel;
import ee.mtakso.driver.ui.screens.settings.SettingsViewModel_Factory;
import ee.mtakso.driver.ui.screens.settings.auto_acceptance.AutoAcceptanceSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.auto_acceptance.AutoAcceptanceSettingsFragment_Factory;
import ee.mtakso.driver.ui.screens.settings.auto_acceptance.AutoAcceptanceSettingsViewModel;
import ee.mtakso.driver.ui.screens.settings.auto_acceptance.AutoAcceptanceSettingsViewModel_Factory;
import ee.mtakso.driver.ui.screens.settings.language.LanguageSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.language.LanguageSettingsFragment_Factory;
import ee.mtakso.driver.ui.screens.settings.language.LanguageSettingsViewModel;
import ee.mtakso.driver.ui.screens.settings.language.LanguageSettingsViewModel_Factory;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtFragment;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtFragment_Factory;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtViewModel;
import ee.mtakso.driver.ui.screens.settings.navigation_tbt.NavigationSettingsTbtViewModel_Factory;
import ee.mtakso.driver.ui.screens.settings.pricing.PriceFormat_Factory;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment_Factory;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsViewModel;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsViewModel_Factory;
import ee.mtakso.driver.ui.screens.settings.theme.ThemeSettingsFragment;
import ee.mtakso.driver.ui.screens.settings.theme.ThemeSettingsFragment_Factory;
import ee.mtakso.driver.ui.screens.settings.theme.ThemeSettingsViewModel;
import ee.mtakso.driver.ui.screens.settings.theme.ThemeSettingsViewModel_Factory;
import ee.mtakso.driver.ui.screens.shared.InviteDriversActivity;
import ee.mtakso.driver.ui.screens.shared.InviteDriversActivity_MembersInjector;
import ee.mtakso.driver.ui.screens.sos.SosDialogFragment;
import ee.mtakso.driver.ui.screens.sos.SosDialogFragment_Factory;
import ee.mtakso.driver.ui.screens.sos.SosDialogViewModel;
import ee.mtakso.driver.ui.screens.sos.SosDialogViewModel_Factory;
import ee.mtakso.driver.ui.screens.support.SupportFragment;
import ee.mtakso.driver.ui.screens.support.SupportFragment_Factory;
import ee.mtakso.driver.ui.screens.support.SupportViewModel;
import ee.mtakso.driver.ui.screens.support.SupportViewModel_Factory;
import ee.mtakso.driver.ui.screens.time_limit.WorkTimeFragment;
import ee.mtakso.driver.ui.screens.time_limit.WorkTimeFragment_Factory;
import ee.mtakso.driver.ui.screens.time_limit.WorkTimeViewModel;
import ee.mtakso.driver.ui.screens.time_limit.WorkTimeViewModel_Factory;
import ee.mtakso.driver.ui.screens.vehicle.VehicleListFragment;
import ee.mtakso.driver.ui.screens.vehicle.VehicleListFragment_Factory;
import ee.mtakso.driver.ui.screens.vehicle.VehicleListViewModel;
import ee.mtakso.driver.ui.screens.vehicle.VehicleListViewModel_Factory;
import ee.mtakso.driver.ui.screens.waybill.WaybillFragment;
import ee.mtakso.driver.ui.screens.waybill.WaybillFragment_Factory;
import ee.mtakso.driver.ui.screens.waybill.WaybillViewModel;
import ee.mtakso.driver.ui.screens.waybill.WaybillViewModel_Factory;
import ee.mtakso.driver.ui.screens.work.DashboardMapper_Factory;
import ee.mtakso.driver.ui.screens.work.WorkFragment;
import ee.mtakso.driver.ui.screens.work.WorkFragment_Factory;
import ee.mtakso.driver.ui.screens.work.WorkViewModel;
import ee.mtakso.driver.ui.screens.work.WorkViewModel_Factory;
import ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog;
import ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsViewModel;
import ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsViewModel_Factory;
import ee.mtakso.driver.ui.screens.work.fifo.FifoQueueStateMapper;
import ee.mtakso.driver.ui.screens.work.fifo.FifoQueueStateMapper_Factory;
import ee.mtakso.driver.ui.screens.work.map.MapExplanationFragment;
import ee.mtakso.driver.ui.screens.work.map.MapExplanationFragment_Factory;
import ee.mtakso.driver.ui.screens.work.map.MapExplanationViewModel;
import ee.mtakso.driver.ui.screens.work.map.MapExplanationViewModel_Factory;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment_Factory;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsViewModel;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsViewModel_Factory;
import ee.mtakso.driver.ui.views.drawer.DebugDrawerInitializerImpl;
import ee.mtakso.driver.ui.views.webview.WebViewTracker;
import ee.mtakso.driver.ui.views.webview.WebViewTracker_Factory;
import ee.mtakso.driver.utils.AppResolver;
import ee.mtakso.driver.utils.AppResolver_Factory;
import ee.mtakso.driver.utils.BackgroundManager;
import ee.mtakso.driver.utils.ChromeCustomTabsUrlLauncher;
import ee.mtakso.driver.utils.ChromeCustomTabsUrlLauncher_Factory;
import ee.mtakso.driver.utils.ChromeUrlLauncher;
import ee.mtakso.driver.utils.ChromeUrlLauncher_Factory;
import ee.mtakso.driver.utils.CompositeChromeFirstUrlLauncher;
import ee.mtakso.driver.utils.CompositeChromeFirstUrlLauncher_Factory;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.CompositeUrlLauncher_Factory;
import ee.mtakso.driver.utils.DialerLauncher;
import ee.mtakso.driver.utils.SystemUrlLauncher;
import ee.mtakso.driver.utils.SystemUrlLauncher_Factory;
import ee.mtakso.driver.utils.UrlFactory;
import ee.mtakso.driver.utils.UrlFactory_Factory;
import ee.mtakso.driver.utils.coroutines.DispatcherProvider_Factory;
import ee.mtakso.driver.utils.coroutines.ScopeProvider_Factory;
import ee.mtakso.driver.utils.effects.EffectsFactory;
import ee.mtakso.driver.utils.effects.EffectsFactory_Factory;
import eu.bolt.android.audio_recording_engine.engine.AudioRecorderApi;
import eu.bolt.android.chat.recyclerview.ChatReadDelegate;
import eu.bolt.android.chat.recyclerview.ChatReadDelegate_Factory;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.maps.core.MapProvider;
import eu.bolt.android.stories.mapper.StoryAssetDimensionMapper_Factory;
import eu.bolt.android.stories.mapper.StoryButtonStyleMapper_Factory;
import eu.bolt.android.stories.mapper.StoryMapper;
import eu.bolt.android.stories.mapper.StoryMapper_Factory;
import eu.bolt.android.stories.mapper.StorySlideAssetMapper;
import eu.bolt.android.stories.mapper.StorySlideAssetMapper_Factory;
import eu.bolt.android.stories.mapper.StorySlideContentItemMapper;
import eu.bolt.android.stories.mapper.StorySlideContentItemMapper_Factory;
import eu.bolt.android.stories.mapper.StorySlideContentMapper;
import eu.bolt.android.stories.mapper.StorySlideContentMapper_Factory;
import eu.bolt.chat.chatcore.connection.ChatConnectionProvider;
import eu.bolt.chat.chatcore.interactor.ReadMessageInteractor;
import eu.bolt.chat.chatcore.interactor.RequestReplySuggestionsInteractor;
import eu.bolt.chat.chatcore.interactor.SendChatMessageInteractor;
import eu.bolt.chat.chatcore.push.ChatPushHandler;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.chat.tools.logger.Logger;
import eu.bolt.driver.chat.helper.SoundEffectsPool;
import eu.bolt.driver.chat.service.ChatManager;
import eu.bolt.driver.chat.ui.screen.conversation.ConversationActivity;
import eu.bolt.driver.chat.ui.screen.conversation.ConversationActivity_MembersInjector;
import eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationMapper_Factory;
import eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment;
import eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment_Factory;
import eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerViewModel;
import eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerViewModel_Factory;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationFragment_Factory;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationViewModel;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.ConversationViewModel_Factory;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.MessageMapper;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.MessageMapper_Factory;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.menu.MessageMenuFragment;
import eu.bolt.driver.chat.ui.screen.conversation.pager.item.menu.MessageMenuFragment_Factory;
import eu.bolt.driver.core.di.helper.CoreFragmentFactory;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.theme.AppThemeManager_Factory;
import eu.bolt.driver.core.theme.ThemeHelper;
import eu.bolt.driver.core.theme.ThemeManager;
import eu.bolt.driver.core.time.AnchoredTimeSource;
import eu.bolt.driver.core.time.SystemUptimeSource_Factory;
import eu.bolt.driver.core.ui.base.activity.BaseAuthorisedActivity_MembersInjector;
import eu.bolt.driver.core.ui.base.fragment.BaseFragmentParams;
import eu.bolt.driver.core.ui.common.activity.SimpleAuthorisedActivity;
import eu.bolt.driver.core.ui.common.activity.SimpleAuthorisedActivity_MembersInjector;
import eu.bolt.driver.core.ui.common.mvvm.ViewModelFactory;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.theme.DriverThemeProvider;
import eu.bolt.driver.core.ui.theme.ThemeProvider;
import eu.bolt.driver.core.ui.translation.RawTranslationProvider;
import eu.bolt.driver.core.ui.translation.TranslationManager;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import eu.bolt.driver.core.ui.translation.v2.TranslationHelper;
import eu.bolt.driver.core.util.DateTimeFormatter;
import eu.bolt.driver.earnings.network.EarningsBalanceApi;
import eu.bolt.driver.earnings.network.EarningsBalanceClient;
import eu.bolt.driver.earnings.network.EarningsBalanceClient_Factory;
import eu.bolt.driver.earnings.network.EarningsGoalApi;
import eu.bolt.driver.earnings.network.EarningsGoalClient;
import eu.bolt.driver.earnings.network.EarningsGoalClient_Factory;
import eu.bolt.driver.stories.StoryManager_Factory;
import eu.bolt.driver.stories.network.StoriesApi;
import eu.bolt.driver.stories.network.StoriesClient;
import eu.bolt.driver.stories.network.StoriesClient_Factory;
import eu.bolt.driver.stories.service.analytic.StoryAnalyticDelegate;
import eu.bolt.driver.stories.service.analytic.StoryAnalyticDelegate_Factory;
import eu.bolt.driver.stories.ui.screen.StoryFragment;
import eu.bolt.driver.stories.ui.screen.StoryFragment_Factory;
import eu.bolt.driver.stories.ui.screen.StorySetFragment;
import eu.bolt.driver.stories.ui.screen.StorySetFragment_Factory;
import eu.bolt.driver.stories.ui.screen.StorySetViewModel;
import eu.bolt.driver.stories.ui.screen.StorySetViewModel_Factory;
import eu.bolt.driver.stories.ui.screen.StoryViewModel;
import eu.bolt.driver.stories.ui.screen.StoryViewModel_Factory;
import eu.bolt.driver.verification.identity.VerificationAnalytics;
import eu.bolt.driver.voip.service.order.CurrentOrderInfoProvider;
import eu.bolt.driver.voip.ui.notification.VoipNotificationDrawer;
import eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@DaggerGenerated
/* loaded from: classes3.dex */
public final class DaggerAuthorisedComponent {

    /* loaded from: classes3.dex */
    private static final class AuthorisedComponentImpl implements AuthorisedComponent {
        private Provider<WebViewStrategy> A;
        private Provider<NavigationSettingsTbtViewModel> A0;
        private Provider<ConnectionMessageManager> A1;
        private Provider<DriverScoreClient> A2;
        private Provider<RouteProvider> A3;
        private Provider<SearchClient> A4;
        private Provider<CampaignDetailsViewModel> A5;
        private Provider<DriverInfoBlockMapper> A6;
        private Provider<ViewModel> A7;
        private Provider<OrderListFragment> A8;
        private Provider<HowToRequestPayoutFragment> A9;
        private Provider<DynamicStopDetailsService> Aa;
        private Provider<ConversationFragment> Ab;
        private Provider<WebViewTracker> B;
        private Provider<CoroutineDispatcher> B0;
        private Provider<PollMessageCache> B1;
        private Provider<DriverScoreManager> B2;
        private Provider<MapDataInteractor> B3;
        private Provider<OtherDriversManager> B4;
        private Provider<ReferralCampaignInvitationFactory> B5;
        private Provider<DriverBannerMapper> B6;
        private Provider<ViewModel> B7;
        private Provider<InboxFragment> B8;
        private Provider<MapExplanationFragment> B9;
        private Provider<StopDetailsService> Ba;
        private Provider<CoreFragmentFactory> Bb;
        private Provider<CircleKLoyaltyViewModel> C;
        private Provider<DriverNavigationConfigurationApi> C0;
        private Provider<PollMessageManager> C1;
        private Provider<TrainingApi> C2;
        private Provider<DriverInteractor> C3;
        private Provider<UpdateOtherDriversService> C4;
        private Provider<ReferralCampaignMapper> C5;
        private Provider<EarningsBalanceHeaderMapper> C6;
        private Provider<ChatRepo> C7;
        private Provider<DriverScoreFragment> C8;
        private Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> C9;
        private Provider<RideStopPollerLaunchService> Ca;
        private Provider<ConversationPagerFragment> Cb;
        private Provider<CircleKApi> D;
        private Provider<DriverNavigationConfigurationClient> D0;
        private Provider<AuthorizedWarningInteractor> D1;
        private Provider<TrainingClient> D2;
        private Provider<B2bManager> D3;
        private Provider<NearbyDriversInteractor> D4;
        private Provider<ReferralCampaignDetailsViewModel> D5;
        private Provider<EarningsBalanceHistoryItemMapper> D6;
        private Provider<SendChatMessageInteractor> D7;
        private Provider<DriverScoreExplanationFragment> D8;
        private Provider<NavigatorChooserDelegate> D9;
        private Provider<DispatchSettingsService> Da;
        private Provider<Map<Class<? extends Fragment>, Provider<Fragment>>> Db;
        private Provider<ResponseErrorProcessor> E;
        private Provider<NavigationOptionsInteractor> E0;
        private Provider<SafetyToolkitAnalytics> E1;
        private Provider<HomePromoDialogInteractor> E2;
        private Provider<AnchoredTimeSource> E3;
        private Provider<DriverStateInteractor> E4;
        private Provider<OptInChoiceViewModel> E5;
        private Provider<EarningsBalanceHistoryMapper> E6;
        private Provider<RequestReplySuggestionsInteractor> E7;
        private Provider<PricingSettingsFragment> E8;
        private Provider<PushDialogDelegate> E9;
        private Provider<AutoNavigationManager> Ea;
        private Provider<ReadMessageInteractor> Eb;
        private Provider<CircleKClient> F;
        private Provider<NavigatorChooserViewModel> F0;
        private Provider<EmergencyAssistApi> F1;
        private Provider<DashboardClient> F2;
        private Provider<OrderStateDataInteractor> F3;
        private Provider<FifoQueueMapInteractor> F4;
        private Provider<GetScheduledOrdersInteractor> F5;
        private Provider<EarningsBalanceViewModel> F6;
        private Provider<ChatConnectionProvider> F7;
        private Provider<VehicleListFragment> F8;
        private Provider<OnBoardingDelegate> F9;
        private Provider<AutoNavigationRoutingService> Fa;
        private Provider<Logger> Fb;
        private Provider<CircleKLoyaltyStarterViewModel> G;
        private Provider<OrderProvider> G0;
        private Provider<EmergencyAssistClient> G1;
        private Provider<DashboardService> G2;
        private Provider<NavigationManager> G3;
        private Provider<SurgeInteractor> G4;
        private Provider<GetAcceptedOrdersInteractor> G5;
        private Provider<RequestWebUrlViewModel> G6;
        private Provider<ConversationViewModel> G7;
        private Provider<DriverAppDisabledFragment> G8;
        private Provider<AppRoutingManager> G9;
        private Provider<ApiExceptionProvider> Ga;
        private Provider<ChatReadDelegate> Gb;
        private Provider<CampaignApi> H;
        private Provider<PriceReviewApi> H0;
        private Provider<CarApplicationApi> H1;
        private Provider<BackendModalDialogActionReporterInteractor> H2;
        private Provider<LocationTransmitter> H3;
        private Provider<HeatmapConfigProvider> H4;
        private Provider<ScheduledOrderListModelFactory> H5;
        private Provider<EarningsPayoutExplanationViewModel> H6;
        private Provider<ConversationPagerViewModel> H7;
        private Provider<LanguageSettingsFragment> H8;
        private Provider<DeeplinkHomeContainerCoordinator> H9;
        private Provider<InvalidateTokenService> Ha;
        private Provider<SoundEffectsPool> Hb;
        private Provider<ee.mtakso.driver.network.client.ShardApiProvider> I;
        private Provider<PriceReviewClient> I0;
        private Provider<CarApplicationClient> I1;
        private Provider<DriverStateChangeFailInteractor> I2;
        private Provider<PriceInteractor> I3;
        private Provider<GetHeatmapInteractor> I4;
        private Provider<ScheduledOrderInfoBlockMapper> I5;
        private Provider<GetMapSettingsInteractor> I6;
        private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> I7;
        private Provider<OrderHistoryDetailsFragment> I8;
        private Provider<PushManagerImpl> I9;
        private Provider<WorkingTimeUpdateService> Ia;
        private Provider<ExecutableDeeplinkManager> Ib;
        private Provider<CompositeResponseTransformer> J;
        private Provider<ChoosePriceReviewViewModel> J0;
        private Provider<EmergencyAssistManager> J1;
        private Provider<DriverTrainingRestrictionManager> J2;
        private Provider<PaidStopsStateInteractor> J3;
        private Provider<WorkMapViewModel> J4;
        private Provider<ScheduledOrdersViewModel> J5;
        private Provider<SetMapSettingsHeatmapInteractor> J6;
        private Provider<ViewModelFactory> J7;
        private Provider<FileUploadConfirmationDialog> J8;
        private Provider<ChatPushHandler> J9;
        private Provider<DriverStateService> Ja;
        private Provider<CampaignClient> K;
        private Provider<ChatAnalytics> K0;
        private Provider<EmergencyAssistInteractor> K1;
        private Provider<AppPerformanceAnalytics> K2;
        private Provider<ActiveRideDeeplinkInteractor> K3;
        private Provider<WorkTimeInteractor> K4;
        private Provider<BoltClubApi> K5;
        private Provider<SetMapSettingsCategoryInteractor> K6;
        private Provider<StorySlideAssetMapper> K7;
        private Provider<RetryFileUploadFragment> K8;
        private Provider<ChatPushHandlerWrapper> K9;
        private Provider<DriverBlockService> Ka;
        private Provider<CampaignManager> L;
        private Provider<ContactApi> L0;
        private Provider<DidYouGetHelpInteractor> L1;
        private Provider<NetworkUsageManager> L2;
        private Provider<AutoAcceptedOrderInteractor> L3;
        private Provider<WorkTimeViewModel> L4;
        private Provider<BoltClubClient> L5;
        private Provider<MapSettingsViewModel> L6;
        private Provider<StorySlideContentItemMapper> L7;
        private Provider<ActiveCampaignsFragment> L8;
        private Provider<NewOrderPushHandler> L9;
        private Provider<MockLocationService> La;
        private Provider<OptInCampaignAnalytics> M;
        private Provider<ContactClient> M0;
        private Provider<AudioRecorderApi> M1;
        private Provider<NetworkUsageUploadInteractor> M2;
        private Provider<NoAnswerCallCache> M3;
        private Provider<TimedAnalyticsManager> M4;
        private Provider<BoltClubDataMapper> M5;
        private Provider<HowToRequestPayoutViewModel> M6;
        private Provider<StorySlideContentMapper> M7;
        private Provider<CustomPriceFragment> M8;
        private Provider<OrderTerminatedPushHandler> M9;
        private Provider<EmergencyAssistHelpProviderService> Ma;
        private Provider<DateTimeConverter> N;
        private Provider<VoipCache> N0;
        private Provider<AudioRecordingManager> N1;
        private Provider<HomeViewModel> N2;
        private Provider<NoAnswerIncomingCallInteractor> N3;
        private Provider<TimedAnalyticsImpl> N4;
        private Provider<BoltClubViewModel> N5;
        private Provider<ThemeManager> N6;
        private Provider<StoryMapper> N7;
        private Provider<PricePreviewFragment> N8;
        private Provider<RateAppPushHandler> N9;
        private Provider<AwakeServiceLauncher> Na;
        private Provider<OptInCampaignViewModel> O;
        private Provider<VoipRxLifecycleTransfromer> O0;
        private Provider<OrderTryAgainManager> O1;
        private Provider<IncomingOrderInteractor> O2;
        private Provider<RouteSharingApi> O3;
        private Provider<RateMeCategoryViewModel> O4;
        private Provider<GetUpcomingOrderDetailsInteractor> O5;
        private Provider<GetMapExplanationInteractor> O6;
        private Provider<StoryAnalyticDelegate> O7;
        private Provider<PastCampaignsFragment> O8;
        private Provider<TipsPushHandler> O9;
        private Provider<TransmissionService> Oa;
        private Provider<SurgeManager> P;
        private Provider<VoipOrderInformationDelegate> P0;
        private Provider<DriverOrderApi> P1;
        private Provider<GeoApi> P2;
        private Provider<RouteSharingClient> P3;
        private Provider<SupportViewModel> P4;
        private Provider<ScheduledOrderDetailsComponentFactory> P5;
        private Provider<MapExplanationViewModel> P6;
        private Provider<StorySetFragment> P7;
        private Provider<CampaignInfoBlockMapper> P8;
        private Provider<VoipPushHandler> P9;
        private Provider<BigQueryLogWatcher> Pa;
        private Provider<DriverFeatures> Q;
        private Provider<ContactOptionsDelegate> Q0;
        private Provider<DriverOrderClient> Q1;
        private Provider<GeoClient> Q2;
        private Provider<RouteSharingInteractor> Q3;
        private Provider<HistoryAnalytics> Q4;
        private Provider<ScheduledOrderDetailsStateFactory> Q5;
        private Provider<ScreenAnalytics> Q6;
        private Provider<PayoutHistoryFragment> Q7;
        private Provider<CampaignBonusMapper> Q8;
        private Provider<RouteUpdatePushHandler> Q9;
        private Provider<AppLogWatcher> Qa;
        private Provider<DriverSettings> R;
        private Provider<ChatDelegate> R0;
        private Provider<OrdersCache> R1;
        private Provider<RouteManager> R2;
        private Provider<ChatManager> R3;
        private Provider<OrderListViewModel> R4;
        private Provider<ScheduledOrderDetailsViewModel> R5;
        private Provider<AboutDriverDestinationsFragment> R6;
        private Provider<PayoutRequestFragment> R7;
        private Provider<CampaignDynamicItemsMapper> R8;
        private Provider<ScheduledOrderPushHandler> R9;
        private Provider<LogManager> Ra;
        private Provider<SettingsAnalytics> S;
        private Provider<ContactOptionsInteractor> S0;
        private Provider<TrueTimeProvider> S1;
        private Provider<IncomingOrderRouteInteractor> S2;
        private Provider<ChatActiveOrderSource> S3;
        private Provider<DriverConfig> S4;
        private Provider<ScheduledOrdersGroupViewModel> S5;
        private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> S6;
        private Provider<DriverPriorityFragment> S7;
        private Provider<CampaignDetailsFragment> S8;
        private Provider<Set<PushHandler>> S9;
        private Provider<DatabaseManager> Sa;
        private Provider<DispatchSettingsViewModel> T;
        private Provider<VoipService> T0;
        private Provider<OrderManager> T1;
        private Provider<IncomingOrderViewModel> T2;
        private Provider<DeviceInfoSender> T3;
        private Provider<CleverTapManager> T4;
        private Provider<GetExternalSourceAddressInteractor> T5;
        private Provider<ee.mtakso.driver.ui.base.mvvm.ViewModelFactory> T6;
        private Provider<PayoutDetailsInfoPageFragment> T7;
        private Provider<ReferralCampaignDetailsFragment> T8;
        private Provider<FcmCleverTapPushTokenHandler> T9;
        private Provider<InternalLog> Ta;
        private Provider<DriverClient> U;
        private Provider<VoipApi> U0;
        private Provider<DrivePriceViewModel> U1;
        private Provider<InprogressCallInteractor> U2;
        private Provider<OrderViewModel> U3;
        private Provider<InboxItemsInteractor> U4;
        private Provider<GetSuggestionsInteractor> U5;
        private Provider<BaseUiDependencies> U6;
        private Provider<PayoutDetailsProgressPageFragment> U7;
        private Provider<OptInChoiceFragment> U8;
        private Provider<Set<PushTokenHandler>> U9;
        private Provider<LogStorage> Ua;
        private Provider<DeviceInfo> V;
        private Provider<VoipClient> V0;
        private Provider<EarningsApi> V1;
        private Provider<InprogressCallViewModel> V2;
        private Provider<PayoutHistoryInteractor> V3;
        private Provider<NewsAnalytics> V4;
        private Provider<GetExternalSourceAddressDetailInteractor> V5;
        private Provider<AutoAcceptanceSettingsFragment> V6;
        private Provider<InfoWebFragment> V7;
        private Provider<ScheduledOrdersFragment> V8;
        private Provider<AuthPushService> V9;
        private Provider<DidNotRespondStrategy> Va;
        private Provider<LanguageManager> W;
        private Provider<VoipCallDelegate> W0;
        private Provider<EarningsClient> W1;
        private Provider<StartUpTracing> W2;
        private Provider<PayoutHistoryViewModel> W3;
        private Provider<PartnerOffersAnalytics> W4;
        private Provider<UpdateDriverDestinationInteractor> W5;
        private Provider<BalanceFragment> W6;
        private Provider<OperationResultFragment> W7;
        private Provider<BoltClubListingFragment> W8;
        private Provider<AppVerificationAnalytics> W9;
        private Provider<OrderStateStrategy> Wa;
        private Provider<UrlFactory> X;
        private Provider<CallToRiderInteractor> X0;
        private Provider<EarningsInteractor> X1;
        private Provider<GetDashboardInteractor> X2;
        private Provider<StoriesApi> X3;
        private Provider<InboxViewModel> X4;
        private Provider<DriverDestinationSearchViewModel> X5;
        private Provider<WaybillFragment> X6;
        private Provider<OrderMapFragment> X7;
        private Provider<ScheduledOrderDetailsFragment> X8;
        private Provider<IdentityVerificationManager> X9;
        private Provider<DriverWrongStateStrategy> Xa;
        private Provider<DriverManager> Y;
        private Provider<ContactOptionsViewModel> Y0;
        private Provider<PayoutApi> Y1;
        private Provider<CampaignAnalytics> Y2;
        private Provider<StoriesClient> Y3;
        private Provider<DriverScoreMapper> Y4;
        private Provider<DriverDestinationActiveStateViewModel> Y5;
        private Provider<CircleKLoyaltyFragment> Y6;
        private Provider<DriverAppStickyBannerMapper> Y7;
        private Provider<OrderModalFragment> Y8;
        private Provider<DriverRestrictionManager> Y9;
        private Provider<OrderWrongStateStrategy> Ya;
        private Provider<GetDriverCarsInteractor> Z;
        private Provider<DriverDestinationsManager> Z0;
        private Provider<PayoutClient> Z1;
        private Provider<WorkDistanceDelegate> Z2;
        private Provider<StorySetViewModel> Z3;
        private Provider<DriverScoreTooltipFactory> Z4;
        private Provider<BoltClubOfferDetailsViewModel> Z5;
        private Provider<CircleKLoyaltyStarterFragment> Z6;
        private Provider<OrderPanelFragment> Z7;
        private Provider<TripCancellationBottomSheetFragment> Z8;
        private Provider<DriverAnalytics> Z9;
        private Provider<LocationStrategy> Za;

        /* renamed from: a  reason: collision with root package name */
        private final ApplicationComponent f20378a;

        /* renamed from: a0  reason: collision with root package name */
        private Provider<DeviceSettings> f20379a0;

        /* renamed from: a1  reason: collision with root package name */
        private Provider<DestinationLimitInteractor> f20380a1;

        /* renamed from: a2  reason: collision with root package name */
        private Provider<PayToBoltLinkInteractor> f20381a2;

        /* renamed from: a3  reason: collision with root package name */
        private Provider<LocationStorageCleaner> f20382a3;

        /* renamed from: a4  reason: collision with root package name */
        private Provider<PayoutInfoInteractor> f20383a4;

        /* renamed from: a5  reason: collision with root package name */
        private Provider<DriverScoreViewModel> f20384a5;

        /* renamed from: a6  reason: collision with root package name */
        private Provider<ThemeSettingsViewModel> f20385a6;

        /* renamed from: a7  reason: collision with root package name */
        private Provider<OptInCampaignFragment> f20386a7;
        private Provider<PayToBoltFragment> a8;
        private Provider<ScheduledOrdersGroupFragment> a9;
        private Provider<TokenManager> aa;
        private Provider<ActivityLifecycleStrategy> ab;

        /* renamed from: b  reason: collision with root package name */
        private final AuthorisedUiModule f20387b;

        /* renamed from: b0  reason: collision with root package name */
        private Provider<AuthenticatedAuthApi> f20388b0;

        /* renamed from: b1  reason: collision with root package name */
        private Provider<SavedDestinationsInteractor> f20389b1;

        /* renamed from: b2  reason: collision with root package name */
        private Provider<PayoutPayToBoltInfoInteractor> f20390b2;

        /* renamed from: b3  reason: collision with root package name */
        private Provider<ReferralCampaignsAnalytics> f20391b3;

        /* renamed from: b4  reason: collision with root package name */
        private Provider<ConfirmPayoutInteractor> f20392b4;

        /* renamed from: b5  reason: collision with root package name */
        private Provider<DriverScoreExplanationViewModel> f20393b5;

        /* renamed from: b6  reason: collision with root package name */
        private Provider<CurrentOrderInfoProvider> f20394b6;

        /* renamed from: b7  reason: collision with root package name */
        private Provider<AccountSettingsFragment> f20395b7;
        private Provider<QuickAccessSettingsFragment> b8;
        private Provider<DestinationFragment> b9;
        private Provider<PollerService> ba;
        private Provider<DriverOfflineDetectionStrategy> bb;

        /* renamed from: c  reason: collision with root package name */
        private final DriverConfig f20396c;

        /* renamed from: c0  reason: collision with root package name */
        private Provider<AuthenticatedAuthClient> f20397c0;

        /* renamed from: c1  reason: collision with root package name */
        private Provider<ActiveDestinationInteractor> f20398c1;

        /* renamed from: c2  reason: collision with root package name */
        private Provider<PayoutAnalytics> f20399c2;

        /* renamed from: c3  reason: collision with root package name */
        private Provider<FifoQueueManager> f20400c3;

        /* renamed from: c4  reason: collision with root package name */
        private Provider<PayoutRequestViewModel> f20401c4;

        /* renamed from: c5  reason: collision with root package name */
        private Provider<CallBackViewModel> f20402c5;

        /* renamed from: c6  reason: collision with root package name */
        private Provider<IncomingCallViewModel> f20403c6;

        /* renamed from: c7  reason: collision with root package name */
        private Provider<AppSettingsFragment> f20404c7;
        private Provider<SosDialogFragment> c8;
        private Provider<DriverDestinationSearchFragment> c9;
        private Provider<AuthService> ca;
        private Provider<ee.mtakso.driver.log.strategy.WebViewStrategy> cb;

        /* renamed from: d  reason: collision with root package name */
        private final ThemeModule f20405d;

        /* renamed from: d0  reason: collision with root package name */
        private Provider<GetDriverPortalTokenInteractor> f20406d0;

        /* renamed from: d1  reason: collision with root package name */
        private Provider<SelectDestinationInteractor> f20407d1;

        /* renamed from: d2  reason: collision with root package name */
        private Provider<ReportPageInteractor> f20408d2;

        /* renamed from: d3  reason: collision with root package name */
        private Provider<FifoModalInteractor> f20409d3;

        /* renamed from: d4  reason: collision with root package name */
        private Provider<DriverPriorityClient> f20410d4;

        /* renamed from: d5  reason: collision with root package name */
        private Provider<DriverPricingConfigurationApi> f20411d5;

        /* renamed from: d6  reason: collision with root package name */
        private Provider<GetOrderDestinationSearchSuggestionInteractor> f20412d6;

        /* renamed from: d7  reason: collision with root package name */
        private Provider<NavigationSettingsFragment> f20413d7;
        private Provider<TileClient> d8;
        private Provider<DriverDestinationActiveStateFragment> d9;
        private Provider<InstallationIdProvider> da;
        private Provider<CompositeWatcher> db;

        /* renamed from: e  reason: collision with root package name */
        private final DriverFeatures f20414e;

        /* renamed from: e0  reason: collision with root package name */
        private Provider<CarChooserViewModel> f20415e0;

        /* renamed from: e1  reason: collision with root package name */
        private Provider<DeactivateDestinationInteractor> f20416e1;

        /* renamed from: e2  reason: collision with root package name */
        private Provider<EarningsViewModel> f20417e2;

        /* renamed from: e3  reason: collision with root package name */
        private Provider<AdvertiserIdProvider> f20418e3;

        /* renamed from: e4  reason: collision with root package name */
        private Provider<DriverPriorityMapper> f20419e4;

        /* renamed from: e5  reason: collision with root package name */
        private Provider<DriverPricingConfigurationClient> f20420e5;

        /* renamed from: e6  reason: collision with root package name */
        private Provider<OrderDestinationViewModel> f20421e6;

        /* renamed from: e7  reason: collision with root package name */
        private Provider<NavigationSettingsTbtFragment> f20422e7;
        private Provider<TileRequestMerger> e8;
        private Provider<BoltClubOfferDetailsFragment> e9;
        private Provider<DeviceFingerprintCollector> ea;
        private Provider<LogSaver> eb;

        /* renamed from: f  reason: collision with root package name */
        private final AuthorisedCoreModule f20423f;

        /* renamed from: f0  reason: collision with root package name */
        private Provider<WorkingTimeManager> f20424f0;

        /* renamed from: f1  reason: collision with root package name */
        private Provider<DeleteDestinationInteractor> f20425f1;

        /* renamed from: f2  reason: collision with root package name */
        private Provider<DistinctDriverStateInteractor> f20426f2;

        /* renamed from: f3  reason: collision with root package name */
        private Provider<AppsflyerManager> f20427f3;

        /* renamed from: f4  reason: collision with root package name */
        private Provider<DriverPriorityViewModel> f20428f4;

        /* renamed from: f5  reason: collision with root package name */
        private Provider<PricingSettingsViewModel> f20429f5;

        /* renamed from: f6  reason: collision with root package name */
        private Provider<eu.bolt.driver.earnings.network.EarningsApi> f20430f6;

        /* renamed from: f7  reason: collision with root package name */
        private Provider<SettingsFragment> f20431f7;
        private Provider<VectorTileBitmapPool> f8;
        private Provider<OrderMenuDialogFragment> f9;
        private Provider<DeviceInfoApi> fa;
        private Provider<LogWorker> fb;

        /* renamed from: g  reason: collision with root package name */
        private final PollerModule f20432g;

        /* renamed from: g0  reason: collision with root package name */
        private Provider<NavigationAppTypeFactory> f20433g0;

        /* renamed from: g1  reason: collision with root package name */
        private Provider<GeoLocationManager> f20434g1;

        /* renamed from: g2  reason: collision with root package name */
        private Provider<Poller> f20435g2;

        /* renamed from: g3  reason: collision with root package name */
        private Provider<AttributedAnalyticsDelegate> f20436g3;

        /* renamed from: g4  reason: collision with root package name */
        private Provider<PayoutDetailsInteractor> f20437g4;

        /* renamed from: g5  reason: collision with root package name */
        private Provider<DriverPortalTokenInteractor> f20438g5;

        /* renamed from: g6  reason: collision with root package name */
        private Provider<eu.bolt.driver.earnings.network.EarningsClient> f20439g6;

        /* renamed from: g7  reason: collision with root package name */
        private Provider<NavigatorChooserFragment> f20440g7;
        private Provider<MvtToRasterConverter> g8;
        private Provider<AddStopBottomSheetDialogFragment> g9;
        private Provider<DeviceInfoClient> ga;
        private Provider<StorageConsumer> gb;

        /* renamed from: h  reason: collision with root package name */
        private final AuthorisedComponentImpl f20441h;

        /* renamed from: h0  reason: collision with root package name */
        private Provider<DriverReferralCampaignManager> f20442h0;

        /* renamed from: h1  reason: collision with root package name */
        private Provider<DestinationsViewModel> f20443h1;

        /* renamed from: h2  reason: collision with root package name */
        private Provider<BackgroundManager> f20444h2;

        /* renamed from: h3  reason: collision with root package name */
        private Provider<DriverButtonMapper> f20445h3;

        /* renamed from: h4  reason: collision with root package name */
        private Provider<PayoutDetailsViewModel> f20446h4;

        /* renamed from: h5  reason: collision with root package name */
        private Provider<VehicleListViewModel> f20447h5;

        /* renamed from: h6  reason: collision with root package name */
        private Provider<EarningsGoalApi> f20448h6;

        /* renamed from: h7  reason: collision with root package name */
        private Provider<ChoosePriceReviewDialog> f20449h7;
        private Provider<HeatmapTileSourceFactory> h8;
        private Provider<ThemeSettingsFragment> h9;
        private Provider<DeviceFingerprintManager> ha;
        private Provider<LogService> hb;

        /* renamed from: i  reason: collision with root package name */
        private Provider<DispatchSettingsManager> f20450i;

        /* renamed from: i0  reason: collision with root package name */
        private Provider<DriverStatusProvider> f20451i0;

        /* renamed from: i1  reason: collision with root package name */
        private Provider<DriverActivityInteractor> f20452i1;

        /* renamed from: i2  reason: collision with root package name */
        private Provider<PollerManager> f20453i2;

        /* renamed from: i3  reason: collision with root package name */
        private Provider<DriverImageMapper> f20454i3;

        /* renamed from: i4  reason: collision with root package name */
        private Provider<InfoWebViewModel> f20455i4;

        /* renamed from: i5  reason: collision with root package name */
        private Provider<DriverAppDisabledViewModel> f20456i5;

        /* renamed from: i6  reason: collision with root package name */
        private Provider<EarningsGoalClient> f20457i6;

        /* renamed from: i7  reason: collision with root package name */
        private Provider<DriverActivityFragment> f20458i7;
        private Provider<Gson> i8;
        private Provider<OptInChoiceActivationInfoFragment> i9;
        private Provider<DeviceFingerprintService> ia;
        private Provider<SessionProvider> ib;

        /* renamed from: j  reason: collision with root package name */
        private Provider<Context> f20459j;

        /* renamed from: j0  reason: collision with root package name */
        private Provider<OnBoardingManager> f20460j0;

        /* renamed from: j1  reason: collision with root package name */
        private Provider<DriverActivityViewModel> f20461j1;

        /* renamed from: j2  reason: collision with root package name */
        private Provider<DriverStatusSender> f20462j2;

        /* renamed from: j3  reason: collision with root package name */
        private Provider<HtmlEngine> f20463j3;

        /* renamed from: j4  reason: collision with root package name */
        private Provider<EarningsPaymentApi> f20464j4;

        /* renamed from: j5  reason: collision with root package name */
        private Provider<GetLanguageSettingsInteractor> f20465j5;

        /* renamed from: j6  reason: collision with root package name */
        private Provider<EarningsManager> f20466j6;

        /* renamed from: j7  reason: collision with root package name */
        private Provider<HomeFragment> f20467j7;
        private Provider<FeaturePropertiesFactory> j8;
        private Provider<OrderDestinationFragment> j9;
        private Provider<MixpanelController> ja;
        private Provider<SessionService> jb;

        /* renamed from: k  reason: collision with root package name */
        private Provider<Features> f20468k;

        /* renamed from: k0  reason: collision with root package name */
        private Provider<RoutingManager> f20469k0;

        /* renamed from: k1  reason: collision with root package name */
        private Provider<OrderClient> f20470k1;

        /* renamed from: k2  reason: collision with root package name */
        private Provider<DynamicPollingService> f20471k2;

        /* renamed from: k3  reason: collision with root package name */
        private Provider<FifoQueueStateMapper> f20472k3;

        /* renamed from: k4  reason: collision with root package name */
        private Provider<EarningsPaymentClient> f20473k4;

        /* renamed from: k5  reason: collision with root package name */
        private Provider<TranslationManager> f20474k5;

        /* renamed from: k6  reason: collision with root package name */
        private Provider<EarningsLandingViewModel> f20475k6;

        /* renamed from: k7  reason: collision with root package name */
        private Provider<FragmentFactory> f20476k7;
        private Provider<VectorPropertiesFactory> k8;
        private Provider<DriverChipMapper> k9;
        private Provider<MixpanelService> ka;
        private Provider<CleverTapService> kb;

        /* renamed from: l  reason: collision with root package name */
        private Provider<DriverProvider> f20477l;

        /* renamed from: l0  reason: collision with root package name */
        private Provider<ThemeHelper> f20478l0;

        /* renamed from: l1  reason: collision with root package name */
        private Provider<DrivePriceInteractor> f20479l1;

        /* renamed from: l2  reason: collision with root package name */
        private Provider<FixedPollingService> f20480l2;

        /* renamed from: l3  reason: collision with root package name */
        private Provider<DeepLinkManager> f20481l3;

        /* renamed from: l4  reason: collision with root package name */
        private Provider<PayToBoltViewModel> f20482l4;

        /* renamed from: l5  reason: collision with root package name */
        private Provider<SetLanguageInteractor> f20483l5;

        /* renamed from: l6  reason: collision with root package name */
        private Provider<EarningsItemMapper> f20484l6;

        /* renamed from: l7  reason: collision with root package name */
        private Provider<EffectsFactory> f20485l7;
        private Provider<WaitingTimeMarkerProvider> l8;
        private Provider<EarningsLandingMapper> l9;
        private Provider<GeoService> la;
        private Provider<PollMessageService> lb;

        /* renamed from: m  reason: collision with root package name */
        private Provider<AnalyticsManager> f20486m;

        /* renamed from: m0  reason: collision with root package name */
        private Provider<AppThemeManager> f20487m0;

        /* renamed from: m1  reason: collision with root package name */
        private Provider<OrderStateManager> f20488m1;

        /* renamed from: m2  reason: collision with root package name */
        private Provider<PollerSource> f20489m2;

        /* renamed from: m3  reason: collision with root package name */
        private Provider<DeeplinkDelegate> f20490m3;

        /* renamed from: m4  reason: collision with root package name */
        private Provider<QuickAccessStateAnalytics> f20491m4;

        /* renamed from: m5  reason: collision with root package name */
        private Provider<LanguageSettingsViewModel> f20492m5;

        /* renamed from: m6  reason: collision with root package name */
        private Provider<EarningsNestedItemMapper> f20493m6;

        /* renamed from: m7  reason: collision with root package name */
        private Provider<IncomingOrderSoundController> f20494m7;
        private Provider<WaitingTimeTileSourceFactory> m8;
        private Provider<EarningsLandingFragment> m9;
        private Provider<CacheCleanupService> ma;
        private Provider<NotificationCleanerService> mb;

        /* renamed from: n  reason: collision with root package name */
        private Provider<PackageManager> f20495n;

        /* renamed from: n0  reason: collision with root package name */
        private Provider<SettingsInteractor> f20496n0;

        /* renamed from: n1  reason: collision with root package name */
        private Provider<OrderTracing> f20497n1;

        /* renamed from: n2  reason: collision with root package name */
        private Provider<OnlineCheckInteractor> f20498n2;

        /* renamed from: n3  reason: collision with root package name */
        private Provider<WorkRadiusInteractor> f20499n3;

        /* renamed from: n4  reason: collision with root package name */
        private Provider<QuickAccessSettingsViewModel> f20500n4;

        /* renamed from: n5  reason: collision with root package name */
        private Provider<DateTimeFormatter> f20501n5;

        /* renamed from: n6  reason: collision with root package name */
        private Provider<EarningsBreakdownMapper> f20502n6;

        /* renamed from: n7  reason: collision with root package name */
        private Provider<IntentProvider> f20503n7;
        private Provider<RawTranslationProvider> n8;
        private Provider<EarningsBreakdownFragment> n9;
        private Provider<DriverDestinationsService> na;
        private Provider<ActiveCampaignInfoRefreshService> nb;

        /* renamed from: o  reason: collision with root package name */
        private Provider<ReportManager> f20504o;

        /* renamed from: o0  reason: collision with root package name */
        private Provider<MagicLinkInteractor> f20505o0;

        /* renamed from: o1  reason: collision with root package name */
        private Provider<OrderFlowAnalytics> f20506o1;

        /* renamed from: o2  reason: collision with root package name */
        private Provider<MakeDriverInactiveInteractor> f20507o2;

        /* renamed from: o3  reason: collision with root package name */
        private Provider<HeatmapSettingManager> f20508o3;

        /* renamed from: o4  reason: collision with root package name */
        private Provider<RateCallInteractor> f20509o4;

        /* renamed from: o5  reason: collision with root package name */
        private Provider<TripAudioSupportClient> f20510o5;

        /* renamed from: o6  reason: collision with root package name */
        private Provider<EarningsBreakdownViewModel> f20511o6;

        /* renamed from: o7  reason: collision with root package name */
        private Provider<NotificationManager> f20512o7;
        private Provider<WaitingTimeTranslationProvider> o8;
        private Provider<EarningsGoalFragment> o9;
        private Provider<DriverStatusService> oa;
        private Provider<FifoQueueService> ob;

        /* renamed from: p  reason: collision with root package name */
        private Provider<PlatformManager> f20513p;

        /* renamed from: p0  reason: collision with root package name */
        private Provider<LoginAnalytics> f20514p0;

        /* renamed from: p1  reason: collision with root package name */
        private Provider<ee.mtakso.driver.log.strategy.memory.OrderStateStrategy> f20515p1;

        /* renamed from: p2  reason: collision with root package name */
        private Provider<PushNotificationManager> f20516p2;

        /* renamed from: p3  reason: collision with root package name */
        private Provider<HeatmapOptionProvider> f20517p3;

        /* renamed from: p4  reason: collision with root package name */
        private Provider<RateCallViewModel> f20518p4;

        /* renamed from: p5  reason: collision with root package name */
        private Provider<AudioRecordingNetworkAPI> f20519p5;

        /* renamed from: p6  reason: collision with root package name */
        private Provider<EarningsGoalViewModel> f20520p6;

        /* renamed from: p7  reason: collision with root package name */
        private Provider<UiNotificationManager> f20521p7;
        private Provider<WaitingTimeMarkerRenderer> p8;
        private Provider<EarningsGoalExpensesFragment> p9;
        private Provider<PollingAnalyticsService> pa;
        private Provider<ThirdPartyIncidentService> pb;

        /* renamed from: q  reason: collision with root package name */
        private Provider<AnalyticsImpl> f20522q;

        /* renamed from: q0  reason: collision with root package name */
        private Provider<AppResolver> f20523q0;

        /* renamed from: q1  reason: collision with root package name */
        private Provider<NotRespondReporter> f20524q1;

        /* renamed from: q2  reason: collision with root package name */
        private Provider<PushDataService> f20525q2;

        /* renamed from: q3  reason: collision with root package name */
        private Provider<MapsConfigsService> f20526q3;

        /* renamed from: q4  reason: collision with root package name */
        private Provider<IncidentReportingService> f20527q4;

        /* renamed from: q5  reason: collision with root package name */
        private Provider<AudioRecordingClient> f20528q5;

        /* renamed from: q6  reason: collision with root package name */
        private Provider<EarningsGoalExpensesViewModel> f20529q6;

        /* renamed from: q7  reason: collision with root package name */
        private Provider<IncomingOrderFragment> f20530q7;
        private Provider<FifoQueueTileSource> q8;
        private Provider<SafetyToolkitMapper> q9;
        private Provider<IncomingOrderRoutingCoordinator> qa;
        private Provider<AudioRecordingService> qb;

        /* renamed from: r  reason: collision with root package name */
        private Provider<AutoAcceptanceSettingsViewModel> f20531r;

        /* renamed from: r0  reason: collision with root package name */
        private Provider<ChromeCustomTabsUrlLauncher> f20532r0;

        /* renamed from: r1  reason: collision with root package name */
        private Provider<WrongStateReporter> f20533r1;

        /* renamed from: r2  reason: collision with root package name */
        private Provider<ModalApi> f20534r2;

        /* renamed from: r3  reason: collision with root package name */
        private Provider<GetHeatmapStatusInteractor> f20535r3;

        /* renamed from: r4  reason: collision with root package name */
        private Provider<SosDialogViewModel> f20536r4;

        /* renamed from: r5  reason: collision with root package name */
        private Provider<AudioRecordingUploadAPI> f20537r5;

        /* renamed from: r6  reason: collision with root package name */
        private Provider<SafetyToolkitInteractor> f20538r6;
        private Provider<MapProvider> r7;
        private Provider<WorkMapFragment> r8;
        private Provider<SafetyToolkitBottomSheetFragment> r9;
        private Provider<OrderRoutingService> ra;
        private Provider<HeatmapSettingService> rb;

        /* renamed from: s  reason: collision with root package name */
        private Provider<OkHttpClient> f20539s;

        /* renamed from: s0  reason: collision with root package name */
        private Provider<SystemUrlLauncher> f20540s0;

        /* renamed from: s1  reason: collision with root package name */
        private Provider<OrderTracker> f20541s1;

        /* renamed from: s2  reason: collision with root package name */
        private Provider<ModalClient> f20542s2;

        /* renamed from: s3  reason: collision with root package name */
        private Provider<PermissionAnalytics> f20543s3;

        /* renamed from: s4  reason: collision with root package name */
        private Provider<VoipCallErrorDelegate> f20544s4;

        /* renamed from: s5  reason: collision with root package name */
        private Provider<AudioRecordingUploadClient> f20545s5;

        /* renamed from: s6  reason: collision with root package name */
        private Provider<SafetyToolkitViewModel> f20546s6;
        private Provider<MarkerParamsFactory> s7;
        private Provider<WorkTimeFragment> s8;
        private Provider<EmergencyAssistHelpBottomSheetFragment> s9;
        private Provider<PollingLoggerService> sa;
        private Provider<Set<BaseService>> sb;

        /* renamed from: t  reason: collision with root package name */
        private Provider<GsonConverterFactory> f20547t;

        /* renamed from: t0  reason: collision with root package name */
        private Provider<CompositeUrlLauncher> f20548t0;

        /* renamed from: t1  reason: collision with root package name */
        private Provider<RateMePrefsManager> f20549t1;

        /* renamed from: t2  reason: collision with root package name */
        private Provider<SingleModalDialogInteractor> f20550t2;

        /* renamed from: t3  reason: collision with root package name */
        private Provider<WorkViewModel> f20551t3;

        /* renamed from: t4  reason: collision with root package name */
        private Provider<VoipCallErrorInteractor> f20552t4;

        /* renamed from: t5  reason: collision with root package name */
        private Provider<UploadAudioRecordingManager> f20553t5;

        /* renamed from: t6  reason: collision with root package name */
        private Provider<EmergencyAssistDataMapper> f20554t6;
        private Provider<IncomingOrderMapFragment> t7;
        private Provider<RateRiderFragment> t8;
        private Provider<DidYouGetHelpFragment> t9;
        private Provider<OrderAppRoutingService> ta;
        private Provider<AuthorisedServicesRunner> tb;

        /* renamed from: u  reason: collision with root package name */
        private Provider<SimpleXmlConverterFactory> f20555u;

        /* renamed from: u0  reason: collision with root package name */
        private Provider<ChromeUrlLauncher> f20556u0;

        /* renamed from: u1  reason: collision with root package name */
        private Provider<RideHistoryApi> f20557u1;

        /* renamed from: u2  reason: collision with root package name */
        private Provider<ChatService> f20558u2;

        /* renamed from: u3  reason: collision with root package name */
        private Provider<NoAnswerInteractor> f20559u3;

        /* renamed from: u4  reason: collision with root package name */
        private Provider<VoipCallErrorViewModel> f20560u4;

        /* renamed from: u5  reason: collision with root package name */
        private Provider<AudioRecordingAnalytics> f20561u5;

        /* renamed from: u6  reason: collision with root package name */
        private Provider<EmergencyAssistHelpViewModel> f20562u6;
        private Provider<PromoDialogDelegate> u7;
        private Provider<RateRiderDialogFragment> u8;
        private Provider<ActiveIncidentDialogFragment> u9;
        private Provider<LocationStateService> ua;
        private Provider<Retrofit.Builder> ub;

        /* renamed from: v  reason: collision with root package name */
        private Provider<ApiFactory> f20563v;

        /* renamed from: v0  reason: collision with root package name */
        private Provider<CompositeChromeFirstUrlLauncher> f20564v0;

        /* renamed from: v1  reason: collision with root package name */
        private Provider<RideHistoryClient> f20565v1;

        /* renamed from: v2  reason: collision with root package name */
        private Provider<TokenProvider> f20566v2;

        /* renamed from: v3  reason: collision with root package name */
        private Provider<NoAnswerViewModel> f20567v3;

        /* renamed from: v4  reason: collision with root package name */
        private Provider<ScheduledOrderProvider> f20568v4;

        /* renamed from: v5  reason: collision with root package name */
        private Provider<OrderHistoryDetailsViewModel> f20569v5;

        /* renamed from: v6  reason: collision with root package name */
        private Provider<DidYouGetHelpViewModel> f20570v6;
        private Provider<ModalDelegate> v7;
        private Provider<RateMeCategoriesFragment> v8;
        private Provider<AudioRecordingBottomSheetFragment> v9;
        private Provider<B2bService> va;
        private Provider<StoryFragment> vb;

        /* renamed from: w  reason: collision with root package name */
        private Provider<WaybillApi> f20571w;

        /* renamed from: w0  reason: collision with root package name */
        private Provider<SupportApi> f20572w0;

        /* renamed from: w1  reason: collision with root package name */
        private Provider<OrderHistoryManager> f20573w1;

        /* renamed from: w2  reason: collision with root package name */
        private Provider<ContactOptionsService> f20574w2;

        /* renamed from: w3  reason: collision with root package name */
        private Provider<UpcomingStopDistanceService> f20575w3;

        /* renamed from: w4  reason: collision with root package name */
        private Provider<ScheduledOrderManager> f20576w4;

        /* renamed from: w5  reason: collision with root package name */
        private Provider<CampaignFactory> f20577w5;

        /* renamed from: w6  reason: collision with root package name */
        private Provider<StartRecordingInteractor> f20578w6;
        private Provider<MicrophonePermissionDialogProvider> w7;
        private Provider<RateMeReasonsFragment> w8;
        private Provider<EarningsBalanceFragment> w9;
        private Provider<OrderTimerService> wa;
        private Provider<Fragment> wb;

        /* renamed from: x  reason: collision with root package name */
        private Provider<WaybillClient> f20579x;

        /* renamed from: x0  reason: collision with root package name */
        private Provider<SupportClient> f20580x0;

        /* renamed from: x1  reason: collision with root package name */
        private Provider<AppRatingManager> f20581x1;

        /* renamed from: x2  reason: collision with root package name */
        private Provider<PermissionManager> f20582x2;

        /* renamed from: x3  reason: collision with root package name */
        private Provider<OrderDistanceInteractor> f20583x3;

        /* renamed from: x4  reason: collision with root package name */
        private Provider<TripCancellationViewModel> f20584x4;

        /* renamed from: x5  reason: collision with root package name */
        private Provider<FutureCampaignFactory> f20585x5;

        /* renamed from: x6  reason: collision with root package name */
        private Provider<AudioRecordingViewModel> f20586x6;
        private Provider<LowStorageDialogDelegate> x7;
        private Provider<SupportFragment> x8;
        private Provider<RequestWebUrlFragment> x9;
        private Provider<OrderUpdaterService> xa;
        private Provider<Fragment> xb;

        /* renamed from: y  reason: collision with root package name */
        private Provider<WaybillViewModel> f20587y;

        /* renamed from: y0  reason: collision with root package name */
        private Provider<AuthManager> f20588y0;

        /* renamed from: y1  reason: collision with root package name */
        private Provider<NetworkService> f20589y1;

        /* renamed from: y2  reason: collision with root package name */
        private Provider<DriverSettingsInMemory> f20590y2;

        /* renamed from: y3  reason: collision with root package name */
        private Provider<AutoReminderImpl> f20591y3;

        /* renamed from: y4  reason: collision with root package name */
        private Provider<DriverAreaInteractor> f20592y4;

        /* renamed from: y5  reason: collision with root package name */
        private Provider<ActiveCampaignsViewModel> f20593y5;

        /* renamed from: y6  reason: collision with root package name */
        private Provider<EarningsBalanceApi> f20594y6;
        private Provider<WorkFragment> y7;
        private Provider<DriverBlockedFragment> y8;
        private Provider<EarningsPayoutExplanationFragment> y9;
        private Provider<SurgeService> ya;
        private Provider<MessageMenuFragment> yb;

        /* renamed from: z  reason: collision with root package name */
        private Provider<WebViewAnalytics> f20595z;

        /* renamed from: z0  reason: collision with root package name */
        private Provider<SettingsViewModel> f20596z0;

        /* renamed from: z1  reason: collision with root package name */
        private Provider<InternetDataDelegate> f20597z1;

        /* renamed from: z2  reason: collision with root package name */
        private Provider<DriverScoreApi> f20598z2;

        /* renamed from: z3  reason: collision with root package name */
        private Provider<BottomSheetStateInteractor> f20599z3;

        /* renamed from: z4  reason: collision with root package name */
        private Provider<SearchApi> f20600z4;

        /* renamed from: z5  reason: collision with root package name */
        private Provider<PastCampaignsViewModel> f20601z5;

        /* renamed from: z6  reason: collision with root package name */
        private Provider<EarningsBalanceClient> f20602z6;
        private Provider<BaseFragmentParams> z7;
        private Provider<RateMeDialogDelegate> z8;
        private Provider<MapSettingsFragment> z9;
        private Provider<StaticStopDetailsService> za;
        private Provider<MessageMapper> zb;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class AdvertiserIdProviderProvider implements Provider<AdvertiserIdProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20603a;

            AdvertiserIdProviderProvider(ApplicationComponent applicationComponent) {
                this.f20603a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AdvertiserIdProvider get() {
                return (AdvertiserIdProvider) Preconditions.checkNotNullFromComponent(this.f20603a.p());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class AnalyticsManagerProvider implements Provider<AnalyticsManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20604a;

            AnalyticsManagerProvider(ApplicationComponent applicationComponent) {
                this.f20604a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AnalyticsManager get() {
                return (AnalyticsManager) Preconditions.checkNotNullFromComponent(this.f20604a.x0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ApiErrorsProvider implements Provider<ApiExceptionProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20605a;

            ApiErrorsProvider(ApplicationComponent applicationComponent) {
                this.f20605a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ApiExceptionProvider get() {
                return (ApiExceptionProvider) Preconditions.checkNotNullFromComponent(this.f20605a.S0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class AppPerformanceAnalyticsProvider implements Provider<AppPerformanceAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20606a;

            AppPerformanceAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20606a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AppPerformanceAnalytics get() {
                return (AppPerformanceAnalytics) Preconditions.checkNotNullFromComponent(this.f20606a.y1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ApplogProvider implements Provider<AppLogWatcher> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20607a;

            ApplogProvider(ApplicationComponent applicationComponent) {
                this.f20607a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AppLogWatcher get() {
                return (AppLogWatcher) Preconditions.checkNotNullFromComponent(this.f20607a.R());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ApproutingProvider implements Provider<AppRoutingManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20608a;

            ApproutingProvider(ApplicationComponent applicationComponent) {
                this.f20608a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AppRoutingManager get() {
                return (AppRoutingManager) Preconditions.checkNotNullFromComponent(this.f20608a.g0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class AttributionProvider implements Provider<AppsflyerManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20609a;

            AttributionProvider(ApplicationComponent applicationComponent) {
                this.f20609a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AppsflyerManager get() {
                return (AppsflyerManager) Preconditions.checkNotNullFromComponent(this.f20609a.x1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class AudioRecordingAnalyticsProvider implements Provider<AudioRecordingAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20610a;

            AudioRecordingAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20610a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AudioRecordingAnalytics get() {
                return (AudioRecordingAnalytics) Preconditions.checkNotNullFromComponent(this.f20610a.W0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class AuthApi2Provider implements Provider<AuthenticatedAuthApi> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20611a;

            AuthApi2Provider(ApplicationComponent applicationComponent) {
                this.f20611a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AuthenticatedAuthApi get() {
                return (AuthenticatedAuthApi) Preconditions.checkNotNullFromComponent(this.f20611a.b0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class AuthManagerProvider implements Provider<AuthManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20612a;

            AuthManagerProvider(ApplicationComponent applicationComponent) {
                this.f20612a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AuthManager get() {
                return (AuthManager) Preconditions.checkNotNullFromComponent(this.f20612a.w0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class BackgroundManagerProvider implements Provider<BackgroundManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20613a;

            BackgroundManagerProvider(ApplicationComponent applicationComponent) {
                this.f20613a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public BackgroundManager get() {
                return (BackgroundManager) Preconditions.checkNotNullFromComponent(this.f20613a.R1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class BigQueryProvider implements Provider<BigQueryLogWatcher> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20614a;

            BigQueryProvider(ApplicationComponent applicationComponent) {
                this.f20614a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public BigQueryLogWatcher get() {
                return (BigQueryLogWatcher) Preconditions.checkNotNullFromComponent(this.f20614a.r());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class CampaignAnalyticsProvider implements Provider<CampaignAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20615a;

            CampaignAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20615a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public CampaignAnalytics get() {
                return (CampaignAnalytics) Preconditions.checkNotNullFromComponent(this.f20615a.p1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class CategoriesProvider implements Provider<DispatchSettingsManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20616a;

            CategoriesProvider(ApplicationComponent applicationComponent) {
                this.f20616a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DispatchSettingsManager get() {
                return (DispatchSettingsManager) Preconditions.checkNotNullFromComponent(this.f20616a.H1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ChatAnalyticsProvider implements Provider<ChatAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20617a;

            ChatAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20617a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ChatAnalytics get() {
                return (ChatAnalytics) Preconditions.checkNotNullFromComponent(this.f20617a.n0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ChatConnProviderProvider implements Provider<ChatConnectionProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20618a;

            ChatConnProviderProvider(ApplicationComponent applicationComponent) {
                this.f20618a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ChatConnectionProvider get() {
                return (ChatConnectionProvider) Preconditions.checkNotNullFromComponent(this.f20618a.N1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ChatManagerProvider implements Provider<ChatManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20619a;

            ChatManagerProvider(ApplicationComponent applicationComponent) {
                this.f20619a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ChatManager get() {
                return (ChatManager) Preconditions.checkNotNullFromComponent(this.f20619a.L());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ChatProvider implements Provider<ChatService> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20620a;

            ChatProvider(ApplicationComponent applicationComponent) {
                this.f20620a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ChatService get() {
                return (ChatService) Preconditions.checkNotNullFromComponent(this.f20620a.F1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ChatPushHandlerProvider implements Provider<ChatPushHandler> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20621a;

            ChatPushHandlerProvider(ApplicationComponent applicationComponent) {
                this.f20621a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ChatPushHandler get() {
                return (ChatPushHandler) Preconditions.checkNotNullFromComponent(this.f20621a.d());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ChatRepoProvider implements Provider<ChatRepo> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20622a;

            ChatRepoProvider(ApplicationComponent applicationComponent) {
                this.f20622a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ChatRepo get() {
                return (ChatRepo) Preconditions.checkNotNullFromComponent(this.f20622a.g());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class CleverTapProvider implements Provider<CleverTapManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20623a;

            CleverTapProvider(ApplicationComponent applicationComponent) {
                this.f20623a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public CleverTapManager get() {
                return (CleverTapManager) Preconditions.checkNotNullFromComponent(this.f20623a.G1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ContactApiProvider implements Provider<ContactApi> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20624a;

            ContactApiProvider(ApplicationComponent applicationComponent) {
                this.f20624a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ContactApi get() {
                return (ContactApi) Preconditions.checkNotNullFromComponent(this.f20624a.X());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ContextProvider implements Provider<Context> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20625a;

            ContextProvider(ApplicationComponent applicationComponent) {
                this.f20625a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.f20625a.A0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DatabaseProvider implements Provider<DatabaseManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20626a;

            DatabaseProvider(ApplicationComponent applicationComponent) {
                this.f20626a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DatabaseManager get() {
                return (DatabaseManager) Preconditions.checkNotNullFromComponent(this.f20626a.D0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DateTimeConverterProvider implements Provider<DateTimeConverter> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20627a;

            DateTimeConverterProvider(ApplicationComponent applicationComponent) {
                this.f20627a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DateTimeConverter get() {
                return (DateTimeConverter) Preconditions.checkNotNullFromComponent(this.f20627a.C0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DateTimeFormatterProvider implements Provider<DateTimeFormatter> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20628a;

            DateTimeFormatterProvider(ApplicationComponent applicationComponent) {
                this.f20628a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DateTimeFormatter get() {
                return (DateTimeFormatter) Preconditions.checkNotNullFromComponent(this.f20628a.v1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DateTimeProviderProvider implements Provider<TrueTimeProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20629a;

            DateTimeProviderProvider(ApplicationComponent applicationComponent) {
                this.f20629a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public TrueTimeProvider get() {
                return (TrueTimeProvider) Preconditions.checkNotNullFromComponent(this.f20629a.G());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DeepLinkManagerProvider implements Provider<DeepLinkManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20630a;

            DeepLinkManagerProvider(ApplicationComponent applicationComponent) {
                this.f20630a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DeepLinkManager get() {
                return (DeepLinkManager) Preconditions.checkNotNullFromComponent(this.f20630a.Z());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DeeplinkHomeContainerCoordinatorProvider implements Provider<DeeplinkHomeContainerCoordinator> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20631a;

            DeeplinkHomeContainerCoordinatorProvider(ApplicationComponent applicationComponent) {
                this.f20631a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DeeplinkHomeContainerCoordinator get() {
                return (DeeplinkHomeContainerCoordinator) Preconditions.checkNotNullFromComponent(this.f20631a.C1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DestinationsProvider implements Provider<DriverDestinationsManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20632a;

            DestinationsProvider(ApplicationComponent applicationComponent) {
                this.f20632a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DriverDestinationsManager get() {
                return (DriverDestinationsManager) Preconditions.checkNotNullFromComponent(this.f20632a.j1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DeviceInfoApiProvider implements Provider<DeviceInfoApi> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20633a;

            DeviceInfoApiProvider(ApplicationComponent applicationComponent) {
                this.f20633a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DeviceInfoApi get() {
                return (DeviceInfoApi) Preconditions.checkNotNullFromComponent(this.f20633a.C());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DeviceInfoSenderProvider implements Provider<DeviceInfoSender> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20634a;

            DeviceInfoSenderProvider(ApplicationComponent applicationComponent) {
                this.f20634a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DeviceInfoSender get() {
                return (DeviceInfoSender) Preconditions.checkNotNullFromComponent(this.f20634a.J0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DeviceProvider implements Provider<DeviceInfo> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20635a;

            DeviceProvider(ApplicationComponent applicationComponent) {
                this.f20635a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DeviceInfo get() {
                return (DeviceInfo) Preconditions.checkNotNullFromComponent(this.f20635a.l());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DeviceSettingsProvider implements Provider<DeviceSettings> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20636a;

            DeviceSettingsProvider(ApplicationComponent applicationComponent) {
                this.f20636a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DeviceSettings get() {
                return (DeviceSettings) Preconditions.checkNotNullFromComponent(this.f20636a.M());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DjProvider implements Provider<SoundEffectsPool> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20637a;

            DjProvider(ApplicationComponent applicationComponent) {
                this.f20637a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public SoundEffectsPool get() {
                return (SoundEffectsPool) Preconditions.checkNotNullFromComponent(this.f20637a.s0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DriverAnalyticsProvider implements Provider<DriverAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20638a;

            DriverAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20638a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DriverAnalytics get() {
                return (DriverAnalytics) Preconditions.checkNotNullFromComponent(this.f20638a.d1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DriverJourneyTraceProvider implements Provider<OrderTracing> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20639a;

            DriverJourneyTraceProvider(ApplicationComponent applicationComponent) {
                this.f20639a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public OrderTracing get() {
                return (OrderTracing) Preconditions.checkNotNullFromComponent(this.f20639a.N());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DriverManagerProvider implements Provider<DriverManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20640a;

            DriverManagerProvider(ApplicationComponent applicationComponent) {
                this.f20640a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DriverManager get() {
                return (DriverManager) Preconditions.checkNotNullFromComponent(this.f20640a.Q0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DriverProviderProvider implements Provider<DriverProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20641a;

            DriverProviderProvider(ApplicationComponent applicationComponent) {
                this.f20641a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DriverProvider get() {
                return (DriverProvider) Preconditions.checkNotNullFromComponent(this.f20641a.t());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DriverStateProvider implements Provider<DriverStatusProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20642a;

            DriverStateProvider(ApplicationComponent applicationComponent) {
                this.f20642a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DriverStatusProvider get() {
                return (DriverStatusProvider) Preconditions.checkNotNullFromComponent(this.f20642a.z0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DriverStatusSenderProvider implements Provider<DriverStatusSender> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20643a;

            DriverStatusSenderProvider(ApplicationComponent applicationComponent) {
                this.f20643a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DriverStatusSender get() {
                return (DriverStatusSender) Preconditions.checkNotNullFromComponent(this.f20643a.V0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class DriverTrainingRestrictionManagerProvider implements Provider<DriverTrainingRestrictionManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20644a;

            DriverTrainingRestrictionManagerProvider(ApplicationComponent applicationComponent) {
                this.f20644a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public DriverTrainingRestrictionManager get() {
                return (DriverTrainingRestrictionManager) Preconditions.checkNotNullFromComponent(this.f20644a.F());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class EarningsApiProvider implements Provider<eu.bolt.driver.earnings.network.EarningsApi> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20645a;

            EarningsApiProvider(ApplicationComponent applicationComponent) {
                this.f20645a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public eu.bolt.driver.earnings.network.EarningsApi get() {
                return (eu.bolt.driver.earnings.network.EarningsApi) Preconditions.checkNotNullFromComponent(this.f20645a.J());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class EarningsBalanceApiProvider implements Provider<EarningsBalanceApi> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20646a;

            EarningsBalanceApiProvider(ApplicationComponent applicationComponent) {
                this.f20646a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public EarningsBalanceApi get() {
                return (EarningsBalanceApi) Preconditions.checkNotNullFromComponent(this.f20646a.s());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class EarningsGoalApiProvider implements Provider<EarningsGoalApi> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20647a;

            EarningsGoalApiProvider(ApplicationComponent applicationComponent) {
                this.f20647a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public EarningsGoalApi get() {
                return (EarningsGoalApi) Preconditions.checkNotNullFromComponent(this.f20647a.l0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class FeaturesProvider implements Provider<Features> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20648a;

            FeaturesProvider(ApplicationComponent applicationComponent) {
                this.f20648a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public Features get() {
                return (Features) Preconditions.checkNotNullFromComponent(this.f20648a.z());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class GsonProvider implements Provider<Gson> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20649a;

            GsonProvider(ApplicationComponent applicationComponent) {
                this.f20649a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public Gson get() {
                return (Gson) Preconditions.checkNotNullFromComponent(this.f20649a.b1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class HistoryAnalyticsProvider implements Provider<HistoryAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20650a;

            HistoryAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20650a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public HistoryAnalytics get() {
                return (HistoryAnalytics) Preconditions.checkNotNullFromComponent(this.f20650a.u());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class HtmlEngineProvider implements Provider<HtmlEngine> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20651a;

            HtmlEngineProvider(ApplicationComponent applicationComponent) {
                this.f20651a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public HtmlEngine get() {
                return (HtmlEngine) Preconditions.checkNotNullFromComponent(this.f20651a.j0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class IdProviderProvider implements Provider<InstallationIdProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20652a;

            IdProviderProvider(ApplicationComponent applicationComponent) {
                this.f20652a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public InstallationIdProvider get() {
                return (InstallationIdProvider) Preconditions.checkNotNullFromComponent(this.f20652a.G0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class IdentityVerificationManagerProvider implements Provider<IdentityVerificationManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20653a;

            IdentityVerificationManagerProvider(ApplicationComponent applicationComponent) {
                this.f20653a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public IdentityVerificationManager get() {
                return (IdentityVerificationManager) Preconditions.checkNotNullFromComponent(this.f20653a.I0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class IoDispatcherProvider implements Provider<CoroutineDispatcher> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20654a;

            IoDispatcherProvider(ApplicationComponent applicationComponent) {
                this.f20654a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public CoroutineDispatcher get() {
                return (CoroutineDispatcher) Preconditions.checkNotNullFromComponent(this.f20654a.O1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class JsonConverterProvider implements Provider<GsonConverterFactory> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20655a;

            JsonConverterProvider(ApplicationComponent applicationComponent) {
                this.f20655a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public GsonConverterFactory get() {
                return (GsonConverterFactory) Preconditions.checkNotNullFromComponent(this.f20655a.I());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class LanguageManagerProvider implements Provider<LanguageManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20656a;

            LanguageManagerProvider(ApplicationComponent applicationComponent) {
                this.f20656a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public LanguageManager get() {
                return (LanguageManager) Preconditions.checkNotNullFromComponent(this.f20656a.a());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class LocationCleanerProvider implements Provider<LocationStorageCleaner> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20657a;

            LocationCleanerProvider(ApplicationComponent applicationComponent) {
                this.f20657a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public LocationStorageCleaner get() {
                return (LocationStorageCleaner) Preconditions.checkNotNullFromComponent(this.f20657a.e0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class LocationManagerProvider implements Provider<GeoLocationManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20658a;

            LocationManagerProvider(ApplicationComponent applicationComponent) {
                this.f20658a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public GeoLocationManager get() {
                return (GeoLocationManager) Preconditions.checkNotNullFromComponent(this.f20658a.o1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class LocationTransmitterProvider implements Provider<LocationTransmitter> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20659a;

            LocationTransmitterProvider(ApplicationComponent applicationComponent) {
                this.f20659a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public LocationTransmitter get() {
                return (LocationTransmitter) Preconditions.checkNotNullFromComponent(this.f20659a.N0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class LogManagerProvider implements Provider<LogManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20660a;

            LogManagerProvider(ApplicationComponent applicationComponent) {
                this.f20660a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public LogManager get() {
                return (LogManager) Preconditions.checkNotNullFromComponent(this.f20660a.r1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class LogWorkerProvider implements Provider<LogWorker> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20661a;

            LogWorkerProvider(ApplicationComponent applicationComponent) {
                this.f20661a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public LogWorker get() {
                return (LogWorker) Preconditions.checkNotNullFromComponent(this.f20661a.m1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class LoginAnalyticsV2Provider implements Provider<LoginAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20662a;

            LoginAnalyticsV2Provider(ApplicationComponent applicationComponent) {
                this.f20662a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public LoginAnalytics get() {
                return (LoginAnalytics) Preconditions.checkNotNullFromComponent(this.f20662a.i());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class MapProvider2Provider implements Provider<MapProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20663a;

            MapProvider2Provider(ApplicationComponent applicationComponent) {
                this.f20663a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public MapProvider get() {
                return (MapProvider) Preconditions.checkNotNullFromComponent(this.f20663a.w());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class MixpanelProvider implements Provider<MixpanelController> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20664a;

            MixpanelProvider(ApplicationComponent applicationComponent) {
                this.f20664a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public MixpanelController get() {
                return (MixpanelController) Preconditions.checkNotNullFromComponent(this.f20664a.O0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class NavigationProvider implements Provider<NavigationManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20665a;

            NavigationProvider(ApplicationComponent applicationComponent) {
                this.f20665a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public NavigationManager get() {
                return (NavigationManager) Preconditions.checkNotNullFromComponent(this.f20665a.O());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class NavigatorFactoryProvider implements Provider<NavigationAppTypeFactory> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20666a;

            NavigatorFactoryProvider(ApplicationComponent applicationComponent) {
                this.f20666a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public NavigationAppTypeFactory get() {
                return (NavigationAppTypeFactory) Preconditions.checkNotNullFromComponent(this.f20666a.y());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class NetworkProvider implements Provider<NetworkService> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20667a;

            NetworkProvider(ApplicationComponent applicationComponent) {
                this.f20667a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public NetworkService get() {
                return (NetworkService) Preconditions.checkNotNullFromComponent(this.f20667a.V());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class NewsAnalyticsProvider implements Provider<NewsAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20668a;

            NewsAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20668a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public NewsAnalytics get() {
                return (NewsAnalytics) Preconditions.checkNotNullFromComponent(this.f20668a.P0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class NoAnswerIncomingCallCacheProvider implements Provider<NoAnswerCallCache> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20669a;

            NoAnswerIncomingCallCacheProvider(ApplicationComponent applicationComponent) {
                this.f20669a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public NoAnswerCallCache get() {
                return (NoAnswerCallCache) Preconditions.checkNotNullFromComponent(this.f20669a.W());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class NotRespondReporterProvider implements Provider<NotRespondReporter> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20670a;

            NotRespondReporterProvider(ApplicationComponent applicationComponent) {
                this.f20670a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public NotRespondReporter get() {
                return (NotRespondReporter) Preconditions.checkNotNullFromComponent(this.f20670a.t1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class NotificationManagerProvider implements Provider<NotificationManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20671a;

            NotificationManagerProvider(ApplicationComponent applicationComponent) {
                this.f20671a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public NotificationManager get() {
                return (NotificationManager) Preconditions.checkNotNullFromComponent(this.f20671a.m0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class OkHttpClientProvider implements Provider<OkHttpClient> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20672a;

            OkHttpClientProvider(ApplicationComponent applicationComponent) {
                this.f20672a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public OkHttpClient get() {
                return (OkHttpClient) Preconditions.checkNotNullFromComponent(this.f20672a.o0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class OnBoardingManagerProvider implements Provider<OnBoardingManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20673a;

            OnBoardingManagerProvider(ApplicationComponent applicationComponent) {
                this.f20673a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public OnBoardingManager get() {
                return (OnBoardingManager) Preconditions.checkNotNullFromComponent(this.f20673a.i1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class OptInCampaignAnalyticsProvider implements Provider<OptInCampaignAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20674a;

            OptInCampaignAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20674a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public OptInCampaignAnalytics get() {
                return (OptInCampaignAnalytics) Preconditions.checkNotNullFromComponent(this.f20674a.A1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class OrderFlowAnalyticsProvider implements Provider<OrderFlowAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20675a;

            OrderFlowAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20675a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public OrderFlowAnalytics get() {
                return (OrderFlowAnalytics) Preconditions.checkNotNullFromComponent(this.f20675a.u1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class OrderProviderProvider implements Provider<OrderProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20676a;

            OrderProviderProvider(ApplicationComponent applicationComponent) {
                this.f20676a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public OrderProvider get() {
                return (OrderProvider) Preconditions.checkNotNullFromComponent(this.f20676a.B0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class OrderStateManagerProvider implements Provider<OrderStateManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20677a;

            OrderStateManagerProvider(ApplicationComponent applicationComponent) {
                this.f20677a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public OrderStateManager get() {
                return (OrderStateManager) Preconditions.checkNotNullFromComponent(this.f20677a.Q());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class OrderStateProvider implements Provider<ee.mtakso.driver.log.strategy.memory.OrderStateStrategy> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20678a;

            OrderStateProvider(ApplicationComponent applicationComponent) {
                this.f20678a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ee.mtakso.driver.log.strategy.memory.OrderStateStrategy get() {
                return (ee.mtakso.driver.log.strategy.memory.OrderStateStrategy) Preconditions.checkNotNullFromComponent(this.f20678a.F0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class OrdersProvider implements Provider<OrdersCache> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20679a;

            OrdersProvider(ApplicationComponent applicationComponent) {
                this.f20679a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public OrdersCache get() {
                return (OrdersCache) Preconditions.checkNotNullFromComponent(this.f20679a.f());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PackageManagerProvider implements Provider<PackageManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20680a;

            PackageManagerProvider(ApplicationComponent applicationComponent) {
                this.f20680a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PackageManager get() {
                return (PackageManager) Preconditions.checkNotNullFromComponent(this.f20680a.E1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PartnerOffersAnalyticsProvider implements Provider<PartnerOffersAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20681a;

            PartnerOffersAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20681a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PartnerOffersAnalytics get() {
                return (PartnerOffersAnalytics) Preconditions.checkNotNullFromComponent(this.f20681a.S1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PayoutAnalyticsProvider implements Provider<PayoutAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20682a;

            PayoutAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20682a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PayoutAnalytics get() {
                return (PayoutAnalytics) Preconditions.checkNotNullFromComponent(this.f20682a.R0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PermissionAnalyticsProvider implements Provider<PermissionAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20683a;

            PermissionAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20683a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PermissionAnalytics get() {
                return (PermissionAnalytics) Preconditions.checkNotNullFromComponent(this.f20683a.K1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PermissionManagerProvider implements Provider<PermissionManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20684a;

            PermissionManagerProvider(ApplicationComponent applicationComponent) {
                this.f20684a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PermissionManager get() {
                return (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20684a.i0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PlatformManagerProvider implements Provider<PlatformManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20685a;

            PlatformManagerProvider(ApplicationComponent applicationComponent) {
                this.f20685a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PlatformManager get() {
                return (PlatformManager) Preconditions.checkNotNullFromComponent(this.f20685a.D1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PollerProvider implements Provider<Poller> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20686a;

            PollerProvider(ApplicationComponent applicationComponent) {
                this.f20686a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public Poller get() {
                return (Poller) Preconditions.checkNotNullFromComponent(this.f20686a.u0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PushManagerImplProvider implements Provider<PushManagerImpl> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20687a;

            PushManagerImplProvider(ApplicationComponent applicationComponent) {
                this.f20687a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PushManagerImpl get() {
                return (PushManagerImpl) Preconditions.checkNotNullFromComponent(this.f20687a.v());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class PushNotificationsProvider implements Provider<PushNotificationManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20688a;

            PushNotificationsProvider(ApplicationComponent applicationComponent) {
                this.f20688a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public PushNotificationManager get() {
                return (PushNotificationManager) Preconditions.checkNotNullFromComponent(this.f20688a.t0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class QaAnalyticsProvider implements Provider<QuickAccessStateAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20689a;

            QaAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20689a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public QuickAccessStateAnalytics get() {
                return (QuickAccessStateAnalytics) Preconditions.checkNotNullFromComponent(this.f20689a.w1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class RawTranslationProviderProvider implements Provider<RawTranslationProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20690a;

            RawTranslationProviderProvider(ApplicationComponent applicationComponent) {
                this.f20690a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public RawTranslationProvider get() {
                return (RawTranslationProvider) Preconditions.checkNotNullFromComponent(this.f20690a.a1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ReadMessageInteractorProvider implements Provider<ReadMessageInteractor> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20691a;

            ReadMessageInteractorProvider(ApplicationComponent applicationComponent) {
                this.f20691a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ReadMessageInteractor get() {
                return (ReadMessageInteractor) Preconditions.checkNotNullFromComponent(this.f20691a.b());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ReferralCampaignsAnalyticsProvider implements Provider<ReferralCampaignsAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20692a;

            ReferralCampaignsAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20692a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ReferralCampaignsAnalytics get() {
                return (ReferralCampaignsAnalytics) Preconditions.checkNotNullFromComponent(this.f20692a.S());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ReportManagerProvider implements Provider<ReportManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20693a;

            ReportManagerProvider(ApplicationComponent applicationComponent) {
                this.f20693a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ReportManager get() {
                return (ReportManager) Preconditions.checkNotNullFromComponent(this.f20693a.g1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ReporterProvider implements Provider<WrongStateReporter> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20694a;

            ReporterProvider(ApplicationComponent applicationComponent) {
                this.f20694a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public WrongStateReporter get() {
                return (WrongStateReporter) Preconditions.checkNotNullFromComponent(this.f20694a.E0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ReportsProvider implements Provider<IncidentReportingService> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20695a;

            ReportsProvider(ApplicationComponent applicationComponent) {
                this.f20695a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public IncidentReportingService get() {
                return (IncidentReportingService) Preconditions.checkNotNullFromComponent(this.f20695a.D());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class RequestReplySuggestionsInteractorProvider implements Provider<RequestReplySuggestionsInteractor> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20696a;

            RequestReplySuggestionsInteractorProvider(ApplicationComponent applicationComponent) {
                this.f20696a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public RequestReplySuggestionsInteractor get() {
                return (RequestReplySuggestionsInteractor) Preconditions.checkNotNullFromComponent(this.f20696a.e());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ResponseProcessorProvider implements Provider<ResponseErrorProcessor> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20697a;

            ResponseProcessorProvider(ApplicationComponent applicationComponent) {
                this.f20697a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ResponseErrorProcessor get() {
                return (ResponseErrorProcessor) Preconditions.checkNotNullFromComponent(this.f20697a.Q1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class RouterProvider implements Provider<RoutingManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20698a;

            RouterProvider(ApplicationComponent applicationComponent) {
                this.f20698a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public RoutingManager get() {
                return (RoutingManager) Preconditions.checkNotNullFromComponent(this.f20698a.A());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class SafetyToolkitAnalyticsProvider implements Provider<SafetyToolkitAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20699a;

            SafetyToolkitAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20699a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public SafetyToolkitAnalytics get() {
                return (SafetyToolkitAnalytics) Preconditions.checkNotNullFromComponent(this.f20699a.K());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ScreenAnalyticsProvider implements Provider<ScreenAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20700a;

            ScreenAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20700a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ScreenAnalytics get() {
                return (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20700a.J1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class SendChatMessageInteractorProvider implements Provider<SendChatMessageInteractor> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20701a;

            SendChatMessageInteractorProvider(ApplicationComponent applicationComponent) {
                this.f20701a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public SendChatMessageInteractor get() {
                return (SendChatMessageInteractor) Preconditions.checkNotNullFromComponent(this.f20701a.c());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class SessionProviderProvider implements Provider<SessionProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20702a;

            SessionProviderProvider(ApplicationComponent applicationComponent) {
                this.f20702a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public SessionProvider get() {
                return (SessionProvider) Preconditions.checkNotNullFromComponent(this.f20702a.h1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class SettingsAnalyticsProvider implements Provider<SettingsAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20703a;

            SettingsAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20703a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public SettingsAnalytics get() {
                return (SettingsAnalytics) Preconditions.checkNotNullFromComponent(this.f20703a.M1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class ShardApiProvider implements Provider<ee.mtakso.driver.network.client.ShardApiProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20704a;

            ShardApiProvider(ApplicationComponent applicationComponent) {
                this.f20704a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public ee.mtakso.driver.network.client.ShardApiProvider get() {
                return (ee.mtakso.driver.network.client.ShardApiProvider) Preconditions.checkNotNullFromComponent(this.f20704a.T0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class StartUpTracingProvider implements Provider<StartUpTracing> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20705a;

            StartUpTracingProvider(ApplicationComponent applicationComponent) {
                this.f20705a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public StartUpTracing get() {
                return (StartUpTracing) Preconditions.checkNotNullFromComponent(this.f20705a.m());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class SupportApiProvider implements Provider<SupportApi> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20706a;

            SupportApiProvider(ApplicationComponent applicationComponent) {
                this.f20706a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public SupportApi get() {
                return (SupportApi) Preconditions.checkNotNullFromComponent(this.f20706a.c0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class SurgeProvider implements Provider<SurgeManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20707a;

            SurgeProvider(ApplicationComponent applicationComponent) {
                this.f20707a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public SurgeManager get() {
                return (SurgeManager) Preconditions.checkNotNullFromComponent(this.f20707a.k1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class TimedAnalyticsProvider implements Provider<TimedAnalyticsManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20708a;

            TimedAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20708a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public TimedAnalyticsManager get() {
                return (TimedAnalyticsManager) Preconditions.checkNotNullFromComponent(this.f20708a.U1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class TokenManagerProvider implements Provider<TokenManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20709a;

            TokenManagerProvider(ApplicationComponent applicationComponent) {
                this.f20709a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public TokenManager get() {
                return (TokenManager) Preconditions.checkNotNullFromComponent(this.f20709a.T1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class TokenProviderProvider implements Provider<TokenProvider> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20710a;

            TokenProviderProvider(ApplicationComponent applicationComponent) {
                this.f20710a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public TokenProvider get() {
                return (TokenProvider) Preconditions.checkNotNullFromComponent(this.f20710a.h0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class TranslationManagerProvider implements Provider<TranslationManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20711a;

            TranslationManagerProvider(ApplicationComponent applicationComponent) {
                this.f20711a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public TranslationManager get() {
                return (TranslationManager) Preconditions.checkNotNullFromComponent(this.f20711a.X0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class UploadApiProvider implements Provider<AudioRecordingUploadAPI> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20712a;

            UploadApiProvider(ApplicationComponent applicationComponent) {
                this.f20712a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AudioRecordingUploadAPI get() {
                return (AudioRecordingUploadAPI) Preconditions.checkNotNullFromComponent(this.f20712a.L0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class VectorTileBitmapPoolProvider implements Provider<VectorTileBitmapPool> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20713a;

            VectorTileBitmapPoolProvider(ApplicationComponent applicationComponent) {
                this.f20713a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public VectorTileBitmapPool get() {
                return (VectorTileBitmapPool) Preconditions.checkNotNullFromComponent(this.f20713a.p0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class VerificationProvider implements Provider<AppVerificationAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20714a;

            VerificationProvider(ApplicationComponent applicationComponent) {
                this.f20714a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public AppVerificationAnalytics get() {
                return (AppVerificationAnalytics) Preconditions.checkNotNullFromComponent(this.f20714a.k0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class VoipLifecycleProvider implements Provider<VoipRxLifecycleTransfromer> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20715a;

            VoipLifecycleProvider(ApplicationComponent applicationComponent) {
                this.f20715a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public VoipRxLifecycleTransfromer get() {
                return (VoipRxLifecycleTransfromer) Preconditions.checkNotNullFromComponent(this.f20715a.q0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class VoipProvider implements Provider<VoipService> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20716a;

            VoipProvider(ApplicationComponent applicationComponent) {
                this.f20716a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public VoipService get() {
                return (VoipService) Preconditions.checkNotNullFromComponent(this.f20716a.f1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class WebViewAnalyticsProvider implements Provider<WebViewAnalytics> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20717a;

            WebViewAnalyticsProvider(ApplicationComponent applicationComponent) {
                this.f20717a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public WebViewAnalytics get() {
                return (WebViewAnalytics) Preconditions.checkNotNullFromComponent(this.f20717a.s1());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class WebViewStrategyProvider implements Provider<WebViewStrategy> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20718a;

            WebViewStrategyProvider(ApplicationComponent applicationComponent) {
                this.f20718a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public WebViewStrategy get() {
                return (WebViewStrategy) Preconditions.checkNotNullFromComponent(this.f20718a.f0());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class WorkingTimeProvider implements Provider<WorkingTimeManager> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20719a;

            WorkingTimeProvider(ApplicationComponent applicationComponent) {
                this.f20719a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public WorkingTimeManager get() {
                return (WorkingTimeManager) Preconditions.checkNotNullFromComponent(this.f20719a.q());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class XmlConverterProvider implements Provider<SimpleXmlConverterFactory> {

            /* renamed from: a  reason: collision with root package name */
            private final ApplicationComponent f20720a;

            XmlConverterProvider(ApplicationComponent applicationComponent) {
                this.f20720a = applicationComponent;
            }

            @Override // javax.inject.Provider
            /* renamed from: a */
            public SimpleXmlConverterFactory get() {
                return (SimpleXmlConverterFactory) Preconditions.checkNotNullFromComponent(this.f20720a.y0());
            }
        }

        private AuthorisedComponentImpl(AuthorisedCoreModule authorisedCoreModule, AuthorisedNetworkModule authorisedNetworkModule, AuthorisedServicesModule authorisedServicesModule, AuthorisedStaffModule authorisedStaffModule, AuthorisedUiModule authorisedUiModule, ThemeModule themeModule, DriverChatAuthorisedModule driverChatAuthorisedModule, StoriesModule storiesModule, PollerModule pollerModule, TripAudioRecordingModule tripAudioRecordingModule, ApplicationComponent applicationComponent, DriverConfig driverConfig, DriverSettings driverSettings, DriverFeatures driverFeatures, AnchoredTimeSource anchoredTimeSource) {
            this.f20441h = this;
            this.f20378a = applicationComponent;
            this.f20387b = authorisedUiModule;
            this.f20396c = driverConfig;
            this.f20405d = themeModule;
            this.f20414e = driverFeatures;
            this.f20423f = authorisedCoreModule;
            this.f20432g = pollerModule;
            T(authorisedCoreModule, authorisedNetworkModule, authorisedServicesModule, authorisedStaffModule, authorisedUiModule, themeModule, driverChatAuthorisedModule, storiesModule, pollerModule, tripAudioRecordingModule, applicationComponent, driverConfig, driverSettings, driverFeatures, anchoredTimeSource);
            U(authorisedCoreModule, authorisedNetworkModule, authorisedServicesModule, authorisedStaffModule, authorisedUiModule, themeModule, driverChatAuthorisedModule, storiesModule, pollerModule, tripAudioRecordingModule, applicationComponent, driverConfig, driverSettings, driverFeatures, anchoredTimeSource);
            V(authorisedCoreModule, authorisedNetworkModule, authorisedServicesModule, authorisedStaffModule, authorisedUiModule, themeModule, driverChatAuthorisedModule, storiesModule, pollerModule, tripAudioRecordingModule, applicationComponent, driverConfig, driverSettings, driverFeatures, anchoredTimeSource);
            W(authorisedCoreModule, authorisedNetworkModule, authorisedServicesModule, authorisedStaffModule, authorisedUiModule, themeModule, driverChatAuthorisedModule, storiesModule, pollerModule, tripAudioRecordingModule, applicationComponent, driverConfig, driverSettings, driverFeatures, anchoredTimeSource);
            X(authorisedCoreModule, authorisedNetworkModule, authorisedServicesModule, authorisedStaffModule, authorisedUiModule, themeModule, driverChatAuthorisedModule, storiesModule, pollerModule, tripAudioRecordingModule, applicationComponent, driverConfig, driverSettings, driverFeatures, anchoredTimeSource);
            Y(authorisedCoreModule, authorisedNetworkModule, authorisedServicesModule, authorisedStaffModule, authorisedUiModule, themeModule, driverChatAuthorisedModule, storiesModule, pollerModule, tripAudioRecordingModule, applicationComponent, driverConfig, driverSettings, driverFeatures, anchoredTimeSource);
            Z(authorisedCoreModule, authorisedNetworkModule, authorisedServicesModule, authorisedStaffModule, authorisedUiModule, themeModule, driverChatAuthorisedModule, storiesModule, pollerModule, tripAudioRecordingModule, applicationComponent, driverConfig, driverSettings, driverFeatures, anchoredTimeSource);
        }

        private VoipCallErrorFragment A0(VoipCallErrorFragment voipCallErrorFragment) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(voipCallErrorFragment, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(voipCallErrorFragment, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(voipCallErrorFragment, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            return voipCallErrorFragment;
        }

        private VoipFloatingActivity B0(VoipFloatingActivity voipFloatingActivity) {
            BaseActivity_MembersInjector.b(voipFloatingActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            BaseActivity_MembersInjector.a(voipFloatingActivity, b());
            VoipFloatingActivity_MembersInjector.b(voipFloatingActivity, (VoipActiveWindowTracker) Preconditions.checkNotNullFromComponent(this.f20378a.T()));
            VoipFloatingActivity_MembersInjector.c(voipFloatingActivity, (VoipNotificationDrawer) Preconditions.checkNotNullFromComponent(this.f20378a.L1()));
            VoipFloatingActivity_MembersInjector.a(voipFloatingActivity, J());
            return voipFloatingActivity;
        }

        private IntentProvider C0() {
            return new IntentProvider((Context) Preconditions.checkNotNullFromComponent(this.f20378a.A0()));
        }

        private Map<Class<? extends Fragment>, Provider<Fragment>> D0() {
            return MapBuilder.newMapBuilder(5).put(StoryFragment.class, this.wb).put(StorySetFragment.class, this.xb).put(MessageMenuFragment.class, this.yb).put(ConversationFragment.class, this.Ab).put(ConversationPagerFragment.class, this.Cb).build();
        }

        private PushDialogDelegate E0() {
            return new PushDialogDelegate(G0(), L0());
        }

        private RateMePrefsManager F0() {
            return new RateMePrefsManager((DriverProvider) Preconditions.checkNotNullFromComponent(this.f20378a.t()));
        }

        private SystemUrlLauncher H0() {
            return new SystemUrlLauncher((Context) Preconditions.checkNotNullFromComponent(this.f20378a.A0()));
        }

        private AnalyticsImpl I() {
            return new AnalyticsImpl((Context) Preconditions.checkNotNullFromComponent(this.f20378a.A0()), (Features) Preconditions.checkNotNullFromComponent(this.f20378a.z()), (DriverProvider) Preconditions.checkNotNullFromComponent(this.f20378a.t()), (AnalyticsManager) Preconditions.checkNotNullFromComponent(this.f20378a.x0()), (PackageManager) Preconditions.checkNotNullFromComponent(this.f20378a.E1()), (ReportManager) Preconditions.checkNotNullFromComponent(this.f20378a.g1()), (PlatformManager) Preconditions.checkNotNullFromComponent(this.f20378a.D1()));
        }

        private ThemeHelper I0() {
            return ThemeModule_ProvideThemeHelperFactory.c(this.f20405d, (DriverProvider) Preconditions.checkNotNullFromComponent(this.f20378a.t()));
        }

        private AppThemeManager J() {
            return new AppThemeManager((Context) Preconditions.checkNotNullFromComponent(this.f20378a.A0()), (RoutingManager) Preconditions.checkNotNullFromComponent(this.f20378a.A()), I0());
        }

        private ThemeManager J0() {
            return AuthorisedCoreModule_ProvideThemeManagerFactory.c(this.f20423f, (DriverProvider) Preconditions.checkNotNullFromComponent(this.f20378a.t()));
        }

        private Map<Class<? extends Fragment>, Provider<Fragment>> K() {
            return MapBuilder.newMapBuilder(89).put(AboutDriverDestinationsFragment.class, this.R6).put(AutoAcceptanceSettingsFragment.class, this.V6).put(BalanceFragment.class, this.W6).put(WaybillFragment.class, this.X6).put(CircleKLoyaltyFragment.class, this.Y6).put(CircleKLoyaltyStarterFragment.class, this.Z6).put(OptInCampaignFragment.class, this.f20386a7).put(AccountSettingsFragment.class, this.f20395b7).put(AppSettingsFragment.class, this.f20404c7).put(NavigationSettingsFragment.class, this.f20413d7).put(NavigationSettingsTbtFragment.class, this.f20422e7).put(SettingsFragment.class, this.f20431f7).put(NavigatorChooserFragment.class, this.f20440g7).put(ChoosePriceReviewDialog.class, this.f20449h7).put(DriverActivityFragment.class, this.f20458i7).put(HomeFragment.class, this.f20467j7).put(IncomingOrderFragment.class, this.f20530q7).put(IncomingOrderMapFragment.class, this.t7).put(WorkFragment.class, this.y7).put(StorySetFragment.class, this.P7).put(PayoutHistoryFragment.class, this.Q7).put(PayoutRequestFragment.class, this.R7).put(DriverPriorityFragment.class, this.S7).put(PayoutDetailsInfoPageFragment.class, this.T7).put(PayoutDetailsProgressPageFragment.class, this.U7).put(InfoWebFragment.class, this.V7).put(OperationResultFragment.class, this.W7).put(OrderMapFragment.class, this.X7).put(OrderPanelFragment.class, this.Z7).put(PayToBoltFragment.class, this.a8).put(QuickAccessSettingsFragment.class, this.b8).put(SosDialogFragment.class, this.c8).put(WorkMapFragment.class, this.r8).put(WorkTimeFragment.class, this.s8).put(RateRiderFragment.class, this.t8).put(RateRiderDisclaimerFragment.class, RateRiderDisclaimerFragment_Factory.a()).put(RateRiderDialogFragment.class, this.u8).put(RateMeCategoriesFragment.class, this.v8).put(RateMeReasonsFragment.class, this.w8).put(SupportFragment.class, this.x8).put(DriverBlockedFragment.class, this.y8).put(OrderListFragment.class, this.A8).put(InboxFragment.class, this.B8).put(DriverScoreFragment.class, this.C8).put(DriverScoreExplanationFragment.class, this.D8).put(PricingSettingsFragment.class, this.E8).put(VehicleListFragment.class, this.F8).put(DriverAppDisabledFragment.class, this.G8).put(LanguageSettingsFragment.class, this.H8).put(OrderHistoryDetailsFragment.class, this.I8).put(FileUploadConfirmationDialog.class, this.J8).put(RetryFileUploadFragment.class, this.K8).put(ActiveCampaignsFragment.class, this.L8).put(CustomPriceFragment.class, this.M8).put(PricePreviewFragment.class, this.N8).put(PastCampaignsFragment.class, this.O8).put(CampaignDetailsFragment.class, this.S8).put(ReferralCampaignDetailsFragment.class, this.T8).put(OptInChoiceFragment.class, this.U8).put(ScheduledOrdersFragment.class, this.V8).put(BoltClubListingFragment.class, this.W8).put(ScheduledOrderDetailsFragment.class, this.X8).put(OrderModalFragment.class, this.Y8).put(TripCancellationBottomSheetFragment.class, this.Z8).put(ScheduledOrdersGroupFragment.class, this.a9).put(DestinationFragment.class, this.b9).put(DriverDestinationSearchFragment.class, this.c9).put(DriverDestinationActiveStateFragment.class, this.d9).put(BoltClubOfferDetailsFragment.class, this.e9).put(OrderMenuDialogFragment.class, this.f9).put(AddStopBottomSheetDialogFragment.class, this.g9).put(ThemeSettingsFragment.class, this.h9).put(OptInChoiceActivationInfoFragment.class, this.i9).put(OrderDestinationFragment.class, this.j9).put(EarningsLandingFragment.class, this.m9).put(EarningsBreakdownFragment.class, this.n9).put(EarningsGoalFragment.class, this.o9).put(EarningsGoalExpensesFragment.class, this.p9).put(SafetyToolkitBottomSheetFragment.class, this.r9).put(EmergencyAssistHelpBottomSheetFragment.class, this.s9).put(DidYouGetHelpFragment.class, this.t9).put(ActiveIncidentDialogFragment.class, this.u9).put(AudioRecordingBottomSheetFragment.class, this.v9).put(EarningsBalanceFragment.class, this.w9).put(RequestWebUrlFragment.class, this.x9).put(EarningsPayoutExplanationFragment.class, this.y9).put(MapSettingsFragment.class, this.z9).put(HowToRequestPayoutFragment.class, this.A9).put(MapExplanationFragment.class, this.B9).build();
        }

        private ThemeProvider K0() {
            return AuthorisedCoreModule_ProvideThemeProviderFactory.a(this.f20423f, R());
        }

        private Map<Class<? extends ViewModel>, Provider<ViewModel>> L() {
            return MapBuilder.newMapBuilder(79).put(AutoAcceptanceSettingsViewModel.class, this.f20531r).put(WaybillViewModel.class, this.f20587y).put(CircleKLoyaltyViewModel.class, this.C).put(CircleKLoyaltyStarterViewModel.class, this.G).put(OptInCampaignViewModel.class, this.O).put(DispatchSettingsViewModel.class, this.T).put(CarChooserViewModel.class, this.f20415e0).put(SettingsViewModel.class, this.f20596z0).put(NavigationSettingsTbtViewModel.class, this.A0).put(NavigatorChooserViewModel.class, this.F0).put(ChoosePriceReviewViewModel.class, this.J0).put(ContactOptionsViewModel.class, this.Y0).put(DestinationsViewModel.class, this.f20443h1).put(DriverActivityViewModel.class, this.f20461j1).put(DrivePriceViewModel.class, this.U1).put(EarningsViewModel.class, this.f20417e2).put(HomeViewModel.class, this.N2).put(ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallViewModel.class, IncomingCallViewModel_Factory.a()).put(IncomingOrderViewModel.class, this.T2).put(InprogressCallViewModel.class, this.V2).put(MapPaddingViewModel.class, MapPaddingViewModel_Factory.a()).put(WorkViewModel.class, this.f20551t3).put(NoAnswerViewModel.class, this.f20567v3).put(OrderViewModel.class, this.U3).put(PayoutHistoryViewModel.class, this.W3).put(StorySetViewModel.class, this.Z3).put(PayoutRequestViewModel.class, this.f20401c4).put(DriverPriorityViewModel.class, this.f20428f4).put(PayoutDetailsViewModel.class, this.f20446h4).put(InfoWebViewModel.class, this.f20455i4).put(PayToBoltViewModel.class, this.f20482l4).put(QuickAccessSettingsViewModel.class, this.f20500n4).put(RateCallViewModel.class, this.f20518p4).put(SosDialogViewModel.class, this.f20536r4).put(VoipCallErrorViewModel.class, this.f20560u4).put(TripCancellationViewModel.class, this.f20584x4).put(WorkMapViewModel.class, this.J4).put(WorkTimeViewModel.class, this.L4).put(RateMeCategoryViewModel.class, this.O4).put(SupportViewModel.class, this.P4).put(OrderListViewModel.class, this.R4).put(InboxViewModel.class, this.X4).put(DriverScoreViewModel.class, this.f20384a5).put(DriverScoreExplanationViewModel.class, this.f20393b5).put(CallBackViewModel.class, this.f20402c5).put(PricingSettingsViewModel.class, this.f20429f5).put(VehicleListViewModel.class, this.f20447h5).put(DriverAppDisabledViewModel.class, this.f20456i5).put(LanguageSettingsViewModel.class, this.f20492m5).put(OrderHistoryDetailsViewModel.class, this.f20569v5).put(ActiveCampaignsViewModel.class, this.f20593y5).put(PastCampaignsViewModel.class, this.f20601z5).put(CampaignDetailsViewModel.class, this.A5).put(ReferralCampaignDetailsViewModel.class, this.D5).put(OptInChoiceViewModel.class, this.E5).put(ScheduledOrdersViewModel.class, this.J5).put(BoltClubViewModel.class, this.N5).put(ScheduledOrderDetailsViewModel.class, this.R5).put(ScheduledOrdersGroupViewModel.class, this.S5).put(DriverDestinationSearchViewModel.class, this.X5).put(DriverDestinationActiveStateViewModel.class, this.Y5).put(BoltClubOfferDetailsViewModel.class, this.Z5).put(ThemeSettingsViewModel.class, this.f20385a6).put(IncomingCallViewModel.class, this.f20403c6).put(OrderDestinationViewModel.class, this.f20421e6).put(EarningsLandingViewModel.class, this.f20475k6).put(EarningsBreakdownViewModel.class, this.f20511o6).put(EarningsGoalViewModel.class, this.f20520p6).put(EarningsGoalExpensesViewModel.class, this.f20529q6).put(SafetyToolkitViewModel.class, this.f20546s6).put(EmergencyAssistHelpViewModel.class, this.f20562u6).put(DidYouGetHelpViewModel.class, this.f20570v6).put(AudioRecordingViewModel.class, this.f20586x6).put(EarningsBalanceViewModel.class, this.F6).put(RequestWebUrlViewModel.class, this.G6).put(EarningsPayoutExplanationViewModel.class, this.H6).put(MapSettingsViewModel.class, this.L6).put(HowToRequestPayoutViewModel.class, this.M6).put(MapExplanationViewModel.class, this.P6).build();
        }

        private UiNotificationManager L0() {
            return new UiNotificationManager((Context) Preconditions.checkNotNullFromComponent(this.f20378a.A0()), C0(), (NotificationManager) Preconditions.checkNotNullFromComponent(this.f20378a.m0()), new VoipEffectsFactory());
        }

        private ChromeCustomTabsUrlLauncher M() {
            return new ChromeCustomTabsUrlLauncher((Context) Preconditions.checkNotNullFromComponent(this.f20378a.A0()));
        }

        private UrlFactory M0() {
            return new UrlFactory((DeviceInfo) Preconditions.checkNotNullFromComponent(this.f20378a.l()), (LanguageManager) Preconditions.checkNotNullFromComponent(this.f20378a.a()));
        }

        private CompositeUrlLauncher N() {
            return new CompositeUrlLauncher(M(), H0());
        }

        private ee.mtakso.driver.ui.base.mvvm.ViewModelFactory N0() {
            return AuthorisedUiModule_ProvideAuthViewModelFactoryFactory.c(this.f20387b, L());
        }

        private VoipPermissionDialogFactory O0() {
            return new VoipPermissionDialogFactory(P0(), (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()), (DriverProvider) Preconditions.checkNotNullFromComponent(this.f20378a.t()));
        }

        private DebugDrawerInitializerImpl P() {
            return new DebugDrawerInitializerImpl((Features) Preconditions.checkNotNullFromComponent(this.f20378a.z()));
        }

        private VoipPrefsManager P0() {
            return new VoipPrefsManager((DriverProvider) Preconditions.checkNotNullFromComponent(this.f20378a.t()));
        }

        private DialerLauncher Q() {
            return new DialerLauncher(I());
        }

        private DriverThemeProvider R() {
            return new DriverThemeProvider(J0());
        }

        private EffectsFactory S() {
            return new EffectsFactory((Context) Preconditions.checkNotNullFromComponent(this.f20378a.A0()));
        }

        private void T(AuthorisedCoreModule authorisedCoreModule, AuthorisedNetworkModule authorisedNetworkModule, AuthorisedServicesModule authorisedServicesModule, AuthorisedStaffModule authorisedStaffModule, AuthorisedUiModule authorisedUiModule, ThemeModule themeModule, DriverChatAuthorisedModule driverChatAuthorisedModule, StoriesModule storiesModule, PollerModule pollerModule, TripAudioRecordingModule tripAudioRecordingModule, ApplicationComponent applicationComponent, DriverConfig driverConfig, DriverSettings driverSettings, DriverFeatures driverFeatures, AnchoredTimeSource anchoredTimeSource) {
            this.f20450i = new CategoriesProvider(applicationComponent);
            this.f20459j = new ContextProvider(applicationComponent);
            this.f20468k = new FeaturesProvider(applicationComponent);
            this.f20477l = new DriverProviderProvider(applicationComponent);
            this.f20486m = new AnalyticsManagerProvider(applicationComponent);
            this.f20495n = new PackageManagerProvider(applicationComponent);
            this.f20504o = new ReportManagerProvider(applicationComponent);
            PlatformManagerProvider platformManagerProvider = new PlatformManagerProvider(applicationComponent);
            this.f20513p = platformManagerProvider;
            AnalyticsImpl_Factory a8 = AnalyticsImpl_Factory.a(this.f20459j, this.f20468k, this.f20477l, this.f20486m, this.f20495n, this.f20504o, platformManagerProvider);
            this.f20522q = a8;
            this.f20531r = AutoAcceptanceSettingsViewModel_Factory.a(this.f20450i, a8);
            this.f20539s = new OkHttpClientProvider(applicationComponent);
            this.f20547t = new JsonConverterProvider(applicationComponent);
            XmlConverterProvider xmlConverterProvider = new XmlConverterProvider(applicationComponent);
            this.f20555u = xmlConverterProvider;
            ApiFactory_Factory a9 = ApiFactory_Factory.a(this.f20547t, xmlConverterProvider);
            this.f20563v = a9;
            Provider<WaybillApi> provider = DoubleCheck.provider(AuthorisedNetworkModule_ProvideWaybillApiFactory.a(authorisedNetworkModule, this.f20539s, a9));
            this.f20571w = provider;
            WaybillClient_Factory a10 = WaybillClient_Factory.a(provider);
            this.f20579x = a10;
            this.f20587y = WaybillViewModel_Factory.a(a10);
            this.f20595z = new WebViewAnalyticsProvider(applicationComponent);
            WebViewStrategyProvider webViewStrategyProvider = new WebViewStrategyProvider(applicationComponent);
            this.A = webViewStrategyProvider;
            WebViewTracker_Factory a11 = WebViewTracker_Factory.a(this.f20595z, webViewStrategyProvider);
            this.B = a11;
            this.C = CircleKLoyaltyViewModel_Factory.a(a11);
            this.D = DoubleCheck.provider(AuthorisedNetworkModule_ProvidesCircleKApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            ResponseProcessorProvider responseProcessorProvider = new ResponseProcessorProvider(applicationComponent);
            this.E = responseProcessorProvider;
            CircleKClient_Factory a12 = CircleKClient_Factory.a(this.D, responseProcessorProvider);
            this.F = a12;
            this.G = CircleKLoyaltyStarterViewModel_Factory.a(a12);
            this.H = DoubleCheck.provider(AuthorisedNetworkModule_ProvidesCampaignApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.I = new ShardApiProvider(applicationComponent);
            CompositeResponseTransformer_Factory a13 = CompositeResponseTransformer_Factory.a(ExposeResponseTransformer_Factory.a());
            this.J = a13;
            CampaignClient_Factory a14 = CampaignClient_Factory.a(this.H, this.I, a13);
            this.K = a14;
            this.L = DoubleCheck.provider(CampaignManager_Factory.a(a14));
            this.M = new OptInCampaignAnalyticsProvider(applicationComponent);
            DateTimeConverterProvider dateTimeConverterProvider = new DateTimeConverterProvider(applicationComponent);
            this.N = dateTimeConverterProvider;
            this.O = OptInCampaignViewModel_Factory.a(this.L, this.M, dateTimeConverterProvider);
            this.P = new SurgeProvider(applicationComponent);
            this.Q = InstanceFactory.create(driverFeatures);
            this.R = InstanceFactory.create(driverSettings);
            SettingsAnalyticsProvider settingsAnalyticsProvider = new SettingsAnalyticsProvider(applicationComponent);
            this.S = settingsAnalyticsProvider;
            this.T = DispatchSettingsViewModel_Factory.a(this.f20450i, this.f20522q, this.P, this.Q, this.R, settingsAnalyticsProvider);
            this.U = DriverClient_Factory.a(this.I, this.J, this.E);
            this.V = new DeviceProvider(applicationComponent);
            LanguageManagerProvider languageManagerProvider = new LanguageManagerProvider(applicationComponent);
            this.W = languageManagerProvider;
            this.X = UrlFactory_Factory.a(this.V, languageManagerProvider);
            DriverManagerProvider driverManagerProvider = new DriverManagerProvider(applicationComponent);
            this.Y = driverManagerProvider;
            this.Z = GetDriverCarsInteractor_Factory.a(this.U, driverManagerProvider, this.f20477l);
            this.f20379a0 = new DeviceSettingsProvider(applicationComponent);
            AuthApi2Provider authApi2Provider = new AuthApi2Provider(applicationComponent);
            this.f20388b0 = authApi2Provider;
            AuthenticatedAuthClient_Factory a15 = AuthenticatedAuthClient_Factory.a(this.V, this.f20379a0, authApi2Provider, this.J, this.E);
            this.f20397c0 = a15;
            GetDriverPortalTokenInteractor_Factory a16 = GetDriverPortalTokenInteractor_Factory.a(a15);
            this.f20406d0 = a16;
            this.f20415e0 = CarChooserViewModel_Factory.a(this.f20477l, this.U, this.X, this.Z, a16, this.Y);
            this.f20424f0 = new WorkingTimeProvider(applicationComponent);
            this.f20433g0 = new NavigatorFactoryProvider(applicationComponent);
            this.f20442h0 = DriverReferralCampaignManager_Factory.a(this.f20477l);
            this.f20451i0 = new DriverStateProvider(applicationComponent);
            this.f20460j0 = new OnBoardingManagerProvider(applicationComponent);
            this.f20469k0 = new RouterProvider(applicationComponent);
            ThemeModule_ProvideThemeHelperFactory a17 = ThemeModule_ProvideThemeHelperFactory.a(themeModule, this.f20477l);
            this.f20478l0 = a17;
            AppThemeManager_Factory a18 = AppThemeManager_Factory.a(this.f20459j, this.f20469k0, a17);
            this.f20487m0 = a18;
            this.f20496n0 = SettingsInteractor_Factory.a(this.f20459j, this.f20477l, this.V, this.f20424f0, this.f20433g0, this.f20442h0, this.f20451i0, this.f20379a0, this.W, this.Y, this.f20450i, this.f20460j0, a18, this.Q);
            this.f20505o0 = MagicLinkInteractor_Factory.a(this.X, this.f20397c0);
            this.f20514p0 = new LoginAnalyticsV2Provider(applicationComponent);
            this.f20523q0 = AppResolver_Factory.a(this.f20459j, this.f20513p);
            this.f20532r0 = ChromeCustomTabsUrlLauncher_Factory.a(this.f20459j);
            SystemUrlLauncher_Factory a19 = SystemUrlLauncher_Factory.a(this.f20459j);
            this.f20540s0 = a19;
            this.f20548t0 = CompositeUrlLauncher_Factory.a(this.f20532r0, a19);
            ChromeUrlLauncher_Factory a20 = ChromeUrlLauncher_Factory.a(this.f20459j);
            this.f20556u0 = a20;
            this.f20564v0 = CompositeChromeFirstUrlLauncher_Factory.a(this.f20540s0, a20);
            SupportApiProvider supportApiProvider = new SupportApiProvider(applicationComponent);
            this.f20572w0 = supportApiProvider;
            this.f20580x0 = SupportClient_Factory.a(supportApiProvider, this.E);
            AuthManagerProvider authManagerProvider = new AuthManagerProvider(applicationComponent);
            this.f20588y0 = authManagerProvider;
            this.f20596z0 = SettingsViewModel_Factory.a(this.f20496n0, this.f20477l, this.f20505o0, this.X, this.S, this.f20514p0, this.f20523q0, this.f20548t0, this.f20564v0, this.f20580x0, authManagerProvider, this.f20487m0);
            this.A0 = NavigationSettingsTbtViewModel_Factory.a(this.f20477l, this.f20513p, this.f20433g0);
            this.B0 = new IoDispatcherProvider(applicationComponent);
            Provider<DriverNavigationConfigurationApi> provider2 = DoubleCheck.provider(AuthorisedNetworkModule_ProvideDriverNavigationConfigurationApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.C0 = provider2;
            DriverNavigationConfigurationClient_Factory a21 = DriverNavigationConfigurationClient_Factory.a(this.B0, provider2);
            this.D0 = a21;
            NavigationOptionsInteractor_Factory a22 = NavigationOptionsInteractor_Factory.a(a21, this.f20523q0, DynamicNavigationMapper_Factory.a());
            this.E0 = a22;
            this.F0 = NavigatorChooserViewModel_Factory.a(this.f20433g0, this.f20513p, this.f20477l, this.Q, a22, this.f20523q0);
            this.G0 = new OrderProviderProvider(applicationComponent);
            Provider<PriceReviewApi> provider3 = DoubleCheck.provider(AuthorisedNetworkModule_ProvidesPriceReviewApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.H0 = provider3;
            PriceReviewClient_Factory a23 = PriceReviewClient_Factory.a(provider3, this.J);
            this.I0 = a23;
            this.J0 = ChoosePriceReviewViewModel_Factory.a(this.G0, a23);
            this.K0 = new ChatAnalyticsProvider(applicationComponent);
            ContactApiProvider contactApiProvider = new ContactApiProvider(applicationComponent);
            this.L0 = contactApiProvider;
            this.M0 = ContactClient_Factory.a(contactApiProvider, this.J);
            this.N0 = DoubleCheck.provider(VoipCache_Factory.a());
            VoipLifecycleProvider voipLifecycleProvider = new VoipLifecycleProvider(applicationComponent);
            this.O0 = voipLifecycleProvider;
            VoipOrderInformationDelegate_Factory a24 = VoipOrderInformationDelegate_Factory.a(this.N0, this.G0, voipLifecycleProvider);
            this.P0 = a24;
            ContactOptionsDelegate_Factory a25 = ContactOptionsDelegate_Factory.a(this.M0, a24);
            this.Q0 = a25;
            ChatDelegate_Factory a26 = ChatDelegate_Factory.a(a25, ChatMessageMapper_Factory.a());
            this.R0 = a26;
            this.S0 = ContactOptionsInteractor_Factory.a(a26, this.Q0);
            this.T0 = new VoipProvider(applicationComponent);
            Provider<VoipApi> provider4 = DoubleCheck.provider(AuthorisedNetworkModule_ProvideVoipApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.U0 = provider4;
            VoipClient_Factory a27 = VoipClient_Factory.a(provider4, this.E);
            this.V0 = a27;
            VoipCallDelegate_Factory a28 = VoipCallDelegate_Factory.a(this.T0, a27, this.M0, this.N0);
            this.W0 = a28;
            CallToRiderInteractor_Factory a29 = CallToRiderInteractor_Factory.a(a28);
            this.X0 = a29;
            this.Y0 = ContactOptionsViewModel_Factory.a(this.K0, this.S0, a29);
            DestinationsProvider destinationsProvider = new DestinationsProvider(applicationComponent);
            this.Z0 = destinationsProvider;
            this.f20380a1 = DestinationLimitInteractor_Factory.a(destinationsProvider);
            this.f20389b1 = SavedDestinationsInteractor_Factory.a(this.Z0);
            this.f20398c1 = ActiveDestinationInteractor_Factory.a(this.Z0);
            this.f20407d1 = SelectDestinationInteractor_Factory.a(this.Z0);
        }

        private void U(AuthorisedCoreModule authorisedCoreModule, AuthorisedNetworkModule authorisedNetworkModule, AuthorisedServicesModule authorisedServicesModule, AuthorisedStaffModule authorisedStaffModule, AuthorisedUiModule authorisedUiModule, ThemeModule themeModule, DriverChatAuthorisedModule driverChatAuthorisedModule, StoriesModule storiesModule, PollerModule pollerModule, TripAudioRecordingModule tripAudioRecordingModule, ApplicationComponent applicationComponent, DriverConfig driverConfig, DriverSettings driverSettings, DriverFeatures driverFeatures, AnchoredTimeSource anchoredTimeSource) {
            this.f20416e1 = DeactivateDestinationInteractor_Factory.a(this.Z0);
            this.f20425f1 = DeleteDestinationInteractor_Factory.a(this.Z0);
            LocationManagerProvider locationManagerProvider = new LocationManagerProvider(applicationComponent);
            this.f20434g1 = locationManagerProvider;
            this.f20443h1 = DestinationsViewModel_Factory.a(this.f20380a1, this.f20389b1, this.f20398c1, this.f20407d1, this.f20416e1, this.f20425f1, locationManagerProvider, DestinationMapper_Factory.a(), this.f20477l);
            DriverActivityInteractor_Factory a8 = DriverActivityInteractor_Factory.a(this.U);
            this.f20452i1 = a8;
            this.f20461j1 = DriverActivityViewModel_Factory.a(a8, this.f20477l);
            OrderClient_Factory a9 = OrderClient_Factory.a(this.I, this.J, this.E);
            this.f20470k1 = a9;
            this.f20479l1 = DrivePriceInteractor_Factory.a(this.G0, a9);
            this.f20488m1 = new OrderStateManagerProvider(applicationComponent);
            this.f20497n1 = new DriverJourneyTraceProvider(applicationComponent);
            this.f20506o1 = new OrderFlowAnalyticsProvider(applicationComponent);
            this.f20515p1 = new OrderStateProvider(applicationComponent);
            this.f20524q1 = new NotRespondReporterProvider(applicationComponent);
            ReporterProvider reporterProvider = new ReporterProvider(applicationComponent);
            this.f20533r1 = reporterProvider;
            this.f20541s1 = OrderTracker_Factory.a(this.f20497n1, this.f20506o1, this.f20522q, this.f20515p1, this.f20524q1, reporterProvider);
            this.f20549t1 = RateMePrefsManager_Factory.a(this.f20477l);
            Provider<RideHistoryApi> provider = DoubleCheck.provider(AuthorisedNetworkModule_ProvidesRideHistoryApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.f20557u1 = provider;
            RideHistoryClient_Factory a10 = RideHistoryClient_Factory.a(provider, this.J);
            this.f20565v1 = a10;
            OrderHistoryManager_Factory a11 = OrderHistoryManager_Factory.a(a10);
            this.f20573w1 = a11;
            this.f20581x1 = DoubleCheck.provider(AppRatingManager_Factory.a(this.f20549t1, this.K, this.Z0, this.f20434g1, this.f20451i0, a11));
            NetworkProvider networkProvider = new NetworkProvider(applicationComponent);
            this.f20589y1 = networkProvider;
            this.f20597z1 = InternetDataDelegate_Factory.a(networkProvider);
            this.A1 = ConnectionMessageManager_Factory.a(this.f20589y1);
            Provider<PollMessageCache> provider2 = DoubleCheck.provider(PollMessageCache_Factory.a());
            this.B1 = provider2;
            PollMessageManager_Factory a12 = PollMessageManager_Factory.a(provider2);
            this.C1 = a12;
            this.D1 = AuthorizedWarningInteractor_Factory.a(this.A1, a12, this.f20477l);
            this.E1 = new SafetyToolkitAnalyticsProvider(applicationComponent);
            Provider<EmergencyAssistApi> provider3 = DoubleCheck.provider(AuthorisedNetworkModule_ProvideEmergencyAssistApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.F1 = provider3;
            this.G1 = EmergencyAssistClient_Factory.a(provider3);
            Provider<CarApplicationApi> provider4 = DoubleCheck.provider(AuthorisedNetworkModule_ProvideCarApplicationApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.H1 = provider4;
            CarApplicationClient_Factory a13 = CarApplicationClient_Factory.a(provider4);
            this.I1 = a13;
            Provider<EmergencyAssistManager> provider5 = DoubleCheck.provider(EmergencyAssistManager_Factory.a(this.G1, a13, this.f20434g1, this.f20477l, this.G0, this.R));
            this.J1 = provider5;
            this.K1 = EmergencyAssistInteractor_Factory.a(provider5);
            this.L1 = DidYouGetHelpInteractor_Factory.a(this.J1);
            TripAudioRecordingModule_ProvideAudioRecordingAPIFactory a14 = TripAudioRecordingModule_ProvideAudioRecordingAPIFactory.a(tripAudioRecordingModule, this.f20459j);
            this.M1 = a14;
            this.N1 = DoubleCheck.provider(AudioRecordingManager_Factory.a(a14, this.B0, AudioRecordingMapper_Factory.a()));
            this.O1 = DoubleCheck.provider(OrderTryAgainManager_Factory.a());
            Provider<DriverOrderApi> provider6 = DoubleCheck.provider(AuthorisedNetworkModule_ProvideDriverOrderApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.P1 = provider6;
            this.Q1 = DriverOrderClient_Factory.a(this.B0, provider6);
            this.R1 = new OrdersProvider(applicationComponent);
            this.S1 = new DateTimeProviderProvider(applicationComponent);
            Provider<OrderManager> provider7 = DoubleCheck.provider(OrderManager_Factory.a(ScopeProvider_Factory.a(), DispatcherProvider_Factory.a(), this.f20470k1, this.Q1, this.R1, this.S1, this.O1));
            this.T1 = provider7;
            this.U1 = DrivePriceViewModel_Factory.a(this.f20479l1, this.f20477l, this.f20488m1, this.f20541s1, this.f20581x1, this.f20597z1, this.D1, this.E1, this.K1, this.L1, this.R, this.N1, this.O1, provider7);
            Provider<EarningsApi> provider8 = DoubleCheck.provider(AuthorisedNetworkModule_ProvidesInvoicingApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.V1 = provider8;
            EarningsClient_Factory a15 = EarningsClient_Factory.a(provider8, this.J);
            this.W1 = a15;
            this.X1 = EarningsInteractor_Factory.a(a15);
            Provider<PayoutApi> provider9 = DoubleCheck.provider(AuthorisedNetworkModule_ProvidesPayoutApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.Y1 = provider9;
            PayoutClient_Factory a16 = PayoutClient_Factory.a(provider9, this.J);
            this.Z1 = a16;
            this.f20381a2 = PayToBoltLinkInteractor_Factory.a(a16);
            this.f20390b2 = PayoutPayToBoltInfoInteractor_Factory.a(this.Z1);
            this.f20399c2 = new PayoutAnalyticsProvider(applicationComponent);
            ReportPageInteractor_Factory a17 = ReportPageInteractor_Factory.a(this.W1, ReportItemsMapper_Factory.a(), ChartMapper_Factory.a());
            this.f20408d2 = a17;
            Provider<EarningsInteractor> provider10 = this.X1;
            Provider<PayToBoltLinkInteractor> provider11 = this.f20381a2;
            Provider<PayoutPayToBoltInfoInteractor> provider12 = this.f20390b2;
            Provider<AnalyticsImpl> provider13 = this.f20522q;
            this.f20417e2 = EarningsViewModel_Factory.a(provider10, provider11, provider12, provider13, provider13, this.f20399c2, this.W1, this.R, a17, this.Q);
            this.f20426f2 = DistinctDriverStateInteractor_Factory.a(this.f20451i0);
            this.f20435g2 = new PollerProvider(applicationComponent);
            BackgroundManagerProvider backgroundManagerProvider = new BackgroundManagerProvider(applicationComponent);
            this.f20444h2 = backgroundManagerProvider;
            this.f20453i2 = DoubleCheck.provider(PollerManager_Factory.a(this.U, this.R1, backgroundManagerProvider, this.f20477l, this.f20434g1));
            this.f20462j2 = new DriverStatusSenderProvider(applicationComponent);
            this.f20471k2 = DoubleCheck.provider(DynamicPollingService_Factory.a(this.f20453i2, PollingRetryStrategy_Factory.a(), this.f20462j2));
            Provider<FixedPollingService> provider14 = DoubleCheck.provider(FixedPollingService_Factory.a(this.f20453i2, PollingRetryStrategy_Factory.a(), this.f20462j2));
            this.f20480l2 = provider14;
            PollerModule_ProvidePollerDataSourceFactory a18 = PollerModule_ProvidePollerDataSourceFactory.a(pollerModule, this.Q, this.f20435g2, this.f20471k2, provider14);
            this.f20489m2 = a18;
            this.f20498n2 = OnlineCheckInteractor_Factory.a(a18);
            this.f20507o2 = MakeDriverInactiveInteractor_Factory.a(this.f20451i0, this.Y, this.f20477l, this.Z0, this.P, this.f20581x1);
            PushNotificationsProvider pushNotificationsProvider = new PushNotificationsProvider(applicationComponent);
            this.f20516p2 = pushNotificationsProvider;
            this.f20525q2 = PushDataService_Factory.a(pushNotificationsProvider);
            Provider<ModalApi> provider15 = DoubleCheck.provider(AuthorisedNetworkModule_ProvidesModalApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.f20534r2 = provider15;
            ModalClient_Factory a19 = ModalClient_Factory.a(provider15);
            this.f20542s2 = a19;
            this.f20550t2 = SingleModalDialogInteractor_Factory.a(a19, this.f20468k);
            this.f20558u2 = new ChatProvider(applicationComponent);
            TokenProviderProvider tokenProviderProvider = new TokenProviderProvider(applicationComponent);
            this.f20566v2 = tokenProviderProvider;
            this.f20574w2 = DoubleCheck.provider(ContactOptionsService_Factory.a(this.M0, this.f20468k, this.T0, this.f20513p, this.f20558u2, tokenProviderProvider));
            this.f20582x2 = new PermissionManagerProvider(applicationComponent);
            this.f20590y2 = DoubleCheck.provider(DriverSettingsInMemory_Factory.a());
            Provider<DriverScoreApi> provider16 = DoubleCheck.provider(AuthorisedNetworkModule_ProvidesDriverScoreApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.f20598z2 = provider16;
            DriverScoreClient_Factory a20 = DriverScoreClient_Factory.a(provider16, this.E);
            this.A2 = a20;
            this.B2 = DoubleCheck.provider(DriverScoreManager_Factory.a(a20, this.f20477l, this.f20522q));
            Provider<TrainingApi> provider17 = DoubleCheck.provider(AuthorisedNetworkModule_ProvidesTrainingApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.C2 = provider17;
            TrainingClient_Factory a21 = TrainingClient_Factory.a(provider17);
            this.D2 = a21;
            this.E2 = HomePromoDialogInteractor_Factory.a(this.f20477l, this.f20550t2, this.f20450i, this.f20460j0, this.f20574w2, this.f20582x2, this.f20590y2, this.B2, a21);
            this.F2 = DashboardClient_Factory.a(this.I, this.E);
            this.G2 = DoubleCheck.provider(DashboardService_Factory.a(PollingRetryStrategy_Factory.a(), this.F2));
            this.H2 = BackendModalDialogActionReporterInteractor_Factory.a(this.f20542s2);
            this.I2 = DriverStateChangeFailInteractor_Factory.a(this.Y, this.U);
            this.J2 = new DriverTrainingRestrictionManagerProvider(applicationComponent);
            this.K2 = new AppPerformanceAnalyticsProvider(applicationComponent);
            Provider<NetworkUsageManager> provider18 = DoubleCheck.provider(NetworkUsageManager_Factory.a());
            this.L2 = provider18;
            this.M2 = NetworkUsageUploadInteractor_Factory.a(this.f20477l, this.f20379a0, this.K2, provider18, this.S1);
            this.N2 = HomeViewModel_Factory.a(this.f20426f2, this.f20498n2, this.f20507o2, this.f20525q2, this.f20581x1, this.G0, this.f20488m1, this.Y, this.f20477l, this.f20548t0, DeepLinkParser_Factory.a(), this.E2, this.D1, this.G2, this.H2, this.f20522q, this.I2, this.D2, this.J2, this.S, this.M2, this.f20450i);
            this.O2 = IncomingOrderInteractor_Factory.a(this.G0, this.Z0, this.f20434g1);
            Provider<GeoApi> provider19 = DoubleCheck.provider(AuthorisedNetworkModule_ProvidesGeoApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.P2 = provider19;
            GeoClient_Factory a22 = GeoClient_Factory.a(provider19, this.f20477l, this.J);
            this.Q2 = a22;
            RouteManager_Factory a23 = RouteManager_Factory.a(a22);
            this.R2 = a23;
            IncomingOrderRouteInteractor_Factory a24 = IncomingOrderRouteInteractor_Factory.a(a23);
            this.S2 = a24;
            this.T2 = IncomingOrderViewModel_Factory.a(this.O2, a24, this.f20488m1, this.f20487m0, this.f20549t1, this.S1, this.Q);
            InprogressCallInteractor_Factory a25 = InprogressCallInteractor_Factory.a(this.T0, this.O0, this.P0);
            this.U2 = a25;
            this.V2 = InprogressCallViewModel_Factory.a(a25);
            this.W2 = new StartUpTracingProvider(applicationComponent);
            this.X2 = GetDashboardInteractor_Factory.a(this.G2);
            this.Y2 = new CampaignAnalyticsProvider(applicationComponent);
            this.Z2 = DoubleCheck.provider(WorkDistanceDelegate_Factory.a(this.f20477l, this.f20489m2, this.U));
        }

        private void V(AuthorisedCoreModule authorisedCoreModule, AuthorisedNetworkModule authorisedNetworkModule, AuthorisedServicesModule authorisedServicesModule, AuthorisedStaffModule authorisedStaffModule, AuthorisedUiModule authorisedUiModule, ThemeModule themeModule, DriverChatAuthorisedModule driverChatAuthorisedModule, StoriesModule storiesModule, PollerModule pollerModule, TripAudioRecordingModule tripAudioRecordingModule, ApplicationComponent applicationComponent, DriverConfig driverConfig, DriverSettings driverSettings, DriverFeatures driverFeatures, AnchoredTimeSource anchoredTimeSource) {
            this.f20382a3 = new LocationCleanerProvider(applicationComponent);
            this.f20391b3 = new ReferralCampaignsAnalyticsProvider(applicationComponent);
            Provider<FifoQueueManager> provider = DoubleCheck.provider(FifoQueueManager_Factory.a(this.Q, this.f20470k1));
            this.f20400c3 = provider;
            this.f20409d3 = FifoModalInteractor_Factory.a(provider, this.f20550t2);
            this.f20418e3 = new AdvertiserIdProviderProvider(applicationComponent);
            AttributionProvider attributionProvider = new AttributionProvider(applicationComponent);
            this.f20427f3 = attributionProvider;
            this.f20436g3 = AttributedAnalyticsDelegate_Factory.a(this.f20522q, this.f20418e3, attributionProvider);
            this.f20445h3 = DriverButtonMapper_Factory.a(DriverButtonSizeMapper_Factory.a(), DriverButtonAppearanceMapper_Factory.a());
            this.f20454i3 = DriverImageMapper_Factory.a(DriverNormalImageMapper_Factory.a(), DriverTintableImageMapper_Factory.a());
            this.f20463j3 = new HtmlEngineProvider(applicationComponent);
            this.f20472k3 = FifoQueueStateMapper_Factory.a(this.f20445h3, this.f20454i3, DriverLottieMapper_Factory.a(), this.f20463j3);
            this.f20481l3 = new DeepLinkManagerProvider(applicationComponent);
            this.f20490m3 = DeeplinkDelegate_Factory.a(DeepLinkParser_Factory.a(), this.f20481l3, this.f20548t0, this.f20469k0);
            this.f20499n3 = WorkRadiusInteractor_Factory.a(this.f20477l, this.Z2, this.Z0, this.f20400c3);
            Provider<HeatmapSettingManager> provider2 = DoubleCheck.provider(HeatmapSettingManager_Factory.a(this.R));
            this.f20508o3 = provider2;
            this.f20517p3 = HeatmapOptionProvider_Factory.a(provider2);
            Provider<MapsConfigsService> provider3 = DoubleCheck.provider(MapsConfigsService_Factory.a(PollingRetryStrategy_Factory.a(), this.U, this.f20451i0, this.Q));
            this.f20526q3 = provider3;
            this.f20535r3 = GetHeatmapStatusInteractor_Factory.a(this.f20517p3, provider3, this.f20454i3, this.Q);
            this.f20543s3 = new PermissionAnalyticsProvider(applicationComponent);
            Provider<DriverClient> provider4 = this.U;
            Provider<OrderTracker> provider5 = this.f20541s1;
            Provider<CircleKClient> provider6 = this.F;
            Provider<DriverManager> provider7 = this.Y;
            Provider<DriverProvider> provider8 = this.f20477l;
            Provider<DriverSettings> provider9 = this.R;
            Provider<CampaignClient> provider10 = this.K;
            Provider<LoginAnalytics> provider11 = this.f20514p0;
            Provider<StartUpTracing> provider12 = this.W2;
            Provider<CampaignManager> provider13 = this.L;
            Provider<GetDashboardInteractor> provider14 = this.X2;
            DashboardMapper_Factory a8 = DashboardMapper_Factory.a();
            Provider<CampaignAnalytics> provider15 = this.Y2;
            Provider<SettingsAnalytics> provider16 = this.S;
            Provider<DriverScoreManager> provider17 = this.B2;
            Provider<DriverStatusSender> provider18 = this.f20462j2;
            Provider<GeoLocationManager> provider19 = this.f20434g1;
            Provider<RateMePrefsManager> provider20 = this.f20549t1;
            Provider<WorkingTimeManager> provider21 = this.f20424f0;
            Provider<WorkDistanceDelegate> provider22 = this.Z2;
            Provider<AnalyticsImpl> provider23 = this.f20522q;
            this.f20551t3 = WorkViewModel_Factory.a(provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, a8, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, this.f20451i0, this.f20382a3, this.M, provider23, this.f20450i, this.Z0, this.f20391b3, this.E1, this.f20550t2, this.f20409d3, this.f20436g3, this.H2, this.f20400c3, this.f20472k3, this.f20490m3, provider23, this.L1, this.K1, this.f20499n3, this.N1, this.f20535r3, this.f20543s3);
            NoAnswerInteractor_Factory a9 = NoAnswerInteractor_Factory.a(this.T0, this.O0, this.P0);
            this.f20559u3 = a9;
            this.f20567v3 = NoAnswerViewModel_Factory.a(a9);
            Provider<UpcomingStopDistanceService> provider24 = DoubleCheck.provider(UpcomingStopDistanceService_Factory.a(this.f20434g1, this.G0));
            this.f20575w3 = provider24;
            this.f20583x3 = OrderDistanceInteractor_Factory.a(provider24);
            this.f20591y3 = DoubleCheck.provider(AutoReminderImpl_Factory.a(this.f20575w3));
            this.f20599z3 = BottomSheetStateInteractor_Factory.a(this.G0, this.f20434g1);
            RouteProvider_Factory a10 = RouteProvider_Factory.a(this.f20477l, this.S1, this.Q2);
            this.A3 = a10;
            this.B3 = MapDataInteractor_Factory.a(this.f20434g1, this.G0, a10);
            this.C3 = DriverInteractor_Factory.a(this.f20477l, this.f20433g0);
            this.D3 = DoubleCheck.provider(B2bManager_Factory.a(this.U, this.f20522q, this.S1, this.Q1));
            Factory create = InstanceFactory.create(anchoredTimeSource);
            this.E3 = create;
            this.F3 = OrderStateDataInteractor_Factory.a(this.f20459j, this.G0, this.f20477l, this.Z0, this.Q, this.f20468k, this.D3, this.f20575w3, create, this.f20433g0);
            this.G3 = new NavigationProvider(applicationComponent);
            LocationTransmitterProvider locationTransmitterProvider = new LocationTransmitterProvider(applicationComponent);
            this.H3 = locationTransmitterProvider;
            this.I3 = PriceInteractor_Factory.a(locationTransmitterProvider, this.f20470k1);
            this.J3 = PaidStopsStateInteractor_Factory.a(this.f20575w3, this.f20468k);
            this.K3 = ActiveRideDeeplinkInteractor_Factory.a(this.f20481l3);
            this.L3 = AutoAcceptedOrderInteractor_Factory.a(this.G0);
            NoAnswerIncomingCallCacheProvider noAnswerIncomingCallCacheProvider = new NoAnswerIncomingCallCacheProvider(applicationComponent);
            this.M3 = noAnswerIncomingCallCacheProvider;
            this.N3 = NoAnswerIncomingCallInteractor_Factory.a(this.G0, noAnswerIncomingCallCacheProvider);
            Provider<RouteSharingApi> provider25 = DoubleCheck.provider(AuthorisedNetworkModule_ProvideRouteSharingApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.O3 = provider25;
            RouteSharingClient_Factory a11 = RouteSharingClient_Factory.a(provider25);
            this.P3 = a11;
            this.Q3 = RouteSharingInteractor_Factory.a(a11, this.f20459j);
            this.R3 = new ChatManagerProvider(applicationComponent);
            this.S3 = ChatActiveOrderSource_Factory.a(this.G0);
            DeviceInfoSenderProvider deviceInfoSenderProvider = new DeviceInfoSenderProvider(applicationComponent);
            this.T3 = deviceInfoSenderProvider;
            this.U3 = OrderViewModel_Factory.a(this.f20583x3, this.f20591y3, this.f20599z3, this.B3, this.C3, this.F3, this.G3, this.f20488m1, this.D3, this.I3, this.K0, this.E1, this.f20597z1, this.f20433g0, this.f20525q2, this.f20477l, this.R, this.J3, this.K3, this.L3, this.N3, this.D1, this.f20541s1, this.f20549t1, this.f20487m0, this.Q3, this.L1, this.K1, this.f20434g1, this.f20463j3, this.R3, this.S3, this.O1, this.T1, deviceInfoSenderProvider, this.N1);
            PayoutHistoryInteractor_Factory a12 = PayoutHistoryInteractor_Factory.a(this.Z1);
            this.V3 = a12;
            this.W3 = PayoutHistoryViewModel_Factory.a(a12, this.f20399c2);
            Provider<StoriesApi> provider26 = DoubleCheck.provider(AuthorisedNetworkModule_ProvidesStoriesApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.X3 = provider26;
            StoriesClient_Factory a13 = StoriesClient_Factory.a(provider26);
            this.Y3 = a13;
            this.Z3 = StorySetViewModel_Factory.a(a13);
            this.f20383a4 = PayoutInfoInteractor_Factory.a(this.Z1);
            ConfirmPayoutInteractor_Factory a14 = ConfirmPayoutInteractor_Factory.a(this.Z1);
            this.f20392b4 = a14;
            this.f20401c4 = PayoutRequestViewModel_Factory.a(this.f20383a4, a14, this.f20399c2);
            this.f20410d4 = DriverPriorityClient_Factory.a(this.I, this.E);
            DriverPriorityMapper_Factory a15 = DriverPriorityMapper_Factory.a(InformationMessageMapper_Factory.a(), SimpleTextMapper_Factory.a());
            this.f20419e4 = a15;
            this.f20428f4 = DriverPriorityViewModel_Factory.a(this.f20410d4, a15, this.f20548t0);
            PayoutDetailsInteractor_Factory a16 = PayoutDetailsInteractor_Factory.a(this.Z1);
            this.f20437g4 = a16;
            this.f20446h4 = PayoutDetailsViewModel_Factory.a(a16, this.f20548t0, this.f20399c2);
            this.f20455i4 = InfoWebViewModel_Factory.a(this.f20548t0);
            Provider<EarningsPaymentApi> provider27 = DoubleCheck.provider(AuthorisedNetworkModule_ProvidePaymentsApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.f20464j4 = provider27;
            EarningsPaymentClient_Factory a17 = EarningsPaymentClient_Factory.a(provider27, this.J);
            this.f20473k4 = a17;
            this.f20482l4 = PayToBoltViewModel_Factory.a(a17, this.B, this.f20399c2);
            QaAnalyticsProvider qaAnalyticsProvider = new QaAnalyticsProvider(applicationComponent);
            this.f20491m4 = qaAnalyticsProvider;
            this.f20500n4 = QuickAccessSettingsViewModel_Factory.a(this.f20477l, this.f20468k, qaAnalyticsProvider);
            RateCallInteractor_Factory a18 = RateCallInteractor_Factory.a(this.V0);
            this.f20509o4 = a18;
            this.f20518p4 = RateCallViewModel_Factory.a(a18);
            ReportsProvider reportsProvider = new ReportsProvider(applicationComponent);
            this.f20527q4 = reportsProvider;
            this.f20536r4 = SosDialogViewModel_Factory.a(this.S1, reportsProvider, this.f20477l, this.f20506o1);
            VoipCallErrorDelegate_Factory a19 = VoipCallErrorDelegate_Factory.a(this.Q0, this.P0, this.N0);
            this.f20544s4 = a19;
            VoipCallErrorInteractor_Factory a20 = VoipCallErrorInteractor_Factory.a(this.Q0, a19);
            this.f20552t4 = a20;
            this.f20560u4 = VoipCallErrorViewModel_Factory.a(a20, this.X0);
            Provider<ScheduledOrderProvider> provider28 = DoubleCheck.provider(ScheduledOrderProvider_Factory.a());
            this.f20568v4 = provider28;
            ScheduledOrderManager_Factory a21 = ScheduledOrderManager_Factory.a(this.f20470k1, provider28, this.Y, this.f20469k0);
            this.f20576w4 = a21;
            this.f20584x4 = TripCancellationViewModel_Factory.a(this.f20488m1, this.G0, this.f20506o1, a21, this.f20463j3, this.f20549t1);
            this.f20592y4 = DriverAreaInteractor_Factory.a(this.f20477l, this.Z0, this.Z2, this.f20400c3, this.f20434g1);
            Provider<SearchApi> provider29 = DoubleCheck.provider(AuthorisedNetworkModule_ProvidesSearchApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.f20600z4 = provider29;
            SearchClient_Factory a22 = SearchClient_Factory.a(provider29, this.J);
            this.A4 = a22;
            Provider<OtherDriversManager> provider30 = DoubleCheck.provider(OtherDriversManager_Factory.a(a22));
            this.B4 = provider30;
            UpdateOtherDriversService_Factory a23 = UpdateOtherDriversService_Factory.a(provider30, this.P, this.Q);
            this.C4 = a23;
            this.D4 = NearbyDriversInteractor_Factory.a(a23, this.B4, this.f20477l);
            this.E4 = DriverStateInteractor_Factory.a(this.f20451i0);
            this.F4 = FifoQueueMapInteractor_Factory.a(this.f20526q3, this.f20400c3);
            this.G4 = SurgeInteractor_Factory.a(this.P, this.f20450i, this.Q);
            HeatmapConfigProvider_Factory a24 = HeatmapConfigProvider_Factory.a(this.f20508o3);
            this.H4 = a24;
            GetHeatmapInteractor_Factory a25 = GetHeatmapInteractor_Factory.a(this.Q, this.G4, a24);
            this.I4 = a25;
            this.J4 = WorkMapViewModel_Factory.a(this.f20592y4, this.D4, this.E4, this.f20400c3, this.F4, a25, this.f20487m0, this.L);
            WorkTimeInteractor_Factory a26 = WorkTimeInteractor_Factory.a(this.f20424f0);
            this.K4 = a26;
            this.L4 = WorkTimeViewModel_Factory.a(a26, this.f20477l);
            TimedAnalyticsProvider timedAnalyticsProvider = new TimedAnalyticsProvider(applicationComponent);
            this.M4 = timedAnalyticsProvider;
            this.N4 = TimedAnalyticsImpl_Factory.a(timedAnalyticsProvider);
            this.O4 = RateMeCategoryViewModel_Factory.a(RateMeFetchCategoriesInteractor_Factory.a(), this.f20522q, this.N4);
            this.P4 = SupportViewModel_Factory.a(this.B, this.f20468k, this.f20580x0);
            HistoryAnalyticsProvider historyAnalyticsProvider = new HistoryAnalyticsProvider(applicationComponent);
            this.Q4 = historyAnalyticsProvider;
            this.R4 = OrderListViewModel_Factory.a(this.f20573w1, this.f20549t1, historyAnalyticsProvider, this.Y);
            this.S4 = InstanceFactory.create(driverConfig);
            CleverTapProvider cleverTapProvider = new CleverTapProvider(applicationComponent);
            this.T4 = cleverTapProvider;
            this.U4 = InboxItemsInteractor_Factory.a(this.L, this.S4, cleverTapProvider, this.Y3);
            this.V4 = new NewsAnalyticsProvider(applicationComponent);
        }

        private void W(AuthorisedCoreModule authorisedCoreModule, AuthorisedNetworkModule authorisedNetworkModule, AuthorisedServicesModule authorisedServicesModule, AuthorisedStaffModule authorisedStaffModule, AuthorisedUiModule authorisedUiModule, ThemeModule themeModule, DriverChatAuthorisedModule driverChatAuthorisedModule, StoriesModule storiesModule, PollerModule pollerModule, TripAudioRecordingModule tripAudioRecordingModule, ApplicationComponent applicationComponent, DriverConfig driverConfig, DriverSettings driverSettings, DriverFeatures driverFeatures, AnchoredTimeSource anchoredTimeSource) {
            PartnerOffersAnalyticsProvider partnerOffersAnalyticsProvider = new PartnerOffersAnalyticsProvider(applicationComponent);
            this.W4 = partnerOffersAnalyticsProvider;
            this.X4 = InboxViewModel_Factory.a(this.U4, this.V4, this.T4, partnerOffersAnalyticsProvider);
            this.Y4 = DriverScoreMapper_Factory.a(InformationMessageMapper_Factory.a());
            DriverScoreTooltipFactory_Factory a8 = DriverScoreTooltipFactory_Factory.a(InformationMessageMapper_Factory.a());
            this.Z4 = a8;
            this.f20384a5 = DriverScoreViewModel_Factory.a(this.A2, this.Y4, a8, this.f20522q);
            this.f20393b5 = DriverScoreExplanationViewModel_Factory.a(this.A2, this.f20522q, this.B);
            this.f20402c5 = CallBackViewModel_Factory.a(this.W0);
            Provider<DriverPricingConfigurationApi> provider = DoubleCheck.provider(AuthorisedNetworkModule_ProvideDriverPricingConfigurationApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.f20411d5 = provider;
            DriverPricingConfigurationClient_Factory a9 = DriverPricingConfigurationClient_Factory.a(provider);
            this.f20420e5 = a9;
            this.f20429f5 = PricingSettingsViewModel_Factory.a(a9, this.f20450i, this.f20477l, this.f20522q);
            DriverPortalTokenInteractor_Factory a10 = DriverPortalTokenInteractor_Factory.a(this.f20397c0);
            this.f20438g5 = a10;
            this.f20447h5 = VehicleListViewModel_Factory.a(a10, this.X, this.Y, this.f20477l, this.U, this.I1);
            this.f20456i5 = DriverAppDisabledViewModel_Factory.a(this.f20434g1, this.f20516p2, this.f20580x0);
            this.f20465j5 = GetLanguageSettingsInteractor_Factory.a(this.W);
            TranslationManagerProvider translationManagerProvider = new TranslationManagerProvider(applicationComponent);
            this.f20474k5 = translationManagerProvider;
            SetLanguageInteractor_Factory a11 = SetLanguageInteractor_Factory.a(this.W, translationManagerProvider, this.U, this.N, this.f20469k0);
            this.f20483l5 = a11;
            this.f20492m5 = LanguageSettingsViewModel_Factory.a(this.f20465j5, a11);
            this.f20501n5 = new DateTimeFormatterProvider(applicationComponent);
            this.f20510o5 = TripAudioSupportClient_Factory.a(this.f20539s);
            Provider<AudioRecordingNetworkAPI> provider2 = DoubleCheck.provider(AuthorisedNetworkModule_ProvideAudioRecordingNetworkApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.f20519p5 = provider2;
            this.f20528q5 = AudioRecordingClient_Factory.a(this.B0, provider2);
            UploadApiProvider uploadApiProvider = new UploadApiProvider(applicationComponent);
            this.f20537r5 = uploadApiProvider;
            this.f20545s5 = AudioRecordingUploadClient_Factory.a(uploadApiProvider);
            this.f20553t5 = UploadAudioRecordingManager_Factory.a(this.f20459j, this.N1, AudioRecordingMapper_Factory.a(), this.f20528q5, this.f20545s5, this.B0);
            this.f20561u5 = new AudioRecordingAnalyticsProvider(applicationComponent);
            this.f20569v5 = OrderHistoryDetailsViewModel_Factory.a(this.N1, AudioRecordingMapper_Factory.a(), this.f20501n5, this.f20477l, this.Q4, this.M0, this.f20565v1, this.f20580x0, this.S1, this.f20510o5, this.f20553t5, this.f20561u5);
            this.f20577w5 = CampaignFactory_Factory.a(this.f20463j3);
            FutureCampaignFactory_Factory a12 = FutureCampaignFactory_Factory.a(this.f20463j3);
            this.f20585x5 = a12;
            this.f20593y5 = ActiveCampaignsViewModel_Factory.a(this.F, this.K, this.L, this.f20442h0, this.S4, this.Y2, this.M, this.f20577w5, a12, this.f20391b3);
            this.f20601z5 = PastCampaignsViewModel_Factory.a(this.K, this.Y2, this.f20577w5);
            this.A5 = CampaignDetailsViewModel_Factory.a(this.K, this.Y2);
            ReferralCampaignInvitationFactory_Factory a13 = ReferralCampaignInvitationFactory_Factory.a(this.N);
            this.B5 = a13;
            ReferralCampaignMapper_Factory a14 = ReferralCampaignMapper_Factory.a(this.S1, this.S4, a13, this.N, this.f20463j3);
            this.C5 = a14;
            this.D5 = ReferralCampaignDetailsViewModel_Factory.a(this.K, this.f20391b3, a14);
            this.E5 = OptInChoiceViewModel_Factory.a(this.L, this.Y2, this.M);
            this.F5 = GetScheduledOrdersInteractor_Factory.a(this.f20470k1, this.f20568v4);
            this.G5 = GetAcceptedOrdersInteractor_Factory.a(this.f20470k1, this.f20568v4);
            this.H5 = ScheduledOrderListModelFactory_Factory.a(this.f20463j3, OrderMapPointsFactory_Factory.a());
            ScheduledOrderInfoBlockMapper_Factory a15 = ScheduledOrderInfoBlockMapper_Factory.a(this.f20463j3);
            this.I5 = a15;
            this.J5 = ScheduledOrdersViewModel_Factory.a(this.F5, this.G5, this.H5, a15, this.f20463j3);
            Provider<BoltClubApi> provider3 = DoubleCheck.provider(AuthorisedNetworkModule_ProvideBoltClubApiFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            this.K5 = provider3;
            this.L5 = BoltClubClient_Factory.a(provider3);
            BoltClubDataMapper_Factory a16 = BoltClubDataMapper_Factory.a(this.f20463j3);
            this.M5 = a16;
            this.N5 = BoltClubViewModel_Factory.a(this.L5, a16, this.W, this.f20548t0);
            this.O5 = GetUpcomingOrderDetailsInteractor_Factory.a(this.f20470k1, this.f20568v4);
            ScheduledOrderDetailsComponentFactory_Factory a17 = ScheduledOrderDetailsComponentFactory_Factory.a(this.I5, ScheduledOrderButtonAppearanceMapper_Factory.a(), this.f20463j3, OrderMapPointsFactory_Factory.a());
            this.P5 = a17;
            ScheduledOrderDetailsStateFactory_Factory a18 = ScheduledOrderDetailsStateFactory_Factory.a(a17);
            this.Q5 = a18;
            this.R5 = ScheduledOrderDetailsViewModel_Factory.a(this.O5, this.f20576w4, a18);
            this.S5 = ScheduledOrdersGroupViewModel_Factory.a(this.F5, this.H5);
            GetExternalSourceAddressInteractor_Factory a19 = GetExternalSourceAddressInteractor_Factory.a(this.Q2);
            this.T5 = a19;
            this.U5 = GetSuggestionsInteractor_Factory.a(this.f20434g1, a19);
            GetExternalSourceAddressDetailInteractor_Factory a20 = GetExternalSourceAddressDetailInteractor_Factory.a(this.Q2);
            this.V5 = a20;
            UpdateDriverDestinationInteractor_Factory a21 = UpdateDriverDestinationInteractor_Factory.a(this.Z0, a20);
            this.W5 = a21;
            this.X5 = DriverDestinationSearchViewModel_Factory.a(this.U5, a21, this.f20407d1, SearchSuggestionMapper_Factory.a());
            this.Y5 = DriverDestinationActiveStateViewModel_Factory.a(this.f20416e1);
            this.Z5 = BoltClubOfferDetailsViewModel_Factory.a(this.L5, this.M5, this.W, this.f20548t0, this.W4);
            this.f20385a6 = ThemeSettingsViewModel_Factory.a(this.f20487m0, this.S);
            AuthorisedStaffModule_BindVoipOrderInfoProviderFactory b8 = AuthorisedStaffModule_BindVoipOrderInfoProviderFactory.b(authorisedStaffModule, this.P0);
            this.f20394b6 = b8;
            this.f20403c6 = eu.bolt.driver.voip.ui.screen.call.incoming.IncomingCallViewModel_Factory.a(b8);
            GetOrderDestinationSearchSuggestionInteractor_Factory a22 = GetOrderDestinationSearchSuggestionInteractor_Factory.a(this.T5, this.U, this.G0, this.f20434g1);
            this.f20412d6 = a22;
            this.f20421e6 = OrderDestinationViewModel_Factory.a(a22, this.V5, SearchSuggestionMapper_Factory.a());
            EarningsApiProvider earningsApiProvider = new EarningsApiProvider(applicationComponent);
            this.f20430f6 = earningsApiProvider;
            this.f20439g6 = eu.bolt.driver.earnings.network.EarningsClient_Factory.a(earningsApiProvider);
            EarningsGoalApiProvider earningsGoalApiProvider = new EarningsGoalApiProvider(applicationComponent);
            this.f20448h6 = earningsGoalApiProvider;
            EarningsGoalClient_Factory a23 = EarningsGoalClient_Factory.a(earningsGoalApiProvider);
            this.f20457i6 = a23;
            Provider<EarningsManager> provider4 = DoubleCheck.provider(EarningsManager_Factory.a(this.f20439g6, a23));
            this.f20466j6 = provider4;
            this.f20475k6 = EarningsLandingViewModel_Factory.a(provider4, this.f20550t2, this.H2);
            this.f20484l6 = EarningsItemMapper_Factory.a(this.f20454i3, this.f20463j3);
            EarningsNestedItemMapper_Factory a24 = EarningsNestedItemMapper_Factory.a(this.f20454i3);
            this.f20493m6 = a24;
            EarningsBreakdownMapper_Factory a25 = EarningsBreakdownMapper_Factory.a(this.f20484l6, a24, DriverContentTypeMapper_Factory.a());
            this.f20502n6 = a25;
            this.f20511o6 = EarningsBreakdownViewModel_Factory.a(this.f20439g6, a25, EarningsBreakdownStubFactory_Factory.a());
            this.f20520p6 = EarningsGoalViewModel_Factory.a(this.f20466j6, DriverNormalImageMapper_Factory.a(), this.f20522q);
            this.f20529q6 = EarningsGoalExpensesViewModel_Factory.a(this.f20522q);
            SafetyToolkitInteractor_Factory a26 = SafetyToolkitInteractor_Factory.a(this.f20477l, this.S4, this.R, this.G0, this.J1, this.f20582x2, this.N1);
            this.f20538r6 = a26;
            this.f20546s6 = SafetyToolkitViewModel_Factory.a(a26, this.f20541s1, this.G0, this.Q3, this.f20561u5, this.f20543s3, this.E1);
            EmergencyAssistDataMapper_Factory a27 = EmergencyAssistDataMapper_Factory.a(this.f20454i3, this.f20477l);
            this.f20554t6 = a27;
            this.f20562u6 = EmergencyAssistHelpViewModel_Factory.a(this.J1, a27, this.R, this.E1);
            this.f20570v6 = DidYouGetHelpViewModel_Factory.a(this.G1, this.G0, this.J1, this.E1);
            StartRecordingInteractor_Factory a28 = StartRecordingInteractor_Factory.a(this.G0, this.f20528q5, this.N1);
            this.f20578w6 = a28;
            this.f20586x6 = AudioRecordingViewModel_Factory.a(this.N1, a28, this.f20561u5);
            EarningsBalanceApiProvider earningsBalanceApiProvider = new EarningsBalanceApiProvider(applicationComponent);
            this.f20594y6 = earningsBalanceApiProvider;
            this.f20602z6 = EarningsBalanceClient_Factory.a(earningsBalanceApiProvider);
            this.A6 = DriverInfoBlockMapper_Factory.a(this.f20463j3, this.f20454i3);
            this.B6 = DriverBannerMapper_Factory.a(this.f20454i3);
            this.C6 = EarningsBalanceHeaderMapper_Factory.a(EarningsBalanceStateTypeMapper_Factory.a(), this.f20445h3, this.A6, this.B6);
            EarningsBalanceHistoryItemMapper_Factory a29 = EarningsBalanceHistoryItemMapper_Factory.a(DriverContentTypeMapper_Factory.a(), this.f20463j3);
            this.D6 = a29;
            EarningsBalanceHistoryMapper_Factory a30 = EarningsBalanceHistoryMapper_Factory.a(a29, this.A6);
            this.E6 = a30;
            this.F6 = EarningsBalanceViewModel_Factory.a(this.f20602z6, this.C6, a30);
            this.G6 = RequestWebUrlViewModel_Factory.a(this.f20473k4);
            this.H6 = EarningsPayoutExplanationViewModel_Factory.a(this.f20439g6, this.f20463j3, this.A6);
            this.I6 = GetMapSettingsInteractor_Factory.a(this.f20517p3, this.f20454i3);
            this.J6 = SetMapSettingsHeatmapInteractor_Factory.a(this.f20508o3);
            SetMapSettingsCategoryInteractor_Factory a31 = SetMapSettingsCategoryInteractor_Factory.a(this.f20508o3);
            this.K6 = a31;
            this.L6 = MapSettingsViewModel_Factory.a(this.I6, this.J6, a31, this.f20522q);
            this.M6 = HowToRequestPayoutViewModel_Factory.a(this.Z1);
            AuthorisedCoreModule_ProvideThemeManagerFactory a32 = AuthorisedCoreModule_ProvideThemeManagerFactory.a(authorisedCoreModule, this.f20477l);
            this.N6 = a32;
            GetMapExplanationInteractor_Factory a33 = GetMapExplanationInteractor_Factory.a(this.U, a32);
            this.O6 = a33;
            this.P6 = MapExplanationViewModel_Factory.a(a33);
            ScreenAnalyticsProvider screenAnalyticsProvider = new ScreenAnalyticsProvider(applicationComponent);
            this.Q6 = screenAnalyticsProvider;
            this.R6 = AboutDriverDestinationsFragment_Factory.a(screenAnalyticsProvider);
        }

        private void X(AuthorisedCoreModule authorisedCoreModule, AuthorisedNetworkModule authorisedNetworkModule, AuthorisedServicesModule authorisedServicesModule, AuthorisedStaffModule authorisedStaffModule, AuthorisedUiModule authorisedUiModule, ThemeModule themeModule, DriverChatAuthorisedModule driverChatAuthorisedModule, StoriesModule storiesModule, PollerModule pollerModule, TripAudioRecordingModule tripAudioRecordingModule, ApplicationComponent applicationComponent, DriverConfig driverConfig, DriverSettings driverSettings, DriverFeatures driverFeatures, AnchoredTimeSource anchoredTimeSource) {
            MapProviderFactory build = MapProviderFactory.builder(79).put((MapProviderFactory.Builder) AutoAcceptanceSettingsViewModel.class, (Provider) this.f20531r).put((MapProviderFactory.Builder) WaybillViewModel.class, (Provider) this.f20587y).put((MapProviderFactory.Builder) CircleKLoyaltyViewModel.class, (Provider) this.C).put((MapProviderFactory.Builder) CircleKLoyaltyStarterViewModel.class, (Provider) this.G).put((MapProviderFactory.Builder) OptInCampaignViewModel.class, (Provider) this.O).put((MapProviderFactory.Builder) DispatchSettingsViewModel.class, (Provider) this.T).put((MapProviderFactory.Builder) CarChooserViewModel.class, (Provider) this.f20415e0).put((MapProviderFactory.Builder) SettingsViewModel.class, (Provider) this.f20596z0).put((MapProviderFactory.Builder) NavigationSettingsTbtViewModel.class, (Provider) this.A0).put((MapProviderFactory.Builder) NavigatorChooserViewModel.class, (Provider) this.F0).put((MapProviderFactory.Builder) ChoosePriceReviewViewModel.class, (Provider) this.J0).put((MapProviderFactory.Builder) ContactOptionsViewModel.class, (Provider) this.Y0).put((MapProviderFactory.Builder) DestinationsViewModel.class, (Provider) this.f20443h1).put((MapProviderFactory.Builder) DriverActivityViewModel.class, (Provider) this.f20461j1).put((MapProviderFactory.Builder) DrivePriceViewModel.class, (Provider) this.U1).put((MapProviderFactory.Builder) EarningsViewModel.class, (Provider) this.f20417e2).put((MapProviderFactory.Builder) HomeViewModel.class, (Provider) this.N2).put((MapProviderFactory.Builder) ee.mtakso.driver.ui.screens.contact_methods.voip.incoming.IncomingCallViewModel.class, (Provider) IncomingCallViewModel_Factory.a()).put((MapProviderFactory.Builder) IncomingOrderViewModel.class, (Provider) this.T2).put((MapProviderFactory.Builder) InprogressCallViewModel.class, (Provider) this.V2).put((MapProviderFactory.Builder) MapPaddingViewModel.class, (Provider) MapPaddingViewModel_Factory.a()).put((MapProviderFactory.Builder) WorkViewModel.class, (Provider) this.f20551t3).put((MapProviderFactory.Builder) NoAnswerViewModel.class, (Provider) this.f20567v3).put((MapProviderFactory.Builder) OrderViewModel.class, (Provider) this.U3).put((MapProviderFactory.Builder) PayoutHistoryViewModel.class, (Provider) this.W3).put((MapProviderFactory.Builder) StorySetViewModel.class, (Provider) this.Z3).put((MapProviderFactory.Builder) PayoutRequestViewModel.class, (Provider) this.f20401c4).put((MapProviderFactory.Builder) DriverPriorityViewModel.class, (Provider) this.f20428f4).put((MapProviderFactory.Builder) PayoutDetailsViewModel.class, (Provider) this.f20446h4).put((MapProviderFactory.Builder) InfoWebViewModel.class, (Provider) this.f20455i4).put((MapProviderFactory.Builder) PayToBoltViewModel.class, (Provider) this.f20482l4).put((MapProviderFactory.Builder) QuickAccessSettingsViewModel.class, (Provider) this.f20500n4).put((MapProviderFactory.Builder) RateCallViewModel.class, (Provider) this.f20518p4).put((MapProviderFactory.Builder) SosDialogViewModel.class, (Provider) this.f20536r4).put((MapProviderFactory.Builder) VoipCallErrorViewModel.class, (Provider) this.f20560u4).put((MapProviderFactory.Builder) TripCancellationViewModel.class, (Provider) this.f20584x4).put((MapProviderFactory.Builder) WorkMapViewModel.class, (Provider) this.J4).put((MapProviderFactory.Builder) WorkTimeViewModel.class, (Provider) this.L4).put((MapProviderFactory.Builder) RateMeCategoryViewModel.class, (Provider) this.O4).put((MapProviderFactory.Builder) SupportViewModel.class, (Provider) this.P4).put((MapProviderFactory.Builder) OrderListViewModel.class, (Provider) this.R4).put((MapProviderFactory.Builder) InboxViewModel.class, (Provider) this.X4).put((MapProviderFactory.Builder) DriverScoreViewModel.class, (Provider) this.f20384a5).put((MapProviderFactory.Builder) DriverScoreExplanationViewModel.class, (Provider) this.f20393b5).put((MapProviderFactory.Builder) CallBackViewModel.class, (Provider) this.f20402c5).put((MapProviderFactory.Builder) PricingSettingsViewModel.class, (Provider) this.f20429f5).put((MapProviderFactory.Builder) VehicleListViewModel.class, (Provider) this.f20447h5).put((MapProviderFactory.Builder) DriverAppDisabledViewModel.class, (Provider) this.f20456i5).put((MapProviderFactory.Builder) LanguageSettingsViewModel.class, (Provider) this.f20492m5).put((MapProviderFactory.Builder) OrderHistoryDetailsViewModel.class, (Provider) this.f20569v5).put((MapProviderFactory.Builder) ActiveCampaignsViewModel.class, (Provider) this.f20593y5).put((MapProviderFactory.Builder) PastCampaignsViewModel.class, (Provider) this.f20601z5).put((MapProviderFactory.Builder) CampaignDetailsViewModel.class, (Provider) this.A5).put((MapProviderFactory.Builder) ReferralCampaignDetailsViewModel.class, (Provider) this.D5).put((MapProviderFactory.Builder) OptInChoiceViewModel.class, (Provider) this.E5).put((MapProviderFactory.Builder) ScheduledOrdersViewModel.class, (Provider) this.J5).put((MapProviderFactory.Builder) BoltClubViewModel.class, (Provider) this.N5).put((MapProviderFactory.Builder) ScheduledOrderDetailsViewModel.class, (Provider) this.R5).put((MapProviderFactory.Builder) ScheduledOrdersGroupViewModel.class, (Provider) this.S5).put((MapProviderFactory.Builder) DriverDestinationSearchViewModel.class, (Provider) this.X5).put((MapProviderFactory.Builder) DriverDestinationActiveStateViewModel.class, (Provider) this.Y5).put((MapProviderFactory.Builder) BoltClubOfferDetailsViewModel.class, (Provider) this.Z5).put((MapProviderFactory.Builder) ThemeSettingsViewModel.class, (Provider) this.f20385a6).put((MapProviderFactory.Builder) IncomingCallViewModel.class, (Provider) this.f20403c6).put((MapProviderFactory.Builder) OrderDestinationViewModel.class, (Provider) this.f20421e6).put((MapProviderFactory.Builder) EarningsLandingViewModel.class, (Provider) this.f20475k6).put((MapProviderFactory.Builder) EarningsBreakdownViewModel.class, (Provider) this.f20511o6).put((MapProviderFactory.Builder) EarningsGoalViewModel.class, (Provider) this.f20520p6).put((MapProviderFactory.Builder) EarningsGoalExpensesViewModel.class, (Provider) this.f20529q6).put((MapProviderFactory.Builder) SafetyToolkitViewModel.class, (Provider) this.f20546s6).put((MapProviderFactory.Builder) EmergencyAssistHelpViewModel.class, (Provider) this.f20562u6).put((MapProviderFactory.Builder) DidYouGetHelpViewModel.class, (Provider) this.f20570v6).put((MapProviderFactory.Builder) AudioRecordingViewModel.class, (Provider) this.f20586x6).put((MapProviderFactory.Builder) EarningsBalanceViewModel.class, (Provider) this.F6).put((MapProviderFactory.Builder) RequestWebUrlViewModel.class, (Provider) this.G6).put((MapProviderFactory.Builder) EarningsPayoutExplanationViewModel.class, (Provider) this.H6).put((MapProviderFactory.Builder) MapSettingsViewModel.class, (Provider) this.L6).put((MapProviderFactory.Builder) HowToRequestPayoutViewModel.class, (Provider) this.M6).put((MapProviderFactory.Builder) MapExplanationViewModel.class, (Provider) this.P6).build();
            this.S6 = build;
            AuthorisedUiModule_ProvideAuthViewModelFactoryFactory a8 = AuthorisedUiModule_ProvideAuthViewModelFactoryFactory.a(authorisedUiModule, build);
            this.T6 = a8;
            AuthorisedStaffModule_ProvideAuthorisedUiDependenciesFactory a9 = AuthorisedStaffModule_ProvideAuthorisedUiDependenciesFactory.a(authorisedStaffModule, this.Q6, a8, this.f20582x2, this.f20487m0);
            this.U6 = a9;
            this.V6 = AutoAcceptanceSettingsFragment_Factory.a(a9);
            this.W6 = BalanceFragment_Factory.a(this.U6, ReportPageMapper_Factory.a());
            this.X6 = WaybillFragment_Factory.a(this.B, this.U6);
            this.Y6 = CircleKLoyaltyFragment_Factory.a(this.U6, this.f20582x2);
            this.Z6 = CircleKLoyaltyStarterFragment_Factory.a(this.U6);
            this.f20386a7 = OptInCampaignFragment_Factory.a(this.U6, this.f20463j3);
            this.f20395b7 = AccountSettingsFragment_Factory.a(this.U6);
            this.f20404c7 = AppSettingsFragment_Factory.a(this.U6, this.f20522q, this.f20487m0);
            this.f20413d7 = NavigationSettingsFragment_Factory.a(this.U6);
            this.f20422e7 = NavigationSettingsTbtFragment_Factory.a(this.U6);
            this.f20431f7 = SettingsFragment_Factory.a(this.U6, DebugTweaksMenu_Factory.a(), this.f20477l);
            this.f20440g7 = NavigatorChooserFragment_Factory.a(this.U6, this.Q);
            this.f20449h7 = ChoosePriceReviewDialog_Factory.a(this.U6);
            this.f20458i7 = DriverActivityFragment_Factory.a(this.U6, this.N);
            this.f20467j7 = new DelegateFactory();
            this.f20476k7 = new DelegateFactory();
            EffectsFactory_Factory a10 = EffectsFactory_Factory.a(this.f20459j);
            this.f20485l7 = a10;
            this.f20494m7 = IncomingOrderSoundController_Factory.a(a10);
            this.f20503n7 = IntentProvider_Factory.a(this.f20459j);
            NotificationManagerProvider notificationManagerProvider = new NotificationManagerProvider(applicationComponent);
            this.f20512o7 = notificationManagerProvider;
            UiNotificationManager_Factory a11 = UiNotificationManager_Factory.a(this.f20459j, this.f20503n7, notificationManagerProvider, VoipEffectsFactory_Factory.a());
            this.f20521p7 = a11;
            this.f20530q7 = IncomingOrderFragment_Factory.a(this.U6, this.f20541s1, this.S1, this.f20476k7, this.f20494m7, this.f20463j3, a11, this.f20477l);
            this.r7 = new MapProvider2Provider(applicationComponent);
            MarkerParamsFactory_Factory a12 = MarkerParamsFactory_Factory.a(this.f20459j, this.f20487m0);
            this.s7 = a12;
            this.t7 = IncomingOrderMapFragment_Factory.a(this.U6, this.r7, a12, this.Q);
            Provider<DriverProvider> provider = this.f20477l;
            Provider<AnalyticsImpl> provider2 = this.f20522q;
            PromoDialogDelegate_Factory a13 = PromoDialogDelegate_Factory.a(provider, provider2, this.f20491m4, provider2, this.f20582x2, this.S);
            this.u7 = a13;
            this.v7 = ModalDelegate_Factory.a(a13);
            this.w7 = MicrophonePermissionDialogProvider_Factory.a(this.f20459j);
            LowStorageDialogDelegate_Factory a14 = LowStorageDialogDelegate_Factory.a(this.f20459j);
            this.x7 = a14;
            this.y7 = WorkFragment_Factory.a(this.U6, this.f20477l, this.N, this.f20442h0, this.f20468k, this.f20490m3, this.f20434g1, this.f20522q, this.u7, this.f20582x2, this.f20463j3, this.v7, this.S4, this.w7, this.f20543s3, a14);
            this.z7 = AuthorisedCoreModule_ProvideBaseFragmentParamsFactory.a(authorisedCoreModule, this.f20582x2);
            this.A7 = StoriesModule_ProvideStoryViewModelFactory.a(storiesModule, StoryViewModel_Factory.a());
            this.B7 = StoriesModule_ProvideStorySetViewModelFactory.a(storiesModule, this.Z3);
            this.C7 = new ChatRepoProvider(applicationComponent);
            this.D7 = new SendChatMessageInteractorProvider(applicationComponent);
            this.E7 = new RequestReplySuggestionsInteractorProvider(applicationComponent);
            ChatConnProviderProvider chatConnProviderProvider = new ChatConnProviderProvider(applicationComponent);
            this.F7 = chatConnProviderProvider;
            this.G7 = ConversationViewModel_Factory.a(this.C7, this.D7, this.E7, this.f20522q, chatConnProviderProvider);
            this.H7 = ConversationPagerViewModel_Factory.a(this.S3, ConversationMapper_Factory.a());
            MapProviderFactory build2 = MapProviderFactory.builder(4).put((MapProviderFactory.Builder) StoryViewModel.class, (Provider) this.A7).put((MapProviderFactory.Builder) StorySetViewModel.class, (Provider) this.B7).put((MapProviderFactory.Builder) ConversationViewModel.class, (Provider) this.G7).put((MapProviderFactory.Builder) ConversationPagerViewModel.class, (Provider) this.H7).build();
            this.I7 = build2;
            this.J7 = AuthorisedCoreModule_ProvideViewModelFactoryFactory.a(authorisedCoreModule, build2);
            StorySlideAssetMapper_Factory a15 = StorySlideAssetMapper_Factory.a(StoryAssetDimensionMapper_Factory.a());
            this.K7 = a15;
            StorySlideContentItemMapper_Factory a16 = StorySlideContentItemMapper_Factory.a(a15);
            this.L7 = a16;
            this.M7 = StorySlideContentMapper_Factory.a(a16);
            this.N7 = StoryMapper_Factory.a(this.K7, StoryButtonStyleMapper_Factory.a(), this.M7);
            StoryAnalyticDelegate_Factory a17 = StoryAnalyticDelegate_Factory.a(this.f20522q);
            this.O7 = a17;
            this.P7 = StorySetFragment_Factory.a(this.z7, this.J7, this.N7, a17, this.f20463j3);
            this.Q7 = PayoutHistoryFragment_Factory.a(this.U6);
            this.R7 = PayoutRequestFragment_Factory.a(this.U6, FlatGenericSectionsMapper_Factory.a());
            this.S7 = DriverPriorityFragment_Factory.a(this.U6, this.f20490m3);
            this.T7 = PayoutDetailsInfoPageFragment_Factory.a(this.U6, PayoutDetailsMapper_Factory.a());
            this.U7 = PayoutDetailsProgressPageFragment_Factory.a(this.U6, PayoutDetailsMapper_Factory.a());
            this.V7 = InfoWebFragment_Factory.a(this.U6);
            this.W7 = OperationResultFragment_Factory.a(this.U6);
            this.X7 = OrderMapFragment_Factory.a(this.U6, this.r7, this.s7, this.f20477l);
            DriverAppStickyBannerMapper_Factory a18 = DriverAppStickyBannerMapper_Factory.a(this.f20463j3, this.f20454i3, DriverColorMapper_Factory.a());
            this.Y7 = a18;
            this.Z7 = OrderPanelFragment_Factory.a(this.U6, this.f20476k7, this.f20469k0, this.f20477l, a18);
            this.a8 = PayToBoltFragment_Factory.a(this.U6);
            this.b8 = QuickAccessSettingsFragment_Factory.a(this.U6);
            this.c8 = SosDialogFragment_Factory.a(this.U6);
            TileClient_Factory a19 = TileClient_Factory.a(this.f20539s, this.X);
            this.d8 = a19;
            this.e8 = DoubleCheck.provider(TileRequestMerger_Factory.a(a19));
            this.f8 = new VectorTileBitmapPoolProvider(applicationComponent);
            MvtToRasterConverter_Factory a20 = MvtToRasterConverter_Factory.a(MvtRenderer_Factory.a(), this.f8);
            this.g8 = a20;
            this.h8 = HeatmapTileSourceFactory_Factory.a(this.e8, a20, SystemUptimeSource_Factory.a());
            GsonProvider gsonProvider = new GsonProvider(applicationComponent);
            this.i8 = gsonProvider;
            FeaturePropertiesFactory_Factory a21 = FeaturePropertiesFactory_Factory.a(gsonProvider);
            this.j8 = a21;
            VectorPropertiesFactory_Factory a22 = VectorPropertiesFactory_Factory.a(a21);
            this.k8 = a22;
            WaitingTimeMarkerProvider_Factory a23 = WaitingTimeMarkerProvider_Factory.a(this.e8, a22);
            this.l8 = a23;
            this.m8 = WaitingTimeTileSourceFactory_Factory.a(a23);
            RawTranslationProviderProvider rawTranslationProviderProvider = new RawTranslationProviderProvider(applicationComponent);
            this.n8 = rawTranslationProviderProvider;
            this.o8 = WaitingTimeTranslationProvider_Factory.a(rawTranslationProviderProvider);
            this.p8 = WaitingTimeMarkerRenderer_Factory.a(MarkerCache_Factory.a(), this.s7, this.f20463j3, this.o8, this.f20459j);
            FifoQueueTileSource_Factory a24 = FifoQueueTileSource_Factory.a(this.f8, this.e8, this.k8);
            this.q8 = a24;
            this.r8 = WorkMapFragment_Factory.a(this.U6, this.r7, this.h8, this.m8, this.p8, a24, a24, this.s7, this.f20463j3, this.Q);
            this.s8 = WorkTimeFragment_Factory.a(this.U6);
            this.t8 = RateRiderFragment_Factory.a(this.U6);
            this.u8 = RateRiderDialogFragment_Factory.a(this.f20476k7);
            this.v8 = RateMeCategoriesFragment_Factory.a(this.U6, this.f20463j3);
            this.w8 = RateMeReasonsFragment_Factory.a(this.U6);
            this.x8 = SupportFragment_Factory.a(this.U6, this.f20582x2, this.f20548t0);
            this.y8 = DriverBlockedFragment_Factory.a(this.U6, this.f20469k0, this.f20548t0);
            RateMeDialogDelegate_Factory a25 = RateMeDialogDelegate_Factory.a(this.f20549t1, this.f20522q);
            this.z8 = a25;
            this.A8 = OrderListFragment_Factory.a(this.U6, this.f20469k0, a25);
            this.B8 = InboxFragment_Factory.a(this.U6, StoryManager_Factory.a(), this.f20469k0);
            this.C8 = DriverScoreFragment_Factory.a(this.U6, this.f20548t0);
            this.D8 = DriverScoreExplanationFragment_Factory.a(this.U6, this.N6);
            this.E8 = PricingSettingsFragment_Factory.a(this.U6, PriceFormat_Factory.a());
            this.F8 = VehicleListFragment_Factory.a(this.U6);
            this.G8 = DriverAppDisabledFragment_Factory.a(this.U6, this.f20513p);
            this.H8 = LanguageSettingsFragment_Factory.a(this.U6);
            this.I8 = OrderHistoryDetailsFragment_Factory.a(this.U6, this.N, this.r7, this.f20487m0, this.f20469k0, this.S4, this.f20477l, this.f20463j3, this.f20476k7);
            this.J8 = FileUploadConfirmationDialog_Factory.a(this.U6, AudioRecordingMapper_Factory.a());
            this.K8 = RetryFileUploadFragment_Factory.a(this.U6);
            this.L8 = ActiveCampaignsFragment_Factory.a(this.N, this.U6);
            this.M8 = CustomPriceFragment_Factory.a(this.U6, this.f20476k7, this.f20477l, this.S4);
            this.N8 = PricePreviewFragment_Factory.a(this.U6, this.f20476k7, this.S4, this.f20477l);
        }

        private void Y(AuthorisedCoreModule authorisedCoreModule, AuthorisedNetworkModule authorisedNetworkModule, AuthorisedServicesModule authorisedServicesModule, AuthorisedStaffModule authorisedStaffModule, AuthorisedUiModule authorisedUiModule, ThemeModule themeModule, DriverChatAuthorisedModule driverChatAuthorisedModule, StoriesModule storiesModule, PollerModule pollerModule, TripAudioRecordingModule tripAudioRecordingModule, ApplicationComponent applicationComponent, DriverConfig driverConfig, DriverSettings driverSettings, DriverFeatures driverFeatures, AnchoredTimeSource anchoredTimeSource) {
            this.O8 = PastCampaignsFragment_Factory.a(this.U6);
            this.P8 = CampaignInfoBlockMapper_Factory.a(this.f20463j3);
            this.Q8 = CampaignBonusMapper_Factory.a(CampaignImageMapper_Factory.a(), this.P8);
            CampaignDynamicItemsMapper_Factory a8 = CampaignDynamicItemsMapper_Factory.a(this.P8, this.f20463j3);
            this.R8 = a8;
            this.S8 = CampaignDetailsFragment_Factory.a(this.r7, this.f20487m0, this.f20463j3, this.Q8, this.P8, a8, this.U6);
            this.T8 = ReferralCampaignDetailsFragment_Factory.a(this.Q8, this.U6);
            this.U8 = OptInChoiceFragment_Factory.a(this.r7, this.f20487m0, this.Q8, this.P8, this.R8, this.U6);
            this.V8 = ScheduledOrdersFragment_Factory.a(this.U6, this.r7, this.f20487m0, this.s7);
            this.W8 = BoltClubListingFragment_Factory.a(this.U6);
            this.X8 = ScheduledOrderDetailsFragment_Factory.a(this.U6, this.r7, this.f20487m0, this.s7, this.f20548t0, this.f20476k7, ScheduledOrderButtonAppearanceMapper_Factory.a(), this.f20463j3);
            this.Y8 = OrderModalFragment_Factory.a(this.U6, this.f20463j3, this.f20490m3);
            this.Z8 = TripCancellationBottomSheetFragment_Factory.a(this.Q6, this.T6, this.f20582x2);
            this.a9 = ScheduledOrdersGroupFragment_Factory.a(this.U6, this.r7, this.f20487m0, this.s7, this.f20463j3);
            this.b9 = DestinationFragment_Factory.a(this.U6, this.f20434g1, DestinationMapper_Factory.a(), this.f20476k7);
            this.c9 = DriverDestinationSearchFragment_Factory.a(this.U6);
            this.d9 = DriverDestinationActiveStateFragment_Factory.a(this.U6);
            this.e9 = BoltClubOfferDetailsFragment_Factory.a(this.U6);
            this.f9 = OrderMenuDialogFragment_Factory.a(this.f20477l, this.f20476k7, OrderMenuDialogMapper_Factory.a(), this.f20541s1, this.A6);
            this.g9 = AddStopBottomSheetDialogFragment_Factory.a(this.U6);
            this.h9 = ThemeSettingsFragment_Factory.a(this.U6);
            this.i9 = OptInChoiceActivationInfoFragment_Factory.a(this.U6);
            this.j9 = OrderDestinationFragment_Factory.a(this.U6);
            this.k9 = DriverChipMapper_Factory.a(this.f20454i3);
            EarningsLandingMapper_Factory a9 = EarningsLandingMapper_Factory.a(this.Q, DriverColorMapper_Factory.a(), this.f20454i3, this.k9, DriverLinkAppearanceMapper_Factory.a(), EarningsBalanceStateTypeMapper_Factory.a());
            this.l9 = a9;
            this.m9 = EarningsLandingFragment_Factory.a(this.U6, this.f20490m3, a9, this.Q, this.v7);
            this.n9 = EarningsBreakdownFragment_Factory.a(this.U6, this.f20490m3, this.f20469k0);
            this.o9 = EarningsGoalFragment_Factory.a(this.U6, this.f20476k7, CurrencyValueFormat_Factory.a());
            this.p9 = EarningsGoalExpensesFragment_Factory.a(this.U6, CurrencyValueFormat_Factory.a());
            SafetyToolkitMapper_Factory a10 = SafetyToolkitMapper_Factory.a(this.f20582x2, this.f20463j3);
            this.q9 = a10;
            this.r9 = SafetyToolkitBottomSheetFragment_Factory.a(a10, this.f20476k7, this.w7, this.Q6, this.T6, this.f20582x2);
            this.s9 = EmergencyAssistHelpBottomSheetFragment_Factory.a(this.f20554t6, this.f20476k7, this.R, this.Q6, this.T6, this.f20582x2);
            this.t9 = DidYouGetHelpFragment_Factory.a(this.Q6, this.T6, this.f20582x2);
            this.u9 = ActiveIncidentDialogFragment_Factory.a(this.U6, this.R);
            this.v9 = AudioRecordingBottomSheetFragment_Factory.a(this.f20463j3, this.Q6, this.T6, this.f20582x2);
            this.w9 = EarningsBalanceFragment_Factory.a(this.U6, this.f20469k0, this.f20490m3);
            this.x9 = RequestWebUrlFragment_Factory.a(this.U6, this.f20532r0);
            this.y9 = EarningsPayoutExplanationFragment_Factory.a(this.U6);
            this.z9 = MapSettingsFragment_Factory.a(this.U6, this.f20469k0);
            this.A9 = HowToRequestPayoutFragment_Factory.a(this.U6);
            this.B9 = MapExplanationFragment_Factory.a(this.U6);
            MapProviderFactory build = MapProviderFactory.builder(89).put((MapProviderFactory.Builder) AboutDriverDestinationsFragment.class, (Provider) this.R6).put((MapProviderFactory.Builder) AutoAcceptanceSettingsFragment.class, (Provider) this.V6).put((MapProviderFactory.Builder) BalanceFragment.class, (Provider) this.W6).put((MapProviderFactory.Builder) WaybillFragment.class, (Provider) this.X6).put((MapProviderFactory.Builder) CircleKLoyaltyFragment.class, (Provider) this.Y6).put((MapProviderFactory.Builder) CircleKLoyaltyStarterFragment.class, (Provider) this.Z6).put((MapProviderFactory.Builder) OptInCampaignFragment.class, (Provider) this.f20386a7).put((MapProviderFactory.Builder) AccountSettingsFragment.class, (Provider) this.f20395b7).put((MapProviderFactory.Builder) AppSettingsFragment.class, (Provider) this.f20404c7).put((MapProviderFactory.Builder) NavigationSettingsFragment.class, (Provider) this.f20413d7).put((MapProviderFactory.Builder) NavigationSettingsTbtFragment.class, (Provider) this.f20422e7).put((MapProviderFactory.Builder) SettingsFragment.class, (Provider) this.f20431f7).put((MapProviderFactory.Builder) NavigatorChooserFragment.class, (Provider) this.f20440g7).put((MapProviderFactory.Builder) ChoosePriceReviewDialog.class, (Provider) this.f20449h7).put((MapProviderFactory.Builder) DriverActivityFragment.class, (Provider) this.f20458i7).put((MapProviderFactory.Builder) HomeFragment.class, (Provider) this.f20467j7).put((MapProviderFactory.Builder) IncomingOrderFragment.class, (Provider) this.f20530q7).put((MapProviderFactory.Builder) IncomingOrderMapFragment.class, (Provider) this.t7).put((MapProviderFactory.Builder) WorkFragment.class, (Provider) this.y7).put((MapProviderFactory.Builder) StorySetFragment.class, (Provider) this.P7).put((MapProviderFactory.Builder) PayoutHistoryFragment.class, (Provider) this.Q7).put((MapProviderFactory.Builder) PayoutRequestFragment.class, (Provider) this.R7).put((MapProviderFactory.Builder) DriverPriorityFragment.class, (Provider) this.S7).put((MapProviderFactory.Builder) PayoutDetailsInfoPageFragment.class, (Provider) this.T7).put((MapProviderFactory.Builder) PayoutDetailsProgressPageFragment.class, (Provider) this.U7).put((MapProviderFactory.Builder) InfoWebFragment.class, (Provider) this.V7).put((MapProviderFactory.Builder) OperationResultFragment.class, (Provider) this.W7).put((MapProviderFactory.Builder) OrderMapFragment.class, (Provider) this.X7).put((MapProviderFactory.Builder) OrderPanelFragment.class, (Provider) this.Z7).put((MapProviderFactory.Builder) PayToBoltFragment.class, (Provider) this.a8).put((MapProviderFactory.Builder) QuickAccessSettingsFragment.class, (Provider) this.b8).put((MapProviderFactory.Builder) SosDialogFragment.class, (Provider) this.c8).put((MapProviderFactory.Builder) WorkMapFragment.class, (Provider) this.r8).put((MapProviderFactory.Builder) WorkTimeFragment.class, (Provider) this.s8).put((MapProviderFactory.Builder) RateRiderFragment.class, (Provider) this.t8).put((MapProviderFactory.Builder) RateRiderDisclaimerFragment.class, (Provider) RateRiderDisclaimerFragment_Factory.a()).put((MapProviderFactory.Builder) RateRiderDialogFragment.class, (Provider) this.u8).put((MapProviderFactory.Builder) RateMeCategoriesFragment.class, (Provider) this.v8).put((MapProviderFactory.Builder) RateMeReasonsFragment.class, (Provider) this.w8).put((MapProviderFactory.Builder) SupportFragment.class, (Provider) this.x8).put((MapProviderFactory.Builder) DriverBlockedFragment.class, (Provider) this.y8).put((MapProviderFactory.Builder) OrderListFragment.class, (Provider) this.A8).put((MapProviderFactory.Builder) InboxFragment.class, (Provider) this.B8).put((MapProviderFactory.Builder) DriverScoreFragment.class, (Provider) this.C8).put((MapProviderFactory.Builder) DriverScoreExplanationFragment.class, (Provider) this.D8).put((MapProviderFactory.Builder) PricingSettingsFragment.class, (Provider) this.E8).put((MapProviderFactory.Builder) VehicleListFragment.class, (Provider) this.F8).put((MapProviderFactory.Builder) DriverAppDisabledFragment.class, (Provider) this.G8).put((MapProviderFactory.Builder) LanguageSettingsFragment.class, (Provider) this.H8).put((MapProviderFactory.Builder) OrderHistoryDetailsFragment.class, (Provider) this.I8).put((MapProviderFactory.Builder) FileUploadConfirmationDialog.class, (Provider) this.J8).put((MapProviderFactory.Builder) RetryFileUploadFragment.class, (Provider) this.K8).put((MapProviderFactory.Builder) ActiveCampaignsFragment.class, (Provider) this.L8).put((MapProviderFactory.Builder) CustomPriceFragment.class, (Provider) this.M8).put((MapProviderFactory.Builder) PricePreviewFragment.class, (Provider) this.N8).put((MapProviderFactory.Builder) PastCampaignsFragment.class, (Provider) this.O8).put((MapProviderFactory.Builder) CampaignDetailsFragment.class, (Provider) this.S8).put((MapProviderFactory.Builder) ReferralCampaignDetailsFragment.class, (Provider) this.T8).put((MapProviderFactory.Builder) OptInChoiceFragment.class, (Provider) this.U8).put((MapProviderFactory.Builder) ScheduledOrdersFragment.class, (Provider) this.V8).put((MapProviderFactory.Builder) BoltClubListingFragment.class, (Provider) this.W8).put((MapProviderFactory.Builder) ScheduledOrderDetailsFragment.class, (Provider) this.X8).put((MapProviderFactory.Builder) OrderModalFragment.class, (Provider) this.Y8).put((MapProviderFactory.Builder) TripCancellationBottomSheetFragment.class, (Provider) this.Z8).put((MapProviderFactory.Builder) ScheduledOrdersGroupFragment.class, (Provider) this.a9).put((MapProviderFactory.Builder) DestinationFragment.class, (Provider) this.b9).put((MapProviderFactory.Builder) DriverDestinationSearchFragment.class, (Provider) this.c9).put((MapProviderFactory.Builder) DriverDestinationActiveStateFragment.class, (Provider) this.d9).put((MapProviderFactory.Builder) BoltClubOfferDetailsFragment.class, (Provider) this.e9).put((MapProviderFactory.Builder) OrderMenuDialogFragment.class, (Provider) this.f9).put((MapProviderFactory.Builder) AddStopBottomSheetDialogFragment.class, (Provider) this.g9).put((MapProviderFactory.Builder) ThemeSettingsFragment.class, (Provider) this.h9).put((MapProviderFactory.Builder) OptInChoiceActivationInfoFragment.class, (Provider) this.i9).put((MapProviderFactory.Builder) OrderDestinationFragment.class, (Provider) this.j9).put((MapProviderFactory.Builder) EarningsLandingFragment.class, (Provider) this.m9).put((MapProviderFactory.Builder) EarningsBreakdownFragment.class, (Provider) this.n9).put((MapProviderFactory.Builder) EarningsGoalFragment.class, (Provider) this.o9).put((MapProviderFactory.Builder) EarningsGoalExpensesFragment.class, (Provider) this.p9).put((MapProviderFactory.Builder) SafetyToolkitBottomSheetFragment.class, (Provider) this.r9).put((MapProviderFactory.Builder) EmergencyAssistHelpBottomSheetFragment.class, (Provider) this.s9).put((MapProviderFactory.Builder) DidYouGetHelpFragment.class, (Provider) this.t9).put((MapProviderFactory.Builder) ActiveIncidentDialogFragment.class, (Provider) this.u9).put((MapProviderFactory.Builder) AudioRecordingBottomSheetFragment.class, (Provider) this.v9).put((MapProviderFactory.Builder) EarningsBalanceFragment.class, (Provider) this.w9).put((MapProviderFactory.Builder) RequestWebUrlFragment.class, (Provider) this.x9).put((MapProviderFactory.Builder) EarningsPayoutExplanationFragment.class, (Provider) this.y9).put((MapProviderFactory.Builder) MapSettingsFragment.class, (Provider) this.z9).put((MapProviderFactory.Builder) HowToRequestPayoutFragment.class, (Provider) this.A9).put((MapProviderFactory.Builder) MapExplanationFragment.class, (Provider) this.B9).build();
            this.C9 = build;
            DelegateFactory.setDelegate(this.f20476k7, AuthorisedUiModule_ProvideAuthFragmentFactoryFactory.a(authorisedUiModule, build));
            this.D9 = NavigatorChooserDelegate_Factory.a(this.f20477l, this.f20433g0);
            this.E9 = PushDialogDelegate_Factory.a(this.z8, this.f20521p7);
            this.F9 = OnBoardingDelegate_Factory.a(this.f20460j0);
            this.G9 = new ApproutingProvider(applicationComponent);
            this.H9 = new DeeplinkHomeContainerCoordinatorProvider(applicationComponent);
            DelegateFactory.setDelegate(this.f20467j7, HomeFragment_Factory.a(this.U6, this.f20476k7, this.D9, this.E9, this.u7, TrainingDelegate_Factory.a(), this.f20490m3, this.F9, this.z8, this.G9, CarUnavailableDialogDelegate_Factory.a(), this.H9, this.x7));
            this.I9 = new PushManagerImplProvider(applicationComponent);
            ChatPushHandlerProvider chatPushHandlerProvider = new ChatPushHandlerProvider(applicationComponent);
            this.J9 = chatPushHandlerProvider;
            this.K9 = ChatPushHandlerWrapper_Factory.a(chatPushHandlerProvider);
            this.L9 = NewOrderPushHandler_Factory.a(this.f20444h2, this.f20516p2, this.G0);
            this.M9 = OrderTerminatedPushHandler_Factory.a(this.f20516p2);
            this.N9 = RateAppPushHandler_Factory.a(this.f20516p2, this.f20581x1, this.f20444h2, this.f20451i0);
            this.O9 = TipsPushHandler_Factory.a(this.f20516p2, this.f20581x1);
            this.P9 = VoipPushHandler_Factory.a(this.T0);
            this.Q9 = RouteUpdatePushHandler_Factory.a(this.f20444h2, this.f20516p2, this.G0);
            this.R9 = ScheduledOrderPushHandler_Factory.a(this.f20516p2, this.f20451i0);
            this.S9 = SetFactory.builder(8, 0).addProvider(this.K9).addProvider(this.L9).addProvider(this.M9).addProvider(this.N9).addProvider(this.O9).addProvider(this.P9).addProvider(this.Q9).addProvider(this.R9).build();
            this.T9 = FcmCleverTapPushTokenHandler_Factory.a(this.T4);
            SetFactory build2 = SetFactory.builder(2, 0).addProvider(this.T9).addProvider(InternalTokenHandler_Factory.a()).build();
            this.U9 = build2;
            this.V9 = AuthPushService_Factory.a(this.I9, this.S9, build2);
            this.W9 = new VerificationProvider(applicationComponent);
            IdentityVerificationManagerProvider identityVerificationManagerProvider = new IdentityVerificationManagerProvider(applicationComponent);
            this.X9 = identityVerificationManagerProvider;
            this.Y9 = DriverRestrictionManager_Factory.a(this.f20459j, this.Y, this.G0, this.T3, this.Q, this.W9, identityVerificationManagerProvider, this.J2);
            this.Z9 = new DriverAnalyticsProvider(applicationComponent);
            this.aa = new TokenManagerProvider(applicationComponent);
            this.ba = PollerModule_ProvidePollerServiceFactory.a(pollerModule, this.f20477l, this.f20471k2, this.f20480l2);
            this.ca = AuthService_Factory.a(this.S4, this.Q, this.f20468k, this.f20514p0, this.Y9, this.f20435g2, this.f20558u2, this.Z9, this.S, FirebaseRemoteConfigManager_Factory.a(), this.Y, this.aa, this.f20487m0, this.R1, this.ba);
            IdProviderProvider idProviderProvider = new IdProviderProvider(applicationComponent);
            this.da = idProviderProvider;
            this.ea = DeviceFingerprintCollector_Factory.a(this.f20459j, idProviderProvider);
            DeviceInfoApiProvider deviceInfoApiProvider = new DeviceInfoApiProvider(applicationComponent);
            this.fa = deviceInfoApiProvider;
            DeviceInfoClient_Factory a11 = DeviceInfoClient_Factory.a(deviceInfoApiProvider, this.E);
            this.ga = a11;
            DeviceFingerprintManager_Factory a12 = DeviceFingerprintManager_Factory.a(this.ea, a11);
            this.ha = a12;
            this.ia = DeviceFingerprintService_Factory.a(a12);
            MixpanelProvider mixpanelProvider = new MixpanelProvider(applicationComponent);
            this.ja = mixpanelProvider;
            this.ka = MixpanelService_Factory.a(mixpanelProvider);
            this.la = GeoService_Factory.a(this.f20434g1);
            this.ma = DoubleCheck.provider(CacheCleanupService_Factory.a(this.R1));
            this.na = DoubleCheck.provider(DriverDestinationsService_Factory.a(this.f20489m2, this.Z0));
            this.oa = DoubleCheck.provider(DriverStatusService_Factory.a(this.f20489m2, this.Y));
            this.pa = DoubleCheck.provider(PollingAnalyticsService_Factory.a(this.f20489m2, this.f20541s1));
            Provider<IncomingOrderRoutingCoordinator> provider = DoubleCheck.provider(IncomingOrderRoutingCoordinator_Factory.a(this.f20521p7, this.f20541s1));
            this.qa = provider;
            this.ra = OrderRoutingService_Factory.a(this.f20489m2, this.f20469k0, this.f20503n7, provider);
            this.sa = DoubleCheck.provider(PollingLoggerService_Factory.a(this.f20489m2, this.f20541s1));
            this.ta = DoubleCheck.provider(OrderAppRoutingService_Factory.a(this.f20444h2, this.G0, this.f20459j));
            this.ua = LocationStateService_Factory.a(this.f20434g1, this.Y9, this.f20451i0);
            this.va = DoubleCheck.provider(B2bService_Factory.a(this.f20489m2, this.D3));
            this.wa = DoubleCheck.provider(OrderTimerService_Factory.a(this.R1));
            this.xa = DoubleCheck.provider(OrderUpdaterService_Factory.a(this.f20489m2, this.T1));
            this.ya = DoubleCheck.provider(SurgeService_Factory.a(this.P, this.f20451i0, this.U, this.f20434g1));
            this.za = DoubleCheck.provider(StaticStopDetailsService_Factory.a(this.f20470k1, this.G0, this.R1));
            Provider<DynamicStopDetailsService> provider2 = DoubleCheck.provider(DynamicStopDetailsService_Factory.a(this.f20470k1, this.G0, this.R1));
            this.Aa = provider2;
            AuthorisedServicesModule_ProvideStopDetailsServiceFactory a13 = AuthorisedServicesModule_ProvideStopDetailsServiceFactory.a(authorisedServicesModule, this.za, provider2, this.f20468k);
            this.Ba = a13;
            this.Ca = RideStopPollerLaunchService_Factory.a(this.R1, a13);
            this.Da = DoubleCheck.provider(DispatchSettingsService_Factory.a(this.f20451i0, this.f20489m2, this.f20450i));
            Provider<AutoNavigationManager> provider3 = DoubleCheck.provider(AutoNavigationManager_Factory.a(this.f20477l, this.G3, this.f20444h2, this.f20469k0, this.f20522q));
            this.Ea = provider3;
            this.Fa = DoubleCheck.provider(AutoNavigationRoutingService_Factory.a(this.G0, provider3));
            ApiErrorsProvider apiErrorsProvider = new ApiErrorsProvider(applicationComponent);
            this.Ga = apiErrorsProvider;
            this.Ha = InvalidateTokenService_Factory.a(apiErrorsProvider, this.aa);
        }

        private void Z(AuthorisedCoreModule authorisedCoreModule, AuthorisedNetworkModule authorisedNetworkModule, AuthorisedServicesModule authorisedServicesModule, AuthorisedStaffModule authorisedStaffModule, AuthorisedUiModule authorisedUiModule, ThemeModule themeModule, DriverChatAuthorisedModule driverChatAuthorisedModule, StoriesModule storiesModule, PollerModule pollerModule, TripAudioRecordingModule tripAudioRecordingModule, ApplicationComponent applicationComponent, DriverConfig driverConfig, DriverSettings driverSettings, DriverFeatures driverFeatures, AnchoredTimeSource anchoredTimeSource) {
            this.Ia = DoubleCheck.provider(WorkingTimeUpdateService_Factory.a(this.f20451i0, this.f20424f0));
            this.Ja = DoubleCheck.provider(DriverStateService_Factory.a(this.f20451i0, this.Y));
            this.Ka = DriverBlockService_Factory.a(this.f20451i0, this.Y9);
            this.La = MockLocationService_Factory.a(this.f20434g1, this.Y9);
            this.Ma = DoubleCheck.provider(EmergencyAssistHelpProviderService_Factory.a(this.f20489m2, this.J1));
            this.Na = AwakeServiceLauncher_Factory.a(this.f20459j, this.f20451i0, this.f20477l, this.f20444h2, this.f20513p);
            this.Oa = DoubleCheck.provider(TransmissionService_Factory.a(this.f20451i0, this.f20434g1, this.G0, this.H3, this.S4));
            this.Pa = new BigQueryProvider(applicationComponent);
            this.Qa = new ApplogProvider(applicationComponent);
            this.Ra = new LogManagerProvider(applicationComponent);
            this.Sa = new DatabaseProvider(applicationComponent);
            this.Ta = InternalLog_Factory.a(this.f20504o);
            LogStorage_Factory a8 = LogStorage_Factory.a(this.Sa);
            this.Ua = a8;
            this.Va = DidNotRespondStrategy_Factory.a(a8, this.f20477l);
            this.Wa = OrderStateStrategy_Factory.a(this.f20477l, this.Ua);
            this.Xa = DriverWrongStateStrategy_Factory.a(this.Ua, this.f20477l);
            this.Ya = OrderWrongStateStrategy_Factory.a(this.Ua, this.f20477l);
            this.Za = LocationStrategy_Factory.a(this.Ua, this.f20468k);
            this.ab = ActivityLifecycleStrategy_Factory.a(this.Ua, this.f20477l);
            this.bb = DriverOfflineDetectionStrategy_Factory.a(this.Ua, this.f20477l);
            WebViewStrategy_Factory a9 = WebViewStrategy_Factory.a(this.f20477l, this.Ua);
            this.cb = a9;
            CompositeWatcher_Factory a10 = CompositeWatcher_Factory.a(this.f20477l, this.Va, this.Wa, this.Xa, this.Ya, this.Za, this.ab, this.bb, a9);
            this.db = a10;
            this.eb = LogSaver_Factory.a(this.Sa, this.Ta, a10);
            LogWorkerProvider logWorkerProvider = new LogWorkerProvider(applicationComponent);
            this.fb = logWorkerProvider;
            StorageConsumer_Factory a11 = StorageConsumer_Factory.a(this.eb, logWorkerProvider, LogFilter_Factory.a(), this.Ta, this.f20477l);
            this.gb = a11;
            this.hb = LogService_Factory.a(this.Q, this.Pa, this.Qa, this.Ra, a11, this.f20515p1);
            SessionProviderProvider sessionProviderProvider = new SessionProviderProvider(applicationComponent);
            this.ib = sessionProviderProvider;
            this.jb = SessionService_Factory.a(sessionProviderProvider, this.S4);
            this.kb = CleverTapService_Factory.a(this.S4, this.R, this.T4, this.f20459j, this.f20521p7);
            this.lb = DoubleCheck.provider(PollMessageService_Factory.a(this.f20489m2, this.B1));
            this.mb = NotificationCleanerService_Factory.a(this.f20489m2, this.f20521p7);
            this.nb = DoubleCheck.provider(ActiveCampaignInfoRefreshService_Factory.a(this.L));
            this.ob = DoubleCheck.provider(FifoQueueService_Factory.a(this.f20489m2, this.f20451i0, this.f20400c3));
            this.pb = DoubleCheck.provider(ThirdPartyIncidentService_Factory.a(this.J1, this.R, this.f20477l));
            this.qb = DoubleCheck.provider(AudioRecordingService_Factory.a(ScopeProvider_Factory.a(), DispatcherProvider_Factory.a(), this.G0, this.N1));
            this.rb = DoubleCheck.provider(HeatmapSettingService_Factory.a(this.f20450i, this.f20526q3, this.f20508o3, this.Q));
            SetFactory build = SetFactory.builder(43, 0).addProvider(this.V9).addProvider(this.ca).addProvider(this.ia).addProvider(this.ka).addProvider(this.la).addProvider(this.ma).addProvider(this.na).addProvider(this.oa).addProvider(this.pa).addProvider(this.ra).addProvider(this.sa).addProvider(this.ta).addProvider(this.ua).addProvider(this.f20575w3).addProvider(this.va).addProvider(this.wa).addProvider(this.xa).addProvider(this.ya).addProvider(this.Ca).addProvider(this.Da).addProvider(this.Fa).addProvider(this.Ha).addProvider(this.Ia).addProvider(this.Ja).addProvider(this.f20591y3).addProvider(this.Ka).addProvider(this.La).addProvider(this.T0).addProvider(this.Ma).addProvider(this.f20574w2).addProvider(this.Na).addProvider(this.Oa).addProvider(this.hb).addProvider(this.jb).addProvider(this.kb).addProvider(this.lb).addProvider(this.mb).addProvider(this.nb).addProvider(this.ob).addProvider(this.pb).addProvider(this.f20526q3).addProvider(this.qb).addProvider(this.rb).build();
            this.sb = build;
            this.tb = DoubleCheck.provider(AuthorisedServicesRunner_Factory.a(build));
            this.ub = DoubleCheck.provider(AuthorisedNetworkModule_ProvideBoltDriverVerificationRetrofitBuilderFactory.a(authorisedNetworkModule, this.f20539s, this.f20563v));
            StoryFragment_Factory a12 = StoryFragment_Factory.a(this.z7, this.J7);
            this.vb = a12;
            this.wb = StoriesModule_ProvideStoryFragmentFactory.a(storiesModule, a12);
            this.xb = StoriesModule_ProvideStorySetFragmentFactory.a(storiesModule, this.P7);
            this.yb = MessageMenuFragment_Factory.a(this.J7);
            this.zb = MessageMapper_Factory.a(this.f20501n5);
            this.Ab = new DelegateFactory();
            DelegateFactory delegateFactory = new DelegateFactory();
            this.Bb = delegateFactory;
            this.Cb = ConversationPagerFragment_Factory.a(this.z7, this.J7, delegateFactory);
            MapProviderFactory build2 = MapProviderFactory.builder(5).put((MapProviderFactory.Builder) StoryFragment.class, (Provider) this.wb).put((MapProviderFactory.Builder) StorySetFragment.class, (Provider) this.xb).put((MapProviderFactory.Builder) MessageMenuFragment.class, (Provider) this.yb).put((MapProviderFactory.Builder) ConversationFragment.class, (Provider) this.Ab).put((MapProviderFactory.Builder) ConversationPagerFragment.class, (Provider) this.Cb).build();
            this.Db = build2;
            DelegateFactory.setDelegate(this.Bb, AuthorisedCoreModule_ProvideFragmentFactoryFactory.a(authorisedCoreModule, build2));
            this.Eb = new ReadMessageInteractorProvider(applicationComponent);
            DriverChatAuthorisedModule_ChatLoggerFactory b8 = DriverChatAuthorisedModule_ChatLoggerFactory.b(driverChatAuthorisedModule);
            this.Fb = b8;
            this.Gb = ChatReadDelegate_Factory.a(this.Eb, b8);
            DjProvider djProvider = new DjProvider(applicationComponent);
            this.Hb = djProvider;
            DelegateFactory.setDelegate(this.Ab, ConversationFragment_Factory.a(this.z7, this.J7, this.zb, this.Bb, this.Gb, djProvider, this.f20469k0));
            this.Ib = DoubleCheck.provider(ExecutableDeeplinkManager_Factory.a(this.f20481l3, this.f20576w4, this.J2, this.f20466j6));
        }

        private ActiveRideActivity a0(ActiveRideActivity activeRideActivity) {
            BaseMvvmActivity_MembersInjector.c(activeRideActivity, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmActivity_MembersInjector.d(activeRideActivity, N0());
            BaseMvvmActivity_MembersInjector.b(activeRideActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            BaseMvvmActivity_MembersInjector.a(activeRideActivity, b());
            ActiveRideActivity_MembersInjector.b(activeRideActivity, Q());
            ActiveRideActivity_MembersInjector.d(activeRideActivity, (DriverProvider) Preconditions.checkNotNullFromComponent(this.f20378a.t()));
            ActiveRideActivity_MembersInjector.c(activeRideActivity, this.f20396c);
            ActiveRideActivity_MembersInjector.j(activeRideActivity, L0());
            ActiveRideActivity_MembersInjector.e(activeRideActivity, (ErrorHandler) Preconditions.checkNotNullFromComponent(this.f20378a.d0()));
            ActiveRideActivity_MembersInjector.h(activeRideActivity, E0());
            ActiveRideActivity_MembersInjector.k(activeRideActivity, N());
            ActiveRideActivity_MembersInjector.g(activeRideActivity, (LanguageManager) Preconditions.checkNotNullFromComponent(this.f20378a.a()));
            ActiveRideActivity_MembersInjector.a(activeRideActivity, J());
            ActiveRideActivity_MembersInjector.i(activeRideActivity, (RoutingManager) Preconditions.checkNotNullFromComponent(this.f20378a.A()));
            ActiveRideActivity_MembersInjector.f(activeRideActivity, (HtmlEngine) Preconditions.checkNotNullFromComponent(this.f20378a.j0()));
            return activeRideActivity;
        }

        private AudioRecordingBottomSheetFragment b0(AudioRecordingBottomSheetFragment audioRecordingBottomSheetFragment) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(audioRecordingBottomSheetFragment, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(audioRecordingBottomSheetFragment, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(audioRecordingBottomSheetFragment, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            return audioRecordingBottomSheetFragment;
        }

        private CallBackFragment c0(CallBackFragment callBackFragment) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(callBackFragment, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(callBackFragment, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(callBackFragment, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            CallBackFragment_MembersInjector.a(callBackFragment, O0());
            return callBackFragment;
        }

        private CarChooserActivity d0(CarChooserActivity carChooserActivity) {
            BaseMvvmActivity_MembersInjector.c(carChooserActivity, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmActivity_MembersInjector.d(carChooserActivity, N0());
            BaseMvvmActivity_MembersInjector.b(carChooserActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            BaseMvvmActivity_MembersInjector.a(carChooserActivity, b());
            CarChooserActivity_MembersInjector.b(carChooserActivity, N());
            CarChooserActivity_MembersInjector.a(carChooserActivity, J());
            return carChooserActivity;
        }

        private ContactMethodsBaseActivity e0(ContactMethodsBaseActivity contactMethodsBaseActivity) {
            BaseActivity_MembersInjector.b(contactMethodsBaseActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            BaseActivity_MembersInjector.a(contactMethodsBaseActivity, b());
            ContactMethodsBaseActivity_MembersInjector.a(contactMethodsBaseActivity, J());
            return contactMethodsBaseActivity;
        }

        private ContactOptionsFragment f0(ContactOptionsFragment contactOptionsFragment) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(contactOptionsFragment, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(contactOptionsFragment, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(contactOptionsFragment, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            ContactOptionsFragment_MembersInjector.c(contactOptionsFragment, O0());
            ContactOptionsFragment_MembersInjector.a(contactOptionsFragment, (Features) Preconditions.checkNotNullFromComponent(this.f20378a.z()));
            ContactOptionsFragment_MembersInjector.b(contactOptionsFragment, (RoutingManager) Preconditions.checkNotNullFromComponent(this.f20378a.A()));
            return contactOptionsFragment;
        }

        private ConversationActivity g0(ConversationActivity conversationActivity) {
            eu.bolt.driver.core.ui.base.activity.BaseActivity_MembersInjector.a(conversationActivity, O());
            eu.bolt.driver.core.ui.base.activity.BaseActivity_MembersInjector.b(conversationActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            BaseAuthorisedActivity_MembersInjector.a(conversationActivity, (RoutingManager) Preconditions.checkNotNullFromComponent(this.f20378a.A()));
            ConversationActivity_MembersInjector.a(conversationActivity, K0());
            return conversationActivity;
        }

        private DestinationEditBottomDialogFragment h0(DestinationEditBottomDialogFragment destinationEditBottomDialogFragment) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(destinationEditBottomDialogFragment, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(destinationEditBottomDialogFragment, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(destinationEditBottomDialogFragment, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            return destinationEditBottomDialogFragment;
        }

        private DidYouGetHelpFragment i0(DidYouGetHelpFragment didYouGetHelpFragment) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(didYouGetHelpFragment, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(didYouGetHelpFragment, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(didYouGetHelpFragment, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            return didYouGetHelpFragment;
        }

        private DispatchSettingsDialog j0(DispatchSettingsDialog dispatchSettingsDialog) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(dispatchSettingsDialog, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(dispatchSettingsDialog, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(dispatchSettingsDialog, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            return dispatchSettingsDialog;
        }

        private EarningsActivity k0(EarningsActivity earningsActivity) {
            BaseMvvmActivity_MembersInjector.c(earningsActivity, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmActivity_MembersInjector.d(earningsActivity, N0());
            BaseMvvmActivity_MembersInjector.b(earningsActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            BaseMvvmActivity_MembersInjector.a(earningsActivity, b());
            EarningsActivity_MembersInjector.c(earningsActivity, (DriverProvider) Preconditions.checkNotNullFromComponent(this.f20378a.t()));
            EarningsActivity_MembersInjector.a(earningsActivity, J());
            EarningsActivity_MembersInjector.b(earningsActivity, this.f20414e);
            return earningsActivity;
        }

        private EmergencyAssistHelpBottomSheetFragment l0(EmergencyAssistHelpBottomSheetFragment emergencyAssistHelpBottomSheetFragment) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(emergencyAssistHelpBottomSheetFragment, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(emergencyAssistHelpBottomSheetFragment, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(emergencyAssistHelpBottomSheetFragment, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            return emergencyAssistHelpBottomSheetFragment;
        }

        private IncomingCallFragment m0(IncomingCallFragment incomingCallFragment) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(incomingCallFragment, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(incomingCallFragment, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(incomingCallFragment, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            IncomingCallFragment_MembersInjector.b(incomingCallFragment, O0());
            IncomingCallFragment_MembersInjector.a(incomingCallFragment, S());
            return incomingCallFragment;
        }

        private IncomingOrderActivity n0(IncomingOrderActivity incomingOrderActivity) {
            IncomingOrderActivity_MembersInjector.a(incomingOrderActivity, J());
            return incomingOrderActivity;
        }

        private InprogressCallFragment o0(InprogressCallFragment inprogressCallFragment) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(inprogressCallFragment, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(inprogressCallFragment, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(inprogressCallFragment, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            return inprogressCallFragment;
        }

        private InviteDriversActivity p0(InviteDriversActivity inviteDriversActivity) {
            BaseActivity_MembersInjector.b(inviteDriversActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            BaseActivity_MembersInjector.a(inviteDriversActivity, b());
            InviteDriversActivity_MembersInjector.a(inviteDriversActivity, (ReferralCampaignsAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.S()));
            return inviteDriversActivity;
        }

        private ModeChooserBottomDialog q0(ModeChooserBottomDialog modeChooserBottomDialog) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(modeChooserBottomDialog, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(modeChooserBottomDialog, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(modeChooserBottomDialog, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            return modeChooserBottomDialog;
        }

        private NoAnswerFragment r0(NoAnswerFragment noAnswerFragment) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(noAnswerFragment, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(noAnswerFragment, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(noAnswerFragment, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            return noAnswerFragment;
        }

        private PayoutDetailsActivity s0(PayoutDetailsActivity payoutDetailsActivity) {
            BaseMvvmActivity_MembersInjector.c(payoutDetailsActivity, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmActivity_MembersInjector.d(payoutDetailsActivity, N0());
            BaseMvvmActivity_MembersInjector.b(payoutDetailsActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            BaseMvvmActivity_MembersInjector.a(payoutDetailsActivity, b());
            return payoutDetailsActivity;
        }

        private PermissionOnboardingActivity t0(PermissionOnboardingActivity permissionOnboardingActivity) {
            BaseActivity_MembersInjector.b(permissionOnboardingActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            BaseActivity_MembersInjector.a(permissionOnboardingActivity, b());
            PermissionOnboardingActivity_MembersInjector.e(permissionOnboardingActivity, (AppRoutingManager) Preconditions.checkNotNullFromComponent(this.f20378a.g0()));
            PermissionOnboardingActivity_MembersInjector.b(permissionOnboardingActivity, (DriverProvider) Preconditions.checkNotNullFromComponent(this.f20378a.t()));
            PermissionOnboardingActivity_MembersInjector.d(permissionOnboardingActivity, (OnBoardingManager) Preconditions.checkNotNullFromComponent(this.f20378a.i1()));
            PermissionOnboardingActivity_MembersInjector.c(permissionOnboardingActivity, (LoginAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.i()));
            PermissionOnboardingActivity_MembersInjector.a(permissionOnboardingActivity, J());
            return permissionOnboardingActivity;
        }

        private RateCallFragment u0(RateCallFragment rateCallFragment) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(rateCallFragment, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(rateCallFragment, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(rateCallFragment, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            return rateCallFragment;
        }

        private RateMeDialog v0(RateMeDialog rateMeDialog) {
            RateMeDialog_MembersInjector.e(rateMeDialog, F0());
            RateMeDialog_MembersInjector.a(rateMeDialog, (DriverProvider) Preconditions.checkNotNullFromComponent(this.f20378a.t()));
            RateMeDialog_MembersInjector.d(rateMeDialog, I());
            RateMeDialog_MembersInjector.b(rateMeDialog, (Features) Preconditions.checkNotNullFromComponent(this.f20378a.z()));
            RateMeDialog_MembersInjector.c(rateMeDialog, (PlatformManager) Preconditions.checkNotNullFromComponent(this.f20378a.D1()));
            return rateMeDialog;
        }

        private RideFinishActivity w0(RideFinishActivity rideFinishActivity) {
            BaseMvvmActivity_MembersInjector.c(rideFinishActivity, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmActivity_MembersInjector.d(rideFinishActivity, N0());
            BaseMvvmActivity_MembersInjector.b(rideFinishActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            BaseMvvmActivity_MembersInjector.a(rideFinishActivity, b());
            RideFinishActivity_MembersInjector.a(rideFinishActivity, J());
            return rideFinishActivity;
        }

        private SafetyToolkitBottomSheetFragment x0(SafetyToolkitBottomSheetFragment safetyToolkitBottomSheetFragment) {
            BaseMvvmBottomSheetDialogFragment_MembersInjector.b(safetyToolkitBottomSheetFragment, (ScreenAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.J1()));
            BaseMvvmBottomSheetDialogFragment_MembersInjector.c(safetyToolkitBottomSheetFragment, N0());
            BaseMvvmBottomSheetDialogFragment_MembersInjector.a(safetyToolkitBottomSheetFragment, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            return safetyToolkitBottomSheetFragment;
        }

        private SimpleActivity y0(SimpleActivity simpleActivity) {
            SimpleActivity_MembersInjector.c(simpleActivity, b());
            SimpleActivity_MembersInjector.b(simpleActivity, P());
            SimpleActivity_MembersInjector.a(simpleActivity, J());
            return simpleActivity;
        }

        private SimpleAuthorisedActivity z0(SimpleAuthorisedActivity simpleAuthorisedActivity) {
            eu.bolt.driver.core.ui.base.activity.BaseActivity_MembersInjector.a(simpleAuthorisedActivity, O());
            eu.bolt.driver.core.ui.base.activity.BaseActivity_MembersInjector.b(simpleAuthorisedActivity, (PermissionManager) Preconditions.checkNotNullFromComponent(this.f20378a.i0()));
            BaseAuthorisedActivity_MembersInjector.a(simpleAuthorisedActivity, (RoutingManager) Preconditions.checkNotNullFromComponent(this.f20378a.A()));
            SimpleAuthorisedActivity_MembersInjector.b(simpleAuthorisedActivity, K0());
            SimpleAuthorisedActivity_MembersInjector.a(simpleAuthorisedActivity, (LanguageManager) Preconditions.checkNotNullFromComponent(this.f20378a.a()));
            return simpleAuthorisedActivity;
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void A(CarChooserActivity carChooserActivity) {
            d0(carChooserActivity);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void B(SafetyToolkitBottomSheetFragment safetyToolkitBottomSheetFragment) {
            x0(safetyToolkitBottomSheetFragment);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void C(ModeChooserBottomDialog modeChooserBottomDialog) {
            q0(modeChooserBottomDialog);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void D(PayoutDetailsActivity payoutDetailsActivity) {
            s0(payoutDetailsActivity);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void E(RideFinishActivity rideFinishActivity) {
            w0(rideFinishActivity);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public AuthorisedServicesRunner F() {
            return this.tb.get();
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void G(PermissionOnboardingActivity permissionOnboardingActivity) {
            t0(permissionOnboardingActivity);
        }

        public RateMeDialogDelegate G0() {
            return new RateMeDialogDelegate(F0(), I());
        }

        @Override // eu.bolt.driver.core.di.scope.authorized.AuthorizedCoreComponent
        public TranslationHelper H() {
            return AuthorisedCoreModule_ProvideTranslationHelperFactory.a(this.f20423f);
        }

        public CoreFragmentFactory O() {
            return AuthorisedCoreModule_ProvideFragmentFactoryFactory.c(this.f20423f, D0());
        }

        @Override // eu.bolt.driver.core.di.scope.authorized.AuthorizedCoreComponent
        public eu.bolt.driver.core.language.LanguageManager a() {
            return AuthorisedCoreModule_ProvideLanguageManagerFactory.a(this.f20423f, (DriverProvider) Preconditions.checkNotNullFromComponent(this.f20378a.t()), (Context) Preconditions.checkNotNullFromComponent(this.f20378a.A0()), new LanguageListProviderImpl());
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public FragmentFactory b() {
            return AuthorisedUiModule_ProvideAuthFragmentFactoryFactory.c(this.f20387b, K());
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void c(RateCallFragment rateCallFragment) {
            u0(rateCallFragment);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void d(InviteDriversActivity inviteDriversActivity) {
            p0(inviteDriversActivity);
        }

        @Override // eu.bolt.driver.chat.di.DriverChatAutorisedComponent
        public void e(ConversationActivity conversationActivity) {
            g0(conversationActivity);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void f(EmergencyAssistHelpBottomSheetFragment emergencyAssistHelpBottomSheetFragment) {
            l0(emergencyAssistHelpBottomSheetFragment);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void g(EarningsActivity earningsActivity) {
            k0(earningsActivity);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void h(IncomingOrderActivity incomingOrderActivity) {
            n0(incomingOrderActivity);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void i(ContactOptionsFragment contactOptionsFragment) {
            f0(contactOptionsFragment);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void j(ContactMethodsBaseActivity contactMethodsBaseActivity) {
            e0(contactMethodsBaseActivity);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void k(ActiveRideActivity activeRideActivity) {
            a0(activeRideActivity);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void l(NoAnswerFragment noAnswerFragment) {
            r0(noAnswerFragment);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void m(DestinationEditBottomDialogFragment destinationEditBottomDialogFragment) {
            h0(destinationEditBottomDialogFragment);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void n(IncomingCallFragment incomingCallFragment) {
            m0(incomingCallFragment);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void o(SimpleActivity simpleActivity) {
            y0(simpleActivity);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void p(DidYouGetHelpFragment didYouGetHelpFragment) {
            i0(didYouGetHelpFragment);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void q(RateMeDialog rateMeDialog) {
            v0(rateMeDialog);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void r(AudioRecordingBottomSheetFragment audioRecordingBottomSheetFragment) {
            b0(audioRecordingBottomSheetFragment);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void s(InprogressCallFragment inprogressCallFragment) {
            o0(inprogressCallFragment);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void t(VoipCallErrorFragment voipCallErrorFragment) {
            A0(voipCallErrorFragment);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void u(VoipFloatingActivity voipFloatingActivity) {
            B0(voipFloatingActivity);
        }

        @Override // eu.bolt.driver.core.di.scope.authorized.AuthorizedCoreComponent
        public void v(SimpleAuthorisedActivity simpleAuthorisedActivity) {
            z0(simpleAuthorisedActivity);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void w(CallBackFragment callBackFragment) {
            c0(callBackFragment);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public void x(DispatchSettingsDialog dispatchSettingsDialog) {
            j0(dispatchSettingsDialog);
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedComponent
        public ExecutableDeeplinkManager y() {
            return this.Ib.get();
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent
        public IdentityVerificationInitializer z() {
            return new IdentityVerificationInitializer(M0(), this.ub.get(), (DeviceInfo) Preconditions.checkNotNullFromComponent(this.f20378a.l()), (LanguageManager) Preconditions.checkNotNullFromComponent(this.f20378a.a()), (TokenManager) Preconditions.checkNotNullFromComponent(this.f20378a.T1()), (VerificationAnalytics) Preconditions.checkNotNullFromComponent(this.f20378a.P1()), (DriverProvider) Preconditions.checkNotNullFromComponent(this.f20378a.t()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Builder implements AuthorisedComponent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private DriverConfig f20721a;

        /* renamed from: b  reason: collision with root package name */
        private DriverSettings f20722b;

        /* renamed from: c  reason: collision with root package name */
        private DriverFeatures f20723c;

        /* renamed from: d  reason: collision with root package name */
        private AnchoredTimeSource f20724d;

        /* renamed from: e  reason: collision with root package name */
        private ApplicationComponent f20725e;

        private Builder() {
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent.Builder
        public AuthorisedComponent build() {
            Preconditions.checkBuilderRequirement(this.f20721a, DriverConfig.class);
            Preconditions.checkBuilderRequirement(this.f20722b, DriverSettings.class);
            Preconditions.checkBuilderRequirement(this.f20723c, DriverFeatures.class);
            Preconditions.checkBuilderRequirement(this.f20724d, AnchoredTimeSource.class);
            Preconditions.checkBuilderRequirement(this.f20725e, ApplicationComponent.class);
            return new AuthorisedComponentImpl(new AuthorisedCoreModule(), new AuthorisedNetworkModule(), new AuthorisedServicesModule(), new AuthorisedStaffModule(), new AuthorisedUiModule(), new ThemeModule(), new DriverChatAuthorisedModule(), new StoriesModule(), new PollerModule(), new TripAudioRecordingModule(), this.f20725e, this.f20721a, this.f20722b, this.f20723c, this.f20724d);
        }

        @Override // ee.mtakso.driver.di.authorised.MainAuthorisedComponent.Builder
        /* renamed from: f */
        public Builder e(ApplicationComponent applicationComponent) {
            this.f20725e = (ApplicationComponent) Preconditions.checkNotNull(applicationComponent);
            return this;
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedComponent.Builder, ee.mtakso.driver.di.authorised.MainAuthorisedComponent.Builder
        /* renamed from: g */
        public Builder d(DriverConfig driverConfig) {
            this.f20721a = (DriverConfig) Preconditions.checkNotNull(driverConfig);
            return this;
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedComponent.Builder, ee.mtakso.driver.di.authorised.MainAuthorisedComponent.Builder
        /* renamed from: h */
        public Builder a(DriverFeatures driverFeatures) {
            this.f20723c = (DriverFeatures) Preconditions.checkNotNull(driverFeatures);
            return this;
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedComponent.Builder, ee.mtakso.driver.di.authorised.MainAuthorisedComponent.Builder
        /* renamed from: i */
        public Builder b(DriverSettings driverSettings) {
            this.f20722b = (DriverSettings) Preconditions.checkNotNull(driverSettings);
            return this;
        }

        @Override // ee.mtakso.driver.di.authorised.AuthorisedComponent.Builder, ee.mtakso.driver.di.authorised.MainAuthorisedComponent.Builder
        /* renamed from: j */
        public Builder c(AnchoredTimeSource anchoredTimeSource) {
            this.f20724d = (AnchoredTimeSource) Preconditions.checkNotNull(anchoredTimeSource);
            return this;
        }
    }

    private DaggerAuthorisedComponent() {
    }

    public static AuthorisedComponent.Builder a() {
        return new Builder();
    }
}
