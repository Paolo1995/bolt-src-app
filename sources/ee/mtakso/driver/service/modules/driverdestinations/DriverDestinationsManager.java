package ee.mtakso.driver.service.modules.driverdestinations;

import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.fleet.FleetClient;
import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.network.client.settings.DriverDestinationId;
import ee.mtakso.driver.network.client.settings.DriverDestinations;
import ee.mtakso.driver.network.client.settings.SettingsClient;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.modules.status.DriverStatusSender;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverDestinationsManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DriverDestinationsManager {

    /* renamed from: a  reason: collision with root package name */
    private final FleetClient f24609a;

    /* renamed from: b  reason: collision with root package name */
    private final SettingsClient f24610b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverProvider f24611c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverStatusProvider f24612d;

    /* renamed from: e  reason: collision with root package name */
    private final DriverStatusSender f24613e;

    /* renamed from: f  reason: collision with root package name */
    private Long f24614f;

    /* renamed from: g  reason: collision with root package name */
    private List<DriverDestination> f24615g;

    /* renamed from: h  reason: collision with root package name */
    private BehaviorSubject<Optional<DriverDestination>> f24616h;

    /* renamed from: i  reason: collision with root package name */
    private BehaviorSubject<DestinationLimit> f24617i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f24618j;

    @Inject
    public DriverDestinationsManager(FleetClient fleetClient, SettingsClient settingsClient, DriverProvider driverProvider, DriverStatusProvider statusProvider, DriverStatusSender statusSender) {
        Intrinsics.f(fleetClient, "fleetClient");
        Intrinsics.f(settingsClient, "settingsClient");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(statusProvider, "statusProvider");
        Intrinsics.f(statusSender, "statusSender");
        this.f24609a = fleetClient;
        this.f24610b = settingsClient;
        this.f24611c = driverProvider;
        this.f24612d = statusProvider;
        this.f24613e = statusSender;
        this.f24615g = Collections.synchronizedList(new ArrayList());
        BehaviorSubject<Optional<DriverDestination>> f8 = BehaviorSubject.f(Optional.a());
        Intrinsics.e(f8, "createDefault<Optional<D…ation>>(Optional.empty())");
        this.f24616h = f8;
        BehaviorSubject<DestinationLimit> f9 = BehaviorSubject.f(new DestinationLimit(0, 0));
        Intrinsics.e(f9, "createDefault(DestinationLimit(0, 0))");
        this.f24617i = f9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void H(final long j8) {
        if (DisposableExtKt.b(this.f24618j)) {
            Single<DriverDestinations> B = B();
            final DriverDestinationsManager$onNewDriverDestination$1 driverDestinationsManager$onNewDriverDestination$1 = new Function1<DriverDestinations, ObservableSource<? extends DriverDestination>>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$onNewDriverDestination$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final ObservableSource<? extends DriverDestination> invoke(DriverDestinations it) {
                    Intrinsics.f(it, "it");
                    return Observable.fromIterable(it.a());
                }
            };
            Observable<R> t7 = B.t(new Function() { // from class: ee.mtakso.driver.service.modules.driverdestinations.n
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource M;
                    M = DriverDestinationsManager.M(Function1.this, obj);
                    return M;
                }
            });
            final Function1<DriverDestination, Boolean> function1 = new Function1<DriverDestination, Boolean>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$onNewDriverDestination$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Boolean invoke(DriverDestination it) {
                    boolean z7;
                    Intrinsics.f(it, "it");
                    if (it.b() == j8) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    return Boolean.valueOf(z7);
                }
            };
            Single firstOrError = t7.filter(new Predicate() { // from class: ee.mtakso.driver.service.modules.driverdestinations.b
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean I;
                    I = DriverDestinationsManager.I(Function1.this, obj);
                    return I;
                }
            }).firstOrError();
            Intrinsics.e(firstOrError, "destinationId: Long) {\n …          .firstOrError()");
            Single d8 = SingleExtKt.d(firstOrError);
            final Function1<DriverDestination, Unit> function12 = new Function1<DriverDestination, Unit>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$onNewDriverDestination$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(DriverDestination driverDestination) {
                    DriverDestinationsManager.this.f24614f = Long.valueOf(j8);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DriverDestination driverDestination) {
                    b(driverDestination);
                    return Unit.f50853a;
                }
            };
            Single o8 = d8.o(new Consumer() { // from class: ee.mtakso.driver.service.modules.driverdestinations.c
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    DriverDestinationsManager.J(Function1.this, obj);
                }
            });
            final Function1<DriverDestination, Unit> function13 = new Function1<DriverDestination, Unit>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$onNewDriverDestination$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(DriverDestination driverDestination) {
                    BehaviorSubject behaviorSubject;
                    behaviorSubject = DriverDestinationsManager.this.f24616h;
                    behaviorSubject.onNext(Optional.f(driverDestination));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DriverDestination driverDestination) {
                    b(driverDestination);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.driverdestinations.d
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    DriverDestinationsManager.K(Function1.this, obj);
                }
            };
            final DriverDestinationsManager$onNewDriverDestination$5 driverDestinationsManager$onNewDriverDestination$5 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$onNewDriverDestination$5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable throwable) {
                    Intrinsics.e(throwable, "throwable");
                    Kalev.e(throwable, "Failed to fetch all driver destinations!");
                }
            };
            this.f24618j = o8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.driverdestinations.e
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    DriverDestinationsManager.L(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(DriverDestination driverDestination) {
        List<DriverDestination> cachedDestinations = this.f24615g;
        Intrinsics.e(cachedDestinations, "cachedDestinations");
        Iterator<DriverDestination> it = cachedDestinations.iterator();
        int i8 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.a(it.next().f(), driverDestination.f())) {
                    break;
                }
                i8++;
            } else {
                i8 = -1;
                break;
            }
        }
        if (i8 != -1) {
            this.f24615g.set(i8, driverDestination);
        } else {
            this.f24615g.add(driverDestination);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean R(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource T(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverDestination U(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverDestination) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final Completable A(long j8) {
        Completable v7 = this.f24610b.k(j8).v();
        Intrinsics.e(v7, "settingsClient.deleteDri…nationId).ignoreElement()");
        return v7;
    }

    public final Single<DriverDestinations> B() {
        Single<DriverDestinations> m8 = this.f24610b.m();
        final Function1<DriverDestinations, Unit> function1 = new Function1<DriverDestinations, Unit>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$fetchAllDestinations$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverDestinations driverDestinations) {
                List list;
                List list2;
                BehaviorSubject behaviorSubject;
                list = DriverDestinationsManager.this.f24615g;
                list.clear();
                list2 = DriverDestinationsManager.this.f24615g;
                List<DriverDestination> a8 = driverDestinations.a();
                if (a8 == null) {
                    a8 = CollectionsKt__CollectionsKt.k();
                }
                list2.addAll(a8);
                behaviorSubject = DriverDestinationsManager.this.f24617i;
                behaviorSubject.onNext(new DestinationLimit(driverDestinations.c(), driverDestinations.b()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverDestinations driverDestinations) {
                b(driverDestinations);
                return Unit.f50853a;
            }
        };
        Single<DriverDestinations> o8 = m8.o(new Consumer() { // from class: ee.mtakso.driver.service.modules.driverdestinations.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverDestinationsManager.C(Function1.this, obj);
            }
        });
        Intrinsics.e(o8, "fun fetchAllDestinations…Max))\n            }\n    }");
        return o8;
    }

    public final DriverDestination D() {
        Optional<DriverDestination> g8 = this.f24616h.g();
        if (g8 != null) {
            return g8.c();
        }
        return null;
    }

    public final boolean E() {
        if (this.f24614f != null) {
            return true;
        }
        return false;
    }

    public final Observable<Optional<DriverDestination>> F() {
        return this.f24616h;
    }

    public final Observable<DestinationLimit> G() {
        return this.f24617i;
    }

    public final void N(Long l8) {
        if (Intrinsics.a(this.f24614f, l8)) {
            return;
        }
        if (l8 == null) {
            this.f24616h.onNext(Optional.a());
            this.f24614f = l8;
            return;
        }
        H(l8.longValue());
    }

    public final Single<DriverDestination> P(final String type, final String str, final String address, final double d8, final double d9) {
        Intrinsics.f(type, "type");
        Intrinsics.f(address, "address");
        Single<DriverDestinations> B = B();
        final DriverDestinationsManager$updateDriverDestination$1 driverDestinationsManager$updateDriverDestination$1 = new Function1<DriverDestinations, ObservableSource<? extends DriverDestination>>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$updateDriverDestination$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends DriverDestination> invoke(DriverDestinations it) {
                Intrinsics.f(it, "it");
                return Observable.fromIterable(it.a());
            }
        };
        Observable<R> t7 = B.t(new Function() { // from class: ee.mtakso.driver.service.modules.driverdestinations.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource Q;
                Q = DriverDestinationsManager.Q(Function1.this, obj);
                return Q;
            }
        });
        final Function1<DriverDestination, Boolean> function1 = new Function1<DriverDestination, Boolean>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$updateDriverDestination$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(DriverDestination it) {
                Intrinsics.f(it, "it");
                return Boolean.valueOf(Intrinsics.a(it.f(), type));
            }
        };
        Single singleOrError = t7.filter(new Predicate() { // from class: ee.mtakso.driver.service.modules.driverdestinations.f
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean R;
                R = DriverDestinationsManager.R(Function1.this, obj);
                return R;
            }
        }).singleOrError();
        final Function1<DriverDestination, SingleSource<? extends DriverDestinationId>> function12 = new Function1<DriverDestination, SingleSource<? extends DriverDestinationId>>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$updateDriverDestination$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends DriverDestinationId> invoke(DriverDestination it) {
                SettingsClient settingsClient;
                Intrinsics.f(it, "it");
                settingsClient = DriverDestinationsManager.this.f24610b;
                return settingsClient.s(it.b(), type, str, address, d8, d9);
            }
        };
        Single r7 = singleOrError.r(new Function() { // from class: ee.mtakso.driver.service.modules.driverdestinations.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource S;
                S = DriverDestinationsManager.S(Function1.this, obj);
                return S;
            }
        });
        final Function1<Throwable, SingleSource<? extends DriverDestinationId>> function13 = new Function1<Throwable, SingleSource<? extends DriverDestinationId>>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$updateDriverDestination$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends DriverDestinationId> invoke(Throwable it) {
                SettingsClient settingsClient;
                Intrinsics.f(it, "it");
                settingsClient = DriverDestinationsManager.this.f24610b;
                return settingsClient.i(type, str, address, d8, d9);
            }
        };
        Single B2 = r7.B(new Function() { // from class: ee.mtakso.driver.service.modules.driverdestinations.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource T;
                T = DriverDestinationsManager.T(Function1.this, obj);
                return T;
            }
        });
        final Function1<DriverDestinationId, DriverDestination> function14 = new Function1<DriverDestinationId, DriverDestination>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$updateDriverDestination$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final DriverDestination invoke(DriverDestinationId it) {
                Intrinsics.f(it, "it");
                return new DriverDestination(it.a(), type, str, address, Double.valueOf(d8), Double.valueOf(d9), "visible");
            }
        };
        Single x7 = B2.x(new Function() { // from class: ee.mtakso.driver.service.modules.driverdestinations.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DriverDestination U;
                U = DriverDestinationsManager.U(Function1.this, obj);
                return U;
            }
        });
        final Function1<DriverDestination, Unit> function15 = new Function1<DriverDestination, Unit>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$updateDriverDestination$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverDestination it) {
                DriverDestinationsManager driverDestinationsManager = DriverDestinationsManager.this;
                Intrinsics.e(it, "it");
                driverDestinationsManager.O(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverDestination driverDestination) {
                b(driverDestination);
                return Unit.f50853a;
            }
        };
        Single o8 = x7.o(new Consumer() { // from class: ee.mtakso.driver.service.modules.driverdestinations.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverDestinationsManager.V(Function1.this, obj);
            }
        });
        final Function1<DriverDestination, Unit> function16 = new Function1<DriverDestination, Unit>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$updateDriverDestination$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverDestination driverDestination) {
                DriverProvider driverProvider;
                driverProvider = DriverDestinationsManager.this.f24611c;
                driverProvider.t().m().b(true);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverDestination driverDestination) {
                b(driverDestination);
                return Unit.f50853a;
            }
        };
        Single<DriverDestination> o9 = o8.o(new Consumer() { // from class: ee.mtakso.driver.service.modules.driverdestinations.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverDestinationsManager.W(Function1.this, obj);
            }
        });
        Intrinsics.e(o9, "fun updateDriverDestinat…Used.value = true }\n    }");
        return o9;
    }

    public final Completable x(DriverDestination destination) {
        Intrinsics.f(destination, "destination");
        DestinationLimit g8 = this.f24617i.g();
        if (g8 != null && this.f24612d.n() == DriverStatus.INACTIVE && g8.a() > g8.b()) {
            this.f24613e.j(Long.valueOf(destination.b()), null);
        }
        Completable v7 = this.f24609a.b(destination.b()).v();
        Intrinsics.e(v7, "fleetClient.setActiveDri…ation.id).ignoreElement()");
        return v7;
    }

    public final Single<EmptyServerResponse> y() {
        Single<EmptyServerResponse> a8 = this.f24609a.a();
        final Function1<EmptyServerResponse, Unit> function1 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager$deactivateDriverDestination$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                DriverStatusProvider driverStatusProvider;
                DriverStatusSender driverStatusSender;
                driverStatusProvider = DriverDestinationsManager.this.f24612d;
                if (driverStatusProvider.n() == DriverStatus.WAITING_ORDER) {
                    driverStatusSender = DriverDestinationsManager.this.f24613e;
                    driverStatusSender.e();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Single<EmptyServerResponse> o8 = a8.o(new Consumer() { // from class: ee.mtakso.driver.service.modules.driverdestinations.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverDestinationsManager.z(Function1.this, obj);
            }
        });
        Intrinsics.e(o8, "fun deactivateDriverDest…        }\n        }\n    }");
        return o8;
    }
}
