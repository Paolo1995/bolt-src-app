package ee.mtakso.driver.service.modules.polling;

import ee.mtakso.driver.di.modules.TimingHooks;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.ObservableService;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.polling.dynamic.DynamicPollerImpl;
import ee.mtakso.driver.service.modules.polling.v2.BasePollerImpl;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.utils.BackgroundManager;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PollerFactory.kt */
/* loaded from: classes3.dex */
public final class PollerFactory {

    /* renamed from: a  reason: collision with root package name */
    private final TimingHooks f25100a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverClient f25101b;

    /* renamed from: c  reason: collision with root package name */
    private final OrdersCache f25102c;

    /* renamed from: d  reason: collision with root package name */
    private final BackgroundManager f25103d;

    /* renamed from: e  reason: collision with root package name */
    private final DriverProvider f25104e;

    /* renamed from: f  reason: collision with root package name */
    private final PollingRetryStrategy f25105f;

    /* renamed from: g  reason: collision with root package name */
    private final GeoLocationManager f25106g;

    @Inject
    public PollerFactory(TimingHooks hooks, DriverClient apiClient, OrdersCache orderCache, BackgroundManager backgroundManager, DriverProvider driverProvider, PollingRetryStrategy pollingRetryStrategy, GeoLocationManager locationManager) {
        Intrinsics.f(hooks, "hooks");
        Intrinsics.f(apiClient, "apiClient");
        Intrinsics.f(orderCache, "orderCache");
        Intrinsics.f(backgroundManager, "backgroundManager");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(pollingRetryStrategy, "pollingRetryStrategy");
        Intrinsics.f(locationManager, "locationManager");
        this.f25100a = hooks;
        this.f25101b = apiClient;
        this.f25102c = orderCache;
        this.f25103d = backgroundManager;
        this.f25104e = driverProvider;
        this.f25105f = pollingRetryStrategy;
        this.f25106g = locationManager;
    }

    public final ObservableService<PollingSigned<PollingResult>> a(long j8, String loggingKey, Consumer<Throwable> errorConsumer) {
        Intrinsics.f(loggingKey, "loggingKey");
        Intrinsics.f(errorConsumer, "errorConsumer");
        if (this.f25104e.p().s()) {
            return new DynamicPollerImpl(this.f25105f, errorConsumer, j8, this.f25102c, this.f25101b, this.f25103d, this.f25106g, this.f25104e, loggingKey);
        }
        return new BasePollerImpl(j8, this.f25100a, this.f25101b, this.f25105f, this.f25102c, errorConsumer, loggingKey, this.f25103d, this.f25106g, this.f25104e);
    }
}
