package ee.mtakso.driver.service.driver;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.param.TargetingUpdateManager;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import ee.mtakso.driver.service.time.AnchoredTrueTimeProvider;
import ee.mtakso.driver.utils.CompletableExtKt;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DriverManager {

    /* renamed from: a */
    private final DriverStatusSender f24308a;

    /* renamed from: b */
    private final TargetingUpdateManager f24309b;

    /* renamed from: c */
    private final AnchoredTrueTimeProvider f24310c;

    /* renamed from: d */
    private final Lazy f24311d;

    /* renamed from: e */
    private final Lazy f24312e;

    /* renamed from: f */
    private Disposable f24313f;

    /* renamed from: g */
    private Disposable f24314g;

    @Inject
    public DriverManager(DriverStatusSender driverStatusSender, final DriverProvider driverProvider, TargetingUpdateManager targetingUpdateManager, AnchoredTrueTimeProvider timeProvider) {
        Lazy b8;
        Lazy b9;
        Intrinsics.f(driverStatusSender, "driverStatusSender");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(targetingUpdateManager, "targetingUpdateManager");
        Intrinsics.f(timeProvider, "timeProvider");
        this.f24308a = driverStatusSender;
        this.f24309b = targetingUpdateManager;
        this.f24310c = timeProvider;
        b8 = LazyKt__LazyJVMKt.b(new Function0<DriverSettings>() { // from class: ee.mtakso.driver.service.driver.DriverManager$settings$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DriverSettings invoke() {
                return DriverProvider.this.t();
            }
        });
        this.f24311d = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<DriverConfig>() { // from class: ee.mtakso.driver.service.driver.DriverManager$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DriverConfig invoke() {
                return DriverProvider.this.m();
            }
        });
        this.f24312e = b9;
    }

    private final DriverConfig h() {
        return (DriverConfig) this.f24312e.getValue();
    }

    private final DriverSettings i() {
        return (DriverSettings) this.f24311d.getValue();
    }

    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void o(DriverManager driverManager, OrderHandle orderHandle, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            orderHandle = null;
        }
        driverManager.n(orderHandle);
    }

    public static final void p(DriverManager this$0, OrderHandle orderHandle) {
        Intrinsics.f(this$0, "this$0");
        this$0.w(orderHandle);
    }

    public static final void q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void w(OrderHandle orderHandle) {
        this.f24308a.j(null, orderHandle);
    }

    public final void g() {
        this.f24308a.f();
        this.f24308a.a();
    }

    public final void j() {
        this.f24308a.e();
        long a8 = i().i().a();
        if (a8 < 0) {
            a8 = this.f24310c.a();
            i().i().c(a8);
        }
        long o8 = (a8 + h().o()) - this.f24310c.a();
        if (o8 <= 0) {
            m();
        } else if (!DisposableExtKt.b(this.f24313f)) {
            Single<Long> O = Single.O(o8, TimeUnit.SECONDS);
            Intrinsics.e(O, "timer(timeout, TimeUnit.SECONDS)");
            Single d8 = SingleExtKt.d(O);
            final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.service.driver.DriverManager$goInactive$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(Long l8) {
                    DriverStatusSender driverStatusSender;
                    driverStatusSender = DriverManager.this.f24308a;
                    if (driverStatusSender.n() == DriverStatus.INACTIVE) {
                        DriverManager.this.m();
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                    b(l8);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.driver.c
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    DriverManager.k(Function1.this, obj);
                }
            };
            final DriverManager$goInactive$2 driverManager$goInactive$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.driver.DriverManager$goInactive$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.e(it, "it");
                    Kalev.e(it, "Failed to go offline by timer");
                }
            };
            this.f24313f = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.driver.d
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    DriverManager.l(Function1.this, obj);
                }
            });
        }
    }

    public final void m() {
        Disposable disposable = this.f24313f;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        this.f24313f = null;
        i().i().c(-1L);
    }

    public final void n(final OrderHandle orderHandle) {
        this.f24308a.c();
        Completable a8 = CompletableExtKt.a(this.f24309b.d());
        Action action = new Action() { // from class: ee.mtakso.driver.service.driver.a
            @Override // io.reactivex.functions.Action
            public final void run() {
                DriverManager.p(DriverManager.this, orderHandle);
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.driver.DriverManager$goOnline$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                DriverManager.this.w(orderHandle);
                Intrinsics.e(it, "it");
                Kalev.e(it, "Error updating configs");
            }
        };
        this.f24314g = a8.G(action, new Consumer() { // from class: ee.mtakso.driver.service.driver.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverManager.q(Function1.this, obj);
            }
        });
    }

    public final boolean r() {
        return DriverStatusKt.a(this.f24308a.n());
    }

    public final boolean s() {
        return DriverStatusKt.b(this.f24308a.n());
    }

    public final Observable<Throwable> t() {
        return this.f24308a.b();
    }

    public final void u(DriverStatus status) {
        Intrinsics.f(status, "status");
        this.f24308a.i(status);
    }

    public final void v(DriverStatus status) {
        Intrinsics.f(status, "status");
        if (status != DriverStatus.UNDEFINED && status != DriverStatus.INACTIVE) {
            Disposable disposable = this.f24313f;
            if (disposable != null) {
                DisposableExtKt.a(disposable);
            }
            this.f24313f = null;
            i().i().c(-1L);
        }
    }
}
