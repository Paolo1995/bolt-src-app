package ee.mtakso.driver.di.authorised;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import ee.mtakso.driver.log.LogService;
import ee.mtakso.driver.service.AwakeServiceLauncher;
import ee.mtakso.driver.service.BaseService;
import ee.mtakso.driver.service.auth.AuthService;
import ee.mtakso.driver.service.auth.audiorecording.AudioRecordingService;
import ee.mtakso.driver.service.b2b.B2bService;
import ee.mtakso.driver.service.campaign.ActiveCampaignInfoRefreshService;
import ee.mtakso.driver.service.contact.ContactOptionsService;
import ee.mtakso.driver.service.device.fingerprint.DeviceFingerprintService;
import ee.mtakso.driver.service.driver.DriverStateService;
import ee.mtakso.driver.service.geo.GeoService;
import ee.mtakso.driver.service.geo.transmitter.TransmissionService;
import ee.mtakso.driver.service.integration.clevertap.CleverTapService;
import ee.mtakso.driver.service.integration.mixpanel.MixpanelService;
import ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsService;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistHelpProviderService;
import ee.mtakso.driver.service.modules.fifo.FifoQueueService;
import ee.mtakso.driver.service.modules.map.HeatmapSettingService;
import ee.mtakso.driver.service.modules.map.MapsConfigsService;
import ee.mtakso.driver.service.modules.order.v2.PollingAnalyticsService;
import ee.mtakso.driver.service.modules.order.v2.RideStopPollerLaunchService;
import ee.mtakso.driver.service.modules.polling.PollingLoggerService;
import ee.mtakso.driver.service.modules.reminder.AutoReminder;
import ee.mtakso.driver.service.modules.reminder.AutoReminderImpl;
import ee.mtakso.driver.service.modules.status.DriverStatusService;
import ee.mtakso.driver.service.modules.surge.SurgeService;
import ee.mtakso.driver.service.order.details.CacheCleanupService;
import ee.mtakso.driver.service.order.details.OrderTimerService;
import ee.mtakso.driver.service.order.details.OrderUpdaterService;
import ee.mtakso.driver.service.order.routing.OrderRoutingService;
import ee.mtakso.driver.service.polling.message.PollMessageService;
import ee.mtakso.driver.service.push.AuthPushService;
import ee.mtakso.driver.service.restriction.DriverBlockService;
import ee.mtakso.driver.service.restriction.LocationStateService;
import ee.mtakso.driver.service.restriction.MockLocationService;
import ee.mtakso.driver.service.routing.AutoNavigationRoutingService;
import ee.mtakso.driver.service.routing.OrderAppRoutingService;
import ee.mtakso.driver.service.session.SessionService;
import ee.mtakso.driver.service.settings.DispatchSettingsService;
import ee.mtakso.driver.service.thirdparty_incident.ThirdPartyIncidentService;
import ee.mtakso.driver.service.token.InvalidateTokenService;
import ee.mtakso.driver.service.voip.VoipService;
import ee.mtakso.driver.service.workingtime.WorkingTimeUpdateService;
import ee.mtakso.driver.ui.notification.NotificationCleanerService;

/* compiled from: AuthorisedServicesBindings.kt */
@Module
/* loaded from: classes3.dex */
public interface AuthorisedServicesBindings {
    @Binds
    @IntoSet
    BaseService A(GeoService geoService);

    @Binds
    @IntoSet
    BaseService B(PollMessageService pollMessageService);

    @Binds
    @IntoSet
    BaseService C(DriverBlockService driverBlockService);

    @Binds
    @IntoSet
    BaseService D(DriverStateService driverStateService);

    @Binds
    @IntoSet
    BaseService E(MapsConfigsService mapsConfigsService);

    @Binds
    @IntoSet
    BaseService F(TransmissionService transmissionService);

    @Binds
    @IntoSet
    BaseService G(AwakeServiceLauncher awakeServiceLauncher);

    @Binds
    @IntoSet
    BaseService H(ContactOptionsService contactOptionsService);

    @Binds
    @IntoSet
    BaseService I(WorkingTimeUpdateService workingTimeUpdateService);

    @Binds
    @IntoSet
    BaseService J(FifoQueueService fifoQueueService);

    @Binds
    @IntoSet
    BaseService K(VoipService voipService);

    @Binds
    @IntoSet
    BaseService L(OrderAppRoutingService orderAppRoutingService);

    @Binds
    @IntoSet
    BaseService M(OrderUpdaterService orderUpdaterService);

    @Binds
    @IntoSet
    BaseService N(AutoNavigationRoutingService autoNavigationRoutingService);

    @Binds
    @IntoSet
    BaseService O(AuthService authService);

    @Binds
    @IntoSet
    BaseService P(LogService logService);

    @Binds
    @IntoSet
    BaseService Q(DriverDestinationsService driverDestinationsService);

    @Binds
    @IntoSet
    BaseService R(HeatmapSettingService heatmapSettingService);

    @Binds
    @IntoSet
    BaseService a(AutoReminderImpl autoReminderImpl);

    @Binds
    @IntoSet
    BaseService b(EmergencyAssistHelpProviderService emergencyAssistHelpProviderService);

    @Binds
    @IntoSet
    BaseService c(B2bService b2bService);

    @Binds
    @IntoSet
    BaseService d(InvalidateTokenService invalidateTokenService);

    @Binds
    @IntoSet
    BaseService e(OrderTimerService orderTimerService);

    @Binds
    @IntoSet
    BaseService f(CleverTapService cleverTapService);

    @Binds
    @IntoSet
    BaseService g(CacheCleanupService cacheCleanupService);

    @Binds
    @IntoSet
    BaseService h(PollingLoggerService pollingLoggerService);

    @Binds
    @IntoSet
    BaseService i(DriverStatusService driverStatusService);

    @Binds
    @IntoSet
    BaseService j(LocationStateService locationStateService);

    @Binds
    @IntoSet
    BaseService k(DeviceFingerprintService deviceFingerprintService);

    @Binds
    @IntoSet
    BaseService l(UpcomingStopDistanceService upcomingStopDistanceService);

    @Binds
    @IntoSet
    BaseService m(OrderRoutingService orderRoutingService);

    @Binds
    AutoReminder n(AutoReminderImpl autoReminderImpl);

    @Binds
    @IntoSet
    BaseService o(PollingAnalyticsService pollingAnalyticsService);

    @Binds
    @IntoSet
    BaseService p(AuthPushService authPushService);

    @Binds
    @IntoSet
    BaseService q(AudioRecordingService audioRecordingService);

    @Binds
    @IntoSet
    BaseService r(ActiveCampaignInfoRefreshService activeCampaignInfoRefreshService);

    @Binds
    @IntoSet
    BaseService s(MockLocationService mockLocationService);

    @Binds
    @IntoSet
    BaseService t(ThirdPartyIncidentService thirdPartyIncidentService);

    @Binds
    @IntoSet
    BaseService u(DispatchSettingsService dispatchSettingsService);

    @Binds
    @IntoSet
    BaseService v(RideStopPollerLaunchService rideStopPollerLaunchService);

    @Binds
    @IntoSet
    BaseService w(MixpanelService mixpanelService);

    @Binds
    @IntoSet
    BaseService x(SurgeService surgeService);

    @Binds
    @IntoSet
    BaseService y(NotificationCleanerService notificationCleanerService);

    @Binds
    @IntoSet
    BaseService z(SessionService sessionService);
}
