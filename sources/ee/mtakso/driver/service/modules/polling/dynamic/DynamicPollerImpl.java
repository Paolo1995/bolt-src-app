package ee.mtakso.driver.service.modules.polling.dynamic;

import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.polling.Poller;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.utils.BackgroundManager;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.polling.DynamicPoller;
import ee.mtakso.driver.utils.polling.RepeatStrategy;
import ee.mtakso.driver.utils.polling.RetryStrategy;
import eu.bolt.kalev.Kalev;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicPollerImpl.kt */
/* loaded from: classes3.dex */
public final class DynamicPollerImpl implements Poller {

    /* renamed from: a  reason: collision with root package name */
    private final long f25142a;

    /* renamed from: b  reason: collision with root package name */
    private final OrdersCache f25143b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverClient f25144c;

    /* renamed from: d  reason: collision with root package name */
    private final BackgroundManager f25145d;

    /* renamed from: e  reason: collision with root package name */
    private final GeoLocationManager f25146e;

    /* renamed from: f  reason: collision with root package name */
    private final DriverProvider f25147f;

    /* renamed from: g  reason: collision with root package name */
    private final String f25148g;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicInteger f25149h;

    /* renamed from: i  reason: collision with root package name */
    private final DynamicPollerImpl$repeatStrategy$1 f25150i;

    /* renamed from: j  reason: collision with root package name */
    private final DynamicPoller<Optional<PollingSigned<PollingResult>>> f25151j;

    /* JADX WARN: Type inference failed for: r7v1, types: [ee.mtakso.driver.utils.polling.RepeatStrategy, ee.mtakso.driver.service.modules.polling.dynamic.DynamicPollerImpl$repeatStrategy$1] */
    public DynamicPollerImpl(RetryStrategy retryStrategy, Consumer<Throwable> errorHandler, long j8, OrdersCache ordersCache, DriverClient apiClient, BackgroundManager backgroundManager, GeoLocationManager locationManager, DriverProvider driverProvider, String loggingKey) {
        Intrinsics.f(retryStrategy, "retryStrategy");
        Intrinsics.f(errorHandler, "errorHandler");
        Intrinsics.f(ordersCache, "ordersCache");
        Intrinsics.f(apiClient, "apiClient");
        Intrinsics.f(backgroundManager, "backgroundManager");
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(loggingKey, "loggingKey");
        this.f25142a = j8;
        this.f25143b = ordersCache;
        this.f25144c = apiClient;
        this.f25145d = backgroundManager;
        this.f25146e = locationManager;
        this.f25147f = driverProvider;
        this.f25148g = loggingKey;
        this.f25149h = new AtomicInteger();
        ?? r7 = new RepeatStrategy<Optional<PollingSigned<PollingResult>>>() { // from class: ee.mtakso.driver.service.modules.polling.dynamic.DynamicPollerImpl$repeatStrategy$1
            @Override // ee.mtakso.driver.utils.polling.RepeatStrategy
            /* renamed from: b */
            public long a(Optional<PollingSigned<PollingResult>> item) {
                long j9;
                long j10;
                Intrinsics.f(item, "item");
                PollingSigned<PollingResult> c8 = item.c();
                if (c8 == null) {
                    j10 = DynamicPollerImpl.this.f25142a;
                    return j10;
                }
                Float g8 = c8.a().g();
                if (g8 == null) {
                    j9 = DynamicPollerImpl.this.f25142a;
                    return j9;
                }
                return g8.floatValue();
            }
        };
        this.f25150i = r7;
        DynamicPoller<Optional<PollingSigned<PollingResult>>> dynamicPoller = new DynamicPoller<>(new Callable() { // from class: ee.mtakso.driver.service.modules.polling.dynamic.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Optional l8;
                l8 = DynamicPollerImpl.l(DynamicPollerImpl.this);
                return l8;
            }
        }, r7, retryStrategy, null, 8, null);
        dynamicPoller.i().subscribe(errorHandler);
        this.f25151j = dynamicPoller;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Notification j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Notification) tmp0.invoke(obj);
    }

    private final Optional<PollingSigned<PollingResult>> k() {
        int incrementAndGet = this.f25149h.incrementAndGet();
        String str = this.f25148g;
        Kalev.b(str + " poller tick " + incrementAndGet);
        if (!this.f25147f.q().G() && this.f25146e.q() == null) {
            Optional<PollingSigned<PollingResult>> a8 = Optional.a();
            Intrinsics.e(a8, "empty()");
            return a8;
        }
        PollingResult d8 = this.f25144c.s(this.f25143b.g(), this.f25145d.d().c()).d();
        Intrinsics.e(d8, "apiClient.poll(handles, …s().apiVal).blockingGet()");
        Optional<PollingSigned<PollingResult>> f8 = Optional.f(new PollingSigned(d8, incrementAndGet));
        Intrinsics.e(f8, "of(PollingResultModel(ap…al).blockingGet(), tick))");
        return f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional l(DynamicPollerImpl this$0) {
        Intrinsics.f(this$0, "this$0");
        return this$0.k();
    }

    @Override // ee.mtakso.driver.service.modules.polling.Poller
    public void a() {
        this.f25151j.l();
    }

    @Override // ee.mtakso.driver.service.modules.polling.Poller
    public void b() {
        this.f25149h.set(0);
        this.f25151j.n();
    }

    @Override // ee.mtakso.driver.service.ObservableService
    public Observable<PollingSigned<PollingResult>> c() {
        Observable<PollingSigned<PollingResult>> observeOn = ObservableExtKt.h(this.f25151j.h()).observeOn(AndroidSchedulers.a());
        Intrinsics.e(observeOn, "scheduler.observeData().…dSchedulers.mainThread())");
        return observeOn;
    }

    @Override // ee.mtakso.driver.service.pollerv2.PollerSource
    public Observable<PollingSigned<PollingResult>> e() {
        return Poller.DefaultImpls.a(this);
    }

    @Override // ee.mtakso.driver.service.pollerv2.PollerSource
    public Observable<Notification<PollingSigned<PollingResult>>> f() {
        Observable<PollingSigned<PollingResult>> c8 = c();
        final DynamicPollerImpl$observePollingResultNotification$1 dynamicPollerImpl$observePollingResultNotification$1 = new Function1<PollingSigned<PollingResult>, Notification<PollingSigned<PollingResult>>>() { // from class: ee.mtakso.driver.service.modules.polling.dynamic.DynamicPollerImpl$observePollingResultNotification$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Notification<PollingSigned<PollingResult>> invoke(PollingSigned<PollingResult> it) {
                Intrinsics.f(it, "it");
                return Notification.c(it);
            }
        };
        Observable map = c8.map(new Function() { // from class: ee.mtakso.driver.service.modules.polling.dynamic.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Notification j8;
                j8 = DynamicPollerImpl.j(Function1.this, obj);
                return j8;
            }
        });
        Intrinsics.e(map, "observeResults().map { N…cation.createOnNext(it) }");
        return map;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        a();
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        b();
    }
}
