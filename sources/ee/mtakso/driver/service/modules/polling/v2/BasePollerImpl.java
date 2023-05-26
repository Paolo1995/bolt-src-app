package ee.mtakso.driver.service.modules.polling.v2;

import ee.mtakso.driver.di.modules.TimingHooks;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.ObservableService;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.modules.polling.PollingRetryStrategy;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.modules.polling.v2.BasePollerImpl;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.utils.AppForegroundState;
import ee.mtakso.driver.utils.BackgroundManager;
import ee.mtakso.driver.utils.RxUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasePollerImpl.kt */
/* loaded from: classes3.dex */
public final class BasePollerImpl implements ObservableService<PollingSigned<PollingResult>> {

    /* renamed from: a  reason: collision with root package name */
    private final long f25156a;

    /* renamed from: b  reason: collision with root package name */
    private final TimingHooks f25157b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverClient f25158c;

    /* renamed from: d  reason: collision with root package name */
    private final PollingRetryStrategy f25159d;

    /* renamed from: e  reason: collision with root package name */
    private final OrdersCache f25160e;

    /* renamed from: f  reason: collision with root package name */
    private final Consumer<Throwable> f25161f;

    /* renamed from: g  reason: collision with root package name */
    private final String f25162g;

    /* renamed from: h  reason: collision with root package name */
    private final BackgroundManager f25163h;

    /* renamed from: i  reason: collision with root package name */
    private final GeoLocationManager f25164i;

    /* renamed from: j  reason: collision with root package name */
    private final DriverProvider f25165j;

    /* renamed from: k  reason: collision with root package name */
    private final AtomicBoolean f25166k;

    /* renamed from: l  reason: collision with root package name */
    private Disposable f25167l;

    /* renamed from: m  reason: collision with root package name */
    private final PublishSubject<PollingSigned<PollingResult>> f25168m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BasePollerImpl.kt */
    /* loaded from: classes3.dex */
    public static final class TickWithAppState {

        /* renamed from: a  reason: collision with root package name */
        private final int f25169a;

        /* renamed from: b  reason: collision with root package name */
        private final AppForegroundState f25170b;

        public TickWithAppState(int i8, AppForegroundState appForegroundState) {
            Intrinsics.f(appForegroundState, "appForegroundState");
            this.f25169a = i8;
            this.f25170b = appForegroundState;
        }

        public final AppForegroundState a() {
            return this.f25170b;
        }

        public final int b() {
            return this.f25169a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TickWithAppState) {
                TickWithAppState tickWithAppState = (TickWithAppState) obj;
                return this.f25169a == tickWithAppState.f25169a && this.f25170b == tickWithAppState.f25170b;
            }
            return false;
        }

        public int hashCode() {
            return (this.f25169a * 31) + this.f25170b.hashCode();
        }

