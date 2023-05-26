package ee.mtakso.driver.service.modules.fifo;

import ee.mtakso.driver.network.client.order.FifoQueueStateForDriverResponse;
import ee.mtakso.driver.network.client.order.FifoQueueStateResponse;
import ee.mtakso.driver.network.client.order.OrderClient;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.modules.fifo.FifoQueueDetails;
import ee.mtakso.driver.service.modules.fifo.FifoQueueState;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueueManager.kt */
/* loaded from: classes3.dex */
public final class FifoQueueManager {

    /* renamed from: a  reason: collision with root package name */
    private final DriverFeatures f24731a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderClient f24732b;

    /* renamed from: c  reason: collision with root package name */
    private final BehaviorSubject<FifoQueueState> f24733c;

    /* renamed from: d  reason: collision with root package name */
    private final Observable<FifoQueueDetails> f24734d;

    /* renamed from: e  reason: collision with root package name */
    private FifoQueuePollingState f24735e;

    /* renamed from: f  reason: collision with root package name */
    private FifoQueueDetails f24736f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f24737g;

    @Inject
    public FifoQueueManager(DriverFeatures driverFeatures, OrderClient orderClient) {
        Intrinsics.f(driverFeatures, "driverFeatures");
        Intrinsics.f(orderClient, "orderClient");
        this.f24731a = driverFeatures;
        this.f24732b = orderClient;
        BehaviorSubject<FifoQueueState> f8 = BehaviorSubject.f(FifoQueueState.None.f24759a);
        Intrinsics.e(f8, "createDefault<FifoQueueState>(FifoQueueState.None)");
        this.f24733c = f8;
        final Function1<FifoQueueState, ObservableSource<? extends FifoQueueDetails>> function1 = new Function1<FifoQueueState, ObservableSource<? extends FifoQueueDetails>>() { // from class: ee.mtakso.driver.service.modules.fifo.FifoQueueManager$detailsObservable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends FifoQueueDetails> invoke(FifoQueueState state) {
                Observable s7;
                Intrinsics.f(state, "state");
                s7 = FifoQueueManager.this.s(state);
                return s7;
            }
        };
        Observable<FifoQueueDetails> e8 = f8.switchMap(new Function() { // from class: ee.mtakso.driver.service.modules.fifo.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource n8;
                n8 = FifoQueueManager.n(Function1.this, obj);
                return n8;
            }
        }).distinctUntilChanged().replay(1).e();
        Intrinsics.e(e8, "stateSubject\n        .sw…ay(1)\n        .refCount()");
        this.f24734d = e8;
    }

    private final void l() {
        String str;
        String str2;
        FifoQueueState fifoQueueState;
        FifoQueueState proximity;
        FifoQueuePollingState fifoQueuePollingState = this.f24735e;
        if (!this.f24731a.y()) {
            fifoQueueState = FifoQueueState.None.f24759a;
        } else {
            String str3 = null;
            if (fifoQueuePollingState != null) {
                str = fifoQueuePollingState.b();
            } else {
                str = null;
            }
            if (str != null) {
                this.f24737g = false;
                proximity = new FifoQueueState.InQueue(fifoQueuePollingState.b());
            } else {
                if (fifoQueuePollingState != null) {
                    str2 = fifoQueuePollingState.a();
                } else {
                    str2 = null;
                }
                if (str2 != null && this.f24737g) {
                    fifoQueueState = FifoQueueState.Closed.f24757a;
                } else {
                    if (fifoQueuePollingState != null) {
                        str3 = fifoQueuePollingState.a();
                    }
                    if (str3 != null) {
                        this.f24737g = false;
                        proximity = new FifoQueueState.Proximity(fifoQueuePollingState.a());
                    } else {
                        this.f24737g = false;
                        fifoQueueState = FifoQueueState.None.f24759a;
                    }
                }
            }
            fifoQueueState = proximity;
        }
        this.f24733c.onNext(fifoQueueState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<? extends FifoQueueDetails> s(FifoQueueState fifoQueueState) {
        Observable just;
        if (fifoQueueState instanceof FifoQueueState.InQueue) {
            Single<FifoQueueStateForDriverResponse> x7 = this.f24732b.x();
            final FifoQueueManager$requestFifoQueueDetails$1 fifoQueueManager$requestFifoQueueDetails$1 = new Function1<FifoQueueStateForDriverResponse, FifoQueueDetails>() { // from class: ee.mtakso.driver.service.modules.fifo.FifoQueueManager$requestFifoQueueDetails$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final FifoQueueDetails invoke(FifoQueueStateForDriverResponse it) {
                    Intrinsics.f(it, "it");
                    return new FifoQueueDetails.InQueue(it);
                }
            };
            Single C = x7.x(new Function() { // from class: ee.mtakso.driver.service.modules.fifo.b
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    FifoQueueDetails t7;
                    t7 = FifoQueueManager.t(Function1.this, obj);
                    return t7;
                }
            }).C(new Function() { // from class: ee.mtakso.driver.service.modules.fifo.c
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    FifoQueueDetails u7;
                    u7 = FifoQueueManager.u((Throwable) obj);
                    return u7;
                }
            });
            Intrinsics.e(C, "orderClient\n            …QueueDetails.Failed(it) }");
            Observable R = SingleExtKt.d(C).R();
            final Function1<Observable<FifoQueueDetails>, ObservableSource<FifoQueueDetails>> function1 = new Function1<Observable<FifoQueueDetails>, ObservableSource<FifoQueueDetails>>() { // from class: ee.mtakso.driver.service.modules.fifo.FifoQueueManager$requestFifoQueueDetails$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final ObservableSource<FifoQueueDetails> invoke(Observable<FifoQueueDetails> source) {
                    FifoQueueDetails fifoQueueDetails;
                    FifoQueueDetails fifoQueueDetails2;
                    Intrinsics.f(source, "source");
                    fifoQueueDetails = FifoQueueManager.this.f24736f;
                    if (fifoQueueDetails != null) {
                        fifoQueueDetails2 = FifoQueueManager.this.f24736f;
                        if (fifoQueueDetails2 instanceof FifoQueueDetails.InQueue) {
                            return source;
                        }
                    }
                    return source.startWith((Observable<FifoQueueDetails>) FifoQueueDetails.LoadingInQueue.f24727a);
                }
            };
            just = R.compose(new ObservableTransformer() { // from class: ee.mtakso.driver.service.modules.fifo.d
                @Override // io.reactivex.ObservableTransformer
                public final ObservableSource a(Observable observable) {
                    ObservableSource v7;
                    v7 = FifoQueueManager.v(Function1.this, observable);
                    return v7;
                }
            });
        } else if (fifoQueueState instanceof FifoQueueState.Proximity) {
            Single<FifoQueueStateResponse> v7 = this.f24732b.v();
            final FifoQueueManager$requestFifoQueueDetails$4 fifoQueueManager$requestFifoQueueDetails$4 = new Function1<FifoQueueStateResponse, FifoQueueDetails>() { // from class: ee.mtakso.driver.service.modules.fifo.FifoQueueManager$requestFifoQueueDetails$4
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final FifoQueueDetails invoke(FifoQueueStateResponse it) {
                    Intrinsics.f(it, "it");
                    return new FifoQueueDetails.Proximity(it);
                }
            };
            Single C2 = v7.x(new Function() { // from class: ee.mtakso.driver.service.modules.fifo.e
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    FifoQueueDetails w7;
                    w7 = FifoQueueManager.w(Function1.this, obj);
                    return w7;
                }
            }).C(new Function() { // from class: ee.mtakso.driver.service.modules.fifo.f
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    FifoQueueDetails x8;
                    x8 = FifoQueueManager.x((Throwable) obj);
                    return x8;
                }
            });
            Intrinsics.e(C2, "orderClient\n            …QueueDetails.Failed(it) }");
            Observable R2 = SingleExtKt.d(C2).R();
            final Function1<Observable<FifoQueueDetails>, ObservableSource<FifoQueueDetails>> function12 = new Function1<Observable<FifoQueueDetails>, ObservableSource<FifoQueueDetails>>() { // from class: ee.mtakso.driver.service.modules.fifo.FifoQueueManager$requestFifoQueueDetails$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final ObservableSource<FifoQueueDetails> invoke(Observable<FifoQueueDetails> source) {
                    FifoQueueDetails fifoQueueDetails;
                    FifoQueueDetails fifoQueueDetails2;
                    Intrinsics.f(source, "source");
                    fifoQueueDetails = FifoQueueManager.this.f24736f;
                    if (fifoQueueDetails != null) {
                        fifoQueueDetails2 = FifoQueueManager.this.f24736f;
                        if (fifoQueueDetails2 instanceof FifoQueueDetails.Proximity) {
                            return source;
                        }
                    }
                    return source.startWith((Observable<FifoQueueDetails>) FifoQueueDetails.LoadingProximity.f24728a);
                }
            };
            just = R2.compose(new ObservableTransformer() { // from class: ee.mtakso.driver.service.modules.fifo.g
                @Override // io.reactivex.ObservableTransformer
                public final ObservableSource a(Observable observable) {
                    ObservableSource y7;
                    y7 = FifoQueueManager.y(Function1.this, observable);
                    return y7;
                }
            });
        } else {
            just = Observable.just(FifoQueueDetails.None.f24729a);
        }
        final Function1<FifoQueueDetails, Unit> function13 = new Function1<FifoQueueDetails, Unit>() { // from class: ee.mtakso.driver.service.modules.fifo.FifoQueueManager$requestFifoQueueDetails$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(FifoQueueDetails fifoQueueDetails) {
                FifoQueueManager.this.f24736f = fifoQueueDetails;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FifoQueueDetails fifoQueueDetails) {
                b(fifoQueueDetails);
                return Unit.f50853a;
            }
        };
        Observable<? extends FifoQueueDetails> doOnNext = just.doOnNext(new Consumer() { // from class: ee.mtakso.driver.service.modules.fifo.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FifoQueueManager.z(Function1.this, obj);
            }
        });
        Intrinsics.e(doOnNext, "private fun requestFifoQ…xt { details = it }\n    }");
        return doOnNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FifoQueueDetails t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (FifoQueueDetails) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FifoQueueDetails u(Throwable it) {
        Intrinsics.f(it, "it");
        return new FifoQueueDetails.Failed(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource v(Function1 tmp0, Observable p02) {
        Intrinsics.f(tmp0, "$tmp0");
        Intrinsics.f(p02, "p0");
        return (ObservableSource) tmp0.invoke(p02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FifoQueueDetails w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (FifoQueueDetails) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FifoQueueDetails x(Throwable it) {
        Intrinsics.f(it, "it");
        return new FifoQueueDetails.Failed(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource y(Function1 tmp0, Observable p02) {
        Intrinsics.f(tmp0, "$tmp0");
        Intrinsics.f(p02, "p0");
        return (ObservableSource) tmp0.invoke(p02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void A(FifoQueuePollingState pollingState) {
        String str;
        Intrinsics.f(pollingState, "pollingState");
        FifoQueuePollingState fifoQueuePollingState = this.f24735e;
        this.f24735e = pollingState;
        if (fifoQueuePollingState != null) {
            str = fifoQueuePollingState.a();
        } else {
            str = null;
        }
        if (str == null && pollingState.a() != null) {
            this.f24737g = false;
        }
        l();
    }

    public final void m() {
        this.f24737g = true;
        l();
    }

    public final void o() {
        l();
    }

    public final Observable<FifoQueueDetails> p() {
        return this.f24734d;
    }

    public final Observable<FifoQueueState> q() {
        Observable<FifoQueueState> distinctUntilChanged = this.f24733c.distinctUntilChanged();
        Intrinsics.e(distinctUntilChanged, "stateSubject.distinctUntilChanged()");
        return distinctUntilChanged;
    }

    public final void r() {
        this.f24737g = false;
        l();
    }
}
