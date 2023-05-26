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

/* compiled from: DynamicPollingService.kt */
/* loaded from: classes3.dex */
public final class DynamicPollingService implements PollerService {

    /* renamed from: a  reason: collision with root package name */
    private final PollerManager f25514a;

    /* renamed from: b  reason: collision with root package name */
    private final PollingRetryStrategy f25515b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverStatusSender f25516c;

    /* renamed from: d  reason: collision with root package name */
    private final Subject<Notification<PollingSigned<PollingResult>>> f25517d;

    /* renamed from: e  reason: collision with root package name */
    private long f25518e;

    /* renamed from: f  reason: collision with root package name */
    private Disposable f25519f;

    @Inject
    public DynamicPollingService(PollerManager pollerManager, PollingRetryStrategy pollingRetryStrategy, DriverStatusSender driverStatusSender) {
        Intrinsics.f(pollerManager, "pollerManager");
        Intrinsics.f(pollingRetryStrategy, "pollingRetryStrategy");
        Intrinsics.f(driverStatusSender, "driverStatusSender");
        this.f25514a = pollerManager;
        this.f25515b = pollingRetryStrategy;
        this.f25516c = driverStatusSender;
        BehaviorSubject e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create()");
        this.f25517d = e8;
        this.f25518e = 2L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(Float f8) {
        long j8;
        if (f8 != null) {
            j8 = f8.floatValue();
        } else {
            j8 = 2;
        }
        this.f25518e = j8;
    }

    private final Single<Boolean> r() {
        Single<Boolean> f8 = Single.f(new SingleOnSubscribe() { // from class: ee.mtakso.driver.service.pollerv2.f
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                DynamicPollingService.s(DynamicPollingService.this, singleEmitter);
            }
        });
        Intrinsics.e(f8, "create { emitter ->\n    …)\n            }\n        }");
        return f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(DynamicPollingService this$0, SingleEmitter emitter) {
        boolean z7;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(emitter, "emitter");
        if (this$0.f25516c.n() != DriverStatus.OFFLINE && this$0.f25516c.n() != DriverStatus.UNKNOWN) {
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
    public final Flowable<Long> u() {
        return Flowable.d0(this.f25518e, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flowable<Long> v(Throwable th) {
        long a8 = this.f25515b.a(th);
        if (a8 == -1) {
            return Flowable.s(th);
        }
        return Flowable.d0(a8, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher x(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
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

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        Single<Boolean> r7 = r();
        final Function1<Boolean, SingleSource<? extends PollingSigned<PollingResult>>> function1 = new Function1<Boolean, SingleSource<? extends PollingSigned<PollingResult>>>() { // from class: ee.mtakso.driver.service.pollerv2.DynamicPollingService$start$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends PollingSigned<PollingResult>> invoke(Boolean it) {
                PollerManager pollerManager;
                Intrinsics.f(it, "it");
                pollerManager = DynamicPollingService.this.f25514a;
                return pollerManager.g();
            }
        };
        Single z7 = r7.r(new Function() { // from class: ee.mtakso.driver.service.pollerv2.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource w7;
                w7 = DynamicPollingService.w(Function1.this, obj);
                return w7;
            }
        }).z(AndroidSchedulers.a());
        final DynamicPollingService$start$2 dynamicPollingService$start$2 = new DynamicPollingService$start$2(this);
        Flowable E = z7.E(new Function() { // from class: ee.mtakso.driver.service.pollerv2.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher x7;
                x7 = DynamicPollingService.x(Function1.this, obj);
                return x7;
            }
        });
        final DynamicPollingService$start$3 dynamicPollingService$start$3 = new DynamicPollingService$start$3(this);
        Flowable U = E.U(new Function() { // from class: ee.mtakso.driver.service.pollerv2.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher y7;
                y7 = DynamicPollingService.y(Function1.this, obj);
                return y7;
            }
        });
        final Function1<PollingSigned<PollingResult>, Unit> function12 = new Function1<PollingSigned<PollingResult>, Unit>() { // from class: ee.mtakso.driver.service.pollerv2.DynamicPollingService$start$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PollingSigned<PollingResult> pollingSigned) {
                Subject subject;
                DynamicPollingService.this.B(pollingSigned.a().g());
                subject = DynamicPollingService.this.f25517d;
                subject.onNext(Notification.c(pollingSigned));
                int b8 = pollingSigned.b();
                Kalev.b("Dynamic poller service fingerprint " + b8);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PollingSigned<PollingResult> pollingSigned) {
                b(pollingSigned);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.pollerv2.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DynamicPollingService.z(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.pollerv2.DynamicPollingService$start$5
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
                subject = DynamicPollingService.this.f25517d;
                subject.onNext(Notification.b(it));
                Intrinsics.e(it, "it");
                Kalev.e(it, "Exception in Dynamic poller service!");
            }
        };
        this.f25519f = U.V(consumer, new Consumer() { // from class: ee.mtakso.driver.service.pollerv2.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DynamicPollingService.A(Function1.this, obj);
            }
        });
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        this.f25514a.f();
        Disposable disposable = this.f25519f;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }

    @Override // ee.mtakso.driver.service.pollerv2.PollerSource
    /* renamed from: t */
    public Subject<Notification<PollingSigned<PollingResult>>> f() {
        return this.f25517d;
    }
}
