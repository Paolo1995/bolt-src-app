package ee.mtakso.driver.service.pollerv2;

import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.service.pollerv2.exception.PollingNotAllowedException;
import ee.mtakso.driver.utils.BackgroundManager;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PollerManager.kt */
/* loaded from: classes3.dex */
public final class PollerManager {

    /* renamed from: a  reason: collision with root package name */
    private final DriverClient f25545a;

    /* renamed from: b  reason: collision with root package name */
    private final OrdersCache f25546b;

    /* renamed from: c  reason: collision with root package name */
    private final BackgroundManager f25547c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverProvider f25548d;

    /* renamed from: e  reason: collision with root package name */
    private final GeoLocationManager f25549e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f25550f;

    @Inject
    public PollerManager(DriverClient driverClient, OrdersCache ordersCache, BackgroundManager backgroundManager, DriverProvider driverProvider, GeoLocationManager locationManager) {
        Intrinsics.f(driverClient, "driverClient");
        Intrinsics.f(ordersCache, "ordersCache");
        Intrinsics.f(backgroundManager, "backgroundManager");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(locationManager, "locationManager");
        this.f25545a = driverClient;
        this.f25546b = ordersCache;
        this.f25547c = backgroundManager;
        this.f25548d = driverProvider;
        this.f25549e = locationManager;
        this.f25550f = new AtomicInteger();
    }

    private final Completable d() {
        Completable i8 = Completable.i(new CompletableOnSubscribe() { // from class: ee.mtakso.driver.service.pollerv2.r
            @Override // io.reactivex.CompletableOnSubscribe
            public final void a(CompletableEmitter completableEmitter) {
                PollerManager.e(PollerManager.this, completableEmitter);
            }
        });
        Intrinsics.e(i8, "create { emitter ->\n    …)\n            }\n        }");
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(PollerManager this$0, CompletableEmitter emitter) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(emitter, "emitter");
        boolean z7 = true;
        if (!this$0.f25548d.q().G() && this$0.f25549e.q() == null) {
            z7 = false;
        }
        if (z7) {
            emitter.onComplete();
        } else {
            emitter.onError(new PollingNotAllowedException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PollingSigned h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (PollingSigned) tmp0.invoke(obj);
    }

    public final void f() {
        this.f25550f.set(0);
    }

    public final Single<PollingSigned<PollingResult>> g() {
        Single f8 = d().f(this.f25545a.s(this.f25546b.g(), this.f25547c.d().c()));
        final Function1<PollingResult, PollingSigned<PollingResult>> function1 = new Function1<PollingResult, PollingSigned<PollingResult>>() { // from class: ee.mtakso.driver.service.pollerv2.PollerManager$triggerPolling$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final PollingSigned<PollingResult> invoke(PollingResult it) {
                AtomicInteger atomicInteger;
                Intrinsics.f(it, "it");
                atomicInteger = PollerManager.this.f25550f;
                return new PollingSigned<>(it, atomicInteger.incrementAndGet());
            }
        };
        Single<PollingSigned<PollingResult>> K = f8.x(new Function() { // from class: ee.mtakso.driver.service.pollerv2.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PollingSigned h8;
                h8 = PollerManager.h(Function1.this, obj);
                return h8;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "fun triggerPolling(): Si…On(Schedulers.io())\n    }");
        return K;
    }
}
