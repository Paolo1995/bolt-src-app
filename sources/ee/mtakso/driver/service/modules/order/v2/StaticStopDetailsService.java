package ee.mtakso.driver.service.modules.order.v2;

import androidx.fragment.app.FragmentTransaction;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.network.client.order.StopSummary;
import ee.mtakso.driver.network.client.order.StopTimerResponse;
import ee.mtakso.driver.network.client.order.UpcomingStop;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.ActiveOrderDetailsKt;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.order.details.OrdersCache;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import j$.util.Spliterator;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StaticStopDetailsService.kt */
/* loaded from: classes3.dex */
public final class StaticStopDetailsService implements StopDetailsService {

    /* renamed from: a  reason: collision with root package name */
    private final OrderClient f25014a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderProvider f25015b;

    /* renamed from: c  reason: collision with root package name */
    private final OrdersCache f25016c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f25017d;

    /* renamed from: e  reason: collision with root package name */
    private Disposable f25018e;

    @Inject
    public StaticStopDetailsService(OrderClient driverApiClient, OrderProvider orderProvider, OrdersCache ordersCache) {
        Intrinsics.f(driverApiClient, "driverApiClient");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(ordersCache, "ordersCache");
        this.f25014a = driverApiClient;
        this.f25015b = orderProvider;
        this.f25016c = ordersCache;
        this.f25017d = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource A(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(final double d8) {
        final AtomicInteger atomicInteger = new AtomicInteger();
        Observable fromCallable = Observable.fromCallable(new Callable() { // from class: ee.mtakso.driver.service.modules.order.v2.c1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer r7;
                r7 = StaticStopDetailsService.r(atomicInteger);
                return r7;
            }
        });
        final Function1<Integer, SingleSource<? extends StopSummary>> function1 = new Function1<Integer, SingleSource<? extends StopSummary>>() { // from class: ee.mtakso.driver.service.modules.order.v2.StaticStopDetailsService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends StopSummary> invoke(Integer tick) {
                Single y7;
                Intrinsics.f(tick, "tick");
                y7 = StaticStopDetailsService.this.y(tick.intValue());
                return y7;
            }
        };
        Observable flatMapSingle = fromCallable.flatMapSingle(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.d1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource s7;
                s7 = StaticStopDetailsService.s(Function1.this, obj);
                return s7;
            }
        });
        final StaticStopDetailsService$doStart$3 staticStopDetailsService$doStart$3 = StaticStopDetailsService$doStart$3.f25020f;
        Observable retryWhen = flatMapSingle.retryWhen(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.e1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource t7;
                t7 = StaticStopDetailsService.t(Function1.this, obj);
                return t7;
            }
        });
        final Function1<Observable<Object>, ObservableSource<?>> function12 = new Function1<Observable<Object>, ObservableSource<?>>() { // from class: ee.mtakso.driver.service.modules.order.v2.StaticStopDetailsService$doStart$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<?> invoke(Observable<Object> pollingObservable) {
                Intrinsics.f(pollingObservable, "pollingObservable");
                return pollingObservable.delay((long) d8, TimeUnit.SECONDS);
            }
        };
        Observable repeatWhen = retryWhen.repeatWhen(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.f1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource u7;
                u7 = StaticStopDetailsService.u(Function1.this, obj);
                return u7;
            }
        });
        final Function1<StopSummary, Unit> function13 = new Function1<StopSummary, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.StaticStopDetailsService$doStart$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(StopSummary stopSummary) {
                OrdersCache ordersCache;
                OrdersCache ordersCache2;
                ActiveOrderDetails e8;
                ordersCache = StaticStopDetailsService.this.f25016c;
                ActiveOrderDetails d9 = ordersCache.d(OrderState.ORDER_STATE_WAITING_ON_STOP);
                if (d9 != null) {
                    ordersCache2 = StaticStopDetailsService.this.f25016c;
                    e8 = d9.e((r36 & 1) != 0 ? d9.a() : null, (r36 & 2) != 0 ? d9.d() : 0, (r36 & 4) != 0 ? d9.b() : null, (r36 & 8) != 0 ? d9.c() : null, (r36 & 16) != 0 ? d9.f25399e : null, (r36 & 32) != 0 ? d9.f25400f : 0L, (r36 & 64) != 0 ? d9.f25401g : false, (r36 & 128) != 0 ? d9.f25402h : false, (r36 & Spliterator.NONNULL) != 0 ? d9.f25403i : null, (r36 & 512) != 0 ? d9.f25404j : 0L, (r36 & Spliterator.IMMUTABLE) != 0 ? d9.f25405k : null, (r36 & 2048) != 0 ? d9.f25406l : Long.valueOf(stopSummary.c()), (r36 & 4096) != 0 ? d9.f25407m : stopSummary.a(), (r36 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? d9.f25408n : null, (r36 & 16384) != 0 ? d9.f25409o : null, (r36 & 32768) != 0 ? d9.f25410p : null);
                    ordersCache2.b(e8);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StopSummary stopSummary) {
                b(stopSummary);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.g1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StaticStopDetailsService.v(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function14 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.StaticStopDetailsService$doStart$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Got order stop price error");
                StaticStopDetailsService.this.b();
            }
        };
        this.f25018e = repeatWhen.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.h1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StaticStopDetailsService.w(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer r(AtomicInteger tickCounter) {
        Intrinsics.f(tickCounter, "$tickCounter");
        return Integer.valueOf(tickCounter.incrementAndGet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean x() {
        boolean compareAndSet = this.f25017d.compareAndSet(false, true);
        if (!compareAndSet) {
            Kalev.d("Stop poller already running");
        }
        return compareAndSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Single<StopSummary> y(int i8) {
        Kalev.d("Stop poller tick " + i8);
        Single<OrderDetails> r7 = OrderProviderUtils.r(this.f25015b, OrderState.ORDER_STATE_WAITING_ON_STOP);
        final Function1<OrderDetails, SingleSource<? extends StopSummary>> function1 = new Function1<OrderDetails, SingleSource<? extends StopSummary>>() { // from class: ee.mtakso.driver.service.modules.order.v2.StaticStopDetailsService$poll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends StopSummary> invoke(OrderDetails it) {
                OrderClient orderClient;
                Intrinsics.f(it, "it");
                orderClient = StaticStopDetailsService.this.f25014a;
                return orderClient.G(it.a());
            }
        };
        Single r8 = r7.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.i1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource z7;
                z7 = StaticStopDetailsService.z(Function1.this, obj);
                return z7;
            }
        });
        Intrinsics.e(r8, "private fun poll(tick: I…y(it.orderHandle) }\n    }");
        return r8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.modules.order.v2.StopDetailsService
    public void a() {
        if (!x()) {
            return;
        }
        Single<ActiveOrderDetails> p8 = OrderProviderUtils.p(this.f25015b, OrderState.ORDER_STATE_WAITING_ON_STOP);
        final Function1<ActiveOrderDetails, SingleSource<? extends StopTimerResponse>> function1 = new Function1<ActiveOrderDetails, SingleSource<? extends StopTimerResponse>>() { // from class: ee.mtakso.driver.service.modules.order.v2.StaticStopDetailsService$startPolling$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends StopTimerResponse> invoke(ActiveOrderDetails it) {
                OrderClient orderClient;
                Object W;
                Intrinsics.f(it, "it");
                orderClient = StaticStopDetailsService.this.f25014a;
                OrderHandle a8 = it.a();
                W = CollectionsKt___CollectionsKt.W(ActiveOrderDetailsKt.a(it));
                return orderClient.k(a8, ((UpcomingStop) W).b());
            }
        };
        Single<R> r7 = p8.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.z0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource A;
                A = StaticStopDetailsService.A(Function1.this, obj);
                return A;
            }
        });
        final Function1<StopTimerResponse, Unit> function12 = new Function1<StopTimerResponse, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.StaticStopDetailsService$startPolling$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(StopTimerResponse stopTimerResponse) {
                StaticStopDetailsService.this.q(stopTimerResponse.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StopTimerResponse stopTimerResponse) {
                b(stopTimerResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.a1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StaticStopDetailsService.B(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.StaticStopDetailsService$startPolling$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to start polling of stop details");
                StaticStopDetailsService.this.b();
            }
        };
        this.f25018e = r7.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.b1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                StaticStopDetailsService.C(Function1.this, obj);
            }
        });
    }

    @Override // ee.mtakso.driver.service.modules.order.v2.StopDetailsService
    public void b() {
        this.f25017d.set(false);
        Disposable disposable = this.f25018e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f25018e = null;
    }

    @Override // ee.mtakso.driver.service.modules.order.v2.StopDetailsService
    public boolean isRunning() {
        return this.f25017d.get();
    }
}
