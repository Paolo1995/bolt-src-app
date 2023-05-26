package ee.mtakso.driver.service.settings;

import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DispatchSettingsService.kt */
/* loaded from: classes3.dex */
public final class DispatchSettingsService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final DriverStatusProvider f25971b;

    /* renamed from: c  reason: collision with root package name */
    private final PollerSource f25972c;

    /* renamed from: d  reason: collision with root package name */
    private final DispatchSettingsManager f25973d;

    @Inject
    public DispatchSettingsService(DriverStatusProvider driverStatusProvider, PollerSource poller, DispatchSettingsManager dispatchSettingsManager) {
        Intrinsics.f(driverStatusProvider, "driverStatusProvider");
        Intrinsics.f(poller, "poller");
        Intrinsics.f(dispatchSettingsManager, "dispatchSettingsManager");
        this.f25971b = driverStatusProvider;
        this.f25972c = poller;
        this.f25973d = dispatchSettingsManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A(DriverStatus driverStatus) {
        if (driverStatus != DriverStatus.PENDING && driverStatus != DriverStatus.UNDEFINED && driverStatus != DriverStatus.UNKNOWN) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(String str) {
        this.f25973d.B(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(boolean z7) {
        this.f25973d.n(z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Boolean) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.s(obj, obj2)).booleanValue();
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

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<DriverStatus> g8 = this.f25971b.g();
        final Function1<DriverStatus, Boolean> function1 = new Function1<DriverStatus, Boolean>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsService$doStart$driverStatusDisposable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(DriverStatus it) {
                boolean A;
                Intrinsics.f(it, "it");
                A = DispatchSettingsService.this.A(it);
                return Boolean.valueOf(A);
            }
        };
        Observable<DriverStatus> filter = g8.filter(new Predicate() { // from class: ee.mtakso.driver.service.settings.m
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean r7;
                r7 = DispatchSettingsService.r(Function1.this, obj);
                return r7;
            }
        });
        final DispatchSettingsService$doStart$driverStatusDisposable$2 dispatchSettingsService$doStart$driverStatusDisposable$2 = new Function1<DriverStatus, Boolean>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsService$doStart$driverStatusDisposable$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(DriverStatus it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(DriverStatusKt.b(it));
            }
        };
        Observable distinctUntilChanged = filter.map(new Function() { // from class: ee.mtakso.driver.service.settings.n
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean s7;
                s7 = DispatchSettingsService.s(Function1.this, obj);
                return s7;
            }
        }).distinctUntilChanged();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsService$doStart$driverStatusDisposable$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean it) {
                DispatchSettingsService dispatchSettingsService = DispatchSettingsService.this;
                Intrinsics.e(it, "it");
                dispatchSettingsService.C(it.booleanValue());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.settings.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DispatchSettingsService.t(Function1.this, obj);
            }
        };
        final DispatchSettingsService$doStart$driverStatusDisposable$4 dispatchSettingsService$doStart$driverStatusDisposable$4 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsService$doStart$driverStatusDisposable$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to observer driver status!");
            }
        };
        Disposable subscribe = distinctUntilChanged.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.settings.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DispatchSettingsService.u(Function1.this, obj);
            }
        });
        Observable<PollingSigned<PollingResult>> e8 = this.f25972c.e();
        final DispatchSettingsService$doStart$categoriesHashDisposable$1 dispatchSettingsService$doStart$categoriesHashDisposable$1 = new Function1<PollingSigned<PollingResult>, Optional<String>>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsService$doStart$categoriesHashDisposable$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<String> invoke(PollingSigned<PollingResult> it) {
                Intrinsics.f(it, "it");
                return Optional.f(it.a().a());
            }
        };
        Observable<R> map = e8.map(new Function() { // from class: ee.mtakso.driver.service.settings.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional v7;
                v7 = DispatchSettingsService.v(Function1.this, obj);
                return v7;
            }
        });
        final DispatchSettingsService$doStart$categoriesHashDisposable$2 dispatchSettingsService$doStart$categoriesHashDisposable$2 = new Function1<Optional<String>, Boolean>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsService$doStart$categoriesHashDisposable$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Optional<String> it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(!it.d());
            }
        };
        Observable filter2 = map.filter(new Predicate() { // from class: ee.mtakso.driver.service.settings.r
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean w7;
                w7 = DispatchSettingsService.w(Function1.this, obj);
                return w7;
            }
        });
        final DispatchSettingsService$doStart$categoriesHashDisposable$3 dispatchSettingsService$doStart$categoriesHashDisposable$3 = new Function2<Optional<String>, Optional<String>, Boolean>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsService$doStart$categoriesHashDisposable$3
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final Boolean s(Optional<String> oldHash, Optional<String> newHash) {
                Intrinsics.f(oldHash, "oldHash");
                Intrinsics.f(newHash, "newHash");
                return Boolean.valueOf(Intrinsics.a(oldHash.c(), newHash.c()));
            }
        };
        Observable distinctUntilChanged2 = filter2.distinctUntilChanged(new BiPredicate() { // from class: ee.mtakso.driver.service.settings.s
            @Override // io.reactivex.functions.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                boolean x7;
                x7 = DispatchSettingsService.x(Function2.this, obj, obj2);
                return x7;
            }
        });
        final Function1<Optional<String>, Unit> function13 = new Function1<Optional<String>, Unit>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsService$doStart$categoriesHashDisposable$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<String> optional) {
                DispatchSettingsService dispatchSettingsService = DispatchSettingsService.this;
                String b8 = optional.b();
                Intrinsics.e(b8, "it.value");
                dispatchSettingsService.B(b8);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<String> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer2 = new Consumer() { // from class: ee.mtakso.driver.service.settings.t
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DispatchSettingsService.y(Function1.this, obj);
            }
        };
        final DispatchSettingsService$doStart$categoriesHashDisposable$5 dispatchSettingsService$doStart$categoriesHashDisposable$5 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsService$doStart$categoriesHashDisposable$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to observe poller result!");
            }
        };
        return new CompositeDisposable(subscribe, distinctUntilChanged2.subscribe(consumer2, new Consumer() { // from class: ee.mtakso.driver.service.settings.u
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DispatchSettingsService.z(Function1.this, obj);
            }
        }));
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl, ee.mtakso.driver.service.BaseService
    public void stop() {
        super.stop();
        this.f25973d.q();
    }
}
