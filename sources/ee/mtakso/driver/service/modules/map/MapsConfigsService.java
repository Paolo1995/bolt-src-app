package ee.mtakso.driver.service.modules.map;

import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.DriverMapsConfigs;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.ObservableService;
import ee.mtakso.driver.service.modules.polling.PollingRetryStrategy;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.polling.DynamicPoller;
import ee.mtakso.driver.utils.polling.RepeatStrategy;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapsConfigsService.kt */
/* loaded from: classes3.dex */
public final class MapsConfigsService implements ObservableService<MapsConfigs> {

    /* renamed from: a  reason: collision with root package name */
    private final DriverClient f24850a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverStatusProvider f24851b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverFeatures f24852c;

    /* renamed from: d  reason: collision with root package name */
    private final DynamicPoller<DriverMapsConfigs> f24853d;

    /* renamed from: e  reason: collision with root package name */
    private Disposable f24854e;

    @Inject
    public MapsConfigsService(PollingRetryStrategy retryStrategy, DriverClient driverClient, DriverStatusProvider driverStatusProvider, DriverFeatures driverFeatures) {
        Intrinsics.f(retryStrategy, "retryStrategy");
        Intrinsics.f(driverClient, "driverClient");
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        Intrinsics.f(driverFeatures, "driverFeatures");
        this.f24850a = driverClient;
        this.f24851b = driverStatusProvider;
        this.f24852c = driverFeatures;
        this.f24853d = new DynamicPoller<>(new Callable() { // from class: ee.mtakso.driver.service.modules.map.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                DriverMapsConfigs m8;
                m8 = MapsConfigsService.m(MapsConfigsService.this);
                return m8;
            }
        }, new RepeatStrategy<DriverMapsConfigs>() { // from class: ee.mtakso.driver.service.modules.map.MapsConfigsService$poller$2
            @Override // ee.mtakso.driver.utils.polling.RepeatStrategy
            /* renamed from: b */
            public long a(DriverMapsConfigs item) {
                Intrinsics.f(item, "item");
                Long a8 = item.a();
                if (a8 != null) {
                    return a8.longValue();
                }
                return 60L;
            }
        }, retryStrategy, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MapsConfigs l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (MapsConfigs) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverMapsConfigs m(MapsConfigsService this$0) {
        Intrinsics.f(this$0, "this$0");
        return this$0.f24850a.o().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.ObservableService
    public Observable<MapsConfigs> c() {
        Observable<DriverMapsConfigs> h8 = this.f24853d.h();
        final MapsConfigsService$observeResults$1 mapsConfigsService$observeResults$1 = new Function1<DriverMapsConfigs, MapsConfigs>() { // from class: ee.mtakso.driver.service.modules.map.MapsConfigsService$observeResults$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final MapsConfigs invoke(DriverMapsConfigs it) {
                Intrinsics.f(it, "it");
                return new MapsConfigs(it);
            }
        };
        Observable map = h8.map(new Function() { // from class: ee.mtakso.driver.service.modules.map.l
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                MapsConfigs l8;
                l8 = MapsConfigsService.l(Function1.this, obj);
                return l8;
            }
        });
        Intrinsics.e(map, "poller.observeData()\n   …Configs(it)\n            }");
        return map;
    }

    public final void k() {
        stop();
        start();
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        Observable g8 = ObservableExtKt.g(this.f24851b.g());
        final Function1<DriverStatus, Unit> function1 = new Function1<DriverStatus, Unit>() { // from class: ee.mtakso.driver.service.modules.map.MapsConfigsService$start$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0016, code lost:
                if (r0.O() != false) goto L11;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void b(ee.mtakso.driver.network.client.driver.DriverStatus r2) {
                /*
                    r1 = this;
                    ee.mtakso.driver.service.modules.map.MapsConfigsService r0 = ee.mtakso.driver.service.modules.map.MapsConfigsService.this
                    ee.mtakso.driver.param.DriverFeatures r0 = ee.mtakso.driver.service.modules.map.MapsConfigsService.i(r0)
                    boolean r0 = r0.y()
                    if (r0 != 0) goto L18
                    ee.mtakso.driver.service.modules.map.MapsConfigsService r0 = ee.mtakso.driver.service.modules.map.MapsConfigsService.this
                    ee.mtakso.driver.param.DriverFeatures r0 = ee.mtakso.driver.service.modules.map.MapsConfigsService.i(r0)
                    boolean r0 = r0.O()
                    if (r0 == 0) goto L1c
                L18:
                    ee.mtakso.driver.network.client.driver.DriverStatus r0 = ee.mtakso.driver.network.client.driver.DriverStatus.ACTIVE_ORDER
                    if (r2 != r0) goto L32
                L1c:
                    ee.mtakso.driver.service.modules.map.MapsConfigsService r2 = ee.mtakso.driver.service.modules.map.MapsConfigsService.this
                    ee.mtakso.driver.utils.polling.DynamicPoller r2 = ee.mtakso.driver.service.modules.map.MapsConfigsService.j(r2)
                    boolean r2 = r2.g()
                    if (r2 == 0) goto L47
                    ee.mtakso.driver.service.modules.map.MapsConfigsService r2 = ee.mtakso.driver.service.modules.map.MapsConfigsService.this
                    ee.mtakso.driver.utils.polling.DynamicPoller r2 = ee.mtakso.driver.service.modules.map.MapsConfigsService.j(r2)
                    r2.n()
                    goto L47
                L32:
                    ee.mtakso.driver.service.modules.map.MapsConfigsService r2 = ee.mtakso.driver.service.modules.map.MapsConfigsService.this
                    ee.mtakso.driver.utils.polling.DynamicPoller r2 = ee.mtakso.driver.service.modules.map.MapsConfigsService.j(r2)
                    boolean r2 = r2.g()
                    if (r2 != 0) goto L47
                    ee.mtakso.driver.service.modules.map.MapsConfigsService r2 = ee.mtakso.driver.service.modules.map.MapsConfigsService.this
                    ee.mtakso.driver.utils.polling.DynamicPoller r2 = ee.mtakso.driver.service.modules.map.MapsConfigsService.j(r2)
                    r2.l()
                L47:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.modules.map.MapsConfigsService$start$1.b(ee.mtakso.driver.network.client.driver.DriverStatus):void");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverStatus driverStatus) {
                b(driverStatus);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.map.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MapsConfigsService.n(Function1.this, obj);
            }
        };
        final MapsConfigsService$start$2 mapsConfigsService$start$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.map.MapsConfigsService$start$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Unexpected error in maps configs polling");
            }
        };
        this.f24854e = g8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.map.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MapsConfigsService.o(Function1.this, obj);
            }
        });
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        Disposable disposable = this.f24854e;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        this.f24853d.n();
    }
}
