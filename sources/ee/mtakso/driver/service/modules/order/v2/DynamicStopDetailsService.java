package ee.mtakso.driver.service.modules.order.v2;

import androidx.fragment.app.FragmentTransaction;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.network.client.order.StopSummary;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import ee.mtakso.driver.utils.polling.DynamicPoller;
import ee.mtakso.driver.utils.polling.RepeatStrategy;
import ee.mtakso.driver.utils.polling.RetryStrategy;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import j$.util.Spliterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicStopDetailsService.kt */
/* loaded from: classes3.dex */
public final class DynamicStopDetailsService implements StopDetailsService {

    /* renamed from: a  reason: collision with root package name */
    private final OrderClient f24894a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderProvider f24895b;

    /* renamed from: c  reason: collision with root package name */
    private final OrdersCache f24896c;

    /* renamed from: d  reason: collision with root package name */
    private final Callable<StopSummary> f24897d;

    /* renamed from: e  reason: collision with root package name */
    private final DynamicStopDetailsService$repeatStrategy$1 f24898e;

    /* renamed from: f  reason: collision with root package name */
    private final DynamicStopDetailsService$retryStrategy$1 f24899f;

    /* renamed from: g  reason: collision with root package name */
    private final DynamicPoller<StopSummary> f24900g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f24901h;

    /* JADX WARN: Type inference failed for: r5v1, types: [ee.mtakso.driver.service.modules.order.v2.DynamicStopDetailsService$repeatStrategy$1, ee.mtakso.driver.utils.polling.RepeatStrategy] */
    /* JADX WARN: Type inference failed for: r6v1, types: [ee.mtakso.driver.service.modules.order.v2.DynamicStopDetailsService$retryStrategy$1, ee.mtakso.driver.utils.polling.RetryStrategy] */
    @Inject
    public DynamicStopDetailsService(OrderClient apiClient, OrderProvider orderProvider, OrdersCache ordersCache) {
        Intrinsics.f(apiClient, "apiClient");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(ordersCache, "ordersCache");
        this.f24894a = apiClient;
        this.f24895b = orderProvider;
        this.f24896c = ordersCache;
        Callable<StopSummary> callable = new Callable() { // from class: ee.mtakso.driver.service.modules.order.v2.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                StopSummary i8;
                i8 = DynamicStopDetailsService.i(DynamicStopDetailsService.this);
                return i8;
            }
        };
        this.f24897d = callable;
        ?? r52 = new RepeatStrategy<StopSummary>() { // from class: ee.mtakso.driver.service.modules.order.v2.DynamicStopDetailsService$repeatStrategy$1
            @Override // ee.mtakso.driver.utils.polling.RepeatStrategy
            /* renamed from: b */
            public long a(StopSummary item) {
                Intrinsics.f(item, "item");
                return item.b();
            }
        };
        this.f24898e = r52;
        ?? r62 = new RetryStrategy() { // from class: ee.mtakso.driver.service.modules.order.v2.DynamicStopDetailsService$retryStrategy$1
            @Override // ee.mtakso.driver.utils.polling.RetryStrategy
            public long a(Throwable throwable) {
                Intrinsics.f(throwable, "throwable");
                if ((throwable instanceof NoSuchElementException) || ApiExceptionUtils.m(throwable, 415)) {
                    return -1L;
                }
                return 2L;
            }
        };
        this.f24899f = r62;
        PublishSubject e8 = PublishSubject.e();
        Intrinsics.e(e8, "create()");
        this.f24900g = new DynamicPoller<>(callable, r52, r62, e8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StopSummary i(final DynamicStopDetailsService this$0) {
        Intrinsics.f(this$0, "this$0");
        Single<OrderDetails> r7 = OrderProviderUtils.r(this$0.f24895b, OrderState.ORDER_STATE_WAITING_ON_STOP);
        final Function1<OrderDetails, SingleSource<? extends StopSummary>> function1 = new Function1<OrderDetails, SingleSource<? extends StopSummary>>() { // from class: ee.mtakso.driver.service.modules.order.v2.DynamicStopDetailsService$dataSource$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends StopSummary> invoke(OrderDetails it) {
                OrderClient orderClient;
                Intrinsics.f(it, "it");
                orderClient = DynamicStopDetailsService.this.f24894a;
                return orderClient.G(it.a());
            }
        };
        return (StopSummary) r7.r(new Function() { // from class: ee.mtakso.driver.service.modules.order.v2.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource j8;
                j8 = DynamicStopDetailsService.j(Function1.this, obj);
                return j8;
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    private final void k() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Observable<StopSummary> h8 = this.f24900g.h();
        final Function1<StopSummary, Unit> function1 = new Function1<StopSummary, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.DynamicStopDetailsService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(StopSummary stopSummary) {
                OrdersCache ordersCache;
                OrdersCache ordersCache2;
                ActiveOrderDetails e8;
                ordersCache = DynamicStopDetailsService.this.f24896c;
                ActiveOrderDetails d8 = ordersCache.d(OrderState.ORDER_STATE_WAITING_ON_STOP);
                if (d8 != null) {
                    ordersCache2 = DynamicStopDetailsService.this.f24896c;
                    e8 = d8.e((r36 & 1) != 0 ? d8.a() : null, (r36 & 2) != 0 ? d8.d() : 0, (r36 & 4) != 0 ? d8.b() : null, (r36 & 8) != 0 ? d8.c() : null, (r36 & 16) != 0 ? d8.f25399e : null, (r36 & 32) != 0 ? d8.f25400f : 0L, (r36 & 64) != 0 ? d8.f25401g : false, (r36 & 128) != 0 ? d8.f25402h : false, (r36 & Spliterator.NONNULL) != 0 ? d8.f25403i : null, (r36 & 512) != 0 ? d8.f25404j : 0L, (r36 & Spliterator.IMMUTABLE) != 0 ? d8.f25405k : null, (r36 & 2048) != 0 ? d8.f25406l : Long.valueOf(stopSummary.c()), (r36 & 4096) != 0 ? d8.f25407m : stopSummary.a(), (r36 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? d8.f25408n : null, (r36 & 16384) != 0 ? d8.f25409o : null, (r36 & 32768) != 0 ? d8.f25410p : null);
                    ordersCache2.b(e8);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StopSummary stopSummary) {
                b(stopSummary);
                return Unit.f50853a;
            }
        };
        compositeDisposable.b(h8.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DynamicStopDetailsService.l(Function1.this, obj);
            }
        }));
        Observable<Throwable> i8 = this.f24900g.i();
        final DynamicStopDetailsService$doStart$2 dynamicStopDetailsService$doStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.order.v2.DynamicStopDetailsService$doStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.o(it).b("Stop summary poll error");
            }
        };
        compositeDisposable.b(i8.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.modules.order.v2.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DynamicStopDetailsService.m(Function1.this, obj);
            }
        }));
        this.f24901h = compositeDisposable;
        this.f24900g.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.modules.order.v2.StopDetailsService
    public void a() {
        k();
    }

    @Override // ee.mtakso.driver.service.modules.order.v2.StopDetailsService
    public void b() {
        this.f24900g.n();
        Disposable disposable = this.f24901h;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // ee.mtakso.driver.service.modules.order.v2.StopDetailsService
    public boolean isRunning() {
        return this.f24900g.g();
    }
}
