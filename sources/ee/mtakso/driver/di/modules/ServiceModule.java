package ee.mtakso.driver.di.modules;

import android.os.SystemClock;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.deeplink.DeepLinkParser;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.ObservableService;
import ee.mtakso.driver.service.deviceinfo.DeviceInfoSender;
import ee.mtakso.driver.service.deviceinfo.DriverDeviceInfoSender;
import ee.mtakso.driver.service.modules.polling.Poller;
import ee.mtakso.driver.service.modules.polling.PollerImpl;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import ee.mtakso.driver.service.modules.status.DriverStatusSenderImpl;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.service.time.AnchoredTrueTimeProvider;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.service.time.clock.Clock;
import javax.inject.Singleton;

@Module
/* loaded from: classes3.dex */
public abstract class ServiceModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public static DeepLinkManager e(DeepLinkParser deepLinkParser) {
        return new DeepLinkManager(deepLinkParser);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public static DeepLinkParser f() {
        return new DeepLinkParser();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @Singleton
    public static AnchoredTrueTimeProvider j() {
        return new AnchoredTrueTimeProvider(new Clock() { // from class: ee.mtakso.driver.di.modules.a
            @Override // ee.mtakso.driver.service.time.clock.Clock
            public final long a() {
                return SystemClock.elapsedRealtime();
            }
        }, new Clock() { // from class: ee.mtakso.driver.di.modules.b
            @Override // ee.mtakso.driver.service.time.clock.Clock
            public final long a() {
                return System.currentTimeMillis();
            }
        });
    }

    @Binds
    abstract DriverStatusProvider a(DriverStatusSenderImpl driverStatusSenderImpl);

    @Binds
    abstract OrderProvider b(OrdersCache ordersCache);

    @Binds
    abstract Poller c(PollerImpl pollerImpl);

    @Binds
    abstract ObservableService<PollingSigned<PollingResult>> d(PollerImpl pollerImpl);

    @Binds
    abstract DeviceInfoSender g(DriverDeviceInfoSender driverDeviceInfoSender);

    @Binds
    abstract DriverStatusSender h(DriverStatusSenderImpl driverStatusSenderImpl);

    @Binds
    abstract TrueTimeProvider i(AnchoredTrueTimeProvider anchoredTrueTimeProvider);
}
