package ee.mtakso.driver.service.pollerv2;

import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.modules.polling.PollingRetryStrategy;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import ee.mtakso.driver.service.pollerv2.PollerService;
import ee.mtakso.driver.service.pollerv2.exception.FixedPollingNotAllowedException;
import ee.mtakso.driver.utils.DisposableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;

/* compiled from: FixedPollingService.kt */
/* loaded from: classes3.dex */
public final class FixedPollingService implements PollerService {

    /* renamed from: a  reason: collision with root package name */
    private final PollerManager f25529a;

    /* renamed from: b  reason: collision with root package name */
    private final PollingRetryStrategy f25530b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverStatusSender f25531c;

    /* renamed from: d  reason: collision with root package name */
    private final Subject<Notification<PollingSigned<PollingResult>>> f25532d;

    /* renamed from: e  reason: collision with root package name */
    private long f25533e;

    /* renamed from: f  reason: collision with root package name */
    private Disposable f25534f;

    /* compiled from: FixedPollingService.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25535a;

        static {
            int[] iArr = new int[DriverStatus.values().length];
            try {
                iArr[DriverStatus.ACTIVE_ORDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverStatus.WAITING_ORDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DriverStatus.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DriverStatus.INACTIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DriverStatus.UNDEFINED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DriverStatus.BUSY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f25535a = iArr;
        }
    }

    @Inject
    public FixedPollingService(PollerManager pollerManager, PollingRetryStrategy pollingRetryStrategy, DriverStatusSender driverStatusSender) {
        Intrinsics.f(pollerManager, "pollerManager");
        Intrinsics.f(pollingRetryStrategy, "pollingRetryStrategy");
        Intrinsics.f(driverStatusSender, "driverStatusSender");
        this.f25529a = pollerManager;
        this.f25530b = pollingRetryStrategy;
        this.f25531c = driverStatusSender;
        BehaviorSubject e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create()");
        this.f25532d = e8;
        this.f25533e = 5L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        long j8 = 5;
        switch (WhenMappings.f25535a[this.f25531c.n().ordinal()]) {
            case 1:
            case 2:
            case 3:
                j8 = 2;
                break;
        }
        this.f25533e = j8;
    }

    private final Single<Boolean> r() {
        Single<Boolean> f8 = Single.f(new SingleOnSubscribe() { // from class: ee.mtakso.driver.service.pollerv2.n
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                FixedPollingService.s(FixedPollingService.this, singleEmitter);
            }
        });
        Intrinsics.e(f8, "create { emitter ->\n    …)\n            }\n        }");
        return f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(FixedPollingService this$0, SingleEmitter emitter) {
        boolean z7;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(emitter, "emitter");
        if (this$0.f25531c.n() != DriverStatus.OFFLINE && this$0.f25531c.n() != DriverStatus.UNKNOWN) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            emitter.onSuccess(Boolean.valueOf(z7));
        } else {
            emitter.onError(new FixedPollingNotAllowedException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flowable<Long> t() {
        return Flowable.d0(this.f25533e, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flowable<Long> u(Throwable th) {
        long a8 = this.f25530b.a(th);
        if (a8 == -1) {
            Flowable<Long> s7 = Flowable.s(th);
            Intrinsics.e(s7, "error(throwable)");
            return s7;
        }
        Flowable<Long> d02 = Flowable.d0(a8, TimeUnit.SECONDS);
        Intrinsics.e(d02, "timer(retryIn, TimeUnit.SECONDS)");
        return d02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher x(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.pollerv2.PollerSource
    public Observable<PollingSigned<PollingResult>> e() {
        return PollerService.DefaultImpls.a(this);
    }

    @Override // ee.mtakso.driver.service.pollerv2.PollerSource
    public Observable<Notification<PollingSigned<PollingResult>>> f() {
        return this.f25532d;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        Single<Boolean> r7 = r();
        final Function1<Boolean, SingleSource<? extends PollingSigned<PollingResult>>> function1 = new Function1<Boolean, SingleSource<? extends PollingSigned<PollingResult>>>() { // from class: ee.mtakso.driver.service.pollerv2.FixedPollingService$start$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends PollingSigned<PollingResult>> invoke(Boolean it) {
                PollerManager pollerManager;
                Intrinsics.f(it, "it");
                pollerManager = FixedPollingService.this.f25529a;
                return pollerManager.g();
            }
        };
        Single z7 = r7.r(new Function() { // from class: ee.mtakso.driver.service.pollerv2.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource v7;
                v7 = FixedPollingService.v(Function1.this, obj);
                return v7;
            }
        }).z(AndroidSchedulers.a());
        final FixedPollingService$start$2 fixedPollingService$start$2 = new FixedPollingService$start$2(this);
        Flowable E = z7.E(new Function() { // from class: ee.mtakso.driver.service.pollerv2.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher w7;
                w7 = FixedPollingService.w(Function1.this, obj);
                return w7;
            }
        });
        final FixedPollingService$start$3 fixedPollingService$start$3 = new FixedPollingService$start$3(this);
        Flowable U = E.U(new Function() { // from class: ee.mtakso.driver.service.pollerv2.k
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher x7;
                x7 = FixedPollingService.x(Function1.this, obj);
                return x7;
            }
        });
        final Function1<PollingSigned<PollingResult>, Unit> function12 = new Function1<PollingSigned<PollingResult>, Unit>() { // from class: ee.mtakso.driver.service.pollerv2.FixedPollingService$start$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PollingSigned<PollingResult> pollingSigned) {
                Subject subject;
                FixedPollingService.this.A();
                subject = FixedPollingService.this.f25532d;
                subject.onNext(Notification.c(pollingSigned));
                int b8 = pollingSigned.b();
                Kalev.b("Fixed poller service fingerprint " + b8);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PollingSigned<PollingResult> pollingSigned) {
                b(pollingSigned);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.pollerv2.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FixedPollingService.y(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.pollerv2.FixedPollingService$start$5
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
                Subject subject;
                subject = FixedPollingService.this.f25532d;
                subject.onNext(Notification.b(it));
                Intrinsics.e(it, "it");
                Kalev.e(it, "Exception in Fixed poller service!");
            }
        };
        this.f25534f = U.V(consumer, new Consumer() { // from class: ee.mtakso.driver.service.pollerv2.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FixedPollingService.z(Function1.this, obj);
            }
        });
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        this.f25529a.f();
        Disposable disposable = this.f25534f;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }
}