        public String toString() {
            int i8 = this.f25169a;
            AppForegroundState appForegroundState = this.f25170b;
            return "TickWithAppState(tick=" + i8 + ", appForegroundState=" + appForegroundState + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BasePollerImpl.kt */
    /* loaded from: classes3.dex */
    public static final class TickWithLocationStatus {

        /* renamed from: a  reason: collision with root package name */
        private final int f25171a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f25172b;

        public TickWithLocationStatus(int i8, boolean z7) {
            this.f25171a = i8;
            this.f25172b = z7;
        }

        public final int a() {
            return this.f25171a;
        }

        public final boolean b() {
            return this.f25172b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TickWithLocationStatus) {
                TickWithLocationStatus tickWithLocationStatus = (TickWithLocationStatus) obj;
                return this.f25171a == tickWithLocationStatus.f25171a && this.f25172b == tickWithLocationStatus.f25172b;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i8 = this.f25171a * 31;
            boolean z7 = this.f25172b;
            int i9 = z7;
            if (z7 != 0) {
                i9 = 1;
            }
            return i8 + i9;
        }

        public String toString() {
            int i8 = this.f25171a;
            boolean z7 = this.f25172b;
            return "TickWithLocationStatus(tick=" + i8 + ", canProceedNext=" + z7 + ")";
        }
    }

    public BasePollerImpl(long j8, TimingHooks hooks, DriverClient apiClient, PollingRetryStrategy pollingRetryStrategy, OrdersCache ordersCache, Consumer<Throwable> pollingErrorHandler, String loggingKey, BackgroundManager backgroundManager, GeoLocationManager locationManager, DriverProvider driverProvider) {
        Intrinsics.f(hooks, "hooks");
        Intrinsics.f(apiClient, "apiClient");
        Intrinsics.f(pollingRetryStrategy, "pollingRetryStrategy");
        Intrinsics.f(ordersCache, "ordersCache");
        Intrinsics.f(pollingErrorHandler, "pollingErrorHandler");
        Intrinsics.f(loggingKey, "loggingKey");
        Intrinsics.f(backgroundManager, "backgroundManager");
        Intrinsics.f(locationManager, "locationManager");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f25156a = j8;
        this.f25157b = hooks;
        this.f25158c = apiClient;
        this.f25159d = pollingRetryStrategy;
        this.f25160e = ordersCache;
        this.f25161f = pollingErrorHandler;
        this.f25162g = loggingKey;
        this.f25163h = backgroundManager;
        this.f25164i = locationManager;
        this.f25165j = driverProvider;
        this.f25166k = new AtomicBoolean(false);
        PublishSubject<PollingSigned<PollingResult>> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<PollingResultModel>()");
        this.f25168m = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer A(AtomicInteger tickCounter) {
        Intrinsics.f(tickCounter, "$tickCounter");
        return Integer.valueOf(tickCounter.incrementAndGet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TickWithLocationStatus B(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (TickWithLocationStatus) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer E(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Integer) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TickWithAppState F(Integer tick, AppForegroundState appState) {
        Intrinsics.f(tick, "tick");
        Intrinsics.f(appState, "appState");
        return new TickWithAppState(tick.intValue(), appState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource G(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource H(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource J(Function1 tmp0, Observable p02) {
        Intrinsics.f(tmp0, "$tmp0");
        Intrinsics.f(p02, "p0");
        return (ObservableSource) tmp0.invoke(p02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Single<PollingSigned<PollingResult>> y(final TickWithAppState tickWithAppState) {
        String str = this.f25162g;
        int b8 = tickWithAppState.b();
        Kalev.b(str + " poller tick " + b8);
        Single<PollingResult> s7 = this.f25158c.s(this.f25160e.g(), tickWithAppState.a().c());
        final Function1<PollingResult, PollingSigned<PollingResult>> function1 = new Function1<PollingResult, PollingSigned<PollingResult>>() { // from class: ee.mtakso.driver.service.modules.polling.v2.BasePollerImpl$poll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final PollingSigned<PollingResult> invoke(PollingResult pollingResult) {
                Intrinsics.f(pollingResult, "pollingResult");
                return new PollingSigned<>(pollingResult, BasePollerImpl.TickWithAppState.this.b());
            }
        };
        Single<PollingSigned<PollingResult>> K = s7.x(new Function() { // from class: ee.mtakso.driver.service.modules.polling.v2.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PollingSigned z7;
                z7 = BasePollerImpl.z(Function1.this, obj);
                return z7;
            }
        }).K(Schedulers.c());
        Intrinsics.e(K, "tickWithAppState: TickWi…scribeOn(Schedulers.io())");
        return K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PollingSigned z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (PollingSigned) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.ObservableService
    public Observable<PollingSigned<PollingResult>> c() {
        return this.f25168m;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        if (!this.f25166k.compareAndSet(false, true)) {
            String str = this.f25162g;
            Kalev.b(str + " poller already running");
            return false;
        }
        final AtomicInteger atomicInteger = new AtomicInteger();
        Observable compose = Observable.fromCallable(new Callable() { // from class: ee.mtakso.driver.service.modules.polling.v2.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer A;
                A = BasePollerImpl.A(atomicInteger);
                return A;
            }
        }).compose(this.f25157b.c());
        final Function1<Integer, TickWithLocationStatus> function1 = new Function1<Integer, TickWithLocationStatus>() { // from class: ee.mtakso.driver.service.modules.polling.v2.BasePollerImpl$start$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final BasePollerImpl.TickWithLocationStatus invoke(Integer tick) {
                DriverProvider driverProvider;
                GeoLocationManager geoLocationManager;
                Intrinsics.f(tick, "tick");
                driverProvider = BasePollerImpl.this.f25165j;
                boolean z7 = true;
                if (driverProvider.q().G()) {
                    return new BasePollerImpl.TickWithLocationStatus(tick.intValue(), true);
                }
                int intValue = tick.intValue();
                geoLocationManager = BasePollerImpl.this.f25164i;
                if (geoLocationManager.q() == null) {
                    z7 = false;
                }
                return new BasePollerImpl.TickWithLocationStatus(intValue, z7);
            }
        };
        Observable map = compose.map(new Function() { // from class: ee.mtakso.driver.service.modules.polling.v2.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BasePollerImpl.TickWithLocationStatus B;
                B = BasePollerImpl.B(Function1.this, obj);
                return B;
            }
        });
        final Function1<TickWithLocationStatus, Boolean> function12 = new Function1<TickWithLocationStatus, Boolean>() { // from class: ee.mtakso.driver.service.modules.polling.v2.BasePollerImpl$start$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(BasePollerImpl.TickWithLocationStatus tickWithLocationStatus) {
                String str2;
                AtomicBoolean atomicBoolean;
                boolean z7;
                Intrinsics.f(tickWithLocationStatus, "<name for destructuring parameter 0>");
                boolean b8 = tickWithLocationStatus.b();
                str2 = BasePollerImpl.this.f25162g;
                Kalev.b(str2 + " poller pre perform operation. can proceed next? " + b8);
                atomicBoolean = BasePollerImpl.this.f25166k;
                if (atomicBoolean.get() && b8) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable filter = map.filter(new Predicate() { // from class: ee.mtakso.driver.service.modules.polling.v2.f
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean D;
                D = BasePollerImpl.D(Function1.this, obj);
                return D;
            }
        });
        final BasePollerImpl$start$4 basePollerImpl$start$4 = new Function1<TickWithLocationStatus, Integer>() { // from class: ee.mtakso.driver.service.modules.polling.v2.BasePollerImpl$start$4
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Integer invoke(BasePollerImpl.TickWithLocationStatus tickWithLocationStatus) {
                Intrinsics.f(tickWithLocationStatus, "<name for destructuring parameter 0>");
                return Integer.valueOf(tickWithLocationStatus.a());
            }
        };
        Observable withLatestFrom = filter.map(new Function() { // from class: ee.mtakso.driver.service.modules.polling.v2.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Integer E;
                E = BasePollerImpl.E(Function1.this, obj);
                return E;
            }
        }).withLatestFrom(this.f25163h.h(), new BiFunction() { // from class: ee.mtakso.driver.service.modules.polling.v2.h
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                BasePollerImpl.TickWithAppState F;
                F = BasePollerImpl.F((Integer) obj, (AppForegroundState) obj2);
                return F;
            }
        });
        final Function1<TickWithAppState, SingleSource<? extends PollingSigned<PollingResult>>> function13 = new Function1<TickWithAppState, SingleSource<? extends PollingSigned<PollingResult>>>() { // from class: ee.mtakso.driver.service.modules.polling.v2.BasePollerImpl$start$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends PollingSigned<PollingResult>> invoke(BasePollerImpl.TickWithAppState tickWithState) {
                Single y7;
                Intrinsics.f(tickWithState, "tickWithState");
                y7 = BasePollerImpl.this.y(tickWithState);
                return y7;
            }
        };
        Observable doOnError = withLatestFrom.flatMapSingle(new Function() { // from class: ee.mtakso.driver.service.modules.polling.v2.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource G;
                G = BasePollerImpl.G(Function1.this, obj);
                return G;
            }
        }).doOnError(this.f25161f);
        final BasePollerImpl$start$7 basePollerImpl$start$7 = new BasePollerImpl$start$7(this);
        Observable retryWhen = doOnError.retryWhen(new Function() { // from class: ee.mtakso.driver.service.modules.polling.v2.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource H;
                H = BasePollerImpl.H(Function1.this, obj);
                return H;
            }
        });
        final Function1<Observable<Object>, ObservableSource<?>> function14 = new Function1<Observable<Object>, ObservableSource<?>>() { // from class: ee.mtakso.driver.service.modules.polling.v2.BasePollerImpl$start$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<?> invoke(Observable<Object> pollingObservable) {
                long j8;
                Intrinsics.f(pollingObservable, "pollingObservable");
                j8 = BasePollerImpl.this.f25156a;
                return pollingObservable.delay(j8, TimeUnit.SECONDS);
            }
        };
        Observable repeatWhen = retryWhen.repeatWhen(new Function() { // from class: ee.mtakso.driver.service.modules.polling.v2.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource I;
                I = BasePollerImpl.I(Function1.this, obj);
                return I;
            }
        });
        final BasePollerImpl$start$9 basePollerImpl$start$9 = new Function1<Observable<PollingSigned<PollingResult>>, ObservableSource<PollingSigned<PollingResult>>>() { // from class: ee.mtakso.driver.service.modules.polling.v2.BasePollerImpl$start$9
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<PollingSigned<PollingResult>> invoke(Observable<PollingSigned<PollingResult>> it) {
                Intrinsics.f(it, "it");
                return RxUtils.b(it);
            }
        };
        Observable compose2 = repeatWhen.compose(new ObservableTransformer() { // from class: ee.mtakso.driver.service.modules.polling.v2.l
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource a(Observable observable) {
                ObservableSource J;
                J = BasePollerImpl.J(Function1.this, observable);
                return J;
            }
        });
        final Function1<PollingSigned<PollingResult>, Unit> function15 = new Function1<PollingSigned<PollingResult>, Unit>() { // from class: ee.mtakso.driver.service.modules.polling.v2.BasePollerImpl$start$10
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PollingSigned<PollingResult> pollingSigned) {
                PublishSubject publishSubject;
                publishSubject = BasePollerImpl.this.f25168m;
                publishSubject.onNext(pollingSigned);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PollingSigned<PollingResult> pollingSigned) {
                b(pollingSigned);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.polling.v2.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BasePollerImpl.K(Function1.this, obj);
            }
        };
        final BasePollerImpl$start$11 basePollerImpl$start$11 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.polling.v2.BasePollerImpl$start$11
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                Intrinsics.e(error, "error");
                Kalev.e(error, "Exception on BasePoller!");
            }
        };
        this.f25167l = compose2.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.polling.v2.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BasePollerImpl.C(Function1.this, obj);
            }
        });
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        this.f25166k.set(false);
        Disposable disposable = this.f25167l;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f25167l = null;
    }
}
